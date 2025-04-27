<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
		<!-- <script language="javascript" src="../../eCommon/common/common.js"></script> -->
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src='../../eSS/js/SsTransactionRemarks.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id			=		"<%= request.getParameter( "function_id" ) %>"
		</script>
	</head>
<%

		String bean_id			=		 "SsTransactionRemarksBean";
		String bean_name		=		 "eSS.SsTransactionRemarksBean";
		String mode				=		 request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		eSS.SsTransactionRemarksBean SsTransactionRemarksBean = (eSS.SsTransactionRemarksBean) getBeanObject(bean_id,bean_name,request);
		SsTransactionRemarksBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			SsTransactionRemarksBean.clear();
		}
%>
	
	<iframe name="SsTransactionRemarksHeaderFrame" id="SsTransactionRemarksHeaderFrame" src="../../eSS/jsp/SsTransactionRemarksHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name="SsTransactionRemarksDetailFrame" id="SsTransactionRemarksDetailFrame" src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:90vh;width:100vw'></iframe>


</html>

