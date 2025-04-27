<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used for Search Sub Result.
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs			=	null;

	
	String fs_locn_code = "";
	String fs_desc		= "";

	String facility_id			=	(String)session.getValue("facility_id");
	String sql_query = "";

	String file_type_appl_yn	=	request.getParameter("file_type_appl_yn");
	String maintain_doc_or_file	=	request.getParameter("maintain_doc_or_file");
	String whereClause			=   request.getParameter("whereClause");
	
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
	if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) maintain_doc_or_file = "";
	if(whereClause == null || whereClause.equals("null")) whereClause = "";

	try
	{
		con		=	ConnectionManager.getConnection(request);
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMAssignStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMAssnStrLocnSubResultForm' id='FMAssnStrLocnSubResultForm' action='' method=''>
	<table cellpadding='0' cellspacing='0' border='0' width='100%'>
	<tr>
		<%if(maintain_doc_or_file.equals("F")){%>
		<td class='label' width='25%'><fmt:message key="eFM.AssignAllFilesTo.label" bundle="${fm_labels}"/>
		<%}else if(maintain_doc_or_file.equals("D")){%>
		<td class='label' width='25%'><fmt:message key="eFM.AssignAllDocumentsTo.label" bundle="${fm_labels}"/>
		<%}%>
		</td><td class='fields' colspan='3'><select name='locn_code' id='locn_code' onChange='checkAll(this)'>
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
	stmt	=	con.createStatement();
/*	Properties prop	=	new Properties();
	prop.put("Statement",stmt);
	prop.put("facility_id",facility_id);
	rs	=	eFM.FMUtilities.getStorageLocn(prop);
*/
	//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";				
	sql_query="SELECT   fs_Locn_Code,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) Short_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"' AND  Permanent_File_Area_yn = 'Y' AND eff_Status = 'E' ORDER BY Short_desc";				

	rs		=	stmt.executeQuery(sql_query);
			
			
	while(rs != null && rs.next())
		{
			fs_locn_code	=	rs.getString("fs_locn_code");
			fs_desc			=	rs.getString("short_desc");
			out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
		}
		rs.close();
	
%>
</select></td>
	<input type='hidden' name='CBValStr' id='CBValStr' value=''>
	<input type='hidden' name='LocnValStr' id='LocnValStr' value=''>
	<input type='hidden' name='locn_code_main' id='locn_code_main' value=''>
	<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value='<%=maintain_doc_or_file%>'>
	<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
</tr>
</table>
</form>
<%
if(rs != null) rs.close();
if(stmt != null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception while fetching connection"+e);
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
<script>
	var whereClause = "<%=whereClause%>";
	callMainResultPage(whereClause);
</script>
</body>
</html>

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

