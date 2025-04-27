<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eAlert.src.config.AlertConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page import = "java.util.*" %>
 <%@ page import = "eAlert.src.alert.response.*" %>
 <%@ page import = "eAlert.src.config.*" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
AlertsByFilterResponse alertFilterResponse = null;
List<AlertsByUser> userAlertList = null;
int headerCount = 0;
int alertCount = 0;
int icount = 0;
String count = "";
String sFlagged = "";
String sReceived = "";
String sReviewed = "";
String sForwarded = "";
String sAcknowledged = "";
String alertPriority = "";
int reminderInt = 0;
String intervalDisplay = "";
String filter = "";
String filterClass = "";

if(request.getAttribute("AlertsByFilterResponse") != null){
	alertFilterResponse = (AlertsByFilterResponse)request.getAttribute("AlertsByFilterResponse");
	
	if(alertFilterResponse != null)
	{
		userAlertList = alertFilterResponse.getUserAlertList();
		headerCount = alertFilterResponse.getCountResponse().getAlertCount();
		filter = alertFilterResponse.getFiltered();
		if(filter.equalsIgnoreCase("Y"))
			filterClass = "FlagONBTN";
		else
			filterClass = "FlagBTN";
		if(userAlertList != null && userAlertList.size() > 0)
		{
			alertCount = userAlertList.size();
		}
	}
	
	/* if(alertCount < 10){ 
		count = "0" + alertCount;
	}
	else{
		count = alertCount;
	} */
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alert</title>
<link href="eAlert/css/Style.css" rel="stylesheet" type="text/css" />

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

noty
<script type="text/javascript" src="eCommon/js/noty/jquery.noty.js"></script>

layouts
<script type="text/javascript" src="eCommon/js/noty/layouts/bottom.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/bottomCenter.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/bottomLeft.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/bottomRight.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/center.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/centerLeft.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/centerRight.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/inline.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/top.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/topCenter.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/topLeft.js"></script>
<script type="text/javascript" src="eCommon/js/noty/layouts/topRight.js"></script>

themes
<script type="text/javascript" src="eCommon/js/noty/themes/default.js"></script> -->

<script language="javascript">
var isFiltered;
window.parent.clearAlertList();

function showAlertDetail(count, alertId)
{
	window.parent.displayAlertDetails(count, alertId);
}

function showGroupDropDown(id)
{
	var groupdiv = document.getElementById(id);
	var groupby = document.getElementById('groupby');
	var title = document.getElementById('title');
	var groupIcon = document.getElementById("groupicon");
	if(groupdiv.style.display == 'block'){
		groupdiv.style.display = 'none';
		groupIcon.src = "eAlert/images/DownArrow.png";
	}
	else
	{
		groupdiv.style.display = 'block';
		groupdiv.style.zIndex = '1000';
		groupdiv.style.position = 'absolute';
		groupdiv.style.top = groupby.offsetHeight + title.offsetHeight + 1;
		groupIcon.src = "eAlert/images/UpArrow.png";
	}
}

function highlight(obj)
{
	obj.className = "groupSelectState";
}

function normal(obj)
{
	obj.className = "groupNormalItem";
}

function setGroupBy(id, grouptext, code)
{
	var spantext = document.getElementById("groupbytext");
	var groupdiv = document.getElementById(id);
	groupdiv.style.display = 'none';
	if(grouptext == null && grouptext == "undefined")
		spantext.innerHTML = "None";
	else
		spantext.innerHTML = grouptext;
	window.parent.setGroupBy(code, grouptext);
}

function filterList()
{
	var filterDiv = document.getElementById("filterbutton");
	
	<%if(filter.equalsIgnoreCase("Y"))
	{%>
		isFiltered = true;
	<%}%>
	if(isFiltered == 'undefined' || isFiltered == null)
		isFiltered = false;
	
	if(isFiltered == false)
		isFiltered = true;
	else
		isFiltered = false;
	
	if(isFiltered == true){
		filterDiv.className = "FlagONBTN";
	}
	else if(isFiltered == false){
		filterDiv.className = "FlagBTN";
	}
	window.parent.filterUserList(isFiltered);
}

function loadFilterList()
{
	var filterDiv = document.getElementById("filterbutton");
	filterDiv.className = "FlagONBTN";
}

/* function LaunchNotification(){
	var n = $('div#notificaton').noty({
  		text: 'alert',
  		type: 'alert',
      dismissQueue: true,
  		layout: 'bottom',
  		theme: 'defaultTheme',
  			 animation: {
  		        open: {height: 'toggle'},
  		        close: {height: 'toggle'},
  		        easing: 'swing',
  		        speed: 500 // opening & closing animation speed
  		    },
  		    timeout: false, // delay for closing event. Set false for sticky notifications
  		    force: false, // adds notification to the beginning of queue when set to true
  		    modal: false
  	});
} */
</script>
</head>
<body onload="loadFilterList()">
<table cellpadding="0" cellspacing="0" class="container">
  <!-- HEADER START -->
<tr>
    <td align="left" valign="middle" class="Titlebg" id="title">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="16%" align="left" valign="top">
               <div class="Title">
                Alert
              </div>
            </td>
            <td width="17%" align="left" valign="top">
                <div class="TitleBTN">
                <%= headerCount%>
              </div>
            </td>
            <td width="67%" align="right" valign="middle">
             <div class="<%=filterClass %>" id="filterbutton">
             	<div class="flag" onclick="filterList()">
                </div>              
             </div>
            
            </td>
          </tr>
        </table>

    </td>
</tr>
    <!-- HEADER END -->
    
    <!-- FILTER START -->
<tr>
    <td align="left" valign="middle"  class="group" id="groupby">
    	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr onclick="showGroupDropDown('groupbylist')" style="cursor:pointer;">
    <td width="92%" align="left" valign="middle" class="groupSelectedTxt">Group by :  <span id="groupbytext">None</span></td>
    <td width="8%" align="left" valign="middle"  style="cursor:pointer;">
    <div style="width:15px;">
    <img id="groupicon" src="eAlert/images/DownArrow.png"  width="10" height="10"/>
    </div>
    </td>
  </tr>
  
</table>

    
    </td>
</tr>
  <!-- FILTER END -->
  
  <!-- RESULT START -->
    
    <tr>
<td align="left" valign="top">
<div class="alertcontainer">
<%
if(userAlertList != null && userAlertList.size() > 0){
for(AlertsByUser userAlert : userAlertList){
	
	sFlagged = userAlert.getFlagged();
	sReceived = userAlert.getReceived();
	sReviewed = userAlert.getReviewed();
	sForwarded = userAlert.getForwarded();
	sAcknowledged = userAlert.getAlertAck();
	alertPriority = userAlert.getAlertPriority();
	reminderInt = userAlert.getReminderInterval();
	intervalDisplay = userAlert.getIntervalDisplay();
%> 
<!-- Temporary fix for alert count for details page. Need to fix -->   
<div class="AlertRow01" style="cursor:pointer;" onclick="showAlertDetail(<%=alertCount %>, <%=userAlert.getPatientAlertSeqId() %>)">

<table width="auto" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="8%" align="center" valign="top" class="Alertindicator">
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
    <td width="91%" align="left" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td>
        <div class="AlertTitle">
        <%=userAlert.getAlertName() %> 
        </div>
        </td>
        
      </tr>
      <tr>
        <td>
        <div class="DetailRow01">
        <span class="HighlightTxt"><%=userAlert.getPatientName() %></span> <span class="normaltxt">A34 Ward, Room No.4, Bed No.5</span></div>
        </td>
      </tr>
      <tr>
        <td>
        <div class="DetailRow02">
        <% if(sForwarded.equalsIgnoreCase("Y")) {%>
        	<span class="normaltxt"><%=AlertConstants.FORWARDED_TEXT %></span> <span class="HighlightTxt"><%=userAlert.getForwardedUserId() %></span>
        <% }
        if(sReceived.equalsIgnoreCase("Y") && sReviewed.equalsIgnoreCase("N") && sFlagged.equalsIgnoreCase("N")){ %>
        	<span class="normaltxt"><%=AlertConstants.RECEIVED_TEXT %></span> <span class="HighlightTxt"><%=userAlert.getRecFromUser() %></span>
        <%} 
        if(sReviewed.equalsIgnoreCase("Y")){ %>
        	<span class="normaltxt"><%=AlertConstants.REVIEWED_TEXT %></span> <span class="HighlightTxt"><%=userAlert.getModifiedDate() %></span>
        <%}
        if(sFlagged.equalsIgnoreCase("Y") && sReviewed.equalsIgnoreCase("N")) {
        	if(reminderInt > 0){ %>
        	<%-- <span class="normaltxt"><%=AlertConstants.FLAGGED_TEXT %></span> <span class="HighlightTxt"><%=reminderInt %></span> --%>
        	<span class="normaltxt"><%=AlertConstants.FLAGGED_TEXT %></span> <span class="HighlightTxt"><%=intervalDisplay %></span>
        <%	}
        	if(reminderInt == 0){ %>
        	<%-- <span class="normaltxt"><%=AlertConstants.FLAGGED_TEXT %></span> <span class="HighlightTxt"><%=AlertConstants.FLAGGED_REMINDER_NOTSET %></span> --%>
        	<span class="normaltxt"><%=AlertConstants.FLAGGED_TEXT %></span> <span class="HighlightTxt"><%=AlertConstants.FLAGGED_REMINDER_NOTSET %></span>
        <%	}
        }
        if(sForwarded.equalsIgnoreCase("N") && sReceived.equalsIgnoreCase("N") && sReviewed.equalsIgnoreCase("N") && sFlagged.equalsIgnoreCase("N") && sAcknowledged.equalsIgnoreCase("Y")){%>
        	<span class="normaltxt"><%=userAlert.getStandardText() %></span>
        <%}
        if(sForwarded.equalsIgnoreCase("N") && sReceived.equalsIgnoreCase("N") && sReviewed.equalsIgnoreCase("N") && sFlagged.equalsIgnoreCase("N") && sAcknowledged.equalsIgnoreCase("N")){%>
        	<span class="UnAcktxt"><%=userAlert.getStandardText() %></span>
       	<%} %>
        
        </div>
        </td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
          <% if(sForwarded.equalsIgnoreCase("Y")){ %>
            	<td width="6%" align="left" valign="middle"><img src="eAlert/images/Send.png" width="10" height="10" /></td>
            <%} 
          	else if(sReceived.equalsIgnoreCase("Y")){ %>
            	<td width="6%" align="left" valign="middle"><img src="eAlert/images/Recived.png" width="10" height="10" /></td>
            <%}
          	else if(sReviewed.equalsIgnoreCase("Y")){ %>
      			<td width="6%" align="left" valign="middle"><img src="eAlert/images/ReviewedS.png" width="10" height="10" /></td>
      		<%}
            else {
            %>
            <td width="6%" align="left" valign="middle"><img src="eAlert/images/Send_Dis.png" width="10" height="10" /></td>
            <%} %>
            <td width="84%" align="left" valign="middle">
            <span class="normaltxt"><%=userAlert.getDateTimeDisplay() %></span>
            </td>
            <% if(sFlagged.equalsIgnoreCase("Y")) {%>
            	<td width="6%" align="right" valign="middle"><img src="eAlert/images/Flag.png" width="16" height="16" /></td>
            <%}
            else{
            %>
            	<td width="6%" align="right" valign="middle"><img src="eAlert/images/Flag_Dis.png" width="16" height="16" /></td>
            <%} %>
           <%--  <% if(sReviewed.equalsIgnoreCase("Y")){ %>
            	<td width="8%" align="right" valign="middle"><img src="eAlert/images/Reviewed.png" width="16" height="16" /></td>
            <%}
            else {
            %>
            	<td width="8%" align="right" valign="middle"><img src="eAlert/images/Reviewed_dis.png" width="16" height="16" /></td>
            <%} %> --%>
            <td width="4%" align="right" valign="middle">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

</div>
<script language="javascript">
<%-- var alertObject<%=icount %> = new Object();
alertObject<%=icount %>.count = <%=icount%>;
alertObject<%=icount %>.alertId = <%=userAlert.getPatientAlertSeqId()%>;
window.parent.setAlertList(alertObject<%=icount %>); --%>
var alertObject = new Object();
alertObject.count = <%=icount%>;
alertObject.alertId = <%=userAlert.getPatientAlertSeqId()%>;
window.parent.setAlertList(alertObject);
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% icount = icount + 1;
}
}%>
</div>
    
    </td>
    </tr>
    
  <!-- RESULT END --> 
  <!-- <table>
  	<tr>
  		<div id="notificaton" style="width:auto;height:40px"></div>
  		<script>
  		LaunchNotification();
  		</script>
  	</tr>
  </table> -->
</table>

<div id="groupbylist" style="display:none;" class="group">
  	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
	   	<tr>
			<td width="100%" align="left" valign="middle" class="groupNormalItem" OnMouseOver="highlight(this)" OnMouseOut="normal(this)" onclick="setGroupBy('groupbylist', 'None', 'NONE')">None</td>
		</tr>
		<tr>
			<td width="100%" align="left" valign="middle" class="groupNormalItem" OnMouseOver="highlight(this)" OnMouseOut="normal(this)" onclick="setGroupBy('groupbylist', 'Patient Name', 'PATNAME')">Patient Name</td>
		</tr>
		<tr>
			<td width="100%" align="left" valign="middle" class="groupNormalItem" OnMouseOver="highlight(this)" OnMouseOut="normal(this)" onclick="setGroupBy('groupbylist', 'Date', 'DATE')">Date</td>
		</tr>
		<tr>
			<td width="100%" align="left" valign="middle" class="groupNormalItem" OnMouseOver="highlight(this)" OnMouseOut="normal(this)" onclick="setGroupBy('groupbylist', 'Alert Name', 'ALERTNAME')">Alert Name</td>
		</tr>
		<tr>
			<td width="100%" align="left" valign="middle" class="groupNormalItem" OnMouseOver="highlight(this)" OnMouseOut="normal(this)" onclick="setGroupBy('groupbylist', 'Fwd / Re', 'FWDRE')">Fwd / Re</td>
		</tr>
	</table>
</div>

</body>
</html>

