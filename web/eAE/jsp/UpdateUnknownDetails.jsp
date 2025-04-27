<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eAE/js/UpdateUnknownDetails.js' ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
 	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head> 
	<body onLoad="FocusFirstElement()" onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<%
	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
		
	String p_nat_length_str				= "";
	String p_accept_national_id_no_yn	= "";
	String alt_id1_unique_yn			= "";

	String patient_id	=	request.getParameter("patient_id");
	String p_short_desc =   request.getParameter("p_short_desc");
	if(patient_id == null) patient_id     = "";
	if(p_short_desc == null) p_short_desc = "";

	int p_patient_id_length = 0;
	int p_nat_length		= 0;
	int p_alt_length		= 0;

	try
	{ 
		con = ConnectionManager.getConnection(request);
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select accept_national_id_no_yn,"); 
		sqlStr.append(" nat_id_length, alt_id1_length, ");
		sqlStr.append("patient_id_length, alt_id1_unique_yn from mp_param  where module_id='MP' ");
        pstmt		=	con.prepareStatement(sqlStr.toString());
		rs			=	pstmt.executeQuery();
		
		while (rs.next())
		{
			p_accept_national_id_no_yn	= rs.getString("accept_national_id_no_yn");
			p_nat_length_str			= rs.getString("nat_id_length");
			p_patient_id_length			= rs.getInt("patient_id_length");
			alt_id1_unique_yn			= rs.getString("alt_id1_unique_yn");
			p_alt_length				= rs.getInt("alt_id1_length");

			if(p_accept_national_id_no_yn==null) p_accept_national_id_no_yn = "N";
			if (alt_id1_unique_yn==null) alt_id1_unique_yn = "N";
			if(p_nat_length_str==null) p_nat_length_str = "0"; 
			p_nat_length = Integer.parseInt(p_nat_length_str);
		}			
		%>
		<form name='UpdateUnknownDetails' id='UpdateUnknownDetails'  action='../../servlet/eAE.UpdateUnknownDetailsServlet' method='post' target='messageFrame'>
			<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center' id='id2'>
			<br><br>
			<tr>
				<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.ExistingDetails.label" bundle="${ae_labels}"/></td>
			</tr>

				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<td width='25%' class='label'  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields'  width="25%">
					<input type='text' name='patient_id' id='patient_id' size='22' maxlength="<%=p_patient_id_length%>" tabindex=1 value='<%=patient_id%>' onKeyPress='return CheckForSpecChars(event)' onBlur="checkPatientExists(this)" ><input type='button' class='Button' name='pat_search' id='pat_search' value='?' onclick="callPatientSearch(this);"><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
					<td id='DeceasedID'  class='OTHLANGDATA'>&nbsp;</td>
					<td class='label' >&nbsp; </td>
				</tr>
				<tr><td colspan='4'></td>&nbsp;</tr>
				<tr>
					<td class=label width='25%'>&nbsp;</td>
					<td id='pat_name' width='25%' class='OTHLANGDATA' colspan='2' >&nbsp;</td>
					<td class=label >&nbsp;</td>
				</tr>
				<tr><td colspan='4'></td></tr>
				<tr>
					<td width='25%' class='label' ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
					<td width='25%' id='pat_ser_grp' class='data' align='left'><b><%=p_short_desc%></b></td>
					<td colspan='2' class='label' ></td>
				</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<td class='COLUMNHEADER' colspan='4' ><fmt:message key="eAE.NewDetails.label" bundle="${ae_labels}"/></td>
				</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<td width='25%' class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td  class='fields'  width="25%">
					<input type='text' name='p_id_patient_id' id='p_id_patient_id' size='22' maxlength="<%=p_patient_id_length%>" onKeyPress='return CheckForSpecChars(event)'  onBlur="Populate_Main_Details()" value='' disabled><input type='button' class='Button' name='pat_search1' id='pat_search1' value='?' onclick="callPatientSearch(this);" disabled><img src="../../eCommon/images/mandatory.gif"></img></td>
					<td  class='label' colspan='2'>&nbsp;</td>
				</tr>
				<tr><td colspan='4'></td></tr>
				<tr>
					<td class=label width='25%' >&nbsp;</td>
					<td id='NewPatDltsID' width='20%' class='OTHLANGDATA' colspan='2' >&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr>
				<tr> 
					<td class='BUTTON'   colspan=2 align ="right" >
						<input type='button' class='BUTTON' value='Start Now' name='start_now' id='start_now' onClick='start_nowClick();' >
						<input type='button' class='BUTTON' value='Start Later' name='start_later' id='start_later' onClick='later_Click();'  >&nbsp;&nbsp;&nbsp;
						</td>

		              <td class=label width='25%'> <fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		              <td  class='fields'  width="25%"><input type='text' size='14' name='start_later_time' id='start_later_time'value='' onBlur="later_Click11();"  ><img name="calendertime"  id="calendertime"  src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].start_later_time.focus(); return showCalendar('start_later_time',null,'hh:mm');" style='cursor:pointer'></img>
					</td>
            </tr>
			<tr><td colspan='4' height='5'></td></tr>
			</table>
			<input type='hidden' name='p_pat_ser_grp_code' id='p_pat_ser_grp_code' value=''>
			<input type='hidden' name='mode' id='mode' value='insert'>
			<input type='hidden' name='nat_length' id='nat_length' value=<%=p_nat_length%>>
			<input type='hidden' name='alt_length' id='alt_length' value=<%=p_alt_length%>>
			<input type='hidden' name='pat_id_length' id='pat_id_length' value=<%=p_patient_id_length%>>
			<input type='hidden' name='alt_id1_unique_yn' id='alt_id1_unique_yn' value=<%=alt_id1_unique_yn%>>	
			<input type='hidden' name='p_gen_pat_id_yn' id='p_gen_pat_id_yn' value=''>
			<input type='hidden' name='p_existing_series_group' id='p_existing_series_group' value=''>
			<input type='hidden' name='prefix_reqd_yn' id='prefix_reqd_yn' value=''>	
			<input type='hidden' name='NewPatDltsIDName' id='NewPatDltsIDName' value=''>
			<input type='hidden' name='process_start' id='process_start' value=''>
			<input type='hidden' name='process' id='process' value=''>
		</form>
	<%
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if((sqlStr != null) && (sqlStr.length() > 0))
		{
			sqlStr.delete(0,sqlStr.length());
		}
	}
	catch (Exception e){e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
</html>

