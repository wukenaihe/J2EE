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
    <title>Template for Market</title>

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
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
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
            <li class="active"><a href="#">Overview</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
            <li><a href="#">Commodity</a>
          </ul>
        </div>
        <div class="col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
           		<table class="easyui-datagrid" title="Bootstrap" style="height:250px"
            		data-options="singleSelect:true,collapsible:true,pagination:true,url:'product',method:'get'" id="dg">
  			  </table>
          </div>
        </div> 
      </div>
    </div>

    <div id="win">
      <div id="commonchart" style="width: 580px; height: 360px;">
        
      </div>
    </div>
    <script type="text/javascript">

      var lineChartData = [
                {
                    "date": "2009-10-02",
                    "value": 5
                },
                {
                    "date": "2009-10-03",
                    "value": 15
                },
                {
                    "date": "2009-10-04",
                    "value": 13
                },
                {
                    "date": "2009-10-05",
                    "value": 17
                },
                {
                    "date": "2009-10-06",
                    "value": 15
                },
                {
                    "date": "2009-10-09",
                    "value": 19
                },
                {
                    "date": "2009-10-10",
                    "value": 21
                },
                {
                    "date": "2009-10-11",
                    "value": 20
                },
                {
                    "date": "2009-10-12",
                    "value": 20
                },
                {
                    "date": "2009-10-13",
                    "value": 19
                },
                {
                    "date": "2009-10-16",
                    "value": 25
                }
            ];

        $("#dg").datagrid({
              columns:[[
                {field:'itemId',title:'Item ID',width:80,
                  formatter: function(value,row,index){
                        return '<a onclick="getHisChart()">'+row.itemId+'</a>';
                      }},
                {field:'productName',title:'Product',width:150,},
                {field:'listPrice',title:'List Price',width:80,},
                {field:'unitCost',title:'Unit Cost',width:80,},
                {field:'status',title:'Status',width:160,},
                {field:'attr1',title:'Attribute',width:400,}
              ]]});

        function getHisChart () {
          var rows = $('#dg').datagrid('getSelected');
          var chart = new AmCharts.AmSerialChart();
          chart.dataProvider = lineChartData;
          chart.pathToImages = "../resources/plugins/amcharts/images/";
          chart.categoryField = "date";
          chart.dataDateFormat = "YYYY-MM-DD";

          // sometimes we need to set margins manually
          // autoMargins should be set to false in order chart to use custom margin values
          chart.autoMargins = false;
          chart.marginRight = 0;
          chart.marginLeft = 0;
          chart.marginBottom = 0;
          chart.marginTop = 0;

          // AXES
          // category
          var categoryAxis = chart.categoryAxis;
          categoryAxis.parseDates = true; // as our data is date-based, we set parseDates to true
          categoryAxis.minPeriod = "DD"; // our data is daily, so we set minPeriod to DD
          categoryAxis.inside = true;
          categoryAxis.gridAlpha = 0;
          categoryAxis.tickLength = 0;
          categoryAxis.axisAlpha = 0;

          // value
          var valueAxis = new AmCharts.ValueAxis();
          valueAxis.dashLength = 4;
          valueAxis.axisAlpha = 0;
          chart.addValueAxis(valueAxis);

          // GRAPH
          var graph = new AmCharts.AmGraph();
          graph.type = "line";
          graph.valueField = "value";
          graph.lineColor = "#D8E63C";
          graph.customBullet = "../resources/plugins/amcharts/images/star.png"; // bullet for all data points
          graph.bulletSize = 14; // bullet image should be a rectangle (width = height)
          graph.customBulletField = "customBullet"; // this will make the graph to display custom bullet (red star)
          chart.addGraph(graph);

          // CURSOR
          var chartCursor = new AmCharts.ChartCursor();
          chart.addChartCursor(chartCursor);

          $('#commonchart').empty();
          $('#win').window({
            width : 600,
            height : 400,
            title : 'Reports',
            modal : false
          });  
          chart.write("commonchart");
          $('#win').window('refresh');
        }
    </script>
  </body>
</html>
