function create() {
	f_query_add_mod.location.href = "../../eST/jsp/AssemblyDetailFrame.jsp?mode=" + MODE_INSERT;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/AssemblyDetailQueryCriteria.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function onSuccess(mode, index) {
	if (mode.value == MODE_INSERT) {
	
		f_query_add_mod.location.reload();
	} else {
	  // f_query_add_mod.location.reload();
	   create();
	//	f_query_add_mod.detailframe.location.href = "../../eST/jsp/AssemblyDetailListResult.jsp?mode=" + mode.value + "&index=" + index.value;
	//	f_query_add_mod.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?mode=" + mode.value + "&index=-1";
	}
}
function reset() {


	if (f_query_add_mod.document.query_form != null) {
		
		f_query_add_mod.document.query_form.reset();
	
	}
	if(f_query_add_mod.selectcriteriaframe!=undefined)
	if (f_query_add_mod.selectcriteriaframe.document.AssemblyDetail_form != null) {
	if(!result){
	f_query_add_mod.location.reload();
	}else{
	var mode = f_query_add_mod.selectcriteriaframe.AssemblyDetail_form.mode.value;
	var index = f_query_add_mod.selectcriteriaframe.AssemblyDetail_form.index.value;

/* @Name - Rams
 * @Date - 12/17/2009
 * @Inc# - IN-17270
 * @Desc - For Reset Work
 */


     f_query_add_mod.selectcriteriaframe.location.href = "../../eST/jsp/AssemblyDetailCriteria.jsp?mode="+mode+"&index="+index;
	f_query_add_mod.detailframe.location.href = "../../eST/jsp/AssemblyDetailListResult.jsp?mode="+mode+"&index="+index;
	f_query_add_mod.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?mode="+mode;	
		
		
		
	}
	}
}
function assignzero(obj) {
	var formObj = parent.parent.f_query_add_mod.selectcriteriaframe.AssemblyDetail_form;
	if ((formObj.process_loss).value < 0) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "Common"));
		formObj.process_loss.focus();
	} else {
		formObj.process_loss.value = formObj.process_loss.value;
	}
}
function apply() {
	var blankObject = null;
	var fields = new Array();
	var fieldNames = new Array();
	if(f_query_add_mod.selectcriteriaframe==undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
		return;
	}

	var formObj = f_query_add_mod.selectcriteriaframe.AssemblyDetail_form;
	fields[0] = formObj.item_code_desc;
	fieldNames[0] = getLabel("Common.item.label", "Common");
	fields[1] = formObj.base_qty;
	fieldNames[1] = getLabel("Common.Quantity.label", "Common");
	fields[2] = formObj.process_loss;
	fieldNames[2] = getLabel("eST.ProcessLoss.label", "ST");
	var errorPage = "../../eCommon/jsp/error.jsp";
	blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
	if (blankObject == true) {
		var canProcess = 0;
		var forInserting = "";
		var formObject = f_query_add_mod.detailframe.AssemblyDetailResultForm;
		var total_checkboxes = formObject.totalRecords.value;
		for (i = 0; i < total_checkboxes; i++) {
			if (eval("formObject.del_" + i + ".checked")) {
				forInserting += ("Y,");
			} else {
				canProcess++;
				forInserting += ("N,");
			}
		}
		forInserting = forInserting.substring(0, forInserting.length - 1);
		formObj.checkBoxVals.value = forInserting;
		if (parseInt(canProcess) == 0) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MIN_ONE_CHILD_ITEM_REQD", "ST");
			return;
		} else {
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
			
				onSuccess(formObj.mode, formObj.index);
			}
		}
	} else {
	}
}
function checkOnDelete(checkObj, tblrow_id, noOfCols, rowIndex) {
	if (checkObj.checked == true) {
		cancelRecord(tblrow_id, noOfCols);
	} else {
		activateRecord(tblrow_id, noOfCols);
	}
}
function displayResult(index) {

	var frmObject = parent.addModframe.AddModify_Frame;
	if (parent.selectcriteriaframe.AssemblyDetail_form.item_code.value != "") {
		var blankObject = null;
		var fields = new Array();
		var fieldNames = new Array();
		fields[0] = frmObject.child_item_code_desc;
		fieldNames[0] = getLabel("eST.Ingredients.label", "ST");
		fields[1] = frmObject.component_qty;
		fieldNames[1] = getLabel("Common.Quantity.label", "Common");
		fields[2] = frmObject.mfg_uom;
		fieldNames[2] = getLabel("eST.MFGUOM.label", "ST");
		fields[3] = frmObject.Seqence_No;
		fieldNames[3] = getLabel("Common.SequenceNo.label", "Common");
		var SEQ_NO = frmObject.SEQ_NO.value;
		var Seqence_No = frmObject.Seqence_No.value;
		messageFrame = parent.parent.frames[2];
		var errorPage = "../../eCommon/jsp/error.jsp";
		blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
		var mfg_uom = "";
		if (blankObject == true) {
			if (frmObject.child_item_code.value != parent.selectcriteriaframe.AssemblyDetail_form.item_code.value) {
				if (getUOMConvertionFactor()) {
					if (frmObject.mfg_uom.value != "") {
						mfg_uom = frmObject.mfg_uom.options[frmObject.mfg_uom.selectedIndex].text;
					}
					if (frmObject.mode.value != MODE_MODIFY) {
						if (index != "-1") {
							//temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=3&index=" + index + "&mfg_desc=" + mfg_uom + "&stock_uom=" + frmObject.all.stock_uom.innerText + "&Conv_factor=" + frmObject.all.td_sale_stk_uom_conv.innerHTML+"&allow_deci_yn="+frmObject.allow_deci_yn.value+"&no_deci="+frmObject.no_deci.value+"&td_sale_stk_uom_conv_rule=" + frmObject.all.td_sale_stk_uom_conv_rule.innerHTML;
							temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=3&index=" + index + "&mfg_desc=" + mfg_uom + "&stock_uom=" + document.getElementById("stock_uom").innerText + "&Conv_factor=" + document.getElementById("td_sale_stk_uom_conv").innerHTML+"&allow_deci_yn="+frmObject.allow_deci_yn.value+"&no_deci="+frmObject.no_deci.value+"&td_sale_stk_uom_conv_rule=" + document.getElementById("td_sale_stk_uom_conv_rule").innerHTML;
						} else {
							//temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=1&stock_uom=" + frmObject.all.stock_uom.innerText + "&Conv_factor=" + frmObject.all.td_sale_stk_uom_conv.innerHTML + "&mfg_desc=" + mfg_uom+"&allow_deci_yn="+frmObject.allow_deci_yn.value+"&no_deci="+frmObject.no_deci.value+"&td_sale_stk_uom_conv_rule=" + frmObject.all.td_sale_stk_uom_conv_rule.innerHTML;
							temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=1&stock_uom=" + document.getElementById("stock_uom").innerText + "&Conv_factor=" + document.getElementById("td_sale_stk_uom_conv").innerHTML + "&mfg_desc=" + mfg_uom+"&allow_deci_yn="+frmObject.allow_deci_yn.value+"&no_deci="+frmObject.no_deci.value+"&td_sale_stk_uom_conv_rule=" + document.getElementById("td_sale_stk_uom_conv_rule").innerHTML;
						}
					} else {
						//temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=4&index=" + index + "&stock_uom=" + frmObject.all.stock_uom.innerText + "&Conv_factor=" + frmObject.all.td_sale_stk_uom_conv.innerHTML + "&mfg_desc=" + mfg_uom + "&uom_code=" + frmObject.uom_code.value+"&td_sale_stk_uom_conv_rule=" + frmObject.all.td_sale_stk_uom_conv_rule.innerHTML;
						temp_jsp = "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=4&index=" + index + "&stock_uom=" + document.getElementById("stock_uom").innerText + "&Conv_factor=" + document.getElementById("td_sale_stk_uom_conv").innerHTML + "&mfg_desc=" + mfg_uom + "&uom_code=" + frmObject.uom_code.value+"&td_sale_stk_uom_conv_rule=" + document.getElementById("td_sale_stk_uom_conv_rule").innerHTML;
					}
					callValidatepage(temp_jsp, index);
				//parent.addModframe.location.href="../../eST/jsp/AssemblyDetailAddModify.jsp?mode="+frmObject.mode.value+"&index=-1";
				//parent.detailframe.location.href="../../eST/jsp/AssemblyDetailListResult.jsp?mode="+frmObject.mode.value+"&index="+index;
				} else {
					return false;
				}
			} else {
				alert(getMessage("ST_ASMB_CHILD_ITEM_NOT_SAME", "ST"));
				cancelData();
			}
		} else {
			//blankObject.focus();
		}
	} else {
		alert(getMessage("ST_ASMB_ITEM_NOT_BLANK", "ST"));
		parent.selectcriteriaframe.AssemblyDetail_form.item_code_desc.focus();
	}
}
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
	if (obj.name == "child_item_code_desc") {
		search_string = parent.addModframe.AddModify_Frame.child_item_code_desc.value;
		mfg_item = "A";
	} else {
		search_string = parent.selectcriteriaframe.AssemblyDetail_form.item_code_desc.value;
		mfg_item = "Y";
	}
	var frmObject = "";
	var return_val =null;
	if (form.name == "AssemblyDetail_form") {
		var array_itemsearch = new Array();
		array_itemsearch[0] = "ST_ASSEMBLY_DTL"; // Function id.. If more parameters are required then add it in the arraylist and get that in the itemsearchbean
		
		return_val = await callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch);
	} else { // For Extemporaneous type..  Default  item search should be called.
		
		return_val = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	}
//Commented by Mahesh on 7/16/2008 as it is opening the itemsearch screen twice if "query caused no records" is displayed.
	//var return_val = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	if (return_val != null) {
		if (obj.name == "child_item_code_desc") {
		//var  returnvals=item_code+"æ"+item_name+"æ"+expiry_yn+"æ"+item_class+"æ"+alpha_code+"æ"+mfg_base_qty+"æ"+machine_code+"æ"+min_stk_qty+"æ"+max_stk_qty+"æ"+long_desc+"æ"+ps_item_yn+"æ"+sole_source_yn+"æ"+manufacturer_id+"æ"+gen_uom_code+"æ"+unit_cost+"æ"+uom_desc+"æ"+manufacture_desc+"æ"+trade_id_applicable_yn+"æ"+batch_id_applicable_yn;
			frmObject = parent.addModframe.AddModify_Frame;
			frmObject.child_item_code_desc.value = return_val[1];
			frmObject.child_item_code.value = return_val[0];
			frmObject.uom_code.value = return_val[13];
			document.getElementById("stock_uom").innerText = return_val[15];
			frmObject.dec_allowed_yn.value =return_val[27];
			var stock_uom = return_val[15];
			var item_code = return_val[0];
			frmObject.child_item_code_desc.disabled = true;
			setDecimalParameters(return_val[27],return_val[28],frmObject);
			if (return_val[13] != "") {
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr = "<root><SEARCH /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=5&mfg_uom=" + return_val[13] + "&stock_uom=" + stock_uom + "&item_code=" + item_code+"&uom_code="+return_val[13], false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
					//alert(responseText);
				eval(responseText);
				//frmObject.all.td_sale_stk_uom_conv.innerHTML = "1";
				document.getElementById("td_sale_stk_uom_conv").innerHTML = "1";
			}
			populateMFGUoms();
		} else {
			if (obj.name == "item_code_desc") {
				frmObject = parent.selectcriteriaframe.AssemblyDetail_form;
				frmObject.item_code_desc.value = return_val[1];
				frmObject.item_code_desc.disabled = true;
				frmObject.item_code.value = return_val[0];
				document.getElementById('stock_uom').innerText = return_val[15];
				setDecimalParameters(return_val[27],return_val[28],frmObject);
				/*alert(return_val[27])
				We can use these two for the Decimal CRF 1/12/2010 Rams
				alert(return_val[28])*/
			}
		}
	}
}
function callValidatepage(temp_jsp, index) {
	var frmObject = parent.addModframe.AddModify_Frame;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getEnhancedXMLString(frmObject);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
		//alert(responseText);
	eval(responseText);
	if (!result) {
		if (message == "ITEM_CODE_ALREADY_EXIST") {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage(message, "ST");
			parent.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?mode=" + frmObject.mode.value + "&index=-1";
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage(message, "ST");
			parent.addModframe.AddModify_Frame.Seqence_No.value = "";
			parent.addModframe.AddModify_Frame.Seqence_No.focus();
		}
	} else {
		parent.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?mode=" + frmObject.mode.value + "&index=-1";
		parent.detailframe.location.href = "../../eST/jsp/AssemblyDetailListResult.jsp?mode=" + frmObject.mode.value + "&index=" + index;
	}
}
function getUOMConvertionFactor() {
	var detailForm = document.AddModify_Frame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = errorPage + "?err_num=";
	bean_id = detailForm.bean_id.value;
	bean_name = detailForm.bean_name.value;
	if (detailForm.mfg_uom.value != "") {
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH " + detailForm.mfg_uom.name + "=\"" + detailForm.mfg_uom.value + "\"/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=2&uom_code=" + detailForm.uom_code.value + "&item_code=" + detailForm.child_item_code.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
			//alert(responseText);
		eval(responseText);
		if (!result) {
			document.getElementById("td_sale_stk_uom_conv").innerHTML = "";
			alert(getMessage("ST_NO_CONV_FACTOR_MFG_UOM_CODE", "ST"));
			//	detailForm.mfg_uom.value=detailForm.uom_code.value;
				//document.getElementById("td_sale_stk_uom_conv").innerHTML="1";
			detailForm.mfg_uom.focus();
			return false;
				//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?error_value=0&err_num=";
				//return;
		}
		return true;
		//}
		/*else{
			detailForm.mfg_uom.value=detailForm.uom_code.value;
			document.getElementById("td_sale_stk_uom_conv").innerHTML="1";
		}*/
	}
	//return;
}
function modifyData(index, instrn_code) {
	var frmObject = parent.addModframe.AddModify_Frame;

	if (frmObject.child_item_code_desc.value != parent.selectcriteriaframe.AssemblyDetail_form.item_code_desc.value) {
		parent.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?index=" + index + "&mode=" + parent.selectcriteriaframe.AssemblyDetail_form.mode.value + "&instrn_code=" + instrn_code;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	} else {
		alert(getMessage("ST_ASMB_CHILD_ITEM_NOT_SAME", "ST"));
		cancelData();
			//frmObject.child_item_code_desc.focus();
	}
}
function cancelData() {
	parent.addModframe.location.href = "../../eST/jsp/AssemblyDetailAddModify.jsp?mode=" + parent.selectcriteriaframe.AssemblyDetail_form.mode.value;
}
function checkVal(obj, form) {
	if (obj.value != "") {
		callItemSearchScreen(obj, form);
	} else {
		return false;
	}
}
function Modify(index) {
	parent.f_query_add_mod.location.href = "../../eST/jsp/AssemblyDetailFrame.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&index=" + index;
}
async function showInstruction(item_code, mode) {
	retVal =await window.showModalDialog("../../eST/jsp/AssemblyMfgInstruction.jsp?item_code=" + item_code + "&mode=" + mode, "", "dialogHeight:55vh; dialogWidth:55vw; center:0; status: no; dialogLeft :15; dialogTop :10;");
}
function updateInstructions() {
	formObject = document.formMfgInstructions;
	if (!setTextAreaMaxLength(formObject.instruction, 4000)) {
		alert(getMessage("REMARKS_CHAR_EXCEEDS_LIMIT", "ST"));
		return;
	}
	if (formObject.instruction.value == "") {
		alert("APP-000005 - " + getLabel("eST.MfgInstructions.label", "ST") + " " + getLabel("Common.Cannotbeblank.label", "Common"));
		return;
	}
	bean_id = formObject.bean_id.value;
	bean_name = formObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlStr = getXMLString(null); 
	var xmlDom =  new DOMParser().parseFromString(xmlStr, "text/xml");;
	var xmlHttp = new XMLHttpRequest();
	//xmlStr = getXMLString(formObject);
	xmlStr = "<root><SEARCH ";
	xmlStr += " instruction=\"" + encodeURIComponent(formObject.instruction.value,"UTF-8") + "\"";//Added for ML-MMOH-SCF-0302 IN:58060 by B.Badmavathi on 12/11/2015
	xmlStr += " /></root>";
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=6&instruction=" + encodeURIComponent(formObject.instruction.value,"UTF-8"), false);//Added for ML-MMOH-SCF-0302 IN:58060 by B.Badmavathi on 12/11/2015
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag"); 
    dialogTag.close();
}
function populateMFGUoms() {
	formObject = document.AddModify_Frame;
	var bean_id = formObject.bean_id.value;
	var bean_name = formObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	//var xmlDom = "";
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH /></root>";
	//xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=7&uom_code=" + formObject.uom_code.value, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	//alert(responseText);
	eval(responseText);
	if (formObject.assembly_size > 0) {
		formObject.mfg_uom[formObject.mfg_uom.selectedIndex].text = mfg_desc;
	}
}
function checkSeqNo(obj) {
	var str = obj.value;
	if (str.charAt(0) == "0" && str.length > 1) {
		var str1 = str.substring(1, str.length);
		obj.value = str1;
	}
}
function CheckForSequence(event) {
	var strCheck = "1234567890";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	return true;
}
function populateMFGUoms1() {
	formObject = document.AddModify_Frame;
	var mfg_desc = formObject.MFG_DESC.value;
	var bean_id = formObject.bean_id.value;
	var bean_name = formObject.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH /></root>";
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/AssemblyDetailValidate.jsp?function_type=7", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
}

function setDecimalParameters(allow_yn,no_decimals,frmObject) {
		


		frmObject.allow_deci_yn.value = allow_yn;
		frmObject.no_deci.value = no_decimals;

}
function allow_restrict_decimals(obj,event)
{

var allow_yn =	document.AssemblyDetail_form.allow_deci_yn.value;
var  no_decimals = document.AssemblyDetail_form.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}
function allow_restrict_decimals_child(obj,event)
{
var allow_yn =	document.AddModify_Frame.allow_deci_yn.value;
var  no_decimals = document.AddModify_Frame.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}


function isValidNumberCost(fld, e, maxInt, deci) {
	

	/*var disp_allowed_yn = "Y";
	if(document.forms[0].dec_allowed_yn!=undefined){
		disp_allowed_yn = document.forms[0].dec_allowed_yn.value;
	}
	if(disp_allowed_yn=="N"){
		deci = 0;
	}		*/
	var count = fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (count >= maxInt) {
		if (count == maxInt) {
			var dotOccurance = fld.value.indexOf(".");
			if (((dotOccurance >= maxInt) || (dotOccurance == -1)) && (count == maxInt)) {
				if (whichCode != 46) {
					if (deci > 1) {
						fld.value = fld.value + ".";
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
							fld.value = objectValue.substring(0, maxInt);
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
		return true;  // Enter
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
//Added for ML-MMOH-CRF-1909 starts
function isValidShelfLifeValue(fld) {
    var input = fld.value;
    if (isNaN(input) || input > 999) {
          // If input is not valid, set input field value to an empty string
          document.getElementById("shelfLifeValue").value = "";
        }
}
//Added for ML-MMOH-CRF-1909 ends
