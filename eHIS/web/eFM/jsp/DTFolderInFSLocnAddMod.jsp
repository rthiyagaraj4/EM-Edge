<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>

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

	<script language="javascript" src="../../eFM/js/DTFolderInFSLocn.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="DTFolderInFSLocnForm" id="DTFolderInFSLocnForm" action="">
<table cellpadding="0" cellspacing="0" border="0" width="100%"> 
<tr>
	<td class="LABEL" width="40%"><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>

	<td width="60%" class='fields'><select name="fs_location" id="fs_location" onChange="getValidRecords(this.value);">
	<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	<%
		Connection connection	=	null;
		PreparedStatement pstmt	=	null;
		ResultSet	rset		=	null;
		
		try
		{
			String facility_id		= checkForNull((String) session.getAttribute("facility_id"));
			String fs_location_id	= "";	
			connection	=	ConnectionManager.getConnection(request);
			pstmt		=	connection.prepareStatement(" SELECT fs_locn_code, short_desc FROM fm_storage_locn WHERE facility_id = ? AND eff_status = 'E' AND permanent_file_area_yn = 'Y'");
			pstmt.setString(1, facility_id);
			rset =	pstmt.executeQuery();
			if (rset!=null)
			{
				while(rset.next())
				{
					fs_location_id = checkForNull(rset.getString("fs_locn_code"));
				%>
				<option value='<%=fs_location_id%>'><%=checkForNull(rset.getString("short_desc"))%></option>
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

