//基本控制层
app.controller('baseController', function ($scope) {
//重新加载列表 数据
    $scope.reloadList = function () {
    //切换页码
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50], onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //消息提示插件显示位置
    toastr.options.positionClass = 'toast-top-center';
    //自动关闭超时时间
    toastr.options.timeOut= "1100";



    $scope.selectIds = [];//选中的 ID 集合

    //全选逻辑
    $scope.selectAll = function () {
        if ($scope.select_all) { //判断是全选
            $scope.selectIds = [];//先清空，防止在操作了一个轮回之后，重复添加了...
            angular.forEach($scope.list, function (i) {  //list这是循环从后台获取的数组，并添加到刚刚定义的数组里
                i.selectIds = true; //全选即将所有的复选框变为选中
                $scope.selectIds.push(i.id);//将选中的内容放到数组里
            })
        }else {//判断全不选
            angular.forEach($scope.list, function (i) {
                i.selectIds = false; //所有复选框为不选中
                $scope.selectIds = [];//将数组清空
            })
        }
    };

    //下面的复选框单独点击逻辑
    $scope.selectOne = function () {
        angular.forEach($scope.list, function (i) {//依旧是循环......
            var index = $scope.selectIds.indexOf(i.id);//检索checked中是否有i.deviceId 如果没有则会返回-1
            if (i.selectIds && index === -1) {
                $scope.selectIds.push(i.id);
            } else if (!i.selectIds && index !== -1) {
                $scope.selectIds.splice(index, 1);
            }
        })
        if ($scope.list.devices.length === $scope.selectIds.length) {//判断checked数组的长度是否与原来请求的后台数组的长度是否相等 即是否给全选框加上选中
            $scope.select_all = true;
        } else {
            $scope.select_all = false;
        }
    }







    //提取 json 字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json 字符串转换为 json 对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }



});

