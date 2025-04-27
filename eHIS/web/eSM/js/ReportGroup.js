function create() {

	f_query_add_mod.location.href = "../../eSM/jsp/addReportGroup.jsp" ;
}

function query() {
	
	f_query_add_mod.location.href ="../../eSM/jsp/queryReportGroup.jsp?function=Report Group" ;
}

function checkFields1( fields, names, messageFrame) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common"); 
			errors = errors.replace('$',names[i]);
			errors = errors + "\n" ;

		}	
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}



function apply() {

	var to_proceed = true;
if(f_query_add_mod.document.reportgroup_form!=null){
	if (parseInt(f_query_add_mod.document.reportgroup_form.Dflt_No_Of_Copies.value) == 0)
	{
		alert(f_query_add_mod.getMessage("COPY_GR_ZERO",'SM'));
		to_proceed=false;
	}

	if (f_query_add_mod.document.reportgroup_form.Dflt_No_Of_Copies.value.length == 0)
	{
		f_query_add_mod.document.reportgroup_form.Dflt_No_Of_Copies.value = 1;
	}


	if (to_proceed==true)
	{
	 var fields = new Array ( f_query_add_mod.document.reportgroup_form.id,
				  f_query_add_mod.document.reportgroup_form.long_desc,
				  f_query_add_mod.document.reportgroup_form.short_desc
				);
	 var names  = new Array ( f_query_add_mod.getLabel("Common.identification.label","Common"),
		                  f_query_add_mod.getLabel("Common.longdescription.label","Common"),
				  f_query_add_mod.getLabel("Common.shortdescription.label","Common")
				 );

	 var field = new Array ( f_query_add_mod.document.reportgroup_form.id );

	 var name  = new Array ( f_query_add_mod.getLabel("Common.identification.label","Common") );
	
			 var transform = new Array ( f_query_add_mod.document.reportgroup_form,
							 f_query_add_mod.document.reportgroup_form.eff_date_from,
							 f_query_add_mod.document.reportgroup_form.eff_date_from1,
						 f_query_add_mod.document.reportgroup_form.eff_date_to,
						 f_query_add_mod.document.reportgroup_form.eff_date_to1
					   );

			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{
				if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
				{
				   if(f_query_add_mod.DateTransform(transform,messageFrame)) 
				   { }
				}
			}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=";
	}
}else{
   frames[0].location.reload();
   return false;
}
}


function onSuccess()
{

		f_query_add_mod.document.location.reload();
}
function reset() {
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.location.reload() ;
}
