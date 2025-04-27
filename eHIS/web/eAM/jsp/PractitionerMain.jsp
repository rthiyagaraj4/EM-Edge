<!DOCTYPE html>
<%--
	FileName	: PractitionerMain.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" session="false" %>

<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	
String practitionerid=request.getParameter("practitioner_id");
String function_id=request.getParameter("function_id");
%>
<html>
<head>
<script language='javascript' src='../../eAM/js/Practitioner.js'></script>
<!--<script language='javascript' src='../../eAM/js/externalPractitioner.js'></script>-->
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='practitioner_main' id='practitioner_main' src="../../eAM/jsp/addModifyPractitioner.jsp?practitioner_id=<%=practitionerid%>&fcall=nocall&function_id=<%=function_id%>" frameborder=0 scrolling='no' noresize style='height:35vh;width:98vw'></iframe>
<iframe name='practitioner_sub' id='practitioner_sub' src="../../eAM/jsp/addModifyPractitioner.jsp?practitioner_id=<%=practitionerid%>&fcall=call&function_id=<%=function_id%>" frameborder=0 scrolling='no' noresize style='height:62vh;width:98vw'></iframe>

	
</html>


