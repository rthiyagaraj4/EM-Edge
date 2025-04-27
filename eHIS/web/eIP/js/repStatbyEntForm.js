function reset() {
	f_query_add_mod.document.repStatbyEnt.reset() ;
}

function run() {
	var fields = new Array ( f_query_add_mod.document.repStatbyEnt.p_facilityid );
    var names = new Array ( getLabel('Common.facility.label','Common') );
	if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		var from = f_query_add_mod.document.repStatbyEnt.p_fr_trn_date;
		var to     = f_query_add_mod.document.repStatbyEnt.p_to_trn_date ;  
		var fields = new Array( f_query_add_mod.document.repStatbyEnt.p_fr_trn_date,f_query_add_mod.document.repStatbyEnt.p_to_trn_date);
		var names = new Array(getLabel('Common.MonthFrom.label','Common'),getLabel('Common.MonthTo.label','Common'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		if( f_query_add_mod.doDateChkWithLabel(from,to, messageFrame,'MY',getLabel('Common.month.label','Common') ) ) {
			if (f_query_add_mod.trimCheck(from.value)) {
				//f_query_add_mod.document.repStatbyEnt.p_fm_regndate.value = '01/' + from.value;
				f_query_add_mod.document.repStatbyEnt.p_fr_trn_date.value = from.value;
			}
			if (f_query_add_mod.trimCheck(to.value)) {
				//f_query_add_mod.document.repStatbyEnt.p_to_regndate.value = f_query_add_mod.LastDate(to)+'/' + to.value;
				f_query_add_mod.document.repStatbyEnt.p_to_trn_date.value = to.value;
			}
			if( f_query_add_mod.CheckString('Organization', f_query_add_mod.document.repStatbyEnt.p_fr_org_id,f_query_add_mod.document.repStatbyEnt.p_to_org_id, messageFrame )  )
			f_query_add_mod.document.repStatbyEnt.submit() ;
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
			var dialogHeight= "70vh" ;
			var dialogWidth	= "80vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_user_name = document.repStatbyEnt.p_user_name.value;
			var p_resp_id = document.repStatbyEnt.p_resp_id.value;
			
			//alert(obj.name)
			if(obj.name=="organization")
			{
				tit="Organization"
				sql="select family_org_id, family_org_name from mp_family_org";
				search_code="family_org_id";
				search_desc= "family_org_name"
			}
			else if(obj.name=="facility")
			{
				tit="Facility"
				sql="select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id =`"+ p_user_name+"` and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = `"+p_resp_id+"`) ";
				search_code="facility_id";
				search_desc= "facility_name";
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

