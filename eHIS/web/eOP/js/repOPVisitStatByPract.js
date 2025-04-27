function run()
{ 
	var fields1 = new Array( f_query_add_mod.document.forms[0].p_nationality,
		                    f_query_add_mod.document.forms[0].p_date_from,
							f_query_add_mod.document.forms[0].p_date_to 
		                    );
	var names1 = new Array(getLabel("Common.nationality.label","Common"),getLabel("Common.periodfrom.label","Common"), getLabel("Common.periodto.label","Common"));
	f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
	f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
	f_query_add_mod.document.forms[0].p_pract_from.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;	
	f_query_add_mod.document.forms[0].p_pract_to.value=	f_query_add_mod.document.forms[0].p_to_pract_id.value;	
//	f_query_add_mod.document.forms[0].p_incl_no_show.value = f_query_add_mod.document.forms[0].statistics.value;
//	f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
	f_query_add_mod.document.forms[0].p_date_from.value = f_query_add_mod.document.forms[0].p_fm_date.value;	
	f_query_add_mod.document.forms[0].p_date_to.value = f_query_add_mod.document.forms[0].p_to_date.value;	

// if( f_query_add_mod.CheckString('Location Code', f_query_add_mod.document.repVisitTypeforClinic.p_fm_clinic_code,f_query_add_mod.document.repVisitTypeforClinic.p_to_clinic_code, messageFrame )  )
	if(f_query_add_mod.checkFields( fields1, names1, messageFrame))
    {
	if(chkGrtr(f_query_add_mod.document.forms[0].p_date_from,f_query_add_mod.document.forms[0].p_date_to)==true)
	if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
	if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
	if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label",'Common'),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
	if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.forms[0].submit();
	}
 }
}
/* function validateDate(obj)
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
function reset() {
	f_query_add_mod.document.forms[0].reset();
	}

async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var tit="";
	var p_faclid = VisitByStatus_form.P_facilityid.value;
	var p_usr = VisitByStatus_form.p_user_name.value;
	var p_resp =VisitByStatus_form.p_resp_id.value;
	/*var practitionerName="";
	var practitionerValue="";
	var practitionerTypeValue="";
	var speciality="";*/0
	var locale=VisitByStatus_form.locale.value;

	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
	if(obj.name=="tolocn" || obj.name=="fromlocn")
	{
		tit=getLabel("Common.Location.label","Common");

		
		//SQL
		
		//argumentArray[0]="select clinic_code code, short_desc description from op_clinic where (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		//argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where (('"+p_faclid+"' like ? and language_id='"+locale+"' and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";

		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";


		argumentArray[1]=new Array("'"+p_faclid+"'","appl_user_id","resp_id","'"+p_faclid+"'","facility_id");
		argumentArray[2]=new Array("All",p_usr,p_resp,"All",p_faclid);
		argumentArray[3]=new Array(STRING,STRING,STRING,STRING,STRING);
		argumentArray[4]="6,7";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

	}			
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
        tit=getLabel("Common.speciality.label","Common");


		//SQL

        //argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

        argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

    }
	else if(obj.name=="toservice" || obj.name=="fromservice")
    {
        tit=getLabel("Common.service.label","Common");

		//SQL

		//argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service where '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
        
		argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where '1' like ?  and language_id='"+locale+"' and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";				

		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

	}
	else
	{
		/*
		//sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sql="SELECT practitioner_id,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type,position_code job_title, gender, am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,'"+locale+"',1) primary_specialty FROM am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1))))  AND DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),	   DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123'))) ORDER BY 2";
			
		//sqlSecond="SELECT practitioner_id,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type,position_code job_title, gender, am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,'"+locale+"',1) primary_specialty FROM am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1))))  AND DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),	   DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND UPPER(NVL(position_code,'123')) LIKE PPER(NVL(?,NVL(position_code,'123'))) order by 2 ";

		sqlSecond="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

		practitionerName=target.name;
		practitionerValue=target.value;
				
		*/
		
		if(obj.name=="pract_id1")
		{
			if(document.forms[0].p_fm_specialty_code)
				speciality=document.forms[0].p_fm_specialty_code.value;

			if(document.forms[0].fm_pract_type)
				practitionerTypeValue=document.forms[0].fm_pract_type.value;

		}
		else
		{
			if(document.forms[0].p_to_specialty_code)
				speciality=document.forms[0].p_to_specialty_code.value;

			if(document.forms[0].to_pract_type)
				practitionerTypeValue=document.forms[0].to_pract_type.value;
		}

		await getPractitioner(obj,target,'',speciality,practitionerTypeValue,'','','','','',"Q2");
		
		/*

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
		xmlStr += " practitioner_type=\"" + practitionerTypeValue + "\"";
		xmlStr += " specialty_code=\"" + speciality + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		*/		
		return;            

	}
	
	var retVal=await CommonLookup(tit,argumentArray);

	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
		            
}

function PractLookupRetVal(retVal,objName)
{

	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="p_fm_pract_id")
			document.forms[0].p_fm_pract_id.value=arr[0];
		else
			document.forms[0].p_to_pract_id.value=arr[0];
						
	}
	else
	{
		
		if(objName=="p_fm_pract_id")
			document.forms[0].p_fm_pract_id.value="";
		else
			document.forms[0].p_to_pract_id.value="";
						
	}
	
}
