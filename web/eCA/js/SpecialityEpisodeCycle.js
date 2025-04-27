	var linkContent = "";

	function create()
	{
		f_query_add_mod.location.href='../../eCA/jsp/SpecialityEpisodeCycleAddModify.jsp?mode=INSERT';
	}

	function reset()
	{
		 if(f_query_add_mod.document.forms[0]!=null)
			f_query_add_mod.document.forms[0].reset();
	}

	function query(){
		f_query_add_mod.location.href="../../eCA/jsp/SpecialityEpisodeCycleQueryCriteria.jsp";
	}

	function deleterecord(){
			   if (! (f_query_add_mod.document.specialityepisodeform) ){
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
		}
		f_query_add_mod.document.specialityepisodeform.mode.value="DELETE";
		f_query_add_mod.document.specialityepisodeform.mod_id_val.value = f_query_add_mod.document.specialityepisodeform.module_id.value
		f_query_add_mod.document.specialityepisodeform.submit();

	}

	function apply(){
			   if (! (f_query_add_mod.document.specialityepisodeform) ){
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
		}
	f_query_add_mod.document.specialityepisodeform.mod_id_val.value = f_query_add_mod.document.specialityepisodeform.module_id.value
	f_query_add_mod.document.specialityepisodeform.spepisode_desc_val.value = f_query_add_mod.document.specialityepisodeform.spepsd_desc.value
	f_query_add_mod.document.specialityepisodeform.spevnt_desc_val.value = f_query_add_mod.document.specialityepisodeform.spevnt_desc.value
	var fields = new Array (f_query_add_mod.document.specialityepisodeform.module_id,
							f_query_add_mod.document.specialityepisodeform.spepsd_desc,
							f_query_add_mod.document.specialityepisodeform.spevnt_desc
							);

	var names  = new Array (getLabel("Common.Module.label","Common"),
							getLabel("eCA.EpisodeDescription.label","CA"),
							getLabel("eCA.EventTitleDescription.label","CA")
							);
	if(checkFieldsofMst( fields, names, messageFrame)){
				f_query_add_mod.document.specialityepisodeform.submit();

	 }
	}

function onSuccess(){
	var modeval=f_query_add_mod.document.specialityepisodeform.mode.value;
		if(modeval=='DELETE'){
		create();
		}else{
		parent.frames[1].frames[1].location.reload();
		}
}

