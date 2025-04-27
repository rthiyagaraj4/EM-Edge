/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
async function confirmFinalize() 
{
	/**
	  * @user - SS_PREPARE_HDR 
	  */
	var retVal="";
	var dialogHeight= "30vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
//	var url = "../../eSS/html/ConfirmTransaction.html";
	var url = "../../eSS/jsp/ConfirmTransaction.jsp";
	retVal =await window.showModalDialog(url,arguments,features);

	if(retVal == null) {
		retVal="";
	}
	return retVal;
}
async function confirmCancel() 
{
	/**
	  * @user - SS_CANCEL_REQUEST
	  */
	var retVal="";
	var dialogHeight= "30vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
//	var url = "../../eSS/html/ConfirmCancel.html";
	var url = "../../eSS/jsp/ConfirmCancel.jsp";
	retVal =await window.showModalDialog(url,arguments,features);

	if(retVal == null) {
		retVal="";
	}
	return retVal;
}

async function confirmAuthorize() 
{
	/**
	  * @user - SS_REQUEST_HDR 
	  */
	var retVal="";
	var dialogHeight= "30vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	//var url = "../../eSS/html/ConfirmAuthorize.html";
	var url = "../../eSS/jsp/ConfirmAuthorize.jsp";
	retVal =await window.showModalDialog(url,arguments,features);
	if(retVal == null) {
		retVal="";
	}
	return retVal;
}
async function confirmDelete() 
{
	/**
	  * @user - SS_PREPARE_HDR 
	  */
	var retVal="";
	var dialogHeight= "30vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
//	var url = "../../eSS/html/ConfirmDelete.html";
	var url = "../../eSS/jsp/ConfirmDelete.jsp";
	retVal = await window.showModalDialog(url,arguments,features);

	if(retVal == null) {
		retVal="";
	}
	return retVal;
}

function validateGroupCodeSearch(group_code,group_desc,function_type, group_type_code) {
	if (group_desc.value =="" || group_desc.readOnly || group_desc.disabled) {
		return true;
	}
	if (function_type == null) {
		function_type = '1';
	}
	var xmlDom = "";//new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var arrayObjects = new Array();
	arrayObjects[0] = group_code;
	arrayObjects[1] = group_desc;
	if (group_type_code != null) {
		arrayObjects[2] = group_type_code;
	}
	var xmlString = "";
	
	for (index=0;index<arrayObjects.length;index++)	{
			xmlString += arrayObjects[index].name+"=\""+ checkSpl(arrayObjects[index].value) +"\" ";
	}
	xmlString += " function_type=\""+function_type+"\"";
	xmlString ="<root><SEARCH "+xmlString+" /></root>";
 	//xmlDom.loadXML(xmlString);
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/GroupSearchValidate.jsp", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval(responseText);
 	var msgFrame = top.content.messageFrame;
 	if (!result) {
		msgFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+message;
		group_desc.focus();
		return result;
	}
	group_desc.readOnly = true;
	msgFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	return result;
}

async function confirmPrinting() {
	
	var retVal = "";
	var dialogHeight = "30vh";
	var dialogWidth = "30vw";
	var dialogTop = "230";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eSS/jsp/ConfirmOnlinePrint.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
