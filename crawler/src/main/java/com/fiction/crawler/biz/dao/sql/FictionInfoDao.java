package com.fiction.crawler.biz.dao.sql;

import com.fiction.crawler.domain.dto.FictionInfo;
import com.fiction.crawler.domain.dto.FictionInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface FictionInfoDao {

    List<FictionInfo> selectByName(Map<String,Object> param);

    Integer selectByNameCount(Map<String,Object> param);

    List<FictionInfo> selectByOrderType(Map<String,Object> param);

    Integer selectByOrderTypeCount(Map<String,Object> param);

    List<FictionInfo> selectByFictionType(Map<String,Object> param);

    Integer selectByFictionTypeCount(Map<String,Object> param);

    List<FictionInfo> selectBySexType(Map<String,Object> param);

    Integer selectBySexTypeCount(Map<String,Object> param);

    List<FictionInfo> afterLoad(Map<String, Object> param);

    Integer addOrSubtract(@Param("falg") int falg,@Param("num") int i,@Param("id") int id);

    List<Map<String,Object>> selectList(Map<String,Object> param);
}