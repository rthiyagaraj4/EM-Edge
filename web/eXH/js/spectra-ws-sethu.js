(function () {

    window.SpectraClient = window.SpectraClient || {};
    SpectraClient = (function () {
    	
    	function handleCOMConnect(comRequest){
    		alert("handleCOMConnect:"+comRequest);

            try {

                SpectraClient.socket.send(comRequest);
            }
            catch (ex) {

                if (SpectraClient.ErrorCallback !== undefined) {
                    SpectraClient.ErrorCallback('Error while sending handle COM Connect');
                }
            }
    	}

        function RequestPayment(paymentReq) {
        	alert("RequestPayment:"+paymentReq);

            try {

                SpectraClient.socket.send(paymentReq);
            }
            catch (ex) {

                if (SpectraClient.ErrorCallback !== undefined) {
                    SpectraClient.ErrorCallback('Error while sending payment request');
                }
            }
        }

        // Public interface
        return {
            RequestPayment: RequestPayment
        };

    })();

})(window);

$(document).ready(function () {
    try {
        // Create a new WebSocket.
			//var segment_id = "SWEB", element_id = "WEBSOCKET_URL", standard_code = "SPECTRAWEBCC1";
			//document.getElementById("websockurl").value = websocketurl;
    		//var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
			
			var websocketurl = document.getElementById("websocketurl").value;
			var requestType = document.getElementById("requesttype").value;		
	
			alert("RequestPayment:"+requestType+" websocketurl:"+websocketurl);
			
			SpectraClient.socket = new WebSocket(websocketurl);
			
			
			//SpectraClient.socket = new WebSocket('ws://localhost:5000/messages');

			SpectraClient.ReceiveHealthIdCallback =  function(evt) {HealthIdCallBack(evt)};
			SpectraClient.ConnectionCallBack =  function(evt) {ConnectionCallBack(evt)};
			SpectraClient.OnTerminalActionCallback = function(evt) {OnTerminalActionCallback(evt)};
			SpectraClient.PaymentResultCallback =  function(evt) {PaymentResultCallback(evt)};
			SpectraClient.RequestPaymentAckCallback =  function(evt) {RequestPaymentAckCallback(evt)};
			SpectraClient.ErrorCallback =  function(evt) {ErrorCallback(evt)};
			
			// Handle any errors that occur.
			SpectraClient.socket.onerror = function (error) {
				alert("onerror:"+error);
				if (SpectraClient.ErrorCallback !== undefined) {
					SpectraClient.ErrorCallback('WebSocket Error');
				}

			};

			// Show a connected message when the WebSocket is opened.
			SpectraClient.socket.onopen = function (event) {
				alert("onopen:"+event);
				
				if (requestType == 'RequestPayment'){
					getCOMConnect();
					sendPaymentRequest();
					
				}
			};

			// Handle messages sent by the server.
			SpectraClient.socket.onmessage = function (event) {
				try {
					 
					var message = JSON.parse(event.data);
					
					alert("Received message: " + JSON.stringify(message));
					
					//send customer health ID to UHA server
					if (message.Event == 'OnConnect' || message.Event == 'OnDisConnect') {
						if (SpectraClient.ConnectionCallBack !== undefined) {
							SpectraClient.ConnectionCallBack(message);
						}
					}
					else if (message.Event == 'OnTerminalAction') {
						if (SpectraClient.OnTerminalActionCallback !== undefined) {
							SpectraClient.OnTerminalActionCallback(message.JsonResult);
						}
					}
					//Notify UHA server with customer payment
					else if (message.Event == 'OnDataReceive') {
						if (SpectraClient.PaymentResultCallback !== undefined) {
							SpectraClient.PaymentResultCallback(message);
						}
					}
					//Send UHA server customer info received
					else if (message.Event == 'OnWrite') {
						if (SpectraClient.RequestPaymentAckCallback !== undefined) {
							SpectraClient.RequestPaymentAckCallback(message);
						}
					}
					//Send UHA server error
					else if (message.Event == 'OnError') {
						if (SpectraClient.ErrorCallback !== undefined) {
							SpectraClient.ErrorCallback(message.Message);
						}
					}

				}
				catch (ex) {
					if (SpectraClient.ErrorCallback !== undefined) {
                    	SpectraClient.ErrorCallback('Error while receiving message from socket server');
					}

				}
			};

			// Show a disconnected message when the WebSocket is closed.
			SpectraClient.socket.onclose = function (event) {
				alert("onclose:"+event);
				if (SpectraClient.ErrorCallback !== undefined) {
					SpectraClient.ErrorCallback('WebSocket Closed');
				}

			};

    }
    catch (ex) {

        if (SpectraClient.ErrorCallback !== undefined) {
            SpectraClient.ErrorCallback('Initialization Error!');
        }
    }

});