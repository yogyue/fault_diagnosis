<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.*"%>
<%@ page import="function.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	
		
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>查询分析</title>
	<script>
		function test()
		{
			form.flag.value="1234";
			document.form.submit();
			 <%String flag=request.getParameter("flag");
				if(flag!=null){
					if(flag.equals("1234")){}
				}%>  
			form.flag.value="";
		}
	</script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body onload="checkvalue()" style="background:#2F4F4F;color:white" >
<center>
<form action="photoDay1_cid1servlet" name = "form"method= "post">
<table width="1000" height="25" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td>预测结果</td>
  </tr>
</table>

<table width="1000" style="text-align:center" border="1" cellspacing="0" cellpadding="0">
  <tr style="background:#696969;">
    <td width="15%">编号</td>
    <td width="20%">故障代码</td>
    <td width="50%">故障含义</td>
    <td width="15%">是否发生故障</td>
  </tr>
  <tr>
    <td width="15%">1</td>
    <td width="20%">SC03_05_027</td>
    <td width="50%">变频器主断路器跳闸</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">2</td>
    <td width="20%">SC03_05_029</td>
    <td width="50%">变频器定子断路器故障</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">3</td>
    <td width="20%">SC03_05_058（此类）</td>
    <td width="50%">直流母线过压故障</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">4</td>
    <td width="20%">SC01_05_107（此类）</td>
    <td width="50%">桨叶1、2、3PMC控制器输出过流</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">5</td>
    <td width="20%">SC01_05_003（此类）</td>
    <td width="50%">桨叶同步误差5秒等级1、2、3故障</td>
    <td width="15%">0</td>
  </tr>
<tr>
    <td width="15%">6</td>
    <td width="20%">SC01_05_109（此类）</td>
    <td width="50%">桨叶1、2、3变桨系统进线电源过压</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">7</td>
    <td width="20%">SC01_05_316（此类）</td>
    <td width="50%">桨叶1、2、3电池电压太低</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">8</td>
    <td width="20%">SC01_05_016（此类）</td>
    <td width="50%">桨叶1、2、3跟随错误</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">9</td>
    <td width="20%">SC01_03_015（此类）</td>
    <td width="50%">轴控箱1、2、3电池温度太高</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">10</td>
    <td width="20%">SC02_04_021（此类）</td>
    <td width="50%">机舱振动Y、Z方向超限</td>
    <td width="15%">0</td>
  </tr>
  <tr>
    <td width="15%">11</td>
    <td width="20%">SC03_05_006（此类）</td>
    <td width="50%">通讯错误</td>
    <td width="15%">0</td>
  </tr>
</table>
<span  style="height:18px"></span>
<table width="1000" height="25" style="text-align:center" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td><input type="submit" name="OK" class="button" id="OK" style="font-size:18px" value="维修后置0键"></td>
  </tr>
</table>
</form>
</center>
</body>
</html>