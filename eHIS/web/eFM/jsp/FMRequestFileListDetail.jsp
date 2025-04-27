<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBREQLS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
	<TITLE></TITLE>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%> 

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src="../../eFM/js/checkSystemDate.js"></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eFM/js/FMRepRequestFileList.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onMouseDown="CodeArrest();" onLoad="document.forms[0].p_iss_fs_locn.focus()" onKeyDown = 'lockKey();'>
	<br><br><br><br><br><br><br><br>
	<form name="RequestFileList" id="RequestFileList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 <%
	Connection conn			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rset			= null;
	ResultSet rs			= null;

	String today		= "";
	String doc_or_file  = "";

	String sql  = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
	String sql2 = "select maintain_doc_or_file from mp_param";

	StringBuffer sb = new StringBuffer();

	String itemDescription	= "";
	String itemCOde			= "";
 
	try
	{
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
		if(rset.next())
		{
			today = rset.getString("today");
		}
		if(rset!=null)	rset.close();
		rs = stmt.executeQuery(sql2);
		if(rs.next())
		{
			doc_or_file = rs.getString("maintain_doc_or_file");
		}
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();

		sql ="SELECT fs_locn_code,short_desc FROM fm_storage_locn_lang_vw WHERE facility_id = '"+p_facility_id+"' AND mr_locn_yn = 'Y' AND permanent_file_area_yn = 'Y' AND eff_status = 'E' and language_id='"+localeName+"' ORDER BY 2 ";
		sb.append("<option value=''>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>");
		stmt = conn.createStatement();		
		rset = stmt.executeQuery(sql);
		if(rset!=null)
		{
			while(rset.next())
			{
				itemDescription = rset.getString("short_desc");
				itemCOde	     = rset.getString("fs_locn_code");
				sb.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
			}
		}

		if(rset!=null)	rset.close();
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e) { out.println(e); }
	finally
	{	
		ConnectionManager.returnConnection(conn,request);
	}
%>
	<table width='70%' cellPadding="5" cellSpacing="0"  align='center' >
		<tr>
			<td   colspan="4" class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td  class='label' width='30%'>&nbsp;</td>
			<td  class='querydata' width='30%'><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
			<td  class='label' width='10%'>&nbsp;</td>
			<td  class='querydata' width='30%'><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eFM.IssuingFSLocation.label" bundle="${fm_labels}"/></td>
			<td	class='fields' colspan='3'><select name='p_iss_fs_locn' id='p_iss_fs_locn'  onChange=''><%=sb.toString()%></select><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/></td>
			<td	class='fields'><input type='text' id="req_date_from"
			name='p_from_date' id='p_from_date' value=''  size="10"	maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>');DateCompare(this, p_to_date, 'messageFrame','Request Date');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_from_date.focus();return showCalendar('req_date_from');">
			<td class='label' >&nbsp;</td>
			<td class='fields' ><input type='text' id="req_date_to" 
			name='p_to_date' id='p_to_date' value=''  size="10"	maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>');DateCompare(p_from_date, this, 'messageFrame','Request Date');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date.focus(); return showCalendar('req_date_to');"></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<td	class='fields' colspan='3'><select name='p_order_by' id='p_order_by' onChange="callreport(this)">
			<option value="1" selected><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></option>
			<% if(doc_or_file.equals("F")) { %>
				<option value="2"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
			<% } %>
				</select></td>
			</td>
		</tr>
		<tr><td colspan="4" class='label'>&nbsp;</td></tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="today" id="today"				value="<%=today%>">
	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

