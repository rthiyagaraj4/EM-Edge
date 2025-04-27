/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD;
import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import eIPAD.HealthObjects.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
public class InPatientList implements java.io.Serializable {
	public List<InPatients> getInPatientLis(InPatientContext oInPatientContext) throws Exception {
		List<InPatients> oInPatientsList = new ArrayList<InPatients>() ;
		if(oInPatientContext != null && oInPatientContext.getRequest() != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String sPatientId = "" ;
			String sNursingUnit = "" ;
			String sPracId = "";
			String SpecialityID = "" ;
			String sOrderBy = "";
			HttpSession session = oInPatientContext.getSession();
			HttpServletRequest request = oInPatientContext.getRequest();
			
			int nRowCount = 0;
			
		
			
			if(oInPatientContext.getFacilityId() != null && !oInPatientContext.getFacilityId().equals("") )
			{
				facility_id = oInPatientContext.getFacilityId();
			}
			if(oInPatientContext.getClinicianId() != null && !oInPatientContext.getClinicianId().equals(""))
			{
				clinicianId  = oInPatientContext.getClinicianId();
			}
			
			sqlStr.append("SELECT   REPLACE (DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'DD/MM/YYYY HH24:MI') discharge_date_time, ca_get_patient_curr_status (a.facility_id,a.patient_id,a.episode_id,a.patient_class,'" + clinicianId + "',a.deceased_yn) status,a.episode_id,a.specialty_code,service_code,cur_ward_code,locn_type, ");
			sqlStr.append(" (select count(*) from CA_ENCNTR_PRACT_RELN where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.episode_id,0) and practitioner_id = '"+ clinicianId +"' and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE ) reln_count FROM ca_ip_active_episode_vw a ");
			sqlStr.append(" WHERE a.facility_id ='" + facility_id +"' AND a.patient_class = 'IP' AND (a.adt_status IN ('01', '02')) ");
			
			if(oInPatientContext.getPatientId() != null && !oInPatientContext.getPatientId().equals(""))
			{
			 sPatientId = oInPatientContext.getPatientId();
			}

			if(oInPatientContext.getNursingUnitCode() != null && !oInPatientContext.getNursingUnitCode().equals("") )
			{
			  sNursingUnit = oInPatientContext.getNursingUnitCode();
			}
			if(oInPatientContext.getPractionerId() != null &&  !oInPatientContext.getPractionerId().equals("") )
			{
			  sPracId = oInPatientContext.getPractionerId();
			}
			if(oInPatientContext.getSpecialityCode() != null && !oInPatientContext.getSpecialityCode().equals(""))
			{
			 SpecialityID = oInPatientContext.getSpecialityCode();
			}

			if(oInPatientContext.getOrderBy()!= null &&  !oInPatientContext.getOrderBy().equals(""))
			{
				sOrderBy = oInPatientContext.getOrderBy();
			}

			if(!sPatientId.equals(""))
			{
			  sqlStr.append(" AND ( UPPER(a.patient_id) = UPPER('" + sPatientId + "') OR UPPER(a.cur_bed_num) = UPPER('" + sPatientId + "') ) ");

			}
			else{

				if(!sPracId.equals("") )
				{
					sqlStr.append(" AND a.cur_physician_id = '" + sPracId + "'");
				}
				else
				{
					sqlStr.append(" AND a.cur_physician_id = '" + clinicianId + "'");
				}
	
				if(!sNursingUnit.equals(""))
				{
				  sqlStr.append(" AND a.cur_ward_code ='" + sNursingUnit + "'");
				}
				if(!SpecialityID.equals(""))
				{
				   sqlStr.append(" AND a.specialty_code = '" + SpecialityID + "'");
				}
			
			}
			//sqlStr.append(" AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
			//this condition is added to find whether the ESTABLISH_RELN_REQ_YN is "Y" and if equal to "Y" then only the patients who have a legitimate relationship with the practitioner will be displayed in the IP List
			sqlStr.append("AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%') ");
			if(sPatientId.equals(""))
			{
				sqlStr.append(" and case when (Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM) = 'Y' then (select count(*) from CA_ENCNTR_PRACT_RELN  where facility_id=a.facility_id and NVL(ENCOUNTER_ID,0) = NVL(a.episode_id,0) and practitioner_id = a.cur_physician_id and patient_id=a.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE) else 1 end > 0 ");
			}
			if(!sOrderBy.equals ("") && !sOrderBy.equals ("OR"))
			{
				sqlStr.append("ORDER BY " + sOrderBy );
			}
			else
			{
				//sqlStr.append("ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
				//sqlStr.append("ORDER BY patient_name desc");
				sqlStr.append(" ORDER BY a.admission_date_time desc");
			}
			
	       
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() && nRowCount < 100) {
						
						InPatients oInPatients = new InPatients();
						
						oInPatients.sPatientName = ((resultSet.getString("patient_name") != null) ? resultSet.getString("patient_name") : "") ;
						oInPatients.sAge = ((resultSet.getString("age") != null) ? resultSet.getString("age") : "") ;
						oInPatients.sGender = ((resultSet.getString("sex") != null) ? resultSet.getString("sex") : "") ;
						oInPatients.sPatientId = ((resultSet.getString("patient_id") != null) ? resultSet.getString("patient_id") : "") ;
						oInPatients.sBedNo = ((resultSet.getString("bed_num") != null) ? resultSet.getString("bed_num") : "") ;
						oInPatients.sRoomNo = ((resultSet.getString("room_num") != null) ? resultSet.getString("room_num") : "") ;
						oInPatients.sAdmDateTime = ((resultSet.getString("adm_visit_date") != null) ? resultSet.getString("adm_visit_date") : "") ;
						oInPatients.sPhysicianName = ((resultSet.getString("physician_name") != null) ? resultSet.getString("physician_name") : "") ;
						oInPatients.sDischargeDateTime = ((resultSet.getString("discharge_date_time") != null) ? resultSet.getString("discharge_date_time") : "") ;
						oInPatients.sStatus = ((resultSet.getString("status") != null) ? resultSet.getString("status") : "") ;
						oInPatients.locationCode = ((resultSet.getString("cur_ward_code") != null) ? resultSet.getString("cur_ward_code") : "");
						oInPatients.locationType = ((resultSet.getString("locn_type") != null) ? resultSet.getString("locn_type") : "");
						oInPatients.serviceCode = ((resultSet.getString("service_code") != null) ? resultSet.getString("service_code") : "");
						oInPatients.sEpisodeId = ((resultSet.getString("episode_id") != null && !resultSet.getString("episode_id").equals("null")) ? resultSet.getString("episode_id") : "") ;
						oInPatients.relnExists = (resultSet.getInt("reln_count")<1?false:true);
						oInPatients.sSpecialityCode = ((resultSet.getString("specialty_code") != null) ? resultSet.getString("specialty_code") : "");
						
						oInPatientsList.add(oInPatients);
						nRowCount = nRowCount + 1;
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oInPatientsList;
	}
	
	public List<InPatients> getRecentlyAccessedInPatientList(InPatientContext oInPatientContext) throws Exception {
		List<InPatients> oInPatientsList = new ArrayList<InPatients>() ;
		if(oInPatientContext != null && oInPatientContext.getRequest() != null)
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			Statement stmt				= null;
			ResultSet resultSet 			= null;
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String facility_id= ""; //(String)session.getValue("facility_id");
			String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
			String sPatientId = "" ;
			String sNursingUnit = "" ;
			String sPracId = "";
			String SpecialityID = "" ;
			String sOrderBy = "";
			String userId = "";
			HttpSession session = oInPatientContext.getSession();
			HttpServletRequest request = oInPatientContext.getRequest();
			session = request.getSession();
			if(session.getAttribute("login_user") != null){
				userId = (String)session.getAttribute("login_user");
			}
			int nRowCount = 0;
			
		
			
			if(oInPatientContext.getFacilityId() != null && !oInPatientContext.getFacilityId().equals("") )
			{
				facility_id = oInPatientContext.getFacilityId();
			}
			if(oInPatientContext.getClinicianId() != null && !oInPatientContext.getClinicianId().equals(""))
			{
				clinicianId  = oInPatientContext.getClinicianId();
			}
			if(oInPatientContext.getClinicianId() != null && !oInPatientContext.getClinicianId().equals(""))
			{
				clinicianId  = oInPatientContext.getClinicianId();
			}
			
			sqlStr.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name,  b.assign_care_locn_code locn_code, b.assign_care_locn_type locn_type, b.SERVICE_CODE service_code , b.specialty_code specialty_code, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, decode(b.ASSIGN_room_num,'*ALL','',NVL (b.ASSIGN_room_num, '') ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,decode( b.patient_class, 'OP',b.visit_adm_type,''),?,1) visit_type,ca_ae_get_priority_zone_color(b.priority_zone,'en') ae_zone_color, (select count(*) from CA_ENCNTR_PRACT_RELN where facility_id=b.facility_id and NVL(ENCOUNTER_ID,0) = NVL(b.episode_id,0) and practitioner_id = ? and patient_id=b.patient_id AND NVL(STATUS,'01')='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) AND BEGIN_DATE_TIME<SYSDATE ) reln_count FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (           b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )        Order By access_date_time desc ");
			
	       
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						pstmt = connection.prepareStatement(sqlStr.toString());
						pstmt.setString(1,locale);
						pstmt.setString(2,locale);
						pstmt.setString(3,locale);
						pstmt.setString(4,locale);
						pstmt.setString(5,locale);
						pstmt.setString(6,locale);
						pstmt.setString(7,locale);
						pstmt.setString(8,locale);
						pstmt.setString(9,clinicianId);
						pstmt.setString(10,facility_id);
						pstmt.setString(11,locale);
						pstmt.setString(12,clinicianId);
						pstmt.setString(13,facility_id);
						pstmt.setString(14,userId);
					}
					if (resultSet != null) 
					{
						resultSet.close();  
					}
				
					if(pstmt != null)
						resultSet = pstmt.executeQuery();
					while ( resultSet != null && resultSet.next() && nRowCount < 100) {
						
						InPatients oInPatients = new InPatients();
						
						oInPatients.sPatientName = ((resultSet.getString("patient_name") != null) ? resultSet.getString("patient_name") : "") ;
						oInPatients.sAge = ((resultSet.getString("age") != null) ? resultSet.getString("age") : "") ;
						oInPatients.sGender = ((resultSet.getString("sex") != null) ? resultSet.getString("sex") : "") ;
						oInPatients.sPatientId = ((resultSet.getString("patient_id") != null) ? resultSet.getString("patient_id") : "") ;
						oInPatients.sBedNo = ((resultSet.getString("bed_num") != null) ? resultSet.getString("bed_num") : "") ;
						oInPatients.sRoomNo = ((resultSet.getString("room_num") != null) ? resultSet.getString("room_num") : "") ;
						oInPatients.sAdmDateTime = ((resultSet.getString("visit_adm_date") != null) ? resultSet.getString("visit_adm_date") : "") ;
						oInPatients.sPhysicianName = ((resultSet.getString("phy_prov_name") != null) ? resultSet.getString("phy_prov_name") : "") ;
						oInPatients.sDischargeDateTime = ((resultSet.getString("discharge_date_time") != null) ? resultSet.getString("discharge_date_time") : "") ;
						oInPatients.sStatus = ((resultSet.getString("status") != null) ? resultSet.getString("status") : "") ;
						oInPatients.locationCode = ((resultSet.getString("locn_code") != null) ? resultSet.getString("locn_code") : "");
						oInPatients.locationType = ((resultSet.getString("locn_type") != null) ? resultSet.getString("locn_type") : "");
						oInPatients.serviceCode = ((resultSet.getString("service_code") != null) ? resultSet.getString("service_code") : "");
						oInPatients.sEpisodeId = ((resultSet.getString("episode_id") != null && !resultSet.getString("episode_id").equals("null")) ? resultSet.getString("episode_id") : "") ;
						oInPatients.relnExists = (resultSet.getInt("reln_count")<1?false:true);
						oInPatients.sSpecialityCode = ((resultSet.getString("specialty_code") != null) ? resultSet.getString("specialty_code") : "");
						
						oInPatientsList.add(oInPatients);
						nRowCount = nRowCount + 1;
						
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( pstmt != null ) pstmt.close() ;
					 ConnectionManager.returnConnection(connection,request);
			 
			}
		}
		return oInPatientsList;
	}
	
	
	
	public String patientPractRelnReqdYN(){
		String relReqYN = "N";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM";
		try{
			con = ConnectionManager.getConnection();
			if(con!=null){
				pstmt=con.prepareStatement(query.toString());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					relReqYN=rs.getString("ESTABLISH_RELN_REQ_YN");
				}
			}
			
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(SQLException e){
			System.out.println("A database exception occurred while finding patientPractRelnReqdYN" +e);
		}
		catch(Exception e){
			System.out.println("An exception occurred while finding patientPractRelnReqdYN" +e);
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
		return relReqYN; 
	}

}
