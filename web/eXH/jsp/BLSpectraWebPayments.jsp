<!DOCTYPE html>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.*, eXH.*" %>
<HTML>	
<%
	request.setCharacterEncoding("UTF-8");   
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)
	       ||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session
			.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);	

 %> 
 
 <%
	 String strloggeduser = "";
	 String strslmtpatientId = request.getParameter("Patient_id") == null ? "" : request.getParameter("Patient_id");
	 String strslmtbillamount = request.getParameter("Amount") == null ? "" : request.getParameter("Amount");
	 String strrequesttype = request.getParameter("Request_type") == null ? "" : request.getParameter("Request_type");
	 String strwaitime = request.getParameter("WaitTime") == null ? "5" : request.getParameter("WaitTime");
	 String strwebsocketurl = request.getParameter("Ws_url") == null ? "ws://localhost:5000/messages" : request.getParameter("Ws_url");
	 String strcomPort = request.getParameter("Machine_port") == null ? "COM3" : request.getParameter("Machine_port");
	 String strboudRate = request.getParameter("BoudRate") == null ? "38400" : request.getParameter("BoudRate");
	 String strprintSettings = request.getParameter("Print_settings") == null ? "0" : request.getParameter("Print_settings");
	
	 boolean isDebugYN = false;
	
	 try {
	     isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
	
	     if (isDebugYN) {
	         System.err.println("***Inside BLSpectraWebPayments - Patient Id... " + strslmtpatientId + " *** Settlement Bill Amount... " + strslmtbillamount + " *** Request Type... " + strrequesttype + " *** Wait Time... " + strwaitime + " *** Websocket url... " + strwebsocketurl + " *** COM Port... " + strcomPort + " *** Boudrate... " + strboudRate);
		 }
	
	 } catch (Exception e) {
	     out.println("Exception while fetching Debug YN :" + e);
	 }
 %>
<HEAD>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title> Spectra Payment </title>
	<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	<script language="javascript" src="../../eXH/js/spectra-ws.js"></script>
	
	<script type="text/javascript">
		/*function HealthIdCallBack(hids) {
	
		    var returnStr = "";
	
		    $(hids).each(function(idx, obj) {
		        $('.cnt-healthidcallback').append('<p>ID: ' + obj + '</p>');
		        returnStr = obj;
		    });
	
		    parent.window.returnValue = returnStr;
		    TimeOutFn("Success");
	
		};*/
	
		function ConnectionCallBack(response) {
			
			var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){
		    	alert("Connection Callback Response... "+JSON.stringify(response));
			}
		    
		    if (response.IsConnected == "True") {
		        $('.cnt-statuscallback').append('<h5 style="color:green"><p>'+response.Status+'</p></h5>');
		    } else {
		        $('.cnt-statuscallback').append('<p class=\'text-danger\'></p>Connection Status: ' + response.Status + '</p>');
		    }
	
		};
	
		function OnTerminalActionCallback(response) {
			
			response = JSON.parse(response);
	
		    $('.cnt-terminalactioncallback').append('<p class=\'text-danger\'></p>' + response.OptionalMessage + '</p>');
		}
	
		function PaymentResultCallback(pmtObj) {
	
			var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){
				alert("Document Mode in Payment Page : "+document.documentMode);
		    	alert("Inside Payment Result Callback - Payment Object - " + JSON.stringify(pmtObj));
			}
	
		    var jsonResult = JSON.parse(pmtObj.JsonResult);	      
		    
	
		    var waitime = document.getElementById("waittime").value.trim();
	
		    waitime = Number(waitime) * 1000;
	
		    $('.cnt-statuscallback').append('<h5 style="color:green"><p>Message received successfully...</p></h5>');
	
		    //$('.cnt-notifypmtcallback').append('<p>PatientId: ' + $("#slmtpatientId").val().trim() + '</p>');
		    $('.cnt-notifypmtcallback').append('<p>Response: ' + jsonResult.TransactionResponseEnglish + '</p>');
		    $('.cnt-notifypmtcallback').append('<p>Reference Number: ' + jsonResult.ECRReferenceNumber + '</p>');
		    $('.cnt-notifypmtcallback').append('<p>RRN: ' + jsonResult.RetrievalReferenceNumber + '</p>');
		    $('.cnt-notifypmtcallback').append('<p>Approval Code: ' + jsonResult.TransactionAuthCode + '</p>');
	
		    var returnStr = "";
		    var resultFlag = "";
	
		    var d = new Date();
		    var datestring = "";
	
		    var processStatus = "F";
		    var processRemarks = "Internal Error";
		    var ErrorMessage = "";
		    var payerName = "";
		    var saleDraftNo = "";
		    var rrn = "";
		    var approvalCode = "";
		    var cardType = "";
		    var cardNumber = "";
		    var cardExpDate = "";
		    var batchNumber = "";
		    var txnDate = "";
		    var txnTime = "";
		    var cardIssuedBank = "";
		    var trackingID = "";
		    var terminalID = "";
	
		    if (pmtObj.EventName == "TERMINAL_RESPONSE") {
		        if (jsonResult.TransactionResponseEnglish == "APPROVED") {
		            resultFlag = "Success";
		            processStatus = "S";
	
		            processRemarks = jsonResult.TransactionResponseEnglish;
		            saleDraftNo = jsonResult.ECRReferenceNumber;
		            rrn = jsonResult.RetrievalReferenceNumber;
		            approvalCode = jsonResult.TransactionAuthCode;
		            cardType = jsonResult.CardScheme;
		            cardNumber = jsonResult.PrimaryAccountNumber;
		            batchNumber = jsonResult.TransactionSTAN;
	
		            txnDate = ('0' + d.getDate()).slice(-2) + '/' +
		                ('0' + (d.getMonth() + 1)).slice(-2) + '/' +
		                d.getFullYear();
		            txnTime = ('0' + d.getHours()).slice(-2) + "" + ('0' + d.getMinutes()).slice(-2) + "" + ('0' + d.getSeconds()).slice(-2);
	
		            terminalID = jsonResult.CardAcceptorTerminalId;
	
		        } else {
		            resultFlag = "Failed";
		            processStatus = "E";
		            processRemarks = jsonResult.TransactionResponseEnglish;
	
		        }
		    }
		    //response =approvedPurchaseResultCode+"$|#"+approvedPurchaseResult+" "+responseDescription+"$|#$|#"
		    //+ "$|#"+merchantID+"$|#"+rrn+"$|#"+authResponse+"$|#"+cardType+"$|#"
		    //+ cardNumber+"$|#$|#"+traceNumber+"$|#"+dateTime1+"$|#$|#"
		    //+ "$|#$|#$|#"+terminalID
		    returnStr = processStatus + "$|#" + processRemarks + "$|#" + ErrorMessage + "$|#" + payerName + "$|#" + saleDraftNo + "$|#" + rrn + "$|#" + approvalCode + "$|#" + cardType + "$|#" + cardNumber + "$|#" + cardExpDate + "$|#" + batchNumber + "$|#" + txnDate + "$|#" + txnTime + "$|#$|#" + cardIssuedBank + "$|#" + trackingID + "$|#" + terminalID;
	
		    parent.window.returnValue = returnStr;
		    TimeOutFn(resultFlag);
		};
	
		var x;
		function TimeOutFn(status) {
	
		    var waitime = document.getElementById("waittime").value.trim();
		    
		    if (status == "Success") {
				clearInterval(x);
				waitime = 5;
		    }
	
		    waitime = Number(waitime) * 1000;
	
		    var countDownDate = new Date().getTime() + waitime * 1000;
	
		    countDownDate = countDownDate + waitime;
	
		    // Update the count down every 1 second
		    x = setInterval(function() {
	
		        // Get today's date and time
		        var now = new Date().getTime();
	
		        // Find the distance between now and the count down date
		        var distance = countDownDate - now;
	
		        // Time calculations for days, hours, minutes and seconds
		        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
		        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
		        var statusMessage = "";
		        if (status == "Success") {
		            statusMessage = "transaction is successful";
		        } else {
		            statusMessage = "transaction is in progress";
		        }
				
		        // Output the result in an element with id="demo"
		        document.getElementById("demo").innerHTML = "Kindly wait... " + statusMessage + " and this window will close in " + seconds + "s ";
	
		        // If the count down is over, write some text 
		        if (distance < 0) {
		            clearInterval(x);
		            document.getElementById("demo").innerHTML = "EXPIRED";
		            parent.window.close();
		        }
		    }, 1000);
	
		};

	
		function ErrorCallback(error) {
	
		    var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){	
		    	alert("Inside Error Callback " + error);
			}
	
		    $('.cnt-statuscallback').append('<h5 style="color:red"><p>'+error+'</p></h5>');
	
		    var slmtidno = ""; //document.getElementById("slmtidno").value.trim();
	
		    var returnStr = "";
		    var resultFlag = "";
	
		    var datestring = "";
	
		    resultFlag = "ERROR";
		    datestring = "";
		    returnStr = "E$|#Error. " + error + "$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#";
		    parent.window.returnValue = returnStr;
		    TimeOutFn(resultFlag);
		};
	
		function RequestPaymentAckCallback(obj) {
		    
		    var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){
		    	alert("Inside Payment AckCallback " + JSON.stringify(obj));
			}

			var jsonResult = JSON.parse(obj.JsonResult);
			
			if(!document.getElementById("ackRes")){
				$('.cnt-statuscallback').append('<h5 style="color:green"><p id="ackRes">Payment Acknowledgement Received By the Server...</p></h5>');
			}
			
		    $('.cnt-custinfoackcallback').append('<p>' + jsonResult.Status + '</p>');
		};
	
		function getCOMConnect() {	
			
			var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){
		    	alert("Before Connecting COM PORT... "+document.documentMode);
			}
		    
		    SpectraClient.sendRequest({
		        Event: "CONNECTION",
		        Operation: "CONNECT",
		        connectionMode: "COM",
		        comName: $("#comPort").val().trim(),
		        braudRate: $("#braudRate").val().trim(),
		        dataBits: "8",
		        parity: "none",
		    });
		    
			//SpectraClient.sendRequest(jsonData);
		}
	
		function sendPaymentRequest() {
			
		
			var isDebugYN = document.getElementById("isDebugYN").value;
			
			if(isDebugYN=="true"){
		    	alert("Sending Payment Request...");
			}
	
		    //$('.cnt-statuscallback').append('<h5 style="color:green"><p>WebSocket Connected</p></h5>');
	
		    //Generating 16 random number ecr reference
		    document.getElementById("ecrnumber").value = (Math.random() + ' ').substring(2, 10) + (Math.random() + ' ').substring(2, 10);
	
		    var slmtidno = "";
	
		    //SpectraClient.RequestPayment(jsonData);
			SpectraClient.sendRequest({
		        Event: "TRANSACTION",
		        Operation: "PURCHASE",
		        Amount: $("#slmtbillamount").val().trim(),
		        PrintSettings: $("#printSettings").val().trim(),
		        AppId: "11",
		        ECRNumber: $("#ecrnumber").val().trim()
		    });
	
		    $('.cnt-statuscallback').append('<h5 style="color:green"><p>Payment request successfully made</p></h5>');
	
		    $('.cnt-statuscallback').append('<h5 style="color:blue"><p>Kindly swipe/insert the card in the card reader machine </p></h5>');
	
		    var returnStr = "";
		    var resultFlag = "";
	
		    var datestring = "";
	
		    resultFlag = "ERROR";
		    datestring = "";
		    returnStr = "E$!^Error. " + resultFlag + "$!^Transaction Failed$!^ERROR$!^" + slmtidno + "$!^" + datestring;
		    parent.window.returnValue = returnStr;
		    TimeOutFn(resultFlag);
	
		}
	</script>
	<style>
		td {
			vertical-align: top;
		}
		.call-back{
			font-weight: bold;
		}
	</style>
</HEAD>
<body>
	<form>
	    <table border='0' cellpadding='3' cellspacing='0' width='100%'>
	        <tr>
	            <td width="20%" class="fields">
	                <p class="call-back">Payment Details</p>
	            </td>
		    <!--<td width="20%" class="fields">
	                <p class="call-back">Health Id Callback</p>
	            </td>
	            <td width="20%" class="fields">
	                <p class="call-back">Connection Callback</p>
	            </td>-->
	            <td width="20%" class="fields">
	                <p class="call-back">Terminal Action Callback</p>
	            </td>
	            <td width="20%" class="fields">
	                <p class="call-back">Request Payment Ack Callback</p>
	            </td>
	            <td width="25%" class="fields">
	                <p class="call-back">Payment Result Callback</p>
	            </td>
		    <!--<td width="20%" class="fields">
	                <p class="call-back">Error Callback</p>
	            </td>-->
	        </tr>
	        <tr>
	            <td width="20%" class="label">
	                <p>Patient ID : <%=strslmtpatientId%>
	                </p>
	                <p>Payable Amount : <%=strslmtbillamount%>
	                </p>
	            </td>
	            <!--<td width="20%" class="label">
	                <p class='cnt-healthidcallback text-success'></p>
	            </td>
	            <td width="20%" class="label">
	                <p class='cnt-connectioncallback'></p>
	            </td>-->
	            <td width="20%" class="label">
	                <p class='cnt-terminalactioncallback'></p>
	            </td>
	            <td width="20%" class="label">
	                <p class='cnt-custinfoackcallback text-success'></p>
	            </td>
	            <td width="25%" class="label">
	                <p class='cnt-notifypmtcallback text-success'></p>
	            </td>
	            <!--<td width="15%" class="label">
	                <p class='cnt-errorcallback text-danger'></p>
	            </td>-->
	        </tr>
	    </table>
	    <table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	        <tr>
	            <td>
	                <p class="cnt-statuscallback text-success">Transaction Status</p>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <p id="demo">Kindly wait... transaction in progress and this window will close automatically...</p>
	            </td>
	        </tr>
	    </table> 
	    <input type=hidden id='slmtpatientId' name='slmtpatientId' value="<%=strslmtpatientId%>"> 
	    <input type=hidden id='slmtbillamount' name='slmtbillamount' value="<%=strslmtbillamount%>"> 
	    <input type=hidden id='requesttype' name='requesttype' value="<%=strrequesttype%>"> 
	    <input type=hidden id='waittime' name='waittime' value="<%=strwaitime%>"> 
	    <input type=hidden id='websocketurl' name='websocketurl' value="<%=strwebsocketurl%>"> 
	    <input type=hidden id='isDebugYN' name='isDebugYN' value="<%=isDebugYN%>"> 
	    <input type=hidden id='comPort' name='comPort' value="<%=strcomPort%>"> 
	    <input type=hidden id='braudRate' name='braudRate' value="<%=strboudRate%>"> 
	    <input type=hidden id='printSettings' name='printSettings' value="<%=strprintSettings%>"> 
	    <input type=hidden id='ecrnumber' name='ecrnumber' value="">
	</form>
</body>
</HTML>
