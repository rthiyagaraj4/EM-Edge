function callPrevEnctr(strFacilityId,strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncPatRegDate,called_frm)
{		
	var locale = document.forms[0].locale.value;
	var pat_fin_mod_date = eval("parent.frames[1].document.forms[0].pat_fin_mod_date_"+0);
	pat_fin_mod_date = pat_fin_mod_date.value;

	if(!isAfter(strEncPatRegDate,pat_fin_mod_date,'DMYHMS',locale))
	{
		var confirm_flag = confirm(getMessage("BL7433","BL"));

		if(!confirm_flag)
			return false;
	}

	var calling_module_id=document.forms[0].calling_module_id.value;
	var query_string=document.forms[0].query_string.value;	parent.frames[2].location.href='../../eBL/jsp/BLFinDetHiddenFlds.jsp?selected_from_prev_enc_YN=Y&strFacilityId='+strFacilityId+'&patient_id='+strPatientId+"&calling_module="+calling_module_id+'&episode_type='+strEpisodeType+'&episode_id='+strEpisodeId+'&visit_id='+strVisitId+'&query_string='+query_string;
}

function callPrevEnctrPlcyActSeq(strPolicyNum,strAcctSeq,strFacilityId,strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncPatRegDate,called_frm)
{		
	var locale = document.forms[0].locale.value;
	var pat_fin_mod_date = eval("parent.frames[1].document.forms[0].pat_fin_mod_date_"+0);
	if(pat_fin_mod_date !=null && pat_fin_mod_date!='undefined')
		{
	pat_fin_mod_date = pat_fin_mod_date.value;

	if(!isAfter(strEncPatRegDate,pat_fin_mod_date,'DMYHMS',locale))
	{
		var confirm_flag = confirm(getMessage("BL7433","BL"));

		if(!confirm_flag)
			return false;
	}
		}

	var calling_module_id=document.forms[0].calling_module_id.value;
	var query_string=document.forms[0].query_string.value;	parent.frames[2].location.href='../../eBL/jsp/BLFinDetHiddenFlds.jsp?selected_from_prev_enc_YN=Y&strFacilityId='+strFacilityId+'&acct_seq='+strAcctSeq+'&patient_id='+strPatientId+"&calling_module="+calling_module_id+'&episode_type='+strEpisodeType+'&episode_id='+strEpisodeId+'&visit_id='+strVisitId+'&query_string='+query_string+'&policy_num='+strPolicyNum;
}
