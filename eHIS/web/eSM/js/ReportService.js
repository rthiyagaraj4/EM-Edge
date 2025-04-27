function create() {
	f_query_add_mod.location.href ="../../eSM/jsp/addReportService.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/queryReportService.jsp?function=ReportService";
}

function CheckMaxLen1(lab,obj,max,messageFrame) {
		if(obj.value.length > max) {
			//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+f_query_add_mod.getMessage('REMARKS_NOT_EXCEED_200_CH','SM');
			return false;
		} else return true;
}

function apply() {
if(f_query_add_mod.document.report_service_form!=null){
	if(CheckMaxLen1(f_query_add_mod.getLabel("Common.remarks.label","Common"),f_query_add_mod.document.report_service_form.Remarks,200,messageFrame)) {
		var fields = new Array (f_query_add_mod.document.report_service_form.Report_Service_Id,f_query_add_mod.document.report_service_form.Report_Service_Name);	
		var names = new Array (f_query_add_mod.getLabel("Common.identification.label","Common"),f_query_add_mod.getLabel("Common.name.label","Common"));	
		var field = new Array (f_query_add_mod.document.report_service_form.Report_Service_Id);	
		var name = new Array (f_query_add_mod.getLabel("Common.identification.label","Common"));	

		var transform = new Array (f_query_add_mod.document.report_service_form,
								f_query_add_mod.document.report_service_form.eff_date_from,
								f_query_add_mod.document.report_service_form.eff_date_from1,
								f_query_add_mod.document.report_service_form.eff_date_to,
								f_query_add_mod.document.report_service_form.eff_date_to1
							   );	
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) {
			if (f_query_add_mod.SpecialCharCheck(field,name,messageFrame,'M','MstCodeError.jsp'))
			{			
				f_query_add_mod.document.report_service_form.submit();
			}
		} 
	}
}else{
         frames[0].location.reload();
	     return false;
}
}

function reset() {
	if(f_query_add_mod.document.forms[0]){
			f_query_add_mod.document.location.reload();
			}
			}

function onSuccess() 
{
		f_query_add_mod.document.location.reload();
}

