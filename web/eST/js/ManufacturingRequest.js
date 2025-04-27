
var prevObj = null;
var prevColor = null;
var errorPage = "../../eCommon/jsp/error.jsp";
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturingRequestFrame.jsp?mode=" + MODE_INSERT;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturingRequestCriteria.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id;
}
function onSuccess() {
	f_query_add_mod.location.href = "../../eST/jsp/ManufacturingRequestFrame.jsp?mode=" + MODE_INSERT;
}
function reset() {
	f_query_add_mod.location.reload();
}
function apply() {
if(f_query_add_mod.detailframe.ManufacturingResultForm==undefined){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObjcheck = f_query_add_mod.detailframe.location.href.indexOf(".jsp");
	var formObj = f_query_add_mod.addModframe.manufacturing_form;
	var mode = f_query_add_mod.detailframe.ManufacturingResultForm.mode.value;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObjcheck != -1) {
		if (formObj.item_code.value == "" || formObj.item_code.value == null) {
			formObj.item_code.value = formObj.item_code_desc.value;
		}
		total_checkboxes = f_query_add_mod.detailframe.ManufacturingResultForm.totalRecords.value;
		var forInserting = "";
		var canProcess = 0;
		for (i = 0; i < total_checkboxes; i++) {
			if (eval("f_query_add_mod.detailframe.ManufacturingResultForm.del_" + i + ".checked")) {
				forInserting += "Y,";
			} else {
				canProcess++;
				forInserting += "N,";
			}
		}
		forInserting = forInserting.substring(0, forInserting.length - 1);
		formObj.checkBoxVals.value = forInserting;
		if (parseInt(canProcess) == 0 && mode == 1) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("MIN_ONE_ITEM_REQD", "ST");
			return;
		} else {
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			messageFrame.location.href = errorPage + "?err_num=" + message + flag;//flag Added By Sakti Sankar against Inc#34852 on 19/09/2012 ;
			if (result) {
				onSuccess();
			}
		}
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return false;
	}
}
function checkOnDelete(checkObj, tblrow_id, noOfCols, rowIndex) {
	if (checkObj.checked == true) {
		cancelRecord(tblrow_id, noOfCols);
	} else {
		activateRecord(tblrow_id, noOfCols);
	}
}
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
	if (checkFieldsManReq(fields, fieldNames)) {
		if (frmObject.mfg_uom.value != "") {
			mfg_uom = frmObject.mfg_uom.options[frmObject.mfg_uom.selectedIndex].text;
		}
		if (frmObject.mode.value != MODE_MODIFY) {
			if (index != "-1") {
				//Commented and Added by suresh.r on 14-04-2014 against #048582(SKR-SCF-0985)
				//temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=3&index=" + index + "&mfg_desc=" + mfg_uom + "&stock_uom=" + frmObject.all.stock_uom.innerText;
				temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=3&index=" + index + "&mfg_desc=" + encodeURIComponent(mfg_uom,"UTF-8") + "&stock_uom=" + encodeURIComponent(frmObject.all.stock_uom.innerText,"UTF-8");
			} else {
				//Commented and Added by suresh.r on 14-04-2014 against #048582(SKR-SCF-0985)
				//temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=1&stock_uom=" + frmObject.all.stock_uom.innerText + "&mfg_desc=" + mfg_uom;
				temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=1&stock_uom=" + encodeURIComponent(frmObject.all.stock_uom.innerText,"UTF-8") + "&mfg_desc=" + encodeURIComponent(mfg_uom,"UTF-8");
			}
		} else {
			//Commented and Added by suresh.r on 14-04-2014 against #048582(SKR-SCF-0985)
			//temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=4&index=" + index + "&stock_uom=" + frmObject.all.stock_uom.innerText;
			temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=4&index=" + index + "&stock_uom=" + encodeURIComponent(frmObject.all.stock_uom.innerText,"UTF-8");
		}
		callValidatepage(temp_jsp);
		if (!result) {
			alert(getMessage(message, "ST"));
			cancelData();
		} else {
			parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestAddModify.jsp?mode=" + frmObject.mode.value + "&index=-1&seq_no=" + seq_no;
			parent.detailframe.location.href = "../../eST/jsp/ManufacturingRequestListResult.jsp?mode=" + frmObject.mode.value + "&index=" + index + "&seq_no=" + seq_no;
		}
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
	var store_code = "";
	if (obj.name == "child_item_code_desc") {
		store_code = parent.addModframe.AddModify_Form.store_code.value;
		search_string = parent.addModframe.AddModify_Form.child_item_code_desc.value;
		mfg_item = "A";
	} else {
		store_code = parent.addModframe.manufacturing_form.req_store.value;
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
// Added on 10/1/2005 by RAM pass the parameters as an array list...so that it  n number of parameters can be send for item search query.
	if (form.name == "manufacturing_form") {
		var array_itemsearch = new Array();
		array_itemsearch[0] = "ST_MANUFACTURING_REQUEST"; // Function id..
		array_itemsearch[1] = form.req_type.value;
		array_itemsearch[2] = form.prep_mode.value == "" ? "A" : form.prep_mode.value;
		return_val = await callItemSearchWindowParam(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment, array_itemsearch);
		if (return_val == null) {
			return;
		}
		parent.addModframe.manufacturing_form.req_type.value = return_val[23];
		parent.addModframe.manufacturing_form.prep_mode.value = return_val[24];
		parent.addModframe.manufacturing_form.req_type.disabled = true;
		parent.addModframe.manufacturing_form.prep_mode.disabled = true;
	} else { // For Extemporaneous type..  Default  item search should be called.
		return_val = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
	}
//Commented by Mahesh on 7/16/2008 as it is opening the itemsearch screen twice if "query caused no records" is displayed.
	//var return_val = callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment);
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
				xmlHttp.open("POST", "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=5&mfg_uom=" + return_val[13], false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
		} else {
			alert(getMessage("NOT_STOCK_ITEM", "ST"));
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
				document.querySelector('td.label#stock_label[nowrap]').innerText = "Stock UOM" + "  ";
				document.querySelector('#stock_uom').innerText=return_val[15];
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
function modifyData(index) {
	var trObject = eval(document.getElementById("tr_" + index));
	changeRowColor(trObject);
	var frmObject = parent.addModframe.manufacturing_form;
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestCriteria.jsp?index=" + index + "&mode=" + frmObject.mode.value;
}
function cancelHdrData(index) {
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestCriteria.jsp?mode=" + parent.addModframe.manufacturing_form.mode.value + "&index=-1";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}
function checkVal(obj, form) {
	if (obj.value != "") {
		callItemSearchScreen(obj, form);
	} else {
		return false;
	}
}
function Modify(index) {
	parent.f_query_add_mod.location.href = "../../eST/jsp/ManufacturingRequestAddModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + function_id + "&index=" + index;
}
function addEncounterData(obj) {
	if (obj.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = obj;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=2", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
async function callPatientSearch(patientID, patientName, formObject) {
	var pat_id = await PatientSearch();
	if ((pat_id == null) || (pat_id == "")) {
		patientID.value = "";
		return;
	}
	patientID.value = pat_id;
	parent.addModframe.manufacturing_form.patient_id.disabled = true;
	getPatientName(patientID, formObject);
}
function getPatientName(patientID, formObject) {
	if (patientID.value == "") {
		return;
	}
	var arrayObject = new Array();
	arrayObject[0] = patientID;
	/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "ManufacturingRequestValidate.jsp?function_type=6", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	if (formObject.all.pn.innerText == "") {
		alert(getMessage("INVALID_PATIENT", "ST"));
		patientID.focus();
	} else {
		addEncounterData(parent.addModframe.manufacturing_form.patient_id);
		parent.addModframe.manufacturing_form.ExItem.disabled = false;
	}
}
async function callItemChildWindow(index) {
	var fields = new Array();
	var fieldNames = new Array();
	var formObj = parent.addModframe.manufacturing_form;
	/*	fields[0]		=	formObj.req_store;
	fieldNames[0]	=	"Requesting Store";
	fields[1]		=	formObj.prep_loc;
	fieldNames[1]	=	"Prepare Location";
	fields[2]		=	formObj.req_type;
	fieldNames[2]	=	"Preparation Type";
	fields[3]		=	formObj.prep_mode;
	fieldNames[3]	=	"Preparation Mode";
	fields[4]		=	formObj.item_code_desc;
	fieldNames[4]	=	"Item Code";
	fields[5]		=	formObj.req_qty;
	fieldNames[5]	=	"Request Qty";*/
	fields[0] = formObj.req_store;
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
	fieldNames[5] = getLabel("Common.ReqQuantity.label", "Common");
	if (formObj.req_type.value == "E") {
		/*fields[6]		=	formObj.patient_id;
		fieldNames[6]	=	"Patient ID";*/
		fields[6] = formObj.patient_id;
		fieldNames[6] = getLabel("Common.patientId.label", "common");
	}
	if (formObj.item_code.value == "" || formObj.item_code.value == null) {
		formObj.item_code.value = formObj.item_code_desc.value;
	}
	messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
	if (blankObject == true) {
		if (index != "-1") {
			/*xmlDom = new ActiveXObject("Microsoft.XMLDom");
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlDom = "";
		    var xmlHttp = new XMLHttpRequest();
			xmlStr = "<root><SEARCH /></root>";
			xmlDom.loadXML(xmlStr);
			xmlHttp.open("POST", "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=8", false);
			xmlHttp.send(xmlDom);
			responseText = xmlHttp.responseText;
		}
		retVal = await  window.showModalDialog("../jsp/ManufacturingRequestChild.jsp?mode=" + MODE_INSERT + "&index=" + index + "&store_code=" + parent.addModframe.manufacturing_form.req_store.value + "&seq_no=" + parent.addModframe.manufacturing_form.extemp_item_seq.value, "", "dialogHeight:18vh; dialogWidth:50vw; center:0; status: no;  dialogTop :120;");
			if (retVal != null) {
			parent.addModframe.manufacturing_form.add.disabled = false;
			parent.addModframe.manufacturing_form.add.focus();
		}
	} else {
//	blankObject.focus();
	}
}
function loadData() {
	var formObj = parent.selectcriteriaframe.manufacturing_form;
	temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=9";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getEnhancedXMLString(formObj);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	var index = "-1";
	cancelHdrData(index);
	parent.detailframe.location.href = "../../eST/jsp/ManufacturingRequestHeaderResult.jsp?mode=" + MODE_MODIFY;
}
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
		temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=8&seq_no=" + seq_no + "&forInserting=" + forInserting + "&ItemCode=" + ItemCode;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = "<root><SEARCH/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	}
	parent.parent.window.returnValue = forInserting;
	parent.window.close();
}
function hdrData(index) {
	var fields = new Array();
	var fieldNames = new Array();
	var formObj = parent.addModframe.manufacturing_form;
	fields[0] = formObj.req_store;
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
	fieldNames[5] = getLabel("Common.ReqQuantity.label", "Common");
	if (formObj.req_type.value == "E") {
		fields[6] = formObj.patient_id;
		fieldNames[6] = getLabel("Common.patientId.label", "common");
	}
	if (formObj.item_code.value == "" || formObj.item_code.value == null) {
		formObj.item_code.value = formObj.item_code_desc.value;
	}
	messageFrame = parent.parent.messageFrame;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
	if (blankObject == true) {
		if (formObj.req_type.value != "E" && index == "-1") {
			if (formObj.req_type.value != formObj.preptype.value) {
				alert(getMessage("PREP_TYPE_DO_NOT_MATCH", "ST"));
				formObj.item_code_desc.disabled = false;
				formObj.item_code_desc.focus();
				return;
			}
			if (formObj.prep_mode.value != formObj.prepmode.value) {
				alert(getMessage("PREP_MODE_DO_NOT_MATCH", "ST"));
				formObj.item_code_desc.disabled = false;
				formObj.item_code_desc.focus();
				return;
			}
		}
		if (index != "-1") {
			//Commented and Added by suresh.r on 14-04-2014 against #048582(SKR-SCF-0985)
			//temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=10&stock_uom=" + document.getElementById("stock_uom").innerText + "&index=" + index + "&patient_name=" + document.getElementById("pn").innerText;
			temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=10&stock_uom=" + encodeURIComponent(document.getElementById("stock_uom").innerText,"UTF-8") + "&index=" + index + "&patient_name=" + document.getElementById("pn").innerText;
		} else {
			//Commented and Added by suresh.r on 14-04-2014 against #048582(SKR-SCF-0985)
			//temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=4&stock_uom=" + document.getElementById("stock_uom").innerText + "&patient_name=" + document.getElementById("pn").innerText;
			temp_jsp = "../../eST/jsp/ManufacturingRequestValidate.jsp?function_type=4&stock_uom=" + encodeURIComponent(document.getElementById("stock_uom").innerText,"UTF-8") + "&patient_name=" + document.getElementById("pn").innerText;
		}
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getEnhancedXMLString(formObj);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		cancelHdrData(index);
		parent.detailframe.location.href = "../../eST/jsp/ManufacturingRequestHeaderResult.jsp?mode=" + MODE_INSERT + "&index=" + index;
	}
}
function cancelData(index, seq_no) {
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestAddModify.jsp?mode=" + parent.addModframe.AddModify_Form.mode.value + "&index=-1&seq_no=" + seq_no;
}
function onChanegeVal(obj) {
    if (obj.value === "E") {
        const imElement = document.getElementById('im');
        if (imElement) {
            imElement.style.visibility = "visible";
        }
        const form = parent.addModframe.manufacturing_form;
        form.searchitem.disabled = true;
        form.add.disabled = true;
        form.item_code_desc.maxLength = 20;
        form.item_code_desc.value = "";
        form.item_code_desc.disabled = false; // Enable the input if it's disabled
        form.item_code.value = "";
        
        const stockLabelElement = document.getElementById("stock_label");
        const stockUomElement = document.getElementById("stock_uom");
        if (stockLabelElement) {
            stockLabelElement.innerText = "";
        }
        if (stockUomElement) {
            stockUomElement.innerText = "";
        }

        document.getElementById("pid").style.visibility = "visible";
        document.getElementById("p_text").style.visibility = "visible";
        document.getElementById("p_button").style.visibility = "visible";
        document.getElementById("eid").style.visibility = "visible";
        document.getElementById("e_sel").style.visibility = "visible";
        form.ExItem.disabled = false;
    } else {
        const imElement = document.getElementById('im');
        if (imElement) {
            imElement.style.visibility = "hidden";
        }
        const form = parent.addModframe.manufacturing_form;
        form.searchitem.disabled = false;
        form.add.disabled = false;
        form.item_code_desc.maxLength = 60;
        
        const pnElement = document.getElementById("pn");
        if (pnElement) {
            pnElement.innerText = "";
        }

        document.getElementById("pid").style.visibility = "hidden";
        document.getElementById("p_text").style.visibility = "hidden";
        document.getElementById("p_button").style.visibility = "hidden";
        document.getElementById("eid").style.visibility = "hidden";
        document.getElementById("e_sel").style.visibility = "hidden";
        form.ExItem.disabled = true;
    }
}



/*
function onChanegeVal(obj) {
	if (obj.value != "") {
		if (obj.value == "E") {
			parent.addModframe.manufacturing_form.document.getElementById('im').style.visibility = "visible";
			parent.addModframe.manufacturing_form.searchitem.disabled = true;
			parent.addModframe.manufacturing_form.add.disabled = true;
			parent.addModframe.manufacturing_form.item_code_desc.maxLength = "20";
			parent.addModframe.manufacturing_form.item_code_desc.value = "";
			if (parent.addModframe.manufacturing_form.item_code_desc.disabled) {
				parent.addModframe.manufacturing_form.item_code_desc.disabled = false;
			}
			parent.addModframe.manufacturing_form.item_code.value = "";
			parent.addModframe.manufacturing_form.document.getElementById("stock_label").innerText = "";
			parent.addModframe.manufacturing_form.document.getElementById("stock_uom").innerText = "";
			document.getElementById("pid").style.visibility = "visible";
			document.getElementById("p_text").style.visibility = "visible";
			document.getElementById("p_button").style.visibility = "visible";
			document.getElementById("eid").style.visibility = "visible";
			document.getElementById("e_sel").style.visibility = "visible";
			parent.addModframe.manufacturing_form.ExItem.disabled = false;
		} else {
			parent.addModframe.manufacturing_form.document.getElementById('im').style.visibility = "hidden";
			parent.addModframe.manufacturing_form.searchitem.disabled = false;
			parent.addModframe.manufacturing_form.add.disabled = false;
			parent.addModframe.manufacturing_form.item_code_desc.maxLength = "60";
			parent.addModframe.manufacturing_form.document.getElementById("pn").innerText = "";
			document.getElementById("pid").style.visibility = "hidden";
			document.getElementById("p_text").style.visibility = "hidden";
			document.getElementById("p_button").style.visibility = "hidden";
			document.getElementById("eid").style.visibility = "hidden";
			document.getElementById("e_sel").style.visibility = "hidden";
			parent.addModframe.manufacturing_form.ExItem.disabled = true;
		}
	}
}*/
function deleterecord() {
	var formObj = f_query_add_mod.addModframe.manufacturing_form;
	formObj.mode.value = MODE_DELETE;
	var errorPage = "../../eCommon/jsp/error.jsp";
	eval(formApply(formObj, ST_CONTROLLER));
	messageFrame.location.href = errorPage + "?err_num=" + message;
	if (result) {
		onSuccess(MODE_DELETE);
	}
}
function modifyChildData(index, seq_no) {
	var frmObject = parent.addModframe.ManufacturingResultForm;
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestAddModify.jsp?index=" + index + "&mode=" + MODE_INSERT + "&seq_no=" + seq_no;
}
function checkFieldsManReq(fields, names) {
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

function dispField(preparation_type) {
    switch (preparation_type) {
        case "E":
            document.getElementById("pid").style.visibility = "visible";
            document.getElementById("p_text").style.visibility = "visible";
            document.getElementById("p_button").style.visibility = "visible";
            document.getElementById("eid").style.visibility = "visible";
            document.getElementById("e_sel").style.visibility = "visible";
            document.getElementById("im").style.visibility = "visible";
            break;
        default:
            document.getElementById("pid").style.visibility = "hidden";
            document.getElementById("p_text").style.visibility = "hidden";
            document.getElementById("p_button").style.visibility = "hidden";
            document.getElementById("eid").style.visibility = "hidden";
            document.getElementById("e_sel").style.visibility = "hidden";
            document.getElementById("im").style.visibility = "hidden";
            break;
    }
}

/*
function dispField(preparation_type) {
	if (preparation_type == "E") {
		document.getElementById("pid").style.visibility = "visible";
		document.getElementById("p_text").style.visibility = "visible";
		document.getElementById("p_button").style.visibility = "visible";
		document.getElementById("eid").style.visibility = "visible";
		document.getElementById("e_sel").style.visibility = "visible";
		document.getElementById("im").style.visibility = "visible";
	} else {
		document.getElementById("pid").style.visibility = "hidden";
		document.getElementById("p_text").style.visibility = "hidden";
		document.getElementById("p_button").style.visibility = "hidden";
		document.getElementById("eid").style.visibility = "hidden";
		document.getElementById("e_sel").style.visibility = "hidden";
		document.getElementById("im").style.visibility = "hidden";
	}
}*/
function callProc(store_code, item_code, objName, form) {
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr = getEnhancedXMLString(form);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ManufacturingRequestValidate.jsp?store_code=" + store_code + "&item_code=" + item_code + "&function_type=7&objName=" + objName, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	var process = true;
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (result) {
		if (document.forms[0].stock_item_yn.value == "N") {
			process = false;
			if (objName == "item_code_desc") {
				parent.parent.frames[2].location.href = errorPage + "?err_num=" + getMessage("NOT_STOCK_ITEM", "ST");
			}
			return false;
		}
	} else {
		process = false;
		if (objName == "item_code_desc") {
			parent.parent.frames[2].location.href = errorPage;//+"?err_num="+ getMessage(message);
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
function onMMove(obj, e, patinetName) {
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
async function callRemarksModal(index, remarks) {
	retVal =await window.showModalDialog("../../eST/jsp/ManufacturingRequestItem.jsp?index=" + index + "&remarks=" + remarks, "", "dialogHeight:50vh; dialogWidth:28vw; dialogLeft:200; dialogRight:150; center:0; status: no;  dialogTop :200;");
	if (retVal != null) {
		parent.addModframe.manufacturing_form.remarks.value = retVal;
	}
}
function closeModal() {
	//parent.window.close();
	
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   	
}
function retainVal(remarks) {
	returnValue = remarks.value;
	closeModal();
}
function loadPage() {
	parent.addModframe.location.href = "../../eST/jsp/ManufacturingRequestCriteria.jsp?mode=" + MODE_INSERT + "&index=-1";
}
function changeRowColor(obj) {
	tot = document.forms[0].totalRecords.value;
	tot = tot - 1;
	if (prevObj != null) {
		for (k = 0; k < 7; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[1].className;
	for (k = 0; k < 7; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}

function setDecimalParameters(allow_yn,no_decimals,frmObject) {
		
	//alert(no_decimals);

		frmObject.allow_deci_yn.value = allow_yn;
		frmObject.no_deci.value = no_decimals;

}
function allow_restrict_decimals(obj,event)
{
var allow_yn =	document.manufacturing_form.allow_deci_yn.value;
var  no_decimals = document.manufacturing_form.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}
function allow_restrict_decimals1(obj,event)
{
var allow_yn =	document.AddModify_Form.allow_deci_yn.value;
var  no_decimals = document.AddModify_Form.no_deci.value;

 if(allow_yn=='N')
	   obj.onkeypress=function(){return isValidInteger()};
	
	if(allow_yn=='Y')
	{
	   obj.onkeypress=function(){return isValidNumber(obj,event,12,parseInt(no_decimals))};
      
	}
}
