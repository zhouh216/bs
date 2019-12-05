package com.fiction.crawler.biz.dao.sql;

import com.fiction.crawler.domain.dto.FictionContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FictionContentDao {
    int insertList(@Param("list") List<FictionContent> fictionContentList);
}