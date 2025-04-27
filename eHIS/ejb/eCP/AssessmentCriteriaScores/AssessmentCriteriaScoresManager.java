/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.AssessmentCriteriaScores;

import java.sql.*;
import java.util.Properties;
import java.util.HashMap;
import java.util.ArrayList;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
/**
*
* @ejb.bean
*	name="AssessmentCriteriaScores"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssessmentCriteriaScores"
*	local-jndi-name="AssessmentCriteriaScores"
*	impl-class-name="eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresLocal"
*	remote-class="eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresLocalHome"
*	remote-class="eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresHome"
*	generate= "local,remote"
*
*
*/
public class AssessmentCriteriaScoresManager implements SessionBean
{
	Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt_num = null;
    PreparedStatement pstmt_list = null;
    PreparedStatement pstmt_chk = null;
    public AssessmentCriteriaScoresManager()
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
    public HashMap AddModify(Properties properties, ArrayList assess_main)
	{
		StringBuffer  stringbuffer = new StringBuffer();
        HashMap tempHash = new HashMap();
		HashMap record = null;
		String assess_note_id = "";
		String assess_catg_code	= "";
		String sec_hdg_code	= "";
		String child_sec_hdg_code	= "";
		String comp_id = "";
		String comp_srl_no = "";
		String comp_type = "";
		String normal_rng_low = "";
		String normal_rng_high = "";
		String normal_score = "";
		String abnormal_rng_low = "";
		String abnormal_rng_high = "";
		String abnormal_score = "";
		String critical_rng_low = "";
		String critical_rng_high = "";
		String critical_score = "";
		String scorelistyes = "";
		String scorelistno = "";
		String added_by_id = "";
		String added_at_ws_no = "";
		String added_facility_id = "";
		String modified_by_id = "";
		String modified_at_ws_no = "";
		String modified_facility_id = "";
		String list_item_id = "";
		String score = "";
		ArrayList resp = null;
		try
        {

            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			// deletion starts
			if(assess_main.size() > 0)
			{
				record	= (HashMap)assess_main.get(0);
				assess_note_id = (String)record.get("ASSESS_NOTE_ID");
				assess_catg_code = (String)record.get("ASSESS_CATG_CODE");
				String sql_num_delete = "delete from cp_assess_num_crit_score where assess_note_id=? and assess_catg_code=?";
				String sql_list_delete = "delete from cp_assess_list_crit_score where assess_note_id=? and assess_catg_code=?";
				// delete cp_assess_list_crit_score
				pstmt = con.prepareStatement(sql_list_delete);
				pstmt.setString(1,assess_note_id);
				pstmt.setString(2,assess_catg_code);
				pstmt.executeUpdate();
				// delete cp_assess_num_crit_score
				if(pstmt !=	null) pstmt.close();
				pstmt = con.prepareStatement(sql_num_delete);
				pstmt.setString(1,assess_note_id);
				pstmt.setString(2,assess_catg_code);
				pstmt.executeUpdate();
				if(pstmt != null) 
				{
					pstmt.close();
				}
			}
			
			// deletion ends
			String sql_insert_num = "Insert into cp_assess_num_crit_score(ASSESS_NOTE_ID,ASSESS_CATG_CODE,SEC_HDG_CODE,CHILD_SEC_HDG_CODE,COMP_ID,COMP_SRL_NO,NORMAL_RNG_LOW,NORMAL_RNG_HIGH,NORMAL_SCORE,ABNORMAL_RNG_LOW,ABNORMAL_RNG_HIGH,ABNORMAL_SCORE,CRITICAL_RNG_LOW,CRITICAL_RNG_HIGH,CRITICAL_SCORE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			pstmt_num = con.prepareStatement(sql_insert_num);
			String sql_insert_chk = "Insert into cp_assess_list_crit_score(ASSESS_NOTE_ID,ASSESS_CATG_CODE,SEC_HDG_CODE,CHILD_SEC_HDG_CODE,COMP_ID,COMP_SRL_NO,LIST_ITEM_ID,SCORE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,? )";
			pstmt_chk = con.prepareStatement(sql_insert_chk);
			String sql_insert_list = "Insert into cp_assess_list_crit_score(ASSESS_NOTE_ID,ASSESS_CATG_CODE,SEC_HDG_CODE,CHILD_SEC_HDG_CODE,COMP_ID,COMP_SRL_NO,LIST_ITEM_ID,SCORE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,? )";
			pstmt_list = con.prepareStatement(sql_insert_list);

			for(int i=0;i<assess_main.size();i++)
			{
				record	= (HashMap)assess_main.get(i);
				assess_note_id = (String)record.get("ASSESS_NOTE_ID");
				assess_catg_code = (String)record.get("ASSESS_CATG_CODE");
				sec_hdg_code = (String)record.get("SEC_HDG_CODE");
				child_sec_hdg_code = (String)record.get("CHILD_SEC_HDG_CODE");
				comp_id	 = (String)record.get("COMP_ID");
				comp_srl_no	 = (String)record.get("COMP_SRL_NO");
				comp_type =	(String)record.get("COMP_TYPE");
				added_by_id = (String)record.get("ADDED_BY_ID");
				added_at_ws_no = (String)record.get("ADDED_AT_WS_NO");
				added_facility_id = (String)record.get("ADDED_FACILITY_ID");
				modified_by_id = (String)record.get("MODIFIED_BY_ID");
				modified_at_ws_no = (String)record.get("MODIFIED_AT_WS_NO");
				modified_facility_id = (String)record.get("MODIFIED_FACILITY_ID");
				//String locale=(String)record.get("locale")==null?"en":(String)record.get("locale");
				// For Number
				if((comp_type.equals("N")) || (comp_type.equals("I")))
				{
					normal_rng_low = (String)record.get("NORMAL_RNG_LOW");
					if(normal_rng_low.equals("")) normal_rng_low = "0";
					normal_rng_high = (String)record.get("NORMAL_RNG_HIGH");
					if(normal_rng_high.equals("")) normal_rng_high = "0";
					normal_score = (String)record.get("NORMAL_SCORE");
					abnormal_rng_low = (String)record.get("ABNORMAL_RNG_LOW");
					if(abnormal_rng_low.equals("")) abnormal_rng_low = "0";
					abnormal_rng_high = (String)record.get("ABNORMAL_RNG_HIGH");
					if(abnormal_rng_high.equals("")) abnormal_rng_high = "0";
					abnormal_score = (String)record.get("ABNORMAL_SCORE");
					critical_rng_low = (String)record.get("CRITICAL_RNG_LOW");
					if(critical_rng_low.equals("")) critical_rng_low = "0";
					critical_rng_high = (String)record.get("CRITICAL_RNG_HIGH");
					if(critical_rng_high.equals("")) critical_rng_high = "0";
					critical_score = (String)record.get("CRITICAL_SCORE");
					pstmt_num.setString(1,assess_note_id);
					pstmt_num.setString(2,assess_catg_code);
					pstmt_num.setString(3,sec_hdg_code);
					pstmt_num.setString(4,child_sec_hdg_code);
					pstmt_num.setString(5,comp_id);
					pstmt_num.setString(6,comp_srl_no);
					pstmt_num.setString(7,normal_rng_low);
					pstmt_num.setString(8,normal_rng_high);
					pstmt_num.setString(9,normal_score);
					pstmt_num.setString(10,abnormal_rng_low);
					pstmt_num.setString(11,abnormal_rng_high);
					pstmt_num.setString(12,abnormal_score);
					pstmt_num.setString(13,critical_rng_low);
					pstmt_num.setString(14,critical_rng_high);
					pstmt_num.setString(15,critical_score);
					pstmt_num.setString(16, added_by_id);
					pstmt_num.setString(17, added_at_ws_no);
					pstmt_num.setString(18, added_facility_id);
					pstmt_num.setString(19, modified_by_id);
					pstmt_num.setString(20, modified_at_ws_no);
					pstmt_num.setString(21, modified_facility_id);
					int l = pstmt_num.executeUpdate();
					if(l==0)
					throw new Exception("Number Not inserted");
				}
				// End of Number	
				// For Checkbox
				if(comp_type.equals("C"))
				{
					scorelistyes = (String)record.get("SCORELISTYES");
					scorelistno = (String)record.get("SCORELISTNO");
					for(int k=1;k<=2;k++)
					{
						if (k==1)
						{
							list_item_id = "Y";
							score = scorelistyes;
						}
						else if(k==2)
						{
							list_item_id = "N";
							score = scorelistno;
						}
						pstmt_chk.setString(1,assess_note_id);
						pstmt_chk.setString(2,assess_catg_code);
						pstmt_chk.setString(3,sec_hdg_code);
						pstmt_chk.setString(4,child_sec_hdg_code);
						pstmt_chk.setString(5,comp_id);
						pstmt_chk.setString(6,comp_srl_no);
						pstmt_chk.setString(7,list_item_id);
						pstmt_chk.setString(8,score);
						pstmt_chk.setString(9,added_by_id);
						pstmt_chk.setString(10,added_at_ws_no);
						pstmt_chk.setString(11,added_facility_id);
						pstmt_chk.setString(12,modified_by_id);
						pstmt_chk.setString(13,modified_at_ws_no);
						pstmt_chk.setString(14,modified_facility_id);
						pstmt_chk.addBatch();
					}
					int[] batch_result = pstmt_chk.executeBatch();
					for (int m=0;m<batch_result.length;m++ ) 
					{
						if (batch_result[m]<0  && batch_result[m] != -2) 
						{
							pstmt_chk.cancel();
							throw new Exception("Checkbox Insertion Failed");
						}
					}
				}
				// End of Checkbox
				// For Listbox
				if(comp_type.equals("L"))
				{
					resp = (ArrayList)record.get("RESP");
					for(int j=0; j<resp.size(); j+=2)
					{
						list_item_id	=	(String)resp.get(j);
						score	=	(String)resp.get(j+1);
						pstmt_list.setString(1,assess_note_id);
						pstmt_list.setString(2,assess_catg_code);
						pstmt_list.setString(3,sec_hdg_code);
						pstmt_list.setString(4,child_sec_hdg_code);
						pstmt_list.setString(5,comp_id);
						pstmt_list.setString(6,comp_srl_no);
						pstmt_list.setString(7,list_item_id);
						pstmt_list.setString(8,score);
						pstmt_list.setString(9,added_by_id);
						pstmt_list.setString(10,added_at_ws_no);
						pstmt_list.setString(11,added_facility_id);
						pstmt_list.setString(12,modified_by_id);
						pstmt_list.setString(13,modified_at_ws_no);
						pstmt_list.setString(14,modified_facility_id);
						pstmt_list.addBatch();
					}
					int[] batch_result = pstmt_list.executeBatch();
					for (int m=0;m<batch_result.length;m++ ) 
					{
						if (batch_result[m]<0  && batch_result[m] != -2) 
						{
							pstmt_list.cancel();
							throw new Exception("List Item Entry Failed");
						}
					}
				}
				// End of Listbox
			}
			con.commit();
			 if(con != null)
			{
				if(pstmt != null) 
				{
					pstmt.close();
					//pstmt = null;
				}
				if(pstmt_num != null) 
				{
					pstmt_num.close();
					//pstmt_num = null;
				}
				if(pstmt_chk != null) 
				{
					pstmt_chk.close();
					//pstmt_chk = null;
				}
				if(pstmt_list != null) 
				{
					pstmt_list.close();
					//pstmt_list = null;
				}
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			tempHash.put("status",new Boolean(true));
			tempHash.put("error",stringbuffer.toString());
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
				if(pstmt != null) 
				{
					pstmt.close();
					//pstmt = null;
				}
				if(pstmt_num != null) 
				{
					pstmt_num.close();
					//pstmt_num = null;
				}
				if(pstmt_chk != null) 
				{
					pstmt_chk.close();
					//pstmt_chk = null;
				}
				if(pstmt_list != null) 
				{
					pstmt_list.close();
					//pstmt_list = null;
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
