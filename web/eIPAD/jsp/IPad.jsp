<%@page import="eCommon.Common.CommonBean"%> 
<%@page import="eIPAD.IPADConstants"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.*,java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.pendingresults.*" contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath(); 
String product_description = "";
String version_no = "";
String activePage=request.getParameter("ActivePage")==null?"DV":request.getParameter("ActivePage");


if(request.getParameter("hdnActivePage")!= null)
{
	activePage =  request.getParameter("hdnActivePage");
	if(activePage.trim().equals(""))
	{
		activePage="IP";
	}
}

String formValErrClass = "";
String transactionMessage = "";
String transactionResult = "";
String transactionOccurred = "false";
if(request.getParameter("transactionOccurred") != null && request.getParameter("transactionOccurred").equals("true")){
	transactionOccurred = request.getParameter("transactionOccurred") == null?"":request.getParameter("transactionOccurred");
	transactionMessage = request.getParameter("transactionMessage") == null?"":request.getParameter("transactionMessage");
	transactionResult = request.getParameter("transactionResult") == null?"":request.getParameter("transactionResult");
	if(transactionResult.equals("0")){ 
		formValErrClass= "formValSuccessTheme";
	}
	else{
		formValErrClass= "formValErrorTheme";
	}
}
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

if(session.getAttribute("version_no") != null)
{
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null)
{
	product_description = (String)session.getAttribute("product_description");
}


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
		
/* sqlipcount.append("SELECT COUNT (*) Total FROM ip_open_encounter a WHERE a.facility_id = '"+facility_id+"' AND attend_practitioner_id = '"+func_role_id+"' AND patient_class = 'IP'  AND adt_status IN ('00', '01')  AND EXISTS ( SELECT patient_class FROM ca_pract_by_locn_detail o  WHERE facility_id = '"+facility_id +"' AND practitioner_id = '"+ func_role_id +"' ");
sqlipcount.append(" AND locn_type = 'W' AND patient_class = 'IP' AND EXISTS ( SELECT 1   FROM pr_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y'  AND mp_p.patient_id = a.patient_id  AND a.assign_care_locn_code = o.locn_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND a.attend_practitioner_id = '"+ func_role_id +"' AND (a.adt_status IN ('01', '02')))) ");
 */		
sqlipcount.append("select count(*) count from IP_OPEN_ENCOUNTER a Where a.facility_id ='"+facility_id+"' AND  ATTEND_PRACTITIONER_ID='"+func_role_id+"' AND PATIENT_CLASS='IP' AND ADT_STATUS IN ('01','02') ");
//this condition is added to find whether the ESTABLISH_RELN_REQ_YN is "Y" and if equal to "Y" then only the patients who have a legitimate relationship with the practitioner will be displayed in the IP List
sqlipcount.append("and case when (Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM) = 'Y' then (select count(*) from CA_ENCNTR_PRACT_RELN where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.ENCOUNTER_ID,0) and practitioner_id = a.ATTEND_PRACTITIONER_ID and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE) else 1 end > 0");
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
				
				strIPCount = rsip.getString("count");
				if(strIPCount != null )
				{
	                if(strIPCount.length() == 1)
					{
	                	strIPCount = "00" + strIPCount;
					}
	                if(strIPCount.length() == 2)
					{
	                	strIPCount = "0" + strIPCount;
					}
				}
			
			}
			rsip.close();
			if ( stmt1 != null ) stmt1.close() ;
			session.putValue("practitioner_id",func_role_id);
			
		}		
	 					
    
%>
<!DOCTYPE html> 
<html> 
<head> 
<title></title>   
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> 
<script src="../jquery-1.5.2.min.js"></script> 
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src="../js/lib/jquery.touchSwipe.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- <link rel="stylesheet" href="../css/iPADNew.css" /> 
<link rel="stylesheet" href="../css/iPADThemeA.css" />  -->
<link rel="stylesheet" href="<%=path%>/eIPAD/css/mCommon.css" /> 
<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="<%=path%>/eIPAD/css/mIP.css" /> 
<style>

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
<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
var bExpanded = true;

function getTotalPageDivHeight(){
	var i = $('#divParent').height();
	return i;
}
 
function logout()
{
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				window.location = "<%=path%>/ipadlogin";
			}
		}
		xmlhttp.open("POST", "../jsp/Logoff.jsp", true);
		xmlhttp.send();
}



var legendsScroll ;
var scrollContent1;
var IPOpen = false;
function toggleMenu() {
	if(IPOpen){
		return;
	}
setTimeout(function () {
	if (legendsScroll != null){
	legendsScroll.refresh();}
	if (scrollContent1 != null){
	scrollContent1.refresh();}
}, 0);

	if (bExpanded) {
		$('#divMenu').animate({
			width : "0%"
		}, 'slow');
		$('#divContent').animate({
			width : "100%"
		}, 'slow');
		document.getElementById("mb").style.display = "none";
		document.getElementById("mh").style.display = "none";
		document.getElementById("mc").style.display = "none";
		bExpanded = false;
	} else {
		$('#divMenu').animate({
			width : "2%"
		}, 'slow');
		$('#divContent').animate({
			width : "98%"
		}, 'slow');
		document.getElementById("mb").style.display = "block";
		document.getElementById("mh").style.display = "block";
		document.getElementById("mc").style.display = "block";
		bExpanded = true;

	}
}
function loadwidgets(patientID, episodeId, admitDate, dischargeDateTime,
		locnType, locnCode, servicecode,navType) {
	document.getElementById("hdnPatientId").value = patientID;
	document.getElementById("hdnEpisodeId").value = episodeId;
	document.getElementById("hdnAdmitDate").value = admitDate;
	document.getElementById("hdnDischargeDateTime").value = dischargeDateTime;
	document.getElementById("hdnLocnType").value = locnType;
	document.getElementById("hdnLocnCode").value = locnCode;
	document.getElementById("hdnServiceCode").value = servicecode;
	document.getElementById("hdnNavType").value = navType;	
	if(navType == 'recordConsent'){
		document.getElementById("frmIcontent").action = "<%=path%>/mobile/charts/consent/RecordConsentInitPatContext";
	}
	document.getElementById("frmIcontent").submit();
}
function slideSearchByPat(patientID){
	$('#frameIP')[0].contentWindow.slidesfsSearch(patientID); 
}
function clearHdnPatientValue(){
	$('#frameIP')[0].contentWindow.clearHdnPatientValue();
}
function addSpinner(){
	var a = $("#spinnerDiv")
	//alert("spinner val"+a.length);
	if(a.length ==0)
		$("#divContent").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function removeSpinner(){
	var a = $("#spinnerDiv")
	//alert("spinner val"+a.length);
	if(a.length > 0)
	$("#spinnerDiv").remove();
}
function showTransactionMessage(){
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}
$(document).ready(function() {

					//alert($(".divContent").height());
	var transactionOccurred = $("#transactionOccurred").val();
	if(transactionOccurred == 'true'){
		showTransactionMessage();
	}

					var activePage = document.getElementById("hdnActivePage").value;
					if (activePage == 'PR') {
						$('#pendingResultsMenuItem').removeClass(
								'normText6-theme').addClass(
								'normText5-theme');
						hideSearchImg();
					}
					if (activePage == 'IP') {
						//addSpinner();
						$('#inPatientsMenuItem').removeClass(
								'normText6-theme').addClass(
								'normText5-theme');
						showSearchImg();
					}
					if(activePage== 'DV') {
						$('#diaryViewMenuItem').removeClass(
						'normText6-theme').addClass(
						'normText5-theme');
                        hideSearchImg();
					}
					if (activePage == 'RO') {
						$('#registerOrdersMenuItem').removeClass(
						'normText6-theme').addClass(
						'normText5-theme');
						hideSearchImg();
					}

					//On orientation change
					if (window.DeviceOrientationEvent) {
						window.addEventListener('orientationchange',
								myOrientResizeFunction, false);
						// orientation = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
					}

					function myOrientResizeFunction() {
						// alert(Math.abs(window.orientation));
						//alert($('#divContent').height());
						var orient = Math.abs(window.orientation) === 90 ? 'landscape'
								: 'portrait';
						if (orient == "landscape") {
							document.getElementById("frameIP").contentWindow
									.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
						} else {
							document.getElementById("frameIP").contentWindow
									.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
						}
							setIframeSFSHeight();	

					}
					
					
					$(document).bind("swiperight", '.sliderSwipe',function( e ) {
						 showSlideSFS();
					});
				});

function activePage() {
	var activePage = document.getElementById("hdnActivePage").value;
	if (activePage == 'PR') {
		$('#pendingResultsMenuItem').removeClass('normText6-theme').addClass(
				'normText5-theme');
		$('#inPatientsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#RecentPatientsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#diaryViewMenuItem').removeClass('normText5-theme')
		.addClass('normText6-theme');
		$('#registerOrdersMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
	}
	if (activePage == 'IP') {
		$('#inPatientsMenuItem').removeClass('normText6-theme').addClass(
				'normText5-theme');
		$('#RecentPatientsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#pendingResultsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#diaryViewMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#registerOrdersMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
	}
	if (activePage == 'DV') {
		$('#inPatientsMenuItem').removeClass('normText5-theme').addClass(
				'normText6-theme');
		$('#pendingResultsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#RecentPatientsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#diaryViewMenuItem').removeClass('normText6-theme')
				.addClass('normText5-theme');
		$('#registerOrdersMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
	}
	if (activePage == 'RP') {
		$('#inPatientsMenuItem').removeClass('normText5-theme').addClass(
				'normText6-theme');
		$('#pendingResultsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#diaryViewMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#RecentPatientsMenuItem').removeClass('normText6-theme')
				.addClass('normText5-theme');
		$('#registerOrdersMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
	}
	if (activePage == 'RO') {
		$('#inPatientsMenuItem').removeClass('normText5-theme').addClass(
				'normText6-theme');
		$('#pendingResultsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#diaryViewMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#RecentPatientsMenuItem').removeClass('normText5-theme')
				.addClass('normText6-theme');
		$('#registerOrdersMenuItem').removeClass('normText6-theme')
				.addClass('normText5-theme');
	}
	
}

function setIframeHeight() {
	//On Initial Load change the frame height based on the orientation
	var orientOnLoad = Math.abs(window.orientation) === 90 ? 'landscape'
			: 'portrait';
	//alert(orientOnLoad);
	document.getElementById("frameIP").contentWindow
			.changeOrientation(orientOnLoad,$('#EMHeader').height() + $('#EMFooter').height());
}
function setIframeSFSHeight() {
	var orientOnLoad = Math.abs(window.orientation) === 90 ? 'landscape'
			: 'portrait';
	document.getElementById("SlideSfsFrame").contentWindow
			.changeOrientation(orientOnLoad,$('#EMHeader').height() + $('#EMFooter').height());
}
function openPendingResults() {
	//addSpinner();
	document.getElementById("hdnActivePage").value = "PR";
	var fromPeriodComp = document.getElementById("hdnFromPeriod");
	var fromPeriodVal = "";
	if (fromPeriodComp) {
		fromPeriodVal = fromPeriodComp.value;
	}

	var toPeriodComp = document.getElementById("hdnToPeriod");
	var toPeriodVal = "";
	if (toPeriodComp) {
		toPeriodVal = toPeriodComp.value;
	}

	var selectedPeriodComp = document.getElementById("hdnSelectedPeriod");
	var selectedPeriod;
	if (selectedPeriodComp) {
		selectedPeriod = selectedPeriodComp.value;
	}

	var taskApplicabilityComp = document
			.getElementById("hdnTaskApplicability");
	var taskApplicability;
	if (taskApplicabilityComp) {
		taskApplicability = taskApplicabilityComp.value;
	}

	var groupbyComp = document.getElementById("hdnGroupby");
	var groupby;
	if (groupbyComp) {
		groupby = groupbyComp.value;
	}
	var caNormalcyIndComp = document.getElementById("hdnCANormalcyInd");
	var caNormalcyInd;
	if (caNormalcyIndComp) {
		caNormalcyInd = caNormalcyIndComp.value;
	}

	var pagesrc = "PendingResultsCriteria.jsp?fromPeriod=" + fromPeriodVal
			+ "&toPeriod=" + toPeriodVal;
	pagesrc = "PendingResults-newUI.jsp?hdnFromPeriod=" + fromPeriodVal
			+ "&hdnToPeriod=" + toPeriodVal + "&hdnGetTaskApplicability="
			+ taskApplicability + "&hdnGroupby=" + groupby
			+ "&hdnNormalcyVal=" + caNormalcyInd + "&hdnSelectedPeriod="
			+ selectedPeriod;
	document.getElementById("frameIP").src = pagesrc;
	activePage();
}
function openIPResults() {
	//addSpinner();
	document.getElementById("hdnActivePage").value = "IP";
		document.getElementById("frameIP").src = "IPList-newUI.jsp";
	// document.getElementById("frameIP").src = "IPListSlideSfsFilter.jsp"; 
	activePage();
	$('#sfsSearchImg').show();
	$('.sliderSwipe').show();
}

function openRecentPatients() {
	//addSpinner();
	document.getElementById("hdnActivePage").value = "RP";
		document.getElementById("frameIP").src = "IPRecentPatients.jsp";
	// document.getElementById("frameIP").src = "IPListSlideSfsFilter.jsp"; 
	activePage();
	$('#sfsSearchImg').hide();
	$('.sliderSwipe').hide();
}
function openDiaryView() {	
	//addSpinner();
	//$("#PageLoadingAnimation").show();
	document.getElementById("hdnActivePage").value = "DV";
	document.getElementById("frameIP").src = "DiaryView.jsp";
	$("#PageLoadingAnimation").hide();
	activePage();
	$('#sfsSearchImg').hide();
	$('.sliderSwipe').hide();
}
function showErrorWindow(msg){
	showMezzaineWindow();
	$("#ErrorMessageTxt").html(msg);
	$("#Error_Window").css("display","block");
	$("#dvMez").data("popid","Error_Window");
}
function showMezzaineWindow()
{
	$('#dvMez').css("display","block");
	setTimeout(function() {
		$("#dvMez").click(closeMezzaineWindow);
	}, 500);
}
function closeMezzaineWindow()
{
	$("#dvMez").css("display","none");
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").data("popid","");
	$("#dvMez").unbind( "click" )
}
function closeErrorPop(){
	closeMezzaineWindow();
	$("#Error_Window").hide();
	$("#dvMez").data("popid","");
	$("#ErrorMessageTxt").html("");
}
function openSearchWindow(){
	document.getElementById("sfsFrame").src="IPSlideSFS.jsp";	
}
function showsfs()
{
	//document.getElementById("sfs").style.display = "none";
	//var e = event.originalEvent; 
	//alert( $(obj).scrollTop());
	//alert(e.touches[0].pageY);
	document.getElementById("sfsFrame").src = "IPSlideSFS.jsp";
	$("#sfs").css('z-index', "1000");
	$("#sfsarrow").css('z-index',"1000");
	$('#sfs').toggle();
	$('#sfsarrow').toggle();
	//document.getElementById("frame1").src = "popup1.html";
	//window.parent.show();
}
function showSlideSFS(){
	$("#SlideSfs").show();
	$("#mb").hide();
	$("#SlideSFSOpener").hide();
	$(".sliderSwipe").hide();
	IPOpen = true;
	
}
function refresh(){

	document.getElementById("frameIP").src = "IPList-newUI.jsp"; 

}
function hideSlideSFS(){
	var count = document.getElementById("hdnRecCount").value;
	if(count == 0){
		document.getElementById('SlideSfsFrame').contentWindow.refreshMain();
		openIPResults();
	}
	$("#SlideSfs").hide();
	$("#mb").show();
	$("#SlideSFSOpener").show();
	$(".sliderSwipe").show();
	
	if(bExpanded){
		$('#divMenu').animate({
			width : "2%"
		}, 'slow');
		$('#divContent').animate({
			width : "98%"
		}, 'slow');
		document.getElementById("mb").style.display = "block";
		document.getElementById("mh").style.display = "block";
		document.getElementById("mc").style.display = "block";
	}else{
		$('#divMenu').animate({
			width : "0%"
		}, 'slow');
		$('#divContent').animate({
			width : "100%"
		}, 'slow');
		document.getElementById("mb").style.display = "none";
		document.getElementById("mh").style.display = "none";
		document.getElementById("mc").style.display = "none";
	}
	IPOpen = false;
}
function showSearchImg(){
	$('#sfsSearchImg').show();
}
function hideSearchImg(){
	$('#sfsSearchImg').hide();
}
function hideRows(arrSP,arrPR,arrNU){
	document.getElementById('frameIP').contentWindow.hideRows(arrSP,arrPR,arrNU);
}
function selectedPract(val, desc, dPage){
	document.getElementById('frameIP').contentWindow.selectedPract(val, desc, dPage);
	$("#hdnSfsPractitionerId").val(val);
	$("#hdnSfsPractitionerDesc").val(desc);
}
function updateIPCount(ipCount){
	document.getElementById("hdnRecCount").value = ipCount;
	 $("#ipListCount").empty();
	 if(ipCount == 0){
		 $("#ipListCount").append('000');
	 }
	 else if(ipCount < 10){
	 		$("#ipListCount").append('00'+ipCount);
	 }
	 else if(ipCount < 100){
	 		$("#ipListCount").append('0'+ipCount);
	 }else{
		 	$("#ipListCount").append(ipCount);
	 }
}
//Added Against KDAH-CRF-0517 (Register Order) Starts
function registerOrders() {	
	document.getElementById("hdnActivePage").value = "RO";
	document.getElementById("frameIP").src = "RegisterOrderList.jsp"; 
	activePage();
	$('#sfsSearchImg').hide();
	//$('.sliderSwipe').show();
}
//Added Against KDAH-CRF-0517 (Register Order) Ends
</script>
<style>

/*---CSS for error pop up Starts---*/
.absoluteCenter {
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
}
#Error_Window {
	width: 325;
	height: 200px;
	border: 2px solid #ffffff;
	background: #074860;
	min-height: 200px;
	max-width: 325px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	border-radius: 10px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	overflow: hidden;
	z-index:100;
}
.top_shadow {
	width: 100%;
	height: 90px;
	background: #3b6f81; /* Old browsers */
	background: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */
	background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */
	background: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */
	background: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */
	background: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */
	background: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3b6f81', endColorstr='#074860', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
	margin-top: -40px;
	margin-top: -240px;
	z-index: -999;
}
.Error_msg_box {
	width: 100%;
	height: 150px;
	max-height: 150px;
	max-width: 100%;
	border-bottom: 1px solid #000000;
}
.Error_msg_btn {
	width: 100%;
	height: 49px;
	background: #2ea3c0; /* Old browsers */
	background: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */
	background: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2ea3c0', endColorstr='#0c7d9a', GradientType=0 ); /* IE6-9 */
display:table;
}
.Error_msg {
	height: 150px;
	width: 100%;
	overflow: auto;
	z-index: 999999;
	position: relative;
	display: table;
}
.Error_msg_Frame {
	display: table-cell;
	vertical-align: middle
}
.Error_icon
{
	width:60px;
	height:100%;
	float:left;
	text-align:right;
	
}
.Error_cont
{
	width: 260px;
	height:100%;
	float:left;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;
	padding-top: 10px;
	text-shadow: none;
}
.Error_btn_div
{
	width:0px;
	height:100%;
	border-left:1px solid #0bb5dd;
	border-right:1px solid #023542;
	float: left;
}
.Error_btn_div_con
{
	width:159px;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
	
}
.Error_btn_div_con_single
{
	width:100%;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
}
.blurPopup
{
	position:absolute;
	z-index : 3;
	left : 0px;
	top : 0px;
	width : 100%;
	height : 100%;
	background-color : #808080;
	opacity : 0.6;
	display : none;
	
}
.slideSfsOpener
{
	position:absolute;
	z-index:1000;
	top: calc(100%/2); 
}
.sliderSwipe{
	position: absolute;
	width: 20px;
	height: 100%;
	z-index:999;
}

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
/*---CSS for error pop up Ends---*/
</style>
</head>
<body>
	<div id="divParent" class = "mdivParent" data-role="page">
	  <form id="frmIcontent" name = "frmIcontent" method = "post" class="mform" action = "<%=path%>/setpatientcontext">
		 <div id="divTable" class = "mdivTable" data-role = "none">
		 	<div data-role = "none" class = "mheaderRow" id="EMHeader"><!-- header starts -->
					<table class="mheader grd1-theme" border = "0" cellspacing = "0" cellpadding = "0">
			        <tr style = "width:100%;height:100%">
						<td style = "width:90%;height:100%" align = "left" ><span class="mheaderText headerText1-theme"><%=product_description%> - <%=version_no%></span></td>
						<td style = "width:10%;height:100%" valign = "center" align = "right" onclick = "logout()">
							<img src = "<%=path%>/eIPAD/images/Logout1.png" class="mHeaderImgLogout" ></img>
						</td>
			        </tr>
		       </table>
		   </div><!-- div first row header ends  -->
		   
		   <div data-role = "none" class = "ipContentRow bg1-theme"><!-- second row starts -->
		   <div data-role = "none" style="display:table-cell">
			   	<div data-role = "none" style="display:table;height:100%;width:100%">
			   	   	<div data-role = "none" style="display:table-row">
						<div class="sliderSwipe" ></div>
	                     <div onclick="showSlideSFS()" class="slideSfsOpener" id="SlideSFSOpener">
	                    <img id="sfsSearchImg" src = "../images/Open_window.png" /></div> 
					   	<div class = "ipdivMenu bg1-theme" id = "divMenu" data-role = "none" >
					   	  <div class = "ipmenuBody bg2-theme" id = "mb"><!-- menu body starts here -->
						   	<div class = "ipmenuHeader grd4-theme ipmenuHeaderBorder-theme" data-role = "none" id = "mh">
							        <span class = "ipmenuHeaderPageTitle headingText2-theme">Menu</span>
							</div> <!-- menu header ends here -->
							
							<div class = "ipmenucontainer border4-theme" data-role = "none" id = "mc">
							      <div class = "ipmenuGroup grd5-theme border4TopBottom-theme" data-role = "none">
							       <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0" border = "0">
							          <tr style = "width:100%;height:100%">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							              <img src = "../images/iCON01.png"></img>
							            </td>
							             <td class = "ipmenuBigTd" align ="left" valign = "center">
							             <span class = "ipspanMenuGroup normText4-theme">My Patients</span>
							            </td>
							          </tr>
							        </table>
							      </div>
							      <div class = "ipmenuItems menuItemBox-theme" data-role = "none" onclick="openIPResults()">
							        <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0" border = "0">
							          <tr style = "width:100%;height:100%">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							              <img src = "../images/iCON.png"></img>
							            </td>
							             <td class = "ipmenuBigTd" align ="left" valign = "center">
							             <span class = "normText6-theme ipMenuItemTxt" id="inPatientsMenuItem">In Patients</span>
							            </td>
							            <td class = "ipmenuSmallTd" valign = "center" align = "left">
							             <div data-role ="none" id="ipListCount" class = "btn5-theme ipCountButton normText3-theme"><%=strIPCount%></div>
							            </td>
							          </tr>
							        </table>
							      </div>	
							      <!-- <div class = "ipmenuItems menuItemBox-theme" data-role = "none" onclick="openRecentPatients()">
							        <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0" border = "0">
							          <tr style = "width:100%;height:100%">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							              <img src = "../images/iCON.png"></img>
							            </td>
							             <td class = "ipmenuBigTd" align ="left" valign = "center">
							             <span class = "normText6-theme ipMenuItemTxt" id="RecentPatientsMenuItem">Recently Accessed Patients</span>
							            </td>
							          </tr>
							        </table>
							      </div> -->							      
							      <div class = "ipmenuGroup grd5-theme border4TopBottom-theme" data-role = "none">
							         <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0" border = "0">
							          <tr style = "width:100%;height:100%">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							              <img src = "../images/iCON01.png"></img>
							            </td>
							             <td class = "ipmenuBigTd" align ="left" valign = "center">
							             <span class = "ipspanMenuGroup normText4-theme">My Tasks</span>
							            </td>
							          </tr>
							        </table>
							      </div>
							      
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
									String strTotalPendingResults = "" + totalPendingResults;
									
					                if(strTotalPendingResults.length() == 1)
									{
					                	strTotalPendingResults = "00" + strTotalPendingResults;
									}
					                if(strTotalPendingResults.length() == 2)
									{
					                	strTotalPendingResults = "0" + strTotalPendingResults;
									}
									%>	
							      <div class = "menuItems menuItemBox-theme" data-role = "none">
							           <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0">
							          <tr style = "width:100%;height:100%" id="diaryView" onclick="openDiaryView()">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							             <img src = "../images/iCON.png"></img>
							            </td>
							             <td class = "ipmenuBigTdp" valign = "center" align = "left">
							           
							              <span class = "normText6-theme ipMenuItemTxt" id="diaryViewMenuItem">My Diary</span>
							            </td>
							          </tr>
							         </table>
							          </div>
							         <div class = "menuItems menuItemBox-theme" data-role = "none">
							        <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0">
							          <tr style = "width:100%;height:100%" id="pendingResults" onclick="openPendingResults()">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							             <img src = "../images/iCON.png"></img>
							            </td>
							             <td class = "ipmenuBigTdp" valign = "center" align = "left">
							           
							              <span class = "normText6-theme ipMenuItemTxt" id="pendingResultsMenuItem">Pending Results Review</span>
							            </td>
							            <td class = "ipmenuSmallTd" valign = "center" align = "left">
							             <div data-role ="none" class = "btn5-theme ipCountButton normText3-theme"> <%=strTotalPendingResults%></div>
							            </td>
							            
							          </tr>
							        </table>
							      </div>
							      
							      <!-- Added Against KDAH-CRF-0517 (Register Order) Starts-->
							      <div class = "menuItems menuItemBox-theme" data-role = "none">
							           <table style = "width:100%;height:100%" cellspacing = "0" cellpadding = "0">
							          <tr style = "width:100%;height:100%" id="" onclick="registerOrders()">
							            <td class = "ipmenuIConTd" valign = "center" align = "center">
							             <img src = "../images/iCON.png"></img>
							            </td>
							             <td class = "ipmenuBigTdp" valign = "center" align = "left">
							           
							              <span class = "normText6-theme ipMenuItemTxt" id="registerOrdersMenuItem">Register Orders</span>
							            </td>
							          </tr>
							         </table>
							      </div>
							      <!-- Added Against KDAH-CRF-0517 (Register Order) Ends-->
							      
						    </div><!-- menu container ends here -->
					   	  </div><!-- menu body end here -->
				
					   	    <!-- Slide SFS popup STARTS -->
					   	  	<div data-role = "none"  id = "SlideSfs" style="position:relative;width:230px;height:100%;background:white;display:none">
  	 							<iframe id = "SlideSfsFrame" frameborder="0"  scrolling ="no" height = "100%" width = "100%" src = "IPSlideSFS.jsp"></iframe>  
  	 							
   							</div>
   							<!-- Slide SFS popup ENDS -->
					   	</div> <!-- div menu end here -->
					   	<div class = "mdivContent bg1-theme" id = "divContent"> <!-- div content starts here -->
		                       <div class = "ipframeContainer" id = "contentWrapper">
		                       	<%if(activePage.equals("IP")){ %>
	                               <iframe frameborder="0" id = "frameIP" class = "ipframe" scrolling ="no" src = "IPList-newUI.jsp"></iframe>
	                             <%}else{ %>
	                             	<iframe frameborder="0" id = "frameIP" class = "ipframe" scrolling ="no" src = "DiaryView.jsp"></iframe>
	                             <%} %>
	                             <!-- Transaction message -->
								<div class="<%=formValErrClass %> CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"><%=transactionMessage %></div>
								</div>
								<!-- End of Transaction message -->
	                          </div>
		                </div> <!-- div content end here -->
		                
				   	</div><!-- div content holder ends here -->
			   	</div><!-- pagContent content end here -->
			   	
			   	</div>
		   </div><!-- div second row rends here -->
		   
		   <div data-role = "none" class = "mfooter" id="EMFooter" ><!-- Footer start  -->
		      <div class = "mfooterContent border3Top-theme grd3-theme" data-role = "none">
			     <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
				        <tr style = "width:100%;height:100%">
					          <td style = "width:50%;height:100%" valign = "top">
					            <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
					            	<tr style = "width:100%;height:50%">
					            	  <td style = "width:100%;height:100%" valign = "top" align = "left">
					            	    <span class="mfooterUserInfo cpyRightTxt-theme"><%=jdbc_user_id%></span>
					            	  </td>
					            	</tr>
					            	<tr style = "width:100%;height:50%">
					            	<td style = "width:100%;height:100%" valign = "top" align = "left">
					            	  <span class="mfooterUserInfo cpyRightTxt-theme"><%=facility_name %>-<%=site%></span>
					            	  </td>
					            	</tr>
					            </table>
					          </td>
					          <td style = "width:50%;height:100%" align = "right" valign = "top">
					          <span class="mcopyrightsText cpyRightTxt-theme"></span>
					         <img src="../images/CSC_Logo.png" class="mimgCopyRights"></img>
					          </td>
					          
				        </tr>
			       </table>
			   </div>    
		   </div><!-- div footerends here -->
		   
		 </div> <!-- div table ends here -->
		 <input type = "hidden" name = "hdnPatientId" id = "hdnPatientId" value = "" />
		<input type = "hidden" name = "hdnEpisodeId" id = "hdnEpisodeId" value = "" />
		<input type = "hidden" name = "hdnAdmitDate" id = "hdnAdmitDate" value = "" />
		<input type = "hidden" name = "hdnDischargeDateTime" id =  "hdnDischargeDateTime" value = "" />
		<input type = "hidden" name = "hdnLocnType" id =  "hdnLocnType" value = "" />
		<input type = "hidden" name = "hdnLocnCode" id =  "hdnLocnCode" value = "" />
		<input type = "hidden" name = "hdnServiceCode" id =  "hdnServiceCode" value = "" />
		<input type = "hidden" name = "hdnNavType" id =  "hdnNavType" value = "" />
		<input type="hidden" name="hdnPatClass" id="hdnPatClass" id="hdnPatClass" value="IP"/>
		<input type = "hidden" name ="hdnRecCount" id ="hdnRecCount" value = "1"/>
		
			<!-- This is added for sending the from and to period in pending review results page -->
		<input type="hidden" name="hdnFromPeriod" id="hdnFromPeriod" id="hdnFromPeriod" value="<%=fromPeriod%>"/>
		<input type="hidden" name="hdnToPeriod" id="hdnToPeriod" id="hdnToPeriod" value="<%=toPeriod%>"/>
		<input type="hidden" name="hdnTaskApplicability" id="hdnTaskApplicability" id="hdnTaskApplicability" value="<%=taskApplicability%>"/>
		<input type="hidden" name="hdnGroupby" id="hdnGroupby" id="hdnGroupby" value="<%=groupBy%>"/>
		<input type="hidden" name="hdnCANormalcyInd" id="hdnCANormalcyInd" id="hdnCANormalcyInd" value="<%=ca_normalcy_ind%>"/>
		<input type="hidden" name="hdnSelectedPeriod" id="hdnSelectedPeriod" id="hdnSelectedPeriod" value="<%=selectedPeriod%>"/>
		<input type="hidden" name="hdnMainPageURL" id="hdnMainPageURL" id="hdnMainPageURL" value=""/>
		<input type="hidden" name="hdnParams" id="hdnParams" id="hdnParams" value="<%=params%>"/>
		<input type="hidden" name="hdnPatClass" id="hdnPatClass" id="hdnPatClass" value="IP"/>
		<input type="hidden" name="hdnHideIcon" id="hdnHideIcon" id="hdnHideIcon" value=""/>
		<input type="hidden" name="hdnActivePage" id="hdnActivePage" id="hdnActivePage" value="<%=activePage%>"/>
		<input type="hidden" name="transactionOccurred" id="transactionOccurred" id="transactionOccurred" value="<%=transactionOccurred %>"/>
		<input type="hidden" name="hdnSfsPractitionerId" id="hdnSfsPractitionerId" id="hdnSfsPractitionerId" value="<%=func_role_id%>"/>
		<input type="hidden" name="hdnSfsPractitionerDesc" id="hdnSfsPractitionerDesc" id="hdnSfsPractitionerDesc" value="<%=practitioner_name%>"/>
		 </form>
		 <!-- Pop up  starts here -->
		 <div data-role = "none" id = "dvMez" class = "blurPopup" data-popid=""></div>
		 <div id="Error_Window" class="absoluteCenter" style="display:none">
			<div class="Error_msg_box">
			  <div class="Error_msg">
			    <div class="Error_msg_Frame">
			      <div>
			        <div class="Error_icon"><img src="../images/PopWarning.png" width="30" height="30" /></div>
			        <div class="Error_cont" id="ErrorMessageTxt" data-role="none"></div>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="Error_msg_btn">
			    <div class="Error_btn_div_con_single" onclick="closeErrorPop()">OK</div>
			</div>
			<div class="top_shadow"> </div>
		</div> 
		 
		 <!-- Pop up  ends here -->
	</div><!-- div parent ends here -->
	<div id="PageLoadingAnimation" class="absoluteCenter"></div>
</body>
</html>
<%

}
    catch(Exception e){
		e.printStackTrace();
		out.println("Exception in Ipad.jsp"+e.toString());
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

