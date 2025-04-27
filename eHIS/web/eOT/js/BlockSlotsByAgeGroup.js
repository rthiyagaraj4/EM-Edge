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
	var cmf=commontoolbarFrame.document.forms[0];
	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsByAgeGroupFrameForCreate.jsp?'+source+"&update_mode_yn=insert";
}

function apply()
{	
	var formObj=window.parent.frames[1].frames[1].frames[0].document.forms[0];
	var oper_room_code=formObj.oper_room_code.value;
	//alert("oper_value :",oper_value);
	if (oper_room_code!='' && oper_room_code!=null) {
		//var msg = "No Changes to Commit..";
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		var masterframe = window.parent.frames[1].frames[1].frames[0]; 
		var HdrformObj=masterframe.document.forms[0];
		//var curr_date=HdrformObj.curr_date.value;
		var detailframe = window.parent.frames[1].frames[1].frames[4];
		var rows=window.parent.frames[1].frames[1].frames[1].rows;
		var hiddenframe=window.parent.frames[1].frames[1].frames[1];
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root>";
		var action = '../../servlet/eOT.BlockSlotsByAgeGroupServlet';
		//xmlStr+=hiddenframe.createXMLForOT_SPECIALITY_TIME_TABLE();
		xmlStr+=createXMLForAgeGroup();
		xmlStr+="</root>";
		//alert(xmlStr);
		if(xmlStr.indexOf("<root></root>")!=-1){
			window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return ;
		}
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		//alert("retVal=="+retVal);
				window.parent.frames[1].frames[1].frames[1].location.reload();
				window.parent.frames[1].frames[0].location.reload();
				window.parent.frames[1].frames[1].frames[0].location.reload();
				window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+retVal;
	} else {
		err_txt=getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = err_txt.split("&");
		var speciality=getLabel("Common.OperatingRoom.label","Common");
		err_txt=msgArray[0]+speciality+msgArray[1];
		window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_txt;

	}
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsBySpecialitiesFrameInCreateMode.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

function reset()
{
	//alert(parent.master_pages.f_query_add_mod.hidden_frame.name);
	  //var HdrFrame=window.parent.parent.frames[1].frames[0];
	  //alert(window.parent.frames[1].frames[1].frames[0].document.forms[0].name);
	  f_query_add_mod.document.forms[0].reset();
}

function query(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==false){
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eOT/jsp/BlockSlotsBySpecialityQueryCriteria.jsp';
}

function setCheckValue(obj){
	obj.value = (obj.checked)?"Y":"N"
}

function callAgeGroupcode(){
	var column_sizes = escape("20%,20%,20%,20%,20%");               
	var column_descriptions=getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common')+','+getLabel('Common.gender.label','common')+','+getLabel('Common.MinAge.label','common')+','+getLabel('Common.MaxAge.label','common');
	column_descriptions = encodeURIComponent(column_descriptions);
	var sql=escape("SELECT SHORT_DESC DESCRIPTION,AGE_GROUP_CODE CODE,NVL(GENDER,'Non Specific') SEX,MIN_AGE MINIMUM,MAX_AGE MAXIMUM from AM_AGE_GROUP where nvl(EFF_STATUS,'E')='E'");
	var title=encodeURIComponent(getLabel("Common.agegroup.label","common"));
	var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&sql="+sql;
	var retVal=callDialog(param);
	retVal=checkNull(retVal);
	var obj=document.forms[0];
	var arr=new Array();
	if(retVal!=""){
		arr=retVal.split("::");
		document.forms[0].agegrp_desc.value = arr[0];
		document.forms[0].agegrp_code.value = arr[1];
		document.forms[0].gender.value=arr[2];
	}else{
		document.forms[0].agegrp_desc.value = '';
		document.forms[0].agegrp_code.value = '';	
		document.forms[0].gender.value='';
	}
}

function trimString(sInString) {
return sInString.replace(/^\s+|\s+$/g,"");
}

function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	var retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}


function checkNull(retVal){
	return (retVal!=null && retVal.length>0)?retVal:""; 		
}
  
// This Function checks for Duplicate Start & End Times
function alreadyExist(){
	return true;
	/*
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var spltyCodeDtl =window.parent.parent.frames[1].frames[4].speciality_code; //detail frame
	var dayCodeDtl = window.parent.parent.frames[1].frames[4].day_code;
	var startTimeDtl = window.parent.parent.frames[1].frames[4].start_time;
	var endTimeDtl = window.parent.parent.frames[1].frames[4].end_time;
	var frmSpeciality_code=formObj.speciality_code.value;
	var frmDayCode = formObj.day_code.value;
	var frmStartTime=formObj.start_time.value;
	var frmEndTime=formObj.end_time.value;
	err_txt="";
	
        if(spltyCodeDtl.indexOf(frmSpeciality_code)>=0 && dayCodeDtl.indexOf(frmDayCode)>=0 && (startTimeDtl.indexOf(frmStartTime)>=0 || endTimeDtl.indexOf(frmEndTime)>=0) ){
			if(startTimeDtl.indexOf(frmStartTime)>=0 || endTimeDtl.indexOf(frmEndTime)>=0){
				if(startTimeDtl.indexOf(frmStartTime)>=0){
					err_txt+="APP-OT40 Start Time Slot Overlaped...";
				}else if(endTimeDtl.indexOf(frmEndTime)>=0){
					err_txt+="APP-OT40 End Time Slot Overlaped...";
				}
			 }
		}
		 if(err_txt.length>0){
              parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	     	  return false;
		}else return true;
		*/
}

 function chkEmpty(){
	var formObj = document.forms[0];
	var agegroup=getLabel("Common.agegroup.label","common");
	var starttime=getLabel("Common.StartTime.label","common");
	var endtime=getLabel("Common.EndTime.label","common");
	var fields = new Array(formObj.agegrp_code,formObj.start_time,formObj.end_time);
	var names = new Array(agegroup,starttime,endtime);
	var messageFrame = window.parent.parent.messageFrame;
	//alert(messageFrame.name);
	//alert("165");
	return checkFieldsofMst( fields, names, messageFrame)
}


//This Function checks for Time Range For Start & End Times, Time entered should fall within the range given in operating room function
function chkTimeRange(){
	return true;
	/*
	var RecordformObj = document.BlockSlotsBySpecialityRecordForm;
	//var day_status=RecordformObj.day_status.value;
	var start_time=RecordformObj.start_time.value;
	var end_time=RecordformObj.end_time.value;
	var wd_start_time=RecordformObj.wd_start_time.value;
	var wd_end_time=RecordformObj.wd_end_time.value;
	var hd_start_time=RecordformObj.hd_start_time.value;
	var hd_end_time=RecordformObj.hd_end_time.value;
	var err_txt="";
	alert(wd_start_time+" "+wd_end_time);
	if(day_status=="W"){
		if(start_time<wd_start_time || start_time>wd_end_time){
		//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+ wd_start_time  +msgArr[1]+ wd_end_time +msgArr[2];
		}
		if(end_time<wd_start_time || end_time>wd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+wd_start_time+" to "+wd_end_time+" on Working Days";
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+ wd_start_time  +msgArr[1]+ wd_end_time +msgArr[2];
		}
	}else if(day_status=="H"){
		if(start_time<hd_start_time || start_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+ wd_start_time  +msgArr[1]+ wd_end_time +msgArr[2];
		}
		if(end_time<hd_start_time || end_time>hd_end_time){
			//err_txt="Entered Time Should fall within the Booking Range of "+hd_start_time+" to "+hd_end_time+" on Holidays";
			var msg_1 = getMessage("APP-OT0112","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+ wd_start_time  +msgArr[1]+ wd_end_time +msgArr[2];
		}
	}
       if(err_txt.length>0){
		  parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	     	  return false;
		}else return true; 
	*/
}

function addRow(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var formObj = document.BlockSlotsBySpecialityRecordForm;
  var unit_time=formObj.unit_ot_time.value;
  var start_time=formObj.start_time.value;
  var end_time=formObj.end_time.value;
  var mode =formObj.mode.value;
  var recId = rows.length+1;
  if( chkEmpty() && mode=='I' ){
	  // if(buildLookUpTable(start_time,end_time,unit_time)){
	  //var hashfromtotimecheck  = new Hashtable();
		//hashfromtotimecheck=buildLookUpTable(start_time,end_time,unit_time);
		//alert(hashfromtotimecheck);
		//var test=hashfromtotimecheck.keys();//get("start_time");
		//alert(test);
		//hashfromtotimecheck.set(start_time,start_time,'Y');
		//alert(hashfromtotimecheck);
		//if(start_time!=test){
		//hashfromtotimecheck.remove(test);
		//hashfromtotimecheck.put(start_time,'Y');

		//alert(hashfromtotimecheck)
	   var hash  = new Hashtable();
	   hash.put("agegrp_code",formObj.agegrp_code.value);
	   hash.put("agegrp_desc",formObj.agegrp_desc.value);
	   hash.put("gender",formObj.gender.value);
	   hash.put("start_time",formObj.start_time.value);
	   hash.put("end_time",formObj.end_time.value);
	   hash.put("alert_type",formObj.alert_type.value);
	   hash.put("recId",recId);
	   hash.put("mode","I");
	   rows.push(hash);
	   resetFields();
	   refresh();
	//	}
	}else 
		  updateRow();
  }




function updateRow(){
	var formObj = document.forms[0];
	var recId = document.forms[0].recId.value;
	var mode = document.forms[0].mode.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
	if(mode=='U'){        
		var hash = new Hashtable();
		hash= rows[recId-1]
		rows.splice(recId-1,1);
		hash.put("end_time",formObj.end_time.value)
		hash.put("alert_type",formObj.alert_type.value)
		hash.put("mode",'U');
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
	if(hash.get("mode")=='L' || hash.get("mode")=='U' ){
		hash.put("mode","D");
		rows.push(recId-1,hash);
	 }else{
		rows.splice(recId-1,1);
	 }
	 rows = null;
	 resetFields();
	 refresh();
}else
   resetFields();
}


function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.agegrp_code.value=arr[0];
	//alert("arr[0]=="+arr[0]+" "+"arr[1]=="+arr[1]+" "+"arr[2]=="+arr[2]+" "+"arr[3]=="+arr[3]+" "+"arr[4]=="+arr[4]+" "+"arr[5]=="+arr[5]+" "+"arr[6]=="+arr[6]+" "+"arr[7]=="+arr[7]+" "+"arr[8]=="+arr[8]+" "+"arr[9]=="+arr[9]+"arr[10]=="+arr[10]+" "+"arr[11]=="+arr[11]+" "+"arr[12]=="+arr[12]);
	frmObj.agegrp_desc.value=arr[1];
	frmObj.start_time.value=arr[2];
	frmObj.end_time.value=arr[3];
	frmObj.alert_type.value=arr[4];
	frmObj.recId.value=arr[5];
	frmObj.mode.value=arr[6];
	frmObj.gender.value=arr[7];
	//frmObj.gender.disabled=true;
	frmObj.srchagegroup.disabled=true;
	frmObj.start_time.disabled=true;//In update mode speciality_code,Day Code & start_time are not allowed for modification
	
	
}


function resetFields(){
	var frmObj = document.forms[0];
	frmObj.agegrp_code.value="";
	frmObj.agegrp_desc.value="";
	frmObj.gender.value="";
	frmObj.start_time.value="";
	frmObj.end_time.value="";
	frmObj.mode.value='I';
	frmObj.recId.value="";
	//frmObj.gender.disabled=true;
	frmObj.srchagegroup.disabled=false;
	frmObj.start_time.disabled=false;
	
}

function refresh(){
	//alert(window.parent.frames[4].name);
	window.parent.DetailFrame.location.href='../../eOT/jsp/BlockSlotsByAgeGroupDetailForm.jsp?';              //+params;
}

function loadDBRows(str){
	var arr = str.split("@@");
	//ageGroup_code,ageGroup_desc,start_time,end_time,alert_type,recId,mode,gender
	
	var rows=window.parent.parent.frames[1].frames[1].rows;
	var i=0;
	if(arr[6]=='L' && rows.length==0){
	   var objrow = new Hashtable();
	   rows.put("agegroup_code",arr[0]);
	   rows.put("agegroup_desc",arr[1]);
	   rows.put("start_time",arr[2]);
	   rows.put("end_time",arr[3]);
	   rows.put("alert_type",arr[4]);
	   rows.put("recId",arr[5]);
	   rows.put("mode",arr[6]);
	   rows.put(arr[5]+1,objrow);
	}
}

//To check start time and end time at the time of adding a row
function chkTime(){
	alert("inside check time");
	var formObj = document.BlockSlotsBySpecialityRecordForm;
	var frmStartTime=formObj.start_time.value;
	var frmEndTime=formObj.end_time.value;
	var err_txt="";
	if(frmStartTime>=frmEndTime){
		//err_txt="Start Time Cannot Be Greater than End time..........";
		var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msgArr = msg_1.split("#");
		var starttime =getLabel("Common.StartTime.label","Common");
		var endtime =getLabel("Common.EndTime.label","Common");
		err_txt = msgArr[0]+ starttime +msgArr[1]+ endtime +msgArr[2];		
        formObj.start_time.focus();
		formObj.start_time.select();
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
        return false;
	}else return true;
}



//function chkTimeOverlap(){
//   	var formObj = document.forms[0];
//	//var full_String = window.parent.parent.frames[1].frames[4].full_String; //detail frame
//	//var spltyCodeDtl =window.parent.parent.frames[1].frames[4].speciality_code; //detail frame
//	//var dayCodeDtl = window.parent.parent.frames[1].frames[4].day_code;
//	alert(" line 377 "+formObj.name);
//	alert(" line 378 "+window.parent.parent.frames[1].frames[4].name);
//	//var startTimeDtl = window.parent.parent.frames[1].frames[4].start_time;
//	var startTimeDtl = formObj.start_time;
//	alert(startTimeDtl);
//	var startTime_val=startTimeDtl.split(",");
//	var endTimeDtl = formObj.end_time;
//	alert(endTimeDtl);
//	var endTime_val=endTimeDtl.split(",");
//	var agegrp_desc=formObj.agegrp_desc.value;
//	//	var frmDayCode = formObj.day_code.value;
//	var frmStartTime=formObj.start_time.value;
//	var frmEndTime=formObj.end_time.value;
//	alert("linee no 388");
//	var err_txt="";
//	var inner_arr="";
//	var outer_arr=full_String.split("*");
//	var one=outer_arr[0];
//	var two=outer_arr[1];
//	var three=outer_arr[2];
//	var four=outer_arr[3];
//	var five=outer_arr[4];
//	var six=outer_arr[5];
//	for (var i=0;i<outer_arr.length;i++ )
//	{
//	
//       var inner_arr=outer_arr[i].split("#");
//			//if(inner_arr[0]==frmSpeciality_code && inner_arr[1]==frmDayCode && frmStartTime>inner_arr[2] && frmStartTime<inner_arr[3]){
//				if(inner_arr[0]==frmSpeciality_code && frmStartTime>inner_arr[2] && frmStartTime<inner_arr[3]){
//			err_txt="Time Slot Overlaped"// when start time is bet existing start and end time i.e. 1st if Case";
//	        //}else if(inner_arr[0]==frmSpeciality_code && inner_arr[1]==frmDayCode && frmStartTime<inner_arr[2] && (frmEndTime>inner_arr[2] && frmEndTime<inner_arr[3])){
//				}else if(inner_arr[0]==frmSpeciality_code && frmStartTime<inner_arr[2] && (frmEndTime>inner_arr[2] && frmEndTime<inner_arr[3])){
//			err_txt="Time Slot Overlaped";// when start time is less than existing start time and end time is less than or equal to existing end time i.e. 2nd if  Case";
//	        //}else if (inner_arr[0]==frmSpeciality_code && inner_arr[1]==frmDayCode && frmStartTime<inner_arr[2] && frmEndTime>inner_arr[3]){
//				}else if (inner_arr[0]==frmSpeciality_code && frmStartTime<inner_arr[2] && frmEndTime>inner_arr[3]){
//            err_txt="Time Slot Overlaped";// when start time is less than existing start time and end time is >= existing end time i.e.  third if Case";
//		   }else continue;
//
//		}
//	          if(err_txt.length>0){
//	                 parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
//	     	         return false;
//			         }else return true;
//}


function  buildLookUpTable(from_time,to_time,unit_time){
	var hash=window.parent.parent.frames[1].frames[1].lookUpTable;
	var frm = from_time.split(":");
	var to = to_time.split(":");
	var slots = (to[0]*60+to[1] - frm[0]*60+frm[1])/unit_time;
	var date = new Date();
	date.setUTCHours(frm[0],frm[1]*60);
	var hrs_min =  getUTCHours()+":"+getUTCMinutes();
	hash.put(hrs_min,"N");
	for(var j=0;j<slots-1;j++){
		date.setUTCHours(frm[0],frm[1]+unit_time*60);
		hash.put(getHours(from_time+unit_time),"N");
	}
	alert(hash.toString());
	return hash;
}

function chkTimeOverlap(){
var formObj = document.forms[0];
var start_time=formObj.start_time.value;
var end_time=formObj.start_time.value;
var agegrp_desc=formObj.agegrp_desc.value;
var objrow = new Hashtable();

//var arr = str.split("@@");
	var hash=window.parent.parent.frames[1].frames[1].lookUpTable;
//	if(arr[2]=='L' && rows.length==0){
	   var objrow = new Hashtable();
	   rows.put("agegroup_desc",agegrp_desc);
	   rows.put("start_time",start_time);
	   rows.put("end_time",end_time);
	   rows.put(arr[2]+1,objrow);
//	}


}



function TimeCheck(st_date,end_date){
    var formObj=document.forms[0];
    var ot_unit_time=formObj.unit_ot_time.value; 
	if(timeValidity(end_date.value)==true){
		var st_date_val=st_date.value;
		var end_date_val=end_date.value;
		var start_date_arr = st_date_val.split(':');
		var end_date_arr = end_date_val.split(':');
        var	dt_date_start = new Date();
		var	dt_date_end = new Date();

			dt_date_start.setHours(start_date_arr[0]);
			dt_date_start.setMinutes(start_date_arr[1]);
		    dt_date_end.setHours(end_date_arr[0]);
		    dt_date_end.setMinutes(end_date_arr[1]);
			//alert("dt_date_start=="+dt_date_start);
			//alert("dt_date_end=="+dt_date_end);
			var result=chkUnitTime(ot_unit_time,st_date_val,end_date_val);
            //var result2=chkUnitTime(ot_unit_time,end_date_val);
			if(result!==0 || dt_date_end <= dt_date_start){
			    if(result!==0){
				  alert("Entered Time should be a multiple of OT Unit Time "+ot_unit_time);
				  st_date.focus();
				  return false;
			   }
			   if (dt_date_end <= dt_date_start){
				  alert("End Time Should be > Start Time");
			      end_date.focus();
                  return false;
			   }
			}else return true;
			
	}
	else 
     end_date.focus();
}


function timeValidity(str_time) {
	var dt_date = new Date();
	var arr_time = String(str_time ? str_time : '').split(':');
	if (!arr_time[0]) dt_date.setHours(0);
	else if (RE_NUM.exec(arr_time[0]))
		if (arr_time[0] < 24) {
			dt_date.setHours(arr_time[0]);
		}else{
			var msg_1 = getMessage("APP-OT0040","OT");
			var msgArr = msg_1.split("#");
			var err_txt = msgArr[0] + arr_time[0];
			//else return cal_error ("Invalid hours value: '" + arr_time[0] + "'.\nAllowed range is 00-23.");
			return cal_error (err_txt);
		}else{
			var msg_2 = getMessage("APP-OT0040","OT");
			var msgArr2 = msg_2.split("#");
			var err_txt2 = msgArr2[0] + arr_time[0];
			return cal_error (err_txt2);
		}
	//else return cal_error ("Invalid hours value: '" + arr_time[0] + "'.\nAllowed format is HH24:MM");
		
	if (!arr_time[1]) dt_date.setMinutes(0);
		else if (RE_NUM.exec(arr_time[1]))
		if (arr_time[1] < 60) {
			dt_date.setMinutes(arr_time[1]);
		}else{
			var msg_1 = getMessage("APP-OT0041","OT");
			var msgArr = msg_1.split("#");
			var err_txt = msgArr[0] + arr_time[1];
			//		else return cal_error ("Invalid minutes value: '" + arr_time[1] + "'.\nAllowed range is 00-59.");		
			return cal_error (err_txt);
		}else{
			var msg_2 = getMessage("APP-OT0040","OT");
			var msgArr2 = msg_2.split("#");
			var err_txt2 = msgArr2[0] + arr_time[1];
			return cal_error (err_txt2);
		}
//	else return cal_error ("Invalid minutes value: '" + arr_time[1] + "'.\nAllowed format is HH24:MM");
		
	return true;
}


function cal_error (str_message) {
	alert (str_message);
	return false;
}
//This function converts given time to minutes
function convertTimeToMinutes(obj){
	var ot_unit_time_val=obj.split(":");
	var time_in_min=""; 
	time_in_min=parseInt((ot_unit_time_val[0]*60)+parseInt(ot_unit_time_val[1]));
	return time_in_min;
}
//This Function checks whether the given time is multiple of Unit Time or not
function chkUnitTime(obj_unit_time,obj_start_time,obj_end_time){
	var unit_time=convertTimeToMinutes(obj_unit_time);
	var chk_start_time=convertTimeToMinutes(obj_start_time);
	var chk_end_time=convertTimeToMinutes(obj_end_time);
	var result=(parseInt(chk_end_time)-parseInt(chk_start_time))%(parseInt(unit_time));
	return result;
}


function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index+1];
	var hash = new Hashtable();	
	hash = rows;
	var str = hash.get("agegrp_code")+"::"+hash.get("agegrp_desc")+"::"+hash.get("start_time")+"::"+hash.get("end_time")+"::"+hash.get("alert_type")+"::"+hash.get("recId")+"::U::"+hash.get("gender");
	alert(str);
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);
}

function createXMLForAgeGroup(){
  var formObj=window.parent.frames[1].frames[1].frames[0].document.forms[0];
  var oper_room_code=formObj.oper_room_code.value;
  var rows=parent.master_pages.f_query_add_mod.hidden_frame.rows;
  var table_name = "OT_OPER_ROOM_PREF";
  var xmlString ="";
  for(var key in rows){
	   var hash = new Hashtable();
	   hash = rows[key];
	   if(hash.get("mode")!='L' ){
			xmlString+="<BLOCK_SLOTS_BY_AGE_GROUP"+key+" ";
			xmlString+="operating_facility_id=\""+formObj.facility_id.value+"\""+" ";
			xmlString+="oper_room_code=\""+oper_room_code+"\""+" ";
			xmlString+="agegrp_code=\""+hash.get("agegrp_code") +"\""+" ";
			xmlString+="start_time=\""+hash.get("start_time")+"\""+" ";
			xmlString+="end_time=\""+hash.get("end_time") +"\""+" ";
			xmlString+="alert_type=\""+hash.get("alert_type")+"\""+" ";
			xmlString+="mode=\""+hash.get("mode")+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";
			hash=null;
		}//if condition
	 }//for loop
    return xmlString;
}



