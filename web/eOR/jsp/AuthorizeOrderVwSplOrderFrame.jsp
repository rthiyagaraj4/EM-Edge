<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<title><fmt:message key="Common.SpecialApproval.label" bundle="${common_labels}"/></title>
<iframe name='SplApprvlTop' id='SplApprvlTop' src='AuthorizeOrderVwSplOrder.jsp' frameborder=0  noresize style='height:84vh;width:100vw'></iframe>
	<iframe name='SplApprvlDtl' id='SplApprvlDtl' src='AuthorizeOrderVwSplBtn.jsp' frameborder=0 noresize style='height:16vh;width:100vw'></iframe>


