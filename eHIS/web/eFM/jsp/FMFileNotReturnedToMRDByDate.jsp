<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.*" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%
	Connection conn			= null;
	java.sql.Statement stmt	= null;
	ResultSet rst			= null;
	ResultSet rs			= null;

	String p_module_id		= "FM" ;
	String p_report_id		= "FMBRTMRD" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

	String maintain_doc_or_file = "";
	String mysql = "SELECT maintain_doc_or_file FROM mp_param";
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			maintain_doc_or_file = rst.getString("maintain_doc_or_file");
		}
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
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMCheck.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="reportDate" id="reportDate" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

			<table width='70%'  cellPadding="0" cellSpacing="0"  align='center' valign='top'>
			<tr><td class='COLUMNHEADER'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td></tr>
			</table>

			<table width='70%' cellPadding="5" border='0' cellSpacing="0"  align='center' >

			<tr>
			 	<td width='50%'  class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
				<td  class='fields'><select name="p_from_code" id="p_from_code" >
						<option value='' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						
							  try {
									 String sql = "select fs_locn_code,short_desc from fm_storage_locn_lang_vw  where EFF_STATUS='E' and facility_id='"+ p_facility_id + "' and PERMANENT_FILE_AREA_YN='Y' and language_id='"+localeName+"'";
										
									  rs = stmt.executeQuery(sql);
									  if( rs != null )
									  {
										  while( rs.next())
										  {
											String classname = rs.getString("fs_locn_code") ;
											String classname1=rs.getString("short_desc");

							%>
							
							<option value='<%= classname %>'><%= classname1%></option>
							
							<%
									  }
							  }

							}
							catch(Exception e) { out.println(e.toString());}
%>
					</select>
			   </td>
			</tr>


			<tr>
	<%		if(maintain_doc_or_file.equals("F"))
						{
	%>
							<td class='label'><fmt:message key="eFM.Filespendingformorethan.label" bundle="${fm_labels}"/></td>
<%						}
						else if(maintain_doc_or_file.equals("D"))
						{
%>
							<td class='label'><fmt:message key="eFM.Documentspendingformorethan.label" bundle="${fm_labels}"/></td>
<%
						}
%>
						<td	class='fields' ><input type='text' name='p_no_of_days' id='p_no_of_days' value=''  size="2"	maxlength="3" onBlur='CheckPositiveNumberMy(this);'>&nbsp;Days&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
					
			<tr>
<%
					  if(maintain_doc_or_file.equals("F"))
					  {
%>
					   <td  class='label'><fmt:message key="eFM.IncludeInpatients.label" bundle="${fm_labels}"/></td>
						<td class='fields' ><input type="checkbox" name="p_include_ip" id="p_include_ip" value="" ></td>
				
<%						}
						else if(maintain_doc_or_file.equals("D"))
						{
%>
							<td class="label" colspan="2">&nbsp;</td>
<%						
						}
%>
		</tr>
			</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		 value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		 value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		 value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		     value="<%= p_user_name %>">
	<input type="hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%= maintain_doc_or_file %>">
	</form>
<%	
		if(rs != null)  rs.close();
		if(rst  !=null) rst.close();
		if(stmt !=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception "+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
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

