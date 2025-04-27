// Created to generalise Practitioner LookUP by Marimuthu on 23/04/2007
function closeWin2(enc,patid,changefunc)
{
	showModalCurEnc2(enc,patid,changefunc);
}
async function showModalCurEnc2(enc,patid,changefunc)
{   

	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function.value;
	var jsp_name="MRCurrentEncounterMain2.jsp";


	var retVal = 	new String();

	var dialogHeight= "98vh"; //41
	var dialogWidth = "95vw"; //65
	//var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status; // + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}
function closeWin1(enc,patid,changefunc)
{
	showModalCurEnc1(enc,patid,changefunc);
}
async function showModalCurEnc1(enc,patid,changefunc)
{ 

	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function.value;
	var jsp_name="MRCurrentEncounterMain.jsp";
/*
	var win_height=document.forms[0].win_height.value;
	if(win_height == "") win_height="33.4";
	var win_width=document.forms[0].win_width.value;
	if(win_width == "") win_width="49.8";
	*/
	//if(changefunc == "Y")
		//call_function = "QueryDischarge";

	var retVal = 	new String();

	var dialogHeight= "90vh";
	var dialogWidth = "85vw";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + ";" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}
function getPractitioner1(obj,target,fac_Id,splty,pract_type,clinic_code,trtmt_area_code,callfunc,res_type,visitadmtype,executeQuery) 
{



	var firstSql		  = "";
	var secondSql		  = "";
	var practitionerName  = "";
	var practitionerValue = "";
	var speciality		  = "";	
	var practitioner_type = "";	
	
	target.value = trimString(target.value);	
	practitionerName = target.name;
	practitionerValue = target.value;
	speciality = '';
	practitioner_type = pract_type;
	
	/* Added by Dharma on June 28th 2016 Start*/
	var showPractAvailDetails	= "N";
	if(document.forms[0].showPractAvailDetails){
		showPractAvailDetails	= document.forms[0].showPractAvailDetails.value; 
	}
	/* Added by Dharma on June 28th 2016 End*/


	
	if(executeQuery == "Q2")
	{
			
		/*

			FileName 		:      PatCheckout.js
			                       VisitRegistration1.js
								   repOPVisitStatByPract.js
			Function Name 	:      OP Transactions -> Mangage Patient Queue && Check Out
			                       OP Transactions -> Register Visit
								   OP Reports -> General Statistics -> Visit Statistics By Practitioner
			Used in all Reports

		*/
		
	
		 firstSql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+fac_Id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(practitioner_type!="")
		{
			firstSql=firstSql+"	a.pract_type='"+practitioner_type+"' AND ";
		}

		//firstSql = firstSql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

		firstSql = firstSql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
		
		

		secondSql="SELECT  DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender,  am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty   FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+fac_Id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND ";

		if(practitioner_type!="")	
		{
			secondSql=secondSql+" a.pract_type='"+practitioner_type+"' AND ";
		}

		secondSql = secondSql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";	 
		
	}
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(firstSql)+"\"";
	xmlStr += " sqlSec=\"" +escape(secondSql)+"\"";
	xmlStr += " practitioner_type=\"" + practitioner_type + "\"";
	xmlStr += " specialty_code=\"" + speciality + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr += " showPractAvailDetails=\"" + showPractAvailDetails + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	
	return;

}

async function NursingUnitLookup(FacilityID,LoginUser,OperatorStationID)
{  
	
	var Facility_ID				=	FacilityID;
	var Login_User				=	LoginUser;
	var Operator_Station_ID		=	OperatorStationID;
	//var nursingUnitCode			=  document.forms[0].nursing_unit_desc.value
	var tit						= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "41vh" ; //41
	var dialogWidth				= "65vw" ; //65
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	//var tospecialtycode			= document.forms[0].to_speciality_code.value;
	//var splty_code				= document.forms[0].Splcode.value;
	//var pract_id				= document.forms[0].practid.value;
	var patientclass			= document.forms[0].encounter_type_sel.value
	//var bkg_type				= parent.frames[0].document.Select_form.bkg_type.value;
	//var clin_code				= parent.frames[0].document.Select_form.clin_code.value;
	var admit_patient_with_bed_yn="Y";
	/*if(clin_code!="") {
		if(document.getElementById("d_clinic_code")) {
			document.getElementById("d_clinic_code").value = clin_code;
			}
	}*/

	//var room_no					= document.forms[0].room_no.value;
	//var bed_mandatory_for_admn_yn= document.forms[0].bed_mandatory_for_admn_yn.value;
	var call_function;

	

//		if(bkg_type == 'D' || bkg_type =='I')
		call_function='PatMovHist';
//		else
//			call_function='Admit';
	var statics_yn='Y';
	
	/*if (patientclass == "I")
	{
		patientclass = "IP";
	}
	if (patientclass == "D")
	{
		patientclass = "DC";
	}*/

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&statics_yn="+statics_yn+"&call_function="+call_function;
	
	var retVal =  await window.showModalDialog(jsp_name,arguments, features);
	var arr=new Array();
	if (retVal != null )
	{
		arr=retVal.split("~");		
		document.forms[0].nursing_unit_desc.value=arr[1];
		document.forms[0].nursing_unit.value=arr[0];
		//document.forms[0].patient_class_id.value = arr[2];

		/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
		if(arr[0] != "")
		{
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH step='seven' nursing_unit=\""+arr[0]+"\"  operatorstation=\""+Operator_Station_ID+"\" Login_User=\""+Login_User+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			admit_patient_with_bed_yn = responseText
		}
		
		//document.forms[0].nurs_unit_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		//validateFields(document.forms[0].nursing_unit_desc);
		

		
		
		

		//document.forms[0].SplDesc.value='';
		//document.forms[0].Splcode.value='';
		document.forms[0].practid_desc.value='';
		document.forms[0].practid.value='';
		//document.forms[0].att_practid_desc.value='';
		//document.forms[0].att_practid.value='';

	}
	else
	{		
		document.forms[0].nursing_unit.value='';
		document.forms[0].nursing_unit_desc.value = '';
		//document.forms[0].patient_class_id.value ='';
		//document.forms[0].SplDesc.value='';
		//document.forms[0].Splcode.value='';
		//document.forms[0].practid_desc.value='';
		//document.forms[0].practid.value='';
		//document.forms[0].att_practid_desc.value='';
		//document.forms[0].att_practid.value='';
		//document.forms[0].Bedcode.value='';
		//document.forms[0].bed_type.value='';
		
		
		//if(document.forms[0].pat_check_in_allowed_yn.value == "Y")
		//document.forms[0].attend_img.style.visibility="hidden";
		//parent.frames[3].document.getElementById("valuables").disabled = true;
		//var obj = document.forms[0].service;
		//var length  = obj.length;
		//for(i=0;i<length;i++) { obj.remove(0); }
		
		//var opt = document.createElement("OPTION");
		//opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		//opt.value= '';
		//document.forms[0].service.add(opt);
	}
	/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
	
	
	/*if(admit_patient_with_bed_yn=="Y" || bed_mandatory_for_admn_yn == "Y") 
	{
		enableBed(document.forms[0].nursing_unit_desc);
	}
	else 
	{
		document.forms[0].bed_no.value = '';
		document.forms[0].bed_avail_chart.disabled = true;
	} */
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
	
	var patientclass=document.forms[0].encounter_type_sel.value ; // added for ICN-64475
	
	var tit					= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight		= "98vh" ;
	var dialogWidth			= "95vw" ;
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
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id+"&call_function="+call_function+"&applicable_to="+patientclass+"&nursingUnitCode="+encodeURIComponent(nursingUnitCode); // modified for ICN-64475
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
