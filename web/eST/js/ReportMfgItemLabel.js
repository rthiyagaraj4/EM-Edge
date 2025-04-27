
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	f_query_add_mod_sub.location.reload();
}
function loadPage() {
	if (document.formMfgItemLabelMain.summary_code.value == "") {
		parent.f_query_add_mod_sub.document.location.href = "../../eCommon/html/blank.html";
	} else {
		parent.f_query_add_mod_sub.document.location.href = "../../eST/jsp/ReportMfgItemLabelCriteria.jsp?sum_code=" + document.getElementById("summary_code").value;
	}
}
async function searchCodeStore(obj) {
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
	argumentArray[0] = document.forms[0].SQL_ST_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
	{
 		arr[0]="";	
 		arr[1]="";	
	}
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = arr[0];
	}
}
function run() {
	/*if(f_query_add_mod_sub.document.MfgItemLabelCriteria)
	{
	var formObj= f_query_add_mod_sub.document.MfgItemLabelCriteria;
	
	var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_no_labels,formObj.p_label_type);
	var names = new Array("Doc Type","No.of Copies","Label type");
	
	var blankObject = getBlankField(arrayObject, names, messageFrame);
	if (blankObject==null) 
		{
		formObj.submit();
		}
	else
		{
		blankObject.focus();
		}
}*/
}
function ChangeReport(formObj) {
	if ((formObj.Report_type.value == "A") && (formObj.p_label_type.value == "A")) {
		formObj.p_report_id.value = "STBMFGLB";
	} else {
		if ((formObj.Report_type.value == "A") && (formObj.p_label_type.value == "B")) {
			formObj.p_report_id.value = "STBMFGLS";
		} else {
			if ((formObj.Report_type.value == "B") && (formObj.p_label_type.value == "A")) {
			//alert(formObj.p_report_id.value);
				formObj.p_report_id.value = "STBREPLB";
			}else{
			  if ((formObj.Report_type.value == "C") && (formObj.p_label_type.value == "A")) {
			  //alert(formObj.p_report_id.value);
				formObj.p_report_id.value = "STBREPLB1";
			}
			}
		}
	}
	/*else
		{
			formObj.p_report_id.value="STBREPLS";
		}*/
}

//added here on 11/24/2005
function callResultPage() {
	var formObj = document.MfgItemLabelCriteria;
	var locale = formObj.p_language_id.value;
	var dt_from = convertDate(formObj.p_fr_doc_date.value, "DMY", locale, "en");
	var dt_to = convertDate(formObj.p_to_doc_date.value, "DMY", locale, "en");
//	var dt_from	=	formObj.p_fr_doc_date.value;
//	var dt_to	=	formObj.p_to_doc_date.value;
	var store_code = formObj.store_code.value;
	var p_doc_type_code = formObj.p_doc_type_code.value;
	var p_doc_no = formObj.p_doc_no.value;
	var p_no_labels = formObj.p_no_labels.value;
	var p_label_type = formObj.p_label_type.value;
	var Report_type = formObj.Report_type.value;
	if (dt_from != "" && dt_to != "") {
		if (!doDateCheck(formObj.p_fr_doc_date, formObj.p_to_doc_date, parent.messageFrame)) {
			formObj.p_fr_doc_date.select();
			formObj.p_fr_doc_date.focus();
			return;
		}
	}
	if (formObj.p_no_labels.value != "") {
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
	if (formObj.p_doc_type_code.value != "") {
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
	var arrayObject = new Array(formObj.p_doc_type_code, formObj.p_no_labels);
	var names = new Array(getLabel("Common.DocType.label", "Common"), getLabel("eST.NoofCopies.label", "ST"));
//	var blankObject = getBlankField(arrayObject, names, parent.messageFrame);
	var blankObject = checkSTFields(arrayObject, names, parent.messageFrame);
	if (blankObject != true) {
	//	blankObject.focus();
		return;
	} else {
		parent.f_query_add_mod_result.location.href = "../../eST/jsp/ReportMfgItemLabelResult.jsp?Report_type=" + Report_type + "&p_label_type=" + p_label_type + "&p_no_labels=" + p_no_labels + "&p_doc_type_code=" + p_doc_type_code + "&store_code=" + store_code + "&p_doc_no=" + p_doc_no + "&dt_from=" + dt_from + "&dt_to=" + dt_to;
	}
}
function callReport(doc_type_code, doc_no, store_code) {
	var formObj = parent.f_query_add_mod_sub.document.MfgItemLabelCriteria;
	ChangeReport(formObj);
	formObj.p_doc_no.value = doc_no;
	formObj.p_doc_type_code.value = doc_type_code;
	formObj.store_code.value = store_code;
	formObj.submit();
	/*var result = confirmPrintView();
	if (result == "Yes") {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/ReportMfgItemLabelValidate.jsp?docno=" + doc_no + "&doc_type_code=" + doc_type_code + "&store_code=" + store_code + "&report_id=" + formObj.p_report_id.value + "&nooflabels=" + formObj.p_no_labels.value, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			alert(getMessage("REPORT_SUBMITTED", "ST"));
		}
	} else {
		if (result == "No") {
			formObj.submit();
		//formObj.p_doc_no.value	= "";
		//formObj.p_doc_type_code.value = "";
		}
	}*/
}
//ended
function setChangeReport() {
	if (document.MfgItemLabelCriteria.Report_type.value == "A") {
		document.MfgItemLabelCriteria.p_report_id.value = "STBMFGLB";
		parent.f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
	}
	if (document.MfgItemLabelCriteria.Report_type.value == "B") {
		document.MfgItemLabelCriteria.p_report_id.value = "STBREPLB";
		parent.f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
	}
	if (document.MfgItemLabelCriteria.Report_type.value == "C") {
		document.MfgItemLabelCriteria.p_report_id.value = "STBREPLB1";
		parent.f_query_add_mod_result.location.href = "../../eCommon/html/blank.html";
	}
	
}

