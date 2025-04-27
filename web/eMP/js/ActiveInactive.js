function show() {
	//parent.parent.window.document.title = "Setup AlternativeID" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addActiveInactive.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/ActiveInactiveQueryPage.jsp?function=InactiveReason" ;
//	f_query_add_mod.location.href ="../../eMP/jsp/queryActiveInactive.jsp?function=InactiveReason" ;
}

function apply() {

	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
		
	var fields = new Array ( f_query_add_mod.document.active_inactive_form.reason_code,
				 f_query_add_mod.document.active_inactive_form.long_desc,
				 f_query_add_mod.document.active_inactive_form.short_desc
			       );	
			       
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common'), f_query_add_mod.getLabel('Common.shortdescription.label','common') );	
	
	var transform = new Array ( f_query_add_mod.document.active_inactive_form,
				    f_query_add_mod.document.active_inactive_form.eff_date_from,
				    f_query_add_mod.document.active_inactive_form.eff_date_from1,
				    f_query_add_mod.document.active_inactive_form.eff_date_to,
				    f_query_add_mod.document.active_inactive_form.eff_date_to1
			          );		
				   
	var splField = new Array (f_query_add_mod.document.active_inactive_form.reason_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));
		
	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
	{
		if (f_query_add_mod.checkFieldsofMst(fields, names, messageFrame)) 
		{
			if(f_query_add_mod.DateTransform(transform,messageFrame)) 
				{	
					var fn_status = f_query_add_mod.document.active_inactive_form.function_name.value ;
				}	
		}
	}
	/*
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	
	if ( errors.length != 0 ) 
	{
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false ;
	}
	*/

	

	
}

function reset() {

       /*if(f_query_add_mod.document.forms[0].name == "active_inactive_form") 
            f_query_add_mod.document.active_inactive_form.reset() ;      
       else     
	    f_query_add_mod.document.query_form.reset() ;  */
	f_query_add_mod.document.forms[0].reset() ; 
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

//Added on 2/21/2005
function assignvalue()
{
	if(document.forms[0].reason_for_active_yn[0].checked===true)
	   document.forms[0].reason_for_active_yn.value="Y";
	else
		document.forms[0].reason_for_active_yn.value="N";
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
