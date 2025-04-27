var 	returnVal="";
	 
	var ip=window.location.hostname;
	var height = 0;
	let fingerReturnVal="";
	//var websocket_url = "wss://"+ip+":5963/mykadwebsocket";
	var websocket_url = "wss://localhost:5963/mykadwebsocket";
var func_name="";
window.onload = function()
	{
	func_name=document.getElementById("func_name").value;
 
	//alert('window.onload') 
 try{
		var emailOutput="";
	 	WebSocketManager.init(websocket_url);
		//WebSocketManager.init("wss://localhost:5963/mykadwebsocket"); 
		//returnVal = WebSocketManager.listReader(ListSlotsCallback);	
		//setTimeout("WebSocketManager.listReader(ListSlotsCallback)", 5000);
		returnVal = setTimeout("emailOutput = WebSocketManager.listReader(ListSlotsCallback)",1000);
		//WebSocketManager.listReader(ListSlotsCallback);	
		//	returnVal = WebSocketManager.readMyKad(myReadMyKadCallback);	  
		
	}catch(exception){
		alert("exception : "+exception.description)
	}
}
function ListSlotsCallback(data, respcode)
	{
//	alert('ListSlotsCallback');
//	alert("ListReader>> Message: " + data);
//	alert("ListReader>> RespCode: " + respcode);
		//displayMessage("ListReader>> RespCode: " + respcode);
	//	displayMessage("ListReader>> Message: " + data);	
		var slots = data.toString().split(',');
	//	var strSlotListContent = "<b>Select Slot:</b> <select id='cbReaderSlot' style='height:25px'>";
	//	strSlotListContent += "<option value='' selected>-- Reader slot (config file) --</option>";		
		//Get reader name from config file
		//var ReaderName = 'IRIS BCR200DTP 11111001080600062 CT01 2';
	//	var ReaderName = document.getElementById('ReaderNameInput').value;
		var ReaderName ="";
		var i;
	/*		alert('slots.length : '+slots.length);
		for(i=0; i < slots.length; i++)
		{
		//	strSlotListContent += "<option value='"+ slots[i] +"'>"+ slots[i] +"</option>";
			
			//IRIS BCR200DTP 11111001080600062 CT01 2
			//Returns -1 when a substring cannot be found
			alert('slots[i].indexOf(BCR200) : '+slots[i].indexOf('BCR200'));
			alert('slots[i].indexOf(CT01) : '+slots[i].indexOf('CT01'));
			alert('slots[i].indexOf(BCR610) : '+slots[i].indexOf('BCR610'));
			if((slots[i].indexOf('BCR200') != -1) && (slots[i].indexOf('CT01') != -1) && (slots[i].indexOf('BCR610') != -1))
			{
				//Each BCR200DTP reader ID (eg: 11111001080600062) will be different
				//Get the real reader name from listReader function
				ReaderName = slots[i];
				alert('ReaderName111 : '+ReaderName);
			}
		}  */
		ReaderName=slots;
		setTimeout(WebSocketManager.open(OpenReaderCallback, ReaderName), 1000);
	}
function OpenReaderCallback(data)
	{
	//alert('OpenReaderCallback');
	//alert(data.RespMessage + ', RespCode: ' + data.RespCode + ', SW12: ' + data.RespSW12AndApiName)
		if(typeof data == 'object')
		{
			if(data.RespCode == 0)
			{
				// Read MyKad
				//('setTimeout(WebSocketManager.readMyKad');
				setTimeout(WebSocketManager.readMyKad(myReadMyKadCallback), 1000);
			}
		
			else
			{
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
			}
		}
	}
function myReadMyKadCallback(data, respcode, sw12AndApiName)
	{
	//alert('myReadMyKadCallback : respcode : '+respcode)
	//alert("readMyKad>> RespCode:" + respcode);
	//alert("readMyKad>> SW12AndApiName: " + sw12AndApiName);
		if(typeof data == 'object')
		{
			if(respcode == 0)
			{
				fingerReturnVal=data;
			//alert("Do you want to verify Finger Print2 ?");
			  
			//var message= "Do you want to verify Finger Print ?";
			var validFinger=false;
			
		$("#preloader").hide();
		var confirmBox = $("#confirm");
		confirmBox.find(".message").text("Do you want to verify Finger Print ?");
		confirmBox.show();
		confirmBox.find(".Ok").unbind().click(function() {
		confirmBox.hide();
		WebSocketManager.FPBioVerify(VerifyFPCallback);
		});
		confirmBox.find(".Cancel").unbind().click(function() { 
		confirmBox.hide();
		/*Condition to overwrite details in Change Patient Details*/
 
		if(func_name=='CP') {
				var confirmBox1 = $("#overwrite");
		confirmBox1.find(".message").text("Do you want to overwrite the details ?");
 
		confirmBox1.show();
 
		confirmBox1.find(".Ok").unbind().click(function() {
		confirmBox1.hide();
		returnVal=fingerReturnVal;
		window.opener.getMyKadValue(returnVal)
		setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
		});
		confirmBox1.find(".Cancel").unbind().click(function() { 
		confirmBox1.hide();
		
 
		returnVal="";
		window.opener.getMyKadValue(returnVal);
		setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
		});
		}
		else {
		/*Populate the values in other screens*/
		returnVal=fingerReturnVal;
		window.opener.getMyKadValue(returnVal);
		setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
		}
		});
		/*	if(confirm(message))
			{
				validFinger=true;
		
			//	WebSocketManager.verifyFPTemplate(verifyFPTemplateCallback, 3, "","");	
				WebSocketManager.FPBioVerify(VerifyFPCallback);
			}else
			{
				
				validFinger=false;
				returnVal=data;
				window.opener.getMyKadValue(returnVal);
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
				//parent.frames[0].document.getElementById("reset").click();
			}*/
			
		/*	if(!validFinger)
				{
				returnVal=data;
				window.opener.getMyKadValue(returnVal);
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
				}*/
			}	
		else if(respcode  == -87)
			{
		//	alert('setTimeout(WebSocketManager.readMyKid');
			setTimeout(WebSocketManager.readMyKid(myReadMyKidCallback), 1000);	
				
			}
			else
			{
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
			}
		}
	}
	function myReadMyKidCallback(data, respcode, sw12AndApiName)
	{
	//	alert('myReadMyKidCallback respcode : '+respcode)			
		//alert("readMyKid>> RespCode:" + respcode);
		//alert("readMyKid>> SW12AndApiName: " + sw12AndApiName);
		if(typeof data == 'object')
		{
			if(respcode == 0)
			{
			returnVal=data;
			window.opener.getMyKadValue(returnVal);
			}
			else 
			{
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);
				
			}
		
		}
	}
	function closeReader_Callback(data)
	{
	//	alert('closeReader_Callback');
		if(typeof data == 'object')
		{
		//	alert(data.RespMessage + ', RespCode: ' + data.RespCode + ', SW12: ' + data.RespSW12AndApiName);
		}
	}
	
////////////////
		
	function VerifyFPCallback(data, respcode, sw12AndApiName)
	{
	//	alert("VerifyFP>> RespCode: " + respcode);
		//alert("VerifyFP>> Sw12AndApiName: " + sw12AndApiName);
		//alert("VerifyFP>> Status: " + data.Verified);
		if(respcode == 0)
			{
			
		//	alert('Finger Verification Successful');
			var confirmBox = $("#fingerFail");
			confirmBox.find(".message").text("Finger Verification Successful");
			confirmBox.show();
			confirmBox.find(".Ok").unbind().click(function() {
			confirmBox.hide();
			/*Condition to overwrite details in Change Patient Details after Finger Print*/
			if(func_name=='CP') {
					var confirmBox1 = $("#overwrite");
					confirmBox1.find(".message").text("Do you want to overwrite the details ?");
					confirmBox1.show();
					confirmBox1.find(".Ok").unbind().click(function() {
					confirmBox1.hide();
					returnVal=fingerReturnVal;
					window.opener.getMyKadValue(returnVal);
					setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
					});
					confirmBox1.find(".Cancel").unbind().click(function() { 
					confirmBox1.hide();
					returnVal="";
					window.opener.getMyKadValue(returnVal);
					setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
					});	
			}
			else {
				/*Populate the values in other screens after Finger Print*/
				returnVal=fingerReturnVal;
				window.opener.getMyKadValue(returnVal);
				setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
				}
			});	
			
		//	returnVal=fingerReturnVal;
		//	window.opener.getMyKadValue(returnVal);
		//	setTimeout(WebSocketManager.close(closeReader_Callback), 1000);			
			
			}
		else {
		//	alert('Finger Verification Failed');
			var confirmBox = $("#fingerFail");
			confirmBox.find(".message").text("Finger Verification Failed");
			confirmBox.show();
			confirmBox.find(".Ok").unbind().click(function() {
			confirmBox.hide();
			returnVal="";
			window.opener.getMyKadValue(returnVal);
			setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
			});
		//	returnVal="";
		//	window.opener.getMyKadValue(returnVal);
		//	setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
			}	
	}
/*	function verifyFPTemplateCallback(respcode, respMessage)
	{
			alert('verifyFPTemplateCallback in IRISMyKad.js');	
		alert("verifyFPTemplate>> RespCode:" + respcode);
		alert("verifyFPTemplate>> respMessage: " + respMessage);
		alert(fingerReturnVal)
		if(respcode == 0)
			{
			returnVal=fingerReturnVal;
			window.opener.getMyKadValue(returnVal);
			setTimeout(WebSocketManager.close(closeReader_Callback), 1000);	
			}
		else {
			alert('Finger Verification failed');
		}	
		
	}*/

