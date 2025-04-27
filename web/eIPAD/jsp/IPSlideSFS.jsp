<%@page import="eIPAD.HealthObjects.InPatientContext"%> 
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.HealthObjects.*,eIPAD.sfs.*," contentType="text/html;charset=UTF-8" %>
<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("UTF-8");
	InPatientContext objInPatientContext = new InPatientContext();
	objInPatientContext.setRequest(request);
	
	String locale = "en";
	String facilityId = "";
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = ""; 
	String fSfsContext = "";
	
	
%>

	
<!DOCTYPE html>
<html>
<head>
<title>IP View</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> -->

<link rel="stylesheet" href="../css/iPADNew.css" /> 
<link rel="stylesheet" href="../css/iPadNew_IP.css" />
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<link rel="stylesheet" href="../css/IPSlideSFS.css" />
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<!-- <script type="application/javascript" src="../js/iscroll.js"></script> -->
<script src="../jquery-1.9.1.min.js"></script>
<script src="../jquery.mobile-1.3.1.min.js"></script>




<script type="text/javascript">
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
$.extend($.expr[":"], {
	"containsIN": function(elem, i, match, array) {
	return (elem.textContent || elem.innerText || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
	});

var sfsScrollSP;
var sfsScrollPR;
var sfsScrollNU;
var sfsMainScroll;
var currentViewMore;
var viewLessHeight;
var arrSP = [];
var arrPR = [];
var arrNU = [];
var currentSearchText;
var path;

function loaded() {
	sfsMainScroll=  new IScroll('#slSfsWrapperMain', { scrollbars: true, click: true, mouseWheel: true, disableMouse: false, disablePointer: true } );
	sfsScrollPR = new IScroll('#slSfsWrapperPR', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );
	if($("#slSfsWrapperSP").is(":visible")){
	sfsScrollSP = new IScroll('#slSfsWrapperSP', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );
	}
	if($("#slSfsWrapperNU").is(":visible")){
	sfsScrollNU = new IScroll('#slSfsWrapperNU', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true  } );
	}
}

function refreshMain(){
	
	$(".SLSfsCircleVisibleTheme").hide();
	$(".slSfsAfterSelection").hide();
	if($('#searchInputSFSSP').length > 0)
	 $('#searchInputSFSSP').val('');
	if($('#searchInputSFSPR').length > 0)
	$('#searchInputSFSPR').val('');
	if($('#searchInputSFSNU').length > 0)
	$('#searchInputSFSNU').val('');
	if($('#txtPatientId').length > 0)
		$('#txtPatientId').val('');
	//document.getElementById("IpSearchForm").submit();
	arrSP.splice(0,arrSP.length);
	arrPR.splice(0,arrPR.length);
	arrNU.splice(0,arrNU.length);
	parent.hideRows(arrSP,arrPR,arrNU);
	sfsMainScroll.refresh();

	var loggedInUser = $('#hdnLoggedInUser').val();
	var loggedInUserDesc = $('#hdnLoggedInUserDesc').val();

	selectedPract(loggedInUser, loggedInUserDesc,  'SlectedPract');
	parent.refresh();
}

function refresh(current,other1,other2){
	document.getElementById("searchInputSFS"+current).value = "";
	$("#list"+current).find(".listItem"+current).show();
	$(".slSfsTickVisible"+current).hide();
	$("#ref"+current).addClass('sfsReloadDefault');
	if(current=='SP'){
		$("#SPAfterSel").empty();
		arrSP.splice(0,arrSP.length);
		sfsScrollSP.refresh();
	}
	if(current=='PR'){
		$("#PRAfterSel").empty();
		arrPR.splice(0,arrPR.length);
		sfsScrollPR.refresh();
	}
	if(current=='NU'){
		$("#NUAfterSel").empty();
		arrNU.splice(0,arrNU.length);
		sfsScrollNU.refresh();
	}
	if($("#AfterSelection"+current).is(":visible")){
		$('#AfterSelection'+current).empty();
		$("#AfterSelection"+current).hide();
	}
	parent.hideRows(arrSP,arrPR,arrNU);
}

function enableSlideSfsIcon(){
	var patientID = $("#txtPatientId").val();
	
	if(patientID == '' || $.trim(patientID).length == 0)
	{
		$( "#txtPatientIdSearchIcon" ).removeClass( "enableSlSfsSearchIcon" ).addClass( "slSfsSearchIcon" );
		$("#ClearPatIdTxt").hide();
	}
	else
	{
		$( "#txtPatientIdSearchIcon" ).removeClass( "slSfsSearchIcon" ).addClass( "enableSlSfsSearchIcon" );		
		$("#ClearPatIdTxt").show();
	}
}
function hideSlideSFS(){
	parent.hideSlideSFS();
}

function slidesfsSearchByPat(){
	var patientID = $("#txtPatientId").val();
	if(patientID != '' || $.trim(patientID).length != 0)
		parent.slideSearchByPat(patientID);	
}

function viewMore(expand, collapse1, collapse2){
	currentViewMore = expand;
	$("#ViewMore"+expand).hide();
	$("#ViewMore"+collapse1).hide();
	$("#ViewMore"+collapse2).hide();
	$("#ViewLess"+expand).show();
	$("#textBox"+collapse1).hide();
	$("#textBox"+collapse2).hide();
	$("#content"+collapse1).hide();
	$("#content"+collapse2).hide();
	setViewMoreHeight(expand,collapse1,collapse2);
	sfsMainScroll.refresh();
	if(expand == "SP"){
		sfsScrollSP.refresh();
	}
	if(expand == "PR"){
		sfsScrollPR.refresh();
	}
	if(expand == "NU"){
		sfsScrollNU.refresh();
	}
}
function viewLess(current,other1,other2){
	if(currentViewMore != ""){
		$("#ViewMore"+current).show();
		$("#ViewMore"+other1).show();
		$("#ViewMore"+other2).show();
		$("#ViewLess"+current).hide();
		$("#textBox"+other1).show();
		$("#textBox"+other2).show();
		$("#content"+other1).show();
		$("#content"+other2).show();
		$("#data"+currentViewMore).height(viewLessHeight);
		if(currentViewMore == "SP"){
			sfsScrollSP.refresh();
		}
		if(currentViewMore == "PR"){
			sfsScrollPR.refresh();
		}			
		if(currentViewMore == "NU"){
			sfsScrollNU.refresh();
		}
	}
	currentViewMore="";
	sfsMainScroll.refresh();
}

function setViewMoreHeight(){
	var fullHeight = $("#slSfsWrapperMain").height();
	fullHeight = fullHeight - $("#headingSP").height() - $("#headingPR").height() - $("#headingNU").height() + $("#heading"+currentViewMore).height() - $("#textBoxSP").height() - $("#textBoxPR").height() - $("#textBoxNU").height();
	$("#data"+currentViewMore).height(fullHeight);
}


/*changed to single selection*/
function showTick(val, type){ 
parent.addSpinner();
	if(type=="SP"){	
		 arrSP =[];
		if($("#slSfsTickSP"+val).is(":visible")){
			 $("#slSfsTickSP"+val).hide();
			 $('div[id^="slSfsTickSP"]').hide();
		}
		else{
			arrSP.push(val);
			$('div[id^="slSfsTickSP"]').hide();
			$("#slSfsTickSP"+val).show();
				
		}
		parent.hideRows(arrSP,arrPR,arrNU);
		if($('#searchInputSFS'+type).length > 0)
			$('#searchInputSFS'+type).val('');
	}
	
	if(type=="NU"){	
		arrNU =[];
		if($("#slSfsTickNU"+val).is(":visible")){
			$("#slSfsTickNU"+val).hide();
			$('div[id^="slSfsTickNU"]').hide();
		}
		else{
			arrNU.push(val); 
			$('div[id^="slSfsTickNU"]').hide();
			$("#slSfsTickNU"+val).show();		
		}
		parent.hideRows(arrSP,arrPR,arrNU);	
		
		if($('#searchInputSFS'+type).length > 0)
			$('#searchInputSFS'+type).val('');	
	}
	sfsScrollNU.refresh();	
	sfsScrollSP.refresh();	
	
}
function selectedPract(val, desc, dPage){
	parent.clearHdnPatientValue();
	/* if($("#slSfsTickPR"+val).is(":visible")){
		 $("#slSfsTickPR"+val).hide();
		 $('div[id^="slSfsTickPR"]').hide();
		 $(".listItemPR").show();
		 $("#listItemPR"+val).show();
		 $("#slSfsTickPR"+val).hide();
		 if($("#contentSP").is(":visible")){
			 $("#contentSP").hide();
		 }
		 if($("#textBoxSP").is(":visible")){
			 $("#textBoxSP").hide();
		 }
		 if($("#contentNU").is(":visible")){
			 $("#contentNU").hide();
		 }
		 if($("#textBoxNU").is(":visible")){
			 $("#textBoxNU").hide();
		 }
		 
		 
		 

		 sfsScrollPR.refresh();
	}
	else{
		arrPR.push(val); 
		 $('div[id^="slSfsTickPR"]').hide();
		 $(".listItemPR").hide();
		 $("#listItemPR"+val).show();
		 $("#slSfsTickPR"+val).show();
		 
		 $("#textBoxSP").show();
		 $("#textBoxNU").show();
		 $("#contentSP").show();
		 $("#contentNU").show();
		 
		 document.getElementById("hdnSelectedPractiotinerID").value = val
		 document.getElementById("hdnSfsClinicianId").value = val
		 parent.selectedPract(val, dPage);
		 sfsScrollPR.refresh();
	} */
	$("#searchInputSFSPR").blur();
	parent.selectedPract(val, desc, dPage);
	/* sfsScrollPR.refresh(); */
}
function removeInblockItem(val,type){
	$("#inBlockItem"+val).remove();
	if(type == 'SP'){
		var index = arrSP.indexOf(val);
		arrSP.splice(index,1);
			if(arrSP.length<1){
				$("#SPAfterSel").hide();
				$("#AfterSelectionSP").empty();
			}
		parent.hideRows(arrSP,arrPR,arrNU);
		$("#slSfsTickSP"+val).hide();
		
		$("#contentSP").show();
 		$("#textBoxSP").show();
		sfsScrollSP.refresh();
	}
	if(type == 'PR'){
		var index = arrPR.indexOf(val);
		arrPR.splice(index,1);
			if(arrPR.length<1){
				$("#PRAfterSel").hide();
				$("#AfterSelectionPR").empty();
			}
		parent.hideRows(arrSP,arrPR,arrNU);
		$("#slSfsTickPR"+val).hide();
		
		$("#contentPR").show();
 		$("#textBoxPR").show();
 		$("#arrowPR").removeClass('slSfsarrow');
 		sfsScrollPR.refresh();
	}
	if(type =='NU'){
		var index = arrNU.indexOf(val);
		arrNU.splice(index,1);
			if(arrNU.length<1){
				$("#NUAfterSel").hide();
				$("#AfterSelectionNU").empty();
			}
		parent.hideRows(arrSP,arrPR,arrNU);
		$("#slSfsTickNU"+val).hide();
		$("#contentNU").show();
 		$("#textBoxNU").show();
		sfsScrollNU.refresh();
		}
}

function clearPatIdTxt(){
	document.getElementById("txtPatientId").value = "";	
	$("#ClearPatIdTxt").hide();
	$( "#txtPatientIdSearchIcon" ).removeClass( "enableSlSfsSearchIcon" ).addClass( "slSfsSearchIcon" );
}
function clearTxt(current,other1,other2){
	document.getElementById("searchInputSFS"+current).value = "";
	//parent.hideRows(arrSP,arrPR,arrNU);
	$("#list"+current).find(".listItem"+current).show();
	if(current='SP'){
		sfsScrollSP.refresh();
	}
	if(current='PR'){
		$("#slSfsScrollerPR").empty();
		sfsScrollPR.refresh(); 
		
		/* var practID =arrPR[0];
		var scrollToPR = ".listItemPR"+practID;
		sfsScrollPR.scrollToElement(scrollToPR , 0 ); */
		
	}
	if(current='NU'){
		sfsScrollNU.refresh(); 
	}
}

function downArrow(current,other1,other2){
	
	$("#content"+current).toggle();
	$("#textBox"+current).toggle();
	if(current=="SP"){
		if($("#AfterSelectionSP").is(":visible")){
			$("#AfterSelectionSP").empty();
			$("#AfterSelectionSP").hide();
			$("#contentSP").show();
	 		$("#textBoxSP").show();
	 		sfsScrollSP.refresh(); 
		}
		 
		 if(arrSP.length>0){
				$("#AfterSelectionSP").show();
				for(var i=0;i<arrSP.length;i++){
					var specCode= arrSP[i];
					var specDesc ="";
					$("[data-speccode = '"+specCode+"']").each(function (i,v ){
						specDesc = $(this).data("specdesc");
					});
		 			var inblockSP ='<div id="inBlockItem'+specCode+'" class="row slSfsInlineBlock slSfsInlineBlockTheme"> <div class="cell slSfsInlineBlockCell slSfsInlineBlockCellTheme"> '+ specDesc +' </div><div class="cell slSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+specCode+'&quot;,&quot;SP&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
		 			$("#AfterSelectionSP").append(inblockSP);    
			 	}
				
				$("#AfterSelectionSP").show();
	    	    $("#contentSP").hide();
	 		    $("#textBoxSP").hide();
	 		 
			}
			else {
				sfsScrollSP.refresh(); 
			}
	 }
	 
	 if(current=="PR"){
		 if($("#AfterSelectionPR").is(":visible")){

				 
				$("#AfterSelectionPR").empty();
				$("#AfterSelectionPR").hide();
				$("#contentPR").show();
		 		$("#textBoxPR").show();
		 		var PractID = arrPR[0];
				var scrollToPR;
				scrollToPR = ".listItemPR"+PractID;
				sfsScrollPR.scrollToElement(scrollToPR , 0 );
				sfsScrollPR.refresh();
			}
		 else if(arrPR.length>0){
				for(var i=0;i<arrPR.length;i++){
					var practCode = arrPR[i];
    				var practDesc ="";
    				$("[data-practcode = '"+practCode+"']").each(function (i,v ){
    					practDesc = $(this).data("practdesc");
					});
    		 		var inblockPR ='<div id="inBlockItem'+practCode+'" class="row slSfsInlineBlock slSfsInlineBlockTheme"> <div class="cell slSfsInlineBlockCell slSfsInlineBlockCellTheme"> '+ practDesc +' </div><div class="cell slSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+practCode+'&quot;,&quot;PR&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
    		 		$("#AfterSelectionPR").empty();
    		 		$("#AfterSelectionPR").append(inblockPR);    
    		 	}
				$("#AfterSelectionPR").show();
	    	    $("#contentPR").hide();
	 		    $("#textBoxPR").hide();
	 		   	var PractID = arrPR[0];
				var scrollToPR;
				scrollToPR = ".listItemPR"+PractID;
				sfsScrollPR.scrollToElement(scrollToPR , 0 );
				
	 		 
			}
		
	 }
	 
	 if(current=="NU"){
		 if($("#AfterSelectionNU").is(":visible")){
			 	var index = arrNU.indexOf(0);
				arrNU.splice(index,1);
			 	
				$("#AfterSelectionNU").empty();
				$("#AfterSelectionNU").hide();
				$("#contentNU").show();
		 		$("#textBoxNU").show();
		 		sfsScrollNU.refresh(); 
			}
		 
		 if(arrNU.length>0){
				$("#AfterSelectionNU").show();
				for(var i=0;i<arrNU.length;i++){
					var nursingUnitCode= arrNU[i];
					var nursingUnitDesc ="";
					$("[data-nursingunitcode = '"+nursingUnitCode+"']").each(function (i,v ){
						nursingUnitDesc = $(this).data("nursingunitdesc");
					});
	 				var inblockNU ='<div id="inBlockItem'+nursingUnitCode+'" class="row slSfsInlineBlock slSfsInlineBlockTheme"> <div class="cell slSfsInlineBlockCell slSfsInlineBlockCellTheme"> '+ nursingUnitDesc +' </div><div class="cell slSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+nursingUnitCode+'&quot;,&quot;NU&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
	 				$("#AfterSelectionNU").append(inblockNU);    
	 			}
	    		
				$("#AfterSelectionNU").show();
	    	    $("#contentNU").hide();
	 		    $("#textBoxNU").hide();
	 		 
			}
			else {
				sfsScrollNU.refresh();
			}
	 }
	 
	 if($("#content"+current).is(":visible")){
		  $("#arrow"+current).removeClass('slSfsarrow');
		}
		else{
			$("#arrow"+current).addClass('slSfsarrow');
		}
	
	
}
$(document).ready(function(){
	//$("#codePR_Static").html(($("#hdnSfsPractitionerId",parent.document).val()));
	$("#textPR_Static").html($("#hdnSfsPractitionerDesc",parent.document).val()+'<br><span class="slSfsViewItemTextSmall slSfsViewItemTextSmallTheme" id="codePR_Static">'+$("#hdnSfsPractitionerId",parent.document).val()+'</span>');
	path = $('#hdnPath').val();
	loaded();
	if(sfsScrollSP != null){
		sfsScrollSP.on('beforeScrollStart', function () {
			sfsMainScroll.disable();
		});
		sfsScrollSP.on('scrollEnd', function () {
			sfsMainScroll.enable();
		});
	}
	if(sfsScrollPR != null){
		sfsScrollPR.on('beforeScrollStart', function () {
			sfsMainScroll.disable();
		});
		sfsScrollPR.on('scrollEnd', function () {
			sfsMainScroll.enable();
		});
	}
	if(sfsScrollNU != null){
		sfsScrollNU.on('beforeScrollStart', function () {
			sfsMainScroll.disable();
		});
		sfsScrollNU.on('scrollEnd', function () {
			sfsMainScroll.enable();
		});
	}
	$('#slSfsWrapperMain').on('touchstart click', function(){
		sfsMainScroll.enable();
	});
	$('#ClearPatIdTxt').hide();
	$('#AfterSelectionPR').hide();
	$('#AfterSelectionSP').hide();
	$('#AfterSelectionNU').hide();
	
	if($("#searchInputSFSSP").is(":visible")){
	$("#searchInputSFSSP").keyup(function () {
	var rows = $("#listSP").find(".listItemSP").hide();
	sfsScrollSP.refresh();
	   if (this.value.length) {
		    addSpinnerNU();
		   parent.addSpinner();
	       var data = this.value.split(" ");
	       //$.each(data, function (i, v){
	       		//var val = v.toLowerCase(); 
	       		var val = this.value.toLowerCase();
	       		rows.filter(":containsIN('" + val + "')").show();
	       		sfsScrollSP.refresh();
				//});
				 removeSpinner();
	   		}
	   	else{
	   		rows.show();	
	   		sfsScrollSP.refresh();
	   	}
	}); 
	}
	
	function addSpinnerNU(){
	var a = $("#spinnerDiv")

	if(a.length ==0)
		$("#slSfsWrapperNU").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
	function removeSpinner(){
	var a = $("#spinnerDiv")

	if(a.length > 0)
	$("#spinnerDiv").remove();
}
	/* if($("#searchInputSFSPR").is(":visible")){ */
	$("#searchInputSFSPR").keyup(function () {
		
		if (this.value.length == 3 ){
			
			$("#spinnerDiv_PRSFS").show();
		
			currentSearchText = this.value;
			$('#slSfsScrollerPR').load(path+"/eIPAD/jsp/IPSlideSFSPractSearch.jsp?practSearchText="+this.value,function(){
				sfsScrollPR.refresh();
				$("#spinnerDiv_PRSFS").hide();
				//$("#searchInputSFSPR").blur();
				
			});
		}else if(this.value.length > 3){
			var rows = $("#listPR").find(".listItemPR").hide();
			 var data = this.value.split(" ");
	       //$.each(data, function (i, v){
	       	//var val = v.toLowerCase(); 
	       	var val = this.value.toLowerCase();
	       	var visibleData = rows.filter(":containsIN('" + val + "')").show();
	       	if(visibleData.length<=0){
	       	
	       		$("#listPR_NoResults").css("display","block");
	       	}
	       	sfsScrollPR.refresh();
		}
       	else if(this.value.length < 3){
    	    $('#slSfsScrollerPR').empty();
       	}
		
	/* var rows = $("#listPR").find(".listItemPR").hide();
	sfsScrollPR.refresh();
	   if (this.value.length) {
	       var data = this.value.split(" ");
	       //$.each(data, function (i, v){
	       	//var val = v.toLowerCase(); 
	       	var val = this.value.toLowerCase();
	       	rows.filter(":containsIN('" + val + "')").show();
	       	sfsScrollPR.refresh();
	   		//});
	   	}
	   	else{
	   		rows.show();
	   		sfsScrollPR.refresh();
			   	}
			    var searchVal = $("#searchInputSFSPR").val();
				if(searchVal.length == 0){
					var PractID = arrPR[0];
					var scrollToPR;
					scrollToPR = ".listItemPR"+PractID;
					sfsScrollPR.scrollToElement(scrollToPR , 0);
	   	} */
	}); 
	       
	//}
	if($("#searchInputSFSNU").is(":visible")){
	$("#searchInputSFSNU").keyup(function () {
	var rows = $("#listNU").find(".listItemNU").hide();
	  if (this.value.length) {
		  addSpinnerNU();
	      var data = this.value.split(" ");
	      //$.each(data, function (i, v){
	      	//var val = v.toLowerCase(); 
	      	var val = this.value.toLowerCase();
			rows.filter(":containsIN('" + val + "')").show();
			sfsScrollNU.refresh();
	      	//});
			 removeSpinner();
	  	}
	  	else{ 
	  		rows.show();
			sfsScrollNU.refresh();
	  	}
	});
	}
	
	var PractID = $('#hdnSfsClinicianId').val();
	$("#slSfsTickPR"+PractID).show();
	arrPR.push(PractID);
	var scrollToPR;
	scrollToPR = ".listItemPR"+PractID;
	sfsScrollPR.scrollToElement(scrollToPR , 0 );
	
	$('input').bind('focus', function(e) {
			window.parent.$('#divParent').css('position','fixed')		
	});
	$('input').bind('blur', function(e) {
			window.parent.$('#divParent').css('position','absolute')		
	});
	/* $( document).on( "swipeleft", "#IpSearchForm", function( e ) {
		hideSlideSFS();
	}); */
	parent.setIframeSFSHeight();
 });
 function changeOrientation(orient, HFheight)
 {
 	content_height = parent.getTotalPageDivHeight() - HFheight-5;
	document.getElementById("IPsfsTable").style.height = content_height+"px";
	window.parent.$("#SlideSfs").css("height", content_height+"px");
	
 }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body style="width: 100%; height: 100%;">
	<form name='IpSearchForm' id='IpSearchForm' id="IpSearchForm" method='post' style="background-color: #eaedf2;">
		<!-- main table STARTS -->
		<div class="table" id="IPsfsTable" style="width:100%;height:100%; position: absolute; overflow: hidden; background:#eaedf2"> 
			<!-- header row STARTS -->
			<div class="row" style="height:40px; width:100%"> <!-- MR1 -->
				<div class="cell">
					<div class="table" style="width:100%; height:100%">
						<div class="row slSfsHeader slSfsHeaderTheme">
							<div class="cell slSfsHeaderText slSfsHeaderTextTheme">SEARCH / FILTER</div>
							<div class="cell slSfsHeaderCell" id="refMain" onclick="refreshMain()"><img src ="${path}/eIPAD/images/Reload24x24.png" /></div>
							<div class="cell slSfsHeaderCell"  onclick="hideSlideSFS()"><img src = "${path}/eIPAD/images/CloseSearch24x24.png" /></div>
						</div>
					</div>
				</div>
			</div>
			<!-- Text box row starts-->	
			<div class="row" style="height:40px; width:100%"> <!-- MR2 -->
				<div class="cell">
					<div class="table" style="height:40px; width:96%; margin-top:4px; margin-left:4px; margin-right:4px">
						<div class="row" style="background:#ffffff; height:100%; width:100%">
							<div class="cell" style="width:99%">
								<div class="table slSfsMainTextBox">
									<div class="row" style="background:#ffffff; height:100%; width:100%">
										<div class="cell" style="vertical-align:middle; text-align: center;">
											<input type="text" class="slSfsTxtBox" style="color:#9da5b3; height:24px" name = "txtPatientId" id = "txtPatientId" placeholder="Patient ID/Bed No." maxlength="20" value = "<%=objInPatientContext.getPatientId() %>"  onKeyUp="enableSlideSfsIcon()" onChange="enableSlideSfsIcon()"/>
										</div>
										<div class="cell" id="ClearPatIdTxt" onclick="clearPatIdTxt()" style="vertical-align: middle; text-align: center;">
											<div class=" slSfsTextBoxCloseButton"  ><img src="../images/Close-small.png" style="width:10px; height:10px"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="cell" style=" width:1%; vertical-align: middle; text-align: center;">
								<div id="txtPatientIdSearchIcon" class="slSfsSearchIcon" onclick="slidesfsSearchByPat()"><img src = "../images/SearchSFS14x14.png" style="vertical-align: middle; text-align: center; padding-top: 12px;"/></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Text box row ends  -->
			<!-- header row ENDS -->
			<div class="row" style="height:96%; width:100%"> <!-- MR3 -->
				<div class="cell">
					<div style="width:100%;height:100%;overflow:hidden;position:relative">
						<div id="slSfsWrapperMain">
							<div id="slSfsScrollerMain">
								<div class="table" id="sfsMainTable" style="width:96%; margin:4px;position:relative">
								<%
									SFSContext oSFSContext = new SFSContext();
									String sfacility_id = "";
									String sclinicianId = "";
									String sPractionerId = "";
									String selectedPractID = "";
									String specCode= "";
									String practCode = "";
									String nursingCode= "";
									String clinicianId = "";
									oSFSContext.setRequest(request);
									if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
									{
										sfacility_id = (String)session.getValue("facility_id");
										oSFSContext.setSfacility_id(sfacility_id);
									}
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setSclinicianId(sclinicianId);
									}
									/* if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
									{
										sPractionerId = (String)request.getParameter("hdnPractitionerId");
										oSFSContext.setsPractionerId(sPractionerId);
									} */
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")	
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
									}
									if(request.getParameter("selectedPractID") != null){
										
										selectedPractID = (String)request.getParameter("selectedPractID");
										oSFSContext.setsPractionerId(selectedPractID);
									}
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										clinicianId = (String)session.getValue("ca_practitioner_id");
										objInPatientContext.setClinicianId(clinicianId);
									}
									if(session.getValue("practitioner_name") != null && session.getValue("practitioner_name") != "")
									{
										fPractitionerName = (String)session.getValue("practitioner_name");
										objInPatientContext.setClinicianDesc(fPractitionerName);
									}
									
												
									   int nRowCount = 1;		       			    
									   int nLoopCount = 0;
									   
									   int nListSizeSP = 0;
									   int nListSizePR = 0;
									   int nListSizeNU = 0;
									 
									   SFSDetails bean = new SFSDetails();
									   List<SFSUnit> objSfsDetailsSP = new ArrayList<SFSUnit>();
									   List<SFSUnit> objSfsDetailsPR = new ArrayList<SFSUnit>();
									   List<SFSUnit> objSfsDetailsNU = new ArrayList<SFSUnit>();
									   
									   int sfsContextTypePR = 4;
									   int sfsContextTypeSP = 5;
									   int sfsContextTypeNU = 6;
									%>
										
										<!-- PR Content starts here-->
										<div class="table filterTextWrap">
											<div class="row" id="headingPR" style="height:40px">
												<div class="cell">
													<div class="table" style="width:100%;height:40px;">
														<div class="row slSfsCategoryBlock" onclick="downArrow('PR','SP','NU')" style="width:100%; height:40px;">
														<div class="cell slSfsDivText slSfsDivTextTheme" > PRACTITIONER </div>
														<!-- <div class="cell slSfsHeaderCell" onclick="refresh('PR','SP','NU')"> <img  id="refPR" src = "../images/ReloadGrySFS.png"  style="padding-top:4px"/></div> -->
														<div class="cell slSfsHeaderCell" id="arrowPR"  ><img  src = "../images/DownarrowSFS.png" /></div>
										 			</div>
													</div>
												</div>
											</div>
											<%
											
												oSFSContext.setType(sfsContextTypePR);  
												objSfsDetailsPR = bean.getSFSUnit(oSFSContext); 
							   					nListSizePR =  objSfsDetailsPR.size();
							   					SFSUnit sfsUnitPR = null;
							   					
							   						/* if(nListSizePR > 10){ */
											 %>
											<div class="row" id="textBoxPR" style="width:100%; height:40px; background:#ffffff; ">
												<div class="cell">
													<div class="table slSfsDivShadow">
														<div class="row" style="height:30px">
															<div class="cell" style="vertical-align:middle; text-align: center;">
																<input type="text" id="searchInputSFSPR" class="slSfsDivLevelTxtBox" style="color:#9da5b3; height:24px;"/>
															</div>
															<div class="cell" style="width: 11%;padding:0px;">
																<div style="width:90%;margin-top:4px;background-color:#dbdbdb;border-radius:10px;" onclick="clearTxt('PR','SP','NU')">
																 <img style="vertical-align:middle;padding-top:0;margin-top:-3px" src="../images/Close-small.png">
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										<%
						   						/* } */
						   						/* if(nListSizePR >0 ){ */
										%>
										
										<%
										try {
											%>
											<div class="row" id="contentPR">
												<div class="cell">
													<div class="slSfsNormalView" id="dataPR">
														<div id="slSfsWrapperPR" style="height:100%; width:100%; background-color: #ffffff;"> 
														
															<div id="slSfsScrollerPR">
															
																
																		   <%-- <div class="table" id="listPR" style="width:100%; height:100%;">
																 	 		<%
																 	  		for(nLoopCount = 0 ; nLoopCount < nListSizePR; nLoopCount++)
																 	  			{
																 		 		sfsUnitPR = objSfsDetailsPR.get(nLoopCount);
																 		  		if(sfsUnitPR != null )
																		  			{
																 					 practCode = sfsUnitPR.getsCode();
															 		 		%>
																					<div class="row listItemPR listItemPR<%=practCode%>"  data-pract="<%=practCode%>" id="listItemPR<%=practCode%>" style="width:100%; height:45px;" onclick="selectedPract('<%=practCode%>','SlectedPract')" data-practcode="<%=practCode%>" data-practdesc="<%=sfsUnitPR.getsDescription()%>">
																						<!-- border-bottom: 1px solid #f6f6f6; -->
																						<div class= "cell slSfsViewItemTextPract slSfsViewItemTextPractTheme" id="textPR<%=practCode%>"><%=sfsUnitPR.getsDescription()%><br>
																						<span class="slSfsViewItemTextSmall slSfsViewItemTextSmallTheme"><%=sfsUnitPR.getsCode()%></span>
																						</div>
																						<div class="cell SLSfsListTickPractTheme"><div class="slSfsTickVisiblePR SLSfsCircleVisibleTheme" id="slSfsTickPR<%=practCode%>" style="display:none;"></div></div>
																					</div>
																					
																	 		<%
																  					}
																  					nRowCount = nRowCount + 1;
																				} 
																 	 		%>
																			</div> --%>
																	
											  				</div>
											  				
														</div>
														<div class="table" id="spinnerDiv_PRSFS" style="width:100%; height:100%;position:relative;display:none">
											  				<div class="row listItemPR_Static"   id="listItemPR_Static" style="width:100%; height:45px;" onclick="" data-practcode="" data-practdesc="">
											  					<div class='loadingCartItem' ></div>
															</div>
															
														</div>
														<div class="table" id="listPR_Static" style="width:100%; height:100%;">
											  				<div class="row listItemPR_Static"   id="listItemPR_Static" style="width:100%; height:45px;" onclick="" data-practcode="" data-practdesc="">
																<!-- border-bottom: 1px solid #f6f6f6; -->
																<div class= "cell slSfsViewItemTextPract slSfsViewItemTextPractTheme" id="textPR_Static"><br>
																<span class="slSfsViewItemTextSmall slSfsViewItemTextSmallTheme" id="codePR_Static"></span>
																</div>
																<div class="cell SLSfsListTickPractTheme"><div class="slSfsTickVisiblePR SLSfsCircleVisibleTheme" id="slSfsTickPR_Static""></div></div>
															</div>
															
														</div>
														
														
														
														
													</div>
												</div>
											</div>
								
											<div class="row slSfsAfterSelection" id="PRAfterSel">
												<div class="cell">
													<div class="table" style="padding-left:10px;display:block" id="AfterSelectionPR"></div>
												</div>
											</div>
											<%
											}catch ( Exception e ){
											e.printStackTrace();
											}
											finally{
											}
											/* } */
											%>
										</div>
										<!-- PR Content ends here-->
										<!-- SP Content Stars Here -->
										<%
										oSFSContext.setType(sfsContextTypeSP);  
										objSfsDetailsSP = bean.getSFSUnit(oSFSContext); 
										
										
										
										nListSizeSP =  objSfsDetailsSP.size();
								   		SFSUnit sfsUnitSP = null;
										%>
										<div class="table filterTextWrap">
										<%
										if(nListSizeSP > 0){
										%>
											<div class="row" id="headingSP" style="height:40px">
										<%
										}else{
										%>
											<div class="row disabledRow" id="headingSP" style="height:40px">
										<%
										}
										%>
												<div class="cell">
													<div class="table" style="width:100%;height:40px">
														<div class="row slSfsCategoryBlock" onclick="downArrow('SP','PR','NU')" style="width:100%; height:40px;">
															<div class="cell slSfsDivText slSfsDivTextTheme" > SPECIALITY </div>
															<!-- <div class="cell slSfsHeaderCell" onclick="refresh('SP','PR','NU')"> <img  id="refSP" src = "../images/ReloadGrySFS.png"  style="padding-top:4px"/></div> -->
															<div class="cell slSfsHeaderCell" id="arrowSP"  ><img  src = "../images/DownarrowSFS.png" /></div>
														</div>
													</div>
												</div>
											</div>
											<%
											
								   	 				   
										   	if(nListSizeSP > 10){
											%>
											<div class="row" id="textBoxSP" style="width:100%; height:40px; background:#ffffff; ">
												<div class="cell">
													<div class="table slSfsDivShadow">
														<div class="row" style="height:30px">
															<div class="cell" style="vertical-align:middle; text-align: center;">
																<input type="text" id="searchInputSFSSP" class="slSfsDivLevelTxtBox" style="color:#9da5b3;height:26px;"/>
															</div>
															<div class="cell"  style="vertical-align: middle; text-align: center;">
																<div class=" slSfsTextBoxCloseButton" onclick="clearTxt('SP','PR','NU')"><img src="../images/Close-small.png" style="width:10px; height:10px"></div>
															</div>
												    	</div>
													</div>
												</div>
											</div>
											<%
										   		}
										   			if(nListSizeSP > 0){
										   					
											%>
											<div class="row" id="contentSP">
												<div class="cell"> 
													<div class="slSfsNormalView" id="dataSP">
														<div id="slSfsWrapperSP" style="background-color: #ffffff;"> 
															<div id="slSfsScrollerSP">
															<%				   
															   try {
																
															   	
																   %>
																   <div class="table" id="listSP" style="width:100%; height:100%;">															   
																		
															 	   <%
																 	  for(nLoopCount = 0 ; nLoopCount < nListSizeSP; nLoopCount++)
																 	  {
																 		 sfsUnitSP = objSfsDetailsSP.get(nLoopCount);
																 		  if(sfsUnitSP != null )
																		  {
																 			 specCode = sfsUnitSP.getsCode(); 
											 
											 				 	   %>   
																		<div class="listItemSP" style="width:100%; height:40px;" onclick="showTick('<%=specCode%>','SP')" data-speccode="<%=specCode%>" data-specdesc="<%=sfsUnitSP.getsDescription() %>">
																			<div class= "cell slSfsViewItemText slSfsViewItemTextTheme" id="textSP<%=specCode%>"><%=sfsUnitSP.getsDescription()%></div>
																			<div class="cell slSfsListTick" id="divSP<%=specCode%>"><div class="slSfsTickVisibleSP SLSfsCircleVisibleTheme" id="slSfsTickSP<%=specCode%>" style="display:none"></div></div>
																		</div>
																 	<%
															  				}
															  					nRowCount = nRowCount + 1;
																		} 
																 %>
																   </div>
																
															  	
											  				</div>
														</div>
													</div>
												</div>
											</div>
								
										    <div class="row slSfsAfterSelection" id="SPAfterSel">
										   		<div class="cell">
													<div class="table" style="padding-left:10px;display:block" id="AfterSelectionSP"></div>
												</div>
	                                        </div>
											<%
											   }catch ( Exception e ){
													e.printStackTrace();
													}
													finally{
													}
										   			}
											
											%>
										</div>
										<!-- SP Content ends here-->
										<!-- NU Content starts here-->
										<%
										oSFSContext.setType(sfsContextTypeNU);  
										objSfsDetailsNU = bean.getSFSUnit(oSFSContext); 
									    
										nListSizeNU =  objSfsDetailsNU.size();
									    SFSUnit sfsUnitNU = null;
										%>
										<div class="table filterTextWrap">
										<%
										if(nListSizeNU > 0){
										%>
											<div class="row" id="headingNU" style="height:40px">
										<%
										}else{
										%>
											<div class="row disabledRow" id="headingNU" style="height:40px">
										<%
										}
										%>
												<div class="cell">
													<div class="table" style="width:100%;height:40px;">
														<div class="row slSfsCategoryBlock" onclick="downArrow('NU','SP','PR')" style="width:100%; height:40px;">
															<div class="cell slSfsDivText slSfsDivTextTheme" > NURSING UNIT </div>
															<!-- <div class="cell slSfsHeaderCell" onclick="refresh('NU','SP','PR')"> <img  id="refNU" src = "../images/ReloadGrySFS.png"  style="padding-top:4px"/></div> -->
															<div class="cell slSfsHeaderCell" id="arrowNU" ><img  src = "../images/DownarrowSFS.png" /></div>
														</div>
													</div>
												</div>
											</div>
											<%
											
											
										    if(nListSizeNU > 10){
										    %>
											<div class="row" id="textBoxNU" style="width:100%; height:40px; background:#ffffff; ">
												<div class="cell">
													<div class="table slSfsDivShadow">
														<div class="row" style="height:30px">
															<div class="cell" style="vertical-align:middle; text-align: center;">
																<input type="text" id="searchInputSFSNU" class="slSfsDivLevelTxtBox" style="color:#9da5b3;height:26px;"/>
															</div>
															<div class="cell" style="vertical-align: middle; text-align: center;">
																<div class=" slSfsTextBoxCloseButton"  onclick="clearTxt('NU','SP','PR')"><img src="../images/Close-small.png" style="width:10px; height:10px"></div>
															</div>
	  													</div>
	  												</div>
	  											</div>
	  										</div>
  										<%
										    	}
										    	if(nListSizeNU > 0){
										  
  										%>
										<div class="row" id="contentNU">
											<div class="cell">
												<div class="slSfsNormalView" id="dataNU">
													<div id="slSfsWrapperNU" style="height:100%; width:100%; background-color: #ffffff;"> 
														<div id="slSfsScrollerNU">
														<%
														   try {
															
														    
															   %>
															   <div class="table" id="listNU">
															    
														 	  <%
														 	  for(nLoopCount = 0 ; nLoopCount < nListSizeNU; nLoopCount++)
														 	  {
														 		 sfsUnitNU = objSfsDetailsNU.get(nLoopCount);
														 		  if(sfsUnitNU != null )
																  {
														 			 nursingCode=sfsUnitNU.getsCode();
													 		  %>
																		    <div class="listItemNU" style="width:100%; height:40px;" onClick="showTick('<%=nursingCode%>','NU')" data-nursingunitcode="<%=nursingCode%>" data-nursingunitdesc="<%=sfsUnitNU.getsDescription()%>">
																				<div class= "cell slSfsViewItemText slSfsViewItemTextTheme" id="textNU<%=nursingCode%>"><%=sfsUnitNU.getsDescription()%></div>
																				<div class="cell slSfsListTick"><div class="slSfsTickVisibleNU SLSfsCircleVisibleTheme" id="slSfsTickNU<%=nursingCode%>" style="display:none"></div></div>
																			</div>
															
															 	<%
														  		}
														  		nRowCount = nRowCount + 1;
																} 
														 	 	%>
																</div>
															
													  						
										  				</div>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row slSfsAfterSelection" id="NUAfterSel">
											<div class="cell">
												<div class="table" style="padding-left:10px;display:block" id="AfterSelectionNU"></div>
											</div>
										</div>
										<%  
										   }catch ( Exception e ){
												e.printStackTrace();
												}
												finally{
										  }
										  }
										%> 
										</div>
										<!-- NU Content ends here-->
								</div> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div><!-- end of main table -->
		
		<input type = "hidden" name ="hdnSelectedPractiotinerID" id ="hdnSelectedPractiotinerID" value = "<%=objInPatientContext.getPractionerId()%>"/>
		<input type = "hidden" name ="hdnClinicianId" id ="hdnClinicianId" value = "<%=objInPatientContext.getClinicianId()%>"/>
		<input type = "hidden" name ="hdnSfsClinicianId" id ="hdnSfsClinicianId" value = "<%=oSFSContext.getsPractionerId()%>"/>
		<input type = "hidden" name ="hdnLoggedInUser" id ="hdnLoggedInUser" value = "<%=objInPatientContext.getClinicianId()%>"/>
		<input type = "hidden" name ="hdnLoggedInUserDesc" id ="hdnLoggedInUserDesc" value = "<%=fPractitionerName%>"/>
		
		<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
	</form>	
</body>
</html>

