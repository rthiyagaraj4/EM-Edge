function run() {
	var fields = new Array ( f_query_add_mod.document.forms[0].mon,
						f_query_add_mod.document.forms[0].years
					    );
	var names = new Array ( getLabel("eOA.StatisticsMonth.label","eOA")
,getLabel("Common.year.label","Common")
);

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		f_query_add_mod.document.forms[0].P_From_Clinic_Code.value = f_query_add_mod.document.forms[0].from_clinic_code.value;
		f_query_add_mod.document.forms[0].P_To_Clinic_Code.value = f_query_add_mod.document.forms[0].to_clinic_code.value; f_query_add_mod.document.forms[0].P_Start_Month.value = f_query_add_mod.document.forms[0].mon.value;
		f_query_add_mod.document.forms[0].P_Start_Year.value = f_query_add_mod.document.forms[0].years.value; 
	if( f_query_add_mod.CheckString1(getLabel("Common.locationcode.label","Common")
, f_query_add_mod.document.forms[0].P_From_Clinic_Code,f_query_add_mod.document.forms[0].P_To_Clinic_Code, messageFrame )  )	{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.forms[0].submit();
}
	}
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}

function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].from_clinic_code.value='';
	document.forms[0].to_clinic_code.value='';
}

function CheckString1(str ,fromobj,toobj,messageFrame) {

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

		var facilityid = document.forms[0].P_Facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
		var locale=document.forms[0].locale.value;
			

			if(obj.name=="locn" || obj.name=="from_clinic_code" || obj.name=="to_clinic_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description, facility_id from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			}

			if(obj.name=="spec" || obj.name=="P_FM_SPECIAL" || obj.name=="P_TO_SPECIAL")
			{
				
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code,short_Desc description from am_speciality_lang_vw where language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_Desc) like upper(?) order by 2";
								
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

/*function validateYear(obj)
	{
		var msg;
	if (obj.value!=""){
		if (obj.value < 1900 || obj.value > 3000)
		{
			msg = getMessage("YR_CHECK","OA")+ "<br>";
			document.forms[0].years.value ="";
			obj.focus();
		}
		if (msg!=null && msg != "")
		{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg ;
		}
	 }
	}*/



	function validateYear(obj)
	{
		var msg;
		if (obj.value!=""){
			
		var greg_obj = convertDate(obj.value,"yy",localeName,"en");
		
		if (greg_obj < 1900 || greg_obj > 3000)
		{
			msg = getMessage("YR_CHECK","OA")+ "<br>";
			document.forms[0].years.value ="";
			obj.focus();
		}
		if (msg!=null && msg != "")
		{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg ;
		}

		}
	}
