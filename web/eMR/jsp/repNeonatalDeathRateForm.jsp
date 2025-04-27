<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<%
String p_module_id	= "MR" ;
String p_report_id	= "MRBNEODT" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
Connection con = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null ;
ResultSet rset = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown='lockKey()'>
<center>
<form name="MRBNEODT" id="MRBNEODT" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="80%" cellpadding='0' cellspacing='0'>
<th align='left' colspan='4'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
<tr>
	<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
<td>&nbsp&nbsp<select name='P_facilityid' id='P_facilityid'><!--  onChange='onChangeFacilityId()'> -->
<%
try
{
String fid;
String fname;
String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
  pstmt=con.prepareStatement(sql1);
 rset=pstmt.executeQuery();
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
if (pstmt != null) pstmt.close();

%>
</select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
	<td colspan=4>&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width="40%">
		<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>
	</td>

	<td align="left" width="15%">
		&nbsp;&nbsp;<input type="text" id='datefrom' name="p_fm_date" id="p_fm_date" size="10" maxlength="10" onBlur="CheckDate(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('datefrom');"/>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>

	</td>
	<td align="left" width="3%" class="label">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td align="left" width="42%">
		<input type="text" id='dateto' name="p_to_date" id="p_to_date" size="10" maxlength="10" onBlur="CheckDate(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dateto');"/>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td colspan=4>&nbsp;</td>
</tr>
	<tr>
         <td align="right" class="label">&nbsp;&nbsp;&nbsp;<fmt:message key="eMR.NeonatalDeathsoccuredwithin.label" bundle="${mr_labels}"/></td>
		 <td >&nbsp&nbsp<INPUT TYPE="text" name="p_days" id="p_days" size=2 maxlength=2 onKeyPress='return allowValidNumber(this, event,2,0)'>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
        <td width='10%'>&nbsp</td>
		 <td width='10%'>&nbsp</td>
      </tr>

<tr><td colspan ='4'>&nbsp;</td></tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
</form>
</center>
<%
}
catch(Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
try
	{
	if(rset	 != null)   rset.close();
	if(pstmt != null)	pstmt.close();
	}
	catch(Exception e)
{
}
	ConnectionManager.returnConnection(con,request);
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

