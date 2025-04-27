<%@ page contentType="text/html;charset=UTF-8" import="eST.*, eST.Common.*,eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src='../../eST/js/TransactionRemarks.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id			=		"<%= request.getParameter( "function_id" ) %>"
		</script>
	</head>
<%

		String bean_id			=		 "transactionRemarksBean";
		String bean_name		=		 "eST.TransactionRemarksBean";
		String mode				=		 request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		eST.TransactionRemarksBean transactionRemarksBean = (eST.TransactionRemarksBean) getBeanObject(bean_id,bean_name,request);
		transactionRemarksBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			transactionRemarksBean.clear();
		}
%>
	
	<iframe name="TransactionRemarksHeaderFrame" id="TransactionRemarksHeaderFrame" src="../../eST/jsp/TransactionRemarksHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:10%;width:100vw'></iframe>
	<iframe name="TransactionRemarksDetailFrame" id="TransactionRemarksDetailFrame" src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>


</html>

