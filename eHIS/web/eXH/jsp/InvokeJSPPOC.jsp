<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoke JSP POC</title>
<SCRIPT LANGUAGE="javascript">
/*
 * Interface javascript function.
 * In this Notificaition filter criteria window is being invoked and valued for message & event types are being populated automatically
 */
	function invokeJSPPOC()
	{
		// Parameters that are to be populated in the JSP
		var messageTypeDesc = "OT Appointments";
		var messageType = "OTN";
		var eventTypeDesc = "OT Remainder";
		var eventType = "OT81";
		
		var url = "../../eXH/jsp/NotificationFilterCriteria.jsp"; // JSP that is to be invoked
	 
		var newWindow = window.open(url, "POC", "width=400,height=400"); // Opening the jsp and getting the reference for further populating the fields
		
		// Populating required fields once the jsp is loaded
		newWindow.document.onreadystatechange = function () {
			  if (newWindow.document.readyState == "complete") {
					newWindow.document.getElementById("messageTypeDesc").value = messageTypeDesc;
					newWindow.document.getElementById("messageType").value = messageType;
					newWindow.document.getElementById("eventTypeDesc").value = eventTypeDesc;
					newWindow.document.getElementById("eventType").value = eventType;
			  }
			};
		
	}
  </SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<INPUT TYPE="button" VALUE="Invoke Notification Filter" onClick="invokeJSPPOC()">
</body>
</html>

