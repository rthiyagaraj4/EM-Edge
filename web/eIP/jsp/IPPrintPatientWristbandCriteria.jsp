<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	//String p_user_name		= (String) session.getValue( "login_user" );
	String p_locale		= (String) session.getValue( "LOCALE" );
%>

<html>
<HEAD>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eIP/js/IPPrintPatientWristband.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
</HEAD>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<%
Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null;
String sql = "";
int p_patient_id_length		= 0 ;
try
	{	
		stmt = conn.createStatement();
		sql = "select patient_id_length from mp_param " ;
		rset = stmt.executeQuery(sql);
		while (rset.next())
		{
				p_patient_id_length = rset.getInt("patient_id_length");
		}
		
%>
<form name="IPPrintPatientWristbandCriteria_form" id="IPPrintPatientWristbandCriteria_form">
<table cellpadding='0' border = '0' cellspacing='0' width='50%'>
<tr>	
	<td class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='patient_id' id='patient_id' value='' onBlur="ChangeUpperCase(this);enableID();Checkvalidpat(this);" onKeyPress='return CheckForSpecChars(event)' size='20' maxlength=<%=p_patient_id_length%> ><input type=button name=search id=search value='?'   class='button' onClick="callPatientSearch()">
</tr>
<tr>
	<td class='label'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='encounter_id' id='encounter_id' size="12" maxlength="12" onBlur='validSplchars1(this);CheckNum(this);ValidateEncID(this)' onKeyPress="return allowValidNumber(this,event,12,0)" align="center"><input type='button' name='encounter_id_but' id='encounter_id_but' value='?' class='button' onclick='encounter_search(this,encounter_id)' disabled><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<!-- <tr>
	<td>&nbsp;</td><td><input type='button' name='select' id='select' value='Select'  onclick='submitPage()'/></td>
</tr> -->
<!--<tr>
 <td class="label" width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td>
		<input type='radio' name='location_type' id='location_type' checked><fmt:message key="Common.IP.label" bundle="${common_labels}"/></input>
		<input type='radio' name='location_type' id='location_type'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></input>
		<input type='radio' name='location_type' id='location_type'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></input>
	</td>
</tr> -->

<!-- <tr>
	<td class="label" width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="location_desc" id="location_desc" size="15" maxlength="15" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, location_desc)'>
	</td>
</tr> -->
</table>
<!-- <table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
<tr>
	<td width = "75%" class='white' >&nbsp;</td>
	<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'></td>
</tr>
</table> -->
<%
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
</body>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_locale" id="p_locale"		value="<%= p_locale %>">
</form>

