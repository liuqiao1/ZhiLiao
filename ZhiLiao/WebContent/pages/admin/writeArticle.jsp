<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <link rel='stylesheet' id='bootstrap-css-css'  href='../css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='../css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='../js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='../css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' href='../css/article.css?' type='text/css' media='all' />
                <link rel='stylesheet' id='custom-css-css'  href='../css/custom5152.html?ver=1.0' type='text/css' media='all' />
				

                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script>
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
                                                        <img src="../images/logo.png" alt="Knowledge Base Theme">
                                                </a>
                                               <!-- <span class="tag-line">Premium WordPress Theme</span>-->
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

                <!-- Start of Search Wrapper -->

                <!-- End of Search Wrapper -->
              <!--  <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="模板之家">模板之家</a></div>-->
                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">
								<!-- <a href="../AnswerServlet?method=submitAnswer">test write answer</a> -->
								
                                        <!-- start of page content -->
                                        <section class="receptacle">
                                                <!-- start of title content -->
                                        		<div class="atticle_title">
                                                	<textarea class="js-textarea"  
                                                	name="title" 
                                                	autofocus="true" 
                                                	word-min="2" 
                                                	word-max="50"
                                                	 placeholder="请输入标题" s
                                                	 tyle="height: 47px;"></textarea>
                                                </div>
                                                <!-- end of title content -->
                        
                                                <!-- Basic Home Page Template -->
                                                <div class="article_content">
                                                 <%-- <%@include file="../plugin/utf8-jsp/demo.html"%>  --%>
                                                 
                                                 <form action="../AnswerServlet?method=submitAnswer" method="POST">
                                                 <textarea id="container" 
                                                 name="container"style="height: 400px; margin: 0 auto;">
												</textarea> 
												<input type="submit" value="提交">
												 </form>
                                                
    												
												    <!-- 配置文件 -->
												    <script type="text/javascript" src="../plugin/utf8-jsp/ueditor.config.js"></script>
												    <!-- 编辑器源码文件 -->
												    <script type="text/javascript" src="../plugin/utf8-jsp/ueditor.all.js"></script>
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
  		        uparse('.article_content',{
		        	rootpath:'../plugin/utf8-jsp'
		        })
        </body>
</html>
