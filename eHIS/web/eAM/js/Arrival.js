function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyArrival.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryArrivalPage.jsp?function=arrival";
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


	var fields = new Array (f_query_add_mod.document.arrival_form.arrival_code);
	var names  =  new Array ( getLabel("Common.code.label","Common") );
	
	

	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

	var fields = new Array (f_query_add_mod.document.arrival_form.transportmode, 
						f_query_add_mod.document.arrival_form.arrival_code,
						f_query_add_mod.document.arrival_form.long_desc,
						f_query_add_mod.document.arrival_form.short_desc

				    );

	var names = new Array ( getLabel("Common.TransportMode.label","Common"),
							getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
					        getLabel("Common.shortdescription.label","Common")

					      );

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			f_query_add_mod.document.arrival_form.submit();
				var fn_status = f_query_add_mod.document.arrival_form.function_name.value ;

		}
	}
}

function onSuccess() {
 f_query_add_mod.location.reload();

}

function reset() {

	//	if(f_query_add_mod.document.forms[0]) f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.document.forms[0]) f_query_add_mod.document.location.reload();
	



}
