<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eFM/js/FMDocumentTypeFolder.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="FMDocumentContentForm" id="FMDocumentContentForm" action="">
<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
<tr>
	<td class="LABEL" width="40%"><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></td>

	<td width="60%" class='fields'><select name="document_id" id="document_id" onChange="getValidRecords(this.value);">
	<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	<%
		Connection connection	=	null;
		PreparedStatement pstmt	=	null;
		ResultSet	rset		=	null;			
		try
		{
			String facility_id	= checkForNull((String) session.getAttribute("facility_id"));
			String folder_name	= "";	
			connection	=	ConnectionManager.getConnection(request);
			pstmt		=	connection.prepareStatement(" SELECT doc_folder_id, doc_folder_name FROM fm_doc_folder WHERE facility_id = ? AND eff_status = 'E' ORDER BY doc_folder_name");
			pstmt.setString(1, facility_id);
			rset =	pstmt.executeQuery();
			if (rset!=null)
			{
				while(rset.next())
				{
					folder_name = checkForNull(rset.getString("doc_folder_id"))+"$$"+checkForNull(rset.getString("doc_folder_name"));
				%>
				<option value='<%=folder_name%>'><%=checkForNull(rset.getString("doc_folder_name"))%></option>
				<%
				}
			}
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception : " + e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(connection, request);
		}
	%>	
	</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>
</table>
</form>
<script>
	parent.resultFrame.document.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
</script>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return (((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>

