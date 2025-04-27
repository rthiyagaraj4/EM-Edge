/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
10/04/2013    IN30708        Karthi      To incorporate the ?Symbol? function  from Microsoft words to the Microsoft Editor in the clinical notes.
28/05/2013    IN040319        Karthi	System is not responding		
04/06/2013    IN040453      Nijitha S	CRF-CA-Bru-HIMS-CRF-221/07-Symbol->System is displaying special character in the 'Remarks' field		
20/06/2013    IN041021        Karthi	System is not displaying proper error messages 
24/06/2013	  IN041144		Karthi L	When more characters are entered in Remarks filed of Symbol master , system displays exception message 	
---------------------------------------------------------------------------------------------------------
*/
var addedRowCount = 0;

function create()
{ 
	f_query_add_mod.location.href='../../eCA/jsp/AddModifySymbol.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/CASymbolQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}
function reset(){
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
}
function apply()
{	
	var formobj= f_query_add_mod.document.Symbol;
	if(formobj != null){
		fields = new Array (f_query_add_mod.document.Symbol.symbol_id, f_query_add_mod.document.Symbol.symbol,f_query_add_mod.document.Symbol.symbol_group_desc_,f_query_add_mod.document.Symbol.symbol_remarks); 
		names = new Array( getLabel("eCA.symbolid.label",'CA'),getLabel("eCA.symbol.label",'CA'),getLabel("eCA.symbolgroups.label",'CA'),getLabel("eCA.Remarks.label",'CA')); 
		
		if(checkFieldsofMst(fields,names,messageFrame))
		{	
			f_query_add_mod.document.Symbol.action="../../servlet/eCA.CASymbolServlet";
			f_query_add_mod.document.Symbol.target="messageFrame";
			f_query_add_mod.document.Symbol.method="post";
			f_query_add_mod.document.Symbol.submit();	
		}
	}
	else {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}
}
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifySymbol.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
		     	
}

async function  getNoteGroupCode()
{	
	var symbolDescObj = document.Symbol.symbol_group_desc_.value;
	if(symbolDescObj == undefined)
	{
		symbolDescObj ="";
	}
	
	if(symbolDescObj!=""){
		var sql = "SELECT distinct SYMBOL_GROUP code, SYMBOL_GROUP_DESC description FROM ca_symbol_group where eff_status='E' and upper(SYMBOL_GROUP) like upper(?) and  upper(SYMBOL_GROUP_DESC) like upper(?) order by 2";

		var title = getLabel("eCA.symbolgroups.label","CA");

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
		argArray[5] = symbolDescObj;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );
		var str =unescape(retArray);
		var arr = str.split(",");
		if(retArray != null && retArray !="")	
		{
			document.Symbol.symbol_group_desc_.value = arr[1];
			document.Symbol.symbol_group_id_.value = arr[0];
		} 
	}
}

async function  getNoteGroupCode1()
{	
	var symbolDescObj = document.Symbol.symbol_group_desc_.value;
	if(symbolDescObj == undefined)
	{
		symbolDescObj ="";
	}


	var sql = "SELECT distinct SYMBOL_GROUP code, SYMBOL_GROUP_DESC description FROM ca_symbol_group where eff_status='E' and upper(SYMBOL_GROUP) like upper(?) and  upper(SYMBOL_GROUP_DESC) like upper(?) order by 2";

	var title = getLabel("eCA.symbolgroups.label","CA");

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
	//argArray[5] = symbolDescObj;//IN040453
	argArray[5] = "";//IN040453
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{	
		arr[1]="";
		arr[0]="";
	}				
	document.Symbol.symbol_group_desc_.value = "";  //added for IN040319 
	if(retVal != null && retVal !="")	
	{
		document.Symbol.symbol_group_desc_.value = arr[1];
		document.Symbol.symbol_group_id_.value = arr[0];
	} 
}
function setEffStauts(obj){
	if(obj.checked){
		document.Symbol.eff_status.value="E";
	}else{
		document.Symbol.eff_status.value="D";
	}
}

function CheckForPromptSpecChars(event){
   if ((event.keyCode > 64 && event.keyCode < 91) || (event.keyCode > 96 && event.keyCode < 123) || (event.keyCode > 47 && event.keyCode < 58) || event.keyCode == 8 || event.keyCode == 36 || event.keyCode == 38 || event.keyCode == 94 || event.keyCode == 124 || event.keyCode == 126) {
		//alert(" You should not enter alpha, numeric and following symbols: ~, $, &, ^, | "); // commented for IN041021
		alert(getMessage("CA_ALPHA_NUMERIC_SYMBOL","CA")); // modified for IN041021
		return false;
	}	
	else
	{
		return true;
	}
}
function CheckForPromptSpecChars1(keydata){
	var whichCode = keydata.value;
	
	var keycode = whichCode.charCodeAt(0);	
	//IN043895 Start.
	//if ((keycode > 64 && keycode < 91) || (keycode > 96 && keycode < 123) || (keycode > 47 && keycode < 58) || keycode == 8 || keycode == 36 || keycode == 38 || keycode == 94 || keycode == 124 || keycode == 126) {
	if ( keycode == 8 || keycode == 36 || keycode == 38 || keycode == 94 || keycode == 124 || keycode == 126) {
	// IN043895 End.
		document.Symbol.symbol.value ="";
		//alert(" You should not enter alpha, numeric and following symbols: ~, $, &, ^, | "); // commented for IN041021
		alert(getMessage("CA_ALPHA_NUMERIC_SYMBOL","CA")); // modified for IN041021
		document.Symbol.symbol.select();
		document.Symbol.symbol.focus();
		return false;		
	}		
	else
	{
		return true;
	}
}
function refreshFooter(){
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
}
//IN041144 - Start
function callCheckMaxLength(obj,max) {
        if(obj.value.length > max) {
           alert(getMessage('EXCEED_MAX_LENGTH',"CP"));
		    obj.focus();
			obj.select();
        } else return true;
}
