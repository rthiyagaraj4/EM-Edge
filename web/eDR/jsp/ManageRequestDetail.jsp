<!DOCTYPE html>
<%
/**
*	MODULE		: Duplicate Registration Check ...[DR]
*	Developer	: Shyam Prasad.P
*	Created On	: 05 AUG 2005
*	Funtion		: ManageRequestDetail
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>


<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
   String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<Script language="JavaScript" src="../../eDR/js/ManageRequest.js" ></Script>
	<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	/*function checkFromDate(obj)
    {
		alert(document.forms[0].sysdate.value);
		var next_execute_date=new Date(obj.value);
		var next_execute_time=next_execute_date.getTime();
		var sysdate=new Date(document.forms[0].sysdate.value);
		var syddate_time=sysdate.getTime();
        //alert('dt4'+dt4);
		// alert('dat1time'+dat1time);

		 if(eval(syddate_time) > eval(next_execute_time))
		 {
			  alert("sysdate should be always greater Than To date");
			  return false;
		 }
	     else
		 return true;
	}*/
	
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<%
	String scheduled_by		= checkForNull(request.getParameter("scheduled_by"));
	String scheduled_date	= checkForNull(request.getParameter("scheduled_date"));
	String id				= checkForNull(request.getParameter("id"));
	String disabled = "";
	java.util.Date currentdate=new java.util.Date();
	java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
	String sysdt=sf.format(currentdate);
%>
	
<form name="Request_form" id="Request_form" action='../../servlet/eDR.MergeRequestServlet' method='post' target='messageFrame'>
	
<table border=0 width='100%' cellspacing=0 cellpadding=0 >
	
	<tr><td colspan=6>&nbsp;</td></tr>
<!-- 	<tr>
		<td align=right class='label'>ID&nbsp;</td> -->
		<!-- <td align=left> --><input type=hidden size=14 name="job_control_no" id="job_control_no" readonly value='<%=id%>'> <!-- </td>
		<td colspan=2>&nbsp;</td>
	</tr> -->
	
	<tr>
		<td align=right class='label' width="15%"><fmt:message key="eDR.ScheduledBy.label" bundle="${dr_labels}"/></td>
		<td align=left class='querydata' width="10%"><%=scheduled_by%><input type=hidden name="scheduled_by" id="scheduled_by" size=14 readonly value='<%=scheduled_by%>'></td>
		<td align=right class='label' width="15%"><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td>
		<td align=left class='querydata' width="20%"><input type=hidden name="scheduled_date" id="scheduled_date" size=14 readonly value='<%=scheduled_date%>'><%=scheduled_date%></td>
		<td align=right class='label' ><fmt:message key="eDR.NextExecutionDate.label" bundle="${dr_labels}"/></td>
	<%	if(!(scheduled_date.equals("")) && !(id.equals("")))
		{	%>
			
			<td class='fields' align=left><input type=text size=14 name="next_execute_date" id="next_execute_date" onKeyPress="return(ChkDateNumberInput(this,event,2));" onblur="if(validDateObj(this,'DMYHM',localeName))checkFromDate(this);" ><input type='image' name="calendertime" id="calendertime" src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].next_execute_date.focus(); return showCalendar('next_execute_date',null,'hh:mm');"></td>
	<%	}
		else
		{	%>
			<td class='fields' align=left><input type=text readonly size=14 name="next_execute_date" id="next_execute_date"><input type='image' disabled name="calendertime" id="calendertime"  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].next_execute_date.focus(); return showCalendar('next_execute_date',null,'hh:mm');"></td>
	<%	}	%>
	</tr>
	<tr>
		<td colspan=5>&nbsp;</td>
	<%	if(!(scheduled_date.equals("")) && !(id.equals("")))
			disabled = "";
		else
			disabled = "disabled";
	%>
		<td class='button' colspan=2 align=left>
		<input class='BUTTON' type=button style="margin:7px 0 0 25%" value='<fmt:message key="Common.Submit.label" bundle="${common_labels}"/>' <%=disabled%> onClick="onSubmit()">
		<input class='BUTTON' type=button value='<fmt:message key="Common.change.label" bundle="${common_labels}"/>' <%=disabled%> onClick="onChange()">
		<input class='BUTTON' type=button value='<fmt:message key="Common.Remove.label" bundle="${common_labels}"/>' onClick="onRemove()" <%=disabled%> ></td>
	</tr>
</table>
<input type="hidden" name="function_name" id="function_name" value="">
<input type="hidden" name="sysdate" id="sysdate" value='<%=sysdt%>'>
</form>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

