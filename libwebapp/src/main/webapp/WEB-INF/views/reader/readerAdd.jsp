<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>图书馆管理系统</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/main/dashboard.css"/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/plugins/easyui/themes/bootstrap/easyui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/plugins/easyui/themes/icon.css"/>">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/plugins/easyui/jquery.easyui.min.js"/>"></script>
     <script type="text/javascript" src="<c:url value="/resources/plugins/amcharts/amcharts.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/resources/plugins/amcharts/serial.js"/>"></script>
    
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../book/books">图书管理</a></li>
            <li><a href="../reader/readers">读者管理</a></li>
            <li><a href="../borrow/borrowMain">借阅管理</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">读者管理</a></li>
          </ul>
        </div>
        <div class="col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">读者导入</h2>
          <form class="form-horizontal" role="form" action="addReader" method="post">
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="id" placeholder="学号">
              </div>
            </div>
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">名字</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="name" placeholder="名字">
              </div>
            </div>
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
              <div class="col-sm-5">
                <input type="password" class="form-control" name="password" placeholder="密码">
              </div>
            </div>
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="sex" placeholder="性别">
              </div>
            </div>
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">联系方式</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="telphone" placeholder="联系方式">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加</button>
              </div>
            </div>
          </form>
        </div> 
      </div>
    </div>
    </div>
    <script type="text/javascript">
    </script>
  </body>
</html>
