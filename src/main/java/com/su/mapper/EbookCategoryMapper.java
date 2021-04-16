package com.su.mapper;

import com.su.pojo.EbookCategory;
import com.su.pojo.EbookCategoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EbookCategoryMapper {
    int countByExample(EbookCategoryExample example);

    int deleteByExample(EbookCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbookCategory record);

    int insertSelective(EbookCategory record);

    List<EbookCategory> selectByExample(EbookCategoryExample example);

    EbookCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbookCategory record, @Param("example") EbookCategoryExample example);

    int updateByExample(@Param("record") EbookCategory record, @Param("example") EbookCategoryExample example);

    int updateByPrimaryKeySelective(EbookCategory record);

    int updateByPrimaryKey(EbookCategory record);
}