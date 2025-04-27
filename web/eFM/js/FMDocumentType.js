function create()
{
	f_query_add_mod.location.href = "../../eFM/jsp/FMDocumentTypeAddMod.jsp?" ;
} 
function query()
{
	f_query_add_mod.location.href = "../../eFM/jsp/FMDocumentTypeQueryCriteria.jsp" ;
	messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
} 
function checkIsValidForProceed()
{
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("typequery")==-1) )
        return true;
    else
        return false;
 }
function apply()
{	

 if (! (checkIsValidForProceed()) )
{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	return false;
}
	var fields = new Array (f_query_add_mod.document.DocumentType_Form.doc_type_code,	f_query_add_mod.document.DocumentType_Form.doc_type_name,
	f_query_add_mod.document.DocumentType_Form.doc_description,
	f_query_add_mod.document.DocumentType_Form.doc_number);
	var names = new Array (getLabel('Common.code.label','common'),getLabel('Common.name.label','common'),getLabel('Common.description.label','common'),getLabel('Common.documentno.label','common'));
	var field = new Array (f_query_add_mod.document.DocumentType_Form.doc_type_code,	f_query_add_mod.document.DocumentType_Form.doc_type_name,
	f_query_add_mod.document.DocumentType_Form.doc_description,
	f_query_add_mod.document.DocumentType_Form.doc_number);
	var name = new Array (getLabel('Common.code.label','common'),getLabel('Common.name.label','common'),getLabel('Common.description.label','common'),getLabel('Common.documentno.label','common'));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			f_query_add_mod.document.DocumentType_Form.submit();
		}
}
 
function onSuccess() 
{
	f_query_add_mod.location.reload();
}

function reset() 
{
	if(f_query_add_mod.document.location.href.indexOf("FMDocumentTypeQueryResult.jsp") != -1)
		return false;
	else {	
		if(f_query_add_mod.document.forms[0].name == "DocumentType_Form")
		{
		f_query_add_mod.document.DocumentType_Form.reset();		f_query_add_mod.document.DocumentType_Form.doc_type_code.focus();
		messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp";
		}

		if(f_query_add_mod.document.forms[0].name == "query_form")
		{
			f_query_add_mod.document.query_form.reset() ;
		}
	}
}
function checkLength(charlen)
{
	if (charlen.value.length > 200)
	{
		//alert("APP-FM0099 - Description cannot exceed 200 characters");
		var msg=getMessage("REMARKS_CANNOT_EXCEED","common");
		msg=msg.replace('$',getLabel("Common.description.label","common"));
		msg=msg.replace('#',200);         
		DocumentType_Form.doc_description.focus();
	}
	
}
