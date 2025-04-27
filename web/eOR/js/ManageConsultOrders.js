/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date Rev.By  Description
--------------------------------------------------------------------------------------------------------------
11/02/2014    IN046933      Chowminya  	11/02/2014 Akbar Unable to associate practitioner at order associated package included services i.e. consultations
---------------------------------------------------------------------------------------------------------
*/
function callSpecialityDesc(obj,rowvalue)
{
	if(obj.value!="")
	{
		callSpeciality(obj,rowvalue);
	}
	else
	{
		eval("document.ManageConsultOrderDtl.speciality_code"+rowvalue).value="";
	}
}

function callSpeciality(obj,rowvalue)  //Called on click of the speciality
{
		var dataNameArray  		= new Array() ;
		var dataValueArray 		= new Array() ;
  		var dataTypeArray 		= new Array() ;
  		var sql_query			= document.ManageConsultOrderDtl.sql_or_order_entry_speciality.value;
  		var argumentArray  		= new Array() ;
		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		argumentArray[5]	= obj.value;//eval("document.ManageConsultOrderDtl.speciality"+rowvalue).value ;//Target
  		retVal = callCommonLookUpSearch(argumentArray,obj.name);
		if(retVal!=null && retVal!='')
  		{
  			eval("document.ManageConsultOrderDtl.speciality"+rowvalue).value 		= retVal[1] ;
  			eval("document.ManageConsultOrderDtl.speciality_code"+rowvalue).value = retVal[0];
		}
		else
	{
	   eval("document.ManageConsultOrderDtl.speciality"+rowvalue).value 		= "" ;
	}
}

function callCommonLookUpSearch(argumentArray,name) // calling the Common Look Up(For Population of Practitioner and Location)
{
  		argumentArray[6]   	= CODE_LINK; // DESC_LINK ;
  		argumentArray[7]   	= CODE_DESC ; // DESC_CODE display part
  		var title			= "";
  		if(name.indexOf("location")!=-1)
  			title			= "Location";
  		else if(name.indexOf("speciality")!=-1)
			title			= "Speciality";
  		else
  			title			= "Practitioner";
  		return retVal = await CommonLookup( title, argumentArray );
} // End of Common Look Up

function show_practtioner_window(target,rowvalue)
{

	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";

	practName_FName		= target.name;		// object name
	practName_FValue	= target.value;	
	practId_FName		= eval("document.ManageConsultOrderDtl.practitioner_id"+rowvalue).value
	speciality_code		= eval("document.ManageConsultOrderDtl.speciality_code"+rowvalue).value
	clinic_code		= eval("document.ManageConsultOrderDtl.locn"+rowvalue).value
	facilityid		= document.ManageConsultOrderDtl.facility_id.value;
	//IN046933 - Start modified the both queries to handle the secondary specialty condition for practitioner 
	//sql="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM am_practitioner))) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  OR UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";
	sql="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  )) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  OR UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";

	//sql2="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM am_practitioner))) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  AND UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";
	sql2="SELECT  b.practitioner_id practitioner_id,am_get_desc.am_practitioner (b.practitioner_id,'"+localeName+"',1) practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type,b.position_code job_title, b.gender gender,am_get_desc.am_speciality (e.primary_speciality_code,'"+localeName+"',2) primary_specialty FROM am_pract_for_facility a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d, am_pract_all_splty_vw e WHERE b.eff_status = 'E'  AND c.eff_status = 'E' AND b.practitioner_id = a.practitioner_id  AND a.eff_status = 'E'  AND a.facility_id = '"+facilityid+"' AND b.language_id = '"+localeName+"' AND c.facility_id = a.facility_id   AND c.clinic_code = '"+clinic_code+"' AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities  WHERE facility_id = '"+facilityid+"'  AND practitioner_id = b.practitioner_id  )) AND NVL (c.pract_type, b.pract_type) = b.pract_type  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND a.facility_id = e.facility_id  AND UPPER (e.primary_speciality_code) LIKE UPPER (NVL (replace(?,'%',''), b.primary_speciality_code))  AND b.practitioner_id = e.practitioner_id AND (UPPER (e.practitioner_id) LIKE  UPPER (NVL (?, e.practitioner_id))  AND UPPER (am_get_desc.am_practitioner (e.practitioner_id, '"+localeName+"', 1)) LIKE  UPPER (NVL (?,am_get_desc.am_practitioner (e.practitioner_id,'"+localeName+"',1 )))) AND UPPER (e.gender) LIKE UPPER (NVL(?, e.gender)) AND UPPER (NVL (e.job_title, '123')) LIKE  UPPER (NVL (?, NVL (e.job_title, '123'))) ORDER BY 2";
	//IN046933 - End 
	var splty			= "";
	var facility_id		= "";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + speciality_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
 

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText	= xmlHttp.responseText;
	responseText	= trimString(responseText);
	eval(responseText);
}

function CheckForNotChars(event)
{  
    if( (event.keyCode < 97) && (event.keyCode > 122) )
		return (event.keyCode);
	else
		return false ;
}

function PractLookupRetVal(retVal,target)
{
 	if(retVal != null && retVal != "")
	{
		arr=retVal.split("~");
		rowvalue= target.substring(17);
		eval("document.ManageConsultOrderDtl.practitioner_id"+rowvalue).value = arr[0];
		eval("document.ManageConsultOrderDtl.practitioner_desc"+rowvalue).value = arr[1];
		eval("document.ManageConsultOrderDtl.practitioner_desc"+rowvalue).focus();
	}
 }

 function populateLocation(target,rowvalue)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	var localeName=document.ManageConsultOrderDtl.localeName.value;
	 location_type	= "C";
	
	facilityid		= document.ManageConsultOrderDtl.facility_id.value;
	sql="select clinic_code code,short_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and eff_status='E'  and clinic_type='C' and language_id='"+localeName+"' and  UPPER(clinic_code) LIKE UPPER(NVL(?,clinic_code)) AND UPPER(short_desc) LIKE UPPER(NVL(?,short_desc))";
	argumentArray[0]=sql;
 
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
 
   	retVal = await CommonLookup( getLabel("Common.Location.label","Common"),argumentArray ); 
	if(retVal != null && retVal != "")
	{
		eval("document.ManageConsultOrderDtl.locn"+rowvalue).value=retVal[0];
		target.value = retVal[1];
	}
	else
	{
		target.value="";
		eval("document.ManageConsultOrderDtl.locn"+rowvalue).value = "";
	}
}
function CheckForNumsAndColon(event)
{
   var key = window.event.keyCode;
   if( !(( ( key>=47 ) && ( key<=58 ) )||(key==32)) ) {
       return false;
  }
	
}

function apply()
{
	var fm_disp		= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.from_disp.value;
	var to_disp		= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.to_disp.value;
	var mode			= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.mode.value;
	var called_from			= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.called_from.value;
	var encounter_id			= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.encounter_id.value;
	var row_ids = "";
	var speciality_codes = "";
	var practitioner_ids = "";
	var locns = "";
	var Consult_dates = "";
	for(i=fm_disp; i<to_disp; i++)
	{
		var row_id = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.row_id"+i).value;
		var speciality_code = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.speciality_code"+i).value;
		var practitioner_id = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.practitioner_id"+i).value;
		var locn = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.locn"+i).value;
		var Consult_date = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.Consult_date"+i).value;
		if(row_id=="")
		{
			row_id = "@#";
		}
		if(speciality_code=="")
		{
			speciality_code = "@#";
		}
		if(practitioner_id=="")
		{
			practitioner_id = "@#";
		}
		if(locn=="")
		{
			locn = "@#";
		}
		if(Consult_date=="")
		{
			Consult_date = "@#";
		}
		row_ids+=row_id+"~";
		speciality_codes+=speciality_code+"~";
		practitioner_ids+=practitioner_id+"~";
		locns+=locn+"~";
		Consult_dates+=Consult_date+"~";
	}
	var xmlStr = "";
	var CallFrom = "SAVE_CONSULT_GRP";		
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
	xmlStr += "ROW_IDS=\""+ row_ids +"\" " ;
	xmlStr += "SPECIALITY_CODES=\""+ speciality_codes+"\" " ;		
	xmlStr += "PRACTITIONER_IDS=\""+ practitioner_ids +"\" " ;		
	xmlStr += "LOCNS=\""+ locns +"\" " ;		
	xmlStr += "CONSULT_DATES=\""+ Consult_dates +"\" " ;				
	xmlStr += "FROM=\""+ fm_disp +"\" " ;				
	xmlStr += "TO=\""+ to_disp +"\" " ;				
	xmlStr += "MODE=\""+ mode +"\" " ;				
	xmlStr += "ENCOUNTER_ID=\""+ encounter_id +"\" " ;				
	xmlStr += "CALLED_FROM=\""+ called_from +"\" " ;				
	xmlStr +=" /></root>" ;	
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ManageConsultOrdersValidate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function submitPrevNext(from, to,encounter_id,mode)
{
	pagination();
	parent.ManageConsultOrderdtl.location.href ="../../eOR/jsp/ManageConsultOrdersDetail.jsp?from="+from+"&encounter_id="+encounter_id+"&mode="+mode+"&to="+to;	
}

function pagination()
{
	var fm_disp		= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.from_disp.value;
	var to_disp		= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.to_disp.value;
	var mode			= parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.mode.value;
	var row_ids = "";
	var speciality_codes = "";
	var practitioner_ids = "";
	var locns = "";
	var Consult_dates = "";
	for(i=fm_disp; i<to_disp; i++)
	{
		var row_id = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.row_id"+i).value;
		var speciality_code = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.speciality_code"+i).value;
		var practitioner_id = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.practitioner_id"+i).value;
		var locn = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.locn"+i).value;
		var Consult_date = eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.Consult_date"+i).value;
		if(row_id=="")
		{
			row_id = "@#";
		}
		if(speciality_code=="")
		{
			speciality_code = "@#";
		}
		if(practitioner_id=="")
		{
			practitioner_id = "@#";
		}
		if(locn=="")
		{
			locn = "@#";
		}
		if(Consult_date=="")
		{
			Consult_date = "@#";
		}
		row_ids+=row_id+"~";
		speciality_codes+=speciality_code+"~";
		practitioner_ids+=practitioner_id+"~";
		locns+=locn+"~";
		Consult_dates+=Consult_date+"~";
	}
	var xmlStr = "";
	var CallFrom = "UPDATE_CONSULT_GRP";		
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
	xmlStr += "ROW_IDS=\""+ row_ids +"\" " ;
	xmlStr += "SPECIALITY_CODES=\""+ speciality_codes+"\" " ;		
	xmlStr += "PRACTITIONER_IDS=\""+ practitioner_ids +"\" " ;		
	xmlStr += "LOCNS=\""+ locns +"\" " ;		
	xmlStr += "CONSULT_DATES=\""+ Consult_dates +"\" " ;				
	xmlStr += "FROM=\""+ fm_disp +"\" " ;				
	xmlStr += "TO=\""+ to_disp +"\" " ;				
	xmlStr += "MODE=\""+ mode +"\" " ;				
	xmlStr +=" /></root>" ;			
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ManageConsultOrdersValidate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function Cancel()
{
	window.close();
}

function Refresh(queryString)
{
	parent.ManageConsultOrderdtl.location.href="../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString;
}

function validateConsultDate(obj,consultStartDate,consultEndDate,rowValue)
{
	localeName = document.getElementById("localeName").value;		
	if(validDateObj(obj,"DMYHM",localeName))
	{
		if(!isAfter(consultEndDate,obj.value,"DMYHM",localeName.value))
		{
			alert(getMessage("CONSULT_DATE_GRT_THAN_END_DATE","OR"));
			obj.focus();
			return false;
			
		}
		else if(!isBefore(consultStartDate,obj.value,"DMYHM",localeName.value))
		{
			alert(getMessage("CONSULT_DATE_LESS_THAN_START_DATE","OR"));
			obj.focus();
			return false;
		}
	}
	else
	{
		eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.Consult_date"+i).value =eval("parent.ManageConsultOrderdtl.document.ManageConsultOrderDtl.temp_Consult_date"+i).value;
	}
}
