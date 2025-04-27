function show() {
	//parent.parent.window.document.title = "Setup AlternativeID" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addAlternateID.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
//	f_query_add_mod.location.href ="../../eMP/jsp/queryAlternateID.jsp?function=alternateId" ;
	f_query_add_mod.location.href ="../../eMP/jsp/AlternateIDQueryPage.jsp?function=alternateId" ;
}

function apply() {
	
	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	var fields = new Array ( f_query_add_mod.document.alternate_id_form.alternate_id_code,
				 f_query_add_mod.document.alternate_id_form.long_desc,
				 f_query_add_mod.document.alternate_id_form.short_desc
			       );	
			       
	var names = new Array ( f_query_add_mod.getLabel('Common.type.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common') ,f_query_add_mod.getLabel('Common.shortdescription.label','common'));	
	
	var transform = new Array ( f_query_add_mod.document.alternate_id_form,
				    f_query_add_mod.document.alternate_id_form.eff_date_from,
				    f_query_add_mod.document.alternate_id_form.eff_date_from1,
				    f_query_add_mod.document.alternate_id_form.eff_date_to,
				    f_query_add_mod.document.alternate_id_form.eff_date_to1
			          );		
						   
	var splFields = new Array(f_query_add_mod.document.alternate_id_form.alternate_id_code);
	var splFieldNames = new Array(f_query_add_mod.getLabel('Common.type.label','common'));
	
	if(f_query_add_mod.SpecialCharCheck(splFields, splFieldNames, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {	
				var fn_status = f_query_add_mod.document.alternate_id_form.function_name.value ;
	/*			if(fn_status == "insert") {
					 f_query_add_mod.document.alternate_id_form.reset();
				}*/
			}	
		}
	}
}

function reset() {

       if(f_query_add_mod.document.forms[0].name == "alternate_id_form") 
            f_query_add_mod.document.alternate_id_form.reset() ;      
       else     
	    f_query_add_mod.document.query_form.reset() ;  
}

function onSuccess() {
	f_query_add_mod.location.reload();
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
