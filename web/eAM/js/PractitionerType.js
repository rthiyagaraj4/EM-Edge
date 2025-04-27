
function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryPractitionerType.jsp?function=practitionertype" ;
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
	var fields = new Array ( f_query_add_mod.document.practitioner_form.pract_type,
				 f_query_add_mod.document.practitioner_form.desc_sysdef,
				 f_query_add_mod.document.practitioner_form.desc_userdef,
				 f_query_add_mod.document.practitioner_form.seq_no
			        );

		var names = new Array ( getLabel("Common.type.label","Common"),
					 getLabel("Common.SystemDescription.label","Common"),
					 getLabel("Common.UserDescription.label","common"),
					getLabel("Common.SequenceNo.label","Common")
				      );

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		f_query_add_mod.practitioner_form.submit()
		}

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
	if(f_query_add_mod.document.forms[0].name == "practitioner_form") f_query_add_mod.document.practitioner_form.reset() ;
	else f_query_add_mod.document.query_form.reset() ;


}

/*not required since there is no insert operation*/

function onSuccess() {
	if(	f_query_add_mod.practitioner_form)
	{
		f_query_add_mod.location.reload();
	}
}


function run() {
	var parameters = "report=mpbrelgn.rdf&server=medrep&userid=ecis/magic@tgdb" ;

	messageFrame.location.href = "../../eCommon/jsp/report_amtions.jsp?" + parameters ;
}
