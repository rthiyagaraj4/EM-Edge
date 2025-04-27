<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.net.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="VBScript">
	 Sub callInvokeForms(query_string)
		On Error Resume Next
		dim x
	    	Set objNet = CreateObject("WScript.Shell")
			x = objNet.Run(query_string,0) 
	 end sub

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onLoad='callInvokeForms("<%=java.net.URLDecoder.decode(request.getQueryString(),"UTF-8")%>")'> 
<form>
	<Script>parent.window.close()</script>
</form>
</BODY>
</HTML> 

