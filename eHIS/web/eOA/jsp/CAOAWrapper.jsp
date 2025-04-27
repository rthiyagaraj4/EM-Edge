<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
      
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head><title><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></title>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");	
		String s=request.getQueryString();
		
	%>
		<iframe name='caoapage' id='caoapage' src='../../eOA/jsp/CAOAAppointment.jsp?<%=s%>'  scrolling=no noresize style='height:96vh;width:97vw;border:0'></iframe>
			
</html>

