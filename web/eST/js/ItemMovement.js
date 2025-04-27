var headTop = -1;
var FloatHead;
var FloatHead1;
function reset() {
	f_query_add_mod.location.reload();
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ItemMovementFrame.jsp";
}
async function searchStoreCode(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = " SELECT  a.store_code CODE, b.short_desc DESCRIPTION FROM st_store a, mm_store_lang_vw b WHERE a.store_code =b.store_code AND b.eff_status='E' AND b.language_id like (?) AND b.facility_id like (?) AND a .STORE_CODE LIKE UPPER(?) AND UPPER(b.SHORT_DESC) LIKE UPPER(?)  ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value.toUpperCase();
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
    }
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
		document.forms[0].store_desc.value= returnedValues[1];

	}*/
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
	argumentArray[0] = document.getElementById('SQL_ST_ITEM_CLASS_LOOKUP_LANG').value + "'" + document.forms[0].p_language_id.value + "'";
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
	}*/
}

async function searchItemCode(objCode, objDesc) {
	var search_string = "";
	if (!document.StockStatusByStoreCriteria_form.item_desc.readOnly) {
		search_string = document.StockStatusByStoreCriteria_form.item_desc.value;
	}
	var store_code = "";//parent.parent.frameSalesHeader.formSalesHeader.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (retVal != null) {
		document.StockStatusByStoreCriteria_form.item_code.value = retVal[0];
		document.StockStatusByStoreCriteria_form.item_desc.value = retVal[1];
	}
	
}
function searchResults(frmObj) { 
		//if(frmObj.item_code.value=="")
		//{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if ((frmObj.item_desc.value == "" && frmObj.item_class.value == "" && frmObj.query_type.value == "summary") || (frmObj.item_code.value == "" && frmObj.item_class.value == "" && frmObj.query_type.value == "summary")) {
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("ITEM_OR_ITEM_CLASS_MANDATORY", "ST");
		return;
	}

		//}
	var item_desc = frmObj.item_desc.value;
	var store_code = frmObj.store_code.value;
	var item_code = frmObj.item_code.value;
	var item_class = frmObj.item_class.value;
	var query_type = frmObj.query_type.value;
	var result_criteria = frmObj.result_criteria.value;
	var from_year = frmObj.from_year.value;
	var from_month = frmObj.from_month.value;
	var to_year = frmObj.to_year.value;
	var to_month = frmObj.to_month.value;
	var stock_item = frmObj.stock_item.value;
	var trn_type = frmObj.trn_type.value;
	var stock_inflow_outflow = frmObj.stock_inflow_outflow.value;
	var total_show = "";
	
	if ((frmObj.query_type.value == "detail") && (item_desc == "" | store_code == "")) {
		var arrayObject = new Array(frmObj.item_desc, frmObj.store_code);
		var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.StoreCode.label", "Common"));
		var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
		if (blankObject != true) {
//		blankObject.focus();
			return;
		}
	}
	
	if (from_month > 12 || to_month > 12) {
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MONTH_IS_GR_12", "Common");
		return;
	}
	if (from_month.length != 2) {
		from_month = "0" + from_month;
	}
	if (to_month.length != 2) {
		to_month = "0" + to_month;
	}

		//month_val( from_month,to_month );
	if((from_year + from_month)>0 &&(to_year + to_month)>0)
	if (from_year + from_month > to_year + to_month) {
		parent.frames[1].location.href = "../../eCommon/html/blank.html";

		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, getLabel("Common.Period.label","COMMON"));	


		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + stMessage;
		return;
	}
	if (frmObj.query_type.value == "detail") {
		parent.frames[1].location.href = "../../eST/jsp/ItemMovementQueryResultDetail.jsp?item_code=" + item_code + "&store_code=" + store_code + "&stock_item=" + stock_item + "&query_type=" + query_type + "&from1=" + from_year + from_month + "&to1=" + to_year + to_month + "&trn_code=" + trn_type+"&stock_inflow_outflow="+stock_inflow_outflow;		

	} else {
		parent.frames[1].location.href = "../../eST/jsp/ItemMovementQueryResult.jsp?item_code=" + item_code + "&store_code=" + store_code + "&item_class=" + item_class + "&query_type=" + query_type + "&result_criteria=" + result_criteria + "&from=" + from_year + from_month + "&to=" + to_year + to_month;
	}
}
async function callDetailWindow(item, store, period, op_bal, rgn, rtv, in_inv_iss, out_inv_iss, in_ns_iss, out_ns_iss, in_inv_ret, out_inv_ret, in_ns_ret, out_ns_ret, sales, sales_ret, in_trans, out_trans, in_adj, out_adj, close_bal, in_mfg_rec, out_mfg_rec, in_tfr_s, out_tfr_s) {
	var item = parent.frames[0].document.StockStatusByStoreCriteria_form.item_desc.value;
	var store = parent.frames[0].document.StockStatusByStoreCriteria_form.store_desc.value;
	retVal = await top.window.showModalDialog("../../eST/jsp/ItemMovementQueryResultMore.jsp?item=" + encodeURIComponent(item,"UTF-8") + "&store=" + encodeURIComponent(store,"UTF-8") + "&period=" + period + "&op_bal=" + op_bal + "&rgn=" + rgn + "&rtv=" + rtv + "&in_inv_iss=" + in_inv_iss + "&out_inv_iss=" + out_inv_iss + "&in_ns_iss=" + in_ns_iss + "&out_ns_iss=" + out_ns_iss + "&in_inv_ret=" + in_inv_ret + "&out_inv_ret=" + out_inv_ret + "&in_ns_ret=" + in_ns_ret + "&out_ns_ret=" + out_ns_ret + "&sales=" + sales + "&sales_ret=" + sales_ret + "&in_trans=" + in_trans + "&out_trans=" + out_trans + "&in_adj=" + in_adj + "&out_adj=" + out_adj + "&close_bal=" + close_bal + "&in_mfg_rec=" + in_mfg_rec + "&out_mfg_rec=" + out_mfg_rec + "&IN_TFR_s=" + in_tfr_s + "&OUT_TFR_s=" + out_tfr_s, "", "dialogHeight:55vh; dialogWidth:45vw; center:0; status: no;scroll:auto; dialogLeft :150; dialogTop :20;");
}
function dis_detail(frmObj) {
	parent.frames[1].location.href = "../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	if (frmObj.query_type.value == "detail") {
		document.getElementById('item_S').style.visibility = "visible";
		document.getElementById('store_S').style.visibility = "visible";
		frmObj.trn_type.disabled = false;
		frmObj.stock_item.disabled = true;
		frmObj.result_criteria.disabled = true;
		frmObj.item_class.disabled = true;
		frmObj.searchItemClass.disabled = true;
		document.getElementById('inflow_out_flow').style.visibility= "visible";
		frmObj.stock_inflow_outflow.value="B";
		frmObj.item_desc.value = "";
		frmObj.item_code.value = "";
		frmObj.item_class.value="";
		frmObj.store_code.value="";

		return;
	}
	if (frmObj.query_type.value == "summary") {
		frmObj.searchItemClass.disabled = false;
		document.getElementById('item_S').style.visibility = "hidden";
		document.getElementById('store_S').style.visibility = "hidden";
		document.getElementById('inflow_out_flow').style.visibility= "hidden";
		frmObj.result_criteria.disabled = false;
		frmObj.item_class.disabled = false;
		frmObj.trn_type.disabled = true;
		frmObj.stock_item.disabled = true;
		frmObj.trn_type.value = "";
		frmObj.item_desc.value = "";
		frmObj.item_code.value = "";
		frmObj.store_code.value="";
		return;
	}
}
function trn_Show(frmObj) {
	
	if (frmObj.trn_type.value == "URG" | frmObj.trn_type.value == "ISS" | frmObj.trn_type.value == "RET"| frmObj.trn_type.value == "TFR") {
		frmObj.stock_item.disabled = false;
		return;
	} else {
		frmObj.stock_item.disabled = true;
		frmObj.stock_item.value = "B";
		return;
	}
}
var prevObj = null;
var prevColor = null;
function changeRowColor(obj) {
	if (prevObj != null) {
		for (k = 0; k < prevObj.cells.length; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < obj.cells.length; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}

function processScroll()
	{
		//alert("1");
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop){
				FloatHead.style.top = (theTop-headTop) + 'px';
				FloatHead1.style.top = (theTop-headTop) + 'px';
			}
			else{
				FloatHead.style.top = '0px';
				FloatHead1.style.top = '0px';
			}
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead = document.getElementById("heading");
			FloatHead1 = document.getElementById("heading1");
			FloatHead.style.position = "relative";
			FloatHead1.style.position = "relative";
		}
	}

