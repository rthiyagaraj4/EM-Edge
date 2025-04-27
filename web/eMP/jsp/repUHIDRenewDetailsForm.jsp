<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../js/repUHIDRenewDtls.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPUHREDL" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rset = null;
	int Patient_Id_Length=0	;
							

							try
							{
							con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement("SELECT PATIENT_ID_LENGTH FROM mp_param"); 
							rs = pstmt.executeQuery();
							if(rs != null && rs.next())
								Patient_Id_Length = rs.getInt("Patient_Id_Length");
							}catch(Exception e){out.println(e);}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


							

%>

<center>
	<form name="repUHIDRenewForm" id="repUHIDRenewForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
		<table cellpadding='3' cellspacing='0' align='center' border="0" width="60%">

		
		
	
			<tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		  </tr>
			<tr>
				<td class="label"><fmt:message key="eMP.RenewDate.label" bundle="${mp_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_fr_renew_dt" id="p_fr_renew_dt" size="10" maxlength="10" onBlur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id='regnagenatstatto' name="p_to_renew_dt" id="p_to_renew_dt" size="10" maxlength="10" onBlur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fr_pat_id" id="p_fr_pat_id" size="20" maxlength=<%=Patient_Id_Length%> onBlur="ChangeUpperCase(this);"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='PatSearch(p_fr_pat_id)'>
				</td>

				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="p_to_pat_id" id="p_to_pat_id" size="20" maxlength=<%=Patient_Id_Length%>  onBlur="ChangeUpperCase(this);"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='PatSearch(p_to_pat_id)'>
				</td>
			</tr>
			
			<tr>
				<td class="label"><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/> </td>
				<td class='fields'><input type="text" name="P_fm_bl_group_code" id="P_fm_bl_group_code" size="6" maxlength="6"><input type='button' name='Billing' id='Billing' value='?' class='button' onclick='searchCode(this, P_fm_bl_group_code)'>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="P_to_bl_group_code" id="P_to_bl_group_code" size="6" maxlength="6"><input type='button' name='Billing' id='Billing' value='?' class='button' onclick='searchCode(this, P_to_bl_group_code)'>
				</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/> </td>
				<td class='fields'><input type="text" name="P_fm_user_code" id="P_fm_user_code" size="6" maxlength="6"><input type='button' name='from_user' id='from_user' value='?' class='button' onclick="usersearchCode(this,P_fm_user_code,'N')">
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="P_to_user_code" id="P_to_user_code" size="6" maxlength="6"><input type='button' name='to_user' id='to_user' value='?' class='button' onclick="usersearchCode(this,P_to_user_code,'N')">
				</td>
			</tr>



			<tr><td colspan='4'>&nbsp;</td></tr>
		</table>

		<br>
		



		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>

</center>
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

