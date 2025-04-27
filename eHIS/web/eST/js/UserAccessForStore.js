/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
26/04/2016				56060				Badmavathi B					  PMG2015-CRF-INT-ST-0001(Use 'Authorize at Issue Store' privilege to Authorize)		
20/10/2021  			TFS:24105			Shazana																	MOHE-SCF-0162		
12/04/2022  			TFS:30369			Mohamed																	MO-CRF-20177		
28/04/2022  			TFS:29303			Mohamed																	MO-CRF-20174
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj = null;
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + MODE_INSERT + "&function_id=" + function_id;
}
function query() {
	f_query_add_mod.location.href = "../../eST/jsp/UserAccessForStoreQueryCriteria.jsp?function_id=" + function_id;
}
function onSuccess() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	f_query_add_mod.UserForStoreHeaderFrame.location.reload();
	f_query_add_mod.UserForStoreListFrame.location.href = "../../eCommon/html/blank.html";
}
function onSuccess1() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
	//f_query_add_mod.UserForStoreHeaderFrame.location.reload();
	//f_query_add_mod.UserForStoreListFrame.location.reload();//href = "../../eCommon/html/blank.html";
}

function reset() {
	//f_query_add_mod.location.reload(); //Commented by Rabbani #43779 on 04-OCT-2013
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	} else {
	     if(f_query_add_mod.UserForStoreHeaderFrame != undefined){ //Added by Rabbani #43779 on 04-OCT-2013
		if (f_query_add_mod.UserForStoreHeaderFrame.document.Search_form != null) {
			f_query_add_mod.location.reload();
		} else {
			clearDetails();
		}
	  }
	}
}
function clearDetails() {
	f_query_add_mod.UserForStoreListFrame.location.href = "../../eCommon/html/blank.html";
}
async function searchCode(target) {
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=document.forms[0].language_id.value;
	
	//var sql = document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value + "'" + document.forms[0].language_id.value + "'";
	//var sql ="SELECT appl_user_id code,	appl_user_name  description FROM sm_appl_user_lang_vw sm_appl_user where  eff_status='E' AND appl_user_id like UPPER(?) AND UPPER(appl_user_name)	like  UPPER(?) AND language_id = '"+document.forms[0].language_id.value +"' ";
	var sql ="";
	if (target.name == "user_name") {
	//	argumentArray[0]							=		document.forms[0].SQL_ST_USER_LOOKUP_USERACCESS.value
		argumentArray[0] = sql;
		argumentArray[4] = "1,2"; 
//		argumentArray[4]							=		"2,3"; 
	}
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	argumentArray[12]  = "SQL_ST_USER_ACCESS_FOR_USER_LOOKUP_SELECT";
	argumentArray[13]  = "eST.Common.StRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	
	var retVal = "" ;
	if (target.name == "user_name") {
		if (!document.forms[0].user_name.readOnly) {
			retVal = await CommonLookup(getLabel("Common.user.label", "Common"), argumentArray);
		} else {
			retVal = "";
		}
	}
	var ret1=unescape(retVal);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
 	
	if (retVal != null && retVal != "") {
		target.value = arr[1];
		if (target.name == "user_name") {
			document.forms[0].user_id.value = arr[0];
			document.forms[0].userIdSearch.disabled = true;
			document.forms[0].user_name.readOnly = true;
		}
	}
}
function searchDetails() {
	top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = parent.UserForStoreHeaderFrame.document.forms[0];
	var errorPage = "../../eCommon/jsp/error.jsp";
	var user_id = formObj.user_id.value;
	var store_code = formObj.store_name.value;
	var dflt_item_search = formObj.dflt_item_search.value;
	var dflt_sal_type = formObj.dflt_sal_type.value;  // Added by Padmapriya
	var disp_curr_enc_findtl_yn = formObj.disp_curr_enc_findtl_yn.value;  //Added by suresh.r 12-11-2013 against JD-CRF-156
	if (user_id == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("USER_SEARCH_MANDATORY", "ST");
		return;
	}
	if (store_code == "") {
		parent.parent.messageFrame.location.href = errorPage + "?err_num=" + getMessage("STORE_CANNOT_BE_BLANK", "ST");
		return;
	}
	var messageFrame = top.content.messageFrame;
	var fields = new Array(formObj.user_name, formObj.store_name);
	var names = new Array(getLabel("Common.user.label", "Common"), getLabel("Common.Store.label", "Common"));
	var blankObject = null;
	blankObject = checkSTFields(fields, names, messageFrame, errorPage);
	if (blankObject == true) {
		//parent.UserForStoreListFrame.location.href = "../../eST/jsp/UserAccessForStoreDetail.jsp?user_id=" + user_id + "&store_code=" + store_code + "&mode=" + MODE_MODIFY+ "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type;//Commented by suresh.r 12-11-2013 against JD-CRF-156
		//parent.UserForStoreListFrame.location.href = "../../eST/jsp/UserAccessForStoreDetail.jsp?user_id=" + user_id + "&store_code=" + store_code + "&mode=" + MODE_MODIFY+ "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;//Added  by suresh.r 12-11-2013 against JD-CRF-156
		parent.UserForStoreListFrame.location.href = "../../eST/jsp/UserAccessForStoreDetail.jsp?user_id=" + user_id + "&store_code=" + store_code + "&mode=" + MODE_MODIFY+ "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;
		document.getElementById('trhidden').style="";
		//Commented by suresh.r on 07-05-2014 against #48871(MO-GN-5447)
		//document.Search_form.all.trhidfindtl.style.visibility="visible";//Added by suresh.r 12-11-2013 against JD-CRF-156
	}
}
function apply() {
	var messageFrame = top.content.messageFrame;
	if (f_query_add_mod.UserForStoreHeaderFrame.Search_form.mode.value == MODE_INSERT) {
		var user_id = f_query_add_mod.UserForStoreHeaderFrame.document.forms[0].user_id.value;
		var store_code = f_query_add_mod.UserForStoreHeaderFrame.document.forms[0].store_name.value;
		var fields = new Array(f_query_add_mod.UserForStoreHeaderFrame.document.forms[0].user_name, f_query_add_mod.UserForStoreHeaderFrame.document.forms[0].store_name);
		var names = new Array(getLabel("Common.user.label", "Common"), getLabel("Common.Store.label", "Common"));
		var errorPage = "../../eCommon/jsp/error.jsp";
		var blankObject = null;
		blankObject = checkSTFields(fields, names, messageFrame, errorPage);
		if (blankObject == true) {
			var formObj = f_query_add_mod.UserForStoreListFrame.document.UserAccessForStoreListForm;				
			responseText = formApply(formObj, ST_CONTROLLER);
			responseText = responseText.replace(/<[^>]*>/g, '');
			eval(responseText);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
			if (result) {
				onSuccess();
			}
		}
	}
	if (f_query_add_mod.UserForStoreHeaderFrame.Search_form.mode.value == MODE_MODIFY) {
		var formObj = f_query_add_mod.UserForStoreListFrame.document.UserAccessForStoreListForm;	
		responseText = formApply(formObj, ST_CONTROLLER);
		responseText = responseText.replace(/<[^>]*>/g, '');
		eval(responseText);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
		if (result) {
			onSuccess1();
		}
	}
}
//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
/*
 function Modify1(obj) {
	var user_id = obj.cells[0].innerText;
	var user_name = obj.cells[1].innerText;
	var store_code = obj.cells[2].innerText;
	var store_desc = escape(obj.cells[3].innerText);
	var dflt_item_search = obj.cells[63].innerText;//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
	var dflt_sal_type = obj.cells[64].innerText;//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
	var disp_curr_enc_findtl_yn = obj.cells[65].innerText;//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
	document.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&store_code=" + store_code + "&store_desc=" + store_desc + "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;//Added by suresh.r 12-11-2013 against JD-CRF-156
}
function Modify(obj) {
	var user_id = obj.cells[0].innerText;
	var user_name = obj.cells[1].innerText;
	var store_code = obj.cells[2].innerText;
	var store_desc = escape(obj.cells[3].innerText);
	//var dflt_item_search = obj.cells[60].innerText;
	var dflt_item_search = obj.cells[61].innerText; //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
	//var dflt_sal_type = obj.cells[61].innerText;   
	var dflt_sal_type = obj.cells[62].innerText;  // Added by Padmapriya	
	//var disp_curr_enc_findtl_yn = obj.cells[62].innerText;//Added by suresh.r 12-11-2013 against JD-CRF-156
	var disp_curr_enc_findtl_yn = obj.cells[63].innerText;//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
	//document.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&store_code=" + store_code + "&store_desc=" + store_desc + "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type;//Commented by suresh.r 12-11-2013 against JD-CRF-156
	document.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&store_code=" + store_code + "&store_desc=" + store_desc + "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;//Added by suresh.r 12-11-2013 against JD-CRF-156
}
 */

function Modify1(obj) {
	var formObj=document.QueryResult;
	var interface_to_external_po_yn = formObj.interface_to_external_po_yn.value;
	var user_id = obj.cells[0].innerText;
	var user_name = obj.cells[1].innerText;
	var store_code = obj.cells[2].innerText;
	var store_desc = obj.cells[3].innerText;//escape removed for ARYU-SCF-0011
	if(interface_to_external_po_yn == "Y"){
		var dflt_item_search = obj.cells[66].innerText; 
		var dflt_sal_type = obj.cells[67].innerText;
		var disp_curr_enc_findtl_yn = obj.cells[68].innerText;
	}
	else{
		var dflt_item_search = obj.cells[63].innerText;
		var dflt_sal_type = obj.cells[64].innerText;
		var disp_curr_enc_findtl_yn = obj.cells[65].innerText;
	}

	document.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&store_code=" + store_code + "&store_desc=" + store_desc + "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;//Added by suresh.r 12-11-2013 against JD-CRF-156
}
function Modify(obj) {
	var formObj=document.QueryResult;
	var interface_to_external_po_yn = formObj.interface_to_external_po_yn.value;
	var user_id = obj.cells[0].innerText;
	var user_name = obj.cells[1].innerText;
	var store_code = obj.cells[2].innerText;
	var store_desc = obj.cells[3].innerText; //escape removed for ARYU-SCF-0011
	if(interface_to_external_po_yn == "Y"){
		var dflt_item_search = obj.cells[64].innerText;
		var dflt_sal_type = obj.cells[65].innerText;
		var disp_curr_enc_findtl_yn = obj.cells[66].innerText;
		}
	else{
		var dflt_item_search = obj.cells[61].innerText;
		var dflt_sal_type = obj.cells[62].innerText;
		var disp_curr_enc_findtl_yn = obj.cells[63].innerText;
	}
	//encodeURIComponent added for store_desc ARYU-SCF-0011
	document.location.href = "../../eST/jsp/UserAccessForStoreMain.jsp?mode=" + parent.MODE_MODIFY + "&function_id=" + parent.function_id + "&user_id=" + user_id + "&user_name=" + user_name + "&store_code=" + store_code + "&store_desc=" +encodeURIComponent(store_desc,"UTF-8") + "&dflt_item_search=" + dflt_item_search+ "&dflt_sal_type=" + dflt_sal_type+ "&disp_curr_enc_findtl_yn=" + disp_curr_enc_findtl_yn;//Added by suresh.r 12-11-2013 against JD-CRF-156
}
//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
function checkfinalizeapplicable(tran_app, final_app,ack_yn,con_yn,dele_yn,final_prompt_yn) {
	if (tran_app.checked == false) {
		final_app.checked = false;
		final_app.disabled = true;
		final_app.value = "N";
		final_prompt_yn.checked = false;
		final_prompt_yn.disabled = true;
		final_prompt_yn.value = "N";
		if(ack_yn!=undefined){
			ack_yn.checked = false;
			con_yn.checked = false;
			ack_yn.disabled = true;
			con_yn.disabled = true;
			con_yn.value = "N";
			con_yn.value = "N";
		}
			dele_yn.disabled = true;
			dele_yn.value = "N";
			dele_yn.checked = false;
	} else {
		final_app.disabled = false;
		final_prompt_yn.disabled = true;
		if(ack_yn!=undefined){
			ack_yn.disabled = false;
			con_yn.disabled = false;
		}
			dele_yn.disabled = false;
	}
}

function setValue(obj)
{
	//alert("obj.checked===>"+obj.checked+"=obj.value===>"+obj.value);
	if(obj.checked)
		obj.value="Y";
	else
		obj.value="N";
}

function validateFinilize(obj){

var formObj=document.UserAccessForStoreListForm;
if(formObj.interface_to_external_po_yn.value=="Y"){
if(obj.checked==true){
formObj.prq_finalize_allowed_yn.disabled=false;
formObj.prq_delete_yn.disabled=false;
}
if(obj.checked==false){
formObj.prq_finalize_allowed_yn.disabled=true;
formObj.prq_finalize_allowed_yn.checked = false;
formObj.prq_delete_yn.disabled=true;
formObj.prq_delete_yn.checked = false;

}
}
}

function disablePrq(obj,external_po,prq_allowed_yn){
if(external_po=="Y"){
if(obj.checked==true && prq_allowed_yn=="Y"){
document.UserAccessForStoreListForm.prq_allowed_yn.disabled=false;

}else{
document.UserAccessForStoreListForm.prq_allowed_yn.disabled=true;
document.UserAccessForStoreListForm.prq_allowed_yn.checked=false;
document.UserAccessForStoreListForm.prq_delete_yn.disabled=true;
document.UserAccessForStoreListForm.prq_delete_yn.checked = false;
document.UserAccessForStoreListForm.prq_finalize_allowed_yn.disabled=true;
document.UserAccessForStoreListForm.prq_finalize_allowed_yn.checked = false;

}
}
}

//Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
function checkRecordsDfltItmSearch(obj)
{     
	parent.UserForStoreListFrame.document.UserAccessForStoreListForm.dflt_item_search.value = obj;
}

// Added by Padmapriya
function checkRecordsDfltSalType(obj)
{     
	parent.UserForStoreListFrame.document.UserAccessForStoreListForm.dflt_sal_type.value = obj;
}
function validate_sal_trn(){
	var store_code = document.Search_form.store_name.value;
	var user_id = document.Search_form.user_id.value;
	var chk_flag="Y";//Added by suresh.r 13-11-2013 against JD-CRF-156
	if (store_code != "") {
	
	//document.Search_form.str_c.value = store_code;
	//document.Search_form.usr_i.value = user_id;
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		//xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		//xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=UA_SALES_TYPE&store_code=" + store_code + "&user_id=" + user_id, false);//Commented by suresh.r 13-11-2013 against JD-CRF-156
		xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=UA_SALES_TYPE&store_code=" + store_code + "&user_id=" + user_id+ "&chk_flag=" + chk_flag, false);//Added by suresh.r 13-11-2013 against JD-CRF-156
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		responseText = responseText.replace(/<[^>]*>/g, '');
		eval(responseText);	
		
	}
}


function addSalTrnList(listObject) {
	var store_code = document.Search_form.str_code.value;
	var user_id = document.Search_form.usr_id.value;
	var chk_flag="N";//Added by suresh.r 13-11-2013 against JD-CRF-156
	if (store_code != "") {
	var xmlDom = "";
	var xmlHttp = new XMLHttpRequest();
	//xmlDom.loadXML(getXMLString(null));
	xmlDom = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	//xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=UA_SALES_TYPE&store_code=" + store_code + "&user_id=" + user_id, false);//Commented by suresh.r 13-11-2013 against JD-CRF-156
	xmlHttp.open("POST", "../../eST/jsp/SalesValidate.jsp?validate=UA_SALES_TYPE&store_code=" + store_code + "&user_id=" + user_id+ "&chk_flag=" + chk_flag, false);//Added by suresh.r 13-11-2013 against JD-CRF-156
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);
	
	
	
	}
}

function checkfinalizepromptapplicable(obj,finalize_prompt_yn){
	if(obj.checked==false){
		finalize_prompt_yn.disabled = true;
		finalize_prompt_yn.value = "N";
		finalize_prompt_yn.checked = false;
	}else{
		finalize_prompt_yn.disabled = false;
		finalize_prompt_yn.value = "Y";
		finalize_prompt_yn.checked = true;
	}	
}


//Added by suresh.r 12-11-2013 against JD-CRF-156 beg
function setDispCurrFind(obj)
{
	if(obj.checked)
		parent.UserForStoreListFrame.document.UserAccessForStoreListForm.disp_curr_enc_findtl_yn.value = "Y";
	else
		parent.UserForStoreListFrame.document.UserAccessForStoreListForm.disp_curr_enc_findtl_yn.value = "N";
}
//Added by suresh.r 12-11-2013 against JD-CRF-156 end
