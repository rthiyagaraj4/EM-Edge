<!DOCTYPE html>
<!-- 

This  file was developed by Venkatesh.S on Feb/2013 against PMG2012-CRF-0006 [IN034693]  

-->

<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eMP.PatDoc.label" bundle="${mp_labels}"/></title>
<head>
<%
	  request.setCharacterEncoding("UTF-8");    
	  request= new XSSRequestWrapper(request);
	  response.addHeader("X-XSS-Protection", "1; mode=block");
	  response.addHeader("X-Content-Type-Options", "nosniff");
	   String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
		String patient_id = request.getParameter("patient_id");
		String column_name =request.getParameter("column_name");
		String isViewPrintPatDoc =request.getParameter("isViewPrintPatDoc");
%>

 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
 </script>

</head>
 
<%if(isViewPrintPatDoc!=null && isViewPrintPatDoc.equals("true")){%>
 <iframe name='' src='../../eMP/jsp/ViewPatientPrintDocument.jsp?patient_id=<%=patient_id%>&column_name=<%=column_name%>' frameborder='0' scrolling='no'  style='height:10vh;width:100vw'></iframe>
<iframe name='' src='../../eMP/jsp/ViewPatientDocument.jsp?patient_id=<%=patient_id%>&column_name=<%=column_name%>' frameborder='0' scrolling='auto'  style='height:90vh;width:100vw'></iframe>

<%}
else {%>
 <iframe name='' src='../../eMP/jsp/ViewPatientDocument.jsp?patient_id=<%=patient_id%>&column_name=<%=column_name%>' frameborder='0' scrolling='auto'  style='height:100vh;width:100vw'></iframe>

<%}%>
</html>

