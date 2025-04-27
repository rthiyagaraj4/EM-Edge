/*
												Developed by		   :		Geetha C R
												Developed on	 	   :	 	02/02/2001
												Modified by      		   :
												Modified Date	       :										*/



/*Common Javascript for the function*/

/* to call the addmodify jsp when 'create' button  is clicked*/
function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/CircumstanceofInjuryAddModify.jsp" ;
}
/* not used now*/
function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}
/* to call the query criteria jsp when 'Query' button is clicked*/
function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/CircumstanceofInjuryQueryCriteria.jsp";
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
/* to pass mandatory fields and their names to checkfields function */
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

	var fields = new Array ( f_query_add_mod.document.CircumstanceofInjury_form.circumstance_of_injury_code );
	var names  =  new Array ( getLabel("Common.code.label","Common") );
	
	//var messageFrame = parent.frames[1].frames[2]; 
	

	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){


	var fields = new Array (f_query_add_mod.document.CircumstanceofInjury_form.circumstance_of_injury_code,
				f_query_add_mod.document.CircumstanceofInjury_form.long_desc,
				f_query_add_mod.document.CircumstanceofInjury_form.short_desc

				    );

	var names = new Array (getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
					        getLabel("Common.shortdescription.label","Common")

						 );

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			 var fn_status = f_query_add_mod.document.CircumstanceofInjury_form.function_name.value ;
			f_query_add_mod.document.CircumstanceofInjury_form.injury_reimbursement_type.disabled=false;
			f_query_add_mod.document.CircumstanceofInjury_form.short_desc.disabled	= false ;
			f_query_add_mod.document.CircumstanceofInjury_form.long_desc.disabled	= false ;

			f_query_add_mod.document.CircumstanceofInjury_form.submit();

		}
	}
}

/*to reinitialize the function name and items once the operation is successful*/
/* called by the ejb*/
function onSuccess() 
{
	/*if(f_query_add_mod.document.CircumstanceofInjury_form.function_name.value == "insert") 
	{
		f_query_add_mod.document.CircumstanceofInjury_form.injury_reimbursement_type.value	= "" ;
		f_query_add_mod.document.CircumstanceofInjury_form.short_desc.value	= "" ;
		f_query_add_mod.document.CircumstanceofInjury_form.long_desc.value	= "" ;
		f_query_add_mod.document.CircumstanceofInjury_form.circumstance_of_injury_code.value	= "" ;
		f_query_add_mod.document.CircumstanceofInjury_form.eff_status.checked=true;
		
		f_query_add_mod.document.CircumstanceofInjury_form.locntype_ind.options[0].selected=true;
	}
	else
	{

		if (f_query_add_mod.document.CircumstanceofInjury_form.eff_status.checked==false)
		{
			f_query_add_mod.document.CircumstanceofInjury_form.injury_reimbursement_type.disabled=true;
			f_query_add_mod.document.CircumstanceofInjury_form.short_desc.disabled	= true ;
			f_query_add_mod.document.CircumstanceofInjury_form.long_desc.disabled	= true ;
		}
		else
		{
			f_query_add_mod.document.CircumstanceofInjury_form.short_desc.disabled	= false ;
			f_query_add_mod.document.CircumstanceofInjury_form.long_desc.disabled	= false ;

		}
		
	}
	*/
	f_query_add_mod.location.reload();
}

/*to clear all fields and  initialize the fn and fields*/
function reset() {

	if(f_query_add_mod.document.forms[0])
	//f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.location.reload();

	//f_query_add_mod.location.reload();

}

/* disable the check box if the fn is modify*/
function checkboxdisable()
{

	if (CircumstanceofInjury_form.function_name.value=="modify")
	{
	CircumstanceofInjury_form.ud.disabled=true;

	}
}

/*Assign value to check box*/

function checkboxvalue()
{
	if (CircumstanceofInjury_form.eff_status.checked == true)
	CircumstanceofInjury_form.eff_status.value="E";
	else
	CircumstanceofInjury_form.eff_status.value="D";
}
function changeCase(Obj)
{
	Obj.value=Obj.value.toUpperCase();

}
