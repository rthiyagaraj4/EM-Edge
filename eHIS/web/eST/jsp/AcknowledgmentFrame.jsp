<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<meta name="Author" content="Mahesh">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
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
<iframe name='frameAcknowledgeHeader' id='frameAcknowledgeHeader'	src="../../eST/jsp/AcknowledgmentHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:14vh;width:100vw'></iframe>
		<iframe name='frameAcknowledgeDetail' id='frameAcknowledgeDetail'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto'   noresize style='height:50vh;width:99vw'></iframe>
		<iframe name='frameAcknowledgeList' id='frameAcknowledgeList'		src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:41vh;width:99vw'></iframe>
	
</html>

