function create() {
			f_query_add_mod.location.href = "../../eSM/jsp/addPrinter.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/queryPrinterPage.jsp?function=Printer" ;
}

function apply() {
	if(f_query_add_mod.document.printer_form!=null){
	 var fields = new Array ( f_query_add_mod.document.printer_form.printer_id,
				  f_query_add_mod.document.printer_form.printer_name,
				  f_query_add_mod.document.printer_form.queue_name,
				  f_query_add_mod.document.printer_form.printer_type,
				 f_query_add_mod.document.printer_form.report_service
				);

	 var names  = new Array ( f_query_add_mod.getLabel("Common.identification.label","Common"),
		                  f_query_add_mod.getLabel("eSM.PrinterName.label","SM"),
				  f_query_add_mod.getLabel("eSM.QueueName.label","SM"),
				  f_query_add_mod.getLabel("eSM.PrinterType.label","SM"),
					f_query_add_mod.getLabel("eSM.ReportService.label","SM")
				);

 	 var field = new Array ( f_query_add_mod.document.printer_form.printer_id );

	 var name  = new Array ( f_query_add_mod.getLabel("Common.identification.label","Common") );

	 var transform = new Array ( f_query_add_mod.document.printer_form,
			             f_query_add_mod.document.printer_form.eff_date_from,
			             f_query_add_mod.document.printer_form.eff_date_from1,
				     f_query_add_mod.document.printer_form.eff_date_to,
				     f_query_add_mod.document.printer_form.eff_date_to1
				   );

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
			   if(f_query_add_mod.document.printer_form.report_service.disabled == true)
			   	{
			   	f_query_add_mod.document.printer_form.report_service.disabled=false;
			   	f_query_add_mod.document.printer_form.printer_type.disabled=false;
			   	}
			   	
			   if(f_query_add_mod.DateTransform(transform,messageFrame)) {
		      var fn_status = f_query_add_mod.document.printer_form.function_name.value ;
		   }
		}
	}
	}else{
          frames[0].location.reload();
		  return false;
	}
}

function reset() {
		if(f_query_add_mod.document.forms[0])
		   //f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload();

}

function onSuccess() 
{

		f_query_add_mod.document.location.reload();
}


