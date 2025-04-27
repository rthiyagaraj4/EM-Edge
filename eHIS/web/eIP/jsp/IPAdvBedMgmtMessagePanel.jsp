<!DOCTYPE html>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html>
<head>

</head>
<body style='background:#e7f3f2;'>

<div>
<%

String errorMessage = request.getParameter(GBMConstants.ERRORMESSAGE_REQUEST_KEY);
String infoMessage = request.getParameter(GBMConstants.INFO_MESSAGE_REQUEST_KEY);
if(errorMessage != null && !errorMessage.trim().equals("")){
%>
<span style='font-style: bold;color: #C00000;' ><%=errorMessage %></span>
<%

}else if(infoMessage != null && !infoMessage.trim().equals("")){
%>
<span style='color: #000000;' ><%=infoMessage %></span>
<%	
}
%>
</div>

</body>
</html>
