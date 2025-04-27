var headTop = -1;
var FloatHead;
var FloatHead1;
function reset() {
	f_query_add_mod.location.reload();
}
async function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.forms[0].SQL_ST_STORE_LOOKUP.value + "'" + localeName + "'" + "  ORDER BY 2";
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}

	async function searchItemCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = localeName;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.forms[0].item_code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
	
	async function searchPatient() {
	var patient_id = await PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	getPatientName(patient_id);
}
	function searchpatientName(formObj) {
	var patientid = formObj.patient_id.value;
	if (!(patientid == null || patientid == "")) {
		getPatientName(patientid);
	}else{
		setPatientName("","");
	}
}
	function getPatientName(_patient_id) {
	var formObj = document.documentformSalesAndReturnHistoryQueryCriteria;
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesAndReturnHistoryValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
	function setPatientName(_patient_name,_patient_nationality) {
	if (_patient_name == null || _patient_name == "" || _patient_name.toLowerCase() =='null') {
		document.getElementById("patient_name").innerText = "";
	} else {
		document.getElementById("patient_name").innerText = _patient_name;
	}
	document.getElementById("patient_nation").innerText = _patient_nationality;
}
	

function checkDate(formObj) {
	
    //Added for AMS-CRF-0258 - Start
	var Sysdate = formObj.sysdate.value;
	var locale = formObj.locale.value;
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	
	if(locale!='en')
	   Sysdate = convertDate(Sysdate,'DMY',"en",locale); 
	
	if(formObj.from_date.value==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		formObj.from_date.focus();
		return;
	}
	
	if(formObj.to_date.value != "" ){
		if(!isBefore(to_date,Sysdate,"DMY",locale) )
			{			
				alert(getMessage("TO_DATE_NOT_GREATER_SYSDATE", "ST"));
				return ;	
			}
	}
	if(formObj.to_date.value=="")
	{
		to_date=Sysdate;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesAndReturnHistoryValidate.jsp?from_date="+from_date+"&to_date="+to_date+"&validate=CHECK_SYS_DATE", false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	eval(responseText);
	if(result){
	   //commented by Rabbani #Inc no:36887 on  20/12/2012
		/*if(formObj.patient_id.value==""){
			alert("Patient ID Cannot Be Blank");
			formObj.patient_id.focus();
			return;
			}*/
	if (isValidFromToField(formObj.from_date, formObj.to_date, DATE, getLabel("Common.date.label", "Common"), Sysdate)) { //Sysdate added for AMS-CRF-0258
		formObj.action="../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp";
		formObj.target="frameSalesAndReturnHistoryQueryResult";	
		formObj.submit();
	}
  }
	else
		{
			alert(getMessage("FROM_DATE_NOT_GREATER_SYSDATE", "ST"));
		    return ;
		}
	//Added for AMS-CRF-0258 - END
}
	
function isValidFromToField(fromObj, toObj, dataType, stLegend, Sysdate) { //Sysdate added for AMS-CRF-0258
		
		
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
	//Added for AMS-CRF-0258
	if(stToValue=="")
		{
			stToValue =Sysdate;
		}
	//Added for AMS-CRF-0258
	if ((!trimCheck(stFromValue)) || (!trimCheck(stToValue))) {
		return bReturn;
	}
	if (dataType == null) {
		dataType = STRING;
	}
	switch (dataType) {
	  case INT:
	  case LONG:
	  case FLOAT:
	  case DOUBLE:
		if (parseFloat(stFromValue) > parseFloat(stToValue)) {
			bReturn = false;
		}
		break;
	  case DATE:
		var arFromDate = stFromValue.split("/");
		var arToDate = stToValue.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			bReturn = false;
		}
		break;
	  default:
		if (stFromValue > stToValue) {
			bReturn = false;
		}
	}
	if ((!bReturn)) {
		var stMessage = getMessage("LESS_OR_EQUAL_VALIDATE", "ST");
		stMessage = stMessage.replace(/@/g, stLegend);
		alert(stMessage);
		toObj.focus();
	}
		return bReturn;
}



	function PopulateSalesReturnDocTypeCode(_trn_type1) {
		
		parent.frameSalesAndReturnHistoryQueryResult.document.location.href = "../../eCommon/html/blank.html";	
		var xmlHttp = new XMLHttpRequest();
		/*var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));*/
		var xmlString = getXMLString(null);
        var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
		xmlHttp.open("POST", "../../eST/jsp/SalesAndReturnHistoryValidate.jsp?trn_type=" + _trn_type1 +"&validate=POPULATE_SALES_DOC_TYPE_CODE", false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		eval(responseText) ;
	}
	


	function PopulateSalesDocTypeCode(_trn_type){	

	parent.frameSalesAndReturnHistoryQueryResult.document.location.href = "../../eCommon/html/blank.html";	
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesAndReturnHistoryValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_RETURN_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	eval(responseText);
}

	function populateBothDocTypeCode(_trn_type2){
	parent.frameSalesAndReturnHistoryQueryResult.document.location.href = "../../eCommon/html/blank.html";	
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesAndReturnHistoryValidate.jsp?trn_type="+_trn_type2+"&validate=POPULATE_BOTH_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	eval(responseText);
}


		
