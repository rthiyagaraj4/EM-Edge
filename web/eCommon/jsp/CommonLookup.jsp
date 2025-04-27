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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<html>
<script>
	//var argArray = parent.window.dialogArguments;	
	var argArray = parent.document.getElementById('dialog-body').contentWindow.dialogArguments;	
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>

<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title id="lookup_title"></title>
	<iframe name="lookup_head" src="../../eCommon/jsp/CommonLookupSearchCriteria.jsp" noresize   marginheight="0" marginwidth="0" frameborder="0" scrolling="no" style="height:15vh;width:95vw"></iframe>
	<iframe name="lookup_detail"    src="../../eCommon/html/blank.html"   scrolling="auto"  marginheight="0" marginwidth="0" frameborder="0" style="height:74vh;width:95vw"></iframe>
	<iframe name="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize   scrolling="no" marginheight="0" marginwidth="0" frameborder="0" style="height:5vh;width:95vw"></iframe>

<input type="hidden" id="arguments" name="arguments" >


</html>

