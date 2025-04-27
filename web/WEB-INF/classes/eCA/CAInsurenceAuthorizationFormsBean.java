/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
07/11/2018      AAKH-CRF-0079.2  prathyusha      
25/06/2019		IN070757			Sivabagyam M	  		25/06/2019				Ramesh G.		AAKH-CRF-0079.8
23/12/2019  IN071639        SIVABAGYAM M 23/12/2019          Ramesh G      AAKH-CRF-0079.10
28/01/2020  IN072296       SIVABAGYAM M  28/01/2020          Ramesh G      CA-AAKH-CRF-0079.10/02-Saved Approval Number doesn't display.
---------------------------------------------------------------------------------------------------------------
*/
package eCA;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.Serializable;
import eCommon.Common.*;
import webbeans.eCommon.*; 
import eCA.Common.CaAdapter;


public class CAInsurenceAuthorizationFormsBean extends CaAdapter implements Serializable  {
	 private String facility_id = null;
	public CAInsurenceAuthorizationFormsBean() {}
	public String getInsurenceFormsCount(String patient_id,String encounter_id) throws Exception{
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		
		String count="0";
		try{
			connection				= ConnectionManager.getConnection() ;
			//MODIFIED FOR in069204
			String str_qry			= "select count(*) count from bl_encounter_payer_priority where patient_id = ?  AND DECODE(EPISODE_TYPE,'O',EPISODE_ID||LPAD(VISIT_ID,4,'0'),'E',EPISODE_ID||LPAD(VISIT_ID,4,'0'),'I',EPISODE_ID,'D',EPISODE_ID)  = ? AND settlement_ind = 'X'";
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count	= resultSet.getString("COUNT");	
			}
		
		}catch ( Exception e ) {
			
			System.err.println( "Error sys_date_plus_days  :"+e ) ;
			e.printStackTrace() ;
		}
		
		finally{
			try{
				resultSet.close();
				pstmt.close();
				connection.close();
			}catch(Exception ex){
			
			}
		}
		return count;
	}
	public ArrayList getEncounterIdDetails( String patient_id, String login_facility_id) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList EncounterIdList = new ArrayList();
		try{
			connection = ConnectionManager.getConnection() ;
			pstmt		= connection.prepareStatement("SELECT   encounter_id FROM pr_encounter WHERE patient_id = ? AND facility_id = ? ORDER BY VISIT_ADM_DATE_TIME DESC");
			pstmt.setString(1, patient_id);
		    pstmt.setString(2, login_facility_id);
			
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					EncounterIdList.add(resultSet.getString("ENCOUNTER_ID"));
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		
			finally
		{
			if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
			if(connection != null) ConnectionManager.returnConnection(connection);
		}
		return EncounterIdList;
	}
	public ArrayList getPatientInsurenceAuthorizationDetails(String patient_id,String encounter_id,String language_id) throws Exception {		
		ArrayList PatientInsurenceAuthorizationDetails			= new ArrayList();
		Connection connection       	= null ;
		PreparedStatement pstmt     	= null ;
		ResultSet resultSet         	= null ;
			
		String priority	=	"";
		String policy_type_code	=	"";
		String short_desc	=	"";
		String report_id	=	"",approval_number="";
		String[] insurnceList=null;
		try{
			connection				= ConnectionManager.getConnection() ;
			//String str_qry			= "SELECT A.POLICY_TYPE_CODE,blcommonproc.get_polity_type_desc(A.POLICY_TYPE_CODE,?,'S')POLICY_NAME,A.PRIORITY , B.INS_REP_ID FROM BL_ENCOUNTER_PAYER_PRIORITY A, AR_CUSTOMER B WHERE A.CUST_CODE = B.CUST_CODE AND A.SETTLEMENT_IND = 'X' AND decode(episode_type,'O',episode_id||lpad(visit_id,4,'0'),'E',episode_id||lpad(visit_id,4,'0'),'I',episode_id,'D',episode_id) = ? AND A.PATIENT_ID=? ";
			String str_qry ="SELECT A.POLICY_TYPE_CODE,BLCOMMONPROC.GET_POLITY_TYPE_DESC(A.POLICY_TYPE_CODE,?,'S')POLICY_NAME,A.PRIORITY , B.INS_REP_ID FROM BL_ENCOUNTER_PAYER_PRIORITY A, AR_CUSTOMER B WHERE A.CUST_CODE = B.CUST_CODE AND A.SETTLEMENT_IND = 'X' AND DECODE(A.EPISODE_TYPE,'O',A.EPISODE_ID||LPAD(A.VISIT_ID,4,'0'),'E',A.EPISODE_ID||LPAD(A.VISIT_ID,4,'0'),'I',A.EPISODE_ID,'D',A.EPISODE_ID) = ? AND A.PATIENT_ID=? ORDER BY A.PRIORITY";
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1, language_id);//episode_id
			pstmt.setString(2, encounter_id);//patient_id
			pstmt.setString(3, patient_id);//patient_id
			
			
			resultSet				= pstmt.executeQuery();
			while(resultSet.next()){
				priority	= resultSet.getString("PRIORITY");	
				policy_type_code=resultSet.getString("POLICY_TYPE_CODE"); 
				short_desc=resultSet.getString("POLICY_NAME");
				report_id=resultSet.getString("INS_REP_ID")==null?"":resultSet.getString("INS_REP_ID");
				approval_number=getApprovalNumber(connection,patient_id, encounter_id, report_id);
				insurnceList=new String[3];
				insurnceList[0]=short_desc;
				insurnceList[1]=report_id;
				insurnceList[2]=approval_number;
				PatientInsurenceAuthorizationDetails.add(insurnceList);
			}
			
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally{
			if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
			if(connection != null) ConnectionManager.returnConnection(connection);
		}
			
		return PatientInsurenceAuthorizationDetails;

	}
	
	//AAKH_CRF_0079 start
	public String getFacility_id(String patient_id,String encounter_id) {
		Connection con			    	= null ;
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql = null;
		String facility = null;
		//int id=1;  //COMMON-ICN-0122
		try{
			con				=	ConnectionManager.getConnection();
			sql="select facility_id from PR_ENCOUNTER where patient_id=? and encounter_id=?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, patient_id);//encounter_id
			pstmt.setString(2, encounter_id);//patient_id
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				facility = rs.getString("facility_id");
			}
			if(rs!=null)
					rs.close();
			if(pstmt!=null)
				pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			if(con != null) ConnectionManager.returnConnection(con);
		}
		return facility;
	}
	
	public ArrayList<String> getFormData(String patient_id,String encounter_id,String facility_id){
		Connection con			    	= null ;
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String mainQuery = null;
		//String subQuery1 = null; //COMMON-ICN-0122
		String patient_name = "";
		String patient_class = "";
		String contact_no = "";
		String visit_adm_date = "";
		String visit_adm_type_ind = "";
		String mv_accident_yn = "";
		String attend_practitioner_id = "";
		String policy_number 			= "" ; 
		String provider_name = "";
		String physician_license_no = "";
		String referral_id = "";
		String referral_source = "";
		String visit_adm_date_time = "";
		String exp_length_of_stay = "";
		String exp_date = "";
		String specify = "";
		String attend_practitioner_name = "";
		String admission_yn = "";
		String mri_yn = "";
		String ct_scan_yn = "";
		String physio_yn = "";
		String home_nursing_yn = "";
		String endoscopy_yn = "";
		String others_yn = "";
		String chiefComplaints ="";
		String anitManiPlan="",diagnosisIC9="",day_care="";//IN070757

		ArrayList<String> record = new ArrayList<String>();
		String language_id = "en";
		try{
			con				=	ConnectionManager.getConnection();
			mainQuery="SELECT b.facility_id, b.referral_id, b.visit_adm_type_ind, SUBSTR (a.patient_name, 1, 50) || ' ( '|| b.patient_id || ' / ' || b.encounter_id||' ) ' patient_name, a.patient_id, a.contact2_no, TO_CHAR (b.visit_adm_date_time, 'DD-MON-YYYY') VISIT_ADM_DATE, b.admit_practitioner_id, b.patient_class, b.encounter_id, b.mv_accident_yn, SUBSTR (am_get_desc.am_practitioner (b.attend_practitioner_id, ?, '2' ), 1, 25 ) attend_practitioner, TO_CHAR(b.visit_adm_date_time,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time,b.attend_practitioner_id FROM mp_patient a, pr_encounter b WHERE a.patient_id = b.patient_id AND b.facility_id = ? AND b.encounter_id = ? AND b.patient_id = ?";
			pstmt			=	con.prepareStatement(mainQuery);
			pstmt.setString(1, language_id);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, patient_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				patient_name 	     = checkForNull(rs.getString( "PATIENT_NAME" ),"");
				patient_class  		 = checkForNull(rs.getString( "PATIENT_CLASS" ),"");  
				contact_no    		 = checkForNull(rs.getString( "contact2_no" ),""); 
				visit_adm_date  	 = checkForNull(rs.getString( "VISIT_ADM_DATE" ),""); 
				visit_adm_date_time  	 = checkForNull(rs.getString( "VISIT_ADM_DATE_TIME" ),""); 
				attend_practitioner_id  = checkForNull(rs.getString( "ATTEND_PRACTITIONER_ID" ),"");
				visit_adm_type_ind  = checkForNull(rs.getString( "VISIT_ADM_TYPE_IND" ),"");
				mv_accident_yn  = checkForNull(rs.getString( "MV_ACCIDENT_YN" ),""); 
				referral_id  = checkForNull(rs.getString( "REFERRAL_ID" ),"");
				attend_practitioner_name  = checkForNull(rs.getString( "ATTEND_PRACTITIONER" ),"");
			}
			if(rs!=null)
					rs.close();
			record.add(patient_name);//0
			//policy number using different query
			policy_number = getCardId(con,facility_id,patient_id,patient_class,encounter_id);
			record.add(policy_number);//1
			record.add(contact_no);//2
			//provider name using different query
			//provider_name = getProviderName(con,facility_id);//IN070757
			provider_name = getProviderName(con,facility_id,patient_class,encounter_id,patient_id);//IN070757
			record.add(provider_name);//3
			//physician license no using different query
			physician_license_no = getPhysicianLicenseNo(con,attend_practitioner_id);
			record.add(physician_license_no);//4
			record.add(visit_adm_date);//5
			record.add(patient_class);//6
			record.add(visit_adm_type_ind);//7
			record.add(mv_accident_yn);//8
			record.add(referral_id);//9
			//referral source using different query
			referral_source = getReferralSource(con,facility_id,patient_id,encounter_id);
			record.add(referral_source);//10
			//Expected length of stay using different query
			exp_length_of_stay = getExpectedLengthOfStay(con,visit_adm_date_time,facility_id,patient_id,encounter_id);
			record.add(exp_length_of_stay);//11
			//Expected Date using different query
			exp_date = getExpectedDate(con, visit_adm_date_time, facility_id, patient_id, encounter_id);
			record.add(exp_date);//12
			//Specify using different query
			specify = getSpecify(con, facility_id, patient_id, encounter_id);
			record.add(specify);//13
			record.add(attend_practitioner_name);//14
			//Admission check name using different query
			admission_yn = getAdmissionYN(con,facility_id, patient_id, encounter_id);
			record.add(admission_yn);//15
			//MRI check name using different query
			mri_yn = getMRI(con, facility_id, patient_id, encounter_id);
			record.add(mri_yn);//16
			//CT-SCAN check name using different query
			ct_scan_yn = getCTScan(con, facility_id, patient_id, encounter_id);
			record.add(ct_scan_yn);//17
			//Physio check name using different query
			physio_yn = getPhysio(con, facility_id, patient_id, encounter_id);
			record.add(physio_yn);//18
			//home nursing check name using different query
			home_nursing_yn = getHomeNursing(con, facility_id, patient_id, encounter_id);
			record.add(home_nursing_yn);//19
			//Endoscopy check name using different query
			endoscopy_yn = getEndoscopy(con, facility_id, patient_id, encounter_id);
			record.add(endoscopy_yn);//20
			//Others check name using different query
			others_yn = getInsureOthers(con, facility_id, patient_id, encounter_id);
			record.add(others_yn);//21
			chiefComplaints = getChiefComplaints(con,facility_id, patient_id, encounter_id);
				//IN070757 starts
			anitManiPlan=getAntiManPlan(con,facility_id, patient_id, encounter_id);
			diagnosisIC9=getDiagnosisIC9(con,facility_id, patient_id, encounter_id);
			day_care=getDayCare(con,facility_id, patient_id, encounter_id);
			//IN070757 ends
			record.add(chiefComplaints);//22
			record.add(attend_practitioner_id);//23
			//IN070757 starts
			record.add(diagnosisIC9);//24
			record.add(anitManiPlan);//25
			record.add(day_care);//26
			//IN070757 ends
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			if(con != null) ConnectionManager.returnConnection(con);
		}
		return record;
	}
	public String getCardId(Connection con,String facility_id,String patient_id,String patient_class,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String policy_number 			= "" ; 
		try{
			sql="SELECT a.policy_number FROM bl_encounter_payer_priority a WHERE a.operating_facility_id = ? AND a.patient_id = ? AND a.episode_type = DECODE (?, 'OP', 'O', 'IP', 'I', 'EM', 'E', 'DC', 'D', 'RF', 'R' ) AND ( ( ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') =? ) OR (? IN ('IP', 'DC') AND a.episode_id = ?) ) AND a.priority = 1 AND a.cust_code IS NOT NULL";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, patient_class);
			pstmt.setString(4, patient_class);
			pstmt.setString(5, encounter_id);
			pstmt.setString(6, patient_class);
			pstmt.setString(7, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				policy_number 	     = checkForNull(rs.getString( "POLICY_NUMBER" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return policy_number;
	}
	//public String getProviderName(Connection con,String facility_id){
	public String getProviderName(Connection con,String facility_id,String patient_class,String encounter_id,String patient_id){
		PreparedStatement pstmt     	= null ;
		PreparedStatement pstmt1     	= null ;
		ResultSet rs			       	= null ;
		ResultSet rs1			       	= null ;
		String sql						= null ;
		//StringBuilder sb=new StringBuilder();  //COMMON-ICN-0122
		String provider_name = "";
		try{
			//IN070757 starts
			//sql="SELECT SUBSTR(FACILITY_NAME,1,30)||' / '||FACILITY_ID PROVIDER_NAME FROM SM_FACILITY_PARAM WHERE FCILITY_ID=?";
			sql="SELECT SUBSTR(FACILITY_NAME,1,30)||' / '  facility_name FROM SM_FACILITY_PARAM WHERE FACILITY_ID=?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			rs				=	pstmt.executeQuery();			
			if(rs.next()) {
				provider_name += checkForNull(rs.getString( "facility_name" ));
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			String sql1="SELECT b.cust_alpha_code PROVIDER_NAME FROM bl_encounter_payer_priority a,ar_customer b WHERE a.operating_facility_id = ? AND a.patient_id = ? AND a.episode_type =DECODE (?,'OP', 'O','IP', 'I','EM', 'E','DC', 'D','RF', 'R') AND (   (  ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') =? ) OR (? IN ('IP', 'DC') AND a.episode_id = ?)) AND a.priority = 1 AND a.cust_code IS NOT NULL AND a.cust_code = b.cust_code AND a.cust_group_code = b.cust_group_code" ;			
			pstmt1			=	con.prepareStatement(sql1);
			pstmt1.setString(1, facility_id);
			pstmt1.setString(2, patient_id);
			pstmt1.setString(3, patient_class);
			pstmt1.setString(4, patient_class);
			pstmt1.setString(5, encounter_id);
			pstmt1.setString(6, patient_class);
			pstmt1.setString(7, encounter_id);
			rs1				=	pstmt1.executeQuery();
			if(rs1.next()) {
				provider_name +=checkForNull(rs1.getString("PROVIDER_NAME"));
			}
			//IN070757 ends
			if(rs1 !=null) rs1.close();
			if(pstmt1 !=null) pstmt1.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return provider_name;
	}
	public String getPhysicianLicenseNo(Connection con,String attend_practitioner_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String physician_license_no = "";
		try{
			sql="SELECT SUBSTR(APC_NO,1,20) PHYSICIAN_LICENSE FROM  AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, attend_practitioner_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				physician_license_no 	     = checkForNull(rs.getString( "PHYSICIAN_LICENSE" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return physician_license_no;
	}
	public String getReferralSource(Connection con,String facility_id,String patient_id,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String hist_data = "";
		try{
			sql="SELECT SUBSTR(TO_CHAR(HIST_DATA),1,60)HIST_DATA FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code = 'AKINF_REF' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_REF' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				hist_data 	     = checkForNull(rs.getString( "HIST_DATA" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return hist_data;
	}
	public String getChiefComplaints(Connection con,String facility_id,String patient_id,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String chief_complaints = "";
		StringBuilder s=new StringBuilder();
		try{
			//IN070757 starts
			//sql="SELECT SUBSTR(HIST_DATA,1,300) CHIEF_COMPLAINTS FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code ='AKINF_CCOMP' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code ='AKINF_CCOMP' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			sql="SELECT SUBSTR (hist_data, 1, 300) chief_complaints,contr_sys_event_code,accession_num FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN('AKINF_CCOMP') AND accession_num =(SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_CCOMP') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL (b.status, 'X') != 'E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR (hist_data, 1, 300) chief_complaints,contr_sys_event_code,accession_num FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN('AKINF_CCOMP1') AND accession_num =(SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_CCOMP1') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL (b.status, 'X') != 'E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR (hist_data, 1, 300) chief_complaints,contr_sys_event_code,accession_num FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN('AKINF_CCOMP2') AND accession_num =(SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_CCOMP2') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL (b.status, 'X') != 'E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, patient_id);
			pstmt.setString(9, encounter_id);
			rs				=	pstmt.executeQuery();
			int i=0;//IN070757 starts
			while(rs.next()) {
				if(i!=0)
					s.append(", ");
				
				chief_complaints 	     = checkForNull(rs.getString( "CHIEF_COMPLAINTS" ),"");
				s.append(chief_complaints);
				i++;	
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
			}
		return s.toString();
	}//IN070757 ends
	//IN070757 starts
	public String getAntiManPlan(Connection con,String facility_id,String patient_id,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String anit_man_plan = "";
		StringBuilder s=new StringBuilder();
		try{
			//sql="SELECT SUBSTR(HIST_DATA,1,300) CHIEF_COMPLAINTS FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code ='AKINF_CCOMP' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code ='AKINF_CCOMP' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			sql="SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_DRG') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_DRG') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_CPT') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_CPT') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_HCPCS') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_HCPCS') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_SERV') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_SERV') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_T1') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_T1') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKNINF_T2') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKNINF_T2') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') union all SELECT SUBSTR(HIST_DATA,1,300) ANTI_MAN_PLAN FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKNINF_T3') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKNINF_T3') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, patient_id);
			pstmt.setString(9, encounter_id);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, patient_id);
			pstmt.setString(12, encounter_id);
			pstmt.setString(13, facility_id);
			pstmt.setString(14, patient_id);
			pstmt.setString(15, encounter_id);
			pstmt.setString(16, facility_id);
			pstmt.setString(17, patient_id);
			pstmt.setString(18, encounter_id);
			pstmt.setString(19, facility_id);
			pstmt.setString(20, patient_id);
			pstmt.setString(21, encounter_id);
			rs				=	pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				if(i!=0)
					s.append(", ");
				
				anit_man_plan 	     = checkForNull(rs.getString( "ANTI_MAN_PLAN" ),"");
				s.append(anit_man_plan);
				i++;	
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
			}
		return s.toString();
	}
	public String getDiagnosisIC9(Connection con,String facility_id,String patient_id,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String diagnosis = "";
		StringBuilder s=new StringBuilder();
		try{
			//sql="SELECT SUBSTR(HIST_DATA,1,300) CHIEF_COMPLAINTS FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code ='AKINF_CCOMP' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code ='AKINF_CCOMP' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			sql="SELECT SUBSTR(HIST_DATA,1,300) DIAGNOSIS_IC9 FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_ICD') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_ICD') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') UNION ALL SELECT SUBSTR(HIST_DATA,1,300) DIAGNOSIS_IC9 FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_ICD1') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_ICD1') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT') UNION ALL SELECT SUBSTR(HIST_DATA,1,300) DIAGNOSIS_IC9 FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code IN ('AKINF_ICD2') AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_ICD2') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, patient_id);
			pstmt.setString(9, encounter_id);
			rs				=	pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				if(i!=0)
					s.append(", ");
				
				diagnosis 	     = checkForNull(rs.getString( "DIAGNOSIS_IC9" ),"");
				s.append(diagnosis);
					i++;				
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
			}
		return s.toString();
	}
	public String getDayCare(Connection con,String facility_id,String patient_id,String encounter_id){
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String daycare = "";
		try{
			//sql="SELECT SUBSTR(HIST_DATA,1,300) CHIEF_COMPLAINTS FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code ='AKINF_CCOMP' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code ='AKINF_CCOMP' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			sql="SELECT 'Y' daycare FROM cr_encounter_detail b WHERE b.contr_sys_event_code IN ('AKINF_DC') AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id =? AND b.hist_data_type = 'STR'";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				daycare 	     = checkForNull(rs.getString( "daycare" ),"");
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
			}
		return daycare;
	}
	//IN070757 ends
	private String getExpectedLengthOfStay(Connection con,String visit_adm_date_time, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String lengthOfStay = "";
		try{
			sql="SELECT (NVL(TO_DATE(result_str,'DD/MM/YYYY'),SYSDATE)- TRUNC(TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'))) EXPECTED_STAY FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_ELS' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_ELS' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, visit_adm_date_time);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, encounter_id);
			pstmt.setString(5, facility_id);
			pstmt.setString(6, patient_id);
			pstmt.setString(7, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				lengthOfStay 	     = checkForNull(rs.getString( "EXPECTED_STAY" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return lengthOfStay;
	}
	private String getExpectedDate(Connection con,String visit_adm_date_time, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String expectedDate = "";
		try{
			sql="SELECT TO_CHAR(TO_DATE(result_str,'DD/MM/YYYY'),'DD-MON-YYYY') EXPECTED_DATE FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_EAD' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_EAD' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				expectedDate 	     = checkForNull(rs.getString( "EXPECTED_DATE" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return expectedDate;
	}
	private String getSpecify(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String specify = "";
		try{
			sql="SELECT SUBSTR(TO_CHAR(HIST_DATA),1,80)SPECIFY FROM cr_encounter_detail_txt WHERE hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND contr_sys_event_code = 'AKINF_SPECI' AND accession_num = (SELECT MAX (accession_num) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_SPECI' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ? AND b.hist_data_type = 'TXT')";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				specify 	     = checkForNull(rs.getString( "SPECIFY" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return specify;
	}
	private String getAdmissionYN(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String admission_yn = "";
		try{
			sql="SELECT result_str ADMISSION FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_ADM' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_ADM' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				admission_yn 	     = checkForNull(rs.getString( "ADMISSION" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return admission_yn;
	}
	private String getMRI(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String mri_yn = "";
		try{
			sql="SELECT result_str MRI FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_MRI' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_MRI' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				mri_yn 	     = checkForNull(rs.getString( "MRI" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return mri_yn;
	}
	private String getCTScan(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String ct_scan_yn = "";
		try{
			sql="SELECT result_str CTSCAN FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_CTS' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_CTS' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				ct_scan_yn 	     = checkForNull(rs.getString( "CTSCAN" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return ct_scan_yn;
	}
	private String getPhysio(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String physio_yn = "";
		try{
			sql="SELECT result_str PHYSIO FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_PHYSIO' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_PHYSIO' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				physio_yn 	     = checkForNull(rs.getString( "PHYSIO" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return physio_yn;
	}
	private String getHomeNursing(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String home_nursing_yn = "";
		try{
			sql="SELECT result_str HOME_NURSING FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_HNUR' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_HNUR' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				home_nursing_yn 	     = checkForNull(rs.getString( "HOME_NURSING" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return home_nursing_yn;
	}
	private String getEndoscopy(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String endoscopy_yn = "";
		try{
			sql="SELECT result_str ENDOSCOPY FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_ENDO' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_ENDO' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				endoscopy_yn 	     = checkForNull(rs.getString( "ENDOSCOPY" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return endoscopy_yn;
	}
	private String getInsureOthers(Connection con, String facility_id, String patient_id,String encounter_id) {
		PreparedStatement pstmt     	= null ;
		ResultSet rs			       	= null ;
		String sql						= null ;
		String others_yn = "";
		try{
			sql="SELECT result_str INSURE_OTHERS FROM cr_encounter_detail a WHERE a.contr_sys_event_code = 'AKINF_OTH' AND hist_rec_type = 'PTCR' AND contr_sys_id = 'OR' AND facility_id = ? AND patient_id = ? AND encounter_id = ? AND event_date = (SELECT MAX (event_date) FROM cr_encounter_detail b WHERE b.contr_sys_event_code = 'AKINF_OTH' AND b.hist_rec_type = 'PTCR' AND b.contr_sys_id = 'OR' AND NVL(B.STATUS,'X') !='E' AND b.facility_id = ? AND b.patient_id = ? AND b.encounter_id = ?)";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, patient_id);
			pstmt.setString(6, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()) {
				others_yn 	     = checkForNull(rs.getString( "INSURE_OTHERS" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return others_yn;
	}
	//AAKH_CRF_0079 end
	//IN071639 STARTS
	public String getApprovalNumber(Connection connection,String patient_id,String encounter_id,String report_id) {
		PreparedStatement pstmt	= null ;
		ResultSet rs			= null ;
		String sql				= null ;
		String app_number= "";
		try{
			sql="SELECT APPROVAL_NUMBER FROM CA_PAT_INSU_SIGNATURE WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND REPORT_ID=?";
			pstmt			=	connection.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2,encounter_id );
			pstmt.setString(3,report_id );
			rs			=	pstmt.executeQuery();
			if(rs.next()) {
				app_number 	     = checkForNull(rs.getString( "APPROVAL_NUMBER" ),"");
			}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		return app_number;
	}
	//IN071639ENDS
//IN072296 starts
	public String insertApprovalNumber(String patient_id,String encounter_id,String report_id,String approvalNumber,String loginuserid,String client_ip_address,String facility_id)
	{
		PreparedStatement pstmt   = null ;
		PreparedStatement pstmt1   = null ;
		PreparedStatement pstmt2   = null ;
		String sql				  = null ;
		Connection connection     = null ;
		int count=0,index=1,record=0;
		ResultSet rs=null;
		String sql2=null;
		String result="FAIL";
		try{
			connection				= ConnectionManager.getConnection() ;
			sql2="SELECT COUNT(*)count FROM CA_PAT_INSU_SIGNATURE WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND REPORT_ID=?";
			pstmt2=connection.prepareStatement(sql2);
			pstmt2.setString(1,patient_id);
			pstmt2.setString(2,encounter_id);
			pstmt2.setString(3,report_id);
			rs=pstmt2.executeQuery();
			if(rs.next())
				record=Integer.parseInt(rs.getString("count")==null?"":rs.getString("count"));
			
			if(rs !=null) rs.close();
			if(pstmt2 !=null) pstmt2.close();
			
			if(record==0)
			{
				pstmt1=connection.prepareStatement("INSERT INTO CA_PAT_INSU_SIGNATURE( PATIENT_ID,ENCOUNTER_ID,REPORT_ID,SIGNATURE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SIGNATURE_BLOB,APPROVAL_NUMBER)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)");
				pstmt1.setString(index++, patient_id);
				pstmt1.setString(index++, encounter_id);
				pstmt1.setString(index++, report_id);
				pstmt1.setString(index++, "");
				pstmt1.setString(index++, loginuserid);
				pstmt1.setString(index++, client_ip_address);
				pstmt1.setString(index++, facility_id);
				pstmt1.setString(index++, loginuserid);
				pstmt1.setString(index++, client_ip_address);
				pstmt1.setString(index++, facility_id);
				pstmt1.setString(index++, "");
				pstmt1.setString(index++, approvalNumber);
				count=pstmt1.executeUpdate();
			}
			else
			{
				sql="UPDATE CA_PAT_INSU_SIGNATURE SET APPROVAL_NUMBER= ? WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND REPORT_ID=?";
				pstmt			=	connection.prepareStatement(sql);
				pstmt.setString(index++, approvalNumber);
				pstmt.setString(index++, patient_id);
				pstmt.setString(index++,encounter_id );
				pstmt.setString(index++,report_id );
				count			=	pstmt.executeUpdate();	
			}
			if(count>0) {
				result="SUCCESS";
				connection.commit();
			}else{
				connection.rollback();
			}
			
			if(pstmt !=null) 
				pstmt.close();
			if(pstmt1 !=null) 
				pstmt1.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(connection!=null) 
					connection.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
			
		return  result;
	}
	//IN072296ENDS
}