function reset() {
	f_query_add_mod.document.repUHIDRenewForm.reset() ;
}

function run() 
{
	var from = f_query_add_mod.document.repUHIDRenewForm.p_fr_renew_dt;
	var to     = f_query_add_mod.document.repUHIDRenewForm.p_to_renew_dt ;
	var fields = new Array( f_query_add_mod.document.repUHIDRenewForm.p_fr_renew_dt,
                            f_query_add_mod.document.repUHIDRenewForm.p_to_renew_dt );

	var names = new Array(getLabel('eMP.RenewDate.label','MP')+" "+getLabel('Common.from.label','common'), getLabel('eMP.RenewDate.label','MP')+" "+getLabel('Common.to.label','common'));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, 'DMY', getLabel('eMP.RenewDate.label','MP')))
		if( f_query_add_mod.CheckString( getLabel('Common.patientId.label','common'), f_query_add_mod.document.repUHIDRenewForm.p_fr_pat_id, f_query_add_mod.document.repUHIDRenewForm.p_to_pat_id, messageFrame ) ) 
		if( f_query_add_mod.CheckString( getLabel('eBL.BillingGroupId.label','BL'), f_query_add_mod.document.repUHIDRenewForm.P_fm_bl_group_code, f_query_add_mod.document.repUHIDRenewForm.P_to_bl_group_code, messageFrame ) )
		if( f_query_add_mod.CheckString( getLabel('Common.userid.label','common'), f_query_add_mod.document.repUHIDRenewForm.P_fm_user_code, f_query_add_mod.document.repUHIDRenewForm.P_to_user_code, messageFrame ) )
			f_query_add_mod.document.forms[0].submit();



	}
}


async function usersearchCode(obj,target)
{

		var retVal = 	new String();
		//var dialogHeight= "28" ;
		//var dialogWidth	= "43" ;
		
		var dialogHeight= "400px" ;
	    var dialogTop = "10px" ;
	    var dialogWidth	= "700px" ;
	
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		
		
			tit=getLabel('Common.userid.label','common');
			sql="Select appl_user_id,appl_user_name from sm_appl_user_lang_vw where eff_status=`E` and language_id=`"+localeName+"`"; 
			search_code="appl_user_id";
			search_desc= "appl_user_name";
				

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

		if(retVal !=null){

		if (!(unescape(retVal) == null))
		{
			arr=unescape(retVal).split("::");
			target.value =arr[0];
			
		}
		else{
			object.focus();
			target.value ="";
		
		}
		}
		else{
			target.value ="";

			
		}
}

async function searchCode(obj,target)
{

		var retVal = 	new String();
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
	
	if(obj.name=="Billing")
			{
				tit=getLabel('Common.BillingGroup.label','common');
				sql="select BLNG_GRP_ID , SHORT_DESC from BL_BLNG_GRP_lang_vw where language_id=`"+localeName+"`";
				search_code="BLNG_GRP_ID";
				search_desc= "SHORT_DESC";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();




}

async function PatSearch(target)
	{

		var patientid=await PatientSearch('','','','','','','','','','VIEW');
		
		if (!(patientid == null))
			{
				target.value=patientid;
			}
			else
				target.focus();
	}

function validate_date(obj){ 
	
	if(obj.value!=''){
		if(isBeforeNow(obj.value,"DMY",localeName))
		{
			return true;
		}
		else{
			var error = getMessage("START_DATE_GREATER_SYSDATE","COMMON");
			var dateLbl = "";
			
			if(obj.name == "p_fr_renew_dt")
				dateLbl = getLabel("eMP.RenewDate.label","MP") + " " + getLabel("Common.from.label","common");
			else
				dateLbl = getLabel("eMP.RenewDate.label","MP") + " " + getLabel("Common.to.label","common");
			
			var error1 = error.replace("Date", dateLbl);
			alert(error1);
			obj.select();
			obj.focus();
			return false ;
		}
	}
}
