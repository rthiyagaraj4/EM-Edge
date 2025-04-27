(function () {
    // Create or extend the SpectraClient namespace
    window.SpectraClient = window.SpectraClient || {};

    // Define SpectraClient module
    SpectraClient = (function () {
        // Private functions
        function sendRequest(data) { 
			//alert(data.Operation);
            try {
                SpectraClient.socket.send(data);
            } catch (ex) {
                if (SpectraClient.ErrorCallback !== undefined) {
					if(data.Operation == 'CONNECT'){
						SpectraClient.ErrorCallback('Error while sending handle COM Connect');
					} else if(data.Operation == 'PURCHASE'){
						SpectraClient.ErrorCallback('Error while sending payment request');
					}
                }
            }
        }

        // Public interface
        return {
            sendRequest: sendRequest
        };
    })();

})();

$(document).ready(function () {
	
    try {
		
		SpectraClient.ConnectionCallBack =  function(evt) {ConnectionCallBack(evt)};
		SpectraClient.OnTerminalActionCallback = function(evt) {OnTerminalActionCallback(evt)};
		SpectraClient.PaymentResultCallback =  function(evt) {PaymentResultCallback(evt)};
		SpectraClient.RequestPaymentAckCallback =  function(evt) {RequestPaymentAckCallback(evt)};
		SpectraClient.ErrorCallback =  function(evt) {ErrorCallback(evt)};
		
        // Get WebSocket URL and request type from DOM
		const websocketurl = document.getElementById("websocketurl").value;
		const requestType = document.getElementById("requesttype").value;		
	
		alert("RequestPayment:"+requestType+" websocketurl:"+websocketurl);
		
        // Define WebSocket connection
        SpectraClient.socket = new WebSocket(websocketurl);

        // Error handling
        SpectraClient.socket.onerror = function (error) {
            if (SpectraClient.ErrorCallback !== undefined) {
                SpectraClient.ErrorCallback('WebSocket Error: ' + error);
            }
        };

        // WebSocket connection established
        SpectraClient.socket.onopen = function (event) {
            if (requestType === 'RequestPayment') {
				getCOMConnect();
				sendPaymentRequest();
            }
        };

        // Handle incoming messages
        SpectraClient.socket.onmessage = function (event) {
            try {
                var message = JSON.parse(event.data);

                switch (message.Event) {
                    case 'OnConnect':
                    case 'OnDisConnect':
                        if (SpectraClient.ConnectionCallBack !== undefined) {
                            SpectraClient.ConnectionCallBack(message);
                        }
                        break;
                    case 'OnTerminalAction':
                        if (SpectraClient.OnTerminalActionCallback !== undefined) {
                            SpectraClient.OnTerminalActionCallback(message.JsonResult);
                        }
                        break;
                    case 'OnDataReceive':
                        if (SpectraClient.PaymentResultCallback !== undefined) {
                            SpectraClient.PaymentResultCallback(message);
                        }
                        break;
                    case 'OnWrite':
                        if (SpectraClient.RequestPaymentAckCallback !== undefined) {
                            SpectraClient.RequestPaymentAckCallback(message);
                        }
                        break;
                    case 'OnError':
                        if (SpectraClient.ErrorCallback !== undefined) {
                            SpectraClient.ErrorCallback(message.Message);
                        }
                        break;
                    default:
                        break;
                }
            } catch (ex) {
                if (SpectraClient.ErrorCallback !== undefined) {
                    SpectraClient.ErrorCallback('Error while receiving message from socket server');
                }
            }
        };

        // WebSocket connection closed
        SpectraClient.socket.onclose = function (event) {
            if (SpectraClient.ErrorCallback !== undefined) {
                SpectraClient.ErrorCallback('WebSocket Closed: ' + event.code + ', ' + event.reason);
            }
        };
    } catch (ex) {
		alert('Exception: '+ex);
        if (SpectraClient.ErrorCallback !== undefined) {
            SpectraClient.ErrorCallback('Initialization Error: ' + ex.message);
        }
    }
});
