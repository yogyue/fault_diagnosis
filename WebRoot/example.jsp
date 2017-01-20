<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'MainPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="CSS/HomePage.css" rel="stylesheet" type="text/css" />
	<link href="js/dtree.css" rel="stylesheet" type="test/css"/>
	<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
	<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/dtree.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>

	<script type="text/javascript">
	function baiduMap(bus)
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		
		bMap.innerHTML="<iframe src='Map.jsp' width='1200' height='500' ></iframe>";
	}
	function result()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='result.jsp' width='1200' height='490'></iframe>";
	}
	</script>
	
  </head>
  
  <body  onload="javascript:baiduMap()" background="images/12.jpg" style="background-repeat:no-repeat;">
    <center>
     <form action="searchservlet" name = "searchform" method= "post" onsubmit = "return on_submit();">
    <table width="1210" border="0" height="613">
  <tr>
    <td width="480" align="center" class="title">故障预测管理平台</td>
    <td width="480" align="right" class="text"><%= session.getAttribute("username") %>，您好！|<a href="Login.jsp"> 注销</a></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" >
    	预测时间：<input type="text" name="forecastPeriod" id="forecastPeriod"/> &nbsp; h &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:result()">预测</a> 
    </td>
  </tr>
  <tr>
    <td height="500" colspan="2" >
    <table width="1200" height="500"border="1">
      <tr>
        <td width="1200"><div id="baiduMap"><label>123</label></div></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<p>&nbsp; </p>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
    </center>
  </body>
</html>
