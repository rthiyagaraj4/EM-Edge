
function reset(){
	f_query_add_mod.f_criteria.ReprintDocumentCriteria.reset();
	f_query_add_mod.f_result.location.href="../../eCommon/html/blank.html";
}

function run(){       
//functionality of run method is removed on Sunday, February 15, 2004
	return;
}

function populateDocTypeCode(_trn_type){
	//Added By Rams for the Authorise At Issue Store In the Reprint Doc 12/16/2009
	if(_trn_type=='AIS')
		_trn_type='REQ'
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../eST/jsp/ReprintDocumentValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function searchCodeStore( objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	dataNameArray[1]  = "facility_id";
	dataValueArray[1]  =document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}
function callResultPage(){

	var formObj		=	document.frames.ReprintDocumentCriteria;
		parent.f_result.location.href="../../eCommon/html/blank.html"
	var locale		=formObj.p_language_id.value;
	var dt_from	=	convertDate(formObj.p_fr_doc_date.value,'DMY',locale,"en");
	var dt_to	=	convertDate(formObj.p_to_doc_date.value,'DMY',locale,"en");

	var p_trn_type		= formObj.p_trn_type.value;
	var p_doc_type_code = formObj.doc_type_code.value;

	var req_by_store_code		= formObj.p_reqby_st.value;
	var req_on_store_code		= formObj.p_reqon_st.value;
	var p_doc_no		= formObj.doc_no.value;
	
	if (dt_from!="" && dt_to!=""){
		if(!doDateCheck(formObj.p_fr_doc_date,formObj.p_to_doc_date,parent.parent.messageFrame)){
			formObj.p_fr_doc_date.select();
			formObj.p_fr_doc_date.focus();
			parent.f_result.location.href = "../../eCommon/html/blank.html";
			return;
		}
	}

	var arrayObject = new Array(formObj.p_trn_type);
	var names = new Array(getLabel("Common.Transaction.label","Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject !=true){
		return;
	}
	else{
	 	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
		parent.f_result.location.href = "../../eST/jsp/SRRRePrintDocumentResult.jsp?p_trn_type="+p_trn_type+"&p_doc_type_code="+p_doc_type_code+"&req_on_store_code="+req_on_store_code+"&req_by_store_code="+req_by_store_code+"&p_doc_no="+p_doc_no+"&dt_from="+dt_from+"&dt_to="+dt_to;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}

function callReport(doc_type_code,doc_no,store_code, seq_no) {
	var formObj	=  parent.parent.f_query_add_mod.f_criteria.document.ReprintDocumentCriteria;
	formObj.p_doc_no.value	=	doc_no;
	formObj.p_doc_type_code.value	=	doc_type_code;

	if (seq_no==null)
		seq_no="";


	formObj.p_seq_no.value = seq_no;
	formObj.dest_locn_code.value=store_code;


	var arReportID	=	new Array();
	arReportID["ADJ"]="STBADJDC";
	arReportID["CEB"]="STBCEBDC";
	arReportID["ISS"]="STBISSDC";
	arReportID["MFG"]="STBMFGDC";
	arReportID["REQ"]="STBREQDC";
	arReportID["RET"]="STBRETDC";
	arReportID["SAL"]="STBSALDC";
	arReportID["SRT"]="STBSRTDC";
	arReportID["TFR"]="STBTFRDC";
	arReportID["URG"]="STBURGDC";
	arReportID["VAR"]="STBVARDC";
	arReportID["GRN"]="STBGRNDC";
	arReportID["RTV"]="STBRTVDC";
	arReportID["CON"]="STBSTCDC";
	arReportID["PRT"]="STBPTFDC";
	arReportID["AIS"]="STBATRIS2_SRR";


	formObj.p_report_id.value = arReportID[formObj.p_trn_type.value];
/*if(formObj.p_trn_type.value == 'AIS')
formObj.p_trn_type.value ='REQ'
	/*if(formObj.reprint_orig.checked == true)
		formObj.p_reprint_orig.value='Y';
	else
		formObj.p_reprint_orig.value='N';*/

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
function searchCodeItem(obj) {

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
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		document.formReprintCountSheetReportCriteria.p_item_desc.value=returnedValues[1];
		document.formReprintCountSheetReportCriteria.p_item_code.value=returnedValues[0];

		

	}
}

function searchCodeStore(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
