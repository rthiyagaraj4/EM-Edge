<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>

<title>Clinic Allocation</title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String params = request.getQueryString();
%>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='clinic_allocation' id='clinic_allocation' src='../../eOA/jsp/ClinicAllocationAddModifyFrame.jsp?<%=params%>' scrolling=no noresize style='height:90vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		 src='../../eCommon/jsp/error.jsp' noresize scrolling=auto style='height:10vh;width:100vw'></iframe>
</html>

