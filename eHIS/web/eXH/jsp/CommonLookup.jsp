<!DOCTYPE html>

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
<head>
<meta http-equiv="x-ua-compatible" content="IE=Edge">
<script>
	var argArray = window.dialogArguments ;
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>
<title id="lookup_title"></title>
</head>
<body>
	<iframe name="lookup_head" id="lookup_head"  src="../../eCommon/jsp/CommonLookupSearchCriteria.jsp" height="75px" width="100%" style="border:0;" ></iframe>
	<iframe name="lookup_detail" id="lookup_detail"  src="../../eCommon/html/blank.html"  height="275px" width="100%"  style="border:0;"></iframe>
	<iframe name="lookup_cancel" id="lookup_cancel"  src="../../eCommon/jsp/CommonLookupCancel.jsp" height="50px" width="100%" style="border:0;"></iframe>
</body>
</html>
