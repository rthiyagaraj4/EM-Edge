/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var finalizeType;
var radioval = "D";

function create(){

	//f_query_add_mod.location.href = "../../eSS/jsp/PrepareGroupAddModify.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id;
	f_query_add_mod.location.href = "../../eSS/jsp/PrepareGroupFrame.jsp?mode="+MODE_INSERT+"&menu_id="+menu_id+"&module_id="+module_id+"&function_id="+function_id;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/PrepareGroupQueryMain.jsp?function_id="+function_id;
}

function onSuccess(){
	
    if(f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.mode.value==MODE_DELETE) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
		create();
		return;
	}
	if(f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.mode.value==MODE_MODIFY) {
		if (finalizeType == YES) {
			create();
			
		}
		else {
			create();
		}
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
	}
	
	else {
		
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message+flag;
		create();
	}
	return;
}

function reset() {
	//var prepareForm = f_query_add_mod.document.formPrepareGroup;
	f_query_add_mod.location.reload();
}

//Added by Sakti for reset in group search against inc#42119
/*function resetgroupsearch() {
	parent.frameGroupSearchCriteria.document.GroupSearchCriteria_Form.reset();
	var formObject = parent.frameGroupSearchResult.document.GroupsearchForm;
	var totalRecords = formObject.totalRecords.value;
	for(var i=0;i<totalRecords;i++){
		if( !(eval("parent.frameGroupSearchResult.document.GroupsearchForm.checked_key"+i+"").value == "checked" ) ) {
			
			eval("parent.frameGroupSearchResult.document.GroupsearchForm.group_code"+i+"").checked = false;
			parent.frameGroupSearchResult.document.GroupsearchForm.selectAll.checked = false;
		}else{
			eval("parent.frameGroupSearchResult.document.GroupsearchForm.group_code"+i+"").checked = true;
			parent.frameGroupSearchResult.document.GroupsearchForm.selectAll.checked = true;
		}
	}
}*/

async function deleterecord(){
	if(  f_query_add_mod.PrepareGroupListFrame ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
	if(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value==MODE_MODIFY){
		f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value = MODE_DELETE;
		var result = await confirmDelete();
		if(result==YES){
			apply();
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
			f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value = MODE_MODIFY;
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

async function apply(){
	if(  f_query_add_mod.PrepareGroupListFrame ==undefined ){
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return;
	} 
var formObj = f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail;
 
	if (f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value==MODE_DELETE)	{
		eval(formApply(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup,SS_CONTROLLER));
		onSuccess();
		return;
	}
	var fields =	new Array();
	var fieldNames =new Array();
	var index = 0;
	var queryString = "";

	fields[index] = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_type_code;
	fieldNames[index++]	=	getLabel("Common.DocType.label","Common");
	if(!f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_no.disabled){
		fields[index] = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_no;
		fieldNames[index++]	=getLabel("eSS.DocNo.label","SS");
	}
	fields[index] = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_date;
	fieldNames[index++]	=getLabel("eSS.DocDate.label","SS");
	fields[index] = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.store_code;
	fieldNames[index++]	=getLabel("Common.Store.label","Common");

	var obj = getBlankField(fields, fieldNames, messageFrame); 
 	
	if(obj != null){
	
		obj.focus();
	}
	else{//Validations added By Sakti Sankar against BRU-HIMS-CRF-370
		var qty_exist = false;
		var bin_exist = false;
		var canproces = false;
		var forProcess = "";
		
		var total_check_boxes = f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.total_checkboxes.value;
		if(total_check_boxes <1){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","COMMON");
			return;
		}
		for (var count = 0;count<total_check_boxes;count++) {
				
			if(eval("formObj.checkbox"+count).checked){
				forProcess+=("Y,");
				if(eval("formObj.prepare_qty_"+count).value == "") {
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("QUANTITY_CANNOT_BLANK","SS");
						eval("formObj.prepare_qty_"+count).focus();
						return;
					}
					if(eval("formObj.bin_location_code_"+count).value == "") {
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("BIN_CANNOT_BLANK","SS");
						eval("formObj.bin_location_code_"+count).focus();
						return;
					}
					canproces= true;
				}else{forProcess+= ("N,");}
		}
			forProcess=forProcess.substring(0,forProcess.length-1);
			formObj.records_to_process.value=forProcess;
		if(!canproces){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("MIN_ONE_DETAIL_REQUIRED","COMMON");
			return;
		}
	
		validateDocDate(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_date);
		if (!result) {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;
			return;
		}
		
			bean_id = f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.bean_id.value;
			bean_name =f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.bean_name.value;
			var index = f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.total_checkboxes.value;
//			xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//			xmlStr = getEnhancedXMLString (formObj);
//			xmlDom.loadXML( xmlStr );
			
			var xmlHttp = new XMLHttpRequest();
			var xmlStr = getXMLString (formObj);
		    var parser = new DOMParser();
		    //var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		    xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
   
			xmlHttp.open("POST", "PrepareGroupValidate.jsp?prev_index=" + index  +"&bean_id="+bean_id+"&bean_name="+bean_name+ "&validate=prepare_qty&function_type=5", false);
			xmlHttp.send( xmlDom );
			//xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    //xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
			responseText=xmlHttp.responseText;
			eval( responseText );

				/*if(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.SS_PREPARE_GROUP_FINALIZE != null) { Commented by Sakti  since we have finalize in function level AAKH_SCF_158
				
						if(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.SS_PREPARE_GROUP_FINALIZE.value=="Y") {
							finalizeType = confirmFinalize();
						}else {
								finalizeType = NO;
							}
						}else {
							finalizeType = NO;
						}*/
						finalizeType = await confirmFinalize();					
							if (finalizeType == 'Yes') {
								f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.finalize_yn.value = YES;
								f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.finalize_yn.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.finalize_yn.value
							}
							else {
	 						
								f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.finalize_yn.value = NO;
								f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.finalize_yn.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.finalize_yn.value
							}
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.facility_id.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.facility_id.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.mode.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.function_id.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.function_id.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.store_code.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.store_code.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.doc_ref.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_ref.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.doc_type_code.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_type_code.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.doc_no.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_no.value;
										f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail.doc_date.value = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_date.value;
					if (finalizeType !=	CLOSED) {
					
						eval(formApply(f_query_add_mod.PrepareGroupListFrame.document.formPrepareGroupDetail,SS_CONTROLLER));
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
					if( result ) {
							onSuccess();
						}
					}
					else {
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
					}
		
	}
}

function checkDate(obj, sysdate,locale){
	
	if(validDateObj(obj,"DMY",locale))	{
		
		if(isBefore(obj.value,sysdate.value,"DMY",locale)){
			alert(getMessage("NOT_LESS_THAN_SYSDATE","ST"));
			obj.focus();
			return false;
		}
	}
}
function assignBean() {
	bean_id = document.formPrepareGroup.bean_id.value;
	bean_name = document.formPrepareGroup.bean_name.value;
	//xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	var xmlDom		= "";
	var xmlHttp = new XMLHttpRequest();
	
}

// Added by Martin
// To add Bin Location to the ListBox on Focus Lost of Store Code
function validateDocNo(doc_type_code) {
	if(document.formPrepareGroup.mode.value == MODE_INSERT){
		if(doc_type_code.value == "") 
			return;
		var arrayObject = new Array();
		arrayObject[0] = doc_type_code;
		assignBean();
		xmlStr = getXMLString(arrayObject);
		
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=doc_type_code&function_type=1", false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

function validateStoreCode(store_code, bin_location_code) {
		if( store_code.value == "" ) 
		return;
		assignBean();
		var arrayObject = new Array();
		arrayObject[0] = store_code;
		xmlStr = getXMLString(arrayObject);
		//xmlDom.loadXML(xmlStr);
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&bin_location_code=" + bin_location_code + "&validate=store_code&function_type=2", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
}

function validateDocDate(doc_date) {

	var locale				=	f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.locale.value;
	var doc_date_value				=	convertDate(doc_date.value,'DMY',locale,"en");
	doc_date.value=doc_date_value;
	var arrayObjects = new Array();
	arrayObjects[0] = doc_date;
	if(!(f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.mode.value==MODE_DELETE)) {
		bean_id = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.bean_id.value;
		bean_name = f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.bean_name.value;
		//xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
		//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
		var xmlDom = "" ;
	    var xmlHttp = new XMLHttpRequest() ;
				
		xmlStr = getXMLString (arrayObjects);
 		//xmlDom.loadXML( xmlStr );
		xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=doc_date&function_type=4", false);
		xmlHttp.send( xmlDom );
		responseText=xmlHttp.responseText;
		eval( responseText );
	}
}
//Comented by Sakti sankar against BRU-CRF-370
/*function calculateTotalCost() { //Case 3
	if((document.formPrepareGroup.prepare_qty.value == "") || (document.formPrepareGroup.group_desc.value == ""))  {
		return;
	}
	if (!checkIntegerFormat(document.formPrepareGroup.prepare_qty)) {
		document.formPrepareGroup.prepare_qty.focus();
		return;
	}
	if (!validateGroupCodeSearch(document.formPrepareGroup.group_code,document.formPrepareGroup.group_desc)) {
		return;
	}
	var arrayObjects = new Array();
	arrayObjects[0] = document.formPrepareGroup.prepare_qty;
	arrayObjects[1] = document.formPrepareGroup.group_code;
	bean_id = document.formPrepareGroup.bean_id.value;
	bean_name = document.formPrepareGroup.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	xmlStr = getXMLString (arrayObjects);
	xmlDom.loadXML( xmlStr );
	xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=prepare_qty&function_type=3", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
}

function setTotalCostValue(totalCost) {
	if (document.formPrepareGroup != null) {
		document.formPrepareGroup.total_cost.value = totalCost;
	}
	else {
		f_query_add_mod.document.formPrepareGroup.total_cost.value = totalCost;
	}
}*/
//Added By Sakti against BRU-HIMS-CRF-370
function calculateTotalCost(i) { 
	if((eval("document.formPrepareGroupDetail.prepare_qty_"+i).value == "") || (eval("document.formPrepareGroupDetail.desc"+i) == ""))  {
		return;
	}
	if (!checkIntegerFormat(eval("document.formPrepareGroupDetail.prepare_qty_"+i) )) {
		eval("document.formPrepareGroupDetail.prepare_qty_"+i).focus();
		return;
	}

	var arrayObjects = new Array();
	arrayObjects[0] = eval("document.formPrepareGroupDetail.prepare_qty_"+i);
	arrayObjects[1] = eval("document.formPrepareGroupDetail.group"+i);
	bean_id = document.formPrepareGroupDetail.bean_id.value;
	bean_name = document.formPrepareGroupDetail.bean_name.value;
	//xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	var xmlDom = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    
	xmlStr = getXMLString (arrayObjects);
	//xmlDom.loadXML( xmlStr );
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
 	xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&prepare_qty="+eval("document.formPrepareGroupDetail.prepare_qty_"+i).value+"&group_code="+eval("document.formPrepareGroupDetail.group"+i).value+"&index="+i+ "&validate=prepare_qty&function_type=3", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	//alert(responseText);
}

function setTotalCostValue(totalCost,index) {
	var total_checkboxes = document.formPrepareGroupDetail.total_checkboxes.value;
	if (document.formPrepareGroupDetail != null) {
		eval("document.formPrepareGroupDetail.total_value_"+index).value = totalCost.toFixed(3);
	}
}

function calculateApplyTotalCost() { //Case 3
	if((f_query_add_mod.document.formPrepareGroup.prepare_qty.value == "")&&(f_query_add_mod.document.formPrepareGroup.group_desc.value == ""))  {
		return;
	}
	if (!checkIntegerFormat(f_query_add_mod.document.formPrepareGroup.prepare_qty)) {
		f_query_add_mod.document.formPrepareGroup.prepare_qty.focus();
		return;
	}
	var arrayObjects = new Array();
	arrayObjects[0] = f_query_add_mod.document.formPrepareGroup.prepare_qty;
	arrayObjects[1] = f_query_add_mod.document.formPrepareGroup.group_code;
	bean_id = f_query_add_mod.document.formPrepareGroup.bean_id.value;
	bean_name = f_query_add_mod.document.formPrepareGroup.bean_name.value;
	//xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	//xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
	
	
	var xmlDom = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    
    
	xmlStr = getXMLString (arrayObjects);
	//xmlDom.loadXML( xmlStr );
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=prepare_qty&function_type=3", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	
	eval( responseText );
}

function assignBinLocationDesc(ListObject) {
	document.formPrepareGroup.bin_location_code.value = ListObject.options[ListObject.selectedIndex].text;
}

function errorDisplay() {
	document.formPrepareGroup.store_code.focus(); 
}


function enableDocNo() {
	prepareForm = document.formPrepareGroup;
	prepareForm.doc_no.disabled = false;
	prepareForm.doc_no.readonly = false;
	prepareForm.doc_no.focus();
	prepareForm.autono_yn.value = NO;
}

function disableDocNo() {
	prepareForm = document.formPrepareGroup;
	prepareForm.doc_no.disabled = true;
	prepareForm.doc_no.readonly = true;
	prepareForm.doc_no.value="";
	prepareForm.doc_date.focus();
	prepareForm.autono_yn.value = YES;
}

function requestDocDateFocus(doc_date_value) {
	f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_date.value=''; //Edge going in loop if not cleared
	f_query_add_mod.PrepareGroupHeaderFrame.document.formPrepareGroup.doc_date.focus();
}

function Modify(obj){
	//var doc_type_code =obj.cells[5].innerText;
	var doc_type_code =obj.cells[4].innerText;
	var doc_no =obj.cells[1].innerText;
	var store_code=obj.cells[5].innerText;//Added By Sakti against BRU-HIMS-CRF-370
	var doc_ref=obj.cells[6].innerText;//Added By Sakti against BRU-HIMS-CRF-370
	var doc_date=obj.cells[2].innerText;//Added By Sakti against BRU-HIMS-CRF-370

	//parent.document.location.href="../../eSS/jsp/PrepareGroupAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
	parent.document.location.href="../../eSS/jsp/PrepareGroupFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&store_code="+store_code+"&doc_ref="+doc_ref+"&doc_date="+doc_date+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
}


//Added By Sakti against BRU-HIMS-CRF-370
async function callGroupSearch() {
	var formObject = parent.PrepareGroupListFrame.document.formPrepareGroupDetail;
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	var formObj = document.formPrepareGroup;
	var arrayObject = new Array(formObj.store_code);
	var names = new Array(getLabel("Common.Store.label", "Common"));
	var blankObject = checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject == true) {
		var store_code = formObj.store_code.value;
		var total_rec = parent.PrepareGroupListFrame.document.formPrepareGroupDetail.total_rec.value;
		
//		xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//		xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//		xmlStr = getEnhancedXMLString (formObject);
//		xmlDom.loadXML( xmlStr );
		
		var xmlHttp = new XMLHttpRequest();
		var xmlStr = getXMLString (formObject);
	    var parser = new DOMParser();
	    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
		
		
		xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id="+formObject.bean_id.value+"&bean_name="+formObject.bean_name.value+ "&validate=prepare_qty&function_type=7", false);
//		xmlHttp.send( xmlDom );
		
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
		responseText=xmlHttp.responseText;
		eval( responseText );
	
		
		var retval = await callGroupSearchWindow(store_code,total_rec,formObj.mode.value);
		var newrecord = "";

		if (retval != null && retval!="" && retval!=undefined) {

			formObj.store_code.disabled = true;
			parent.PrepareGroupListFrame.location.href="../../eSS/jsp/PrepareGroupDetail.jsp?store_code="+store_code+"&mode="+formObj.mode.value;
		}
		//else part added by Sakti for clearing checked values oncancel and clicking on cross against inc#42370
		else{
			var bean_id = document.formPrepareGroup.bean_id.value;
			var bean_name = document.formPrepareGroup.bean_name.value;

//			xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//			xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//			xmlStr = getXMLString (null);
//			xmlDom.loadXML( xmlStr );
			
			var xmlHttp = new XMLHttpRequest();
			var xmlStr = getXMLString (arrayObject);
		    var parser = new DOMParser();
		    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
			
			xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=next_prev_action&function_type=8", false);
			//xmlHttp.send( xmlDom );
			
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
			responseText=xmlHttp.responseText;
			eval( responseText );
		}//Added ends
	}
}

async function callGroupSearchWindow( store_code,total_rec,mode) {  
	
	retVal = await window.showModalDialog("../../eSS/jsp/GroupSearchFrame.jsp?store_code=" + store_code+"&mode="+mode ,"", "dialogHeight:77vh; dialogWidth:60vw; center:0; status: no; dialogLeft :200; dialogTop :100;");
	return retVal;
}



function searchVals() {
	var store_code = document.GroupSearchCriteria_Form.store_code.value;
	var search_text = document.GroupSearchCriteria_Form.search_text.value;
	var group_type = document.GroupSearchCriteria_Form.group_type.value; //ML-MMOH-CRF-1827
	var search_criteria = document.GroupSearchCriteria_Form.search_criteria.value; //ML-MMOH-CRF-1827
	parent.frameGroupSearchResult.document.location.href = "../../eSS/jsp/GroupSearchResult.jsp?radioval=" + radioval+"&search_text="+search_text+"&store_code="+store_code+"&group_type="+group_type+"&search_criteria="+search_criteria;
}

function storeVal(currad) {
    radioval=currad.value
}



//Added By Sakti Sankar Against BRU-HIMS-CRF-370
function closeActionPerformed(frmObj) {

	var index = 0;
	var returnvals = "";
	var new_index= "";
	var unchecked_index = "";
	var exist = false;
	var formObj = parent.frameGroupSearchResult.document.GroupsearchForm;
	if(formObj == undefined){
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS"));
		return;
	}
	var total_trays = formObj.totalRecords.value;
	var arrayObject = new Array();
	window.returnValue=false;
	var item_arr   = new Array;
	for (count = 0;count<total_trays;count++) {
			if(eval("formObj.group_code"+count+".checked")) {
				exist = true;
				returnvals += formObj.elements["group" + count].value + "`" + formObj.elements["desc" + count].value +  "~";

				arrayObject[index] = eval("formObj.group"+count);
				//eval("formObj.desc"+count).value = decodeURIComponent(eval("formObj.desc"+count).value,"UTF-8");
				arrayObject[index+1] = eval("formObj.desc"+count);
				index += 2;
				
				new_index += count + "!";
			}else{
				arrayObject[index] = eval("formObj.group"+count);
				//eval("formObj.desc"+count).value = decodeURIComponent(eval("formObj.desc"+count).value,"UTF-8");
				arrayObject[index+1] = eval("formObj.desc"+count);
				
				index += 2;
				
				unchecked_index += count+"!";
			}
	}

	if(!exist){
		alert(getMessage("SELECT_GROUP_TO_PROCEED","SS")); 
		return;
	}
	
	
	
	formObj.index.value = new_index;
	formObj.mode.value = document.GroupSearchCriteria_Form.mode.value;
	formObj.unchecked_index.value = unchecked_index;
	
	arrayObject[arrayObject.length] = formObj.unchecked_index;
	arrayObject[arrayObject.length] = formObj.index;
	arrayObject[arrayObject.length] = formObj.mode;


	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value;
	
	
	
//	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
//	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
//	xmlStr = getXMLString (arrayObject);
//	xmlDom.loadXML( xmlStr );
	
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = getXMLString (arrayObject);
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "application/xml");
	
	xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=next_prev_action&function_type=6", false);
//	xmlHttp.send( xmlDom );
	
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));	
	responseText=xmlHttp.responseText;
	eval( responseText );
 
	//window.parent.parent.returnValue = returnvals;
	dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnvals;
    
 	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close();   
	  
	//window.close();
	
} 


function toggleCheck(selAllObj){

	var formObj = document.GroupsearchForm;
	
	for(var i=0; i<formObj.totalRecords.value; i++){
	if(eval('formObj.group_code'+i).disabled == false) {	
		if(selAllObj.checked == true){
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.group_code'+i) != undefined) {
				eval('formObj.group_code'+i).checked = false;
			}
		}
	}
 }

}

function toggleCheckforDetail(selAllObj){

	var formObj = document.formPrepareGroupDetail;
	
	for(var i=0; i<formObj.total_checkboxes.value; i++){

		if(selAllObj.checked == true){
			if(eval('formObj.checkbox'+i) != undefined) {
				eval('formObj.checkbox'+i).checked = true;
			}
		}
		else{
			if(eval('formObj.checkbox'+i) != undefined) {
				eval('formObj.checkbox'+i).checked = false;
			}
		}

 }

}
//Added ends
function loadbin(){
	document.formPrepareGroupDetail;
}



async function searchCode( objCode, objDesc ) {
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0] = "store_code";
	dataValueArray[0]= document.formPrepareGroup.store_code.value;
	dataTypeArray[0] = STRING;

	dataNameArray[1] = "locale";
	dataValueArray[1]= document.formPrepareGroup.locale.value;
	dataTypeArray[1] = STRING;
   
	argumentArray[0] = document.formPrepareGroup.SQL_SS_PREPARE_GROUP_LOOKUP.value;

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray,document.formPrepareGroup.trn_type.value );
	
	if((returnedValues != null) && (returnedValues != "") )  {
	 		
			if(returnedValues.length === 1){
				returnedValues = returnedValues[0].split(',');
			}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
		//document.formPrepareGroup.store_code.disabled=true;
		document.getElementById("store_code").disabled=true;
		
		//document.getElementById("details").disabled = false;	
		//document.getElementById("details").style.cursor = "hand";	
	     //document.formPrepareGroup.all.details.disabled = false;	
	     //document.formPrepareGroup.all.details.style.cursor = "hand";
		return;

	} 
}

function submitCriteria() {
	if (!validateGroupCodeSearch(document.formPrepareGroup.group_code,document.formPrepareGroup.group_desc)) {
		return;
	}
	
	document.formPrepareGroup.action="../../eSS/jsp/PrepareGroupQueryResult.jsp";
	document.formPrepareGroup.target="qryResultPrepareGroup"; 
		
	document.formPrepareGroup.submit();
}

function validateGroupCode() {

}
/*function details()
{
    var group_code		=	document.formPrepareGroup.group_code.value;
	var group_desc		=	document.formPrepareGroup.group_desc.value;

	if(group_code!="")
	{
	var dialogHeight = "30" ;
	var dialogWidth	= "24" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}

}*/

async function details(group_code,group_desc)
{ 
 
	if(group_code!="")
	{
	var dialogHeight = "80vh" ;
	var dialogWidth	= "70vw" ;

	var dialogTop = "50" ;
	var center = "1" ;
 

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=auto; status=no;" ;
 
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = await top.window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	}

}
//Added By Sakti Sankar Against BRU-HIMS-CRF-370
function SubmitLink(from, to) {

	var index = 0;
	var new_index= "";
	var unchecked_index= "";
	var formObj = document.GroupsearchForm;
	if(document.GroupsearchForm){
	var total_trays = formObj.totalRecords.value;
	var arrayObject = new Array();
		for (count = 0;count<total_trays;count++) {
		
			if(eval("document.GroupsearchForm.group_code"+count+".checked")) {
				
				arrayObject[index] = eval("document.GroupsearchForm.group"+count);
				eval("document.GroupsearchForm.desc"+count).value = encodeURIComponent(eval("document.GroupsearchForm.desc"+count).value,"UTF-8");
				arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
				
				index += 2;
				
				new_index += count+"!";
		}else{
			arrayObject[index] = eval("document.GroupsearchForm.group"+count);
			eval("document.GroupsearchForm.desc"+count).value = encodeURIComponent(eval("document.GroupsearchForm.desc"+count).value,"UTF-8");
			arrayObject[index+1] = eval("document.GroupsearchForm.desc"+count);
			
			index += 2;
			
			unchecked_index += count+"!";
		}
	}

	
	document.GroupsearchForm.index.value = new_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.index;
	
	document.GroupsearchForm.unchecked_index.value = unchecked_index;
	arrayObject[arrayObject.length] = document.GroupsearchForm.unchecked_index;

	var bean_id = document.GroupsearchForm.bean_id.value;
	var bean_name = document.GroupsearchForm.bean_name.value;
	
	xmlDom = "";//new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new XMLHttpRequest() ;//new ActiveXObject( "Microsoft.XMLHTTP" );
	
	xmlStr = getXMLString (arrayObject);
	xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	//xmlDom.loadXML( xmlStr );
	xmlHttp.open("POST", "PrepareGroupValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=next_prev_action&function_type=6", false);
	xmlHttp.send( xmlDom );
	responseText=xmlHttp.responseText;
	eval( responseText );
	}
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ; 
    
}


function updateSelection() {
	var frmObject		= document.formPrepareGroupDetail;
	var total_check_boxes = frmObject.total_checkboxes.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {
				if(!(eval("frmObject.checkbox"+count+".checked"))) {
					exist=false;
				}
			}
			if(exist){
			document.formPrepareGroupDetail.selectAll.checked=true;
			}else{
			document.formPrepareGroupDetail.selectAll.checked=false;
			}
}

function updateSelectionGroupSearch() {
	var frmObject		= document.GroupsearchForm;
	var total_check_boxes = frmObject.totalRecords.value;
	var exist=true;
		for (var count = 0;count<total_check_boxes;count++) {

				if(!(eval("frmObject.group_code"+count+".checked"))) {
					exist=false;
				}
		}
			if(exist){
			document.GroupsearchForm.selectAll.checked=true;
			}else{
			document.GroupsearchForm.selectAll.checked=false;
			}
}

//Added by Sakti for special character check specific to prepare group function
function getXMLString(arrayObject) {
	
	xmlStr ="<root><SEARCH ";
	if (arrayObject!=null)
		for (index=0;index<arrayObject.length;index++)	{
			xmlStr += arrayObject[index].name+"=\""+ checkSpl(arrayObject[index].value) +"\" ";
		}
	xmlStr +=" /></root>";
	return xmlStr;
}


 function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode == 8 || charCode == 46) 
    	return false;

 }

 function closeWindow() {
	 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	 dialogTag.close();   
	}
