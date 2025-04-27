
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.TransactionsAuditTrailCriteria;
	formObj.reset();
//	parent.frames[1].frames[1].document.forms[0].reset();
}

function searchsuppliercode(obj){


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
	argumentArray[0] = document.getElementById("SQL_AP_SUPPLIER_SELECT_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Supplier.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}

}

function searchUser(obj) {
		var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	

	var sql = document.getElementById("SQL_ST_USER_LOOKUP_USERACCESS").value + "'" + document.forms[0].p_language_id.value + "'";
	
	//	argumentArray[0]							=		document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value
		argumentArray[0] = sql;
		argumentArray[4] = "1,2"; 
//		argumentArray[4]							=		"2,3"; 
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}

}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function CheckForSpecialCharswithchar(event) {
	var strCheck = "0123456789";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function searchCodeItem(obj) {
	
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
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ALPHA_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
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
function run() {
	formObj = f_query_add_mod.document.TransactionsAuditTrailCriteria;
	if (f_query_add_mod.document.TransactionsAuditTrailCriteria) {
		
		var from_date=formObj.p_dt_from ;
		var to_date=formObj.p_dt_to;
		var sysdate=formObj.sysdate ;

		var errorPage = "../../eCommon/jsp/error.jsp";
		var arrayObject = new Array(formObj.p_dt_from ,formObj.p_dt_to);
		//var arrayObject = new Array(formObj.p_dt_to );
		var names = new Array(getLabel("Common.fromdate.label", "Common"),getLabel("Common.todate.label", "Common"));
		var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return;
		}
		var flag_fm=false;
		var flag_to=false;
		if(to_date.value==""){
		flag_to=true;
		}else{
		flag_to=checkSysdate(to_date,from_date,"N");
		}
		flag_fm=checkSysdate(from_date,sysdate,"Y");

if (isValidFromToField(formObj.p_fr_str_code, formObj.p_to_str_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
	if (isValidFromToField(formObj.p_fr_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fr_alpa_code, formObj.p_to_alpa_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.P_FR_DOC_NO, formObj.P_TO_DOC_NO, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_doc_ref, formObj.p_to_doc_ref, STRING, getLabel("Common.DocRef.label", "Common"), messageFrame)) {

				if(flag_fm!=false && flag_to!=false){
		formObj.dt_from.value = convertDate(formObj.p_dt_from.value, "DMY", formObj.p_language_id.value, "en");
		
		formObj.dt_to.value = convertDate(formObj.p_dt_to.value, "DMY", formObj.p_language_id.value, "en");

		formObj.dt_from_1.value = convertDate(formObj.p_dt_from.value, "DMY", formObj.p_language_id.value, "en");
		
		formObj.dt_to_1.value = convertDate(formObj.p_dt_to.value, "DMY", formObj.p_language_id.value, "en");

		formObj.submit(); 
				    }
                  }
				}
			  } 
		    }
	      }
	   }		
	}
}
function changeReport() {
	if (document.TransactionsAuditTrailCriteria.p_report_option.value == "1") {
		document.TransactionsAuditTrailCriteria.p_report_id.value = "STBTXAU1";
	}
	if (document.TransactionsAuditTrailCriteria.p_report_option.value == "2") {
		document.TransactionsAuditTrailCriteria.p_report_id.value = "STBTXAU3";
	}
	if (document.TransactionsAuditTrailCriteria.p_report_option.value == "3") {
		document.TransactionsAuditTrailCriteria.p_report_id.value = "STBTXAU2";
	} 
}
	function checkSysdate(receiptdate, sysdate,sel) {


		
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(f_query_add_mod.document.TransactionsAuditTrailCriteria.p_dt_from);
	if(receiptdate.value!=""){
		var flag = ChkDate(receiptdate);
		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		
		if (flag) {
			if(sel=="Y")
			if (checkdateWithSysDatefrom(receiptdate, sysdate)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FRM_DATE_NOT_LESS_SYSDATE","common");
			return false;
						
			}
			if(sel=="N")
			if (checkdateWithSysDate(receiptdate, sysdate)) {

               if (errorPage == null) {
			errorPage = "../../eCommon/jsp/error.jsp";
	 	}

		var error = getMessage("REMARKS_MUST_GR_EQUAL", "common");
		error = error.replace("$", getLabel("Common.todate.label", "Common"));
		var stLegend=getLabel("Common.todate.label", "Common");
		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + error;
			return false;




			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DT_GR_FM_DT", "ST");
			//return false;
			}
		}
	}
}
function checkdateWithSysDatefrom(entered_date, sys_date) {
	/*Entered Date Should not be less than sysdate */
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
function checkdateWithSysDate(entered_date, sys_date) {
	/*Entered Date Should not be less than sysdate Krishna 1/13/2009*/
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}
