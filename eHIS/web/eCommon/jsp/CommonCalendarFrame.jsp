<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
%>

<html>
<script>
	var argArray = window.dialogArguments ; 
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>
<title id="lookup_title"></title>
	<iframe name="lookup_head" src="../../eCommon/jsp/CommonStaticCalenderGlad.jsp?<%=request.getQueryString()%>" noresize   marginheight="0" marginwidth="0" scrolling="no" style="height:100%;width:100%"></iframe>

<input type="hidden" id="arguments" name="arguments" >


</html>

