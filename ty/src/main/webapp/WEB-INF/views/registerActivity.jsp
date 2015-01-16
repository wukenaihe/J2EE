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

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>活动报名</title>
<style type="text/css">
</style>
</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" data-theme="b">
			<h1>活动报名</h1>
		</div>
		<div data-role="content" data-theme="b">
			<form action="form.php" method="post">
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup">
				    	<legend>活动</legend>
				         	<input type="radio" name="radio-choice-1" id="radio-choice-1" value="choice-1" checked="checked" />
				         	<label for="radio-choice-1">大明山</label>

				         	<input type="radio" name="radio-choice-1" id="radio-choice-2" value="choice-2"  />
				         	<label for="radio-choice-2">黄山</label>

				         	<input type="radio" name="radio-choice-1" id="radio-choice-3" value="choice-3"  />
				         	<label for="radio-choice-3">清凉峰(已报25人)</label>

				         	<input type="radio" name="radio-choice-1" id="radio-choice-4" value="choice-4"  disabled="disabled" />
				         	<label for="radio-choice-4">徽杭古道(已满)</label>
				    </fieldset>
				</div>
				<div data-role="fieldcontain">
				<label for="textarea">备注信息:</label>
					<textarea name="textarea" id="textarea"></textarea>
				</div>
				<div class="ui-field-contain">
				    <button type="submit" id="submit-1" class="ui-shadow ui-btn ui-corner-all">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>