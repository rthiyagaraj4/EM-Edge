<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../../eCommon/jsp/CommonInclude.jsp"%>
<%
String product_description = "";
String version_no = "";
String path = request.getContextPath();
ArrayList<String> RespIdArrayList = new ArrayList<String>();
ArrayList<String> RespNameArrayList = new ArrayList<String>();
ArrayList<String> FacilityIdArrayList = new ArrayList<String>();
ArrayList<String> FacilityNameArrayList = new ArrayList<String>();
int RespCount = 0;
int FacilityCount = 0;
if(request.getAttribute("LoginRespIdArray") != null) {
	RespIdArrayList = (ArrayList<String>)request.getAttribute("LoginRespIdArray");
}
if(request.getAttribute("LoginRespNameArray") != null) {
	RespNameArrayList = (ArrayList<String>)request.getAttribute("LoginRespNameArray");
}
if(request.getAttribute("LoginFacilityIdArray") != null) {
	FacilityIdArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityIdArray");
}
if(request.getAttribute("LoginFacilityNameArray") != null) {
	FacilityNameArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityNameArray");
}
if(request.getAttribute("LoginRespCount") != null) {
	RespCount = (Integer)request.getAttribute("LoginRespCount");
}
if(request.getAttribute("LoginFacilityCount") != null) {
	FacilityCount = (Integer)request.getAttribute("LoginFacilityCount");
}
if(session.getAttribute("version_no") != null) {
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null) {
	product_description = (String)session.getAttribute("product_description");
}
%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Insurance Authorization Form</title>   
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/jquery.mobile-1.0.1.min.css" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.common.min.css" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.default.min.css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="<%=path%>/eIPAD/kendo.web.min.js"></script>
	<script src="<%=path%>/eIPAD/console.js"></script>
	
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" />
	<script type="application/javascript" src="<%=path%>/eIPAD/js/GenericSlider.js"></script>
	<script type="application/javascript" src="<%=path%>/eCommon/js/common.js"></script>
	<script src="<%=path%>/eIPAD/js/IALoginUI.js"></script>
	<script src="<%=path%>/eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="<%=path%>/eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel="stylesheet" href="<%=path%>/eIPAD/css/mLogin.css" /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/mCommon.css" /> 
	<script>
		var contextPath = "<%=path%>";
		var totalItemsCount = "<%=RespNameArrayList.size()%>";
		document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
		var myScroll;
		function logout() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					window.location = "<%=path%>/ialogin";
				}
			}
		xmlhttp.open("POST", contextPath+"/eIPAD/jsp/Logoff.jsp", true);
		xmlhttp.send();
		}
	
		$(document).ready(function(){
        	$("#encounterId").kendoComboBox({
        		dataTextField: "encounterId",
  				dataValueField: "encounterId"
        	});
    	});
	</script>
	<style>
	.CNButtonContainer {
margin-right: 10px;
display: table;
width: 42px;
cursor:pointer;
}
	</style>
</head>
<body>
	<div id="divParent" class="mdivParent" data-role="page">
	  	<form id='formClaimFormsCriteria' name='formClaimFormsCriteria' id='formClaimFormsCriteria'>
			<div id="divTable" class = "mdivTable" data-role = "none">
		 		<div data-role = "none" class = "mheaderRow"><!-- header starts -->
					<table class="mheader grd1-theme" border = "0" cellspacing = "0" cellpadding = "0">
			        	<tr style = "width:100%;height:100%">
							<td style = "width:90%;height:100%" align = "left" ><span class="mheaderText headerText1-theme"><%=product_description%> - <%=version_no%></span></td>
							<td style = "width:10%;height:100%" valign = "center" align = "right" onclick = "logout()">
								<img src = "<%=path%>/eIPAD/images/Logout1.png" class="mHeaderImgLogout" ></img>
							</td>
			        	</tr>
		       		</table>
		   		</div><!-- div first row header ends  -->
		   		<div class="bg1-theme" style="display:table-row;height:10%;">
					<div style="display:table;width:100%;height:auto;">
						&nbsp;
						<div style="display:table-row;width:100%;height:auto;">
			  				<div style="display: table-cell;width:40%;height:auto;">
            					<div style="display:table;width:100%;height:auto;">
			  						<div style="display:table-row;width:100%;height:auto;">
               							<div class="iaLoginRowFonts" id="labelPat" style="display:table-cell;width:30%;height:auto;vertical-align: middle;">
			  								&nbsp;<fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/>
			  								<img src="<%=path%>/eCommon/images/mandatory.gif">
			   							</div>
			     						<div id="textPat_Label"  style="display:table-cell;width:60%;height:auto;vertical-align: middle;">
                    						<input type="text" id="Patient_Id" name="Patient_Id" id="Patient_Id" maxlength='20' size=20' class="k-textbox" value='' style="text-transform: uppercase;background-color: #eff4f8;" onkeyup="resetFrame()"/>
			   							</div>
			   							<div id="arrPat_Label"  style="display:table-cell;width:10%;height:auto;vertical-align: middle;" class="CNButtonItemTheme">
			   								<img src = "<%=path%>/eIPAD/images/Right.png" onclick="populateEncounter()">
			   							</div>
			  						</div>
			  					</div>
			  				</div>
			  				<div style="display: table-cell;width:50%;height:10%;vertical-align: middle;">
			    				<div style="display:table;width:100%;height:10%;vertical-align: middle;">
			    					<div style="display:table-row;width:100%;height:auto;">
			    						<div class="iaLoginRowFonts" id="lableEnc" style="display:table-cell;vertical-align: middle;width:30%;height:auto;">
			    							&nbsp;<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			    						</div>
			    						<div id="spinEnc"  style="display:table-cell;width:70%;height:auto;">
			    						 	<select style="width:90%;" name="encounterId" id="encounterId" id="encounterId" data-mandatory="true" placeholder="--Select--">
											</select> 
			    						</div>
			    					</div>
			  					</div>
			  				</div>
			  				<div style="display: table-cell;width:10%;height:auto;">
								<input type="button" class="k-button" name="Search" id="Search" VALUE='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="getResultForTab()" />
			  				</div>
			  			</div>
			 		</div>
				</div>
				<div data-role = "none" class="bg1-theme" style="height:100%;">
					<div  id="searchresultframe"></div>
					<div  id="iaform"  style="height:100%;width:100%"></div>
				</div>
				<div data-role = "none" class = "mfooter" ><!-- Footer start  -->
					<div class = "mfooterContent border3Top-theme grd3-theme iaLoginRowFonts" data-role = "none" id="errorframe"></div>    
		   		</div><!-- div footerends here -->
			</div> <!-- div table ends here -->
	  	</form>
	</div>
</body>
</html>

