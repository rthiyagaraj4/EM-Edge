/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.RecDiagnosis;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.rmi.RemoteException;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="RecDiagnosis"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecDiagnosis"
*	local-jndi-name="RecDiagnosis"
*	impl-class-name="eMR.RecDiagnosis.RecDiagnosisManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.RecDiagnosis.RecDiagnosisLocal"
*	remote-class="eMR.RecDiagnosis.RecDiagnosisRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.RecDiagnosis.RecDiagnosisLocalHome"
*	remote-class="eMR.RecDiagnosis.RecDiagnosisHome"
*	generate= "local,remote"
*
*
*/

public class RecDiagnosisManager implements SessionBean
{
	Connection con ;
	PreparedStatement pstmt			= null;
	PreparedStatement supportPstmt	= null;
	PreparedStatement pstmt1		= null;
	PreparedStatement pstmt2		= null;
	PreparedStatement pstmt3		= null;
	PreparedStatement logPstmt		= null;
	ResultSet rset					= null;
	ResultSet rs					= null;
	ResultSet rs2					= null;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext context) {this.ctx=context; }
	
	boolean isDeceasedDiagClassDeathRegAppl = false; //Added by Jeyachitra - ML-MMOH-CRF 1742

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertRecDiagnosis(Properties p,HashMap tableData)
	{
		java.util.HashMap results	= new java.util.HashMap() ;
		StringBuffer support		= new StringBuffer();
		StringBuffer sbSql			= new StringBuffer();
		StringBuffer sbMsg			= new StringBuffer();
		StringBuffer errLog			= new StringBuffer();
		boolean	result				= true ;
		int count					= 0;
		int srl_no					= 0;
		int err_no					= 0;
		int log_updated				= 0;
		String diag_enc_level_yn="N";
		String restrict_sec_diag_yn ="N";
		String x_facility_id				=	(String)tableData.get("x_facility_id");
		String client_ip_address			=	(String)tableData.get("client_ip_address");
		String Practitioner_Id				=	(String)tableData.get("Practitioner_Id"); 
		String relationship_id				=	(String)tableData.get("relationship_id"); 
		String Locn_Code					=	(String)tableData.get("Locn_Code"); 
		String Locn_Type					=	(String)tableData.get("Locn_Type"); 
		if(Locn_Type.equals("W"))
				Locn_Type = "N";
		String Encounter_Id					=	(String)tableData.get("Encounter_Id");
		String old_onset_type				=	(String)tableData.get("old_onset_type");
		//long Encounter_ID = 0;
		//Encounter_ID = (long)Long.parseLong(Encounter_Id);
		String mode							=	(String)tableData.get("mode");
		String Patient_Id					=	(String)tableData.get("Patient_Id"); 
		String external_diag_code			=	""; 
		String code_set						=	(String)tableData.get("code_set"); 
		String diagprob_code				=	(String)tableData.get("diagprob_code");
		if(diagprob_code.equals(""))
				diagprob_code				=   "*OTH";
		String diff_group_id_hid			=	"0";
		String accuracy						=	(String)tableData.get("accuracy");
		String accuracy_ind					=	(String)tableData.get("accuracy_ind");
		String nature						=	(String)tableData.get("nature"); 
		String priority						=	(String)tableData.get("priority"); 
		String severity						=	(String)tableData.get("severity"); 
		String onset_date					=	(String)tableData.get("onset_date"); 
		String type							=	(String)tableData.get("type"); 
		String status						=	(String)tableData.get("status"); 
		String status_date					=	(String)tableData.get("status_date");
		String remarks						=	(String)tableData.get("remarks"); 
		String as_evidenced_by_hid			=	(String)tableData.get("as_evidenced_by_hid"); 
		String associate_codes				=	(String)tableData.get("associate_codes");
		String occur_srl_no_hid				=	(String)tableData.get("occur_srl_no_hid");
		String associate_codes_modify		=	(String)tableData.get("associate_codes_modify");
		String cause_of_death_yn			=	(String)tableData.get("cause_of_death_yn");
		String link_diag_pri_sec_yn			=	(String)tableData.get("link_diag_pri_sec_yn");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		String stage_code					=	(String)tableData.get("stage_code");
		String code_indicator				=	(String)tableData.get("code_indicator");
		String poa_indicator				=	(String)tableData.get("poa_indicator");
		String addedById					=	p.getProperty( "login_user" ) ;
		String curr_encr_flag				=	(String)tableData.get("curr_encr_flag");
		String diag_catg_code				=	(String)tableData.get("diag_catg_code");//Added by Ajay for TH-KW-CRF-165.1
		String slink_flag					=	(String)tableData.get("slink_flag"); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
		//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
		//Start
		String curr_encounter_id					=	(String)tableData.get("curr_encounter_id");
		String onset_encounter_id					=	(String)tableData.get("onset_encounter_id");
		diag_enc_level_yn					=	(String)tableData.get("diag_enc_level");
		restrict_sec_diag_yn					=    (String)tableData.get("restrict_sec_diag_yn");
		String old_encounter_id				=	(String)tableData.get("old_encounter_id");
		//While resolving the diags of previous enc in current enc window(will be S link in current enc), assigning the previous enc id only
		if(diag_enc_level_yn.equals("Y"))
			{
			if(curr_encr_flag.equals("Y")&&(status.equals("R")))
			Encounter_Id=old_encounter_id;
			}
		else 
			{
			if(curr_encr_flag.equals("Y")&&(status.equals("R")))
			Encounter_Id=curr_encounter_id;
			}
		//End
		String factor_code					=	"";			
		String new_group_id					=	(String)tableData.get("diff_group_vals");
		//String old_encounter_id				=	(String)tableData.get("old_encounter_id");
		String anatomical_site				=	(String)tableData.get("anatomical_site");
		String applicable_side				=	(String)tableData.get("applicable_side");
		String accession_number				=	(String)tableData.get("accession_number");
		String diag_class_code				=	(String)tableData.get("diag_class_code");
		String high_risk_code				=	(String)tableData.get("high_risk_code");
		String diag_Description				=	(String)tableData.get("diag_Description");
		String complaint_id 				=	(String)tableData.get("complaint_id");
		String anatomical_oral_sites		=	(String)tableData.get("anatomical_oral_sites");
		String call_from								=	(String)tableData.get("call_from");//Getting From MDR added On 9/15/2009
		String recorded_from_death_reg_yn		=	"";//Getting From MDR added On 9/15/2009

		String called_from_ot=(String)tableData.get("called_from_ot_desc"); //Added for this CRF [PMG2012-CRF-0030]
		
		RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet) tableData.get("OHDiagLinkConditionBean");

		String notifiable_code		=	(String)tableData.get("notifiable_code");	//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
		//Added for this CRF Bru-HIMS-CRF-024.2
		String accession_num_work_related=	(String)tableData.get("accession_num_work_related");
        String accession_num_notifiable=(String)tableData.get("accession_num_notifiable");
		
		String isMultiDescAppl = (String)tableData.get("isMultiDescAppl"); // added by mujafar for ML-MMOH-CRF-1281 US3
		String term_oth_desc = (String)tableData.get("term_oth_desc");
		
		//Added by Jeyachitra - ML-MMOH-CRF 1742
		String aud_complaint_desc = checkForNull((String)tableData.get("aud_complaint_desc"));
		String complaint_desc = checkForNull((String)tableData.get("complaint_desc"));
		
		if(new_group_id.equals("undefined"))
			new_group_id="";
		String modifiedById			= addedById ;
		String modifiedAtWorkstation= client_ip_address ;
		String addedAtWorkstation	= modifiedAtWorkstation;
		String temp_code_set		= ""; 
		String temp_diagprob_code	= "";
		String temp_severity		= "";		
		String temp_type			= "";
		String temp_Practitioner_Id	= "";
		String temp_relationship_id	= "";
		String temp_Locn_Type		= "";  	
		String temp_Locn_Code		= "";
		String temp_nature			= "";	
		String temp_priority		= "";
		String temp_accuracy		= "";	
		String temp_accuracy_ind	= "";
		String temp_remarks			= "";	
		String temp_status			= "";
		String temp_status_date		= "";		
		String occur_srl_no			= "";		
		String err_srl_no			= "";
		String temp_occur_srl_no	= "";
		String temp_srl_no			= "";
		//String error_marked_date	= "";
		//String error_marked_by_id	= "";
		//String error_remarks		= "";
		String locale				= p.getProperty("LOCALE");
		String complaint			= "";
		//String comp_occur_srl_no	= "";
		String comp_onset_date_time	= "";
		String n_code				= "";
		StringBuffer n_code_list			= new StringBuffer();
		String chief_compl_code_list="";
		boolean first_time			= true;
		//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
		//Start
		String occur_srl_no_js="0";
		String prev_onset_type ="";
		String prev_facility_id ="";
		String prev_encounter_id ="";
		String prev_practitioner_id ="";
		String prev_practitioner_reln_id ="";
		String prev_locn_type ="";
		String prev_locn_code ="";
		String prev_nature ="";
		String prev_priority ="";
		String prev_accuracy_code ="";
		String prev_accuracy_ind ="";
		String prev_remarks ="";
		String prev_diag_class_code ="";
		String prev_recorded_from_death_reg_yn ="";
		String prev_severity  ="";
		//End
		
		//Added by Jeyachitra - ML-MMOH-CRF 1742
		HashMap<String, String> prev_RecDiag_Data = new HashMap<String, String>();
		HashMap<String, String> curr_RecDiag_Data = new HashMap<String, String>();

		try{
		/*
			FYI: 
				1.IF  Recording a Diagnosis from MDR function, coloumn RECORDED_FROM_DEATH_REG_YN is inserted as 'Y' in all respective tables
				PR_DIAGNOSIS,PR_DIAGNOSIS_ENC_DTL,PR_DIAGNOSIS_DETAIL,PR_DIAGNOSIS_ENC_ERR_LOG,PR_DIAGNOSIS_EVIDENCE 
				ADD,PR_DIAGNOSIS_STATUS ADD,PR_DIFFERENTIAL_DIAGNOSIS ADD,PR_SUPPORT_DIAGNOSIS ADD.
				ELSE the coloumn RECORDED_FROM_DEATH_REG_YN is inserted as 'N' in all above mentioned Tables.
				2. for that the below logic works 
		*/
			if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
				recorded_from_death_reg_yn="Y";
			}else{
				recorded_from_death_reg_yn="N";
			}
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			pstmt = null;
			
			//Added by Jeyachitra - ML-MMOH-CRF 1742
			isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");			
			
			if(isDeceasedDiagClassDeathRegAppl){
				getOldDataAuditTrial(Patient_Id,code_set,diagprob_code, occur_srl_no_hid, x_facility_id,Encounter_Id, prev_RecDiag_Data,aud_complaint_desc);//Added by Jeyachitra - ML-MMOH-CRF 1742
			}
			
			//Maheshwaran K added to get the previous encounter related details
			//Start
			if(status.equals("E"))
				{
				try
					{
					pstmt = con.prepareStatement("select onset_type,facility_id,encounter_id,practitioner_id,practitioner_reln_id,locn_type,locn_code,nature,priority,severity,accuracy_code,accuracy_ind,remarks,diag_class_code,recorded_from_death_reg_yn from (select onset_type,facility_id,encounter_id,practitioner_id,practitioner_reln_id,locn_type,locn_code,nature,priority,severity,accuracy_code,accuracy_ind,remarks,diag_class_code,recorded_from_death_reg_yn from pr_diagnosis_enc_dtl where patient_id =? and term_set_id = ? and term_code=? and  OCCUR_SRL_NO = ? and encounter_id != ?  and status='A' order by RECORDED_DATE_TIME desc) where rownum <=1");
					pstmt.setString( 1, Patient_Id) ;
					pstmt.setString( 2, code_set) ;
					pstmt.setString( 3, diagprob_code) ;
					pstmt.setString( 4, occur_srl_no_hid) ;
					pstmt.setString( 5, Encounter_Id) ;
					rs = pstmt.executeQuery();
					if(rs.next())
						{
						prev_onset_type=rs.getString("onset_type");
						prev_facility_id=rs.getString("facility_id");
						prev_encounter_id=rs.getString("encounter_id");
						prev_practitioner_id=rs.getString("practitioner_id");
						prev_practitioner_reln_id=rs.getString("practitioner_reln_id");
						prev_locn_type=rs.getString("locn_type");
						prev_locn_code=rs.getString("locn_code");
						prev_nature=rs.getString("nature");
						prev_priority=rs.getString("priority");
						prev_severity=rs.getString("severity");
						prev_accuracy_code=rs.getString("accuracy_code");
						prev_accuracy_ind=rs.getString("accuracy_ind");
						prev_remarks=rs.getString("remarks");
						prev_diag_class_code=rs.getString("diag_class_code");
						prev_recorded_from_death_reg_yn=rs.getString("recorded_from_death_reg_yn");
						}
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
					}
				catch(Exception e) 
					{
					e.printStackTrace();
					}	
				}
				try {
					//Start Maheshwaran added for MMS-DM-CRF -197.1
					if(restrict_sec_diag_yn.equals("Y") && !mode.equals("modify") && !mode.equals("modify_curr_desc")) {
					int cnt=0;
					sbSql.setLength(0);
					sbSql.append("select mr_validate_primary_diag(?,?,?,?,?,?) as cnt from dual");
					pstmt = con.prepareStatement( sbSql.toString() ) ;	
						pstmt.setString( 1, Patient_Id) ;
						pstmt.setString( 2, Encounter_Id) ;	
						pstmt.setString( 3, code_set) ;
						pstmt.setString( 4,diagprob_code) ;	
						pstmt.setString( 5,diag_class_code) ;		
						pstmt.setString( 6,x_facility_id) ;	
						rs = pstmt.executeQuery() ;
						if(rs.next())
						{
							cnt = rs.getInt("cnt");
						System.err.println("cnt in Y==="+cnt);
							if(cnt==0)
								{
								result = false ;
								final java.util.Hashtable message = MessageManager.getMessage( locale, "PRIMARY_DIAG_NOT_RECORDED","MR" ) ;
								sbMsg.append((String) message.get("message"));
								results.put("message",(String) message.get("message"));
								if ( message != null ) message.clear();								
								}
							
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();



				if(result==false)
				{
					results.put( "status", new Boolean(result) );
					results.put( "error", sbMsg.toString() );
					return results;

						}
					}	
				}
			catch(Exception e) 
					{
						System.err.println("Exception occurred  in mr_validate_primary_diag : "+e);
					e.printStackTrace();
					}				
			//Ends Maheshwaran added for MMS-DM-CRF -197.1			
			/*try
				{
					pstmt = con.prepareStatement("select diag_enc_level from mr_parameter");
					rs = pstmt.executeQuery();
					if(rs.next())
					{
					diag_enc_level_yn=rs.getString("diag_enc_level");
					}
					if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					
				}*/
			//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			//Start
			if(curr_encr_flag.equals("Y")&&(diag_enc_level_yn.equals("Y"))&&(mode.equals("modify"))&&(status.equals("R")))
				{
				mode="modify";
				}	
			if(curr_encr_flag.equals("Y")&&(diag_enc_level_yn.equals("Y"))&&(mode.equals("modify"))&&(!status.equals("R")))
				{
				mode="modify_curr_desc";
				}	
			//End	
			if(mode.equals("modify_curr_enc"))
			status = "A";
			//if(sbMsg.length() > 0) sbMsg.delete(0,sbMsg.length());
			sbMsg.setLength(0);
			//Validation whether record exing or not
			//if(!mode.equals("modify") && !mode.equals("modify_curr_enc")&& !mode.equals("modify_curr_desc"))//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
			if((!mode.equals("modify")&& !mode.equals("modify_curr_enc")&&(!status.equals("E")))||(mode.equals("modify_curr_enc")&&(diag_enc_level_yn.equals("Y"))))//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			{
				//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.setLength(0);
				sbSql.append("select 1 from pr_diagnosis  where patient_id = ? ");
				sbSql.append(" and TERM_SET_ID=? and TERM_CODE=?   "); 
				sbSql.append("and CURR_STATUS ='A' ");
				sbSql.append("AND TERM_CODE NOT IN '*OTH' ");
				//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
				//Start
				if(diag_enc_level_yn.equals("Y")) {
					sbSql.append("AND CURR_ENCOUNTER_ID = ? ");	
				}
				//end
				pstmt = con.prepareStatement( sbSql.toString() ) ;
				pstmt.setString( 1, Patient_Id) ;
				pstmt.setString( 2, code_set) ;
				pstmt.setString( 3, diagprob_code) ;
				//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
				//Start
				if(diag_enc_level_yn.equals("Y")) {
					pstmt.setString( 4, Encounter_Id) ;	
				}
				//End
				rs = pstmt.executeQuery() ;
				if(rs.next())
				{
					result = false ;
					final java.util.Hashtable message = MessageManager.getMessage( locale, "CODE_ALREADY_EXISTS","Common" ) ;
					sbMsg.append((String) message.get("message"));
					if ( message != null ) message.clear();
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}

			if(result)
			{
				//Select max srl_no for each Diagnosis from pr_diagnosis table in Insert mode only
				//if(!mode.equals("modify") && !mode.equals("modify_curr_enc"))
				if(!mode.equals("modify")  && result)//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
				{

					//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.setLength(0);
					sbSql.append("select nvl(max(OCCUR_SRL_NO),0)+1 srl_no from pr_diagnosis ");
					sbSql.append("where patient_id = ? and term_set_id=? and term_code=? ") ;
					pstmt = con.prepareStatement( sbSql.toString()) ;
					pstmt.setString( 1, Patient_Id) ;
					pstmt.setString( 2, code_set) ;
					pstmt.setString( 3, diagprob_code) ;
					rs = pstmt.executeQuery() ;
					rs.next();
					occur_srl_no = rs.getString("srl_no");
					pstmt.close();
					rs.close();
					srl_no=Integer.parseInt(occur_srl_no);
				}

				if((mode.equals("modify"))||mode.equals("modify_curr_desc"))//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
				{
					
					//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.setLength(0);
					sbSql.append("select nvl(diff_group_id,'0') diff_group_id  from  PR_DIFFERENTIAL_DIAGNOSIS ");
					sbSql.append(" where PATIENT_ID=? and TERM_SET_ID=? and TERM_CODE = ? and OCCUR_SRL_NO=?");
					pstmt = con.prepareStatement( sbSql.toString() ) ;
					pstmt.setString( 1, Patient_Id) ;
					pstmt.setString( 2, code_set) ;
					pstmt.setString( 3, diagprob_code) ;
					pstmt.setString(4, occur_srl_no_hid) ;
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						diff_group_id_hid = rs.getString("diff_group_id");
						if(diff_group_id_hid == null) diff_group_id_hid="0";
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					
				}
			}

			
			/////////////////// MODIFY MODE 
			//if(mode.equals("modify") || mode.equals("modify_curr_enc")&& result)
			if(((mode.equals("modify") ||  mode.equals("modify_curr_enc") || mode.equals("modify_curr_desc")) && result && (diag_enc_level_yn.equals("N")))||((mode.equals("modify") || mode.equals("modify_curr_desc"))&&(!status.equals("A")) &&(diag_enc_level_yn.equals("Y")) && result)||((mode.equals("modify") &&(status.equals("A")) &&(diag_enc_level_yn.equals("Y")) && !curr_encr_flag.equals("Y") && result)))//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
			{


				//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.setLength(0);
				sbSql.append("select nvl(max(srl_no),0)+1 srl_no from pr_diagnosis_status ");
				sbSql.append(" where patient_id=? and term_set_id=? and term_code=? and OCCUR_SRL_NO=?"); 
				//commented for MMS-JU-SCF-0213
				//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
				//Start
			/*	if(diag_enc_level_yn.equals("Y")) {
				sbSql.append("AND ENCOUNTER_ID = ? ");	
				}*/
				//end
				pstmt = con.prepareStatement( sbSql.toString() ) ;
				pstmt.setString( 1, Patient_Id) ;
				pstmt.setString( 2, code_set) ;
				pstmt.setString( 3, diagprob_code) ;
				pstmt.setString( 4, occur_srl_no_hid) ;
				//commented for MMS-JU-SCF-0213
				//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
				//Start
			/*	if(diag_enc_level_yn.equals("Y")) {
					pstmt.setString( 5, Encounter_Id) ;	
				}*/
				//End
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					srl_no = rs.getInt("srl_no");
				}
				occur_srl_no = occur_srl_no_hid;
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				//Update record into pr_diagnosis table
				//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.setLength(0);

				sbSql.append(" update pr_diagnosis set ");
				if(!mode.equals("modify_curr_enc"))
				{
					sbSql.append("diag_class_code=?,");
					sbSql.append("curr_severity=?, curr_onset_type=?,");
				}
				sbSql.append("curr_facility_id=?,curr_encounter_id=?,");
				sbSql.append("curr_practitioner_id=?,curr_practitioner_reln_id=?,");
				sbSql.append("curr_locn_type=?,curr_locn_code=?,");
				sbSql.append("accession_num_work_related= ?,ACCESSION_NUM_NOTIFIABLE= ? ,");
				if(!mode.equals("modify_curr_enc"))
				{
					sbSql.append("curr_nature=?,curr_priority=?,curr_accuracy_code=?,poa_indicator='"+poa_indicator+"',");
					sbSql.append("curr_accuracy_ind=?,curr_remarks=?,");
					//sbSql.append("curr_status_date=to_date('"+status_date+"','dd/mm/yyyy'),");  // commented and added below line for PE
					sbSql.append("curr_status_date=to_date(?,'dd/mm/yyyy'),");
					
					if(isMultiDescAppl.equals("true") && code_set.equals("ICD10") && !term_oth_desc.equals(""))
					{  // Added by mujafar for ML-MMOH-CRF-1281 US3
					
					String diag_Description_temp = diag_Description.replaceAll("'","''");
					sbSql.append("TERM_CODE_SHORT_DESC='"+diag_Description_temp+"',");
					}
					
					
					
					if(status.equals("E"))	{					
						 if(diag_enc_level_yn.equals("Y")) {
							if(Encounter_Id.equals(onset_encounter_id)){
								sbSql.append(" curr_status=?, ");
							}
					      }	else{							  
							  sbSql.append(" curr_status=?, ");
						  }
						}
					else{
						sbSql.append(" curr_status=?, ");
						}
				}
				if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0){ // added by Bhavani Shankar


					sbSql.append("accession_num=?,"); // added by Bhavani Shankar
				} // added by Bhavani Shankar
				sbSql.append("modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,");
				sbSql.append("modified_facility_id=? , ");
				sbSql.append("anatomical_site=? , applicable_side=? ");
				sbSql.append(" where patient_id=? and term_set_id=? and term_code=? and ");
				sbSql.append("OCCUR_SRL_NO=?");  

				
				pstmt = con.prepareStatement( sbSql.toString() );
				
				String update_accession_num = "";

				if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0){
					/*
					String chart_num = "";
					String oh_chart_details = "";

					oh_chart_details = (String)OHDiagLinkConditionOBJ.getObject(0);
					if(oh_chart_details!=null && !oh_chart_details.equals("") && oh_chart_details.indexOf("||")!=-1)
					{
						StringTokenizer oh_chart_token = new StringTokenizer(oh_chart_details,"||");
						int f=0;
						while(oh_chart_token.hasMoreTokens() && f<1)
						{
							chart_num		=oh_chart_token.nextToken();
							update_accession_num  =  x_facility_id +"||" + Encounter_Id + "||" + chart_num;
							f++;
						}
					}
					*/
					update_accession_num = accession_number;
					
				}

								
				if(mode.equals("modify_curr_enc"))
				{    
					
					if(status.equals("E"))
						{	
						if(Encounter_Id.equals(onset_encounter_id))
							{
							pstmt.setString	(1,x_facility_id ) ;
							pstmt.setString(2,Encounter_Id ) ;
							pstmt.setString	(3,Practitioner_Id ) ;
							pstmt.setString	(4,relationship_id ) ;
							pstmt.setString	(5,Locn_Type ) ;
							pstmt.setString	(6,Locn_Code ) ;
							pstmt.setString	(7,accession_num_work_related ) ; // 24.2
							pstmt.setString	(8,accession_num_notifiable ) ; // 24.2
							}
						else
							{
							pstmt.setString	(1,prev_facility_id  ) ;
							pstmt.setString(2,prev_encounter_id ) ;
							pstmt.setString	(3,prev_practitioner_id ) ;
							pstmt.setString	(4,prev_practitioner_reln_id ) ;
							pstmt.setString	(5,prev_locn_type ) ;
							pstmt.setString	(6,prev_locn_code ) ;
							pstmt.setString	(7,accession_num_work_related ) ; // 24.2
							pstmt.setString	(8,accession_num_notifiable ) ; // 24.2
							}
						}
					else 
						{
						pstmt.setString	(1,x_facility_id ) ;
						pstmt.setString(2,Encounter_Id ) ;
						pstmt.setString	(3,Practitioner_Id ) ;
						pstmt.setString	(4,relationship_id ) ;
						pstmt.setString	(5,Locn_Type ) ;
						pstmt.setString	(6,Locn_Code ) ;
						pstmt.setString	(7,accession_num_work_related ) ; // 24.2
						pstmt.setString	(8,accession_num_notifiable ) ; // 24.2
						}
					//pstmt.setString(2,Encounter_Id ) ;
					//pstmt.setString	(3,Practitioner_Id ) ;
					//pstmt.setString	(4,relationship_id ) ;
					//pstmt.setString	(5,Locn_Type ) ;
					//pstmt.setString	(6,Locn_Code ) ;
					/*
					// Commented and modified as below by Bhavani Shankar
					// if condition has accession_num updation code
					//else condition should not have accession_num updation.
						pstmt.setString (7,modifiedById);
						pstmt.setString (8,modifiedAtWorkstation);
						pstmt.setString (9,x_facility_id);
						pstmt.setString (10,anatomical_site);
						pstmt.setString (11,applicable_side);
						pstmt.setString (12,Patient_Id);
						pstmt.setString (13,code_set);
						pstmt.setString (14,diagprob_code);
						pstmt.setString (15,occur_srl_no_hid);
					*/
					if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0){
                        
						pstmt.setString	(9,update_accession_num);
						pstmt.setString (10,modifiedById);
						pstmt.setString (11,modifiedAtWorkstation);
						pstmt.setString (12,x_facility_id);
						pstmt.setString (13,anatomical_site);
						pstmt.setString (14,applicable_side);
						pstmt.setString (15,Patient_Id);
						pstmt.setString (16,code_set);
						pstmt.setString (17,diagprob_code);
						pstmt.setString (18,occur_srl_no_hid);
						
					}else{
                       
						pstmt.setString (9,modifiedById);
						pstmt.setString (10,modifiedAtWorkstation);
						pstmt.setString (11,x_facility_id);
						pstmt.setString (12,anatomical_site);
						pstmt.setString (13,applicable_side);
						pstmt.setString (14,Patient_Id);
						pstmt.setString (15,code_set);
						pstmt.setString (16,diagprob_code);
						pstmt.setString (17,occur_srl_no_hid);
					}
				}
				else
				{
                    
					if(status.equals("E"))
						{	
						if(Encounter_Id.equals(onset_encounter_id))
							{
							pstmt.setString	(1,diag_class_code ) ;
							pstmt.setString	(2,severity ) ;
							pstmt.setString	(3,type ) ;
							pstmt.setString	(4,x_facility_id ) ;
							}
						else
							{
							pstmt.setString	(1,prev_diag_class_code ) ;
							pstmt.setString	(2,prev_severity ) ;
							pstmt.setString	(3,prev_onset_type ) ;
							pstmt.setString	(4,prev_facility_id ) ;
							}
						}
					else 
						{
						pstmt.setString	(1,diag_class_code ) ;
						pstmt.setString	(2,severity ) ;
						pstmt.setString	(3,type ) ;
						pstmt.setString	(4,x_facility_id ) ;
						}
					
			
					if(curr_encr_flag.equals("N"))
					{
						pstmt.setString	(5,null ) ;
						}
					else
						{
						if(status.equals("E"))
						{	
						if(Encounter_Id.equals(onset_encounter_id))
							{
							pstmt.setString(5,Encounter_Id ) ;
							pstmt.setString	(6,Practitioner_Id ) ;
							pstmt.setString	(7,relationship_id ) ;
							pstmt.setString	(8,Locn_Type ) ;
							pstmt.setString	(9,Locn_Code ) ;
							pstmt.setString	(10,accession_num_work_related ) ; // 24.2
							pstmt.setString	(11,accession_num_notifiable ) ; // 24.2
							pstmt.setString	(12,nature ) ;
							pstmt.setString	(13,priority ) ;
							pstmt.setString	(14,accuracy ) ;
							pstmt.setString	(15,accuracy_ind ) ;
							pstmt.setString	(16,remarks ) ;
							}
						else
							{
							pstmt.setString(5,prev_encounter_id ) ;
							pstmt.setString	(6,prev_practitioner_id  ) ;
							pstmt.setString	(7,prev_practitioner_reln_id  ) ;
							pstmt.setString	(8,prev_locn_type  ) ;
							pstmt.setString	(9,prev_locn_code  ) ;
							pstmt.setString	(10,accession_num_work_related ) ; // 24.2
							pstmt.setString	(11,accession_num_notifiable ) ; // 24.2
							pstmt.setString	(12,prev_nature  ) ;
							pstmt.setString	(13,prev_priority  ) ;
							pstmt.setString	(14,prev_accuracy_code  ) ;
							pstmt.setString	(15,prev_accuracy_ind  ) ;
							pstmt.setString	(16,prev_remarks  ) ;
							}
						}
					else 
						{
						pstmt.setString(5,Encounter_Id ) ;
						pstmt.setString	(6,Practitioner_Id ) ;
						pstmt.setString	(7,relationship_id ) ;
						pstmt.setString	(8,Locn_Type ) ;
						pstmt.setString	(9,Locn_Code ) ;
						pstmt.setString	(10,accession_num_work_related ) ; // 24.2
						pstmt.setString	(11,accession_num_notifiable ) ; // 24.2
						pstmt.setString	(12,nature ) ;
						pstmt.setString	(13,priority ) ;
						pstmt.setString	(14,accuracy ) ;
						pstmt.setString	(15,accuracy_ind ) ;
						pstmt.setString	(16,remarks ) ;
						
						}
						}
					pstmt.setString	(17,status_date);
					if(status.equals("E")){	
						 if(diag_enc_level_yn.equals("Y")) {
								if(Encounter_Id.equals(onset_encounter_id)){						
									pstmt.setString	(18,status ) ;
							    }
						 }else{							 
							 pstmt.setString	(18,status ) ;
						 }
					}else{	
						     pstmt.setString	(18,status ) ;
						}
					/*
					// Commented and modified as below by Bhavani Shankar
					// if condition has accession_num updation code
					//else condition should not have accession_num updation.
						pstmt.setString (15,modifiedById);
						pstmt.setString (16,modifiedAtWorkstation);
						pstmt.setString (17,x_facility_id);
						pstmt.setString (18,anatomical_site);
						pstmt.setString (19,applicable_side);
						pstmt.setString (20,Patient_Id);
						pstmt.setString (21,code_set);
						pstmt.setString (22,diagprob_code);
						pstmt.setString (23,occur_srl_no_hid);

					*/
					if(status.equals("E"))
						{	
						if(Encounter_Id.equals(onset_encounter_id))
							{
							if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0)
								{
								System.err.println("728,*****************");	
                        		pstmt.setString	(19,update_accession_num);
								pstmt.setString (20,modifiedById);
								pstmt.setString (21,modifiedAtWorkstation);
								pstmt.setString (22,x_facility_id);
								pstmt.setString (23,anatomical_site);
								pstmt.setString (24,applicable_side);
								pstmt.setString (25,Patient_Id);
								pstmt.setString (26,code_set);
								pstmt.setString (27,diagprob_code);
								pstmt.setString (28,occur_srl_no_hid);
								}
							else{
							System.err.println("741,*****************");	
                        		pstmt.setString (19,modifiedById);
								pstmt.setString (20,modifiedAtWorkstation);
								pstmt.setString (21,x_facility_id);
								pstmt.setString (22,anatomical_site);
								pstmt.setString (23,applicable_side);
								pstmt.setString (24,Patient_Id);
								pstmt.setString (25,code_set);
								pstmt.setString (26,diagprob_code);
								pstmt.setString (27,occur_srl_no_hid);
								}
							}
						else
							{
							if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0)
								{
								System.err.println("757,*****************");	
                        		pstmt.setString	(19,update_accession_num);
								pstmt.setString (20,modifiedById);
								pstmt.setString (21,modifiedAtWorkstation);
								pstmt.setString (22,x_facility_id);
								pstmt.setString (23,anatomical_site);
								pstmt.setString (24,applicable_side);
								pstmt.setString (25,Patient_Id);
								pstmt.setString (26,code_set);
								pstmt.setString (27,diagprob_code);
								pstmt.setString (28,occur_srl_no_hid);
								
								}
							else{
							System.err.println("771,*****************");	
							 if(diag_enc_level_yn.equals("Y")) {
                        		pstmt.setString (18,modifiedById);
								pstmt.setString (19,modifiedAtWorkstation);
								pstmt.setString (20,x_facility_id);
								pstmt.setString (21,anatomical_site);
								pstmt.setString (22,applicable_side);
								pstmt.setString (23,Patient_Id);
								pstmt.setString (24,code_set);
								pstmt.setString (25,diagprob_code);
								pstmt.setString (26,occur_srl_no_hid);
							 }else{
								pstmt.setString (19,modifiedById);
								pstmt.setString (20,modifiedAtWorkstation);
								pstmt.setString (21,x_facility_id);
								pstmt.setString (22,anatomical_site);
								pstmt.setString (23,applicable_side);
								pstmt.setString (24,Patient_Id);
								pstmt.setString (25,code_set);
								pstmt.setString (26,diagprob_code);
								pstmt.setString (27,occur_srl_no_hid);
							 }
								
								
								}
							}
						}
					else 
						{
						if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()>0)
								{
								System.err.println("790,*****************");	
                        		pstmt.setString	(19,update_accession_num);
								pstmt.setString (20,modifiedById);
								pstmt.setString (21,modifiedAtWorkstation);
								pstmt.setString (22,x_facility_id);
								pstmt.setString (23,anatomical_site);
								pstmt.setString (24,applicable_side);
								pstmt.setString (25,Patient_Id);
								pstmt.setString (26,code_set);
								pstmt.setString (27,diagprob_code);
								pstmt.setString (28,occur_srl_no_hid);
								}
							else{
							System.err.println("803,*****************");	
                        		pstmt.setString (19,modifiedById);
								pstmt.setString (20,modifiedAtWorkstation);
								pstmt.setString (21,x_facility_id);
								pstmt.setString (22,anatomical_site);
								pstmt.setString (23,applicable_side);
								pstmt.setString (24,Patient_Id);
								pstmt.setString (25,code_set);
								pstmt.setString (26,diagprob_code);
								pstmt.setString (27,occur_srl_no_hid);
								
								
								}
						}
										
				}
				count=0;

				try
				{
					try
						{
						count	= pstmt.executeUpdate();
						//Added Bru-HIMS-CRF-024.2
						if(count > 0){
						if(pstmt!=null) pstmt.close();
						if(status.equals("E")&&!accession_num_work_related.equals("")){
						pstmt = con.prepareStatement("update CA_ENCNTR_NOTE set EVENT_STATUS='9',event_status_caption = 'In Error', marked_in_error_by_id ='"+modifiedById+"', marked_in_error_date_time = SYSDATE, modified_by_id ='"+modifiedById+"', modified_date = SYSDATE, modified_at_ws_no ='"+modifiedAtWorkstation+"', modified_facility_id ='"+x_facility_id+"' where ACCESSION_NUM='"+accession_num_work_related+"'");
						count= pstmt.executeUpdate();
						System.err.println("count 794===>"+count);
						}
						// Bru-HIMS-CRF-024.2
						}
						}
					catch(Exception e)
						{
						result = false;
						System.out.println("Exception  : "+e.toString());
						}
					if(count > 0)
						result = true; 
					else 
						result = false;

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					if(result)
					{
						StringBuffer sql_up_pr_diagnosis_enc_dtl=new StringBuffer();
						int cnt=0;
						if((mode.equals("modify") || mode.equals("modify_curr_enc") || mode.equals("modify_curr_desc")) && curr_encr_flag.equals("Y")&&(status.equals("A")))//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
						{	//Maheshwaran K modified the insert query as on 17/09/2013
							sql_up_pr_diagnosis_enc_dtl.append(" insert into PR_DIAGNOSIS_ENC_DTL ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE, cause_of_death_yn, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,DIAG_CLASS_CODE,NOTIFICATION_CODE,POA_INDICATOR,SLINK_FLAG_YN,DIAG_CATG,link_diag_pri_sec_yn ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), sysdate, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,?,?,?,'"+poa_indicator+"',?,?,?) ");//Maheshwaran K modified for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013

							cnt=0;
							pstmt	= con.prepareStatement( sql_up_pr_diagnosis_enc_dtl.toString() );

							pstmt.setString (1,Patient_Id);
							pstmt.setString (2,code_set);
							pstmt.setString (3,diagprob_code);
							pstmt.setString (4,occur_srl_no);
							pstmt.setString (5,x_facility_id);
							pstmt.setString (6,Encounter_Id);
							pstmt.setString (7,severity);
							pstmt.setString (8,type);
							pstmt.setString (9,Practitioner_Id);
							pstmt.setString (10,relationship_id);
							pstmt.setString (11,Locn_Type);
							pstmt.setString (12,Locn_Code);
							pstmt.setString (13,nature);
							pstmt.setString (14,priority);
							pstmt.setString (15,accuracy);
							pstmt.setString (16,accuracy_ind);
							pstmt.setString (17,remarks);
							pstmt.setString (18,status);
							pstmt.setString (19,status_date);
							pstmt.setString (20,stage_code);
							pstmt.setString (21,cause_of_death_yn);
							pstmt.setString (22,addedById);
							pstmt.setString (23,addedAtWorkstation);
							pstmt.setString (24,x_facility_id);
							pstmt.setString (25,modifiedById);
							pstmt.setString (26,modifiedAtWorkstation);
							pstmt.setString (27,x_facility_id);
							pstmt.setString (28,diag_Description);
							pstmt.setString (29,diag_class_code);//Maheshwaran K added as on 17/09/2013
							pstmt.setString (30,notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
							pstmt.setString (31,slink_flag); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
							pstmt.setString (32,diag_catg_code); //Added by Ajay on 03-Jan-2023 for TH-KW-CRF-165.1
							pstmt.setString (33,link_diag_pri_sec_yn);//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
						}
						else
						{
							//else if((mode.equals("modify") || mode.equals("modify_curr_enc"))&& curr_encr_flag.equals("N") )|| !mode.equals("modify_curr_enc"))
							//sql_up_pr_diagnosis_enc_dtl.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= '"+severity+"', ONSET_TYPE = '"+type+"', PRACTITIONER_ID = '"+Practitioner_Id+"' , PRACTITIONER_RELN_ID = '"+relationship_id+"', LOCN_TYPE = '"+Locn_Type+"', LOCN_CODE = '"+Locn_Code+"', NATURE = '"+nature+"', PRIORITY = '"+priority+"', ACCURACY_CODE ='"+accuracy+"', ACCURACY_IND = '"+accuracy_ind+"', REMARKS = '"+remarks+"', STATUS = '"+status+"', STATUS_DATE = to_date('"+status_date+"','dd/mm/yyyy'), ENC_STAGE = '"+stage_code+"' , cause_of_death_yn = '"+cause_of_death_yn+"', MODIFIED_BY_ID = '"+modifiedById+"' , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+x_facility_id+"' where PATIENT_ID = '"+Patient_Id+"' and TERM_SET_ID = '"+code_set+"' and TERM_CODE = '"+diagprob_code+"' and  OCCUR_SRL_NO = '"+occur_srl_no+"' and FACILITY_ID = '"+x_facility_id+"' and ENCOUNTER_ID = '"+Encounter_Id+"'  ");
							//Maheshwaran K added notifiable_code for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
							//Added DIAG_CATG by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023
							sql_up_pr_diagnosis_enc_dtl.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= ?, ONSET_TYPE = ?, PRACTITIONER_ID = ? , PRACTITIONER_RELN_ID = ?, LOCN_TYPE =?, LOCN_CODE = ?, NATURE = ?, PRIORITY = ?, ACCURACY_CODE =?, ACCURACY_IND = ?, REMARKS = ?, STATUS = ?, STATUS_DATE = to_date(?,'dd/mm/yyyy'), ENC_STAGE = ? , cause_of_death_yn = ?, MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,DIAG_CLASS_CODE =? ,NOTIFICATION_CODE = ?,poa_indicator='"+poa_indicator+"',DIAG_CATG = ?,link_diag_pri_sec_yn = ? where PATIENT_ID = ? and TERM_SET_ID = ? and TERM_CODE = ? and  OCCUR_SRL_NO = ? and FACILITY_ID = ? "); 
							sql_up_pr_diagnosis_enc_dtl.append( " and ENCOUNTER_ID = ? ");
							cnt=0;
							pstmt	= con.prepareStatement( sql_up_pr_diagnosis_enc_dtl.toString() );
							pstmt.setString (1,severity);
							pstmt.setString (2,type);
							pstmt.setString (3,Practitioner_Id);
							pstmt.setString (4,relationship_id);
							pstmt.setString (5,Locn_Type);
							pstmt.setString (6,Locn_Code);
							pstmt.setString (7,nature);
							pstmt.setString (8,priority);
							pstmt.setString (9,accuracy);
							pstmt.setString (10,accuracy_ind);
							pstmt.setString (11,remarks);
							pstmt.setString (12,status);
							pstmt.setString (13,status_date);
							pstmt.setString (14,stage_code);
							pstmt.setString (15,cause_of_death_yn);
							pstmt.setString (16,modifiedById);
							pstmt.setString (17,modifiedAtWorkstation);
							pstmt.setString (18,x_facility_id);
							
							pstmt.setString (19,diag_class_code);//Maheshwaran K added as on 17/09/2013
							pstmt.setString (20,notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
							pstmt.setString (21,diag_catg_code);//Added by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023
							pstmt.setString (22,link_diag_pri_sec_yn);//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
							pstmt.setString (23,Patient_Id);
							pstmt.setString (24,code_set);
							pstmt.setString (25,diagprob_code);
							pstmt.setString (26,occur_srl_no);
							pstmt.setString (27,x_facility_id);
							pstmt.setString (28,Encounter_Id);
							//Maheshwaran K added to handle while resolving the previous encounter when enc level was "N"(patient level resolving)
							//Start	
							if((status.equals("R") || status.equals("E"))&&(diag_enc_level_yn.equals("N")))
								{
								StringBuffer sql_up_pr_diagnosis_enc_dtl1=new StringBuffer();	
								sql_up_pr_diagnosis_enc_dtl1.append(" update PR_DIAGNOSIS_ENC_DTL set STATUS = ? , REMARKS = ?, MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  where PATIENT_ID = ? and TERM_SET_ID = ? and TERM_CODE = ? and  OCCUR_SRL_NO = ? and FACILITY_ID = ?  and ENCOUNTER_ID   in (select encounter_id from pr_diagnosis_enc_dtl where patient_id= ?  and term_set_id= ? and term_code= ? and status='A' ) " );
								pstmt3	= con.prepareStatement( sql_up_pr_diagnosis_enc_dtl1.toString() );
								pstmt3.setString (1,status);
								pstmt3.setString (2,remarks);
								pstmt3.setString (3,modifiedById);
								pstmt3.setString (4,modifiedAtWorkstation);
								pstmt3.setString (5,x_facility_id);
								pstmt3.setString (6,Patient_Id);
								pstmt3.setString (7,code_set);
								pstmt3.setString (8,diagprob_code);
								pstmt3.setString (9,occur_srl_no);
								pstmt3.setString (10,x_facility_id);
								pstmt3.setString (11,Patient_Id);
								pstmt3.setString (12,code_set);
								pstmt3.setString (13,diagprob_code);
								}
								//End	
							
							}
						

						//sql_up_pr_diagnosis_enc_dtl.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= '"+severity+"', ONSET_TYPE = '"+type+"', PRACTITIONER_ID = '"+Practitioner_Id+"' , PRACTITIONER_RELN_ID = '"+relationship_id+"', LOCN_TYPE = '"+Locn_Type+"', LOCN_CODE = '"+Locn_Code+"', NATURE = '"+nature+"', PRIORITY = '"+priority+"', ACCURACY_CODE ='"+accuracy+"', ACCURACY_IND = '"+accuracy_ind+"', REMARKS = '"+remarks+"', STATUS = '"+status+"', STATUS_DATE = to_date('"+status_date+"','dd/mm/yyyy'), RECORDED_DATE_TIME = sysdate , ENC_STAGE = '"+stage_code+"' , cause_of_death_yn = '"+cause_of_death_yn+"', ADDED_BY_ID = '"+addedById+"', ADDED_DATE = sysdate, ADDED_AT_WS_NO = '"+addedAtWorkstation+"' , ADDED_FACILITY_ID = '"+x_facility_id+"', MODIFIED_BY_ID = '"+modifiedById+"' , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+x_facility_id+"' where PATIENT_ID = '"+Patient_Id+"' and TERM_SET_ID = '"+code_set+"' and TERM_CODE = '"+diagprob_code+"' and  OCCUR_SRL_NO = '"+occur_srl_no+"' and FACILITY_ID = '"+x_facility_id+"' and ENCOUNTER_ID = '"+Encounter_Id+"'  ");

						
						try
						{
							cnt	= pstmt.executeUpdate();
							if(cnt > 0){
								result = true; 
							}
							else 
							{
								result = false;
								sbMsg.append("update/insert of PR_DIAGNOSIS_ENC_DTL is failed");
							}

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						}
						catch (Exception e)
							{
							//Maheshwaran added to handle PR_DIAGNOSIS_ENC_DTL_PK exception 
							//Start
							if(e.toString().contains("PR_DIAGNOSIS_ENC_DTL_PK"))
								{
								StringBuffer sql_up_pr_diagnosis_enc_dtl3=new StringBuffer();	
								sql_up_pr_diagnosis_enc_dtl3.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= ?, ONSET_TYPE = ?, PRACTITIONER_ID = ? , PRACTITIONER_RELN_ID = ?, LOCN_TYPE =?, LOCN_CODE = ?, NATURE = ?, PRIORITY = ?, ACCURACY_CODE =?, ACCURACY_IND = ?, REMARKS = ?, STATUS = ?, STATUS_DATE = to_date(?,'dd/mm/yyyy'), ENC_STAGE = ? , cause_of_death_yn = ?, MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,DIAG_CLASS_CODE =? ,NOTIFICATION_CODE = ?,poa_indicator='"+poa_indicator+"' ,DIAG_CATG = ?, link_diag_pri_sec_yn = ? where PATIENT_ID = ? and TERM_SET_ID = ? and TERM_CODE = ? and  OCCUR_SRL_NO = ? and FACILITY_ID = ? "); 
								sql_up_pr_diagnosis_enc_dtl3.append( " and ENCOUNTER_ID = ? ");
								if(pstmt != null) pstmt.close();
								cnt=0;
								pstmt	= con.prepareStatement( sql_up_pr_diagnosis_enc_dtl3.toString() );
								pstmt.setString (1,severity);
								pstmt.setString (2,type);
								pstmt.setString (3,Practitioner_Id);
								pstmt.setString (4,relationship_id);
								pstmt.setString (5,Locn_Type);
								pstmt.setString (6,Locn_Code);
								pstmt.setString (7,nature);
								pstmt.setString (8,priority);
								pstmt.setString (9,accuracy);
								pstmt.setString (10,accuracy_ind);
								pstmt.setString (11,remarks);
								pstmt.setString (12,status);
								pstmt.setString (13,status_date);
								pstmt.setString (14,stage_code);
								pstmt.setString (15,cause_of_death_yn);
								pstmt.setString (16,modifiedById);
								pstmt.setString (17,modifiedAtWorkstation);
								pstmt.setString (18,x_facility_id);
								pstmt.setString (19,diag_class_code);//Maheshwaran K added as on 17/09/2013
								pstmt.setString (20,notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
								pstmt.setString (21,diag_catg_code);//Added by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023
								pstmt.setString (22,link_diag_pri_sec_yn);//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
								pstmt.setString (23,Patient_Id);
								pstmt.setString (24,code_set);
								pstmt.setString (25,diagprob_code);
								pstmt.setString (26,occur_srl_no);
								pstmt.setString (27,x_facility_id);
								pstmt.setString (28,Encounter_Id);
								try
									{
										cnt	= pstmt.executeUpdate();
										if(cnt > 0){
											result = true; 
										}
										else 
										{
											result = false;
											sbMsg.append("update/insert of PR_DIAGNOSIS_ENC_DTL1 is failed");
										}

										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									}
								catch (Exception e1)	
									{
									e1.printStackTrace();
									}
								}
							else 
								{	
								result = false;
								e.printStackTrace();
								sbMsg.append("Inside -update  PR_DIAGNOSIS_ENC_DTL --"+e.toString());
								}
							//End
							}
						//Maheshwaran K added to handle while resolving the previous encounter when enc level was "N"(patient level resolving)
						//Start						
						try
							{
							if((mode.equals("modify") || mode.equals("modify_curr_enc") || mode.equals("modify_curr_desc")) && curr_encr_flag.equals("Y")&&(status.equals("A")) )
								{}
							else
								{
								if((status.equals("R") || status.equals("E"))&&(diag_enc_level_yn.equals("N")))	
									{
									try
										{
										cnt=0;
										cnt	= pstmt3.executeUpdate();
										if(cnt > 0)
											{
											result = true; 
											}
										if(rs != null) rs.close();
										if(pstmt3 != null) pstmt3.close();
										}
									catch (Exception e)
										{
										result = false;
										e.printStackTrace();
										sbMsg.append("Inside -update  PR_DIAGNOSIS_ENC_DTL for Resolving --"+e.toString());
										}	
									}
								}
							}
						catch(Exception e)	
							{
							result = false;
							e.printStackTrace();
							sbMsg.append("Inside -update  PR_DIAGNOSIS_ENC_DTL for Resolving --"+e.toString());
							}
						//End	
						}
					if(result && accuracy_ind.equals("C") && !diff_group_id_hid.equals("0") && (mode.equals("modify") || mode.equals("modify_curr_desc")))////Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
					{
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

						sbSql.append("update PR_DIFFERENTIAL_DIAGNOSIS set FINALIZED_YN='Y' ,");
						sbSql.append("modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,  ");
						sbSql.append(" modified_facility_id=? where PATIENT_ID=? and DIFF_GROUP_ID=?"); 
						sbSql.append(" and term_set_id=? ");

						pstmt = con.prepareStatement( sbSql.toString() ) ;
						pstmt.setString (1,modifiedById);
						pstmt.setString (2,modifiedAtWorkstation);
						pstmt.setString (3,x_facility_id);
						pstmt.setString( 4, Patient_Id) ;
						pstmt.setString( 5, diff_group_id_hid) ;
						pstmt.setString( 6, code_set) ;
						count=0;
						count	= pstmt.executeUpdate();
						if(count>0)
							result = true;
						else
						{
							result= false;
							sbMsg.append("update  of PR_DIFFERENTIAL_DIAGNOSIS is failed");
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

						sbSql.append("select 1 from  PR_DIFFERENTIAL_DIAGNOSIS  where PATIENT_ID=? ");
						sbSql.append(" and DIFF_GROUP_ID=? and TERM_SET_ID=? and TERM_CODE != ? ");
						pstmt = con.prepareStatement( sbSql.toString() ) ;
						pstmt.setString( 1, Patient_Id) ;
						pstmt.setString( 2, diff_group_id_hid) ;
						pstmt.setString( 3, code_set) ;
						pstmt.setString( 4, diagprob_code) ;
						rs	= pstmt.executeQuery();
						if(rs.next())
						{
							//Update PR_DIAGNOSIS Table
							if(pstmt != null) pstmt.close();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);

							sbSql.append("update PR_DIAGNOSIS a set CURR_STATUS='X' ");
							sbSql.append(",modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? "); 
							sbSql.append(" where PATIENT_ID=? and TERM_SET_ID=? and  ");
							sbSql.append(" TERM_CODE != ? ");
							sbSql.append(" and exists  (select TERM_CODE from  PR_DIFFERENTIAL_DIAGNOSIS  where ");
							sbSql.append(" PATIENT_ID=a.patient_id ");
							sbSql.append(" and TERM_SET_ID=a.term_set_id and term_code =a.term_code and ");
							sbSql.append(" OCCUR_SRL_NO =a.OCCUR_SRL_NO and DIFF_GROUP_ID=?)");
				
							pstmt = con.prepareStatement( sbSql.toString() ) ;
							pstmt.setString (1,modifiedById);
							pstmt.setString (2,modifiedAtWorkstation);
							pstmt.setString (3,x_facility_id);
							pstmt.setString( 4, Patient_Id) ;
							pstmt.setString( 5, code_set) ;
							pstmt.setString( 6, diagprob_code) ;
							pstmt.setString( 7, diff_group_id_hid) ;
							count=0;
							count	= pstmt.executeUpdate();
							if(count>0)
								result = true;
							else
							{
								result= false;
								sbMsg.append("update  of PR_DIAGNOSIS is failed after PR_DIFFERENTIAL_DIAGNOSIS.");
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
				
							// insert value into pr_diagnosis_status table for all updated members--->>on 2/14/2005
							/*condition to be checked for revoked for free text diagnosis in pr_diagnosis_status*/
							if(result)
							{
								//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.setLength(0);

								sbSql.append("insert into pr_diagnosis_status (patient_id,term_set_id,"); sbSql.append("term_code,srl_no,severity,onset_type,");
								sbSql.append("facility_id,encounter_id,practitioner_id,");
								sbSql.append("practitioner_reln_id,locn_type,locn_code,nature,priority,");
								sbSql.append("accuracy_code,accuracy_ind,remarks,status,status_date,");
								sbSql.append("added_by_id,added_date,added_at_ws_no,added_facility_id,");
								sbSql.append("modified_by_id,modified_date,modified_at_ws_no");
								sbSql.append(",modified_facility_id,OCCUR_SRL_NO,RECORDED_FROM_DEATH_REG_YN) values");
								sbSql.append("  ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?, ?, ?,"); 
								sbSql.append(" ?,?,");
								sbSql.append("to_date(?,'dd/mm/yyyy hh24:MI'),?,");
								sbSql.append(" sysdate,?,?,?,sysdate,?,?,?,?)");
								
								pstmt = con.prepareStatement( sbSql.toString() );

								//Fetching exiting record for the corresponding udating Diagnosis ..
								//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.setLength(0);

								sbSql.append("select TERM_CODE, TERM_SET_ID,occur_srl_no from  PR_DIFFERENTIAL_DIAGNOSIS  where PATIENT_ID=? ");
								sbSql.append(" and DIFF_GROUP_ID=? and TERM_SET_ID=? and TERM_CODE != ? ");
								pstmt1 = con.prepareStatement( sbSql.toString() ) ;

								pstmt1.setString( 1, Patient_Id) ;
								pstmt1.setString( 2, diff_group_id_hid) ;
								pstmt1.setString( 3, code_set) ;
								pstmt1.setString( 4, diagprob_code) ;
								rs	= pstmt1.executeQuery();
								while(rs.next())
								{
									temp_code_set="";
									temp_diagprob_code="";
									temp_code_set=checkForNull(rs.getString("TERM_SET_ID"));
									temp_diagprob_code=checkForNull(rs.getString("TERM_CODE"));
									temp_occur_srl_no=checkForNull(rs.getString("occur_srl_no"));

									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append(" select a.curr_severity, ");
									sbSql.append("a.curr_onset_type,a.curr_facility_id,"); 
									sbSql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sbSql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
									sbSql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); 
									sbSql.append("to_char(a.curr_status_date,'dd/mm/yyyy') status_date, ");
									sbSql.append("(select nvl(max(srl_no),0)+1 srl_no from pr_diagnosis_status c where ");
									sbSql.append("c.PATIENT_ID=a.patient_id and c.TERM_SET_ID=a.TERM_SET_ID and c.TERM_CODE=a.TERM_CODE and c.OCCUR_SRL_NO=a.OCCUR_SRL_NO) srl_no ");
									sbSql.append(" from pr_diagnosis a, mr_term_code b");
									sbSql.append(" where a.term_code=b.term_code and a.term_set_id=b.term_set_id and "); 
									sbSql.append(" a.curr_status='X' and ");
									sbSql.append(" a.patient_id=? and a.term_set_id=? and a.term_code=? ");
									sbSql.append(" and a.OCCUR_SRL_NO=?");

									pstmt2 = con.prepareStatement( sbSql.toString() ) ;
									pstmt2.setString( 1, Patient_Id) ;
									pstmt2.setString( 2, temp_code_set) ;
									pstmt2.setString( 3, temp_diagprob_code) ;
									pstmt2.setString( 4, temp_occur_srl_no) ;
									if(rs2 != null) rs2.close();
									rs2	= pstmt2.executeQuery();
									if(rs2.next())
									{
										temp_severity			=checkForNull(rs2.getString("curr_severity"));
										temp_type				=checkForNull(rs2.getString("curr_onset_type"));
										temp_Practitioner_Id	=checkForNull(rs2.getString("curr_practitioner_id"));
										temp_relationship_id	= checkForNull(rs2.getString("curr_practitioner_reln_id"));
										temp_Locn_Type			=checkForNull(rs2.getString("curr_locn_type"));
										temp_Locn_Code			=checkForNull(rs2.getString("curr_locn_code"));
										temp_nature				=checkForNull(rs2.getString("curr_nature"));
										temp_priority			=checkForNull(rs2.getString("curr_priority"));
										temp_accuracy			=checkForNull(rs2.getString("curr_accuracy_code"));
										temp_accuracy_ind		=checkForNull(rs2.getString("curr_accuracy_ind"));
										temp_remarks			=checkForNull(rs2.getString("curr_remarks"));
										temp_status				=checkForNull(rs2.getString("curr_status"));
										temp_status_date		=checkForNull(rs2.getString("status_date"));
										temp_srl_no				=checkForNull(rs2.getString("srl_no"));
									}

									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();

									pstmt.clearParameters();
									pstmt.setString	(1,  Patient_Id ) ;
									pstmt.setString	(2,  temp_code_set) ;
									pstmt.setString	(3,  temp_diagprob_code ) ;
									pstmt.setString	(4,  temp_srl_no ) ;
									pstmt.setString	(5,  temp_severity ) ;
									pstmt.setString	(6,  temp_type ) ;
									pstmt.setString	(7,  x_facility_id ) ;

									if(curr_encr_flag.equals("N")){
										pstmt.setString	(8,  null ) ;
									}else{
										pstmt.setString	(8,  Encounter_Id ) ;
									}

									pstmt.setString	(9,  temp_Practitioner_Id ) ;
									pstmt.setString	(10, temp_relationship_id ) ;
									pstmt.setString	(11, temp_Locn_Type ) ;
									pstmt.setString	(12, temp_Locn_Code ) ;
									pstmt.setString	(13, temp_nature ) ;
									pstmt.setString	(14, temp_priority ) ;
									pstmt.setString	(15, temp_accuracy ) ;
									pstmt.setString	(16, temp_accuracy_ind ) ;
									pstmt.setString	(17, temp_remarks ) ;
									pstmt.setString	(18, temp_status ) ;
									pstmt.setString	(19, temp_status_date ) ;
									pstmt.setString (20,addedById);
									pstmt.setString (21,addedAtWorkstation);
									pstmt.setString (22,x_facility_id);
									pstmt.setString (23,modifiedById);
									pstmt.setString (24,modifiedAtWorkstation);
									pstmt.setString (25,x_facility_id);
									pstmt.setString (26,temp_occur_srl_no);
									pstmt.setString (27,recorded_from_death_reg_yn);// Added on 9/15/2009 For MDR.
									count=0;
									count	= pstmt.executeUpdate();
								}// eo while
							
							
								if(count>0)
									result = true; 
								else 
								{
									result = false;
									sbMsg.append("selection from pr_diagnosis is failed.");
									
								}
							}
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(pstmt1 != null) pstmt1.close();

					}
					else if(result && accuracy_ind.equals("U") && !diff_group_id_hid.equals("0") && (mode.equals("modify") || mode.equals("modify_curr_desc")) && status.equals("E") )//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
					{
						/*
						*	If status is InError - Modify mode
						*/
						if(result)
						{
							if(result)
							{
								/*
								*	FETCHING MAX SRL NO
								*/
								//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.setLength(0);

								sbSql.append(" select nvl(max(ERR_SRL_NO),0)+1 ERR_SRL_NO from PR_DIAGNOSIS_ENC_ERR_LOG ");
								sbSql.append(" where patient_id = ? and term_set_id = ? and term_code = ? and occur_srl_no = ? and facility_id = ?  and encounter_id = ?  ") ;

								pstmt = con.prepareStatement( sbSql.toString()) ;
								pstmt.setString( 1, Patient_Id) ;
								pstmt.setString( 2, code_set) ;
								pstmt.setString( 3, diagprob_code) ;
								pstmt.setString( 4, occur_srl_no) ;
								pstmt.setString( 5, x_facility_id) ;
								pstmt.setString( 6, Encounter_Id) ;
								rs = pstmt.executeQuery() ;
								rs.next();
								err_srl_no = rs.getString("ERR_SRL_NO");

								pstmt.close();
								rs.close();
								err_no = Integer.parseInt(err_srl_no);
							}
							if(result)
							{
								//Fetching exiting record for the corresponding udating Diagnosis ..
								//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.setLength(0);

								//sbSql.append(" select term_code, term_set_id, occur_srl_no from PR_DIFFERENTIAL_DIAGNOSIS where patient_id = '"+Patient_Id+"' and diff_group_id = '"+diff_group_id_hid+"' and term_set_id = '"+code_set+"' and term_code != '"+diagprob_code+"' ");

								sbSql.append(" select term_code, term_set_id, occur_srl_no from PR_DIFFERENTIAL_DIAGNOSIS where patient_id = ? and diff_group_id = ? and term_set_id = ? and term_code != ? ");

								pstmt1 = con.prepareStatement( sbSql.toString() ) ;
								pstmt1.setString( 1, Patient_Id) ;
								pstmt1.setString( 2, diff_group_id_hid) ;
								pstmt1.setString( 3, code_set) ;
								pstmt1.setString( 4, diagprob_code) ;

								rs	= pstmt1.executeQuery();
								
								while(rs.next())
								{

									temp_code_set="";
									temp_diagprob_code="";
									temp_code_set=checkForNull(rs.getString("TERM_SET_ID"));
									temp_diagprob_code=checkForNull(rs.getString("TERM_CODE"));
									temp_occur_srl_no=checkForNull(rs.getString("occur_srl_no"));

									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append(" select a.curr_severity, ");
									sbSql.append(" a.curr_onset_type, a.curr_facility_id,"); 
									sbSql.append(" a.curr_encounter_id, a.curr_practitioner_id, a.curr_practitioner_reln_id,"); 
									sbSql.append(" a.curr_locn_type, a.curr_locn_code, a.curr_nature, a.curr_priority,");
									sbSql.append(" a.curr_accuracy_code, a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); 
									sbSql.append(" to_char(a.curr_status_date,'dd/mm/yyyy') status_date, ");
									sbSql.append("( select nvl(max(srl_no),0)+1 srl_no from pr_diagnosis_status c where c.patient_id = a.patient_id and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.occur_srl_no = a.occur_srl_no ) srl_no ");
									sbSql.append(" from PR_DIAGNOSIS a, MR_TERM_CODE b");
									//sbSql.append(" where a.term_code = b.term_code and a.term_set_id = b.term_set_id and a.curr_status = 'A' and a.patient_id = '"+Patient_Id+"' and a.term_set_id = '"+temp_code_set+"' and a.term_code = '"+temp_diagprob_code+"' and a.occur_srl_no = '"+temp_occur_srl_no+"' ");
									sbSql.append(" where a.term_code = b.term_code and a.term_set_id = b.term_set_id and a.curr_status = 'A' and a.patient_id = ? and a.term_set_id = ? and a.term_code = ? and a.occur_srl_no = ? ");

									

									
									pstmt2 = con.prepareStatement( sbSql.toString() ) ;

									pstmt2.setString( 1, Patient_Id) ;
									pstmt2.setString( 2, temp_code_set) ;
									pstmt2.setString( 3, temp_diagprob_code) ;
									pstmt2.setString( 4, temp_occur_srl_no) ;
									//if(rs != null) rs.close();
									rs2	= pstmt2.executeQuery();

									if(rs2.next())
									{
										temp_severity			=checkForNull(rs2.getString("curr_severity"));
										temp_type				=checkForNull(rs2.getString("curr_onset_type"));
										temp_Practitioner_Id	=checkForNull(rs2.getString("curr_practitioner_id"));
										temp_relationship_id	= checkForNull(rs2.getString("curr_practitioner_reln_id"));
										temp_Locn_Type			=checkForNull(rs2.getString("curr_locn_type"));
										temp_Locn_Code			=checkForNull(rs2.getString("curr_locn_code"));
										temp_nature				=checkForNull(rs2.getString("curr_nature"));
										temp_priority			=checkForNull(rs2.getString("curr_priority"));
										temp_accuracy			=checkForNull(rs2.getString("curr_accuracy_code"));
										temp_accuracy_ind		=checkForNull(rs2.getString("curr_accuracy_ind"));
										temp_remarks			=checkForNull(rs2.getString("curr_remarks"));
										temp_status				=checkForNull(rs2.getString("curr_status"));
										temp_status_date		=checkForNull(rs2.getString("status_date"));
										temp_srl_no				=checkForNull(rs2.getString("srl_no"));
									}
									if(pstmt2 != null) pstmt2.close();
									if(rs2 != null) rs2.close();
									
/*									
*	insert into PR_DIAGNOSIS_ENC_ERR_LOG
*/
									if(temp_type.equals(""))
										temp_type = old_onset_type;
										//old_onset_type - old form value

									//errLog.append(" insert into PR_DIAGNOSIS_ENC_ERR_LOG ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, ERR_SRL_NO, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE, cause_of_death_yn, ERROR_MARKED_DATE, ERROR_MARKED_BY_ID, ERROR_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN) values ( '"+Patient_Id+"', '"+temp_code_set+"', '"+temp_diagprob_code+"', '"+temp_occur_srl_no+"', '"+x_facility_id+"', '"+Encounter_Id+"', '"+err_no+"', '"+temp_severity+"', '"+temp_type+"', '"+temp_Practitioner_Id+"', '"+temp_relationship_id+"', '"+temp_Locn_Type+"', '"+temp_Locn_Code+"', '"+temp_nature+"', '"+temp_priority+"', '"+temp_accuracy+"', '"+temp_accuracy_ind+"', '"+temp_remarks+"', '"+temp_status+"', to_date('"+temp_status_date+"','dd/mm/yyyy'), sysdate, '"+stage_code+"', '"+cause_of_death_yn+"', sysdate, '"+addedById+"', '"+remarks+"', '"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+x_facility_id+"', '"+modifiedById+"', sysdate, '"+modifiedAtWorkstation+"', '"+x_facility_id+"',?, ?) "); 			
									errLog.append(" insert into PR_DIAGNOSIS_ENC_ERR_LOG ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, ERR_SRL_NO, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE, cause_of_death_yn, ERROR_MARKED_DATE, ERROR_MARKED_BY_ID, ERROR_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), sysdate, ?, ?, sysdate,?,?, ?, sysdate, ?,?, ?, sysdate, ?, ?,?, ?) "); 
									
									if(logPstmt != null) logPstmt.close();
									logPstmt = con.prepareStatement( errLog.toString());
									errLog.setLength(0);

									logPstmt.setString( 1, Patient_Id) ;
									logPstmt.setString( 2, temp_code_set);
									logPstmt.setString( 3, temp_diagprob_code);
									logPstmt.setString( 4, temp_occur_srl_no);
									logPstmt.setString( 5, x_facility_id);
									logPstmt.setString( 6, Encounter_Id);
									logPstmt.setInt( 7, err_no);
									logPstmt.setString( 8, temp_severity);
									logPstmt.setString( 9, temp_type);
									logPstmt.setString( 10, temp_Practitioner_Id);
									logPstmt.setString( 11, temp_relationship_id);
									logPstmt.setString( 12, temp_Locn_Type);
									logPstmt.setString( 13, temp_Locn_Code);
									logPstmt.setString( 14, temp_nature);
									logPstmt.setString( 15, temp_priority);
									logPstmt.setString( 16, temp_accuracy);
									logPstmt.setString( 17, temp_accuracy_ind);
									logPstmt.setString( 18, temp_remarks);
									logPstmt.setString( 19, temp_status);
									logPstmt.setString( 20, temp_status_date);
									logPstmt.setString( 21, stage_code);
									logPstmt.setString( 22, cause_of_death_yn);
									logPstmt.setString( 23, addedById);
									logPstmt.setString( 24, remarks);
									logPstmt.setString( 25, addedById);
									logPstmt.setString( 26, addedAtWorkstation);
									logPstmt.setString( 27, x_facility_id);
									logPstmt.setString( 28, modifiedById);
									logPstmt.setString( 29, modifiedAtWorkstation);
									logPstmt.setString( 30, x_facility_id);
									logPstmt.setString( 31, diag_Description) ;
									logPstmt.setString( 32, recorded_from_death_reg_yn) ;// Added On 9/15/2009 For MDR.


									try
									{
										log_updated = logPstmt.executeUpdate();
										if(logPstmt != null) logPstmt.close();
									}
									catch(SQLException logSql)
									{
										logSql.printStackTrace();
										con.rollback();
										result=false;
										sbMsg.append("exception at support_updated---- "+logSql.getMessage());
									}
									if(log_updated >0)
										result=true;
									else
									{
										result=false;
										sbMsg.append("exception at insertion of PR_DIAGNOSIS_ENC_ERR_LOG---- ");
									}
								}// eo while
								if(pstmt1 != null) pstmt1.close();
								/*
								Thursday, May 07, 2009
									if(pstmt2 != null) pstmt2.close();
									if(rs2 != null) rs2.close();

									*/

								/*
								*	delete PR_DIFFERENTIAL_DIAGNOSIS PR_DIFFERENTIAL_DIAGNOSIS for free text diagnosis
								*/
								//condition to be checked for delete in 
								if(result)
								{
									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append(" delete PR_DIFFERENTIAL_DIAGNOSIS where patient_id = ? and term_code = ? and diff_group_id = ? and term_set_id = ? and occur_srl_no = ?");

									pstmt = con.prepareStatement( sbSql.toString() ) ;
									pstmt.setString(1, Patient_Id) ;
									pstmt.setString(2, diagprob_code) ;
									pstmt.setString(3, diff_group_id_hid) ;
									pstmt.setString(4, code_set) ;
									pstmt.setString(5, occur_srl_no_hid) ;
									count=0;

									count	= pstmt.executeUpdate();

									if(count>0)
										result = true;
									else
									{
										result= false;
										sbMsg.append("exception at deletion of PR_DIFFERENTIAL_DIAGNOSIS. ");
									}
									if(pstmt != null) pstmt.close();
								}
							}
						}
					}
				}catch(Exception sqle)
				{
					sqle.printStackTrace();
					sbMsg.append("test :-Exception while updating into pr_diagnosis_status tables: " + sqle.getMessage());
					sqle.printStackTrace();
					con.rollback();
					result = false;
				}
				finally{
					//11/24/2008 close the result set
					if(rs2 != null) rs2.close();
					if(rs != null) rs.close();
				}
			}

			if(result)
			{
				if(OHDiagLinkConditionOBJ!=null)
						{
							String chart_num = "";
							String chart_line_num = "";
							String condition_code = "";
							String oh_chart_details = "";
							boolean isatLeastOneLinkConditionSelected = false;
							
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);

							sbSql.append(" insert into oh_diag_cond_link (patient_id, term_set_id, term_code, occur_srl_no, chart_num, chart_line_num, condition_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?, ?, ?, ?, ?, ?, ?,?, sysdate, ?, ?, ?, sysdate, ?, ?)");

							pstmt = con.prepareStatement( sbSql.toString() );

							
							for(int i=0;i< OHDiagLinkConditionOBJ.getSize();i++)
							{
								oh_chart_details = (String)OHDiagLinkConditionOBJ.getObject(i);
								if(oh_chart_details!=null && !oh_chart_details.equals("") && oh_chart_details.indexOf("||")!=-1)
								{
									StringTokenizer oh_chart_token = new StringTokenizer(oh_chart_details,"||");
									while(oh_chart_token.hasMoreTokens())
									{
										chart_num		=oh_chart_token.nextToken();
										chart_line_num	=oh_chart_token.nextToken();
										condition_code	=oh_chart_token.nextToken();
										accession_number  =  x_facility_id +"||" + Encounter_Id + "||" + chart_num;							
									}
									
									pstmt.setString	(1,Patient_Id ) ;
									pstmt.setString	(2,code_set) ;
									pstmt.setString	(3,diagprob_code ) ;
									pstmt.setString	(4,occur_srl_no ) ;
									pstmt.setString	(5,chart_num ) ;
									pstmt.setString	(6,chart_line_num ) ;
									pstmt.setString	(7,condition_code ) ;
									pstmt.setString	(8,addedById ) ;
									pstmt.setString	(9,addedAtWorkstation ) ;
									pstmt.setString	(10,x_facility_id ) ;
									pstmt.setString	(11,modifiedById ) ;
									pstmt.setString	(12,modifiedAtWorkstation ) ;
									pstmt.setString	(13,x_facility_id ) ;
									pstmt.addBatch();
									isatLeastOneLinkConditionSelected = true;
								}
							}
							try
							{
								if(isatLeastOneLinkConditionSelected)
								{
									int result_update[] = pstmt.executeBatch();
									if(result_update!=null && result_update.length>0)
										result	= true;
									else
									{
										result	= false;
										sbMsg.append("Exception in inserting into oh_diag_cond_link table : ");
									}
								}
				
							}
							catch (Exception e)
							{
								
								e.printStackTrace();
								sbMsg.append("Exception in inserting into oh_diag_cond_link : " +e.getMessage());
								result = false;
							}
								
							
						}

						if(pstmt != null) pstmt.close();
			}
			//////////////// INSERT MODE
			if(result)
			{
				try
				{
					//if(!mode.equals("modify") && !mode.equals("modify_curr_enc"))
					if(((!mode.equals("modify"))&& !mode.equals("modify_curr_enc") && !mode.equals("modify_curr_desc"))||((mode.equals("modify_curr_enc") || mode.equals("modify_curr_desc"))&&(diag_enc_level_yn.equals("Y"))&&(status.equals("A"))))//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
					{

						
						/*if(OHDiagLinkConditionOBJ!=null)
						{
							String chart_num = "";
							String chart_line_num = "";
							String condition_code = "";
							String oh_chart_details = "";
							boolean isatLeastOneLinkConditionSelected = false;
							
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append(" insert into oh_diag_cond_link (patient_id, term_set_id, term_code, occur_srl_no, chart_num, chart_line_num, condition_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?, ?, ?, ?, ?, ?, ?,?, sysdate, ?, ?, ?, sysdate, ?, ?)");

							pstmt = con.prepareStatement( sbSql.toString() );

							
							for(int i=0;i< OHDiagLinkConditionOBJ.getSize();i++)
							{
								oh_chart_details = (String)OHDiagLinkConditionOBJ.getObject(i);
								if(oh_chart_details!=null && !oh_chart_details.equals("") && oh_chart_details.indexOf("||")!=-1)
								{
									StringTokenizer oh_chart_token = new StringTokenizer(oh_chart_details,"||");
									while(oh_chart_token.hasMoreTokens())
									{
										chart_num		=oh_chart_token.nextToken();
										chart_line_num	=oh_chart_token.nextToken();
										condition_code	=oh_chart_token.nextToken();
										accession_number  =  x_facility_id +"||" + Encounter_Id + "||" + chart_num;							
									}
									
									pstmt.setString	(1,Patient_Id ) ;
									pstmt.setString	(2,code_set) ;
									pstmt.setString	(3,diagprob_code ) ;
									pstmt.setString	(4,occur_srl_no ) ;
									pstmt.setString	(5,chart_num ) ;
									pstmt.setString	(6,chart_line_num ) ;
									pstmt.setString	(7,condition_code ) ;
									pstmt.setString	(8,addedById ) ;
									pstmt.setString	(9,addedAtWorkstation ) ;
									pstmt.setString	(10,x_facility_id ) ;
									pstmt.setString	(11,modifiedById ) ;
									pstmt.setString	(12,modifiedAtWorkstation ) ;
									pstmt.setString	(13,x_facility_id ) ;
									pstmt.addBatch();
									isatLeastOneLinkConditionSelected = true;
								}
							}
							try
							{
								if(isatLeastOneLinkConditionSelected)
								{
									int result_update[] = pstmt.executeBatch();
									if(result_update!=null && result_update.length>0)
										result	= true;
									else
									{
										result	= false;
										sbMsg.append("Exception in inserting into oh_diag_cond_link table : ");
									}
								}
				
							}
							catch (Exception e)
							{
								
								sbMsg.append("Exception in inserting into oh_diag_cond_link : " +e.getMessage());
								result = false;
							}
								
							
						}

						if(pstmt != null) pstmt.close();

						*/

						
						if(result)
						{
							if(OHDiagLinkConditionOBJ!=null && OHDiagLinkConditionOBJ.getSize()==0)
							{
								accession_number="";								
							}
							else if(OHDiagLinkConditionOBJ==null)
							{
								accession_number="";														
							}

							
							
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);

							sbSql.append(" insert into PR_DIAGNOSIS (patient_id,term_set_id,term_code,"); 
							sbSql.append(" onset_date,onset_severity,onset_type,onset_facility_id,");
							sbSql.append(" onset_encounter_id,onset_practitioner_id,onset_practitioner_reln_id,");
							sbSql.append(" onset_locn_type,onset_locn_code,onset_nature,onset_priority, ");
							sbSql.append(" onset_accuracy_code,onset_accuracy_ind,onset_remarks,");
							sbSql.append(" onset_status,onset_status_date,curr_severity,");
							sbSql.append(" curr_onset_type,curr_facility_id,curr_encounter_id,");
							sbSql.append(" curr_practitioner_id,curr_practitioner_reln_id,curr_locn_type,");
							sbSql.append(" curr_locn_code,curr_accuracy_ind,curr_remarks,curr_status,");
							sbSql.append(" curr_status_date,diff_group_id,diff_yn,added_by_id,");
							sbSql.append(" added_date,added_facility_id,added_at_ws_no,modified_by_id,");
							sbSql.append(" modified_date,modified_facility_id,modified_at_ws_no,curr_nature,");
							sbSql.append(" curr_accuracy_code,curr_priority,OCCUR_SRL_NO,code_indicator,");
							sbSql.append(" anatomical_site,applicable_side,accession_num,");
							sbSql.append(" diag_class_code,term_code_short_desc,anatomical_site_code,recorded_from_death_reg_yn,OT_PRE_OPER_DIAG_YN,accession_num_work_related,accession_num_notifiable,poa_indicator)");
							sbSql.append(" values ( ?, ?, ?, to_date(?,'dd/mm/yyyy hh24:MI'), ?, ?, ?, ?, ?,?,?,?,?,?, ?,?, ?,?, to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,");
							sbSql.append(" to_date(?,'dd/mm/yyyy'),0,'N',?,");
							sbSql.append(" sysdate,?,?,?,");
							//sbSql.append(" sysdate,?,?,?,?,?,?,?)");
							sbSql.append(" sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+poa_indicator+"')"); 

							pstmt = con.prepareStatement( sbSql.toString() );
							pstmt.setString	(1,Patient_Id ) ;
							pstmt.setString	(2,code_set) ;
							pstmt.setString	(3,diagprob_code ) ;
							pstmt.setString	(4,onset_date ) ;
							pstmt.setString	(5,severity ) ;
							pstmt.setString	(6,type ) ;
							pstmt.setString	(7,x_facility_id ) ;
							if(curr_encr_flag.equals("N"))
								pstmt.setString	(8,null ) ;	
							else
								pstmt.setString	(8,Encounter_Id ) ;
							pstmt.setString	(9,Practitioner_Id ) ;
							pstmt.setString	(10,relationship_id ) ;
							pstmt.setString	(11,Locn_Type ) ;
							pstmt.setString	(12,Locn_Code ) ;
							pstmt.setString	(13,nature ) ;
							pstmt.setString	(14,priority ) ;
							pstmt.setString	(15,accuracy ) ;
							pstmt.setString	(16,accuracy_ind ) ;
							pstmt.setString	(17,remarks ) ;
							pstmt.setString	(18,status ) ;
							pstmt.setString	(19,status_date ) ;
							pstmt.setString	(20,severity) ;
							pstmt.setString	(21,type) ;
							pstmt.setString (22,x_facility_id);
							if(curr_encr_flag.equals("N"))
								pstmt.setString	(23,null ) ;
							else
								pstmt.setString	(23,Encounter_Id ) ;
							pstmt.setString	(24,Practitioner_Id ) ;
							pstmt.setString	(25,relationship_id ) ;
							pstmt.setString	(26,Locn_Type ) ;
							pstmt.setString	(27,Locn_Code ) ;
							pstmt.setString (28,accuracy_ind);
							pstmt.setString (29,remarks);
							pstmt.setString (30,status);
							pstmt.setString (31,status_date);
							pstmt.setString (32,addedById);
							pstmt.setString (33,x_facility_id);
							pstmt.setString (34,addedAtWorkstation);
							pstmt.setString (35,modifiedById);
							pstmt.setString (36,x_facility_id);
							pstmt.setString (37,modifiedAtWorkstation);
							pstmt.setString (38,nature);
							pstmt.setString (39,accuracy);
							pstmt.setString (40,priority);
							pstmt.setString (41,occur_srl_no);
							pstmt.setString (42,code_indicator);
							pstmt.setString (43,anatomical_site);
							pstmt.setString (44,applicable_side);
							pstmt.setString (45,accession_number);
							pstmt.setString (46,diag_class_code);
							pstmt.setString (47,diag_Description);
							pstmt.setString (48,anatomical_oral_sites);
							pstmt.setString (49,recorded_from_death_reg_yn);//This Will be Inserted 'Y' Only when recording From MDR.

							pstmt.setString (50,called_from_ot); //Added for this CRF [PMG2012-CRF-0030]
							pstmt.setString (51,accession_num_work_related); //Added for this Bru-HIMS-CRF-024.2
							pstmt.setString (52,accession_num_notifiable); //Added for this CRF Bru-HIMS-CRF-024.2

							try
							{
								count	= pstmt.executeUpdate();
								if(pstmt != null) pstmt.close();

								if(count > 0)
									result = true; 
								else 
								{
									result = false;
									sbMsg.append("Exception in inserting into pr_diagnosis : ");

								}
							}
							catch(Exception sqle)
							{
								sqle.printStackTrace();
								sqle.printStackTrace();
								sbMsg.append("Exception in inserting into pr_diagnosis : " + sqle.getMessage());
								con.rollback();
								result = false;
							}
						}

						if(result)
					{
						
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);


						//sbSql.append(" insert into PR_DIAGNOSIS_ENC_DTL ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE,cause_of_death_yn,recorded_from_death_reg_yn,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC) values ( '"+Patient_Id+"', '"+code_set+"', '"+diagprob_code+"', '"+occur_srl_no+"', '"+x_facility_id+"', '"+Encounter_Id+"', '"+severity+"', '"+type+"', '"+Practitioner_Id+"', '"+relationship_id+"', '"+Locn_Type+"', '"+Locn_Code+"', '"+nature+"', '"+priority+"', '"+accuracy+"', '"+accuracy_ind+"', '"+remarks+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), sysdate, '"+stage_code+"', '"+cause_of_death_yn+"','"+recorded_from_death_reg_yn+"','"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+x_facility_id+"', '"+modifiedById+"', sysdate, '"+modifiedAtWorkstation+"', '"+x_facility_id+"', ?) ");
						//Maheshwaran K modified the query as on 17/09/2013
						sbSql.append(" insert into PR_DIAGNOSIS_ENC_DTL ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE,cause_of_death_yn,recorded_from_death_reg_yn,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,diag_class_code,NOTIFICATION_CODE,poa_indicator,SLINK_FLAG_YN,DIAG_CATG,link_diag_pri_sec_yn) values ( ?, ?, ?, ?, ?,?,?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), sysdate,?, ?,?,?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ? ,?,'"+poa_indicator+"',?,?,?) ");//Maheshwaran K modified for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//Added DIAG_CATG by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023

						pstmt = con.prepareStatement( sbSql.toString() );
						
						pstmt.setString(1, Patient_Id) ;
						pstmt.setString(2, code_set) ;
						pstmt.setString(3, diagprob_code) ;
						pstmt.setString(4, occur_srl_no) ;
						pstmt.setString(5, x_facility_id) ;
						pstmt.setString(6, Encounter_Id) ;
						pstmt.setString(7, severity) ;
						pstmt.setString(8, type) ;
						pstmt.setString(9, Practitioner_Id) ;
						pstmt.setString(10, relationship_id) ;
						pstmt.setString(11, Locn_Type) ;
						pstmt.setString(12, Locn_Code) ;
						pstmt.setString(13, nature) ;
						pstmt.setString(14, priority) ;
						pstmt.setString(15, accuracy) ;
						pstmt.setString(16, accuracy_ind) ;
						pstmt.setString(17, remarks) ;
						pstmt.setString(18, status) ;
						pstmt.setString(19, status_date) ;
						pstmt.setString(20, stage_code) ;
						pstmt.setString(21, cause_of_death_yn) ;
						pstmt.setString(22, recorded_from_death_reg_yn) ;
						pstmt.setString(23, addedById) ;
						pstmt.setString(24, addedAtWorkstation) ;
						pstmt.setString(25, x_facility_id) ;
						pstmt.setString(26, modifiedById) ;
						pstmt.setString(27, modifiedAtWorkstation) ;
						pstmt.setString(28, x_facility_id) ;
						pstmt.setString(29, diag_Description) ;
						pstmt.setString (30,diag_class_code);//Maheshwaran K added as on 17/09/2013
						pstmt.setString (31,notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						pstmt.setString (32,slink_flag); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
						pstmt.setString (33,diag_catg_code); //Added by Ajay on 03-Jan-2023 for TH-KW-CRF-165.1
						pstmt.setString (34,link_diag_pri_sec_yn); //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

						try
						{
							count	= pstmt.executeUpdate();
							if(pstmt != null) pstmt.close();
							if(count > 0)
								result = true; 
							else 
							{
								result = false;
								sbMsg.append("Exception in inserting into PR_DIAGNOSIS_ENC_DTL : ");
							}
							
						}
						catch(Exception sqlDtl)
						{
							sqlDtl.printStackTrace();

							sbMsg.append("Exception in inserting into PR_DIAGNOSIS_ENC_DTL : " + sqlDtl.getMessage());
							con.rollback();
							result = false;
						}
					}
				
				if(!high_risk_code.equals("")){
			if (result) 
			{

				try
				{
					int srlno = 0;
					String Sql = "select nvl(max(srl_no),0)+1 num from pr_high_risk_condition where patient_id = ? and high_risk_code = ?" ;
		
							pstmt = con.prepareStatement( Sql ) ;
							
							pstmt.setString( 1, Patient_Id) ;
							pstmt.setString( 2, high_risk_code) ;
							rs = pstmt.executeQuery() ;
							
							rs.next();
							srlno = rs.getInt("num");

							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							
				
				StringBuffer sql =new StringBuffer();
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" insert into 	pr_high_risk_condition(	" );	
				sql.append(" PATIENT_ID,		HIGH_RISK_CODE,");
				sql.append(" SRL_NO, ONSET_DATE, remarks,"); 	
				sql.append("ONSET_PRACTITIONER_ID, ONSET_FACILITY_ID, " );
				sql.append("ONSET_LOCN_CODE, ONSET_LOCN_TYPE, " );
				sql.append("ONSET_ENCOUNTER_ID, ONSET_RECORDED_DATE,OCCUR_SRL_NO,TERM_SET_ID,TERM_CODE, " ); 
				sql.append(" added_by_id,		added_date, " );
				sql.append(" added_facility_id, added_at_ws_no, " );
				sql.append(" modified_by_id,	 modified_date, ");
				sql.append(" modified_facility_id,	modified_at_ws_no ");
				sql.append(" ) values ( ?, ?, ?, to_date(?,'dd/mm/yyyy hh24:MI'), ?, ?, ?, ?, ?, ?,sysdate,?,?,?,?,sysdate,? ,?, ?, sysdate, ?, ? )" );

				pstmt = con.prepareStatement( sql.toString());
				pstmt.setString	( 1, Patient_Id ) ;
				pstmt.setString	( 2, high_risk_code) ;
				pstmt.setInt	( 3, srlno  ) ;
				pstmt.setString	( 4, onset_date ) ;
				pstmt.setString (5, remarks);
				pstmt.setString	( 6, Practitioner_Id ) ;			
				pstmt.setString	( 7, x_facility_id ) ;
				pstmt.setString	( 8, Locn_Code ) ;
				pstmt.setString	( 9, Locn_Type ) ;
				pstmt.setString( 10, Encounter_Id ) ; 	
				pstmt.setString( 11, occur_srl_no ) ;
				pstmt.setString( 12, code_set ) ; 
				pstmt.setString( 13, diagprob_code ) ; 
				pstmt.setString   (14,addedById);
				pstmt.setString	( 15, x_facility_id ) ;
				pstmt.setString	( 16, addedAtWorkstation ) ;
				pstmt.setString	( 17, modifiedById ) ;
				pstmt.setString	( 18, x_facility_id ) ;
				pstmt.setString	( 19, modifiedAtWorkstation ) ;
				int res = pstmt.executeUpdate() ;

				
							if(pstmt != null) pstmt.close();
							if(res > 0)
								result = true; 
							else 
							{
								result = false;
								sbMsg.append("Exception in inserting into pr_high_risk_condition : ");
							}

			
			}
			catch ( Exception e ) 
			{
				sbMsg.append( "Exception in inserting into pr_high_risk_condition"+e.getMessage()+"<br> " ) ;
				e.printStackTrace() ;
				try 
				{ con.rollback(); 
				} 
				catch (Exception ee) 
				{
					ee.printStackTrace();
				}
			}

		}
					}
				}
				else if(!mode.equals("modify") && !mode.equals("modify_curr_enc") && !mode.equals("modify_curr_desc"))//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
				{
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

					
					if(status.equals("E"))
					{
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

						sbSql.append(" delete PR_DIAGNOSIS_ENC_DTL where patient_id = ? and term_code = ? and  term_set_id = ? and occur_srl_no = ?");

						pstmt = con.prepareStatement( sbSql.toString() ) ;
						pstmt.setString(1, Patient_Id) ;
						pstmt.setString(2, diagprob_code) ;
						pstmt.setString(3, code_set) ;
						pstmt.setString(4, occur_srl_no_hid) ;
						count=0;
						count	= pstmt.executeUpdate();
						if(count>0)
							result = true;
						else
						{
							result= false;
							sbMsg.append("Exception in delete from PR_DIAGNOSIS_ENC_DTL : ");
						}
						if(pstmt != null) pstmt.close();
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

						//sbSql.append(" insert into PR_DIAGNOSIS_ENC_DTL ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE, cause_of_death_yn,recorded_from_death_reg_yn, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC) values ( '"+Patient_Id+"', '"+code_set+"', '"+diagprob_code+"', '"+occur_srl_no+"', '"+x_facility_id+"', '"+Encounter_Id+"', '"+severity+"', '"+type+"', '"+Practitioner_Id+"', '"+relationship_id+"', '"+Locn_Type+"', '"+Locn_Code+"', '"+nature+"', '"+priority+"', '"+accuracy+"', '"+accuracy_ind+"', '"+remarks+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), sysdate, '"+stage_code+"', '"+cause_of_death_yn+"', '"+recorded_from_death_reg_yn+"','"+addedById+"', sysdate, '"+addedAtWorkstation+"', '"+x_facility_id+"', '"+modifiedById+"', sysdate, '"+modifiedAtWorkstation+"', '"+x_facility_id+"', ?) ");
						//Maheshwaran K modified the query as on 17/09/2013
						sbSql.append(" insert into PR_DIAGNOSIS_ENC_DTL ( PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, FACILITY_ID, ENCOUNTER_ID, SEVERITY, ONSET_TYPE, PRACTITIONER_ID, PRACTITIONER_RELN_ID, LOCN_TYPE, LOCN_CODE, NATURE, PRIORITY, ACCURACY_CODE, ACCURACY_IND, REMARKS, STATUS, STATUS_DATE, RECORDED_DATE_TIME, ENC_STAGE, cause_of_death_yn,recorded_from_death_reg_yn, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,diag_class_code,NOTIFICATION_CODE,poa_indicator,SLINK_FLAG_YN,DIAG_CATG,link_diag_pri_sec_yn) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), sysdate, ?, ?, ?,?, sysdate, ?,?, ?, sysdate,?, ?, ?, ?,?,'"+poa_indicator+"',?,?,?) ");//Maheshwaran K modified for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						//Modified by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023
						
						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString(1,Patient_Id);
						pstmt.setString(2,code_set);
						pstmt.setString(3,diagprob_code);
						pstmt.setString(4,occur_srl_no);
						pstmt.setString(5,x_facility_id);
						pstmt.setString(6,Encounter_Id);
						pstmt.setString(7,severity);
						pstmt.setString(8,type);
						pstmt.setString(9,Practitioner_Id);
						pstmt.setString(10,relationship_id);
						pstmt.setString(11,Locn_Type);
						pstmt.setString(12,Locn_Code);
						pstmt.setString(13,nature);
						pstmt.setString(14,priority);
						pstmt.setString(15,accuracy);
						pstmt.setString(16,accuracy_ind);
						pstmt.setString(17,remarks);
						pstmt.setString(18,status);
						pstmt.setString(19,status_date);
						pstmt.setString(20,stage_code);
						pstmt.setString(21,cause_of_death_yn);
						pstmt.setString(22,recorded_from_death_reg_yn);
						pstmt.setString(23,addedById);
						pstmt.setString(24,addedAtWorkstation);
						pstmt.setString(25,x_facility_id);
						pstmt.setString(26,modifiedById);
						pstmt.setString(27,modifiedAtWorkstation);
						pstmt.setString(28,x_facility_id);
						pstmt.setString(29,diag_Description);
						pstmt.setString (30,diag_class_code);//Maheshwaran K added as on 17/09/2013
						pstmt.setString (31,notifiable_code);
						pstmt.setString (32,slink_flag); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
						pstmt.setString (33,diag_catg_code); //Added by Ajay on 03-Jan-2023 for TH-KW-CRF-165.1
						pstmt.setString (34,link_diag_pri_sec_yn); //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
					}
					else
					{
						
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.setLength(0);

						//sbSql.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= '"+severity+"', ONSET_TYPE = '"+type+"', PRACTITIONER_ID = '"+Practitioner_Id+"' , PRACTITIONER_RELN_ID = '"+relationship_id+"', LOCN_TYPE = '"+Locn_Type+"', LOCN_CODE = '"+Locn_Code+"', NATURE = '"+nature+"', PRIORITY = '"+priority+"', ACCURACY_CODE ='"+accuracy+"', ACCURACY_IND = '"+accuracy_ind+"', REMARKS = '"+remarks+"', STATUS = '"+status+"', STATUS_DATE = to_date('"+status_date+"','dd/mm/yyyy'), ENC_STAGE = '"+stage_code+"' , cause_of_death_yn = '"+cause_of_death_yn+"',recorded_from_death_reg_yn = '"+recorded_from_death_reg_yn+"',   MODIFIED_BY_ID = '"+modifiedById+"' , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = '"+modifiedAtWorkstation+"', MODIFIED_FACILITY_ID = '"+x_facility_id+"' where PATIENT_ID = '"+Patient_Id+"' and TERM_SET_ID = '"+code_set+"' and TERM_CODE = '"+diagprob_code+"' and  OCCUR_SRL_NO = '"+occur_srl_no+"' and FACILITY_ID = '"+x_facility_id+"' /*and ENCOUNTER_ID = '"+Encounter_Id+"' */ ");

						//Maheshwaran K added notifiable_code for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						sbSql.append(" update PR_DIAGNOSIS_ENC_DTL set SEVERITY= ?, ONSET_TYPE = ?, PRACTITIONER_ID = ? , PRACTITIONER_RELN_ID = ?, LOCN_TYPE = ?, LOCN_CODE =?, NATURE = ?, PRIORITY = ?, ACCURACY_CODE =?, ACCURACY_IND = ?, REMARKS = ?, STATUS = ?, STATUS_DATE = to_date(?,'dd/mm/yyyy'), ENC_STAGE = ? , cause_of_death_yn = ?,recorded_from_death_reg_yn = ?,   MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,diag_class_code =? , NOTIFICATION_CODE = ?,poa_indicator='"+poa_indicator+"', DIAG_CATG = ?, link_diag_pri_sec_yn = ? where PATIENT_ID = ? and TERM_SET_ID = ? and TERM_CODE = ? and  OCCUR_SRL_NO = ? and FACILITY_ID = ? ");
						pstmt = con.prepareStatement( sbSql.toString() );
						pstmt.setString(1,severity);
						pstmt.setString(2,type);
						pstmt.setString(3,Practitioner_Id);
						pstmt.setString(4,relationship_id);
						pstmt.setString(5,Locn_Type);
						pstmt.setString(6,Locn_Code);
						pstmt.setString(7,nature);
						pstmt.setString(8,priority);
						pstmt.setString(9,accuracy);
						pstmt.setString(10,accuracy_ind);
						pstmt.setString(11,remarks);
						pstmt.setString(12,status);
						pstmt.setString(13,status_date);
						pstmt.setString(14,stage_code);
						pstmt.setString(15,cause_of_death_yn);
						pstmt.setString(16,recorded_from_death_reg_yn);
						pstmt.setString(17,modifiedById);
						pstmt.setString(18,modifiedAtWorkstation);
						pstmt.setString(19,x_facility_id);
						pstmt.setString (20,diag_class_code);//Maheshwaran K added as on 17/09/2013
						pstmt.setString(21,notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
						pstmt.setString(22,diag_catg_code);//Added by Ajay for TH-KW-CRF-165.1 on 03-Jan-2023
						pstmt.setString(23,link_diag_pri_sec_yn);//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
						pstmt.setString(24,Patient_Id);
						pstmt.setString(25,code_set);
						pstmt.setString(26,diagprob_code);
						pstmt.setString(27,occur_srl_no);
						pstmt.setString(28,x_facility_id);
						
						


					}

						
						try
						{
							count	= pstmt.executeUpdate();
							if(pstmt != null) pstmt.close();
							if(count > 0)
								result = true; 
							else 
							{
								result = false;
								sbMsg.append("Exception in update in PR_DIAGNOSIS_ENC_DTL : ");
							}
						}
						catch(Exception sqlDtl)
						{
							sqlDtl.printStackTrace();

							sbMsg.append("Exception in updation into PR_DIAGNOSIS_ENC_DTL : " + sqlDtl.getMessage());
							con.rollback();
							result = false;
						}
						
					}
/**/				
			//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
					if((mode.equals("modify") || mode.equals("modify_curr_desc")) && !high_risk_code.equals("")){

						
							if(status.equals("R") || status.equals("E")){
							
							String updatePR= "update PR_HIGH_RISK_CONDITION set CLOSE_RECORDED_DATE=sysdate,CLOSE_ENCOUNTER_ID=?,CLOSE_LOCN_TYPE=?,CLOSE_LOCN_CODE=?,CLOSE_FACILITY_ID=?,CLOSE_PRACTITIONER_ID=?,CLOSE_DATE=to_date(sysdate,'dd/mm/yyyy'),modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?, modified_facility_id=? where TERM_SET_ID=? and TERM_CODE=? and OCCUR_SRL_NO=? ";

							pstmt = con.prepareStatement(updatePR) ;							
							pstmt.setString (1,Encounter_Id);
							pstmt.setString (2,Locn_Type);
							pstmt.setString (3,Locn_Code);
							pstmt.setString (4,x_facility_id);
							pstmt.setString( 5, Practitioner_Id) ;							
							pstmt.setString (6,modifiedById);
							pstmt.setString (7,modifiedAtWorkstation);
							pstmt.setString (8,x_facility_id);
							pstmt.setString( 9,code_set) ;
							pstmt.setString( 10,diagprob_code) ;
							pstmt.setString( 11,occur_srl_no) ;
							count=0;
							count	= pstmt.executeUpdate();
							if(count>0)
								result = true;
							else
							{
								result= false;
								sbMsg.append("update  of PR_HIGH_RISK_CONDITION is failed");
							}
					   }else if(status.equals("X")){

						   	sbSql.append("update PR_HIGH_RISK_CONDITION set CLOSE_RECORDED_DATE='',CLOSE_ENCOUNTER_ID='',CLOSE_LOCN_TYPE='',CLOSE_LOCN_CODE='',CLOSE_FACILITY_ID='',CLOSE_PRACTITIONER_ID='',CLOSE_DATE='',modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?, modified_facility_id=? where TERM_SET_ID=? and TERM_CODE=?and OCCUR_SRL_NO=? ");

							pstmt = con.prepareStatement( sbSql.toString() ) ;
							pstmt.setString (1,modifiedById);
							pstmt.setString (2,modifiedAtWorkstation);
							pstmt.setString (3,x_facility_id);
							pstmt.setString( 4, code_set) ;
							pstmt.setString( 5, diagprob_code) ;
							pstmt.setString( 6, occur_srl_no) ;
							count=0;
							count	= pstmt.executeUpdate();
							if(count>0)
								result = true;
							else
							{
								result= false;
								sbMsg.append("update  of PR_HIGH_RISK_CONDITION is failed");
							}

					   }

					}
					if(result)
					{
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							sbSql.append("select a.complaint_id complaint_id from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and occur_srl_no = ?  ");
							if(!diagprob_code.equals("*OTH")){
								sbSql.append("and a.term_code = ? ");
							}else{
								sbSql.append("and a.term_code_short_desc = ? ");
							}
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString(1,x_facility_id);
							pstmt.setString(2,Encounter_Id);
							pstmt.setString(3,code_set);
							pstmt.setString(4,occur_srl_no);
							if(!diagprob_code.equals("*OTH")){
								pstmt.setString(5,diagprob_code);
							}else{
								pstmt.setString(5,diag_Description);
							}
							rs = pstmt.executeQuery();
							while(rs.next()){
								n_code = rs.getString(1);
								if(first_time){
									//n_code_list = n_code_list + "'" +n_code +"'";
									//Changed on 9/2/2010 for  Incident 23579
									chief_compl_code_list="'"+n_code+"',";
//									n_code_list.append(n_code_list.toString());
//									n_code_list.append("'" +n_code +"'");
								}else{
									//n_code_list = n_code_list + ",'" +n_code +"'";
//									n_code_list.append(n_code_list.toString());
//									n_code_list.append(",'" +n_code +"'");
									chief_compl_code_list=chief_compl_code_list+"'"+n_code+"',";//Changed on 9/2/2010 for  Incident 23579
								}
								first_time = false;
							}
							//if(n_code_list.equals("")){
								//n_code_list = "('')";
							//}else{
								//n_code_list = "("+n_code_list+")" ;
							//}
							//Changed on 9/2/2010 for  Incident 23579
							if(chief_compl_code_list!=""){
								chief_compl_code_list =chief_compl_code_list.substring(0,chief_compl_code_list.length()-1);
							}
							n_code_list.append("("+chief_compl_code_list+")") ;//Changed on 9/2/2010 for  Incident 23579
							/*if(n_code_list.length()==0){
								n_code_list.append("('')");
							}else{
								n_code_list.append("("+chief_compl_code_list+")") ;
							}*/
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							if(chief_compl_code_list!=""){
									sbSql.append("delete from pr_diagnosis_compl_enc_dtl where ");
									sbSql.append(" facility_id=? and encounter_id=? and term_set_id=?");
									sbSql.append(" and occur_srl_no = ? ");
									if(!diagprob_code.equals("*OTH")){
										sbSql.append("and term_code = ? ");
									}else{
										sbSql.append("and term_code_short_desc = ? ");
									}
									sbSql.append(" and complaint_id in ");
									sbSql.append(n_code_list.toString()); 
		//							n_code_list=null;
									n_code_list.setLength(0);//Changed on 9/2/2010 for  Incident 23579
									chief_compl_code_list="";
									try{
										pstmt = con.prepareStatement(sbSql.toString());
										pstmt.setString(1,x_facility_id);
										pstmt.setString(2,Encounter_Id);
										pstmt.setString(3,code_set);
										pstmt.setString(4,occur_srl_no);	
										if(!diagprob_code.equals("*OTH")){
											pstmt.setString(5,diagprob_code);
										}else{
											pstmt.setString(5,diag_Description);
										}
										count=0;
										count = pstmt.executeUpdate();
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									}
									catch (Exception e){
										e.printStackTrace();
									}
							}

						StringTokenizer complaintToken = new StringTokenizer(complaint_id, "$");
						while (complaintToken.hasMoreTokens()){
							complaint = complaintToken.nextToken();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							 sbSql.append("select to_char(onset_datetime,'dd/mm/yyyy HH24:MI') onset_date_time from ca_encntr_chief_complaint a where facility_id=? and encounter_id=? and complaint_id=?");
							 pstmt = con.prepareStatement( sbSql.toString() );
							 pstmt.setString( 1, x_facility_id) ;
							 pstmt.setString( 2, Encounter_Id) ;
							 pstmt.setString( 3, complaint) ;
							rs	= pstmt.executeQuery();
							if(rs.next() && rs!= null){
								comp_onset_date_time =checkForNull(rs.getString("onset_date_time"));
							}
							 if(rs != null) rs.close();
							 if(pstmt != null) pstmt.close();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							sbSql.append("insert into pr_diagnosis_compl_enc_dtl");
							sbSql.append("(facility_id,encounter_id,patient_id,");
							sbSql.append("term_set_id,term_code,term_code_short_desc,");
							sbSql.append("occur_srl_no,complaint_id,onset_date,staus,");
							sbSql.append("added_by_id,added_date,added_at_ws_no,added_facility_id,");
							sbSql.append("modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)");
							sbSql.append("values");
							sbSql.append("(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,");
							//sbSql.append("(?,?,?,?,?,?,?,?,?,?,?,sysdate,");
							sbSql.append("?,?,?,sysdate,?,?)");
							pstmt2 = con.prepareStatement( sbSql.toString() );
							pstmt2.setString	(1,  x_facility_id ) ;
							pstmt2.setString	(2,  Encounter_Id) ;
							pstmt2.setString	(3,  Patient_Id ) ;
							pstmt2.setString	(4,  code_set ) ;
							pstmt2.setString	(5,  diagprob_code ) ;
							pstmt2.setString	(6,  diag_Description ) ;
							pstmt2.setString	(7,  occur_srl_no ) ;
							pstmt2.setString	(8,  complaint ) ;
							pstmt2.setString	(9,  comp_onset_date_time ) ;
							pstmt2.setString	(10, status ) ;
							pstmt2.setString (11, addedById);
							pstmt2.setString (12, addedAtWorkstation);
							pstmt2.setString (13, x_facility_id);
							pstmt2.setString (14, modifiedById);
							pstmt2.setString (15, modifiedAtWorkstation);
							pstmt2.setString (16, x_facility_id);
							count=0;
							try{
								count	= pstmt2.executeUpdate();
								if(pstmt2 != null) pstmt2.close();
								if(count>0){
									result = true; 
								}else {
									result = false;
									sbMsg.append("Exception in inserting into pr_diagnosis_compl_enc_dtl : ");
								}
							}
							catch(SQLException sqle1){
								con.rollback();
								sbMsg.append("Exception in inserting into pr_diagnosis_compl_enc_dtl : " + sqle1.getMessage());
								result = false;
							}
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(pstmt2 != null) pstmt2.close();
					}
/**/
					if(result)
					{
						//Insert record into pr_diagnosis_status table PR_DIAGNOSIS_STATUS
						//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 22/07/2013
						//Start
						//if((mode.equals("modify_curr_enc")|| mode.equals("modify_curr_desc") || !mode.equals("modify")) && diag_enc_level_yn.equals("Y"))
						if((mode.equals("modify_curr_enc")|| mode.equals("modify_curr_desc") || !mode.equals("modify")) && diag_enc_level_yn.equals("Y")&&(status.equals("A")))
						{
						try
							{
							sbSql.setLength(0);
							sbSql.append("select OCCUR_SRL_NO from PR_DIAGNOSIS_STATUS ");
							sbSql.append("where patient_id = ? and term_set_id=? and term_code=? ") ;
							pstmt = con.prepareStatement( sbSql.toString()) ;
							pstmt.setString( 1, Patient_Id) ;
							pstmt.setString( 2, code_set) ;
							pstmt.setString( 3, diagprob_code) ;
							rs = pstmt.executeQuery() ;
							if(rs.next()){
							occur_srl_no_js = rs.getString("OCCUR_SRL_NO");
							}
							else{occur_srl_no_js="1";}
							//occur_srl_no=Integer.toString(srl_no);//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 28/09/2013
							srl_no=Integer.parseInt(occur_srl_no_js);
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
							}
						catch(Exception e)	
							{
							System.out.println("Exception occurred while getting : "+e);
							e.printStackTrace();
							}
							}
						//End	
						sbSql.setLength(0);
						sbSql.append("insert into PR_DIAGNOSIS_STATUS (patient_id,term_set_id,"); 
						sbSql.append("term_code,SRL_NO,severity,onset_type,");
						sbSql.append("facility_id,encounter_id,practitioner_id,");
						sbSql.append("practitioner_reln_id,locn_type,locn_code,nature,priority,");
						sbSql.append("accuracy_code,accuracy_ind,remarks,status,status_date,");
						sbSql.append("added_by_id,added_date,added_at_ws_no,added_facility_id,");
						sbSql.append("modified_by_id,modified_date,modified_at_ws_no");
						sbSql.append(",modified_facility_id,occur_srl_no,term_code_short_desc,recorded_from_death_reg_yn) values");
						sbSql.append("  ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?, ?, ?,"); 
						sbSql.append(" ?,?,");
						//sbSql.append("to_date('"+status_date+"','dd/mm/yyyy'),?,");
						sbSql.append("to_date(?,'dd/mm/yyyy'),?,");
						sbSql.append(" sysdate,?,?,?,sysdate,?,?,?,?,?)");
						pstmt = con.prepareStatement( sbSql.toString() );
						//Fetch data from PR_DIAGNOSIS...
						if(mode.equals("modify_curr_enc"))
						{
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);

							sbSql.append(" select a.curr_severity, ");
							sbSql.append("a.curr_onset_type,a.curr_facility_id,"); 
							sbSql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sbSql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
							sbSql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); 
							sbSql.append("to_char(a.curr_status_date,'dd/mm/yyyy') status_date, ");
							sbSql.append("(select nvl(max(srl_no),0)+1 srl_no from pr_diagnosis_status c where ");
							sbSql.append("c.PATIENT_ID=a.patient_id and c.TERM_SET_ID=a.TERM_SET_ID and c.TERM_CODE=a.TERM_CODE and c.OCCUR_SRL_NO=a.OCCUR_SRL_NO) srl_no ");
							sbSql.append(" from pr_diagnosis a, mr_term_code b");
							sbSql.append(" where a.term_code=b.term_code and a.term_set_id=b.term_set_id and "); 
							//sbSql.append(" a.curr_status='A' and ");
					//modified on 30/07/2008 for SCR 4916
							sbSql.append(" a.curr_status in ('A','R','E') and ");
							sbSql.append(" a.patient_id=? and a.term_set_id=? and a.term_code=? ");
							sbSql.append(" and a.OCCUR_SRL_NO=?");
							pstmt2 = con.prepareStatement( sbSql.toString() ) ;
							pstmt2.setString( 1, Patient_Id) ;
							pstmt2.setString( 2, code_set) ;
							pstmt2.setString( 3, diagprob_code) ;
							pstmt2.setString( 4, occur_srl_no) ;
							if(rs != null) rs.close();
							rs	= pstmt2.executeQuery();
							if(rs.next())
							{
								temp_severity			=checkForNull(rs.getString("curr_severity"));
								temp_type				=checkForNull(rs.getString("curr_onset_type"));
								temp_Practitioner_Id	=checkForNull(rs.getString("curr_practitioner_id"));
								temp_relationship_id	=checkForNull(rs.getString("curr_practitioner_reln_id"));
								temp_Locn_Type			=checkForNull(rs.getString("curr_locn_type"));
								temp_Locn_Code			=checkForNull(rs.getString("curr_locn_code"));
								temp_nature				=checkForNull(rs.getString("curr_nature"));
								temp_priority			=checkForNull(rs.getString("curr_priority"));
								temp_accuracy			=checkForNull(rs.getString("curr_accuracy_code"));
								temp_accuracy_ind		=checkForNull(rs.getString("curr_accuracy_ind"));
								temp_remarks			=checkForNull(rs.getString("curr_remarks"));
								temp_status				=checkForNull(rs.getString("curr_status"));
								temp_status_date		=checkForNull(rs.getString("status_date"));
							}

							if(rs != null)rs.close();
							if(pstmt2 != null)pstmt2.close();
							pstmt.setString	(1,  Patient_Id ) ;
							pstmt.setString	(2,  code_set) ;
							pstmt.setString	(3,  diagprob_code ) ;
							pstmt.setInt	(4,  srl_no ) ;
							pstmt.setString	(5,  temp_severity ) ;
							pstmt.setString	(6,  temp_type ) ;
							pstmt.setString	(7,  x_facility_id ) ;
							pstmt.setString	(8,  Encounter_Id ) ;
							pstmt.setString	(9,  Practitioner_Id ) ;
							pstmt.setString	(10, relationship_id ) ;
							pstmt.setString	(11, Locn_Type ) ;
							pstmt.setString	(12, Locn_Code ) ;
							pstmt.setString	(13, temp_nature ) ;
							pstmt.setString	(14, temp_priority ) ;
							pstmt.setString	(15, temp_accuracy ) ;
							pstmt.setString	(16, temp_accuracy_ind ) ;
							pstmt.setString	(17, temp_remarks ) ;
							pstmt.setString	(18, temp_status ) ;
							pstmt.setString (19,status_date);
							pstmt.setString (20,addedById);
							pstmt.setString (21,addedAtWorkstation);
							pstmt.setString (22,x_facility_id);
							pstmt.setString (23,modifiedById);
							pstmt.setString (24,modifiedAtWorkstation);
							pstmt.setString (25,x_facility_id);
							pstmt.setString (26,occur_srl_no);
							pstmt.setString (27,diag_Description);
							pstmt.setString (28,recorded_from_death_reg_yn);//Added on 9/15/2009 From MDR
						}
						else
						{
							pstmt.setString	(1,  Patient_Id ) ;
							pstmt.setString	(2,  code_set) ;
							pstmt.setString	(3,  diagprob_code ) ;
							pstmt.setInt	(4,  srl_no ) ;
							pstmt.setString	(5,  severity ) ;
							pstmt.setString	(6,  type ) ;
							pstmt.setString	(7,  x_facility_id ) ;
							if(curr_encr_flag.equals("N"))
								pstmt.setString	(8,  null ) ;
							else
								pstmt.setString	(8,  Encounter_Id ) ;
							pstmt.setString	(9,  Practitioner_Id ) ;
							pstmt.setString	(10, relationship_id ) ;
							pstmt.setString	(11, Locn_Type ) ;
							pstmt.setString	(12, Locn_Code ) ;
							pstmt.setString	(13, nature ) ;
							pstmt.setString	(14, priority ) ;
							pstmt.setString	(15, accuracy ) ;
							pstmt.setString	(16, accuracy_ind ) ;
							pstmt.setString	(17, remarks ) ;
							pstmt.setString	(18, status ) ;
							pstmt.setString	(19, status_date ) ;
							pstmt.setString (20,addedById);
							pstmt.setString (21,addedAtWorkstation);
							pstmt.setString (22,x_facility_id);
							pstmt.setString (23,modifiedById);
							pstmt.setString (24,modifiedAtWorkstation);
							pstmt.setString (25,x_facility_id);
							pstmt.setString (26,occur_srl_no);
							pstmt.setString (27,diag_Description);
							pstmt.setString (28,recorded_from_death_reg_yn);//Added on 9/15/2009 From MDR

						}
						count=0;
						try{
						count	= pstmt.executeUpdate();
			            if(pstmt != null) pstmt.close();
						if(count>0)
							result = true; 
						else 
							{
								result = false;
								sbMsg.append("Exception in inserting into pr_diagnosis_status : ");

							}
						}
						catch(SQLException sqle1)
						{
							con.rollback();
							sbMsg.append("Exception in inserting into pr_diagnosis_status : " + sqle1.getMessage());
							result = false;
						}
						if(result && !mode.equals("modify_curr_enc"))
						{
							if(!as_evidenced_by_hid.equals(""))
							{
								try
								{
									String ins_strtoken_main_left="";
									String ins_strtoken_main_right="";
									String ins_left_val="";
									String ins_right_val="";
									String ins_left_val1="";
									String ins_right_val1="";
									StringTokenizer ins_strtoken_main_left1 = new StringTokenizer(java.net.URLDecoder.decode(as_evidenced_by_hid),"#");
									while(ins_strtoken_main_left1.hasMoreTokens())
									{
										ins_strtoken_main_left=ins_strtoken_main_left1.nextToken();
										ins_strtoken_main_right=ins_strtoken_main_left1.nextToken();
									}
									StringTokenizer ins_strtoken = new StringTokenizer(java.net.URLDecoder.decode(ins_strtoken_main_left),"||");
									while(ins_strtoken.hasMoreTokens())
									{
										if(ins_strtoken.hasMoreTokens())
										ins_left_val = ins_strtoken.nextToken();
										if(ins_strtoken.hasMoreTokens())
										ins_right_val=(String)ins_strtoken.nextToken();
									}
									StringTokenizer ins_strtoken1 = new StringTokenizer(java.net.URLDecoder.decode(ins_strtoken_main_right),"^");
									while(ins_strtoken1.hasMoreTokens())
									{
										if(ins_strtoken1.hasMoreTokens())
										ins_left_val1 = ins_strtoken1.nextToken();
										if(ins_strtoken1.hasMoreTokens())
										ins_right_val1=(String)ins_strtoken1.nextToken();
									}
									
									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append(" insert into PR_DIAGNOSIS_EVIDENCE "); 
									sbSql.append(" (patient_id,term_set_id,"); 
									sbSql.append("term_code,STATUS_SRL_NO,");
									sbSql.append("FACTOR_CODE,FACTOR_TYPE,");
									sbSql.append("ADDED_BY_ID,ADDED_DATE,");
									sbSql.append("ADDED_AT_WS_NO,ADDED_FACILITY_ID,");
									sbSql.append("MODIFIED_BY_ID,MODIFIED_DATE,");
									sbSql.append("MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OCCUR_SRL_NO,RECORDED_FROM_DEATH_REG_YN) values");
									sbSql.append(" ( ?, ?, ?,");
									sbSql.append("?, ?, ?, ?, sysdate,?,?,?,sysdate,"); 
									sbSql.append(" ?,?,?,?)");
									pstmt = con.prepareStatement( sbSql.toString() );

									
									pstmt.setString	(1,  Patient_Id ) ;
									pstmt.setString	(2,  code_set) ;
									pstmt.setString	(3,  diagprob_code) ;
									pstmt.setInt	(4,  srl_no ) ;
									
									pstmt.setString	(7,  addedById ) ;
									pstmt.setString (8,addedAtWorkstation);
									pstmt.setString (9,x_facility_id);
									pstmt.setString (10,modifiedById);
									pstmt.setString (11,modifiedAtWorkstation);
									pstmt.setString (12,x_facility_id);
									pstmt.setString (13,occur_srl_no);
									//pstmt.setString (14,diag_Description);
									pstmt.setString (14,recorded_from_death_reg_yn);//Added On 9/15/2009 From MDR .

									StringTokenizer L_factor_code_str=new StringTokenizer(ins_left_val,"~");
									while(L_factor_code_str.hasMoreTokens())
									{
										factor_code=(String)L_factor_code_str.nextToken();
										pstmt.setString	(5,  factor_code ) ;
										pstmt.setString	(6,  ins_left_val1 ) ;
										
										

										count=0;
										count	= pstmt.executeUpdate();
									}
									StringTokenizer R_factor_code_str=new StringTokenizer(ins_right_val,"~");
									while(R_factor_code_str.hasMoreTokens())
									{
										factor_code=(String)R_factor_code_str.nextToken();
										pstmt.setString	(5,  factor_code ) ;
										pstmt.setString	(6,  ins_right_val1 ) ;
										count=0;
									
									

										count	= pstmt.executeUpdate();
									}
						            if(pstmt != null) pstmt.close();

								

									if(count>0)
										result = true; 
									else 
									{
										result = false;
										sbMsg.append("Exception while inserting into PR_DIAGNOSIS_STATUS : ");

									}
									
									
									
									}
									catch(SQLException Ex)
									{
										Ex.printStackTrace() ;
										con.rollback();
										sbMsg.append("Exception while inserting into PR_DIAGNOSIS_STATUS : " + Ex.getMessage());
										result = false;
									}
								}

								if(result && !mode.equals("modify") && accuracy_ind.equals("U")&& !mode.equals("modify_curr_enc") && !mode.equals("modify_curr_desc"))//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
								{
									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append("SELECT 1 FROM PR_DIFFERENTIAL_DIAGNOSIS  ");
									sbSql.append(" WHERE PATIENT_ID=? AND FINALIZED_YN='N' and term_set_id=?"); 
									pstmt = con.prepareStatement( sbSql.toString() ) ;
									pstmt.setString( 1, Patient_Id) ;
									pstmt.setString	(2,  code_set) ;
									rset = pstmt.executeQuery() ;
									if(!rset.next()|| !new_group_id.equals(""))
									{
										if(new_group_id.equals("")||new_group_id.equals("Create New Group"))
										{
											//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
											sbSql.setLength(0);

											sbSql.append("select nvl(max(diff_group_id),0)+1 "); 
											sbSql.append("new_group_id from pr_differential_diagnosis where patient_id=? and term_set_id=?");
											pstmt = con.prepareStatement(sbSql.toString());
											pstmt.setString(1,Patient_Id);
											pstmt.setString	(2,code_set) ;
											rs=pstmt.executeQuery();
											while(rs.next())
											{
												new_group_id = rs.getString(1);
											}
								            if(rs != null) rs.close();
										}
										if(rset != null) rset.close();
										if(pstmt != null) pstmt.close();

										//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
										sbSql.setLength(0);

										sbSql.append("insert into pr_differential_diagnosis ");
										sbSql.append("(patient_id,term_set_id,term_code,");
										sbSql.append("OCCUR_SRL_NO,diff_group_id,finalized_yn,"); 
										sbSql.append("added_by_id,added_date,added_at_ws_no,"); 
										sbSql.append("added_facility_id,");
										sbSql.append("modified_by_id,modified_date,");
										sbSql.append("modified_at_ws_no,modified_facility_id,term_code_short_desc,recorded_from_death_reg_yn)");
										sbSql.append(" values  (?,?,?,");
										sbSql.append("?,");
										sbSql.append("?,'N',?,sysdate,?,?,?,sysdate,?,?,?,?)");

										pstmt = con.prepareStatement( sbSql.toString() );
										pstmt.setString(1,Patient_Id);
										pstmt.setString(2,code_set);
										pstmt.setString(3,diagprob_code);
										pstmt.setString(4,occur_srl_no);
										pstmt.setString(5,new_group_id);
										pstmt.setString(6,addedById);
										pstmt.setString(7,addedAtWorkstation);
										pstmt.setString(8,x_facility_id);
										pstmt.setString(9,modifiedById);
										pstmt.setString(10,modifiedAtWorkstation);
										pstmt.setString(11,x_facility_id);
										pstmt.setString(12,diag_Description);
										pstmt.setString(13,recorded_from_death_reg_yn);// Added On 9/15/2009 For MDR.

										count=0;
										count	= pstmt.executeUpdate();
										if(count>0)
											result = true; 
										else 
										{
											result = false;
											sbMsg.append("exception at insertion in pr_differential_diagnosis.");
										}
										results.put("diff_flaf","Not_found");
									}
									else
									{
										sbMsg.append("Diff Diagnosis Found");
										results.put("diff_flaf","Record_found");
									}
									if(pstmt!=null) pstmt.close();
								}

								if(!associate_codes.equals("") && !associate_codes.equals(associate_codes_modify) && result)
								{
									String splitsupportcodes = "";
									String codesDelete		 = "";   //Added by Sangeetha for ML-MMOH-CRF-0733
									int supp_code_updated = 0;
									int support_updated = 0;
									//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.setLength(0);

									sbSql.append(" insert into PR_SUPPORT_DIAGNOSIS (PATIENT_ID,TERM_SET_ID,TERM_CODE, "); sbSql.append(" SUPP_TERM_SET_ID,SUPP_TERM_CODE,ADDED_BY_ID, ");
									sbSql.append(" ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID, ");
									sbSql.append(" MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OCCUR_SRL_NO,SRL_NO,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN) values ( ");
									sbSql.append(" ?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?) ");
									if(pstmt != null) pstmt.close();
									pstmt = con.prepareStatement( sbSql.toString());

									

									support.append(" insert into PR_DIAGNOSIS_DETAIL (PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, SUPP_TERM_SET_ID, SUPP_TERM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN ) values ( ?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,? ) "); 			
									if(supportPstmt != null) supportPstmt.close();
									supportPstmt = con.prepareStatement( support.toString());
									support.setLength(0);
									
									
									StringTokenizer str1 = new StringTokenizer(associate_codes,"|");
									StringTokenizer delete_str1 = new StringTokenizer(associate_codes_modify,"|");  //Added by Sangeetha for ML-MMOH-CRF-0733

									while(str1.hasMoreTokens())
									{
										
										splitsupportcodes  = str1.nextToken();
										splitsupportcodes = splitsupportcodes.replace('+',' ');
									
										//Added by Sangeetha for ML-MMOH-CRF-0733
										codesDelete		   = "";
										if(delete_str1.hasMoreTokens()){
											codesDelete	= delete_str1.nextToken();
										}
										
										if(!splitsupportcodes.equals(codesDelete))
										{
											
										StringTokenizer str2 = new StringTokenizer(splitsupportcodes,"~");
										while(str2.hasMoreTokens())
										{
										
											external_diag_code = str2.nextToken();
											external_diag_code = external_diag_code.replace(' ','+');
											
											//String shortDesc=str2.nextToken();
											str2.nextToken();
											String longDesc="";
											if(str2.hasMoreTokens())
												longDesc= str2.nextToken();
//											pstmt.clearParameters();
											
											

											pstmt.setString(1, Patient_Id);
											pstmt.setString(2,code_set);
											pstmt.setString(3, diagprob_code);
											pstmt.setString(4, code_set);
											pstmt.setString(5, external_diag_code);
											pstmt.setString(6, addedById);
											pstmt.setString(7, addedAtWorkstation);
											pstmt.setString(8, x_facility_id);
											pstmt.setString(9, modifiedById);
											pstmt.setString(10, modifiedAtWorkstation);	
											pstmt.setString(11, x_facility_id);
											pstmt.setString(12, occur_srl_no);
											pstmt.setInt(13, srl_no);
											pstmt.setString(14, diag_Description);
											pstmt.setString(15, recorded_from_death_reg_yn);// Added On 9/15/2009 For MDR.

											try
											{
												supp_code_updated=0;
												supp_code_updated = pstmt.executeUpdate();
											}
											catch(SQLException sqle)
											{
												sqle.printStackTrace();
												con.rollback();
												result=false;
												sbMsg.append("exception at supp_code_updated---- "+sqle.getMessage());
											}
											if(supp_code_updated >0)
												result=true;
											else
											{
												result=false;
												sbMsg.append("exception at insertion of PR_DIAGNOSIS_DETAIL.");
												
											}

											//String suppe = "insert into PR_DIAGNOSIS_DETAIL (PATIENT_ID, TERM_SET_ID, TERM_CODE, OCCUR_SRL_NO, SUPP_TERM_SET_ID, SUPP_TERM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) values ( '"+Patient_Id+"','"+code_set+"','"+diagprob_code+"','"+occur_srl_no+"','"+code_set+"','"+external_diag_code+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+x_facility_id+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+x_facility_id+"' ) "; 			

											if(result)
											{

												supportPstmt.clearParameters();
												supportPstmt.setString(1, Patient_Id);
												supportPstmt.setString(2, code_set);
												supportPstmt.setString(3, diagprob_code);
												supportPstmt.setString(4, occur_srl_no);
												supportPstmt.setString(5, code_set);
												supportPstmt.setString(6, external_diag_code);
												supportPstmt.setString(7, addedById);
												supportPstmt.setString(8, addedAtWorkstation);
												supportPstmt.setString(9, x_facility_id);
												supportPstmt.setString(10, modifiedById);
												supportPstmt.setString(11, modifiedAtWorkstation);	
												supportPstmt.setString(12, x_facility_id);
												supportPstmt.setString(13, diag_Description);
												supportPstmt.setString(14, recorded_from_death_reg_yn);//Added on 9/15/2009 For MDR.
												try
												{
													support_updated=0;
													support_updated = supportPstmt.executeUpdate();
												}
												catch(SQLException sqle)
												{
													sqle.printStackTrace();
													con.rollback();
													result=false;
													sbMsg.append("exception at support_updated---- "+sqle.getMessage());
												}

												if(support_updated >0)
													result=true;
												else
												{
													result=false;
													sbMsg.append("exception at insertion of PR_DIAGNOSIS_DETAIL. ");
												}
											}
										}   
										}   
									}
								}
							}
						}
					if(pstmt != null) pstmt.close();
					if(supportPstmt != null) supportPstmt.close();
					if(result)
					{
						java.util.Hashtable message=new java.util.Hashtable();
						if(mode.equals("modify")||mode.equals("modify_curr_desc"))//Maheshwaran K modified for the CRF : SKR-CRF-0020 as on 22/07/2013
						{
							//Added by Jeyachitra - ML-MMOH-CRF 1742 
							if(isDeceasedDiagClassDeathRegAppl){
							curr_RecDiag_Data.put("Diagnosis_Code" ,diagprob_code);
							curr_RecDiag_Data.put("Diagnosis_Classification", diag_class_code);
							curr_RecDiag_Data.put("Nature", nature);
							curr_RecDiag_Data.put("Severity", severity);
							curr_RecDiag_Data.put("Accuracy", accuracy);
							curr_RecDiag_Data.put("Priority", priority);
							curr_RecDiag_Data.put("Onset_Date", onset_date);
							curr_RecDiag_Data.put("Encounter_Stage", stage_code);
							curr_RecDiag_Data.put("As_On_Date", status_date );
							curr_RecDiag_Data.put("Status", status);
							curr_RecDiag_Data.put("Diagnosis_Remarks", remarks);
							curr_RecDiag_Data.put("Chief_Complaint", complaint_desc);
								
								insertAuditTrial(Patient_Id,code_set, diagprob_code, occur_srl_no, x_facility_id, Encounter_Id, addedById, addedAtWorkstation,modifiedById, modifiedAtWorkstation, prev_RecDiag_Data, curr_RecDiag_Data);
							}
							
							message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM");
						}
						else
						{
							message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM");
						}
						results.put("occur_srl_no",occur_srl_no);
						results.put("message",(String) message.get("message"));
						con.commit();
						if ( message != null ) message.clear();
					}
					else
					{
							con.rollback();
					}
				}
				catch(Exception e)
				{
					sbMsg.append("Exception in while inserting::  " + e.getMessage());
					con.rollback();
					result = false;
					e.printStackTrace();
				}
			}
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
			sbMsg.append("Exception in RecDiagnosis Manager EJB : " + ex.getMessage());
		}
		finally
		{
			if( con != null ) ConnectionManager.returnConnection(con,p);
		}
		sbSql=null;
		results.put( "status", new Boolean(result) );
		results.put( "error", sbMsg.toString() );
		
		return results;
	}



	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertRecDiagnosisEOCare(Properties p,HashMap tableData)
	{
		boolean result=true;
		java.util.HashMap results = new java.util.HashMap() ;
		StringBuffer sbSql = new StringBuffer();
		StringBuffer sbMsg = new StringBuffer();
		
		String x_facility_id				=	(String)tableData.get("x_facility_id");
		String client_ip_address			=	(String)tableData.get("client_ip_address");
		String Practitioner_Id				=	(String)tableData.get("Practitioner_Id"); 

		//String relationship_id				=	(String)tableData.get("relationship_id"); 
		//String Locn_Code					=	(String)tableData.get("Locn_Code"); 
		//String Locn_Type					=	(String)tableData.get("Locn_Type"); 
		//String Encounter_Id					=	(String)tableData.get("Encounter_Id");

		String episode_id					=	(String)tableData.get("episode_id");
		String eposide_desc					=	(String)tableData.get("eposide_desc");
		String primary_yn_hid					=	(String)tableData.get("primary_yn");
		String significant_yn				=	(String)tableData.get("significant_yn");
		String include_yn					=	(String)tableData.get("include_yn");
		String diag_Description				=	(String)tableData.get("diag_Description");
		//long Encounter_ID = 0;
		int EOC_updated_count=0;

		//Encounter_ID = Long.parseLong(Encounter_Id);
		//String mode					=	(String)tableData.get("mode");
		String Patient_Id					=	(String)tableData.get("Patient_Id"); 
		
		//String occur_srl_no_hid				=	(String)tableData.get("occur_srl_no_hid");

		String addedById		 = p.getProperty( "login_user" ) ;
		String locale			 = p.getProperty("LOCALE");

		String modifiedAtWorkstation = client_ip_address ;
		String addedAtWorkstation = modifiedAtWorkstation;
		//String factor_code	="";	int new_group_id	=0;
		//int diff_grp_no=0;
		//String addedDate	 = dateFormat.format(new java.util.Date()) ;
		String modifiedById  = addedById ;
		//String modifiedDate = addedDate ;
		String term_set_id	="";
		String term_id	=""; String occur_srl_no	="";
		String sign_yn	=""; String primary_yn	="";
		//String incd_yn="";
		
		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
			sbSql.setLength(0);

			
			sbSql.append(" insert into PR_EPISODE_OF_CARE "); 
			sbSql.append(" (EOC_ID,PATIENT_ID,"); 
			sbSql.append("EOC_CODE,STATUS,");
			sbSql.append("OPEN_FACILITY_ID,OPEN_PRACTITIONER_ID,");
			sbSql.append("OPEN_DATE,RESOLVE_FACILITY_ID,");
			sbSql.append("RESOLVE_PRACTITIONER_ID,RESOLVE_DATE,");
			sbSql.append("ERROR_FACILITY_ID,ERROR_PRACTITIONER_ID,");
			sbSql.append("ERROR_DATE,ERROR_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,");
			sbSql.append("ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values");
			sbSql.append(" (?, ?, ?,?,?,?,sysdate,");
			sbSql.append("?, ?, ?, ?, ?,?,?,?,sysdate,?,?,?,"); 
			sbSql.append(" sysdate,?,?)");
			
			pstmt = con.prepareStatement( sbSql.toString());
			pstmt.setString(1, episode_id);
			
			pstmt.setString(2, Patient_Id);
			
			pstmt.setString(3, eposide_desc);
			
			pstmt.setString(4, "A");
			pstmt.setString(5, x_facility_id);
			
			pstmt.setString(6, Practitioner_Id);
			
			pstmt.setString(7, x_facility_id);
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, x_facility_id);
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			pstmt.setString(13, "");
			pstmt.setString(14, addedById);
			pstmt.setString(15, addedAtWorkstation);
			pstmt.setString(16, x_facility_id);
			pstmt.setString(17, modifiedById);
			pstmt.setString(18, modifiedAtWorkstation);
			
			pstmt.setString(19, x_facility_id);
			
				EOC_updated_count = pstmt.executeUpdate();	
					
			if(EOC_updated_count>0)
				result=true;
			else
				result=false;
			
			if(pstmt != null) pstmt.close();
			if(result)
			{
				//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.setLength(0);

				
				sbSql.append(" insert into PR_EPISODE_OF_CARE_DETAIL "); 
				sbSql.append(" (EOC_ID,PATIENT_ID,"); 
				sbSql.append("TERM_SET_ID,TERM_CODE,");
				sbSql.append("OCCUR_SRL_NO,PRIMARY_YN,");
				sbSql.append("SIGNIFICANT_YN,ADDED_BY_ID,");
				sbSql.append("ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID");
				sbSql.append(",MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TERM_CODE_SHORT_DESC ) values");
				sbSql.append(" (?, ?, ?,?,?,?,?,");
				sbSql.append("?, sysdate, ?, ?, ?,sysdate,?,?,?)");
				pstmt = con.prepareStatement( sbSql.toString());
				
				pstmt.setString(1, episode_id);
				pstmt.setString(2, Patient_Id);
				pstmt.setString(8, addedById);
				pstmt.setString(9, addedAtWorkstation);
				pstmt.setString(10, x_facility_id);
				pstmt.setString(11, modifiedById);
				pstmt.setString(12, modifiedAtWorkstation);
				pstmt.setString(13, x_facility_id);
				pstmt.setString(14, diag_Description);
				StringTokenizer peoc_token = new StringTokenizer(primary_yn_hid,"~");
				while(peoc_token.hasMoreTokens())
				{
					term_id = peoc_token.nextToken();
					primary_yn = "Y";
					sign_yn = "N";
					//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.setLength(0);

					sbSql.append("select TERM_SET_ID,OCCUR_SRL_NO from pr_diagnosis where ");
					sbSql.append(" TERM_CODE=? and PATIENT_ID=? ");
					pstmt1 = con.prepareStatement( sbSql.toString());
					pstmt1.setString(1, term_id);
					pstmt1.setString(2, Patient_Id);
					rset= pstmt1.executeQuery();
					
					if(rset.next())
					{
						term_set_id = rset.getString("TERM_SET_ID");
						
						occur_srl_no = rset.getString("OCCUR_SRL_NO");
						
					}
					if(rset != null) rset.close();
					if(pstmt1 != null) pstmt1.close();
					pstmt.setString(3, term_set_id);
					pstmt.setString(4, term_id);

					pstmt.setString(5, occur_srl_no);
					pstmt.setString(6, primary_yn);
					pstmt.setString(7, sign_yn);
				
					EOC_updated_count=0;
					EOC_updated_count = pstmt.executeUpdate();
				}
				StringTokenizer seoc_token = new StringTokenizer(significant_yn,"~");
				while(seoc_token.hasMoreTokens())
				{
					term_id = seoc_token.nextToken();
					sign_yn = "Y";
					primary_yn = "N";
					//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.setLength(0);

					sbSql.append("select TERM_SET_ID,OCCUR_SRL_NO from pr_diagnosis where ");
					sbSql.append(" TERM_CODE=?  and PATIENT_ID=? ");
					pstmt1 = con.prepareStatement( sbSql.toString());
					pstmt1.setString(1, term_id);
					pstmt1.setString(2, Patient_Id);
					rset= pstmt1.executeQuery();
					if(rset.next())
					{
						term_set_id = rset.getString("TERM_SET_ID");
						occur_srl_no = rset.getString("OCCUR_SRL_NO");
					}
					if(rset != null) rset.close();
					if(pstmt1 != null) pstmt1.close();
					pstmt.setString(3, term_set_id);
					pstmt.setString(4, term_id);
					pstmt.setString(5, occur_srl_no);
					pstmt.setString(6, primary_yn);
					pstmt.setString(7, sign_yn);
						
					EOC_updated_count=0;
					EOC_updated_count = pstmt.executeUpdate();
								}
				if(pstmt != null) pstmt.close();
				StringTokenizer incd_token = new StringTokenizer(include_yn,"~");
				while(incd_token.hasMoreTokens())
				{
					term_id = incd_token.nextToken();
					sign_yn = "N";
					primary_yn = "N";
					//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.setLength(0);

					sbSql.append("select TERM_SET_ID,OCCUR_SRL_NO from pr_diagnosis where ");
					sbSql.append(" TERM_CODE=?  and PATIENT_ID=? ");
					pstmt1 = con.prepareStatement( sbSql.toString());
					pstmt1.setString(1, term_id);
					pstmt1.setString(2, Patient_Id);
					rset= pstmt1.executeQuery();
					if(rset.next())
					{
						term_set_id = rset.getString("TERM_SET_ID");
						occur_srl_no = rset.getString("OCCUR_SRL_NO");
					}
					if(rset != null) rset.close();
					if(pstmt1 != null) pstmt1.close();
					pstmt.setString(3, term_set_id);
					pstmt.setString(4, term_id);
					pstmt.setString(5, occur_srl_no);
					pstmt.setString(6, primary_yn);
					pstmt.setString(7, sign_yn);
				
					EOC_updated_count=0;
					EOC_updated_count = pstmt.executeUpdate();
					}
				if(	pstmt!= null) pstmt.close();
				if(	pstmt1!= null) pstmt1.close();
			}
			if(result)
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				results.put("message",(String) message.get("message"));
				con.commit();
				if ( message != null ) message.clear();
			}
			else
			{
				sbMsg.append("Transaction Has been Rollbacked");
				result=false;
				con.rollback();
			}
		}
		catch(Exception xp)
		{
			try
			{
				con.rollback();
			}
			catch(Exception x)
			{
				x.printStackTrace();
				sbMsg.append("Exception inside catch Exception in Episode of Care: " + x.getMessage());
				result=false;
			}
			xp.printStackTrace();
		}
		finally
		{
			if( con != null ) ConnectionManager.returnConnection(con,p);
		}
		sbSql=null;
		results.put( "status", new Boolean(result) ) ;
		return results;
	}
	public static String checkForNull(String s)
    {
        return s != null && !s.equals("null") ? s : "";
    }
	
//Added by Jeyachitra - ML-MMOH-CRF 1742
public void insertAuditTrial(String Patient_Id,String code_set,String diagprob_code,String occur_srl_no,String x_facility_id,
		String Encounter_Id, String addedById, String addedAtWorkstation,String modifiedById, String modifiedAtWorkstation, HashMap<String, String>prev_RecDiag_Data, HashMap<String, String>curr_RecDiag_Data ){
	try
	{
		
		for(Entry<String, String> k : prev_RecDiag_Data.entrySet())
		{
			String key = k.getKey();
			String prev_value = checkForNull(k.getValue());
			if(curr_RecDiag_Data.containsKey(key))
			{
				String curr_value = checkForNull(curr_RecDiag_Data.get(key));
				if(!curr_value.equalsIgnoreCase(prev_value))
				{
					
					pstmt3	= con.prepareStatement( "insert into mr_rec_diag_audit_trial(patient_id, term_set_id, term_code, occur_srl_no, facility_id,encounter_id, attr_updated, cur_attr_value, prev_attr_value, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)" );	

					pstmt3.setString (1,Patient_Id);
					pstmt3.setString (2,code_set);
					pstmt3.setString (3,diagprob_code);
					pstmt3.setString (4,occur_srl_no);
					pstmt3.setString (5,x_facility_id);
					pstmt3.setString (6,Encounter_Id);
					pstmt3.setString (7,key);
					pstmt3.setString (8,curr_value);
					pstmt3.setString (9,prev_value);
					pstmt3.setString (10,addedById);
					pstmt3.setString (11,addedAtWorkstation);
					pstmt3.setString (12,x_facility_id);
					pstmt3.setString (13,modifiedById);
					pstmt3.setString (14,modifiedAtWorkstation);
					pstmt3.setString (15,x_facility_id);
					pstmt3.executeUpdate();
					
					if(pstmt3 != null) pstmt3.close();
				}
			}
		}			
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

//Added by Jeyachitra - ML-MMOH-CRF 1742
public void getOldDataAuditTrial(String Patient_Id,String code_set,String diagprob_code,String occur_srl_no,String x_facility_id,String Encounter_Id, HashMap<String, String>prev_RecDiag_Data, String aud_complaint_desc){

	try
	{
		pstmt3	= con.prepareStatement( "SELECT a.term_code, a.diag_class_code, a.nature, a.severity, a.accuracy_code,a.priority, TO_CHAR(b.onset_date, 'dd/mm/yyyy hh24:mi') onset_date, a.enc_stage, TO_CHAR(b.curr_status_date, 'dd/mm/yyyy') status_date,       a.status, a.remarks FROM pr_diagnosis_enc_dtl a, pr_diagnosis b WHERE a.patient_id = b.patient_id AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND a.occur_srl_no = b.occur_srl_no AND a.patient_id = ? AND a.term_set_id = ? AND a.encounter_id = ? AND a.term_code = ? AND a.occur_srl_no = ? AND a.facility_id = ?" );	

		pstmt3.setString (1,Patient_Id);
		pstmt3.setString (2,code_set);
		pstmt3.setString (3,Encounter_Id);
		pstmt3.setString (4,diagprob_code);
		pstmt3.setString (5,occur_srl_no);
		pstmt3.setString (6,x_facility_id);
		rs = pstmt3.executeQuery();
		if(rs != null && rs.next())
		{
			prev_RecDiag_Data.put("Diagnosis_Code" ,checkForNull(rs.getString("term_code")));
			prev_RecDiag_Data.put("Diagnosis_Classification", checkForNull(rs.getString("diag_class_code")));
			prev_RecDiag_Data.put("Nature", checkForNull(rs.getString("nature")));
			prev_RecDiag_Data.put("Severity", checkForNull(rs.getString("severity")));
			prev_RecDiag_Data.put("Accuracy", checkForNull(rs.getString("accuracy_code")));
			prev_RecDiag_Data.put("Priority", checkForNull(rs.getString("priority")));
			prev_RecDiag_Data.put("Onset_Date", checkForNull(rs.getString("onset_date")));
			prev_RecDiag_Data.put("Encounter_Stage", checkForNull(rs.getString("enc_stage")));
			prev_RecDiag_Data.put("As_On_Date", checkForNull(rs.getString("status_date")));
			prev_RecDiag_Data.put("Status", checkForNull(rs.getString("status")));
			prev_RecDiag_Data.put("Diagnosis_Remarks", checkForNull(rs.getString("remarks")));
			prev_RecDiag_Data.put("Chief_Complaint", checkForNull(aud_complaint_desc));			
		}
			
		if(rs != null) rs.close();
		if(pstmt3 != null) pstmt3.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
