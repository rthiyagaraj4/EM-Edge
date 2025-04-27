
var prevObj = null;
var prevColor = null;
var bin_location_code;
var avail_qty;
var batch_id;
var item_code;
var item_desc;
var store_code;
var store_desc;
var expiry_date;
var bin_desc = "";
var trade_id;
var trade_name;
var qty_on_hand;
var retVal;
var to_bin_code;
var batch_search_barcode = false;
function reset() {
	f_query_add_mod.location.reload();
}
function cancel() {
	parent.frameChangeBinLocationList.location.href = "../../eST/jsp/ChangeBinLocationList.jsp?function_id=ST_CHANGE_BIN_LOCATION";
    //parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code_disabled.value="enabled";
//parent.frameChangeBinLocationList.location.reload();
	parent.parent.messageFrame.location.reload();
	displayMessage(parent.parent.messageFrame, "");
}
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ChangeBinLocationFrame.jsp?function_id=" + function_id;
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/ChangeBinLocationFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
	//messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag+ "   Barcode ID : " + f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList.barcode_id.value;
	// This f_query_add_mod.location.href="../../eCommon/html/blank.html";
}
function callItemSearchScreen() {
	//alert("a1");
	if (document.formChangeBinLocationList.item_desc.readOnly == true) {
		var search_string = "";
	} else {
		search_string = parent.frameChangeBinLocationList.formChangeBinLocationList.item_desc.value;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var store_code = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
	document.formChangeBinLocationList.store_code.value = store_code;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.item_class_code.value;
	var item_class_check = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.item_class_check.value;
	if (item_class_check == "Y") {
		if ((item_class == "") || (item_class == "null")) {
			alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
		}
		if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
			sub1();
		}
	} else {
		sub1();
	}
	async function sub1() {
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		retVal =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"CBL");
		var str =unescape(retVal);
		var arr = str.split(",");

		if (retVal == null) {
			return;
		}
		document.formChangeBinLocationList.item_code.value = arr[0];
		/** @Name - Priya
			* @Date - 11/02/2010
			* @Inc# - 19210
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn'
			*/
		document.formChangeBinLocationList.dec_allowed_yn.value = arr[27];
		document.formChangeBinLocationList.item_desc.value = arr[1];
		document.formChangeBinLocationList.uom.value = arr[25];
		document.formChangeBinLocationList.uom_code.value = arr[13];
		document.getElementById("td_uom").innerHTML = "UOM&nbsp;" + "<b>" + arr[25] + "</b>";
		document.formChangeBinLocationList.item_desc.readOnly = true;
		document.formChangeBinLocationList.to_bin_location.disabled = false; 
		document.formChangeBinLocationList.to_bin_location.focus();
		if (retVal != null && arr[0].length > 0) {
			parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code_disabled.value = "disabled";
			var formObj = parent.frameChangeBinLocationList.document.formChangeBinLocationList;
			var xmlHttp = new XMLHttpRequest();
			var xmlString = getXMLString(null);  
			var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?item_code=" + formObj.item_code.value + "&store_code=" + store_code + "&validate=ITEM_CODE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
		//alert(responseText);
			eval(responseText);
			if (!result) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";//?err_num="+ getMessage(message);
				if (message == "PHY_INV_PROCESS_INITIATED") {
					alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + formObj.phy_inv_id.value);
				} else {
					alert(getMessage(message, "ST"));
				}
				refreshDetails();
			}
		}
	}
}
function addToList(obj) {
  	var operation = obj;
	var formObj = document.formChangeBinLocationList;//parent.frameChangeBinLocationHeader.
	var proceed = false;
	var messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlString = getXMLString(null);  
	//var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsCriteria), "text/xml");
		/** 
			* @Name - Priya 
			* @Date - 17/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the xmlHttp.open code
			
			*/
			
	 if(formObj.barcode_applicable.value == "true"){ 
	   var store_code = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
	   var old_barcode_id = parent.frameChangeBinLocationList.formChangeBinLocationList.bar_code.value;
	   var barcode_id = formObj.barcode_id;
       var facility_id = formObj.facility_id.value;
	   var bean_id = formObj.bean_id.value;
	   var bean_name = formObj.bean_name.value;
       var item_code = formObj.item_code.value;
	   var item_code_bar_code = formObj.item_code_bar_code.value;
	  if (operation == "add") {
	 var barcode_appl = parent.frames[0].document.forms[0].barcode_applicable1.value;   
     if(document.forms[0].BarcodeRule.value=="P" || document.forms[0].BarcodeRule.value =="S"){
    var new_barcode_id = CallNewBarcodeStringAdd(bean_id,bean_name,facility_id, item_code,batch_id,expiry_date,trade_id,formObj.to_bin_location,store_code,barcode_id,formObj.adj_item_qty.value);
    }else{
   var new_barcode_id = formObj.barcode_id.value;
   }
   
 //  alert(formObj.to_bin_location.value);
  // alert(bin_location_code);
	xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&trade_id=" + trade_id + "&trade_name=" + trade_name + "&adj_item_qty=" + formObj.adj_item_qty.value + "&avl_item_qty=" + avail_qty + "&batch_id=" + batch_id + "&new_bin_loc_code=" + formObj.to_bin_location.value + "&old_bin_loc_code=" + bin_location_code + "&old_bin_loc_desc=" + bin_desc + "&new_bin_loc_desc=" + formObj.new_bin_loc_desc.value + "&exp_date=" + expiry_date + "&uom_code=" + formObj.uom_code.value + "&uom=" + formObj.uom.value +"&new_barcode_id="+new_barcode_id+"&old_barcode_id="+old_barcode_id+ "&validate=ADD_TO_LIST", false);
	
	} else {
	/* if(document.forms[0].BarcodeRule.value=="P" || document.forms[0].BarcodeRule.value =="S"){
   var new_barcode_id = CallNewBarcodeStringModify(bean_id,bean_name,facility_id, formObj.item_code.value, formObj.batch_id.value,document.forms[0].exp_date.value,formObj.trade_id.value,formObj.to_bin_location.value,store_code,barcode_id,formObj.adj_item_qty.value);
    }else{
   var new_barcode_id = formObj.barcode_id.value;
   }*/
 	
		xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&trade_id=" + formObj.trade_id.value + "&trade_name=" + formObj.trade_name.value + "&adj_item_qty=" + formObj.adj_item_qty.value + "&avl_item_qty=" + formObj.avl_item_qty.value + "&batch_id=" + formObj.batch_id.value + "&new_bin_loc_code=" + formObj.to_bin_location.value + "&old_bin_loc_code=" + formObj.old_bin_loc_code.value + "&old_bin_loc_desc=" + formObj.old_bin_loc_desc.value + "&new_bin_loc_desc=" + formObj.to_bin_location.options[formObj.to_bin_location.options.selectedIndex].text + "&exp_date=" + formObj.exp_date.value + "&uom_code=" + formObj.uom_code.value + "&uom=" + formObj.uom.value+"&new_barcode_id="+formObj.barcode_id.value+"&old_barcode_id="+old_barcode_id+ "&validate=ADD_TO_LIST", false);
	}
	}else{
	if (operation == "add") {
		xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&trade_id=" + trade_id + "&trade_name=" + trade_name + "&adj_item_qty=" + formObj.adj_item_qty.value + "&avl_item_qty=" + avail_qty + "&batch_id=" + batch_id + "&new_bin_loc_code=" + formObj.to_bin_location.value + "&old_bin_loc_code=" + bin_location_code + "&old_bin_loc_desc=" + bin_desc + "&new_bin_loc_desc=" + formObj.new_bin_loc_desc.value + "&exp_date=" + expiry_date + "&uom_code=" + formObj.uom_code.value + "&uom=" + formObj.uom.value + "&validate=ADD_TO_LIST", false);
	} else {
		xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&trade_id=" + formObj.trade_id.value + "&trade_name=" + formObj.trade_name.value + "&adj_item_qty=" + formObj.adj_item_qty.value + "&avl_item_qty=" + formObj.avl_item_qty.value + "&batch_id=" + formObj.batch_id.value + "&new_bin_loc_code=" + formObj.to_bin_location.value + "&old_bin_loc_code=" + formObj.old_bin_loc_code.value + "&old_bin_loc_desc=" + formObj.old_bin_loc_desc.value + "&new_bin_loc_desc=" + formObj.to_bin_location.options[formObj.to_bin_location.options.selectedIndex].text + "&exp_date=" + formObj.exp_date.value + "&uom_code=" + formObj.uom_code.value + "&uom=" + formObj.uom.value + "&validate=ADD_TO_LIST", false);
	}
	}
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	if (result) {
		index = formObj.doc_srl_no.value;
		if (index != -1) {
			index = index - 1;
		}
		refreshDetails(index);
		//parent.frameChangeBinLocationList.location.href="../../eST/jsp/ChangeBinLocationList.jsp?function_id=ST_CHANGE_BIN_LOCATION" ;
	} else {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
	}
}

// To refresh detail frame on click of Add
function refreshDetails(index) {

//	parent.frameChangeBinLocationDetail.location.reload();
	parent.frameChangeBinLocationDetail.location.href = "../../eST/jsp/ChangeBinLocationDetail.jsp?index=" + index;
	parent.frameChangeBinLocationList.location.href = "../../eST/jsp/ChangeBinLocationList.jsp";
	//parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code_disabled.value="enabled";

	//parent.parent.frameChangeBinLocationHeader.location.href='../../eST/jsp/ChangeBinLocationHeader.jsp';
	//parent.frameChangeBinLocationDetail.location.href='../../eCommon/html/blank.html';
	//messageFrame.document.reload();
}
function apply() {
	var formObj = f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail;
	var locale = formObj.locale.value;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var barcode_applicable = f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList.barcode_applicable.value;
      
	  if(barcode_applicable == "true"){
	 var bean_id   = formObj.bean_id.value;   
	 var bean_name   = formObj.bean_name.value; 
	 var store_code =  f_query_add_mod.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
	 var barcode_id = f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList.barcode_id;
     var facility_id = f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList.facility_id.value;
	 var BarcodeRule = f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList.BarcodeRule.value;
 	}
	
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (!(checkBoxObj.checked)) 
		if (eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hOld_bin" + i).value == eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hNew_bin" + i).value) {
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("TO_AND_FM_BIN_LOC_NOT_SAME", "ST") + " > Item: " + eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hItem" + i).value + ", Batch: " + eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hbatch_id" + i).value + ", Expiry Date: " + eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hExpiry" + i).value;
			return;
		}
	}
	for (i = 0; i < totalCBox; i++) {
		checkBoxObj = eval("formObj.checkbox" + i);
		if (checkBoxObj.checked) {
			forDeletion += ("Y,");
		} else {
			forDeletion += ("N,");
			noDetailExists = false; 
		}
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	forDeletion = forDeletion.substring(0, forDeletion.length - 1);
	formObj.records_to_delete.value = forDeletion;
    if(barcode_applicable == "true"){
	for (i = 0; i < totalCBox; i++) {
	var batch_id = eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hbatch_id" + i);
	var Expiry_date  = eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hExpiry" + i);
	var binlocn_code= eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hNew_bin" + i);
	var trade_name= eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hTrade_name" + i);
	var item_code = eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.hitem_code" + i).value;
    var adj_qty = eval("f_query_add_mod.frameChangeBinLocationDetail.document.formChangeBinLocationDetail.adj_item_qty" + i).value;
   
   /*if(BarcodeRule == "P" || BarcodeRule == "S"){
   CallNewBarcodeStringforbin(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_name,binlocn_code,store_code,barcode_id,adj_qty);
     }*/
	}
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	//alert(responseText);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	}
}
function cancel_me() {
	parent.frameChangeBinLocationHeader.location.href = "../../eST/jsp/ChangeBinLocationHeader.jsp";
	parent.parent.location.href = "../../eCommon/html/blank.html";
}
async function callBatchSearch() {
//alert("batchserach");
	var store_code = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
	var item_code = parent.frameChangeBinLocationList.formChangeBinLocationList.item_code.value;
	//alert("item_code" +item_code);
       batch_search_barcode = "true"; //04/05/12
	 	//alert("item_code" +batch_search_barcode);

	var includeZeroStockBatches = "N";
	var includeExpiredBatches = "N";
	var includeSuspendedBatches = "N";
	var searchFunction = "Y";
	var multipleSelect = "Y";
	var batchRetval =await callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
	
	if (batchRetval == null) {
		return;
	}
	var arr_string = new Array();
	var arr_vals = new Array();
	if (batchRetval.length > 0) {
		arr_vals1 = batchRetval.split("~");
		for (var i = 0; i < arr_vals1.length; i++) {
			arr_vals = arr_vals1[i].split("`");
			batch_id = arr_vals[0];
			item_code = arr_vals[1];
			item_desc = arr_vals[2];
			store_code = arr_vals[3];
			store_desc = arr_vals[4];
			trade_id_applicable_yn = arr_vals[5];
			expiry_date = arr_vals[6];
			bin_location_code = arr_vals[7];
			bin_desc = arr_vals[8];
			trade_id = arr_vals[9];
			trade_name = arr_vals[10];
			qty_on_hand = arr_vals[11];
			nod = arr_vals[12];
			manufacturer_id = arr_vals[13];
			manufacturer_name = arr_vals[14];
			avail_qty = arr_vals[15];
			expiry_yn = arr_vals[16];
			/*		document.formChangeBinLocationList.document.getElementById("batch").innerHTML="Batch" ;
        document.formChangeBinLocationList.document.getElementById("tradename").innerHTML="Trade Name" ;
        document.formChangeBinLocationList.document.getElementById("available_qty").innerHTML="Available Qty." ;
		document.formChangeBinLocationList.document.getElementById("bin_location").innerHTML="Bin Location";
		document.formChangeBinLocationList.document.getElementById("expiry_date").innerHTML="Expiry Date" ;

	    document.formChangeBinLocationList.document.getElementById("batch_dtl").innerHTML="<b>"+batch_id+"</b>";
        document.formChangeBinLocationList.document.getElementById("batch_dtl1").innerHTML="<b>"+bin_desc+"</b>";
        document.formChangeBinLocationList.document.getElementById("batch_dtl2").innerHTML="<b>"+expiry_date+"</b>";
        document.formChangeBinLocationList.document.getElementById("batch_dtl3").innerHTML="<b>"+avail_qty+"</b>";
        document.formChangeBinLocationList.document.getElementById("batch_dtl4").innerHTML="<b>"+trade_name+"</b>";
*/
			document.formChangeBinLocationList.adj_item_qty.value = avail_qty;
			parent.frameChangeBinLocationList.document.getElementById('bin_location').innerHTML = "Bin Location";
			parent.frameChangeBinLocationList.document.getElementById('batch_dtl1').innerHTML = "<b>" + bin_desc + "</b>";
			parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.readOnly = false;
			document.formChangeBinLocationList.new_bin_loc_desc.value = document.formChangeBinLocationList.to_bin_location.options[parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.options.selectedIndex].text;
			//alert("addTo");
			addToList("add");
		}
	}
}
function validateBinLocation(obj) {
	var operation = obj;
	to_bin_code = parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.value;
	
	//alert("to_bin_code :"+to_bin_code);
    
	/*    if(document.formChangeBinLocationList.document.getElementById("batch_dtl3").innerHTML=="&nbsp;")
    {
      return false;
	} else */
	if (to_bin_code == "") {
		alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
		parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.focus();
		return false;
	} else {
		if (bin_location_code == null) {
			bin_location_code = parent.frameChangeBinLocationList.formChangeBinLocationList.old_bin_loc_code.value;
			//alert("bin_location_code" +bin_location_code);
		}
	}
	if (to_bin_code == bin_location_code) {
		alert(getMessage("TO_AND_FM_BIN_LOC_NOT_SAME", "ST"));
		parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.focus();
		return false;
	} else {
		return true;
	}
}
function validateForm() {
	var transfer_qty = parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.value;
	parent.frameChangeBinLocationList.formChangeBinLocationList.new_bin_loc_desc.value = parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.options[parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.options.selectedIndex].text;
	var temp_item_desc;
	temp_item_desc = parent.frameChangeBinLocationList.formChangeBinLocationList.item_desc.value;
	if (temp_item_desc == "") {
		alert(getMessage("ST_ITEM_CODE_BLANK", "ST"));
		parent.frameChangeBinLocationList.formChangeBinLocationList.item_desc.focus();
	} else {
		if (validateBinLocation() == false) {
			if (parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.disabled == false) {
				parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.focus();
			}
		} else {
			if (transfer_qty == "") {
				alert(getMessage("QTY_TO_TFER_NOT_BLANK", "ST"));
				if (parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.disabled == false) {
					parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.focus();
				}
			} else {
				if (parseInt(transfer_qty) > parseInt(avail_qty)) {
					alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
					parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.focus();
				} else {
					addToList("add");
				}
			}
		}
	}
}
function validateFormForModify() {
	var transfer_qty = parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.value;
	var available_qty = parent.frameChangeBinLocationList.formChangeBinLocationList.avl_item_qty.value;
	to_bin_code = parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.value;
//	alert(to_bin_code);
	/*	if(to_bin_code!=bin_location_code)
	{
			validateBinLocation()==true;
	}*/
	if (validateBinLocation() == false) {
		parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.focus();
	} else {
		if (transfer_qty == "") {
			alert(getMessage("QTY_TO_TFER_NOT_BLANK", "ST"));
			parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.focus();
		} else {
			if (parseInt(transfer_qty) > parseInt(available_qty)) {
				alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
				parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.focus();
			} else {
				addToList("modify");
			}
		}
	}
}
function populateData(index, item_code, item_desc, doc_srl_no, batch_id, trade_name, avail_qty, uom, expiry_date, bin_desc, new_bin_loc_desc, adj_item_qty, new_bin_loc_code) {
	var trObject = eval(document.getElementById("tr_" + index));
	changeRowColor(trObject);
	avail_qty = avail_qty;
	parent.frameChangeBinLocationList.location.href = "../../eST/jsp/ChangeBinLocationList.jsp?item_code=" + item_code + "&item_desc=" + escape(item_desc) + "&doc_srl_no=" + doc_srl_no + "&batch_id=" + batch_id + "&trade_name=" + trade_name + "&avail_qty=" + avail_qty + "&uom=" + uom + "&expiry_date=" + expiry_date + "&bin_desc=" + bin_desc + "&new_bin_loc_desc=" + new_bin_loc_desc + "&adj_item_qty=" + adj_item_qty + "&new_bin_loc_code=" + new_bin_loc_code;	

    //parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.disabled=false;
    //parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.readOnly=false;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}
function loadMe() {
    
    //parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.disabled=true;
    //parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.readOnly=true;
    //parent.frameChangeBinLocationList.formChangeBinLocationList.Add.disabled=true ;
    //parent.frameChangeBinLocationList.formChangeBinLocationList.Cancel.disabled=true ;
}
function disableBatchButton() {
	alert(getMessage("NOT_STOCK_ITEM", "ST"));
	parent.frameChangeBinLocationList.formChangeBinLocationList.batch_search.disabled = true;
	parent.frameChangeBinLocationList.location.reload();
}
function disableBatchButton1() {
	alert(getMessage("STOCK_NOT_AVAILABLE", "ST"));
	parent.frameChangeBinLocationList.formChangeBinLocationList.batch_search.disabled = true;
	parent.frameChangeBinLocationList.location.reload();
}
function enableBatchButton() {
	parent.frameChangeBinLocationList.formChangeBinLocationList.batch_search.disabled = false;
}
function populateBinLocation() {
	var store_code = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
	var formObj = parent.frameChangeBinLocationList.document.formChangeBinLocationList;
	//var item_code = formObj.item_code.value;
	var barcode_appl = parent.frames[0].document.forms[0].barcode_applicable1.value; //04/05/12
	var item_code = "";
	var item_barcode= parent.frameChangeBinLocationList.document.formChangeBinLocationList.item_code_bar_code.value;
	if(barcode_appl == "Y" && item_barcode != ""){
	  item_code  = item_barcode;            
	  }else{
	  item_code = formObj.item_code.value; 
      }
	var xmlHttp = new XMLHttpRequest();
	var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?" + "&store_code=" + store_code + "&item_code=" + item_code + "&validate=BIN_LOCATION", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
		//alert(responseText);
	eval(responseText);
	 
	
}
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 10; k++) {
			prevObj.cells(k).className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells(1).className;
	for (k = 0; k < 10; k++) {
		obj.cells(k).className = "STLIGHTPINK";
	}
}
function batchsearchclick() {
	if (!to_bin_code == "") {
		callBatchSearch();
	}
}

//Added by Rabbani #Inc no:29973 on 11/05/12
//Starts
function callBarCodeBatchSearchChangeBin(e,trntype,fromStore,toStore,formObj,bean_id,bean_name){
	//if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0)
	{
    var bar_code = parent.frameChangeBinLocationList.formChangeBinLocationList.item_desc.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.frames[0].document.forms[0].barcode_applicable1.value;
	var resultArray	;	
	if (barcode_appl=="Y"){
	if (toStore==undefined)
		toStore="";

	/*var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlHttp = new XMLHttpRequest();
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(responseText){
	document.formChangeBinLocationList.to_bin_location.disabled = false;
	document.formChangeBinLocationList.to_bin_location.focus();	    
	//parent.frameChangeBinLocationHeader.document.formChangeBinLocationHeader.store_code_disabled.value = "disabled";
	
	}else{
	    parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;
		if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				return;
		} else {
			if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				//parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
				refreshDetails();
			}
			else{
				//alert(message);
				refreshDetails();
			}
		}
	 }
	}
	else{
		callItemSearchScreen();
	}
	
}
}

function batchsearchbarcode(){
          var check_yn =  parent.frameChangeBinLocationList.formChangeBinLocationList.check.value;
 		  if(check_yn == "Y"){
          var bar_code = parent.frameChangeBinLocationList.formChangeBinLocationList.bar_code.value;  
 		  var store_code = parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
		  var item_code = parent.frameChangeBinLocationList.formChangeBinLocationList.item_code_bar_code.value;
		  var formObj = parent.frameChangeBinLocationList.document.formChangeBinLocationList;
		  var formObj		= formObj.name; 
		 // document.formChangeBinLocationList.to_bin_location.value = obj.value; 
		  
   // var xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDoc   = new ActiveXObject("Microsoft.XMLDom");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?bar_code=" + bar_code + "&store_code=" +store_code+"&item_code="+item_code+"&formObj="+formObj+ "&validate=BARCODE_CHANGE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
 	eval(responseText);	  
    }
}

function BarcodeApply(ITEM_CODE,ITEM_DESC,TRADE_ID,short_desc,BATCH_ID,EXPIRY_DATE,EXPIRY_YN,GEN_UOM_DESC,GEN_UOM_CODE,availableqty,binlocation){

            batch_id    = BATCH_ID;
			item_code   = ITEM_CODE;
			item_desc   = ITEM_DESC;
			expiry_date = EXPIRY_DATE;
			bin_desc    = short_desc;
			trade_id    = TRADE_ID;
			trade_name  = TRADE_ID;
			avail_qty   = availableqty;
			expiry_yn   = EXPIRY_YN;
			uom_code    = GEN_UOM_CODE;
			uom         = GEN_UOM_DESC;
			bin_location_code = binlocation;
 			parent.frameChangeBinLocationList.formChangeBinLocationList.adj_item_qty.readOnly = false;
			document.formChangeBinLocationList.new_bin_loc_desc.value = document.formChangeBinLocationList.to_bin_location.options[parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.options.selectedIndex].text;
 			to_bin_code = parent.frameChangeBinLocationList.formChangeBinLocationList.to_bin_location.value;
 	       if(!to_bin_code == ""){
			addToList("add");
			}
}

function CallNewBarcodeStringforbin(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){

          var formObj = f_query_add_mod.frameChangeBinLocationList.document.formChangeBinLocationList;
 	      var trn_type = formObj.trn_type.value;
	      if(formObj.BarcodeRule.value=="P"){
	  	  if(batch_id.value!= "" || Expiry_date.value!= ""){
			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			var mrp = formObj.mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
 			barcode_id.value= message.substring(0,60);
		}
		} else if(formObj.BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
 			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			var mrp = formObj.mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type +"&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			
			barcode_id.value=message;
			
		}
	}	 
 }


function CallNewBarcodeStringAdd(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){
 	 var trn_type = document.forms[0].trn_type.value;
 	 if(document.forms[0].BarcodeRule.value=="P"){
		if(batch_id.value!= "" || Expiry_date.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
 			barcode_id.value= message.substring(0,60);
			return barcode_id.value;
		}
		} else if(document.forms[0].BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
 			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
			return barcode_id.value;
		}
	}
 }

function CallNewBarcodeStringModify(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){
 	 var trn_type = document.forms[0].trn_type.value;
	 if(document.forms[0].BarcodeRule.value=="P"){
		if(batch_id!= "" || Expiry_date!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
 		    barcode_id.value= message.substring(0,60);
			return barcode_id.value;
		}
		} else if(document.forms[0].BarcodeRule.value=="S"){
 		if(barcode_id.value=="" && item_qty != undefined && item_qty!="" && batch_id!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
			return barcode_id.value;
		}
	}
 }

function getGTINDetails(e,barcode){//Adding start for MOHE-CRF-0167
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_code =document.formChangeBinLocationList.item_code.value;
		var store_code =parent.frameChangeBinLocationHeader.formChangeBinLocationHeader.store_code.value;
		var arr_vals = new Array();
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/ChangeBinLocationValidate.jsp?&barcode=" + barcode.value+"&item_code="+item_code +"&fromStore="+store_code+"&validate=BARCODE_VAL", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if(result){
			callItemSearchScreen("BARCODE",barcode.value);
		}else{
			if(item_code==""){
			document.formChangeBinLocationList.barcode.value = "";
			 alert(getMessage(message, "ST"));
			}
		}
		
	}
}
//  END MOHE-CRF-0167 25/11/2023 






