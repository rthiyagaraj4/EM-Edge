<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used for Search Criteria.
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet	rs			=	null;

	String maintain_doc_or_file = "";
	//String mysql				= "SELECT maintain_doc_or_file FROM mp_param";
	String mysql				= "SELECT maintain_doc_or_file FROM mp_param where module_id='MP'";
	try
	{
		con  = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs   =  stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		}
	%>
	<html>
	<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMAssignStorageLocn.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
	<form name='FMAssnStrLocnCriteriaForm' id='FMAssnStrLocnCriteriaForm' action='' method=''>
		<table cellpadding='2' cellspacing='0' border='0' width='100%'>
		<tr>
		<%
			if(maintain_doc_or_file.equals("F"))
			{
		%>
				<td class='label' width="25%"><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></td>
				<td class='fields' width="25%"><input type='text' name='terminal_digit' id='terminal_digit' value='' size='10' maxlength='10'  onBlur='ChangeUpperCase(this);' onKeyPress='return CheckForSpecChars(event)'></td>
				<td class='label' width="25%"><fmt:message key="eFM.FileCreationDate.label" bundle="${fm_labels}"/></td>
				<td class='fields' width="25%"><input type='text' id='stolocndate' name='file_date' id='file_date' value='' size='10' maxlength='10' onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('stolocndate');"></td>
		<%
			}
			else if(maintain_doc_or_file.equals("D"))
			{
		%>
				<td colspan='4'></td>
		<%		
			}
		%>
		</tr>
		<tr><td colspan="4">
			<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.f_query_add_mod.FMAssnStrLocnCriteriaFrame"/>
				<jsp:param name="form_name" value="FMAssnStrLocnCriteriaForm"/>
				<jsp:param name="messageframe_name" value="parent.parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patient_id"/>
				<jsp:param name="fileno_name" value="file_no"/>
				<jsp:param name="filetype_name" value="file_type_code"/>
				<jsp:param name="document_type_name" value="doc_type_code"/>
				<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
				<jsp:param name="volumeno_name" value="volume_no"/>
				<jsp:param name="table_width" value="100"/>
				<jsp:param name="tablealign" value="center"/>
				<jsp:param name="volume_no_appl_yn" value="N"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			</jsp:include>
			</td>
		</tr>
		<tr align="right" ><td colspan='4' class='button'><input type='button' class='button' name='search_dtl' id='search_dtl' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='return fetchResults();'><input type='button' class='button' name='reset1' id='reset1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues();'></td></tr>
	</table>
	<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	</form>
<%
	if(rs   != null) rs.close();
	if(stmt != null) stmt.close();
	}
		catch(Exception e)
		{
			out.println("Exception e:"+e.toString());
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

