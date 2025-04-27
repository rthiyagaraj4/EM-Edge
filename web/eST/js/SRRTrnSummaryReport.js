
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
	if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "A") {
		parent.MasterCodePages.document.location.href = "../../eST/jsp/RequestSummaryReport.jsp";
	} else {
		if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "B") {
			parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRIssueSummaryReport.jsp";
		} else {
			if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "C" || parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "L") {
				parent.MasterCodePages.document.location.href = "../../eST/jsp/MFGReceiptSummaryReport.jsp";
			} else {
				if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "D") {
					parent.MasterCodePages.document.location.href = "../../eST/jsp/AdjustmentSummaryReport.jsp?trn_type=ADJ";
				} else {
					if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "E") {
						parent.MasterCodePages.document.location.href = "../../eST/jsp/TransferSummaryReport.jsp";
					} else {
						if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "F") {
							parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRIssueReturnSummaryReport.jsp";
						} else {
							if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "G") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/TrnSummaryReportGRN.jsp";
							} else {
								if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "H") {
									parent.MasterCodePages.document.location.href = "../../eST/jsp/TrnSummaryReportRTV.jsp";
								} else {
									if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "I") {
										parent.MasterCodePages.document.location.href = "../../eST/jsp/SalesSummaryReport.jsp";
									} else {
										if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "J") {
											parent.MasterCodePages.document.location.href = "../../eST/jsp/BonusSummaryReportCriteria.jsp";
										} else {
											if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "K") {
												parent.MasterCodePages.document.location.href = "../../eST/jsp/ProductTransferSummaryReport.jsp";
											} else {
												if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "M") {
													parent.MasterCodePages.document.location.href = "../../eST/jsp/AdjustmentSummaryReport.jsp?trn_type=SPB";
												}else {
													if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "N") {
														//parent.MasterCodePages.document.location.href = "../../eST/jsp/AdjustmentSummaryReport.jsp?trn_type=CBL";
														   /* @Name - Priya
															* @Date - 16/06/2010
															* @Inc# - 
															* @Desc - To load the newly created 'SRRAdjustmentSummaryReport' page the above is commented.
															*/
														parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRAdjustmentSummaryReport.jsp?trn_type=CBL";
													}else {
														if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "O") {
															parent.MasterCodePages.document.location.href = "../../eST/jsp/AdjustmentSummaryReport.jsp?trn_type=CEB";
														}else {
															if (parent.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value == "P") {
															parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRAcknowledgeSummaryReport.jsp?trn_type=CEB";
														}else{
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
					}
				}
			}
		}
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
function CheckForSpecialCharsPONo(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
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
}
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
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
function searchCodeDeptForFacility(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.department.label", "Common"), argumentArray);
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
function searchSupplier(obj) {
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
}
function numbervalidation() {
	if ((event.keyCode >= 48) && (event.keyCode <= 57)) {
		return true;
	} else {
		event.keyCode = 0;
	}
}
function run() {
	if (f_query_add_mod.MasterCodePages.document.formrequestsummary) {
		formObj = f_query_add_mod.MasterCodePages.document.formrequestsummary;
		if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
								formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
							}
						}
					}
				}
			}
		}
		formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
		formObj.submit();
	} else {
		if (f_query_add_mod.MasterCodePages.document.formissuesummary) {
			formObj = f_query_add_mod.MasterCodePages.document.formissuesummary;
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.item.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_iss_st, formObj.p_to_iss_st, STRING, getLabel("eST.IssuingStore.label", "ST"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_rec_to_st, formObj.p_to_rec_to_st, STRING, getLabel("Common.ReceivingStore.label", "Common"), messageFrame)) {
							if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
								if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
									if (isValidFromToField(formObj.p_fm_doc_ref, formObj.p_to_doc_ref, STRING, getLabel("Common.DocRef.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fr_supplier_code, formObj.p_to_supplier_code, STRING, getLabel("Common.Supplier.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_dt_from_1, formObj.p_dt_to_1, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
												formObj.dt_from.value = convertDate(formObj.p_dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
												formObj.dt_to.value = convertDate(formObj.p_dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
													if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
											formObj.submit();}
												}
											}
										}
								}
							}
						}
					}
				}
			
			}
			//formObj.dt_to.value = convertDate(formObj.p_dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
			//formObj.submit();
			}
		} else {
			if (f_query_add_mod.MasterCodePages.document.formMFGsummary) {
				formObj = f_query_add_mod.MasterCodePages.document.formMFGsummary;
				if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
						if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
							formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
						}
					}
				}
				formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
				if(f_query_add_mod.MasterCodeListFrame.document.formTrnSummaryList.summary_code.value=="L"){
				formObj.p_report_id.value="STBMFGDTL";
			
				}
				formObj.submit();
			} else {
				if (f_query_add_mod.MasterCodePages.document.formadjustmentsummary) {
					formObj = f_query_add_mod.MasterCodePages.document.formadjustmentsummary;
					if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
							if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
								if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
									if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
											formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
										}
									}
								}
							}
						}
					}
					formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
					if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
						formObj.submit();
					}
				} else {
					if (f_query_add_mod.MasterCodePages.document.formtransfersummary) {
						formObj = f_query_add_mod.MasterCodePages.document.formtransfersummary;
						if (isValidFromToField(formObj.p_fm_iss_st, formObj.p_to_iss_st, STRING, getLabel("Common.FromStore.label", "Common"), messageFrame)) {
							if (isValidFromToField(formObj.p_fm_iss_to_st, formObj.p_to_iss_to_st, STRING, getLabel("Common.ToStore.label", "Common"), messageFrame)) {
								if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
									if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT,getLabel("Common.DocNo.label", "Common"), messageFrame)) {
													if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
														formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
													}
												}
											}
										}
									}
								}
							}
						}
						formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
						formObj.submit();
					} else {
						if (f_query_add_mod.MasterCodePages.document.formproducttransfersummary) {
							formObj = f_query_add_mod.MasterCodePages.document.formproducttransfersummary;
							if (isValidFromToField(formObj.p_fm_iss_st, formObj.p_to_iss_st, STRING, getLabel("Common.Store.label", "Common"), messageFrame)) {
								if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
									if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocType.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
													if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
														formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
													}
												}
											}
										}
									}
								}
							}
							formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
							formObj.submit();
						} else {
							if (f_query_add_mod.MasterCodePages.document.formissuereturnsummary) {
								formObj = f_query_add_mod.MasterCodePages.document.formissuereturnsummary;
								if (isValidFromToField(formObj.p_fm_iss_st, formObj.p_to_iss_st, STRING, getLabel("Common.ReturnFromStore.label", "Common"), messageFrame)) {
									if (isValidFromToField(formObj.p_fm_iss_to_st, formObj.p_to_iss_to_st, STRING, getLabel("Common.ReturnToStore.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING,getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING,getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
													if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_doc_ref, formObj.p_to_doc_ref, STRING, getLabel("Common.DocRef.label", "Common"), messageFrame)) {
																if (isValidFromToField(formObj.p_dt_from_1, formObj.p_dt_to_1, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
												formObj.dt_from.value = convertDate(formObj.p_dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
												formObj.dt_to.value = convertDate(formObj.p_dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
													if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
													formObj.submit();}
												}
															}
														}
													}
												}
											}
										}
									}
								}
								
							} else {
								if (f_query_add_mod.MasterCodePages.document.formGRNSummary) {
									formObj = f_query_add_mod.MasterCodePages.document.formGRNSummary;
									if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
										if (isValidFromToField(formObj.dt_from, formObj.dt_to, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING,getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
													if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_supp_code, formObj.p_to_supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
																if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, getLabel("Common.DepartmentCode.label", "Common"), messageFrame)) {
																	if (isValidFromToField(formObj.p_fm_po_no, formObj.p_to_po_no, STRING, getLabel("eST.PONo.label", "ST"), messageFrame)) {
																		if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
																			formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
																			formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
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
								} else {
									if (f_query_add_mod.MasterCodePages.document.formRTVSummary) {
										formObj = f_query_add_mod.MasterCodePages.document.formRTVSummary;
										if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, LONG, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.dt_from, formObj.dt_to, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
													if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_supp_code, formObj.p_to_supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame)) {
																if (isValidFromToField(formObj.p_fm_po_no, formObj.p_to_po_no, STRING, getLabel("eST.PONo.label", "ST"), messageFrame)) {
																	if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
																		formObj.dt_from.value = convertDate(formObj.dt_from_1.value, "DMY", formObj.p_language_id.value, "en");
																		formObj.dt_to.value = convertDate(formObj.dt_to_1.value, "DMY", formObj.p_language_id.value, "en");
																		formObj.submit();
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										if (f_query_add_mod.MasterCodePages.document.formBonusSummaryReport) {
											formObj = f_query_add_mod.MasterCodePages.document.formBonusSummaryReport;
											if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, LONG, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_doc_date, formObj.p_to_doc_date, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
													if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClassCode.label", "Common"), messageFrame)) {
																if (isValidFromToField(formObj.p_fm_supp_code, formObj.p_to_supp_code, STRING, getLabel("Common.SupplierCode.label", "Common"), messageFrame)) {
																	if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
																		if (isValidFromToField(formObj.p_fm_po_no, formObj.p_to_po_no, STRING, getLabel("eST.PONo.label", "ST"), messageFrame)) {
																			formObj.p_fm_doc_date.value = convertDate(formObj.p_fm_doc_date_1.value, "DMY", formObj.p_language_id.value, "en");
																			formObj.p_to_doc_date.value = convertDate(formObj.p_to_doc_date_1.value, "DMY", formObj.p_language_id.value, "en");
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
										else if (f_query_add_mod.MasterCodePages.document.formSRRChangeBinLocation) {
											/* @Name - Priya
											* @Date - 16/06/2010
											* @Inc# - 
											* @Desc - This condition is added for the new siriraj change bin location report
											*/
											formObj = f_query_add_mod.MasterCodePages.document.formSRRChangeBinLocation;
											//Mandatory Fields Checking

												var from_date=formObj.p_date_from ;
												var to_date=formObj.p_date_to;
												var p_store_code=formObj.p_store_code ;

												var errorPage = "../../eCommon/jsp/error.jsp";
												var arrayObject = new Array(formObj.p_date_from ,formObj.p_date_to,formObj.p_store_code);
												
												var names = new Array(getLabel("Common.fromdate.label", "Common"),getLabel("Common.todate.label", "Common"),getLabel("Common.StoreCode.label", "Common"));
												var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
												if (blankObject != true) {
												return;
												}

											if (isValidFromToField(formObj.p_date_from, formObj.p_date_to, DATE, getLabel("Common.date.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_bin_loc, formObj.p_to_bin_loc, STRING, getLabel("Common.BinLocation.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
												formObj.submit();
											}
											}
											}
											}
											}
										}
										else{
											if (f_query_add_mod.MasterCodePages.document.formAcknowledgeSummaryReport) {
											formObj = f_query_add_mod.MasterCodePages.document.formAcknowledgeSummaryReport;
											if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, LONG, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_doc_date_1, formObj.p_to_doc_date_1, DATE, getLabel("Common.DocDate.label", "Common"), messageFrame)) {
													if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_iss_st, formObj.p_to_iss_st, STRING, getLabel("eST.IssuingStore.label", "st_labels"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_rec_to_st, formObj.p_to_rec_to_st, STRING, getLabel("Common.ReceivingStore.label", "Common"), messageFrame)) {
																if (isValidFromToField(formObj.p_fr_doc_type, formObj.p_to_doc_type, STRING, getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
																	if (isValidFromToField(formObj.p_fm_doc_no, formObj.p_to_doc_no, INT, getLabel("Common.DocNo.label", "Common"), messageFrame)) {
														if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
															if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClassCode.label", "Common"), messageFrame)) {
															
																
																			formObj.dt_from.value = convertDate(formObj.p_fm_doc_date_1.value, "DMY", formObj.p_language_id.value, "en");
																			formObj.dt_to.value = convertDate(formObj.p_to_doc_date_1.value, "DMY", formObj.p_language_id.value, "en");
																				
																				if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
																																									

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
	}
}
function setReportStoreId() {
	if (document.formReportStore.p_report_type.value == "1") {
		document.formReportStore.p_report_id.value = "STBSTORE";
	} else {
		document.formReportStore.p_report_id.value = "STBSTRDT";
	}
}
function setReportItemId() {
	if (document.formReportItem.p_report_type.value == "1") {
		document.formReportItem.p_report_id.value = "STBITEMS";
	} else {
		document.formReportItem.p_report_id.value = "STBITMDT";
	}
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
/* @Name - Priya
* @Date - 16/06/2010
* @Inc# - 
* @Desc - To Fetch user id.
*/
 function searchUserCode(target) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_SM_APPL_USER_USER_LOOK_UP").value;
	argumentArray[4] = "2,3";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(getLabel("Common.user.label", "Common"), argumentArray); 	
	if (retVal != null && retVal != "") {
		target.value = retVal[0];
	}
}
