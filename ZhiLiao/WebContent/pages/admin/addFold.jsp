<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>Knowledge Base Theme</title>

                <link rel="shortcut icon" href="../images/favicon.png" />

                <!-- Style Sheet-->
                <link rel="stylesheet" href="style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='http://localhost:8080/ZhiLiao/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='http://localhost:8080/ZhiLiao/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='http://localhost:8080/ZhiLiao/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='http://localhost:8080/ZhiLiao/css/main5152.css?ver=1.0' type='text/css' media='all' />
                
                <link rel='stylesheet' id='custom-css-css'  href='http://localhost:8080/ZhiLiao/css/custom5152.html?ver=1.0' type='text/css' media='all' />
				

                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script>
                <![endif]-->
</head>
<body>


				<!-- Start of Header -->
                <jsp:include page="/pages/publicTop.jsp"></jsp:include>
                <!-- End of Header -->
					<form action="http://localhost:8080/ZhiLiao/SaveServlet.do?method=addFold" method="POST">
					<br>
					收藏夹名称:
							<input type="text" name="title"/>
					<br>
					
					收藏夹描述：			
								<textarea id="" 
			                                  name="desc" style="height: 100px; margin: 0 auto;">
								</textarea> 
								<br>
								<br>
					权限：
								<input class="" type="checkbox" name="is">公开
								<!--<input type="checkbox" name="is" value="0">私密  -->
								<br>
								<br>
								 <input  type="submit" value="提交">
					</form>
					
					
								 
												 
												 
												
</body>
</html>