<!DOCTYPE html>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.*" %>
<HTML>
	
<%
	request.setCharacterEncoding("UTF-8");   

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
 %> 
<HEAD>
<meta http-equiv="X-UA-Compatible" content="IE=10">
<TITLE> New Document </TITLE>
<meta charset="utf-8">
	<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	

<script Language="JavaScript">

	
	var websocket;
	
	$(document).ready(function() {   
		
		$("#connect").click(function() {

			var myNav = navigator.userAgent.toLowerCase();

			$("#status").val("");
			$("#messagesList").val("");
			$("#insuranceid").val("");

			var id = invokeInsuranceCardReader("insuranceid","cardStatus"); //invokeInsuranceCardReader("insuranceid","cardStatus");	

			return false;     
			
		});

	});

	/*
	$(document).ready(function() {   

		$("#connect").click(function() {			

			$("#status").val("");
			$("#messagesList").val("");
			$("#insuranceid").val("");

			var socketUri = $("#websocketuri").val();	

			*/

			/* ************************
			var arguments = new Array();

			var dialogWidth	= "300px";
			var dialogHeight = "300px";
			var dialogTop    = "100";
			var dialogLeft   = "100";

			var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ ";status:yes;scroll:no";	

			var action_url	="../../eXH/jsp/WebSockets.html";

			var retVal = window.open(action_url,"",  "toolbar=no,scrollbars=yes,resizable=yes,top=100,left=500,width=400,height=400");

			*/
			
			/*
			websocket = new WebSocket(socketUri,"echo-protocol");

			$("#status").val("Connected");
			
			return false;     
			
		});

		$("#send").click(function() {	
			
			var message = $("#request").val();	

			websocket.send(message);

			$("#status").val("Message Sent");

			$("#messagesList").val(message);

			var data = JSON.parse(message);
			var x=data.message;

			$("#insuranceid").val(x);

			return false;     
			
		});
		
	});

	*/

	

	function invokeInsuranceCardReader(fieldName, statusFieldName)
	{
		var segment_id = "ICR", element_id = "WEBSOCKET_URL", standard_code = "INSCARDSTD";
	
		var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
		//var websocketurl = "wss://echo.websocket.org/";


		$("#websocketuri").val(websocketurl);
		
		var insuranceField = "#"+fieldName;
		$(insuranceField).val("");

		var statusfield = "#"+statusFieldName;

		$(statusfield).text("Inside Card Reader");

		insuranceid = "";
		//var socketUri = $("#websocketuri").val();
		//websocket = new WebSocket('ws://localhost:8025/ws/chat');

		websocket = new WebSocket(websocketurl);		
		websocket.onopen = function(evt) { onOpen(evt, statusFieldName) };
		websocket.onclose = function(evt) { onClose(evt, statusFieldName) };
		websocket.onmessage = function(evt) { onMessage(evt, fieldName, statusFieldName) };
		websocket.onerror = function(evt) { onError(evt, fieldName, statusFieldName) };

		return insuranceid;
	}

	function onOpen(evt, statusFieldName)
	{
		$("#status").val("Connected");
		var message = $("#request").val();	
		doSend(message, statusFieldName);
	}

	function onClose(evt, statusFieldName)
	{
		$("#status").val("Disconnected");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Received and Closed");
	}

	function onMessage(evt, fieldName, statusFieldName)
	{
		$("#status").val("Message Received");

		$("#messagesList").val(JSON.stringify(evt.data));

		var data = JSON.parse(evt.data);
		var insuranceData=data.message;

		var insuranceField = "#"+fieldName;
		$(insuranceField).val(insuranceData);

		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Received");

		insuranceid = insuranceData;
		websocket.close();
	}

	function onError(evt, fieldName, statusFieldName)
	{		
		$("#status").val( evt.data);
		var insuranceField = "#"+fieldName;
		$(insuranceField).val("");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text(evt.data);
	}

	function doSend(message, statusFieldName)
	{
		websocket.send(message);
		$("#status").val("Message Sent");
		var statusfield = "#"+statusFieldName;
		$(statusfield).text("Message Sent");
	}


	function getDocumentMode()
	{	
		
		var documentModeStr = document.documentMode;

		alert(documentModeStr);		
		
	}





	
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onload = "loadPage()">
	<form>
	<table border="1" cellpadding="3" cellspacing="0" align = "center" width="800">		
		<tr>	
			<td width="25%" class="label">Card Reader URI</td>
			<td width="50%" align=left>				
				<input class="textbox" type="textbox" id="websocketuri" name="websocketuri" id="websocketuri" value="" size="50"> 
			</td>
			<td width="25%" align=left>				
				<input class="button" type="button"  id="connect" name="connect" id="connect" value="Get Insurance IDs"> 
			</td>
		</tr>
		<tr>
			<td width="25%" class="label">Request</td>
			<td width="50%" align=left>				
				<input class="textbox" type="textbox" id="request" name="request" id="request" value='{"message":"10028989, 10028990, 10028991",	"sender":"client",	"timeStamp": "Wed Aug 12 16:55:15 EET 2020"}' size="50"> 
			</td>
			<td width="25%" align=left>				
				<input class="button" type="button"  id="send" name="send" id="send" value="Send"> 
			</td>
			
		</tr>	
		<tr>				
			<td width="25%" align=left>	
				Status 
				<!--<input class="textbox" type="textbox" id="status" name="status" id="status" value=""> -->
				<div id="cardStatus"><div>

			</td>			
			<td width="50%" align=left>	
				Message Received
				<textarea id="messagesList" name="messagesList" rows="4" cols="60" disabled></textarea>
			</td>
			<td width="25%" align=left>	
				Insurance ID's
				<input class="textbox" type="textbox" id="insuranceid" name="insuranceid" id="insuranceid" value=""> 
			</td>			
		</tr>	
		<tr>				
			<td width="25%" align=left>				
				<input class="button" type="button"  id="DocumentMode" name="DocumentMode" id="DocumentMode" value="DocumentMode" onClick="getDocumentMode();"> 
			</td>
		</tr>	
	</table>	

	</form>
</body>
</HTML>

