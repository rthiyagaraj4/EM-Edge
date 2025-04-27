
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj = null;
function create() {
	f_query_add_mod.location.href = "../../ePO/jsp/FacilityForPurchaseUnitMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	} else {
		if (f_query_add_mod.FacilityForPurchaseUnitHeaderFrame.document.formFacilityForPurchaseUnitHeader != null) {
			f_query_add_mod.location.reload();
		} else {
			clearDetails();
		}
	}
}
function clearDetails() {
	f_query_add_mod.FacilityForPurchaseUnitListFrame.location.href = "../../eCommon/html/blank.html";
}
function searchCode(target) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.forms[0].SQL_PO_PURCHASE_UNIT_LOOKUP.value ;
	
	if (target.name == "purchase_unit") {
		argumentArray[0] = sql;
		argumentArray[4] = "1,2"; 
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = target.value;
 	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	
	if (target.name == "purchase_unit") {
		if (!document.forms[0].purchase_unit.readOnly) {
			retVal = CommonLookup(getLabel("ePO.PurchaseUnit.label", "PO"), argumentArray);
		} else {
			retVal = "";
		}
	}
	
	if (retVal != null && retVal != "") {
		target.value = retVal[1];
		if (target.name == "purchase_unit") {
			document.forms[0].pur_ut_id.value = retVal[0];
			document.forms[0].purchase_unit.readOnly = true;
			document.forms[0].pur_ut_id.disabled = true;
		}	
	}
}
function searchDetails() {

	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = parent.FacilityForPurchaseUnitHeaderFrame.document.forms[0];
	var errorPage = "../../eCommon/jsp/error.jsp";
	var pur_unit_id = formObj.pur_ut_id.value;
	if (pur_unit_id == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("PURCHASE_UNIT_SEARCH_MANDATORY", "PO");
		return;
	}
	
	var messageFrame = top.content.messageFrame;
	var fields = new Array(formObj.purchase_unit);
	var names = new Array(getLabel("eST.PurchaseUnit.label", "ST"));
	var blankObject = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		parent.FacilityForPurchaseUnitListFrame.location.href = "../../ePO/jsp/FacilityForPurchaseUnitDetails.jsp?pur_unit_id=" + pur_unit_id + "&mode=" + MODE_INSERT;
		
	}
}


function apply() {
	var errorPage = "../../eCommon/jsp/error.jsp";
	if (f_query_add_mod.FacilityForPurchaseUnitHeaderFrame == null) {
		messageFrame.location.href = errorPage + "?err_num=";
		return;
	}
	var fields = new Array(f_query_add_mod.FacilityForPurchaseUnitHeaderFrame.document.formFacilityForPurchaseUnitHeader.pur_ut_id);
	var names = new Array(getLabel("ePO.PurchaseUnit.label", "PO"));
	var blankObj = null;
	blankObject = checkPOFields(fields, names, messageFrame, errorPage);
	if (blankObject != true) {
	
		return;
	}
	if (!f_query_add_mod.FacilityForPurchaseUnitHeaderFrame.document.formFacilityForPurchaseUnitHeader.pur_ut_id.disabled) {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_RECORD_AVB", "PO");
		return;
	}
	var formObj = f_query_add_mod.FacilityForPurchaseUnitListFrame.document.FacilityForPurchaseUnitListForm;
	
	if(formObj != undefined){
	formObj.total_facility_id.value = f_query_add_mod.FacilityForPurchaseUnitHeaderFrame.document.formFacilityForPurchaseUnitHeader.total_count_flag.value;
	var total_facility_id = formObj.total_facility_id.value;
	var chkdValue = 0;
	for (count = 0; count < total_facility_id; count++) {
		if (eval("formObj.facility_id_" + count) != null && eval("formObj.facility_id_" + count + ".checked")) {
			chkdValue++;
		}
	}
	formObj.canProcess.value = chkdValue;
	if (parseFloat(formObj.canProcess.value) <= 0 && formObj.PreviousListValueExit.value == "N") {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		return;
	}
	eval(formApply(formObj, PO_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	if (result) {
		onSuccess();
	}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + getMessage("NO_CHANGES_TO_SAVE", "PO") ; 
		return;
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function gettotalcheckBoxes(facility_id_count) {
	if (parseInt(parent.frames[0].document.formFacilityForPurchaseUnitHeader.total_count_flag.value) == 0) {
		parent.frames[0].document.formFacilityForPurchaseUnitHeader.total_count_flag.value = parseInt(facility_id_count.value);
	} else {
		parent.frames[0].document.formFacilityForPurchaseUnitHeader.total_count_flag.value = parseInt(parent.frames[0].document.formFacilityForPurchaseUnitHeader.total_count_flag.value) + parseInt(facility_id_count.value);
	}
}

function SubmitLink(from, to) {
	if (document.FacilityForPurchaseUnitListForm == null) {
		document.QueryForm.from.value = from;
		document.QueryForm.to.value = to;
		document.QueryForm.submit();
		return;
	}
	var selectedIndices = "";
	var index = 0;
	var total_facility_id = document.FacilityForPurchaseUnitListForm.total_facility_id.value;
	var arrayObject = new Array();
	window.returnValue = false;
	for (count = 0; count < total_facility_id; count++) {
		arrayObject[index++] = eval("document.FacilityForPurchaseUnitListForm.remove_facility_id_" + count);
		if (eval("document.FacilityForPurchaseUnitListForm.facility_id_" + count) != null && eval("document.FacilityForPurchaseUnitListForm.facility_id_" + count + ".checked")) {
			window.returnValue = true;
			arrayObject[index++] = eval("document.FacilityForPurchaseUnitListForm.facility_id_" + count);
		}
	}
	assignBean(document.FacilityForPurchaseUnitListForm);
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePO/jsp/FacilityForPurchaseUnitValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	//alert(responseText);
	eval(responseText);
	document.QueryForm.from.value = from;
	document.QueryForm.to.value = to;
	document.QueryForm.submit();
}
function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom = new ActiveXObject("Microsoft.XMLDom");
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

var cnt = 0;
function checkPUGlobal(global_unit_yn,i,obj,count){
	var formObj = document.FacilityForPurchaseUnitListForm;
	if(obj.checked){
		cnt++;
	}else{
		if(cnt >0)
			cnt--;
		formObj.PreviousListValueExit.value = "N";
	}
	if(global_unit_yn == "N" && (count > 0 || cnt > 1 || formObj.PreviousListValueExit.value == "Y")){
	//	alert("This Purchase Unit is not 'Global' and hence only One Facility can be linked.");
	alert(getMessage("PUR_UNIT_NOT_GLOBAL","PO"));  
	
		if(cnt >0)
			cnt--;
		eval("document.FacilityForPurchaseUnitListForm.facility_id_" + i+ ".checked = false" ) ;
		return;
	}
}
	
	
