function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/Report_For_Facility.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/queryReportForFacilityForm.jsp";
}

function apply() {
	if(f_query_add_mod.document.report_for_facility!=null){
	var fields = new Array (f_query_add_mod.document.report_for_facility.Module_Id,
						f_query_add_mod.document.report_for_facility.Report_Id,
						f_query_add_mod.document.report_for_facility.Facility_Id,
						f_query_add_mod.document.report_for_facility.Report_Group_Id
					    );
	 var names = new Array ( getLabel("Common.Module.label","Common"),
						 getLabel("Common.report.label","Common"),
						 getLabel("Common.facility.label","Common"),
						 getLabel("eSM.ReportGroup.label","SM")
					      );
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		f_query_add_mod.document.report_for_facility.submit();
	}
	}else{
               frames[0].location.reload();
			   return null;
	}
}

function reset() {
		if(f_query_add_mod.document.forms[0])
			// f_query_add_mod.document.forms[0].reset() ;
			 f_query_add_mod.document.location.reload();

}

function onSuccess() 
{
		if(f_query_add_mod.document.forms[0].function_name.value == 'delete')
			f_query_add_mod.location.href='../../eCommon/html/blank.html'
		else
		f_query_add_mod.document.location.reload();
}

function deleterecord()
{
	if(f_query_add_mod.document.report_for_facility!=null){
if(f_query_add_mod.document.forms[0].function_name.value!="insert")
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
		f_query_add_mod.document.report_for_facility.function_name.value="delete";
		f_query_add_mod.document.report_for_facility.submit();
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
		}
	}
	else
	{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
	}else
{
	frames[0].location.reload();
	return false;
}
}
