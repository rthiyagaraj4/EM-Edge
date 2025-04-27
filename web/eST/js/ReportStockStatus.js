/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017		IN063889			B.Badmavathi								    Performance issue - KDAH-SCF-0415 
10/08/2018      IN068415            B.Haribabu                                      AMRI-SCF-0540
-------------------------------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.formStockStatusReportCriteria;
	formObj.p_fr_sr.disabled = true; 
	formObj.p_fr_st_code.disabled = true;
	formObj.p_to_sr.disabled = true;
	formObj.p_to_st_code.disabled = true;
	formObj.p_item_sel.disabled = false;
	formObj.p_report_order.disabled = false;
	frames[1].document.forms[0].reset();
	//parent.frames[1].frames[1].document.forms[0].reset();
	frames[1].document.getElementById("p_top_style").style.visibility = "visible";
	frames[1].document.getElementById("p_count_style").style.visibility = "visible";
	frames[1].document.getElementById("p_item_style").style.visibility = "visible";
}
function CheckForSpecialChars(event) {
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
function loadcolumn(obj,sitespecific) {//sitespecific Added for AMRI-SCF-0540 
	
	formObj = document.forms[0];
	if (obj.value == "STBSTKS1") {
		formObj.p_fr_sr.disabled = true;
		formObj.p_fr_st_code.value = "";
		formObj.p_fr_st_code.disabled = true;
		formObj.p_to_st_code.value = "";//Added for KDAH-SCF-0415
		formObj.p_to_sr.disabled = true;
		formObj.p_to_st_code.disabled = true;
		document.getElementById("fm_str_code_mnd").style.visibility="hidden";//Added for KDAH-SCF-0415 
	} else {
		formObj.p_fr_sr.disabled = false;
		formObj.p_fr_st_code.disabled = false;
		document.getElementById("fm_str_code_mnd").style.visibility="visible";//Added for KDAH-SCF-0415 
		formObj.p_to_sr.disabled = true;//Commented for KDAH-SCF-0415 
		formObj.p_to_st_code.disabled = true;//Commented for KDAH-SCF-0415 
	}
	if ((sitespecific =="true") && (obj.value == "STBSTKS5")) {
		
		formObj.p_to_sr.disabled = false;//Added for AMRI-SCF-0540 
		formObj.p_to_st_code.disabled = false;//Added for AMRI-SCF-0540
	}
	/*	if(obj.value != "STBSTKS1") {
			formObj.p_item_sel.value="AL";
			formObj.p_item_sel.disabled=true;
	}
	else
			formObj.p_item_sel.disabled=false;*/
	if ((obj.value == "STBSTKS3") || (obj.value == "STBSTKS4") || (obj.value == "STBSTKS6")) {
		formObj.p_fr_bin_loc.disabled = false;
		formObj.p_to_bin_loc.disabled = false;
	} else {
		formObj.p_fr_bin_loc.disabled = true;
		formObj.p_to_bin_loc.disabled = true;
	}
	if (obj.value == "STBSTKS1") {
		formObj.p_count.disabled = false;
	}
	if (obj.value == "STBSTKS2") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS3") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS4") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS5") {
		formObj.p_count.disabled = true;
	}
	if (obj.value == "STBSTKS6") {
		formObj.p_count.disabled = true;
	}
}
/*
function setReportType() {
	var formObject = document.formStockStatusReportCriteria;
	if (formObject.p_report_id.value == "STBSTKS1") {
		document.getElementById("p_top_style").style.visibility = "visible";
		document.getElementById("p_count").style.visibility = "visible";
		document.getElementById("p_count_style").style.visibility = "visible";
		document.getElementById("p_item_style").style.visibility = "visible";
	} else {
		document.getElementById("p_top_style").style.visibility = "hidden";
		document.getElementById("p_count").style.visibility = "hidden";
		document.getElementById("p_count_style").style.visibility = "hidden";
		document.getElementById("p_item_style").style.visibility = "hidden";
	}
}*/
function setReportType() {
    var formObject = document.formStockStatusReportCriteria;
    
    var p_top_style = document.getElementById("p_top_style");
    var p_count = document.getElementById("p_count");
    var p_count_style = document.getElementById("p_count_style");
    var p_item_style = document.getElementById("p_item_style");
    
    if (formObject.p_report_id.value == "STBSTKS1") {
        if (p_top_style) p_top_style.style.visibility = "visible";
        if (p_count) p_count.style.visibility = "visible";
        if (p_count_style) p_count_style.style.visibility = "visible";
        if (p_item_style) p_item_style.style.visibility = "visible";
    } else {
        if (p_top_style) p_top_style.style.visibility = "hidden";
        if (p_count) p_count.style.visibility = "hidden";
        if (p_count_style) p_count_style.style.visibility = "hidden";
        if (p_item_style) p_item_style.style.visibility = "hidden";
    }
}

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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchCodeStore(obj,obj1) {//Added obj1 for KDAH-SCF-0415 
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
	//argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	var sql = "SELECT    DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE ? AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+document.forms[0].p_user_name.value+"') AND C.STORE_CODE = E.STORE_CODE";
	argumentArray[0] = encodeURIComponent(sql)+" ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
		obj1.value = arr[0];//Added for KDAH-SCF-0415 
	}
}
async function searchCodeItemClass(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchAlphaCode(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
async function searchSterileType(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function setValue() {
	if (document.formStockStatusReportCriteria.p_count.value != "") {
		document.formStockStatusReportCriteria.p_report_order.selectedIndex = 2;
	}
}
function setReportOrder() {
	document.formStockStatusReportCriteria.p_report_order.disabled = false;
	document.formStockStatusReportCriteria.p_report_order.selectedIndex = 0;
	document.formStockStatusReportCriteria.p_count.value = "";
}

function run() {
	if (f_query_add_mod.document.formStockStatusReportCriteria) {
		formObj = f_query_add_mod.document.formStockStatusReportCriteria;
		//Added for KDAH-SCF-0415 starts
		if (formObj.p_report_id.value != "STBSTKS1") {
			var p_fr_str_code = formObj.p_fr_st_code.value;
			//var p_to_str_code = formObj.p_to_st_code.value;
		    if(p_fr_str_code==""){
			  alert(getMessage("STORE_CANNOT_BE_BLANK", "ST"));
			  formObj.p_fr_st_code.focus();
				return;
			} 
		}
		//Added for KDAH-SCF-0415 ends 
		if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_unit_cost, formObj.p_to_unit_cost, INT,getLabel("Common.UnitCost.label", "Common") , messageFrame)) {
							if (isValidFromToField(formObj.p_fr_st_val, formObj.p_to_st_val, INT, getLabel("eST.StockValue.label", "ST"), messageFrame)) {
								if (isValidFromToField(formObj.p_fr_bin_loc, formObj.p_to_bin_loc, STRING,getLabel("Common.BinLocation.label", "Common"), messageFrame)) {
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
/*		else if(f_query_add_mod.MasterCodePages.document.formReportItem)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItem;
		
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item", messageFrame)) 
			 if (isValidFromToField(formObj.p_fm_alpha_code, formObj.p_to_alpha_code, STRING, "Alpha Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, "Item Class", messageFrame)) 
				if (isValidFromToField(formObj.p_fm_machine_code, formObj.p_to_machine_code, STRING, "Machine Code", messageFrame))  
				  if (isValidFromToField(formObj.p_fm_model_no, formObj.p_to_model_no, STRING, "Model Number", messageFrame)) 
				    if (isValidFromToField(formObj.p_fm_part_no, formObj.p_to_part_no, STRING, "Part Number", messageFrame)) 
				      formObj.submit();
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, "Department", messageFrame)) 
				formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportItemForStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItemForStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item Code", messageFrame)) 
				formObj.submit();
			
		}
       	else if(f_query_add_mod.MasterCodePages.document.formReportItemClassForStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItemClassForStore;
		
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store Code", messageFrame)) 
			  if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, "Item Class Code", messageFrame)) 
				formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportPrepareLocation)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportPrepareLocation;
		
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Prepare Location", messageFrame)) 
			  formObj.submit();
			
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportTrnDocType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportTrnDocType;
		
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Doc Type Code", messageFrame)) 
			  formObj.submit();
			
		}
}  */
function setReportStoreId() {
	if (document.formReportStore.p_report_type.value == "IC") {
		document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS1";
	} else {
		if (document.formStockStatusReportCriteria.p_report_type.value == "BI") {
			document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS2";
		} else {
			if (document.formStockStatusReportCriteria.p_report_type.value == "BS") {
				document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS3";
			} else {
				if (document.formStockStatusReportCriteria.p_report_type.value == "IB") {
					document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS4";
				} else {
					if (document.formStockStatusReportCriteria.p_report_type.value == "SB") {
						document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS5";
					} else {
						if (document.formStockStatusReportCriteria.p_report_type.value == "BL") {
							document.formStockStatusReportCriteria.p_report_id.value = "STBSTKS6";
						}
					}
				}
			}
		}
	}
}
function setReportItemId() {
	if (document.formReportItem.p_report_type.value == "1") {
		document.formReportItem.p_report_id.value = "STBITEMS";
	} else {
		document.formReportItem.p_report_id.value = "STBITMDT";
	}
}

