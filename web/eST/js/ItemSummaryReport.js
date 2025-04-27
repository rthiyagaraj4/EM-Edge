
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
function reset() {
	formObj = f_query_add_mod.document.formItemSummaryReportCriteria;
	formObj.reset();
	//parent.frames[1].frames[1].document.forms[0].reset();
}
function loadcolumn(obj) {
	formObj = document.forms[0];
}
async function searchCodeItem(obj) {
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
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
	else{
		obj.value=arr[0];
	}
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
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
	else{
		obj.value=arr[0];
	}
}
async function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
	else{
		obj.value=arr[0];
	}
}
function run() {
	if (f_query_add_mod.document.formItemSummaryReportCriteria) {
		formObj = f_query_add_mod.document.formItemSummaryReportCriteria;
		if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fm_item_value, formObj.p_to_item_value, DOUBLE, getLabel("eST.StockItemValue.label", "eST"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_unit_cost, formObj.p_to_unit_cost, DOUBLE, getLabel("Common.UnitCost.label", "Common"), messageFrame)) {
							formObj.submit();
						}
					}
				}
			}
		}
	}
}
/*function setReportStoreId()
{
    if(document.formReportStore.p_report_type.value=="IC")
  
   {
     document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS1" ;
   }else if(document.formItemSummaryReportCriteria.p_report_type.value=="BI")
	   {
      document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS2" ; 
   }else if(document.formItemSummaryReportCriteria.p_report_type.value=="BS")
	   {
      document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS3" ; 
   }else if(document.formItemSummaryReportCriteria.p_report_type.value=="IB")
	   {
      document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS4" ; 
   }else if(document.formItemSummaryReportCriteria.p_report_type.value=="SB")
	   {
      document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS5" ; 
   }else if(document.formItemSummaryReportCriteria.p_report_type.value=="BL")
	   {
      document.formItemSummaryReportCriteria.p_report_id.value="STBSTKS6" ; 
   }
}

function setReportItemId()
{
  
  if(document.formReportItem.p_report_type.value=="1")
   {
     document.formReportItem.p_report_id.value="STBITEMS" ;
   }else {
      document.formReportItem.p_report_id.value="STBITMDT" ; 
   }
}

*/

