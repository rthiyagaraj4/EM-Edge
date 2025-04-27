//************************************************************************
function run()
{
	if(f_query_add_mod.document.report_application_mesg)
	{
		f_query_add_mod.document.report_application_mesg.submit() ;	
	}	
}
//************************************************************************
function reset()
{
	
	window.f_query_add_mod.document.forms[0].reset();

	//window.f_query_add_mod.location.href="../../eXH/jsp/ReviewApplMessageQuery.jsp";	
	window.header.location.href="../../eCommon/html/blank.html";
	window.result.location.href="../../eCommon/html/blank.html";
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";


}
//************************************************************************
function callSearchScreen()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	//alert(patientid);
	if(patientid !=null){
	document.forms[0].ND_FROM_PATIENT_ID.value = patientid;
	document.forms[0].ND_FROM_PATIENT_ID.focus();
	}
}

//
function callSearchScreen2()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	//alert(patientid);
	if(patientid !=null)
	{
	document.forms[0].patient_id.value = patientid;
	document.forms[0].patient_id.focus();
	}
}

//************************************************************************
function callSearchScreen1()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
		//alert(patientid);
	if(patientid !=null) {
		document.forms[0].ND_TO_PATIENT_ID.value = patientid;
	document.forms[0].ND_TO_PATIENT_ID.focus();
	}
}


function callSearchScreen3()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	//alert(patientid);
	if(patientid !=null){
	document.forms[0].pat_id.value = patientid;
	document.forms[0].pat_id.focus();
	}
}


//************************************************************************
