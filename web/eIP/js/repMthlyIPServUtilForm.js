function reset() {
	f_query_add_mod.document.repMthlyIPServUtil.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repMthlyIPServUtil.P_facilityid);
    var names = new Array ( "Facility");

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		
		var from = f_query_add_mod.document.repMthlyIPServUtil.p_trn_date;
		var to     = f_query_add_mod.document.repMthlyIPServUtil.p_trn_date ;  
		var fields = new Array( f_query_add_mod.document.repMthlyIPServUtil.p_trn_date);

		var names = new Array("Month");
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{				
			
			if( f_query_add_mod.CheckString('Ward', f_query_add_mod.document.repMthlyIPServUtil.p_fr_nur_unit_code,f_query_add_mod.document.repMthlyIPServUtil.p_to_nur_unit_code, messageFrame )  )
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame"; 
			f_query_add_mod.document.repMthlyIPServUtil.submit() ;
			}
		}
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
			var dialogHeight= "60vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
			
			//alert(obj.name)
			if(obj.name=="ward")
			{
				tit="Ward"
				sql="select nursing_unit_code, long_desc from ip_nursing_unit";
				search_code="nursing_unit_code";
				search_desc= "long_desc"
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

