  // Modified to Practitioner Lookup a
function getPractitioner(obj, target, facility_id, splty,practitioner_type, executeQuery,clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn)

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
			Function Name	-	AE Transactions -	Current Emergency Patients
													Assign Treatment Area  
													Current Emergency Patients Using Bed/Bay Chart
													AE Checkout
								AE Queries      -   Patient By Treatment Room
			File Name		-	eAE/js/AEManagePatient.js
								eAE/js/AEPatientTMTQuery.js
								eAE/jsp/AESearchVisitQueryCriteria.jsp
								eAE/jsp/AEPatientTMTSearch.jsp
								eAE/jsp/AEManagePatGICriteria.jsp
								eAE/jsp/AEMPSearchCriteria.jsp
								eAE/jsp/AEMPAssignTreatmentArea.jsp
		*/
		if(clinic_code!="") {
		   if(treatment_area_code!="") {
				if(open_to_all_prac_for_clinic_yn=='N')
				    { 

					    FirstSql= "select distinct a.practitioner_id, c.practitioner_name, c.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, c.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and b.practitioner_id = a.practitioner_id and a.practitioner_id = c.practitioner_id and c.language_id = '"+localeName+"'  and b.eff_status = 'E' and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"'  and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"'  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or  upper(c.practitioner_name) like upper(nvl(?, c.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

						SecondSql= "select distinct a.practitioner_id, c.practitioner_name, c.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, c.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and b.practitioner_id = a.practitioner_id and a.practitioner_id = c.practitioner_id and c.language_id = '"+localeName+"'  and b.eff_status = 'E' and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"'  and b.clinic_code = '"+clinic_code+"' and b.treatment_area_code = '"+treatment_area_code+"'  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and  upper(c.practitioner_name) like upper(nvl(?, c.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

					 } 
					 else  if(open_to_all_pract_yn=='Y')
					 {
                       FirstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

						SecondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

					 }
			         else
					 {


					    FirstSql= "select distinct a.practitioner_id, c.practitioner_name, c.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, c.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and b.practitioner_id = a.practitioner_id and a.practitioner_id = c.practitioner_id and c.language_id = '"+localeName+"'  and b.eff_status = 'E' and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"'  and b.clinic_code = '"+clinic_code+"'   and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or  upper(c.practitioner_name) like upper(nvl(?, c.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

						SecondSql= "select distinct a.practitioner_id, c.practitioner_name, c.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, c.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and b.practitioner_id = a.practitioner_id and a.practitioner_id = c.practitioner_id and c.language_id = '"+localeName+"'  and b.eff_status = 'E' and a.facility_id=b.facility_id and b.facility_id= '"+facility_id+"'  and b.clinic_code = '"+clinic_code+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and  upper(c.practitioner_name) like upper(nvl(?, c.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";
			         }
               }else{  
				   
				   if(open_to_all_pract_yn=='Y') 
				    {

					    FirstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

						SecondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";
					}
			        
		        }
          }
		  else 
		  {

                       FirstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

					   SecondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";
		 }
		
	}
	else if(executeQuery == "Q2")
	{
		/*
			Function Name	-	AE Transactions -	Revise Attendance Details
													
								AE Reports      -   AE Internal Reports Reprint

			File Name		-	eAE/js/AESearchVisit.js
		                        eAE/jsp/AESearchVisitQueryCriteria.jsp
		*/

	   if(clinic_code!="") 
			{
				if(open_to_all_pract_yn=="Y") 
				{

                        FirstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

						SecondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id  and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

				 }
				 
			}
			else
			{
				      FirstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

					  SecondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+facility_id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

			}	
	}
    else if(executeQuery == "Q3")
	{

		/*
		   Function Name	-  AE Code Setup --> Practitioner for Treatment Area

		   File Name		-  eAE/js/PractforTreatmentArea.js
		                       eAE/jsp/addModifyPractforTreatmentArea.jsp
		*/
        	FirstSql ="select a.practitioner_id,d. practitioner_name, a.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, a.primary_splty_short_desc primary_specialty from am_practitioner_vw a , am_pract_for_facility b, op_clinic c,am_practitioner_lang_vw d	where a.eff_status='E' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and c.facility_id = b.facility_id and c.clinic_code = '"+clinic_code+"' and  (c.speciality_code = a.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = a.practitioner_id )) and b.practitioner_id = a.practitioner_id and a.practitioner_id=d.practitioner_id  and d.language_id='"+localeName+"' and b.eff_status = 'E' 	and b.facility_id= '"+facility_id+"' and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or  upper(d.practitioner_name) like upper(nvl(?,d.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";

	        SecondSql="select a.practitioner_id,d. practitioner_name, a.pract_type_desc practitioner_type, a.POSITION_CODE job_title, a.gender, a.primary_splty_short_desc primary_specialty from am_practitioner_vw a , am_pract_for_facility b, op_clinic c,am_practitioner_lang_vw d	where a.eff_status='E' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and c.facility_id = b.facility_id and c.clinic_code = '"+clinic_code+"' and  (c.speciality_code = a.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and practitioner_id = a.practitioner_id )) 	and b.practitioner_id = a.practitioner_id and a.practitioner_id=d.practitioner_id and d.language_id='"+localeName+"' and b.eff_status = 'E' 	and b.facility_id= '"+facility_id+"' and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(d.practitioner_name) like upper(nvl(?,d.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) ORDER BY 2";
	}
	else if(executeQuery == "Q4")
	{
		/*
			Function Name	-	AE Reports --> AE Reporrts List --> Patient Revisit Within A Day
								AE Reports --> AE Reporrts List --> Brought Dead Patients				
			File Name		-	eAE/js/PatientRevistWithinADay.js
		                        eAE/js/RepBroughtDead.js
								eAE/jsp/RepBroughtDead.jsp
								eAE/jsp/PatientRevistWithinADay.jsp
		*/

		FirstSql="SELECT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, a.PRIMARY_SPECIALITY_DESC primary_specialty  FROM AM_PRACTITIONER_LANG_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";

		if(splty != "")
		FirstSql+=" a.primary_speciality_code='"+splty+"' and";

		if(practitioner_type!="")	
			FirstSql+= "	a.pract_type='"+practitioner_type+"' AND ";

		FirstSql += " UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = a.PRACTITIONER_ID AND a.LANGUAGE_ID = '"+localeName+"'  and a.language_id = '"+localeName+"' ORDER BY 2 ";

		SecondSql="SELECT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, a.PRIMARY_SPECIALITY_DESC primary_specialty  FROM AM_PRACTITIONER_LANG_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND ";

		if(splty != "")
		SecondSql+=" a.primary_speciality_code='"+splty+"' and";

		if(practitioner_type!="")	
			SecondSql+="	a.pract_type='"+practitioner_type+"' AND ";

		SecondSql += " UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = a.PRACTITIONER_ID AND a.LANGUAGE_ID = '"+localeName+"'  and a.language_id = '"+localeName+"' ORDER BY 2 ";	

	}
	else if(executeQuery == "Q5")
	{
/*
			Function Name	-   AE Reports --> AE Master Code List --> Practitioner For Treatment Area
								AE Reports --> AE Statistics --> Patients Seen By Individual			
			File Name		-	eAE/js/AECodeCheck.js
		                        eAE/js/AERepPatSeenbyDoctors.js
								eAE/jsp/RepPatSeenbyDoctors.jsp
								eAE/jsp/repPractitionerforTreatmentAreaList.jsp
		*/

		FirstSql="SELECT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, a.PRIMARY_SPECIALITY_DESC primary_specialty  FROM AM_PRACTITIONER_LANG_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND  UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = a.PRACTITIONER_ID AND a.LANGUAGE_ID = '"+localeName+"'  and a.language_id = '"+localeName+"' ORDER BY 2 ";

		SecondSql="SELECT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, a.PRIMARY_SPECIALITY_DESC primary_specialty  FROM AM_PRACTITIONER_LANG_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND  UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = a.PRACTITIONER_ID AND a.LANGUAGE_ID = '"+localeName+"'  and a.language_id = '"+localeName+"' ORDER BY 2 ";	
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\""	;
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + practitioner_type + "\"";
	xmlStr += " specialty_code=\"" + splty+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText); 
    eval(practSearch(encodeURIComponent(practitionerName),encodeURIComponent(practitionerValue),splty,responseText));
	

}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "55vh" ;
	var dialogWidth	= "75vw" ;
		
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


