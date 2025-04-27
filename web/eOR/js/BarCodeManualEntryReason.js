/*
--------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
Date       Edit History     		 Name       		Rev.Date   	Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1
--------------------------------------------------------------------------------------------------------------
*/ 
function displayDesc(obj)
{
	frmObj=document.manualBarCodeReason;
	
	if(frmObj.manual_reason.value!="O" && frmObj.manual_reason.value!=""){
	     frmObj.reason_desc.value = obj.options[obj.selectedIndex].text;
	       frmObj.reason_desc.readOnly = true;
	}
	else{
		frmObj.reason_desc.readOnly = false;
		frmObj.reason_desc.value ="";
	    
	}
}

function closeWindow(remarks_mandetory_yn)
{
	var retArray	= new Array();
	//alert("remarks_mandetory_yn==="+remarks_mandetory_yn+"reason_desc=="+document.manualBarCodeReason.reason_desc.value);
	if(remarks_mandetory_yn == 'Y' && document.manualBarCodeReason.reason_desc.value == "")
	{
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
			   msg = msg.replace('$', getLabel("Common.remarks.label","Common"));
			   alert(msg);
		//window.returnValue = "";
		return false;
	}
	else if(document.manualBarCodeReason.reason_desc.value.length >= 255) 
	{
		       msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			   msg = msg.replace('$', "RAMARKS");
			   msg = msg.replace('#', "255");
			   alert(msg);
		//window.returnValue = "";
		return false;
	}
	else
	{
		return true;
		//window.returnValue = retArray;
	}
	//window.close();
}

function CheckMaxLength(obj,max) 
{  
	if(obj.value.length >= max) 
	{
		msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			   msg = msg.replace('$', "RAMARKS");
			   msg = msg.replace('#', "255");
			   alert(msg);
		obj.focus();
		return false;
	}
	else 
		return true;
}

function saveManulRemarks(bean_id,bean_name,patient_id,encounter_id,menu_id,sub_menu_id,module_id,entry_type,order_id,order_line_no,item_code,batch_id,patient_class,remarks_mandetory_yn,speciality){
	 var result =closeWindow(remarks_mandetory_yn);
	 //alert("result=="+result)
		 if(result){
	    var retVal = "";
		var reason_code = document.manualBarCodeReason.manual_reason.value;
        var reason_desc = document.manualBarCodeReason.reason_desc.value;
		if(module_id == "BT"){
			window.returnValue = reason_code +"||"+reason_desc;
			window.close();
		}else{
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\"" + bean_id + "\"";
		xmlStr += " bean_name=\"" + bean_name + "\"";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " menu_id=\""+menu_id+"\"";
		xmlStr += " sub_menu_id=\""+sub_menu_id+"\"";
		xmlStr += " module_id=\""+module_id+"\"";
		xmlStr += " reason_code=\""+reason_code+"\"";
		xmlStr += " reason_desc=\""+encodeURIComponent(reason_desc)+"\"";
        xmlStr += " entry_type=\""+entry_type+"\"";
		xmlStr += " order_id=\""+order_id+"\"";
        xmlStr += " order_line_no=\""+order_line_no+"\"";
        xmlStr += " item_code=\""+item_code+"\"";
        xmlStr += " batch_id=\""+batch_id+"\"";
		xmlStr += " patient_class=\""+patient_class+"\"";
        xmlStr += " speciality=\""+speciality+"\"";
		xmlStr +=" /></root>";
		
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
        window.returnValue=true;
		window.close()
		}
		
		}
			
}
