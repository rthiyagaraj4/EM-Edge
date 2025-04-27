<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="preview_editor" id="preview_editor"   src="../../eOR/jsp/ConsentFormatPreviewTemplate.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" style="height:26vh;width:100vw"></iframe> 
<!-- Modified by kishore kumar N on 08-Cct-09 for ICN 14998* -->
	<!-- <frameset cols='830,*' frameborder="none" border="none"> -->
		<iframe name="editor" id="editor"  src="../../eCommon/jsp/RTEditor.jsp?<%=request.getQueryString()%>" 	frameborder="none" border="none" scrolling="no" style="height:59vh;width:100vw"></iframe> 
		<iframe name="blankFrm" id="blankFrm"   src="../../eCommon/html/blank.html" 	frameborder="none" border="none" scrolling="no" style="height:0vh;width:100vw"> </iframe>
<!--	</frameset>-->
	<!-- ends here. -->
	<iframe name="editor_button" id="editor_button"  src="../../eOR/jsp/ConsentFormatEditorButton.jsp?<%=request.getQueryString()%>" 	frameborder="none" border="none" scrolling="no" style="height:15vh;width:100vw"></iframe> 

