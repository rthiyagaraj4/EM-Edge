
var flag = true;
var count = 1;
function reset() {
		frames[1].document.forms[0].reset();
	    frames[2].location.href = "../../eCommon/html/blank.html";
}
function run() {
	var formObj = f_query_add_mod.document.forms[0];
//	var fields = new Array(formObj.p_PHY_INV_ID);
//	var names = new Array(getLabel("eST.PhyInventoryID.label", "ST"));
//	var errorPage = "../../eCommon/jsp/error.jsp";
//	var blankObj = null;
//	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	//if (blankObject == true) {
	//	if (f_query_add_mod.document.formReprintCountSheetReportCriteria.p_report_id.disabled = true) {
	//		f_query_add_mod.document.formReprintCountSheetReportCriteria.p_report_id.disabled = false;
	//	}
		formObj.submit();
	//}
}
function loadRepType() {
	document.formReprintCountSheetReportCriteria.p_report_id.disabled = true;
}
function searchDetails() {
	var phy_id = document.formReprintCountSheetReportCriteria.p_PHY_INV_ID.value;
	var cnt_date = document.formReprintCountSheetReportCriteria.count_date.value;
	//var p_store_gr = document.formReprintCountSheetReportCriteria.p_store_gr.value;
	var p_st_code = document.formReprintCountSheetReportCriteria.p_st_code.value;
	var p_item_desc = document.formReprintCountSheetReportCriteria.p_item_desc.value;
	var p_item_code = document.formReprintCountSheetReportCriteria.p_item_code.value;
	var p_created_By = document.formReprintCountSheetReportCriteria.p_created_By.value;
	var p_report_id = document.formReprintCountSheetReportCriteria.p_report_id.value;

	parent.frames[2].location.href="../../eST/jsp/SRRReprintCountSheetReportResult.jsp?phy_id="+phy_id+"&cnt_date="+cnt_date+"&p_st_code="+p_st_code+"&p_item_desc="+p_item_desc+"&p_item_code="+p_item_code+"&p_created_By="+p_created_By+"&p_report_id="+p_report_id;

/*	var formObj = document.formReprintCountSheetReportCriteria;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SRRReprintCountSheetReportResult.jsp?phy_id=" + phy_id + "& cnt_date= "+cnt_date+"& p_store_gr= "+p_store_gr +"& p_st_code ="+p_st_code +"& p_item_desc ="+p_item_desc + "& p_item_code ="+p_item_code +"& p_created_By="+p_created_By+ " & p_report_id="+p_report_id , false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText); */
}
function getDateValue(p_PHY_INV_ID) {
	var phy_id = document.formReprintCountSheetReportCriteria.p_PHY_INV_ID.value;
	var formObj = document.formReprintCountSheetReportCriteria;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SRRReprintCountSheetStoreValidate.jsp?phy_id=" + phy_id, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
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

function searchCodeItem(obj) {

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
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formReprintCountSheetReportCriteria.p_item_desc.value=returnedValues[1];
		document.formReprintCountSheetReportCriteria.p_item_code.value=returnedValues[0];

		

	}
}

function schduleCreatedByLookup(target) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.getElementById("SQL_ST_USER_LOOKUP_USERACCESS").value + "'" + document.formReprintCountSheetReportCriteria.p_language_id.value + "'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(getLabel("Common.Createdby.label", "common"), argumentArray);

	if (retVal != null && retVal != "" && retVal!=undefined) {
		target.value = retVal[1];
		//document.formReprintCountSheetReportCriteria.p_created_By.value = retVal[1];
		document.formReprintCountSheetReportCriteria.p_created_By.value =retVal[0];
		
		
	}
}
function searchCodeStore(obj) {
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
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function callReport(phy_inv_id) {
		var formObj	=  parent.f_query_add_mod.document.forms[0];
		formObj.p_PHY_INV_ID.value	=	phy_inv_id;
		formObj.submit();

}

