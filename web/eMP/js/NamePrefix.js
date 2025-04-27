function show() {
	//parent.parent.window.document.title = "Setup Country" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addNamePrefix.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
//	f_query_add_mod.location.href ="../../eMP/jsp/queryNamePrefix.jsp?function=nameprefix" ;
	f_query_add_mod.location.href ="../../eMP/jsp/NamePrefixQueryPage.jsp?function=nameprefix" ;
}

function apply() {
		
	  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }	
		
//		CheckChars1(f_query_add_mod.document.nameprefix_form.name_prefix);
		var fields = new Array ( f_query_add_mod.document.nameprefix_form.name_prefix,
				 f_query_add_mod.document.nameprefix_form.prefix_sex
				 );
		var names = new Array ( f_query_add_mod.getLabel('Common.name.label','common')+" "+ f_query_add_mod.getLabel('eMP.prefix.label','MP'), f_query_add_mod.getLabel('eMP.PrefixSex.label','MP')					
				      );
		var transform = new Array (	f_query_add_mod.document.nameprefix_form,
						f_query_add_mod.document.nameprefix_form.eff_date_from,
						f_query_add_mod.document.nameprefix_form.eff_date_from1,
						f_query_add_mod.document.nameprefix_form.eff_date_to,
						f_query_add_mod.document.nameprefix_form.eff_date_to1
					   );
	var splField = new Array (f_query_add_mod.document.nameprefix_form.name_prefix);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.name.label','common')+" "+ f_query_add_mod.getLabel('eMP.prefix.label','MP'));

	//if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.nameprefix_form.function_name.value ;
			}
		}
	}
}


function reset() {
		if(f_query_add_mod.document.forms[0].name == "nameprefix_form")	
            f_query_add_mod.document.nameprefix_form.reset() ;      
		else 
			f_query_add_mod.document.query_form.reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}


 function closeWin(name_prefix_suffix)
{

	np = document.getElementById(name_prefix_suffix).innerText;
	parent.window.returnValue= escape(np);
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
	//parent.window.close()
}

 function nextSet(start,end)
 {
	 document.dummyform.from.value = start
	 document.dummyform.to.value = end
	 document.dummyform.submit();
 }

 function callfunc()
{
	document.getElementById("td3").style.display="none";		
	document.getElementById("td1").style.display="inline";
	document.getElementById("td1").style.visibility="visible";
	document.getElementById("name_prefix_suffix_loc_lang").style.visibility="hidden";
	document.getElementById("td2").style.display="inline";
	document.getElementById("td2").style.visibility="visible";
	document.getElementById("td2").innerHTML = "";
}

function callclose()
{
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
	//parent.window.close()
}

	function callsearch(optValue)
{
	var HTMLVal = new String();
	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/SearchNamePrefixSuffixResult.jsp'>"+
			  "<input type='hidden' name='name_prefix_suffix' id='name_prefix_suffix' value='"+document.forms[0].name_prefix_suffix.value+"'> "+
			  " <input type='hidden' name='name_prefix_suffix_loc_lang' id='name_prefix_suffix_loc_lang' value='" + document.forms[0].name_prefix_suffix_loc_lang.value +"'>"+
			  "<input type='hidden' name='criteria' id='criteria' value='" + document.forms[0].criteria.value +"'>"+
			  "<input type='hidden' name='opt' id='opt' value='"+optValue+"'></form></BODY></HTML>";
			  
	parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[1].document.form1.submit();
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


/*
 function CheckChars1(obj) {
   var sequence = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_~``-=!@#$%^*-P";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert('You have entered one or more invalid characters - try again!');
			obj.value='';
			obj.focus();			
			return false;
		}
   }

   return true ;
}
*/

