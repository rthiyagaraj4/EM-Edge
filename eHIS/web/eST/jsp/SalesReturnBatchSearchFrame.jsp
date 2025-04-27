<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.SalesBatchSearch.label" bundle="${st_labels}"/></title>
		<meta name="Author" content="Rammohan">
		<%
		request.setCharacterEncoding("UTF-8");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturnBatchSearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<iframe name='frameSalesReturnBatchSearchQueryCriteria' id='frameSalesReturnBatchSearchQueryCriteria' src="../../eST/jsp/SalesReturnBatchSearchQueryCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:20%;width:100vw'></iframe>
		<iframe name='frameSalesReturnBatchSearchQueryResult' id='frameSalesReturnBatchSearchQueryResult'   src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

