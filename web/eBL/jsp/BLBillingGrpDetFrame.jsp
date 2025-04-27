<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		String params = request.getQueryString();
//		System.err.println("BLBillingGrpDetFrame.jsp:"+params);
%>


<HTML>
<HEAD>
		<title><fmt:message key="eBL.BILLING_GROUP_EXPLANATORY_NOTE.label" bundle="${bl_labels}"/></title>
</HEAD>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<iframe name='BLBillingGrpDetFrame' id='BLBillingGrpDetFrame'	src='../../eBL/jsp/BLBillingGrpDet.jsp?<%=params%>'  frameborder=0 scrolling='AUTO' noresize style='height:75vh;width:100vw'></iframe>
			<iframe name='ButtonFrame' id='ButtonFrame'		src='../../eBL/jsp/BLCloseButpage.jsp' frameborder=0 noresize scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
		
</HTML>

