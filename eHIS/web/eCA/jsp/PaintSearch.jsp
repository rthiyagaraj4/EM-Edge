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
//	out.println(request.getParameter("cause_indicator"));

%>
<iframe name='code_label' id='code_label'    src='SearchicdQueryResult.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:33%;width:100vw'></iframe><iframe name='prevnextframe' id='prevnextframe'    src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe><iframe name='codedesc' id='codedesc'    src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe>
</html>

