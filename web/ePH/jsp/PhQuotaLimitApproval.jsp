<!DOCTYPE html>
 <%/* 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name		Description
--------------------------------------------------------------------------------------------------------------------
	
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePH.QuotaLimitApproval.label" bundle="${ph_labels}"/></title>

		<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			
			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<iframe name='QuotaLimitApprovalCriteriaFrame' id='QuotaLimitApprovalCriteriaFrame' src='PhQuotaLimitApprovalCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='QuotaLimitApprovalBottom' id='QuotaLimitApprovalBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe>	
</html>

