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

<%@page import="webbeans.eOT.StaffAssignmentTimeBean"%>
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
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
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
	facilityId = facilityId.substring(facilityId.length() - 2);
	String locale = (String)session.getAttribute("LOCALE");
	String assignmentFromDate = checkForNull(request.getParameter("assignmentFromDate"));
	String assignmentToDate = checkForNull(request.getParameter("assignmentToDate"));
	String operRoomCode = checkForNull(request.getParameter("operRoomCode"));
	Properties p = (Properties) session.getValue( "jdbc" ) ;
	
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
	Map <String,List<StaffAssignmentTimeBean>> timeBeanMap = null;
	List<StaffAssignmentTimeBean> timeBeanList = null;
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject(beanId, beanName, request) ;
	condnList.add(facilityId);
	condnList.add(locale);
	otRoomMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROOM_SELECT"), condnList);

	Map<String,String> roleMap = null;
	
	condnList = new ArrayList<String>();
	condnList.add(locale);
	roleMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROLE_SELECT"), condnList);
	timeBeanMap = staffAssignmentBean.fetchStaffAssignmentDetails(assignmentFromDate, assignmentToDate, operRoomCode, facilityId, locale, p);

	int dateIndex = 0;
	int timeIndex = 0;
	
	String checkedValue = "";
	String indexSuffix = null;
	
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
	<form name="StaffAssignmentRoleForm" id="StaffAssignmentRoleForm" >
		<div class="main" style="width:99%; height:380px; overflow: auto; ">
				<div class="stfdet">
					<div class="floatleft" ><span class="stftitle"><fmt:message key="eOT.StaffDetails.Label" bundle="${ot_labels}"/></span> </div>
				</div>
				<div class="tablediv" style="width:100%; height:100%;  "> 
					<table  class="crstaffgrid"  border="0" cellspacing="0" id='AssignmentTimeTable'>
						<th width='17%'><fmt:message key="eOT.SARole.Label" bundle="${ot_labels}"/></th>
						<th width='17%'><fmt:message key="eOT.SAName.Label" bundle="${ot_labels}"/></th>
						<th width='17%'><fmt:message key="eOT.ShowInWidget.Label" bundle="${ot_labels}"/></th>
						<th width='17%'><fmt:message key="eOT.FromTime.Label" bundle="${ot_labels}"/></th>
						<th width='17%'><fmt:message key="eOT.ToTime.Label" bundle="${ot_labels}"/></th>
						<th width='17%'><fmt:message key="eOT.SAAction.Label" bundle="${ot_labels}"/></th>
					<%
						if(timeBeanMap != null && !timeBeanMap.isEmpty())
						{
							
							for(String key : timeBeanMap.keySet())
							{
								String [] keyArray = key.split("~");
								timeBeanList = timeBeanMap.get(key);
								dateIndex++;
								indexSuffix = dateIndex + "_1"; 
								
					%>	
					
						<table class="modstaffgrid" cellspacing="0" id="OuterTable<%=dateIndex%>">
							
							<tr>
								<th  class="alignimgtext"  width='85%'>
									<%= keyArray[0] %>
									<input type='hidden' name='assignmentDate<%=dateIndex%>' id='assignmentDate<%=dateIndex%>' value='<%= keyArray[0] %>' />
									<input type='hidden' name='operRoomCode<%=dateIndex%>' id='operRoomCode<%=dateIndex%>' value='<%= keyArray[1] %>' />
								</th>
								<th  class="alignimgtext"  width='15%' >
									<input class="oldbtn" id='addBtn<%=dateIndex  %>' type="button" value="Add" onclick='javascript:addRoleRow(<%=dateIndex%>)' disabled/>
									 <img id='arrow<%=dateIndex %>' src="../../eOT/images/Arrow1.PNG" class="arrowps" onclick='javascript:showHideDateDetails(<%=dateIndex%>)'/>
								</th>
							</tr>
							<tr>
								<td colspan='2'>
									<div id="dateDetailDiv<%=dateIndex %>" style='display:none;visibility:visible;overflow:auto'>		
								
										<table class="modstaffgrid" cellspacing="0" id="RoleTable<%=dateIndex%>">
											<tr>	
												<td class="alignimgtext" width='17%'>
													<select class="brdclr" name='roleType<%=indexSuffix%>' id='roleType<%=indexSuffix%>'>
													
													</select>
												</td>
												<td class="alignimgtext" width='17%'>
													<input type='hidden' name='practitionerId<%=indexSuffix%>' id='practitionerId<%=indexSuffix%>' >
													<input type='text' name='practitionerName<%=indexSuffix%>' id='practitionerName<%=indexSuffix%>'  size='20' onblur="if(this.value!='')searchDoctor(roleType<%=indexSuffix%>, practitionerId<%=indexSuffix%>,practitionerName<%=indexSuffix%>, 1); else practitionerId<%=indexSuffix%>.value='';" > 
													<input type='button' class='button' value='?' onClick='searchDoctor(roleType<%=indexSuffix%>, practitionerId<%=indexSuffix%>,practitionerName<%=indexSuffix%>, 1);'  > 
													<img src='../../eCommon/images/mandatory.gif'></img>
												</td>
												<td  width='17%'>
													<input class="brdclr"class="brdclr" type="checkbox" name='showWidgetYN<%=indexSuffix%>' id='showWidgetYN<%=indexSuffix%>' value='Y'/>
												</td>
												<td class="alignimgtext" width='17%'>
													<input class="brdclr"class="brdclr" type="text" name='fromTime<%=indexSuffix%>' id='fromTime<%=indexSuffix%>' size='5' onblur='javascript:checkTimeFormat(this)'/>
												</td>
												<td class="alignimgtext" width='17%'>
													<input class="brdclr"class="brdclr" type="text" name='toTime<%=indexSuffix%>' id='toTime<%=indexSuffix%>' size='5' onblur='javascript:checkTimeFormat(this)'/>
												</td>
												<td class="alignimgtext" width='17%'>
												</td>
											</tr>
											<script>
												populateAndSetComboModify('', <%=dateIndex%>,1);
											</script>
								<%
											if(timeBeanList != null && !timeBeanList.isEmpty())
											{
												timeIndex = 1;
												for(StaffAssignmentTimeBean timeBean : timeBeanList)
												{
													timeIndex++;
													if("Y".equals(timeBean.getShowWidgetYN()))
													{
														checkedValue = "checked";
													}
													else
													{
														checkedValue = "";
													}
													indexSuffix = dateIndex + "_" + timeIndex; 
														
								%>		
									
											<tr>
												<td class="alignimgtext">
													<input type='hidden' name='staffAssignmentId<%=indexSuffix%>' id='staffAssignmentId<%=indexSuffix%>' value='<%= timeBean.getStaffAssginmentId() %>' />
													<input type='hidden' name='rowModified<%=indexSuffix%>' id='rowModified<%=indexSuffix%>' value='' />
													<input type='hidden' name='roleType<%=indexSuffix%>' id='roleType<%=indexSuffix%>' value='<%= timeBean.getRoleId() %>' />
													<%= timeBean.getRoleDesc() %>
												</td>
												<td class="alignimgtext">
													<input type='hidden' name='practitionerId<%=indexSuffix%>' id='practitionerId<%=indexSuffix%>' value='<%= timeBean.getStaffId() %>' />
													<%= timeBean.getStaffName() %>
												</td>
												<td >
												
													<input class="brdclr"class="brdclr" type="checkbox" name='showWidgetYN<%=indexSuffix%>' id='showWidgetYN<%=indexSuffix%>' value='Y' <%= checkedValue %> onclick="setRowModified(<%=dateIndex%>,<%=timeIndex%>)"/>
												</td>
												<td class="alignimgtext">
													<input class="brdclr"class="brdclr" type="text" name='fromTime<%=indexSuffix%>' id='fromTime<%=indexSuffix%>' size='5' value='<%= timeBean.getFromTime()%>' onblur="checkTimeModify(this, <%=dateIndex%>,<%=timeIndex%>)"/>
												</td>
												<td class="alignimgtext">
													<input class="brdclr"class="brdclr" type="text" name='toTime<%=indexSuffix%>' id='toTime<%=indexSuffix%>' size='5' value='<%= timeBean.getToTime()%>' onblur="checkTimeModify(this, <%=dateIndex%>,<%=timeIndex%>)"/>
												</td>
												<td>
													<img src="../../eOT/images/Close.png" class="midalign" onclick='javascript:deleteRoleRow(<%= dateIndex%>, <%= timeIndex %>)'/>
													<span class="tbtxt" >Delete</span>
												</td>
											</tr>
										
							<%
										}
									}			
							%>	
								<input type="hidden" name='rowCount<%=dateIndex %>' id='rowCount<%=dateIndex %>' value='<%=timeIndex %>' />
										</table>
									</div>
								</td>			
							</tr>		
						</table>	
					<%
							}
						}
					%>	
					</table>	
					
				</div>
			</div>	
			<input class="oldbtn1 floatright" type="button" value='<fmt:message key="eOT.AuditTrail.Label" bundle="${ot_labels}"/>' onclick='javascript:viewAuditTrail()'/>
		</div>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
			<input type='hidden' name='deleteId' id='deleteId' value='' />
			<input type='hidden' name='mode' id='mode' value='modify' />
			<input type='hidden' name='dateCount' id='dateCount' value='<%= dateIndex %>' />
			<input type='hidden' name='assignmentFromDate' id='assignmentFromDate' value='<%=assignmentFromDate%>' />
			<input type='hidden' name='assignmentToDate' id='assignmentToDate' value='<%= assignmentToDate%>' />
			<input type='hidden' name='operRoomCode' id='operRoomCode' value='<%=operRoomCode %>' />
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

