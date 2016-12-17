<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>Knowledge Base Theme</title>

                <link rel="shortcut icon" href="http://localhost:8080/ZhiLiao/images/favicon.png" />

                <!-- Style Sheet-->
                <link rel="stylesheet" href="style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='http://localhost:8080/ZhiLiao/css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='http://localhost:8080/ZhiLiao/css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='http://localhost:8080/ZhiLiao/js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='http://localhost:8080/ZhiLiao/css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' href='../css/article.css?' type='text/css' media='all' />
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



 <div class="myanswer-page-container">
                <div class="page-container">
                	 <article class="type-page hentry clearfix">
					<a href="addFold.jsp">新建收藏夹</a>
                      <ul class="tabs-nav">
                              <li class="active" style=""><a href="#">我的收藏</a></li>
                      </ul>
                    <form action="http://localhost:8080/ZhiLiao/SaveServlet.do?method=deleteFold" method="POST" id="deleteFold">
                     <input type="hidden" id="folderId" name="folderId"> 
                    </form> 
                    <form action="http://localhost:8080/ZhiLiao/SaveServlet.do?method=updateFold" method="POST" id="updateFold">
                    <input type="hidden" id="folderId2" name="folderId2"> 
                    <div id="alert" style=" position:fixed; margin:auto;left:0; right:0; top:0; bottom:0; width:600px;height:400px;display:none;background-color:#eee">
                    <br>
					收藏夹名称:
							<input type="text" name="foldNameChange" id="foldNameChange"/>
					<br>
					
					收藏夹描述：			
								<textarea id="foldDesChange" 
			                                  name="foldDesChange" style="height: 100px; margin: 0 auto;">
								</textarea> 
								<br>
								<br>
					权限：
								<input type="checkbox" name="is" value="1">公开
								<input type="checkbox" name="is" value="0">私密
								<br>
								<br>
								 <input  type="submit" value="提交">
								 <br>
								 <input  type="button" onclick="cancelUpdate" value="取消">
                    </div>
                    </form>
                     <c:forEach items= "${sessionScope.myfolds }" var="fold">
                     
                    
                      	<article class="format-standard type-post hentry clearfix">
                            <header class="clearfix">
                            		                                                       
                                    <h5>
                                   			<img src="http://localhost:8080/ZhiLiao/images/fold.png">&nbsp;&nbsp;
                                            <!-- <a href="single.html">提问者</a>  -->
                                            &nbsp;&nbsp;<a>${fold.foldName } </a>
                                    </h5>
                             
                            </header>
                         </article>
                            
                           	<div class="fold-content">
                           	 		${fold.foldDes }
                            
                           	</div>						
							
                                                            
                            <footer>
                            	 <div class="post-meta clearfix">
                                            
                                            <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 条内容</a></span>
                                           
                                           
                                            <span class="deltete-fold" onclick="deleteFold(${fold.foldId})">删除</span>
                                            
                                           
                                            <span class="update-fold" onclick="updateFold(${fold.foldId},'${fold.foldName}','${fold.foldDes}')">修改</span> 
                                 </div>
                            
                            </footer>                     
                    </c:forEach> 
                    
                     </article>
                   </div>  
                                 
                </div>   
                                       <!-- end of page content -->


                                         <!-- start of sidebar -->
    
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>




	
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
<script type="text/javascript">
function deleteFold(id){
	console.log("##################### " +id)
	var r=confirm("确认删除吗？")
	  if (r==true)
	    {
		  document.getElementById("folderId").value=id;//1为你传入的预约单号的ID
		  document.getElementById("deleteFold").submit();
	    }
	  else
	    {
	    console.log("delete cancel")
	    }
}

function updateFold(id,Name,Des){
	document.getElementById('alert').style.display="block";
	document.getElementById("folderId2").value=id;
	document.getElementById('foldNameChange').value= Name;
	document.getElementById('foldDesChange').innerText=Des;
}

function cancelUpdate(){
	document.getElementById('alert').style.display="none";
}

</script>
</body>
</html>