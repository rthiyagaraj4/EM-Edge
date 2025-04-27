<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src="../../eMP/js/repPreMaturedList.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String p_module_id	= "MP" ;
String p_report_id	= "MPBPREBT" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
String unit_of_gest_nb = "";
String Sdate = "";
Connection con = null;
Statement stmt = null;
ResultSet rset = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
<form name="PrematuredList" id="PrematuredList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="70%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='40%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
	<td width='5%'>&nbsp;</td>
	<td width='25%'>&nbsp;</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='P_facilityid' id='P_facilityid'>
<%
try
{

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt	= new java.util.Date() ;

	Sdate = dateFormat.format(dt) ;

con = ConnectionManager.getConnection(request);
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
   if (rset != null) rset.close();
   //if (stmt != null) stmt.close();

   String sql_new = "select unit_of_gest_nb from mp_param";

   rset=stmt.executeQuery(sql_new);

   if(rset!=null && rset.next()) {
		unit_of_gest_nb = rset.getString("unit_of_gest_nb");	
		      
   }
    if(unit_of_gest_nb==null || unit_of_gest_nb=="")unit_of_gest_nb="";
   if (rset != null) rset.close();
   if (stmt != null) stmt.close();
}
}catch(Exception e)
{
	out.println(e);
	e.printStackTrace();
}
finally
{
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</select>
</td>
<td >&nbsp;</td>
<td >&nbsp;</td>
</tr>
 <tr>
	<td class="label" ><fmt:message key="eMP.ChildBirthDateFrom.label" bundle="${mp_labels}"/></td>
	<td class='fields' ><input type="text" name="p_date_from" id="p_date_from" size="10" maxlength="10"  onblur='chkFromToDate(this);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="text" name="p_date_to" id="p_date_to" size="10" maxlength="10"  onblur='chkFromToDate(this);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</tr>
	
<tr>
		<td  class="label" width="25%"><fmt:message key="eMP.PrematureCutOffPeriod.label" bundle="${mp_labels}"/></td>
		<td  class='fields' width="25%"><input type=text  name='p_wk_gest_period' id='p_wk_gest_period' size="3" maxlength="3" align="center" onKeyPress='return(ChkNumberInput(this,event,0))' onblur='enableGestDays(this);'><img align="center" src="../../eCommon/images/mandatory.gif"><%if(unit_of_gest_nb.equals("W")) { %>
			<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text' disabled name='p_gest_period' id='p_gest_period' size="2" maxlength="1" align="center" onKeyPress='return(ChkNumberInput(this,event,0));' onblur='validateDate(this);'> <fmt:message key="Common.days.label" bundle="${common_labels}"/>
		<% } else { 
					%>
				<fmt:message key="Common.days.label" bundle="${common_labels}"/>
				<input type="hidden" name="p_gest_period" id="p_gest_period"	value=""><%}%>
		</td>
		<td >&nbsp;</td>
		<td >&nbsp;</td>		
</tr>

 </table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	<input type="hidden" name="currdate" id="currdate"		value="<%= Sdate %>">
     <input type="hidden" name="unit_of_gest_nb" id="unit_of_gest_nb"		value="<%=unit_of_gest_nb%>">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</center>
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

