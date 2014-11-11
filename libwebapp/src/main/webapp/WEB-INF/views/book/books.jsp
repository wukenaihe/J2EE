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
            <li><a href="#">图书管理</a></li>
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
            <li class="active"><a href="#">图书浏览</a></li>
          </ul>
        </div>
        <div class="col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">图书管理</h2>
          <div class="table-responsive">
         	 <a href="add" class="btn btn-success" role="button">添加</a>
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ISBN</th>
                   <th>书名</th>
                   <th>作者</th>
                   <th>出版社</th>
                   <th>图书册数</th>
                   <th>剩余</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>
                   <c:forEach items="${list}" var="p" varStatus="count">
                    <tr>
                        <td>${p.isdn}</td>
                        <td>${p.bookname}</td>
                        <td>${p.author}</td>
                        <td>${p.publish}</td>
                        <td>${p.total}</td>
                        <td>${p.remain}</td>
                        <td>
                          <a href="updateBook?isdn=${p.isdn}" class="btn btn-success" role="button">更新</a>
                          <c:choose>

                             <c:when test="${p.total==p.remain}">
                                 <a href="delete?isdn=${p.isdn}" class="btn btn-danger" role="button">删除</a>
                             </c:when>
                                   
                             <c:otherwise>
                                  <a href="#" class="btn btn-danger" role="button" disabled="disabled">删除</a>
                             </c:otherwise>
                            
                          </c:choose>
                         
                        </td>
                    </tr>
                   </c:forEach>
               </tbody>
             </table>
          </div>
        </div> 
      </div>
    </div>
    </div>
    <script type="text/javascript">
    </script>
  </body>
</html>
