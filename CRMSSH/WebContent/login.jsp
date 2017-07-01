<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>后台登录</title> 
<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet"> 
</head> 
<body> 

<div class="login">
    <div class="message">后台登录</div>
    <div id="darkbannerwrap"></div>
    
    <form action="${pageContext.request.contextPath}/login" method="post">
		<input name="action" value="login" type="hidden">
		<input name="user.userName" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="user.passWord" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
	</form>

	
</div>
</body>
</html>