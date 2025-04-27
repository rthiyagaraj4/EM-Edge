
function reset(){
	f_query_add_mod.f_criteria.ReprintDocumentCriteria.reset();
	f_query_add_mod.f_result.location.href="../../eCommon/html/blank.html";
}

function run(){       
//functionality of run method is removed on Sunday, February 15, 2004
	return;
}

function populateDocTypeCode(_trn_type){
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/POReprintDocumentValidate.jsp?trn_type="+_trn_type+"&validate=POPULATE_DOC_TYPE_CODE", false);
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
	//alert(p_trn_type);
	var p_doc_type_code = formObj.doc_type_code.value;

	var store_code		= formObj.store_code.value;
	var p_doc_no		= formObj.doc_no.value;
	//alert(p_doc_no);
	var pur_unit       = formObj.pur_unit.value;
	var supp_code       = formObj.to_supplier.value
	
	
	if (dt_from!="" && dt_to!=""){
		if(!doDateCheck(formObj.p_fr_doc_date,formObj.p_to_doc_date,parent.parent.messageFrame)){
			formObj.p_fr_doc_date.select();
			formObj.p_fr_doc_date.focus();
			return;
		}
	}

	var arrayObject = new Array(formObj.p_trn_type);
	var names = new Array(getLabel("Common.Transaction.label","Common"));
	var blankObject = checkPOFields(arrayObject, names, parent.parent.messageFrame);	
	if (blankObject !=true){
		return;
	}
	else
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
	 	parent.f_result.location.href = "../../ePO/jsp/PORePrintDocumentResult.jsp?p_trn_type="+p_trn_type+"&p_doc_type_code="+p_doc_type_code+"&store_code="+store_code+"&p_doc_no="+p_doc_no+"&dt_from="+dt_from+"&dt_to="+dt_to+"&pur_unit="+pur_unit+"&supp_code="+supp_code;
}


function callReport(doc_no, store_code){

	var formObj	=  parent.parent.f_query_add_mod.f_criteria.document.ReprintDocumentCriteria;

	formObj.p_doc_no.value	=	doc_no; 	 
	formObj.dest_locn_code.value=store_code;

	var arReportID	=	new Array();
	 arReportID["PORDER"] ="POBORDER";
     arReportID["POREQN"] ="POBREQST";
     arReportID["DLVORD"] ="POBDELVORD";

	formObj.p_report_id.value = arReportID[formObj.p_trn_type.value];
	formObj.submit();
	formObj.p_doc_no.value	= "";
	//formObj.p_doc_type_code.value = "";
}


function SequenceChk(obj) {
    
	var  formObj		=	document.ReprintDocumentCriteria;
	if (formObj.seq_chk.checked == true){
    formObj.seq_chk.value='Y';
	}else{
	formObj.seq_chk.value='N';
	}
	}

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

//19/06/12
function loaddoctype()
{
//alert(document.ReprintDocumentCriteria.p_trn_type.value);

             var store1 = document.getElementById('store1');
			 var storedesc = document.getElementById('store_desc');
			 var but = document.getElementById('but1');
			 var suplierlabel = document.getElementById('suplierlabel');
			 var suplier = document.getElementById('suplier');
			 var purcode = document.getElementById('purcode');
			 var pur1 = document.getElementById('pur1');
			 var MASTER_TYPE ="";
			 

if(document.ReprintDocumentCriteria.p_trn_type.value == "POREQN"){

             MASTER_TYPE = "POREQN";
             suplierlabel.style.visibility ='hidden';
	         suplier.style.visibility ='hidden';
			 store1.style.visibility ='visible';
			 storedesc.style.visibility ='visible';
			 but.style.visibility ='visible';
			 pur1.style.visibility ='visible'; 
             purcode.style.visibility ='visible';

}else if(document.ReprintDocumentCriteria.p_trn_type.value == "PORDER"){
             MASTER_TYPE = "PORDER";
             store1.style.visibility ='hidden';
			 storedesc.style.visibility ='hidden';
			 but.style.visibility ='hidden';
			 store1.style.display ="";
			 storedesc.style.display ="";			 
			 suplierlabel.style.visibility ='visible';
             suplier.style.visibility ='visible';
			 pur1.style.visibility ='visible'; 
             purcode.style.visibility ='visible'; 
}
else if(document.ReprintDocumentCriteria.p_trn_type.value == "DLVORD"){
             MASTER_TYPE = "DLVORD";
             store1.style.visibility ='hidden';
			 storedesc.style.visibility ='hidden';
			 but.style.visibility ='hidden';
			 suplierlabel.style.visibility ='visible';
             suplier.style.visibility ='visible'; 
             pur1.style.visibility ='hidden'; 
             purcode.style.visibility ='hidden'; 
}
 
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/POReprintDocumentValidate.jsp?trn_type="+MASTER_TYPE+"&validate=POPULATE_DOC_TYPE_CODE", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	document.ReprintDocumentCriteria.doc_type_code.focus();

}





function loadpurunitcode()
{
 
//if(document.ReprintDocumentCriteria.p_trn_type.value == "PORDER"){
   var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null));
	xmlHttp.open("POST", "../../ePO/jsp/POReprintDocumentValidate.jsp?&validate=POPULATE_PUR_UNIT_CODE"+"&trn_type="+document.ReprintDocumentCriteria.p_trn_type.value, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
	//document.ReprintDocumentCriteria.doc_type_code.focus();

//}
}

function specialCharacterCheck(fieldObj)
{
	var fieldValue = fieldObj.value;
	
	if(fieldValue != "" && fieldValue.search(/[^a-zA-Z0-9.,\/ ]/g) != -1){
		alert("please enter alpha numeric characters only");
		fieldObj.focus();
		return false;
	
	}
	else
	return true;
		
		
}





