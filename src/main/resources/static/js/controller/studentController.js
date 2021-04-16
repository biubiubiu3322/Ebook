//控制层
app.controller("studentController",function($scope,studentService,$controller) {

    $controller('baseController',{$scope:$scope});//继承


    //javascript
    $scope.mobileRegx = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
    $scope.emailRegx = "^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\.][a-z]{2,3}([\.][a-z]{2})?$";
    $scope.pwdRegx = "[a-zA-Z0-9]*";

    $scope.submitForm = function() {
        alert("it works!");
    };

    //读取列表数据绑定到表单中
        $scope.findAll=function(){
            studentService.findAll().success(
                function(response){
                    $scope.ebookList=response;
                }
            );
    }

    //分页
    $scope.findPage=function(page,rows){
        studentService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }


    $scope.searchEntity={};//定义搜索对象

    //搜索
    $scope.search=function(page,rows){
        if($scope.categoryid==1){
            //将前端select选中的值传入到后台
            $scope.searchEntity.categoryid=1;
        }else if($scope.categoryid==2){
            $scope.searchEntity.categoryid=2;
        }else if($scope.categoryid==3){
            $scope.searchEntity.categoryid=3;
        }else if($scope.categoryid==4){
            $scope.searchEntity.categoryid=4;
        } else{
            $scope.searchEntity = {};
        }
        studentService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }


    //add
    $scope.save = function () {
        var obj=null;
        if ($scope.entity.id != null) {//如果有 ID
            obj=studentService.update($scope.entity);
        }else{
            obj=studentService.save($scope.entity);
        }
        obj.success(
            function (response) {
                if (response.success) {//重新查询
                    toastr.success(response.message);
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }

    //注册功能控制
    $scope.regiest = function () {
        studentService.regiest($scope.entity).success(
            function (response) {
                if (response.success) {//重新查询
                    alert(response.message);
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }

    //数据回显
    $scope.findOne = function (id) {
        studentService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }

    //做个提示
    $scope.logout=function(){
        toastr.success("注销成功!");
    }





    //批量删除
    $scope.delete = function () {
        if($scope.selectIds.length<=0){
            toastr.warning("请选择有效数据");
            return;
        }else{
            //获取选中的复选框
            Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(
                function (e) {
                    if (!e){
                        return;
                    }
                    studentService.delete($scope.selectIds).success(
                        function (response) {
                            if (response.success) {
                                $scope.selectIds=[];   //清空选项内遗留bug
                                toastr.success(response.message);
                                $scope.reloadList();//刷新列表
                            }
                        }
                    );
                })
            }
        }



    $scope.updateStatus = function (id, brandstatus) {
        studentService.updateStatusBrand(id, brandstatus).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                } else {
                    alert("失败");
                }
            }
        );
    }

    //读取当前登录人
    $scope.showLoginName = function () {
        studentService.loginName().success(
            function (response) {
                $scope.loginName = response.loginName;
            }
        );
    }

});