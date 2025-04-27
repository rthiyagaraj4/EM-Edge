/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.StartCons;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="StartCons"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="StartCons"
*	local-jndi-name="StartCons"
*	impl-class-name="eOP.StartCons.StartConsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.StartCons.StartConsLocal"
*	remote-class="eOP.StartCons.StartConsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.StartCons.StartConsLocalHome"
*	remote-class="eOP.StartCons.StartConsHome"
*	generate= "local,remote"
*
*
*/

public class StartConsManager implements SessionBean {
	Connection con;

	PreparedStatement pstmt;

	ResultSet rs = null;
	
	CallableStatement cstmt = null; //this line added for this CRF -Bru-HIMS-CRF-133

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	boolean result = false;

	boolean updateable = true;

	StringBuffer sb = new StringBuffer("");

	java.util.HashMap results = new java.util.HashMap();

	//StringBuffer upsql1 = new StringBuffer();

	//StringBuffer upsql5 = new StringBuffer();	

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	SessionContext ctx;

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


	public java.util.HashMap updateRecordStartCons(java.util.Properties p,
			java.util.HashMap tabdata

	) {

		results.put("status", new Boolean(true));
		results.put("error", "no error");

		sb.setLength(0);

		String facilityid = (String) tabdata.get("facilityId");
		String locale = p.getProperty("LOCALE");
		String encounterid = (String) tabdata.get("encounterid");		
		String addedFacilityId = (String) tabdata.get("facilityId");
		String addedAtWorkstation = (String) tabdata.get("client_ip_address");
		String addedById = p.getProperty("login_user");
		String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;

		Date modified_date = Date.valueOf(modifiedDate);

		/*Below line added for this CRF Bru-HIMS-CRF-133  [IN:034536]*/
		String patientid = (String) tabdata.get("patientid");		
		String queue_date = (String) tabdata.get("p_queue_date");		
		String isPatientEncMovement = (String) tabdata.get("isPatientEncMovement");
		String Sydate = (String) tabdata.get("Sydate");
		//End this CRF Bru-HIMS-CRF-133 
		/*Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623 Start*/
		String moduleId				= checkForNull((String) tabdata.get("moduleId"));
		String insertBackDatedConsY	= checkForNull((String) tabdata.get("insertBackDatedConsY"));
		String allowBackdateConsYn	= checkForNull((String) tabdata.get("allowBackdateConsYn"));
		String startConsDateTime	= checkForNull((String) tabdata.get("start_cons_date_time"));
		/*End*/
		updateable = true;//Added by Thamizh selvi on 5th Dec 2017
		try {

			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);				

			if (updateable) {
				updateable = updatePrencounter(facilityid, encounterid,
						addedById, modifiedById, modified_date,
						modifiedFacilityId, modifiedAtWorkstation);


			}	
			
			if (updateable) {			
				//updateable = updatePatientQueue(facilityid, encounterid,modifiedById, modified_date, modifiedFacilityId,modifiedAtWorkstation);
			 /*Above line commented and below line added for this CRF Bru-HIMS-CRF-133*/	
			//updateable = updatePatientQueue(facilityid, encounterid,modifiedById, modified_date, modifiedFacilityId,modifiedAtWorkstation,queue_date,patientid,isPatientEncMovement,Sydate);	
			 
			/*Above line commented and 3 additional parameters added for ML-MMOH-CRF-0623 by Thamizh selvi on 16th Oct 2017*/
			 updateable = updatePatientQueue(facilityid, encounterid,modifiedById, modified_date, modifiedFacilityId,modifiedAtWorkstation,queue_date,patientid,isPatientEncMovement,Sydate, moduleId, allowBackdateConsYn, startConsDateTime, insertBackDatedConsY);	
			}

			
			if (updateable) {
				result = true;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				results.put("error", sb.toString());
				message.clear();

			} else {
				result = false;
				con.rollback();
				results.put("status", new Boolean(result));
				results.put("error", sb.toString());
			}

			tabdata.clear();
		} catch (Exception e) {
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ee) {
				ee.printStackTrace();
			}

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ce) {
				ce.printStackTrace();
			}
			if (con != null)
				ConnectionManager.returnConnection(con, p);

		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}

	private boolean updatePatientQueue(String facilityid, String encounterid,
			String modifiedById, Date modified_date, String modifiedFacilityId,
			String modifiedAtWorkstation,String queue_date,String patientid,String isPatientEncMovement,String Sydate,String moduleId,String allowBackdateConsYn,String startConsDateTime, String insertBackDatedConsY) {

		try {			

			String selectSql="select MULTI_SPECIALITY_YN from op_clinic a, op_patient_queue b where b.encounter_id="+encounterid+" and b.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.CLINIC_CODE=b.LOCN_CODE ";
			pstmt = con.prepareStatement(selectSql);
			//pstmt.setString(1, facilityid);
		//	pstmt.setString(2, encounterid);
			String multi_speciality_yn="N";
			
			ResultSet rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){
				multi_speciality_yn=rs.getString("MULTI_SPECIALITY_YN")==null?"N":rs.getString("MULTI_SPECIALITY_YN");
			}
			
			if(pstmt!=null) pstmt.close();
			if(rs !=null) rs.close();
			
			/*Below line added for this CRF Bru-HIMS-CRF-133*/							
				if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT") && isPatientEncMovement.equals("true") && queue_date.equals(Sydate)){
						
						cstmt = con.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
						cstmt.setString(1, facilityid);
						cstmt.setString(2, patientid);
						cstmt.setString(3, encounterid);
						cstmt.setString(4, "04");
						cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);						
						cstmt.execute();				
						String err_pr_enc_mvmnt= cstmt.getString(5);
						
						if (cstmt != null){
							cstmt.close();
						}							 
				}
			 //End Bru-HIMS-CRF-133
			
			/*String upsql = " Update op_patient_queue set queue_status ='04' , cons_srvc_start_date_time = sysdate , modified_by_id = ?, modified_date = ?, modified_facility_id=?, modified_at_ws_no=? where  facility_id = ? and encounter_id = ? ";*/
			
			//Above upsql string commented and query stored in updPatQueue string buffer for ML-MMOH-CRF-0623 on 23rd Oct 2017
			StringBuffer updPatQueue = new StringBuffer("");
			updPatQueue.append(" Update op_patient_queue set queue_status ='04' ");
			if(("AE").equals(moduleId) && allowBackdateConsYn.equals("Y"))
				updPatQueue.append(" , cons_srvc_start_date_time = TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			else
				updPatQueue.append(" , cons_srvc_start_date_time = sysdate ");

			if(insertBackDatedConsY.equals("Y"))
				updPatQueue.append(" , backdated_cons_em_yn = 'Y' ");

			updPatQueue.append(" , modified_by_id = ?, modified_date = sysdate, modified_facility_id=?, modified_at_ws_no=? where  facility_id = ? and encounter_id = ?");
		

			if(multi_speciality_yn.equals("Y")){
				updPatQueue.append(" and cons_srvc_start_date_time is null ");
				//upsql=upsql+" and cons_srvc_start_date_time is null";
			}
			
			pstmt = con.prepareStatement(updPatQueue.toString());
			int i = 1;
			if(("AE").equals(moduleId) && allowBackdateConsYn.equals("Y")){//Added by Thamizh selvi on 16th Oct 2017 for ML-MMOH-CRF-0623
				pstmt.setString(i++, startConsDateTime);
			}
			pstmt.setString(i++, modifiedById);
			//pstmt.setDate(i++, modified_date); //commented since time is not stored in modified_date column
			pstmt.setString(i++, modifiedFacilityId);
			pstmt.setString(i++, modifiedAtWorkstation);
			pstmt.setString(i++, facilityid);
			pstmt.setString(i++, encounterid);

			int res1 = pstmt.executeUpdate();

			if (res1 != 0 || multi_speciality_yn.equals("Y"))
				updateable = true;
			else
				updateable = false;

			if (pstmt != null)
				pstmt.close();

			//upsql1.setLength(0);

		} catch (Exception e) {
			/*Added by Thamizh selvi on 5th Dec 2017 Start*/
			System.err.println("Exception catched in updatePatientQueue"+e.getMessage());
			sb.append(e.getMessage());/*End*/
			updateable = false;
			e.printStackTrace();
		}

		return updateable;
	}

	private boolean updatePrencounter(String facilityid, String encounterid,
			String addedById, String modifiedById, Date modified_date,
			String modifiedFacilityId, String modifiedAtWorkstation) {
		try {
			
			//upsql1.setLength(0);
			
			String sql1 = " Update pr_encounter Set visit_status='04' , visit_status_set_on_date = sysdate, visit_status_set_by_user = ? , modified_by_id = ?, modified_date = sysdate, modified_facility_id=?, modified_at_ws_no=? where encounter_id = ? and facility_id = ? ";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, addedById);
			pstmt.setString(2, modifiedById);
			// Code Commented for IN022870 by Suresh M on 28-July-2010
		//	pstmt.setDate(3, modified_date);
			pstmt.setString(3, modifiedFacilityId);
			pstmt.setString(4, modifiedAtWorkstation);
			pstmt.setString(5, encounterid);
			pstmt.setString(6, facilityid);

			int res2 = pstmt.executeUpdate();

			if (res2 != 0)
				updateable = true;
			else
				updateable = false;

			if (pstmt != null)
				pstmt.close();

			//upsql1.setLength(0);

		} catch (Exception e) {
			/*Added by Thamizh selvi on 5th Dec 2017 Start*/
			System.err.println("Exception catched in updatePrencounter"+e.getMessage());
			sb.append(e.getMessage());/*End*/
			updateable = false;
			e.printStackTrace();
		}
		return updateable;
	}
	
	private String checkForNull(String inputString)
	{
		return ((inputString==null) || inputString.equals("null"))	?	""	:	inputString;
	}

}


