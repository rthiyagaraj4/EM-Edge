<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="preview_editor" id="preview_editor"   src="../../eCA/jsp/DefineHeaderPreviewTemplate.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize style="height:20%;width:100vw"></iframe> 
		<iframe name="editor" id="editor"   src="../../eCommon/jsp/RTEditor.jsp?<%=request.getQueryString()%>" 	frameborder="none" border="none" scrolling="no" noresize style="height:100vh;width:100vw"></iframe> 
		<iframe name="editor_button" id="editor_button"   src="../../eCA/jsp/DefineHeaderEditorButton.jsp?<%=request.getQueryString()%>" 	frameborder="none" border="none" scrolling="no" noresize style="height:10%;width:100vw"></iframe> 
 

