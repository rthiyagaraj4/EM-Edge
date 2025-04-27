<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../js/Orderable.js"></script>
	<Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script> 

	
	
<html><head>
<head> 


<title><fmt:message key="Common.Order.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></title></head>
<body>
<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center' id='tableId' class='grid'>
		<td class='columnHeadercenter'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='columnHeadercenter'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='columnHeadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</table>
</body>
</html>

