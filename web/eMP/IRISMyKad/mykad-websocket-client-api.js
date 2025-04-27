

WebSocketManager = {	
	url:"",
	init: function(url) {
		WebSocketManager.url = url;
	},	
	open: function(callback, slot) {	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"OPEN","Slot":"'+ slot +'"}'); 
		};    
		wsocket.onmessage = function (evt) {
					var obj = JSON.parse(evt.data);
					wsocket.close();
					callback(obj);
					//wsocket.close();
		};			
		
	},	
	listReader: function(callback) {	
	//alert('listReader in WebSocketManager.url : '+WebSocketManager.url);
	
	///////////////////
		
		/////////////////////////		
		var wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
		//	alert('onopen');
			wsocket.send('{"Cmd":"LIST_READER"}'); 
		};    
		wsocket.onmessage = function (evt) {
		//	alert('onmessage');
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);
		//	alert('data : '+data);
			wsocket.close();			
			callback(data, obj.RespCode);
			//wsocket.close();
		};			
		
	},	
	close: function(callback) {
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"CLOSE"}');
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);
			wsocket.close();
			callback(obj);
			//wsocket.close();
		};
	},	
	verifyFPTemplate: function(callback, ThumbCode, Bas64FPLeft, Bas64FPRight) {	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"VERIFY_FP_TEMPLATE","ThumbCode":"'+ ThumbCode +'","Bas64FPLeft":"'+ Bas64FPLeft +'","Bas64FPRight":"'+ Bas64FPRight +'"}'); 
		};    
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);
			wsocket.close();
			callback(obj.RespCode, obj.RespMessage);
			//wsocket.close();
		};			
		
	},
	readMyKad: function (callback) {   
//alert('testJsAPI_ReadMyKAD===');	
		wsocket = new WebSocket(WebSocketManager.url);
	//	alert(wsocket);
		wsocket.onopen = function () {
		//	alert('69,onopen');
			wsocket.send('{"Cmd":"READ_MYKAD"}'); 
		};		
		wsocket.onmessage = function (evt) {
		//	alert('data: '+data);
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
		//alert('end readMyKad');
	},
	readMyKid: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"READ_MYKID"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioEnrol: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_ENROL"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			//var data = JSON.parse(obj.RespMessage);
			wsocket.close();			
			callback(obj);
			//wsocket.close();
		};		
	},	
	getThumbImage: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"GET_MYKAD_THUMB_IMAGE"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);	
			wsocket.close();			
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	getThumbBin1: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"GET_THUMB_BIN1"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	getThumbBin2: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"GET_THUMB_BIN2"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioEnrolBin1: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_ENROL_BIN1"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			//var data = JSON.parse(obj.RespMessage);
			wsocket.close();			
			callback(obj);
			//wsocket.close();
		};		
	},	
	FPBioEnrolBin2: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_ENROL_BIN2"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			//var data = JSON.parse(obj.RespMessage);
			wsocket.close();			
			callback(obj);
			//wsocket.close();
		};		
	},	
	FPBioVerify: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioVerifyBin: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY_BIN"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioVerifyLeft: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY_LEFT"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioVerifyBinLeft: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY_BIN_LEFT"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioVerifyRight: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY_RIGHT"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	},	
	FPBioVerifyBinRight: function (callback) {   	
		wsocket = new WebSocket(WebSocketManager.url);
		wsocket.onopen = function () {
			wsocket.send('{"Cmd":"FP_BIO_VERIFY_BIN_RIGHT"}'); 
		};		
		wsocket.onmessage = function (evt) {
			var obj = JSON.parse(evt.data);		
			var data = JSON.parse(obj.RespMessage);		
			wsocket.close();
			callback(data, obj.RespCode, obj.RespSW12AndApiName);
			//wsocket.close();
		};		
	}	
}
