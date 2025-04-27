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

<%@page import="eOT.Common.OTRepository"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, webbeans.eOT.StaffAssignmentBean" contentType="text/html;charset=UTF-8" %> 
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
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
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
	
function lockKey()
{
	 	 
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
}

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
	String assignmentFromDate = checkForNull(request.getParameter("assignmentFromDate"));
	String assignmentToDate = checkForNull(request.getParameter("assignmentToDate"));
	String operRoomCode = checkForNull(request.getParameter("operRoomCode"));
	String operRoomDesc = checkForNull(request.getParameter("operRoomDesc"));
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
<body>
	<form name="StaffAssignmentForm" id="StaffAssignmentForm" >
		<div class="main">
			<div class="actiontitle">
				<fmt:message key="eOT.ModifyStaffAssignment.Label" bundle="${ot_labels}"/>
			</div>
			<div class="tcontent" >
				<div class="inputflds"> 
					<span class="iptdate"><fmt:message key="eOT.fromDate.Label" bundle="${ot_labels}"/></span>
					<input type='text' name='assignmentFromDate' id='assignmentFromDate' maxlength='10' size='10'  class='txtbx' value='<%=assignmentFromDate %>' readOnly/>
					<span class="iptdate"><fmt:message key="eOT.toDate.Label" bundle="${ot_labels}"/></span>
					<input type='text' name='assignmentToDate' id='assignmentToDate' maxlength='10' size='10'  class='txtbx' value='<%=assignmentToDate %>' readOnly/>
					
					<span class="iptroom"><fmt:message key="eOT.SARoom.Label" bundle="${ot_labels}"/></span>
						<input type='text' name='operRoomDesc' id='operRoomDesc' maxlength='10' size='10'  class='txtbx' value='<%=operRoomDesc %>' readOnly/>
						
				</div>
			
			</div>	
		</div>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
			<input type='hidden' name='rowCount' id='rowCount' value='0' />
			<input type='hidden' name='mode' id='mode' value='modify' />
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

