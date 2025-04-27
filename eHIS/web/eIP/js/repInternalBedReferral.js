function reset()
{
	f_query_add_mod.document.repInternalBedReferralForm.reset() ;
}


function run() 
{
  var repInternalBedReferralForm= f_query_add_mod.document.repInternalBedReferralForm;
  if(repInternalBedReferralForm)
  {
    var fields = new Array( repInternalBedReferralForm.p_fm_ref_date,repInternalBedReferralForm.p_to_ref_date);
	var names = new Array((getLabel("Common.referral.label","Common")+" "+getLabel("Common.date.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.referral.label","Common")+" "+getLabel("Common.date.label","Common")+" "+getLabel("Common.to.label","Common")));
  if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		  if(CheckString(getLabel("Common.NursingUnitCode.label","Common"), repInternalBedReferralForm.p_fm_nursg_unit_code,repInternalBedReferralForm.p_to_nursg_unit_code, messageFrame )  ){
			  f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			  f_query_add_mod.document.forms[0].target="messageFrame";
			  repInternalBedReferralForm.submit() ;
		  }
		}
  }
}

async function callSearchScreen()
{
            var patientid= await PatientSearch('','','','','','','Y','','','Visitreg');
			if(patientid !=null)
            document.forms[0].p_patient_id.value = patientid;
             document.forms[0].p_patient_id.focus();
			
}


async function searchCode(obj,target)
{

			var retVal = 	new String();
			var locale= document.forms[0].locale.value;
			var p_facility_id= document.forms[0].p_facility_id.value;
			var dialogHeight= "70vh" ;
			var dialogWidth	= "50vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
	
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+p_facility_id+"` and EFF_STATUS=`E` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			if(obj.name=="Speciality")
			{
				tit=getLabel('Common.speciality.label','common');
				sql="select speciality_code, short_desc from am_speciality_lang_vw where EFF_STATUS=`E` and language_id=`"+locale+"`  ";
				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="pract")
            {
	           tit=getLabel('Common.practitioner.label','common')
	           sql="select practitioner_id, short_name from am_practitioner_lang_vw where EFF_STATUS=`E` and language_id=`"+locale+"` ";
	           search_code="practitioner_id";
	           search_desc= "short_name";
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

function DateCompare(from,to,messageFrame,getVal) 
{
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate != "" && todate != "" ) 
	{
		if(validDate(fromdate,"DMY","en") && validDate(todate,"DMY","en"))
		{
			var greg_fromDate = convertDate(fromdate,'DMY',localeName,'en');
			var greg_toDate = convertDate(todate,'DMY',localeName,'en');
			 if(!isBefore(greg_fromDate,greg_toDate,'DMY','en'))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
				return false;
			}
			else 
			{
				return true;
			}
		}
	  }
	return true;
 }

function CheckString(str,fromobj,toobj,messageFrame) {
var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) { 
            return true;
        }
        else {
var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
error=error.replace("#",str);
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
