(function () {

    window.PsUhaClient = window.PsUhaClient || {};
    PsUhaClient = (function () {

        function RequestPayment(paymentReq) {

            try {

                var msg = {
                    MsgType: 'RequestPayment',
                    Data: paymentReq
                };

                PsUhaClient.socket.send(JSON.stringify(msg));
            }
            catch (ex) {

                if (PsUhaClient.ErrorCallback !== undefined) {
                    PsUhaClient.ErrorCallback('Error while sending payment request');
                }
            }
        }

        // Public interface
        return {
            RequestPayment: RequestPayment,
        };

    })();

})(window);

$(document).ready(function () {
    try {
        // Create a new WebSocket.
			var segment_id = "ICR", element_id = "WEBSOCKET_URL", standard_code = "INSCARDSTD";
			var websocketurl = getGetSegmentData(standard_code, segment_id, element_id);
			document.getElementById("websockurl").value = websocketurl;
			
			var requestType = document.getElementById("requesttype").value;		
	
			var documentModeStr = document.documentMode;
			
			PsUhaClient.socket = new WebSocket(websocketurl);
			
			//PsUhaClient.socket = new WebSocket('ws://localhost:5024');

			PsUhaClient.ReceiveHealthIdCallback =  function(evt) {HealthIdCallBack(evt)};
			PsUhaClient.PaymentResultCallback =  function(evt) {PaymentResultCallback(evt)};
			PsUhaClient.RequestPaymentAckCallback =  function(evt) {RequestPaymentAckCallback(evt)};
			PsUhaClient.ErrorCallback =  function(evt) {ErrorCallback(evt)};
			
			// Handle any errors that occur.
			PsUhaClient.socket.onerror = function (error) {

				if (PsUhaClient.ErrorCallback !== undefined) {
					PsUhaClient.ErrorCallback('WebSocket Error');
				}

			};

			// Show a connected message when the WebSocket is opened.
			PsUhaClient.socket.onopen = function (event) {
				if (requestType == 'RequestPayment'){
					sendPaymentRequest();
				}
			};

			// Handle messages sent by the server.
			PsUhaClient.socket.onmessage = function (event) {
				try {

					var message = JSON.parse(event.data);
					
					//send customer health ID to UHA server
					if (message.MsgType == 'CustInq') {
						if (PsUhaClient.ReceiveHealthIdCallback !== undefined) {
							PsUhaClient.ReceiveHealthIdCallback(message.Data);
						}
					}
					//Notify UHA server with customer payment
					else if (message.MsgType == 'PaymentResult') {
						if (PsUhaClient.PaymentResultCallback !== undefined) {
							PsUhaClient.PaymentResultCallback(message.Data);
						}
					}
					//Send UHA server customer info received
					else if (message.MsgType == 'RequestPaymentAck') {
						if (PsUhaClient.RequestPaymentAckCallback !== undefined) {
							PsUhaClient.RequestPaymentAckCallback(message.Data);
						}
					}
					//Send UHA server error
					else if (message.MsgType == 'Error') {
						if (PsUhaClient.ErrorCallback !== undefined) {
							PsUhaClient.ErrorCallback(message.Data);
						}
					}

				}
				catch (ex) {
					if (PsUhaClient.ErrorCallback !== undefined) {
                    	PsUhaClient.ErrorCallback('Error while receiving message from socket server');
					}

				}
			};

			// Show a disconnected message when the WebSocket is closed.
			PsUhaClient.socket.onclose = function (event) {

				if (PsUhaClient.ErrorCallback !== undefined) {
					PsUhaClient.ErrorCallback('WebSocket Closed');
				}

			};

    }
    catch (ex) {

        if (PsUhaClient.ErrorCallback !== undefined) {
            PsUhaClient.ErrorCallback('Initialization Error!');
        }
    }

});