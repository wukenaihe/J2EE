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
			<h1>黄山二日游</h1>
		</div>
		<div data-role="content" data-theme="b">
		<table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke" data-column-btn-text="" data-column-btn-theme="b">
    <thead>
        <tr>
            <th data-priority="1"></th>
            <th data-priority="1">昵称</th>
            <th data-priority="1">性别</th>
            <th data-priority="1">感情</th>
            <th data-priority="1">年龄</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="http://wx.qlogo.cn/mmopen/PiajxSqBRaEJIKrM2che2u6B9uNt5LgSvCTes4gJ8MT9AgN8CojTqzJUw1wU7ZDRxwyciaCIJ6rEfsceywEwARLw/0" height="32px" width="32px"></td>
            <td>无可奈何</td>
            <td>男</td>
            <td>单身</td>
            <td>26</td>
        </tr>
        <tr>
            <td><img src="http://wx.qlogo.cn/mmopen/PiajxSqBRaEJIKrM2che2u6B9uNt5LgSvCTes4gJ8MT9AgN8CojTqzJUw1wU7ZDRxwyciaCIJ6rEfsceywEwARLw/0" height="32px" width="32px"></td>
            <td>无可奈何</td>
            <td>男</td>
            <td>单身</td>
            <td>26</td>
        </tr>
        <tr>
            <td><img src="http://wx.qlogo.cn/mmopen/PiajxSqBRaEJIKrM2che2u6B9uNt5LgSvCTes4gJ8MT9AgN8CojTqzJUw1wU7ZDRxwyciaCIJ6rEfsceywEwARLw/0" height="32px" width="32px"></td>
            <td>无可奈何</td>
            <td>男</td>
            <td>单身</td>
            <td>26</td>
        </tr>
        <tr>
            <td><img src="http://wx.qlogo.cn/mmopen/PiajxSqBRaEJIKrM2che2u6B9uNt5LgSvCTes4gJ8MT9AgN8CojTqzJUw1wU7ZDRxwyciaCIJ6rEfsceywEwARLw/0" height="32px" width="32px"></td>
            <td>无可奈何</td>
            <td>男</td>
            <td>有伴</td>
            <td>26</td>
        </tr>
        <tr>
            <td><img src="http://wx.qlogo.cn/mmopen/PiajxSqBRaEJIKrM2che2u6B9uNt5LgSvCTes4gJ8MT9AgN8CojTqzJUw1wU7ZDRxwyciaCIJ6rEfsceywEwARLw/0" height="32px" width="32px"></td>
            <td>无可奈何</td>
            <td>男</td>
            <td>求交往</td>
            <td>26</td>
        </tr>
    </tbody>
</table>
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