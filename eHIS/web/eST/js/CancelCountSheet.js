
var flag = true;
var count = 1;
function reset() {
	f_query_add_mod.location.reload();
}
async function searchCodeItem(obj) {
	//alert(document.forms[0].store_code.value);
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
//var sql_3=unescape("Select st.item_code code,	mm.short_desc description FROM mm_item_lang_vw mm, st_item st  WHERE    mm.eff_status =	'E'	AND	 st.item_code = mm.item_code  AND  upper(st.item_code)  LIKE UPPER(?)  AND upper(mm.short_desc)	LIKE  upper(?)  AND  mm.language_id='"+locale+"'  order by 2");
//sql=document.forms[0].SQL_ST_ITEM_LOOKUP_LANG.value+"  "+"AND mm.language_id='"+locale+"'"+"  "+"order by 2";
	//var sql = "SELECT DISTINCT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW MM, ST_ITEM ST, ST_ITEM_STORE STSTR,ST_ITEM_TRN_DTL TRN WHERE STSTR.STOCK_ITEM_YN = 'Y' AND MM.EFF_STATUS = 'E' AND STSTR.STORE_CODE = '"+document.forms[0].store_code.value+"' AND ST.ITEM_CODE LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND ST.ITEM_CODE = MM.ITEM_CODE AND STSTR.PHY_INV_ID IS NULL AND STSTR.ITEM_CODE = ST.ITEM_CODE AND MM.LANGUAGE_ID = '" + document.forms[0].language_id.value + "'AND TRN.ITEM_CODE = STSTR.ITEM_CODE AND TRN.STORE_CODE = STSTR.STORE_CODE";
	//Added By Sakti Sankar against inc#28630
	var sql = "SELECT DISTINCT ST.ITEM_CODE CODE, MM.SHORT_DESC DESCRIPTION FROM MM_ITEM_LANG_VW MM, ST_ITEM ST, ST_ITEM_STORE STSTR,ST_ITEM_TRN_DTL TRN WHERE STSTR.STOCK_ITEM_YN = 'Y' AND MM.EFF_STATUS = 'E' AND STSTR.STORE_CODE = '"+document.forms[0].store_code.value+"' AND ST.ITEM_CODE LIKE UPPER (?) AND UPPER (MM.SHORT_DESC) LIKE UPPER (?) AND ST.ITEM_CODE = MM.ITEM_CODE AND STSTR.PHY_INV_ID = '"+document.forms[0].phy_inv_id.value+"' AND STSTR.ITEM_CODE = ST.ITEM_CODE AND MM.LANGUAGE_ID = '" + document.forms[0].language_id.value + "'AND TRN.ITEM_CODE = STSTR.ITEM_CODE AND TRN.STORE_CODE = STSTR.STORE_CODE";
	argumentArray[0] = unescape(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
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
function selectCheck(cnt) {
	count = cnt;
	formName = parent.frames[1].document.forms[0].name;
	chk_sel = parent.frames[1].document.forms[0].item_chk.checked;
	//	alert(parent.frames[1].document.forms[0].document.getElementById("t1").checked);
	
	if (chk_sel == true) {
		for (i = 0; i < cnt; i++) {
			parent.frames[1].document.getElementById("t"+i).checked = true;
		}
	} else {
		for (i = 0; i < cnt; i++) {
			parent.frames[1].document.getElementById("t"+i).checked = false;
		}
	}
}
function getStoreName(phy_id) {
	
	var phy_id = phy_id.value;

	var formObj = document.formCancelCountSheetQueryCriteria;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	//xmlDoc.loadXML(getXMLString(null));
	var xmlStr = getXMLString(null);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/CancelCountSheetStoreValidate.jsp?phy_id=" + phy_id, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
     
	//Added By Sakti Sankar against Inc#28630
	if(phy_id != "") {
		
	formObj.item_code.disabled = false;
	formObj.p_fm_sr2.disabled = false;
	}
	else{
	formObj.item_code.disabled = true;
	formObj.p_fm_sr2.disabled = true;
	}
	eval( responseText);
	//Added ends
} 
function searchResults(formObj) {
	parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
	var phy_inv_id = formObj.phy_inv_id.options[formObj.phy_inv_id.selectedIndex].value;
	if (phy_inv_id == "") {
		flag = false;
	} else {
		flag = true;
	}
	var store_code = formObj.store_code.options[formObj.store_code.selectedIndex].value;
	var item_code = formObj.item_code.value;
	if (flag == true) {
		parent.frames[1].location.href = "../../eST/jsp/CancelCountSheetQueryResult.jsp?validate=STORE&store_code=" + store_code + "&item_code=" + item_code + "&phy_inv_id=" + phy_inv_id;
	} else {
		checkField(formObj.phy_inv_id, getLabel("eST.PhyInventoryID.label", "ST"));
			//parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=Physical Inv ID Madatory";
	}
}
function apply() {
//	var formobject=f_query_add_mod.frames[1].formCancelCountSheetQueryResult;
	//var formobject=f_query_add_mod.result.formCancelCountSheetQueryResult.count.value;
	
	/*	if(!proceedOnApply())
		{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	        return false;
		}
	*/
	if (proceedOnApply()) {
		count = f_query_add_mod.frames[1].formCancelCountSheetQueryResult.count.value;
		//formObj=parent.frames[1].frames[1].frames[1].document.forms[0];
		formObj = f_query_add_mod.frames[1].formCancelCountSheetQueryResult;
		//var s=eval("parent.frames[1].document.forms[0].document.getElementById("t")"+i).checked;
		var alertchk = 0;
		var forInserting = "";
		var canProcess = 0;
		for (i = 0; i < count; i++) {
			if (f_query_add_mod.frames[1].document.getElementById("t"+ i).checked) {
				forInserting += "Y,";
				alertchk++;
			} else {
				canProcess++;
				forInserting += "N,";
			}
		}
	
		if (alertchk > 0) {
			f_query_add_mod.frames[1].formCancelCountSheetQueryResult.checkBoxVals.value = forInserting;
			forInserting = forInserting.substring(0, forInserting.length - 1);
			var xmlHttp = new XMLHttpRequest();
			xmlStr = getEnhancedXMLString(formObj);
			xmlDoc= new DOMParser().parseFromString(xmlStr, "text/xml");
			var responseText = formApply(formObj, ST_CONTROLLER);
			eval(responseText);
			if (result) {
				if (message == "RECORD_DELETED<BR>" || message == "RECORD_INSERTED<BR>" || message == "RECORD_MODIFIED<BR>") {
					message = "RECORD_DELETED";
					message = getMessage(message, "ST");
				}
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + message;
				onSuccess();
			} else {
				message = "";
			//messageFrame.location.href = errorPage+"?err_num="+ message;
				return false;
			}
		} else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
		}
	} else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("MIN_ONE_DETAIL_REQUIRED", "Common");
	}
}
function onSuccess() {
	f_query_add_mod.document.location.reload();
}
function proceedOnApply() {
	var url = f_query_add_mod.frames[1].location.href;
	url = url.toLowerCase();
	if ((url.indexOf("blank.html") == -1) && (url.indexOf("drugcategoryquery") == -1)) {
		return true;
	} else {
		return false;
	}
}

