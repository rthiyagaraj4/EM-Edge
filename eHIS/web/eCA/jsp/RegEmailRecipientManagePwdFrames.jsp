<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
		<title><fmt:message key="eCA.ManagePassword.label" bundle="${ca_labels}"/></title>
		<iframe name='RegEmailRecipientManagePwdTop' id='RegEmailRecipientManagePwdTop' src="RegEmailRecipientManagePwdTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noResize style='height:50%;width:100vw'></iframe>
			<iframe name='RegEmailRecipientManagePwdBtm' id='RegEmailRecipientManagePwdBtm' 	src="../../eCommon/html/blank.html" frameborder=0 scrolling=yes noResize style='height:*%;width:100vw'></iframe>
		 
</html>

