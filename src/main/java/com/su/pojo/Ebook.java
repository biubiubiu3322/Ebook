package com.su.pojo;

import java.util.Date;

public class Ebook {
    private Integer id;
    private Integer categoryid;
    private String title;
    private String summary;
    private String uploaduser;
    private Date catedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser == null ? null : uploaduser.trim();
    }

    public Date getCatedate() {
        return catedate;
    }

    public void setCatedate(Date catedate) {
        this.catedate = catedate;
    }
}