<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<Script src="../../eMR/js/CreatePatientFile.js" language="JavaScript"></Script>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script language='javascript' src='../../eMR/js/MajorMedicalEvents.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/mrblank.jsp?step_1=8' frameborder=0  scrolling='no' style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
</html>

