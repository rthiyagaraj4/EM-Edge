/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleOvertime;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;

/**
*
* @ejb.bean
*	name="RSManageWorkScheduleOvertime"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleOvertime"
*	local-jndi-name="RSManageWorkScheduleOvertime"
*	impl-class-name="eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeLocal"
*	remote-class="eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeLocalHome"
*	remote-class="eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleOvertimeManager implements SessionBean
{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    PreparedStatement pstmt_activity_log = null;
	PreparedStatement pstmt_activity_log_dtl = null;
	PreparedStatement pstmt_work_schedule = null;
	
    public RSManageWorkScheduleOvertimeManager(){
    }
    public void ejbCreate() throws  CreateException{
    }
    public void ejbRemove(){
    }
    public void ejbActivate(){
    }
    public void ejbPassivate(){
    }
    public void setSessionContext(SessionContext sessioncontext){
    }
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert(Properties properties, HashMap tabData){
		StringBuffer  stringbuffer = new StringBuffer();
        HashMap hashmap1 = new HashMap();
		try{
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			String facility_id  = (String)tabData.get("FACILITY_ID");
			String workplace_code = (String)tabData.get("WORKPLACE_CODE");
			String schedule_date  = (String)tabData.get("DATE_FROM");
			String role_type  = (String)tabData.get("ROLE_TYPE");
			String staff_type  = (String)tabData.get("STAFF_TYPE");
			String staff_id  = (String)tabData.get("STAFF_ID");
			String position_code  = (String)tabData.get("POSITION_CODE");
			String shift_mnemonic  = (String)tabData.get("SHIFT_MNEMONIC");
			String shift_code  = (String)tabData.get("SHIFT");
			String reason_code  = (String)tabData.get("REASON_CODE");
			String remarks  = (String)tabData.get("REMARKS");
			String over_time_durn  = (String)tabData.get("OVER_TIME_DURN");
			String shift_start_date_time  = (String)tabData.get("SHIFT_START_DATE_TIME");
			String shift_end_date_time  = (String)tabData.get("SHIFT_END_DATE_TIME");
			String actual_end_date_time  = (String)tabData.get("ACTUAL_END_DATE_TIME");
			String requirement_id  = (String)tabData.get("REQUIREMENT_ID");
			String added_by_id = (String)tabData.get("ADDED_BY_ID");
			String added_at_ws_no = (String)tabData.get("ADDED_AT_WS_NO");
			String added_facility_id = (String)tabData.get("ADDED_FACILITY_ID");
			String modified_by_id = (String)tabData.get("MODIFIED_BY_ID");
			String modified_at_ws_no = (String)tabData.get("MODIFIED_AT_WS_NO");
			String modified_facility_id = (String)tabData.get("MODIFIED_FACILITY_ID");
			String activity_log_id = "";
			
			String sql_activity_log = "select rs_activity_log_seq.nextval activity_log_id from dual";
			pstmt = con.prepareStatement(sql_activity_log);
			rs = pstmt.executeQuery();
			if(rs!=null){
				if(rs.next()){
					activity_log_id = rs.getString("activity_log_id");
				}
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}
			
			String sql_rs_activity_log = "insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,DATE_FROM,DATE_TO,FACILITY_ID,WORKPLACE_CODE,REQUIREMENT_ID,ROLE_TYPE,STAFF_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,'OT',?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt_activity_log = con.prepareStatement(sql_rs_activity_log);
			pstmt_activity_log.setString(1,activity_log_id);
			pstmt_activity_log.setString(2,reason_code);
			pstmt_activity_log.setString(3,remarks);
			pstmt_activity_log.setString(4,schedule_date);
			pstmt_activity_log.setString(5,schedule_date);
			pstmt_activity_log.setString(6,facility_id);
			pstmt_activity_log.setString(7,workplace_code);
			pstmt_activity_log.setString(8,requirement_id);
			pstmt_activity_log.setString(9,role_type);
			pstmt_activity_log.setString(10,staff_id);
			pstmt_activity_log.setString(11,position_code);
			pstmt_activity_log.setString(12,added_by_id);
			pstmt_activity_log.setString(13,added_at_ws_no);
			pstmt_activity_log.setString(14,added_facility_id);
			pstmt_activity_log.setString(15,modified_by_id);
			pstmt_activity_log.setString(16,modified_at_ws_no);
			pstmt_activity_log.setString(17,modified_facility_id);
			int i = pstmt_activity_log.executeUpdate();

			if (i==0)
				throw new Exception("rs_activity_log Not inserted");

			String sql_activity_log_dtl = "insert into rs_activity_log_dtl (ACTIVITY_LOG_ID,SERIAL_NUM,ACTIVITY_TYPE,SCHEDULE_TYPE,FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,REQUIREMENT_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OVER_TIME_DURN, ACTUAL_END_TIME) values(?,'1','OT','A',?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?,to_date(?,'dd/mm/yyyyhh24:mi') )";

			pstmt_activity_log_dtl = con.prepareStatement(sql_activity_log_dtl);
			pstmt_activity_log_dtl.setString(1,activity_log_id);
			pstmt_activity_log_dtl.setString(2,facility_id);
			pstmt_activity_log_dtl.setString(3,workplace_code);
			pstmt_activity_log_dtl.setString(4,role_type);
			pstmt_activity_log_dtl.setString(5,staff_type);
			pstmt_activity_log_dtl.setString(6,staff_id);
			pstmt_activity_log_dtl.setString(7,schedule_date);
			pstmt_activity_log_dtl.setString(8,shift_code);
			pstmt_activity_log_dtl.setString(9,shift_mnemonic);
			pstmt_activity_log_dtl.setString(10,shift_start_date_time);
			pstmt_activity_log_dtl.setString(11,shift_end_date_time);
			pstmt_activity_log_dtl.setString(12,requirement_id);
			pstmt_activity_log_dtl.setString(13,position_code);
			pstmt_activity_log_dtl.setString(14,added_by_id);
			pstmt_activity_log_dtl.setString(15,added_at_ws_no);
			pstmt_activity_log_dtl.setString(16,added_facility_id);
			pstmt_activity_log_dtl.setString(17,modified_by_id);
			pstmt_activity_log_dtl.setString(18,modified_at_ws_no);
			pstmt_activity_log_dtl.setString(19,modified_facility_id);
			pstmt_activity_log_dtl.setString(20,over_time_durn);
			pstmt_activity_log_dtl.setString(21,actual_end_date_time);
			
			int k = pstmt_activity_log_dtl.executeUpdate();

			if (k==0)
				throw new Exception("rs_activity_log Not inserted");

			String sql_rs_work_schedule = "update rs_work_schedule set over_time_durn =? , actual_end_time = to_date(?,'dd/mm/yyyyhh24:mi') where  facility_id=? and workplace_code=? and role_type=? and staff_id=? and schedule_date=to_date(?,'dd/mm/yyyy') and shift_code=?";

			pstmt_work_schedule = con.prepareStatement(sql_rs_work_schedule);
			pstmt_work_schedule.setString(1,over_time_durn);

			pstmt_work_schedule.setString(2,actual_end_date_time);
			pstmt_work_schedule.setString(3,facility_id);
			pstmt_work_schedule.setString(4,workplace_code);
			pstmt_work_schedule.setString(5,role_type);
			pstmt_work_schedule.setString(6,staff_id);
			pstmt_work_schedule.setString(7,schedule_date);
			pstmt_work_schedule.setString(8,shift_code);

			int j = pstmt_work_schedule.executeUpdate();

			if (j==0)
				throw new Exception("rs_activity_log Not inserted");
			con.commit();
			hashmap1.put("status",new Boolean(true));
			hashmap1.put("error",stringbuffer.toString());
        }
        catch(Exception exception){
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
			hashmap1.put("status",new Boolean(false));
			hashmap1.put("error",stringbuffer.toString());
			try{
				con.rollback();
			}
			catch(Exception e){
				e.printStackTrace();		
			}
        }
        finally{
			try{
				if(pstmt != null) pstmt.close();
				if(pstmt_activity_log != null) pstmt_activity_log.close();
				if(pstmt_activity_log_dtl != null) pstmt_activity_log_dtl.close();
				if(pstmt_work_schedule != null) pstmt_work_schedule.close();
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2){
				exception2.printStackTrace();		
			}
        }
		return hashmap1;
    }
} 
