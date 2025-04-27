/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.AssessmentCategoryForAssessmentNote;

import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="AssessmentCategoryForAssessmentNote"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssessmentCategoryForAssessmentNote"
*	local-jndi-name="AssessmentCategoryForAssessmentNote"
*	impl-class-name="eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteLocal"
*	remote-class="eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteLocalHome"
*	remote-class="eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteHome"
*	generate= "local,remote"
*
*
*/
public class AssessmentCategoryForAssessmentNoteManager implements SessionBean
{
	Connection connection;
   	PreparedStatement pstmt_insert	= null;
	PreparedStatement pstmt_delete  = null;
	PreparedStatement pstmt_delete_crit  = null;
	PreparedStatement pstmt_delete_list_crit  = null;
	PreparedStatement pstmt_delete_num_crit  = null;
	StringBuffer traceVal	    	= new StringBuffer();

	int inserted=0;
	int deleted=0;

	String added_by_id="";
	String added_at_ws_no="";
	String added_facility_id="";
	String modified_by_id="";
	String modified_at_ws_no="";
	String modified_facility_id="";

	String db_action="";
	String select_yn="";
	String assess_note_id="";
	String assess_catg_code="";

	int total_records=0;

    public AssessmentCategoryForAssessmentNoteManager()
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
    public HashMap SpecialityAddModify(HashMap tabData)
    {
        Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		boolean final_flag=false;

		assess_note_id	=	(String)tabData.get("assess_note_id");
        added_by_id			=	(String)tabData.get("added_by_id");
		added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		added_facility_id	=	(String)tabData.get("added_facility_id");
		ppts				=	(Properties)tabData.get("properties");
		String locale=(String)tabData.get("locale")==null?"en":(String)tabData.get("locale");
		modified_by_id		=	added_by_id;
		modified_at_ws_no	=	added_at_ws_no;
		modified_facility_id	=	added_facility_id;

        total_records = Integer.parseInt((String)tabData.get("total_records")==null?"0":	(String)tabData.get("total_records"));
	    
        try
        {
            connection = ConnectionManager.getConnection(ppts);
            connection.setAutoCommit(false);

            String sql_insert = "insert into cp_assess_note_assess_catg (assess_note_id,assess_catg_code,  added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?,?, sysdate, ?, ?, ?, sysdate, ?, ? )";
            String sql_delete = "delete from cp_assess_note_assess_catg where  assess_note_id=? and assess_catg_code=?";
            String sql_delete_crit = "delete from cp_assess_crit where  assess_note_id=? and assess_catg_code=?";
            String sql_delete_list_crit = "delete from cp_assess_list_crit_score where  assess_note_id=? and assess_catg_code=?";
            String sql_delete_num_crit = "delete from cp_assess_num_crit_score where  assess_note_id=? and assess_catg_code=?";

			pstmt_insert = connection.prepareStatement(sql_insert);                
			pstmt_delete = connection.prepareStatement(sql_delete);
			pstmt_delete_crit = connection.prepareStatement(sql_delete_crit);
			pstmt_delete_list_crit = connection.prepareStatement(sql_delete_list_crit);
			pstmt_delete_num_crit = connection.prepareStatement(sql_delete_num_crit);

            for(int k = 0; k < total_records; k++)
            {
				assess_catg_code = (String)tabData.get("assess_catg_code"+ k);
    			db_action = (String)tabData.get("db_action" + k);
            	select_yn = (String)tabData.get("select" + k);
				if((db_action.equalsIgnoreCase("U")) && (select_yn.equalsIgnoreCase("N")))
				{
					pstmt_delete.setString(1,assess_note_id);              
					pstmt_delete.setString(2,assess_catg_code);              

					pstmt_delete_crit.setString(1,assess_note_id);              
					pstmt_delete_crit.setString(2,assess_catg_code);            

					pstmt_delete_list_crit.setString(1,assess_note_id);              
					pstmt_delete_list_crit.setString(2,assess_catg_code);            

    				pstmt_delete_num_crit.setString(1,assess_note_id);              
					pstmt_delete_num_crit.setString(2,assess_catg_code);            

					pstmt_delete_list_crit.executeUpdate();
					pstmt_delete_num_crit.executeUpdate();
     				pstmt_delete_crit.executeUpdate();
					pstmt_delete.executeUpdate();
					deleted++;
				}
				else if((db_action.equalsIgnoreCase("I")) && (select_yn.equalsIgnoreCase("Y")))
				{
                    pstmt_insert.setString(1, assess_note_id);
					pstmt_insert.setString(2, assess_catg_code);
					pstmt_insert.setString(3, added_by_id);
					pstmt_insert.setString(4, added_at_ws_no);
					pstmt_insert.setString(5, added_facility_id);
					pstmt_insert.setString(6, modified_by_id);
					pstmt_insert.setString(7, modified_at_ws_no);
					pstmt_insert.setString(8, modified_facility_id);
					pstmt_insert.executeUpdate();
					inserted++;
				}
            }

			if(pstmt_delete != null)
			{
				pstmt_delete.close();
				pstmt_delete = null;
			}
			if(pstmt_delete_crit != null) 
			{
				pstmt_delete_crit.close();
				pstmt_delete_crit = null;
			}
			if(pstmt_delete_list_crit != null) 
			{
				pstmt_delete_list_crit.close();
				pstmt_delete_list_crit = null;
			}
			if(pstmt_delete_num_crit != null) 
			{
				pstmt_delete_num_crit.close();
				pstmt_delete_num_crit = null;
			}
			if(pstmt_insert != null) 
			{
				pstmt_insert.close();
				pstmt_insert = null;
			}

			if(inserted >=0 || deleted>=0)
			{
				final_flag=true;
			}
			else
			{
				final_flag=false;
			}

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
            messages.append((String)massageMap.get("message"));
		}catch(Exception ex)	{
			ex.printStackTrace();
		}
	}
	finally{

		try{
			if(pstmt_delete != null)
			{
				pstmt_delete.close();
				pstmt_delete = null;
			}
			if(pstmt_delete_crit != null) 
			{
				pstmt_delete_crit.close();
				pstmt_delete_crit = null;
			}
			if(pstmt_delete_list_crit != null) 
			{
				pstmt_delete_list_crit.close();
				pstmt_delete_list_crit = null;
			}
			if(pstmt_delete_num_crit != null) 
			{
				pstmt_delete_num_crit.close();
				pstmt_delete_num_crit = null;
			}
			if(pstmt_insert != null) 
			{
				pstmt_insert.close();
				pstmt_insert = null;
			}
			if(connection != null) 
				ConnectionManager.returnConnection(connection,ppts);
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
