/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function disablereset()
{  
	var frmObj=document.forms[0];
	var booking_num=frmObj.bkng_no.value;
	if(booking_num==""){

		if(parent.parent.parent.commontoolbarFrame!=null && typeof parent.parent.parent.commontoolbarFrame.value != 'undefined')
			{
					parent.parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
			}
		}
	/*else{
		parent.parent.frames[0].document.forms[0].reset.disabled=true;
      }*/
}

function onloadAssignDay(){	
	var date=document.forms[0].sch_date.value;
	var locale=document.forms[0].locale.value;
	date=convertDate(date,"DMY",locale,"en");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "date="+date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=assignDate&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	document.forms[0].day.value=retVal;
}

function checkDate(){
	var curr_date=getCurrentDate('DMY', locale);
	var date=document.forms[0].sch_date.value;
	var locale=document.forms[0].locale.value;
	var flag=isAfter(date,curr_date,'DMY',locale);
	if(flag==false){
		var msg=getMessage("APP-OT0157","OT");
		var msg_split=msg.split("#");
		var msg_split1=msg_split[1].split("$");
		var sch_date_label=getLabel("Common.ScheduleDate.label","Common");
		var cur_date_label=getLabel("Common.CurrentDate.label","Common");
		alert(msg_split[0]+sch_date_label+msg_split1[0]+cur_date_label)
		document.forms[0].sch_date.select();	
		document.forms[0].sch_date.focus();	
		return false;
	}else 
		return true
}


function assignDay(){
		var date=document.forms[0].sch_date.value;
		var locale=document.forms[0].locale.value;
		date=convertDate(date,"DMY",locale,"en");
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "date="+date;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=assignDate&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal==null ||retVal=="null" ||retVal=="" )
		{
			document.forms[0].day.value="";
		}else{
			document.forms[0].day.value=retVal;
		}
}



function assignDayFromParent(dateVal,dayInput){
		var date= dateVal;
		var locale=document.querySelector('#dateFilter0').contentWindow.document.querySelector('#locale').value;
		date=convertDate(date,"DMY",locale,"en");
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "date="+date;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=assignDate&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal==null ||retVal=="null" ||retVal=="" )
		{
			dayInput.value="";
		}else{
			dayInput.value=retVal;
		}
}

function isValidDateLocal(obj){
	if(obj.value!=""){
		assignDay();
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}


function validateElectiveCutOffTime(boDate){
	var formObj = document.forms[0];
	var order_id = formObj.Horderid.value;
	var locale = formObj.locale.value;
	var booking_num = formObj.bkng_no.value;
	var facility_id = formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	boDate=convertDate(boDate,"DMY",locale,"en");
	var params = "order_id="+order_id+"&queried_pref_surg_date="+boDate+"&facility_id="+facility_id+"&booking_num="+booking_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=validateElectiveCutOffTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;

}

function loadSchedulePage()
{
	var obj=document.forms[0];
	var chkSize = obj.chkSize.value;
	var locale;
	var over_book_YN;
	var no_of_slots;
	var rem_slots_ovr_bk_yn;
	var over_bk_strt_time;
	var speciality_code;
	var	speciality_desc;
	var called_from;
	var bkng_no;
	var bkng_date;
	var function_id;
	var Horderid;
	var speciality_code;
	var	speciality_desc;
	var roomCode;
	var roomDesc;
	var surgeonCode;
	var selSurgeonCode;// 051825
	var surgeonName;
	var procedure;
	var full_vacant;
	var function_id;
	var orderid;
	var selOrderIds;//186
	var flag;
	var retVal;
	var authFlag;//186


	if(chkSize == '' || chkSize == '1')
	{
		locale = obj.locale.value;
		over_book_YN = checkOverBookAlowed();
		no_of_slots = checkSlotsGenerated();
		rem_slots_ovr_bk_yn = checkOverBookingSlotsYN();
		over_bk_strt_time = checkOverBookStartTime();
		called_from = obj.Hcalled_from.value;
		bkng_no = obj.bkng_no.value;
		bkng_date = obj.sch_date.value;
		bkng_date = convertDate(bkng_date,"DMY",locale,"en");
		function_id = obj.Hfunction_id.value;
		Horderid = obj.Horderid.value;
		speciality_code = '';
		speciality_desc = '';
		roomCode = obj.HroomCode.value;
		roomDesc = obj.HroomDesc.value;
		surgeonCode = obj.HsurgeonCode.value;
		selSurgeonCode = obj.selSurgeonCode.value; // 051825
		surgeonName = obj.HsurgeonDesc.value;
		procedure = obj.Hprocedure.value;
		full_vacant = obj.Hfull_vacant.value;
		orderid = obj.Horderid.value;
		//186
		selOrderIds = obj.selOrderIds.value;
		//authFlag = obj.authFlag.value; // commented by selvin for script error issue	
		//186
		

		if(obj.sch_date.value == "")
		{
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msg_split = msg.split("&");
			var label = getLabel("Common.ScheduleDate.label","Common");
			alert(msg_split[0]+label+msg_split[1]);
		}
		else
		{
			var curr_date = getCurrentDate('DMY', locale);
			var date = document.forms[0].sch_date.value;
			locale = document.forms[0].locale.value;
			flag = isAfter(date,curr_date,'DMY',locale);
			if(flag == false)
			{
				var msg = getMessage("APP-OT0157","OT");
				var msg_split = msg.split("#");
				var msg_split1 = msg_split[1].split("$");
				var sch_date_label = getLabel("Common.ScheduleDate.label","Common");
				var cur_date_label = getLabel("Common.CurrentDate.label","Common");
				alert(msg_split[0]+sch_date_label+msg_split1[0]+cur_date_label);
				document.forms[0].sch_date.select();	
				return false;
			}
			if(no_of_slots == 0)
			{
				alert(getMessage("APP-OT0194","OT"));
				document.forms[0].sch_date.select();
				if(chkSize == '')
					dummy(speciality_code,speciality_desc,surgeonCode,surgeonName,roomCode,roomDesc,bkng_date,full_vacant,called_from,over_bk_strt_time,no_of_slots,bkng_no,orderid);
				else if(chkSize == '1')
					dummyFrame(no_of_slots, '', '', chkSize);
				return false;
			}
			else
			{
				var called_from = obj.Hcalled_from.value;
				var bkng_no = obj.bkng_no.value;
				var locale = document.forms[0].locale.value;
				var bkng_date = obj.sch_date.value;
				bkng_date = convertDate(bkng_date,"DMY",locale,"en");
				function_id = obj.Hfunction_id.value;
				Horderid = obj.Horderid.value;
				selOrderIds = obj.selOrderIds.value;//186
				roomCode = obj.HroomCode.value;
				roomDesc = obj.HroomDesc.value;
				surgeonCode = obj.HsurgeonCode.value;
				surgeonName = obj.HsurgeonDesc.value;
				procedure = obj.Hprocedure.value;
				full_vacant = obj.Hfull_vacant.value;
				no_of_slots = checkSlotsGenerated();
				retVal = trimString(validateElectiveCutOffTime(bkng_date));
				if(retVal.length > 1)
				{
					var msg = getMessage("APP-OT0124","OT");
					alert(msg);
				}
				else
				{
					if(obj.Hspeciality_code.value!=null&&obj.Hspeciality_code.value!='')
						speciality_code = obj.Hspeciality_code.value;
					if(obj.HspecialityDesc.value!=null&&obj.HspecialityDesc.value!='')
						speciality_desc = obj.HspecialityDesc.value;

					//Over booking logic hould be call here	
					if(over_book_YN == "Y" && rem_slots_ovr_bk_yn == "0")
					{
						full_vacant = "FULL_OVER_BOOKING_YES";
					}
					var param = "booking_date="+bkng_date+
								"&roomCode="+roomCode+
								"&roomDesc="+roomDesc+
								"&surgeonCode="+surgeonCode+
								"&surgeonName="+encodeURIComponent(surgeonName)+//186
								"&speciality_code="+speciality_code+
								"&speciality_desc="+encodeURIComponent(speciality_desc)+//44531
								"&orderid="+Horderid+
								"&selOrderIds="+selOrderIds+//186
								"&booking_no="+bkng_no+
								"&called_from="+called_from+
								"&procedure="+procedure+
								"&function_id="+function_id+
								"&selSurgeonCode="+selSurgeonCode+// 051825
								"&full_vacant="+full_vacant;
								if(chkSize == '1')
									param += "&chkSize=1";

					if(full_vacant == "VACANT" )
					{
						if(chkSize == '')
						{
							parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdr.jsp?"+param;
							parent.frames[0].changeTab("DaySchedule");
							parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+param;
							parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
						}
						else if(chkSize == '1')
						{
							parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
							parent.parent.frames[0].changeTab("DaySchedule");
							parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
							parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
						}
					}
				}//Slots Check
			}//Else part
		}//Date Null check
	}
	else if(chkSize == '2')
	{
		var param = '';
		var param0 = '';
		var param1 = '';
		var no_of_slots0;
		var no_of_slots1;

		locale = obj.locale.value;
		over_book_YN = checkOverBookAlowed();
		no_of_slots = checkSlotsGeneratedFrame(chkSize);
		if(no_of_slots.indexOf("~") != -1)
		{
			no_of_slots0 = no_of_slots.substring(0, no_of_slots.indexOf("~"));
			no_of_slots1 = no_of_slots.substring(no_of_slots.indexOf("~")+1, no_of_slots.length);
		}
		rem_slots_ovr_bk_yn = checkOverBookingSlotsYN();
		over_bk_strt_time = checkOverBookStartTime();
		called_from = obj.Hcalled_from.value;
		bkng_no = obj.bkng_no.value;
		bkng_date = obj.sch_date.value;
		bkng_date = convertDate(bkng_date,"DMY",locale,"en");
		function_id = obj.Hfunction_id.value;
		Horderid = obj.Horderid.value;
		speciality_code = '';
		speciality_desc = '';
		roomCode = obj.HroomCode.value;
		roomDesc = obj.HroomDesc.value;
		surgeonCode = obj.HsurgeonCode.value;
		surgeonName = obj.HsurgeonDesc.value;
		procedure = obj.Hprocedure.value;
		full_vacant = obj.Hfull_vacant.value;
		orderid = obj.Horderid.value;
		selOrderIds = obj.selOrderIds.value;//186

		if(obj.sch_date.value == "")
		{
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msg_split = msg.split("&");
			var label = getLabel("Common.ScheduleDate.label","Common");
			alert(msg_split[0]+label+msg_split[1]);
		}
		else
		{
			var curr_date = getCurrentDate('DMY', locale);
			var date = document.forms[0].sch_date.value;
			locale = document.forms[0].locale.value;
			flag = isAfter(date,curr_date,'DMY',locale);
			if(flag == false)
			{
				var msg = getMessage("APP-OT0157","OT");
				var msg_split = msg.split("#");
				var msg_split1 = msg_split[1].split("$");
				var sch_date_label = getLabel("Common.ScheduleDate.label","Common");
				var cur_date_label = getLabel("Common.CurrentDate.label","Common");
				alert(msg_split[0]+sch_date_label+msg_split1[0]+cur_date_label);
				document.forms[0].sch_date.select();
				//dummyFrame(no_of_slots0, no_of_slots1, '', chkSize);
				return false;
			}
			if(no_of_slots != '')
			{
				if(no_of_slots0 == 0)
				{
					alert(getMessage("APP-OT0194","OT"));
					parent.frames[0].document.forms[0].sch_date.select();
					dummyFrame(no_of_slots0, no_of_slots1, '', chkSize);
				}
				if(no_of_slots1 == 0)
				{
					alert(getMessage("APP-OT0194","OT"));
					parent.frames[1].document.forms[0].sch_date.select();
					dummyFrame(no_of_slots0, no_of_slots1, '', chkSize);
				}
			}

			var called_from = obj.Hcalled_from.value;
			var bkng_no = obj.bkng_no.value;
			var locale = document.forms[0].locale.value;
			var bkng_date = obj.sch_date.value;
			bkng_date = convertDate(bkng_date,"DMY",locale,"en");
			function_id = obj.Hfunction_id.value;
			Horderid = obj.Horderid.value;
			roomCode = obj.HroomCode.value;
			roomDesc = obj.HroomDesc.value;
			surgeonCode = obj.HsurgeonCode.value;
			surgeonName = obj.HsurgeonDesc.value;
			procedure = obj.Hprocedure.value;
			full_vacant = obj.Hfull_vacant.value;
			no_of_slots = checkSlotsGenerated();		
			retVal = trimString(validateElectiveCutOffTime(bkng_date));
			if(retVal.length > 1)
			{
				var msg = getMessage("APP-OT0124","OT");
				alert(msg);
			}
			else
			{
				var speciality_code0 = '';
				var speciality_desc0 = '';
				var speciality_code1 = '';
				var speciality_desc1 = '';

				if(parent.frames[0].document.forms[0].Hspeciality_code != null && parent.frames[0].document.forms[0].Hspeciality_code.value != '')
					speciality_code0 = parent.frames[0].document.forms[0].Hspeciality_code.value;
				if(parent.frames[0].document.forms[0].HspecialityDesc != null && parent.frames[0].document.forms[0].HspecialityDesc.value != '')
					speciality_desc0 = parent.frames[0].document.forms[0].HspecialityDesc.value;
				if(parent.frames[1].document.forms[0].Hspeciality_code != null && parent.frames[1].document.forms[0].Hspeciality_code.value != '')
					speciality_code1 = parent.frames[1].document.forms[0].Hspeciality_code.value;
				if(parent.frames[1].document.forms[0].HspecialityDesc != null && parent.frames[1].document.forms[0].HspecialityDesc.value != '')
					speciality_desc1 = parent.frames[1].document.forms[0].HspecialityDesc.value;

				//Over booking logic hould be call here	
				if(over_book_YN == "Y" && rem_slots_ovr_bk_yn == "0")
					full_vacant = "FULL_OVER_BOOKING_YES";

				param0 = "booking_date="+parent.frames[0].document.forms[0].sch_date.value+
							"&roomCode="+parent.frames[0].document.forms[0].HroomCode.value+
							"&roomDesc="+parent.frames[0].document.forms[0].HroomDesc.value+
							"&surgeonCode="+parent.frames[0].document.forms[0].HsurgeonCode.value+
							"&surgeonName="+encodeURIComponent(parent.frames[0].document.forms[0].HsurgeonDesc.value)+//186
							"&speciality_code="+speciality_code0+
							"&speciality_desc="+encodeURIComponent(speciality_desc0)+//44531
							"&orderid="+parent.frames[0].document.forms[0].Horderid.value+
							"&selOrderIds="+parent.frames[0].document.forms[0].selOrderIds.value+//186
							"&booking_no="+parent.frames[0].document.forms[0].bkng_no.value+
							"&called_from="+parent.frames[0].document.forms[0].Hcalled_from.value+
							"&procedure="+parent.frames[0].document.forms[0].Hprocedure.value+
							"&function_id="+parent.frames[0].document.forms[0].Hfunction_id.value+
							"&fullVacantVal="+parent.frames[0].document.forms[0].fullVacantVal.value+
							"&selSurgeonCode="+parent.frames[0].document.forms[0].selSurgeonCode.value+ // 051825
							"&chkSize=2"+
							"&full_vacant="+parent.frames[0].document.forms[0].Hfull_vacant.value;

				param1 = "booking_date="+parent.frames[1].document.forms[0].sch_date.value+
							"&roomCode="+parent.frames[1].document.forms[0].HroomCode.value+
							"&roomDesc="+parent.frames[1].document.forms[0].HroomDesc.value+
							"&surgeonCode="+parent.frames[1].document.forms[0].HsurgeonCode.value+
							"&surgeonName="+encodeURIComponent(parent.frames[1].document.forms[0].HsurgeonDesc.value)+//186
							"&speciality_code="+speciality_code1+
							"&speciality_desc="+encodeURIComponent(speciality_desc1)+//44531
							"&orderid="+parent.frames[1].document.forms[0].Horderid.value+
							"&selOrderIds="+parent.frames[1].document.forms[0].selOrderIds.value+//186
							"&booking_no="+parent.frames[1].document.forms[0].bkng_no.value+
							"&called_from="+parent.frames[1].document.forms[0].Hcalled_from.value+
							"&procedure="+parent.frames[1].document.forms[0].Hprocedure.value+
							"&function_id="+parent.frames[1].document.forms[0].Hfunction_id.value+
							"&fullVacantVal="+parent.frames[1].document.forms[0].fullVacantVal.value+
							"&selSurgeonCode="+parent.frames[1].document.forms[0].selSurgeonCode.value+ // 051825
							"&chkSize=2"+
							"&full_vacant="+parent.frames[1].document.forms[0].Hfull_vacant.value;

				param = param0 + "~" + param1;
				parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
				parent.parent.frames[0].changeTab("DaySchedule");
				parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
				parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
			}//Slots Check
		}//Date Null check
	}
	else if(chkSize == '3')
	{
		var param = '';
		var param0 = '';
		var param1 = '';
		var param2 = '';
		var no_of_slots0;
		var no_of_slots1;
		var no_of_slots2;

		locale = obj.locale.value;
		over_book_YN = checkOverBookAlowed();
		no_of_slots = checkSlotsGeneratedFrame(chkSize);
		if(no_of_slots.indexOf("~") != -1 && no_of_slots.indexOf("~~") != -1)
		{
			no_of_slots0 = no_of_slots.substring(0, no_of_slots.indexOf("~"));
			no_of_slots1 = no_of_slots.substring(no_of_slots.indexOf("~")+1, no_of_slots.indexOf("~~"));
			no_of_slots2 = no_of_slots.substring(no_of_slots.indexOf("~~")+2, no_of_slots.length);
		}
		rem_slots_ovr_bk_yn = checkOverBookingSlotsYN();
		over_bk_strt_time = checkOverBookStartTime();
		called_from = obj.Hcalled_from.value;
		bkng_no = obj.bkng_no.value;
		bkng_date = obj.sch_date.value;
		bkng_date = convertDate(bkng_date,"DMY",locale,"en");
		function_id = obj.Hfunction_id.value;
		Horderid = obj.Horderid.value;
		speciality_code = '';
		speciality_desc = '';
		roomCode = obj.HroomCode.value;
		roomDesc = obj.HroomDesc.value;
		surgeonCode = obj.HsurgeonCode.value;
		surgeonName = obj.HsurgeonDesc.value;
		procedure = obj.Hprocedure.value;
		full_vacant = obj.Hfull_vacant.value;
		orderid = obj.Horderid.value;
		selOrderIds = obj.selOrderIds.value;//186

		if(obj.sch_date.value == "")
		{
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msg_split = msg.split("&");
			var label = getLabel("Common.ScheduleDate.label","Common");
			alert(msg_split[0]+label+msg_split[1]);
		}
		else
		{
			var curr_date = getCurrentDate('DMY', locale);
			var date = document.forms[0].sch_date.value;
			locale = document.forms[0].locale.value;
			flag = isAfter(date,curr_date,'DMY',locale);
			if(flag == false)
			{
				var msg = getMessage("APP-OT0157","OT");
				var msg_split = msg.split("#");
				var msg_split1 = msg_split[1].split("$");
				var sch_date_label = getLabel("Common.ScheduleDate.label","Common");
				var cur_date_label = getLabel("Common.CurrentDate.label","Common");
				alert(msg_split[0]+sch_date_label+msg_split1[0]+cur_date_label);
				document.forms[0].sch_date.select();	
				//dummyFrame(no_of_slots0, no_of_slots1, no_of_slots2, chkSize);
				return false;
			}

			if(no_of_slots != '')
			{
				if(no_of_slots0 == 0)
				{
					alert(getMessage("APP-OT0194","OT"));
					parent.frames[0].document.forms[0].sch_date.select();
					dummyFrame(no_of_slots0, no_of_slots1, no_of_slots2, chkSize);
				}
				if(no_of_slots1 == 0)
				{
					alert(getMessage("APP-OT0194","OT"));
					parent.frames[1].document.forms[0].sch_date.select();
					dummyFrame(no_of_slots0, no_of_slots1, no_of_slots2, chkSize);
				}
				if(no_of_slots2 == 0)
				{
					alert(getMessage("APP-OT0194","OT"));
					parent.frames[2].document.forms[0].sch_date.select();
					dummyFrame(no_of_slots0, no_of_slots1, no_of_slots2, chkSize);
				}
			}

			var called_from = obj.Hcalled_from.value;
			var bkng_no = obj.bkng_no.value;
			var locale = document.forms[0].locale.value;
			var bkng_date = obj.sch_date.value;
			bkng_date = convertDate(bkng_date,"DMY",locale,"en");
			function_id = obj.Hfunction_id.value;
			Horderid = obj.Horderid.value;
			roomCode = obj.HroomCode.value;
			roomDesc = obj.HroomDesc.value;
			surgeonCode = obj.HsurgeonCode.value;
			surgeonName = obj.HsurgeonDesc.value;
			procedure = obj.Hprocedure.value;
			full_vacant = obj.Hfull_vacant.value;
			no_of_slots = checkSlotsGenerated();		
			retVal = trimString(validateElectiveCutOffTime(bkng_date));
			if(retVal.length > 1)
			{
				var msg = getMessage("APP-OT0124","OT");
				alert(msg);
			}
			else
			{
				var speciality_code0 = '';
				var speciality_desc0 = ''
				var speciality_code1 = ''
				var speciality_desc1 = ''
				var speciality_code2 = ''
				var speciality_desc2 = ''

				if(parent.frames[0].document.forms[0].Hspeciality_code != null && parent.frames[0].document.forms[0].Hspeciality_code.value != '')
					speciality_code0 = parent.frames[0].document.forms[0].Hspeciality_code.value;
				if(parent.frames[0].document.forms[0].HspecialityDesc != null && parent.frames[0].document.forms[0].HspecialityDesc.value != '')
					speciality_desc0 = parent.frames[0].document.forms[0].HspecialityDesc.value;
				if(parent.frames[1].document.forms[0].Hspeciality_code != null && parent.frames[1].document.forms[0].Hspeciality_code.value != '')
					speciality_code1 = parent.frames[1].document.forms[0].Hspeciality_code.value;
				if(parent.frames[1].document.forms[0].HspecialityDesc != null && parent.frames[1].document.forms[0].HspecialityDesc.value != '')
					speciality_desc1 = parent.frames[1].document.forms[0].HspecialityDesc.value;
				if(parent.frames[2].document.forms[0].Hspeciality_code != null && parent.frames[2].document.forms[0].Hspeciality_code.value != '')
					speciality_code2 = parent.frames[2].document.forms[0].Hspeciality_code.value;
				if(parent.frames[2].document.forms[0].HspecialityDesc != null && parent.frames[2].document.forms[0].HspecialityDesc.value != '')
					speciality_desc2 = parent.frames[2].document.forms[0].HspecialityDesc.value;

				//Over booking logic should be call here	
				if(over_book_YN == "Y" && rem_slots_ovr_bk_yn == "0")
					full_vacant = "FULL_OVER_BOOKING_YES";

				param0 = "booking_date="+parent.frames[0].document.forms[0].sch_date.value+
							"&roomCode="+parent.frames[0].document.forms[0].HroomCode.value+
							"&roomDesc="+parent.frames[0].document.forms[0].HroomDesc.value+
							"&surgeonCode="+parent.frames[0].document.forms[0].HsurgeonCode.value+
							"&surgeonName="+encodeURIComponent(parent.frames[0].document.forms[0].HsurgeonDesc.value)+//186
							"&speciality_code="+speciality_code0+
							"&speciality_desc="+encodeURIComponent(speciality_desc0)+//44531
							"&orderid="+parent.frames[0].document.forms[0].Horderid.value+
							"&selOrderIds="+parent.frames[0].document.forms[0].selOrderIds.value+//186
							"&booking_no="+parent.frames[0].document.forms[0].bkng_no.value+
							"&called_from="+parent.frames[0].document.forms[0].Hcalled_from.value+
							"&procedure="+parent.frames[0].document.forms[0].Hprocedure.value+
							"&function_id="+parent.frames[0].document.forms[0].Hfunction_id.value+
							"&fullVacantVal="+parent.frames[0].document.forms[0].fullVacantVal.value+
							"&selSurgeonCode="+parent.frames[0].document.forms[0].selSurgeonCode.value+ // 051825
							"&chkSize=3"+
							"&full_vacant="+parent.frames[0].document.forms[0].Hfull_vacant.value;

				param1 = "booking_date="+parent.frames[1].document.forms[0].sch_date.value+
							"&roomCode="+parent.frames[1].document.forms[0].HroomCode.value+
							"&roomDesc="+parent.frames[1].document.forms[0].HroomDesc.value+
							"&surgeonCode="+parent.frames[1].document.forms[0].HsurgeonCode.value+
							"&surgeonName="+(parent.frames[1].document.forms[0].HsurgeonDesc.value)+//186
							"&speciality_code="+speciality_code1+
							"&speciality_desc="+encodeURIComponent(speciality_desc1)+//44531
							"&orderid="+parent.frames[1].document.forms[0].Horderid.value+
							"&selOrderIds="+parent.frames[1].document.forms[0].selOrderIds.value+//186
							"&booking_no="+parent.frames[1].document.forms[0].bkng_no.value+
							"&called_from="+parent.frames[1].document.forms[0].Hcalled_from.value+
							"&procedure="+parent.frames[1].document.forms[0].Hprocedure.value+
							"&function_id="+parent.frames[1].document.forms[0].Hfunction_id.value+
							"&fullVacantVal="+parent.frames[1].document.forms[0].fullVacantVal.value+
							"&selSurgeonCode="+parent.frames[1].document.forms[0].selSurgeonCode.value+ // 051825
							"&chkSize=3"+
							"&full_vacant="+parent.frames[1].document.forms[0].Hfull_vacant.value;

				param2 = "booking_date="+parent.frames[2].document.forms[0].sch_date.value+
							"&roomCode="+parent.frames[2].document.forms[0].HroomCode.value+
							"&roomDesc="+parent.frames[2].document.forms[0].HroomDesc.value+
							"&surgeonCode="+parent.frames[2].document.forms[0].HsurgeonCode.value+
							"&surgeonName="+encodeURIComponent(parent.frames[2].document.forms[0].HsurgeonDesc.value)+//186
							"&speciality_code="+speciality_code2+
							"&speciality_desc="+encodeURIComponent(speciality_desc2)+//44531
							"&orderid="+parent.frames[2].document.forms[0].Horderid.value+
							"&selOrderIds="+parent.frames[2].document.forms[0].selOrderIds.value+
							"&booking_no="+parent.frames[2].document.forms[0].bkng_no.value+
							"&called_from="+parent.frames[2].document.forms[0].Hcalled_from.value+
							"&procedure="+parent.frames[2].document.forms[0].Hprocedure.value+
							"&function_id="+parent.frames[1].document.forms[0].Hfunction_id.value+
							"&fullVacantVal="+parent.frames[2].document.forms[0].fullVacantVal.value+
							"&selSurgeonCode="+parent.frames[2].document.forms[0].selSurgeonCode.value+ // 051825
							"&chkSize=3"+
							"&full_vacant="+parent.frames[2].document.forms[0].Hfull_vacant.value;

				param = param0 + "~" + param1 + "~~" + param2;
				parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
				parent.parent.frames[0].changeTab("DaySchedule");
				parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
				parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
			}//Slots Check
		}//Date Null check
	}
}

function checkOverBookAlowed(){
	var locale=document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
	var room_code=document.forms[0].HroomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&room_code="+room_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkOverBookYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var over_book_YN = trimString(xmlHttp.responseText);
	return over_book_YN;
}

function checkSlotsGenerated(){
	var locale=document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
	var room_code=document.forms[0].HroomCode.value;
	var surgeon_code=document.forms[0].HsurgeonCode.value;
	var sch_date=document.forms[0].sch_date.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	sch_date=convertDate(sch_date,"DMY",locale,"en");
	var params = "facility_id="+facility_id+"&room_code="+room_code+"&sch_date="+sch_date+"&surgeon_code="+surgeon_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params,false);
	xmlHttp.send(xmlDoc);
	var no_of_slots = trimString(xmlHttp.responseText);
	return no_of_slots;
}

//this function will return when the oper room is having over booking and how many slots remaining

function checkOverBookingSlotsYN(){
	var locale=document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
	var room_code=document.forms[0].HroomCode.value
	var sch_date=document.forms[0].sch_date.value
	sch_date=convertDate(sch_date,"DMY",locale,"en");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&room_code="+room_code+"&sch_date="+sch_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkOverBookingSlotsYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var remaining_slots = trimString(xmlHttp.responseText);
	if(remaining_slots==""){
		remaining_slots=0;
	}
	return remaining_slots;
}

function checkOverBookStartTime(){
	var locale=document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
	var room_code=document.forms[0].HroomCode.value
	var sch_date=document.forms[0].sch_date.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&room_code="+room_code+"&sch_date="+sch_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkOverBookStartTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var over_bk_strt_time = trimString(xmlHttp.responseText);
	return over_bk_strt_time;

}


function checkSlotsGeneratedFrame(chkSize)
{
	var no_of_slots;
	var no_of_slots0;
	var no_of_slots1;
	if(chkSize == '2')
	{
		var locale0 = parent.frames[0].document.forms[0].locale.value;
		var facility_id0 = parent.frames[0].document.forms[0].facility_id.value;
		var room_code0 = parent.frames[0].document.forms[0].HroomCode.value;
		var surgeon_code0 = parent.frames[0].document.forms[0].HsurgeonCode.value;
		var sch_date0 = parent.frames[0].document.forms[0].sch_date.value;
		
		/*var xmlDoc0 = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp0 = new ActiveXObject( "Microsoft.XMLHTTP" );
		sch_date0 = convertDate(sch_date0, "DMY",locale0, "en");
		var params0 = "facility_id="+facility_id0+"&room_code="+room_code0+"&sch_date="+sch_date0+"&surgeon_code="+surgeon_code0;
		var xmlStr0 = "<root><SEARCH ";
		xmlStr0 += " /></root>";
		xmlDoc0.loadXML(xmlStr0);
		xmlHttp0.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params0,false);
		xmlHttp0.send(xmlDoc0);
		no_of_slots0 = trimString(xmlHttp0.responseText);*/
		
		sch_date0 = convertDate(sch_date0, "DMY",locale0, "en");
		var params0 = "facility_id="+facility_id0+"&room_code="+room_code0+"&sch_date="+sch_date0+"&surgeon_code="+surgeon_code0;
		
		var xmlStr = "";
		//var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH" ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params0, false ) ;
		xmlHttp.send(xmlDoc);
		no_of_slots0 = trimString(xmlHttp.responseText);
		

		var locale1 = parent.frames[1].document.forms[0].locale.value;
		var facility_id1 = parent.frames[1].document.forms[0].facility_id.value;
		var room_code1 = parent.frames[1].document.forms[0].HroomCode.value;
		var surgeon_code1 = parent.frames[1].document.forms[0].HsurgeonCode.value;
		var sch_date1 = parent.frames[1].document.forms[0].sch_date.value;
		
		/*var xmlDoc1 = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp1 = new ActiveXObject( "Microsoft.XMLHTTP" );
		sch_date1 = convertDate(sch_date1, "DMY",locale1, "en");
		var params1 = "facility_id="+facility_id1+"&room_code="+room_code1+"&sch_date="+sch_date1+"&surgeon_code="+surgeon_code1;
		var xmlStr1 = "<root><SEARCH ";
		xmlStr1 += " /></root>";
		xmlDoc1.loadXML(xmlStr1);
		xmlHttp1.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params1,false);
		xmlHttp1.send(xmlDoc1);
		no_of_slots1 = trimString(xmlHttp1.responseText);*/
		
		sch_date1 = convertDate(sch_date1, "DMY",locale1, "en");
		var params1 = "facility_id="+facility_id1+"&room_code="+room_code1+"&sch_date="+sch_date1+"&surgeon_code="+surgeon_code1;
		
		//xmlDoc="";
		xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH" ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params1, false ) ;
		xmlHttp.send(xmlDoc);
		no_of_slots1 = trimString(xmlHttp.responseText);

		no_of_slots = no_of_slots0 + "~" + no_of_slots1;
	}
	else if(chkSize == '3')
	{
		var locale0 = parent.frames[0].document.forms[0].locale.value;
		var facility_id0 = parent.frames[0].document.forms[0].facility_id.value;
		var room_code0 = parent.frames[0].document.forms[0].HroomCode.value;
		var surgeon_code0 = parent.frames[0].document.forms[0].HsurgeonCode.value;
		var sch_date0 = parent.frames[0].document.forms[0].sch_date.value;
		/*var xmlDoc0 = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp0 = new ActiveXObject( "Microsoft.XMLHTTP" );
		sch_date0 = convertDate(sch_date0, "DMY",locale0, "en");
		var params0 = "facility_id="+facility_id0+"&room_code="+room_code0+"&sch_date="+sch_date0+"&surgeon_code="+surgeon_code0;
		var xmlStr0 = "<root><SEARCH ";
		xmlStr0 += " /></root>";
		xmlDoc0.loadXML(xmlStr0);
		xmlHttp0.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params0,false);
		xmlHttp0.send(xmlDoc0);
		no_of_slots0 = trimString(xmlHttp0.responseText);*/
		
		sch_date0 = convertDate(sch_date0, "DMY",locale0, "en");
		var params0 = "facility_id="+facility_id0+"&room_code="+room_code0+"&sch_date="+sch_date0+"&surgeon_code="+surgeon_code0;
		
		var xmlStr = "";
		//var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH" ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params0, false ) ;
		xmlHttp.send(xmlDoc);
		no_of_slots0 = trimString(xmlHttp.responseText);

		var locale1 = parent.frames[1].document.forms[0].locale.value;
		var facility_id1 = parent.frames[1].document.forms[0].facility_id.value;
		var room_code1 = parent.frames[1].document.forms[0].HroomCode.value;
		var surgeon_code1 = parent.frames[1].document.forms[0].HsurgeonCode.value;
		var sch_date1 = parent.frames[1].document.forms[0].sch_date.value;
		
		/*var xmlDoc1 = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp1 = new ActiveXObject( "Microsoft.XMLHTTP" );
		sch_date1 = convertDate(sch_date1, "DMY",locale1, "en");
		var params1 = "facility_id="+facility_id1+"&room_code="+room_code1+"&sch_date="+sch_date1+"&surgeon_code="+surgeon_code1;
		var xmlStr1 = "<root><SEARCH ";
		xmlStr1 += " /></root>";
		xmlDoc1.loadXML(xmlStr1);
		xmlHttp1.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params1,false);
		xmlHttp1.send(xmlDoc1);
		no_of_slots1 = trimString(xmlHttp1.responseText);*/
		
		sch_date1 = convertDate(sch_date1, "DMY",locale1, "en");
		var params1 = "facility_id="+facility_id1+"&room_code="+room_code1+"&sch_date="+sch_date1+"&surgeon_code="+surgeon_code1;
		
		//xmlDoc="";
		xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH" ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params1, false ) ;
		xmlHttp.send(xmlDoc);
		no_of_slots1 = trimString(xmlHttp.responseText);

		var locale2 = parent.frames[2].document.forms[0].locale.value;
		var facility_id2 = parent.frames[2].document.forms[0].facility_id.value;
		var room_code2 = parent.frames[2].document.forms[0].HroomCode.value;
		var surgeon_code2 = parent.frames[2].document.forms[0].HsurgeonCode.value;
		var sch_date2 = parent.frames[2].document.forms[0].sch_date.value;
		/*var xmlDoc2 = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp2 = new ActiveXObject( "Microsoft.XMLHTTP" );
		sch_date2 = convertDate(sch_date2, "DMY",locale2, "en");
		var params2 = "facility_id="+facility_id2+"&room_code="+room_code2+"&sch_date="+sch_date2+"&surgeon_code="+surgeon_code2;
		var xmlStr2 = "<root><SEARCH ";
		xmlStr2 += " /></root>";
		xmlDoc2.loadXML(xmlStr2);
		xmlHttp2.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params2,false);
		xmlHttp2.send(xmlDoc2);
		no_of_slots2 = trimString(xmlHttp2.responseText);*/
		
		sch_date2 = convertDate(sch_date2, "DMY",locale2, "en");
		var params2 = "facility_id="+facility_id2+"&room_code="+room_code2+"&sch_date="+sch_date2+"&surgeon_code="+surgeon_code2;
		
		//xmlDoc="";
		xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH" ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params2, false ) ;
		xmlHttp.send(xmlDoc);
		no_of_slots2 = trimString(xmlHttp.responseText);

		no_of_slots = no_of_slots0 + "~" + no_of_slots1 + "~~" + no_of_slots2;
	}
	return no_of_slots;
}

//this function will return when the oper room is having over booking and how many slots remaining

function checkOverBookStartTimeFrame(frameNmbr)
{
	var i = parseInt(frameNmbr);
	var locale = parent.frames[i].document.forms[0].locale.value;
	var facility_id = parent.frames[i].document.forms[0].facility_id.value;
	var room_code = parent.frames[i].document.forms[0].HroomCode.value
	var sch_date = parent.frames[i].document.forms[0].sch_date.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "facility_id="+facility_id+"&room_code="+room_code+"&sch_date="+sch_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkOverBookStartTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var over_bk_strt_time = trimString(xmlHttp.responseText);
	return over_bk_strt_time;
}

function checkSlotsGeneratedFrameDaySched(frameNmbr)
{
	var no_of_slots;
	var i = parseInt(frameNmbr);
	var locale = parent.frames[i].document.forms[0].locale.value;
	var facility_id = parent.frames[i].document.forms[0].facility_id.value;
	var room_code = parent.frames[i].document.forms[0].HroomCode.value;
	var surgeon_code = parent.frames[i].document.forms[0].HsurgeonCode.value;
	var sch_date = parent.frames[i].document.forms[0].sch_date.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	sch_date = convertDate(sch_date, "DMY",locale, "en");
	var params = "facility_id="+facility_id+"&room_code="+room_code+"&sch_date="+sch_date+"&surgeon_code="+surgeon_code;
	var xmlStr = "<root><SEARCH ";
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=checkSlotsCenerated&"+params,false);
	xmlHttp.send(xmlDoc);
	no_of_slots = trimString(xmlHttp.responseText);
	return no_of_slots;
}


//Over booking calling function


async function showBookingDialog1(specialityCode,specialityDesc,surgeonCode,surgeonName,roomCode,roomDesc,booking_date,full_vacant,called_from,over_bk_strt_time,no_of_slots, frameNmr)
{
	
	var i = parseInt(frameNmr);//186
	var dialogHeight = screen.availHeight;
	var dialogWidth = screen.availWidth;
	var dialogTop = "0";
	var dialogLeft = "0";
	var features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments = "";
	var retVal = "";
	var retVal1 = "";
	if(frameNmr != '')
	{
		over_bk_strt_time = checkOverBookStartTimeFrame(frameNmr);
		no_of_slots = checkSlotsGeneratedFrameDaySched(frameNmr);
	}

	var obj=document.forms[0];
	var locale = obj.locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var procedure = obj.Hprocedure.value;
	var bkng_no = obj.bkng_no.value;
	var hiddenTime = booking_date+" "+over_bk_strt_time;
	var function_id = obj.Hfunction_id.value;
	var orderid = obj.Horderid.value;
	var selOrderIds = obj.selOrderIds.value;//186
	if(obj.bkng_no == null || bkng_no == '')
	{
		var param = "booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+over_bk_strt_time+"&hidden_time="+hiddenTime+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&procedure="+procedure+"&no_of_slots="+no_of_slots;
		var strval = obj.Horderid.value;
		param += "&orderid="+strval;
		param += "&selOrderIds="+selOrderIds;//186
		
		retVal1 = await top.window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);
	}
	else
	{
		var function_id = function_id;
		var param = "booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+bkng_no+"&facility_id="+facility_id+"&order_id="+orderid+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id+"&no_of_slots="+no_of_slots;
		param += "&selOrderIds="+selOrderIds;//186
		retVal1 = await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}
	var par = "";
	if(retVal1.charAt(0)=='1')
	{
		if((obj.Horderid!=null&&obj.Horderid.value.length > 0) || (obj.bkng_no!=null&&obj.bkng_no.value.length >0))
		{
			param=param+"&fun=1";
		}
		parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdr.jsp?"+param;
		parent.frames[0].changeTab("DaySchedule");
		parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
		parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
	}
}


async function showBookingDialogOverBook(specialityCode,specialityDesc,surgeonCode,surgeonName,roomCode,roomDesc,booking_date,full_vacant,called_from,over_bk_strt_time,no_of_slots, frameNmr, overBookingWindowYN)
{

	var i = parseInt(frameNmr);
	var dialogHeight = screen.availHeight;
	var dialogWidth = screen.availWidth;
	var dialogTop = "0";
	var dialogLeft = "0";
	var features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments = "";
	var retVal = "";
	var retVal1 = "";
	if(frameNmr != '')
	{
		over_bk_strt_time = checkOverBookStartTimeFrame(frameNmr);
		no_of_slots = checkSlotsGeneratedFrameDaySched(frameNmr);
	}

	var obj=document.forms[0];
	var locale = obj.locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var procedure = obj.Hprocedure.value;
	var bkng_no = obj.bkng_no.value;
	var hiddenTime = booking_date+" "+over_bk_strt_time;
	var function_id = obj.Hfunction_id.value;
	var orderid = obj.Horderid.value;
	var selOrderIds = obj.selOrderIds.value;//186
	if(obj.bkng_no == null || bkng_no == '')
	{
		var param = "booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+over_bk_strt_time+"&hidden_time="+hiddenTime+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&procedure="+procedure+"&no_of_slots="+no_of_slots;
		var strval = obj.Horderid.value;
		param += "&orderid="+strval;
		param += "&selOrderIds="+selOrderIds;//186
		
//		retVal1 = ""+window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);
		if (overBookingWindowYN == 'N')
		{
			bookingAvailable = chkOverBookingAvailable(roomCode, booking_date, facility_id);
			if(bookingAvailable == 'Y')
			{
				dialogHeight = screen.availHeight;
				features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
				retVal1=""+window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);//Sanja
			}
			else
				alert(getMessage("APP-OT0219","OT"));
		}
		else 
		{
			// Sanjay To show Overbooking window
			dialogHeight = "16";
			features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
			retVal1= await window.showModalDialog("../../eOT/jsp/OperOverBookingFrame.jsp?"+param,arguments,features);//Sanjay
		}
	}
	else
	{
		var function_id = function_id;
		var param = "booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&start_time="+fromTime+"&hidden_time="+hiddenTime+"&transfer=1"+"&booking_no="+bkng_no+"&facility_id="+facility_id+"&order_id="+orderid+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id+"&no_of_slots="+no_of_slots;
		param += "&selOrderIds="+selOrderIds;//186
		retVal1 = await window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}
	var par = "";

	if(retVal1.charAt(0)=='1')
	{
		if((obj.Horderid!=null&&obj.Horderid.value.length > 0) || (obj.bkng_no!=null&&obj.bkng_no.value.length >0))
		{
			param=param+"&fun=1";
		}
		parent.frames(i).location.reload();
/*
		parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdr.jsp?"+param;
		parent.frames[0].changeTab("DaySchedule");
		parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
		parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
*/
	}
}


async function showCalendar_loc(dateInput,format,dayInput)
{
		var date = await showInModal(dateInput,format);
		assignDayFromParent(dateInput.value,dayInput);
		return dateInput.value;		
}

function dummy(specialityCode,specialityDesc,surgeonCode,surgeonName,roomCode,roomDesc,booking_date,full_vacant,called_from,over_bk_strt_time,no_of_slots,bkng_no,orderid){
	var obj=document.forms[0];
	var locale = obj.locale.value;
	var function_id=obj.Hfunction_id.value;
	var facility_id=document.forms[0].facility_id.value;
	var param="booking_date="+convertDate(booking_date,'DMY','en',locale)+"&roomCode="+roomCode+"&roomDesc="+encodeURIComponent(roomDesc)+"&surgeonCode="+surgeonCode+"&surgeonName="+encodeURIComponent(surgeonName)+"&speciality_code="+specialityCode+"&speciality_desc="+encodeURIComponent(specialityDesc)+"&transfer=1"+"&booking_no="+bkng_no+"&facility_id="+facility_id+"&order_id="+orderid+"&over_booking_case_yn=Y"+"&called_from="+called_from+"&function_id="+function_id+"&no_of_slots="+no_of_slots;
	parent.frames[0].changeTab("DaySchedule");
	parent.qa_query_result.location.href="../../eOT/jsp/Schedule.jsp?"+param;
	parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"+param;
}

function dummyFrame(no_of_slots0, no_of_slots1, no_of_slots2, chkSize)
{
	var param;
	var bkng_date0;

	var locale;
	var speciality_code = '';
	var speciality_desc = '';

	locale = document.forms[0].locale.value;

	if(chkSize == '1')
	{
		bkng_date0 = convertDate(parent.frames[0].document.forms[0].sch_date.value,"DMY",locale,"en");
		param = "booking_date="+convertDate(bkng_date0,'DMY','en',locale)+
						"&roomCode="+parent.frames[0].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[0].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[0].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[0].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[0].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[0].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[0].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[0].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[0].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[0].document.forms[0].Hfunction_id.value+
						"&chkSize=1"+
						"&no_of_slots="+no_of_slots0;
		parent.parent.frames[0].changeTab("DaySchedule");
//		parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;//186
		parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
		parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
	}
	else if(chkSize == '2')
	{
		bkng_date0 = convertDate(parent.frames[0].document.forms[0].sch_date.value,"DMY",locale,"en");
		bkng_date1 = convertDate(parent.frames[1].document.forms[0].sch_date.value,"DMY",locale,"en");

		param0 = "booking_date="+convertDate(bkng_date0,'DMY','en',locale)+
						"&roomCode="+parent.frames[0].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[0].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[0].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[0].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[0].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[0].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[0].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[0].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[0].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[0].document.forms[0].Hfunction_id.value+
						"&chkSize=2"+
						"&no_of_slots="+no_of_slots0;

		param1 = "booking_date="+convertDate(bkng_date1,'DMY','en',locale)+
						"&roomCode="+parent.frames[1].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[1].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[1].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[1].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[1].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[1].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[1].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[1].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[1].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[1].document.forms[0].Hfunction_id.value+
						"&chkSize=2"+
						"&no_of_slots="+no_of_slots1;

		param = param0 + "~" + param1;
		parent.parent.frames[0].changeTab("DaySchedule");
//		parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;
		parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
		parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
	}
	else if(chkSize == '3')
	{
		bkng_date0 = convertDate(parent.frames[0].document.forms[0].sch_date.value,"DMY",locale,"en");
		bkng_date1 = convertDate(parent.frames[1].document.forms[0].sch_date.value,"DMY",locale,"en");
		bkng_date2 = convertDate(parent.frames[2].document.forms[0].sch_date.value,"DMY",locale,"en");

		param0 = "booking_date="+convertDate(bkng_date0,'DMY','en',locale)+
						"&roomCode="+parent.frames[0].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[0].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[0].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[0].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[0].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[0].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[0].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[0].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[0].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[0].document.forms[0].Hfunction_id.value+
						"&chkSize=3"+
						"&no_of_slots="+no_of_slots0;

		param1 = "booking_date="+convertDate(bkng_date1,'DMY','en',locale)+
						"&roomCode="+parent.frames[1].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[1].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[1].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[1].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[1].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[1].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[1].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[1].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[1].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[1].document.forms[0].Hfunction_id.value+
						"&chkSize=3"+
						"&no_of_slots="+no_of_slots1;

		param2 = "booking_date="+convertDate(bkng_date2,'DMY','en',locale)+
						"&roomCode="+parent.frames[2].document.forms[0].HroomCode.value+
						"&roomDesc="+encodeURIComponent(parent.frames[2].document.forms[0].HroomDesc.value)+
						"&surgeonCode="+parent.frames[2].document.forms[0].HsurgeonCode.value+
						"&surgeonName="+encodeURIComponent(parent.frames[2].document.forms[0].HsurgeonDesc.value)+
						"&speciality_code="+speciality_code+
						"&speciality_desc="+encodeURIComponent(speciality_desc)+
						"&transfer=1"+
						"&booking_no="+parent.frames[2].document.forms[0].bkng_no.value+
						"&facility_id="+parent.frames[2].document.forms[0].facility_id.value+
						"&orderid="+parent.frames[2].document.forms[0].Horderid.value+
						"&selOrderIds="+parent.frames[2].document.forms[0].selOrderIds.value+//186
						"&over_booking_case_yn=Y"+
						"&called_from="+parent.frames[2].document.forms[0].Hcalled_from.value+
						"&function_id="+parent.frames[2].document.forms[0].Hfunction_id.value+
						"&chkSize=3"+
						"&no_of_slots="+no_of_slots2;

		param = param0 + "~" + param1 + "~~" + param2;
//		parent.parent.frames[0].changeTab("DaySchedule");
		parent.parent.f_query_add_mod.location.href="../../eOT/jsp/ScheduleHdrFrame.jsp?"+param;//186
		parent.parent.qa_query_result.location.href="../../eOT/jsp/ScheduleFrame.jsp?"+param;
		parent.parent.qa_query_result_tail.location.href="../../eOT/jsp/TailScheduleLegendFrame.jsp?"+param;
	}
}

function chkOverBookingAvailable(roomCode, booking_date, facility_id)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var locale = document.forms[0].locale.value;
	var xmlStr ="<root><SEARCH  /></root>";
	var param="func_mode=chkOverBookingAvailable&roomCode="+roomCode+"&strBookingDate="+convertDate(booking_date,'DMY','en',locale)+"&facility_id="+facility_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var check_count = localTrimString(xmlHttp.responseText);	
	return check_count;
}

function localTrimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}
