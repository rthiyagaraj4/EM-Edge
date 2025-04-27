function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyFacilitySection.jsp?facilityId="+facId ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/FacilitySectionQueryCriteria.jsp?function=FaciltySection";
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
if(f_query_add_mod.document.FaciltySection_form.function_name.value=="insert") {

	var fields = new Array ( f_query_add_mod.document.FaciltySection_form.facility,
						f_query_add_mod.document.FaciltySection_form.department,
						f_query_add_mod.document.FaciltySection_form.section

				);

	var names = new Array ( getLabel("Common.facility.label","Common"),
				getLabel("Common.acctdept.label","Common"),
				getLabel("Common.Section.label","Common")
			      );
}
else if(f_query_add_mod.document.FaciltySection_form.function_name.value=="modify") {




var fields = new Array ( f_query_add_mod.document.FaciltySection_form.facility2,
						f_query_add_mod.document.FaciltySection_form.department2,
						f_query_add_mod.document.FaciltySection_form.section2

				);

	var names = new Array ( getLabel("Common.facility.label","Common"),
				getLabel("eAM.AcctDept.label","am"),
				getLabel("Common.Section.label","Common")
			      );
}


		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			f_query_add_mod.document.FaciltySection_form.submit();
			var fn_status = f_query_add_mod.document.FaciltySection_form.function_name.value ;


		}

}

var facId='';
function onSuccess() {

if(f_query_add_mod.document.FaciltySection_form.function_name.value=="insert")
{
facId=f_query_add_mod.document.FaciltySection_form.facility.value;
create();
}
else
f_query_add_mod.location.reload();



}

function reset() {

/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
			if(f_query_add_mod.document.forms[0] == "FaciltySection_form") 
	{
			//	f_query_add_mod.document.FaciltySection_form.reset() ;
				f_query_add_mod.document.location.reload();
				ClearList(f_query_add_mod.document.FaciltySection_form.section)
	}
	else 
	{
		//f_query_add_mod.document.query_form.reset() ;
		f_query_add_mod.document.location.reload();

	}

}

function ClearList(object)
{
    
	if (object)
	var length  =object.length;


var element = f_query_add_mod.document.FaciltySection_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value=""; 

	
        for(i=1;i<length;i++)
            object.remove(1);   

}
