/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function searchReason(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";	
	var locale = document.forms[0].locale.value;
	if(target.name == desc_name){
		//tit="Search Reasons"
		tit=getLabel("Common.reason.label","Common");
		//var sql="SELECT REASON_DESC description, REASON_CODE code FROM OT_REASONS WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE='TT' AND NVL(ACTIVE_YN,'N')='Y')  and upper( REASON_DESC) like upper(?) and upper(REASON_CODE) like upper(?) order by 2";
		var sql="SELECT REASON_DESC description, REASON_CODE code FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE='TT' AND NVL(ACTIVE_YN,'N')='Y')  and upper( REASON_DESC) like upper(?) and upper(REASON_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"' order by 2";

		
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}

}

function CheckMandatoryFields(){
	var submitflag = 'false';
	var messageFrame = parent.parent.messageFrame;
	var formObj=document.frames.transfer_ot_frame.document.TransferToOTDetailForm;
	var fields= new Array(formObj.theatre_type,formObj.theatre,formObj.reason_desc,formObj.status_code);
	//var names=new Array("Theatre Type",	"Theatre","Reason","Change Status");	
	var theatretype=getLabel("eOT.TheatreType.Label","OT");
	var theatre=getLabel("Common.Theatre.label","Common");
	var reason=getLabel("Common.reason.label","Common");
	var changestatusto=getLabel("eOT.ChangeStatusto.Label","OT");
	var names=new Array(theatretype,theatre,reason,changestatusto);		
	if(checkFields(fields,names,messageFrame)){
		submitflag=true;
	}else{
		submitflag=false;
	}
	return submitflag;
}


function reset(){
	var formObj = document.frames.transfer_ot_frame.document.TransferToOTDetailForm;
	var messageFrame = parent.messageFrame;
	formObj.reset();
	document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

function apply(){
	var formObj = document.frames.transfer_ot_frame.document.TransferToOTDetailForm;
	//Added Against PMG2016-KDAH-CRF-0001
	var multi_check_in_yn=formObj.multi_check_in_yn.value;

	if(multi_check_in_yn=="N"){
	var check_in_date_time="";
	var oper_room_code=formObj.theatre.value;
	var facility_id=formObj.facility_id.value;
	var isOTVaccant=isOTAvailable(check_in_date_time,oper_room_code,facility_id,'','Transfer_Back_To_OT');
	if(isOTVaccant!=""){
		var msg=getMessage("APP-OT0235","OT");
		var messageFrame = parent.messageFrame;
		document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}
	}
	//PMG2016-KDAH-CRF-0001 ends
		
	if(CheckMandatoryFields()){
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest();
		//var called_from = formObj.called_from.value;
		var xmlStr ="<root><SEARCH ";
		var called_from = formObj.called_from.value;
		xmlStr += "oper_num=\""+ formObj.oper_num.value +  "\" ";
		xmlStr += "slate_user_id=\""+ formObj.slate_user_id.value +  "\" ";
		xmlStr += "theatre=\""+ formObj.theatre.value +  "\" ";
		xmlStr += "reason_code=\""+ formObj.reason_code.value +  "\" ";
		xmlStr += "status_code=\""+ formObj.status_code.value +  "\" ";
		xmlStr += "remarks_desc=\""+ encodeURIComponent(formObj.remarks_desc.value,"UTF-8") +  "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert(xmlStr);
		xmlHttp.open("POST","TransferToOTValidation.jsp?func_mode=recordtransferDtls",false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		//alert(retVal);
		if(retVal!=null && retVal!=""){
				if(called_from=="OT_SLATE"){
					window.returnValue=getMessage("RECORD_INSERTED","SM");
					alert(window.returnValue);
					window.close();
				}
		} 
	}
}

function assign()
{
	var frmObj=document.TransferToOTDetailForm;
	frmObj.theatre_type.value=frmObj.theatre_type.DB_VALUE;
	frmObj.status_code.value=frmObj.status_code.DB_VALUE;
}	

function funLoadValues(obj){
	formObj = document.TransferToOTDetailForm;
	var theatre_type = obj.value;
	var oper_num = formObj.oper_num.value;
	var slate_user_id=formObj.slate_user_id.value;
	var called_from = formObj.called_from.value;
	var reason_code = formObj.reason_code.value;
	var reason_desc = formObj.reason_desc.value;
	parent.transfer_ot_frame.location.href='../../eOT/jsp/TransferToOTDetails.jsp?&reason_desc='+reason_desc+'&theatre_type='+theatre_type+'&oper_num='+oper_num+'&slate_user_id='+slate_user_id+'&called_from='+called_from+'&reason_code='+reason_code;
}

 function checkLimit(field, limit){
	 var messageFrame = parent.messageFrame;
	//document.frames.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

	 if (field.value.length > limit){
           var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   //alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   error=msgArray[0]+""+msgArray[1]+limit+msgArray[2];
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
		   parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
	  }
}

//Added Against PMG2016-KDAH-CRF-0001 starts
 /*function isOTAvailable(check_in_date_time,oper_room_code,facility_id){
 	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=isOTAvailable&oper_room_code="+oper_room_code+"&check_in_date_time="+check_in_date_time+"&facility_id="+facility_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;	  
 }*/
 
 function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading space
	  return sInString.replace(/^\s+|\s+$/g,"");
	}
//Added Against PMG2016-KDAH-CRF-0001 ends
