/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.sfs.impl;

import eIPAD.HealthObjects.SFSContext;
import eIPAD.sfs.SFS;
import eIPAD.sfs.SFSReturnData;

public class SpecialitySFSImpl implements SFS { 

	public SpecialitySFSImpl() {
	}
	public SFSReturnData getQuery(SFSContext oSFSContext) {
		// here the SQL Query string will be specific
		// for a speciality
		String facility_id = oSFSContext.getSfacility_id();
		if(facility_id == null)
		{
			facility_id = "";
		}
		if (oSFSContext.getSfacility_id() != null
				&& !oSFSContext.getSfacility_id().equals("")) {
			facility_id = oSFSContext.getSfacility_id();
		}
		String clinicianId = oSFSContext.getSclinicianId();
		if(clinicianId == null)
		{
			clinicianId = "";
		}
		if (oSFSContext.getSclinicianId() != null
				&& !oSFSContext.getSclinicianId().equals("")) {
			clinicianId = oSFSContext.getSclinicianId();
		}
		StringBuffer sqlStr = new StringBuffer("");
		String searchBy = oSFSContext.getsSearchBy();
		if(searchBy == null){
			searchBy = "";
		}
		String searchCriteria = oSFSContext.getsSearchCriteria();
		if(searchCriteria == null){
			searchCriteria = "";
		}
		String practitionerId = (oSFSContext.getsPractionerId()==null)?"":oSFSContext.getsPractionerId();
		
		
		String searchText = oSFSContext.getsSearchText() ;
		if (searchText == null)
		{
			searchText = "";
		}
		sqlStr.append("SELECT DISTINCT mainQry.SPECIALTY_CODE Code ,  splTable.LONG_DESC Description from(SELECT   REPLACE ( DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'DD/MM/YYYY HH24:MI') discharge_date_time, ca_get_patient_curr_status "); 
		sqlStr.append("(a.facility_id,a.patient_id,a.episode_id,a.patient_class	,'"+ practitionerId +"',") ;
		sqlStr.append("a.deceased_yn)  status,a.episode_id,a.specialty_code,service_code,cur_ward_code,locn_type, (select count(*) from ");
		sqlStr.append("CA_ENCNTR_PRACT_RELN where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.episode_id,0)" );
		sqlStr.append(" and practitioner_id='" + practitionerId +"'");
		sqlStr.append("and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE ) reln_count FROM ca_ip_active_episode_vw a WHERE a.facility_id ='" + facility_id +"' AND a.patient_class = 'IP' AND ");
		sqlStr.append("(a.adt_status IN ('01', '02'))AND a.cur_physician_id  ='" + practitionerId +"'"); 
		sqlStr.append("AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')  and case when (Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM) = 'Y' then (select count(*) from CA_ENCNTR_PRACT_RELN  where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.episode_id,0) and practitioner_id = a.cur_physician_id and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE) else 1 end > 0) mainQry ,AM_SPECIALITY_lang_vw splTable where splTable.SPECIALITY_CODE = mainQry.SPECIALTY_CODE AND splTable.LANGUAGE_ID  ='en'");
		
		SFSReturnData returndata = new SFSReturnData();
		returndata.setQuery(sqlStr.toString());
		return returndata;

	}


}
