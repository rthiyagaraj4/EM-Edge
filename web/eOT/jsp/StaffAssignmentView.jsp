<!DOCTYPE html>


<%@page import="webbeans.eOT.StaffAssignmentTimeBean"%>
<%@page import="eOT.Common.OTRepository"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eCommon.Common.*, webbeans.eOT.StaffAssignmentBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
	<title>
		View Staff Assignment
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
	String assignmentDate = checkForNull(request.getParameter("assignmentDate"));
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
String operRoomDesc = "";

try  
{
	
	Map<String, String> otRoomMap = null;
	Map <String,List<StaffAssignmentTimeBean>> staffDetailMap = null;
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject(beanId, beanName, request) ;
	condnList.add(facilityId);
	condnList.add(locale);
	otRoomMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROOM_SELECT"), condnList);

	staffDetailMap = staffAssignmentBean.fetchStaffAssignmentDetails(assignmentDate, assignmentDate, operRoomCode, facilityId, locale, p);
	//operRoomDesc = otRoomMap.get(operRoomCode) == null ? operRoomCode : otRoomMap.get(operRoomCode);
	operRoomDesc = (otRoomMap.get(operRoomCode) == null || otRoomMap.get(operRoomCode) == "") ? "" : otRoomMap.get(operRoomCode); // Modified by dharma against IN-043734
%>	
	
<body>
	<form name="StaffAssignmentForm" id="StaffAssignmentForm" >
		<div class="main" style="position:fixed;height:380px;vertical-align:top;overflow:auto" >

			<div class="tcontent" >
				<div class="floatright"><div class="oldbtnclose" align='right' onclick='javascript:window.close();'>X</div></div>
				<div class="inputflds"> 
					<span class="iptdate"><fmt:message key="eOT.SADate.Label" bundle="${ot_labels}"/></span>
					<input type='text' name='assignmentDate' id='assignmentDate' maxlength='10' size='10'  class='txtbx' value='<%= assignmentDate %>' readOnly/>
					
					<span class="iptroom"><fmt:message key="eOT.SARoom.Label" bundle="${ot_labels}"/></span>
					<!-- <input type='text' name='operRoomDesc' id='operRoomDesc' maxlength='10' size='10'  class='txtbx' value='<%=otRoomMap.get(operRoomCode) %>' readOnly/> -->
					<input type='text' name='operRoomDesc' id='operRoomDesc' maxlength='10' size='10'  class='txtbx' value='<%=operRoomDesc%>' readOnly/><!-- Modified by dharma against IN-043734 -->
				</div>
				
				<div class="tablediv" > 
					<table  class="popupgrid" cellspacing="0">
						<th><span class="audittitle"><fmt:message key="eOT.SARole.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.SAName.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.FromTime.Label" bundle="${ot_labels}"/></th>
						<th><span class="audittitle"><fmt:message key="eOT.ToTime.Label" bundle="${ot_labels}"/></th>
					<%
						for(String key : staffDetailMap.keySet())
						{
								
							List<StaffAssignmentTimeBean> staffList = staffDetailMap.get(key);
							
							for(StaffAssignmentTimeBean timeBean : staffList)
							{
					%>	
								<tr>
									<td  class="alerttext">
										<span><%= timeBean.getRoleDesc() %></span>
									</td>
									<td  class="alerttext">
										<span><%= timeBean.getStaffName() %></span>
									</td>
									<td  class="alerttext">
										<span><%= timeBean.getFromTime() %></span>
									</td>
									<td  class="alerttext">
										<span><%= timeBean.getToTime() %></span>
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

