/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){}

function query(){}

function apply(){}

/*function reset() {

	 if(f_query_add_mod.document.location.href.indexOf("BlockTheatreCanvas.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}*/


function reset(){
f_query_add_mod.document.forms[0].theatre_code.value="";
f_query_add_mod.document.forms[0].oper_room_code.value="";
f_query_add_mod.document.location.reload();
}
function blockbyday() {
	
	var frmObj = document.forms[0];
	if(frmObj.block_by_day.checked==true)
		frmObj.block_by_day.value="Y";
	else
		frmObj.block_by_day.value="N";
	if (frmObj.blocksetflag.value=="true")
	{
	frmObj.blocksetflag.value="false";
	frmObj.all.disabled=false;
	frmObj.week_1.disabled=false;
	frmObj.week_2.disabled=false;
	frmObj.week_3.disabled=false;
	frmObj.week_4.disabled=false;
	frmObj.week_5.disabled=false;
	frmObj.day_code.disabled=false;
    frmObj.imageflag.src="../../eCommon/images/mandatory.gif";
	}
	else {
	frmObj.blocksetflag.value="true";
	frmObj.all.disabled=true;
	frmObj.all.checked=false;
	frmObj.week_1.disabled=true;
	frmObj.week_1.checked=false;
	frmObj.week_2.disabled=true;
	frmObj.week_2.checked=false;
	frmObj.week_3.disabled=true;
	frmObj.week_3.checked=false;
	frmObj.week_4.disabled=true;
	frmObj.week_4.checked=false;
	frmObj.week_5.disabled=true;
	frmObj.week_5.checked=false;
	frmObj.day_code.value='';
	frmObj.day_code.disabled=true;
	frmObj.imageflag.src="../../eCommon/images/Blank1.gif";
	
	}

}


function selectall() {
	var frmObj = document.forms[0];
	if (frmObj.blocksetflagcheck.value=="true")
	{
	frmObj.blocksetflagcheck.value="false";
	frmObj.week_1.checked=true;
	frmObj.week_2.checked=true;
	frmObj.week_3.checked=true;
	frmObj.week_4.checked=true;
	frmObj.week_5.checked=true;
	}
	else {
	frmObj.blocksetflagcheck.value="true";
	frmObj.week_1.checked=false;
	frmObj.week_2.checked=false;
	frmObj.week_3.checked=false;
	frmObj.week_4.checked=false;
	frmObj.week_5.checked=false;
	}
}

function blocktheatre(){
	var frm=window.parent.frames[1];
	var frmObj = document.forms[0];
	var messageFrame = parent.frames[2];
	var currDate=frmObj.from_date.value;
	var locale = frmObj.locale.value;
	var format = currentDate();
	var theatre_code=frmObj.theatre_code;
	var block_reason=frmObj.block_reason;
	var from_date=frmObj.from_date;
	var to_date=frmObj.to_date;
	var from_time=frmObj.from_time;
	var to_time=frmObj.to_time;
	var frmStartTime=frmObj.from_time.value;
	var frmEndTime=frmObj.to_time.value;
	var theatre_code_title= getLabel("Common.Theatre.label","Common");
	var block_reason_title= getLabel("eOA.BlockReason.label","OA") ;
	var from_date_title= getLabel("Common.fromdate.label","Common") ;
	var to_date_title= getLabel("Common.todate.label","Common") ;
	var from_time_title= getLabel("Common.fromtime.label","Common");
	var to_time_title= getLabel("Common.totime.label","Common");
	var fields = new Array (theatre_code,block_reason,from_date,to_date,from_time,to_time);
	var names = new Array(theatre_code_title,block_reason_title,from_date_title,to_date_title,from_time_title,to_time_title);
		if(checkFieldsofMst( fields, names, messageFrame)){ 
		} else{
			return false;
		}
	var frm_date_time=frmObj.from_date.value+" "+frmObj.from_time.value;
	var to_date_time=frmObj.to_date.value+" "+frmObj.to_time.value;
	if(validateDateTime(frm_date_time,to_date_time,'F')=="N"){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var date = getLabel("Common.fromdatetime.label","common");
		var current_date = getLabel("Common.CurrentDateTime.label","common");
		var errmsg=msgArray[0]+date+msgArray[1]+current_date+msgArray[2];
		messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errmsg;
		frmObj.from_date.focus();
		return false;
	}  
	if(validateDateTime(frm_date_time,to_date_time,'T')=="N"){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var date = getLabel("Common.fromdatetime.label","common");
		//var current_date = getLabel("Common.CurrentDateTime.label","common");
		var to_date=getLabel("Common.ToDateTime.label","common");
		var errmsg=msgArray[0]+to_date+msgArray[1]+date+msgArray[2];
		messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errmsg;
		frmObj.from_date.focus();
		return false;
	}  
	if(frmEndTime!=""){
		if(frmStartTime>frmEndTime){
			//err_txt="Start Time Cannot Be Greater than End time..........";
			err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
			frmObj.from_time.focus();
			frmObj.from_time.select();
			alert(err_txt);
			return false;
		}
	}else{
	alert("To Time Cannot Be Blank...")
	return;
	}
		

	
	//checkbox validation
	var checked =frmObj.block_by_day.value;
	if(checked=="Y"){
		var all	   = (frmObj.all.checked==true)?"Y":"N";
		var week_1 = (frmObj.week_1.checked==true)?"Y":"N";
		var week_2 = (frmObj.week_2.checked==true)?"Y":"N";
		var week_3 = (frmObj.week_3.checked==true)?"Y":"N";
		var week_4 = (frmObj.week_4.checked==true)?"Y":"N";
		var week_5 = (frmObj.week_5.checked==true)?"Y":"N";
		var error_message = "";
		if( (all=="N") && (week_1== "N") && (week_2 == "N") && (week_3 == "N") && (week_4 == "N") && (week_5 == "N")){
				//'Atleast one week should be selected'				
			    error_message = getMessage("APP-OT0105","OT");
				error_message = error_message + "<BR>";
		}		
		if(frmObj.day_code.value==""){
			var blank_msg=getMessage("CANNOT_BE_BLANK","OT");
			var msgArry=blank_msg.split("&");
			var day_label=getLabel("Common.day.label","Common");
			error_message = error_message + msgArry[0]+ day_label + msgArry[1];
		}
		if(error_message.length>1){
			messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error_message;
			return false;
		}
	}

	//check time validation
	if(validateTimings()){
	//ChkDate(frmObj.to_date);
	if( checkdate(frmObj.from_date.value)=="Y"  && checkdate(frmObj.to_date.value)=="Y" ){
		var from_date_time = frmObj.from_date.value+" "+frmObj.from_time.value;
		var to_date_time = frmObj.to_date.value+" "+frmObj.to_time.value;
		if(compareDateTimes(to_date_time,from_date_time)!="N"){
			//if (frmObj.from_date.value!="" && frmObj.W_code.value !=""  && frmObj.to_date.value!="" )
			//	{
					var all	   = (frmObj.all.checked==true)?"Y":"N";
					var week_1 = (frmObj.week_1.checked==true)?"Y":"N";
					var week_2 = (frmObj.week_2.checked==true)?"Y":"N";
					var week_3 = (frmObj.week_3.checked==true)?"Y":"N";
					var week_4 = (frmObj.week_4.checked==true)?"Y":"N";
					var week_5 = (frmObj.week_5.checked==true)?"Y":"N";

					var locale = frmObj.locale.value;
					var change_from_date = dateUtils(frmObj.from_date.value,locale); 
					var change_to_date = dateUtils(frmObj.to_date.value,locale);
					//	var params = "theatre_code="+frmObj.theatre_code.value+"&block_reason="+frmObj.block_reason.value+"&all="+all+"&week1="+week_1+"&week2="+week_2+"&week3="+week_3+"&week4="+week_4+"&week5="+week_5+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&from_time="+frmObj.from_time.value+"&to_time="+frmObj.to_time.value+"&block_by_day="+frmObj.block_by_day.value+"&day_code="+frmObj.day_code.value ;
					var params = "theatre_code="+frmObj.theatre_code.value+"&block_reason="+encodeURIComponent(frmObj.block_reason.value,"UTF-8")+"&all="+all+"&week1="+week_1+"&week2="+week_2+"&week3="+week_3+"&week4="+week_4+"&week5="+week_5+"&from_date="+change_from_date+"&to_date="+change_to_date+"&from_time="+frmObj.from_time.value+"&to_time="+frmObj.to_time.value+"&block_by_day="+frmObj.block_by_day.value+"&day_code="+frmObj.day_code.value ;
					var action="../../servlet/eOT.BlockTheatreSlotsServlet?"+params;
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					var xmlStr="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",action,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					//msg=(retVal=="RECORD_INSERTED")? "Operation Completed Successfully...":"Operation Failed : "+retVal;
					var msg_inserted =  getMessage("RECORD_INSERTED","SM");
					var msg_failed =  getMessage("APP-OT0082","OT");
					//msg=(retVal=="RECORD_INSERTED")?msg_inserted :(msg_failed+retVal);
					if(retVal=="RECORD_INSERTED"){
						msg = getMessage("RECORD_INSERTED","SM");
					}else{
						if(retVal=="PRC-OT0046"){
							var msg_1 = getMessage(retVal,"OT");							
							var msgArray = msg_1.split("#");
							msg = msgArray[0]+ " "+change_from_date + msgArray[1];
						}else
							msg = getMessage(retVal,"OT");
					}
					//alert(msg);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
					if (retVal=="RECORD_INSERTED")
					{
						//frm.location.reload();//commented by  parul on 6/18/2009 for IN09789
						document.location.href = '../../eOT/jsp/BlockTheatreCanvas.jsp';	
						
					}
					/*frmObj.method = 'POST';
					frmObj.action="../../servlet/eOT.BlockTheatreSlotsServlet";
					frmObj.submit();	
					frm.location.reload();*/
			//	}
			}
		}//time validation
	}
}


function currentDate(){
var sql="SELECT TO_CHAR(SYSDATE,'mm/dd/yyyy')  FROM dual";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}

function compareDateTimes(to_date,from_date){
	//alert(from_date);
	//alert(to_date);
	var sql="select decode( SIGN ( to_date('"+to_date+"','DD/MM/YYYY HH24:MI') - to_date('"+from_date+"','DD/MM/YYYY HH24:MI') ),1,'Y','N') FROM DUAL";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert(retVal);
	return retVal;
}



//From Date should be Greater than Sysdate
//To Date should be Greater than Sysdate and From Date
function validateDateTime(frm_date_time,to_date_time,flg){
	//flag 'F' - From Time 
	//flag 'T' - To time
	switch(flg){
				case 'F' : //From Time > Sysdate Time

		var SQL = "select DECODE( SIGN (TO_DATE('"+frm_date_time+"','DD/MM/YYYY HH24:MI')  - SYSDATE ) ,1,'Y','N') FROM DUAL";
		break;
		case 'T' : //To Time > Sysdate Time

		var SQL = "select DECODE(SIGN(TO_DATE('"+frm_date_time+"','DD/MM/YYYY HH24:MI')  - SYSDATE) ,1, Decode(SIGN(TO_DATE('"+to_date_time+"','DD/MM/YYYY HH24:MI') - TO_DATE('"+frm_date_time+"','DD/MM/YYYY HH24:MI')),1,'Y','N'), 'N') FROM DUAL" ;
		break;
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="flag=MED_SER&sql="+SQL;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;


}



function compareDates(to_date,from_date){
	//alert(from_date);
	//alert(to_date);
	var sql="select decode( SIGN ( to_date('"+to_date+"','DD/MM/YYYY') - to_date('"+from_date+"','DD/MM/YYYY') ),1,'Y','N') FROM DUAL";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}



function checkdate(pref_date){
	var sql="select decode(SIGN(to_date('"+pref_date+"','DD/MM/YYYY')-TRUNC(SYSDATE)),-1,'N','Y') FROM DUAL";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert("RETVAL"+retVal);
	return retVal;
}

function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function assignDayofWeek(obj){
	if(obj.checked==true) {
		obj.value = "Y";
	} else {
		obj.value="N";
	}
}

function checkMaxLimit1(obj,maxSize) 
 {
  var len  = obj.value;
     if ( len.length > maxSize ){   
		var msg = getMessage("APP-OT0114","OT");
		var msgArray = msg.split("#");
		var lbl_text = getLabel("Common.reason.label","Common");
		alert(msgArray[0]+lbl_text+msgArray[1]+" "+maxSize+" "+msgArray[2]); 
    	var revertField = obj.value.slice(0, maxSize);
		obj.value=revertField;
		event.returnValue = false;
        obj.focus();
      } 
 } 

function checkFromTimeFormat(obj){
	var formObj =document.forms[0];
	var time1=formObj.from_time.value;
	var obj=formObj.from_time;
	if(time1!=null && time1!=""){
		var time_arr=time1.split(":");
		if(time_arr[0].length!=2 || time_arr[1].length!=2){
		alert("Invalid Time Format...");
		obj.focus();
		return;
		}
		if (time1.value != undefined){
			time1 = time1.value;
		}else{
			time1=time1;
		}
		time1=trimString(time1); 
		var retval=true;
		var strCheck = ':0123456789';
		for(var i=0;i<=time1.length;i++) {
			if (strCheck.indexOf(time1.charAt(i)) == -1){
			   retval = false;
			   break;
			}
		}
		if (retval){
		  if( (time1.charAt(time1.length-1) )!=":"){
			var time1arr=new Array()
			time1arr=time1.split(":")

			if(time1arr.length==2)
			{
				var time1hr=time1arr[0]
				var time1min=time1arr[1]

				time1hr=eval(time1hr)
				time1min=eval(time1min)
				if(time1hr<=23)
				{
					if(time1min>59)
					{
							retval=false;
							//alert("Invalid Time")
					}
				}
				else
						retval=false;
						//alert("Invalid Time")
			}
			else
				retval=false;
				//alert("Invalid Time")
			}
			else
				retval=false;
				//alert("Invalid Time")
			}
			if(retval==false){
				alert(getMessage("VALID_TIME_SLOTS","OT"));
				obj.select();
				return;
			}else{
				retVal=chkTime_local(obj);
				if(retVal==false){
					alert(getMessage("VALID_TIME_SLOTS","OT"));
					obj.select();
					return;
				}
			}
	}
	
}

function checkToTimeFormat(obj){
	var formObj =document.forms[0];
	var time1=formObj.to_time.value;
	var obj=formObj.to_time;
	if(time1!=null && time1!=""){
		var time_arr=time1.split(":");
		if(time_arr[0].length!=2 ||time_arr[1].length!=2 ){
		alert("Invalid Time Format...");
		obj.focus();
		return;
		}
		if (time1.value != undefined){
			time1 = time1.value;
		}else{
			time1=time1;
		}
		time1=trimString(time1); 
		var retval=true;
		var strCheck = ':0123456789';
		for(var i=0;i<=time1.length;i++) {
			if (strCheck.indexOf(time1.charAt(i)) == -1){
			   retval = false;
			   break;
			}
		}
		if (retval){
		  if( (time1.charAt(time1.length-1) )!=":"){
			var time1arr=new Array()
			time1arr=time1.split(":")

			if(time1arr.length==2){
				var time1hr=time1arr[0]
				var time1min=time1arr[1]

				time1hr=eval(time1hr)
				time1min=eval(time1min)
				if(time1hr<=23){
					if(time1min>59){
							retval=false;
					}
				}else
					retval=false;
			}else
				retval=false;
			}else
				retval=false;
			}
			if(retval==false){
				alert(getMessage("VALID_TIME_SLOTS","OT"));
				obj.select();
				return;
			}else{
				retVal=chkTime_local(obj);
				if(retVal==false){
					alert(getMessage("VALID_TIME_SLOTS","OT"));
					obj.select();
					return;
				}
			}
	}
	
}


function chkTime_local(strfromTime){
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	if(strfromTime.value.length !=5){
		return false;
	}
	if(hr>23){
		return false;
	}
	if(min>59){
		return false;
	}
	return true;
}
function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			//alert("Invalid Date Format");
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
		}
	}
}



//Time Validation for from and to time

function validateTimings(){
	if(!chkFromTimeRange()) return false;
	if(!chkToTimeRange()) return false;
	if(!chkUnitTime()) return false;
	//if(!chkTimeRange()) return false;
	return true;
}

//This function converts given time to minutes
function convertTimeToMinutes(obj){
	var ot_unit_time_val=obj.split(":");
	var time_in_min=""; 
	time_in_min=parseInt((ot_unit_time_val[0]*60)+parseInt(ot_unit_time_val[1]));
	return time_in_min;
}

function chkUnitTime(){
	var formObj =document.forms[0];
	var obj_unit_time=formObj.unit_ot_time_DB.value;
	var obj_start_time=formObj.from_time.value;
	var obj_end_time=formObj.to_time.value;
	var unit_time=convertTimeToMinutes(obj_unit_time);
	var chk_start_time=convertTimeToMinutes(obj_start_time);
	var chk_end_time=convertTimeToMinutes(obj_end_time);
	var result=(parseInt(chk_end_time)-parseInt(chk_start_time))%(parseInt(unit_time));
	var flag=(result==0)?true:false;
	if(!flag){
		var msg_1 =  getMessage("APP-OT0110","OT")+" ("+obj_unit_time+")";
		alert(msg_1)
		// parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg_1;
		return false;
	}
	return true; 
}


function chkFromTimeRange(obj){
		var formObj = document.forms[0];
		var start_time = formObj.from_time.value;
		if(start_time!=""){
		var end_time = formObj.to_time.value;
		var wd_start_time = formObj.wd_start_time.value;
		var wd_end_time = formObj.wd_end_time.value;
		var msg="";
		var err_txt="";
		var alert_wstart_time = formObj.wd_start_time.value;
		var alert_wend_time = formObj.wd_end_time.value;
		if(!checkFromTimeFormat(obj)){
			if(start_time<wd_start_time||start_time>wd_end_time){
				var msg_1 = getMessage("APP-OT0111","OT");
				var msgArr = msg_1.split("#");
				err_txt=msgArr[0]+alert_wstart_time+msgArr[1]+ alert_wend_time+msgArr[2];
		}
			
		}//checkTimeFormat()
		if(err_txt.length>0)parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return (err_txt.length>0)?false:true
	}
}

function chkToTimeRange(){
	var formObj = document.forms[0];
	var start_time = formObj.from_time.value;
	var end_time = formObj.to_time.value;
	var wd_start_time = formObj.wd_start_time.value;
	var wd_end_time = formObj.wd_end_time.value;
	var msg="";
	var err_txt="";
	var alert_wstart_time = formObj.wd_start_time.value;
	var alert_wend_time = formObj.wd_end_time.value;
if (end_time!=""){
		if(end_time<wd_start_time || end_time>wd_end_time){
			var msg_1 = getMessage("APP-OT0111","OT");
			var msgArr = msg_1.split("#");
			err_txt=msgArr[0]+alert_wstart_time+msgArr[1]+ alert_wend_time+msgArr[2];
		}
}
	if(err_txt.length>0)parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	return (err_txt.length>0)?false:true
}

function chkToTime(obj){
	if(chkToTimeRange()){
			var formObj = document.forms[0];
			var frmStartTime=formObj.from_time.value;
			var frmEndTime=formObj.to_time.value;
	if(frmEndTime!=""){
			var err_txt="";
			if(!checkToTimeFormat(obj)){
				if(frmEndTime!=""){
					if(frmStartTime>frmEndTime){
						err_txt=getMessage("ST_TIME_GREATER_ED_TIME","OA");
						formObj.from_time.focus();
						formObj.from_time.select();
						alert(err_txt);
						return false;
					}else return true;
				}else{
				alert("To Time Cannot Be Blank...")
				return;
				}
			}
		}//chkUnitTime
	}
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkForSpecCharsforIDTime(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
//added by  parul on 6/18/2009 for IN09789
function populateTheartre(){
		var formObj = document.forms[0];
        var oper_room_code = formObj.theatre_code.value;
		var facilityid=formObj.facility_id.value;

		var sql=escape("SELECT TO_CHAR(WD_START_TIME, 'HH24:MI') WD_START_TIME, TO_CHAR(WD_END_TIME, 'HH24:MI') WD_END_TIME FROM OT_OPER_ROOM WHERE  OPERATING_FACILITY_ID ='"+facilityid+"' AND OPER_ROOM_CODE ='"+oper_room_code+"'");
		var param = "oper_room_code="+oper_room_code+"&"+"sql_1="+sql;
		document.location.href = '../../eOT/jsp/BlockTheatreCanvas.jsp?'+param;	

}
