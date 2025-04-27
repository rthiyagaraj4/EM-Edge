
function reset() {
	formObj = f_query_add_mod.document.formDrugMedicalItemSalesHistoryReportCriteria;
	formObj.reset();
	formObj.p_cust_code.disabled=false;
	formObj.p_cus_code.disabled=false;
}
function searchCodeItem(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.formDrugMedicalItemSalesHistoryReportCriteria;	
	formObj.p_report_id.value=formObj.p_report_type.value;
	//Mandatory Fields Checking
	var from_date=formObj.p_frm_doc_date ;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(formObj.p_frm_doc_date); 	
	var names = new Array(getLabel("Common.fromdate.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
	var currentdate=getCurrentDate("DMY",formObj.p_language_id.value);
	if (blankObject != true) {
	return;
	}
if(formObj.p_frm_doc_date.value!=""){
	if(!isBefore(formObj.p_frm_doc_date.value, currentdate, "DMY", formObj.p_language_id.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.p_frm_doc_date.select();
			formObj.p_frm_doc_date.focus();
			return;
		}
}
	
	if(formObj.p_to_doc_date.value!=""){
		if(!isBefore(formObj.p_to_doc_date.value, currentdate, "DMY", formObj.p_language_id.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST");
			formObj.p_to_doc_date.select();
			formObj.p_to_doc_date.focus();
			return;
		}
	}

	if (isValidFromToField(formObj.p_frm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {	
		if (isValidFromToField(formObj.p_frm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_frm_item_code, formObj.p_to_item_code, STRING,getLabel("Common.ItemCode.label", "Common") , messageFrame)) {	   		
				if (isValidFromToField(formObj.p_frm_doc_date, formObj.p_to_doc_date, DATE, getLabel("Common.date.label", "Common"), messageFrame)) { 

						formObj.submit();											   		
				}
			}
		}
	}
}

function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}


function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}

function searchCustomerCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "acc_entity_code";
	dataValueArray[0] = document.forms[0].p_entity_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_CUSTOMER_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.CustomerCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

function enableCustCode(){
 if (document.forms[0].p_billing_nature.value=="C")
 {
	document.forms[0].p_cust_code.value="";
	document.forms[0].p_cust_code.disabled=true;
	document.forms[0].p_cus_code.disabled=true;  
 }else{
	document.forms[0].p_cust_code.disabled=false;
	document.forms[0].p_cus_code.disabled=false;
 }
}
