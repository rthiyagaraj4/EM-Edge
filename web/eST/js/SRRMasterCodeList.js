
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	//frames[1].frames[1].reset();
	frames[1].frames[1].document.forms[0].reset();
	// parent.frames[1].frames[1].frames[1].document.forms[0].reset();
}
function loadPage() {
//alert(parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value);
	parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_MACHINE") {
		parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportMachine.jsp";
	} else {
		if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ITEM") {
			parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRReportItem.jsp";
		} else {
			if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_STORE") {
				parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportStore.jsp";
			} else {
				if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ITEM_STORE") {
					parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRItemForStore.jsp";
				} else {
					if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ASSEMBLY_DTL") {
						parent.MasterCodePages.document.location.href = "../../eST/jsp/AssemblyDetailsList.jsp";
					} else {
						if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ITEM_CLASS_STORE") {
							parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportItemClassForStore.jsp";
						} else {
							if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_PREPARE_LOCATION") {
								parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportPrepareLocation.jsp";
							} else {
								if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ITEM_FOR_STORE") {
									parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportPrepareLocation.jsp";
								} else {
									if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ITEM_STORE_BIN") {
										parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportItemStoreBinLocation.jsp";
									} else {
										if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_STORE_PARENT_STORE") {
									parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRParentStoreForStore.jsp";
								} else {
										if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_TRN_DOC_TYPE") {
											parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportTrnDocType.jsp";
										} else {
											if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_REPACKING_GROUP") {
												parent.MasterCodePages.document.location.href = "../../eST/jsp/ReportRepackingGroup.jsp";
											} else {
												if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_ASSEMBLY_INSTRN") {
												parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRAssemblyInstruction.jsp";
											} else {

                                                  if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_TRN_TYPE_FOR_REMARKS") {
												parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRReportTransactionRemarks.jsp";
												  }else{
													   if (parent.MasterCodeListFrame.document.formMasterCodeList.master_code.value == "ST_DIR_SALE_PATIENT_PARAM") {
												parent.MasterCodePages.document.location.href = "../../eST/jsp/SRRDirectSalesPatient.jsp";
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
function searchMachineCode(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	/*dataNameArray  [0]="language_id"
	dataValueArray [0]=document.forms[0].p_language_id.value;
	dataTypeArray   [0]=STRING;*/
	var sql = escape("SELECT MACHINE_CODE CODE, MACHINE_NAME DESCRIPTION FROM ST_MACHINE_LANG_VW ST_MACHINE    WHERE  UPPER(ADDED_FACILITY_ID) LIKE  UPPER(?)  AND  UPPER(MACHINE_CODE) LIKE\t UPPER(?)  AND  UPPER(MACHINE_NAME) LIKE UPPER(?) AND LANGUAGE_ID =");
	argumentArray[0] = sql + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eST.MachineCode.label", "ST"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
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
function searchAssemblyCodeItem(obj) {
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
	argumentArray[0] = document.getElementById("SQL_ST_ASSEMBLY_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eST.AssemblyItemCode.label", "ST"), argumentArray);
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
	/*argumentArray[0] =
	"SELECT	  st.store_code	   code,        mm.short_desc	     description	    FROM     mm_store_lang_vw    mm, st_store st  WHERE       language_id  like  ?    AND mm.facility_id  LIKE(?)   AND    UPPER(st.store_code)	LIKE upper(?)     AND   UPPER(mm.short_desc)          LIKE	   UPPER(?)   and  mm.store_code = st.store_code "	 */
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP_FOR_REPORT").value;
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
	var sql_1 = "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'spl','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'spl','2') LIKE UPPER(?) ORDER BY 1";
	var sql_2 = sql_1.replace(/spl/, document.formReportStore.p_language_id.value);
	var sql_3 = sql_2.replace(/spl/, document.formReportStore.p_language_id.value);
	argumentArray[0] = sql_3;
//	argumentArray[0] = document.getElementById("SQL_ST_DEPT_LOOKUP").value;
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
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT").value + "'" + document.forms[0].p_language_id.value + "'";
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
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ALPHA_LOOKUP").value;
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
function searchSterileType(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT STERILE_TYPE CODE,SHORT_DESC DESCRIPTION  FROM  SS_STERILIZATION_TYPE \tWHERE    UPPER(STERILE_TYPE)  LIKE UPPER(?)  AND  UPPER(SHORT_DESC)\tLIKE UPPER(?)";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.SterileType.label", "Common"), argumentArray);
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
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_PREPARE_LOCATION_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.PrepareLocation.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeRepackLocation(obj) {
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
	argumentArray[0] = document.getElementById("SQL_ST_REPACK_LOCATION_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.RepackingGroup.label", "Common"), argumentArray);
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
	returnedValues = CommonLookup(getLabel("Common.TRNdoctype.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchManuId(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	var sql = escape("SELECT DISTINCT AM.MANUFACTURER_ID	CODE, AM.SHORT_NAME	DESCRIPTION	 FROM  AM_MANUFACTURER_LANG_VW AM,ST_MACHINE ST	WHERE ST.MANUFACTURER_ID=AM.MANUFACTURER_ID	 AND UPPER(ST.ADDED_FACILITY_ID) LIKE	UPPER(?) AND UPPER(AM.MANUFACTURER_ID) LIKE	UPPER(?) AND UPPER(AM.SHORT_NAME) LIKE UPPER(?) AND AM.LANGUAGE_ID = ");
	argumentArray[0] = sql + "'" + document.forms[0].p_language_id.value + "' ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Manufacturer.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	if (f_query_add_mod.MasterCodePages.document.formReportMachine) {
		formObj = f_query_add_mod.MasterCodePages.document.formReportMachine;
		if (isValidFromToField(formObj.P_fm_code, formObj.P_to_code, STRING, getLabel("eST.MachineCode.label", "ST"), messageFrame)) {
			if (isValidFromToField(formObj.P_fm_manu_id, formObj.P_to_manu_id, STRING, getLabel("Common.ManufacturerID.label", "Common"), messageFrame)) {
				formObj.submit();
			}
		}
	} else {
		if (f_query_add_mod.MasterCodePages.document.formReportItem) {
			formObj = f_query_add_mod.MasterCodePages.document.formReportItem;
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				//if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
				//	if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					//	if (isValidFromToField(formObj.p_fm_machine_code, formObj.p_to_machine_code, STRING, getLabel("eST.MachineCode.label", "ST"), messageFrame)) {
						//	if (isValidFromToField(formObj.p_fm_model_no, formObj.p_to_model_no, STRING, "Model Number", messageFrame)) {
							//	if (isValidFromToField(formObj.p_fm_part_no, formObj.p_to_part_no, STRING, getLabel("eST.PartNumber.label", "ST"), messageFrame)) {
									formObj.submit();
							//	}
							//}
						//}
					//}
				//}
			}
		} else {
			if (f_query_add_mod.MasterCodePages.document.formReportStore) {
				formObj = f_query_add_mod.MasterCodePages.document.formReportStore;
				if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.Store.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, getLabel("Common.department.label", "Common"), messageFrame)) {
						formObj.submit();
					}
				}
			} else {
				if (f_query_add_mod.MasterCodePages.document.formReportItemForStore) {
					formObj = f_query_add_mod.MasterCodePages.document.formReportItemForStore;
					if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
							formObj.submit();
						}
					}
				} else {
					if (f_query_add_mod.MasterCodePages.document.formAssemblyDetails) {
						formObj = f_query_add_mod.MasterCodePages.document.formAssemblyDetails;
						if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("eST.AssemblyItemCode.label", "ST"), messageFrame)) {
							formObj.submit();
						}
					} else {
						if (f_query_add_mod.MasterCodePages.document.formReportItemClassForStore) {
							formObj = f_query_add_mod.MasterCodePages.document.formReportItemClassForStore;
							if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
								if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClassCode.label", "Common"), messageFrame)) {
									formObj.submit();
								}
							}
						} else {
							if (f_query_add_mod.MasterCodePages.document.formReportPrepareLocation) {
								formObj = f_query_add_mod.MasterCodePages.document.formReportPrepareLocation;
								if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, getLabel("Common.PrepareLocation.label", "Common"), messageFrame)) {
									formObj.submit();
								}
							} else {
								if (f_query_add_mod.MasterCodePages.document.formReportTrnDocType) {
									formObj = f_query_add_mod.MasterCodePages.document.formReportTrnDocType;
									if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING,getLabel("Common.DocTypeCode.label", "Common"), messageFrame)) {
										formObj.submit();
									}
								} else {
									if (f_query_add_mod.MasterCodePages.document.formReportItemStoreBinLocation) {
										formObj = f_query_add_mod.MasterCodePages.document.formReportItemStoreBinLocation;
										if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
											if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
												if (isValidFromToField(formObj.p_fm_bin_location_code, formObj.p_to_bin_location_code, STRING, getLabel("Common.BinLocation.label", "Common"), messageFrame)) {
													formObj.submit();
												}
											}
										}
									} else {
										if (f_query_add_mod.MasterCodePages.document.formReportRepackingGroup) {
											formObj = f_query_add_mod.MasterCodePages.document.formReportRepackingGroup;
											if (isValidFromToField(formObj.p_fm_repacking_location, formObj.p_to_repacking_location, STRING, getLabel("Common.RepackingGroup.label", "Common"), messageFrame)) {
												formObj.submit();
											}
										}
										else{
											if(f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks) {
												formObj=f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks;
	                                          if (isValidFromToField(formObj.p_fm_trn_type_code, formObj.p_to_trn_type_code, STRING, getLabel("Common.transactiontype.label", "Common") + getLabel("Common.code.label", "Common"), messageFrame)) {											
	                                          if (isValidFromToField(formObj.P_FM_trn_remarks_code, formObj.P_TO_trn_remarks_code, STRING, getLabel("Common.TransactionRemarks.label", "Common"), messageFrame)) {											
													formObj.submit();
											     }
									         	}

											}else{

												if (f_query_add_mod.MasterCodePages.document.formAssemblyInstruction) {
											formObj = f_query_add_mod.MasterCodePages.document.formAssemblyInstruction;
											if (isValidFromToField(formObj.p_fm_inst, formObj.p_to_inst, STRING, getLabel("eST.AssemblyInstruction.label", "ST"), messageFrame)) {
												formObj.submit();
											}
												}else{
													if (f_query_add_mod.MasterCodePages.document.formDirectSalesPatient) {
											formObj = f_query_add_mod.MasterCodePages.document.formDirectSalesPatient;
											if (isValidFromToField(formObj.patient_idfr, formObj.patient_idto, STRING, getLabel("Common.patientId.label", "Common"), messageFrame)) {
												formObj.submit();
													}
																				

											
											}
											else{
											if (f_query_add_mod.MasterCodePages.document.formParentStoreForStore) {
											formObj = f_query_add_mod.MasterCodePages.document.formParentStoreForStore;
											if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
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
function searchBinLocation(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_MM_BIN_LOCATION_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.BinLocation.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}

function searchCodeRemarks(objCode,objDesc) {

	objCode_value = "";
	objDesc_value = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id" ;
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING ;
	dataNameArray[2] = "trn_type" ;
	dataValueArray[2] = "ADJ";
	dataTypeArray[2] = STRING ;

	argumentArray[0] = document.getElementById("SQL_MM_TRN_REMARKS_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.remarks.label","Common") , argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		
	} 
}
function searchtranstypecode(obj) {

	
    var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT TL.TRN_TYPE CODE,TL.SHORT_DESC DESCRIPTION FROM ST_TRN_TYPE T,ST_TRN_TYPE_LANG_VW TL WHERE T.TRN_TYPE LIKE UPPER(?) AND UPPER(T.SHORT_DESC) LIKE UPPER(?) AND TL.TRN_TYPE=T.TRN_TYPE AND TL.LANGUAGE_ID =";
	argumentArray[0] = sql + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	returnedValues = CommonLookup(getLabel("Common.transactiontype.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function callPatientSearch()
{
	var patient_id	=	document.forms[0].patient_idto;
	var retun_value =	"";

	return_value	=	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

function callPatientSearchFrom()
{
	var patient_id	=	document.forms[0].patient_idfr;
	var retun_value =	"";

	return_value	=	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}
function searchCodeInstruction(obj) {
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
	var sql = "SELECT	AL.INSTRN_CODE code,AL. INSTRN_TEXT	description	 FROM ST_ASSEMBLY_INSTRN A,ST_ASSEMBLY_INSTRN_LANG_VW   AL  WHERE  AL.LANGUAGE_ID  LIKE ? AND	A.INSTRN_CODE  LIKE UPPER(?) AND UPPER(A.INSTRN_TEXT)	LIKE UPPER(?) AND AL.INSTRN_CODE = A.INSTRN_CODE  AND A.EFF_STATUS = 'E'  ";
	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eMM.AssemblyInstructions.label", "mm_labels"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
