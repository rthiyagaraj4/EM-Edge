function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/NoteDisclaimerAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/NoteDisclaimerQueryCriteria.jsp';
}


function apply()
 {
	var mode = f_query_add_mod.document.forms[0].mode
	//alert("mode="+mode);
	var fields = new Array (f_query_add_mod.document.forms[0].note_disclaimer_id,
							f_query_add_mod.document.forms[0].note_disclaimer_desc
													
							);

	var names = new Array ( getLabel("Common.identification.label","COMMON"),
							getLabel("Common.description.label","COMMON")
														
							);

	var tttt =  f_query_add_mod.document.notedisclaimer_form.note_disclaimer_id1.value;
	if(f_query_add_mod.document.notedisclaimer_form != null)
	 {
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			if(mode != null)
			{
				if(mode.value=='update')
				{
					f_query_add_mod.document.forms[0].note_disclaimer_id1.value= f_query_add_mod.document.forms[0].note_disclaimer_id.value
					f_query_add_mod.document.forms[0].note_disclaimer_desc1.value= f_query_add_mod.document.forms[0].note_disclaimer_desc.value
					f_query_add_mod.document.forms[0].disclaimer_text1.value= f_query_add_mod.document.forms[0].disclaimer_text.value					
				}
			}
			if(f_query_add_mod.document.forms[0].applicable_to_rep_yn.checked)
				f_query_add_mod.document.forms[0].applicable_to_rep_yn.value="Y";
			else
				f_query_add_mod.document.forms[0].applicable_to_rep_yn.value="N";
			f_query_add_mod.document.notedisclaimer_form.submit();
		}
	 }
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/NoteDisclaimerAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/NoteDisclaimerAddModify.jsp?mode=update&note_disclaimer_id='+f_query_add_mod.document.forms[0].note_disclaimer_id.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset();

}
function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status1.value='E'
		}
		else
		{
			document.forms[0].eff_status1.value='D'
		}
	}
}

function checkRepAppl(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].applicable_to_rep_yn.value="Y"
		}
		else
		{
			document.forms[0].applicable_to_rep_yn.value="N"
		}
	}
}

function chopText(elem,limit)
	{
		if(elem.value.length>limit){
		elem.value=elem.value.substring(0,limit);
		var msg = getMessage('ONLY_MAX_CHARS','CA');
		msg=msg.replace('$$','200');
		alert(msg);
		//alert('You  are not allowed to enter more than 200 characters');
		}
	}
