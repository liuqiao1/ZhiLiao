<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
        <!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
        <!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
        <!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
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
				<% 
					String formAction;
                	String buttonValue;
					if(request.getAttribute("answerWaitToUpdate")==null)
					{
						
						formAction="http://localhost:8080/ZhiLiao/AnswerServlet?method=submitAnswer";
						buttonValue="提交回答";
					
					}
					else{
						//http://localhost:8080/ZhiLiao/AnswerServlet
						formAction="http://localhost:8080/ZhiLiao/AnswerServlet?method=updateAnswer";
						buttonValue="修改回答";
					}
				%>
                <!-- Start of Header -->
                <jsp:include page="/pages/publicTop.jsp"></jsp:include>
                <!-- End of Header -->

                <!-- Start of Search Wrapper -->

                <!-- End of Search Wrapper -->
           
                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">
								<!-- <a href="../AnswerServlet?method=submitAnswer">test write answer</a> -->
								
                                        <!-- start of page content -->
                                        <section class="receptacle">
                                                <!-- start of title content -->
                                                <!-- 取问题标题放置在textarea中 -->
                                        		<div class="atticle_title">
                                        			<img src="http://localhost:8080/ZhiLiao/images/question-blue.png">&nbsp;&nbsp;
                                                	<a class="js-textarea"  
                                                	 name="title" 
                                                	 disabled="disabled"   	
                                                	 style="height: 47px;">
                                                	 ${requestScope.answerWaitToUpdate.question.questionTitle }
                                                	 </a>
                                                </div>
                                                <!-- end of title content -->
                        
                                                <!-- Basic Home Page Template -->
                                                <div class="article_content">
                                                 <%-- <%@include file="../plugin/utf8-jsp/demo.html"%>  --%>
                                                 
                                                 <form action=<%=formAction %> method="POST">
                                                 	 <input name="answerIdInput" type="text" style="display:none;" value=${requestScope.answerWaitToUpdate.answerId } >
	                                                 <textarea id="container" 
	                                                  name="container" style="height: 400px; margin: 0 auto;">
	                                                  ${requestScope.answerWaitToUpdate.answerContent } 
													 </textarea> 
												 
												 <!-- <input type="submit" value="提交">
												 <input type="submit" value="取草稿"> -->
												  <div>		 
												   <input class="" name="isAnoy" type="checkbox">匿名回答
												 <%--   <c:if test="${requestScope.answerWaitToUpdate!=null }"><!-- 当前是修改回答 -->
												   		<input class="btn" name="submit" type="submit" id="submit"  value="确定修改">
												   </c:if>
												   <c:if test=""><!-- 当前是写新回答 -->
												   		<input class="btn" name="submit" type="submit" id="submit"  value="提交回答">
												   </c:if> --%>
												   <input class="btn" name="submit" type="submit" id="submit"  value=<%=buttonValue %>>
												   <input class="btn" name="submit" type="submit" id="submit"  value="取出草稿">
												  </div>
												 </form>                                
    												
												    <!-- 配置文件 -->
												    <script type="text/javascript" src="http://localhost:8080/ZhiLiao/plugin/utf8-jsp/ueditor.config.js"></script>
												    <!-- 编辑器源码文件 -->
												    <script type="text/javascript" src="http://localhost:8080/ZhiLiao/plugin/utf8-jsp/ueditor.all.js"></script>
												    <!-- 实例化编辑器 -->
												    
													<script type="text/javascript">
												        //var ue = UE.getEditor('container');
												        var ue = UE.getEditor('container', {						           
												            //autoHeightEnabled: true,
												            //autoFloatEnabled: true,
												            initialFrameHeight:600
												        });						        
												    </script>      

												                        
                                                </div>  
                                         </section>                                    
                                        <!-- end of page content -->
                                    
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->

                <!-- Start of Footer -->
               <!-- <footer id="footer-wrapper">
                        <div id="footer" class="container">
                                <div class="row">

                                        <div class="span3">
                                                <section class="widget">
                                                        <h3 class="title">How it works</h3>
                                                        <div class="textwidget">
                                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
                                                                <p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. </p>
                                                        </div>
                                                </section>
                                        </div>

                                        <div class="span3">
                                                <section class="widget"><h3 class="title">Categories</h3>
                                                        <ul>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Advanced Techniques</a> </li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Designing in WordPress</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Server &amp; Database</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">Theme Development</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Website Dev</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">WordPress for Beginners</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">WordPress Plugins</a></li>
                                                        </ul>
                                                </section>
                                        </div>

                                        <div class="span3">
                                                <section class="widget">
                                                        <h3 class="title">Latest Tweets</h3>
                                                        <div id="twitter_update_list">
                                                                <ul>
                                                                        <li>No Tweets loaded !</li>
                                                                </ul>
                                                        </div>
                                                       
                                                </section>
                                        </div>

                                        <div class="span3">
                                                <section class="widget">
                                                        <h3 class="title">Flickr Photos</h3>
                                                        <div class="flickr-photos" id="basicuse">
                                                        </div>
                                                </section>
                                        </div>

                                </div>
                        </div>-->
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
                <script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='js/jflickrfeed.js'></script>
				<script type='text/javascript' src='js/jquery.liveSearch.js'></script>
                <script type='text/javascript' src='js/jquery.form.js'></script>
                <script type='text/javascript' src='js/jquery.validate.min.js'></script>
                <script type='text/javascript' src='js/custom.js'></script>
                <script src="../plugin/utf8-jsp/ueditor.parse.js"></script>
  		        <!-- uparse('.article_content',{
		        	rootpath:'../plugin/utf8-jsp'
		        }) -->
        </body>
</html>