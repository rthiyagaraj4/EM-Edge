<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cust_code=request.getParameter("cust_code");
	String policy_code=request.getParameter("policy_code");

	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	
	//out.println("<script>alert('"+cust_code+"')</script>");
	//out.println("<script>alert('"+policy_code+"')</script>");

	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	policy_code = java.net.URLEncoder.encode(policy_code);
%>
<html>	
<head>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<iframe SRC="BLPolicyExclusion.jsp?cust_code=<%=cust_code%>&policy_code=<%=policy_code%>" name='frameExclu' id='frameExclu frameborder=1 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe SRC="BLPolicyInclusion.jsp?cust_code=<%=cust_code%>&policy_code=<%=policy_code%>" frameborder=1 name='frameInclu' id='frameInclu' scrolling='no' noresize style='height:62vh;width:100vw'></iframe>


</html>

