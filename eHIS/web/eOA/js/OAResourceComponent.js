// Created to generalize Practitioner Lookup by Venkatesh on 23/04/2007	




async function getPractitioner(obj,target,facility_id,splty,pract_type,clinic_code,practitioner_id,executeQuery){
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var sql="";
	var sql2="";
	var facilityId = facility_id;	
	if(executeQuery == "Q1"){
		/*
		Function Names: OA Reports->Administration Transaction Records ,Appointments For OPD,
						OA Statistics->Statistics by Day of Month, by Resource,Statistics by Day of Week, by Resource
						OA Reports->Cancelled Appointments,Patient Records Pulling List for Appointments,No Shows,OA Master List & Transfer Appointments

		File Names:		repAdminTranRecords.js
						repAppointmentsForOPD.js
						repApptStatsByDayOfMonthByPract.js
						repApptStatsByDayOfWeekByPract.js
						repCancelAppointments.js
						repMRPullingListForAppt.js
						repNoshowsAppointments.js 
						repOACodeCheck.js
						repTranAppointments.js

		*/
		
		//sql="select practitioner_id practitioner_id, practitioner_name, pract_type_desc practitioner_type, primary_speciality_desc primary_specialty, position_code job_title, gender gender from am_practitioner_lang_vw  where pract_type = nvl('"+pract_type+"', pract_type)  and upper(pract_type) like upper(nvl(?, pract_type)) and upper(primary_speciality_code) like upper(nvl(?, primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?, practitioner_id)) or upper(practitioner_name) like upper(nvl(?, practitioner_name))) and gender like nvl(upper(?), gender) and upper(nvl(position_code, '123')) like upper(nvl(?, nvl(position_code, '123'))) and language_id = '"+localeName+"' order by practitioner_name";

		// commented for in  19335 & below added
	
		sql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql=sql+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql = sql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

		
		//sql2="select practitioner_id practitioner_id, practitioner_name, pract_type_desc practitioner_type, primary_speciality_desc primary_specialty, position_code job_title, gender gender from am_practitioner_lang_vw  where pract_type = nvl('"+pract_type+"', pract_type)  and upper(pract_type) like upper(nvl(?, pract_type)) and upper(primary_speciality_code) like upper(nvl(?, primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?, practitioner_id)) AND upper(practitioner_name) like upper(nvl(?, practitioner_name))) and gender like nvl(upper(?), gender) and upper(nvl(position_code, '123')) like upper(nvl(?, nvl(position_code, '123'))) and language_id = '"+localeName+"' order by practitioner_name"

		// commented for in  19335 & below added

		sql2="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql2=sql2+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql2 = sql2+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME)) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

	}else if (executeQuery == "Q2"){
		/*
		Function Names: OA Reports->Reprint Appointment Slips
						OA Transactions->Schedule Appointments

		File Names:		repReprintApptSlips.js
						Validate.js
		*/

		//sql= "SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.POSITION_CODE job_title, b.gender FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.practitioner_id = b.practitioner_id AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR upper(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND b.language_id = '"+localeName+"' order by b.PRACTITIONER_NAME ";
		// commented for in  19335 & below added

		sql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql=sql+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql = sql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

		//sql2= "SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.POSITION_CODE job_title, b.gender FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.practitioner_id = b.practitioner_id AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND upper(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND b.language_id = '"+localeName+"' order by b.PRACTITIONER_NAME ";
		// commented for in  19335 & below added

		sql2= "SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql2=sql2+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql2 = sql2+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
	}else if(executeQuery == "Q3"){
	/*

	Function Names: OA Transactions->Create Wait List
					OA Schedules->Block Appointment Slots,Block/Lift/Cancel Schedule,Change Resource for Generated Schedule,Duty Roster for Resources
					OA Admin Setup->Purge Schedule Records
					OA Queries->Appointment for a Resource ,Appointments for Patients,Block on Appointments,Locations for a day,Location Schedule
					OA Schedules->Setup Daily Schedule 
					OA Transactions->Transfer/Cancel Appointment 
					OA Schedules->Transfer Location Schedule 
					OA Transactions->Schedule Appointments & Manage Wait List

	File Names:		ApptWaitList.js
					Blockapptslots.js
					BlockLiftCancelSch.js
					ChangePractitionerforGenSch.js
					PractDutyRoster.js
					Purgeschedulerecords.js
					QryApptforPractCriteria.js
					QueryApptForPatient.js
					QueryBlockAppt.js
					QueryLocnForDay.js
					QueryLocnSchedule.js
					Scheduling.js
					TransferCancelAppointment.js
					TransferClinicSch.js
					Validate.js
					WaitListMgmt.js


	*/

			sql="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c ";

			if(obj.name!="to")
		{
			sql=sql +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.specialty_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.specialty_code) like upper(nvl(?,a.specialty_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";

		}else
		{
				

			sql=sql +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id and b.practitioner_id != '"+practitioner_id+"' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.specialty_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.specialty_code) like upper(nvl(?,a.specialty_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}

			sql2="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c";
			
			if(obj.name!="to")
		{
			sql2=sql2 +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.specialty_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.specialty_code) like upper(nvl(?,a.specialty_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}else
		{
			sql2=sql2 +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and b.practitioner_id != '"+practitioner_id+"' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.specialty_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.specialty_code) like upper(nvl(?,a.specialty_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}

	/*		sql="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"','2') primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c ";

			if(obj.name!="to")
		{
			sql=sql +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = b.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(replace(?,'%',''),b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?, a.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";

		}else
		{
				

			sql=sql +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id and b.practitioner_id != '"+practitioner_id+"' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = b.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(replace(?,'%',''),b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?, a.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}

			sql2="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"','2') primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c";
			
			if(obj.name!="to")
		{
			sql2=sql2 +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = b.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(replace(?,'%',''),b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?, a.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}else
		{
			sql2=sql2 +" where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and b.practitioner_id != '"+practitioner_id+"' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = b.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(replace(?,'%',''),b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?, a.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
		}
		*/

	}else if(executeQuery == "Q5"){
		/*
		Function Names: OA Transactions->Create Wait List & Manage Wait List

		File Names:     ApptWaitList.js
					    WaitListMgmt.js

		*/
		sql = "SELECT a.facility_id,a.practitioner_id practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty, b.gender, b.position_code job_title FROM am_pract_all_splty_vw a, am_practitioner_lang_vw b, ip_nursing_unit_for_pract e WHERE a.facility_id='"+facilityId+"' AND a.specialty_code = '"+splty+"' AND e.facility_id = a.facility_id   AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) and a.practitioner_id = b.practitioner_id and b.language_id = 'en' AND 1 = 1";

		
	}else if(executeQuery == "Q9")
	{

	/*

	Function Names: OA Transactions->Bulk Transfer Appointments

	File Names:     BulkTransferAppointment.js


	*/

sql="SELECT a.PRACTITIONER_ID practitioner_id, c.practitioner_name, c.PRACT_TYPE_DESC practitioner_type, c.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, AM_PRACT_ALL_SPLTY_VW b, am_practitioner_lang_vw c WHERE a.facility_id = b.facility_id AND a.facility_id = '"+facilityId+"' and a.practitioner_id= b.practitioner_id AND b.primary_speciality_code='"+splty+"' AND a.resource_class='P' and a.clinic_code = NVL('"+clinic_code+"',a.clinic_code)  AND a.eff_status='E' and a.practitioner_id= c.practitioner_id and c.language_id = 'en' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(c.practitioner_id) LIKE UPPER(NVL(?,c.practitioner_id)) OR upper(c.practitioner_name) LIKE UPPER(NVL(?,c.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))";


sql2="SELECT a.PRACTITIONER_ID practitioner_id, c.practitioner_name, c.PRACT_TYPE_DESC practitioner_type, c.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, AM_PRACT_ALL_SPLTY_VW b, am_practitioner_lang_vw c WHERE a.facility_id = b.facility_id AND a.facility_id = '"+facilityId+"' and a.practitioner_id= b.practitioner_id AND b.primary_speciality_code='"+splty+"' AND a.resource_class='P' and a.clinic_code = NVL('"+clinic_code+"',a.clinic_code)  AND a.eff_status='E' and a.practitioner_id= c.practitioner_id and c.language_id = 'en' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(c.practitioner_id) LIKE UPPER(NVL(?,c.practitioner_id)) AND upper(c.practitioner_name) LIKE UPPER(NVL(?,c.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))";

	

	}else if(executeQuery == "Q11")
	{
		
	/*

	Function Names: OA Schedules->Change Resource for Generated Schedule 

	File Names:     ChangePractitionerforGenSch.js


	*/
		sql="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic a,am_practitioner b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' and a.practitioner_id != '"+practitioner_id+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name)))   AND b.gender	LIKE NVL(UPPER(?),b.gender)   AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic a,am_practitioner b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' and a.practitioner_id != '"+practitioner_id+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))  AND UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))   AND b.gender	LIKE NVL(UPPER(?),b.gender)   AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";

	}else if(executeQuery == "Q12"){
		/*

		Function Names: OA Transactions->Create Wait List
						OA Schedules->Block Appointment Slots,Block/Lift/Cancel Schedule,Change Resource for Generated Schedule,,Duty Roster for Resources
						OA Admin Setup->Purge Schedule Records
						OA Queries->Appointment for a Resource ,Appointments for Patients,Block on Appointments,Locations for a day,Location Schedule
						OA Schedules->Setup Daily Schedule 
						OA Transactions->Transfer/Cancel Appointment 
						OA Schedules->Transfer Location Schedule 
						OA Transactions->Schedule Appointments & Manage Wait List

		File Names:		ApptWaitList.js
						Blockapptslots.js
						BlockLiftCancelSch.js
						ChangePractitionerforGenSch.js
						PractDutyRoster.js
						Purgeschedulerecords.js
						QryApptforPractCriteria.js
						QueryApptForPatient.js
						QueryBlockAppt.js
						QueryLocnForDay.js
						QueryLocnSchedule.js
						Scheduling.js
						TransferCancelAppointment.js
						TransferClinicSch.js
						Validate.js
						WaitListMgmt.js

		*/

 
   /*Below query was commented by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
   
       // sql="SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, am_practitioner_lang_vw b ";
		
		 /*Below query was added by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
		 
		sql="SELECT DISTINCT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM am_practitioner_lang_vw b,  am_pract_all_splty_vw c RIGHT OUTER JOIN op_pract_for_clinic a on a.practitioner_id = c.PRACTITIONER_ID ";

		if(obj.name!="to"){ 
		
		/*Below query was commented by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
		
		//sql=sql+"WHERE a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND a.resource_class='P'";
			
			/*Below query was added by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
		sql=sql+" WHERE a.facility_id='"+facilityId+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND (UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code))  or  UPPER (c.primary_speciality_code) LIKE UPPER (NVL (REPLACE ('"+splty+"', '%', ''), c.primary_speciality_code))) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name)))  AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND b.eff_status = 'E' AND a.resource_class='P' ";
		//modified by N Munisekhar against JD-CRF-0185 [IN041355]
		if(clinic_code!=undefined && clinic_code!="" && clinic_code != null){
			sql=sql+" AND a.clinic_code='"+clinic_code+"'";
		}
		
		}else{ 
			sql=sql+"WHERE a.facility_id='"+facilityId+"'  and a.practitioner_id != '"+practitioner_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND b.eff_status = 'E' AND a.resource_class='P'";
			//modified by N Munisekhar against JD-CRF-0185 [IN041355]
			if(clinic_code!=undefined && clinic_code!="" && clinic_code != null){
				sql=sql+" AND a.clinic_code='"+clinic_code+"'";
			}
		}
		
		/*Below query was commented by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
		
		//sql2="SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, am_practitioner_lang_vw b ";
		
		sql2="SELECT DISTINCT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM am_practitioner_lang_vw b,  am_pract_all_splty_vw c  RIGHT OUTER JOIN op_pract_for_clinic a on a.practitioner_id = c.PRACTITIONER_ID ";

		if(obj.name!="to"){
		
		 /*Below query was added by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
		 
			//sql2=sql2+"WHERE a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND a.resource_class='P'";
			
			/*Below query was added by venkatesh.S on  03-Oct-2012 against KAUH-SCF-0105 [IN035411] */
			
			sql2=sql2+"WHERE a.facility_id='"+facilityId+"' AND a.practitioner_id = b.practitioner_id  and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND (UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code))  or  UPPER (c.primary_speciality_code) LIKE UPPER (NVL (REPLACE ('"+splty+"', '%', ''), c.primary_speciality_code))) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E' 	  AND a.resource_class='P' AND B.eff_status='E'";
			//modified by N Munisekhar against JD-CRF-0185 [IN041355]
			if(clinic_code!=undefined && clinic_code!="" && clinic_code != null){
				sql=sql+" AND a.clinic_code='"+clinic_code+"'";
			}
		}else{ 
			sql2=sql2+"WHERE a.facility_id='"+facilityId+"' and a.practitioner_id != '"+practitioner_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND b.eff_status = 'E' AND a.resource_class='P'";
			//modified by N Munisekhar against JD-CRF-0185 [IN041355]
			if(clinic_code!=undefined && clinic_code!="" && clinic_code != null){
				sql=sql+" AND a.clinic_code='"+clinic_code+"'";
			}
		}			
	}else if(executeQuery == "Q6"){


		sql= "SELECT PRACTITIONER_ID practitioner_id, PRACTITIONER_NAME practitioner_name,	am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,a.position_code job_title ,gender	FROM  AM_PRACT_ALL_SPLTY_VW a	WHERE facility_id = '"+facilityId+"'   and SPECIALTY_CODE=nvl('"+splty+"',SPECIALTY_CODE) AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))    AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) 	AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) 	OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)))	AND  sex LIKE NVL(UPPER(?),sex) and upper(nvl(POSITION_CODE,'123')) like upper(nvl(?,nvl(POSITION_CODE,'123'))) " ;

		sql2= "SELECT PRACTITIONER_ID practitioner_id, PRACTITIONER_NAME practitioner_name,	am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,a.position_code job_title ,gender	FROM  AM_PRACT_ALL_SPLTY_VW a	WHERE facility_id = '"+facilityId+"'   and SPECIALTY_CODE=nvl('"+splty+"',SPECIALTY_CODE) AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))    AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) 	AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) 	AND UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)))	AND  sex LIKE NVL(UPPER(?),sex) and upper(nvl(POSITION_CODE,'123')) like upper(nvl(?,nvl(POSITION_CODE,'123'))) " ;

	}else if(executeQuery == "Q7")
	{
			sql="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";

			sql2="SELECT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and c.speciality_code = a.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
	
	}else if(executeQuery == "Q8")
	{		
		
		/*Below Query Modified by Senthil on 12-10-2011 incident[29200]*/
		
		sql="Select a.practitioner_id practitioner_id, initcap(b.practitioner_name) practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender from am_pract_for_facility a, am_practitioner_lang_vw b, op_clinic c, am_practitioner d  where b.practitioner_id = a.practitioner_id and d.practitioner_id = a.practitioner_id and language_id = '"+localeName+"' and a.eff_status = 'E' and d.eff_status = 'E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in   (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and   practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'" ;

		sql2="Select a.practitioner_id practitioner_id, initcap(b.practitioner_name) practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender from am_pract_for_facility a, am_practitioner_lang_vw b, op_clinic c, am_practitioner d  where b.practitioner_id = a.practitioner_id and d.practitioner_id = a.practitioner_id and language_id = '"+localeName+"' and a.eff_status = 'E' and d.eff_status = 'E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in   (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and   practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?, a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'" ;


	}else if(executeQuery == "Q13")
	{
		sql="SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, am_practitioner_lang_vw b WHERE a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND a.resource_class='P'";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, b.practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.PRIMARY_SPECIALITY_DESC primary_specialty, b.position_code job_title, b.gender FROM op_pract_for_clinic a, am_practitioner_lang_vw b WHERE a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123'))) AND a.eff_status='E' AND a.resource_class='P'"
	}else if(executeQuery == "Q14"){
			
			sql="SELECT DISTINCT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id  and c.speciality_code = a.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";

			sql2="SELECT DISTINCT a.PRACTITIONER_ID practitioner_id,b.practitioner_name,b.pract_type_desc practitioner_type,b.PRIMARY_SPECIALITY_DESC primary_specialty,b.position_code job_title,b.gender gender FROM AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b, op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id  and c.speciality_code = a.primary_speciality_code and nvl(c.pract_type, b.pract_type) = b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?, b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and b.gender LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.language_id = '"+localeName+"'";
	}
	/*Below Execute Condition Added Against JD-CRF-0184 [IN:041354] By Saanthaakumar*/
	else if(executeQuery == "Q15"){
		sql= "SELECT PRACTITIONER_ID practitioner_id, PRACTITIONER_NAME practitioner_name,	am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,a.position_code job_title ,gender	FROM  am_practitioner_vw a	WHERE facility_id = '"+facilityId+"' AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))    AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) 	AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) 	OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name)))	AND  sex LIKE NVL(UPPER(?),sex) and upper(nvl(POSITION_CODE,'123')) like upper(nvl(?,nvl(POSITION_CODE,'123'))) " ;
			
	}


	var xmlDoc= "";
	var xmlHttp= new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +encodeURIComponent(practName_FName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +splty+ "\""; // Thursday, February 18, 2010 19335 Venkat S.
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);
	eval(practSearch(encodeURIComponent(practName_FName),encodeURIComponent(practName_FValue),splty,responseText));	
	//return;
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
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

/*script called in Transfer Cancel Appointment function for enabling not iden pract check box*/

function chk_pract_value(obj)
{
	var function_id=document.forms[0].function_id.value
	var called_for=parent.frames[1].document.forms[0].called_for.value ;
if(function_id !="BULK_CANCEL" && called_for !="Link" )
{

	if(obj.value !="")
	{
		document.forms[0].not_iden_pract.value="";
		document.forms[0].not_iden_pract.disabled=true;
	}else
	{
		document.forms[0].not_iden_pract.value="";
		document.forms[0].not_iden_pract.disabled=false;
	}
}

}
