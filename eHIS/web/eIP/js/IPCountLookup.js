function BeforeGetNursingUnit(obj1,obj2,obj3)
{
	
	
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnitValue(obj1,obj2,obj3);
		else
			document.forms[0].nursing_unit.value = "";
	
}
function BeforeGetSpecialtyValue(obj1,obj2,obj3)
{
	if(obj3 == 'from')
	{
		if(document.forms[0].from_specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].from_Splcode.value = "";
	}
	else
	{
		if(document.forms[0].specialty_desc.value != "")
			getSpecialtyValue(obj1,obj2,obj3);
		else
			document.forms[0].Splcode.value = "";
	}
 }

async function getNursingUnitValue(aNursingUnit, getFacilitID, details)
{	
	var msg					= "";
	var nursingUnitCode		= aNursingUnit.value;
	var facility_id			= getFacilitID;
	var loginUser			= document.forms[0].loginUser.value;
	var operstn				= document.forms[0].operstn.value;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var wherecondn			= document.forms[0].wherecondn.value;
	var retVal				= new String();
	var call_function		= document.forms[0].call_function.value;
	
	var tit					= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight		= "600px" ;
	var dialogWidth			= "1000px" ;
	var status				= "no";
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "";
	if(call_function == 'TransferPatientOut'  || call_function == 'CancelTransferPatientOut')
	{
		if(details == 'from')
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
		}
		else
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=Y";
		}
	}
	else
	{ 
		if(details == 'from')
		{  
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=Y";
		}
		else
		{ 
			
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);
		}

	}


	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	var arr=new Array();
	
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");

		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value=arr[0];
			document.forms[0].from_nursing_unit_desc.value=arr[1];
		}
		else
		{
			document.forms[0].nursing_unit.value=arr[0];
			document.forms[0].nursing_unit_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_nursing_unit.value		="";
			document.forms[0].from_nursing_unit_desc.value	="";
		}
		else
		{
			document.forms[0].nursing_unit.value		="";
			document.forms[0].nursing_unit_desc.value	="";
		}
	 }
}
async function getSpecialtyValue(aSpecialty, getFacilitID, details)
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
		
		if(details == "from")
		{
			document.forms[0].from_Splcode.value=arr[0];
			document.forms[0].from_specialty_desc.value=arr[1];
		}
		else
		{
			document.forms[0].Splcode.value=arr[0];
			document.forms[0].specialty_desc.value=arr[1];
		}
	}
	else
	{
		if(details == "from")
		{
			document.forms[0].from_specialty_desc.value = "";
			document.forms[0].from_Splcode.value = "";
		}
		else
		{
			document.forms[0].specialty_desc.value = "";
			document.forms[0].Splcode.value = "";
		}
	}
 }

function compareDates()
{
	var from = document.forms[0].from_date;
	var to = document.forms[0].to_date;
	
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{
			var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
			var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.value = "";
				document.forms[0].to_date.select();
			}
		}
	}
 }
 
 /*Below line modified by Venkatesh.S on 04/FEB/2012 against KDAH-CRF-0191(32447) */
  function patientDetails(patient_catogory,counts)
 {
  
 
  var Nursing_unit_code =document.forms[0].Nursing_unit_code.value;
  var facilityid        =document.forms[0].facilityid.value;
  var Speciality_code   =document.forms[0].Speciality_code.value;
  var From_date         =document.forms[0].From_date.value;
  var To_date           =document.forms[0].To_date.value;
  var Practitioner_id   =document.forms[0].Practitioner_id.value;
  var title =document.forms[0].title.value
  	
	
	var Height		    = "500px" ;
	var Width			= "1000px" ;
	var status		    = "no";
	var features		= "dialogHeight:" + Height + "; dialogWidth:" + Width +"; scroll=yes; status:" + status ;
	var arguments		= "" ;
	
 
 
 if(counts !=0) 
  {
 jsp_name = "../../eIP/jsp/IPPatientDtlFrame.jsp?Nursing_unit_code="+Nursing_unit_code+"&facilityid="+facilityid+"&Speciality_code="+Speciality_code+"&From_date="+From_date+"&To_date="+To_date+"&Practitioner_id="+Practitioner_id+"&patient_catogory="+patient_catogory+"&title="+title+"  ";
 
 //parent.frames[1].location.href=jsp_name;
 
 window.showModalDialog(jsp_name,arguments,features);
  
  }
  
 }
/*end KDAH-CRF-0191(32447)*/
 

