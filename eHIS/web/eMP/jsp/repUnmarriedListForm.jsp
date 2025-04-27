<!DOCTYPE html>
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
<Script src="../../eMP/js/repUnmarriedList.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<%
String p_module_id	= "MP" ;
String p_report_id	= "MPBUNMOT" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
Connection con = null;
PreparedStatement pstmt = null ;
ResultSet rs = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
<form name="UnmarriedList" id="UnmarriedList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="60%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='30%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
	<td width='10%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='P_facilityid' id='P_facilityid'><!--  onChange='onChangeFacilityId()'> -->
<%
try
{
con = ConnectionManager.getConnection(request);
Statement stmt=con.createStatement();
String fid;
String fname;
String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2";
				
ResultSet rset=stmt.executeQuery(sql1);
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
}catch(Exception e)
{
	out.println(e);
}
%>
</select>
</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="eMP.BirthDateFrom.label" bundle="${mp_labels}"/></td>

	<td class='fields' ><input type="text" name="p_from_birth_date" id="p_from_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_birth_date');"><img src='../images/mandatory.gif'></img>
	</td>
	<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="text" name="p_to_birth_date" id="p_to_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_birth_date');"><img src='../images/mandatory.gif'></img>
	</td>
</tr>
<%
try
{
	pstmt = con.prepareStatement("SELECT mar_status_code,short_desc FROM mp_marital_status_lang_vw where language_id='"+localeName+"'");
	rs = pstmt.executeQuery();
%>
<tr>
<td class="label" ><fmt:message key="eMP.UnmarriedIndicator.label" bundle="${mp_labels}"/></td>
<td class='fields' ><select name="p_unmarried_indicator" id="p_unmarried_indicator">
<%
if(rs!=null)
{
	while (rs.next()){
		out.println("<option value='" + rs.getString("mar_status_code") + "'");
		if(rs.getString("mar_status_code").equals("S"))
			out.println(" selected");
		out.println(">" + rs.getString("Short_Desc")+"</option>");
	}
}
%>
</select><img src='../images/mandatory.gif'></img>
</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr><td colspan ='4'>&nbsp;</td></tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	<input type="hidden" name="locale" id="locale" value="<%=localeName%>" >
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</center>
<%
	if(rs	 != null)   rs.close();
	if(pstmt != null)	pstmt.close();
}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
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

