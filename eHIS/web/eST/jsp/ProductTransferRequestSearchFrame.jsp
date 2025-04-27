<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.ProductTransferRequestSearch.label" bundle="${st_labels}"/></title>
		<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->	
<!--	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/BatchSearch.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javaScript" src="../../eST/js/ProductTransfer.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<iframe name='frameProductTransferRequestSearchQueryCriteria' id='frameProductTransferRequestSearchQueryCriteria'				src="../../eST/jsp/ProductTransferRequestSearchQueryCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='frameProductTransferRequestSearchQueryResult' id='frameProductTransferRequestSearchQueryResult'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"	frameborder=0 scrolling='auto'   noresize style='height:91vh;width:100vw'></iframe> 
	
</html>

