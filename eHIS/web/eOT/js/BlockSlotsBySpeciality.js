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
	week[0] = getLabel("Common.all.label","common");
	week[1] = getLabel("Common.mon.label","common");
	week[2] = getLabel("Common.tue.label","common");
	week[3] = getLabel("Common.wed.label","common");
	week[4] = getLabel("Common.thu.label","common");
	week[5] = getLabel("Common.fri.label","common");
	week[6] = getLabel("Common.sat.label","common");
	week[7] = getLabel("Common.sun.label","common");

}

function create()
{  
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	//alert(source);
	f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?'+source;
}

function apply()
{	
	
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
	var code = HdrformObj.oper_room_code1.value;
	var params= masterframe.BlockSlotsBySpecialityHdr.params.value;
	var mode = HdrformObj.mode.value;
	//var detailframe = window.parent.frames[1].frames[1].frames[4];
	var detailframe = parent.content.f_query_add_mod.DetailFrame;
    //var hiddenframe=window.parent.frames[1].frames[1].frames[1];
    var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
	var operatingroom=getLabel("Common.OperatingRoom.label","Common");
	var formObj = document.forms.BlockSlotsBySpecialityHdr;
	var fields = new Array(HdrformObj.oper_room_code);
	var names = new Array(operatingroom);
	var rows=hiddenframe.rows;
	var curr_date=HdrformObj.curr_date.value;
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.BlockSlotsBySpecialityServlet?curr_date='+curr_date;
	xmlStr+=hiddenframe.createXMLForOT_SPECIALITY_TIME_TABLE();
	xmlStr+="</root>";
	if(xmlStr.indexOf("<root></root>")!=-1){
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return;
	}
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	autoRefresh(code,mode,retVal,params);
	}
	else
	{
	parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
    }
}

function autoRefresh(code,mode,mesg,params){
	params=params+"oper_room_code="+code+"&update_mode_yn="+mode+"&mesg="+mesg;
	if(mode=="modify") {
		//parent.frames[1].frames[1].location.href="../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?mode="+mode+"&"+params;
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?mode="+mode+"&"+params;
	} else {
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?mode=insert&mesg="+mesg;
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsBySpecialitiesFrameInCreateMode.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

function reset() {
   if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BlockSlotsBySpecialityFrameForCreate.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("BlockSlotsBySpecialityMain.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
   }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BlockSlotsBySpecialityQueryCriteria.jsp") != -1)
	{
	   f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	var source=document.forms[0].source.value;
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    }
	f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsBySpecialityQueryCriteria.jsp'
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

async function callSpecialitycode(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit="Category Search" ;
	var tit=getLabel("Common.speciality.label","common");
	var sql="SELECT A.SHORT_DESC DESCRIPTION, B.SPECIALITY_CODE CODE FROM   OT_SPECIALITIES B , AM_SPECIALITY_LANG_VW a WHERE a.LANGUAGE_ID='"+locale+"' AND B.SPECIALITY_CODE = A.SPECIALITY_CODE and   NVL(eff_status, '$') != 'S' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(B.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 1";
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

function Class_blockSlotsBySpecialityrow(){
     this.speciality_code="";
	 this.speciality_desc="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.day_code="";
     this.day_desc="";
	 this.start_time="";
	 this.end_time="";
	 this.schedule_type="";
	 this.week1="";
	 this.week2="";
	 this.week3="";
	 this.week4="";
	 this.week5="";
	 this.mode="";
	 this.day_status="";
	 this.recId ="";
}


 function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


function chkEmpty(){
	var speciality=getLabel("Common.speciality.label","common");
	var day=getLabel("Common.day.label","common");
	var startTime=getLabel("Common.StartTime.label","common");
	var endTime=getLabel("Common.EndTime.label","common");
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var fields = new Array(formObj.speciality_code,formObj.day,formObj.start_time,formObj.end_time);
	var names = new Array(speciality,day,startTime,endTime);
	var messageFrame = window.parent.parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
	return true;
}

function newRow(){
  var objrow = new Class_blockSlotsBySpecialityrow(); // 
   return(objrow);
}

//This Function checks for Time Range For Start & End Times, Time entered should fall within the range given in operating room function
function chkTimeRange(){
	var RecordformObj = document.BlockSlotsBySpecialityRecordForm;
	var day_status=RecordformObj.day_status.value;
	var start_time=RecordformObj.start_time.value;
	var end_time=RecordformObj.end_time.value;
	var wd_start_time=RecordformObj.wd_start_time.value;
	var wd_end_time=RecordformObj.wd_end_time.value;
	var hd_start_time=RecordformObj.hd_start_time.value;
	var hd_end_time=RecordformObj.hd_end_time.value;
	var err_txt="";
	if(day_status=="W"){
		if(start_time<wd_start_time||start_time>wd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+wd_start_time+msgArr[1]+ wd_end_time+msgArr[2];

		}
		if(end_time<wd_start_time || end_time>wd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+wd_start_time+msgArr[1]+ wd_end_time+msgArr[2];
		}
	}else if(day_status=="H"){
		if(start_time<hd_start_time || start_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+hd_start_time+msgArr[1]+hd_end_time+msgArr[2];
		}
		if(end_time<hd_start_time||end_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+ hd_start_time+msgArr[1]+ hd_end_time+msgArr[2];
		}
	}
	if(err_txt.length>0){
		  parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	      return false;
		}
	return true; 
}

//This function converts given time to minutes
function convertTimeToMinutes(val){
	var ot_unit_time_val=val.split(":");
	var time_in_min=parseInt((ot_unit_time_val[0]*60)+parseInt(ot_unit_time_val[1]));
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

//function is used to validate the start and end time /time range and unit time

function vaidateTimings(){
	if(!chkTime()) return false;
	if(!chkUnitTime()) return false;
	if(! chkTimeRange()) return false;
	if(! validateWeek()) return false;
	if(! weekOverLapValidation()) return false;
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
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var from_time=formObj.start_time.value
	var to_time=formObj.end_time.value

	if(HdrformObj.oper_room_code.value==""){
	  var msg = getMessage("CANNOT_BE_BLANK","OT");
	  var msgArray = msg.split("&");
  	  var operation_room=getLabel("eOT.OperationRoom.Label","OT");
	  alert(msgArray[0]+operation_room+msgArray[1]);
	  return false;
  }

  var HdrformObj = parent.MasterFrame.document.forms[0];
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var hash=window.parent.parent.frames[1].frames[1].hash;
  var formObj = document.BlockSlotsBySpecialityRecordForm;
   var mode =formObj.mode.value;
  // alert(mode);
  if(chkEmpty() && mode=='I'){
//	if(chkTimeRange())
	if(vaidateTimings() ){
		if(processValidate()){
			var objrow = newRow();
			with(formObj){
				 objrow.speciality_code		= speciality_code.value;
				 objrow.speciality_desc		= speciality_desc.value;
				 objrow.day_code			= day_code.value;
				 objrow.day_desc			= week[day_code.value];
				 objrow.start_time			= start_time.value;
				 objrow.end_time			= end_time.value;
				 objrow.schedule_type		= schedule_type.value;
				 objrow.week1				= week1.value;
				 objrow.week2				= week2.value;
				 objrow.week3				= week3.value;
				 objrow.week4				= week4.value;
				 objrow.week5				= week5.value;
				 hash.put(speciality_code.value+day_code.value,week1.value+week2.value+week3.value+week4.value+week5.value);
				 objrow.day_status			=day_status.value;	
				 objrow.mode="I";
				 objrow.recId = rows.length+1;
				 rows.push(objrow);
				 resetFields();
				 refresh();
			 }
		  }else{
			  //show the error message in the message frame;
			  callMessageFrame("APP-OT0109");
			  return;
		  }//chkTimeOverlap
	}//vaidateTimings
}else
	  updateRow();
}





function updateRow(){
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows;
	var hash=window.parent.parent.frames[1].frames[1].hash;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
  		if(rows.length>0 && mode=='U'){
			   for(var jj=0;jj<rows.length;jj++){
				 if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
                        if(vaidateTimings()){
							//rows[jj].start_time=formObj.start_time.value;
							rows[jj].end_time=formObj.end_time.value;
							rows[jj].schedule_type=formObj.schedule_type.value;
							rows[jj].week1=formObj.week1.value;
							rows[jj].week2=formObj.week2.value;
							rows[jj].week3=formObj.week3.value;
							rows[jj].week4=formObj.week4.value;
							rows[jj].week5=formObj.week5.value;
							hash.put(rows[jj].speciality_code+rows[jj].day_code,rows[jj].week1+rows[jj].week2+rows[jj].week3+rows[jj].week4+rows[jj].week5);
				            if(rows[jj].mode=='L'){
								rows[jj].mode='U';
							}else if ( rows[jj].mode=='I'){
								rows[jj].mode='I';
							}

							//rows[jj].mode='I';
						}else return;
					}
		         }else  
					continue;
			}
      resetFields();
	  refresh();
 }
}

function removeRow(){
var formObj = document.BlockSlotsBySpecialityRecordForm;
var rows=window.parent.parent.frames[1].frames[1].rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].mode=='L')
				rows[jj].mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
// refresh();
window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp';
}else
   resetFields();
}

function assingChkBoxVal(obj,val){
	obj.checked=(val=="Y")?true:false;
	obj.value = val;
}


function splitString(index){
	var frmObj = document.BlockSlotsBySpecialityRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows[index];
	frmObj.speciality_code.value=rows.speciality_code;
	frmObj.speciality_desc.value=rows.speciality_desc;
	frmObj.day.value=rows.day_code+"@@"+rows.day_status;
	frmObj.day_code.value=rows.day_code;
	frmObj.start_time.value=rows.start_time;
	frmObj.end_time.value=rows.end_time;
	frmObj.schedule_type.value=rows.schedule_type;
	if(rows.schedule_type=="A"){
		chkBoxDisable();

	}else{
		with(frmObj){
				chkBoxEnable();
				assingChkBoxVal(week1,rows.week1);
				assingChkBoxVal(week2,rows.week2);
				assingChkBoxVal(week3,rows.week3);
				assingChkBoxVal(week4,rows.week4);
				assingChkBoxVal(week5,rows.week5);
				
		}
	}
	frmObj.recId.value=rows.recId;
	frmObj.mode.value="U";
	frmObj.day_status.value=rows.day_status;
	frmObj.day.disabled=true;
	frmObj.speciality_desc.disabled=true;
	frmObj.start_time.disabled=true;
}


function resetFields(){
	var frmObj = document.BlockSlotsBySpecialityRecordForm;
	with(frmObj){
		start_time.disabled=false;
		speciality_desc.disabled=false;
		schedule_type.disabled=false;
		day.disabled=false;
		speciality_desc.value='';
		speciality_code.value='';
		start_time.value='';
		end_time.value='';
		mode.value='I';
		schedule_type.value="S";
		day.value="";
		selected_weeks.value="";
		chkBoxEnable();
	}
}

function refresh(){
	var params = document.forms[0].params.value;
	window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?'+params;
}

function loadDBRows(speciality_code,speciality_desc,day_code,day_desc,start_time,end_time,schedule_type,week1,week2,week3,week4,week5,recId,day_status,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var i=0;
   if(mode=='L'){
	  objrow.speciality_code = speciality_code;
	  objrow.speciality_desc = decodeURIComponent(speciality_desc,"UTF-8").replace(/\+/g," ");
	  objrow.day_code =day_code;
	  objrow.day_desc=day_desc;
	  objrow.start_time=start_time;
	  objrow.end_time=end_time;
	  objrow.schedule_type=schedule_type;
	  objrow.week1=week1;
	  objrow.week2=week2;
	  objrow.week3=week3;
	  objrow.week4=week4;
	  objrow.week5=week5;
	  objrow.mode=mode;
	  objrow.recId=recId;
  	  objrow.day_status=day_status;
	  rows.push(objrow);
	}
}

//To check start time and end time at the time of adding a row
function chkTime(){
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var frmStartTime=formObj.start_time.value;
	var frmEndTime=formObj.end_time.value;
	var err_txt="";
	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
        formObj.start_time.focus();
		formObj.start_time.select();
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
        return false;
	}else{ return true};
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

function validateDuration(obj){
var formObj = document.BlockSlotsBySpecialityRecordForm;
	var from_time=formObj.start_time.value
	var splt_from_dur=from_time.split(":");
	var to_time=formObj.end_time.value
	var splt_to_dur=to_time.split(":");
if(from_time!=''){
	if(from_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("APP-OT0130","OT"));
		formObj.start_time.value="";
		formObj.start_time.select();
//		formObj.start_time.focus()
		return;
	}
	if(splt_from_dur[0].length!=2 ||splt_from_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		formObj.start_time.value="";
		formObj.start_time.select();
//		formObj.start_time.focus()
		return;
	}
}
if(to_time!=''){	
	if(to_time.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert("Invalid Format : End Time Hours/Minutes (00:00)")
		formObj.end_time.value="";
		formObj.end_time.select();
//		formObj.end_time.focus();

		return;
	}
	if(splt_to_dur[0].length!=2 ||splt_to_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		formObj.end_time.value="";
		formObj.end_time.select();
//		formObj.end_time.focus()
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2 || arr_time[1]=='' || arr_time[0]==''){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
/*		if(arr_time[1]=='' || arr_time[0]==''){
			alert("1");
		cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}*/
		if(arr_time[0]<0 || arr_time[0]>23 || arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT");
		}
	/*	if(arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
			err_text+=getMessage("APP-OT0041","OT");
		}*/
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}
	return true
}


function cal_error (str_message,obj) {
	alert (str_message);
	obj.value="";
	obj.select();
	return null;
}


function validateDay(){
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var day_code=formObj.day_code.value+",";
	var speciality_code =formObj.speciality_code.value+",";
	var dayCodeDtl = window.parent.parent.frames[1].frames[4].day_code;
	var allDaySplty = window.parent.parent.frames[1].frames[4].allDaySplty;
	if(allDaySplty.indexOf( speciality_code )>=0) return true;
	var flag=(dayCodeDtl.indexOf(day_code)>=0)?true:false;
	return flag;
}
function validateSpeciality(){
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var splty_code=formObj.speciality_code.value+",";
	var spltyCodeDtl =window.parent.parent.frames[1].frames[4].speciality_code; //detail frame
	var flag=(spltyCodeDtl.indexOf(splty_code)>=0)?true:false;
	return flag;
}

function validateTimeOverLap(){
	var HdrformObj = parent.MasterFrame.document.forms[0];
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var room_code = formObj.oper_room_code1.value;
	var facility_id = formObj.facility_id.value;
	var day_code=formObj.day_code.value;
	var splty_code=formObj.speciality_code.value;
	var start_time=formObj.start_time.value;
	var end_time=formObj.end_time.value;
	var mode = formObj.mode.value;
	var schdule_type = formObj.schedule_type.value;
	var selected_weeks = formObj.selected_weeks.value;
	var retVal = callActiveXWindow(facility_id,room_code,day_code,splty_code,start_time,end_time,mode,schdule_type,selected_weeks);
	return ((retVal=='X'))?false:true; 
	
}

function callActiveXWindow(facility_id,room_code,day_code,splty_code,start_time,end_time,mode,schdule_type,selected_weeks){
	var xmlStr ="<root></root>";
	var params ="facility_id="+facility_id+"&room_code="+room_code+"&day_code="+day_code+"&splty_code="+splty_code+"&start_time="+start_time+"&end_time="+end_time+"&mode="+mode+"&schdule_type="+schdule_type+"&selected_weeks="+selected_weeks;
	var temp_jsp="../../eOT/jsp/TimeOverLapValidation.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=localTrimString(xmlHttp.responseText);
	return responseText;
}


function processValidate(){
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var day_code=formObj.day_code.value;
	var flag = false;
	var res = "N";
	if(day_code=="0"){
		if(validateSpeciality())
			res = validateTimeOverLap();
	}else{
		if(validateSpeciality() &&  validateDay() )
			res = validateTimeOverLap();
				
		}
	return res;
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
				if(mode.value!="I") schedule_type.disabled=true; //Modified By Muthukumar against IN028658 on 05/09/2011
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


  function assignDayStatus(obj){
	  var frmObj=document.forms[0];
	  var arr=obj.value.split("@@");
	  frmObj.day_code.value=arr[0];
	  frmObj.day_status.value=arr[1];
  
  }


// function copiedfrom BlockSlotsBySpecialityMain.jsp

  function assignValues(obj){
	var formObj=document.forms[0];
	var rows=window.parent.frames[1].rows;
	if(rows!=null){
		if(rows.length!=0)
			rows.length=0;
	}
	var RecordFrame=window.parent.frames[3];
	var RecordFrame_formObj=RecordFrame.document.forms[0];
	var update_mode_yn=RecordFrame_formObj.mode.value;
	var val=obj.value;
	var arr=val.split("::");
    var oper_room_code=arr[0];
	var wd_start_time=arr[1];
	var wd_end_time=arr[2];
	var hd_start_time=arr[3];
	var hd_end_time=arr[4];
    window.parent.frames[4].location.href='../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?';	
	window.parent.frames[3].location.href="../../eOT/jsp/BlockSlotsBySpecialityRecord.jsp?oper_room_code="+oper_room_code+"&wd_start_time="+wd_start_time+"&wd_end_time="+wd_end_time+"&hd_start_time="+hd_start_time+"&hd_end_time="+hd_end_time+"&update_mode_yn="+update_mode_yn;
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


function loadWeek(key,val){
	var hash=window.parent.parent.frames[1].frames[1].hash;
	hash.put(key,val);
}


function weekOverLapValidation(){
	var hash=window.parent.parent.frames[1].frames[1].hash;
	var formObj  = document.forms[0];
	var splty_code = formObj.speciality_code.value;
	var day_code = formObj.day_code.value;
	key = splty_code+day_code;
	var val = hash.get(key);
	if(val!=null){
		var arr = new Array();
		for(var i =0;i<val.length;i++){
			arr[i] = val.substring(i,i+1);
		}
		var selected_weeks = formObj.selected_weeks.value;
		for(var j=0;j<selected_weeks.length;j++){
			var indx = parseInt(selected_weeks.substring(j,j+1));
			var flag = (arr[indx-1]=="Y")?true:false;
			if(flag) break;
		}
		if(flag){
			callMessageFrame("APP-OT0109"); 
		}
		return (flag)? false:true;
	}else
		return true;
	
}

