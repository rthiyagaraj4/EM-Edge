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
*	Created On		:	19 Mar 2005
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<!--//This file is saved on 18/10/2005.-->
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<iframe name='eval_cp_criteria' id='eval_cp_criteria' src='../../eCP/jsp/EvaluateCarePlanCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:18%;width:100vw'></iframe>
	<iframe name='eval_cp_result' id='eval_cp_result' scrolling='auto'	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='eval_cp_dyn_val' id='eval_cp_dyn_val' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0%;width:100vw'></iframe>
	<iframe name='eval_cp_addmod' id='eval_cp_addmod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0%;width:100vw'></iframe>

</head>
</html>

