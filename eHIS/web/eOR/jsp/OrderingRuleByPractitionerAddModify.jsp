<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--OrderingRuleByPractitionerAddModify.jsp -->
<%--
*	Copyright � IBA Health India (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eOR
*	Purpose 		:	
*	Created By		:	Harichandra Reddy 
*	Created On		:	03 Aug 2007

--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>

<%
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
 	<script language="JavaScript" src="../../eOR/js/OrderingRuleByPractitioner.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String mode			= request.getParameter("mode");

	mode = mode.trim();
	if(!(mode.equals("2"))){
		mode = "1";
	}
%>
	<iframe name='dept_only_Catalog_appl_header' id='dept_only_Catalog_appl_header' src='OrderingRuleByPractitionerAddModifyHeader.jsp?function_id=<%=function_id%>&mode=<%=java.net.URLEncoder.encode(mode)%>' frameborder=0 scrolling='no' noresize style='height:13vh;width:99vw'></iframe>
		<iframe name='dept_only_Catalog_appl_middle' id='dept_only_Catalog_appl_middle' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:80vh;width:99vw'></iframe>
</html>									

