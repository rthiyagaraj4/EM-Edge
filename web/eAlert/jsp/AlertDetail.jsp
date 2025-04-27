<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!DOCTYPE html>
	
<%@page import="eAlert.src.config.AlertConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page import = "java.util.*" %>
 <%@ page import = "eAlert.src.alert.response.*" %>
 <%@ page import = "eAlert.src.config.*" %>


 
 <script type='text/javascript' src="eAlert/js/json2.js"></script>
 <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
 <script type='text/javascript' src="eAlert/js/kendo.web.min.js"></script>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
AlertDetailsResponse alertDetailsResponse = null;

long patientAlertSeqId = 0;
long patientRecipientSeqId = 0;
String alertName = "";
String alertDescription = "";
String patientId = "";
String patientName = "";
String dateTimeDisplay = "";
String details = "";
String alertPriority = "";
String sFlagged = "";
String sReceived = "";
String sReviewed = "";
String sForwarded = "";
String sComments = "";
String modifiedDate = "";
String receivedUserID = "";
String forwardedUserNames = "";
int count = 0;

if(request.getAttribute("AlertDetailsResponse") != null){
	alertDetailsResponse = (AlertDetailsResponse)request.getAttribute("AlertDetailsResponse");
	
	if(alertDetailsResponse != null)
	{
		patientAlertSeqId = alertDetailsResponse.getPatientAlertSeqId();
		patientRecipientSeqId = alertDetailsResponse.getPatientRecipientSeqId();
		alertName = alertDetailsResponse.getAlertName();
		alertDescription = alertDetailsResponse.getAlertDescription();
		patientName = alertDetailsResponse.getPatientName();
		dateTimeDisplay = alertDetailsResponse.getDateTimeDisplay();
		details = alertDetailsResponse.getDetails();
		alertPriority = alertDetailsResponse.getAlertPriority();
		sFlagged = alertDetailsResponse.getFlagged();
		sReceived = alertDetailsResponse.getReceived();
		sReviewed = alertDetailsResponse.getReviewed();
		sForwarded = alertDetailsResponse.getForwarded();
		sComments = alertDetailsResponse.getComments();
		modifiedDate = alertDetailsResponse.getModifiedDate();
		receivedUserID = alertDetailsResponse.getReceivedUserId();
		forwardedUserNames = alertDetailsResponse.getForwardedUserId();
		count = alertDetailsResponse.getTotalCount();
	}
}
%>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Alert</title>
<link href="eAlert/css/Style.css" rel="stylesheet" type="text/css" />
<link href="eAlert/css/kendo.common.min.css" rel="stylesheet" type="text/css" />
<link href="eAlert/css/kendo.default.min.css" rel="stylesheet" type="text/css" />
<link href="eAlert/css/kendo.silver.min.css" rel="stylesheet" type="text/css" />

<script language="javascript">
var currentAlertId;
var selectedTab;
var xmlHttp = null;
var flagTime = null;
var flagged = null;
var forwardUsersList = null;
window.parent.interval = 0;

$(document).ready(function() {
    // create MultiSelect from select HTML element
    $("#fwdselect").kendoMultiSelect({
    	dataTextField: "userName",
    	dataValueField: "userId",
    	change : function(e) {
    		forwardUsersList = this.value();
    	}
    });
    
});

function loadXmlHttp(){
	if (window.XMLHttpRequest) { // IE7, Mozilla, Safari, Opera, etc. 
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // IE 5.x and 6
        }
        catch (e) { }
    }
}

function getAlertCount()
{
	document.getElementById("alertTotal").innerHTML = <%=count%>;
}

function loadUserAlert()
{
	window.parent.loadUserAlert();
}

function traverse(direction)
{
	var alertList = window.parent.getAlertList();
	var alertId;
	
	if(direction == "next"){
		for(var i=0; i < alertList.length; i++)
		{
			if(alertList[i] != null && alertList[i].count == window.parent.currIndex)
			{
				//currIndex = alertList[i].count;
				if(alertList[i+1] != null)
				{
					alertId = alertList[i+1].alertId;
					window.parent.currIndex = alertList[i+1].count;
				}
				
				break;
			}
		}
	}
	if(direction == "previous"){
		for(var i=0; i < alertList.length; i++)
		{
			if(alertList[i] != null && alertList[i].count == window.parent.currIndex)
			{
				//currIndex = alertList[i].count;
				if(alertList[i-1] != null)
				{
					alertId = alertList[i-1].alertId;
					window.parent.currIndex = alertList[i-1].count;
				}
				
				break;
			}
		}
	}
	
	if(typeof(alertId) != 'undefined')
	{
		currentAlertId = alertId; 
		window.parent.traverseDetails(alertId, <%=count%>);
	}
}

function selectTab(menucode, divcode)
{
	var divContent;
	var contentTable;

	var reviewContent = document.getElementById("review");
	var reviewCol = document.getElementById("reviewCol");
	var fwdContent = document.getElementById("forward");
	var fwdCol = document.getElementById("forwardCol");
	var flagContent = document.getElementById("flag");
	var flagCol = document.getElementById("flagCol");
	var btnSave = document.getElementById("btnSave");
	
	if(menucode == "forwardmenu" || menucode == "flagmenu"){
		loadXmlHttp();
	}
	
	if(menucode == "forwardmenu"){
		btnSave.innerHTML = "Send";
	}
	else{
		btnSave.innerHTML = "Save";
	}
	if(menucode == "reviewmenu")
	{
		divContent = document.getElementById(divcode);
		contentTable = document.getElementById("reviewCol");
		divContent.style.display = 'block';
		fwdContent.style.display = 'none';
		flagContent.style.display = 'none';
		contentTable.className = "TabMenucurrentbg";
		fwdCol.className = null;
		flagCol.className = null;
		selectedTab = "review";
	}
	else if(menucode == "forwardmenu")
	{
		divContent = document.getElementById(divcode);
		contentTable = document.getElementById("forwardCol");
		divContent.style.display = 'block';
		reviewContent.style.display = 'none';
		flagContent.style.display = 'none';
		contentTable.className = "TabMenucurrentbg";
		reviewCol.className = null;
		flagCol.className = null;
		selectedTab = "forward";
		
		forwardUsers();
	}
	else if(menucode == "flagmenu")
	{
		var flagCheck = document.getElementById("checkbox");
		divContent = document.getElementById(divcode);
		contentTable = document.getElementById("flagCol");
		divContent.style.display = 'block';
		reviewContent.style.display = 'none';
		fwdContent.style.display = 'none';
		contentTable.className = "TabMenucurrentbg";
		reviewCol.className = null;
		fwdCol.className = null;
		selectedTab = "flag";
		
		if(flagCheck.checked){
			flagChecked();
		}
	}
}

function save(divObj){
	//divObj.onclick = null;
	if(currentAlertId == null && typeof(currentAlertId) == 'undefined'){
		currentAlertId = window.parent.currentAlertId;
	}
	if(selectedTab == null && typeof(selectedTab) == 'undefined'){
		selectedTab = "review";
	}
	if((currentAlertId != null && typeof(currentAlertId) != 'undefined') 
			&& selectedTab != null && typeof(selectedTab) != 'undefined'){
	
		if(selectedTab == "forward"){
			if(forwardUsersList != 'undefined' && forwardUsersList != null){
				document.getElementById("alertForwardListhdn").value = JSON.stringify(forwardUsersList);
			}
		}
		document.getElementById("alertPatientRecipientIdhdn").value = <%=patientRecipientSeqId%>;
		document.getElementById("alertIdhdn").value = currentAlertId;
		document.getElementById("alertTabhdn").value = selectedTab;
		document.getElementById("alertTotcnthdn").value = <%=count%>;
		document.getElementById("alertdetailfrm").submit();
	}
}

function archiveAlert(){
	
	if(currentAlertId == null && typeof(currentAlertId) == 'undefined'){
		currentAlertId = window.parent.currentAlertId;
	}
	
	if(currentAlertId != null && typeof(currentAlertId) != 'undefined'){
		
		var res = null;
		loadXmlHttp();

		if(xmlHttp){
			xmlHttp.open("post", "AlertArchiveServlet", true);

			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					res = xmlHttp.responseText;
					
					if(res){
						loadUserAlert();
					}
				}
			}
			
			xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			
			xmlHttp.send("alertId=" + currentAlertId);
		}
	}
}

function flagChecked(){
	var flagCheck = document.getElementById("checkbox");
	var flagCombo = document.getElementById("select");
	if(flagCheck.checked){
		flagged = flagCheck.checked;
		if(xmlHttp){
			xmlHttp.open("post", "AlertFlagOptionServlet", true);
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					res = xmlHttp.responseText;

					if(res){
						//var jsonList = JSON.parse(res.alertFlagOptionList);
						var jsonString = JSON.parse(res);
						var objOption = document.createElement("option");

						for(var i=0;i<jsonString.alertFlagOptionList.length;i++){
							objOption.text = jsonString.alertFlagOptionList[i].timeIntervalDesc;
						    objOption.value = jsonString.alertFlagOptionList[i].timeIntervalCode;
						    flagCombo.options[flagCombo.options.length] = new Option(objOption.text, objOption.value);
						} 
					}
				}
			}
			
			xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			xmlHttp.send();
		}
	}
	else{
		flagCombo.innerHTML = "";
		flagCombo.options[flagCombo.options.length] = new Option("-------------  Select ------------", null);
		//flagCombo.innerHTML = "<option>-------------  Select ------------</option>";
		/* var length = flagCombo.options.length;
		for(i = 0; i < length; i++){
			flagCombo.options[i] = null
		} */
	}
}

function forwardUsers(){
	var fwdCombo = document.getElementById("fwdselect");
	if(xmlHttp){
		xmlHttp.open("post", "AlertForwardUserServlet", true);
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				res = xmlHttp.responseText;

				if(res){
					//var jsonList = JSON.parse(res.alertFlagOptionList);
					var jsonString = JSON.parse(res);
					var objOption = document.createElement("option");

					/* for(var i=0;i<jsonString.forwardUserList.length;i++){
						objOption.text = jsonString.forwardUserList[i].userId;
					    objOption.value = jsonString.forwardUserList[i].userName;
					    fwdCombo.options[fwdCombo.options.length] = new Option(objOption.text, objOption.value);
					}  */
					var fwdMultiselect = $("#fwdselect").data("kendoMultiSelect");
					fwdMultiselect.setDataSource(jsonString.forwardUserList);
				}
			}
		}
		
		xmlHttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlHttp.send();
	}
}

function timeSelected(sel){
	flagTime = sel.options[sel.selectedIndex].value;
}
</script>
</head>

<body onload="getAlertCount()">


<form id="alertdetailfrm" name="alertdetailfrm" id="alertdetailfrm" method="post" action="AlertManageServlet">
<input type = "hidden" name = "alertIdhdn" id = "alertIdhdn"  />
<input type = "hidden" name = "alertTabhdn" id = "alertTabhdn"  />
<input type = "hidden" name = "alertTotcnthdn" id = "alertTotcnthdn"  />
<input type = "hidden" name = "alertForwardListhdn" id = "alertForwardListhdn"  />
<input type = "hidden" name = "alertPatientRecipientIdhdn" id = "alertPatientRecipientIdhdn"  />
<table cellpadding="0" cellspacing="0" class="container">
  <!-- HEADER START -->
<tr>
    <td align="left" valign="middle" class="Titlebg">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="14%" align="left" valign="top">
               <div class="Title">
                Alert
              </div>
            </td>
            <td width="86%" align="left" valign="top">
                <div class="TitleBTN" id="alertTotal">
                
              </div>
            </td>
       
          </tr>
        </table>

    </td>
</tr>
    <!-- HEADER END -->
    
    <!-- Alert Details START -->
<tr>
    <td align="left" valign="top"  class="AlertView"><table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td width="52%" align="left" valign="middle">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="12%" align="center" valign="top" >
            <% if(alertPriority.equalsIgnoreCase("1")) {%>
		    	<img src="eAlert/images/Priority_l.PNG" width="15" height="15" />
		    <%} %>
		    <% if(alertPriority.equalsIgnoreCase("2")) {%>
		    	<img src="eAlert/images/Priority_ll.PNG" width="15" height="15" />
		    <%} %>
		    <% if(alertPriority.equalsIgnoreCase("3")) {%>
		    	<img src="eAlert/images/Priority_lll.PNG" width="15" height="15" />
		    <%} %>
            </td>
            <td width="88%" align="left" valign="top"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><div class="AlertTitlein"> <%=alertName %> </div></td>
              </tr>
              <tr>
                <td align="left" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <% if(sForwarded.equalsIgnoreCase("Y")){ %>
		            	<td width="4%" align="left" valign="middle"><img src="eAlert/images/Send.png" width="10" height="10" /></td>
		            <%} 
		          	else if(sReceived.equalsIgnoreCase("Y")){ %>
		            	<td width="4%" align="left" valign="middle"><img src="eAlert/images/Recived.png" width="10" height="10" /></td>
		            <%}
		          	else if(sReviewed.equalsIgnoreCase("Y")){ %>
		      			<td width="8%" align="left" valign="middle"><img src="eAlert/images/ReviewedS.png" width="10" height="10" /></td>
		      		<%}
		            else {
		            %>
		            <td width="4%" align="left" valign="middle"><img src="eAlert/images/Send_Dis.png" width="10" height="10" /></td>
		            <%} %>
                    <td width="96%" align="left" valign="middle"><span class="normaltxt"><%=dateTimeDisplay %></span></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <!-- <td width="8%" align="center" valign="middle"><div class="FlagBTN">
          <div class="flag"></div>
        </div></td> -->
        <td width="5%" align="left" valign="middle">  
          <%if(sFlagged.equalsIgnoreCase("Y")) { %>
          	<div class="flag"><img src="eAlert/images/Flag.png" width="16" height="16" /></div>
          <%}else {%>
          	<div class="flagDis"><img src="eAlert/images/Flag_Dis.png" width="16" height="16" /></div>
          <%} %>
           
         </td>
        <td width="5%" align="center" valign="middle">
        <div class="FlagBTN">
          <div class="arc" onclick="archiveAlert()"></div>
        </div>
        </td>
        
        <td width="5%" align="center" valign="middle"><div class="FlagBTN">
          <div class="prev" onclick="traverse('previous')"></div>
        </div></td>
        <td width="5%" align="center" valign="middle"><div class="FlagBTN">
          <div class="next" onclick="traverse('next')"></div>
        </div></td>
        <td width="5%" align="center" valign="middle"><div class="FlagBTN">
          <div class="close" onclick="loadUserAlert()"></div>
        </div></td>
      </tr>
    </table></td>
</tr>
  <!--  Alert Details END -->

<!-- info window -->
<% if (sReceived.equalsIgnoreCase("Y")){%>
<tr>
<td align="left" valign="top">
<div class="infowindow">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="9%" height="39" align="center" valign="middle">&nbsp;</td>
      <td width="91%" align="left" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          <div class="infowindowheader">
          <span>Received on </span><span><%=modifiedDate %></span><span> from </span><span><%=receivedUserID %></span> 
          </div>
          </td>
        </tr>
        <tr>
          <td>
           <div class="infowindowsubheader">
			<%=sComments %>
          </div>
          </td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
</td>
</tr>
<%} 

else if(sReviewed.equalsIgnoreCase("Y") || sForwarded.equalsIgnoreCase("Y")){%>
  <tr>
<td align="left" valign="top">
<div class="infowindow">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="100%" height="39" align="left" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <%if (sReviewed.equalsIgnoreCase("Y")){ %>
        <tr>
          <td><div class="infowindowheader"> <span>Reviewed on </span> <%=modifiedDate %> </div></td>
        </tr>
        <%}
      else if(sForwarded.equalsIgnoreCase("Y")){%>
      	<tr>
      	<!-- TODO loop through the collection of user ids to which the alert has been forwarded and give the comma separated values -->
          <td><div class="infowindowheader"> <span>Forwarded on </span> <span> <%=modifiedDate %> </span> <span> to </span> <span> <%=forwardedUserNames %> </span> </div></td>
        </tr>
      <%} %>
        <tr>
          <td><div class="infowindowsubheader"> <%=sComments %> </div></td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
</td>
</tr>
<%} %>
 
 <!-- info window -->
  
  <!-- RESULT START -->
    
    <tr>
<td align="left" valign="top">
<%if(sReviewed.equalsIgnoreCase("Y") || sForwarded.equalsIgnoreCase("Y")){%>
<div class="alertcontainerview02">
<%}
else if (sReceived.equalsIgnoreCase("Y")){%>
<div class="alertcontainerview01">
<%} 
else { %>
<div class="alertcontainerview">
<%} %>
  <p class="alertcontent"> <%=patientName %>, IP Ward, Room No.2, Bed No.2<br />
    <%=alertDescription %><br />
    <%
    String[] arrDetails = details.split("~,");
    for(String detail : arrDetails)
    {%>
    	<%=detail %><br/>
    <%} %></p>
 
 </div></td>
    </tr>
    
  <!-- RESULT END -->
<%if(sReviewed.equalsIgnoreCase("Y") || sForwarded.equalsIgnoreCase("Y")){%> 
	<tr style="display:none">
<%} 
else {%>
	<tr>
<%} %>
<td align="left" valign="top" class="TabCont">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="TabMenubg">
    <td align="left" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td id="reviewCol" width="110" height="34" align="center" valign="middle" class="TabMenucurrentbg"><div class="Tabmenu" onclick="selectTab('reviewmenu', 'review')"> Review </div></td>
        <td width="2" height="34" align="center" valign="middle" class="tabsep">&nbsp;</td>
        <td id="flagCol" width="106" height="34" align="center" valign="middle"><div class="Tabmenu" onclick="selectTab('flagmenu', 'flag')"> Set Flag </div></td>
        <td width="2" height="34" align="center" valign="middle" class="tabsep">&nbsp;</td>
        <td id="forwardCol" width="110" height="34" align="center" valign="middle"><div class="Tabmenu" onclick="selectTab('forwardmenu', 'forward')"> Forward  to </div></td>
        <!-- <td width="22%" height="34" align="center" valign="middle"><div class="Tabmenu"> Archive </div></td> -->
      </tr>
    </table>
    
    
    
    </td>
  </tr>
  
  <tr>
    <td id="review" align="left" valign="top" height="85" style="display:block;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" class="normaltxt">Comment</td>
      </tr>
      <tr>
        <td align="left" valign="top" class="normaltxt"><textarea name="rvwtextarea" id="rvwtextarea" cols="35" rows="4"></textarea></td>
      </tr>
      <tr>
        <td align="left" valign="top">
        
        
        </td>
      </tr>
    </table></td>
    
    <td id="forward" align="left" valign="top" height="85" style="display:none;"><table width="100%" border="0" cellspacing="0" cellpadding="3">
      <tr>
        <td align="left" valign="top" class="normaltxt">Forward to</td>
      </tr>
      <tr>
        <td align="left" valign="top" class="normaltxt"><div style="width:90%; align:center">
    	<select multiple="multiple" name="fwdselect" id="fwdselect" id="fwdselect"  >
          <option>-------------  Select ------------</option>

        </select>
   		</div></td>
      </tr>
      <tr>
        <td align="left" valign="top" class="normaltxt"><textarea name="fwdtextarea" id="fwdtextarea" cols="30" rows="1"></textarea></td>
      </tr>
      <tr>
        <td align="left" valign="top"></td>
      </tr>
    </table></td>
    
    <td id="flag" align="left" valign="top" height="85" style="display:none;"><table width="100%" border="0" cellspacing="0" cellpadding="3">
      <tr>
        <td align="left" valign="top" class="normaltxt">
        <%if(sFlagged.equalsIgnoreCase("Y")) { %>
        	<input type="checkbox" name="checkbox" id="checkbox" id="checkbox" checked = "checked" onclick="flagChecked()"/>
        <%} 
        else{ %>
        	<input type="checkbox" name="checkbox" id="checkbox" id="checkbox" onclick="flagChecked()"/>
        <%} %>
		Set Flag </td>
      </tr>
      <tr>
        <td align="left" valign="top" class="normaltxt">Remind After</td>
      </tr>
      <tr>
        <td align="left" valign="top" class="normaltxt"><select name="select" id="select" id="select" onchange="timeSelected(this)">
          <option>-------------  Select ------------</option>
        </select></td>
      </tr>
      <tr>
        <td align="left" valign="top">
        
        
        </td>
      </tr>
    </table></td>
    
    
  </tr>
   
    <tr>
    <td align="right" valign="top">
    <div id="btnSave" class="btn" onclick="save(this)">
    	Save
    </div>
    </td>
  </tr>
</table>
</td>
</tr>
  
</table>
</form>
</body>
</html>

