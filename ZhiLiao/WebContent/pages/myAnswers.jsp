<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my answers</title>
<!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <link rel="shortcut icon" href="../images/favicon.png" />              

                <!-- Style Sheet-->
                <link rel="stylesheet" href="style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='../css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='../css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='../js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='../css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='custom-css-css'  href='../css/custom5152.html?ver=1.0' type='text/css' media='all' />


                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script></script>
                <![endif]-->

</head>
<body>
<!-- Start of Header -->
				<!-- <input type="button" value="sb" id="btn"> -->
                <div class="header-wrapper">
                        <header>
                                <div class="container">


                                        <div class="logo-container">
                                                <!-- Website Logo -->
                                                <a href="index-2.html"  title="Knowledge Base Theme">
                                                        <img src="../images/logo.png" alt="Knowledge Base Theme">
                                                </a>
                                                <span class="tag-line">Premium WordPress Theme</span>
                                        </div>


                                        <!-- Start of Main Navigation -->
                                        <nav class="main-nav">
                                                <div class="menu-top-menu-container">
                                                        <ul id="menu-top-menu" class="clearfix">
                                                                <li class="current-menu-item"><a href="index-2.html">首页</a></li>
                                                                <li><a href="home-categories-description.html">提问</a></li>
                                                                <li><a href="home-categories-articles.html">我的主页</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="blue-skin.html">我提的问题</a></li>
                                                                                <li><a href="green-skin.html">我的回答</a></li>
                                                                                <li><a href="red-skin.html">我赞过</a></li>
                                                                                <li><a href="index-2.html">我的评论</a></li>
                                                                                <li><a href="index-2.html">我的收藏</a></li>
                                                                        </ul>
                                                                </li>
                                                                <!--<li><a href="articles-list.html">Articles List</a></li>-->
                                                                <li><a href="faq.html">FAQs</a></li>
                                                                <li><a href="#">皮肤</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="blue-skin.html">Blue Skin</a></li>
                                                                                <li><a href="green-skin.html">Green Skin</a></li>
                                                                                <li><a href="red-skin.html">Red Skin</a></li>
                                                                                <li><a href="index-2.html">Default Skin</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="#">More</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="full-width.html">Full Width</a></li>
                                                                                <li><a href="elements.html">Elements</a></li>
                                                                                <li><a href="page.html">Sample Page</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="contact.html">联系我们</a></li>
                                                        </ul>
                                                </div>
                                        </nav>
                                        <!-- End of Main Navigation -->

                                </div>
                        </header>
                </div>
                <!-- End of Header -->

                <!-- Start of Page Container -->
                <div class="myanswer-page-container">
                <div class="page-container">
                	 <article class="type-page hentry clearfix">

                      <ul class="tabs-nav">
                              <li class="active" style=""><a href="#">我的回答</a></li>
                      </ul>
                      
                      <c:forEach items= "${sessionScope.myAnswers }" var="answer">

                      	<article class="format-standard type-post hentry clearfix">
                            <header class="clearfix">
                            		                                                       
                                    <h5>
                                   			<img src="../images/question-blue.png">&nbsp;&nbsp;
                                            <!-- <a href="single.html">提问者</a>  -->
                                            &nbsp;&nbsp;<a>${answer.question.questionTitle }</a>
                                    </h5>
                             
                            </header>
                            
                            <c:if test="${fn:length(answer.answerContent)>200}">
								<div class="content-summary">
								${fn:substring(answer.answerContent,0,300)}...
                            	<%-- ${answer.answerContent } --%>
                            	<a id=${answer.answerId } class="readmore">展开</a>
                            </div>
                            
                            <div id=${answer.answerId }div class="answer-content-details">
                                 <%-- ${answer.answerContent }  --%>
                                 ${fn:substring(answer.answerContent,200,fn:length(answer.answerContent))} 
                                <%--  <a id=${answer.answerId }s >收起</a>--%>                 
                            </div>
							</c:if>
							
							<c:if test="${fn:length(answer.answerContent)<=200}">
                                 ${answer.answerContent }
                            </c:if>
                            <footer>
                            	 <div class="post-meta clearfix">
                                            <span class="date">发布${answer.answerDate }</span>
                                            
                                            <c:if test="${not empty answer.asLastUpdateDate }">
                                            	<span class="date">最后修改${answer.asLastUpdateDate }</span>
                                            </c:if>
                                            
                                            <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 条评论</a></span>
                                            <span class="like-count">${answer.answerSupport }</span>
                                           <!--  <span class="deltete-answer"><a>删除</a></span>
                                            <span class="like-count"><a>修改</a></span> -->
                                            <a href="../AnswerServlet?method=deleteAnswer&answerId=${answer.answerId }">删除</a>
                                            <a href="../AnswerServlet?method=goEdit&answerId=${answer.answerId }">修改</a>
                                 </div>
                            </footer> 
                            
                         </article>
                      </c:forEach>
                     </article>
                   </div>  
                                 
                </div>
                
                <!-- End of Page Container -->

                <!-- Start of Footer -->

                        <!-- end of #footer -->

                        <!-- Footer Bottom -->
                        <div id="footer-bottom-wrapper">
                                <div id="footer-bottom" class="container">
                                        <div class="row">
                                                <div class="span6">
                                                        <p class="copyright">
                                                                Copyright © 2013. All Rights Reserved by 小知了团队.中南大学
                                                        </p>
                                                </div>
                                                <div class="span6">
                                                        <!-- Social Navigation -->
                                                        <ul class="social-nav clearfix">
                                                                <li class="linkedin"><a target="_blank" href="#"></a></li>
                                                                <li class="stumble"><a target="_blank" href="#"></a></li>
                                                                <li class="google"><a target="_blank" href="#"></a></li>
                                                                <li class="deviantart"><a target="_blank" href="#"></a></li>
                                                                <li class="flickr"><a target="_blank" href="#"></a></li>
                                                                <li class="skype"><a target="_blank" href="skype:#?call"></a></li>
                                                                <li class="rss"><a target="_blank" href="#"></a></li>
                                                                <li class="twitter"><a target="_blank" href="#"></a></li>
                                                                <li class="facebook"><a target="_blank" href="#"></a></li>
                                                        </ul>
                                                </div>
                                        </div>
                                </div>
                        </div>
                        <!-- End of Footer Bottom -->

                </footer>
                <!-- End of Footer -->

                <a href="#top" id="scroll-top"></a>

                <!-- script -->
                <script type='text/javascript' src='../js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='../js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='../js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='../js/jflickrfeed.js'></script>
                <script type='text/javascript' src='../js/jquery.liveSearch.js'></script>
                <script type='text/javascript' src='../js/jquery.form.js'></script>
                <script type='text/javascript' src='../js/jquery.validate.min.js'></script>
                <script type='text/javascript' src='../js/custom.js'></script>
				<script type='text/javascript' src='../js/answerListJs.js'></script>
	</body>
</html>