app.service("studentService",function ($http) {
    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../ebook/search?page='+page+"&rows="+rows, searchEntity);
    }



    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../ebook/findAll');
    }


    //分页
    this.findPage=function(page,rows){
        return $http.get('../ebook/findPage?page='+page+'&rows='+rows);
    }


    //findOne
    this.findOne=function (id) {
        return $http.get('../ebook/findOne?id=' + id);
    }

    //add
    this.save=function (entity) {

        return  $http.post('../ebook/save', entity);
    }

    //注册
    this.regiest=function (entity) {
        return $http.post("../ebook/regiest",entity);
    }

    //update
    this.update=function (entity) {

        return  $http.post('../ebook/update', entity);
    }

    //delete
    this.delete=function (ids) {
        return $http.get('../ebook/delete?ids='+ids);
    }

    //读取登录人名称
    this.loginName=function(){
        return $http.get('../ebook/name');
    }







})