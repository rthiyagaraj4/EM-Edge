<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
20/11/12      100         pparthasarathy  created
Acts as create and Modify screen for Payer Group Mapping screen
called on click of create button from common tool bar
on submission (apply) request will be submitted to BLPayerGroupServlet.java
-----------------------------------------------------------------------------------------------
-->

<%@page import="eOT.SlateBean"%>
<%@page import="eOT.Common.OTRepository"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eCommon.Common.*, webbeans.eOT.StaffAssignmentBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eOT/html/style.css' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eOT/js/StaffAssignment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var roleTypeArray;
var headTop = -1;
var FloatHead1;
function processScroll()
{
	if (headTop < 0)
	{
		saveHeadPos();
		
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function saveHeadPos()
{
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}
	
/*function lockKey()
{
	 	 
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
} */

 function lockbackSpace()
 {
// alert(document.order_type_form.mode.value);
   var mode = document.mode.value;
    // alert(window.event.keyCode);
 if(mode=='modify' && window.event.keyCode==8)
  {
         //return false;
  }
 }

<%
	String mode = checkForNull(request.getParameter("mode"));
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	
	int index = 0;
%>

	
</script>
</head>
<style>
		thead td, thead td.locked	{ 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server


String beanId = "ot_StaffAssignmentBean" ;
String beanName = "webbeans.eOT.StaffAssignmentBean";
List<String> condnList = new ArrayList<String>();


try  
{
	
	Map<String, String> otRoomMap = null;
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject(beanId, beanName, request) ;
	condnList.add(facilityId);
	condnList.add(locale);
	otRoomMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROOM_SELECT"), condnList);

	Map<String,String> roleMap = null;
	
	condnList = new ArrayList<String>();
	condnList.add(locale);
	roleMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROLE_SELECT"), condnList);
	
	
	SlateBean slateBean = (SlateBean)getBeanObject(  "SlateBean","eOT.SlateBean",  request  );
	String currentDate = slateBean.getSysDateTime();
%>	
<script>	
 roleTypeArray = [
<%	
	index = 0;
	for(String key : roleMap.keySet())
	{
%>	
		["<%=key %>" , "<%=roleMap.get(key) %>"] <%= index++ < (roleMap.keySet().size() -1) ? "," : "" %>
<%
		
	}
%>
];	
 
 </script>		
<body onKeyDown = 'lockKey()'>
	<form name="StaffAssignmentForm" id="StaffAssignmentForm" >
		<div class="main" style="width:99%; height:550px;">
			<div class="actiontitle">
				<fmt:message key="eOT.CreateStaffAssignment.Label" bundle="${ot_labels}"/>
			</div>
			<div class="tcontent" >
				<div class="inputflds"> 
					<span class="iptdate"><fmt:message key="eOT.SADate.Label" bundle="${ot_labels}"/></span>
					<input type='text' name='assignmentDate' id='assignmentDate' maxlength='10' size='10'  value='<%= currentDate %>' />
					<input type='image' id='assignmentDateImg' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('assignmentDate');" >
					<span class="iptroom"><fmt:message key="eOT.SARoom.Label" bundle="${ot_labels}"/></span>
					<select class="roomopt" name='operRoomCode' id='operRoomCode' multiple onblur='javascript:chkAllselect()'>
							<!--option value=''>Select</option-->
							<option value='ALL'>All</option>
							<%
									for(String key : otRoomMap.keySet())
									{
							%>		
									<option value='<%= key %>'><%= otRoomMap.get(key) %> </option>
							<%
									}
							%>		
					</select>
				</div>
				<div class="stfdet">
					<div class="floatleft" ><span class="stftitle"><fmt:message key="eOT.StaffDetails.Label" bundle="${ot_labels}"/></span> </div>
					<div class="floatright"><input class="oldbtn"  type="button" value="Add" onclick='javascript:addRow()'/></div>
				</div>
				<!--<div class="tablediv" style="width:100%; height:100%;  overflow: auto; " > -->
					<table  class="crstaffgrid"  border="0" cellspacing="0" id='AssignmentTimeTable' width="100%" >
						<th><fmt:message key="eOT.SARole.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.SAName.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.ShowInWidget.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.FromTime.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.ToTime.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.SAAction.Label" bundle="${ot_labels}"/></th>
						<tr>
							<td class="alignimgtext">
							<select class="brdclr" name='roleType_1' id='roleType_1'>
								
							</select>
							</td>
							<td class="alignimgtext">
								<input type='hidden' name='practitionerId_1' id='practitionerId_1' >
								<input type='text' name='practitionerName_1' id='practitionerName_1'  size='20' onblur="if(this.value!='')searchDoctor(roleType_1, practitionerId_1,practitionerName_1, 1); else practitionerId_1.value='';" > 
								<input type='button' class='button' value='?' name='DoctorLookUp_1' id='DoctorLookUp_1' onClick='searchDoctor(roleType_1,practitionerId_1,practitionerName_1, 1);'  > 
								<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td >
								<input class="brdclr"class="brdclr" type="checkbox" name='showWidgetYN_1' id='showWidgetYN_1' value='Y'/>
							</td>
							<td class="alignimgtext">
								<input class="brdclr"class="brdclr" type="text" name='fromTime_1' id='fromTime_1' size='5' onblur='javascript:checkTimeFormat(this)'/>
							</td>
							<td class="alignimgtext">
								<input class="brdclr"class="brdclr" type="text" name='toTime_1' id='toTime_1' size='5' onblur='javascript:checkTimeFormat(this)'/>
							</td>
							<td>
								
							</td>
						</tr>
						<script>
						populateAndSetCombo('', 1);
						</script>
					</table>
<!--			</div>-->
			</div>	
		</div>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
			<input type='hidden' name='rowCount' id='rowCount' value='0' />
			<input type='hidden' name='mode' id='mode' value='insert' />
	</form>	

<%
	//putObjectInBean(beanId,payerGroupBean,request);
%>	
	
	
</body>
<%
}
catch(Exception e)
{
	System.out.println("Exception in StaffAssignmentAdd.jsp::"+e.toString());
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

