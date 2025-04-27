/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
var ordercolmns = "1";
var count = 1;
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/BatchSearchFrame.jsp";
}
function reset() {
	f_query_add_mod.location.reload();
}
/*function searchCodeStore( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	dataNameArray[1]  = "facility_id";
	dataValueArray[1]  =document.forms[0].facility_id.value;
	dataTypeArray[1] = STRING;

	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = CommonLookup(getLabel("Common.Store.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
async function searchCodeItem(obj) {
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
	    obj.focus();
		if(document.forms[0].item_code_to != undefined)
		document.forms[0].item_code_to.value = returnedValues[0];
		//Added for TFS id:6938 start
		if(document.forms[0].barcode_to != undefined && document.forms[0].item_code_from != undefined ){
			if(document.forms[0].item_code_from.value != "")
				document.forms[0].barcode_to.disabled = true;
		}	
		//Added for TFS id:6938 end
	}  */
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
	dataValueArray[1] = document.forms[0].facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
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
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0]; 
//		objCode.value = returnedValues[1];
//		document.getElementById("td_storedesc").innerText=returnedValues[1]
	} */
}
/*
function searchCodeItem( obj) 
{
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
*/
function searchVals() {
	//alert(parent.frames[0].document.forms[0].name);
	objform = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
	//search_string=objform.search_string.value;
	var item_code_from = "";
	var item_code_to = "";
	var store_code_from = "";
	var store_code_to = "";
	var manufacturer_code = "";
	var perod_of_expiry = "";
	var includeZeroStockBatches = "";
	var includeExpiredBatches = "";
	var includeSuspendedBatches = "";
	var searchFunction = "";
	var multipleSelect = "";
	var batch_id = "";
	var Trade_code = "";
	item_code_from = objform.item_code_from.value;
	item_code_to = objform.item_code_to.value;
	store_code_from = objform.store_code_from.value;
	store_code_to = objform.store_code_to.value;
	manufacturer_code = objform.manufacturer_code.value;
	period_of_expiry = objform.period_of_expiry.value;
	searchFunction = objform.searchFunction.value;
	multipleSelect = objform.multipleSelect.value;
	includeZeroStockBatches = objform.includeZeroStockBatches.checked ? "Y" : "N";
	includeExpiredBatches = objform.includeExpiredBatches.checked ? "Y" : "N";
	includeSuspendedBatches = objform.includeSuspendedBatches.checked ? "Y" : "N";
	batch_id = objform.batch_id.value;
	Trade_code = objform.Trade_code.value;
	p_list_all_trades_yn = objform.p_list_all_trades_yn.value;
	var item_class_from = objform.item_class_from.value;
	var item_class_to = objform.item_class_to.value;
	var called_from   = objform.called_from.value;//Added for TH-KW-CRF-0043
	var req_batch_qty   = objform.req_batch_qty.value;//Added for TH-KW-CRF-0043
	var temp_conv   = objform.temp_conv.value;//Added for TH-KW-CRF-0043
	var drug_type = "%";
	if(objform.drug_type!=undefined){
		drug_type=objform.drug_type.value;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	if(parent.parent.messageFrame!=null){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";
	}
	if (isValidFromToField(objform.item_code_from, objform.item_code_to, STRING, getLabel("Common.item.label", "Common"), parent.parent.frames[2])){
	if (isValidFromToField(objform.item_class_from, objform.item_class_to, STRING, getLabel("Common.ItemClass.label", "Common"), parent.parent.frames[2])){
	if (isValidFromToField(objform.store_code_from, objform.store_code_to, STRING, getLabel("Common.Store.label", "Common"), parent.parent.frames[2])){
		var temp_jsp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=1&multipleSelect=" + multipleSelect + "&searchFunction=" + searchFunction + "&includeSuspendedBatches=" + includeSuspendedBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeZeroStockBatches=" + includeZeroStockBatches + "&item_code_from=" + item_code_from + "&item_code_to=" + item_code_to + "&store_code_from=" + store_code_from + "&store_code_to=" + store_code_to + "&manufacturer_code=" + manufacturer_code + "&period_of_expiry=" + period_of_expiry + "&batch_id=" + batch_id + "&ordercolmns=" + ordercolmns + "&Trade_code=" + Trade_code + "&doc_type_code=" + objform.doc_type_code.value + "&doc_no=" + objform.doc_no.value + "&trn_type=" + objform.trn_type.value+"&item_class_from="+item_class_from+"&item_class_to="+item_class_to+"&drug_type="+drug_type;
		//var temp_jsp="../../eST/jsp/BatchSearchValidate.jsp?function_type=1";

		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		parent.frameBatchSearchQueryResult.document.location.href = "../../eST/jsp/BatchSearchQueryResult.jsp?p_list_all_trades_yn=" + p_list_all_trades_yn+"&called_from="+called_from+"&req_batch_qty="+req_batch_qty+"&temp_conv="+temp_conv;//called_from,req_batch_qty,temp_conv Added for TH-KW-CRF-0043
	}	
	}
	}
	//multipleSelect="+multipleSelect+"&searchFunction="+searchFunction+"&includeSuspendedBatches="+includeSuspendedBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeZeroStockBatches="+includeZeroStockBatches+"&item_code_from="+item_code_from+"&item_code_to="+item_code_to+"&store_code_from="+store_code_from+"&store_code_to="+store_code_to+"&manufacturer_code="+manufacturer_code+"&period_of_expiry="+period_of_expiry+"&ordercolmns="+ordercolmns;
}
function activeLink() {
//	alert(parent.frameBatchSearchQueryResult.document.forms[0].name);
	formObjCriteria = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
	formObjResult = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	if (formObjResult != null || formObjResult != undefined) {
		//Below condition is added by Archana Dhal on 11/26/2010 related to incident no IN024566
		if ((parseInt(formObjResult.start) != undefined) && parseInt(formObjResult.start.value) != 0) {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.previous.disabled = false;
		} else {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.previous.disabled = true;
		}
		if ((parseInt(formObjResult.start) != undefined) && !((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.next.disabled = false;
		} else {
			parent.frameBatchSearchQueryCriteria.BatchSearchCriteria_Form.next.disabled = true;
		}
	}
}
function goNext() {
	formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	//Below condition is added by Archana Dhal on 11/26/2010 related to incident no IN024566
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined))
	{
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	parent.frameBatchSearchQueryResult.document.location.href = "../../eST/jsp/BatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
}
function goPrev() {
	//Below condition is added by Archana Dhal on 11/26/2010 related to incident no IN024566
	formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;
	if((parseInt(formObj.start) != undefined) || (parseInt(formObj.end) != undefined))
	{
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	parent.frameBatchSearchQueryResult.location.href = "../../eST/jsp/BatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.frameBatchSearchQueryResult.BatchsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	totalRecords = formObj.totalRecords.value;
	if (parseInt(end) > totalRecords) {
		end = totalRecords;
	}
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=2&from=" + start + "&to=" + end + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.qryResult.location.href = "../../eST/jsp/BatchSearchQueryResult.jsp?from=" + start + "&to=" + end;
}
/*function returnVals( mfg_base_qty, machine_code, min_stk_qty, max_stk_qty, long_desc, ps_item_yn,sole_source_yn,manufacturer_id, gen_uom_code,unit_cost, manufacture_desc,trade_id_applicable_yn,batch_id_applicable_yn ,expiry_yn,item_code,item_name,item_class,alpha_code,uom_desc,consignment){
	var  returnvals=item_code+"`"+item_name+"`"+expiry_yn+"`"+item_class+"`"+alpha_code+"`"+mfg_base_qty+"`"+machine_code+"`"+min_stk_qty+"`"+max_stk_qty+"`"+long_desc+"`"+ps_item_yn+"`"+sole_source_yn+"`"+manufacturer_id+"`"+gen_uom_code+"`"+unit_cost+"`"+uom_desc+"`"+manufacture_desc+"`"+trade_id_applicable_yn+"`"+batch_id_applicable_yn+"&consignment="+consignment;
	window.parent.parent.returnValue=returnvals.split("`");
	parent.window.close();
}
*/
var maxAllowed = 0;
//frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form.maxAllowed.value;
var totalChecked = 0;
function checkAllowed(obj,row_no) {
	var called_from = parent.frameBatchSearchQueryResult.document.BatchsearchForm.called_from.value; 
	maxAllowed = parent.frameBatchSearchQueryResult.document.BatchsearchForm.maxAllowed.value;
	//alert(maxAllowed);
	if (obj.checked) {
		totalChecked++;
		//alert(totalChecked);
		if (totalChecked > maxAllowed) {
//			alert("Cannot enter more than "+maxAllowed);
			alert(getMessage("ST_CANT_ENTER_MORE", "ST") + maxAllowed);
			totalChecked--;
			return false;
		} else {
			return true;
		}
	} else {
        if(called_from =="NEWSCREEN"){
			var formObj =parent.frameBatchSearchQueryResult.document.BatchsearchForm;
			    var sel_key = formObj.elements("batch_id" + row_no).value + "~" + formObj.elements("item_code" + row_no).value;
				formObj.elements("sel_qty_" + row_no).value ="";
		        var temp_jsp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=7&sel_key=" + sel_key;
				var xmlStr = "<root><SEARCH /></root>";
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", temp_jsp, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
		}
		totalChecked--;
		return true;
	}
}
function returnVals() {
	var count = 0;
	var j = 0;
	var formObj = parent.frameBatchSearchQueryResult.document.BatchsearchForm;

	if ((formObj != null) && (formObj != undefined)) //Added for TH-KW-CRF-0043
	     var called_from = parent.frameBatchSearchQueryResult.document.getElementById('called_from').value;
	else 
		var called_from ="";//Ading end for TH-KW-CRF-0043

	var returnvals = "";
	if ((formObj != null) && (formObj != undefined)) {
		count = formObj.totalRecords.value;
	}
	var index = "";
	var total_qty =0;
	var noOfCheckedRecords = "";
	var item_qty =document.BatchSearchCriteria_Form.req_batch_qty.value;
	 var temp_conv = document.BatchSearchCriteria_Form.temp_conv.value;
	if(called_from =="NEWSCREEN"){//Adding start for TH-KW-CRF-0043
	 for (var i = 0; i < count; i++) {
		 var entered_qty = eval("formObj.sel_qty_" + i).value;
		 if (formObj.elements["check" + i].checked) {  
			   var remin=parseFloat(entered_qty)%parseFloat(temp_conv);
			if (!(remin==0)) {
				alert(getMessage("BATCH_QTY_MULTIPLE_STORE_UOM", "ST")+" "+ temp_conv);
				return;
			}
				 total_qty =parseFloat(total_qty)+parseFloat(entered_qty);
		 }
	   }
		  
	     var conv_qty  = item_qty*temp_conv;
	   if(total_qty!= conv_qty){
		  alert("Entered Quantity should be equal to selected Quantity: "+conv_qty);
		    return;
	  }
	}//Adding end for TH-KW-CRF-0043
	for (var i = 0; i < count; i++) {
		if (formObj.elements["check" + i].checked) {
		//batch_id,item_code,item_desc, store_code, store_desc, trade_id_applicable_yn, ,  to_char(expiry_date,'dd/mm/yyyy') expiry_date, bin_location_code, bin_desc, trade_id, trade_name,  qty_on_hand, nod, manufacturer_id, manufacturer_name, avail_qty,expiry_yn  
		 if(called_from =="NEWSCREEN"){//Adding start for TH-KW-CRF-0043
		   var entered_qty = eval("formObj.sel_qty_" + i).value;
            if(entered_qty ==""){
				 alert("Please enter Quantity for selected record");
			   return;
		   }else{
                  var sel_key = formObj.elements["batch_id" + i].value + "~" + formObj.elements["item_code" + i].value;
				  var sel_value =eval("formObj.sel_qty_" + i).value;
				  var item_code =formObj.elements("item_code" + i).value;;
                  var temp_jsp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=6&sel_key=" + sel_key + "&sel_value=" + sel_value+"&i="+i+"&item_code="+item_code;
				var xmlStr = "<root><SEARCH /></root>";
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", temp_jsp, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
			}
		 }//Adding end for TH-KW-CRF-0043
			var expiry_date = "";
			var locale = formObj.locale.value;
			expiry_date = formObj.elements["expiry_date" + i].value;
			expiry_date = convertDate(expiry_date, "DMY", locale, "en");
			returnvals += formObj.elements["batch_id" + i].value + "`" + formObj.elements["item_code" + i].value + "`" + formObj.elements["item_desc" + i].value + "`" + formObj.elements["store_code" + i].value + "`" + formObj.elements["store_desc" + i].value + "`" + formObj.elements["trade_id_applicable_yn" + i].value + "`" + expiry_date + "`" + formObj.elements["bin_location_code" + i].value + "`" + formObj.elements["bin_desc" + i].value + "`" + formObj.elements["trade_id" + i].value + "`" + formObj.elements["trade_name" + i].value + "`" + formObj.elements["qty_on_hand" + i].value + "`" + formObj.elements["nod" + i].value + "`" + formObj.elements["manufacturer_id" + i].value + "`" + formObj.elements["manufacturer_name" + i].value + "`" + formObj.elements["avail_qty" + i].value + "`" + formObj.elements["expiry_yn" + i].value + "~";
			index += i + "!";
			noOfCheckedRecords++;
		//alert("returnvals--->"+returnvals);
		}
	}
	if (returnvals != "") {
		returnvals = returnvals.substring(0, returnvals.length - 1);
		index = index.substring(0, index.length - 1);
		/* from here*/
		//bean method to return selected values
		var temp_jsp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=4&index=" + index + "&noOfCheckedRecords=" + noOfCheckedRecords;
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//alert(responseText);
	}
	/* till here*/


	//alert("Inside Batch Search");
	//alert(returnvals);
	window.parent.parent.returnValue = returnvals;
	window.close();
 
	//let dialogBody = parent.parent.document.getElementById('dialog-body');
    //dialogBody.contentWindow.returnValue = returnvals;
    
    //const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
	
	//return returnvals;
}
async function showHistory1 (trObj, index,index1) {
	var trObj = eval(document.getElementById("tr_" + index + ""));
	//var item_code = eval(document.BatchsearchForm.getElementById("item_code" + index1 + ".value"));
	var item_code = document.getElementById("item_code" + index1 + ".value");
	//var item_desc = eval(document.BatchsearchForm.getElementById("item_desc" + index1 + ".value"));
	var item_desc = document.getElementById("item_desc" + index1 + ".value");
	var expiry_date = trObj.cells[1].innerText;
	var batch_id = trObj.cells[2].innerText;
	var trade_name = trObj.cells[3].innerText;
	var manufacturer_name = trObj.cells[4].innerText;
	var uom_desc = trObj.cells[6].innerText;


	retVal = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:50vh; dialogWidth:50vw; center:0; status: no; dialogLeft :10; dialogTop :10;");
}

async function showHistory(trObj, index) {
	var trObj = eval(document.getElementById("tr_" + index + ""));
	//var item_code = eval(document.BatchsearchForm.getElementById("item_code" + index + ".value"));
	var item_code = document.getElementById("item_code" + index).value;
	var item_desc = document.getElementById("item_desc" + index).value;
	//var item_desc = eval(document.BatchsearchForm.getElementById("item_desc" + index + ".value"));
	var expiry_date = trObj.cells[1].innerText;
	var batch_id = trObj.cells[2].innerText;
	var trade_name = trObj.cells[3].innerText;
	var manufacturer_name = trObj.cells[4].innerText;
	var uom_desc = trObj.cells[6].innerText;
	retVal =await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + escape(item_code) + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + escape(item_desc) + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:80vh; dialogWidth:80vw; center:0; status: no; dialogLeft :75; dialogTop :20;");
}

function getTradeList()
{
 var objform = parent.frameBatchSearchQueryCriteria.document.BatchSearchCriteria_Form;
 var item_code_from = objform.item_code_from.value;
 var item_code_to = objform.item_code_to.value;

 if(item_code_to=="")
	item_code_to = item_code_from;

 var p_list_all_trades_yn = objform.p_list_all_trades_yn.value;

 var temp = "../../eST/jsp/BatchSearchValidate.jsp?function_type=5&item_code_from="+escape(item_code_from)+"&item_code_to="+escape(item_code_to)+"&p_list_all_trades_yn="+p_list_all_trades_yn; 
 	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	
}

async function searchItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value;
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

async function searchTradeName(obj,item_code_from,item_code_to) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "language_id";
	dataValueArray[0]= localeName;
	dataTypeArray[0] = STRING;

	argumentArray[0] = "select code , description from (SELECT distinct nvl(a.trade_id,c.DFLT_TRADE_ID) code , nvl(b.short_name,c.DFLT_TRADE_ID) description FROM mm_trade_name_for_item a, am_trade_name_lang_vw b,mm_parameter c WHERE a.trade_id = b.trade_id AND LANGUAGE_ID LIKE ? AND b.eff_status = 'E' AND (item_code BETWEEN NVL ('"+item_code_from.value+"', '!') AND NVL ('"+item_code_to.value+"', '~'))) where  upper(code) LIKE  upper(?) AND upper(description)  LIKE  upper(?) ORDER BY 2";

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value.toUpperCase();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.TradeName.label", "common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";
		document.getElementById("Trade_code").value=arr[0];		
 		}
	else{
		obj.value=arr[0];
		document.getElementById("Trade_code").value=arr[0];

	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.getElementById("Trade_code").value=returnedValues[0];
	}
	else{
		obj.value ="";
		document.getElementById("Trade_code").value="";
	} */
}

function clearTradeid(){
	var trade_desc = document.getElementById("Trade_desc").value;
		if(trade_desc=="")
		document.getElementById("Trade_code").value="";
}

function checkQty(qty,count,temp_conv){//TH-KW-CRF-0043
	  if(qty.value!=""){
		  var remin=parseFloat(qty.value)%parseFloat(temp_conv);
			if (!(remin==0)) {
				alert(getMessage("BATCH_QTY_MULTIPLE_STORE_UOM", "ST")+" "+ temp_conv);
                eval("document.BatchsearchForm.sel_qty_" + count).focus();
				return;
			}else{
				eval("document.BatchsearchForm.check" + count).checked =true;
			}
  }
}//Adding end for TH-KW-CRF-0043
