/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset(){
	f_query_add_mod.f_criteria.ReprintDocumentCriteria.reset();
	f_query_add_mod.f_result.location.href="../../eCommon/html/blank.html";
}

function run(){       
	if(f_query_add_mod.f_result.document.RePrintDocumentResult == null) {
		alert("Please Select A Transaction From The List Then Search");
	}
	if(f_query_add_mod.f_result.document.RePrintDocumentResult != null) {
		alert("Please Click on Below Hyperlink");
	}
	return; 
}

function populateDocTypeCode(_trn_type){
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlString = getXMLString(null); 
	var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	//xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eSS/jsp/ReprintDocumentValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

async function searchCodeStore( objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  =document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1]   = "language_id";
	dataValueArray[1]   = document.forms[0].p_language_id.value;
	dataTypeArray[1]    = STRING;
	argumentArray[0] = document.getElementById("SQL_SS_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}
function callResultPage(){
	//var formObj		=	document.frames.ReprintDocumentCriteria;
	var formObj		=	document.getElementById("ReprintDocumentCriteria");
	parent.f_result.location.href="../../eCommon/html/blank.html";
	var locale		=formObj.p_language_id.value;
	var dt_from	=	convertDate(formObj.p_fr_doc_date.value,'DMY',locale,"en");
	var dt_to	=	convertDate(formObj.p_to_doc_date.value,'DMY',locale,"en");
	var p_trn_type		= formObj.p_trn_type.value;
	var p_doc_type_code = formObj.doc_type_code.value;
	var store_desc		= formObj.store_desc.value;//IN054317
	var store_code		= formObj.store_code.value;
	//IN054317 starts
	if(store_desc == '')
	{
		store_code = "";
	}
	//IN0054317 ends
	var p_doc_no		= formObj.doc_no.value;
	if (dt_from!="" && dt_to!=""){
		if(!doDateCheck(formObj.p_fr_doc_date,formObj.p_to_doc_date,parent.parent.messageFrame)){
			formObj.p_fr_doc_date.select();
			formObj.p_fr_doc_date.focus();
			return;
		}
	}
	var arrayObject = new Array(formObj.p_trn_type);
	var names = new Array(getLabel("Common.Transaction.label","Common"));
	var blankObject =checkSSFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject !=true){
		return;
	}
	else
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.f_result.location.href = "../../eSS/jsp/ReprintDocumentResult.jsp?p_trn_type="+p_trn_type+"&p_doc_type_code="+p_doc_type_code+"&store_code="+store_code+"&p_doc_no="+p_doc_no+"&dt_from="+dt_from+"&dt_to="+dt_to;

}

function callReport(doc_type_code,doc_no,store_code, sal_trn_type) {
	var formObj	=  parent.parent.f_query_add_mod.f_criteria.document.ReprintDocumentCriteria;
	formObj.p_doc_no.value	=	doc_no;
	formObj.p_doc_type_code.value	=	doc_type_code;
	formObj.dest_locn_code.value=store_code;
	var arReportID	=	new Array();
	arReportID["REQ"]="SSREQGRPFRM";
	arReportID["RTG"]="SSRTNGRPFRM";
	formObj.p_report_id.value = arReportID[formObj.p_trn_type.value];
	if(formObj.reprint_orig.checked == true)
		formObj.p_reprint_orig.value='Y';
	else
		formObj.p_reprint_orig.value='N';
	formObj.action="../../eCommon/jsp/report_options.jsp"; 
	formObj.target="messageFrame";
	formObj.submit();
	formObj.p_doc_no.value	= "";
	formObj.p_doc_type_code.value = "";
}


function addListItem12(listObject,code,text,selectedValue) {
	if(selectedValue==null){
		selectedValue="";
	}
	var listOption = createListOption12(code,text,selectedValue);
	eval(listObject+".add(listOption)");
}

function createListOption12(code,text,selectedValue){
	var listOption	=	document.createElement('OPTION');
	listOption.text =	text;
	listOption.value=	code ;
	if(code==selectedValue){
		listOption.selected=true;
	}
	return listOption;
}

function frmdate(){
	var from_date    =  document.ReprintDocumentCriteria.p_fr_doc_date.value ;
	var to_doc_date =  document.ReprintDocumentCriteria.p_to_doc_date.value ;
	var locale=document.ReprintDocumentCriteria.p_language_id.value;
	if(locale != "en") {
		from_date = convertDate(from_date, "DMY", locale, "en");
		to_doc_date = convertDate(to_doc_date, "DMY", locale, "en");
	}

	if(from_date==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
		document.ReprintDocumentCriteria.p_fr_doc_date.focus();
		return ;
	}
	else if(to_doc_date==""){
		alert(getMessage("TO_DATE_NOT_BLANK", "SS"));
		document.ReprintDocumentCriteria.p_to_doc_date.focus();
		return ;
	}
	else if(!isBefore(from_date,to_doc_date,"DMY",'en'.value)) {
		alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
		document.ReprintDocumentCriteria.p_fr_doc_date.focus();
		return ;
	}
	else
	{
		callResultPage();
	}
}
