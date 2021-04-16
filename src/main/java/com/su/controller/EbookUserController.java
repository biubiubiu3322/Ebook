package com.su.controller;

import com.su.pojo.EbookUser;
import com.su.pojo.Result.PageResult;
import com.su.service.EbookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebookuser")
public class EbookUserController {

    @Autowired
    private EbookUserService ebookUserService;

    //遍历用户数据
    @RequestMapping("/userList")
    public PageResult findUserPage(@RequestBody EbookUser ebookUser, int page, int rows){
        return ebookUserService.findPage(ebookUser,page,rows);
    }

    //查询所有
    @RequestMapping("/findAll")
    public List<EbookUser> findAll(){
        return ebookUserService.findAll();
    }
}
