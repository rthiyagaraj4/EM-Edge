<!DOCTYPE html>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.*, eXH.*" %>
<HTML>	
<%
	request.setCharacterEncoding("UTF-8");   
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);	

 %> 
 <%
		String      strloggeduser = "";
		String		strslmtidno = request.getParameter("saledraftno") == null ? "":request.getParameter("saledraftno");	
		String		strslmtpatientId = request.getParameter("patientid") == null ? "":request.getParameter("patientid");	
		String		strslmtbillamount = request.getParameter("amount") == null ? "":request.getParameter("amount");		
		String		strrequesttype = request.getParameter("requesttype") == null ? "":request.getParameter("requesttype");	
		String		strwaitime = request.getParameter("waitime") == null ? "5":request.getParameter("waitime");
		
		boolean isDebugYN = false;
		
		try
		{
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			if(isDebugYN)
				System.err.println("***Inside BLPaySkyPayments - Settlement ID No... "+strslmtidno+" ***Patient Id... "+strslmtpatientId+" *** Settlement Bill Amount... "+strslmtbillamount+" *** Request Type... "+strrequesttype+" *** Wait Time... "+strwaitime);

		}		
		catch(Exception e)
		{
			out.println("Exception while fetching Debug YN :"+e);
		}
		

	%>
<HEAD>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title> PaySky Payment </title>
	<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	<script language="javascript" src="../../eXH/js/ps-uha-1.2.js"></script>
	<script Language="JavaScript">				

		function HealthIdCallBack(hids) {
			
			var returnStr = "";
			
			$(hids).each(function (idx, obj) {
				$('.cnt-healthidcallback').append('<p>ID: ' + obj + '</p>');				
				returnStr = obj;				
			});		
			
			parent.window.returnValue = returnStr;
			TimeOutFn("SUCCESS");			
			 
         };

        function PaymentResultCallback(pmtObj) {        	
        	
        	var waitime = document.getElementById("waittime").value.trim();
        	
        	waitime = Number(waitime) * 1000;

			$('.cnt-statuscallback').append('<h5 style="color:green"><p>Message received successfully...</p></h5>');

			$('.cnt-notifypmtcallback').append('<p>PatientId: ' + pmtObj.PatientId + '</p>');
            $('.cnt-notifypmtcallback').append('<p>ProcessingReference: ' + pmtObj.ProcessingReference + '</p>');
            $('.cnt-notifypmtcallback').append('<p>TransactionId: ' + pmtObj.TransactionId + '</p>');
            $('.cnt-notifypmtcallback').append('<p>Result Code: ' + pmtObj.Result + '</p>');
			
			var returnStr = "";
			var resultFlag = "";

			var d = new Date();
			var datestring = "";
			
			var isDebugYN = document.getElementById("isDebugYN").value.trim();
			if (isDebugYN == "true")
				alert("Inside Payment Result Callback - "+pmtObj.Result);

			if (pmtObj.Result == 1)
			{
				resultFlag = "SUCCESS";
				//Commented by Sethu for MOHE-SCF-0179 on 21/04/2022
				//datestring = d.getDate()  + "-" + (d.getMonth()+1) + "-" + d.getFullYear() + " " +d.getHours() + ":" + d.getMinutes();
				datestring = d.getDate()  + "-" + (d.getMonth()+1) + "-" + d.getFullYear();
				returnStr = resultFlag+"$!^"+resultFlag+"$!^$!^"+pmtObj.ProcessingReference+"$!^"+pmtObj.TransactionId+"$!^"+datestring;
				parent.window.returnValue = returnStr;
				TimeOutFn(resultFlag);			
			}	
			else
			{
				resultFlag = "FAILED";
				datestring = "";
				returnStr = resultFlag+"$!^"+resultFlag+"$!^Transaction Failed$!^"+""+"$!^"+pmtObj.TransactionId+"$!^"+datestring;
				parent.window.returnValue = returnStr;
				TimeOutFn(resultFlag);			
			}			
         };
         
         function TimeOutFn(status) {
         	
         	var waitime = document.getElementById("waittime").value.trim();
         	var isDebugYN = document.getElementById("isDebugYN").value.trim();
			if (isDebugYN == "true"){
				alert("Inside Time out Function "+waitime);
			}

			//waitime = 10;
         	
         	waitime = Number(waitime) * 1000;	
         	
         	var countDownDate = new Date().getTime();

			countDownDate = countDownDate +  waitime;

			// Update the count down every 1 second
			var x = setInterval(function() {
			
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
			if (status == "SUCCESS")
			{
				statusMessage = "transaction is successful";
			}
			else
			{
				statusMessage = "transaction is in progress";
			}
			// Output the result in an element with id="demo"
			document.getElementById("demo").innerHTML = "Kindly wait... "+statusMessage+" and this window will close in "+seconds + "s ";
			  
			// If the count down is over, write some text 
			if (distance < 0) {
			  	clearInterval(x);
			  	document.getElementById("demo").innerHTML = "EXPIRED";			  	
			 	parent.window.close();
			}
			}, 1000); 			
 			
         };

         function ErrorCallback(error) {
        	
        	var isDebugYN = document.getElementById("isDebugYN").value.trim();
        	if (isDebugYN == "true"){
 				alert("Inside Error Callback "+error);
			}
        	 
			$('.cnt-errorcallback').append('<p>' + error + '</p>');
			
			var slmtidno = document.getElementById("slmtidno").value.trim();
			
			var returnStr = "";
			var resultFlag = "";

			var datestring = "";
			 
			resultFlag = "ERROR";
			datestring = "";
			returnStr = resultFlag+"$!^"+resultFlag+"$!^Transaction Failed$!^"+error+"$!^"+slmtidno+"$!^"+datestring;
			parent.window.returnValue = returnStr;
			TimeOutFn(resultFlag);
         };

         function RequestPaymentAckCallback(obj) {
        	 var isDebugYN = document.getElementById("isDebugYN").value.trim();
         	 if (isDebugYN == "true"){
  				alert("Inside Payment AckCallback "+obj.Response);
			 }

			 $('.cnt-statuscallback').append('<h5 style="color:green"><p>Payment Acknowledgement Received By the Server...</p></h5>');

			 $('.cnt-custinfoackcallback').append('<p>Payment Acknowledgement Received By the Server</p>');
			 $('.cnt-custinfoackcallback').append('<p>Response Code: ' + obj.Response + '</p>');
			 $('.cnt-custinfoackcallback').append('<p>PatientId: ' + obj.PatientId + '</p>');
			 $('.cnt-custinfoackcallback').append('<p>TransactionId: ' + obj.TransactionId + '</p>');
         };
         
		 function sendPaymentRequest() {
			 
			$('.cnt-statuscallback').append('<h5 style="color:green"><p>WebSocket Connected</p></h5>');
			
			var slmtidno = document.getElementById("slmtidno").value.trim();
			var slmtpatientid = document.getElementById("slmtpatientId").value.trim();
			var slmtbillamount = document.getElementById("slmtbillamount").value.trim();

			var paymentData = {"PatientId":$("#slmtpatientId").val(), "TransactionId":$("#slmtidno").val(), "Amount":$("#slmtbillamount").val()};		
			
			var jsonData = JSON.stringify(paymentData);

			 PsUhaClient.RequestPayment(
			 {
				 PatientId: $("#slmtpatientId").val().trim(),
				 TransactionId: $("#slmtidno").val().trim(),
				 Amount: Number($("#slmtbillamount").val().trim())
			});

			$('.cnt-statuscallback').append('<h5 style="color:green"><p>Payment request successfully made</p></h5>');
			
			$('.cnt-statuscallback').append('<h5 style="color:blue"><p>Kindly swipe/insert the card in the card reader machine </p></h5>');
			
			var returnStr = "";
			var resultFlag = "";

			var datestring = "";

			resultFlag = "ERROR";
			datestring = "";
			returnStr = resultFlag+"$!^"+resultFlag+"$!^Transaction Failed$!^"+"ERROR"+"$!^"+slmtidno+"$!^"+datestring;
			parent.window.returnValue = returnStr;
			TimeOutFn(resultFlag);

        }
	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<body>

	<form>
	
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>
			<tr>				
				<td width="20%" class="fields">
					<p class="call-back">Payment Details</p>
				</td>
				<td width="20%" class="fields">
					<p class="call-back">Receive HealthID Callback</p>
			   	</td>
				<td width="20%" class="fields">
					<p class="call-back">Request Payment Ack Callback</p>
			   	</td>
			   	<td width="25%" class="fields">
					<p class="call-back">Payment Result Callback</p>
			   	</td>
			   	<td width="15%" class="fields">
					<p class="call-back">Error Callback</p>
			   	</td>
			</tr>
			<tr>				
				<td width="20%" class="label">
					<p>Patient ID : <%=strslmtpatientId%> <p>
					<p>Payable Amount : <%=strslmtbillamount%> <p>
					<p>Transaction ID : <%=strslmtidno%> <p>
				</td>
				<td width="20%" class="label">
					<p class='cnt-healthidcallback text-success'></p>
			    </td>
				<td width="20%" class="label">
					<p class='cnt-custinfoackcallback text-success'></p>
			    </td>
			    <td width="25%" class="label">
					<p class='cnt-notifypmtcallback text-success'></p>
			    </td>
			    <td width="15%" class="label">
					<p class='cnt-errorcallback text-danger'></p>
			    </td>
			</tr>
		</table>	
		<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>
			<tr>
				<td><p class="cnt-statuscallback text-success">Transaction Status</p></td>
			</tr>
			<tr>
				<td><p id="demo">Kindly wait... transaction in progress and this window will close automatically...</p></td>
			</tr>
		</table>
		<input type=hidden id='slmtidno' name='slmtidno' id='slmtidno' value="<%=strslmtidno%>">
		<input type=hidden id='slmtpatientId' name='slmtpatientId' id='slmtpatientId' value="<%=strslmtpatientId%>">
		<input type=hidden id='slmtbillamount' name='slmtbillamount' id='slmtbillamount' value="<%=strslmtbillamount%>">
		<input type=hidden id='requesttype' name='requesttype' id='requesttype' value="<%=strrequesttype%>">	
		<input type=hidden id='waittime' name='waittime' id='waittime' value="<%=strwaitime%>">	
		
		<input type=hidden id='websockurl' name='websockurl' id='websockurl' value="">
		<input type=hidden id='isDebugYN' name='isDebugYN' id='isDebugYN' value="<%=isDebugYN%>">
	</form>
</body>
</HTML>

