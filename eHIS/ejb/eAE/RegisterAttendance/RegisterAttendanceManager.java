/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE.RegisterAttendance; 

import java.rmi.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.ejb.*;
import javax.naming.*;
import webbeans.eCommon.*;
import blopin.*;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="RegisterAttendance"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RegisterAttendance"
*	local-jndi-name="RegisterAttendance"
*	impl-class-name="eAE.RegisterAttendance.RegisterAttendanceManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eAE.RegisterAttendance.RegisterAttendanceLocal"
*	remote-class="eAE.RegisterAttendance.RegisterAttendanceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAE.RegisterAttendance.RegisterAttendanceLocalHome"
*	remote-class="eAE.RegisterAttendance.RegisterAttendanceHome"
*	generate= "local,remote"
*
*
*/


public class RegisterAttendanceManager implements SessionBean {
	Connection con;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
	PreparedStatement pstmt5;
	PreparedStatement pstmt6;
	Statement stmt ;
	ResultSet rset;
	ResultSet rs;
	ResultSet rset1;
	CallableStatement cstmt				= null;
	java.util.HashMap results 			= new HashMap() ;
	StringBuffer sb  					= new StringBuffer("");
	StringBuffer sbMessage 				= new StringBuffer("");
	StringBuffer sb_Error_msg		    = new StringBuffer("");
	StringBuffer sb_dflt_locncode		= new StringBuffer("");
	StringBuffer sql					= new StringBuffer("");
	StringBuffer sqlBuff1				= new StringBuffer("");
	StringBuffer sqlBuff2				= new StringBuffer("");
	StringBuffer sqlPREnc				= new StringBuffer("");
	StringBuffer sqlBuild				= new StringBuffer("");
	StringBuffer sqlOPParam				= new StringBuffer("");
	StringBuffer sqlOPEpi				= new StringBuffer("");
	StringBuffer sqlEpiSer				= new StringBuffer("");
	StringBuffer PREncBuf				= new StringBuffer("");
	StringBuffer PREncOth				= new StringBuffer("");
	StringBuffer OPVisit				= new StringBuffer("");
	StringBuffer OPVisitSer				= new StringBuffer("");
	StringBuffer UpPREnc				= new StringBuffer("");
	StringBuffer OPPatQBuf				= new StringBuffer("");
	StringBuffer sqlOPVisit             = new StringBuffer();
	StringBuffer AEPatRelContc			= new StringBuffer("");
	StringBuffer AEPatEmerDet			= new StringBuffer("");
	StringBuffer MPPatOthDet			= new StringBuffer("");
	StringBuffer MPPat					= new StringBuffer("");
	StringBuffer AEPatLog				= new StringBuffer("");
	StringBuffer AEDiseregn		= new StringBuffer("");
	StringBuffer sqlBillEPi				= new StringBuffer("");


	String presenting_problem_code	    = "";
	String brought_dead_yn				= "";
	String clinic_code					= "";
	String error_msg					= "";
	String msgEncounter                 = "N";
	String episodeno					= "";
	String pm_yn						= "N";
	String marked_date                  = "";
	String regn_date_time                  = "";
	String marked_by_id                 = "";
	String deceased_date_time           = "";
	String strMessage					= "0";
	String newFileNO					= "";
	boolean result 						= false;
	boolean proceed						= false;
	boolean result_file					= false;
	int rs1								= 0;
	String encounter_id					= "";
	String episode_id					= "";
	String episode_visit_no				= "";
/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	String practitioner_id				= "";
/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081 */
/*Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023 */
	String isMLCAppl 					= "false";
	SessionContext ctx;
	public final String ENC_ID_REACHED_MAX = "ENC_ID_REACHED_MAX";

	public void ejbCreate() { }
	public void ejbRemove()  { }
	public void ejbActivate()   { }
	public void ejbPassivate()   { }

	public void setSessionContext (SessionContext sessioncontext) {
		ctx = sessioncontext;
	}

	/**
	 *Method to Start Consultation
	 *@param properties Connection Properties
	 *@param hashMap Visit Data
	 *@param hashMap Arrival Data
	 *@param hashMap Related Condacts Data
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap insertRegisterAttendance(Properties p,
			 java.util.HashMap ae_values_add_visit,
			 java.util.HashMap ae_values_arrival,
			 java.util.HashMap ae_values_related_contacts
			 )  {
		sb  				= new StringBuffer();
		sbMessage 			= new StringBuffer("");
		sb_Error_msg		= new StringBuffer("");
		result 				= false;
		rs1					= 0;
		//ML-01-START
		String billdoctype	= "";
		String billdocnum	= "";
		String billgenlater = "";
		String billtotalamt = "";
		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";

		String locale		= (String)ae_values_add_visit.get("locale");
		//ML-01-END
		try{
			con				= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			stmt			= con.createStatement();
			rs				= stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') d from dual")  ;
			rs.next();
			String addedDate= rs.getString("d");
			if (rs != null) rs.close();
			if (stmt != null) stmt.close(); stmt=null;

			if((sb != null) && (sb.length() > 0))   {
				sb.delete(0,sb.length());
			}
			rs1 = 0;
			String ws_no				= p.getProperty("client_ip_address");
//			String episode_id			= "";
			String treat_area           = (String)ae_values_add_visit.get("treat_area");
			if(treat_area == null || treat_area.equals("null") || treat_area == "" || treat_area.equals(""))
				treat_area				= "";
				clinic_code				= (String)ae_values_add_visit.get("location_code"); // from the screen location_code
			if(clinic_code == null || clinic_code.equals("null") || clinic_code == "" || clinic_code.equals(""))
				clinic_code				= "";

			String queue_status;
			String visit_status;
			String queue_date;
			if (!treat_area.equals("")) {
				queue_status			= "02";
				visit_status			= "02";
			}else{
				queue_status			= "01";
				visit_status			= "01";
			}
//		  String episode_visit_no		= "";
		  String new_op_episode_yn      = "Y";
		  String errmsg="";
		  String service_code			= (String)ae_values_add_visit.get("service_code");
		  if(service_code == null || service_code.equals("null") || service_code == "" || service_code.equals(""))
		  service_code					= "";
		  String buildEpisodeRule		= (String)ae_values_add_visit.get("buildEpisodeRule");
		  buildEpisodeRule 				= (buildEpisodeRule == null)?"":buildEpisodeRule;
		  String episode_close_days_fu	="";
		  String episode_close_days_wo_fu ="";
		  String msgPR					= "N";

          episode_id					= "";
		  episode_visit_no				= "0001";
		  new_op_episode_yn				= "Y";
          String upt_contact_dtls_oa_yn=(String)ae_values_add_visit.get("upt_contact_dtls_oa_yn");//added changes  HSA-CRF-0226 [IN:050599]
		  //Added for this CRF GDOH-CRF-0129
		  String referral_toid="";
		  String assigncare_loctype_ind = (String) ae_values_add_visit.get("assigncare_loctype_ind");
		  String assigncare_locacode = (String) ae_values_add_visit.get("assigncare_locacode");
		  Boolean isReferral =false; 		
		  isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");
		  String smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		  if(isReferral && !assigncare_loctype_ind.equals("")){
		        referral_toid = assigncare_loctype_ind+"$"+assigncare_locacode;
		  }		
		//End GDOH-CRF-0129
		//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
		isMLCAppl = (String) ae_values_add_visit.get("isMLCAppl");
		 
		  
		  try{
		  String facility_id=(String)ae_values_add_visit.get("facility_id");
		  String episode_sql="select episode_close_days_fu,episode_close_days_wo_fu from op_param where operating_facility_id = '"+facility_id+"'";
		  stmt			= con.createStatement();
		  rs				= stmt.executeQuery(episode_sql) ;
		  rs.next();
		  episode_close_days_fu= rs.getString("episode_close_days_fu");
		  episode_close_days_wo_fu= rs.getString("episode_close_days_wo_fu");
		  }catch(Exception e){
				 e.printStackTrace();
		  }
	     if (rs != null) rs.close();
		 if (stmt != null) stmt.close(); stmt=null;

		 try
		 {
			cstmt=con.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,episode_id);
			cstmt.setString(2,episode_visit_no);
			cstmt.setString(3,(String)ae_values_add_visit.get("facility_id"));
			cstmt.setString(4,(String) ae_values_add_visit.get("added_by_id"));
			cstmt.setString(5,ws_no);
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);

			cstmt.execute();

			errmsg=cstmt.getString(9);
			if(errmsg == null) errmsg="";
			msgEncounter=cstmt.getString(10);
			if(msgEncounter == null) msgEncounter="N";

			if(errmsg.equals(""))
			 {
				 if(msgEncounter.equals("Y"))
				 {
					  result=false;
				 }else
				 {
					encounter_id	=cstmt.getString(8);
					if(encounter_id == null) encounter_id="";
					episodeno=cstmt.getString(6);
					if(episodeno == null) episodeno="";
					episode_visit_no=cstmt.getString(7);
					if(episode_visit_no == null) episode_visit_no="";
					result			= true;

				 }
			 }else
			 {
				 result				= false;
				 sb.append(errmsg);
			 }
			if(cstmt != null) cstmt.close(); cstmt=null;
		 }catch(Exception e)
		 {
			 e.printStackTrace();
 		     result					 = false;
			 sb.append("Exception in Encounter id generate proc :"+e);

		 }
		 if (result) {
					try {
						String chkSql = "select '1' from op_patient_queue where facility_id = ?  and patient_id = ? and service_code = ?  and queue_status < '07' ";

						pstmt = con.prepareStatement(chkSql);
						pstmt.setString(1, (String)ae_values_add_visit.get("facility_id"));
						pstmt.setString(2, (String)ae_values_add_visit.get("patient_id"));
						pstmt.setString(3, service_code);
						rset = pstmt.executeQuery();

						if (rset != null) {
							if (rset.next()) {
								result = false;
								msgPR = "Y";
							}
						} else {
							result = true;
							msgPR = "N";
						}
						if (rset != null) rset.close();
						if (pstmt != null) pstmt.close();

					} catch (Exception e) {
						e.printStackTrace();
						result = false;
					}
				}
			    // End of Episode Condition
			// Getting the Values here
			String sub_service_code     = (String)ae_values_add_visit.get("sub_service_code");
			if(sub_service_code == null || sub_service_code.equals("null") || sub_service_code == "" || sub_service_code.equals(""))
				sub_service_code		= "";
			String visit_date_time		= (String)ae_values_add_visit.get("visit_date_time");
			if(visit_date_time == null || visit_date_time.equals("null") || visit_date_time == "" || visit_date_time.equals(""))
				visit_date_time			= "";
			String visit_type_code		= (String)ae_values_add_visit.get("visit_type_code");
			if(visit_type_code == null || visit_type_code.equals("null") || visit_type_code == "" || visit_type_code.equals(""))
				visit_type_code			= "";
			String visit_type_ind		= (String)ae_values_add_visit.get("visit_type_ind");
			if(visit_type_ind == null || visit_type_ind.equals("null") || visit_type_ind == "" || visit_type_ind.equals(""))
				visit_type_ind			= "E";
			String patient_type         = "";
			String ambulatory_status	= "";
			queue_date="";
			queue_date=visit_date_time.substring(0,visit_date_time.indexOf(" "));

			//Added here
  if(result)
	{
      try{
		  if((PREncBuf != null) && (PREncBuf.length() > 0))
		  {
			PREncBuf.delete(0,PREncBuf.length());
		  }
	      String  mlc_case_yn	= (String)ae_values_add_visit.get("mlc_case_yn");
		  if(mlc_case_yn == null || mlc_case_yn.equals("null") || mlc_case_yn == "" || mlc_case_yn.equals(""))  mlc_case_yn="N";
		  brought_dead_yn		= (String)ae_values_add_visit.get("brought_dead_yn");
		  if(brought_dead_yn == null || brought_dead_yn.equals("null") || brought_dead_yn == "" || brought_dead_yn.equals(""))
		  brought_dead_yn		= "N";


		    presenting_problem_code		= (String)ae_values_add_visit.get("presenting_problem_code");
		  if(presenting_problem_code == null || presenting_problem_code.equals("null") || presenting_problem_code == "" || presenting_problem_code.equals(""))   presenting_problem_code="";

		 if(brought_dead_yn.equals("Y"))
		 {
			 deceased_date_time = addedDate;
		 }
		 else
		 {
			 deceased_date_time = "";
		 }
		 if (mlc_case_yn.equals("Y") && brought_dead_yn.equals("Y") )
	     {
			 pm_yn = "Y";
		 }
		 else{
			 pm_yn = "N";
		 }
		 if (mlc_case_yn.equals("Y"))
	     {
			 marked_date	= addedDate;
			 marked_by_id	= (String)ae_values_add_visit.get("user_id");
		 }
		 else{
			  marked_date	= "";
			  marked_by_id	= "";
		 }
		 if(episode_id == null || episode_id.equals("")) {
			 episode_id		= episodeno;
			 proceed		= true ;
		 }
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			  practitioner_id= (String)ae_values_add_visit.get("practitioner_id");

			  PREncBuf.append("insert into PR_ENCOUNTER(FACILITY_ID,");
			  PREncBuf.append("ENCOUNTER_ID,PATIENT_ID,");
			  PREncBuf.append("VISIT_ADM_DATE_TIME, VISIT_ADM_TYPE,");
			  PREncBuf.append("VISIT_ADM_TYPE_FACILITY_ID, ");
			  PREncBuf.append("VISIT_ADM_TYPE_IND,ASSIGN_CARE_LOCN_TYPE,");
			  PREncBuf.append("ASSIGN_CARE_LOCN_CODE,");
			  PREncBuf.append("PAT_CURR_LOCN_TYPE,PAT_CURR_LOCN_CODE,");
			  PREncBuf.append("PAT_TRN_TIME, PATIENT_TYPE,");
			  PREncBuf.append("AMBULATORY_STATUS,OP_EPISODE_VISIT_NUM,");
			  PREncBuf.append("RECALL_YN,MDS_COMPLETE_YN,");
			  PREncBuf.append("BACKDATED_YN, VISIT_STATUS,");
			  PREncBuf.append(" MLC_YN, PM_YN,SERVICE_CODE,");
			  PREncBuf.append("SUBSERVICE_CODE, NEW_OP_EPISODE_YN,");
			  PREncBuf.append("AE_EPISODE_YN, EPISODE_ID, ");
			  PREncBuf.append("ADDED_BY_ID, ADDED_DATE,");
			  PREncBuf.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
			  PREncBuf.append("MODIFIED_BY_ID, MODIFIED_DATE,");
			  PREncBuf.append("MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
			  PREncBuf.append("ANCILLARY_YN,BOOKING_CASE_YN,");
			  PREncBuf.append("PATIENT_CLASS,APPT_CASE_YN,");
			  PREncBuf.append("VISIT_STATUS_SET_ON_DATE,VISIT_STATUS_SET_BY_USER ,");
			  PREncBuf.append("REFERRAL_ID,SPECIALTY_CODE,");
			  PREncBuf.append("MARKED_BY_ID,");
              if(!marked_date.equals(""))
				PREncBuf.append("MARKED_DATE,");

			  PREncBuf.append("PRIORITY_ZONE,TREATMENT_AREA_CODE,");
			  PREncBuf.append("BROUGHT_DEAD_YN,ASSIGN_BED_NUM,");
			  if(!deceased_date_time.equals(""))
				PREncBuf.append("DECEASED_DATE_TIME,");

			  PREncBuf.append("DISASTER_YN,DISASTER_TOWN_CODE,DISASTER_TYPE_CODE,MV_ACCIDENT_YN,COMPLAINT_CODE,");
				
				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					PREncBuf.append("ATTEND_PRACTITIONER_ID ,"); }
				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/

			  PREncBuf.append(" DATE_TIME_OF_ACCIDENT,PLACE_OF_ACCIDENT,VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,PAT_POSITION_CODE,");//Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1
    //Below line added for this CRF GDOH-CRF-0129	
	
	//Modified by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
	PREncBuf.append(" TRAUMA_YN,OSCC_YN,MEDICAL_YN,SURGICAL_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,PROTECTIVE_DEVICE_CODE,vehicle_reg_no1,vehicle_reg_no2,referred_locn_code,form60_yn,TRANSPORT_MODE, ARRIVAL_CODE, ACCOMPANIED_BY_CODE, O_AND_G_YN");//Added by Rameswar on 03-Oct-15 for GDOH-CRF-0004.2
	//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
			//Added by Ajay Hatwate for GHL-CRF-0650on 12/07/2023
			if(isMLCAppl.equals("true")){
				PREncBuf.append(", mlc_death_yn, POL_STN_ID, POL_REP_NO, MLC_REMARKS, MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS)");
			}else{
				PREncBuf.append(" )");
			}

			  PREncBuf.append(" values(?,?,?, to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
			  PREncBuf.append("?,?,?,?,?,?,?,sysdate,?,?,?,");
			  PREncBuf.append("?,?,?,?,?,?,?,?,?,?,?,?,sysdate,");
			  PREncBuf.append("?,?,?,sysdate,?,?,'N','N','EM','W',");
			  PREncBuf.append("sysdate,?,?,?,?,");
			  if(!marked_date.equals(""))
				PREncBuf.append("to_date('"+marked_date+"','dd/mm/yyyy hh24:mi'),");
			  PREncBuf.append("?,?,?,?,");
			  if(!deceased_date_time.equals(""))
				PREncBuf.append("to_date('"+deceased_date_time+"','dd/mm/yyyy hh24:mi'),");
		      PREncBuf.append("?,?,?,?,?, ");

				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					PREncBuf.append("'"+ practitioner_id+"' ,"); }
				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/

			 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/	
			 PREncBuf.append("to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?, ");
			 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/	
			
			 //Below line modified by Sangeetha for KDAH-CRF-0347 on 14/apr/17
			 /*Added by Rameswar on 03-Oct-15 for GDOH-CRF-0004.2*/	
			 PREncBuf.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");  //This line modified for the GDOH-CRF-0129
			 /*Added by Rameswar on 03-Oct-15 for GDOH-CRF-0004.2*/	
			//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
			//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
			if(isMLCAppl.equals("true")){
				PREncBuf.append(", ?, ?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),? )");
			}else{
				PREncBuf.append(")");
			}

				if(pstmt!=null) pstmt.close(); pstmt=null;
				pstmt	= con.prepareStatement(PREncBuf.toString());
				pstmt.setString(1,(String)ae_values_add_visit.get("facility_id")) ;
				pstmt.setString(2,encounter_id) ;
				pstmt.setString(3,(String)ae_values_add_visit.get("patient_id")) ;
				pstmt.setString(4,visit_date_time);
				pstmt.setString(5,visit_type_code) ;
				pstmt.setString(6,(String)ae_values_add_visit.get("facility_id")) ;
				pstmt.setString(7,visit_type_ind) ;
				pstmt.setString(8,(String)ae_values_add_visit.get("location_type")) ;
				pstmt.setString(9,(String)ae_values_add_visit.get("location_code")) ;
				pstmt.setString(10,(String)ae_values_add_visit.get("location_type")) ;
				pstmt.setString(11,(String)ae_values_add_visit.get("location_code")) ;
				pstmt.setString(12,patient_type) ;
				pstmt.setString(13,ambulatory_status) ;
				pstmt.setString(14,episode_visit_no) ;
				pstmt.setString(15,"N") ;
				pstmt.setString(16,"N") ;
				pstmt.setString(17,"N") ;
				pstmt.setString(18,visit_status);
				pstmt.setString(19,(String)ae_values_add_visit.get("mlc_case_yn"));
				pstmt.setString(20,pm_yn) ;
				pstmt.setString(21,service_code) ;
				pstmt.setString(22,sub_service_code) ;
				pstmt.setString(23,new_op_episode_yn);
				pstmt.setString(24,"Y") ;
				pstmt.setString(25,episode_id) ;
				pstmt.setString(26,(String)ae_values_add_visit.get("user_id")) ;
				pstmt.setString(27,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
				pstmt.setString(28,(String)ae_values_add_visit.get("facility_id")) ;
				pstmt.setString(29,(String)ae_values_add_visit.get("user_id")) ;
				pstmt.setString(30,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
				pstmt.setString(31,(String)ae_values_add_visit.get("facility_id")) ;
				pstmt.setString(32,(String)ae_values_add_visit.get("user_id")) ;
				pstmt.setString(33,(String)ae_values_add_visit.get("referral_id")) ;
				pstmt.setString(34,(String)ae_values_add_visit.get("speciality_code")) ;
				pstmt.setString(35,marked_by_id) ;
				pstmt.setString(36,(String)ae_values_add_visit.get("priority")) ;
				pstmt.setString(37,(String)ae_values_add_visit.get("treat_area")) ;
				pstmt.setString(38,(String)ae_values_add_visit.get("brought_dead_yn")) ;
				pstmt.setString(39,(String)ae_values_add_visit.get("bed_bay_no"));
				pstmt.setString(40,(String)ae_values_add_visit.get("disaster_yn")) ;
				pstmt.setString(41,(String)ae_values_add_visit.get("disaster_area")) ;
				pstmt.setString(42,(String)ae_values_add_visit.get("disaster_type_code")) ;
				pstmt.setString(43,(String)ae_values_add_visit.get("mv_accident_yn")) ;
				pstmt.setString(44,(String)ae_values_add_visit.get("presenting_problem_code")) ;
				/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
				pstmt.setString(45,(String)ae_values_add_visit.get("accidentdatetime")) ;
				pstmt.setString(46,(String)ae_values_add_visit.get("place_of_accident")) ;
				pstmt.setString(47,(String)ae_values_add_visit.get("vehicle_invol1")) ;
				pstmt.setString(48,(String)ae_values_add_visit.get("vehicle_invol2")) ;
				pstmt.setString(49,(String)ae_values_add_visit.get("PosDurInc")) ;
				/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/	

				 /*Added by Rameswar on 03-Oct-15 for GDOH-CRF-0004.2*/	
				pstmt.setString(50,(String)ae_values_add_visit.get("CaseofTrauma_val")) ;
				pstmt.setString(51,(String)ae_values_add_visit.get("oscc_yn")) ;
				pstmt.setString(52,(String)ae_values_add_visit.get("medical_yn")) ;
				pstmt.setString(53,(String)ae_values_add_visit.get("surgical_yn")) ;
				pstmt.setString(54,(String)ae_values_add_visit.get("mech_injury_catg_code")) ;
				pstmt.setString(55,(String)ae_values_add_visit.get("mech_injury_subcatg_code")) ;
				pstmt.setString(56,(String)ae_values_add_visit.get("protective_device_code")) ;
				 /*Added by Rameswar on 03-Oct-15 for GDOH-CRF-0004.2*/	
				 
				//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
				pstmt.setString(57,(String)ae_values_add_visit.get("Vehicle_Reg_No1")) ;
				pstmt.setString(58,(String)ae_values_add_visit.get("Vehicle_Reg_No2")) ;
				 
				//Below line added for this CRF GDOH-CRF-0129 
				pstmt.setString(59,referral_toid); 
			   //End GDOH-CRF-0129 
				
				pstmt.setString(60,(String)ae_values_add_visit.get("form60_YN")) ;
				
				//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
				pstmt.setString(61,(String)ae_values_add_visit.get("transport_mode")) ;
				pstmt.setString(62,(String)ae_values_add_visit.get("mode_of_arrival")) ;
				pstmt.setString(63,(String)ae_values_arrival.get("accompany_by")) ;

				pstmt.setString(64,checkNullWithDftValue((String)ae_values_add_visit.get("OandGYn"),"N")) ;//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645
				//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
				if(isMLCAppl.equals("true")){
					pstmt.setString(65,checkNullWithDftValue((String)ae_values_add_visit.get("mlc_death_yn"),"N")) ;
					pstmt.setString(66,checkNullWithDftValue((String)ae_values_add_visit.get("police_stn_dtls"),"")) ;
					pstmt.setString(67,checkNullWithDftValue((String)ae_values_add_visit.get("police_rep_no"),"")) ;
					pstmt.setString(68,checkNullWithDftValue((String)ae_values_add_visit.get("mlc_remarks"),"")) ;
					pstmt.setString(69,checkNullWithDftValue((String)ae_values_add_visit.get("date_of_mlc_capture"),"")) ;
					pstmt.setString(70,checkNullWithDftValue((String)ae_values_add_visit.get("outside_mlc_dtls"),"")) ;
				}

		rs1 =  pstmt.executeUpdate();
		if(rs1 > 0){
			result	=	true;
		}
		else
			result	=	false;
       if(pstmt!=null) pstmt.close(); pstmt=null;
	   if((PREncBuf != null) && (PREncBuf.length() > 0))
		{
			PREncBuf.delete(0,PREncBuf.length());
		}
	}catch(Exception e){e.printStackTrace();
	   result	= false;
	   sb.append("Exception in PR_ENCOUNTER :"+e);
	   }
   } // End of if result (for pr_encounter)

   /*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	if(result)
	{
		String followup_enc = (String)ae_values_add_visit.get("followup_enc");
		if(followup_enc == null || followup_enc.equals("null"))
		followup_enc = "";

		if(!followup_enc.equals(""))
		 {
		 try{
               PREncBuf.append("update PR_ENCOUNTER set  ");
			   PREncBuf.append("RECALLED_ENC_ID = ? ,");
			   PREncBuf.append("MODIFIED_BY_ID = ? ,");
			   PREncBuf.append("MODIFIED_DATE  = sysdate ,");
			   PREncBuf.append("MODIFIED_AT_WS_NO	= ? ,");
			   PREncBuf.append("MODIFIED_FACILITY_ID = ? ");
			   PREncBuf.append(" WHERE ENCOUNTER_ID = ? AND FACILITY_ID = ?");
			   pstmt= con.prepareStatement(PREncBuf.toString());
			   pstmt.setString(1, encounter_id) ;
			   pstmt.setString(2, (String)ae_values_add_visit.get("user_id")) ;
			   pstmt.setString(3, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			   pstmt.setString(4, (String)ae_values_add_visit.get("facility_id")) ;
			   pstmt.setString(5, (String)ae_values_add_visit.get("followup_enc")) ;
			   pstmt.setString(6, (String)ae_values_add_visit.get("facility_id")) ;
			   rs1 =  pstmt.executeUpdate();

			   if(rs1 > 0)
					result	= true;
			   else
					result	= false;
			   if(pstmt!=null) pstmt.close(); pstmt=null;
			   if((PREncBuf != null) && (PREncBuf.length() > 0))
				  {
					PREncBuf.delete(0,PREncBuf.length());
				  }
		}catch(Exception e){e.printStackTrace();  result	= false;
		          sb.append("Exception in PR_ENCOUNTER :"+e);
				  }
        }
	}
	/*End ML-MMOH-CRF-0657*/

			if(result) {
				if ( !(buildEpisodeRule.equals("X")) && !(service_code.equals("")) ) {
					try{
						sqlBuild.append("select BUILD_EPISODE_RULE from ");
						sqlBuild.append("OP_PARAM_FOR_FACILITY_SERVICE ");
						sqlBuild.append(" where OPERATING_FACILITY_ID = ? ");
						sqlBuild.append(" and SERVICE_CODE= ? ");
                     if((sqlOPParam != null) && (sqlOPParam.length() > 0)) {
						sqlOPParam.delete(0,sqlOPParam.length());
					  }

						pstmt	= con.prepareStatement(sqlBuild.toString());
						pstmt.setString(1,(String)ae_values_add_visit.get("facility_id")) ;
						pstmt.setString(2,service_code) ;
						rset	= pstmt.executeQuery() ;
						if(!rset.next())  {
							sqlOPParam.append("insert into OP_PARAM_FOR_FACILITY_SERVICE  ");
							sqlOPParam.append("(OPERATING_FACILITY_ID,SERVICE_CODE, ");
							sqlOPParam.append("BUILD_EPISODE_RULE,EPISODE_CLOSE_DAYS_FU,");
							sqlOPParam.append("EPISODE_CLOSE_DAYS_WO_FU, ADDED_BY_ID, ");
							sqlOPParam.append("ADDED_DATE,ADDED_FACILITY_ID,");
							sqlOPParam.append("ADDED_AT_WS_NO,MODIFIED_BY_ID, ");
							sqlOPParam.append("MODIFIED_DATE,MODIFIED_FACILITY_ID,");
							sqlOPParam.append("MODIFIED_AT_WS_NO) values ");
							sqlOPParam.append("(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

							pstmt	= con.prepareStatement(sqlOPParam.toString());
							pstmt.setString(1, (String)ae_values_add_visit.get("facility_id")) ;
							pstmt.setString(2, service_code) ;
							pstmt.setString(3, buildEpisodeRule) ;
							pstmt.setString(4, episode_close_days_fu) ;
							pstmt.setString(5, episode_close_days_wo_fu) ;
							pstmt.setString(6, (String)ae_values_add_visit.get("user_id")) ;
							pstmt.setString(7, (String)ae_values_add_visit.get("facility_id")) ; pstmt.setString(8, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
							pstmt.setString(9, (String)ae_values_add_visit.get("user_id")) ;
							pstmt.setString(10,(String)ae_values_add_visit.get("facility_id")) ;
	     						pstmt.setString(11,(String)ae_values_add_visit.get("addedAtWorkstation")) ;

							rs1 =  pstmt.executeUpdate();
							if(rs1 > 0)
								result	=	true;
							else
								result	=	false;

							if(pstmt!=null) pstmt.close(); pstmt=null;
						}  // end of if !rset.next()
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close(); pstmt=null;
						if((sqlOPParam != null) && (sqlOPParam.length() > 0)) {
							sqlOPParam.delete(0,sqlOPParam.length());
						}
						if((sqlBuild != null) && (sqlBuild.length() > 0)) {
							sqlBuild.delete(0,sqlBuild.length());
						}
					}catch(Exception e){
						 result=false;
						 e.printStackTrace();
						 sb.append("Exception in OP_PARAM_FOR_FACILITY_SERVICE :"+e);
                    }
					if(result && proceed) {
						episode_id = episodeno;
						result = true;
						if(result) {
						 if (buildEpisodeRule.equalsIgnoreCase("S")) {
							try{
                                if((sqlOPEpi != null) && (sqlOPEpi.length() > 0)) {
							        sqlOPEpi.delete(0,sqlOPEpi.length());
						           }
								sqlOPEpi.append("INSERT INTO OP_EPISODE_FOR_SERVICE(");
								sqlOPEpi.append("PATIENT_ID,OPERATING_FACILITY_ID,");
								sqlOPEpi.append("EPISODE_ID,CLINIC_CODE,SERVICE_CODE,");
								sqlOPEpi.append("START_DATE_TIME,EPISODE_STATUS,");
								sqlOPEpi.append("LAST_ENCOUNTER_ID,LAST_VISIT_DATE,");
								sqlOPEpi.append("LAST_VISIT_NUM,ADDED_BY_ID,ADDED_DATE,");
								sqlOPEpi.append("ADDED_FACILITY_ID,ADDED_AT_WS_NO,");
								sqlOPEpi.append("MODIFIED_BY_ID,MODIFIED_DATE,");
								sqlOPEpi.append("MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,");
								sqlOPEpi.append("AE_EPISODE_YN )  values(?,?,?,?,?,sysdate,");
								sqlOPEpi.append("'01',?,sysdate,1,?,sysdate,");
								sqlOPEpi.append("?,?,?,sysdate,?,?,'Y') ");
								pstmt	= con.prepareStatement(sqlOPEpi.toString());

								pstmt.setString(1, (String)ae_values_add_visit.get("patient_id")) ;
								pstmt.setString(2, (String)ae_values_add_visit.get("facility_id")) ;
								pstmt.setString(3, episode_id);    // episode_id
								pstmt.setString(4, clinic_code);   // clinic_code
								pstmt.setString(5, service_code) ; // service_code
								pstmt.setString(6, encounter_id) ;
								pstmt.setString(7, (String)ae_values_add_visit.get("user_id")) ;
								pstmt.setString(8, (String)ae_values_add_visit.get("facility_id")) ;
								pstmt.setString(9, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
								pstmt.setString(10, (String)ae_values_add_visit.get("user_id")) ;
								pstmt.setString(11, (String)ae_values_add_visit.get("facility_id")) ;
								pstmt.setString(12, (String)ae_values_add_visit.get("addedAtWorkstation")) ;

								rs1 =  pstmt.executeUpdate();
								if(rs1 > 0)
									result	=	true;
								else
									result	=	false;
								if(pstmt!=null) pstmt.close(); pstmt=null;
								if((sqlOPEpi != null) && (sqlOPEpi.length() > 0)) {
									sqlOPEpi.delete(0,sqlOPEpi.length());
								}
							}catch(Exception e){e.printStackTrace();
							    result=false;
								sb.append("Exception in OP_EPISODE_FOR_SERVICE 1:"+e);

							}
						} // end of if buildEpisodeRule "S"
						if (result && buildEpisodeRule.equalsIgnoreCase("S"))  {
							try{
								sqlEpiSer.append("UPDATE OP_EPISODE_FOR_SERVICE SET ");
								sqlEpiSer.append("EPISODE_STATUS='99',MODIFIED_BY_ID = ?,");
								sqlEpiSer.append("MODIFIED_DATE  = sysdate,MODIFIED_FACILITY_ID = ?, ");
								sqlEpiSer.append("MODIFIED_AT_WS_NO	= ? ");
								sqlEpiSer.append(" WHERE OPERATING_FACILITY_ID = ? ");
								sqlEpiSer.append(" AND SERVICE_CODE = ? AND EPISODE_ID != ? ");
								sqlEpiSer.append(" AND PATIENT_ID = ?  ");

								pstmt	= con.prepareStatement(sqlEpiSer.toString());

								pstmt.setString(1, (String) ae_values_add_visit.get("user_id")) ;
								pstmt.setString(2, (String) ae_values_add_visit.get("facility_id")) ;
								pstmt.setString(3, (String) ae_values_add_visit.get("addedAtWorkstation")) ;
								pstmt.setString(4, (String) ae_values_add_visit.get("facility_id")) ;
								pstmt.setString(5, service_code) ; // service_code
								pstmt.setString(6, episode_id) ; // episode_id
								pstmt.setString(7, (String) ae_values_add_visit.get("patient_id")) ;

								rs1 =  pstmt.executeUpdate();
								if(pstmt!=null) pstmt.close(); pstmt=null;
								if((sqlEpiSer != null) && (sqlEpiSer.length() > 0)) {
									sqlEpiSer.delete(0,sqlEpiSer.length());
								}
							}catch(Exception e){
								result=false;
								e.printStackTrace();
							    sb.append("Exception in OP_EPISODE_FOR_SERVICE 2:"+e);}
						} // end of if buildEpisodeRule "S"
					} // End of if result
				} // end of if(result && (episode_id == null || episode_id.equals("")))
				else if (result) {
					//update op_episode_for_service
					episode_id = episodeno;
					sqlEpiSer.setLength(0);
					if (buildEpisodeRule.equals("S")) {
						try{
							sqlEpiSer.append("UPDATE OP_EPISODE_FOR_SERVICE SET  ");
							sqlEpiSer.append(" LAST_ENCOUNTER_ID = ?,");
							sqlEpiSer.append("LAST_VISIT_DATE = SYSDATE ,");
							sqlEpiSer.append("LAST_VISIT_NUM = LAST_VISIT_NUM + 1, ");
							sqlEpiSer.append("MODIFIED_BY_ID = ?, ");
							sqlEpiSer.append("MODIFIED_DATE  = SYSDATE, ");
							sqlEpiSer.append("MODIFIED_FACILITY_ID = ?, ");
							sqlEpiSer.append("MODIFIED_AT_WS_NO	= ? ");
							sqlEpiSer.append(" WHERE OPERATING_FACILITY_ID = ? ");
							sqlEpiSer.append(" AND SERVICE_CODE = ? ");
							sqlEpiSer.append(" AND EPISODE_ID = ? AND PATIENT_ID = ? ");

							pstmt	= con.prepareStatement(sqlEpiSer.toString());

							pstmt.setString(1, encounter_id) ;
							pstmt.setString(2, (String) ae_values_add_visit.get("user_id")) ;
							pstmt.setString(3, (String) ae_values_add_visit.get("facility_id")) ;
							pstmt.setString(4, (String) ae_values_add_visit.get("addedAtWorkstation")) ;
							pstmt.setString(5, (String) ae_values_add_visit.get("facility_id")) ;
							pstmt.setString(6, service_code) ; // service_code
							pstmt.setString(7, episode_id) ; // episode_id
							pstmt.setString(8, (String) ae_values_add_visit.get("patient_id")) ;

							rs1 =  pstmt.executeUpdate();
							if(rs1 > 0)
								result	=	true;
							else
								result	=	false;
							if(pstmt!=null) pstmt.close(); pstmt=null;
							if((sqlEpiSer != null) && (sqlEpiSer.length() > 0)) {
								sqlEpiSer.delete(0,sqlEpiSer.length());
							}
						}catch(Exception e){
							result=false;
							e.printStackTrace();
						    sb.append("Exception in OP_EPISODE_FOR_SERVICE 3:"+e);
							}
		} // end of if buildEpisodeRule "S"
	} // else of if result
   } // End of if buildEpisodeRule && service_code
  } // End of if result
  if(result)	   {
	try{
		// search for the record in op_last_visit_for_service
		OPVisit.append("select '1' from OP_LAST_VISIT_FOR_SERVICE ");
		OPVisit.append(" where OPERATING_FACILITY_ID=? and SERVICE_CODE=? ");
		OPVisit.append(" and PATIENT_ID=? ");


		if(pstmt!=null) pstmt.close(); pstmt=null;
		pstmt	= con.prepareStatement(OPVisit.toString());
		pstmt.setString(1,(String)ae_values_add_visit.get("facility_id")) ;
		pstmt.setString(2,service_code) ;
		pstmt.setString(3,(String)ae_values_add_visit.get("patient_id")) ;
		rset	= pstmt.executeQuery() ;
	    if (!rset.next())
	   {
			OPVisitSer.append("insert into OP_LAST_VISIT_FOR_SERVICE ");
			OPVisitSer.append("(PATIENT_ID, OPERATING_FACILITY_ID,");
			OPVisitSer.append("SERVICE_CODE,ENCOUNTER_ID,");
			OPVisitSer.append("ADDED_BY_ID,ADDED_DATE,");
			OPVisitSer.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
			OPVisitSer.append("MODIFIED_BY_ID, MODIFIED_DATE,");
			OPVisitSer.append("MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ");
			OPVisitSer.append("VISIT_ADM_DATE_TIME, ASSIGN_CARE_LOCN_CODE, ");
			OPVisitSer.append("PATIENT_CLASS, REFERRAL_ID, ");
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					OPVisitSer.append("ATTEND_PRACTITIONER_ID ,"); }
				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			OPVisitSer.append("SUBSERVICE_CODE)");
			OPVisitSer.append(" values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,");
			OPVisitSer.append("to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,'EM',?,");
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					OPVisitSer.append("'"+practitioner_id+"' ,"); }
				/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			OPVisitSer.append("?)");
			
		


			if(pstmt!=null) pstmt.close(); pstmt=null;
			pstmt	= con.prepareStatement(OPVisitSer.toString());
			pstmt.setString(1,(String)ae_values_add_visit.get("patient_id")) ;
			pstmt.setString(2,(String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(3,service_code) ;
			pstmt.setString(4,encounter_id) ;
			pstmt.setString(5,(String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(6,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(7,(String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(8,(String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(9,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(10,(String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(11,visit_date_time) ;
			pstmt.setString(12,(String)ae_values_add_visit.get("location_code")) ;
			pstmt.setString(13,(String)ae_values_add_visit.get("referral_id")) ;
			pstmt.setString(14,sub_service_code) ;

			rs1 =  pstmt.executeUpdate();
			if(rs1 > 0)
				result	=	true;
			else
				result	=	false;
			if(pstmt!=null) pstmt.close(); pstmt=null;
			if((OPVisitSer != null) && (OPVisitSer.length() > 0))
			{
				OPVisitSer.delete(0,OPVisitSer.length());
			}
			if((OPVisit != null) && (OPVisit.length() > 0))
			{
				OPVisit.delete(0,OPVisit.length());
			}
		}  // end of if !rset.next()
		else
		{
		 try{
			// Update the record
			OPVisitSer.append("UPDATE OP_LAST_VISIT_FOR_SERVICE SET ");
			OPVisitSer.append(" ENCOUNTER_ID = ? , RECALL_DATE = NULL,");
			OPVisitSer.append(" VISIT_ADM_DATE_TIME = to_date(?,'dd/mm/yyyy hh24:mi:ss'),ASSIGN_CARE_LOCN_CODE = ?,");
            OPVisitSer.append(" PATIENT_CLASS ='EM', ");
			OPVisitSer.append("RECALL_REASON=NULL,MODIFIED_BY_ID = ?,");
			OPVisitSer.append("MODIFIED_DATE  = to_date(?,'dd/mm/yyyy hh24:mi:ss') ,");
			OPVisitSer.append("MODIFIED_FACILITY_ID = ? ,");
			OPVisitSer.append("MODIFIED_AT_WS_NO	= ? ,");
			OPVisitSer.append("REFERRAL_ID	= ? ,");
			OPVisitSer.append("SUBSERVICE_CODE	= ?  ");
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					OPVisitSer.append(",ATTEND_PRACTITIONER_ID='"+practitioner_id+"' "); }
			/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
			OPVisitSer.append(" WHERE OPERATING_FACILITY_ID = ? and SERVICE_CODE = ? ");
			OPVisitSer.append(" and PATIENT_ID=? ");

			if(pstmt!=null) pstmt.close(); pstmt=null;
 			pstmt= con.prepareStatement(OPVisitSer.toString());
			pstmt.setString(1, encounter_id) ;
			pstmt.setString(2, visit_date_time) ;
			pstmt.setString(3, (String)ae_values_add_visit.get("location_code")) ;
			pstmt.setString(4, (String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(5, visit_date_time) ;
			pstmt.setString(6, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(7, (String)ae_values_add_visit.get("addedAtWorkstation"));
			pstmt.setString(8, (String)ae_values_add_visit.get("referral_id")) ;
			pstmt.setString(9, sub_service_code);
			pstmt.setString(10, (String)ae_values_add_visit.get("facility_id"));
			pstmt.setString(11, service_code);
			pstmt.setString(12,(String)ae_values_add_visit.get("patient_id")) ;
			rs1 =  pstmt.executeUpdate();

			 if(rs1!=0)
					result	= true;
			 else
					result	= false;
			if(pstmt!=null) pstmt.close(); pstmt=null;
			if((OPVisitSer != null) && (OPVisitSer.length() > 0))
			{
				OPVisitSer.delete(0,OPVisitSer.length());
			}
		}catch(Exception e){e.printStackTrace();
		 result	= false;  }
		if((OPVisit != null) && (OPVisit.length() > 0))
			{
				OPVisit.delete(0,OPVisit.length());
			}
	  }// end of the else OP_LAST_VISIT_FOR_SERVICE
	}catch(Exception e){e.printStackTrace();
	sb.append("Exception in OP_LAST_VISIT_FOR_SERVICE :"+e);}
	// Code for adding to update pr_referral_register starts here
	String referral_id = (String)ae_values_add_visit.get("referral_id");
	if(referral_id == null) referral_id ="";
	if(result && !referral_id.equals(""))
	{
	 try
	 {
        UpPREnc.append("update pr_referral_register set STATUS='C', referred_in_func = 3,");
		UpPREnc.append("CLOSE_ENCOUNTER_ID= ? ");
		/*Added by Dharma for AUDIT COLUMNS update Start*/ 
		UpPREnc.append(" ,MODIFIED_BY_ID= ? ");
		UpPREnc.append(" ,MODIFIED_DATE= sysdate ");
		UpPREnc.append(" ,MODIFIED_FACILITY_ID= ? ");
		UpPREnc.append(" ,MODIFIED_AT_WS_NO= ? ");
		/*Added by Dharma for AUDIT COLUMNS update End*/
		UpPREnc.append(" where referral_id =? ");
		pstmt2=con.prepareStatement(UpPREnc.toString());
        pstmt2.setString(1, encounter_id) ;
		/*Added by Dharma for AUDIT COLUMNS update Start*/ 
		//pstmt2.setString(2, referral_id) ;
		pstmt2.setString(2, (String)ae_values_add_visit.get("user_id")) ;
		pstmt2.setString(3, (String)ae_values_add_visit.get("facility_id")) ;
		pstmt2.setString(4, (String)ae_values_add_visit.get("addedAtWorkstation"));
		pstmt2.setString(5, referral_id) ;
		/*Added by Dharma for AUDIT COLUMNS update End*/

		if(pstmt2.executeUpdate()>0)
			 result=true;
		else
		{
			result=false;
            sb.append("Exception while updating PR_REFERRAL_REGISTER :");
		}
		if(pstmt2 != null)pstmt2.close(); pstmt2=null;
		if((UpPREnc != null) && (UpPREnc.length() > 0))
		{
			UpPREnc.delete(0,UpPREnc.length());
		}
	}catch(Exception exc12)
	{
		exc12.printStackTrace();
		result=false;
		sb.append("Exception while updating PR_REFERRAL_REGISTER :"+exc12);
	}
   }
 } // end of the result
if(rset!=null) rset.close();

/*
// start ae_disaster_pat_regn table insert
if(result)
	{
	 try{
		 AEDiseregn.append("insert into AE_DISASTER_PAT_REGN (FACILITY_ID,REGN_DATE_TIME,");
	   	 AEDiseregn.append("ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,");
		 AEDiseregn.append("ADDED_FACILITY_ID,");
		 AEDiseregn.append("DIS_REGN_REFERENCE) ");
		 AEDiseregn.append(" VALUES(?,");
		 AEDiseregn.append(" to_date(?,'dd/mm/yyyy hh24:mi'),");
		 AEDiseregn.append("?,sysdate,?,");
		 AEDiseregn.append("?,");
         AEDiseregn.append("?) ");
         if(pstmt!=null) pstmt.close(); pstmt=null;
		     pstmt	= con.prepareStatement(AEDiseregn.toString());
			 pstmt.setString(1,(String)ae_values_add_visit.get("facility_id")) ;
			 pstmt.setString(2,visit_date_time);
     		 pstmt.setString(3,(String)ae_values_add_visit.get("user_id")) ;
		     pstmt.setString(4,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
		     pstmt.setString(5,(String)ae_values_add_visit.get("facility_id"));
			 pstmt.setString(6,(String)ae_values_add_visit.get("dis_regn_reference"));


		 rs1 =  pstmt.executeUpdate();
		 if(rs1 > 0)
			result	=	true;
		 else
		 result	=	false;
		 if(pstmt!=null) pstmt.close(); pstmt=null;
		 if((AEDiseregn != null) && (AEDiseregn.length() > 0))
		 {
		 	AEDiseregn.delete(0,AEDiseregn.length());
		 }
		}catch(Exception e){
			result	= false;
		    sb.append("Exception in AE_DISASTER_PAT_REGN :"+e);
		}
	} //end of the ae_disaster_pat_regn

	*/

  if(result)
	{
	 try{


		 OPPatQBuf.append("insert into OP_PATIENT_QUEUE (FACILITY_ID,");
		 OPPatQBuf.append("QUEUE_DATE, QUEUE_SHIFT, LOCN_TYPE,");
	     OPPatQBuf.append("LOCN_CODE, QUEUE_NUM, PATIENT_ID,");
		 OPPatQBuf.append("PRACTITIONER_ID, APPT_OR_WALK_IN_IND, ");
		 OPPatQBuf.append("ENCOUNTER_ID, CHECK_IN_DATE_TIME, AE_BED_NO, ");
		 OPPatQBuf.append("QUEUE_STATUS,ARRIVE_DATE_TIME, ");
		 OPPatQBuf.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,");
		 OPPatQBuf.append("ADDED_FACILITY_ID,MODIFIED_BY_ID,");
		 OPPatQBuf.append("MODIFIED_DATE, MODIFIED_AT_WS_NO,");
		 OPPatQBuf.append("MODIFIED_FACILITY_ID,PRIORITY_ZONE,");
		 OPPatQBuf.append("TREATMENT_AREA_CODE,");
         if (!treat_area.equals(""))
		 {
		 OPPatQBuf.append("ASSIGN_TMT_AREA_TIME,");
		 }
		 OPPatQBuf.append("PATIENT_CLASS,");
		 OPPatQBuf.append("MLC_YN,VISIT_TYPE_IND,VISIT_TYPE_CODE,");
		 OPPatQBuf.append("SERVICE_CODE,SUBSERVICE_CODE,PAT_CURR_LOCN_CODE,");
		 OPPatQBuf.append("PAT_CURR_LOCN_TYPE,SPECIALITY_CODE,");
		 OPPatQBuf.append("REFERRAL_ID,DISASTER_TYPE_CODE,");
		 if(!deceased_date_time.equals("")){
		   OPPatQBuf.append("DECEASED_DATE_TIME,");
		 }
		 OPPatQBuf.append("PM_YN,BROUGHT_DEAD_YN,DISASTER_YN,DISASTER_TOWN_CODE,EPISODE_ID, OP_EPISODE_VISIT_NUM,");

    	 OPPatQBuf.append("PAT_PRIORITY,MV_ACCIDENT_YN,DIS_REGN_REFERENCE,COMPLAINT_CODE,");

		 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
		OPPatQBuf.append("DATE_TIME_OF_ACCIDENT,PLACE_OF_ACCIDENT,VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,PAT_POSITION_CODE, ");	
		 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

		  /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		OPPatQBuf.append("TRAUMA_YN,OSCC_YN,MEDICAL_YN,SURGICAL_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,PROTECTIVE_DEVICE_CODE ,VEHICLE_REG_NO1,VEHICLE_REG_NO2,O_AND_G_YN,PAT_CRITICAL_CASE_YN) ");//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
		 /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/

		 OPPatQBuf.append(" VALUES(?,TO_DATE(?,'DD/MM/YYYY HH24:MI:ss'),");
		 OPPatQBuf.append("'*ALL',?,?,1,?,?,'W',?,");
		 OPPatQBuf.append("TO_DATE(?,'DD/MM/YYYY HH24:MI:ss'),?,?,sysdate,");
		 OPPatQBuf.append("?,sysdate,?,?,?,sysdate,?,?,?,?,");
         if (!treat_area.equals(""))
		 {
		// OPPatQBuf.append("to_date('"+visit_date_time+"'||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi'),");
		 OPPatQBuf.append("to_date('"+visit_date_time+"','dd/mm/yyyy hh24:mi:ss'),");
		 }
		 OPPatQBuf.append("'EM',?,?,?,?,?,?,?,?,?,?,");
		 if(!deceased_date_time.equals("")){
			OPPatQBuf.append("to_date('"+deceased_date_time+"','dd/mm/yyyy hh24:mi'),");
		 }
		 OPPatQBuf.append("?,?,?,?,?,?,?,?,?,?,");

		 

		 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
		OPPatQBuf.append("to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,");
		 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

		  /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		OPPatQBuf.append("?,?,?,?,?,?,?,?,?,?,?) ");
		  /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/

         if(pstmt!=null) pstmt.close(); pstmt=null;
		 pstmt	= con.prepareStatement(OPPatQBuf.toString());

		 pstmt.setString(1,(String)ae_values_add_visit.get("facility_id")) ;
		 pstmt.setString(2,visit_date_time);
		 pstmt.setString(3,(String)ae_values_add_visit.get("location_type")) ;
		 pstmt.setString(4,(String)ae_values_add_visit.get("location_code")) ;
		 pstmt.setString(5,(String)ae_values_add_visit.get("patient_id")) ;
		 String practId = "*ALL";
		 /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					practId =practitioner_id; }
		/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
		 pstmt.setString(6,practId) ;
		 pstmt.setString(7,encounter_id) ;
		 pstmt.setString(8,visit_date_time);
		 pstmt.setString(9,(String)ae_values_add_visit.get("bed_bay_no")) ;
		 pstmt.setString(10,queue_status) ;
		 pstmt.setString(11,(String)ae_values_add_visit.get("user_id")) ;
		 pstmt.setString(12,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
		 pstmt.setString(13,(String)ae_values_add_visit.get("facility_id")) ;
		 pstmt.setString(14,(String)ae_values_add_visit.get("user_id")) ;
		 pstmt.setString(15,(String)ae_values_add_visit.get("addedAtWorkstation")) ;
		 pstmt.setString(16,(String)ae_values_add_visit.get("facility_id")) ;
		 pstmt.setString(17,(String)ae_values_add_visit.get("priority")) ;
		 pstmt.setString(18,(String)ae_values_add_visit.get("treat_area")) ;
         pstmt.setString(19,(String)ae_values_add_visit.get("mlc_case_yn"));
		 pstmt.setString(20,visit_type_ind);
		 pstmt.setString(21,visit_type_code);
		 pstmt.setString(22,service_code);
		 pstmt.setString(23,sub_service_code);
		 pstmt.setString(24,(String)ae_values_add_visit.get("location_code")) ;
		 pstmt.setString(25,(String)ae_values_add_visit.get("location_type")) ;
		 pstmt.setString(26,(String)ae_values_add_visit.get("speciality_code"));
		 pstmt.setString(27,(String)ae_values_add_visit.get("referral_id"));
		 pstmt.setString(28,(String)ae_values_add_visit.get("disaster_type_code"));
		 pstmt.setString(29,pm_yn);
		 pstmt.setString(30,(String)ae_values_add_visit.get("brought_dead_yn"));
		 pstmt.setString(31,(String)ae_values_add_visit.get("disaster_yn"));
		 pstmt.setString(32,(String)ae_values_add_visit.get("disaster_area"));

	//	 pstmt.setString(33,((encounter_id+"").substring(0,8)));
//	Commented the above line by suresh M on 29.03.2011
		 pstmt.setString(33,episode_id);
		 pstmt.setString(34,episode_visit_no);
		 pstmt.setString(35,(String)ae_values_add_visit.get("priority_no_code"));
		 pstmt.setString(36,(String)ae_values_add_visit.get("mv_accident_yn"));
		 pstmt.setString(37,(String)ae_values_add_visit.get("dis_regn_reference")) ;
		 pstmt.setString(38,(String)ae_values_add_visit.get("presenting_problem_code")) ;

		 /*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
		pstmt.setString(39,(String)ae_values_add_visit.get("accidentdatetime")) ;
		pstmt.setString(40,(String)ae_values_add_visit.get("place_of_accident")) ;
		pstmt.setString(41,(String)ae_values_add_visit.get("vehicle_invol1")) ;
		pstmt.setString(42,(String)ae_values_add_visit.get("vehicle_invol2")) ;
		pstmt.setString(43,(String)ae_values_add_visit.get("PosDurInc")) ;
		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

		 /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		pstmt.setString(44,(String)ae_values_add_visit.get("CaseofTrauma_val")) ;
		pstmt.setString(45,(String)ae_values_add_visit.get("oscc_yn")) ;
		pstmt.setString(46,(String)ae_values_add_visit.get("medical_yn")) ;
		pstmt.setString(47,(String)ae_values_add_visit.get("surgical_yn")) ;
		pstmt.setString(48,(String)ae_values_add_visit.get("mech_injury_catg_code")) ;
		pstmt.setString(49,(String)ae_values_add_visit.get("mech_injury_subcatg_code")) ;
		pstmt.setString(50,(String)ae_values_add_visit.get("protective_device_code")) ;
		 /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		 pstmt.setString(51,(String)ae_values_add_visit.get("Vehicle_Reg_No1")) ;
		pstmt.setString(52,(String)ae_values_add_visit.get("Vehicle_Reg_No2")) ;

		pstmt.setString(53,checkNullWithDftValue((String)ae_values_add_visit.get("OandGYn"),"N")) ;//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645
		pstmt.setString(54,(String)ae_values_add_visit.get("pat_critical_case_yn"));//Added by Shanmukh for MMS-DM-CRF-0147
		 rs1 =  pstmt.executeUpdate();
		 if(rs1 > 0)
			result	=	true;
		 else
		 result	=	false;
		 if(pstmt!=null) pstmt.close(); pstmt=null;
		 if((OPPatQBuf != null) && (OPPatQBuf.length() > 0))
		 {
		 	OPPatQBuf.delete(0,OPPatQBuf.length());
		 }
		}catch(Exception e){
			e.printStackTrace();
			result	= false;
		    sb.append("Exception in OP_PATIENT_QUEUE :"+e);
		}
	} // End of if result

	/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	if(result)
	{
		String followup_enc = (String)ae_values_add_visit.get("followup_enc");
		if(followup_enc == null || followup_enc.equals("null"))
		followup_enc = "";

		if(!followup_enc.equals(""))
		 {
		 try{
               OPPatQBuf.append("update OP_PATIENT_QUEUE set  ");
			   OPPatQBuf.append("RECALLED_ENC_ID = ? ,");
			   OPPatQBuf.append("MODIFIED_BY_ID = ? ,");
			   OPPatQBuf.append("MODIFIED_DATE  = sysdate ,");
			   OPPatQBuf.append("MODIFIED_AT_WS_NO	= ? ,");
			   OPPatQBuf.append("MODIFIED_FACILITY_ID = ? ");
			   OPPatQBuf.append(" WHERE ENCOUNTER_ID = ? AND FACILITY_ID = ?");
			   pstmt= con.prepareStatement(OPPatQBuf.toString());
			   pstmt.setString(1, encounter_id) ;
			   pstmt.setString(2, (String)ae_values_add_visit.get("user_id")) ;
			   pstmt.setString(3, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			   pstmt.setString(4, (String)ae_values_add_visit.get("facility_id")) ;
			   pstmt.setString(5, (String)ae_values_add_visit.get("followup_enc")) ;
			   pstmt.setString(6, (String)ae_values_add_visit.get("facility_id")) ;
			   rs1 =  pstmt.executeUpdate();

			   if(rs1 > 0)
					result	= true;
			   else
					result	= false;
			   if(pstmt!=null) pstmt.close(); pstmt=null;
			   if((OPPatQBuf != null) && (OPPatQBuf.length() > 0))
				  {
					OPPatQBuf.delete(0,OPPatQBuf.length());
				  }
		}catch(Exception e){e.printStackTrace();  result	= false;
		          sb.append("Exception in OP_PATIENT_QUEUE :"+e);
				  }
        }
	}
	/*End ML-MMOH-CRF-0657*/

if(result)
		{
			brought_dead_yn = (String)ae_values_add_visit.get("brought_dead_yn");
			if(brought_dead_yn == null || brought_dead_yn.equals("null") || brought_dead_yn == "" || brought_dead_yn.equals(""))
			brought_dead_yn="N";
			if(brought_dead_yn.equals("Y"))
			{
			  try{

				   MPPat.append("update MP_PATIENT set deceased_date = sysdate , ");
				   MPPat.append("deceased_yn = 'Y' ,active_yn='N', modified_by_id= ? , ");
				   MPPat.append("modified_date=sysdate, modified_at_ws_no= ?,");
				   MPPat.append("modified_facility_id=? where patient_id=? ");

				   pstmt= con.prepareStatement(MPPat.toString());
				   pstmt.setString(1, (String)ae_values_add_visit.get("user_id")) ;
				   pstmt.setString(2, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
				   pstmt.setString(3,  (String)ae_values_add_visit.get("facility_id")) ;
				   pstmt.setString(4, (String)ae_values_add_visit.get("patient_id")) ;
				   rs1 =  pstmt.executeUpdate();

				   if(rs1 > 0)
						result	= true;
				   else
						result	= false;
				   if(pstmt!=null) pstmt.close(); pstmt=null;
				   if((MPPat != null) && (MPPat.length() > 0))
					  {
						MPPat.delete(0,MPPat.length());
					  }
				}catch(Exception e){e.printStackTrace();  result	= false;
				sb.append("Exception in update MP_PATIENT:"+e.toString() );}
			}
		}

	 if(result)
	  {
	   try{
		    PREncOth.append("insert into PR_ENCOUNTER_OTHER_DETAIL(");
		    PREncOth.append("OPERATING_FACILITY_ID,ENCOUNTER_ID,");
		    PREncOth.append("ARRIVAL_CODE,ESCORT_TYPE,");
		    PREncOth.append("ACCOMPANIED_BY_CODE,RELATION_TO_PATIENT,");
		    PREncOth.append("ESCORT_NAME,ESCORT_TEL_NUM,");
		    PREncOth.append("ESCORT_NATIONAL_ID_NO,ESCORT_MV_REG_NO,");
		    PREncOth.append("ESCORT_OTH_ALT_ID_TYPE,ESCORT_OTH_ALT_ID_NO,");
		    PREncOth.append("ESCORT_ADD_LN1,ESCORT_ADD_LN2,");
		    PREncOth.append("ESCORT_ADD_LN3,ESCORT_ADD_LN4,");
		    PREncOth.append("RES_TOWN_CODE,RES_AREA_CODE,");
		    PREncOth.append("ESCORT_REGION_CODE,ESCORT_ADD_POSTAL_CODE,");
		    PREncOth.append("ESCORT_COUNTRY_CODE,ESCORT_REMARKS,");
		    PREncOth.append("ENCOUNTER_TYPE,CHECK_IN_DATE_TIME,");
			PREncOth.append("ADDED_BY_ID, ADDED_DATE,");
			PREncOth.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
			PREncOth.append("MODIFIED_BY_ID, MODIFIED_DATE,");
			PREncOth.append("MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,");
			PREncOth.append("TRANSPORT_MODE) ");
			PREncOth.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,");
			PREncOth.append("to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,sysdate,");
			PREncOth.append("?,?,?,sysdate,?,?,?) ");

			pstmt	= con.prepareStatement(PREncOth.toString());
			pstmt.setString(1, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(2, encounter_id) ;
			pstmt.setString(3, (String)ae_values_add_visit.get("mode_of_arrival"));
			pstmt.setString(4, (String)ae_values_arrival.get("escort_type")) ;
			pstmt.setString(5, (String)ae_values_arrival.get("accompany_by")) ;
			pstmt.setString(6, (String)ae_values_arrival.get("relation_val")) ;
			pstmt.setString(7, (String)ae_values_arrival.get("name_of_escort")) ;
			pstmt.setString(8, (String)ae_values_arrival.get("ambulance_contact_no")) ;
			pstmt.setString(9, (String)ae_values_arrival.get("nat_id_no")) ;
			pstmt.setString(10, (String)ae_values_arrival.get("motor_vehicle_reg_no")) ;
			pstmt.setString(11, (String)ae_values_arrival.get("other_alt_id")) ;
			pstmt.setString(12, (String)ae_values_arrival.get("oth_alt_id")) ;
			pstmt.setString(13, (String)ae_values_arrival.get("e_addr_line1")) ;
			pstmt.setString(14, (String)ae_values_arrival.get("e_addr_line2")) ;
			pstmt.setString(15, (String)ae_values_arrival.get("e_addr_line3")) ;
			pstmt.setString(16, (String)ae_values_arrival.get("e_addr_line4")) ;
			pstmt.setString(17, (String)ae_values_arrival.get("e_res_town_code")) ;
			pstmt.setString(18, (String)ae_values_arrival.get("e_res_area_code")) ;
			pstmt.setString(19, (String)ae_values_arrival.get("e_region_code")) ;
			pstmt.setString(20, (String)ae_values_arrival.get("e_postal_code")) ;
			pstmt.setString(21, (String)ae_values_arrival.get("e_country_code")) ;
			pstmt.setString(22, (String)ae_values_arrival.get("arrival_remarks")) ;
			pstmt.setString(23, (String)ae_values_add_visit.get("enc_type"));
			pstmt.setString(24,visit_date_time);
			pstmt.setString(25, (String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(26, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(27, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(28, (String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(29, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(30, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(31, (String)ae_values_add_visit.get("transport_mode")) ;
			rs1 =  pstmt.executeUpdate();
			if(rs1 > 0)
				result	=	true;
			else
				result	=	false;
			if(pstmt!=null) pstmt.close(); pstmt=null;
			if((PREncOth != null) && (PREncOth.length() > 0))
			{
				PREncOth.delete(0,PREncOth.length());
			}
		}catch(Exception e){e.printStackTrace();
		 result	= false;
		 sb.append("Exception in PR_ENCOUNTER_OTHER_DETAIL :"+e);}
	} // end of if result (for pr_encounter_other_detail)

  if(result)
  {
   if (!treat_area.equals(""))
	{
   try{
        if((AEPatLog != null) && (AEPatLog.length() > 0))
		{
			AEPatLog.delete(0,AEPatLog.length());
		}
	   AEPatLog.append("insert into ae_pat_movement_log ");
	   AEPatLog.append("(patient_id,facility_id,encounter_id, ");
	   AEPatLog.append("assign_tmt_area_code,");
	   AEPatLog.append("assign_date,assign_clinic_code,assign_bed_no,service_code,added_facility_id, ");
	  /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					AEPatLog.append("ASSIGN_PRACTITIONER_ID ,"); }
	   /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/

	   AEPatLog.append("added_date,added_by_id,added_at_ws_no)  values ");
	   AEPatLog.append("(?,?,?,?,");
	   //AEPatLog.append("to_date(?||to_char(sysdate,':ss'),'dd/mm/yyyy hh24:mi:ss'),");
	   AEPatLog.append("to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
	   AEPatLog.append("?,?,?,?,");
	   /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
				if(!practitioner_id.equals("")){
					AEPatLog.append("'"+practitioner_id+"' ,"); }
	   /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	   AEPatLog.append("sysdate,?,?) ");

	

		pstmt				=	con.prepareStatement(AEPatLog.toString());

		pstmt.setString	(	1,	(String)ae_values_add_visit.get("patient_id"));
		pstmt.setString	(	2,	(String)ae_values_add_visit.get("facility_id"));
		pstmt.setString	(	3,	encounter_id);
		pstmt.setString	(	4,	(String)ae_values_add_visit.get("treat_area"));
		pstmt.setString	(	5,	visit_date_time		);
		pstmt.setString	(	6,	(String)ae_values_add_visit.get("location_code"));
		pstmt.setString	(	7,	(String)ae_values_add_visit.get("bed_bay_no"));
        pstmt.setString	(	8,	service_code);
		pstmt.setString	(	9,	(String)ae_values_add_visit.get("facility_id"));
		pstmt.setString	(	10,	(String)ae_values_add_visit.get("user_id"));
		pstmt.setString	(	11,	(String)ae_values_add_visit.get("addedAtWorkstation"));

        if(pstmt.executeUpdate()>0)
				 result=true;
		  else
				 result=false;
	  if((AEPatLog != null) && (AEPatLog.length() > 0))
			{
				AEPatLog.delete(0,AEPatLog.length());
			}
		if(pstmt!=null) pstmt.close(); pstmt=null;
		}
	    catch(Exception e)
	    {
         e.printStackTrace();
		 result	= false;
		 sb.append("Exception in AE_PAT_MOVEMENT_LOG :"+e);
	    }
      }
   }
// From Here to Insert into the AE Tables

 if(result)
  {
	try{
        if((AEPatRelContc != null) && (AEPatRelContc.length() > 0))
		{
			AEPatRelContc.delete(0,AEPatRelContc.length());
		}
		String isAENextofKinchngAppl = (String)ae_values_related_contacts.get("isAENextofKinchngAppl"); // added by mujafar for ML-MMOH-CRF-0632
		String patient_id1_val  = (String)ae_values_related_contacts.get("patient_id1_val");  // added by mujafar for ML-MMOH-CRF-0632
	    //Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		Boolean resiAddMailAdd =false; 		
		resiAddMailAdd=CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");
		
        AEPatRelContc.append("insert into AE_PAT_RELATED_CONTACTS( ");
		AEPatRelContc.append("FACILITY_ID, ENCOUNTER_ID,");
		AEPatRelContc.append("CONTACT1_NAME,CONTACT1_RELATION,");
		AEPatRelContc.append("CONTACT1_NATIONAL_ID_NO,CONTACT1_BIRTH_DATE,");
		AEPatRelContc.append("JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,");
		AEPatRelContc.append("ADDR1_LINE3,ADDR1_LINE4,CONTACT1_TOWN_CODE,");
		AEPatRelContc.append("CONTACT1_AREA_CODE,CONTACT1_REGION_CODE,");
		AEPatRelContc.append("POSTAL1_CODE,COUNTRY1_CODE,RES1_TEL_NO,");
		AEPatRelContc.append("CONTACT1_MOB_TEL_NO,OFF1_TEL_NO,");
		AEPatRelContc.append("CONTACT1_EMAIL_ID,FIRST_TO_NOTIFY_NAME,");
		AEPatRelContc.append("CONTACT2_RELATION,CONTACT2_NATIONAL_ID_NO,");
		AEPatRelContc.append("JOB2_TITLE,RES2_TEL_NO,");
		AEPatRelContc.append("CONTACT2_MOB_TEL_NO,OFF2_TEL_NO,");
		AEPatRelContc.append("CONTACT2_EMAIL_ID,ADDR2_LINE1,");
		AEPatRelContc.append("ADDR2_LINE2,ADDR2_LINE3,");
		AEPatRelContc.append("ADDR2_LINE4,CONTACT2_TOWN_CODE,");
		AEPatRelContc.append("CONTACT2_AREA_CODE,CONTACT2_REGION_CODE,");
		AEPatRelContc.append("POSTAL2_CODE,COUNTRY2_CODE,");
		AEPatRelContc.append("EMPLOYER_NAME,CONTACT3_NAME,");
		AEPatRelContc.append("ADDR3_LINE1,ADDR3_LINE2,");
		AEPatRelContc.append("ADDR3_LINE3,ADDR3_LINE4,");
		AEPatRelContc.append("CONTACT3_TOWN_CODE,CONTACT3_AREA_CODE,");
		AEPatRelContc.append("CONTACT3_REGION_CODE,POSTAL3_CODE,");
		AEPatRelContc.append("COUNTRY3_CODE,RES3_TEL_NO,");
		AEPatRelContc.append("OFF3_TEL_NO,PATIENT_EMPLOYEE_ID,");
		AEPatRelContc.append("OCPN_CLASS_CODE,OCPN_CODE,OCPN_DESC,");
		AEPatRelContc.append("EMPLOYMENT_STATUS,");
		AEPatRelContc.append("ADDED_BY_ID, ADDED_DATE, ");
		AEPatRelContc.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID, ");
		AEPatRelContc.append("MODIFIED_BY_ID, MODIFIED_DATE,");
		AEPatRelContc.append("MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID "); // added by mujafar for ML-MMOH-CRF-0632
		
		if(isAENextofKinchngAppl.equals("true")) 
		AEPatRelContc.append(",REL_PATIENT_ID ");
		//Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		if(resiAddMailAdd){
		AEPatRelContc.append(",nk_mail_addr_line1,nk_mail_addr_line2,nk_mail_addr_line3,nk_mail_addr_line4 ");
		AEPatRelContc.append(",nk_mail_town_code,nk_mail_region_code,nk_mail_area_code,nk_mail_postal_code ");
		AEPatRelContc.append(",nk_mail_country_code,nk_res_contact_name,nk_mail_contact_name ");
		AEPatRelContc.append(",fton_mail_addr_line1,fton_mail_addr_line2,fton_mail_addr_line3,fton_mail_addr_line4 ");
		AEPatRelContc.append(",fton_mail_town_code,fton_mail_region_code,fton_mail_area_code,fton_mail_postal_code ");
		AEPatRelContc.append(",fton_mail_country_code,fton_res_contact_name,fton_mail_contact_name ");
		AEPatRelContc.append(",nk_contact3_mode,nk_contact3_no,nk_contact4_mode,nk_contact4_no ");
		AEPatRelContc.append(",nk_contact5_mode,nk_contact5_no ");
		AEPatRelContc.append(",fton_contact3_mode,fton_contact3_no,fton_contact4_mode,fton_contact4_no ");
		AEPatRelContc.append(",fton_contact5_mode,fton_contact5_no ");
		}
		//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		//else
		AEPatRelContc.append(") ");
		
		
		
		AEPatRelContc.append(" values(?,?,?,?,?,to_date(?,'dd/mm/rrrr'),");
		AEPatRelContc.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,");
		AEPatRelContc.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,");
		AEPatRelContc.append("?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,? "); // added by mujafar for ML-MMOH-CRF-0632
		
		  
		if(isAENextofKinchngAppl.equals("true"))
		AEPatRelContc.append(",? ");
        //Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		if(resiAddMailAdd){
		AEPatRelContc.append(",?,?,?,?,?,?,?,?,?,?,? ");
		AEPatRelContc.append(",?,?,?,?,?,?,?,?,?,?,? ");
		AEPatRelContc.append(",?,?,?,?,?,? ");
		AEPatRelContc.append(",?,?,?,?,?,? ");
	     }
		//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
		//else
		AEPatRelContc.append(") ");
		
		pstmt	= con.prepareStatement(AEPatRelContc.toString());
		int i=1;
		pstmt.setString(i++, (String)ae_values_add_visit.get("facility_id")) ;
		pstmt.setString(i++, encounter_id) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_contact_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_contact_relation")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_new_nat_id_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_birth_date")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_job_title")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_addr_line1")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_addr_line2")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_addr_line3")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_addr_line4")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_res_town_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_res_area_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_region_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_postal_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_country_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_res_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_mob_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("next_off_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact1_email_id")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_contact_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_contact_relation")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_nat_id_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_job_title")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_res_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_mob_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_off_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_email_id")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_addr_line1")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_addr_line2")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_addr_line3")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_addr_line4")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_res_town_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_res_area_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact2_region_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_postal_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_country_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("organization_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("empyr_contact_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("employ_addr_line1")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("employ_addr_line2")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("employ_addr_line3")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("employ_addr_line4")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact3_res_town_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact3_res_area_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("contact3_region_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("employ_postal_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("empyr_country_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("res3_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("empyr_off_tel_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("empyr_eid")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("occ_class")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("occ_of_per")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("occu_of_per_desc")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("empyr_employment_status")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("user_id")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("facility_id")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("user_id")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
		pstmt.setString(i++, (String)ae_values_add_visit.get("facility_id")) ;
		
		if(isAENextofKinchngAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-0632
		pstmt.setString(i++, patient_id1_val) ;
       
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		if(resiAddMailAdd){
        pstmt.setString(i++, (String)ae_values_related_contacts.get("n_next_addr_line1")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_ma_addr_line2")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_ma_addr_line3")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_ma_addr_line4")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_contact_ma_town_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_contact_ma_area_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_contac_region_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("n_ma_postal_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nkin_mail_country_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_res_contact_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_mail_contact_name")) ;

		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_mail_addr_line1")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_mail_addr_line2")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_mail_addr_line3")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_mail_addr_line4")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fst_to_no_ma_town_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fst_to_no_ma_area_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fst_to_no_ma_reg_cod")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fst_no_ma_pos_cod")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("first_mail_country_code")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_res_contact_name")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_mail_contact_name")) ;

		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact3_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact3_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact4_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact4_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact5_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("nk_contact5_no")) ;

		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact3_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact3_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact4_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact4_no")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact5_mode")) ;
		pstmt.setString(i++, (String)ae_values_related_contacts.get("fton_contact5_no")) ;
		}
        //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		
			  rs1 =  pstmt.executeUpdate();
			  if(rs1 > 0)
					result	=	true;
			  else
					result	=	false;
			  if(pstmt!=null) pstmt.close(); pstmt=null;
			  if((AEPatRelContc != null) && (AEPatRelContc.length() > 0))
			  {
				AEPatRelContc.delete(0,AEPatRelContc.length());
			  }
		}catch(Exception e){e.printStackTrace();
        result	= false;
		sb.append("Exception in AE_PAT_RELATED_CONTACTS :"+e);
		}
	}
     // Insert into  AE_PAT_EMERGENCY_DETAIL  Table On 09/07/2004
   if(result)
	  {
	 try{

          brought_dead_yn = (String)ae_values_add_visit.get("brought_dead_yn");
		  if(brought_dead_yn == null || brought_dead_yn.equals("null") || brought_dead_yn == "" || brought_dead_yn.equals(""))
				brought_dead_yn="N";
		 String  mlc_case_yn = (String)ae_values_add_visit.get("mlc_case_yn");
		 if(mlc_case_yn == null || mlc_case_yn.equals("null") || mlc_case_yn == "" || mlc_case_yn.equals(""))  mlc_case_yn="N";

		 String  disaster_yn = (String)ae_values_add_visit.get("disaster_yn");
		 if(disaster_yn == null || disaster_yn.equals("null") || disaster_yn == "" || disaster_yn.equals(""))  disaster_yn="N";


		 String  disaster_area = (String)ae_values_add_visit.get("disaster_area");
		 if(disaster_area == null || disaster_area.equals("null") || disaster_area == "" || disaster_area.equals(""))  disaster_area="";

		/*Below line modified for this CRF ML-MMOH-CRF-0629*/ 
		
		AEPatEmerDet.append("insert into AE_PAT_EMERGENCY_DETAIL( ");
        AEPatEmerDet.append("FACILITY_ID, ENCOUNTER_ID, ");
        AEPatEmerDet.append("AE_ENCOUNTER_TYPE, ARRIVAL_MODE,");
        AEPatEmerDet.append("BURN_YN,");
        AEPatEmerDet.append("BLUNT_INJURY_YN,PENETRATING_INJURY_YN,");
        AEPatEmerDet.append("TETANUS_ADMIN_YN,PREGNANT_YN ,");
        AEPatEmerDet.append("GD_FOR_AGE_YN,IM_UPTO_DATE_YN,  ");
        AEPatEmerDet.append("DISASTER_TYPE_CODE,");
        AEPatEmerDet.append("ADDED_BY_ID, ADDED_DATE,");
        AEPatEmerDet.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
		AEPatEmerDet.append("MODIFIED_BY_ID, MODIFIED_DATE,");
		AEPatEmerDet.append(" MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
		AEPatEmerDet.append("PRIORITY_ZONE,");
        AEPatEmerDet.append("TREATMENT_AREA_CODE,");
        AEPatEmerDet.append("BED_NO,");
        AEPatEmerDet.append("CLINIC_CODE,PAT_PRIORITY,DISASTER_YN,DISASTER_TOWN_CODE,COMPLAINT_CODE,");
		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
        AEPatEmerDet.append("DATE_TIME_OF_ACCIDENT,PLACE_OF_ACCIDENT,VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,PAT_POSITION_CODE,");
		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

		 /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
        AEPatEmerDet.append("TRAUMA_YN,OSCC_YN,MEDICAL_YN,SURGICAL_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,PROTECTIVE_DEVICE_CODE,VEHICLE_REG_NO1,VEHICLE_REG_NO2,priority_zone_red,TRANSPORT_MODE, ARRIVAL_CODE, ACCOMPANIED_BY_CODE, O_AND_G_YN ");//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645 --O_AND_G_YN
		 /*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		 /* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
				if(isMLCAppl.equals("true")){
					AEPatEmerDet.append(", mlc_death_yn, POL_STN_ID, POL_REP_NO, MLC_REMARKS, MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS ");
				}
		 AEPatEmerDet.append(")");
		 /* End GHL-CRF-0650 */
		AEPatEmerDet.append("values(?,?,'A',?,");
        AEPatEmerDet.append("'N','N','N','N','N','N','N',?,?,");
        AEPatEmerDet.append("sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,");

		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
		AEPatEmerDet.append("to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?, ");
		/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

		//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
	 	/*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
		AEPatEmerDet.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?"); //this line modified for this CRF ML-MMOH-CRF-0629
		/* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
				if(isMLCAppl.equals("true")){
					AEPatEmerDet.append(", ?, ?, ?, ?, to_date(?,'DD/MM/YYYY HH24:MI:SS'), ?");
				}
			AEPatEmerDet.append(")");	
		/* End GHL-CRF-0650 */
		/*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/


			pstmt	= con.prepareStatement(AEPatEmerDet.toString());
			pstmt.setString(1, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(2, encounter_id) ;
			pstmt.setString(3, (String)ae_values_add_visit.get("mode_of_arrival"));
			pstmt.setString(4, (String)ae_values_add_visit.get("disaster_type_code"));
    		pstmt.setString(5, (String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(6, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(7, (String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(8, (String)ae_values_add_visit.get("user_id")) ;
			pstmt.setString(9, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			pstmt.setString(10,(String)ae_values_add_visit.get("facility_id")) ;
			pstmt.setString(11,(String)ae_values_add_visit.get("priority")) ;
			pstmt.setString(12,(String)ae_values_add_visit.get("treat_area")) ;
			pstmt.setString(13,(String)ae_values_add_visit.get("bed_bay_no"));
			pstmt.setString(14,(String)ae_values_add_visit.get("location_code"));
			pstmt.setString(15,(String)ae_values_add_visit.get("priority_no_code"));
			pstmt.setString(16,(String)ae_values_add_visit.get("disaster_yn"));
			pstmt.setString(17,(String)ae_values_add_visit.get("disaster_area"));
			pstmt.setString(18,(String)ae_values_add_visit.get("presenting_problem_code")) ;

			/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/
			pstmt.setString(19,(String)ae_values_add_visit.get("accidentdatetime")) ;
			pstmt.setString(20,(String)ae_values_add_visit.get("place_of_accident")) ;
			pstmt.setString(21,(String)ae_values_add_visit.get("vehicle_invol1")) ;
			pstmt.setString(22,(String)ae_values_add_visit.get("vehicle_invol2")) ;
			pstmt.setString(23,(String)ae_values_add_visit.get("PosDurInc")) ;
			/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/

			/*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
			pstmt.setString(24,(String)ae_values_add_visit.get("CaseofTrauma_val")) ;
			pstmt.setString(25,(String)ae_values_add_visit.get("oscc_yn")) ;
			pstmt.setString(26,(String)ae_values_add_visit.get("medical_yn")) ;
			pstmt.setString(27,(String)ae_values_add_visit.get("surgical_yn")) ;
			pstmt.setString(28,(String)ae_values_add_visit.get("mech_injury_catg_code")) ;
			pstmt.setString(29,(String)ae_values_add_visit.get("mech_injury_subcatg_code")) ;
			pstmt.setString(30,(String)ae_values_add_visit.get("protective_device_code")) ;
			/*Added by Rameswar on 03-Oct-16 for GDOH-CRF-0004.2*/
			//Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3
			pstmt.setString(31,(String)ae_values_add_visit.get("Vehicle_Reg_No1")) ;
			pstmt.setString(32,(String)ae_values_add_visit.get("Vehicle_Reg_No2")) ;
			pstmt.setString(33,(String)ae_values_add_visit.get("priorityZone")) ;  //Added for this CRF ML-MMOH-CRF-0629

			//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
			pstmt.setString(34,(String)ae_values_add_visit.get("transport_mode")) ;
			pstmt.setString(35,(String)ae_values_add_visit.get("mode_of_arrival")) ;
			pstmt.setString(36,(String)ae_values_arrival.get("accompany_by")) ;

			pstmt.setString(37,checkNullWithDftValue((String)ae_values_add_visit.get("OandGYn"),"N")) ;//Modified by Thamizh selvi on 21st Mar 2018 against ML-MMOH-CRF-0645
			/* Added by Ajay Hatwate for GHL-CRF-0650 on 18/07/2023 */
				if(isMLCAppl.equals("true")){
					pstmt.setString(38,checkNullWithDftValue((String)ae_values_add_visit.get("mlc_death_yn"),"N")) ;
					pstmt.setString(39,checkNullWithDftValue((String)ae_values_add_visit.get("police_stn_dtls"),"")) ;
					pstmt.setString(40,checkNullWithDftValue((String)ae_values_add_visit.get("police_rep_no"),"")) ;
					pstmt.setString(41,checkNullWithDftValue((String)ae_values_add_visit.get("mlc_remarks"),"")) ;
					pstmt.setString(42,checkNullWithDftValue((String)ae_values_add_visit.get("date_of_mlc_capture"),"")) ;
					pstmt.setString(43,checkNullWithDftValue((String)ae_values_add_visit.get("outside_mlc_dtls"),"")) ;
				}
		/* End GHL-CRF-0650 */
		    rs1 =  pstmt.executeUpdate();

		   if(rs1 > 0)
				result	=	true;
		   else
				result	=	false;
		   if(pstmt!=null) pstmt.close(); pstmt=null;
		   if((AEPatEmerDet != null) && (AEPatEmerDet.length() > 0))
			  {
				AEPatEmerDet.delete(0,AEPatEmerDet.length());
			  }
		  }catch(Exception e){e.printStackTrace();  result	= false;
           sb.append("Exception in AE_PAT_EMERGENCY_DETAIL :"+e);
       }
	 }
	if(result)
	 {
		String blood_group		= (String)ae_values_add_visit.get("blood_group");
		if((blood_group==null) || (blood_group.equals("null")) || (blood_group=="") || (blood_group.equals("")))
			blood_group			= "";
		String rh_factor		= (String)ae_values_add_visit.get("rh_factor");
		if((rh_factor==null) || (rh_factor.equals("null")) || (rh_factor=="") || (rh_factor.equals("")))
		rh_factor			= "";

		if( (!blood_group.equals("")) && (!rh_factor.equals("")))
		 {
		 try{
               MPPatOthDet.append("update MP_PAT_OTH_DTLS set  ");
			   MPPatOthDet.append("BLOOD_GRP = ?, RH_FACTOR = ? ,");
			   MPPatOthDet.append("MODIFIED_BY_ID = ? ,");
			   MPPatOthDet.append("MODIFIED_DATE  = sysdate ,");
			   MPPatOthDet.append("MODIFIED_AT_WS_NO	= ? ,");
			   MPPatOthDet.append("MODIFIED_FACILITY_ID = ? ");
			   MPPatOthDet.append(" WHERE PATIENT_ID = ? ");
			   pstmt= con.prepareStatement(MPPatOthDet.toString());
			   pstmt.setString(1, blood_group) ;
			   pstmt.setString(2, rh_factor) ;
			   pstmt.setString(3, (String)ae_values_add_visit.get("user_id")) ;
			   pstmt.setString(4, (String)ae_values_add_visit.get("addedAtWorkstation")) ;
			   pstmt.setString(5, (String)ae_values_add_visit.get("facility_id")) ;
			   pstmt.setString(6, (String)ae_values_add_visit.get("patient_id")) ;
			   rs1 =  pstmt.executeUpdate();

			   if(rs1 > 0)
					result	= true;
			   else
					result	= false;
			   if(pstmt!=null) pstmt.close(); pstmt=null;
			   if((MPPatOthDet != null) && (MPPatOthDet.length() > 0))
				  {
					MPPatOthDet.delete(0,MPPatOthDet.length());
				  }
		}catch(Exception e){e.printStackTrace();  result	= false;
		          sb.append("Exception in MP_PAT_OTH_DTLS :"+e);
				  }
             } // end of if !blood_group  && !rh_factor
		 } // end of if result
		// String call_mp_pat_add_update = checkForNull((String)ae_values_add_visit.get("call_mp_pat_add_update"));

		// if(call_mp_pat_add_update.equals("Y")) Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
			//{
			  if(result)
	           {
				try
				{
				cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('AE_REGISTER_ATTN')}");
				cstmt.execute();
				if(cstmt != null) cstmt.close(); cstmt=null;
				}catch(Exception e)
				{
				result=false;
				sb.append("Procedure-MP_AUDIT_FUNCTION:"+e.toString());
				e.printStackTrace();
				}
			}
		   if(result)
			{
				String cs="0";
				try{
					//cstmt = con.prepareCall("{call MP_PAT_ADD_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification
					cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 

					    cstmt.setString(1,  checkForNull((String)ae_values_add_visit.get("facility_id")));
					    cstmt.setString(2,  encounter_id);
					    cstmt.setString(3,  "EM");
					    cstmt.setString(4,  checkForNull((String)ae_values_add_visit.get("patient_id")));
						cstmt.setString(5,  checkForNull((String)ae_values_add_visit.get("res_tel_no")));
						cstmt.setString(6,  checkForNull((String)ae_values_add_visit.get("oth_contact_no")));
						cstmt.setString(7,  checkForNull((String)ae_values_add_visit.get("res_area_code")));
						cstmt.setString(8,  checkForNull((String)ae_values_add_visit.get("res_town_code")));
						cstmt.setString(9,  checkForNull((String)ae_values_add_visit.get("res_region_code")));
						cstmt.setString(10,  checkForNull((String)ae_values_add_visit.get("email_id")));
						cstmt.setString(11, checkForNull((String)ae_values_add_visit.get("res_addr_line1")));
						cstmt.setString(12, checkForNull((String)ae_values_add_visit.get("res_addr_line2")));
						cstmt.setString(13, checkForNull((String)ae_values_add_visit.get("res_addr_line3")));
						cstmt.setString(14, checkForNull((String)ae_values_add_visit.get("res_addr_line4")));
						cstmt.setString(15, checkForNull((String)ae_values_add_visit.get("postal_code")));
						cstmt.setString(16, checkForNull((String)ae_values_add_visit.get("country_code")));
						cstmt.setString(17, checkForNull((String)ae_values_add_visit.get("mail_addr_line1")));
						cstmt.setString(18, checkForNull((String)ae_values_add_visit.get("mail_addr_line2")));
						cstmt.setString(19, checkForNull((String)ae_values_add_visit.get("mail_addr_line3")));
						cstmt.setString(20, checkForNull((String)ae_values_add_visit.get("mail_addr_line4")));
						cstmt.setString(21, checkForNull((String)ae_values_add_visit.get("mail_area_code")));
						cstmt.setString(22, checkForNull((String)ae_values_add_visit.get("mail_town_code")));
						cstmt.setString(23, checkForNull((String)ae_values_add_visit.get("mail_postal_code")));
						cstmt.setString(24, checkForNull((String)ae_values_add_visit.get("mail_region_code")));
						cstmt.setString(25, checkForNull((String)ae_values_add_visit.get("mail_country_code")));
						/*Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start*/
						cstmt.setString(26, checkForNull((String)ae_values_add_visit.get("altAddrLine1")));
						cstmt.setString(27, checkForNull((String)ae_values_add_visit.get("altAddrLine2")));
						cstmt.setString(28, checkForNull((String)ae_values_add_visit.get("altAddrLine3")));
						cstmt.setString(29, checkForNull((String)ae_values_add_visit.get("altAddrLine4")));
						cstmt.setString(30, checkForNull((String)ae_values_add_visit.get("altAreaCode")));
						cstmt.setString(31, checkForNull((String)ae_values_add_visit.get("altTownCode")));
						cstmt.setString(32, checkForNull((String)ae_values_add_visit.get("altPostalCode")));
						cstmt.setString(33, checkForNull((String)ae_values_add_visit.get("altRegionCode")));
						cstmt.setString(34, checkForNull((String)ae_values_add_visit.get("altCountryCode")));
						/*End*/
						cstmt.setString(35, checkForNull((String)ae_values_add_visit.get("user_id")));
						cstmt.setString(36, checkForNull((String)ae_values_add_visit.get("addedAtWorkstation")));
						cstmt.registerOutParameter(37,java.sql.Types.VARCHAR);

						cstmt.execute();
						cs = cstmt.getString(37);


						if(cs.equals("1"))
						{
							result = true;
					              //added changes for HSA-CRF-0226 [IN:050599]
									if(upt_contact_dtls_oa_yn.equals("Y")){
									String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+checkForNull((String)ae_values_add_visit.get("patient_id"))+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
									if(rset!=null) rset.close();
		                            if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement(appt_count);
									rset=pstmt.executeQuery();
									int apt_cnt=0;
									if(rset != null && rset.next()){
									apt_cnt=rset.getInt("apt_cnt");
									   } 
									if(rset!=null) rset.close(); //Added for checkstyle
									if(apt_cnt > 0){
									String update_app_contact_dtl="update oa_appt set res_tel_no='"+checkForNull((String)ae_values_add_visit.get("res_tel_no"))+"', oth_contact_no='"+checkForNull((String)ae_values_add_visit.get("oth_contact_no"))+"',email_id='"+checkForNull((String)ae_values_add_visit.get("email_id"))+"', res_addr_line1='"+checkForNull((String)ae_values_add_visit.get("res_addr_line1"))+"', res_addr_line2='"+checkForNull((String)ae_values_add_visit.get("res_addr_line2"))+"',res_addr_line3='"+checkForNull((String)ae_values_add_visit.get("res_addr_line3"))+"', res_addr_line4='"+checkForNull((String)ae_values_add_visit.get("res_addr_line4"))+"',postal_code='"+checkForNull((String)ae_values_add_visit.get("postal_code"))+"',modified_date=sysdate,modified_facility_id='"+checkForNull((String)ae_values_add_visit.get("facility_id"))+"',modified_by_id='"+checkForNull((String)ae_values_add_visit.get("user_id"))+"', modified_at_ws_no='"+checkForNull((String)ae_values_add_visit.get("addedAtWorkstation"))+"',RES_AREA_CODE='"+checkForNull((String)ae_values_add_visit.get("res_area_code"))+"',RES_TOWN_CODE='"+checkForNull((String)ae_values_add_visit.get("res_town_code"))+"',RES_REGION_CODE='"+checkForNull((String)ae_values_add_visit.get("res_region_code"))+"',MAIL_ADDR_LINE1='"+checkForNull((String)ae_values_add_visit.get("mail_addr_line1"))+"',MAIL_ADDR_LINE2='"+checkForNull((String)ae_values_add_visit.get("mail_addr_line2"))+"',MAIL_ADDR_LINE3='"+checkForNull((String)ae_values_add_visit.get("mail_addr_line3"))+"',MAIL_ADDR_LINE4='"+checkForNull((String)ae_values_add_visit.get("mail_addr_line4"))+"',MAIL_AREA_CODE='"+checkForNull((String)ae_values_add_visit.get("mail_area_code"))+"',MAIL_TOWN_CODE='"+checkForNull((String)ae_values_add_visit.get("mail_town_code"))+"',MAIL_REGION_CODE='"+checkForNull((String)ae_values_add_visit.get("mail_region_code"))+"',MAIL_POSTAL_CODE='"+checkForNull((String)ae_values_add_visit.get("mail_postal_code"))+"',MAIL_COUNTRY_CODE='"+checkForNull((String)ae_values_add_visit.get("mail_country_code"))+"',RES_COUNTRY_CODE='"+checkForNull((String)ae_values_add_visit.get("country_code"))+"',alt_addr_line1='"+checkForNull((String)ae_values_add_visit.get("altAddrLine1"))+"',alt_addr_line2='"+checkForNull((String)ae_values_add_visit.get("altAddrLine2"))+"',alt_addr_line3='"+checkForNull((String)ae_values_add_visit.get("altAddrLine3"))+"',alt_addr_line4='"+checkForNull((String)ae_values_add_visit.get("altAddrLine4"))+"',alt_area_code='"+checkForNull((String)ae_values_add_visit.get("altAreaCode"))+"',alt_town_code='"+checkForNull((String)ae_values_add_visit.get("altTownCode"))+"',alt_region_code='"+checkForNull((String)ae_values_add_visit.get("altRegionCode"))+"',alt_postal_code='"+checkForNull((String)ae_values_add_visit.get("altPostalCode"))+"',alt_country_code='"+checkForNull((String)ae_values_add_visit.get("altCountryCode"))+"' where patient_id='"+checkForNull((String)ae_values_add_visit.get("patient_id"))+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";//Modified by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601
									if(pstmt!=null)pstmt.close();
									pstmt=con.prepareStatement(update_app_contact_dtl);
									pstmt.executeUpdate();
									}			
		                            if(pstmt!=null) pstmt.close(); //Added for checkstyle
							       }
							
					     //end  of HSA-CRF-0226 [IN:050599]
						}
						else
						{
							result = false;
							sb.append("Procedure-MP_PAT_ADD_UPDATE:");
						}
            if(cstmt!=null) cstmt.close(); cstmt=null;
				}catch(Exception e){
					result = false;
					e.printStackTrace();
					sb.append("Procedure-MP_PAT_ADD_UPDATE:"+e.toString() );
				}
			  }
			//}//End of call of MP Procedure

  try
	{
	if (result)
	  {
		String treatment_area_code = (String)ae_values_add_visit.get("treat_area");
		if (!treatment_area_code.equals(""))
		{
			StringBuffer	AEPr		=	new StringBuffer() ;
			AEPr.append("{call AE_CALC_QUEUE_SUMM(?, ?, ?, ?, ?, ?, ?)}");

			cstmt					=	con.prepareCall(AEPr.toString());

			cstmt.setString	(	1,  (String)ae_values_add_visit.get("facility_id"));
			cstmt.setString	(	2,	queue_date		);
			cstmt.setString	(	3,	(String)ae_values_add_visit.get("location_type"));
			cstmt.setString	(	4,	(String)ae_values_add_visit.get("location_code"));
			cstmt.setString	(	5,	treatment_area_code	);
			cstmt.setString	(	6,	(String)ae_values_add_visit.get("user_id"));

			cstmt.registerOutParameter	(	7,	java.sql.Types.VARCHAR	);

			cstmt.execute();

			error_msg	=	cstmt.getString(7);

			if(error_msg==null) error_msg = "";
			if(!(error_msg.equals("NO_ERROR")))
			{
				result	= false;
				sb.append(error_msg);
			}
			 if(cstmt!=null) cstmt.close(); cstmt=null;
			}
	  }
	}
	catch(Exception e)
	{
		sb.append("<br>Exception@EJB2: "+e);
		result	= false;
		e.printStackTrace();
	}
	//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	//Starts
	try 
		{
		String biometric_reason=checkForNull((String)ae_values_add_visit.get("biometric_reason"));
	
		if(result && smartCardFunc.equals("01") && !biometric_reason.equals(""))
			{
			String status=eCommon.Common.CommonBean.insertReasonforBiometric(con,(String)ae_values_add_visit.get("facility_id"),"AE_REG_ATTN",(String)ae_values_add_visit.get("patient_id"),encounter_id,(String)ae_values_add_visit.get("location_code"),biometric_reason,checkForNull((String)ae_values_add_visit.get("addedAtWorkstation")),(String)ae_values_add_visit.get("user_id"));
			if(status.equals("S"))
				{
				result	= true;	
				}
			else {
				result	= false;
				}	
			} 
		}
	catch(Exception e)
		{
		result	= false;
		e.printStackTrace();
		}
	//Ends	
//Added for Billing Interface
try
{
	if ( (ae_values_add_visit.get("bl_install_yn").equals("Y")) && (result == true))
    {
			Hashtable ae_values_add_visit1=new Hashtable();
			ae_values_add_visit1.put("bl_interface_yn",(String)ae_values_add_visit.get("bl_interface_yn"));
			ae_values_add_visit1.put("bl_install_yn",(String)ae_values_add_visit.get("bl_install_yn"));
			ae_values_add_visit1.put("visit_charge_stage",(String)ae_values_add_visit.get("visit_charge_stage"));
			ae_values_add_visit1.put("billing_group",(String)ae_values_add_visit.get("billing_group"));
			ae_values_add_visit1.put("fin_dtls",(HashMap)ae_values_add_visit.get("fin_dtls"));
			//Added by prithivi on 06/04/17 for bupa interface crf-0085
			System.out.println("RegisterAttendanceManager.java:::...PAYER_ELIGIBILITY_CHECK_MAP.");
			ae_values_add_visit1.put("PAYER_ELIGIBILITY_CHECK_MAP",(HashMap)ae_values_add_visit.get("PAYER_ELIGIBILITY_CHECK_MAP"));
            ae_values_add_visit1.put("package_bill_doc_type",(String)ae_values_add_visit.get("package_bill_doc_type"));
			ae_values_add_visit1.put("package_bill_doc_num",(String)ae_values_add_visit.get("package_bill_doc_num"));
			ae_values_add_visit1.put("episode_status",(String)ae_values_add_visit.get("episode_status"));
			ae_values_add_visit1.put("episode_type",(String)ae_values_add_visit.get("episode_type"));
			ae_values_add_visit1.put("recordMode",(String)ae_values_add_visit.get("recordMode"));
            ae_values_add_visit1.put("bill_type_code",(String)ae_values_add_visit.get("bill_type_code"));
			ae_values_add_visit1.put("pkg_serv_code",(String)ae_values_add_visit.get("pkg_serv_code"));
			ae_values_add_visit1.put("base_qty",(String)ae_values_add_visit.get("base_qty"));
            ae_values_add_visit1.put("base_rate",(String)ae_values_add_visit.get("base_rate"));
			ae_values_add_visit1.put("base_charge_amt",(String)ae_values_add_visit.get("base_charge_amt"));
			ae_values_add_visit1.put("gross_charge_amt",(String)ae_values_add_visit.get("gross_charge_amt"));
			ae_values_add_visit1.put("disc_amt",(String)ae_values_add_visit.get("disc_amt"));
			ae_values_add_visit1.put("net_charge_amt",(String)ae_values_add_visit.get("net_charge_amt"));
			ae_values_add_visit1.put("pat_base_qty",(String)ae_values_add_visit.get("pat_base_qty"));
			ae_values_add_visit1.put("pat_base_rate",(String)ae_values_add_visit.get("pat_base_rate"));
			ae_values_add_visit1.put("pat_serv_qty",(String)ae_values_add_visit.get("pat_serv_qty"));
			ae_values_add_visit1.put("pat_base_charge_amt",(String)ae_values_add_visit.get("pat_base_charge_amt"));
			ae_values_add_visit1.put("pat_gross_charge_amt",(String)ae_values_add_visit.get("pat_gross_charge_amt"));
			ae_values_add_visit1.put("pat_disc_amt",(String)ae_values_add_visit.get("pat_disc_amt"));
			ae_values_add_visit1.put("pat_net_charge_amt",(String)ae_values_add_visit.get("pat_net_charge_amt"));
			ae_values_add_visit1.put("cust_base_qty",(String)ae_values_add_visit.get("cust_base_qty"));
			ae_values_add_visit1.put("cust_base_rate",(String)ae_values_add_visit.get("cust_base_rate"));
			ae_values_add_visit1.put("cust_serv_qty",(String)ae_values_add_visit.get("cust_serv_qty"));
            ae_values_add_visit1.put("cust_base_charge_amt",(String)ae_values_add_visit.get("cust_base_charge_amt"));
			ae_values_add_visit1.put("cust_gross_charge_amt",(String)ae_values_add_visit.get("cust_gross_charge_amt"));
			ae_values_add_visit1.put("cust_disc_amt",(String)ae_values_add_visit.get("cust_disc_amt"));
			ae_values_add_visit1.put("cust_net_charge_amt",(String)ae_values_add_visit.get("cust_net_charge_amt"));
			ae_values_add_visit1.put("pkg_ins_pat_ind",(String)ae_values_add_visit.get("pkg_ins_pat_ind"));
			ae_values_add_visit1.put("split_yn",(String)ae_values_add_visit.get("split_yn"));
			ae_values_add_visit1.put("pkg_bill_doc_type",(String)ae_values_add_visit.get("pkg_bill_doc_type"));
			ae_values_add_visit1.put("pkg_bill_doc_num",(String)ae_values_add_visit.get("pkg_bill_doc_num"));
			ae_values_add_visit1.put("day_type_code",(String)ae_values_add_visit.get("day_type_code"));
			ae_values_add_visit1.put("time_type_code",(String)ae_values_add_visit.get("time_type_code"));
			ae_values_add_visit1.put("disc_perc",(String)ae_values_add_visit.get("disc_perc"));
			ae_values_add_visit1.put("addl_fctr",(String)ae_values_add_visit.get("addl_fctr"));
			ae_values_add_visit1.put("upd_user_flag",(String)ae_values_add_visit.get("upd_user_flag"));
			ae_values_add_visit1.put("user_id",(String)ae_values_add_visit.get("user_id"));
			ae_values_add_visit1.put("addedAtWorkstation",(String)ae_values_add_visit.get("addedAtWorkstation"));
			ae_values_add_visit1.put("buildEpisodeRule",(String)ae_values_add_visit.get("buildEpisodeRule"));
			ae_values_add_visit1.put("patient_id",(String)ae_values_add_visit.get("patient_id"));
			ae_values_add_visit1.put("referral_id",(String)ae_values_add_visit.get("referral_id"));
			ae_values_add_visit1.put("nationality",(String)ae_values_add_visit.get("nationality"));
			ae_values_add_visit1.put("brought_dead_yn",(String)ae_values_add_visit.get("brought_dead_yn"));
			ae_values_add_visit1.put("mlc_case_yn",(String)ae_values_add_visit.get("mlc_case_yn"));
			ae_values_add_visit1.put("alternate_id",(String)ae_values_add_visit.get("alternate_id"));
			ae_values_add_visit1.put("expiry_date",(String)ae_values_add_visit.get("expiry_date"));
			ae_values_add_visit1.put("blood_group",(String)ae_values_add_visit.get("blood_group"));
			ae_values_add_visit1.put("rh_factor",(String)ae_values_add_visit.get("rh_factor"));
			ae_values_add_visit1.put("visit_date_time",(String)ae_values_add_visit.get("visit_date_time"));
			ae_values_add_visit1.put("location_code",(String)ae_values_add_visit.get("location_code"));
			ae_values_add_visit1.put("location_type",(String)ae_values_add_visit.get("location_type"));
			ae_values_add_visit1.put("service_code",(String)ae_values_add_visit.get("service_code"));
			ae_values_add_visit1.put("visit_type_code",(String)ae_values_add_visit.get("visit_type_code"));
			ae_values_add_visit1.put("visit_type_ind",(String)ae_values_add_visit.get("visit_type_ind"));
			ae_values_add_visit1.put("sub_service",(String)ae_values_add_visit.get("sub_service"));
			ae_values_add_visit1.put("sub_service_code",(String)ae_values_add_visit.get("sub_service_code"));
			ae_values_add_visit1.put("transport_mode",(String)ae_values_add_visit.get("transport_mode"));
			ae_values_add_visit1.put("mode_of_arrival",(String)ae_values_add_visit.get("mode_of_arrival"));
			ae_values_add_visit1.put("priority",(String)ae_values_add_visit.get("priority"));
			ae_values_add_visit1.put("treat_area",(String)ae_values_add_visit.get("treat_area"));
			ae_values_add_visit1.put("bed_bay_no",(String)ae_values_add_visit.get("bed_bay_no"));
			ae_values_add_visit1.put("disaster_yn",(String)ae_values_add_visit.get("disaster_yn"));
			ae_values_add_visit1.put("disaster_area",(String)ae_values_add_visit.get("disaster_area"));
			ae_values_add_visit1.put("new_episode_yn_val",new_op_episode_yn );
			ae_values_add_visit1.put("new_episode_yn",new_op_episode_yn );
			ae_values_add_visit1.put("episode_id",episode_id);
			ae_values_add_visit1.put("episode_visit_no",episode_visit_no);
			ae_values_add_visit1.put("res_tel_no",(String)ae_values_add_visit.get("res_tel_no"));
			ae_values_add_visit1.put("oth_contact_no",(String)ae_values_add_visit.get("oth_contact_no"));
			ae_values_add_visit1.put("res_area_code",(String)ae_values_add_visit.get("res_area_code"));
			ae_values_add_visit1.put("res_town_code",(String)ae_values_add_visit.get("res_town_code"));
			ae_values_add_visit1.put("res_region_code",(String)ae_values_add_visit.get("res_region_code"));
			ae_values_add_visit1.put("email_id",(String)ae_values_add_visit.get("email_id"));
			ae_values_add_visit1.put("res_addr_line1",(String)ae_values_add_visit.get("res_addr_line1"));
			ae_values_add_visit1.put("res_addr_line2",(String)ae_values_add_visit.get("res_addr_line2"));
			ae_values_add_visit1.put("res_addr_line3",(String)ae_values_add_visit.get("res_addr_line3"));
			ae_values_add_visit1.put("res_addr_line4",(String)ae_values_add_visit.get("res_addr_line4"));
			ae_values_add_visit1.put("postal_code",(String)ae_values_add_visit.get("postal_code"));
			ae_values_add_visit1.put("country_code",(String)ae_values_add_visit.get("country_code"));
			ae_values_add_visit1.put("mail_addr_line1",(String)ae_values_add_visit.get("mail_addr_line1"));
			ae_values_add_visit1.put("mail_addr_line2",(String)ae_values_add_visit.get("mail_addr_line2"));
			ae_values_add_visit1.put("mail_addr_line3",(String)ae_values_add_visit.get("mail_addr_line3"));
			ae_values_add_visit1.put("mail_addr_line4",(String)ae_values_add_visit.get("mail_addr_line4"));
			ae_values_add_visit1.put("mail_area_code",(String)ae_values_add_visit.get("mail_area_code"));
			ae_values_add_visit1.put("mail_town_code",(String)ae_values_add_visit.get("mail_town_code"));
			ae_values_add_visit1.put("mail_postal_code",(String)ae_values_add_visit.get("mail_postal_code"));
			ae_values_add_visit1.put("mail_region_code",(String)ae_values_add_visit.get("mail_region_code"));
			ae_values_add_visit1.put("mail_country_code",(String)ae_values_add_visit.get("mail_country_code"));
			ae_values_add_visit1.put("patient_valuables_rcdby",(String)ae_values_add_visit.get("patient_valuables_rcdby"));
			ae_values_add_visit1.put("patient_valuables_chkin_dtm",(String)ae_values_add_visit.get("patient_valuables_chkin_dtm"));
            ae_values_add_visit1.put("enc_type",(String)ae_values_add_visit.get("enc_type"));
			ae_values_add_visit1.put("generate_file",(String)ae_values_add_visit.get("generate_file"));
			ae_values_add_visit1.put("oper_stn_id",(String)ae_values_add_visit.get("oper_stn_id"));
			ae_values_add_visit1.put("sysDateWithoutTime",(String)ae_values_add_visit.get("sysDateWithoutTime"));
			ae_values_add_visit1.put("open_to_all_pract_yn",(String)ae_values_add_visit.get("open_to_all_pract_yn"));
			ae_values_add_visit1.put("facility_id",(String)ae_values_add_visit.get("facility_id"));
			ae_values_add_visit1.put("operating_facility_id",(String)ae_values_add_visit.get("operating_facility_id"));
			ae_values_add_visit1.put("added_by_id",(String)ae_values_add_visit.get("added_by_id"));
			ae_values_add_visit1.put("added_date",(java.sql.Date)ae_values_add_visit.get("added_date"));
			ae_values_add_visit1.put("added_facility_id",(String)ae_values_add_visit.get("added_facility_id"));
			ae_values_add_visit1.put("added_at_ws_no",(String)ae_values_add_visit.get("added_at_ws_no"));
			ae_values_add_visit1.put("modified_by_id",(String)ae_values_add_visit.get("modified_by_id"));
			ae_values_add_visit1.put("modified_date",(java.sql.Date)ae_values_add_visit.get("modified_date"));
			ae_values_add_visit1.put("modified_facility_id",(String)ae_values_add_visit.get("modified_facility_id"));
			ae_values_add_visit1.put("modified_at_ws_no",(String)ae_values_add_visit.get("modified_at_ws_no"));
		    Hashtable prencounter=new Hashtable();
			prencounter.put("facility_id",(String)ae_values_add_visit.get("facility_id"));
            prencounter.put("patient_id",(String)ae_values_add_visit.get("patient_id"));
            prencounter.put("visit_adm_type",(String)ae_values_add_visit.get("visit_type_code"));
            prencounter.put("visit_adm_type_facility_id",(String)ae_values_add_visit.get("facility_id"));
			prencounter.put("assign_care_locn_type",(String)ae_values_add_visit.get("location_type"));
			prencounter.put("assign_care_locn_code",(String)ae_values_add_visit.get("location_code"));
			prencounter.put("appt_case_yn","W");
			prencounter.put("ancillary_yn","N");
			if (!episode_visit_no.equals("")){
				prencounter.put("op_episode_visit_num",episode_visit_no);
			}
			else
		    {
				prencounter.put("op_episode_visit_num","1");
			}
			prencounter.put("recall_yn","N");
			prencounter.put("mds_complete_yn","N");
			prencounter.put("backdated_yn","N");
			prencounter.put("visit_status","1");
			prencounter.put("added_by_id",(String)ae_values_add_visit.get("user_id")) ;
			prencounter.put("added_facility_id", (String)ae_values_add_visit.get("facility_id"));
			prencounter.put("added_at_ws_no",(String)ae_values_add_visit.get("addedAtWorkstation")) ;
			prencounter.put("modified_by_id",(String)ae_values_add_visit.get("user_id")) ;
			prencounter.put("modified_facility_id",(String)ae_values_add_visit.get("facility_id"));
			prencounter.put("modified_at_ws_no",(String)ae_values_add_visit.get("addedAtWorkstation")) ;
            Hashtable prencounterdetail=new Hashtable();
            prencounterdetail.put("operating_facility_id",(String)ae_values_add_visit.get("facility_id"));
		 	prencounterdetail.put("added_by_id",(String)ae_values_add_visit.get("user_id")) ;
			prencounterdetail.put("added_date",(java.sql.Date)ae_values_add_visit.get("added_date")) ;
			prencounterdetail.put("added_facility_id",(String)ae_values_add_visit.get("facility_id"));
			prencounterdetail.put("added_at_ws_no",(String)ae_values_add_visit.get("addedAtWorkstation")) ;
		  	prencounterdetail.put("modified_by_id",(String)ae_values_add_visit.get("user_id")) ;
		   	prencounterdetail.put("modified_date",(java.sql.Date)ae_values_add_visit.get("added_date")) ;
			prencounterdetail.put("modified_facility_id",(String)ae_values_add_visit.get("facility_id"));
			prencounterdetail.put("modified_at_ws_no",(String)ae_values_add_visit.get("addedAtWorkstation")) ;
			java.util.Hashtable blTabdata = ae_values_add_visit1;
			blTabdata.put("episodeno",episode_id);
			blTabdata.put("encounterid",encounter_id);
			blTabdata.put("module_id","AE");

			BLOPVisit  blopVisit = new BLOPVisit();
			java.util.Hashtable  resultsBL = blopVisit.billPatientService(p,con,blTabdata,prencounter,prencounterdetail);
			boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
			//ML-02-START
			String  doctype = (String)(resultsBL.get("billdoctype"));
			String  docnum  = (String)(resultsBL.get("billdocnum"));
			String genlater = (String) (resultsBL.get("billgenlater"));
			String totalamt = (String) (resultsBL.get("billtotalamt"));

			str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
			str_bill_prt_format_vals = (String)(resultsBL.get("bill_prt_format_vals"));
			pgm_id = (String)(resultsBL.get("pgm_id"));
			session_id = (String)(resultsBL.get("session_id"));
			pgm_date = (String)(resultsBL.get("pgm_date"));
			mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));
			//ML-02-END
			result = boolRes;
			//ML-03-START
			billdoctype = doctype;
			billdocnum  = docnum;
			billgenlater = genlater;
			billtotalamt = totalamt;
			//ML-03-END
			strMessage = "";
			if (boolRes == false)
			{
				result = false;
				sb.append((String)resultsBL.get("error"));
			}
			if (boolRes == true)
			{
				result = true;
				strMessage = (String) resultsBL.get("message");
			if (strMessage != null )
				{
				strMessage = strMessage.trim();
			
					if (!strMessage.equalsIgnoreCase("null") && !strMessage.equals(""))
					{
					
						sbMessage.append("<u>"+strMessage+"</u>. <br></FONT>");

					}
				}

			}
	ae_values_add_visit1.clear();
	prencounter.clear();
	prencounterdetail.clear();
	blTabdata.clear();
	resultsBL.clear();
	}
 }
catch(Exception e)
{
    result=false;
    con.rollback() ;
    e.printStackTrace();
    sbMessage.append( e.getMessage() + "<br>" );
}
//End of Billing

			if(result)
			{
				con.commit();

				brought_dead_yn = (String)ae_values_add_visit.get("brought_dead_yn");
				if(brought_dead_yn == null || brought_dead_yn.equals("null") || brought_dead_yn == "" || brought_dead_yn.equals(""))
				brought_dead_yn="N";
                String errors ="";
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "AE_VISIT_REG_COMPLETE", "AE") ;
				String msg = ((String) mesg.get("message"));
				errors =errors + msg + "<B><font size=4>"+encounter_id+"</font></B>. ";

				sbMessage.append(errors);
 			    mesg.clear();
				if(brought_dead_yn.equals("N")){
					if(result_file)
					{
					  con.commit();
					}
					else
	   			    {
						con.rollback();
				    }
				  }
				}
            else
            {
                con.rollback();
				if (msgEncounter.equals("Y"))
			    {
               	MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "ENC_ID_REACHED_MAX", "Common") ;
				String msg = ((String) mesg.get("message"));

			   if((sb != null) && (sb.length() > 0))
				  {
					sb.delete(0,sb.length());
				  }
			   sb.append(msg);
			   mesg.clear();
			   }else if (msgPR.equals("Y")) {
                       java.util.Hashtable message = MessageManager.getMessage(locale,
						  "OPEN_VISIT_STATUS_FOR_SERVICE", "OP");
				       sb.append((String) message.get("message"));
					 

			   }else{
					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "AE_VISIT_REG_INCOMPLETE", "AE") ;
					String msg = ((String) mesg.get("message"));
					sb.append(msg);
					sbMessage.append(msg);
 					mesg.clear();

			   }
            }
			ae_values_add_visit.clear();
			ae_values_arrival.clear();
			ae_values_related_contacts.clear();

        } // End of the try
        catch(Exception exception)
            {
			   sb.append("Catch :"+exception.getMessage()) ; result=false;
			    try{
				         con.rollback();
			       }catch(Exception e) {
						e.printStackTrace();
				}
			   sb.append(exception.toString());
               exception.printStackTrace();
        	}
        finally
        {
            try
            {
                if(con!=null) { ConnectionManager.returnConnection(con,p); }
            }
            catch(Exception e){result=false;e.printStackTrace();}
        } // End of the Finally
        results.put("status",new Boolean(result));
        results.put("error",sb.toString());
        results.put("ResultFromMessageManager", sbMessage.toString());
		results.put("Message",sb_Error_msg) ;
        results.put("status1",new Boolean(result_file) ) ;
        results.put("locn_code",sb_dflt_locncode.toString())  ;
		results.put("newFileNO",newFileNO);
    	results.put("encounter_id",encounter_id) ;
    	results.put("episode_id",episode_id) ;
    	results.put("episode_visit_no",episode_visit_no) ;

			//ML-04-START
		if ( billdoctype != null || billdoctype != "" )
		{

		results.put( "billdoctype", billdoctype ) ;
		results.put( "billdocnum", billdocnum ) ;
		results.put( "billgenlater", billgenlater ) ;
		results.put( "billtotalamt", billtotalamt ) ;

		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("bill_prt_format_vals", str_bill_prt_format_vals);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);

		}
		//ML-04-END
		if (strMessage == null)
		{
			strMessage ="0";
		}
        results.put( "bl_message",strMessage);
		return results;
   } // End of the method insertRegisterAttendance

   private String checkForNull(String inputString)
	{
		return ((inputString==null) || inputString.equals("null"))	?	""	:	inputString;
	}
	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}
} //End of the Class
