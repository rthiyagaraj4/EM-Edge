function reset() {
	f_query_add_mod.location.reload();
f_query_result.document.location.href="../../eCommon/html/blank.html";
}





function setTrnType(obj){
	if(obj==null)
	obj = document.formTrnAuditTrail.trn_type;
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TRNTYPE&trn_type="+obj.value, false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
	
}
async function searchCode(target) {
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.formTrnAuditTrail.SQL_ST_DELETED_BY_USER.value + "'" + document.formTrnAuditTrail.language_id.value + "'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		target.value=arr[1];
		document.formTrnAuditTrail.deleted_by_id.value = arr[0];
	}
	/*if (retVal != null && retVal != "" &&  retVal != undefined) {
		target.value = retVal[1];
		document.formTrnAuditTrail.deleted_by_id.value = retVal[0];
		
		} */
	}

	function checkSysdate(receiptdate, sysdate,sel) {
	var errorPage = "../../eCommon/jsp/error.jsp";
	var arrayObject = new Array(document.formTrnAuditTrail.doc_date_from);
	if(receiptdate.value!=""){
		var flag = ChkDate(receiptdate);
		if (!flag) {

		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

		if (flag) {
			if(sel=="Y")
			if (checkdateWithSysDatefrom(receiptdate, sysdate)) {
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("FRM_DOC_DATE_NOT_LESS_SYSDATE","ST");
			return false;
						
			}
			if(sel=="N")
			if (checkdateWithSysDate(receiptdate, sysdate)) {
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE", "ST");
			return false;
			}
		}
	}
}

function checkdateWithSysDate(entered_date, sys_date) {
	/*Entered Date Should not be less than sysdate Krishna 1/13/2009*/
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

function checkdateWithSysDatefrom(entered_date, sys_date) {
	/*Entered Date Should not be less than sysdate Krishna 1/13/2009*/
	var enteredDateArray;
	var sysDateArray;
	var enteredDate = entered_date.value;
	var sysDate = sys_date.value;
	if (enteredDate.length > 0 && sysDate.length > 0) {
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2], (enteredDateArray[1] - 1), enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2], (sysDateArray[1] - 1), sysDateArray[0]);
		if (Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) {
				
			return false;
		} else {
			if (Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
				return true;
			}
		}
	}
	return true;
}

function searchDeletedDocsAuditLog(){
parent.f_query_result.document.location.href="../../eCommon/html/blank.html";
parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
var from_doc_date=document.formTrnAuditTrail.doc_date_from ;
var to_doc_date=document.formTrnAuditTrail.doc_date_to ;
var sysdate=document.formTrnAuditTrail.sysdate ;
var errorPage = "../../eCommon/jsp/error.jsp";
var arrayObject = new Array(document.formTrnAuditTrail.doc_date_from);
var names = new Array(getLabel("eST.DocDateFrom.label", "ST"));
var blankObject = checkSTFields(arrayObject, names, parent.messageFrame, errorPage);
	if (blankObject != true) {
		return;
	}

var flag_fm=false;
var flag_to=false;
if(to_doc_date.value==""){
	flag_to=true;
}else{
flag_to=checkSysdate(to_doc_date,from_doc_date,"N");
}
flag_fm=checkSysdate(from_doc_date,sysdate,"Y");

if(flag_fm!=false && flag_to!=false){
var formobj=document.formTrnAuditTrail;
parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=new&from=0&to=14";
}
}

function submitPrevNext(from, to){
	document.formTrnAuditTrialResult.from.value = from;
	document.formTrnAuditTrialResult.to.value = to; 
	document.formTrnAuditTrialResult.submit();
	
}





function changeOrder(order,header) {
var formobj=document.formTrnAuditTrialResult;
	
if(header=="TT"){

document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.TTorder.value="DESC";
document.getElementById("TT").src="../../eST/images/Descending.gif";
document.getElementById("TT").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=TRN_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=TRN_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("TT").style.visibility = "visible";	
document.formTrnAuditTrialResult.TTorder.value="ASC";
document.getElementById("TT").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("TT").style.visibility = "visible";
document.formTrnAuditTrialResult.TTorder.value="DESC";
document.getElementById("TT").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=TRN_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="DT"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.DTorder.value="DESC";
document.getElementById("DT").src="../../eST/images/Descending.gif";
document.getElementById("DT").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DOC_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=TRN_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("DT").style.visibility = "visible";	
document.formTrnAuditTrialResult.DTorder.value="ASC";
document.getElementById("DT").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("DT").style.visibility = "visible";
document.formTrnAuditTrialResult.DTorder.value="DESC";
document.getElementById("DT").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=TRN_DESC", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="DN"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.DNorder.value="DESC";
document.getElementById("DN").src="../../eST/images/Descending.gif";
document.getElementById("DN").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DOC_NO", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=DOC_NO", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("DN").style.visibility = "visible";	
document.formTrnAuditTrialResult.DNorder.value="ASC";
document.getElementById("DN").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("DT").style.visibility = "visible";
document.formTrnAuditTrialResult.DTorder.value="DESC";
document.getElementById("DT").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DOC_NO", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="DD"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.DDorder.value="DESC";
document.getElementById("DD").src="../../eST/images/Descending.gif";
document.getElementById("DD").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DOC_DATE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=DOC_DATE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("DD").style.visibility = "visible";	
document.formTrnAuditTrialResult.DDorder.value="ASC";
document.getElementById("DD").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("DD").style.visibility = "visible";
document.formTrnAuditTrialResult.DDorder.value="DESC";
document.getElementById("DD").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DOC_DATE", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="CB"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.CBorder.value="DESC";
document.getElementById("CB").src="../../eST/images/Descending.gif";
document.getElementById("CB").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=CREATED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=CREATED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("CB").style.visibility = "visible";	
document.formTrnAuditTrialResult.CBorder.value="ASC";
document.getElementById("CB").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("CB").style.visibility = "visible";
document.formTrnAuditTrialResult.CBorder.value="DESC";
document.getElementById("CB").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=CREATED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="DB"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DDT").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DTTorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.DBorder.value="DESC";
document.getElementById("DB").src="../../eST/images/Descending.gif";
document.getElementById("DB").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DELETED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=DELETED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("DB").style.visibility = "visible";	
document.formTrnAuditTrialResult.DBorder.value="ASC";
document.getElementById("DB").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("DB").style.visibility = "visible";
document.formTrnAuditTrialResult.DBorder.value="DESC";
document.getElementById("DB").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DELETED_BY", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}else if(header=="DDT"){

document.getElementById("TT").style.visibility = "hidden";
document.getElementById("DT").style.visibility = "hidden";
document.getElementById("DN").style.visibility = "hidden";
document.getElementById("DD").style.visibility = "hidden";
document.getElementById("CB").style.visibility = "hidden";
document.getElementById("DB").style.visibility = "hidden";
document.formTrnAuditTrialResult.TTorder.value="";
document.formTrnAuditTrialResult.DTorder.value="";
document.formTrnAuditTrialResult.DNorder.value="";
document.formTrnAuditTrialResult.DDorder.value="";
document.formTrnAuditTrialResult.CBorder.value="";
document.formTrnAuditTrialResult.DBorder.value="";

if(order.value==""){
document.formTrnAuditTrialResult.DTTorder.value="DESC";
document.getElementById("DDT").src="../../eST/images/Descending.gif";
document.getElementById("DDT").style.visibility = "visible";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DELETED_DATE_TIME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";

}else if(order.value=="DESC"){

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=ASC&header=DELETED_DATE_TIME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=ASC";

document.getElementById("DDT").style.visibility = "visible";	
document.formTrnAuditTrialResult.DTTorder.value="ASC";
document.getElementById("DDT").src="../../eST/images/Ascending.gif";
}else if(order.value=="ASC"){
document.getElementById("DDT").style.visibility = "visible";
document.formTrnAuditTrialResult.DTTorder.value="DESC";
document.getElementById("DDT").src="../../eST/images/Descending.gif";
var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/TrnAuditTrailValidate.jsp?validate=TTORDER&TTorder=DESC&header=DELETED_DATE_TIME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	parent.f_query_result.document.location.href = "TrnAuditTrailQueryResult.jsp?trn_type="+formobj.trn_type.value+"&doc_type_code="+formobj.doc_type_code.value+"&doc_no="+formobj.doc_no.value+"&doc_date_from="+formobj.doc_date_from.value+"&doc_date_to="+formobj.doc_date_to.value+"&deleted_by_id="+formobj.deleted_by_id.value +"&search=&from="+	document.formTrnAuditTrialResult.from.value+"&to="+	document.formTrnAuditTrialResult.to.value+"&header="+header+"&order=DESC";
}
}
}





