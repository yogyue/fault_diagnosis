<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String username = (String)session.getAttribute("username");
	if( username == null ){
		response.sendRedirect("Login.jsp");
	}
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


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="CSS/HomePage.css" rel="stylesheet" type="text/css" />
<link href="js/dtree.css" rel="stylesheet" type="test/css" />
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css" />
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<script type="text/javascript" src="js/dtree.js"></script>
<!-- 
<script type="text/javascript" src="js/jquery.js"></script>
 -->

<script type="text/javascript">
	function baiduMap(bus) {
		var bMap = document.getElementById("baiduMap");
		now = new Date();

		
	bMap.innerHTML = "<iframe src='Map.jsp' width='1200' height='500' frameborder='1px'></iframe>";
	}
	function result() {
		var bMap = document.getElementById("baiduMap");
		now = new Date();
		bMap.innerHTML = "<iframe src='result.jsp' width='1200' height='490' frameborder='1px'></iframe>";
	}
</script>

</head>

<body onload="javascript:baiduMap()" background="images/12.jpg"
	style="background-repeat:no-repeat;">
	<center>
		<form action="searchservlet" name="searchform" method="post"
			onsubmit="return on_submit();">
			<table width="1210px" border="0" height="613">
				<tr>
					<td width="480px" align="center" class="title">故障预测管理平台</td>
					<td width="480px" align="right" class="text">
						<%=session.getAttribute("username")%>，您好！|<a href="javascript:void(0);"> 注销</a>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
						<h5>预测时间： </h5>
						<input type="text" style="length:20px;" name="forecastPeriod" id="forecastPeriod" /> &nbsp;h &nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-primary" onclick="javascript:result()">开始预测</button>
						<!-- 
						<a href="javascript:result()">预测</a>
						 -->
					</td>
				</tr>
				<tr style="height:10px;"></tr>
				<tr>
					<td height="500" colspan="2">
						<table width="1200" height="500">
							<tr>
								<td width="1200">
									<div id="baiduMap">
										<label>123</label>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
		<p>&nbsp;</p>
		<script type="text/javascript">
			var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
				imgDown : "SpryAssets/SpryMenuBarDownHover.gif",
				imgRight : "SpryAssets/SpryMenuBarRightHover.gif"
			});
		</script>
	</center>
</body>
</html>
