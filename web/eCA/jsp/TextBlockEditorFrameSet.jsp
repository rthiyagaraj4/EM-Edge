<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
	<title>
		Text Block Editor 
	</title>
</head>
<iframe name="textBlockEditor" id="textBlockEditor" src="../../eCA/jsp/RTEditor.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize style="height:88vh;width:100vw"></iframe> 
	<iframe name="textBlockEditor_button" id="textBlockEditor_button"   src="../../eCA/jsp/TextBlockEditorButton.jsp" 	frameborder="none" border="none" scrolling="no" noresize style="height:10vh;width:100vw"></iframe> 

</html>

