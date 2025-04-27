/*
function sendRequest(query,field)
{		
	clearOption(field);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " query=\""+query+"\"";
	xmlStr += " field=\""+field+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","XHAjaxUtil.jsp",false);	
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
}
function clearOption(field)	{ 	
	list_obj = document.getElementById(field);
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove(field) ;
	}

	var tp = "All" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}
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
	eval(xmlHttp.responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));	
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
