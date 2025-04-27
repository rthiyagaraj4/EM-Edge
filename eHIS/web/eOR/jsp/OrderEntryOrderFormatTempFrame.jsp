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

<%	
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>

<html>
  <head>
	<title><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></title>
	<script>
		function doInit()
		{
		    var tempArray ;
		    if(parent.dialogArguments !=undefined)
		    tempArray 	= parent.dialogArguments;
		   else{			   
			   tempArray 	= top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-2].contentWindow.dialogArguments;
		   if(tempArray ==undefined){
			   tempArray 	= top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-3].contentWindow.dialogArguments;
		   }
		   } 
		    var str = "";
		    for(i=0;i<tempArray.length;i++)
		    	str   += tempArray[i];
		    document.write(str);
		    document.dummyForm.method	  =  "POST";
		 	document.dummyForm.action 	  = "../../eOR/jsp/OrderEntryOrderFormatLine.jsp";
			document.dummyForm.submit();
		}
	</script>
  </head>
  <body onLoad="doInit()" > </body>
</html>
