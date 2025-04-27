<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
  <head>
	<title><fmt:message key="Common.email.label" bundle="${common_labels}"/></title>
	<script>
		function doInit()
		{
		    var tempArray 	= window.dialogArguments;
		    var str = "";
		    for(i=0;i<tempArray.length;i++)
		    	str   += tempArray[i];
		    document.write(str);
		    document.dummyForm.method	  =  "POST";
		 	document.dummyForm.action 	  = "../../eOR/jsp/EmailPreview.jsp";
			document.dummyForm.submit();
		}
	</script>
  </head>
  <body onLoad="doInit()" > </body>
</html>
