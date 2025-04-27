var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function reset() {
	f_query_add_mod.document.formCSSDStockVendorLoanDetails.reset();
}
function searchCodeStoreMaster(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.forms[0].SQL_SS_STORE_LOOKUP.value;
	dataNameArray[1]="LANGUAGE_ID"
	dataValueArray[1]=document.forms[0].locale.value;
	dataTypeArray[1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
	 
		obj.value = returnedValues[0];
	} 
}
function searchCodeSterileGroupMaster(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray  [0]="LANGUAGE_ID";
	dataValueArray [0]=document.formCSSDStockVendorLoanDetails.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[0] =document.formCSSDStockVendorLoanDetails.SQL_SS_GROUP_LOOKUP.value; 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eSS.SterileGroup.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
	 
		obj.value = returnedValues[0];
	} 
}
function searchCodeVendorMaster	(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray  [0]="LANGUAGE_ID";
	dataValueArray [0]=document.formCSSDStockVendorLoanDetails.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[0] =document.formCSSDStockVendorLoanDetails.SQL_AP_SUPPLIER_SELECT_LIST1.value; 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("eSS.Vendor.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
	 
		obj.value = returnedValues[0];
	} 
}
function run()
{
	   formObj = f_query_add_mod.document.formCSSDStockVendorLoanDetails;
	   formObj.p_req_from_date.value = convertDate(formObj.p_req_from_date1.value, "DMY", formObj.p_language_id.value, "en");		 
		formObj.p_req_to_date.value = convertDate(formObj.p_req_to_date1.value, "DMY", formObj.p_language_id.value, "en");
	     if(formObj.p_req_from_date.value != "" && formObj.p_req_to_date.value != "" ){
			  if(!isBefore(formObj.p_req_from_date.value,formObj.p_req_to_date.value,"DMY",'en'.value)) {
	          alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
	          formObj.p_req_to_date1.focus();
	           return ;	
	         } 
		  }
		   if(formObj.p_report_option.value == "SM")
		   formObj.p_report_id.value = "SSSTKVENLONSUM" ;
		   else
		   formObj.p_report_id.value = "SSSTKVENLONDTL";
		   
		   if (isValidFromToField(formObj.p_request_from_vendor, formObj.p_request_to_vendor, STRING, "Vendor", messageFrame))
			   if (isValidFromToField(formObj.p_req_by_from_store_code, formObj.p_req_by_to_store_code, STRING, "Store", messageFrame))
				   if (isValidFromToField(formObj.p_req_from_group_code, formObj.p_req_to_group_code, STRING, "Group", messageFrame))
	        formObj.submit();
}
function checkSysdate(receiptdate,sysdate){

	var flag=true;
if(ChkDate(receiptdate) && flag )
{
	
		if(!checkdateWithSysDate(receiptdate,sysdate))
		{
		alert(getMessage("NOT_GRT_THAN_SYSDATE","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;
		}
		else
		{

		}
}
	else
	{
		if(!(flag))
		{

			alert(getMessage("INVALID_DATE_FMT","SS"));
			receiptdate.select();
			receiptdate.focus();
			return false;

		}
		else
		{
		alert(getMessage("INVALID_DATE_FMT","SS"));
		receiptdate.select();
		receiptdate.focus();
		return false;
		}
	}

	
}
function checkdateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/**
			  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
			  */
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}
