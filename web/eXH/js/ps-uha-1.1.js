(function () {

	window.PsUhaClient = window.PsUhaClient || {};
	PsUhaClient = (function () {
		
		function sendCustomerInfo(customerInfo){
			
			PsUhaClient.socket.send(JSON.stringify(customerInfo));
		
		}
			
		// Public interface
        return {
            SendCustomerInfo: sendCustomerInfo,
        };

    })();

})(window);

$(document).ready(function()
	{
		  // Create a new WebSocket.
			var myNav = navigator.userAgent.toLowerCase();
			var segment_id = "ICR", element_id = "WEBSOCKET_URL", standard_code = "INSCARDSTD";
			var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
			document.getElementById("websockurl").value = websocketurl;
			alert(" Websocket... "+document.getElementById("websockurl").value);

		  PsUhaClient.socket = new WebSocket(websocketurl);  
		  //PsUhaClient.socket = new WebSocket('wss://echo.websocket.org/');  

		  PsUhaClient.HealthIdCallBack =  function(evt) {HealthIdCallBack(evt) };
		  PsUhaClient.NotifyPmtCallBack =  function(evt) {PaymentResultCallback(evt) };
		  PsUhaClient.RequestPaymentAckCallback =  function(evt) {RequestPaymentAckCallback(evt) };
		  PsUhaClient.ErrorCallback =  function(evt) {ErrorCallback(evt) };

		  // Handle any errors that occur.
		  PsUhaClient.socket.onerror = function(event) {
			$('.cnt-statuscallback').append('<h5 style="color:red"><p>'+event.data+'</p></h5>');
		  };

		  // Show a connected message when the WebSocket is opened.
		  PsUhaClient.socket.onopen = function(event) {
			$('.cnt-statuscallback').append('<h5 style="color:green"><p>WebSocket Connected</p></h5>');

			sendPaymentRequest();

			$('.cnt-statuscallback').append('<h5 style="color:green"><p>Payment request successfully made</p></h5>');


			var responseStr = "{ \"msgType\":\"NotifyPmt\",\"HealthId\":\"PX78901234\", \"Amount\":100.00, \"PaymentRef\":\"TX23457890\" }";

			PsUhaClient.socket.send(responseStr);

			
		  };

		  // Handle messages sent by the server.
		  PsUhaClient.socket.onmessage = function(event) {
			$('.cnt-statuscallback').append('<h5 style="color:green"><p>Message received successfully...</p></h5>');
			var message = JSON.parse(event.data);

			//get customer data from UHA server using healthID
			if(message.msgType == 'CustInq')
			{
				if(PsUhaClient.HealthIdCallBack !== undefined)
				{
					PsUhaClient.HealthIdCallBack(message.HealthId);
				}
			}
			//Notify UHA server with customer payment
			else if(message.msgType == 'NotifyPmt')
			{
				if(PsUhaClient.NotifyPmtCallBack !== undefined)
				{
					PsUhaClient.NotifyPmtCallBack({ "HealthId":message.HealthId, "Amount":message.Amount, "PaymentRef":message.PaymentRef });
				}
			}
		  };

		  // Show a disconnected message when the WebSocket is closed.
		  PsUhaClient.socket.onclose = function(event) {
			$('.cnt-statuscallback').append('<h5 style="color:green"><p>Websocket connection closed</p></h5>');
		  };
		  
	});