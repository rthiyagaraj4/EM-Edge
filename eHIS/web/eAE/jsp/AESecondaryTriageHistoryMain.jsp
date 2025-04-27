<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html> 
<head>
<title><fmt:message key="eAE.PatSecondaryTriageHistory.label" bundle="${ae_labels}"/></title>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String functionid=request.getParameter("functionid");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name='PatientSecondaryTriageDetails' id='PatientSecondaryTriageDetails' src='../../eAE/jsp/CallAESecondaryTriage.jsp?<%=request.getQueryString()%>&page_name=PatientAEHistory' frameborder=0 scrolling='auto' noresize style='height:99vh;width:99vw'></iframe>
     
</html>  

