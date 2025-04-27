<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String facilityid = request.getParameter( "facility_id" ) ;
	String section_code = request.getParameter("section_code");
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
    PreparedStatement pstmt1 =null;
	ResultSet rs3=null;
	Statement stmt = null;
	ResultSet rst  = null;
	String status = "" ;
	String mr_section_code="";
	String facilityname = "";
	String long_name="";
	String short_name="";
	String mr_section_type="";
	String prefix_reqd_yn="";	
	long max_srl_no=0;
	long next_srl_no=0;
	String prompt_for_old_file_no_yn="";
	String sqlstmt = null;
	String mysql = "SELECT patient_id_length from mp_param";
	int patient_id_length = 0;
	try{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst  = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			patient_id_length = rst.getInt("patient_id_length");
		}
		String strsql = "";
		strsql = "Select facility_name from sm_facility_param where facility_id=? ";
		
		pstmt1 = conn.prepareStatement(strsql);
		pstmt1.setString(1,facilityid); // Added by lakshmanan for security issue ID 174074717 on 14-08-2023
		rs3= pstmt1.executeQuery();
		if(rs3.next())
			{
			facilityname=rs3.getString(1);
			}
		
		sqlstmt = "select mr_section_code, long_name, short_name, mr_section_type,   prefix_reqd_yn, next_srl_no, max_srl_no, prompt_for_old_file_no_yn,eff_status	 from mr_section where mr_section_code=? and facility_id = ? ";
		
		pstmt = conn.prepareStatement(sqlstmt);
		pstmt.setString(1,section_code); // Added by lakshmanan for security issue ID 174074717 on 14-08-2023
		pstmt.setString(2,facilityid); // Added by lakshmanan for security issue ID 174074717 on 14-08-2023
		rs = pstmt.executeQuery();
		if( rs != null ) {
		    if(rs.next()) {		    	
		    	status = rs.getString("eff_status")==null ? "D" : rs.getString("eff_status");
		    	mr_section_code = rs.getString("mr_section_code")==null ? "" : rs.getString("mr_section_code");
		    	long_name = rs.getString("long_name")==null ? "" : rs.getString("long_name");
		    	short_name = rs.getString("short_name")==null ? "" : rs.getString("short_name");
		    	mr_section_type = rs.getString("mr_section_type")==null ? "C" : rs.getString("mr_section_type");
		    	prefix_reqd_yn = rs.getString("prefix_reqd_yn")==null ? "Y" : rs.getString("prefix_reqd_yn");
		    	next_srl_no = rs.getLong("next_srl_no");
		    	max_srl_no = rs.getLong("max_srl_no");
		    	prompt_for_old_file_no_yn = rs.getString("prompt_for_old_file_no_yn")==null ? "Y" : rs.getString("prompt_for_old_file_no_yn");
			}
			else {
			}
		    }
		}
	catch ( Exception e ) { }
	finally {
		if(pstmt !=null) pstmt.close();
		if(rs !=null) rs.close();
		if (pstmt1 != null) pstmt1.close();
		if (rs3 != null) rs3.close();		
		if (rst != null) rst.close();		
		if (stmt != null) stmt.close();		
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script src="../../eCommon/js/common.js" language="javascript"></script>


<script language="javascript">
	function setMaxLength() {
		mr_section_form.next_srl.value="";
		mr_section_form.max_srl.value="";

		if(mr_section_form.prefix_req1.checked==true) {
			mr_section_form.next_srl.maxLength = "<%=patient_id_length-2%>";
			mr_section_form.max_srl.maxLength = "<%=patient_id_length-2%>";
		}
		else {
			mr_section_form.next_srl.maxLength = "<%=patient_id_length%>";
			mr_section_form.max_srl.maxLength = "<%=patient_id_length%>";
		}
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('section_code')">
<form name="mr_section_form" id="mr_section_form" action="../../servlet/eMP.MRecordsSectionServlet" method="post" target="messageFrame">
<BR><BR>

<center>
	<table border="0" cellpadding="0" cellspacing="0" width="90%" align='center'>
<%
	if(status.equals("E")) {
%>
<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		    <td class="label"  width="40%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		    <td class='fields'  width="60%" colspan="2"><input type="text" name="facility" id="facility" value="<%=facilityname%>" size="48" maxlength="35" onBlur="" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
		    			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label"  width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		    <td class='fields'  width="60%" colspan="2"><input type="text" name="section_code" id="section_code" value="<%=mr_section_code%>" size="2" maxlength="2" onBlur="ChangeUpperCase(this)" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
		    			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label" width="40%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
			<td class='fields'  width="60%" colspan="2"><input type="text" name="long_name" id="long_name" value="<%=long_name%>" size="30" maxlength="30" onBlur="makeValidString(this);">&nbsp;<img src="../images/mandatory.gif"></img></td>
					<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label" width="40%"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
			<td class='fields'  width="60%" colspan="2"><input type="text" name="short_name" id="short_name" value="<%=short_name%>" size="15" maxlength="15" onBlur="makeValidString(this);">&nbsp;<img src="../images/mandatory.gif"></img></td>
					<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label"  width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields'  width="60%" colspan="2"><select name="section_type1" id="section_type1" disabled>
			<%
				if(mr_section_type.equals("C")) out.println("<option value='C' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels")+"</option>");
				else out.println("<option value='D' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Departmental.label","common_labels")+"</option>");
			%>
			</select>&nbsp;<img src="../images/mandatory.gif"></img></td>
					<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label" width="40%"><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></td>
		    <%
		    	out.println("<td class='fields' width='60%' ><input type='checkbox' name='prefix_req1' id='prefix_req1' value='Y' ");
		    	if(prefix_reqd_yn.equals("Y")) out.println(" Checked ");
		    	out.println(" onClick='setMaxLength()' disabled></td>");
		    %>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					
		</tr>
<tr>
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		     <td width="40%" class="label"><fmt:message key="eMP.SerialNumberNext.label" bundle="${mp_labels}"/></td>
		    <td class='fields'  width="60%" colspan="2" class="label"><input type="text" name="next_srl" id="next_srl" value="<%=next_srl_no%>" size="<%=patient_id_length%>"   readonly>&nbsp;<img src="../images/mandatory.gif"></img>
		    &nbsp;&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="max_srl" id="max_srl" value="<%=max_srl_no%>" size="<%=patient_id_length%>"  readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
					<td>&nbsp;</td>
		</tr>
		<!--tr><td>&nbsp; </td></tr-->
<tr>
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label"  width="41%"><fmt:message key="eMP.PromptforoldMRN.label" bundle="${mp_labels}"/></td>
		    <%
		    	out.println("<td class='fields' width='59%' colspan='2'><input type='checkbox' name='old_mrn1' id='old_mrn1' value='Y' ");
		    	if(prompt_for_old_file_no_yn.equals("Y")) out.println(" Checked ");
		    	out.println(" ></td>");
		    %>
					<td>&nbsp;</td>
	</tr>
			<tr>
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label" width="41%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		    <td class='fields'  width="59%" colspan="2"><input type="checkbox" name="eff_status1" id="eff_status1" value="E" checked></td>
			<td>&nbsp;</td>

		</tr>
		<tr>
				
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%' colspan='2'>&nbsp;</td>
	</tr>
	<%
	}
	else {
%>
<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%' colspan='2'>&nbsp;</td>
	</tr> 
	<tr>
		    <td class="label" width="40%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		    <td class='fields'  width="60%" colspan="2"><input type="text" name="facility" id="facility" value="<%=facilityname%>" size="35" maxlength="35" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
		    			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label"  width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		    <td class='fields'  width="60%" colspan="2"><input type="text" name="section_code" id="section_code" value="<%=mr_section_code%>" size="2" maxlength="2" onBlur="ChangeUpperCase(this)" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label"  width="40%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
			<td  width="60%" colspan="2"><input type="text" name="long_name" id="long_name" value="<%=long_name%>" size="30" maxlength="30" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label"  width="40%"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
			<td class='fields'  width="60%" colspan="2"><input type="text" name="short_name" id="short_name" value="<%=short_name%>" size="15" maxlength="15" readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
			<td class="label" width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields'  width="60%" colspan="2"><select name="section_type1" id="section_type1" disabled>
			<%
				if(mr_section_type.equals("C")) out.println("<option value='C' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels")+"</option>");
				else out.println("<option value='D' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Departmental.label","common_labels")+"</option>");
			%>
			</select>&nbsp;<img src="../images/mandatory.gif"></img></td>
			<td>&nbsp;</td>

		</tr>
			<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label" width="40%"><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></td>
		    <%
		    	out.println("<td class='fields'  width='60%' colspan='2'><input type='checkbox' name='prefix_req1' id='prefix_req1' value='Y' ");
		    	if(prefix_reqd_yn.equals("Y")) out.println(" Checked ");
		    	out.println(" onClick='setMaxLength()' disabled></td>");
		    %>
			<td>&nbsp;</td>
		</tr>
<tr>
		<td colspan='4'>&nbsp;
		</td>
		</tr>
	<tr>
		     <td width="40%" class="label"><fmt:message key="eMP.SerialNumberNext.label" bundle="${mp_labels}"/></td>
		    <td class='fields' width="60%" colspan="2" class="label"><input type="text" name="next_srl" id="next_srl" value="<%=next_srl_no%>" size="<%=patient_id_length%>"  readonly>&nbsp;<img src="../images/mandatory.gif"></img>
		    &nbsp;&nbsp;Max&nbsp;&nbsp;<input type="text" name="max_srl" id="max_srl" value="<%=max_srl_no%>" size="<%=patient_id_length%>"  readonly>&nbsp;<img src="../images/mandatory.gif"></img></td>
			<td>&nbsp;</td>

		</tr>
<tr>
		<td colspan='4'>&nbsp;
		</td>
		</tr>

		<tr>
		    <td class="label" width="41%"><fmt:message key="eMP.PromptforoldMRN.label" bundle="${mp_labels}"/></td>
		    <%
		    	out.println("<td class='fields' width='59%' colspan='2'><input type='checkbox' name='old_mrn1' id='old_mrn1' value='Y' ");
		    	if(prompt_for_old_file_no_yn.equals("Y")) out.println(" Checked ");
		    	out.println(" disabled></td>");
		    %>
			<td>&nbsp;</td>

		</tr>
		
		
		<tr >
		<td colspan='4'>&nbsp;
		</td>
		</tr>
		<tr>
		    <td class="label" width="41%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		    <td class='fields' width="59%" colspan="2"><input type="checkbox" name="eff_status1" id="eff_status1" value="E"></td>
			<td>&nbsp;</td>

		</tr>
		<tr>
						<td colspan='4'>&nbsp;</td>
	</tr>
<%	}
%>
</table>
</center>
<input type="hidden" name="function" id="function" value="modify">
<input type="hidden" name="prefix_req" id="prefix_req" value="N">
<input type="hidden" name="section_type" id="section_type" value="D">
<input type="hidden" name="old_mrn" id="old_mrn" value="N">
<input type="hidden" name="eff_status" id="eff_status" value="D">

</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

