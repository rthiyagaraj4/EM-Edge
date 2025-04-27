/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCP.EvaluateCarePlan;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
/**
*
* @ejb.bean
*	name="EvaluateCarePlan"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="EvaluateCarePlan"
*	local-jndi-name="EvaluateCarePlan"
*	impl-class-name="eCP.EvaluateCarePlan.EvaluateCarePlanManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.EvaluateCarePlan.EvaluateCarePlanLocal"
*	remote-class="eCP.EvaluateCarePlan.EvaluateCarePlanRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.EvaluateCarePlan.EvaluateCarePlanLocalHome"
*	remote-class="eCP.EvaluateCarePlan.EvaluateCarePlanHome"
*	generate= "local,remote"
*
*
*/
public class EvaluateCarePlanManager implements SessionBean
{
	Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt_insert_eval = null;
    PreparedStatement pstmt_update_goal = null;
    PreparedStatement pstmt_update_diag_intvn = null;
    PreparedStatement pstmt_diag_goal_diag = null;
    PreparedStatement pstmt_diag_goal_goal = null;
    PreparedStatement pstmt_update_goal_intvn = null;
    PreparedStatement pstmt_update_diag_intvn_dtl = null;
    PreparedStatement pstmt_update_goal_intvn_dtl = null;
    PreparedStatement pstmt_update_diag_task_list = null;
    PreparedStatement pstmt_update_goal_task_list = null;
    PreparedStatement pstmt_update_diag_prdiag = null;
    PreparedStatement pstmt_update_outcome = null;
    PreparedStatement pstmt_update_outcome_eval = null;
    PreparedStatement pstmt_insert_diag = null;
    PreparedStatement pstmt_insert_goal = null;
    PreparedStatement pstmt_insert_outcome = null;
    PreparedStatement pstmt_select_diag = null;
    PreparedStatement pstmt_select_goal = null;
	ResultSet rs_eval_id=null;
	ResultSet rs_select_diag = null;
	ResultSet rs_select_goal = null;
	StringBuffer stringbuffer = new StringBuffer();
    public EvaluateCarePlanManager()
    {
    }
    public void ejbCreate() throws  CreateException
    {
    }
    public void ejbRemove()
    {
    }
    public void ejbActivate()
    {
    }
    public void ejbPassivate()
    {
    }
    public void setSessionContext(SessionContext sessioncontext)
    {
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap AddModify(Properties properties, HashMap hashmap)
	{
		HashMap tempHash = new HashMap();
		try
		{
			con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			ArrayList diag_arr = new ArrayList();
			ArrayList goal_arr = new ArrayList();
			ArrayList outcome_arr = new ArrayList();
			HashMap diag_map = new HashMap();
			HashMap goal_map = new HashMap();
			HashMap outcome_map = new HashMap();
			diag_arr = (ArrayList) hashmap.get("DIAGNOSIS");
			goal_arr = (ArrayList) hashmap.get("GOAL");
			outcome_arr = (ArrayList) hashmap.get("OUTCOME");
			String patient_id = (String) hashmap.get("PATIENT_ID");
			String pract_id = (String) hashmap.get("PRACT_ID");
			String encounter_id = (String) hashmap.get("ENCOUNTER_ID");
			String care_plan_id = (String) hashmap.get("CARE_PLAN_ID");
			String md_plan_id = (String) hashmap.get("MD_PLAN_ID");
			String eval_status = (String) hashmap.get("STATUS");
			String eval_remarks = (String) hashmap.get("REMARKS");
			String added_by_id = (String)hashmap.get("ADDED_BY_ID");
			String added_at_ws_no = (String)hashmap.get("ADDED_AT_WS_NO");
			String added_facility_id = (String)hashmap.get("ADDED_FACILITY_ID");
			String modified_by_id = (String)hashmap.get("MODIFIED_BY_ID");
			String modified_at_ws_no = (String)hashmap.get("MODIFIED_AT_WS_NO");
			String modified_facility_id = (String)hashmap.get("MODIFIED_FACILITY_ID");
			String eval_id="";
			// Diagnosis var declaration.
			String term_set_id_diag = "";
			String term_code_diag = "";
			String term_code_srl_no_diag = "";
			String dx_prog_pct = "";
			String DiagmsrID="";
			int diag_pct = 0;
			int diag_count = 0;
			StringBuffer sb_diag = new StringBuffer();
			// End ofDiagnosis.
			// Goal var declaration.
			String term_set_id_goal = "";
			String term_code_goal = "";
			String term_code_srl_no_goal = "";
			String goal_srl_no = "";
			String goal_code = "";
			String goal_prog_pct = "";
			String GoalmsrID="";
			int goal_pct = 0;
			int goal_count = 0;
			int eval_inserted=-1;
			StringBuffer sb_goal = new StringBuffer();
			// End of Goal.
			// Outcome var declaration.
			String term_set_id_outcome = "";
			String term_code_outcome = "";
			String term_code_srl_no_outcome = "";
			String goal_code_outcome = "";
			String goal_srl_no_outcome = "";
			String group_id = "";
			String outcome_code = "";
			String outcome_prog_pct = "";
			String outcome_srl_no = "";
			String OutcomemsrID="";
			// End of Outcome.		
			String eval_id_sql_select="select cp_eval_seq.nextval eval_id from dual";
			String eval_sql_insert="insert into cp_pat_care_plan_eval (md_care_plan_id, care_plan_id, eval_id, eval_datetime, eval_by, remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			// Queries of Diagnosis.
			String diag_sql_update = "update cp_pat_care_plan_term_code set last_eval_datetime = sysdate,last_eval_by = ?, last_progress_percent = ?, status = decode(?,100,'R',status),eval_id=?,LAST_EVAL_TERM_CODE_MSR_ID=? where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ?";
			String diag_sql_insert = "insert into cp_pat_term_code_eval(md_care_plan_id,care_plan_id,term_set_id,		term_code,term_code_srl_no,last_eval_datetime,last_eval_by,	 progress_percent, eval_id, added_by_id,added_date,added_at_ws_no,	added_facility_id,modified_by_id,modified_date,	modified_at_ws_no,modified_facility_id,TERM_CODE_MSR_ID)values(?,?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			String diag_sql_update_prdiag = "update pr_diagnosis set curr_status = 'R', curr_status_date = sysdate, modified_by_id = 'CP*' where patient_id = ? and term_set_id = ? and term_code = ? and curr_status = 'A'";
			// End of Quries Diagnosis.
			// Queries of Goals.
			String goal_sql_update = "update cp_pat_care_plan_goal set last_eval_datetime = sysdate,last_eval_by = ?,last_progress_percent = ?,status = decode(?,100,'A',0,'N','P'),eval_id=?,LAST_EVAL_GOAL_MSR_ID=? where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ? and goal_code = ?";
			String goal_sql_insert = "insert into cp_pat_goal_eval(md_care_plan_id,care_plan_id ,term_set_id, term_code, term_code_srl_no, goal_code,goal_srl_no, last_eval_datetime, last_eval_by, progress_percent, eval_id, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,GOAL_MSR_ID) values (?,?,?,?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			// End of Queries Goal.
			// Queries of Outcome.
			String outcome_sql_update = "update cp_pat_care_plan_outcome set last_eval_datetime = sysdate,last_eval_by = ?, last_progress_percent = ?,status = decode(?,100,'A',0,'N','P'),eval_id=?,LAST_EVAL_OUTCOME_MSR_ID=? where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ? and goal_code = ?  and group_id = ? and outcome_code = ?";
			String outcome_sql_insert = "insert into cp_pat_outcome_eval(md_care_plan_id,care_plan_id,term_set_id,term_code,term_code_srl_no,goal_code,goal_srl_no,outcome_code,outcome_srl_no,last_eval_datetime,last_eval_by,progress_percent, eval_id, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,OUTCOME_MSR_ID) values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			String pat_care_plan_update_sql="";
			pat_care_plan_update_sql = "update cp_pat_care_plan set last_eval_datetime = sysdate,last_eval_by = ?, current_status=decode(?,'A',current_status,?), status_facility_id=?, status_encounter_id=?, status_pract_id=?,	status_date=sysdate, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=?,eval_id=? where md_care_plan_id = ? and care_plan_id = ?";
			// End of Quries Outcome.
			// Quries used in both Goal & Diagnosis.
			String diag_sql_select = "select intervention_code from cp_pat_care_plan_intvn where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ? and goal_code = nvl(?,goal_code) and status in ('O','P')";
			String diag_sql_update_intvn = "update cp_pat_care_plan_intvn set status = 'D', status_date = sysdate where md_care_plan_id = ? and care_plan_id = ?  and term_set_id = ? and term_code = ? and goal_code = nvl(?,goal_code) and status in ('O','P') and appl_yn = 'Y'";
			String diag_sql_update_intvn_dtl = "update cp_pat_care_plan_intvn_dtl set status = 'D',status_date = sysdate where md_care_plan_id = ? and care_plan_id = ? and intervention_code in (select intervention_code from cp_pat_care_plan_intvn where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ? and goal_code = nvl(?,goal_code) and status in ('O','P')) and status in ('O','P') and end_date >= trunc(sysdate)";
			String diag_sql_update_task_list = "update ca_pat_task_list set status = 'D',  status_date = sysdate where patient_id = ? and md_care_plan_id = ?  and care_plan_id = ?  and task_code in (select intervention_code from cp_pat_care_plan_intvn where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ? and term_code = ? and goal_code = nvl(?,goal_code) and status in ('O','P')) and status in ('O') ";
			String diag_goal_sql_update = "update cp_pat_care_plan_outcome  set status = 'D',status_date = sysdate where md_care_plan_id = ? and care_plan_id = ? and term_set_id = ?	   and term_code = ? and goal_code = nvl(?,goal_code) and status in ('O','P') and appl_yn = 'Y'";
			// End of Quries in Goal & Diagnosis.
			//insertion in cp_pat_care_plan_eval
			pstmt = con.prepareStatement(eval_id_sql_select);
			rs_eval_id = pstmt.executeQuery();
			while (rs_eval_id != null && rs_eval_id.next()) 
			{
				eval_id=rs_eval_id.getString("eval_id");
			}
			if(rs_eval_id!=null) 
				rs_eval_id.close();
			if(pstmt!=null){ 
				pstmt.close();
				pstmt=null;
			}
			pstmt_insert_eval=con.prepareStatement(eval_sql_insert);
			pstmt_insert_eval.setString(1,md_plan_id);
			pstmt_insert_eval.setString(2,care_plan_id);
			pstmt_insert_eval.setString(3,eval_id);
			pstmt_insert_eval.setString(4,pract_id);
			pstmt_insert_eval.setString(5,eval_remarks);
			pstmt_insert_eval.setString(6,added_by_id);
			pstmt_insert_eval.setString(7,added_at_ws_no);
			pstmt_insert_eval.setString(8,added_facility_id);
			pstmt_insert_eval.setString(9,modified_by_id);
			pstmt_insert_eval.setString(10,modified_at_ws_no);
			pstmt_insert_eval.setString(11,modified_facility_id);
			eval_inserted = pstmt_insert_eval.executeUpdate();	
			if(pstmt_insert_eval!=null){ 
				pstmt_insert_eval.close();
				pstmt_insert_eval=null;
			}
			if(eval_inserted<0)
			{
				con.rollback();
			}
			else
			{
				// Insertion of Diagnosis.
				if(diag_arr.size()>0)
				{


				pstmt						= con.prepareStatement(diag_sql_update);
				pstmt_insert_diag			= con.prepareStatement(diag_sql_insert);
				pstmt_diag_goal_diag		= con.prepareStatement(diag_goal_sql_update);
				pstmt_update_diag_prdiag	= con.prepareStatement(diag_sql_update_prdiag);
				pstmt_select_diag			= con.prepareStatement(diag_sql_select);
				pstmt_update_diag_task_list = con.prepareStatement(diag_sql_update_task_list);
				pstmt_update_diag_intvn_dtl = con.prepareStatement(diag_sql_update_intvn_dtl);
				pstmt_update_diag_intvn		= con.prepareStatement(diag_sql_update_intvn);


					for(int i=0;i<diag_arr.size();i++)
					{
						sb_diag = new StringBuffer();
						diag_count = 0;
						diag_map = (HashMap) diag_arr.get(i);
						term_set_id_diag = (String) diag_map.get("TERM_SET_ID_DIAG");
						term_code_diag = (String) diag_map.get("TERM_CODE_DIAG");
						term_code_srl_no_diag = (String) diag_map.get("TERM_CODE_SRL_NO_DIAG");
						dx_prog_pct = (String) diag_map.get("DX_PROG_PCT");
						diag_pct = Integer.parseInt(dx_prog_pct);
						DiagmsrID=(String)diag_map.get("DIAGMSRID");
						// Update cp_pat_care_plan_term_code.
						//pstmt = con.prepareStatement(diag_sql_update);
						pstmt.setString(1,pract_id);
						pstmt.setString(2,dx_prog_pct);
						pstmt.setString(3,dx_prog_pct);
						pstmt.setString(4,eval_id);
						pstmt.setString(5,DiagmsrID);
						pstmt.setString(6,md_plan_id);
						pstmt.setString(7,care_plan_id);
						pstmt.setString(8,term_set_id_diag);
						pstmt.setString(9,term_code_diag);
						pstmt.executeUpdate();
						if(pstmt!=null){
							pstmt.close();
							pstmt=null;
						}
						// End of updation cp_pat_care_plan_term_code.
						// Insertion into cp_pat_term_code_eval.
						//pstmt_insert_diag = con.prepareStatement(diag_sql_insert);
						pstmt_insert_diag.setString(1,md_plan_id);
						pstmt_insert_diag.setString(2,care_plan_id);
						pstmt_insert_diag.setString(3,term_set_id_diag);
						pstmt_insert_diag.setString(4,term_code_diag);
						pstmt_insert_diag.setString(5,term_code_srl_no_diag);
						pstmt_insert_diag.setString(6,pract_id);
						pstmt_insert_diag.setString(7,dx_prog_pct);
						pstmt_insert_diag.setString(8,eval_id);
						pstmt_insert_diag.setString(9,added_by_id);
						pstmt_insert_diag.setString(10,added_at_ws_no);
						pstmt_insert_diag.setString(11,added_facility_id);
						pstmt_insert_diag.setString(12,modified_by_id);
						pstmt_insert_diag.setString(13,modified_at_ws_no);
						pstmt_insert_diag.setString(14,modified_facility_id);
						pstmt_insert_diag.setString(15,DiagmsrID);
						pstmt_insert_diag.executeUpdate();
						//End of insertion into cp_pat_term_code_eval.
						// If Diagnosis percentage is equal to 0.
						if(diag_pct==100)
						{
							// Updation of cp_pat_care_plan_outcome in Diagnosis.
							//pstmt_diag_goal_diag = con.prepareStatement(diag_goal_sql_update);
							pstmt_diag_goal_diag.setString(1,md_plan_id);
							pstmt_diag_goal_diag.setString(2,care_plan_id);
							pstmt_diag_goal_diag.setString(3,term_set_id_diag);
							pstmt_diag_goal_diag.setString(4,term_code_diag);
							pstmt_diag_goal_diag.setString(5,goal_code);
							pstmt_diag_goal_diag.executeUpdate();
							// End of cp_pat_care_plan_outcome updation in Diagnosis.

							// Updation of pr_diagnosis in Diagnosis.
							//pstmt_update_diag_prdiag = con.prepareStatement(diag_sql_update_prdiag);
							pstmt_update_diag_prdiag.setString(1,patient_id);
							pstmt_update_diag_prdiag.setString(2,term_set_id_diag);
							pstmt_update_diag_prdiag.setString(3,term_code_diag);
							pstmt_update_diag_prdiag.executeUpdate();
							// End of Updating pr_diagnosis in Diagnosis.

							// Select query execution for interventions from cp_pat_care_plan_intvn.
							//pstmt_select_diag = con.prepareStatement(diag_sql_select);
							pstmt_select_diag.setString(1,md_plan_id);
							pstmt_select_diag.setString(2,care_plan_id);
							pstmt_select_diag.setString(3,term_set_id_diag);
							pstmt_select_diag.setString(4,term_code_diag);
							pstmt_select_diag.setString(5,goal_code);
							rs_select_diag = pstmt_select_diag.executeQuery();
							if(rs_select_diag!=null)
							{
								while(rs_select_diag.next())
								{
									if(diag_count==0)
										sb_diag.append("'"+rs_select_diag.getString("intervention_code")+"'");
									else
										sb_diag.append(","+"'"+rs_select_diag.getString("intervention_code")+"'");
									diag_count++;
								}
								if(rs_select_diag!=null){ 
									rs_select_diag.close();
									rs_select_diag=null;
									}
								if(pstmt_select_diag!=null){
									pstmt_select_diag.close();
									pstmt_select_diag=null;
									}
							}
							// End of select execution.
							if(!sb_diag.toString().equals(""))
							{
								// Updation of ca_pat_task_list in Diagnosis.
								//pstmt_update_diag_task_list = con.prepareStatement(diag_sql_update_task_list);
								pstmt_update_diag_task_list.setString(1,patient_id);
								pstmt_update_diag_task_list.setString(2,md_plan_id);
								pstmt_update_diag_task_list.setString(3,care_plan_id);
								pstmt_update_diag_task_list.setString(4,md_plan_id);
								pstmt_update_diag_task_list.setString(5,care_plan_id);
								pstmt_update_diag_task_list.setString(6,term_set_id_diag);
								pstmt_update_diag_task_list.setString(7,term_code_diag);
								pstmt_update_diag_task_list.setString(8,goal_code);
								int inserted=	pstmt_update_diag_task_list.executeUpdate();
								if(inserted==0)
									throw new Exception("Diag Not inserted");
								// Updation of cp_pat_care_plan_intvn_dtl in Diagnosis.
								//pstmt_update_diag_intvn_dtl = con.prepareStatement(diag_sql_update_intvn_dtl);
								pstmt_update_diag_intvn_dtl.setString(1,md_plan_id);
								pstmt_update_diag_intvn_dtl.setString(2,care_plan_id);
								pstmt_update_diag_intvn_dtl.setString(3,md_plan_id);
								pstmt_update_diag_intvn_dtl.setString(4,care_plan_id);
								pstmt_update_diag_intvn_dtl.setString(5,term_set_id_diag);
								pstmt_update_diag_intvn_dtl.setString(6,term_code_diag);
								pstmt_update_diag_intvn_dtl.setString(7,goal_code);
								pstmt_update_diag_intvn_dtl.executeUpdate();
								// End of Updating cp_pat_care_plan_intvn_dtl in Diagnosis.
							// Updation of cp_pat_care_plan_intvn in Diagnosis.
							//pstmt_update_diag_intvn = con.prepareStatement(diag_sql_update_intvn);
							pstmt_update_diag_intvn.setString(1,md_plan_id);
							pstmt_update_diag_intvn.setString(2,care_plan_id);
							pstmt_update_diag_intvn.setString(3,term_set_id_diag);
							pstmt_update_diag_intvn.setString(4,term_code_diag);
							pstmt_update_diag_intvn.setString(5,goal_code);
							pstmt_update_diag_intvn.executeUpdate();
							// End of updation of cp_pat_care_plan_intvn in Diagnosis.

								// End of Updating ca_pat_task_list in Diagnosis.
							}
						}
						// End of chking percentange.
					}

					if(pstmt!=null){
						pstmt.close();
						pstmt=null;
					}
					if(pstmt_insert_diag!=null){
						pstmt_insert_diag.close();
						pstmt_insert_diag=null;
					}

				   if(pstmt_diag_goal_diag!=null){
						pstmt_diag_goal_diag.close();
						pstmt_diag_goal_diag=null;
					}

					if(pstmt_update_diag_prdiag!=null){
						pstmt_update_diag_prdiag.close();
						pstmt_update_diag_prdiag=null;
					}
					if(pstmt_select_diag!=null){
						pstmt_select_diag.close();
						pstmt_select_diag=null;
					}
					if(pstmt_select_diag!=null){
						pstmt_update_diag_task_list.close();
						pstmt_update_diag_task_list=null;
					}
					if(pstmt_update_diag_intvn_dtl!=null){
						pstmt_update_diag_intvn_dtl.close();
						pstmt_update_diag_intvn_dtl=null;
					}
					if(pstmt_update_diag_intvn!=null){
						pstmt_update_diag_intvn.close();
						pstmt_update_diag_intvn=null;
					}						
							

				}
				// End of Diagnosis.
				// Insertion of Goal.


				


				if(goal_arr.size()>0)
				{
					pstmt_update_goal			= con.prepareStatement(goal_sql_update);
					pstmt_insert_goal			= con.prepareStatement(goal_sql_insert);
					pstmt_diag_goal_goal		= con.prepareStatement(diag_goal_sql_update);
					pstmt_select_goal			= con.prepareStatement(diag_sql_select);
					pstmt_update_goal_task_list = con.prepareStatement(diag_sql_update_task_list);
					pstmt_update_goal_intvn_dtl = con.prepareStatement(diag_sql_update_intvn_dtl);
					pstmt_update_goal_intvn		= con.prepareStatement(diag_sql_update_intvn);
					for(int j=0;j<goal_arr.size();j++)
					{
						sb_goal = new StringBuffer();
						goal_count = 0;
						goal_map = (HashMap) goal_arr.get(j);
						term_set_id_goal = (String) goal_map.get("TERM_SET_ID_GOAL");
						term_code_goal = (String) goal_map.get("TERM_CODE_GOAL");
						term_code_srl_no_goal = (String) goal_map.get("TERM_CODE_SRL_NO_GOAL");
						goal_srl_no = (String) goal_map.get("GOAL_SRL_NO");
						goal_code = (String) goal_map.get("GOAL_CODE");
						goal_prog_pct = (String) goal_map.get("GOAL_PROG_PCT");
						goal_pct = Integer.parseInt(goal_prog_pct);
						GoalmsrID=(String) goal_map.get("GOALMSRID");
						//System.err.println("GoalmsrID in ejb "+GoalmsrID);
						// Updation of cp_pat_care_plan_goal in Goal.
						//pstmt_update_goal = con.prepareStatement(goal_sql_update);
						pstmt_update_goal.setString(1,pract_id);
						pstmt_update_goal.setString(2,goal_prog_pct);
						pstmt_update_goal.setString(3,goal_prog_pct);
						pstmt_update_goal.setString(4,eval_id);
						pstmt_update_goal.setString(5,GoalmsrID);
						pstmt_update_goal.setString(6,md_plan_id);
						pstmt_update_goal.setString(7,care_plan_id);
						pstmt_update_goal.setString(8,term_set_id_goal);
						pstmt_update_goal.setString(9,term_code_goal);
						pstmt_update_goal.setString(10,goal_code);
						pstmt_update_goal.executeUpdate();
						// End of updation of Goal.
						// Insertion of cp_pat_goal_eval in Goal.
						//pstmt_insert_goal = con.prepareStatement(goal_sql_insert);
						pstmt_insert_goal.setString(1,md_plan_id);
						pstmt_insert_goal.setString(2,care_plan_id);
						pstmt_insert_goal.setString(3,term_set_id_goal);
						pstmt_insert_goal.setString(4,term_code_goal);
						pstmt_insert_goal.setString(5,term_code_srl_no_goal);
						pstmt_insert_goal.setString(6,goal_code);
						pstmt_insert_goal.setString(7,goal_srl_no);
						pstmt_insert_goal.setString(8,pract_id);
						pstmt_insert_goal.setString(9,goal_prog_pct);
						pstmt_insert_goal.setString(10,eval_id);
						pstmt_insert_goal.setString(11,added_by_id);
						pstmt_insert_goal.setString(12,added_at_ws_no);
						pstmt_insert_goal.setString(13,added_facility_id);
						pstmt_insert_goal.setString(14,modified_by_id);
						pstmt_insert_goal.setString(15,modified_at_ws_no);
						pstmt_insert_goal.setString(16,modified_facility_id);
						pstmt_insert_goal.setString(17,GoalmsrID);
						pstmt_insert_goal.executeUpdate();
						// If Diagnosis percentage is equal to 0.
						if((goal_pct==100) || (goal_pct==0))
						{
							// Updation of cp_pat_care_plan_outcome in Goal.
							//pstmt_diag_goal_goal = con.prepareStatement(diag_goal_sql_update);
							pstmt_diag_goal_goal.setString(1,md_plan_id);
							pstmt_diag_goal_goal.setString(2,care_plan_id);
							pstmt_diag_goal_goal.setString(3,term_set_id_diag);
							pstmt_diag_goal_goal.setString(4,term_code_diag);
							pstmt_diag_goal_goal.setString(5,goal_code);
							// End of cp_pat_care_plan_outcome updation in Goal.

							// Select query execution for interventions from cp_pat_care_plan_intvn.
							//pstmt_select_goal = con.prepareStatement(diag_sql_select);
							pstmt_select_goal.setString(1,md_plan_id);
							pstmt_select_goal.setString(2,care_plan_id);
							pstmt_select_goal.setString(3,term_set_id_goal);
							pstmt_select_goal.setString(4,term_code_goal);
							pstmt_select_goal.setString(5,goal_code);
							rs_select_goal = pstmt_select_goal.executeQuery();
							if(rs_select_goal!=null)
							{
								while(rs_select_goal.next())
								{
									if(goal_count==0)
										sb_goal.append("'"+rs_select_goal.getString("intervention_code")+"'");
									else
										sb_goal.append(","+"'"+rs_select_goal.getString("intervention_code")+"'");

									goal_count++;
								}
								if(rs_select_goal!=null){
									rs_select_goal.close();
									rs_select_goal=null;
								}
								if(pstmt_select_goal!=null){
									pstmt_select_goal.close();
									pstmt_select_goal=null;
								}
							}
							// End of select execution.
							if(!sb_goal.toString().equals(""))
							{
								// Updation of ca_pat_task_list in Diagnosis.
								//pstmt_update_goal_task_list = con.prepareStatement(diag_sql_update_task_list);
								pstmt_update_goal_task_list.setString(1,patient_id);
								pstmt_update_goal_task_list.setString(2,md_plan_id);
								pstmt_update_goal_task_list.setString(3,care_plan_id);
								pstmt_update_goal_task_list.setString(4,md_plan_id);
								pstmt_update_goal_task_list.setString(5,care_plan_id);
								pstmt_update_goal_task_list.setString(6,term_set_id_goal);
								pstmt_update_goal_task_list.setString(7,term_code_goal);
								pstmt_update_goal_task_list.setString(8,goal_code);
								pstmt_update_goal_task_list.executeUpdate();
								// End of Updating ca_pat_task_list in Diagnosis.

								// Updation of cp_pat_care_plan_intvn_dtl in Diagnosis.
								//pstmt_update_goal_intvn_dtl = con.prepareStatement(diag_sql_update_intvn_dtl);
								pstmt_update_goal_intvn_dtl.setString(1,md_plan_id);
								pstmt_update_goal_intvn_dtl.setString(2,care_plan_id);
								pstmt_update_goal_intvn_dtl.setString(3,md_plan_id);
								pstmt_update_goal_intvn_dtl.setString(4,care_plan_id);
								pstmt_update_goal_intvn_dtl.setString(5,term_set_id_goal);
								pstmt_update_goal_intvn_dtl.setString(6,term_code_goal);
								pstmt_update_goal_intvn_dtl.setString(7,goal_code);
								pstmt_update_goal_intvn_dtl.executeUpdate();
								// End of Updating cp_pat_care_plan_intvn_dtl in Diagnosis.

								// Updation of cp_pat_care_plan_intvn in Goal.
								//pstmt_update_goal_intvn = con.prepareStatement(diag_sql_update_intvn);
								pstmt_update_goal_intvn.setString(1,md_plan_id);
								pstmt_update_goal_intvn.setString(2,care_plan_id);
								pstmt_update_goal_intvn.setString(3,term_set_id_goal);
								pstmt_update_goal_intvn.setString(4,term_code_goal);
								pstmt_update_goal_intvn.setString(5,goal_code);
								pstmt_update_goal_intvn.executeUpdate();
								// End of updation of cp_pat_care_plan_intvn in Goal.

							}
						}
						// End of chking percentange.
					}

					if(pstmt_update_goal!=null){
						pstmt_update_goal.close();
						pstmt_update_goal=null;
					}
					if(pstmt_insert_goal!=null){
						pstmt_insert_goal.close();
						pstmt_insert_goal=null;
					}
					if(pstmt_diag_goal_goal!=null){
						pstmt_diag_goal_goal.close();
						pstmt_diag_goal_goal=null;
					}
					if(pstmt_select_goal!=null){
						pstmt_select_goal.close();
						pstmt_select_goal=null;
					}
					if(pstmt_update_goal_task_list!=null){
						pstmt_update_goal_task_list.close();
						pstmt_update_goal_task_list=null;
					}
					if(pstmt_update_goal_intvn_dtl!=null){
						pstmt_update_goal_intvn_dtl.close();
						pstmt_update_goal_intvn_dtl=null;
					}
					if(pstmt_update_goal_intvn!=null){
						pstmt_update_goal_intvn.close();
						pstmt_update_goal_intvn=null;
					}	 
					 
							
				}
				// End of Insertion of Goal.
				// Insertion of Outcome.



				
				if(outcome_arr.size()>0)
				{

				pstmt_insert_outcome = con.prepareStatement(outcome_sql_insert);
				pstmt_update_outcome = con.prepareStatement(outcome_sql_update);



					for(int k=0;k<outcome_arr.size();k++)
					{
						outcome_map = (HashMap) outcome_arr.get(k);
						term_set_id_outcome = (String) outcome_map.get("TERM_SET_ID_OUTCOME");
						term_code_outcome = (String) outcome_map.get("TERM_CODE_OUTCOME");
						term_code_srl_no_outcome = (String) outcome_map.get("TERM_CODE_SRL_NO_OUTCOME");
						goal_srl_no_outcome = (String) outcome_map.get("GOAL_SRL_NO_OUTCOME");
						goal_code_outcome = (String) outcome_map.get("GOAL_CODE_OUTCOME");
						group_id = (String) outcome_map.get("GROUP_ID");
						outcome_code = (String) outcome_map.get("OUTCOME_CODE");
						outcome_prog_pct = (String) outcome_map.get("OUTCOME_PROG_PCT");
						outcome_srl_no = (String) outcome_map.get("OUTCOME_SRL_NO");
						OutcomemsrID=(String) outcome_map.get("OUTCOMEMSRID");
//						System.err.println("OutcomemsrID in ejb"+OutcomemsrID);
						// Updation of cp_pat_care_plan_outcome in Outcome.
						//pstmt_update_outcome = con.prepareStatement(outcome_sql_update);
						pstmt_update_outcome.setString(1,pract_id);
						pstmt_update_outcome.setString(2,outcome_prog_pct);
						pstmt_update_outcome.setString(3,outcome_prog_pct);
						pstmt_update_outcome.setString(4,eval_id);
						pstmt_update_outcome.setString(5,OutcomemsrID);
						pstmt_update_outcome.setString(6,md_plan_id);
						pstmt_update_outcome.setString(7,care_plan_id);
						pstmt_update_outcome.setString(8,term_set_id_outcome);
						pstmt_update_outcome.setString(9,term_code_outcome);
						pstmt_update_outcome.setString(10,goal_code_outcome);
						pstmt_update_outcome.setString(11,group_id);
						pstmt_update_outcome.setString(12,outcome_code);
						pstmt_update_outcome.executeUpdate();
						// End of Outcome Updation.
						// Insert in cp_pat_outcome_eval of Outcome.
					//	pstmt_insert_outcome = con.prepareStatement(outcome_sql_insert);
						pstmt_insert_outcome.setString(1,md_plan_id);
						pstmt_insert_outcome.setString(2,care_plan_id);
						pstmt_insert_outcome.setString(3,term_set_id_outcome);
						pstmt_insert_outcome.setString(4,term_code_outcome);
						pstmt_insert_outcome.setString(5,term_code_srl_no_outcome);
						pstmt_insert_outcome.setString(6,goal_code_outcome);
						pstmt_insert_outcome.setString(7,goal_srl_no_outcome);
						pstmt_insert_outcome.setString(8,outcome_code);
						pstmt_insert_outcome.setString(9,outcome_srl_no);
						pstmt_insert_outcome.setString(10,pract_id);
						pstmt_insert_outcome.setString(11,outcome_prog_pct);
						pstmt_insert_outcome.setString(12,eval_id);
						pstmt_insert_outcome.setString(13,added_by_id);
						pstmt_insert_outcome.setString(14,added_at_ws_no);
						pstmt_insert_outcome.setString(15,added_facility_id);
						pstmt_insert_outcome.setString(16,modified_by_id);
						pstmt_insert_outcome.setString(17,modified_at_ws_no);
						pstmt_insert_outcome.setString(18,modified_facility_id);
						pstmt_insert_outcome.setString(18,modified_facility_id);
						pstmt_insert_outcome.setString(19,OutcomemsrID);
						pstmt_insert_outcome.executeUpdate();
						// End of insertion into cp_pat_outcome_eval of Outcome.
					}


					if(pstmt_insert_outcome!=null){
						pstmt_insert_outcome.close();
						pstmt_insert_outcome=null;
					}
					if(pstmt_update_outcome!=null){
						pstmt_update_outcome.close();
						pstmt_update_outcome=null;
					}	
				}
				// End of Outcome.
//---
				// Updation of cp_pat_care_plan.
					pstmt_update_outcome_eval = con.prepareStatement(pat_care_plan_update_sql);
					pstmt_update_outcome_eval.setString(1,pract_id);
					pstmt_update_outcome_eval.setString(2,eval_status);
					pstmt_update_outcome_eval.setString(3,eval_status);
					pstmt_update_outcome_eval.setString(4,modified_facility_id);
					pstmt_update_outcome_eval.setString(5,encounter_id);
					pstmt_update_outcome_eval.setString(6,pract_id);
					pstmt_update_outcome_eval.setString(7,modified_by_id);
					pstmt_update_outcome_eval.setString(8,modified_at_ws_no);
					pstmt_update_outcome_eval.setString(9,modified_facility_id);
					pstmt_update_outcome_eval.setString(10,eval_id);
					pstmt_update_outcome_eval.setString(11,md_plan_id);
					pstmt_update_outcome_eval.setString(12,care_plan_id);
					pstmt_update_outcome_eval.executeUpdate();
				// End of updation in cp_pat_care_plan of Outcome.
//---
				con.commit();
			}
			tempHash.put("status",new Boolean(true));
			tempHash.put("error",stringbuffer.toString());
			if(con!=null)
				ConnectionManager.returnConnection(con, properties);
		}
        catch(Exception exception)
        {
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
			tempHash.put("status",new Boolean(false));
			tempHash.put("error",stringbuffer.toString());
			try
			{
				con.rollback();
			}
			catch(Exception es)
			{
				es.printStackTrace();		
			}
        }
        finally
        {
            if(con != null)
			try
			{
				if(pstmt!=null){
					pstmt.close();
					pstmt=null;
				}
				if(rs_select_diag!=null){
					rs_select_diag.close();
					rs_select_diag=null;
				}
				if(rs_select_goal!=null){
					rs_select_goal.close();
					rs_select_goal=null;
				}
				if(pstmt_update_goal!=null){
					pstmt_update_goal.close();
					pstmt_update_goal=null;
				}
				if(pstmt_diag_goal_goal!=null) {
					pstmt_diag_goal_goal.close();
					pstmt_diag_goal_goal=null;
				}
				if(pstmt_diag_goal_diag!=null){
					pstmt_diag_goal_diag.close();
					pstmt_diag_goal_diag=null;
				}
				if(pstmt_update_outcome!=null) {
					pstmt_update_outcome.close();
					pstmt_update_outcome=null;
				}
				if(pstmt_update_outcome_eval!=null){
					pstmt_update_outcome_eval.close();
					pstmt_update_outcome_eval=null;
				}
				if(pstmt_insert_diag!=null){
					pstmt_insert_diag.close();
					pstmt_insert_diag=null;

				}
				if(pstmt_insert_goal!=null) {
					pstmt_insert_goal.close();
					pstmt_insert_goal=null;
				}
				if(pstmt_insert_outcome!=null){
					pstmt_insert_outcome.close();
					pstmt_insert_outcome=null;
				}
				if(pstmt_update_diag_intvn!=null) {
					pstmt_update_diag_intvn.close();
					pstmt_update_diag_intvn=null;
				}
				if(pstmt_update_goal_intvn!=null){
					pstmt_update_goal_intvn.close();
					pstmt_update_goal_intvn=null;

				}
				if(pstmt_update_diag_intvn_dtl!=null){
					pstmt_update_diag_intvn_dtl.close();
					pstmt_update_diag_intvn_dtl=null;
				}
				if(pstmt_update_goal_intvn_dtl!=null){
					pstmt_update_goal_intvn_dtl.close();
					pstmt_update_goal_intvn_dtl=null;
				}
				if(pstmt_update_diag_task_list!=null){ 
					pstmt_update_diag_task_list.close();
					pstmt_update_diag_task_list=null;
				}
				if(pstmt_update_goal_task_list!=null){
					pstmt_update_goal_task_list.close();
					pstmt_update_goal_task_list=null;
				}
				if(pstmt_select_diag!=null) {
					pstmt_select_diag.close();
					pstmt_select_diag=null;
				}
				if(pstmt_select_goal!=null){
					pstmt_select_goal.close();
					pstmt_select_goal=null;
				}
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2) 
			{
				System.err.println(exception2.toString());
			}
        }
		return tempHash;
    }
}
