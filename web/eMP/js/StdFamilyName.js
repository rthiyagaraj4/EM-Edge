function show() {
	//parent.parent.window.document.title = "Setup Country" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/AddModifyStdFamilyName.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMP/jsp/StdFamilyNameQueryCriteria.jsp?function=standardfamilyname" ;
}

function apply() {
		
		
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }		
		
		var fields = new Array ( f_query_add_mod.document.Std_family_Name_Form.last_name
				 );
		var names = new Array ( getLabel('Common.FamilyName.label','common'));

	//if(f_query_add_mod.SpecialCharCheck(fields, names, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
		{	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.document.Std_family_Name_Form.submit()
		}
	}
}


function reset() {
	/*	if(f_query_add_mod.document.forms[0].name == "Std_family_Name_Form") f_query_add_mod.document.Std_family_Name_Form.reset() ;
		else
			f_query_add_mod.location.href ="../../eMP/jsp/StdFamilyNameQueryCriteria.jsp?function=standardfamilyname" ;*/
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

//These Functions are moved here from SearchStdFamilyNameCriteria.jsp
function callsearch(){
	//parent.frames[1].location.href="../jsp/SearchStdFamilyNameResult.jsp?last_name="+document.forms[0].last_name.value+"&last_name_loc_lang="+document.forms[0].last_name_loc_lang.value+"&criteria="+document.forms[0].criteria.value;
	var HTMLVal = new String();
	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/SearchStdFamilyNameResult.jsp'>"+
			  "<input type='hidden' name='last_name' id='last_name' value='"+document.forms[0].last_name.value+"'> "+
			  " <input type='hidden' name='last_name_loc_lang' id='last_name_loc_lang' value='" + document.forms[0].last_name_loc_lang.value +"'>"+
			  "<input type='hidden' name='criteria' id='criteria' value='" + document.forms[0].criteria.value +"'></form></BODY></HTML>";
			  

	parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);

	parent.frames[1].document.form1.submit();
}
    
function callclose()
{
	 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	   dialogTag.close();   
	//parent.window.close()
}

//These Functions are moved here from SearchStdFamilyNameResult.jsp
function closeWin(last_name,last_name_local_lang)
{
	//parent.window.returnValue= last_name +"`"+last_name_local_lang
	//parent.window.close()
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = last_name +"`"+last_name_local_lang;
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close(); 
}
    
function nextSet(start,end)
{
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
	var last_name_loc_lang = "";
	var last_name=document.forms[0].last_name.value;
	if(document.forms[0].last_name_loc_lang!=null)
		last_name_loc_lang=document.forms[0].last_name_loc_lang.value;
	var eff_status=document.forms[0].eff_status.value;
	var orderbycolumns =document.forms[0].orderbycolumns.value;

if(document.getElementById("orderbycolumns").options.length >0 ){


parent.frames[1].location.href='../../eMP/jsp/StdFamilyNameQueryResult.jsp?last_name='+last_name+'&last_name_loc_lang='+last_name_loc_lang+'&eff_status='+eff_status;

}
else
	{
	alert(getMessage('ORDERBY_NOT_BLANK','Common'));
	}
}


function focusObject()
{
	document.forms[0].last_name.focus();
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

