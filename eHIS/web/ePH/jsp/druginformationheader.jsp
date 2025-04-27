
 <!--
Fine Tuning
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<head>
		<title></title>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/FDBDrugInfo.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>

<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<table id="TblInfo" name="TblInfo" id="TblInfo" width="100%"  >
			<TR><Th align="left" id="header"><fmt:message key="ePH.DrugInformation.label" bundle="${ph_labels}"/></Th></TR>
</table>
</BODY>
</HTML>

