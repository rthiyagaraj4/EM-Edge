
/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/

function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function run() 
{
 	f_query_add_mod.document.forms[0].p_visit_type_from.value = f_query_add_mod.document.forms[0].p_fm_visit_type.value;
	f_query_add_mod.document.forms[0].p_visit_type_to.value = f_query_add_mod.document.forms[0].p_to_visit_type.value;
		
	f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
	f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
    f_query_add_mod.document.forms[0].p_specialty_code_from.value =f_query_add_mod.document.forms[0].p_fm_specialty_code.value;
	f_query_add_mod.document.forms[0].p_specialty_code_to.value	=f_query_add_mod.document.forms[0].p_to_specialty_code.value;
    f_query_add_mod.document.forms[0].p_service_code_from.value= f_query_add_mod.document.forms[0].p_fm_service_code.value;
	 f_query_add_mod.document.forms[0].p_service_code_to.value=f_query_add_mod.document.forms[0].p_to_service_code.value;

	  f_query_add_mod.document.forms[0].p_pract_id_from.value= f_query_add_mod.document.forms[0].p_fm_pract_id.value;
	 f_query_add_mod.document.forms[0].p_pract_id_to.value=f_query_add_mod.document.forms[0].p_to_pract_id.value;
	
	
	var fields = new Array(f_query_add_mod.document.forms[0].p_fm_date,
		f_query_add_mod.document.forms[0].p_to_date);
	var names = new Array(getLabel("eOP.StatisticsDateFrom.label","Op"),getLabel("eOP.StatisticsDateTo.label","Op"));
	//var names = new Array((getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
		if(chkGrtr(f_query_add_mod.document.forms[0].p_fm_date,
	        f_query_add_mod.document.forms[0].p_to_date) == true)
				if(f_query_add_mod.CheckString( getLabel("Common.VisitTypeCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_visit_type,f_query_add_mod.document.forms[0].p_to_visit_type,messageFrame))
                 if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
	              if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label",'Common'),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))	       
	                if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
	                  if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))     
	                    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame"; 
						f_query_add_mod.document.forms[0].submit();
	}

function reset() 
{   
	//Modified by Arthi on 30-May-2022 for MOHE-CRF-0136
	//f_query_add_mod.document.forms[0].reset();
	 parent.content.frames[1].location.reload();
}

/*Added by Arthi on 30-May-2022 for MOHE-CRF-0136*/
function changeFacility(obj)
{
	var p_user_name = document.forms[0].p_user_name.value;
	var locale = document.forms[0].locale.value;
	var p_resp_id = document.forms[0].p_resp_id.value;
	var p_gov_code = obj.value;

	deleteValues(document.forms[0].p_facilityid);

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH p_user_name=\""+p_user_name+"\" locale=\""+locale+"\" p_resp_id=\""+p_resp_id+"\" p_gov_code=\""+p_gov_code+"\" action='getFacilityValue' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	var FacilityValue = trimString(responseText);

	var arr = new Array();
	arr = FacilityValue.split("##");

	if(FacilityValue != '')
	{
		for(i=0; i<arr.length; i++) 
		{
			var FacilityArr = new Array();
			FacilityArr = trimString(arr[i]).split("~~");

			var facility_id = FacilityArr[0];
			var facility_name = FacilityArr[1];

			var opt = document.createElement('OPTION');
			opt.text = facility_name;
			opt.value = facility_id;
			document.forms[0].p_facilityid.add(opt);
		}
	}
}

function deleteValues(obj)
{
	while(obj.options.length>1) obj.options.remove(1);
}
/*End MOHE-CRF-0136*/

