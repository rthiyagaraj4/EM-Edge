function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/AddModifyReaction.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/ReactionQueryCriteria.jsp?function=Reaction";
}

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply() {
var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 


	var fields = new Array ( f_query_add_mod.document.Reaction_form.reaction_code );
	var names  =  new Array ( getLabel("Common.code.label","Common") );
	
//	var messageFrame = parent.frames[1].frames[2]; 

	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

		var fields = new Array ( 		f_query_add_mod.document.Reaction_form.reaction_code,
							f_query_add_mod.document.Reaction_form.long_desc,
							f_query_add_mod.document.Reaction_form.short_desc

						);

		var names = new Array ( getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common")

							  );


		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
				if(f_query_add_mod.document.Reaction_form.adverse_reaction_yn.disabled == true)
					f_query_add_mod.document.Reaction_form.adverse_reaction_yn.disabled=false;
				
				
			f_query_add_mod.document.Reaction_form.submit();
			//var fn_status = f_query_add_mod.document.Reaction_form.function_name.value;
			if(f_query_add_mod.document.Reaction_form.adverse_reaction_yn.disabled == false)
				f_query_add_mod.document.Reaction_form.adverse_reaction_yn.disabled=true;

		}
	}

}

function onSuccess() {
/*
	if(f_query_add_mod.document.Reaction_form.function_name.value=="insert")
	{
		f_query_add_mod.document.Reaction_form.disp_type.value		= "" ;
		f_query_add_mod.document.Reaction_form.long_desc.value		= "" ;
		f_query_add_mod.document.Reaction_form.short_desc.value		= "" ;
		f_query_add_mod.document.Reaction_form.adverse_reaction_yn.checked 	= false;		
		f_query_add_mod.document.Reaction_form.eff_status.checked 	= true;
	}
*/
 f_query_add_mod.location.reload();

}

function reset()
{

	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
}
function CheckForSpecCharsDesc(event)
{

   var strCheck = '`!^~$;|@&#%<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1 && whichCode != 92) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}
