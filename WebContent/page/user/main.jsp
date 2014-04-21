<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="userService">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Index</title>
<style type="text/css">
</style>
</head>
<body ng-controller="UserController">
 <div id="save"
  style="display: block; margin-left: auto; margin-right: auto;">
  <table>
   <tr style="display: none">
    <td>用户id</td>
    <td><input type="text" name="user.id" ng-model="saveUser.userId" /></td>
   </tr>
   <tr>
    <td>用户名</td>
    <td><input type="text" name="user.username"
     ng-model="saveUser.username" /></td>
   </tr>
   <tr>
    <td>密码</td>
    <td><input type="password" name="user.password"
     ng-model="saveUser.password" /></td>
   </tr>
   <tr>
    <td>邮箱</td>
    <td><input type="email" name="user.email"
     ng-model="saveUser.email" /></td>
   </tr>
   <tr>
    <td colspan="2"><input type="button" value="添加"
     ng-click="addUserClick()" /></td>
   </tr>
  </table>
 </div>
Search : <input type="text" ng-model="query"><br/>
Order : <select ng-model="orderProp">
 <option value="userId">Id</option>
 <option value="username">Username</option>
 </select>
 <div id="userList" style="margin-left: auto; margin-right: auto;">
  <table border="1" style="margin-left: auto; margin-right: auto;">
   <tr>
    <th>序号</th>
    <th>用户id</th>
    <th>用户名称</th>
    <th>用户密码</th>
    <th>用户邮箱</th>
    <th>用户操作</th>
   </tr>
   <tr ng-repeat="user in mydata | filter : query | orderBy : orderProp" ng-class-even="'even'"
    ng-class-odd="'odd'">
    <td>{{$index + 1}}</td>
    <td>{{user.userId}}</td>
    <td>{{user.username}}</td>
    <td>{{user.password}}</td>
    <td>{{user.email}}</td>
    <td><a href="" ng-click="updateUser(user)">修改</a> &nbsp; <a
     href="" ng-click="deleteUser(user)">删除</a></td>
   </tr>
  </table>
 </div>
 <div id="update"
  style="display: block; margin-left: auto; margin-right: auto;">
  <table>
   <tr style="display: none">
    <td>用户id</td>
    <td><input type="text" id="id" name="user.id"
     ng-model="modifyUser.id" /></td>
   </tr>
   <tr>
    <td>用户名</td>
    <td><input type="text" id="username" name="user.username"
     ng-model="modifyUser.username" /></td>
   </tr>
   <tr>
    <td>密码</td>
    <td><input type="password" id="password" name="user.password"
     ng-model="modifyUser.password" /></td>
   </tr>
   <tr>
    <td>用户邮箱</td>
    <td><input type="email" id="cs" name="user.email"
     ng-model="modifyUser.email" /></td>
   </tr>
   <tr>
    <td colspan="2"><input type="button" value="更新"
     ng-click="updateUserClick()" /></td>
   </tr>
  </table>
 </div>
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/angular.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/angular-resource.min.js"></script>
<script type="text/javascript">
  var userModule = angular.module('userService',['ngResource'],angular.noop);
  userModule.config(function($httpProvider) {
		$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
		$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
		$httpProvider.defaults.transformRequest = [function(data) {
			var param = function(obj) {
			var query = '';
			var name, value, fullSubName, subName, subValue, innerObj, i;

				for (name in obj) {
					value = obj[name];

					if (value instanceof Array) {
						for (i = 0; i < value.length; ++i) {
							subValue = value[i];
							fullSubName = name + '[' + i + ']';
							innerObj = {};
							innerObj[fullSubName] = subValue;
							query += param(innerObj) + '&';
						}
					} else if (value instanceof Object) {
						for (subName in value) {
							subValue = value[subName];
							fullSubName = name + '[' + subName + ']';
							innerObj = {};
							innerObj[fullSubName] = subValue;
							query += param(innerObj) + '&';
						}
					} else if (value !== undefined && value !== null) {
						query += encodeURIComponent(name) + '='
		 						+ encodeURIComponent(value) + '&';
						}
					}
				return query.length ? query.substr(0, query.length - 1) : query;
				};
			return angular.isObject(data) && String(data) !== '[object File]'
				? param(data)
				: data;
	}];
});
  var userUrl = {
                  'addUrl' : '<%=request.getContextPath() %>/user/add',
                  'updateUrl' : '<%=request.getContextPath() %>/user/update',
                  'deleteUrl' : '<%=request.getContextPath() %>/user/delete',
                  'queryUrl' : '<%=request.getContextPath() %>/user/json'
                 };
  
  userModule.controller('UserController',function($scope,$resource){
	  var actions = {
			  'add' : {
				  method : 'POST',
				  isArray : true,
				  headers : {
					  'Content-Type' : 'application/json'
				  }
			  },
			  'delete' : {
				  method : 'POST',
				  isArray : true
			  },
			  'update' : {
				  method : 'POST',
				  isArray : true,
				  headers : {
					  'Content-Type' : 'application/json'
				  }
			  },
			  'query' : {
				  method : 'GET',
				  isArray : true
			  }
	  };
	  
	  var getUserList = $resource(userUrl.queryUrl, {
	        page : 1,
	        pageSize : 20
	    }, actions);
	    getUserList.query({}, function(data) {
	        subobj = data;
	        $scope.mydata = data;
	    });
	    var userAdd = $resource(userUrl.addUrl, {
	        page : 1,
	        pageSize : 20
	    }, actions);
	    $scope.addUserClick = function() {
	        userAdd.add($scope.saveUser, function(data) {
	            subobj = data;
	            $scope.mydata = data;
	        });
	    };
	    var userUpdate = $resource(userUrl.updateUrl, {
	        page : 1,
	        pageSize : 20
	    }, actions);
	    $scope.updateUserClick = function() {
	        userUpdate.update($scope.modifyUser, function(data) {
	            subobj = data;
	            $scope.mydata = data;
	        });
	    };
	    var userDelete = $resource(userUrl.deleteUrl, {
	        page : 1,
	        pageSize : 20,
	        id : ':id'
	    }, actions);
	    $scope.deleteUser = function(user) {
	        userDelete['delete']({
	            id : user.id
	        }, {}, function(data) {
	            subobj = data;
	            $scope.mydata = data;
	        });
	    };
	    $scope.updateUser = function(user) {
	        $scope.modifyUser = user;
	    };
	    
	    $scope.orderProp = 'userId';
  })




</script>
</body>
</html>