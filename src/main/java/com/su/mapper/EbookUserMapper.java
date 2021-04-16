package com.su.mapper;

import com.su.pojo.EbookUser;
import com.su.pojo.EbookUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EbookUserMapper {
    int countByExample(EbookUserExample example);

    int deleteByExample(EbookUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbookUser record);

    int insertSelective(EbookUser record);

    List<EbookUser> selectByExample(EbookUserExample example);

    EbookUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbookUser record, @Param("example") EbookUserExample example);

    int updateByExample(@Param("record") EbookUser record, @Param("example") EbookUserExample example);

    int updateByPrimaryKeySelective(EbookUser record);

    int updateByPrimaryKey(EbookUser record);

    //用来验证数据库内用户名与密码是否正确（spring sercurity安全框架）
    EbookUser loginbyUserName(String username);
}