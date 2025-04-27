function reset()
	{ 
   f_search_criteria.document.forms[0].reset();
}

function run() 
{
	
	var fields = new Array( f_search_criteria.document.forms[0].p_fm_appt_date,
						f_search_criteria.document.forms[0].p_to_appt_date );

var names = new Array(getLabel("eOA.ApptDateFrom.label","OA"), getLabel("eOA.ApptDateTo.label","OA"));
if(f_search_criteria.checkFields( fields, names, messageFrame))
{		
    /*if( f_search_criteria.DateCompare_apply( f_search_criteria.document.forms[0].p_fm_appt_date, f_search_criteria.document.forms[0].p_to_appt_date) ) 
  	{*/
  		if( f_search_criteria.CheckString( getLabel("Common.locationcode.label","Common"),f_search_criteria.document.forms[0].p_fm_locn_code, f_search_criteria.document.forms[0].p_to_locn_code, messageFrame ) ) 
		{
  			if( f_search_criteria.CheckString( getLabel("Common.SpecialityCode.label","Common"),f_search_criteria.document.forms[0].p_fm_speciality, f_search_criteria.document.forms[0].p_to_speciality, messageFrame ) ) 
			{
		  		if( f_search_criteria.CheckString( getLabel("Common.ServiceCode.label","Common"),f_search_criteria.document.forms[0].p_fm_service, f_search_criteria.document.forms[0].p_to_service, messageFrame ) )  
  					{
                       if( f_search_criteria.CheckString( getLabel("Common.patientId.label","Common"),f_search_criteria.document.forms[0].p_patient_id,
						   f_search_criteria.document.forms[0].p_patient_id,messageFrame ) ) 				    	
                    	   f_search_criteria.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
                           f_search_criteria.document.forms[0].target="messageFrame";
                    	   f_search_criteria.document.forms[0].submit() ;	
							
					}
						
  				
  			}
		}
	//}
 } 
	
	
}

async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.forms[0].p_patient_id.value=pat_id;
}

async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var facilityid = document.forms[0].p_facility_id.value;
			//var facility=obj1.value;
			var locale=document.forms[0].locale.value;

			if(obj.name=="locn" || obj.name=="p_fm_locn_code" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"'  and language_id='"+locale+"' and level_of_care_ind = 'E' and CLINIC_TYPE = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
			}
			
		
			
			if(obj.name=="service"|| obj.name=="p_fm_service" || obj.name=="p_to_service")
			{
				tit=getLabel("Common.service.label","Common");
				sql="select service_code code, short_desc description from am_service_lang_vw where  language_id='"+locale+"' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
			}
			
			if(obj.name=="speciality" || obj.name=="p_fm_speciality" || obj.name=="p_to_speciality")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality_lang_vw where language_id='"+locale+"' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
				
			}
					
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}
			
			
			
function DateCompare_from(obj2,obj)
{
var sysdt = parent.frames[1].document.forms[0].sys_date.value;

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(obj1,sysdt,'DMY',localeName)==false)
				{
				alert(getMessage("NOSHOW_FM_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(obj1,sysdt,'DMY',localeName)==false)
				{
				alert(getMessage("NOSHOW_FM_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
}

}

function DateCompare_apply(from,to)
	{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				//var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				//parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}

	}
