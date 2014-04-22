<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html ng-app="myApp">
<head>
	<meta charset="UTF-8">
	<title>Angular</title>
	<meta name="keywords" content="Angular">
	<meta name="description" content="Angular">
	<link rel="shortcut icon" href="http://www.w3cplus.com/sites/all/themes/marvin/favicon.ico">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/base.css" media="all" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css" media="all" />
</head>
<body>
	<!--<div class="wrap_top_nav">
		<nav id="top_nav">
			<ul class="inline-style clearfix">
				<li><a href="http://www.w3cplus.com" target="_blank">w3cplus</a></li>
				<li><a href="http://www.w3cplus.com/resources/css3-tutorial-and-case" target="_blank">css3详解教程</a></li>
				<li><a href="http://www.w3cplus.com/demos/list.html" target="_blank">css3实例</a></li>
				<li><a href="http://www.w3cplus.com/demo/tags/242.html" target="_blank">藤藤每日一练</a></li>
			</ul>
			<a id="read" href="http://www.w3cplus.com/demo/749.html" target="_blank">查看原文>></a>
		</nav>
	</div>-->
	<div class="page">
		<!--<header id="header">
			<hgroup class="white blank">
				<h1>css3制作后台管理面板</h1>
				<h2>作者：<a href="http://weibo.com/zhp1991">白牙</a>(如有更好建议或疑问请加群：1041263)</h2>
			</hgroup>
		</header>-->
		<section class="demo">
			<div class="admin-panel clearfix">
				<div class="slidebar">
					<div class="logo">
						<a href=""></a>
					</div>
					<ul ng-controller="CommonController">
						<li><a href="#dashboard" id="targeted">${I18N.getText("index.home")}</a></li>
						<li><a ng-click="listUser()">User</a></li>
						<li><a ng-click="listGame()">Game</a></li>
						<li><a ng-click="showUserPie()">UserPie</a></li>
						<li><a href="#links">links</a></li>
						<li><a href="#comments">comments</a></li>
						<li><a href="#widgets">widgets</a></li>
						<li><a href="#plugins">plugins</a></li>
						<li><a href="#users">users</a></li>
						<li><a href="#tools">tools</a></li>
						<li><a href="#settings">settings</a></li>
					</ul>
				</div>
				<div class="main">
					<ul class="topbar clearfix">
						<li><a href="#">q</a></li>
						<li><a href="#">p</a></li>
						<li><a href="#">o</a></li>
						<li><a href="#">f</a></li>
						<li><a href="#">n</a></li>
					</ul>
					<div id="mainContent">
						<!-- <div id="dashboard">
							<h2 class="header"><span class="icon"></span>Dashboard</h2>
							<div class="monitor">
								<h4>Right Now</h4>
								<div class="clearfix">
									<ul class="content" ng-controller="UserController">
										<li>UserInfo</li>
										<li class="posts"><a href="">${user.get("email")}</a></li>
										<li class="pages"><a href="">${user.attrs['birth']}</a></li>
										<li class="categories"><a href=""><format:formatDate value="${user.attrs['lastLoginDate']}" pattern="yyyy-MM-dd HH:mm:ss"/></a></li>
										<!-- <li>content</li>
										<li class="posts"><span class="count">179</span><a href="">posts</a></li>
										<li class="pages"><span class="count">13</span><a href="">pages</a></li>
										<li class="categories"><span class="count">21</span><a href="">categories</a></li>
										<li class="tags"><span class="count">305</span><a href="">tags</a></li>
									</ul>
									<ul class="discussions">
										<li>discussions</li>
										<li class="comments"><span class="count">353</span><a href="">comments</a></li>
										<li class="approved"><span class="count">319</span><a href="">approved</a></li>
										<li class="pending"><span class="count">0</span><a href="">pending</a></li>
										<li class="spam"><span class="count">34</span><a href="">spam</a></li>
									</ul>
								</div>
								<p>Theme <a href="">Twenty Eleven</a> with <a href="">3 widgets</a></p>
							</div>
							<div class="quick-press">
								<h4>Quick Press</h4>
								<form action="" method="post">
									<input type="text" name="title" placeholder="Title"/>
									<input type="text" name="content" placeholder="Content"/>
									<input type="text" name="tags" placeholder="Tags"/>
									<button type="button" class="save">l</button>
									<button type="button" class="delet">m</button>
									<button type="submit" class="submit" name="submit">Publish</button>
								</form>
							</div>
						</div>
						<div id="posts">
							<h2 class="header">posts</h2>
						</div>
						<div id="media">
							<h2 class="header">media</h2>
						</div>
						<div id="pages">
							<h2 class="header">pages</h2>
						</div>
						<div id="links">
							<h2 class="header">links</h2>
						</div>
						<div id="comments">
							<h2 class="header">comments</h2>
						</div>
						<div id="widgets">
							<h2 class="header">widgets</h2>
						</div>
						<div id="plugins">
							<h2 class="header">plugins</h2>
						</div>
						<div id="users">
							<h2 class="header">users</h2>
						</div>
						<div id="tools">
							<h2 class="header">tools</h2>
						</div>
						<div id="settings">
							<h2 class="header">settings</h2>
						</div>-->
					</div>
					<ul class="statusbar">
						<li><a href=""></a></li>
						<li><a href=""></a></li>
						<li class="profiles-setting"><a href="">s</a></li>
						<li class="logout"><a href="">k</a></li>
					</ul>
				</div>
			</div>
		</section>
	</div>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath() %>/js/jquery-1.8.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath() %>/js/prefixfree.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath() %>/js/angular.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath() %>/js/angular-route.min.js"></script>


<script type="text/javascript">
			(function() {
					var initTarget = document.getElementById("targeted");
					//initTarget.click();
				})();
				var userModule = angular.module('myApp',['ngRoute']);
				userModule.config(['$routeProvider',function ($routeProvider) {  
				    $routeProvider  
			        .when('/user/index', {  
			            templateUrl: 'page/user/index.jsp',  
			            controller: 'UserController'  
			        })
			        .when('/game/index', {  
			            templateUrl: 'page/game/index.jsp',  
			            controller: 'GameController'  
			        })
			        .when('/main.html', {  
			            templateUrl: 'page/game/index.jsp',  
			            controller: 'GameController'  
			        })
			        .otherwise({  
			            redirectTo: '/index'  
			        });  
			}]); 
				userModule.controller("CommonController",function($scope,$http){
					$scope.listUser = function(){
						$http.get('<%=request.getContextPath()%>/user/index').success(function(data){
							$("#mainContent").html(data);
						});
					};
					$scope.listGame = function(){
						$http.get('<%=request.getContextPath()%>/game/index').success(function(data){
							$("#mainContent").html(data);
						});
					}
					
					$scope.showUserPie = function(){
						$http.get('<%=request.getContextPath()%>/user/pie').success(function(data){
							$("#mainContent").html(data);
						});
					}
					
				})
				userModule.controller("UserController",function($scope,$http){
					console.log("User");
				})
				
				userModule.controller("GameController",function($scope){
					console.log("Game");
				})
</script>
</body>
</html>