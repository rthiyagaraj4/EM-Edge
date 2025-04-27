/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSAccessRights;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="RSAccessRights"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSAccessRights"
*	local-jndi-name="RSAccessRights"
*	impl-class-name="eRS.RSAccessRights.RSAccessRightsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSAccessRights.RSAccessRightsLocal"
*	remote-class="eRS.RSAccessRights.RSAccessRightsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSAccessRights.RSAccessRightsLocalHome"
*	remote-class="eRS.RSAccessRights.RSAccessRightsHome"
*	generate= "local,remote"
*
*
*/

public class RSAccessRightsManager implements SessionBean{
	Connection connection				= null;
	StringBuffer traceVal				= new StringBuffer();

	PreparedStatement pstmt_insert		= null;
	PreparedStatement pstmt_delete		= null;
	PreparedStatement pstmt_update		= null;
	
	String facility_id		="";
	String user_id	 ="";
	String workplace_code="";
    
	String setup_yn="";
	String allocate_yn="";
	String reallocate_yn="";
	String cancel_yn="";
	String select_yn="";
	String dbaction="";

	String added_by_id="";
	String added_at_ws_no="";
	String added_facility_id	="";
	String modified_by_id	="";
	String modified_facility_id	="";
	String modified_at_ws_no	 ="";
	String locale				="";
	int total_records;

	public RSAccessRightsManager(){}

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
    public HashMap modify(HashMap tabData)
	{
		Properties prop = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		int[] resCnt = null;
		int inserted = 0;
		int done=0;

        prop				=	(Properties)tabData.get("properties");
	    total_records = Integer.parseInt((String)tabData.get("total_records")==null?"0":(String)tabData.get("total_records"));
        boolean delete_flag = false;
        boolean update_flag = false;
        boolean insert_flag = true;

        try{
            connection = ConnectionManager.getConnection(prop);
            connection.setAutoCommit(false);
            String sql_delete = "";
            int delet = 0;

			int updated=0;
			int first=0;

            facility_id			=	(String)tabData.get("facility_id");
            
		    user_id				=	(String)tabData.get("appl_user_id");

            added_by_id			=	(String)tabData.get("added_by_id");
		    added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		    added_facility_id	=	(String)tabData.get("added_facility_id");
		    modified_by_id		=	added_by_id;
		    modified_at_ws_no	=	added_at_ws_no;
		    modified_facility_id	=	added_facility_id;
			locale			=	(String)tabData.get("locale");

			sql_delete = "delete from rs_access_rights where appl_user_id=? and workplace_code=? and facility_id=?";
            pstmt_delete = connection.prepareStatement(sql_delete);

			String sql_insert = "insert into rs_access_rights (facility_id, workplace_code, appl_user_id, setup_requirement_yn,allocate_yn, reallocate_yn, cancel_schedule_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt_insert = connection.prepareStatement(sql_insert);

			String sql_update ="update rs_access_rights set setup_requirement_yn=?,allocate_yn=?,reallocate_yn=?,cancel_schedule_yn=? where facility_id=? and workplace_code=? and appl_user_id=?";
			pstmt_update=connection.prepareStatement(sql_update);
			//System.out.println("------values in ejb----");
			//System.out.println("locale value 127------->"+locale);
			if(total_records<=1){
		        workplace_code		=	(String)tabData.get("workplace_code");

         		setup_yn=(String)tabData.get("setup_requirement_yn");
		        allocate_yn=(String)tabData.get("allocate_yn");
		        reallocate_yn=(String)tabData.get("reallocate_yn");
		        cancel_yn=(String)tabData.get("cancel_schedule_yn");
		        select_yn=(String)tabData.get("select_yn");
		        dbaction=(String)tabData.get("dbaction");

				if(dbaction.equals("U") && select_yn.equals("N")){
					pstmt_delete.setString(1,user_id);
					pstmt_delete.setString(2,workplace_code);
					pstmt_delete.setString(3,facility_id);

					delet = pstmt_delete.executeUpdate();
				}
				else if(dbaction.equals("I") && select_yn.equals("Y"))	{
					pstmt_insert.setString(1, facility_id);
					pstmt_insert.setString(2, workplace_code);
					pstmt_insert.setString(3, user_id);
					pstmt_insert.setString(4, setup_yn);
					pstmt_insert.setString(5, allocate_yn);
					pstmt_insert.setString(6, reallocate_yn);
					pstmt_insert.setString(7, cancel_yn);
					pstmt_insert.setString(8, added_by_id);
					pstmt_insert.setString(9, added_at_ws_no);
					pstmt_insert.setString(10, added_facility_id);
					pstmt_insert.setString(11, modified_by_id);
					pstmt_insert.setString(12, modified_at_ws_no);
					pstmt_insert.setString(13, modified_facility_id);
					inserted = pstmt_insert.executeUpdate();
				}
				else if(dbaction.equals("U") && select_yn.equals("Y")){
    				pstmt_update.setString(1,setup_yn);
					pstmt_update.setString(2,allocate_yn);
					pstmt_update.setString(3,reallocate_yn);
					pstmt_update.setString(4,cancel_yn);
					pstmt_update.setString(5,facility_id);
					pstmt_update.setString(6,workplace_code);
					pstmt_update.setString(7,user_id);
				    updated=pstmt_update.executeUpdate();
				}
				else if(dbaction.equals("I") && select_yn.equals("N")){
					first++;
				}
			}
         	else if(total_records>1){
     			for(int i=0;i<total_records;i++){
					String workplace_value=(String)tabData.get("workplace_code"+(i));
					String select=(String)tabData.get("select"+(i))==null?"N":(String)tabData.get("select"+(i));
					String setup_yn=(String)tabData.get("setup"+(i))==null?"N":(String)tabData.get("setup"+(i));
					String allocate_yn=(String)tabData.get("allocate"+(i))==null?"N":(String)tabData.get("allocate"+(i));
					String reallocate_yn=(String)tabData.get("reallocate"+(i))==null?"N":(String)tabData.get("reallocate"+(i));
					String cancel_yn=(String)tabData.get("cancel"+(i))==null?"N":(String)tabData.get("cancel"+(i));
					String dbaction=(String)tabData.get("dbaction"+(i));

					if(dbaction.equals("U") && select.equals("N")){
						pstmt_delete.setString(1,user_id);
						pstmt_delete.setString(2,workplace_value);
						pstmt_delete.setString(3,facility_id);
						delet = pstmt_delete.executeUpdate();
					}
					else if(dbaction.equals("U") && select.equals("Y")){
    					pstmt_update.setString(1,setup_yn);
						pstmt_update.setString(2,allocate_yn);
						pstmt_update.setString(3,reallocate_yn);
						pstmt_update.setString(4,cancel_yn);
						pstmt_update.setString(5,facility_id);
						pstmt_update.setString(6,workplace_value);
						pstmt_update.setString(7,user_id);
				        updated=pstmt_update.executeUpdate();
					}
					else if(dbaction.equals("I") && select.equals("Y")){
						pstmt_insert.setString(1, facility_id);
						pstmt_insert.setString(2, workplace_value);
						pstmt_insert.setString(3, user_id);
						pstmt_insert.setString(4, setup_yn);
						pstmt_insert.setString(5, allocate_yn);
						pstmt_insert.setString(6, reallocate_yn);
						pstmt_insert.setString(7, cancel_yn);
						pstmt_insert.setString(8, added_by_id);
						pstmt_insert.setString(9, added_at_ws_no);
						pstmt_insert.setString(10, added_facility_id);
						pstmt_insert.setString(11, modified_by_id);
						pstmt_insert.setString(12, modified_at_ws_no);
						pstmt_insert.setString(13, modified_facility_id);
						pstmt_insert.addBatch();
					}
					else if(dbaction.equals("I") && select.equals("N")){
						done++;
					}
					resCnt = pstmt_insert.executeBatch();
				}
			}

			if(delet>= 0)
                delete_flag = true;
            else
                delete_flag = false;

			if(updated>=0)
				update_flag=true;
			else
				update_flag=false;

			if(total_records<=1)	{
				if((inserted != 0) || (delete_flag) || (update_flag) || first>=0)
					insert_flag = true;
				else
					insert_flag = false;
			}
			else if(total_records>1){
				if((resCnt != null) || (delete_flag) || (update_flag) || done>=0)
					insert_flag = true;
				else
					insert_flag = false;
			}

            if(insert_flag){
                connection.commit();
 				retMap.put( "result", new Boolean( true ) ) ;
				retMap.put( "flag" , "" );
				//Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
				Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
				messages.append((String)massageMap.get("message"));
			}
			else{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				messages.append((String)massageMap.get("message"));				
			}
        }
        catch(Exception e){
			try{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				traceVal.append(e.getMessage());
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				messages.append((String)massageMap.get("message"));
			}
			catch(Exception ex)	{
				ex.printStackTrace();
			}
		}
		finally{
			try{
				if(pstmt_insert != null) 
					pstmt_insert.close();
				if(pstmt_delete != null)
					pstmt_delete.close();
				if(pstmt_update != null)
					pstmt_update.close();

				if(connection != null) {
					ConnectionManager.returnConnection(connection,prop);
				}
			}
			catch(Exception exp){
				exp.printStackTrace();
			}
		}

		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;
    }
}
