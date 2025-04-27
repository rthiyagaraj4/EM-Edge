function reset() {
	f_query_add_mod.document.repPatHistDtls.reset() ;
}

function run() {
			if( f_query_add_mod.CheckString(getLabel('Common.patientId.label','common'), f_query_add_mod.document.repPatHistDtls.p_fr_patient_id, f_query_add_mod.document.repPatHistDtls.p_to_patient_id, messageFrame ) )  {
			f_query_add_mod.document.repPatHistDtls.submit() ;
		}
	
}

//From repPatHistDtlsForm.jsp
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
//End - repPatHistDtlsForm.jsp
async function usersearchCode(obj,target)
{

		var retVal = 	new String();
		//var dialogHeight= "28" ;
		//var dialogWidth	= "43" ;
		
		var dialogHeight= "400px" ; //added by vijayan
	    var dialogTop = "10px" ;
	    var dialogWidth	= "700px" ;
		
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		
		if(obj.name=="usergrp")
		{
			tit=getLabel('Common.user.label','common');
			sql="Select appl_user_id,appl_user_name from sm_appl_user_lang_vw where eff_status=`E` and language_id=`"+localeName+"`"; 
			search_code="appl_user_id";
			search_desc= "appl_user_name";
		}
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

