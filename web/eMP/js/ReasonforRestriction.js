function show() {
	//parent.parent.window.document.title = "Setup AlternativeID" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/AddModifyReasonforRestriction.jsp";
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/queryReasonforRestriction.jsp" ;
}

function apply() {
		
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
		
	var fields = new Array ( f_query_add_mod.document.reason_for_restriction_form.reason_code,
				 f_query_add_mod.document.reason_for_restriction_form.long_desc,
				 f_query_add_mod.document.reason_for_restriction_form.short_desc
			       );	
			       
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common'), f_query_add_mod.getLabel('Common.shortdescription.label','common') );	
	
				   
	var splField = new Array (f_query_add_mod.document.reason_for_restriction_form.reason_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));
		
	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
	{

		if (f_query_add_mod.checkFieldsofMst(fields, names, messageFrame)) 
		{	

					var fn_status = f_query_add_mod.document.reason_for_restriction_form.function_name.value;
					f_query_add_mod.document.reason_for_restriction_form.submit();
		}	
	}	
}

function reset() {
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

function updateEffStatus()
{
	if(document.forms[0].eff_status.checked===true)
	   document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
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
