<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		String params = request.getQueryString();

		String function_id = request.getParameter("function_id");
%>
<HTML>
<HEAD>
<%
	if(function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS"))
	{
%>
<title><fmt:message key="eBL.OP_OVERRIDE_REIM_DTLS.label" bundle="${bl_labels}"/></title>
<%
	}
	else if(function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS"))
	{
%>
<title><fmt:message key="eBL.IP_OVERRIDE_REIM_DTLS.label" bundle="${bl_labels}"/></title>
<%
	}
	else if(function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS"))
	{
%>
<title><fmt:message key="eBL.OP_OVERRIDE_UNBLD_REIM_DTLS.label" bundle="${bl_labels}"/></title>
<%
	}
	else if(function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
	{
%>
<title><fmt:message key="eBL.IP_OVERRIDE_UNBLD_REIM_DTLS.label" bundle="${bl_labels}"/></title>
<%
	}
%>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='BillReimbAmtFrame' id='BillReimbAmtFrame'	src='BLBillReimburseAmtFrame.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:83vh;width:100vw'></iframe>
			<iframe SRC="../../eCommon/html/blank.html"	  name="messageFrame" id="messageFrame" frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
</HTML>

