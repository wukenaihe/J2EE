<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Sign In</title>
</head>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<body>

	<div class="container">

		<form class="form-signin" action="doLogin" method="post">
			<h2 class="form-signin-heading">Login</h2>
			<c:if test="${!empty errorMsg}">
				<div class="help-inline" style="color: red">${errorMsg}</div>
			</c:if>
			<input type="text" class="input-block-level" placeholder="Account" name="name" value="21451001"> 
			<input type="password" class="input-block-level" placeholder="Password" name="password" value="123456">
			<label class="checkbox"> <input type="checkbox"
				value="remember-me"> Remember me
			</label>
			<button class="btn btn-large btn-primary" type="submit">登陆</button>
			<button class="btn btn-info" type="button">忘记密码</button>
		</form>

	</div>
	<!-- /container -->

</body>

</html>