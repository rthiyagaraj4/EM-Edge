var item_Cod;

function Display(from, code) {
	if (document.formStockStatusQueryCriteria.item_code.value == "") {
		return;
	}
	if (from == "1") {
		var formObj=document.formStockStatusQueryCriteria;
		//parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" + item_Cod;
		parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&item_code=" + item_Cod+"&dflt_facility_id="+formObj.dflt_facility_id.value+"&includeSuspendedBatches="+formObj.includeSuspendedBatches.value;
		document.getElementById('id_storestatus').className = "clicked";
		document.getElementById('id_moredetail').className = "normal";
		document.getElementById('id_consumption').className = "normal";		
	} else {
		if (from == "2") {
			parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResultMore.jsp";
			document.getElementById('id_storestatus').className = "normal";
			document.getElementById('id_moredetail').className = "clicked";
			document.getElementById('id_consumption').className = "normal";
		} else {
			var formObj=document.formStockStatusQueryCriteria;
			parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemConsumption.jsp?item_code=" + item_Cod+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&dflt_facility_id="+formObj.dflt_facility_id.value;
			document.getElementById('id_storestatus').className = "normal";
			document.getElementById('id_moredetail').className = "normal";
			document.getElementById('id_consumption').className = "clicked";
		}
	}
}
function reset() {
	f_query_add_mod.location.reload();
}
function query() {
	callItemSearchScreen();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/OpeningStockFrame44.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
async function callItemSearchScreen() {
	//alert("a16");
	var search_string = "";
	if (!parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.item_desc.readOnly) {
		search_string = parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.item_desc.value;
	}
	var store_code = "";//parent.parent.frameSalesHeader.formSalesHeader.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var store_disable = "Y";
//   store_disable is added on 6/2/2005 to disable the store search criteria in item search page.
	var retVal = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, "", "", store_disable);

	if (retVal != null) {
		var ret1=unescape(retVal);
		 	var retVal=ret1.split(",");
	//		parent.parent.frameSalesHeader.document.formSalesHeader.store_code_disabled.value="disabled";
		var item_C = retVal[0];
		item_Cod = item_C;
		var no_of_decimals_for_cost = eval(parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.no_of_decimals_for_cost.value);
		var unit_cost = setNumber(retVal[14], no_of_decimals_for_cost);
		var exp_yn = retVal[2];
		var store_code = retVal[20];
		//Added by Rabbani #INC no :39203  on 09/04/2013 
		var dflt_facility_id  = parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.dflt_facility_id.value;
		document.formStockStatusQueryCriteria.unit_cost_facility.value = unit_cost;
		document.formStockStatusQueryCriteria.id_min_lev.value = retVal[7];
	//store_Cod = store_code;
		//var temp_jsp = "../../eST/jsp/StockStatusByItemSearchValidate.jsp?item_code=" + item_C + "&unit_cost=" + unit_cost + "&store_code=" + store_code + "&id_minl=" + retVal[7];
		var temp_jsp = "../../eST/jsp/StockStatusByItemSearchValidate.jsp?item_code=" + item_C + "&unit_cost=" + unit_cost + "&store_code=" + store_code + "&id_minl=" + retVal[7]+"&dflt_facility_id="+dflt_facility_id;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		
		eval( responseText);
		
		document.formStockStatusQueryCriteria.item_code.value = item_C;
		document.formStockStatusQueryCriteria.item_desc.value = retVal[1];
		document.formStockStatusQueryCriteria.item_desc.readOnly=true;
		//document.formStockStatusQueryCriteria.store_cod.value = store_code;
		if (exp_yn == "Y") {
			document.getElementById('id_exp').innerHTML = "<image src='../../eCommon/images/enabled.gif'>";
		} else {
			document.getElementById('id_exp').innerHTML = "<image src='../../eCommon/images/disabled.gif'>";
		}
		 //NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(item_value))
		// alert(new Locale("en"));
		document.getElementById('id_uom').innerHTML = retVal[15];
		//document.getElementById('id_cost').innerHTML = setNumberForNumberFormat(setNumber(retVal[14], 2)+"");//.substring(0,5); //Comented by Sakti against TTM-SCF-0106. This is setted from validate
		
		document.getElementById('id_minl').innerHTML =setNumberForNumberFormat(retVal[7]);
		document.getElementById('id_maxl').innerHTML = setNumberForNumberFormat(retVal[8]);
//		document.formStockStatusQueryCriteria.item_desc.readOnly=true;
		if (retVal[20] != null) {
			document.getElementById('id_pstore').innerHTML = retVal[21];
		}
		document.getElementById("trhidden").style.visibility="hidden";
		parent.frameStockStatusQueryResult.location.href = "../../eCommon/html/blank.html";
	
	
	}
}
function callBatchSearchScreen(store_batch_code,includeSuspendedBatches) {
	parent.frameStockStatusSearchQueryCriteria.document.getElementById('item_desc').innerText;
	var batch_item = parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.item_code.value;
	//var batch_store	= parent.frameStockStatusSearchQueryCriteria.formStockStatusQueryCriteria.store_cod.value;
	//document.getElementById("id").innerText;
	var batch_store = store_batch_code;
	var includeZeroStockBatches = "Y";
	var includeExpiredBatches = "Y";
	//var includeSuspendedBatches = "Y";
	//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
	var includeSuspendedBatches = includeSuspendedBatches;
	var searchFunction = "N";
	var multipleSelect = "N";
	var itemStoreDisable = "Y";
	var cuttOffDate = "";
	var doc_type_code = "";
	var doc_no = "";
	var trn_type = "";
	var retval = callBatchSearchWindow(batch_item, batch_store, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect,cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable);	
}

async function displayPending(item_code, move_month,move_year1, move_year, count,store_code_from,store_code_to) {
	for (var i = 1; i < document.getElementById('tb1').rows.length; i++) {
		var className = "";
		var className1 = "";
		if (i % 2) {
			className = "QRYEVEN";
		} else {
			className = "QRYODD";
		}
		if (i == count) {
			eval(document.getElementById('period_' + count)).className = "STLIGHTPINK";
			eval(document.getElementById('qty_' + count)).className = "STLIGHTPINK";
			if(cost_access == 'Y'){
				eval(document.getElementById('cost_' + count)).className = "STLIGHTPINK";
			}
		} else {
			if (eval(document.getElementById('period_' + i)) != null) {
				eval(document.getElementById('period_' + i)).className = className;
			}
			if (eval(document.getElementById('qty_' + i)) != null) {
				eval(document.getElementById('qty_' + i)).className = className1;
			}
			if(cost_access == 'Y'){
				if (eval(document.getElementById('cost_' + i)) != null) {
					eval(document.getElementById('cost_' + i)).className = className1;
				}
			}
		}
	}
	
	var dialogFeatures = "dialogHeight: 35vh; dialogWidth:40vw ;dialogLeft :125; dialogTop :300; scrolling :yes; status:no";
	var retVal = await window.showModalDialog("../../eST/jsp/StockStatusByItemFrameList.jsp?item_code=" + item_code + "&move_month=" + move_month  + "&move_year1=" + move_year1 + "&move_year=" + move_year +"&store_code_from=" +store_code_from+"&store_code_to="+store_code_to+"&cost_access="+cost_access, "", dialogFeatures);
	
}
async function searchStoreCode( objDesc, user) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formStockStatusQueryCriteria.language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	//dataValueArray[1] = document.formStockStatusQueryCriteria.facility_id.value;
	dataValueArray[1] = document.formStockStatusQueryCriteria.dflt_facility_id.value;
	dataTypeArray[1] = STRING;
	//argumentArray[0] = document.formStockStatusQueryCriteria.SQL_ST_STORE_LOOKUP.value;
	var sql = "SELECT    DISTINCT A.STORE_CODE CODE, A.SHORT_DESC DESCRIPTION FROM MM_STORE_LANG_VW A, ST_STORE C, ST_ACC_ENTITY_PARAM D, ST_USER_ACCESS_FOR_STORE E WHERE A.LANGUAGE_ID LIKE ? AND A.FACILITY_ID LIKE ? AND A.STORE_CODE LIKE UPPER (?) AND UPPER (A.SHORT_DESC) LIKE UPPER (?) AND A.EFF_STATUS = 'E' AND A.STORE_CODE = C.STORE_CODE AND C.STORE_TYPE_FLAG != 'N' AND E.USER_ID LIKE DECODE(D.RESTRICT_VIEW_STK_STATUS , 'ALL','%', '"+user+"') AND C.STORE_CODE = E.STORE_CODE";
	argumentArray[0] = encodeURIComponent(sql)+" ORDER BY 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
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
		objDesc.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		//objCode.value = returnedValues[0];
		objDesc.value = returnedValues[0];
	} */
}

function searchDetails(){

formObj=document.formStockStatusQueryCriteria;
var messageFrame=parent.parent.messageFrame;
var errorPage = "../../eCommon/jsp/error.jsp";
messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
var fields = new Array(formObj.item_code);
var names = new Array(getLabel("Common.item.label", "Common"));
var blankObject = null;
blankObject = checkSTFields(fields, names, messageFrame, errorPage);
//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
var includeSuspendedBatches = formObj.includeSuspendedBatches.value;

if(blankObject){
if(formObj.store_code_from.value!="" && formObj.store_code_to.value!=""){
if (isValidFromToField(formObj.store_code_from, formObj.store_code_to, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) { 
	//parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&dflt_facility_id="+formObj.dflt_facility_id.value;
	//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
	parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&dflt_facility_id="+formObj.dflt_facility_id.value+"&includeSuspendedBatches="+includeSuspendedBatches;
document.formStockStatusQueryCriteria.all.trhidden.style.visibility="visible";
document.formStockStatusQueryCriteria.all.id_storestatus.className = "clicked";
document.formStockStatusQueryCriteria.all.id_moredetail.className = "normal";
document.formStockStatusQueryCriteria.all.id_consumption.className = "normal";
}else{
	parent.frames[1].location.href = "../../eCommon/html/blank.html";
}
	}else{
//parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&dflt_facility_id="+formObj.dflt_facility_id.value;
//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&dflt_facility_id="+formObj.dflt_facility_id.value+"&includeSuspendedBatches="+includeSuspendedBatches;
//document.formStockStatusQueryCriteria.all.trhidden.style.visibility="visible";
document.getElementById('trhidden').style="display";
//document.formStockStatusQueryCriteria.all.id_storestatus.className = "clicked";
document.getElementById('id_storestatus').className = "clicked";
//document.formStockStatusQueryCriteria.all.id_moredetail.className = "normal";
document.getElementById('id_moredetail').className = "normal";
//document.formStockStatusQueryCriteria.all.id_consumption.className = "normal";
document.getElementById('id_consumption').className = "normal";
}
}
}
//Added by Rabbani #INC no : 39203  on 18-04-2013
function facility_select(obj){
  if(document.formStockStatusQueryCriteria.item_code.value != ""){
       var item_C = document.formStockStatusQueryCriteria.item_code.value;
       var store_code = "";
       var unit_cost  =  document.formStockStatusQueryCriteria.unit_cost_facility.value;
       var id_min1    =  document.formStockStatusQueryCriteria.id_min_lev.value;
  
        var temp_jsp = "../../eST/jsp/StockStatusByItemSearchValidate.jsp?item_code=" + item_C + "&unit_cost=" + unit_cost + "&store_code=" + store_code + "&id_minl=" +id_min1+"&dflt_facility_id="+obj.value;
	    var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		
		formObj=document.formStockStatusQueryCriteria;
		formObj.store_code_from.value = "";
		formObj.store_code_to.value = "";
		parent.frameStockStatusQueryResult.location.href = "../../eST/jsp/StockStatusByItemQueryResult.jsp?item_code=" +formObj.item_code.value+"&store_code_from="+formObj.store_code_from.value+"&store_code_to="+formObj.store_code_to.value+"&stock_level="+formObj.stock_level.value+"&dflt_facility_id="+formObj.dflt_facility_id.value+"&includeSuspendedBatches="+formObj.includeSuspendedBatches.value;
        document.formStockStatusQueryCriteria.all.trhidden.style.visibility  = "visible";
        document.formStockStatusQueryCriteria.all.id_storestatus.className   = "clicked";
        document.formStockStatusQueryCriteria.all.id_moredetail.className    =  "normal";
        document.formStockStatusQueryCriteria.all.id_consumption.className   = "normal";
		}
}
//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013 Starts
function SetSuspendedBatches(obj){
if(obj.checked == true)
document.formStockStatusQueryCriteria.includeSuspendedBatches.value = "Y";
else
document.formStockStatusQueryCriteria.includeSuspendedBatches.value = "N";
}
//ends





