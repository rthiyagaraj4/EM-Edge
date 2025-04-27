<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.IPADConstants"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.*,java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.pendingresults.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null,pstmt1=null; 
ResultSet rset =null,rsip=null,rset1=null;
Statement stmt = null,stmt1 = null;
String strIPCount = "";
// this code is added specifically for pending results for review
String fromPeriod="";
String toPeriod="";
String selectedPeriod=IPADConstants.LAST_ONE_WEEK;
StringBuffer sqlipcount = new StringBuffer("");

// code modified to get the request parameters in the flow
// of pending results review
String params = request.getQueryString();
params = CommonBean.checkForNull(params);

try{
	String facility_id= (String)session.getValue("facility_id");
    String login_user= (String)session.getValue("login_user");
    String facility_name = "";
    String jdbc_user =  "";
	String jdbc_user_id="";
	String site = "" ;
	if(login_user == null)
	{
		login_user = "";
	}
	String strFromdate = DateUtils.getCurrentDate("DMY", "en");
	String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) reln_req_yn from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P' ";
    String func_role_id="",practitioner_name="",pract_type="";
    con =  ConnectionManager.getConnection(request);
    if(con != null)
    pstmt=con.prepareStatement(sql);
    
    String locale = "en";
    if(pstmt != null)
    {
		pstmt.setString(1,locale);
		pstmt.setString(2,login_user);
		
		rset=pstmt.executeQuery();
    }
	
	if(rset !=null && rset.next())
    {
		func_role_id=rset.getString("func_role_id");
		if(func_role_id == null) func_role_id="";
        
		practitioner_name=rset.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="";
		
		pract_type = rset.getString("pract_type");
		if(pract_type == null) pract_type="";

    }
	if(rset !=null) rset.close();
	if (pstmt!=null) pstmt.close();
	
	 session.putValue("ca_practitioner_id",func_role_id);
	 session.putValue("practitioner_name",practitioner_name);
	 session.putValue("practitioner_type",pract_type);
	 
	 if(con != null)
	 stmt = con.createStatement();
	 
	 rset = null;
	// site = "hi";
	 if(stmt != null)
	 {
	   rset = stmt.executeQuery("SELECT SITE_NAME,DISPLAY_USER_NAME_YN FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' and 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = '"+facility_id+"')") ;//Changed  for PE By Sudhakar
	   //site = "hello";
	 }
	 
	 
	 
	 String display_user_name_yn = "";		 
		if(rset !=null)	{
			if(rset.next()) {
				site = rset.getString("SITE_NAME");
				display_user_name_yn= rset.getString("DISPLAY_USER_NAME_YN");//Changed  for PE By Sudhakar
				
			}
		}
		session.putValue("userSite",site);	
		if(rset !=null) rset.close();
		if (stmt!=null) stmt.close();
		
	    if(con != null)
		pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
	    
	    
		if(pstmt != null)
		{
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,login_user);
			rset = pstmt.executeQuery();
		}
		

		if(rset !=null)	{
			if(rset.next()) {
				jdbc_user = rset.getString("APPL_USER_NAME");
				jdbc_user_id = rset.getString("APPL_USER_ID");
				facility_name = rset.getString("FACILITY_NAME");
			}
		}
		session.putValue("facility_name",facility_name);
		session.putValue("jdbc_user",jdbc_user);
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		
sqlipcount.append("SELECT COUNT (*) Total FROM ip_open_encounter a WHERE a.facility_id = '"+facility_id+"' AND attend_practitioner_id = '"+func_role_id+"' AND patient_class = 'IP'  AND adt_status IN ('00', '01')  AND EXISTS ( SELECT patient_class FROM ca_pract_by_locn_detail o  WHERE facility_id = '"+facility_id +"' AND practitioner_id = '"+ func_role_id +"' ");
sqlipcount.append(" AND locn_type = 'W' AND patient_class = 'IP' AND EXISTS ( SELECT 1   FROM pr_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y'  AND mp_p.patient_id = a.patient_id  AND a.assign_care_locn_code = o.locn_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND a.attend_practitioner_id = '"+ func_role_id +"' AND (a.adt_status IN ('01', '02')))) ");
			
if(con != null)
{
	 stmt1 = con.createStatement();
}
		
		if(stmt1 != null)
		{
			rsip = stmt1.executeQuery(sqlipcount.toString());
		}
		if(rsip != null)
		{
			
			if(rsip.next())
			{
				
				strIPCount = rsip.getString("Total");
			
			}
			rsip.close();
			if ( stmt1 != null ) stmt1.close() ;
			session.putValue("practitioner_id",func_role_id);
			
		}		
	 					
    
%>

<!DOCTYPE html> 
<html> 
<head> 
<title>EM Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />


 
 <!--  
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />  


<link rel="stylesheet" href="../css/iPadBasePage.css" />  
<link rel="stylesheet" href="../css/ipad.css" />


<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

<script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script> 

-->
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  


<link rel="stylesheet" href="../css/iPadBasePage.css" />  
<link rel="stylesheet" href="../css/ipad.css" />


   

<script src="../jquery.mobile-1.0a4.1.min.js"></script> 


 <!--  <script type="text/javascript" src="iscroll-lite.js"></script> 
 <Script Language="JavaScript" src="../eCommon/js/common.js"></Script>
 <script type='text/javascript' src="../eCommon/js/DateUtils.js"></script>
 mootools-core-1.4.5-full-compat.js
  -->
<!--  <script src="mootools-core-1.4.5-full-compat.js"></script>  -->



<script type="text/javascript">


</script>

<script type="text/javascript">
function scrolTop()
{
	  //alert("helloj");
	  $.mobile.silentScroll(-2000);
}
/*
window.addEventListener("load",function() {
	// Set a timeout...
	//alert("hi");
	setTimeout(function(){
		// Hide the address bar!
		window.scrollTo(0, 1);
	}, 0);
});

*/
//$.pageLoading();
/*
$("#page1").bind("pagecreate", function() {
	// Asynchronously include a footer template
//$.mobile.loadingMessage = 'Loading...';	
showLoadingMsg();
//alert("hit");
	})
*/
//---------end---------
/*
 $(document).bind("swipe", function(event, data){
	 //alert("hi")
	event.preventDefault();	
 });
*/
 $(document).bind("mobileinit", function () {
     // As of Beta 2, jQuery Mobile's Ajax navigation does not work in all cases (e.g.,
     // when navigating from a mobile to a non-mobile page, or when clicking "back"
     // after a form post), hence disabling it.
    // $.mobile.ajaxEnabled = false;
      $.mobile.loadingMessage = 'Loading...';
     // alert("hi");

 });
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
 <script>
 /*
$(document).bind("mobileinit", function(){
  $.mobile.touchOverflowEnabled = true;
});
 */
 /*
 var theScroll;
 var ifrScroll;

 function scroll() {
    // theScroll = new iScroll('wrapper');
      theScroll = new iScroll('ulUsers', {
    		//snap: true,
    		//momentum: false,
    		hScrollbar: false});
    		//vScrollbar: false });

    // ifrScroll = new iScroll('divcnt');
     
 }
*/
 //document.addEventListener('DOMContentLoaded', scroll, false);

</script>
<script>

var bclick = false;
var bShPatients = true;
var bShUsers = true;
//frameloaded();
    $(document).ready(function () {
    	//$.mobile.touchOverflowEnabled = true;
    	  $(document).bind("swipe", function(event, data){
    		// alert("hiii")
    		event.preventDefault();	
    	 });
    	 /*
    	  if (window.DeviceOrientationEvent) {  window.addEventListener('orientationchange', myOrientResizeFunction, false);}
    	  
    	  function myOrientResizeFunction(orientation){     
    		 // alert(Math.abs(window.orientation));
    		 
    		   var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
    		    
    		  }
    	 */ 
    	
    	/*
    	  $.mobile.orientationChangeEnabled = true;
    	 
    	  $("#page1").bind("orentationchange", function(orientation) {
    			alert("hellooo");
    		});
    	 
    	  */
    	
    	// $('#divView').load('AppView.jsp', function() {
   		 // alert('Load was performed.');
   		//});
    	// scroll();
    	// theScroll = null;
  /*
    	 $(document).scroll(function(){
		// alert("hig");
         if ($(window).scrollTop() + $(window).height() -20 == $(document).height() -20 )
         {
             
           document.getElementById("selectionFromFrame").contentWindow.test();
            // $('#divView').append(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML);
             //document.getElementById("selectionFromFrame").contentDocument.body.innerHTML =  document.getElementById("selectionFromFrame").contentDocument.body.innerHTML +  document.getElementById("selectionFromFrame").contentDocument.body.innerHTML;
         }
     });
   	*/
    	//theScroll.destroy();
//alert(window.screen.availWidth);
    	 //-----------------------
    	 
    	jQuery.fn.oneFingerScroll = function() { 
    	    var scrollStartPos = 0; 
    	    var scrollLast = 0;
    	    $(this).bind('touchstart', function(event) { 
    	        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get 'touches' 
    	        var e = event.originalEvent; 
    	       // alert($(this).scrollTop() );
    	        scrollStartPos = $(this).scrollTop() + e.touches[0].pageY;
    	       // scrollLast = event.touches[0].pageY;

    	     //   $('#divscr').html ("scroostartpos111=" + scrollStartPos );
    	       // e.preventDefault(); 
    	    }); 
    	    $(this).bind('touchmove', function(event) { 
    	        var e = event.originalEvent; 
    	       // alert(scrollStartPos - e.touches[0].pageY);
    	      //  $(this).scrollTop(scrollStartPos - e.touches[0].pageY);
    	       //$(this).scrollSpeed (event.touches[0].pageY-scrollLast);
    	       var nscroll = (scrollStartPos - e.touches[0].pageY) ;
    	       if(nscroll == $(document).height()){
    	    	   nscroll = e.touches[0].pageY;
    	       }
    	     /*
    	            if(nscroll > 0)
    	    	   {
    	            	nscroll = nscroll * 3;
    	    	   }
    	            else
    	            	{
    	            	nscroll = nscroll / 3;
    	            	}
    	      
    	         */   
    	      $(this).scrollTop(nscroll); 
    	     // $('#divscr').append ("<br>" +  "scroostartpos=" + scrollStartPos + "pagey=" + e.touches[0].pageY + "scrolltop=" + $(this).scrollTop() + "</br>");
    	     // $('#divscr').append ("<br>" +  "windowtop=" + $(window).scrollTop() + "windowheight=" + $(window).height() + "documentheight=" + $(document).height() + "</br>");
    	     // alert( e.touches[0].pageY);
    	      //alert(scrollStartPos);
    	    //  scrollStartPos = e.touches[0].pageY;
    	        e.preventDefault(); 
    	    }); 
    	    return this; 
    	}; 

    	 
    //	$('#wrapper').oneFingerScroll(); 
    //	$('#ul1').oneFingerScroll(); 
    	 
    	 //---------------------------
    	 jQuery.fn.scrollStop = function() { 
    	    var scrollStartPos = 0; 
    	    var scrollLast = 0;
    	    $(this).bind('touchstart', function(event) { 
    	        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get 'touches' 
    	        var e = event.originalEvent; 
    	       
    	       // e.preventDefault(); 
    	    }); 
    	    $(this).bind('touchmove', function(event) { 
    	        var e = event.originalEvent; 
    	       
    	        e.preventDefault(); 
    	    }); 
    	    return this; 
    	}; 
    	 //-----------------------
    	/* 
 $('#selectionFromFrame').one('readyState', function(){
        
    	  alert('loaded');  
    	})
     
*/

		$('#tdToggle').tap(function(){
			hideFooter();
			slidee("false");
			showIcon();
		});


	/*
		$('#tdToggle').touchstart(function(){
			//alert("ghg");
			if(bclick)
				{
				document.getElementById("imgIcon").src ="../images/Arrow-Close-Touch.png" 
				}
			else
				{
				  document.getElementById("imgIcon").src ="../images/Arrow-Open-Touch.png" 
				}
			
			
		});
		
		
		$('#tdToggle').touchend(function(){
			//alert("end");
			slidee("false");
			//document.getElementById("imgIcon").src ="Arrow-Open-Normal.png"
			showIcon();
				
			
		});
		 
		*/
		//$('#tabSlide').tap(function () {
			//$('#tdimg').css("background-color", "white");
			//alert('hi');
			
		//	$('#wrapper').load(function() {    
			//document.getElementById("wrapper").style.height = "354px"; //(document.body.offsetHeight -30) + 'px';
			//alert($(window).height());
			//alert($(document).height());
			//alert(document.body.offsetHeight);
			
			
			//}
			//); 
		    //document.addEventListener('DOMContentLoaded', scroll, false);
		   
			//slidee("false");
		   /*
			if(!bclick)
				{
			      $('#divcontent').animate({width:"32%"},'fast');
		          $('#dvmain').animate({left:"32%"},'fast');
		         // $('#divframe').scrollStop();
		
		          bclick = true;
				}
			else
				{
		          $('#divcontent').animate({width:"0%"},'fast');
		          $('#dvmain').animate({left:"0%"},'fast');
		        //  $('#divframe').unbind("touchmove");
		          bclick = false;
				}
		   // $('#dvmain').animate({width:"20%"});
		  //  $('#dvmain').animate({float:right});
		  */
		
		       // }); 
		        
		       
		
		 
		/*
		$('#menu3').click(function () {
			tabmain
			tdslide
		    $('#div3').slideToggle('fast');
		        })
		*/
		        //----
		        /*
		        $('#div1').live("swipe", function() {
		        	// Get the current page number from the id and increment it by 1.
		        	//alert('hi');
		        	});
		        */
  }); //end of document ready
    function slidee111(strChild)
    {
    //	$('#tdimg').animate({backgroundcolor:"white"},500);
    	if(strChild == "true")
    		{
    		bclick = true;
    		}
    	if(!bclick)
		{
    		//scroll();
        	// theScroll = null;
        	//document.getElementById("divView").style.position = "fixed";
        	//document.getElementById("wrapper").style.position = "fixed";
        	//document.getElementById("page1").style.position = "fixed";
        //	style = "position:fixed"
           //   $('#divheader').animate({width:"100%"},'fast');
	      $('#divcontent').animate({width:"35%"},'fast');
	    	
          $('#dvmain').animate({left:"35%"},'fast');
          $('#dvmain').animate({width:"65%"},'fast');
        //  $('#tdimg').css("background-color", "#2088cf");
      //  $('#tdimg').animate({backgroundcolor:"#2088cf"},20);
         // $('#dvmain').animate({width:"80%"},'fast');
         
        //  $('#divframe').scrollStop();

          bclick = true;
		}
	else
		{
		//document.getElementById("wrapper").style.position = "";
		//document.getElementById("divView").style.position = "";
		//document.getElementById("page1").style.position = "";
          $('#divcontent').animate({width:"0%"},'fast');
       
          $('#dvmain').animate({left:"0%"},'fast');
          $('#dvmain').animate({width:"100%"},'fast');
        //  $('#divheader').animate({width:"100%"},'fast');
        //  $('#tdimg').css("background-color", "#2088cf");
           // $('#tdimg').animate({backgroundcolor:"#2088cf"},20);
          //$('#divframe').unbind("touchmove");
          if( theScroll != null)
        	  {
                //theScroll.destroy();
        	  }
          bclick = false;
		}
  }

  function slidee(strChild) {
     
	 // hideFooter();
      if (strChild == "true") {
          bclick = true;
      }
      if (!bclick) {
          /*
          $('#divcontent').animate({ width: "35%" }, 'fast');
          */
         // $('#dvmain').animate({ left: "35%" }, 'fast');
         // $('#dvmain').animate({float: "right" }, 'fast');
         
        $('#dvmain').animate({ left: "30%" }, 'fast');
          $('#dvmain').animate({ width: "70%" }, 'fast');
         $('#divcontent').animate({ width: "30%" }, 'fast');
        // $('#divcontent').animate({ left: "0%" }, 'fast');
         
          //alert("hii");
       //  document.getElementById("divcontent").style.display = "block";
          bclick = true;
         // document.getElementById("divView").style.position = "fixed";
          
        //  $('#divcontent').slideToggle('fast');
      }
      else {
          /*
          $('#divcontent').animate({ width: "0%" }, 'fast');

          $('#dvmain').animate({ left: "0%" }, 'fast');
          $('#dvmain').animate({ width: "100%" }, 'fast');
        
         
          bclick = false;
          */
         	 bclick = false;
       //   $('#divcontent').slideToggle('fast');
        
	        $('#divcontent').animate({ width: "0%" }, 'fast');
	       // $('#divcontent').animate({ left: "-31%" }, 'fast');
	          $('#dvmain').animate({ width: "100%" }, 'fast');
	         // document.getElementById("divView").style.position = "";
	            //$('#divcontent').slideToggle('fast');
         // $('#dvmain').css("float","right");
         // $('#dvmain').animate({float: "right" }, 'fast');
      }
     showFooter();
  }
    function showUsersList() {
        //  $("#td1").hide("medium");
        $("#dvUsersList").toggle("fast");
    }
    function showDivPatList() {
        //  $("#td1").hide("medium");
      //  alert();
        $("#dvPatList").toggle("fast");
      //  touchScroll("wrapper");
    }
    function showLoadingMsg()
    {
    	 //$.mobile.loadingMessage = 'Loading...';
    	//hideFooter();
    	$.mobile.pageLoading();
    }
    function HideLoadingMsg()
    {
    	// showFooter();
    	 $.mobile.pageLoading(true);
    }
    function showOP()
    {
    	/*
    	$('#divframe').load('AppView.jsp', function() {
    		  alert('Load was performed.');
    		});
    	*/
    	
    	//$('#divframe').html("hello")
    	//$('#divframe').html($('#selectionFromFrame').html());
    	//alert(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML)
    	
    	//$('#divframe').html(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML);
    	//theiFrameObject.contentDocument.body.innerHTML
    	//document.getElementById("divframe").innerHTML = "LOADING........"
    	// document.getElementById("selectionFromFrame").src="AppView.jsp";
    	 
    	 //document.getElementById("divframe").innerHTML = document.getElementById("selectionFromFrame").contentDocument.body.innerHTML;
    	// alert(document.getElementById("divframe").innerHTML);
    	//alert(document.body.height);
      //eve   document.getElementById("selectionFromFrame").contentDocument.body.innerHTML = "";//"LOADING OutPatients......."
          
        // $.mobile.showPageLoadingMsg();
         
         showLoadingMsg();


    	//eve document.getElementById("selectionFromFrame").src="OP.jsp";
    	 
    	 
    	 /*
    	 $('#divframe').load('AppView.jsp',
    	 
    			 function() {
    		  
    		});
    	 */
    	// alert(document.getElementById("selectionFromFrame").readyState);
    	/*
    	 if (document.getElementById("selectionFromFrame").readyState == "complete"){       
    		 alert("Iframe is now loaded.");  
    		 document.getElementById("divframe").innerHTML = document.getElementById("selectionFromFrame").contentDocument.body.innerHTML;
    		 
    	 } 
    	*/
    	 
    	 
    	slidee("false");
    	
    	showIcon();
    	
    	//frameloaded();
    	//alert($(this));
    	// $(this).removeClass("ui-btn-active").addClass("ui-btn-hover-a");
    	 //.addClass('ui-state-disabled'); 
    	
    }
    function showIcon()
    {
    	if(bclick)
    	{
    	document.getElementById("imgIcon").src ="../images/Arrow-Close-Normal.png" ;
    	}
    else
    	{
    	  document.getElementById("imgIcon").src ="../images/Arrow-Open-Normal.png" ;
    	}
    }
    function showIP()
    {
    	//alert("hello")
    	//$(this).highlight('#ddf');
    	var x = 100;
    //	var folioChange = new Fx.Tween('aIP', {duration:1200});
    	//folioChange.start('left',x);
    	//folioChange.highlight('#ddf', '#ccc');
         document.getElementById("hdnPatClass").value = "IP";
         document.getElementById("selectionFromFrame").contentDocument.body.innerHTML = "<div style='height:1000px'>&nbsp;</div>";
         //$.mobile.loadingMessage = 'loading';
          showLoadingMsg();
    	 document.getElementById("selectionFromFrame").src="IP.jsp";
    	/*
    	 $('#divView').load('IP.jsp', function() {
  alert('Load was performed.');
    });
    	*/ 
    	slidee("false");
    	showIcon();
    	//document.getelementById("divView").style.height = "auto";
    	//frameloaded();
    
    	
    }
    
    function showAppList()
    {
    	//document.getElementById("divframe").innerHTML = "LOADING........"
    	 //$(this).css("background-color", "#eeeeee");
    	//document.getElementById("selectionFromFrame").contentDocument.body.innerHTML = "";
    	showLoadingMsg();
    	//document.getElementById("selectionFromFrame").contentDocument.body.innerHTML = "<table border = '1' style='width:100%;height;1000px'><tr style='width:100%;height;1000px'><td style='width:100%;height;100%' align = 'center' valign = 'Bottom'>LOADING AppointmentList.......</td></tr></table>"
    //	document.getElementById("selectionFromFrame").src="AppView.jsp";
    		slidee("false");
    		showIcon();
    		//$(this).highlight('#ddf');

    	/*
    		$('#divframe').load('AppView.jsp', function() {
      		  alert('Load was performed.');
      		});
    	*/
    		//$('#divframe').append(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML);
    	/*
    	$('#divframe').append("<div id = 'divcnt' data-role = 'content' class = 'divcontent' > <ul data-role='listview' >  <li class ='ui-btn-text-data' ><a href='#' ><img src='hanuman-blessing.jpg'></img> <summary><span class='lz-list-label-Patient'>Rtntest50a Rtntest50b  Rtntest50c</span>&nbsp;&nbsp;&nbsp;<span class = 'eh-pat-id'>G200001058</span></summary><ul style='list-style-type: none'> <li class='leftUl'> <p> <span class='lz-list-label'></span><span class='lz-list-data'> &nbsp;</span></p> </li> </ul><ul style='list-style-type: none' ><li class='leftUl'><p><span class='lz-list-label'>Appt No: &nbsp;</span><span class='lz-list-data'>15559</span></p><p><span class='lz-list-label'>Practitioner:&nbsp;</span><span class='lz-list-data'>Afida Bt Khalib, Dr ,Afida Bt</span></p></li> </ul> </a></li></ul></div>");
    		document.getElementById("divframe").style.display = "block";
    		document.getElementById("selectionFromFrame").style.display = "none";
    		*/
    	
    	//frameloaded();
    		
    }
   
   function frameloaded()
   {
	  // $('#selectionFromFrame').ready(function(){
		  // alert("hi");
		//  $.mobile.pageLoading(true);
		  // document.getElementById("divframe").innerHTML = document.getElementById("selectionFromFrame").contentDocument.body.innerHTML;
		   //alert(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML);
			//alert('loaded');
			//alert(document.getElementById("selectionFromFrame").contentDocument.body.offsetHeight);
			//documnet.getElementByID("divView").style.height = document.getElementById("selectionFromFrame").contentDocument.body.offsetHeight;
			//$('#divframe').append(document.getElementById("selectionFromFrame").contentDocument.body.innerHTML);
			//alert(document.getElementById("divframe").innerHTML);
	  //  });
   }
   function logOff()
   {
	   var 	xmlHttpObj;
	   if (navigator.appName.indexOf("Internet") == -1) {
			xmlHttpObj = new XMLHttpRequest();
			//var oParser = new DOMParser();
			//xmlDoc = oParser.parseFromString(xmlStr, "text/xml");
		} else {
			xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
			//xmlDoc = new ActiveXObject("Microsoft.XMLDom");
			//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		}  
		
	   xmlHttpObj.open("POST", "../jsp/Logoff.jsp", true);
	   xmlHttpObj.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	   var sendString = "logoff=true";
	   xmlHttpObj.send(sendString);
   }
   
   function logout()
   {
	   logOff();
	   window.location ="../html/loginIpad.html";
   }
   function showPatients()
   {
	 //  $('#ulwrapper').toggle('fast');
	   
	   $("#ulwrapper").toggle("fast");
	   
	   if(!bShPatients)
	   {
			   bShPatients = true;
			   document.getElementById("imgPat").src = "../images/Heading-Panel-Up-Arrow.png" ;
	   }
	   else
	   {
			   bShPatients = false;
			   document.getElementById("imgPat").src = "../images/Heading-Panel-down-Arrow.png";
	   }
	   
   }
   function showUsers()
   {
	 //  $('#ulwrapper').toggle('fast');
	   
	   $("#ulUsers").toggle("fast");
	   
	   if(!bShUsers)
		   {
		   bShUsers = true;
		   document.getElementById("imgUsers").src = "../images/Heading-Panel-Up-Arrow.png" ;
		   }
	   else
		   {
		   bShUsers = false;
		   document.getElementById("imgUsers").src = "../images/Heading-Panel-down-Arrow.png";
		   }
	   
   }
   function showFirstPage()
   {
	 showLoadingMsg();
	 
	 // code added to check if the request parameters passed and 
	 // stored as hidden variable is not empty
	 var hdnParamComp = document.getElementById("hdnParams");
	 var params = "";
	 if(hdnParamComp){
		 params = hdnParamComp.value;
	 }
	 
	 if(params.length > 0){
		 document.getElementById("selectionFromFrame").src = "PendingResults.jsp?"+params;
		 HideLoadingMsg();
	 }else{
		 document.getElementById("selectionFromFrame").src = "IP.jsp";	 
		 slidee("false");
		 showIcon();
	 }
	 	 
	 
		 //document.body.style.scrollbarBaseColor='#E2E3F0';
   }
   function loadwidgets(patientID,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)
   {
	  // alert(episodeId);
	   document.getElementById("hdnPatientId").value = patientID;
	   document.getElementById("hdnEpisodeId").value = episodeId;
	   document.getElementById("hdnAdmitDate").value = admitDate;
	   document.getElementById("hdnDischargeDateTime").value = dischargeDateTime;
	   document.getElementById("hdnLocnType").value = locnType;
	   document.getElementById("hdnLocnCode").value = locnCode;
	   document.getElementById("hdnServiceCode").value = servicecode;
	  // alert(document.getElementById("hdnPatientId").value);
	   document.getElementById("frmIcontent").submit();
   }
   function showFooter()
   {
	   document.getElementById("divFooter").style.display = "block";
   }
   function hideFooter()
   {
	   document.getElementById("divFooter").style.display = "none";
   }
   
   function showPendingResults(){
	   var fromPeriodComp = document.getElementById("hdnFromPeriod");
	   var fromPeriodVal="";
	   if(fromPeriodComp){
		   fromPeriodVal=fromPeriodComp.value;
	   }
	   
	   var toPeriodComp = document.getElementById("hdnToPeriod");
	   var toPeriodVal="";
	   if(toPeriodComp){
		   toPeriodVal=toPeriodComp.value;
	   }
	   
	   var selectedPeriodComp = document.getElementById("hdnSelectedPeriod");
	   var selectedPeriod;
	   if(selectedPeriodComp){
		   selectedPeriod = selectedPeriodComp.value;
	   }
	   
	   var taskApplicabilityComp = document.getElementById("hdnTaskApplicability");
	   var taskApplicability;
	   if(taskApplicabilityComp){
		   taskApplicability = taskApplicabilityComp.value;
	   }
	   
	   var groupbyComp = document.getElementById("hdnGroupby");
	   var groupby;
	   if(groupbyComp){
		   groupby = groupbyComp.value;
	   }
	   var caNormalcyIndComp = document.getElementById("hdnCANormalcyInd");
	   var caNormalcyInd;
	   if(caNormalcyIndComp){
		   caNormalcyInd = caNormalcyIndComp.value;
	   }
	   
	   var pagesrc = "PendingResultsCriteria.jsp?fromPeriod="+fromPeriodVal+"&toPeriod="+toPeriodVal;
	   pagesrc = "PendingResults.jsp?hdnFromPeriod="+fromPeriodVal+"&hdnToPeriod="+toPeriodVal+"&hdnGetTaskApplicability="+taskApplicability+"&hdnGroupby="+groupby+"&hdnNormalcyVal="+caNormalcyInd+"&hdnSelectedPeriod="+selectedPeriod;
	   document.getElementById("selectionFromFrame").src=pagesrc;
	   slidee("false");
   		showIcon();
   }
   
   function showPreviousResults(url,parameters){
	   var hdnMainPageUrlComp = document.getElementById("hdnMainPageURL");
	   if(hdnMainPageUrlComp){
		   hdnMainPageUrlComp.value = url;
	   }
	   var mainPageUrl = "iPadWidget.jsp";
	   mainPageUrl += "?";
	   //var actionurl = url + "?" + parameters;
	   //alert(actionurl);
	  // mainPageUrl += "hdnMainPageURL="+actionurl;
	   mainPageUrl += "hdnMainPageURL="+url;
	   
	   var paramComp = document.getElementById("hdnParams");
	   if(paramComp){
		   paramComp.value = parameters;
	   }
	   
	   // code added to set the patient id and episode id
	   // to the ipadwidget.jsp
	   var patientIdIndex = parameters.indexOf("hdnPatientid");
	   var equalToIndex = parameters.indexOf("=",patientIdIndex);
	   var amperIndex = parameters.indexOf("&",equalToIndex);
	   var patientIdValue = parameters.substring(equalToIndex+1,amperIndex);
	   
	   var patientIdComp = document.getElementById("hdnPatientId");
	   if(patientIdComp){
		   patientIdComp.value = patientIdValue;
	   }
	   
	   var episodeIdIndex = parameters.indexOf("hdnEpisodeId");
	   equalToIndex = parameters.indexOf("=",episodeIdIndex);
	   amperIndex = parameters.indexOf("&",equalToIndex);
	   var episodeIdValue = parameters.substring(equalToIndex+1,amperIndex);
	   
	   var episodeIdComp = document.getElementById("hdnEpisodeId");
	   if(episodeIdComp){
		   episodeIdComp.value = episodeIdValue;
	   }
	   
	   var hideIconComp = document.getElementById("hdnHideIcon");
	   if(hideIconComp){
		   hideIconComp.value = "Y";
	   }
	   
	   //alert('complete page url='+mainPageUrl);
	   //document.getElementById("frmIcontent").action = mainPageUrl;
	   document.getElementById("frmIcontent").submit();
   }
   
    </script>

</head> 
<body onload = "showFirstPage()"> 
	<section id="page1" data-role="page"  style = "padding:0px;width:100%;background:#ffffff;top:0px"> 
		 <form id="frmIcontent" method = "post" action = "iPadWidget.jsp">
		 <header data-role="header"  style="height:65px;padding:0px;border:0px">
			<div id = "divheader" class="dvheader"  data-role="none"  >
			
				<table border = "0" style = "width:100%;height:auto" cellpadding = "0" cellspacing = "0">
				
					<tr  class="trTitle"align = "center">
					 
						<td align = "left" style ="width:33%" nowrap = "false"><span class="spTitle">Enterprise Management-12.0.2</span></td>
						<td align = "center" style ="width:34%"><span class="spFooter2"><%=jdbc_user%></span></td>
						<td align = "right" style ="width:33%"><span class="spFooter3" id = "spaDate"><%=strFromdate  %></span>
						 
					
						</td>
					</table>
					<table border = "0" style = "width:100%;height:auto;border-top:1px solid #474747" cellpadding = "0" cellspacing = "0">	
					</tr>
					<tr class="trIcon">
						<td align = "left" style ="width:33%" id ="tdToggle"><img src = "../images/Arrow-Open-Normal.png" class="imgIcon" id="imgIcon"></img></td>
						<td align = "center" style ="width:34%"></td>
						<td align = "right" style ="width:33%" >
						
						<img src = "../images/Logout.png" class="imgLogout" onclick = "logout()"></img>
						</td>
					
					</tr>
				</table>
			</div>
		 </header>
		
		<div    class='content' id='divcontent' scrolling = "auto" style="padding:0px">
			<div   id = "wrapper" style ="display:block;padding:0px" data-role = "none">
			   	<div  class="dvPatients" data-role = "none" onclick= "showPatients()">
			   
			   	
			   		 <table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						  <tr style = "height:100%;width:100%">
						    <td style = "width:85%">
						         <span class = "spanPatients">Patients</span>
						    </td>
						    <td style = "width:13%" align = "right" valign = "center">
						        	<img src = "../images/Heading-Panel-Up-Arrow.png"  id="imgPat" ></img>	
						    </td>
						    <td style = "width:2%">
						      &nbsp;
						    </td>
						    
						  </tr>
		    		</table>
			   	
			   	</div>
			    <div class = "dvStroke"></div>
				<div style="height:auto" id = "ulwrapper">
                    <table border = "0" cellpadding = "0" cellspacing = "0" class = "menuTable">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle" onclick = "showIP()">
                           <span class="spMenu">In-Patients</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                        <div  data-role="none" class="countIcon">
                         <%=strIPCount %>
                          </div>
                          <!--  <div style="height:20px;width:30px;border-radius:10px;background:black">10</div>  --> 
                        </td>
                       </tr>
                     </table>
                     
                     <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle">
                           <span class="spMenu">Out-Patients</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                          <!--   <div style="height:20px;width:30px;border-radius:10px;background:black">10</div>  -->
                        </td>
                      </tr>
                    </table>
                    
                    <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle">
                           <span class="spMenu">Day Care</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                       
                        </td>
                      </tr>
                    </table>
                    
                    <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle">
                           <span class="spMenu">Emergency</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                        
                        </td>
                      </tr>
                    </table>
                    
                    <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle">
                           <span class="spMenu">Recently Accessed</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                         
                        </td>
                      </tr>
                    </table>
                    
                     <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle">
                           <span class="spMenu">Consultations</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                         
                        </td>
                      </tr>
                    </table>
                    
                     <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%">&nbsp;</td>
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:55%" valign = "middle">
                           <span class="spMenu">Self</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                         
                        </td>
                      </tr>
                    </table>
                    
                     <table class = "menuTable" border = "0" cellpadding = "0" cellspacing = "0">
                      <tr class = "trMenu">
                        <td style="width:14%">&nbsp;</td>
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:55%" valign = "middle">
                           <span class="spMenu">Speciality</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                         
                        </td>
                      </tr>
                    </table>
                    
                </div>
				<div   class="dvPatients" data-role = "none" >
				<!--  <span class="spanPatients">Users</span>
				<img src = "Heading-Panel-down-Arrow.png" class = "imgPat" id="imgUsers"></img>
				-->
				<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						  <tr style = "height:100%;width:100%">
						    <td style = "width:85%">
						         <span class = "spanPatients">Users</span>
						    </td>
						    <td style = "width:13%" align = "right" valign = "center">
						        	<img src = "../images/Heading-Panel-Up-Arrow.png"  id="imgPat" ></img>	
						    </td>
						    <td style = "width:2%">
						      &nbsp;
						    </td>
						    
						  </tr>
		    		</table>
				</div>
				<!-- 
				<div style = "height:580px">
				  &nbsp;
				</div>
				 -->
<%
// the below code is for pending review results
PendingResults pendingResults = new PendingResults();
// initialize the request and set it with data
PendingResultsCountRequest countRequest = new PendingResultsCountRequest();
countRequest.setRequest(request);
countRequest.setSession(session);
countRequest.setPractitionerId(func_role_id);
Calendar cal = Calendar.getInstance();
Date toDate = cal.getTime();
cal.add(Calendar.DATE, -7);
Date fromDate = cal.getTime();
countRequest.setFromDate(fromDate);
countRequest.setToDate(toDate);

// get the response
PendingResultsCountResponse countResponse = pendingResults.getPendingResultsCount(countRequest);
// process the response
Map<PendingResultCategory, Integer> pendingResultCountMap = countResponse.getPendingResultCountMap();
int totalPendingResults = 0;

if(pendingResultCountMap != null){
	PendingResultCategory pendingResultCategory = new PendingResultCategory(
			PendingResultCategory.TOTAL_CATEGORY);
	Object totalCount = pendingResultCountMap.get(pendingResultCategory);
	Set<PendingResultCategory> keySet = pendingResultCountMap.keySet();
	if(keySet != null){
		Iterator<PendingResultCategory> itr = keySet.iterator();
		if(itr != null){
			while(itr.hasNext()){
				pendingResultCategory = itr.next();
				if(PendingResultCategory.TOTAL_CATEGORY.equals(pendingResultCategory.getCategoryName())){
					totalCount = pendingResultCountMap.get(pendingResultCategory);
					break;
				}
			}
		}
	}
	if(totalCount instanceof Integer){
		totalPendingResults = ((Integer)totalCount).intValue();
	}
}

// code added to get the task applicability value
// which is passed to the pending results screen
String taskApplicability = "";
TaskApplicablityRequest taskRequest = new TaskApplicablityRequest();
taskRequest.setMenu("VIEW_CONF_RESULT");
taskRequest.setRequest(request);
taskRequest.setSession(session);
String resp_id = (String)session.getValue("responsibility_id");
if(resp_id== null){
	resp_id = "";
}
taskRequest.setResponsibilityId(resp_id);
String practRelationId = "";// this is the value passed in desktop app also
taskRequest.setPract_relationId(practRelationId);

TaskApplicabilityResponse taskResponse = pendingResults.getTaskApplicability(taskRequest);
taskApplicability = taskResponse.getMenuValue();

// this variable is of use for showing pending results
// in desktop application also, the group by value is being passed as "P"
// to pending results screen
String groupBy = "P";
// this refers to the normalcy index which is passed to the pending results
// screen
String ca_normalcy_ind = "Z";		

%>				 
				 
				<div style="height:auto" id = "userulwrapper">
				  <table border = "0" cellpadding = "0" cellspacing = "0" class = "menuTable">
                      <tr class = "trMenu">
                        <td style="width:14%" valign = "middle" align = "center">
                          <img src="../images/Navigation Icons.png" class="imgIcon"></img> 
                        </td>
                         <td style="width:69%" valign = "middle" onclick = "showPendingResults()">
                           <span class="spMenu">Pending Results Review</span>
                        </td>
                        <td style="width:17%" valign = "middle" align = "center">
                          <div class="countIcon" data-role="none">
                          <span><%=totalPendingResults %></span>
                          </div>
                          <!--  <div style="height:20px;width:30px;border-radius:10px;background:black">10</div>  --> 
                        </td>
                       </tr>
                     </table>
				</div> 
		     </div>  
		</div>
		<div class ='divmain' id = 'dvmain'   style="padding:0px;background-color : #ffffff">
		     <div id = "divView"   style = "width:100%;height:auto;overflow:auto;padding:0px" data-role ="none"> 
		   
		        
			  <iframe frameborder="0" id="selectionFromFrame" src="" 
			            width="100%"   height = "1050px" scrolling ="yes" style = "display:block"></iframe>
		      
		
		      </div>         
		</div>
		  <footer data-role = "footer"   style="padding:0px;height:20px">  
		    <div id = "divFooter" class="dvFooter"    data-role = "none"> 
				<table border = "0" style = "width:100%;height:100%" cellpadding = "0" cellspacing = "0" class="tbFooter">
					<tr >
						<td align = "left" style ="width:30%" valign="top"><span class="spFooter1"><%=facility_name %>-<%=site%></span></td>
						<td align = "right" style ="width:64%" valign="top"><span class="spFooter2">Copyright 2012 Computer Sciences Corporation - All rights reserved</span></td>
						<td align = "right" style ="width:6%" valign="top"><img src="../images/CSC_Logo.png" class="imgTitle"></img></td>
					
					</tr>
				</table>
		   </div> 
		  </footer> 
		<input type = "hidden" name = "hdnPatientId" id = "hdnPatientId" value = "" />
		<input type = "hidden" name = "hdnEpisodeId" id = "hdnEpisodeId" value = "" />
		<input type = "hidden" name = "hdnAdmitDate" id = "hdnAdmitDate" value = "" />
		<input type = "hidden" name = "hdnDischargeDateTime" id =  "hdnDischargeDateTime" value = "" />
		<input type = "hidden" name = "hdnLocnType" id =  "hdnLocnType" value = "" />
		<input type = "hidden" name = "hdnLocnCode" id =  "hdnLocnCode" value = "" />
		<input type = "hidden" name = "hdnServiceCode" id =  "hdnServiceCode" value = "" />
	<!-- This is added for sending the from and to period in pending review results page -->
		<input type = "hidden" name= "hdnFromPeriod" id="hdnFromPeriod" value="<%=fromPeriod%>"/>
		<input type = "hidden" name= "hdnToPeriod" id="hdnToPeriod" value="<%=toPeriod%>"/>
                <input type="hidden" name="hdnTaskApplicability" id="hdnTaskApplicability" id="hdnTaskApplicability" value="<%=taskApplicability%>"/>
		<input type="hidden" name="hdnGroupby" id="hdnGroupby" id="hdnGroupby" value="<%=groupBy%>"/>
		<input type="hidden" name="hdnCANormalcyInd" id="hdnCANormalcyInd" id="hdnCANormalcyInd" value="<%=ca_normalcy_ind%>"/>
<input type="hidden" name="hdnSelectedPeriod" id="hdnSelectedPeriod" id="hdnSelectedPeriod" value="<%=selectedPeriod%>"/>
		<input type="hidden" name="hdnMainPageURL" id="hdnMainPageURL" id="hdnMainPageURL" value=""/>
		<input type="hidden" name="hdnParams" id="hdnParams" id="hdnParams" value="<%=params%>"/>
		<input type="hidden" name="hdnPatClass" id="hdnPatClass" id="hdnPatClass" value="IP"/>
		<input type="hidden" name="hdnHideIcon" id="hdnHideIcon" id="hdnHideIcon" value=""/>
		</form>
	</section>
	
</body>
</html>
<%

}
    catch(Exception e){
		e.printStackTrace();
		out.println("Exception in IpadBasePage.jsp"+e.toString());
    }
    finally{
        if (rset !=null) rset.close();
		if (pstmt!=null) pstmt.close();
		if (stmt!=null) stmt.close();
		if (rsip!=null) rsip.close();
		if (stmt1!=null) stmt1.close();
        if (con !=null) ConnectionManager.returnConnection(con,request);
		

    }
%>

