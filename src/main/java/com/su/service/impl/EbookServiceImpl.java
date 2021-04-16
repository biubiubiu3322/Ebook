package com.su.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.su.mapper.EbookMapper;
import com.su.pojo.Ebook;
import com.su.pojo.EbookExample;
import com.su.pojo.Result.PageResult;
import com.su.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    @Override
    public List<Ebook> findAll() {
        return ebookMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(Ebook ebook, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        EbookExample ebookExampl = new EbookExample();
        EbookExample.Criteria criteria = ebookExampl.createCriteria();
        if (ebook != null) {
            if (ebook.getCategoryid() != null) {
                criteria.andCategoryidEqualTo(ebook.getCategoryid());
            }
        }
        Page<Ebook> page = (Page) ebookMapper.selectByExample(ebookExampl);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Ebook findOne(Integer id) {
        return ebookMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Ebook ebook) {
        ebookMapper.insert(ebook);
    }

    @Override
    public void update(Ebook ebook) {
        ebookMapper.updateByPrimaryKey(ebook);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            ebookMapper.deleteByPrimaryKey(id);
        }
    }
}
