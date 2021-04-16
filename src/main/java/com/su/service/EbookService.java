package com.su.service;

import com.su.pojo.Ebook;
import com.su.pojo.Result.PageResult;

import java.util.List;

public interface EbookService {

        public List<Ebook> findAll();

        public PageResult findPage(Ebook ebook, int pageNum, int pageSize);

        public Ebook findOne(Integer id);

        public void save(Ebook ebook);

        public void update(Ebook ebook);

        public void delete(Integer[] ids);
}
