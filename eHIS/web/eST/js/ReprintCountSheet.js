
var flag = true;
var count = 1;
function reset() {
	f_query_add_mod.location.reload();
}
function run() {
	var formObj = f_query_add_mod.document.forms[0];
	var fields = new Array(formObj.p_PHY_INV_ID);
	var names = new Array(getLabel("eST.PhyInventoryID.label", "ST"));
	var errorPage = "../../eCommon/jsp/error.jsp";
	var blankObj = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		if (f_query_add_mod.document.formReprintCountSheetReportCriteria.p_report_id.disabled = true) {
			f_query_add_mod.document.formReprintCountSheetReportCriteria.p_report_id.disabled = false;
		}
		formObj.submit();
	}
}
function loadRepType() {
	document.formReprintCountSheetReportCriteria.p_report_id.disabled = true;
}
function getDateValue(p_PHY_INV_ID) {
	var phy_id = document.formReprintCountSheetReportCriteria.p_PHY_INV_ID.value;
	var formObj = document.formReprintCountSheetReportCriteria;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlStr = getXMLString(null);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReprintCountSheetStoreValidate.jsp?phy_id=" + phy_id, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
	//return responseText;
}
function setDateValue(_date_value) {
	var details = new Array();
	details = _date_value.split(",");
	var _date_value = details[0];
	var _rep_type = details[1];
	if (_date_value == null || _date_value == "") {
		document.formReprintCountSheetReportCriteria.count_date.value = "";
	} else {
		document.formReprintCountSheetReportCriteria.count_date.value = _date_value;
		document.formReprintCountSheetReportCriteria.count_date.disabled = true;
	}
	if (_rep_type == "A") {
		document.formReprintCountSheetReportCriteria.p_report_id.disabled = true;
	} else {
		document.formReprintCountSheetReportCriteria.p_report_id.disabled = false;
	}
}

