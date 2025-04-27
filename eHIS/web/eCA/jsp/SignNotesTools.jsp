<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con  = null;
	ResultSet rs = null;
	PreparedStatement	pstmt	= null;
	String figer_print_auth_yn="";
	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String login_user = (String) session.getValue("login_user");
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select FIGER_PRINT_AUTH_YN from ca_note_param");
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			figer_print_auth_yn = rs.getString("FIGER_PRINT_AUTH_YN");
		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<html>
<head>
	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/SignNotes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<form>
<table cellpadding=3 cellspacing=0 width="100%" align=center>
<tr>
	<td class=BODYCOLORFILLED align=right><input type="button" class=button name='sign' id='sign'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")%>'
	onClick="record()"></td>
	
</tr>
</table>
<input type='hidden' name ='user_id' value='<%=login_user%>' >
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name ='figer_print_auth_yn' value='<%=figer_print_auth_yn%>' >

</form>
<!-- <OBJECT ID="WebFp"
	CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F"
	CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT></OBJECT> -->
</body>
</html>

