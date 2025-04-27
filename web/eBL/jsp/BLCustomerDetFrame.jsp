<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
		String params = request.getQueryString();
//		System.err.println("BLCustomerDetFrame.jsp:"+params);
%>

<HTML>
<HEAD>
		<title><fmt:message key="eBL.CUSTOMER_DTL.label" bundle="${bl_labels}"/></title>
</HEAD>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<iframe name='BLCustomerDetFrame' id='BLCustomerDetFrame'	src='../../eBL/jsp/BLCustomerDet.jsp?<%=params%>'  frameborder=0 scrolling='AUTO' noresize style='height:80vh;width:100vw'></iframe>
			<iframe name='ButtonFrame' id='ButtonFrame'		src='../../eBL/jsp/BLCloseButpage.jsp' frameborder=0 noresize scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
		
</HTML>

