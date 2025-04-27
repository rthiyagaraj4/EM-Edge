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
AlertsByGroupResponse alertGroupByResponse = null;
List<AlertsByGroup> alertGroupList = null;
List<AlertsByUser> userAlertList = null;
int alertCount = 0;
int icount = 0;
int icountHeader = 0;
String header = "";
String count = "";
String sFlagged = "";
String sReceived = "";
String sReviewed = "";
String sForwarded = "";
String sAcknowledged = "";
String alertPriority = "";
int reminderInt = 0;
String intervalDisplay = "";
String groupText = "";
String filter = "";
String filterClass = "";

if(request.getAttribute("AlertGroupByResponse") != null){
	alertGroupByResponse = (AlertsByGroupResponse)request.getAttribute("AlertGroupByResponse");
	
	if(alertGroupByResponse != null)
	{
		groupText = alertGroupByResponse.getGroupText();
		filter = alertGroupByResponse.getFiltered();
		if(filter.equalsIgnoreCase("Y"))
			filterClass = "FlagONBTN";
		else
			filterClass = "FlagBTN";
		alertCount = alertGroupByResponse.getCountResponse().getAlertCount();
		alertGroupList = alertGroupByResponse.getAlertGroupList();
		/* if(alertGroupList != null && alertGroupList.size() > 0)
		{
			
		} */
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

function toggleGroup(obj, count)
{
	var id = "groupChild" + count;
	var groupChildDiv = document.getElementById(id);
	var subGroupIconId = "subgroupicon" + count;
	var subgroupIcon = document.getElementById(subGroupIconId);
	if(groupChildDiv.style.display == 'block'){
		groupChildDiv.style.display = 'none';
		subgroupIcon.src = "eAlert/images/Down_arrow.png";
	}
	else{
		groupChildDiv.style.display = 'block';
		subgroupIcon.src = "eAlert/images/Up_Arrow.png";
	}
}

function groupFilterList()
{
	var filterDiv = document.getElementById("groupfilterbutton");

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

</script>
</head>
<body>
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
                <%= alertCount%>
              </div>
            </td>
            <td width="67%" align="right" valign="middle">
              <div class="<%=filterClass %>" id="groupfilterbutton">
             	<div class="flag" onclick="groupFilterList()">
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
    <td width="92%" align="left" valign="middle" class="groupSelectedTxt">Group by :  <span id="groupbytext"><%=groupText %></span></td>
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
if(alertGroupList != null && alertGroupList.size() > 0){
for(AlertsByGroup userAlertGroupBy : alertGroupList){
	header = userAlertGroupBy.getHeader();
	userAlertList = userAlertGroupBy.getUserAlertList();%>
	
	<div class="groupHeader" id="groupHeader<%=icountHeader %>">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="94%" >
				<div>
				<span class="groupHeaderText"><%=header %> (<%= userAlertGroupBy.getGroupCount()%>)</span>
				</div>
				</td>
				<td width="5%" align="center" valign="middle" style="cursor:pointer;height:26px;">
				<img id="subgroupicon<%=icountHeader %>" src="eAlert/images/Up_Arrow.png" width="16" height="16" onclick="toggleGroup(this, <%=icountHeader %>)"/>
				<!-- include the image -->
				</td>
			</tr>
		</table>
	</div>
<div id="groupChild<%=icountHeader%>">	
<%	for(AlertsByUser userAlert : userAlertList)
	{
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
            <%-- <% if(sReviewed.equalsIgnoreCase("Y")){ %>
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
	icountHeader = icountHeader + 1;%>
	</div>
	<%}
}%>
</div>
    
    </td>
    </tr>
    
  <!-- RESULT END --> 
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

