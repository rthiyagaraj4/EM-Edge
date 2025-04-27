
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	frames[1].frames[1].document.forms[0].reset();
}
function loadPage() {
	parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	/*if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "A") {
		parent.MasterCodePages.document.location.href = "../../eST/jsp/ItemMasterPriceReport.jsp";
	} else{*/
	if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "B") {
			parent.MasterCodePages.document.location.href = "../../eST/jsp/PendingIndent.jsp";
		}else {
		if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "C") {
			parent.MasterCodePages.document.location.href = "../../eST/jsp/ListofItemsCrossingROL.jsp";
		} else {
			if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "D") {
				parent.MasterCodePages.document.location.href = "../../eST/jsp/RetailMasterStockQuantityandValueSummary.jsp";
			}  
				  else {
					if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "E") {
						parent.MasterCodePages.document.location.href = "../../eST/jsp/StockQuantityStationWise.jsp";
					} else {
						if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "F") {
							parent.MasterCodePages.document.location.href = "../../eST/jsp/StockValueStationWise.jsp";
						} else {
							if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "G") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/DeptWiseConsumption.jsp";
							}else {
							if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "H") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/ExpiryItem.jsp";
							}else {
							if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "I") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/GoodsReturnToVendorReport.jsp";
							}else {
							if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "J") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/IndentIssuebyDept.jsp";
							}else {
							if (parent.MasterCodeListFrame.document.formStockSummaryList.summary_code.value == "K") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/PurchaseSummaryReport.jsp";
							}else {
		                       parent.MasterCodePages.document.location.href = "../../eCommon/html/blank.html";
						            }
						   }
					   }
				    }
			      }
		       }
	         }
          }
       }
    }
 //}
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}   
	return true;
}
function CheckForSpecialCharsPONo(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}   
	return true;
}
/*
function searchMachineCode(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.forms[0].p_facility_id.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = document.forms[0].SQL_ST_MACHINE_CODE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.DocType.label", "Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}*/
async function searchCodeItem(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
/*
function searchAssemblyCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ASSEMBLY_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
} */
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
	}
}
async function searchCodeStore(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
async function searchCodeDeptForFacility(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "operating_facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
//	argumentArray[0] = document.getElementById("SQL_ST_DEPT_LOOKUP").value;
	var sql_1 = "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'spl','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'spl','2') LIKE UPPER(?) ORDER BY 1";
	var sql_2 = sql_1.replace(/spl/, document.forms[0].p_language_id.value);
	var sql_3 = sql_2.replace(/spl/, document.forms[0].p_language_id.value);
	argumentArray[0] = sql_3;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.department.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
/*
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
} */
async function searchSupplier(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.Supplier.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
/*
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
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchSterileType(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_STERILE_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodePrepareLocation(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_PREPARE_LOCATION_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeTrnDocType(obj) {
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
	argumentArray[0] = document.getElementById("SQL_ST_TRN_DOC_TYPE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchDocType(obj) {
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
	argumentArray[0] = "Select   a.doc_type_code    code, 	b.short_desc  description    FROM    st_trn_doc_type a, sy_doc_type_master_lang_vw  b     Where   b.language_id like  ?    AND   a.facility_id  like (?)    AND   a.doc_type_code LIKE	  upper(?) AND   upper(b.short_desc)   like upper(?)   and  a.doc_type_code = b.doc_type_code and A.TRN_TYPE not in ('PRQ','SAL','SRT') order by 	2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeTrnDocTypeFORGRN(obj) {
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
	argumentArray[0] = "Select   a.doc_type_code    code, 	b.short_desc  description    FROM    st_trn_doc_type a, sy_doc_type_master_lang_vw  b     Where   b.language_id like  ?    AND   a.facility_id  like (?)    AND   a.doc_type_code LIKE	  upper(?) AND   upper(b.short_desc)   like upper(?)   and  a.doc_type_code = b.doc_type_code and A.TRN_TYPE not in ('PRQ','SAL','SRT') order by 	2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.DocType.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
} */
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
	}
}
function run() {
   /*if (f_query_add_mod.MasterCodePages.document.formItemMasterPriceReport) {
				formObj = f_query_add_mod.MasterCodePages.document.formItemMasterPriceReport;
					 if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
					 	
						  }
						formObj.submit(); 
					  }else {*/
	if (f_query_add_mod.MasterCodePages.document.formPendingIndent) {
		formObj = f_query_add_mod.MasterCodePages.document.formPendingIndent;
							//if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, STRING, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");	
							}
							//}
		formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY",formObj.p_module_id,formObj.p_facility_id.value, formObj.p_language_id.value, "en");
		if(formObj.dt_from_1.value==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.dt_from_1.focus();
		return;
		}
		if(formObj.dt_to_1.value != ""){
		if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",'en'.value)) {
       alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
       formObj.dt_to_1.focus();
       return ;	
       }
	  }
		formObj.action="../../eCommon/jsp/report_options.jsp";
		formObj.target="messageFrame";
        formObj.submit();	
	} else {
		if (f_query_add_mod.MasterCodePages.document.formListofItemsCrossingROL) {
			formObj = f_query_add_mod.MasterCodePages.document.formListofItemsCrossingROL;
		if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
  		if(formObj.p_fm_store_code.value==""){
		alert(getMessage("FROM_STORE_NOT_DEFINED", "ST"));
		formObj.p_fm_store_code.focus();
		return;
		}
		if(formObj.p_to_store_code.value==""){
		alert("APP-ST0117 To Store Cannot be blank...");
		formObj.p_to_store_code.focus();
		return;
		}
		formObj.action="../../eCommon/jsp/report_options.jsp";
		formObj.target="messageFrame";
		formObj.submit();
        }							
   	   }
	  }else {
				if (f_query_add_mod.MasterCodePages.document.formRetailMasterStockQuantityandValueSummary) {
					formObj = f_query_add_mod.MasterCodePages.document.formRetailMasterStockQuantityandValueSummary;
					 if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
						formObj.action="../../eCommon/jsp/report_options.jsp";
						formObj.target="messageFrame";
								formObj.submit();
						  }
						}	 
					} else {
					if (f_query_add_mod.MasterCodePages.document.formStockQuantityStationWise) {
						formObj = f_query_add_mod.MasterCodePages.document.formStockQuantityStationWise;
						if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
							formObj.action="../../eCommon/jsp/report_options.jsp";
							formObj.target="messageFrame";
						formObj.submit();
  					    }
							
						 }else {
						if (f_query_add_mod.MasterCodePages.document.formStockValueStationWise) {
						formObj = f_query_add_mod.MasterCodePages.document.formStockValueStationWise;
						if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
							formObj.action="../../eCommon/jsp/report_options.jsp";
							formObj.target="messageFrame";
						     formObj.submit();
  						   } 
						   }else{
							if (f_query_add_mod.MasterCodePages.document.formDeptWiseConsumption) {
			formObj = f_query_add_mod.MasterCodePages.document.formDeptWiseConsumption;
		   if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
  	    // if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
	formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");					 
	    formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
		if(formObj.dt_from_1.value==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.dt_from_1.focus();
		 return;
		 }
		 if(formObj.dt_to_1.value != ""){
		  if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",'en'.value)) {
       alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
       formObj.dt_to_1.focus();
       return ;	
       } 
	   }
		 formObj.action="../../eCommon/jsp/report_options.jsp";
			formObj.target="messageFrame";
		  formObj.submit();
		 // }
	    }	
		 }else {
		if (f_query_add_mod.MasterCodePages.document.formExpiryitem) {
		formObj = f_query_add_mod.MasterCodePages.document.formExpiryitem;
							 if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
							//if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");	
		formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY",formObj.p_module_id,formObj.p_facility_id.value, formObj.p_language_id.value, "en");
		 if(formObj.dt_from_1.value==""){
		 alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		 formObj.dt_from_1.focus();
		 return;
		}
		/*if(formObj.dt_to.value==""){
		alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		formObj.dt_to_1.focus();
		return;
		}*/
		if(formObj.dt_to_1.value != ""){
		if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",'en'.value)) {
      alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
      formObj.dt_to_1.focus();
     return ;	
     } 
	 }
		
		if (isValidFromToField(formObj.dt_from_1, formObj.dt_to_1, DATE, getLabel("Common.date.label", "Common"))) {
			formObj.action="../../eCommon/jsp/report_options.jsp";
			formObj.target="messageFrame";
        formObj.submit();
		}
		//}	
		}
		}else {
		if (f_query_add_mod.MasterCodePages.document.formGoodsReturntoVendor) {
		formObj = f_query_add_mod.MasterCodePages.document.formGoodsReturntoVendor;
		if (isValidFromToField(formObj.FR_STORE_CODE, formObj.TO_STORE_CODE, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
		           if(formObj.supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame) {
				   if (isValidFromToField(formObj.from_item, formObj.to_item, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
					        //if (doDateCheck(formObj.from_date, formObj.TO_DATE, messageFrame)) {
								formObj.from_date.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");	
							//}
		formObj.TO_DATE.value = convertDate(formObj.dt_to_1.value, "DMY",formObj.p_module_id,formObj.p_facility_id.value, formObj.p_language_id.value, "en");
		if(formObj.from_date.value==""){
		 alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.dt_from_1.focus();
		return;
		}
        if(formObj.TO_DATE.value==""){
		 alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		formObj.dt_to_1.focus();
		return;
		}
		if(formObj.TO_DATE.value != ""){
	  if(!isBefore(formObj.from_date.value,formObj.TO_DATE.value,"DMY",'en'.value)) {
     alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
     formObj.dt_to_1.focus();
     return;	
     }
	 }
		formObj.action="../../eCommon/jsp/report_options.jsp";
		formObj.target="messageFrame";
		formObj.submit(); 
		}	
		}
		}
     
	}else {
		if (f_query_add_mod.MasterCodePages.document.formIndentIssuebyDept) {
		formObj = f_query_add_mod.MasterCodePages.document.formIndentIssuebyDept;
		if(formObj.p_fm_store_code.value==""){
		alert(getMessage("FROM_STORE_NOT_DEFINED", "ST"));
		formObj.p_fm_store_code.focus();
		return;
		}
		 if(!((formObj.p_fm_store_code.value).toUpperCase()==""&& (formObj.p_to_store_code.value).toUpperCase()=="")
		 && ((formObj.p_fm_store_code.value).toUpperCase() == (formObj.p_to_store_code.value).toUpperCase())){
		 alert(getMessage("BOTH_STORE_CANNOT_BE_SAME", "ST"));
		 formObj.p_to_store_code.focus();
		 return;
		 }
		// if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)){
		//if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
		formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");	
		 //}
		 formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY",formObj.p_module_id,formObj.p_facility_id.value, formObj.p_language_id.value, "en");

		if(formObj.dt_from.value==""){
		 alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.dt_from_1.focus();
		return;
		}
        if(formObj.dt_to.value==""){
		 alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		formObj.dt_to_1.focus();
		return;
		}
		if(formObj.dt_to.value !=""){
         if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",'en'.value)) {
     alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
     formObj.dt_to_1.focus();
      return;	
       }
	   }
		formObj.action="../../eCommon/jsp/report_options.jsp";
		formObj.target="messageFrame";
       formObj.submit();
	  // }
		}else {
		if (f_query_add_mod.MasterCodePages.document.formPurchaseSummary) {
		formObj = f_query_add_mod.MasterCodePages.document.formPurchaseSummary;
		if(formObj.supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame) {
							//if (doDateCheck(formObj.from_date, formObj.TO_DATE, messageFrame)) {
								formObj.from_date.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");	
							//}
		}
		formObj.TO_DATE.value = convertDate(formObj.dt_to_1.value, "DMY",formObj.p_module_id,formObj.p_facility_id.value, formObj.p_language_id.value, "en");	
       if(formObj.from_date.value==""){
		 alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.dt_from_1.focus();
		return;
		}
        if(formObj.TO_DATE.value==""){
		 alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		formObj.dt_to_1.focus();
		return;
		}
		if(formObj.TO_DATE.value !=""){
      if(!isBefore(formObj.from_date.value,formObj.TO_DATE.value,"DMY",'en'.value)) {
     alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
     formObj.dt_to_1.focus();
    return ;	
    }   
	}
		formObj.action="../../eCommon/jsp/report_options.jsp";
		formObj.target="messageFrame";
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
			  }
		// }
	  }
	


function checkDocDate(formObj) {
	if (isValidFromToField(formObj.dt_from_1, formObj.dt_to_1, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
	}
}
 function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		setTimeout(function() {

		toObj.focus();												
		}, 0);
		
	}
	return bReturn;
} 

function frmdate(){
   formObj = document.formPendingIndent;      
 var dt_from_1=document.formPendingIndent.dt_from_1.value ;
   if(dt_from_1==""){
alert(getMessage("DATE_NOT_BLANK", "ST"));
formObj.dt_from_1.focus();
}
}

 



