/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleTransfer;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;

/**
*
* @ejb.bean
*	name="RSManageWorkScheduleTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleTransfer"
*	local-jndi-name="RSManageWorkScheduleTransfer"
*	impl-class-name="eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferLocal"
*	remote-class="eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferLocalHome"
*	remote-class="eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleTransferManager implements SessionBean{
	Connection con = null;
	PreparedStatement pstmt = null;
    PreparedStatement pstmt_rs_activity_log = null;
    PreparedStatement pstmt_rs_activity_log_dtl = null;
    PreparedStatement pstmt_rs_activity_log_dtl_old = null;
    PreparedStatement pstmt_rs_work_schedule = null;
	ResultSet rs = null;
	String activity_log_id = "";
	String serial_num = "";
	String facility_id  = "";
	String schedule_date  = "";
	String role_type  = "";
	String staff_id  = "";
	String staff_type  = "";
	String position_code  = "";
	String reason_code  = "";
	String remarks  = "";
	String requirement_id  = "";
	String workplace_code  = "";
	String old_workplace_code  = "";
	String shift_code = "";
	String shift_mnemonic = "";
	String shift_start_time  = "";
	String shift_end_time  = "";
	String actual_end_time  = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
   public RSManageWorkScheduleTransferManager(){
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
    public HashMap create(Properties properties, ArrayList transfer_finalval){
		StringBuffer  stringbuffer = new StringBuffer();
        HashMap tempHash = new HashMap();
		HashMap transfer = null;
		int j = 1;
		try{
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
			for(int i=0;i<transfer_finalval.size();i++){
				transfer = (HashMap) transfer_finalval.get(i);
				reason_code = (String) transfer.get("REASON_CODE");
				remarks = (String) transfer.get("REMARKS");
				requirement_id = (String) transfer.get("REQUIREMENT_ID");
				position_code = (String) transfer.get("POSITION_CODE");
				facility_id = (String) transfer.get("FACILITY_ID");
				workplace_code = (String) transfer.get("WORKPLACE_CODE");
				old_workplace_code = (String) transfer.get("OLD_WORKPLACE_CODE");
				role_type = (String) transfer.get("ROLE_TYPE");
				staff_id = (String) transfer.get("STAFF_ID");
				staff_type = (String) transfer.get("STAFF_TYPE");
				position_code = (String) transfer.get("POSITION_CODE");
				schedule_date = (String) transfer.get("SCHEDULE_DATE");
				shift_code = (String) transfer.get("SHIFT_CODE");
				shift_mnemonic = (String) transfer.get("SHIFT_MNEMONIC");
				added_by_id = (String)transfer.get("ADDED_BY_ID");
				added_at_ws_no = (String)transfer.get("ADDED_AT_WS_NO");
				added_facility_id = (String)transfer.get("ADDED_FACILITY_ID");
				modified_by_id = (String)transfer.get("MODIFIED_BY_ID");
				modified_at_ws_no = (String)transfer.get("MODIFIED_AT_WS_NO");
				modified_facility_id = (String)transfer.get("MODIFIED_FACILITY_ID");
				// To get activity_log_id and Start,end and actual time
				String sql_time = "select to_char(shift_start_time,'dd/mm/yyyyhh24:mi') shift_start_time,to_char(shift_end_time,'dd/mm/yyyyhh24:mi') shift_end_time,to_char(actual_end_time,'dd/mm/yyyyhh24:mi') actual_end_time,RS_ACTIVITY_LOG_SEQ.nextval activity_log_id from rs_work_schedule,dual where facility_id = '"+facility_id+"' and workplace_code = '"+old_workplace_code+"' and role_type = '"+role_type+"' and staff_id = '"+staff_id+"' and schedule_date = to_date('"+schedule_date+"','dd/mm/yyyy')and shift_code ='"+shift_code+"'";
				pstmt = con.prepareStatement(sql_time);
				rs = pstmt.executeQuery();
				if(rs!=null){
					if(rs.next()){
						shift_start_time = rs.getString("shift_start_time");
						shift_end_time = rs.getString("shift_end_time");
						actual_end_time = rs.getString("actual_end_time");
						activity_log_id = rs.getString("activity_log_id");
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				//End of getting activity_log_id and Start,end and actual time
				String sql_insert_rs_activity_log = "insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,DATE_FROM,DATE_TO,FACILITY_ID,WORKPLACE_CODE,REQUIREMENT_ID,ROLE_TYPE,STAFF_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,STAFF_TYPE) values (?,'TR',?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
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
				pstmt_rs_activity_log.addBatch();
				String sql_insert_rs_activity_log_dtl_old = "insert into rs_activity_log_dtl (ACTIVITY_LOG_ID,SERIAL_NUM,ACTIVITY_TYPE,SCHEDULE_TYPE,FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,REQUIREMENT_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ACTUAL_END_TIME,STAFF_TYPE) values (?,?,'TR','A',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'),?)";
				serial_num = "" + j;
				pstmt_rs_activity_log_dtl_old = con.prepareStatement(sql_insert_rs_activity_log_dtl_old);
				pstmt_rs_activity_log_dtl_old.setString(1,activity_log_id);
				pstmt_rs_activity_log_dtl_old.setString(2,serial_num);
				pstmt_rs_activity_log_dtl_old.setString(3,facility_id);
				pstmt_rs_activity_log_dtl_old.setString(4,old_workplace_code);
				pstmt_rs_activity_log_dtl_old.setString(5,role_type);
				pstmt_rs_activity_log_dtl_old.setString(6,staff_id);
				pstmt_rs_activity_log_dtl_old.setString(7,schedule_date);
				pstmt_rs_activity_log_dtl_old.setString(8,shift_code);
				pstmt_rs_activity_log_dtl_old.setString(9,shift_mnemonic);
				pstmt_rs_activity_log_dtl_old.setString(10,shift_start_time);
				pstmt_rs_activity_log_dtl_old.setString(11,shift_end_time);
				pstmt_rs_activity_log_dtl_old.setString(12,requirement_id);
				pstmt_rs_activity_log_dtl_old.setString(13,position_code);
				pstmt_rs_activity_log_dtl_old.setString(14,added_by_id);
				pstmt_rs_activity_log_dtl_old.setString(15,added_at_ws_no);
				pstmt_rs_activity_log_dtl_old.setString(16,added_facility_id);
				pstmt_rs_activity_log_dtl_old.setString(17,modified_by_id);
				pstmt_rs_activity_log_dtl_old.setString(18,modified_at_ws_no);
				pstmt_rs_activity_log_dtl_old.setString(19,modified_facility_id);
				pstmt_rs_activity_log_dtl_old.setString(20,actual_end_time);
				pstmt_rs_activity_log_dtl_old.setString(21,staff_type);
				pstmt_rs_activity_log_dtl_old.addBatch();
				String sql_dele = "delete from rs_work_schedule where facility_id = ? and workplace_code = ? and role_type = ? and staff_id = ? and schedule_date = to_date(?,'dd/mm/yyyy')and shift_code =?";
				pstmt = con.prepareStatement(sql_dele);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,old_workplace_code);
				pstmt.setString(3,role_type);
				pstmt.setString(4,staff_id);
				pstmt.setString(5,schedule_date);
				pstmt.setString(6,shift_code);
				pstmt.addBatch();
				String sql_insert_rs_work_schedule = "insert into rs_work_schedule(FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,SCHEDULE_TYPE,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,ACTIVITY_LOG_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ACTUAL_END_TIME) values (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
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
				pstmt_rs_work_schedule.addBatch();
				String sql_insert_rs_activity_log_dtl = "insert into rs_activity_log_dtl (ACTIVITY_LOG_ID,SERIAL_NUM,ACTIVITY_TYPE,SCHEDULE_TYPE,FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,SCHEDULE_DATE,SHIFT_CODE,SHIFT_MNEMONIC,SHIFT_START_TIME,SHIFT_END_TIME,REQUIREMENT_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ACTUAL_END_TIME,STAFF_TYPE) values (?,?,'TR','A',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'),to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'),?)";
				j = j+1;
				serial_num = "" + j;
				pstmt_rs_activity_log_dtl = con.prepareStatement(sql_insert_rs_activity_log_dtl);
				pstmt_rs_activity_log_dtl.setString(1,activity_log_id);
				pstmt_rs_activity_log_dtl.setString(2,serial_num);
				pstmt_rs_activity_log_dtl.setString(3,facility_id);
				pstmt_rs_activity_log_dtl.setString(4,workplace_code);
				pstmt_rs_activity_log_dtl.setString(5,role_type);
				pstmt_rs_activity_log_dtl.setString(6,staff_id);
				pstmt_rs_activity_log_dtl.setString(7,schedule_date);
				pstmt_rs_activity_log_dtl.setString(8,shift_code);
				pstmt_rs_activity_log_dtl.setString(9,shift_mnemonic);
				pstmt_rs_activity_log_dtl.setString(10,shift_start_time);
				pstmt_rs_activity_log_dtl.setString(11,shift_end_time);
				pstmt_rs_activity_log_dtl.setString(12,requirement_id);
				pstmt_rs_activity_log_dtl.setString(13,position_code);
				pstmt_rs_activity_log_dtl.setString(14,added_by_id);
				pstmt_rs_activity_log_dtl.setString(15,added_at_ws_no);
				pstmt_rs_activity_log_dtl.setString(16,added_facility_id);
				pstmt_rs_activity_log_dtl.setString(17,modified_by_id);
				pstmt_rs_activity_log_dtl.setString(18,modified_at_ws_no);
				pstmt_rs_activity_log_dtl.setString(19,modified_facility_id);
				pstmt_rs_activity_log_dtl.setString(20,actual_end_time);
				pstmt_rs_activity_log_dtl.setString(21,staff_type);
				pstmt_rs_activity_log_dtl.addBatch();			
			}
			// Execute batch for rs_activity_log Insertion
			int[] batch_result = pstmt_rs_activity_log.executeBatch();
			if(pstmt_rs_activity_log != null)
				pstmt_rs_activity_log.close();
			for (int m=0;m<batch_result.length;m++ ){
				if (batch_result[m]<0  && batch_result[m] != -2)	{
					pstmt_rs_activity_log.cancel();
					throw new Exception("rs_activity_log Insertion Failed");
				}
			}
			// End of batch
			// Execute batch for rs_activity_log_dtl_old Insertion
			int[] batch_result1 = pstmt_rs_activity_log_dtl_old.executeBatch();
			for (int m1=0;m1<batch_result1.length;m1++ ){
				if (batch_result[m1]<0  && batch_result[m1] != -2)	{
					pstmt_rs_activity_log_dtl_old.cancel();
					throw new Exception("rs_activity_log_dtl Insertion Failed");
				}
			}
			// End of batch
			// Execute batch for rs_work_schedule Insertion
			int[] batch_result2 = pstmt_rs_work_schedule.executeBatch();
			for (int m2=0;m2<batch_result2.length;m2++ ){
				if (batch_result[m2]<0  && batch_result[m2] != -2){
					pstmt_rs_work_schedule.cancel();
					throw new Exception("rs_work_schedule Insertion Failed");
				}
			}
			// End of batch
			// Execute batch for rs_work_schedule Deletion
			int[] batch_result3 = pstmt.executeBatch();
			for (int m3=0;m3<batch_result3.length;m3++ ){
				if (batch_result[m3]<=0  && batch_result[m3] != -2){
					pstmt.cancel();
					throw new Exception("rs_work_schedule Deletion Failed");
				}
			}
			// End of batch
			// Execute batch for rs_activity_log_dtl_old Insertion
			int[] batch_result4 = pstmt_rs_activity_log_dtl.executeBatch();
			for (int m4=0;m4<batch_result4.length;m4++ ){
				if (batch_result[m4]<0  && batch_result[m4] != -2){
					pstmt_rs_activity_log_dtl.cancel();
					throw new Exception("rs_activity_log_dtl Insertion Failed");
				}
			}
			// End of batch
			con.commit();
			tempHash.put("status",new Boolean(true));
			tempHash.put("error",stringbuffer.toString());
        }
        catch(Exception exception){
            stringbuffer.append("Error in main try " + exception.getMessage());
			exception.printStackTrace();
			tempHash.put("status",new Boolean(false));
			tempHash.put("error",stringbuffer.toString());
			try{
				con.rollback();
			}
			catch(Exception es){
				es.printStackTrace();		
			}
        }
        finally{
			try{
				if(pstmt != null) pstmt.close();
				if(pstmt_rs_activity_log != null) pstmt_rs_activity_log.close();
				if(pstmt_rs_activity_log_dtl != null) pstmt_rs_activity_log_dtl.close();
				if(pstmt_rs_work_schedule != null) pstmt_rs_work_schedule.close();
				if(con != null)ConnectionManager.returnConnection(con, properties);
			}
			catch(Exception exception2){
				exception2.printStackTrace();		
			}
        }
		return tempHash;
    }
}
