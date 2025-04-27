<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay.
*	Created On		:	05 Jul 2005
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<!--//This file is saved on 18/10/2005.-->
<TITLE><fmt:message key="eCP.MarkEvaluationError.label" bundle="${cp_labels}"/></TITLE>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/EvaluateCarePlanMarkError.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name='eval_cp_mrk_err_hdr' id='eval_cp_mrk_err_hdr' src='../../eCP/jsp/EvaluateCarePlanMarkErrorHeader.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name='eval_cp_mrk_err_dtl' id='eval_cp_mrk_err_dtl' scrolling='auto'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='eval_cp_dyn_val' id='eval_cp_dyn_val' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0%;width:100vw'></iframe>

</head>
</html>

