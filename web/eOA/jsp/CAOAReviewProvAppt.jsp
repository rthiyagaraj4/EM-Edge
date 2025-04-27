<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	//String call_function	= request.getParameter("call_function");
	
%>
<script src="../../eOA/js/QueryApptForPatient.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<iframe name='dummy1' id='dummy1'	src='../../eCommon/html/blank.html' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	<iframe name='frame1' id='frame1' src='../../eOA/jsp/QueryApptForPatientCriteria.jsp?function_id=<%=function_id%>&<%=source%>'  scrolling='no' style='height:33vh;width:100vw'></iframe>
	<iframe name='frame3' id='frame3' 	src='../../eCommon/html/blank.html'  scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='frame2' id='frame2' src='../../eCommon/html/blank.html'  noresize scrolling='auto' style='height:58vh;width:100vw'></iframe>

</html>

