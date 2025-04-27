/* Newly Created against ML-MMOH-CRF-0598 */
function run()
{					
	var frm=f_query_rep.document.forms[0];		
	var p_facility_id = frm.p_facility_id.value;
	var facility_id = frm.facility_id.value;
	var p_user_name = frm.p_user_name.value;
	var p_module_id = frm.p_module_id.value;
	var p_report_id = frm.p_report_id.value;
	var p_language_id = frm.p_language_id.value;
	var datepattrn = frm.datepattrn.value;
	var locale = frm.locale.value;
//CONVERTDATE ADDED BY SANTHOSH FOR ML-MMOH-CRF-1961
	var p_order_fm_date = convertDate(frm.fromDate.value,"DMYHM",locale,'en');
	var p_order_to_date= convertDate(frm.toDate.value,"DMYHM",locale,'en');

	if( p_order_fm_date.length<1 || p_order_to_date.length<1){
		alert(getMessage("DS_ORDER_DATE_NOT_BLANK","DS"));
		return false;
	}
	if(isBefore(p_order_fm_date,p_order_to_date,"DMYHM",'en')){
	}else{
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));			
		f_query_rep.document.forms[0].fromDate.focus();
		parent.messageFrame.document.location.href='../../eCommon/html/blank.html' ; 
	}
//END
	var p_patient_class=frm.Patient_Class.value;
	var p_patient_id=frm.patientId.value;
	var p_ward_code=frm.wardDesc.value;	
	var isDSMealFoodOrder = frm.isDSMealFoodOrder.value;	// Added Against ML-MMOH-CRF-1572
	//Added Against Start ML-MMOH-CRF-1291[IN068947]
	var isDSNotifications = frm.isDSNotifications.value;
	
	var InstructionInLabelFormulaAppl = frm.InstructionInLabelFormulaAppl.value;
	var p_ord_status_fm = "";
	var p_ord_status_to = "";
	if(InstructionInLabelFormulaAppl=="true"){//ADDED BY SANTHOSH FOR ML-MMOH-CRF-1961
		p_ord_status_fm=frm.OrderStatusFrom.value;		
	} else if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){ // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572
		p_ord_status_fm=frm.OrderStatusFrom.value;	
		p_ord_status_to=frm.OrderStatusTo.value;	
	}  
	//Added Against End ML-MMOH-CRF-1291[IN068947]				
	
	if(p_order_fm_date.length<1 || p_order_to_date.length<1){
		alert(getMessage('DS_FROM_TO_DATE_NOT_BLANK','ds'));
		return false;
	}
	if(!checkTODate())
	return false;
	
	if(isDSNotifications=="false" && isDSMealFoodOrder=="false"){ //Site Specific Added Against ML-MMOH-CRF-1291[IN068947] & // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572
		if(p_patient_class==""){
			alert(getMessage('DS_PATIENT_CLASS_NOT_BLANK','ds'));
			return false;
		}
	}
	
	frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+"&locale="+locale+"&p_order_fm_date="+p_order_fm_date+"&p_order_to_date="+p_order_to_date+"&p_patient_class="+p_patient_class+"&p_patient_id="+p_patient_id+"&p_ward_code="+p_ward_code+"&p_ord_status_fm="+p_ord_status_fm+"&p_ord_status_to="+p_ord_status_to;	//Added Against ML-MMOH-CRF-1291[IN068947]
	
	frm.submit();		
}

//Date Comparision
function checkTODate()
{
	var formObj=parent.content.f_query_rep.MedicalFoodOrderReport;
	var fromDate= formObj.fromDate.value;
	var toDate= formObj.toDate.value;

	var d1Arr = fromDate.split("/");
	var d2Arr = toDate.split("/");
	var errMsg = getMessage('DS_FROMDATE_NOT_GTN_TODATE','ds')
	if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){
		alert(errMsg);
		return false;
	}
	else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
		if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
			alert(errMsg);
			return false;
		}
		else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
		if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
			alert(errMsg);
			return false;
		}
		else{
			return true;
		}
		}
		else{
			return true;
		}
	}
	else{
		return true;
	}
} 

function reset()
{
	var formObj = parent.content.f_query_rep.MedicalFoodOrderReport;
	var isDSMealFoodOrder = formObj.isDSMealFoodOrder.value; // Added Against ML-MMOH-CRF-1572
	//Added Against Start ML-MMOH-CRF-1291[IN068947]
	var isDSNotifications = formObj.isDSNotifications.value;
	if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){	// Added isDSMealFoodOrder Against ML-MMOH-CRF-1572		
		formObj.wardClinic_code.disabled=true;			
		formObj.quest6.disabled=true;			
	}
	//Added Against End ML-MMOH-CRF-1291[IN068947]	
	formObj.reset();
}

function searchWardClinicSelect(obj)
{
	var formObj=document.forms[0];
	var patient_class=formObj.Patient_Class.value;
	searchwardclinic(obj);
}

async function searchwardclinic(obj)
{	
	var result = false;
	var formObj = document.forms[0];
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_class=formObj.Patient_Class.value;
	
	if(patient_class=='IP'|| patient_class=='DC'){
		sql="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND PATIENT_CLASS='"+patient_class+"' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
	}else if(patient_class=='EM'|| patient_class=='OP'){	  
		sql="SELECT CLINIC_CODE CODE, LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";
		if(patient_class=='EM')
		sql +=" AND level_of_care_ind = 'E'";
		else
		sql +=" AND  level_of_care_ind = 'A'";
		sql +=" AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?)  ORDER BY 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+getLabel("eDS.WardClinic.Label","ds")+msgArray[1]);
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

	returnedValues =await CommonLookup(getLabel("eDS.WardClinic.Label","ds"),argumentArray );
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "") )  {		
		formObj.HLongRefWdId.value=arr[0];
		formObj.wardDesc.value=arr[0];
		formObj.wardClinic_code.value=arr[1];	
	} 
	else{
		formObj.HLongRefWdId.value="";
		formObj.wardDesc.value="";
		formObj.wardClinic_code.value="";
	}
}

function callclear()
{
	var formObj = document.forms[0];
	formObj.HLongRefWdId.value="";
	formObj.wardDesc.value="";
	formObj.wardClinic_code.value="";
}

function checkForSpecCharsforID(event)
{
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true;
}
function restrictSpecialChars(event)
{
	var strCheck = '.~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) != -1) 
	{
		window.event.keyCode = 27;
		return false;  
	}
	return true;
}

//Added Against Start ML-MMOH-CRF-1291[IN068947]
function enable_disable(){
	var frm=document.forms[0];
	var isDSNotifications = frm.isDSNotifications.value;
	var isDSMealFoodOrder = frm.isDSMealFoodOrder.value; // Added Against ML-MMOH-CRF-1572
	var p_patient_class=frm.Patient_Class.value;
	if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){		// Added isDSMealFoodOrder Against ML-MMOH-CRF-1572		
		frm.wardClinic_code.disabled=true;			
		frm.quest6.disabled=true;			
	}
}
//Added Against End ML-MMOH-CRF-1291[IN068947]
