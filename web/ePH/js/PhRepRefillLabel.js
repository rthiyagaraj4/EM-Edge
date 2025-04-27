function reset(obj) {
	f_query_add_mod.document.PhRepRefillLabelCriteriaForm.reset();
	f_query_add_mod.PhRepRefillLabelCriteriaForm.btnPatientID.disabled=false;
	f_query_results.location.href="../../eCommon/html/blank.html";
	f_query_status.location.href="../../eCommon/html/blank.html";
	
}

function CheckDateT(obj){
		var locale=document.PhRepRefillLabelCriteriaForm.p_language_id.value;
	
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}

	function DateCheck(from,to) {
	if(from.value=="" || to.value==""){ 
		
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.select();
			return false;
		}
	}
    return true;
}

function validate_date(Obj,ref) {
  
	if(document.forms[0].p_from_date.value=='' || document.forms[0].p_to_date.value==''){ 
		return false;
	}
	else{
		if(!isBefore(document.forms[0].p_from_date.value,document.forms[0].p_to_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			document.forms[0].p_from_date.slect();
			return false;
		}
	}
	return true;
}


// This will call common patient search
async function callPatientSearch(target){

	//var formObj=document.frames.PhRepRefillLabelCriteriaForm;
	var formObj=document.getElementById("PhRepRefillLabelCriteriaForm");
	var patient_id = await PatientSearch();
	
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
	}
}
async function locationLookup(target){
	//var formObj = document.frames.PhRepRefillLabelCriteriaForm;
	var formObj=document.getElementById("PhRepRefillLabelCriteriaForm");
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var locn_type=formObj.locn_name.value;
	var facility_id = formObj.p_facility_code.value;
	      if(facility_id =="" ){
			argumentArray[0]   =  escape("SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC  WHERE  UPPER(CLINIC_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND LANGUAGE_ID ='"+formObj.p_language_id.value+"'" );
			}else{
				argumentArray[0]   =  escape("SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW OP_CLINIC  WHERE  UPPER(CLINIC_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND EFF_STATUS='E' AND FACILITY_ID ='"+facility_id+"' AND LANGUAGE_ID ='"+formObj.p_language_id.value+"'" );
			}
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			var str =unescape(retVal);
			var arr = str.split(",");
			if(retVal != null && retVal != "" )  {
				formObj.p_locn_code.value=arr[0];
				target.value = arr[1] ;
			
            }
}

function resetLocation(){
	var formObj = document.frames.PhRepRefillLabelCriteriaForm;
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}


function showResults(){
	//var formObj			= document.frames.PhRepRefillLabelCriteriaForm;
	//var formObj=document.frames.PhRepRefillLabelCriteriaForm;
	var formObj=document.getElementById("PhRepRefillLabelCriteriaForm");

	if(document.forms[0].p_from_date.value!='' && document.forms[0].p_to_date.valu!=''){

	if(!isBefore(document.forms[0].p_from_date.value,document.forms[0].p_to_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			return false;
		}
	}
	if(formObj.locn_name.value =="")
       formObj.p_locn_code.value ="";

	var locale			= formObj.p_language_id.value;
	var patient_id      = formObj.p_patient_id.value ;
	var order_date_from = convertDate(formObj.p_from_date.value,'DMY',locale,"en");
	var order_date_to	= convertDate(formObj.p_to_date.value,'DMY',locale,"en");
	var locn_code       = formObj.p_locn_code.value;
	var facility_id     = formObj.p_facility_code.value;
    var order_id        = formObj.order_id.value;

	
	if(patient_id !=""){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		parent.f_query_results.location.href="../../ePH/jsp/PhRepRefillLabelResult.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_date_from="+order_date_from+"&facility_id="+facility_id+"&locale="+locale+"&locn_code="+locn_code+"&order_date_to="+order_date_to;
	}else{

		    alert(getMessage("PATIENT_ID_REQUIRED", "PH"));
			formObj.p_patient_id.focus();
		}
	
}

function SubmitLink(from,to,patient_id,order_id,order_date_from,order_date_to,facility_id,locn_code,locale){
	var obj=document.frames.PhRepPrescriptionResultForm;
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value =patient_id;
	obj.order_date_from.value  =order_date_from;
	obj.order_date_to.value    =order_date_to;
	obj.facility_id.value =facility_id;
	obj.locn_code.value   =locn_code;
	obj.order_id.value      =order_id;
	obj.submit();
}

function showPrintReport(order_id,drug_code){
	
	var formObj = parent.f_query_add_mod.PhRepRefillLabelCriteriaForm;

	formObj.p_refill_order.value = "@"+order_id+"@" ;
	formObj.P_ORDER_CATALOG_CODE.value = drug_code;
	parent.f_query_add_mod.PhRepRefillLabelCriteriaForm.submit();

}
