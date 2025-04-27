<!DOCTYPE html>
<html> 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>

<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 

<script language="JavaScript">
function initFunc()
{
	var messageType = parent.searchCriteria.document.getElementById("messageType").value;
	var eventType = parent.searchCriteria.document.getElementById("eventType").value;
	var requestParams = "requestType=RECIPIENT_LIST&eventType=" + eventType + "&messageType=" + messageType;
	parent.recipientSchedule.document.location.href = "../servlet/eXH.NotificationSettingsServlet?" + requestParams;
}

</script>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
											   
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc()">
<form>
<p align="left">																					    
${param.stMessage}
</p>	
</form>
</BODY>															  
</html>																						 		 

