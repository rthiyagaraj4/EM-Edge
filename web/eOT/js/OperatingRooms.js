/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/OperatingRoomsAddModify.jsp?mode=insert';
}

//checking Proper From and To Date
function checkTime(){
	var err_txt="";
	var formObj=f_query_add_mod.document.forms[0];
	var wd_start_time=formObj.wd_start_time.value;
	var wd_end_time=formObj.wd_end_time.value;
	var hd_start_time=formObj.hd_start_time.value;
	var hd_end_time=formObj.hd_end_time.value;
	if(!CheckFromToDate(wd_start_time,wd_end_time)){
		  var msg=getMessage("APP-OT0103","OT");
		  arr = msg.split("#");
		  var work_day_start_time=getLabel("eOT.WorkingDayStartTime.Label","OT");
		  var work_day_end_time=getLabel("eOT.WorkingDayEndTime.Label","OT");
		  err_txt=arr[0]+" "+work_day_start_time+" "+arr[1]+work_day_end_time+"<BR>";
	}
	if(!CheckFromToDate(hd_start_time,hd_end_time)){
			  var msg=getMessage("APP-OT0103","OT");
			  arr = msg.split("#");
			  var holiday_start_time=getLabel("eOT.HolidayStartTime.Label","OT");
			  var holiday_end_time=getLabel("eOT.HolidayEndTime.Label","OT");
			  err_txt+=arr[0]+" "+holiday_start_time+" "+arr[1]+holiday_end_time;
			 
	}
	  if(err_txt.length>0){
		   window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		   return false;
	  }else return true;
}



//checking for Operation Sequence Duplication
function checkSeqDup(seq,code,facility_id){
	var sql="SELECT 'X' FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_ROOM_SEQ='"+seq+"' AND OPER_ROOM_CODE NOT IN('"+code+"')";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	if(retVal=='X'){ 		 
		 err_txt=getMessage('RECORD_ALREADY_EXISTS','Common');
		 var thtre_seq=getLabel("eOT.TheatreSequenceNo.Label","OT");
		window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt+thtre_seq;
		return false;
	}
		return true;

}

//checking for Operation Room Duplication
function checkOperDup(code,facility_id){
	var sql="SELECT 'X' FROM OT_OPER_ROOM WHERE   OPERATING_FACILITY_ID = '"+facility_id+"'  OPER_ROOM_CODE ='"+code+"'";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert(retVal);
	if(retVal=='X'){ 		
		var oper_room=getLabel("Common.OperatingRoom.label","Common");
		 //err_txt=getMessage('RECORD_ALREADY_EXISTS','Common');
		 err_txt=getMessage('CODE_ALREADY_EXISTS','Common');
		//window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt+oper_room;
		window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return false;
	}else
		return true;

}

function chkUnitTimeMultiple(){
	var formObj=f_query_add_mod.document.forms[0];
	var wd_start_time=formObj.wd_start_time.value;
	var wd_end_time=formObj.wd_end_time.value;
	var hd_start_time=formObj.hd_start_time.value;
	var hd_end_time=formObj.hd_end_time.value;
	var unit_time=formObj.unit_ot_time.value;
	var bool = isMultipleOfUnitTime(unit_time,wd_start_time,wd_end_time);
	var bool1 = isMultipleOfUnitTime(unit_time,hd_start_time,hd_end_time);
	//alert("bool="+bool+"bool1="+bool1);
	if(!(bool && bool1) ){
		var msg =getMessage("APP-OT0115","OT"); 
		window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		return false;
	}else
	return true
	

}

function isMultipleOfUnitTime(unit_time,start_time,end_time){
	var unit_time=changeToMts(unit_time);
	var chk_start_time=changeToMts(start_time);
	var chk_end_time=changeToMts(end_time);
	//alert("Unit Time-->"+unit_time+"Start-->"+chk_start_time+"End Time-->"+chk_end_time);
	var result=( Number(chk_end_time) - Number(chk_start_time) ) %  Number(unit_time);
	//alert("Result From is Multiple of-->"+result);
	return (result==0)?true:false;
	
}

function changeToMts(time){
	var arr = time.split(":");
	var hrs =arr[0]*60;
	var mts = arr[1];
	var tot = Number(hrs)+Number(mts);
	var res = (arr[0]>0)?tot:mts;
	//alert("Return Val From ChangToMTS-->"+res);
	return res;
}

function trimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function apply(){	
	var formObj = f_query_add_mod.document.forms[0];
	if(formObj!=null){
		var theatreType=getLabel("eOT.TheatreType.Label","OT");
		var operatingRoom=getLabel("Common.OperatingRoom.label","Common");
		//var theatreSequenceNo=getLabel("eOT.TheatreSequenceNo.Label","OT");
		var theatreSequenceNo="eOT.TheatreSequenceNo.Label";
		var longdescription=getLabel("Common.longdescription.label","common");
		var shortdescription=getLabel("Common.shortdescription.label","common");
		var service=getLabel("Common.service.label","common");
		var workingDayStartTime=getLabel("eOT.WorkingDayStartTime.Label","OT");
		var workingDayEndTime=getLabel("eOT.WorkingDayEndTime.Label","OT");
		var holidayEndTime=getLabel("eOT.HolidayEndTime.Label","OT");
		var holidayStartTime=getLabel("eOT.HolidayStartTime.Label","OT");
		var noofoverbookings=getLabel("Common.count.label","common");//Added by lakshmi against MO-CRF-20058

		var seq = formObj.oper_room_seq.value;
		var code = formObj.oper_room_code.value;
		var wd_start_time=formObj.wd_start_time.value;
		var wd_end_time=formObj.wd_end_time.value;
		var hd_start_time=formObj.hd_start_time.value;
		var hd_end_time=formObj.hd_end_time.value;
		var facility_id = formObj.facility_id.value;	
		
		//fields
		/*var fields = new Array (f_query_add_mod.document.forms[0].theatre_desc,f_query_add_mod.document.forms[0].oper_room_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].oper_room_seq,f_query_add_mod.document.forms[0].service_desc,f_query_add_mod.document.forms[0].wd_start_time,f_query_add_mod.document.forms[0].wd_end_time,f_query_add_mod.document.forms[0].hd_start_time,f_query_add_mod.document.forms[0].hd_end_time);*/
		var fields = new Array (f_query_add_mod.document.forms[0].theatre_desc,f_query_add_mod.document.forms[0].oper_room_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].oper_room_seq,f_query_add_mod.document.forms[0].No_Of_Overbookings,f_query_add_mod.document.forms[0].service_desc,f_query_add_mod.document.forms[0].wd_start_time,f_query_add_mod.document.forms[0].wd_end_time,f_query_add_mod.document.forms[0].hd_start_time,f_query_add_mod.document.forms[0].hd_end_time);//Modified by lakshmi against MO-CRF-20058
		//corresponding names
	/*	var names = new Array (theatreType,operatingRoom,longdescription,shortdescription,theatreSequenceNo,service,workingDayStartTime,workingDayEndTime,holidayStartTime,holidayEndTime);*/

		var names = new Array (theatreType,operatingRoom,longdescription,shortdescription,theatreSequenceNo,noofoverbookings,service,workingDayStartTime,workingDayEndTime,holidayStartTime,holidayEndTime);//Modified by lakshmi against MO-CRF-20058
		/* added by Sanjay STARTS here for enabling Count as mandatory only when Over Booked Y/N checkbox is Checked against MO-CRF-20058*/
		if (formObj.over_booking_allowed_yn.checked==false)
		{
			fields = new Array (f_query_add_mod.document.forms[0].theatre_desc,f_query_add_mod.document.forms[0].oper_room_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].oper_room_seq,f_query_add_mod.document.forms[0].service_desc,f_query_add_mod.document.forms[0].wd_start_time,f_query_add_mod.document.forms[0].wd_end_time,f_query_add_mod.document.forms[0].hd_start_time,f_query_add_mod.document.forms[0].hd_end_time);

			names = new Array (theatreType,operatingRoom,longdescription,shortdescription,theatreSequenceNo,service,workingDayStartTime,workingDayEndTime,holidayStartTime,holidayEndTime);
		}
		/* added by Sanjay ENDS here for enabling Count as mandatory only when Over Booked Y/N checkbox is Checked against MO-CRF-20058*/
		var mode = formObj.mode.value;
		if(mode=="insert"){			
			if(!checkOperDup(code,facility_id))
			return false;
		}		

		if(checkFieldsofMst( fields, names, messageFrame) ){			
			if(checkSeqDup(seq,code,facility_id) && checkTime() ){				
				if(chkUnitTimeMultiple()){					
					//if(alreadyExist())
					f_query_add_mod.document.forms[0].submit();					
					f_query_add_mod.location.href='../../eOT/jsp/OperatingRoomsAddModify.jsp?mode='+mode;					
	//				f_query_add_mod.document.forms[0].reload();
				}
			}
		}
		}else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}



function onSuccess(){
	var formObj = f_query_add_mod.document.forms[0]; 
	var mode = formObj.mode.value;
	var code = formObj.mode.oper_room_code.value;
	f_query_add_mod.location.href='../../eOT/jsp/OperatingRoomsAddModify.jsp?mode='+mode+'&oper_room_code='+code;
}

/*function reset(){
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperatingRoomsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("OperatingRooms.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperatingRoomsQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}
}
function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;//changed for 43429
	f_query_add_mod.location.href='../../eOT/jsp/OperatingRoomsQueryCriteria.jsp?';
}

function setCheckValue(obj){
	var formObj = document.forms[0];
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
	
	/*if(document.forms[0].restrict_by_splty_yn.checked==true)
		document.forms[0].restrict_by_splty_yn.value="Y";
		else
		document.forms[0].restrict_by_splty_yn.value="N";*/
	
//Added by lakshmi against MO-CRF-20058 starts here
if (obj.value =="Y")
	{
		formObj.No_Of_Overbookings.disabled = false;
	}
else{
		formObj.No_Of_Overbookings.disabled = true;
		formObj.No_Of_Overbookings.value="";
	}
//Added by lakshmi against MO-CRF-20058 ends here
}
function setCheckValueRestrictbySpltyYn(obj){
	var formObj = document.forms[0];
	if(document.forms[0].restrict_by_splty_yn.checked==true)
		document.forms[0].restrict_by_splty_yn.value="Y";
		else
		document.forms[0].restrict_by_splty_yn.value="N";
}//Added for 43429
function setCheckValueChargableRoom(obj){
	var formObj = document.forms[0];
	if(document.forms[0].chargable_room.checked==true)
		document.forms[0].chargable_room.value="Y";
		else
		document.forms[0].chargable_room.value="N";
}//Added for 43429

//function added by Sanjay for showing mandatory symbol for Count when Overbooking Allowed Y/N checkbox is Checked against IN032063
function checkCount(obj){	
	//var formObj=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;	
	if(obj.checked){
		document.getElementById("count_check").style.visibility='visible'
	}else{
		document.getElementById("count_check").style.visibility='hidden'
	}
	
}

function checkNull(retVal){
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';
}

async function callTheatreType(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.category1.label","common");
	
	var sql="SELECT SHORT_DESC DESCRIPTION, LOCN_TYPE CODE FROM AM_CARE_LOCN_TYPE_LANG_VW WHERE language_id='"+locale+"' and CARE_LOCN_TYPE_IND ='O' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(LOCN_TYPE) LIKE UPPER(?) ORDER BY 1";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		target.value="";
		obj.value="";
	}
 }
async function callService(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.service.label","common");
	var sql="SELECT LONG_DESC DESCRIPTION, SERVICE_CODE CODE FROM AM_SERVICE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(ANCILLARY_YN,'N') ='Y' AND NVL(EFF_STATUS,'D')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(SERVICE_CODE) LIKE UPPER(?) ORDER BY 1";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }
function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}



function CheckForPositiveNumber(obj){
	var RegExpr=/^[1-9]|[0-9]{1,2}$/
	if(obj.value!=""){
		if(!RegExpr.test(obj.value)){
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));			
			obj.select();
			obj.focus(); 
		}
	}
}

function validatePositiveNumber(){		
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	    alert(getMessage("INVALID_POSITIVE_NUMBER","common"));
	   	window.event.keyCode = 27;
   		}		
}

function CheckForPositiveNumber1(obj){
	var RegExpr=/^[1-9]|[0-9]{1,2}$/
	if(obj.value!=""){
		if(!RegExpr.test(obj.value)){
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));			
			obj.select();
			obj.focus(); 
		}
	}
}

function validatePositiveNumber1(obj){
	   	if (!(obj.value > 0)) { 
	    alert(getMessage("INVALID_POSITIVE_NUMBER","common"));
		obj.value = '';
	   	obj.select();
		obj.focus(); 
   		}		
}


function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function isValidTimeFormat(obj){
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	var from_time=obj.value
	var splt_from_dur=from_time.split(":");
if(from_time!=''){
	if(from_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
//		formObj.start_time.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		obj.value="";
		obj.select();
//		formObj.start_time.focus()
		return;
	}
}
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}

		if(  isNaN(arr_time[0]) || isNaN(arr_time[1]) ){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}

		if(arr_time[0]<0 || arr_time[0]>23 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT");
		}
		if(arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
			err_text+=getMessage("APP-OT0041","OT");
		}
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}
	return true
}


function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function CheckFromToDate(date1,date2){
	from = changeToMts(date1);
	to = changeToMts(date2);
	return ( Number(to)-Number(from) > 0)?true:false;
}

function alreadyExist(){
	var formObj = f_query_add_mod.document.forms[0];
	//alert(formObj.name);
	var codeDtl = parent.frames[1].code;	
	//alert(codeDtl);
	var oper_room_code = formObj.oper_room_code.value;
	//alert(oper_room_code);
	//var item_type = formObj.item_type.value;
	var codeRecord =oper_room_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}


function checkOperRoomDup(obj){
	var sql="select 'X' from ot_oper_room where oper_room_code='"+obj.value+"'";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal=='X'){ 		 
		 err_txt=getMessage('RECORD_ALREADY_EXISTS','Common');
		alert(err_txt);
		obj.select();
		return false;
	}else
		return true;

}


async function callRecoveryRoom(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.DefaultRecoveryRoom.Label","OT");
	
	var sql="SELECT RECOVERY_ROOM_DESC DESCRIPTION, RECOVERY_ROOM_CODE CODE FROM OT_RECOVERY_ROOM_LANG_VW WHERE language_id='"+locale+"' AND UPPER(RECOVERY_ROOM_DESC) LIKE UPPER(?) AND UPPER(RECOVERY_ROOM_CODE) LIKE UPPER(?) ORDER BY 1";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

//Newly added by rajesh on 12/12/2009 for checking the exisitig room appointments for the future date before updating the oper room end timings.
function checkExixtingAppWE(obj){
	var formObj=document.forms[0];
	var time=obj.value;
	var oper_room_code=formObj.oper_room_code1.value;
	var wd_end_time_db=formObj.wd_end_time1.value;
	var facility_id=formObj.facility_id.value;
	var param="func_mode=OPR_RM_MSTR_EXIST_APP&room_code="+oper_room_code+"&facility_id="+facility_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="X" && wd_end_time_db!=time){
//	if(retVal=="X"){
		alert(getMessage("APP-OT0174","OT"));
		obj.value="";
		obj.select();
		return false;
	}else{
		return true;
	}
}

function checkExixtingAppWS(obj){
	var formObj=document.forms[0];
	var time=obj.value;
	var oper_room_code=formObj.oper_room_code1.value;
	var wd_strt_time_db=formObj.wd_start_time1.value;
	var facility_id=formObj.facility_id.value;
	var param="func_mode=OPR_RM_MSTR_EXIST_APP&room_code="+oper_room_code+"&facility_id="+facility_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="X" && wd_strt_time_db!=time){
//	if(retVal=="X"){
		alert(getMessage("APP-OT0174","OT"));
		obj.value="";
		obj.select();
		return false;
	}else{
		return true;
	}
}

function checkExixtingAppHS(obj){
	var formObj=document.forms[0];
	var time=obj.value;
	var oper_room_code=formObj.oper_room_code1.value;
	var hd_strt_time_db=formObj.hd_start_time1.value;
	var facility_id=formObj.facility_id.value;
	var param="func_mode=OPR_RM_MSTR_EXIST_APP&room_code="+oper_room_code+"&facility_id="+facility_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="X" && hd_strt_time_db!=time){
//	if(retVal=="X"){
		alert(getMessage("APP-OT0174","OT"));
		obj.value="";
		obj.select();
		return false;
	}else{
		return true;
	}
}

function checkExixtingAppHE(obj){
	var formObj=document.forms[0];
	var time=obj.value;
	var oper_room_code=formObj.oper_room_code1.value;
	var hd_end_time_db=formObj.hd_end_time1.value;
	var facility_id=formObj.facility_id.value;
	var param="func_mode=OPR_RM_MSTR_EXIST_APP&room_code="+oper_room_code+"&facility_id="+facility_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="X" && hd_end_time_db!=time){
//	if(retVal=="X"){
		alert(getMessage("APP-OT0174","OT"));
		obj.value="";
		obj.select();
		return false;
	}else{
		return true;
	}
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

//CRF-004 Authorize Slots for Booking - Rajesh V 
async function restrictSlots() {
	var formObj = document.forms[0];

	var parameters = "oper_room="+formObj.oper_room_code1.value;
	  var retVal =  new String();
	  var dialogHeight= "40" ;
	  var dialogWidth = "40" ;
	  var dialogTop = "10" ;
	  var status = "no";
	  var arguments = "" ;
	  var features = "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	  retVal = await window.showModalDialog("../../eOT/jsp/RestrictSlotsForOperatingRoom.jsp?"+parameters,arguments,features);
	  if(retVal != 'undefined' && retVal!=null){
		 document.forms[0].childWinParams.value =  localTrimString(retVal);
	  }
	}

async function searchDoctor(obj,target){
	var role=getLabel("Common.Role.label","common");
	var locale = document.forms[0].locale.value;
		var tcode = obj.value;
		var tdesc = target.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit = role;
		var sql="";

		sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS,'E') = 'E'  AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			obj.value = arr[0];
			target.value=arr[1];
			document.forms[0].idForPract.value = arr[0];
		}else{
	
			target.value="";
			obj.value="";
		}
}

function cancelRecord(){

	var fields = document.restrictSlots.practitioner_name.value;
	if(fields.length>1){
	document.getElementById("practitioner_name").disabled = false;
	
	var name = document.restrictSlots.practitioner_name.value;
	var idForPract = document.restrictSlots.idForPract.value;
	var rowCount = document.getElementById("listContentTable").rows.length-1;
	var totRows = document.getElementById("totalRows").value;
	if(rowCount>0){
		for(i=1;i<=rowCount;i++){
			var hdnI = i-1;
			selectedText = document.getElementById("listContentTable").rows[i].cells[0].innerText;
			if((idForPract == selectedText)){
				
				if(i<=totRows){
					document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
					document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
					document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';

					var hdntxt = "nutMode"+hdnI;
					var val = "D";
					document.getElementById(hdntxt).value=val;
				}
				else{
					document.getElementById("listContentTable").deleteRow(i);
					var rowCnt = document.getElementById("listContentTable").rows.length;			 
					if(rowCnt>1){
						var l = i+1;
						for(j=l;j<=rowCnt;j++){
							var k = j-1;
							idForPract = document.getElementById("listContentTable").rows[k].cells[0].innerText;						
							document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+idForPract+"</a>";

							 var input = document.createElement("input");
							 input.setAttribute("type", "hidden");
							 var iCnt = k-1;
							 input.setAttribute("name", "nutMode"+iCnt);
							 input.setAttribute("value", "I");
							 document.getElementById("restrictSlots").appendChild(input);
						}
					}
				}
				
				return true;
			}
			 document.restrictSlots.practitioner_name.value = "";
		}
	}
	 document.restrictSlots.practitioner_name.value = "";
	}
}


function selectRecord1() {

	var fields = document.restrictSlots.practitioner_name.value;
	if(fields.length>1){
		var rowCount = 0;
		rowCount = document.getElementById("listContentTable").rows.length;
		var name = document.restrictSlots.practitioner_name.value;
		var idForPract = document.restrictSlots.idForPract.value;
		if(rowCount>1){
			for(j=2;j<=rowCount;j++){
				var k = j-1;
				var selectedText = document.getElementById("listContentTable").rows[k].cells[0].innerText;
				if((idForPract == selectedText)){
					alert(getMessage("APP-OT0200","OT"));
					document.getElementById("practitioner_name").disabled = false;
					document.restrictSlots.practitioner_name.value = '';
					return true;
				}
				
			}
		}
		
		var newRow = document.all("listContentTable").insertRow();
		 var newCell = newRow.insertCell();
		 rowCount = document.getElementById("listContentTable").rows.length;
		 var fncal = "javascript:callfn12("+rowCount+");"
		 newCell.innerHTML = "<a href='"+fncal+"'>"+idForPract+"</a>";   
		 
		 
		 newCell = newRow.insertCell();
		 newCell.innerHTML = name;

		 var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		var iCnt = rowCount-2;
		input.setAttribute("name", "nutMode"+iCnt);
		input.setAttribute("value","I");
		document.getElementById("restrictSlots").appendChild(input);
					 
		 document.restrictSlots.practitioner_name.value = "";
	}
}

function callfn12(obj){
	obj = obj-1;

	var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
	var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;

	document.restrictSlots.practitioner_name.value = cell2;
	document.restrictSlots.idForPract.value = cell1;
	
	document.getElementById("practitioner_name").disabled = true;
}

function tempSubmit(){
	var frm = document.forms[0];
	var kitchenArr = new Array();
	var tbl = document.getElementById("listContentTable");
	var rowCount = tbl.rows.length;
	for(j=2;j<=rowCount;j++){
		var k = j-1;
		var arrI = j-2;
		kitchenArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+tbl.rows[k].cells[1].innerText;
	}
	var contentValue = kitchenArr[0];
	for(var i=1;i<kitchenArr.length;i++){
		contentValue = contentValue + "###" + kitchenArr[i];
	}
	var totRows = document.getElementById("totalRows").value;
	var modeValue = "";
	for(var j=0;j<totRows;j++){
		var hdn = "nutMode"+j;
		hdnval = document.getElementById(hdn).value;
		modeValue = modeValue+"::"+hdnval;
	}
	for(j=totRows;j<i;j++){
		modeValue = modeValue+"::"+"I";
	}
	modeValue = modeValue.substring(2, modeValue.length);
	var retVal = contentValue+"!!!"+modeValue;
	window.returnValue=retVal;
	window.close();
}

function chkPermSlotsBooking(bookingDate,operRoom,doctorCode,specialityCode){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=chkPermSlots&booking_date="+bookingDate+"&doctor_code="+doctorCode+"&oper_room="+operRoom+"&speciality_code="+specialityCode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var role_type = localTrimString(xmlHttp.responseText);	
	return role_type;
}
//CRF-004 Authorize Slots for Booking - Rajesh V 
