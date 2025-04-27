<!DOCTYPE html>
<%--
/**
  *	Author				:	Mr.ArulKumarRaja.N
  * Created Date		:	07th June 2002
  * Last Modified Date	:	07th June 2002
  *	Purpose				:	Displays the Triage function for Manage Patient.
  */
--%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<center>
<form name='AEMPTriageForm' id='AEMPTriageForm'>
<br>
<table border='0' cellpadding='3' cellspacing='0' width='90%'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	query_treatment_area	=	"",		facility_id				=	"";
	String	open_to_all_pract_yn	=	"";
	String	clinic_code				=	"";
	String	sys_date				=	"";
	String	treatment_area_code		=	"",		treatment_area_desc		=	"";

	String	open_to_all_prac_for_clinic_yn	=	"";

	int		arrIndex				=	1;

	try
	{
   		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		clinic_code				=	(request.getParameter("clinic_code")==null)				? "" : request.getParameter("clinic_code");
		open_to_all_pract_yn	=	(request.getParameter("open_to_all_pract_yn")==null)	? "" : request.getParameter("open_to_all_pract_yn");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
	<tr>
		<td class='LABEL' align='RIGHT'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name='treatment_area_code' id='treatment_area_code' onChange='populateDynamicValues("AssignTreatmentArea")'>
		<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
		query_treatment_area	=	" select treatment_area_code, short_desc treatment_area_desc, " +
									" gender treatment_area_gender, open_to_all_prac_for_clinic_yn, "+
									" to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date "+
									" from ae_tmt_area_for_clinic " +
									" where facility_id = ? and CLINIC_CODE = ? and "+
									" eff_status = 'E' ";

			pstmt		=	con.prepareStatement(query_treatment_area);

			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	clinic_code		);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				treatment_area_code				=	rs.getString("treatment_area_code");
				treatment_area_desc				=	rs.getString("treatment_area_desc");
				open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");
				sys_date						=	rs.getString("sys_date");

				if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
			%>
				<option value='<%=treatment_area_code%>'><%=treatment_area_desc%></option>
				<script>parent.AEMPTriageFrame.openToAllPractForClnYN[<%=arrIndex%>] = '<%=open_to_all_prac_for_clinic_yn %>';</script>
			<%
				arrIndex++;
			} // end of while
%>		</select></td>
	</tr>
	<tr>
		<td class='LABEL' align='RIGHT'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name='practitioner_id' id='practitioner_id'>
		<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		</select></td>
	</tr>
	<tr>
		<td class='LABEL' align='RIGHT'>Date/Time</td>
		<td>&nbsp;&nbsp;<input type='text' name='tmt_date_time' id='tmt_date_time' value='<%=sys_date%>' size='16' maxlength='16'></td>
	</tr>
</table>
<p align='center'>
<input type='button' class='BUTTON' name='submit' id='submit' value=' OK '>&nbsp;
<input type='button' class='BUTTON' name='cancel' id='cancel' value=' Cancel '>
</p>
<br>
<input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>'>

</form>
</center>
</body>
</html>
<%
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
ConnectionManager.returnConnection(con,request);
%>

