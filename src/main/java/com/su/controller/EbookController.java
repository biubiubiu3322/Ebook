package com.su.controller;

import com.su.pojo.Ebook;
import com.su.pojo.EbookCategory;
import com.su.pojo.EbookUser;
import com.su.pojo.Result.PageResult;
import com.su.pojo.Result.Result;
import com.su.service.EbookGroundService;
import com.su.service.EbookService;
import com.su.service.EbookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @Autowired
    private EbookGroundService ebookGroundService;

    @Autowired
    private EbookUserService ebookUserService;



    @RequestMapping("/findAll")
    public List<EbookCategory> findAll(){
        return ebookGroundService.findAll();
    }

    //返回获取登录名
    @RequestMapping("/name")
    public Map name() {
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

    //注册功能
    @RequestMapping("/regiest")
    public Result regiest(@RequestBody EbookUser ebookUser){
        try {
            ebookUserService.save(ebookUser);
            return new Result(true, "注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, "注册失败");
        }
    }
    /**
     *
     * 返回全部列表(json)
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody Ebook student, int page, int rows){

        return ebookService.findPage(student,page,rows);
    }

    //添加
    @RequestMapping("/save")
    public Result add(@RequestBody Ebook student){

        try {
            student.setCatedate(new Date());
            ebookService.save(student);
            return new Result(true, "增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    //数据回显
    @RequestMapping("/findOne")
    public Ebook findOne(Integer id){
        return ebookService.findOne(id);
    }


    //更新
    @RequestMapping("/update")
    public Result update(@RequestBody Ebook student){
        try {
            student.setCatedate(new Date());
            ebookService.update(student);
            return new Result(true,"更新成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"更新失败!");

        }
    }

    //删除
    @RequestMapping("/delete")
    public Result delete(Integer[] ids){

        try {
            ebookService.delete(ids);
            return  new Result(true,"删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,"删除失败!");

        }

    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody Ebook student, int page,int rows ){
        return ebookService.findPage(student,page,rows);
    }

}
