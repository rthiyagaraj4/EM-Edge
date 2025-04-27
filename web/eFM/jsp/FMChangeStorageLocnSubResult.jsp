<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Change File Store Location
	Function		:	This function is used for Search Sub Result.
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String fs_locn_code	= "", fs_desc = "", fs_locn = "";
	String facility_id	=	(String)session.getValue("facility_id");
	String sql_query ="";
    String added_temp_code=request.getParameter("added_temp_code");
	String patient_id			=   request.getParameter("patient_id");
	String file_type_code		=   request.getParameter("file_type_code");
	String file_no				=   request.getParameter("file_no");
	String volume_no			=   request.getParameter("volume_no");
	String whereClause			=   request.getParameter("whereClause");
	String whereClause1			=   request.getParameter("whereClause1");
	String file_type_appl_yn	=	request.getParameter("file_type_appl_yn");
	String maintain_doc_or_file	=	request.getParameter("maintain_doc_or_file");
	String storage_locn             =request.getParameter("storage_locn");
	fs_locn						    =	request.getParameter("fs_locn");
	String terminaldigit        =	request.getParameter("terminaldigit");
	if(terminaldigit == null || terminaldigit.equals("null"))
		terminaldigit = "";
		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
		maintain_doc_or_file = "";
	if(patient_id == null || patient_id.equals("null"))
		patient_id = "";
	if(file_type_code == null || file_type_code.equals("null"))
		file_type_code = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
		file_type_appl_yn = "";
	if(whereClause == null || whereClause.equals("null"))
		whereClause = "";
	if(fs_locn==null || fs_locn.equals("null")) fs_locn = "P";
   if(added_temp_code==null || added_temp_code.equals("null")) added_temp_code = "";
	try
	{
		con	 =	ConnectionManager.getConnection(request);
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
			<script language='javascript' src='../../eFM/js/FMChangeStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
		<form name='FMChngStrLocnSubResultForm' id='FMChngStrLocnSubResultForm' action='' method=''>
		<table cellpadding='2' cellspacing='0' border='0' width='100%'>
			<tr><td class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
			<td width='75%' class='fields'><select name='locn_code' id='locn_code' onChange='checkAll(this,"onchnge")'>
			<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
	stmt			= con.createStatement();
/*	Properties prop	= new Properties();
	prop.put("Statement",stmt);
	prop.put("facility_id",facility_id);
	prop.put("fs_locn",fs_locn);
	rs	=	eFM.FMUtilities.getStorageLocn(prop);*/
			
			if(fs_locn.equals("C"))
				{
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
					sql_query = "SELECT fs_Locn_Code  ,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) Short_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"'     AND eff_Status = 'E' ORDER BY Short_desc";

				}
				else
				{
							sql_query = "SELECT fs_Locn_Code ,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) Short_desc FROM  FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"'    AND Permanent_File_Area_yn = 'Y'  AND eff_Status = 'E'   ORDER BY Short_desc";

				}

				rs		=	stmt.executeQuery(sql_query);
			
			
				while(rs != null && rs.next())
	{
		fs_locn_code	= rs.getString("fs_locn_code");
		fs_desc			= rs.getString("short_desc");
		out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
	}
%>		
		</select></td></tr>
		<input type='hidden' name='fm_cnt' id='fm_cnt' value='' >
		<input type='hidden' name='to_cnt' id='to_cnt' value='' >
		<input type='hidden' name='CBValStr' id='CBValStr' value='' >
		<input type='hidden' name='LocnValStr' id='LocnValStr' value='' >
		<input type='hidden' name='sel_all' id='sel_all' value='false'>
        <input type='hidden' name='fs_locn' id='fs_locn' value='<%=fs_locn%>' >
		<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value='<%=maintain_doc_or_file%>' >
		<input type='hidden' name='flag' id='flag' value='' >
		<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value="<%=file_type_appl_yn%>" >
		<input type='hidden' name='whereClause' id='whereClause' value="" >
		<input type='hidden' name='from' id='from' value="" >
		<input type='hidden' name='to' id='to' value="" >
	</table>
</form>
<script>
	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
	var whereClause = "<%=whereClause%>";
	var whereClause1 = "<%=whereClause1%>";
	var fs_locn = "<%=fs_locn%>";
	var patient_id = "<%=patient_id%>";
	var file_type_code = "<%=file_type_code%>";
	var file_type_appl_yn = "<%=file_type_appl_yn%>";
	var volume_no = "<%=volume_no%>";
	var file_no = "<%=file_no%>";
	var storage_locn = "<%=storage_locn%>";
	var terminaldigit  = "<%=terminaldigit%>";
	var added_temp_code = "<%=added_temp_code%>";
	if(maintain_doc_or_file == 'D')
	{
		
		
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTChangeStorageLocnMainResult.jsp' target='FMChngStrLocnMainResultFrame'><input name='whereClause' id='whereClause' type='hidden' value=\""+whereClause+"\"><input name='whereClause1' id='whereClause1' type='hidden' value=\""+whereClause1+"\"><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='file_type_code' id='file_type_code' type='hidden' value="+file_type_code+"><input name='terminaldigit' id='terminaldigit' type='hidden' value="+terminaldigit+"><input name='added_temp_code' id='added_temp_code' type='hidden' value="+added_temp_code+"></form></BODY></HTML>";

		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit();
	}
	else
	{
		//parent.FMChngStrLocnMainResultFrame.location.href="../../eFM/jsp/FMChangeStorageLocnMainResult.jsp?file_type_appl_yn=<%=file_type_appl_yn%>&whereClause=<%=whereClause%>&fs_locn=<%=fs_locn%>&file_no=<%=file_no%>&volume_no=<%=volume_no%>";

		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMChangeStorageLocnMainResult.jsp' target='FMChngStrLocnMainResultFrame'><input name='whereClause' id='whereClause' type='hidden' value=\""+whereClause+"\"><input name='whereClause1' id='whereClause1' type='hidden' value=\""+whereClause1+"\"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='fs_locn' id='fs_locn' type='hidden' value="+fs_locn+"><input name='file_no' id='file_no' type='hidden' value="+file_no+"><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='file_type_code' id='file_type_code' type='hidden' value="+file_type_code+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='storage_locn' id='storage_locn' type='hidden' value="+storage_locn+"><input name='terminaldigit' id='terminaldigit' type='hidden' value="+terminaldigit+"><input name='added_temp_code' id='added_temp_code' type='hidden' value="+added_temp_code+"></form></BODY></HTML>";
		//alert(HTMLVal);

		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit();

	}
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
</script>
<%
if(rs !=null)	 rs.close();
if(stmt != null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception while fetching connection"+e);
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
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

