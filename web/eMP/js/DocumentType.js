function show() {
	//parent.parent.window.document.title = "Setup AlternativeID" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addDocumentType.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/DocumentTypeQueryPage.jsp?function=DocumentType" ;
//	f_query_add_mod.location.href ="../../eMP/jsp/queryDocumentType.jsp?function=DocumentType" ;
}

function apply() {
	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	//Added by Sangeetha on  19/apr/17 for KDAH-CRF-0347
	var isSuppDocFieldAvail = f_query_add_mod.document.document_type_form.isSuppDocFieldAvail.value;
	if(isSuppDocFieldAvail == "true"){
		if((f_query_add_mod.document.getElementById("addr_id").checked == false) && (f_query_add_mod.document.getElementById("iden_id").checked == false)){
			f_query_add_mod.document.document_type_form.isdocTypeSelected.value = "";
		}else{
			f_query_add_mod.document.document_type_form.isdocTypeSelected.value = "selected";
		}
		
	   var fields = new Array (  f_query_add_mod.document.document_type_form.doc_type,
								 f_query_add_mod.document.document_type_form.long_desc,
								 f_query_add_mod.document.document_type_form.short_desc,
								 f_query_add_mod.document.document_type_form.isdocTypeSelected,
								 f_query_add_mod.document.document_type_form.supp_doc_desc
							 );	
	   var names = new Array (	f_query_add_mod.getLabel('Common.type.label','common'), 
								f_query_add_mod.getLabel('Common.longdescription.label','common'), 
								f_query_add_mod.getLabel('Common.shortdescription.label','common'),
								f_query_add_mod.getLabel('eMP.SuppDocType.label','MP'),
								f_query_add_mod.getLabel('eMP.SuppDocDesc.label','MP')
							  );	

	} else{
		var fields = new Array ( f_query_add_mod.document.document_type_form.doc_type,
								 f_query_add_mod.document.document_type_form.long_desc,
								 f_query_add_mod.document.document_type_form.short_desc
								);	
		var names = new Array ( 
								f_query_add_mod.getLabel('Common.type.label','common'),
								f_query_add_mod.getLabel('Common.longdescription.label','common'),
								f_query_add_mod.getLabel('Common.shortdescription.label','common')
							  );	
	}
	
	
	var transform = new Array ( f_query_add_mod.document.document_type_form,
				    f_query_add_mod.document.document_type_form.eff_date_from,
				    f_query_add_mod.document.document_type_form.eff_date_from1,
				    f_query_add_mod.document.document_type_form.eff_date_to,
				    f_query_add_mod.document.document_type_form.eff_date_to1
			          );		

	var splField = new Array (f_query_add_mod.document.document_type_form.doc_type);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.type.label','common'));


	
	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) 
			{	
				var fn_status = f_query_add_mod.document.document_type_form.function_name.value ;
			}	
	   }
	}
}

function reset() {

       if(f_query_add_mod.document.forms[0].name == "document_type_form") 
            f_query_add_mod.document.document_type_form.reset() ;      
       else     
	    f_query_add_mod.document.query_form.reset() ;  
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function trimCheck(inString) 
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) 
	{
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
		{
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function trimString(inString) 
{
	var outString;
	var startPos;
	var endPos;
	var ch;

	startPos = 0;
	ch = inString.charAt(startPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
	{
		startPos++;
		ch = inString.charAt(startPos);
	}

	endPos = inString.length - 1;
	ch = inString.charAt(endPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
	{
		endPos--;
		ch = inString.charAt(endPos);
	}

	outString = inString.substring(startPos, endPos + 1);

	return outString;
}
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

// Added by Sangeetha on 24/apr/17 for KDAH-CRF-0347
 function callCheckMaxLen(obj,maxSize) {

		var legendName = getLabel('eMP.SuppDocDesc.label','MP') ;
        if ( obj.value.length > maxSize ) {
			var error = getMessage('REMARKS_CANNOT_EXCEED','COMMON');
			error = error.replace('$',legendName);
			error = error.replace('#',maxSize);
			alert(error);
			obj.focus();
			return false;
        }
}
