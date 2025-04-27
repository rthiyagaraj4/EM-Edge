async function getGatewayServerID(protocolLinkID, message)
{	 
	var url = '../../eXH/jsp/GatewayServerList.jsp?protocolLinkID='+protocolLinkID+'&message='+message;
	var arguments = new Array();
	var dialogTop = "300";
	var dialogHeight = "15vh" ;
	var dialogLeft = "400" ;
	var dialogWidth  = "45vw" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	return await window.showModalDialog(url,arguments,features);	
}