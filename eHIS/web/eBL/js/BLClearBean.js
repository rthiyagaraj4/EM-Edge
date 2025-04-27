function clearBeanForBilling(){
	var url="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=clearBeanFromMP";
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
}
