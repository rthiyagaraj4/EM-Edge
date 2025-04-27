/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------

10/10/2019  IN:071344           B Haribabu                                         		GHL-CRF-0609	
26/03/2020  IN:072784           Haribabu                                             ST Store master function - No action on click of Apply
22/2/2022	TFS27891			Shazana		 										MO-CRF-20176
-------------------------------------------------------------------------------------------------------------------------------
*/  
var count = 0;
function create() {
	
    f_query_add_mod.location.href = "../../eST/jsp/StoreAddModify.jsp?mode="+ MODE_INSERT +"&function_id="+ function_id ;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/StoreQueryCriteria.jsp?function_id="+function_id;
}
function apply() {
	var formObj = f_query_add_mod.document.formStore;
	var flag=false;//Added for IN:072784
	if(formObj==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return
	}
	var atleastOneFieldChecked = false;
	if (f_query_add_mod.document.formStore.medical_item_yn.checked || f_query_add_mod.document.formStore.nonmedical_item_yn.checked) {
		atleastOneFieldChecked = true;
	} else {
		atleastOneFieldChecked = false;
	}
	var errorPage = "../../eCommon/jsp/error.jsp";
	//Added for IN:071344 start, Modified for IN:072784 start
	if(formObj.auto_rol_appl_yn.value=="Y"){
		if(formObj.chk_auto_rol_yn.checked && formObj.consm_freq_days.value==""){
			flag=true;
		}
	}
	if(flag){
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("CON_PERIOD_BLANK", "ST");
	}
	
	else{//Added for IN:071344 end, Modified for IN:072784 end
	if (atleastOneFieldChecked) {
		var checkedTransaction = false;
		var formObject1 = f_query_add_mod.document.formStore;
		for (var i = 0; i < formObject1.elements.length; i++) {
			if (i > 7 && formObject1.elements[i].type == "checkbox" && formObject1.elements[i].checked == true) {
				checkedTransaction = true;
				break;
			}
		}
		if (f_query_add_mod.document.formStore.count.value > 0 || checkedTransaction == true) {
			var fields = new Array(formObj.store_code);
			var names = new Array(getLabel("Common.Store.label", "Common"));
			var blankObject = null;
			blankObject = checkSTFields(fields, names, messageFrame, errorPage);
			if (blankObject == true) {
				eval(formApply(formObj, ST_CONTROLLER));
				messageFrame.location.href = errorPage + "?err_num=" + message;
				if (result) {
					onSuccess();
				}
			} 
		} else {
			messageFrame.location.href = errorPage + "?err_num=" + getMessage("ATLEAST_ONE_TRANS", "ST");
		}
	} else {
		messageFrame.location.href = errorPage + "?err_num=" + getMessage("MEDICAL_NON_MEDICAL_CHECKED", "ST");
	}
}
}
//MO-CRF-20176
function checkZero(obj,finalizedcount,records_per_trn,trn_type) {
	if (obj.value == "0") {
		alert("No. Of Records Per Transaction Cannot Be Zero");
		obj.select();
		return false; 
	}
	
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
	if(trn_type == "ISS"){
		if(finalizedcount=="true" && obj.value != records_per_trn) {  
			alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
			obj.value = records_per_trn; 
		}
	}
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends
}
function reset() {
	if (f_query_add_mod.document.formStore != null) {
		f_query_add_mod.location.reload();
	}
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.location.reload();
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.formStore.mode.value;
	if (mode == MODE_INSERT) {
		reset();
	} else {
		f_query_add_mod.document.location.reload();
	}
}
function doCheckUnCheck(isChecked) {
	document.formStore.pre_allowed_yn.checked = isChecked;
	document.formStore.iss_allowed_yn.checked = isChecked;
	document.formStore.adj_allowed_yn.checked = isChecked;
	document.formStore.var_allowed_yn.checked = isChecked;
	document.formStore.rof_allowed_yn.checked = isChecked;
}
function isOwner_YNChecked() {
	return document.formStore.owner_yn.checked;
}
function Modify(obj) {
	var store_code = obj.cells[0].innerText;
	document.location.href = "../../eST/jsp/StoreAddModify.jsp?mode=" + MODE_MODIFY + "&function_id=" + parent.function_id + "&store_code=" + store_code;
}
async function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";

	//var sql_store = "SELECT store_code  code,short_desc  description  FROM  mm_store_lang_vw a  WHERE facility_id   =  '" +  + "'   AND  UPPER(store_code)     LIKE  UPPER(?)  AND  UPPER(short_desc)  LIKE UPPER(?)  AND  eff_status='E'  AND  not exists  ( select  store_code     from  st_store b  where  a.store_code=b.store_code)  and a.language_id ='"+document.forms[0].language_id.value+"'";//removed \t for 15977
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~FACILITY_ID`";
	parNameArray[1] ="~LOCALE_ID`";
	parValueArray[0]=document.forms[0].facility_id.value;
	parValueArray[1]=document.forms[0].language_id.value;
	
	argumentArray[0] = "";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	argumentArray[12]  = "SQL_ST_STORE_LOOKUP_SELECT";
	argumentArray[13]  = "eST.Common.StRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray
	
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
		validate_store_code(arr[0]);
	}

}
function validate_store_code(obj) {
	var formObj = document.forms[0];
	if (formObj.store_code.value == "") {
		return;
	}
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/StoreValidate.jsp?validate=STORE_CODE&store_code=" + formObj.store_code.value, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText); 
	eval(responseText);
	if (!result) {
		alert(getMessage(flag, "ST"));
		formObj.store_code.select();
		formObj.store_code.focus();
		parent.f_query_add_mod.document.getElementById('td_external_gif_label').innerHTML = "";
		parent.f_query_add_mod.document.getElementById('td_external').innerHTML = "";
		parent.f_query_add_mod.document.getElementById('td_department_label').innerHTML = "";
	}
	addParentStore(obj);
}
function setStoreDetail(store_code, department, store_desc, external_yn, group_code) {
	var formObj = parent.f_query_add_mod.formStore;
	formObj.store_code.value = store_code;
	 parent.f_query_add_mod.document.getElementById('td_storedesc').innerHTML = "<b>" + store_desc + "</b>";
	 parent.f_query_add_mod.document.getElementById('td_department_label').innerText = "Department  ";
	 parent.f_query_add_mod.document.getElementById('td_department').innerHTML = "<b>" + department + "</b>&nbsp;";
	 parent.f_query_add_mod.document.getElementById('td_department_label').innerHTML = "Department ";
	 parent.f_query_add_mod.document.getElementById('td_external_gif_label').innerHTML = "External ";
	if (external_yn == "Y") {
		 parent.f_query_add_mod.document.getElementById('td_external').innerHTML = "<image src='../../eCommon/images/enabled.gif'></image>";
		disableStoreType();
	} else {
		if (external_yn == "N") {
			 parent.f_query_add_mod.document.getElementById('td_external').innerHTML = "<image src='../../eCommon/images/disabled.gif'></image>";
		}
	}
	parent.f_query_add_mod.document.getElementById('td_storegroup').innerHTML = "<b>" + group_code + "</b>&nbsp;";
}
function disableStoreType() {
	parent.f_query_add_mod.document.formStore.store_type_flag.options.selectedIndex = 3;
	parent.f_query_add_mod.document.formStore.store_type_flag.disabled = true;
	validate_store_type(parent.f_query_add_mod.document.formStore.store_type_flag);
}
function setStoreType(stock_item_yn) {
	if (stock_item_yn == "Y") {
		alert(getMessage("NONSTOCK_STORE_TYPE", "ST"));
	}
}

//Added by Martin
function addParentStore(obj) {
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/StoreValidate.jsp?validate=PARENT_STORE&store_code=" + document.forms[0].store_code.value, false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlString);
	var responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
function validate_store_type(obj) {
	var store_type = obj.value;
	var mode = document.forms[0].mode.value;
	
	if (store_type == "S") {
		document.forms[0].grn_allowed_yn.disabled = true;
		document.forms[0].grn_allowed_yn.checked = false;
		document.forms[0].rtv_allowed_yn.disabled = true;
		document.forms[0].rtv_allowed_yn.checked = false;
		document.forms[0].prt_allowed_yn.disabled = false;
		document.forms[0].mfg_allowed_yn.disabled = false;
		document.forms[0].iss_allowed_yn.disabled = false;
		document.forms[0].urg_allowed_yn.disabled = false;
		document.forms[0].tfr_allowed_yn.disabled = false;
		document.forms[0].adj_allowed_yn.disabled = false;
		document.forms[0].var_allowed_yn.disabled = false;
		document.forms[0].obs_allowed_yn.disabled = false;
		document.forms[0].split_batch_allowed_yn.disabled = false;
		document.forms[0].bin_change_allowed_yn.disabled = false;
		if (mode == "1") {
			document.forms[0].mfg_allowed_yn.checked = false;
			document.forms[0].iss_allowed_yn.checked = false;
			document.forms[0].urg_allowed_yn.checked = false;
			document.forms[0].tfr_allowed_yn.checked = false;
			document.forms[0].adj_allowed_yn.checked = false;
			document.forms[0].var_allowed_yn.checked = false;
			document.forms[0].prt_allowed_yn.checked = false;
			document.forms[0].obs_allowed_yn.checked = false;
			document.forms[0].srt_allowed_yn.checked = false;
			document.forms[0].sal_allowed_yn.checked = false;
			document.forms[0].req_allowed_yn.checked = false;
			document.forms[0].ret_allowed_yn.checked = false;
			document.forms[0].split_batch_allowed_yn.checked = false;
			document.forms[0].bin_change_allowed_yn.checked = false;
			document.forms[0].grn_allowed_yn.checked = false;
			document.forms[0].rtv_allowed_yn.checked = false;
			document.forms[0].authorize_spl_req_yn.checked = false;
			document.forms[0].stock_item_cons_yn.checked = false;
		}
	} else {
		if (store_type == "N") {
			document.forms[0].req_allowed_yn.disabled = false;
			document.forms[0].ret_allowed_yn.disabled = false;
			if (document.forms[0].scope) {
				if (document.forms[0].sal_allowed_yn != null) {
					document.forms[0].sal_allowed_yn.disabled = false;
				}
				if (document.forms[0].srt_allowed_yn != null) {
					document.forms[0].srt_allowed_yn.disabled = false;
				}
			}
			document.forms[0].stock_item_cons_yn.disabled = true;
			document.forms[0].stock_item_cons_yn.checked = false;
			document.forms[0].grn_allowed_yn.disabled = true;
			document.forms[0].grn_allowed_yn.checked = false;
			document.forms[0].rtv_allowed_yn.disabled = true;
			document.forms[0].rtv_allowed_yn.checked = false;
			document.forms[0].prt_allowed_yn.disabled = true;
			document.forms[0].prt_allowed_yn.checked = false;
			document.forms[0].mfg_allowed_yn.disabled = true;
			document.forms[0].mfg_allowed_yn.checked = false;
			document.forms[0].iss_allowed_yn.disabled = true;
			document.forms[0].iss_allowed_yn.checked = false;
			document.forms[0].urg_allowed_yn.disabled = true;
			document.forms[0].urg_allowed_yn.checked = false;
			document.forms[0].tfr_allowed_yn.disabled = true;
			document.forms[0].tfr_allowed_yn.checked = false;
			document.forms[0].adj_allowed_yn.disabled = true;
			document.forms[0].adj_allowed_yn.checked = false;
			document.forms[0].var_allowed_yn.disabled = true;
			document.forms[0].var_allowed_yn.checked = false;
			document.forms[0].obs_allowed_yn.disabled = true;
			document.forms[0].obs_allowed_yn.checked = false;
			document.forms[0].split_batch_allowed_yn.disabled = true;
			document.forms[0].split_batch_allowed_yn.checked = false;
			document.forms[0].bin_change_allowed_yn.disabled = true;
			document.forms[0].bin_change_allowed_yn.checked = false;
			if (mode == "1") {
				document.forms[0].srt_allowed_yn.checked = false;
				document.forms[0].sal_allowed_yn.checked = false;
				document.forms[0].req_allowed_yn.checked = false;
				document.forms[0].ret_allowed_yn.checked = false;
				document.forms[0].authorize_spl_req_yn.checked = false;
				document.forms[0].authorize_spl_req_yn.value = "N";
			}
		} else {
			if (store_type == "P") {
				document.forms[0].mfg_allowed_yn.disabled = false;
				document.forms[0].iss_allowed_yn.disabled = false;
				document.forms[0].urg_allowed_yn.disabled = false;
				document.forms[0].tfr_allowed_yn.disabled = false;
				document.forms[0].adj_allowed_yn.disabled = false;
				document.forms[0].var_allowed_yn.disabled = false;
				document.forms[0].prt_allowed_yn.disabled = false;
				document.forms[0].obs_allowed_yn.disabled = false;
				document.forms[0].split_batch_allowed_yn.disabled = false;
				document.forms[0].bin_change_allowed_yn.disabled = false;
				document.forms[0].grn_allowed_yn.disabled = false;
				document.forms[0].rtv_allowed_yn.disabled = false;
				document.forms[0].authorize_spl_req_yn.disabled = false;
				document.forms[0].stock_item_cons_yn.disabled = false;
				if (mode == "1") {
					document.forms[0].mfg_allowed_yn.checked = true;
					document.forms[0].iss_allowed_yn.checked = true;
					document.forms[0].urg_allowed_yn.checked = true;
					document.forms[0].tfr_allowed_yn.checked = true;
					document.forms[0].adj_allowed_yn.checked = true;
					document.forms[0].var_allowed_yn.checked = true;
					document.forms[0].prt_allowed_yn.checked = true;
					document.forms[0].obs_allowed_yn.checked = true;
					document.forms[0].srt_allowed_yn.checked = true;
					document.forms[0].sal_allowed_yn.checked = true;
					document.forms[0].req_allowed_yn.checked = true;
					document.forms[0].ret_allowed_yn.checked = true;
					document.forms[0].split_batch_allowed_yn.checked = true;
					document.forms[0].bin_change_allowed_yn.checked = true;
					document.forms[0].grn_allowed_yn.checked = true;
					document.forms[0].rtv_allowed_yn.checked = true;
					document.forms[0].authorize_spl_req_yn.checked = true;
					document.forms[0].stock_item_cons_yn.checked = true;
					document.forms[0].authorize_spl_req_yn.value = "Y";
				}
			} else {
				document.forms[0].mfg_allowed_yn.disabled = false;
				document.forms[0].iss_allowed_yn.disabled = false;
				document.forms[0].urg_allowed_yn.disabled = false;
				document.forms[0].tfr_allowed_yn.disabled = false;
				document.forms[0].adj_allowed_yn.disabled = false;
				document.forms[0].var_allowed_yn.disabled = false;
				document.forms[0].prt_allowed_yn.disabled = false;
				document.forms[0].obs_allowed_yn.disabled = false;
				document.forms[0].split_batch_allowed_yn.disabled = false;
				document.forms[0].bin_change_allowed_yn.disabled = false;
				document.forms[0].grn_allowed_yn.disabled = false;
				document.forms[0].rtv_allowed_yn.disabled = false;
				document.forms[0].authorize_spl_req_yn.disabled = false;
				document.forms[0].stock_item_cons_yn.disabled = false;
				if (mode == "1") {
					document.forms[0].mfg_allowed_yn.checked = false;
					document.forms[0].iss_allowed_yn.checked = false;
					document.forms[0].urg_allowed_yn.checked = false;
					document.forms[0].tfr_allowed_yn.checked = false;
					document.forms[0].adj_allowed_yn.checked = false;
					document.forms[0].var_allowed_yn.checked = false;
					document.forms[0].prt_allowed_yn.checked = false;
					document.forms[0].obs_allowed_yn.checked = false;
					document.forms[0].srt_allowed_yn.checked = false;
					document.forms[0].sal_allowed_yn.checked = false;
					document.forms[0].req_allowed_yn.checked = false;
					document.forms[0].ret_allowed_yn.checked = false;
					document.forms[0].split_batch_allowed_yn.checked = false;
					document.forms[0].bin_change_allowed_yn.checked = false;
					document.forms[0].grn_allowed_yn.checked = false;
					document.forms[0].rtv_allowed_yn.checked = false;
					document.forms[0].authorize_spl_req_yn.checked = false;
					document.forms[0].stock_item_cons_yn.checked = false;
				}
			}
		}
	}
}
function incrementCount(obj) {
if(document.formStore.interface_to_external_po_yn.value=="Y"){
	if(obj.name=="grn_allowed_yn" && obj.checked==true ){
		document.formStore.prq_allowed_yn.disabled = false;
	}
	if(obj.name=="grn_allowed_yn" && obj.checked==false ){
		document.formStore.prq_allowed_yn.disabled = true;
		document.formStore.prq_allowed_yn.checked = false;
		document.formStore.prq_allowed_yn.value = "N";
	}
}

	if (obj.checked) {
		count = parseInt(count) + 1;
	} else {
		count = parseInt(count) - 1;
	}
	document.formStore.count.value = count;
}
function setAuthorizeSplReq() {
	if (document.formStore.authorize_spl_req_yn.checked == true) {
		document.formStore.authorize_spl_req_yn.value = "Y";
	} else {
		document.formStore.authorize_spl_req_yn.value = "N";
	}
}
function validate_store_typeModify(obj) {
	var store_type = obj.value;
	var mode = document.forms[0].mode.value;
	if (store_type == "S") {
		document.forms[0].grn_allowed_yn.disabled = true;
		document.forms[0].grn_allowed_yn.checked = false;
		document.forms[0].rtv_allowed_yn.disabled = true;
		document.forms[0].rtv_allowed_yn.checked = false;
		document.forms[0].prt_allowed_yn.disabled = false;
		document.forms[0].mfg_allowed_yn.disabled = false;
		document.forms[0].iss_allowed_yn.disabled = false;
		document.forms[0].urg_allowed_yn.disabled = false;
		document.forms[0].tfr_allowed_yn.disabled = false;
		document.forms[0].adj_allowed_yn.disabled = false;
		document.forms[0].var_allowed_yn.disabled = false;
		document.forms[0].obs_allowed_yn.disabled = false;
		document.forms[0].split_batch_allowed_yn.disabled = false;
		document.forms[0].bin_change_allowed_yn.disabled = false;
	} else {
		if (store_type == "N") {
			document.forms[0].req_allowed_yn.disabled = false;
			document.forms[0].ret_allowed_yn.disabled = false;
			if (document.forms[0].scope) {
				if (document.forms[0].sal_allowed_yn != null) {
					document.forms[0].sal_allowed_yn.disabled = false;
				}
				if (document.forms[0].srt_allowed_yn != null) {
					document.forms[0].srt_allowed_yn.disabled = false;
				}
			}
			document.forms[0].stock_item_cons_yn.disabled = true;
			document.forms[0].stock_item_cons_yn.checked = false;
			document.forms[0].grn_allowed_yn.disabled = true;
			document.forms[0].grn_allowed_yn.checked = false;
			document.forms[0].rtv_allowed_yn.disabled = true;
			document.forms[0].rtv_allowed_yn.checked = false;
			document.forms[0].prt_allowed_yn.disabled = true;
			document.forms[0].prt_allowed_yn.checked = false;
			document.forms[0].mfg_allowed_yn.disabled = true;
			document.forms[0].mfg_allowed_yn.checked = false;
			document.forms[0].iss_allowed_yn.disabled = true;
			document.forms[0].iss_allowed_yn.checked = false;
			document.forms[0].urg_allowed_yn.disabled = true;
			document.forms[0].urg_allowed_yn.checked = false;
			document.forms[0].tfr_allowed_yn.disabled = true;
			document.forms[0].tfr_allowed_yn.checked = false;
			document.forms[0].adj_allowed_yn.disabled = true;
			document.forms[0].adj_allowed_yn.checked = false;
			document.forms[0].var_allowed_yn.disabled = true;
			document.forms[0].var_allowed_yn.checked = false;
			document.forms[0].obs_allowed_yn.disabled = true;
			document.forms[0].obs_allowed_yn.checked = false;
			document.forms[0].split_batch_allowed_yn.disabled = true;
			document.forms[0].split_batch_allowed_yn.checked = false;
			document.forms[0].bin_change_allowed_yn.disabled = true;
			document.forms[0].bin_change_allowed_yn.checked = false;
		} else {
			document.forms[0].mfg_allowed_yn.disabled = false;
			document.forms[0].iss_allowed_yn.disabled = false;
			document.forms[0].urg_allowed_yn.disabled = false;
			document.forms[0].tfr_allowed_yn.disabled = false;
			document.forms[0].adj_allowed_yn.disabled = false;
			document.forms[0].var_allowed_yn.disabled = false;
			document.forms[0].prt_allowed_yn.disabled = false;
			document.forms[0].obs_allowed_yn.disabled = false;
			document.forms[0].split_batch_allowed_yn.disabled = false;
			document.forms[0].bin_change_allowed_yn.disabled = false;
			document.forms[0].grn_allowed_yn.disabled = false;
			document.forms[0].rtv_allowed_yn.disabled = false;
			document.forms[0].authorize_spl_req_yn.disabled = false;
			document.forms[0].stock_item_cons_yn.disabled = false;
		}
	}
}
async function searchCodeBinLocation(obj,obj1){

	//var sql_store = "select BIN_LOCATION_CODE code , SHORT_DESC Description from MM_BIN_LOCATION_lang_vw where EFF_STATUS='E' and upper (SHORT_DESC) like upper(?) and upper(BIN_LOCATION_CODE) like upper(?) and store_code="; 
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~STORE_ID`";
	parNameArray[1] ="~LOCALE_ID`";
	parValueArray[0]=obj1.value;
	parValueArray[1]=document.forms[0].language_id.value;
	
	//argumentArray[0] = sql_store+"'"+obj1.value+"'"+" and language_id="+"'"+document.forms[0].language_id.value+"'";
	argumentArray[0] ="";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";           //#Inc no:27191  on 23/11/11
	argumentArray[5] = "";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	
	argumentArray[12]  = "SQL_ST_STORE_BINLOCATION_LOOKUP_SELECT";
	argumentArray[13]  = "eST.Common.StRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	
	returnedValues = await CommonLookup(getLabel("Common.BinLocation.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "" && returnedValues!=undefined )) {
		document.forms[0].bin_loc_desc.value = returnedValues[1];
		document.forms[0].bin_loc_code.value=returnedValues[0];
		}

}
//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
function checkRecordsForIssue(obj){
	if(obj.checked == false && document.formStore.records_exist_for_issue.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForIssueReturn(obj){
	if(obj.checked == false && document.formStore.records_exist_for_issueReturn.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
function checkRecordsForStockTransfer(obj){
	if(obj.checked == false && document.formStore.records_exist_Stock_transfer.value=="Y"){
		alert(getMessage("UNFINALIZED_TRN_EXITS_ST_PARAM","ST"));
		obj.checked = true;
		obj.value = "Y";
	}
}
//Added for IN:071344 start
function enableConPeriod(obj){
if(obj.checked == false )
{
	document.formStore.consm_freq_days.disabled=true;
	document.formStore.all.span2.style.visibility="hidden";
}
else
{	
	document.formStore.all.span2.style.visibility="visible";
	document.formStore.consm_freq_days.disabled=false;
}
}
function checkIntegerFormat(obj, zeroNotAllowed) {
	if (zeroNotAllowed == null) {
		zeroNotAllowed = true;
	}
	if (obj.value == "") {
		return;
	}
	if (!isValidIntegerFormat(obj)) {
		alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
		obj.select();
		obj.focus();
		return false;
	} else {
		if ((obj.value) == 0 || (obj.value > 90)) {
			alert(getMessage("INVALID_CON_PERIOD", "ST"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	return true;
}
function isValidConPeriod(obj) {
	  if(obj.value > 90){
		  alert(getMessage("INVALID_CON_PERIOD", "ST"));
			obj.value="";
			obj.focus();
			return false; 
	  }
}
//Added for IN:071344 end
