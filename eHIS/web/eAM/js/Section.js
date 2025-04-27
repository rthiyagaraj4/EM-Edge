
function Change() 
{
 if (section_form.eff_status.checked == true)
	section_form.eff_status.value="E";
 else
	section_form.eff_status.value="D";
}
function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/AddModifySection.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/SectionQueryCriteria.jsp?function=section";
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
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array (f_query_add_mod.document.section_form.dept_code,
						f_query_add_mod.document.section_form.section_code,
						f_query_add_mod.document.section_form.long_desc,
						f_query_add_mod.document.section_form.short_desc

				    );



	var names = new Array ( getLabel("Common.acctdept.label","Common"),
							getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common")
					      );

	var spFields = new Array (f_query_add_mod.document.section_form.section_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

		f_query_add_mod.document.section_form.submit();
		var fn_status = f_query_add_mod.document.section_form.function_name.value;
	}

}

function onSuccess() {

	if(f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.location.reload();
	
	}
}

function reset()
{

	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].reset() ;
		   	f_query_add_mod.document.location.reload();


}
