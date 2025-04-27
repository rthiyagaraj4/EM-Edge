// Created to generalise Practitioner LookUP by Marimuthu on 23/04/2007
async function getPractitioner(obj,target,fac_Id,splty,pract_type,clinic_code,trtmt_area_code,callfunc,res_type,visitadmtype,executeQuery) {

	


	var firstSql		  = "";
	var secondSql		  = "";
	var practitionerName  = "";
	var practitionerValue = "";
	var speciality		  = "";	
	var practitioner_type = "";	
	var dialogTop	= "56";
	var dialogHeight= "400px" ;
	var dialogWidth = "700px" ;
	//  added by lakshmanan for ML-MMOH-CRF-1930 US008 start
	var visit_type_code=""; 
	var virtualConsultEnable="";
	var isVirtualConsultationVisit="";
	if (document.forms[0].functionId){
	if (document.forms[0].functionId.value=="VISIT_REGISTRATION" || document.forms[0].functionId.value=="ASSIGN_PRACTITIONER_FOR_OP") {
		
		if (document.forms[0].visit_adm_type)
			visit_type_code=document.forms[0].visit_adm_type.value;
		if (document.forms[0].isVirtualConsultationVisit)
			isVirtualConsultationVisit=document.forms[0].isVirtualConsultationVisit.value;
		if (document.forms[0].virtualConsultEnable)
			virtualConsultEnable=document.forms[0].virtualConsultEnable.value;
		}
	}
	//  added by lakshmanan for ML-MMOH-CRF-1930 US008 end
	target.value = trimString(target.value);	
	practitionerName = target.name;
	practitionerValue = target.value;
	speciality = splty;
	practitioner_type = pract_type;
	
	if(executeQuery == "Q1")
	{

		/*

			FileName 		:      PatCheckout.js
			Function Name 	:      OP Transactions -> Mangage Patient Queue && Check Out (used when called from AE)

		*/
		firstSql="SELECT a.practitioner_id, c.practitioner_name,c.pract_type_desc practitioner_type,   a.position_code job_title, a.gender,  am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"', '2') primary_specialty  FROM am_pract_all_splty_vw a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c WHERE UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND UPPER (a.primary_speciality_code) LIKE           UPPER (NVL (replace(?,'%',''), c.primary_speciality_code))   AND a.facility_id = b.facility_id AND b.practitioner_id = a.practitioner_id  AND b.eff_status = 'E'  AND b.facility_id = '"+fac_Id+"'  AND b.clinic_code = '"+clinic_code+"'  AND b.treatment_area_code = '"+trtmt_area_code+"' AND (UPPER (a.practitioner_id) LIKE  UPPER (NVL (?, a.practitioner_id)) OR UPPER (c.practitioner_name) LIKE  UPPER (NVL (?, c.practitioner_name)))  AND DECODE (UPPER (a.gender), 'MALE', 'M','FEMALE', 'F', 'Unknown', 'U' ) LIKE NVL (UPPER (?),  DECODE (UPPER (a.gender),  'MALE', 'M', 'FEMALE', 'F','Unknown', 'U'))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) AND a.practitioner_id = c.practitioner_id  AND c.language_id = '"+localeName+"' ORDER BY 2";

		//firstSql="SELECT DISTINCT a.practitioner_id, C.practitioner_name, C.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, d.short_desc primary_specialty FROM AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, AM_PRACTITIONER_LANG_VW C, am_speciality_lang_vw d WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND a.facility_id = b.facility_id  AND b.practitioner_id = a.practitioner_id AND b.eff_status = 'E' AND b.facility_id= '"+fac_Id+"' AND b.clinic_code = '"+clinic_code+"' AND b.treatment_area_code = '"+trtmt_area_code+"' AND a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(C.PRACTITIONER_NAME) LIKE UPPER(NVL(?, C.PRACTITIONER_NAME))) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND C.LANGUAGE_ID ='"+localeName+"' ORDER BY 2 ";		
		
		//secondSql="SELECT DISTINCT a.practitioner_id, C.practitioner_name, C.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, d.short_desc primary_specialty FROM AM_PRACT_ALL_SPLTY_VW a, ae_pract_for_tmt_area b, AM_PRACTITIONER_LANG_VW C, am_speciality_lang_vw d WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND a.facility_id = b.facility_id  AND b.practitioner_id = a.practitioner_id AND b.eff_status = 'E' AND b.facility_id= '"+fac_Id+"' AND b.clinic_code = '"+clinic_code+"' AND b.treatment_area_code = '"+trtmt_area_code+"' AND a.primary_speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(C.PRACTITIONER_NAME) LIKE UPPER(NVL(?, C.PRACTITIONER_NAME))) AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND C.LANGUAGE_ID ='"+localeName+"' ORDER BY 2 ";
		
		secondSql="SELECT a.practitioner_id, c.practitioner_name,c.pract_type_desc practitioner_type,   a.position_code job_title, a.gender,  am_get_desc.am_speciality(a.primary_speciality_code,'"+localeName+"', '2') primary_specialty  FROM am_pract_all_splty_vw a, ae_pract_for_tmt_area b, am_practitioner_lang_vw c WHERE UPPER (a.pract_type) LIKE UPPER (NVL (?, a.pract_type)) AND UPPER (a.primary_speciality_code) LIKE           UPPER (NVL (replace(?,'%',''), c.primary_speciality_code))   AND a.facility_id = b.facility_id AND b.practitioner_id = a.practitioner_id  AND b.eff_status = 'E'  AND b.facility_id = '"+fac_Id+"'  AND b.clinic_code = '"+clinic_code+"'  AND b.treatment_area_code = '"+trtmt_area_code+"' AND (UPPER (a.practitioner_id) LIKE  UPPER (NVL (?, a.practitioner_id)) AND UPPER (c.practitioner_name) LIKE  UPPER (NVL (?, c.practitioner_name)))  AND DECODE (UPPER (a.gender), 'MALE', 'M','FEMALE', 'F', 'Unknown', 'U' ) LIKE NVL (UPPER (?),  DECODE (UPPER (a.gender),  'MALE', 'M', 'FEMALE', 'F','Unknown', 'U'))  AND UPPER (NVL (a.position_code, '123')) LIKE  UPPER (NVL (?, NVL (a.position_code, '123'))) AND a.practitioner_id = c.practitioner_id  AND c.language_id = '"+localeName+"' ORDER BY 2";
	}
	else if(executeQuery == "Q2")
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

		firstSql = firstSql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
		

		secondSql="SELECT  DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender,  am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty   FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+fac_Id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND ";

		if(practitioner_type!="")	
		{
			secondSql=secondSql+" a.pract_type='"+practitioner_type+"' AND ";
		}

		secondSql = secondSql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";	 
		
	}
	else if(executeQuery == "Q3")
	{
		vst_regn_date_time =  trtmt_area_code;

		/*

			FileName 		:      PatCheckout.js
			                       VisitRegistration.js
								   ReviseVisit.js
								   QmgmtRe_AssignPract.js
			Function Name 	:      OP Transactions -> Mangage Patient Queue && Check Out
			                       OP Transactions -> Register Visit
								   OP Transactions -> Revise Visit
								   OP Transactions -> Manage Patient Queue -> Assign Practitioner

			This query is executed when open to all is "N"
		*/
		
		//firstSql= " SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id='"+localeName+"' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+fac_Id+"'), 'F', a.fi_visit_type_appl_yn, 'L', a.fu_visit_type_appl_yn, 'R', a.rt_visit_type_appl_yn, 'S',a.sr_visit_type_appl_yn, 'C', a.cs_visit_type_appl_yn, 'E', a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+clinic_code+"' AND  a.facility_id='"+fac_Id+"' AND a.eff_status = 'E' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = '"+fac_Id+"' and eff_status = 'E' ) ";

		firstSql = "SELECT distinct b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty, b.gender gender, b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_pract_all_splty_vw d WHERE b.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code = c.clinic_code AND c.facility_id = a.facility_id AND b.pract_type = NVL (DECODE (c.primary_resource_class,'R', '','E', '','O', '', c.pract_type), b.pract_type) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+fac_Id+"',d.facility_id) AND a.clinic_code = '"+clinic_code+"' AND a.facility_id = '"+fac_Id+"' AND a.eff_status = 'E' AND EXISTS (SELECT 1 FROM am_pract_for_facility WHERE practitioner_id = b.practitioner_id AND facility_id = '"+fac_Id+"' AND eff_status = 'E') ";
		
		if(visitadmtype!=""){
			firstSql = firstSql+"  AND DECODE ((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code = '"+visitadmtype+"' AND facility_id = '"+fac_Id+"'), 'F', a.fi_visit_type_appl_yn, 'L', a.fu_visit_type_appl_yn, 'R', a.rt_visit_type_appl_yn, 'S', a.sr_visit_type_appl_yn, 'C', a.cs_visit_type_appl_yn, 'E', a.em_visit_type_appl_yn) = 'Y' "
		}
		if(callfunc=="FromAppt")	
		{
			if(document.forms[0].appt_practitioner_id)
				pract_id=document.forms[0].appt_practitioner_id.value;
			else
				pract_id="";
			
			if(pract_id !=""){
				firstSql = firstSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL AND practitioner_id !='"+pract_id+"'   AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}else{
				firstSql = firstSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL  AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}
			// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			 if (virtualConsultEnable=="E" && isVirtualConsultationVisit=="true"){
				 firstSql=firstSql+" and b.enable_virtual_cons='E' ";
			 	}  
			// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		}
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			 if (visit_type_code!="" && isVirtualConsultationVisit=="true"){
				 firstSql=firstSql+" AND b.ENABLE_VIRTUAL_CONS like decode((select virtual_consultation from op_visit_type where visit_type_code='"+visit_type_code+"' and facility_id=A.FACILITY_ID ),'D','%','E','E','%')";
			 	}  
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		
		firstSql = firstSql +" and('Y'= (case when c.OPEN_TO_ALL_PRACT_YN='N' then  (SELECT GET_PRACT_WORKING_YN('"+fac_Id+"','"+clinic_code+"',d.practitioner_id) from dual) else 'Y'  end)) ";
		
		

		//secondSql= " SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id='"+localeName+"' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,'123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = '"+localeName+"' and DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+fac_Id+"'), 'F', a.fi_visit_type_appl_yn, 'L', a.fu_visit_type_appl_yn, 'R', a.rt_visit_type_appl_yn, 'S',a.sr_visit_type_appl_yn, 'C', a.cs_visit_type_appl_yn, 'E', a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+clinic_code+"' AND  a.facility_id='"+fac_Id+"' AND a.eff_status = 'E' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = '"+fac_Id+"' and eff_status = 'E' ) ";
		
		secondSql = "SELECT distinct b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty, b.gender gender, b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_pract_all_splty_vw d WHERE b.language_id = '"+localeName+"' AND b.pract_type LIKE (?) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code = c.clinic_code AND c.facility_id = a.facility_id AND b.pract_type = NVL (DECODE (c.primary_resource_class,'R', '','E', '','O', '', c.pract_type), b.pract_type) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+fac_Id+"',d.facility_id) AND a.clinic_code = '"+clinic_code+"' AND a.facility_id = '"+fac_Id+"' AND a.eff_status = 'E' AND EXISTS (SELECT 1 FROM am_pract_for_facility WHERE practitioner_id = b.practitioner_id AND facility_id = '"+fac_Id+"' AND eff_status = 'E') ";

		if(visitadmtype!=""){
			firstSql = firstSql+"  AND DECODE ((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code = '"+visitadmtype+"' AND facility_id = '"+fac_Id+"'), 'F', a.fi_visit_type_appl_yn, 'L', a.fu_visit_type_appl_yn, 'R', a.rt_visit_type_appl_yn, 'S', a.sr_visit_type_appl_yn, 'C', a.cs_visit_type_appl_yn, 'E', a.em_visit_type_appl_yn) = 'Y' ";
		}
		if(callfunc=="FromAppt")	
		{
			if(document.forms[0].appt_practitioner_id)
				pract_id=document.forms[0].appt_practitioner_id.value;
			else
				pract_id="";
			
			if(pract_id != ""){
				secondSql = secondSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL AND practitioner_id !='"+pract_id+"'  AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}else{
				secondSql = secondSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL  AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}
			// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			
			 if (virtualConsultEnable=="E" && isVirtualConsultationVisit=="true"){
				 secondSql=secondSql+" and b.enable_virtual_cons='E' ";
			 	}  
			// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		}
		
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			 if (visit_type_code!="" && isVirtualConsultationVisit=="true"){
				 secondSql=secondSql+" AND b.ENABLE_VIRTUAL_CONS like decode((select virtual_consultation from op_visit_type where visit_type_code='"+visit_type_code+"' AND facility_id=A.FACILITY_ID ),'D','%','E','E','%')";
			 	}  
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		
		secondSql = secondSql +" and('Y'= (case when c.OPEN_TO_ALL_PRACT_YN='N' then  (SELECT GET_PRACT_WORKING_YN('"+fac_Id+"','"+clinic_code+"',d.practitioner_id) from dual) else 'Y'  end)) ";

	}	
	else if(executeQuery == "Q4")
	{

		vst_regn_date_time =  trtmt_area_code;

		/*
			File Name 		:      VisitRegistration.js
			                       QmgmtRe_AssignPract.js
								   ReviseVisit.js
			Function Name 	:      OP Transactions -> Register Visit
			                       OP Transactions -> Manage Patient Queue -> Assign Practitioner
								   OP Transactions -> Revise Visit
		*/

		//firstSql=" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id='"+localeName+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND d.facility_id='"+fac_Id+"' AND d.clinic_code= '"+clinic_code+"' AND e.speciality_code = f.speciality_code and f.language_id = '"+localeName+"'";

		firstSql="SELECT distinct d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, am_get_desc.am_speciality(f.PRIMARY_SPECIALITY_CODE,'"+localeName+"','2') primary_specialty, a.gender gender, a.position_code job_title FROM op_register_visit_pract_vw d, am_practitioner_lang_vw a, op_clinic e, am_pract_all_splty_vw f WHERE a.language_id = '"+localeName+"' AND d.facility_id = e.facility_id  AND d.clinic_code = e.clinic_code AND d.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND UPPER (f.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND (UPPER (a.practitioner_id) LIKE UPPER (nvl(?,a.practitioner_id)) OR UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) AND d.facility_id = '"+fac_Id+"' AND d.clinic_code = '"+clinic_code+"' AND a.practitioner_id = f.practitioner_id AND f.facility_id = nvl('"+fac_Id+"',f.facility_id)";

		if(callfunc=="FromAppt")	
		{
			if(document.forms[0].appt_practitioner_id)
				pract_id=document.forms[0].appt_practitioner_id.value;
			else
				pract_id="";
			
			if(pract_id = ""){
				firstSql = firstSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NULL AND practitioner_id ='"+pract_id+"'   AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}else{
				firstSql = firstSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NULL AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}
		}
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			 if (visit_type_code!="" && isVirtualConsultationVisit=="true"){
				 firstSql=firstSql+" AND A.ENABLE_VIRTUAL_CONS like decode((select virtual_consultation from op_visit_type where visit_type_code='"+visit_type_code+"'),'D','%','E','E','%')";
			 	}  
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		
		//secondSql=" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC  practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id='"+localeName+"' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND d.facility_id='"+fac_Id+"' AND d.clinic_code= '"+clinic_code+"' AND e.speciality_code = f.speciality_code and f.language_id = '"+localeName+"'";

		secondSql="SELECT distinct d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, am_get_desc.am_speciality(f.PRIMARY_SPECIALITY_CODE,'"+localeName+"','2') primary_specialty, a.gender gender, a.position_code job_title FROM op_register_visit_pract_vw d, am_practitioner_lang_vw a, op_clinic e, am_pract_all_splty_vw f WHERE a.language_id = '"+localeName+"' AND d.facility_id = e.facility_id  AND d.clinic_code = e.clinic_code AND d.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND UPPER (f.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND (UPPER (a.practitioner_id) LIKE UPPER (nvl(?,a.practitioner_id)) AND UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (a.position_code, '123')) LIKE UPPER (NVL (?, NVL (a.position_code, '123'))) AND d.facility_id = '"+fac_Id+"' AND d.clinic_code = '"+clinic_code+"' AND a.practitioner_id = f.practitioner_id AND f.facility_id = nvl('"+fac_Id+"',f.facility_id)";

		if(callfunc=="FromAppt")	
		{
			if(document.forms[0].appt_practitioner_id)
				pract_id=document.forms[0].appt_practitioner_id.value;
			else
				pract_id="";
			
			if(pract_id = ""){
				secondSql = secondSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NULL AND practitioner_id ='"+pract_id+"'   AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}else{ 
				secondSql = secondSql+" AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NULL AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' ))) ";
			}
		}
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 start
			 if (visit_type_code!="" && isVirtualConsultationVisit=="true"){
				 secondSql=secondSql+" AND A.ENABLE_VIRTUAL_CONS like decode((select virtual_consultation from op_visit_type where visit_type_code='"+visit_type_code+"'),'D','%','E','E','%')";
			 	}  
		// added by lakshmanan for ML-MMOH-CRF-1930 US008 end
		
	}	
	else if(executeQuery == "Q5")
	{

		/*

			FileName 		:      Opqueuenumbering.js
			Function Name 	:      OP Admin SetUP -> Queue Numbering Control

		*/

		//firstSql = "select DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.GENDER gender, e.short_desc primary_specialty  from op_clinic a, AM_PRACT_ALL_SPLTY_VW b, am_pract_type d, am_speciality e where a.facility_id='"+fac_Id+"' and a.clinic_code='"+clinic_code+"' and a.specialIty_code = b.PRIMARY_SPECIALITY_CODE and b.pract_type = d.pract_type and e.speciality_code=b.primary_speciality_code and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2 ";

		firstSql = "SELECT DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, NVL (d.desc_sysdef, d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM op_clinic a, am_pract_all_splty_vw b, am_pract_type d,am_practitioner_lang_vw e WHERE a.facility_id = '"+fac_Id+"' AND a.clinic_code = '"+clinic_code+"'  AND a.speciality_code = e.primary_speciality_code   AND b.pract_type = d.pract_type AND b.practitioner_id = e.practitioner_id AND e.language_id = '"+localeName+"'      AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),e.primary_speciality_code)) AND (UPPER (b.practitioner_id) LIKE  UPPER (NVL (?, b.practitioner_id)) OR UPPER (e.practitioner_name) LIKE  UPPER (NVL (?, e.practitioner_name))) AND DECODE (UPPER (b.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U' ) LIKE  NVL (UPPER (?), DECODE (UPPER (b.gender),  'MALE', 'M','FEMALE', 'F', 'Unknown', 'U')) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) order by 2 ";

		secondSql = "SELECT DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM op_clinic a, am_pract_all_splty_vw b, am_pract_type d,am_practitioner_lang_vw e WHERE a.facility_id = '"+fac_Id+"' AND a.clinic_code = '"+clinic_code+"'  AND a.speciality_code = e.primary_speciality_code   AND b.pract_type = d.pract_type AND b.practitioner_id = e.practitioner_id AND e.language_id = '"+localeName+"'       AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),e.primary_speciality_code)) AND (UPPER (b.practitioner_id) LIKE  UPPER (NVL (?, b.practitioner_id)) AND UPPER (e.practitioner_name) LIKE  UPPER (NVL (?, e.practitioner_name))) AND DECODE (UPPER (b.gender), 'MALE', 'M', 'FEMALE', 'F', 'Unknown', 'U' ) LIKE  NVL (UPPER (?), DECODE (UPPER (b.gender),  'MALE', 'M','FEMALE', 'F', 'Unknown', 'U')) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) order by 2 ";
	 
		//secondSql = "select DISTINCT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.GENDER gender, e.short_desc primary_specialty  from op_clinic a, AM_PRACT_ALL_SPLTY_VW b, am_pract_type d, am_speciality e where a.facility_id='"+fac_Id+"' and a.clinic_code='"+clinic_code+"' and a.specialIty_code = b.PRIMARY_SPECIALITY_CODE and b.pract_type = d.pract_type and e.speciality_code=b.primary_speciality_code and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.PRIMARY_SPECIALITY_CODE) like upper(nvl(?,b.PRIMARY_SPECIALITY_CODE)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2 ";		

	}
	else if(executeQuery == "Q6")
	{

		/*

			FileName 		:      Opqueuenumbering.js
			Function Name 	:      OP Admin SetUP -> Queue Numbering Control

		*/	

		//firstSql="select b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, e.short_desc primary_specialty from op_pract_for_clinic a, am_practitioner b, op_clinic c, am_pract_type d, am_speciality e where a.practitioner_id = b.practitioner_id and a.clinic_code=c.clinic_code and b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) and a.clinic_code='"+clinic_code+"' and c.facility_id = a.facility_id and a.facility_id='"+fac_Id+"' and a.eff_status = 'E' and d.pract_type=b.pract_type and e.speciality_code=b.primary_speciality_code and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";
      
		firstSql="SELECT DISTINCT b.practitioner_id practitioner_id,b.practitioner_name practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, am_get_desc.am_speciality(e.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_pract_type d, am_pract_all_splty_vw e WHERE a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' AND a.clinic_code = c.clinic_code AND b.pract_type = NVL (DECODE (c.primary_resource_class, 'R', '', 'E', '', 'O', '', c.pract_type), b.pract_type ) AND a.clinic_code = '"+clinic_code+"' AND c.facility_id = a.facility_id AND a.facility_id = '"+fac_Id+"' AND a.eff_status = 'E'  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND UPPER (e.primary_speciality_code) LIKE UPPER(NVL(REPLACE(?,'%',''),b.primary_speciality_code)) AND (UPPER (e.practitioner_id) LIKE UPPER (NVL(?,e.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND UPPER (b.gender) LIKE UPPER (NVL (?, b.gender)) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123')))AND e.facility_id = NVL('"+fac_Id+"',e.facility_id)AND a.practitioner_id = e.practitioner_id";
	 
		secondSql="SELECT DISTINCT b.practitioner_id practitioner_id,b.practitioner_name practitioner_name,NVL (d.desc_sysdef, d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender,am_get_desc.am_speciality(e.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM op_pract_for_clinic a,am_practitioner_lang_vw b,op_clinic c,am_pract_type d,am_pract_all_splty_vw e WHERE a.practitioner_id = b.practitioner_id AND b.language_id = '"+localeName+"' AND a.clinic_code = c.clinic_code AND b.pract_type = NVL (DECODE (c.primary_resource_class, 'R', '', 'E', '', 'O', '', c.pract_type), b.pract_type ) AND a.clinic_code = '"+clinic_code+"' AND c.facility_id = a.facility_id AND a.facility_id = '"+fac_Id+"' AND a.eff_status = 'E'  AND d.pract_type = b.pract_type AND UPPER (d.pract_type) LIKE UPPER (NVL (?, d.pract_type)) AND UPPER (e.primary_speciality_code) LIKE UPPER(NVL(REPLACE(?,'%',''),b.primary_speciality_code)) AND (UPPER (e.practitioner_id) LIKE UPPER (NVL(?,e.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND UPPER (b.gender) LIKE UPPER (NVL (?, b.gender)) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123')))AND e.facility_id = NVL('"+fac_Id+"',e.facility_id)AND a.practitioner_id = e.practitioner_id";	
		
		//secondSql="select b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, b.position_code job_title, b.gender gender, e.short_desc primary_specialty from op_pract_for_clinic a, am_practitioner b, op_clinic c, am_pract_type d, am_speciality e where a.practitioner_id = b.practitioner_id and a.clinic_code=c.clinic_code and b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,'R','','E','','O','',c.pract_type),b.pract_type) and a.clinic_code='"+clinic_code+"' and c.facility_id = a.facility_id and a.facility_id='"+fac_Id+"' and a.eff_status = 'E' and d.pract_type=b.pract_type and e.speciality_code=b.primary_speciality_code and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name)) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) order by 2";
	}
	else if(executeQuery == "Q7")
	{		
		/*

			File Name 		:      ResourceForUnit.js
			                       ReviseVisit.js
			Function Name 	:      Op Code SetUp -> Resource For Location 
			                       OP Transactions -> Revise Visit
		*/

		/*
		firstSql = "Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, b.position_code job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b, op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+fac_Id+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			firstSql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		firstSql+=" and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+fac_Id+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";			
		*/

		firstSql = "SELECT  distinct a.practitioner_id practitioner_id,e.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, b.position_code job_title, b.gender, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM am_pract_for_facility a, am_practitioner_vw b, op_clinic c,am_pract_all_splty_vw d,am_practitioner_lang_vw e WHERE b.practitioner_id = a.practitioner_id AND  b.practitioner_id=e.practitioner_id and a.eff_status = 'E' AND a.facility_id = '"+fac_Id+"' AND c.facility_id = a.facility_id AND c.clinic_code = '"+clinic_code+"' and e.language_id='"+localeName+"'";

		if(callfunc == "Resource_unit") {  
			firstSql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		} 
		
		firstSql+="AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities WHERE facility_id = '"+fac_Id+"' AND practitioner_id = b.practitioner_id)) AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,e.practitioner_id)) OR UPPER (e.practitioner_name) LIKE UPPER (NVL (?, e.practitioner_name))) AND DECODE (UPPER (b.gender),'MALE', 'M','FEMALE', 'F','UNKNOWN', 'U') LIKE NVL (UPPER (?), DECODE (UPPER (b.gender),'MALE', 'M','FEMALE', 'F','UNKNOWN', 'U')) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+fac_Id+"',d.facility_id)";

		secondSql = "SELECT  distinct a.practitioner_id practitioner_id,e.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, b.position_code job_title, b.gender, am_get_desc.am_speciality(d.primary_speciality_code,'"+localeName+"','2') primary_specialty FROM am_pract_for_facility a, am_practitioner_vw b, op_clinic c, am_pract_all_splty_vw d,am_practitioner_lang_vw e WHERE b.practitioner_id = a.practitioner_id AND  a.practitioner_id=e.practitioner_id and a.eff_status = 'E' AND a.facility_id = '"+fac_Id+"' AND c.facility_id = a.facility_id AND c.clinic_code = '"+clinic_code+"' and e.language_id='"+localeName+"'";

		if(callfunc == "Resource_unit") {
			secondSql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		} 
		
		secondSql+="AND (c.speciality_code = b.primary_speciality_code OR c.speciality_code IN (SELECT speciality_code FROM am_pract_specialities WHERE facility_id = '"+fac_Id+"' AND practitioner_id = b.practitioner_id)) AND UPPER (b.pract_type) LIKE UPPER (NVL (?, b.pract_type)) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''), b.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (e.practitioner_name) LIKE UPPER (NVL (?, e.practitioner_name))) AND DECODE (UPPER (b.gender),'MALE', 'M','FEMALE', 'F','UNKNOWN', 'U') LIKE NVL (UPPER (?), DECODE (UPPER (b.gender),'MALE', 'M','FEMALE', 'F','UNKNOWN', 'U')) AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (?, NVL (b.position_code, '123'))) AND b.practitioner_id = d.practitioner_id AND d.facility_id = nvl('"+fac_Id+"',d.facility_id)";	

		/*

		secondSql="Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, b.position_code job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+fac_Id+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			secondSql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		secondSql+="and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+fac_Id+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";	

		*/
	}
	else if(executeQuery == "Q8")
	{

		/*
			File Name 		:      VisitRegistration.js			                       
			Function Name 	:      OP Transactions -> Register Visit			                       
		*/		
		
		var vst_regn_date_time = visitadmtype; 		

		firstSql="SELECT a.practitioner_id practitioner_id,a.practitioner_name practitioner_name, a.pract_type practitioner_type,am_get_desc.am_speciality  (d.primary_speciality_code,'"+localeName+"', '2' ) primary_specialty, a.gender gender,a.position_code job_title   FROM am_practitioner_lang_vw a,am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule        WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL   AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' )))  AND a.pract_type LIKE (?) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) OR UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name)))  AND a.gender LIKE (?)  AND UPPER (NVL (a.position_code, '123')) LIKE   UPPER (NVL (?, NVL (a.position_code, '123'))) 	AND a.practitioner_id = d.practitioner_id  AND d.facility_id = nvl('"+fac_Id+"',d.facility_id)   ORDER BY 2";

		secondSql="SELECT a.practitioner_id practitioner_id,a.practitioner_name practitioner_name, a.pract_type practitioner_type,am_get_desc.am_speciality  (d.primary_speciality_code,'"+localeName+"', '2' ) primary_specialty, a.gender gender,a.position_code job_title   FROM am_practitioner_lang_vw a,am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.practitioner_id NOT IN (SELECT practitioner_id  FROM oa_clinic_schedule        WHERE clinic_code = '"+clinic_code+"'  AND facility_id = '"+fac_Id+"'  AND resource_class = 'P'   AND practitioner_id IS NOT NULL   AND TRUNC (clinic_date) =  TRUNC (TO_DATE ('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi' )))  AND a.pract_type LIKE (?) AND UPPER (d.primary_speciality_code) LIKE UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND (UPPER (d.practitioner_id) LIKE UPPER (nvl(?,d.practitioner_id)) AND UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?)  AND UPPER (NVL (a.position_code, '123')) LIKE   UPPER (NVL (?, NVL (a.position_code, '123'))) 	AND a.practitioner_id = d.practitioner_id  AND d.facility_id = nvl('"+fac_Id+"',d.facility_id) ORDER BY 2";
		
	}
// Newly added  by Name :Selvin M  Date :22 sep 2011 INCIDENT NO: 25177 added Starts	
if(executeQuery == "Q9")
	{	
		firstSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+fac_Id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";

						secondSql= "select distinct a.practitioner_id practitioner_id, b.practitioner_name, b.pract_type_desc practitioner_type,a.POSITION_CODE  job_title,a.gender gender, b.PRIMARY_SPECIALITY_DESC primary_specialty from AM_PRACT_ALL_SPLTY_VW a, am_practitioner_lang_vw b where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and a.facility_id= '"+fac_Id+"' and b.language_id = '"+localeName+"' and a.practitioner_id = b.practitioner_id and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?, b.practitioner_name))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2";	
		
	}
//End		
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
	xmlStr +=" /></root>" ;
	var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eAM/jsp/callGeneralPractitionerSearch.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText); 
	await practSearch(practitionerName,practitioner_type,encodeURIComponent(practitionerValue),speciality,responseText);
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	//xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	//xmlHttp.send(xmlDoc);
	//responseText=xmlHttp.responseText;
	//responseText = trimString(responseText);
	//eval(responseText);	
	return;

}
async function practSearch(practName_FName,practitionertype,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "600px" ;
	var dialogWidth	= "800px" ;
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
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+practitionertype+"&primary_specialty="+splty,arguments,features);
	PractLookupRetVal(retVal,objName);
	
}
