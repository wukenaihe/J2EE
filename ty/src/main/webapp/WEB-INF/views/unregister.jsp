<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>正在跳转</title>
</head>
<body>
	<form name=loading>
		<p align=center>
			<font color="#0066ff" size="2">尚未绑定，正在跳转，请稍等</font><font color="#0066ff"
				size="2" face="Arial">...</font> <input type=text name=chart size=46
				style="font-family: Arial; font-weight: bolder; color: #0066ff; background-color: #fef4d9; padding: 0px; border-style: none;">

			<input type=text name=percent size=47
				style="color: #0066ff; text-align: center; border-width: medium; border-style: none;">
			<script>
				var bar = 0
				var line = "||"
				var amount = "||"
				count()
				function count() {
					bar = bar + 2
					amount = amount + line
					document.loading.chart.value = amount
					document.loading.percent.value = bar + "%"
					if (bar < 99) {
						setTimeout("count()", 50);
					} else {
						window.location = "http://www.baidu.com";
					}
				}
			</script>
		</p>
	</form>
	<p align="center">
		如果您的浏览器不支持跳转,<a style="text-decoration: none"
			href="http://www.baidu.com"><font color="blue">请点这里</font></a>.
	</p>
</body>
</html>