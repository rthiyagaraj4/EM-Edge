<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMP/js/repPurgeAudit.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPURGE" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
%>
<center>
	<form name="repPurgeAudit" id="repPurgeAudit" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
		<table cellpadding='3' cellspacing='0' width='60%' align='center' border='0'>
		<tr>
				<td width='30%'>&nbsp;</td>
				<td width='30%'>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
				<td width='30%'>&nbsp;</td>
			</tr>
			<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields"><select name='P_FACILITYID' id='P_FACILITYID'>
				<%
					Connection con = null;
					ResultSet rset=null;
					Statement stmt=null;
					try
					{
					con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  1";
							

					rset=stmt.executeQuery(sql1);
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
						if(rset!=null) rset.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						out.println(e);
					}
					finally { 
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
				%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
			<tr>
				<td class="label"><fmt:message key="eMP.PurgedDateFrom.label" bundle="${mp_labels}"/></td>
				<td class="fields"><input type="text" id="purge_date_from" name="P_PURGED_FROM_DATE" id="P_PURGED_FROM_DATE" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('purge_date_from');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>

				<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>

				<td class="fields"><input type="text" id="purge_date_to" name="P_PURGED_TO_DATE" id="P_PURGED_TO_DATE" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('purge_date_to');"><img src='../../eCommon/images/mandatory.gif'></img>
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

