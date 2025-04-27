/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE.AEManagePatient;

import blopin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="AEManagePatient"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AEManagePatient"
*	local-jndi-name="AEManagePatient"
*	impl-class-name="eAE.AEManagePatient.AEManagePatientManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eAE.AEManagePatient.AEManagePatientLocal"
*	remote-class="eAE.AEManagePatient.AEManagePatientRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAE.AEManagePatient.AEManagePatientLocalHome"
*	remote-class="eAE.AEManagePatient.AEManagePatientHome"
*	generate= "local,remote"
*
*
*/

public class AEManagePatientManager implements SessionBean  {

	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	Connection con = null;
	String locale  = "";

	public void setSessionContext(SessionContext sessionContext)  {
		this.ctx = sessionContext;
	}
	/**
	 *Method to  Assign Treatment Area
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap assignTreatmentArea ( Properties	jdbc_props, java.util.HashMap	 htAEManagePatient ) {
		locale         				=	(String) htAEManagePatient.get ( "locale"	);
		PreparedStatement	pstmt	=	null;
		PreparedStatement	pstmt2	=	null;
		PreparedStatement pstmtDate =    null;
		CallableStatement	cstmt	=	null;
		java.util.HashMap results		=	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;
		String  strBLMessage        =  "0";
		String billgenlater = "";
		String billtotalamt = "";
		String str_bill_prt_format_YN = "N";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";
		String  facility_id			=  "",	login_user_id			=	"";
		String  login_at_ws_no		=  "",	encounter_id			=	"";
		String  locn_code			=  "",	locn_type				=	"";
		String  queue_date			=  "",	queue_status			=	"";
		String  practitioner_id		=  "",	treatment_area_code	=	"";
		String  assign_tmt_area_time	=  "",	error_msg			=	"";
		String  patient_id		    =	"";
		String  priority_value		=  "",	bed_bay_no			=	"";
		String  previous_status		=  "", 	prev_tmt_area_code	=	"";
		String  bl_install_yn       =  "";
		String  visit_type_code     =  "",  pract_type          =  "";
		String  priority_code		=  "";//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
		boolean result				=  false;
		int     priority_num			=  0,	 update_result		=  0, colIndex			=  0;
		StringBuffer	statusUpd	=  null;
		StringBuffer	AEPatQ		=  null;
		StringBuffer	OPLast1		=  null;
		StringBuffer	OPLast2		=  null;
		StringBuffer	UpdPat		=  null;
		StringBuffer	AEPro		=  null;
		StringBuffer	PatQUp		=  null;
		ResultSet rsetDate			= null;
		String sys_date			= "";
		String episode_id="";
		String episode_visit_num="";
		MessageManager mmm = new MessageManager();
		final java.util.Hashtable mesaag = mmm.getMessage(locale, "FAILED_TRANSACTION", "SM") ;
		String recordmsg  = ((String) mesaag.get("message"));
		String isStartConsultationAppl = "";//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623
		String isEnableDateTimeAppl = "";//Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133


		try {
			con					=	ConnectionManager.getConnection(jdbc_props);
			try{
			pstmtDate =con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys_date from dual");
		rsetDate = pstmtDate.executeQuery();
		if(rsetDate!=null && rsetDate.next())
			sys_date = rsetDate.getString("sys_date");
		if(rsetDate!=null) rsetDate.close();
		if(pstmtDate!=null) pstmtDate.close();
			}catch(Exception e){e.printStackTrace();}
			facility_id				=	(String) htAEManagePatient.get ( "facility_id"	);
			bl_install_yn           =	(String) htAEManagePatient.get ("bl_install_yn"	);
			login_user_id			=	(String) htAEManagePatient.get ( "login_user_id");
			login_at_ws_no			=	(String) htAEManagePatient.get ( "login_at_ws_no");
			encounter_id			=	(String) htAEManagePatient.get ( "encounter_id");
			locn_code				=	(String) htAEManagePatient.get ( "locn_code");
			locn_type				=	(String) htAEManagePatient.get ( "locn_type"	);
			queue_date				=	(String) htAEManagePatient.get ( "queue_date");
			queue_status			=	(String) htAEManagePatient.get ( "queue_status");
			practitioner_id			=	(String) htAEManagePatient.get ( "practitioner_id");
			//practitioner_id2		=	(String) htAEManagePatient.get ( "practitioner_id");
			treatment_area_code		=	(String) htAEManagePatient.get ( "treatment_area_code");
			assign_tmt_area_time	=	(String) htAEManagePatient.get ( "assign_tmt_area_time");
			previous_status			=	(String) htAEManagePatient.get ( "previous_status");
			prev_tmt_area_code		=	(String) htAEManagePatient.get ( "prev_tmt_area_code");
			patient_id				=	(String) htAEManagePatient.get ( "patient_id");
			visit_type_code			=	(String) htAEManagePatient.get ( "visit_type_code");
			pract_type			    =	(String) htAEManagePatient.get ( "pract_type");
			priority_value			=	(String) htAEManagePatient.get ( "priority_value");
			priority_code			=	(String) htAEManagePatient.get ( "priority_code");//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
			
			bed_bay_no				=	(String) htAEManagePatient.get ( "bed_bay_no");
			isStartConsultationAppl	=	(String) htAEManagePatient.get ( "isStartConsultationAppl");//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623
			isEnableDateTimeAppl	=	(String) htAEManagePatient.get ( "isEnableDateTimeAppl");//Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133

			episode_id =(String) htAEManagePatient.get("episode_id");
			episode_visit_num =(String) htAEManagePatient.get("episode_visit_num");

			if(priority_value.equals("R")) { priority_num = 1; }
			else if(priority_value.equals("Y")) { priority_num = 2; }
			else if(priority_value.equals("G")) { priority_num = 3; }
			con.setAutoCommit(false);

			statusUpd	=	new StringBuffer();

		// updating pr_encounter start here

		try
		{
			if(!practitioner_id.equals("*ALL")) {
				//if(result) {
					AEPatQ		=	new StringBuffer() ;
					OPLast1		=	new StringBuffer() ;
					AEPatQ.append("update pr_encounter set ATTEND_PRACTITIONER_ID = ?");
					/*Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623 Start*/
					if(isStartConsultationAppl.equals("true"))
						AEPatQ.append(", VISIT_STATUS ='02' ");
					else/*End*/
						AEPatQ.append(", VISIT_STATUS ='04' ");
					AEPatQ.append(", assign_bed_num=?,ASSIGN_CARE_LOCN_TYPE=?, ASSIGN_CARE_LOCN_CODE=?,PATIENT_PRIORITY_NO=?, VISIT_STATUS_SET_ON_DATE=to_date(?,'dd/mm/yyyy hh24:mi:ss') ,VISIT_STATUS_SET_BY_USER = ?, modified_by_id = ?,modified_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'),modified_at_ws_no = ?,modified_facility_id = ?, priority_zone =?,treatment_area_code = ? where facility_id = ? and encounter_id = ? ");

					/* AEPatQ.append("update pr_encounter set ");
					AEPatQ.append("ATTEND_PRACTITIONER_ID = ?, VISIT_STATUS ='04',");
					AEPatQ.append("assign_bed_num=?,ASSIGN_CARE_LOCN_TYPE=?,");
					AEPatQ.append("ASSIGN_CARE_LOCN_CODE=?,PATIENT_PRIORITY_NO=?,");
					AEPatQ.append(" VISIT_STATUS_SET_ON_DATE=to_date(?,'dd/mm/yyyy hh24:mi:ss') ,");
					AEPatQ.append("VISIT_STATUS_SET_BY_USER = ?, modified_by_id = ?,");
					AEPatQ.append(" modified_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
					AEPatQ.append(" modified_at_ws_no = ?,modified_facility_id = ?, priority_zone =?, ");
					AEPatQ.append(" treatment_area_code = ? ");
					AEPatQ.append(" where facility_id = ?");
					AEPatQ.append("and encounter_id = ?"); */


					pstmt	=	con.prepareStatement(AEPatQ.toString());
					pstmt.setString(1,	practitioner_id);
					pstmt.setString(2,	bed_bay_no);
					pstmt.setString(3,	locn_type);
					pstmt.setString(4,	locn_code);
					pstmt.setInt(5,	priority_num);
					pstmt.setString(6,	sys_date);
					pstmt.setString(7,	login_user_id);
					pstmt.setString(8,	login_user_id);
					pstmt.setString(9,	sys_date);
					pstmt.setString(10,	login_at_ws_no);
					pstmt.setString(11,	facility_id);
					pstmt.setString(12,	priority_value);
					pstmt.setString(13,	treatment_area_code);
					pstmt.setString(14,	facility_id);
					pstmt.setString(15,	encounter_id);

					update_result	=	pstmt.executeUpdate();

					OPLast1.append("update OP_LAST_VISIT_FOR_SERVICE set ATTEND_PRACTITIONER_ID = ?, ASSIGN_CARE_LOCN_CODE=?,MODIFIED_BY_ID= ?, MODIFIED_DATE = to_date(?,'dd/mm/yyyy hh24:mi:ss'),MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where OPERATING_FACILITY_ID = ? and ENCOUNTER_ID = ? ");

/*					OPLast1.append("update OP_LAST_VISIT_FOR_SERVICE set ");
					OPLast1.append("ATTEND_PRACTITIONER_ID = ?, ASSIGN_CARE_LOCN_CODE=?,");
					OPLast1.append("MODIFIED_BY_ID    = ?,");
					OPLast1.append(" MODIFIED_DATE = to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
					OPLast1.append(" MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ?");
					OPLast1.append(" where OPERATING_FACILITY_ID = ?");
					OPLast1.append("and ENCOUNTER_ID = ?"); */

					pstmt2	=	con.prepareStatement(OPLast1.toString());
					pstmt2.setString(1,	practitioner_id);
					pstmt2.setString(2,	locn_code);
					pstmt2.setString(3,	login_user_id);
					pstmt2.setString(4,	sys_date);
					pstmt2.setString(5,	login_at_ws_no);
					pstmt2.setString(6,	facility_id);
					pstmt2.setString(7,	facility_id);
					pstmt2.setString(8,	encounter_id);
					pstmt2.executeUpdate();

					if(update_result > 0)
						result	= true;
					else{
						result	= false;
						sb.append("<br>Exception@PatQ: ");
					}
				//}
				if(pstmt!=null) pstmt.close();
				if((AEPatQ != null) && (AEPatQ.length() > 0)){
					AEPatQ.delete(0,AEPatQ.length());
				}
				if(pstmt2!=null) pstmt2.close();
				if((OPLast1 != null) && (OPLast1.length() > 0)){
					OPLast1.delete(0,OPLast1.length());
				}

			//	op_patient_queue start here
			if(result){
			try{
				/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
				if(("true").equals(isEnableDateTimeAppl))
				{
					statusUpd.append("assign_tmt_area_time =to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'), ");
				}else
				{
					if(previous_status.compareTo(queue_status)<0)  {
						// statusUpd.append(" assign_tmt_area_time = ");
						 statusUpd.append("assign_tmt_area_time =to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'), ");
					 }
				}

				UpdPat	=	new StringBuffer() ;
				UpdPat.append("update op_patient_queue set treatment_area_code = ?,PRIORITY_ZONE = ?, PAT_PRIORITY = ?, AE_BED_NO = ?,practitioner_id = ?,");
				//UpdPat.append("PRIORITY_ZONE = ?,AE_BED_NO = ?,practitioner_id = ?,");
				UpdPat.append(statusUpd);
				UpdPat.append("queue_status = ?, ");
				if(!( practitioner_id.equals("") || practitioner_id.equals("*ALL")) )
				{
					if(!isStartConsultationAppl.equals("true"))//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623
						UpdPat.append(" cons_srvc_start_date_time = SYSDATE, ");
				}
				UpdPat.append("modified_by_id = ?, modified_date = SYSDATE,modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? ");
				//UpdPat.append("modified_at_ws_no = ?, modified_facility_id = ? ");
				//UpdPat.append("where facility_id = ? ");
//				UpdPat.append("and trunc(queue_date) = trunc(to_date(?,'dd/mm/yyyy')) ");
//				UpdPat.append("and locn_type = ? and locn_code = ? and ");
//				UpdPat.append("encounter_id = ? ");
				UpdPat.append(" and encounter_id = ? ");
				pstmt				=	con.prepareStatement(UpdPat.toString());

  				if(practitioner_id.equals("") || practitioner_id.equals("*ALL")){
					practitioner_id = "*ALL";
					queue_status    = "02";
				}
				else
				{
					/*Added by Thamizh selvi on 4th Oct 2017 against ML-MMOH-CRF-0623 Start*/
					if(isStartConsultationAppl.equals("true"))
						queue_status = "02";
					else/*End*/
						queue_status    = "04";
				}
				pstmt.setString(++colIndex,	treatment_area_code);
				pstmt.setString(++colIndex,	priority_value);
				pstmt.setString(++colIndex,	priority_code);//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
				pstmt.setString(++colIndex,	bed_bay_no);
				pstmt.setString(++colIndex,	practitioner_id);
				if( !(statusUpd.toString().equals("")) ) {
					pstmt.setString(++colIndex,	assign_tmt_area_time);
				}
				pstmt.setString(++colIndex,	queue_status);
				pstmt.setString(++colIndex,	login_user_id);
				pstmt.setString(++colIndex,	login_at_ws_no);
				pstmt.setString(++colIndex,	facility_id);
				pstmt.setString(++colIndex,	facility_id);
			//	pstmt.setString(++colIndex,	queue_date);
			//	pstmt.setString(++colIndex,	locn_type	);
			//	pstmt.setString(++colIndex,	locn_code	);
				pstmt.setString(++colIndex,	encounter_id);
				update_result	=	pstmt.executeUpdate();

				if(update_result > 0)
					result	= true;
				else{
					result	= false;
					sb.append("<br>Exception@UpdatePatientQ: ");
				}
				if(pstmt!=null) pstmt.close();
				if((UpdPat != null) && (UpdPat.length() > 0)) { UpdPat.delete(0,UpdPat.length()); }
			}catch(Exception e)  {
				e.printStackTrace();
				result	= false;
			}
		}
			//	op_patient_queue end here

				/*if(result) {
				    result = updatingPrEncounter(htAEManagePatient);

				}*/
			}  else   {
				//if(result)   {
					PatQUp		=	new StringBuffer() ;
					OPLast2		=	new StringBuffer() ;

					PatQUp.append(" update pr_encounter set ATTEND_PRACTITIONER_ID = ?,VISIT_STATUS=DECODE(VISIT_STATUS,'04','04','02'),  assign_bed_num=?,ASSIGN_CARE_LOCN_TYPE=?,ASSIGN_CARE_LOCN_CODE=?,PATIENT_PRIORITY_NO=?,visit_status_set_on_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'), visit_status_set_by_user = ?,modified_by_id = ?,modified_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'),modified_at_ws_no = ?,modified_facility_id = ?, priority_zone =?,treatment_area_code = ? where facility_id = ? and encounter_id = ? ");

					/* PatQUp.append("update pr_encounter set ATTEND_PRACTITIONER_ID = ?,");
					PatQUp.append(" VISIT_STATUS=DECODE(VISIT_STATUS,'04','04','02'),  assign_bed_num=?,");
					PatQUp.append(" ASSIGN_CARE_LOCN_TYPE=?,ASSIGN_CARE_LOCN_CODE=?,");
					PatQUp.append(" PATIENT_PRIORITY_NO=?, ");
					PatQUp.append(" visit_status_set_on_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
					PatQUp.append(" visit_status_set_by_user = ?,modified_by_id = ?,");
					PatQUp.append(" modified_date = to_date(?,'dd/mm/yyyy hh24:mi:ss'), ");
					PatQUp.append(" modified_at_ws_no = ?,modified_facility_id = ?, priority_zone =?, ");
					PatQUp.append(" treatment_area_code = ? ");
					PatQUp.append(" where facility_id = ? and encounter_id = ?"); */
					pstmt				=	con.prepareStatement(PatQUp.toString());

					if(practitioner_id.equals("*ALL")) {
						practitioner_id = "";
					}

					pstmt.setString(1,	practitioner_id);
					pstmt.setString(2,	bed_bay_no);
					pstmt.setString(3,	locn_type	);
					pstmt.setString(4,	locn_code	);
					pstmt.setInt(5,	priority_num);
					pstmt.setString(6,	sys_date);
					pstmt.setString(7,	login_user_id);
					pstmt.setString(8,	login_user_id);
					pstmt.setString(9,	sys_date);
					pstmt.setString(10,	login_at_ws_no);
					pstmt.setString(11,	facility_id);
					pstmt.setString(12,	priority_value);
					pstmt.setString(13,	treatment_area_code);
					pstmt.setString(14,	facility_id);
					pstmt.setString(15,	encounter_id);

					update_result	=	pstmt.executeUpdate();
					// Newly Added
					OPLast2.append(" update OP_LAST_VISIT_FOR_SERVICE set ATTEND_PRACTITIONER_ID = ?, ASSIGN_CARE_LOCN_CODE=?,MODIFIED_BY_ID    = ?,MODIFIED_DATE = to_date(?,'dd/mm/yyyy hh24:mi:ss'), MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where OPERATING_FACILITY_ID = ? and ENCOUNTER_ID = ? ");
					/*
					OPLast2.append("update OP_LAST_VISIT_FOR_SERVICE set ");
					OPLast2.append("ATTEND_PRACTITIONER_ID = ?, ASSIGN_CARE_LOCN_CODE=?,");
					OPLast2.append("MODIFIED_BY_ID    = ?,");
					OPLast2.append(" MODIFIED_DATE = to_date(?,'dd/mm/yyyy hh24:mi:ss'),");
					OPLast2.append(" MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ?");
					OPLast2.append(" where OPERATING_FACILITY_ID = ?");
					OPLast2.append("and ENCOUNTER_ID = ?"); */

					pstmt2	=	con.prepareStatement(OPLast2.toString());


					pstmt2.setString(1,	practitioner_id);
					pstmt2.setString(2,	locn_code	);
					pstmt2.setString(3,	login_user_id);
					pstmt2.setString(4,	sys_date);
					pstmt2.setString(5,	login_at_ws_no);
					pstmt2.setString(6,	facility_id);
					pstmt2.setString(7,	facility_id);
					pstmt2.setString(8,	encounter_id);
					pstmt2.executeUpdate();

					if(update_result > 0)
						result	= true;
					else{
						result	= false;
						sb.append("<br>Exception@PatQUpdate: ");
					}
				//}
				if(pstmt!=null) pstmt.close();
				if((PatQUp != null) && (PatQUp.length() > 0)) 	{
					PatQUp.delete(0,PatQUp.length());
				}
				if(pstmt2!=null) pstmt2.close();
				if((OPLast2 != null) && (OPLast2.length() > 0)) 	{
					OPLast2.delete(0,OPLast2.length());
				}
			//	op_patient_queue start here
			if(result){
			try{
				/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
				if(("true").equals(isEnableDateTimeAppl))
				{
					statusUpd.append("assign_tmt_area_time =to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'), ");
				}else
				{
					if(previous_status.compareTo(queue_status)<0)  {
						// statusUpd.append(" assign_tmt_area_time = ");
						 statusUpd.append("assign_tmt_area_time =to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'), ");
					 }
				}


				UpdPat	=	new StringBuffer() ;
				UpdPat.append("update op_patient_queue set treatment_area_code = ?,PRIORITY_ZONE = ?, PAT_PRIORITY = ?, AE_BED_NO = ?,practitioner_id = ?,");
				//UpdPat.append("PRIORITY_ZONE = ?,AE_BED_NO = ?,practitioner_id = ?,");
				UpdPat.append(statusUpd);
				UpdPat.append("queue_status = ?, ");
				if(!( practitioner_id.equals("") || practitioner_id.equals("*ALL")) )
				{
					UpdPat.append(" cons_srvc_start_date_time = SYSDATE, ");
				}
				UpdPat.append("modified_by_id = ?, modified_date = SYSDATE,modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and trunc(queue_date) = trunc(to_date(?,'dd/mm/yyyy')) and locn_type = ? and locn_code = ? and encounter_id = ?");

			/*	UpdPat.append("modified_by_id = ?, modified_date = SYSDATE, ");
				UpdPat.append("modified_at_ws_no = ?, modified_facility_id = ? ");
				UpdPat.append("where facility_id = ? ");
				UpdPat.append("and trunc(queue_date) = trunc(to_date(?,'dd/mm/yyyy')) ");
				UpdPat.append("and locn_type = ? and locn_code = ? and ");
				UpdPat.append("encounter_id = ? "); */
				pstmt				=	con.prepareStatement(UpdPat.toString());

  				if(practitioner_id.equals("") || practitioner_id.equals("*ALL")){
					practitioner_id = "*ALL";
					queue_status    = "02";
				}
				else
				{
					queue_status    = "04";
				}
				pstmt.setString(++colIndex,	treatment_area_code);
				pstmt.setString(++colIndex,	priority_value);
				pstmt.setString(++colIndex,	priority_code);//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
				pstmt.setString(++colIndex,	bed_bay_no);
				pstmt.setString(++colIndex,	practitioner_id);
				if( !(statusUpd.toString().equals("")) ) {
					pstmt.setString(++colIndex,	assign_tmt_area_time);
				}
				pstmt.setString(++colIndex,	queue_status);
				pstmt.setString(++colIndex,	login_user_id);
				pstmt.setString(++colIndex,	login_at_ws_no);
				pstmt.setString(++colIndex,	facility_id);
				pstmt.setString(++colIndex,	facility_id);
				pstmt.setString(++colIndex,	queue_date);
				pstmt.setString(++colIndex,	locn_type	);
				pstmt.setString(++colIndex,	locn_code	);
				pstmt.setString(++colIndex,	encounter_id);
				update_result	=	pstmt.executeUpdate();

				if(update_result > 0)
					result	= true;
				else{
					result	= false;
					sb.append("<br>Exception@UpdatePatientQ: ");
				}
				if(pstmt!=null) pstmt.close();
				if((UpdPat != null) && (UpdPat.length() > 0)) { UpdPat.delete(0,UpdPat.length()); }
			}catch(Exception e)  {
				e.printStackTrace();
				result	= false;
			}
		}
			//	op_patient_queue end here
			}

			}catch(Exception e)  {
				e.printStackTrace();
				result	= false;
			}

		// updating pr_encounter end here



			// result 1
			if(result) {
				result = updatingAEBedDetail(htAEManagePatient);
				}

				// result 2
	     		if(result){
				AEPro		=	new StringBuffer() ;
				AEPro.append("{call AE_CALC_QUEUE_SUMM(?, ?, ?, ?, ?, ?, ?)}");
				cstmt					=	con.prepareCall(AEPro.toString());
				cstmt.setString	(1,	facility_id);
				cstmt.setString	(2,	queue_date);
				cstmt.setString	(3,	locn_type);
				cstmt.setString	(4,	locn_code);
				cstmt.setString	(5,	treatment_area_code);
				cstmt.setString	(6,	login_user_id);
				cstmt.registerOutParameter(7,	java.sql.Types.VARCHAR);
				cstmt.execute();

				error_msg	=	cstmt.getString(7);
				if(error_msg==null) error_msg = "";
				if(!(error_msg.equals("NO_ERROR"))) {
					result	= false;
					sb.append(error_msg);
				}
				if(cstmt!=null) cstmt.close();
			}

			// result 3
			if(result) {
				if(!prev_tmt_area_code.equals("")) {
					cstmt	=	con.prepareCall(AEPro.toString());

					cstmt.setString	(1,	facility_id);
					cstmt.setString	(2,	queue_date);
					cstmt.setString	(3,	locn_type);
					cstmt.setString	(4,	locn_code);
					cstmt.setString	(5,	prev_tmt_area_code);
					cstmt.setString	(6,	login_user_id);
					cstmt.registerOutParameter(7, java.sql.Types.VARCHAR	);
					cstmt.execute();
					error_msg	=	cstmt.getString(7);
 					if(error_msg==null) error_msg = "";
					if(!(error_msg.equals("NO_ERROR"))) {
						result	= false;
						sb.append(error_msg);
					}
					if(cstmt!=null) cstmt.close();
					if((AEPro != null) && (AEPro.length() > 0)) {
						AEPro.delete(0,AEPro.length());
					}
				}
			}



     //Added for Billing
	 if(bl_install_yn.equalsIgnoreCase("Y"))
	     {

			if(result)
				{
			    if(!practitioner_id.equals("*ALL"))
			     {
				 try
				  {

					Hashtable hashtableBL = new Hashtable();
					hashtableBL.put("patient_id",patient_id);
					hashtableBL.put("facilityId",facility_id);
					hashtableBL.put("episode_id",episode_id);
					hashtableBL.put("visit_id",episode_visit_num);
					hashtableBL.put("clinic_code",locn_code);
					hashtableBL.put("episode_type","E");
					hashtableBL.put("module_id","AE");
					hashtableBL.put("clinic_type",locn_type);
					hashtableBL.put("asn_visit_type_code",visit_type_code);
					hashtableBL.put("cur_visit_type_code",visit_type_code);
					hashtableBL.put("asn_pract_id",practitioner_id);
					hashtableBL.put("practitioner_type_ind","P");
					hashtableBL.put("locntype",locn_type);
					hashtableBL.put("locncode",locn_code);
					hashtableBL.put("encounterid",encounter_id);
					hashtableBL.put("practid",practitioner_id);
					hashtableBL.put("curlocncode",locn_code);
					hashtableBL.put("curlocntype",locn_type);
					hashtableBL.put("asslocncode",locn_code);
					hashtableBL.put("asslocntype",locn_type);
					hashtableBL.put("curpractid",practitioner_id);
					hashtableBL.put("curpracttype",pract_type);
					hashtableBL.put("curvisittypecode",visit_type_code);
					hashtableBL.put("assvisittypecode",visit_type_code);
					hashtableBL.put("visitcase","W");
					hashtableBL.put("addedAtWorkstation",login_at_ws_no);
					hashtableBL.put("addedFacilityId",facility_id);
					hashtableBL.put("addedById",login_user_id);
					hashtableBL.put("locale",locale);
					hashtableBL.put("function_id","ASSIGN_PRACTITIONER");
					hashtableBL.put("fin_dtls", htAEManagePatient.get("fin_dtls"));
					BLOPReviseVisit  blRevise = new BLOPReviseVisit();
					Hashtable resultsBL = blRevise.billPatientService(jdbc_props,con,hashtableBL);

					boolean boolBLStatus = ((Boolean)(resultsBL.get("status"))).booleanValue();
			        result = boolBLStatus;

					billgenlater = (String) (resultsBL.get("billgenlater"));
					billtotalamt = (String) (resultsBL.get("billtotalamt"));
			        strBLMessage = (String)resultsBL.get("message");

					str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
					pgm_id = (String)(resultsBL.get("pgm_id"));
					session_id = (String)(resultsBL.get("session_id"));
					pgm_date = (String)(resultsBL.get("pgm_date"));
					mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));

			        if (boolBLStatus == false)
			        {
				      sb.append((String)resultsBL.get("error"));
			        }
					if (boolBLStatus == true)
			        {
			           if ( strBLMessage != null )
				       {
					    if ((strBLMessage.trim().equals("")))
					    {
						    strBLMessage = " ";
					    }
				       }
				       else
				       {
					     strBLMessage = "0";
				       }
			       }
				resultsBL.clear();
				hashtableBL.clear();
				}
		        catch(Exception exceptionBL)
		        {
				exceptionBL.printStackTrace();
			     sb.append(" Error in BL "+exceptionBL);
		        }
		 }
	 }
}
			if(result) {
				result = true ;
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                String msg  = ((String) mesg.get("message"));
				sb.append(msg) ;
				mesg.clear();
				con.commit();
			} else {
				con.rollback();
				sb.append("<br>"+recordmsg);
			}
			htAEManagePatient.clear();

		} // end of try
		catch(Exception e) {
			e.printStackTrace();
			sb.append("<br>"+recordmsg);
			result	= false;
		}finally{
			if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
		} // end of finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		if ((strBLMessage == null) || (strBLMessage.equals(""))) {
			strBLMessage = "0";
		}
		results.put("bl_message", strBLMessage);
		results.put("billgenlater", billgenlater);
		results.put("billtotalamt", billtotalamt);

		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);

		return results ;
	} // end of method assignTreatmentArea
	//Function

	public boolean updatingAEBedDetail(java.util.HashMap	htAEManagePatient){
		StringBuffer        AEPatLog		= null;
		PreparedStatement	pstmt		= null;
		int updateRec1					= 0;
		String practitioner_id2			= (String) htAEManagePatient.get ( "practitioner_id"		);
  		try{

				if (practitioner_id2.equals("")	|| practitioner_id2.equals("*ALL"))  {
					practitioner_id2="";
				}
				AEPatLog		=	new StringBuffer() ;


				AEPatLog.append("insert /*+ append */ into ae_pat_movement_log (patient_id,facility_id,encounter_id,assign_tmt_area_code,assign_practitioner_id,assign_date,assign_clinic_code,assign_bed_no,added_facility_id,added_date,added_by_id,added_at_ws_no)  values (?,?,?,?,?,to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'),?,?,?,sysdate,?,?)");

			//	AEPatLog.append("insert /*+ append */ into ae_pat_movement_log ");
			/*	AEPatLog.append("(patient_id,facility_id,encounter_id, ");
				AEPatLog.append("assign_tmt_area_code,assign_practitioner_id,");
				AEPatLog.append("assign_date,assign_clinic_code,assign_bed_no,added_facility_id, ");
				AEPatLog.append("added_date,added_by_id,added_at_ws_no)  values ");
				AEPatLog.append("(?,?,?,?,?,");
				AEPatLog.append("to_date(?||to_char(sysdate,'ss'),'dd/mm/yyyy hh24:mi:ss'),");
				AEPatLog.append("?,?,?,sysdate,?,?) "); */

   				pstmt				=	con.prepareStatement(AEPatLog.toString());

				pstmt.setString	(	1,(String) htAEManagePatient.get ("patient_id"));
				pstmt.setString	(	2,(String) htAEManagePatient.get("facility_id"));
				pstmt.setString	(	3,(String) htAEManagePatient.get( "encounter_id"));
				pstmt.setString	(	4,(String) htAEManagePatient.get("treatment_area_code"));
				pstmt.setString	(	5,practitioner_id2);
				pstmt.setString	(	6,(String) htAEManagePatient.get("assign_tmt_area_time"));
				pstmt.setString	(	7,(String) htAEManagePatient.get("locn_code"));
				pstmt.setString	(	8,(String) htAEManagePatient.get( "bed_bay_no"));
				pstmt.setString	(	9,(String) htAEManagePatient.get("facility_id"));
				pstmt.setString	(	10,(String) htAEManagePatient.get("login_user_id"));
				pstmt.setString	(	11,(String) htAEManagePatient.get( "login_at_ws_no"));

				updateRec1	=	pstmt.executeUpdate();
				if((AEPatLog != null) && (AEPatLog.length() > 0)) {
					AEPatLog.delete(0,AEPatLog.length());
				}
				if(pstmt!=null) pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		/*try{
			htAEManagePatient.clear();
		}catch(Exception e) {  }*/
		return true;
	}

	// Function 3
	/*public boolean updatingPrEncounter(java.util.HashMap	htAEManagePatient){
		StringBuffer AEPract			=	new StringBuffer() ;
		StringBuffer specl			=	new StringBuffer() ;
		StringBuffer InPract			=	new StringBuffer() ;
		StringBuffer PRPract			=	new StringBuffer() ;
		StringBuffer srl				=	new StringBuffer() ;
		PreparedStatement	pstmt	=	null;
		PreparedStatement	srlpstmt	=	null;
		ResultSet			rs		=	null;
		ResultSet			srlRS		=	null;
		String  remarks			=   "",     speciality_code			=	"";
		int update_result = 0;
		int		colPractIndex=0;
		boolean result =false;
		try{

			AEPract.append("select PRACTITIONER_ID from pr_encounter_pract ");
			AEPract.append(" where OPERATING_FACILITY_ID =? and ENCOUNTER_ID=? ");
			pstmt		=	con.prepareStatement(AEPract.toString());
			pstmt.setString(1,(String) htAEManagePatient.get("facility_id"));
			pstmt.setString(2,(String) htAEManagePatient.get( "encounter_id"));
			rs			=	pstmt.executeQuery();

			if(rs.next() && rs!=null) {

				PRPract.append("update pr_encounter_pract set ");
				PRPract.append("practitioner_id = ? ,modified_by_id = ?,");
				PRPract.append("modified_date = SYSDATE,modified_at_ws_no = ?,");
				PRPract.append(" modified_facility_id = ? ");
				PRPract.append(" where operating_facility_id = ? ");
				PRPract.append(" and encounter_id = ? ");

				pstmt		=	con.prepareStatement(PRPract.toString());
   				pstmt.setString(1,(String) htAEManagePatient.get ( "practitioner_id"));
				pstmt.setString(2,(String) htAEManagePatient.get ( "login_user_id"));
				pstmt.setString(3,(String) htAEManagePatient.get ( "login_at_ws_no"));
				pstmt.setString(4,(String) htAEManagePatient.get("facility_id"));
				pstmt.setString(5,(String) htAEManagePatient.get("facility_id"));
				pstmt.setString(6,(String) htAEManagePatient.get( "encounter_id"));

				update_result	=	pstmt.executeUpdate();
				if(update_result > 0)
					result	= true;
				else{
					result	= false;

				}
				if((AEPract != null) && (AEPract.length() > 0)) {
					AEPract.delete(0,AEPract.length());
				}
				if((PRPract != null) && (PRPract.length() > 0)){
					PRPract.delete(0,PRPract.length());
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} else{
				//if(result)   {

					specl.append("select PRIMARY_SPECIALITY_CODE from ");
					specl.append(" am_practitioner  where PRACTITIONER_ID = ? ");
					pstmt		=	con.prepareStatement(specl.toString());
					pstmt.setString(1,(String) htAEManagePatient.get ( "practitioner_id"));
					rs			=	pstmt.executeQuery();
					if(rs.next() && rs!=null)
						speciality_code=rs.getString("PRIMARY_SPECIALITY_CODE");
						if((specl != null) && (specl.length() > 0)) 	{
							specl.delete(0,specl.length());
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						int SRL_NO = 0;

						srl.append("SELECT NVL(MAX(SRL_NO),0)+1 FROM ");
						srl.append(" PR_ENCOUNTER_PRACT WHERE OPERATING_FACILITY_ID = ? ");
						srl.append(" AND ENCOUNTER_ID=? AND PRACTITIONER_ID=?  ");
						srl.append(" AND PRACTITIONER_ROLE='1' ");
						srlpstmt		=	con.prepareStatement(srl.toString());
						srlpstmt.setString(1,(String) htAEManagePatient.get("facility_id"));
						srlpstmt.setString(2,(String) htAEManagePatient.get( "encounter_id"));
						srlpstmt.setString(3,(String) htAEManagePatient.get ( "practitioner_id"));
						srlRS			=	srlpstmt.executeQuery();
						if( srlRS !=null ) {
							while(srlRS.next()) {
								SRL_NO	= srlRS.getInt(1);
							}
						}
						if((srl != null) && (srl.length() > 0)) {
							srl.delete(0,srl.length());
						}
						if(srlRS!=null) srlRS.close();
						if(srlpstmt!=null) srlpstmt.close();

						InPract.append("insert into  pr_encounter_pract ");
						InPract.append("(OPERATING_FACILITY_ID,ENCOUNTER_ID,");
						InPract.append("PRACTITIONER_ID,PRACTITIONER_ROLE,");
						InPract.append("SPECIALTY_CODE,REMARKS,ADDED_BY_ID,");
						InPract.append("ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,");
						InPract.append("MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,");
						InPract.append("MODIFIED_FACILITY_ID,SRL_NO) ");
						InPract.append(" values (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?) ");
						pstmt		=	con.prepareStatement(InPract.toString());

						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get("facility_id"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get( "encounter_id"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get ( "practitioner_id"));
						pstmt.setString(++colPractIndex,"1");
						pstmt.setString(++colPractIndex,speciality_code);
						pstmt.setString(++colPractIndex,remarks);
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get ( "login_user_id"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get ( "login_at_ws_no"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get("facility_id"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get ( "login_user_id"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get ( "login_at_ws_no"));
						pstmt.setString(++colPractIndex,(String) htAEManagePatient.get("facility_id"));
						pstmt.setInt (++colPractIndex,SRL_NO);

 						pstmt.executeUpdate();
		            		//}
				}
			}catch (Exception e){

			return false;
			}
			try{
				if(pstmt!=null) pstmt.close();
				if((InPract != null) && (InPract.length() > 0)) {
					InPract.delete(0,InPract.length());
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				//htAEManagePatient.clear();
			}catch(Exception e) {  }
		return true;
	}*/

	/**
	 *Method to Start Consultation
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/



	public java.util.HashMap startConsultation(Properties	jdbc_props, java.util.HashMap	htAEManagePatient){
		locale         				=	(String) htAEManagePatient.get ( "locale"	);
		Connection			con	=	null;
		PreparedStatement	pstmt	=	null;
		CallableStatement	cstmt	=	null;
		java.util.HashMap results		=	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;
		String	facility_id			=	"",		login_user_id			=	"";
		String	login_at_ws_no	=	"",		encounter_id			=	"";
		String	locn_code			=	"",		locn_type				=	"";
		String	queue_date		=	"",		queue_status			=	"";
		String	practitioner_id		=	"",		treatment_area_code	=	"";
		String	error_msg		=	"";
		boolean result				=	false;
		int		update_result		=	0;
		StringBuffer	OPPatQ		= null;
		StringBuffer	AEPr			= null;
		StringBuffer	AEPrEnc		= null;

		try {
			facility_id				=	(String) htAEManagePatient.get ( "facility_id");
			login_user_id			=	(String) htAEManagePatient.get ( "login_user_id");
			login_at_ws_no		=	(String) htAEManagePatient.get ( "login_at_ws_no");
			encounter_id			=	(String) htAEManagePatient.get ( "encounter_id");
			locn_code				=	(String) htAEManagePatient.get ( "locn_code");
			locn_type				=	(String) htAEManagePatient.get ( "locn_type"	);
			queue_date			=	(String) htAEManagePatient.get ( "queue_date");
			queue_status			=	(String) htAEManagePatient.get ( "queue_status");
			practitioner_id			=	(String) htAEManagePatient.get ( "practitioner_id");
			treatment_area_code	=	(String) htAEManagePatient.get ( "treatment_area_code");
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);

			AEPrEnc		=	new StringBuffer() ;
				AEPrEnc.append("update pr_encounter set visit_status = ?, visit_status_set_on_date = to_date( SYSDATE,'dd/mm/yyyy hh24:mi:ss'), visit_status_set_by_user = ?,modified_by_id = ?, modified_date =to_date( SYSDATE,'dd/mm/yyyy hh24:mi:ss'),modified_at_ws_no = ?,modified_facility_id = ? where facility_id = ? and encounter_id = ? ");

			pstmt				=	con.prepareStatement(AEPrEnc.toString());
			pstmt.setString	(	1,	queue_status			);
			pstmt.setString	(	2,	login_user_id			);
			pstmt.setString	(	3,	login_user_id			);
			pstmt.setString	(	4,	login_at_ws_no			);
			pstmt.setString	(	5,	facility_id				);
			pstmt.setString	(	6,	facility_id				);
			pstmt.setString	(	7,	encounter_id			);
			update_result	=	pstmt.executeUpdate();
			if(update_result > 0)
				result	= true;
			else
				result	= false;
			if(pstmt!=null) pstmt.close();
			if((AEPrEnc != null) && (AEPrEnc.length() > 0)) {
				AEPrEnc.delete(0,AEPrEnc.length());
			}

			if (result)  {
			OPPatQ		=	new StringBuffer() ;
			OPPatQ.append("update op_patient_queue set  cons_srvc_start_date_time = SYSDATE,queue_status = ?, modified_by_id = ?, modified_date = SYSDATE,modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ?  and trunc(queue_date) = trunc(to_date(?,'dd/mm/yyyy'))  and locn_type = ? and locn_code = ? and  encounter_id = ? and treatment_area_code = ? and practitioner_id = ?");


			pstmt				=	con.prepareStatement(OPPatQ.toString());
			if(practitioner_id.equals("")) practitioner_id = "*ALL";
			pstmt.setString(1,	queue_status);
			pstmt.setString(2,	login_user_id);
			pstmt.setString(3,	login_at_ws_no);
			pstmt.setString(4,	facility_id);
			pstmt.setString(5,	facility_id);
			pstmt.setString(6,	queue_date);
			pstmt.setString(7,	locn_type);
			pstmt.setString(8,	locn_code);
			pstmt.setString(9,	encounter_id);
			pstmt.setString(10,	treatment_area_code);
			pstmt.setString(11,	practitioner_id);

			update_result	=	pstmt.executeUpdate();
			 if(update_result > 0)
				result	= true;
			 else
				result	= false;
			if(pstmt!=null) pstmt.close();
			if((OPPatQ != null) && (OPPatQ.length() > 0)) {
				OPPatQ.delete(0,OPPatQ.length());
			}
			}


			if (result)   {
				AEPr		=	new StringBuffer() ;
				AEPr.append("{call AE_CALC_QUEUE_SUMM(?, ?, ?, ?, ?, ?, ?)}");
				cstmt					=	con.prepareCall(AEPr.toString());

				cstmt.setString	(1,	facility_id);
				cstmt.setString	(2,	queue_date);
				cstmt.setString	(3,	locn_type);
				cstmt.setString	(4,	locn_code	);
				cstmt.setString	(5,	treatment_area_code);
				cstmt.setString	(6,	login_user_id);
				cstmt.registerOutParameter(7,   java.sql.Types.VARCHAR);
				cstmt.execute();

				error_msg	=	cstmt.getString(7);
				if(error_msg==null) error_msg = "";
				if(!(error_msg.equals("NO_ERROR"))) {
					result	= false;
					sb.append(error_msg);
				}
				if(cstmt!=null) cstmt.close();
				if((AEPr != null) && (AEPr.length() > 0)) {
					AEPr.delete(0,AEPr.length());
				}
			}

			if(result) {
				result = true ;
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                String msg  = ((String) mesg.get("message"));
				sb.append(msg) ;
				mesg.clear();
				con.commit();
			}  else {
					con.rollback();
			}
			htAEManagePatient.clear();
		} // end of try
		catch(Exception e) {
			e.printStackTrace();
			result	= false;
			sb.append("<br>Exception@EJB5: "+e);
		} finally {
				if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
		} // end of finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	} // end of method startConsultation


} // end of class AEManagePatientManager

