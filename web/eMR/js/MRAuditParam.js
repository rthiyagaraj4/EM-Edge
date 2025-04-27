function apply() 
{

	if(resultFrame.document.forms[0])
	{
		for(var i=0;i < resultFrame.document.forms[0].elements.length; i++)
		{
			if (resultFrame.document.forms[0].elements[i].type=='checkbox')
			{
				if(resultFrame.document.forms[0].elements[i].checked)
					resultFrame.document.forms[0].elements[i].value = "Y";
				else
					resultFrame.document.forms[0].elements[i].value = "N";
			}
		}
		resultFrame.document.forms[0].submit();
	}
	else
	{
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}

function onSuccess() 
{
	
	resultFrame.location.href='../../eMR/jsp/AddModifyMRAuditParam.jsp'
}


function reset() 
{
	resultFrame.location.reload();
}

function loadSection()
{
	if(parent.frames[1].document.forms[0].audit_trial.value != "")
		parent.frames[2].location.href="../../eMR/jsp/AddModifyMRAuditParam.jsp";
	else
		parent.frames[2].location.href="../../eCommon/html/blank.html";

	parent.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp';

}

function enableGeneralSection()
{
	if(document.forms[0].general_details_hist_yn.checked)
	{
		document.forms[0].attending_practitioner_hist_yn.disabled=false;
		document.forms[0].auth_practitioner_hist_yn.disabled=false;
		document.forms[0].brought_dead_hist_yn.disabled=false;
		//document.forms[0].deceased_details_hist_yn.disabled=false;
		document.forms[0].attending_practitioner_hist_yn.checked=true;
		document.forms[0].auth_practitioner_hist_yn.checked=true;
		document.forms[0].brought_dead_hist_yn.checked=true;
		//document.forms[0].deceased_details_hist_yn.checked=true;
	}
	else
	{
		document.forms[0].attending_practitioner_hist_yn.disabled=true;
		document.forms[0].auth_practitioner_hist_yn.disabled=true;
		document.forms[0].brought_dead_hist_yn.disabled=true;
		//document.forms[0].deceased_details_hist_yn.disabled=true;
		document.forms[0].attending_practitioner_hist_yn.checked=false;
		document.forms[0].auth_practitioner_hist_yn.checked=false;
		document.forms[0].brought_dead_hist_yn.checked=false;
		//document.forms[0].deceased_details_hist_yn.checked=false;
	}

}

function enableDiagnosisSection()
{
	if(document.forms[0].diagnosis_details_hist_yn.checked)
	{
		document.forms[0].seq_no_hist_yn.disabled=false;
		document.forms[0].add_diagnosis_hist_yn.disabled=false;
		document.forms[0].moved_from_gen_to_cod_hist_yn.disabled=false;
		document.forms[0].moved_from_cod_to_oth_hist_yn.disabled=false;
		document.forms[0].moved_from_oth_to_cod_hist_yn.disabled=false;
		//document.forms[0].cause_of_death_remarks_hist_yn.disabled=false;
		document.forms[0].moved_from_cod_to_gen_hist_yn.disabled=false;
		document.forms[0].moved_from_oth_to_gen_hist_yn.disabled=false;
		document.forms[0].moved_from_gen_to_oth_hist_yn.disabled=false;
		document.forms[0].onset_date_hist_yn.disabled=false;
		document.forms[0].seq_no_hist_yn.checked=true;
		document.forms[0].add_diagnosis_hist_yn.checked=true;
		document.forms[0].moved_from_gen_to_cod_hist_yn.checked=true;
		document.forms[0].moved_from_cod_to_oth_hist_yn.checked=true;
		document.forms[0].moved_from_oth_to_cod_hist_yn.checked=true;
		//document.forms[0].cause_of_death_remarks_hist_yn.checked=true;
		document.forms[0].moved_from_cod_to_gen_hist_yn.checked=true;
		document.forms[0].moved_from_oth_to_gen_hist_yn.checked=true;
		document.forms[0].moved_from_gen_to_oth_hist_yn.checked=true;
		document.forms[0].onset_date_hist_yn.checked=true;
	}
	else
	{
		document.forms[0].seq_no_hist_yn.disabled=true;
		document.forms[0].add_diagnosis_hist_yn.disabled=true;
		document.forms[0].moved_from_gen_to_cod_hist_yn.disabled=true;
		document.forms[0].moved_from_cod_to_oth_hist_yn.disabled=true;
		document.forms[0].moved_from_oth_to_cod_hist_yn.disabled=true;
		//document.forms[0].cause_of_death_remarks_hist_yn.disabled=true;
		document.forms[0].moved_from_cod_to_gen_hist_yn.disabled=true;
		document.forms[0].moved_from_oth_to_gen_hist_yn.disabled=true;
		document.forms[0].moved_from_gen_to_oth_hist_yn.disabled=true;
		document.forms[0].onset_date_hist_yn.disabled=true;
		document.forms[0].seq_no_hist_yn.checked=false;
		document.forms[0].add_diagnosis_hist_yn.checked=false;
		document.forms[0].moved_from_gen_to_cod_hist_yn.checked=false;
		document.forms[0].moved_from_cod_to_oth_hist_yn.checked=false;
		document.forms[0].moved_from_oth_to_cod_hist_yn.checked=false;
		//document.forms[0].cause_of_death_remarks_hist_yn.checked=false;
		document.forms[0].moved_from_cod_to_gen_hist_yn.checked=false;
		document.forms[0].moved_from_oth_to_gen_hist_yn.checked=false;
		document.forms[0].moved_from_gen_to_oth_hist_yn.checked=false;
		document.forms[0].onset_date_hist_yn.checked=false;
	}
}

function enableMLCSection()
{
	if(document.forms[0].mlc_patient_details_hist_yn.checked)
	{
		document.forms[0].medical_legal_case_hist_yn.disabled=false;
		document.forms[0].pol_rep_no_hist_yn.disabled=false;
		document.forms[0].pol_stn_id_hist_yn.disabled=false;
		document.forms[0].pol_id_hist_yn.disabled=false;
		document.forms[0].medical_legal_case_hist_yn.checked=true;
		document.forms[0].pol_rep_no_hist_yn.checked=true;
		document.forms[0].pol_stn_id_hist_yn.checked=true;
		document.forms[0].pol_id_hist_yn.checked=true;
	}
	else
	{
		document.forms[0].medical_legal_case_hist_yn.disabled=true;
		document.forms[0].pol_rep_no_hist_yn.disabled=true;
		document.forms[0].pol_stn_id_hist_yn.disabled=true;
		document.forms[0].pol_id_hist_yn.disabled=true;
		document.forms[0].medical_legal_case_hist_yn.checked=false;
		document.forms[0].pol_rep_no_hist_yn.checked=false;
		document.forms[0].pol_stn_id_hist_yn.checked=false;
		document.forms[0].pol_id_hist_yn.checked=false;
	}


}
