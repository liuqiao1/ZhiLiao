<%@page import="com.csu.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                <script src="js/html5.js"></script></script>
                <![endif]-->

        </head>
		<%
			HttpSession mySession=request.getSession();
            User loginUser=(User)mySession.getAttribute("loginUser");	
		%>
        <body>

         		<!-- start of Header -->
         		<jsp:include page="/pages/publicTop.jsp"></jsp:include>	
                <!-- End of Header -->

                <!-- Start of Search Wrapper -->
                <div class="search-area-wrapper">
                        <div class="search-area container">
                        
                        <div class="user-image">
                       
                        	<img src="http://localhost:8080/ZhiLiao/images/89842bfa74aa5c9cef3e175f0a41efd3_xl.jpg">
                        </div>
                        
                        <div class="ProfileHeader-content">
                        	<div class="ProfileHeader-contentHead">
                                <h1 class="ProfileHeader-title">
                                    <span class="ProfileHeader-name"><%=loginUser.getUserName() %></span>
                                    <span class="RichText ProfileHeader-headline"><%=loginUser.getSimpleIntro() %></span>
                                <!-- react-empty: 104 -->
                                </h1>
                            </div>
                            <div class="ProfileHeader-contentBody" style="height: 52px;">
                            	<ul>
                                	<li><%=loginUser.getIndustry() %></li>
                                    <li><%=loginUser.getAddress() %></li>
                                    <li><%=loginUser.getSex() %></li>                                  
                                </ul>
                            </div>    
                        </div >
                        
                          
                        </div>
                        
<!--                        <div class="ProfileHeader-footer">
                        	<img src="images/editProfile.png">
                        </div>-->
                        
                        <div class="ProfileHeader-buttons">
                        	<button class="Button Button--blue" type="button">
                            <!-- react-text: 135 -->编辑<!-- /react-text -->
                            <!-- react-text: 136 -->个人<!-- /react-text -->
                            <!-- react-text: 137 -->资料<!-- /react-text -->
                            </button>
                        </div>
                </div>
                <!-- End of Search Wrapper -->

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span12 page-content">

                                                <article class="type-page hentry clearfix">

                                                      
                                                        <ul class="tabs-nav">
                                                                <li class="active" style=""><a href="#">回答</a></li>
                                                                <li><a href="#">提问</a></li>
                                                                <li><a href="#">关注</a></li>
                                                                <li><a href="#">收藏</a></li>
                                                        </ul>

                                                        <div class="tabs-container">
                                                        <div class="tab-content">
                                                        <article class="format-standard type-post hentry clearfix">

                                                        <header class="clearfix">
                                                        		<!--<img src="images/幸福.gif">-->                                                             
                                                                <h5>
                                                               			<img src="../images/testUs.jpg">&nbsp;&nbsp;
                                                                        <a href="single.html">提问者</a> &nbsp;&nbsp;
                                                                        长沙有什么好吃的？
                                                                         
                                                                </h5>
                                                         
                                                        </header>

                                                        <p>Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings, rushing from one thing to another, never pausing and never ending.&nbsp;Then the day is over, and we are exhausted, and we often have very little to show for it. And we start the next . . . <a class="readmore-link" href="http://knowledgebase.inspirythemes.com/integrating-wordpress-with-your-website/">Read more</a></p>
                                                        <footer>
                                                        
                                                        	 <div class="post-meta clearfix">
                                                                        <span class="date">2016-12-11</span>
                                                                      
                                                                        <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 条评论</a></span>
                                                                        <span class="like-count">66 </span>
                                                                </div>
                                                        
                                                        </footer> </article></div>

                                               
                                                                <div class="tab-content">First lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</div>
                                                                <div class="tab-content">Second lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</div>
                                                                <div class="tab-content">Third lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</div>
                                                        </div>

                                                                                                             
 <!--                                                       <h3>Blockquote</h3>
                                                        <blockquote>
                                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.</p>
                                                        </blockquote>

                                                        <h3>Messages</h3>

                                                        <p class="error">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>

                                                        <p class="success">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>

                                                        <p class="info">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>

                                                        <p class="notice">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>-->


                                                </article>
                                        </div>
                                        <!-- end of page content -->

                                </div>
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
                <script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='js/jquery.easing.1.3.js'></script>
                <script type='text/javascript' src='js/prettyphoto/jquery.prettyPhoto.js'></script>
                <script type='text/javascript' src='js/jflickrfeed.js'></script>
                <script type='text/javascript' src='js/jquery.liveSearch.js'></script>
                <script type='text/javascript' src='js/jquery.form.js'></script>
                <script type='text/javascript' src='js/jquery.validate.min.js'></script>
                <script type='text/javascript' src='js/custom.js'></script>

        </body>
</html>

