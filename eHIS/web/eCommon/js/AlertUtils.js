/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!"); 
		return;
	}else return request;
}

function getUnacknowledgedAlerts(userId){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/AlertUtils.jsp?methodName=getUnacknowledgedAlerts&userId="+userId;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send(""); 
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}
