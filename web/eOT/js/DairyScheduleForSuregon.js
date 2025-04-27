/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var week = new Array();


function getLabels(){
	week[0] = getLabel("Common.all.label","common").toUpperCase();
	week[1] = getLabel("Common.mon.label","common").toUpperCase();
	week[2] = getLabel("Common.tue.label","common").toUpperCase();
	week[3] = getLabel("Common.wed.label","common").toUpperCase();
	week[4] = getLabel("Common.thu.label","common").toUpperCase();
	week[5] = getLabel("Common.fri.label","common").toUpperCase();
	week[6] = getLabel("Common.sat.label","common").toUpperCase();
	week[7] = getLabel("Common.sun.label","common").toUpperCase();

}

function create()
{
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href="../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp?"+source+"&mode=insert";
}

function apply(){	
	//alert("28 DairyScheduleForSuregon.js");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	//alert("31")
	var HdrformObj=masterframe.document.forms[0];
	var code = HdrformObj.oper_room_code.value;
	var mode = HdrformObj.mode.value;
	//var detailframe = window.parent.frames[1].frames[1].frames[4];
    //var hiddenframe=window.parent.frames[1].frames[1].frames[1];
    var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
	//alert("38")
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var frmObj = parent.content.f_query_add_mod.RecordFrame.document.forms[0];
	var ot_param = frmObj.ot_Param.value;
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var operatingroom=getLabel("Common.OperatingRoom.label","Common");
	var formObj = document.forms.BlockSlotsBySpecialityHdr;
	var fields = new Array(HdrformObj.oper_room_code);
	var names = new Array(operatingroom);
	var curr_date=HdrformObj.curr_date.value;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = "../../servlet/eOT.DiaryScheduleForSurgeonServlet?curr_date="+curr_date+"&mode=I"+"&otParam="+ot_param;//+mode;
	xmlStr+=createXMLForDiarySchdule();
	xmlStr+="</root>";
	if(xmlStr.indexOf("<root></root>")!=-1){
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false;
	}
	
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		//alert(retVal);
		autoRefresh(code,mode,retVal);
		msg = (retVal=="RECORD_INSERTED")?getMessage("RECORD_INSERTED","SM"):msg=getMessage("APP-OT0082","OT");
		//alert(msg);
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		                                                             
		//parent.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	
}

function trimString(inString){
    return inString.replace(/^\s+|\s+$/g,"");
}

function wrapTime(str){
	var now  = new Date();
	var arr = str.split(":");
	var date = new Date(now.getFullYear() , now.getMonth(),now.getDate(), arr[0], arr[1], "00"); 
	 //date.setHours(arr[0]);
	// date.setMinutes(arr[1]);
	return date
}


function chkTimeRange(){
	var record_formObj = parent.RecordFrame.document.forms[0];
	var start_time = wrapTime(record_formObj.start_time.value);
	var end_time = wrapTime(record_formObj.end_time.value);
	var wd_start_time = wrapTime(record_formObj.wd_start_time.value);
	var wd_end_time = wrapTime(record_formObj.wd_end_time.value);
	var hd_start_time = wrapTime(record_formObj.hd_start_time.value);
	var hd_end_time = wrapTime(record_formObj.hd_end_time.value);
	var start_time = wrapTime(record_formObj.start_time.value);
	var end_time = wrapTime(record_formObj.end_time.value);
	var status = record_formObj.days.value;
	var day_status = status.substring((status.indexOf("@@")+2));
	var msg="";
	var err_txt="";
	var alert_wstart_time = record_formObj.wd_start_time.value;
	var alert_wend_time = record_formObj.wd_end_time.value;
	var alert_hstart_time = record_formObj.hd_start_time.value;
	var alert_hend_time = record_formObj.hd_end_time.value;

	//alert("1.1");
	if(day_status=="W"){
		if(start_time<wd_start_time||start_time>wd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+alert_wstart_time+msgArr[1]+ alert_wend_time+msgArr[2];
			//CRF-004 Authorize Slots for Booking - Rajesh V 
			record_formObj.start_time.value = "";
			//CRF-004 Authorize Slots for Booking - Rajesh V 			
		}
		//alert("1.2");
		if(end_time<wd_start_time || end_time>wd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+alert_wstart_time+msgArr[1]+ alert_wend_time+msgArr[2];
			//CRF-004 Authorize Slots for Booking - Rajesh V 		
			record_formObj.end_time.value = "";
			//CRF-004 Authorize Slots for Booking - Rajesh V 			
		}
		//if(err_txt.length>0)alert(err_txt);

	}else if(day_status=="H"){
		if(start_time<hd_start_time || start_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+alert_hstart_time+msgArr[1]+alert_hend_time+msgArr[2];
		}
		if(end_time<hd_start_time||end_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			//err_txt=msgArr[0]+ hd_start_time+msgArr[1]+ hd_end_time+msgArr[2];
			err_txt=msgArr[0]+alert_hstart_time+msgArr[1]+alert_hend_time+msgArr[2];
		}
		//if(err_txt.length>0)alert(err_txt);
	}
	//alert(err_txt);
	if(err_txt.length>0)parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	return (err_txt.length>0)?false:true
}


function createXMLForDiarySchdule(){
  //var formObj=window.parent.frames[1].frames[1].frames[0].document.forms[0];
  var formObj=parent.content.f_query_add_mod.MasterFrame.document.forms[0];
  //var rows = window.parent.frames[1].frames[1].frames[1].rows;
  //CRF-004 Authorize Slots for Booking - Rajesh V 
  var frmObj = parent.content.f_query_add_mod.RecordFrame.document.forms[0];
  var otParam = frmObj.ot_Param.value;
  //CRF-004 Authorize Slots for Booking - Rajesh V 
  var rows = parent.content.f_query_add_mod.hidden_frame.rows;
  var oper_room_code=formObj.oper_room_code.value;
  oper_room_code=oper_room_code.split("@@");
  oper_room_code=oper_room_code[0];
  var table_name = "OT_DIARY_TIMETABLE";
  var xmlString ="";
  var final_value ="";
  for(var key in rows){
	   var hash = new Hashtable();
	   hash = rows[key];
		final_value = hash.get("surgeon_code") +"|"+hash.get("speciality_code") +"|"+hash.get("day").charAt(0);
	   if(hash.get("mode")!='L' ){
		xmlString+="<OT_SURGEON_SCHEDULE"+i+" ";
		xmlString+="operating_facility_id=\""+formObj.facility_id.value+"\""+" ";
		xmlString+="oper_room_code=\""+oper_room_code+"\""+" ";
		xmlString+="surgeon_code=\""+hash.get("surgeon_code") +"\""+" ";
		xmlString+="speciality_code=\""+hash.get("speciality_code")+"\""+" ";
		xmlString+="day=\""+hash.get("day").charAt(0)+"\""+" ";
		xmlString+="start_time=\""+hash.get("start_time")+"\""+" ";
		xmlString+="end_time=\""+hash.get("end_time") +"\""+" ";
		xmlString+="schedule_type=\""+hash.get("schedule_type")+"\""+" ";
		xmlString+="week=\""+hash.get("week")+"\""+" ";
		xmlString+="mode=\""+hash.get("mode")+"\""+" ";
		xmlString+="final_value=\""+final_value+"\""+" ";
		//CRF-004 Authorize Slots for Booking - Rajesh V 
		if(otParam == 'Y' || otParam=='y'){
			xmlString+="table_name=\""+table_name+"\""+" ";
			xmlString+="totalSlots=\""+hash.get("totalSlots")+"\""+" ";
			xmlString+="restrictedSlots=\""+hash.get("restrictedSlots")+"\""+" />";
		}
		else{
			xmlString+="table_name=\""+table_name+"\""+" />";
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V 		
		hash=null;
		}//if condition
	 }//for loop
    return xmlString;
}

function spltyEnaDis()
{	
	 var formObj=document.forms[0];
	 var restrict_by_splty_yn=window.parent.frames[3].DiaryScheduleForSurgeonForm.restrict_by_splty_yn.value
	 var splty=getLabel("eIP.AllSPLTY.label","IP");
		
	 if(restrict_by_splty_yn == "N"){
		
		window.parent.frames[3].DiaryScheduleForSurgeonForm.generic_search_for_speciality.disabled=true;
		window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_desc.disabled=true;
		window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_code.value="*ALL";
		window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_desc.value=splty;
     }else{
		window.parent.frames[3].DiaryScheduleForSurgeonForm.generic_search_for_speciality.disabled=false;
		window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_desc.disabled=false;
	//	window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_code.value="";
	//	window.parent.frames[3].DiaryScheduleForSurgeonForm.speciality_desc.value="";
     }
}
function assignValues(){
	 var formObj=document.forms[0];
	 var oper_room_restrict=formObj.oper_room_code.value;
	 var oper_room_code_split=oper_room_restrict.split("@@");
	 var oper_room_code=oper_room_code_split[0];
	 var restrict_by_splty_yn=oper_room_code_split[1];
	 var rows=window.parent.frames[1].rows;
		if(rows!=null){
			if(rows.length!=0)
				rows.length=0;
		}
		window.parent.frames[3].location.href="../../eOT/jsp/DairyScheduleForSuregonRecord.jsp?oper_room_code="+oper_room_code+"&restrict_by_splty_yn="+restrict_by_splty_yn;
}

function autoRefresh(code,mode,mesg){
	var params="oper_room_code="+code+"&update_mode_yn="+mode+"&mesg="+mesg;
	if(mode=="modify")
		//parent.frames[1].frames[1].location.href="../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp?"+params;
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp?"+params;
	else
		//parent.frames[1].frames[1].location.href="../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp";
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp";
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/DairyScheduleForSuregonForCreate.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();
}

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DairyScheduleForSuregonForCreate.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("DairyScheduleForSuregonMain.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
 }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DairyScheduleForSuregonQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	var source=document.forms[0].source.value;
	//Modified against 046233 
	if(cmf.apply != "undefined" && cmf.apply != null ) 
	{
		if(cmf.apply.disabled==false)
		{
		  cmf.apply.disabled=true;
		 //commontoolbarFrame.document.forms[0].reset.disabled=true;

		}
	}
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href="../../eOT/jsp/DairyScheduleForSuregonQueryCriteria.jsp?"+source+"&mode=modify";
}

function setCheckValue(obj)
{
	var select = document.forms[0].selected_weeks.value;
	if(obj.checked==true){
		obj.value="Y";
		document.forms[0].selected_weeks.value = select+obj.name.replace("week","");
	}else{
		obj.value="N";
		document.forms[0].selected_weeks.value = select.replace(obj.name.replace("week",""),"");
	   }
}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
		else 
			return '';

}

function isNull(retVal)
{
if(retVal==null||retVal=='')
	return true;
else
	return false;
}
async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

async function callSpecialitycode(obj,target){
	var formObj = document.forms[0];
	var surgeon_code = formObj.surgeon_code.value;
	var facility_id = formObj.facility_id.value;
	var oper_room_code = formObj.theatre_code.value;
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.speciality.label","common");
	var sql="SELECT A.SHORT_DESC DESCRIPTION, B.SPECIALITY_CODE CODE FROM   OT_SPECIALITIES B , AM_SPECIALITY_LANG_VW a WHERE a.LANGUAGE_ID='"+locale+"' AND B.SPECIALITY_CODE = A.SPECIALITY_CODE and   NVL(eff_status, '$') != 'S' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(B.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 1";
	//var sql = "SELECT  DISTINCT A.SPECIALITY_CODE CODE, C.SHORT_DESC DESCRIPTION FROM AM_PRACT_SPECIALITIES A, OT_SPECIALITY_TIME_TABLE B, AM_SPECIALITY  C WHERE A.SPECIALITY_CODE = B.SPECIALITY_CODE AND A.FACILITY_ID = B.OPERATING_FACILITY_ID AND B.OPER_ROOM_CODE = '"+oper_room_code+"' AND B.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.FACILITY_ID = '"+facility_id+"' AND A.PRACTITIONER_ID = '"+surgeon_code+"' AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND NVL(C.EFF_STATUS, 'D') = 'E' AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) AND UPPER(C.SHORT_DESC) LIKE UPPER(?) UNION SELECT A.PRIMARY_SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM AM_PRACTITIONER A, AM_SPECIALITY B WHERE A.PRACTITIONER_ID = '"+surgeon_code+"'  AND A.PRIMARY_SPECIALITY_CODE= B.SPECIALITY_CODE AND UPPER(A.PRIMARY_SPECIALITY_CODE) LIKE UPPER(?) AND UPPER(B.SHORT_DESC) LIKE UPPER(?) UNION SELECT '*ALL', 'All' FROM DUAL UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(B.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2 ";
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
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }


function alreadyExist(){
	var xmlStr="<root></root>";
	var msg = getMessage("DUPLICATE_CODE_EXISTS","Common");
	var formObj = document.forms[0];
	var splty_code = formObj.speciality_code.value;
	var surg_code = formObj.surgeon_code.value;
	var start_time = formObj.start_time.value;
	var end_time=formObj.end_time.value;
	var arr=formObj.days.value.split("@@");
	var day_code=arr[0];
	var sql = "SELECT COUNT(*) FROM OT_DIARY_TIMETABLE WHERE RESOURCE_ID='"+surg_code+"' AND SPECIALITY_CODE='"+splty_code+"' AND DAY_CODE='"+day_code+"' AND ('"+start_time+"' BETWEEN TO_CHAR(FROM_TIME,'HH24:MI') AND TO_CHAR(TO_TIME,'HH24:MI') OR '"+end_time+"' BETWEEN TO_CHAR(FROM_TIME,'HH24:MI') AND TO_CHAR(TO_TIME,'HH24:MI'))";
	var param = "flag=MED_SER&sql="+sql;
	var action = "../../servlet/eOT.CommonQueryServlet?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	if(responseText==0){
		return true
	}else{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		return false;
	}
}

function chkEmpty(){
  var formObj = document.forms[0];
  var otParam = formObj.ot_Param.value;
  var surgeon_title = getLabel("Common.Surgeon.label","Common");
  var speciality_title = getLabel("Common.speciality.label","Common");
  var start_time_title = getLabel("Common.StartTime.label","Common");
  var end_time_title = getLabel("Common.EndTime.label","Common");
  var restricted_Slots = getLabel("eOT.PermissibleSlots.Label","OT");// Added by Chaitanya for IN:043345 on October 17, 2013
  var fields = new Array (formObj.surgeon_code, formObj.speciality_code,formObj.start_time,formObj.end_time);
  var names = new Array (surgeon_title,speciality_title, start_time_title, end_time_title);
  if(otParam == 'Y' || otParam=='y')
  {
	fields = new Array (formObj.surgeon_code, formObj.speciality_code,formObj.start_time,formObj.end_time, formObj.restricted_Slots);
	names = new Array (surgeon_title,speciality_title, start_time_title, end_time_title, restricted_Slots);
  }
  var messageFrame = window.parent.parent.messageFrame;
  return checkFieldsofMst( fields, names, messageFrame);
}

//function is used to validate the start and end time /time range and unit time

function validateTimings(){
//	if(!validateSurgeon()) return false;
	if(!chkTime()) return false;
	if(!chkUnitTime()) return false;
	if(!chkTimeRange()) return false;
	//alert("Ln:366");
	if(!validateWeek()) return false;
//if(!weekOverLapValidation()) return false;
if(!overLapValidation()) return false;
	return true;
}

function TimeCheck(st_date,end_date){
	return true;
}

function validateWeek(){
	var frmObj=document.forms[0];
	var result=false;
	with(frmObj){
		var str = (week1.value)+(week2.value)+(week3.value)+(week4.value)+(week5.value);
		result=("NNNNN".indexOf(str)>=0)?true:false;
		}
	if(result){
		callMessageFrame("APP-OT0105");
		return false;
	}
	return true;
}

function callMessageFrame(msg){
	
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage(msg,"OT");
	
} 

function addRow(){
  var HdrformObj = parent.MasterFrame.document.forms[0];
  var formObj = document.forms[0];
  //CRF-004 Authorize Slots for Booking - Rajesh V 
  var otParam = formObj.ot_Param.value;
  //CRF-004 Authorize Slots for Booking - Rajesh V 
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var mode=formObj.mode.value;
   if(HdrformObj.oper_room_code.value==null || HdrformObj.oper_room_code.value==""){
	  var msg = getMessage("CANNOT_BE_BLANK","OT");
	  var msgArray = msg.split("&");
  	  var operation_room=getLabel("eOT.OperationRoom.Label","OT");
	  alert(msgArray[0]+operation_room+msgArray[1]);
	  return false;
  }
  //CRF-004 Authorize Slots for Booking - Rajesh V 
  if(otParam == 'Y' || otParam=='y'){
	  var allowSots = formObj.restricted_Slots.value.replace(/^\s+|\s+$/g, "");
	  if(allowSots.length<1){
		//alert("Booking allowed for slots cannot be empty");
		//return false;
		formObj.restricted_Slots.value = '';
	  }
  }
  //CRF-004 Authorize Slots for Booking - Rajesh V 
 	if( chkEmpty() && mode=='I'  ){
		if(validateTimings() ){
			if(processValidate()){
				//Code for check 
				//alert("412");
				var test=formObj.days.value.split("@@");
				var day_no=test[0];
				var final_value= formObj.surgeon_code.value+"|"+formObj.speciality_code.value +"|"+day_no+"|"+formObj.start_time.value+"|"+formObj.end_time.value ;
			   var hash  = new Hashtable();
			   hash.put("speciality_code",formObj.speciality_code.value);
			   hash.put("speciality_desc",formObj.speciality_desc.value);
			   hash.put("surgeon_code",formObj.surgeon_code.value);
			   hash.put("surgeon_desc",formObj.surgeon_desc.value);
			   hash.put("start_time",formObj.start_time.value);
			   hash.put("end_time",formObj.end_time.value);
			   hash.put("day",formObj.days.value);
			   hash.put("day_desc",formObj.days.options[formObj.days.selectedIndex].text );
			   hash.put("week",weeks());
			   hash.put("schedule_type",formObj.schedule_type.value);
			   hash.put("recId",rows.length+1);
			   hash.put("mode","I");
			   hash.put("final_value",final_value);
			   //CRF-004 Authorize Slots for Booking - Rajesh V 
			   if(otParam == 'Y' || otParam=='y'){
					hash.put("totalSlots",formObj.total_Slots.value);
					hash.put("restrictedSlots",formObj.restricted_Slots.value);
			   }
			   //CRF-004 Authorize Slots for Booking - Rajesh V 
			   rows.push(hash);
			   refresh();
			   resetFields();
			}
			}
			//alert("431");	
	}
	else
	{
		if(chkEmpty())
	   updateRow();
	}
    
  }

function validateWeek(){
	var frmObj=document.forms[0];
	var result=false;
	with(frmObj){
		var str = (week1.value)+(week2.value)+(week3.value)+(week4.value)+(week5.value);
		result=("NNNNN".indexOf(str)>=0)?true:false;
		}
	if(result){
		callMessageFrame("APP-OT0105");
		return false;
	}
	return true;
}

function weeks(){
	var frmObj = document.forms[0];
	var weeks =  (frmObj.week1.checked ==true)?"Y":"N";
	weeks+=(frmObj.week2.checked ==true)?"Y":"N";
	weeks+=(frmObj.week3.checked ==true)?"Y":"N";
	weeks+=(frmObj.week4.checked ==true)?"Y":"N";
	weeks+=(frmObj.week5.checked ==true)?"Y":"N";
	return weeks;
}


function updateRow(){
	var formObj = document.forms[0];
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var otParam = formObj.ot_Param.value;
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var recId = document.forms[0].recId.value;
	var mode = document.forms[0].mode.value;
	var rows=window.parent.parent.frames[1].frames[1].rows[recId-1];
	if(mode=='U'){ 
		var test=formObj.days.value.split("@@");
				var day_no=test[0];
				var final_value= formObj.surgeon_code.value+"|"+formObj.speciality_code.value +"|"+day_no+"|"+formObj.start_time.value+"|"+formObj.end_time.value ;

		var hash = new Hashtable();
		hash= rows;
		hash.put("day",formObj.days.value);
		hash.put("day_desc",formObj.days.options[formObj.days.selectedIndex].text );
		hash.put("week",weeks());
		hash.put("schedule_type",formObj.schedule_type.value);
		hash.put("start_time",formObj.start_time.value);
		hash.put("end_time",formObj.end_time.value);
		hash.put("final_value",final_value);
		// CRF-004 Authorize Slots for Booking - Rajesh V 
		if(otParam == 'Y' || otParam=='y'){
			hash.put("totalSlots",formObj.total_Slots.value);
			hash.put("restrictedSlots",formObj.restricted_Slots.value);
		}
		// CRF-004 Authorize Slots for Booking - Rajesh V 
		if(hash.get("mode")=="L") hash.put("mode",'U');
		rows[recId-1]=hash;
		hash=null;
		resetFields();
		refresh();
	}

}
		   
function removeRow(){
	var formObj = document.forms[0];
	var recId = document.forms[0].recId.value;
	var mode = document.forms[0].mode.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
	if(mode=='U'){        
		var hash = new Hashtable();
		hash= rows[recId-1]
		if(hash.get("mode")=='L' || hash.get("mode")=='U'){
			hash.put("mode","D");
			//rows.splice(recId-1,1);
			//rows.push(recId-1,hash);
		 }else{
			rows.splice(recId-1,1);
		 }
		 rows = null;
		 resetFields();
		 refresh();
	}else
	   resetFields();
       refresh();
}

function splitString(indx){
	var rows=window.parent.parent.frames[1].frames[1].rows[indx];
	var frmObj = document.forms[0];
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var otParam = frmObj.ot_Param.value;
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var hash = new Hashtable();
	var weeks = new Array();
	hash = rows;
	frmObj.speciality_desc.value=hash.get("speciality_desc");
	frmObj.speciality_code.value=hash.get("speciality_code");
	frmObj.surgeon_code.value=hash.get("surgeon_code");
	frmObj.surgeon_desc.value=hash.get("surgeon_desc");
	frmObj.days.value=hash.get("day");
	frmObj.start_time.value=hash.get("start_time");
	frmObj.end_time.value=hash.get("end_time");
	frmObj.schedule_type.value=hash.get("schedule_type");
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	if(otParam == 'Y' || otParam=='y'){
		frmObj.total_Slots.value = hash.get("totalSlots");
		if(hash.get("restrictedSlots") == 'null'){
			frmObj.restricted_Slots.value = "";
		}
		else{
			frmObj.restricted_Slots.value = hash.get("restrictedSlots");
		}
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	frmObj.mode.value="U";
	frmObj.recId.value=indx+1;
	var week = hash.get("week");
	if(hash.get("schedule_type")=="A"){
		chkBoxDisable();

	}else{
		chkBoxEnable();
		for(var j=0;j<week.length;j++ ){
			var val = week.charAt(j,j+1);
 			var wk = "week"+eval(j+1)
			obj = eval("frmObj."+wk);
			assingChkBoxVal(obj,val);
	    }
	}
	frmObj.mode.value="U";
	frmObj.day_status.value=rows.day_status;
	frmObj.days.disabled=true;
	frmObj.surgeon_desc.disabled=true;
	frmObj.speciality_desc.disabled=true;
	frmObj.start_time.disabled=true;
}

function assingChkBoxVal(obj,val){
	obj.checked=(val=="Y")?true:false;
	obj.value = val;
}

function resetFields(){
	var frmObj = document.forms[0];
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var otParam = frmObj.ot_Param.value;
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	var flag_yn=frmObj.menu_change_flag.value;
	//alert("Splty_code");
	if(flag_yn=="N"){
		frmObj.speciality_code.value='';
		frmObj.menu_change_flag.value
		enableTextField(frmObj.speciality_desc);
		frmObj.surgeon_desc.value="*All Surgeons";
		frmObj.surgeon_code.value="*ALL";
		enableTextField(frmObj.start_time);
		enableTextField(frmObj.end_time);
		chkBoxEnable();
		frmObj.schedule_type.value="S";
		frmObj.mode.value='I';
		frmObj.days.value='0@@W';
		frmObj.days.disabled=false;
		frmObj.generic_search_for_day.disabled=true;
		frmObj.generic_search_for_speciality.disabled=false;
		frmObj.cancel.disabled=false;
		//CRF-004 Authorize Slots for Booking - Rajesh V 
		if(otParam == 'Y' || otParam=='y'){
			frmObj.total_Slots.value = '';
			frmObj.restricted_Slots.value = '';
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V 
	}else{
		frmObj.speciality_code.value='';
		frmObj.surgeon_code.value='';
//		if(frmObj.speciality_desc.value!="All Specialities"){
		enableTextField(frmObj.speciality_desc);
//		}
		enableTextField(frmObj.surgeon_desc);
		enableTextField(frmObj.start_time);
		enableTextField(frmObj.end_time);
		chkBoxEnable();
		frmObj.schedule_type.value="S";
		frmObj.mode.value='I';
		frmObj.days.value='0@@W';
		frmObj.days.disabled=false;
		frmObj.generic_search_for_day.disabled=false;
		frmObj.generic_search_for_speciality.disabled=false;
		frmObj.cancel.disabled=false;
		//CRF-004 Authorize Slots for Booking - Rajesh V 
		if(otParam == 'Y' || otParam=='y'){
			frmObj.total_Slots.value = '';
			frmObj.restricted_Slots.value = '';
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V 
	}
}


function refresh(){
var params = document.forms[0].params.value;
window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/DairyScheduleForSuregonDetailForm.jsp?'+params;
}

function loadDBRows(str){ 
	 
	 /*  var arr = str.split("##");
	  var rows=window.parent.parent.frames[1].frames[1].rows;
	 var formObj = document.forms[0];
	   if(arr[10]=="L")
		{
		  var hash  = new Hashtable();
		  hash.put("surgeon_code",arr[0]);
		  hash.put("speciality_code",arr[1]);
		  hash.put("speciality_desc",arr[2]);
		  hash.put("day",arr[3]);
		  hash.put("day_desc",arr[4]);
		  hash.put("start_time",arr[5]);
		  hash.put("end_time",arr[6]);
		  hash.put("week",arr[7]);
		  hash.put("schedule_type",arr[8]);
		  hash.put("surgeon_desc",arr[9]);
		  hash.put("recId",rows.length+1);
		  hash.put("mode",arr[10]);
		  rows.push(hash);
		  loadWeek(arr[1]+arr[3].split("@@")[0]+arr[0],arr[7]);
		  refresh();
		  setTimeout("",3000);
	    
	}*/
	var delay = function() { loadDBRows1(str); };

	 setTimeout(delay,500);
   //loadDBRows1(str)
   
}
function loadDBRows1(str){ 
	var arr = str.split("##");
	  var rows=window.parent.parent.frames[1].frames[1].rows;
	  var formObj = document.forms[0];
	  //CRF-004 Authorize Slots for Booking - Rajesh V 
	  var otParam = formObj.ot_Param.value;
	  //CRF-004 Authorize Slots for Booking - Rajesh V 
	  var day_no_val=arr[3].split("@@");
		var day_no=day_no_val[0];
	  var final_value= arr[0] +"|"+arr[1] +"|"+day_no+"|"+arr[5]+"|"+arr[6] ;
	   if(arr[10]=="L")
		{
		var days=arr[3].replace('#','');//Maheshwaran K added for Inci  No : 38363 as on 27/03/2013
		  var hash  = new Hashtable();
		  hash.put("surgeon_code",arr[0]);
		  hash.put("speciality_code",arr[1]);
		  hash.put("speciality_desc",arr[2]);
		// hash.put("day",arr[3]);
		  hash.put("day",days);//Maheshwaran K modified for Inci  No : 38363 as on 27/03/2013
		  hash.put("day_desc",arr[4]);
		  hash.put("start_time",arr[5]);
		  hash.put("end_time",arr[6]);
		  hash.put("week",arr[7]);
		  hash.put("schedule_type",arr[8]);
		  hash.put("surgeon_desc",arr[9]);
		  hash.put("recId",rows.length+1);
		  hash.put("mode",arr[10]);
		  hash.put("final_value",final_value);
		  //CRF-004 Authorize Slots for Booking - Rajesh V 
		  if(otParam == 'Y' || otParam=='y'){
			if(arr[11]>0){
			  hash.put("totalSlots",arr[11]);
			}
			else{
			  var slots = calcSlotsInternal(arr[5],arr[6]);
			  hash.put("totalSlots",slots);
			}
			hash.put("restrictedSlots",arr[12]);						
		  }
		//CRF-004 Authorize Slots for Booking - Rajesh V 
		  rows.push(hash);
		  loadWeek(arr[1]+arr[3].split("@@")[0]+arr[0],arr[7]);
		  refresh();
	    }
  }


//To check start time and end time at the time of adding a row
function chkTime(){
	var formObj = document.DiaryScheduleForSurgeonForm;
	var frmStartTime=wrapTime(formObj.start_time.value);
	var frmEndTime=wrapTime(formObj.end_time.value);
	var err_txt="";
	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("APP-OT0166","OT");
        formObj.start_time.focus();
		formObj.start_time.select();
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return false;
	}else return true;
}


async function callSurgeoncode(obj){
	//alert("callSurgeoncode in DiaryScheduleForSurgeon.js "); //muthu
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Surgeon.label","Common");
//	var sql="SELECT '*All Surgeons' DESCRIPTION, '*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND  PRACT_TYPE IN ('SG','MD','DN','PS') AND  NVL(EFF_STATUS, 'E')!= 'D' AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

//Code Modified by rajesh for including RoleType on 09/07/2008

	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT '*All Surgeons' DESCRIPTION, '*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND  PRACT_TYPE IN ('SG','MD','DN','PS') AND  NVL(EFF_STATUS, 'E')= 'E') WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 1";
var sql=" SELECT PRACTITIONER_ID CODE, SHORT_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1 ";
//alert("1" +sql);
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].surgeon_code.value = arr[0];
		document.forms[0].surgeon_desc.value=arr[1];
	}else{
		document.forms[0].surgeon_code.value="";
		obj.value="";
	}

}


//This function converts given time to minutes
function convertTimeToMinutes(obj){
	var ot_unit_time_val=obj.split(":");
	var time_in_min=""; 
	time_in_min=parseInt((ot_unit_time_val[0]*60)+parseInt(ot_unit_time_val[1]));
	return time_in_min;
}
//This Function checks whether the given time is multiple of Unit Time or not

function chkUnitTime(){
	var formObj =document.forms[0];
	var obj_unit_time=formObj.unit_ot_time_DB.value;
	var obj_start_time=formObj.start_time.value;
	var obj_end_time=formObj.end_time.value;
	var unit_time=convertTimeToMinutes(obj_unit_time);
	var chk_start_time=convertTimeToMinutes(obj_start_time);
	var chk_end_time=convertTimeToMinutes(obj_end_time);
	var result=(parseInt(chk_end_time)-parseInt(chk_start_time))%(parseInt(unit_time));
	var flag=(result==0)?true:false;
	if(!flag){
		var msg_1 =  getMessage("APP-OT0110","OT")+" ("+obj_unit_time+")";
		 parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg_1;
		return false;
	}
	return true; 
}

function isValidTime(obj){
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time[0].length!=2 || arr_time[1].length!=2){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			obj.select();
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
			return false;
		}

	if(  isNaN(arr_time[0]) || isNaN(arr_time[1]) ){
			obj.select();
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
			return false;
	}

	if(arr_time[0]<0 || arr_time[0]>23 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT")+"\n";
			obj.select();
			
		}
		if(arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
			err_text+=getMessage("APP-OT0041","OT");
			obj.select();
			
		}
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}

	return true
}


//Copied for Surgeon/Speciality/Day/& Time Validation......

function cal_error(str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function validateDay(){
	var formObj = document.DiaryScheduleForSurgeonForm;
	var day_code=formObj.days.value+",";
	var dayCodeDtl = window.parent.parent.frames[1].frames[4].day;
	var flag=(dayCodeDtl.indexOf(day_code)>=0)?true:false;
	return flag;
}
function validateSpeciality(){
	var formObj = document.DiaryScheduleForSurgeonForm;
	var splty_code=formObj.speciality_code.value+",";
	var spltyCodeDtl =window.parent.parent.frames[1].frames[4].speciality_code; //detail frame
	var flag=(spltyCodeDtl.indexOf(splty_code)>=0)?true:false;

	return flag;
}

function validateSurgeon(){

	var formObj = document.DiaryScheduleForSurgeonForm;
	var surgeon_code=formObj.surgeon_code.value+",";
	var sugeonCodeDtl =window.parent.parent.frames[1].frames[4].surgeon_code; //detail frame
	 flag=(sugeonCodeDtl.indexOf(surgeon_code)>=0)?true:false;
	return flag;
}

function validateTimeOverLap(check_with_session_data_yn, old_start_time, old_end_time){
	var HdrformObj = parent.MasterFrame.document.forms[0];
	var formObj = document.DiaryScheduleForSurgeonForm;
	var room_code = formObj.oper_room_code1.value;
	var facility_id = formObj.facility_id.value;
	var spl_day_code=formObj.days.value;
	var test=spl_day_code.split("@@");
	var day_code=test[0];
	var splty_code=formObj.speciality_code.value;
	var surgeon_code=formObj.surgeon_code.value;
	var start_time=formObj.start_time.value;
	var end_time=formObj.end_time.value;
	var mode = formObj.mode.value;
	var schdule_type = formObj.schedule_type.value;
	var selected_weeks = formObj.selected_weeks.value;
	var retVal = callActiveXWindow(facility_id,room_code,day_code,splty_code,start_time,end_time,mode,schdule_type,selected_weeks,surgeon_code, check_with_session_data_yn, old_start_time, old_end_time);

	if(retVal=='X'){
	alert(getMessage("APP-OT0109","OT"));
	return false;
	}
	else
		return true;
//	return ((retVal=='X'))?false:true; 
}

function callActiveXWindow(facility_id,room_code,day_code,splty_code,start_time,end_time,mode,schdule_type,selected_weeks,surgeon_code,check_with_session_data_yn, old_start_time, old_end_time){
	var xmlStr ="<root></root>";
	//var params ="facility_id="+facility_id+"&room_code="+room_code+"&day_code="+day_code+"&splty_code="+splty_code+"&start_time="+start_time+"&end_time="+end_time;
	var params ="facility_id="+facility_id+"&room_code="+room_code+"&day_code="+day_code+"&splty_code="+splty_code+"&start_time="+start_time+"&end_time="+end_time+"&mode="+mode+"&schdule_type="+schdule_type+"&selected_weeks="+selected_weeks+"&surgeon_code="+surgeon_code+"&check_with_session_data_yn="+check_with_session_data_yn+"&old_start_time="+old_start_time+"&old_end_time="+old_end_time;
	var temp_jsp="../../eOT/jsp/SurgeonTimeoverLapValidation.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=localTrimString(xmlHttp.responseText);
	return responseText;
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}



/*
function processValidate(){
	var formObj = document.DiaryScheduleForSurgeonForm;
//	var day_code=formObj.day_code.value;
//Modified by rajesh for day code value is giong as null
	var spl_day_code=formObj.days.value;
	var test=spl_day_code.split("@@");
	var day_code=test[0];
	var flag = false;
	var res = "N";
	if(day_code=="0"){
		if( validateSpeciality()  && validateSurgeon() )
			res = validateTimeOverLap();
	}else{
			if(validateSpeciality() &&  validateDay() && validateSurgeon() )
				res = validateTimeOverLap();
	}
	return res;
}
*/
function processValidate(){
	var formObj = document.DiaryScheduleForSurgeonForm;
	var spl_day_code=formObj.days.value;
	var surgeon_code = formObj.surgeon_code.value;
	var speciality_code = formObj.speciality_code.value;
	var start_time_new = formObj.start_time.value;
	var end_time_new = formObj.end_time.value;
	var test=spl_day_code.split("@@");
	var day_code=test[0];
	var flag = false;
	var res = "N";

	var final_val_new=surgeon_code+"|"+speciality_code+"|"+day_code+"|"+start_time_new+"|"+end_time_new;
	if(day_code=="0"){
		if( validateSpeciality()  && validateSurgeon() ){
			var check_with_session_data_yn="N";
			var old_start_time = "";
			var old_end_time = "";

			var start_end_times = getStartAndEndTimesForExistingRecord(surgeon_code,speciality_code);
		
			if(start_end_times!=""){
				var times_arr = start_end_times.split("##");
				old_start_time = times_arr[0];
				old_end_time = times_arr[1];
				check_with_session_data_yn = "Y";
			}	
			res = validateTimeOverLap(check_with_session_data_yn, old_start_time, old_end_time);
		}
	}else{
		if(validateSpeciality() && validateDay() &&  validateSurgeon() ){
					

			var check_with_session_data_yn="N";
			//var old_start_time = times_arr[0];
			//var old_end_time = times_arr[1];
 var rows=window.parent.parent.frames[1].frames[1].rows;
  if(rows!=null){
	  var hash = new Hashtable();
			 var flag=true;
	 for(var jj=0;jj<rows.length;jj++){
		 hash = rows[jj];
		var final_value = hash.get("final_value");

			 if(final_val_new == final_value)
			 {
				alert(getMessage("CODE_ALREADY_EXISTS","Common"));
				flag=false;
				}
				if(flag==false)
				 {
					res=false;
				}
		
	 }
  }
		/*	commented by Suma for issue 18367 var start_end_times = getStartAndEndTimesForExistingRecord(surgeon_code,speciality_code);
			if(start_end_times!=""){
				var times_arr = start_end_times.split("##");
				old_start_time = times_arr[0];
				old_end_time = times_arr[1];
				check_with_session_data_yn = "Y";
			}	

			res = validateTimeOverLap(check_with_session_data_yn, old_start_time, old_end_time);*/
		}
	}
	return res;
}

function assignDayStatus(obj){
	  var frmObj=document.forms[0];
	  var arr=obj.value.split("@@");
	  frmObj.day_code.value=arr[0];
	  frmObj.day_status.value=arr[1];
	  
  }


function checkAll(){
	var formObj = document.forms[0];
	with(formObj){
		assingChkBoxVal(week1,"Y");
		assingChkBoxVal(week2,"Y");
		assingChkBoxVal(week3,"Y");
		assingChkBoxVal(week4,"Y");
		assingChkBoxVal(week5,"Y");
	}
}

function chkBoxEnableDisable(obj){
	if(obj.value=="A") {
		chkBoxDisable();
	}else{
		chkBoxEnable();
	}
 }

function chkBoxEnable(){
	  var formObj = document.forms[0];
	  with(formObj){
				enable(week1);
				enable(week2);
				enable(week3);
				enable(week4);
				enable(week5);
				schedule_type.disabled=false;
		}
  }

  function chkBoxDisable(){
	  var formObj = document.forms[0];
	  with(formObj){
				disable(week1);
				disable(week2);
				disable(week3);
				disable(week4);
				disable(week5);
				if(mode.value!="I") schedule_type.disabled=true;
		}
  }

  function disable(obj){
	  obj.disabled=true;
	  obj.checked=true;
	  obj.value="Y";
  }

  function enable(obj){
	  obj.disabled=false;
	  obj.checked=false;
	  obj.value="N";
  }

//Week Overlap Validation

function loadWeek(key,val){
	var hash=window.parent.parent.frames[1].frames[1].hash;
	hash.put(key,val);
}

function enableTextField(obj){
	obj.disabled=false;
	obj.value="";
}


function weekOverLapValidation(str){
	var formObj  = document.forms[0];
	var flag=false;
	var schedule_type = formObj.schedule_type.value
	var selected_weeks = formObj.selected_weeks.value;
	var arr = new Array();
	if(schedule_type=="S"){
		for(var i =0;i<str.length;i++){
			arr[i] = str.substring(i,i+1);
		}
	for(var j=0;j<selected_weeks.length;j++){
			var sel = selected_weeks.substring(j,j+1);
			flag = (arr[sel-1]=="Y")?true:false;
			if(flag) break;
		}
	}
	/*if(flag){
		callMessageFrame("APP-OT0109"); 
	}*/
	return (flag)?false:true;

}
	



function overLapValidation(){
	var rows=window.parent.parent.frames[1].frames[1].rows;
	var flag=false;
	var formObj  = document.forms[0];
	var splty_code = formObj.speciality_code.value;
	var day_code = formObj.day_code.value;
	var surgeon_code = formObj.surgeon_code.value;
	//var selected_weeks = formObj.selected_weeks.value;
	var str = "";
	var flag_1 = false;
	var day_code_1 = "";
	for(i in rows){
		var hash = new Hashtable();
		hash = rows[i];
		if( hash.get("surgeon_code")==surgeon_code){
				if(hash.get("speciality_code")==splty_code){
					day_code_1 =  hash.get("day").split("@@")[0];
					if(day_code_1== day_code || day_code_1=="0" || day_code=="0"){
						var cmp_start_time = hash.get("start_time");
						var cmp_end_time = hash.get("end_time");
						str = hash.get("week");
						//time validation & week overlap validation
						flag =	isBetween(cmp_start_time,cmp_end_time,str);	
						//if flag is true then overlapping occurs otherwise no overlapping
						if(flag==true){ 								
								callMessageFrame("APP-OT0109");
								break;
						}
								
					}
				}
		}
	}
	return  (flag)?false:true;	
}


function isBetween(st_time,end_time,str){
	var overlap_flag = false;
	var formObj = document.forms[0];
	var  cmp_st_time = wrapTime(trimString(st_time));//comparing time
	var  cmp_end_time = wrapTime(trimString(end_time));//comparing time
	var start_time = wrapTime(formObj.start_time.value) //entering time
	var end_time = wrapTime(formObj.end_time.value); //entering time
	var schedule_type = formObj.schedule_type.value
	if( start_time >= cmp_st_time || start_time <= cmp_end_time )	overlap_flag = true;
	
	//week overlap validation checking 
	if(schedule_type=='S'){
		var flag_1 = weekOverLapValidation(str);
		if(flag_1==false) overlap_flag = false;
	}


/*	if(!overlap_flag){
		if( end_time > cmp_st_time && end_time < cmp_end_time ) overlap_flag = true;
	}*/

	return (overlap_flag)?false:true;

}

function getStartAndEndTimesForExistingRecord(surgeon_code,speciality_code){
	var formObj = document.forms[0];
	var rows=window.parent.parent.frames[1].frames[1].rows;
	var row_length = rows.length;
	var old_surgeon_code = "";
	var old_speciality_code = "";
	var old_start_time = "";
	var old_end_time = "";
	var start_end_times = "";

	for(i in rows){
		var hash = new Hashtable();
		hash = rows[i];
		old_speciality_code = hash.get("speciality_code");
		old_surgeon_code = hash.get("surgeon_code");
		if(surgeon_code==old_surgeon_code && speciality_code==old_speciality_code){
			old_start_time = hash.get("start_time");
			old_end_time = hash.get("end_time");
			start_end_times = old_start_time+"##"+old_end_time;
		}
	}

	return start_end_times;
}


function callAlertFunction(msg_id) {
	alert(getMessage(msg_id,'OT'));
	//parent.content.frames[0].document.forms[0].home.click();
	//parent.content.location.href='../../eCommon/jsp/maindisplay.jsp';
	parent.parent.parent.frames[1].expand(this);//046233
	return false;//046233] 
}

//CRF-004 Authorize Slots for Booking - Rajesh V 
function calcSlots(){
		var stTime0;
		var stTime1;
		var enTime0;
		var enTime1;
		var unTime0;
		var unTime1;

	var record_formObj = parent.RecordFrame.document.forms[0];
	var start_time = record_formObj.start_time.value;
	var end_time =  record_formObj.end_time.value;
	var unitOtTime = record_formObj.unit_ot_time_DB.value;
	var operRoom = parent.MasterFrame.document.forms[0].oper_room_code.value;
	if(start_time!="" && end_time!="" && operRoom!=""){
		var weekDaySlots = "";
		var unitSlots = "";
		var startTimeArr = start_time.split(":");
		var endTimeArr = end_time.split(":");
		var unitTimeArr = unitOtTime.split(":");



		if(unitTimeArr[0].charAt(0)=='0')			   unTime0 =  unitTimeArr[0].charAt(1);
					else 				unTime0 =  unitTimeArr[0];	

		if(unitTimeArr[1].charAt(0)=='0')			   unTime1 =  unitTimeArr[1].charAt(1);
		else 		unTime1 =  unitTimeArr[1];	

		if(startTimeArr[0].charAt(0)=='0')			   stTime0 =  startTimeArr[0].charAt(1);
		else 				stTime0 =  startTimeArr[0];	

		if(startTimeArr[1].charAt(0)=='0')			   stTime1 =  startTimeArr[1].charAt(1);
		else 		stTime1 =  startTimeArr[1];	

		if(endTimeArr[0].charAt(0)=='0')			   enTime0 =  endTimeArr[0].charAt(1);
		else 				enTime0 =  endTimeArr[0];	

		if(endTimeArr[1].charAt(0)=='0')			   enTime1 =  endTimeArr[1].charAt(1);
		else 		enTime1 =  endTimeArr[1];	

		

		/*	
		unitSlotsMin = parseInt((parseInt(unitTimeArr[0]))*60)+parseInt(parseInt(unitTimeArr[1]));
		weekDaySlots = parseInt(parseInt((parseInt(endTimeArr[0]))*60)+parseInt(parseInt(endTimeArr[1])))-parseInt(parseInt((parseInt(startTimeArr[0]))*60)+parseInt(parseInt(startTimeArr[1])));
		weekDaySlots = parseInt(weekDaySlots)/parseInt(unitSlotsMin);
		*/

		unitSlotsMin = parseInt((parseInt(unTime0))*60)+parseInt(parseInt(unTime1));

		weekDaySlots = parseInt(parseInt((parseInt(enTime0))*60)+parseInt(parseInt(enTime1)))-parseInt(parseInt((parseInt(stTime0))*60)+parseInt(parseInt(stTime1)));

		weekDaySlots = parseInt(weekDaySlots)/parseInt(unitSlotsMin);

		//weekDaySlots = ""+weekDaySlots;

		record_formObj.total_Slots.value = weekDaySlots;
	}

}

function calcSlotsInternal(start_Time,end_Time){

		var stTime0;
		var stTime1;
		var enTime0;
		var enTime1;
		var unTime0;
		var unTime1;


	var record_formObj = parent.RecordFrame.document.forms[0];
	var start_time =  start_Time;
	var end_time = end_Time;
	
	var unitOtTime = record_formObj.unit_ot_time_DB.value;
	var operRoom = parent.MasterFrame.document.forms[0].oper_room_code.value;
	if(start_time!="" && end_time!="" && operRoom!=""){
		var weekDaySlots = "";
		var unitSlots = "";
		var startTimeArr = start_time.split(":");
		var endTimeArr = end_time.split(":");
		var unitTimeArr = unitOtTime.split(":");
		



		if(unitTimeArr[0].charAt(0)=='0')			   unTime0 =  unitTimeArr[0].charAt(1);
							else 				unTime0 =  unitTimeArr[0];	

				if(unitTimeArr[1].charAt(0)=='0')			   unTime1 =  unitTimeArr[1].charAt(1);
				else 		unTime1 =  unitTimeArr[1];	

				if(startTimeArr[0].charAt(0)=='0')			   stTime0 =  startTimeArr[0].charAt(1);
				else 				stTime0 =  startTimeArr[0];	

				if(startTimeArr[1].charAt(0)=='0')			   stTime1 =  startTimeArr[1].charAt(1);
				else 		stTime1 =  startTimeArr[1];	

				if(endTimeArr[0].charAt(0)=='0')			   enTime0 =  endTimeArr[0].charAt(1);
				else 				enTime0 =  endTimeArr[0];	

				if(endTimeArr[1].charAt(0)=='0')			   enTime1 =  endTimeArr[1].charAt(1);
				else 		enTime1 =  endTimeArr[1];	

		


		unitSlotsMin = parseInt((parseInt(unTime0))*60)+parseInt(parseInt(unTime1));

		weekDaySlots = parseInt(parseInt((parseInt(enTime0))*60)+parseInt(parseInt(enTime1)))-parseInt(parseInt((parseInt(stTime0))*60)+parseInt(parseInt(stTime1)));

		weekDaySlots = parseInt(weekDaySlots)/parseInt(unitSlotsMin);







/*		unitSlotsMin =  parseInt((parseInt(unitTimeArr[0]))*60)+parseInt(parseInt(unitTimeArr[1]));
		weekDaySlots = parseInt(parseInt((parseInt(endTimeArr[0]))*60)+parseInt(parseInt(endTimeArr[1])))-parseInt(parseInt((parseInt(startTimeArr[0]))*60)+parseInt(parseInt(startTimeArr[1])));
		
		weekDaySlots = parseInt(weekDaySlots)/parseInt(unitSlotsMin);*/
		//weekDaySlots = ""+weekDaySlots;
		return weekDaySlots;
	}

}

function checkUnitTime(){
	var operRoom = parent.MasterFrame.document.forms[0].oper_room_code.value;
	var formObj =document.forms[0];
	var obj_unit_time=formObj.unit_ot_time_DB.value;
	var obj_start_time=formObj.start_time.value;
	var obj_end_time=formObj.end_time.value;
	if(operRoom!='' && obj_start_time!='' && obj_end_time!=''){
		var unit_time=convertTimeToMinutes(obj_unit_time);
		var chk_start_time=convertTimeToMinutes(obj_start_time);
		var chk_end_time=convertTimeToMinutes(obj_end_time);
		var result=(parseInt(chk_end_time)-parseInt(chk_start_time))%(parseInt(unit_time));
		var flag=(result==0)?true:false;
		if(!flag){
			formObj.start_time.value = '';
			formObj.end_time.value = '';
			var msg_1 =  getMessage("APP-OT0110","OT")+" ("+obj_unit_time+")";
			 parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg_1;
			return false;
		}
	}
	
	return true; 
}

function checkResSlots(obje){
	var obj = document.getElementById("restricted_Slots");
    if ( obj.value >= 0) {
        	if(parseInt(obj.value)>parseInt(document.getElementById('total_Slots').value)){
       		 alert(getMessage("APP-OT0201","OT"));
                document.getElementById(obje).value = "";
                return false;
       	}
           return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            document.getElementById(obje).value = "";
            return false;
        }
    }
}
//CRF-004 Authorize Slots for Booking - Rajesh V 
// Added by Chaitanya for IN:043345 on October 17, 2013
function checkResSlotsNumber(obje)
{
	var obj = document.getElementById("restricted_Slots");
	 if (trimString(obj.value).length > 0) 
	 {
		if(chkContainChars(obj.value,"0123456789") == false)
		{
			alert(getMessage("NUM_ALLOWED", "SM"));
			document.getElementById(obje).value = "";
			return false;
		}
		if(parseInt(obj.value) > parseInt(document.getElementById('total_Slots').value))
		{
			alert(getMessage("APP-OT0201","OT"));
			document.getElementById(obje).value = "";
			return false;
		}
	}
	else
	{
		alert(getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(getLabel("eOT.PermissibleSlots.Label","OT"))));
		document.getElementById(obje).value = "";
		 return false;
	}
	return true;
}
function chkContainChars(s,bag)
{
    var i;
    for(i=0;i<s.length;i++)
    {
        var c = s.charAt(i);
        if(bag.indexOf(c) == -1)
            return false;
    }
    return true;
}
// Added by Chaitanya for IN:043345 on October 17, 2013

