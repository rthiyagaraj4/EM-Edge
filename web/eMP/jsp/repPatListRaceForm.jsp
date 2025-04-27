<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*, eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src="../../eMP/js/repPatListRace.js" language="JavaScript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String p_module_id	= "MP" ;
String p_report_id	= "MPBPRACE" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
Connection con = null;
Statement stmt = null;
ResultSet rset = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
<form name="Racereport" id="Racereport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="60%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='30%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
	<td width='5%'>&nbsp;</td>
	<td width='35%'>&nbsp;</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class="fields"><select name='P_facilityid' id='P_facilityid'><!--  onChange='onChangeFacilityId()'> -->
<%
try
{
con = ConnectionManager.getConnection(request);
//Added by Sangeetha for ML-MMOH-CRF-0732 
Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");

stmt=con.createStatement();
String fid;
String fname;
String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2";

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
if (rset != null) rset.close();
if (stmt != null) stmt.close();

%>
</select>
</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
    <td>&nbsp;</td>
    <td class="querydata"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td> 
    <td>&nbsp;</td>
    <td class="querydata"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
	<td class="fields" ><input type="text" id='regnagenatstatfrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img align="center" src="../../eCommon/images/mandatory.gif">
	</td>
	<td class="label">&nbsp;</td>
	<td class="fields" ><input type="text" id='regnagenatstatto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img align="center" src="../../eCommon/images/mandatory.gif">
	</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
	<td class="fields" ><input type="text" name="p_series_from" id="p_series_from" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %>><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
	p_series_from,'N')">
	</td>
	<td class="label">&nbsp;</td>
	<td class="fields" ><input type="text" name="p_series_to" id="p_series_to" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %>><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
		p_series_to,'N')">
	</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>

	<td class="fields" ><input type="text" name="p_from_birth_date" id="p_from_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_birth_date');">
	</td>
	<td class="label">&nbsp;</td>
	<td class="fields" ><input type="text" name="p_to_birth_date" id="p_to_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_birth_date');">
	</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
<td class="fields" ><input type="text" name="p_fm_race_code" id="p_fm_race_code" size="6" maxlength="6"><input type='button' name='race' id='race' value='?' class='button' onclick="searchCode(this, p_fm_race_code,'N')"></td>
<td  class="label" >&nbsp;</td>
<td  ><input type="text" name="p_to_race_code" id="p_to_race_code" size="6" maxlength="6"><input type='button' name='race' id='race' value='?' class='button' onclick="searchCode(this, p_to_race_code,'N')"></td>
</tr>
<tr><td colspan ='4'>&nbsp;</td></tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</center>
</body>
</html>
<%
}catch(Exception e){
	out.println(e);
}finally{
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
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

