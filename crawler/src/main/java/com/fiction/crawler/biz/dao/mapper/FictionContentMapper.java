package com.fiction.crawler.biz.dao.mapper;

import com.fiction.crawler.domain.dto.FictionContent;
import com.fiction.crawler.domain.dto.FictionContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FictionContentMapper {
    int countByExample(FictionContentExample example);

    int deleteByExample(FictionContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FictionContent record);

    int insertSelective(FictionContent record);

    List<FictionContent> selectByExampleWithBLOBsWithRowbounds(FictionContentExample example, RowBounds rowBounds);

    List<FictionContent> selectByExampleWithBLOBs(FictionContentExample example);

    List<FictionContent> selectByExampleWithRowbounds(FictionContentExample example, RowBounds rowBounds);

    List<FictionContent> selectByExample(FictionContentExample example);

    FictionContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FictionContent record, @Param("example") FictionContentExample example);

    int updateByExampleWithBLOBs(@Param("record") FictionContent record, @Param("example") FictionContentExample example);

    int updateByExample(@Param("record") FictionContent record, @Param("example") FictionContentExample example);

    int updateByPrimaryKeySelective(FictionContent record);

    int updateByPrimaryKeyWithBLOBs(FictionContent record);

    int updateByPrimaryKey(FictionContent record);
}