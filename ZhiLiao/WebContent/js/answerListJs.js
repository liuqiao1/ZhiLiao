$(document).ready(function(){
  $("#showCmt").click(function(){
	  //$("p").toggle();
	  //alert("you clicked!");
	  $(".comment-list ").toggle()	  
  });
  
  $(".writeCmtBack").click(function(){
	  //$("p").toggle();
	  //alert("you clicked writeCmtBack!");
	  $(".cmtBack ").toggle()	  
  });
  
  $("#btn").click(function(){
	    alert("clicked!");
  });
	
	
/*$.fn.expandable = function(config) {
	  var that = $(this);
	  var isExpand = false;
	  var btnStr = '展开';
	  var summaryCharLen = 300;
	  
	  var content = that.text();
	  alert(content);
	  var summary = content.substr(0, summaryCharLen);

	  that.text(summary + '...');

	  var btn = $('<div>' + btnStr + '</div>').click(function(e) {
	    var target = $(this).prev();
	    if (isExpand) {
	      target.text(summary + '...');
	      $(this).text('展开');
	    } else {
	      target.text(content);
	      $(this).text('关闭');
	    }
	    isExpand = !isExpand;
	  }).insertAfter(that).addClass('toggle-btn');
	};

	$('.content').expandable();  */
  
  /*var id=$(".content-summary a").attr("id");
  alert(id);
  $(id).click(function(){
	  alert("323");
	  $(".answer-content-details").toggle();
  });*/
  
  $(".content-summary a").each(function(){
	  
	  var id="#" + $(this).attr("id") + "div";
	  $(this).click(function(){
		  //alert($(this).text());
		  /*$(".answer-content-details").toggle();*/ 
		  $(id).toggle();
		  /*$(this).parent().toggle();*/
		  if($(id).is(":hidden")){
			  //当前是hide状态
			  $(this).text("展开");
			 }else{
			  //当前是show状态
			  $(this).text("收起");
			 }
	  });
  });
  
 
  
});