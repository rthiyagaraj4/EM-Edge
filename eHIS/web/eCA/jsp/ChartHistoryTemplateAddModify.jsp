<!DOCTYPE html>
<%@page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head> 
		<title><fmt:message key="eCA.ChartTemplateCreate.label" bundle="${ca_labels}"/></title> 
		<script language="javascript" src="../js/ChartHistoryTemplate.js"></script>
<%

		request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<!-- Modified by kishore kumar N on 08/12/2008 for the CRF 0387
	altered the frameset size.
-->
		<iframe name="HeaderFrame" id="HeaderFrame" src="../../eCA/jsp/DynamictabHrd.jsp" frameborder="0" scrolling="no" noresize style="height:20vh;width:100vw"></iframe>
		<iframe name="DetailsFrame" id="DetailsFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" noresize style="height:78vh;width:100vw"></iframe>
	
</html>

