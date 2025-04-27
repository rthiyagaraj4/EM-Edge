/*---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
02/02/2017		IN0063276			Badmavathi B							GHL-CRF-0446
09/02/2017		IN0061923			Badmavathi B							GHL-CRF-0413.6 - Barcode search
1/2/2018		IN0066368			shazana									GHL-CRF-0503 split batch
---------------------------------------------------------------------------------------------------------
*/
var prevObj = null;
var prevColor = null;
var params = "";
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/SplitBatchFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/SplitBatchFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag;
}
function callItemSearchScreen() {
	//alert("line23callItemSearchScreen");
	var search_string = "";
	var errorPage = "../../eCommon/jsp/error.jsp";
	//parent.frameOpeningStockListHeader.formOpeningStockListHeader.item_desc.value;
	var store_code = parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = item_class = parent.parent.frameOpeningStockHeader.SplitBatchHeader.item_class_code.value;
	var item_class_check = parent.parent.frameOpeningStockHeader.SplitBatchHeader.item_class_check.value;
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
		if (parent.frameOpeningStockListHeader.formOpeningStockListHeader.item_desc.disabled == true) {
			search_string = "";
		} else {
			search_string = parent.frameOpeningStockListHeader.formOpeningStockListHeader.item_desc.value;
		}
		var retValue = "";
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		retValue =await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"SPB");
		var str =unescape(retValue);
		var arr = str.split(",");
		if (retVal == null) {
			return;
		}
		document.formOpeningStockListHeader.item_code.value = arr[0];
		/** @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To enable remarks look up button
			*/
			document.formOpeningStockListHeader.remark.disabled = false;
			 /**END**/
			/** @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - 'Allow Decimal Y/N' value of the selected item is assigned to the hidden field 'dec_allowed_yn' & no of decimals is assigned to "no_of_decimals"	hidden field
			*/
		document.formOpeningStockListHeader.dec_allowed_yn.value=arr[27];
		if(document.formOpeningStockListHeader.dec_allowed_yn.value == "Y"){
			document.formOpeningStockListHeader.no_of_decimals.value=arr[28];
		}else{
			document.formOpeningStockListHeader.no_of_decimals.value=0;
		}
		/**end**/
		document.formOpeningStockListHeader.item_desc.value = arr[1];
		document.formOpeningStockListHeader.expiry_yn.value = arr[2];
		document.formOpeningStockListHeader.uom.value = arr[15];
		document.formOpeningStockListHeader.uom_code.value = arr[13];
		document.getElementById("td_uom").innerHTML = "<b>" + arr[15] + "</b>";
		//document.formOpeningStockListHeader.document.getElementById("td_cost").innerHTML=setNumber(retVal[14],3);
		document.formOpeningStockListHeader.trade_id_applicable_yn.value = arr[17];
		document.formOpeningStockListHeader.batch_id_applicable_yn.value = arr[18];
		document.formOpeningStockListHeader.item_desc.disabled = true;
		document.formOpeningStockListHeader.store_code.value = store_code;
		params = "item_desc=" + escape(arr[1]) + "&item_code=" + arr[0] + "&expiry_yn=" + arr[2] + "&uom_code=" + arr[13] + "&uom=" + arr[15] + "&batch_id_applicable_yn=" + arr[18] + "&trade_id_applicable_yn=" + arr[17];
		var xmlHttp = new XMLHttpRequest();
		var xmlString = getXMLString(null);  
		var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		var xml = "<root><SEARCH/></root>";
		xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?store_code=" + store_code + "&item_code=" + arr[0] + "&validate=CHECK_PROC", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		var errorPage = "../../eCommon/jsp/error.jsp";
		if (result) {
			if (document.forms[0].stock_item_yn.value == "Y") {
				if (document.forms[0].stock_available_yn.value == "N") {
					alert(getMessage("STOCK_NOT_AVAILABLE", "ST"));
					document.formOpeningStockListHeader.item_code.value = "";
					document.formOpeningStockListHeader.item_desc.value = "";
					document.formOpeningStockListHeader.item_desc.disabled = false;
					document.getElementById("td_uom").innerHTML = "";
					//parent.parent.parent.frames[2].location.href = errorPage+"?err_num="+ getMessage("STOCK_NOT_AVAILABLE");
				} else {
					document.formOpeningStockListHeader.batch_search.disabled = false;
					//document.formOpeningStockListHeader.batch_search.focus();
				}
			} else {
				alert(getMessage("NOT_STOCK_ITEM", "ST"));
				document.formOpeningStockListHeader.item_code.value = "";
				document.formOpeningStockListHeader.item_desc.value = "";
				document.formOpeningStockListHeader.item_desc.disabled = false;
				document.formOpeningStockListHeader.document.getElementById("td_uom").innerHTML = "";
					//parent.parent.parent.frames[2].location.href = errorPage+"?err_num="+ getMessage("NOT_STOCK_ITEM");
			}
		} else {
			document.formOpeningStockListHeader.item_code.value = "";
			document.formOpeningStockListHeader.item_desc.value = "";
			document.formOpeningStockListHeader.item_desc.disabled = false;
			document.formOpeningStockListHeader.item_desc.focus();
			document.formOpeningStockListHeader.item_desc.disabled = false;
			document.getElementById("td_uom").innerHTML = "";
			parent.parent.parent.frames[2].location.href = errorPage;//+"?err_num="+ getMessage(message);
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.formOpeningStockListHeader.phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			return;
		}
		document.getElementById("ed_lbl").innerText = "";
		document.getElementById("ed_data").innerText = "";
		//document.getElementById("bid_lbl").innerText=""
		document.getElementById("bid_data").innerText = "";
		document.getElementById("bl_lbl").innerText = "";
		document.getElementById("bl_data").innerText = "";
		document.getElementById("aq_lbl").innerText = "";
		document.getElementById("aq_data").innerText = "";
		document.getElementById("tn_lbl").innerText = "";
		document.getElementById("tn_data").innerText = "";
		parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code_disabled.value = "disabled";
		parent.frameOpeningStockListDetail.location.href = "../../eCommon/html/blank.html";
	}
}
function ComputeCost() {
	var quantity = document.formOpeningStockListHeader.adj_item_qty.value;
	var cost = document.getElementById("td_cost").innerHTML;
	var avl_qty = document.getElementById("aq_data").innerHTML;
	if (avl_qty != "" && quantity != "") {
		if (parseInt(avl_qty) < parseInt(quantity)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			document.formOpeningStockListHeader.adj_item_qty.value='';  //Edge Having issue as it is going in loop, so have to clear.
			document.formOpeningStockListHeader.adj_item_qty.focus();
		} else {
			if (quantity != "" && cost != "") {
				/** @Name - Priya
				* @Date - 17/02/2010
				* @Inc# - 19404 
				* @Desc - parseInt is changed to parseFloat & toFixed is used to print only 3 digits after decimal point.
				*/
				value = parseFloat(cost) * parseFloat(quantity);
				/** @Name - Priya
				* @Date - 11/02/2010
				* @Inc# - 19213 
				* @Desc - To display value field.
				*/
				//document.formOpeningStockListHeader.
			
				document.getElementById("val_id").innerHTML =  getLabel("Common.Value.label", "Common");
				/** @Name - Priya
				* @Date - 24/05/2010
				* @Inc# -  
				* @Desc - To round up the value field with no_of_decimals_for_cost.
				*/
				var no_of_decimals_for_cost = eval(document.formOpeningStockListHeader.no_of_decimals_for_cost.value);
				//document.formOpeningStockListHeader.
				document.getElementById("val_dat").innerHTML = "<b>"+value.toFixed(no_of_decimals_for_cost)+"</b>";
				document.getElementById("val_id").style.visibility = "visible";
				document.getElementById("val_dat").style.visibility = "visible";
				/**END**/
			} else {
				document.getElementById("val_id").innerText = "";
				document.getElementById("val_dat").innerText = "";
				/** @Name - Priya
				* @Date - 11/02/2010
				* @Inc# - 19213 
				* @Desc - To hide value field.
				*/
				document.getElementById("val_id").style.visibility = "hidden";
				document.getElementById("val_dat").style.visibility = "hidden";
				/**END**/
			}
		}
	}
}
function CheckQuantity() {
	if (document.formOpeningStockListHeader.adj_item_qty.value != null) {
		if (document.formOpeningStockListHeader.adj_item_qty.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	isValidDouble(document.formOpeningStockListHeader.adj_item_qty);
	ComputeCost();
}
function CheckValue() {
	if (document.formOpeningStockListHeader.item_cost_value.value != null) {
		if (document.formOpeningStockListHeader.item_cost_value.value == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		}
	}
	if (isValidDouble(document.formOpeningStockListHeader.quantity)) {
	}
	ComputeCost();
}
function addToList(obj) {
	
	var locale = formOpeningStockListDetail.locale.value;
	var barcode_yn = document.formOpeningStockListDetail.Barcode_app_yn.value;
	//alert("barcode_yn add "+barcode_yn);
	var messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var batch_arr = new Array();
	var batch_value = 0;
	var no_of_batches_entered = 0; //04/05/12	
	for (var b = 0; b < 10; b++) {
	 	var q_batch = document.forms[0].elements.namedItem("item_qty_" + b).value;
		if (q_batch != "") {
			var ex_date = parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + b).value;
	//var ex_date = convertDate(parent.frameOpeningStockListDetail.document.forms[0].elements("expiry_date_or_receipt_date_"+b).value,"DMY",locale,"en");
	//convertDate(ex_date,"DMY",locale,"en");
			var b_id = parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("batch_id_" + b).value;
	
			var t_name = parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("trade_id_" + b).value;
			var bin_loc = parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("bin_location_code_" + b).value;
			 
			//if(barcode_yn == "true")
			//{
		  //bin_loc_code = parent.frameOpeningStockListDetail.document.formOpeningStockListDetail.bin_location_code_chk.value;    
			//}else{
			  var bin_loc_code = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader.bin_location_code.value;
			 // alert(bin_loc_code);
			 
			//}
			var rec_1 = ex_date + trimString(b_id) + t_name + bin_loc;
			batch_arr[batch_value] = rec_1;
			batch_value++;
		}
	}
	for (var c = 0; c < batch_arr.length; c++) {
		var check_arr = batch_arr[c];
		for (var f = c + 1; f < batch_arr.length; f++) {
			if (check_arr == batch_arr[f]) {
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("BATCH_DTL_ALREADY_EXIST", "ST");
				return;
			}
		}
	}
	var operation = obj;
	var formObj = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var formObj1 = parent.parent.frameOpeningStockList.frameOpeningStockListDetail.document.formOpeningStockListDetail;
	var proceed = false;
	var total_qty = 0;
	var quantity = parent.frameOpeningStockListHeader.document.forms[0].adj_item_qty.value;
	if (quantity == "") {//Added against GHL-CRF-0446 starts
		alert(getMessage("QTY_CANNOT_BLANK", "ST"));
		parent.frameOpeningStockListHeader.document.forms[0].adj_item_qty.focus();
		return;
	}//Added against GHL-CRF-0446 ends
	for (var i = 0; i < 10; i++) {
		if (parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("item_qty_" + i).value != "") {
			/**
			* @Name - Priya
			* @Date - 19/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - parseFloat is changed into eval as item_qty_ is having double values 
			*/
			item_qty = parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("item_qty_" + i).value;
			if (item_qty == "") {
					item_qty = 0;
				}
			total_qty += parseFloat(item_qty);
			/**END**/
				// check for mandatory fields in detail frame
			if (parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).value == "") {
				//alert(getMessage("EXPIRY_DT_NOT_BLANK", "ST"));
				alert(getMessage("DATE_NOT_BLANK", "ST"));
				/*Jagadeesh id is not there*/
				parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).focus();
				return;
				proceed = false;
			} else {
				if (parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("batch_id_" + i).value == "") {
					alert(getMessage("BATCH_ID_NOT_BLANK", "ST"));
					parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("batch_id_" + i).focus();
					return;
					proceed = false;
				} else {
					if (parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("trade_id_" + i).value == "") {
						alert(getMessage("TRADE_ID_NOT_BLANK", "ST"));
						proceed = false;
						parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("trade_id_" + i).focus();
						return;
					} else {
						if (parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("bin_location_code_" + i).value == "") {
							alert(getMessage("BIN_LOCN_NOT_BLANK", "ST"));
							proceed = false;
							parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("bin_location_code_" + i).focus();
							return;
						} else {
							proceed = true;
							no_of_batches_entered = no_of_batches_entered+1;
						}
					}
				}
			}
		}
	}
	formObj1.no_of_batches_entered.value = no_of_batches_entered;
	if (total_qty == 0 ) {//Added against GHL-CRF-0446 starts
		alert(getMessage("QTY_CANNOT_BLANK", "ST"));
		//parent.frameOpeningStockListHeader.document.forms[0].adj_item_qty.focus();
		return;
	}//Added against GHL-CRF-0446 ends
	if (proceed) {
		/**
			* @Name - Priya
			* @Date - 23/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - eval is applied as total_qty & quantity are having double values 
			*/		
				
		var no_of_decimals = parent.frameOpeningStockListHeader.document.forms[0].no_of_decimals.value;
		total_qty=total_qty.toFixed(no_of_decimals);
		/**
			* @Name - Priya
			* @Date - 17/02/2010
			* @Inc# - 19404
			* @Desc - eval is changed as parseFloat 
			*/
		if (parseFloat(total_qty) == parseFloat(quantity)) {
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getEnhancedXMLString(formObj1));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj1), "text/xml");
			/**
			* @Name - Priya 
			* @Date - 18/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(formObj.item_desc.value,"UTF-8")' in the next line code
			*/
		//alert(bin_loc_code);
			var item_unit_cost 	= "";
			var item_cost_value = "";
			var expiry_date		= "";
			var bin_loc_desc	= "";
			var avl_qty			= "";
			var trade_name_desc = "";
			var batch_id		= "";

 			if(parent.frameOpeningStockListHeader.document.getElementById('td_cost')!=null && parent.frameOpeningStockListHeader.document.getElementById('td_cost').innerHTML!=null)
				item_unit_cost = parent.frameOpeningStockListHeader.document.getElementById("td_cost").innerHTML;
			
			if(parent.frameOpeningStockListHeader.document.getElementById("val_dat")!=null && parent.frameOpeningStockListHeader.document.getElementById("val_dat").innerText!=null)
				item_cost_value = parent.frameOpeningStockListHeader.document.getElementById("val_dat").innerText;
			
			if(parent.frameOpeningStockListHeader.document.getElementById("ed_data")!=null && parent.frameOpeningStockListHeader.document.getElementById("ed_data").innerText!=null)
				expiry_date = parent.frameOpeningStockListHeader.document.getElementById("ed_data").innerText;
 	
			if(parent.frameOpeningStockListHeader.document.getElementById("bl_data")!=null && parent.frameOpeningStockListHeader.document.getElementById("bl_data").innerText!=null)
				bin_loc_desc = parent.frameOpeningStockListHeader.document.getElementById("bl_data").innerText;

 			if(parent.frameOpeningStockListHeader.document.getElementById("aq_data")!=null && parent.frameOpeningStockListHeader.document.getElementById("aq_data").innerText!=null)
 				avl_qty= parent.frameOpeningStockListHeader.document.getElementById("aq_data").innerText;

 	
			if(parent.frameOpeningStockListHeader.document.getElementById("tn_data")!=null && parent.frameOpeningStockListHeader.document.getElementById("tn_data").innerText!=null)	{
				trade_name_desc=parent.frameOpeningStockListHeader.document.getElementById("tn_data").innerText;
				if(trade_name_desc!=null)
					trade_name_desc=encodeURIComponent(trade_name_desc,"UTF-8"); 
			}

			if(parent.frameOpeningStockListHeader.document.getElementById("bid_data")!=null && parent.frameOpeningStockListHeader.document.getElementById("bid_data").innerText!=null)	
				batch_id=parent.frameOpeningStockListHeader.document.getElementById("bid_data").innerText;
			
			//xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&adj_item_qty=" + formObj.adj_item_qty.value + "&item_unit_cost=" + document.getElementById("td_cost").innerHTML + "&item_cost_value=" + document.getElementById("val_dat").innerText + "&remarks=" + formObj.remarks.value + "&expiry_yn=" + formObj1.expiry_yn.value + "&batch_id_applicable_yn=" + formObj1.batch_id_applicable_yn.value + "&trade_id_applicable_yn=" + formObj1.trade_id_applicable_yn.value + "&stock_uom_code=" + formObj.uom_code.value + "&uom=" + formObj1.uom.value + "&expiry_date=" + document.getElementById("ed_data").innerText + "&batch_id=" + document.getElementById("bid_data").innerText + "&bin_loc_desc=" + document.getElementById("bl_data").innerText + "&avl_qty=" + document.getElementById("aq_data").innerText + "&trade_name_desc=" + encodeURIComponent(document.getElementById("tn_data").innerText,"UTF-8") + "&trade_id=" + t_name + "&bin_loc_code=" + bin_loc_code + "&remarks_code=" + formObj.remarks_code.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&index="+formObj1.index.value+"&barcode_yn="+barcode_yn+"&validate=ADD_TO_LIST", false);
			xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&item_code=" + formObj.item_code.value + "&item_desc=" + encodeURIComponent(formObj.item_desc.value,"UTF-8") + "&adj_item_qty=" + formObj.adj_item_qty.value + "&item_unit_cost=" + item_unit_cost + "&item_cost_value=" + item_cost_value + "&remarks=" + formObj.remarks.value + "&expiry_yn=" + formObj1.expiry_yn.value + "&batch_id_applicable_yn=" + formObj1.batch_id_applicable_yn.value + "&trade_id_applicable_yn=" + formObj1.trade_id_applicable_yn.value + "&stock_uom_code=" + formObj.uom_code.value + "&uom=" + formObj1.uom.value + "&expiry_date=" + expiry_date + "&batch_id=" + batch_id + "&bin_loc_desc=" + bin_loc_desc + "&avl_qty=" + avl_qty + "&trade_name_desc=" + trade_name_desc + "&trade_id=" + t_name + "&bin_loc_code=" + bin_loc_code + "&remarks_code=" + formObj.remarks_code.value+"&dec_allowed_yn="+formObj.dec_allowed_yn.value+"&index="+formObj1.index.value+"&barcode_yn="+barcode_yn+"&validate=ADD_TO_LIST", false);

			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
	
			if (result) {
				index = formObj.doc_srl_no.value;
				if (index != -1) {
					index = index - 1;
				}
				refreshDetails(index);
			} else {
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			}
		} else {
			alert(getMessage("QUANTIY_MUST_BE_EQUAL", "ST"));
		}
	}
}

// To refresh detail frame on click of Add
function refreshDetails(index) {
//	parent.parent.frameOpeningStockDetail.location.reload();
	var store_code = parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	var barcode_yn = document.formOpeningStockListDetail.Barcode_app_yn.value; //04/05/12
	var bar_code = document.formOpeningStockListDetail.Barcode_.value;
	//alert("bar_code:"+bar_code);
	
	//alert("barcode_yn refrshdtl:" +barcode_yn);
	//alert(document.formOpeningStockListDetail.Barcode_app_yn.value);
	parent.parent.frameOpeningStockDetail.location.href = "../../eST/jsp/SplitBatchListResult.jsp?index=" + index + "&store_code=" + store_code +"&barcode_yn="+barcode_yn+"&bar_code="+bar_code;
	parent.frameOpeningStockListHeader.location.href = "../../eST/jsp/SplitBatchCriteria.jsp";
	parent.frameOpeningStockListDetail.location.href = "../../eCommon/html/blank.html";
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
}
function apply() {
	var formObj = f_query_add_mod.frameOpeningStockDetail.document.formOpeningStockDetail;
	totalCBox = parseInt(formObj.total_checkboxes.value);
	var checkBoxObj = null;
	var forDeletion = "";
	var noDetailExists = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObj = f_query_add_mod.frameOpeningStockDetail.document.formOpeningStockDetail;
 
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
  
	eval(formApply(formObj, ST_CONTROLLER));
 	messageFrame.location.href = errorPage + "?err_num=" + message + "<BR>" + flag;
	if (result) {
		onSuccess();
	}
}
function populateData(item_code, doc_srl_no, expiry_yn, batch_id_applicable_yn, trade_id_applicable_yn, uom,barcode_yn,bar_code,index) {
//alert("bar_code==>" +bar_code);
	   var index = doc_srl_no;
				if (index != -1) {
					index = index - 1;
				}
	var trObject = eval(document.getElementById("tr_" + (doc_srl_no - 1)));
	var store_code = parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	changeRowColor(trObject);
	parent.frameOpeningStockList.frameOpeningStockListHeader.location.href = "../../eST/jsp/SplitBatchCriteria.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&uom=" + uom + "&store_code=" + store_code+"&Barcode_yn="+barcode_yn+"&index="+index;
	parent.frameOpeningStockList.frameOpeningStockListDetail.location.href = "../../eST/jsp/SplitBatchAddModify.jsp?item_code=" + item_code + "&doc_srl_no=" + doc_srl_no + "&expiry_yn=" + expiry_yn + "&batch_id_applicable_yn=" + batch_id_applicable_yn + "&uom=" + uom + "&trade_id_applicable_yn=" + trade_id_applicable_yn + "&uom=" + uom+"&bar_code="+bar_code+ "&store_code=" + store_code+"&index="+index+"&Barcode_yn="+barcode_yn;     //04/05/12
	
}
function getBatchIDFromExpiryDate(expiry_date_object, i, flag) {
	var sys_date = document.forms[0].sys_date;
	sys_date	= sys_date.value;
	var formObj = document.formOpeningStockListDetail;
	var locale = formObj.locale.value; 
	//alert(locale);
	if(locale != "en") {
	expiry_date_object = convertDate(expiry_date_object.value, "DMY", locale, "en");
	}
	else{
	sys_date = sys_date;
	expiry_date_object = expiry_date_object.value;
	}
	//alert(expiry_date_object);
	if (CheckDate(expiry_date_object)) {
		if (checkDateWithSysDatee(sys_date, expiry_date_object)) {
			if ((CheckDate(expiry_date_object)) && (flag == "E") && (expiry_date_object.value != "")) {
				var index = i;
				var expiry_date = expiry_date_object;
				if(locale != "en") {
				expiry_date = convertDate(expiry_date, "DMY", "en", locale);
				}
				var result = "";
				var start_index = 0;
				var end_index = 0;
				while (expiry_date.indexOf("/") != -1) {
					end_index = expiry_date.indexOf("/");
					result += expiry_date.substring(start_index, end_index);
					expiry_date = expiry_date.substring(end_index + 1);
				}
				result += expiry_date;
				parent.parent.frameOpeningStockList.frameOpeningStockListDetail.document.formOpeningStockListDetail.elements.namedItem("batch_id_" + i).value = result;
			}
		} else {
			alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
			//Added against GHL-CRF-0446 starts
			var restrict_GRN_batch =parent.frameOpeningStockListDetail.document.forms[0].restrict_GRN_batch.value;
			if(restrict_GRN_batch=="true"){
				parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).value = "";
				parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("batch_id_" + i).value = "";
				parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("bin_location_code_" + i).value = "";
				parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("barcode_id_" + i).value = "";
				return false;
			}
			else{//Added against GHL-CRF-0446 ends
			for (var i = 0; i < 10; i++) {
			parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).select();
			parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).focus();
			return false;
			}
			}
			
		}
	}
	else {
			//alert(getMessage("INVALID_DATE_FMT", "SM"));
			for (var i = 0; i < 10; i++) {
			parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).select();
			parent.frameOpeningStockListDetail.document.forms[0].elements.namedItem("expiry_date_or_receipt_date_" + i).focus();
			//expiry_date_object.select();
			//expiry_date_object.focus();
			return false;
			}
}
}
function cancel_me() {
	parent.frameOpeningStockListHeader.location.href = "../../eST/jsp/SplitBatchCriteria.jsp";
	parent.parent.frameOpeningStockList.frameOpeningStockListDetail.location.href = "../../eCommon/html/blank.html";
}
function ValidateItem(obj) {
	var formObj = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader;
	var xmlHttp = new XMLHttpRequest();
//	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?validate=ITEM_CODE&search_code=" + escape(formObj.item_desc.value), false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
}
async function callVals() {
	var store_code = parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	var item_code = document.formOpeningStockListHeader.item_code.value;
	var includeZeroStockBatches = "N";
	var includeExpiredBatches = "Y";
	var includeSuspendedBatches = "N";
	var searchFunction = "Y";
	var multipleSelect = "N";
	if (item_code == null) { 
		alert(getMessage("ST_ITEM_CODE_BLANK", "ST"));
	} else {
		if (store_code == null) {
			alert(getMessage("ST_STORE_CODE_BLANK", "ST"));
		} else {
			var retval = await callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
			//alert(retval);
			if (retval == null) {
				return;
			}
			var arr_string = new Array();
			var arr_vals = new Array();
			if (retval.length > 0) {
				var locale = formOpeningStockListHeader.locale.value;
				var batch_string = "";
				arr_vals = retval.split("`");
				batch_id = arr_vals[0];
				item_code = arr_vals[1];
				item_desc = arr_vals[2];
				store_code = arr_vals[3];
				store_desc = arr_vals[4];
				trade_id_applicable_yn = arr_vals[5];
				expiry_date = arr_vals[6];
//				expiry_date=convertDate(arr_vals[6],"DMY","en",locale);
				bin_location_code = arr_vals[7];
				//alert(bin_location_code);
				bin_desc = arr_vals[8];
				trade_id = arr_vals[9];
				//alert(trade_id);
				trade_name = arr_vals[10];
				qty_on_hand = arr_vals[11];
				nod = arr_vals[12];
				manufacturer_id = arr_vals[13];
				manufacturer_name = arr_vals[14];
				avail_qty = arr_vals[15];
				expiry_yn = arr_vals[16];
				document.getElementById("ed_lbl").innerText = getLabel("Common.expiryDate.label", "Common");
				document.getElementById("ed_data").innerText = convertDate(arr_vals[6], "DMY", "en", locale);
				document.getElementById("bid_lbl").innerText = getLabel("Common.BatchID.label", "Common");
				document.getElementById("bid_data").innerText = arr_vals[0];
				document.getElementById("bl_lbl").innerText = getLabel("Common.BinLocation.label", "Common");
				document.getElementById("bl_data").innerText = arr_vals[8];
				document.getElementById("aq_lbl").innerText = getLabel("eST.AvailableQty.label", "ST");
				var no_of_decimals = eval(document.forms[0].no_of_decimals.value); 
				var var_avl_qty =  eval(arr_vals[15]);
				document.getElementById("aq_data").innerText = var_avl_qty.toFixed(no_of_decimals);
				document.getElementById("tn_lbl").innerText = getLabel("Common.Trade.label", "Common");
				document.getElementById("tn_data").innerText = arr_vals[10];
				document.formOpeningStockListHeader.trade_id.value = arr_vals[9];
				document.formOpeningStockListHeader.bin_location_code.value = arr_vals[7];
				//alert(document.formOpeningStockListHeader.bin_location_code.value);
				parent.frameOpeningStockListDetail.location.href = "../../eST/jsp/SplitBatchAddModify.jsp?" + params + "&trade_id=" + arr_vals[9] + "&expiry_date=" + arr_vals[6];
			}
			if(document.formOpeningStockListHeader.adj_item_qty.value!=""){
				/** @Name - Priya
				* @Date - 11/02/2010
				* @Inc# - 19213 
				* @Desc - To calculate cost & value the function 'ComputeCost'.
				*/
			   ComputeCost();
			}
		}
	}
}
function diplayLbl() {
	if (document.formOpeningStockListHeader.doc_srl_no.value != "-1") {
		document.getElementById("ed_lbl").innerText = getLabel("Common.expiryDate.label", "Common");
		document.getElementById("bid_lbl").innerText = getLabel("Common.BatchID.label", "Common");
		document.getElementById("bl_lbl").innerText = getLabel("Common.BinLocation.label", "Common");
		document.getElementById("aq_lbl").innerText = getLabel("eST.AvailableQty.label", "ST");
		document.getElementById("tn_lbl").innerText = getLabel("Common.Trade.label", "Common");
		document.getElementById("val_id").innerText = getLabel("Common.Value.label", "Common");
	}
}
function showCalendarLocal(id) {
	var flag = showCalendar(id);
	document.getElementById(id).focus();
	return flag;
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122)) {
		return (event.keyCode -= 32);
	}
	return true;
}
function changeRowColor(obj) {
	tot = document.forms[0].total_checkboxes.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 2; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < 2; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
async function searchRemarks(objCode, objDesc) {
//	objCode_value = trimString(objCode.value);
//	objDesc_value = trimString(objDesc.value);
	objCode_value = "";
	objDesc_value = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formOpeningStockListHeader.language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formOpeningStockListHeader.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formOpeningStockListHeader.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc_value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}

function checkDateWithSysDatee(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	//var enteredDate = entered_date.value;
	//var sysDate = sys_date.value;
	//alert(entered_date);
	//alert(sys_date);
	//alert(entered_date.length);
	//alert(sys_date.length);
	if (entered_date.length > 0 && sys_date.length > 0) {
		enteredDateArray = entered_date.split("/");
		sysDateArray = sys_date.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		//alert(enteredDateObject);
		//alert(sysDateObject);
		if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		} else {
			if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

//Added by Rabbani #Inc no:29973 on 11/05/12
function BarcodeApply(bar_code){

        document.getElementById("ed_lbl").innerText = getLabel("Common.expiryDate.label", "Common");
		document.getElementById("bid_lbl").innerText = getLabel("Common.BatchID.label", "Common");
		document.getElementById("bl_lbl").innerText = getLabel("Common.BinLocation.label", "Common");
		document.getElementById("aq_lbl").innerText = getLabel("eST.AvailableQty.label", "ST");
		document.getElementById("tn_lbl").innerText = getLabel("Common.Trade.label", "Common"); 
		
	  var doc_srl_no    = parent.frameOpeningStockListHeader.formOpeningStockListHeader.doc_srl_no.value;
	  var store_code = parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	  var item_code = document.formOpeningStockListHeader.item_code.value;
	 
	 var xmlHttp = new XMLHttpRequest();
	  var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));

	xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?validate=BARCODE_VAL&doc_srl_no=" + doc_srl_no +"&bar_code="+bar_code+"&fromStore="+store_code, false); 
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;  
	eval(responseText);
	//Added against IN:062247 starts
	if(!result){
	    parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;
	    if (message == "SUSPENDED_BATCH") 
		{
	    	 alert(getMessage(message, "ST"));
	    	 window.location.reload();
	    	 return;
		}
		if (message == "EXPIRED_BATCH" ) 
		{
	    	 alert(getMessage(message, "ST"));
	    	 window.location.reload();
	    	 return;
		}
	 }
	//Added against IN:062247 ends
	document.formOpeningStockListHeader.adj_item_qty.focus();
	parent.frameOpeningStockListDetail.location.href = "../../eST/jsp/SplitBatchAddModify.jsp?store_code="+store_code+"&bar_code="+bar_code+"&Barcode_yn=true";  
	
}
//Added against GHL-CRF-0413.6 starts
function callBarCodeBatchSearchsplit1(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
	if(e.keyCode==9 || e.keyCode== 13  || e.keyCode== 0){
		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?&store_code="+fromStore.value+"&barcode=" + barcode.value + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" +  "&validate=VALID_BARCODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText); 
		if(result){
			callBarCodeBatchSearchsplit(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail);
		}
		else{
			alert(getMessage("ST_INVALID_BAR_CODE", "ST"));
			 parent.frames[0].document.forms[0].barcode.value = "";
			return false;
		}
	}
}
//Added against GHL-CRF-0413.6 ends
function callBarCodeBatchSearchsplit(e,barcode,trntype,fromStore,toStore,formObj,bean_id,bean_name,ListHeader,ListDetail,Detail){
//	if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0) command it for IE work
	{
	var bar_code	= barcode.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.parent.frames[0].document.forms[0].barcode_applicable1.value;
	var resultArray	;	
	if (barcode_appl=="Y" && bar_code != ''){//Added bar_code check against IN:062247
	if (toStore==undefined)
		toStore="";
	var frombarcode ="";
	if( parent.frames[0].document.forms[0].barcode != undefined){
		if(parent.frames[0].document.forms[0].barcode.value != "" )
			frombarcode = "Y";
	}
	var xmlHttp  = new XMLHttpRequest();
	var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SplitBatchValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&jsp_page=" + ListDetail +"&frombarcode="+frombarcode+ "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//alert(result);
	if(!result){
	       /* document.formOpeningStockListHeader.item_code.value = "";
			document.formOpeningStockListHeader.item_desc.value = "";
			document.formOpeningStockListHeader.item_desc.disabled = false;
			document.formOpeningStockListHeader.item_desc.focus();
			document.formOpeningStockListHeader.item_desc.disabled = false;
			document.formOpeningStockListHeader.document.getElementById("td_uom").innerHTML = ""; */
	         parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;

		if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				if(parent.frames[0].document.forms[0].barcode!=undefined)
					parent.frames[0].document.forms[0].barcode.value = "";
				return;
		} else {
			//if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				if(parent.frames[0].document.forms[0].barcode != undefined){//Added for GHL-CRF-0413.6
					parent.frames[0].document.forms[0].barcode.value = "";
				}
				//refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			//}
			//else{
				//alert(message);
				//refreshDetailsforBarCode('999',ListHeader,Detail,'','','','','');
			//}
		}
		return;
	 }else{
		 if(parent.frames[0].document.forms[0].barcode != undefined){//Added for GHL-CRF-0413.6
		 parent.frames[0].document.forms[0].barcode.disabled = true;
		 parent.frames[0].document.forms[0].barcode.value = "";
		 }
	 }
	}
	else{
		callItemSearchScreen();
	}
}
}
//Added against GHL-CRF-0446 starts
function GoBarcode(){
	if(parent.frames[0].document.forms[0] != undefined){
		if(parent.frames[0].document.forms[0].barcode != undefined && parent.frames[0].document.forms[0].barcode.value=="" && parent.frames[0].document.forms[0].barcode.disabled != true ){
			parent.frames[0].document.forms[0].barcode.select();
		}
	}
}
async function callGRNBatchSearch(val,locale){
	var store_code = parent.parent.frameOpeningStockHeader.SplitBatchHeader.store_code.value;
	var item_code = parent.frameOpeningStockListHeader.document.formOpeningStockListHeader.item_code.value;
	var src_batch_id = parent.frameOpeningStockListHeader.document.getElementById("bid_data").innerHTML;
	var src_bin_location_code =parent.frameOpeningStockListHeader.document.getElementById("bin_location_code").value;
	var src_expiry_date = parent.frameOpeningStockListHeader.document.getElementById("ed_data").innerHTML;
	var allow_zero_batches= document.formOpeningStockListDetail.allow_zero_batches.value;//Added for GHL-CRF-0503
	
	var includeZeroStockBatches = "N";
	var includeExpiredBatches = "Y";
	var includeSuspendedBatches = "N";
	var searchFunction = "Y";
	var multipleSelect = "N";
	if (item_code == null) { 
		alert(getMessage("ST_ITEM_CODE_BLANK", "ST"));
	} else {
		if (store_code == null) {
			alert(getMessage("ST_STORE_CODE_BLANK", "ST"));
		} else {
			var retval =await callBatchSearchWindowforBarcode(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", "", "", "","","",src_batch_id,src_bin_location_code,src_expiry_date,allow_zero_batches);//Added allow_zero_batches For GHL-CRF-0503
			//alert(retval);
			if (retval == null) {
				return;
			}
			var arr_vals = new Array();
			if (retval.length > 0) {
				arr_vals = retval.split("`");
				batch_id = arr_vals[0];
				expiry_date = arr_vals[6];
				bin_location_desc = arr_vals[8];
				bin_location_code = arr_vals[7];
				trade_desc = arr_vals[10];
				trade_id = arr_vals[9];
				barcode_id = arr_vals[17];
				eval("document.formOpeningStockListDetail.batch_id_"+val).value = batch_id;
				eval("document.formOpeningStockListDetail.expiry_date_or_receipt_date_"+val).value = expiry_date;
				 var x =eval("document.formOpeningStockListDetail.bin_location_code_"+val);
				    var c = document.createElement("option");
				    c.text = bin_location_desc;
				    c.value =bin_location_code;
				    x.options.add(c, 1);
				     x.selectedIndex=1;
				var x1 =eval("document.formOpeningStockListDetail.trade_id_"+val);
				var c1 = document.createElement("option");
				c1.text = trade_desc;
				c1.value =trade_id;
				x1.options.add(c1, 1);
				x1.selectedIndex=1;
				eval("document.formOpeningStockListDetail.barcode_id_"+val).value = barcode_id;
				getBatchIDFromExpiryDate(eval("document.formOpeningStockListDetail.expiry_date_or_receipt_date_"+val),val,"Y");
				if(eval("document.formOpeningStockListDetail.batch_id_"+val).value != "")
					eval("document.formOpeningStockListDetail.item_qty_"+val).focus();
			}
		}
	}
}
async function callBatchSearchWindowforBarcode(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, cuttOffDate, doc_type_code, doc_no, trn_type,itemStoreDisable,barcode,src_batch_id,src_bin_location_code,src_expiry_date,allow_zero_batches) {//Added allow_zero_batches for GHL-CRF-0503

	if (cuttOffDate == null) {
		cuttOffDate = "";
	}
	if (doc_type_code == null) {
		doc_type_code = "";
	}
	if (doc_no == null) {
		doc_no = "";
	}
	if (trn_type == null) {
		trn_type = "";
	}
	retVal =await window.showModalDialog("../../eST/jsp/BatchSearchFrameForBarcode.jsp?item_code=" + item_code + "&store_code=" + store_code + "&includeZeroStockBatches=" + includeZeroStockBatches + "&includeExpiredBatches=" + includeExpiredBatches + "&includeSuspendedBatches=" + includeSuspendedBatches + "&searchFunction=" + searchFunction + "&multipleSelect=" + multipleSelect + "&cuttOffDate=" + cuttOffDate + "&doc_type_code=" + doc_type_code + "&doc_no=" + doc_no + "&trn_type=" + trn_type+"&itemStoreDisable="+itemStoreDisable+"&barcode="+barcode+"&src_batch_id="+src_batch_id+"&src_bin_location_code="+src_bin_location_code+"&src_expiry_date="+src_expiry_date+"&allow_zero_batches="+allow_zero_batches, "", "dialogHeight:30vh; dialogWidth:60vw; center:0; status: no; dialogLeft :200; dialogTop :100;");//added allow_zero_batches for GHL-CRF-0503	
	return retVal;
}
 //Added against GHL-CRF-0446 ends
