<!DOCTYPE html>
 

<%@page import="webbeans.eOT.StaffAssignmentAuditTrailBean"%>
<%@page import="eOT.Common.OTRepository"%>
<%@ page import="java.sql.*,java.util.*,eCommon.Common.*, webbeans.eOT.StaffAssignmentBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
	<title>
			Audit History
	</title>
<link rel='StyleSheet' href='../../eOT/html/style.css' type="text/css" media="screen, projection"/>
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
	Properties p = (Properties) session.getValue( "jdbc" ) ;
	
	int index = 0;
%>

	
</script>
</head>

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
	Map <Integer,List<StaffAssignmentAuditTrailBean>> auditTrailMap = null;
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject(beanId, beanName, request) ;
	condnList.add(facilityId);
	condnList.add(locale);
	otRoomMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROOM_SELECT"), condnList);
	otRoomMap.put("ALL","All");

	auditTrailMap = staffAssignmentBean.fetchAuditTrailDetails(assignmentFromDate, assignmentToDate, operRoomCode, facilityId, locale, p);
%>	
	
<body>
	<form name="StaffAssignmentForm" id="StaffAssignmentForm" >
		<div class="main" style="width:99%; height:600px; overflow: auto; ">

			<div class="tcontent" >

				<div class="stfdet">
					<div class="floatleft" ><span class="audittitle"><fmt:message key="eOT.AuditHistory.Label" bundle="${ot_labels}"/></span> </div>
					<!-- <div class="floatright"><div class="oldbtnclose" align='right' onclick='javascript:window.close();'>X</div></div> -->
				</div>
				<div class="tablediv" > 
					<table  class="popupgrid" cellspacing="0">
						<th><span class="audittitle"><fmt:message key="eOT.SAOld.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.SANew.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.ActionDateTime.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.SAUser.Label" bundle="${ot_labels}"/></th>
					<%
						for(Integer staffAssignmentId : auditTrailMap.keySet())
						{
								
							List<StaffAssignmentAuditTrailBean> auditList = auditTrailMap.get(staffAssignmentId);
							
							for(StaffAssignmentAuditTrailBean auditBean : auditList)
							{
					%>	
								<tr>
									<td  class="alerttext">
										<div class="contentbold"><%= otRoomMap.get(auditBean.getOperRoomCode()) %></div>
										<div class="contentbold"><span><%= auditBean.getStaffName() %>, </span><span><%= auditBean.getRoleDesc() %>,</span></div>
										<div ><span><%=auditBean.getAssignmentDate() %> <%=auditBean.getFromTime() %> Hrs</span><span> to </span><span><%=auditBean.getToTime() %> hrs</span></div>
										
									</td>
									<td  class="alerttext">
									<%
										if(auditBean.getNewFromTime() != null)
										{
									%>
										<div class="contentbold"><%= otRoomMap.get(auditBean.getOperRoomCode()) %></div>
										<div class="contentbold"><span><%= auditBean.getStaffName() %>, </span><span><%= auditBean.getRoleDesc() %>,</span></div>
										<div ><span><%=auditBean.getAssignmentDate() %> <%=auditBean.getNewFromTime() %> Hrs</span><span> to </span><span><%= auditBean.getNewToTime() %> hrs</span></div>
									<%
										}
										else
										{
									%>	
										<div class="contentbold">Record Deleted</div>
									<%
										}
									%>
									</td>
									<td>
										<div class="contentbold" ><span><%=auditBean.getModifiedDate() %></span></div>
									</td>
									<td>
										<div class="contentbold" ><span><%=auditBean.getModifiedBy() %></span></div>
									</td>
								</tr>
					<%
							}
						}
					%>	
					</table>
				</div>
			</div>
		</div>
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

