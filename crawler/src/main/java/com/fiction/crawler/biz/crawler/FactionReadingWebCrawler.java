package com.fiction.crawler.biz.crawler;


import com.alibaba.fastjson.JSON;
import com.fiction.crawler.biz.dao.mapper.FictionInfoMapper;
import com.fiction.crawler.biz.dao.sql.FictionContentDao;
import com.fiction.crawler.biz.utils.GeneralConstants;
import com.fiction.crawler.biz.utils.JSoupUtils;
import com.fiction.crawler.domain.dto.FictionContent;
import com.fiction.crawler.domain.dto.FictionInfo;
import com.fiction.crawler.domain.dto.FictionInfoExample;
import com.fiction.crawler.domain.enums.FictionIsOverEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * the introduction of class
 * @date 2019/4/17 20:48:28
 */
@Component("factionReadingWebCrawler")
public class FactionReadingWebCrawler extends HttpAbstractCrawler {

    private static final int MAX_PAGE = 30;

    @Resource
    private FictionInfoMapper fictionInfoMapper;

    @Resource
    private FictionContentDao fictionContentDao;

    @Resource
    private GeneralConstants generalConstants;

    private final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));

    @Override
    void dealCrawler(String url) throws Exception {

        Object clock = generalConstants.mapCache.get("FACTION_READING_WEB");

        if (clock != null && clock.toString().contains(Boolean.TRUE.toString())) {
            if(Long.valueOf(clock.toString().split("-")[1]) + 60*60*1000L > System.currentTimeMillis()){
                throw new Exception("正在抓取小说阅读网,暂不支持多线程抓取！");
            }
        }
        //解析小说信息
        Map<String, FictionInfo> map = analysisFictionInfo(url);
        if (map.isEmpty()) {
            throw new Exception("网站和地址不匹配,无法抓取！");
        }

        removeExist(map);
        if(map.isEmpty()){
            throw new Exception("该页小说已经全部抓过, 换一页吧 !");
        }
        generalConstants.mapCache.put("FACTION_READING_WEB", Boolean.TRUE.toString() + "-" + System.currentTimeMillis());
        analysisFictionContent(map);

    }

    /**
     * 解析小说内容并落库
     *
     * @param map
     */
    private void analysisFictionContent(Map<String, FictionInfo> map) {
        //执行抓取详情 + 落库
        Collection<FictionInfo> values = map.values();
        int size = values.size();
        int flag = 0;
        for (FictionInfo fictionInfo : values) {
            flag ++ ;
            final int FLAG_PARAM =  flag;
            THREAD_POOL_EXECUTOR.execute(() -> {
                try {
                    int insert = fictionInfoMapper.insert(fictionInfo);
                    if (insert == 0) {
                        return;
                    }
                    //fictionInfo 落库 得到id
                    Document document3 = JSoupUtils.get(fictionInfo.getExt());
                    Elements select = document3.select("div.volume-wrap div.volume ul.cf li");
                    List<FictionContent> fictionContentList = Lists.newArrayList();
                    for (int i = 1; i <= select.size(); i++) {
                        Element li = select.get(i - 1);
                        String content = "";
                        String contentUrl = li.select("a").attr("href");
                        if (StringUtils.isNotBlank(contentUrl)) {
                            Document contentDoc;
                            contentDoc = JSoupUtils.get("https:" + contentUrl);
                            content = contentDoc.select("div.main-text-wrap div.read-content.j_readContent p").toString();

                        }
                        FictionContent fictionContent = new FictionContent();
                        fictionContent.setFictionId(fictionInfo.getId());
                        fictionContent.setPage(i);
                        fictionContent.setFictionContent(content);
                        fictionContentList.add(fictionContent);
                        if (fictionContentList.size() >= 10 || i == select.size()) {
                            fictionContentDao.insertList(fictionContentList);
                            fictionContentList.clear();
                        }
                        // 限制下载页数
                        if (i >= MAX_PAGE) {
                            if(FLAG_PARAM >= size){
                                generalConstants.mapCache.remove("FACTION_READING_WEB");
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("抓取小说内容异常: rq->{" + JSON.toJSONString(map) + "}");
                    return;
                }
            });
        }
    }

    /**
     *
     *删除库中已经存在的小说
     * @param map
     */
    private void removeExist(Map<String, FictionInfo> map) {
        List<String> nameList = map.values().stream().map(FictionInfo::getFictionName).collect(Collectors.toList());
        FictionInfoExample fictionInfoExample = new FictionInfoExample();
        fictionInfoExample.createCriteria().andFictionNameIn(nameList);
        List<FictionInfo> fictionInfos = fictionInfoMapper.selectByExample(fictionInfoExample);
        fictionInfos.stream().filter(fictionInfo -> {
            if (nameList.contains(fictionInfo.getFictionName())) {
                return true;
            }
            return false;
        }).forEach(fictionInfo -> {
            map.remove(fictionInfo.getFictionName());
        });
    }

    private Map<String, FictionInfo> analysisFictionInfo(String url) throws FileNotFoundException {
        //缓存
        Map<String, FictionInfo> map = Maps.newHashMap();
        //获取根地址
        String rootUrl = url.split(".com/")[0] + ".com";
        Document document = null;
        try {
            document = JSoupUtils.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (document == null) {
            return map;
        }
        //获取对应节点集合, 组装对象
        Elements lis = document.select("div.right-book-list").select("li");
        for (Element li : lis) {
            String name = li.select("div.book-info h3 a").attr("title");
            String author = li.select("div.book-info h4 a").text();
            String img = li.select("div.book-img img").attr("src");
            if (StringUtils.isBlank(name) || StringUtils.isBlank(author) || StringUtils.isBlank(img)) {
                continue;
            }
            FictionInfo fictionInfo = new FictionInfo();
            fictionInfo.setFictionName(name);
            fictionInfo.setImg(img);
            fictionInfo.setSexType((int) (Math.random() * 2));
            fictionInfo.setFictionAuthor(author);
            String href = li.select("div.book-info h3 a").attr("href");
            String isOver = li.select("div.book-info p.tag span.red").text();
            String fictionSize = li.select("div.book-info p.tag span.blue").text();
            String typeName = li.select("div.book-info p.tag span.org").text();
            fictionInfo.setFictionSize(fictionSize);
            fictionInfo.setExt(rootUrl + href);
            fictionInfo.setClickNum(0);
            fictionInfo.setCollectNum(0);
            fictionInfo.setSubscriptionNum(0);
            fictionInfo.setFictionType((int) (Math.random() * 2) + 1);
            FictionIsOverEnum fictionIsOverEnum = FictionIsOverEnum.typeOf((int) (Math.random() * 2));
            fictionInfo.setIsOver(fictionIsOverEnum == null ? FictionIsOverEnum.LOADING.getDesc() : fictionIsOverEnum.getDesc());
            map.put(name, fictionInfo);
        }
        return map;
    }



}
