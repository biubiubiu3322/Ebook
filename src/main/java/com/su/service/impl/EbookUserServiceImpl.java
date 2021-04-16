package com.su.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.su.mapper.EbookUserMapper;
import com.su.pojo.EbookUser;
import com.su.pojo.EbookUserExample;
import com.su.pojo.Result.PageResult;
import com.su.service.EbookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookUserServiceImpl implements EbookUserService {

    @Autowired
    private EbookUserMapper ebookUserMapper;


    @Override
    public List<EbookUser> findAll() {
        return ebookUserMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(EbookUser ebookUser, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EbookUserExample ebookUserExample=new EbookUserExample();
        EbookUserExample.Criteria criteria=ebookUserExample.createCriteria();
        if(ebookUser!=null){
            if(ebookUser.getUsername()!=null && ebookUser.getUsername().length()>0){
                    criteria.andUsernameLike("%"+ebookUser.getUsername()+"%");
            }
        }
        Page<EbookUser> page= (Page) ebookUserMapper.selectByExample(ebookUserExample);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public EbookUser findOne(Integer id) {
        return ebookUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(EbookUser ebookUser) {
        ebookUserMapper.insert(ebookUser);
    }


    @Override
    public void update(EbookUser ebookUser) {
        ebookUserMapper.updateByPrimaryKey(ebookUser);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            ebookUserMapper.deleteByPrimaryKey(id);
        }
    }
}
