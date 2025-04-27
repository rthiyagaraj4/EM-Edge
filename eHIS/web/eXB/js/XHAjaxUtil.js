/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function addOptions(id,desc,field)	
{  
	var element = document.createElement('OPTION') ;
	element.value = id ;
	element.text = desc ;
	document.getElementById(field).add(element);
}

function sendRequest(query,field,defaultItem,toDisplay)
{		
//	alert("sendRequest");
	clearOption(field,defaultItem);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " query=\""+query+"\"";
	xmlStr += " field=\""+field+"\"";
	xmlStr += " toDisplay=\""+toDisplay+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","XHAjaxUtil.jsp",false);	
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
}
function clearOption(field,defaultItem)	
{ 	
	list_obj = document.getElementById(field);
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) 
	{
		list_obj.remove(field) ;
	}

	var tp = defaultItem ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}

// Function sends a request and retrives the desired value.
function getValue(query)
{			
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " query=\""+query+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","XHAjaxUtil.jsp",false);	
	xmlHttp.send(xmlDoc);
	return xmlHttp.responseText;	
}
