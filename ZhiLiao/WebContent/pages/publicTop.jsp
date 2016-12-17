<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>Knowledge Base Theme</title>

                <link rel="shortcut icon" href="images/favicon.png" />
                
                <!-- Style Sheet-->
                <link rel="stylesheet" href="style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='http://localhost:8080/ZhiLiao/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='http://localhost:8080/ZhiLiao/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='http://localhost:8080/ZhiLiao/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='http://localhost:8080/ZhiLiao/css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='custom-css-css'  href='http://localhost:8080/ZhiLiao/css/custom5152.html?ver=1.0' type='text/css' media='all' />


                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script></script>
                <![endif]-->
</head>
<body>
<!-- Start of Header -->
                <div class="header-wrapper">
                        <header>
                                <div class="container">


                                        <div class="logo-container">
                                                <!-- Website Logo -->
                                                <a href="index-2.html"  title="Knowledge Base Theme">
                                                        <img src="http://localhost:8080/ZhiLiao/images/logo.png" alt="Knowledge Base Theme">
                                                </a>
                                                <span class="tag-line">Premium WordPress Theme</span>
                                        </div>


                                        <!-- Start of Main Navigation -->
                                        <nav class="main-nav">
                                                <div class="menu-top-menu-container">
                                                        <ul id="menu-top-menu" class="clearfix">
                                                                <li class="current-menu-item"><a href="http://localhost:8080/ZhiLiao/index.jsp">首页</a></li>
                                                                <li><a href="http://localhost:8080/ZhiLiao/pages/admin/qSubmit.jsp">提问</a></li>
                                                                <li><a href="http://localhost:8080/ZhiLiao/pages/admin/myProfile.jsp">我的主页</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="http://localhost:8080/ZhiLiao/AnswerServlet?method=showMyAnswers">我提的问题</a></li>
                                                                                <li><a href="http://localhost:8080/ZhiLiao/AnswerServlet?method=showMyAnswers">我的回答</a></li>
                                                                                <li><a href="http://localhost:8080/ZhiLiao/SaveServlet.do?method=showMyFolds">我的收藏</a></li>
                                                                        </ul>
                                                                </li>
                                                                <!--<li><a href="articles-list.html">Articles List</a></li>-->
                                                                <li><a href="faq.html">FAQs</a></li>
                                                                <!-- <li><a href="#">皮肤</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="blue-skin.html">Blue Skin</a></li>
                                                                                <li><a href="green-skin.html">Green Skin</a></li>
                                                                                <li><a href="red-skin.html">Red Skin</a></li>
                                                                                <li><a href="index-2.html">Default Skin</a></li>
                                                                        </ul>
                                                                </li> -->
                                                                <!-- <li><a href="#">More</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="full-width.html">Full Width</a></li>
                                                                                <li><a href="elements.html">Elements</a></li>
                                                                                <li><a href="page.html">Sample Page</a></li>
                                                                        </ul>
                                                                </li> -->
                                                                <li><a href="http://localhost:8080/ZhiLiao/pages/admin/contact.jsp">联系我们</a></li>
                                                                <c:if test="${not empty sessionScope.loginUser }"><li><a href="user?action=userExit">退出</a></li></c:if>
                                                        </ul>
                                                </div>
                                        </nav>
                                        <!-- End of Main Navigation -->

                                </div>
                        </header>
                </div>
                <!-- End of Header -->
				<script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jflickrfeed.js'></script>
				<script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jquery.liveSearch.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jquery.form.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/jquery.validate.min.js'></script>
                <script type='text/javascript' src='http://localhost:8080/ZhiLiao/js/custom.js'></script>
               
</body>
</html>