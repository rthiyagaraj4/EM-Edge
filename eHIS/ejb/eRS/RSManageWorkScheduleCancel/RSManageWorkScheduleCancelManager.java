/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleCancel ;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSManageWorkScheduleCancel"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleCancel"
*	local-jndi-name="RSManageWorkScheduleCancel"
*	impl-class-name="eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelLocal"
*	remote-class="eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelLocalHome"
*	remote-class="eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleCancelManager implements SessionBean{

	Connection connection = null;
	StringBuffer traceVal	= new StringBuffer();

	PreparedStatement pstmt_insert=null;
	PreparedStatement pstmt_insert_dtl=null;
	PreparedStatement pstmt_delete=null;

	String activity_type="";
	String reason_code="";
	String remarks="";
	String date_from="";
	String date_to="";
	String locn_type="";
	String facility_id="";
	String workplace_code="";
	String requirement_id="";
	String role_type="";
	String staff_type="";
	String staff_id="";
	String position_code="";

	String schedule_date="";
	String shift_code="";
	String shift_mnemonic="";
	String shift_start_time="";
	String shift_end_time="";
	String schedule_type="";
	String over_time_durn="";

	String added_by_id	="";
	String added_at_ws_no="";
	String added_facility_id	="";
	String locale	 ="";

	public RSManageWorkScheduleCancelManager(){}

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

	public HashMap cancelshift(HashMap tabData){
		Properties prop = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		int insert=0;
		int insertCnt = 0;
		int delete = 0;

		prop = (Properties)tabData.get("properties");
    	int activity_id=Integer.parseInt((String)tabData.get("activity_id"));
		locale= (String )tabData.get("locale");
		//System.err.println("locale -- in EJB---" +locale);
		//System.err.println("tabData -- in EJB---" +tabData);
		try
		{
    	connection = ConnectionManager.getConnection(prop);
		connection.setAutoCommit(false);

		String sql_delete = "delete from rs_work_schedule where facility_id=? and workplace_code=? and schedule_date=to_date(?,'dd/mm/yyyy') and shift_code=? and role_type=? and position_code=? and staff_id=?";
        pstmt_delete = connection.prepareStatement(sql_delete);

		String sql_insert = "insert into rs_activity_log (activity_log_id, activity_type,reason_code,remarks,date_from,date_to,locn_type,facility_id,workplace_code,requirement_id,role_type,staff_type,staff_id,position_code,added_by_id, added_date, added_at_ws_no,added_facility_id,modified_by_id, modified_date,modified_at_ws_no, modified_facility_id) values(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
    	pstmt_insert = connection.prepareStatement(sql_insert);

		String sql_insert_dtl = "insert into rs_activity_log_dtl (activity_log_id, serial_num, activity_type, facility_id, workplace_code, role_type, staff_id, schedule_date, shift_code, shift_mnemonic, shift_start_time, shift_end_time, schedule_type, requirement_id, staff_type, position_code, locn_type, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, over_time_durn, actual_end_time) values (?,'1',?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'))";
    	pstmt_insert_dtl = connection.prepareStatement(sql_insert_dtl);

			int totalRecords = Integer.parseInt((String )tabData.get("Records"));

				activity_type=(String)tabData.get("activity_type");
				reason_code=(String)tabData.get("reason_code");
				remarks=(String)tabData.get("remarks");
                date_from=(String)tabData.get("date_from");
                date_to=(String)tabData.get("date_to");
                locn_type=(String)tabData.get("locn_type");
                facility_id=(String)tabData.get("facility_id");
                workplace_code=(String)tabData.get("workplace_code");
                requirement_id=(String)tabData.get("requirement_id");
                role_type=(String)tabData.get("role_type");
                staff_type=(String)tabData.get("staff_type");
                staff_id=(String)tabData.get("staff_id");
                position_code=(String)tabData.get("position_code");
				schedule_date=(String)tabData.get("schedule_date");
                staff_type=(String)tabData.get("staff_type");
                over_time_durn=(String)tabData.get("over_time_durn");
		 

		    added_by_id = (String )tabData.get("added_by_id");
			added_at_ws_no = (String )tabData.get("added_at_ws_no");
			added_facility_id = (String )tabData.get("added_facility_id");

		
			for(int i=1;i<=totalRecords;i++)
			{
            HashMap selectedItem=new HashMap();
			selectedItem=(HashMap)tabData.get("selectedItem"+(i));
   			shift_code=(String)selectedItem.get("shift_code");
            shift_mnemonic=(String)selectedItem.get("shift_mnemonic");
            shift_start_time=(String)selectedItem.get("shift_start_time");
            shift_end_time=(String)selectedItem.get("shift_end_time");
            schedule_type=(String)selectedItem.get("schedule_type");

			String s_activity_id_=String.valueOf(activity_id);

			pstmt_insert.setString(1,s_activity_id_);
			pstmt_insert.setString(2,activity_type);
			pstmt_insert.setString(3,reason_code);
			pstmt_insert.setString(4,remarks);
			pstmt_insert.setString(5,date_from);
			pstmt_insert.setString(6,date_to);
			pstmt_insert.setString(7,locn_type);
			pstmt_insert.setString(8,facility_id);
			pstmt_insert.setString(9,workplace_code);
			pstmt_insert.setString(10,requirement_id);
			pstmt_insert.setString(11,role_type);
			pstmt_insert.setString(12,staff_type);
			pstmt_insert.setString(13,staff_id);
			pstmt_insert.setString(14,position_code);
			pstmt_insert.setString(15,added_by_id);
			pstmt_insert.setString(16,added_at_ws_no);
			pstmt_insert.setString(17,added_facility_id);
			pstmt_insert.setString(18,added_by_id);
			pstmt_insert.setString(19,added_at_ws_no);
			pstmt_insert.setString(20,added_facility_id);

			insert=pstmt_insert.executeUpdate();


			pstmt_insert_dtl.setString(1,s_activity_id_);
			pstmt_insert_dtl.setString(2,activity_type);
			pstmt_insert_dtl.setString(3,facility_id);
			pstmt_insert_dtl.setString(4,workplace_code);
			pstmt_insert_dtl.setString(5,role_type);
			pstmt_insert_dtl.setString(6,staff_id);
			pstmt_insert_dtl.setString(7,schedule_date);
			pstmt_insert_dtl.setString(8,shift_code);
			pstmt_insert_dtl.setString(9,shift_mnemonic);
			pstmt_insert_dtl.setString(10,shift_start_time);
			pstmt_insert_dtl.setString(11,shift_end_time);
			pstmt_insert_dtl.setString(12,schedule_type);
			pstmt_insert_dtl.setString(13,requirement_id);
			pstmt_insert_dtl.setString(14,staff_type);
			pstmt_insert_dtl.setString(15,position_code);
			pstmt_insert_dtl.setString(16,locn_type);
			pstmt_insert_dtl.setString(17,added_by_id);
			pstmt_insert_dtl.setString(18,added_at_ws_no);
			pstmt_insert_dtl.setString(19,added_facility_id);
			pstmt_insert_dtl.setString(20,added_by_id);
			pstmt_insert_dtl.setString(21,added_at_ws_no);
			pstmt_insert_dtl.setString(22,added_facility_id);
			pstmt_insert_dtl.setString(23,over_time_durn);
			pstmt_insert_dtl.setString(24,shift_end_time);

			insertCnt=pstmt_insert_dtl.executeUpdate();

    		pstmt_delete.setString(1,facility_id);
			pstmt_delete.setString(2,workplace_code);
			pstmt_delete.setString(3,schedule_date);
			pstmt_delete.setString(4,shift_code);
			pstmt_delete.setString(5,role_type);
			pstmt_delete.setString(6,position_code);
			pstmt_delete.setString(7,staff_id);
        	delete=pstmt_delete.executeUpdate();

			activity_id++;
			}


			    if((insert >=1) && (insertCnt >=1) && (delete >= 0))
				{
					connection.commit();
					retMap.put( "result", new Boolean( true ) ) ;
					retMap.put( "flag" , "" );
					Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED", "RS");
					messages.append((String)massageMap.get("message"));
				}
				else
				{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				messages.append("ERROR_IN_INSERTING_INTO");
			    }
			}catch(Exception e){

			try{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				traceVal.append(e.getMessage());
				messages.append( " ERROR_IN_INSERTING_INTO" ) ;
			}catch(Exception ex)	{
				ex.printStackTrace();
			}
		}finally{
			try{
				if(pstmt_delete!=null) pstmt_delete.close();
				if(pstmt_insert!=null) pstmt_insert.close();
				if(pstmt_insert_dtl!=null) pstmt_insert_dtl.close();

				if(connection != null) {
			ConnectionManager.returnConnection(connection,prop);
			}
			}catch(Exception ey)	{
				ey.printStackTrace();
			}
		}

		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
    	return retMap;

	}
}
