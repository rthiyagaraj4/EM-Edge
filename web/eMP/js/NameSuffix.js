function show() {
	//parent.parent.window.document.title = "Setup Country" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addNameSuffix.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
//	f_query_add_mod.location.href ="../../eMP/jsp/queryNameSuffix.jsp?function=nameSuffix" ;
	f_query_add_mod.location.href ="../../eMP/jsp/NameSuffixQueryPage.jsp?function=nameSuffix" ;
}

function apply() {

	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	
	var fields = new Array ( f_query_add_mod.document.namesuffix_form.name_suffix,
				f_query_add_mod.document.namesuffix_form.baby_suffix_yn
			 );
	var names = new Array ( f_query_add_mod.getLabel('Common.name.label','common')+ " " +f_query_add_mod.getLabel('eMP.Suffix.label','MP'), f_query_add_mod.getLabel('eMP.BabySuffix.label','MP')
				 );
	var transform = new Array (	f_query_add_mod.document.namesuffix_form,
					f_query_add_mod.document.namesuffix_form.eff_date_from,
					f_query_add_mod.document.namesuffix_form.eff_date_from1,
					f_query_add_mod.document.namesuffix_form.eff_date_to,
					f_query_add_mod.document.namesuffix_form.eff_date_to1
				   );
	var splField = new Array (f_query_add_mod.document.namesuffix_form.name_suffix);
	var splFieldName = new Array ( f_query_add_mod.getLabel('Common.name.label','common')+ " " +f_query_add_mod.getLabel('eMP.Suffix.label','MP'));

	//if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.namesuffix_form.function_name.value ;

			}
		}
	}

}

function reset() {
	//f_query_add_mod.document.namesuffix_form.reset() ;
		if(f_query_add_mod.document.forms[0].name == "namesuffix_form") 
			f_query_add_mod.document.namesuffix_form.reset() ;
		else f_query_add_mod.document.query_form.reset() ;
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

function makeValidString1(txtObj)
{ 
	
	var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {  
		text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

   /*
   for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
				alert(text_value);
                i++;
            }
        }
    }
	*/

    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}
function CheckForSpecChars(event){
	var strCheck = '&+%()|/\\><';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if (!(strCheck.indexOf(key) == -1))
	   return false;  
	return true ;
}

function CheckSpecCh(event){
	var strCheck = '%<>&';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if (!(strCheck.indexOf(key) == -1))
	   return false;  
	return true ;
}
