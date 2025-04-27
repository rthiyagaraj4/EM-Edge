/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
8/8/2021  	TFS:21452        Shazana                      					ML-MMOH-SCF-1861
--------------------------------------------------------------------------------------------------------------------------------
 */ 
var fm_bin_location_code;
var fm_avail_qty;
var fm_batch_id;
var fm_item_code;
var fm_item_desc;
var fm_store_code;
var fm_store_desc;
var fm_expiry_date;
var fm_bin_desc;
var fm_trade_id;
var fm_trade_name;
var fm_qty_on_hand;
var fm_conv_factor;
var to_conv_factor;
var too_item_desc;
var from_item_desc;
var fromuomcode;
var touomcode;
var toitemcode;
var toitem_code;
var fromtradeidapplicableyn;
var batchidapplicableyn;
var totradeidapplicableyn;
var remarks;
var fm_retVal = "";
var fromexpiry;
var fromuom;
var touom;
var toexpiry;
var fromitemcode;
var tooitemcode;
var item_search_value;
var request_flag = "N";
var request_flag1 = "N";
var item_flag = "N";
var item_flag1 = "N";
var to_bin_location_code;
var to_avail_qty;
var to_batch_id;
var to_item_code;
var to_item_desc;
var to_store_code;
var to_store_desc;
var to_expiry_date;
var to_bin_desc;
var to_trade_id;
var to_trade_name;
var to_qty_on_hand;
var to_retVal;
var fm_expiry_yn = "";
var fm_batch_id_applicable_yn = "";
var fm_trade_id_applicable_yn = "";
var to_expiry_yn = "";
var to_batch_id_applicable_yn = "";
var to_trade_id_applicable_yn = "";
var flag1 = "";
var sales;
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016 starts
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ProductTransferFrame.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ProductTransferQueryFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016 ends
//var sole_source_depends_on_trade_fm="";
function reset() {
	f_query_add_mod.location.reload();
}
async function callBatchSearchFrom() {
	var site = parent.frameProductTransferAddModify.formProductTransferAddModify.site.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var mode = parent.frameProductTransferAddModify.formProductTransferAddModify.mode.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var from_item_code = parent.frameProductTransferAddModify.formProductTransferAddModify.from_item_code.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var to_quantity = document.formProductTransferAddModify.p_actual_qty.value;
	var request_yn = parent.frameProductTransferHeader.formProductTransferHeader.request_yn.value; 
	var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
	fromitemcode = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
	if (request_yn == "N") {
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		var item_code = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
		
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var batch_retval = "";
		//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
		if(mode!=1){
			batch_retval = await callBatchSearchWindow(from_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		}
		else{
		//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
		
			batch_retval =await callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
	//		console.log(batch_retval);
		}//Added for ML-MMOH-CRF-0448 B.Badmavathi
		if (batch_retval == null) {
			return;
		}
		var arr_vals = new Array();
		if (batch_retval.length > 0) {
			arr_vals = batch_retval.split("`");
			for (var i = 0; i < 16; i++) {
				fm_batch_id = arr_vals[0];
				fm_item_code = arr_vals[1];
				fm_item_desc = arr_vals[2];
				fm_store_code = arr_vals[3];
				fm_store_desc = arr_vals[4];
			//fm_trade_id_applicable_yn=arr_vals[5];
				fm_expiry_date = arr_vals[6];
				fm_bin_location_code = arr_vals[7];
				fm_bin_desc = arr_vals[8];
				fm_trade_id = arr_vals[9];
				fm_trade_name = arr_vals[10];
				fm_qty_on_hand = arr_vals[11];
				fm_nod = arr_vals[12];
				fm_manufacturer_id = arr_vals[13];
				fm_manufacturer_name = arr_vals[14];
				fm_avail_qty = arr_vals[15];
				fm_expiry_yn = arr_vals[16];

				if(formObj.sale_price_appl_yn.value == "Y") {
				/*var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fromitemcode + "&fm_trade_id=" + fm_trade_id + "&fm_batch_id=" + fm_batch_id + "&validate=SALE_PRICE", false);
				xmlHttp.send(xmlDoc);*/
					
					var xmlHttp = new XMLHttpRequest();
					var xmlStr = getEnhancedXMLString(formObj);
					var xmlDoc = new DOMParser().parseFromString(xmlStr, "application/xml");
					xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fromitemcode + "&fm_trade_id=" + fm_trade_id + "&fm_batch_id=" + fm_batch_id + "&validate=SALE_PRICE", false);
					xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
				responseText = xmlHttp.responseText;
				eval(responseText);
				}

			}
		}
		if (batch_retval != "") {
			var temp_exp_date_label;
			var temp_exp_date_label_to;
			if (fm_expiry_yn == "Y") {
				temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.expiryDate.label", "Common");
				var ex_param_days = parent.frameProductTransferAddModify.formProductTransferAddModify.ex_param_days.value;
				if (parseInt(fm_nod) <= parseInt(ex_param_days)) {
					if (parseInt(fm_nod) > 0) {
				//<br><font class="DATAHIGHLIGHT"><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></font>
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + fm_nod + getLabel("Common.days.label", "Common") + "</font>";
					} else {
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + "</font>";
					}
				}
			} else {
				temp_exp_date_label = getLabel("Common.receiptdate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.receiptdate.label", "Common");
			}
			document.getElementById("fm_display_dtl_1_bl").innerHTML = getLabel("Common.BatchID.label", "Common");
			document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_batch_id + "' size='10'>";
			document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_expiry_date + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + parseFloat(fm_avail_qty).toFixed(parseInt(document.formProductTransferAddModify.no_deci_from.value)) + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			if(formObj.sale_price_appl_yn.value == "Y") {
			document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("eST.SalePrice.label", "ST");
			document.getElementById("fm_display_slp_1_et").innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
			document.getElementById("fr_sale_price").value =  sales.toFixed(2);
			}
			/*+"&nbsp;&nbsp;&nbsp; Conv Factor."+"<b>"+document.formProductTransferAddModify.eqvlvalue.value;*/
			document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") + "<b>" + fm_bin_desc + "</b>";
			if(mode==1){
				document.getElementById("to_trade_dtl").innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;<b>" + fm_trade_name + "</b>";
			}
			document.getElementById("to_expiry_date_id").innerHTML = temp_exp_date_label_to;

//      document.formProductTransferAddModify.p_to_expiry_date.value=document.formProductTransferAddModify.sys_date.value;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			document.formProductTransferAddModify.fm_expiry_date.value = fm_expiry_date;
			document.formProductTransferAddModify.fm_batch_id.value = fm_batch_id;
			//if(document.formProductTransferAddModifyallow_deci_yn_from=='Y')
			document.formProductTransferAddModify.p_fm_quantity.value = parseFloat(fm_avail_qty).toFixed(parseInt(document.formProductTransferAddModify.no_of_decimals.value));
		//	if(document.formProductTransferAddModifyallow_deci_yn_from=='N')
		//	{
          //  alert(setNumber(fm_avail_qty,0));
					//	document.formProductTransferAddModify.p_fm_quantity.value = setNumber(fm_avail_qty,0);

			//}
			document.formProductTransferAddModify.fm_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.to_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			if(formObj.sale_price_appl_yn.value == "Y") {
			if(sales == 0){
			document.formProductTransferAddModify.sale_price.value= 0;
			}else{
			if(to_quantity!="")
			document.formProductTransferAddModify.sale_price.value = (sales/to_quantity).toFixed(2);
			else
			document.formProductTransferAddModify.sale_price.value = 0;
			}
			}
			//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
			if(site && mode==2){
				enableAllToFields1();
			}
			else{//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
				enableAllToFields();
			}//Added for ML-MMOH-CRF-0448 B.Badmavathi
			if (fm_expiry_yn == "N") {
				document.formProductTransferAddModify.p_to_expiry_date.readonly = true;
				document.formProductTransferAddModify.document.getElementById("Calendar").disabled = true;
			}
		}
	} else {
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		 var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
		fromitemcode = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
		var item_code = fromitemcode;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var batch_retval = "";
		//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
		if(mode!=1){
			batch_retval = await callBatchSearchWindow(from_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		}
		else{
		//Added for ML-MMOH-CRF-0448 B.Badmavathi ends		
			batch_retval = await callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		}//Added for ML-MMOH-CRF-0448 B.Badmavathi
		if (batch_retval == null) {
			return;
		}
		var arr_vals = new Array();
		if (batch_retval.length > 0) {
			arr_vals = batch_retval.split("`");
			for (var i = 0; i < 17; i++) {
				fm_batch_id = arr_vals[0];
				fm_item_code = arr_vals[1];
				fm_item_desc = arr_vals[2];
				fm_store_code = arr_vals[3];
				fm_store_desc = arr_vals[4];
			//fm_trade_id_applicable_yn=arr_vals[5];
				fm_expiry_date = arr_vals[6];
				fm_bin_location_code = arr_vals[7];
				fm_bin_desc = arr_vals[8];
				fm_trade_id = arr_vals[9];
				fm_trade_name = arr_vals[10];
				fm_qty_on_hand = arr_vals[11];
				fm_nod = arr_vals[12];
				fm_manufacturer_id = arr_vals[13];
				fm_manufacturer_name = arr_vals[14];
				fm_avail_qty = arr_vals[15];
				fm_expiry_yn = arr_vals[16];

				if(formObj.sale_price_appl_yn.value == "Y") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				// xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fromitemcode + "&fm_trade_id=" + fm_trade_id + "&fm_batch_id=" + fm_batch_id + "&validate=SALE_PRICE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				}
			}
		}
		if (batch_retval != "") {
			var temp_exp_date_label;
			var temp_exp_date_label_to;
			if (fm_expiry_yn == "Y") {
				temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.expiryDate.label", "Common");
				var ex_param_days = parent.frameProductTransferAddModify.formProductTransferAddModify.ex_param_days.value;
				if (parseInt(fm_nod) <= parseInt(ex_param_days)) {
					if (parseInt(fm_nod) > 0) {
				//<br><font class="DATAHIGHLIGHT"><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></font>
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("eST.Exp.label", "ST") + fm_nod + getLabel("Common.days.label", "Common") + "</font>";
					} else {
						temp_exp_date_label = temp_exp_date_label + temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + "</font>";
					}
				}
			} else {
				temp_exp_date_label = getLabel("Common.receiptdate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.receiptdate.label", "Common");
			}

			//document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = fm_sale_price;
			
			
			document.querySelector('form[name="formProductTransferAddModify"] #fm_display_dtl_1_bl').innerHTML = getLabel("Common.BatchID.label", "Common");
			document.querySelector('form[name="formProductTransferAddModify"] #fm_display_dtl_1_bt').innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_batch_id + "' size='10'>";
			document.querySelector('form[name="formProductTransferAddModify"] #fm_display_dtl_1_el').innerHTML = temp_exp_date_label;
			document.querySelector('form[name="formProductTransferAddModify"] #fm_display_dtl_1_et').innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_expiry_date + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + fm_avail_qty + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
			
			/*parent.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerHTML = getLabel("Common.BatchID.label", "Common");
			parent.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_batch_id + "' size='10'>";
			parent.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			parent.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_expiry_date + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + fm_avail_qty + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
*/
			if(formObj.sale_price_appl_yn.value == "Y") {
				document.querySelector('form[name="formProductTransferAddModify"] #fm_display_slp_1_el').innerHTML = getLabel("eST.SalePrice.label", "ST");
				document.querySelector('form[name="formProductTransferAddModify"] #fm_display_slp_1_et').innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
				document.querySelector('form[name="formProductTransferAddModify"] #fr_sale_price').value =  sales.toFixed(2);
/*			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("eST.SalePrice.label", "ST");
			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_et").innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
			document.formProductTransferAddModify.document.getElementById("fr_sale_price").value =  sales.toFixed(2);
*/			
			}
			/*+"&nbsp;&nbsp;&nbsp; Conv Factor."+"<b>"+document.formProductTransferAddModify.eqvlvalue.value;*/
			//document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("Common.SalePrice.label", "Common") + "<b>" + "" + "</b>";
			document.querySelector('form[name="formProductTransferAddModify"] #fm_display_dtl_2').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") + "<b>" + fm_bin_desc + "</b>";
			if(mode==1){
				
				document.querySelector('form[name="formProductTransferAddModify"] #to_trade_dtl').innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;<b>" + fm_trade_name + "</b>";
				}
			document.querySelector('form[name="formProductTransferAddModify"] #to_expiry_date_id').innerHTML = temp_exp_date_label_to;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			document.formProductTransferAddModify.fm_expiry_date.value = fm_expiry_date;
			document.formProductTransferAddModify.fm_batch_id.value = fm_batch_id;
			document.formProductTransferAddModify.fm_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.to_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;

			if(formObj.sale_price_appl_yn.value == "Y") {
			if(sales == 0){
			document.formProductTransferAddModify.sale_price.value= 0;
			}else{
			if(to_quantity!="")
			document.formProductTransferAddModify.sale_price.value = (sales/to_quantity).toFixed(2);
			else
			document.formProductTransferAddModify.sale_price.value = 0;

			}
			}
			//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
			if(site && mode==2){
				enableAllReqToFields1();;
			}
			else{//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
				enableAllReqToFields();
			}//Added for ML-MMOH-CRF-0448 B.Badmavathi
			
			
			if (fm_expiry_yn == "N") {
				document.formProductTransferAddModify.p_to_expiry_date.readonly = true;
				document.querySelector('form[name="formProductTransferAddModify"] #Calendar').disabled = true;
			}
		}
	}
}
function validateForm() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var message = "";
	var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	if (formObj.p_fm_item_desc.value == "") {
		message = "ST_ITEM_CODE_BLANK";
		if (formObj.p_fm_item_desc.disabled == false) {
			formObj.p_fm_item_desc.focus();
		}
		messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
		return false;
	} else {
	//	console.log(document.getElementById("fm_display_dtl_1_bl"));
		if (f_query_add_mod.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerText.length <= 1 || f_query_add_mod.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerText.length == 5) {
			message = "BATCH_DETAILS_NOT_BLANK";
			if (formObj.batch_search_from.disabled == false) {
				formObj.batch_search_from.focus();
			}
			messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
			return false;
		} else {
			if (formObj.p_fm_factor.value == "") {
				message = "ITEM_CONV_FACTOR_BLANK";
				formObj.p_fm_factor.focus();
				messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
				return false;
			} else {
				if (formObj.p_fm_quantity.value == "") {
					message = "QTY_TO_TFER_NOT_BLANK";
					formObj.p_fm_quantity.focus();
					messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
					return false;
				} else {
					if (formObj.p_to_item_desc.value == "") {
						message = "ST_ITEM_CODE_BLANK";
						formObj.p_to_item_desc.focus();
						messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
						return false;
					} else {
						if (formObj.p_to_batch_id.value == "" && formObj.p_to_batch_id.disabled == false) {
							message = "BATCH_ID_NOT_BLANK";
							formObj.p_to_batch_id.focus();
							messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
							return false;
						} else {
							if (formObj.p_to_expiry_date.value == "") {
								/* if the item is expirable than only need to show */
								message = "DATE_NOT_BLANK";
								formObj.p_to_expiry_date.focus();
								messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
								return false;
							} else {
								if (!checkToDateWithSysDate(formObj.p_to_expiry_date, formObj.sys_date) == true) {
									message = "NOT_LESS_THAN_SYSDATE";
									if (formObj.p_to_expiry_date.disabled != true) {
										formObj.p_to_expiry_date.focus();
									}
									messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
									return false;
								} else {
									if (formObj.p_to_bin_location.value == "") {
										message = "BIN_LOCN_NOT_BLANK";
										formObj.p_to_bin_location.focus();
										messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
										return false;
									} else {
										if (formObj.p_to_factor.value == "") {
											message = "ITEM_CONV_FACTOR_BLANK";
											formObj.p_to_factor.focus();
											messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
											return false;
										} else {
											if (formObj.p_expect_act_qty.value == "") {
												message = "TFR_QTY_NOT_BLK";
												formObj.p_expect_act_qty.focus();
												messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
												return false;
											} else {
												if (formObj.p_actual_qty.value == "") {
													message = "TFR_QTY_NOT_BLK";
													formObj.p_actual_qty.focus();
													messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
													return false;
												} else {
													if (!checkLength1()) {
														message = "REMARKS_CHAR_EXCEEDS_LIMIT";
														messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
														return false;
													}
													else{
														if(formObj.sale_price_appl_yn.value == "Y"){
															if(formObj.sale_price.value == ""){
																message = "SALE_PRICE_NOT_BLANK";
																formObj.sale_price.focus();
																messageFrame.location.href = errorPage + "?err_num=" + getMessage(message, "ST");
																return false;
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
	return true;
}
function fn_check_items_same() {
	var fm_item_code = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_code.value;
	var to_item_code = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value;
	if (fm_item_code == "" || to_item_code == "") {
		return true;
	} else {
		if (fm_item_code == to_item_code) {
			alert(getMessage("TO_AND_FM_ITEM_NOT_SAME", "ST"));
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
			parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
			return false;
		} else {
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = true;
			return true;
		}
	}
}
function checkLength() {
	var formObj = document.formProductTransferAddModify;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.remarks, 200)) {
		return false;
	}
	return true;
}
function checkLength1() {
	var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	if (!SPCheckMaxLen(getLabel("Common.remarks.label", "Common"), formObj.remarks, 200)) {
		return false;
	}
	return true;
}
function from_stock_item_check() {
	alert(getMessage("NOT_STOCK_ITEM", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_uom_code.value = "";
	parent.frameProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.focus();
}
function to_stock_item_check() {
	alert(getMessage("NOT_STOCK_ITEM", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_uom_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();

     //check it not correct
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_unit_cost.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_expiry_date.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.value = "";
}
function from_enable_Batch_Button() {
//08/05/12
	//parent.frameProductTransferAddModify.document.formProductTransferAddModify.batch_search_from.disabled = false;
	parent.frameProductTransferAddModify.document.getElementById("batch_search_from").disabled = false;
}
function from_disable_Batch_Button() {
	alert(getMessage("STOCK_NOT_AVAILABLE", "ST"));
	parent.frameProductTransferAddModify.document.getElementById("batch_search_from").disabled = true;
	parent.frameProductTransferAddModify.document.getElementById("p_fm_item_desc").value = "";
	parent.frameProductTransferAddModify.document.getElementById("fm_uom_code").value = "";
	parent.frameProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = "";
}
function from_display_data() {
  	//parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML="UOM&nbsp;"+"<b>"+retVal[15]+"</b>"
}
/*
function to_display_data()
{
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML="<b>"+retVal[15]+"</b>"
} 
*/
function fn_from_expiry_yn() {
	alert(getMessage("BOTH_ITEM_EXP_OR_NON_EXP", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.value = "";
	parent.frameProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.focus();
	fm_expiry_yn = "";
}
function fn_to_expiry_yn() {
	alert(getMessage("BOTH_ITEM_EXP_OR_NON_EXP", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_unit_cost.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_expiry_date.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.value = "";
	to_expiry_yn = "";
}
function populateBinLocation() {
	var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
	var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
//	xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?" + "&store_code=" + store_code + "&item_code=" + formObj.to_item_code.value + "&validate=BIN_LOCATION", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function checkWithAvlQty(obj) {
	checkDoubleFormat(obj);
	var qty_to_transfer = document.formProductTransferAddModify.p_fm_quantity.value;
	if (parseFloat(fm_avail_qty) < parseFloat(qty_to_transfer)) {
		alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
		document.formProductTransferAddModify.p_fm_quantity.value = "";
		document.formProductTransferAddModify.p_fm_quantity.focus();
		return false;
	} else {
		ComputeToQuantity();
		return true;
	}
}
function CheckForZeroFrom(obj) {
	if (checkDoubleFormat(obj)) {
		ComputeToQuantity();
	} else {
		obj.focus();
	}
	/*
	var FactorVal=obj.value ;
	if(parseFloat(FactorVal)==0)
	{
		alert(getMessage("CANNOT_BE_ZERO"));
        obj.focus();
	} */
}
function CheckForZeroTo(obj) {
	if (checkDoubleFormat(obj)) {
		ComputeToQuantity();
	} else {
		obj.focus();
	}
	/*
	var FactorVal=obj.value ;
	if(parseFloat(FactorVal)==0)
	{
		alert(getMessage("CANNOT_BE_ZERO"));
        obj.focus();
	} */
}
function ComputeToQuantity() {
	var fm_quantity = document.formProductTransferAddModify.p_fm_quantity.value;
	var mode = document.formProductTransferAddModify.mode.value;
	var nooflabel = 1;
	var fm_factor = document.formProductTransferAddModify.p_fm_factor.value;
	var to_factor = document.formProductTransferAddModify.p_to_factor.value;
	var from_stk_uom = document.formProductTransferAddModify.fm_uom_code.value;
	var to_stk_uom = document.formProductTransferAddModify.to_uom_code.value;
	var convfactor = document.formProductTransferAddModify.eqvlvalue.value;
	//var label_reqd_yn=document.formProductTransferAddModify.label_reqd_yn.value;
	if(document.formProductTransferAddModify.barcode_applicable.value== "true"){ //31/05/12
    if(document.formProductTransferAddModify.site_id.value	=="MOHBR"){
	if(document.formProductTransferAddModify.label_reqd_yn_1.checked == true|| document.formProductTransferAddModify.label_reqd_yn_2.checked == true) {
	var lableyn = true;
	}else{
	var lableyn = false;
	}
	}else{
	var lableyn = document.formProductTransferAddModify.label_reqd_yn.checked;
	}
	}else{
		var lableyn = document.formProductTransferAddModify.label_reqd_yn.checked;
	}
	//alert(lableyn);
	if (convfactor == null || convfactor == "") {
		convfactor = "1";
	}
	var nooflabel = 1;
	if (fm_quantity != "" && fm_factor != "" && to_factor != "") {
		/*if(document.formProductTransferAddModify.to_quantity.value=="")
		{*/

		var to_quantity = parseFloat((fm_quantity * parseInt(convfactor)) * (to_factor / fm_factor));
		if(document.formProductTransferAddModify.no_deci_to.value =='')
          document.formProductTransferAddModify.no_deci_to.value ='0';
		document.formProductTransferAddModify.to_quantity.value = to_quantity.toFixed(parseInt(document.formProductTransferAddModify.no_deci_to.value));

		parent.frameProductTransferAddModify.document.getElementById("p_to_quantity").innerHTML = getLabel("eST.ExpectedQuantity.label", "ST") + "&nbsp;&nbsp;<b>" + document.formProductTransferAddModify.to_quantity.value; + "</b>";//modified for ml-mmoh-scf-1065
		//document.formProductTransferAddModify.p_actual_qty.value = to_quantity.toFixed(parseInt(document.formProductTransferAddModify.no_deci_to.value));;//commented for ML-MMOH-1065
		document.formProductTransferAddModify.p_actual_qty.value=document.formProductTransferAddModify.to_quantity.value;//added for ML-MMOH-SCF-1065
		if(document.formProductTransferAddModify.sale_price_appl_yn.value=="Y")
		document.formProductTransferAddModify.sale_price.value =  (document.formProductTransferAddModify.fr_sale_price.value/to_quantity).toFixed(2);

	/*}else 
		{
		var to_quantity = document.formProductTransferAddModify.to_quantity.value;
		document.formProductTransferAddModify.to_quantity.value = to_quantity;
		document.formProductTransferAddModify.document.getElementById("p_to_quantity").innerHTML = getLabel("eST.ExpectedQuantity.label", "ST") + "&nbsp;&nbsp;<b>" + to_quantity + "</b>";
		document.formProductTransferAddModify.p_actual_qty.value = to_quantity;
		}*/
		if (lableyn == true && mode == 1 ) {
			document.formProductTransferAddModify.no_of_labels.value = Math.ceil(to_quantity);
		} 
		var bal_quantity = parseFloat((parseInt(convfactor) * parseFloat(setNumber(fm_quantity,parseInt(document.formProductTransferAddModify.no_deci_to.value)))) * to_factor) - ((setNumber(to_quantity,parseInt(document.formProductTransferAddModify.no_deci_to.value))) * fm_factor);
        if(bal_quantity>0)
		{
         //document.formProductTransferAddModify.no_deci_to.value ='0';
		document.formProductTransferAddModify.document.getElementById("p_expect_bal_qty").innerHTML = getLabel("eST.ExpectedBalanceQuantity.label", "ST") + "&nbsp;&nbsp;<b>" + bal_quantity.toFixed(parseInt(document.formProductTransferAddModify.no_deci_to.value)); + "</b>";
		document.formProductTransferAddModify.p_act_expect_bal_qty.value = bal_quantity.toFixed(parseInt(document.formProductTransferAddModify.no_deci_to.value));
			//document.formProductTransferAddModify.p_expect_bal_qty.value=bal_quantity;
		document.formProductTransferAddModify.p_expect_act_qty.value = bal_quantity.toFixed(parseInt(document.formProductTransferAddModify.no_deci_to.value));
		}
		if(bal_quantity==0)
		{
		parent.frameProductTransferAddModify.document.getElementById("p_expect_bal_qty").innerHTML = getLabel("eST.ExpectedBalanceQuantity.label", "ST") + "&nbsp;&nbsp;<b>" + bal_quantity + "</b>";
		document.formProductTransferAddModify.p_act_expect_bal_qty.value = bal_quantity;
			//document.formProductTransferAddModify.p_expect_bal_qty.value=bal_quantity;
		document.formProductTransferAddModify.p_expect_act_qty.value = bal_quantity;
		
		}
		
	}
}
function checkForValidFactor() {
	
	var actualqty = document.formProductTransferAddModify.p_expect_act_qty.value;
	var fromfactor = document.formProductTransferAddModify.p_fm_factor.value;
	if (parseFloat(actualqty) > parseFloat(fromfactor)) {
		alert(getMessage("AVAILQTY_LESS_THAN_FACTOR", "ST"));
		document.formProductTransferAddModify.p_expect_act_qty.value = "";
		document.formProductTransferAddModify.p_expect_act_qty.focus();
	
	}
}
function setFinalize_allowed(_finalize_allowed_yn) {//Added for ML-MMOH-CRF-0448 B.Badmavathi
	f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.finalize_allowed_yn.value = _finalize_allowed_yn;
}
function onSuccess() {
   //f_query_add_mod.frameProductTransferAddModify.location.href="../../eST/jsp/ProductTransferAddModify.jsp?function_id=ST_PRODUCT_TRANSFER" ;
	f_query_add_mod.frameProductTransferHeader.location.href = "../../eST/jsp/ProductTransferHeader.jsp?function_id=ST_PRODUCT_TRANSFER";
	var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	//var site = formObj.site.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var mode = formObj.mode.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	if(mode==2 && formObj.site.value == "true"){//Added for ML-MMOH-CRF-0448 B.Badmavathi
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag1;
		
	}
	else{
	
	if(f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.barcode_applicable.value =="true"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag1 + "   Batch ID : " + f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.next_batch_id.value+ "   Barcode ID : " + f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.to_barcode_id.value;
	}else{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" + flag1 + "   Batch ID : " + f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.next_batch_id.value;
	}
	}
	f_query_add_mod.frameProductTransferAddModify.location.href = "../../eCommon/html/blank.html";
}
async function apply() {
	if(  f_query_add_mod.frameProductTransferAddModify==undefined){//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016
	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	return;
} 
//    p_to_expiry_date
	var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	//alert(formObj.label_reqd_yn.vallue);
	var site = formObj.site.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var store_code = f_query_add_mod.frameProductTransferHeader.formProductTransferHeader.store_code.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	var auto = formObj.auto_gen_batch_yn.value;  
 	if(formObj.barcode_applicable.value =="true"){
	var facility_id = formObj.facility_id.value;
	var bean_id   = formObj.bean_id.value; 
	var bean_name   = formObj.bean_name.value; 
	var fm_barcode_id = formObj.fm_barcode.value;  
	var to_barcode_id = formObj.to_barcode_id.value;
	var to_quantity = formObj.p_actual_qty.value
	 }
	if (formObj.to_batch_id_applicable_yn_1.value == "N") {
		auto = "N";
	}
	if (formObj.to_batch_id_applicable_yn_1.value == "E") {
		var exp = (formObj.p_to_expiry_date.value).split("/");
		formObj.next_batch_id.value = exp[0] + exp[1] + exp[2];
	}
	var repack2 = formObj.repack_group2.value;
	if (auto == "N") {
		formObj.next_batch_id.value = formObj.p_to_batch_id.value;
		        // alert(formObj.next_batch_id.value);

	}
	if (formObj.to_batch_id_applicable_yn_1.value == "N" || formObj.to_batch_id_applicable_yn_1.value == "Y") {
		if (repack2 == "") {
			formObj.next_batch_id.value = formObj.p_to_batch_id.value;
		}
	}
	// alert(formObj.next_batch_id.value);
	var errorPage = "../../eCommon/jsp/error.jsp";
	var validate=await validateForm();
	if (validate) {
  
 //alert(formObj.p_to_batch_id.disabled);
     if(formObj.barcode_applicable.value =="true"){
         if(formObj.p_to_batch_id.disabled == true){
	     CallNewBarcodeStringforproduct(bean_id,bean_name,facility_id,formObj.to_item_code.value,formObj.next_batch_id,formObj.p_to_expiry_date,formObj.to_trade_id,formObj.p_to_bin_location,store_code, formObj.to_barcode_id,formObj.p_actual_qty,formObj.sale_price);
		 }
	 }
		addToList("add");
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
		if(formObj.site.value == "true"){
			var finalizeType = "N";
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?CHECK_AUTH_YN=CHECKAUTH&store_code=" + store_code, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText); 
			if (formObj.finalize_allowed_yn.value == "Y") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" function_type=\"2\" ";		
				xmlStr +=" /></root>" ; 
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type=" + formObj.trn_type.value + "&store_code="+store_code, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);		
				var response = "";
				if(result){
					response = await confirmFinalize();
				}else{
					response = YES;
				}
				if(response=="")
				{
				messageFrame.location.href = errorPage + "?err_num=";
				return false;
				}
				if (response == YES) {
					formObj.finalize_yn.value = "Y";
				}
				else{
					formObj.finalize_yn.value="N";
				}
			}
			else
			{
				formObj.finalize_yn.value="N";
			}
		}
		//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
		
		var responseText = formApply(formObj, ST_CONTROLLER);
		eval(responseText);
		flag1 = (flag.split("~"))[0];
		flag2 = (flag.split("~"))[1];
		flag1 = (flag1 == "null" ? "" : flag1);
		if (result) {
			if (flag2 == "PY") {
				var PConfirm = await confirmPrinting();
				if (PConfirm == "Yes") {
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
				//	xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//operation="+operation+"&doc_srl_no="+formObj.doc_srl_no.value+"&store_code="+store_code+"&fm_item_code="+formObj.fm_item_code.value+"&to_item_code="+formObj.to_item_code.value+"&fm_uom_code="+formObj.fm_uom_code.value
					//xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?validate=printOnlineDoc" + "&labelreqd=" + formObj.label_reqd_yn.value + "&nooflabels=" + formObj.no_of_labels.value + "&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?validate=printOnlineDoc" + "&labelreqd=" + formObj.label_reqd_yn.value + "&nooflabels=" + formObj.no_of_labels.value + "&msg=" + encodeURIComponent(message), true);
						//+"&bean_id="+bean_id+"&bean_name="+bean_name
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
				}
			}else 	if (flag2 == "PN") {
			
					var xmlHttp = new XMLHttpRequest();
					var xmlDoc="";
					//xmlDoc.loadXML(getXMLString(null));
					xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
						//operation="+operation+"&doc_srl_no="+formObj.doc_srl_no.value+"&store_code="+store_code+"&fm_item_code="+formObj.fm_item_code.value+"&to_item_code="+formObj.to_item_code.value+"&fm_uom_code="+formObj.fm_uom_code.value
					//xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?validate=printOnlineDoc" + "&labelreqd=" + formObj.label_reqd_yn.value + "&nooflabels=" + formObj.no_of_labels.value + "&msg=" + encodeURIComponent(message), false);
					xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?validate=printOnlineDoc" + "&labelreqd=" + formObj.label_reqd_yn.value + "&nooflabels=" + formObj.no_of_labels.value + "&msg=" + encodeURIComponent(message), true);
						//+"&bean_id="+bean_id+"&bean_name="+bean_name
					xmlHttp.send(xmlDoc);
					responseText = xmlHttp.responseText;
					eval(responseText);
				
			}
		}
		messageFrame.location.href = errorPage + "?err_num=" + encodeURIComponent(message) + "<BR>" + flag1;
		if (result) {
			onSuccess();
		}
	}
}
function addToList(obj) {

	var operation = obj;
	var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	var auto = formObj.auto_gen_batch_yn.value;
	var store_code = f_query_add_mod.frameProductTransferHeader.formProductTransferHeader.store_code.value;
	var prepare_location = f_query_add_mod.frameProductTransferHeader.formProductTransferHeader.prep_loc.value;
	var actual_qty = formObj.p_actual_qty.value;
	var expect_bal_qty = formObj.p_act_expect_bal_qty.value;
	var expect_act_qty = formObj.p_expect_act_qty.value;
	var counter_check = formObj.p_counter_chk.value;
	var time_taken = formObj.time_taken.value;
	var p_auth_by = formObj.p_auth_by.value;
	var p_packed_by = formObj.p_packed_by.value;
	var no_of_labels = formObj.no_of_labels.value;
    if(formObj.barcode_applicable.value =="true"){
	var fm_barcode_id = formObj.fm_barcode.value;  
	var to_barcode_id = formObj.to_barcode_id.value;
	//alert("to_barcode_id" +to_barcode_id);
	}
  ////ML-MMOH-SCF-1861
    if(formObj.doc_no.value!= undefined)
		doc_no = formObj.doc_no.value;
	else
		doc_no=""; 
	if(formObj.doc_type_code.value!=undefined)
		doc_type_code = formObj.doc_type_code.value; 
	else
		doc_type_code=""; 
    var prod_transfer_mode = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.prod_transfer_mode.value; //ML-MMOH-SCF-1861   
	var mode = formObj.mode.value;//Added for ML-MMOH-CRF-0448 B.Badmavathi
	
	var	fr_sale_price
	var to_sale_price;

	if(formObj.fr_sale_price!= undefined)
	fr_sale_price = formObj.fr_sale_price.value;
	else
	to_sale_price = "";	

	if(formObj.sale_price!= undefined)
	 to_sale_price = formObj.sale_price.value;
	else
	 to_sale_price = "";

	var proceed = false;
	var messageFrame = parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
/*Commented for ML-MMOH-CRF-0448 B.Badmavathi starts
	if(formObj.barcode_applicable.value =="true"){
		if (operation == "add") {
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.fm_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.next_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value+"&to_barcode_id="+ to_barcode_id +"&fm_barcode_id="+ fm_barcode_id  + "&validate=ADD_TO_LIST", false);
	}
	}else{
		if (operation == "add") {
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.fm_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.next_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value+ "&validate=ADD_TO_LIST", false);   
		}
	}
*/	
//Modified for ML-MMOH-CRF-0448 B.Badmavathi starts
	if(mode != 2)
	{
		if(formObj.barcode_applicable.value =="true"){
			if (operation == "add") {
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.fm_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.next_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value+"&to_barcode_id="+ to_barcode_id +"&fm_barcode_id="+ fm_barcode_id + "&prod_transfer_mode="+ prod_transfer_mode  + "&doc_no="+ doc_no+ "&doc_type_code="+ doc_type_code+ "&validate=ADD_TO_LIST", false);//ML-MMOH-SCF-1861
			}
		}else{
			if (operation == "add") {
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.fm_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.next_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value + "&prod_transfer_mode="+ prod_transfer_mode + "&doc_no="+ doc_no+ "&doc_type_code="+ doc_type_code +  "&validate=ADD_TO_LIST", false);   //ML-MMOH-SCF-1861
			}
		}
	}
	else
	{
		if(formObj.barcode_applicable.value =="true"){
			if (operation == "add") {
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.from_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.to_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value+"&to_barcode_id="+ to_barcode_id +"&fm_barcode_id="+ fm_barcode_id + "&prod_transfer_mode="+ prod_transfer_mode  + "&doc_no="+ doc_no+ "&doc_type_code="+ doc_type_code+ "&validate=ADD_TO_LIST", false);//ML-MMOH-SCF-1861
			}
		}else{
			if (operation == "add") {
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?operation=" + operation + "&doc_srl_no=" + formObj.doc_srl_no.value + "&store_code=" + store_code + "&fm_item_code=" + formObj.from_item_code.value + "&to_item_code=" + formObj.to_item_code.value + "&fm_uom_code=" + formObj.fm_uom_code.value + "&to_uom_code=" + formObj.to_uom_code.value + "&fm_batch_id=" + formObj.fm_batch_id.value + "&to_batch_id=" + formObj.to_batch_id.value + "&fm_expiry_date=" + formObj.fm_expiry_date.value + "&to_expiry_date=" + formObj.p_to_expiry_date.value + "&fm_trade_id=" + formObj.fm_trade_id.value + "&to_trade_id=" + formObj.to_trade_id.value + "&fm_bin_location_code=" + formObj.fm_bin_location_code.value + "&to_bin_location_code=" + formObj.p_to_bin_location.value + "&fm_conversion_factor=" + formObj.p_fm_factor.value + "&to_conversion_factor=" + formObj.p_to_factor.value + "&fm_item_quantity=" + formObj.p_fm_quantity.value + "&to_item_quantity=" + formObj.to_quantity.value + "&fm_item_unit_cost=" + formObj.fm_item_unit_cost.value + "&to_item_unit_cost=" + formObj.to_item_unit_cost.value + "&remarks=" + formObj.remarks.value + "&prepare_location=" + prepare_location + "&actual_qty=" + actual_qty + "&expect_bal_qty=" + expect_bal_qty + "&expect_act_qty=" + expect_act_qty + "&counter_check=" + counter_check + "&time_taken=" + time_taken + "&p_auth_by=" + p_auth_by + "&p_packed_by=" + p_packed_by + "&no_of_labels=" + no_of_labels + "&request_no=" + formObj.request_no.value  + "&to_sale_price="+ to_sale_price + "&fr_sale_price="+ fr_sale_price + "&sale_price_appl_yn="+ formObj.sale_price_appl_yn.value + "&prod_transfer_mode="+ prod_transfer_mode+ "&doc_no="+ doc_no+ "&doc_type_code="+ doc_type_code+ "&validate=ADD_TO_LIST", false);//added for  ML-MMOH-SCF-1861
			}
		}
	}
//Modified for ML-MMOH-CRF-0448 B.Badmavathi ends
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function enableAllToFields() {
	document.formProductTransferAddModify.p_to_item_desc.disabled = false;
	document.formProductTransferAddModify.item_search_to.disabled = false;
	document.formProductTransferAddModify.p_to_expiry_date.disabled = false;
	document.formProductTransferAddModify.p_to_bin_location.disabled = false;
	document.formProductTransferAddModify.p_to_factor.disabled = false;
	document.formProductTransferAddModify.remarks.disabled = false;
	document.formProductTransferAddModify.p_to_batch_id.disabled = false;
	document.getElementById("Calendar").disabled = false;
	document.formProductTransferAddModify.p_fm_factor.focus();
}
function to_disable_expiry_date() {
	document.formProductTransferAddModify.p_to_expiry_date.disabled = true;
	document.getElementById("Calendar").disabled = true;
}
function fn_check_for_item_validation_from() {
	if (document.formProductTransferAddModify.p_fm_item_desc.value != "") {
		if (document.formProductTransferAddModify.p_fm_item_desc.disabled == false) {
		//document.formProductTransferAddModify.item_search_from.click();
			return true;
		}
		return fn_check_items_same();
	}
}
function fn_check_for_item_validation_to() {
	if (document.formProductTransferAddModify.p_to_item_desc.value != "") {
		if (document.formProductTransferAddModify.p_to_item_desc.disabled == false) {
			document.formProductTransferAddModify.item_search_to.click();
			return true;
		}
		return fn_check_items_same();
	}
}
function setDefaultBatchId(BatchId) {
	parent.frameProductTransferAddModify.document.getElementById("p_to_batch_id").value = BatchId;
	parent.frameProductTransferAddModify.document.getElementById("p_to_batch_id").disabled = true;
	 
	
}
function setDefaultTradeId(TradeId) {
	parent.frameProductTransferAddModify.document.getElementById("to_trade_dtl").innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;&nbsp;<b>" + TradeId + "</b>";
	parent.frameProductTransferAddModify.document.getElementById("to_trade_id").value = TradeId;
}
function checkToDateWithSysDate(entered_date, sys_date) {
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(enteredDateObject) >= Date.parse(sysDateObject)) {
			return true;
		}
		if (Date.parse(enteredDateObject) < Date.parse(sysDateObject)) {
			return false;
		}
	}
}
function refreshDetails() {
	parent.frameProductTransferAddModify.location.reload();
	//parent.frameProductTransferList.location.reload(); 
}
function fn_trade_id_applicable_yn() {
	alert(getMessage("ONLY_TRADE_SPEC_ITEM_ALWD", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
	if (request_flag == "Y") {
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.disabled = false;
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.item_search_to.disabled = false;
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();
	} else {
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();
	}
		//to_expiry_yn="";
}
function repacking_groups_different() {
	alert(getMessage("REPACKING_GROUPS_DIFFERENT", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
	//document.formProductTransferAddModify.p_to_item_desc.focus();
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_trade_id.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.value = "";
}
function conv_factor_not_defined() {
	alert(getMessage("CONV_FACTOR_NOT_DEFINED", "ST"));
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
	if(parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.disabled==false)
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_trade_id.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.value = "";
	//parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.value="";
}
function next_batch_id(next_batch_id) {
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled = true;
	parent.frameProductTransferAddModify.document.getElementById("imgs").style.visibility = "hidden";
	 
	
}
function enable_batch_id() {
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled = false;
	parent.frameProductTransferAddModify.document.getElementById("imgs").style.visibility = "visible";
}
function callItemSearchScreenFrom() {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	if (request_flag == "N") {
		if (parent.frameProductTransferAddModify.document.getElementById('fm_display_dtl_1_bl').innerHTML != "&nbsp;") {
			parent.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerHTML = "&nbsp;";
			parent.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;";
			parent.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_el").innerHTML = "&nbsp;";
			parent.frameProductTransferAddModify.document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;";
			parent.frameProductTransferAddModify.document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

		}
	
		var search_string;
		if (parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.readOnly == true) {
			search_string = "";
		} else {
			search_string = parent.frameProductTransferAddModify.formProductTransferAddModify.p_fm_item_desc.value;
		}
	
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		var category = "A";
		var sole_source = "A";
		var ps_item = "A";
		var mfg_item = "A";
		var expiry = "A";
		var consignment = "A";
		var item_class = parent.frameProductTransferHeader.formProductTransferHeader.item_class_code.value;
		var item_class_check = parent.frameProductTransferHeader.formProductTransferHeader.item_class_check.value;
		if (item_class_check == "Y") {
			if ((item_class == "") || (item_class == "null")) {
				alert(getMessage("ITEM_CLASS_CANNOT_BLANK", "ST"));
			}
			if ((item_class_check == "Y") && ((item_class != "") && (item_class != "null"))) {
				sub1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
			}
		} else {
			sub1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
		}
	}
}
		async function sub1(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment) {
	//var request_yn=parent.frameProductTransferHeader.formProductTransferHeader.request_yn.value;
			request_flag = parent.frameProductTransferHeader.formProductTransferHeader.request_flag.value;
			//Modified by Sakti against AMS-CRF-0011 trn_type passing
			//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
			//fm_retVal = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRD");
			
			fm_retVal = await callItemSearchWindow_PRD(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRD","1");
			//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end
			if (fm_retVal == null) {
				return;
			}
			fm_trade_id_applicable_yn = fm_retVal[17];
			console.log(parent.frameProductTransferAddModify);
			console.log(parent.frameProductTransferAddModify.document.getElementById("lblItem"));
			parent.frameProductTransferAddModify.document.getElementById("lblItem").title = getLabel("Common.item.label", "Common") + " " + getLabel("Common.code.label", "Common") + ":" + fm_retVal[0];
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_code.value = fm_retVal[0];
			fromitemcode = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_code.value;
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.value = fm_retVal[1];
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_uom_code.value = fm_retVal[13];
			fromuomcode = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_uom_code.value;
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_unit_cost.value = fm_retVal[14];
			parent.frameProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + fm_retVal[15] + "</b>";
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.readOnly = true;
			fm_expiry_yn = fm_retVal[2];
			if (fm_trade_id_applicable_yn == "N") {
	   //document.formProductTransferAddModify.p_to_item_desc.value  = document.formProductTransferAddModify.fm_item_code.value;
	   //document.formProductTransferAddModify.to_item_code.value =   document.formProductTransferAddModify.fm_item_code.value;
	   //document.formProductTransferAddModify.item_search_to.disabled = true;
   	   //document.formProductTransferAddModify.p_to_item_desc.disabled = true;
			} else {
		//sole_source_depends_on_trade_fm = "N";
			}
//	&& fm_retVal[0].length>0
			if (fm_retVal != null && fm_retVal[0].length > 0) {
				item_flag = "Y";
			} else {
				item_flag = "N";
			}
	//cut
	if (item_flag == "Y") {
		if (request_flag == "Y") {
			var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
			var fm_item_code = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_item_code.value;
			fromuom = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_uom_code.value;
			fromuomcode = fromuom;
			var fromuomdesc = parent.frameProductTransferAddModify.document.formProductTransferAddModify.from_uom_desc.value;
			parent.frameProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + fromuomdesc + "</b>";
			//alert(fromuomdesc);
//				from_item_desc = parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.from_item_desc.value;
				from_item_desc = parent.frameProductTransferAddModify.document.getElementById('from_item_desc').value;
				parent.frameProductTransferAddModify.document.getElementById('p_fm_item_desc').value = from_item_desc;
				var fromtradeidapplicable = parent.frameProductTransferAddModify.document.getElementById('from_req_trade_id_applicable_yn').value;
				fm_trade_id_applicable_yn = fromtradeidapplicable;
				fromexpiry = parent.frameProductTransferAddModify.document.getElementById('fm_expiry_yn').value;
				
				
				var fromtradeidapplicableyn = parent.frameProductTransferAddModify.document.getElementById('from_req_trade_id_applicable_yn').value;
				fromitemcode = fm_item_code;
				fm_expiry_yn = fromexpiry;
			}
			if (request_flag == "Y" || request_flag == "N") {
				parent.frameProductTransferHeader.document.formProductTransferHeader.store_code_disabled.value = "disabled";
				var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
				
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getEnhancedXMLString(formObj));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?item_code=" + fromitemcode + "&store_code=" + store_code + "&validate=ITEM_CODE" + "&label=from" + "&to_expiry_yn=" + to_expiry_yn + "&fm_expiry_yn=" + fm_expiry_yn + "&stk_uom=" + fromuomcode + "&requestflag=" + request_flag, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
			
		}
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			refreshDetails();
		}
	}


		}
		
	

async function callItemSearchScreenTo() {
	if (request_flag1 == "N") {
		var search_string;
		if (parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly == true) {
			search_string = "";
		} else {
			search_string = parent.frameProductTransferAddModify.formProductTransferAddModify.p_to_item_desc.value;
		}
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		var category = "A";
		var sole_source = "A";
	//sole_source = sole_source_depends_on_trade_fm;
		var ps_item = "A";
		var mfg_item = "A";
		var expiry = "A";
		var consignment = "A";
		var item_class = "";
		//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 beg
		//to_retVal = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRD");
		to_retVal = await callItemSearchWindow_PRD(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"PRD","2");
		//Added by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 end
		if (to_retVal == null) {
			return;
		}
		parent.frameProductTransferAddModify.document.getElementById("lblItem_2").title = getLabel("Common.item.label", "Common") + "    " + getLabel("Common.code.label", "Common") + ":" + to_retVal[0];
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value = to_retVal[0];
		//alert(parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value);
		toitemcode = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value;
	//tooitemcode=parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value;	
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = to_retVal[1];
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_uom_code.value = to_retVal[13];
		touomcode = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_uom_code.value;
	
	//check it not correct
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_unit_cost.value = to_retVal[14];
		parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + to_retVal[15] + "</b>";
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = true;
		to_expiry_yn = to_retVal[2];
		to_trade_id_applicable_yn = to_retVal[17];
		to_batch_id_applicable_yn = to_retVal[18];
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_batch_id_applicable_yn_1.value = to_batch_id_applicable_yn;
		if (to_retVal != null && to_retVal[0].length > 0) {
			item_flag1 = "Y";
		} else {
			item_flag1 = "N";
		}
	}
	if (item_flag1 == "Y") {
		if (request_flag1 == "Y") {
			var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
			var to_item_code = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_item_code.value;
			toitemcode = to_item_code;
			toexpiry = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_expiry_yn.value;
			touom = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_uom_code.value;
			touomcode = touom;
			var toouomdesc = parent.frameProductTransferAddModify.document.formProductTransferAddModify.too_uom_desc.value;
			parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + toouomdesc + "</b>";
			//alert(toouomdesc);
			totradeidapplicableyn = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_req_trade_id_applicable_yn.value;
			to_trade_id_applicable_yn = totradeidapplicableyn;
			batchidapplicableyn = parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_req_batch_id_applicable_yn.value;
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.to_batch_id_applicable_yn_1.value = batchidapplicableyn;
			to_batch_id_applicable_yn = batchidapplicableyn;
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.disabled = false;
			too_item_desc = parent.frameProductTransferAddModify.document.getElementById('too_item_desc').value;
			parent.frameProductTransferAddModify.document.getElementById('p_to_item_desc').value = too_item_desc;
			parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.focus();

					 //populateBinLocation();

		}
		/*else
			{
				 /*var rpk1=parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.repack_group1.value;
				 var rpk2=parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.repack_group2.value;
				 alert(rpk1);
				 alert(rpk2);
				 
				 if(rpk1==rpk2)
				{
					 alert("entrring");
					parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.disabled=false;
					parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.focus() ;
				}

			 }*/
		if (request_flag == "Y" || request_flag == "N") {
			var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getEnhancedXMLString(formObj));
			xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?item_code=" + toitemcode + "&store_code=" + store_code + "&validate=ITEM_CODE" + "&label=to" + "&to_expiry_yn=" + to_expiry_yn + "&fm_expiry_yn=" + fm_expiry_yn + "&to_batch_id_applicable_yn=" + to_batch_id_applicable_yn + "&to_trade_id_applicable_yn=" + to_trade_id_applicable_yn + "&fm_trade_id_applicable_yn=" + fm_trade_id_applicable_yn + "&to_stk_uom=" + touomcode + "&stk_uom=" + fromuomcode + "&repack_group1=" + parent.frameProductTransferAddModify.document.getElementById("repack_group1").value + "&eqvlvalue=" + parent.frameProductTransferAddModify.document.getElementById("eqvlvalue").value + "&requestflag=" + request_flag + "&item_code_1=" + toitemcode, false);
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			eval(responseText);
		}
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
			refreshDetails();
		}
	}
	fn_check_items_same();
}
async function callRequestSearch() {



	var store_code = document.forms[0].store_code.value;
	
	var store_desc = document.getElementById("store_desc").innerText;
	var batchRequest = await callRequestSearchWindow(store_code, store_desc); 
	//alert(batchRequest);
	var arr_values = new Array();
	if (batchRequest == null || batchRequest==undefined) {

		document.formProductTransferHeader.request_flag.value = "N";
		document.formProductTransferHeader.request_yn.value = "N";
		return;
	}
	document.formProductTransferHeader.request_flag.value = "Y";
	document.formProductTransferHeader.request_yn.value = "Y";
	if (batchRequest.length > 0) {
		arr_values = batchRequest.split("`");
		prod_tfr_request_no = arr_values[0];
		fm_item_code = arr_values[1];
		fm_qty_on_hand = arr_values[2];
		fm_item_desc = arr_values[6];
		to_item_code = arr_values[3];
		to_qty_on_hand = arr_values[4];
		allow_deci_yn_from =arr_values[7];
		no_deci_from =arr_values[8];
		allow_deci_yn_to =arr_values[9];
		no_deci_to =arr_values[10];
		//fromuom = parent.frameProductTransferAddModify.document.formProductTransferAddModify.fm_uom_code.value;
		//alert(fromuom);
		//fromuomdesc = fromuom;
	}
	
	if (batchRequest != "") {
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML="UOM&nbsp;"+"<b>"+fromuomdesc+"</b>";
		//parent.frameProductTransferHeader.document.formProductTransferHeader.document.getElementById("request_no_hdr").innerHTML = getLabel("eST.ReqNo.label", "ST") + "  :" + "<b>" + prod_tfr_request_no + "</b>";
		document.getElementById("request_no_hdr").innerHTML = getLabel("eST.ReqNo.label", "ST") + " : <b>" + prod_tfr_request_no + "</b>";
		var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;	//parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.value=fm_item_code;
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.item_search_from.click();
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.item_search_from.itemvisibility='hidden';
		formObj.p_fm_item_desc.value = fm_item_desc; 
			//formObj.p_fm_item_desc.disabled=true; 
		formObj.item_search_from.disabled = true; 
			//formObj.p_to_item_desc.value=to_item_code;
			

	       
		formObj.p_fm_quantity.value = parseFloat(fm_qty_on_hand).toFixed(parseInt(no_deci_from));
		formObj.to_quantity.value  = to_qty_on_hand;
		formObj.p_fm_factor.value = arr_values[5];
		formObj.item_search_to.disabled = false;
		formObj.p_to_bin_location.disabled = false;
		formObj.p_to_bin_location.focus();
		formObj.request_no.value = prod_tfr_request_no;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
//		xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?item_code=" + fm_item_code + "&store_code=" + store_code + "&itemlabel=from" + "&validate=ITEM_FROM_SEARCH", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		} else {
			request_flag = "Y";
			item_flag = "Y";
			callItemSearchScreenFrom();
		}
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = to_item_code;
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.item_search_to.disabled = true;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		// xmlDoc.loadXML(getEnhancedXMLString(formObj));
		xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?item_code=" + to_item_code + "&store_code=" + store_code + "&validate=ITEM_FROM_SEARCH" + "&itemlabel=to", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "ST");
		} else {
			request_flag1 = "Y";
			item_flag1 = "Y";
			callItemSearchScreenTo();
		}
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_expiry_date.disabled = false;
 	parent.frameProductTransferAddModify.document.getElementById("Calendar").disabled = false;
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = to_item_code;
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled=false;
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_factor.value=fm_conv_factor;
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_factor.disabled=false;
			//parent.frameProductTransferAddModify.document.formProductTransferAddModify.remarks.value=to_conv_factor;

		parent.frameProductTransferHeader.document.getElementById("prt_delete_yn").value=arr_values[7];

		parent.frameProductTransferAddModify.document.formProductTransferAddModify.remarks.disabled = false;
		parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_quantity.focus();
		
	}
}
async function callRequestSearchWindow(store_code, store_desc) {
	var retVal = await window.showModalDialog("../../eST/jsp/ProductTransferRequestSearchFrame.jsp?store_code=" + store_code + "&store_desc" + store_desc, "", "dialogHeight:80vh; dialogWidth:60vw; center:1; status: no;  dialogTop :20; scrolling :auto");
	return retVal;
}
function RequestsearchVals() {
	objform = parent.frameProductTransferRequestSearchQueryCriteria.document.ProductTransferRequestSearchCriteria_Form;
	var r_store_code = "";
	var r_request_no = "";
	var searchFunction = "";
	r_store_code = objform.r_store_code.value;
	r_request_no = objform.r_request_no.value;
	parent.frameProductTransferRequestSearchQueryResult.document.location.href = "../../eST/jsp/ProductTransferRequestSearchQueryResult.jsp?r_store_code=" + r_store_code + "&r_request_no=" + r_request_no;
}
function returnVals() {
	var j = 0;
	var formObj = parent.frameProductTransferRequestSearchQueryResult.document.ProductTransferRequestSearchCriteria;
	var returnvals = "";
	var count = formObj.totalRecords.value;
	//parent.frameProductTransferHeader.formProductTransferHeader.prt_delete_yn.value=formObj.prt_delete_yn.value
	var index = "";
	var noOfCheckedRecords = "";
	for (var i = 0; i < count; i++) {
		if (formObj.elements["check" + i].checked) { 	
			returnvals += formObj.elements["prod_tfr_req_no" + i].value + "`" + formObj.elements["fm_item_code" + i].value + "`" + formObj.elements["fm_item_qty" + i].value + "`" + formObj.elements["to_item_code" + i].value + "`" + formObj.elements["to_item_qty" + i].value + "`" + formObj.elements["fm_stk_uom_conv_factor" + i].value + "`" + formObj.elements["fm_item_desc" + i].value+"`"+formObj.elements["allow_deci_yn_from"+i].value+"`"+formObj.elements["no_deci_from"+i].value+"`"+formObj.elements["allow_deci_yn_to"+i].value+"`"+formObj.elements["no_deci_to"+i].value;
			index += i + "!";
			noOfCheckedRecords++;
		}
	}
if(noOfCheckedRecords>0)
	{
	//console.log(parent.frameProductTransferRequestSearchQueryResult.document.getElementById('prt_delete_yn').value);
	var retVal=parent.frameProductTransferRequestSearchQueryResult.document.getElementById('prt_delete_yn').value;
	//console.log(window.parent.parent.returnValue);
	//window.parent.parent.returnValue = returnvals+"`"+formObj.prt_delete_yn.value;
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue =returnvals+"`"+retVal;
	}
	//window.close();
	  const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	    dialogTag.close(); 
    
	//parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML="UOM&nbsp;"+"<b>"+fromuomdesc+"</b>";
	//parent.frameProductTransferHeader.document.formProductTransferHeader.document.getElementById("request_no_hdr").innerHTML=" Request No;"+"<b>"+
}
var maxAllowed = 0;
var totalChecked = 0;
function checkAllowed(obj) {
	maxAllowed = parent.frameProductTransferRequestSearchQueryResult.document.ProductTransferRequestSearchCriteria.maxAllowed.value;
	if (obj.checked) {
		totalChecked++;
		if (totalChecked > maxAllowed) {
			alert(getMessage("ST_CANT_ENTER_MORE", "ST") + maxAllowed);
			totalChecked--;
			return false;
		} else {
			return true;
		}
	} else {
		totalChecked--;
		return true;
	}
}
function validateLength(objText) {
//	if (CustomTimeFlag == false)
//	{
	var Time = objText.value;
	if (objText.value.charAt(0) == ":") {
		Time = "00" + Time;
		objText.value = Time;
	}
	if (objText.value.charAt(1) == ":") {
		Time = "0" + Time;
	}
	objText.value = Time;
	if (Time.length < 5 && Time.length > 3) {
		Time = Time + "0";
	}
	if (Time.length == 6) {
		if (Time.charAt(2) != ":") {
			Time = "0" + Time;
		}
		Time = Time.substr(0, 5);
	} else {
		if (Time.length == 7) {
			if (Time.charAt(2) != ":") {
				Time = "0" + Time;
			}
			Time = Time.substr(0, 5);
		}
	}
}
function formatTimePerSlab(frmin) {
	if (frmin.value.length == 2) {
		if (frmin.value.substring(1, 2) == ":") {
			frmin.value = "0" + frmin.value;
		}
	}
	if (frmin.value.length == 3) {
		if (frmin.value.substring(0, 1) == ":") {
			frmin.value = "00" + frmin.value;
		}
	}
}
var sendingError = false;
var errorObj = null;
function chkCustomTime(time) {
	if (sendingError == true) {
		if (time != errorObj) {
			return false;
		}
	}
	if (time.value == "") {
		return false;
	}
	if (!chkTime(time.value)) {
		sendingError = true;
		errorObj = time;
		time.focus();
		time.select();
		alert(getMessage("INVALID_TIME_FMT", "ST"));
		
 // 		CustomTimeFlag = true;
		return false;
   // For checking with the next function validateLength()
	} else {
		sendingError = false;
		errorObj = null;
	}
	return true;
}
function allowValidNumber(e) {
	if (e.keyCode > 47 && e.keyCode < 59) {
		return true;
	} else {
		return false;
	}
}
function chkTime(time1) {
	var retval = true;
	var strCheck = ":0123456789";
	for (var i = 0; i <= time1.length; i++) {
		if (strCheck.indexOf(time1.charAt(i)) == -1) {
			retval = false;
			break;
		}
	}
	if (retval) {
		if ((time1.charAt(time1.length - 1)) != ":") {
			var time1arr = new Array();
			time1arr = time1.split(":");
			if (time1arr.length == 2) {
				var time1hr = time1arr[0];
				var time1min = time1arr[1];
				time1hr = eval(time1hr);
				time1min = eval(time1min);
				if (time1hr <= 23) {
					if (time1min > 59) {
						retval = false;
					}
				} else {
					retval = false;
				}
			} else {
				retval = false;
			}
		} else {
			retval = false;
		}
	}
	return retval;
}
function checklabelyn() {
	var addno = "1";
	if (document.formProductTransferAddModify.label_reqd_yn.checked == false) {
		document.formProductTransferAddModify.no_of_labels.value = "";
	} else {
		document.formProductTransferAddModify.no_of_labels.disabled= false;
		var addactno = document.formProductTransferAddModify.p_actual_qty.value;		
		var addLabelno = Math.ceil(addactno);
		document.formProductTransferAddModify.no_of_labels.value = Math.ceil(addLabelno);
	}	
}

//30/05/12

function enabledisable() {
    var addno = "1";
	formObj= document.formProductTransferAddModify;
	if(formObj.label_reqd_yn_1.checked == true || formObj.label_reqd_yn_2.checked == true) {
		var addactno = document.formProductTransferAddModify.p_actual_qty.value;		
		var addLabelno = Math.ceil(addactno);
		document.formProductTransferAddModify.no_of_labels.value = Math.ceil(addLabelno);

	}
	else {
		document.formProductTransferAddModify.no_of_labels.value = "";
		}
}



function itemvalues(dtlvalue) {
	item_search_value = dtlvalue;
}
function computeLabel() {
	var labelvalue = 1;
	var labelvl = document.formProductTransferAddModify.p_actual_qty.value; 
	if(document.formProductTransferAddModify.barcode_applicable.value== "true"){ //30/05/12
	//alert(document.formProductTransferAddModify.label_reqd_yn_1.checked);
	//alert(document.formProductTransferAddModify.label_reqd_yn_2.checked); 
	if(document.formProductTransferAddModify.site_id.value	=="MOHBR"){
	if(document.formProductTransferAddModify.label_reqd_yn_1.checked == true || document.formProductTransferAddModify.label_reqd_yn_2.checked == true) {
	document.formProductTransferAddModify.no_of_labels.value = Math.ceil(labelvl);
	}
	}else{
	      if (document.formProductTransferAddModify.label_reqd_yn.checked == true) {
		document.formProductTransferAddModify.no_of_labels.value = Math.ceil(labelvl);
	}
	}
	}else{
	if (document.formProductTransferAddModify.label_reqd_yn.checked == true) {
		document.formProductTransferAddModify.no_of_labels.value = Math.ceil(labelvl);
	}
	}
	if(document.formProductTransferAddModify.sale_price_appl_yn.value=="Y")
	calculatetosaleprice();	
}

function calculatetosaleprice(){
	var to_quantity = document.formProductTransferAddModify.p_actual_qty.value;
	if (to_quantity != "") {
	document.formProductTransferAddModify.sale_price.value =  (document.formProductTransferAddModify.fr_sale_price.value/to_quantity).toFixed(2);
	}
}


function enableAllReqToFields() {
	document.formProductTransferAddModify.item_search_to.disabled = true;
	document.formProductTransferAddModify.p_to_factor.disabled = false;
	//document.formProductTransferAddModify.document.getElementById("Calendar").disabled = false;
	document.getElementById("Calendar").disabled = false;
	document.formProductTransferAddModify.p_fm_factor.focus();
}
//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
function enableAllReqToFields1() {
	document.formProductTransferAddModify.item_search_to.disabled = true;
	document.formProductTransferAddModify.p_to_factor.disabled = false;
	document.getElementById("Calendar").disabled = false;
	//document.formProductTransferAddModify.document.getElementById("Calendar").disabled = false;
	//document.formProductTransferAddModify.p_fm_factor.focus();
}
//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
function PrintWorkSheet(req_no) {
	var objform = parent.frameProductTransferRequestSearchQueryResult.document.ProductTransferRequestSearchCriteria_Form;
	document.ProductTransferRequestSearchCriteria_Form.p_request_no.value = req_no;
	objform.submit();
}
function bin_location_populate() {
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.disabled = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_bin_location.focus();
}
function phy_inv_progress1() {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + parent.frameProductTransferAddModify.document.formProductTransferAddModify.phy_inv_id.value);
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.readOnly = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_fm_item_desc.focus();
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = "";
}
function phy_inv_progress2() {
	alert(getMessage("PHY_INV_PROCESS_INITIATED", "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + parent.frameProductTransferAddModify.document.formProductTransferAddModify.phy_inv_id.value);
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.value = "";
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.readOnly = false;
	parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_item_desc.focus();
	parent.frameProductTransferAddModify.document.getElementById("to_item_uom_desc").innerHTML = "";
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.formProductTransferAddModify.lang_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.formProductTransferAddModify.rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.formProductTransferAddModify.SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}		
	if ((retVal != null) && (retVal != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}

async function deleterecord() {
	//ML-MMOH-SCF-1861 START
	var mode = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.mode.value;
	var doc_no = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.doc_no.value;
	var doc_type_code = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.doc_type_code.value;   
	var prod_transfer_mode = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.prod_transfer_mode.value;//ML-MMOH-SCF-1861 END
	
 	if(  f_query_add_mod.frameProductTransferAddModify==undefined){//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	/*if(f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.mode.value == 2){//ML-MMOH-SCF-1861 START
	//	alert(f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.mode.value);
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}*/
//	else{
		
	if(f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.request_no.value!="" || prod_transfer_mode == "2"){ //ML-MMOH-SCF-1861 END
		var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	var errorPage = "../../eCommon/jsp/error.jsp";
	//added for delete method working
	if(f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify.prt_delete_yn.value=="N"){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");;
	formObj.mode.value = MODE_INSERT;
		return false;
	}
	if (await confirmDelete() != YES) {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	
	}else{

			formObj.mode.value = MODE_DELETE;
			addToList("add");
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	messageFrame.location.href = errorPage + "?err_num=" + message;
	if (result) {
		f_query_add_mod.frameProductTransferHeader.location.href = "../../eST/jsp/ProductTransferHeader.jsp?function_id=ST_PRODUCT_TRANSFER";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + message + "<BR>" 
	f_query_add_mod.frameProductTransferAddModify.location.href = "../../eCommon/html/blank.html";
		}
	} 
	}else{
		
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("SELECT_PROD_TFR_REQUEST_NO", "ST");
	}
	//}//ML-MMOH-SCF-1861
	
	}

		
function setDecimalParameters(allow_yn,no_decimals,label) {
		
var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;	
if(formObj==null)
formObj = document.formProductTransferAddModify;	
if(allow_yn=='N')
			no_decimals ='0';
if(label=='from')
	{
		
		formObj.allow_deci_yn_from.value = allow_yn;
        formObj.no_deci_from.value = no_decimals;
	}
     
	  if(label=='to')
	{
		formObj.allow_deci_yn_to.value = allow_yn;
        formObj.no_deci_to.value = no_decimals;
	}
}

function allow_restrict_decimals1(obj,event)
{
	
var allow_yn =	document.formProductTransferAddModify.allow_deci_yn_from.value ;
var  no_decimals = document.formProductTransferAddModify.no_deci_from.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
}
function allow_restrict_decimals(obj,event)
{
	
var allow_yn =	document.formProductTransferAddModify.allow_deci_yn_to.value ;
var  no_decimals = document.formProductTransferAddModify.no_deci_to.value ;
if(allow_yn=='N')
obj.onkeypress=function(){return isValidInteger()};

if(allow_yn=='Y')
	   obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
}

//Added by Rabbani #Inc no:29973 on 11/05/12
//Starts

function callBarCodeBatchSearchproduct(e,trntype,fromStore,toStore,formObj,bean_id,bean_name){
		//if(e.keyCode==13 || e.keyCode== 9  || e.keyCode== 0)
		{
	var request_flag_yn = parent.frameProductTransferHeader.document.formProductTransferHeader.request_flag.value;
	
	if(request_flag_yn =="N" ){
    var bar_code = parent.frameProductTransferAddModify.formProductTransferAddModify.p_fm_item_desc.value;
	var trn_type	= trntype.value;
	var fromStore   = fromStore.value;
	var toStore		= toStore.value;
	var formObj		= formObj.name; 
	var barcode_appl = parent.frames[0].document.forms[0].barcode_applicable1.value;
	var resultArray	;	
	
	if (barcode_appl=="Y"){
	if (toStore==undefined)
		toStore="";
	var xmlHttp  = new XMLHttpRequest();
	var xmlDoc   = ""
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?trn_type=" + trn_type + "&bar_code=" + bar_code + "&formObj=" + formObj  +"&fromStore=" + fromStore + "&toStore=" + toStore + "&bean_id=" + bean_id + "&bean_name=" + bean_name + "&BARCODE_YN=TRUE" + "&validate=BARCODE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if(!result){
	    parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";	//err_num=" + message;
		if (message == "PHY_INV_PROCESS_INITIATED") {
			alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
				return;
		} else {
			if(getMessage(message, "ST") != ""){
				alert(getMessage(message, "ST"));
				refreshDetails();
			}
			else{
				refreshDetails();
			}
		}
	 }
	}
	else{
		callItemSearchScreenFrom();
	}
	}
 }

}
	
function BarcodeApply(uom_desc,binlocation,batchid,expirydate,tradeid,availqty,bin_short_desc,nod,expiry_yn,trade_name){

 var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
 var fromitemcode = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
 var to_quantity = document.formProductTransferAddModify.p_actual_qty.value;
 parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.getElementById("fm_item_uom_desc").innerHTML = getLabel("Common.uom.label", "Common") + "&nbsp;" + "<b>" + uom_desc + "</b>";

              if(formObj.sale_price_appl_yn.value == "Y") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fromitemcode + "&fm_trade_id=" + tradeid + "&fm_batch_id=" + batchid + "&validate=SALE_PRICE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				}
	        var temp_exp_date_label;
			var temp_exp_date_label_to;
			if (expiry_yn == "Y") {
				temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.expiryDate.label", "Common");
				var ex_param_days = parent.frameProductTransferAddModify.formProductTransferAddModify.ex_param_days.value;
				if (parseInt(nod) <= parseInt(ex_param_days)) {
					if (parseInt(nod) > 0) {
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + nod + getLabel("Common.days.label", "Common") + "</font>";
					} else {
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + "</font>";
					}
				}
			} else {
				temp_exp_date_label = getLabel("Common.receiptdate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.receiptdate.label", "Common");
			}
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerHTML = getLabel("Common.BatchID.label", "Common");
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;&nbsp;<input disabled value='" + batchid + "' size='10'>";
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;<input disabled value='" + expirydate + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + tradeid + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + availqty + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			//alert(formObj.sale_price_appl_yn.value);
		 	if(formObj.sale_price_appl_yn.value == "Y") {
			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("eST.SalePrice.label", "ST");
			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_et").innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
			document.formProductTransferAddModify.document.getElementById("fr_sale_price").value =  sales.toFixed(2);
			}
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") + "<b>" + bin_short_desc + "</b>";
			document.formProductTransferAddModify.document.getElementById("to_trade_dtl").innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;<b>" + tradeid + "</b>";
			document.formProductTransferAddModify.document.getElementById("to_expiry_date_id").innerHTML = temp_exp_date_label_to;

 			document.formProductTransferAddModify.fm_bin_location_code.value = binlocation;
			document.formProductTransferAddModify.fm_expiry_date.value = expirydate;
			document.formProductTransferAddModify.fm_batch_id.value = batchid;
 			document.formProductTransferAddModify.p_fm_quantity.value = availqty;
			document.formProductTransferAddModify.fm_trade_id.value = tradeid;
			document.formProductTransferAddModify.to_trade_id.value = tradeid;
			document.formProductTransferAddModify.fm_bin_location_code.value = binlocation; 
			
			if(formObj.sale_price_appl_yn.value == "Y") {
			if(sales == 0){
			document.formProductTransferAddModify.sale_price.value= 0;
			}else{
			if(to_quantity!="")
			document.formProductTransferAddModify.sale_price.value = (sales/to_quantity).toFixed(2);
			else
			document.formProductTransferAddModify.sale_price.value = 0;
			}
			}
			enableAllToFields();
			if (expiry_yn == "N") {
				document.formProductTransferAddModify.p_to_expiry_date.readonly = true;
				document.formProductTransferAddModify.document.getElementById("Calendar").disabled = true;
			}
	}
//ends
function CallNewBarcodeStringforproduct(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty,sale_price){
          var formObj = f_query_add_mod.frameProductTransferAddModify.document.formProductTransferAddModify;
	     var trn_type = formObj.trn_type.value;
	     if(formObj.BarcodeRule.value=="P"){
		if(batch_id.value!= "" || Expiry_date.value!= ""){
			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			//var mrp = formObj.mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id+"&trn_type="+trn_type + "&mrp=" + sale_price.value+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			//barcode_id.value=message;
			barcode_id.value= message.substring(0,60);
		}
		} else if(formObj.BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
		//if(barcode_id.value=="" && item_qty.value!="" && batch_id.value!= ""){
			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			//var mrp = formObj.mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id +"&trn_type="+trn_type + "&mrp=" + sale_price.value+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			//alert(message);
			barcode_id.value=message;
			
		}
	}
	//alert(barcode_id.value);
}



function NewBarcodeid(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty,sale_price){
	if(parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled == false){
	    var trn_type = document.forms[0].trn_type.value;
	    if(document.forms[0].BarcodeRule.value=="P"){
		if(batch_id.value!= "" || Expiry_date.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			//var mrp = document.forms[0].mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code.value + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code.value + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id +"&trn_type="+trn_type + "&mrp=" + sale_price.value+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value= message.substring(0,60);
		}
		} else if(document.forms[0].BarcodeRule.value=="S"){
		//if(barcode_id.value=="" && item_qty.value!="" && batch_id.value!= ""){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			//var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id.value+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id +"&trn_type="+trn_type+  "&mrp=" + sale_price.value+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
		}
	}
 	}
}

function setreport(){
 var report_id = "";
             
			 if(document.getElementById("label_reqd_yn_2").checked == true){
            report_id = "STBREPLB";
            }
			if(document.formProductTransferAddModify.site_id.value	=="MOHBR"){
            if(document.getElementById("label_reqd_yn_1").checked == true){
            report_id = "STBREPLB1";
            }
			}
            var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?validate=SET_REPORT&report_id="+report_id, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
           }
//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016 starts
function Modify(obj,doc_type_code,store_code,doc_ref,local) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	document.getElementById("readOnlyDiv").style.visibility='visible';
	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	
	var doc_no		= obj.cells[1].innerText;
	var doc_date	= obj.cells[2].innerText;
    doc_date        = convertDate(doc_date,'DMY',local,"en");
	if(doc_ref == "undefined") {
		doc_ref = "";
	}
	parent.document.location.href="../../eST/jsp/ProductTransferFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&doc_date="+doc_date+"&store_code="+store_code+"&doc_ref="+doc_ref; 

}
//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
function enableAllToFields1() {
	document.formProductTransferAddModify.p_to_item_desc.disabled = true;
	document.formProductTransferAddModify.item_search_to.disabled = true;
	document.formProductTransferAddModify.p_to_expiry_date.disabled = false;
	document.formProductTransferAddModify.p_to_bin_location.disabled = false;
	document.formProductTransferAddModify.p_to_factor.disabled = false;
	document.formProductTransferAddModify.remarks.disabled = false;
	document.formProductTransferAddModify.p_to_batch_id.disabled = true;
	document.formProductTransferAddModify.document.getElementById("Calendar").disabled = false;
	//document.formProductTransferAddModify.p_fm_factor.focus();
}
//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
function checkForMandatory(){

	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var from_doc_date=document.formProductTransferQueryCriteria.from_doc_date ;
	var to_doc_date=document.formProductTransferQueryCriteria.to_doc_date ;
	var sysdate=document.formProductTransferQueryCriteria.sysdate ;
/*	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formProductTransferQueryCriteria.from_doc_date,document.formProductTransferQueryCriteria.to_doc_date);
	var names = new Array(getLabel("eST.FromDocDate.label", "ST"),getLabel("eST.ToDocDate.label", "ST"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame, errorPage);
		if (blankObject != true) {
			return;
		}*/
	var flag1=false;
		
	var flag2=false;
	var flag3=false;
	flag1=checkSysdate(sysdate,from_doc_date);
	flag2=checkSysdateTo(to_doc_date,from_doc_date);
	flag3=checkSysdateTo1(sysdate,to_doc_date);
	if(flag1!=false)
	if(flag2!=false)
	if(flag3!=false)
	document.formProductTransferQueryCriteria.submit();
	}

	function checkSysdate(receiptdate, sysdate) {
		var errorPage = "../../eCommon/jsp/error.jsp";
		var arrayObject = new Array(document.formProductTransferQueryCriteria.from_doc_date);
		if(receiptdate.value!=""){
			var flag = ChkDate(receiptdate);
			if (!flag) {

			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
				return false;
			}
if(sysdate.value!=""){
			if (flag) {
				if (checkdateWithSysDate(receiptdate, sysdate)) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FRM_DOC_DATE_NOT_LESS_SYSDATE","ST");
				return false;
				}
				}
				}
		}
	}
	function checkdateWithSysDate(entered_date, sys_date) {
		/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
		var enteredDateArray;
		var sysDateArray;
		var enteredDate = entered_date.value;
		var sysDate = sys_date.value;
		if (enteredDate.length > 0 && sysDate.length > 0) {
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
			var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
			if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
					
				return false;
			} else {
				if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
					return true;
				}
			}
		}
		return true;
	}

	function checkSysdateTo(receiptdate, sysdate) {
		var errorPage = "../../eCommon/jsp/error.jsp";
		var arrayObject = new Array(document.formProductTransferQueryCriteria.from_doc_date);
		if(receiptdate.value!=""){
			var flag = ChkDate(receiptdate);
			if (!flag) {

			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
				return false;
			}

			if(sysdate.value!=""){
				if (flag) {
			
				if (checkdateWithSysDateTo(receiptdate, sysdate)) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE","ST");
				return false;
				}
				}
				}
		}
	}
	function checkdateWithSysDateTo(entered_date, sys_date) {
		/* Entered Date Should not be less than sysdate Krishna 1/13/2009 */
		var enteredDateArray;
		var sysDateArray;
		var enteredDate = entered_date.value;
		var sysDate = sys_date.value;
		if (enteredDate.length > 0 && sysDate.length > 0) {
			enteredDateArray = enteredDate.split("/");
			sysDateArray = sysDate.split("/");
			var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
			var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
			if (Date.parse(sysDateObject) <= Date.parse(enteredDateObject)) {
					
				return false;
			} else {
				if (Date.parse(sysDateObject) > Date.parse(enteredDateObject)) {
					return true;
				}
			}
		}
		return true;
	}
	function checkSysdateTo1(receiptdate, sysdate) {
		var errorPage = "../../eCommon/jsp/error.jsp";
		var arrayObject = new Array(document.formProductTransferQueryCriteria.from_doc_date);
		if(sysdate.value!=""){
			var flag = ChkDate(sysdate);
			if (flag) {
				if (checkdateWithSysDateTo(receiptdate, sysdate)) {
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_SYSDATE","ST");
				return false;
							
				}
				}
		}
	}
	function clearMessageFrame(){
		var errorPage = "../../eCommon/jsp/error.jsp";
		parent.parent.messageFrame.location.href = errorPage + "?err_num=";
		}
	function callBatchSearchFrom1() {
	var site = parent.frameProductTransferAddModify.formProductTransferAddModify.site.value;
	var to_quantity = document.formProductTransferAddModify.p_actual_qty.value;
	var request_yn = parent.frameProductTransferHeader.formProductTransferHeader.request_yn.value; 
	var from_item_code = parent.frameProductTransferAddModify.formProductTransferAddModify.from_item_code.value;
	var from_item_desc = parent.frameProductTransferAddModify.formProductTransferAddModify.from_item_desc.value;
	var from_batch_id =  parent.frameProductTransferAddModify.formProductTransferAddModify.from_batch_id.value;
	var from_exp_date =  parent.frameProductTransferAddModify.formProductTransferAddModify.from_exp_date.value;
	var store_desc =  parent.frameProductTransferAddModify.formProductTransferAddModify.store_desc.value;
	var FM_BIN_LOCN_CODE =  parent.frameProductTransferAddModify.formProductTransferAddModify.FM_BIN_LOCN_CODE.value;
	var FM_BIN_LOCN =  parent.frameProductTransferAddModify.formProductTransferAddModify.FM_BIN_LOCN.value;
	var FM_TRADE =  parent.frameProductTransferAddModify.formProductTransferAddModify.FM_TRADE.value;
	var FM_TRADE_ID =  parent.frameProductTransferAddModify.formProductTransferAddModify.FM_TRADE_ID.value;
	var MANUFACTURER_ID =  parent.frameProductTransferAddModify.formProductTransferAddModify.MANUFACTURER_ID.value;
	var MANU_DESC =  parent.frameProductTransferAddModify.formProductTransferAddModify.MANU_DESC.value;
	var expiry_yn =  parent.frameProductTransferAddModify.formProductTransferAddModify.expiry_yn.value;
	var QTY_ON_HAND =  parent.frameProductTransferAddModify.formProductTransferAddModify.QTY_ON_HAND.value;
	var AVAIL_QTY =  parent.frameProductTransferAddModify.formProductTransferAddModify.AVAIL_QTY.value;
	var NOD =  parent.frameProductTransferAddModify.formProductTransferAddModify.NOD.value;
	
	var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
	fromitemcode = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
	var	mode = parent.frameProductTransferAddModify.formProductTransferAddModify.mode.value;
	if (request_yn == "N") {
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		var item_code = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
		
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var batch_retval = "";
		/*if(site && mode!=1){
		batch_retval = callBatchSearchWindow(from_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		}
		else{
			batch_retval = callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		}*/
		batch_retval=batch_retval.concat(from_batch_id)+"`";
		batch_retval=batch_retval.concat(from_item_code)+"`";
		batch_retval=batch_retval.concat(from_item_desc)+"`";
		batch_retval=batch_retval.concat(store_code)+"`";
		batch_retval=batch_retval.concat(store_desc)+"`";
		batch_retval=batch_retval.concat("Y")+"`";
		batch_retval=batch_retval.concat(from_exp_date)+"`";
		batch_retval=batch_retval.concat(FM_BIN_LOCN_CODE)+"`";
		batch_retval=batch_retval.concat(FM_BIN_LOCN)+"`";
		batch_retval=batch_retval.concat(FM_TRADE_ID)+"`";
		batch_retval=batch_retval.concat(FM_TRADE)+"`";
		batch_retval=batch_retval.concat(QTY_ON_HAND)+"`";
		batch_retval=batch_retval.concat(NOD)+"`";
		batch_retval=batch_retval.concat(MANUFACTURER_ID)+"`";
		batch_retval=batch_retval.concat(MANU_DESC)+"`";
		batch_retval=batch_retval.concat(AVAIL_QTY)+"`";
		batch_retval=batch_retval.concat(expiry_yn)+"`";
		//alert(batch_retval);
		if (batch_retval == null) {
			return;
		}
		var arr_vals = new Array();
		if (batch_retval.length > 0) {
			arr_vals = batch_retval.split("`");
			for (var i = 0; i < 16; i++) {
				fm_batch_id = arr_vals[0];
				fm_item_code = arr_vals[1];
				fm_item_desc = arr_vals[2];
				fm_store_code = arr_vals[3];
				fm_store_desc = arr_vals[4];
			//fm_trade_id_applicable_yn=arr_vals[5];
				fm_expiry_date = arr_vals[6];
				fm_bin_location_code = arr_vals[7];
				fm_bin_desc = arr_vals[8];
				fm_trade_id = arr_vals[9];
				fm_trade_name = arr_vals[10];
				fm_qty_on_hand = arr_vals[11];
				fm_nod = arr_vals[12];
				fm_manufacturer_id = arr_vals[13];
				fm_manufacturer_name = arr_vals[14];
				fm_avail_qty = arr_vals[15];
				fm_expiry_yn = arr_vals[16];

				if(formObj.sale_price_appl_yn.value == "Y") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fm_item_code + "&fm_trade_id=" + fm_trade_id + "&fm_batch_id=" + fm_batch_id + "&validate=SALE_PRICE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				}

			}
		}
		if (batch_retval != "") {
			var temp_exp_date_label;
			var temp_exp_date_label_to;
			if (fm_expiry_yn == "Y") {
				temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.expiryDate.label", "Common");
				var ex_param_days = parent.frameProductTransferAddModify.formProductTransferAddModify.ex_param_days.value;
				if (parseInt(fm_nod) <= parseInt(ex_param_days)) {
					if (parseInt(fm_nod) > 0) {
				//<br><font class="DATAHIGHLIGHT"><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></font>
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + fm_nod + getLabel("Common.days.label", "Common") + "</font>";
					} else {
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + "</font>";
					}
				}
			} else {
				temp_exp_date_label = getLabel("Common.receiptdate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.receiptdate.label", "Common");
			}
			document.getElementById('fm_display_dtl_1_bl').innerHTML = getLabel("Common.BatchID.label", "Common");
			document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_batch_id + "' size='10'>";
			document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_expiry_date + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + parseFloat(fm_avail_qty).toFixed(parseInt(document.formProductTransferAddModify.no_deci_from.value)) + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			if(formObj.sale_price_appl_yn.value == "Y") {
			document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("eST.SalePrice.label", "ST");
			document.getElementById("fm_display_slp_1_et").innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
			document.getElementById("fr_sale_price").value =  sales.toFixed(2);
			}
			/*+"&nbsp;&nbsp;&nbsp; Conv Factor."+"<b>"+document.formProductTransferAddModify.eqvlvalue.value;*/
			document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") + "<b>" + fm_bin_desc + "</b>";
			//alert("label check"+document.formProductTransferAddModify.document.getElementById("to_trade_dtl1").innerHTML);
			//document.formProductTransferAddModify.document.getElementById("to_trade_dtl").innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;<b>" + fm_trade_name + "</b>";
			document.getElementById("to_expiry_date_id").innerHTML = temp_exp_date_label_to;

//      document.formProductTransferAddModify.p_to_expiry_date.value=document.formProductTransferAddModify.sys_date.value;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			document.formProductTransferAddModify.fm_expiry_date.value = fm_expiry_date;
			document.formProductTransferAddModify.fm_batch_id.value = fm_batch_id;
			//if(document.formProductTransferAddModifyallow_deci_yn_from=='Y')
		//	document.formProductTransferAddModify.p_fm_quantity.value = parseFloat(fm_avail_qty).toFixed(parseInt(document.formProductTransferAddModify.no_of_decimals.value));
		//	if(document.formProductTransferAddModifyallow_deci_yn_from=='N')
		//	{
          //  alert(setNumber(fm_avail_qty,0));
					//	document.formProductTransferAddModify.p_fm_quantity.value = setNumber(fm_avail_qty,0);

			//}
			document.formProductTransferAddModify.fm_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.to_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			if(formObj.sale_price_appl_yn.value == "Y") {
			if(sales == 0){
			document.formProductTransferAddModify.sale_price.value= 0;
			}else{
			if(to_quantity!="")
			document.formProductTransferAddModify.sale_price.value = (sales/to_quantity).toFixed(2);
			else
			document.formProductTransferAddModify.sale_price.value = 0;
			}
			}
			if(site && mode==2){
				enableAllToFields1();
			}
			else{
			enableAllToFields();}
			if (fm_expiry_yn == "N") {
				document.formProductTransferAddModify.p_to_expiry_date.readonly = true;
				document.formProductTransferAddModify.document.getElementById("Calendar").disabled = true;
			}
		}
	} else {
		var store_code = parent.frameProductTransferHeader.formProductTransferHeader.store_code.value;
		 var formObj = parent.frameProductTransferAddModify.document.formProductTransferAddModify;
		fromitemcode = parent.frameProductTransferAddModify.formProductTransferAddModify.fm_item_code.value;
		var item_code = fromitemcode;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "N";
		var batch_retval = "";
		batch_retval=batch_retval.concat(from_batch_id)+"`";
		batch_retval=batch_retval.concat(from_item_code)+"`";
		batch_retval=batch_retval.concat(from_item_desc)+"`";
		batch_retval=batch_retval.concat(store_code)+"`";
		batch_retval=batch_retval.concat(store_desc)+"`";
		batch_retval=batch_retval.concat("Y")+"`";
		batch_retval=batch_retval.concat(from_exp_date)+"`";
		batch_retval=batch_retval.concat(FM_BIN_LOCN_CODE)+"`";
		batch_retval=batch_retval.concat(FM_BIN_LOCN)+"`";
		batch_retval=batch_retval.concat(FM_TRADE_ID)+"`";
		batch_retval=batch_retval.concat(FM_TRADE)+"`";
		batch_retval=batch_retval.concat(QTY_ON_HAND)+"`";
		batch_retval=batch_retval.concat(NOD)+"`";
		batch_retval=batch_retval.concat(MANUFACTURER_ID)+"`";
		batch_retval=batch_retval.concat(MANU_DESC)+"`";
		batch_retval=batch_retval.concat(AVAIL_QTY)+"`";
		batch_retval=batch_retval.concat(expiry_yn)+"`";
		//batch_retval = callBatchSearchWindow(item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect);
		if (batch_retval == null) {
			return;
		}
		var arr_vals = new Array();
		if (batch_retval.length > 0) {
			arr_vals = batch_retval.split("`");
			for (var i = 0; i < 17; i++) {
				fm_batch_id = arr_vals[0];
				fm_item_code = arr_vals[1];
				fm_item_desc = arr_vals[2];
				fm_store_code = arr_vals[3];
				fm_store_desc = arr_vals[4];
			//fm_trade_id_applicable_yn=arr_vals[5];
				fm_expiry_date = arr_vals[6];
				fm_bin_location_code = arr_vals[7];
				fm_bin_desc = arr_vals[8];
				fm_trade_id = arr_vals[9];
				fm_trade_name = arr_vals[10];
				fm_qty_on_hand = arr_vals[11];
				fm_nod = arr_vals[12];
				fm_manufacturer_id = arr_vals[13];
				fm_manufacturer_name = arr_vals[14];
				fm_avail_qty = arr_vals[15];
				fm_expiry_yn = arr_vals[16];

				if(formObj.sale_price_appl_yn.value == "Y") {
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				xmlDoc.loadXML(getEnhancedXMLString(formObj));
				xmlHttp.open("POST", "../../eST/jsp/ProductTransferValidate.jsp?episode_type=" + formObj.episode_type.value + "&fm_item_code=" + fromitemcode + "&fm_trade_id=" + fm_trade_id + "&fm_batch_id=" + fm_batch_id + "&validate=SALE_PRICE", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
				}
			}
		}
		if (batch_retval != "") {
			var temp_exp_date_label;
			var temp_exp_date_label_to;
			if (fm_expiry_yn == "Y") {
				temp_exp_date_label = getLabel("Common.expiryDate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.expiryDate.label", "Common");
				var ex_param_days = parent.frameProductTransferAddModify.formProductTransferAddModify.ex_param_days.value;
				if (parseInt(fm_nod) <= parseInt(ex_param_days)) {
					if (parseInt(fm_nod) > 0) {
				//<br><font class="DATAHIGHLIGHT"><%="Exp. "+(String)hmBatchRecord.get("NOD")+"Days"%></font>
						temp_exp_date_label = temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("eST.Exp.label", "ST") + fm_nod + getLabel("Common.days.label", "Common") + "</font>";
					} else {
						temp_exp_date_label = temp_exp_date_label + temp_exp_date_label + "<br><font class=DATAHIGHLIGHT>" + getLabel("Common.Expired.label", "Common") + "</font>";
					}
				}
			} else {
				temp_exp_date_label = getLabel("Common.receiptdate.label", "Common");
				temp_exp_date_label_to = getLabel("Common.receiptdate.label", "Common");
			}

			//document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = fm_sale_price;
			
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bl").innerHTML = getLabel("Common.BatchID.label", "Common");
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_bt").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_batch_id + "' size='10'>";
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_el").innerHTML = temp_exp_date_label;
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_1_et").innerHTML = "&nbsp;&nbsp;<input disabled value='" + fm_expiry_date + "' size='10'>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.TradeName.label", "Common") + "<b>" + fm_trade_name + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("eST.AvailableQty.label", "ST") + "<b>" + fm_avail_qty + "</b>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;

			if(formObj.sale_price_appl_yn.value == "Y") {
			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("eST.SalePrice.label", "ST");
			document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_et").innerHTML = "<input disabled value='" + sales.toFixed(2) + "' size='10'>";
			document.formProductTransferAddModify.document.getElementById("fr_sale_price").value =  sales.toFixed(2);
			}
			/*+"&nbsp;&nbsp;&nbsp; Conv Factor."+"<b>"+document.formProductTransferAddModify.eqvlvalue.value;*/
			//document.formProductTransferAddModify.document.getElementById("fm_display_slp_1_el").innerHTML = getLabel("Common.SalePrice.label", "Common") + "<b>" + "" + "</b>";
			
			document.formProductTransferAddModify.document.getElementById("fm_display_dtl_2").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + getLabel("Common.BinLocation.label", "Common") + "<b>" + fm_bin_desc + "</b>";
			//document.formProductTransferAddModify.document.getElementById("to_trade_dtl").innerHTML = getLabel("Common.TradeName.label", "Common") + "&nbsp;<b>" + fm_trade_name + "</b>";
			document.formProductTransferAddModify.document.getElementById("to_expiry_date_id").innerHTML = temp_exp_date_label_to;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;
			document.formProductTransferAddModify.fm_expiry_date.value = fm_expiry_date;
			document.formProductTransferAddModify.fm_batch_id.value = fm_batch_id;
			document.formProductTransferAddModify.fm_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.to_trade_id.value = fm_trade_id;
			document.formProductTransferAddModify.fm_bin_location_code.value = fm_bin_location_code;

			if(formObj.sale_price_appl_yn.value == "Y") {
			if(sales == 0){
			document.formProductTransferAddModify.sale_price.value= 0;
			}else{
			if(to_quantity!="")
			document.formProductTransferAddModify.sale_price.value = (sales/to_quantity).toFixed(2);
			else
			document.formProductTransferAddModify.sale_price.value = 0;

			}
			}
			if(site && mode==2){
				enableAllReqToFields1();;
			}
			else{
				enableAllReqToFields();}
			
			
			if (fm_expiry_yn == "N") {
				document.formProductTransferAddModify.p_to_expiry_date.readonly = true;
				document.formProductTransferAddModify.document.getElementById("Calendar").disabled = true;
			}
		}
	}
}//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi  ends

