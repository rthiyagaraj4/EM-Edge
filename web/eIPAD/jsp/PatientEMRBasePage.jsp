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
<title>Patient Charts</title>
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/mCommon.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/kendo/kendo.common.min.css"/> 
<link rel="stylesheet" href="${path}/eIPAD/css/kendo/kendo.silver.min.css" />
 <%--<link rel="stylesheet" href="${path}/eIPAD/css/kendo/kendo.custom.css" /> --%>
<script type="text/javascript" src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>  
<link rel="stylesheet" href="${path}/eIPAD/css/iPadPharmaCommon.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPadPharmaPages.css" /> 
<script src="${path}/eIPAD/js/lib/jquery/jquery-2.2.4.js"></script> 
<script src="${path}/eIPAD/js/lib/kendo/kendo.all.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<style>
body {
    position: fixed;
}
</style>
<script>
//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
var path;
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

$(document).ready(function(){
	path = $("#hdnPath").val();
	$("#ChartFunctionPage").load("${path}/mobile/charts/pharmacy/PharmInitServlet");
	
	if (window.DeviceOrientationEvent) {
		window.addEventListener('orientationchange',
				myOrientResizeFunction, false);
	}
	var frameHeight = getTotalPageDivHeight() - $('#EMHeader').height() - $('#EMFooter').height();
	$('#ChartFunctionPage').css("height" ,frameHeight );
    //$('#ChartSummaryNotesIframe').css("height" ,frameHeight );
	
	function myOrientResizeFunction() {
		setTimeout(function() {
		var orient = Math.abs(window.orientation) === 90 ? 'landscape' : 'portrait';
		var ht = getTotalPageDivHeight() - $('#EMHeader').height() - $('#EMFooter').height()
		if (orient == "landscape") {
			$('#ChartFunctionPage').css("height" ,ht );
			document.getElementById("ChartFunctionPage").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
			
		
		} else {
			$('#ChartFunctionPage').css("height" ,ht );
			document.getElementById("ChartFunctionPage").contentWindow.changeOrientation(orient, $('#EMHeader').height() + $('#EMFooter').height());
			
		}
	}, 500);
	}
	
});
function getTotalPageDivHeight(){
	var i = $('#divParent').height();
	return i;
}

function openOtherChartFunctions(functionName){
	window.location.replace(path+"/setpatientcontext?activePage="+functionName+"&setNewPatientContext=N"); 
}
function openPharmacyFunction(){
	$("#ChartFunctionPage").load("${path}/mobile/charts/pharmacy/PharmInitServlet");
}
function closeChartSummary(){
	$("#ChartSummaryBlock").append("<div class='loadingCartItem'></div>");
	 window.location.replace(path+"/eIPAD/jsp/IPad.jsp?ActivePage=IP"); 
}



</script>
<style>


</style>
</head>
<body>


<% 
String openingPage = request.getParameter("activePage")==null?"":request.getParameter("activePage"); 

%>
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
		   			<div class="ChartsContent">
		   				<div id="ChartFunctionPage" style="width:100%;height:100%">
		   				
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
		    <input type="hidden" name="hdnOpeningPage" id="hdnOpeningPage" id="hdnOpeningPage" value="<%=openingPage%>"/>
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
	<!-- modal box content Ends -->
</body>
</html>

