<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/common.js"></script>
<script src="../js/repRegnRelgnStat.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBRLRGS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
%>

<center>
	<form name="repRegnRelgnStat" id="repRegnRelgnStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
		<table cellpadding='3' cellspacing='0' width='60%' align='center'>
		<tr>
			<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
			</tr>
			<tr>
			<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='facilityid' id='facilityid'>
				<%
					Connection con = null;
					ResultSet rset=null;
					PreparedStatement pstmt = null;
					try
					{
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  1 ";					

					pstmt=con.prepareStatement(sql1);

					rset=pstmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}
					}catch(Exception e)
					{
						
					}
					finally { 
						try
						{
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) ConnectionManager.returnConnection(con,request);
						}
						catch(Exception e)
						{
						
						}

					}
				%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	   <tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
			<tr>
				<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id='regnagenatstatto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.ReligionCode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_nd_fm_relgn_code" id="p_nd_fm_relgn_code" size="4" maxlength="4" value=''><input type='button' name='religion' id='religion' value='?' class='button' onclick='searchCode(this, p_nd_fm_relgn_code)'>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="p_nd_to_relgn_code" id="p_nd_to_relgn_code" size="4" maxlength="4"><input type='button' name='religion' id='religion' value='?' class='button' onclick='searchCode(this, p_nd_to_relgn_code)'>
				</td>
			</tr>
			<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
			</tr>

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

