<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/TriageDetails.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String params		 = request.getQueryString() ;
		String patient_id	 = request.getParameter("patient_id");
		patient_id			= (patient_id==null)?"":patient_id;
%>

<iframe name='triageDates' id='triageDates' src='../../eAE/jsp/AETriageDates.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='triageResult' id='triageResult' src='../../eAE/jsp/AETriageDetailsResult.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>

</html>

