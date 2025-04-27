/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleAllocate;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSManageWorkScheduleAllocate"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleAllocate"
*	local-jndi-name="RSManageWorkScheduleAllocate"
*	impl-class-name="eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateLocal"
*	remote-class="eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateLocalHome"
*	remote-class="eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleAllocateManager implements SessionBean{
	Connection con = null;
	PreparedStatement pstmt = null;
    PreparedStatement pstmt_rs_activity_log = null;
    PreparedStatement pstmt_rs_activity_log_dtl = null;
    PreparedStatement pstmt_rs_work_schedule = null;
	ResultSet rs = null;
	String locale	 ="";
    public RSManageWorkScheduleAllocateManager(){
    }
    public void ejbCreate() throws CreateException{
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
    public HashMap insert(Properties properties, HashMap allocate) {
		StringBuffer messages = new StringBuffer() ;
        HashMap tempHash = new HashMap();
		try{
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			String facility_id  = (String)allocate.get("FACILITY_ID");
			String workplace_code = (String)allocate.get("WORKPLACE_CODE");
			String schedule_date  = (String)allocate.get("SCHEDULE_DATE");
			String role_type  = (String)allocate.get("ROLE_TYPE");
			String staff_id  = (String)allocate.get("STAFF_ID");
			String staff_type  = (String)allocate.get("STAFF_TYPE");
			String position_code  = (String)allocate.get("POSITION_CODE");
			String reason_code  = (String)allocate.get("REASON_CODE");
			String remarks  = (String)allocate.get("REMARKS");
			String requirement_id  = (String)allocate.get("REQUIREMENT_ID");
			String shift_code  = (String)allocate.get("SHIFT_CODE");
			String shift_mnemonic  = (String)allocate.get("SHIFT_MNEMONIC");
			System.err.println("shift_mnemonic---->"+shift_mnemonic);
			String shift_start_time  = (String)allocate.get("SHIFT_START_TIME");
			String shift_end_time  = (String)allocate.get("SHIFT_END_TIME");
			String added_by_id = (String)allocate.get("ADDED_BY_ID");
			String added_at_ws_no = (String)allocate.get("ADDED_AT_WS_NO");
			String added_facility_id = (String)allocate.get("ADDED_FACILITY_ID");
			String modified_by_id = (String)allocate.get("MODIFIED_BY_ID");
			String modified_at_ws_no = (String)allocate.get("MODIFIED_AT_WS_NO");
			String modified_facility_id = (String)allocate.get("MODIFIED_FACILITY_ID");
			String activity_log_id = "";
			locale= (String )allocate.get("locale");
			// To get activity log id
			String sql_activity = "select RS_ACTIVITY_LOG_SEQ.nextval activity_log_id from dual";
						
			pstmt = con.prepareStatement(sql_activity);
			rs = pstmt.executeQuery();
						
			if(rs!=null)
			{
				if(rs.next())
				{
					activity_log_id = rs.getString("activity_log_id");
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			// end of activity
			String sql_insert_rs_activity_log = "insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,DATE_FROM,DATE_TO,FACILITY_ID,WORKPLACE_CODE,REQUIREMENT_ID,ROLE_TYPE,STAFF_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,STAFF_TYPE) values (?,'AL',?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			pstmt_rs_activity_log = con.prepareStatement(sql_insert_rs_activity_log);
			pstmt_rs_activity_log.setString(1,activity_log_id);
			pstmt_rs_activity_log.setString(2,reason_code);
			pstmt_rs_activity_log.setString(3,remarks);
			pstmt_rs_activity_log.setString(4,schedule_date);
			pstmt_rs_activity_log.setString(5,schedule_date);
			pstmt_rs_activity_log.setString(6,facility_id);
			pstmt_rs_activity_log.setString(7,workplace_code);
			pstmt_rs_activity_log.setString(8,requirement_id);
			pstmt_rs_activity_log.setString(9,role_type);
			pstmt_rs_activity_log.setString(10,staff_id);
			pstmt_rs_activity_log.setString(11,position_code);
			pstmt_rs_activity_log.setString(12,added_by_id);
			pstmt_rs_activity_log.setString(13,added_at_ws_no);
			pstmt_rs_activity_log.setString(14,added_facility_id);
			pstmt_rs_activity_log.setString(15,modified_by_id);
			pstmt_rs_activity_log.setString(16,modified_at_ws_no);
			pstmt_rs_activity_log.setString(17,modified_facility_id);
			pstmt_rs_activity_log.setString(18,staff_type);
			int chk_prop = pstmt_rs_activity_log.executeUpdate();
			if (chk_prop==0)
				throw new Exception("rs_activity_log Not inserted");
			String sql_insert_rs_activity_log_dtl = "insert into rs_activity_log_dtl (ACTIVITY_LOG_ID,SERIAL_NUM,ACTIVITY_TYPE,SCHEDULE_TYPE,FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,REQUIREMENT_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ACTUAL_END_TIME,STAFF_TYPE)values(?,'1','AL','A',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'),?)";
			pstmt_rs_activity_log_dtl = con.prepareStatement(sql_insert_rs_activity_log_dtl);
			pstmt_rs_activity_log_dtl.setString(1,activity_log_id);
			pstmt_rs_activity_log_dtl.setString(2,facility_id);
			pstmt_rs_activity_log_dtl.setString(3,workplace_code);
			pstmt_rs_activity_log_dtl.setString(4,role_type);
			pstmt_rs_activity_log_dtl.setString(5,staff_id);
			pstmt_rs_activity_log_dtl.setString(6,schedule_date);
			pstmt_rs_activity_log_dtl.setString(7,shift_code);
			pstmt_rs_activity_log_dtl.setString(8,shift_mnemonic);
			pstmt_rs_activity_log_dtl.setString(9,shift_start_time);
			pstmt_rs_activity_log_dtl.setString(10,shift_end_time);
			pstmt_rs_activity_log_dtl.setString(11,requirement_id);
			pstmt_rs_activity_log_dtl.setString(12,position_code);
			pstmt_rs_activity_log_dtl.setString(13,added_by_id);
			pstmt_rs_activity_log_dtl.setString(14,added_at_ws_no);
			pstmt_rs_activity_log_dtl.setString(15,added_facility_id);
			pstmt_rs_activity_log_dtl.setString(16,modified_by_id);
			pstmt_rs_activity_log_dtl.setString(17,modified_at_ws_no);
			pstmt_rs_activity_log_dtl.setString(18,modified_facility_id);
			pstmt_rs_activity_log_dtl.setString(19,shift_end_time);
			pstmt_rs_activity_log_dtl.setString(20,staff_type);
			int chk_dtl = pstmt_rs_activity_log_dtl.executeUpdate();
			if(chk_dtl==0)
				throw new Exception("rs_activity_log_dtl Not inserted");
			
			String sql_insert_rs_work_schedule = "insert into rs_work_schedule(FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,SCHEDULE_TYPE,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,ACTIVITY_LOG_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ACTUAL_END_TIME)values(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
			pstmt_rs_work_schedule = con.prepareStatement(sql_insert_rs_work_schedule);
			pstmt_rs_work_schedule.setString(1,facility_id);
			pstmt_rs_work_schedule.setString(2,workplace_code);
			pstmt_rs_work_schedule.setString(3,role_type);
			pstmt_rs_work_schedule.setString(4,staff_id);
			pstmt_rs_work_schedule.setString(5,schedule_date);
			pstmt_rs_work_schedule.setString(6,shift_code);
			pstmt_rs_work_schedule.setString(7,shift_mnemonic);
			pstmt_rs_work_schedule.setString(8,shift_start_time);
			pstmt_rs_work_schedule.setString(9,shift_end_time);
			pstmt_rs_work_schedule.setString(10,requirement_id);
			pstmt_rs_work_schedule.setString(11,staff_type);
			pstmt_rs_work_schedule.setString(12,position_code);
			pstmt_rs_work_schedule.setString(13,activity_log_id);
			pstmt_rs_work_schedule.setString(14,added_by_id);
			pstmt_rs_work_schedule.setString(15,added_at_ws_no);
			pstmt_rs_work_schedule.setString(16,added_facility_id);
			pstmt_rs_work_schedule.setString(17,modified_by_id);
			pstmt_rs_work_schedule.setString(18,modified_at_ws_no);
			pstmt_rs_work_schedule.setString(19,modified_facility_id);
			pstmt_rs_work_schedule.setString(20,shift_end_time);
			int chk_sch = pstmt_rs_work_schedule.executeUpdate();
			/*System.out.println("facility_id in ejb:1-----|"+facility_id+"|-------");
			
			System.out.println("role_type in ejb:3-----|"+role_type+"|-------");
			System.out.println("staff_id in ejb:4-----|"+staff_id+"|-------");
			System.out.println("schedule_date in ejb:5-----|"+schedule_date+"|-------");
			System.out.println("shift_code in ejb:6----|"+shift_code+"|-------");
			System.out.println("shift_mnemonic in ejb:7-----|"+shift_mnemonic+"|-------");
			System.out.println("shift_start_time in ejb:8-----|"+shift_start_time+"|-------");
			System.out.println("shift_end_time in ejb:9-----|"+shift_end_time+"|-------");
			System.out.println("requirement_id in ejb:10-----|"+requirement_id+"|-------");
			System.out.println("staff_type in ejb:11-----|"+staff_type+"|-------");
			System.out.println("position_code in ejb:12-----|"+position_code+"|-------");
			System.out.println("activity_log_id in ejb:13-----|"+activity_log_id+"|-------");
			System.out.println("added_by_id in ejb:14-----|"+added_by_id+"|-------");
			System.out.println("added_at_ws_no in ejb:15-----|"+added_at_ws_no+"|-------");
			System.out.println("added_facility_id in ejb:16-----|"+added_facility_id+"|-------");
			System.out.println("modified_by_id in ejb:17-----|"+modified_by_id+"|-------");
			System.out.println("modified_at_ws_no in ejb:18-----|"+modified_at_ws_no+"|-------");
			System.out.println("modified_facility_id in ejb:19-----|"+modified_facility_id+"|-------");
			System.out.println("shift_end_time in ejb:20-----|"+shift_end_time+"|-------");*/
			if(chk_sch==0)
				throw new Exception("rs_work_schedule Not inserted");
			con.commit();
			tempHash.put("status",new Boolean(true));
			Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
			messages.append((String)massageMap.get("message"));
			System.out.println("massageMap in ejb:182-----|"+massageMap+"|-------");
        }
        catch(Exception exception){
			exception.printStackTrace();
			tempHash.put("status",new Boolean(false));
			Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","RS");
			messages.append((String)massageMap.get("message"));
            messages.append("Error in main try " + exception.getMessage());
			try{
				con.rollback();
			}
			catch(Exception es){
				es.printStackTrace();		
			}
        }
        finally{
			try{
				if(pstmt != null) 
					pstmt.close();
				if(pstmt_rs_activity_log != null) 
					pstmt_rs_activity_log.close();
				if(pstmt_rs_activity_log_dtl != null) 
					pstmt_rs_activity_log_dtl.close();
				if(pstmt_rs_work_schedule != null) 
					pstmt_rs_work_schedule.close();
				if(con != null)
					ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2){
				exception2.printStackTrace();		
			}
        }
		tempHash.put( "message", messages.toString() ) ;
		return tempHash;
    }
}
