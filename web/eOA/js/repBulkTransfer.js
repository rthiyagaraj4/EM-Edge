async function searchCode1(obj,target_code,target_desc)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var fac_id=document.forms[0].fac_id.value;
				var locale=document.forms[0].locale.value;
				var oper_stn_id=document.forms[0].oper_stn_id.value;
				var tit="";
				var sql="";
if(obj.name=="speciality" || obj.name=="P_SPECIALTY_CODE_FROM" )
			{
				
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+fac_id+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E') and language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
			}else if(obj.name=="speciality1" || obj.name=="P_SPECIALTY_CODE_TO" )
			{
				
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code, short_desc description from am_speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+fac_id+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E') and language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
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
			if(obj.name=="speciality" || obj.name=="P_SPECIALTY_CODE_FROM")
	{
			if(target_code.value !="")
			{
				document.forms[0].P_LOCATION_CODE_FROM.disabled=false;
				document.forms[0].locn.disabled=false;
			}else
			{
				document.forms[0].P_LOCATION_CODE_FROM.disabled=true;
				document.forms[0].locn.disabled=true;
			}
	}else
	{
		if(target_code.value !="")
			{
				document.forms[0].P_LOCATION_CODE_TO.disabled=false;
				document.forms[0].locn1.disabled=false;
			}else
			{
				document.forms[0].P_LOCATION_CODE_TO.disabled=true;
				document.forms[0].locn1.disabled=true;
			}
	}
//Added by shanmukh for ML_MMOH-CRF-1115.1	
if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N" && document.forms[0].P_SPECIALTY_CODE_FROM.value!=""){
	document.forms[0].P_LOCATION_CODE_TO.disabled=false;
	document.forms[0].locn1.disabled=false;
	document.forms[0].P_SPECIALTY_CODE_TO.value= document.forms[0].P_SPECIALTY_CODE_FROM.value;
}

}

async function searchCode2(obj,target_code,target_desc)
{
				var retVal		   = new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var fac_id=document.forms[0].fac_id.value;
				var locale=document.forms[0].locale.value;
				var oper_stn_id=document.forms[0].oper_stn_id.value;
				var speciality_code_from=document.forms[0].P_SPECIALTY_CODE_FROM.value;
				var speciality_code_to=document.forms[0].P_SPECIALTY_CODE_TO.value;
				var loginuser=document.forms[0].loginuser.value;
				var tit="";
				var sql="";
if(obj.name=="locn" || obj.name=="P_LOCATION_CODE_FROM")
			{
				
				tit=getLabel("Common.Location.label","Common");
				sql="select a.clinic_code code,a.long_desc description from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+fac_id+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type and a.SPECIALITY_CODE ='"+speciality_code_from+"'  and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 "
				
			}if(obj.name=="locn1" || obj.name=="P_LOCATION_CODE_TO")
			{
				
				tit=getLabel("Common.Location.label","Common");
				sql="select a.clinic_code code,a.long_desc description from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+fac_id+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type and a.SPECIALITY_CODE ='"+speciality_code_to+"'  and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 "
				
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
				if(obj.name=="locn" || obj.name=="P_LOCATION_CODE_FROM")
	{
				if(target_code !="")
				{
				document.forms[0].p_fm_pract_id.disabled=false;
				document.forms[0].pract_id.disabled=false;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()

								
				xmlStr ="<root><SEARCH clinic_code = \""+target_code.value+"\"  from_part='Locnfrom' steps='bulk_report'/></root>"

				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","ServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
				
				}else
				{
				document.forms[0].p_fm_pract_id.disabled=true;
				document.forms[0].pract_id.disabled=true;

				}
	}else
	{
				if(target_code !="")
				{
				document.forms[0].p_to_pract_id.disabled=false;
				document.forms[0].pract_id1.disabled=false;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()

								
				xmlStr ="<root><SEARCH clinic_code = \""+target_code.value+"\" from_part='Locnto' steps='bulk_report'/></root>"

				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","ServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
				
				}else
				{
				document.forms[0].p_to_pract_id.disabled=true;
				document.forms[0].pract_id1.disabled=true;

				}
	}

}

function ValidateDate(obj)
	{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
}

function run()
{	//Added by shanmukh for ML_MMOH-CRF-1115.1
	if(frames[1].document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
		if(frames[1].document.forms[0].p_fm_speciality.value!=""){
		frames[1].document.forms[0].P_SPECIALTY_CODE_TO.value= frames[1].document.forms[0].P_SPECIALTY_CODE_FROM.value;
		}else{
			frames[1].document.forms[0].P_SPECIALTY_CODE_TO.value="";
			frames[1].document.forms[0].P_SPECIALTY_CODE_FROM.value="";
		}
	}
		
	var fields = new Array(frames[1].document.forms[0].P_APPT_DATE_FROM,
						frames[1].document.forms[0].P_APPT_DATE_TO);

var names = new Array(getLabel("eOA.ApptDateFrom.label","OA"),
					getLabel("eOA.ApptDateTo.label","OA"));
if(frames[1].checkFields( fields, names, messageFrame))
{
		frames[1].document.bulktransferapptreport.action="../../eCommon/jsp/report_options.jsp";
    	frames[1].document.bulktransferapptreport.target="messageFrame";
		frames[1].document.bulktransferapptreport.submit() ;
}
}


function reset()
{
	frames[1].document.bulktransferapptreport.reset() ;
}
//Added by shanmukh for ML_MMOH-CRF-1115.1
function chkSpecVal(target,target_from_code,target_to_code){
	if(target.value==""){
		target_from_code.value="";
	target_to_code.value="";}
	
}	
