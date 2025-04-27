<!DOCTYPE html>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Created By		:	Bangarraju
*	Created On		:	10 Jan 2007
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/EquivalentTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String type_set = request.getParameter("type_set");
	//String source = url + params ;
	 
%>

<iframe name="f_query_criteria" id="f_query_criteria" frameborder=0  scrolling='auto' noresize src="../../eMR/jsp/EquivalentTermCode2.jsp?<%=params%>" style='height:22vh;width:100vw'></iframe>
<iframe name="f_batch_result" id="f_batch_result" frameborder=0 scrolling="auto" noresize src="../../eMR/jsp/EquivalentTermCodeResult.jsp?type_set=<%=type_set%>" style="height:100vh;width:98vw"></iframe>
</head>
</html>

