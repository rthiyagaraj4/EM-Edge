
var message = ""; 
var result = true;
var dummy_chk = null;
var prevObj = null;
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ParentStoreForStoreFrames.jsp?mode=" + MODE_INSERT;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/ParentStoreForStoreQueryCriteria.jsp?function_id=" + function_id;
}
function reset() {
	f_query_add_mod.location.reload();
}
function searchDetails() {
	var store_code = document.forms[0].store_code.value;
	var store_desc = document.forms[0].store_desc.value;
	var mode = document.forms[0].mode.value;
	var formObj = document.forms[0];
	var mode = formObj.mode.value;
	var messageFrame = parent.parent.frames[2];
	var error_page = "../../eCommon/jsp/error.jsp";
	var fields = new Array(formObj.store_desc);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	if (checkSTFields(fields, names, messageFrame)) {
		if (document.forms[0].store_result.value == "done") {
			document.forms[0].store_desc.disabled = true;
			document.forms[0].searchStore.disabled = true;
			parent.parentStoreFrame.location.href = "../../eST/jsp/ParentStoreForStorePStores.jsp?store_code=" + store_code + "&mode=" + mode;
			//parent.frames[2].location.href="../../eST/jsp/ParentStoreForStoreAddModifyDetail.jsp?store_code="+store_code+"&parent_store_code="+parent_store_code+"&store_desc="+store_desc+"&parent_store_desc="+parent_store_desc+"&mode="+mode;
		} else {
			if (document.forms[0].store_result.value == "error") {
				alert(getMessage("INVALID_STORE_CODE", "ST"));
				document.forms[0].store_desc.value = "";
				document.forms[0].store_desc.focus();
				return;
			}
		}
	}
}
async function searchStoreDetails(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=document.forms[0].p_language_id.value;
	
//	var sql_st_parent_store = "SELECT MM.STORE_CODE CODE , MM.LONG_DESC  DESCRIPTION FROM MM_STORE_LANG_VW  MM WHERE  MM.EFF_STATUS = 'E'  AND UPPER(MM.STORE_CODE) LIKE UPPER(?) AND UPPER(MM.LONG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = '"+ document.forms[0].p_language_id.value +"' ";
//	argumentArray[0] = document.forms[0].SQL_ST_PARENT_STORE_STORE_LOOKUP.value + "'" + document.forms[0].p_language_id.value + "'";
//	argumentArray[0] =  sql_st_parent_store; 
	argumentArray[0] = "";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	argumentArray[12]  = "SQL_ST_PARENTSTORE_FOR_STORE_LOOKUP_SELECT";
	argumentArray[13]  = "eST.Common.StRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	
	
	returnedValues =await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	var arr=ret1.split(",");
    if(arr[1]== undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
async function searchParentStoreDetails(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "MM.STORE_CODE";
	dataValueArray[0] = document.forms[0].store_code.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP.value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
    var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	}
}
function checkedValue(str) {
	if (str == "Y") {
		return MODE_MODIFY;
	} else {
		return MODE_INSERT;
	}
}
function check_Status(index, obj) {
	if (obj.checked == true) {
		obj.value = "E";
	} else {
		if (obj.checked == false) {
			obj.value = "D";
		}
	}
}

function apply() {
	if(f_query_add_mod.headerFrame==undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
	return;
	}
	var formObj =f_query_add_mod.headerFrame.document.formParentAddModify;
	var fields = new Array(formObj.store_desc);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var msg1;
	if (!checkSTFields(fields, names, messageFrame)) {
		return;
	}
	var formObj1 = f_query_add_mod.modifyFrame.document.formStoreDetail;
	if (formObj1 != null) {
		if (!lastCheck(formObj1, formObj1.parent_store_code.value)) {
			msg = getMessage("MIN_ONE_ITEM_CLASS_REQUIRED", "ST");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
			return;
		}
	}
	formObj1 = f_query_add_mod.parentStoreFrame.document.formParentStoreDetail;
	if (!eval(formObj1.count.value) > 0) {
		msg = getMessage("MIN_ONE_ITEM_REQD", "ST");
		msg = msg.replace("Item", " ");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
		return;
	}
	var responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	if (result) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
		onSuccess();
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
	}
}
function onSuccess1() {
	f_query_add_mod.location.href = "../../eST/jsp/ParentStoreForStoreFrames.jsp?mode=" + MODE_INSERT;
}
function onSuccess() {
	f_query_add_mod.location.reload();
}
function assignResult(_result, _message, _flag) {
	result = _result;
	message = _message;
	flag = _flag;
}
function Modify(obj) {
	var store_code = obj.cells[0].innerText;
	var store_desc = obj.cells[1].innerText;
	var parent_store_code = obj.cells[2].innerText;
	var parent_store_desc = obj.cells[3].innerText;
	var item_class_code = obj.cells[4].innerText;
	parent.frames[1].location.href = "../../eST/jsp/ParentStoreForStoreFrames.jsp?mode=" + MODE_MODIFY + "&store_code=" + store_code + "&store_desc=" + store_desc + "&parent_store_code=" + parent_store_code + "&parent_store_desc=" + parent_store_desc + "&item_class_code=" + item_class_code;
}
function set_Status(index, obj) {
	if (obj.checked == true) {
		obj.value = "E";
		document.forms[0].index.value = eval(document.forms[0].index.value) + 1;
	} else {
		if (obj.checked == false) {
			obj.value = "D";
			document.forms[0].index.value = eval(document.forms[0].index.value) - 1;
		}
	}
	if (eval(document.forms[0].total_index.value) == (eval(document.forms[0].index.value))) {
		document.forms[0].select_all.checked = true;
	} else {
		document.forms[0].select_all.checked = false;
	}
}
function selectCheck(cnt) {
	count = cnt;
	formName = parent.frames[2].document.forms[0].name;
	chk_sel = parent.frames[2].document.forms[0].select_all.checked;
	var cnt = parent.frames[2].document.forms[0].total_index.value;
	if (chk_sel == true) {
		for (i = 0; i < cnt; i++) {
			eval(document.getElementById("eff_status_" + i)).checked = true;
			eval(document.getElementById("eff_status_" + i)).value = "E";
		}
	} else {
		for (i = 0; i < cnt; i++) {
			eval(parent.frames[2].document.forms[0].document.getElementById("eff_status_" + i)).checked = false;
			eval(parent.frames[2].document.forms[0].document.getElementById("eff_status_" + i)).value = "D";
		}
	}
}
function checkStores() {
	var bean_id = document.forms[0].bean_id.value;
	var bean_name = document.forms[0].bean_name.value;
	var store_code = document.forms[0].store_code.value;
	var store_desc = document.forms[0].store_desc.value;
	var parent_store_code = "";
	var parent_store_desc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlString = getXMLString(null); 
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ParentStoreForStoreValidate.jsp?validate=STORE_DESC" + "&store_desc=" + store_desc + "&store_code=" + store_code + "&bean_name=" + bean_name + "&bean_id=" + bean_id + "&parent_store_code=" + parent_store_code + "&parent_store_desc=" + parent_store_desc, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}
function setResult() {
	document.forms[0].store_result.value = "done";
}
function setResultNo() {
	document.forms[0].store_result.value = "error";
}
function dispItemClass(obj, parent_store_code, parent_store_desc, p, obj1) {
	var bean_id = document.forms[0].bean_id.value;
	var bean_name = document.forms[0].bean_name.value;
	var store_code = parent.frames[0].document.forms[0].store_code.value;
	var store_desc = parent.frames[0].document.forms[0].store_desc.value;
	var mode = parent.frames[0].document.forms[0].mode.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	if (obj.checked == true) {
		//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.cursor = "hand";
		eval(document.getElementById("td_" + p)).style.cursor = "hand";
		//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.color = "blue";
		eval(document.getElementById("td_" + p)).style.color = "blue";
		parent.frames[1].document.forms[0].count.value = eval(parent.frames[1].document.forms[0].count.value) + 1;
	}
	if ((eval(document.getElementById("td_" + p)).style.color) == "") {
		return;
	}
	var formObj1 = parent.modifyFrame.document.forms[0];
	if (formObj1 != null) {
		var tot_item_class = formObj1.total_index.value;
		var count = 0;
		for (var i = 0; i < tot_item_class; i++) {
			if (eval("formObj1.eff_status_" + i).checked == true) {
				count = 1;
				break;
			}
		}
		if (count == 0) {
			if (obj.checked == false) {
				//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.cursor = "";
				eval(document.getElementById("td_" + p)).style.cursor = "";
				//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.color = "";
				eval(document.getElementById("td_" + p)).style.color = "";
				xmlDom.loadXML(getXMLString(null));
				xmlHttp.open("POST", "../../eST/jsp/ParentStoreForStoreValidate.jsp?validate=DELETERECORD" + "&bean_name=" + bean_name + "&bean_id=" + bean_id + "&parent_store_code=" + parent_store_code, false);
				xmlHttp.send(xmlDom);
				responseText = xmlHttp.responseText;
				eval(responseText);
			}
			if (dummy_chk != p) {
				if (obj.checked == true && obj1 != null) {
					alert(getMessage("MIN_ONE_ITEM_CLASS_REQUIRED", "ST"));
					obj.checked = false;
					//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.cursor = "";
					//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.color = "";
					eval(document.getElementById("td_" + p)).style.cursor = "";
					eval(document.getElementById("td_" + p)).style.color = "";
				}
				if (obj1 == null) {
					alert(getMessage("MIN_ONE_ITEM_CLASS_REQUIRED", "ST"));
				}
				//changeRowColor(eval(parent.frames[1].document.forms[0].document.getElementById("tr_" + dummy_chk)),2);
				changeRowColor(eval(document.getElementById("tr_" + dummy_chk)),2);
				return;
			}
		}
		frmObj = formObj1.document.forms[0];
		var arrObj = frmObj.elements;
		var frmObjs = new Array();
		if (frmObj.name == null) {
			frmObjs = frmObj;
		} else {
			frmObjs[0] = frmObj;
		}
		var xmlString = "<root><SEARCH ";
		for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
			frmObj = frmObjs[frmCount];
			var arrObj = frmObj.elements;
			for (var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					if (arrObj[i].checked) {
						arrObj[i].value = "Y";
						val = arrObj[i].value;
					} else {
						arrObj[i].value = "N";
						val = arrObj[i].value;
					}
				} else {
					if (arrObj[i].type == "radio") {
						if (arrObj[i].checked) {
							val = arrObj[i].value;
						}
					} else {
						if (arrObj[i].type == "select-multiple") {
							for (var j = 0; j < arrObj[i].options.length; j++) {
								if (arrObj[i].options[j].selected) {
									val += arrObj[i].options[j].value + "~";
								}
							}
							val = val.substring(0, val.lastIndexOf("~"));
						} else {
							val = arrObj[i].value;
						}
					}
				}
				val = checkSpl(val);
				xmlString += arrObj[i].name + "=\"" + val + "\" ";
			}
		}
		xmlString += " /></root>";
		xmlDom.loadXML(xmlString);
		xmlHttp.open("POST", "../../eST/jsp/ParentStoreForStoreValidate.jsp?validate=REFRESHDETAIL&parent_store_code=" + parent.parentStoreFrame.document.formParentStoreDetail.prev_parent_store.value + "&bean_name=" + bean_name + "&bean_id=" + bean_id + "&tot_item_class=" + tot_item_class, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	if (obj.checked == false) {
		//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.cursor = "";
		eval(document.getElementById("td_" + p)).style.cursor = "";
		//eval(parent.frames[1].document.forms[0].document.getElementById("td_" + p)).style.color = "";
		eval(document.getElementById("td_" + p)).style.color = "";
		parent.frames[1].document.forms[0].count.value = eval(parent.frames[1].document.forms[0].count.value) - 1;
		xmlDom.loadXML(getXMLString(null));
		xmlHttp.open("POST", "../../eST/jsp/ParentStoreForStoreValidate.jsp?validate=DELETERECORD" + "&bean_name=" + bean_name + "&bean_id=" + bean_id + "&parent_store_code=" + parent_store_code, false);
		xmlHttp.send(xmlDom);
		responseText = xmlHttp.responseText;
		eval(responseText);
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		return;
	}
	//alert(document.getElementById("tr_" + p));
	//trobj = eval(parent.frames[1].document.forms[0].document.getElementById("tr_" + p));
	trobj = eval(document.getElementById("tr_" + p));
	changeRowColor(trobj, 2);
	dummy_chk = p;
	parent.parentStoreFrame.document.formParentStoreDetail.prev_parent_store.value = parent_store_code;
	parent.frames[2].location.href = "../../eST/jsp/ParentStoreForStoreAddModifyDetail.jsp?store_code=" + store_code + "&parent_store_code=" + parent_store_code + "&store_desc=" + encodeURIComponent(store_desc) + "&parent_store_desc=" + encodeURIComponent(parent_store_desc) + "&mode=" + MODE_MODIFY + "&store_index=" + p;
}
function lastCheck(formObj1, parent_store) {
	var bean_id = formObj1.bean_id.value;
	var bean_name = formObj1.bean_name.value;
	//xmlDom = new ActiveXObject("Microsoft.XMLDom");
	//xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	var xmlString = getXMLString(null);  
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	if (formObj1 != null) {
		var tot_item_class = formObj1.total_index.value;
		var count = 0;
		for (var i = 0; i < tot_item_class; i++) {
			if (eval("formObj1.eff_status_" + i).checked == true) {
				count = 1;
				break;
			}
		}
		if (count == 0) {
				return false;
		}
		//frmObj = formObj1.document.forms[0];
		frmObj = f_query_add_mod.modifyFrame.document.forms[0];
		var arrObj = frmObj.elements;
		var frmObjs = new Array();
		if (frmObj.name == null) {
			frmObjs = frmObj;
		} else {
			frmObjs[0] = frmObj;
		}
		var xmlString = "<root><SEARCH ";
		for (var frmCount = 0; frmCount < frmObjs.length; frmCount++) {
			frmObj = frmObjs[frmCount];
			var arrObj = frmObj.elements;
			for (var i = 0; i < arrObj.length; i++) {
				var val = "";
				if (arrObj[i].type == "checkbox") {
					if (arrObj[i].checked) {
						arrObj[i].value = "Y";
						val = arrObj[i].value;
					} else {
						arrObj[i].value = "N";
						val = arrObj[i].value;
					}
				} else {
					if (arrObj[i].type == "radio") {
						if (arrObj[i].checked) {
							val = arrObj[i].value;
						}
					} else {
						if (arrObj[i].type == "select-multiple") {
							for (var j = 0; j < arrObj[i].options.length; j++) {
								if (arrObj[i].options[j].selected) {
									val += arrObj[i].options[j].value + "~";
								}
							}
							val = val.substring(0, val.lastIndexOf("~"));
						} else {
							val = arrObj[i].value;
						}
					}
				}
				val = checkSpl(val);
				xmlString += arrObj[i].name + "=\"" + val + "\" ";
			}
		}
		xmlString += " /></root>";
		//xmlDom.loadXML(xmlString);
		xmlHttp.open("POST", "../../eST/jsp/ParentStoreForStoreValidate.jsp?validate=REFRESHDETAIL&parent_store_code=" + parent_store + "&bean_name=" + bean_name + "&bean_id=" + bean_id + "&tot_item_class=" + tot_item_class, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	return true;
}
function changeRowColor(obj, n) {
	if (prevObj != null) {
		for (k = 0; k < n; k++) {
			prevObj.cells[k].className = prevColor;
		}
	}
	prevObj = obj;
	//alert(obj.cells[0].className);
	prevColor = obj.cells[0].className;
	for (k = 0; k < n; k++) {
		//alert(obj.cells[k].className);
		obj.cells[k].className = "STLIGHTPINK";
	}
}

