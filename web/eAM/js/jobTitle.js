 
function create() {
	//f_query_add_mod.location.href = "../../eAM/jsp/addAgeRange.jsp" ;
f_query_add_mod.location.href = "../../eAM/jsp/addModifyJobTitle.jsp";
}


function query() {
		 f_query_add_mod.location.href ="../../eAM/jsp/JobTitleQueryCriteria.jsp" ;
 
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
	
	    if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array (	parent.frames[1].frames[1].document.job_title_form.job_title_code,
						parent.frames[1].frames[1].document.job_title_form.job_title_desc
						
					    );
	var names = new Array (
						getLabel("Common.code.label","Common"),
						getLabel("Common.description.label","Common")

						  );

messageFrame=parent.frames[1].frames[1];
if(parent.frames[1].frames[1].checkFieldsofMst( fields, names, messageFrame)) {
	 f_query_add_mod.document.job_title_form.submit();

					}

	
}


function reset()
	{
		if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
		
		}
	







function onSuccess() {
	f_query_add_mod.location.reload() ;
}












