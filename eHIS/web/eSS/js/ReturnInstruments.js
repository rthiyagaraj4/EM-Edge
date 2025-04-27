/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href = "../../eSS/jsp/ReturnInstrumentsFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id +"&menu_id="+menu_id+"&module_id="+module_id;
}

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/ReturnInstrumentsQueryFrame.jsp?function_id="+function_id ;
}

function onSuccess(){
	var mode = f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else if( (mode == MODE_DELETE)||(f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.finalized_yn.value=="Y")) 
		f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	else
		f_query_add_mod.document.location.reload();
}

function deleterecord(){
	var formObj	=	f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader;
	if(formObj.mode.value==MODE_MODIFY){
		var confirmation = confirmDelete();//window.confirm("Current record will be deleted!!");
		if(confirmation=="Yes"){
			formObj.mode.value=MODE_DELETE;
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
			else{
				formObj.mode.value=MODE_MODIFY;
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("OPERATION_CANCELLED","SS");
		}
	}
	else {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	}
}

function reset() {
	if(f_query_add_mod.frameReturnInstrumentsQueryCriteria!=null){
		f_query_add_mod.frameReturnInstrumentsQueryCriteria.document.formReturnInstrumentsQueryCriteria.reset();
		f_query_add_mod.frameReturnInstrumentsQueryResult.document.location.href="../../eCommon/html/blank.html";
	}
	else if(f_query_add_mod.frameReturnInstrumentsHeader!=null){
		f_query_add_mod.location.reload();
	}
}


function apply(){
	totalCBox=parseInt(f_query_add_mod.frameReturnInstrumentsList.document.formReturnInstrumentsList.total_checkboxes.value);
	
	var checkBoxObj=null;
	var forDeletion=""
	for(i=0;i<totalCBox;i++)
	{
		checkBoxObj=eval("f_query_add_mod.frameReturnInstrumentsList.document.formReturnInstrumentsList.checkbox"+i);
		if(checkBoxObj.checked)
			forDeletion+=("Y,");
		else
			forDeletion+=("N,");
	}
	forDeletion=forDeletion.substring(0,forDeletion.length-1);

	var formObj						=	f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader ;
	formObj.records_to_delete.value =	forDeletion;
	var blankObject					=	null;
	var fields						=	new Array();
	var fieldNames					=	new Array();
	var	index						=	0;
	var queryString					=	"";
	fields[index]					=	formObj.doc_type_code;
	fieldNames[index++]				=	getLabel("Common.DocType.label","Common");
	if(!formObj.doc_no.disabled){
		fields[index]				=	formObj.doc_no;
		fieldNames[index++]			=	getLabel("eSS.DocNo.label","SS");
	}

	var locale						=	formObj.locale.value;
	formObj.doc_date.value			=	convertDate(formObj.doc_date.value,'DMY',formObj.locale.value,"en"); 
	
	fields[index]					=	formObj.doc_date;
	fieldNames[index++]				=	getLabel("eSS.DocDate.label","SS");
	fields[index]					=	formObj.rec_store_code;
	fieldNames[index++]				=	getLabel("eSS.ReceivingStore.label","SS");
	fields[index]					=	formObj.ret_store_code;
	fieldNames[index++]				=	getLabel("eSS.ReturningStore.label","SS");

	var errorPage					=	"../../eCommon/jsp/error.jsp";
	blankObject						=	getBlankField( fields, fieldNames, messageFrame);
     if (blankObject)
     {
		 var blank = blankObject.value;
     }else (blankObject==null)
		 var blank = '';
	
	if(blank=='') {
		
		if(formObj.entry_completed_yn.checked){

		//if (formObj.SS_RETURN_INSTRUMENTS_FINALIZE!=null)
		//if(formObj.entry_completed_yn.checked && (formObj.SS_RETURN_INSTRUMENTS_FINALIZE.value=="Y")) Commented by Sakti  since we have finalize in function level AAKH_SCF_158
		
		var confirmation		=	confirmFinalize();

			
			if(confirmation=="Yes"){
				formObj.finalized_yn.value="Y";
			}
			else if(formObj.entry_completed_yn.disabled){
				formObj.finalized_yn.value="N";
				messageFrame.location.href = errorPage+"?err_num="+ getMessage("OPERATION_CANCELLED","SS");
				return;
			}
			else{
				formObj.finalized_yn.value="N";
			}
		}
		eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		messageFrame.location.href = errorPage+"?err_num="+ message+"<br>"+flag;
		if( result ) {
			onSuccess();
		}
	}
	else{
		blankObject.focus();
	}
}

function searchItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	if(objDesc.readOnly)
		argumentArray[5] = "";
	else
		argumentArray[5] = objDesc.value;
	
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item Search", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.readOnly=true;
	} 
}

function checkDoc_type_code(){
	if(document.formReturnInstrumentsHeader.doc_type_code.value=="") return;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/ReturnInstrumentsValidate.jsp?validate=DOC_TYPE_CODE&doc_type_code=" + document.formReturnInstrumentsHeader.doc_type_code.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
}


function enableDocNo(bValue){
	if(!bValue){
		parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.doc_no.value="";	
	}
	parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.doc_no.disabled=!bValue;
}
function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText);

	return(xmlText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
//			request = new ActiveXObject("Msxml2.XMLHTTP");
			request = new new XMLHttpRequest();
		}catch (othermicrosoft) {
			try {
//				request = new ActiveXObject("Microsoft.XMLHTTP");
				request = new XMLHttpRequest();
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
function setItemDetails(_item_code, _item_desc){
	var formObj=  document.formReturnInstrumentsDetail;
	formObj.item_code.value		=	_item_code;
}
function populateItem(){
	var formObj=  document.formReturnInstrumentsHeader;
	var patient_id=formObj.patient_id.value;
	var ret_store_code=formObj.ret_store_code.value;
	var rec_store_code=formObj.rec_store_code.value;
	if((ret_store_code!="")&&(rec_store_code!="")){
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
//		xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ReturnInstrumentsValidate.jsp?patient_id=" + patient_id +"&ret_store_code=" + ret_store_code+"&rec_store_code=" + rec_store_code+ "&validate=POPULATE_ITEM_CODE", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	}
}
function addToList(){
	var formObj=  document.formReturnInstrumentsDetail;
	
	
	var item_code;
	if(formObj.mode.value=="1")
	{
	var fields = new Array ( formObj.item_code, formObj.ret_item_qty);
	
	}
	else
	{
	var fields = new Array ( formObj.item_code_1, formObj.ret_item_qty);
	
	}
	var names  =  new Array ( getLabel("Common.item.label","Common"),getLabel("eSS.ReturnQty.label","SS") );
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp"
	obj=getBlankField( fields, names, messageFrame);
	if(obj==null) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var item_desc;
		if(formObj.mode.value=="1")
		{
		item_desc=formObj.item_code.options[formObj.item_code.options.selectedIndex].text;
		item_code=formObj.item_code.value;
		
		}
		else
		{
			item_desc=formObj.item_desc_1.value;
			item_code=formObj.item_code_1.value;
			
			
		}
	
		var formObjHeader	=	parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader;
//		xmlDoc.loadXML(getXMLString(null));
		xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
		xmlHttp.open("POST", "../../eSS/jsp/ReturnInstrumentsValidate.jsp?item_code=" +item_code  +  "&ret_item_qty=" + formObj.ret_item_qty.value + "&remarks=" + escape(formObj.remarks.value) +"&ret_item_cost=" + formObj.ret_item_cost.value +"&item_desc=" + item_desc+"&index="+formObj.index.value+ "&contaminated_yn="+formObj.contaminated_yn.checked+ "&damaged_yn="+formObj.damaged_yn.checked+ "&ret_store_code="+formObjHeader.ret_store_code.value+"&rec_store_code="+formObjHeader.rec_store_code.value+"&patient_id="+formObjHeader.patient_id.value+"&validate=ADD_TO_LIST"+"&mode="+formObj.mode.value, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		if( result ) {
			refreshDetails();
		}
		else{
			messageFrame.location.href = errorPage+"?err_num="+ getMessage(message,"SS");
		}
	}
}

async function searchPatient() {
	var patient_id	= await PatientSearch();
	var formObj = top.content.f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader;
	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}

async function searchPatientInQuery() {
	var patient_id	= await PatientSearch();
	var formObj = top.content.f_query_add_mod.frameReturnInstrumentsQueryCriteria.document.formReturnInstrumentsQueryCriteria;
	if (!((patient_id == null) || (patient_id =="")))	{
		formObj.patient_id.value = patient_id;
	}
	formObj.patient_id.focus();
}

function searchPatientName(){
	var formObj	= document.formReturnInstrumentsHeader;
	if(formObj.patient_id.value==""){
		clearListItems("parent.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail.item_code");
		populateItem();
		formObj.patient_name.value="";
		return;
	}
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
//	xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null), "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/ReturnInstrumentsValidate.jsp?validate=PATIENT_NAME&patient_id="+formObj.patient_id.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
	if(!result){
		alert(getMessage(flag));
		formObj.patient_id.select();
		formObj.patient_id.focus();
	}
}

function setPatientName(patient_name){
	var formObj = top.content.f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader;
	formObj.patient_name.value=patient_name;
}


function resetReturnInstrumentsDetail(){
	
	var formObj=top.content.f_query_add_mod.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail;
	
	if(formObj.mode.value=="1"){
	formObj.item_code.value="";
	formObj.item_code.disabled=false;
	}
	else
	{
		
			formObj.item_desc_1.readOnly=true;
			formObj.item_desc_1.disabled=true;
			formObj.item_desc_1.value="";
				
	}
	
	
	formObj.apply.value="  Add  ";
	formObj.index.value="-1";
	listModify(formObj.index.value);

	formObj.ret_item_qty.value="";
	formObj.ret_item_cost.value="";
	formObj.contaminated_yn.checked=false;
	formObj.damaged_yn.checked=false;
	formObj.remarks.value="";
}


function refreshDetails(){
	displayMessage(top.content.messageFrame,"");
	resetReturnInstrumentsDetail();
	refreshList();
}

function refreshList(){
	top.content.f_query_add_mod.frameReturnInstrumentsList.document.location.reload();
}

function listModify(index){
	parent.frameReturnInstrumentsDetail.location.href="../../eSS/jsp/ReturnInstrumentsDetail.jsp?index="+index+"&function_id="+parent.parent.function_id+"&patient_id="+parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.patient_id.value+"&ret_store_code="+parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.ret_store_code.value+"&rec_store_code="+parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.rec_store_code.value;
      //details_mod();
}

function Modify(obj){
	var doc_type_code=obj.cells[4].innerText;
	var doc_no=obj.cells[1].innerText;
	top.content.f_query_add_mod.document.location.href="../../eSS/jsp/ReturnInstrumentsFrame.jsp?mode="+MODE_MODIFY+"&function_id="+parent.parent.function_id+"&doc_type_code="+doc_type_code+"&menu_id="+parent.parent.menu_id+"&module_id="+parent.parent.module_id+"&doc_no="+doc_no;
}

function disableStorePatient(){
 	var formObj=parent.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader;
	formObj.ret_store_code.disabled=true;
    formObj.rec_store_code.disabled=true;
	formObj.patient_id.disabled=true;
	formObj.patient_search.disabled=true;
}

function assignValues(obj)
{
	
	
	var item_code_string=new Array();
	var item_desc_string=new Array();
	var formObj=  document.formReturnInstrumentsDetail;
      item_desc=formObj.item_code.options[formObj.item_code.options.selectedIndex].text;
		item_code=formObj.item_code.options[formObj.item_code.options.selectedIndex].value;
		  item_desc_string=item_desc.split("/");
          item_code_string=item_code.split("|");//21052 
		  if(item_code_string[0]!="")
	         formObj.all.details.disabled = false;
	         formObj.all.details.style.cursor = "hand";

            
}
function details()
{
      var group_code;
	  var group_desc;
      var formObj=  document.formReturnInstrumentsDetail;
	  var mode =   top.content.f_query_add_mod.frameReturnInstrumentsHeader.document.formReturnInstrumentsHeader.querySelector("#mode").value;
       var item_code_string=new Array();
	   var item_desc_string=new Array();
	if(mode=='1' && (!formObj.item_desc_1))
		{
		
       item_desc=formObj.item_code.options[formObj.item_code.options.selectedIndex].text;
	   item_code=formObj.item_code.options[formObj.item_code.options.selectedIndex].value;
	   item_desc_string=item_desc.split("/");
       item_code_string=item_code.split("-");
		} else
	{
    
		item_desc_string=(formObj.item_desc_1.value).split("/");
        item_code_string=(formObj.item_code_1.value).split("-");
	}
	if(item_code_string[0]!="") {
		 group_code		=	item_code_string[0];
	     group_desc		=	item_desc_string[0];
	
	var dialogHeight = "30" ;
	//var dialogWidth	= "24" ;
	var dialogWidth	= "40" ;
	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=yes; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "group_code="+group_code+"&group_desc="+group_desc;
	
	retVal = window.showModalDialog("../../eSS/jsp/GroupItemDetails.jsp?"+params,arguments,features);
	} else
	{
	return;
	}
}
