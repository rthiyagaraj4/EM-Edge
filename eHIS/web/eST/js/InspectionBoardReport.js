/**
  * Created By Mahesh on 6/25/2008
*/
function reset() {
	formObj = f_query_add_mod.document.formInspectionBoardReportCriteria;
	formObj.reset();
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
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		//document.forms[0].p_str_code.value = returnedValues[0];
	}
}

async function searchCodeItem( obj) {
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		//document.forms[0].p_item_code.value = returnedValues[0];
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
	argumentArray[0] = document.formInspectionBoardReportCriteria.SQL_ST_ITEM_CLASS_LOOKUP_LANG.value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
	}
}

async function searchRemarksCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = "SELECT DISTINCT MM.TRN_REMARKS_CODE  CODE,MM.REMARKS_DESC  DESCRIPTION FROM  MM_TRN_REMARKS_LANG_VW  MM, ST_TRN_TYPE_FOR_REMARKS ST WHERE  ST.EFF_STATUS = 'E'   AND  ST.TRN_REMARKS_CODE = MM.TRN_REMARKS_CODE  AND UPPER(MM.MODULE_ID) LIKE  UPPER('ST')   AND  UPPER(ST.TRN_TYPE)  LIKE  UPPER('ADJ')     AND  MM.TRN_REMARKS_CODE LIKE   UPPER(?)     AND  UPPER(MM.REMARKS_DESC) LIKE  UPPER(?) AND MM.LANGUAGE_ID =" + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.remarks.label", "Common"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}				
 
	if ((retVal != null) && (retVal != "")) {
		obj.value = arr[0];
	}
}

function run() {
	if (f_query_add_mod.document.formInspectionBoardReportCriteria) {
		formObj = f_query_add_mod.document.formInspectionBoardReportCriteria;
		if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
				if (doDateCheck(formObj.dt_from, formObj.dt_to, messageFrame)) {
					if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
						if (isValidFromToField(formObj.p_fm_batch_id, formObj.p_to_batch_id, STRING,getLabel("Common.BatchID.label", "Common"), messageFrame)) {
							if (doDateCheck(formObj.cond_dt_from, formObj.cond_dt_to, messageFrame)) {
								if (isValidFromToField(formObj.p_fm_remarks_code, formObj.p_to_remarks_code, STRING,getLabel("Common.remarks.label", "Common")+" "+getLabel("Common.code.label", "Common"), messageFrame)) {
									formObj.dt_from.value = convertDate(formObj.dt_from.value, "DMY", formObj.p_language_id.value, "en");
									formObj.dt_to.value = convertDate(formObj.dt_to.value, "DMY", formObj.p_language_id.value, "en");
									formObj.cond_dt_from.value = convertDate(formObj.cond_dt_from.value, "DMY", formObj.p_language_id.value, "en");
									formObj.cond_dt_to.value = convertDate(formObj.cond_dt_to.value, "DMY", formObj.p_language_id.value, "en");									
									f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		                        f_query_add_mod.document.forms[0].target="messageFrame"
									formObj.submit();
								}
							}
						}
					}
				}
			}
		}
	}
}
