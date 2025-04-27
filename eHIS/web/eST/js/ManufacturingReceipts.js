
var flag1 = true;
var prevObj = null;
var prevColor = null; 
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturingReceiptsFrame.jsp?mode=" + MODE_INSERT;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturingReceiptsQueryCriteriaFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function onSuccess(mode) {
	if (mode.value == MODE_INSERT) {
		create(); 
	} else {
		query();
	}
}
function Success() {
	if (mode.value == MODE_INSERT) {
		create();
	} else {
		query();
	}
}
function reset() {
  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
  if(f_query_add_mod.frameHeader == undefined && f_query_add_mod.selectcriteriaframe.frameHeader != null){
   if(f_query_add_mod.selectcriteriaframe.frameHeader.Header.mode.value ==1){
   create();
   }
   }else{
	if(f_query_add_mod.frameHeader!=null){
	if(f_query_add_mod.frameHeader.Header.mode.value==1){
		create();
	}else{
		f_query_add_mod.frameHeader.document.Header.reset();
		f_query_add_mod.frameDetail.document.formDetail.reset();
	//	f_query_add_mod.frameList.frameListDetail.document.formListDetail.reset();
		//f_query_add_mod.formListDetail.document.formDetail.reset();
	}
	}
	}
	//create();
	//Added By rabbani #inc no :38408 on 07-MAR-2013
	if(f_query_add_mod.frameHeader == undefined)
	f_query_add_mod.location.reload();
}
async function apply() {
   //Commented by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013   
	/*if(f_query_add_mod.frameHeader==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}*/
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013   
	if(f_query_add_mod.frameHeader==undefined){ 
	if(f_query_add_mod.selectcriteriaframe.frameHeader == undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
		}
	} //ends
	var msg ;
	var fields = new Array();
	var fieldNames = new Array();
	var formObj;
	if(f_query_add_mod.frameHeader == undefined){ //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 
	 formObj = f_query_add_mod.selectcriteriaframe.frameHeader.Header;
	}else{
	 formObj = f_query_add_mod.frameHeader.Header; 
	}
	var locale = formObj.locale.value;
	var mfg_req_yn = formObj.mfg_req_yn.value;//Added by suresh.r on 12-12-2014 against BRU-HIMS-CRF-080
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013
	if(formObj.dflt_mfg_mode.value == "D" && formObj.mode.value == "1")
	 formObj.prep_type.value = formObj.req_type.value;
	if (formObj.prep_type.value != "E") {
		if (formObj.auto_gen_batch_yn.value == "N") {
			fields[0] = formObj.batch_id;
			fields[1] = formObj.expiry_date;
			fields[2] = formObj.bin_location;
			fields[3] = formObj.trade_id;
			fields[4] = formObj.composition_for_qty;
			fieldNames[0] = getLabel("Common.BatchID.label", "Common");
			fieldNames[1] = getLabel("Common.expiryDate.label", "Common");
			fieldNames[2] = getLabel("Common.BinLocation.label", "Common");
			fieldNames[3] = getLabel("Common.TradeID.label", "Common");
			fieldNames[4] = getLabel("eST.Compositionfor.label", "ST");
		} else {
			fields[0] = formObj.expiry_date;
			fields[1] = formObj.bin_location;
			fields[2] = formObj.trade_id;
			fields[3] = formObj.composition_for_qty;
			fieldNames[0] = getLabel("Common.expiryDate.label", "Common");
			fieldNames[1] = getLabel("Common.BinLocation.label", "Common");
			fieldNames[2] = getLabel("Common.TradeID.label", "Common");
			fieldNames[3] = getLabel("eST.Compositionfor.label", "ST");
		}
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	

	var blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
	 
	if (blankObject == true) {
		var canProcess = 0;
		var forInserting = "";
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		var fmObject;
		if(formObj.dflt_mfg_mode.value == "D" && formObj.mode.value == "1")
		 fmObject = f_query_add_mod.selectcriteriaframe.frameDetail.formDetail;
		else
		 fmObject = f_query_add_mod.frameDetail.formDetail;  
		//ends
		//var fmObject = f_query_add_mod.frameDetail.formDetail;
		if (fmObject == null) {
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_CHILD_ITEM_REQD", "ST");
			return;
		}
		var total_checkboxes = fmObject.total_checkboxes.value;
		fmObject.batch_id.value = formObj.batch_id.value;
		fmObject.expiry_date.value = convertDate(formObj.expiry_date.value, "DMY", locale, "en");
		fmObject.bin_location.value = formObj.bin_location.value;
		fmObject.process_loss.value = formObj.process_loss.value;
		fmObject.composition_for_qty.value = formObj.composition_for_qty.value;
		fmObject.baseqty.value = formObj.baseqty.value;
		fmObject.trade_id.value = formObj.trade_id.value;
		fmObject.remarks.value = formObj.remarks.value;
		fmObject.packed_by.value = formObj.packed_by.value;
		fmObject.counter.value = formObj.counter.value;
		fmObject.auto_gen_batch_yn.value = formObj.auto_gen_batch_yn.value;
			
		if(formObj.BarCodeApplicable.value == "true"){
		//setlabels();
		setlabels(formObj); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		}
		
		for (i = 0; i < total_checkboxes; i++) {
			if (eval("fmObject.checkbox" + i + ".checked")) {
				forInserting += ("Y,");
				eval("fmObject.checkbox" + i + ".value='Y'");
			} else {
				canProcess++;
				forInserting += ("N,");
				eval("fmObject.checkbox" + i + ".value='N'");
			}
		}
		forInserting = forInserting.substring(0, forInserting.length - 1);	
		fmObject.checkBoxVals.value = forInserting;
		
		if (parseInt(canProcess) == 0) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MIN_ONE_CHILD_ITEM_REQD", "ST");
			return;
		} else {
				
			if (fmObject.mode.value == MODE_INSERT) {
				//xmlDom = new ActiveXObject("Microsoft.XMLDom");
				//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				xmlHttp = new XMLHttpRequest();
				xmlDom="";
				xmlStr = getEnhancedXMLString(fmObject);
				//xmlDom.loadXML(xmlStr);
				xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=9", false);
				xmlHttp.send(xmlDom);
				responseText = xmlHttp.responseText;
			//alert("1"+responseText);
				eval(responseText);
				if (!result) {
					var Item_desc = new Array();
					Item_desc = responseText.split(";");
					if (Item_desc.length > 2) {
						var First = "";
						var First_desc = "";
						First = First.concat(getMessage("ITEM_STORE_NOT_FOUND", "ST"));
						First = First.concat("::");
						var Item_first = new Array();
						if (Item_desc[0] != null && Item_desc[0].length > 0) {
							Item_first = Item_desc[0].split(",");
						}
						var Item_second = new Array();
						if (Item_desc[1] != null && Item_desc[1].length > 0) {
							Item_second = Item_desc[1].split("!");
						}
						for (z = 1; z < Item_first.length - 1; z++) {
							First_desc = First_desc.concat(Item_first[z]);
							First_desc = First_desc.concat(", ");
						}
						First_desc = First_desc.substring(0, First_desc.length - 3);
						var second = "";
						second = second.concat(getMessage("INSUFFICIENT_BATCH_QTY", "ST"));
						second = second.concat("::");
						var sec_desc = Item_second[0];
						sec_desc = sec_desc.substring(25, sec_desc.length - 0);
						second = second.concat(sec_desc);
						if (First_desc.length > 1) {
							First_desc = First_desc.substring(1, First_desc.length);
							First = First.concat(" ");
							First = First.concat(First_desc);
						} else {
							First = "";
							First = First.concat(second.substring(1, second.length - 3));
							second = "";
						}
						if (second != undefined) {
							second = second.substring(2, second.length - 3);
						} else {
							second = "";
						}
					} else {
						var Item_first = new Array();
						if (Item_desc[0] != null && Item_desc[0].length > 0) {
							Item_first = Item_desc[0].split(",");
						}
						var First = "";
						if (Item_first.length > 2) {
							for (z = 1; z < Item_first.length - 1; z++) {
								First = "";
								First = First.concat(getMessage("ITEM_STORE_NOT_FOUND", "ST"));
								First = First.concat("::");
								First = First.substring(0, First.length - 1);
								var item_desc_st = "";
								item_desc_st = item_desc_st.concat(Item_first[z]);
								item_desc_st = item_desc_st.substring(1, item_desc_st.length - 0);
								First = First.concat(":");
								First = First.concat(item_desc_st);
	 // First=First.concat(",");
	//First =First.substring(1,First.length-0);
							}
							First = First.substring(4, First.length - 1);
						} else {
							First = "";
							First = First.concat(getMessage("INSUFFICIENT_BATCH_QTY", "ST"));
							First = First.concat("::");
							First = First.substring(0, First.length - 1);
							var item_desc_st = "";
							item_desc_st = item_desc_st.concat(Item_first[1]);
							item_desc_st = item_desc_st.substring(2, item_desc_st.length - 1);
							First = First.concat(":");
							First = First.concat(item_desc_st);
//First=Item_first[1];
							First = First.substring(0, First.length - 2);
						}
						var second = "";
					}
					messageFrame.location.href = errorPage + "?err_num=" + First + "<br>" + second;
				//messageFrame.location.href = errorPage+"?err_num="+Item_second[1] ;
					return;
				}
			}
			setRemarkscode(); //18/06/12		
			
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=27&store_code=" + formObj.store_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);
				
			var response = "";
			if(result){
				//added for SKR-CRF-0039 By Ganga on 5th Aug 2013
				var xmlHttp = new XMLHttpRequest();
				var xmlDoc="";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" function_type=\"2\" ";		
				xmlStr +=" /></root>" ; 
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?trn_type="+formObj.trn_type.value+"&store_code="+formObj.store_code.value, false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);				
				
				//response = confirmFinalize(); commented
				if(result){
					response = await confirmFinalize();	
				}else{
					response = YES;
				}
				//Added ends	
				
				
				if(response=="")
				{
				messageFrame.location.href = errorPage + "?err_num=" ;
				return false;
				}
			}
			
			if (response == YES) {
				fmObject.finalized_yn.value = "Y";
			} else {
				fmObject.finalized_yn.value = "N";
			}

			var responseText = formApply(fmObject, ST_CONTROLLER);
			eval(responseText);
			origFlag = flag;
			if ((flag.split("!")).length > 1) {
				flagtemp = flag.split("!");
				batchId = "Batch Id :" + (flag.split("!"))[1];
				flag = (flag.split("!"))[0];
			} else {
				flagtemp = flag;
				batchId = "";
			}
			flagtemp = flag.split("!");
			flag1 = (batchId.split("~"))[0]; // batchid
			flag2 = (batchId.split("~"))[1];// PY
			flag1 = (flag1 == "null" ? "" : flag1);
			flagPrint = flag;
			if (result) {
				flag2 = origFlag.substring(origFlag.indexOf("~") + 1);
				if (flag2 == "PY") {
					var PConfirm = await confirmPrinting();
					if (PConfirm == "Yes") {
						//xmlDom = new ActiveXObject("Microsoft.XMLDom");
						//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						xmlDom="";
						xmlHttp = new XMLHttpRequest();
						
						xmlStr = getEnhancedXMLString(fmObject);
						xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlDom.loadXML(xmlStr);
						//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" + formObj.labeltype.value, false);
						 //Added by Rabbani #Inc no : 38900 on 23-Mar-2013 
                        if(formObj.BarCodeApplicable.value == "true"){ //Added by Rabbani #Inc no : 40094 on 21-MAY-2013  
						//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" +formObj.labeltype.value+"&no_of_labels="+formObj.no_of_labels.value+"&item_code="+formObj.item_code.value, false);
						xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" +formObj.labeltype.value+"&no_of_labels="+formObj.no_of_labels.value+"&item_code="+formObj.item_code.value, true);
						}else{//Added by Rabbani #Inc no : 40094 on 21-MAY-2013
						//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" +formObj.labeltype.value+"&item_code="+formObj.item_code.value, false);
						xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" +formObj.labeltype.value+"&item_code="+formObj.item_code.value, true);
						}
						xmlHttp.send(xmlDom);
						//responseText = xmlHttp.responseText;
						//eval(responseText);
					}
				} else if (flag2 == "PN") {
						//xmlDom = new ActiveXObject("Microsoft.XMLDom");
						//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						xmlDom="";
						xmlHttp = new XMLHttpRequest();
						
						xmlStr = getEnhancedXMLString(fmObject);
						xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlDom.loadXML(xmlStr);
						//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" + formObj.labeltype.value, false);
						 //Added by Rabbani #Inc no : 38900 on 23-Mar-2013 
						//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" + formObj.labeltype.value+"&no_of_labels="+formObj.no_of_labels.value+"&item_code="+formObj.item_code.value, false);
						if(formObj.BarCodeApplicable.value == "true"){ //Added by Rabbani #Inc no : 40094 on 21-MAY-2013  
						xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" + formObj.labeltype.value+"&no_of_labels="+formObj.no_of_labels.value+"&item_code="+formObj.item_code.value, true);
						}else{
						xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=6" + "&msg=" + message + "&labeltype=" + formObj.labeltype.value+"&item_code="+formObj.item_code.value, true);
						}
						xmlHttp.send(xmlDom);
						//responseText = xmlHttp.responseText;
						//eval(responseText);
					}
			}
			flag = flagPrint;
			if (message == "APP-ST0037 Insufficient Stock" && (flag.split("~")).length > 1) {
				messageFrame.location.href = errorPage + "?err_num=" + message + " For Item: " + (flag.split("~"))[1];
				//obj2 = eval("frames[1].frames[1].document.getElementById("tr_")" + (flag.split("~"))[0]);
				obj2 = eval(frames[1].frames[1].document.getElementById('tr_') + (flag.split("~"))[0]);
				for (k = 0; k < 2; k++) {
					obj2.cells(k).className = "STLIGHTPINK";
				}
			} else {
			//alert(formObj.new_barcode.value);
			//msg = message;
			//flagPrint1=flag;
			// message = msg;
			// flag = flagPrint1;
 				if (response == YES && fmObject.mode.value == "2") {
					onSuccess(fmObject.mode);
					messageFrame.location.href = errorPage + "?err_num=" + message;
				} else {
					if (flag2 == "PY" && fmObject.mode.value == "2") {
						onSuccess(fmObject.mode);
						messageFrame.location.href = errorPage + "?err_num=" + message;// +flag+"<BR>"+ (result?flag1:"");
					} else {
				    	if(formObj.BarCodeApplicable.value == "true"){
					      if(formObj.BarcodeRule.value == "P" || formObj.BarcodeRule.value == "S"){
						onSuccess(fmObject.mode);
						//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
						if (formObj.auto_gen_batch_yn.value == "N") {
						messageFrame.location.href = errorPage + "?err_num=" + message + flag + "<BR>" + (batchId.split("~"))[0]+" Barcode Id : " + formObj.barcode_id.value; 
						}else{
						messageFrame.location.href = errorPage + "?err_num=" + message + flag + "<BR>" + (batchId.split("~"))[0]+" Barcode Id : " + formObj.new_barcode.value; 
						 }
						}else{
						onSuccess(fmObject.mode);
						messageFrame.location.href = errorPage + "?err_num=" + message + flag + "<BR>" + (batchId.split("~"))[0]+" Barcode Id : " + formObj.barcode_id.value; 
						}
					}else{
					onSuccess(fmObject.mode);
						messageFrame.location.href = errorPage + "?err_num=" + message + flag + "<BR>" + (batchId.split("~"))[0];
					}
					}
				}
			}
			//Added by suresh.r on 12-12-2014 for PH against Bru-HIMS-CRF-080[IN:029946] beg
			if(mfg_req_yn=="Y"){
				//window.returnValue="OK";
				//window.close();
				forInserting
				let dialogBody = parent.document.getElementById('dialog-body');
			    dialogBody.contentWindow.returnValue = "OK";
			    
			    const dialogTag = parent.document.getElementById('dialog_tag');    
			    dialogTag.close(); 
			}//ends
		}
	} else {
//		blankObject.focus();
	}
}
function callItemSearchScreen1(obj, form) {
	var search_string = "";
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	if (obj.name == "child_item_code_desc") {
		search_string = parent.addModframe.AddModify_Form.child_item_code_desc.value;
		mfg_item = "A";
	} else {
		search_string = parent.selectcriteriaframe.manufacturing_form.item_code_desc.value;
		mfg_item = "Y";
	}
	var frmObject = "";
	var return_val = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"MFG");
	
	if (return_val == null) {
		return;
	}
	/**
	 * @Name - Priya
	 * @Date - 03/06/2010
	 * @Inc# - 
	 * @Desc -  To round up unitcost based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	if (obj.name == "child_item_code_desc") {
		frmObject = parent.addModframe.AddModify_Form;
		frmObject.child_item_code_desc.value = return_val[1];
		frmObject.child_item_code.value = return_val[0];
		frmObject.uom_code.value = return_val[13];
		frmObject.all.unitcost.innerText = setNumber(return_val[14], 2);
		frmObject.all.stock_uom.innerText = return_val[15];
	} else {
		if (obj.name == "item_code_desc") {
			frmObject = parent.selectcriteriaframe.manufacturing_form;
			frmObject.item_code_desc.value = return_val[1];
			frmObject.item_code.value = return_val[0];
			form.all.stockuom.innerText = return_val[15];
			frmObject.item_code_desc.disabled = true;
			frmObject.unit_cost.value = setNumber(return_val[14], 2);
		}
	}
}
//function modifyData(batch_id, index, preparationmode_desc, preparation_desc, loc_desc, store_desc, request_qty, mode, doc_no,doc_type_code,store_code,barcode_id,no_of_labels) {

//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013  
function modifyData(batch_id, index, preparationmode_desc, preparation_desc, loc_desc, store_desc, request_qty, mode, doc_no,doc_type_code,store_code,barcode_id,no_of_labels,dflt_mfg_mode) {

	if(dflt_mfg_mode == undefined)
         dflt_mfg_mode = "R"
 
	/**
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	*/
   
	if(mode==2)
	{
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=11&doc_type_code=" + doc_type_code + "&store_code=" +store_code + "&doc_no=" + doc_no, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
//	var errorPage = "../../eCommon/jsp/error.jsp";
	//document.getElementById("readOnlyDiv").style.visibility='visible';
//	parent.parent.messageFrame.location.href = errorPage + "?err_num="+getMessage("ST_PROCESSING_WAIT", "ST");
	}
	parent.parent.frames[1].location.href = "../../eST/jsp/ManufacturingReceiptsSecondFrame.jsp?batch_id=" + batch_id + "&index=" + index + "&mode=" + mode + "&prep_type=" + preparation_desc + "&prep_mode=" + preparationmode_desc + "&loc_desc=" + loc_desc + "&store_desc=" + store_desc + "&doc_no=" + doc_no +"&barcode_id="+barcode_id+"&no_of_labels="+no_of_labels+"&dflt_mfg_mode="+dflt_mfg_mode;   
}
function cancelData(index) {
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?mode=" + parent.selectcriteriaframe.manufacturing_form.mode.value + "&index=-1";
}
function checkVal(obj, form) {
	if (obj.value != "") {
		callItemSearchScreen(obj, form);
	} else {
		return false;
	}
}
function Modify(index) {
	parent.f_query_add_mod.location.href = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&index=" + index;
}
async function callBatchSearch(mode) {
	formObj = document.formHeaderCriteria;
	formObj1 = parent.parent.frameHeader.document.Header;
	var store_code = formObj.store_code.value;
	if (parent.frameListDetail.document.formListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var arrayObject = new Array(formObj.item_code, formObj.adj_item_qty);
	var names = new Array(getLabel("Common.item.label", "Common"), getLabel("Common.Quantity.label", "Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.parent.messageFrame);
	if (blankObject == true) {
		var _item_code = formObj.item_code.value;
		var item_qty = formObj.adj_item_qty.value;
		var includeZeroStockBatches = "N";
		var includeExpiredBatches = "N";
		var includeSuspendedBatches = "N";
		var searchFunction = "Y";
		var multipleSelect = "Y";
		var expiry_yn = "Y";
		var retval = await callBatchSearchWindow(_item_code, store_code, includeZeroStockBatches, includeExpiredBatches, includeSuspendedBatches, searchFunction, multipleSelect, "", formObj1.doc_type_code.value, formObj1.doc_no.value, formObj1.trn_type.value);
	
		if (retval != null && retval!="" && retval!=undefined) {
			parent.frameListDetail.location.href = "../../eST/jsp/ManufacturingReceiptsAddModify.jsp?function=search&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + expiry_yn + "&index=" + formObj.index.value + "&item_qty=" + item_qty + "&function_id" + parent.parent.function_id + "&mode=" + mode;
		}
	}
}
function displayAssemblyDtl(prepare_qty) {
	frmObject = parent.selectcriteriaframe.manufacturing_form;
	
	var arrayObject = new Array();
	arrayObject[0] = frmObject.item_code;
	arrayObject[1] = frmObject.store_code;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom = "";
	xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=7", false);
	xmlHttp.send(xmlDom);
	
	responseText = xmlHttp.responseText;
	eval(responseText);
	parent.detailframe.location.href = "../../eST/jsp/ManufacturingReceiptsListResult.jsp?index=" + index + "&mode=" + parent.selectcriteriaframe.manufacturing_form.mode.value + "&prepare_qty=" + prepare_qty.value;
}
function enableButton() {
	if (parent.selectcriteriaframe.manufacturing_form.item_code == null) {
		alert(getMessage("ST_ITEM_CODE_BLANK", "ST"));
	} else {
		parent.selectcriteriaframe.manufacturing_form.select.disabled = false;
	}
}
function ComputeCost() {
	var quantity = document.AddModify_Form.component_qty.value;
	var cost = document.AddModify_Form.all.unitcost.innerText;
	var val = "";
	if (quantity != "" && cost != "") {
		val = parseInt(cost) * parseFloat(quantity);
		document.getElementById("cost_value").innerText = value;
		document.AddModify_Form.comp_qty.value = val;
	} else {
		document.getElementById("cost_value").innerText = "";
		document.AddModify_Form.comp_qty.value = val;
	}
}
function loadData() {
   var formObj = "";
    //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
    if (parent.selectcriteriaframe == undefined) {
        formObj = document.manufacturing_form;
    } else {
        formObj = parent.selectcriteriaframe.manufacturing_form;
    }

    var temp_jsp = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=7";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = getEnhancedXMLString(formObj);
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);

    var responseText = xmlHttp.responseText;
    parent.detailframe.location.href = "../../eST/jsp/ManufacturingReceiptHeaderResult.jsp?mode=" + MODE_INSERT;
}
function getBaseQty() {
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlHttp = new XMLHttpRequest(); 
	xmlStr = "<root><SEARCH /></root>";
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=8", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function loadDtlData(composition_for_qty, baseqty, locale) {
	var blankObject = null;
	var fields = new Array();
	var fieldNames = new Array();
	var fmobj = parent.frameHeader.document.forms[0];
	fields[0] = fmobj.process_loss;
	//fieldNames[0] = getLabel("eST.ProcessLoss%.label", "ST");
	fieldNames[0] = getLabel("eST.ProcessLoss.label", "ST");
	fields[1] = fmobj.composition_for_qty;
	fieldNames[1] = getLabel("eST.Compositionfor.label", "ST");
	fields[2] = fmobj.req_qty;
	fieldNames[2] = getLabel("eST.ReqQty.label", "ST");
	  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	 if(fmobj.dflt_mfg_mode.value == "D"){
	fields[3] = fmobj.prep_loc;
	fieldNames[3] = getLabel("Common.PrepareLocation.label", "Common");
	fields[4] = fmobj.req_type;
	fieldNames[4] = getLabel("eST.PreparationType.label", "ST");
	fields[5] = fmobj.prep_mode;
	fieldNames[5] = getLabel("eST.PreparationMode.label", "ST");
	fields[6] = fmobj.item_code_desc;
	fieldNames[6] = getLabel("Common.ItemCode.label", "Common");
	//fields[6] = fmobj.req_qty;
	//fieldNames[6] = getLabel("eST.ReqQty.label", "ST");
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	
	document.getElementById("mfg_mode").disabled = true;
	
	//fmobj.document.getElementById("direct_mode").disabled = true;
	//fmobj.document.getElementById("by_request").disabled = true;
	
	//parent.frameHeader.document.getElementId('direct_mode').disabled = true;
	//parent.frameHeader.document.getElementId("by_request").disabled = true;
	getBatchIDFromExpiryDate(fmobj.expiry_date, fmobj.sys_date, locale);
	if (flag1) {
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	    if(fmobj.dflt_mfg_mode.value == "R")
		blankObject = checkSTFields(fields, fieldNames, parent.parent.messageFrame, errorPage);
		else
		blankObject = checkSTFields(fields, fieldNames,parent.parent.parent.messageFrame, errorPage);
		//ends
		//blankObject = checkSTFields(fields, fieldNames, parent.parent.messageFrame, errorPage);
		if (blankObject == true) {
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
		  if(fmobj.dflt_mfg_mode.value == "R"){
 			//xmlDom = new ActiveXObject("Microsoft.XMLDom");
			//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			xmlHttp = new XMLHttpRequest();  
			xmlStr = "<root><SEARCH /></root>";
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlDom.loadXML(xmlStr);
		    //if(fmobj.BarCodeApplicable.value == true){
			//xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=4&composition_for_qty=" + composition_for_qty.value, false);   
			xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=4&composition_for_qty=" + composition_for_qty.value+"&req_qty="+fmobj.req_qty.value, false); //Added by rabbani on RUT-CRF-0097
			}else{
			if(fmobj.req_type.value == "E"){
			fmobj.prep_mode.disabled = true;
			fmobj.req_type.disabled = true;
			fmobj.ExItem.disabled = true;
			}
			//fmobj.req_qty.disabled = true;
			fmobj.prep_loc.disabled = true;
		
			  //xmlDom = new ActiveXObject("Microsoft.XMLDom");
			  //xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			  xmlHttp = new XMLHttpRequest();
			  xmlStr = getEnhancedXMLString(fmobj);
			  xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	          //xmlDom.loadXML(xmlStr);
			  xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=24&composition_for_qty=" + composition_for_qty.value+"&req_qty="+fmobj.req_qty.value+"&dflt_mfg_mode="+fmobj.dflt_mfg_mode.value+"&req_type="+fmobj.req_type.value, false);
			}
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
			parent.frameHeader.document.forms[0].select.disabled = true;
			parent.frameDetail.location.href = "../../eST/jsp/ManufacturingReceiptsListResult.jsp?mode=" + MODE_INSERT + "&composition_for_qty=" + composition_for_qty.value + "&baseqty=" + baseqty.value+"&dflt_mfg_mode="+fmobj.dflt_mfg_mode.value;
			//clearMessageFrame();
		}
		
	}
}
function populateData(index, item_code, mode, store_code, comp_qty, req_qty, short_desc, qty, baseqty) {
	
	
	var trObject = eval(document.getElementById("tr_" + index));
	changeRowColor(trObject);
	// Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	 var dflt_mfg_mode = parent.frameHeader.Header.dflt_mfg_mode.value;
	 if(dflt_mfg_mode == "D" && mode == "1")
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";  
	else
	parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";  
	
	// These trn_qty is not used anywhere 
	var trn_qty = parseFloat(comp_qty) * parseFloat(qty) / parseFloat(baseqty);
	
	//parent.frameList.frameListHeader.location.href = "../../eST/jsp/ManufacturingReceiptsCriteria.jsp?item_code=" + item_code + "&index=" + index + "&function=default&store_code=" + store_code + "&item_qty=" + trn_qty + "&short_desc=" + encodeURIComponent(short_desc) + "&mode=" + mode + "&qty=" + qty+"&item_code="+item_code+"";	
	// Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts 
	parent.frameList.frameListHeader.location.href = "../../eST/jsp/ManufacturingReceiptsCriteria.jsp?item_code=" + item_code + "&index=" + index + "&function=default&store_code=" + store_code + "&item_qty=" + trn_qty + "&short_desc=" + encodeURIComponent(short_desc) + "&mode=" + mode + "&qty=" + qty+"&item_code="+item_code+"&dflt_mfg_mode="+dflt_mfg_mode+"";	
	
	if (mode == MODE_MODIFY) {
		parent.frameList.frameListDetail.location.href = "../../eST/jsp/ManufacturingReceiptsAddModify.jsp?item_code=" + item_code + "&index=" + index + "&function=default&short_desc=" +  encodeURIComponent(short_desc) + "&mode=" + mode + "&store_code=" + store_code;

	} else {
		parent.frameList.frameListDetail.location.href = "../../eST/jsp/ManufacturingReceiptsAddModify.jsp?item_code=" + item_code + "&index=" + index + "&function=default&store_code=" + store_code + "&item_qty=" + trn_qty + "&short_desc=" +  encodeURIComponent(short_desc) + "&mode=" + mode;
	}
}
function addToList(obj) {
	var operation = obj;
	var formObj = parent.frameListHeader.document.formListHeader;
	var formObj1 = parent.parent.frameList.frameListDetail.document.formListDetail;
	var proceed = false;
	var messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	formObj1.item_qty_parent.value = document.forms[0].adj_item_qty.value;
	var sum = 0;
	var quantity = parent.frameListHeader.document.forms[0].adj_item_qty.value;
	// Need To check This   Set Number can be used
	var lquantity = quantity;
	var rquantity = quantity;
	_total_checkboxes = formObj1.total_checkboxes.value;
	var sum = 0;
	for (i = 0; i < _total_checkboxes; i++) {
		var qty = eval("formObj1.item_qty_" + i).value;
		if (qty == "") {
			qty = 0;
		}
		if (!isNaN(qty)) {
			sum += parseFloat(qty);
		}
	}
	if (sum != rquantity) {
		alert("Sum Of Batch Quantity Must Be " + rquantity);
				//formObj.apply.disabled=false;
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getEnhancedXMLString(formObj1));
	xmlDoc = new DOMParser().parseFromString(getEnhancedXMLString(formObj1), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=5", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (result) {
		//parent.parent.frameDetail.location.href = "../../eST/jsp/ManufacturingReceiptsListResult.jsp?datMode=modify&mode=" + obj + "&index=" + formObj1.index.value + "&doc_no=" + document.forms[0].doc_no.value;
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		 var dflt_mfg_mode = parent.parent.frameHeader.Header.dflt_mfg_mode.value;
		parent.parent.frameDetail.location.href = "../../eST/jsp/ManufacturingReceiptsListResult.jsp?datMode=modify&mode=" + obj + "&index=" + formObj1.index.value + "&doc_no=" + document.forms[0].doc_no.value+"&dflt_mfg_mode="+dflt_mfg_mode+"&expiry=expiry";
		refreshDetails();
	} else {
		parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage(message, "ST");
	}
}
function refreshDetails() {
	//parent.frameListHeader.location.href='../../eST/jsp/ManufacturingReceiptsCriteria.jsp';
	//parent.frameListDetail.location.href='../../eCommon/html/blank.html';
	//parent.parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp";
	parent.frameListHeader.location.href = "../../eCommon/html/blank.html";
	parent.frameListDetail.location.href = "../../eCommon/html/blank.html";
	//parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	var dflt_mfg_mode = parent.parent.frameHeader.Header.dflt_mfg_mode.value;
	var mode = parent.parent.frameHeader.Header.mode.value;
	if(dflt_mfg_mode == "D" && mode == "1"){
    parent.parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	}else{
	parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp"; 
 }	
}
function calcComp(obj) {
	if (obj.value != "") {
		var   proc_loss = parent.frameHeader.document.forms[0].process_loss.value;
		//var req_qty = parent.frameHeader.document.forms[0].document.getElementById("rq").innerText;
		var req_qty = parent.frameHeader.document.forms[0].req_qty.value;//Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
		if (proc_loss != "" && req_qty != "") 
		parent.frameHeader.document.forms[0].composition_for_qty.value = Math.ceil(parseFloat(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100);
	}
}
function disbleStore() {
	if(parent.frameHeader.Header!=undefined){
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts 
	if(parent.frameHeader.Header.dflt_mfg_mode.value == "R")
	parent.frameHeader.Header.store_code_disabled.value = "disabled";
	else
	parent.frameHeader.Header.store_code_disabled.value = "";
	}
}
function editViewBatch(mode) {
	var formObj = document.formHeaderCriteria;
	var store_code = formObj.store_code.value;

	if (parent.frameListDetail.document.formListDetail != null) {
		if (!confirm(getMessage("BATCH_REFRESHED", "ST"))) {
			return;
		}
	}
	var _item_code = formObj.item_code.value;
	var item_qty = formObj.adj_item_qty.value;
	
	
	var expiry_yn = "true";

	parent.frameListDetail.location.href = "../../eST/jsp/ManufacturingReceiptsAddModify.jsp?function=edit&store_code=" + store_code + "&item_code=" + _item_code + "&expiry_yn=" + expiry_yn + "&item_qty=" +item_qty + "&index=" + formObj.index.value + "&mode=" + mode+"&short_desc="+encodeURIComponent(escape(formObj.short_desc.value));
}
function onMMove(obj, e, patinetName) {
	var patinetName = decodeURIComponent(patinetName,"UTF-8");
	if (patinetName != "") {
		obj.style.left = e.x + 10;
		obj.style.top = e.y;
		obj.style.borderColor = "pink";
		obj.style.borderWidth = "thin";
		obj.style.borderStyle = "";
		obj.style.width = 150;
		obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td align='left'  class='ordata'><font size=1>" + patinetName + "</font></td></tr></table>";
	} else {
		return false;
	}
}
function onMOut(obj) {
	obj.innerHTML = "";
	obj.style.width = 0;
	obj.style.borderColor = "";
	obj.style.borderWidth = "";
	obj.style.borderStyle = "";
}
function checkBatchQty(obj, available_qty) {
	if (checkDoubleFormat(obj)) {
		if (parseFloat(available_qty) < parseFloat(obj.value)) {
			alert(getMessage("QTY_NOT_GRT_AVLQTY", "ST"));
			obj.focus();
		}
	}
}
function loadReceiptDtlData(mode, composition_for_qty, doc_no) {
	if (mode == MODE_MODIFY) {
		parent.frames[1].location.href = "../../eST/jsp/ManufacturingReceiptsListResult.jsp?mode=" + MODE_MODIFY + "&composition_for_qty=" + composition_for_qty + "&doc_no=" + doc_no;
	} else {
		return;
	}
}
function displayGif(prep_type) {
	if (prep_type.value != "E") {
		parent.frameHeader.document.getElementById("im1").style.visibility = "visible";
		parent.frameHeader.document.getElementById("im2").style.visibility = "visible";
		parent.frameHeader.document.getElementById("im3").style.visibility = "visible";
		parent.frameHeader.document.getElementById("pid").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("eid").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("tid").style.visibility = "visible";
		parent.frameHeader.document.getElementById("tname").style.visibility = "visible";
		parent.frameHeader.document.getElementById("uom").style.visibility = "visible";
	} else {
		parent.frameHeader.document.getElementById("im1").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("im2").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("im3").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("pid").style.visibility = "visible";
		parent.frameHeader.document.getElementById("eid").style.visibility = "visible";
		parent.frameHeader.document.getElementById("tid").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("tname").style.visibility = "hidden";
		parent.frameHeader.document.getElementById("uom").style.visibility = "hidden";
	}
}
function cancelForm() {
	//parent.parent.frameDetail.location.reload();
	//refreshDetails();
	parent.frameListHeader.location.href = "../../eCommon/html/blank.html";
	parent.frameListDetail.location.href = "../../eCommon/html/blank.html";
	//parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	var mode = parent.parent.frameHeader.Header.mode.value;
	dflt_mfg_mode = parent.parent.frameHeader.Header.dflt_mfg_mode.value;
	if(dflt_mfg_mode == "D" && mode == "1" ){
	parent.parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	}else{
	 parent.parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
    }
}
async function deleterecord() {
	if(f_query_add_mod.frameDetail==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	
	var formObjDtl = f_query_add_mod.frameDetail.location.href.indexOf(".jsp");
	var formObj = f_query_add_mod.frameDetail.formDetail;
	if(formObj==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObj.mode.value == MODE_MODIFY) {
		formObj.mode.value = MODE_DELETE;
		if (formObjDtl != -1) {
		if(f_query_add_mod.frameHeader.document.forms[0].mfg_delete_yn.value=="N"){
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("NO_DELETE_ACCESS_FOR_USER", "ST");
		formObj.mode.value = MODE_MODIFY;
		return false;
		}
			var confirmation = await confirmDelete();
	 		
			if (confirmation == "Yes") {
				eval(formApply(formObj, ST_CONTROLLER));
				messageFrame.location.href = errorPage + "?err_num=" + message;
				if (result) {
					onSuccess(MODE_DELETE);
				}
			} else {
				messageFrame.location.href = errorPage + "?err_num=" + getMessage("OPER_CANCELLED", "ST");
				formObj.mode.value = MODE_MODIFY;
				return false;
			}
		}
	} else {
		message = "";
		messageFrame.location.href = errorPage + "?err_num=" + message;
		return false;
	}
}
function loadHdrData(store_code, doc_type, doc_no, mode) {
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
  var dflt_mode = "R";
  if(document.getElementById("dflt_id").checked)
	  dflt_mode = "D";
  else
	  dflt_mode = "R";
  parent.frames[1].location.href = "../../eST/jsp/ManufacturingReceiptsQueryResult.jsp?store_code=" + store_code.value + "&doc_type=" + doc_type.value + "&doc_no=" + doc_no.value + "&mode=" + mode+"&dflt_mfg_mode="+dflt_mode;;
}
async function confirmContinue() {
	/** @user - ST_PREPARE_HDR */
	var retVal = "";
	var dialogHeight = "10vh";
	var dialogWidth = "20vw";
	var dialogTop = "250";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/ConfirmContinue.jsp";
	retVal = await window.showModalDialog(url, arguments, features);
	if (retVal == null) {
		retVal = "";
	}
	return retVal;
}
function checkCompQty(obj,allow_deci_yn,no_of_decimals) {
	if (obj.value != "") {
		var comp_qty = "";
		var proc_loss = parent.frameHeader.document.forms[0].process_loss.value;
		//var req_qty = parent.frameHeader.document.forms[0].document.getElementById("rq").innerText;
		 var req_qty = parent.frameHeader.document.forms[0].req_qty.value;//Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
		if (proc_loss != "" && req_qty != "") {
			if(allow_deci_yn=="Y"){
			//commented by Rabbani #Inc no:29950 on 28/02/2013
			//comp_qty = (parseFloat(parseInt(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100)).toFixed(no_of_decimals);
			comp_qty =  Math.ceil(parseFloat(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100);
			}else{
			//comp_qty = (parseFloat(parseInt(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100)).toFixed(0);
			comp_qty =  Math.ceil(parseFloat(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100);
			}
		}
		if (parseInt(obj.value) > parseInt(comp_qty)) {
			alert(getMessage("COMP_QTY_NOT_GRT", "ST") + "  " + comp_qty);
			obj.value = comp_qty;
		}
	}
}
function getBatchIDFromExpiryDate(expiry_date_object, sys_date, locale) {
	 
	if (expiry_date_object.value != "") {
		//if(CheckDate(expiry_date_object))	{
		 
		if (validDateObj(expiry_date_object, "DMY", locale)) {
			if (!checkDateWithSysDate(sys_date, expiry_date_object)) {
				alert(getMessage("NOT_LESS_THAN_SYSDATE", "ST"));
				expiry_date_object.value=""; //Edge
				expiry_date_object.select();
				expiry_date_object.focus();
				flag1 = false;
			} else {
				flag1 = true;
			}
		}
	}
}
function CheckQty(obj, qty, available_qty) {
	if (obj != "" && qty != "") {
		if (parseFloat(obj.value) > parseFloat(available_qty)) {
			alert(getMessage("TFR_QTY_LESS_THAN_AVL_QTY", "ST"));
			obj.value="" //Edge
			obj.focus();
			return;
		} else {
			checkBatchQty(obj, available_qty);
		}
	}
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
async function showAssemblyDetails(item_code, prep_type, prep_mode, index,item,stock_uom_desc) {

 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
   if(document.Header.dflt_mfg_mode.value == "D"){
    if(item_code == "" || item_code == null)
	item_code = document.Header.item_code.value;
    if(prep_type == "" || prep_type == null)
	prep_type = document.Header.req_type.value;
	if(prep_mode == "" || prep_mode == null)
	prep_mode = document.Header.prep_mode.value;
    if(item == "" || item == null)
	item = document.Header.item_code_desc.value;
    if(stock_uom_desc == "" || item == stock_uom_desc)
	stock_uom_desc = document.Header.stock_desc.value;
	
	if(document.Header.item_code.value != "null" && document.Header.item_code.value != "" && document.Header.item_code.value != undefined && prep_type != "E"){ 
	var retVal = "";
	var dialogHeight = "20vh";
	var dialogWidth = "60vh";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/ManufacturingReceiptsResultList.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&prep_type=" + prep_type + "&prep_mode=" + prep_mode + "&index=" + index+"&process_loss_percent="+document.Header.process_loss.value+"&item="+item+"&baseqty="+document.Header.baseqty.value+"&stock_uom_desc="+encodeURIComponent(stock_uom_desc)+"&dflt_mfg_mode="+document.Header.dflt_mfg_mode.value;
	retVal = await window.showModalDialog(url, arguments, features); 
	}
	}else{
	var retVal = "";
	var dialogHeight = "20vh";
	var dialogWidth = "60vh";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments = "";
	var url = "../../eST/jsp/ManufacturingReceiptsResultList.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&prep_type=" + prep_type + "&prep_mode=" + prep_mode + "&index=" + index+"&process_loss_percent="+document.Header.process_loss.value+"&item="+item+"&baseqty="+document.Header.baseqty.value+"&stock_uom_desc="+encodeURIComponent(stock_uom_desc)+"&dflt_mfg_mode ="+document.Header.dflt_mfg_mode.value;
	retVal = await window.showModalDialog(url, arguments, features); 
	}
 
}
function PrintWorkSheet(req_no) {
	var formObj = parent.detailframe.ManufacturingResultReportForm;
	document.ManufacturingResultReportForm.p_request_no.value = req_no;
	formObj.submit();
	/*var retVal			="";
	var dialogHeight	= "20" ;
	var dialogWidth		= "40" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var url				= "../../eCommon/jsp/report_options.jsp?req_no='2'";
	retVal = window.showModalDialog(url,arguments,features); ******/
	/*
		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		xmlStr = "<root><SEARCH /></root>";
		xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "../../eST/jsp/ram_report_options.jsp?function_type=10"+"&p_request_no="+document.ManufacturingResultForm.p_request_no.value+"&bean_id="+document.ManufacturingResultForm.bean_id.value+"&p_bean_name="+document.ManufacturingResultForm.bean_name.value+"&p_module_id="+document.ManufacturingResultForm.p_module_id.value+"&p_report_id="+document.ManufacturingResultForm.p_report_id.value+"&p_user_name="+document.ManufacturingResultForm.p_user_name.value+"&p_facility_id="+document.ManufacturingResultForm.p_facility_id.value, false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		alert("1="+responseText);
	//	 eval(responseText);
		 //	alert("2="+responseText);

*/
}
function calculatecost() {
	var formObj = document.formHeaderCriteria;
	var quantity = formObj.adj_item_qty.value;
	/*var fields = new Array();
	var fieldNames = new Array();
		
	fields[0] = formObj.adj_item_qty;
	fieldNames[0] = getLabel("Common.Quantity.label", "Common");
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = checkSTFields(fields, fieldNames, parent.parent.parent.messageFrame, errorPage);
	
	if(blankObject!=true){
		formObj.adj_item_qty.focus();
		return;
	}*/
	if (quantity =="" ) {
			alert("Quantity cannot be blank");
		formObj.adj_item_qty.focus();
		return;
	}
	if (quantity != null) {
		if (quantity == 0) {
			alert(getMessage("CANNOT_BE_ZERO", "Common"));
		formObj.adj_item_qty.focus();	
		}
	}	
	var cost = document.getElementById('td_cost').innerTex ;//formObj.all.td_cost.innerText;
	var val = "";
		/**
	 * @Name - Priya
	 * @Date - 03/06/2010
	 * @Inc# - 
	 * @Desc -  To round up val_id based on the no_of_decimals_for_cost column in st_acc_entity_param table
	 */
	var no_of_decimals_for_cost = formObj.no_of_decimals_for_cost.value;
	if (quantity != "" && cost != "") {
		val = parseFloat(cost) * parseFloat(quantity);
				//formObj.all.val_id.innerText=parseFloat(val);
		//formObj.all.val_id.innerText = setNumber(val, no_of_decimals_for_cost);
		document.getElementById('val_id').innerText = setNumber(val, no_of_decimals_for_cost);
	} else {
		if ( val != "") 
		//formObj.all.val_id.innerText = setNumber(val, no_of_decimals_for_cost);
		document.getElementById('val_id').innerText =setNumber(val, no_of_decimals_for_cost);
	}
	
}
//function Disablepro(obj) {
function Disablepro(obj,dflt_mfg_mode) { //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013  
   var formObj = "";
   if(dflt_mfg_mode.value == "R")  
   formObj = parent.parent.f_query_add_mod.frameHeader.Header;
  else
   formObj = Header;
   
	//var formObj = parent.parent.f_query_add_mod.frameHeader.Header;
	if (formObj.process_loss.value == "") {
		formObj.process_loss.focus;
	} else {
		if (formObj.composition_for_qty.value == "") {
			formObj.composition_for_qty.focus;
		} else {
			formObj.process_loss.disabled = true;
			formObj.composition_for_qty.disabled = true;
		}
	}
	 //Added by rabbani on RUT-CRF-0097
	      if(formObj.req_qty.value == ""){
			formObj.req_qty.focus;
		   }else{
			formObj.req_qty.disabled = true;
		  }
}
async function searchRemarks(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].locale.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id";
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING;
	dataNameArray[2] = "trn_type";
	dataValueArray[2] = document.forms[0].rem_trans_type.value;
	dataTypeArray[2] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_TRN_REMARKS_LOOKUP_SELECT.value;
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
/**
* @Name - Priya
* @Date - 21/12/2009
* @Inc# - IN017084
* @Desc - To avoid the duplication records display in Modify mode
*/

function clearMessageFrame(){
var errorPage = "../../eCommon/jsp/error.jsp";
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
if(parent.messageFrame == undefined)  
parent.parent.messageFrame.location.href = errorPage + "?err_num=";  
else //ends
 parent.messageFrame.location.href = errorPage + "?err_num=";  
}

function allow_restrict_decimals(obj,event)
{
var allow_yn =	document.formHeaderCriteria.allow_deci_yn.value;
var  no_decimals = document.formHeaderCriteria.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}
function allow_restrict_decimals1(obj,event)
{
var allow_yn =	document.formListDetail.allow_deci_yn.value;
var  no_decimals = document.formListDetail.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}

function CheckQuantity(obj,dec_allowed_yn) {
	if(dec_allowed_yn=="Y"){
		if (!checkDoubleFormat(obj,false)) {
			return false;
		}
	}else{
		if (!checkIntegerFormat(obj,false)) {
			return false;
		}
	}
}
 //Added by Rabbani #Inc no:32766 on 18/05/12 Starts
function checklabelyn() {
	var addno = "1";
	if (document.Header.label_reqd_yn.checked == false) {
		document.Header.no_of_labels.value = "";
	} else {
		var addactno = document.Header.composition_for_qty.value;		
		var addLabelno = Math.ceil(addactno);
		document.Header.no_of_labels.value = Math.ceil(addLabelno);
	}	
}

function setbarcode(){
            var fmobj = parent.frameHeader.document.forms[0];
          if(fmobj.BarCodeApplicable.value == "true"){
            //xmlDom = new ActiveXObject("Microsoft.XMLDom");
			//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        	xmlDoc="";
			xmlHttp = new XMLHttpRequest();
				
			
 			xmlStr = "<root><SEARCH /></root>";
			//xmlDom.loadXML(xmlStr);
 			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=12&barcode_id_set=" + fmobj.barcode_id.value, false); 
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
}			
}

function NewBarcodeString(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){

        var fmobj = parent.frameHeader.document.forms[0];
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		if(fmobj.dflt_mfg_mode.value == "D"){
		store_code = fmobj.store_code_bar.value;
		}
		//alert(fmobj.BarCodeApplicable.value);
		if(fmobj.BarCodeApplicable.value == "true"){
		//alert(fmobj.BarCodeApplicable.value);
 		if(fmobj.BarcodeRule.value=="P" || fmobj.BarcodeRule.value=="S" ){
		 if(fmobj.batch_id.value == ""){
		 new_batch_id = (fmobj.batch_id_series.value)+(fmobj.next_batch_id.value);
 		 var barcode_ins =  CallNewBarcodeStringformanufg(bean_id,bean_name,facility_id,item_code,new_batch_id,Expiry_date,fmobj.trade_id,binlocn_code,store_code,barcode_id,item_qty);
		   fmobj.barcode_id.value = "";
		   fmobj.new_barcode.value = barcode_ins;
			
			xmlDom="";
			xmlHttp = new XMLHttpRequest();
 		    //xmlDom = new ActiveXObject("Microsoft.XMLDom");
			//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
 			xmlStr = "<root><SEARCH /></root>";
			//xmlDom.loadXML(xmlStr);
 			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=12&barcode_id_set="+barcode_ins, false); 
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText; 
		 }
		 else{
	  CallNewBarcodeString(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,fmobj.trade_id,binlocn_code,store_code,  barcode_id,item_qty,fmobj.mrp);
	  }
	  
	 }
}	 
}
/*function CallNewBarcodeStringformfg(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){

      
		  var formObj = f_query_add_mod.frameHeader.Header;		 
 	       var trn_type = formObj.trn_type.value;
	         if(formObj.BarcodeRule.value=="P"){
		  if(batch_id!= "" || Expiry_date.value!= ""){
			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			var mrp = formObj.mrp.value;
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type+ "&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
 			barcode_id.value=message;
			return barcode_id.value;
		}
		} else if(formObj.BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id.value!= ""){
			var manufacturer_id = formObj.manufacturer_id.value;
			var supplier_id = formObj.supplier_id.value;
			var mrp = formObj.mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trn_type=" + trn_type +"&trade_id=" + trade_id.value+ "&BarcodeRule=" + formObj.BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			
			barcode_id.value=message;
			return barcode_id.value;
			
		}
	}
	 
}
*/
function CallNewBarcodeStringformanufg(bean_id,bean_name,facility_id,item_code,batch_id,Expiry_date,trade_id,binlocn_code,store_code,barcode_id,item_qty){
 	 
		var trn_type = document.forms[0].trn_type.value;
	 if(document.forms[0].BarcodeRule.value=="P"){
		if(batch_id!= "" || Expiry_date.value!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trade_id=" + trade_id.value+ "&trn_type=" + trn_type+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
			return barcode_id.value;
		}
		} else if(document.forms[0].BarcodeRule.value=="S"){
		if(barcode_id.value=="" && item_qty != undefined && item_qty.value!="" && batch_id!= ""){
			var manufacturer_id = document.forms[0].manufacturer_id.value;
			var supplier_id = document.forms[0].supplier_id.value;
			var mrp = document.forms[0].mrp.value;

			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/CommonSearchValidate.jsp?validate=NEW_BARCODE_STRING&facility_id="+facility_id+"&item_code="+item_code + "&batch_id=" + batch_id+ "&Expiry_date=" + Expiry_date.value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&store_code="+store_code + "&binlocn_code=" + binlocn_code.value +"&manufacturer_id="+manufacturer_id+"&supplier_id="+supplier_id + "&mrp=" + mrp+ "&trade_id=" + trade_id.value+ "&trn_type=" + trn_type+ "&BarcodeRule=" + document.forms[0].BarcodeRule.value +"&BARCODE_YN=TRUE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);	
			barcode_id.value=message;
			return barcode_id.value;
		}
	}
	//alert(barcode_id.value);
}

//function setlabels(){
function setlabels(obj){
        //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013
		var  dflt_mfg_mode = obj.dflt_mfg_mode.value;
		var  mode = obj.mode.value;
		if(dflt_mfg_mode == "D" && mode == "1")
		var fmobj = f_query_add_mod.selectcriteriaframe.frameHeader.Header;
		else
		var fmobj = f_query_add_mod.frameHeader.Header;
       //ends
		if(fmobj.BarCodeApplicable.value == "true"){
       // var fmobj = parent.frameHeader.document.forms[0];
		// alert(fmobj.no_of_labels.value);
        // alert(fmobj.barcode_id.value);
        // alert(fmobj.BarCodeApplicable.value);
           // xmlDom = new ActiveXObject("Microsoft.XMLDom");
			//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			xmlDom  = "";
			xmlHttp = new XMLHttpRequest();
			
			xmlStr = "<root><SEARCH /></root>";
			//xmlDom.loadXML(xmlStr);
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
            xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=13&barcode_id="+fmobj.barcode_id.value+"&barcode_yn="+fmobj.BarCodeApplicable.value+"&no_of_labels="+fmobj.no_of_labels.value, false); 
			xmlHttp.send(xmlDom);			
			responseText = xmlHttp.responseText;
			}		 
}

//ends
//Added by Rabbani #Inc no:33352 on 18/06/12
function setRemarkscode(){
               // var formObj = f_query_add_mod.frameHeader.Header;
			   if(f_query_add_mod.frameHeader==undefined) //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013  
			    var formObj = f_query_add_mod.selectcriteriaframe.frameHeader.Header;
				else
			    var formObj = f_query_add_mod.frameHeader.Header;  
			  
               // xmlDom = new ActiveXObject("Microsoft.XMLDom");
			   // xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			    xmlDom  = "";
				xmlHttp = new XMLHttpRequest();
			    xmlStr = "<root><SEARCH /></root>";
			    //xmlDom.loadXML(xmlStr);
			    xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			    xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=14" + "&remarks_code=" + formObj.remarks_code_1.value + "&remarks_desc=" + formObj.remarks.value, false);
				xmlHttp.send(xmlDom);
				responseText = xmlHttp.responseText;
				eval(responseText);
   }
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
async function callItemSearchScreenmfg(obj, form) {
	var search_string = "";
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var store_code = "";
	//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 beg
	var sec_str="";
 	
	if(form.mfg_req_yn.value=='Y'){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=28&item_code=" + document.Header.item_code_desc.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (!result) {
			('Store does not have User access to process Manufacturing');
			
			
			window.close();
		}else{
			if(flag=="N"){
				alert('Assembly Details/MFG Formulary Not Defined for this Item');
				window.close();
				  
			}else{
				sec_str=message;
			}
		}
	}
	//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 end
		store_code = document.Header.store_code.value;
		if(store_code == ""){
			alert("APP-000001 Store code cannot be blank");
			return;
		}
	
		//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 beg
		if(form.mfg_req_yn.value=='Y'){
			search_string = sec_str;
		}else{//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 end
			search_string = document.Header.item_code_desc.value;
		}
		 mfg_item = "Y";
	     var frmObject = "";
	     var return_val = null;
		 var array_itemsearch = new Array();
		array_itemsearch[0] = "ST_MANUFACTURING_REQUEST"; // Function id..
		array_itemsearch[1] = form.req_type.value;
		array_itemsearch[2] = form.prep_mode.value == "" ? "A" : form.prep_mode.value;
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		 	
		return_val = await callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch,"MFG");	
	 
	if (return_val == null) {
		return;
	  }
		if (obj.name == "item_code_desc") {
		 if (callProc(store_code, return_val[0], obj.name, form)) {
		  // parent.parent.parent.frames[2].location.href = errorPage + "?err_num=";
			//frmObject = parent.frameHeader.Header;
			frmObject = document.Header;
			
			frmObject.item_code_desc.value = return_val[1];
			frmObject.item_code.value = return_val[0];
			frmObject.req_type.value = return_val[23];
		    frmObject.prep_mode.value = return_val[24];
		    frmObject.stock_desc.value = return_val[15];
		    
		    
		    document.getElementById('uom').innerText = "UOM"+ "  ";
		    document.getElementById('uom').style.visibility = "visible";
		    document.getElementById('stock_uom').innerText = return_val[15];
		    //frmObject.all.uom.innerText = "UOM"+ "  ";
			//frmObject.all.uom.style.visibility = "visible";
		    //frmObject.all.stock_uom.innerText = return_val[15];
			
			 setDecimalParameters(retVal[27],retVal[28],frmObject);
			frmObject.dec_allowed_yn.value = retVal[27];
			frmObject.no_of_decimals.value = retVal[28];
			frmObject.item_code_desc.disabled = true;
			frmObject.req_type.disabled = true;
			frmObject.prep_mode.disabled = true;
			//frmObject.all.item_chk.disabled = false;
			//document.getElementById.all.item_chk.disabled = false;
			document.getElementById('item_chk').disabled = false;	
			parent.frameHeader.Header.store_code_disabled.value = "disabled";
			//window.location.href = document.getElementById('hyper1').href;
		    populateBinLocation();
			//Added for ML-MMOH-CRF-1909 US3 starts
			populateExpiry();         
		    frmObject.expiry_date.value = frmObject.expiry.value; 
		    if(frmObject.expiry_date.value!=null && frmObject.expiry_date.value!="")  
		    	{
		    	frmObject.expiry_date.disabled='disabled';
				frmObject.cal.disabled='disabled';
		    	}
			//Added for ML-MMOH-CRF-1909 US3 ends
		}else{
		     var frmObject = parent.frameHeader.Header;
			frmObject.item_code.value = "";
			frmObject.item_code_desc.value = "";
			frmObject.item_code_desc.focus();
			return;
			}
		}
}

function onChanegeVal(obj) { //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	if(obj.value != "") {
	//alert(Header.patient_id.value);
	if(Header.patient_id.value != "")
	Header.patient_id.value = "";
	if(Header.encounter_id.value != "")
	Header.encounter_id.value = "";
	if(Header.item_code_desc.value != "")
	Header.item_code_desc.value = "";
    if (obj.value == "E") {
	  //Header.document.getElementById('im').style.visibility = "visible";  //patient_id
    	document.getElementById('im').style.visibility = "visible";
	  Header.searchitem.disabled = true;
	  Header.item_code_desc.maxLength = "20";
      Header.item_code_desc.value = "";
	 if (Header.item_code_desc.disabled) {
	  Header.item_code_desc.disabled = false;
	 }
	 Header.item_code.value = "";
	//Header.document.getElementById("stock_label").innerText = "";
	 Header.document.getElementById('stock_uom').innerText = "";
	 document.getElementById('stock_uom').innerText = "";
	 document.getElementById("pid").style.visibility = "visible";
	 document.getElementById("patient_id").style.visibility = "visible";
	 document.getElementById("p_button").style.visibility = "visible";
	 document.getElementById("eid").style.visibility = "visible";
	 document.getElementById("encounter_id").style.visibility = "visible";			
	 document.getElementById("ExItem").style.visibility = "visible";
	 //document.getElementById("expitm").style.visibility = "visible";
	 //document.getElementById("expitm1").style.visibility = "hidden";
	 Header.ExItem.disabled = false;
	//Header.expitm1.disabled = true;
	//Header.select.disabled = true;
	 Header.bin_location.disabled = true;	
    }else{
	        //Header.document.getElementById('im').style.visibility = "hidden";
			document.getElementById('im').classList.add('hidden');
			Header.searchitem.disabled = false;
		   //Header.add.disabled = false;
			Header.item_code_desc.maxLength = "60";
			document.getElementById("pn").innerText = "";
			document.getElementById("pid").style.visibility = "hidden";
			document.getElementById("patient_id").style.visibility = "hidden";
			document.getElementById("p_button").style.visibility = "hidden";
			document.getElementById("eid").style.visibility = "hidden";
			document.getElementById("encounter_id").style.visibility = "hidden";
			document.getElementById("ExItem").style.visibility = "hidden";
			//document.getElementById("add").style.visibility = "hidden";
			//document.getElementById("cancel").style.visibility = "hidden";
			Header.ExItem.disabled = true;
			Header.select.disabled = false;
			Header.bin_location.disabled = false;
	}
	           // xmlDom = new ActiveXObject("Microsoft.XMLDom");
    			
			    xmlHttp = new XMLHttpRequest();
			    xmlStr = "<root><SEARCH /></root>";
			    xmlDom= new DOMParser().parseFromString(xmlStr , "text/xml");
			    xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=25"+"&req_type="+ Header.req_type.value, false);
				xmlHttp.send(xmlDom);
				responseText = xmlHttp.responseText;
				eval(responseText);
	            displayGif(Header.req_type);
}
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function chkreqqty(){
 
//document.forms[0].document.getElementById('rq').innerText = document.forms[0].req_qty.value; 
 	document.getElementById('rq').innerText = document.forms[0].req_qty.value; 
	document.forms[0].composition_for_qty.value = document.forms[0].req_qty.value;
 //document.forms[0].process_loss.disabled = false;
 if(document.forms[0].process_loss.value == "")
 document.forms[0].process_loss.value = 0;
 var req_qty = document.forms[0].req_qty.value;
 var proc_loss = document.forms[0].process_loss.value;
 if(document.forms[0].req_qty.value != "" && document.forms[0].req_qty.value != "null"){
    document.forms[0].composition_for_qty.value  = Math.ceil(parseFloat(req_qty) + (parseFloat(proc_loss) * parseFloat(req_qty)) / 100);
	}
}
function populateBinLocation() { //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
     var formobj = document.forms[0];
	 var store_code = document.forms[0].store_code.value;
	  var item_code = document.forms[0].item_code.value;
	   document.forms[0].store_code_bar.value = store_code ;
	  
	        // xmlDom = new ActiveXObject("Microsoft.XMLDom");
		    // xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		     
		     xmlDom  = "";
			 xmlHttp = new XMLHttpRequest();
				
		     xmlStr = getEnhancedXMLString(formobj);
		     xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			 //xmlDom.loadXML(xmlStr);
			 xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=15&store_code="+store_code+ "&item_code="+item_code, false);
			 xmlHttp.send(xmlDom);
			 responseText = xmlHttp.responseText;
	         eval(responseText);
			  
	        var xmlDoc="";
	        var xmlHttp = new XMLHttpRequest();
	        var xmlStr = getEnhancedXMLString(formobj);
	        	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	        	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=7", false);
	        	xmlHttp.send(xmlDoc);
	        	responseText = xmlHttp.responseText;
			  	  
	        	getBaseQty	();
	 
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function getPatientName(patientID, formObject) {
	if (patientID.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = patientID;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom="";
	xmlHttp = new XMLHttpRequest();
	
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=16", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (formObject.all.pn.innerText == "") {
		alert(getMessage("INVALID_PATIENT", "ST"));
		patientID.focus();
	} else {
		addEncounterData(Header.patient_id);
		Header.ExItem.disabled = false;
	}
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
async function callPatientSearch(patientID, patientName, formObject) {
	var pat_id = await PatientSearch();
	if ((pat_id == null) || (pat_id == "")) {
		patientID.value = "";
		return;
	}
	patientID.value = pat_id;
	//Header.patient_id.disabled = true;
	Header.patient_id.disabled = true;
	getPatientName(patientID, formObject);
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function addEncounterData(obj) {
	if (obj.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = obj;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlDom="";
	xmlHttp = new XMLHttpRequest();
	
	xmlStr = getXMLString(arrayObject);
	//xmlDom.loadXML(xmlStr);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=17", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
async function callItemChildWindow(index) {
	var fields = new Array();
	var fieldNames = new Array();
	//var formObj = Header;
	var formObj =  Header;
	
	fields[0] = formObj.store_code;
	fieldNames[0] = getLabel("Common.ReqByStore.label", "Common");
	fields[1] = formObj.prep_loc;
	fieldNames[1] = getLabel("Common.PrepareLocation.label", "Common");
	fields[2] = formObj.req_type;
	fieldNames[2] = getLabel("eST.PreparationType.label", "ST");
	fields[3] = formObj.prep_mode;
	fieldNames[3] = getLabel("eST.PreparationMode.label", "ST");
	fields[4] = formObj.item_code_desc;
	fieldNames[4] = getLabel("Common.ItemCode.label", "Common");
	fields[5] = formObj.req_qty;
	fieldNames[5] = getLabel("eST.ReqQty.label", "ST");
	
	if (formObj.req_type.value == "E") {
		fields[6] = formObj.patient_id;
		fieldNames[6] = getLabel("Common.patientId.label", "common");
	}
	if (formObj.item_code.value == "" || formObj.item_code.value == null) {
		formObj.item_code.value = formObj.item_code_desc.value;
	}
	messageFrame = parent.parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
	
	if (blankObject == true) {
		if (index != "-1") {
			//xmlDom = new ActiveXObject("Microsoft.XMLDom");
			//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			xmlDom="";
			xmlHttp = new XMLHttpRequest();
			
			xmlStr = "<root><SEARCH /></root>";
			//xmlDom.loadXML(xmlStr);
			xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=18", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
		}
		retVal =await window.showModalDialog("../jsp/ManufacturingReceiptsChild.jsp?mode=" + MODE_INSERT + "&index=" + index + "&store_code=" + Header.store_code.value + "&seq_no=" + Header.extemp_item_seq.value, "", "dialogHeight:18vh; dialogWidth:50vw; center:0; status: no;  dialogTop :120;");
			if (retVal != null) {
			Header.select.disabled = false;
			Header.select.focus();
		}
	} else {
	//blankObject.focus();
	}
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 
function selectmode(){
parent.document.location.href = "../../eST/jsp/ManufacturingReceiptsFrame.jsp?mode=" + MODE_INSERT+"&dflt_mfg_mode=D";
}
function selectmfgmode(){
if(document.Header != null){
if(document.Header.mode.value == "1")
parent.parent.document.location.href = "../../eST/jsp/ManufacturingReceiptsFrame.jsp?mode="+MODE_INSERT+"&dflt_mfg_mode=R";
else
parent.document.location.href = "../../eST/jsp/ManufacturingReceiptsFrame.jsp?mode="+MODE_INSERT+"&dflt_mfg_mode=R";
}
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 
async function callItemSearchScreen(obj, form) {
	var search_string = "";
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	var store_code = "";
	if (obj.name == "child_item_code_desc") {
		store_code = parent.addModframe.AddModify_Form.store_code.value;
		search_string = parent.addModframe.AddModify_Form.child_item_code_desc.value;
		mfg_item = "A";
	} else {
		store_code = parent.addModframe.manufacturing_form.store_code.value;
		search_string = parent.addModframe.manufacturing_form.item_code_desc.value;
		mfg_item = "Y";
		if (store_code == "") {
			alert(getMessage("ST_STORE_CODE_BLANK", "ST"));
			parent.addModframe.manufacturing_form.req_store.focus();
			return;
		}
	}
	var frmObject = "";
	var return_val = null;
	if (form.name == "manufacturing_form") {
		var array_itemsearch = new Array();
		array_itemsearch[0] = "ST_MANUFACTURING_REQUEST"; // Function id..
		array_itemsearch[1] = form.req_type.value;
		array_itemsearch[2] = form.prep_mode.value == "" ? "A" : form.prep_mode.value;
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		return_val = await callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch,"MFG");
		if (return_val == null) {
			return;
		}
		parent.addModframe.manufacturing_form.req_type.value = return_val[23];
		parent.addModframe.manufacturing_form.prep_mode.value = return_val[24];
		parent.addModframe.manufacturing_form.req_type.disabled = true;
		parent.addModframe.manufacturing_form.prep_mode.disabled = true;
	} else { // For Extemporaneous type..  Default  item search should be called.
		return_val = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"MFG");
	}
	if (return_val == null) {
		return;
	}
	if (obj.name == "child_item_code_desc") {
		store_code = parent.addModframe.AddModify_Form.store_code.value;
		if (callProc(store_code, return_val[0], obj.name, form)) {
			var frmObject = parent.addModframe.AddModify_Form;
			frmObject.child_item_code_desc.value = return_val[1];
			frmObject.child_item_code.value = return_val[0];
			frmObject.uom_code.value = return_val[13];
			frmObject.all.stock_uom.innerText = return_val[15];
			frmObject.child_item_code_desc.disabled = true;
			setDecimalParameters(retVal[27],retVal[28],frmObject);
			frmObject.dec_allowed_yn.value = retVal[27];
			frmObject.no_of_decimals.value = retVal[28];
			frmObject.add.disabled = false;
			if (return_val[13] != "") {
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr = "<root><SEARCH /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=19&mfg_uom=" + return_val[13], false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
		} else {
			//alert(getMessage("NOT_STOCK_ITEM", "ST"));
			var frmObject = parent.addModframe.AddModify_Form;
			frmObject.child_item_code.value = "";
			frmObject.child_item_code_desc.value = "";
			frmObject.child_item_code_desc.focus();
			return;
		}
	} else {
		if (obj.name == "item_code_desc") {
			if (callProc(store_code, return_val[0], obj.name, form)) {
				parent.parent.frames[2].location.href = errorPage + "?err_num=";
				frmObject = parent.addModframe.manufacturing_form;
				frmObject.item_code_desc.value = return_val[1];
				frmObject.item_code.value = return_val[0];
				frmObject.all.stock_label.innerText = "Stock UOM" + "  ";
				frmObject.all.stock_uom.innerText = return_val[15];
				frmObject.item_code_desc.disabled = true;
				frmObject.add.disabled = false;
			 setDecimalParameters(retVal[27],retVal[28],frmObject);
			 	frmObject.dec_allowed_yn.value = retVal[27];
			frmObject.no_of_decimals.value = retVal[28];
			} else {
				frmObject = parent.frames[2].document.forms[0];
				frmObject.item_code.value = "";
				frmObject.item_code_desc.value = "";
				frmObject.item_code_desc.focus();
				return;
			}
		}
	}
}

//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function displayResult(index, seq_no) {
	var frmObject = parent.addModframe.AddModify_Form;
	var fields = new Array();
	var fieldNames = new Array();
	fields[0] = frmObject.child_item_code_desc;
	fieldNames[0] = getLabel("eST.Ingredients.label", "ST");
	fields[1] = frmObject.component_qty;
	fieldNames[1] = getLabel("Common.Quantity.label", "Common");
	fields[2] = frmObject.mfg_uom;
	fieldNames[2] = getLabel("eST.MFGUOM.label", "ST");
	if (checkFieldsManRec(fields, fieldNames)) {
		if (frmObject.mfg_uom.value != "") {
			mfg_uom = frmObject.mfg_uom.options[frmObject.mfg_uom.selectedIndex].text;
		}
		if (frmObject.mode.value != MODE_MODIFY) {
			if (index != "-1") {
				temp_jsp = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=21&index=" + index + "&mfg_desc=" + mfg_uom + "&stock_uom=" + frmObject.all.stock_uom.innerText;
			} else {
				temp_jsp = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=20&stock_uom=" + frmObject.all.stock_uom.innerText + "&mfg_desc=" + mfg_uom;
			}
		} else {
			temp_jsp = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=22&index=" + index + "&stock_uom=" + frmObject.all.stock_uom.innerText;
		}
		callValidatepage(temp_jsp);
		if (!result) {
			alert(getMessage(message, "ST"));
			cancelDatamode();
		} else {
			parent.addModframe.location.href = "../../eST/jsp/ManufacturingReceiptsChildAddModify.jsp?mode=" + frmObject.mode.value + "&index=-1&seq_no=" + seq_no;
			parent.detailframe.location.href = "../../eST/jsp/ManufacturingReceiptsChildResult.jsp?mode=" + frmObject.mode.value + "&index=" + index + "&seq_no=" + seq_no;
		}
	}
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function checkFieldsManRec(fields, names) {
	var errors = "";
	for (var i = 0; i < fields.length; i++) {
		if (trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		} else {
			errors = errors + "APP-000001 " + names[i] + getLabel("Common.Cannotbeblank.label", "Common") + "\n";
		}
	}
	if (errors.length != 0) {
		alert(errors);
		return false;
	}
	return true;
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function callValidatepage(temp_jsp) {
	var frmObject = parent.addModframe.AddModify_Form;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getEnhancedXMLString(frmObject);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function cancelDatamode(index, seq_no) {
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingReceiptsChildAddModify.jsp?mode=" + parent.addModframe.AddModify_Form.mode.value + "&index=-1&seq_no=" + seq_no;
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function closeWindow(seq_no) {
	total_checkboxes = parent.detailframe.ManufacturingResultForm.totalRecords.value;
	var forInserting = "";
	var ItemCode = "";
	var canProcess = 0;
	for (i = 0; i < total_checkboxes; i++) {
		if (eval("parent.detailframe.ManufacturingResultForm.del_" + i + ".checked")) {
			ItemCode += eval("parent.detailframe.ManufacturingResultForm.itemcode_" + i + ".value") + ",";
		} else {
			canProcess++;
			forInserting += eval("parent.detailframe.ManufacturingResultForm.itemcode_" + i + ".value") + ",";
		}
	}
	ItemCode = ItemCode.substring(0, ItemCode.length - 1);
	forInserting = forInserting.substring(0, forInserting.length - 1);
	if (parseInt(canProcess) == 0) {
		alert(getMessage("MIN_ONE_CHILD_ITEM_REQD", "ST"));
		return;
	}
	 
	if (ItemCode.length > 0 || forInserting.length > 0) {
		temp_jsp = "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=18&seq_no="+seq_no +"&forInserting="+ forInserting+"&ItemCode="+ItemCode;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	}
	
	//parent.parent.window.returnValue = forInserting;
	//parent.window.close();
	
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = forInserting;
	
	const dialogTag = parent.document.getElementById('dialog_tag');    
	dialogTag.close(); 
	    
}
//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 
function modifyChildData(index, seq_no) {
	var frmObject = parent.addModframe.ManufacturingResultForm;
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingReceiptsChildAddModify.jsp?index=" + index + "&mode=" + MODE_INSERT + "&seq_no=" + seq_no;
}

//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
function callProc(store_code, item_code, objName, form) {
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr = getEnhancedXMLString(form);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?store_code=" + store_code + "&item_code=" + item_code + "&function_type=23&objName=" + objName, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var process = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (result) {
		if (document.forms[0].stock_item_yn.value == "N") {
			process = false;
			if (objName == "item_code_desc") {
				parent.parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("NOT_STOCK_ITEM", "ST");
				 
			}
			return false;
		}
	} else {
		process = false;
		if (objName == "item_code_desc") {
			parent.parent.parent.frames[2].location.href = errorPage;//+"?err_num="+ getMessage(message);
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
		} else {
			if (message == "PHY_INV_PROCESS_INITIATED") {
				alert(getMessage(message, "ST") + "\n" + getLabel("eST.PhyInventoryID.label", "ST") + ":" + document.forms[0].phy_inv_id.value);
			} else {
				alert(getMessage(message, "ST"));
			}
			return;
		}
	}
	return process;
}
 function setDecimalParameters(allow_yn,no_decimals,frmObject){ 
		frmObject.allow_deci_yn.value = allow_yn;
		frmObject.dec_allowed_yn.value = allow_yn;
		frmObject.no_deci.value = no_decimals;
		frmObject.no_of_decimals.value = no_decimals;
}
function allow_restrict_decimals2(obj,event)
{
var allow_yn =	document.AddModify_Form.allow_deci_yn.value;
var  no_decimals = document.AddModify_Form.no_deci.value;
 if(allow_yn=='N')
 return isValidInteger();
	if(allow_yn=='Y')
	{
	 var validate = isValidInteger();
	  if(!validate){
	  return isValidInteger();
	  }else{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
	   }
	}
}

function prep_select(obj){
    
      var xmlHttp = new XMLHttpRequest();
      var xmlString = getXMLString(null);  
      var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml"); 
            var url = "../../eST/jsp/ManufacturingReceiptsValidate.jsp";
           var params = "prep_loc=" + encodeURIComponent(obj.value) + "&function_type=26";
	    xmlHttp.open("POST", url + "?" + params, false);
	    //xmlHttp.open("POST", url, false);
	    //xmlHttp.setRequestHeader("Content-Type", "application/xml");
		xmlHttp.send(xmlDoc);
        var responseText = xmlHttp.responseText;
		eval(responseText) ;
	if (result)
		document.Header.batch_id.readOnly = false;
	}
/*
function prep_select(obj){
    
	if(obj.value != "") {
	 document.Header.batch_id.value = "";
	 document.Header.batch_id.readOnly = true;
      var xmlHttp = new XMLHttpRequest();
	   var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?prep_loc="+obj.value+"&function_type=26" , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (result)
		document.Header.batch_id.readOnly = false;
	}
}*/
function loadresultpage(obj,mode)
{
  //Added by Rabbani for avoid doubleclick on radio button on 12-APR-2013
  if(obj.value == "D"){
	  document.getElementById('dflt_id').disabled = true;
	  document.getElementById('dflt_id1').disabled = false;
	  document.getElementById('dflt_id1').checked = false;
  }else{
	  document.getElementById('dflt_id').disabled  = false;
	  document.getElementById('dflt_id1').disabled = true;
	  document.getElementById('dflt_id').checked  = false;
  }
  //ends
	parent.frames[1].location.href = "../../eST/jsp/ManufacturingReceiptsQueryResult.jsp?dflt_mfg_mode="+obj.value+"&mode=" + mode;
}
function allow_req_decimals(obj,event)
{
var allow_yn =	document.Header.allow_deci_yn.value;
var  no_decimals = document.Header.no_deci.value;
 if(allow_yn == "N"){
         return isValidInteger();
	  // obj.onkeypress=function(){return isValidInteger()};
	   }
	if(allow_yn=="Y")
	{
	  var validate = isValidInteger();
	  if(!validate){
	  return isValidInteger();
	  }else{
	   //obj.onkeypress=function(){return isValidNumber(obj,event,7,parseInt(no_decimals))};
	   obj.onkeypress=function(){return isValidReqNumber(obj,event,7,parseInt(no_decimals))};
	   }
	}
}
/*function CompQtychk(obj){
var allow_yn =	document.Header.allow_deci_yn.value;
var  no_decimals = document.Header.no_deci.value;
checkCompQty(obj,allow_yn,no_decimals);
}*/

/*function allow_processloss_decimals(fld, e, maxInt)
{
var allow_yn =	document.Header.allow_deci_yn.value;
var  no_decimals = document.Header.no_deci.value; 
 if(allow_yn == "N"){
         return isValidInteger();
	   }else{
      var validate = isValidInteger();
	  if(!validate){
	  return isValidInteger();
	  }else{
     fld.onkeypress=function(){return isValidNumberforMultiLine(fld, e, 2, no_decimals,allow_yn)};
	 }
	 }
	 fld.onkeypress=function(){return isValidNumberforMultiLine(fld, e, 2, allow_deci_yn,no_deci)};
}*/


function checkBarcodeChars(obj) {
	if (obj.value == "") {
		return;
	} 
	if (!CheckBarcode(obj)) {
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED", "ST"));
		obj.focus();
		return false;
	}
	return true;
}
function CheckBarcode(Obj){
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122)));
            else{
                specCharsExist = false;
                break;
            }
        }
        return specCharsExist;
  }

  function isValidReqNumber(fld, e, maxInt, deci) {
	var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 0) {
						fld.value = fld.value + ".";
					}else{
						return false;
					}
				}
			}
		} else {
			if (count > maxInt) {
				var objectValue = fld.value;
				var dotOccurance = objectValue.indexOf(".");
				if ((objectValue.charAt(maxInt)) != ".") {
					if (dotOccurance == -1) {
						if (deci != 0) {
							fld.value = objectValue.substring(0, maxInt) + ".";
						} else {
							//fld.value = objectValue.substring(0, maxInt);
							return false;
						}
						return false;
					}
				}
			}
		}
	}
	var strCheck = ".0123456789";
	if (deci == 0) {
		strCheck = "0123456789";
	}
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) {
		return false;   
	}
	var pointCount = 0;
	for (var i = 0; i < fldvalue.length; i++) {
		if (fldvalue.charAt(i) == ".") {
			pointCount++;
		}
	}
	if (pointCount > 0 && whichCode == 46) {
		return false;
	}
	var fldValue = fld.value;
	var dotIndex = fldValue.indexOf(".");
	var fldLength = fldValue.length;
	if(isValidInteger()){
	var selectedText = ShowSelection(fld); 
	if(selectedText != 0){
		return true;
	}
	}
	if (dotIndex != -1) {
		if (fldLength > (dotIndex + deci)) {
			return false;
		}
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;  // Not a valid key
	}
	return true;
}
function ShowSelection(id)
{
  var selectedText;
  // IE version
  if (document.selection != undefined)
  {
    id.focus();
    var sel = document.selection.createRange();
    selectedText = sel.text;
  }
  // Mozilla version
  else if (id.selectionStart != undefined)
  {
    var startPos = id.selectionStart;
    var endPos = id.selectionEnd;
    selectedText = id.value.substring(startPos, endPos)
  }
   return selectedText;
}

function populateExpiry() { //Added for ML-MMOH-CRF-1909 US3 Starts
    var formobj = document.forms[0];
	 var store_code = document.forms[0].store_code.value;
	  var item_code = document.forms[0].item_code.value;
	   document.forms[0].store_code_bar.value = store_code ;
	  
	         //xmlDom = new ActiveXObject("Microsoft.XMLDom");
		     //xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	   		 xmlDom  = "";
	   		 xmlHttp = new XMLHttpRequest();
	   		 xmlStr = getEnhancedXMLString(formobj);
			 //xmlDom.loadXML(xmlStr);
		     xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
			 xmlHttp.open("POST", "../../eST/jsp/ManufacturingReceiptsValidate.jsp?function_type=29&item_code="+item_code, false);
			 xmlHttp.send(xmlDom);
			 responseText = xmlHttp.responseText;
	         eval(responseText);

}//Added for ML-MMOH-CRF-1909 US3 Ends



 
