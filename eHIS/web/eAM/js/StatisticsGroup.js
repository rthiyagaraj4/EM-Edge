function create()
{
	f_query_add_mod.location.href = '../../eAM/jsp/AddModifyStatisticsGroup.jsp?operation=insert' ;
}

function reset()
{
			if(f_query_add_mod.document.forms[0])
					//f_query_add_mod.document.forms[0].reset() ;
					f_query_add_mod.document.location.reload();
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/StatisticsGroupQueryCriteria.jsp?operation=modify" ;
}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 
 url = url.toLowerCase();
	
 if ((url.indexOf("statisticsgroupquery")==-1) &&(url.indexOf("blank.html")==-1))
 return true;
else
  return false;
}
function apply()
{
	if(!(checkIsValidForProceed()))
	{
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	return false;
		
		
	}
	var fields = new Array(f_query_add_mod.document.StatisticsGroup_form.stat_grp_id,
		f_query_add_mod.document.StatisticsGroup_form.stat_grp_desc,
		f_query_add_mod.document.StatisticsGroup_form.stat_grp_cat);
	var names = new Array(getLabel("Common.identification.label","Common"),
							getLabel("Common.description.label","Common"),
							getLabel("Common.category.label","Common"));

	var spFields = new Array (f_query_add_mod.document.StatisticsGroup_form.stat_grp_id);
	
	var spNames = new Array (getLabel("Common.identification.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(spFields,spNames,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.StatisticsGroup_form.submit();
		}
	 }

}

function onSuccess()
{
/////////////////Added by Manish Anand on 02-07-2002///////////////
	f_query_add_mod.location.reload();
///////////////////////////////////////////////////////////////////


}







