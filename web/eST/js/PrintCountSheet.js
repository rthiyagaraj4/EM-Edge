/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
9/7/2021				TFS-21260      		     Shazana           	     									ST-GHL-CRF-0640.7-TF-US001/01 - Sales Return
--------------------------------------------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	f_query_add_mod.location.reload();
}
function loadcolumn() {
	formObj = document.forms[0];
	var obj = document.forms[0].p_report_mode;
	if (obj.value == "A") {
		formObj.p_fm_item_code.disabled = true;
		formObj.p_to_item_code.disabled = true;
		//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		formObj.p_fm_bin_code.disabled = true;
		formObj.p_to_bin_code.disabled = true;
		formObj.p_fm_bin.disabled = true;
		formObj.p_to_bin.disabled = true;
		//Added ends
		formObj.p_to_sr2.disabled = true;
		formObj.p_fm_sr2.disabled = true;
		formObj.p_fm_item_class.disabled = true;
		formObj.p_fm_b_class.disabled = true;
		formObj.p_to_item_class.disabled = true;
		formObj.p_to_b_class.disabled = true;
		formObj.p_fr_alp_code.disabled = true;
		formObj.p_to_alp_code.disabled = true;
		formObj.p_fr_unit_cost.disabled = true;
		formObj.p_to_unit_cost.disabled = true;
		formObj.p_fr_st_val.disabled = true;
		formObj.p_to_st_val.disabled = true;
		formObj.p_fr_phy_inv.disabled = true;
		formObj.p_phy_sel.disabled = true;
		formObj.p_phy_count_sel.disabled = true;		
		formObj.p_expiry_sel.disabled = true;
		formObj.p_report_id1.disabled = true;
		formObj.p_item_anal1.disabled = true;
		formObj.p_item_anal3.disabled = true;
		formObj.p_item_anal2.disabled = true;
		formObj.p_abc_sel.disabled = true;
		formObj.p_fm_item_code.value = "";
		formObj.p_to_item_code.value = "";
		formObj.p_fm_bin_code.value = "";	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		formObj.p_to_bin_code.value = "";	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		formObj.p_fm_item_class.value = "";
		formObj.p_to_item_class.value = "";
		formObj.p_fr_alp_code.value = "";
		formObj.p_to_alp_code.value = "";
		formObj.p_fr_unit_cost.value = "";
		formObj.p_to_unit_cost.value = "";
		formObj.p_fr_st_val.value = "";
		formObj.p_to_st_val.value = "";
		formObj.p_fr_phy_inv.value = "";
		formObj.p_phy_sel.value = formObj.p_phy_sel.options[0].value;
		formObj.p_phy_count_sel.value = formObj.p_phy_count_sel.options[0].value;		
		formObj.p_expiry_sel.value = formObj.p_expiry_sel.options[0].value;
		formObj.p_report_id1.value = formObj.p_report_id1.options[0].value;
		formObj.p_item_anal1.value = formObj.p_item_anal1.options[0].value;
		formObj.p_item_anal3.value = formObj.p_item_anal3.options[0].value;
		formObj.p_item_anal2.value = formObj.p_item_anal2.options[0].value;
		formObj.p_abc_sel.value = formObj.p_abc_sel.options[0].value;

		formObj.p_fr_month.disabled = true;
		formObj.p_fr_year.disabled = true;
		formObj.p_to_month.disabled = true;
		formObj.p_to_year.disabled = true;
		formObj.p_slow_fast_move.disabled = true;
		formObj.p_count.disabled = true;
		formObj.p_order_by_qty_value.disabled = true;
		formObj.p_fr_month.value = "";
		formObj.p_fr_year.value = "";
		formObj.p_to_month.value = "";
		formObj.p_to_year.value = "";
		formObj.p_count.value = "";
		formObj.p_slow_fast_move.value = formObj.p_slow_fast_move.options[0].value;
		document.getElementById("mandatory_img_from").style.visibility = "hidden";
		document.getElementById("mandatory_img_count").style.visibility = "hidden";



	} else {
		formObj.p_fm_item_code.disabled = false;
		formObj.p_to_item_code.disabled = false;
		//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
		formObj.p_fm_bin_code.disabled = false;
		formObj.p_to_bin_code.disabled = false;
		formObj.p_fm_bin.disabled = false;
		formObj.p_to_bin.disabled = false;
		//Added ends
		formObj.p_to_sr2.disabled = false;
		formObj.p_fm_sr2.disabled = false;
		formObj.p_fm_item_class.disabled = false;
		formObj.p_fm_b_class.disabled = false;
		formObj.p_to_item_class.disabled = false;
		formObj.p_to_b_class.disabled = false;
		formObj.p_fr_alp_code.disabled = false;
		formObj.p_to_alp_code.disabled = false;
		formObj.p_fr_unit_cost.disabled = false;
		formObj.p_to_unit_cost.disabled = false;
		formObj.p_fr_st_val.disabled = false;
		formObj.p_to_st_val.disabled = false;
		formObj.p_fr_phy_inv.disabled = false;
		formObj.p_phy_sel.disabled = false;
		formObj.p_phy_count_sel.disabled = false;		
		formObj.p_expiry_sel.disabled = false;
		formObj.p_report_id1.disabled = false;
		formObj.p_item_anal1.disabled = false;
		formObj.p_item_anal3.disabled = false;
		formObj.p_item_anal2.disabled = false;
		formObj.p_abc_sel.disabled = false;

		formObj.p_fr_month.disabled = false;
		formObj.p_fr_year.disabled = false;
		formObj.p_to_month.disabled = false;
		formObj.p_to_year.disabled = false;
		formObj.p_slow_fast_move.disabled = false;
		formObj.p_count.disabled = false;
		formObj.p_order_by_qty_value.disabled = false;

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
	//var sql = "SELECT DISTINCT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW MM, ST_ITEM ST, ST_ITEM_STORE STSTR,ST_ITEM_TRN_DTL TRN WHERE STSTR.STOCK_ITEM_YN = 'Y' AND MM.EFF_STATUS = 'E' AND STSTR.STORE_CODE = '"+document.forms[0].p_fr_st_code.value+"' AND ST.ITEM_CODE LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND ST.ITEM_CODE = MM.ITEM_CODE AND STSTR.PHY_INV_ID IS NULL AND STSTR.ITEM_CODE = ST.ITEM_CODE AND MM.LANGUAGE_ID = '" + document.forms[0].p_language_id.value + "'AND TRN.ITEM_CODE = STSTR.ITEM_CODE AND TRN.STORE_CODE = STSTR.STORE_CODE";
	//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
	var sql = "SELECT DISTINCT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW MM, ST_ITEM ST, ST_ITEM_STORE STSTR,ST_ITEM_TRN_DTL TRN,ST_ITEM_STORE_BIN_LOCN ITSBN WHERE STSTR.STOCK_ITEM_YN = 'Y' AND MM.EFF_STATUS = 'E' AND STSTR.STORE_CODE = '"+document.forms[0].p_fr_st_code.value+"' AND ST.ITEM_CODE LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND ST.ITEM_CODE = MM.ITEM_CODE AND STSTR.PHY_INV_ID IS NULL AND STSTR.ITEM_CODE = ST.ITEM_CODE AND MM.LANGUAGE_ID = '" + document.forms[0].p_language_id.value + "'AND TRN.ITEM_CODE = STSTR.ITEM_CODE AND TRN.STORE_CODE = STSTR.STORE_CODE AND ITSBN.ITEM_CODE = STSTR.ITEM_CODE AND ITSBN.STORE_CODE = STSTR.STORE_CODE AND ITSBN.BIN_LOCATION_CODE BETWEEN NVL (UPPER ('"+document.forms[0].p_fm_bin_code.value+"'), '!') AND NVL (UPPER ('"+document.forms[0].p_to_bin_code.value+"'), '~')";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
//Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220
async function searchBinCode(obj) {

	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT DISTINCT st.bin_location_code CODE,mm.SHORT_DESC DESCRIPTION FROM  st_item_store_bin_locn st, mm_bin_location_lang_vw mm,  st_item_store ststr WHERE   ststr.stock_item_yn = 'Y'  and ststr.store_code = '"+document.forms[0].p_fr_st_code.value+"' AND st.bin_location_code LIKE UPPER (?) AND UPPER (mm.SHORT_DESC) LIKE UPPER (?) and st.bin_location_code=mm.bin_location_code AND   ststr.phy_inv_id IS NULL  AND  st.store_code=mm.store_code AND st.store_code = ststr.store_code  AND st.item_code = ststr.item_code AND mm.LANGUAGE_ID = '" + document.forms[0].p_language_id.value + "' AND st.eff_status='Y'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.BinLocation.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
//Added ends
async function searchCodeStore(obj, obj1) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql_1 = "SELECT st.store_code code, mm.short_desc description FROM mm_store_lang_vw mm, st_store st,st_user_access_for_store uas " +
			"WHERE mm.facility_id = '"+document.forms[0].p_facility_id.value+"' AND mm.eff_status = 'E' AND UPPER (st.store_code) LIKE UPPER (?)   AND UPPER (mm.short_desc) LIKE UPPER (?)  AND mm.store_code = st.store_code  and st.store_code = uas.store_code  AND uas.var_allowed_yn = 'Y'  " + "  AND mm.language_id='" + document.forms[0].p_language_id.value +"' and  uas.user_id='" + document.forms[0].p_user_name.value +  "' ORDER BY 2";//modified for 23594 
	//dataNameArray[0] = "facility_id";
	//dataValueArray[0] = document.forms[0].p_facility_id.value;
	//dataTypeArray[0] = STRING;
	argumentArray[0] = sql_1;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
		obj1.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		obj1.value = returnedValues[0];
	} */
}
/*function searchCodeStore( objCode ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
/*	var sql_1="SELECT st.store_code code,  mm.short_desc  description  FROM  mm_store_lang_vw mm, st_store st   WHERE  	mm.eff_status ='E'	  AND   mm.facility_id    LIKE(?)  and   UPPER(st.store_code)    LIKE	    UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND   mm.store_code=st.store_code    AND mm.language_id='"+document.forms[0].language_id.value+"'   order  by  2";
var sql_1="SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st   WHERE       mm.facility_id       LIKE     (?)    	AND    mm.eff_status ='E'	  AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code" + "    AND mm.language_id='"+document.forms[0].language_id.value+"'  ";
	//var sql=document.getElementById("SQL_ST_STORE_LOOKUP_LANG").value/*+"   AND mm.language_id='"+document.forms[0].language_id.value+"'   order by 2"; 
	alert("sql--> "+sql_1);
	//argumentArray[0] = unescape(sql_1);
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  =document.forms[0].p_facility_id.value;

	dataTypeArray[0] = STRING;
	argumentArray[0] = unescape(sql_1);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			objCode.value = returnedValues[0];
		}
	}
*/
/*function searchCodeStore( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql=document.getElementById("SQL_ST_ITEM_LOOKUP_LANG").value+"   AND mm.language_id='"+document.forms[0].language_id.value+"'   order by 2";
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  =document.forms[0].p_facility_id.value;
	alert("1-->"+sql);
	//dataTypeArray[0] = STRING;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";

	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = CommonLookup( "Store", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
async function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql_1 = "SELECT ITEM_CLASS_CODE CODE,SHORT_DESC DESCRIPTION FROM MM_ITEM_CLASS_LANG_VW MM_ITEM_CLASS WHERE EFF_STATUS='E' AND UPPER(ITEM_CLASS_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND LANGUAGE_ID= " + "'" + document.getElementById("p_language_id").value + "'";//modified for 23594
	argumentArray[0] = sql_1;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
/*
function searchCodeItemClass( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item Class", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
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
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.document.formPrintCountSheetReportCriteria;
	result = false;
	var fields = new Array(formObj.p_fr_st_code);
	var names = new Array(getLabel("Common.StoreCode.label", "Common"));
	var blankObject = checkSTFields(fields, names, messageFrame);
	
	if(f_query_add_mod.document.getElementById("p_fr_month").style.visibility == "visible"){
	
		if(!checkMonYear()) {
			return;
		}
		if(formObj.p_count.value=="" || parseInt(formObj.p_count.value)==0){
			formObj.p_count.focus();
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("NO_OF_ITEM_CANNOT_BE_BLANK_OR_ZERO", "ST");
			return;
		}
	}

	
	if (blankObject != true) {
		return;
	}


	if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_bin_code, formObj.p_to_bin_code, STRING, getLabel("Common.BinLocation.label", "Common"), messageFrame)) {
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_unit_cost, formObj.p_to_unit_cost, DOUBLE, getLabel("Common.UnitCost.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fr_st_val, formObj.p_to_st_val, DOUBLE, getLabel("eST.StockValue.label", "ST"), messageFrame)) {
							var resultText = formApply(formObj, ST_CONTROLLER);
							//alert(resultText);
							eval(resultText);
							messageFrame.location.href = errorPage + "?err_num=" + message;
							if (result) {
								formObj.p_phy_inv_id.value = flag;
								formObj.mode.value = "BITMAP";
								formObj.action="../../eCommon/jsp/report_options.jsp";
								formObj.target="messageFrame";
								formObj.submit();
								formObj.mode.value = "1";
							} else {
								if(flag=="norecord"){
									messageFrame.location.href = errorPage + "?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
								}else{
									messageFrame.location.href = errorPage + "?err_num=" + getMessage("VALUE_NOT_FOUND_FOR_REPORT", "ST");

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
function setReportItemId() {
	/*formObj = document.forms[0];
	formObj.p_report_id.value = formObj.p_report_id1.options.value;*/
	formObj = document.forms[0];	
	var report_id = document.getElementById("p_report_id1");
	var report_id_Value ;
	for(var j=0; j<report_id.options.length; j++)
	{
		if(report_id.options[j].selected)
			report_id_Value=report_id.options[j].value;
	}
	formObj.p_report_id.value = report_id_Value;
}

function changeVisibility() {
	var formObject = document.formPrintCountSheetReportCriteria;
	if (formObject.p_slow_fast_move.value != "") {
		document.getElementById("mandatory_img_from").style.visibility = "visible";
		//document.getElementById("mandatory_img_to").style.visibility = "visible";
		document.getElementById("mandatory_img_count").style.visibility = "visible";
		formObject.p_fr_month.value = formObject.curr_proc_month.value;
		formObject.p_to_month.value = formObject.curr_proc_month.value;
		formObject.p_fr_year.value = formObject.curr_proc_year.value;
		formObject.p_to_year.value = formObject.curr_proc_year.value;
	} else {
		document.getElementById("mandatory_img_from").style.visibility = "hidden";
		//document.getElementById("mandatory_img_to").style.visibility = "hidden";
		document.getElementById("mandatory_img_count").style.visibility = "hidden";
		formObject.p_fr_month.value = "";
		formObject.p_to_month.value = "";
		formObject.p_fr_year.value = "";
		formObject.p_to_year.value = "";
	}	
}
function changeToPeriod() {
	var formObject = document.formPrintCountSheetReportCriteria;
	if (formObject.p_slow_fast_move.value != "") {
		
		if(formObject.p_to_month.value == "")
			formObject.p_to_month.value = formObject.curr_proc_month.value;

		if(formObject.p_to_year.value == "")
			formObject.p_to_year.value = formObject.curr_proc_year.value;

	}	
}
function formatNumber(number, length) {
	var returnNumber = "" + number;
	if (isNaN(returnNumber)) {
		returnNumber = "0";
	}
	var numberLength = length - returnNumber.length;
	for (i = 0; i < numberLength; i++) {
		returnNumber = "0" + returnNumber;
	}
	return returnNumber;
}
function checkMonYear() {
	formObj = frames[1].document.forms[0];
	var p_fm_year = formObj.p_fr_year.value;
	var p_to_year = formObj.p_to_year.value;
	var p_fm_month = formObj.p_fr_month.value;
	var p_to_month = formObj.p_to_month.value;
	var sysDate = formObj.sysdate.value;
	var sysDateArray = sysDate.split("/");
	var curr_proc_year = sysDateArray[2];//formObj.curr_proc_year.value;
	var curr_proc_month = sysDateArray[1];//formObj.curr_proc_month.value;
	var fromPeriod = parseFloat(formatNumber(p_fm_year, 4) + formatNumber(p_fm_month, 2));
	var toPeriod = parseFloat(formatNumber(p_to_year, 4) + formatNumber(p_to_month, 2));
	var currPeriod = parseFloat(formatNumber(curr_proc_year, 4) + formatNumber(curr_proc_month, 2));
	if ((formObj.p_fr_year.value.length != 4) || (formObj.p_to_year.value.length != 4)) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_PERIOD_MONTH_YEAR", "ST");
		return false;
	} else {
		if ((formObj.p_fr_month.value > 12) || (formObj.p_to_month.value > 12) || (formObj.p_fr_month.value < 1) || (formObj.p_to_month.value < 1)) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("INVALID_PERIOD_MONTH_YEAR", "ST");
			return false;
		} else {
			if (fromPeriod > toPeriod) {
				var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
				stMessage = stMessage.replace(/@/g, "Month/Year");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
				return false;
			} else {
				if (toPeriod > currPeriod) {
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("DATE_NOT_GREATER_SYSDATE", "ST");
					return false;
				}
			}
		}
	}
	return true;
}
