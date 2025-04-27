<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <html>
 <script src='../../eCommon/js/common.js' language='javascript'></script> 
 <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
	String code_desc=request.getParameter("p_diag_scheme_desc");
%>
<title<fmt:message key="Common.search.label" bundle="${common_labels}"/><%=code_desc%><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.List.label" bundle="${common_labels}"/></title>
<iframe name='code_desc' id='code_desc'    src='PaintSearch.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100%;width:100vw'></iframe>
</html>

