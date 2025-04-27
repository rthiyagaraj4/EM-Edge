var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";

function reset(){
	f_query_add_mod.location.reload();
}
function run(){       
	var formObj=  f_query_add_mod.document.MfgItemLabelCriteria;
	var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_doc_no,formObj.p_no_labels);
	var names = new Array(getLabel("Common.DocType.label", "Common"),getLabel("Common.DocNo.label", "Common"),getLabel("eST.NoofCopies.label","ST"));
	var blankObject = checkSTFields(arrayObject, names, messageFrame);	
	if (blankObject==true) 
		formObj.submit();
}