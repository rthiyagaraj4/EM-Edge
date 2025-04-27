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
//Declaration for Amazon Changes
var prevObjID;
var prevImgObj;
var disappeardelay= 250;
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;
var radioval		= "C";// using for Order ID Lookup
var firstCodeVal	= "" ;
var firstDescVal	= "" ;
var duplPatientIdSearchFlag = true;//PMG2014-CRF-0024

function reset()
{	
	var header_frame=document.header_frame;
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
			frames[1].frames[1].frames[0].document.forms[0].reset();
			frames[1].frames[1].frames[1].document.location.href ="../../eCommon/html/blank.html";
		}
	}
}

async function apply()
{
	var headFrm=header_frame;

	var sex_value='';	
	var authChkFlag = 'YES'; //049829
	if(headFrm != null && headFrm !='') 
	{
		
		var hrmin1="";
		var hrmin2="";
		var formObj = headFrm.document.PreOperHdr;	
		
		var orderId = formObj.orderid.value;
		var booking_num=formObj.booking_num.value;	
		var oper_room_code=formObj.roomCode.value;	
		var oper_room_desc=formObj.waitlist_no.value;
		
		oper_room_desc=encodeURIComponent(oper_room_desc);
		var patient_class=formObj.episode_type.value;
		var physician_code    = formObj.surgeonCode.value;	
		var physician_desc    = formObj.surgeonName.value;	
		
		physician_desc=encodeURIComponent(physician_desc);	
		var speciality_code = formObj.SPECIALITY_CODE.value;
		var speciality_desc = formObj.SPECIALITY_DESC.value;	
	
		speciality_desc=encodeURIComponent(speciality_desc);
	
		var booking_date_time    = formObj.booking_date.value+" "+formObj.start_time.value;   
		
		var med_serv_code   =    getMedicalServiceCode(speciality_code);
	
		var patient_id      =    formObj.patient_id.value;	
	
		var locale      =    formObj.locale.value;
	
		var facility_id=formObj.facility_id.value;
	
		var nursing_unit_code      =    formObj.sourceDesc.value;
		var nursing_unit_desc      =    encodeURIComponent(formObj.Source_code.value);
	
		if (formObj.anaes_review.checked){
		
			formObj.anaes_review1.value = 'Y';
		}
		else{
		
			formObj.anaes_review1.value = 'N';
		}
		var Anaesthetia_code = formObj.Anaesthetia_code.value;
	var parametrs ;
	sex_value=formObj.sex.value;
	var obj2=message_search_frame.detailframe.frames[1].document.forms[0];
	var selectAuthFlag = obj2.selectAuthFlag.value;
	var duration=obj2.total_hour.value+":"+obj2.total_min.value;
	var over_booking_case_yn=formObj.over_booking_case_yn.value;
	var PreOpPreparationDays=formObj.PreOpPreparationDays.value;
		var customerId = message_search_frame.detailframe.message_search_frame.document.forms[0].customerId.value; //IN050472
	if(over_booking_case_yn=="N")
	{
		
	var th_end_time=formObj.end_time.value;
	var start_time=formObj.start_time.value;
    th_end_time=th_end_time.split(":");
    start_time=start_time.split(":");
	var hr2=parseInt(Math.abs(obj2.total_hour.value));
	var min2=parseInt(Math.abs(obj2.total_min.value));
	var h2=parseInt(Math.abs(th_end_time[0]));
	var m2=parseInt(Math.abs(th_end_time[1]));
	var hr1="";
	var min1="";
	var h1=parseInt(Math.abs(start_time[0]));
	var m1=parseInt(Math.abs(start_time[1]));
	var hr="";
    var min="";
	var flagtime=true;
			if(m2==m1)
			{
		hr1=h2-h1;
		min1=0;
	}
	else if(m2>m1)
	{  

		hr1=h2-h1;
		min1=m2-m1;
			}
			else 
	{   
		hr1=h2-h1-1;
		min1=m2-m1+60;
	}
    hr1=parseInt(Math.abs(hr1));
	min1=parseInt(Math.abs(min1));
    hr2=hr2*60;
	hrmin2=hr2+min2;
	hr1=hr1*60;
	hrmin1=hr1+min1;
		if(hrmin1>=hrmin2)
			flagtime=true;
			else
		flagtime=false;
	}
		else if(over_booking_case_yn=="Y") {
		
			flagtime=true;
		}
	if(flagtime==true)
	{
   	 if(duration=="00:00")
	 {
			var msg = getMessage("CANNOT_BE_BLANK","OT");
	        var msgArray = msg.split("&");
			msg1=msgArray[0]+getLabel("Common.duration.label","Common")+msgArray[1];
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
			//return false;
	 }
			else if(funsubmitCheckInDtls()==true)
			{
				 //049829 start
				if(selectAuthFlag != 'Y')
				{
					//authChkFlag = chkPermSlotsBooking(formObj.booking_date.value, formObj.roomCode.value, formObj.surgeonCode.value, formObj.SPECIALITY_CODE.value, hrmin2, customerId); //IN050472 & Commented against 55733
				}
				if(authChkFlag == 'YES')
				{
					 //049829 end
					formObj.booking_date.value =   convertDate(formObj.booking_date.value,'DMY',locale,'en') ;
				
					parametrs = "call_func=OT&Patient_Id="+patient_id+"&medical_service="+med_serv_code+"&booking_date_time="+booking_date_time+"&medical_speciality_desc="+speciality_desc+"&medical_speciality_code="+speciality_code+"&physician_desc="+physician_desc+"&physician_code="+physician_code+"&oper_room_code="+oper_room_code+"&oper_room_desc="+oper_room_desc+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&nursing_unit_short_desc="+nursing_unit_desc+"&PreOpPreparationDays="+PreOpPreparationDays;
					//alert();
					var obret=formApply(formObj,OT_CONTROLLER);
				
					//alert("obret value :"+obret);
					
					
					eval(obret);
					message1=message1.replace('<br>','');
					if(flag1==0)
					{
						formObj.booking_date.value =   convertDate(formObj.booking_date.value,'DMY','en',locale) ;
						var msgFrame=parent.messageFrame;
						if(message1.length==10)
						{
							messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage(message1,"OT");
							return false;
						}
						else
						{
							//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+message1;
							alert(message1);
						
							closeWindow();
							return false;
						}
					}
			else
			{
				
				alert(getMessage(localTrimString(message1),"SM"));
				var flag2=flag1.split("$$")
				var booking_num = flag2[1];
				var dialogHeight	= "11" ;
				var dialogWidth	= "25" ;
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
				var url = "../../eOT/jsp/BookingReports.jsp";
						if(sex_value.charAt(0)=='M')
							sex_value="M";
						else if(sex_value.charAt(0)=='F')
							sex_value="F";
						else
							sex_value="U";
				url=url+"?booking_num="+booking_num+"&sex="+sex_value;
				var p_module_id="OT";
				var p_report_id="OTRNOTIF";
				var nd_facility_id=facility_id;
				var params1="nd_booking_num="+booking_num+"&sex="+sex_value+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&nd_facility_id="+nd_facility_id+"&facility_id="+facility_id;
				if(formObj.ip_booking_yn.value=='Y')
					await openIPDialog(parametrs);
				await callReportOptionsFrameset(params1);
				//parent.window.returnValue=1;
				//parent.window.close();	
				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = 1;
    
				const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				dialogTag.close();
		 }
				} //049829 start
				else
				{
					var msgFrame=parent.messageFrame;
					messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
				}
				 //049829 end
		}
		}
		else
		{
		var msgtime=getMessage("APP-OT0146","OT");
		var msgFrame=parent.messageFrame;
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msgtime;
   }
	}
	else
	{
	var msgFrame=parent.messageFrame;
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
   }
}

async function callReportOptionsFrameset( params )
{
		var url		= "../../eCommon/jsp/report_options_frameset.jsp?"+params ;
		var dialogHeight	= "11" ;
		var dialogWidth	= "25" ;
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
		var reportURL 	= await window.showModalDialog( url, arguments, features ) ;
		//var reportURL 	= window.open( url, '_blank', features ) ;
		if ( reportURL != null ) {
			reportURL		= "../../eCommon/jsp/report_process.jsp?" + reportURL ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;
		}
}

function getMedicalServiceCode(speciality_code)
{

	var locale = header_frame.document.PreOperHdr.locale.value;

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

function getSurgeonSpeicality( surgeon_code )
{	
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

function getSurgSpecialityDesc( speciality_code )
{	
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

async function showSlipDialog()
{
	var dialogHeight 		= "40";
	var dialogWidth  		= "40";
	var dialogTop   		= "100";
	var dialogLeft   		= "50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/BookingSlip.jsp?",arguments,features);
}

function CheckMandatoryFields()
{
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

function assignResult( _result, _message, _flag)
{

	
  result1 = _result;
 
  message1  = _message;

  flag1 = _flag;

} 

function beforePost(str){}
function callAuthorization(obj,msg,msg_text,called_from)
{
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

async function funOTCheckDetail1(flag,flg,locale)
{
	if(flag=='Anesthetist')		 await callAnesthetist(locale);
	else if(flag=='Anesthesia')	 await callAnesthesia(locale);
	else if(flag=='Position')	 await callPosition(locale);
	else if(flag=='Surgeon')	 await callSurgeon(locale);
	else if(flag=='SurgeonSplty') await callSurgeonSplty(locale);
	else if(flag=='Speciality')  await callSpeciality(locale);
	else if(flag=='Speciality1') await callSpeciality(locale);
	else if(flag=='SurgeryType') await callSurgeryType(locale);
	else if(flag=='Operation')	 await callOperation(locale);
	else if(flag=='OperationSplty') await callOperationSplty(locale);
	else if(flag=='Procedure')   await callProcedure(locale);
	else if(flag=='SourceType')  await callSourceType(locale);
	else if(flag=='CurrStage')   await callCurrentStage(locale);
	else if(flag=='TheatreType') await callTheatreType(locale);
	else if(flag=='Theatre')	 await callTheatre(flg,locale);
	else if(flag=='orderid')	 await callOrderId(locale);
	else if(flag=='Reason')		 await callReasonCode(locale);
	else if(flag=='WaitlistReason') await callReasonCode('1',locale);
	else if(flag=='Transfer')    await callTransfer(locale);
	else if(flag=='OrderCategory') await callOrderCategory(locale);
	else if(flag=='OrderType') await callOrderType(locale);
	else if(flag=='Catalog')    await callCatalog(locale);
	else if(flag=='Reshedule') await callReshedule(locale);
	else if(flag=='WaitList')  await callWaitList(locale);
	else if(flag=='Waitlist')  await callWaitList(locale);
	else if(flag='ItemSelect') await callItemSelect(locale);

}

async function callItemSelect(locale)
{
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
	var title=getLabel("Common.SourceType.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.item_desc.value=arr[0];
		obj.item_id.value=arr[1];
	}else{
		obj.item_desc.value='';
		obj.item_id.value='';
	}
}

async function callWaitList(locale)
{
	var column_sizes = escape("10%,10%,30%,5%,10%,10%,10%");
	// Modified by Selvam 24-Oct-06
	//var column_descriptions = escape("Waitlist,Patient Id,Patient Name,Sex,DOB,Surgeon,Preferred Date");
	var tit = getLabel('Common.WaitList.label','Common')+','+getLabel('Common.patientId.label','Common')+','+getLabel('Common.PatientName.label','Common')+','+getLabel('Common.gender.label','Common')+','+getLabel('Common.DateofBirth.label','Common')+','+getLabel('Common.Surgeon.label','Common')+','+getLabel('Common.PreferredDate.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	var frmObj=document.forms[0];
	var facilityid=frmObj.facility_id.value;
	var booking_no=frmObj.booking_no.value;
	var duration=frmObj.booking_duration.value;
	var booking_date=frmObj.booking_date.value;
	var waitlist_no=frmObj.waitlist_no.value;
	var old_waitlist_num=frmObj.waitlist_nm.value;
	//commented by subramanian on 01/08/2005
	//var sql=escape("SELECT WAITLIST_NUM WAITLIST_NUM1, PREFERRED_DATE PREFERRED_DATE1 FROM OT_WAITLISTING  WHERE OPERATING_FACILITY_ID='"+facilityid+"' AND STATUS = 'P' AND BOOKING_NUM <> '"+booking_no+"' AND TRUNC(BOOKING_DATE) > TRUNC(to_date('"+booking_date+"','dd/mm/yyyy')) AND TO_NUMBER(TO_CHAR(BOOKING_DURATION,'SSSSS'))<= TO_NUMBER(TO_CHAR(to_date('"+duration+"','hh24:mi'),'SSSSS'))");
	var sql=escape("SELECT A.WAITLIST_NUM WAITLIST_NUM1, A.PATIENT_ID PATIENT_ID1,  B.PATIENT_NAME PATIENT_NAME1, DECODE(B.SEX,'M','MALE','F','FEMALE','U','UNKNOWN') SEX1, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH1, A.TEAM_DOCTOR_CODE TEAM_DOCTOR_CODE1, NVL(A.PREFERRED_DATE,A.BOOKING_DATE) PREFERRED_DATE1 FROM OT_WAITLISTING A, MP_PATIENT B WHERE A.OPERATING_FACILITY_ID = '"+facilityid+"' AND     A.PATIENT_ID = B.PATIENT_ID AND A.STATUS = 'P' AND  A.BOOKING_NUM <> '"+booking_no+"' AND  TRUNC(A.BOOKING_DATE)  > TRUNC(to_date('"+booking_date+"','dd/mm/yyyy')) AND      TO_NUMBER(TO_CHAR(A.BOOKING_DURATION,'SSSSS'))<= TO_NUMBER(TO_CHAR(to_date('"+duration+"','hh24:mi'),'SSSSS'))");

	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
	var title=getLabel('Common.WaitList.label','Common');
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+waitlist_no;
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		frmObj.waitlist_no.value=arr[0];
	}else{
		//	frmObj.waitlist_no.value="";
		frmObj.waitlist_no.value=old_waitlist_num;
	}
	var param1="facility_id="+facilityid+"&waitlist_no="+frmObj.waitlist_no.value+"&booking_no="+booking_no;
	parent.detailframe.location.href="../../eOT/jsp/WaitListProcedureFrame.jsp?"+param1;
	frmObj.submit();
}

async function searchreasonforresch(obj)
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
	var locale=frmObj.locale.value;
	//var sql="select short_desc DESCRIPTION,ANAESTHESIA_CODE CODE from AM_ANAESTHESIA where NVL(Eff_Status,'X')='E' AND upper(short_desc) like upper(?) AND upper(ANAESTHESIA_CODE) like upper(?) order by 2";
	//var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND upper(REASON_DESC) like upper(?) AND upper(REASON_CODE) like upper(?) order by 2 " ;
	//Above is commented and modified as below by lakshmi against language_id issue
	var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND upper(REASON_DESC) like upper(?) AND upper(REASON_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"' order by 2 " ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eOT.RescheduleReason.Label","OT"), argumentArray );
	var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
	if((returnedValues != null) && (returnedValues != "") )  {
		
		document.forms[0].reason_desc.value = arr[1];
		document.forms[0].reason_code.value = arr[0];	
	}else{
		document.forms[0].reason_desc.value = '';
		document.forms[0].reason_code.value = '';	
	}
}

async function callReshedule(locale)
{
	var column_sizes = escape("60%,40%");               
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	//var sql=escape("select SHORT_DESC SHORT_DESC1,LOCN_TYPE LOCN_TYPE1  from AM_CARE_LOCN_TYPE where CARE_LOCN_TYPE_IND='O'");
	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");

	//Above is commented and modified as below by lakshmi against language_id issue
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");
	//var title='Reschedule Reason Search';
	var title=getLabel("Common.RescheduledReason.label","Common");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.reason_desc.value=arr[0];
		obj.reason_code.value=arr[1];
	}else{
		obj.reason_desc.value="";
		obj.reason_code.value="";
	}
}

async function callOnBlurReshedule(text,reschedule_value,locale)
{
	var column_sizes = escape("60%,40%");               
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	//var sql=escape("select SHORT_DESC SHORT_DESC1,LOCN_TYPE LOCN_TYPE1  from AM_CARE_LOCN_TYPE where CARE_LOCN_TYPE_IND='O'");
	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");

	//Above is commented and modified as below by lakshmi against language_id issue
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");
	//var title='Reschedule Reason Search';
	var title=getLabel("Common.RescheduledReason.label","Common");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+text.value;
	retVal=await callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.reason_desc.value=arr[0];
		obj.reason_code.value=arr[1];
	}else{
		obj.reason_desc.value="";
		obj.reason_code.value="";
	}
}


async function callOrderType(locale)
{	
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
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.order_type_desc.value=arr[0];
		obj.order_type_code.value=arr[1];
		obj.catalogbut.disabled=false;
	}else{
		obj.order_type_desc.value="";
		obj.order_type_code.value="";
		obj.catalogbut.disabled=true;
	}
}


async function callCatalog(locale)
{
	var locale = document.forms[0].locale.value;
	var column_sizes = escape("70%,30%");               
	var obj=document.forms[0];

	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit); 

	if(obj.order_type_code.value==''){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.OrderType.label","Common")+msgArray[1]);
		return;
	}
	//var sql=escape("SELECT SHORT_DESC SHORT_DESC1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1 FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN ('RD','RL') AND ORDER_CATEGORY = DECODE('"+obj.order_catagory.value+"','*A',ORDER_CATEGORY, '"+obj.order_catagory.value+"') AND ORDER_TYPE_CODE = NVL('"+obj.order_type_code.value+"', ORDER_TYPE_CODE) AND NVL(EFF_STATUS,'S') ='E'");
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, ORDER_CATALOG_CODE ORDER_CATALOG_CODE1 FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY IN ('RD','LB','PC','NC') AND ORDER_CATEGORY = DECODE('"+obj.order_catagory.value+"','*A',ORDER_CATEGORY, '"+obj.order_catagory.value+"') AND ORDER_TYPE_CODE = NVL('"+obj.order_type_code.value+"', ORDER_TYPE_CODE) AND NVL(EFF_STATUS,'S') ='E'");// As told by dilip on 26-06-2009 changed by sathish.K
	//var title='OrderType Search';
	var title=getLabel("Common.OrderType.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.catalog.value=arr[0];
		obj.order_catalog_code.value=arr[1];
	}else{
		obj.catalog.value="";
		obj.order_catalog_code.value="";
	}
}


async function callOrderId(locale)
{
	var column_sizes = escape("70%,30%");               
	var obj=document.forms[0];

	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.OrderID.label','Common')+','+getLabel('Common.OrderDateTime.label','Common');
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT ORDER_ID ORDER_ID1, to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') ORDER_DATE_TIME1 FROM OT_PENDING_ORDER WHERE PERFORMING_FACILITY_ID ='"+obj.facility_id.value+"'");
	//var title='OrderId Search';
	var title=getLabel("Common.OrderID.label","Common")
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].orderid.value;
	retVal=await callDialog(param);

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
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to;	
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	//MMS-QH-CRF-0186
	var ammendBooking = $('#ammendBooking').val();
	var ChkExistDays;	
	if(frmObj.chkBookingExistDays.value != '')
	{
		ChkExistDays="+"+" "+frmObj.chkBookingExistDays.value;
	}
	else
	{
		ChkExistDays="+ 0";
	}
	//MMS-QH-CRF-0186
	
	//	var sql="SELECT PATIENT_ID PATIENT_ID1,PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,SHORT_NAME SHORT_NAME1, SEX SEX1, SURGERY_NATURE_DESC SURGERY_TYPE1, SPECIALITY_DESC SPECIALITY_DESC1, TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, ORDER_ID ORDER_ID1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1 FROM OT_PENDING_ORDERS_VW   WHERE PERFORMING_FACILITY_ID = '"+frmObj.facility_id.value+"'";

	// added by rajesh for from/to date thai conversion
		var change_from_date = dateUtils(frmObj.from_date.value,locale); 
		var change_to_date = dateUtils(frmObj.to_date.value,locale);
		if(!callDateCheck(change_from_date,change_to_date)) return;

	if(frmObj.from_date.value!='')
	{
		var sql = " SELECT DISTINCT ";
		if((typeof(frmObj.priority) == 'undefined') || (frmObj.priority.value != null && frmObj.priority.value == ''))
		{
			sql += " A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code,B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT c.short_name FROM am_practitioner_lang_vw c WHERE c.practitioner_id = a.physician_id AND c.language_id ='"+locale+"') ordering_surgeon_name,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B  ";
			//KDAH-CRF-0283 [IN:050553] MMS-QH-CRF-186 added on 27-Sept-2015 & IN066057
			//ENCOUNTER_ID and EPISODE_TYPE Added Against TH-KW-CRF-0126
			sql += "WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'";
			sql += "AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
			
		}
		else if(frmObj.priority.value != null && frmObj.priority.value != '')
		{
			sql += " order_field_mnemonic, order_field_value, A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code, B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B, or_order_field_values c  WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND a.order_id = c.order_id AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' "; // KDAH-CRF-0283 [IN:050553]MMS-QH-CRF-186 & IN066057
			//ENCOUNTER_ID and EPISODE_TYPE Added Against TH-KW-CRF-0126
			sql += "and ORDER_FIELD_MNEMONIC = 'PRIORITY'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
		}

		var where = " ";
		if(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!='')
			where+=escape(" and A.SPECIALITY_CODE ='"+frmObj.speciality_code.value+"'");

		if(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!='') // start KDAH-CRF-0283 [IN:050553]
		{
			if(frmObj.customerId.value == 'KDAH')
				where += escape(" and A.physician_id ='"+frmObj.surgeon_code.value+"'");
			else
				where += escape(" and A.PERFORMING_TEAM_SURGEON ='"+frmObj.surgeon_code.value+"'");
		} // end KDAH-CRF-0283 [IN:050553]

		if(frmObj.order_id.value!=null && frmObj.order_id.value!='')
			where+=escape(" and A.ORDER_ID ='"+frmObj.order_id.value+"'");

		if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
			where +=escape(" AND A.PREF_SURG_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");

		if(frmObj.patient_id.value!=null && frmObj.patient_id.value!='')   
			where+=escape(" and PATIENT_ID ='"+frmObj.patient_id.value+"'");
		else if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!='') 
			where+= escape(" and short_name like '"+frmObj.patient_name.value+"%'");
		 if(frmObj.checkin_booking_flag.value=='CHECK_IN')
			where+= " and  A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='10' )";

		//if(ammendBooking == 'Y')
			//where += "order by A.PATIENT_ID,pref_surg_date1 ,b.long_desc,a.speciality_desc";
		where += "ORDER BY a.patient_id, pref_surg_date1, a.speciality_desc,b.long_desc"; //added by selvin
		sql+=where;
		// start KDAH-CRF-0283 [IN:050553]
		var param='sql='+sql+'&surgeonCode='+frmObj.surgeon_code.value+'&checkin_booking_flag='+frmObj.checkin_booking_flag.value+"&from="+from+"&to="+to+"&speciality_code="+frmObj.speciality_code.value+"&surgeon_code="+frmObj.surgeon_code.value+"&order_id="+frmObj.order_id.value+"&patient_id="+frmObj.patient_id.value+"&patient_name="+frmObj.patient_name.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&called_from="+frmObj.called_from.value; //+"&totalRecCnt="+totalRecCnt; //+"&totalRecCnt="frmObj.totalRecCnt.value; // Added [called_from] against for [IN:057473] 
		if(frmObj.priority != null && frmObj.priority != 'undefined')
			param += "&priorityValue="+frmObj.priority.value;
		param += "&bookingPriorityOrdersYN="+frmObj.bookingPriorityOrdersYN.value
						+"&customerId="+frmObj.customerId.value;
		// end KDAH-CRF-0283 [IN:050553]
		parent.parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtlFrame.jsp?'+param;	
		//End IN024288
	}
	else
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
}
function funPendingSearch()
{
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	var called_from = frmObj.called_from.value;  // [IN:057473]
	var change_from_date = dateUtils(frmObj.from_date.value,locale); 
	var change_to_date = dateUtils(frmObj.to_date.value,locale);
	//MMS-QH-CRF-0186
	var ammendBooking = $('#ammendBooking').val();
	var ChkExistDays;	
	if(frmObj.chkBookingExistDays.value != '')
	{
		ChkExistDays="+"+" "+frmObj.chkBookingExistDays.value;
	}
	else
	{
		ChkExistDays="+ 0";
	}
	//MMS-QH-CRF-0186
	if(!callDateCheck(change_from_date,change_to_date))
		return;
	if(frmObj.from_date.value != '')
	{
		var sql = " SELECT DISTINCT ";
			if((typeof(frmObj.priority) == 'undefined') || (frmObj.priority.value != null && frmObj.priority.value == '')) // KDAH-CRF-0283 [IN:050553]
		{
			sql += " A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code,B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id , (SELECT c.short_name FROM am_practitioner_lang_vw c WHERE c.practitioner_id = a.physician_id AND c.language_id ='"+frmObj.locale.value+"') as ordering_surgeon_name,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B  "; // KDAH-CRF-0283 [IN:050553 & 055758]////MMS-QH-CRF-0186			
				//ENCOUNTER_ID and EPISODE_TYPE Added Against TH-KW-CRF-0126
			sql += "WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'";
			sql += "AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
		}
		else if(frmObj.priority.value != null && frmObj.priority.value != '')
		{
				
			sql += " order_field_mnemonic, order_field_value, A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code,B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id , (SELECT c.short_name FROM am_practitioner_lang_vw c WHERE c.practitioner_id = a.physician_id AND c.language_id ='en') as ordering_surgeon_name,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B, or_order_field_values c  WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND a.order_id = c.order_id AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' ";// KDAH-CRF-0283 [IN:050553 & 055758] MMS-QH-CRF-0186 vikash added on 27-Sept-2015
			//ENCOUNTER_ID and EPISODE_TYPE Added Against TH-KW-CRF-0126
			sql += "and ORDER_FIELD_MNEMONIC = 'PRIORITY'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
		}

		var where = " ";

	   if(frmObj.priority != null && frmObj.priority != 'undefined' && frmObj.priority.value != '') // KDAH-CRF-0283 [IN:050553]
			where += escape(" AND order_field_value = '"+frmObj.priority.value+"'");
	   if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
			where += escape(" and A.SPECIALITY_CODE ='"+frmObj.SPECIALITY_CODE.value+"'");
	   if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='') // start KDAH-CRF-0283 [IN:050553]
	   {
			if(frmObj.customerId.value == 'KDAH')
				where += escape(" and A.physician_id ='"+frmObj.SURGEON_CODE.value+"'");
			else
			where += escape(" and A.PERFORMING_TEAM_SURGEON ='"+frmObj.SURGEON_CODE.value+"'");
		} // end KDAH-CRF-0283 [IN:050553]
		if(frmObj.orderid.value!=null && frmObj.orderid.value!='')
			where += escape(" and A.ORDER_ID ='"+frmObj.orderid.value+"'");
		if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
			where += escape(" AND A.PREF_SURG_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");
		if(frmObj.patientid.value!=null && frmObj.patientid.value!='')   
			where+=escape(" and PATIENT_ID ='"+frmObj.patientid.value+"'");
		else if(frmObj.patientName.value!=null&&frmObj.patientName.value!='') 
			where+= escape(" and short_name like '"+frmObj.patientName.value+"%'");
		 if(frmObj.checkin_booking_flag.value=='CHECK_IN')
			where+= " and  A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='10' )";
//		if(ammendBooking == 'Y')
			//where+= "order by A.PATIENT_ID,pref_surg_date1 ,b.long_desc,a.speciality_desc";
			  where += "ORDER BY a.patient_id, pref_surg_date1, a.speciality_desc,b.long_desc"; //added by selvin 057504
		sql += where;
		
		
		var param='sql='+sql+'&surgeonCode='+frmObj.SURGEON_CODE.value+ '&checkin_booking_flag='+frmObj.checkin_booking_flag.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&order_id="+frmObj.orderid.value+"&patient_id="+frmObj.patientid.value+"&patient_name="+frmObj.patientName.value+"&called_from="+called_from; // start KDAH-CRF-0283 [IN:050553] & [IN:057473]
		if(frmObj.priority != null && frmObj.priority != 'undefined')
			param += "&priorityValue="+frmObj.priority.value;
		param += "&bookingPriorityOrdersYN="+frmObj.bookingPriorityOrdersYN.value
						+"&customerId="+frmObj.customerId.value;
		// end KDAH-CRF-0283 [IN:050553]
		parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtlFrame.jsp?'+param;	
	}
	else
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
}

function validateMandatory(obj,validatStr,dispStr,messageFrame)
{
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
		// //messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;	
		messageFrame.src="../../eCommon/jsp/error.jsp?err_num="+errors ;	
		return false ;
    }
    return true ;
}

async function searchsourcetype(obj)
{	
	var result		=	false ;
	var formObj = document.forms[0];
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_class=formObj.episode_type.value;
	if(patient_class=='IP'|| patient_class=='DC'){
		sql="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
	}else if(patient_class=='EM'|| patient_class=='OP'){
		sql="SELECT CLINIC_CODE CODE, LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?)  ORDER BY 1" ;
		}else if(patient_class=='XT'){
		sql="SELECT REFERRAL_CODE CODE, LONG_DESC  DESCRIPTION  FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(REFERRAL_CODE) LIKE UPPER(?)  ORDER BY 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+getLabel("Common.SourceType.label","Common")+msgArray[1]);
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
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(getLabel("Common.SourceType.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//obj.value = returnedValues[1];
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		formObj.HLongRefSrcId.value=arr[0];
		formObj.sourceDesc.value=arr[0];
		formObj.Source_code.value=arr[1];
		if (typeof(preOperDiagArray) != 'undefined') 
		{
			showPreOperDiagLink();
		}
	} 
	else{
		formObj.HLongRefSrcId.value="";
		formObj.sourceDesc.value="";
		formObj.Source_code.value="";
	}
}

async function callSourceType(locale)
{
	var locale = document.forms[0].locale.value;
	var column_sizes = escape("60%,20%");   
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);  
	var sql;
	var obj=document.forms[0];

	if(obj.sourceType.value=='W'){
		sql=escape("SELECT LONG_DESC SHORT_DESC1, NURSING_UNIT_CODE NURSING_UNIT_CODE1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
	}else if(obj.sourceType.value=='C'){
		sql=escape("SELECT LONG_DESC SHORT_DESC1, CLINIC_CODE CLINIC_CODE1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'  AND FACILITY_ID = '"+obj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' ");
	}else if(obj.sourceType.value=='R'){
	sql=escape("SELECT LONG_DESC  SHORT_DESC1, REFERRAL_CODE  REFERRAL_CODE1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	}
	else
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.SourceType.label","Common")+msgArray[1]);
		return false;
	}
	//var title='Source Type Search';
	var title=getLabel("Common.SourceType.label","Common")
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.sourceDesc.value=arr[1];
		obj.Source_code.value=arr[0];
	}else{
		obj.sourceDesc.value="";
		obj.Source_code.value="";
	}
}

async function callProcedure(locale)
{
	var formObj=document.forms[0];
	var obj=document.forms[0];
	var proc_value=formObj.PROCEDURE.value;
	var column_sizes = escape("40%, 30%, 30%");
	var column_descriptions = getLabel('Common.description.label','common') + ',' +
							  getLabel('Common.code.label','common') + ',' +
							  getLabel('Common.speciality.label','common') 	;
	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT LONG_DESC SHORT_DESC,OPER_CODE OPER_CODE, (SPECIALITY_CODE || ' - ' ||  " +
			"(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +
					" FROM OT_OPER_MAST_LANG_VW OPER WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='" + locale + "'");//MMS-QH-CRF-0199
	var SPECIALITY_CODE_SQL = escape("SELECT B.SPECIALITY_CODE SPECIALITY_CODE, A.SHORT_DESC SHORT_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B " +
			"WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X')= 'E' AND NVL(B.STATUS,'E') != 'D' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2");
	var title=getLabel("Common.Procedure.label","Common");
	title=encodeURIComponent(title);
	var param = "title=" + title + "&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions +
	"&sql=" + sql + "&search_criteria=" + proc_value  + "&search_text=" + proc_value +
	"&SPECIALITY_CODE_SQL=" + SPECIALITY_CODE_SQL;
	var dir_param = "sql=" + sql
				 + "&search_criteria=S&search_by_index=0&search_text=" + proc_value
				 + "&search_by=SHORT_DESC1&column_types=VARCHAR2,VARCHAR2,VARCHAR2,"
				 + "&column_names=SHORT_DESC,OPER_CODE,SPECIALITY_CODE,&column_sizes=50%,25%,25%,"
				 + "&column_types1=VARCHAR2,VARCHAR2,VARCHAR2,&column_descriptions=" + column_descriptions;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTGeneralSearchRecordResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var arr=retVal.split("::");
	if(arr[3]=="1")
	{
		obj.PROCEDURE.value=arr[0];
		obj.oper_code.value=arr[1];
		var specArray = getSpecialityCodeDesc(arr[2]);
		obj.SPECIALITY_CODE.value= specArray [0];
		obj.SPECIALITY_DESC.value= specArray[1];
	}
	else
	{
			obj.PROCEDURE.value='';
			obj.SPECIALITY_CODE.value='';
			obj.oper_code.value='';
			retVal=await callDialog(param);
			retVal=checkNull(retVal);
			var arr=new Array();
			if(retVal!=''){
				arr=retVal.split("::");
				if(arr[1]==undefined) { 
				arr[1]="";
				arr[0]="";
				arr[2]="";
				}
				obj.PROCEDURE.value=arr[0];
				obj.oper_code.value=arr[1];
				var specArray = getSpecialityCodeDesc(arr[2]);
				obj.SPECIALITY_CODE.value= specArray [0];
				obj.SPECIALITY_DESC.value= specArray[1];
			}else{
				obj.PROCEDURE.value='';
				obj.SPECIALITY_CODE.value='';
				obj.oper_code.value='';
			}
	}
}

async function callOperation(locale)
{	
//alert("ca;l");
	//var frmObj=document.forms[0];
	
	
	var originalHeight1 = parent.parent.parent.document.getElementById('header_frame').style.height ;
	var originalHeight2 = parent.parent.parent.document.getElementById('message_search_frame').style.height ;
	parent.parent.parent.document.getElementById('header_frame').style.height = '0vh' ;
	parent.parent.parent.document.getElementById('message_search_frame').style.height = '85vh' ;

	var obj=document.forms[0];

	var column_sizes = escape("40%,20%,10%,20%,10%");             
	
	var oper_desc=document.forms[0].operation_desc.value
	
	var column_sizes = escape("30%,10%,10%,10%,10%");
	
	var hdrobj = parent.parent.parent.header_frame.PreOperHdr;//Added Against ML-MMOH-CRF-1939-US2                          
	          
	//alert("hdrobj value :"+hdrobj);
	var tit = getLabel('Common.description.label','Common') + ',' 
			+ getLabel('Common.code.label','Common') + ',' 
			+ getLabel('eOT.SideApplicable.Label','OT') + ','
			+ getLabel('Common.catalog.label','Common') + ','
			+ getLabel('Common.speciality.label','Common'); 
			
	var column_descriptions=encodeURIComponent(tit);
	var include_fpp_yn = obj.include_fpp_yn.value;
	var isincludefpp = obj.isincludefpp.value;
	var function_id = obj.function_id.value;
	var count = obj.count.value;
	var oper_code = obj.oper_code.value;
	var bill_flag = obj.bill_flag.value;
	//MMS-QH-CRF-0199	
	//var sql=escape("SELECT SHORT_DESC SHORT_DESC,OPER_CODE OPER_CODE, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, ORDER_CATALOG_CODE CATALOG_CODE, (SPECIALITY_CODE || ' - ' ||  " +"(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +" FROM OT_OPER_MAST_LANG_VW OPER WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='" + locale + "'");
	//Added Against ML-MMOH-SCF-1939-US2...starts
	if(include_fpp_yn === 'Y' && isincludefpp === 'true' && bill_flag === 'true' && count === '1')
	{
	var sql=escape("SELECT OPER.SHORT_DESC SHORT_DESC, OPER.OPER_CODE OPER_CODE,NVL (OPER.APPL_RIGHT_LEFT_FLAG, 'N') APPL_RIGHT_LEFT_FLAG, OPER.ORDER_CATALOG_CODE CATALOG_CODE,(OPER.SPECIALITY_CODE || ' - ' ||  " +"(SELECT VW.SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +"FROM OT_OPER_MAST_LANG_VW OPER,  OR_ORDER_CATALOG A WHERE NVL (STATUS, 'E') = 'E' AND OPER.LANGUAGE_ID = '" + locale + "' AND OPER.OPER_CODE = A.ORDER_CATALOG_CODE AND A.FPP_YN= ? AND A.ORDER_CATEGORY = 'OT'");
	}else{
	var sql=escape("SELECT LONG_DESC LONG_DESC,OPER_CODE OPER_CODE, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, ORDER_CATALOG_CODE CATALOG_CODE, (SPECIALITY_CODE || ' - ' ||  " +"(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +" FROM OT_OPER_MAST_LANG_VW OPER WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='" + locale + "'");
	}
	//Added Against ML-MMOH-SCF-1939-US2...ends
	var SPECIALITY_CODE_SQL = escape("SELECT B.SPECIALITY_CODE SPECIALITY_CODE, A.SHORT_DESC SHORT_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B " + " WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X')= 'E' AND NVL(B.STATUS,'E') != 'D' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2");
	

	
	var title=getLabel("Common.operation.label","common");
	
	title=encodeURIComponent(title);
	
	//Added Against ML-MMOH-CRF-1939-US2...starts
	var patient_class = hdrobj.episode_type.value;
	var episode_id  = hdrobj.episode_id.value;
	var encounter_id = hdrobj.encounter_id.value;
	
	//Added Against ML-MMOH-CRF-1939-US2...ends
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
	+sql+"&search_criteria="+document.forms[0].operation_desc.value +  "&SPECIALITY_CODE_SQL=" + SPECIALITY_CODE_SQL;
	param += "&patient_class=" + patient_class + "&episode_id=" + episode_id+"&encounter_id="+encounter_id+"&called_from=DIRECT_BOOKING";//Added Against ML-MMOH-CRF-1939-US2...
	retVal=await callDialog(param);	
	
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.operation_desc.value=arr[0];
		obj.oper_code.value=arr[1];
		obj.catalog_code.value=arr[3];

		if(arr[2]!='Y'){
			obj.appl_right_left_flag.disabled=true;
			obj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else
		{
		obj.imageflag.src="../../eCommon/images/mandatory.gif";
		obj.appl_right_left_flag.disabled=false;
		}
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
		var specArray = getSpecialityCodeDesc(arr[4]);
		obj.speciaitycode.value=specArray[0];
		if(obj.specialityCollect.value=='')
		{
		obj.specialityCollect.value+=","+specArray[0]+",";
		}
		else
		{
		obj.specialityCollect.value+=specArray[0]+",";
		}
	}else{
		obj.operation_desc.value='';
		obj.stdduration.value='';
		obj.oper_code.value='';
		obj.appl_right_left_flag.value='';
		}
		//ML-MMOH-CRF-1939-US003
		var fpp_category = "";
			    var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=getFppList&oper_code="+obj.oper_code.value;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				if(retVal!=''){
				arr=retVal.split("::");
				obj.fpp_category.value=arr[1];
				}
//	}
				parent.parent.parent.document.getElementById('header_frame').style.height = originalHeight1 ;
				parent.parent.parent.document.getElementById('message_search_frame').style.height = originalHeight2 ;

}

//Newly added by rajesh for defaulting operation from Booking Search page.

function onLoadOperation()
{
	var column_sizes = escape("40%,20%,10%,20%,10%");
	var oper_desc=document.forms[0].operation_desc.value
	var locale=document.forms[0].locale.value
	var book_proc=document.forms[0].book_proc.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=book_oper_code&locale="+locale+"&oper_code="+book_proc;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var obj=document.forms[0];
	retVal=checkNull(retVal).split("::::::::")[1];
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.operation_desc.value=arr[0];
		obj.oper_code.value=arr[1];

		if(arr[2]!='Y'){
			obj.appl_right_left_flag.disabled=true;
			obj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else
		{
		obj.imageflag.src="../../eCommon/images/mandatory.gif";
		obj.appl_right_left_flag.disabled=false;
		}
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
	//Modified by DhanasekarV against issue IN028258 on 28/07/2011
		if(obj.specialityCollect.value=='')
		{
		obj.specialityCollect.value+=","+arr[4]+",";
		}
		else
		{
		obj.specialityCollect.value+=arr[4]+",";
		}
	}else{
		obj.operation_desc.value='';
		obj.stdduration.value='';
		obj.oper_code.value='';
		obj.appl_right_left_flag.value='';
		}

//	}

}

async function callOperationSplty(locale)
{
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
	retVal=await callDialog(param);
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

function trimValue(dtDetails)
{
	var cou=dtDetails.indexOf(":");
	var msg='';
	for(var ii=cou-2;ii<dtDetails.length;ii++)
	msg+=dtDetails.charAt(ii);
	return msg;
}

async function callSurgeryType(locale)
{
	var column_sizes = escape("60%,20%,10%");
	var surg_type_desc=document.forms[0].surgeonType.value
	var srgry_type_desc=getLabel('Common.SurgeryType.label','Common')+" "+getLabel('Common.description.label','Common');
	var elec_emer=getLabel('Common.elective.label','Common')+"/"+getLabel('Common.emergency.label','Common');
	var tit = srgry_type_desc+','+getLabel('Common.SurgeryType.label','Common')+','+elec_emer;
	var column_descriptions = encodeURIComponent(tit);
	//var sql=escape("SELECT SHORT_DESC SHORT_DESC1, NATURE_CODE  NATURE_CODE1, NATURE_TYPE NATURE_TYPE1 FROM OT_NATURE_OF_SURGERY WHERE NVL(STATUS,'E') = 'E'");
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, NATURE_CODE  NATURE_CODE1, decode(NATURE_TYPE,'EL','Elective','EM','Emergency') NATURE_TYPE1 FROM OT_NATURE_OF_SURGERY WHERE NVL(STATUS,'E') = 'E'");

	var title=getLabel("Common.SurgeryType.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		obj.surgeonType.value=arr[0];
		obj.natureCode.value=arr[1];
		obj.natureType.value=arr[2];
		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}

	}else{
		obj.surgeonType.value="";
		obj.natureCode.value="";
		obj.natureType.value="";
	}
}

function getAvgTime(surgCode,operCode)
{
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
	return retVal;
}
async function callAnesthetist(locale){
	var column_sizes = escape("60%,30%");
	var obj=document.forms[0];
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.name.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Name,Code");
	var sql=escape("SELECT SHORT_NAME SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj.locale.value+"' AND  PRACT_TYPE IN ('AN') AND  NVL(EFF_STATUS,'X') <> 'S'");
	//var title='Anaesthetist Search';
	var title=getLabel("Common.Anaesthetist.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
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
async function searchanaesthesia(obj){
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

	returnedValues = await CommonLookup(getLabel("Common.Anaesthesia.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].Anaesthetia1_code.value = arr[1];
		document.forms[0].Anaesthetia_code.value = arr[0];
	}else{
		document.forms[0].Anaesthetia1_code.value = '';
		document.forms[0].Anaesthetia_code.value = '';
	}
}

async function callAnesthesia(locale){
	var column_sizes = escape("60%,30%");
	var locale = document.forms[0].locale.value;
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Description ,Code");
	var sql=escape("select short_desc short_desc1,ANAESTHESIA_CODE ANAESTHESIA_CODE1 from AM_ANAESTHESIA_LANG_VW where LANGUAGE_ID='"+locale+"' AND NVL(Eff_Status,'X')='E'");
	//var title='Anaesthesia Search';
	var title=getLabel("Common.Anaesthesia.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.Anaesthetia1_code.value=arr[0];
		obj.Anaesthetia_code.value=arr[1];
	}else{
		obj.Anaesthetia1_code.value='';
		obj.Anaesthetia_code.value='';
	}
}

async function searchposition(obj){
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

	returnedValues = await CommonLookup(getLabel("Common.PatientPosition.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].Position_desc.value = arr[1];
		document.forms[0].Patient_position.value = arr[0];
	}else{
		document.forms[0].Position_desc.value = '';
		document.forms[0].Patient_position.value = '';
	}
}

async function callPosition(locale){
	var column_sizes = escape("70%,30%");
	var locale = document.forms[0].locale.value;
	// Modified by Selvam 24-Oct-2006
	var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.PositionCode.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Position Description,Position Code");
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1,POSITION_CODE POSITION_CODE1 FROM OT_POSITION_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'Y') = 'Y'");
	//var title='Patient Position Search';
	var title=getLabel("Common.PatientPosition.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.Position_desc.value=arr[0];
		obj.Patient_position.value=arr[1];
	}else{
		obj.Position_desc.value='';
		obj.Patient_position.value=arr[1];
	}
}

async function callSurgeonSplty(locale){
	var column_sizes = escape("60%,40%");
	// Modified by Selvam 24-Oct-2006
	//	var tit = getMessage('Common.description.label','Common')+','+getMessage('eOT.PositionCode.Label','OT');
	//var column_descriptions = escape(tit);
	//var column_descriptions = escape("Surgeon Name,Surgeon Code");
	 var tit = getLabel('Common.SpecialtyDescription.label','Common')+','+getLabel('Common.SpecialtyCode.label','Common');
	 var column_descriptions = encodeURIComponent(tit);
	var obj=document.forms[0];
	var sql= "SELECT SHORT_NAME  SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ";
	if((obj.SPECIALITY_CODE.value != null) && (obj.SPECIALITY_CODE.value !=''))
		sql  = sql + " AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj.facility_id.value+"' AND SPECIALITY_CODE = '"+obj.SPECIALITY_CODE.value+"')";
	sql = escape(sql);
	//var title='Surgeon Search';
	var title=getLabel("Common.Surgeon.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SURGEON.value;
	retVal=await callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].SURGEON.value = arr[0];
		document.forms[0].SURGEON_CODE.value = arr[1];
	}else{
		document.forms[0].SURGEON.value = '';
		document.forms[0].SURGEON_CODE.value = '';
	}
}

async function callSurgeon(locale){
	var column_sizes = escape("60%,40%");
	//var column_descriptions = escape("Surgeon Name,Surgeon Code");
	var surgeon_name=getLabel("Common.Surgeon.label","Common")+" "+getLabel("Common.name.label","Common");
	var surgeon_code=getLabel("Common.Surgeon.label","Common")+" "+getLabel("Common.code.label","Common");
	var column_descriptions = surgeon_name+","+surgeon_code;//escape("Surgeon Name,Surgeon Code");
	var sql=escape("SELECT SHORT_NAME  SHORT_NAME1,PRACTITIONER_ID PHYSICIAN_ID1 FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+document.forms[0].locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ");
	//var sql=escape("SELECT SHORT_NAME SHORT_NAME1,PHYSICIAN_ID PHYSICIAN_ID1 FROM SY_PHYSICIAN_MAST");
	//var title='Surgeon Search';
	var title=getLabel("Common.Surgeon.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SURGEON.value;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].SURGEON.value = arr[0];
		document.forms[0].SURGEON_CODE.value = arr[1];
	}else{
		document.forms[0].SURGEON.value = '';
		document.forms[0].SURGEON_CODE.value = '';
	}
}

async function callSpeciality(locale){
var locale = document.forms[0].locale.value;
var column_sizes = escape("70%,30%");

 //Modified by Selvam 25-Oct-2006
 var tit = getLabel('Common.SpecialtyDescription.label','Common')+','+getLabel('Common.SpecialtyCode.label','Common');
 var column_descriptions = encodeURIComponent(tit);

//var column_descriptions = escape("Speciality Description ,Speciality Code");
var sql=escape("SELECT SHORT_DESC SHORT_DESC1,A.SPECIALITY_CODE SPECIALITY_CODE1 FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.EFF_STATUS,'X') = 'E' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE");
var obj=document.forms[0];
//var title='Speciality Search';
var title=getLabel("Common.speciality.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].SPECIALITY_DESC.value;
retVal=await callDialog(param);

retVal=checkNull(retVal);

	var arr=new Array();
if(retVal!='')
	{
	arr=retVal.split("::");
		 if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
	document.forms[0].SPECIALITY_DESC.value = arr[0];
	document.forms[0].SPECIALITY_CODE.value = arr[1];

	}
else
	{
	document.forms[0].SPECIALITY_DESC.value = '';
	document.forms[0].SPECIALITY_CODE.value ='';
	}
}


function funMoveNext(orderid,surgeonCode,prefDate,objCount,patId)
{
	var frmObj = document.forms[0];
	var obStr = "frmObj.xx"+objCount+".value";
	var  objS = eval(obStr);
	var param = '';
	var selSpecialityFlag = true;//186
	var facility_id = frmObj.facility_id.value;//PMG2014-CRF-0024
	var duplPatientIdSearchFlag = true;//PMG2014-CRF-0024
	var todaysDate = $('#todaysDate').val(); //PMG2014-CRF-0024 U-3
	var chkBoxSelect = $('#chkBoxSelect').val();//186
	var ammendBooking = $('#ammendBooking').val();//186
	var chkedRecsOrderIds = new Array();//186

	if(frmObj.checkin_booking_flag.value=="CHECK_IN")
	{

		if(todaysDate == prefDate)//PMG2014-CRF-0024  U-3
		{
		// PMG2014-CRF-0024 Start
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=duplPatientIdSearch&patient_id="+patId+"&facilityId="+facility_id,false);
		xmlHttp.send(xmlDoc);
		var duplPatientIdSearch = localTrimString(xmlHttp.responseText);
		var duplPatientIdSearchArray = duplPatientIdSearch.split("~");
		if(duplPatientIdSearchArray[0] == "REC_EXIST")
		{
			if(duplPatientIdSearchArray[1] == 'Y' && duplPatientIdSearchArray[2] == 'Y')
			{
				if(!window.confirm(getMessage("APP-OT0229","OT")))
					duplPatientIdSearchFlag = false;
			}
			else if(duplPatientIdSearchArray[1] == 'Y')
			{
				if(!window.confirm(getMessage("APP-OT0227","OT")))
					duplPatientIdSearchFlag = false;
			}
			else if(duplPatientIdSearchArray[2] == 'Y')
			{
					if(!window.confirm(getMessage("APP-OT0228","OT")))
						duplPatientIdSearchFlag = false;
			}
		}
		}//186
		if(chkBoxSelect == 'true')
		{
			selSpecialityFlag = false;
			
			getPrimarySpeciality();
			
			if($('#selSpeciality').val() != '')
			{
				selSpecialityFlag = true;
				var totalRecCnt = $('#totalRecCnt').val();
				for(var i=0; i<totalRecCnt; i++)
				{
					if($('#bukngsToSchedule'+i).is(':checked') && $.inArray($('#speciality_code_'+i).val(), chkedRecsOrderIds) == -1)
					{
						
						chkedRecsOrderIds.push($('#selOrderIds_'+i).val());
					}
				}
			}
		}//186

		if(duplPatientIdSearchFlag && selSpecialityFlag)//186
		{
			//PMG2014-CRF-0024 end
			param = "order_id="+orderid+
						  "&chkedRecsOrderIds="+chkedRecsOrderIds+
						  "&ammendBooking="+ammendBooking+
						  "&surgeon_name="+objS+
						  "&surgeon_code="+surgeonCode+
						  "&surgery_date="+prefDate+
						  "&called_from=BOOKING&patient_id="+patId;
			parent.parent.parent.frames[2].location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+param;
		}	//PMG2014-CRF-0024
	}
	else
	{
		param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS+"&called_from=OT_MENU ";
		parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
		parent.qa_query_result.location.href="../../eCommon/html/blank.html";
	}		//End Pending orderDtl
}
async function showRemarks(obj,fl,head,size){
	
	var ret1=obj.value;
	
	var heading = getLabel("eOT.ProcedureRemarksData.Label","OT");
	if (head!=null&&head!=''){
		heading=head;
	}
	if(fl=='2' && ret1!="undefined")
	{
    ret1=ret1.slice(0,size);
	obj.value=ret1;
	}

	var dialogHeight		= "24vh";
	var dialogWidth			= "40vw";
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no;overflow: hidden;";
	var arguments			= "";
	heading=encodeURIComponent(heading);
	obj1=encodeURIComponent(obj.value);
	var param='remarks='+obj1+'&heading='+heading+'&flag='+fl+'&size='+size;

	//obj1=obj1.replace(/%20/g,"$")
	var ret=await top.window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);

	var ret2;
	if(fl=='1' && ret!="undefined" ){
		ret2=ret.substring(0,size);
		obj.value=ret2;
	}
}
async function showRemarks1(obj,fl,head,size){
    var readOnlyYN="";
	if(fl=="0")
	readOnlyYN = "Y";
	else
	readOnlyYN = "N";
	var remarks = document.forms[0].pre_oper_diag.value;
	var remarks_hid = document.forms[0].pre_oper_diag.value;
	remarks = trimString(remarks);
	remarks = encodeURIComponent(remarks);
	title =encodeURIComponent(head);
	remarks = encodeURIComponent(remarks);
	var retVal = await window.showModalDialog("../../eOT/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&size="+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;overflow: hidden;");
	//retVal = encodeURIComponent(retVal);
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X'
		document.forms[0].pre_oper_diag.value = remarks_hid;
	}
	else{
		document.forms[0].pre_oper_diag.value = retVal;
	}
}


async function openNewDialogWindow(strVal,obj,size,disable_flag)
{
	//get rettext, assign value to hidden field
    /*var text_value=obj.value;
	 for(var i=0; i<text_value.length; i++)
    {
     if(  (text_value.charAt(i)=='>')   )
        {if(text_value.charAt(i+1)!=' ')
            {
              text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
              i++;
            }
        }
    }*/
    var val=obj.value;
	var text_value=checkSpl1(val);
    //text_value=decodeURIComponent(text_value);
	strVal=encodeURIComponent(strVal);
	var param='heading='+getLabel(strVal,'common')+'&para='+escape(text_value)+'&size='+size+"&disable_flag="+disable_flag;
	var retext= await window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'|| retext==''|| retext==null)
		retext=obj.value;
	else
	{
		obj.value=retext;
	}
}

function checkLength(){
	var frmObj=document.forms[0];
	var remrk=frmObj.remarks.value;
	if(remrk.length > 500){
		var max_len = getMessage("MAX_LENGTH_DATA","OT");
		var max_len_msg_arr = max_len.split("#");
		var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+" 500 "+max_len_msg_arr[2];
		alert(errors)
		var remark_spl_char=remrk.substring(0,499);
		frmObj.remarks.value=decodeURIComponent(remark_spl_char);
		return false;
	}
}

function methodSubmit()
{
	//Added Against ML-MMOH-CRF-1939-US2...starts
	var obj = parent.parent.parent.message_search_frame.detailframe.message_search_frame.dtlForm;
    var Hdrobj = parent.parent.parent.header_frame.document.forms[0];	
	var encounter_id = Hdrobj.encounter_id.value;
	if(encounter_id != "")
	{
		obj.operation_desc.disabled = false;
        obj.OperationLookUp.disabled = false;		
	}else{
		obj.operation_desc.disabled = true;
		obj.OperationLookUp.disabled = true;
	
	}
	//Added Against ML-MMOH-CRF-1939-US2...starts
	var frmObj=document.forms[0];	
	var ammendFlag = frmObj.ammendFlag.value;//186	
	var formObjHdr = '';
	if(ammendFlag == 'Y')
		formObjHdr = top.header_frame.document.forms[0];
	else
		formObjHdr = parent.parent.parent.header_frame.document.forms[0];

	var msgFrame = parent.parent.parent.messageFrame;//186
	var facility_id = formObjHdr.facility_id.value;
	var oper_room_code=formObjHdr.roomCode.value;
	var theatre_desc = formObjHdr.roomDesc.value;
	var patient_id = formObjHdr.patient_id.value;
	var encounter_id = formObjHdr.encounter_id1.value;
	var locale=formObjHdr.locale.value;//57876
	var oper_date = formObjHdr.BOOKING_DATE.value;
	oper_date=convertDate(oper_date,'DMY',locale,'en');//57876
	var patient_class = formObjHdr.episode_type.value;
	//var surgeon_code = formObjHdr.surgeonCode.value;
//	frmObj.operation_desc.disabled=false; 
	var surgeon_code = frmObj.surgeonCode.value;//1160 - Chaitanya
	var oper_code = frmObj.oper_code.value;
	var oper_desc = frmObj.operation_desc.value;
	var splty_code = frmObj.speciaitycode.value;	
	var orderid = frmObj.orderid.value;
	var called_from = frmObj.called_from.value;
	var msgFrame=parent.parent.parent.messageFrame;
	var obj=frmObj.codeCollect.value;
	var bill_flag=frmObj.bill_flag.value;
	var retVal="";
	var arr="";
	//CRF-004 Authorize Slots for Booking - Rajesh V
	var otParam = frmObj.ot_Param.value;
	var fpp_cat = frmObj.fpp_category.value;
	var fullVacant = frmObj.full_vacant.value;
	var durSofar = 0;
	var customerId = document.forms[0].customerId.value; //IN050472
	if(fullVacant == 'VACANT') 
	{
		if(otParam == 'Y' || otParam=='y')
		{
			if(frmObj.mode.value!='D')
			{
				var totHour1 = parent.frames[1].document.forms[0].total_hour.value;
				var totalMin1 = parent.frames[1].document.forms[0].total_min.value;
				var timeFrmFrame = document.forms[0].durFromFrame.value;
				var timeFrmFrameArr;
				if(timeFrmFrame.length<1)
				{
					durSofar = parseInt(parseInt(totHour1, 10)*60, 10)+parseInt(totalMin1, 10);//50456
				}
				else
				{
					timeFrmFrameArr = timeFrmFrame.split(':');
					durSofar = (parseInt(parseInt(totHour1, 10)*60, 10) + parseInt(totalMin1, 10)) - (parseInt(parseInt(timeFrmFrameArr[0], 10)*60, 10)+parseInt(timeFrmFrameArr[1], 10));//50456
				}
				var durForCurOprn = frmObj.duration.value;
				var spltyCodePend = "";
				if(splty_code.length>1)
				{
					spltyCodePend = splty_code;
				}
				else
				{
					spltyCodePend = formObjHdr.SPECIALITY_CODE.value;
				}
				if(surgeon_code.length<1){
					surgeon_code = '*ALL';
				}
				if(oper_date.length>1 && oper_room_code.length>1 && surgeon_code.length>1 && spltyCodePend.length>1 && durForCurOprn!='00:00' && durForCurOprn.length>1){
					var durForCurOprnArr = durForCurOprn.split(':');
					durSofar = parseInt(durSofar, 10) + (parseInt(durForCurOprnArr[0], 10)*60) + parseInt(durForCurOprnArr[1], 10);//50456
					var ret = chkPermSlotsBooking(oper_date,oper_room_code,surgeon_code,spltyCodePend,durSofar, customerId); //IN050472
					if(ret=='NO')
					{
						return false;
					}
					document.forms[0].durFromFrame.value = '';
				}
			}
		}
	}

	//CRF-004 Authorize Slots for Booking - Rajesh V
	if(called_from==""){
	var order_line_num="";
	called_from="DIRECT_BOOKING";
	orderid="";
	}
	if(validate()==false) {
		return false;
	}
	if(called_from=="DIRECT_BOOKING"){
	/* when we are selecting the records  this fiels should be mandatory for billing values only through direct booking */

	var bookingDate=getLabel("Common.BookingDate.label","common");
	var encounterid=getLabel("Common.encounterid.label","common");
	var patientId=getLabel("Common.patientId.label","common");
	var patientclass=getLabel("Common.patientclass.label","common");
	//Newly added IF condition by rajesh on 20/04/2010 for CRF-20056-INT-0003.4
	var fields="";
	var names="";
	if(patient_class=="XT"){
		fields=new Array( formObjHdr.BOOKING_DATE,formObjHdr.episode_type,formObjHdr.patient_id);
		names=new Array(bookingDate,patientclass,patientId);
	}else{
		fields=new Array( formObjHdr.BOOKING_DATE,formObjHdr.episode_type,formObjHdr.patient_id,formObjHdr.encounter_id);
		names=new Array(bookingDate,patientclass,patientId,encounterid);
	}

	if(checkFields( fields, names, msgFrame)){flag=true;}
	else{flag=false;}
	if(flag==false)
	return false;
	}
	if(frmObj.mode.value=='I'){
		if(obj!=''&&obj!=null&&obj.indexOf(frmObj.oper_code.value)>=0){
			alert(getMessage("CODE_ALREADY_EXISTS","Common"));
			clearValues();
			return false;
		}
		if(obj==null) obj='';
		obj+=frmObj.oper_code.value+",";
		frmObj.codeCollect.value=obj
	}
	if(frmObj.oper_code.value==null||frmObj.oper_code.value==''){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("eOT.OperationDescription.Label","OT")+msgArray[1]);
		return false;
	}
	var mode=document.getElementById("mode").value;
	var remrk=encodeURIComponent(frmObj.remarks.value);
	if( checkFitOperation( facility_id,oper_room_code,theatre_desc,oper_code,oper_desc )==false ){
		top.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	var panel_str="";
	var bill_str="";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "order_catalog_code="+frmObj.catalog_code.value;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=from_direct_booking&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal1 = trimString(xmlHttp.responseText);
	if(retVal1== "Y")
		{
		if((frmObj.mode.value=="I" || frmObj.mode.value=="U") && bill_flag=="true")
		{
			retVal = callOrderLineCreation();
			arr = retVal.split("@@");
			//if(localTrimString(arr[0])=='BL0639')
			if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))
			{
			alert(getMessage("BL0639","BL"));
			var frmObj=document.forms[0];
			var strDetail=frmObj.codeCollect.value
			strDetail=strDetail.replace(frmObj.oper_code.value+",","");
			frmObj.codeCollect.value=strDetail;
			clearValues();
			return false;
			}
			if(arr[2]!=undefined)
			{
				if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			var frmObj=document.forms[0];
			var strDetail=frmObj.codeCollect.value
			strDetail=strDetail.replace(frmObj.oper_code.value+",","");
			frmObj.codeCollect.value=strDetail;
			clearValues();
			return false;
			}
			}
			 panel_str=arr[0].replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
			 bill_str=arr[1];
		}
		}
  // Added Against ML-MMOH-SCF-2510  
	var fpp_yn = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=getFppList&oper_code="+frmObj.oper_code.value;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal!=''){
	arr=retVal.split("::");
	fpp_yn = arr[0];
	}	
  // Added Against ML-MMOH-SCF-2510
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "oper_code=\""+  checkSpl( document.getElementById("oper_code").value ) + "\" ";
	xmlStr += "operation_desc=\""+  checkSpl( document.getElementById("operation_desc").value ) + "\" ";
	xmlStr += "appl_right_left_flag=\""+  checkSpl( document.getElementById("appl_right_left_flag").value )+ "\" ";
	xmlStr += "duration=\""+  checkSpl( document.getElementById("duration").value )+ "\" ";
	xmlStr += "remarks=\""+encodeURIComponent(frmObj.remarks.value)+"\" ";
	xmlStr += "f_duration=\""+frmObj.f_duration.value+"\" ";
	xmlStr += "surgeon_avg_time=\""+frmObj.avgTime.value+"\" ";
	xmlStr += "splty_code=\""+splty_code+"\" ";
	xmlStr += "patient_id=\""+patient_id+"\" ";
	if(frmObj.mode.value=="I" && bill_flag=="true")
	{
		xmlStr += "panel_str=\""+  checkSpl(panel_str) + "\" ";
		xmlStr += "bill_str=\""+ checkSpl(bill_str )+ "\" ";
		xmlStr += "order_id=\""+orderid+"\" ";
		xmlStr += "order_line_num=\""+order_line_num+ "\" ";
	}
	if((frmObj.mode.value=="I" || frmObj.mode.value=="U") && bill_flag=="true")
	{
		
		xmlStr += "fpp_yn=\""+ fpp_yn + "\" "; // Added Against ML-MMOH-SCF-2510
		if(fpp_yn == 'N') fpp_cat = 'N'; // Added Against ML-MMOH-SCF-2510
		xmlStr += "fpp_category=\""+  fpp_cat + "\" ";
	}
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var key=frmObj.key.value;
	xmlHttp.open("POST","OperationCollectDetail.jsp?mode="+mode+'&key='+key,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var url="../../eOT/jsp/OperationStaticDtl.jsp?called_from="+called_from+"&orderid="+orderid+"&mode="+mode+"&bill_flag="+bill_flag+"&order_cat_bill_yn="+retVal1+"&selectAuthFlag=Y"+"&fpp_category="+fpp_cat;//Added By Gaurav Against ML-MMOH-SCF-2511
	parent.frames[1].document.location.href=url;
	clearValues();
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
			var msg = getMessage("APP-OT0080","OT");
			var msgArray = msg.split("&");
			alert(msgArray[0]+oper_desc+msgArray[1]+theatre_desc);
			return false;
		}else
			return true;
	}else{
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
	frmObj.operation_desc.disabled=false;
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	parent.frames[0].document.forms[0].durFromFrame.value = '';
	//CRF-004 Authorize Slots for Booking - Rajesh V 
	methodSubmit( );
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
	if((frmObj.orderid.value!=null&&frmObj.orderid.value!=''&&frmObj.orderid.value.length>0)||(frmObj.booking_no.value!=null&&frmObj.booking_no.value!=''&&frmObj.booking_no.value.length>0))
	validateAll();
}

function checkDate(flag){
	var data="";
	var change_pref_date="";
	var obj=document.forms[0];
	var locale = obj.locale.value;
	//Commented by rajesh for IN012547 on 17/12/09
	if(obj.chkavilable!=null&&obj.chkavilable!='undefined'&&obj.chkavilable!='')
		//obj.chkavilable.checked=false;
	if(flag=='1'){
		data=obj.PREFERRED_DATE.value;
		change_pref_date=dateUtils(data,locale);
		if(data == null || data == '') return false;
		data=changeDate(change_pref_date);
		var dat1=new Date(data);
		var dat2=new Date(obj.date_compare.value);
		if(dat1<dat2){
			var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var date = getLabel("Common.date.label","common");
			var current_date = getLabel("Common.CurrentDate.label","common");
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
	if(dat[0]==null || dat[0]=="null" || dat[0]=="undefined")dat[0]="";
	if(dat[1]==null || dat[1]=="null" || dat[1]=="undefined")dat[1]="";
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
		 alert(getMessage("APP-OT0036","OT"));
		 return false;
	}

	if( obj.PREFERRED_DATE.value=='' && obj.PREFERRED_MONTH.value=='' ) {
		alert(getMessage("APP-OT0037","OT"));
		return false;
	}
	
	//alert(" Inside Booking.js 2194 obj.SURGEON.value : "+obj.SURGEON.value);

	if( obj.PREFERRED_DATE.value!='' && checkDate(1)==false ){
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
		//alert(" Inside Booking.js 2218 Inside If Loop : ");
		datVal=changeDate(obj.date_compare.value);
		funOTTheaterSearch(countFlag,'1',datVal);
	}else{
		//alert(" Inside Booking.js 2218 Inside Else Loop : ");
		funOTTheaterSearch(countFlag,'2',datVal);
	}
//END OF Prob
}

async function callDialog(param){
	var dialogTop			= "0";
	var dialogHeight		= "84vh";
	var dialogWidth			= "55vw";
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await top.window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function funOTTheaterSearch(flag,fl,datVal){
	var sql;
	var obj=document.forms[0];
	var facility_id = obj.facility_id.value;//lakshmi
	var function_id = obj.function_id.value;
	var diary_sched_for_surg_reqd_yn = obj.diary_sched_for_surg_reqd_yn.value;
	var locale = obj.locale.value;
	var procedure = obj.oper_code.value;
	var order_by="";
	var sql_query="";
	
	//alert(" Inside Booking.js 2249 diary_sched_for_surg_reqd_yn : "+diary_sched_for_surg_reqd_yn);
	
	if(diary_sched_for_surg_reqd_yn =="Y")
	{
		order_by="SURGEON_NAME1,OPER_ROOM_DESC1";
	}else
	{
		order_by="OPER_ROOM_DESC1,SURGEON_NAME1";
	}
	if(flag==4||flag==5){
		sql_query = "OTINTERNALREP_3::otsql::"+locale+"::"+obj.SURGEON_CODE.value+"::"+locale+"::"+locale+"::"+locale+"::"+facility_id+"::"+obj.room_code.value+"::"+obj.SURGEON_CODE.value+"::"+obj.SPECIALITY_CODE.value+"::"+order_by+"::";
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, ''  THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, '' SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B,(SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, X.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_vw X WHERE X.LANGUAGE_ID='"+locale+"' AND X.PRACTITIONER_ID = '"+obj.SURGEON_CODE.value+"' AND X.PRACTITIONER_ID <>'*ALL' UNION SELECT LANGUAGE_ID, '*ALL' PRACTITIONER_ID, 'All' PRACTITIONER_NAME FROM SM_LANGUAGE where LANGUAGE_ID = '"+locale+"') C WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"'  AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"'  AND C.LANGUAGE_ID = '"+locale+"' AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND (A.TEAM_DOCTOR_CODE = '"+obj.SURGEON_CODE.value+"' OR A.TEAM_DOCTOR_CODE = '*ALL') AND (SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE ) OR SPECIALITY_CODE = '*ALL')  AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE  AND A.TEAM_DOCTOR_CODE = C.PRACTITIONER_ID AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1) order by "+order_by+" ");//Modified by lakshmi for duplication of records in booking verification screen

	}else if(flag==6 || flag==7) {
		sql_query = "OTINTERNALREP_4::otsql::"+locale+"::"+locale+"::"+locale+"::"+locale+"::"+facility_id+"::"+obj.SPECIALITY_CODE.value+"::"+obj.room_code.value+"::"+order_by+"::";
		//sql=escape("SELECT DISTINCT C.PRACTITIONER_NAME SURGEON_NAME1, '' THEATRE_TYPE_DESC1,A.TEAM_DOCTOR_CODE SURGEON_CODE1, A.SPECIALITY_CODE SPECIALITY_CODE1,A.OPER_ROOM_CODE OPER_ROOM_CODE1, B.SHORT_DESC OPER_ROOM_DESC1 FROM OT_DIARY_SCHEDULE A, OT_OPER_ROOM_LANG_VW B, (SELECT X.LANGUAGE_ID, X.PRACTITIONER_ID, X.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW X WHERE X.LANGUAGE_ID='"+locale+"' AND X.PRACTITIONER_ID <>'*ALL' UNION SELECT LANGUAGE_ID, '*ALL' PRACTITIONER_ID, 'All' PRACTITIONER_NAME FROM SM_LANGUAGE where LANGUAGE_ID = '"+locale+"') C WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = '"+locale+"' AND (SPECIALITY_CODE = NVL('"+obj.SPECIALITY_CODE.value+"',SPECIALITY_CODE ) OR SPECIALITY_CODE = '*ALL') AND B.OPER_ROOM_CODE = NVL('"+obj.room_code.value+"',B.OPER_ROOM_CODE) AND A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE AND A.TEAM_DOCTOR_CODE = C.PRACTITIONER_ID AND BOOKING_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND ADD_MONTHS(TO_DATE(?,'dd/mm/yyyy'),1) order by "+order_by+" ");//Modified by lakshmi for duplication of records in booking verification screen
	}

	var flag=0;
	var obj1;
	var locale = obj.locale.value;
	if(fl=='1'){
		var change_pref_date = datVal;
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

	//below line added by Sanjay against Special Characters issue. This line encodes the special characters and passes it onto the ../../eOT/jsp/CalendarFrm.jsp. In jsp, no need to decode.
	spld = encodeURIComponent(spld);
	if(splc==null||splc==''){
		splc.value='';
		spld.value='';
	}

	if(obj.orderid.value==null||obj.orderid.value=='')
		obj.orderid.value='';
	if(obj.booking_no.value==null||obj.booking_no.value=='')
		obj.booking_no.value='';
	if(obj.startTime.value==null||obj.startTime.value=='')// 44528 - Chaitanya
		obj.startTime.value='';
	if(obj.endTime.value==null||obj.endTime.value=='')
		obj.endTime.value='';

	var param = "sql="+sql_query+"&flag="+flag+
						"&date="+change_pref_date+
						"&speciality_code="+splc+
						"&orderid="+obj.orderid.value+
						"&booking_no="+obj.booking_no.value+
						"&called_from="+obj.called_from.value+
						"&procedure="+procedure+
						"&function_id="+function_id+
						"&speciality_desc="+spld+
						"&startTime="+obj.startTime.value+
						"&endTime="+obj.endTime.value+
						"&selSurgeonCode="+obj.SURGEON_CODE.value+
						"&patientId="+obj.patientId.value+ //PMG2014-CRF-0024  U-3
						"&selOrderIds="+obj.selOrderIds.value+ // ChAiTu - 186
						"&fpp_category="+obj.fpp_category.value; //ML-MMOH-CRF-1939-US005
						parent.qa_query_result.location.href = '../../eOT/jsp/CalendarFrm.jsp?'+param;
	parent.qa_query_result_tail.location.href='../../eOT/jsp/TailLegend.jsp';
}

function validate(){
	
	//Newly added IF condition by rajesh on 20/04/2010 for CRF-20056-INT-0003.4
	var formObjHdr = header_frame.document.forms[0];
	var patient_class = formObjHdr.episode_type.value;
	var validatStr="";
	var dispStr = "";
	//CRF- GHL356
	if(patient_class=="XT"){
			validatStr=new Array("surgeonType","episode_type","patient_id","SPECIALITY_DESC");
			dispStr = new Array ( getLabel('Common.SurgeryType.label','Common'),getLabel('Common.encountertype.label','Common'),getLabel('Common.patientId.label','Common'),getLabel('Common.speciality.label','Common'));
		}
		//CRF-OT-GHL-CRF-0356-02
		else
		{
			validatStr=new Array("surgeonType","episode_type","patient_id","SPECIALITY_DESC","Source_code","encounter_id");//IN051134
			dispStr = new Array ( getLabel('Common.SurgeryType.label','Common'),getLabel('Common.encountertype.label','Common'),getLabel('Common.patientId.label','Common'),getLabel('Common.speciality.label','Common'),getLabel('Common.SourceType.label','Common'),getLabel('Common.encounterid.label','Common') );
	}
	var obj=header_frame.document.forms[0]; 
	 
	var msgFrame =document.getElementById('messageFrame');
	return(validateMandatory(obj,validatStr,dispStr,msgFrame));
}

function disableButton(chkReferalDisable){//GHL-CRF-0356
	var frmObj=document.forms[0];
	frmObj.quest1.disabled=true;
	if(frmObj.quest2)frmObj.quest2.disabled=true;
	frmObj.quest3.disabled=true;
	frmObj.quest4.disabled=true;
	frmObj.quest5.disabled=true;
	frmObj.quest6.disabled = chkReferalDisable;//GHL-CRF-0356
	frmObj.sourceType.disabled=true;
}

function funsubmitCheckInDtls()
{
	
	var obj=header_frame.document.forms[0];
	var obj1=message_search_frame.detailframe.frames[0].document.forms[0];
	var obj2=message_search_frame.detailframe.frames[1].document.forms[0];
	obj.duration.value=obj2.total_hour.value+":"+obj2.total_min.value;
	var spl_code=obj.SPECIALITY_CODE.value;
	var spltycode=obj1.spltycode.value;
	var spltycodedesc=obj1.spltycodedesc.value;
	var strSpecialityYN=obj1.strSpecialityYN.value;
	var collect=obj1.specialityCollect.value;
	var codeCollect=obj1.codeCollect.value;
	obj.specilaity_collect.value=collect;
	if(obj.orderid.value==''||obj.orderid.value==null)
	{
	
		if(validate()==false)
			return false;
		var pre_oper_diag=obj.pre_oper_diag.value;
		var remarks=obj.REMARKS.value;
		var errors='';
		if(codeCollect.length==0)
		{
			var msgFrame=parent.messageFrame;
			errors+=getMessage("MIN_ONE_DETAIL_REQUIRED","Common")+"<br>";
		}
		var msg1="";
	
		if(spltycode=="")
			msg1=getMessage("APP-OT0096","OT");
		else
			msg1=getMessage("APP-OT0097","OT");
		var spltycode_arr = spltycode.split(":");
		var selected_splty_list_arr=collect.split(",");
		var count = 0;
		if(spltycode=="")
		{
			for(c=0;c<selected_splty_list_arr.length;c++)
			{
				if(spl_code==selected_splty_list_arr[c])
				{
					count=1;
					break;
				}
			}
		}
		else
		{
			for(c=0;c<spltycode_arr.length;c++)
			{
				if(spl_code==spltycode_arr[c])
				{
					count=1;
					break;
				}
			}
			if(count==0)
			{
				for(c=0;c<selected_splty_list_arr.length;c++)
				{
					if(spl_code==selected_splty_list_arr[c])
					{
						count=1;
						break;
					}
				}
			}
		}
		if(count==0)
		{
			var msgFrame=parent.messageFrame;
			 errors+=getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")+"<br>";
		}
		count = 0;
		if(errors=='')
		{
			if(spltycode!="")
			{
			var flag1=true;
				if(strSpecialityYN=="N")
				{
				var found_str = "";
					for(var j=0;j<spltycode_arr.length;j++)
					{
						for(k=0;k<selected_splty_list_arr.length;k++)
						{
							if(spltycode_arr[j] == selected_splty_list_arr[k])
							{
							count = 1;
							break;
						}
					}
				}
					if(count==0)
					{
					 errors+=msg1+"<br>";
					 flag1=false;
				}
			}
				else
				{
				var flag1=true;
					for(k=0;k<selected_splty_list_arr.length;k++)
					{
						if(spl_code == selected_splty_list_arr[k] && selected_splty_list_arr[k]!='')
						{
							count = 1;
							break;
						}
					}
					if(count==0)
					{
					 errors+=getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")+"<br>"
					 flag1=false;
				}
				if(flag1==true)
                {
				var msgFrame=parent.messageFrame;
				var success='';
				 var msg = getMessage("APP-OT0073","OT");
				 var msgArray = msg.split("#");
				 var msg2=msgArray[0]+"another"+msgArray[1];
						for(var j=0;j<selected_splty_list_arr.length;j++)
						{
							if(errors.indexOf("Selected")<0 && success=='')
							{
								if(selected_splty_list_arr[j]!=spltycode && selected_splty_list_arr[j]!='')
								{
									if(window.confirm(msg2)==false)
									{
								errors+=msg1+"<br>";
								success='';
									}
									else
									{
								errors+='';
								success="YES";
							}
						}
					}
				}
			if(errors.length>0)
			{
				if(errors.indexOf("Selected")>=0)
					errors='';
					var spltyblock_msg=getMessage("APP-OT0096","OT");
					spltyblock_msg=spltyblock_msg.split("#");
					spltyblock_msg=spltyblock_msg[0]+"another"+spltyblock_msg[1]
					errors+=spltyblock_msg;
				}
			  }
			}
		}
		}
		if(remarks.length > 1500)
		{
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var header_value=getlabel("Common.Header.label","common");
			var max_len_msg = max_len_msg_arr[0]+header_value+max_len_msg_arr[1]+" 1500 "+max_len_msg_arr[2];
			errors+=max_len_msg+"<br>";
		}
		if(pre_oper_diag.length > 500)
		{
			var msgFrame=parent.messageFrame;
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var preOperativeDiagnosis_value=getLabel("eOT.PreOperativeDiagnosis.Label","OT");
			var max_len_msg = max_len_msg_arr[0]+preOperativeDiagnosis_value+max_len_msg_arr[1]+" 500 "+max_len_msg_arr[2];
			errors+=max_len_msg+"<br>";
		}
		if(errors.length>0)
		{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors
			return false;
		}
	}
	else
	{
		if(validate()==false)
			return false;
		var pref_date=obj.pref_date.value;
		var booking_date=dateUtils(obj.booking_date.value,obj.locale.value);
		pref_date=changeDate(pref_date);
		booking_date=changeDate(booking_date);
		var bdat=new Date(booking_date);
		var pdat=new Date(pref_date);
		var errors='';
		var success='';
       var msg1="";
		if(spltycode=="")
			msg1=getMessage("APP-OT0096","OT");
		else
			msg1=getMessage("APP-OT0097","OT");
		var spltycode_arr = spltycode.split(":");
		var selected_splty_list_arr=collect.split(",");
		var count = 0;
		if(spltycode=="")
		{
			for(c=0;c<selected_splty_list_arr.length;c++)
			{
				if(spl_code==selected_splty_list_arr[c])
				{
					count=1;
					break;
				}
			}
		}
		else
		{
			for(c=0;c<spltycode_arr.length;c++)
			{
				if(spl_code==spltycode_arr[c])
				{
					count=1;
					break;
				}
			}
			if(count==0)
			{
				for(c=0;c<selected_splty_list_arr.length;c++)
				{	
					if(spl_code==selected_splty_list_arr[c])
					{
						count=1;
						break;
					}
				}
			}
		}
		if(count==0)
		{
			var msgFrame=parent.messageFrame;
			 errors+=getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")+"<br>";
		}
		count = 0;	   // initialize
		if(errors=='')
		{
			if(spltycode!="")
			{
			var flag2=true;
				if(strSpecialityYN=="N")
				{
				var found_str = "";
					for(var j=0;j<spltycode_arr.length;j++)
					{
						for(k=0;k<selected_splty_list_arr.length;k++)
						{
							if(spltycode_arr[j] == selected_splty_list_arr[k])
							{
							count = 1;
							break;
						}
					}
				}
					if(count==0)
					{
					 errors+=msg1+"<br>";
					 flag2=false;
				}
				}
				else
				{
					for(k=0;k<selected_splty_list_arr.length;k++)
					{
						if(spl_code == selected_splty_list_arr[k] && selected_splty_list_arr[k]!='')
						{
							count = 1;
							break;
						}
					}
					if(count==0)
					{
					 errors+=getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")+"<br>"
					 flag2=false;
				}
				if(flag2==true)
                {
				errors='';
				var msgFrame=parent.messageFrame;
				 var msg = getMessage("APP-OT0073","OT");
				 var msgArray = msg.split("#");
				 var msg2=msgArray[0]+"another"+msgArray[1];
						for(var j=0;j<selected_splty_list_arr.length;j++)
						{
							if(errors.indexOf("Selected")<0 && success=='')
							{
								if(selected_splty_list_arr[j]!=spltycode && selected_splty_list_arr[j]!='')
								{
									if(window.confirm(msg2)==false)
									{
								errors+=msg1+"<br>";
								success='';
									}
									else
									{
								errors+='';
								success="YES";
							}
						}
					}
				}
						if(errors.length>0)
						{
							if(errors.indexOf("Selected")>=0)
								errors='';
					var spltyblock_msg=getMessage("APP-OT0096","OT");
					spltyblock_msg=spltyblock_msg.split("#");
					spltyblock_msg=spltyblock_msg[0]+"another"+spltyblock_msg[1]
					errors+=spltyblock_msg;
				}
			 }
			}
		}
		}

        if(errors.length>0)
        {
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors
			return false;
		}
		if(bdat > pdat && obj.waitlistyn.value=='N') 
		{
			if(window.confirm(getMessage("APP-OT0074","OT")))
				obj.waitlistyn.value="Y";
			else
				obj.waitlistyn.value="N";
			}
		}
	return true;
}

function validateSurgeon()
{
	var obj=parent.header_frame.document.forms[0];
	var surgeonCode=obj.surgeonCode.value;
	var asstSurgeonCode=obj.asst_surgeon_code.value;
	var flag=true;

	if(surgeonCode==asstSurgeonCode)
	{
		var msg = getMessage("APP-OT0164","OT");
		//var errors="Surgeon and Assistant Surgeon should not be same.";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		flag=false;
		return false;
		}
		return flag;
}

function closeWindow(){
	//parent.window.returnValue='0';
	//parent.window.close();
	let dialogBody =parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = '0';
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}

async function callPatientSearch(){
	var frmObj	=document.forms[0];
	var patient_class=frmObj.episode_type.value;
	var source_type=frmObj.sourceType.value;
	if(patient_class==null || patient_class==""){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.patientclass.label","Common")+" "+msgArray[1]);
		return false;
	}else{
		frmObj.patient_id.value="";
		frmObj.patient_name.value="";
		frmObj.sex.value="";
		frmObj.date_of_birth.value="";
		var patient_class_desc="";
		if(patient_class=="IP") patient_class_desc=getLabel('Common.inpatient.label','Common');
		if(patient_class=="DC") patient_class_desc=getLabel('Common.daycare.label','Common');
		if(patient_class=="EM") patient_class_desc=getLabel('Common.emergency.label','Common');
		if(patient_class=="OP") patient_class_desc=getLabel('Common.Outpatient.label','Common');
		if(patient_class=="XT") patient_class_desc=getLabel('Common.external.label','Common');
		patient_class_desc=encodeURIComponent(patient_class_desc);
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var
		return_value=await window.showModalDialog("../../eOT/jsp/OTPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc,arguments,features);
		if(return_value!=null && return_value!="undefined" && return_value!=""){
			var arr=return_value.split("##");
			frmObj.patient_id.value = arr[0];
			frmObj.patient_name.value = arr[1];
			frmObj.encounter_id.value=arr[3];
			frmObj.episode_id.value=arr[4];
			frmObj.date_of_birth.value=arr[5];
			frmObj.sex.value=arr[6];
			frmObj.visitid.value=arr[7];
			frmObj.sourceType.value=source_type;

			//var param="patient_id="+arr[0]+"&patient_name="+arr[1]+"&encounter_id="+arr[3]+"&date_of_birth="+arr[5]+"&sex="+arr[6]+"&visitid="+arr[7];
			frmObj.submit();
			/*
			if(patient_class=='OP' || patient_class=='XT' || patient_class=='EM')
			frmObj.sourceType.value = source_type;*/
			//parent.frames[1].location.href='../../eOT/jsp/OperationProcedureHdr.jsp?'+param;
		}
	}
}
function clearPatientDetails(){
	var frmObj	=document.forms[0];
	frmObj.encounter_id.value="";
	frmObj.episode_id.value="";
	frmObj.visitid.value="";
}

function setInitialValue(){
	var obj=document.PreOperHdr;
	if(obj!=null){
			obj.sex.value= (obj.sex.DB_VALUE === undefined ? "" : obj.sex.DB_VALUE);
			if(obj.episode_type.DB_VALUE !== '' && obj.episode_type.DB_VALUE !== undefined){ //Rameez changed against 39540 on 26-04-2013
      obj.episode_type.value=obj.episode_type.DB_VALUE;
			obj.sourceType.value=obj.sourceType.DB_VALUE;
			} //Rameez changed against 39540 on 26-04-2013
	}
}
	
async function callCurrentStage(locale){
	var column_sizes = escape("70%,30%");
	var column_descriptions = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions);
	var sql=escape("select  PRE_STAGE_DESC PRE_STAGE_DESC1,STAGE_CODE STAGE_CODE1 from OT_BOOKING_FIN_STAGES");
	var title = getLabel("eOT.CurrentStage.Label","OT");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
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
	if(frmObj.SURGEON_CODE.value=='*ALL') frmObj.SURGEON_CODE.value='';//against SCF 2643 on 25-06-2009 by Sathish.K
	if(frmObj.room_code.value=='*ALL') frmObj.room_code.value='';//against SCF 2643 on 25-06-2009 by Sathish.K
	var locale = frmObj.locale.value;
    var theatre_date=dateUtils(frmObj.theatre_date.value,locale);
	var bookingStage=frmObj.currstage_code.value;
	var stages1=frmObj.stages1.value; //added crf-0021
	var patient_class=frmObj.patient_class.value;//added crf-0014
	var patient_id = '';
	var patient_name = '';
	if(frmObj.patientid != null && frmObj.patientid != 'undefined')
		patient_id = frmObj.patientid.value;//MO-CRF-20082
	if(frmObj.patient_name != null && frmObj.patient_name != 'undefined')
		patient_name = frmObj.patient_name.value;//MO-CRF-20082
	var seq = (frmObj.chk_sequence.checked==true) ?"Y":"N"
	var param='room_code='+frmObj.room_code.value+'&chk_sequence='+seq+"&theatre_date="+theatre_date+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&booking_stage="+bookingStage+"&theatre_type_code="+frmObj.theatre_type_code.value+"&surgery_type="+frmObj.surgery_type.value+"&stages1="+stages1+"&patient_class="+patient_class+"&patient_id="+patient_id+"&patient_name="+patient_name; //added crf-0014 - patient_class..///MO-CRF-20082
	//added stages1 crf-0021

	if(parent.parent.parent.frames[1].frames[0].document.location.href.indexOf("SlateTab.jsp") == -1)
	{
		parent.parent.frames[1].document.getElementById("booking_verification").rows='5%,35%,*,5%';//MO-CRF-20082
	}
	parent.qa_query_result.location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;
	parent.qa_query_result_tail.location.href='../../eOT/jsp/VerificationColorInd.jsp';
}

function validatewaitlistAll(){
	var frmObj=document.forms[0];

	//Added below lines on 12/20/2010 by Anitha
	var preferred_from_date = dateUtils(frmObj.preferred_from.value,locale); 
	var preferred_to_date = dateUtils(frmObj.preferred_to.value,locale); 
	if(!callDateCheck(preferred_from_date,preferred_to_date)) return;
	//end

	if(frmObj.SURGEON_CODE.value=='*ALL') frmObj.SURGEON_CODE.value='';
    var facility_id=frmObj.facility_id.value;
	var locale = frmObj.locale.value;
	var sql="SELECT PATIENT_ID, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = A.PATIENT_ID) PATIENT_NAME, OPER_DESC SPECIALITY_DESC,BOOKING_NUM, SURGEON_NAME, SURGERY_TYPE, TRUNC(SYSDATE - WAITLIST_DATE) WAITLISTED_DAYS,ORDER_ID,WAITLIST_NUM,TO_CHAR(PREFERRED_DATE,'DD/MM/YYYY') PREFERRED_DATE ,TO_CHAR(WAITLIST_DATE,'DD/MM/YYYY HH24:MI') WAITLIST_DATE, NVL2(BOOKING_NUM,'Assigned','Unassigned') STATUS, TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE, THEATRE_DESC, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME FROM OT_WAITLIST_VW A WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND NATURE_TYPE='EM' AND LANGUAGE_ID='"+locale+"'" ;
	var where="";
	if(isNull(frmObj.view.value)==false && frmObj.view.value=="A"){
		where+=" AND (BOOKING_NUM IS NULL OR (BOOKING_NUM IS NOT NULL AND TRUNC(BOOKING_DATE) = TRUNC(SYSDATE)))";
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

	//Added for ML-MMOH-SCF-2410
	var preferredto='';
	var preferredfrm='';

	//Anitha Added on 12/17/2010
	if(isNull(frmObj.preferred_from.value)==false)
		preferredfrm="true&value1="+frmObj.preferred_from.value; //Added for ML-MMOH-SCF-2410
	//	where +="  AND  TO_DATE(PREFERRED_DATE) >= TO_DATE('"+convertDate(frmObj.preferred_from.value,'DMY',locale,'en')+"','DD/MM/YYYY HH24:MI')";//SKR-SCF-1284

	if(isNull(frmObj.preferred_to.value)==false)
		preferredto="true&value2="+frmObj.preferred_to.value; //Added for ML-MMOH-SCF-2410
	//	where +="  AND  TO_DATE(PREFERRED_DATE) <= TO_DATE('"+convertDate(frmObj.preferred_to.value,'DMY',locale,'en')+"','DD/MM/YYYY HH24:MI')";//SKR-SCF-1284

	if(isNull(frmObj.patientid.value)==false)
		where +="  AND  PATIENT_ID ='"+frmObj.patientid.value+"'";

	sql+=where;
	
	var param='sql='+sql+'&waitlistkey=YES&preferred_from='+preferredfrm+"&preferredto="+preferredto; //Added for ML-MMOH-SCF-2410

	if(parent.parent.parent.frames[1].frames[0].document.location.href.indexOf("SlateTab.jsp") == -1)
	{
		parent.parent.frames[1].document.getElementById("booking_verification").rows='5%,26%,*,5%';
	}
	parent.qa_query_result.location.href = '../../eOT/jsp/VerificationHdrFrame.jsp?'+param;
}

function  displayToolTip1(orderid,surgeonCode,prefDate,obj,patId,fl,orderctlHDR,imgObj)
{
	var param='';
	param+=orderid+","+surgeonCode+","+prefDate+","+obj+","+patId;
	var menu_id_list;
	var	menu_name_list;//186
	var chkBoxSelectsin="false"; //57504
	var chkBoxSelect = $('#chkBoxSelect').val();
	var ammendBooking = $('#ammendBooking').val();
	var isChked = false;
	//MMS-QH-CRF-0186 start
	var NoOfCheckBoxSelected=$('#NoOfCheckBoxSelected').val();
	
	/****************/	
	var totalRecCnt = $('#totalRecCnt').val();
	chkBoxSelectsin = $('#chkBoxSelect'+obj).val();
	/**********************/	
	
	//MMS-QH-CRF-0186 end	
	
	if(chkBoxSelectsin == 'true' && ammendBooking == 'Y' && NoOfCheckBoxSelected>=2)
		fl = '0';

	if(fl == '0')
	{
		menu_id_list = new Array("1");
		menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'));
	
		if(ammendBooking == 'Y' && NoOfCheckBoxSelected >=1 && chkBoxSelectsin == 'true')
		{
			menu_id_list.push("AB");
			menu_name_list.push("Amend Appointment");//186
		}
	}//186
	else if(fl == '1')
	{
		menu_id_list	= new Array("1","2");
		menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'),getLabel('Common.WaitList.label','Common'));
		if(ammendBooking == 'Y' && NoOfCheckBoxSelected==1 && chkBoxSelectsin == 'true')//57524
		{
			menu_id_list.push("AB");
			menu_name_list.push("Amend Appointment");//186
	}
	}//186
	else if(fl=='2')
	{
		menu_id_list		= new Array("2");
		menu_name_list	= new Array(getLabel('Common.WaitList.label','Common'));
	}
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' style='background-color: #b6b7ba;' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ )
	{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval != "")
		{
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class='contextMenuLink' href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
}

function getOperProcDesc(booking_num,indx){
	booking_num="booking_num";
	var frmObj=document.forms[0];
	var waitlist_key=frmObj.waitlist_key_dtl.value;
	if (waitlist_key=="YES")
	{
		booking_num=eval("frmObj.waitlist_num"+indx+".value");
	}else{
		booking_num=eval("frmObj.booking_num"+indx+".value");
	}
	var facility_id=frmObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=getOperDesc&facility_id="+facility_id+"&booking_num="+booking_num+"&waitlist_key="+waitlist_key;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}

function reasonToolTip(stvar,indx){
	var arrMsg="Appendicitomy";
	var arr=new Array();
	var frmObj=document.forms[0];
	 var startpoint=0;//ML-MMOH-SCF-0387 [IN:060022]

	if(stvar=='proc_desc'){
	var arrMsg=getOperProcDesc(stvar,indx);
	startpoint=0;
	}
	else{
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	startpoint=1;//ML-MMOH-SCF-0387 [IN:060022]
	}

	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  = "Operations/Procedures";
		tab_dat     += "<tr>"
		tab_dat     += "<th fontface='TimesNewRoman' size='6pt'  nowrap > "+id_name_colval + "  </a> </th>"
		tab_dat     += "</tr> ";
	
	for( cou=startpoint;cou<arr.length;cou++){ //ML-MMOH-SCF-0387 [IN:060022]
		msg=arr[cou];
		tab_dat     += "<tr>"
		tab_dat     += "<td> "+msg+ "  </a> </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	return tab_dat;
}

//337 crf starts
function BlockedToolTip(operRoomDate,operRoomCode,locale,facility_id){
		var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
		var BlockedSlotDetails = "func_mode=BlockedSlotDetails&facilityId="+facility_id+"&locale="+locale+"&operRoomCode="+operRoomCode+"&operRoomDate="+operRoomDate;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+BlockedSlotDetails,false);
		xmlHttp.send(xmlDoc);
		var getBlockedSlotDetails = localTrimString(xmlHttp.responseText);
		var arr=new Array();
		arr=getBlockedSlotDetails.split(",");
			
		var id_name_colval  = "Blocked Slots";
		tab_dat     += "<tr>"
		tab_dat     += "<th fontface='TimesNewRoman' size='6pt'  nowrap >"+id_name_colval+"</th>"
		tab_dat     += "</tr> ";
		tab_dat     += "<tr><td></td></tr>";
				
		var cou=0;
		var msg="";
		for( cou=0;cou<arr.length;cou++){
		msg=arr[cou];
		
		tab_dat     += "<tr>"
		tab_dat     += "<td>"+msg+"</td>"
		tab_dat     += "</tr>";		
	}
	tab_dat     += "</table>";
	return tab_dat;
	//document.getElementById("tooltiplayer").innerHTML = tab_dat;
	//resizeWindow1();
}
//337 crf ends

function reasonToolTipBlockSlotReason(stvar,indx){
	var arrMsg="";
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
//	var id_name_colval  = "Operation/Procedure";//Added against 44970 on 11/15/2013
	var id_name_colval  = "Operations/Procedures"; //047067 Bharati, // 052679
		tab_dat     += "<tr>"
		tab_dat     += "<th fontface='TimesNewRoman' size='6pt'  nowrap >"+id_name_colval+"</th>"
		tab_dat     += "</tr> ";
	for( cou=1;cou<arr.length;cou++){
		msg=arr[cou];
		//msg=decodeURIComponent(msg,"UTF-8").replace(/\+/g," ");
		if(msg!=""){
		tab_dat     += "<tr>"
		tab_dat     += "<td>"+msg+"</td>"
		tab_dat     += "</tr>";
		}
	}
	tab_dat     += "</table>";
	//58860
	return tab_dat;
	//document.getElementById("tooltiplayer").innerHTML = tab_dat;
	//resizeWindow1();
	//58860
}


function  reasonToolTip_booking(stvar,indx){
//alert(stvar);
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	//alert(arrMsg);

	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  = arr[0];
		//alert(id_name_colval);

		tab_dat     += "<tr>"
		tab_dat     += "<th fontface='TimesNewRoman' size='6pt'  nowrap > "+id_name_colval + "  </a> </th>"
		tab_dat     += "</tr> ";
	for( cou=1;cou<arr.length;cou++){
		msg=arr[cou];
		tab_dat     += "<tr>"
		tab_dat     += "<td> "+msg+ "  </a> </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	//return tab_dat;
document.getElementById("tooltiplayer").innerHTML = tab_dat;
resizeWindow1();
}


function  displayToolTip3(orderid,surgeonCode,prefDate,obj,patId,waitNo,orderctlHDR,imgObj){

	var obStr="document.forms[0].xx"+obj+".value";
	var  objS=eval(obStr);
	var param='';
	param+=orderid+","+surgeonCode+","+prefDate+","+obj+","+waitNo+","+patId;
	//param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
	var menu_id_list		= new Array("3");
	var	menu_name_list	= new Array(getLabel('eOT.CancelWaitlist.Label','OT'));
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow1();
}

function  displayToolTip2(orderid,surgeonCode,prefDate,obj,patId,waitNo,orderctlHDR,imgObj){
	var obStr="document.forms[0].xx"+obj+".value";
	var  objS=eval(obStr);
	var param='';
	//commented by bala on 25/10/2007 for SPR-2045
	//param+=orderid+","+surgeonCode+","+prefDate+","+objS+","+waitNo;
	param+=orderid+","+surgeonCode+","+prefDate+","+obj+","+waitNo+","+patId;
	//param="orderid="+orderid+"&surgeonCode="+surgeonCode+"&prefDate="+prefDate+"&funflag=2&surgeonName="+objS;
	var menu_id_list		= new Array("1","3");
	var	menu_name_list	= new Array(getLabel('Common.bookappointment.label','Common'),getLabel('eOT.CancelWaitlist.Label','OT'));
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink'  href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\"> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);//IE-11 ISSUE
}

async function callMenuItem(obj, para)
{
	
	var dialogHeight = "70";//screen.availHeight/2;//"60" ;
	var dialogWidth  = "70";//screen.availwidth/2;//"130" ;
	var dialogTop    = "5";
	var dialogLeft   = "5";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+"; status:no ;center: yes; help: no; resizable: no";
	var arguments			= "";
	var par=new Array();
	par = para.split(",");
	var formObj=document.forms[0];
	var param="";
	if(obj=='17')
	{
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
			alert(getMessage("APP-OT0038","OT"));
			return;
		}
		var retVal=await window.showModalDialog(url,arguments,features);
	}
	if(obj=='16')
	{
		openHistoryforwaitlist(par[0],par[2]);
	}
	if(obj=='1')
	{		
			var called_from="BOOKING";
		var selOrderIdsArray = new Array();
		var orderId = par[0];
		var surgeonCode = par[1];
		var prefDate = par[2];
			var surgeon_name = eval("formObj.xx"+par[3]+".value");
			var spl_desc = eval("formObj.yy"+par[3]+".value");
			var speciality_code = eval("formObj.speciality_code_"+par[3]+".value");
		var patientId = encodeURIComponent(par[4]);
			var temptab=parent.parent.parent.frames[0].document.forms[0];//PMG-MOD-0005 US-3
			var activeTab=temptab.querySelector("#activeTab").value;//PMG-MOD-0005 US-3	
			//PMG-MOD-0005 US-3 START
			var param ="";			
		//var chkBoxSelect = $('#chkBoxSelect').val();
		//PendingOrders
		//vikash added for waitlist bookappointment issue starts
			var chkBoxSelectsin="";
			var ammendBooking="";
			var NoOfCheckBoxSelected="";
			//vikash added for waitlist bookappointment issue starts
			
		/*	
			//vikash commented for waitlist bookappointment issue starts
			var chkBoxSelectsin=eval("formObj.chkBoxSelect"+par[3]+".value");
		//var chkBoxSelectsin = $('#chkBoxSelect'+obj).val(); // for testing
		
		var ammendBooking = $('#ammendBooking').val();
		//MMS-CRF-186
		var NoOfCheckBoxSelected=$('#NoOfCheckBoxSelected').val();
		*/
		//vikash commented for waitlist bookappointment issue ends

		var selSpecialityFlag = true;
		if(activeTab == "PendingOrders")
		{
		//vikash added for waitlist bookappointment issue starts
		 
		ammendBooking = $('#ammendBooking').val();
		
		if(ammendBooking=='Y'){
			chkBoxSelectsin=eval("formObj.chkBoxSelect"+par[3]+".value");
			NoOfCheckBoxSelected=$('#NoOfCheckBoxSelected').val();
		}
		
		//vikash added for waitlist bookappointment issue ends

		if(chkBoxSelectsin == 'true' && NoOfCheckBoxSelected>1)//186
			{
				selSpecialityFlag = false;
				// alert("===entered===");
				getPrimarySpeciality(patientId);
			//	alert("==selOrderId===bkng_pending==="+$('#selOrderId').val());
				if($('#selOrderId').val() != '')
				{
					selSpecialityFlag = true;
					var i = 0;
					var j = 0;
					var totalRecCnt = $('#totalRecCnt').val();
					var orderId = $('#selOrderId').val();
					for(i=0; i<totalRecCnt; i++)
					{
						if(orderId == $('#selOrderIds_'+i).val())
							j = i;
						if($('#bukngsToSchedule'+i).is(':checked'))
							selOrderIdsArray.push($('#selOrderIds_'+i).val());
					}
					//alert("==j=="+j+"===selOrderIdsArray==="+selOrderIdsArray);
					surgeonCode = $('#surgeonCode_'+j).val();
					surgeon_name = $('#xx'+j).val();
					speciality_code = $('#speciality_code_'+j).val();
					spl_desc = $('#yy'+j).val();
					prefDate = $('#prefDate_'+j).val();
				}
			}

			param = "orderid="+orderId+
					"&surgeonCode="+surgeonCode+
					"&prefDate="+prefDate+
							"&funflag=2&surgeonName="+encodeURIComponent(surgeon_name)+
							"&speciality_code="+speciality_code+
							"&speciality_desc="+encodeURIComponent(spl_desc)+							
							"&booking_called_from="+called_from+
					"&selOrderIds="+selOrderIdsArray+
					"&patientId="+patientId+
					"&ammendFlag="+ammendBooking;//MMS-QH-CRF-186


		//	alert("====selSpecialityFlag===bkng_pending==="+selSpecialityFlag+"==param=="+param);
			if(selSpecialityFlag)
			{
			//	alert("===entered===iff===");
				parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
			}

			}
			else if(activeTab == "WaitList")
			{
					param = "orderid="+par[0]+
							"&surgeonCode="+par[1]+
							"&prefDate="+par[2]+
							"&funflag=2&surgeonName="+encodeURIComponent(surgeon_name)+
							"&speciality_code="+speciality_code+
							"&speciality_desc="+encodeURIComponent(spl_desc)+							
							"&booking_called_from="+called_from+
							"&patientId="+encodeURIComponent(par[5]); //PMG2014-CRF-0024
			//PMG-MOD-0005 US-3 END
			parent.parent.parent.f_query_add_mod.location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
		}
	}
	else if(obj=='2')
	{
		var orderid=par[0];
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.WaitListServlet?orderid="+orderid, false);
		xmlHttp.send(xmlDoc);
		var resTxt=getMessage(xmlHttp.responseText,"OT");
		alert(resTxt);//057524 unable to waitlist issue
		parent.location.reload();
	}
	else if(obj=='3')
	{
		await showWaitListCancel(par[4]);
		parent.location.reload();
	}
	else if(obj == 'AB')
	{
		var called_from = "BOOKING";
		var locale = formObj.locale.value;
		var orderId = par[0];
		var surgeonCode = par[1];
		var prefDate = par[2];
		var surgeon_name = eval("formObj.xx"+par[3]+".value");
		var spl_desc = eval("formObj.yy"+par[3]+".value");
		var speciality_code = eval("formObj.speciality_code_"+par[3]+".value");
		var patientId = encodeURIComponent(par[4]);
		var temptab = parent.parent.parent.frames[0].document.forms[0];//PMG-MOD-0005 US-3
		var activeTab = temptab.document.getElementById("activeTab").value;//PMG-MOD-0005 US-3	
	//	var chkBoxSelect = $('#chkBoxSelect').val(); Mahesh commented
		var ammendBooking = $('#ammendBooking').val();
		var chkBookingExistDays = $('#chkBookingExistDays').val();
		var param = '';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var chkBukingCntParams = "func_mode=chkPatidBookings&facilityId="+formObj.facility_id.value+"&chkBookingExistDays="+chkBookingExistDays+"&patientId="+patientId;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+chkBukingCntParams,false);
		xmlHttp.send(xmlDoc);
		var getBukingCnt = parseInt(localTrimString(xmlHttp.responseText));
		//alert("===getBukingCnt==="+getBukingCnt);

		if(getBukingCnt == 0)
		{
			var msg = getMessage("APP-OT0233","OT");
			alert(msg);
		}
		else
		{
			//alert("===bookings unnayi==ammend cheyyali====Code Dev In Progress==");
			var totalRecCnt = $('#totalRecCnt').val();
			var selOrderIdsArray = new Array();
			for(i=0; i<totalRecCnt; i++)
			{
				if($('#bukngsToSchedule'+i).is(':checked'))
					selOrderIdsArray.push($('#selOrderIds_'+i).val());
			}


			param = "orderid="+par[0]+
					"&surgeonCode="+par[1]+
					"&funflag=2&surgeonName="+encodeURIComponent(surgeon_name)+
					"&speciality_code="+speciality_code+
					"&speciality_desc="+encodeURIComponent(spl_desc)+
					"&called_from="+called_from+
					"&locale="+locale+
					"&selOrderIds="+selOrderIdsArray+
					"&chkBookingExistDays="+chkBookingExistDays+
					"&patientId="+patientId+ //PMG2014-CRF-0024
					"&ammendFlag="+ammendBooking; //MMS-CRF-186
					
			

			var dialogHeight= "41" ;
			var dialogTop = "10" ;
			var dialogWidth	= "65" ;
			var dialogLeft	= "25" ;
			var features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
			var arguments = "";
			retVal = await window.showModalDialog("../../eOT/jsp/ammendBookingsFrame.jsp?"+param, arguments, features);

		}
	}
}

function openHistory(patient_id,booking_num)
{
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
	parent.parent.parent.frames[2].document.body.insertAdjacentHTML("BeforeEnd", HTML);
	parent.parent.parent.frames[2].document.historyForm.submit();
}

async function callVerificationItem(obj, para)
{
	//alert("call");
	//alert("object"+obj);
	var par=new Array();
	par=para.split("@");
	var dialogHeight = "900vh" ;
	var dialogWidth  = "800vw" ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+";status:no";
	var arguments			= "";
	var surg_code=document.forms[0].hidden_surgeon_code.value;
	//var dialogHeight 		= "80";
	//var dialogWidth  		= "80";
	//var dialogTop   		= "10";
	//var dialogLeft   		= "50";
	//var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	hideToolTip1();
if(obj=="V10"){
	var first_enc_id=document.forms[0].Hidn_enc_id_check.value;
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
	if(pt_array[1]=="A"){
		alert(pt_array[2]);
		return;
	}
	if(pt_array[0]=="E")
	{
		alert(getMessage(pt_array[2]))
		return;
	}
	else
	{
		if(pt_array[1]=="S")
		{
			alert(pt_array[2]);
			return;
		}
		if(pt_array[1]=="M")
		{
			alert(pt_array[2]);
		}
		if(pt_array[1]=="M_SPLIT")
		{
			var msg_arr = pt_array[3].split("$$"); // pt_array[3] is a message comes from procedure in the following format
			// PRC-OT0025$$OLD_ENCOUNTER_ID$$NEW_ENCOUNTER_ID
			//PRC-OT0025 This patient is currently an Inpatient.  Outpatient encounter # is changed to Inpatient encounter $
			//PRC-OT0026 This patient encounter is changed from # to current open Inpatient encounter $
			var lang_msg = getMessage(msg_arr[0],"OT"); // get bundle message msg_arr[0] can be either PRC-OT0025 or PRC-OT0026
			var lang_msg_arr_1 = lang_msg.split("#"); // splits the bundle message till #
			var disp_msg1 = lang_msg_arr_1[0]+msg_arr[1]; // Concatenate with msg_arr[1], which is the OLD_ENCOUNTER_ID coming from procedure.
			var lang_msg_arr_2 = lang_msg_arr_1[1].split("$"); // Split the remaining bundle message with $
			var disp_msg2 = lang_msg_arr_2[0]+msg_arr[2]; // Concatenate with msg_arr[2], which is the NEW_ENCOUNTER_ID coming from procedure.
			var lang_msg_display = disp_msg1 + disp_msg2; // Merge both splitted messages and display the alert
			alert(lang_msg_display);
		}
	}
	parent.location.reload();
	//return responseText;
}
if(obj=="V1"){

	//Modified by rajesh for hiding reset button on 12/09/07
		 dialogHeight = "900vh" ;
		 dialogWidth  = "800vh" ;
		 dialogTop    = "45";
		 dialogLeft   = "30";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var	param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&orderid=0&transfer=5&menu_required_yn=N";
	retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
	}

	if(obj=="V2"){
		var par1=new Array();
		par1=par[7].split("::");
		var		param="patient_id="+par[2]+"&patient_name="+par1[0]+"&sex="+par1[1]+"&dob="+par1[2]+"&called_from=OPER_REG&function_name=Surgery History";
		  await top.window.showModalDialog("../../eOT/jsp/SurgeryHistory.jsp?"+param,window,"dialogHeight: 900vh; dialogWidth:800vw; center: yes; help: no; resizable: no; status: no;");
	}

if(obj=='V3'){
	openHistory(par[2],par[0]);
}

if(obj=='V5'){
	var function_id="09";
		 dialogHeight = "900vh" ;
		 dialogWidth  = "800vw" ;
		 dialogTop    = "55";
		 dialogLeft   = "30";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

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
		alert(getMessage("APP-OT0038","OT"));
		return;
	}
	//var retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	var retVal= await top.window.showModalDialog(url,"",features);

	}

if(obj=="V7"){

	dialogHeight = "900vh" ;
		 dialogWidth  = "800vw" ;
		 dialogTop    = "55";
		 dialogLeft   = "30";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2];
	retVal=await top.window.showModalDialog("../../eOT/jsp/PreOperativeDlgFrame.jsp?"+param,arguments,features);
		parent.location.reload();
	}
//Newly Added For Assistant Surgeon by rajesh on 08/08/07.....

	if(obj=="V12"){
		 dialogHeight = "62vh" ;
		 dialogWidth  = "50vw" ;
		 dialogTop    = "250";
		 dialogLeft   = "300";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&speciality_code="+par[10];
		retVal=await top.window.showModalDialog("../../eOT/jsp/AddAsstSurgeonFrame.jsp?"+param,arguments,features);
		if(retVal=="Updated Successfully"){
			parent.location.reload();
		}
	}

	if(obj=="V11"){
		 dialogHeight = "28vh" ;
		 dialogWidth  = "38vw" ;
		 dialogTop    = "250";
		 dialogLeft   = "300";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2];
		retVal=await top.window.showModalDialog("../../eOT/jsp/AssignAnaesFrame.jsp?"+param,arguments,features);
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
		//var param="facility_id="+par[1]+"&patient_id="+par[2]+"&order_id="+par[6]+"&booking_num="+par[9];
		var param="facility_id="+par[1]+"&patient_id="+par[2]+"&order_id="+par[6]+"&booking_num="+par[10];
		retVal=await window.showModalDialog("../../eOT/jsp/AssignTheatreFrame.jsp?"+param,arguments,features);
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
			alert(getMessage("APP-OT0038","OT"));
			return;
		}
		//var retVal=window.showModalDialog(url,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
		var retVal=await window.showModalDialog(url,arguments,features);
	}

	if(obj=="V8"){
		dialogHeight = "900vh" ;
		 dialogWidth  = "800vw" ;
		 dialogTop    = "55";
		 dialogLeft   = "30";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&transfer=6&booking_date="+par[3]+"&roomCode="+par[4]+"&seq_change_yn="+par[5];
		retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
		parent.location.reload();
	}
	if(obj=="V9"){
		rescheduleCount(par[0],par[2]);
		var function_id=document.forms[0].function_id.value;
	//	var surgeonCode1=document.forms[0].user_id.value;
	param="booking_no="+par[0]+"&surgeonCode="+par[8]+"&funflag=2&surgeonName="+encodeURIComponent(par[9])+"&speciality_code="+par[10]+"&speciality_desc="+encodeURIComponent(par[11])+"&orderid="+par[6]+"&function_id=BookingVerification";
			parent.parent.parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
	}

	// added by bshankar
	if(obj=="V4"){
		var param="booking_no="+par[0]+"&facility_id="+par[1]+"&Patient_ID="+par[2];
	    retVal=await top.window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}

	//View Consent Detail added by bala for (SPR-5294)CRF

	if(obj=="V20"){
		dialogHeight = "38" ;
		 dialogWidth  = "85" ;
		 dialogTop    = "55";
		 dialogLeft   = "30";
		 features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		 var consent = consentRequiredYN(par[2],par[6]);
		 if(consent=="C"){
			var param="order_id="+par[6];
			retVal=await window.showModalDialog("../../eOT/jsp/ViewConsentDtls.jsp?"+param,arguments,features);
		}else if(consent=="I"){
			alert("Consent Not Taken");
			return;
		}else{
			alert("Patient Refused");
			return;
		}

	}

	//Reprint Appointment Slip IN34756 - Rajesh V 12/10/2012
/*	if(obj=="V21"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=pat_gender_check&patient_id="+par[2];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var patgender = retVal;
		var params1="nd_booking_num="+par[0]+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTRNOTIF"+"&nd_facility_id="+par[1]+"&facility_id="+par[1]+"&Patient_ID=" + par[2];

		//Reprint Appointment Slip IN34756 - Rajesh V 30/10/2012
		var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OT' AND REPORT_ID = 'OTRNOTIF' and language_id = 'en'";
		var dialogHeight	= '25' ;
		var dialogWidth		= '65' ;
		var dialogTop		= 58;
		var arguments		= '';
		var getUrl			= "../../eOT/jsp/PrintAppointmentSlip.jsp?"+params1;
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		retVal=   window.showModalDialog(getUrl,arguments,features);
		if ( retVal != null ) {
			retVal		= "../../eCommon/jsp/report_process.jsp?" + retVal ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( retVal, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;
		}
		//callReportOptionsFrameset(params1);
		//Reprint Appointment Slip IN34756 - Rajesh V 30/10/2012
	}  */
	//Reprint Appointment Slip IN34756 - Rajesh V 12/10/2012

	if(obj!="V3" && obj!="V16" || obj=='V5'){//Modified against 44207 on 10/17/2013 by MuthuN
		var frmObj = parent.parent.parent.parent.content;
		if(frmObj!=null){
			objf =frmObj.document.forms[0];
			parent.parent.parent.commontoolbarFrame.document.location.href=objf.qury.value;
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	if(obj=="V13"){ // Added by selvin for IN:41808
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=pat_gender_check&patient_id="+par[2];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var patgender = retVal;
		var params1="nd_booking_num="+par[0]+"&sex="+patgender+"&p_module_id="+"OT"+"&p_report_id="+"OTOSIDEN"+"&nd_facility_id="+par[1]+"&facility_id="+par[1]+"&Patient_ID=" + par[2];
		var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OT' AND REPORT_ID = 'OTOSIDEN' and language_id = 'en'";
		var dialogHeight	= '25' ;
		var dialogWidth		= '65' ;
		var dialogTop		= 58;
		var arguments		= '';
		var getUrl			= "../../eOT/jsp/OperatingSiteIdentification.jsp?"+params1;
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		retVal=   await window.showModalDialog(getUrl,arguments,features);
		if ( retVal != null ) {
			retVal		= "../../eCommon/jsp/report_process.jsp?" + retVal ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( retVal, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;
		}
	}  // End for IN:41808
}


function consentRequiredYN(patient_id,order_id){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "patient_id="+patient_id+"&order_id="+order_id;
		xmlHttp.open("POST","TempConsentValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		retVal = trimString(xmlHttp.responseText);
		if(retVal=="CONSENT_NOT_REQUIRED"){
			retVal= "N";
		}else if(retVal=="Patient has refused for this operation. Cannot proceed further"){
			retVal= "R";
		}else if(retVal=="Consent is not taken for the patient"){
			retVal= "I"
		}else if(retVal=="CONSENT_TAKEN"){
			retVal= "C"
		}else if(retVal=="ORDER_ID_NULL")
	    {
			retVal= "N"
	    }
		return retVal;
}
function getBookingstatus(facility_id){
var locale=document.forms[0].locale.value;
var sql="SELECT BOOKING_STATUS  FROM OT_SCHD_OPERS_VW WHERE OPERATING_FACILITY_ID = '"+facility_id+"'  AND LANGUAGE_ID='"+locale+"'  ";
var param="sql="+sql;
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
xmlDoc.loadXML(xmlStr);
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);;
var return_val=xmlHttp.responseText;
var rtn_val=eval(return_val)
return rtn_val;
}

function  displayToolTip(bookingno,facility,patientid,bookingdate,roomcode,chkseq,pacyn,orderid,ind,curstage,finstage,surg_code,surg_name,splty_code,splty_desc,fl,encounter_id,orderctlHDR,imgObj,bookingstatus){
parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
var menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");
var frmObj=document.forms[0];
var customer_name=frmObj.customer_name.value;  //Booking verification page for IN:041808
if(frmObj.waitlist_key_dtl.value=='' || frmObj.waitlist_key_dtl.value==null)
{
var patsexdob=	eval("frmObj.patsexdob"+ind+".value");
}
var param=bookingno+"@"+facility+"@"+patientid+"@"+bookingdate+"@"+roomcode+"@"+chkseq+"@"+orderid+"@"+patsexdob+"@"+surg_code+"@"+surg_name+"@"+splty_code+"@"+splty_desc+"@"+pacyn+"@"+encounter_id;
param=escape(param);
//	param);

var	menu_name_list;

if(fl=='RES'){
	if(pacyn=='Y'){
		//Modified by Selvam 25-Oct-2006
		//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V9");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V9");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else{
		if(ca_module_yn=="Y"){
			 menu_id_list		= new Array("V1","V2","V3","V4","V9");
			 //menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
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
			//var bookingstatus=getBookingstatus(facility);
			if(bookingstatus!='R')
            {
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9","V10","V11","V12");
            menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
			if(customer_name=="RTN")	 //Booking verification page for IN:041808
			{
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9","V10","V11","V12","V13");
            menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'),getLabel('eOT.OperSiteIdentify.Label','OT'));
				}
			}
			else
			{
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V10","V11","V12");
            menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
			}
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist","Asst Surgeon");

			//menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('eOT.PatientHistory.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));

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
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
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

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
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
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
	}else{
		menu_id_list		= new Array("V15");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'));
	}
}


var consent_reqd_yn=consentRequiredYN(patientid,orderid);
//var consent_reqd_yn="Y";
if(consent_reqd_yn!="N"){
	menu_id_list.push("V20")
	menu_name_list.push("View Consent Details");//new Array(getLabel('eOT.AssignTheatre.Label','OT'));
}
//Amazon Changes starts
//Reprint Appointment Slip IN34756 - Rajesh V 12/10/2012
//menu_id_list.push("V21")
//menu_name_list.push(getLabel('eOT.PrintAppointmentSlip.Label','OT'));
//Reprint Appointment Slip IN34756 - Rajesh V 12/10/2012
callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1'  overflow: auto; top:40px; class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' name='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callVerificationItem('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
document.getElementById("tooltiplayer").innerHTML = tab_dat;
resizeWindow(orderctlHDR);
//resizeWindow();
var tooltip = document.getElementById("tooltiplayer");

// Set the background color to grey
tooltip.style.backgroundColor = "#ffffff"; // Grey background with some transparency
tooltip.style.color = "white";
tooltip.style.padding = "10px";
tooltip.style.border = "1px solid #ccc";

// Ensure the tooltip has the width of the content
tooltip.style.width = "auto";
tooltip.style.maxWidth = "200px"; // Optional: Limit the width if the content is too long

// Set the tooltip position to be relative to the hovered link
tooltip.style.position = "absolute";
tooltip.style.zIndex = "1000"; // Ensure the tooltip is on top of other elements

// Make sure the tooltip only wraps the content, not the whole page
tooltip.style.display = "inline-block";



}

function  displayToolTip10(bookingno,facility,patientid,bookingdate,roomcode,chkseq,pacyn,orderid,ind,fl,curstage,finstage,surg_code,surg_name,splty_code,splty_desc,oper_status)
{
var menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");
var frmObj=document.forms[0];
if(frmObj.waitlist_key_dtl.value=='' || frmObj.waitlist_key_dtl.value==null)
{
var patsexdob=	eval("frmObj.patsexdob"+ind+".value");
}

var param=bookingno+"@"+facility+"@"+patientid+"@"+bookingdate+"@"+roomcode+"@"+chkseq+"@"+orderid+"@"+patsexdob+"@"+surg_code+"@"+surg_name+"@"+splty_code+"@"+splty_desc+"@"+pacyn;
var	menu_name_list;
if(fl=='RES'){
	if(pacyn=='Y'){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else{
		if(ca_module_yn=="Y"){
			 menu_id_list		= new Array("V1","V2","V3","V4","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");

			 menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
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

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V8","V9");
			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders", "Mark for Reschedule","Reassign Theatre","Link To Current Episode","Assign Anaesthetist");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));

		}
	}else if(curstage==finstage && (oper_status!="10" || oper_status!=10) ){
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V9","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list		= new Array("V1","V4","V9","V11");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Reassign Theatre");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}
	else if(curstage==finstage && (oper_status=="10" || oper_status==10))
	{
		if(ca_module_yn=="Y"){
			menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");

			//menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Pre-Anaesthesia Evaluation","Link Pre-Operative Orders","Mark for Reschedule","Reassign Theatre");

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
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

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'));
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

		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
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
	resizeWindow1();
//  document.getElementById("tooltiplayer").style.visibility = 'visible';

}

function hideToolTip1(){
  document.getElementById("tooltiplayer").style.visibility = 'hidden';
}


async function callOrderCategory(locale)
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
retVal=await callDialog(param);
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

async function callTheatreType(locale) {
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
retVal=await callDialog(param);
var obj=document.forms[0];
retVal=checkNull(retVal);
var arr=new Array();

if(retVal!='')
	{
	arr=retVal.split("::");
	if(arr[1]==undefined) { 
	arr[1]="";
	arr[0]="";
	}
	document.forms[0].theatre_type_desc.value = arr[0];
	document.forms[0].theatre_type_code.value = arr[1];
	}
else
	{
	document.forms[0].theatre_type_desc.value = '';
	document.forms[0].theatre_type_code.value = '';
	}
}

async function callTheatre(flg,locale){
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

var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].theatre.value;
retVal=await callDialog(param);
retVal=checkNull(retVal);
var arr=new Array();
if(retVal!=''){
	arr=retVal.split("::");
	if(arr[1]==undefined) { 
	arr[1]="";
	arr[0]="";
	}
	document.forms[0].theatre.value = arr[0];
	document.forms[0].room_code.value = arr[1];
	}
else
	{
	document.forms[0].theatre.value = '';
	document.forms[0].room_code.value = '';
	}
}


function resizeWindow1()
{
	bodwidth = parent.frames[0].document.body.offsetWidth;
	bodheight = parent.frames[0].document.body.offsetHeight;

	var x =event.x;
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth);
	y = y + (document.getElementById("tooltiplayer").offsetHeight);

	if(x<bodwidth)
		x =event.x;
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*1);

	if(y<bodheight)
		 y =event.y;
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight*1);

	y+=document.body.scrollTop;
	x+=document.body.scrollLeft;
	
	x+=30;
	y-=10;

	document.getElementById("tooltiplayer").style.left= x + "px";
	document.getElementById("tooltiplayer").style.top = y + "px";
	document.getElementById("tooltiplayer").style.visibility='visible';
}

//Wait List frame
function funWaitListSearch(){
	var frmObj=document.forms[0];//VerificationSearchForm
	var locale = frmObj.locale.value;
	var change_from_date = dateUtils(frmObj.from_date.value,locale);
	var change_to_date = dateUtils(frmObj.to_date.value,locale);
	if(!callDateCheck(change_from_date,change_to_date)) return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "surgeon_code="+frmObj.SURGEON_CODE.value+"&change_from_date="+change_from_date+"&change_to_date="+change_to_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=waitCount&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
		if (retVal==0){
			//	callNoRecord();
		}
		
	if(frmObj.from_date.value!=''){
	//Commented against MO-CRF-20086
	/*var sql="SELECT (to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and v.language_id='"+locale+"'";*/
	//Added against MO-CRF-20086	
	var sql="SELECT * FROM(SELECT(to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy'))	R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS, (SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = 'OT_CATEGORY_TYPE' AND ROWNUM=1)  CATEGORY,(SELECT ORDER_FIELD_VALUE from or_order_field_values D where D.ORDER_ID=V.ORDER_ID and D.ADDED_FACILITY_ID=V.OPERATING_FACILITY_ID and D.ORDER_FIELD_MNEMONIC = 'PRIORITY'  AND ROWNUM=1)  PRIORITY FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and v.language_id='"+locale+"'";
	//Modified by lakshmi against MO_CRF-20051
	//var sql="SELECT (to_date(to_char(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')-to_date(to_char(WAITLIST_DATE,'dd/mm/yyyy'),'dd/mm/yyyy')) R_DAY1,NVL(C.WARN_LIMIT_WAITLIST_DAYS,0) WARNING_DAYS, NVL(c.WARN_UNSCHEDULED_CASES_ONLY,'N') STAT1,v.PATIENT_ID  PATIENT_ID1, (select  decode( '"+locale+"','en',nvl(patient_name,patient_name_loc_lang),nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = v.PATIENT_ID ) PATIENT_NAME1,  v.SURGERY_TYPE SURGERY_TYPE1,v.SPECIALITY_DESC SPECIALITY_DESC1, v.SURGEON_NAME SURGEON_NAME1, to_char(v.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1, to_char(v.WAITLIST_DATE,'dd/mm/yyyy HH24:MI')  WAITLIST_DATE1, v.ORDER_ID ORDER_ID1, v.SURGEON_CODE SURGEON_CODE1,v.BOOKING_NUM BOOKING_NUM1,v.WAITLIST_NUM WAITLIST_NUM1, v.SPECIALITY_CODE  SPECIALITY_CODE1,OPER_DESC  OPER_DESC1,MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1, TO_CHAR(SYSDATE - V.WAITLIST_DATE) WAITLIST_DAYS,v.STATUS,v.PRE_OPER_DIAG FROM  OT_WAITLIST_VW v,OT_PARAM_FOR_FACILITY C WHERE v.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and C.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"' and v.language_id='"+locale+"'";

	var where="";
	var where2="";//Added against MO-CRF-20086
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
	sql+=where+")";//modified against MO-CRF-20086
	//Added against MO-CRF-20086 Starts Here
	if((frmObj.category.value!=null && frmObj.category.value!='') && (frmObj.priority.value!=null && frmObj.priority.value!=''))
	 where2+=escape("where  ((NVL('"+frmObj.category.value+"',CATEGORY)=CATEGORY AND '"+frmObj.category.value+"' IS NOT NULL) OR ('"+frmObj.category.value+"' IS NULL)) AND ((NVL('"+frmObj.priority.value+"',PRIORITY)=PRIORITY AND '"+frmObj.priority.value+"' IS NOT NULL) OR ('"+frmObj.priority.value+"' IS NULL)) ");
	  
	else if(frmObj.category.value!=null && frmObj.category.value!='')
	   where2+=escape("where  ((NVL('"+frmObj.category.value+"',CATEGORY)=CATEGORY AND '"+frmObj.category.value+"' IS NOT NULL) OR ('"+frmObj.category.value+"' IS NULL))");
	   
	else 
	if(frmObj.priority.value!=null && frmObj.priority.value!='')
	   where2+=escape("where  ((NVL('"+frmObj.priority.value+"',PRIORITY)=PRIORITY AND '"+frmObj.priority.value+"' IS NOT NULL) OR ('"+frmObj.priority.value+"' IS NULL))");
    
	sql+=where2;	
	var param='sql='+sql+'&surgeonCode='+frmObj.SURGEON_CODE.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&order_id="+frmObj.orderid.value+"&patient_id="+frmObj.patientid.value+"&patient_name="+frmObj.patientName.value+"&status="+frmObj.status.value+"&category="+frmObj.category.value+"&priority="+frmObj.priority.value;
	//Added against MO-CRF-20086 Ends Here
	//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;
	parent.qa_query_result.location.href = '../../eOT/jsp/WaitListDtlFrame.jsp?'+param;
	parent.qa_query_result_tail.location.href = '../../eOT/jsp/ColorIndofWaitlist.jsp';
	}else{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}

}

async function callReasonCode(fl,locale){
var column_sizes = escape("60%,40%");
var obj=document.forms[0];

// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);
//var column_descriptions = escape("Description,Code");

var sql='';
if(fl=='1')
	{
 //sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CW')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
//Above code is commented and modified as below by lakshmi against language_id issue
 sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW  where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CW')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"'");
	}
else
	{
//sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
//Above code is commented and modified as below by lakshmi against language_id issue
  locale=fl;
  //Modified for Cancel booking reason DhanasekarV on 13/12/2012
sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CA')  AND  NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");
	}

var title=getLabel("Common.reason.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
retVal=await callDialog(param);

retVal=checkNull(retVal);
if(retVal!='')
	{
arr=retVal.split("::");
if(arr[1]==undefined) { 
arr[1]="";
arr[0]="";
}
obj.reason_desc.value=arr[0];
obj.reason_code.value=arr[1];
	}
else
	{
obj.reason_desc.value="";
obj.reason_code.value="";
	}
}


async function callOnBlurReasonCode(obj,fl,locale){
var column_sizes = escape("60%,40%");
var formObj=document.forms[0];

// Modified by Selvam 25-Oct-2006
var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
var column_descriptions = encodeURIComponent(tit);
//var column_descriptions = escape("Description,Code");

var sql='';
if(fl=='1')
	{
 //sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CW')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
//Above code is commented and modified as below by lakshmi against language_id issue
sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CW')  AND NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");
	}
else
	{
//sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CA')  AND 	NVL(ACTIVE_YN,'N') = 'Y')");
//Above code is commented and modified as below by lakshmi against language_id issue
sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('CA') AND NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");
	}

var title=getLabel("Common.reason.label","Common");
title=encodeURIComponent(title);
var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+obj.value;
retVal=await callDialog(param);
retVal=checkNull(retVal);
if(retVal!='')
	{
arr=retVal.split("::");
if(arr[1]==undefined) { 
arr[1]="";
arr[0]="";
}
formObj.reason_desc.value=arr[0];
formObj.reason_code.value=arr[1];
	}
else
	{
formObj.reason_desc.value="";
formObj.reason_code.value="";
	}
}

async function showWaitListCancel(waitNo){
	
	var dialogHeight		= "22vh";
	var dialogWidth			= "35vw";
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no;overflow: hidden;";
	var arguments			= "";
	
	var param="waitlist_no="+waitNo;
	//var ret=await top.window.showModalDialog("../../eOT/jsp/WaitListCancel.jsp?"+param,window,"dialogHeight: 130px; dialogWidth:479px; center: yes; help: no; resizable: no; status: no;");
	var ret=await top.window.showModalDialog("../../eOT/jsp/WaitListCancel.jsp?"+param,arguments,features);
	
	if(ret=='0'||ret==''||ret==null || ret=='undefined') return false;
	alert (ret)
	//Call OT_CANCEL_WAITLIST procedure to cancel  waitList
}

function converString(objstr,constr,eschar){
	var convStr=objStr.replace(eschar,constr);
	return convStr;
}

async function callTransfer(locale){
	var column_sizes = escape("60%,40%");
	var obj=document.forms[0];

	// Modified by Selvam 25-Oct-2006
	var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Description,Code");
	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS WHERE NVL(STATUS,'E') = 'E' AND REASON_CODE IN (SELECT REASON_CODE  FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'TA' AND NVL(ACTIVE_YN,'N') = 'Y') ");
	//Above code is commented and modified as below by lakshmi against IN-34246
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND REASON_CODE IN (SELECT REASON_CODE  FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'TA' AND NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");

	//var title='Transfer Reason Search';
	var title=getLabel("Common.reason.label","Common");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!='')
		{
	arr=retVal.split("::");
	if(arr[1]==undefined) { 
	arr[1]="";
	arr[0]="";
	}
	obj.reason_desc.value=arr[0];
	obj.reason_code.value=arr[1];
		}
	else
		{
	obj.reason_desc.value="";
	obj.reason_code.value="";
		}
}



async function callOnBlurTransfer(text,transfer_value,locale){
	var column_sizes = escape("60%,40%");
	var obj=document.forms[0];

	// Modified by Selvam 25-Oct-2006
	var tit=getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common');
	var column_descriptions = encodeURIComponent(tit);
	//var column_descriptions = escape("Description,Code");
	//var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS WHERE NVL(STATUS,'E') = 'E' AND REASON_CODE IN (SELECT REASON_CODE  FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'TA' AND NVL(ACTIVE_YN,'N') = 'Y') ");
	//Above code is commented and modified as below by lakshmi against language_id issue
	var sql=escape("SELECT REASON_DESC REASON_DESC1, REASON_CODE REASON_CODE1 FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND REASON_CODE IN (SELECT REASON_CODE  FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'TA' AND NVL(ACTIVE_YN,'N') = 'Y') AND LANGUAGE_ID='"+locale+"' ");

	//var title='Transfer Reason Search';
	var title=getLabel("Common.reason.label","Common");
	title=encodeURIComponent(title);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+text;
	retVal=await callDialog(param);

	retVal=checkNull(retVal);
	if(retVal!='')
		{
	arr=retVal.split("::");
	if(arr[1]==undefined) { 
	arr[1]="";
	arr[0]="";
	}
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
var function_id=frmObj.function_id.value;
var change_theatre_date=dateUtils(frmObj.theatre_date.value,locale);
//if(frmObj.theatre_date.value==null || frmObj.theatre_date.value==''){
if(change_theatre_date==null || change_theatre_date==''){
 var msg = getMessage("CANNOT_BE_BLANK","OT");
 var msgArray = msg.split("&");
 alert(msgArray[0]+getLabel("eOT.TheatreDate.Label","OT")+msgArray[1]);
 return;
}
//Modified by rajesh for (SCF-1744 on 25th apr 2008

 //var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SEX SEX1,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) PATIENT_NAME1,A.SURGEON_CODE SURGEON_CODE1,A.SPECIALITY_CODE SPECIALITY_CODE1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.OPER_CODE OPER_CODE1, A.OPER_DESC OPER_DESC1,  A.RESCHD_REASON_CODE RESCHD_REASON_CODE1, B.REASON_DESC REASON_DESC1, A.SURGEON_NAME SURGEON_NAME1,A.APPT_REF_NUM APPT_REF_NUM1 FROM  OT_SCHD_OPERS_VW A, OT_REASONS B WHERE A.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'  AND 	NVL(BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' AND  NVL(A.BOOKING_STATUS,'X') 	= 'R' AND 	 APPT_DATE BETWEEN  	TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND 	TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI') AND	  A.RESCHD_REASON_CODE = B.REASON_CODE ";

 /*var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "surgeon_code="+frmObj.SURGEON_CODE.value+"&change_theatre_date="+change_theatre_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=rescheduleSearchCount&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
		if (retVal==0){
				callNoRecord();
		}*/

// var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SEX SEX1,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) PATIENT_NAME1,A.SURGEON_CODE SURGEON_CODE1,A.SPECIALITY_CODE SPECIALITY_CODE1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.OPER_CODE OPER_CODE1, A.OPER_DESC OPER_DESC1,  A.RESCHD_REASON_CODE RESCHD_REASON_CODE1, B.REASON_DESC REASON_DESC1, A.SURGEON_NAME SURGEON_NAME1,A.APPT_REF_NUM APPT_REF_NUM1 FROM  OT_SCHD_OPERS_VW A, OT_REASONS B WHERE A.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'  AND A.LANGUAGE_ID= '"+frmObj.locale.value+"' AND 	NVL(BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' AND  NVL(A.BOOKING_STATUS,'X') 	= 'R' AND 	 APPT_DATE BETWEEN  	TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND 	TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI') AND	  A.RESCHD_REASON_CODE = B.REASON_CODE ";

//Commented against MMS-QH-CRF-0199
/* var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SEX SEX1,to_char(A.APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1, to_char(A.APPT_TO_TIME,'hh24:mi')  APPT_TO_TIME1,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) PATIENT_NAME1,A.SURGEON_CODE SURGEON_CODE1,A.SPECIALITY_CODE SPECIALITY_CODE1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.OPER_CODE OPER_CODE1, A.OPER_DESC OPER_DESC1,  A.RESCHD_REASON_CODE RESCHD_REASON_CODE1, B.REASON_DESC REASON_DESC1, A.SURGEON_NAME SURGEON_NAME1,A.APPT_REF_NUM APPT_REF_NUM1 ,C.PATIENT_CLASS PATIENT_CLASS1,C.ENCOUNTER_ID ENCOUNTER_ID1,a.ORDER_ID FROM  OT_SCHD_OPERS_VW A, OT_BOOKING_HDR C,OT_REASONS B WHERE A.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'  AND A.LANGUAGE_ID= '"+locale+"' AND NVL(A.BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' AND  NVL(A.BOOKING_STATUS,'X') = 'R' AND  APPT_DATE BETWEEN  TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI') AND  A.OPERATING_FACILITY_ID  = C.OPERATING_FACILITY_ID AND  A.APPT_REF_NUM  = C.BOOKING_NUM AND  A.RESCHD_REASON_CODE = B.REASON_CODE  ";//047067 Bharati*/

//Modified against MMS-QH-CRF-0199
 var sql="SELECT A.PATIENT_ID PATIENT_ID1,A.SEX SEX1,to_char(A.APPT_FROM_TIME,'hh24:mi') APPT_FROM_TIME1, to_char(A.APPT_TO_TIME,'hh24:mi')  APPT_TO_TIME1,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) PATIENT_NAME1,A.SURGEON_CODE SURGEON_CODE1,A.SPECIALITY_CODE SPECIALITY_CODE1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.OPER_CODE OPER_CODE1, D.LONG_DESC OPER_DESC1,  A.RESCHD_REASON_CODE RESCHD_REASON_CODE1, B.REASON_DESC REASON_DESC1, A.SURGEON_NAME SURGEON_NAME1,A.APPT_REF_NUM APPT_REF_NUM1 ,C.PATIENT_CLASS PATIENT_CLASS1,C.ENCOUNTER_ID ENCOUNTER_ID1,a.ORDER_ID FROM  OT_SCHD_OPERS_VW A, OT_BOOKING_HDR C,OT_REASONS B ,OT_OPER_MAST_LANG_VW D WHERE A.OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"'  AND A.LANGUAGE_ID= '"+locale+"' AND NVL(A.BOOKING_STATUS,'X') <> '9' AND NVL(OPER_STATUS,'XX') <> '99' AND  NVL(A.BOOKING_STATUS,'X') = 'R' AND  APPT_DATE BETWEEN  TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI') AND  A.OPERATING_FACILITY_ID  = C.OPERATING_FACILITY_ID AND  A.APPT_REF_NUM  = C.BOOKING_NUM AND  A.RESCHD_REASON_CODE = B.REASON_CODE AND A.LANGUAGE_ID=D.LANGUAGE_ID AND A.OPER_CODE=D.OPER_CODE   ";
 
 sql+="%28%2B%29";
var where="";
if(frmObj.SPECIALITY_CODE.value!=null && frmObj.SPECIALITY_CODE.value!='')
	where=escape("  and instr(NVL(A.ALL_SPECIALITY_CODES,A.SPECIALITY_CODE),'#"+frmObj.SPECIALITY_CODE.value+"#') > 0 ");
if(frmObj.SURGEON_CODE.value!=null && frmObj.SURGEON_CODE.value!='')
	where+=escape(" and SURGEON_CODE ='"+frmObj.SURGEON_CODE.value+"'");
	//MO-CRF-20082 start
if(frmObj.patientid.value!=null && frmObj.patientid.value!='')
	where+=" and a.PATIENT_ID ='"+frmObj.patientid.value+"'";
if(frmObj.ordering_doctor_code.value!=null && frmObj.ordering_doctor_code.value!='')
   //MO-CRF-20082 end
	where+=" and A.ORDER_ID IN (SELECT ORDER_ID FROM OR_ORDER WHERE ORDER_ID = A.ORDER_ID AND ORD_PRACT_ID ='"+frmObj.ordering_doctor_code.value+"')";
sql+=where;
var param='sql='+sql+'&function_id='+function_id;
//parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtl.jsp?'+param;
parent.qa_query_result.location.href = '../../eOT/jsp/ReScheduleDtlFrame.jsp?'+param;
}

async function openIPDialog(parametrs){
 var retVal =  new String();
 var dialogHeight= "700px" ;
 var dialogWidth = "1300px" ;
 var dialogTop = "10" ;
 var status = "no";
 var arguments = "" ;
 var features = "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
 retVal = //window.showModalDialog("../../eIP/jsp/Booking.jsp?call_func="+call_func+"&Patient_Id="+Patient_Id+"&medical_service="+medical_service+"&booking_date_time="+booking_date_time+"&medical_speciality_desc="+medical_speciality_desc+"&medical_speciality_code="+medical_speciality_code+"&physician_desc="+physician_desc+"&physician_code="+physician_code,arguments,features);
 await window.showModalDialog("../../eIP/jsp/Booking.jsp?"+parametrs,arguments,features);
}

async function searchSpeciality(obj){
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//Below Query is modified by muthuN against 36325 on 1/9/2013
	/* If Status is Disabled that speciality should not get displayed into the Booking Speciality Screen */
	var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) AND nvl(a.eff_status,'X')= 'E' and nvl(b.STATUS,'E')!= 'D' order by 2";
	//Qry Modified by BShankar on 23.08 -- and STATUS != 'D'
	//var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";
	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(getLabel("Common.speciality.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {								
	document.forms[0].SPECIALITY_DESC.value = localTrimString(arr[1]);
	document.forms[0].SPECIALITY_CODE.value = localTrimString(arr[0]);

		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}
	}
else
	{
	document.forms[0].SPECIALITY_DESC.value = '';
	document.forms[0].SPECIALITY_CODE.value ='';
		//obj.value = returnedValues[1];
	}
	//alert('Booking.js :' + document.forms[0].SPECIALITY_DESC.value);//Sanjay
	//anesReqYN();
}

//Function added by Sanjay to clear the Speciality code when Speciality Description is null
function clearSpeciality_Code(Obj){
	//alert('clearSpeciality_Code');
	var formObj = document.forms[0];
	var SPECIALITY_DESC=Obj.value;
	if(SPECIALITY_DESC=="" || SPECIALITY_DESC==null || SPECIALITY_DESC=="null" || SPECIALITY_DESC=="undefined")	{
		formObj.SPECIALITY_CODE.value="";
		formObj.anaes_review.checked = false;
		//formObj.anes_check.style.visibility='hidden';
		formObj.anaes_review.disabled = true;
		//alert('speciality_code' + formObj.speciality_code.value);
		clearValues();//Added Against ML-MMOH-CRF-1939-US2
		message_search_frame.detailframe.message_search_frame.dtlForm.OperationLookUp.disabled=false;
	}
}

//Function added by Sanjay for Anesthesia Required Checkbox against IN032063
function anesthesiaRequiredYN(){
	//alert ('Inside anesReqYN');
	var SPECIALITY_CODE = document.forms[0].SPECIALITY_CODE.value;
	//alert ('Booking.js SPECIALITY_CODE value:' +SPECIALITY_CODE + ':');
	if (SPECIALITY_CODE.length > 0) {
		//alert("Inside if"+(SPECIALITY_CODE.length > 0));//Sanjay
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=anes_req_YN&SPECIALITY_CODE="+SPECIALITY_CODE,false);
		xmlHttp.send(xmlDoc);
		//alert ('before retVal');
		var retVal = trimString(xmlHttp.responseText);
		//alert('After retVal :' +retVal);
		if (retVal == 'Y'){
			//document.forms[0].anaes_review.checked = false;
			document.forms[0].anaes_review.checked = true;
			document.forms[0].anaes_review.disabled = false;
			//document.forms[0].anes_check.style.visibility='hidden';
		}
		else if (retVal == 'N'){
			//document.forms[0].anes_check.style.visibility='hidden';
			document.forms[0].anaes_review.checked = false;
			document.forms[0].anaes_review.disabled = true;
		}
	}

	//var arrMsg=retVal;
}

async function searchSurgeon(obj){
	var frmObj=document.forms[0];
	//frmObj.SPECIALITY_CODE.value="";
	//frmObj.SPECIALITY_DESC.value="";
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj1=document.forms[0];
	var sql_query="";
	
	if((obj1.SPECIALITY_CODE.value == null) || (obj1.SPECIALITY_CODE.value =='')){
		sql_query = "OTINTERNALREP_5::otsql::"+obj1.locale.value+"::";
	}
	//var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	//Qry modified by BShankar on 23/08

//	var sql= "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S' ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
//Code Modified by rajesh for including RoleType on 09/07/2008

//	var sql= "SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+obj1.locale.value+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE IN ('OS','AS'))  AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

//var sql= "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND NVL(EFF_STATUS,'X') <> 'S' ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
//sql= "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACTITIONER_ID <>'*ALL' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND NVL(EFF_STATUS,'X') <> 'S' ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2"; //Modified by lakshmi for duplication of records in booking verification screen
	if((obj1.SPECIALITY_CODE.value != null) && (obj1.SPECIALITY_CODE.value !='')){
		sql_query ="OTINTERNALREP_2::otsql::"+obj1.locale.value+"::"+obj1.facility_id.value+"::"+obj1.SPECIALITY_CODE.value+"::"+obj1.SPECIALITY_CODE.value+"::";
}
	//Qry modified by BShankar on 23/08
	//	sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	 // sql  = "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"')) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";

	// sql  = "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'E') = 'E'  AND (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') OR PRIMARY_SPECIALITY_CODE='"+obj1.SPECIALITY_CODE.value+"')) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
//Code altered by rajesh for including role_type on 09/07/08

//sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+obj1.locale.value+"' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='OS') AND ((primary_speciality_code = '"+obj1.SPECIALITY_CODE.value+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+obj1.facility_id.value+"' AND speciality_code = '"+obj1.SPECIALITY_CODE.value+"'))) AND UPPER(practitioner_name) LIKE UPPER(?) AND UPPER(practitioner_id) LIKE UPPER(?) order by 2";

	// sql  = "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'E') = 'E'  AND (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') OR PRIMARY_SPECIALITY_CODE='"+obj1.SPECIALITY_CODE.value+"')) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	 //sql  = "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACTITIONER_ID <>'*ALL' AND PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'E') = 'E'  AND (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') OR PRIMARY_SPECIALITY_CODE='"+obj1.SPECIALITY_CODE.value+"')) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";	//Modified by lakshmi for duplication of records in booking verification screen
	
	argumentArray[0] = sql_query;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(getLabel("Common.Surgeon.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										
		document.forms[0].SURGEON.value = arr[1];
		document.forms[0].SURGEON_CODE.value = arr[0];

		//specaility defaulting is commented by bala on 18/10/2007 as instructed by vishwa.
		/*if(document.forms[0].SPECIALITY_CODE.value==''){
			document.forms[0].SPECIALITY_CODE.value=getSurgeonSpeicality(returnedValues[0]);
			document.forms[0].SPECIALITY_DESC.value=getSurgSpecialityDesc(document.forms[0].SPECIALITY_CODE.value);
		}*/
	}else{
	document.forms[0].SURGEON.value = '';
	document.forms[0].SURGEON_CODE.value = '';

		//obj.value = returnedValues[1];
	}
}


async function searchOrderingSurgeon(obj,target){
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
	if((obj1.SPECIALITY_CODE.value == null) || (obj1.SPECIALITY_CODE.value ==''))
	var sql= "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'X') != 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	if((obj1.SPECIALITY_CODE.value != null) && (obj1.SPECIALITY_CODE.value !=''))
	sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj1.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND NVL(EFF_STATUS,'X') != 'S'  AND PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+obj1.facility_id.value+"' AND SPECIALITY_CODE = '"+obj1.SPECIALITY_CODE.value+"') AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Surgeon.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value = arr[1];
		obj.value = arr[0];
	}else{

	target.value = '';
	obj.value= '';

		//obj.value = returnedValues[1];
	}
}


async function searchProcedure(obj)
{
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
	returnedValues = await CommonLookup(getLabel("Common.Surgeon.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
	}
}
async function searchTheatre(obj){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var obj1=document.forms[0];
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

		// Added for IN023798  on 20/09/2010 by AnithaJ

		sql=sql+"select description, code from (SELECT decode('"+locale+"','th','ห�?อ�?�?�?า�?ั�?�?ั�?�?หม�?','ALL THEATRES') DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+frmObj.facility_id.value+"') where upper(description) like upper(?) AND upper(CODE) like upper(?) order by 2";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Theatre.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].theatre.value = arr[1];
	document.forms[0].room_code.value = arr[0];
	}else{
		document.forms[0].theatre.value = '';
		document.forms[0].room_code.value = '';
	}
}

async function searchTheatreType(obj){
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
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(getLabel("eOT.TheatreType.Label","OT"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].theatre_type_desc.value = arr[1];
	document.forms[0].theatre_type_code.value = arr[0];
	}else{
		document.forms[0].theatre_type_desc.value = '';
		document.forms[0].theatre_type_code.value = '';
	}
}

//Moved from DiaryScheduleSearch.jsp by rajesh for 12547 on 17/12/09

function setFirstDate(){
	var frmObj= document.forms[0];
	var locale = frmObj.locale.value;
	var obj = frmObj.chkavilable;
	var facility_id = frmObj.facility_id.value;
	var speciality_code=frmObj.SPECIALITY_CODE.value;
	if(obj.checked==true){
	if(frmObj.SURGEON.value==''&&frmObj.SPECIALITY_DESC.value==''&&frmObj.PROCEDURE.value==''){
		alert(getMessage("APP-OT0036","OT"));
		obj.checked=false;
		return false;
    }
		//commented by subramanian on 2/07/2005
		//var sql="select to_char(min(booking_date),'dd/mm/yyyy') from ot_booking_time_slots where status = 10 and BOOKING_DATE >= TRUNC(SYSDATE)";
		var sql="";
		//if speciality or procedure is entered
		if(frmObj.SPECIALITY_CODE.value!='') {
			sql="SELECT TO_CHAR(MIN(A.BOOKING_DATE),'DD/MM/YYYY') FROM OT_THEATRE_SCHEDULE A, OT_DIARY_SCHEDULE B WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND A.BOOKING_DATE >= TRUNC(SYSDATE) AND      NVL(A.AVAILABLE_SLOTS,0) > 0 AND A.OPERATING_FACILITY_ID= B.OPERATING_FACILITY_ID AND   A.BOOKING_DATE = B.BOOKING_DATE AND  A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE AND     B.SPECIALITY_CODE IN ('*ALL','"+speciality_code+"') AND  A.OPER_ROOM_CODE  = NVL('"+frmObj.room_code.value+"',A.OPER_ROOM_CODE)";
		}

		//surgeon alone is entered
		if( frmObj.SURGEON_CODE.value!='' && frmObj.SURGEON_CODE.value!=null){
			sql="SELECT TO_CHAR(MIN(A.BOOKING_DATE),'DD/MM/YYYY') FROM OT_THEATRE_SCHEDULE A, OT_DIARY_SCHEDULE B WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND A.BOOKING_DATE >= TRUNC(SYSDATE) AND      NVL(A.AVAILABLE_SLOTS,0) > 0 AND A.OPERATING_FACILITY_ID= B.OPERATING_FACILITY_ID AND   A.BOOKING_DATE = B.BOOKING_DATE AND  A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE AND     B.TEAM_DOCTOR_CODE  = '"+frmObj.SURGEON_CODE.value+"' AND  A.OPER_ROOM_CODE  = NVL('"+frmObj.room_code.value+"',A.OPER_ROOM_CODE)";
		}

		//if surgeon and speciality or procedure is entered
		if( frmObj.SPECIALITY_CODE.value!=''  && frmObj.SURGEON_CODE.value!=''){
			sql="SELECT TO_CHAR(MIN(A.BOOKING_DATE),'DD/MM/YYYY') FROM OT_THEATRE_SCHEDULE A, OT_DIARY_SCHEDULE B WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND A.BOOKING_DATE >= TRUNC(SYSDATE) AND      NVL(A.AVAILABLE_SLOTS,0) > 0 AND A.OPERATING_FACILITY_ID= B.OPERATING_FACILITY_ID AND   A.BOOKING_DATE = B.BOOKING_DATE AND  A.OPER_ROOM_CODE  = B.OPER_ROOM_CODE   AND     B.TEAM_DOCTOR_CODE  = '"+frmObj.SURGEON_CODE.value+"' AND B.SPECIALITY_CODE IN ('*ALL','"+speciality_code+"') AND  A.OPER_ROOM_CODE  = NVL('"+frmObj.room_code.value+"',A.OPER_ROOM_CODE)";
		}
		var param="sql="+sql;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		resTxt=eval(resTxt);
		frmObj.PREFERRED_DATE.value=convertDate(resTxt,"DMY","en",locale);
		frmObj.PREFERRED_MONTH.value='';
	}else{
		//Commented by rajesh for IN012547 on 17/12/09
		frmObj.PREFERRED_DATE.value=frmObj.sysdate.value;
	}
}
async function searchOTTheatre(obj){
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
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title = getLabel("Common.Theatre.label","common");
	returnedValues = await CommonLookup(title,argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].theatre.value = arr[1];
		document.forms[0].room_code.value = arr[0];
		if(frmObj.chkavilable.checked==true){
			setFirstDate();
		}
	}else{
		document.forms[0].theatre.value = '';
		document.forms[0].room_code.value = '';
		if(frmObj.chkavilable.checked==true){
			frmObj.PREFERRED_DATE.value=frmObj.sysdate.value;
		}
	}
}

function clearValues1()
{
	var frmObj=document.forms[0];
	frmObj.theatre.value = '';
	frmObj.room_code.value = '';
		if(frmObj.chkavilable.checked==true){
			frmObj.PREFERRED_DATE.value=frmObj.sysdate.value;
		}
}

async function searchOperation(obj)
{
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
	returnedValues = await CommonLookup(getLabel("Common.operation.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
	}
}

async function searchAnaesthetist(obj)
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
	//Changed by rajesh on 18/10 for pract type.
	//var sql="select short_name DESCRIPTION,PRACTITIONER_ID CODE from AM_PRACTITIONER_LANG_VW where LANGUAGE_ID = '"+frmObj.locale.value+"' and  PRACT_TYPE IN ('AN') and  NVL(EFF_STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

	//Code altered by rajesh fo including role_type on 09/07/2008

//	var sql="SELECT PRACTITIONER_ID CODE, SHORT_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+frmObj.locale.value+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE IN ('AA','MA')) AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";

var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+frmObj.locale.value+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='MA') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified by rajesh lookup issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(getLabel("Common.Anaesthetist.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
	frmObj.Anaesthetiest2_code.value=arr[1];
		frmObj.Anaesthetiest1_code.value=arr[0];
	}else{
		frmObj.Anaesthetiest1_code.value="";
		frmObj.Anaesthetiest2_code.value="";
	}
}

async function searchProceduresdsdsd(obj)
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
	returnedValues = await CommonLookupprocedure("Procedure", argumentArray );
}

function storeVal111(currad)
{
    radioval=currad.value
}

async function CommonLookupprocedure111(title,pArgumentArray)
{
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

function initializeText1111() 
{
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

function formQueryString111(pArgumentArray,callFrom)
{
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

async function searchorderid(obj)
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
	var sql="SELECT  to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') DESCRIPTION, ORDER_ID CODE FROM OT_PENDING_ORDER WHERE PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' AND upper(ORDER_ID) like upper(?) AND to_char(ORDER_DATE_TIME,'dd/mm/yyyy hh24:mi') like upper(?)";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookupfororderid("Order Id", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value=returnedValues[0];
	}
}

async function CommonLookupfororderid(title, pArgumentArray)
{
    var retVal = new String();
    var dialogHeight= "35" ;
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
    if(firstCodeVal == ""){
        var dialogUrl = "../../eoT/jsp/OrderidLookup.jsp?title="+title ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
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

function formQueryStringorderid( pArgumentArray, callFrom )
{
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
				sqlData = sqlData.concat(" ORDER BY DESCRIPTION ");
		}else{
				sqlData = sqlData.concat(" ORDER BY CODE ");
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
            url += "&f" + codePosition + "="+ escape( document.getElementById("search_text").value );
            url += "&f" + descPosition + "=";
        } else {
            url += "&f" + codePosition + "=";
            url += "&f" + descPosition + "=" + escape( document.getElementById("search_text").value );
        }
    }
    else
    {
        if(displayOrder == DESC_CODE)
        {
            url += "&f" + codePosition + "=" ;
            url += "&f" + descPosition + "=" + escape( argArray[5] ) ;
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
    return url ;
}


function storeValorderid(currad)
{
    radioval=currad.value;
}

function valtextorderid(comp)
{
    var txt=comp.value
    CallDescFrameorderid(this);
}


function resetFormorderid( formObj )
{
    formObj.reset();
 //   parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}

function initializeTextorderid()
{
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
    //makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
        fromCalledPage = true
        CallDescFrameorderid() ;
    }
}

function CallDescFrameorderid()
{
    parent.lookup_detail.location.href = "../../eOT/jsp/OrderidLookupResult.jsp?" + formQueryStringorderid();
}

function Modifyorder(obj)
{
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;
	var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;

    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "\"" + code2 ;
    top.window.returnValue = retVal ;
    top.close()
}

function refreshdetails()
{
	parent.qa_query_result.location.href = '../../eCommon/html/blank.html';
	parent.qa_query_result_tail.location.href='../../eCommon/html/blank.html';
}

function selectstages()
{
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
	var sequence  = resTxt.split("##");
	document.forms[0].next_stage_code_1.value=sequence[0];
	document.forms[0].next_specific_ind_1.value=sequence[1];
	document.forms[0].next_action_done_1.value=sequence[2];
	document.forms[0].next_stage_desc_1.value=sequence[3];
	document.forms[0].previlage_1.value=sequence[4];
}

async function displaydetails(booknum,surg,spec)
{
	dialogHeight = "5" ;
	var dialogWidth  = "20" ;
	var dialogTop    = "300";
	var dialogLeft   = "300";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var param="booknum="+booknum+"&surg="+surg+"&spec="+spec;
	retVal=await window.showModalDialog("../../eOT/jsp/Waitliststatusdetails.jsp?"+param,arguments,features);
}

function hideToolTip3()
{
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}

function reasonToolTip3(stvar,indx)
{
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	//Commented by Sharon Crasta on 5/29/2009 for IN010365
	//arr=arrMsg.split(",");
	arr=arrMsg.split("#");
	//Changes end here
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable3' cellpadding=0 cellspacing=0 border='0' class='BOX' width='50%' height='70%' align='center'>";
	for( cou=0;cou<arr.length;cou++){
                msg=arr[cou];
                tab_dat+= "<tr>";
				//Commented by Sharon Crasta on 5/29/2009 for IN010365
                // tab_dat+= "<td>"+arr[cou]+arr[cou+1]+"</td>";
                tab_dat+= "<td>"+arr[cou]+"</td>";
				//
                tab_dat+= "</tr> ";
        }
	tab_dat     += "</table> ";

	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow3();
}

function resizeWindow3()
{
	//Commented by Sharon Crasta on 5/29/2009 for IN010365
	//bodwidth =parent.frames[1].document.body.offsetWidth-300;
	//bodheight = parent.frames[1].document.body.offsetHeight-300;
	//
	bodwidth =parent.frames[0].document.body.offsetWidth-300;
	bodheight = parent.frames[0].document.body.offsetHeight-300;

	var x =event.x-300;
	var y =event.y-300;

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

async function searchreason(obj,obj1)
{
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmobj=document.forms[0];
	var locale=frmobj.locale.value;
	//var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('SC')  AND NVL(ACTIVE_YN,'N')='Y') AND UPPER(REASON_DESC) LIKE UPPER(?) AND UPPER(REASON_CODE) LIKE UPPER(?) ORDER BY 1";

	//Above code is commented and modified as below by lakshmi against language_id issue
	var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS_LANG_VW WHERE NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('SC')  AND NVL(ACTIVE_YN,'N')='Y') AND UPPER(REASON_DESC) LIKE UPPER(?) AND UPPER(REASON_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.reason.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		obj1.value = arr[0];
	}
	else{
		obj.value = '';
		obj1.value = '';
	}
}

async function searchItemSelect(obj)
{
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
	returnedValues = await CommonLookup(getLabel("Common.resourcetype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.forms[0].item_desc.value = arr[1];
		document.forms[0].item_id.value = arr[0];
		enablestore(obj)
	}else{
		document.forms[0].item_id.value = '';
		document.forms[0].item_desc.value = '';
	}
}

//function  displayToolTip4(patid,bookingnum,orderid,fl){
function  displayToolTip4(patid,bookingnum,orderid,fl,orderctlHDR,imgObj)
{
	var param='';
	param+=patid+","+bookingnum+","+orderid;
	var menu_id_list;
	var	menu_name_list;
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
    menu_id_list	= new Array("16","17");
	//Modified by Selvam 25-Oct-2006
	//menu_name_list	= new Array("Patient History","Pre-Anaesthesia Evaluation");
	menu_name_list	= new Array(getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
	//Commented and added by Sharon Crasta on 5/29/2009 for IN010365
	//Amazon Changes starts
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callMenuItem('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	//
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	//resizeWindow();
	resizeWindow(orderctlHDR);
}

function openHistoryforwaitlist(patient_id,order_num)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " order_num=\""+ order_num + "\" ";
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PatientHistoryParams.jsp",false);
	xmlHttp.send(xmlDoc);
	retVal = trimString(xmlHttp.responseText);
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

function funResetAll()
{	
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
	if(obj.value!=""){
		var	locale = document.forms[0].locale.value;
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		//		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
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
		//Leap year issue starts - 57876
		var str_date1;
		if( flag != false)
		{
			str_date1 = convertDate(str_date,'DMY',locale,'en');		
			arr_date = str_date1.split('/');
		}
		dt_date.setYear(arr_date[2]);
		//Leap year issue ends - 57876
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);

		}
		/* newly added for leap year */
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].P_FROM_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].P_TO_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}
		/* newly added for leap year eND*/
	}/* start newly added for leap year*/
	else{		
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value='';
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value='';
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value='';
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value='';
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].param1.value='';
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].param2.value='';
		}
		//Against for leap year ends
	}
	/*end newly added for leap year */
	return true;
}

function isValidMonth(obj)
{
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
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=4 ) flag=false;
		}


		if(flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		var flag1=false;
		if( arr_date[1]<dt_date.getFullYear() ) flag1=false;
		if(flag==false){
			alert(getMessage("MONTH_COMPARE_CURMONTH","OT"));
			return false;
		}
	}
	return true
}

function isValidTime(obj)
{
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

function cal_error (str_message,obj)
{
	alert (str_message);
	//obj.focus();
	//obj.select();
	obj.value='';
	obj.focus();
	obj.select();
	return null;
}

function clearSpltyCode(obj)
{
	if(obj.value=="")
		document.forms[0].SPECIALITY_CODE.VALUE="";
}

function callCalendarObj(obj)
{
	var formObj = document.forms[0];
	var check_box = formObj.ward_informed_yn;
	if(check_box.checked==true){
		return showCalendar(obj);
	}
	return false;
}

function checkWardInformedYN()
{
	var formObj = document.forms[0];
	imgObj1=document.getElementById('img1');
	imgObj2=document.getElementById('img2');
	//imgObj3=document.getElementById('img5');
	if(formObj.ward_informed_yn.checked==true){
		formObj.inform_date.disabled=false;
		formObj.inform_time.disabled =false;
		var sys_dt_time=formObj.dt_time.value;
		/* Modified by Muthukumar against SKR-SCF-0282 on 01/11/2011 */
		sys_dt_time =  convertDate(sys_dt_time,"DMYHM","en",formObj.locale.value);
		//sys_dt_time = dateUtils(sys_dt_time,"en","DMYHM",formObj.locale.value)
		/* Modified by Muthukumar against SKR-SCF-0282 on 01/11/2011 */
		var arr =sys_dt_time.split(" ");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		formObj.inform_date.value = arr[0];
		formObj.inform_time.value = arr[1];
		imgObj1.src = "../../eCommon/images/mandatory.gif";
		imgObj2.src = "../../eCommon/images/mandatory.gif";
		//imgObj3.src = "../../eCommon/images/CommonCalendar.gif";
		formObj.cancelled_remarks.disabled=false;

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
	}
}

function getSysDateTime()
{
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

async function searchSurgon(obj,target)
{
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var formObj=document.forms[0];
	var locale = formObj.locale.value;
	var facility_id = formObj.facility_id.value;
	var splty_code = (formObj.SPECIALITY_CODE!=null)?formObj.SPECIALITY_CODE.value:formObj.speciality_code.value;
	//Commented by Sharon Crasta on 6/1/2009 for IN010489(SRR20056-SCF-2987)
	//Changed primary_speciality_code to primary_speciality_desc
	//sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND ( (PRIMARY_SPECIALITY_CODE = '"+splty_code+"') OR (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+facility_id+"'  AND SPECIALITY_CODE = '"+splty_code+"'))) AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	//sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND ( (PRIMARY_SPECIALITY_DESC = '"+splty_code+"') OR (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+facility_id+"'  AND SPECIALITY_CODE = '"+splty_code+"'))) AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
	//Changes end here
	//var sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";

	sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND NVL(a.eff_status,'E') = 'E' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='OS') AND ((primary_speciality_code = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(practitioner_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) ORDER BY 2"
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = trimString(obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(getLabel("Common.Surgeon.label","Common"),argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
				var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value = arr[0];
		obj.value = arr[1];
	}else{
		target.value = target.value;
		obj.value =obj.value;
	}
}

//Asst Surgeon Code added on 19/12
async function searchAsstSurgeon(obj,target)
{
	var frmObj	=document.forms[0];
/*	var speciality_code=frmObj.SPECIALITY_CODE.value;
	if(speciality_code==null || speciality_code==""){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.speciality.label","Common")+" "+msgArray[1]);
		return false;
	}else{*/
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var title=getLabel("eOT.AsstSurgeon.Label","OT");
		var facility_id = formObj.facility_id.value;
		var splty_code = (formObj.SPECIALITY_CODE!=null)?formObj.SPECIALITY_CODE.value:formObj.speciality_code.value;
		//code altered by rajesh for including role_type on 09/07/2008
		//Commented by Sharon Crasta on 6/1/2009 for IN010489(SRR20056-SCF-2987)
		//Changed primary_speciality_code to primary_speciality_desc
		//sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='AS') AND ((primary_speciality_code = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(practitioner_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
//		sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='AS') AND ((primary_speciality_desc = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(practitioner_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
//		sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='AS') AND ((primary_speciality_desc = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(practitioner_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";
		//Changes end here
		//sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND ( (PRIMARY_SPECIALITY_CODE = '"+splty_code+"') OR (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+facility_id+"'  AND SPECIALITY_CODE = '"+splty_code+"'))) AND upper(SHORT_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

		//var sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";
		sql="SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND NVL(a.eff_status,'E') = 'E' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='AS') AND ((primary_speciality_code = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(practitioner_name) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) ORDER BY 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = trimString(obj.value);
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		returnedValues = await CommonLookup(title,argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
			target.value = arr[0];
			obj.value = arr[1];
		}else{
			target.value = '';
			obj.value ='';
		}
	//}
}

function callDateCheck(from,to)
{
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

function saveAsstSurgeons()
{
	var frmObj=document.forms[0];
	var surgeon_code=frmObj.surgeon_code.value;
	var auto_schdl_yn=frmObj.auto_schdl_yn.value;//Added by Gaurav Against ML-MMOH-CRF-1791-US03
	var surgeon_code2=frmObj.surgeon_code2.value;//Added by Gaurav Against ML-MMOH-CRF-1791-US03
	if(surgeon_code === ''){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
	        var msgArray = msg.split("&");
			msg1=msgArray[0]+getLabel("Common.Surgeon.label","Common")+msgArray[1];
			alert(msg1);
			return;
	}
	var asstSurg1=frmObj.asst_surgeon_code1.value;
	var asstSurg2=frmObj.asst_surgeon_code2.value;
	var booking_no=frmObj.booking_no.value;
	var tab_name=frmObj.tab_name.value;//Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03...
	var appt_ref_num=frmObj.appt_ref_num.value;//Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03...
	var oper_num=frmObj.oper_num.value;//Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03...
	/*var asstSurgeon=getLabel("eOT.AsstSurgeon.Label","OT");
	var msg = getMessage("SHOULD_NOT_BE_BLANK","common");
	var msgArray = msg.split("{1}");
	/* Commented against SCR-1977
	if((asstSurg1=="") && (asstSurg2==""))
	{
		alert(msgArray[0]+asstSurgeon+ " 1 & "+asstSurgeon+" 2 "+msgArray[1]);
		return;
	}
	*/
	if(checkDup(surgeon_code,asstSurg1) || checkDup(surgeon_code,asstSurg2)|| checkDup(asstSurg1,asstSurg2) ){
			alert(getMessage("RECORD_ALREADY_EXISTS","Common"));
			return;
	}else{
		var xmlStr ="<root></root>";
	//	var temp_jsp="RecordAsstSurgeon.jsp?booking_no="+booking_no+"&asstSurgeon1="+asstSurg1+"&asstSurgeon2="+asstSurg2;
		var temp_jsp="RecordAsstSurgeon.jsp?booking_no="+booking_no+"&asstSurgeon1="+asstSurg1+"&asstSurgeon2="+asstSurg2+"&surgeon_code="+surgeon_code+"&tab_name="+tab_name+"&appt_ref_num="+appt_ref_num+"&oper_num="+oper_num+"&auto_schdl_yn="+auto_schdl_yn+"&surgeon_code2="+surgeon_code2;//Modified by Gaurav Against ML-MMOH-CRF-1791-US03
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText = trimString(xmlHttp.responseText);
		var retVal = trimString(xmlHttp.responseText);
		//window.returnValue=retVal;
		//window.close();
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = retVal;
		
		const dialogTag = parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}
}

function checkDup(val1,val2)
{
	//false - no duplication occurs
	//true - duplication occurs
	return ( (trimString(val1).length>0  || trimString(val2).length>0) && (val1==val2) )?true:false
}

function callSurgeryTypeAndValidateCutOffTime(flag)
{
	var customerId = parent.message_search_frame.detailframe.message_search_frame.document.forms[0].customerId.value;//Added against KAUH-SCF-282

	var formObj = document.forms[0];
	var locale      =    formObj.locale.value;
	var facility_id      =    formObj.facility_id.value;

	if(flag=='SurgeryType'){
		callSurgeryType(locale);
		var nature_type = formObj.natureType.value;
		if(nature_type=='Elective')
          		nature_type='EL'
		if(nature_type!=null && nature_type=="EL"){
			var booking_date = formObj.BOOKING_DATE.value;
			//Added against KAUH-SCF-282
			var booking_no = formObj.booking_no.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
	     		//Modified against KAUH-SCF-282 
			var params = "order_id=&queried_pref_surg_date="+booking_date+"&nature_type="+nature_type+"&facility_id="+facility_id+"&booking_no="+booking_no+"&customerId="+customerId;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=validateElectiveCutOffTime&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var msg = getMessage("APP-OT0124","OT");
				alert(msg);
				formObj.surgeonType.value="";
				formObj.natureCode.value="";
				formObj.natureType.value="";
			}
		}
	}
}

function checkSpl1(val)
{
    var result = "" ;
    var ch = "" ;
    //var val=obj.value;
    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
			val = val.replace("\n","\"")
    }

    var spChars = new Array( "<", ">", "&", "\"","'") ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;","&#39;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    return result ;
}

//Added newly by rajesh for SPR-6073 on 05/11/2008

function getPatientName(patient_id)
{
	var sql="select patient_name  from mp_patient where patient_id='"+patient_id+"' ";
	var param="sql="+sql;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);;
	var return_val=xmlHttp.responseText;
	var rtn_val=eval(return_val)
	return rtn_val;
}

function rescheduleCount(ref_no,patient_id)
{
	var frmObj=document.forms[0];
	var facilityid=frmObj.facility_id.value;
	var pat_name=getPatientName(patient_id);
	var patient_name2=pat_name.replace("'","");//049840
	var sql="select NVL(RESCHEDULED_COUNT,0)  from OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID='"+facilityid+"' AND BOOKING_NUM ='"+ref_no+"'";
	var param="sql="+sql;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);;
	var resTxt=xmlHttp.responseText;
	var cou=eval(resTxt);
	var count=parseInt(cou,10);
	count=count+1;
	var suffix = "";
	if(count==1)
		suffix = "st";
	else if(count==2)
		suffix = "nd";
	else if(count==3)
		suffix = "rd";
	else
		suffix = "th";
	if(count == 1 || count > 1){
			var msg_1 = getMessage("APP-OT0081","OT");
			var msgArr=msg_1.split("$");
			var msgArray = msgArr[1].split("&");
			alert(msgArr[0]+" "+patient_name2+" ("+patient_id+") "+msgArray[0]+count+suffix+msgArray[1])//049840
		}
}

function setAssignValue(dat){
	return dat;
}

function callOrderLineCreation()
{
	var formObj = document.forms[0];
	var order_id = "";
	var oper_code = formObj.oper_code.value;
	var patient_id = parent.parent.parent.header_frame.document.forms[0].patient_id.value;
	var patient_class = parent.parent.parent.header_frame.document.forms[0].episode_type.value;
	var encounter_id = parent.parent.parent.header_frame.document.forms[0].encounter_id.value;
	var surgeon_code = parent.parent.parent.header_frame.document.forms[0].surgeonCode.value;
	var oper_date = parent.parent.parent.header_frame.document.forms[0].booking_date.value;
	//Leap Year
	var locale      =    formObj.locale.value;
	var fpp_category      =    formObj.fpp_category.value;
	oper_date=convertDate(oper_date,'DMY',locale,'en') ;	
	//Leap Year
	var start_time = parent.parent.parent.header_frame.document.forms[0].start_time.value;
	var oper_date_time=oper_date+" "+start_time;
	var param = "order_id="+order_id+"&oper_code="+oper_code+"&patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&surgeon_code="+surgeon_code+"&oper_date="+oper_date_time+"&called_from=DIRECT_BOOKING"+"&fpp_category="+fpp_category;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function callBillingWindow1(indx)
{
	var patient_id =parent.parent.parent.header_frame.document.forms[0].patient_id.value;
	//var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	var called_from=document.forms[0].called_from.value;
	if(called_from=="")
	{
	  called_from = "DIRECT_BOOKING";
	}
	if(called_from=="BOOKING" ||called_from=="OR"){
	var order_id=document.forms[0].order_id.value;
	var order_line_num = eval("document.forms[0].order_line_num"+indx+".value");
	var key=order_id;
	var key_line_no=order_line_num;
	}
	else
	{
	var order_id="";
	var order_line_num="";
	var key="";
	var key_line_no="";
	}
	//var booking_num=document.forms[0].booking_num.value;
	var operation_code = eval("document.forms[0].oper_code"+indx+".value");
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&key="+key+"&key_line="+key_line_no+"&oper_code="+operation_code+"&patient_id="+patient_id+"&called_from="+called_from;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	showBillingWindow1(responseText,indx);
}

async function showBillingWindow1(str,indx)
{
	//var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	var arr = str.split("::");
	var called_from=document.forms[0].called_from.value;
	if(called_from=="")
	{
	  called_from = "DIRECT_BOOKING";
	}

	if(called_from=="BOOKING" ||called_from=="OR"){
	//key = order_id
	//key_line = order_line_num
	var order_id=document.forms[0].order_id.value;
	var order_line_num = eval("document.forms[0].order_line_num"+indx+".value");
	var key=order_id;
	var key_line_no=order_line_num;
	}
	else
	{
	var order_id="";
	var order_line_num="";
	var key=arr[0];
	var key_line_no="";
	}
	var panel_str_key="";
	var module_id="OR";
	var order_catalog_code=getCatalogCode(arr[2]);
	var patient_id = arr[3];
	var episode_type = arr[4];
	var episode_id=arr[5];
	var visit_id=arr[6];
	var encounter_id=arr[7];
	var service_date=arr[8];
	var pract_staff_ind=arr[9];
	var pract_staff_id=arr[10];
	var service_panel_ind=arr[11];
	var service_panel_code=arr[12];
	var bean_id="";
	var dialogTop = "100";
	var dialogHeight = "500px" ;
	var dialogWidth = "1400px" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var column_descriptions ="";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_num+"&bean_id="+bean_id;
	
	var originalHeight1 = parent.parent.parent.document.getElementById('header_frame').style.height ;
	var originalHeight2 = parent.parent.parent.document.getElementById('message_search_frame').style.height ;
	parent.parent.parent.document.getElementById('header_frame').style.height = '0vh' ;
	parent.parent.parent.document.getElementById('message_search_frame').style.height = '85vh' ;

	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	
	parent.parent.parent.document.getElementById('header_frame').style.height = originalHeight1 ;
	parent.parent.parent.document.getElementById('message_search_frame').style.height = originalHeight2 ;
	
	if(typeof retVal!='undefined'){
		var bill_st=eval("document.forms[0].bill_st"+indx+".value");
		var arr=bill_st.split("::")[3];
		var bill_st1=bill_st.split("::")
		/*
		retVal[1]----->Total Payble
		retVal[2]----->Patient Payble
		retVal[3]----->Patient Paid
		arr----------->Charge_based_yn
		retVal[6]----->Excl_incl value
		bill_st1[5]--->Approval Reqd? value
		bill_st1[6]--->Service_panel_ind value
		*/
	   if(bill_st1[6]=='L' || retVal[6]=="")
		{
        if(retVal[6]=="") retVal[6]=null;
        if(retVal[7]=="") retVal[7]=null;
		}


		var charge_str = retVal[1]+"::"+retVal[2]+"::"+retVal[3]+"::"+arr+"::"+retVal[6]+"::"+bill_st1[5]+"::"+bill_st1[6]+"::"+retVal[7]+"::"+retVal[8];

		var rate=retVal[5];
		var pnl_str =  getPanelStr(indx);
		var panel_str =pnl_str.split("::")[13];
	   // var bill_str =pnl_str.split("::")[18];
		//var charge_str = retVal[1]+"::"+retVal[2]+"::"+retVal[3];
		updateRevisedPanelStr(indx,charge_str,panel_str,rate)
		paintBillingDetails(indx,charge_str);
	  }
 }

function getCatalogCode(oper_code)
{
	var sql="SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE='"+oper_code+"'";
	var param="sql="+sql+"&flag=MED_SER";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var resTxt=trimString(xmlHttp.responseText);
	return resTxt;
}

function getPanelStr(indx)
{
	var called_from=document.forms[0].called_from.value;
	if(called_from=="")
	{
	  called_from = "DIRECT_BOOKING";
	}
	if(called_from=="BOOKING" ||called_from=="OR"){
	var order_id=document.forms[0].order_id.value;
	var order_line_num = eval("document.forms[0].order_line_num"+indx+".value");
	var key=order_id;
	var key_line_no=order_line_num;
	}
	else
	{
	var order_id="";
	var order_line_num="";
	var key="";
	var key_line_no="";
	}

	var operation_code = eval("document.forms[0].oper_code"+indx+".value");
	var patient_id = parent.parent.parent.header_frame.document.forms[0].patient_id.value;

	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&key="+key+"&key_line="+key_line_no+"&oper_code="+operation_code+"&patient_id="+patient_id+"&called_from="+called_from;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function updateRevisedPanelStr(key,charge_str,panel_str,rate)
{
	var patient_id = parent.parent.parent.header_frame.document.forms[0].patient_id.value;
	var notapplicable=getLabel("Common.notapplicable.label","common");
	var desc =notapplicable;
	var called_from=document.forms[0].called_from.value;
	if(called_from=="")
	{
	  called_from = "DIRECT_BOOKING";
	}
	if(called_from=="BOOKING" ||called_from=="OR"){
		var order_id=document.forms[0].order_id.value;
		var order_line_num = eval("document.forms[0].order_line_num"+key+".value");
	}
	else
	{
		var order_id="";
	    var order_line_num="";
	}

	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "oper_code=\""+  checkSpl( eval("document.forms[0].oper_code"+key+".value") ) + "\" ";
	xmlStr+= "operation_desc=\""+  checkSpl(eval("document.forms[0].operation_desc"+key+".value")) + "\" ";
	xmlStr+= "appl_right_left_flag=\""+  checkSpl( eval("document.forms[0].appl_right_left_flag"+key+".value") )+ "\" ";
	xmlStr+= "duration=\""+  checkSpl( eval("document.forms[0].duration"+key+".value") )+ "\" ";
	xmlStr+= "remarks=\""+  checkSpl( eval("document.forms[0].xx"+key+".value") )+ "\" ";
	xmlStr+= "f_duration=\""+  checkSpl( eval("document.forms[0].f_duration"+key+".value") )+ "\" ";
	xmlStr+= "surgeon_avg_time=\""+  checkSpl( eval("document.forms[0].avgTime"+key+".value") )+ "\" ";
	xmlStr+= "splty_code=\""+  checkSpl( eval("document.forms[0].splty_code"+key+".value") )+ "\" ";
	xmlStr+= "patient_id=\""+patient_id+"\" ";
	xmlStr+= "panel_str=\""+  checkSpl( panel_str ) + "\" ";
	xmlStr+= "rate=\""+rate+"\" ";
	xmlStr+= "bill_str=\""+charge_str+"\" ";
	xmlStr+= " order_id=\""+order_id+"\" ";
	xmlStr+= " order_line_num=\""+order_line_num+"\" ";
	xmlStr+=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OperationCollectDetail.jsp?key="+key,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
}

function paintBillingDetails(row_num,charge_str)
{
	var lbl_total=getLabel("Common.total.label","common_labels");
	var lbl_payable=getLabel("eOT.Payable.label","ot_labels");
	var lbl_pateint_payable=getLabel("Common.PatientPayable.label","ot_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var lbl_incl=getLabel("Common.Included.label","common_labels");
	var lbl_approval=getLabel("eOT.ApprovalRequired.Label","ot_labels");
	var charge_arr = new Array();
	var charges = charge_str.split("::");
	var Total=charges[0];
	var Payable=charges[1];
	var Paid = charges[2];
	var inclexcl = "";
	var approvalreqd = "";
	if(charges[6]=='S')
	{
	if(charges[8]=="E" ||charges[8]=='') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
	if(charges[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(charges[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(charges[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}else{
	inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
	approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}
	var str = "<B><font color='Indigo' >"+lbl_total+"&nbsp;"+lbl_payable+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
	str+="<font color='crimson' >"+lbl_pateint_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font></B>";
	str+="<br>"+lbl_incl+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lbl_approval+approvalreqd;
	eval("document.getElementById('charge'+row_num)").innerHTML = str;
}

//Newly added for Amazon Changes......
function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj)
{
	obj.className = 'contextMenuItem';
}

function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;
  //var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	//var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;
	var wdth = eval("document.getElementById('"+orderctlHDR1+"')").offsetWidth;
	var hght1 = eval("document.getElementById('"+orderctlHDR1+"')").offsetHeight;
 
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;
 
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
 
	var z = bodwidth- (event.x + wdth);
 
	var x 	  = event.x;
	var y 	  = event.y;
 
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);
 
	if(x<bodwidth){
		x= wdth1;
	}else{
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){
		y = hght;
 
	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
	}
	document.getElementById("tooltiplayer").style.left= x+"px";
	document.getElementById("tooltiplayer").style.top = y+"px";
	document.getElementById("tooltiplayer").style.visibility='visible'
}

function callMouseOverOnTD(obj,imgObj)
{
		 if (prevObjID != null && prevObjID != obj.id)
		 {
			 /*eval("document.all."+prevObjID).className = 'gridDataBlue';
			 eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";*/
			 document.getElementById(prevObjID).className = 'gridDataBlue';
             document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";
		 }
		obj.className = 'selectedTDData';
		//eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;
}

function getPos(inputElement)
{
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}

function hidemenu()
{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
//Amazon Changes Ends Here....

//newly added for testing purpose

function  displayToolTipEmergency(bookingno,facility,patientid,bookingdate,roomcode,chkseq,pacyn,orderid,ind,fl,curstage,finstage,surg_code,surg_name,splty_code,splty_desc,encounter_id,orderctlHDR,imgObj)
{
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var menu_id_list		= new Array("V1","V2","V3","V4","V5","V7","V8","V9");
	var frmObj=document.forms[0];
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
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}else{
			menu_id_list	= new Array("V1","V4","V9");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
		}
	}else{
		if(ca_module_yn=="Y"){
			 menu_id_list		= new Array("V1","V2","V3","V4","V9");
			 //menu_name_list	= new Array("Booking Details","Surgery History","Patient History","Patient Demographics","Reassign Theatre");
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'));
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
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'), getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
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
			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
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

			menu_name_list	= new Array(getLabel('eOT.ViewBookingDetails.Label','OT'),getLabel('eOT.SurgeryHistory.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PatientDemographics.Label','OT'),getLabel('eOT.LinkPreOperativeOrders.Label','OT'),getLabel('eOT.MarkforReschedule.Label','OT'),getLabel('eOT.ReassignTheatre.Label','OT'),getLabel('eOT.LinkToCurrentEpisode.Label','OT'),getLabel('eOT.AssignAnaesthetist.Label','OT'),getLabel('eOT.AssignSurgeon.Label','OT'));
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
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'),getLabel('Common.PatientHistory.label','Common'),getLabel('eOT.PreAnaesthesiaEval.Label','OT'));
	}else{
		menu_id_list		= new Array("V15");
		//menu_name_list	= new Array("Assign Theatre","Patient History","Pre-Anaesthesia Evaluation");
		menu_name_list	= new Array(getLabel('eOT.AssignTheatre.Label','OT'));
	}
}


var consent_reqd_yn=consentRequiredYN(patientid,orderid);
//var consent_reqd_yn="Y";
if(consent_reqd_yn!="N"){
	menu_id_list.push("V20")
	menu_name_list.push("View Consent Details");//new Array(getLabel('eOT.AssignTheatre.Label','OT'));
}
//Amazon Changes starts
callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ ){
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callVerificationItem('"+id_colval+"','"+param+"');\")> "+id_name_colval + "  </a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
document.getElementById("tooltiplayer").innerHTML = tab_dat;
resizeWindow(orderctlHDR);
//resizeWindow();
document.getElementById("tooltiplayer").style.visibility = 'visible';

}

//Function to maintain the header part constant on vertical scrolling- added on april 8 2009 by Suma
function scrollTitle()
{
	  var x = document.body.scrollTop;

  if(x == 0){

  document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  =0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
   document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;
   document.getElementById("head6").style.position='static';
   document.getElementById("head6").style.posTop  = 0;
   document.getElementById("head7").style.position='static';
   document.getElementById("head7").style.posTop  = 0;
   document.getElementById("head8").style.position='static';
   document.getElementById("head8").style.posTop  = 0;
   document.getElementById("head9").style.position='static';
   document.getElementById("head9").style.posTop  = 0;
   document.getElementById("head10").style.position='static';
   document.getElementById("head10").style.posTop  = 0;
   if(document.forms[0].waitlist_key_dtl.value =="")
	  {
   document.getElementById("head11").style.position='static';
   document.getElementById("head11").style.posTop  = 0;
	  }
  }else{

	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-3;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  =x-3;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  =x-3;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-3;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  =x-3;
	document.getElementById("head6").style.position = 'relative';
	document.getElementById("head6").style.posTop  =x-3;
	document.getElementById("head7").style.position = 'relative';
	document.getElementById("head7").style.posTop  = x-3;
	document.getElementById("head8").style.position = 'relative';
	document.getElementById("head8").style.posTop  =x-3;
	document.getElementById("head9").style.position = 'relative';
	document.getElementById("head9").style.posTop  = x-3;
	document.getElementById("head10").style.position = 'relative';
	document.getElementById("head10").style.posTop  = x-3;
	if(document.forms[0].waitlist_key_dtl.value =="")
	  {
		document.getElementById("head11").style.position = 'relative';
		document.getElementById("head11").style.posTop  =x-3;
	  }
  }
}

function test5popupactivate(anchor)
{
    testpopup5 = new PopupWindow();
	val=document.getElementById("REMARKS").value;
	testpopup5.height=200;
	testpopup5.width=300;
	testpopup5.offsetX=-10;
	testpopup5.offsetY=10;
	testpopup5.autoHide();

	var title="Remarks";
	var buttonTitle="ok";

	testpopup5.populate('<title>'+title+'</title><link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=100 name="REMARKS" onkeyup="window.opener.document.getElementById("REMARKS").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonTitle+'"/></td></tr></table> </FORM>');
	testpopup5.showPopup(anchor);
	setval();
}

function setval()
{
	val=document.forms[0].REMARKS.value;
	//document.getElementById("remark").value=val;
}

function showCalendar_loc(Val1)
{
	var formObj=document.forms[0];
	var change_holding_desc=formObj.change_holding_desc.value;
		if(change_holding_desc==""){
			var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.HoldingBay.Label","OT"));
			alert(msg1);
			return false;	
		}else{
			return showCalendar(Val1);
	}
}

/*
Newly included by rajesh for CRF-SRR20056-INT-CRF-0003.4
*/


async function searchsourcetypeReferal(obj)
{
	var formObj=document.forms[0];
	var column_sizes = escape("60%,20%,10%");        
	var locale = formObj.locale.value;
	var surg_type_desc=obj.value
	var tit = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common')+','+getLabel('Common.longname.label','Common'); 
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT REFERRAL_CODE CODE, LONG_DESC DESCRIPTION, LONG_NAME LONG_NAMES FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	var title=getLabel("Common.referral.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=await callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		formObj.HLongRefSrcId.value=arr[0];
		formObj.sourceDesc.value=arr[0];
		formObj.Source_code.value=arr[1];
		if(arr[2]==""){
			document.getElementById("more_img").style.visibility = 'hidden';
		}else{
			document.getElementById("more_img").style.visibility = 'visible';
		}
		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.sourceDesc.value="";
		formObj.Source_code.value="";
	}
}

function searchSourceTypeSelect(obj)
{
	var formObj=document.forms[0];
	var patient_class=formObj.episode_type.value;
	if(patient_class=="XT"){
		searchsourcetypeReferal(obj);
	}else{
		searchsourcetype(obj);
	}
}

function callchangeMoreIcon()
{
	var formObj=document.forms[0];
	var Source_code=formObj.Source_code.value;
	if(Source_code==""){
		//document.getElementById("more_img").style.visibility = 'hidden';//CRF-OT-GHL-CRF-0356-02
	}
}

function decodeUTF8(str)
{
	 var REG_EXP =/\+/g;
	return decodeURIComponent(str,"UTF-8").replace(REG_EXP," ");
}

async function showWaitlistRemarks(order_id)
{
    var param = 'func_mode=waitlist_remarks&order_id='+order_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="OTCommonValidation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	var ret1=responseText;
	var heading = getLabel("eOT.PreOperativeDiagnosis.Label","OT");
	var dialogHeight		= "54vh";
	var dialogWidth			= "39vw";
	var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	heading=encodeURIComponent(heading);
	obj1=encodeURIComponent(ret1);
//	obj1=obj.value;

	var param='remarks='+obj1+'&heading='+heading+'&flag=0&size=1500';

	//obj1=obj1.replace(/%20/g,"$")
	var ret=await window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);

	var ret2;

}

//CRF-004 Authorize Slots for Booking - Rajesh V
async function chkPermSlotsBooking(bookingDate,operRoom,doctorCode,specialityCode,totalDur, customerId) //IN050472
{
	if(customerId == 'MOHBR') //IN050472
	{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH  /></root>";
	var param="func_mode=chkPermSlots&booking_date="+bookingDate+"&doctor_code="+doctorCode+"&oper_room="+operRoom+"&speciality_code="+specialityCode+"&total_dur="+totalDur;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var role_type = localTrimString(xmlHttp.responseText);
		if(role_type == 'NO')
		{
		var confirmBox = confirm(getMessage("APP-OT0199","OT"));
			if(confirmBox)
			{
			var url		= "../../eOT/jsp/AuthenticateBookingUsers.jsp?&oper_room="+operRoom+"&doctor_code="+doctorCode;
			var dialogHeight	= "11" ;
			var dialogWidth	= "25" ;
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
			var reportURL 	= await window.showModalDialog( url, arguments, features ) ;
				if(reportURL=='YES')
					role_type='YES';
		}
	}
	return role_type;
}
	else //IN050472
		return "YES";
}

//CRF-004 Authorize Slots for Booking - Rajesh V
function getSpecialityCodeDesc(specialityCodeDesc, code)
{
	 var specialityArray = specialityCodeDesc.split(" - ");
	 return specialityArray;
}

//Added by MuthuN against CRF - 011 on 2/7/2013
async function callPreOPDiagnosis()
{
	var HdrformObj=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= "";
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.source_code.value;
	var location_type= HdrformObj.source_type.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.patient_class.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.surgeon_code.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	if(arr[1]==undefined) { 
		retVal_arr[1]="";
		retVal_arr[0]="";
	}
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var speciality_code = HdrformObj.speciality_code.value;
	var visit_adm_date= "";
	var child_window="Y";
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = screen.availHeight ;
		var dialogWidth  		= screen.availWidth;
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog(jsp_name,arguments,features);
}

async function callPreOPDiagnosis_1()
{
	var HdrformObj=parent.frames[0].document.forms[0];
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= "";
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.source_code.value;
	var location_type= HdrformObj.source_type.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.patient_class.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.surgeon_code.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	if(arr[1]==undefined) { 
		retVal_arr[1]="";
		retVal_arr[0]="";
	}
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var called_from_ot = "PRE_OPER";
	var speciality_code = HdrformObj.speciality_code.value;
	var visit_adm_date= "";
	var child_window="Y";
	if(!checkForEmpty(parent.frames[0].document))
	{
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&called_from_ot="+called_from_ot+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = screen.availHeight ;
		var dialogWidth  		= screen.availWidth;
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog(jsp_name,arguments,features);
	}
}

async function callPreOPDiagnosis_2()
{
	var HdrformObj=document.forms[0];
	var Age= "";		// can pass null
	var Dob= HdrformObj.date_of_birth.value;
	var Function= "";
	var Sex= HdrformObj.sex.value;
	var encounter_id= HdrformObj.encounter_id.value;
	var episode_id= HdrformObj.episode_id.value;
	var episode_type= HdrformObj.episode_type.value;
	var function_id= "";
	var location_code= HdrformObj.sourceDesc.value;
	var location_type= HdrformObj.sourceType.value;
	var modal_yn= "Y";
	var occur_srl_no= "";
	var patient_class= HdrformObj.episode_type.value;
	var patient_id= HdrformObj.patient_id.value;
	var practitioner_id= HdrformObj.order_id.value;
	var  param_sur="func_mode=diag_code_scheme&practitioner_id="+practitioner_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param_sur,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	retVal_arr=retVal.split(":::");
	if(arr[1]==undefined) { 
		retVal_arr[1]="";
		retVal_arr[0]="";
	}
	var diag_code_scheme = retVal_arr[0];
	var practitioner_type = retVal_arr[1];
	var relationship_id= "";
	var term_code= ""; // can pass null
	var term_set_id= "";
	var called_from_ot = "PRE_OPER";
	var speciality_code = HdrformObj.SPECIALITY_CODE.value;
	var visit_adm_date= "";
	var child_window="Y";
	if(!checkForEmpty(parent.frames[1].document))
	{
		var param = "Age=&Dob="+Dob+"&Function="+Function+"&Sex="+Sex+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&location_code="+location_code+"&location_type="+location_type+"&modal_yn="+modal_yn+"&occur_srl_no="+occur_srl_no+"&patient_class="+patient_class+"&patient_id="+patient_id+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&relationship_id="+relationship_id+"&term_code="+term_code+"&visit_adm_date="+visit_adm_date+"&called_from_ot="+called_from_ot+"&child_window="+child_window+"&diag_code_scheme="+diag_code_scheme+"&speciality_code="+speciality_code;
		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?"+param;
		var retVal =        new String();
		var dialogHeight = screen.availHeight ;
		var dialogWidth  		= screen.availWidth;
		var dialogTop    = "0";
		var dialogLeft   = "0";
		var status = "no";
		var arguments    = "" ;
		var features        = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogLeft:" + dialogLeft + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog(jsp_name,arguments,features);
	}
}

function showPreOperDiagLink()
{
	var showDivLink = true;
	if(document.getElementById("showPreOperDiagDivAnch") == undefined)
	{
		return;
	}
	for(var index = 0; index < preOperDiagArray.length; index++)
	{
		var objValue = document.getElementById(preOperDiagArray[index]).value;
		if( objValue == "")
		{
			showDivLink = false;
		}
	}
	var objValue = document.getElementById(preOperDiagArray[1]).value;
	var encounter = document.getElementById("encounter_id").value;

	if(showDivLink && objValue != "XT" && encounter != "")
	{
		document.getElementById("showPreOperDiagDivAnch").style.display='inline';
		document.getElementById("showPreOperDiagDivLabel").style.display='none';
	}
	else if(showDivLink && objValue == "XT")
	{
		document.getElementById("showPreOperDiagDivAnch").style.display='none';
		document.getElementById("showPreOperDiagDivLabel").style.display='inline';
	}
	else
	{
		document.getElementById("showPreOperDiagDivAnch").style.display='none';
		document.getElementById("showPreOperDiagDivLabel").style.display='none';
	}
}

function checkForEmpty()
{
	for(var index = 0; index < preOperDiagArray.length; index++)
	{
		if(document.getElementById(preOperDiagArray[index]).value == '')
		{
			var msg1 = getMessage("OT_MANDATORY","OT");
			alert(msg1);
			return true;
		}
	}
	return false;
}

//Added for MO-CRF-20082
async function callPatientSearch()
{
	var patient_id	=	document.forms[0].patientid;
	var patient_name = document.forms[0].patient_name;
	var return_value =	"";
	if(patient_id.value.length>0) {
		return_value = patient_id.value; }
	else {
		return_value = await PatientSearch();
	}
	//return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(return_value==null)  return;
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;
	}else{
		obj.patientid.value	="";
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";
			patient_id.focus();
			return
	}
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
	}
}

//Added for MO-CRF-20082
function clearPatientName()
{
	var formObj = document.forms[0];
	formObj.patient_name.value='';
}

// start KDAH-CRF-0283 [IN:050553]
async function showPreOperativeComments(orderId, headingName)
{
	//preOperativeComments = encodeURIComponent(preOperativeComments, "UTF-8");
	headingName = encodeURIComponent(headingName, "UTF-8");
	await window.showModalDialog('../../eOT/jsp/TextAreaRemarks.jsp?heading='+headingName+'&calledFrom=pendingOrderTab&orderId='+orderId, window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function  showOperLongDesc(longDesc)
{
	var longDescLabel = getLabel("eOT.LongDescription.Label","ot_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+longDescLabel+ " </B> </a> </th>"
	tab_dat     += "</tr> ";
	tab_dat     += "<tr>"
	tab_dat     += "<td class='label' > "+longDesc+ "</a> </td>"
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow1();
}
// end KDAH-CRF-0283 [IN:050553]
// ChAiTu
function disableAll(patientId, selRec, operCode)
{
	//	alert("==patientId==="+patientId);
	//	alert("==selRec==="+selRec);
	// alert("==operCode==="+operCode);
	var totalRecCnt = $('#totalRecCnt').val();
	var isChked = false;
	var selPatId = '';
	var selProc = '';
	var patIdCnt = 0;
	//	alert("===totalRecCnt===="+totalRecCnt);
	
	
	if(selRec == 'All')
	{
		isChked = false;
	}
	else
	{
		for(var i=0; i<totalRecCnt; i++)
		{
			if($('#bukngsToSchedule'+i).is(':checked'))
			{
				isChked = true;
				
				$("input[name=chkBoxSelect"+i+']').val('true');
			}
			else
				{
			
				$("input[name=chkBoxSelect"+i+']').val('false');
				}
		}
		if(!isChked)
		{
			isChked = false;
		
			$('#bukngsToSchedule').attr("checked", false);
		}
	}

	if(isChked)
	{
		for(var i=0; i<totalRecCnt; i++)
		{
			var othrPatientId = $('#bukngsToSchedule'+i).val();
			var othrOperCode = $('#operCode_'+i).val();
			//alert("==othrOperCode=="+othrOperCode);
			if(patientId != othrPatientId)// || (!$('#bukngsToSchedule'+i).is(':checked') && operCode == othrOperCode))
			{
				//	alert("==iff==");
				$('#bukngsToSchedule'+i).attr("disabled", true);
			//	$("input[name=chkBoxSelect"+i+']').val('true');
				$('#orderctl'+i).attr("disabled", true);
			}
			else
			{
				if($('#bukngsToSchedule'+i).is(':checked'))
					patIdCnt++;
			}
		}
		//MMS-QH-CRF-0186 start			
			$('#NoOfCheckBoxSelected').val(patIdCnt);
		//MMS-QH-CRF-0186 end
		
		
		if(patIdCnt == $('#patIdCnt'+patientId).val()){
		
		$('#bukngsToSchedule').attr("checked", true);
		}
		
		else
			$('#bukngsToSchedule').attr("checked", false);
			$("input[name=chkBoxSelect"+i+']').val('false');
		$('#bukngsToSchedule').attr("disabled", false);
	}
	else
	{
		if($('#bukngsToSchedule').is(':checked'))
		{
			isChked = true;
			for(var i=0; i<totalRecCnt; i++)
			{
				if($('#bukngsToSchedule'+i).is(':checked'))
				{
					selPatId = $('#bukngsToSchedule'+i).val();
					selProc = $('#operCode_'+i).val();
					break;
				}	
			}
			for(var i=0; i<totalRecCnt; i++)
			{
				if(selPatId == $('#bukngsToSchedule'+i).val())// && selProc != $('#operCode_'+i).val())
				{
					$('#bukngsToSchedule'+i).attr("checked", true);
					$("input[name=chkBoxSelect"+i+']').val('true');//vikash on 27-Sept-15
					patIdCnt++;//14-08-2015 MMS-QH-CRF-186
				}
			}
			$('#NoOfCheckBoxSelected').val(patIdCnt);//14-08-2015 MMS-QH-CRF-186
		}
		else
		{
			for(var i=0; i<totalRecCnt; i++)
			{
				$('#bukngsToSchedule'+i).attr("disabled", false);
				$('#bukngsToSchedule'+i).attr("checked", false);
				$("input[name=chkBoxSelect"+i+']').val('false');
				isChked=false;
				$('#orderctl'+i).attr("disabled", false);
			}
			$('#bukngsToSchedule').attr("disabled", true);
			isChked=false;
			//$('input[name="chkBoxSelect"]').val('false');
			//$("input[name=chkBoxSelect"+i+']').val('false');
		}
	}
}

async function getPrimarySpeciality(patientId)
{
	var getSpecialityParams = 'Test';
	//alert("====patientId==="+patientId);
	var totalRecCnt = $('#totalRecCnt').val();
	var getChkedRecsOrderIds = new Array();
	var i = 0;
	for(i=0; i<totalRecCnt; i++)
	{
		if($('#bukngsToSchedule'+i).is(':checked') && $.inArray($('#speciality_code_'+i).val(), getChkedRecsOrderIds) == -1)
		{
//			alert("==ifff====");
			getChkedRecsOrderIds.push($('#selOrderIds_'+i).val());
		}
	}
	//alert("==getChkedRecsOrderIds=="+getChkedRecsOrderIds.length);
	if(getChkedRecsOrderIds.length > 1)
	{
		var retVal = '';
		var dialogHeight = "30" ;
		var dialogWidth = "200" ;
		var dialogTop = "210";
		var status = "no";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no; ";
		retVal = await window.showModalDialog("../../eOT/jsp/getPrimarySpeciality.jsp?&getChkedRecsOrderIds="+encodeURIComponent(getChkedRecsOrderIds)+"&patientId="+patientId, arguments, features);
		//alert("===retVal===="+retVal);
		if(retVal != null)
		{
			$('input[name="selOrderId"]').val(retVal);
		}
		else
			$('input[name="selOrderId"]').val('');
	}
	else
	{
		$('input[name="selOrderId"]').val(getChkedRecsOrderIds[0]);
	}
}

function closePrimary()
{
	var TotalRecord=$('#TotalRecord').val();
	var selectedRow=$('#selectedRow').val();
	
	
	var SelectedOrderID=$('#OrderID'+selectedRow).val();
	
	var AnesthesiaForSelectedOrder=$('#Anaesthesia'+selectedRow).val();
	var AnestesiaFlag="N";
	
	if(AnesthesiaForSelectedOrder=='Y'){
		AnestesiaFlag="N";
	}else{

		for(var i=0;i<TotalRecord;i++){
			if(i!=selectedRow){
				if($('#Anaesthesia'+i).val()=='Y'){
				AnestesiaFlag="Y";
				}
			}
		}
		if(AnestesiaFlag=='Y'){
		var msg = getMessage("APP-OT0234","OT");
		if(window.confirm(msg)){
			AnestesiaFlag="N";
			}
			
		}else{
		}
	}
	if(AnestesiaFlag=="N"){
	window.returnValue = document.getSpecialityForm.selectedOrderId.value;
	window.close();	
	
	
	}	
	//window.returnValue = document.getSpecialityForm.selectedOrderId.value;	
}

function assignValue(orderId,selectedRow)
{

	$('input[name="selectedOrderId"]').val(orderId);	
	$('input[name="selectedRow"]').val(selectedRow);	
	 $('#ok').prop('disabled', false);
}
//186
async function loadDetails(selRow)
{
	var locale = $('#locale').val();	
	var orderId = $('#orderId'+selRow).val();
	var selOrderIds = $('#selOrderIds').val();

	//MMS CRF-QH-186 
	var OverBookedStatus=$('#OverBookedStatus'+selRow).val();
	var dialogHeight = screen.availHeight;
	var dialogWidth = screen.availWidth;
	var dialogTop = "0";
	var dialogLeft = "0";
	var features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	var arguments = "";
	//MMS CRF-QH-186
	var param="booking_date="+convertDate($('#bookingDate'+selRow).val(), 'DMY', 'en', locale)+
	"&start_time="+$('#fromTime'+selRow).val()+
	"&end_time="+$('#maxToTime'+selRow).val()+
	"&roomCode="+$('#operRoomCode'+selRow).val()+
	"&roomDesc="+encodeURIComponent($('#operRoomDesc'+selRow).val())+
	"&surgeonCode="+$('#surgeonCode'+selRow).val()+ // Added against 57524 by selvin for testing
	//"&surgeonCode=*ALL"+ // commented against 57524//(Still doesn�??t display slots issue)
	"&surgeonName="+encodeURIComponent($('#surgeonName'+selRow).val())+
	"&speciality_code="+
	"&selSurgeonCode="+$('#surgeonCode'+selRow).val()+
	"&hidden_time="+$('#fromTime'+selRow).val()+
	"&called_from="+$('#calledFrom'+selRow).val()+
	"&spltycode="+
	"&spltydesc="+
	"&procedure="+
	"&function_id="+
	"&speciality_desc="+encodeURIComponent($('#specialityDesc'+selRow).val())+
	"&orderid="+$('#orderId'+selRow).val()+
	"&patientId="+$('#patientId').val()+
	"&full_vacant=VACANT"+
	"&ammendFlag=Y"+
	"&selBookingNumber="+$('#selBookingNumber'+selRow).val()+
	"&selOrderIds="+selOrderIds;
	

//	parent.dispRecsFrame.location.href="../../eOT/jsp/OperationRegisterFrame.jsp?"+param;
	//MMS CRF-QH-186
	/*if(OverBookedStatus=="N"){
	parent.dispSlotsFrame.location.href="../../eOT/jsp/Schedule.jsp?"+param;
	parent.dispRecsFrame.location.href="../../eOT/jsp/Schedule.jsp?"+par; // Added by selvin 
	}else{
	//parent.dispSlotsFrame.location.href="../../eOT/jsp/Schedule.jsp?"+param;
	param+="&over_booking_case_yn=Y";
	
	
	window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);
	}*/
	//MMS CRF-QH-186

	//Added by vikash for over booking cases issue
	if(OverBookedStatus=="Y"){
		param+="&over_booking_case_yn=Y";
	
	
		await window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);
	}else{
		//alert("Inside Booking Js 7623 param : "+param);
	parent.dispSlotsFrame.location.href="../../eOT/jsp/Schedule.jsp?"+param;
	parent.dispRecsFrame.location.href="../../eOT/jsp/TailScheduleLegend.jsp?"; // Added by selvin
	
	}
	

	var dialogHeight= "41" ;
	var dialogTop = "10" ;
	var dialogWidth	= "65" ;
	var dialogLeft	= "25" ;
	var features = "dialogLeft:"+dialogLeft+"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status:no";
	//retVal1=""+window.showModalDialog("../../eOT/jsp/OperationRegisterFrame.jsp?"+param,arguments,features);

}
//186

