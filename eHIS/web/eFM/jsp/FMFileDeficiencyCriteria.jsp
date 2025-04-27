<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBDFCRT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMFileDeficiencyReport.js" language="javascript"></script>
<script src="../../eFM/js/WorkLoadStatistics.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="document.forms[0].p_from_date.focus()" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="Criteria" id="Criteria" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 <%
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rset=null;
	String today ="";
	String sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
 
 try
 {
	
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
	if (rset.next())
	{
	today = rset.getString("today");
	}
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
 }
 	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>

			<table width='70%' cellPadding="5" cellSpacing="0"  align='center' >

			<tr>
					<td  colspan="4" class='label'>&nbsp;</td>
			</tr>

			<tr>
					<td  class='label' width='30%'>&nbsp;</td>
					<td  class='querydata' width='30%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td  class='label' width='10%'>&nbsp;</td>
					<td  class='querydata' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>		

			<tr>
						<td class='label'><fmt:message key="Common.ReportedDate.label" bundle="${common_labels}"/></td>
						<td	class='fields' ><input type='text' id="date_from"
						name='p_from_date' id='p_from_date' value=''  size="10"	maxlength="10" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">
						<td class='label'>&nbsp;</td>
						<td class='fields' ><input type='text' id="date_to"
						name='p_to_date' id='p_to_date' value=''  size="10"	maxlength="10" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>		
			
		<tr>
						<td class='label'><fmt:message key="eFM.DeficiencyCriteria.label" bundle="${fm_labels}"/></td>
						<td class='fields' colspan="3" ><select name='p_from_code' id='p_from_code' >
						<option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value='O' ><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='C' ><fmt:message key="Common.close.label" bundle="${common_labels}"/></option>
						</select></td>
			</tr>		

			<tr><td colspan="4" class='label'>&nbsp;</td></tr>			
			
			</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="today" id="today"				value="<%=today%>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</BODY>
</HTML>

