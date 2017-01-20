<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(null == session.getAttribute("userrole")){
	String userrole = request.getParameter("userrole");
	System.out.println("after login check:"+userrole);
	
	user userlog = new user();
	userlog = (user)request.getAttribute("loguser");
	//System.out.println(userlog.getUserName());
	
	if(userrole != null){
	System.out.println("session:"+session.getAttribute("userrole"));
	System.out.println("session:"+session.getAttribute("username"));
	}
 //	 List<Dtree> li=(ArrayList<Dtree>)request.getAttribute("treeList");
 
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
	function StuBase()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='StuBase.jsp' width='1200' height='490'></iframe>";
	}
	function StuTakRec()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='StuTakRec.jsp' width='1200' height='490'></iframe>";
	}
	function StuFee()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='StuFee.jsp' width='1200'height='490'></iframe>";
	}
	function StuFeeBase()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='StuFeeBase.jsp' width='1200'height='490'></iframe>";
	}
	function BusBase()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusBase.jsp' width='1200' height='490'></iframe>";
	}
	function BusRoute()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusRoute.jsp' width='1200' height='490'></iframe>";
	}
	function BusDriver()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusDriver.jsp' width='1200' height='490'></iframe>";
	}
	function BusEntourage()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusEntourage.jsp' width='1200' height='490'></iframe>";
	}
	function BusAlarm()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusAlarm.jsp' width='1200' height='490'></iframe>";
	}
	function BusRunRec()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BusRunRec.jsp' width='1200' height='490'></iframe>";
	}
	function Order()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='Order.jsp' width='1200' height='490'></iframe>";
	}
	function MUser()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='MUser.jsp' width='1200' height='490'></iframe>";
	}
	function MOrganization()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='MOrganization.jsp' width='1200' height='490'></iframe>";
	}
	function BuikUpload()
	{
		var bMap=document.getElementById("baiduMap");
		now = new Date(); 
		bMap.innerHTML="<iframe src='BuikUpload.jsp' width='1200' height='490'></iframe>";
	}
	
	
	</script>
	
  </head>
  
  <body  onload="javascript:baiduMap()" background="images/12.jpg" style="background-repeat:no-repeat;">
    <center>
    <table width="1210" border="0" height="613">
  <tr>
    <td width="480" align="center" class="title">故障诊断管理平台</td>
    <td width="480" align="right" class="text"><%= session.getAttribute("username") %>，您好！|<a href="Login.jsp"> 注销</a></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" ><ul id="MenuBar1" class="MenuBarHorizontal">
      <li><a href="javascript:baiduMap(0)">主页</a>        </li>
      <li><a href="#" class="MenuBarItemSubmenu">学生信息</a>
        <ul>
          <li><a href="javascript:StuBase()">学生基本信息</a></li>
          <li><a href="javascript:StuTakRec()">学生乘车记录</a></li>
          <li><a href="javascript:StuFeeBase()">学生缴费信息</a></li>
          <li><a href="javascript:StuFee()">学生缴费记录</a></li>    
        </ul>
      </li>
      <li><a href="#" class="MenuBarItemSubmenu">车辆信息</a>
        <ul>
          <li><a href="javascript:BusBase()">车辆基本信息</a></li>
          <li><a href="javascript:BusRoute()">线路信息</a></li>
          <li><a href="javascript:BusDriver()">驾驶员信息</a></li>
          <li><a href="javascript:BusEntourage()">随行人员信息</a></li>
          <li><a href="javascript:BusAlarm()">报警记录</a></li>
          <li><a href="javascript:BusRunRec()">车辆行驶记录</a></li>
        </ul>
      </li>
      <li><a href="javascript:Order()">发送命令</a></li>
      <li><a href="#" class="MenuBarItemSubmenu">系统管理</a>
        <ul>
          <li><a href="javascript:MUser()">用户管理</a></li>
          <!--  <li><a href="#">角色管理</a></li>-->
          <li><a href="javascript:MOrganization()">组织管理</a></li>
        </ul>
      </li>
      <li><a href="javascript:BuikUpload()">信息批量上传</a>        </li>
</ul></td>
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
<p>&nbsp; </p>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
    </center>
  </body>
</html>
