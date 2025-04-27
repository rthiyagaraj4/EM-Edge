/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result1			= false;         
var message1		= "";
var flag1			= "";
var INT				= "Integer" ;
var LONG			= "Long"    ;
var FLOAT			= "Float"   ;
var DOUBLE			= "Double"  ;
var STRING			= "String"  ;
var CODE_LINK		= "1"   ;
var DESC_LINK		= "2"   ;
var CODE_DESC_LINK  = "1,2" ;
var ca_module_yn	= "Y"; // Constant to check CA-OR module existence. If CA-OR exists, value is 'Y', otherwise its 'N'
/*
    1 - Code Link, 2 - Desc Link
*/

var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;

var radioval		= "D";

var firstCodeVal	= "" ;
var firstDescVal	= "" ;

//PANDIAN MODIFIED APPLY METHOD

function reset(){
	var header_frame=parent.header_frame;
	if(header_frame!=null){
		var params = header_frame.document.forms[0].params.value;
		header_frame.document.location.href = "../../eOT/jsp/OperationProcedureHdr.jsp?"+params;
		message_search_frame.document.location.href = "../../eOT/jsp/OperationCommonFrame.jsp?"+params;	
		messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?"+params;
	}else{
		var frameObj=frames[1].frames[1].frames[1];
		if(frameObj.name=="f_query_add_mod"){
			frameObj.document.forms[0].reset();
			frames[1].frames[1].frames[2].document.location.href ="../../eCommon/html/blank.html";
		}else{
			frames[1].frames[1].frames[1].document.location.href ="../../eCommon/html/blank.html";
		}
	}
}

async function apply(){
	var headFrm=parent.header_frame;
	var sex_value='';
	if(headFrm != null && headFrm !='') {
	var formObj = headFrm.document.PreOperHdr;
	var physician_code    = formObj.surgeonCode.value;
	var physician_desc    = formObj.surgeonName.value;
	var speciality_code = formObj.SPECIALITY_CODE.value;
	var speciality_desc = formObj.SPECIALITY_DESC.value;
	speciality_desc=encodeURIComponent(speciality_desc);
	var booking_date_time    = formObj.booking_date.value+" "+formObj.start_time.value;
	var med_serv_code   =    getMedicalServiceCode(speciality_code);
	var patient_id      =    formObj.patient_id.value;
	var locale      =    formObj.locale.value;
	//again converting back to the english and assingning to that field before submitting the form
	formObj.booking_date.value =   convertDate(formObj.booking_date.value,'DMY',locale,'en') ;
	var parametrs = "call_func=OT&Patient_Id="+patient_id+"&medical_service="+med_serv_code+"&booking_date_time="+booking_date_time+"&medical_speciality_desc="+speciality_desc+"&medical_speciality_code="+speciality_code+"&physician_desc="+physician_desc+"&physician_code="+physician_code;
	sex_value=formObj.sex.value;
	if(funsubmitCheckInDtls()==true){
		var obret=formApply(formObj,OT_CONTROLLER);
		//alert(obret);
		eval(obret);
		message1=message1.replace('<br>','');
		if(flag1==0){
			var msgFrame=parent.messageFrame;
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage(message1,"OT");
		}else{
				alert(getMessage(localTrimString(message1),"SM"));
				var booking_num = flag1;
				var dialogHeight	= "11" ;
				var dialogWidth	= "25" ;
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
				var url = "../../eOT/jsp/BookingReports.jsp";		
				if(sex_value.charAt(0)=='M')   sex_value="M";
				else if(sex_value.charAt(0)=='F')	  sex_value="F";
				else	 sex_value="U";
				url=url+"?booking_num="+booking_num+"&sex="+sex_value;
				//var formObj1 = headFrm.document.PreOperHdr;
				//var patient_id = formObj1.patient_id.value;
				if(formObj.ip_booking_yn.value=='Y') 	      			
					openIPDialog(parametrs);
				retVal 	   = await window.showModalDialog(url, arguments, features);
				parent.window.returnValue=1;
				parent.window.close();
		 }
		}
	}else{
	var msgFrame=parent.messageFrame;
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
   }
}

function getMedicalServiceCode(speciality_code){
	var locale = parent.header_frame.document.PreOperHdr.locale.value;
	var sql="SELECT MED_SER_GRP_CODE MEDICAL_SERVICE FROM OT_SPECIALITIES A, AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = '"+speciality_code+"' AND A.SPECIALITY_CODE  = B.SPECIALITY_CODE";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}

function getSurgeonSpeicality( surgeon_code ){
	var locale = document.forms[0].locale.value;
	var sql="SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID = '"+surgeon_code+"'";
	var xmlDoc = "" ;
	xmlDoc.async = false;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}

function getSurgSpecialityDesc( speciality_code ){
	var locale = document.forms[0].locale.value;
	var sql="SELECT SHORT_DESC  FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND SPECIALITY_CODE = '"+speciality_code+"'";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = (xmlHttp.responseText);
	return retVal;
}

	
function showSlipDialog(){
	var dialogHeight 		= "40";
	var dialogWidth  		= "40";
	var dialogTop   		= "100";
	var dialogLeft   		= "50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/BookingSlip.jsp?",arguments,features);
}

function CheckMandatoryFields(){
	var submitflag = 'false';
	var messageFrame = parent.messageFrame;
	var formObj = document.frames.cancel_checkIn_frame.document.CancelCheckInForm;
	var fields= new Array(formObj.reason_desc);
	//var names=new Array("Reason");	
	var names=new Array(getLabel("eOT.Reason.Label","OT"));	
	if(checkFields(fields,names,messageFrame)){
		submitflag=true;
	}else{
		submitflag=false;
	}
	return submitflag;
}


function assignResult( _result, _message, _flag){
  result1 = _result;
  message1  = _message;
  flag1 = _flag;
} 

function beforePost(str){}
function callAuthorization(obj,msg,msg_text,called_from){
	alert(msg_text);
	if(msg.search("cancel Transfer booking")>=0){
		parent.parent.frames[0].location.href="../../eCommon/html/blank.html";
		parent.parent.frames[1].location.href="../../eCommon/html/blank.html";
		obj.document.forms[0].home.click();
	}else{
	    if(obj!=null){
			parent.parent.parent.frames[0].location.href="../../eCommon/html/blank.html";
			parent.parent.parent.frames[1].location.href="../../eCommon/html/blank.html";
			obj.document.forms[0].home.click();
		}else{
			parent.parent.frames[0].location.href="../../eCommon/html/blank.html";
			parent.parent.frames[1].location.href="../../eCommon/html/blank.html";
			if(called_from=="OR")
				window.close()
			else
				parent.parent.frames[0].document.forms[0].home.click();
		}
	 }
  }

function funOTCheckDetail1(flag,flg,locale){
if(flag=='Anesthetist')		 callAnesthetist(locale);
else if(flag=='Anesthesia')	 callAnesthesia(locale);
else if(flag=='Position')	 callPosition(locale);
else if(flag=='Surgeon')	 callSurgeon(locale);
else if(flag=='SurgeonSplty') callSurgeonSplty(locale);
else if(flag=='Speciality')  callSpeciality(locale);
else if(flag=='Speciality1') callSpeciality(locale);
else if(flag=='SurgeryType') callSurgeryType(locale);
else if(flag=='Operation')	 callOperation(locale);
else if(flag=='OperationSplty') callOperationSplty(locale);
else if(flag=='Procedure')   callProcedure(locale);
else if(flag=='SourceType')  callSourceType(locale);
else if(flag=='CurrStage')   callCurrentStage(locale);
else if(flag=='TheatreType') callTheatreType(locale);
else if(flag=='Theatre')	 callTheatre(flg,locale);
else if(flag=='orderid')	 callOrderId(locale);
else if(flag=='Reason')		 callReasonCode(locale);
else if(flag=='WaitlistReason') callReasonCode('1',locale);
else if(flag=='Transfer')    callTransfer(locale);
else if(flag=='OrderCategory') callOrderCategory(locale);
else if(flag=='OrderType') callOrderType(locale);
else if(flag=='Catalog')    callCatalog(locale);
else if(flag=='Reshedule') callReshedule(locale);
else if(flag=='WaitList')  callWaitList(locale);
else if(flag='ItemSelect') callItemSelect(locale);
}


function callItemSelect(locale){
	var column_sizes = escape("60%,20%");       
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);  
	var sql;
	var obj=document.forms[0];
	if(obj.item_type.value=='I')
		// Code altered by rajesh for PHASE 3.
		//sql=escape("SELECT SHORT_DESC ITEM_DESC1,INSTR_CODE ITEM_ID1 FROM OT_INSTRUMENT_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E'");
		sql=escape("SELECT LONG_DESC ITEM_DESC1,INSTR_CODE ITEM_ID1 FROM OT_INSTRUMENT_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E'");
	else if(obj.item_type.value=='E')
		//Code altered by Selvam for PHASE 3 Delivery
		//sql=escape("SELECT SHORT_DESC ITEM_DESC1,EQUIPMENT_CODE ITEM_ID1 FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID ='"+locale+"'  AND NVL(STATUS,'E') = 'E'");
		sql=escape("SELECT LONG_DESC ITEM_DESC1,EQUIPMENT_CODE ITEM_ID1 FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID ='"+locale+"'  AND NVL(STATUS,'E') = 'E'");
	else if(obj.item_type.value=='P')
		//Code altered by Selvam for PHASE 3 Delivery
		//sql=escape("SELECT SHORT_DESC ITEM_DESC1,PACKAGE_CODE ITEM_ID1 FROM OT_PACKAGE_HDR WHERE  NVL(STATUS,'E') = 'E'");
		sql=escape("SELECT SHORT_DESC ITEM_DESC1,PACKAGE_CODE ITEM_ID1 FROM OT_PACKAGE_HDR WHERE  NVL(STATUS,'E') = 'E'");
	else if(obj.item_type.value=='S')
		sql=escape("SELECT SHORT_DESC ITEM_DESC1,PROSTHESIS_CODE ITEM_ID1 FROM OT_PROSTHESIS WHERE  NVL(STATUS,'E') = 'E'");
	else{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.Itemtype.label","Common")+msgArray[1]);
		return false;
	}
	//var title='Source Type Search';
	var title=getLabel("eOT.SourceType.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.item_desc.value=arr[0];
		obj.item_id.value=arr[1];
	}else{
		obj.item_desc.value='';
		obj.item_id.value='';
	}
}

function callWaitList(locale){
	var column_sizes = escape("10%,10%,30%,5%,10%,10%,10%");
	// Modified by Selvam 24-Oct-06
	//var column_descriptions = escape("Waitlist,Patient Id,Patient Name,Sex,DOB,Surgeon,Preferred Date");  
	var tit = getLabel('Common.WaitList.label','Common')+','+getLabel('Common.patientId.label','Common')+','+getLabel('Common.PatientName.label','Common')+','+getLabel('Common.gender.label','Common')+','+getLabel('Common.DateofBirth.label','Common')+','+getLabel('eOT.Surgeon.Label','OT')+','+getLabel('Common.PreferredDate.label','Common');
	var column_descriptions = encodeURIComponent(tit);  
	var frmObj=document.forms[0];
	var facilityid=frmObj.facility_id.value;
	var booking_no=frmObj.booking_no.value;
	var duration=frmObj.booking_duration.value;
	var booking_date=frmObj.booking_date.value;
	var waitlist_no=frmObj.waitlist_no.value;
	//commented by subramanian on 01/08/2005
	//var sql=escape("SELECT WAITLIST_NUM WAITLIST_NUM1, PREFERRED_DATE PREFERRED_DATE1 FROM OT_WAITLISTING  WHERE OPERATING_FACILITY_ID='"+facilityid+"' AND STATUS = 'P' AND BOOKING_NUM <> '"+booking_no+"' AND TRUNC(BOOKING_DATE) > TRUNC(to_date('"+booking_date+"','dd/mm/yyyy')) AND TO_NUMBER(TO_CHAR(BOOKING_DURATION,'SSSSS'))<= TO_NUMBER(TO_CHAR(to_date('"+duration+"','hh24:mi'),'SSSSS'))");
	var sql=escape("SELECT A.WAITLIST_NUM WAITLIST_NUM1, A.PATIENT_ID PATIENT_ID1,  B.PATIENT_NAME PATIENT_NAME1, DECODE(B.SEX,'M','MALE','F','FEMALE','U','UNKNOWN') SEX1, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH1, A.TEAM_DOCTOR_CODE TEAM_DOCTOR_CODE1, NVL(A.PREFERRED_DATE,A.BOOKING_DATE) PREFERRED_DATE1 FROM OT_WAITLISTING A, MP_PATIENT B WHERE A.OPERATING_FACILITY_ID = '"+facilityid+"' AND     A.PATIENT_ID = B.PATIENT_ID AND A.STATUS = 'P' AND  A.BOOKING_NUM <> '"+booking_no+"' AND  TRUNC(A.BOOKING_DATE)  > TRUNC(to_date('"+booking_date+"','dd/mm/yyyy')) AND      TO_NUMBER(TO_CHAR(A.BOOKING_DURATION,'SSSSS'))<= TO_NUMBER(TO_CHAR(to_date('"+duration+"','hh24:mi'),'SSSSS'))");

	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
	var title=getLabel('Common.WaitList.label','Common');
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		frmObj.waitlist_no.value=arr[0];
	}else{
		//	frmObj.waitlist_no.value="";
		frmObj.waitlist_no.value=waitlist_no;
	}	
	var param1="facility_id="+facilityid+"&waitlist_no="+frmObj.waitlist_no.value+"&booking_no="+booking_no;
	parent.detailframe.location.href="../../eOT/jsp/WaitListProcedureFrame.jsp?"+param1;
	frmObj.submit();
}


function searchreasonforresch(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var frmObj=document.forms[0];
	//var sql="select short_desc DESCRIPTION,ANAESTHESIA_CODE CODE from AM_ANAESTHESIA where NVL(Eff_Status,'X')='E' AND upper(short_desc) like upper(?) AND upper(ANAESTHESIA_CODE) like upper(?) order by 2";
	var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND upper(REASON_DESC) like upper(?) AND upper(REASON_CODE) like upper(?) order by 2 " ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eOT.RescheduleReason.Label","OT"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].reason_desc.value = returnedValues[1];
		document.forms[0].reason_code.value = returnedValues[0];	
	}else{
		document.forms[0].reason_desc.value = '';
		document.forms[0].reason_code.value = '';	
	}
}

function callReshedule(locale){
	var column_sizes = escape("60%,40%");               
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	//var sql=escape("select SHORT_DESC SHORT_DESC1,LOCN_TYPE LOCN_TYPE1  from AM_CARE_LOCN_TYPE where CARE_LOCN_TYPE_IND='O'");
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");

	//var title='Reschedule Reason Search';
	var title=getLabel("eOT.RescheduledReason.Label","OT");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		obj.reason_desc.value=arr[0];
		obj.reason_code.value=arr[1];
	}else{
		obj.reason_desc.value="";
		obj.reason_code.value="";
	}
}

function callOrderType(locale){
	var locale = document.forms[0].locale.value;
	var column_sizes = escape("70%,30%");               
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT SHORT_DESC  SHORT_DESC1, ORDER_TYPE_CODE ORDER_TYPE_CODE1 FROM OR_ORDER_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY = '"+obj.order_catagory.value+"'");
	var title=getLabel("Common.OrderType.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		obj.order_type_desc.value=arr[0];
		obj.order_type_code.value=arr[1];
		obj.catalogbut.disabled=false;
	}else{
		obj.order_type_desc.value="";
		obj.order_type_code.value="";
		obj.catalogbut.disabled=true;
	}
}


function callCatalog(locale)
{
var locale = document.forms[0].locale.value;
var column_sizes = escape("70%,30%");               
var obj=document.forms[0];

// Modified by Selvam 24-Oct-2006
var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit); 

if(obj.order_type_code.value==''){
	//alert(getMessage("ORDER_TYPE_NULL"));
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	alert(msgArray[0]+getLabel("Common.OrderType.label","Common")+msgArray[1]);
	return;
}
var sql=escape("SELECT SHORT_DESC SHORT_DESC1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1 FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN ('RD','RL') AND ORDER_CATEGORY = DECODE('"+obj.order_catagory.value+"','*A',ORDER_CATEGORY, '"+obj.order_catagory.value+"') AND ORDER_TYPE_CODE = NVL('"+obj.order_type_code.value+"', ORDER_TYPE_CODE) AND NVL(EFF_STATUS,'S') ='E'");
//var title='OrderType Search';
var title=getLabel("Common.OrderType.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
retVal=callDialog(param);
retVal=checkNull(retVal);
if(retVal!=''){
	arr=retVal.split("::");
	obj.catalog.value=arr[0];
	obj.order_catalog_code.value=arr[1];
}else{
	obj.catalog.value="";
	obj.order_catalog_code.value="";
}

}


function callOrderId(locale)
{
var column_sizes = escape("70%,30%");               
var obj=document.forms[0];

// Modified by Selvam 24-Oct-2006
var tit = getLabel('eOT.OrderID.Label','OT')+','+getLabel('eOT.OrderDateTime.Label','OT');
var column_descriptions = encodeURIComponent(tit); 
var sql=escape("SELECT ORDER_ID ORDER_ID1, to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') ORDER_DATE_TIME1 FROM OT_PENDING_ORDER WHERE PERFORMING_FACILITY_ID ='"+obj.facility_id.value+"'");
//var title='OrderId Search';
var title=getLabel("eOT.OrderID.Label","OT")
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].orderid.value;
retVal=callDialog(param);

retVal=checkNull(retVal);
if(retVal!='')
	{
arr=retVal.split("::");
obj.orderid.value=arr[0];
	}
else
	{
obj.orderid.value="";
	}
}

function funPendingSearch(){
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	//	var sql="SELECT PATIENT_ID PATIENT_ID1,PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,SHORT_NAME SHORT_NAME1, SEX SEX1, SURGERY_NATURE_DESC SURGERY_TYPE1, SPECIALITY_DESC SPECIALITY_DESC1, TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, ORDER_ID ORDER_ID1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1 FROM OT_PENDING_ORDERS_VW   WHERE PERFORMING_FACILITY_ID = '"+frmObj.facility_id.value+"'";

	// added by rajesh for from/to date thai conversion
		var change_from_date = dateUtils(frmObj.from_date.value,locale); 
		var change_to_date = dateUtils(frmObj.to_date.value,locale);
		if(!callDateCheck(change_from_date,change_to_date)) return;

if(frmObj.from_date.value!=''){
	var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,B.SHORT_DESC OPER_DESC1  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B  WHERE B.ORDER_CATALOG_CODE IN (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1) AND A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' AND B.LANGUAGE_ID='"+locale+"' ";
	var where=" ";
   if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
		where=escape(" and A.SPECIALITY_CODE ='"+frmObj.SPECIALITY_CODE.value+"'");
   if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='')
		where+=escape(" and A.PERFORMING_TEAM_SURGEON ='"+frmObj.SURGEON_CODE.value+"'");
	if(frmObj.orderid.value!=null && frmObj.orderid.value!='')
		where+=escape(" and A.ORDER_ID ='"+frmObj.orderid.value+"'");
	if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
		where +=escape(" AND A.PREF_SURG_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");
/*
	if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
     where +=escape(" AND TO_CHAR(PREF_SURG_DATE,'DD/MM/YYYY') BETWEEN NVL(TO_CHAR('"+frmObj.from_date.value+"','DD/MM/YYYY'),'01/01/1900') AND NVL(TO_CHAR('"+frmObj.to_date.value+"','DD/MM/YYYY'),'01/01/3000') ");
*/

	if(frmObj.patientid.value!=null && frmObj.patientid.value!='')   
		where+=escape(" and PATIENT_ID ='"+frmObj.patientid.value+"'");
	else
		if(frmObj.patientName.value!=null&&frmObj.patientName.value!='') 
			where+= escape(" and short_name like '"+frmObj.patientName.value+"%'");
	sql+=where;  
	
	var param='sql='+sql+'&surgeonCode='+frmObj.SURGEON_CODE.value+
	'&checkin_booking_flag='+frmObj.checkin_booking_flag.value;

	//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;	
	parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtlFrame.jsp?'+param;	
}else{
	//alert("APP-OT1 From Date Cannot be Blank");
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
}

function validateMandatory(obj,validatStr,dispStr,messageFrame){
	var mandObj;
	var errors="";
	var cou=0;
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	for(cou=0;cou<validatStr.length;cou++){
		var mandObj=eval("obj."+validatStr[cou]);
		if(mandObj.value==null || mandObj.value==''){
			//errors = errors + "APP-000001 " + dispStr[cou] + " cannot be blank..." + "<br>" ;
			errors = errors + msgArray[0]+ dispStr[cou] + msgArray[1] + "<br>" ;
		}
    }	
	if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;	
        return false ;
    }
    return true ;
}

function searchsourcetype(obj){
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var obj1=document.forms[0];
	var locale = obj1.locale.value;
	if(obj1.sourceType.value=='W'){
		// Code altered by Selvam for PHASE 3 Delivery
		//sql="SELECT SHORT_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+obj1.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
		sql="SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+obj1.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
	}else if(obj1.sourceType.value=='C'){
		//sql="SELECT SHORT_DESC DESCRIPTION, CLINIC_CODE CODE FROM   OP_CLINIC WHERE   FACILITY_ID = '"+obj1.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
		// Code altered by Selvam for PHASE 3 Delivery
		//sql="SELECT SHORT_DESC DESCRIPTION, CLINIC_CODE CODE FROM OP_CLINIC_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+obj1.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
		sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM OP_CLINIC_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+obj1.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?)  ORDER BY 1" ;
	}else if(obj1.sourceType.value=='E'){
		// code altered for PHASE 3 Delivery by rajesh
//		sql="SELECT SHORT_DESC  DESCRIPTION, REFERRAL_CODE  CODE FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(REFERRAL_CODE) like upper(?)  order by 1" ;
		sql="SELECT LONG_DESC  DESCRIPTION, REFERRAL_CODE  CODE FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(REFERRAL_CODE) LIKE UPPER(?)  ORDER BY 1" ;
	}else{
		 //alert("Source type cannot be NULL");
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+getLabel("eOT.SourceType.Label","OT")+msgArray[1]);
		 return false;
	}
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eOT.SourceType.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//obj.value = returnedValues[1];
		obj1.sourceDesc.value=returnedValues[0];
		obj1.Source_code.value=returnedValues[1];

	} 
	else{
		obj1.sourceDesc.value="";
		obj1.Source_code.value="";
	}
}

function callSourceType(locale){
	var locale = document.forms[0].locale.value;
	var column_sizes = escape("60%,20%");   
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);  
	var sql;
	var obj=document.forms[0];

	if(obj.sourceType.value=='W'){
		// Code altered by Selvam for PHASE 3 Delivery
		//sql=escape("SELECT SHORT_DESC SHORT_DESC1, NURSING_UNIT_CODE NURSING_UNIT_CODE1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
		sql=escape("SELECT LONG_DESC SHORT_DESC1, NURSING_UNIT_CODE NURSING_UNIT_CODE1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
	}else if(obj.sourceType.value=='C'){
		//sql=escape("SELECT SHORT_DESC SHORT_DESC1, CLINIC_CODE CLINIC_CODE1 FROM   OP_CLINIC WHERE   FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
		// Code altered by Selvam for PHASE 3 Delivery
		//sql=escape("SELECT SHORT_DESC SHORT_DESC1, CLINIC_CODE CLINIC_CODE1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'  AND FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
		sql=escape("SELECT LONG_DESC SHORT_DESC1, CLINIC_CODE CLINIC_CODE1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'  AND FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
	}else if(obj.sourceType.value=='R'){
		//Code altered by rajesh for PHASE 3 Delivery 
//		sql=escape("SELECT SHORT_DESC  SHORT_DESC1, REFERRAL_CODE  REFERRAL_CODE1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
sql=escape("SELECT LONG_DESC  SHORT_DESC1, REFERRAL_CODE  REFERRAL_CODE1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	}else{
		//alert("Source type cannot be NULL");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("eOT.SourceType.Label","OT")+msgArray[1]);
		return false;
	}
	//var title='Source Type Search';
	var title=getLabel("eOT.SourceType.Label","OT")
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.sourceDesc.value=arr[1];
		obj.Source_code.value=arr[0];
	}else{
		obj.sourceDesc.value="";
		obj.Source_code.value="";
	}
}
function callProcedure(locale){
	var column_sizes = escape("50%,25%,25%");     
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('eOT.OperationCode.Label','OT')+','+getLabel('Common.SpecialityCode.label','Common');
//	var column_descriptions = escape("Description,Operation Code,Speciality Code");  
	var column_descriptions = encodeURIComponent(tit);  

	var sql;
	var obj=document.forms[0];
	sql=escape("SELECT SHORT_DESC SHORT_DESC1, OPER_CODE OPER_CODE1, SPECIALITY_CODE OPER_SPLTY_CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'");
	//var title='Procedure Search';
	var title=getLabel("Common.Procedure.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].PROCEDURE.value;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	//alert(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.PROCEDURE.value=arr[0];
		obj.oper_code.value=arr[1];
		obj.SPECIALITY_CODE.value=arr[2];
		obj.SPECIALITY_DESC.value=getSurgSpecialityDesc(arr[2]);
	}else{
		obj.PROCEDURE.value='';
		obj.SPECIALITY_CODE.value='';
		obj.oper_code.value='';
	}
}
function callOperationSplty(locale){
	var column_sizes = escape("40%,20%,10%,20%,10%");   
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.operation.label','Common')+','+getLabel('eOT.OperationCode.Label','OT')+','+getLabel('eOT.SideApplicable.Label','OT')+','+getLabel('Common.OrdercatalogCode.label','Common')+','+getLabel('Common.SpecialityCode.label','Common');
	//var column_descriptions = escape("Operation,Operation Code,Side Applicable,Catalog Code,Speciality Code");  
	var column_descriptions = encodeURIComponent(tit);  
	var sql="SELECT SHORT_DESC SHORT_DESC1,OPER_CODE OPER_CODE1  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'";

	var frmObj=document.forms[0];
	if(frmObj.SPECIALITY_CODE.value !='' && frmObj.SPECIALITY_CODE.value !=null)
		sql+="and SPECIALITY_CODE='"+frmObj.SPECIALITY_CODE.value+"'";
	sql=escape(sql);
	//var title='Operation Search';
	var title=getLabel("Common.operation.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		frmObj.operation_desc.value=arr[0];
		frmObj.oper_code.value=arr[1];
	}else{
		frmObj.operation_desc.value='';
		frmObj.oper_code.value='';
	}
}

function callOperation(locale){
	var column_sizes = escape("40%,20%,10%,20%,10%");             
	
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.operation.label','Common')+','+getLabel('eOT.OperationCode.Label','OT')+','+getLabel('eOT.SideApplicable.Label','OT')+','+getLabel('Common.OrdercatalogCode.label','Common')+','+getLabel('Common.SpecialityCode.label','Common');
	//var column_descriptions = escape("Operation,Operation Code,Side Applicable,Catalog Code,Speciality Code");  
	var column_descriptions = encodeURIComponent(tit);   
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1,OPER_CODE OPER_CODE1, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'");
	//var title='Operation Search';
	var title=getLabel("Common.operation.label","Common");
	title=encodeURIComponent(title); 
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		obj.operation_desc.value=arr[0];
		obj.oper_code.value=arr[1];
		if(arr[2]!='Y'){
			obj.appl_right_left_flag.disabled=true;		
			obj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else		
		obj.appl_right_left_flag.disabled=false;
		obj.appl_right_left_flag.Mandatory=arr[2];
		obj.appl_right_left_flag.value=arr[2];
		var dtDetails=getDurationDtl(arr[3]);
		dtDetails=trimValue(dtDetails);
		var dt=new Array();
		dt=dtDetails.split("::");
		obj.duration.value=dt[0];
		obj.f_duration.value=dt[1];
		obj.stdduration.value=dt[0];
		dtDetails=getAvgTime(obj.surgeonCode.value,arr[1]);
		dtDetails=trimValue(dtDetails);
		obj.avgTime.value=dtDetails;   
		obj.speciaitycode.value=arr[4];
		obj.specialityCollect.value+=arr[4]+",";	
	}else{
		obj.operation_desc.value='';
		obj.stdduration.value='';
		obj.oper_code.value='';
		obj.appl_right_left_flag.value='';
	}
}
function trimValue(dtDetails){
	var cou=dtDetails.indexOf(":");
	var msg='';
	for(var ii=cou-2;ii<dtDetails.length;ii++)
	msg+=dtDetails.charAt(ii);
	return msg;
}
function callSurgeryType(locale){
	var column_sizes = escape("60%,20%,10%");        

	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('eOT.SurgeryType.Label','OT')+','+getLabel('eOT.NatureCode.Label','OT')+','+getLabel('eOT.NatureType.Label','OT');
	//var column_descriptions = escape("Surgery Type,Nature code,Nature type");  
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, NATURE_CODE  NATURE_CODE1, NATURE_TYPE NATURE_TYPE1 FROM OT_NATURE_OF_SURGERY WHERE NVL(STATUS,'E') = 'E'");
	//var title='Surgery Type Search';
	var title=getLabel("eOT.SurgeryType.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		obj.surgeonType.value=arr[0];
		obj.natureCode.value=arr[1];
		obj.natureType.value=arr[2];	
	}else{
		obj.surgeonType.value="";
		obj.natureCode.value="";
		obj.natureType.value="";
	}
}
function getAvgTime(surgCode,operCode){
	var flag='2';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	param="surgeonCode="+surgCode+"&operationCode="+operCode+"&flag="+flag;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/CollectDuration.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	return retVal;
}
function getDurationDtl(objVal){
	var flag='1';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	param="catalog_code="+objVal+"&flag="+flag;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/CollectDuration.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	//alert(retVal);
	return retVal;
}
function callAnesthetist(locale){
	var column_sizes = escape("60%,30%");               
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.name.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	//var column_descriptions = escape("Name,Code"); 
	var sql=escape("SELECT SHORT_NAME SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj.locale.value+"' AND  PRACT_TYPE IN ('AN') AND  NVL(EFF_STATUS,'X') <> 'S'");
	//var title='Anaesthetist Search';
	var title=getLabel("eOT.Anaesthetist.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		obj.Anaesthetiest2_code.value=arr[0];
		obj.Anaesthetiest1_code.value=arr[1];
	}else{
		obj.Anaesthetiest1_code.value="";
		obj.Anaesthetiest2_code.value="";
	}
}
function searchanaesthesia(obj){
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql="select short_desc DESCRIPTION,ANAESTHESIA_CODE CODE from AM_ANAESTHESIA_LANG_VW where LANGUAGE_ID='"+locale+"' AND NVL(Eff_Status,'X')='E' AND upper(short_desc) like upper(?) AND upper(ANAESTHESIA_CODE) like upper(?) order by 2";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eOT.Anaesthesia.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].Anaesthetia1_code.value = returnedValues[1];
		document.forms[0].Anaesthetia_code.value = returnedValues[0];	
	}else{
		document.forms[0].Anaesthetia1_code.value = '';
		document.forms[0].Anaesthetia_code.value = '';	
	}
}

function callAnesthesia(locale){
	var column_sizes = escape("60%,30%");
	var locale = document.forms[0].locale.value;
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Description ,Code");  
	var sql=escape("select short_desc short_desc1,ANAESTHESIA_CODE ANAESTHESIA_CODE1 from AM_ANAESTHESIA_LANG_VW where LANGUAGE_ID='"+locale+"' AND NVL(Eff_Status,'X')='E'");
	//var title='Anaesthesia Search';
	var title=getLabel("eOT.Anaesthesia.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		obj.Anaesthetia1_code.value=arr[0];
		obj.Anaesthetia_code.value=arr[1];
	}else{
		obj.Anaesthetia1_code.value='';
		obj.Anaesthetia_code.value='';
	}
}

function searchposition(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];
	var locale = document.forms[0].locale.value;
	var sql="";
	var sql="SELECT SHORT_DESC DESCRIPTION,POSITION_CODE CODE FROM OT_POSITION_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(POSITION_CODE) LIKE UPPER(?) ORDER BY 2 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eOT.PatientPosition.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].Position_desc.value = returnedValues[1];
		document.forms[0].Patient_position.value = returnedValues[0];	
	}else{
		document.forms[0].Position_desc.value = '';
		document.forms[0].Patient_position.value = '';
	} 
}

function callPosition(locale){
	var column_sizes = escape("70%,30%");  
	var locale = document.forms[0].locale.value;
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('eOT.PositionCode.Label','OT');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Position Description,Position Code");  
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1,POSITION_CODE POSITION_CODE1 FROM OT_POSITION_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'Y') = 'Y'");
	//var title='Patient Position Search';
	var title=getLabel("eOT.PatientPosition.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.Position_desc.value=arr[0];
		obj.Patient_position.value=arr[1];
	}else{
		obj.Position_desc.value='';
		obj.Patient_position.value=arr[1];
	}
}

function callSurgeonSplty(locale){
	var column_sizes = escape("60%,40%");     
	// Modified by Selvam 24-Oct-2006
	//	var tit = getMessage('Common.description.label','Common')+','+getMessage('eOT.PositionCode.Label','OT');
	//var column_descriptions = escape(tit);
	//var column_descriptions = escape("Surgeon Name,Surgeon Code");  
	 var tit = getLabel('eOT.SpecialityDescription.Label','OT')+','+getLabel('eOT.SpecialityCode.Label','OT');
	 var column_descriptions = encodeURIComponent(tit);
	var obj=document.forms[0];
	var sql= "SELECT SHORT_NAME  SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ";
	if((obj.SPECIALITY_CODE.value != null) && (obj.SPECIALITY_CODE.value !=''))
		sql  = sql + " AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj.facility_id.value+"' AND SPECIALITY_CODE = '"+obj.SPECIALITY_CODE.value+"')";
	sql = escape(sql);
	//var title='Surgeon Search';
	var title=getLabel("eOT.Surgeon.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SURGEON.value;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		document.forms[0].SURGEON.value = arr[0];
		document.forms[0].SURGEON_CODE.value = arr[1];	
	}else{
		document.forms[0].SURGEON.value = '';
		document.forms[0].SURGEON_CODE.value = '';
	}
}

function callSurgeon(locale){
	var column_sizes = escape("60%,40%"); 
	//var column_descriptions = escape("Surgeon Name,Surgeon Code");  
	var surgeon_name=getLabel("eOT.Surgeon.Label","OT")+" "+getLabel("Common.name.label","Common");
	var surgeon_code=getLabel("eOT.Surgeon.Label","OT")+" "+getLabel("Common.code.label","Common");
	var column_descriptions = surgeon_name+","+surgeon_code;//escape("Surgeon Name,Surgeon Code");  
	var sql=escape("SELECT SHORT_NAME  SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+document.forms[0].locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ");
	//var sql=escape("SELECT SHORT_NAME SHORT_NAME1,PHYSICIAN_ID PHYSICIAN_ID1 FROM SY_PHYSICIAN_MAST");
	//var title='Surgeon Search';
	var title=getLabel("eOT.Surgeon.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SURGEON.value;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		document.forms[0].SURGEON.value = arr[0];
		document.forms[0].SURGEON_CODE.value = arr[1];	
		////alert(document.forms[0].SURGEON_CODE.value);
	}else{
		document.forms[0].SURGEON.value = '';
		document.forms[0].SURGEON_CODE.value = '';
	}
}

function callSpeciality(locale){
var locale = document.forms[0].locale.value;
var column_sizes = escape("70%,30%");               

 //Modified by Selvam 25-Oct-2006
 var tit = getLabel('eOT.SpecialityDescription.Label','OT')+','+getLabel('eOT.SpecialityCode.Label','OT');
 var column_descriptions = encodeURIComponent(tit);

//var column_descriptions = escape("Speciality Description ,Speciality Code");  
var sql=escape("SELECT SHORT_DESC SHORT_DESC1,A.SPECIALITY_CODE SPECIALITY_CODE1 FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.EFF_STATUS,'X') = 'E' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE");
var obj=document.forms[0];
//var title='Speciality Search';
var title=getLabel("Common.speciality.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SPECIALITY_DESC.value;
retVal=callDialog(param);

retVal=checkNull(retVal);

	var arr=new Array();

if(retVal!='')
	{
	arr=retVal.split("::");
	document.forms[0].SPECIALITY_DESC.value = arr[0];
	document.forms[0].SPECIALITY_CODE.value = arr[1];	
	}
else
	{
	document.forms[0].SPECIALITY_DESC.value = '';
	document.forms[0].SPECIALITY_CODE.value ='';		
	}
}




function funMoveNext(orderid,surgeonCode,prefDate,objCount,patId){
	//Pending Order Dtl
	//place header and details in frame1 and frame2
	var frmObj=document.forms[0];
	var obStr="frmObj.xx"+objCount+".value";
	var  objS=eval(obStr);

	var param='';
	var	frmObj= document.forms[0];
		if(frmObj.checkin_booking_flag.value=="CHECK_IN"){		
			param="order_id="+orderid+"&surgeon_name="+objS+"&surgeon_code="+surgeonCode+"&surgery_date="+prefDate+"&surgeon_name="+objS+"&called_from=BOOKING&patient_id="+patId;
			/*parent.parent.frames[1].location.href="../../eOT/jsp/CheckInTab.jsp?"+param;
			parent.parent.f_query_add_mod.location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+param;
			*/
			parent.parent.parent.frames[1].location.href="../../eOT/jsp/CheckInTab.jsp?"+param;
			parent.parent.parent.frames[2].location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+param;
			//parent.qa_query_result.location.href="../../eCommon/html/blank.html";
		}else{	
			param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
			parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
			parent.qa_query_result.location.href="../../eCommon/html/blank.html";

		}
		//End Pending orderDtl
}

function showRemarks(obj,fl,head){
	
//OperationProcedureHdr.jsp
//	var heading='Procedure Remarks Data';
	var heading = getLabel("eOT.ProcedureRemarksData.Label","OT");
	if (head!=null&&head!=''){
		heading=head;
	}
	//var dialogTop			= "350";
	var dialogHeight		= "9";
	var dialogWidth			= "32";

	//var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";

	//var param='remarks='+escape(obj.value)+'&heading='+heading+'&flag='+fl;
	heading=encodeURIComponent(heading);
	var param='remarks='+encodeURIComponent(obj.value)+'&heading='+heading+'&flag='+fl;
	var params=unescape(param);
	var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
	
	//ret =(ret=="undefined")?"":ret;


	//var param='remarks='+escape(obj.value)+'&heading='+heading+'&flag='+fl;
	//var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,window,"dialogHeight: 146px; dialogWidth:505px; center: yes; help: no; resizable: no; status: no;");
	if(fl=='1' && ret!="undefined" ){
		ret=ret.slice(0,ret.length);
		obj.value=ret;
	}
	//End OperationProcedureHdr.jsp
}

function methodSubmit(){
	//OperationProcedureDtl.jsp
	var frmObj=document.forms[0];
	var formObjHdr = top.header_frame.document.forms[0];
	var facility_id = formObjHdr.facility_id.value;
	var oper_room_code=formObjHdr.roomCode.value;
	var theatre_desc = formObjHdr.roomDesc.value;
	var patient_id = formObjHdr.patient_id.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var oper_date = formObjHdr.BOOKING_DATE.value;
	var patient_class = formObjHdr.episode_type.value;
	var surgeon_code = formObjHdr.surgeonCode.value;
	var oper_code = frmObj.oper_code.value;
	var oper_desc = frmObj.operation_desc.value;
	var called_from = "DIRECT_BOOKING";
	var obj=frmObj.codeCollect.value;
	if(validate()==false) {
		return false;
	}
	if(frmObj.mode.value=='I'){
		if(obj!=''&&obj!=null&&obj.indexOf(frmObj.oper_code.value)>=0){
		//	alert("Operation Code already exist");
		//	alert(getMessage("OPERATION_CODE_EXIST"));
			alert(getMessage("CODE_ALREADY_EXISTS","Common"));
			clearValues();
			return false;
		}
		if(obj==null) obj='';
		//frmObj.codeCollect.value=""+obj;
		obj+=frmObj.oper_code.value+",";
		frmObj.codeCollect.value=obj
		//frmObj.codeCollect.value=frmObj.oper_code.value+",";
	}
	if(frmObj.oper_code.value==null||frmObj.oper_code.value==''){
		//alert(getMessage("DESCRIPTION_NULL_STATUS"));
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("eOT.OperationDescription.Label","OT")+msgArray[1]);
		return false;
	}
	var remrk=encodeURIComponent(frmObj.remarks.value);

	if(remrk.length > 500){
		//var errors=getMessage("MAXM_LENGTH_REMARKS1");
		var max_len = getMessage("MAX_LENGTH_DATA","OT");
		var max_len_msg_arr = max_len.split("#");
		var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+" 500 "+max_len_msg_arr[2];
		top.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false;
	}
	if( checkFitOperation( facility_id,oper_room_code,theatre_desc,oper_code,oper_desc )==false ){
		top.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
    
	// please uncomment this line if billing need to be invoked on booking function
	/*
	if(frmObj.mode.value=="I"){
                populateBillingDetails(patient_id,patient_class,encounter_id,surgeon_code,called_from,oper_date,oper_code);
    }
	*/
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	param="oper_code="+frmObj.oper_code.value+"&operation_desc="+frmObj.operation_desc.value+"&appl_right_left_flag="+frmObj.appl_right_left_flag.value+"&duration="+frmObj.duration.value+"&remarks="+encodeURIComponent(frmObj.remarks.value)+"&mode="+frmObj.mode.value+"&key="+frmObj.key.value+"&f_duration="+frmObj.f_duration.value+"&surgeon_avg_time="+frmObj.avgTime.value+"&patient_id="+patient_id;
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OperationCollectDetail.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;		
	parent.frames[1].document.location.href="../../eOT/jsp/OperationStaticDtl.jsp";
	clearValues();
 }

 //For populate Billing related Charges...
 function populateBillingDetails(patient_id,patient_class,encounter_id,surgeon_code,called_from,oper_date,oper_code){
        var param = "oper_code="+oper_code+"&patient_id="+patient_id+"&oper_date="+oper_date+"&encounter_id="+encounter_id+"&surgeon_code="+surgeon_code+"&patient_class="+patient_class+"&called_from="+called_from;
//      alert(param);
        var xmlStr ="<root></root>";
        var action="OTOrderLineCreation.jsp?"+param;
        var xmlDoc = "" ;
        var xmlHttp = new XMLHttpRequest() ;
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        xmlHttp.open("POST",action,false);
        xmlHttp.send(xmlDoc);
        var retVal = localTrimString(xmlHttp.responseText);
        //alert(responseText);
        //showBillingWindow(responseText);
}

function paintBillingDetails(row_num,charge_str){
	var lbl_total=getLabel("eOR.Total.label","or_labels");
	var lbl_payable=getLabel("eOT.Payable.label","ot_labels");
	var lbl_paid=getLabel("eOT.Paid.label","ot_labels");
	var charge_arr = new Array();
	var charges = charge_str.split("::");
	var Total=charges[0];
	var Payable=charges[1];
	var Paid = charges[2];
	var str = "<B><font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font><br>";
	str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font><br>";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font></B>";
	eval("document.getElementById("oper_code")"+row_num).innerHTML = str;
}


async function showBillingWindow(str){
	   	var module_id="OR";    
		var arr = str.split("@@");
	//0DTJ0ZZ@@SD000008870DTJ0ZZ@@SD00000887@@I@@10002954@@1@@10002954@@26/04/2007@@P@@NANDA@@S@@SUC_APPEDI@@order_id@@order_line_num@@row_num
		//alert(str);
		var key_line_no="";
		var bean_id=""; 
		var order_catalog_code=arr[0]; 
		var key = arr[1];
		var patient_id = arr[2];          
        var episode_type = arr[3];
		var episode_id=arr[4];         
        var visit_id=arr[5];
        var encounter_id=arr[6]; 
		var service_date=arr[7];  
		var pract_staff_ind=arr[8];          
        var pract_staff_id=arr[9];
        var service_panel_ind=arr[10]; 
        var service_panel_code=arr[11];     
		var order_id=arr[12];
	    var order_line_no=arr[13];
	    var row=arr[14];
        var dialogTop = "100";
        var dialogHeight = "30" ;
        var dialogWidth = "70" ;
        var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
        var title=getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL");
        title=encodeURIComponent(title);
		 var arguments = "" ;
        var column_sizes = "";
            var column_descriptions ="";       
            var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id; 
			//alert(param);
			var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
			if(retVal!=null){
				var charge_str = retVal[1]+"::"+retVal[2]+"::"+retVal[3];
				updateRevisedPanelStr(arr[14]);
				paintBillingDetails(arr[14],charge_str);
				//parent.frames[1].document.location.reload();
			}
}

function updateRevisedPanelStr(key){
		//alert(key);
		var formObj = document.RecordOperationForm;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH /></root>";
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert('RECID= '+ recId);
		xmlHttp.open("POST","OperationCollectDetail.jsp?mode=R&key="+key,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		//alert(retVal);
}


function checkFitOperation( facility_id,oper_room_code,theatre_desc,oper_code,oper_desc ){
	if(facility_id!="" && oper_room_code!="" ){
		var sql="SELECT 'X' FROM OT_OPER_UNFIT_FOR_ROOM WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_ROOM_CODE = '"+oper_room_code+"' AND OPER_CODE = '"+oper_code+"'";
		var	param="flag=MED_SER&sql="+sql;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt=localTrimString(xmlHttp.responseText);
		if(resTxt=='X') {
			//alert("This "+theatre_desc+" cannot have the facility \n to perform this "+oper_desc+" operation...");
			//alert("This Operation "+oper_desc+"Can't be \n Performed in this "+theatre_desc)
			var msg = getMessage("APP-OT0080","OT");
			var msgArray = msg.split("&");
			alert(msgArray[0]+oper_desc+msgArray[1]+theatre_desc);
			return false;
		}else
			return true;
	}else{
		//alert("Select the theatre before recording operations..");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.Theatre.label","Common")+msgArray[1]);
		return false;
	 }
}

function localTrimString(sInString) {
  //sInString = sInString.replace( /^\s+/g, "" );// strip leading space
  //return sInString.replace( /\s+$/g, "" );// strip trailing space
  return sInString.replace(/^\s+|\s+$/g,"");
}

function funRemoveDtl(){
	var frmObj=document.forms[0];
	var strDetail=frmObj.codeCollect.value
	var strSpeciality=frmObj.specialityCollect.value
	strDetail=strDetail.replace(frmObj.oper_code.value+",","");
	strSpeciality=strSpeciality.replace(frmObj.speciaitycode.value+",","");
	frmObj.codeCollect.value=strDetail;
	frmObj.specialityCollect.value=strSpeciality;
	frmObj.mode.value='D';
	methodSubmit();
}
function clearValues(){ 
	var frmObj=document.forms[0];
	var order_id = frmObj.orderid.value;
	frmObj.oper_code.value='';
	frmObj.operation_desc.value='';
	frmObj.appl_right_left_flag.value='';
	frmObj.remarks.value='';
	frmObj.duration.value='';
	frmObj.avgTime.value="";
	frmObj.mode.value='I';
	frmObj.key.value='';
	frmObj.stdduration.value='';
	if(order_id.length==0)
		frmObj.OperationLookUp.disabled=false;
	//End OperationProcedureDtl.jsp
}

function checkNull(retVal){
//START FUNCTION DIARYSHCEDULE
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';
}

function funAutoSearch(){
	var frmObj=document.forms[0];
	if(frmObj.orderid.value!=null&&frmObj.orderid.value!=''&&frmObj.orderid.value.length>0)
	validateAll();
	if(frmObj.booking_no.value!=null&&frmObj.booking_no.value!=''&&frmObj.booking_no.value.length>0)
		validateAll();
}

function checkDate(flag){
	var data="";
	var change_pref_date="";
	var obj=document.forms[0];	
	var locale = obj.locale.value;
	if(obj.chkavilable!=null&&obj.chkavilable!='undefined'&&obj.chkavilable!='')
		obj.chkavilable.checked=false;
	if(flag=='1'){
		data=obj.PREFERRED_DATE.value;
		change_pref_date=dateUtils(data,locale);
		if(data == null || data == '') return false;
		data=changeDate(change_pref_date);
		var dat1=new Date(data);
		var dat2=new Date(obj.date_compare.value);
		if(dat1<dat2){
			//alert("APP-OT0018 Date should be greater than Current Date");
			//alert(getMessage("DATE_COMPARE_CURDATE"));
		   	var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var date = getLabel("Common.date.label","common");
			var current_date = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+date+msgArray[1]+current_date+msgArray[2]);
			return false;
		}else
			return true;
	}else if(flag=='2'){
		data=obj.PREFERRED_MONTH.value;
		if(data == null || data == '') return ;
		data1=obj.month_compare.value;
		var dt=new Array();
		var dt1=new Array();
		dt=data.split("/");
		dt1=data1.split("/");
		if(dt[0].length==1) dt[0]="0"+dt[0];
		if(dt1[0].length==1) dt1[0]="0"+dt1[0];
		if(dt[1]<dt1[1]||dt[0]<dt1[0]){
		 	//alert(getMessage("MONTH_COMPARE_CURMONTH"));
			return false;
		}else
			return true;
    }
 }
function inactive(obj){
	obj.disabled=true;
}

function changeDate(da){
	var dat=new Array();
	var retDat="";
	dat=da.split("/");
    if(dat[1].length==1) 	dat[1]="0"+dat[1];
	if(dat[0].length==1) 	dat[0]="0"+dat[0];
	retDat=dat[1]+"/";
	retDat+=dat[0]+"/";
	retDat+=dat[2];
	return retDat;
}

function validateAll(){
	var countFlag=0;
	var obj=document.forms[0];
	if(obj.SURGEON.value==''&&obj.SPECIALITY_DESC.value==''&&obj.PROCEDURE.value==''){
		 //alert(" Surgeon or Speciality or Procedure Should be entered");
		 alert(getMessage("APP-OT0036","OT"));
		 return false;
	}	

	if( obj.PREFERRED_DATE.value=='' && obj.PREFERRED_MONTH.value=='' ) {
		//alert("APP-OT0021 Either Prefered  Date or Prefered Month should be enter");
		alert(getMessage("APP-OT0037","OT"));
		return false;
	}

	if( obj.PREFERRED_DATE.value!='' && checkDate(1)==false ){
		//alert(getMessage("DATE_COMPARE_CURDATE"));
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var preferred_date = getLabel("Common.PreferredDate.label","common");
		var current_date = getLabel("Common.CurrentDate.label","common");
		alert(msgArray[0]+preferred_date+msgArray[1]+current_date+msgArray[2]);
		return false;
	}else if(obj.PREFERRED_MONTH.value!='' && checkDate(2)==false ){
		alert(getMessage("MONTH_COMPARE_CURMONTH","OT"));
		return false;
	}
	countFlag=0;
	if(obj.SURGEON.value!='')
		countFlag+=1;
	else if(obj.SPECIALITY_CODE.value!='') 
		countFlag+=3;
	if(obj.PREFERRED_DATE.value!='') 
		countFlag+=3;
	else if(obj.PREFERRED_MONTH.value!='') 
		countFlag+=4;	 
	var datVal='';
	if(obj.PREFERRED_MONTH.value==obj.month_compare.value){
		datVal=changeDate(obj.date_compare.value);
		funOTTheaterSearch(countFlag,'1',datVal);
	}else{
		funOTTheaterSearch(countFlag,'2',datVal);
	}
//END OF Prob
}

function callDialog(param){
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function funOTTheaterSearch(flag,fl,datVal){
	var sql;
	var obj=document.forms[0];	
	var facility_id = obj.facility_id.value;
	var locale = obj.locale.value;
	if(flag==4||flag==5){
		/*sql=escape("SELECT DISTINCT SURGEON_NAME SURGEON_NAME1,SURGEON_CODE SURGEON_CODE1,OPER_ROOM_CODE OPER_ROOM_CODE1,'' SPECIALITY_CODE1,THEATRE_TYPE_DESC THEATRE_TYPE_DESC1, OPER_ROOM_DESC OPER_ROOM_DESC1 FROM OT_SURGEON_BOOKINGS_VW WHERE SURGEON_CODE	= '"+obj.SURGEON_CODE.value+"' AND BOOKING_DATE BETWEEN to_date(?,'dd/mm/yyyy') AND ADD_MONTHS(to_date(?,'dd/mm/yyyy'),1)");*/
		
		//Query modified for performance Issue
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, D.SHORT_DESC  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,AM_PRACTITIONER_LANG_VW C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND D.LANGUAGE_ID = '"+locale+"'  AND A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"'  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID AND B.THEATRE_TYPE  = D.LOCN_TYPE 	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, D.SHORT_DESC  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,AM_PRACTITIONER_LANG C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND D.LANGUAGE_ID = '"+locale+"'  AND A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"'  AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID AND B.THEATRE_TYPE  = D.LOCN_TYPE 	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,(SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, NVL(X.PRACTITIONER_NAME, Y.PRACTITIONER_NAME) PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG X, AM_PRACTITIONER Y WHERE X.PRACTITIONER_ID = Y.PRACTITIONER_ID) C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"'  AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		// 28082007 sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,(SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, NVL(X.PRACTITIONER_NAME, Y.PRACTITIONER_NAME) PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG X, AM_PRACTITIONER Y WHERE X.PRACTITIONER_ID = Y.PRACTITIONER_ID UNION SELECT LANGUAGE_ID, '*ALL' PRACTITIONER_ID, 'All' PRACTITIONER_NAME FROM SM_LANGUAGE) C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"'  AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,(SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, X.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_vw X WHERE X.LANGUAGE_ID='"+locale+"' AND X.PRACTITIONER_ID = '"+obj.SURGEON_CODE.value+"' UNION SELECT LANGUAGE_ID, '*ALL' PRACTITIONER_ID, 'All' PRACTITIONER_NAME FROM SM_LANGUAGE) C WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"'  AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");

	}else if(flag==6 || flag==7) {
		/*sql=escape("SELECT DISTINCT SURGEON_NAME SURGEON_NAME1, THEATRE_TYPE_DESC THEATRE_TYPE_DESC1,SURGEON_CODE SURGEON_CODE1,SPECIALITY_CODE SPECIALITY_CODE1,OPER_ROOM_CODE OPER_ROOM_CODE1,OPER_ROOM_DESC OPER_ROOM_DESC1 FROM OT_SURGEON_BOOKINGS_VW WHERE (SPECIALITY_CODE = '*ALL' OR SPECIALITY_CODE	= '"+obj.SPECIALITY_CODE.value+"') AND BOOKING_DATE BETWEEN to_date(?,'dd/mm/yyyy') AND ADD_MONTHS(to_date(?,'dd/mm/yyyy'),1)");*/
		
		//Query modified for performance Issue
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, D.SHORT_DESC  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, A.SPECIALITY_CODE SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,AM_PRACTITIONER_LANG C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND D.LANGUAGE_ID = '"+locale+"'  AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID AND B.THEATRE_TYPE  = D.LOCN_TYPE 	AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		// 28082007 sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, A.SPECIALITY_CODE SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B, (SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, NVL(X.PRACTITIONER_NAME, Y.PRACTITIONER_NAME) PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG X, AM_PRACTITIONER Y WHERE X.PRACTITIONER_ID = Y.PRACTITIONER_ID UNION SELECT LANGUAGE_ID, '*ALL' PRACTITIONER_ID, 'All' PRACTITIONER_NAME FROM SM_LANGUAGE) C, AM_CARE_LOCN_TYPE_LANG_VW D  WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");
		sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, A.SPECIALITY_CODE SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B, (SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, X.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_vw X) C WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE )  AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE 		= C.PRACTITIONER_ID AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy')   AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1)");

	}
	var flag=0;
	var obj1;
	var locale = obj.locale.value; 
	if(fl=='1'){
		var change_pref_date = datVal;
		//obj1= datVal;
	}else{
		if(document.forms[0].PREFERRED_MONTH.value!=null&&document.forms[0].PREFERRED_MONTH.value!=''){
			obj1=document.forms[0].PREFERRED_MONTH.value;
			obj1="01/"+obj1;	
			var change_pref_date=dateUtils(obj1,locale);
		}else{
			obj1=document.forms[0].PREFERRED_DATE;
			var change_pref_date=dateUtils(obj1.value,locale); 
		}
	}
	var splc=document.forms[0].SPECIALITY_CODE.value;
	var spld=document.forms[0].SPECIALITY_DESC.value;

	if(splc==null||splc==''){
		splc.value='';
		spld.value='';
	}	  
	
	if(obj.orderid.value==null||obj.orderid.value=='')
		obj.orderid.value=''; 
			
	if(obj.booking_no.value==null||obj.booking_no.value=='')
		obj.booking_no.value=''; 

	var param = "sql="+sql+"&flag="+flag+"&date="+change_pref_date+"&speciality_code="+splc+"&speciality_desc="+spld+"&orderid="+obj.orderid.value+"&booking_no="+obj.booking_no.value;
	//alert(param)
	parent.qa_query_result.location.href = '../../eOT/jsp/CalendarFrm.jsp?'+param;
	parent.qa_query_result_tail.location.href='../../eOT/jsp/TailLegend.jsp?'+param
}

function validate(){
	var validatStr=new Array("surgeonType","episode_type","patient_id","SPECIALITY_DESC","Source_code");
	// Modified by Selvam 24-Oct-2006
	//var tit = getLabel('eOT.SurgeryType.Label','OT')+','+getLabel('Common.encountertype.label','Common')+','+getLabel('Common.patientId.label','Common')+','+getLabel('Common.speciality.label','Common')+','+getLabel('eOT.SourceType.Label','OT');
	var dispStr = new Array ( getLabel('eOT.SurgeryType.Label','OT'),getLabel('Common.encountertype.label','Common'),getLabel('Common.patientId.label','Common'),getLabel('Common.speciality.label','Common'),getLabel('eOT.SourceType.Label','OT') );
	//var dispStr = escape(tit); 
	//var dispStr=new Array("Surgery Type","Encounter Type", "Patient Id","Speciality","Source Type");
	var obj=parent.parent.parent.header_frame.document.forms[0];
	var msgFrame=parent.parent.parent.messageFrame;
    return(validateMandatory(obj,validatStr,dispStr,msgFrame));
}

function disableButton(){
	var frmObj=document.forms[0];
	frmObj.quest1.disabled=true;
	if(frmObj.quest2)frmObj.quest2.disabled=true;
	frmObj.quest3.disabled=true;
	frmObj.quest4.disabled=true;
	frmObj.quest5.disabled=true;
	frmObj.quest6.disabled=true;
	frmObj.sourceType.disabled=true;
}

function funsubmitCheckInDtls(){
	var obj=parent.header_frame.document.forms[0];
	var obj1=parent.message_search_frame.detailframe.frames[0].document.forms[0];
	var obj2=parent.message_search_frame.detailframe.frames[1].document.forms[0];
	obj.duration.value=obj2.total_hour.value+":"+obj2.total_min.value;
	var spl_code=obj.SPECIALITY_CODE.value;
	var spltycode=obj1.spltycode.value;
	var spltycodedesc=obj1.spltycodedesc.value;
	var strSpecialityYN=obj1.strSpecialityYN.value;
	var collect=obj1.specialityCollect.value;
	var codeCollect=obj1.codeCollect.value;
	obj.specilaity_collect.value=collect;
	if(obj.orderid.value==''||obj.orderid.value==null){
		if(validate()==false) 	return false;
		var pre_oper_diag=obj.pre_oper_diag.value;
		var remarks=obj.REMARKS.value;
		var errors='';
		if(codeCollect.length==0){
			var msgFrame=parent.messageFrame;
			errors+=getMessage("MIN_ONE_DETAIL_REQUIRED","Common")+"<br>";
		}
		var msg1="";
		if(spltycode==""){
			// Modified by Selvam 25-Oct-2006
			//msg1="Selected Slots are blocked for "+spltycodedesc+" speciality.  Atleast one operation should be of this speciality.";
			msg1=getMessage("APP-OT0096","OT");
		}else{
			//msg1="Selected Slots are blocked for Multiple Specialities. Atleast one operation should be selected for any of these specialities.";
			msg1=getMessage("APP-OT0097","OT");
		}
		var spltycode_arr = spltycode.split(":");
		var selected_splty_list_arr=collect.split(",");
		var count = 0;
		if(spltycode==""){
			for(c=0;c<selected_splty_list_arr.length;c++){ // if there is no blocked specialities
				if(spl_code==selected_splty_list_arr[c]){
					count=1;
					break;
				}
			}
		}else{
			// If there is/are blocked specialitie/s, check whether the operating Specilaity(Header)
			// is a part of the blocked specialities or not.
			for(c=0;c<spltycode_arr.length;c++){ 
				if(spl_code==spltycode_arr[c]){
					count=1;
					break;
				}
			}
			if(count==0){
			// If the operating Specilaity(Header) is a not a part of the blocked specialities,
			// Check for atleast 1 operation for this operating Specilaity(Header) 
				for(c=0;c<selected_splty_list_arr.length;c++){
					if(spl_code==selected_splty_list_arr[c]){
						count=1;
						break;
					}
				}
			}
		}
		if(count==0){
			var msgFrame=parent.messageFrame;
			 errors+=getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")+"<br>";
		}
		count = 0;	   // initialize
		if(spltycode!=""){	
			if(strSpecialityYN=="N"){
				var found_str = "";
				for(var j=0;j<spltycode_arr.length;j++){
					for(k=0;k<selected_splty_list_arr.length;k++){
						if(spltycode_arr[j] == selected_splty_list_arr[k]){
							count = 1;
							break;
						}
					}
				}
				if(count==0){
					 errors+=msg1+"<br>";
				}
			}
			else{
				var msgFrame=parent.messageFrame;
				var success='';	
				//var msg2="Selected Slots are blocked for "+spltycodedesc+" speciality.  Selected operation(s) do not belong to this speciality.  Do you want to continue?";
				//Selected Slots are blocked for # speciality.  Selected operation(s) do not belong to this speciality.  Do you want to continue?"
				 var msg = getMessage("APP-OT0073","OT");
				 var msgArray = msg.split("#");
				 var msg2=msgArray[0]+spltycodedesc+msgArray[1];
				for(var j=0;j<selected_splty_list_arr.length;j++){	
					if(errors.indexOf("Selected")<0 && success==''){
						if(selected_splty_list_arr[j]!=spltycode){
							if(window.confirm(msg2)==false){		
								errors+=msg1+"<br>";
								success='';
							}else{
								errors+='';
								success="YES";
							}
						}
					}
				}
				if(errors.length>0){	
					if(errors.indexOf("Selected")>=0) errors='';
					// Modified by Selvam 25-Oct-2006
					//errors+="Selected Slots are blocked for "+spltycodedesc+" speciality.  Atleast one operation should be of this speciality.";
					errors+=getMessage("APP-OT0096","OT");
				}
			}
		}
		if(remarks.length > 1500){
			//errors+=getMessage("MAXM_LENGTH_REMARKS")+"<br>";
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var header_value=getlabel("Common.Header.label","common");
			var max_len_msg = max_len_msg_arr[0]+header_value+max_len_msg_arr[1]+" 1500 "+max_len_msg_arr[2];
			errors+=max_len_msg+"<br>";
		}
		if(pre_oper_diag.length > 500){
			var msgFrame=parent.messageFrame;
			//errors+=getMessage("MAXM_LENGTH_DATA")+"<br>";
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var preOperativeDiagnosis_value=getLabel("eOT.PreOperativeDiagnosis.Label","OT");
			var max_len_msg = max_len_msg_arr[0]+preOperativeDiagnosis_value+max_len_msg_arr[1]+" 500 "+max_len_msg_arr[2];
			errors+=max_len_msg+"<br>";
		}
		if(errors.length>0){
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors 
			return false;
		}
	}else{
		var pref_date= obj.pref_date.value;
		//var pref_date="02/04/2005";
		var booking_date=obj.booking_date.value;
		pref_date=changeDate(pref_date);
		booking_date=changeDate(booking_date);
		var bdat=new Date(booking_date);
		var pdat=new Date(pref_date);
		if(bdat > pdat && obj.waitlistyn.value=='N') {
			//if(window.confirm("Do you want to Wait list this Patient")){
			if(window.confirm(getMessage("APP-OT0074","OT"))){
				obj.waitlistyn.value="Y";
			}else{
				obj.waitlistyn.value="N";
			}
		}
	}
	return true;
}

function closeWindow(){
	parent.window.returnValue='0';
	parent.window.close();
}	

function callPatientSearch(){
	var frmObj	=document.forms[0];
	var patient_class=frmObj.episode_type.value;
	if(patient_class==null || patient_class==""){
		//alert("Encounter Type should not be blank");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		//alert(msgArray[0]+" Patient Class "+msgArray[1]);
		alert(msgArray[0]+getLabel("Common.patientclass.label","Common")+" "+msgArray[1]);
		return false;
	}else{
		frmObj.patient_id.value="";
		frmObj.patient_name.value="";
		frmObj.sex.value="";
		frmObj.date_of_birth.value="";
		var patient_class_desc="";
		// Modified by Selvam 25-Oct-2006
		//if(patient_class=="IP") patient_class_desc="InPatient";
		if(patient_class=="IP") patient_class_desc=getLabel('Common.inpatient.label','Common');
		//if(patient_class=="DC") patient_class_desc="DayCare";
		if(patient_class=="DC") patient_class_desc=getLabel('Common.daycare.label','Common');
		//if(patient_class=="EM") patient_class_desc="Emergency";
		if(patient_class=="EM") patient_class_desc=getLabel('Common.emergency.label','Common');
		//if(patient_class=="OP") patient_class_desc="Outpatient";
		if(patient_class=="OP") patient_class_desc=getLabel('Common.Outpatient.label','Common');
		//if(patient_class=="XT") patient_class_desc="External";
		if(patient_class=="XT") patient_class_desc=getLabel('Common.external.label','Common');
		patient_class_desc=encodeURIComponent(patient_class_desc);
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		return_value=window.showModalDialog("../../eOT/jsp/OTPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc,arguments,features);
		if(return_value!=null && return_value!="undefined" && return_value!=""){
			var arr=return_value.split("##");
			frmObj.patient_id.value = arr[0];
			frmObj.patient_name.value = arr[1];
			frmObj.encounter_id.value=arr[3];
			frmObj.episode_id.value=arr[4];
			frmObj.date_of_birth.value=arr[5];
			frmObj.sex.value=arr[6];
			frmObj.visitid.value=arr[7];
			//var param="patient_id="+arr[0]+"&patient_name="+arr[1]+"&encounter_id="+arr[3]+"&date_of_birth="+arr[5]+"&sex="+arr[6]+"&visitid="+arr[7];
			frmObj.submit();
			//parent.frames[1].location.href='../../eOT/jsp/OperationProcedureHdr.jsp?'+param;
		}
	}
}
function clearPatientDetails(){
	var frmObj	=document.forms[0];
	frmObj.patient_id.value="";
	frmObj.patient_name.value="";
	frmObj.date_of_birth.value="";
	frmObj.sex.value="";
}

function setInitialValue(){
	var obj=document.PreOperHdr;
	if(obj!=null){
		obj.sex.value=obj.sex.DB_VALUE;
		obj.episode_type.value=obj.episode_type.DB_VALUE;
		obj.sourceType.value=obj.sourceType.DB_VALUE;
	}
}

function callCurrentStage(locale){
	var column_sizes = escape("70%,30%"); 
	// Modified by Selvam 24-Oct-2006
	var column_descriptions = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions);
	//var column_descriptions = escape("Description, Code");  
	var sql=escape("select  PRE_STAGE_DESC PRE_STAGE_DESC1,STAGE_CODE STAGE_CODE1 from OT_BOOKING_FIN_STAGES");
	//var title='Current Stage Search';
	var title = getLabel("eOT.CurrentStage.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		document.forms[0].currstage_desc.value = arr[0];
		document.forms[0].currstage_code.value = arr[1];	
	}else{
		document.forms[0].currstage_desc.value = '';
		document.forms[0].currstage_code.value = '';	
	}
}

function isNull(retVal){
	if(retVal==null||retVal=='')
		return true;
	else
		return false;
}

function verificationList(){
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
    var theatre_date=dateUtils(frmObj.theatre_date.value,locale);
	var bookingStage=frmObj.currstage_code.value;
	var seq = (frmObj.chk_sequence.checked==true) ?"Y":"N"
	var param='room_code='+frmObj.room_code.value+'&chk_sequence='+seq+"&theatre_date="+theatre_date+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&booking_stage="+bookingStage+"&theatre_type_code="+frmObj.theatre_type_code.value+"&surgery_type="+frmObj.surgery_type.value;
	parent.qa_query_result.location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;	
	parent.qa_query_result_tail.location.href='../../eOT/jsp/VerificationColorInd.jsp';
}

function validatewaitlistAll(){
	var frmObj=document.forms[0];
  //  var theatre_date=frmObj.theatre_date.value;
    var facility_id=frmObj.facility_id.value;
	var locale = frmObj.locale.value;
	var sql="SELECT PATIENT_ID, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.PATIENT_ID) PATIENT_NAME, OPER_DESC SPECIALITY_DESC,BOOKING_NUM, SURGEON_NAME, SURGERY_TYPE, TRUNC(SYSDATE - WAITLIST_DATE) WAITLISTED_DAYS,ORDER_ID,WAITLIST_NUM,TO_CHAR(PREFERRED_DATE,'DD/MM/YYYY') PREFERRED_DATE ,TO_CHAR(WAITLIST_DATE,'DD/MM/YYYY HH24:MI') WAITLIST_DATE, NVL2(BOOKING_NUM,'Assigned','Unassigned') STATUS, TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE, THEATRE_DESC, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME FROM OT_WAITLIST_VW A WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND NATURE_TYPE='EM'" ;
	var where="";

	if(isNull(frmObj.view.value)==false && frmObj.view.value=="A"){
		where+="AND (BOOKING_NUM IS NULL OR (BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)))";
	}
	
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="U"){
		where+=" AND BOOKING_NUM IS NULL";
	}
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="S"){
		where+="  AND BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)";
	}

	if(isNull(frmObj.SPECIALITY_CODE.value)==false)	 	 	
	where+=" AND SPECIALITY_CODE ='"+frmObj.SPECIALITY_CODE.value+"'";

	if(isNull(frmObj.SURGEON_CODE.value)==false)	 	
		where+=" AND SURGEON_CODE ='"+frmObj.SURGEON_CODE.value+"'";

	if(isNull(frmObj.surgery_type.value)==false)	 	 	
		where +="  AND  NATURE_CODE ='"+frmObj.surgery_type.value+"'";

	sql+=where;  
	var param='sql='+sql+'&waitlistkey=YES';
	//alert("param"+param);
	parent.qa_query_result.location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;	
	//parent.qa_query_result_tail.location.href='../../eOT/jsp/VerificationColorInd.jsp';
}

function  displayToolTip1(orderid,surgeonCode,prefDate,obj,patId,fl){
	//var obStr="document.forms[0].xx"+obj+".value";
	//var spl_desc="document.forms[0].yy"+obj+".value";
	//var  objS=eval(obStr);
	var param='';
	//param+=orderid+","+surgeonCode+","+prefDate+","+objS+","+splty_desc;
	param+=orderid+","+surgeonCode+","+prefDate+","+obj;
	//param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
	var menu_id_list;
	var	menu_name_list;
	if(fl=='1'){
		menu_id_list	= new Array("1","2");
		menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'),getLabel('Common.WaitList.label','Common'));
	}else if(fl=='0'){
		menu_id_list		= new Array("1");
		menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'));
	}
	else if(fl=='2'){
		menu_id_list		= new Array("2");
		menu_name_list	= new Array(getLabel('Common.WaitList.label','Common'));
	}
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER'  nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a   href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

function  reasonToolTip(stvar,indx){
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  = arr[0];	
		tab_dat     += "<tr>"
		tab_dat     += "<th   nowrap > "+id_name_colval + "  </a> </th>"
		tab_dat     += "</tr> ";
	for( cou=1;cou<arr.length;cou++){
		msg=arr[cou];
		tab_dat     += "<tr>"
		tab_dat     += "<td> "+msg+ "  </a> </td>"		
		tab_dat     += "</tr> ";	
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

function  displayToolTip3(orderid,surgeonCode,prefDate,obj,patId,waitNo){
	var obStr="document.forms[0].xx"+obj+".value";
	var  objS=eval(obStr);
	var param='';
	param+=orderid+","+surgeonCode+","+prefDate+","+obj+","+waitNo;
	//param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
	var menu_id_list		= new Array("3");
	var	menu_name_list	= new Array(getLabel('eOT.CancelWaitlist.Label','OT'));
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER'  nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a   href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

function  displayToolTip2(orderid,surgeonCode,prefDate,obj,patId,waitNo){
	var obStr="document.forms[0].xx"+obj+".value";
	var  objS=eval(obStr);
	var param='';
	param+=orderid+","+surgeonCode+","+prefDate+","+objS+","+waitNo;
	//param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
	var menu_id_list		= new Array("1","3");
	var	menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'),getLabel('eOT.CancelWaitlist.Label','OT'));
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER'  nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a   href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

async function callMenuItem(obj,para){
	var dialogHeight = screen.availHeight/2;//"60" ;
	var dialogWidth  = screen.availwidth/2;//"130" ;
	var dialogTop    = "5";
	var dialogLeft   = "5";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+"; status:no ;center: yes; help: no; resizable: no";
	var arguments			= "";
	var par=new Array();
	par=para.split(",");
	var formObj=document.forms[0];
	//alert(par);
	//alert(param);
	var param="";
	if(obj=='17'){
		var function_id="09";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " order_id=\""+par[2]+ "\" ";
		xmlStr += " function_id=\""+function_id+ "\" ";	
		xmlStr += " /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AnaesthesiaParams.jsp",false);
		xmlHttp.send(xmlDoc);
		retVal = trimString(xmlHttp.responseText);
		var pt_array  = retVal.split("::");
		param="facility_id="+formObj.facility_id.value+"&anesthesia_srl_no="+pt_array[0];
        if(pt_array[4]=="AnesthesiaDetails"){
			var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name=AnesthesiaDetails&patient_id="+par[0]+"&source_id="+pt_array[5]+"&parent_source_id="+pt_array[6]+"&request_source_type="+pt_array[7]+"&anaesthetist_code="+pt_array[8]+"&source_order_id="+pt_array[5];
		}else if(pt_array[4]=="PendingOrders"){
			var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name=PendingOrders"+"&patient_id="+par[2]+"&source_id="+pt_array[5]+"&parent_source_id="+pt_array[6]+"&request_source_type="+pt_array[7]+"&anaesthetist_code="+pt_array[8];
		}else if(pt_array[4]=="AnaesthesiaNotApplicable"){
			//alert("Anesthesia is not applicable for this operation");
			alert(getMessage("APP-OT0038","OT"));
			return;
		}
		//var retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
		//alert(url);
		var retVal= await window.showModalDialog(url,arguments,features);

	}if(obj=='16'){
		openHistoryforwaitlist(par[0],par[2]);
	}
	if(obj=='1'){
		var surgeon_name=eval("formObj.xx"+par[3]+".value");
		var spl_desc=eval("formObj.yy"+par[3]+".value");
		var	param="orderid="+par[0]+"&surgeonCode="+par[1]+"&prefDate="+par[2]+"&funflag=2&surgeonName="+encodeURIComponent(surgeon_name)+"&speciality_desc="+encodeURIComponent(spl_desc);
		// The below code is used for OR function

		/*	var dialogHeight= "33" ;
			var dialogWidth	= "50" ;
			var dialogTop = "150" ;
			var dialogLeft = "100" ;
			var center = "1" ;
			var status="no";
			var scroll="no";
			var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;

			alert("param  ="+ param);

			var url = "../../eOT/jsp/CalendarModalFrame.jsp?"+param;
			var retVal = window.showModalDialog(url,arguments,features);

		*/	

		parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
		//parent.qa_query_result.location.href="../../eCommon/html/blank.html";
	}else if(obj=='2'){
		var orderid=par[0];
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.WaitListServlet?orderid="+orderid, false);
		xmlHttp.send(xmlDoc);
		//alert(responseText);
		var resTxt=getMessage(xmlHttp.responseText,"OT");
		alert(resTxt);
		parent.location.reload();
		//parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/WaitListFrame.jsp?"+param;
		//parent.qa_query_result.location.href="../../eCommon/html/blank.html";
	}else if(obj=='3'){
		showWaitListCancel(par[4]);
		parent.location.reload();
	}
	/*var frmObj = parent.parent.parent.parent.content;
	alert(frmObj.name);
	if(frmObj!=null){
			objf =frmObj.document.forms[0];
			alert(objf);
			parent.parent.parent.commontoolbarFrame.document.location.href=objf.qury.value;
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}*/
}

function openHistory(patient_id,booking_num){ 
	formObj = document.forms[0];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " booking_num=\""+ booking_num + "\" ";	
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PatientHistoryParams.jsp",false);
	xmlHttp.send(xmlDoc);
	retVal = trimString(xmlHttp.responseText);
	var pt_array  = retVal.split("::");
	var HTML = "<html>";
	HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>";
	HTML += "<input type='text' name='patient_id' id='patient_id' value= '"+patient_id+"'>"; 
	HTML += "<input type='text' name='source_accession_type' id='source_accession_type' value= 'OT'>"; 
	HTML += "<input type='text' name='source_accession_num' id='source_accession_num' value= '"+""+"'>"; 
	HTML += "<input type='text' name='accession_type' id='accession_type' value= 'OT'>"; 
	HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '"+pt_array[0]+"'>";
	HTML += "<input type='text' name='patient_class' id='patient_class' value= '"+pt_array[1]+"'>";
	HTML += "<input type='text' name='mode' id='mode' value= 'R'>"; 
	HTML += "<input type='text' name='from_service_yn' id='from_service_yn' value= 'Y'>"; 					
	HTML += "</form>";
	HTML += "</html>";
	//alert(HTML);
	parent.parent.parent.frames[2].document.body.insertAdjacentHTML("BeforeEnd", HTML);
	parent.parent.parent.frames[2].document.historyForm.submit();
}

function callVerificationItem(obj,para){
	var par=new Array();
	par=para.split("@");
	var dialogHeight = "60" ;
	var dialogWidth  = "130" ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+";status:no";
	var arguments			= "";
	//var dialogHeight 		= "80";
	//var dialogWidth  		= "80";
	//var dialogTop   		= "10";
	//var dialogLeft   		= "50";
	//var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	hideToolTip();
if(obj=="V10"){
	//var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2];
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="BookingValidation.jsp?booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&orderid="+par[6];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);
	var pt_array  = responseText.split("##");
	
	if(pt_array[0]=="E")
	{
	//		alert(pt_array[2]);
	alert(getMessage(pt_array[2]))
		return;
	}
	if(pt_array[0]=="S" && pt_array[1]=="S")
	{
		alert(pt_array[2]);
		return;
	}
	if(pt_array[0]=="S" && pt_array[1]=="M")
	{
		alert(pt_array[2]);
		//return;
	}
	parent.location.reload();

	//return responseText;
//	alert(responseText);
}

if(obj=="V1"){
	var	param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&orderid=0&transfer=5";
	retVal=window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}

	if(obj=="V2"){
		var par1=new Array();
		par1=par[7].split("::");
		var		param="patient_id="+par[2]+"&patient_name="+par1[0]+"&sex="+par1[1]+"&dob="+par1[2]+"&called_from=OPER_REG&function_name=Surgery History";
		  window.showModalDialog("SurgeryHistory.jsp?"+param,window,"dialogHeight: 570px; dialogWidth:800px; center: yes; help: no; resizable: no; status: no;");
	}

if(obj=='V3'){
	openHistory(par[2],par[0]);
}
	
if(obj=='V5'){
	var function_id="09";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " order_id=\""+par[6]+ "\" ";
	xmlStr += " function_id=\""+function_id+ "\" ";	
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AnaesthesiaParams.jsp",false);
	xmlHttp.send(xmlDoc);
	retVal = trimString(xmlHttp.responseText);
	var pt_array  = retVal.split("::");
	param="facility_id="+par[1]+"&anesthesia_srl_no="+pt_array[0];
	if(pt_array[4]=="AnesthesiaDetails"){

		var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"AnesthesiaDetails";
	}else if(pt_array[4]=="PendingOrders"){
		var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"PendingOrders"+"&patient_id="+par[2]+"&source_id="+pt_array[5]+"&parent_source_id="+pt_array[6]+"&request_source_type="+pt_array[7]+"&anaesthetist_code="+pt_array[8];
	}else if(pt_array[4]=="AnaesthesiaNotApplicable"){
		//alert("Anesthesia is not applicable for this operation");
		alert(getMessage("APP-OT0038","OT"));
		return;
	}
	//var retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	var retVal=window.showModalDialog(url,"",features);

	}

if(obj=="V7"){
	var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2];
	retVal=window.showModalDialog("../../eOT/jsp/PreOperativeDlgFrame.jsp?"+param,arguments,features);
	//alert(retVal);
		parent.location.reload();
	}
//Newly Added For Assistant Surgeon by rajesh on 08/08/07.....

	if(obj=="V12"){
		 dialogHeight = "10" ;
		 dialogWidth  = "25" ;
		 dialogTop    = "250";
		 dialogLeft   = "300";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&speciality_code="+par[10];
		retVal=window.showModalDialog("../../eOT/jsp/AddAsstSurgeonFrame.jsp?"+param,arguments,features);
		//alert(retVal);
		if(retVal=="Updated Successfully"){
			parent.location.reload();
		}
	}

	if(obj=="V11"){
		 dialogHeight = "8" ;
		 dialogWidth  = "25" ;
		 dialogTop    = "250";
		 dialogLeft   = "300";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2];
		retVal=window.showModalDialog("../../eOT/jsp/AssignAnaesFrame.jsp?"+param,arguments,features);
		//alert(retVal);
		if(retVal=="Updated Successfully"){
			parent.location.reload();
		}
	}

	
	if(obj=="V15"){
		 dialogHeight = "8" ;
		 dialogWidth  = "25" ;
		 dialogTop    = "250";
		 dialogLeft   = "300";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var param="facility_id="+par[1]+"&patient_id="+par[2]+"&order_id="+par[6]+"&booking_num="+par[9];
		//alert(param);
		retVal=window.showModalDialog("../../eOT/jsp/AssignTheatreFrame.jsp?"+param,arguments,features);
		if(retVal=="RECORD_INSERT"){
				parent.location.reload();
		}
	}

	if(obj=='V16'){
		openHistoryforwaitlist(par[2],par[6]);
	}	

	if(obj=='V17'){
		var function_id="09";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr += " order_id=\""+par[6]+ "\" ";
		xmlStr += " function_id=\""+function_id+ "\" ";	
		xmlStr += " /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AnaesthesiaParams.jsp",false);
		xmlHttp.send(xmlDoc);
		retVal = trimString(xmlHttp.responseText);
		var pt_array  = retVal.split("::");
		param="facility_id="+par[1]+"&anesthesia_srl_no="+pt_array[0];
		if(pt_array[4]=="AnesthesiaDetails"){
			var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"AnesthesiaDetails";
		}else if(pt_array[4]=="PendingOrders"){
			var	url='../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param+"&tab_name="+"PendingOrders"+"&patient_id="+par[2]+"&source_id="+pt_array[5]+"&parent_source_id="+pt_array[6]+"&request_source_type="+pt_array[7]+"&anaesthetist_code="+pt_array[8];
		}else if(pt_array[4]=="AnaesthesiaNotApplicable"){
			//alert("Anesthesia is not applicable for this operation");
			alert(getMessage("APP-OT0038","OT"));
			return;
		}
		//var retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
		var retVal=window.showModalDialog(url,arguments,features);
	}

	if(obj=="V8"){
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&transfer=6&booking_date="+par[3]+"&roomCode="+par[4]+"&seq_change_yn="+par[5];
		retVal=""+window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
		parent.location.reload();
	}
	if(obj=="V9"){
		param="booking_no="+par[0]+"&surgeonCode="+par[8]+"&funflag=2&surgeonName="+encodeURIComponent(par[9])+"&speciality_code="+par[10]+"&speciality_desc="+encodeURIComponent(par[11]);
		parent.parent.parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
	}

	// added by bshankar
	if(obj=="V4"){
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&Patient_ID="+par[2];	
	    retVal=""+window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}

	if(obj!="V3" && obj!="V16"){
		var frmObj = parent.parent.parent.parent.content;
		if(frmObj!=null){
			objf =frmObj.document.forms[0];
			parent.parent.parent.commontoolbarFrame.document.location.href=objf.qury.value;
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}


function  displayToolTip(bookingno,facility,patientid,bookingdate,roomcode,chkseq,pacyn,orderid,ind,fl,curstage,finstage,surg_code,surg_name,splty_code,splty_desc,encounter_id){	
parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";

var menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");


var frmObj=document.forms[0];
//alert(frmObj.waitlist_key_dtl.value);
if(frmObj.waitlist_key_dtl.value=='' || frmObj.waitlist_key_dtl.value==null)
{
var patsexdob=	eval("frmObj.patsexdob"+ind+".value");
}

var param=bookingno+"@"+facility+"@"+patientid+"@"+bookingdate+"@"+roomcode+"@"+chkseq+"@"+orderid+"@"+patsexdob+"@"+surg_code+"@"+surg_name+"@"+splty_code+"@"+splty_desc+"@"+pacyn;
param=escape(param);
//	param);

var	menu_name_list;
if(fl=='RES'){
	if(pacyn=='Y'){
		//Modified by Selvam 25-Oct-2006
		//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V9");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V9");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else{
		if(ca_module_yn=="Y"){
			 menu_id_list		= new Array("V1","V2","V3","V4","V9");		 
			 //menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			 menu_id_list		= new Array("V1","V4","V9");		 
			 //menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
}else if(fl!="WAIT"){
	if( pacyn=='Y' ){
		if(ca_module_yn=="Y"){
			//menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9","V10","V11");
			//Newly added Asst Surgeon by rajesh on 08/08/07

			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9","V10","V11","V12");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist","Asst Surgeon");
			
			//menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else if(curstage==finstage ){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V9","V12");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre","AssistantSurgeon");

			//menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT')+','+getLabel('eOT.SurgeryHistory.Label','OT')+','+getLabel('eOT.PatientHistory.Label','OT')+','+getLabel('eOT.PatientDemographics.Label','OT')+','+getLabel('eOT.PreAnaesthesiaEval.Label','OT')+','+getLabel('eOT.LinkPreOperativeOrders.Label','OT')+','+getLabel('eOT.ReassignTheatre.Label','OT'));
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V9","V11");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre");

			//menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT')+','+getLabel('eOT.SurgeryHistory.Label','OT')+','+getLabel('eOT.PatientHistory.Label','OT')+','+getLabel('eOT.PatientDemographics.Label','OT')+','+getLabel('eOT.PreAnaesthesiaEval.Label','OT')+','+getLabel('eOT.LinkPreOperativeOrders.Label','OT')+','+getLabel('eOT.ReassignTheatre.Label','OT'));
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else {
		if(ca_module_yn=="Y"){
			menu_id_list	= new Array("V1","V2","V3","V4","V7","V8","V9","V10","V11","V12");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}

	}
}
if(fl=="WAIT"){
	if(ca_module_yn=="Y"){
		menu_id_list		= new Array("V15","V16","V17");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
	}else{
		menu_id_list		= new Array("V15");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'));
	}
}
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER' nowrap    id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href = \"javascript:callVerificationItem('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
//  document.getElementById("tooltiplayer").style.visibility = 'visible';

}

function  displayToolTip10(bookingno,facility,patientid,bookingdate,roomcode,chkseq,pacyn,orderid,ind,fl,curstage,finstage,surg_code,surg_name,splty_code,splty_desc,oper_status)
{	
//alert("oper_status"+oper_status);
var menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");


var frmObj=document.forms[0];
//alert(frmObj.waitlist_key_dtl.value);
if(frmObj.waitlist_key_dtl.value=='' || frmObj.waitlist_key_dtl.value==null)
{
var patsexdob=	eval("frmObj.patsexdob"+ind+".value");
}

var param=bookingno+"@"+facility+"@"+patientid+"@"+bookingdate+"@"+roomcode+"@"+chkseq+"@"+orderid+"@"+patsexdob+"@"+surg_code+"@"+surg_name+"@"+splty_code+"@"+splty_desc+"@"+pacyn;
//alert(param);
var	menu_name_list;
if(fl=='RES'){
	if(pacyn=='Y'){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else{
		if(ca_module_yn=="Y"){
			 menu_id_list		= new Array("V1","V2","V3","V4","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");

			 menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			 menu_id_list		= new Array("V1","V4","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");

			 menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
}else if(fl!="WAIT")
	{
	if( pacyn=='Y' ){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9","V10","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V8","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));

		}
	}else if(curstage==finstage && (oper_status!="10" || oper_status!=10) ){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V9","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre");		

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V9","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre");		

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
	else if(curstage==finstage && (oper_status=="10" || oper_status==10))
	{
//alert("123");
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
	else {
		if(ca_module_yn=="Y"){
			menu_id_list	= new Array("V1","V2","V3","V4","V7","V8","V9","V10","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
}
if(fl=="WAIT")
{
	if(ca_module_yn=="Y"){
		menu_id_list		= new Array("V15","V16","V17");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");

		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
	}else{
		menu_id_list		= new Array("V15");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");

		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'));
	}
}
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ )
		{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER' nowrap    id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href = \"javascript:callVerificationItem('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
//  document.getElementById("tooltiplayer").style.visibility = 'visible';

}

function hideToolTip(){
  document.getElementById("tooltiplayer").style.visibility = 'hidden';
}


function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OTMENU';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

function callOrderCategory(locale)
{
var locale = document.forms[0].locale.value;
var column_sizes = escape("70%,30%");
// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);  
//var column_descriptions = escape("Description, Code"); 

var sql=escape("SELECT SHORT_DESC SHORT_DESC1, ORDER_CATEGORY  ORDER_CATEGORY1 FROM OR_ORDER_CATEGORY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ");


//var title='Order Category  Search';
var title=getLabel("Common.OrderCategory.label","OT");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
retVal=callDialog(param);
var obj=document.forms[0];
retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		document.forms[0].order_catagory_disp.value = arr[0];
		document.forms[0].order_catagory.value = arr[1];	
		obj.order_type_button.disabled=false;
	}else{
		document.forms[0].order_catagory_disp.value = '';
		document.forms[0].order_catagory.value = '';	
		obj.order_type_button.disabled=true;
	}
}

function callTheatreType(locale) {
var locale = document.forms[0].locale.value;
var column_sizes = escape("70%,30%");     

// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);
//var column_descriptions = escape("Description, Code");  


var sql=escape("select SHORT_DESC SHORT_DESC1,LOCN_TYPE LOCN_TYPE1  from AM_CARE_LOCN_TYPE_LANG_VW where language_id='"+locale+"' and  CARE_LOCN_TYPE_IND='O'");


//var title='Theater Type  Search';
var title=getLabel("eOT.TheatreType.Label","OT");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].theatre_type_desc.value;
retVal=callDialog(param);
var obj=document.forms[0];
retVal=checkNull(retVal);
var arr=new Array();

if(retVal!='')
	{
	arr=retVal.split("::");
	document.forms[0].theatre_type_desc.value = arr[0];
	document.forms[0].theatre_type_code.value = arr[1];	
	}
else
	{
	document.forms[0].theatre_type_desc.value = '';
	document.forms[0].theatre_type_code.value = '';	
	}
}

function callTheatre(flg,locale){
var frmObj=document.forms[0];
var theatre_type=frmObj.theatre_type_code.value;
var column_sizes = escape("70%,30%"); 

// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);
//var column_descriptions = escape("Description, Code");  
var title=getLabel("Common.Theatre.label","Common");
title=encodeURIComponent(title);
var sql='';
if(theatre_type!=null&&theatre_type!=''){
sql=escape("SELECT SHORT_DESC SHORT_DESC1, OPER_ROOM_CODE OPER_ROOM_CODE1 FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' AND THEATRE_TYPE='"+theatre_type+"'");
}else{
sql='';
if(flg=='1') sql="SELECT 'All Theatres' SHORT_DESC1, '*ALL' OPER_ROOM_CODE1    from dual  UNION ";
sql=sql+"SELECT SHORT_DESC SHORT_DESC1, OPER_ROOM_CODE OPER_ROOM_CODE1 FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'";

sql=escape(sql);
}

var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].theatre.value;;

//alert(param);
retVal=callDialog(param);
retVal=checkNull(retVal);
var arr=new Array();
if(retVal!=''){
	arr=retVal.split("::");
	document.forms[0].theatre.value = arr[0];
	document.forms[0].room_code.value = arr[1];	
	//alert(document.forms[0].room_code.value);
	}
else
	{
	document.forms[0].theatre.value = '';
	document.forms[0].room_code.value = '';	
	}
}


function resizeWindow(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}

//Wait List frame
function funWaitListSearch(){
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
var change_from_date = dateUtils(frmObj.from_date.value,locale); 
var change_to_date = dateUtils(frmObj.to_date.value,locale); 
if(!callDateCheck(change_from_date,change_to_date)) return;
if(frmObj.from_date.value!=''){
	var sql="SELECT (to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')) R_DAY1,C.WARN_LIMIT_WAITLIST_DAYS WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'";

	var where="";
   if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
	where=escape(" and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),'#"+frmObj.SPECIALITY_CODE.value+"#')>0");

   if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='')
	where+=escape(" and v.SURGEON_CODE ='"+frmObj.SURGEON_CODE.value+"'");

	if(frmObj.orderid.value!=null && frmObj.orderid.value!='')
	   where+=escape(" and v.ORDER_ID ='"+frmObj.orderid.value+"'");

	if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
     where +=" AND PREFERRED_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')";

	if(frmObj.patientid.value!=null && frmObj.patientid.value!='')
	   where+=escape(" and v.PATIENT_ID ='"+frmObj.patientid.value+"'");
	else
		if(frmObj.patientName.value!=null&&frmObj.patientName.value!='')
		where+= escape(" and UPPER(v.PATIENT_NAME) like UPPER('"+frmObj.patientName.value+"%')");

	if(frmObj.status.value=='S')
	 where+=escape(" and v.BOOKING_NUM IS NOT NULL");
	else
	if(frmObj.status.value=='U')
	 where+=escape(" and v.BOOKING_NUM IS  NULL");
	sql+=where;  
	var param='sql='+sql+'&surgeonCode='+frmObj.SURGEON_CODE.value;
	//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;	
	parent.qa_query_result.location.href = '../../eOT/jsp/WaitListDtlFrame.jsp?'+param;	
	parent.qa_query_result_tail.location.href = '../../eOT/jsp/ColorIndofWaitlist.jsp';
	}else{
		//alert("APP-OT1 From Date Cannot be Blank...");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
}

function callReasonCode(fl,locale){
var column_sizes = escape("60%,40%");               
var obj=document.forms[0];

// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);
//var column_descriptions = escape("Description,Code"); 

var sql='';
if(fl=='1')
	{
 sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CW')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
	}
else
	{
sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
	}

var title=getLabel("Common.reason.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
retVal=callDialog(param);

retVal=checkNull(retVal);
if(retVal!='')
	{
arr=retVal.split("::");
obj.reason_desc.value=arr[0];
obj.reason_code.value=arr[1];
	}
else
	{
obj.reason_desc.value="";
obj.reason_code.value="";
	}
}

function showWaitListCancel(waitNo){
	var param="waitlist_no="+waitNo;
	var ret=""+window.showModalDialog("../../eOT/jsp/WaitListCancel.jsp?"+param,window,"dialogHeight: 150px; dialogWidth:470px; center: yes; help: no; resizable: no; status: no;");

	if(ret=='0'||ret==''||ret==null || ret=='undefined') return false;
//	alert (ret)
	//Call OT_CANCEL_WAITLIST procedure to cancel  waitList
}

function converString(objstr,constr,eschar){
	var convStr=objStr.replace(eschar,constr);
	return convStr;
}

function callTransfer(locale){
	var column_sizes = escape("60%,40%");               
	var obj=document.forms[0];

	// Modified by Selvam 25-Oct-2006
	var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Description,Code"); 
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS WHERE NVL(STATUS,'E') = 'E' AND REASON_CODE IN (SELECT REASON_CODE  FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'TA' AND NVL(ACTIVE_YN,'N') = 'Y') ");

	//var title='Transfer Reason Search';
	var title=getLabel("Common.reason.label","Common");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!='')
		{
	arr=retVal.split("::");
	obj.reason_desc.value=arr[0];
	obj.reason_code.value=arr[1];
		}
	else
		{
	obj.reason_desc.value="";
	obj.reason_code.value="";
		}
}

function callNoRecord(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}


function funRescheduleSearch(){
var frmObj=document.forms[0];
var locale=frmObj.locale.value;
var change_theatre_date=dateUtils(frmObj.theatre_date.value,locale);
//if(frmObj.theatre_date.value==null || frmObj.theatre_date.value==''){	
if(change_theatre_date==null || change_theatre_date==''){	
 //alert( "Appl00027 Theatre Date must be enter");
 var msg = getMessage("CANNOT_BE_BLANK","OT");
 var msgArray = msg.split("&");
 alert(msgArray[0]+getLabel("eOT.TheatreDate.Label","OT")+msgArray[1]);
 return;
}
 var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SEX SEX1,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) PATIENT_NAME1,A.SURGEON_CODE SURGEON_CODE1,A.SPECIALITY_CODE SPECIALITY_CODE1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.OPER_CODE OPER_CODE1, A.OPER_DESC OPER_DESC1,  A.RESCHD_REASON_CODE RESCHD_REASON_CODE1, B.REASON_DESC REASON_DESC1, A.SURGEON_NAME SURGEON_NAME1,A.APPT_REF_NUM APPT_REF_NUM1 FROM  OT_SCHD_OPERS_VW A, OT_REASONS B WHERE A.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'  AND 	NVL(BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' AND  NVL(A.BOOKING_STATUS,'X') 	= 'R' AND 	 APPT_DATE BETWEEN  	TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND 	TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI') AND	  A.RESCHD_REASON_CODE = B.REASON_CODE ";
 sql+="%28%2B%29";	

var where="";
if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
	where=escape("  and instr(NVL(ALL_SPECIALITY_CODES,SPECIALITY_CODE),'#"+frmObj.SPECIALITY_CODE.value+"#') > 0 ");

if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='')
	where+=escape(" and SURGEON_CODE ='"+frmObj.SURGEON_CODE.value+"'");

if(frmObj.ordering_doctor_code.value!=null && frmObj.ordering_doctor_code.value!='')
	where+=" and ORDER_ID IN (SELECT ORDER_ID FROM OR_ORDER WHERE ORDER_ID = A.ORDER_ID AND ORD_PRACT_ID ='"+frmObj.ordering_doctor_code.value+"')";
sql+=where;  
var param='sql='+sql;

//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;	
parent.qa_query_result.location.href = '../../eOT/jsp/ReScheduleDtlFrame.jsp?'+param;	
}

function openIPDialog(parametrs){
 var retVal =  new String();
 var dialogHeight= "80" ;
 var dialogWidth = "80" ;
 var dialogTop = "10" ;
 var status = "no";
 var arguments = "" ;
 var features = "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
 retVal = //window.showModalDialog("../../eIP/jsp/Booking.jsp?call_func="+call_func+"&Patient_Id="+Patient_Id+"&medical_service="+medical_service+"&booking_date_time="+booking_date_time+"&medical_speciality_desc="+medical_speciality_desc+"&medical_speciality_code="+medical_speciality_code+"&physician_desc="+physician_desc+"&physician_code="+physician_code,arguments,features);
 window.showModalDialog("../../eIP/jsp/Booking.jsp?"+parametrs,arguments,features);
}

function searchSpeciality(obj){
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//Qry Modified by BShankar on 23.08

	var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";
	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.speciality.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].SPECIALITY_DESC.value = localTrimString(returnedValues[1]);
	document.forms[0].SPECIALITY_CODE.value = localTrimString(returnedValues[0]);	
	}
else
	{
	document.forms[0].SPECIALITY_DESC.value = '';
	document.forms[0].SPECIALITY_CODE.value ='';		
		//obj.value = returnedValues[1];
	} 
}

function searchSurgeon(obj){
	var frmObj=document.forms[0];
	frmObj.SPECIALITY_CODE.value="";
	frmObj.SPECIALITY_DESC.value="";
	//alert("enter");
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];
	var sql="";
	//alert(obj1.SPECIALITY_CODE.value);
	if((obj1.SPECIALITY_CODE.value == null) || (obj1.SPECIALITY_CODE.value ==''))
	//var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	//Qry modified by BShankar on 23/08 

	var sql= "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";

	if((obj1.SPECIALITY_CODE.value != null) && (obj1.SPECIALITY_CODE.value !=''))

	//Qry modified by BShankar on 23/08 
	//	sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	 sql  = "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"')  UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert(sql);
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = CommonLookup(getLabel("eOT.Surgeon.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].SURGEON.value = returnedValues[1];
		document.forms[0].SURGEON_CODE.value = returnedValues[0];
		if(document.forms[0].SPECIALITY_CODE.value==''){
			document.forms[0].SPECIALITY_CODE.value=getSurgeonSpeicality(returnedValues[0]);
			document.forms[0].SPECIALITY_DESC.value=getSurgSpecialityDesc(document.forms[0].SPECIALITY_CODE.value);
		}
	}else{
	document.forms[0].SURGEON.value = '';
	document.forms[0].SURGEON_CODE.value = '';
	
		//obj.value = returnedValues[1];
	} 
}


function searchOrderingSurgeon(obj,target){
	//alert("enter");
	//var result		=	false ;
	//var message		=	"" ;
	//var flag		=	"" ;
	//var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	

	
	var obj1=document.forms[0];

	var sql="";
	//alert(obj1.SPECIALITY_CODE.value);
	if((obj1.SPECIALITY_CODE.value == null) || (obj1.SPECIALITY_CODE.value ==''))
	var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') != 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	
	if((obj1.SPECIALITY_CODE.value != null) && (obj1.SPECIALITY_CODE.value !=''))
	sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') != 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eOT.Surgeon.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value = returnedValues[1];
		obj.value = returnedValues[0];	
	}else{

	target.value = '';
	obj.value= '';

		//obj.value = returnedValues[1];
	} 
}


function searchProcedure(obj)
{
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	var obj1=document.forms[0];
	sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?)  order by 1" ;

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eOT.Surgeon.Label","OT"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
	} 
}

function searchTheatre(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var obj1=document.forms[0];
	//alert(obj1.locale.value);
	var locale=obj1.locale.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var theatre_type=frmObj.theatre_type_code.value;
	if(theatre_type!=null&&theatre_type!=''){
		//sql="SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' AND THEATRE_TYPE='"+theatre_type+"' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_ROOM_CODE) like upper(?) order by 2";
		//sql="SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' AND THEATRE_TYPE='"+theatre_type+"' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_ROOM_CODE) like upper(?) order by 2";
		sql="select description, code from (SELECT 'ALL THEATRES' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' AND THEATRE_TYPE='"+theatre_type+"' ) where upper(description) like upper(?) AND upper(CODE) like upper(?) order by 2"; 
	}else{
		sql='';
		//if(flg=='1') sql="SELECT 'All Theatres' SHORT_DESC1, '*ALL' OPER_ROOM_CODE1    from dual  UNION ";
		//sql=sql+"SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_ROOM_CODE) like upper(?) order by 2";
		sql=sql+"select description, code from (SELECT 'ALL THEATRES' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"') where upper(description) like upper(?) AND upper(CODE) like upper(?) order by 2";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.Theatre.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].theatre.value = returnedValues[1];
	document.forms[0].room_code.value = returnedValues[0];	
	//alert(document.forms[0].room_code.value);
	}else{
		document.forms[0].theatre.value = '';
		document.forms[0].room_code.value = '';	
	}
}
 
function searchTheatreType(obj){
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var sql="select SHORT_DESC DESCRIPTION,LOCN_TYPE CODE  from AM_CARE_LOCN_TYPE_LANG_VW where language_id='"+locale+"' and CARE_LOCN_TYPE_IND='O' AND upper(SHORT_DESC) like upper(?) AND upper(LOCN_TYPE) like upper(?) order by 2";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eOT.TheatreType.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].theatre_type_desc.value = returnedValues[1];
	document.forms[0].theatre_type_code.value = returnedValues[0];	
	}else{
		document.forms[0].theatre_type_desc.value = '';
		document.forms[0].theatre_type_code.value = '';	
	}
}

function searchOTTheatre(obj){
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var frmObj=document.forms[0];
	//var sql="SELECT description, code FROM (SELECT 'ALL THEATRES' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' ) WHERE UPPER(description) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	var sql="SELECT SHORT_DESC description,OPER_ROOM_CODE code FROM  OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2"
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	var title = getLabel("Common.Theatre.label","common");
	returnedValues = CommonLookup(title,argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].theatre.value = returnedValues[1];
	document.forms[0].room_code.value = returnedValues[0];	
	}else{
		document.forms[0].theatre.value = '';
		document.forms[0].room_code.value = '';	
	}
}


function searchOperation(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql="SELECT SHORT_DESC DESCRIPTION,OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.operation.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
	} 
}

function searchAnaesthetist(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var sql="select short_name DESCRIPTION,PRACTITIONER_ID CODE from AM_PRACTITIONER_LANG_VW where LANGUAGE_ID = '"+frmObj.locale.value+"' and  PRACT_TYPE IN ('AN') and  NVL(EFF_STATUS,'X') != 'S' AND upper(short_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified by rajesh lookup issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eOT.Anaesthetist.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
	frmObj.Anaesthetiest2_code.value=returnedValues[1];
		frmObj.Anaesthetiest1_code.value=returnedValues[0];
	}else{
		frmObj.Anaesthetiest1_code.value="";
		frmObj.Anaesthetiest2_code.value="";
	}
}

function searchProceduresdsdsd(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE, SPECIALITY_CODE CODE1 FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) AND upper(SPECIALITY_CODE) like upper(?) order by 2" ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	argumentArray[8] = "SPEC_DESC";
	returnedValues = CommonLookupprocedure("Procedure", argumentArray );
}
function storeVal111(currad) {
    radioval=currad.value
}

async function CommonLookupprocedure111(title,pArgumentArray){
	var retVal = new String();
    var dialogHeight= "28" ;
    var dialogWidth = "43" ;
    var status = "no";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eOT/jsp/ProcedureLookupResult.jsp?callFrom=0&" + formQueryString1(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;
	//alert(responseText);
    eval(responseText) ;
	if(firstCodeVal == ""){
        var dialogUrl       = "../../eOT/jsp/ProcedureLookup.jsp?title="+title ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
     }else{
         if(pArgumentArray[7] == CODE_DESC ){
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
         returnVal = firstCodeVal + "\"" + firstDescVal
         return returnVal.split("\"") ;
     }
}

function initializeText1111() {
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
    makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' ){
        fromCalledPage = true
        CallDescFrame() ;
    }
}

function resetForm111( formObj ){
}

function formQueryString111(pArgumentArray,callFrom){
    if(callFrom != 0)
      var  argArray = window.dialogArguments ;
    else
       var argArray = pArgumentArray;
	var sqlData         = argArray[0] ;
    var dataNameArray   = argArray[1] ;
    var dataValueArray  = argArray[2] ;
    var dataTypeArray   = argArray[3] ;
    var positionVal     = argArray[4] ;

    var linkFields      = argArray[6] ;
    var displayOrder    = argArray[7] ;
	if(sqlData.toUpperCase().indexOf("ORDER BY")==-1){
		//add order by clause based on value of radio button
		if(radioval=="D"){
			sqlData = sqlData.concat(" ORDER BY description ");
		}else{
			sqlData = sqlData.concat(" ORDER BY code ");
		}
	}

	//enhancement ends
    var url = "sqlData="+escape(sqlData) ;
    for(i = 0 ; i<dataNameArray.length ; i++) {
        if(positionVal.indexOf( toString(i) ) == -1){
            url += "&f"+(i+1)+"="  +dataValueArray[i] ;
            url += "&f"+(i+1)+"T=" +dataTypeArray[i] ;
        }
    }
	var positionValArr = positionVal.split( "," ) ;
    var codePosition = parseInt( positionValArr[0] ) ;
    var descPosition = parseInt( positionValArr[1] ) ;
    if(callFrom != 0){
        if( radioval =="C" ){
            url += "&f" + codePosition + "=" + escape( document.getElementById("search_text").value ) ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value ) ;
        }
    }else{
        if(displayOrder == DESC_CODE){
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
            //alert("descPosition:"+descPosition+argArray[5])
        }else{
            url += "&f" + codePosition + "=" + escape( argArray[5] ) ;
            url += "&f" + descPosition + "=" ;
        }
    }
    url += "&f" + codePosition + "T=String" ;
    url += "&f" + descPosition + "T=String" ;

    if(callFrom != 0)
        url += "&sc=" + escape(document.getElementById("search_criteria").options.value) ;
    else
        url += "&sc=S" ;
    url += "&displayOrder=" + displayOrder ;
    if( displayOrder == DESC_CODE ) {
        if( linkFields == CODE_LINK )
            linkFields = DESC_LINK ;
        else if ( linkFields == DESC_LINK )
            linkFields = CODE_LINK ;
    }

    url += "&linkFields=" + linkFields ;
    return url ;
}

function searchorderid(obj)
{
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var sql="SELECT  to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') DESCRIPTION, ORDER_ID CODE FROM OT_PENDING_ORDER WHERE PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' AND upper(ORDER_ID) like upper(?) AND upper(ORDER_DATE_TIME) like upper(?) order by 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookupfororderid("Order Id", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value=returnedValues[0];
	}
}

async function CommonLookupfororderid(title, pArgumentArray){
	//alert("32948");
    var retVal = new String();
    var dialogHeight= "28" ;
    var dialogWidth = "70" ;
    var status = "no";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open( "GET", "../../eOT/jsp/OrderidLookupResult.jsp?callFrom=0&"+formQueryStringorderid(pArgumentArray,0),false);
    xmlHttp.send( xmlDoc );
    responseText=localTrimString(xmlHttp.responseText);
	//alert(responseText);
    //eval(responseText);
	//alert(responseText);
    if(firstCodeVal == ""){
        var dialogUrl = "../../eoT/jsp/OrderidLookup.jsp?title="+title ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		//alert(returnVal);

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
     }else{
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}

function formQueryStringorderid( pArgumentArray, callFrom ) {
    var argArray
    if(callFrom != 0)
        argArray = window.dialogArguments ;
    else
        argArray = pArgumentArray

    var sqlData         = argArray[0] ;
    var dataNameArray   = argArray[1] ;
    var dataValueArray  = argArray[2] ;
    var dataTypeArray   = argArray[3] ;
    var positionVal     = argArray[4] ;

    var linkFields      = argArray[6] ;
    var displayOrder    = argArray[7] ;
	//enhancement code - added to provide query result ordered by code or description based the radio button selection, only if supplied query does not have a ORDER BY clause

	if(sqlData.toUpperCase().indexOf("ORDER BY")==-1){
		//add order by clause based on value of radio button
		if(radioval=="D"){
				sqlData = sqlData.concat(" ORDER BY description ");
		}else{
				sqlData = sqlData.concat(" ORDER BY code ");
		}
	}

	//enhancement ends
    var url = "sqlData="+escape(sqlData) ;
	
    for(i = 0 ; i<dataNameArray.length ; i++) {
        if(positionVal.indexOf( toString(i) ) == -1)
        {
            url += "&f"+(i+1)+"="  +dataValueArray[i] ;
            url += "&f"+(i+1)+"T=" +dataTypeArray[i] ;
        }
    }
    var positionValArr = positionVal.split( "," ) ;

    var codePosition = parseInt( positionValArr[1] ) ;
    var descPosition = parseInt( positionValArr[0] ) ;

    if(callFrom != 0)
    {
        if( radioval =="C" ) {
            url += "&f" + codePosition + "=" + escape( document.getElementById("search_text").value ) ;
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value ) ;
        }
    }
    else
    {
        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
            //alert("descPosition:"+descPosition+argArray[5])
        }
        else
        {
            url += "&f" + codePosition + "=" + escape( argArray[5] ) ;
            url += "&f" + descPosition + "=" ;
        }
    }

    url += "&f" + codePosition + "T=String" ;
    url += "&f" + descPosition + "T=String" ;

    if(callFrom != 0)
        url += "&sc=" + escape(document.getElementById("search_criteria").options.value) ;
    else
        url += "&sc=S" ;

    url += "&displayOrder=" + displayOrder ;
    if( displayOrder == DESC_CODE ) {
        if( linkFields == CODE_LINK )
            linkFields = DESC_LINK ;
        else if ( linkFields == DESC_LINK )
            linkFields = CODE_LINK ;
    }

    url += "&linkFields=" + linkFields ;
    //alert( "urlFinal:"+url );
    return url ;
}


function storeValorderid(currad) {
//	alert("currad"+currad);
    radioval=currad.value;
//	alert("radioval"+radioval);
}

function valtextorderid(comp) {
    var txt=comp.value
    CallDescFrameorderid(this);
}


function resetFormorderid( formObj )
{
    formObj.reset();
 //   parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}

function initializeTextorderid() {
//	alert("enter INTIAL");
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
	//alert(document.getElementById("search_text").value);
    //makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
		//alert("HELLO");
        fromCalledPage = true
        CallDescFrameorderid() ;
    }
}


function CallDescFrameorderid() {
	//alert("SDFDSF");
//    alert(formQueryStringorderid());
    parent.lookup_detail.location.href = "../../eOT/jsp/OrderidLookupResult.jsp?" + formQueryStringorderid();
}

function Modifyorder(obj){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;
	var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
	//alert("code1"+code1+"code2"+code2);
    var retVal = code1 + "\"" + code2 ;
	//alert(retVal);
    top.window.returnValue = retVal ;
    top.close()
}
function refreshdetails()
{
parent.qa_query_result.location.href = '../../eCommon/html/blank.html';
parent.qa_query_result_tail.location.href='../../eCommon/html/blank.html';
}

function selectstages(){
	var frmobj=document.forms[0];
	var currstage=document.forms[0].currstage_code.value;
	var stages_change= document.forms[0].stages;
	if(currstage=="*A" ){
		document.forms[0].stages.disabled=true;
	}else{
		document.forms[0].stages.disabled=false;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="BookingValidation.jsp?currstage="+currstage+"&stages=YES";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var resTxt=trimString(xmlHttp.responseText);
		//alert(resTxt);
		if(resTxt=="##"){
			var len=stages_change.length;
			for(var i=len;i>0; i--){
				stages_change.remove(i);
			}
		}
		if(resTxt!="##"){	
			var pt_array  = resTxt.split("###");
			var pt_array_1=pt_array[0];
			var pt_array_2=pt_array[1];
			var stage_desc= pt_array_1.split("#");
			var stage_code_1= pt_array_2.split("::");
			var len=stages_change.length;
			for(var i=len;i>0; i--){
				stages_change.remove(i);
			}
			var j=1;
			for(len=0;len<stage_desc.length&&len<stage_code_1.length;len++){
				stages_change.options[j++]=new Option(stage_desc[len],stage_code_1[len]);
			 }
		}
	}				
}
function getserialno()
{
	var sequence=new Array();
	var currstage=document.forms[0].currstage_code.value;
	var facility_id=document.forms[0].facility_id.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="BookingValidation.jsp?currstage="+currstage+"&stages=NO"+"&facility_id="+facility_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var resTxt=trimString(xmlHttp.responseText);
	//alert(resTxt);
	var sequence  = resTxt.split("##");
	document.forms[0].next_stage_code_1.value=sequence[0];
	document.forms[0].next_specific_ind_1.value=sequence[1];
	document.forms[0].next_action_done_1.value=sequence[2];
	document.forms[0].next_stage_desc_1.value=sequence[3];
	document.forms[0].previlage_1.value=sequence[4];
}

function displaydetails(booknum,surg,spec){
	dialogHeight = "5" ;
	var dialogWidth  = "20" ;
	var dialogTop    = "300";
	var dialogLeft   = "300";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var param="booknum="+booknum+"&surg="+surg+"&spec="+spec;
	//	alert(param);
	retVal=window.showModalDialog("../../eOT/jsp/Waitliststatusdetails.jsp?"+param,arguments,features);
}
function hideToolTip3(){
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}

function  reasonToolTip3(stvar,indx){
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable3' cellpadding=0 cellspacing=0 border='0' class='BOX' width='50%' height='70%' align='center'>";
		
	for( cou=0;cou<arr.length;cou+=2){
                msg=arr[cou];
                tab_dat+= "<tr>";
                tab_dat+= "<td>"+arr[cou]+arr[cou+1]+"</td>";
                tab_dat+= "</tr> ";                             
        }
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer3").innerHTML = tab_dat;
	resizeWindow3();
}
function resizeWindow3(){
	bodwidth =parent.frames[1].document.body.offsetWidth-300;
	bodheight = parent.frames[1].document.body.offsetHeight-300;

	var x =event.x-300;
	var y =event.y-300;

	x = x + (document.getElementById("tooltiplayer3").offsetWidth)
	y = y + (document.getElementById("tooltiplayer3").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer3").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer3").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer3").style.posLeft= x
	document.getElementById("tooltiplayer3").style.posTop = y
	document.getElementById("tooltiplayer3").style.visibility='visible'
}

function searchreason(obj,obj1){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmobj=document.forms[0];
	var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('SC')  AND NVL(ACTIVE_YN,'N')='Y') AND UPPER(REASON_DESC) LIKE UPPER(?) AND UPPER(REASON_CODE) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.reason.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		obj1.value = returnedValues[0];
	} 
	else{
		obj.value = '';
		obj1.value = '';
	} 

}

function searchItemSelect(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];
	var locale=obj1.locale.value;
	var sql="";
	if(obj1.item_type.value=='I')
	//Code altered by rajesh for PHASE 3.	
	//sql="SELECT SHORT_DESC DESCRIPTION,INSTR_CODE CODE FROM OT_INSTRUMENT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(INSTR_CODE) like upper(?) order by 2 ";
		sql="SELECT LONG_DESC DESCRIPTION,INSTR_CODE CODE FROM OT_INSTRUMENT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(INSTR_CODE) like upper(?) order by 2 ";
	else if(obj1.item_type.value=='E')
		//Code altered by Selvam for PHASE 3 Delivery
		//	sql="SELECT SHORT_DESC DESCRIPTION,EQUIPMENT_CODE CODE FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID ='"+locale+"'  AND  NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(EQUIPMENT_CODE) like upper(?) order by 2";
		sql="SELECT LONG_DESC DESCRIPTION,EQUIPMENT_CODE CODE FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID ='"+locale+"'  AND  NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(EQUIPMENT_CODE) like upper(?) order by 2";
	else if(obj1.item_type.value=='P')
		//Code altered by Selvam for PHASE 3 Delivery
		//sql="SELECT SHORT_DESC DESCRIPTION,PACKAGE_CODE CODE FROM OT_PACKAGE_HDR WHERE  NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(PACKAGE_CODE) like upper(?) order by 2 ";
		sql="SELECT LONG_DESC DESCRIPTION,PACKAGE_CODE CODE FROM OT_PACKAGE_HDR WHERE  NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(PACKAGE_CODE) like upper(?) order by 2 ";
	else if(obj1.item_type.value=='S')
		sql="SELECT SHORT_DESC DESCRIPTION,PROSTHESIS_CODE CODE FROM OT_PROSTHESIS WHERE  NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(PROSTHESIS_CODE) like upper(?) order by 2";
	else if(obj1.item_type.value=='R')
		sql="SELECT ROLE_DESC DESCRIPTION,ROLE_ID CODE FROM OT_ROLES_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND upper(ROLE_DESC) like upper(?) AND upper(ROLE_ID) like upper(?) order by 2";
	else{
		//alert("Item type cannot be NULL");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.Itemtype.label","Common")+msgArray[1]);
		return false;
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.resourcetype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].item_desc.value = returnedValues[1];
		document.forms[0].item_id.value = returnedValues[0];	
	}else{
		document.forms[0].item_id.value = '';
		document.forms[0].item_desc.value = '';
	} 
}

function  displayToolTip4(patid,bookingnum,orderid,fl){
	var param='';
	param+=patid+","+bookingnum+","+orderid;
	var menu_id_list;
	var	menu_name_list;
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
    menu_id_list	= new Array("16","17");
	//Modified by Selvam 25-Oct-2006
	//menu_name_list	= new Array("Patient History","Pre-Anaesthesia Evaluation");
	menu_name_list	= new Array(getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));

	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];		
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'OTMENULAYER'  nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a   href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow();
}

function openHistoryforwaitlist(patient_id,order_num){ 
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " order_num=\""+ order_num + "\" ";	
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PatientHistoryParams.jsp",false);
	xmlHttp.send(xmlDoc);
	retVal = trimString(xmlHttp.responseText);
	//alert("retVal--"+retVal);
	var pt_array  = retVal.split("::");
	var HTML = "<html>";
	HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>";
	HTML += "<input type='text' name='patient_id' id='patient_id' value= '"+patient_id+"'>"; 
	HTML += "<input type='text' name='accession_type' id='accession_type' value= 'OT'>"; 
	HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '"+pt_array[0]+"'>";
	HTML += "<input type='text' name='patient_class' id='patient_class' value= '"+pt_array[1]+"'>";
	HTML += "<input type='text' name='mode' id='mode' value= 'R'>"; 
	HTML += "</form>";
	HTML += "</html>";
	parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
	parent.parent.parent.messageFrame.document.forms[0].submit();
 }


function funResetAll(){
	var obj=document.forms[0];
	obj.SURGEON.value='';
	obj.SPECIALITY_DESC.value='';
	obj.PREFERRED_MONTH.value='';
	obj.SURGEON_CODE.value='';
	obj.PROCEDURE.value='';
	obj.SPECIALITY_CODE.value='';
	obj.surButton.disabled=false;
	obj.spcButton.disabled=false;
	obj.probutton.disabled=false;
	parent.qa_query_result.location.href = "../../eCommon/html/blank.html";
	parent.qa_query_result_tail.location.href="../../eCommon/html/blank.html";
	
}

function isValidDate(obj){
	/*
	if(obj.value!=""){
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		//		if (arr_date.length != 3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is dd/mm/yyyy.",obj);
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		//		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!arr_date[0]) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		//		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!arr_date[1]) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		//if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (!arr_date[2]) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);	
	}*/
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		//alert("Current Date 3751"+str_date);
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		//		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
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

function isValidMonth(obj){
	var RE_NUM =/^\d{2}\/+\d{4}$/
	var str_date = obj.value;
	var arr_date = str_date.split('/');
	
	var dt_date = new Date();
	/*
	if(obj.value!=""){
		if(!RE_NUM.test(str_date) && arr_date.length!=2)	return cal_error ("Invalid date format: '" +str_date + "'.\nFormat accepted is MM/YYYY.",obj);
		if (arr_date[0] < 1 || arr_date[0] > 12) return cal_error ("Invalid month value: '" + arr_date[0] + "'.\nAllowed range is 01-12.",obj);
		if( arr_date[1]<dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[1] + "'.\nLess than Current Year Not Allowed .",obj);	
	}
	*/
	var flag=true;
	if(obj.value!=""){
		if(!RE_NUM.test(str_date) && arr_date.length!=2) flag=false;
		if (arr_date[0] < 1 || arr_date[0] > 12) flag=false;
		if( arr_date[1]<dt_date.getFullYear() ) flag=false;	

		if(flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true
}
function isValidTime(obj){
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
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

function clearSpltyCode(obj){
	if(obj.value=="")
		document.forms[0].SPECIALITY_CODE.VALUE="";
}

function callCalendarObj(obj){
	var formObj = document.forms[0];
	var check_box = formObj.ward_informed_yn;
	if(check_box.checked==true){
		return showCalendar(obj);
	}
	return false;
}

function checkWardInformedYN(){
	var formObj = document.forms[0];
	imgObj1=document.getElementById('img1');
	imgObj2=document.getElementById('img2');
	//imgObj3=document.getElementById('img5');
	if(formObj.ward_informed_yn.checked==true){
		formObj.inform_date.disabled=false;
		formObj.inform_time.disabled =false;
		var arr =getSysDateTime().split(" ");
		formObj.inform_date.value=arr[0];
		formObj.inform_time.value = arr[1];
		imgObj1.src = "../../eCommon/images/mandatory.gif";
		imgObj2.src = "../../eCommon/images/mandatory.gif";
		//imgObj3.src = "../../eCommon/images/CommonCalendar.gif";
		formObj.cancelled_remarks.disabled=false;
		//alert("checked");
	}else{
		formObj.inform_date.value="";
		formObj.inform_time.value = "";
		formObj.inform_date.disabled=true;
		formObj.inform_time.disabled =true;
		imgObj1.src = "../../eCommon/images/Blank1.gif";
		imgObj2.src = "../../eCommon/images/Blank1.gif";
		//imgObj3.src = "../../eCommon/images/Blank1.gif";
		//imgObj3.onClick="callDummy()";
		//imgObj3.style.cursor="Normal"
		formObj.cancelled_remarks.disabled=true;
		formObj.cancelled_remarks.value="";
		//alert("unchecked");
	}
}

function getSysDateTime(){
	var xmlStr ="<root></root>";
	var temp_jsp="HoldingAreaValidation.jsp?func_mode=getSysDateTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return localTrimString(responseText);
}


//Asst Surgeon Code added on 19/12
function searchAsstSurgeon(obj,target){
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var formObj=document.forms[0];
	var locale = formObj.locale.value;

	//sql  = "SELECT PRACTITIONER_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND ( (PRIMARY_SPECIALITY_CODE = '"+splty_code+"') OR (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+facility_id+"'  AND SPECIALITY_CODE = '"+splty_code+"'))) AND upper(PRACTITIONER_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	var sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') != 'S'  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";
	//alert(sql);
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = CommonLookup(getLabel("eOT.Surgeon.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value = returnedValues[0];
		obj.value = returnedValues[1];
	}else{
		target.value = "";
		obj.value = "";
	} 
}


function callDateCheck(from,to) {
	var fromarray; var toarray;
    var fromdate = from ;
    var todate = to ;
	 var arr = new Array(todate,fromdate)
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			//var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
			var error = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT").replace("#",getLabel("Common.todate.label","Common")).replace("#",getLabel("Common.fromdate.label","Common"));
			alert(error);
			 return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}




function saveAsstSurgeons(){
	var frmObj=document.forms[0];
	var asstSurg1=frmObj.asst_surgeon_code1.value;
	var asstSurg2=frmObj.asst_surgeon_code2.value;
	var surgeon_code=frmObj.surgeon_code.value;
	var booking_no=frmObj.booking_no.value;
	/*var asstSurgeon=getLabel("eOT.AsstSurgeon.Label","OT");
	var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
	var msgArray = msg.split("{1}");
	/*if((asstSurg1=="") && (asstSurg2==""))
	{
		alert(msgArray[0]+asstSurgeon+ " 1 & "+asstSurgeon+" 2 "+msgArray[1]);
		return;
	}*/
	var dup_flag = false;
	if(asstSurg1.length>0 || asstSurg1.length>0 || asstSurg2.length>0 ){
		dup_flag = true;
	}

	if(dup_flag){
		if(asstSurg1==surgeon_code || asstSurg2==surgeon_code || asstSurg1==asstSurg2 )
		{
			alert(getMessage("RECORD_ALREADY_EXISTS","Common"));
			return;
		}
	}
	var xmlStr ="<root></root>";
	var temp_jsp="RecordAsstSurgeon.jsp?booking_no="+booking_no+"&asstSurgeon1="+asstSurg1+"&asstSurgeon2="+asstSurg2+"&surgeon_code="+surgeon_code;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);
	var retVal = trimString(xmlHttp.responseText);
	window.returnValue=retVal;
	window.close(); 

}



