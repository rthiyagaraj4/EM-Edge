<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBNPRFX" ;

	request.setCharacterEncoding("UTF-8");
	int length_prefix = 0;
	String name_prefix = "";
	Connection con=null;
	java.sql.Statement stmt	= null;
	ResultSet rset	= null ;
	
	try
	{
		con = ConnectionManager.getConnection(request);	
		String sql = "Select  PAT_NAME_AS_MULTIPART_YN from mp_param";
		stmt = con.createStatement();
	    rset = stmt.executeQuery(sql);
	    if( rset != null ){
	         while( rset.next()){
		       	 name_prefix = rset.getString("PAT_NAME_AS_MULTIPART_YN") ;
			 }
		 }
		if (name_prefix.equals("Y"))
			length_prefix = 8;
		else
			length_prefix = 40;		
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>

<HEAD>
<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eMP/js/MPReportMasterList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repNamePrefixList" id="repNamePrefixList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='85%' align='center' valign='top'>

		<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="85%" class="Border" >
				<table width='85%' cellPadding="3" cellSpacing="0" align='center'>
					<tr>
						<td width="35%">&nbsp;</td>
						<td class="querydata"  width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata"  width="45%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></td>
						<td  class='fields' ><input type=text  name='p_fm_name_prefix' id='p_fm_name_prefix' size="<%=length_prefix%>" maxlength="<%=length_prefix%>"><input type='button' name='namePrefix' id='namePrefix' value='?' class='button' onclick='callSearch(this, p_fm_name_prefix)'>
						</td>
						<td class='fields'><input type=text  name='p_to_name_prefix' id='p_to_name_prefix' size="<%=length_prefix%>" maxlength="<%=length_prefix%>"><input type='button' name='namePrefix' id='namePrefix' value='?' class='button' onclick='callSearch(this, p_to_name_prefix)'>
						</td>
					</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class='fields' ><select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= session.getValue( "facility_id" ) %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=  session.getValue( "login_user" ) %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
<%}catch(Exception e){/* out.println("tst "+e); */ e.printStackTrace(); }
    finally{
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
        if(con!=null) ConnectionManager.returnConnection(con,request);
    }
%>
</BODY>
</HTML>

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

