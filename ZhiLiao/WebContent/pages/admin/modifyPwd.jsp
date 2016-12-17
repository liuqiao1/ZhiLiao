<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>我的主页</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">  
	function checkForm(){
		// 校验用户名:
		// 获得用户名文本框的值:
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			alert("两次密码输入不一致!");
			return false;
		}
	
		document.forms[0].action="user?action=modifyPwd";
		document.forms[0].submit();
		return true;
	}
	
</script>  
</head>
<body>
<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员注册</strong>USER REGISTER
					</div>
					<form id="registerForm" action=" "  method="post"  onsubmit="return checkForm();">
						<table>
							<tbody>
							<tr>
								<th>
									<span class="requiredField">*</span>新密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" />
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>确认新密码:
								</th>
								<td>
									<input id="repassword" type="password" name="repassword" class="text" maxlength="20" />
								</td>
							</tr>				
							<tr>
								<th>&nbsp;
								</th>
								<td>
									<input type="submit" onClick="javascript:checkForm()" id="submit" class="submit" value="确认">
								</td>
							</tr>
						</tbody></table>
						<div class="login">
						<dl>
								<dt>已经修改密码了？</dt>
								<dd>
									立即登录即可体验在线评论！
									<a href="./login.jsp">立即登录</a>
								</dd>
						</dl>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	
	<div class="span24">
		<div class="copyright">Copyright © 2016 -2020 知乎论坛  版权所有</div>
	</div>
</div>
<div id="_my97DP" style="position: absolute; top: -1970px; left: -1970px;"><iframe style="width: 190px; height: 191px;" src="./会员注册 - Powered By Mango Team_files/My97DatePicker.htm" frameborder="0" border="0" scrolling="no"></iframe></div></body></html>