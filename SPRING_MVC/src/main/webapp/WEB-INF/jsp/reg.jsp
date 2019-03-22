<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>开始注册</title>
<link href="templets/style/reg.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>用户注册</h1>
	<h2>count:${count}</h2>
	<form action="handle_reg.do" method="post">
		用户名:<input type="text" placeholder="请输入账号" name="username">
		密码:<input type="password" placeholder="请输入密码" name="password"> 年龄:<input
			type="text" placeholder="请输入年龄" name="age"> 手机号码:<input
			type="text" placeholder="请输入手机号码" name="phone"> 电子邮箱:<input
			type="text" placeholder="请输入邮箱" name="email"> <input
			type="submit" value="注册">
	</form>
</body>
</html>