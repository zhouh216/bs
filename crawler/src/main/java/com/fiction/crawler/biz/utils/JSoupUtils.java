package com.fiction.crawler.biz.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.KeyVal;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class JSoupUtils {
    private static final Logger log = LoggerFactory.getLogger(JSoupUtils.class);

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
    /**
     * 五分钟超时
     */
    public static final int CONN_TIME_OUT = 1000 * 60 * 5;
    public static final int DEFAULT_TIMEOUT = 6000;

    /**
     * 访问特定连接
     */
    private static Document access(Connection connection, Connection.Method method) throws IOException {
        Document document;
        if (connection == null) {
            log.error("Access failed.\nError:Connection is null");
            return null;
        }

        connection.ignoreContentType(true);
        String url = connection.request().url().toString();
        int idx = url.indexOf("?");
        String mainUlr = url;
        String host = "";
        if (idx > -1) {
            mainUlr = url.substring(0, idx);
        }
        host = mainUlr.substring(mainUlr.indexOf("//") + 2);
        host = host.substring(0, host.indexOf("/"));
        Collection<Connection.KeyVal> dataBak = new ArrayList<KeyVal>();

        //执行完execute，request会丢失。备份原collection的data
        for (Connection.KeyVal kv : connection.request().data()) {
            if (StringUtils.isNotBlank(kv.value())) {
                dataBak.add(HttpConnection.KeyVal.create(kv.key(), kv.value()));
            }
        }
        try {
            long start = System.currentTimeMillis();
            // connection//.timeout(DEFAULT_TIMEOUT)
            Connection.Response response = connection
                .header("trad-client-name",
                    System.getProperty("project.name") == null ? "hdcs" : System.getProperty("project.name"))
                //.header("trad-proxy-socket-timeout",DEFAULT_TIMEOUT+"")
                .header("Cache-Control", "no-cache")
                .method(method)
                .execute();
            document = response.parse();
        } catch (IOException e) {
                        log.error("Access failed.url="+url+",data="+dataBak,e);
            throw new IOException(e);
        }
        return document;
    }

    /**
     * post 请求
     */
    public static Document post(Connection connection) throws IOException {
        return access(connection, Connection.Method.POST);
    }

    /**
     * get请求
     */
    public static Document get(Connection connection) throws IOException {
        return access(connection, Connection.Method.GET);
    }

    /**
     * 得到一个标准的Jsoup Connection
     * 设置了超时时间和user_agent
     */
    public static Connection getConnection(String url) {
        return Jsoup.connect(url).followRedirects(true).timeout(CONN_TIME_OUT).userAgent(USER_AGENT);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @return
     */
    public static Document get(String url) throws Exception {
        Collection<KeyVal> data = Collections.emptyList();
        return get(url, data);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @param data
     * @return
     */
    public static Document get(String url, Collection<KeyVal> data) throws Exception {
        return get(url, data, null, null);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @param refer
     * @return
     */
    public static Document get(String url, String refer, String useProxy) throws Exception {
        return get(url, Collections.EMPTY_LIST, refer, useProxy);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @param refer
     * @return
     */
    public static Document get(String url, String refer) throws Exception {

        return get(url, refer, null);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @param data
     * @return
     */
    public static Document get(String url, Collection<KeyVal> data, String refer, String proxyUrl) throws Exception {
        return get(url, null, data, refer, proxyUrl);
    }

    /**
     * get方式获取响应内容
     *
     * @param url
     * @param data
     * @return
     */
    public static Document get(String url, Map<String, String> cookies, Collection<KeyVal> data, String refer,
                               String proxyUrl) throws Exception {
        long start = System.currentTimeMillis();

        try {
            Connection connection = getConnection(url).data(data);
            if (!CollectionUtils.isEmpty(cookies)) {
                connection.cookies(cookies);
            }
            if (StringUtils.isNotBlank(refer)) {
                connection.referrer(refer);
            }
            if (StringUtils.isNotBlank(proxyUrl)) {
                System.setProperty("http.proxyHost", proxyUrl.split(":")[0].trim());
                System.setProperty("http.proxyPort", proxyUrl.split(":")[1].trim());
            }
            return get(connection);
        } catch (Exception e) {
            throw e;
        } finally {
            System.clearProperty("http.proxyHost");
            System.clearProperty("http.proxyPort");
        }
    }

    /**
     * post方式获取响应内容
     *
     * @param url
     * @return
     */
    public static Document post(String url) throws IOException {
        Collection<KeyVal> data = Collections.emptyList();
        return post(url, data);
    }

    /**
     * post方式获取响应内容
     *
     * @param url
     * @param data
     * @return
     */
    public static Document post(String url, Collection<KeyVal> data) throws IOException {
        Connection connection = getConnection(url).data(data);

        return post(connection);
    }

    /**
     * 获取响应内容
     *
     * @param url
     * @param data
     * @return
     */
    public static String getResponseText(String url, Collection<KeyVal> data) {
        Connection connection = getConnection(url).data(data);

        String responseText = null;
        try {
            responseText = post(connection).body().ownText();
        } catch (IOException e) {
            log.error("Get json failed.URL:" + url);
        }
        return responseText;
    }

}
