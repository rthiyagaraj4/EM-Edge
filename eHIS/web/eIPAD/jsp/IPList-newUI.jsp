
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
	request.setCharacterEncoding("UTF-8");
	SFSContext oSfsContext = new SFSContext();
	InPatientContext oInPatientContext = new InPatientContext();
	oInPatientContext.setRequest(request);
	String facility_id= ""; //(String)session.getValue("facility_id");
	String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
	String sPatientId = "" ;
	String sNursingUnitCode = "";
	String sNursingUnit = "";
	String sClinicianDesc = "";
	String sSpecialityCode = "";
	String sSpeciality = "";
	String sOrderBy = "";
	String sFacilityId = "";
	String sPractionerId = "";
	String sfsPractionerId = "";
	String sPractionerDesc = "";
	boolean patPractRelReqd = false;
	Gson gson = new Gson();
	List<String> allPatientIds = new ArrayList<String>();
	List<String> allEncounerIds = new ArrayList<String>();
	 
	if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
	{
		facility_id = (String)session.getValue("facility_id");
		oInPatientContext.setFacilityId(facility_id);
	}
	
	if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
	{
		clinicianId = (String)session.getValue("ca_practitioner_id");
		oInPatientContext.setClinicianId(clinicianId);
	}
	String className = "dvLegendNotRequired";
	StringTokenizer st = null;
	String deceasedYn = "";
	int noofchildren = 0;
	String relationYn = "";
	String tempDischargeDate = "";
	String strPatientName = "";
	String strPatientIdGender ="";
	String strPatientDetails = "";
	
	
	if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "" && request.getParameter("hdnPatientId") != " ")
	{
	 
		sPatientId = ((String)request.getParameter("hdnPatientId")).trim();
		oInPatientContext.setPatientId(sPatientId);
	 
	}
	
	if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
	{
	  
	 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
	 oInPatientContext.setNursingUnitCode(sNursingUnitCode);
	}
	if(request.getParameter("hdnClinicianId") != null && request.getParameter("hdnClinicianId") != "" && request.getParameter("hdnClinicianId") != " ")
	{
	
	 sPractionerId = (String)request.getParameter("hdnClinicianId");
	 oInPatientContext.setPractionerId(sPractionerId);
	 
	}
	if(request.getParameter("hdnSfsClinicianId") != null )
	{
	
	 sfsPractionerId = (String)request.getParameter("hdnSfsClinicianId");
	 oSfsContext.setsPractionerId(sfsPractionerId);

	}
	if(request.getParameter("hdnSpeciality") != null && request.getParameter("hdnSpeciality") != "" && request.getParameter("hdnSpeciality") != " ")
	{
	
	 sSpecialityCode = (String)request.getParameter("hdnSpeciality");
	 oInPatientContext.setSpecialityCode(sSpecialityCode);
	}
	
	if(request.getParameter("hdnOrderBy") != null &&  request.getParameter("hdnOrderBy") != "")
	{
		
		sOrderBy = (String)request.getParameter("hdnOrderBy");
		oInPatientContext.setOrderBy(sOrderBy);
	}
	
	
	if(request.getParameter("txtPracId") != null &&  request.getParameter("txtPracId") != "")
	{
		
		sPractionerDesc = (String)request.getParameter("txtPracId");
		oInPatientContext.setPractionerDesc(sPractionerDesc);
	}
	
	if(request.getParameter("txtNursingUnit") != null &&  request.getParameter("txtNursingUnit") != "")
	{
		
		sNursingUnit = (String)request.getParameter("txtNursingUnit");
		oInPatientContext.setNursingUnit(sNursingUnit);
		
	}
	if(request.getParameter("txtSpeciality") != null &&  request.getParameter("txtSpeciality") != "")
	{
		
		sSpeciality = (String)request.getParameter("txtSpeciality");
		oInPatientContext.setSpeciality(sSpeciality);
		
	}
	

%>
<!DOCTYPE html> 
<html> 
<head> 
<title>IP View</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> -->


<link rel="stylesheet" href="../css/iPadNew_IP.css" />  
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<link rel="stylesheet" href="../css/iPADNew.css" />  
<script src="../jquery-1.9.1.min.js"></script>  

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> -->
<script type="application/javascript" src="../js/iscroll.js"></script>


<script type="text/javascript">
//variables for setting the content frame height according to the device
//below values are header footer heights



//parent.removeSpinner();
//var legendsScroll ;
function loaderInd() {
	setTimeout(function () {
		 parent.legendsScroll = new iScroll('legendWrapper');
	}, 100);
	
} 


document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaderInd, false);



var header_borderheight= 90;
var content_height;

var scrollContent1 ;
var scrollNav;
var ArrayOfPats=[];
var ArrayOfEncounter=[];

function loaded1() {
	//scrollContent1 = new iScroll('divcnt');
	//scrollNav = new iScroll('contentWrapper2');
	setTimeout(function () {
		parent.scrollContent1 = new iScroll('divcnt');
	}, 100);
	}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaded1, false);

var indicatorTypeScroll;

 $(document).ready(function () {
	 var ipCount =  document.getElementById("hdnIPCount").value;
	 parent.updateIPCount(ipCount);
	 //click, long press and swipe events of patient list are managed in below code
	var pressTimer;
	var ua = navigator.userAgent,
    evnt = (ua.match(/iPad/i)) ? "touchstart" : "click";
	$(".IPContentTableTheme").bind(evnt,function(event){
		var swipeEvent=false;
		pressTimer = window.setTimeout(function() {
			  //this is a tap-hold
		$('#RecordConsentQAItem').hide();
		var  patientId =$(event.currentTarget).attr("data-patientid");	
		$("#lpPatientId").val(patientId);
		if($('#Consent_'+patientId).is(":visible")){
			$('#RecordConsentQAItem').show();
		}
		$("#navTypeModal").show();
		var  episodeId =$( event.currentTarget ).attr("data-episodeId");
		$("#lpEpisodeId").val(episodeId);
		var  admDateTime =$( event.currentTarget ).attr("data-admDateTime");
		$("#lpAdmDateTime").val(admDateTime);
		var  dischargeDateTime =$( event.currentTarget ).attr("data-dischargeDateTime");
		$("#lpDischargeDateTime").val(dischargeDateTime);
		var  locationType =$( event.currentTarget ).attr("data-locationType");
		$("#lplocationType").val(locationType);
		var  locationCode =$( event.currentTarget ).attr("data-locationCode");
		$("#lpLocationCode").val(locationCode);
		var  serviceCode =$( event.currentTarget ).attr("data-serviceCode" );
		$("#lpServiceCode").val(serviceCode);		
		event.preventDefault();				

		$(".navModal-content").css('position',"absolute");
		$(".navModal-content").css('top',"0");
		$(".navModal-content").css('right',"0");
		$(".navModal-content").css('left',"0");
		$(".navModal-content").css('bottom',"0");
			},750);
	if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
						//behaviour for end
		$(".IPContentTableTheme").bind("touchend", function(e){
					clearTimeout(pressTimer);
					if(!swipeEvent){
						
					var  patientId =$(event.currentTarget).attr("data-patientid");	
					$("#lpPatientId").val(patientId);
					var  episodeId =$( event.currentTarget ).attr("data-episodeId");
					$("#lpEpisodeId").val(episodeId);
					var  admDateTime =$( event.currentTarget ).attr("data-admDateTime");
					$("#lpAdmDateTime").val(admDateTime);
					var  dischargeDateTime =$( event.currentTarget ).attr("data-dischargeDateTime");
					$("#lpDischargeDateTime").val(dischargeDateTime);
					var  locationType =$( event.currentTarget ).attr("data-locationType");
					$("#lplocationType").val(locationType);
					var  locationCode =$( event.currentTarget ).attr("data-locationCode");
					$("#lpLocationCode").val(locationCode);
					var  serviceCode =$( event.currentTarget ).attr("data-serviceCode" );
					$("#lpServiceCode").val(serviceCode);
					
					if ($('#navTypeModal').css('display') == 'none') {
						openPatient(patientId,episodeId,admDateTime,dischargeDateTime,locationType,locationCode,serviceCode)
					}

							
					event.preventDefault();
					}
		  $(".IPContentTableTheme").off('touchend');
		});
		//behaviour for  move
		$(".IPContentTableTheme").bind('touchmove', function(e){
			swipeEvent = true;
		});
	}else{
	    $(".IPContentTableTheme").bind("mouseleave", function () {
            		clearTimeout(pressTimer);
					var  patientId =$(event.currentTarget).attr("data-patientid");	
					$("#lpPatientId").val(patientId);
					var  episodeId =$( event.currentTarget ).attr("data-episodeId");
					$("#lpEpisodeId").val(episodeId);
					var  admDateTime =$( event.currentTarget ).attr("data-admDateTime");
					$("#lpAdmDateTime").val(admDateTime);
					var  dischargeDateTime =$( event.currentTarget ).attr("data-dischargeDateTime");
					$("#lpDischargeDateTime").val(dischargeDateTime);
					var  locationType =$( event.currentTarget ).attr("data-locationType");
					$("#lplocationType").val(locationType);
					var  locationCode =$( event.currentTarget ).attr("data-locationCode");
					$("#lpLocationCode").val(locationCode);
					var  serviceCode =$( event.currentTarget ).attr("data-serviceCode" );
					$("#lpServiceCode").val(serviceCode);
					
					if ($('#navTypeModal').css('display') == 'none') {
						openPatient(patientId,episodeId,admDateTime,dischargeDateTime,locationType,locationCode,serviceCode)
					}					
					event.preventDefault();
        });
	}
	});	
	 $("#closePoPUp").bind(evnt,function(e){
		 $("#navTypeModal").css("display","none");
	 });
	 
	$('#navTypeModal').click(function (e) {	
    if ($(e.target).is("#navTypeModal")) {
        if ($('#navTypeModal').is(':visible')) {
            $('#navTypeModal').hide();
        }
    }  
    }); 
	 
	
	 parent.setIframeHeight();
	var currentOrderBy = document.getElementById("hdnOrderBy").value;
    if(currentOrderBy == "" || currentOrderBy == "OR")
    	$('#orderByNone').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "patient_name")
    	$('#orderByPatientName').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "physician_name")
    	$('#orderByPhysicianName').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    else if(currentOrderBy == "bed_num")
    	$('#orderByBedNum').removeClass('WidgetFilterButtonTheme').addClass('WidgetFilterButtonSelTheme');
    
    //submitting form when space or enter key is pressed in the patient id text box
    $('#txtPatientId').bind('keypress', function(e) {
        if (e.which == 32){//space bar
            //alert('space');
        	ipFormSubmit();
        }
        if (e.which == 13){//enter key
            //alert('enter');
        	ipFormSubmit();
        }
        
	});
    
    //------scroll----------
    //sfsrelated code below
    $("#btnsfs").bind('touchstart', function(event) { 
        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get 'touches' 
        var e = event.originalEvent;
        var scrollStartPos =  e.touches[0].pageY;
        scrollStartPos = scrollStartPos;
        var tleft = e.touches[0].pageX - "15"
         $("#sfs").css('z-index', "1000");
         $("#sfsarrow").css('z-index',"1000");
    }); 
 });
 
 
 function changeOrientation(orient, HFheight)
 {
 	content_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;
	document.getElementById("divcnt").style.height = content_height+"px";
	
	if(parent.scrollContent1 != null)
	parent.scrollContent1.refresh();
 }

 function clearPatientIdText()
 {
	 document.getElementById("txtPatientId").value="";
	 document.getElementById("hdnPatientId").value ="";
 }
 function toggleLegend(){
	
	 $('#legendContainer').toggle(); 
	 var totalWidth = 0;
	 $('#legendScroller .legendTabs').each(function(index) {
     totalWidth += parseInt($(this).outerWidth());
   	});
	$('#legendScroller').css("width",(totalWidth+90)+'px');
	
	setTimeout(function () {
		parent.legendsScroll.refresh();
    }, 0);	
	
 }
 function hideLegend(){
	 $('#legendContainer').hide(); 
 }
 function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)
 {
	
	 //window.parent.slidee("true");
	
	//alert(patientid);
	//alert("hi");
	//alert(episodeId);
	window.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode);
	//document.getElementById("IpForm").submit();
	//window.open("Appointment.html");
 }
 function show(objBtn)
 {
	  //alert("hiii");
	    var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
		//var myFeatures = myBars + ', ' + myOptions ;
		var myFeatures =  myOptions ;
		//var ecisWindow = open( 'iPadWidget.html', 'iPadWidget.html', myFeatures,false ) ;
		
		//var retval = window.showModalDialog("AppView.jsp", "", myFeatures);
		//$.mobile.changePage('#Dialog',{role:'dialog'})
		//$.mobile.changePage('#Dialog',{role:'dialog',transition: "pop"})
	//	document.getElementById("srchFrame").src = "appview.html";
    //   $.mobile.changePage("#Dialog", "slide" , false,false);
		//alert("finished");
		objBtn.style.border = "3px solid #48d1d8";
		document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
		 document.getElementById("hdnNursingUnit").value = "";
		 document.getElementById("hdnClinicianId").value = "";
		 document.getElementById("hdnSpeciality").value = "";
		//document.getElementById("hdnClinicianId").value = document.getElementById("txtPracId").value;
		//document.getElementById("hdnNursingUnit").value = document.getElementById("txtNursingUnit").value;
		//document.getElementById("hdnSpeciality").value = document.getElementById("txtSpeciality").value;
		document.getElementById("IpForm").submit();


 }

 function ipFormSubmit()
 {
	 //$.trim($("#hdnPatientId").val($.trim($("#txtPatientId").val())));
	 //alert(document.getElementById("txtPatientId").value.length);
	 //var trimmedPatId= document.getElementById("txtPatientId").value.trim();
	 //alert(trimmedPatId.length);
	 document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
	 document.getElementById("IpForm").submit();
 }


 function fnOrderBy(orderByVal)
 {
	//alert(orderByVal);
	 document.getElementById("hdnOrderBy").value = orderByVal;
	 document.getElementById("IpForm").submit();
 }

 function showsfs()
 {
 
 	document.getElementById("sfsFrame").src = "IPSearch-newUI.jsp";
 	$("#sfs").css('z-index', "1000");
 	$("#sfsarrow").css('z-index',"1000");
 	$('#sfs').toggle();
 	$('#sfsarrow').toggle();
 
 }


 
 function refresh(){
	 document.getElementById("hdnOrderBy").value = "";
	 document.getElementById("hdnPatientId").value = "";
	 document.getElementById("hdnNursingUnit").value = "";
	 document.getElementById("hdnClinicianId").value = "";
	 document.getElementById("hdnSpeciality").value = "";
	 document.getElementById("IpForm").submit();
 }
 function showNoRelationError(){
	 parent.showErrorWindow('No Patient Practitioner Relationship exists');
 }
 
 function action(navType){ 
	 $("#PageLoadingAnimation").show();
	 var patientid = $("#lpPatientId").val();
	 var episodeId = $("#lpEpisodeId").val();
	 var admitDate = $("#lpAdmDateTime").val();
	 var dischargeDateTime = $("#lpDischargeDateTime").val();
	 var locnType = $("#lplocationType").val();
	 var locnCode = $("#lpLocationCode").val();
	 var servicecode = $("#lpServiceCode").val();
	 window.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode,navType);	 
	} 
 function slidesfsSearch(patientID){

	 /* alert(patientID); */
	 document.getElementById("hdnPatientId").value = patientID;
	 document.getElementById("hdnNursingUnit").value = "";
	 document.getElementById("hdnClinicianId").value = "";
	 document.getElementById("hdnSpeciality").value = "";
	 document.getElementById("IpForm").submit();
 }
 function clearHdnPatientValue(){
	 document.getElementById("hdnPatientId").value = "";
 }
 function selectedPract(val, desc,  dPage){
	 document.getElementById("hdnClinicianId").value = val;
	 document.getElementById("hdnSfsClinicianId").value = val;
	 window.parent.$("#SlideSfsFrame").contents().find("#IpSearchForm").append('<input type="hidden" id="selectedPractID" name="selectedPractID" id="selectedPractID" value="'+val+'" />');
	 window.parent.$("#SlideSfsFrame").contents().find("#IpSearchForm").submit();
	 window.parent.$("#SlideSfsFrame").contents(). find("#slSfsTickPR"+val).show();
	 document.getElementById("IpForm").submit();
	 
 }
 
 function hideRows(arrSP,arrPR,arrNU){
	var SPArray =[];
	var NUArray =[];
	 var totalCount = arrSP.length + arrPR.length + arrNU.length ;
	 if(totalCount>0){
	  	rows = window.parent.$("#frameIP").contents().find("#divcnt .IPContentTable1").hide();
	  	if(arrPR.length>0){
			 for( var j =0;j<arrPR.length;j++){
					var code = arrPR[j];
					$("[data-pract = '"+code+"']").each(function (i,v ){
						$(this).show();
						parent.scrollContent1.refresh();
					});
			  }
		}
				  if(arrSP.length>0){
					 for( var j =0;j<arrSP.length;j++){
						var code = arrSP[j];
						window.parent.$("#frameIP").contents().find("[data-speccode = '"+code+"']").show();
						parent.scrollContent1.refresh();
					}
				
				 window.parent.$("#SlideSfsFrame").contents().find(".listItemNU[data-nursingunitcode]").hide();
				 window.parent.$("#frameIP").contents().find(".IPContentTable1").each(function (i,v ){
								if($(this).is(":visible")){
								  var nCode =$(this).attr('data-nursingunitcode');
								   NUArray.push(nCode);
								}
				 });
				 window.parent.$("#SlideSfsFrame").contents().find(".listItemNU").removeClass('filteredNU');
				for(var i=0; i<NUArray.length; i++){
					 var code = NUArray[i];
					window.parent.$("#SlideSfsFrame").contents().find(".listItemNU[data-nursingunitcode = '"+code+"']").show().addClass('filteredNU');
				}
	 	}
	  	else{
	  		if(arrNU.length>0){
	  			parent.scrollContent1.refresh();
	  		}
	  		else{
		  		window.parent.$("#SlideSfsFrame").contents().find(".listItemNU").show();
		  		window.parent.$("#SlideSfsFrame").contents().find(".listItemSP").show();
		  		window.parent.$("#frameIP").contents().find(".IPContentTable1").show();
	  		}
	  	}
			 if(arrNU.length >0){
					 for( var j =0;j<arrNU.length;j++){
							var code = arrNU[j];
							window.parent.$("#frameIP").contents().find("[data-nursingunitcode = '"+code+"']").show();
							parent.scrollContent1.refresh();
					  }
				 
					window.parent.$("#SlideSfsFrame").contents().find(".listItemSP[data-speccode]").hide();
					 window.parent.$("#frameIP").contents().find(".IPContentTable1").each(function (i,v ){
									if($(this).is(":visible")){
									  var sCode =$(this).attr('data-speccode');
									   SPArray.push(sCode);
									}
					 });
					  window.parent.$("#SlideSfsFrame").contents().find(".listItemSP").removeClass('filteredSP');
					for(var i=0; i<SPArray.length; i++){
						 var code = SPArray[i];
						window.parent.$("#SlideSfsFrame").contents().find(".listItemSP[data-speccode = '"+code+"']").show().addClass('filteredSP');;
					}
					
			 }
			 if(arrSP.length>0 && arrNU.length>0){
				  window.parent.$("#frameIP").contents().find(".IPContentTable1").hide();
				  window.parent.$("#frameIP").contents().find("[data-speccode='"+arrSP[0]+"'][data-nursingunitcode = '"+arrNU[0]+"']").show(); 
				  parent.scrollContent1.refresh();
			 }
		 
	 }
	 else if(totalCount==0){
		rows= window.parent.$("#frameIP").contents().find("#divcnt .IPContentTable1").show();
			  window.parent.$("#SlideSfsFrame").contents().find(".listItemNU,.listItemSP").show(); 
			  parent.scrollContent1.refresh();
		 }
	parent.removeSpinner();
	 
 }
 function addSpinner(){
	var a = $("#spinnerDiv")

	if(a.length ==0)
		$("#divContent").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function removeSpinner(){

	var a = $("#spinnerDiv")

	if(a.length > 0)
	$("#spinnerDiv").remove();
}
//Added by Subha-V20190403/KDAH-CRF-0517/Starts
function openPatientTasksDiv(patientId,encounterId){
	$(".overlayDivPatTasksClass").hide();
	$(".loadingPatientTasks").hide();
	$("#OverlayDivPatTasks_"+patientId).show();
	
	$("#loadingPatientTasks_"+patientId).show();
	var path = $("#hdnPath").val();
	var facilityId = $("#facilityId").val();
	var clinicianId = $("#clinicianId").val();
	var validationPath = path + '/mobile/ip/InPatientTasksJSONServlet';
    $.getJSON(validationPath, {
            patientId: patientId,
            encounterId: encounterId,
            facilityId: facilityId,
            clinicianId: clinicianId,
            requestMode: 'PATIENT_TASKS'
        })
        .done(function(json) {
            var result_chargeCons = json.chargeConsultationTask.taskPending;
            $("#loadingPatientTasks_"+patientId).hide();
            if(result_chargeCons){
            	$("#ChargePatientBtn_"+patientId).removeClass("imgGrayscale");
            	$("#ChargePatientBtn_"+patientId).attr('onClick', 'chargePatient(this);');
            }else{
            	$("#ChargePatientBtn_"+patientId).addClass("imgGrayscale");
            	$("#ChargePatientBtn_"+patientId).attr('onClick', '');
            }
            //alert(result_chargeCons);
        })
        .fail(function(jqxhr, textStatus, error) {
            var err = textStatus + ", " + error;
        });
}

function closePatientTasksDiv(patientId){
	if($("#OverlayDivPatTasks_"+patientId).is(":visible")){
		$("#OverlayDivPatTasks_"+patientId).hide();
	}
}

function chargePatient(btnObj){
	var path = $("#hdnPath").val();
	var facilityId = $("#facilityId").val();
	var clinicianId = $("#clinicianId").val();
	var loginuserid = $("#loginuserid").val();
	var client_ip_address = $("#client_ip_address").val();
	var patientId = $(btnObj).data("patientid");
	var encounterId = $(btnObj).data("encounterid");
	var validationPath = path + '/mobile/ip/InPatientTasksJSONServlet';
	$("#loadingPatientTasks_"+patientId).show();
    $.getJSON(validationPath, {
            patientId: patientId,
            encounterId: encounterId,
            facilityId: facilityId,
            clinicianId: clinicianId,
            loginuserid: loginuserid,
            client_ip_address: client_ip_address,
            requestMode: 'PATIENT_CHARGE'
        })
        .done(function(json) {
            $("#ChargePatientBtn_"+patientId).addClass("imgGrayscale");
            $("#loadingPatientTasks_"+patientId).hide();
            var msg = json.errorsList[0].errorMessage;
            if(msg) {
            	if(json.transactionResult == -1){
            		showTransactionMessageFailed(msg);
            	}else{
            		showTransactionMessageSuccess(msg);
            	}
            }
            else {
            	if(json.transactionResult == -1){
            		showTransactionMessageFailed("Failed to Charge");
            	}else{
            		showTransactionMessageSuccess("Charged successfully");
            	}
            }
            closePatientTasksDiv(patientId);
        })
        .fail(function(jqxhr, textStatus, error) {
        		$("#loadingPatientTasks_"+patientId).hide();
	            var err = textStatus + ", " + error;
	            console.log(err);
	            var errChargeMsg = json.errorsList[0].errorMessage;
           		if(errChargeMsg)
            		showTransactionMessageFailed(errChargeMsg);
            	else
            		showTransactionMessageFailed("Failed to Charge");
           		closePatientTasksDiv(patientId);
        });
}

function showTransactionMessageSuccess(msg){
	hideLegend();
	$("#transactionMsg").removeClass("formValErrorTheme").addClass("formValSuccessTheme");
	$("#transactionMessageContent").html(msg)
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}

function showTransactionMessageFailed(msg){
	hideLegend();
	$("#transactionMsg").removeClass("formValSuccessTheme").addClass("formValErrorTheme");
	$("#transactionMessageContent").html(msg)
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}
//Added by Subha-V20190403/KDAH-CRF-0517/Ends
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <style>
 #PageLoadingAnimation{
	z-index: 10000;
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background-color: #808080;
	opacity: 0.6;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	display: none; 
}
.loadingCartItem {
	width: 100%;
	height: 80px;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
}
.loadingPatientTasks {
	width: 100%;
	height:100%;
	background:rgba(0,0,0,0.2);
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	 z-index: 99;
	 position:absolute;
	 display:none;
}
.ipContentMoreBtn{
	background-image: url(${path}/eIPAD/images/more_vertical24x24.png);
	background-repeat: no-repeat;
	background-position: 50% 50%;
}
.imgGrayscale {
    -webkit-filter: grayscale(1);
    opacity: 0.7;
}
.CSTransactionMessage{
    
    border-radius: 5px 5px 5px 5px;
    /*box-shadow: 0 2px 2px 2px #D0D0D0;*/
    height: 45px;
    margin-top: 0;
	opacity: 0.8; 
    position: absolute;
    text-align: left;
    width: 95%;
    z-index: 100;
}
 </style>
 </head>
<body style= "width:100%; height:100%;"  >
<div id="PageLoadingAnimation" class="absoluteCenter"></div>
                        <div id="navTypeModal" class="navModal">
						           <div class="navModal-content">
						                 <div class="navAccess">QUICK ACCESS</div>
						                 <div class="navScroll">
                                          <div class="popTable navControl" onclick="action('clinicalNotes')">
											<div class="popTableRow">
												<div class="popTableRowCellLab">
														<img src="${path}/eIPAD/images/ClinicalNote16x16.PNG">
												</div>
												<div class="popTableRowCellCont">Clinical Notes</div>
												<div class="popTableRowCellClick">
													
														<img src="${path}/eIPAD/images/Arrow_24x24.png">
													
												</div>
											</div>
					                        </div>
					                        
					                        <div class="popTable navControl" onclick="action('placeOrder')">
											<div class="popTableRow">
												<div class="popTableRowCellLab">
													
														<img src="${path}/eIPAD/images/PlaceOrder16x16.PNG">
													
												</div>
												<div class="popTableRowCellCont">Place Order</div>
												<div class="popTableRowCellClick">
													
														<img src="${path}/eIPAD/images/Arrow_24x24.png">
													
												</div>
											</div>
					                        </div>
					                        
					                        <div class="popTable navControl" onclick="action('recordConsent')" style="display:none" id="RecordConsentQAItem">
											<div class="popTableRow">
												<div class="popTableRowCellLab">
													
														<img src="${path}/eIPAD/images/Consent16x16.PNG">
													
												</div>
												<div class="popTableRowCellCont">Record Consent</div>
												<div class="popTableRowCellClick">
													
														<img src="${path}/eIPAD/images/Arrow_24x24.png">
													
												</div>
											</div>
					                        </div>
					                        
					                        <div class="popTable navControl" onclick="action('clinicalEvents')">
											<div class="popTableRow">
												<div class="popTableRowCellLab">
													
														<img src="${path}/eIPAD/images/ClinicalEvent16x16.PNG">
													
												</div>
												<div class="popTableRowCellCont">Clinical Events</div>
												<div class="popTableRowCellClick">
													
														<img src="${path}/eIPAD/images/Arrow_24x24.png">
													
												</div>
											</div>
					                        </div>
					                        
					                        <div class="popTable navControl" onclick="action('pharmacy')">
											<div class="popTableRow">
												<div class="popTableRowCellLab">
													
														<img src="${path}/eIPAD/images/Pharmacy_Quick16x16.PNG">
													
												</div>
												<div class="popTableRowCellCont">Pharmacy Order</div>
												<div class="popTableRowCellClick">
													
														<img src="${path}/eIPAD/images/Arrow_24x24.png">
													
												</div>
											</div>
					                        </div>
					                        
                                          </div>
								         <div class="navCancel"  id="closePoPUp"><div style="padding-right: 10px;">CANCEL</div></div>   
						          </div>
						</div>  
	<div id = "sfsarrow" data-role = "none" class = "sfs-bubble-arrow sfs-bubble-arrowIPTheme" ></div>
   	<div data-role = "none" class = "sfs sfsIPTheme"  id = "sfs" >
  	 	<iframe id = "sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height = "300px" width = "340px" src = "IPSearch-newUI.jsp"></iframe>  
   	</div> 
	<div data-role = "page" class="ipListParent" style = "padding:0px;width:100%;height:100%;">
		<form name='IpForm' id='IpForm' method='post' id="IpForm" style = "width:100%;height:100%;">
			<div class ="ipHeader">
				<div class="ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme">
					<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						<tr style = "height:100%;width:100%">
							<td style = "width:50px; padding-left:5px;">
			        			<div class = "WidgetButtonTheme" onclick="parent.toggleMenu()"><img src = "../images/MenuIcon.png"/></div>
			   				</td>
			    			<td style = "width:auto">
			         			<div class = "ipHeaderPageTitle ipHeaderPageTitleTheme"> In Patient</div>
			   				</td>
					   		<!--<td style = "width:200px">
					         		<div class="ipHeaderSearchPatientText ipHeaderSearchPatientTextTheme">
					         		<table cellpadding = "0" cellspacing = "0" border = "0"><tr>
								   	<td style="width:5%; padding-top:5px"><img src="../images/Search.png" onclick="show(this)" style="margin-left:5px;"/></td>
								    <td style="width:90%;">
								        	<input type="text" name = "txtPatientId" id = "txtPatientId"  placeholder="Patient ID" onchange="show(this)" class="ipHeaderSearchPatientTxtBox ipHeaderSearchPatientTxtBoxTheme" value = "<%=oInPatientContext.getPatientId() %>">
								    </td>
								   	<td style="width:5%; padding-top:5px;padding-right:6px"><img src="../images/Close-small.png" style="padding-right: 10px" onclick="clearPatientIdText()"/></td>
								   	</tr></table>
								   	</div>
					   		</td>
							<td style = "width:50px; padding-left:5px;padding-right:5px;text-align:right" onclick="showsfs()">
					        	<div class = "WidgetButtonTheme" id="btnsfs" ><img src = "../images/Search.png" style="padding-top:5px;"/></div>
					   		</td>-->
						</tr>
		    		</table>
				</div>

	  			<div class = "ipHeaderMenuContainer2">
	  				<div  data-role ="none" class ="ipContentHolderHeader ipContentHolderHeaderTheme">
						<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  				<tr style = "height:100%;width:100%">
							    <td style = "width:10%">
							         <span class = "ipContentHolderRefreshIcon"><img src = "../images/Refresh_black.png" onclick="refresh()"/></span>
							    </td>
							    <td></td>
							    <td style = "width:50%;padding-right:10px;" align = "right" valign = "center">
							    	<table class= "ipContentHolderIconContainer WidgetFilterContTheme" cellpadding = "0" cellspacing = "0" border = "0">
									    <tr>
											<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('OR')" id="orderByNone"><img src = "../images/view01.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('bed_num')" id="orderByBedNum"><img src = "../images/ByBed.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('patient_name')" id="orderByPatientName"><img src = "../images/ByPatient.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme" onclick="fnOrderBy('physician_name')" id="orderByPhysicianName"><img src = "../images/View03.png" style="vertical-align: middle;"/></td>
								        </tr>
						        	</table>	
						    	</td>
			 				</tr>
		    			</table>	  
	  				</div>
	  			</div>
	  		</div>
    		<div id = "divcnt"  class = "divIPcontent divIPcontentTheme" style="overflow:hidden">
				<div style = "width:100%;height:auto;overflow:auto" >
				  <%
				  int nClassCount = 1;
				  int cnt = 0;
				  String Status = "";
				  String emergencyYn = "";
				  String n = null;
				  
				  InPatientList bean = new InPatientList();
				  //Check if Practioner Patient Relationship is enabled in the setup
				  patPractRelReqd = bean.patientPractRelnReqdYN().equals("Y")?true:false;
				  List<InPatients> objInPatientList = new ArrayList<InPatients>(); 
				  int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
				  int nCssCount = 1;  // To display alternate Row Color.
				 
				  int nListSize = 0;
			
				  int nLoopCount = 0;
				  InPatients oInPatients = null;
				  try {
					  objInPatientList = bean.getInPatientLis(oInPatientContext);
					  if(objInPatientList != null)
					  {
					       nListSize =  objInPatientList .size();
					       
					  }
					 if(nListSize > 0)
					 {
					   for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
						{
					 
						   oInPatients = objInPatientList.get(nLoopCount); 
						   
						   allPatientIds.add(oInPatients.sPatientId);
						   allEncounerIds.add(oInPatients.sEpisodeId);
						   
						   
						  //System.out.println("all values sizes::"+allPatientIds.size()); 
						   
						   if(oInPatients != null)
						   {
					        Status = oInPatients.sStatus;
					        st = new StringTokenizer(Status,"|");
							  while (st.hasMoreTokens())
								{
									emergencyYn = st.nextToken();
									deceasedYn = st.nextToken();
									n = st.nextToken();
									if(!(n == null || n.equals("")))
										noofchildren = Integer.parseInt(n);
									relationYn = st.nextToken();
								}
					  
							  if(oInPatients.sDischargeDateTime != null)
							  {
									if( !oInPatients.sDischargeDateTime.equals(""))
										className = "dvLegendDischargedTheme";
							  }
							  
								
								if(deceasedYn.equals("D"))
								{
									className = "dvLegendDeceasedTheme";
									
								}
								if(noofchildren > 0) 
									className = "dvLegendNewBornTheme";
								
								if(relationYn.equals("N"))
								{
									className = "dvLegendNoRelationTheme";
								}
								
								 deceasedYn = "";
								 noofchildren = 0;
								 relationYn = "";
								 tempDischargeDate = "";
								 
								 boolean openChartSum = true;
								 if(patPractRelReqd){
									 if(oInPatients.relnExists){
										 openChartSum = true;
									 }else{
										 openChartSum = false;
									 }
								 }
								 
				  %>
				  <div style="display:table;width:100%;position:relative" class="IPContentTable1" style="height:70px;max-height:110px;width:100%" id="patientID<%=oInPatients.sPatientId%>" data-patientid=<%=oInPatients.sPatientId%> data-episodeId=<%=oInPatients.sEpisodeId%> data-admDateTime=<%=oInPatients.sAdmDateTime%> data-dischargeDateTime=<%=oInPatients.sDischargeDateTime%> data-locationType=<%=oInPatients.locationType%> data-locationCode=<%=oInPatients.locationCode%>  data-serviceCode=<%=oInPatients.serviceCode%>  data-speccode="<%=oInPatients.sSpecialityCode%>"  data-nursingunitcode=<%=oInPatients.locationCode%> >
				  	<div class="loadingPatientTasks" id="loadingPatientTasks_<%=oInPatients.sPatientId%>" ></div>
				  	<div id="OverlayDivPatTasks_<%=oInPatients.sPatientId%>" class="overlayDivPatTasksClass" style="position:absolute; width:100%; height:100%;display:none;background:rgba(102,255,255,0.2)" >
				  		<div style="display:table;width:100%;height:100%">
				  			<div style="display:table-row">
				  				<div style="display:table-cell;width:90%" onclick="closePatientTasksDiv('<%=oInPatients.sPatientId%>')">
				  			
				  				</div>
				  				<div style="display:table-cell;width:200px;">
				  					<div style="display:table;width:100%;height:100%">
				  						<div style="display:table-row">
					  						<div style="display:table-cell;vertical-align:middle;text-align:center;width:100px" >
					  							<div style=" height: 60px; width: 60px" id="ChargePatientBtn_<%=oInPatients.sPatientId%>" class="imgGrayscale" data-patientid ='<%=oInPatients.sPatientId%>' data-encounterid = '<%=oInPatients.sEpisodeId%>' onclick="">
					  								<div style="">
					  									<img src="../images/invoice60x60.png"/>
					  								</div>
					  							</div>
					  						</div>
					  						<div style="display:table-cell;vertical-align:middle;text-align:center;min-width:25px" onclick="closePatientTasksDiv('<%=oInPatients.sPatientId%>')">
					  						
					  						</div>
				  						</div>
				  					</div>
				  				</div>
				  			</div>				  	
				  		</div>
				  	</div>
				  	<div style="display:table-row">
				  		<div style="display:table-cell">
				  
   					<%if(openChartSum){ %>
   						<table class = "IPContentTableTheme" style="height:70px;max-height:110px;width:100%" id="patientID<%=oInPatients.sPatientId%>" data-patientid=<%=oInPatients.sPatientId%> data-episodeId=<%=oInPatients.sEpisodeId%> data-admDateTime=<%=oInPatients.sAdmDateTime%> data-dischargeDateTime=<%=oInPatients.sDischargeDateTime%> data-locationType=<%=oInPatients.locationType%> data-locationCode=<%=oInPatients.locationCode%>  data-serviceCode=<%=oInPatients.serviceCode%>  data-speccode="<%=oInPatients.sSpecialityCode%>"  data-nursingunitcode=<%=oInPatients.locationCode%> cellpadding = "0" cellspacing = "0"  border = "0">
<%--    					<div data-patid=<%=oInPatients.sPatientId%> data-patindicator="y"></div> --%>
   					<%}else{ %>
   						<table data-patientid=<%=oInPatients.sPatientId%> data-episodeId=<%=oInPatients.sEpisodeId%> data-admDateTime=<%=oInPatients.sAdmDateTime%> data-dischargeDateTime=<%=oInPatients.sDischargeDateTime%> data-locationType=<%=oInPatients.locationType%> data-locationCode=<%=oInPatients.locationCode%>  data-serviceCode=<%=oInPatients.serviceCode%> data-speccode="<%=oInPatients.sSpecialityCode%>"  data-nursingunitcode=<%=oInPatients.locationCode%> class = "IPContentTable1 IPContentTableTheme" id="patientID<%=oInPatients.sPatientId%>" cellpadding = "0" cellspacing = "0"  border = "0" onclick = "showNoRelationError()">
   					<%} %>
        					<tr class="trIpRows1" style="background-color:white;float:left;">
	           					<td  class="ipListLeftIndicator">
	              					<div class = "<%=className %>" ></div>
	           					</td>
	           					<td style="width:70px; align="center" valign = "center" >
		           					<div class = "imgPhoto1 imgPhotoTheme">
		             					<img width="55" height="55" src="${path}/mobile/PatientImageServlet?PatientId=<%=oInPatients.sPatientId%>" class="PatImgTagTheme"/>
		             				</div>
	           					</td>
           					
	           					<script>
	           					
	           					ArrayOfPats.push("<%=oInPatients.sPatientId%>");
	           					ArrayOfEncounter.push("<%=oInPatients.sEpisodeId%>");
	           					
	           					</script>
           						<td style="width: 90%">
					            	<table style = "width:100%;padding-left:10px" border = "0" cellpadding = "0" cellspacing = "0">
					            
										<tr class="trIpChildRows" style="height:20px";>
					                		<td style="width:100%;word-break:break-all" colspan = "2" >
					                        <%  
					                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
					                        strPatientName = oInPatients.sPatientName + ",";
		  		                            strPatientIdGender = oInPatients.sPatientId + ", " + oInPatients.sGender + " " ;%>
					                         
					                          <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=strPatientName%><span class = "txtRows ptIdGender "style="color:#a3a3a3;font-weight: normal;padding-left:5px;"><%=strPatientIdGender %></span></div>
					                          
					                    	</td>
					                	</tr>
	               						<tr class="trIpChildRows" style="height:20px;">
					                         <td style="width:100%;word-break:break-all" colspan = "2">
					                          <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;">Practitioner :</span><span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f"><%=oInPatients.sPhysicianName%></span>
					                         </td>
	                         
	                					</tr>
						                <tr class="trIpChildRows" style="height:20px;">
						                    <td style="width:100%;word-break:break-all" >
						                     <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;" >Room,Bed No :</span><span class="lz-list-data1 lz-list-data1Theme" style="color:#504f4f">
						                     <%=oInPatients.sRoomNo%>, <%=oInPatients.sBedNo%><span class="lz-list-data2 lz-list-data2Theme"> On <%=oInPatients.sAdmDateTime%></span></span>  
						                   </td>
						                </tr>
					              		<tr>
					                		<td>	
					                
									          <!-- Indicator portion -->
									              
									              <div class="iplIndicators">
									               <span id="PendingTask_<%=oInPatients.sPatientId%>"><img src="../images/PaddingTask20x20.png"/></span>
									               <span id="NewResult_<%=oInPatients.sPatientId%>"><img src="../images/NewResult20x20.png"/></span>
									               <span id="Abnormal_<%=oInPatients.sPatientId%>"><img src="../images/AbnormalResult20x20.png"/></span>
									                <span id="NewNotes_<%=oInPatients.sPatientId%>"><img src="../images/NewNote20x20.png"/></span>
									                <span id="Discharge_<%=oInPatients.sPatientId%>"><img src="../images/Discharge20x20.png"/></span>
									                <span id="Medication_<%=oInPatients.sPatientId%>"><img src="../images/MedicationIndicator20x20.png"/></span>
									                <span id="Consent_<%=oInPatients.sPatientId%>"><img src="../images/Consent20x20.png"/></span>
									                <span id="PatientinOT_<%=oInPatients.sPatientId%>"><img src="../images/PatientinOT20x20.png"/></span>					            
									              </div>   
									              
									          <!-- Indicator portion -->                   	                                        			                     				       				                                       
                                 	 
							        		</td>	
					              		</tr>				             
					             	</table>
           						</td>
        					</tr>
   						</table>   
   					</div>
   					<div style="display:table-cell;width:30px;max-width:30px;min-width:30px;vertical-align:middle;border-bottom: 1px solid #eaedf2;background-color:white;" onclick="openPatientTasksDiv('<%=oInPatients.sPatientId%>', '<%=oInPatients.sEpisodeId%>')">
        					<!-- <div class = "ipContentMoreBtn"></div> -->
        					<img src="../images/more_vertical24x24.png">
     				</div>
     			</div>
     		</div>
           					
					   <%
							   }
					   className = "dvLegendNotRequired";
					     nRowCount = nRowCount + 1;
						  if(nCssCount==1)
						  {
							   nCssCount = nCssCount +1;
						  }
						  else
						  {
							  nCssCount = nCssCount -1;
						  }	 
					   }//for
					 
						 }//if listsize 
						 else
						 {
							 %>
							 <script>
							  $(document).ready(function () {
								var parentDiv = $('#divcnt').height();
								$('#NoRecordsMiddleAlign').height(parentDiv);
							  });
							  window.addEventListener("orientationchange", function() {

									var parentDiv = $('#divcnt').height();
									$('#NoRecordsMiddleAlign').height(parentDiv);
								}, true);
           					</script>
							   <div id="NoRecordsMiddleAlign" class="ipSearchResultsEmptyTheme">
									<table style = 'height:100%;width:100%'>
										<tr style = 'height:100%;width:100%'>
											<td style = 'height:100%;width:100%' align = 'center' valign = 'middle'>
												<span style = 'font-family:Arial;font-weight:normal;font-size:13px;color:#bdbdbd;'>No Records Found</span>
											</td>
										</tr> 
									</table>
							   </div>
							 <% 
						 }
					  %>
					  
 <script>
		             
$(document).ready(function(){
	var path;
    var vals;  
	  
	  var allEncount;
	path = document.getElementById("hdnPath").value;
    // alert("allPatsIds:"+path);
     
	  vals=ArrayOfPats;  
	  
	  allEncount=ArrayOfEncounter;
	$.ajax({
		  method: "GET",
		  url: path+"/mobile/InPatientDetails/IpIndicator",
		  data: {pat_ids: vals.join(),encounter_ids:allEncount.join()}
	})
	.done(function(response) {
		parent.removeSpinner();
		if(response==null){		
		   return;
			}
			
	
	var data=response;

	for(var i =0 ;i<data.length;i++){
		
		var patientObj=data[i];
		
		
	var patientID=patientObj.patId;

	//var allTypesOfFilter=patientObj.typesOfIndicator;
	var indicatorDetails=patientObj.typesOfIndicator;


	/* var newNotes="NewNotes_"+patientID;
	var pendingTask="PaddingTask_"+patientID;
	var abnormal="Abnormal_"+patientID;
	//var discharge="Discharge_"+patientID;
	var note="New_"+patientID;
	 */

	/* var meds="Medication_"+patientID;
	var consent="Consent_"+patientID;
	var otPats="PatientinOT_"+patientID;
	 */


		for(var j=0;j<indicatorDetails.length;j++){		
			var indicators=indicatorDetails[j];
			
			if(indicators.indicatorType=="newnotes"){
				
			//var check=indicators.showIndicator;
			
			if(indicators.showIndicator){
				
				
				$('#NewNotes_'+patientID).css("display","inline-block");
			}else{
				
				$('#NewNotes_'+patientID).hide();
			}
			
			}
			
			if(indicators.indicatorType=="pending"){
				
				//var check=indicators.showIndicator;
				
				if(indicators.showIndicator){
					
					$('#PendingTask_'+patientID).css("display","inline-block");
				}else{
					
					$('#PendingTask_'+patientID).hide();
				}
				
				}
			
			
			if(indicators.indicatorType=="abnormal"){
				
				//var check=indicators.showIndicator;			
				if(indicators.showIndicator){				
					$('#Abnormal_'+patientID).css("display","inline-block");
				} 
				else
				{				
					$('#Abnormal_'+patientID).hide();
				}
				
				}
			
			 if(indicators.indicatorType=="newresult"){
					
					//var check=indicators.showIndicator;
					
					if(indicators.showIndicator){
						
						$('#NewResult_'+patientID).css("display","inline-block");
					}else{
						
					     $('#NewResult_'+patientID).hide();
					}
					
					}
			 
			 
	         if(indicators.indicatorType=="discharge"){
					
					//var check=indicators.showIndicator;
					
					
					
					if(indicators.showIndicator){
						
						$('#Discharge_'+patientID).css("display","inline-block");
					}else{
						
						$('#Discharge_'+patientID).hide();
					}
				}
		         if(indicators.indicatorType=="consent")
			 {
				
				if(indicators.showIndicator)
				{
					
				$('#Consent_'+patientID).css("display","inline-block");
				}
				else
				{
					
					$('#Consent_'+patientID).hide();
				}
			}
				
				}
     
		parent.scrollContent1.refresh();
	}


	//call for Record/sign
		//recordNotes(operation_mode);

	});

});


 </script>
					  
					  
				 
   </div>
   		
    <div class="legendToggler legendTogglerTheme" onclick="toggleLegend()"><img src = "../images/LegendIcon.png" style="padding:10px 10px 10px 22px;"/></div>
   <!-- Added by Subha-V20190403/KDAH-CRF-0517/Starts -->
   	<div class="CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
		<div class="formValErrorMsgTheme" id = "transactionMessageContent"></div>
	</div>	
	<!-- Added by Subha-V20190403/KDAH-CRF-0517/Ends -->	
   <!-- legend scroll portion -->	
   		
   				
 	<div  id ="legendContainer" style="font-family: 'Arial';font-size:12px;">					
		<div id="legendWrapper">
			<div id="legendScroller">
				<div class="legendTabs" ><div class = "dvLegendDischargedTheme"></div><span class="liSpanScroll">Discharged</span></div>
				<div class="legendTabs" ><div class="dvLegendDeceasedTheme" ></div><span class="liSpanScroll">Deceased</span></div>
				<div class="legendTabs" ><div class="dvLegendNewBornTheme"></div><span class="liSpanScroll">Newborn Exist</span></div>
				<div class="legendTabs" ><div class = "dvLegendNoRelationTheme"></div><span class="liSpanScroll">No PP Relationship</span></div>
				<div class="legendTabs" ><img src="../images/PaddingTask20x20.png"/><span class="liSpanScroll">Pending Task</span></div>
				<div class="legendTabs" ><img src="../images/NewResult20x20.png"/><span class="liSpanScroll">New Result</span></div>
				<div class="legendTabs" ><img src="../images/AbnormalResult20x20.png"/><span class="liSpanScroll">Abnormal Result</span></div>
				<div class="legendTabs" ><img src="../images/NewNote20x20.png" /><span class="liSpanScroll">New Clinical Notes  </span></div>
				<div class="legendTabs" ><img src="../images/Discharge20x20.png" /><span class="liSpanScroll">Discharge Due</span></div>
				<div class="legendTabs" ><img src="../images/MedicationIndicator20x20.png" /><span class="liSpanScroll">Medication Due</span></div>
				<div class="legendTabs" ><img src="../images/Consent20x20.png" /><span class="liSpanScroll">Consent</span></div>
				<div class="legendTabs" ><img src="../images/PatientinOT20x20.png"/><span class="liSpanScroll">Patient in OT</span></div>
			  </div>
		</div>
	</div> 	
   </div>
   				
  
	<!--  legend scroll portion ends-->	
</div>
</div>
   
   				
   			</div>
<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
<input type = "hidden" name ="lpPatientId" id ="lpPatientId"  value =""/>
<input type = "hidden" name ="lpEpisodeId" id ="lpEpisodeId"  value =""/>
<input type = "hidden" name ="lpAdmDateTime" id ="lpAdmDateTime"  value =""/>
<input type = "hidden" name ="lpDischargeDateTime" id ="lpDischargeDateTime"  value =""/>
<input type = "hidden" name ="lplocationType" id ="lplocationType"  value =""/>
<input type = "hidden" name ="lpLocationCode" id ="lpLocationCode"  value =""/>
<input type = "hidden" name ="lpServiceCode" id ="lpServiceCode"  value =""/>	
<input type = "hidden" name ="hdnPatientId" id ="hdnPatientId" value = "<%=oInPatientContext.getPatientId()%>"/>
<input type = "hidden" name ="hdnNursingUnit" id ="hdnNursingUnit" value = "<%=oInPatientContext.getNursingUnitCode() %>"/>
<input type = "hidden" name ="hdnClinicianId" id ="hdnClinicianId" value = "<%=oInPatientContext.getPractionerId() %>"/>
<input type = "hidden" name ="hdnSfsClinicianId" id ="hdnSfsClinicianId" value = "<%=oSfsContext.getsPractionerId() %>"/>
<input type = "hidden" name ="hdnSpeciality" id ="hdnSpeciality" value = "<%=oInPatientContext.getSpecialityCode() %>"/>
<input type = "hidden" name ="hdnOrderBy" id ="hdnOrderBy" value = "<%=oInPatientContext.getOrderBy() %>"/>
<input type = "hidden" name ="hdnIPCount" id ="hdnIPCount" value = "<%=nListSize%>"/>
<!-- Added by Subha-V20190403/KDAH-CRF-0517/Starts -->
<input type = "hidden" name ="facilityId" id ="facilityId" value = "<%=oInPatientContext.getFacilityId()%>"/>
<input type = "hidden" name ="clinicianId" id ="clinicianId" value = "<%=oInPatientContext.getClinicianId()%>"/>
<!-- Added by Subha-V20190403/KDAH-CRF-0517/Ends -->
</form> 


  
	  <%
	}catch ( Exception e ){
		out.println("Exception " + e);
		e.printStackTrace();
	}
	finally{
	
	}
	%>
	</div> <!--  data-role = "page" div -->
</body>
</html>

