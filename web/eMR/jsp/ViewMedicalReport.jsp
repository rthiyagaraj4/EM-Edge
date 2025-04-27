
<%
/*
 MODULE			:	Medical Records..(MR)
 Function Name	:	Medical Report [To Print & view]
 Developer		:	SRIDHAR R
 Created On		:	14 Dec 2004
 Function		:	To Print the report using HTML & JSP without Reports...
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.io.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<title><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;

	ResultSet noteRs = null;
	Statement noteStmt = null;

	Boolean isViewMedicalReportAppl = false;//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331 

try
{
	con = ConnectionManager.getConnection(request);
	String Facility_Id = (String) session.getValue("facility_id");
	String loggedUser = (String) session.getValue("login_user");
	String locale	  = (String) session.getAttribute("LOCALE");
	String call_function = request.getParameter("call_function");

	isViewMedicalReportAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","VIEW_MED_REPORT"); //Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331

	String patientId = request.getParameter("patientId");
		if(patientId == null) patientId ="";

	String request_id = request.getParameter("request_id");
		if(request_id == null) request_id ="";

	String accession_num = request.getParameter("accession_num");

	String notes_content		= "";
	String print_date_time = "";
	String authorizedBy = "";

	try
	{
		//String authorisedBySql=" select (select SHORT_NAME from am_practitioner where practitioner_id=a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'') from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG from ca_encntr_note a where a.facility_id='"+Facility_Id+"' and a.accession_num='"+accession_num+"' ";

		String authorisedBySql=" select (select short_name from AM_PRACTITIONER_LANG_VW where language_id = '"+locale+"' and practitioner_id = a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time, (select nvl(PATIENT_NAME_LOC_LANG,'') from MP_PATIENT where PATIENT_ID = a.patient_id) PATIENT_NAME_LOC_LANG from ca_encntr_note a where a.facility_id='"+Facility_Id+"' and a.accession_num='"+accession_num+"' "; 


		stmt = con.createStatement();
		rs	=	stmt.executeQuery(authorisedBySql);
		if (rs.next() && rs != null)
		{
			print_date_time = rs.getString("print_date_time");
				if(print_date_time == null) print_date_time = "";	
			if(!(print_date_time==null || print_date_time.equals("")))
					print_date_time	= DateUtils.convertDate(print_date_time,"DMYHM","en",locale);
	
			authorizedBy = rs.getString("Authorized_by_name");
				if(authorizedBy == null) authorizedBy = "";		
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

	}catch(Exception exp)
	{
	}

%>

<body onKeyDown='lockKey()'>
	<!-- Report Header -->
	<script>
		var a=window.dialogArguments;
		document.write(a);
	</script>
<%
	try
	{
		//oracle.sql.CLOB			clob_notes_content	= null;
		Clob			clob_notes_content	= null;
		java.io.Reader			content_reader		= null;
		java.io.BufferedReader	bf_content_reader	= null;

		String query_notes_detail = " SELECT a.note_content note_content, b.note_type_desc from ca_encntr_note a, ca_note_type b where a.note_type = b.note_type and a.facility_id = '"+Facility_Id+"' and a.accession_num = '"+accession_num+"' ";

		noteStmt = con.createStatement();
		noteRs	 = noteStmt.executeQuery(query_notes_detail);

		if(noteRs.next())
		{
			//clob_notes_content=(oracle.sql.CLOB)noteRs.getObject("note_content");
			clob_notes_content=(Clob)noteRs.getObject("note_content");
			if(clob_notes_content!=null)
			{
				try
				{
					content_reader	= clob_notes_content.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

					notes_content = new String(arr_notes_content);
					bf_content_reader.close();
				}
				catch(Exception e)
				{
					//out.println("Exception@2-readCLOB : "+e);
					e.printStackTrace();
				}

			%>
		<!-- notes_content is a Clob Object which is dynamic based on accession Number -->
			<!-- Report Body -->
			<table border="0" width="100%" cellspacing='0' cellpadding='0'>	
				<tr>
					<td class='BODYCOLORFILLED'> <%=notes_content%></td>
				</tr>
			</table>
			<%
			} 
		} 
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception e)
	{
		//out.println("Exception@2-readCLOB : "+e);
		e.printStackTrace();
	}
%>
		<!-- Report Footer -->
		<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>
			<th colspan='6'>&nbsp;</th>
			<tr>
				<td colspan='4'>&nbsp;</td>
			</tr>
			<tr>
				<td width='20%'><b><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></b></td>
				<td width='45%' align='left'>:<font size='2'><%=authorizedBy%></font></td>
				<td width='15%'><b><fmt:message key="Common.Signature.label" bundle="${common_labels}"/></b></td><td width='20%' align='left'>:</td>
			</tr>
			<tr>
				<td width='20%'><b><fmt:message key="Common.PrintDateTime.label" bundle="${common_labels}"/></b></td>
				<td width='45%' align='left'><font size='2'>:<%=print_date_time%></font></td>
				<td width='15%'><b><fmt:message key="Common.LoggedUser.label" bundle="${common_labels}"/></b></td>
				<td width='20%' align='left'><font size='2'>:<%=loggedUser%></font></td>
			</tr>
		</table>

	<%	
	/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
	if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") || (isViewMedicalReportAppl && call_function.equals("RECEIVE_MEDICAL_REPORT")))
		{
			out.println("<script>window.print();</script>");
		}
	}catch(Exception exp)
	{
		exp.printStackTrace();
	}	
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
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

