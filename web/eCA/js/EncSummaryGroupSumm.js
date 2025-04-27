/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
13/09/2013     		1   		Sethuraman      Created for Adding encounter Summary
-------------------------------------------------------------------------------------------------------------------------------------
*/
function create()
{	
	f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupSummAddModify.jsp?mode=insert';
}

function query()
{	
	f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupSummQueryCriteria.jsp';
}

function apply()
{
	var mode = f_query_add_mod.document.forms[0].mode;

	var fields = new Array (f_query_add_mod.document.forms[0].es_summ_code,
							f_query_add_mod.document.forms[0].es_summ_desc,
							f_query_add_mod.document.forms[0].es_summ_title							
						);

	var names = new Array ( f_query_add_mod.getLabel("Common.code.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							f_query_add_mod.getLabel("eCA.Title.label",'ca')							
						);

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{	
		if(mode != null)
		{			
			f_query_add_mod.document.forms[0].es_summ_code1.value= f_query_add_mod.document.forms[0].es_summ_code.value;
			f_query_add_mod.document.forms[0].es_summ_desc1.value= f_query_add_mod.document.forms[0].es_summ_desc.value;
			f_query_add_mod.document.forms[0].es_summ_title1.value= f_query_add_mod.document.forms[0].es_summ_title.value;			
			f_query_add_mod.document.forms[0].es_summ_status1.value= f_query_add_mod.document.forms[0].es_summ_status.value;
			
			f_query_add_mod.document.forms[0].es_summ_type1.value= f_query_add_mod.document.forms[0].es_summ_type.value;
		}	
		f_query_add_mod.document.SummGroupSummForm.submit();	
	}
 }


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupSummAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{			
		f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupSummAddModify.jsp?mode=update&es_summ_code='+f_query_add_mod.document.forms[0].es_summ_code.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

	f_query_add_mod.location.reload();

}
function checkForMode(objCheck)
{	
	if(objCheck.checked== true)
	{
		document.forms[0].es_summ_status1.value='E';
	}
	else
	{
		document.forms[0].es_summ_status1.value='D';
	}	
}

function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
			obj.select();
			return false;
		}
		if(parseInt(obj.value,10)  == 0)
		{
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				obj.select();
				return false;
		}
	}	
}


function checkdefaultdesc()
{		
    var text_value  =   document.forms[0].es_summ_desc.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    document.forms[0].es_summ_desc.value = text_value;
}

function checkForMaxCharacter(objTextArea)
{
	if(objTextArea.value != '')
	{
		if(objTextArea.value.length > 200)
		{
			return false;
		}
		else
			return true;
	}
}

function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function ChangeUpperCase(Object) 
{
    var objectfield = Object ;
    objectfield.value = objectfield.value.toUpperCase();
}

function CheckForNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function chkMaxLenForLongTest(textarea_name,maxLen)
{	
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 3000;
	}
	
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var val	 = textArea.value;
	var valLength	 = val.length;	
	if (parseInt(valLength)  > maxLen)
	{		
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$","Constructed Parameter list");
		msg = msg.replace("#",maxLen);
		alert(msg);
		textArea.focus();
		return false;
	}
	
}

function chopText(elem,limit)
{	
	if(elem.value.length>limit){
	elem.value=elem.value.substring(0,limit);
	var msg = getMessage('ONLY_MAX_CHARS','CA');
	msg=msg.replace('$$','200');
	alert(msg);
	}
}

function getSummCode(objCode)
{	
	var mode = document.SummGroupSummForm.mode.value;
	
	if(objCode.name=='es_summ_code')
	{		
		if (mode != 'insert')
		{
			summCodeSearch(objCode);	
		}
	}	
	if(objCode.name == "SummCodesrch")
	{
		callSummCodeType();
	}			
}

function summCodeSearch(objCode)
{
	var summCode = objCode.value;
	
	if(summCode == '')
	{
		document.SummGroupSummForm.flag.value='true';
		return false;
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' " +
				"language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<body  onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummGroupSummIntermediate.jsp'>" +
				"<input type=hidden name='es_summ_code' id='es_summ_code' value='"+summCode+"'>" +
						"</form></body></html>";
		parent.BlankFrame.document.write(HtmlVal);
		parent.BlankFrame.document.tempform.submit();
	}
	setTimeout("reloadFrames()",50);
}

function callSummCodeType()
{	
	var sql = "";
	
	sql = "SELECT es_summ_code code, es_summ_desc description FROM cr_es_summ_hdr where upper(es_summ_code) like upper(?) and  upper(es_summ_desc) like upper(?) ORDER BY  es_summ_desc";		
	
	var title = getLabel("Common.GroupSubFlag.label","Common");
	var target = document.SummGroupSummForm.es_summ_code;
	target.value = "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
		document.SummGroupSummForm.es_summ_desc.value = retArray[1];
		document.SummGroupSummForm.es_summ_code.value = retArray[0];
	}
	else
	{
		document.SummGroupSummForm.es_summ_desc.value = '';
		document.SummGroupSummForm.es_summ_code.value = '';
	}

	setTimeout("reloadFrames()",50);
}

function callSummCodeType1(sql,title,target)
{	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
}

