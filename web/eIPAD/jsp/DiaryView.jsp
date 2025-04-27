<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>

<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  -->
<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>-->
<!--  -->
<link href="${path}/eIPAD/css/DiaryView.css" type="text/css" rel="stylesheet" />
<link href="${path}/eIPAD/css/DiaryViewThemeA.css" type="text/css" rel="stylesheet" />

  
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js"></script>  

<script src="${path}/eIPAD/js/weekWidget.js"></script>
<%-- <script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script> --%>
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" type="text/css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" type="text/css" />
<%-- <link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" type="text/css" /> --%>
<!-- <script type="application/javascript" src="../js/DiaryView.js"></script> -->

<script type="text/javascript">
var path;
var currentWeek;
var firstDate;
var firstDay;
var currMonth;
var month;
var year;
var startDate;
var lastDay;
var endDate;
var hdnOrderBy = "null";

function openCal(){
	var calDatePicker = $("#date_picker").data("kendoDatePicker");
	calDatePicker.open();
}
function twoDigitString(num){
	if(num<10) return "0"+num;
	else return ""+num;
}
function StringToDate(string){
	var d = new Date();
	//var str='01/07/2013 11:18:13';
	var datenum,month,year;
	var hr=0, min=0, sec=0;
	var datetimearr = string.split(" ");
	if(datetimearr[0]){
		var datearr = datetimearr[0].split("/");
		if(datearr[0])
			datenum = parseInt(datearr[0]);
		if(datearr[1])
			month = parseInt(datearr[1]);
		if(datearr[2])
			year = parseInt(datearr[2]);
	}
	if(datetimearr[1]){
		var timearr = datetimearr[1].split(":");
		if(timearr[0])
			hr = parseInt(timearr[0]);
		if(timearr[1])
			min = parseInt(timearr[1]);
		if(timearr[2])
			sec = parseInt(timearr[2]);
	}
	
	d.setDate(datenum);
	d.setMonth(month-1);
	d.setFullYear(year);
	//if(hr!=0)
	d.setHours(hr);
	//if(min!=0)
	d.setMinutes(min);
	//if(sec!=0)
	d.setSeconds(sec);
	return d;
}

function loadDate() {
	currentWeek = $('#calender').data("currentWeek");
	todayWeekNo = currentWeek.todayWeekNo;
	currentWeekNo = currentWeek.currentWeekNo;
	firstDay = currentWeek.firstDay;
	firstDate = firstDay.getDate();
	currMonth = currentWeek.currentMonth;
	month = currMonth + 1;
	year = currentWeek.currentYear;
	startDate = firstDate + '/' + month + '/' + year;
	lastDay = currentWeek.seventhDay;
	lastDate = lastDay.getDate();
	if ((lastDate < 7) && (month <12)) {
		month = currMonth + 2;
	}
	else
		if((lastDate < 7) && (month==12)){
		month = 01;
		year = year +1;
	}
	endDate = lastDate + '/' + month + '/' + year;
	$("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
 $("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate="+ startDate + "&endDate=" + endDate+ "&hdnOrderBy=" + hdnOrderBy);


}

function openDiaryViewDetail() {
	loadDate();
}

$(document).ready(
		function() {
			parent.removeSpinner();
			parent.setIframeHeight();
			path = $('#hdnPath').val();
			var serverDateFetched = StringToDate($("#hdnServerDate").val());
			$('#calender').weekWidget({
				callBackForNext : openDiaryViewDetail,
				callBackForPrev : openDiaryViewDetail,
				callBackForToday : openDiaryViewDetail,
				callBackForSelect : scrollToDatePosition,
				serverDate : serverDateFetched
			});
			loadDate();
		});


document.addEventListener('touchmove', function(e) {
	e.preventDefault();
}, false);

//scroller func
//variables for setting the content frame height according to the device
//below values are header footer heights

var header_borderheight;
var content_height;
var scroller_height;
var date = new Date();

var scrollContent1;

function scrollToDatePosition(){
	var dateFetchFunc = $('#calender').data('getDate');
	var selectedDate = $('#calender').data('selectedDate');
	var dd = twoDigitString(selectedDate.getDate());
	var mm = twoDigitString(selectedDate.getMonth()+1);
	var yy = twoDigitString(selectedDate.getFullYear());
	var formattedDate = dd+"/"+mm+"/"+yy;
	var dateSeperatorElemId = $("[data-bookingdate='"+formattedDate+"']").attr('id');
	
	if(scrollContent1){
		scrollContent1.scrollToElement("#"+dateSeperatorElemId, 0);
	}
	
	
}
function loaded1() {
	 
	 setTimeout(function() {
		scrollContent1 = new iScroll('divcnt',{
		onScrollEnd: function(e) {
			//alert('scroll end func is called');
						  var dateChangeFunc = $('#calender').data('setDate');
						 var scrolledDate;
						 var headerSet = false;
					 $.each($(".dateSeperatorStart"), function() { 
						 //alert('datechenge event is called');
						 var currentDateCount = parseInt($(this).data('datecount'));
						 var nextDateSeperator = $("[data-datecount='"+(currentDateCount+1)+"']");
						 $("#testred").html($(this).data('datecount') + "  ---- " +nextDateSeperator.data("bookingdate"));
						// alert(nextDateSeperator.offset().top);
						
						if($(this).offset().top - 160 <=  0 && !headerSet && nextDateSeperator.length && nextDateSeperator.offset().top - 160 >= 0){ //$("#DiaryHeader").height() - $("#calender").height()
							// alert('entered in if block');
						 $("#testred").html("entered in if");
							 curDate =$(this).data('bookingdate');
							 scrolledDate = StringToDate(curDate);
							// alert(curDate);
							
							  //if (scrollContent1.y != scrollContent1.maxScrollY) 
							 	dateChangeFunc(scrolledDate);
							//$("#testred").html("--"+$(this).offset().top+" -- "+scrolledDate); 
							 headerSet = true;
							 //alert('scroll end event is called');
						 }
						else if($(this).offset().top - 160 <=  0 && !headerSet && !nextDateSeperator.length){
							curDate =$(this).data('bookingdate');
							 scrolledDate = StringToDate(curDate);
							 dateChangeFunc(scrolledDate);
							 headerSet = true;
						}
					 });
		    },
		    bounce: false,
		    //momentum: false
			useTransform: true,
			scrollY: true, 
			scrollbars: true,
			interactiveScrollbars: true
		});
	}, 100); 

}
function addEmptyDiv() {
	if($(".dateSeperatorStart").length){
		var lastDateSepPos = $(".dateSeperatorStart:last").offset().top;
		var emptyAreaPos = $("#EmptyScrollArea").offset().top;
		var wrapperHeight = $("#divcnt").height();
		if((emptyAreaPos - lastDateSepPos) < wrapperHeight){
			var emptyAreaHeight = wrapperHeight - (emptyAreaPos - lastDateSepPos);
			$("#EmptyScrollArea").css("height", emptyAreaHeight+"px");
		}
	}
	if(scrollContent1){
		//alert("scroller getting destroyed");
		scrollContent1.destroy();
		scrollContent1 = null;
	}
	loaded1();
	if(scrollContent1){
		scrollContent1.refresh();
		scrollContent1.scrollTo(0,0,0);
	}
}
document.addEventListener('touchmove', function(e) {
	e.preventDefault();
}, false);

//document.addEventListener('DOMContentLoaded', loaded1, false);

function changeOrientation(orient, HFheight) {
	//here the heights of the diary view contents frame and the height of the scrolling portion are set
	header_borderheight = $("#DiaryHeader").height()+$("#calender").height();
	diary_headerHeight = $("#DiaryHeader").height();
	content_height = parent.getTotalPageDivHeight() - diary_headerHeight - HFheight - 5; //5px bottom margin
	scroller_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight - 5; //5px bottom margin
	document.getElementById("divcnt").style.height = scroller_height + "px";
	document.getElementById("DiaryViewContents").style.height = content_height + "px";
	if(scrollContent1)
		scrollContent1.refresh();
	addEmptyDiv();
//	(typeof scrollContent1.refresh === "function" ) || scrollContent1.refresh();
}
var i =0;
var j=0;
function fnOrderBy(orderByVal) {
	 hdnOrderBy = orderByVal; 
	
	if(orderByVal == "" || orderByVal == "null"){
    	$('#orderByNone').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    	$('#orderByOP').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
    	$('#orderByOT').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
		$("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
    	$("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate=" + startDate + "&endDate=" + endDate + "&hdnOrderBy=" + orderByVal);

	}
     if(orderByVal == "OP"){
       	 if(i == 0)
    		 {
    		$('#orderByOP').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    		$('#orderByNone').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
    		$('#orderByOT').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
			$("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
    		$("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate=" + startDate + "&endDate=" + endDate + "&hdnOrderBy=" + orderByVal); 
    		i=1;
       		 }
    	 else 
    		 if( i == 1)
    		 {
    		 orderByVal = null;
    		 $('#orderByNone').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    		 $('#orderByOP').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
    		 $('#orderByOT').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
			 $("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
    		 $("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate=" + startDate + "&endDate=" + endDate + "&hdnOrderBy=" + orderByVal);
    		 i=0;
    		 }
	}
    	 if(orderByVal == "OT"){
    		 if(j == 0)
    			 {
    				$('#orderByOT').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    				$('#orderByNone').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
    				$('#orderByOP').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
					$("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
    				$("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate=" + startDate + "&endDate=" + endDate + "&hdnOrderBy=" + orderByVal);
    				j=1;
    			 }
    		 else 
    			 if(j == 1)
    				 {
    				 orderByVal = null;
    	    		 $('#orderByNone').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    	    		 $('#orderByOP').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
    	    		 $('#orderByOT').removeClass('WidgetFilterButtonSelTheme').addClass('WidgetFilterButtonTheme');
					 $("#DiarViewFrame").append("<div class='loadingCartItem'></div>");
    	    		 $("#DiarViewFrame").load(path + "/eIPAD/jsp/DiaryViewDetail.jsp?startDate=" + startDate + "&endDate=" + endDate + "&hdnOrderBy=" + orderByVal);
    	    		 j=0;
    				 }
	}
    	
}



</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style>
.Cal_Top{
	-webkit-tap-highlight-color: rgba(0,0,0,0);
}
</style>

</head>
<body>
	<div data-role="page" class="ipListParent"
		style="padding: 0px; width: 100%; height: 100%;">

		<form style="width: 100%; height: 100%">


			<!-- Added for header  -->

			<div class="diaryHeader" id="DiaryHeader">
				<div class="ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme">
					<table style="height: 100%; width: 100%" cellpadding="0"
						cellspacing="0" border="0">
						<tr style="height: 100%; width: 100%">
							<td style="width: 50px; padding-left: 5px;">
								<div class="WidgetButtonTheme" onclick="parent.toggleMenu()">
									<img src="../images/MenuIcon.png" />
								</div>
							</td>
							<td style="width: auto">
								<div class="ipHeaderPageTitle ipHeaderPageTitleTheme">My Diary</div>
							</td>
							<td style="width: 50%; padding-right: 10px;" align="right"
								valign="center">
								<table
									class="ipContentHolderIconContainer WidgetFilterContTheme" cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td class="WidgetFilterButtonTheme" onclick="fnOrderBy('null')"  id="orderByNone"> <img src="../images/view01.png"style="vertical-align: middle;" /></td>
										<td class="WidgetFilterButtonTheme" onclick="fnOrderBy('OP')" id="orderByOP">  <img src="../images/OP_icon.png" style="vertical-align: middle;" /></td>
										<td class="WidgetFilterButtonTheme" onclick="fnOrderBy('OT')" id="orderByOT"> <img src="../images/OT.png" style="vertical-align: middle;" /></td>
										
									</tr>
								</table>
							</td>

						</tr>
					</table>
				</div>
			</div>

			<div class="content divIPcontent divIPcontentTheme" id="DiaryViewContents" style="overflow:hidden;min-height:100px">
				<div class="background Diary_Main">
					<div class="background Diary_Left">
						<div class="left_block Diary_Left"></div>
					</div>
					<div class="background Diary_Right">
						<div class="right_block DiaryRight Diary_Right">
							<div class="content">
								<div class="top_block D_Right_Top"></div>
								<div class="top_block D_Right_Cen"></div>
								<div class="bottom_block D_Right_Bottom"></div>
							</div>
						</div>
					</div>
					<div class="background Diary_Content">
						<div class="background Diary_Msg_Box">
							<div class="center_block Diary_Msg_Box">																							
								<div id="calender" class="TopCal_Strip"></div>
								<div id="divcnt" style="overflow: hidden; position: relative;">
									<div style="width: 100%; height: auto; overflow: auto">
										<div id="DiarViewFrame" style="width: 100%; height: 100%"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" />
			<input type="hidden" name="startDate" id="startDate" id="hdnStartDate"
				value="${ startDate} " /> <input type="hidden" name="endDate" id="endDate"
				id="hdnEndDate" value="${ endDate}" /> <input type="hidden"
				name="hdnOrderBy" id="hdnOrderBy" id="hdnOrderBy" value="${ hdnOrderBy}" />
			<%SimpleDateFormat weekWidgetFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
			<!-- <input type="hidden" name="hdnServerDate" id="hdnServerDate" id="hdnServerDate" value="19/09/2014" /> -->
			<input type="hidden" name="hdnServerDate" id="hdnServerDate" id="hdnServerDate" value="<%=weekWidgetFormat.format(new Date())%>" />
		<!--  <div id="testred" style="position:fixed;bottom:0px;right:0px;background:red;height:30px;width:300px"></div> --> 
		</form>
		
	</div>
</body>
</html>

