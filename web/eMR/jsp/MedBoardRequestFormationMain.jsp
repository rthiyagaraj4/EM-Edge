<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedBoardReqFormBean" class="webbeans.eCommon.RecordSet" scope='session'/>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../js/MedBoardRequestMain.js" language='javascript'></script>
<script src="../js/MedBoardReqButtons.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function showImg(obj)
{
	if(obj == "1")// Incomplete
		document.getElementById("apptImg").style.visibility = "Hidden";
	else
		document.getElementById("apptImg").style.visibility = "Visible";
}

</script>
	<body onKeyDown='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = (String)session.getAttribute("LOCALE"); 
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	StringBuffer medboardSql = new StringBuffer();
	String med_board_code = "";	String SystemDate="";
	String med_board_short_desc = "";
	String request_id = request.getParameter("request_id")==null?"":request.getParameter("request_id");
	String med_board_type = request.getParameter("med_board_type")==null?"":request.getParameter("med_board_type");
	String PatientId   = request.getParameter("PatientId")==null?"":request.getParameter("PatientId");

	try
	{
		con = ConnectionManager.getConnection(request);
		String sysdateSql="select to_char(sysdate,'dd/mm/yyyy')SystemDate from dual";
		stmt = con.createStatement();
		rs	=	stmt.executeQuery(sysdateSql);
		if (rs.next() && rs != null)
		{
			SystemDate = rs.getString("SystemDate");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		MedBoardReqFormBean.clearAll();
%>
<form name="MedBoardReqForm" id="MedBoardReqForm">
	<input type='hidden' name='RecordTime' id='RecordTime' value='N'>
	<table border=0 cellspacing=0 cellpadding=2 width='100%'>	
		<tr align="left">
			<th colspan='4' class="columnheader"><fmt:message key="eMR.MedicalBoardMembersFormation.label" bundle="${mr_labels}"/></th>
		</tr>
		<tr>
			<td class='label' width="25%" ><fmt:message key="eMR.MedicalBoard.label" bundle="${mr_labels}"/></td>
			<td class='fields' width="30%"><select name='medical_board' id='medical_board'>
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
				medboardSql.append(" select medical_board_code, short_desc from MR_MEDICAL_BOARD_LANG_VW where language_id = '"+locale+"'  ");
				if(!med_board_type.equals(""))
				{
					medboardSql.append(" and med_board_type_code = '"+med_board_type+"'");
				}

				stmt = con.createStatement();
				rs = stmt.executeQuery(medboardSql.toString());

				while(rs.next())
				{
					med_board_code = rs.getString("medical_board_code");
					med_board_short_desc = rs.getString("short_desc");
					out.println("<option value='"+med_board_code+"'>"+med_board_short_desc+"</option>");
				}

			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();	
			%>
			</select><img align='center'  src='../../eCommon/images/mandatory.gif'></td>
			<td class='label' width="20%" ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='fields' width="25%">
			<!--Below line is commented by Akhilesh because unnecessary function is calling -->
			<!--<input type='text' name='appt_date' id='appt_date' value='' maxlength=12 size=12 onblur ='validDateObj(this,"DMY","<%=locale%>");DateCheck(appt_date,sysdate);'></input>-->
			<input type='text' name='appt_date' id='appt_date' value='' maxlength=12 size=12 onblur ='DateCheck(appt_date,sysdate);'></input><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].appt_date.focus();return showCalendar('appt_date');"/><img align='center' src='../../eCommon/images/mandatory.gif' id='apptImg' style="visibility:hidden"></td>
		</tr>
		<tr>
			<td class='label'  nowrap><fmt:message key="eMR.MemberType.label" bundle="${mr_labels}"/></td>
			<td class='fields' colspan="3"><select name='user_type' id='user_type' value='' onchange='assign_user(this)'><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='I'><fmt:message key="Common.Internal.label" bundle="${common_labels}"/></option>
			<option value='E'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
			</select>&nbsp;/&nbsp;<select name='user' id='user' value='' id='user_id' onchange='assign_user(this)' ><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='U' id='Uid' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></option>
			<option value='P' id='Pid' onchange='clear_values()' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			</select><img align='center'  src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<tr>
			<td class='label'  nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>	
			<td><jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include><img align='center'  src='../../eCommon/images/mandatory.gif'></td>
			<td class='label'  ><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>	
			<td class='fields'><select name='role' id='role' value='S'>
			<option>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='C'><fmt:message key="Common.Chief.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.Member.label" bundle="${common_labels}"/></option></select><img align='center'  src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<tr>
			<td  class='label' ><fmt:message key="eMR.FormationStatus.label" bundle="${mr_labels}"/></td>
			<td  class='fields' ><select name="formation_status" id="formation_status" onchange="showImg(this.value)">
			<option value='2'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option selected value='1'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			</select></td>
			<td class='label'>&nbsp;</td>
			<td class='button' ><input type='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' class='button' onclick='addRequest()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='ClearValues()'></td>
		</tr>
		<tr>
			<td class='DEFAULTBLANKROW2PT' colspan=4 height=5>&nbsp;</td></tr> 
		<tr>
	</table>
	<input type='hidden' name='request_id' id='request_id' value='<%=request_id%>'>
	<input type='hidden' name='sysdate' id='sysdate' value='<%=SystemDate%>'>
	<input type='hidden' name='patientId' id='patientId' value='<%=PatientId%>'>
</form>
</body>
<%
	}
	catch(Exception e)
	{
		//out.println("Exception @ MedBoardRequestFormationMain "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

