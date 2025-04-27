/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.CriteriaForAssessmentCategory;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="CriteriaForAssessmentCategory"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CriteriaForAssessmentCategory"
*	local-jndi-name="CriteriaForAssessmentCategory"
*	impl-class-name="eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryLocal"
*	remote-class="eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryLocalHome"
*	remote-class="eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryHome"
*	generate= "local,remote"
*
*
*/
public class CriteriaForAssessmentCategoryManager implements SessionBean{
	Connection connection			= null;
	PreparedStatement pstmt_insert	=null;
	PreparedStatement pstmt_delete_lc = null;
	PreparedStatement pstmt_delete_ni = null;
	PreparedStatement pstmt_delete_crit = null;
	PreparedStatement pstmt_update = null;
	String assess_note_id ="";
	String assess_catg_code	="";
	String sec_hdg_code	="";
	String child_sec_hdg_code ="";
	String comp_id ="";
	String srl_no ="";
	String comp_type ="";
	String db_action="";
	String select_yn="";
	String added_by_id="";
	String added_at_ws_no="";
	String added_facility_id	="";
	String modified_by_id	="";
	String modified_facility_id	="";
	String modified_at_ws_no	 ="";
	int total_records;

	public CriteriaForAssessmentCategoryManager(){}

	public void ejbCreate() throws  CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext){
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap AddModify(HashMap tabData) {
		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		System.err.println("#####tabData======>"+tabData);
		int inserted = 0;

		assess_note_id	=	(String)tabData.get("assess_note_id");
		assess_catg_code	=	(String)tabData.get("assess_catg_code");
        added_by_id			=	(String)tabData.get("added_by_id");
		added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		added_facility_id	=	(String)tabData.get("added_facility_id");
		ppts				=	(Properties)tabData.get("properties");
		String locale=(String)tabData.get("locale")==null?"en":(String)tabData.get("locale");
		modified_by_id		=	added_by_id;
		modified_at_ws_no	=	added_at_ws_no;
		modified_facility_id	=	added_facility_id;

        total_records = Integer.parseInt((String)tabData.get("total_records")==null?"0":	(String)tabData.get("total_records"));
		
		boolean delete_flag = false;
		boolean delete_flag_chd = false;
        boolean insert_flag = false;
        boolean update_flag = false;
        boolean final_flag = false;

		int chd_delet_lc = 0;
		int chd_delet_ni = 0;
		int delet_crit   = 0;
		int update       = 0;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer();
		System.err.println("1");
		try
        {
			connection = ConnectionManager.getConnection(ppts);
            connection.setAutoCommit(false);
		    String sql_chd_delete_lc = "delete from CP_ASSESS_LIST_CRIT_SCORE  where assess_note_id=? and  assess_catg_code=? and sec_hdg_code=? and  child_sec_hdg_code=? and comp_id=? and comp_srl_no=? ";
			String sql_chd_delete_ni = "delete from CP_ASSESS_NUM_CRIT_SCORE  where assess_note_id=? and  assess_catg_code=? and sec_hdg_code=? and  child_sec_hdg_code=? and comp_id=? and comp_srl_no=? ";
		    String sql_crit_delete = "delete from CP_ASSESS_CRIT where assess_note_id=? and  assess_catg_code=? and sec_hdg_code=? and  child_sec_hdg_code=? and comp_id=? and comp_srl_no=? ";
		    String sql_insert = "insert into cp_assess_crit (assess_note_id, assess_catg_code,sec_hdg_code,child_sec_hdg_code,comp_id,comp_srl_no, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			String sql_update="update cp_assess_crit set assess_note_id=?, assess_catg_code=?, sec_hdg_code=?,child_sec_hdg_code=?,comp_id=?, comp_srl_no=? where assess_note_id=? and assess_catg_code=? and comp_srl_no=?";
		
			pstmt_delete_lc = connection.prepareStatement(sql_chd_delete_lc);
			pstmt_delete_ni = connection.prepareStatement(sql_chd_delete_ni);
			pstmt_delete_crit = connection.prepareStatement(sql_crit_delete);
	        pstmt_insert = connection.prepareStatement(sql_insert);
			pstmt_update = connection.prepareStatement(sql_update);

			for(int k = 0; k <total_records; k++)
			 {
				System.err.println("2");
	            sec_hdg_code = (String)tabData.get("sec_hdg_code" + k);
				child_sec_hdg_code = (String)tabData.get("child_sec_hdg_code" + k);
                comp_id = (String)tabData.get("comp_id" + k);
                srl_no = (String)tabData.get("srl_no" + k);
                comp_type = (String)tabData.get("comp_type" + k);
				db_action = (String)tabData.get("db_action" + k);
            	select_yn = (String)tabData.get("select" + k);
				System.err.println("3");
				if((db_action.equalsIgnoreCase("U")) && (select_yn.equalsIgnoreCase("N")))
				{
					System.err.println("4");
					if(comp_type.equalsIgnoreCase("L") || comp_type.equalsIgnoreCase("C"))
					{
						System.err.println("5");
						pstmt_delete_lc.setString(1,assess_note_id);
						pstmt_delete_lc.setString(2,assess_catg_code);
						pstmt_delete_lc.setString(3,sec_hdg_code);
						pstmt_delete_lc.setString(4,child_sec_hdg_code);
						pstmt_delete_lc.setString(5,comp_id);
						pstmt_delete_lc.setString(6,srl_no);
						chd_delet_lc = pstmt_delete_lc.executeUpdate();
						//if(pstmt_delete_lc != null)	pstmt_delete_lc.close();
					}	
					else if(comp_type.equalsIgnoreCase("N") || comp_type.equalsIgnoreCase("I"))
					{
						System.err.println("6");
						pstmt_delete_ni.setString(1,assess_note_id);
						pstmt_delete_ni.setString(2,assess_catg_code);
						pstmt_delete_ni.setString(3,sec_hdg_code);
						pstmt_delete_ni.setString(4,child_sec_hdg_code);
						pstmt_delete_ni.setString(5,comp_id);
						pstmt_delete_ni.setString(6,srl_no);
						chd_delet_ni = pstmt_delete_ni.executeUpdate();	
						//if(pstmt_delete_ni != null)	pstmt_delete_ni.close();
				    }
						pstmt_delete_crit.setString(1,assess_note_id);
						pstmt_delete_crit.setString(2,assess_catg_code);
						pstmt_delete_crit.setString(3,sec_hdg_code);
						pstmt_delete_crit.setString(4,child_sec_hdg_code);
						pstmt_delete_crit.setString(5,comp_id);
						pstmt_delete_crit.setString(6,srl_no);
						System.err.println("7");
						delet_crit = pstmt_delete_crit.executeUpdate();
						//if(pstmt_delete_crit != null)	pstmt_delete_crit.close();
				}
		    	else if((db_action.equalsIgnoreCase("I")) && (select_yn.equalsIgnoreCase("Y")))
				{		
					System.err.println("8");
					pstmt_insert.setString(1, assess_note_id);
					pstmt_insert.setString(2, assess_catg_code);
					pstmt_insert.setString(3, sec_hdg_code);
					pstmt_insert.setString(4, child_sec_hdg_code);
					pstmt_insert.setString(5, comp_id);
					pstmt_insert.setString(6, srl_no);
			   		pstmt_insert.setString(7, added_by_id);
					pstmt_insert.setString(8, added_at_ws_no);
	                pstmt_insert.setString(9, added_facility_id);
	                pstmt_insert.setString(10, modified_by_id);
	                pstmt_insert.setString(11, modified_at_ws_no);
	                pstmt_insert.setString(12, modified_facility_id);
					System.err.println("9");
					pstmt_insert.executeUpdate();
					System.err.println("91");
					inserted++;
                   // if(pstmt_insert != null)	pstmt_insert.close();
				}
		    	else if((db_action.equalsIgnoreCase("U")) && (select_yn.equalsIgnoreCase("Y")))
		    	{
					System.err.println("10");
					pstmt_update.setString(1,assess_note_id);
					pstmt_update.setString(2,assess_catg_code);
					pstmt_update.setString(3,sec_hdg_code);
					pstmt_update.setString(4,child_sec_hdg_code);
					pstmt_update.setString(5,comp_id);
					pstmt_update.setString(6,srl_no);              
					pstmt_update.setString(7,assess_note_id);              
					pstmt_update.setString(8,assess_catg_code);              
					pstmt_update.setString(9,srl_no);     
					System.err.println("11");
					update = pstmt_update.executeUpdate();
					System.err.println("12");
					//if(pstmt_update != null)	pstmt_update.close();
				}
	    }
				
				if ((chd_delet_lc > 0) || (chd_delet_ni > 0))
					delete_flag_chd=true;
				else
					delete_flag_chd=false;

                if (delet_crit > 0)
					delete_flag=true;
                else
                    delete_flag=false;
				
				if(update > 0)
			    	update_flag = true;
		    	else
					update_flag=false;

				if(inserted > 0)
			    	insert_flag = true;
		    	else
					insert_flag=false;

				if((insert_flag) || (delete_flag) || (update_flag) || (delete_flag_chd))
				final_flag = true;
			    else
				final_flag = false;

			   if(final_flag){
                connection.commit();
 				retMap.put( "result", new Boolean( true ) ) ;
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
				messages.append((String)massageMap.get("message"));
			}else{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
				messages.append((String)massageMap.get("message"));
			}
        }
        catch(Exception e){
		try{
			connection.rollback();
			retMap.put( "result", new Boolean( false ) ) ;
			retMap.put( "flag" , "" );
			traceVal.append(e.getMessage());
            Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
			//messages.append(e.getMessage());
            messages.append((String)massageMap.get("message"));
		}catch(Exception ex)	{
			ex.printStackTrace();
		}
	}
	finally{

		try{
	
		if(pstmt_insert != null) 
		{
			pstmt_insert.close();
			pstmt_insert = null;
		}
		if(pstmt_update != null) 
		{
			pstmt_update.close();
			pstmt_update = null;
		}
		if(pstmt_delete_lc != null)
		{
			pstmt_delete_lc.close();
			pstmt_delete_lc = null;
		}
		if(pstmt_delete_ni != null)
		{
			pstmt_delete_ni.close();
			pstmt_delete_ni = null;

		}
		if(pstmt_delete_crit != null)
		{
			pstmt_delete_crit.close();
			pstmt_delete_crit = null;
		}

		if(connection != null) {
			ConnectionManager.returnConnection(connection,ppts);
		}
		}catch(Exception ey)
		{
			ey.printStackTrace();
		}
	}

	retMap.put( "message", messages.toString() ) ;
	retMap.put( "traceVal",traceVal.toString());
	retMap.put( "invalidCode" , "");

	return retMap;

    }
}
