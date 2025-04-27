/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/1/2019		IN063960			Shazana									AMRI-CRF-0346
---------------------------------------------------------------------------------------------------------
*/


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
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value + "'" + localeName + "'" + "  ORDER BY 2"
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
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
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.forms[0].p_item_code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	
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
	
	async function searchPatient() {
	var patient_id = await PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.p_patient_id.value = patient_id;
	}
	getPatientName(patient_id);
}
	function searchpatientName(formObj) {
	var patientid = formObj.p_patient_id.value;
	if (!(patientid == null || patientid == "")) {
		getPatientName(patientid);
	}else{
		setPatientName("","");
	}
}
	function getPatientName(_patient_id) {
	var formObj = document.formSalesAndSalesReturnHistoryReport;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
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

		if(formObj.from_date.value==""){
						alert(getMessage("DATE_NOT_BLANK", "ST"));
						formObj.from_date.focus();
						return;
					}
}
	function isValidFromToField(fromObj, toObj, dataType, stLegend) {
	var bReturn = true;
	var stFromValue = fromObj.value;
	var stToValue = toObj.value;
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
		var xmlHttp = new XMLHttpRequest();
	        var xmlDoc = getXMLString(null); 
		
                 var url = "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp";
	         var params = "_trn_type1=" + encodeURIComponent(_trn_type1) + "&validate=POPULATE_RETURN_DOC_TYPE_CODE";
	   
	          xmlHttp.open("POST", url + "?" + params, false);
	          xmlHttp.setRequestHeader("Content-Type", "application/xml");
	       	xmlHttp.send(xmlDoc);
		 var responseText = xmlHttp.responseText;
		eval(responseText) ;
	}

	/*function PopulateSalesReturnDocTypeCode(_trn_type1) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp?trn_type=" + _trn_type1 +"&validate=POPULATE_SALES_DOC_TYPE_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText) ;
	}*/
	


	/*function PopulateSalesDocTypeCode(_trn_type){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_RETURN_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}	*/
	function PopulateSalesDocTypeCode(_trn_type) {
		
	    var xmlHttp = new XMLHttpRequest();   
	    var xmlDoc = getXMLString(null); 
	   
	    var url = "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp";
	    var params = "trn_type=" + encodeURIComponent(_trn_type) + "&validate=POPULATE_RETURN_DOC_TYPE_CODE";
	   // alert("xmlHttp.responseText1");
	    xmlHttp.open("POST", url + "?" + params, false);
	    xmlHttp.setRequestHeader("Content-Type", "application/xml");
	    xmlHttp.send(xmlDoc);
	    var responseText = xmlHttp.responseText;
	    eval(responseText);
	   
	}
	function populateBothDocTypeCode(_trn_type2){
		var xmlHttp = new XMLHttpRequest();
	        var xmlDoc = getXMLString(null); 
		
                 var url = "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp";
	         var params = "_trn_type2=" + encodeURIComponent(_trn_type2) + "&validate=POPULATE_RETURN_DOC_TYPE_CODE";
	   
	          xmlHttp.open("POST", url + "?" + params, false);
	          xmlHttp.setRequestHeader("Content-Type", "application/xml");
	       	xmlHttp.send(xmlDoc);
		 var responseText = xmlHttp.responseText;
		eval(responseText) ;
	}

	/*function populateBothDocTypeCode(_trn_type2){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp?trn_type="+_trn_type2+"&validate=POPULATE_BOTH_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}*/
	
	
	function run(){
	
		formObj = f_query_add_mod.document.formSalesAndSalesReturnHistoryReport;
		
		   if(formObj.p_from_date.value == ""){
		   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
	       formObj.p_from_date.focus();
	       return ;	
		   }
		   if(formObj.p_to_date.value == ""){
			   formObj.p_to_date.value= formObj.p_currentdate.value;
			   //alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		       //formObj.p_to_date.focus();
		       //return ;	
		   }
		    var startDate = formObj.p_from_date.value;
		    var endDate = formObj.p_to_date.value;
		   // alert(startDate +""+endDate);
		    const date1 = parseDateFromDDMMYYYY(startDate);
		    const date2 = parseDateFromDDMMYYYY(endDate);
		   // alert(date1 +""+date2);
		    const timeDifference = date2 - date1;
            
		   
		    const daysDifference = timeDifference / (1000 * 60 * 60 * 24);
		    //alert(daysDifference);
		    var xmlHttp = new XMLHttpRequest();
		    var xmlDoc = "";
            xmlDoc=new DOMParser().parseFromString(getXMLString(null), "text/xml");
		    xmlHttp.open("POST", "../../eST/jsp/SalesAndSalesReturnHistoryReportValidate.jsp?${params}", false);
		    xmlHttp.send();
		    var responseText = xmlHttp.responseText;
		    eval(responseText);

		if(daysDifference<=90){
		formObj.DT_FROM.value = convertDate(formObj.p_from_date.value, "DMY", formObj.p_language_id.value, "en");		 
		formObj.DT_TO.value = convertDate(formObj.p_to_date.value, "DMY", formObj.p_language_id.value, "en");
	     if(formObj.p_from_date.value != "" && formObj.p_to_date.value != "" ){
			  if(!isBefore(formObj.DT_FROM.value,formObj.DT_TO.value,"DMY",'en'.value)) {
	          alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
	          formObj.p_to_date.focus();
	           return ;	
	         } 
		  }
		
		   if(formObj.p_from_date.value != "" && formObj.p_to_date.value != "" ){
				  if(!isBefore(formObj.DT_FROM.value,formObj.DT_TO.value,"DMY",'en'.value)) {
		          alert(getMessage("DATE_NOT_GREATER_SYSDATE", "ST"));
		          formObj.p_to_date.focus();
		           return ;	
		         } 
			  }	
			var currentdate=getCurrentDate("DMY",formObj.p_language_id.value);
			var localename=formObj.p_language_id.value;
			if(formObj.p_from_date.value!=""){
				if(!isBefore(formObj.p_from_date.value, currentdate, "DMY", localename)){
					alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST"));
					formObj.p_from_date.select();
					formObj.p_from_date.focus();
					return;
				}
			}
			if(formObj.p_to_date.value!=""){
				if(!isBefore(formObj.p_to_date.value, currentdate, "DMY", localename)){
					alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE","ST"));
					formObj.p_to_date.select();
					formObj.p_to_date.focus();
					return;
				}
			}
			
			//var testScr = IsDateDifferenceLessThanThirtyDays(startDate, endDate);
			//alert("TestScr: "+testScr);
	       // if(!IsDateDifferenceLessThanThirtyDays(startDate, endDate)){
			//	alert("hello");
	       // 	return;
	       // }
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    	   f_query_add_mod.document.forms[0].target="messageFrame"
			   formObj.submit();
		   
		}else{
			alert(getMessage("ST_DOC_DT_NOT_GR_TO_DT_LIMIT","ST"));
					formObj.p_from_date.select();
					formObj.p_from_date.focus();
					return;

		}
	}
	
	function parseDateFromDDMMYYYY(dateString) {
		  // Split the input date string by the '/' character
		  const [day, month, year] = dateString.split('/');

		  // Convert the date parts to numbers
		  const dayNum = parseInt(day, 10);
		  const monthNum = parseInt(month, 10) - 1; // JavaScript months are 0-indexed
		  const yearNum = parseInt(year, 10);

		  // Create and return a new Date object
		  return new Date(yearNum, monthNum, dayNum);
		}


		
