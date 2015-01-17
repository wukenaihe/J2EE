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
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>活动报名情况</h1>
		</div>
		<div data-role="content" data-theme="b">
			<ul data-role="listview" data-inset="true">
				<c:forEach items="${activities}" var="activity">
					<li><a href="registerActivityList?activityId=${activity.id}">${activity.name}</a></li>
				</c:forEach>
			</ul>
		</div>
<!-- 		<div data-role="footer" data-position="fixed"> -->
<!-- 			<h4>My Footer</h4> -->
<!-- 		</div> -->
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
</script>
</html>