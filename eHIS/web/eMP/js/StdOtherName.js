function show() {
	//parent.parent.window.document.title = "Setup Country" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/AddModifyStdOtherName.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/StdOtherNameQueryCriteria.jsp?function=standardothername" ;
}

function apply() {
		
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
		
		
		var fields = new Array ( f_query_add_mod.document.Oth_family_Name_Form.other_name
				 );
		var names = new Array ( getLabel('eMP.OtherName.label','MP'));
	//if(f_query_add_mod.SpecialCharCheck(fields, names, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
		{	
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.document.Oth_family_Name_Form.submit()
		}
	}
}


function reset() {
	/*if(f_query_add_mod.document.forms[0].name == "Oth_family_Name_Form") f_query_add_mod.document.Oth_family_Name_Form.reset() ;
	else
	f_query_add_mod.location.href ="../../eMP/jsp/StdOtherNameQueryCriteria.jsp?function=standardothername" ;*/
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload() ;
}


function ChangeInitCase(Object){
	var flag=makeValidString(Object);
	if(flag == false)
		return false;

	var	objectValue = Object.value ;
	var len=objectValue.length;		    
	var objectValueAfter="";
	
	
	for(var l=0;l<len;l++)
	{
		var objectValueNow="";			
		var objectValueStr="";
		var rest="";
		var first=objectValue.charAt(l);
		first=first.toUpperCase();
		
		var objectValueStr1=objectValue.substring(l,len);
		var i=objectValueStr1.indexOf(' ');
		i=parseInt(i);

		if(i != -1)
		{
			objectValueStr=objectValueStr1.substring(0,i);
			rest=objectValueStr.substring(1,i);
			l+=objectValueStr.length;
			objectValueNow=first+rest+" ";
			objectValueAfter += objectValueNow;
			Object.value=objectValueAfter;
		}
		else
		{
			objectValueStr=objectValue.substring(l,len);
			rest=objectValue.substring(l+1,len);
			objectValueNow=first+rest;
			objectValueAfter += objectValueNow;
			Object.value=objectValueAfter;
			break;
		}

	}//end of for loop
	return true;
}

 function nextSet(start,end){
	document.dummyform.from.value = start
	document.dummyform.to.value = end
	document.dummyform.submit();
}



function removeOrderByCol() 
{  
var j=0;
var from = document.getElementById('orderbycolumns'); 
if ( from.options.length > 0 )
{
var to = document.getElementById('orderbycols');
var element = document.createElement('OPTION');
element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);   
from.remove(from.selectedIndex);
if(from.options[j]) from.options[j].selected=true;
j++; 
} 
} 

function addOrderByCol()   
{     
var i=0; var from = document.getElementById('orderbycols'); 
if ( from.options.length > 0 ) { 
	var to = document.getElementById('orderbycolumns'); 
	var element = document.createElement('OPTION'); 
	element.text = from.options[from.selectedIndex].text; 
	element.value= from.options[from.selectedIndex].value; 
	to.add(element);      
	from.remove(from.selectedIndex);
	if(from.options[i])  from.options[i].selected=true ; 
	i++;
}
}

function execQuery()
{
	var other_name_loc_lang = "";
	var other_name=document.forms[0].other_name.value;
	if(document.forms[0].other_name_loc_lang!=null)
		other_name_loc_lang=document.forms[0].other_name_loc_lang.value;
	var eff_status=document.forms[0].eff_status.value;
//	var orderbycolumns=document.getElementById("orderbycolumns");
	var orderbycolumns =document.forms[0].orderbycolumns.value;

if(document.getElementById("orderbycolumns").options.length >0 ){


parent.frames[1].location.href='../../eMP/jsp/StdOtherNameQueryResult.jsp?other_name='+other_name+'&other_name_loc_lang='+other_name_loc_lang+'&eff_status='+eff_status;

}
else
	{
	alert(getMessage('ORDERBY_NOT_BLANK','Common'));
	}
}


function focusObject()
{
	document.forms[0].other_name.focus();
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
