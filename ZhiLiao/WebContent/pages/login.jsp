<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>知乎 - 与世界分享你的知识、经验和见解</title>
<link href="http://localhost:8080/ZhiLiao/css/common.css" rel="stylesheet" type="text/css"/>
<link href="http://localhost:8080/ZhiLiao/css/login.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
function checkForm(){
	// 校验用户名:
	// 获得用户名文本框的值:
	var username = document.getElementById("username").value;
	if(username == null || username == ''){
		alert("用户名不能为空!");
		return false;
	}
	// 校验密码:
	// 获得密码框的值:
	var password = document.getElementById("password").value;
	if(password == null || password == ''){
		alert("密码不能为空!");
		return false;
	}
       
	document.forms[0].action="user?action=userLogin";
	document.forms[0].submit();
	return true;
}

  $(document).ready(function(){
  $("#btn").click(function(){
	  alert("hi!");
  	  $("#qqBox").toggle();
  });
});
</script>

</head>
<body>
<div class="container login"  >
	<h1 class="title">知了</h1>
    <form action=" "  method="post"  onsubmit="return checkForm();">
	<div class="main">
    
    	<div class="group-inputs">
			<div class="input-wrapper">
			
            	<input type="text" id="username" name="username" class="text" maxlength="20" placeholder="输入用户名">
            </div>
			<div class="input-wrapper">
        		<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" placeholder="输入密码"><br /><br />
        	</div>
        </div>
        
        <div class="group-opt">
			<!--<input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">记住用户名-->
            <button class="sign-button" type="submit" onClick="javascript:checkForm()">登录</button>
		</div>
          
        <div class="foot">
        	<!--<h4>社交账号登陆</h4><br />-->
            <p><a id="showQQ">社交账号登陆</a></p><br />
            <p><a href="checkEmail.jsp">忘记密码？</a></p><br />	
        	<p><font color="#FF0000">还没有账号？</font><a href="regist.jsp"> 点此注册</a></p>	
            <div class="qqBox"><img src="http://localhost:8080/ZhiLiao/images/qq.13f40.png" /></div>
        </div>
    </div>
      </form> 
</div>

<!--<input type="button" value="sb" id="btn"/>-->

<div class="container footer">
	<div class="span24">
		<div class="copyright">Copyright © 2016-2020 知了论坛  版权所有</div>
	</div>
</div>

 <!-- script -->
                <script type='text/javascript' src='../js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='../js/jquery.easing.1.34e44.js?ver=1.3'></script>
                <script type='text/javascript' src='../js/prettyphoto/jquery.prettyPhotoaeb9.js?ver=3.1.4'></script>
                <script type='text/javascript' src='../js/jquery.liveSearchd5f7.js?ver=2.0'></script>
				<script type='text/javascript' src='../js/jflickrfeed.js'></script>
                <script type='text/javascript' src='../js/jquery.formd471.js?ver=3.18'></script>
                <script type='text/javascript' src='../js/jquery.validate.minfc6b.js?ver=1.10.0'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/custom5152.js?ver=1.0'></script>

</body></html>