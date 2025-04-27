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

String scrollToWidget = request.getParameter("scrollToWidget")==null?"":request.getParameter("scrollToWidget");


%>

<!DOCTYPE html> 
<html> 
<head> 
<title>Patient Charts</title>

<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js" ></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" />  --%>
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" /> 


<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/mCommon.css" /> 


<script>
var bNotesContentLoaded = false; //c
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

/* $(document).ready(function(){
	
	if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',
				myOrientResizeFunction, false);
	}

	function myOrientResizeFunction() {
		var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
		if (orient == "landscape") {
			document.getElementById("ChartSummaryIframe").contentWindow
					.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
		} else {
			document.getElementById("ChartSummaryIframe").contentWindow
					.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
		}

	}
});
 */
$(document).ready(function(){

	if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',
				myOrientResizeFunction, false);
	}
	var frameHeight = getTotalPageDivHeight() - $('#EMHeader').height() - $('#EMFooter').height();
	$('#ChartSummaryIframe').css("height" ,frameHeight );
    //$('#ChartSummaryNotesIframe').css("height" ,frameHeight );
	
	function myOrientResizeFunction() {
		setTimeout(function() {
		var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
		var ht = getTotalPageDivHeight() - $('#EMHeader').height() - $('#EMFooter').height()
		if (orient == "landscape") {
			$('#ChartSummaryIframe').css("height" ,ht );
			$('#ChartSummaryNotesIframe').css("height" ,ht ); //cn
			document.getElementById("ChartSummaryIframe").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
			
			if(bNotesContentLoaded)
			{
				document.getElementById("ChartSummaryNotesIframe").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());	
			}
			
		} else {
			$('#ChartSummaryIframe').css("height" ,ht );
			$('#ChartSummaryNotesIframe').css("height" ,ht ); //cn
			document.getElementById("ChartSummaryIframe").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
			
			if(bNotesContentLoaded)
			{
				document.getElementById("ChartSummaryNotesIframe").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());	
			}
			
			
		}
	}, 500);
	}

});
function setNotesFrameContentHeight()
{
	var orientOnLoad = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
	document.getElementById("ChartSummaryNotesIframe").contentWindow.changeOrientation(orientOnLoad, $('#EMHeader').height() + $('#EMFooter').height());
}
function setOnLoadContentPaneHeight() {
	//On Initial Load change the frame height based on the orientation
	var orientOnLoad = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
	document.getElementById("ChartSummaryIframe").contentWindow
			.changeOrientation(orientOnLoad,$('#EMHeader').height() + $('#EMFooter').height());
}

function getTotalPageDivHeight(){
	var i = $('#divParent').height();
	return i;
}

//Active problems - Authorize Sensitive related functions below
function clearPwdText(){
	$('#authorizeTextBox').val("");
	$("#clearPwdTextImg").addClass("authorizeControlsDim");
	$("#authorizeOKButton").addClass("authorizeControlsDim");
	$("#authorizeTextBox").attr("placeholder","");
	$('#ChartSummaryIframe').contents().find('#SensitiveDataPwd').val("");
}

function pwdTextChange(pwdObj){
	var pwdval = $(pwdObj).val();
	if(pwdval.length > 0){
		$("#clearPwdTextImg").removeClass("authorizeControlsDim");
		$("#authorizeOKButton").removeClass("authorizeControlsDim");
	}
	if(pwdval.length <= 0){
		$("#clearPwdTextImg").addClass("authorizeControlsDim");
		$("#authorizeOKButton").addClass("authorizeControlsDim");
	}
}
function closeChartSummary(){
	$("#ChartSummaryBlock").append("<div class='loadingCartItem'></div>");
	 var path = document.getElementById("hdnPath").value + "/eIPAD/jsp/IPad.jsp?ActivePage=IP";
	 window.location.replace(path); 
}
function openAuthorizePrompt(){
	$("#divParent").addClass("dialogIsOpen");
	$("#authorizeWindow").show();
	$("#dvMez").show();
	/* $("body").on("click", function(e) {
		//alert("clicked outside");
		closeAuthorizePrompt();
	}); */
	$("#authorizeWindow").on("click", function(e){
		//alert("Clicked inside");
		e.stopPropagation();
	});
}
function closeAuthorizePrompt(){
	$("#divParent").removeClass("dialogIsOpen");
	$("#authorizeTextBox").attr("placeholder","");
	$("#authorizeTextBox").val("");
	$("#clearPwdTextImg").addClass("authorizeControlsDim");
	$("#authorizeOKButton").addClass("authorizeControlsDim");
	$('#ChartSummaryIframe').contents().find('#SensitiveDataPwd').val("");
	$("#authorizeWindow").hide();
	$("#dvMez").hide();
	
}
function validatePwd(){
	var pwdval = $("#authorizeTextBox").val();
	var $f = $("#ChartSummaryIframe");//getting the ifame
	//var fd = $f[0].document || $f[0].contentWindow.document; // document of iframe
	$('#ChartSummaryIframe').contents().find('#SensitiveDataPwd').val(pwdval);
	if(pwdval.length > 0){
		//fd.authorizeUser();  // run function
		$f[0].contentWindow.authorizeUser(); 
	}
}
function showPwdValError(){
	$("#authorizeTextBox").attr("placeholder","Invalid Password");
	$('#authorizeTextBox').val("");
	$("#clearPwdTextImg").addClass("authorizeControlsDim");
	$("#authorizeOKButton").addClass("authorizeControlsDim");
}
function clearPlaceholderText(pwdObj){
	$(pwdObj).attr("placeholder","");
}
function chooseEncounter(encIdSelected){
	$("#hdnSelectedEncounter").val(encIdSelected);
	$("#ChartsBaseForm").submit();
}
function chooseEncounterForNote(encIdSelected,openingPage){
	$("#hdnSelectedEncounter").val(encIdSelected);
	$("#hdnopeningPage").val(openingPage);
	$("#ChartsBaseForm").submit();
}
function showNotesContent(accessionNum)
{
	bNotesContentLoaded = true;
	//document.getElementById('ChartSummaryNotesIframe').src = '${path}/eIPAD/jsp/chartwidgets/ViewClinicalNotesContent.jsp?accession_num=' + accessionNum;
	$('#ChartSummaryNotesIframe').attr('src' , '${path}/eIPAD/jsp/chartwidgets/ViewClinicalNotesContent.jsp?accession_num=' + accessionNum);
	$('#dvChartSummaryFrame').css("display" , "none");
	$('#dvNotesFrame').css("display" , "block");
	
}

function closeNotesContent()
{
	bNotesContentLoaded = false;
	$('#dvChartSummaryFrame').css("display" , "block");
	$('#dvNotesFrame').css("display" , "none");
	var orientOnLoad = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
	document.getElementById("ChartSummaryIframe").contentWindow
			.changeOrientation(orientOnLoad,$('#EMHeader').height() + $('#EMFooter').height());
	
	
	
}



//this event will post orientation change messages to the iframe ChartSummaryIframe
window.addEventListener("orientationchange", function(e){
	var targetFrame = document.getElementById('ChartSummaryIframe').contentWindow; //$('#ChartSummaryIframe');
	//alert("message sent");
	targetFrame.postMessage('OrientationChange','*');
}, false);

function openPharmacyOrders(){
	var path = $("#hdnPath").val();
	window.location.replace(path+"/PatientEMRServlet"); 
}

</script>
<style>


</style>
</head>
<body>


<% 
String navPage = request.getParameter("hdnNavType")==null?"":request.getParameter("hdnNavType");
String openingPage = "";

openingPage = request.getParameter("activePage")==null?"":request.getParameter("activePage"); %>
	<div id="divParent" class = "mdivParent" data-role="page">
		<div data-role = "none" id = "dvMez" class="blurPopup"></div>
		<form id="ChartsBaseForm" name = "ChartsBaseForm" method = "post" action = "${path}/setpatientcontext">
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
		   		<% if(openingPage.equals("clinicalNotes") || navPage.equals("clinicalNotes") ){ %>
		   		<div class="ChartsContent">
		   				<div class="ChartsIframeContainer" id = "dvChartSummaryFrame">
		   					<iframe id="ChartSummaryIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/mobile/charts/notes/OpenClinicalNoteServlet"> </iframe>
		   				</div> 
		   				 <div class="ChartsIframeContainer" id = "dvNotesFrame" style = "display:none; text-align: -webkit-center;">
		   					<iframe id="ChartSummaryNotesIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" style="width: 98%;height: 98%;margin-top: 5px;"> </iframe>
		   				</div> 
		   			</div> 
		   		<% } else if(openingPage.equals("placeOrder")|| navPage.equals("placeOrder") ){%>
		   			<div class="ChartsContent">
		   				<div class="ChartsIframeContainer" id = "dvChartSummaryFrame">
		   					<iframe id="ChartSummaryIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/mobile/charts/orders/MNewOrderServlet"> </iframe>
		   				</div> 
		   				<div class="ChartsIframeContainer" id = "dvNotesFrame" style = "display:none; text-align: -webkit-center;">
		   					<iframe id="ChartSummaryNotesIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" style="width: 98%;height: 98%;margin-top: 5px;"> </iframe>
		   				</div>
		   			</div> 
				<%} else if(openingPage.equals("clinicalEvents") || navPage.equals("clinicalEvents") ){ %>
		   			<div class="ChartsContent">
		   				<div class="ChartsIframeContainer" id = "dvChartSummaryFrame">
		   					<iframe id="ChartSummaryIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsBasePage.jsp"> </iframe>
		   				</div> 
		   				<div class="ChartsIframeContainer" id = "dvNotesFrame" style = "display:none; text-align: -webkit-center;">
		   					<iframe id="ChartSummaryNotesIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" style="width: 98%;height: 98%;margin-top: 5px;"> </iframe>
		   				</div>
		   			</div> 
		   	  <%} else if(openingPage.equals("pharmacyOrder") || navPage.equals("pharmacyOrder") ){ %>
		   			<div class="ChartsContent">
		   				<div class="ChartsIframeContainer" id = "dvChartSummaryFrame">
		   					<iframe id="ChartSummaryIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/mobile/charts/pharmacy/PharmInitServlet"> </iframe>
		   				</div> 
		   				<div class="ChartsIframeContainer" id = "dvNotesFrame" style = "display:none; text-align: -webkit-center;">
		   					<iframe id="ChartSummaryNotesIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" style="width: 98%;height: 98%;margin-top: 5px;"> </iframe>
		   				</div>
		   			</div> 					
				<% } else {%>
				<div class="ChartsContent">
		   				<div class="ChartsIframeContainer" id = "dvChartSummaryFrame">
		   					<iframe id="ChartSummaryIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/mobile/chartsummary/ChartWidgetsView?scrollToWidget=<%=scrollToWidget%>"> </iframe>
		   				</div> 
		   				<div class="ChartsIframeContainer" id = "dvNotesFrame" style = "display:none; text-align: -webkit-center;">
		   					<iframe id="ChartSummaryNotesIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" style="width: 98%;height: 98%;margin-top: 5px;"> </iframe>
		   				</div>
		   			</div> 
		   		<%} %>
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
		</form>
	</div> <!-- divParent ends here -->
	 <!-- modal box content Starts -- Active Problems & diagnosis sensitive data authorization -->
	<div id="authorizeWindow" style="display:none" class="authorizeWindow authorizeWindowTheme">
		<div class="authorizeWindowTitle WidgetWhiteBoldText2Theme">
			<div style="display:table-cell;vertical-align:middle">Authorize</div>
		</div>
		<div class="authorizeTextBoxContainer authorizeTextBoxContainerTheme">
			<div style="display:table-row">
				<div style="display: table-cell; width: 220px;">
					<input type="password" class="authorizeTextBox authorizeTextBoxTheme" onkeyup="pwdTextChange(this)" onclick="clearPlaceholderText(this)" placeholder="" id="authorizeTextBox" name="authorizeTextBox" id="authorizeTextBox">
				</div>
				<div style="display: table-cell; text-align: center; vertical-align:middle">
					<div class="authorizeClrTxtCircle authorizeClrTxtCircleTheme authorizeControlsDim" onclick="clearPwdText()" id="clearPwdTextImg"></div>
				</div>
			</div>
		</div>
		<div style="display:table;height:10px"></div>
		<div class="authorizeButtonContainer">
			<div style="display:table-row;width:100%">
				<div style="" class="authorizeButtonTheme" id="authorizeCancelButton" onclick="closeAuthorizePrompt()">
					Cancel
				</div>
				<div style="display:table-cell;width:10px;" class=""></div>
				<div style="" class="authorizeButtonTheme authorizeControlsDim" id="authorizeOKButton" onclick="validatePwd()">
					OK
				</div>
			</div>
		</div>
	</div>
	<!-- modal box content Ends-->
</body>
</html>

