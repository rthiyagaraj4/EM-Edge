//************************************************************************
function run()
{
	if(f_query_add_mod.document.report_events_out_bound)
	{
		f_query_add_mod.document.report_events_out_bound.submit() ;	
	}				
}
//***************************************************************************
function reset()
{
	window.f_query_add_mod.location.href="../../eXH/jsp/ReportEventsOutbound.jsp";
}

//************************************************************************
function callSearchScreen()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
		document.forms[0].ND_FROM_PATIENT_ID.value = patientid;
	document.forms[0].ND_FROM_PATIENT_ID.focus();
}
//************************************************************************
function callSearchScreen1()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
		document.forms[0].ND_TO_PATIENT_ID.value = patientid;
	document.forms[0].ND_TO_PATIENT_ID.focus();
}
//************************************************************************
