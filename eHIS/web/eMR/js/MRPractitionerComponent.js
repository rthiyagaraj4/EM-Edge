 async function getPractitioner(obj, target, facility_id, executeQuery,specialty_code,isSpecialtyDefaultApp)
{
	
	var tit="";
	var FirstSql ="";
	var SecondSql ="";
		
	target.value			= trimString(target.value);
	var practitionerName	= target.name;
	var practitionerValue	= target.value;
	//Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start
	var specialtyCode		= specialty_code;
	var isSpecialtyDefaultApp	= isSpecialtyDefaultApp;
	//Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End
	
	if(executeQuery == "Q1")
	{
		/*
		*	Function Name	-	Master Code Setup-> Diagnosis / Procedure Group 
		*	File Name		-	MRDiagGroup.js
		*/
		//FirstSql = "SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.POSITION_CODE like (?) or a.POSITION_CODE is null) ";

		FirstSql = "SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ";
				
		//SecondSql = "SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.POSITION_CODE like (?) or a.POSITION_CODE is null)";

		SecondSql = "SELECT   a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title FROM am_practitioner a, am_pract_type b,am_speciality c WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123')))";
	}
	else if(executeQuery == "Q2")
	{
		/*
		*	Function Name	-	Medical Request
								Medical Board
								Record Patient Valuables
								Medical Report 

		*	File Name		-	PatientValuablesDtls.jsp
								MedBoardReqTransaction.js
								MedRecRequestDetails.js
		*/
		//FirstSql = "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		//FirstSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL)";

		FirstSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

		//SecondSql = "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		//SecondSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL)";

		SecondSql = "SELECT a.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

	}
	else if(executeQuery == "Q3")
	{
		/*
		*	Function Name	- Medical Board Request Formation for External user
		*	File Name		- PractitionerComponent.jsp
		*/
		//FirstSql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME, AM_GET_DESC.AM_PRACT_TYPE( PRACT_TYPE,'"+localeName+"','2')  practitioner_type,AM_GET_DESC.AM_SPECIALITY( PRIMARY_SPECIALITY_CODE  ,'"+localeName+"','2')  primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		//FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b, am_pract_type d,  am_speciality e WHERE b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b, am_pract_type d,  am_speciality e WHERE b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND  upper(nvl(b.JOB_TITLE,'123')) like upper(nvl(?,nvl(b.JOB_TITLE,'123')))";
		
		//SecondSql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,AM_GET_DESC.AM_PRACT_TYPE( PRACT_TYPE,'"+localeName+"','2') practitioner_type,AM_GET_DESC.AM_SPECIALITY( PRIMARY_SPECIALITY_CODE  ,'"+localeName+"','2') primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		SecondSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b, am_pract_type d,  am_speciality e WHERE b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.JOB_TITLE,'123')) like upper(nvl(?,nvl(b.JOB_TITLE,'123')))";		
	}
	else if(executeQuery == "Q4" || executeQuery == "Q5")
	{
		/*
		*	Function Name	- Medical Board Request Formation for Internal user
		*	File Name		- PractitionerComponent.jsp
		*/
		//FirstSql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,AM_GET_DESC.AM_PRACT_TYPE( PRACT_TYPE  ,'"+localeName+"','2') practitioner_type,AM_GET_DESC.AM_SPECIALITY( PRIMARY_SPECIALITY_CODE  ,'"+localeName+"','2') primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		//FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.language_id = '"+localeName+"' and  b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL)";

		FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.language_id = '"+localeName+"' and  b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND  upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";
		
		//SecondSql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,AM_GET_DESC.AM_PRACT_TYPE( PRACT_TYPE  ,'"+localeName+"','2') practitioner_type,AM_GET_DESC.AM_SPECIALITY( PRIMARY_SPECIALITY_CODE  ,'"+localeName+"','2')  primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

		//SecondSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.language_id = '"+localeName+"' and  b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL)";

		SecondSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.language_id = '"+localeName+"' and  b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";
	}
	else if(executeQuery == "Q6")
	{
		/*
		*	Function Name	- Mainttain Death Register
		*	
		*/
		
		FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.primary_speciality_code primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b WHERE b.language_id = '"+localeName+"' and  b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  and  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND  upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";		

		SecondSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.primary_speciality_code primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b  WHERE b.language_id = '"+localeName+"'  and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + encodeURIComponent(practitionerName) + "\""	;
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " practId_FName=\"" + practitionerName + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	//Modified By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454
	if(isSpecialtyDefaultApp=="true"){
		xmlStr += " specialty_code=\"" + specialtyCode+ "\"";
	}else{
		xmlStr += " specialty_code=\"" + ""+ "\"";
	}
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	//Commented by Sethu on 26/12/2024 for EDGE issue 74194 - Practitioner Search window is opened twice.
	//Practitioner Search function is called from eval(responseText) in line 125.
	//eval(practSearch(encodeURIComponent(practitionerName),encodeURIComponent(practitionerValue),specialtyCode,responseText));
	      
/*
	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];	
*/
}
 
 async function practSearch(practName_FName,practName_FValue,splty,responseText) {
		var retVal = 	new String();
		var dialogTop = "10px" ;
		var dialogHeight= "500px" ;
		var dialogWidth	= "800px" ;
			
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



