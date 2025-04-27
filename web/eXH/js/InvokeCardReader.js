window.onload = function() {

    // Get references to elements on the page.

	alert("1");
    var form = document.getElementById("message-form");

	alert("2");

	var websocketuri = document.getElementById("websocketuri");
	var messageField = document.getElementById("request");	

	alert("3");
	
    var socketStatus = document.getElementById("status");

	var messagesList = document.getElementById("messagesList");
	var messageField = document.getElementById("insuranceid");

	alert("4");
    
	var connectBtn = document.getElementById("connect");
	var sendBtn = document.getElementById("send");
	var closeBtn = document.getElementById("close");

	alert("5");
  
  
    // Create a new WebSocket.
    //var socket = new WebSocket("ws://localhost:8025/ws/chat");
	var socket;

	alert("6");
    
    
    // Handle any errors that occur.
    socket.onerror = function(error) {
      console.log("WebSocket Error: " + error);
	  socketStatus.innerHTML = error;
    };
  
	alert("7");

    // Show a connected message when the WebSocket is opened.
    socket.onopen = function(event) {
      socketStatus.innerHTML = "Connected to: " + event.currentTarget.url;
      socketStatus.className = "open";
    };
  
	alert("8");
  
    // Handle messages sent by the server.
    socket.onmessage = function(event) {
		var message = event.data;
		messagesList.innerHTML += "<li class="received"><span>Received:</span>" + message + "</li>";
		alert("message recieve from the server",event.data.message)
		var data = JSON.parse(message);
		var x=data.message;
		document.getElementById("insuranceid").innerHTML = x;
    };
  
	alert("9");
  
    // Show a disconnected message when the WebSocket is closed.
    socket.onclose = function(event) {
      socketStatus.innerHTML = "Disconnected from WebSocket.";
      socketStatus.className = "closed";
    };
  
  
    alert("10");

	// Create the WebSocket connection when the Connect button is clicked.
    connectBtn.onclick = function(e) {
      e.preventDefault();
	
		alert(websocketuri.value);
      // Create the WebSocket Connection.
      socket = new WebSocket(websocketuri.value);

	  alert(websocketuri.value);

		socketStatus.innerHTML = "Connected";
      return false;
    };

	alert("11");

	// Sends the message to WebSocket connection when the send button is clicked.
    sendBtn.onclick = function(e) {
      e.preventDefault();
  
       // Retrieve the message from the textarea.
      var message = {
        "message": messageField.value ,
        "sender" : "client",
        "timeStamp": "Wed Aug 12 16:55:15 EET 2020"
      };
  
  
      message = JSON.stringify(message);
      // Send the message through the WebSocket.
      socket.send(message);
  
      // Add the message to the messages list.
      messagesList.innerHTML += "<li class="sent"><span>Sent:</span>" + message +
                                "</li>";
  
      // Clear out the message field.
      //messageField.value = "";
  
      return false;
    };
  
	alert("12");
  
    // Close the WebSocket connection when the close button is clicked.
    closeBtn.onclick = function(e) {
      e.preventDefault();
  
      // Close the WebSocket.
      socket.close();
  
      return false;
    };

	alert("13");
  
  };

