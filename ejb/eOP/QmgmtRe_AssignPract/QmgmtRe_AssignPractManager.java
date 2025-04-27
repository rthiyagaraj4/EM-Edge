/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.QmgmtRe_AssignPract;

import blopin.*;
import java.util.*;
import java.rmi.*;
import javax.ejb.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import webbeans.eCommon.*;
//import eOP.QMSInterface;

/**
*
* @ejb.bean
*	name="QmgmtRe_AssignPractManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="QmgmtRe_AssignPractManager"
*	local-jndi-name="QmgmtRe_AssignPractManager"
*	impl-class-name="eOP.QmgmtRe_AssignPract.QmgmtRe_AssignPractManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.QmgmtRe_AssignPract.QmgmtRe_AssignPractLocal"
*	remote-class="eOP.QmgmtRe_AssignPract.QmgmtRe_AssignPractRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.QmgmtRe_AssignPract.QmgmtRe_AssignPractLocalHome"
*	remote-class="eOP.QmgmtRe_AssignPract.QmgmtRe_AssignPractHome"
*	generate= "local,remote"
*
*
*/


public class QmgmtRe_AssignPractManager implements SessionBean {

	Connection con = null;

	PreparedStatement pstmt = null;

	PreparedStatement pstmt1 = null;

	CallableStatement cstmt = null;

	ResultSet res = null;

	String addedById = "";

	String addedDate = "";

	String modifiedById = "";

	String modifiedDate = "";

	String modifiedFacilityId = "";

	String modifiedAtWorkstation = "";

	java.sql.Date added_date;

	java.sql.Date modified_date;

	String locale = "";

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	SessionContext ctx;

	StringBuffer sbdebug = new StringBuffer("");

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	
	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap updatePrEncounter(java.util.Properties p,
			java.util.HashMap tabdata)

	{

		//System.out.println("In QmgmtRe_AssignPractManager -- 116 -- Start");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = true;
		String strBLMessage = "0";
	//	String ERROR_IN_UPDATING = "ERROR_IN_UPDATING";

		String ws_no = p.getProperty("client_ip_address");
		if (ws_no == null)
			ws_no = "";
		locale = p.getProperty("LOCALE");
		//String Local_assign_visit_type = "";
		String facilityId = (String) tabdata.get("facilityId");
		String patientid = (String) tabdata.get("patientid");
		String locntype = (String) tabdata.get("locntype");
		String locncode = (String) tabdata.get("locncode");
		String encounterid1 = (String) tabdata.get("encounterid");
		long encounterid = (Long.valueOf(encounterid1.trim())).longValue();
		String practid = (String) tabdata.get("practid");
		String pmode = (String) tabdata.get("pmode");
		String curlocncode = (String) tabdata.get("curlocncode");
		String curlocntype = (String) tabdata.get("curlocntype");
		String asslocncode = (String) tabdata.get("asslocncode");
		String asslocntype = (String) tabdata.get("asslocntype");
		String curpractid = (String) tabdata.get("curpractid");
		String curpracttype = (String) tabdata.get("curpracttype");
		String asspractid = (String) tabdata.get("asspractid");
		String curvisittypecode = (String) tabdata.get("curvisittypecode");
		String assvisittypecode = (String) tabdata.get("assvisittypecode");
		String visitcase = (String) tabdata.get("visitcase");
		String unlinkapptcaseyn = (String) tabdata.get("unlinkapptcaseyn");
		String p_queue_date = (String) tabdata.get("p_queue_date");
		String p_team_id = (String) tabdata.get("p_team_id");
		String room_num = (String) tabdata.get("room_num");
		

		String chg_flag = (String) tabdata.get("chg_flag");
		String service_code = (String) tabdata.get("service_code");
		String subservice_code = (String) tabdata.get("subservice_code");
		String addedAtWorkstation = (String) tabdata.get("client_ip_address");
		String addedFacilityId = (String) tabdata.get("facilityId");
		String strBLInstallYN = (String) tabdata.get("bl_install_yn");
		String apptid = (String) tabdata.get("appt_id");
		String identatcheckin = (String) tabdata.get("IDENT_AT_CHECKIN");
		String other_res_type = (String) tabdata.get("other_res_type");
		String other_res_code = (String) tabdata.get("other_res_code");
		String queue_num = (String) tabdata.get("queue_num");
		String appt_walk_ind = (String) tabdata.get("appt_walk_ind");
		String queue_id = (String) tabdata.get("queue_id");
		String episode_id = (String) tabdata.get("episode_id");
		String episode_visit_num = (String) tabdata.get("episode_visit_num");
		String Local_assign_visit_type = (String) tabdata.get("cur_vis_type_ind");
		String assign_q_num_by = (String) tabdata.get("assign_q_num_by");
		String qms_interfaced_yn = (String) tabdata.get("qms_interfaced_yn");
		String multi_speciality_yn = (String) tabdata.get("multi_speciality_yn")==null?"N":(String) tabdata.get("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF 0198
		String sec_res_lst = (String) tabdata.get("sec_res_lst");//Added for the CRF - Bru-HIMS-CRF 0198
		String billgenlater = "";
		String billtotalamt = "";
		
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
	    //String isPatientEncMovement=(String) tabdata.get("isPatientEncMovement"); //Commented for checkstyle
        String Sydate=(String) tabdata.get("Sydate");
		String queuestatus = (String) tabdata.get("queuestatus");
		//End Bru-HIMS-CRF-133

		String str_bill_prt_format_YN = "N";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";

		addedById = p.getProperty("login_user");
		addedDate = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		modifiedDate = addedDate;
		modifiedFacilityId = addedFacilityId;
		modifiedAtWorkstation = addedAtWorkstation;

		added_date = java.sql.Date.valueOf(addedDate);
		modified_date = java.sql.Date.valueOf(modifiedDate);
		StringBuffer sb = new StringBuffer("");
		try {
			String curpract = "";
			//String pr_srl_no = "";
			con = ConnectionManager.getConnection(p);
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();

			String L_practitioner_id = "";
			//int L_queuenum = 0;
			String L_queuenum = "0"; //Maheshwaran K changed Integer to String for ML-BRU-CRF-0628.11
			String queID = "";	
			//int q_num = 0;
			String q_num = "";//Maheshwaran K changed for ML-BRU-CRF-0628.11

			sql.setLength(0);
			
			if(result) {				

				if (identatcheckin.equals("P"))
					L_practitioner_id = asspractid;
				else {
					if (asspractid == null || asspractid.equals(""))
						L_practitioner_id = "*ALL";
					else
						L_practitioner_id = asspractid;
				}

				if (other_res_type.equals(""))
					other_res_type = "*";
				if (other_res_code.equals(""))
					other_res_code = "*ALL";

				
				if (!queue_num.equals(""))
					//q_num = Integer.parseInt(queue_num.trim());	
					q_num=queue_num.trim();//Maheshwaran K changed for ML-BRU-CRF-0628.11				

				if(assign_q_num_by.equals("M"))
				{
					L_queuenum = q_num;
					queID = queue_id;
				}
				else if(assign_q_num_by.equals("S"))
				{
					if (chg_flag.equals("Y") || q_num.equals("0")) {
						try {							

							//int quenum = 0;
							String quenum = "0";//Maheshwaran K changed for ML-BRU-CRF-0628.11		
							if(qms_interfaced_yn.equals("N")){
							cstmt = con
									.prepareCall("{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, p_queue_date);
							cstmt.setString(3, asslocntype);
							cstmt.setString(4, asslocncode);
							cstmt.setString(5, L_practitioner_id);
							cstmt.setString(6, room_num);
							cstmt.setString(7, other_res_type);
							cstmt.setString(8, other_res_code);
							cstmt.setString(9, appt_walk_ind);
							cstmt.setString(10, addedById);
							cstmt.setString(11, ws_no);
							//cstmt.setInt(12, q_num);
							cstmt.setString(12, q_num);//Maheshwaran K changed for ML-BRU-CRF-0628.11		
							cstmt.setString(13, queue_id);
							cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
							//cstmt.registerOutParameter(15, java.sql.Types.INTEGER);
							cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);//Maheshwaran K changed for ML-BRU-CRF-0628.11		
							cstmt.execute();
							queID = cstmt.getString(14);
						//	quenum = cstmt.getInt(15);
							quenum = cstmt.getString(15);//Maheshwaran K changed for ML-BRU-CRF-0628.11	

							if (queID == null || queID.equals("null"))
								queID = "";

							if (quenum.equals("0") || !quenum.equals("-1") || !quenum.equals("-2")) {
								result = true;
								L_queuenum = quenum;
							} else if (quenum.equals("-1")) {
								
								result = false;
								 java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_ID_NOT_ATTACHED", "OP");
								   sb.append((String) message.get("message"));
								   message.clear();
						
								
							} else if (quenum.equals("-2")) {
								
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_NUM_CTRL_NOT_DEFINED", "OP");
								   sb.append((String) message.get("message"));
								   message.clear();
								
							}

							if (cstmt != null)
								cstmt.close();
							}
						} catch (Exception e) {
							sb.append(e.getMessage());
							e.printStackTrace();
						}
					} else {
						result = true;
						queID = queue_id;
					}
				}
			}
			//Ends here 
			
			if(result) {

				sql.setLength(0);

				try	{			
					

					sql.append(" update PR_ENCOUNTER SET ");

					if (!curlocncode.equals(asslocncode)) {
						sql.append("  ASSIGN_CARE_LOCN_CODE = '" + asslocncode
										+ "' , ");
						sql.append("  ASSIGN_CARE_LOCN_TYPE = '" + asslocntype
										+ "' , ");
						sql.append("  PAT_CURR_LOCN_CODE = '" + asslocncode + "', ");
						sql.append("  PAT_CURR_LOCN_TYPE = '" + asslocntype + "', ");
					}
					if (curpractid == null || curpractid.equals(""))
						curpract = "";

					if (!curpract.equals(asspractid))
						sql.append(" attend_practitioner_id = '" + asspractid + "' , ");

					if (!curvisittypecode.equals(assvisittypecode)) {
						sql.append(" visit_adm_type = '" + assvisittypecode + "' , ");
						sql.append("VISIT_ADM_TYPE_IND='" + Local_assign_visit_type
								+ "',");
						sql.append(" patient_class = 'OP', ");
					}
					if (unlinkapptcaseyn.equals("Y"))
						sql.append(" Appt_id = null, appt_case_yn ='W',  ");
					sql.append(" team_id = '" + p_team_id + "' , ");
					sql.append("	assign_room_num = '" + room_num + "' , ");
					sql.append("   service_code= '" + service_code + "' , ");
					sql.append(" subservice_code='" + subservice_code + "' ");
					//sql.append(" modified_date=sysdate ");

					if (chg_flag.equals("Y") || q_num.equals("0")) {
						sql.append(", OTHER_RES_CLASS='"+other_res_type+"', OTHER_RESOURCE_ID='"+other_res_code+"' , QUEUE_ID = '"+queID+"'");
					}					
					
					//Commented by Ashwini on 09-Nov-2020 for ML-MMOH-SCF-1653
					//sql.append(" , modified_by_id =? , modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? where encounter_id = ? and facility_id = ? and patient_id='"+patientid+"'");

					sql.append(" , modified_by_id =? , modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? where facility_id = ? and encounter_id = ? ");
					
					//System.out.println("In QmgmtRe_AssignPractManager -- 338 -- Query executed to update pr_encounter -->"+sql.toString());
					pstmt = con.prepareStatement(sql.toString());

					pstmt.setString(1, modifiedById);					
					pstmt.setString(2, modifiedFacilityId);
					pstmt.setString(3, modifiedAtWorkstation);
					pstmt.setString(4, facilityId);
					pstmt.setLong(5, encounterid);
					
					int res1 = pstmt.executeUpdate();
					//System.out.println("In QmgmtRe_AssignPractManager -- 348 -- Updated pr_encounter-->"+res1);

					if(res1!=0)
						result=true;
					else 
						result=false;

					if (pstmt != null)
						pstmt.close();

				} catch (Exception e) {
					sb.append(e.getMessage());
					e.printStackTrace();
				}
			}

			if (result) {
				try {					

					String oplastservsql = "update op_last_visit_for_service set ASSIGN_CARE_LOCN_CODE=?,ATTEND_PRACTITIONER_ID=?,SUBSERVICE_CODE=? , modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? ,modified_by_id =? where OPERATING_FACILITY_ID=? and PATIENT_ID=? and SERVICE_CODE=?";
					//System.out.println("In QmgmtRe_AssignPractManager -- 368 -- Query to update op_last_visit_for_service-->"+oplastservsql);
					pstmt = con.prepareStatement(oplastservsql);

					if (!curlocncode.equals(asslocncode))
						pstmt.setString(1, asslocncode);
					else
						pstmt.setString(1, curlocncode);
					if (!curpractid.equals(asspractid))
						pstmt.setString(2, asspractid);
					else
						pstmt.setString(2, curpractid);
					pstmt.setString(3, subservice_code);
					pstmt.setString(4, modifiedFacilityId);
					pstmt.setString(5, modifiedAtWorkstation);
					pstmt.setString(6, modifiedById);
					pstmt.setString(7, facilityId);
					pstmt.setString(8, patientid);
					pstmt.setString(9, service_code);

					int servres = pstmt.executeUpdate();
					//System.out.println("Op_last_visit_for_service updated-->"+servres);
					if (servres != 0)
						result = true;
					else
						result = false;

					if (pstmt != null)
						pstmt.close();

				} catch (Exception e) {
					sb.append(e.getMessage());
					e.printStackTrace();
				}
			}

			if(result) {

				try	{
					
					int res4 = 1;
					sql2.setLength(0);					
					sql2.append(" Update  op_patient_queue set ");
					if (chg_flag.equals("Y") || q_num.equals("0")) {
						sql2.append("   queue_num ='" + L_queuenum + "', ");
					}
					sql2.append(" locn_type = ? ,");
					sql2.append(" locn_code = ? ,");
					sql2.append(" practitioner_id = ? ,");
					sql2.append(" room_num=? ,");
					sql2.append(" OTHER_RES_CLASS=?, ");
					sql2.append(" OTHER_RESOURCE_ID=?, ");
					sql2.append(" QUEUE_ID	= ?	,");
					sql2.append(" VISIT_TYPE_IND =? ,");
					sql2.append(" VISIT_TYPE_CODE =? ,");
					sql2.append(" SERVICE_CODE =? ,");
					sql2.append(" SUBSERVICE_CODE =? ,");
					sql2.append(" PAT_CURR_LOCN_CODE =? ,");
					sql2.append(" PAT_CURR_LOCN_TYPE =? ,");
					sql2.append(" modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? ,modified_by_id =? ");
					sql2.append(" where  facility_id = ? ");			
					sql2.append(" and encounter_id = ? ");			

					//System.out.println("In QmgmtRe_AssignPractManager -- 430 -- Query to update op_patient_queue -->"+sql2.toString());
					pstmt = con.prepareStatement(sql2.toString());

					if (room_num == null || room_num.equals(""))
						room_num = "*ALL";

					pstmt.setString(1, asslocntype);
					pstmt.setString(2, asslocncode);
					pstmt.setString(3, L_practitioner_id);
					pstmt.setString(4, room_num);
					pstmt.setString(5, other_res_type);
					pstmt.setString(6, other_res_code);
					pstmt.setString(7, queID);

					if (curvisittypecode != assvisittypecode) {
						pstmt.setString(8, Local_assign_visit_type);
						pstmt.setString(9, assvisittypecode);

					} else {
						pstmt.setString(8, Local_assign_visit_type);
						pstmt.setString(9, curvisittypecode);
					}

					pstmt.setString(10, service_code);
					pstmt.setString(11, subservice_code);

					if (!curlocncode.equals(asslocncode)) {
						pstmt.setString(12, asslocncode);
						pstmt.setString(13, asslocntype);
					} else {
						pstmt.setString(12, curlocncode);
						pstmt.setString(13, curlocntype);
					}

					pstmt.setString(14, modifiedFacilityId); 
					pstmt.setString(15, modifiedAtWorkstation);
					pstmt.setString(16, modifiedById);
					pstmt.setString(17, facilityId);
					pstmt.setLong(18, encounterid);					

					res4 = pstmt.executeUpdate();

					//System.out.println("In QmgmtRe_AssignPractManager -- 472 -- op_patient_queue updated-->"+res4);
				 /*Below line added for this CRF Bru-HIMS-CRF-133*/		
				    if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT") && p_queue_date.equals(Sydate)){	
					
					 
						cstmt = con.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
						cstmt.setString(1, facilityId);
						cstmt.setString(2, patientid);
						cstmt.setString(3, encounterid1);
						cstmt.setString(4, queuestatus);
						cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
						//System.err.println("Before execute line no377 QmgmtRe_AssignPractManager.java===>");
						cstmt.execute();								
						//System.err.println("After execute line no377 QmgmtRe_AssignPractManager.java===>");
						String err_pr_enc_mvmnt= cstmt.getString(5);
						//System.err.println("err_pr_enc_mvmnt QmgmtRe_AssignPractManager.java===>"+err_pr_enc_mvmnt);						
						if (cstmt != null){
							cstmt.close();
						}							 
				    }
			 //End Bru-HIMS-CRF-133

					if(res4 != 0)
						result=true;
					else 
						result=false;

					if (pstmt != null)
						pstmt.close();

				} catch (Exception e) {
					sb.append(e.getMessage());
					e.printStackTrace();
				}
			}	

			if(result) {	
				
				sql2.setLength(0);
					//System.out.println("In QmgmtRe_AssignPractManager -- 491 -- pmode -->"+pmode);
					//System.out.println("In QmgmtRe_AssignPractManager -- 492 -- unlinkapptcaseyn-->"+unlinkapptcaseyn);
				if (pmode.equals("R") && unlinkapptcaseyn.equals("Y")) {

					try
					{	
						
						sql2.append("update oa_appt set encounter_id = null, appt_status ='1', modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? ,modified_by_id =? where facility_id =? and Appt_ref_no =? ");

						pstmt = con.prepareStatement(sql2.toString());
						pstmt.setString(1, modifiedFacilityId);
						pstmt.setString(2, modifiedAtWorkstation);
						pstmt.setString(3, modifiedById);
						pstmt.setString(4, facilityId);
						pstmt.setString(5, apptid);

					//System.out.println("In QmgmtRe_AssignPractManager -- 507 -- query to update oa_appt -->"+sql2.toString());

						int res_oa = pstmt.executeUpdate();
						//System.out.println("In QmgmtRe_AssignPractManager -- 510 -- oa_appt updated-->"+res_oa);

						if(res_oa!=0)
							result=true;
						else
							result=false;		

					} catch (Exception e) {
						sb.append(e.getMessage());
						e.printStackTrace();
					} finally {
						if (pstmt != null)
							pstmt.close();
					}
				}

			}

			if(result) {				
				//System.out.println("In QmgmtRe_AssignPractManager -- 529 -- curlocncode-->"+curlocncode);

				if (!curlocncode.equals(asslocncode)) {

					try {						

						sql.setLength(0);

						sql.append("update pr_patient_movement set ");
						sql.append(" TO_LOCN_CODE ='" + asslocncode + "' ,");
						sql.append(" TO_LOCN_TYPE ='" + asslocntype + "' ");
						sql.append(" , modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? ,modified_by_id =? where facility_id=? and encounter_id=? and patient_id=? and srl_no =(select max(to_number(srl_no)) from pr_patient_movement where facility_id = ? and encounter_id =? and patient_id = ?)");

					//System.out.println("In QmgmtRe_AssignPractManager -- 542 -- query to update pr_patient_movement-->"+sql.toString());
						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString(1, modifiedFacilityId);
						pstmt.setString(2, modifiedAtWorkstation);
						pstmt.setString(3, modifiedById);
						pstmt.setString(4, facilityId);
						pstmt.setLong(5, encounterid);
						pstmt.setString(6, patientid);
						pstmt.setString(7, facilityId);
						pstmt.setLong(8, encounterid);
						pstmt.setString(9, patientid);
						

						int res_pr = pstmt.executeUpdate();
					//System.out.println("In QmgmtRe_AssignPractManager -- 556 -- pr_patient_movement updated-->"+res_pr);
						if(res_pr!=0)
							result=true;
						else 
							result=false;				

						sql.setLength(0);

					} catch (Exception e) {
						sb.append(e.getMessage());
						e.printStackTrace();
					} finally {
						if (pstmt != null)
							pstmt.close();
					}

				}
			}
				
			if(result) {				
					//System.out.println("In QmgmtRe_AssignPractManager -- 576 -- calling insertEncoutnerRecord");
				HashMap ret = insertEncounterRecord(facilityId, encounterid,
						pmode, curpractid, asspractid, curpracttype,
						addedAtWorkstation, addedFacilityId);
				boolean retval = ((Boolean) ret.get("status")).booleanValue();
				result = retval;
					//System.out.println("In QmgmtRe_AssignPractManager --582 insertEncoutnerRecord returned -->"+result);
				ret.clear();
			}				
			if(result && multi_speciality_yn.equals("Y")){
				String errmsg=updateJointConsult(facilityId,sec_res_lst,modifiedAtWorkstation,modifiedById, modifiedFacilityId,encounterid);
				if(errmsg!=null && !errmsg.equals("")){
					result=false;
					sb.append(errmsg);					
				}
			}
			if (result) {
				try {
					//System.out.println("In QmgmtRe_AssignPractManager -- 588 -- BillingInstalled-->"+strBLInstallYN);
					if (strBLInstallYN.equalsIgnoreCase("Y")) {
						Hashtable hashtableBL = new Hashtable();
						hashtableBL.put("patient_id", patientid);
						hashtableBL.put("facilityId", facilityId);
						hashtableBL.put("episode_id", episode_id.trim());
						hashtableBL.put("visit_id", episode_visit_num.trim());
						hashtableBL.put("clinic_code", (asslocncode));
						hashtableBL.put("episode_type", "O");
						hashtableBL.put("module_id", "OP");
						hashtableBL.put("clinic_type", asslocntype);
						hashtableBL
								.put("asn_visit_type_code", assvisittypecode);
						hashtableBL
								.put("cur_visit_type_code", curvisittypecode);
						hashtableBL.put("asn_pract_id", asspractid);
						hashtableBL.put("locntype", locntype);
						hashtableBL.put("locncode", locncode);
						hashtableBL.put("encounterid", (encounterid + ""));
						hashtableBL.put("practid", practid);
						hashtableBL.put("curlocncode", curlocncode);
						hashtableBL.put("curlocntype", curlocntype);
						hashtableBL.put("asslocncode", asslocncode);
						hashtableBL.put("asslocntype", asslocntype);
						hashtableBL.put("curpractid", curpractid);
						hashtableBL.put("curpracttype", curpracttype);
						hashtableBL.put("curvisittypecode", curvisittypecode);
						hashtableBL.put("assvisittypecode", assvisittypecode);
						hashtableBL.put("visitcase", visitcase);
						hashtableBL.put("addedAtWorkstation",
								addedAtWorkstation);
						hashtableBL.put("addedFacilityId", addedFacilityId);
						hashtableBL.put("addedById", addedById);
						hashtableBL.put("locale", locale);
						hashtableBL.put("function_id", "ASSIGN_PRACTITIONER");
						

						hashtableBL.put("fin_dtls", tabdata.get("fin_dtls")); 
					//System.out.println("In QmgmtRe_AssignPractManager -- 626 -- Billing values passed -->"+hashtableBL.toString());

						BLOPReviseVisit blRevise = new BLOPReviseVisit();
						Hashtable resultsBL = blRevise.billPatientService(p,
								con, hashtableBL);
						//System.err.println("QmgmtRe_assignpractmanager -- 631 -- returned from BLOPReviseVisit - resultsBL -->"+resultsBL.toString());
						boolean boolBLStatus = ((Boolean) (resultsBL
								.get("status"))).booleanValue();
						result = boolBLStatus;

						billgenlater = (String) (resultsBL.get("billgenlater"));						
						billtotalamt = (String) (resultsBL.get("billtotalamt"));	

						str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
						pgm_id = (String)(resultsBL.get("pgm_id"));
						session_id = (String)(resultsBL.get("session_id"));
						pgm_date = (String)(resultsBL.get("pgm_date"));
						mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));

						strBLMessage = (String) resultsBL.get("message");
						if (boolBLStatus == false) {
							sb.append((String) resultsBL.get("error"));

						}

						if (boolBLStatus == true) {
							if (strBLMessage != null) {
								if ((strBLMessage.trim().equals(""))) {
									strBLMessage = " ";
								}

							} else {
								strBLMessage = "0";
							}
						}

						resultsBL.clear();
						hashtableBL.clear();
					}
				} catch (Exception exceptionBL) {
					sb.append(" Error in BL " + exceptionBL);
					//System.out.println("In QmgmtRe_AssignPractManager -- 667 -- Exception in BL-->"+exceptionBL.toString());
					exceptionBL.printStackTrace();
				}
			}
			if (result) {				
				con.commit();
					//System.out.println("In QmgmtRe_AssignPractManager -- 673 -- RECORD_MODIFED");
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();

			} else {
				if(multi_speciality_yn.equals("N")){	
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"ERROR_IN_UPDATING", "SM");
				sb.append((String) message.get("message"));
				message.clear();
				}
				//qms related code
				/*if(qms_interfaced_yn.equals("Y")){
					System.out.println("QmgmtRe_AssignPract rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),patientid,String.valueOf(encounterid),con);
				}*/
				con.rollback();
				
			}
			tabdata.clear();
		} catch (Exception e) {
			try {
				/*if(qms_interfaced_yn.equals("Y")){
					System.out.println("QmgmtRe_AssignPract rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),patientid,String.valueOf(encounterid),con);
				}*/
				con.rollback();
			} catch (Exception e1) {
			}
			sb.append(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		results.put("billgenlater", billgenlater);
		results.put("billtotalamt", billtotalamt);

		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);


		if ((strBLMessage == null) || (strBLMessage.equals(""))) {
			strBLMessage = "0";
		}
		results.put("bl_message", strBLMessage);
		//System.out.println("In QmgmtRe_AssignPractManager -- 733 -- results-->"+results.toString());

		return results;
	}

	
	
	public java.util.HashMap insertEncounterRecord(

	String facilityId, long encounterid, String pmode, String curpractid,
			String asspractid, String curpracttype,

			String addedAtWorkstation, String addedFacilityId)

	{

		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		StringBuffer sb = new StringBuffer("");
		StringBuffer sql = new StringBuffer();

		try {
			int r = 1;
			if (pmode.equals("R")
					&& (curpracttype.equals("MD") || curpracttype.equals("SG")
							|| curpracttype.equals("PS") || curpracttype
							.equals("DN"))) {
				sql.append(" delete from pr_encounter_pract  ");
				sql.append(" where operating_facility_id = ? ");
				sql.append(" and encounter_id = ? ");
				sql.append(" and Practitioner_id = ? ");
				sql.append(" and practitioner_role ='1' ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, facilityId);
				pstmt.setLong(2, encounterid);
				pstmt.setString(3, curpractid);
				r = pstmt.executeUpdate();
				

				if (pstmt != null)
					pstmt.close();
				sql.setLength(0);
			}

			if (curpracttype.equals("MD") || curpracttype.equals("SG")
					|| curpracttype.equals("PS") || curpracttype.equals("DN")) {				

				sql.append(" INSERT INTO PR_ENCOUNTER_PRACT ");
				sql
						.append("  (OPERATING_FACILITY_ID , ENCOUNTER_ID, PRACTITIONER_ID, ");
				sql.append(" PRACTITIONER_ROLE ,SPECIALTY_CODE,REMARKS, ");
				sql.append("    added_by_id , added_date,  ");
				sql.append("    added_facility_id  ,  added_at_ws_no , ");
				sql.append("    modified_by_id  ,modified_date , ");
				sql.append("    modified_facility_id, modified_at_ws_no )   ");
				sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, facilityId);
				pstmt.setLong(2, encounterid);
				pstmt.setString(3, asspractid);
				pstmt.setString(4, "1");
				pstmt.setString(5, null);
				pstmt.setString(6, null);
				pstmt.setString(7, addedById);
				pstmt.setDate(8, added_date);
				pstmt.setString(9, addedFacilityId);
				pstmt.setString(10, addedAtWorkstation);
				pstmt.setString(11, modifiedById);
				pstmt.setDate(12, modified_date);
				pstmt.setString(13, modifiedFacilityId);
				pstmt.setString(14, modifiedAtWorkstation);

				r = pstmt.executeUpdate();
				
			}
			if (r != 0) {
				result = true;

			}

			sql.setLength(0);

			if (pstmt != null)
				pstmt.close();
		} catch (Exception eee) {
			sb.append(eee.getMessage());
			eee.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception eeee) {
				eeee.printStackTrace();
			}
		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}//end insertEncounterRecord
	
	public String updateJointConsult(String facilityId,String sec_res_lst,String modifiedAtWorkstation,String modifiedById,String modifiedFacilityId,long encounterid){
		String msgVal = "";
		try{
			int r = 1;
			ResultSet rs=null;
			StringBuffer sql=new StringBuffer();
			//Incoming secondary resource list will be in the format - A$B.  This will be modified like this - 'A','B' - to be used in the update query.
			String secreslst=sec_res_lst.replace("$", "','");
				secreslst=secreslst.substring(0,secreslst.length()-2);
				//Added Audit column
				sql.append(" update  PR_ENCOUNTER_JOINT_CONSULT set linked_yn='N' ,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ? ");
				sql.append(" where facility_id = ? ");
				sql.append(" and encounter_id = ? and practitioner_id not in ('"+secreslst+")");				
                //System.err.println("893 sql.toString()===>"+sql.toString());
				pstmt = con.prepareStatement(sql.toString());
				//Added Audit column
				pstmt.setString(1, modifiedById);
				pstmt.setString(2, modifiedAtWorkstation);
				pstmt.setString(3, modifiedFacilityId);
				pstmt.setString(4, facilityId);
				pstmt.setLong(5, encounterid);				
				r = pstmt.executeUpdate();
				

				if (pstmt != null)
					pstmt.close();
				if(rs!=null) rs.close();
				sql.setLength(0);
			    //Added Audit column
				sql.append(" update  PR_ENCOUNTER_JOINT_CONSULT set linked_yn='Y' ,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ? ");
				sql.append(" where facility_id = ? ");
				sql.append(" and encounter_id = ? and practitioner_id in ('"+secreslst+")");				
				
				pstmt = con.prepareStatement(sql.toString());
				//Added Audit column
				pstmt.setString(1, modifiedById);
				pstmt.setString(2, modifiedAtWorkstation);
				pstmt.setString(3, modifiedFacilityId);
				pstmt.setString(4, facilityId);
				pstmt.setLong(5, encounterid);				
				r = pstmt.executeUpdate();
				

				if (pstmt != null)
					pstmt.close();
				if(rs!=null) rs.close();
				sql.setLength(0);
								
			StringTokenizer secResPracts=new StringTokenizer(sec_res_lst,"$");
			while(secResPracts.hasMoreTokens()) {	
				String practId=secResPracts.nextToken();
				sql.append(" SELECT (select LINKED_YN from  PR_ENCOUNTER_JOINT_CONSULT where facility_id = ? and encounter_id = ? and practitioner_id ='"+practId+"') linked_yn,(SELECT PRIMARY_SPECIALITY_CODE FROM am_practitioner WHERE PRACTITIONER_ID='"+practId+"' ) spec_code from dual ");	

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, facilityId);
				pstmt.setLong(2, encounterid);				
				rs = pstmt.executeQuery();
				if(pstmt != null) //CheckStyle issue 19-05-2023
				pstmt.close();
				sql.setLength(0);
				while(rs.next()){
					String linked_yn=rs.getString("linked_yn")==null?"":rs.getString("linked_yn");
					String spec_code=rs.getString("spec_code")==null?"":rs.getString("spec_code");
					if(linked_yn.equals("")){
					sql.append("insert into PR_ENCOUNTER_JOINT_CONSULT (FACILITY_ID,ENCOUNTER_ID,PRACTITIONER_ID,LINKED_YN,STATUS,SPECIALTY_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ");
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, facilityId);
					pstmt.setLong(2, encounterid);
					pstmt.setString(3, practId);
					pstmt.setString(4, "Y");
					pstmt.setString(5, "O");
					pstmt.setString(6, spec_code);				
					pstmt.setString(7, modifiedById);				
					pstmt.setString(8, modifiedAtWorkstation);
					pstmt.setString(9, modifiedFacilityId);
					pstmt.setString(10, modifiedById);			
					pstmt.setString(11, modifiedAtWorkstation);
					pstmt.setString(12, modifiedFacilityId);

					r = pstmt.executeUpdate();
					if(pstmt != null) //CheckStyle issue 19-05-2023
					pstmt.close();
					sql.setLength(0);
					}
				}
	
				if(rs != null) //CheckStyle issue 19-05-2023
				rs.close();
			}
			

			sql.setLength(0);

			if(pstmt != null)
				pstmt.close();
			if(rs!=null) 
				rs.close();
		}catch(SQLException e){	
			if(e.getErrorCode()==20101){
				String sqlerrm=e.getMessage();
				int index=sqlerrm.lastIndexOf("PR_JOINT_CONSULT_TRG_ERR");
				if(index!=-1){
					msgVal=sqlerrm.substring(index+25,sqlerrm.indexOf("\n"));
				}else{
					msgVal="SQLException while inserting into PR_ENCOUNTER_JOINT_CONSULT";
				}
			}								
			e.printStackTrace();
		}catch(Exception e){
			msgVal = "Exception While inserting into PR_ENCOUNTER_JOINT_CONSULT";
			e.printStackTrace();
		}

		return  msgVal;
	}
	
}
