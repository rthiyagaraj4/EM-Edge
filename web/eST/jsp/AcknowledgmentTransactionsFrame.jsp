<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<meta name="Author" content="Mahesh">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/Acknowledgment.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<%
		String locale			= (String)session.getAttribute("LOCALE");
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);

%>
<iframe name='frameAcknowledgementTransactionsCriteria' id='frameAcknowledgementTransactionsCriteria'	src="../../eST/jsp/AcknowledgmentTransactionsCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:13%;width:100vw'></iframe>
		<iframe name='frameAcknowledgementTransactionsResult' id='frameAcknowledgementTransactionsResult'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto'   noresize style='height:100vh;width:100vw'></iframe>
	<iframe name="colorIndicators" id="colorIndicators" src="../../eST/jsp/AckTransColorIndicator.jsp" frameborder="0" noresize scrolling="no" style="height:3%;width:100vw"></iframe>
</html>

