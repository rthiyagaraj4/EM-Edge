function reset()
{
	f_query_add_mod.document.RepDeathRegisterForm.reset() ;
}
async function callSearchScreen()
{
            var patientid= await PatientSearch('','','','','','','Y','','','Visitreg');
			if(patientid !=null)
            document.forms[0].p_patient_id.value = patientid;
             document.forms[0].p_patient_id.focus();
			
}
function run()
{

		var fields = new Array( f_query_add_mod.document.RepDeathRegisterForm.p_fm_dec_date,	f_query_add_mod.document.RepDeathRegisterForm.p_to_dec_date);
		var Deceasedperiod=getLabel("eIP.Deceasedperiod.label","IP");
		var names = new Array(getLabel("Common.from.label","Common")+" "+Deceasedperiod,getLabel("Common.to.label","Common")+" "+Deceasedperiod);
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if(chkGrtr(f_query_add_mod.document.RepDeathRegisterForm.p_fm_dec_date,
				f_query_add_mod.document.RepDeathRegisterForm.p_to_dec_date)==true&&chkGrtrADM(f_query_add_mod.document.RepDeathRegisterForm.p_fm_adm_date,
				f_query_add_mod.document.RepDeathRegisterForm.p_to_adm_date)==true)
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
                f_query_add_mod.document.forms[0].target="messageFrame"
				f_query_add_mod.document.RepDeathRegisterForm.submit() ;
			
			}

			
		}	
}

function chkGrtrADM(obj1,obj2)
{
	if(obj1.value!=""&&obj2.value!="")
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			var Deceasedperiod=getLabel("Common.admissiondate.label","common"); 
			var from_Deceased=getLabel('Common.to.label','common_labels')+" "+Deceasedperiod;
			var to_Deceased=getLabel('Common.from.label','common_labels')+" "+Deceasedperiod;
			error = error.replace('To Date',from_Deceased);
			error = error.replace('From Date',to_Deceased);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
	}
	else
		return true;

}
function chkGrtr(obj1,obj2)
{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			var Deceasedperiod=getLabel("eIP.Deceasedperiod.label","IP"); 
			var from_Deceased=getLabel('Common.to.label','common_labels')+" "+Deceasedperiod;
			var to_Deceased=getLabel('Common.from.label','common_labels')+" "+Deceasedperiod;
			error = error.replace('To Date',from_Deceased);
			error = error.replace('From Date',to_Deceased);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}
async function searchCode(obj,target)
{

			var retVal = 	new String();
			var locale= document.forms[0].locale.value;
			var p_facility_id= document.forms[0].p_facility_id.value;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			/*var dialogHeight= "28" ;
			var dialogWidth	= "43" ;*/
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
	
			if(obj.name=="practitioner_id1")
			{
				var tit=getLabel('Common.practitioner.label','common')
				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where  b.FACILITY_ID=`"+p_facility_id+"` AND a.Practitioner_id=b.Practitioner_id ";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="practitioner_id2")
			{
				var tit=getLabel('Common.practitioner.label','common')
				sql  = "select a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`) Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where b.FACILITY_ID=`"+p_facility_id+"` AND a.Practitioner_id=b.Practitioner_id ";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

		
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+p_facility_id+"` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
	
		if(obj.name=="nationality")
			{
				tit=getLabel('Common.nationality.label','common')
				sql="select COUNTRY_CODE, LONG_DESC from MP_COUNTRY ";
				search_code="COUNTRY_CODE";
				search_desc= "LONG_DESC";
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
