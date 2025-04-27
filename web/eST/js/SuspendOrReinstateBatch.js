var headTop = -1;
var FloatHead;
var prevObj = null;
var prevColor = null;
function onSuccess() {
	f_query_add_mod_criteria.location.reload();
	f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
}
function reset() {
	f_query_add_mod_criteria.location.reload();
	f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}
function apply() {
	var formObjcheck = f_query_add_mod_result.SuspendOrReinstate_Detail;
	var total_checkboxes = 0 ;
	if(formObjcheck != undefined || formObjcheck != null)
	var total_checkboxes = formObjcheck.totalRecords.value;
	
	var canProcess = 0;
	var noDetailExists = false;
	var errorPage = "../../eCommon/jsp/error.jsp";
	for (i = 0; i < total_checkboxes; i++) {
		if (eval("f_query_add_mod_result.document.SuspendOrReinstate_Detail.checkbox" + i) != null || eval("f_query_add_mod_result.document.SuspendOrReinstate_Detail.checkbox" + i) != undefined) {
			if (eval("f_query_add_mod_result.document.SuspendOrReinstate_Detail.checkbox" + i + ".checked")) {
			} else {
				canProcess++;
			}
		}
	}
	if (total_checkboxes == canProcess) {
		noDetailExists = true;
	}
	if (noDetailExists) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	var blankObject = null;
	var fields = new Array();
	var fieldNames = new Array();
	var formObj = f_query_add_mod_criteria.SuspendReinstate_form;
	fields[0] = formObj.item_desc;
	fieldNames[0] = getLabel("Common.item.label", "Common");
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (formObj.item_code.value != null) {
		blankObject = checkSTFields(fields, fieldNames, messageFrame, errorPage);
		if (blankObject == true) {
			if (f_query_add_mod_result.location.href.indexOf(".jsp") != -1) {
				var xmlStr = getEnhancedXMLString(f_query_add_mod_result.SuspendOrReinstate_Detail);
				tempJsp = "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?function_type=2";
				callValidatepage(tempJsp, xmlStr);
				var responseText = formApply(formObj, ST_CONTROLLER);
				eval(responseText);
				messageFrame.location.href = errorPage + "?err_num=" + message;
				if (result) {
					onSuccess();
				}
			} else {
				message = "";
				messageFrame.location.href = errorPage + "?err_num=" + message;
				return false;
			}
		}
	}
}
function checkOnDelete(checkObj, tblrow_id, noOfCols, rowIndex) {
	if (checkObj.checked == true) {
		cancelRecord(tblrow_id, noOfCols);
	} else {
		activateRecord(tblrow_id, noOfCols);
	}
}
async function callItemSearchScreen(obj, form) {
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var search_string = parent.f_query_add_mod_criteria.SuspendReinstate_form.item_desc.value;
	var store_code = "";
	var category = "A";
	var sole_source = "A";
	var ps_item = "A";
	var mfg_item = "A";
	var expiry = "A";
	var consignment = "A";
	var item_class = "";
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	var return_val = await callItemSearchWindow(search_string, store_code, category, sole_source, ps_item, mfg_item, expiry, item_class, consignment,"SUSPEND");
	if (return_val != null) {
		obj.value = return_val[1];
		form.item_code.value = return_val[0];
		document.getElementById('uom').innerText = return_val[15];
		document.getElementById('exp_id').innerText = getLabel("Common.Expiry.label", "Common");
		if (return_val[2] == "Y") {
			document.getElementById('exp_data').innerHTML = "<img src='../../eCommon/images/enabled.gif' align=center>";
		} else {
			document.getElementById('exp_data').innerHTML = "<img src='../../eCommon/images/disabled.gif' align=center>";
		}
		parent.f_query_add_mod_criteria.SuspendReinstate_form.item_desc.disabled = true;
		parent.f_query_add_mod_criteria.SuspendReinstate_form.select.disabled = false;
		parent.f_query_add_mod_criteria.SuspendReinstate_form.uom_desc.value = return_val[15];
	}
	var formObj = document.SuspendReinstate_form;
	var formObj = document.SuspendReinstate_form;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null),"text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?item_code=" + form.item_code.value + "&function_type=5", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	document.SuspendReinstate_form.manufacturer.focus();
	eval(responseText);
	if (!result) {
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?";//err_num="+ getMessage(message);
	}
}
function callValidatepage(temp_jsp, xmlStr) {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
}
function displayResult() {
	frmObject = parent.f_query_add_mod_criteria.SuspendReinstate_form;
	//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  01-AUG-2013 Starts
	//var trn_across_facility_yn = frmObject.trn_across_facility_yn.value;
	//if(trn_across_facility_yn == "Y"){
	if(frmObject.selectAll.value == "N" && frmObject.store_code.value == ""){
	alert(getMessage("CHOOSE_SPECIFIC_STORE", "ST"));
	frmObject.store_code.focus();
	return;
	}
	//}
	//ends
	var xmlStr = getEnhancedXMLString(frmObject);
	tempJsp = "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?function_type=1";
	callValidatepage(tempJsp, xmlStr);
	parent.f_query_add_mod_result.location.href = "../../eST/jsp/SuspendOrReinstateBatchAddModify.jsp?mode=" + MODE_INSERT + "&item_desc=" + escape(frmObject.item_desc.value) + "&uom_desc=" + escape(frmObject.uom_desc.value);
}
function activeLink() {
	formObj = parent.f_query_add_mod_result;
	if (formObj.SuspendOrReinstate_Detail.start.value != 0) {
		formObj.document.getElementById('prev').style.display = "block";
	} else {
		formObj.document.getElementById('prev').style.display = "none";
	}
	if (!((parseInt(formObj.start.value) + parseInt(formObj.displaySize.value)) >= formObj.totalRecords.value)) {
		formObj.document.getElementById('next').style.display = "block";
	} else {
		formObj.document.getElementById('next').style.display = "none";
	}
}

function goNext() {
	formObj = parent.f_query_add_mod_result.SuspendOrReinstate_Detail;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	for (var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].type == "checkbox") {
			if (formObj.elements[i].checked) {
				formObj.elements[i].value = "Y";
			} else {
				formObj.elements[i].value = "N";
			}
		}
	}
	var xmlStr = getEnhancedXMLString(formObj);
	tempJsp = "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?function_type=2";
	callValidatepage(tempJsp, xmlStr);
	var formObjCriteria = parent.f_query_add_mod_criteria.SuspendReinstate_form;
	parent.f_query_add_mod_result.location.href = "../../eST/jsp/SuspendOrReinstateBatchAddModify.jsp?item_code=" + formObjCriteria.item_code.value + "&mode=" + MODE_INSERT + "&from=" + start + "&to=" + end;
}
function goPrev() {
	formObj = parent.f_query_add_mod_result.SuspendOrReinstate_Detail;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	for (var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].type == "checkbox") {
			if (formObj.elements[i].checked) {
				formObj.elements[i].value = "Y";
			} else {
				formObj.elements[i].value = "N";
			}
		}
	}
	var xmlStr = getEnhancedXMLString(formObj);
	tempJsp = "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?function_type=2";
	callValidatepage(tempJsp, xmlStr);
	var formObjCriteria = parent.f_query_add_mod_criteria.SuspendReinstate_form;
	parent.f_query_add_mod_result.location.href = "../../eST/jsp/SuspendOrReinstateBatchAddModify.jsp?item_code=" + formObjCriteria.item_code.value + "&mode=" + MODE_INSERT + "&from=" + start + "&to=" + end;
}
function assignValue(obj) {
	if (obj.checked) {
		obj.value = "Y";
	} else {
		obj.value = "N";
	}
}
function changeStatusCheckBox(obj) {
	formObj = parent.f_query_add_mod_result.SuspendOrReinstate_Detail;
	for (var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].type == "checkbox") {
			if (obj.checked) {
				formObj.elements[i].value = "Y";
				formObj.elements[i].checked = true;
			} else {
				formObj.elements[i].value = "N";
				formObj.elements[i].checked = false;
			}
		}
	}
}
function loadBlank() {
	parent.f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
}
async function showReason(trObj, index) {
	changeRowColor(trObj, 10);
	var item_code = parent.f_query_add_mod_criteria.SuspendReinstate_form.item_code.value;
	var remarks_for = parent.f_query_add_mod_criteria.SuspendReinstate_form.Batch.value;
	var batch_id = trObj.cells[0].innerText;
	var expiry_date = trObj.cells[1].innerText;
	//var flag			  =		parent.f_query_add_mod_result.SuspendOrReinstate_Detail.flag.value;
	if (eval("document.SuspendOrReinstate_Detail.checkbox" + index + ".checked")) {
		//retVal = window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchRemarks.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&remarks_for=" + remarks_for, "", "dialogHeight:15; dialogWidth:40; center:0; status: no; dialogLeft :75; dialogTop :250;");
		
		//Added by Rabbani #inc no:39809 on 15-MAY-2013
		retVal = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchRemarks.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&batch_id=" + encodeURIComponent(batch_id,"UTF-8") + "&expiry_date=" + expiry_date + "&remarks_for=" + remarks_for, "", "dialogHeight:40vh; dialogWidth:60vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
	}
}
async function showHistory(trObj, index) {
	changeRowColor(trObj, 10);
	var item_code = parent.f_query_add_mod_criteria.SuspendReinstate_form.item_code.value;
	var item_desc = parent.f_query_add_mod_criteria.SuspendReinstate_form.item_desc.value;
	var uom_desc = parent.f_query_add_mod_criteria.document.getElementById('uom').innerHTML;
	var batch_id = trObj.cells[0].innerText;
	var expiry_date = trObj.cells[1].innerText;
	var trade_name = trObj.cells[2].innerText;
	var manufacturer_name = trObj.cells[3].innerText;
			/**
			* @Name - Priya 
			* @Date - 21/12/2009
			* @Inc# - IN017176
			* @Desc - To Display the character ® properly in Item desc without junck characters
			* added 'encodeURIComponent(item_desc,"UTF-8")' in the next line code
			*/
	//retVal = window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&batch_id=" + batch_id + "&expiry_date=" + expiry_date + "&trade_name=" + trade_name + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30; dialogWidth:55; center:0; status: no; dialogLeft :75; dialogTop :250;");
	
	//Added by Rabbani #inc no:39809 on 15-MAY-2013
	//retVal = window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&batch_id=" + encodeURIComponent(batch_id,"UTF-8") + "&expiry_date=" + expiry_date + "&trade_name=" + encodeURIComponent(trade_name,"UTF-8") + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:30; dialogWidth:55; center:0; status: no; dialogLeft :75; dialogTop :250;");
	retVal = await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchHistory.jsp?function_id=" + parent.parent.function_id + "&item_code=" + item_code + "&batch_id=" + encodeURIComponent(batch_id,"UTF-8") + "&expiry_date=" + expiry_date + "&trade_name=" + encodeURIComponent(trade_name,"UTF-8") + "&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&uom_desc=" + escape(uom_desc) + "&manufacturer_name=" + escape(manufacturer_name), "", "dialogHeight:75vh; dialogWidth:75vw; center:0; status: no; dialogLeft :75; dialogTop :250;");
}
function ChangeLabel(obj) {
	if (document.SuspendReinstate_form.include_complained_items.disabled == true) {
		document.SuspendReinstate_form.include_complained_items.disabled = false;
	}
	document.SuspendReinstate_form.include_complained_items.checked = false;
	if (obj.value == "R") {
		document.getElementById('label_complained').innerText = getLabel("eST.IncludeNotifiedBatches.label", "ST");
		document.getElementById('tb1').style.visibility = "visible";
	}
	if (obj.value == "C") {
		document.SuspendReinstate_form.include_complained_items.checked = true;
		document.getElementById('label_complained').innerText = getLabel("eST.IncludeNotifiedBatches.label", "ST");
	}
	if (obj.value == "S") {
		document.getElementById('label_complained').innerText = getLabel("eST.OnlyNotifiedBatches.label", "ST");
		document.getElementById('tb1').style.visibility = "visible";
	}
}
function setValue() {
	if (document.SuspendReinstate_form.include_complained_items.checked == true) {
		document.SuspendReinstate_form.include_complained_items.value = "Y";
	} else {
		document.SuspendReinstate_form.include_complained_items.value = "N";
	}
}
function updateRemarks() {
	formObject = document.formSuspendOrReinstateRemarks;
	//document.formSuspendOrReinstateRemarks.flag1.value=true;
	
	if (!setTextAreaMaxLength(formObject.remarks, 201)) {
		//alert(getMessage("REMARKS_NOT_EXCEED_200_CH", "ST")); //Commented and Added for 041818 
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$","Remarks");
		msg = msg.replace("#",200);		
		alert(msg);
		return;
	}
		
	if (!setTextAreaMaxLength(formObject.profile, 201)) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$","Profile");
		msg = msg.replace("#",200);		
		alert(msg);
		return;
	}
	
	
	if (!checkField(formObject.remarks, getLabel("Common.remarks.label", "Common"))) {
		return;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getEnhancedXMLString(formObject);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SuspendOrReinstateBatchValidate.jsp?function_type=3", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	window.close();
}
function changeMyRowColor(index, n, chkObj) {
	var trObj = eval(document.getElementById('tr_' + index));
	if (chkObj.checked) {
		classValue = "DATACHANGE";
	} else {
		if (index % 2 == 0) {
			classValue = "OAQRYEVEN";
		} else {
			classValue = "OAQRYODD";
		}
	}
	for (k = 0; k < n; k++) {
		trObj.cells[k].className = classValue;
	}
}
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		obj.cells[k].className = "STLIGHTPINK";
	}
}
function processScroll()
	{
		
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
				
			}
			else{
				FloatHead.style.top = '0px';
				
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
			
			FloatHead.style.position = "relative";
			
		}
	}
	
	//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  01-AUG-2013 Starts -->
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
	dataValueArray[1] = document.forms[0].dflt_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById('SQL_ST_STORE_LOOKUP').value;
	//var sql = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id   LIKE ?  	 	  AND    UPPER(st.store_code)    LIKE	 UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code   ORDER BY 2";
	//argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[0]="";
		arr[1]="";
		}
		obj.value = arr[0];
	}
}
async function DisplayBatchDetails(trObj){
var formObj = document.SuspendOrReinstate_Detail.value;
var batch_id     = trObj.cells[0].innerText;
var  expiry_date = trObj.cells[1].innerText;
//var item_desc    = trObj.cells[9].innerText;
var item_desc    = trObj.cells[10].innerText;

await window.showModalDialog("../../eST/jsp/SuspendOrReinstateBatchDetails.jsp?function_id=" + parent.parent.function_id+"&item_desc=" + encodeURIComponent(item_desc,"UTF-8") + "&expiry_date=" + expiry_date + "&batch_id="+ encodeURIComponent(batch_id,"UTF-8") , "",  "dialogHeight:75vh; dialogWidth:75vw; center:0; status: no; dialogLeft :30; dialogTop :250;");
}

function toggleCheck(obj){
var formobj = document.SuspendReinstate_form;
if(obj.checked){
formobj.store_code.disabled = true;
formobj.p_to_sr2.disabled = true;
formobj.selectAll.value = "Y";
formobj.store_code.value = "";
formobj.store_code.value = "";
}else{
formobj.store_code.disabled = false;
formobj.p_to_sr2.disabled = false;
formobj.selectAll.value = "N";
}
}
//ends


