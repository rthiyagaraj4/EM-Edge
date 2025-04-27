/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result     =   false ;
var message     =   "" ;
var flag        =   "" ;
async function searchSurgeons(obj){
	var formObj	= document.SlateSearchForm;
	formObj.surgeon_name.value="";
	formObj.surgeon.value="";
	var facility_id = formObj.facility_id.value;
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="Surgeons";
	var status = "E";
	tit="Surgeons "
	sql=escape("Select PHYSICIAN_ID,SHORT_NAME from SY_PHYSICIAN_MAST where FACILITY_ID='"+facility_id+"' and PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'E')='E'");
	search_code="PHYSICIAN_ID";
	search_desc= "SHORT_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (!(retVal == null))
	{
	    var retVal=unescape(retVal);
	    arr=retVal.split("::");
	    document.forms[0].surgeon_name.value=arr[0];
	    document.forms[0].surgeon.value=arr[1];
	}
}
function searchSlateWaitlist(){
	var formObj	= document.SlateSearchForm;
	formObj = document.SlateSearchForm;
	var retVal = checkForMandatoryFields(formObj);
	if(retVal==false){
		searchOTDetails('WAITLIST');
	}else{
		var errormessage  = getOTMessage("OT_MANDATORY");
        parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errormessage;
		//enableSearchCriteria();
	}
}
function checkForMandatoryFields(formObj){
	var msg = getOTMessage("CANNOT_BE_BLANK");
	var msgArray = msg.split("&");
	if(formObj.speciality.value ==""){
		alert(msgArray[0]+" Speciality "+(msgArray[1]));
		return true;
	}
	return false;
}
function lockKey(){
    if(event.keyCode == 93)
        alert(getOTMessage("APP-OT0084"));
}
