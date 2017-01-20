<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>建筑消防设施维修管理系统</title>
   <script>
	function on_submit() {
		if (Trim(loginform.LoginName.value) == "") {
			alert("登录名不能为空，请输入登录名！");
			loginform.LoginName.focus();
			return false;
		}
		if (Trim(loginform.Password.value) == "") {
			alert("密码不能为空，请输入密码！");
			loginform.Password1.focus();
			return false;
		}
		if (Trim(loginform.Password2.value) == "") {
			alert("验证码不能为空，请输入验证码！");
			loginform.Password2.focus();
			return false;
		}
	}

	function LTrim(str) {
		//去掉字符串 的头空格 
		var i;
		for (i = 0; i < str.length; i++) {
			if (str.charAt(i) != " " && str.charAt(i) != " ")
				break;
		}
		str = str.substring(i, str.length);
		return str;
	}

	function RTrim(str) {
		var i;
		for (i = str.length - 1; i >= 0; i--) {
			if (str.charAt(i) != " " && str.charAt(i) != " ")
				break;
		}
		str = str.substring(0, i + 1);
		return str;
	}

	function Trim(str) {
		return LTrim(RTrim(str));
	}
	
    
	
</script> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/Login.css">

<script type="text/javascript"> 
function changeimg() 
{ 
	var myimg = document.getElementById("code"); 
	now = new Date(); 
	myimg.src="makeCertPic.jsp?code="+now.getTime();
} 
</script>

	
  </head>
  
  <body onload="javascript:changeimg()">
  <center>
  <form action="logincheckservlet" name = "loginform" method= "post" onsubmit = "return on_submit();">
    <table width="960" height="405" background="images/Login.jpg">
  <tr>
    <td align="center" class="title">风机故障预测软件<br></td>
    <td class="title">&nbsp;</td>
    <td colspan="3" class="title">&nbsp;</td>
  </tr>
  <tr>
    <td width="350">&nbsp;</td>
    <td width="317">&nbsp;</td>
    <td colspan="3" class="text">用户登陆</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right" class="text">用户名：</td>
    <td colspan="3"><input name="LoginName" id="UserName" size="30" maxlength="30" height="18" title="输入用户名"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right" class="text">密	码：</td>
    <td colspan="3"><input name="Password" id="Password" size="30" maxlength="30" height="18" title="输入密码" type="password"/></td>
  </tr>
  <tr>
  	<td>&nbsp;</td>
  	<td align="right" class="text"><br></td>
  	<td colspan="3">
  		
      	
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="OK" class="button" id="OK" value="登录"> 
  		</td>
  
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="right" class="text"><br></td>
    <td colspan="2"><br></td>
  </tr>
  <tr>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
   <td  colspan="2" align="left"><br><a href="javascript:changeimg()"></a></td>
 
  </tr>
  <tr>
     <td colspan="3">&nbsp;</td>
    <td width="381"><br></td>
  </tr>
</table>
</form>
</center>
  </body>
</html>
