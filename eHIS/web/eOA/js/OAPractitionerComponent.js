// Created to generalize Practitioner Lookup by Venkatesh on 23/04/2007

function getPractitioner(obj,target,facility_id,splty,pract_type,clinic_code,practitioner_id,executeQuery)
{

var practName_FName="";
var practName_FValue="";
var practId_FName="";
practName_FName=target.name;
practName_FValue=target.value;

var sql="";
var sql2="";

var facilityId = facility_id;


if(executeQuery == "Q1")
	{

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
		
		sql="select PRACTITIONER_ID practitioner_id,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)  practitioner_name,am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty,POSITION_CODE job_title,gender gender from am_practitioner_vw  where pract_type =nvl('"+pract_type+"',pract_type)  AND UPPER(pract_type)   LIKE UPPER(NVL(?,pract_type)) AND UPPER(primary_speciality_code)   LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id)   LIKE UPPER(NVL(?,practitioner_id)) OR UPPER(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) )   LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) )))   AND gender LIKE NVL(UPPER(?),gender)    AND UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) order by PRACTITIONER_NAME ";

		sql2="select PRACTITIONER_ID practitioner_id,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)  practitioner_name,am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty,POSITION_CODE job_title,gender gender from am_practitioner_vw  where pract_type =nvl('"+pract_type+"',pract_type)  AND UPPER(pract_type)   LIKE UPPER(NVL(?,pract_type)) AND UPPER(primary_speciality_code)   LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id)   LIKE UPPER(NVL(?,practitioner_id)) AND UPPER(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) )   LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) )))   AND gender LIKE NVL(UPPER(?),gender)   AND UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) order by PRACTITIONER_NAME ";

	}
	else if (executeQuery == "Q2")
	{

	/*

	Function Names: OA Reports->Reprint Appointment Slips
					OA Transactions->Schedule Appointments

	File Names:		repReprintApptSlips.js
					Validate.js


	*/

		sql= "SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty,b.POSITION_CODE job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE a.operating_facility_id = '"+facilityId+"'  AND a.practitioner_id = b.practitioner_id  	AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))    AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) 	AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) 	OR UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))	AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) order by b.PRACTITIONER_NAME " ; 

		sql2= "SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+localeName+"',2) primary_specialty,b.POSITION_CODE job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner_vw b 	WHERE a.operating_facility_id = '"+facilityId+"' 	 AND a.practitioner_id = b.practitioner_id  	AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))    AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) 	AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) 	AND UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))	AND b.gender LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) order by b.PRACTITIONER_NAME" ; 

	}
	else if(executeQuery == "Q3")
	{
		
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
		
		sql="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.eff_status ='E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'  and(c.speciality_code = b.primary_speciality_code or c.speciality_code in  (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper( am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.eff_status ='E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'  and(c.speciality_code = b.primary_speciality_code or c.speciality_code in  (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper( am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

	

	}
	else if (executeQuery == "Q4")
	{

	/*

	Function Names: OA Transactions->Transfer/Cancel Appointment 

	File Names:     TransferCancelAppointment.js


	*/

		sql="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner b 	WHERE a.operating_facility_id = '"+facilityId+"' AND a.eff_status ='E' AND a.practitioner_id = b.practitioner_id  	AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	OR UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))	AND b.gender	LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123')))";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender	FROM am_pract_for_facility_vw a, am_practitioner b 	WHERE a.operating_facility_id = '"+facilityId+"' AND a.eff_status ='E'	 AND a.practitioner_id = b.practitioner_id  AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	AND UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))	AND b.gender	LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123')))";

	}
	else if(executeQuery == "Q5")
	{
		
	/*

	Function Names: OA Transactions->Create Wait List & Manage Wait List

	File Names:     ApptWaitList.js
				    WaitListMgmt.js


	*/

		sql = "SELECT a.facility_id, a.practitioner_id practitioner_id,       AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1') practitioner_name,	   AM_GET_DESC.AM_PRACT_TYPE(a.PRACT_TYPE,'"+localeName+"','1') practitioner_type,a.specialty_code, AM_GET_DESC.AM_SPECIALITY(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"','2') primary_specialty,a.sex gender,      a.pract_desgnation job_title FROM am_pract_all_splty_vw a,ip_nursing_unit_for_pract e WHERE a.facility_id='"+facilityId+"' AND a.specialty_code = '"+splty+"' AND e.facility_id = a.facility_id   AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')) LIKE UPPER (NVL (?, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')))) AND a.sex LIKE (?) AND (a.pract_desgnation LIKE (?) OR a.pract_desgnation IS NULL) AND 1 = 1";
	}
	else if (executeQuery == "Q6")
	{
	
	/*

	Function Names: OA Transactions->Manage Wait List

	File Names:     WaitListMgmt.js


	*/
		
		sql = "select A.FACILITY_ID, A.PRACTITIONER_ID practitioner_id, B.PRACTITIONER_NAME practitioner_name, C.desc_sysdef practitioner_type, A.SPECIALTY_CODE, D.SHORT_DESC primary_specialty, A.GENDER gender, A.PRACT_DESGNATION job_title FROM AM_PRACT_ALL_SPLTY_VW A, AM_PRACTITIONER B, am_pract_type C, am_speciality D,ip_nursing_unit_for_pract e WHERE  A.FACILITY_ID = '"+facilityId+"' AND A.SPECIALTY_CODE = '"+splty+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND C.PRACT_TYPE = B.PRACT_TYPE AND D.SPECIALITY_CODE = A.SPECIALTY_CODE AND e.facility_id = a.facility_id and e.NURSING_UNIT_CODE = '"+clinic_code+"' AND e.PRACTITIONER_ID = a.PRACTITIONER_ID and b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR   UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  a.sex LIKE (?) AND (a.PRACT_DESGNATION LIKE (?) OR a.PRACT_DESGNATION IS NULL) AND 1 = 1";

	}
	else if (executeQuery == "Q7")
	{
	
	/*

	Function Names: OA Transactions->Bulk Transfer Appointments

	File Names:     BulkTransferAppointment.js


	*/
		
		sql="SELECT PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,position_code job_title,gender	FROM AM_PRACT_ALL_SPLTY_VW 	WHERE facility_id = '"+facilityId+"' AND practitioner_id = practitioner_id  and primary_speciality_code='"+splty+"' 	AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))    AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) 	AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) 	OR UPPER(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1))))	AND gender	LIKE NVL(UPPER(?),gender) AND UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))";

		sql2="SELECT PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,position_code job_title,gender	FROM AM_PRACT_ALL_SPLTY_VW 	WHERE facility_id = '"+facilityId+"'  AND practitioner_id = practitioner_id and primary_speciality_code='"+splty+"'  AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))    AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) 	AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) 	AND UPPER(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1))))	AND gender	LIKE NVL(UPPER(?),gender) AND UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))";
	}
	else if (executeQuery == "Q8")
	{

	/*

	Function Names: OA Transactions->Bulk Transfer Appointments

	File Names:     BulkTransferAppointment.js


	*/
		sql="SELECT b.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender  FROM AM_PRACT_ALL_SPLTY_VW b,op_clinic c where c.eff_status ='E' and b.facility_id = '"+facilityId+"' and c.facility_id = b.facility_id and c.clinic_code = '"+clinic_code+"'  and c.speciality_code = b.primary_speciality_code AND c.speciality_code ='"+splty+"' and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123')))";

		sql2="SELECT b.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender  FROM AM_PRACT_ALL_SPLTY_VW b ,op_clinic c where c.eff_status ='E'  and b.facility_id = '"+facilityId+"' and c.facility_id = b.facility_id and c.clinic_code = '"+clinic_code+"'  and c.speciality_code = b.primary_speciality_code AND c.speciality_code ='"+splty+"'  and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123')))";

	}
	else if(executeQuery == "Q9")
	{

	/*

	Function Names: OA Transactions->Bulk Transfer Appointments

	File Names:     BulkTransferAppointment.js


	*/


		sql="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2)practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender	  FROM op_pract_for_clinic a, AM_PRACT_ALL_SPLTY_VW b WHERE a.practitioner_id= b.practitioner_id  AND a.facility_id=b.facility_id AND a.facility_id = '"+facilityId+"' and b.primary_speciality_code='"+splty+"'  AND a.resource_class='P' and a.clinic_code = NVL('"+clinic_code+"',a.clinic_code)  AND a.eff_status='E' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	  OR UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND b.gender	LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender  FROM op_pract_for_clinic a, AM_PRACT_ALL_SPLTY_VW b 	  WHERE a.practitioner_id= b.practitioner_id  AND a.facility_id = '"+facilityId+"'	AND a.facility_id=b.facility_id  and b.primary_speciality_code='"+splty+"'  AND a.resource_class='P' and a.clinic_code = NVL('"+clinic_code+"',a.clinic_code)  AND a.eff_status='E' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE UPPER(NVL(?,b.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND	 UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) AND b.gender	LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))";

	}
	else if(executeQuery == "Q10")
	{
		
	/*

	Function Names: OA Schedules->Change Resource for Generated Schedule 

	File Names:     ChangePractitionerforGenSch.js


	*/
		sql = "SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.eff_status ='E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and(c.speciality_code = b.primary_speciality_code or c.speciality_code in  (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and b.practitioner_id != '"+practitioner_id+"' and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123')))";

		sql2 = "SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.eff_status ='E' and a.facility_id = '"+facilityId+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'  and(c.speciality_code = b.primary_speciality_code or c.speciality_code in "+" (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and b.practitioner_id != '"+practitioner_id+"' and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) AND upper(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)))) and b.gender	LIKE NVL(UPPER(?),b.gender) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123')))";
	}
	else if(executeQuery == "Q11")
	{
		
	/*

	Function Names: OA Schedules->Change Resource for Generated Schedule 

	File Names:     ChangePractitionerforGenSch.js


	*/
		sql="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic a,am_practitioner b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' and a.practitioner_id != '"+practitioner_id+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name)))   AND b.gender	LIKE NVL(UPPER(?),b.gender)   AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";

		sql2="SELECT a.PRACTITIONER_ID practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,	am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic a,am_practitioner b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.clinic_code='"+clinic_code+"' and a.practitioner_id != '"+practitioner_id+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))  AND UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))   AND b.gender	LIKE NVL(UPPER(?),b.gender)   AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";

	}
	else if(executeQuery == "Q12")
	{
	
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
	
		sql="SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic_vw a,am_practitioner_vw b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.resource_class='P' and a.clinic_code='"+clinic_code+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   OR UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))   AND  b.gender	LIKE NVL(UPPER(?),b.gender)  AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";



		sql2="SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1) practitioner_name,am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"',2) primary_specialty,b.position_code job_title,b.gender gender FROM op_pract_for_clinic_vw a,am_practitioner_vw b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facilityId+"' AND a.resource_class='P' and a.clinic_code='"+clinic_code+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   AND UPPER(am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))LIKE UPPER(NVL(?,am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1))))   AND b.gender	LIKE NVL(UPPER(?),b.gender) AND UPPER(NVL(b.position_code,'123')) LIKE UPPER(NVL(?,NVL(b.position_code,'123')))  AND a.eff_status='E'";
	}
	else if(executeQuery == "Q13")
	{
	
	/*

	Function Names: OA Queries->Appointments for Patients,Block on Appointments,Locations for a day,Location Schedule

	File Names:		QueryApptForPatient.js
					QueryBlockAppt.js
					QueryLocnForDay.js
					QueryLocnSchedule.js


	*/
	
		sql="Select practitioner_id practitioner_id ,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name ,am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty,position_code job_title,gender gender FROM am_practitioner_vw  where eff_status = 'E' and upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)))) and gender	LIKE NVL(UPPER(?),gender) and upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))";

		sql2="Select practitioner_id practitioner_id,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1) practitioner_name ,am_get_desc.am_pract_type(pract_type,'"+localeName+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+localeName+"',2) primary_specialty, position_code job_title,gender gender FROM am_practitioner_vw  where eff_status = 'E' and upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)) like upper(nvl(?,am_get_desc.am_practitioner(practitioner_id,'"+localeName+"',1)))) and gender	LIKE NVL(UPPER(?),gender) and upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))";

	}


	//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);	
	eval(practSearch(practName_FName,practName_FValue,responseText));
	//return;



}

async function practSearch(practName_FName,practName_FValue,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
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
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}


