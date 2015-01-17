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

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
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
			<form action="registerActivitySave" method="post">
				<input type="hidden" name="openId" value=${openid}></input>
				<div data-role="fieldcontain">
					<fieldset data-role="controlgroup">
						<legend>活动</legend>
						<c:forEach items="${arrs}" var="item">
							<input type="radio" name="activityId" id="${item.activityId}"
								value="${item.activityId}"
								<c:if test="${item.isFull||item.isRegister}">disabled</c:if> />
							<label for="${item.activityId}">${item.activityName} <c:if
									test="${item.isFull&&!item.isRegister}">(人数已满)</c:if>
								<c:if test="${item.isRegister}">(已报名)</c:if>&nbsp&nbsp&nbsp&nbsp${item.registerNum}人
							</label>
						</c:forEach>
					</fieldset>
				</div>
				<div data-role="fieldcontain">
					<label for="textarea">备注信息:</label>
					<textarea name="remark" id="textarea"></textarea>
				</div>
				<div class="ui-field-contain">
					    
					<button type="submit" id="submit-1"
						class="ui-shadow ui-btn ui-corner-all">提交</button>
				</div>
			</form>
		</div>
		<div data-role="popup" id="popupCloseRight" class="ui-content">
			    <a href="#" data-rel="back"
				class="ui-btn ui-corner-all ui-shadow ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
			<p>请选择你要参加的活动后再提交！</p>
		</div>
	</div>
</body>
<script>
	$(document).delegate(
			'#home',
			'pageshow',
			function() {
				var the_height = ($(window).height()
						- $(this).find('[data-role="header"]').height() - $(
						this).find('[data-role="footer"]').height());
				$(this).height($(window).height())
						.find('[data-role="content"]').height(the_height);
			});

	$("form").submit(function(e) {
		var form = $("form");
		var arrays = form.serializeArray();
		for(var i=0;i<arrays.length;++i){
			if(arrays[i].name=="activityId"){
				form.submit();
				return true;
			}
		}
		$("#popupCloseRight").popup("open");
		e.preventDefault();
	});
</script>
</html>