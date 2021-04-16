package com.su.service.impl;

import com.su.mapper.EbookCategoryMapper;
import com.su.pojo.EbookCategory;
import com.su.service.EbookGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookGroundServiceImpl implements EbookGroundService {

    @Autowired
    private EbookCategoryMapper ebookCategoryMapper;

    @Override
    public List<EbookCategory> findAll() {
        return ebookCategoryMapper.selectByExample(null);
    }
}
