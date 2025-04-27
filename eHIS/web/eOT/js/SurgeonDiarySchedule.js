/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset()
{
	f_query_add_mod.document.forms[0].reset();
	// Added against RESET Functionality - Starts Here
	var frmObj = f_query_add_mod.document.forms[0]
	frmObj.surgeon_desc.value="";
	frmObj.surgeon_desc.disabled=false;
	frmObj.theatre_desc.value="";
	frmObj.theatre_desc.disabled=false;
	frmObj.thtrlkp.disabled=false;
	frmObj.notetypelkp.disabled=false;
	// Added against RESET Functionality - Ends Here
}


function onLoadChkSurgonWeeksYn(surgeon_code){
	var formObj=document.forms[0];
	var facility_id=formObj.facilityid.value;
	var theatre_code=formObj.theatre_code.value;
//	var surgeon_code=surgeon_code;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getSurgeonScheduleWeeks&facility_id="+facility_id+"&theatre_code="+theatre_code+"&surgeon_code="+surgeon_code;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	assignChkBoxVal(retVal);
}

function assignChkBoxVal(sel_weeks){
	var formObj=document.forms[0];
	var arr = sel_weeks.split("##");
	if(arr[0]=="1")	formObj.sun.checked=true;
	if(arr[1]=="2")	formObj.mon.checked=true;
	if(arr[2]=="3")	formObj.tue.checked=true;
	if(arr[3]=="4")	formObj.wed.checked=true;
	if(arr[4]=="5")	formObj.thu.checked=true;
	if(arr[5]=="6")	formObj.fri.checked=true;
	if(arr[6]=="7")	formObj.sat.checked=true;
	
}

async function searchLkp(type,obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql="";
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	var facilityid = frmObj.facilityid.value;

	if (type=="D"){
		/*if (frmObj.theatre_desc.value==""){
		  // alert("Theatre cannot be null");
		  var theatre_label = getLabel("Common.Theatre.label","Common");
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  var msgArray = msg.split("&");
		  alert(msgArray[0]+theatre_label+msgArray[1]);
		   return false;
		}*/
	}

	if (type=="T")
	{
		if (frmObj.surgeon_desc.value!=""){
			frmObj.from_date.value ="";
			frmObj.to_date.value = "";
			frmObj.surgeon_code.value = "";
			frmObj.surgeon_desc.value = "";
			frmObj.diary_gen_upto.value = "";
			frmObj.sun.value = "N";
			frmObj.sun.checked = false;
			frmObj.mon.value = "N";
			frmObj.mon.checked = false;
			frmObj.tue.value = "N";
			frmObj.tue.checked = false;
			frmObj.wed.value = "N";
			frmObj.wed.checked = false;
			frmObj.thu.value = "N";
			frmObj.thu.checked = false;
			frmObj.fri.value = "N";
			frmObj.fri.checked = false;
			frmObj.sat.value = "N";
			frmObj.sat.checked = false;
		}
		//tit="Theatre Search" ;
		tit=getLabel("Common.Theatre.label","Common");
		sql="SELECT SHORT_DESC  DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = '"+facilityid+"' AND LANGUAGE_ID='"+locale+"' AND (NVL(STATUS,'D') ='E' OR STATUS IS NULL) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 1";
	}

	if (type=="D")
	{
		//tit="Surgeon Search" ;
		tit=getLabel("Common.Surgeon.label","Common") ;
		//sql="SELECT SHORT_NAME  DESCRIPTION, PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST where (NVL(STATUS,'D') ='E' OR STATUS IS NULL) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?)  AND FACILITY_ID = '"+facilityid+"' AND PRACT_TYPE IN ('MD', 'SG') ORDER BY 1";
//sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE IN ('OS','AS')) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

//Modified by rajesh on 18/07/2008

sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
//		sql="SELECT SHORT_NAME  DESCRIPTION, PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND (NVL(EFF_STATUS,'E') ='E' OR EFF_STATUS IS NULL) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND PRACT_TYPE IN ('MD', 'SG') ORDER BY 1";

	}

	//tit=encodeURIComponent(tit);
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
	if (type=="D" && frmObj.generate_by.value == "BT"){ // generate this logic only when both cases are shown
		getDtls("D") ;
	}
 }

 function getDtls(obj){
	var formObj = document.SurgeonDiaryScheduleForm;
	var locale = formObj.locale.value;
	if (formObj.surgeon_code != ""){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var url="DiaryScheduleDtls.jsp?surgeon_code="+formObj.surgeon_code.value+"&theatre_code="+formObj.theatre_code.value
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",url,false);
		xmlHttp.send(xmlDoc);
		retVal=xmlHttp.responseText;
		if(retVal!="undefined"){
			var days_arr = retVal.split(/::|@@|##/g);
			//var max_date = days_arr[days_arr.length-2];
			var max_date = days_arr[days_arr.length-3];
			//alert("1st max_date==="+max_date)

			if(max_date=="NOT_GENERATED")
				max_date="";
			var cur_date = days_arr[days_arr.length-2];
			var newdate=days_arr[days_arr.length-1];
			formObj.diary_gen_upto.value = max_date=="null"?"":max_date;
			if (formObj.diary_gen_upto.value !=""){
					formObj.from_date.value = newdate;
					formObj.to_date.value = newdate;
			}else{

				formObj.from_date.value = cur_date=="null"?"":cur_date;
				formObj.to_date.value = cur_date=="null"?"":cur_date;
			}
			formObj.curr_date.value = cur_date=="null"?"":cur_date;
			for (var i=1; i<days_arr.length ;i++ )
			{
						if (i==7){
							if (trimString(days_arr[6])=="Y")
							{
								formObj.sun.value = "Y";
								formObj.sun.checked=true;  
							}
							else if (trimString(days_arr[6])=="N")
							{
								formObj.sun.value = "N";
								formObj.sun.checked=false;  
							}
						}

						if (i==1){
							if (trimString(days_arr[0])=="Y"){
								formObj.mon.value = "Y";
								formObj.mon.checked=true; 
							}	
							else if (trimString(days_arr[0])=="N"){
								formObj.mon.value = "N";
								formObj.mon.checked=false;  
							}
						}

						if (i==2){
							if (trimString(days_arr[1])=="Y"){
								formObj.tue.value = "Y";
								formObj.tue.checked=true;  
							}else if (trimString(days_arr[1])=="N"){
								formObj.tue.value = "N";
								formObj.tue.checked=false;  
							}
						}

						if (i==3){
							if (trimString(days_arr[2])=="Y"){
								formObj.wed.value = "Y";
								formObj.wed.checked=true;  
							}else if (trimString(days_arr[2])=="N"){
								formObj.wed.value = "N";
								formObj.wed.checked=false;  
							}
						}

						if (i==4){
							if (trimString(days_arr[3])=="Y"){
								formObj.thu.value = "Y";
								formObj.thu.checked=true;  
							}else if (trimString(days_arr[3])=="N"){
								formObj.thu.value = "N";
								formObj.thu.checked=false;  
							}
						}

						if (i==5){
							if (trimString(days_arr[4])=="Y"){
								formObj.fri.value = "Y";
								formObj.fri.checked=true;  
							}else if (trimString(days_arr[4])=="N"){
								formObj.fri.value = "N";
								formObj.fri.checked=false;  
							}
						}

						if (i==6){
							if (trimString(days_arr[5])=="Y"){
								formObj.sat.value = "Y";
								formObj.sat.checked=true;  
							}else if (trimString(days_arr[5])=="N"){
								formObj.sat.value = "N";
								formObj.sat.checked=false;  
							}
						}
			}
		}
	}
}

function checkdate(pref_date){
	var formObj = document.SurgeonDiaryScheduleForm;
	var bool_flag = true;
	var curr_date = formObj.curr_date.value;
	var arr_cur = curr_date.split("/");
	var arr_pref = pref_date.split("/");
	var arr_diary = formObj.diary_gen_upto.value.split("/");
	cur_date = new Date(arr_cur[2],arr_cur[1]-1,arr_cur[0]);
	pref_date = new Date(arr_pref[2],arr_pref[1]-1,arr_pref[0]);
	diary_upto = new Date(arr_diary[2],arr_diary[1]-1,arr_diary[0]);
		//alert("pref_date==="+pref_date)//Sun Jun 28 00:00:00 UTC+0530 2009
		//alert("cur_date==="+cur_date)//Thu May 28 00:00:00 UTC+0530 2008

	if(pref_date < cur_date ){
	   //	alert("APP-OT0018 Date should be greater than Current Date");
		var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArr = msg_1.split("#");
		var date = getLabel("Common.date.label","Common");
		var currentdate =getLabel("Common.CurrentDate.label","Common");
		var message=msgArr[0]+ date  +msgArr[1]+ currentdate +msgArr[2];
		alert(message);
		bool_flag = false;
	}
	/*
	commented by bshankar on 16th April 2008 against reopened issue for SCR-1862
	if (diary_upto !=""){
		if(pref_date < diary_upto ){
			//alert("APP-OT0019 Date should be greater than Diary Generated Upto Date");
			alert(getMessage("APP-OT0060","OT"));
			bool_flag = false;
		}
	}
	 */
	 return bool_flag;
}	 


function comparedate(x1, y1){

	var arr_x1 = x1.split("/");
	var arr_y1 = y1.split("/");
	xx1 = new Date(arr_x1[2],arr_x1[1]-1,arr_x1[0]);
	yy1 = new Date(arr_y1[2],arr_y1[1]-1,arr_y1[0]);
		if(yy1 < xx1){
			//alert("To Date should be greater than or equal to From Date");
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var to_date = getLabel("Common.todate.label","Common");
			var from_date =getLabel("Common.fromdate.label","Common");
			var message=msgArr[0]+ to_date  +msgArr[1]+ from_date +msgArr[2];
			alert(message);
			return false;
		
		}
		if(xx1 > yy1){
			//alert("From Date should be lesser than or equal to To Date");
			//alert(getMessage("FROM_DATE_GREATER_TO_DATE"));
			var msg_1 = getMessage("FROM_DATE_GREATER_TO_DATE","OT");
			var msgArr = msg_1.split("#");
			var to_date = getLabel("Common.todate.label","Common");
			var from_date =getLabel("Common.fromdate.label","Common");
			var message=msgArr[0]+ from_date  +msgArr[1]+ to_date +msgArr[2];
			alert(message);
			
			return false;
		} 
	return true;
}

function enaDisTxtBox(){
	var frmObj = document.SurgeonDiaryScheduleForm;
	var generate_by= frmObj.generate_by.value
	frmObj.theatre_code.value="";
	frmObj.theatre_desc.value="";
	frmObj.surgeon_code.value="";
	frmObj.surgeon_desc.value="";
	var theatre = frmObj.theatre_code.value;
	var surgeon = frmObj.surgeon_code.value;
	if (generate_by=="TH")
	{
		frmObj.surgeon_desc.disabled=true;
		frmObj.notetypelkp.disabled=true;
		frmObj.theatre_desc.disabled=false;
		frmObj.thtrlkp.disabled=false;
	}else if(generate_by=="SG"){
		frmObj.theatre_desc.disabled=true;
		frmObj.thtrlkp.disabled=true;
		frmObj.surgeon_desc.disabled=false;
		frmObj.notetypelkp.disabled=false;
	}
	else{//Both cases
		frmObj.theatre_desc.disabled=false;
		frmObj.thtrlkp.disabled=false;
		frmObj.surgeon_desc.disabled=false;
		frmObj.notetypelkp.disabled=false;
	}
}

function callGenerate(){
//    var frm=window.parent.frames[1];
	var frmObj = document.SurgeonDiaryScheduleForm;
	var diary_sched_for_surg_reqd_yn= frmObj.diary_sched_for_surg_reqd_yn.value;	
	var generate_by= frmObj.generate_by.value	
	var theatre = frmObj.theatre_desc.value;
	var surgeon = frmObj.surgeon_desc.value;
	var messageFrame = parent.messageFrame;
	var f_query_add_mod = parent.f_query_add_mod;
	messageFrame.location.href='../../eCommon/jsp/error.jsp?';
	var label = "";
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var flag=true;
	//condition for listitem
	
	// if(generate_by=="BT"){ Corrected against 22/10/2007
	if(generate_by=="BT" && diary_sched_for_surg_reqd_yn=="Y"){
		if ((theatre=="") || (surgeon=="")){
			label = getLabel("eOT.TheatreAndSurgeon.Label","OT");
			alert(msgArray[0]+label+msgArray[1]);
			return false;
		}		
    }else if(generate_by=="TH"){
			if(theatre==""){
				label=getLabel("Common.Theatre.label","Common");
				alert(msgArray[0]+label+msgArray[1]);
				return false;
			}
	}else if(generate_by=="SG"){
		if(surgeon==""){
			label=getLabel("Common.Surgeon.label","Common");;	
			alert(msgArray[0]+label+msgArray[1]);
			return false;
		}
	}
	
	
	if (frmObj.from_date.value==""){
	   //alert("From Date cannot be null");
	   label = getLabel("Common.fromdate.label","Common");
	   flag=false;
	}
	if(flag==false){
       alert(msgArray[0]+label+msgArray[1]);
	   return false;
	}

	if (frmObj.to_date.value==""){
	   //alert("To Date cannot be null");
	   label = getLabel("Common.todate.label","Common");
	   flag=false;
    }
	if(flag==false){
       alert(msgArray[0]+label+msgArray[1]);
	   return false;
	}

	 if (frmObj.sun.value=="N" && frmObj.mon.value=="N" && frmObj.tue.value=="N" && frmObj.wed.value=="N" && frmObj.thu.value=="N" && frmObj.fri.value=="N" && frmObj.sat.value=="N")
	{
	   //alert("Schedule is not defined for this Surgeon for the selected Theatre.");
	   alert(getMessage("APP-OT0062","OT"));
	   return false;
	}

	if(checkdate(frmObj.from_date.value)){
		if(checkdate(frmObj.to_date.value)){

			var commit_flag = false;
			var date_compare=comparedate(frmObj.from_date.value, frmObj.to_date.value);
			if(date_compare==true){
				commit_flag=true;
 			if(generate_by=="BT" && diary_sched_for_surg_reqd_yn=="Y"){
				
				if (frmObj.from_date.value!="" && frmObj.theatre_code.value !="" && frmObj.surgeon_code.value!=""  && frmObj.to_date.value!="" && commit_flag==true){
						      // commit_flag=true;
					
				  /*var arr_x1 = frmObj.from_date.value.split("/");
					var arr_y1 = frmObj.to_date.value.split("/");
                   
					if(date_compare==false) commit_flag=false;
					xx1 = new Date(arr_x1[2],arr_x1[1]-1,arr_x1[0]);
					yy1 = new Date(arr_y1[2],arr_y1[1]-1,arr_y1[0]);
					
					
					/*if(arr_x1[2]>arr_y1[2]){
							 commit_flag=false;
					}else if(arr_x1[1]-1>arr_y1[1]-1){
							 commit_flag=false;
						 }
						 else if(arr_x1[0]>arr_y1[0]){
							 commit_flag=false;
						 
						 }else{
						  commit_flag=true;
						 }*/
					}
			}
			if(generate_by=="BT" && diary_sched_for_surg_reqd_yn=="N"){
				if (frmObj.from_date.value!="" && frmObj.theatre_code.value !="" && frmObj.to_date.value!="" ){
					//commit_flag=true; //commented for 44644
				}
			}
			if(generate_by=="TH" || generate_by=="OT"){
				if (frmObj.from_date.value!="" && frmObj.theatre_code.value !="" && frmObj.to_date.value!="" ){						
					//commit_flag=true; //commented for 44644
				}
			}
			if(generate_by=="SG"){
				if (frmObj.from_date.value!="" && frmObj.surgeon_code.value !="" && frmObj.to_date.value!="" ){						
					//commit_flag=true; //commented for 44644
				}
			}
				if (commit_flag==true )
				{		
					var locale = frmObj.locale.value;
					var change_from_date = dateUtils(frmObj.from_date.value,locale); 
					var change_to_date = dateUtils(frmObj.to_date.value,locale); 
					//alert("change_from_date"+from_date.value);
					//alert("change_from_date"+change_from_date);
					
					var params = "theatre_code="+frmObj.theatre_code.value+"&surgeon_code="+frmObj.surgeon_code.value+"&sun="+frmObj.sun.value+"&mon="+frmObj.mon.value+"&tue="+frmObj.tue.value+"&wed="+frmObj.wed.value+"&thu="+frmObj.thu.value+"&fri="+frmObj.fri.value+"&sat="+frmObj.sat.value+"&from_date="+change_from_date+"&to_date="+change_to_date+"&generate_by="+generate_by; 
					//alert("Params passing to servlet : "+params);
					var action="../../servlet/eOT.SurgeonDiaryScheduleServlet?"+params;
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					var xmlStr="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",action,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					//alert("Mesg from Servlet : "+retVal);
					//msg=(retVal=="RECORD_INSERTED")? "Operation Completed Successfully...":"Operation Failed : "+retVal;
					var msg_inserted =  getMessage("RECORD_INSERTED","SM");
					var msg_failed =  getMessage("APP-OT0082","OT");
					msg=(retVal=="RECORD_INSERTED")?msg_inserted :(msg_failed+retVal);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
					if (retVal=="RECORD_INSERTED")
					{

						f_query_add_mod.location.reload();
					}
					
				}
			}//commented for 44644
			else{
					return false;
			}
		}
	}

}


function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

