// Modified to Practitioner Lookup by Sridhar on 16 FEB 2004 
function getPractitioner_common(obj,target,pract_type,facility_id,executeQuery)
{ 
	var tit="";
	var practitionerName="";
	var practitionerValue="";
	var FirstSql ="";
	var SecondSql ="";
		
	target.value		= trimString(target.value);
	practitionerName	= target.name;
	practitionerValue	= target.value;
	
	
	if(executeQuery == "Q1")
	{
		/*
			File Names 		:   1.FMGeneratePullList.js
								2.FMConfirmPullingList.js

			Function Names 	:   1.Track Out to OPD -> Generate OP Pulling List 
								2.Track Out to OPD -> Confirm OP Pulling List
		*/
		
		FirstSql = "SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name, a.pract_type_desc practitioner_type, b.short_Desc primary_specialty, a.POSITION_CODE job_title, a.gender gender FROM am_practitioner_lang_vw a, am_speciality_lang_vw b  WHERE a.pract_type =nvl('"+pract_type+"',a.pract_type) AND UPPER(a.pract_type) LIKE UPPER(NVL(?, a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?, a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?, a.practitioner_name))) AND UPPER(gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) and a.language_id = '"+localeName+"' and a.primary_speciality_code = b.speciality_code and b.language_id = '"+localeName+"' ORDER BY a.PRACTITIONER_NAME";

		SecondSql = "SELECT a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_NAME practitioner_name, a.pract_type_desc practitioner_type, b.short_Desc primary_specialty, a.POSITION_CODE job_title, a.gender gender FROM am_practitioner_lang_vw a, am_speciality_lang_vw b  WHERE a.pract_type =nvl('"+pract_type+"',a.pract_type) AND UPPER(a.pract_type) LIKE UPPER(NVL(?, a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?, a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?, a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE UPPER(NVL(?, a.practitioner_name))) AND UPPER(gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) and a.language_id = '"+localeName+"' and a.primary_speciality_code = b.speciality_code and b.language_id = '"+localeName+"' ORDER BY a.PRACTITIONER_NAME";
		
	}
	else if(executeQuery == "Q2")
	{
		/*
			File Names 		:   1.FMIssueFilesDoc.js
								2.FMLostFound.js 
								3.FMRequestFile.js
								4.FMReturnToMRD.js
								5.FMTransferFile.js

			Function Names 	:   1.Issue File
								2.Change File Status 
								3.Request File
								4.Return To MRD
								5.Transfer File
		*/


		FirstSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.pract_type_desc practitioner_type, c.short_desc primary_specialty, b.gender gender, b.POSITION_CODE job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw c WHERE a.facility_id= '"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = c.speciality_code and c.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND   UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123')))";

		SecondSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.pract_type_desc practitioner_type, c.short_desc primary_specialty, b.gender gender, b.POSITION_CODE job_title  FROM  am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw c WHERE a.facility_id= '"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = c.speciality_code and c.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND   UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123')))";
		
	}
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\""	;
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);*/

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +encodeURIComponent(practitionerName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue)+ "\"";
	//xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);
	eval(practSearch(encodeURIComponent(practitionerName),encodeURIComponent(practitionerValue),"",responseText));
	return;      
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="700px";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName); 
		
	
}