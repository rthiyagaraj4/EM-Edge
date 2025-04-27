function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	if(document.forms[0].nursing_unit_desc.value != "")
		 getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
}
function beforeGetSpecialty(aSpecialtID, Facility_ID)
{
	
	//if(document.forms[0].specialty_desc.value != "")
		//getSpecialty(aSpecialtID, Facility_ID)
	if(document.forms[0].specialty_desc.value != "")
		getSpecialtyValue(aSpecialtID, Facility_ID);
}
function beforeGetPractitioner(obj,target, aFacilityID)
{
	if(target.value != "")
		getPractitionerLocal(obj,target, aFacilityID);

}

async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnitCode = aNursingUnit.value;
	var Facility_ID	= aFacilityId;
	var Login_User	= aLoginUser;
	var	Operator_Station_ID	= pOperStnID;
	var retVal =    new String();
	var wherecondn      = document.forms[0].wherecondn.value;
	if (wherecondn.length>0)
	{
	var call_function =document.forms[0].call_function.value;
	var splty_code=document.forms[0].Splcode.value;
	var pract_id="";
	var tit			= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight        = "400px" ;
    var dialogWidth         = "950px"; 
	/*var dialogHeight		= "28" ;
	var dialogWidth			= "43" ;*/
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();
	}
	/*var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);*/
	//&splty_cd="+splty_code+"

	jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&open_location_yn=Y";

	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
		
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");
		
		document.forms[0].nursing_unit.value		=	arr[0];
		//document.forms[0].nursing_unit_desc.value	=	arr[1];
		document.forms[0].nursing_unit_desc.value	=	unescape(arr[1]);
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	}
	else
	{
		document.forms[0].nursing_unit_desc.value='';
		document.forms[0].nursing_unit.value='';
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	}
}


function compareDates(Obj)
{
	//if(validDateObj(Obj,'DEFAULT_FORMAT',localeName))
	if(validDateObj(Obj,'DMY',localeName))
	{
		if(document.forms[0].from_date.value!='' && document.forms[0].to_date.value!='')
		{
			//var greg_FromDate = convertDate(document.forms[0].from_date.value,'DEFAULT_FORMAT',localeName,'en');
			//var greg_ToDate = convertDate(document.forms[0].to_date.value,'DEFAULT_FORMAT',localeName,'en');
			var greg_FromDate = convertDate(document.forms[0].from_date.value,'DMY',localeName,'en');
			var greg_ToDate = convertDate(document.forms[0].to_date.value,'DMY',localeName,'en');
		
			//if(isAfter(greg_FromDate,greg_ToDate,'DEFAULT_FORMAT','en'))
			if(isAfter(greg_FromDate,greg_ToDate,'DMY','en'))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.focus();
				document.forms[0].to_date.select();
				return false;
			}
		}
	}
	else
		return false;
	
}

async function getSpecialty(getFacilitID)
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
		document.forms[0].specialty_desc.value = document.forms[0].specialty_desc.value;
	}
	else
	{
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	}
}


function getPractitionerLocal(obj,target, aFacilityID)
{
	//alert(obj)	
	//alert(target)
	var practName_FName="";
	
	var practName_FValue="";

	var practId_FName="";
		
	practName_FName=target.name;
	//alert(practName_FName)
	//alert(target.name);
	practName_FValue=target.value;
	//alert(practName_FValue)
	//practId_FName=document.forms[0].practid.name;
	//alert("1"+document.forms[0].practid.name)

	practId_FName=parent.frames[1].document.forms[0].practid_from.name;
	//alert("1"+parent.frames[1].document.forms[0].practid.name)
	var locale = document.forms[0].locale.value;
	var spl_code= parent.frames[1].document.forms[0].Splcode.value;
	//alert("1"+locale)
	//var nursing_unit_code	= document.forms[0].nursing_unit.value;
	//alert("2"+document.forms[0].nursing_unit.value)
	var facility_id = aFacilityID;
	//alert(aFacilityID)
	//alert("12");
	/*if(spl_code != "")
	{
		
		getPractitioner(obj, target, facility_id,spl_code,"Q5");
	}
	else
	{*/
	if(target.name=="practid_desc_from")
	{
	getPractitioner(obj, target, facility_id, "","Q3");
	}
	else
		if(target.name=="practid_desc_to")
			{
			if(spl_code != "")
				/*
				// this if condition is for checking whether specility is selected . if speciality is selected then 
					the specilty is disabled in transfering practitioner.//
				*/
				{
				getPractitioner(obj, target, facility_id,spl_code,"Q5");
				}
			else if (practId_FName != "")
			{
				getPractitioner(obj, target, facility_id,"","Q5");
				
			}
			
			else
			getPractitioner(obj, target, facility_id,"","Q5");
			} 
	
}
function getAttendingPractitionerLocal(obj,target, aFacilityID)
{
	//checkForValues();
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;
	
	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	
	var facility_id = aFacilityID;
	
	//getPractitioner(obj, target, facility_id,"Q5");//, "",nursing_unit_code,"Q3");

	var spl_code			= document.forms[0].speciality_code.value;
	
	/*if(nursing_unit_code != "")
	{locale=document.forms[0].locale.value;*/
		if(spl_code != "")
		{
			var facility_id = aFacilityID;
			getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
			/*
	"
			var sql= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

			var sql2= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	= "<root><SEARCH " ;
			xmlStr += " practName_FName=\"" +practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " practId_FName=\"" + practId_FName + "\"";
			xmlStr += " sql=\"" +escape(sql)+ "\"";
			xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + spl_code+ "\"";
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
		}
		else
		{
			var error = parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("Common.speciality.label","Common"));
			alert(error);	
		}
	/*}
	else
	{
		var error = parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
		alert(error);	
	}*/

}
function compareDates(Obj)
{
	//if(validDateObj(Obj,'DEFAULT_FORMAT',localeName))
	if(validDateObj(Obj,'DMY',localeName))
	{
		if(document.forms[0].from_date.value!='' && document.forms[0].to_date.value!='')
		{
			//var greg_FromDate = convertDate(document.forms[0].from_date.value,'DEFAULT_FORMAT',localeName,'en');
			//var greg_ToDate = convertDate(document.forms[0].to_date.value,'DEFAULT_FORMAT',localeName,'en');
			var greg_FromDate = convertDate(document.forms[0].from_date.value,'DMY',localeName,'en');
			var greg_ToDate = convertDate(document.forms[0].to_date.value,'DMY',localeName,'en');
		
			//if(isAfter(greg_FromDate,greg_ToDate,'DEFAULT_FORMAT','en'))
			if(!isBefore(greg_FromDate,greg_ToDate,'DMY','en'))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.focus();
				document.forms[0].to_date.select();
				return false;
			}
		}
	}
	else
		return false;
	/*if(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		document.forms[0].to_date.focus();
		document.forms[0].to_date.select();
	}*/
}

function clearAll()
{
	document.forms[0].from_date.value="";
	document.forms[0].to_date.value="";
	document.forms[0].specialty_desc.value="";
	document.forms[0].Splcode.value="";

					
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
		
	//parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
			
	if(parent.messageFrame)
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	document.forms[0].search.disabled=false;
	
}

function cancel()
{
	//window.parent.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
}

function PractLookupRetVal(retVal,objName)
{
	
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName=="practid_desc_from"){
		document.forms[0].practid_from.value=arr[0];
		document.forms[0].practid_desc_from.value=arr[1];
		}else if(objName=="practid_desc_to"){
		document.forms[0].practid_to.value=arr[0];
		document.forms[0].practid_desc_to.value=arr[1];
		}
		
	}
	else
	{
		if(objName=="practid_desc_from"){
		document.forms[0].practid_from.value="";
		document.forms[0].practid_desc_from.value="";			
		document.forms[0].practid_desc_from.focus();
		}else if(objName=="practid_desc_to"){
		document.forms[0].practid_to.value="";
		document.forms[0].practid_desc_to.value="";			
		document.forms[0].practid_desc_to.focus();
		}
		
	}
}
async function closeWin(enc,patid,changefunc)
{
	await showModalCurEnc(enc,patid,changefunc);
}
async function showModalCurEnc(enc,patid,changefunc)
{
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "800px";
	var dialogWidth	= "1400px";
	var dialogTop = "65" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}
function checkForValues()
{
	if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		alert(getMessage('SPLTY_NOTNULL','IP'));
		document.forms[0].Splcode_desc.focus();
	}
}
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].target = "f_query_add_mod1"
	document.forms[0].submit();
}


function getPractitionerLocal(obj,target, aFacilityID)
{
	
	
	
	var locale = document.forms[0].locale.value;
	var facility_id = aFacilityID;
	getPractitioner(obj, target, facility_id,"","","Q3");	
}


function Transfer()
{

	
	var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	
	document.forms[0].transfer.disabled=true;

	var practid=parent.frames[3].document.forms[0].practid.name;
	var	transfer_type = parent.frames[3].document.forms[0].transfer_type.name;
	
	if( practid == null && transfer_type == null)
	{
		
	}
	
}

function apply()
	{
		var chk=false;

			if(parent.frames[2].frames[2].document.BulkTransferPractitionerResult!=null){
			var vselect=parseInt(parent.frames[2].frames[2].document.BulkTransferPractitionerResult.counter.value);
			for(var i=0;i<vselect;i++){
				var val1="parent.frames[2].frames[2].document.BulkTransferPractitionerResult.Check"+i;			 
				if(eval(val1).value=="Y")
					chk=true;
			}
			if(chk){
				parent.frames[2].frames[2].document.BulkTransferPractitionerResult.submit();
			}else{
					alert(getMessage("ATLEAST_ONE_RECORD_ENTERED","Common"));
					parent.frames[2].frames[0].location.reload();
			}
			}else{
			parent.frames[2].frames[0].location.reload();
			}
		
	}

	function getchkvalues(obj){
		if(obj.checked==true){
			obj.value='Y'
		}else{
			obj.value='N'
		}
	}


	function onSuccess() 
 {

 }


 async function getSpecialtyValue(aSpecialty, getFacilitID)
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


async function getSpecialty(getFacilitID)
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
		
	}
	else
	{
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	}
}

 
