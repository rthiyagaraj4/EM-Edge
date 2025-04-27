// Module	: Inpatient Management ... [IP]
// Function	: Common For IP Module Query 
// Added by Sridhar on 1st JUNE 2004 
// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit(getFacilitID,loginuser,oper_stn_id)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
		 getNursingUnit(getFacilitID,loginuser,oper_stn_id)
		else
		document.forms[0].nursing_unit.value = "";
	}
}

function beforeGetSpecialty(aSpecialty,getFacilitID)
{
	if(document.forms[0].specialty_desc.value=="")
	{
		document.forms[0].Splcode.value="";
		document.forms[0].spec_desc_hid.value = "";
	}
	if(document.forms[0].spec_desc_hid.value != document.forms[0].specialty_desc.value)
	{
		if(document.forms[0].specialty_desc.value != "")
			getSpecialty(aSpecialty,getFacilitID);
		else
		
			document.forms[0].Splcode.value="";
	}
}
function beforeGetPractitioner(obj,target,facilityID)
{
	if(document.forms[0].pract_desc.value=="")
	{
		document.forms[0].practid.value="";
		document.forms[0].pract_desc_hid.value="";
	}

	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value != "")
		getPractitionerLocal(obj,target,facilityID);
	}
}
		
async function getNursingUnit(getFacilitID,loginuser,oper_stn_id,call_function)
{
	
	var call_function =document.forms[0].call_function.value;
	if( (call_function != 'CA') && (call_function != 'RA') && (call_function != 'OP') && (call_function != 'CT') && (call_function != 'QUERY_UNASSIGNED_PATS') )
	{
		
		var booking_type		= document.forms[0].booking_type.value;
		// var day_unit_id = document.forms[0].daycare_unit.value;
	}
	var nur_unit				= document.forms[0].nursing_unit_desc.value;
	
	var Facility_ID				= getFacilitID;
	var Login_User				= loginuser;
	var Operator_Station_ID		= oper_stn_id;
	if(loginuser==null)		
		Login_User = '';
	if(oper_stn_id==null)	
		Operator_Station_ID = '';
	if(booking_type =='D')
	{
		var target	= document.forms[0].daycare_unit_desc;
	}
	else
	{
		var target	= document.forms[0].nursing_unit_desc;
	}
	var sql						= "";
	var sql_nu					="";
	var tit						= getLabel("Common.nursingUnit.label","Common");	

	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var where_condn				= '';
	
	if(call_function == 'RCB')
		where_condn = " and (CANC_BOOKING_YN = 'Y' or CONFIRM_BOOKING_YN = 'Y' or REVISE_BOOKING_YN = 'Y' ) ";
	else if(call_function == 'AT')
		where_condn				= " and ADMIT_PAT_YN = 'Y'  ";
	else
		where_condn				= "";
	
	if(Operator_Station_ID != '' && Login_User != '')
	{
		
		var splty_code="";
		var pract_id="";
		var Operator_Station_ID="";
		var call_function =document.forms[0].call_function.value;
		var tit			= getLabel("Common.nursingUnit.label","Common");
		var dialogHeight			= "630px" ;
		var dialogWidth				= "850px" ;
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		var retVal =    new String();
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nur_unit)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=Y&bkg_type="+booking_type;

		var retVal =  await window.showModalDialog(jsp_name,arguments,features);
		var arr=new Array();
		
	}
	else
	{
		
		var splty_code="";
		var pract_id="";
		var Operator_Station_ID="";
		var call_function =document.forms[0].call_function.value;
		var tit			= getLabel("Common.nursingUnit.label","Common");
		var dialogHeight			= "630px" ;
		var dialogWidth				= "850px" ;
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		var retVal =    new String();
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nur_unit)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=Y&bkg_type="+booking_type;

		
		var retVal =  await window.showModalDialog(jsp_name,arguments,features);
		var arr=new Array();
	}
	if(retVal != null && retVal != "" )
	{
		
		arr=retVal.split("~");
		if(booking_type =='D')
		{
			document.forms[0].nursing_unit_desc.value=arr[1];
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		}
		else
		{
		document.forms[0].nursing_unit_desc.value=arr[1];
		document.forms[0].nursing_unit.value=arr[0];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		}
	}
	else
	{
		
		if(booking_type =='D')
		{
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit.value="";
		}
		else
		{
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit.value="";
		}
	}
}

function getNursingUnitBlur(getFacilitID,loginuser,oper_stn_id,call_function)
{
	if(document.forms[0].nursing_unit_desc.value == "")
	{
		document.forms[0].nursing_unit.value = "";
	}
	if(document.forms[0].nursing_unit_desc.value != "")
		getNursingUnit(getFacilitID,loginuser,oper_stn_id,call_function)
}

function getDaycareUnitBlur(getFacilitID,loginuser,oper_stn_id,call_function)
{
	if(document.forms[0].daycare_unit_desc.value == "")
	{	
		document.forms[0].daycare_unit.value = "";
	}
	if(document.forms[0].daycare_unit_desc.value != "")
		getDaycareUnit(getFacilitID,loginuser,oper_stn_id,call_function);	
}

// Added by kishore on 8/19/2004
async function getDaycareUnit(getFacilitID,loginuser,oper_stn_id,call_function)
{
	var booking_type			=  document.forms[0].booking_type.value;
	var daycare_unit			=  document.forms[0].daycare_unit_desc.value;
	var day_unit_id				=  document.forms[0].daycare_unit.value;
	
	var Facility_ID				=	getFacilitID;
	var Login_User				=	loginuser;
	var Operator_Station_ID		=	oper_stn_id;

	if(loginuser==null)		Login_User = '';
	if(oper_stn_id==null)	Operator_Station_ID = '';
		var target					= document.forms[0].daycare_unit_desc;
	var sql						= "";
	var sql_nu					="";
	var tit						= getLabel("Common.DaycareUnit.label","Common");
	var retVal					= new String();
	var argumentArray			= new Array() ;
	var dataNameArray			= new Array() ;
	var dataValueArray			= new Array() ;
	var dataTypeArray			= new Array() ;
	var where_condn				= '';
	
	if(call_function == 'RCB')
		where_condn = " and (CANC_BOOKING_YN = 'Y' or CONFIRM_BOOKING_YN = 'Y' or REVISE_BOOKING_YN = 'Y' ) ";
	else if(call_function == 'AT')
		where_condn = " and ADMIT_PAT_YN = 'Y'  ";
	else
		where_condn = "";

	if(Operator_Station_ID != '' && Login_User != '')
	{
		sql="select a.clinic_code code,a.short_desc description from op_clinic a, am_os_user_locn_access_vw b where a.facility_id = '"+Facility_ID+"' and a.facility_id = b.facility_id and a.clinic_code = b.locn_code and b.locn_type = 'Y' and b.oper_stn_id = '"+Operator_Station_ID+"' and b.appl_user_id ='"+Login_User+"' and 	upper(a.clinic_code) like upper(?) and upper(a.short_desc) like upper(?)";
		argumentArray[0]	= sql;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1, 2";
	}
	else 
	{
		sql="Select a.clinic_code code,a.short_desc description from op_clinic a, am_os_user_locn_access_vw b  where facility_id = '"+Facility_ID+"' and a.facility_id = b.facility_id and and a.clinic_code = b.locn_code and b.locn_type = 'Y' and  upper(clinic_code code) like upper(?) and upper(clinic_short_desc) like upper(?)";
		argumentArray[0]	= sql;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
	} 
	argumentArray[5]	= document.forms[0].daycare_unit_desc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].daycare_unit_desc.value=arr[1];
		document.forms[0].daycare_unit.value=arr[0];
		document.forms[0].dcare_desc_hid.value = document.forms[0].daycare_unit_desc.value;	
	}
	else
	{
		document.forms[0].daycare_unit_desc.value="";
		document.forms[0].daycare_unit.value="";
	}
  }
// E.o GerNursingUnit
/*
function getSpecialty(getFacilitID)
{
	var tit				= getLabel("Common.speciality.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var locale = document.forms[0].locale.value;	

	sql=" Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like ? and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";

	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "2,3";
	argumentArray[5]	= document.forms[0].specialty_desc.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].specialty_desc.value=arr[1];
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].spec_desc_hid.value = document.forms[0].specialty_desc.value;
	}
	else
	{
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	}
}
*/

async function getSpecialty(aSpecialty, getFacilitID)
{

	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].specialty_desc;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;
	sql=" Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
	/*Wednesday, June 02, 2010 modified for PE*/
	//sql=" Select speciality_code code,am_get_desc.am_speciality(speciality_code,'"+locale+"',2)description from AM_SPECIALITY where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
	tit=getLabel("Common.speciality.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aSpecialty.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
			document.forms[0].Splcode.value=arr[0];
			document.forms[0].specialty_desc.value=arr[1];
	}
	else
	{
		
			document.forms[0].specialty_desc.value = "";
			document.forms[0].Splcode.value = "";
		
	}
} // End of getSpecialtyValue.
function getPractitionerLocal(obj,target,facilityID)
{ 
	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";
	
	practName_FName	= target.name;
	practName_FValue= target.value;
	practId_FName	= document.forms[0].practid.name;
	var splty		= "";
	var facility_id = "";
	facility_id		= facilityID;
	var sql2		= "";
	locale=document.forms[0].locale.value;

	getPractitioner(obj, target, facility_id, splty,"", "Q2");
	 
	
	/*sql = "SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  '"+locale+"',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, '"+locale+"',  2) primary_specialty,  DECODE(b.gender,  'M',  'Male',  'F',  'Female',  'U',  'Unknown') gender,  am_get_desc.am_position(b.position_code,'"+locale+"',1) job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= '"+facility_id+"'" ;

	sql2 = "SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  '"+locale+"',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, '"+locale+"',  2) primary_specialty,  DECODE(b.gender,  'M',  'Male',  'F',  'Female',  'U',  'Unknown') gender,  am_get_desc.am_position(b.position_code,'"+locale+"',1) job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and   UPPER(am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= '"+facility_id+"'" 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + splty+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];			
		document.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].pract_desc.value="";			
	}
}

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// These functions are called from QueryDailyMonthlyBookingCriteria.jsp
// Added by Sridhar R on 2/23/2005
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function DateCompare_Booking(from,to) 
{
	var fromdate = from.value ;
	var todate = to.value ;

	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);
	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}
			
function submitPage_Booking()
{				
	document.forms[0].search.disabled=true;
	if(document.forms[0].booking.value == 'D')
	{
		var names = new Array (	getLabel('Common.PreferredDateFrom.label','Common'),
								getLabel("eIP.PreferredDateTo.label","IP"));
		var fields=new Array();
			fields[0]= document.forms[0].from_date;
			fields[1]= document.forms[0].to_date;
	}
	else
	{
		var names = new Array (	getLabel('eIP.PreferredMonthFrom.label','IP'),
								getLabel("eIP.PreferredMonthTo.label","IP"));
		var fields=new Array();
		fields[0]= document.forms[0].from_month;
		fields[1]= document.forms[0].to_month;
	}

	if(!parent.criteria.checkFields( fields, names, parent.messageFrame))
	{
		document.forms[0].search.disabled=false;
	}
	else
	{
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		var params = "daily_monthly="+escape(document.getElementById("booking").value)+"&group_by="+document.getElementById("order").value
		if(document.getElementById("nursing_unit")!=null && document.getElementById("nursing_unit").value != '')
			params+="&nursing_unit="+escape(document.getElementById("nursing_unit").value);
		if(document.getElementById("Bedcode")!=null && document.getElementById("Bedcode").value != '')
			params+="&bed_class="+escape(document.getElementById("Bedcode").value);
		if(document.getElementById("medical_service_grp")!=null && document.getElementById("medical_service_grp").value != '')
			params+="&medical_service_grp="+escape(document.getElementById("medical_service_grp").value);
		if(document.getElementById("from_date")!=null && document.getElementById("from_date").value != '')
			params+="&from_date="+document.getElementById("from_date").value;
		if(document.getElementById("to_date").value!=null && document.getElementById("to_date").value != '')
			params+="&to_date="+document.getElementById("to_date").value;
		if(document.getElementById("from_month")!=null && document.getElementById("from_month").value != '')
			params+="&from_month="+document.getElementById("from_month").value;
		if(document.getElementById("to_month")!=null && document.getElementById("to_month").value != '')
			params+="&to_month="+document.getElementById("to_month").value;	
		
		parent.result.location.href= '../jsp/QueryDailyMonthlyBookingResult.jsp?'+params
	}
}

// Added by Sridhar on 2nd JUNE 2004 
// Function will check for empty values before calling up the common lookup func..
function beforeCommonLookupSearch_Booking(target_id,target)
{
	if(target_id.name == "medical_service_grp")
	{
		if(document.forms[0].medical_service_grp_desc.value != "")
			CommonLookupSearch_Booking(target_id,target)
		else
		{
			if(document.forms[0].medical_service_grp != null)
				document.forms[0].medical_service_grp.value="";			
		}
	}
	else if(target_id.name == "nursing_unit")
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			CommonLookupSearch_Booking(target_id,target)
		else
		{
			document.forms[0].nurs_desc_hid.value="";
			if(document.forms[0].nursing_unit != null)
				document.forms[0].nursing_unit.value="";
		}
	}
	else if(target_id.name == "Bedcode")
	{
		if(document.forms[0].bed_class_desc.value != "")
			CommonLookupSearch_Booking(target_id,target)
		else 
			document.forms[0].Bedcode.value="";
	}
}


/* CREATED ON 11/02/04 by SRIDHAR */
/* START OF COMMON LOOKUP FOR MEDICAL SERVICE GROUP, NURSING UNIT & BED CLASS */

async function CommonLookupSearch_Booking(target_id,target)
{
	var title="";
	var argumentArray=new Array(8);
	var facilityid = document.forms[0].facilityID.value;
	var locale = document.forms[0].locale.value;

	if(target_id.name == "medical_service_grp")
	{
		title=getLabel("eIP.MedicalServiceGroup.label","IP");

		argumentArray[0]=" select MED_SER_GRP_CODE code, SHORT_DESC description from IP_MEDICAL_SERVICE_GRP_LANG_VW where language_id = '"+locale+"' and facility_id like ? and upper(MED_SER_GRP_CODE) like upper(nvl(?,MED_SER_GRP_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}

	if(target_id.name == "nursing_unit")
	{
		title=getLabel("Common.nursingUnit.label","Common");

		argumentArray[0]=" select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}

	if(target_id.name == "Bedcode")
	{
		title=getLabel("Common.BedClass.label","common");

		argumentArray[0]=" select BED_CLASS_CODE code, SHORT_DESC description from IP_BED_CLASS_LANG_VW where language_id = '"+locale+"' and  eff_status like ? and upper(BED_CLASS_CODE) like upper(nvl(?,BED_CLASS_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("eff_status");
		argumentArray[2]=new Array("E");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
			
	var retVal = await CommonLookup(title,argumentArray);
			
	if(retVal ==null || retVal=="" || !retVal)
	{
		target.value="";
		target_id.value="";
	}
	else
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target_id.value=arr[0];
		target.value=arr[1];
	}
}
// END OF COMMON LOOKUP FOR MEDICAL SERVICE GROUP, NURSING UNIT & BED CLASS Parameters

function enableDisable_Booking(obj)
{
	if(obj.value == 'D')
	{
		document.getElementById("tr3").style.display= '';
		document.getElementById("tr4").style.display= 'none';
		document.getElementById("from_month").value = '';
		document.getElementById("to_month").value = '';
	}
	else if(obj.value == 'M')
	{
		document.getElementById("tr3").style.display= 'none';
		document.getElementById("tr4").style.display= '';
		document.getElementById("from_date").value = '';
		document.getElementById("to_date").value = '';
	}
	else if(obj.value == 'MS')
	{
		document.getElementById("tr1").style.display= 'none';
		document.getElementById("tr2").style.display= '';
		document.getElementById("nursing_unit").value='';
		document.getElementById("nursing_unit_desc").value='';
		document.getElementById("Bedcode").value='';
		document.getElementById("bed_class_desc").value='';
	}
	else if(obj.value == 'NU')
	{
		document.getElementById("tr1").style.display= '';
		document.getElementById("tr2").style.display= 'none';
		document.getElementById("medical_service_grp").value = '';
		document.getElementById("medical_service_grp_desc").value = '';
	}
	clearAll_Booking();
}

function clearAll_Booking()
{
	parent.result.location.href='../../eCommon/html/blank.html'
	document.forms[0].search.disabled=false;
}	

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// These functions are called from QueryAdmByNursingUnitSpecialtyCriteria.jsp
// Added by Sridhar R on 2/23/2005
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function DateCompare_Adm(from,to) 
{
	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);
	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}

			
function submitPage_Adm()
{				
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	document.forms[0].search.disabled=true;
	var params = "daily_monthly="+document.getElementById("daily_monthly").value
	if(document.getElementById("nursing_unit")!=null && document.getElementById("nursing_unit").value != '')
		params+="&nursing_unit="+document.getElementById("nursing_unit").value;
	if(document.getElementById("Splcode")!=null && document.getElementById("Splcode").value != '')
		params+="&Splcode="+document.getElementById("Splcode").value;
	if(document.getElementById("from_date")!=null && document.getElementById("from_date").value != '')
		params+="&from_date="+document.getElementById("from_date").value;
	if(document.getElementById("to_date").value!=null && document.getElementById("to_date").value != '')
		params+="&to_date="+document.getElementById("to_date").value;
	if(document.getElementById("from_month")!=null && document.getElementById("from_month").value != '')
		params+="&from_month="+document.getElementById("from_month").value;
	if(document.getElementById("to_month")!=null && document.getElementById("to_month").value != '')
		params+="&to_month="+document.getElementById("to_month").value;
	if(document.getElementById("servicecode")!=null && document.getElementById("servicecode").value != '')
		params+="&servicecode="+document.getElementById("servicecode").value;
	if(document.getElementById("statisticby")!=null && document.getElementById("statisticby").value != '')
		params+="&statisticby="+document.getElementById("statisticby").value;

	parent.result.location.href= '../jsp/QueryAdmByNursingUnitSpecialtyResult.jsp?'+params
}
			
function enableDisable_Adm(obj)
{
	if(obj.value == 'D')
	{
		document.getElementById("tr3").style.display= '';
		document.getElementById("tr4").style.display= 'none';
		document.getElementById("from_month").value='';
		document.getElementById("to_month").value='';
	}
	else if(obj.value == 'M')
	{
		document.getElementById("tr3").style.display= 'none';
		document.getElementById("tr4").style.display= '';
		document.getElementById("from_date").value='';
		document.getElementById("to_date").value='';
	}
}

function clearAll_Adm()
{		
	parent.result.location.href='../../eCommon/html/blank.html' 				
	document.forms[0].search.disabled=false;
}

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// These functions are called from QueryBedOccupancyCriteria.jsp
// Added by Sridhar R on 2/23/2005
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function submitPage_BedOccupancy()
{
	var params = "";
	if(document.forms[0].Splcode.value != '')
		params+="&Splcode="+escape(document.forms[0].Splcode.value);
	if(document.forms[0].fr_nursing_unit.value != '')
		params+="&fr_nursing_unit="+escape(document.forms[0].fr_nursing_unit.value);
	if(document.forms[0].to_nursing_unit.value != '')
		params+="&to_nursing_unit="+escape(document.forms[0].to_nursing_unit.value);
	// added on 20-10-2003 by dhanasekaran
	document.forms[0].search.disabled=true;
	compareFrom_BedOccupancy()
	parent.result.location.href= '../jsp/QueryBedOccupancyResult.jsp?'+params
}
		
function compareFrom_BedOccupancy()
{
	fromVal	=	document.forms[0].fr_nursing_unit.value;
	toVal	=	document.forms[0].to_nursing_unit.value;
	if(fromVal != null && toVal != '')
	{
		if(toVal < fromVal)
		{
			alert(getMessage('TO_NRS_UT_GR_FR_NR_UT','IP'));
			document.forms[0].to_nursing_unit_desc.value='';
			document.forms[0].to_nursing_unit.value	='';
			document.forms[0].nursing_unit_to.focus();
			parent.result.location.href='../../eCommon/html/blank.html';
		}
	}
}

// Added by Sridhar on 2nd JUNE 2004 
// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit_BedOccupancy(target_id,target)
{
	if(target.name == "fr_nursing_unit_desc")
	{
		if(document.forms[0].fr_nursing_unit_desc.value != "")
			Lookup_BedOccupancy(target_id,target)
		else
			document.forms[0].fr_nursing_unit.value = "";
	}
	else if(target.name == "to_nursing_unit_desc")
	{
		if(document.forms[0].to_nursing_unit_desc.value != "")
			Lookup_BedOccupancy(target_id,target)
		else
			document.forms[0].to_nursing_unit.value = "";
	}
}

function beforeGetSpecialty_BedOccupancy(target_id,target)
{
	if(document.forms[0].SplDesc.value != "")
		SpecialLookup_BedOccupancy(target_id,target)
	else
		document.forms[0].Splcode.value = "";
}


/* ADDED ON 10/02/04 by SRIDHAR */
/* COMMON LOOKUP FOR Specialty */
async function SpecialLookup_BedOccupancy(target_id,target)
{
	var title="";
	var argumentArray=new Array(8);
	var locale = document.forms[0].locale.value;
	if(target.name == "SplDesc")
	{
		title=getLabel("Common.speciality.label","Common");
		argumentArray[0]="select SPECIALITY_CODE code, SHORT_DESC description from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and '1' like ? and upper(SPECIALITY_CODE) like upper(nvl(?,SPECIALITY_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
			
	var retVal=await CommonLookup(title,argumentArray);
	var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

			target.value = arr[1]; 
			target_id.value = arr[0]; 

}


/* ADDED ON 10/02/04 by SRIDHAR */
/* COMMON LOOKUP FOR NURSING UNIT FROM & TO */
async function Lookup_BedOccupancy(target_id,target)
{
	var facility_id = document.forms[0].facilityid.value;
	var title="";
	var argumentArray=new Array(8);
	var locale = document.forms[0].locale.value;

	if(target.name == "fr_nursing_unit_desc" || target.name == "to_nursing_unit_desc" )
	{
		title=getLabel("Common.nursingUnit.label","Common");

		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and EFF_STATUS like ? and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("EFF_STATUS","facility_id");
		argumentArray[2]=new Array("E",facility_id);
		argumentArray[3]=new Array(STRING,STRING);
		argumentArray[4]="3,4";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
			
	var retVal=await CommonLookup(title,argumentArray);
	
var ret1=unescape(retVal);

		 	arr=ret1.split(",");

		 	if(arr[1]==undefined) 

	 		{

		 		arr[0]="";	

		 		arr[1]="";	

	 		}


			target_id.value = arr[0]; 

			 target.value = arr[1]; 	
}


function clearAll_BedOccupancy()
{	
	parent.result.location.href='../../eCommon/html/blank.html';
	document.forms[0].search.disabled=false;
}		
		

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// These functions are called from QueryHospitalOccupancyCriteria.jsp
// Added by Sridhar R on 2/23/2005
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

// Added by Santhosh for MOHE-CRF-0144
function changeFacilityByGover(obj){
	document.forms[0].fr_nursing_unit_desc.value='';
	document.forms[0].fr_nursing_unit.value='';
	document.forms[0].to_nursing_unit_desc.value='';
	document.forms[0].to_nursing_unit.value='';
}

function nursing_unit_lookup(target_id,target) {	
	if(document.forms[0].repBasedOnGovernorate.value == "true"){
		var P_facilityid = document.forms[0].P_facilityid.value != '' ? document.forms[0].P_facilityid.value :"";
		if( P_facilityid == "All"){
			Lookup_Ward_Occupancy(target_id,target);
		} else {
			Lookup_HospOccupancy(target_id,target);
		}
	} else{
		Lookup_HospOccupancy(target_id,target);
	}
}

async function Lookup_Ward_Occupancy(target_id,target) {
	var facility_id = document.forms[0].facilityid.value;
	var title="";
	var locale = document.forms[0].locale.value;
	var P_facilityid = document.forms[0].P_facilityid.value != '' ? document.forms[0].P_facilityid.value :"";
	var facilityStrList =document.forms[0].facilityList.value;
	facilityStrList = facilityStrList.substring(1, facilityStrList.length-1);
	var facilityList = facilityStrList.split(",");
	var facilityCount=facilityList.length;
	var argumentArray=new Array(7+facilityCount);
	var facilityClause	="";
		
	for (var i = 1; i <= facilityCount; i++) {
		if(i!=facilityCount){
			facilityClause=facilityClause+"facility_id like '"+trimString(facilityList[i-1])+"'or ";
		}else{
			facilityClause=facilityClause+"facility_id like ? ";
		}
	}
	
	if(target.name == "fr_nursing_unit_desc" || target.name == "to_nursing_unit_desc" )
	{
		title=getLabel("Common.nursingUnit.label","Common");
		
		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and PATIENT_CLASS = 'IP' and EFF_STATUS like ? and ("+facilityClause+") and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";
		
		argumentArray[1]=new Array("EFF_STATUS","FACILITY_ID");
		argumentArray[2]=new Array("E",trimString(facilityList[facilityCount-1]));
		argumentArray[3]=new Array(STRING,STRING);
		argumentArray[4]="3,4";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
			
	var retVal=await CommonLookup(title,argumentArray);
	var ret1=unescape(retVal);

		 	arr=ret1.split(",");

		 	if(arr[1]==undefined) 

	 		{

		 		arr[0]="";	

		 		arr[1]="";	

	 		}


			target_id.value = arr[0]; 

			 target.value = arr[1]; 	
}

// END

function submitPage_HospOccupancy()
{				
	document.forms[0].search.disabled=true;
	var params = "";
	if(document.forms[0].fr_nursing_unit.value != '')
		params+="&fr_nursing_unit="+escape(document.forms[0].fr_nursing_unit.value);
	if(document.forms[0].to_nursing_unit.value != '')
		params+="&to_nursing_unit="+escape(document.forms[0].to_nursing_unit.value);
	if(document.getElementById("include_for_calc").checked == true)
		params+="&include_for_calc=Y"
	else
		params+="&include_for_calc=N"
	
	// Added by Santhosh For MOHE-CRF-0144
	if(document.forms[0].repBasedOnGovernorate.value == "true"){
		if(document.forms[0].P_facilityid.value != '')
		params+="&facility="+escape(document.forms[0].P_facilityid.value);
		if(document.forms[0].p_governorate_code.value != '')
			params+="&governorate="+escape(document.forms[0].p_governorate_code.value);
		if(document.forms[0].p_user_name.value != '')
			params+="&user_name="+escape(document.forms[0].p_user_name.value);
		if(document.forms[0].p_resp_id.value != '')
			params+="&p_resp_id="+escape(document.forms[0].p_resp_id.value);
	}
	// End
	parent.result.location.href= '../jsp/QueryHospitalOccupancyResult.jsp?'+params
}
	

function compareFrom_HospOccupancy()
{
	fromVal	=	document.forms[0].fr_nursing_unit.value;
	toVal	=	document.forms[0].to_nursing_unit.value;
	if(fromVal != null && toVal != '')
	{
		if(toVal < fromVal)
		{
			alert(getMessage('TO_NRS_UT_GR_FR_NR_UT','IP'));
			document.forms[0].to_nursing_unit_desc.value='';
			document.forms[0].to_nursing_unit.value	='';
			document.forms[0].nursing_unit_to.focus();
			parent.result.location.href='../../eCommon/html/blank.html';
			return false;
		}
	}
}

// Added by SRIDHAR on 2nd JUNE 2004 
// Function will check for empty values before calling up the common Lookup func..
function beforeGetNursingUnit_HospOccupancy(target_id,target)
{
	if(target.name == "fr_nursing_unit_desc")
	{
		if(document.forms[0].fr_nursing_unit_desc.value != "")
			Lookup_HospOccupancy(target_id,target);
		/* Wednesday, December 30, 2009 IN017811 */
		else
		{
			document.forms[0].fr_nursing_unit_desc.value = "" ;
			document.forms[0].fr_nursing_unit.value = "" ;
		}
		/**/
	}
	else
	if(target.name == "to_nursing_unit_desc")
	{
		if(document.forms[0].to_nursing_unit_desc.value != "")
			Lookup_HospOccupancy(target_id,target);
		/* Wednesday, December 30, 2009 IN017811 */
		else
		{
			document.forms[0].to_nursing_unit_desc.value = "" ;
			document.forms[0].to_nursing_unit.value = "" ;
		}
		/**/
	}
}
/* CREATED ON 09/02/04 by SRIDHAR */
/* COMMON Lookup_HospOccupancy FOR NURSING UNIT FROM & TO */
async function Lookup_HospOccupancy(target_id,target)
{
	var facility_id = document.forms[0].facilityid.value;
	var title="";
	var locale = document.forms[0].locale.value;
	var argumentArray=new Array(8);
	var P_facilityid="";
	if(document.forms[0].repBasedOnGovernorate.value == "true"){
		P_facilityid = document.forms[0].P_facilityid.value;
	}
	
	if(target.name == "fr_nursing_unit_desc" || target.name == "to_nursing_unit_desc" )
	{
		title=getLabel("Common.nursingUnit.label","Common");

		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and PATIENT_CLASS = 'IP' and EFF_STATUS like ? and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))";

		argumentArray[1]=new Array("EFF_STATUS","FACILITY_ID");
		argumentArray[2]=new Array("E",P_facilityid!="All"?P_facilityid:facility_id);
		argumentArray[3]=new Array(STRING,STRING);
		argumentArray[4]="3,4";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
			
	var retVal=await CommonLookup(title,argumentArray);
			
	var ret1=unescape(retVal);

		 	arr=ret1.split(",");

		 	if(arr[1]==undefined) 

	 		{

		 		arr[0]="";	

		 		arr[1]="";	

	 		}


			target_id.value = arr[0]; 

			 target.value = arr[1]; 	
}

function clearAll_HospOccupancy()
{
	parent.result.location.href='../../eCommon/html/blank.html';
	document.forms[0].search.disabled=false;
}					
//============== Functions	copied from QueryUnassignedPatientsCriteria.jsp=============
function validate_user(obj)
{
	var user_name=obj.value;
	document.forms[0].user.value='';
	if(user_name!='')
	{
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/ValidateUser.jsp'><input type='hidden' name='user_name' id='user_name' value='"+user_name+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}
}
function DateCompare_unasgPat(from,to) 
{	
	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);

	if(flg1 && flg2 )
	{

		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
	
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}

function date_compare_sysdate(obj)
{
	if(validDate(obj.value,"DMY",localeName))
	{
		greg_dat = convertDate(obj.value, "DMY", localeName,'en')
		if(!isBefore(greg_dat,getCurrentDate("DMY",'en'),"DMY",'en'))
		{
			alert(getMessage("START_DATE_GREATER_SYSDATE","Common"));
			obj.value="";
			obj.focus();
		}
	}
	return true;
}

function chkSplChar(obj)
{
	var fields = new Array(obj);
	var names = new Array("Patient ID");
	if(!SpecialCharCheck(fields,names,'',"A",'') )
	{
		obj.select()
		obj.focus()
	}
}


function popDynamicValues(){}

async function showLookUpCancel(func_name)
{
// var facility_id = document.forms[0].facilityID.value;
var title="";
	var argumentArray=new Array(8);
	if (func_name=="Modify"){
		title=getLabel("Common.modifiedby.label","common");	
}else{
	 title=getLabel("Common.cancelledby.label","common");
}

 
	//argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER where EFF_STATUS like ? and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_lang_vw where EFF_STATUS like ? and language_id='"+localeName+"'  and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME))";


	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=document.forms[0].user_name.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
	
	var retVal=await CommonLookup(title,argumentArray);
	if (!(retVal == null))
	{
		var ret=unescape(retVal);
		arr=ret.split(",");
		document.forms[0].user_name.value=arr[0];
		document.forms[0].user_hid.value=arr[0];
		document.forms[0].user.value=arr[1];
		document.forms[0].user_name.focus();
		document.forms[0].user.value		= document.forms[0].user_name.value;
	}
	else
	{
		document.forms[0].user_name.value="";
		document.forms[0].user_hid.value= "";
		document.forms[0].user.value="";
		document.forms[0].user_name.focus();
	}
} 



function clearAll_unAsgPat()
{
	parent.result.location.href='../../eCommon/html/blank.html';		
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'
	document.forms[0].search.disabled=false;
}


// Added by Sridhar R on 2/23/2005
async function callLodgerSearch_lodger()
{
	var patient_id	= await	PatientSearch();
	if((patient_id != null))
	{
		document.forms[0].lodger_ref_no.value =	patient_id;
	}
}

function DateCompare_lodger(from,to) 
{
	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);

	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
	
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}

function submitPage_lodger()
{				
	
	var params = "";
	document.forms[0].search.disabled=true;
	/*if(document.getElementById("lodger_ref_no").value != '')
		params+="&lodger_ref_no="+escape(document.getElementById("lodger_ref_no").value);
	if(document.getElementById("from_date").value != '')
		//params+="&from_date="+document.getElementById("from_date").value;
		params+="&from_date="+convertDate(document.getElementById("from_date").value,'DMY',localeName,'en');
	if(document.getElementById("to_date").value != '')
		//params+="&to_date="+document.getElementById("to_date").value;
		params+="&to_date="+convertDate(document.getElementById("to_date").value,'DMY',localeName,'en');
	if(document.getElementById("gender").value != '')
		params+="&gender="+document.getElementById("gender").value;
	if(document.getElementById("attached_patient").checked == true)
		params+="&attached_patient=Y";
	else
		params+="&attached_patient=N";*/

	if(document.forms[0].lodger_ref_no.value != '')
		params+="&lodger_ref_no="+escape(document.forms[0].lodger_ref_no.value);
	if(document.forms[0].from_date.value != '')
		// params+="&from_date="+document.getElementById("from_date").value;
		params+="&from_date="+convertDate(document.forms[0].from_date.value,'DMY',localeName,'en');
	if(document.forms[0].to_date.value != '')
		// params+="&to_date="+document.getElementById("to_date").value;
		params+="&to_date="+convertDate(document.forms[0].to_date.value,'DMY',localeName,'en');
	if(document.forms[0].gender.value != '')
		params+="&gender="+document.forms[0].gender.value;
	if(document.forms[0].attached_patient.value.checked == true)
		params+="&attached_patient=Y";
	else
		params+="&attached_patient=N";
	parent.result.location.href= '../jsp/QueryCurrentLodgersResult.jsp?'+params
	document.forms[0].search.disabled=false;
}

function clearAll_lodger()
{
	parent.result.location.href='../../eCommon/html/blank.html';	
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	document.forms[0].search.disabled=false;
}	

function DateCompare_nshwCancel(from,to,messageFrame) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
		var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);

	if(flg1 && flg2 )
	{

		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
	
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}

function submitPage_nshwCancel()
{
            //Code changes starts by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
            var chk_status = document.getElementById("loc_lang").status; 
       
            if(chk_status==true)	
			{
			document.forms[0].loc_lang.value='th';
			}
           //Code changes ends by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011			
	var condition=""
	var call_function = document.forms[0].call_function.value;
	for(var i=0; i<document.forms[0].elements.length; i++)
			//condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	/*Tuesday, April 19, 2011 , SRR20056-SCF-7177 [IN:027133]*/
			condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
	document.forms[0].search.disabled=true;
	parent.result.location.href= "../jsp/BookingRefNoShowCancelLookupResult.jsp?call_function="+call_function+"&"+condition
	
}

function closeWin_noShowCancel(val)
{
	window.parent.returnValue=val
	window.parent.close()
}

function showModal_noShowCancel(valu)
{
	if(document.forms[0].param.value !='returnval')
	{
	var retVal =    new String();
	var dialogHeight= "29" ;
	var dialogWidth = "43" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal = window.showModalDialog("../jsp/AmendBookingMain.jsp?bookingRefNo="+valu ,arguments,features);
	parent.frames[1].document.location.reload();
	}
	else
	{
	parent.window.returnValue=valu ;
	parent.window.close();
	}
}


function clearAll_turndwnAdmn()
{
	parent.frames[2].location.href = '../../eCommon/html/blank.html';
	document.forms[0].search.disabled=false;
}	

function DateCompare_turndwnAdmn(from,to,messageFrame) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);

	if(flg1 && flg2 )
	{

		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
	
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;

}

	function submitPage_turndwnAdmn()
	{				
		var condition=""

		document.forms[0].search.disabled=true;

		for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
		parent.result.location.href= "../jsp/QueryTurndownAdmissionResult.jsp?"+condition
	}



function closeWin_noShowCancel(val)
{
	window.parent.returnValue=val
	window.parent.close()
}

function showModal_noShowCancel(valu)
{
	if(document.forms[0].param.value !='returnval')
	{
	var retVal =    new String();
	var dialogHeight= "29" ;
	var dialogWidth = "43" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal = window.showModalDialog("../jsp/AmendBookingMain.jsp?bookingRefNo="+valu ,arguments,features);
	parent.frames[1].document.location.reload();
	}
	else
	{
	parent.window.returnValue=valu ;
	parent.window.close();
	}
}

//This function enables disables the date fields (calender) and respective text fields for discharge checklist function.
function enable_date_flds(obj)
{
	if(obj.checked == true)
	{
		obj.value = "Y";
		document.Inpatientlookup_Form.disc_from_date.disabled = false;
		document.Inpatientlookup_Form.disc_to_date.disabled	  = false;
		document.forms[0].disc_cal_gif1.style="";
		document.getElementById("disc_cal_gif2").style="";
		document.forms[0].disc_man_gif1.style.visibility      = "visible";
		document.forms[0].disc_man_gif2.style.visibility      = "visible";
	}
	else
	{
		obj.value = "N";
		document.Inpatientlookup_Form.disc_from_date.value			 = "";
		document.Inpatientlookup_Form.disc_to_date.value			 = "";
		document.Inpatientlookup_Form.disc_from_date.disabled		 = true;
		document.Inpatientlookup_Form.disc_to_date.disabled			 = true;
		document.getElementById("disc_cal_gif1").style="pointer-events: none;";
		document.getElementById("disc_cal_gif2").style="pointer-events: none;";
		document.Inpatientlookup_Form.disc_man_gif1.style.visibility = "hidden";
		document.Inpatientlookup_Form.disc_man_gif2.style.visibility = "hidden";
	}
}

function compareDisDates2(Obj)
{
	
	if(validDateObj(Obj,"DMY",localeName))
	{

		var from = document.forms[0].disc_from_date;
		var to = document.forms[0].disc_to_date;
		
		if(from.value !='' && to.value !='')// DateUtils.js
		{
			var fromDt	= convertDate(from.value,"DMY",localeName,"en");
			var toDt	= convertDate(to.value,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].disc_to_date.value="";
				document.forms[0].disc_to_date.select();
				document.forms[0].disc_to_date.focus();
			}
		}
	}
	else
	{
		Obj.value='';
		return false;
	}
		
	
}

function allowValidNumber_local(fld, e, maxInt, deci)
{
    var count=fld.value.length;
    var whichCode = (window.Event) ? e.which : e.keyCode;

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }

	// you donot require this just var strCheck = '.0123456789' for deci > 0
	var strCheck = '0123456789';

    if (parseInt(deci)==0)// For Only Nos 0 - 9
        strCheck = '0123456789';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function beforeGetService(getFacilitID,obj)
{
	if(obj.value != "")
			getService(getFacilitID,obj)
	else
	{
		document.getElementById("admission_service").value = "";
		document.getElementById("servicecode").value = "";
		document.getElementById("service_desc_hidn").value = "";
	}
	
}

async function getService(getFacilitID,aCode)
{	
	var facility_id		= getFacilitID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var locale			= document.forms[0].locale.value;
	var sql				= "";
	var tit				= "";
	
		sql = " Select SERVICE_CODE code,short_desc description from AM_SERVICE_LANG_VW where eff_status like 'E' and upper(SERVICE_CODE) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+localeName+"' ";
		tit = getLabel("Common.service.label","Common");
	
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1, 2";
		argumentArray[5] = aCode.value;
		argumentArray[6] = CODE_DESC_LINK;
		argumentArray[7] = CODE_DESC;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.getElementById("servicecode").value=arr[0];
			document.getElementById("service_desc_hidn").value=arr[1];
			document.getElementById("admission_service").value=arr[1];
		}		
} 

async function beforeGetTransferedBy()
{
	if(document.forms[0].user.value != document.forms[0].user_name.value)
	{
		if(document.forms[0].user_name.value != "")
			await showLookUpTransfer();
		else
		{
			document.forms[0].user_hid.value="";
			document.forms[0].user.value = "";
		}
	}
}
async function showLookUpTransfer()
{
	var title="";
	var argumentArray=new Array(8);
	 title=getLabel("Common.TransferredBy.label","common");



	argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_lang_vw where EFF_STATUS like ? and language_id='"+localeName+"'  and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME))";


	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=document.forms[0].user_name.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
	
	var retVal=await CommonLookup(title,argumentArray);
	if (!(retVal == null))
	{
		var ret=unescape(retVal);
		arr=ret.split(",");
		document.forms[0].user_name.value=arr[0];
		document.forms[0].user_hid.value=arr[0];
		document.forms[0].user.value=arr[1];
		document.forms[0].user_name.focus();
		document.forms[0].user.value		= document.forms[0].user_name.value;
	}
	else
	{
		document.forms[0].user_name.value="";
		document.forms[0].user_hid.value= "";
		document.forms[0].user.value="";
		document.forms[0].user_name.focus();
	}
}
/*Friday, October 01, 2010 , referral source in Active Booking changed to lookup since AM_REFERRAL has huge data and screen taking time to load*/
async function beforereferralSourceLookup(obj,getFacilitID)
{
	if(document.forms[0].referral_source.value=="")
	{
		document.forms[0].referral_source1.value="";
		document.forms[0].referral_source_hid.value = "";
	}
	if(document.forms[0].referral_source_hid.value != document.forms[0].referral_source.value)
	{
		if(document.forms[0].referral_source.value != "")
			await referralSourceLookup(obj,getFacilitID);
		else
		
			document.forms[0].referral_source1.value="";
	}
}
async function referralSourceLookup(obj, getFacilitID)
{

	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].referral_source;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var ref_type = document.forms[0].ref_type.value;
	var locale = document.forms[0].locale.value;

	if(ref_type.value == 'E')
	{	
		sql=" Select facility_id code,sm_get_desc.sm_facility_param(facility_id ,'"+locale+"',1) description  from sm_facility_param Where STATUS = 'E' and facility_id !='"+facility_id+"' and upper(facility_id) like upper(?) and  upper(facility_name) like upper(?) ";
	}else
	{
		sql=" Select referral_Code code,am_get_desc.am_referral(referral_Code,'"+locale+"',2)description  from am_referral Where eff_status = 'E' and upper(referral_Code) like upper(?) and  upper(short_Desc) like upper(?) ";
	}
	
	tit=getLabel("Common.referralsource.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
			document.forms[0].referral_source1.value=arr[0];
			document.forms[0].referral_source.value=arr[1];
	}
	else
	{
		
			document.forms[0].referral_source.value = "";
			document.forms[0].referral_source1.value = "";
		
	}
}
// Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115
function removeToSearch(){
	// to equal the from and to search
		document.forms[0].to_nursing_unit.value=document.forms[0].fr_nursing_unit.value;
	}

