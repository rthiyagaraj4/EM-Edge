<!DOCTYPE html>
<%
/// MODULE			:	OutPatinet Management..(OP)
/// Function Name	:	Medical Certificate
/// Developer		:	SRIDHAR R
/// Developed On	:	26 OCT 2004

%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<title><fmt:message key="Common.certificate.label" bundle="${common_labels}"/></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="SickLeaveForm" id="SickLeaveForm" >
<%
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	ResultSet rset	= null;
	Statement stmt	= null;
	con = ConnectionManager.getConnection(request);
	String FacilityId  	= (String) session.getValue( "facility_id" );
	String EncounterId  = request.getParameter("EncounterId");
	String PatientId    = request.getParameter("PatientId");
	if (EncounterId==null)	EncounterId = "";
	if (PatientId==null)	PatientId = "";
	String authorized_by_id	= "";
	String cert_issued	= "";
	String cert_issued_date	= "";
	String cert_type	= "";
	String employment_details	="";
	String fit_on_duty	= "";
	String fit_for_duty	= "";
	String follow_up_date	= "";
	String leave_from	= "";
	String leave_to	= "";
	String mc_no	= "";
	String remarks	= "";
try
{

	String sql = " SELECT authorized_by_id,decode(cert_issued,'Y','Yes','N','No') cert_issued, to_char(cert_issued_date,'dd/mm/rrrr hh24:mi')cert_issued_date, decode(cert_type,'M','Medical','O','Others')cert_type, employment_details, to_char(fit_on_duty,'dd/mm/rrrr hh24:mi')fit_on_duty, decode(fit_for_duty,'Y','Yes','N','No')fit_for_duty, to_char(follow_up_date,'dd/mm/rrrr hh24:mi')follow_up_date, to_char(leave_from,'dd/mm/rrrr hh24:mi')leave_from,  to_char(leave_to,'dd/mm/rrrr hh24:mi')leave_to, leave_tot_period, leave_unit, mc_no, remarks, sl_ref_no FROM PR_SICK_LEAVE_REGISTER WHERE FACILITY_ID = '"+FacilityId+"' AND ENCOUNTER_ID='"+EncounterId+"' and PATIENT_ID = '"+PatientId+"' ";
	stmt = con.createStatement();
	rset = stmt.executeQuery(sql);

	if(rset != null)
	 {
		while(rset.next())
		{
			authorized_by_id	= checkForNull(rset.getString("authorized_by_id"));
			cert_issued			= checkForNull(rset.getString("cert_issued"));
			cert_issued_date	= checkForNull(rset.getString("cert_issued_date"));
			
			if(!(cert_issued_date==null || cert_issued_date.equals("")))
				cert_issued_date= DateUtils.convertDate(cert_issued_date,"DMYHM","en",localeName);	
		
			cert_type			= checkForNull(rset.getString("cert_type"));
			employment_details	= checkForNull(rset.getString("employment_details"));
			fit_on_duty			= checkForNull(rset.getString("fit_on_duty"));

			if(!(fit_on_duty==null || fit_on_duty.equals("")))
				fit_on_duty		= DateUtils.convertDate(fit_on_duty,"DMYHM","en",localeName);	
			
			fit_for_duty		= checkForNull(rset.getString("fit_for_duty"));
			follow_up_date		= checkForNull(rset.getString("follow_up_date"));

			if(!(follow_up_date==null || follow_up_date.equals("")))
				follow_up_date	= DateUtils.convertDate(follow_up_date,"DMYHM","en",localeName);

			leave_from			= checkForNull(rset.getString("leave_from"));

			if(!(leave_from==null || leave_from.equals("")))
				leave_from		= DateUtils.convertDate(leave_from,"DMYHM","en",localeName);

			leave_to			= checkForNull(rset.getString("leave_to"));

			if(!(leave_to==null || leave_to.equals("")))
				leave_to		= DateUtils.convertDate(leave_to,"DMYHM","en",localeName);
		
			mc_no				= checkForNull(rset.getString("mc_no"));
			remarks				= checkForNull(rset.getString("remarks"));
			
		}
		if ( rset != null ) rset.close() ;
		if ( stmt != null ) stmt.close() ;
	}

%>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			
	<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td width ="15%" align='right' class='label' ><fmt:message key="Common.certificatetype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td width ="20%" align='left' class='QUERYDATA'><%=cert_type%></td>
		<td width ="15%" align='right' class='label' ><fmt:message key="eMP.mcno.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
		<td width ="50%" align='left' class='QUERYDATA'><%=mc_no%></td>
	</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td align='right' class='label' ><fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=leave_from%></td>
		<td align='right' class='label' ><fmt:message key="Common.LeaveTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=leave_to%></td>
	</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td align='right' class='label' ><fmt:message key="Common.ResumeActivity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=fit_for_duty%></td>
		<td align='right' class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=fit_on_duty%></td>
	</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td align='right' class='label' ><fmt:message key="Common.followupdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=follow_up_date%></td>
		<td colspan='2'>&nbsp</td>
	</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td align='right' class='label' ><fmt:message key="Common.certificateissued.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=cert_issued%></td>
		<td align='right' class='label' ><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=cert_issued_date%></td>
	</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td align='right' class='label' ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=authorized_by_id%></td>
		<td align='right' class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class='QUERYDATA'><%=remarks%></td>
	</tr>
	<tr><td colspan='4'>&nbsp</td></tr>
	<th align='left' colspan='18'><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></th>
	<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td >&nbsp</td>
		<td align='right' class='label' ><TEXTAREA readonly NAME="emp_det" ROWS="6" COLS="40"><%=employment_details%></TEXTAREA></td>
		<td >&nbsp</td>
		<td >&nbsp</td>
	</tr>
	<tr><td colspan='4'>&nbsp</td></tr>
	<tr>
		<td >&nbsp</td>
		<td >&nbsp</td>
		<td >&nbsp</td>
		<td align='right'><input type='button' class='Button' name='close' id='close' onClick='window.close()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'></td>
	</tr>
</table>


<%
	if ( rset != null ) rset.close() ;
	if ( stmt != null ) stmt.close() ;
}catch ( Exception e ){ out.println(e);}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>				
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

