<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="LoginApp">
<head>
<meta charset="UTF-8">
<title>Angular Login</title>
<meta name="keywords" content="Login">
<meta name="description" content="Login">
<link rel="shortcut icon"
	href="http://www.w3cplus.com/sites/all/themes/marvin/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/base.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css" media="all" />
</head>
<body>
	<!--  <div class="wrap_top_nav">
	<nav id="top_nav">
		<ul class="inline-style clearfix">
			<li><a href="http://www.w3cplus.com" target="_blank">w3cplus</a></li>
			<li><a href="http://www.w3cplus.com/resources/css3-tutorial-and-case" target="_blank">css3详解教程</a></li>
			<li><a href="http://www.w3cplus.com/demos/list.html" target="_blank">css3实例</a></li>
			<li><a href="http://www.w3cplus.com/demo/tags/242.html" target="_blank">藤藤每日一练</a></li>
		</ul>
		<a id="read" href="http://www.w3cplus.com/demo/mini-login-form.html" target="_blank">查看原文>></a>
	</nav>
</div>-->
	<div class="page">
		<!--  <header id="header">
		<hgroup class="white">
			<h1>css3制作登陆表单</h1>
			<h2>作者：白牙(如有更好建议或疑问请加群：1041263)</h2>
		</hgroup>
	</header>-->
		<section class="demo">
		<div class="content" ng-controller="LoginController">
			<form action="" method="post" class="login-form" name="LoginForm">
			   <div align="center" class="error" ng-show="message">{{message}}</div>
				<div class="username">
					<input type="text" name="username" autocomplete="on" required
						ng-model="user.username" ng-maxlength=30 /> <span
						class="user-icon icon">u</span>
				</div>
				<div class="password">
					<input type="password" name="password" ng-model="user.password" />
					<span class="password-icon icon">p</span>
				</div>
				<div class="account-control">
					<input type="checkbox" name="Remember me" id="Remember me"
						value="Remember me" checked="checked" /> <label for="Remember me"
						data-on="c" class="check"></label> <label for="Remember me"
						class="info">Remember me</label>
					<button type="submit" ng-click="saveUser()">Login</button>
				</div>
				<p class="not-registered">
					Not a registered user yet?<a>Sign up now!</a>
				</p>
			</form>
		</div>
		</section>
	</div>
	<script type="text/javascript" charset="UTF-8"
		src="<%=request.getContextPath()%>/js/prefixfree.min.js"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<%=request.getContextPath()%>/js/angular.min.js"></script>
	<script type="text/javascript">
        var LoginModule = angular.module('LoginApp',[]);
		LoginModule.config(function($httpProvider) {
		$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
		$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

	// Override $http service's default transformRequest
		$httpProvider.defaults.transformRequest = [function(data) {
		/**
		 * The workhorse; converts an object to x-www-form-urlencoded serialization.
		 * @param {Object} obj
		 * @return {String}
		 */
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
 	LoginModule.controller('LoginController',function($scope,$http,$location){
 		$scope.saveUser = function(){
          $http.post('<%=request.getContextPath()%>/doLogin',$scope.user).success(function(data) {
							$scope.message = data.msg;
							$scope.success = data.success;
							console.log($scope.success);
							if($scope.success){
								window.location.href = '<%=request.getContextPath()%>/index';
							}
			  })
			}
		})
	</script>
</body>
</html>