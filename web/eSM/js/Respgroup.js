
 function create()
  {
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyRespgroup.jsp" ;
  }

function query()
  {
	f_query_add_mod.location.href ="../../eSM/jsp/RespgroupQueryCriteria.jsp" ;
  }

function apply()
  {
if(f_query_add_mod.document.Respgroup_Form!=null){
	var fields = new Array(
				f_query_add_mod.document.forms[0].resp_group_id,
	 	     	        f_query_add_mod.document.forms[0].resp_group_name
			      );

	var names = new Array (getLabel("Common.identification.label","Common"),
				getLabel("Common.name.label","Common"))

	var field = new Array(f_query_add_mod.document.forms[0].resp_group_id );

	var name = new Array (getLabel("Common.identification.label","Common"))

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
		f_query_add_mod.document.forms[0].submit();
	}
  }
  else
	  {

	  frames[0].location.reload();
	  return false;
	  }
  }
function onSuccess()
 {
		f_query_add_mod.document.location.reload();

 }

function reset()
   {

    if(  f_query_add_mod.document.forms[0])
         //f_query_add_mod.document.forms[0].reset() ;
	     f_query_add_mod.document.location.reload() ;
    }


