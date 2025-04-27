<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
try
{
	con =ConnectionManager.getConnection(request);
	//String practitioner_id=(String)session.getValue("ca_practitioner_id");
	String delete = "delete CA_CLIN_ALERT /*WHERE PRACTITIONER_ID=?*/";
	pstmt = con.prepareStatement(delete);
	pstmt.executeUpdate();
	con.commit();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in CAMainHomeRemoveAlerts.jsp: "+e.toString());//common-icn-0181
	out.println("top.content.alertFrame.location.href='../../eCommon/jsp/error.jsp'");
	e.printStackTrace();//COMMON-ICN-0181
	
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
</BODY>
<script>top.content.alertFrame.location.href="../../eCommon/jsp/error.jsp";</script>
</HTML>

