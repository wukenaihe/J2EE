<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="brand" href="../main"><strong>数据管理工具</strong></a>
			<div class="nav-collapse collapse">
					<p class="navbar-text pull-right" style="color: white;">
						<c:out value="${sessionScope.session_user.name}"/> <a
					href="doLogout">注销</a>
					</p>
				<ul class="nav">
					<li class="active"><a href="<c:url value='/main'/>">主页</a></li>
					<li><a href="<c:url value='/dataset/all-datasets'/>">数据集信息</a></li>
					<li><a href="<c:url value='/real-data/datasets'/>">实时数据信息</a></li>
					<li><a href="<c:url value='/schemasource/all-schemasource'/>">数据源信息</a></li>
					<li><a href="<c:url value='/gis/all-gisData'/>">空间数据信息</a></li>
					<li><a href="<c:url value="/sysconfig/main"/>">系统管理</a></li>
					<li><a href="<c:url value='/resources/log/log.html'/>">日志</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>