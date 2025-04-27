//=========== Function copied from SwapPatientBeds.jsp ====================
function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();
	
	if (frames[1].document.forms[0].searchby != null)
	{
	
		frames[1].document.forms[0].searchby.value="";
		frames[1].document.forms[0].searchby.disabled=true;
	}
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;
}
//=========== Function copied from SwapPatientBeds.jsp ***** END====================
//=========== Function copied from SwapPatientBedButtons.jsp ====================
var encounter_id1="";
var encounter_id2="";
	
async function showModal()
{	
	var where_criteria=parent.frames[2].document.forms[0].whereclause.value;
	var retVal = 	new String();
	var dialogHeight= "700px" ;
	var dialogWidth = "1200px" ;
	var dialogTop 	= "70";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eIP/jsp/SwapPatientBedsFrames.jsp?where_criteria="+where_criteria+"&encounter_id1="+encounter_id1+"&encounter_id2="+encounter_id2,arguments,features);

	return retVal;	
}

function Add()
{	

	 encounter_id1= parent.frames[2].document.forms[0].e1.value;
	 encounter_id2= parent.frames[2].document.forms[0].e2.value;

	if(encounter_id1=="" ||encounter_id2=="")
	{
		alert(getMessage('SWAP_ATLEAST_TWO_REC','IP'));//"Atleast Two Rows Should Be Selected For Swapping");
		return;
	}

	var ret=showModal();
	if(ret==null || ret=='')
	{
		parent.frames[1].submitPage();
		
	}
}

function formSubmit()
{
	if(document.forms[0].swap_contact_reason.value!="")
	 {
			document.forms[0].Swap.disabled = true;
			//Changes for the CRF - HSA-CRF-0035 -- Start
			var proceed1 = 'true';
			var proceed2 = 'true';
			var mother_status1 = document.forms[0].mother_status1.value;
			var mother_status2 = document.forms[0].mother_status2.value;
			var transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035
			if ((mother_status1 != '0' && mother_status2!='0' ) && transfer_wo_delink_yn=='Y') {								
				proceed1=validateMotherBabyBed(document.forms[0].nursing_unit_code2.value,document.forms[0].bed_no2.value,document.forms[0].patient_id1.value)
				proceed2=validateMotherBabyBed(document.forms[0].nursing_unit_code1.value,document.forms[0].bed_no1.value,document.forms[0].patient_id2.value)
			}else if(mother_status1 != '0' && transfer_wo_delink_yn=='Y'){
				proceed1=validateMotherBabyBed(document.forms[0].nursing_unit_code2.value,document.forms[0].bed_no2.value,document.forms[0].patient_id1.value)
			}else if(mother_status2 != '0' && transfer_wo_delink_yn=='Y'){
				proceed2=validateMotherBabyBed(document.forms[0].nursing_unit_code1.value,document.forms[0].bed_no1.value,document.forms[0].patient_id2.value)
			}
			if(proceed1!='true' || proceed2!='true'){
				if(confirm(getMessage("TRANSFER_NOT_POSSIBLE","IP"))){
					document.forms[0].transfer_wo_delink_yn.value='N';
					proceed1='true';
					proceed2='true';
				}
			}
			//Changes for the CRF - HSA-CRF-0035 -- End
			if(proceed1=='true' && proceed2=='true'){
				var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post'  action='../../servlet/eIP.SwapPatientBedServlet' target='Dummy_frame'>";
				for(var i=0;i<document.forms[0].elements.length;i++)
				{
				   val += "<input type='hidden' name=\""+document.forms[0].elements[i].name +"\" value=\""+document.forms[0].elements[i].value +"\">";
				}
				val += "</form></body><html>";
				document.forms[0].Swap.disabled = true;
				//Modified against HSA-SCF-0137 - submiting dummy_frame 
				parent.frames[1].document.write(val); 
				parent.frames[1].document.Dummy_form.submit();
			}else{				
					//document.forms[0].Swap.disabled = false;
				//window.close();
				parent.parent.document.getElementById("dialog_tag").close();
			}
			//Changes for the CRF - HSA-CRF - 0035 - End
			//parent.frames[0].document.Dummy_form.submit();
	   }
	else
	{
		alert(getMessage('REASON_SWAP_NOT_BLANK','IP'));
	}
}
//=========== Function copied from SwapPatientBedDetails.jsp ***** END====================
//=========== Function copied from SwapPatientBedsCriteria.jsp ====================
// Function will check for empty values before calling up the common lookup func..  
		
function beforeGetSpecialty(aSpecialtID, Facility_ID)
{
	if(document.forms[0].specialty_desc.value != "")
		getSpecialty(aSpecialtID, Facility_ID)
	else
	{
		document.forms[0].specialty_desc.value = ""
		document.forms[0].Splcode.value = ""
	}
}

function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	if(document.forms[0].nursing_unit_desc.value != "")
		 getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
	else
	{
		document.forms[0].nursing_unit_desc.value = ""
		document.forms[0].nursing_unit.value = ""
	}
}

function beforeGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].practid_desc.value != "")
		getPractitionerLocal(obj,target, aFacilityID);
	else
	{
		document.forms[0].practid_desc.value = ""
		document.forms[0].practid.value = ""
	}
}


var flag = 0;
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
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();
	}
	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&splty_cd="+splty_code+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode);

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
			//if(isAfter(greg_FromDate,greg_ToDate,'DMY','en'))
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
function focusto_date()
{
	document.forms[0].to_date.focus();

}
function focusfrom_date()
{
	document.forms[0].from_date.focus();

}


function enableDisableDays(Obj)
{
	if(Obj.checked)
		document.forms[0].no_of_days.readOnly = false;
	else
	{
		document.forms[0].no_of_days.value = "";
		document.forms[0].no_of_days.readOnly = true;
	}
}


function DateCompare(from,to,messageFrame,getVal) 
{
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			if(messageFrame.name =="f_query_add_mod1")
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			else
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","SM");
			to.focus();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}
	return true;
}
           
function clearAll()
{
	document.forms[0].from_date.value="";
	document.forms[0].to_date.value="";
	document.forms[0].specialty_desc.value="";
	document.forms[0].Splcode.value="";

					
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
			
	if(parent.messageFrame)
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	document.forms[0].search.disabled=false;
	
}

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.encounterid.label","Common");
	if(SpecialCharCheck( fields, names,'',"A",''))
			return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function checkForNursingUnit()
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		var errors = '';
		errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
		errors = errors.replace('$',getLabel("Common.nursingUnit.label","Common"));
        alert(errors);	 
		document.forms[0].nursing_unit_desc.focus();
	}

}

async function getSpecialty(aSpecialtyID, Facility_ID)
{
 	checkForNursingUnit();
	var target			= document.forms[0].specialty_desc;
	var code			= document.forms[0].nursing_unit.value;
	var locale			= document.forms[0].locale.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	sql	=	" select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW a, IP_NURS_UNIT_FOR_SPECIALTY b where a.language_id = '"+localeName+"' and eff_status = 'E' and a.speciality_code = b.specialty_code and  b.facility_id = '"+FacilityID+"' and b.nursing_unit_code = '"+code+"' and upper(a.Speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	/*Wednesday, June 02, 2010 , modified for PE*/
	//sql	=	" select a.speciality_code code, am_get_desc.am_speciality(a.speciality_code,'"+locale+"',2) description from AM_SPECIALITY a, IP_NURS_UNIT_FOR_SPECIALTY b where a.eff_status = 'E' and a.speciality_code = b.specialty_code and  b.facility_id = '"+FacilityID+"' and b.nursing_unit_code = '"+code+"' and upper(a.Speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	
	tit=getLabel("Common.speciality.label","Common"); 
		
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3";
	argumentArray[5] = aSpecialtyID.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
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
		document.forms[0].specialty_desc.value="";
		document.forms[0].Splcode.value="";
	} 
} // End of getSpecialty().

// To get the Pratitioner using GeneralPratitionerSearch.
function getPractitionerLocal(obj,target, aFacilityID)
{
	checkForNursingUnit()
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;
	var locale = document.forms[0].locale.value;

	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	var facility_id = aFacilityID;

	getPractitioner(obj, target, facility_id, "",nursing_unit_code,"Q6");


	/*
	
	var sql = "Select a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title  from am_practitioner a, ip_nursing_unit_For_pract b where a.practitioner_id = b.practitioner_id and  facility_id = '"+facility_id+"' and b.nursing_unit_code='"+nursing_unit_code+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name)) ) AND  a.gender LIKE (?) AND (a.POSITION_CODE LIKE (?) OR a.POSITION_CODE IS NULL)";

	var sql2 = "Select a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(a.primary_speciality_code,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title  from am_practitioner a, ip_nursing_unit_For_pract b where a.practitioner_id = b.practitioner_id and  facility_id = '"+facility_id+"' and b.nursing_unit_code='"+nursing_unit_code+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name)) ) AND  a.gender LIKE (?) AND (a.POSITION_CODE LIKE (?) OR a.POSITION_CODE IS NULL)";	

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
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

} // End of getPractitioner();

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].practid_desc.value="";			
		document.forms[0].practid_desc.focus();
	}
} // End of PractLookupRetVal().

async function getPractID()
{
	var fields=new Array();
	fields[0]= document.forms[0].nursing_unit_desc;
	var names = new Array (	getLabel("Common.nursingUnit.label","Common")); 

	if(checkFields( fields, names, parent.messageFrame))
	{

		var facility_id="";
		var msg="";

		facility_id				="`"+document.forms[0].hid_facility_ID.value+"`";
		var nursing_unit_code	="`"+document.forms[0].nursing_unit.value+"`";	

		var target				= document.forms[0].practid_desc;
		var retVal				=    new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql="";
		var search_desc="";
		var tit="";

		sql = "Select a.practitioner_id,a.practitioner_name from am_practitioner a,ip_nursing_unit_For_pract b  where a.practitioner_id = b.practitioner_id and  facility_id="+facility_id+"and b.nursing_unit_code="+nursing_unit_code+ " ";

		search_code="practitioner_id";
		search_desc="practitioner_name";
		tit=getLabel("Common.practitioner.label","Common"); 
			retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if (!(retVal == null))
		{
			if(!(unescape(retVal) == null))
			{
				var arr = unescape(retVal).split("::");
				document.forms[0].practid_desc.value=arr[0];
				document.forms[0].practid.value=arr[1];
				document.forms[0].practid_desc.focus();
			}
		}
		else
		{
				document.forms[0].practid_desc.value="";
				document.forms[0].practid.value="";
				document.forms[0].practid_desc.focus();
		}

	}

}

function dateFromTo(Obj)
{
	var dateTo=Obj;
	var dateFrom=document.Inpatientlookup_Form.from_date;
			
	if(!doDateCheckAlert(dateFrom,dateTo))
		alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
}
//=========== Function copied from SwapPatientBedsCriteria.jsp ***** END====================
//=========== Function copied from SwapPatientBedsResults.jsp ====================
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].target = "f_query_add_mod1"
	document.forms[0].submit();
}
function closeWin(enc,patid,changefunc)
{
	showModalCurEnc(enc,patid,changefunc);
}
async function showModalCurEnc(enc,patid,changefunc)
{
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "700px";
	var dialogWidth	= "1200px";
	var dialogTop = "65" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}
function checkNoSelect(obj,recSelect,unFinalizedNewBornCnt)
{	
	
	var allowBedSwap_YN = eval("document.forms[0].allow_bed_swap_yn"+recSelect+".value");
	if(allowBedSwap_YN=="Y")
	{
		if (obj.checked==false)
		{
			if (obj.value==document.forms[0].e2.value )
			{
				document.forms[0].e2.value='';
			}
			else
			{
				document.forms[0].e1.value='';
			}
			obj.checked=false;
		}
		if (document.forms[0].e1.value == '' || document.forms[0].e2.value == '')
		{
			if (obj.checked==true)
			{
				if (document.forms[0].e1.value == '')
					document.forms[0].e1.value=obj.value;
				else
					document.forms[0].e2.value=obj.value;
			}
		}
		else
		{
			alert(getMessage("SWAP_ONLY_TWO_REC","IP"));//"At Most Two Rows Can Be Selected For Swaping");
			obj.checked=false;
		}
	}
	else
	{
		alert(getMessage("SWAP_NOT_ALLOWED","IP"));//"Bed Swapping For The Patient Is Not Allowed");
		obj.checked=false;
	}

	/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
	if(obj.checked==true && unFinalizedNewBornCnt > 0){
		alert(getMessage('UNFINALIZED_NEW_BORN_EXISTS',"IP"));
		obj.checked = false;
		if (obj.value==document.forms[0].e2.value )
			document.forms[0].e2.value='';
		else
			document.forms[0].e1.value='';
		return;
	}
	/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/

}//function ends
function validateCheck()
{
	var val = document.forms[0].maxRecord.value;
	if(document.forms[0].e1 && document.forms[0].e2)
	{
		for(c =0;c<=parseInt(val);c++)
		{
			if(eval('document.forms[0].Check'+c))
			{
				if(eval('document.forms[0].Check'+c).value == document.forms[0].e1.value || eval('document.forms[0].Check'+c).value == document.forms[0].e2.value)
				{
					eval('document.forms[0].Check'+c).checked = true;
				}
			}
		}
	}
}
//=========== Function copied from SwapPatientBedsResults.jsp **** END====================
/*Below Method Modified for this SCF ML-BRU-SCF-0230 [IN:033143] */
function checkbabyLink()
{
	var mother_status1 = document.forms[0].mother_status1.value;
	var mother_status2 = document.forms[0].mother_status2.value;
	var transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;
	
	
	var bed_class1=document.forms[0].bed_class_code1.value;
	var bed_class2=document.forms[0].bed_class_code2.value;
	var bed_type1=document.forms[0].bed_type_code1.value;
	var bed_type2=document.forms[0].bed_type_code2.value;
    var bed_chnage_yn=document.forms[0].ip_param_bedchange_yn.value;	

	
	if(bed_class1 != bed_class2 && bed_chnage_yn == 'Y' || bed_type1 != bed_type2 && bed_chnage_yn == 'Y')
	{
		alert(getMessage('CANNOT_SWAP_BEDS','IP'));
		parent.window.close();
	}else{	
		if(mother_status2 != '0' && mother_status1 != '0')
		{
			if(transfer_wo_delink_yn=='N'){
				if(confirm(getMessage('DELINK_BABY_YN','IP'))) 
				{
					 document.forms[0].mother_bed_status1.value='Y';
					 document.forms[0].mother_bed_status2.value='Y';
					 return true; 
				}
				else 
				{
					 document.forms[0].mother_bed_status1.value='N';
					 document.forms[0].mother_bed_status2.value='N';
					 window.close(); 
				}
			}else{
				 document.forms[0].mother_bed_status1.value='Y';
				 document.forms[0].mother_bed_status2.value='Y';
				 return true; 
			}
		}
		else if (mother_status2 != '0')
		{	
			if(transfer_wo_delink_yn=='N'){ 
				if(confirm(getMessage('DELINK_BABY_YN','IP'))) 
				{
					 document.forms[0].mother_bed_status2.value='Y';
					 return true; 
				}
				else 
				{
					 document.forms[0].mother_bed_status2.value='N';
					 window.close(); 
				}
			}else{
				 document.forms[0].mother_bed_status2.value='Y';
				 return true; 
			}
		}else if (mother_status1 != '0')
		{
			if(transfer_wo_delink_yn=='N'){ 
	         if(confirm(getMessage('DELINK_BABY_YN','IP')))   		
			{
				 document.forms[0].mother_bed_status1.value='Y';
				 return true; 
			}
			else 
			{
				 document.forms[0].mother_bed_status1.value='N';
				 window.close(); 
			}
			}else{
				 document.forms[0].mother_bed_status1.value='Y';
				 return true;
			}				
		}
	}	
}
function validateMotherBabyBed(nursing_unit,bed_no,patId){

	var xmlStr ="<root><SEARCH step='Delink' ";
	xmlStr +=" /></root>";
	 
	var param="&frnursingunitcode="+nursing_unit+"&tonursingunitcode="+nursing_unit+"&to_bed_no="+bed_no+"&patient_id="+patId;
	
	var temp_jsp="../../eIP/jsp/BookingGetExpDaysDate.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	//responseText= trimString(responseText);
	return responseText;
	
}

