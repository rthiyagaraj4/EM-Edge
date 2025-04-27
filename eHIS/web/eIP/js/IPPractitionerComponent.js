// Modified to Practitioner Lookup by Sridhar on 16 FEB 2004 
function getPractitioner(obj, target, facility_id, splty,nursing_unit_code,executeQuery)
{
	var tit			= "";
	var FirstSql	= "";
	var SecondSql	= "";
		
	target.value			= trimString(target.value);
	var practitionerName	= target.name;
	var practitionerValue	= target.value;
	if(executeQuery == "Q1")
	{
		/*
		*	Function Name	-	IP Transactions -	Create Booking 
													Confirm Booking 
													Revise Booking
		*	File Name		-	eIP/jsp/AddModifyConfirmBooking.jsp
								eIP/js/Booking1.js
								eIP/js/ReviseBooking.js
		*/
		FirstSql	= "select a.facility_id, A.PRACTITIONER_ID practitioner_id, b.practitioner_name,b.pract_type_desc practitioner_type, A.SPECIALTY_CODE, d.short_desc primary_specialty,a.gender, a.PRACT_TYPE job_title FROM am_pract_all_splty_vw A, am_practitioner_lang_vw b, am_speciality_lang_vw d, am_pract_for_facility e WHERE A.FACILITY_ID = '"+facility_id+"' AND A.SPECIALTY_CODE = '"+splty+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  a.sex LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) AND 1 = 1 AND A.FACILITY_ID=E.FACILITY_ID AND B.PRACTITIONER_ID=E.PRACTITIONER_ID AND B.EFF_STATUS=E.EFF_STATUS";

		SecondSql	= "select a.facility_id, A.PRACTITIONER_ID practitioner_id, b.practitioner_name,b.pract_type_desc practitioner_type, A.SPECIALTY_CODE, d.short_desc primary_specialty,a.gender, a.PRACT_TYPE job_title FROM am_pract_all_splty_vw A, am_practitioner_lang_vw b, am_speciality_lang_vw d, am_pract_for_facility e WHERE A.FACILITY_ID = '"+facility_id+"' AND A.SPECIALTY_CODE = '"+splty+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  a.sex LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) AND 1 = 1 AND A.FACILITY_ID=E.FACILITY_ID AND B.PRACTITIONER_ID=E.PRACTITIONER_ID AND B.EFF_STATUS=E.EFF_STATUS";


	}
	else if(executeQuery == "Q2" || executeQuery == "Q3") 
	{
		/*
		*	Function Name	-	IP Transactions -	TPO criteria page 
													Practitioner Transfer  
													Master CodeSetup
		*	File Name		-	eIP/jsp/IPLookupCriteriaForAmendTrn.jsp
								eIP/jsp/PractitionerComponent.jsp
								eIP/js/IPQueryCommon.js
								eIP/js/NursUnitPract.js
								eIP/js/PractInComplete.js
		*/
		/*Saturday, OCT 20, 2009 */
			   //FirstSql	="Select a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, B.POSITION_CODE  job_title from AM_PRACT_FOR_FACILITY a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id= '"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and b.pract_type LIKE (?) AND b.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";
		
				//SecondSql	="Select a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, B.POSITION_CODE  job_title from AM_PRACT_FOR_FACILITY a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE a.facility_id= '"+facility_id+"' AND a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' and b.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and b.pract_type LIKE (?) AND b.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";
			/*Saturday, June 20, 2009 */
				/*Saturday, OCT 20, 2009 */
				//	SecondSql	="SELECT DISTINCT a.practitioner_id practitioner_id, b.practitioner_name practitioner_name ,b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty ,DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,b.position_code job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_all_splty_vw d WHERE a.facility_id = '"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)  AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code)) and (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (d.practitioner_name) LIKE UPPER (NVL (?, d.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+facility_id+"',d.facility_id) ";
				// phani FirstSql	="SELECT a.practitioner_id practitioner_id, am_get_desc.am_practitioner(b.practitioner_id,'"+localeName+"',1)practitioner_name,am_get_desc.am_pract_type(b.pract_type,'"+localeName+"',2)practitioner_type,am_get_desc.am_speciality(d.speciality_code,'"+localeName+"',2) primary_specialty, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, b.position_code job_title FROM am_pract_for_facility a, am_practitioner b, am_speciality d  WHERE a.facility_id = '"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND b.primary_speciality_code = d.speciality_code AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.eff_status ='E'";

				FirstSql	="Select a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, B.POSITION_CODE  job_title from AM_PRACT_FOR_FACILITY a, am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.primary_speciality_code = d.speciality_code and a.practitioner_id = b.practitioner_id AND a.facility_id= '"+facility_id+"' and b.pract_type LIKE (?) and b.language_id = '"+localeName+"' and  d.language_id = '"+localeName+"'  AND b.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) AND b.eff_status ='E' AND B.EFF_STATUS=A.EFF_STATUS";
				
				/*Monday, August 16, 2010 , changed UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id) to UPPER (b.practitioner_id) LIKE UPPER (nvl(?,b.practitioner_id) AND d.practitioner_name) LIKE UPPER (NVL (?, d.practitioner_name) to b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name) for SRR20056-SCF-5000 [IN:23246] since am_pract_all_splty_vw contains only english.*/
				SecondSql	="SELECT DISTINCT a.practitioner_id practitioner_id, b.practitioner_name practitioner_name ,b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty ,DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,b.position_code job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_all_splty_vw  d WHERE a.practitioner_id = b.practitioner_id  AND a.facility_id = '"+facility_id+"' AND b.pract_type LIKE (?) AND b.language_id = '"+localeName+"'    AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code)) and (UPPER (b.practitioner_id) LIKE UPPER (nvl(?,b.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+facility_id+"',d.facility_id) AND B.EFF_STATUS=A.EFF_STATUS";
		

	}
	/*else if(executeQuery == "Q3")
	{
		/*
		*	Function Name	- IP Transactions - Criteria
		*	File Name		- eIP/jsp/InpatientLookupCriteria.jsp
		*/
		/*FirstSql	= "Select a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')  practitioner_name,d.desc_sysdef practitioner_type,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2')  primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+localeName+"','1')  job_title from AM_PRACT_FOR_FACILITY a, am_practitioner b, am_pract_type d    WHERE a.practitioner_id = b.practitioner_id and   b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL) AND facility_id= '"+facility_id+"'";

		SecondSql	= "Select a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')  practitioner_name,d.desc_sysdef practitioner_type,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2')  primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+localeName+"','1')  job_title from AM_PRACT_FOR_FACILITY a, am_practitioner b, am_pract_type d    WHERE a.practitioner_id = b.practitioner_id and   b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and   UPPER(AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','1')) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.POSITION_CODE LIKE (?) OR b.POSITION_CODE IS NULL) AND facility_id= '"+facility_id+"'";
	}*/
	else if(executeQuery == "Q4")
	{

		/*
		*	Function Name	- IP Transactions - 
		*	File Name		- eIP/jsp/PractitionerComponent.jsp
		*/
		FirstSql = " SELECT a.Practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty , B.POSITION_DESC job_title FROM AM_PRACT_FOR_FACILITY a, AM_PRACTITIONER_lang_vw b, AM_SPECIALITY_lang_vw d WHERE a.facility_id='"+facility_id+"' AND b.pract_type IN ('MD','SG','PS','DN') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = d.speciality_code and b.language_id = '"+localeName+"' and d.language_id = '"+localeName+"' and b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and  b.EFF_STATUS ='E' AND B.EFF_STATUS=A.EFF_STATUS";

		//SecondSql = " SELECT a.Practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, B.POSITION_DESC job_title FROM AM_PRACT_FOR_FACILITY a, AM_PRACTITIONER_lang_vw b, AM_SPECIALITY_lang_vw d WHERE a.facility_id='"+facility_id+"' AND b.pract_type IN ('MD','SG','PS','DN') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = d.speciality_code and b.language_id = '"+localeName+"' and d.language_id = '"+localeName+"' and b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) ";

		/*Saturday, June 20, 2009*/
		SecondSql = "SELECT distinct a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_speciality, b.position_desc job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_all_splty_vw d WHERE a.facility_id = '"+facility_id+"' AND b.pract_type IN ('MD', 'SG', 'PS', 'DN') AND a.practitioner_id = b.practitioner_id  AND b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)  AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code))  AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+facility_id+"',d.facility_id) AND B.EFF_STATUS=A.EFF_STATUS "
	}
	else if(executeQuery == "Q5")
	{

		/*
		*	Function Name	- IP Transactions - Confirm/Cancel Transfer 
												Admit Patient 
												Discharge Patient 
												Record Leave 
												Discharge Advice 
												Tfr Practitioner
		*	File Name		-	eIP/jsp/CancelTransferPatientOutMain.jsp
								eIP/jsp/ConfirmBedClassChangeDetails.jsp
								eIP/js/AdmitPatient1.js
								eIP/js/AssignBedDetail.js
								eIP/js/BedBookingTransfer.js
								eIP/js/ConfirmCancelTransfer.js
								eIP/js/DischargeAdvice.js
								eIP/js/DischargePatient.js
								eIP/js/IPPractitionerComponent.js
								eIP/js/RecordInpatientLeave.js
								eIP/js/TransferPatOccupancyDtls.js
								eIP/js/TransferPractitioner.js
		*/

		
		if(nursing_unit_code!='')
			FirstSql	= "SELECT distinct a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, c.gender, c.PRACT_TYPE job_title FROM IP_NURSING_UNIT_FOR_PRACT a, am_practitioner_lang_vw b, am_pract_all_splty_vw c, am_speciality_lang_vw d, am_pract_for_facility e  WHERE a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+nursing_unit_code+"'  and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND a.facility_id = c.facility_id AND a.practitioner_id = c.practitioner_id AND c.SPECIALTY_CODE = '"+splty+"' AND c.SPECIALTY_CODE = d.speciality_code /* and b.primary_speciality_code = d.speciality_code */ and d.language_id = '"+localeName+"' AND c.pract_type LIKE (?) AND c.primary_speciality_code LIKE UPPER (?) AND (UPPER (c.practitioner_id) LIKE UPPER (NVL (?, c.practitioner_id)) OR UPPER (b.practitioner_name) LIKE  UPPER (NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(c.POSITION_CODE,'123')) like upper(nvl(?,nvl(c.POSITION_CODE,'123'))) AND E.EFF_STATUS=B.EFF_STATUS AND E.PRACTITIONER_ID=B.PRACTITIONER_ID AND a.facility_id = e.facility_id";
		else
			FirstSql	= "SELECT distinct a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, c.gender, c.PRACT_TYPE job_title FROM IP_NURSING_UNIT_FOR_PRACT a, am_practitioner_lang_vw b, am_pract_all_splty_vw c, am_speciality_lang_vw d, am_pract_for_facility e  WHERE a.facility_id = '"+facility_id+"'  and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND a.facility_id = c.facility_id AND a.practitioner_id = c.practitioner_id AND c.SPECIALTY_CODE = '"+splty+"' AND c.SPECIALTY_CODE = d.speciality_code /* and b.primary_speciality_code = d.speciality_code */ and d.language_id = '"+localeName+"' AND c.pract_type LIKE (?) AND c.primary_speciality_code LIKE UPPER (?) AND (UPPER (c.practitioner_id) LIKE UPPER (NVL (?, c.practitioner_id)) OR UPPER (b.practitioner_name) LIKE  UPPER (NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(c.POSITION_CODE,'123')) like upper(nvl(?,nvl(c.POSITION_CODE,'123'))) AND E.EFF_STATUS=B.EFF_STATUS AND E.PRACTITIONER_ID=B.PRACTITIONER_ID AND a.facility_id = e.facility_id";

	
		if(nursing_unit_code!='')
			SecondSql	= "SELECT distinct a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, c.gender, c.PRACT_TYPE job_title FROM IP_NURSING_UNIT_FOR_PRACT a, am_practitioner_lang_vw b, am_pract_all_splty_vw c, am_speciality_lang_vw d, am_pract_for_facility e WHERE a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+nursing_unit_code+"'  and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND a.facility_id = c.facility_id AND a.practitioner_id = c.practitioner_id AND c.SPECIALTY_CODE = '"+splty+"' AND  c.SPECIALTY_CODE = d.speciality_code /* AND b.primary_speciality_code = d.speciality_code */ and d.language_id = '"+localeName+"' AND c.pract_type LIKE (?) AND c.primary_speciality_code LIKE UPPER (?) AND (UPPER (c.practitioner_id) LIKE UPPER (NVL (?, c.practitioner_id)) AND UPPER (b.practitioner_name) LIKE  UPPER (NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(c.POSITION_CODE,'123')) like upper(nvl(?,nvl(c.POSITION_CODE,'123'))) AND E.EFF_STATUS=B.EFF_STATUS AND E.PRACTITIONER_ID=B.PRACTITIONER_ID AND a.facility_id = e.facility_id";
		else
			SecondSql	= "SELECT distinct a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, d.short_desc primary_specialty, c.gender, c.PRACT_TYPE job_title FROM IP_NURSING_UNIT_FOR_PRACT a, am_practitioner_lang_vw b, am_pract_all_splty_vw c, am_speciality_lang_vw d, am_pract_for_facility e WHERE a.facility_id = '"+facility_id+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+localeName+"' AND a.facility_id = c.facility_id AND a.practitioner_id = c.practitioner_id AND c.SPECIALTY_CODE = '"+splty+"' AND  c.SPECIALTY_CODE = d.speciality_code /* AND b.primary_speciality_code = d.speciality_code */ and d.language_id = '"+localeName+"' AND c.pract_type LIKE (?) AND c.primary_speciality_code LIKE UPPER (?) AND (UPPER (c.practitioner_id) LIKE UPPER (NVL (?, c.practitioner_id)) AND UPPER (b.practitioner_name) LIKE  UPPER (NVL(?, b.practitioner_name))) AND b.gender LIKE (?) AND upper(nvl(c.POSITION_CODE,'123')) like upper(nvl(?,nvl(c.POSITION_CODE,'123'))) AND E.EFF_STATUS=B.EFF_STATUS AND E.PRACTITIONER_ID=B.PRACTITIONER_ID AND a.facility_id = e.facility_id";
	}
	else if(executeQuery == "Q6")
	{ 

		/*
		*	Function Name	- IP Transactions - Swap patient Bed
		*	File Name		- eIP/js/SwapPatientBeds.js
		*/

		FirstSql	= "Select b.practitioner_id, a.practitioner_name, a.pract_type_desc practitioner_type, d.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title  from am_practitioner_lang_vw a, ip_nursing_unit_For_pract b, am_speciality_lang_vw d, am_pract_for_facility e where a.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and  b.facility_id = '"+facility_id+"' and b.nursing_unit_code='"+nursing_unit_code+"' AND a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123'))) and a.EFF_STATUS='E' AND A.EFF_STATUS=E.EFF_STATUS AND A.PRACTITIONER_ID=E.PRACTITIONER_ID AND B.FACILITY_ID=E.FACILITY_ID "; 

		//SecondSql	= "Select b.practitioner_id, a.practitioner_name, a.pract_type_desc practitioner_type, d.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, a.POSITION_CODE job_title  from am_practitioner_lang_vw a, ip_nursing_unit_For_pract b, am_speciality_lang_vw d where a.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and  facility_id = '"+facility_id+"' and b.nursing_unit_code='"+nursing_unit_code+"' AND a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' AND a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  AND  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name)) ) AND  a.gender LIKE (?) AND upper(nvl(a.POSITION_CODE,'123')) like upper(nvl(?,nvl(a.POSITION_CODE,'123')))";
		/*Saturday, June 20, 2009*/
		
		SecondSql = "SELECT DISTINCT b.practitioner_id practitioner_id, a.practitioner_name practitioner_name,a.pract_type_desc practitioner_type,am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty,DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,a.position_code job_title FROM am_practitioner_lang_vw a,ip_nursing_unit_for_pract b,am_pract_all_splty_vw d, am_pract_for_facility e WHERE a.language_id = '"+localeName+"' AND a.practitioner_id = b.practitioner_id AND b.facility_id = '"+facility_id+"' AND b.nursing_unit_code = '"+nursing_unit_code+"' AND a.pract_type LIKE (?) AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = b.facility_id AND B.FACILITY_ID=E.FACILITY_ID  AND A.EFF_STATUS=E.EFF_STATUS AND A.PRACTITIONER_ID=E.PRACTITIONER_ID";

		//SecondSql	="SELECT DISTINCT a.practitioner_id practitioner_id, b.practitioner_name practitioner_name ,b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty ,DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,b.position_code job_title FROM am_pract_for_facility a, am_practitioner_lang_vw b, am_pract_all_splty_vw d WHERE a.facility_id = '"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)  AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code)) AND UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (d.practitioner_name) LIKE UPPER (NVL (?, d.practitioner_name)) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+facility_id+"',d.facility_id) ";

	}
	else if(executeQuery == "Q7")
	{ 

	/*
		*	Function Name	- Cancel Discharge
		*	
		*/

		FirstSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.primary_speciality_code primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_pract_for_facility e WHERE b.language_id = '"+localeName+"' and  b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND  upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and b.EFF_STATUS='E' AND B.EFF_STATUS=E.EFF_STATUS AND B.PRACTITIONER_ID=E.PRACTITIONER_ID";		
		

		//SecondSql = "SELECT b.Practitioner_id practitioner_id, b.Practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, b.primary_speciality_code primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, b.POSITION_CODE job_title FROM am_practitioner_lang_vw b, am_speciality_lang_vw d WHERE b.language_id = '"+localeName+"'  and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?, b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?, b.practitioner_name))) AND  b.gender LIKE (?) AND upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123')))";

		/*Saturday, June 20, 2009*/
		SecondSql = "SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type,am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_speciality , DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,b.position_code job_title FROM am_practitioner_lang_vw b, am_pract_all_splty_vw d, am_pract_for_facility e WHERE b.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code))  AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER  (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER  (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+facility_id+"',d.facility_id) AND D.FACILITY_ID=E.FACILITY_ID AND B.EFF_STATUS=E.EFF_STATUS AND B.PRACTITIONER_ID=E.PRACTITIONER_ID";

	}

	
//	var xmlDoc		= new ActiveXObject( "Microsoft.XMLDom" );
//	var xmlHttp		= new ActiveXObject( "Microsoft.XMLHTTP" );
//	xmlStr	="<root><SEARCH ";
//	xmlStr += " practName_FName=\"" + encodeURIComponent(practitionerName) + "\"";
//	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
//	xmlStr += " practId_FName=\"" + practitionerName + "\"";
//	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
//	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
//	xmlStr += " practitioner_type=\"" + "" + "\"";
//	xmlStr += " specialty_code=\"" + splty+ "\"";
//	xmlStr += " job_title=\"" + "" + "\"";
//	xmlStr += " gender=\"" + "" + "\"";
//	xmlStr +=" /></root>";
//	xmlDoc.loadXML( xmlStr );
//	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false );
//	xmlHttp.send(xmlDoc);
//	responseText=xmlHttp.responseText;
//	responseText = trimString(responseText);
//	eval(responseText);
//	return; 
	
//	<---- VEDESH A D 21/05/24 ---->
	xmlStr	="<root><SEARCH "+" practName_FName=\"" + encodeURIComponent(practitionerName) + "\""+" practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\""+" practId_FName=\"" + practitionerName + "\""+" sql=\"" +escape(FirstSql)+ "\""+" sqlSec=\"" +escape(SecondSql)+ "\""+" practitioner_type=\"" + "" + "\""+" specialty_code=\"" + splty+ "\""+" job_title=\"" + "" + "\""+" gender=\"" + "" + "\""+" /></root>";
    // Parse the XML string
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
    // Create an XMLHttpRequest object
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eAM/jsp/callGeneralPractitionerSearch.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    // Send the XML
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    // Handle the response
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText); 
    eval(practSearch(encodeURIComponent(practitionerName),encodeURIComponent(practitionerValue),splty,responseText));	  
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "0" ;
	var dialogHeight= "70vh" ;
	var dialogWidth	= "50vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="50vw";
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


/*Below line added for GHL-CRF-0340*/	
function Specialitycheck(nursing_unitcode,facilityid,splcode){  

			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH nursing_unitcode=\""+nursing_unitcode+"\" facilityid=\""+facilityid+"\" splcode=\""+splcode+"\" step='SpecialityCode'/></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			//alert("responseText===>"+responseText);
			responseText = trimString(responseText)
			eval(responseText)
	
}
function Practitionercheck(nursing_unitcode,facilityid,practid){  
	/*	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
		var xmlHttp=new ActiveXObject("Microsoft.XMLHTTP")
		xmlStr ="<root><SEARCH nursing_unitcode=\""+nursing_unitcode+"\" facilityid=\""+facilityid+"\" practid=\""+practid+"\" step='Practitionercheck'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		//alert("responseText===>"+responseText);
		responseText = trimString(responseText)
		eval(responseText) */
		
		// Commented ActiveXObject dependent code and written alternate for it, for EDGE Standardization.
		
		var xmlHttp = new XMLHttpRequest();	
		xmlStr = "<root><SEARCH nursing_unitcode=\"" + nursing_unitcode + "\" facilityid=\"" + facilityid + "\" practid=\"" + practid + "\" step='Practitionercheck'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open("POST", "BookingGetExpDaysDate.jsp", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;

		responseText = trimString(responseText);
		eval(responseText);

	
}
//End GHL-CRF-0340
