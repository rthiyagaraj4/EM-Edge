function getOA_Message( message_ref, moduleId, param ) 
{
	if(param ==null)	param = new Array()
	var xmlHttp
	if(navigator.appName.indexOf("Internet") ==-1)
		xmlHttp = new XMLHttpRequest();
	else
		//xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        xmlHttp =  "";
	message_ref=message_ref.toUpperCase();
	moduleId = moduleId.toLowerCase()
	var urlString ="?msgId="+message_ref+"&moduleId="+moduleId

	for(var i=1;i<=param.length;i++) 
	{
		urlString +="&"+i+"="+param[i-1]
	}

	xmlHttp.open("POST","../../eCommon/jsp/MessageContainer.jsp"+urlString, false);
	xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
	xmlHttp.send();

	var xmlText = xmlHttp.responseText
	return(TrimStr(xmlHttp.responseText))
}


