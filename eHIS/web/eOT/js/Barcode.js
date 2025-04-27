/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function localSearchPatient1(){
  var formObj = document.SlateBarcodeSelectPatientForm;
  var dialogTop  = "40";
  var dialogHeight = "10";
  var dialogWidth  = "40";
  var arguments = "";
  var 	patient_class="";
  var patient_class_desc="";
  var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
  retVal=window.showModalDialog("../../eOT/jsp/OTPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc,arguments,features);
  if(retVal!=null){
	var arr = retVal.split('##');
		formObj.patient_id.value=arr[0];
		formObj.patient_name.value=arr[1];
   }else{
		formObj.patient_id.value='';
		formObj.patient_name.value='';
		formObj.patient_id.value='';//LD00005722 
   }
}
function getBarcodeFunctionString(url_desc,function_id){
	var function_string = "";
	if(url_desc.search("OTCheckIn") == 0 && url_desc.search("OTCheckInToOR") != 0)
			function_string="&function_id=OT_CHECK_IN&function_name=Check-In";
	else if(url_desc.search("OTCheckInToOR") == 0)
			function_string="&function_id=OT_CHECKIN_TO_OR&function_name=Check-In To OR";
	return function_string;
}

async function callBarcodeMenuFunctions(){
	var formObj=document.SlateSearchForm;
	var obj = formObj.scan_vals;
	var locale = document.SlateSearchForm.locale.value;
	var function_id = document.SlateSearchForm.scan_vals.value;
	//var theatre_date = document.SlateSearchForm.theatre_date.value;
	var theatre_date=dateUtils(document.SlateSearchForm.theatre_date.value,locale);
	var theatre_date_from=dateUtils(document.SlateSearchForm.theatre_date_from.value,locale);
	var valid_date = isValidDated(theatre_date);
	var valid_date_from = isValidDated(theatre_date_from);
	if(function_id=="01"){
		//var msg = "Theatre Date > Current Date \n  Check-In is not Allowed!";
		//var msg = getMessage("APP-OT0034");
		var msg_1 = getMessage("APP-OT0034","OT");
		var msgArr = msg_1.split("#");
		var checkIn_value=getLabel("eOT.CheckIn.Label","OT");
		var msg = msgArr[0]+checkIn_value+msgArr[1];
	}else
		//var msg = "Theatre Date > Current Date \n  Check-In to OR is not Allowed! ";
		//var msg = getMessage("APP-OT0035");
		var msg_1 = getMessage("APP-OT0034","OT");
		var msgArr = msg_1.split("#");
		var checkIntoOR_value=getLabel("eOT.CheckIntoOR.Label","OT");
		var msg = msgArr[0]+checkIntoOR_value+msgArr[1];
	if(function_id!="" && valid_date=="Y"){
	var function_name = formObj.scan_vals.options[obj.selectedIndex].text;
	//var slate_user_id = acceptAndValidateUser(function_id,function_name);
	// if error, slate_user_id = NOT_VALID else it will return the new logged in user id
	var slate_user_id="SUPERUSER";
	if(slate_user_id!=null || slate_user_id!="undefined" || slate_user_id!='false'){
	  if(slate_user_id!='NOT_VALID'){
		 var url_desc="";
		 if(function_id=="01"){
		   url_desc="OTCheckIn";
		  }else if(function_id=="05"){
			url_desc="OTCheckInToOR";
		  }
			var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
			var function_string = getBarcodeFunctionString(url_desc,function_id);	
			var db_param = db_param_1 + function_string;
			var url = "SlateBarcodeSelectPatient.jsp?"+db_param+"&url_desc="+url_desc+"&function_id="+function_id+"&called_from=OT_BARCODE&slate_user_id="+slate_user_id+"&theatre_date="+theatre_date+"&theatre_date_from="+theatre_date_from;// comes from ot_functions (database)
			var retVal;
			var dialogHeight= "10" ;  // 7
			var dialogWidth	= "25" ; // 22
			//var dialogTop = (window.screen.availHeight-dialogHeight)/3;//"210" ;
			//var dialogLeft = (window.screen.availWidth-dialogWidth)/4;// "240" ;
			var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";center: yes;status=no;help=no;" ;
			var arguments    = "" ;
			retVal = await window.showModalDialog(url, arguments, features);
			//alert("Line 69-->"+retVal);
			if(retVal!=null && retVal!='CANCEL'&& retVal!="INVALID_PATIENT"){
					retVal=window.showModalDialog(retVal,window,"dialogHeight: 900px; dialogWidth:1000px; center: yes; help: no; resizable: no; status: no;");
		}
		if(retVal=="RECORD_INSERTED")
			top.content.f_query_add_mod.frames[1].frames[1].document.location.reload();
		}//END OF SLATE_USER_ID IF
	  }//END OF SLATE_USER_ID NOT VALID
	}else{
		if(function_id!="")	alert(msg);
	 }
 }


function callBarcodeFunction(){
	var locale = document.forms[0].locale.value;
	var patient_id=trimString(document.forms[0].patient_id.value).toUpperCase();
	var login_user=document.forms[0].login_user.value;
	var url_desc=document.forms[0].url_desc.value;
	var sch_type=document.forms[0].sch_type.value;
	var theatre_date=document.forms[0].theatre_date.value;
	var order_id=document.forms[0].order_id.value;

	
	if(url_desc=="OTCheckIn"){
	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
		return false;
	}
			var booking_num = document.forms[0].appt_ref_num.value;
			if(booking_num.length==0 || booking_num=="" || booking_num=="undefined"){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.ApptRefnum.Label","OT"));
			alert(msg1);
			return false;
		}
	}
	if(url_desc=="OTCheckInToOR"){
		var oper_num = document.forms[0].oper_num.value;
			if(oper_num.length==0 || oper_num=="" || oper_num=="undefined"){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.OperNum.Label","OT"));
			alert(msg1);
			return false;
		}
     
		var appt_ref_num=getApptRefNumForSchCase(oper_num);
		var	param="patient_id="+patient_id+"&oper_num="+oper_num+"&booking_no="+appt_ref_num+"&access=NYNNY&function_id=OT_CHECKIN_TO_OR&function_name=Check-In To OR&home_required_yn=N&slate_user_id="+login_user+"&theatre_date="+convertDate(theatre_date,'DMY','en',locale)+"&order_id="+order_id;
		var url="../../eOT/jsp/OTCheckInToOR.jsp?"+param;
	}else if(url_desc=="OTCheckIn"){
		var	param="patient_id="+patient_id+"&booking_no="+booking_num+"&access=NYNNY&function_id=OT_CHECK_IN&function_name=Check-In&home_required_yn=N&slate_user_id="+login_user+"&called_from=OT_SLATE&booking_num="+booking_num+"&order_id="+order_id;
		var url='../../eOT/jsp/OTCheckIn.jsp?'+param;
	 }	
	//alert(url);
	//retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	window.returnValue = url;
	window.close();	 
}
function getBarcodeFunctionString(url_desc,function_id){
	var function_string = "";
	if(url_desc.search("OTCheckIn") == 0 && url_desc.search("OTCheckInToOR") != 0)
			function_string="&function_id=OT_CHECK_IN&function_name=Check-In";
	else if(url_desc.search("OTCheckInToOR") == 0)
			function_string="&function_id=OT_CHECKIN_TO_OR&function_name=Check-In To OR";
	return function_string;
}
/*function getBookingNumForSchCase(url_desc,patient_id,theatre_date){
	if(url_desc=="OTCheckIn")
		var sql="select appt_ref_num from OT_SCHD_OPERS_VW where patient_id='"+patient_id+"' and APPT_DATE = to_date('"+theatre_date+"','DD/MM/YYYY') and OPER_STATUS IN('10','15','20','25','30','35')";
	else if(url_desc=="OTCheckInToOR")
		var sql="select oper_num from OT_SCHD_OPERS_VW where patient_id='"+patient_id+"' and APPT_DATE = to_date('"+theatre_date+"','DD/MM/YYYY') and OPER_STATUS IN('40','45')";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = checkReturnString(xmlHttp.responseText);
	//alert("RETVAL"+retVal);
	return retVal;
}
*/

function getApptRefNumForSchCase(oper_num){
	var sql="SELECT BOOKING_NUM FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"'";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = checkReturnString(xmlHttp.responseText);
	//alert("RETVAL"+retVal);
	return retVal;
}

function isValidDated(theatre_date){
	var sql="select decode(SIGN(to_date('"+theatre_date+"','DD/MM/YYYY')-TRUNC(SYSDATE)),1,'N','Y') FROM DUAL";
	//alert(sql);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	//alert(param);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = checkReturnString(xmlHttp.responseText);
	//alert("RETVAL"+retVal);
	return retVal;
}

function checkReturnString(str){
	var valid_str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:@#";
	var checked_str = "";
	for(var jj=0;jj<str.length;jj++){
		if( valid_str.indexOf( str.charAt(jj) )!=-1 )
			checked_str+=str.charAt(jj);
	}
	//alert(checked_str);
	return checked_str;
 }

 function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function closeWindow(){
	window.returnValue="CANCEL";
	window.close();
	//parent.window.close();
}

function changeUpperCase(obj){
	var trim_str = trimString(obj.value);
	obj.value = trim_str.toUpperCase();
}


//newly created for CRF 357 by rajesh on 16/04/2009

function searchApptRefNum(){

	var patient_id=trimString(document.forms[0].patient_id.value).toUpperCase();
	var theatre_date=document.forms[0].theatre_date.value;
	var theatre_date_from=document.forms[0].theatre_date_from.value;
	var url_desc=document.forms[0].url_desc.value;
	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
		return false;
	}
	var sql=escape("SELECT APPT_REF_NUM FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID=? AND APPT_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND OPER_STATUS IN('10','15','20','25','30','35')");
	var dir_param = "sql="+sql+"&theatre_date_from="+theatre_date_from+"&theatre_date_to="+theatre_date+"&patient_id="+patient_id+"&func_id=Chk_In";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTApptRefNumSearchResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	

	
	if(retVal=="1"){
		document.forms[0].appt_ref_num.value	=retVal;
	}else{
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		return_value=window.showModalDialog("../../eOT/jsp/OTApptRefSearchFrames.jsp?func_id=Chk_In&theatre_date_from="+theatre_date_from+"&theatre_date_to="+theatre_date+"&patient_id="+patient_id,arguments,features);
		if(return_value!=null){
			var retVal_arr = return_value.split("##");
			document.forms[0].appt_ref_num.value	=retVal_arr[1];
			document.forms[0].order_id.value	=retVal_arr[2];
		}
	}
}


//newly created for CRF 357 by rajesh on 16/04/2009

function searchOperNum(){
	var patient_id=trimString(document.forms[0].patient_id.value).toUpperCase();
	var theatre_date=document.forms[0].theatre_date.value;
	var theatre_date_from=document.forms[0].theatre_date_from.value;
	var url_desc=document.forms[0].url_desc.value;
	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
		return false;
	}
	var sql=escape("SELECT OPER_NUM FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID=? AND APPT_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND OPER_STATUS IN('40','45')");
	var dir_param = "sql="+sql+"&theatre_date_from="+theatre_date_from+"&theatre_date_to="+theatre_date+"&patient_id="+patient_id+"&func_id=Chk_InTo_OR";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTApptRefNumSearchResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal=="1"){
		document.forms[0].appt_ref_num.value	=retVal;
	}else{
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		return_value=window.showModalDialog("../../eOT/jsp/OTApptRefSearchFrames.jsp?func_id=Chk_InTo_OR&theatre_date_from="+theatre_date_from+"&theatre_date_to="+theatre_date+"&patient_id="+patient_id,arguments,features);
		if(return_value!=null){
			var retVal_arr = return_value.split("##");
			document.forms[0].oper_num.value	=retVal_arr[1];
			document.forms[0].order_id.value	=retVal_arr[2];
		}
	}
}



function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patient_id.value;
	var function_id=formObj.function_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patient_id.value="";
	if(function_id=="OT_CHECK_IN")
	formObj.appt_ref_num.value="";
}

function localTrimString(sInString) {
  //sInString = sInString.replace( /^\s+/g, "" );// strip leading space
  //return sInString.replace( /\s+$/g, "" );// strip trailing space
  return sInString.replace(/^\s+|\s+$/g,"");
}

//newly created for CRF 357 by rajesh on 16/04/2009

function callPatSearch(){
	var formObj=document.forms[0];
	var patient_id = formObj.patient_id;
	var return_value =	"";
	return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	//alert(retVal);
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			formObj.patient_id.focus();
			return
	}
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
	}
}
