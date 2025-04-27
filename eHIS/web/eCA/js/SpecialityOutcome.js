var linkContent = "";

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/SpecialityOutcomeAddModify.jsp?mode=INSERT';
}

function reset() 
  {
		f_query_add_mod.document.forms[0].reset();

  } 
function query(){
	f_query_add_mod.location.href="../../eCA/jsp/SpecialityOutcomeQueryCriteria.jsp";
}

function apply(){
	   if (! (f_query_add_mod.document.specialityoutcomeform) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	f_query_add_mod.document.specialityoutcomeform.module_id_val.value=f_query_add_mod.document.specialityoutcomeform.module_id.value;
	f_query_add_mod.document.specialityoutcomeform.outcome_code_val.value=f_query_add_mod.document.specialityoutcomeform.outcome_code.value;
	f_query_add_mod.document.specialityoutcomeform.descrptn_val.value=f_query_add_mod.document.specialityoutcomeform.descrptn.value;
	//f_query_add_mod.document.specialityoutcomeform.type_val.value=f_query_add_mod.document.specialityoutcomeform.type.value;
	var fields = new Array (f_query_add_mod.document.specialityoutcomeform.module_id,
							f_query_add_mod.document.specialityoutcomeform.outcome_code,
							f_query_add_mod.document.specialityoutcomeform.descrptn,
							f_query_add_mod.document.specialityoutcomeform.agegroupDes
							);
	var names  = new Array (getLabel("Common.Module.label","Common"),
							getLabel("Common.code.label","Common"),
							getLabel("Common.description.label","Common"),
							getLabel("Common.agegroup.label","Common")
							);
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
	
				f_query_add_mod.document.specialityoutcomeform.submit();

	 }
}

function onSuccess(){
	parent.frames[1].frames[1].location.reload();
}

   function changeCase(obj)
	{
		document.specialityoutcomeform.outcome_code.value=obj.value.toUpperCase();
	}

	 function getageGroup()
   {
	var retVal			=  new String();
	var title			= getLabel("Common.agegroup.label","Common");
	//alert("module_id===="+module_id	 );
	var sql="Select AGE_GROUP_CODE code, SHORT_DESC description from  AM_AGE_GROUP where	 EFF_STATUS = 'E'  and upper(AGE_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = "";
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		document.specialityoutcomeform.agegroupCode.value = retArray[0];
		document.specialityoutcomeform.agegroupDes.value = retArray[1];
	}
	else
	{
		document.specialityoutcomeform.agegroupCode.value = "";
		document.specialityoutcomeform.agegroupDes.value = "";
	}
	
}

   function getageGroup1(code,target)
   {
	var retVal			=  new String();
	var title			= getLabel("Common.agegroup.label","Common");
	//alert("module_id===="+module_id	 );
	var sql="Select AGE_GROUP_CODE code, SHORT_DESC description from  AM_AGE_GROUP where	 EFF_STATUS = 'E'  and upper(AGE_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2 ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		code.value = retArray[0];
		document.specialityoutcomeform.agegroupCode.value=retArray[0];
		
		target.value= retArray[1];
	}
	else
	{
		code.value ="";
		target.value= "";
	}
	
}
