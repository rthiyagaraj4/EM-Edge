/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result = "";
var message1= "";
var flag = "";
var oper_remarks="";
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message1  = _message ;
	flag = _flag ;
}

function create()
{
	//f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode=insert';
	return;
}

function beforePost(str){}

function reset(){
	//Added by MuthuN against 32630 on 1/17/2013
	//var formObj1 = (document.forms[0]!=null)?document.forms[0]:parent.frames[1].ChkListRecordFrame.document.forms[0];
	//var formObj1 = parent.frames[1].ChkListRecordFrame.document.forms[0];
	var formObj1 = f_query_add_mod.ChkListRecordFrame.PreOperHdr;
	var check_in_time_date  =  formObj1.check_in_time1.value;
	formObj1.checked_in_date_time.value = check_in_time_date;
	//Added by MuthuN against 32630 on 1/17/2013
	var formObj = parent.document.OTCheckinForm;
	var params = "";
	var tab_id = "";
	if(formObj!=null){
		params = formObj.params.value;
		tab_id = formObj.tab_id.value;
	}
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(tab_id != ""){
		if(tab_id=="CheckIn"){
			f_query_add_mod.location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+params;
		}else{
			f_query_add_mod.location.href="../../eOT/jsp/PendingOrderFrm.jsp?"+params;
		}
	}
}

function checkDtlRecords(){
  //var val = document.frames.f_query_add_mod.ChkListDetailFrame.DetailFrame.document.forms[0].size.value;
	var val =parent.window[2].window[2].window[1].window[1].document.getElementById("OperationDetail").size.value;
	  if(val==0) return 0;
    return 1;
 }

//check one operating speciality match with operation
 function checkOperations(){
	// formObj=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	 formObj=document.getElementById("PreOperHdr");
	 //formObj1=document.frames.f_query_add_mod.ChkListDetailFrame.RecordFrame.document.RecordOperationForm;
	 formObj1=document.getElementById("RecordOperationForm");
	 var doc = parent.window[2].window[2].window[0];
	 var doc1 = parent.window[2].window[2].window[1].window[0];
	 var speciality_hdr=doc.speciality_code.value;
	 var speciality_dtl=doc1.collect_speciality_code.value;
	 if(speciality_dtl.indexOf(speciality_hdr)==-1)
		 return false;
	 else
 	     return true;
 }

 function loadToolBar(called_from){
	if(called_from=='BOOKING')
	 {
	var qry_str="menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_CHECK_IN&function_name=Check-In&function_type=F&access=YYNNY&desktopFlag=N&facility_id=HS&called_from=BOOKING&booking_num=null&slate_user_id=null";
	commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+qry_str;
	 setTimeout("loadToolBar1()",400);
	 }
	else
	 {
	 var qrystr="module_id=OT&function_type=F&menu_id=26&access=NYNNN&home_required_yn=N&function_id=OT_CHECK_IN&function_name=Check-In&called_from=OT_SLATE";
      parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?"+qrystr;
	 }
 }

 function loadToolBar1(){
	commontoolbarFrame.document.forms[0].reset.disabled=true;
 }

  function loadToolBar2(){
	parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
 }

 function checkFields_booking( fields, names, messageFrame,qry_str) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else {
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
		}
    }
    if ( errors.length != 0 ) {
         messageFrame.document.location.href="../../eCommon/jsp/error.jsp?"+qry_str+"&err_num="+errors;
       //  commontoolbarFrame.document.forms[0].reset.disabled=true;
		   setTimeout("loadToolBar1()",400);
       return false ;
    }
    return true ;
}

function apply()
{
	var surgeryDate=getLabel("eOT.SurgeryDate.Label","OT");
	var operatingSpeciality=getLabel("eOT.OperatingSpeciality.Label","OT");
	var surgeryType=getLabel("Common.SurgeryType.label","common");
	var encountertype=getLabel("Common.encountertype.label","common");
	var encounterid=getLabel("Common.encounterid.label","common");
	var patientId=getLabel("Common.patientId.label","common");
	var theatre=getLabel("Common.Theatre.label","common");
	var surgeon=getLabel("Common.Surgeon.label","common");
	var AnaesthesiaType = getLabel("eOT.AnaesthesiaType.Label","OT");
	//var formObj=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	var formObj = f_query_add_mod.ChkListRecordFrame.document.getElementById("PreOperHdr");
	//var locale = formObj.locale.value;
	var locale = document.getElementById("locale").value;
	//var called_from = formObj.called_from.value;
	var doc = parent.window[2].window[2].window[0];
	var called_from = doc.called_from.value;
	//var order_DateTime =formObj. order_DateTime.value;
	var order_DateTime = doc.order_DateTime.value;
	//var retvalValidDateTime = isValidDateTime(formObj.checked_in_date_time);
	var retvalValidDateTime = isValidDateTime(doc.checked_in_date_time);
	//formObj.check_in_time.value = convertDate(formObj.check_in_time.value,"DMYHM",locale,"en");
	doc.check_in_time.value = convertDate(doc.check_in_time.value,"DMYHM",locale,"en");
	//PMG2016-KDAH-CRF-0001
	var multi_check_in_yn="";
	//multi_check_in_yn=formObj.multi_check_in_yn.value;
	multi_check_in_yn=doc.multi_check_in_yn.value;
	if (retvalValidDateTime == false)
			return false;
	if(called_from=="BOOKING"){
		//var formObjParent = document.OTCheckinForm;
		var formObjParent = document.frames.f_query_add_mod.ChkListRecordFrame.document.forms[0];
		var qry_str = formObjParent.params.value;
	}
	//var check_for_check_list_compl = formObj.check_for_check_list_compl.value;
	var check_for_check_list_compl = doc.check_for_check_list_compl.value;
	var checklist_flag = "true";
	if(check_for_check_list_compl=="Y"){
		//if(called_from!="OT_MENU" && formObj.checklist_completed_yn.value=="N"){
		if(called_from!="OT_MENU" && doc.checklist_completed_yn.value=="N"){
			checklist_flag = "false";
			var msg1 = getMessage("INCOMPLETE_CHECKLIST","OT");
			alert(msg1)
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
			setTimeout("loadToolBar('"+called_from+"')",200);
		}
	}
	if(checklist_flag == "true"){
		//var recordFormObj=document.frames.f_query_add_mod.ChkListDetailFrame.RecordFrame.document.forms[0];
		var submitflag=false;
		if(called_from=="OT_SLATE"){ // means it is called from OT Slate
			//var fields= new Array( formObj.surgeon_code);
			var fields= new Array( doc.surgeon_code);
			// give the Label name on the GUI screen
			var names=new Array(surgeon);

		if(checkFields( fields, names, messageFrame)){
					submitflag=true;
			}else{
					submitflag=false;
				}
		}


	//means calling from Pending orders
	if(called_from=="BOOKING"){
			var formObj=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
			//var fields= new Array( formObj.oper_room_code,formObj.surgeon_code);
			var fields= new Array( doc.oper_room_code,doc.surgeon_code);
			//var surgeon_code=formObj.surgeon_code.value;
			var surgeon_code=doc.surgeon_code.value;
			var asstSurg1=formObj.asst_surgeon_code1.value;
			var asstSurg2=formObj.asst_surgeon_code2.value;
			//var formObjParent = document.OTCheckinForm;
		    	//var qrystr="module_id=OT&function_type=F&menu_id=26&access=NYNNN&home_required_yn=N&function_id=OT_CHECK_IN&function_name=Check-In&called_from=BOOKING";
			// give the Label name on the GUI screen
			var names=new Array(theatre,surgeon);
			if(checkFields_booking( fields, names, messageFrame,qry_str)){
					submitflag=true;
			}else{
					submitflag=false;
			}
if(submitflag==true)
{
	if(asstSurg1!="" && asstSurg2!="" && asstSurg1==asstSurg2)
	{
		var msg = trimString(getMessage("APP-OT0189","OT"));
						submitflag=false;
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
	}else
	{
		submitflag=true;
	}
}
 }
		if(called_from=="OT_MENU"){ // means it is called from OT Menu.
			// To check the Mandatory columns
				//var fields= new Array( formObj.surgery_date, formObj.surgery_type, formObj.patient_class,
			var fields= new Array( doc.surgery_date, doc.surgery_type, doc.patient_class,
				//formObj.encounter_id,formObj.patient_id,formObj.surgeon_code,formObj.speciality_code,formObj.oper_room_code);
					doc.encounter_id,doc.patient_id,doc.surgeon_code,doc.speciality_code,doc.oper_room_code);
					// give the Label name on the GUI screen
				//var names=new Array(surgeryDate,surgeryType,encountertype,encounterid,patientId, operatingSpeciality,theatre);
				var names=new Array(surgeryDate,surgeryType,encountertype,encounterid,patientId, surgeon,operatingSpeciality,theatre);
				//Added by Sanjay for Anaesthesia Required Checkbox against IN032063 STARTS here
				if (doc.anaes_review.checked) doc.anaes_review1.value = 'Y';
				else doc.anaes_review1.value = 'N';
				var Anaesthetia_code = doc.anaesthesia_code.value;
				//Added by Sanjay for Anaesthesia Required Checkbox against IN032063 ENDS here
				//Function called to check whether all mandatory values are entered by the user
				if(checkFields( fields, names, messageFrame)){
					submitflag=true;
				}else{
					submitflag=false;
				}
				if(submitflag==true){
					//check the dtls length
					var len= checkDtlRecords();
					if(len==0){
						var msg = trimString(getMessage("MIN_ONE_DETAIL_REQUIRED","common"));//"AtLeast one Detail Record is needed to commit"
						submitflag=false;
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
					}else
						submitflag=true;
				}

				if(submitflag==true){
					if(checkOperations())
						  submitflag=true;
					else{
						  submitflag=false;
						  var message = trimString(getMessage("MIN_ONE_OPER_FOR_SPECIALITY","OT")); //"operation code must match with speciality"
						  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
						}
				}
		}
		
		//Added Against PMG2016-KDAH-CRF-0001 start
		if(submitflag==true && multi_check_in_yn=="N"){
		var check_in_date_time=doc.check_in_time.value;
		var oper_room_code=doc.oper_room_code.value;
		var facility_id=doc.facility_id.value;		
		var isOTVaccant=isOTAvailable(check_in_date_time,oper_room_code,facility_id,'');
		
		if(isOTVaccant==1){			
			if(called_from=="OT_MENU"){			
				submitflag=false;
			}
			else{			
				submitflag=false;
			}			
		}		
		
		if(submitflag==false){		
			var msg=getMessage("APP-OT0238","OT");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		}
		}
		//Added Against PMG2016-KDAH-CRF-0001 ends
		
		if(submitflag==true){
			var msg = trimString(getMessage("RECORD_INSERTED","SM"));
			//var formObj_1=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
			var formObj_1=document.getElementById("PreOperHdr");
			var all_form_fields= new Array(document.getElementById("surgery_date"),document.getElementById("surgery_type"), document.getElementById("order_id"),document.getElementById("booking_no"),document.getElementById("waitlist_no"),document.getElementById("patient_class"),
					document.getElementById("encounter_id"), document.getElementById("patient_id"), document.getElementById("speciality_code"),document.getElementById("surgeon_code"));
			if( called_from=="OT_SLATE" || called_from=="BOOKING" )
			{
				if(alreadyCheckedIn(formObj.patient_id.value)==true)
				{
					//PMG MOD-24 Start
					/*
					if(window.confirm(getMessage("APP-OT0077","OT"))==false){
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
						return;
					}else{*///PMG MOD-24
						AllSpecialityCodes();
						retVal = formApply(formObj,OT_CONTROLLER );
						retVal=trimString(retVal);
						eval(retVal);
					//}PMG MOD-24
				}
				else
				{
					 AllSpecialityCodes();
				 	 retVal = formApply(formObj,OT_CONTROLLER );
				}
			}
			else
			{
				AllSpecialityCodes();
				retVal = formApply(formObj,OT_CONTROLLER );
			}
			if(called_from=="OT_SLATE")
			{
				eval(retVal);
				window.returnValue="RECORD_INSERTED";
				if(flag==1){
					alert(getMessage("RECORD_INSERTED","SM"));
				}else{
					alert(message1);
				}
				window.close();
			}
			else
			{
			
			
				//var formObj1 = document.frames.f_query_add_mod.ChkListRecordFrame.document.forms[0];//55460
				var formObj1 = document.OTCheckinForm;//55460
				var params = formObj1.params.value;
				eval(retVal);
				if(flag==1){
					msg=getMessage("RECORD_INSERTED","SM");
					//55460
					//window.close();
					//window.returnValue="RECORD_INSERTED";
					//55460
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;  //IN050467 & 50700
					//setTimeout("pendingOrderToolbarLoad()", 1000);//[IN:052732]//55460
				}else{
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message1;
				}
				f_query_add_mod.document.location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+params;
			}
		}
	}

}
//[IN:052732]
function pendingOrderToolbarLoad()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	commontoolbarFrame.document.forms[0].reset.disabled=true;
}

//function added by Sanjay for showing mandatory symbol for Anesthesia when Anesthesia Review Required checkbox is Checked against IN032063
/*
function checkAnesReq(obj){
	//var formObj=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	if(obj.checked){
		document.getElementById("anes_check").style.visibility='visible'
	}else{
		document.getElementById("anes_check").style.visibility='hidden'
	}
}
*/

function AllSpecialityCodes(){
	var all_speciality_code="#";
	//var formObjHdr=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	var formObjHdr=document.getElementById("PreOperHdr");
	//var called_from = formObjHdr.called_from.value;
	var called_from = f_query_add_mod.ChkListRecordFrame.document.getElementById("called_from").value;
	if(called_from=="OT_MENU"){
		//var formObjDtl=document.frames.f_query_add_mod.ChkListDetailFrame.RecordFrame.document.RecordOperationForm;
		var formObjDtl=document.getElementById("RecordOperationForm");
	}else{
		//var formObjDtl=document.frames.f_query_add_mod.ChkListDetailFrame.DetailFrame.document.OperationDetail;
		var formObjDtl = document.getElementById("OperationDetail");
	}
	//var speciality_code=trimString(formObjDtl.collect_speciality_code.value);
	var speciality_code=trimString(f_query_add_mod.ChkListDetailFrame.RecordFrame.document.getElementById("collect_speciality_code").value);
	var arr = speciality_code.split(",");
	for(var jj=0;jj<arr.length;jj++){
		if(all_speciality_code.indexOf(arr[jj])==-1 && arr[jj]!="")
			all_speciality_code+=arr[jj]+"#";
		}
	//formObjHdr.all_speciality_code.value=all_speciality_code;
	f_query_add_mod.ChkListRecordFrame.document.getElementById("all_speciality_code").value=all_speciality_code;
}
//Function created for clearing the description value.....
function clearDescValue(){
	var formObj = document.forms[0];
	var oper_code=formObj.operation_code.value;
	if(oper_code=="" || oper_code==null){
	formObj.operation_desc.value="";
	}
}
//function added by Sanjay to Clear the Surgeon Code when Surgeon Description is null
function clearSurgeon_Code(Obj){
	var formObj = document.forms[0];
	var SURGEON_DESC=Obj.value;
	if(SURGEON_DESC=="" || SURGEON_DESC==null || SURGEON_DESC=="null" || SURGEON_DESC=="undefined")	{
		formObj.surgeon_code.value="";
	}
}
//Function added by Sanjay to clear the Speciality code when Speciality Description is null
function clearSpeciality_Code(Obj){
	var formObj = document.forms[0];
	var SPECIALITY_DESC=Obj.value;
	if(SPECIALITY_DESC=="" || SPECIALITY_DESC==null || SPECIALITY_DESC=="null" || SPECIALITY_DESC=="undefined")	{
		formObj.speciality_code.value="";
		formObj.anaes_review.checked = false;
		//formObj.anes_check.style.visibility='hidden';
		formObj.anaes_review.disabled = true;
	}
}
//Function added by Sanjay to clear the Operation Room Code when Theatre Description is null
function clearOper_Room_Code(Obj){
	var formObj = document.forms[0];
	var theatre_desc=Obj.value;
	if(theatre_desc=="" || theatre_desc==null || theatre_desc=="null" || theatre_desc=="undefined")	{
		formObj.oper_room_code.value="";
	}
}

function clearAnaesthesia_Code(Obj){
	var formObj = document.forms[0];
	var ANAESTHESIA_DESC=Obj.value;
	if(ANAESTHESIA_DESC=="" || ANAESTHESIA_DESC==null || ANAESTHESIA_DESC=="null" || ANAESTHESIA_DESC=="undefined")	{
		formObj.anaesthesia_code.value="";
	}
}

function callCatalogCode(oper_code){
	var formObj=document.forms[0];
	var locale = formObj.locale.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=callCatalogCode&oper_code="+oper_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	formObj.catalog_code.value=retVal;
}

async function searchOperations(){
	var dialogTop  = "10";
	var dialogHeight = "60vh";
	var dialogWidth  = "60vw"//window.screen.availWidth;
	var arguments = "";
	var formObj = document.forms[0];
	var locale = document.forms[0].locale.value;
	var oper_code=formObj.operation_code.value;
	if(oper_code=="" && oper_code==null){
	formObj.operation_desc.value="";
	}
//	var column_sizes = escape("40%,20%,10%,10%");
	/**Define the following for the generic lookup
	 *
	 * 1. Column Size
	 * 2. Column Description
	 * 3. columnName_SQL incase of sqls
	 * 4.
	**/
	var column_sizes = escape("20%, 20%, 20%, 20% ");

	var column_descriptions = getLabel('Common.description.label','common') + ',' +
							  getLabel('Common.code.label','common') + ',' +
							  getLabel('eOT.SideApplicable.Label','OT') + ',' +
							  getLabel('Common.speciality.label','common') 	;
	column_descriptions = encodeURIComponent(column_descriptions);
	//Added for CRF 012 & CRF-199
	var sql=escape("SELECT LONG_DESC SHORT_DESC,OPER_CODE OPER_CODE, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG, (SPECIALITY_CODE || ' - ' ||  " +
			"(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW VW WHERE VW.SPECIALITY_CODE =  OPER.SPECIALITY_CODE AND  LANGUAGE_ID='" + locale + "')) SPECIALITY_CODE " +
					" FROM OT_OPER_MAST_LANG_VW OPER WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='" + locale + "'");
	//Added for CRF 012
	var SPECIALITY_CODE_SQL = escape("SELECT B.SPECIALITY_CODE SPECIALITY_CODE, A.SHORT_DESC SHORT_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B " +
			"WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X')= 'E' AND NVL(B.STATUS,'E') != 'D' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2");
	var title=getLabel("Common.operation.label","common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";

	//  added on 11/10/2007 by Muealee
	var param = "title=" + title + "&column_sizes=" + column_sizes + "&column_descriptions=" + column_descriptions +
				"&sql=" + sql + "&search_criteria=" + formObj.operation_code.value + "&search_text=" + formObj.operation_code.value +
				"&SPECIALITY_CODE_SQL=" + SPECIALITY_CODE_SQL+"&called_from=CheckIn";
	// end of the param

	retVal=await window.showModalDialog1("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null)
	{
			var arr = retVal.split('::');
			document.forms[0].operation_desc.value=arr[0];
			document.forms[0].operation_code.value=arr[1];
			document.forms[0].side_applicable_yn.value=arr[2];
			callCatalogCode(arr[1]);
			if(arr[2]!='Y'){
					formObj.side_applicable.value='N';
					formObj.side_applicable.disabled=true;
					formObj.imageflag.src="../../eCommon/images/Blank1.gif";
			}else{
			  formObj.side_applicable.value='N';
			  formObj.side_applicable.disabled=false;
			  formObj.imageflag.src="../../eCommon/images/mandatory.gif";
			}
			document.forms[0].collect_speciality_code.value+=arr[3]+",";
		}else{
			document.forms[0].operation_code.value='';
			document.forms[0].operation_desc.value='';
			document.forms[0].side_applicable.value='';
			document.forms[0].collect_speciality_code.value='';
		}
	//}
}

async function searchsurgeon(obj,target){
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	tit=getLabel("Common.Surgeon.label","common");
	//var sql="select physician_id code, short_name description from sy_physician_mast where facility_id = '"+facility_id+"' and pract_type in ('MD','SG')and nvl(status,'x') <> 's'  and upper(physician_id) like upper(?) and upper(short_name) like upper(?) order by 2";
//	var sql="SELECT SHORT_NAME DESCRIPTION , PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2"

//code altered by rajesh for including role_type on 09/07/08
//Query has been changed by DhanasekarV agianist IN026702 on 1/03/2011
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND NVL(A.EFF_STATUS,'E') = 'E' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1"
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
		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}

	}else{
		target.value='';
		obj.value='';
	}
}

async function searchAnesthetist(obj,target){
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Anaesthetist.label","common");
	//modifieed by rajesh for language id issue :732

	//var sql="SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+FACILITY_ID+"' AND PRACT_TYPE IN ('AN')AND NVL(STATUS,'X') <> 'S'  AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?) ORDER BY 2";
	//var sql="SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND  PRACT_TYPE IN ('AN') AND  NVL(EFF_STATUS,'X') <> 'S' AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";

	//Code altered by rajesh for including role_type on 09/07/08
	//Query has been changed by DhanasekarV agianist IN026702 on 1/03/2011
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND NVL(A.EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'MA') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

	argumentArray[0] = sql;
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
		obj.value=arr[0];
		target.value=arr[1];
	}else{
		target.value='';
		obj.value='';
	}
}

async function searchAnaesthesia(obj,target){
	var locale = document.forms[0].locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Anaesthesia.label","common");
	var sql="Select anaesthesia_code code, short_desc description from AM_ANAESTHESIA_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND nvl(eff_status,'X') = 'E'  and upper(anaesthesia_code) like upper(?) and upper(short_desc) like upper(?) order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[0];
		target.value=arr[1];
	}else{
		target.value='';
		obj.value='';
	}
}

async function searchSpecialty(obj,target){
	var locale = document.forms[0].locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.speciality.label","common");
	//var sql="select a.short_desc description  , b.speciality_code code from am_speciality_lang_vw a, ot_specialities b where a.LANGUAGE_ID='"+locale+"' AND nvl(eff_status,'X')= 'E'and a.speciality_code = b.speciality_code  and upper(a.short_desc) like upper(?) and upper(b.speciality_code) like upper(?) order by 2";
	//Below Query is modified by muthuN against 36326 on 1/9/2013 -- and b.status != 'D'
/* If Status is Disabled that speciality should not get displayed into the CheckIn Operating Specialty Screen */
	var sql="select a.short_desc description  , b.speciality_code code from am_speciality_lang_vw a, ot_specialities b where a.LANGUAGE_ID='"+locale+"' AND nvl(a.eff_status,'X')= 'E' and nvl(b.STATUS,'E')!= 'D' and a.speciality_code = b.speciality_code  and upper(a.short_desc) like upper(?) and upper(b.speciality_code) like upper(?) order by 2";
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
		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}
	}else{
		target.value='';
		obj.value='';
	}
}
//Function added by Sanjay for Anesthesia Required Checkbox against IN032063
function anesthesiaRequiredYN(){

	var SPECIALITY_CODE = document.forms[0].speciality_code.value;
	if (SPECIALITY_CODE.length > 0) {
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=anes_req_YN&SPECIALITY_CODE="+SPECIALITY_CODE,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if (retVal == 'Y'){
			//document.forms[0].anaes_review.checked = false;
			document.forms[0].anaes_review.checked = true;//CRF-20049
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
async function searchWard(obj,target){
	var locale = document.forms[0].locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.nursingUnit.label","common");
	// Code altered by Selvam for PHASE 3 Delivery
//	var	sql="Select nursing_unit_code code,short_desc description from IP_NURSING_UNIT_LANG_VW where LANGUAGE_ID='"+locale+"' AND nvl(eff_status,'E')='E' and  upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	var	sql="SELECT NURSING_UNIT_CODE CODE,LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E')='E' AND  UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[0];
		target.value=arr[1];
	}else{
		target.value='';
		obj.value='';
	}
}

function setAssignValue(dat){
	return dat;
}

function alreadyCheckedIn(patientid)
{
//var sql="SELECT 'X' FROM OT_POST_OPER_HDR WHERE PATIENT_ID = '"+patientid+"' AND OPER_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59','DD/MM/YYYY HH24:MI') AND OPER_STATUS NOT IN ('90')";
//QUERY ALTERED BY RAJESH FOR IN017896 ON 51/01/10
var sql="SELECT 'X' FROM OT_POST_OPER_HDR WHERE PATIENT_ID = '"+patientid+"' AND OPER_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59','DD/MM/YYYY HH24:MI') AND OPER_STATUS NOT IN ('90','99','65','70')";

var param="sql="+sql;

var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
var xmlStr="<root></root>";
xmlDoc.loadXML(xmlStr);
xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
xmlHttp.send(xmlDoc);
var resTxt=xmlHttp.responseText;
resTxt=eval(resTxt);
if(resTxt=='X') return true;
return false;

}

function checkFitOperation( facility_id,oper_room_code,theatre_desc,oper_code,oper_desc ){
	if(facility_id!="" && oper_room_code!=""){
		var sql="SELECT 'X' FROM OT_OPER_UNFIT_FOR_ROOM WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_ROOM_CODE = '"+oper_room_code+"' AND OPER_CODE = '"+oper_code+"'";
		var param="sql="+sql+"&flag=MED_SER";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt=trimString(xmlHttp.responseText);
		//resTxt=eval(resTxt);
		if(resTxt=='X'){
			//alert("This "+theatre_desc.toUpperCase()+" cannot have the facility \n to perform this "+oper_desc.toUpperCase()+" operation...");
			 var msg = getMessage("APP-OT0053","OT");
			  var msgArray = msg.split("#");
		     alert(msgArray[0]+theatre_desc.toUpperCase()+msgArray[1]);
			return false;
		}else
			return true;
	}else{
		//alert("Select the theatre before recording operations..");
		 alert(getMessage("APP-OT0054","OT"));
		 return false;
	}
}


function trimString(sInString){
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


async function callPatientSearch()
{
	var patient_id = document.PreOperHdr.patient_id;
	var patient_name = document.PreOperHdr.patient_name;
	var date_of_birth = document.PreOperHdr.date_of_birth;
	var sex	= document.PreOperHdr.sex;
	var patientclass = document.PreOperHdr.patient_class.value;
	var frmObj=document.PreOperHdr;
	frmObj.patient_name.value="";
	frmObj.sex.value="";
	frmObj.date_of_birth.value="";
	frmObj.encounter_id.value="";
	frmObj.episode_id.value="";
	frmObj.visit_id.value="";
	frmObj.episode_type.value="";
	frmObj.nursing_unit.value="";
	frmObj.admitting_specialty.value="";
	frmObj.source_type.value="";
	frmObj.source_code.value="";
	frmObj.operation_status.value="";
	var return_value =	"";
	var duplPatientIdSearchFlag = true;//PMG2014-CRF-0024
	return_value	=(patient_id.value.length>0)?patient_id.value:await PatientSearch(null,null,null,null,null,null,null,null,null,null,null,patientclass);
	if(return_value==null)
		return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal=="INVALID_PATIENT")
	{
		alert(getMessage("INVALID_PATIENT","MP"));
		patient_id.value="";
		patient_name.value="";
		date_of_birth.value="";
		sex.value = "";
		patient_id.focus();
		return
	}

	//PMG2014-CRF-0024 Start
	xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=duplPatientIdSearch&patient_id="+return_value+"&facilityId="+frmObj.facility_id.value,false);
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
		if(!duplPatientIdSearchFlag)
			patient_id.value = '';
	}
	// PMG2014-CRF-0024 end
	if(retVal != "" && duplPatientIdSearchFlag) //PMG2014-CRF-0024
	{
		   	var retVal_arr = retVal.split("##");
		    patient_id.value		=return_value;
			patient_name.value		= retVal_arr[0];
			date_of_birth.value 	= retVal_arr[1];
			sex.value = (retVal_arr[2]=="MALE")?"M":(retVal_arr[2]=="FEMALE")?"F":"U";
			var obj = document.PreOperHdr.patient_class.value;
			var let = await callEncounterSearch();
			if (typeof(preOperDiagArray) != 'undefined')
			{
				showPreOperDiagLink();
			}
	}
}

//Newly created by rajesh on 30/05/2008

async function callEncounterSearch(){
	var obj = document.PreOperHdr.patient_class;
	var patient_id = document.PreOperHdr.patient_id.value;
	if(patient_id==null || patient_id==""){
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.patientId.label","Common"));
		alert(msg1);
		return false;
	}
	var patient_class = document.PreOperHdr.patient_class.value;
	var patient_class_desc  = encodeURIComponent(document.PreOperHdr.patient_class.options[obj.selectedIndex].text,"UTF-8");
	var encounter_id = document.PreOperHdr.encounter_id;
	var episode_id = document.PreOperHdr.episode_id;
	var visit_id = document.PreOperHdr.visit_id;
	var episode_type= document.PreOperHdr.episode_type;
	var facility_id =  document.PreOperHdr.facility_id.value;
	//Query commented against 39113 on 12-04-2013
	//var sql=escape("SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND PATIENT_CLASS=? AND FACILITY_ID='"+facility_id+"' AND DISCHARGE_DATE_TIME IS NULL"); //MODIFIED BY DHANASEKARV AGAINST PMG20089-CRF-0859
	/*Below query changed against 39113 on 12-04-2013 by MuthuN */
	var sql=escape("SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?) EPISODE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID=? AND PATIENT_CLASS=? AND FACILITY_ID='"+facility_id+"' AND DISCHARGE_DATE_TIME IS NULL AND ((patient_class IN ('OP', 'EM') AND visit_status != '09') OR (patient_class IN ('IP', 'DC') AND adt_status != '09'))");
	var dir_param = "sql="+sql+"&patient_class="+patient_class+"&patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTGeneralEncounterSearchResults.jsp?"+dir_param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var retVal_arr = retVal.split("::");
// Modified by DhanasekarV
//	alert(retVal_arr[0]);
	if(retVal_arr[0]=="1"){
		encounter_id.value		= retVal_arr[1];
		//patient_class.value 	= retVal_arr[2];
		episode_id.value 	= retVal_arr[3];
		visit_id.value 	= retVal_arr[4];
		episode_type.value 	= retVal_arr[5];
		//getPatientDetails(patient_id);
		getPatientDetails(retVal_arr[1],patient_class);
}else{
		// encounter_id,patient_class,episode_id,op_episode_visit_num
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "40";
		var arguments = "";
		var features  = ";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		//return_value=window.showModalDialog("../../eOT/jsp/OTEncounterPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc+"&patient_id="+patient_id,arguments,features);
		return_value=await top.window.showModalDialog("../../eOT/jsp/OTEncounterPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc+"&patient_id="+patient_id+"&tabID=ChkIn",arguments,features); //Modified Against SS-SCF-0796
		if(return_value!=null){
			var retVal_arr = return_value.split("##");
				encounter_id.value		= retVal_arr[0];
				//patient_class.value 	= retVal_arr[1];
				episode_id.value 	= retVal_arr[2];
				visit_id.value 	= retVal_arr[3];
				episode_type.value 	= retVal_arr[4];
				//getPatientDetails(patient_id);
				getPatientDetails(retVal_arr[0],patient_class);
		}
	}
}


/*function callPatientSearch(){
	var surgery_type = document.PreOperHdr.surgery_type.value;
	var patient_class = document.PreOperHdr.patient_class.value;
	var obj = document.PreOperHdr.patient_class;
	var patient_class_desc  = document.PreOperHdr.patient_class.options[obj.selectedIndex].text;
	var patient_id=	document.PreOperHdr.patient_id;
	var episode_id = document.PreOperHdr.episode_id;
	var called_from	=document.PreOperHdr.called_from.value;
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	return_value=window.showModalDialog("../../eOT/jsp/OTPatientSearchFrames.jsp?"+"patient_class="+patient_class+"&patient_class_desc="+patient_class_desc,arguments,features);
	if(return_value!=null && return_value!="undefined" && return_value!=""){
		//patient_id+"##"+patient_name+"##"+episode_type+"##"+encounter_id+"##"+episode_id+"##"+date_of_birth+"##"+sex;
		var arr=return_value.split("##");
		patient_id.value=arr[0];
		episode_id.value=arr[4];
		var param = 'patient_id='+arr[0]+'&called_from='+called_from+"&surgery_type="+surgery_type+"&episode_id="+arr[4];
		parent.frames[0].location.href='../../eOT/jsp/PreOperChkListHdr.jsp?'+param;
		alert(document.forms[0].episode_id.value);
	}
}*/

/*
function callPatientSearch(){
	//var surgery_type = document.PreOperHdr.surgery_type.value;
	var patient_class = document.PreOperHdr.patient_class.value;
	var obj = document.PreOperHdr.patient_class;
	var patient_class_desc  = document.PreOperHdr.patient_class.options[obj.selectedIndex].text;
	var patient_id=	document.PreOperHdr.patient_id;
	var patient_name = document.PreOperHdr.patient_name;
	var encounter_id = document.PreOperHdr.encounter_id;
	var episode_id = document.PreOperHdr.episode_id;
	var episode_type= document.PreOperHdr.episode_type;
	var date_of_birth = document.PreOperHdr.date_of_birth;
	var sex	= document.PreOperHdr.sex;
	var visit_id = document.PreOperHdr.visit_id;
	//var called_from	=document.PreOperHdr.called_from.value;
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	return_value=window.showModalDialog("../../eOT/jsp/OTPatientSearchFrames.jsp?"+"patient_class="+encodeURIComponent(patient_class)+"&patient_class_desc="+encodeURIComponent(patient_class_desc),arguments,features);
	if(return_value!=null && return_value!="undefined" && return_value!=""){
	//patient_id+"##"+patient_name+"##"+episode_type+"##"+encounter_id+"##"+episode_id+"##"+date_of_birth+"##"+sex+"##"+visit_id;
		var arr=return_value.split("##");
		patient_id.value=arr[0];
		patient_name.value=arr[1];
		episode_type.value=arr[2];
		encounter_id.value=arr[3];
		episode_id.value=arr[4];
		date_of_birth.value=arr[5];
		if(arr[6]=="Male"){
			sex.value = "M";
		}else if(arr[6]=="Female"){
			sex.value="F";
		}else{
			sex.value="U";
		}
		visit_id.value = arr[7];
		getPatientDetails(arr[0]);
	}
}
*/
function AssignDBValue(){
	var obj = document.PreOperHdr.sex
	obj.value = obj.DB_VALUE

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=Verify_check_list_clear_value",false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal!="" ){

	}
}

async function funsubmitCheckInDtls(checklists){
	var formObj = document.PreOperHdr;
	var called_from = formObj.called_from.value;
	var formObj1 =top.frames[2].document.forms[0];
	if(formObj1==null){
		formObj1 = formObj;
	}
	var params = formObj1.params.value;
	//commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
	var order_id = formObj.order_id.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;		
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; 
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";
	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	var old_checklist_user_id = (formObj.old_checklist_user_id.value).toUpperCase();
	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	/* Modified by Muthukumar against IN:027756 & SRR20056-SCF-7669 on 4/8/2011 */
	if(called_from !='BOOKING' && old_checklist_user_id!="" && old_checklist_user_id!="null" && old_checklist_user_id!="NULL"){
	/* Modified by Muthukumar against IN:027756 & SRR20056-SCF-7669 on 4/8/2011 */
		if(slate_user_id.toUpperCase()!=old_checklist_user_id.toUpperCase()){
			disable_checklist_fields = "disabled";
			access="NNNNN";
		}
	}
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled";
		access="NNNNN";
	//access="NYNNY";
	}
	var booking_num = formObj.booking_no.value;
	/*if(booking_num!=null && booking_num!="null" && booking_num!="" && booking_num!="NULL"){
		order_id = "";
		oper_num = "";
	}else if(order_id!=null && order_id!="null" && order_id!="" && order_id!="NULL"){
		booking_num = "";
		oper_num = "";
	} */
	var from_pending_orders = formObj.called_from.value;
	if(from_pending_orders=="BOOKING"){ // Checkin called from pending orders.
		slate_user_id = (formObj.login_user_id.value).toUpperCase();
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=verifychecklist_call&speciality_code="+formObj.speciality_code.value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal=="true" ){
			var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var function_string = "&function_id=OT_CHECK_LIST&function_name=Verify Checklist";
	var db_param = db_param_1 + function_string;
	var url_desc = "VerifyCheckListMain.jsp";
	var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage=C20&pre_or_post=P&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+formObj.no_of_verifications.value+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+booking_num+"&oper_num="+"&disable_checklist_fields="+disable_checklist_fields+"&speciality_code="+formObj.speciality_code.value+"&apply_flag=Y";
	
	var retVal;
	var dialogHeight = "40" ;
	var dialogWidth  = "52" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
	if(retVal==null){

		/*parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";*/


	}else if(retVal!="null" && retVal!="" && retVal!="Y"){
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+retVal;
	}else if(retVal!="null" && retVal!="" && retVal=="Y"){
		formObj.checklist_completed_yn.value = "Y";
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;//56016
	}else 	if(called_from=='BOOKING')
	 {// retVal!="Y";
	 var qry_str="menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_CHECK_IN&function_name=Check-In&function_type=F&access=YYNNY&desktopFlag=N&facility_id=HS&called_from=BOOKING&booking_num=null&slate_user_id=null";
	 parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+qry_str;
	 //parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
	 setTimeout("loadToolBar2()",200);
	 }else 	if(called_from=='OT_SLATE')
	 {// retVal!="Y";
	 var qrystr="module_id=OT&function_type=F&menu_id=26&access=NYNNN&home_required_yn=N&function_id=OT_CHECK_IN&function_name=Check-In&called_from=OT_SLATE";
      parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?"+qrystr;
	 //parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
	setTimeout("loadToolBar2()",200);

	 }
	 else
		 {
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	}else
	{
		 var msg = getMessage("APP-OT0170","OT");
		 alert(msg);
		
	}
loadToolBar(called_from); //Modified by Muthukumar against IN028643 on 30/08/2011
}

function funAssingnValues(obj){
  var str = obj.value;
  var arr = new Array();
  arr=str.split('::')
  document.forms[0].nature_code.value=arr[0];
  document.forms[0].nature_type.value=arr[1];
}

function checkDuplicateCode(){
	var mode = document.forms[0].mode.value;
	var formObj = parent.DetailFrame.document.forms[0];
	var codeDetailFrame =  formObj.code.value;
	var codeRecordFrame = document.forms[0].operation_code.value;
	var k = codeDetailFrame.indexOf(codeRecordFrame);
	if(chkEmpty()){
		 if(k>=0){
			var mesg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));//"Operation is already selected...";
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+mesg;
			return k;
		}
		return 1;
	}
}

/*function chkEmpty(){
	var formObj = document.forms[0];
	var fields = new Array(formObj.operation_code);
	var names = new Array('Operation');
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}*/

function chkEmpty(){
	var operation=getLabel("Common.operation.label","common");
	var sideApplicable=getLabel("eOT.SideApplicable.Label","OT");
	var formObj = document.forms[0];
	var side_applicable_yn = formObj.side_applicable_yn.value;
	if(side_applicable_yn=='N'){
		var fields = new Array(formObj.operation_code);
		var names = new Array(operation);
	}else{
		var fields = new Array(formObj.operation_code,formObj.side_applicable);
		var names = new Array(operation,sideApplicable);
	 }
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function checkLimit(field, limit){
	 if (field.value.length > limit){
		    //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		    // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

function resetFields(){
	var frmObj = document.forms[0];
	frmObj.operation_code.value='';
	frmObj.operation_desc.value='';
	frmObj.side_applicable.value='';
	frmObj.remarks.value='';
	frmObj.mode.value='I';
	frmObj.side_applicable_yn.value='';
	frmObj.side_applicable.disabled=false;
	frmObj.OperationLookUp.disabled=false;
	frmObj.OperationLookUp.focus();
	parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="
}

function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.operation_code.value=arr[0];
	frmObj.operation_desc.value=arr[1];
	frmObj.side_applicable.value=arr[2]
	frmObj.remarks.value=arr[3];
	frmObj.recId.value=arr[4];
	frmObj.mode.value=arr[5];
	frmObj.side_applicable_yn.value=arr[6];
	if(arr[6]=="N")
		frmObj.side_applicable.disabled=true;
	else
		frmObj.side_applicable.disabled=false;
	frmObj.OperationLookUp.disabled=true;
}

function cancelOperationDtls()
{
	var formObj = document.RecordOperationForm;
	var called_from = formObj.called_from.value;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var bill_flag=formObj.bill_flag.value;
	var xmlStr ="<root><SEARCH ";

	xmlStr += "operation_code=\""+  checkSpl( document.getElementById("operation_code").value ) + "\" ";
	xmlStr += "operation_desc=\""+  checkSpl( document.getElementById("operation_desc").value ) + "\" ";
	xmlStr += "side_applicable=\""+  checkSpl( document.getElementById("side_applicable").value ) + "\" ";
	xmlStr += " remarks=\""+  checkSpl( document.getElementById("remarks").value ) + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mode=document.getElementById("mode").value;
	var recId=document.getElementById("recId").value;
	xmlHttp.open("POST","CheckInValidation.jsp?func_mode=cancelOperationDtls&mode="+mode+'&recId='+recId,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	parent.DetailFrame.location.href='../../eOT/jsp/ChkListOperationDtls.jsp?called_from='+called_from+'&bill_flag='+bill_flag;
	resetFields();
}

function funCheckDeletion(){
	var mode = document.forms[0].mode.value;
	if(mode=='I'){
		document.forms[0].operation_code.value='';
		document.forms[0].operation_desc.value='';
		document.forms[0].side_applicable.value='';
		document.forms[0].remarks.value='';
	} else {
		cancelOperationDtls();
		document.forms[0].operation_code.value='';
		document.forms[0].operation_desc.value='';
		document.forms[0].side_applicable.value='';
		document.forms[0].remarks.value='';
   }
 }

function callRecordfunction(){
	var messageFrame=parent.parent.parent.messageFrame;
	var surgeryDate=getLabel("eOT.SurgeryDate.Label","OT");
	var encounterid=getLabel("Common.encounterid.label","common");
	var patientId=getLabel("Common.patientId.label","common");
	var patientclass=getLabel("Common.patientclass.label","common");
	//var surgeon=getLabel("Common.Surgeon.label","common");
	var flag=false;
	var HdrFormObj = parent.parent.frames[0].document.forms[0];
	var patient_id = HdrFormObj.patient_id.value;
	var encounter_id = HdrFormObj.encounter_id.value;
	var surgeon_code = HdrFormObj.surgeon_code.value;
	var patient_class = HdrFormObj.patient_class.value;
	var oper_date = HdrFormObj.surgery_date.value;
	var formObj = document.forms[0];
	var mode = formObj.mode.value;
	//var formObjHdr=document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	var formObjHdr = parent.parent.ChkListRecordFrame.PreOperHdr;
	var facility_id = formObjHdr.facility_id.value;
	var oper_room_code=formObjHdr.oper_room_code.value;
	var theatre_desc = formObjHdr.theatre_desc.value;
    var oper_code = formObj.operation_code.value;
	var oper_desc = formObj.operation_desc.value;
	oper_remarks=formObj.remarks.value;
	if(mode=='I'){
		var fields= new Array( HdrFormObj.surgery_date, HdrFormObj.patient_class,HdrFormObj.patient_id,HdrFormObj.encounter_id);
        var names=new Array(surgeryDate,patientclass,patientId,encounterid);
          if(checkFields( fields, names, messageFrame)){
				  flag=true;
		  }else{
				  flag=false;
			   }
	     if(flag==true)
		{
		var p = checkDuplicateCode();

		if(p==1 && checkFitOperation( facility_id, oper_room_code,theatre_desc, oper_code,oper_desc ) )
			recordOperationDtls();
		}
		return;
	}
	recordOperationDtls();
}

function recordOperationDtls(){
	var HdrFormObj = parent.parent.frames[0].document.forms[0];
	var patient_id = HdrFormObj.patient_id.value;
	var encounter_id = HdrFormObj.encounter_id.value;
	var surgeon_code = HdrFormObj.surgeon_code.value;
	var patient_class = HdrFormObj.patient_class.value;
	var oper_date = HdrFormObj.surgery_date.value;
	var notapplicable=getLabel("Common.notapplicable.label","common");
	var formObj = document.RecordOperationForm;
	var desc =notapplicable;
	var obj = formObj.side_applicable;
	var called_from = formObj.called_from.value;
	var oper_code  = formObj.operation_code.value;
	var catalog_code  = formObj.catalog_code.value;
	var mode=document.getElementById("mode").value;
	var bill_flag=formObj.bill_flag.value;
// Added Against ML-MMOH-SCF-2510	
	var fpp_yn = "";
	var fpp_category = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=getFppList&oper_code="+oper_code;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal!=''){
	arr=retVal.split("::");
	fpp_yn = arr[0];
	fpp_category = arr[1];
	if(fpp_yn == 'N') fpp_category = 'N';
	}
 // Added Against ML-MMOH-SCF-2510 

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "order_catalog_code="+catalog_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=from_direct_booking&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal1 = trimString(xmlHttp.responseText);

	var panel_str="";
	var bill_str="";
if(retVal1== "Y")
		{
	if(mode=='I' && bill_flag=="true"){
	var retVal = callOrderLineCreation();
	var arr = retVal.split("@@");

	if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))
	{
		alert(getMessage("BL0639","BL"));
		resetFields();
		return false;
	}
	if(localTrimString(arr[2])!='')
	{
	var err_pat=localTrimString(arr[2]);
	alert(err_pat);
	resetFields();
	return false;
	}

	 panel_str=arr[0];
	 bill_str=arr[1];
	}

		}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "operation_code=\""+  checkSpl( document.getElementById("operation_code").value ) + "\" ";
	xmlStr += "operation_desc=\""+  checkSpl( document.getElementById("operation_desc").value ) + "\" ";
	xmlStr += "side_applicable=\""+  checkSpl( document.getElementById("side_applicable").value )+ "\" ";
	xmlStr += "patient_id=\""+patient_id+"\" ";
	if(document.getElementById("side_applicable").value=="")
		xmlStr+="side_applicable_desc=\""+desc+"\" ";
	else
	   xmlStr+="side_applicable_desc=\""+checkSpl( document.getElementById("side_applicable").options[obj.selectedIndex].text)+ "\" ";
	xmlStr += "side_applicable_yn=\""+  checkSpl( document.getElementById("side_applicable_yn").value )+ "\" ";
	xmlStr += " remarks=\""+  checkSpl( document.getElementById("remarks").value ) + "\" ";
	if(mode=='I' && bill_flag=="true")
	{
	xmlStr += " panel_str=\""+  checkSpl( panel_str ) + "\" ";
	xmlStr += " bill_str=\""+ checkSpl( bill_str )+ "\" ";
	xmlStr += " fpp_yn=\""+ checkSpl( fpp_yn )+ "\" ";// Added Against ML-MMOH-SCF-2510
	xmlStr += " fpp_category=\""+ checkSpl( fpp_category )+ "\" ";// Added Against ML-MMOH-SCF-2510
	}
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var recId=document.getElementById("recId").value;
	if(mode=='I')
	xmlHttp.open("POST","CheckInValidation.jsp?func_mode=recordOperationDtls&mode="+mode+'&recId='+recId,false);
	else if(mode=='U')
	xmlHttp.open("POST","CheckInValidation.jsp?func_mode=ReviseBillDtls&mode="+mode+'&recId='+recId,false);

	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	parent.DetailFrame.location.href='../../eOT/jsp/ChkListOperationDtls.jsp?called_from='+called_from+'&bill_flag='+bill_flag;
	resetFields();
}

function sendParams(index){
	var str = eval("document.forms[0].result"+index+".value");
	//var str = code+'::'+desc+'::'+sideapplicable+'::'+remarks+'::'+rowid+'::'+mode;
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

/*function openDialogWindow(strVal,obj){
	  var remarks = encodeURIComponent(obj.value);
	//var remarks = obj.value;
    window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
} */

function openDialogWindow(strVal,obj,remarks_size){
	var pre_oper_diag=trimString(obj.value);
	//var remarks = encodeURIComponent(pre_oper_diag);
	//Added utf for 25979 on 1/29/2011 by Anitha
	var remarks = encodeURIComponent(pre_oper_diag,"UTF-8");
	 var readOnlyYN="Y";

    window.showModalDialog('../../eOT/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks +'&readOnlyYN='+readOnlyYN+ '&size='+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
async function openDialogWindow1(strVal,obj,remarks_size){
	var readOnlyYN = "Y";
	var remarks = document.forms[0].diagnosis.value;
	var remarks_hid = document.forms[0].diagnosis.value;
	remarks = trimString(remarks);
	//remarks = encodeURIComponent(remarks);
	//Added utf for 25979 on 1/29/2011 by Anitha
	remarks = encodeURIComponent(remarks,"UTF-8");
	title =encodeURIComponent(strVal);
	//remarks = encodeURIComponent(remarks);
	var retVal = await window.showModalDialog("../../eOT/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&size="+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	//retVal = encodeURIComponent(retVal);
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X'
		document.forms[0].diagnosis.value = remarks_hid;
	}
	else{
		document.forms[0].diagnosis.value = retVal;
	}
}

//Added For PMG2016-KDAH-CRF-0001
async function searchTheatre(obj,target,multi_check_in_yn){
	var formObj = document.PreOperHdr;
	var locale = formObj.locale.value;
	var tcode = obj.value;
	var tdesc = target.value;
	var checked_in_date_time=formObj.checked_in_date_time.value;	
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Theatre.label","common");
	//var	sql="Select nursing_unit_code code,short_desc description from Ip_nursing_unit where nvl(eff_status,'E')='E' and  upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	//Added For PMG2016-KDAH-CRF-0001 starts
	var sql="";
	if(multi_check_in_yn=="Y"){
		sql="SELECT  OPER_ROOM_CODE code,SHORT_DESC description FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' and  upper(OPER_ROOM_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
	}else if(multi_check_in_yn=="N"){
		sql="SELECT  OPER_ROOM_CODE code,SHORT_DESC description FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' and  upper(OPER_ROOM_CODE) like upper(?) and upper(short_desc) like upper(?) and oper_room_code not in(select  oper_room_code from ot_post_oper_hdr where to_date(nvl('"+checked_in_date_time+"',TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI')), 'DD/MM/YYYY HH24:MI') between check_in_time and nvl(check_out_time,to_date(nvl('"+checked_in_date_time+"',TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI')), 'DD/MM/YYYY HH24:MI')) and trunc(check_in_time)=trunc(sysdate) and operating_facility_id='"+facility_id+"' AND oper_status != '99')  order by 2";
	}
	//Added For PMG2016-KDAH-CRF-0001 ends
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[0];
		target.value=arr[1];
		if (typeof(preOperDiagArray) != 'undefined')
		{
			showPreOperDiagLink();
		}
	}else{
		target.value='';
		obj.value='';
	}
}

/*function searchTheatre(){
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("40%,60%");
	var column_descriptions = escape("Description,Code");
	var facility_id = document.forms[0].facility_id.value;
	var theatre_code = document.forms[0].oper_room_code.value;
	var theatre_desc = document.forms[0].theatre_desc.value;
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, OPER_ROOM_CODE OPER_ROOM_CODE1 FROM OT_OPER_ROOM  WHERE OPERATING_FACILITY_ID = '"+facility_id+"'");
	var title=getLabel("Common.Theatre.label","common");
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].theatre_desc.value=arr[0];
		document.forms[0].oper_room_code.value=arr[1];
	}else{
		document.forms[0].theatre_desc.value=theatre_desc;
		document.forms[0].oper_room_code.value=theatre_code;

	}
}*/


async function openNewDialogWindow(strVal,obj,size,disable_flag)
{
	//get rettext, assign value to hidden field
	strVal=encodeURIComponent(strVal);
	var param='heading='+strVal+'&para='+escape(obj.value)+'&size='+size+"&disable_flag="+disable_flag;
	var retext= await window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param,window,"dialogHeight: 150px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'|| retext==''|| retext==null)
		retext=obj.value;
	else
		obj.value=retext;
}

async function openNewDialogWindow1(strVal,obj,size,disable_flag)
{
	var readOnlyYN = "N";
	var remarks = document.forms[0].diagnosis.value;
	var remarks_hid = document.forms[0].diagnosis.value;
	remarks = trimString(remarks);
	//remarks = encodeURIComponent(remarks);
	//Added utf for 25979 on 1/29/2011 by Anitha
	remarks = encodeURIComponent(remarks,"UTF-8");
	title =encodeURIComponent(strVal);
	//remarks = encodeURIComponent(remarks);
	var retVal =await window.showModalDialog("../../eOT/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&size="+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	//retVal = encodeURIComponent(retVal);
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X'
		document.forms[0].diagnosis.value = remarks_hid;
	}
	else{
		document.forms[0].diagnosis.value = retVal;
	}
}
function clearFlds(){
	 var formObj = document.forms[0];
	 formObj.encounter_id.value="";
	  formObj.nursing_unit.value="";
	 formObj.episode_id.value="";
	 formObj.admitting_specialty.value="";

}


function getSpltyDetails(){
	var formObj = document.forms[0];
	var patient_id=formObj.patient_id.value;
	//wardDesc+"::"+admitting_speciality_desc+"::"+source_type+"::"+source_code+"::"+operationStatus;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="PreOperChkListHdrTemp.jsp?patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var result = trimString(responseText);
	var arr = result.split("::");
	formObj.admitting_specialty.value=arr[1];
	formObj.operation_status.value=arr[4];
}

function getPatientDetails(encounter_id,patient_class){
	var formObj = document.forms[0];
	//wardDesc+"::"+admitting_speciality_desc+"::"+source_type+"::"+source_code+"::"+operationStatus;
	getSpltyDetails();//admitting_specialty & operation_status value is getting assingned.
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="TempEncounterLkup.jsp?encounter_id="+encounter_id+"&patient_class="+patient_class;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var result = trimString(responseText);
	var arr = result.split("@");
	//formObj.admitting_specialty.value=arr[1];
	formObj.source_type.value=(arr[0]=='E')?'C':arr[0];
	formObj.source_code.value=arr[1];
	formObj.nursing_unit.value=arr[2];
	//formObj.operation_status.value=arr[4];

}

function messageWindow(title, msg){
  var width="300";
  var height="125";
  var left = (screen.width/2) - width/2;
  var top = (screen.height/2) - height/2;
  var styleStr = 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbar=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+',top='+top+',screenX='+left+',screenY='+top;
  var msgWindow = window.open("","msgWindow", styleStr);
  var head = '<head><title>'+title+'</title></head>';
  var body = '<center>'+msg+'<br><p><form><input type="button" value="   OK   " onClick="self.close()"></form>';
  msgWindow.document.write(head + body);
}

	function searchAsstSurgeon(obj,target){
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var formObj=document.forms[0];
		var locale = formObj.locale.value;
		var facility_id = formObj.facility_id.value;
		var splty_code = formObj.operating_speciality_code.value;

	//	sql  = "SELECT PRACTITIONER_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND ( (PRIMARY_SPECIALITY_CODE = '"+splty_code+"') OR (PRACTITIONER_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID ='"+facility_id+"'  AND SPECIALITY_CODE = '"+splty_code+"'))) AND upper(PRACTITIONER_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2";

//Code altered by rajesh for including role_type on 09/07/08

	var sql  = "SELECT practitioner_id CODE, practitioner_name DESCRIPTION FROM am_practitioner_lang_vw a WHERE a.language_id = '"+locale+"' AND a.eff_status = 'E' AND A.PRACT_TYPE IN (SELECT B.PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE B.ROLE_TYPE ='AS') AND ((primary_speciality_code = '"+splty_code+"') OR (practitioner_id IN (SELECT practitioner_id FROM am_pract_specialities WHERE facility_id = '"+facility_id+"' AND speciality_code = '"+splty_code+"'))) AND upper(PRACTITIONER_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) order by 2 "; // Modified for SS-SCF-0725 [IN:048818]
	//var sql  = "SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(EFF_STATUS,'X') <> 'S'  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		returnedValues = CommonLookup(getLabel("eOT.AsstSurgeon.Label","OT"),argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			target.value = returnedValues[0];
			obj.value = returnedValues[1];
		}else{
			target.value = "";
			obj.value = "";
		}
}
function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading space
  //return sInString.replace( /\s+$/g, "" );// strip trailing space
  return sInString.replace(/^\s+|\s+$/g,"");
}

function checkDup(val1,val2){
	//false - no duplication occurs
	//true - duplication occurs
	return ( (trimString(val1).length>0  || trimString(val2).length>0) && (val1==val2) )?true:false

}
/*
	var frmObj=document.forms[0];
	var surgeon_code=frmObj.surgeon_code.value;
	var asstSurg1=frmObj.asst_surgeon_code1.value;
	var asstSurg2=frmObj.asst_surgeon_code2.value;
if(checkDup(surgeon_code,asstSurg1) || checkDup(surgeon_code,asstSurg2)|| checkDup(asstSurg1,asstSurg2) ){
			alert(getMessage("RECORD_ALREADY_EXISTS","Common"));
			return;
*/


function callOrderLineCreation(){
	var formObj = document.forms[0];
	//var order_id = formObj.order_id.value;
	var order_id = "";
	var oper_code = formObj.operation_code.value;
	var patient_id = parent.parent.ChkListRecordFrame.document.forms[0].patient_id.value;
	var patient_class = parent.parent.ChkListRecordFrame.document.forms[0].patient_class.value;
	var encounter_id = parent.parent.ChkListRecordFrame.document.forms[0].encounter_id.value;
	var surgeon_code = parent.parent.ChkListRecordFrame.document.forms[0].surgeon_code.value;
	var oper_date = parent.parent.ChkListRecordFrame.document.forms[0].check_in_time.value;
	var param = "order_id="+order_id+"&oper_code="+oper_code+"&patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&surgeon_code="+surgeon_code+"&oper_date="+oper_date+"&called_from=OT_MENU";
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
function callBillingWindow1(indx){
	var patient_id = parent.parent.ChkListRecordFrame.document.forms[0].patient_id.value;
	var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	//var booking_num=document.forms[0].booking_num.value;
	if(called_from=="BOOKING" ||called_from=="OT_SLATE"){
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
	var operation_code = eval("document.forms[0].operation_code"+indx+".value");
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
//	var responseText="OTEM00000001503::1::0HBU0ZY::SD00000272::E::10019267::1::100192670001::16/09/2009 17:04::P::KATHRINA::S::MN1_001::<NR>MN1_001#C# # #P#KATHRINA#ST21#E#N#1#500::500::500::N::0.0::Y::1";
	showBillingWindow1(responseText,indx);

 }

async function showBillingWindow1(str,indx){

	var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	var arr = str.split("::");
	if(called_from=="BOOKING" ||called_from=="OT_SLATE"){
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
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var column_descriptions ="";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_num+"&bean_id="+bean_id;
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
		if(typeof retVal!='undefined'){
		var bill_st=eval("document.forms[0].bill_st"+indx+".value");
		var arr=bill_st.split("::");
		if(arr[6]=='L' || retVal[6]=="")
		{
		if(retVal[6]=="") retVal[6]=null;
        if(retVal[7]=="") retVal[7]=null;
		}
		var charge_str = retVal[1]+"::"+retVal[2]+"::"+retVal[3]+"::"+arr[3]+"::"+retVal[6]+"::"+arr[5]+"::"+arr[6]+"::"+retVal[7]+"::"+retVal[8];


		var rate=retVal[5];
		var pnl_str =  getPanelStr(indx);
		var panel_str =pnl_str.split("::")[13];
	   // var bill_str =retVal[1]+"::"+retVal[2]+"::"+retVal[3]+"::"+arr[3]+"::"+retVal[6]+"::"+arr[5]+"::"+arr[6]+"::"+retVal[7]+"::"+retVal[8];
		 //charge_str = retVal[1]+"::"+retVal[2]+"::"+retVal[3]+"::"+arr[3]+"::"+retVal[6]+"::"+arr[5]+"::"+arr[6];
		updateRevisedPanelStr(indx,charge_str,panel_str,rate)
		paintBillingDetails(indx,charge_str);
	  }

 }

function getCatalogCode(oper_code){
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
function updateRevisedPanelStr(key,charge_str,panel_str,rate){
	var patient_id = parent.parent.ChkListRecordFrame.document.forms[0].patient_id.value;
	var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	var notapplicable=getLabel("Common.notapplicable.label","common");
	var desc =notapplicable;
	if(called_from=="BOOKING" ||called_from=="OT_SLATE"){
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
	xmlStr+= "operation_code=\""+  checkSpl( eval("document.forms[0].operation_code"+key+".value") ) + "\" ";
	xmlStr+= "operation_desc=\""+  checkSpl(eval("document.forms[0].operation_desc"+key+".value")) + "\" ";
	xmlStr+= "side_applicable=\""+  checkSpl( eval("document.forms[0].side_applicable"+key+".value") )+ "\" ";
	xmlStr+= "patient_id=\""+patient_id+"\" ";
	if(eval("document.forms[0].side_applicable"+key+".value")=="")
		xmlStr+="side_applicable_desc=\""+desc+"\" ";
	else
		xmlStr+="side_applicable_desc=\""+checkSpl( eval("document.forms[0].side_applicable_desc"+key+".value"))+ "\" ";
	xmlStr+= "side_applicable_yn=\""+  checkSpl( eval("document.forms[0].side_applicable_yn"+key+".value") )+ "\" ";
	xmlStr+= " remarks=\""+  checkSpl( eval("document.forms[0].remarks"+key+".value") ) + "\" ";
	xmlStr+= " panel_str=\""+  checkSpl( panel_str ) + "\" ";
	xmlStr+= " rate=\""+rate+"\" ";
	xmlStr+= " bill_str=\""+charge_str+"\" ";
	xmlStr+= " order_id=\""+order_id+"\" ";
	xmlStr+= " order_line_num=\""+order_line_num+"\" ";
	xmlStr+=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CheckInValidation.jsp?func_mode=ReviseBillDtls&recId="+key,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
 }

function paintBillingDetails(row_num,charge_str){
	var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
	var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var lbl_incl=getLabel("eOT.Included.Label","ot_labels");
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


	var str = "<B><font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
	str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</font> </B>";
	str+="<br>"+lbl_incl+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lbl_approval+approvalreqd;
	eval(document.getElementById("charge"+row_num)).innerHTML = str;
  }
function getPanelStr(indx){
	var called_from = parent.parent.ChkListRecordFrame.document.forms[0].called_from.value;
	if(called_from=="BOOKING" ||called_from=="OT_SLATE"){
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
	var operation_code = eval("document.forms[0].operation_code"+indx+".value");
	var patient_id = parent.parent.ChkListRecordFrame.document.forms[0].patient_id.value;

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

function ValidateSurgeryDate(checkin_backdate_limit,sysdate,Chk_Date,da1)
{
 var check_in_backdate_limit = checkin_backdate_limit;
 var sys_date = sysdate;
 var enter_date = document.PreOperHdr.surgery_date.value;
 var chk_dat = Chk_Date;
if(CheckDate1(da1)==true)
{
if(enter_date.length > 0 && sysdate.length > 0 )
		{
			var enteredDateArray = enter_date.split("/");
			var sysDateArray = sysdate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
			var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);
			if(Date.parse(sysDateObject) < (Date.parse(enteredDateObject)))
			{
	          alert(getMessage('APP-OT0161','OT'));
			  document.PreOperHdr.surgery_date.value="";
			  //document.PreOperHdr.surgery_date.focus();
			}

		}
    if(check_in_backdate_limit != "null" || check_in_backdate_limit != "0")
	{
			var enteredDateArray = enter_date.split("/");
			var sysDateArray = chk_dat.split("/");
			var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
			var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);
 		    if(Date.parse(enteredDateObject) < Date.parse(sysDateObject))
		    {
			//alert(" Surgery Date exceeds the Check-In Backdate Limit defined for Facility...");
			alert(getMessage('APP-OT0160','OT'));
			document.PreOperHdr.surgery_date.value="";
		//	document.PreOperHdr.surgery_date.value="";
            //document.PreOperHdr.surgery_date.focus();
		    }


	}
}

}
function CheckDate1(obj)
{
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		//alert("Current Date 3751"+str_date);
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
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}else return true;
	}
}
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}
function validate_Surgery_Date(checkin_backdate_limit)
{
 var check_in_backdate_limit = checkin_backdate_limit;
  if(check_in_backdate_limit == "null" || check_in_backdate_limit == "0")
	{
      document.PreOperHdr.surgery_date.disabled=true;
	}
}
/* added by sathish on 26-09-2008 */
function surgery_date_change()
{
	var formObj=document.forms[0];
	var check_in_time=formObj.check_in_time.value;
    check_in_time=check_in_time.split(" ");
	formObj.check_in_time.value=document.getElementById("surgery_date").value+" "+check_in_time[1];
	//Added by Rajesh V 06/11/2012
	if(document.getElementById("surgery_date").value!=''){
		formObj.checked_in_date_time.value = document.getElementById("surgery_date").value+" "+check_in_time[1];
	}
	//Added by Rajesh V 06/11/2012
	//alert(formObj.check_in_time.value)

}
function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//return (event.keyCode -= 32);
	return true ;
}


//check for spl charactes in Remarks column

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//return (event.keyCode -= 32);
	return true ;
}

function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61));
            else{
                specCharsExist = true;
                break;
            }
        }
        return specCharsExist;
    }
	function CheckChars1(obj)
	{
	   var specCharsExist=CheckChars2(obj);
	   if(specCharsExist==true)
		{
		 //alert("Special Characters other than _ * / - . , = +  are not allowed");
		 alert(getMessage("APP-OT0162","OT"));

		  obj.focus();
	      return;
		}
	}
function isValidDateTime(obj){
	    var msg1 = "";
		//var frmObj = document.frames.f_query_add_mod.ChkListRecordFrame.document.PreOperHdr;
	    var frmObj = document.getElementById("PreOperHdr");
		//var checked_in_time = frmObj.checked_in_date_time.value;
	    var checked_in_time = parent.window[2].window[2].window[0].document.getElementById("checked_in_date_time").value;
		//var check_in_time = frmObj.check_in_time.value;
	    var doc = parent.window[2].window[2].window[0];
	    var check_in_time = doc.check_in_time.value;
		//var called_from_1 = frmObj.called_from.value;
	    var called_from_1 = doc.called_from.value;
		//var surgery_date = frmObj.surgery_date.value;
	    var surgery_date = parent.window[2].window[2].window[0].document.getElementById("surgery_date").value;
		//var order_datetime1 = frmObj.order_DateTime.value;
	    var order_datetime1 = doc.order_DateTime.value;
    if(obj.value!=""){
		var str=obj.value;
		var dflag=true;
		var tflag=true;
		var dateValArr = str.split(' ');
		var resultFlag=false;
		var flag1=false;
		var flag2=false;
		//var Booking_Date = frmObj.booking_date.value;
		var Booking_Date = doc.booking_date.value;
		if (dateValArr.length != 2)
			{
			//msg1 = getMessage("INVALID_DATE_FMT","SM");
			msg1 = getMessage("INVALID_DATE_TIME","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
			 //alert(getMessage('INVALID_DATE_FMT','SM'));
			 obj.focus();
			 return false;
			}
			else
			{
			 dflag=checkDate(dateValArr[0]);
			 tflag=checkTime(dateValArr[1]);
			 if(dflag==true && tflag==true)
				{
				 	 resultFlag = true;
				}
				else
					{
					resultFlag = false;
					return false;
					}
				}
				if(resultFlag == true){
					//Added by Rajesh V 06/11/2012
					var retVal1 = true;
					//var chk_in_back_dt = frmObj.checkin_backdate_limit.value;
					var chk_in_back_dt = doc.checkin_backdate_limit.value;
					if(chk_in_back_dt<1){
						retVal1 = compareDatesLocal1(checked_in_time,check_in_time);
						if(retVal1 == false)
						{
							msg1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
						}
					}
					else{
						//muthu
						var formObj = (document.forms[0]!=null)?document.forms[0]:parent.frames[1].ChkListRecordFrame.document.forms[0];
						//var current_date_format_dr = formObj.current_date_format.value;
						var current_date_format_dr = document.getElementById("current_date_format").value;
						//muthu
						var today = new Date();
						/*var y = today.getFullYear().toString();
						var m = "0" + (today.getMonth() + 1).toString();
						m = m.slice(m.length - 2);
						var n = "0" + today.getDate().toString();
						n = n.slice(n.length-2);
						todayDate = y+'-'+m+'-'+n;
						alert('todayDate... '+todayDate);*/

						today.setFullYear(current_date_format_dr);
						var dat = checked_in_time.split(" ");
						var dateArr = dat[0].split("/");
						var dateArr1 = dat[1].split(":");
						//chkdInDate = dateArr[2]+'-'+dateArr[1]+'-'+dateArr[0]+','+dateArr1[0]+':'+dateArr1[1];
						var chkdInDate = new Date(dateArr[2],dateArr[1]-1,dateArr[0],dateArr1[0],dateArr1[1])
						//if(chkdInDate>todayDate){
						if(chkdInDate>today){
							msg1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
						}
						/*retVal1 = compareDatesLocal2(check_in_time,checked_in_time);
						if(retVal1 == false)
						{
							msg1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
						}*/
					}
					//Added by Rajesh V 06/11/2012
					var retVal2 = "";
					var retVal3 = "";
					var retVal4 = "";
					if (called_from_1 == "OT_MENU")
					{
						surgery_date = surgery_date + " 00:00";
						retVal2 = compareDatesLocal2(checked_in_time,surgery_date);
					}
					else if (called_from_1 == "BOOKING")
					{
						retVal2 = compareDatesLocal2(checked_in_time,order_datetime1);
					}
					else
					{
						retVal3 = compareDatesLocal2(checked_in_time,Booking_Date);
						retVal4 = compareDatesLocal2(checked_in_time,order_datetime1);
						if (retVal3 == true && retVal4 == true)
						{
							retVal2 = true;
						}
						else
						{
							retVal2 = false;
						}
					}

					if(retVal2 == false)
					{
						if (called_from_1 == "OT_MENU")
						{
							//alert(getMessage("APP-OT0196",'OT'));
							msg1 = getMessage("APP-OT0197","OT");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
						}
						else if (called_from_1 == "BOOKING")
						{
							//alert(getMessage("APP-OT0196",'OT'));
							msg1 = getMessage("APP-OT0198","OT");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
						}
						else
						{
							if (retVal3 == "false")
							{
							//alert(getMessage("APP-OT0196",'OT'));
							msg1 = getMessage("APP-OT0196","OT");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
							}
							else
							{
							//alert(getMessage("APP-OT0196",'OT'));
							msg1 = getMessage("APP-OT0198","OT");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
							return false;
							}

						}
					}
					}
							else
		                      {
								return false;
		                      }
				if((retVal1 == true)&&(retVal2 == true)){

				check_in_time = checked_in_time;
				//frmObj.check_in_time.value = check_in_time;
				doc.check_in_time.value = check_in_time;
				 }
				 else{
					return false;
				 }
	}
	else{
         //alert(getMessage('CANNOT_BE_BLANK','OT'));
		 msg1 = getMessage("CANNOT_BE_BLANK","OT");
  		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
		 obj.value = check_in_time;
		 return true;
	}
}

function checkDate(objval)
{
	    var msg2= "";
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = objval;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3)
			{
			//alert(getMessage('INVALID_DATE_FMT','SM'));
			//msg2 = getMessage("INVALID_DATE_FMT","SM");
			msg2 = getMessage("INVALID_DATE_TIME","SM");
  		    messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg2;
			flag=false;
			}
		else
		{//flag=false;
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (arr_date[0].length!=2) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (arr_date[1].length!=2) flag=false;
		if (!arr_date[2]) flag=false;
		if (!RE_NUM.exec(arr_date[2])) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);

		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);

		//alert(dt_date.getMonth()+ " and  " + (arr_date[1]-1));
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		if (flag==false){
				//alert(getMessage('INVALID_DATE_FMT','SM'));
				//msg2 = getMessage("INVALID_DATE_FMT","SM");
				msg2 = getMessage("INVALID_DATE_TIME","SM");
			    messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg2;
			}
		}
		return flag;
}

function checkTime(field)
  {
    var errorMsg = "";
	var msg3 = "";
    // regular expression to match required time format
    re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
    var flag=true;
    if(field.value != '') {
      if(regs = field.match(re)) {
        if(regs[4]) {
          // 12-hour time format with am/pm
          if(regs[1] < 1 || regs[1] > 12 || regs[1].length!=2) {
				  //alert(getMessage('INVALID_DATE_FMT','SM'))
				  //msg3 = getMessage("INVALID_DATE_FMT","SM");
				  msg3 = getMessage("INVALID_DATE_TIME","SM");
		  		  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg3;
					  flag=false;
          }
        } else {
          // 24-hour time format
          if(regs[1] > 23  || regs[1].length!=2) {
			  //alert(getMessage('INVALID_DATE_FMT','SM'));
			  //msg3 = getMessage("INVALID_DATE_FMT","SM");
			  msg3 = getMessage("INVALID_DATE_TIME","SM");
		  	  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg3;
			   flag=false;
          }
        }
        if(!errorMsg && regs[2] > 59) {
			 //alert(getMessage('INVALID_DATE_FMT','SM'));
			 //msg3 = getMessage("INVALID_DATE_FMT","SM");
			 msg3 = getMessage("INVALID_DATE_TIME","SM");
		  	  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg3;
			  flag=false;
        }
      } else {
			 //alert(getMessage('INVALID_DATE_FMT','SM'));
			// msg3 = getMessage("INVALID_DATE_FMT","SM");
			msg3 = getMessage("INVALID_DATE_TIME","SM");
			  messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg3;
			  flag=false;
      }
    }

    if(errorMsg != "") {
      alert(errorMsg);
      return false;
    }
    return flag;
  }

 function compareDatesLocal1(Checked_in_time,Check_in_time) {
    if(Checked_in_time.length > 0 && Check_in_time.length > 0 ) {
			var Checked_in_time_array = Checked_in_time.split(" ");
			var Checked_in_date1 = Checked_in_time_array[0];
			var Checked_in_time1 = Checked_in_time_array[1];
			var Check_in_array = Check_in_time.split(" ");
			var Check_in_date1 = Check_in_array[0];
			var Check_in_time1 = Check_in_array[1];
            var CheckedInDatearray = Checked_in_date1.split("/");
            var CheckInDatearray = Check_in_date1.split("/");
            var CheckedIntimearray = Checked_in_time1.split(":");
            var CheckIntimearray = Check_in_time1.split(":");
			var ChkdDateTime = new Date(CheckedInDatearray[2],CheckedInDatearray[1]-1,CheckedInDatearray[0],CheckedIntimearray[0],CheckedIntimearray[1]);
            var ChkDateTime = new Date(CheckInDatearray[2],CheckInDatearray[1]-1,CheckInDatearray[0],CheckIntimearray[0],CheckIntimearray[1]);
			//Added by MuthuN against 37688 on 2/7/2013 /* For Direct checkIn as well as OT Slate checkIn */
			var rDate = new Date();
			var formObj = (document.forms[0]!=null)?document.forms[0]:parent.frames[1].ChkListRecordFrame.document.forms[0];
			var current_date_format_dr = formObj.current_date_format.value;
			rDate.setFullYear(current_date_format_dr);
			//if(Date.parse(ChkdDateTime) <= Date.parse(ChkDateTime)) {
			if((Date.parse(ChkdDateTime) <= Date.parse(ChkDateTime)) || (Date.parse(ChkdDateTime) <= Date.parse(rDate))) {
			//Added by MuthuN against 37688 on 2/7/2013 /* For Direct checkIn as well as OT Slate checkIn */
              return true;
            }
			else{
				return false;
			}
    }
	return true;
}

  function compareDatesLocal2(Checked_in_time,Booking_Date) {
    if(Checked_in_time.length > 0 && Booking_Date.length > 0 ) {
			var Checked_in_time_array = Checked_in_time.split(" ");
			var Checked_in_date1 = Checked_in_time_array[0];
			var Checked_in_time1 = Checked_in_time_array[1];
			var Booking_Date_array = Booking_Date.split(" ");
			var Booking_Date_date1 = Booking_Date_array[0];
			var Booking_Date_time1 = Booking_Date_array[1];
            var CheckedInDatearray = Checked_in_date1.split("/");
            var BookingDatearray = Booking_Date_date1.split("/");
            var CheckedIntimearray = Checked_in_time1.split(":");
            var Bookingtimearray = Booking_Date_time1.split(":");
			//Modified by Rajesh for SCF 0690
			var ChkdDateTime = new Date(CheckedInDatearray[2],CheckedInDatearray[1]-1,CheckedInDatearray[0],CheckedIntimearray[0],CheckedIntimearray[1]);
            var BookingDateTime = new Date(BookingDatearray[2],BookingDatearray[1]-1,BookingDatearray[0],Bookingtimearray[0],Bookingtimearray[1]);
			//Modified by Rajesh for SCF 0690
			if(Date.parse(ChkdDateTime) >= Date.parse(BookingDateTime)) {
                return true;
            }
			else{
				return false;
			}
    }
	return true;
}
  //Added by lakshmi against date field requirement in check in page CRF ends here

