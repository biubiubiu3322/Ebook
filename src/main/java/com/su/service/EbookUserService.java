package com.su.service;

import com.su.pojo.Ebook;
import com.su.pojo.EbookUser;
import com.su.pojo.Result.PageResult;

import java.util.List;

public interface EbookUserService {

    public List<EbookUser> findAll();

    public PageResult findPage(EbookUser ebookUser, int pageNum, int pageSize);

    public EbookUser findOne(Integer id);

    public void save(EbookUser ebookUser);

    public void update(EbookUser ebookUser);

    public void delete(Integer[] ids);
}
