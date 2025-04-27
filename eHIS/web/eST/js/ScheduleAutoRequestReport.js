

function reset() {
	formObj = f_query_add_mod.document.schduleAutoReportCriteria;
	if(formObj==undefined){
	formObj = f_query_add_mod.document.itemWiseSchduleAutoReportCriteria;
	}
	formObj.reset();
}

function run() {

	if(f_query_add_mod.document.schduleAutoReportCriteria!=undefined){
	if(f_query_add_mod.document.schduleAutoReportCriteria.view.value=="S" ){
	//escape(f_query_add_mod.document.schduleAutoReportCriteria.req_by_store_desc.value);

	f_query_add_mod.document.schduleAutoReportCriteria.p_report_id.value="STBASRBS";
	}else{
	f_query_add_mod.document.schduleAutoReportCriteria.p_report_id.value="STBASRAS";
	}
	 f_query_add_mod.document.schduleAutoReportCriteria.submit();
	}else{
	if(f_query_add_mod.document.itemWiseSchduleAutoReportCriteria.p_schdule_created_By_code.value!=""){
	f_query_add_mod.document.itemWiseSchduleAutoReportCriteria.p_report_id.value="STBASRISU";
	

	f_query_add_mod.document.itemWiseSchduleAutoReportCriteria.submit();
	}else{
	f_query_add_mod.document.itemWiseSchduleAutoReportCriteria.p_report_id.value="STBASRISC";
	f_query_add_mod.document.itemWiseSchduleAutoReportCriteria.submit();
	}
	
	}
	
	
}


async function SchduleCodeLookup(obj) {
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	if(document.itemWiseSchduleAutoReportCriteria!=undefined){
	var ficility_id=document.itemWiseSchduleAutoReportCriteria.p_facility_id.value;
	var sql=document.itemWiseSchduleAutoReportCriteria.SQL_SCHDULE_AUTO_CODE_LOOKUP.value;

	}else{
	var ficility_id=document.schduleAutoReportCriteria.p_facility_id.value;
	var sql=document.schduleAutoReportCriteria.SQL_SCHDULE_AUTO_CODE_LOOKUP.value;

	}
	argumentArray[0] =sql+"'"+ficility_id+"'"+" order by 1";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.ReqOnStore.label","Common"), argumentArray);
    var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}
	//if ((returnedValues != null) && (returnedValues != "")) {
		if ((retVal != null) && (retVal != "")) {
		if(document.itemWiseSchduleAutoReportCriteria!=undefined){
		document.itemWiseSchduleAutoReportCriteria.p_schedule_code.value = arr[0];//code
		document.itemWiseSchduleAutoReportCriteria.p_schedule_desc.value = arr[1];//desc
		}else{

		document.schduleAutoReportCriteria.p_schedule_code.value = arr[0];//code
		document.schduleAutoReportCriteria.p_schedule_desc.value = arr[1];//desc
	
		}
	}
}

async function schduleCreatedByLookup(target) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = document.itemWiseSchduleAutoReportCriteria.SQL_ST_USER_LOOKUP_USERACCESS.value + "'" + document.itemWiseSchduleAutoReportCriteria.p_language_id.value + "'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = "";
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup(getLabel("eST.SchduleCreatedBy.label", "ST"), argumentArray);
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}		

	if (retVal != null && retVal != "" && retVal!=undefined) {
		target.value = retVal[1];
		document.itemWiseSchduleAutoReportCriteria.p_schdule_created_By.value = arr[1];
		document.itemWiseSchduleAutoReportCriteria.p_schdule_created_By_code.value =arr[0];
		
		
	}
}

async function requestByStoreLookup(obj) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var facility_id    = document.schduleAutoReportCriteria.p_facility_id.value;
	var language_id	   = document.schduleAutoReportCriteria.p_language_id.value
	var user_id	   = document.schduleAutoReportCriteria.p_user_name.value
	var sql=document.schduleAutoReportCriteria.SQL_SCHDULE_AUTO_STORE_LOOKUP.value;
	
	argumentArray[0] = sql+"'"+facility_id+"'"+" AND ST.USER_ID ="+"'"+ user_id+"'" +" AND MM.LANGUAGE_ID="+"'"+language_id+"'"+"order by 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.ReqByStore.label","Common"), argumentArray);
    var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}		
	if ((retVal != null) && (retVal != "") && retVal!=undefined) {
		document.schduleAutoReportCriteria.p_requisition_by_store.value = arr[0];//code
		document.schduleAutoReportCriteria.req_by_store_desc.value = arr[1];//desc
	}
}

async function requestOnStoreLookup(obj,obj1) {
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var facility_id    = document.schduleAutoReportCriteria.p_facility_id.value;
	var language_id	   = document.schduleAutoReportCriteria.p_language_id.value
	var user_id	   = document.schduleAutoReportCriteria.p_user_name.value
	var sql=document.schduleAutoReportCriteria.SQL_SCHDULE_AUTO_STORE_LOOKUP.value;


	argumentArray[0] = sql+"'"+facility_id+"'"+" AND ST.USER_ID ="+"'"+ user_id+"'" +" AND MM.LANGUAGE_ID="+"'"+language_id+"'"+"order by 2";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(getLabel("Common.ReqOnStore.label","Common"), argumentArray);
	var ret1=unescape(retVal);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}

	if ((retVal != null) && (retVal != "")) {
		if(retVal[0]==obj1.value){
		alert(getMessage("REQ_ON_REQ_BY_CANNOT_BE_SAME","ST"));
		return;
		}
		document.schduleAutoReportCriteria.p_requisition_on_store.value = arr[0];//code
		document.schduleAutoReportCriteria.req_on_store_desc.value = arr[1];//desc
	
	}
}

function changeType(obj){

if(obj.value=="S"){

document.schduleAutoReportCriteria.req_by_store_desc.disabled=false;
document.schduleAutoReportCriteria.req_code.disabled=false;

}else{
	document.schduleAutoReportCriteria.req_by_store_desc.value="";
	document.schduleAutoReportCriteria.p_requisition_by_store.value="";
	document.schduleAutoReportCriteria.req_by_store_desc.disabled=true;
	document.schduleAutoReportCriteria.req_code.disabled=true;



}


	}
