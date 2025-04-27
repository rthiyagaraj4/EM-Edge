function check_length()
{
	if(f_query_add_mod.document.complaint_form.complaint_desc.value.length > 200)
	{
		//alert("APP-SM0045 - Complaint Description cannot exceed 200 characters");
		return false;
	}
	else
		return true;
}

function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyComplaint.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/ComplaintqueryCriteria.jsp";
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
	var fields = new Array ( f_query_add_mod.document.complaint_form.complaint_code );
	var names  =  new Array ( getLabel("Common.code.label","Common") );
	//var messageFrame = parent.frames[1].frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

		var fields = new Array ( f_query_add_mod.document.complaint_form.complaint_code,
							f_query_add_mod.document.complaint_form.complaint_desc
						);
		var names = new Array ( getLabel("Common.code.label","Common"),
					 getLabel("Common.description.label","Common"));

		if(check_length())
		{
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
						f_query_add_mod.document.complaint_form.submit();
						var fn_status = f_query_add_mod.document.complaint_form.function_name.value ;
			}
		}
		else
		{
			messageFrame.location.href = error_page+"?err_num="+getMessage("DESCRIPTION_CHECK_200","AM");
		}
	}
}

function onSuccess() {
/*
if(f_query_add_mod.document.complaint_form.function_name.value=="insert")
{

	f_query_add_mod.document.complaint_form.complaint_code.value	= "" ;
	f_query_add_mod.document.complaint_form.complaint_desc.value	= "" ;
	f_query_add_mod.document.complaint_form.eff_status.checked	=true ;


}
*/
f_query_add_mod.location.reload();
}

function reset() {

			if(f_query_add_mod.document.forms[0]) 
				f_query_add_mod.document.location.reload();
				//f_query_add_mod.document.forms[0].reset();
	//f_query_add_mod.location.reload();



}
