
function reset(){
	f_query_add_mod.f_criteria.ReprintDocumentCriteria.reset();
	f_query_add_mod.f_result.location.href="../../eCommon/html/blank.html";
}

function run(){       
//functionality of run method is removed on Sunday, February 15, 2004
//functionality of run method is added against 28715 by Sakti sankar
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
	//xmlDoc.loadXML(getXMLString(null));
	xmlDoc = new DOMParser().parseFromString(getXMLString(null),"text/xml");
	xmlHttp.open("POST", "../../eST/jsp/ReprintDocumentValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

async function searchCodeStore( objCode,objDesc) {
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

	returnedValues = await CommonLookup( getLabel("Common.Store.label","Common"), argumentArray );
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

	var formObj		=	document.ReprintDocumentCriteria;
	parent.f_result.location.href="../../eCommon/html/blank.html";
	var locale		=formObj.p_language_id.value;
	var dt_from	=	convertDate(formObj.p_fr_doc_date.value,'DMY',locale,"en");
	var dt_to	=	convertDate(formObj.p_to_doc_date.value,'DMY',locale,"en");

	var p_trn_type		= formObj.p_trn_type.value;
	var p_doc_type_code = formObj.doc_type_code.value;

	var store_code		= formObj.store_code.value;
	var p_doc_no		= formObj.doc_no.value;
	var p_seq_chk       = formObj.seq_chk.value;
	var p_include_ack   = formObj.include_ack.value; //Added By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859
	
	if (dt_from!="" && dt_to!=""){
		if(!doDateCheck(formObj.p_fr_doc_date,formObj.p_to_doc_date,parent.parent.messageFrame)){
			formObj.p_fr_doc_date.select();
			formObj.p_fr_doc_date.focus();
			return;
		}
	}

	var arrayObject = new Array(formObj.p_trn_type);
	var names = new Array(getLabel("Common.Transaction.label","Common"));
	var blankObject = checkSTFields(arrayObject, names, parent.parent.messageFrame);	
	if (blankObject !=true){
		return;
	}
	else {
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	 	parent.f_result.location.href = "../../eST/jsp/RePrintDocumentResult.jsp?p_trn_type="+p_trn_type+"&p_doc_type_code="+p_doc_type_code+"&store_code="+store_code+"&p_doc_no="+p_doc_no+"&dt_from="+dt_from+"&dt_to="+dt_to+"&p_seq_chk="+p_seq_chk+"&p_include_ack="+p_include_ack;
	}
}

function callReport(doc_type_code,doc_no,store_code, seq_no,seq_chk,sal_trn_type) {
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
        
	//if (seq_chk!=undefined)
	if (seq_chk!='')
	{
		if (seq_chk=="Y")
		{
			arReportID["ISS"]="STBISSDCSQ";
		}
		else
		{
			arReportID["ISS"]="STBISSDC";
		}
	}
	else
    {
	arReportID["ISS"]="STBISSDC";
	}
	//Added by Rabbani # Inc no:35591 on 05/10/2012 Starts 
    if(sal_trn_type == "C")
	{
	arReportID["SAL"]="STBSTCDC";
	}
    else{
	arReportID["SAL"]="STBSALDC";
	}
	//ends
	
	arReportID["MFG"]="STBMFGDC";
	arReportID["REQ"]="STBREQDC";
	arReportID["RET"]="STBRETDC";
	//arReportID["SAL"]="STBSALDC";
	arReportID["SRT"]="STBSRTDC";
	arReportID["TFR"]="STBTFRDC";
	arReportID["URG"]="STBURGDC";
	arReportID["VAR"]="STBVARDC";
	arReportID["GRN"]="STBGRNDC";
	arReportID["RTV"]="STBRTVDC";
	arReportID["CON"]="STBSTCDC";
	arReportID["PRT"]="STBPTFDC";
	arReportID["REQPIC"]="STBPKSLP";


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


function SequenceChk(obj) {
    
	var  formObj		=	document.ReprintDocumentCriteria;
	if (formObj.seq_chk.checked == true){
    formObj.seq_chk.value='Y';
	}else{
	formObj.seq_chk.value='N';
	}
	}
//Added By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859
function IncludeAckChk(obj) {
    
	var  formObj		=	document.ReprintDocumentCriteria;
	if (formObj.include_ack.checked == true){
    formObj.include_ack.value='Y';
	}else{
	formObj.include_ack.value='N';
	}
	
} //Added ends

function SequenceVisiblity(obj) {
	
    var  formObj		= document.ReprintDocumentCriteria;
	var  Obj1		    = document.getElementById('seq_chk_label');
	var  Obj2		    = document.getElementById('seq_chk');
	
	if (formObj.p_trn_type.value == 'ISS'){
    Obj1.style.visibility ='visible';
	Obj2.style.visibility ='visible';
	}
	else
	{
	Obj1.style.visibility ='hidden';
	Obj2.style.visibility ='hidden';
	}
	}
//Added By Sakti Sankar on 11/02/2013 against SCF#ML-BRU-SCF-0640 inc#36859
function IncludeAckVisiblity(obj) {
	
    var  formObj		= document.ReprintDocumentCriteria;
	
	var  Obj1		    = document.getElementById('include_ack_label');
	var  Obj2		    = document.getElementById('include_ack');
	
	if (formObj.p_trn_type.value == 'ISS' || formObj.p_trn_type.value == 'URG' || formObj.p_trn_type.value == 'TFR' || formObj.p_trn_type.value == 'RET'){
    Obj1.style.visibility ='visible';
	Obj2.style.visibility ='visible';
	}
	else
	{
	Obj1.style.visibility ='hidden';
	Obj2.style.visibility ='hidden';
	}
}//Added ends


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
   alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
   document.ReprintDocumentCriteria.p_fr_doc_date.focus();
   return ;
   }
   else if(to_doc_date==""){
   alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
   document.ReprintDocumentCriteria.p_to_doc_date.focus();
   return ;
   }
   else if(!isBefore(from_date,to_doc_date,"DMY",'en'.value)) {
   alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
   document.ReprintDocumentCriteria.p_fr_doc_date.focus();
   return ;
   }
   else
	{
	callResultPage();
    }
}
