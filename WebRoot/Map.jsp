<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My JSP 'ChangePassword.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script>
	function on_submit() {
		if (Trim(form.LoginName.value) == "") {
			alert("登录名不能为空，请输入登录名！");
			form.LoginName.focus();
			return false;
		}
		if (Trim(form.Password1.value) == "") {
			alert("原密码不能为空，请输入密码！");
			form.Password1.focus();
			return false;
		}
		if (Trim(form.Password2.value) == "") {
			alert("新密码不能为空，请输入新密码！");
			form.Password2.focus();
			return false;
		}
		if (Trim(form.Password3.value) == "") {
			alert("请确认密码！");
			form.Password3.focus();
			return false;
		}
			if (Trim(form.Password3.value) != Trim(form.Password2.value)) {
			alert("确认密码与新密码不一致！");
			form.Password3.focus();
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
	function reloadImage(url)   
     {   
  
              document.loginform.validateCode.src = url;   
  
    } 
    function jump()
    {
          window.navigate("index.jsp");
    }
	
</script>
<body background="images/12.jpg">
	<form action="modifyuserdoservlet" name="form" method="post"
		onsubmit="return on_submit();">
		<table width="348" border="0" align="center">
			<tr>
				<td colspan="2" align="center">预测结果将显示于此</td>
			</tr>
			<tr>
				<td align="right"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
	<div align="center"></div>
	<div align="center"></div>
</body>
</html>
