<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/DefineHeader.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql			= "";
	String header_id	= request.getParameter("header_type") == null ? "" : request.getParameter("header_type");
	String field_mnemonic_desc = "";
	String field_mnemonic = "";

%>
</head>
<body onload='' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	try
	{
		con =	ConnectionManager.getConnection(request);

		sql = "SELECT field_mnemonic_desc, field_mnemonic, field_mnemonic_type, field_mnemonic_data_type, field_mnemonic_query FROM CA_MNEMONIC WHERE eff_Status = 'E' AND field_mnemonic_type = ? ORDER BY srl_no";
		
		if(header_id.equals("RH"))
		{
%>
			<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center>
			<tr>
 				<td class='columnheader' width="25%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width="25%"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width="25%">Note</td>
			</tr>
			<tr VALIGN="top">
				<td width="25%" class="label">
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"P");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					field_mnemonic_desc = rs.getString("field_mnemonic_desc") == null ? "" : rs.getString("field_mnemonic_desc");
					field_mnemonic = rs.getString("field_mnemonic") == null ? "" : rs.getString("field_mnemonic");
%>
					<tr><td class="label"><A href="javascript:setPreviewTemplate('<%=field_mnemonic%>')"><%=field_mnemonic_desc%></a></td></tr>
<%
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
%>
				</table>
				</td>
				<td width="25%" class="label">
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"E");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					field_mnemonic_desc = rs.getString("field_mnemonic_desc") == null ? "" : rs.getString("field_mnemonic_desc");
					field_mnemonic = rs.getString("field_mnemonic") == null ? "" : rs.getString("field_mnemonic");
%>
					<tr><td class="label"><A href="javascript:setPreviewTemplate('<%=field_mnemonic%>')"><%=field_mnemonic_desc%></a></td></tr>
<%
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
%>
				</table>
				</td>
				<td width="25%" class="label">
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"N");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					field_mnemonic_desc = rs.getString("field_mnemonic_desc") == null ? "" : rs.getString("field_mnemonic_desc");
					field_mnemonic = rs.getString("field_mnemonic") == null ? "" : rs.getString("field_mnemonic");
%>
					<tr><td class="label"><A href="javascript:setPreviewTemplate('<%=field_mnemonic%>')"><%=field_mnemonic_desc%></a></td></tr>
<%
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
%>
				</table>
				</td>
			</tr>
			</table> 
<%
		}
		else
		{
%>
			<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center>
			<tr>
				<td class='columnheader' width="25%">Note</td>
			</tr>
			<tr VALIGN="top">
				<td width="25%" class="label">
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"N");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					field_mnemonic_desc = rs.getString("field_mnemonic_desc") == null ? "" : rs.getString("field_mnemonic_desc");
					field_mnemonic = rs.getString("field_mnemonic") == null ? "" : rs.getString("field_mnemonic");
%>
					<tr><td class="label"><A href="javascript:setPreviewTemplate('<%=field_mnemonic%>')"><%=field_mnemonic_desc%></a></td></tr>
<%
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
%>
				</table>
				</td>
			</tr>
			</table>
<%
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

