
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	//frames[1].document.forms[0].reset();
	f_query_add_mod.location.href = "../../eST/jsp/TransactionListReportCriteria.jsp";
}

function run(){
  formObj = f_query_add_mod.document.formTransactionListReportCriteria;
    if(formObj.P_TRN_TYPE.value == "" ){
	alert("Transaction Type cannot be blank.");
	formObj.P_TRN_TYPE.focus();
	return;
	}
	/*if(formObj.P_Report_OPTION.value == "" ){
	alert("Report Option cannot be blank.");
	formObj.P_Report_OPTION.focus();
	return;
	}*/
 
    formObj.P_FROM_date.value = convertDate(formObj.p_trn_date_from.value, "DMY", formObj.p_language_id.value, "en");		 
	formObj.P_TO_date.value = convertDate(formObj.p_trn_date_to.value, "DMY", formObj.p_language_id.value, "en");
     if(formObj.p_trn_date_to.value != "" && formObj.p_trn_date_from.value != "" ){
		  if(!isBefore(formObj.P_FROM_date.value,formObj.P_TO_date.value,"DMY",'en'.value)) {
          alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
          formObj.p_trn_date_to.focus();
           return ;	
         } 
	  }
	   if(formObj.p_trn_date_from.value == ""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
       formObj.p_trn_date_from.focus();
       return ;	
	   }
	   if(formObj.p_trn_date_to.value == ""){
	   alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
       formObj.p_trn_date_to.focus();
       return ;	
	   }
	   if(formObj.P_TRN_TYPE.value == "ISS" || formObj.P_TRN_TYPE.value == "URG" ){
       if(formObj.p_transaction_mode.value == ""){
       alert("Transaction mode Cannot be blank");
       formObj.p_transaction_mode.focus();
       return;
	   }
       }
	   if(formObj.P_top_Nrecords.value == ""){
	   alert("Please enter value for Top Items");
       formObj.P_top_Nrecords.focus();
       return ;	
	   }
	    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame"
        formObj.submit();		
}

function checkDocDate(formObj) {
	if (isValidFromToField(formObj.p_trn_date_from, formObj.p_trn_date_to, DATE, getLabel("Common.date.label", "Common"))) {
	} else {
		return false;
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
function loadData()
{
  formObj = document.formTransactionListReportCriteria;
  
  //formObj.facility_id.value      = formObj.p_facility_id.value;
 // formObj.p_store_code.value     = "";
  //formObj.P_top_Nrecords.value   = "";
  
  if(formObj.P_TRN_TYPE.value == "ISS" || formObj.P_TRN_TYPE.value == "URG"){
  formObj.p_transaction_mode.value = "";
  formObj.p_transaction_mode.style.visibility="visible";
  document.getElementById("trn_mode_img").style.visibility="visible";
  document.getElementById("mode").style.visibility="visible";
  }else{
  formObj.p_transaction_mode.style.visibility ="hidden";
  document.getElementById("trn_mode_img").style.visibility="hidden";
  document.getElementById("mode").style.visibility="hidden";
  }
  //loadStore(formObj.p_facility_id);
}
function loadStore(obj){ 
             var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			//xmlDoc.loadXML(getXMLString(null));
			xmlDoc = new DOMParser().parseFromString(getXMLString(document.formComputeStockLevelsCriteria), "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/TransactionListReportValidate.jsp?p_facility_id=" +obj.value+ "&validate=LOAD_STORE", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText); 
   } 
function clearListStores(listObject) {
	var select_option =  getLabel("Common.all.label", "Common");
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
	var listOption = createListOption("", select_option);
	eval(listObject + ".add(listOption)");
}
