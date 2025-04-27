function reset() {
	f_query_add_mod.document.repLongStayPats.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repLongStayPats.p_trn_date);
    var names = new Array(getLabel('Common.month.label','Common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame)){			
			if( f_query_add_mod.CheckString('Ward', f_query_add_mod.document.repLongStayPats.p_fr_nur_unit_code,f_query_add_mod.document.repLongStayPats.p_to_nur_unit_code, messageFrame )  )
			f_query_add_mod.document.repLongStayPats.submit() ;
	}

}
function chkWithSysDt(obj){
		if(obj.value!=''){
			if(isBeforeNow(obj.value,"MY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_user_name = document.repLongStayPats.p_user_name.value;
			var p_resp_id = document.repLongStayPats.p_resp_id.value;
			
			//alert(obj.name)
			if(obj.name=="ward")
			{
				tit="Ward"
				sql="select nursing_unit_code, short_desc FROM ip_nursing_unit";
				search_code="nursing_unit_code";
				search_desc= "short_desc"
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}