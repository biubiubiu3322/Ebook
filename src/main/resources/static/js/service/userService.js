app.service("userService",function ($http) {

    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../ebookuser/userList?page='+page+"&rows="+rows, searchEntity);
    }

    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../ebookuser/findAll');
    }

});
