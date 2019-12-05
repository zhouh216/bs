package com.fiction.crawler.biz.dao.mapper;

import com.fiction.crawler.domain.dto.FictionInfo;
import com.fiction.crawler.domain.dto.FictionInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface FictionInfoMapper {
    int countByExample(FictionInfoExample example);

    int deleteByExample(FictionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FictionInfo record);

    int insertSelective(FictionInfo record);

    List<FictionInfo> selectByExampleWithRowbounds(FictionInfoExample example, RowBounds rowBounds);

    List<FictionInfo> selectByExample(FictionInfoExample example);

    FictionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FictionInfo record, @Param("example") FictionInfoExample example);

    int updateByExample(@Param("record") FictionInfo record, @Param("example") FictionInfoExample example);

    int updateByPrimaryKeySelective(FictionInfo record);

    int updateByPrimaryKey(FictionInfo record);
}