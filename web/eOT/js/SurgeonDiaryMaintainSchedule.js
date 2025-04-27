/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var sch_flag="N";

function reset() {

	 if(f_query_add_mod.document.location.href.indexOf("SurgeonDiaryMaintainSchedule.jsp") != -1)
		  return false;
	 else
		window.frames[2].location.href="../../eCommon/html/blank.html";
		f_query_add_mod.document.location.reload();
}


function apply() {
	//var surgeon_code =parent.frames[1].f_query_add_mod.document.forms[0].surgeon_code.value; 
	//var from_date =parent.frames[1].f_query_add_mod.document.forms[0].from_date.value; 
	//var to_date =parent.frames[1].f_query_add_mod.document.forms[0].to_date.value; 	
	var surgeon_code =parent.content.f_query_add_mod.document.forms[0].surgeon_code.value; 
	var from_date =parent.content.f_query_add_mod.document.forms[0].from_date.value; 
	var to_date =parent.content.f_query_add_mod.document.forms[0].to_date.value; 	
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var message = "";
	var xmlStr="<root>";
	var action = "../../servlet/eOT.SurgeonDiaryMaintainScheduleServlet";
	xmlStr+=formXMLString();
	xmlStr+="</root>";
	if(xmlStr.indexOf("<root></root>")!=-1)
	{
		var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		return;
	}
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal==0){
//		var mesg=retVal+" - "+getMessage("Common.Appointments.label","Common")+" "+getMessage("Common.cancelled.label","Common");
//		alert(mesg);
		message=getMessage("RECORD_INSERTED","SM");

	}
	
	parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	parent.content.hidden_frame.location.reload();
	parent.content.f_query_search_values.location.reload();
	
}
 
function formXMLString(){
	var xmlString="";
	var table_name="";
	var delete_yn = "Y";
	var hash = new Hashtable();
	hash = window.frames[4].hash;
	var key=hash.keys();
	for(var j=0;j<key.length;j++){
		xmlString+="<DELETE_SCHEDULE"+eval(j+1)+" ";
	   var arr= hash.get(key[j])
		xmlString+="booking_date=\""+arr[0]+"\""+"  ";
		xmlString+="surgeon_code=\""+arr[2]+"\""+"  ";
		xmlString+="speciality_code=\""+arr[3]+"\""+"  ";
		xmlString+="theatre_code=\""+arr[4]+"\""+"  ";
		xmlString+="sch_flag=\""+arr[5]+"\""+"  ";
		xmlString+="delete_yn=\""+delete_yn+"\""+" "+" />";
	}
	return xmlString; 
}


async function searchSurgeon(obj,target) {
	var tit = getLabel("Common.Surgeon.label","Common");
	var facility_id=document.forms[0].facility_id.value;
	var locale=document.forms[0].locale.value;
	//qry altered by rajesh for Including role type on 09/07/08

//	var sql="SELECT 'All Surgeon' DESCRIPTION ,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE NVL(EFF_STATUS,'E') = 'E' AND LANGUAGE_ID = 'en' AND PRACTITIONER_ID IN (SELECT RESOURCE_ID FROM OT_DIARY_TIMETABLE WHERE RESOURCE_CLASS = 'D' AND OPERATING_FACILITY_ID = 'HS')  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
//	var sql="SELECT DESCRIPTION, CODE FROM(SELECT '*All Surgeon' DESCRIPTION ,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE NVL(EFF_STATUS,'E') = 'E' AND LANGUAGE_ID = '"+locale+"' AND PRACTITIONER_ID IN (SELECT RESOURCE_ID FROM OT_DIARY_TIMETABLE WHERE RESOURCE_CLASS = 'D' AND OPERATING_FACILITY_ID = '"+facility_id+"'))WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 1";

	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = "OTINTERNALREP_1::otsql::"+locale+"::"+facility_id+"::";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues =await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		target.value=arr[1];
		obj.value=arr[0];
		}else{
			nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		target.value="";
		obj.value="";
		}
}

function callsearch(){
var formObj = document.forms[0];
var locale = formObj.locale.value;
//var from_date  =  (from_date!="") ?dateUtils(document.forms[0].from_date.value,locale,'DMY'):"" ;
//var to_date     =  (to_date!="")   ?dateUtils(document.forms[0].to_date.value,locale,'DMY'):"" ;
var from_date  =  (from_date!="") ?dateUtils(document.getElementById('from_date').value,locale,'DMY'):"" ;
var to_date     =  (to_date!="")   ?dateUtils(document.getElementById('to_date').value,locale,'DMY'):"" ;
var fields = new Array (parent.frames[1].SurgeonDiaryMaintainScheduleHeader.surgeon_desc);
var names = new Array (getLabel("Common.Surgeon.label","Common"));	
//var messageFrame = parent.document.getElementById('messageFrame');
var messageFrame = parent.messageFrame;
var formObj=parent.frames[1].SurgeonDiaryMaintainScheduleHeader;
	if( checkFieldsofMst(fields, names, messageFrame) ) {
		var retVal = compareDates(from_date+" 00:00",to_date+" 00:00",locale,'DMYHM');
		if(!retVal) {
				var lblFromDate =getLabel("Common.fromdate.label","Common");
				var lblToDate = getLabel("Common.todate.label","Common");
				var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT").replace("#",lblFromDate).replace("#",lblToDate);
				return false;
		}else{
			//assigning the english date to date fields again
			//document.forms[0].from_date_hidden.value = from_date
			//document.forms[0].to_date_hidden.value =  to_date;
			document.getElementById('from_date_hidden').value = from_date
			document.getElementById('to_date_hidden').value =  to_date;
			parent.frames[1].document.SurgeonDiaryMaintainScheduleHeader.action="../../eOT/jsp/SurgeonDiaryMaintainAddModifySchedule.jsp";
			parent.frames[1].document.SurgeonDiaryMaintainScheduleHeader.target="f_query_search_values";
			parent.frames[1].document.SurgeonDiaryMaintainScheduleHeader.submit();
		}
    }
}

function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

function callNoRecord(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}


function disapply() {
	parent.content.commontoolbarFrame.document.forms[0].apply.disabled=true;
}

function enapply() {
	parent.content.commontoolbarFrame.document.forms[0].apply.disabled=false;
}

function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function validateCheckBox(obj){
	var frm=window.parent.frames[1].document.forms[0];
	var frmObj = window.parent.frames[4];
	var formObj = document.forms[0];
	var booking_date=obj.getAttribute('booking_date');
	var speciality_code=obj.getAttribute('speciality_code');
	var surgeon_code=frm.surgeon_code.value;
	var theatre_code=obj.getAttribute('theatre_code');
	//formObj.modified_flag.value="false";
	var hash = new Hashtable();
	hash = frmObj.hash;
    var indx = obj.name.replace("chk_release" , "");
	hash = window.parent.frames[4].hash;
	var record= new Array();
	if(isSurgeonScheduleYN(obj)){
		if(obj.checked==true ){
				record[0]=booking_date
				record[1]="Y";
				record[2]=surgeon_code;
				record[3]=speciality_code;
				record[4]=theatre_code;
				record[5]=obj.getAttribute('sch_flag');
		}else{
				record[0]=booking_date;
				record[1]="N";
				record[2]=surgeon_code;
				record[3]=speciality_code;
				record[4]=theatre_code;
				record[5]=obj.getAttribute('sch_flag');
		}
		if(hash.get(indx)!=null){
			hash.remove(indx);	
		}else{
			hash.put(indx,record);	
		}
	}else
		obj.checked=false;
	
}

function assingListItemValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = window.parent.frames[4].hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[1]=="Y")
			eval("formObj.chk_release"+key).checked=true;
		else
			eval("formObj.chk_release"+key).checked=false;
	}
}

function previous(){
	var frm=window.parent.frames[1].document.forms[0];
	var formObj = document.forms[0];
    var surgeon_code=frm.surgeon_code.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	var hash = new Hashtable();
	hash = window.parent.frames[4].hash;
	var keys = hash.keys();
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	var URL = "../../eOT/jsp/SurgeonDiaryMaintainAddModifySchedule.jsp?";
	var param = "from="+start+"&to="+end+"&surgeon_code="+surgeon_code+"&from_date_hidden="+from_date+"&to_date_hidden="+to_date+"&totalSelected="+keys;
	document.location.href=URL+param;
}

function next(){
	var frm=window.parent.frames[1].document.forms[0];
	var formObj = document.forms[0];
    var surgeon_code=frm.surgeon_code.value;
	var start = formObj.start.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	var hash = new Hashtable();
	hash = window.parent.frames[4].hash;
	var keys = hash.keys();
	formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
	var URL = "../../eOT/jsp/SurgeonDiaryMaintainAddModifySchedule.jsp?";
	var param = "from="+start+"&to="+end+"&surgeon_code="+surgeon_code+"&from_date_hidden="+from_date+"&to_date_hidden="+to_date+"&totalSelected="+keys;
	document.location.href=URL+param;
}


function isSurgeonScheduleYN(obj){
	var formObj = document.forms[0];
	var facility_id = formObj.facility_id.value;
	var surgeon_code = formObj.surgeon_code.value;
	var booking_date = obj.booking_date
	var splty_code  = obj.speciality_code
	var theatre_code = obj.theatre_code
	if(obj.checked){
		var sql ="SELECT 'X' FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND OPER_ROOM_CODE='"+theatre_code+"'  AND TRUNC(BOOKING_DATE)=TO_DATE('"+booking_date+"','DD/MM/YYYY')  AND TEAM_DOCTOR_CODE='"+surgeon_code+"' ";
		var param="flag=MED_SER&sql="+sql;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt=trimString(xmlHttp.responseText);
		if(resTxt) {
			obj.setAttribute("sch_flag","Y");
		}
		return (resTxt=='X') ? ( window.confirm(getMessage("APP-OT0083","OT") ) ):true;  
		//return (resTxt=='X') ? ( window.confirm("Do you want to delete patient appointment schedule is present" ) ):true;  
	}
	return true;
}

