<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>用户注册</title>
<link href="<c:url value="/resources/css/form.min.css"/>"
	rel="stylesheet" type="text/css">
<style type="text/css">
#bottom_info {
	position: relative;
	top: -3.8em;
	margin: 0 0.5em;
	padding: .8em 0;
	text-align: center;
	background-color: #18c178;
	color: #ffffff;
	border: medium hidden;
	border-radius: 0.1em;
	box-sizing: border-box;
	display: none;
}

#bottom_info a {
	/*
				color: #adadad;
				*/
	width: 100%;
	text-decoration: none;
	outline: none;
}

#bottom_jump {
	position: relative;
	top: -3em;
	margin: 0 0.5em;
	padding: .8em 0;
	text-align: center;
	background-color: #62A9E3;
	color: #ffffff;
	border: medium hidden;
	border-radius: 0.1em;
	box-sizing: border-box;
	display: none;
}
</style>
</head>
<body>
	<div id="subjects">
		<form id="main_form" action="register-save" method="post" accept-charset="utf-8" style="padding-bottom: 4em;">


			<input type="hidden" name="openid" value=${userInfo.openid}></input>
			<input type="hidden" name="nickname" value=${userInfo.nickname}></input>
			<input type="hidden" name="sex" value=${userInfo.sex}></input>
			<input type="hidden" name="province" value=${userInfo.province}></input>
			<input type="hidden" name="city" value=${userInfo.city}></input>
			<input type="hidden" name="country" value=${userInfo.country}></input>
			<input type="hidden" name="headimgurl" value=${userInfo.headimgurl}></input>
			<input type="hidden" name="uuionid" value=${userInfo.unionid}></input>
			<div class="form_ctrl page_head" title="简历提交">
				<h2>用户信息</h2>
			</div>
			<div class="form_ctrl page_text" title=""></div>
			<div class="form_ctrl input_text" title="姓名">
				<label class="ctrl_title">姓名</label> <input type="text" name="name"
					value="${userInfo.name}" placeholder="真实姓名" required="required">
			</div>
			<div class="form_ctrl input_text" title="支付宝昵称">
				<label class="ctrl_title">支付宝昵称</label> <input type="text"
					name="zhifuNikcname" value="${userInfo.zhifuNikcname}"
					placeholder="支付宝昵称" required="required">
			</div>
			<div class="form_ctrl input_text" title="身份证号">
				<label class="ctrl_title">身份证号</label> <input type="text"
					name="cardId" value="${userInfo.cardId}" placeholder="身份证号码"
					required="required">
			</div>
			<div class="form_ctrl input_text" title="手机">
				<label class="ctrl_title">手机</label> <input type="text" name="phone"
					value="${userInfo.phone}" placeholder="手机号码" required="required">
			</div>
			<div class="form_ctrl input_text" title="职业">
				<label class="ctrl_title">职业</label> <input type="text" name="job"
					value="${userInfo.job}" placeholder="职业">
			</div>
			<div class="form_ctrl input_text" title="学校">
				<label class="ctrl_title">学校</label> <input type="text" name="school"
					value="${userInfo.school}" placeholder="学校">
			</div>
			<div class="form_ctrl form_select" title="性取向">
				<label class="ctrl_title">性取向</label> 
				<select name="sexOrientation" num="1">
					<option value="直的" <c:if test="${userInfo.sexOrientation eq '直的'}">selected="selected"</c:if>>直的</option>
					<option value="弯的" <c:if test="${userInfo.sexOrientation eq '弯的'}">selected="selected"</c:if>>弯的</option>
					<option value="通吃" <c:if test="${userInfo.sexOrientation eq '通吃'}">selected="selected"</c:if>>通吃</option>
				</select>
				<div></div>
			</div>
			<div class="form_ctrl input_text" title="年龄">
				<label class="ctrl_title">年龄</label> <input type="text"
					name="age" value="${userInfo.age}" placeholder="年龄">
			</div>
			<div class="form_ctrl form_select" title="感情状况">
				<label class="ctrl_title">感情状况</label> 
				<select name="single">
					<option value="保密" <c:if test="${userInfo.single eq '保密'}">selected="selected"</c:if>>保密</option>
					<option value="单身" <c:if test="${userInfo.single eq '单身'}">selected="selected"</c:if>>单身</option>
					<option value="求交往" <c:if test="${userInfo.single eq '求交往'}">selected="selected"</c:if>>求交往</option>
					<option value="恋爱中" <c:if test="${userInfo.single eq '恋爱中'}">selected="selected"</c:if>>恋爱中</option>
					<option value="已婚" <c:if test="${userInfo.single eq '已婚'}">selected="selected"</c:if>>已婚</option>
				</select>
				<div></div>
			</div>

			<div class="form_ctrl form_submit" id="12" title="">
				<label class="ctrl_title">提交更新</label> <input type="submit"
					name="submit" value="提交">
			</div>
		</form>
		<div id="logo">
			<div style="margin-bottom: 5px;"></div>
		</div>
</body>
</html>