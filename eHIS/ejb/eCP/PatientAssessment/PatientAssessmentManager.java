/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 19/11/2005.
package eCP.PatientAssessment;

import java.sql.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="PatientAssessment"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatientAssessment"
*	local-jndi-name="PatientAssessment"
*	impl-class-name="eCP.PatientAssessment.PatientAssessmentManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.PatientAssessment.PatientAssessmentLocal"
*	remote-class="eCP.PatientAssessment.PatientAssessmentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.PatientAssessment.PatientAssessmentLocalHome"
*	remote-class="eCP.PatientAssessment.PatientAssessmentHome"
*	generate= "local,remote"
*
*
*/
public class PatientAssessmentManager implements SessionBean
{
	Connection con;
	String locale="";
	public PatientAssessmentManager()
	{
		con = null;
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
	public HashMap insertPatientAssessment(Properties p, HashMap assessMap,ArrayList diagList) 
	{
		HashMap valuesMap = new HashMap();
		Hashtable msgTable = new Hashtable();

		String cpPatAssessSQL = "";

		//Statement stmt =null;
		PreparedStatement pstmt = null;
		PreparedStatement ps_active = null;

		//ResultSet rs = null;
		ResultSet res_active=null;
		

		int result = 0;
		boolean flag_ins = false;

		try
		{
			con = ConnectionManager.getConnection(p);
			
			String status_flag = (String) assessMap.get("status_flag");
			String patient_id = (String) assessMap.get("patient_id");
			String login_user_id = (String) assessMap.get("login_user_id");
			String abnormal_categ = (String) assessMap.get("abnormal_categ");			
			String chk_val_hid = (String) assessMap.get("chk_val_hid");
			String facility_id = (String) assessMap.get("facility_id");
			String encounter_id = (String) assessMap.get("encounter_id");
			String accession_no = (String) assessMap.get("accession_no");
			int assess_ref_no = Integer.parseInt((String) assessMap.get("assess_ref_no"));
			String assess_pract_id = (String) assessMap.get("assess_pract_id");
			String ua_dep_code = (String) assessMap.get("ua_dep_code");
			String ss_dep_code = (String) assessMap.get("ss_dep_code");
			String added_by_id = (String) assessMap.get("added_by_id");
			String added_at_ws_no = (String) assessMap.get("added_at_ws_no");
			String added_by_facility_id = (String) assessMap.get("added_by_facility_id");
			String modified_by_id = (String) assessMap.get("modified_by_id");
			String modified_at_ws_no = (String) assessMap.get("modified_at_ws_no");
			String modified_by_facility_id = (String) assessMap.get("modified_by_facility_id");
			locale=(String) assessMap.get("locale");
			if(!status_flag.equals("4"))
			{
				try
				{
					cpPatAssessSQL = " insert into CP_PAT_ASSESS (ASSESS_REF_NO, "+
						" FACILITY_ID, "+
						" ENCOUNTER_ID, "+
						" ACCESSION_NO, "+
						" ASSESS_PRACT_ID, "+
						" ASSESS_DATE, "+
						" SS_DEPENDENCY_CODE, "+
						" UA_DEPENDENCY_CODE, "+
						" ADDED_BY_ID, "+
						" ADDED_DATE, "+
						" ADDED_AT_WS_NO, "+
						" ADDED_FACILITY_ID, "+
						" MODIFIED_BY_ID, "+
						" MODIFIED_DATE, "+
						" MODIFIED_AT_WS_NO, "+
						" MODIFIED_FACILITY_ID "+
						" )values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
												
					pstmt = con.prepareStatement(cpPatAssessSQL);
					pstmt.setInt(1,assess_ref_no);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,encounter_id);
					pstmt.setString(4,accession_no);
					pstmt.setString(5,assess_pract_id);
					pstmt.setString(6,ss_dep_code);
					pstmt.setString(7,ua_dep_code);
					pstmt.setString(8,added_by_id);
					pstmt.setString(9,added_at_ws_no);
					pstmt.setString(10,added_by_facility_id);
					pstmt.setString(11,modified_by_id);
					pstmt.setString(12,modified_at_ws_no);
					pstmt.setString(13,modified_by_facility_id);

					result = pstmt.executeUpdate();

					if(result == 1)
					{
						msgTable = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
						valuesMap.put("message",(String)msgTable.get("message"));
						flag_ins = true;
						con.commit();
					}
					else
					{
						con.rollback();
						valuesMap.put("error","Transaction could not be completed");
					}
					if(pstmt != null) 
					{
						pstmt.close();
						//pstmt = null;
					}
				}//end of try-insert-NotAuthorized
				catch(Exception e)
				{
					e.printStackTrace(System.err);
				}
				//valuesMap.put("inserted",new Boolean (flag_ins));
				//return valuesMap;
			}//end of if not authorized
			else if(status_flag.equals("4"))
			{
				String term_set_id = "";
				String term_code = "";
				String flag_ss_ua = "";
				String stringLit = "A";
				String error = "";
				String assessAbnCateg = "";
				String res_curr_active = "";
				int mapSize = 0;
				boolean flag = true;

				StringTokenizer chkToken = null;
				StringTokenizer categToken = null;

				categToken = new StringTokenizer(abnormal_categ,"~");
				while(categToken.hasMoreTokens())
				{
					if(assessAbnCateg.equals(""))
						assessAbnCateg =assessAbnCateg + ("'" + assessAbnCateg + categToken.nextToken() + "'");
					else
						assessAbnCateg = assessAbnCateg +("'" + assessAbnCateg + categToken.nextToken() + "',");
				}
				if(assessAbnCateg.equals(""))
					assessAbnCateg = "''";

				String sql_active = "SELECT 1  FROM pr_diagnosis WHERE patient_id = ? AND term_set_id = ?  AND term_code = ? AND curr_status = '"+stringLit+"' ";				
				ps_active = con.prepareStatement(sql_active);

				//String cpPatAssessSQL_auth = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assessAbnCateg.equals("")?"''":assessAbnCateg)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";

        		cpPatAssessSQL= "insert into CP_PAT_ASSESS_SS_TERM_CODE( "+
					" ASSESS_REF_NO, "+
					" TERM_SET_ID, "+
					" TERM_CODE, "+
					" ADDED_BY_ID, "+
					" ADDED_DATE, "+
					" ADDED_AT_WS_NO, "+
					" ADDED_FACILITY_ID, "+
					" MODIFIED_BY_ID, "+
					" MODIFIED_DATE, "+
					" MODIFIED_AT_WS_NO, "+
					" MODIFIED_FACILITY_ID "+
					" ) values ( ?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

				mapSize = 0;	
				pstmt = con.prepareStatement(cpPatAssessSQL);

				try
				{
					chkToken = new StringTokenizer(chk_val_hid,"||");
					while(chkToken.hasMoreTokens())
					{
						StringTokenizer diagToken = null;
						chkToken.nextToken();
						String keys = "";							
						keys = (String) diagList.get(mapSize);
						diagToken = new StringTokenizer(keys,"$");
						term_set_id = diagToken.nextToken();
						term_code = diagToken.nextToken();
						flag_ss_ua = diagToken.nextToken();
						
						ps_active.setString(1,patient_id);
						ps_active.setString(2,term_set_id);
						ps_active.setString(3,term_code);
						res_active = ps_active.executeQuery();

						while(res_active!= null && res_active.next())
						{
							res_curr_active = res_active.getString(1);
						}

						if(res_active!=null) res_active.close();
									
							if(flag_ss_ua.equals("SS"))
							{
								pstmt.setInt(1,assess_ref_no);
								pstmt.setString(2,term_set_id);
								pstmt.setString(3,term_code);
								pstmt.setString(4,login_user_id);
								pstmt.setString(5,added_at_ws_no);
								pstmt.setString(6,facility_id);
								pstmt.setString(7,login_user_id);
								pstmt.setString(8,added_at_ws_no);
								pstmt.setString(9,facility_id);
								pstmt.executeUpdate();
							}							
							mapSize++;	

					}//end of while
					if(ps_active != null) 
					{
						ps_active.close();
						//ps_active = null;
					}
					if(pstmt != null) 
					{
						pstmt.close();
						//pstmt = null;
					}

					if(flag)
					{
						if(pstmt !=null) pstmt.close();
						cpPatAssessSQL = "";

						chkToken = new StringTokenizer(chk_val_hid,"||");
						cpPatAssessSQL= "insert into CP_PAT_ASSESS_UA_TERM_CODE( "+
							" ASSESS_REF_NO, "+
							" TERM_SET_ID, "+
							" TERM_CODE, "+
							" ADDED_BY_ID, "+
							" ADDED_DATE, "+
							" ADDED_AT_WS_NO, "+
							" ADDED_FACILITY_ID, "+
							" MODIFIED_BY_ID, "+
							" MODIFIED_DATE, "+
							" MODIFIED_AT_WS_NO, "+
							" MODIFIED_FACILITY_ID "+
							" ) values ( ?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
						mapSize = 0;
						pstmt = con.prepareStatement(cpPatAssessSQL);
						ps_active = con.prepareStatement(sql_active);
					StringTokenizer diagToken = null;
					String keys = null;
					while(chkToken.hasMoreTokens())
						{
							String chkVal = chkToken.nextToken();
							if(chkVal.equals("Y"))
							{							
								diagToken = null;
								keys = "";							
								keys = (String) diagList.get(mapSize);
								diagToken = new StringTokenizer(keys,"$");							
								term_set_id = diagToken.nextToken();
								term_code = diagToken.nextToken();
								flag_ss_ua = diagToken.nextToken();

								ps_active.setString(1,patient_id);
								ps_active.setString(2,term_set_id);
								ps_active.setString(3,term_code);
								res_active = ps_active.executeQuery();
								while(res_active.next())
								{
									res_curr_active = res_active.getString(1);
								}
                                if(res_active!=null) res_active.close();

								if(res_curr_active.equals("1"))
								{				
									if(!term_set_id.equals("") && !term_code.equals(""))
									{	
										pstmt.setInt(1,assess_ref_no);
										pstmt.setString(2,term_set_id);
										pstmt.setString(3,term_code);
										pstmt.setString(4,login_user_id);
										pstmt.setString(5,added_at_ws_no);
										pstmt.setString(6,facility_id);
										pstmt.setString(7,login_user_id);
										pstmt.setString(8,added_at_ws_no);
										pstmt.setString(9,facility_id);
										pstmt.executeUpdate();	
									}
								}
								else
								{					
									Hashtable hTable=new Hashtable();
									hTable= MessageManager.getMessage(locale, "INCL_DIAG_INTO_PAT_PROFILE","CP");
									error = (String)hTable.get("message");
									flag= false;
									break;
								}
							}								
							mapSize++;
						}//end of while
                        if(ps_active!=null) 
						{
							ps_active.close();
							//ps_active = null;
						}
						if(pstmt!=null) 
						{
							pstmt.close();
							//pstmt = null;
						}
					}//end of if flag

					if(pstmt!=null) 
					{
						pstmt.close();
						//pstmt = null;
					}
					cpPatAssessSQL = "";

					if(flag)
					{
						cpPatAssessSQL = " insert into CP_PAT_ASSESS (ASSESS_REF_NO, "+
							" FACILITY_ID, "+
							" ENCOUNTER_ID, "+
							" ACCESSION_NO, "+
							" ASSESS_PRACT_ID, "+
							" ASSESS_DATE, "+
							" SS_DEPENDENCY_CODE, "+
							" UA_DEPENDENCY_CODE, "+
							" ADDED_BY_ID, "+
							" ADDED_DATE, "+
							" ADDED_AT_WS_NO, "+
							" ADDED_FACILITY_ID, "+
							" MODIFIED_BY_ID, "+
							" MODIFIED_DATE, "+
							" MODIFIED_AT_WS_NO, "+
							" MODIFIED_FACILITY_ID "+
							" )values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
												
				
						pstmt = con.prepareStatement(cpPatAssessSQL);
						pstmt.setInt(1,assess_ref_no);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,encounter_id);
						pstmt.setString(4,accession_no);
						pstmt.setString(5,assess_pract_id);
						pstmt.setString(6,ss_dep_code);
						pstmt.setString(7,ua_dep_code);
						pstmt.setString(8,added_by_id);
						pstmt.setString(9,added_at_ws_no);
						pstmt.setString(10,added_by_facility_id);
						pstmt.setString(11,modified_by_id);
						pstmt.setString(12,modified_at_ws_no);
						pstmt.setString(13,modified_by_facility_id);

						pstmt.executeUpdate();
						if(pstmt!=null) 
						{
							pstmt.close();
							//pstmt = null;
						}
						msgTable = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
						valuesMap.put("message",(String)msgTable.get("message"));
						flag_ins = true;
						con.commit();
					}//end of if flag
					else
					{
						con.rollback();
						valuesMap.put("error",error);
					}//end of else if flag
				}//end of try-insert-authorized
				catch(Exception e)
				{
					e.printStackTrace(System.err);
				}

			}//end of if authorized
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(res_active!=null) 
				{
					res_active.close();
					//res_active = null;
				}
				if(pstmt!=null) 
				{
					pstmt.close();
					//pstmt = null;
				}
				if(ps_active!=null) 
				{
					ps_active.close();
					//ps_active = null;
				}

				if(con != null) ConnectionManager.returnConnection(con, p);
			}
			catch(Exception e)
			{
					e.printStackTrace(System.err);
			}
		}
		valuesMap.put("status_ins",new Boolean(flag_ins));
		return valuesMap;
	}//end of insertPatientAssessment()

/*******************************************************************************/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public HashMap updatePatientAssessment(Properties p, HashMap assessMap,ArrayList diagList) 
	{
		HashMap valuesMap = new HashMap();
		Hashtable msgTable = new Hashtable();

		String cpPatAssessSQL = "";
		String assessAbnCateg = "";
		String stringLit = "A";
		String error = "";
		boolean flag = true;
		boolean flag_ins = false;

		int mapSize = 0;
		
		StringTokenizer chkToken = null;
		StringTokenizer categToken = null;

        PreparedStatement ps_active = null;
		PreparedStatement pstmt = null;
		PreparedStatement psPatDel  = null;
		PreparedStatement pstmt_auth = null;

		ResultSet res_auth = null;
		ResultSet res_active = null;

		try
		{
			con = ConnectionManager.getConnection(p);

			String assess_ref_no = (String) assessMap.get("assess_ref_no");
			String patient_id = (String) assessMap.get("patient_id");
			String login_user_id = (String) assessMap.get("login_user_id");
			String abnormal_categ = (String) assessMap.get("abnormal_categ");			
			String chk_val_hid = (String) assessMap.get("chk_val_hid");
			String facility_id = (String) assessMap.get("facility_id");
			String encounter_id = (String) assessMap.get("encounter_id");
			String accession_no = (String) assessMap.get("accession_no");
			String assess_pract_id = (String) assessMap.get("assess_pract_id");
			String ua_dep_code = (String) assessMap.get("ua_dep_code");
			String ss_dep_code = (String) assessMap.get("ss_dep_code");
			String added_at_ws_no = (String) assessMap.get("added_at_ws_no");
			locale=(String) assessMap.get("locale");
			String term_set_id = "";
			String term_code = "";
			String res_curr_active = "";

			String sql_active = "SELECT 1  FROM pr_diagnosis WHERE patient_id = ? AND term_set_id = ?  AND term_code = ? AND curr_status = '"+stringLit+"' ";	
			ps_active = con.prepareStatement(sql_active);

			String cp_pat_del = "delete CP_PAT_ASSESS_UA_TERM_CODE where assess_ref_no = ?";
			psPatDel = con.prepareStatement(cp_pat_del);
			psPatDel.setString(1,assess_ref_no);
			psPatDel.executeQuery();

			if(psPatDel!=null) psPatDel.close();

			cpPatAssessSQL= "insert into CP_PAT_ASSESS_UA_TERM_CODE( "+
				" ASSESS_REF_NO, "+
				" TERM_SET_ID, "+
				" TERM_CODE, "+
				" ADDED_BY_ID, "+
				" ADDED_DATE, "+
				" ADDED_AT_WS_NO, "+
				" ADDED_FACILITY_ID, "+
				" MODIFIED_BY_ID, "+
				" MODIFIED_DATE, "+
				" MODIFIED_AT_WS_NO, "+
				" MODIFIED_FACILITY_ID "+
				" ) values ( ?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt = con.prepareStatement(cpPatAssessSQL);

			mapSize = 0;
			chkToken = new StringTokenizer(chk_val_hid,"||");

			while(chkToken.hasMoreTokens())
			{
				String chkVal = chkToken.nextToken();

				if(chkVal.equals("Y"))
				{							
					StringTokenizer diagToken = null;
					String keys = "";							
					keys = (String) diagList.get(mapSize);
					diagToken = new StringTokenizer(keys,"$");
					term_set_id = diagToken.nextToken();
					term_code = diagToken.nextToken();

					ps_active.setString(1,patient_id);
					ps_active.setString(2,term_set_id);
					ps_active.setString(3,term_code);
					res_active = ps_active.executeQuery();
			
					while(res_active.next())
					{
						res_curr_active = res_active.getString(1);
					}

					if(res_active!=null) res_active.close();

					if(res_curr_active.equals("1"))
					{			

						if(!term_set_id.equals("") && !term_code.equals(""))
						{								
							pstmt.setString(1,assess_ref_no);
							pstmt.setString(2,term_set_id);
							pstmt.setString(3,term_code);
							pstmt.setString(4,login_user_id);
							pstmt.setString(5,added_at_ws_no);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,login_user_id);
							pstmt.setString(8,added_at_ws_no);
							pstmt.setString(9,facility_id);
							pstmt.executeUpdate();							
						}
						if(pstmt!=null) pstmt.close();
					}
					else
					{					
						//	error = term_code+" is not an active diagnosis";
						Hashtable hTable=new Hashtable();
						hTable= MessageManager.getMessage(locale, "INCL_DIAG_INTO_PAT_PROFILE","CP");
						error = (String)hTable.get("message");
						//error = "Please include selected diagnosis as part of Diagnosis profile and continue";
						flag = false;
						break;	
					}
				}				
				mapSize++;					
			}//end of while
            if(ps_active!=null) ps_active.close();

			if(pstmt !=null) pstmt.close();
			cpPatAssessSQL = ""; 

			if(flag)
			{
				cpPatAssessSQL = "insert into CP_PAT_ASSESS_SS_TERM_CODE( "+
				" ASSESS_REF_NO, "+
				" TERM_SET_ID, "+
				" TERM_CODE, "+
				" ADDED_BY_ID, "+
				" ADDED_DATE, "+
				" ADDED_AT_WS_NO, "+
				" ADDED_FACILITY_ID, "+
				" MODIFIED_BY_ID, "+
				" MODIFIED_DATE, "+
				" MODIFIED_AT_WS_NO, "+
				" MODIFIED_FACILITY_ID "+
				" ) values ( ?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			
				categToken = new StringTokenizer(abnormal_categ,"~");
				while(categToken.hasMoreTokens())
				{
					if(assessAbnCateg.equals(""))
						assessAbnCateg =assessAbnCateg + ("'" + assessAbnCateg + categToken.nextToken() + "'");
					else
						assessAbnCateg =assessAbnCateg + ("'" + assessAbnCateg + categToken.nextToken() + "',");
				}
				if(assessAbnCateg.equals(""))
					assessAbnCateg = "''";
				String cpPatAssessSQL_auth = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assessAbnCateg.equals("")?"''":assessAbnCateg)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";
							
				pstmt_auth = con.prepareStatement(cpPatAssessSQL_auth);
				pstmt = con.prepareStatement(cpPatAssessSQL);
				ps_active = con.prepareStatement(sql_active);

				res_auth = pstmt_auth.executeQuery();
				while(res_auth.next())
				{
					term_set_id = res_auth.getString(1);
					term_code = res_auth.getString(3);

					ps_active.setString(1,patient_id);
					ps_active.setString(2,term_set_id);
					ps_active.setString(3,term_code);
					res_active = ps_active.executeQuery();

					while(res_active.next())
					{
						res_curr_active = res_active.getString(1);
					}

					if(res_active!=null) res_active.close();

						pstmt.setString(1,assess_ref_no);
						pstmt.setString(2,term_set_id);
						pstmt.setString(3,term_code);
						pstmt.setString(4,login_user_id);
						pstmt.setString(5,added_at_ws_no);
						pstmt.setString(6,facility_id);
						pstmt.setString(7,login_user_id);
						pstmt.setString(8,added_at_ws_no);
						pstmt.setString(9,facility_id);
						pstmt.executeUpdate();	
				}
                if(ps_active!=null) ps_active.close();
			}//end of if flag

			if(pstmt !=null) pstmt.close();
			if(res_active !=null) res_active.close();
			if(ps_active !=null) ps_active.close();
			if(res_auth !=null) res_auth.close();

			cpPatAssessSQL = ""; 

			if(flag)
			{
				cpPatAssessSQL = " update CP_PAT_ASSESS set "+
				" FACILITY_ID = ? , "+
				" ENCOUNTER_ID = ? , "+
				" ACCESSION_NO = ? , "+
				" ASSESS_PRACT_ID = ?, "+
				" ASSESS_DATE = sysdate , "+
				" SS_DEPENDENCY_CODE = ? , "+
				" UA_DEPENDENCY_CODE = ? , "+
				" ADDED_BY_ID = ? , "+
				" ADDED_DATE = sysdate , "+
				" ADDED_AT_WS_NO = ? , "+
				" ADDED_FACILITY_ID = ? , "+
				" MODIFIED_BY_ID = ? , "+
				" MODIFIED_DATE = sysdate , "+
				" MODIFIED_AT_WS_NO = ? , "+
				" MODIFIED_FACILITY_ID = ? "+
				"where assess_ref_no = ?" ;

				pstmt = con.prepareStatement(cpPatAssessSQL);

				pstmt.setString(13,assess_ref_no);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,accession_no);
				pstmt.setString(4,assess_pract_id);
				pstmt.setString(5,ss_dep_code);
				pstmt.setString(6,ua_dep_code);
				pstmt.setString(7,login_user_id);
				pstmt.setString(8,added_at_ws_no);
				pstmt.setString(9,facility_id);
				pstmt.setString(10,login_user_id);
				pstmt.setString(11,added_at_ws_no);
				pstmt.setString(12,facility_id);
				pstmt.executeUpdate();

				if(pstmt !=null) pstmt.close();
				cpPatAssessSQL = "";

				msgTable = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
				valuesMap.put("message",(String)msgTable.get("message"));
				flag_ins = true;
				con.commit();
			}//end of if flag
			else
			{
				con.rollback();
				valuesMap.put("error",error);
			}

		}//end of try-update 
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(res_auth!=null) res_auth.close();
				if(res_active!=null) res_active.close();

				if(ps_active!=null) ps_active.close();
				if(pstmt!=null) pstmt.close();
				if(psPatDel!=null) psPatDel.close();
				if(pstmt_auth!=null) pstmt_auth.close();

				if(con != null) ConnectionManager.returnConnection(con, p);
			}
			catch(Exception e)
			{
					e.printStackTrace(System.err);
			}
		}
		valuesMap.put("status_ins",new Boolean(flag_ins));
		return valuesMap;		
	}//end of updatePatientAssessment()
};
