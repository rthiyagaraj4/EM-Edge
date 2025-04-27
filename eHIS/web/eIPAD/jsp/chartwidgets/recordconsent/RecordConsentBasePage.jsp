<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse"%>
<%@page import="eIPAD.chartsummary.recordconsent.bc.RecordConsentBC"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>

<!DOCTYPE html> 
<html> 
<head> 
<title>Record Consent</title>

<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js" ></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" />  --%>
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<script src="${path}/eIPAD/js/lib/ckeditor/ckeditor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" /> 

<link rel="stylesheet" href="${path}/eIPAD/css/iPadNew_IP.css" />  
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/mCommon.css" /> 


<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
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
				window.location = "${path}/ipadlogin";
			}
		}
		xmlhttp.open("POST", "${path}/eIPAD/jsp/Logoff.jsp", true);
		xmlhttp.send();
}

//This small jQuery plugin is used to assign the event handler function for the OK button of the confirm dialog
(function ( $ ) {
    $.fn.configureConfirmDialog = function(options) {
    	var defaultVal =  {
    	        callBackForTrue: function () { },
    	    };
    	var obj = $.extend(defaultVal, options);
    	$(this).find("[data-value='true']").off();
        $(this).find("[data-value='true']").on("click",obj.callBackForTrue);
        return this;
    };
 
}( jQuery ));

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
var path;

$(document).ready(function(){
	//TODO Remove these JS variables if not used
	var transactionMessage="";
	var transactionResult="";
	var formValErrClass="";
	
	path = $("#hdnPath").val();
	$("#consentItemView").append("<div class='loadingCartItem'></div>");
	
	disableButtonId('RecordConsentTickBtn');
	
	
	$.getJSON( path+"/mobile/charts/consent/RecordConsentJSONServlet?field=CONSENTCOUNT", function(data){
		 if(data.map.COUNT == 1){
			 map = data.map;
			 if(map.TOTAL_CONSENTS == 1){
				 var order_id = map.ORDER_ID;
				 var consent_form_id = map.CONSENT_FORM_ID;
				 var consent_form_desc = map.CONSENT_FORM_DESC;
				 var consent_stage = map.CONSENT_STAGE;
				 if(consent_form_id==""){
					 $('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp?SingleVariable=true');
					 //Open consent form selection dialog -- ARAVINTHA
				 }else{
					 $('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp',{order_id: order_id, consent_form_id: consent_form_id, consent_form_desc: consent_form_desc, consent_stage: consent_stage} );
				 }
				 //$('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp');
				 
			 }else{
				 $('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp');
			 }
			 
		 }else{
			 $('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp');
		 }
	});

});

function returnToIPList(){
	 var ipPage = path + "/eIPAD/jsp/IPad.jsp?ActivePage=IP";
	 window.location.replace(ipPage); 
}
function returnToIPListWithWarning(){
	var toIPList = function()
	{
		closeConfirmDialog();
		returnToIPList();
		
	};
	$("#RecordConsentConfirmDialog").configureConfirmDialog({
		callBackForTrue: toIPList
	});
	var errorMsg = "Are you sure you wish to cancel the current operation?";
	showConfirmDialog(errorMsg);
	 
}
function showConfirmDialog(errorMsg){
	$("#RecordConsentConfirmDialogMsg").html(errorMsg);
	$("#RecordConsentConfirmDialog").show();
	showMez('RecordConsentConfirmDialog');
}
function closeConfirmDialog(){
	$("#RecordConsentConfirmDialog").hide();
	closeMez();
}
function closeMez(){
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").hide();
	$("#dvMez").off();
	//consentSelectPopup.refresh();
}
function showMez(popid){
	$('#dvMez').show();
	$("#dvMez").data("popid",popid);
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
}

var consentSelectPopup;
function showConsentSelPop(cuurentObj){	
	//alert(cuurentObj);
	//console.log(cuurentObj);
	//alert("cuurentObj"+$(cuurentObj).data("order-catalog"));
	
	var orderCatalog=$(cuurentObj).data("order-catalog");
	var orderId=$(cuurentObj).data("order_id");
	var orderLineNum=$(cuurentObj).data("order_line_num");
	//var orderSeq=$(cuurentObj).data("consent_seq");
	var stage=$(cuurentObj).data("stage-catalog");
	var currentindex=$(cuurentObj).data("order_index");
	var orderItemObj=$("#consentOrderItem"+currentindex);
	var orderSeq = orderItemObj.data("consent_seq");

	
	$("#currentCode").val(orderCatalog);
	$("#currentOrderId").val(orderId);
	$("#currentLineNum").val(orderLineNum);
	$("#currentSeq").val(orderSeq);
	$("#currentstage").val(stage);
	$("#currentindex").val(currentindex);
	
	
	
	$("#ConsentFormSelPopup").show();
	showMez('ConsentFormSelPopup');	 
	if(consentSelectPopup)
		consentSelectPopup.destroy();
	 setTimeout(function () {
		 consentSelectPopup = new IScroll('#navConsentScrollWrapper', { scrollbars: true, click: true,  mouseWheel: true } );
   	}, 100);
}
function closeConsentSelPop(){
	$("#ConsentFormSelPopup").hide();
	closeMez();
	consentSelectPopup.refresh();
}	


function consentFormEditorView(){		
	closeConsentSelPop();
	$("#consentItemView").empty();
	$("#consentItemView").append("<div class='loadingCartItem'></div>");
	$('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp');
}
function chooseConsentForm(desp,code){
	var validation="true";
	var currentCode= $("#currentCode").val();
	var currentOrderId =$("#currentOrderId").val();
	var currentLineNum =$("#currentLineNum").val();
	var currentSeq =$("#currentSeq").val();
	//alert(currentSeq);
	var currentindex =$("#currentindex").val();
	$('[data-order_id = "'+currentOrderId+'"]').each(function (i,v ){
		var const_id =$(this).data('consent-id');
		//console.log("get values 12"+const_id+"==="+code);
	
		if(const_id==code){
			validation="false";
			setTransactionMessage(false,"Duplicate Values Not Allowed");
			$("#ConsentFormSelPopup").hide();
			closeMez();
			return;
		}
	});
	var currentstage =$("#currentstage").val();
	if(validation=="true")	{
		
		 $.ajax({
			  method: "GET",
			  url: path+"/eIPAD/jsp/chartwidgets/recordconsent/AssignConsentFormControl.jsp",
			  data: {desc: desp,code:code,currentCode:currentCode,currentOrderId: currentOrderId,currentLineNum:currentLineNum,currentSeq:currentSeq,currentstage:currentstage,currentindex:currentindex}
		})
		.done(function( data ) {
			$("#consentItemView").append("<div class='loadingCartItem'></div>");
			$("#consentItemView").empty();
			$('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp',{order_id: currentOrderId, consent_form_id: code, consent_form_desc: desp, consent_stage: currentstage} );
			return;
		});
		$("#ConsentFormSelPopup").hide();
		closeMez();
	}
}
function disableButtonId(btnId){
	$("#"+btnId).off();
	$("#"+btnId).addClass("cstFieldDull");
}

function enableRecordConsentTickBtn(){
	$("#RecordConsentTickBtn").removeClass("cstFieldDull");
	$("#RecordConsentTickBtn").off();
	$("#RecordConsentTickBtn").click(function() {
		performRecordConsentTransaction();
	});
}
function performRecordConsentTransaction(){
	
	$("#consent_form_text0").val(CKEDITOR.instances.RecConsentRTE.getData());
	$.ajax({
		  method: "POST",
		  url: path+"/mobile/charts/consent/RecordConsentJSONServlet?field=RECORDCONSENT",
		  data: $("#RecordConsentForm").serialize()
	})
	.done(function(res) {
		//show toast message
		if(res.transactionResult == 0){
			var msg="Consent recorded successfully";
			setTransactionMessage(true,msg);
		}else{
			var msg="Consent could not be recorded";
			setTransactionMessage(false,msg);
		}
		$.getJSON( path+"/mobile/charts/consent/RecordConsentJSONServlet?field=CONSENTCOUNT", function(data){
			 if(data.map.COUNT == 0){
				 var transactionParams = "&transactionOccurred=true&transactionMessage="+res.transactionMessage+"&transactionResult="+res.transactionResult;
				 var ipPage = path + "/eIPAD/jsp/IPad.jsp?ActivePage=IP"+transactionParams;
				 window.location.replace(ipPage); 
			 }else{
				 backToOrderList();
			 }
		});
	});
}
function setTransactionMessage(result,errMsg){
	if(result){
		$("#transactionMsg").addClass("formValSuccessTheme").removeClass("formValErrorTheme");
		$("#transactionMessageContent").html(errMsg);
	}else{
		$("#transactionMsg").addClass("formValErrorTheme").removeClass("formValSuccessTheme");
		$("#transactionMessageContent").html(errMsg);
		
	}
	 showTransactionMessage();
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
function backToOrderList(){
	$("#consentItemView").empty();
	$("#consentItemView").append("<div class='loadingCartItem'></div>");
	$('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp');
}
function editConsentForm(index, consent_form_id, consent_form_desc, consent_stage){
	var orderItemObj=$("#consentOrderItem"+index);
	var order_catalog_code=orderItemObj.data("order_catalog_code");
	var order_id=orderItemObj.data("order_id");
	var ord_id=orderItemObj.data("ord_id");
	var ord_typ_code=orderItemObj.data("ord_typ_code");
	var ord_line_num=orderItemObj.data("ord_line_num");
	var cont_order_ind=orderItemObj.data("cont_order_ind");
	var ord_appr_by_user_id=orderItemObj.data("ord_appr_by_user_id");
	var ord_appr_reqd_yn=orderItemObj.data("ord_appr_reqd_yn");
	var order_set_id=orderItemObj.data("order_set_id");
	var pat_id=orderItemObj.data("pat_id");
	var pat_class=orderItemObj.data("pat_class");
	var encount_id=orderItemObj.data("encount_id");
	var ord_catalog_desc=orderItemObj.data("ord_catalog_desc");
	var link_ref=orderItemObj.data("link_ref");
	var link_ref_no=orderItemObj.data("link_ref_no");
	var ord_auth_reqd_yn=orderItemObj.data("ord_auth_reqd_yn");
	var ord_auth_by_pract_id=orderItemObj.data("ord_auth_by_pract_id");
	var priority=orderItemObj.data("priority");
	var location_type=orderItemObj.data("location_type");
	var location_code=orderItemObj.data("location_code");
	var consent_form_list=orderItemObj.data("consent_form_list");
	var link_ref_det=orderItemObj.data("link_ref_det");
	var appt_reqd_yn=orderItemObj.data("appt_reqd_yn");
	//var consent_stage=orderItemObj.data("consent_stage");
	var patientdetails=orderItemObj.data("patientdetails");
	
	var facility_id = $("#facility_id").val();
	var practitioner_id = $("#practitioner_id").val();
	
	$("#consentItemView").empty();
	$("#consentItemView").append("<div class='loadingCartItem'></div>");
	$('#consentItemView').load(path+'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp',{order_id: order_id, consent_form_id: consent_form_id, consent_form_desc: consent_form_desc, consent_stage: consent_stage} );
		
}
</script>
<style>
#RecordConsentConfirmDialog {
  display: none;
  width: 340px;
  height: 280px;
  z-index: 500;
}
.Error_Window {
	width: 325;
	height: 200px;
	border: 2px solid #ffffff;
	background: #074860;
	margin: 10px;
	min-height: 200px;
	max-width: 325px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	margin: 10px;
	border-radius: 10px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	overflow: hidden
}
	.Error_msg_box {
	width: 100%;
	height: 150px;
	max-height: 150px;
	max-width: 100%;
	border-bottom: 1px solid #000000;
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
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	color:#ffffff;
	text-align:center;
	padding-top: 10px;
	padding-left:10px;
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
.Error_btn_div
{
	width:0px;
	height:100%;
	border-left:1px solid #0bb5dd;
	border-right:1px solid #023542;
	float: left;
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

</style>
</head>
<body>
	<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div><!-- TODO -->
	<div id="RecordConsentConfirmDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
		  <div class="Error_msg_box">
		    <div class="Error_msg">
		      <div class="Error_msg_Frame">
		        <div>
		          <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30" /> </div>
		          <div class="Error_cont" id="RecordConsentConfirmDialogMsg"></div>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="Error_msg_btn">
		    <div class="Error_btn_div_con" onclick="closeConfirmDialog()">Cancel </div>
		    <div class="Error_btn_div"> </div>
		    <div class="Error_btn_div_con" data-value="true">OK </div><!-- Onclick event for OK button will be binded dynamically -->
		  </div>
		  <div class="top_shadow"> </div>
		</div>
	</div>

<%
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	RecordConsentBC bc = new RecordConsentBC();
	RecordConsentFieldResponse consentFormListResp = bc.getConsentFormList(patientContext);
	List<RecordConsentFieldItem> consentFormList = consentFormListResp.getFieldList();
			
%>
	
	<div id="ConsentFormSelPopup" class="absoluteCenter" >
		<div class="navModal-content">
			<div class="navAccess">SELECT CONSENT FORM</div>
		<div  id="navConsentScrollWrapper">
				<div  id="navConsentScroll">
	<%
		if(!consentFormList.isEmpty()){
			
			for(int i=0;i<consentFormList.size();i++){
				RecordConsentFieldItem consentFormItem = consentFormList.get(i);
		
	%>			
					<!-- Each Form Item STARTS -->
					<div class="popTable navControl" onclick="chooseConsentForm('<%=consentFormItem.getDesc() %>','<%=consentFormItem.getCode()%>')">
						<div class="popTableRow">
							<div class="popTableRowCellLab" >
								
									<img src="${path}/eIPAD/images/Consent16x16.PNG"></img>
								
							</div>
							<div class="popTableRowCellCont"><%=consentFormItem.getDesc() %></div>
							<div class="popTableRowCellClick">
								
									<img src="${path}/eIPAD/images/Arrow_24x24.png"></img>
								
							</div>
						</div>
					</div>
					<!-- Each Form Item ENDS -->
	<%
			}
		}else{
			out.println("No consent forms configured");
		}
	%>				
					
				</div>
			</div>
			<div class="navConsentCancel"  id="closePoPUp" onclick="closeConsentSelPop()">CANCEL</div>   
		</div>
	</div>  


	<div id="divParent" class = "mdivParent" data-role="page">
		
		<%-- <form id="ChartsBaseForm" name = "ChartsBaseForm" method = "post" action = "${path}/setpatientcontext"> --%>
			<div id="divTable" class = "mdivTable" data-role = "none">
			
				<!-- header starts -->
				<div data-role = "none" class = "mheaderRow" id="EMHeader">
					<table class="mheader grd1-theme" border = "0" cellspacing = "0" cellpadding = "0">
				        <tr style = "width:100%;height:100%">
							<td style = "width:90%;height:100%" align = "left" ><span class="mheaderText headerText1-theme">${sessionScope["product_description"]} - ${sessionScope["version_no"]}</span></td>
							<td style = "width:10%;height:100%" valign = "center" align = "right" onclick = "logout()">
								<img src = "${path}/eIPAD/images/Logout1.png" class="mHeaderImgLogout" ></img>
							</td>
				        </tr>
		       		</table>
			       
					<div class = "PatienBannerContainer PatientBannerContainerTheme" data-role = "none" >
					    <div class = "PatientBannerRow" data-role = "none">
					    	<div class = "PatientBannerPhotoCol" data-role = "none">
					    		<img class="PatientBannerImage" width="55" height="55" src="${path}/mobile/PatientImageServlet?PatientId=${requestScope.bannerPatientId}">
					    	</div>
					    	<div class = "PatientBannerDataCol" data-role = "none">
						    	<div data-role = "none" class = "PatientBannerDataLine1">
						    		<div class = "PatientBannerDataRow1" data-role = "none">
						    		
						    			<div class = "PatientBannerPatientIDCol PatientBannerPatientIDColTheme" data-role = "none">${requestScope.bannerPatientId}</div>
						    			<div class = "PatientBannerPatientNameCol PatientBannerPatientNameColTheme" data-role = "none">${requestScope.bannerPatientName}</div>
						    			<div class = "PatientBannerTextCol PatientBannerTextColTheme" data-role = "none">${requestScope.bannerPatientNameLocal}</div>
						    		</div>
						    	</div>
						    	<div data-role = "none" class = "PatientBannerDataLine2">
						    		<div class = "PatientBannerDataRow2" data-role = "none">
						    			<div class = "PatientBannerTextCol PatientBannerTextColTheme" data-role = "none">
						    				<c:if test="${not empty requestScope.bannerDob}">
						    					${requestScope.bannerDob}&nbsp;-
						    				</c:if>
						    				<c:if test="${not empty requestScope.bannerAge}">
						    					&nbsp;${requestScope.bannerAge},&nbsp;
						    				</c:if>
						    				<c:if test="${not empty requestScope.bannerGender}">
						    				 	${requestScope.bannerGender},&nbsp; 
						    					
						    				</c:if>
						    				<c:if test="${not empty requestScope.bannerNationality}">
												${requestScope.bannerNationality}&nbsp; 
											</c:if> 

<%-- 										<fmt:message key="eOT.AssignUser.Label" bundle="${ot_labels}"/>
						    				<fmt:message bundle="${cserrors}" key="DatabaseConnectionFailure" />
						    				<fmt:message key="com.iba.ehis.lc.standardStock.source" bundle="${lclabels}"/> --%>
						    			</div>
						    		<c:if test="${not empty requestScope.bannerEncounterId}">
						    			<div class = "PatientBannerLabelCol PatientBannerLabelColTheme" data-role = "none"><%=csResBundle.getString("common.encounterId") %></div><!-- TODO replace with message bundle text --> 
						    			<div class = "PatientBannerTextCol PatientBannerTextColTheme" data-role = "none">${requestScope.bannerEncounterId}</div>
						    		</c:if>
						    		
						    			<div class = "PatientBannerLabelCol PatientBannerLabelColTheme" data-role = "none"><%=csResBundle.getString("common.practitioner") %></div><!-- TODO replace with message bundle text -->
						    			<div class = "PatientBannerTextCol PatientBannerTextColTheme" data-role = "none">${requestScope.bannerAttendPractName}</div>
						    		
						    			
						    		</div>
						    	</div> 
					    	</div>
					    	<div class = "PatientBannerIconCol" data-role = "none">
					    		<div class = "PatientBannerIconTable" data-role = "none">
						    		<div class = "PatientBannerIconRow" data-role = "none">
						    		<c:if test="${requestScope.bannerVip == 'true' }">
						    			<div class = "PatientBannerIcons" data-role = "none"><img class="PatientBannerIconImg" src="${path}/eIPAD/images/VIP.png"></div>
						    		</c:if>
						    		</div>
						    		<div class = "PatientBannerIconRow" data-role = "none">
						    			<div class = "PatientBannerIcons" data-role = "none"><img class="PatientBannerIconImg" src="${path}/eIPAD/images/Down Arrow.png" style="display:none"></div>
						    		</div>
					    		</div>
					    	</div>
					    </div>
									     
			       	</div>
		   		</div><!-- div first row header ends  -->
		   		
		   		<!-- Page content starts -->
<div data-role = "none" class = "secondRow secondRowTheme">
<div class="ChartsContent">
<div class="ChartsIframeContainer" id="patientConsentListContainer">
<div id="ContentPageID" style="display:table;height: 100%;width: 100%;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;-ms-box-sizing: border-box;box-sizing: border-box;position: absolute;overflow: hidden;left: 0;right: 0;top: 0;bottom: 0;border: 5px solid transparent;">
<div id="allergyHeader" class="AllergyHeader" style="padding: 0px;height: 1%;display:table-row;" data-role="none">
	<div style="display:table-cell;">
	<table cellpadding="0" cellspacing="0" class="tbAllergyHeader" data-role="none">
		<tr class="normalTr">
			<td class="normalTd">
				<div class="viewNotesHeader  RecordAllergyHeaderTheme" style="border-bottom: 1px solid transparent;">
					<div class="RecordAllergyTable">
						<div class="normalRow">
							<div class="AllergyCell" style="width: 95%; text-align: left">
								<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Record Consent</div>
							</div>
							<div class="AllergyCell" style="width: 5%">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell"
											style="width: auto; text-align: right">
											<div class="">
												<div class="WidgetButtonTheme heightAlignment" style = "margin-right:10px;margin-top: 4px;" onclick="" id="RecordConsentTickBtn">
													<img src="${path}/eIPAD/images/Tick25x25.png">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="AllergyCell" style="width: 5%">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell"
											style="width: auto; text-align: right">
											<div class="">
												<div class="WidgetButtonTheme heightAlignment" style = "margin-right:10px;" onclick="" id="RecordConsentCanceBtn">
													<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
	</div>
</div>
<form id="RecordConsentForm" name="RecordConsentForm" id="RecordConsentForm" style="width:100%;height:100%;">
	<div id="consentItemView" style ="width:100%;height:100%;display: table;background:white;">
	</div>
</form>
<div class="CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"></div>
								</div>
</div>
						
						
						</div>
					</div>
				</div>
		   		
		   		<!-- Page content ends here -->
		   		
		   		<!-- Footer starts -->
				<div data-role = "none" class = "footer" id="EMFooter" >
					<div class = "footerContent footerContentTheme" data-role = "none">
			     		<table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
				        	<tr style = "width:100%;height:100%">
								<td style = "width:65%;height:100%" valign = "top">
					            	<table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
						            	<tr style = "width:100%;height:50%">
						            		<td style = "width:100%;height:100%" valign = "top" align = "left">
						            	    	<span class="spUserInfo">${sessionScope["login_user"]}</span>
						            	  	</td>
						            	</tr>
						            	<tr style = "width:100%;height:50%">
						            		<td style = "width:100%;height:100%" valign = "top" align = "left">
						            	  		<span class="spUserInfo">${sessionScope["facility_name"]} - ${sessionScope["userSite"]}</span>
						            	  	</td>
						            	</tr>
					            	</table>
					          	</td>
					          	<td style = "width:30%;height:100%" align = "right" valign = "top">
					          		<%-- <span class="spCopyRights"><%=csResBundle.getString("common.allRightsReserved") %></span> --%> <!-- TODO replace with message bundle text --> 
					         		<img src="${path}/eIPAD/images/CSC_Logo.png" class="imgCopyRights"></img>
					          	</td>
				        	</tr>
			       		</table>
			   		</div>    
		   		</div>
		   		<!-- Footer Ends -->
		   		
			</div><!-- divTable ends here -->
			<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
			<input type = "hidden" name = "hdnSelectedEncounter" id = "hdnSelectedEncounter" value="" />
			<input type = "hidden" name = "hdnopeningPage" id = "hdnopeningPage" value="" />
			<input type = "hidden" name = "hdnEpisodeId" id = "hdnEpisodeId" value="${sessionScope.PatientContext.encounterId}" />
			<input type = "hidden" name = "hdnPatientId" id = "hdnPatientId" value="${sessionScope.PatientContext.patientId}" />
			<input type = "hidden" name = "hdnLocnType" id =  "hdnLocnType" value = "${sessionScope.PatientContext.locationType}" />
		    <input type = "hidden" name = "hdnLocnCode" id =  "hdnLocnCode" value = "${sessionScope.PatientContext.locationCode}" />
		    <input type="hidden" name="hdnPatClass" id="hdnPatClass" id="hdnPatClass" value="${sessionScope.PatientContext.patientClass}"/>
			
			<input type = "hidden" name = "currentOrderId" id = "currentOrderId" value ="" />
			<input type = "hidden" name = "currentCode" id = "currentCode" value ="" />
			<input type = "hidden" name = "currentLineNum" id = "currentLineNum" value ="" />
			<input type = "hidden" name = "currentSeq" id = "currentSeq" value ="" />
			<input type = "hidden" name = "currentstage" id = "currentstage" value ="" />
			<input type = "hidden" name = "currentindex" id = "currentindex" value ="" />
		<!-- </form> -->
	</div> <!-- divParent ends here -->
	
</body>
</html>

