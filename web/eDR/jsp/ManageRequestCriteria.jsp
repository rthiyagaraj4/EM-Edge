<!DOCTYPE html>
<%
/**
*	MODULE		: Duplicate Registration Check ...[DR]
*	Developer	: Shyam Prasad.P
*	Created On	: 02 AUG 2005
*	
**/
%>

<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

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
<Script src="../../eDR/js/ManageRequest.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function fetchValues()
	{
		var start_time		= document.forms[0].start_time.value;
		var start_later_time= document.forms[0].start_later_time.value;
		var Status			= document.forms[0].Status.value;	
		

		if(start_time != "")	{
			start_time = convertDate(start_time,"DMYHM",localeName,"en");			
		}

		if(start_later_time != "")	{			
			start_later_time = convertDate(start_later_time,"DMYHM",localeName,"en");
		}
		
		/*
		if(start_time != "" && start_later_time != "")
		{
			start_time = convertDate(start_time,"DMYHM",localeName,"en");
			start_later_time = convertDate(start_later_time,"DMYHM",localeName,"en");
		}
		*/
		parent.frames[1].location.href="../../eDR/jsp/ManageRequestResult.jsp?start_time="+start_time+"&start_later_time="+start_later_time+"&Status="+Status;

		parent.frames[2].document.Request_form.reset();
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
	    //parent.frames[2].location.reload();		
	}

	/*function CompareDate(from ,to)
	{
		var result = "Pass";

		if(from.value != '')
		{
			if(!doDateTimeChk(from))
			{
				from.focus();
				from.value = "";
				result = "Fail";
				return ;
			}
		}
		
		if(result == "Pass")
		{
			if(from.value != '' && to.value != '')
			{
				if(ValidateDateTime(to, from))
				{
					var error=getMessage("ED_TIME_LESS_EQL_ST_TIME","DR");
					//error= error.replace('$','Scheduled To Date time');
					//error= error.replace('#','Scheduled From Date time');
					alert(error);
//					alert("Scheduled To Date time cannot be less than Scheduled From Date time ");
					to.focus();
					to.select();	
					return
				}
			}
		}
	}*/

</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>

	<form name=Manage_criteria_form method="post" action="../../eDR/jsp/ManageRequestResult.jsp">
		<table border=0 width='100%' cellspacing=0 cellpadding=0 >
			<tr><td colspan=3>&nbsp;</td></tr>
			<tr>
				<td class='label' ><fmt:message key="eDR.ScheduledFrom.label" bundle="${dr_labels}"/>&nbsp;</td>
				<td class='fields' colspan=2 ><input type="text" size='14' name="start_time" id='startnow' onKeyPress="return(ChkDateNumberInput(this,event,2));" onblur="if(validDateObj(this,'DMYHM',localeName))chkGrtr(this,document.forms[0].start_later_time);"><input type='image' id="calenderFromTime"  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].start_time.focus();return showCalendar('startnow',null,'hh:mm');" >-
				<input type="text" size='14' id='startlater' name="start_later_time" id="start_later_time" onKeyPress="return(ChkDateNumberInput(this,event,2));" onblur="if(validDateObj(this,'DMYHM',localeName))chkGrtr(document.forms[0].start_time,this);"><input type='image' id="calenderToTime"  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].start_later_time.focus();return showCalendar('startlater',null,'hh:mm');"></td>
			</tr>
			<tr><td colspan='3' height=3px></td></tr>
			<tr>
				<td class='label' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan=2><select name="Status" id="Status">
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
<!-- 					<option value='E'>Error</option> -->
					<option value='P' selected><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="eDR.Running.label" bundle="${dr_labels}"/></option>
			</tr>
			<tr><td colspan='3' height=3px></td></tr>
			<tr>
				<td colspan=2>&nbsp;</td>
				<td class="button" ><input style="margin-left: 90%" class='BUTTON' type=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="fetchValues();"></td>
			</tr>
			<tr><td colspan='3'></td></tr>
		</table>
	</form>
	</body>
</html>

