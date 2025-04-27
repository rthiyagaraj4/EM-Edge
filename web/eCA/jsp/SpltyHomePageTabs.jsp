<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>

	<head>
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../../eCA/js/SpltyHomePage.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<form name='matConsTabsForm' id='matConsTabsForm'>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
		<center>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
				<tr>
					<td width= "100%" class="white">
						<ul id="tablist" class="tablist" >
						<li class="tablistitem" title=''>
						<a onclick='loadHomePage();' class='tabClicked' id='home_tab'><span class='tabSpanclicked' id='home_tabspan'><b><fmt:message key="Common.home.label" bundle="${common_labels}"/></b></span></a></li>
						<a onclick='loadHistoryPage();' class='tabA' id='hist_tab'><span class='tabAspan' id='hist_tabspan'><b><fmt:message key="Common.History.label" bundle="${common_labels}"/></b></span></a> </li>		</td></tr></table></center></body>
	<input type='hidden' name='queryString' id='queryString' value='<%=queryString%>'>
	<script>loadHomePage();</script>
	</form>
</html>

