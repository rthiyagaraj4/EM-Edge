function create()
	{
	
		f_query_add_mod.location.href='../../eCA/jsp/SpecialityTasksAddModify.jsp?mode=insert';
	}	



function query()
	{
	 f_query_add_mod.location.href='../../eCA/jsp/SpecialityTasksQueryCriteria.jsp';
	}


function apply(){
	/*alert('module_id'+f_query_add_mod.document.specialitytaskform.module_id.value)
	alert('sp_code'+f_query_add_mod.document.specialitytaskform.sptask_code.value)
	alert('sp_desc'+f_query_add_mod.document.specialitytaskform.sptask_descrptn.value)
	alert('sp_task type'+f_query_add_mod.document.specialitytaskform.sptask_type.value)
	alert('ext_value'+f_query_add_mod.document.specialitytaskform.sptask_exectable.value)
	alert('actn_code'+f_query_add_mod.document.specialitytaskform.actn_code.value)*/
	   if (! (f_query_add_mod.document.specialitytaskform) ){
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
		}
	f_query_add_mod.document.specialitytaskform.mod_id_val.value = f_query_add_mod.document.specialitytaskform.module_id.value
	f_query_add_mod.document.specialitytaskform.sptask_code_val.value = f_query_add_mod.document.specialitytaskform.sptask_code.value
	f_query_add_mod.document.specialitytaskform.sptask_desc_val.value = f_query_add_mod.document.specialitytaskform.sptask_descrptn.value
	f_query_add_mod.document.specialitytaskform.sptask_type_val.value = f_query_add_mod.document.specialitytaskform.sptask_type.value
	f_query_add_mod.document.specialitytaskform.sptask_extbl_val.value = f_query_add_mod.document.specialitytaskform.sptask_exectable.value
	f_query_add_mod.document.specialitytaskform.sptask_actn_val.value = f_query_add_mod.document.specialitytaskform.actn_code.value

	var fields = new Array (f_query_add_mod.document.specialitytaskform.module_id,
							f_query_add_mod.document.specialitytaskform.sptask_code,
							f_query_add_mod.document.specialitytaskform.sptask_descrptn
							);

	var names  = new Array (getLabel("Common.Module.label","Common"),
							getLabel("Common.code.label","Common"),
							getLabel("Common.description.label","Common")
							);

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
	
				f_query_add_mod.document.specialitytaskform.submit();

	 }

}

function reset()
	{
		 if(f_query_add_mod.document.forms[0]!=null)
			f_query_add_mod.document.forms[0].reset();
	}

function typeset(obj){
	var objval=obj.value;
	if(objval=='FX'){
		document.specialitytaskform.sptask_exectable.disabled=false;
		document.specialitytaskform.actn_code.value="";
	}
	else{
		document.specialitytaskform.sptask_exectable.value="";
		document.specialitytaskform.sptask_exectable.disabled=true;

	}
	if(objval=='NT'||objval=='CT'||objval=='NG'){
	document.specialitytaskform.actn_code.value="";
	document.specialitytaskform.actn_code_desc.value="";
	document.specialitytaskform.actn_code_desc.disabled=false;
	document.specialitytaskform.action_butn.disabled=false;
	}else{
	document.specialitytaskform.actn_code_desc.value="";
	document.specialitytaskform.actn_code_desc.disabled=true;
	document.specialitytaskform.action_butn.disabled=true;
	}
}

function calldis(){
	//document.specialitytaskform.sptask_exectable.disabled=true;
	//document.specialitytaskform.actn_code_desc.disabled=true;
	//document.specialitytaskform.action_butn.disabled=true;
}

function getactioncode(obj,target){

		var typeVal=document.specialitytaskform.sptask_type.value;
		var title='';
		var sql;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		if(typeVal=='NT'){
		title=getLabel("Common.NoteType.label","common");
		sql="select NOTE_TYPE code,NOTE_TYPE_DESC description FROM CA_NOTE_TYPE WHERE EFF_STATUS='E' AND UPPER(NOTE_TYPE) LIKE UPPER(?) AND UPPER(NOTE_TYPE_DESC) LIKE UPPER(?) ORDER BY 2"
		}else if(typeVal=='NG'){
		title=getLabel("eCA.NoteGroup.label","ca");
		sql="select NOTE_GROUP code,NOTE_GROUP_DESC description FROM CA_NOTE_GROUP WHERE EFF_STATUS='E' AND UPPER(NOTE_GROUP) LIKE UPPER(?) AND UPPER(NOTE_GROUP_DESC) LIKE UPPER(?) ORDER BY 2"
		}else if(typeVal=='CT'){
		title=getLabel("eCA.Clinician.label","ca");
		sql="select APPL_TASK_ID code,APPL_TASK_DESC description FROM CA_APPL_TASK  WHERE  UPPER(APPL_TASK_ID) LIKE UPPER(?) AND UPPER(APPL_TASK_DESC) LIKE UPPER(?) ORDER BY 2"
		}	
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = obj.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = CommonLookup( title, argArray );
		if(retArray!=null && retArray!=""){
		target.value=retArray[0];
		obj.value=retArray[1];
		}else{
		target.value='';
		obj.value='';
		}
	
}

function changeCase(obj)
{
	document.specialitytaskform.sptask_code.value=obj.value.toUpperCase();
}

function onSuccess(){
	parent.frames[1].frames[1].location.reload();
}
