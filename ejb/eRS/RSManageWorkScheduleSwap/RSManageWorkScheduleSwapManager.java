/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleSwap;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSManageWorkScheduleSwap"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleSwap"
*	local-jndi-name="RSManageWorkScheduleSwap"
*	impl-class-name="eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapLocal"
*	remote-class="eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapLocalHome"
*	remote-class="eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleSwapManager implements SessionBean{
	Connection connection			= null;
	StringBuffer traceVal	    	= new StringBuffer();
	PreparedStatement pstmt_logid=null;
	PreparedStatement pstmt_insert_log=null;
	PreparedStatement pstmt_select_wrk_staff1=null;
	PreparedStatement pstmt_select_wrk_staff2=null;
	PreparedStatement pstmt_delet_wrk_staff1=null;
	PreparedStatement pstmt_delet_wrk_staff2=null;
	PreparedStatement pstmt_insert_log_dtl_del_staff1=null;
    PreparedStatement pstmt_insert_log_dtl_del_staff2=null;
	PreparedStatement pstmt_insert_log_dtl_insert_staff1=null;
    PreparedStatement pstmt_insert_log_dtl_insert_staff2=null;
	PreparedStatement pstmt_insert_wrk_staff1=null;
	PreparedStatement pstmt_insert_wrk_staff2=null;


	ResultSet rs_logid=null;
	ResultSet rs_select_wrk_staff1=null;
	ResultSet rs_select_wrk_staff2=null;
	String locale	 ="";

	
	public RSManageWorkScheduleSwapManager(){}

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
    public HashMap insert(HashMap tabData){

		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;

		String facility_id  = (String)tabData.get("p_facility_id");
		String workplace_code = (String)tabData.get("p_workplace_code");
		String schedule_date  = (String)tabData.get("p_schedule_date");
		String role_type  = (String)tabData.get("p_role_type");
		String staff_id  = (String)tabData.get("p_staff_id");

		String staff1_shift_code  = (String)tabData.get("staff1_shift_code");
		String new_workplace_code  = (String)tabData.get("new_workplace_code");
		String new_staff_id  = (String)tabData.get("new_staff_id");
		String staff2_shift_code  = (String)tabData.get("staff2_shift_code");
		String reason_code  = (String)tabData.get("reason");
		String remarks  = (String)tabData.get("remarks");
        String added_by_id			=	(String)tabData.get("added_by_id");
		String added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		String added_facility_id	=	(String)tabData.get("added_facility_id");
		locale= (String )tabData.get("locale");
		ppts				=	(Properties)tabData.get("properties");
		System.out.println("Valies in Manageworkscheduleswapmanager.java 100------->");
		System.out.println("tabData in ejb 98----|"+tabData+"|---locale in ejb 98----|"+locale+"|----");

		String facility_id1="";
		String workplace_code1="";
		String role_type1="";        
		String staff_id1="";
		String schedule_date1="";  
		String shift_code1="";
		String shift_mnemonic1= "";    
		String shift_start_time1="";
		String shift_end_time1="";
		String schedule_type1="";
		String requirement_id1= ""; 
		String staff_type1="";        
		String position_code1=""; 
		String locn_type1="";
		String actual_end_time1="";

		String facility_id2="";
		String workplace_code2="";
		String role_type2="";        
		String staff_id2="";
		String schedule_date2="";  
		String shift_code2="";
		String shift_mnemonic2= "";    
		String shift_start_time2="";
		String shift_end_time2="";
		String schedule_type2="";
		String requirement_id2= ""; 
		String staff_type2="";        
		String position_code2=""; 
		String locn_type2="";
		String actual_end_time2="";
		String modified_by_id		=	added_by_id;
		String modified_at_ws_no	=	added_at_ws_no;
		String modified_facility_id	=	added_facility_id;
		String activity_log_id="";

		boolean flag1 = false;
        boolean flag2 = false;
		boolean flag3 = false;
        boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		boolean flag8 = false;
		boolean flag9 = false;
		int insert1=0;
		int insert2=0;
		int insert3=0;
		int insert4=0;
		int insert5=0;
		int insert6=0;
		int insert7=0;
		int insert8=0;
		int insert9=0;
		
	   try{
			connection = ConnectionManager.getConnection(ppts);
            connection.setAutoCommit(false);
			String sql_activity = "select RS_ACTIVITY_LOG_SEQ.nextval activity_log_id from dual";

			pstmt_logid=connection.prepareStatement(sql_activity);
			rs_logid = pstmt_logid.executeQuery() ;
			while (rs_logid != null && rs_logid.next()) {
					activity_log_id=rs_logid.getString("activity_log_id");
			 }
			 if(pstmt_logid != null)
				 pstmt_logid.close();
			 if(rs_logid != null)
				 rs_logid.close();
			
			String sql_insert_log="insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,'SW',?,?,?,sysdate,?,?,?,sysdate,?,?)";

			pstmt_insert_log=connection.prepareStatement(sql_insert_log);
			pstmt_insert_log.setString(1,activity_log_id);
			pstmt_insert_log.setString(2,reason_code);
			pstmt_insert_log.setString(3,remarks);
			pstmt_insert_log.setString(4,added_by_id);
			pstmt_insert_log.setString(5,added_at_ws_no);
			pstmt_insert_log.setString(6,added_facility_id);
			pstmt_insert_log.setString(7,modified_by_id);
			pstmt_insert_log.setString(8,modified_at_ws_no);
			pstmt_insert_log.setString(9,modified_facility_id);
			
			insert1=pstmt_insert_log.executeUpdate();
			if(pstmt_insert_log != null)
				pstmt_insert_log.close();
			if(insert1>0){
				flag1=true;
			}
	
			String sql_shif_staff1="SELECT FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,to_char(SCHEDULE_DATE,'dd/mm/yyyy') schedule_date,SHIFT_CODE,SHIFT_MNEMONIC,to_char(SHIFT_START_TIME,'dd/mm/yyyyhh24:mi') SHIFT_START_TIME ,to_char(SHIFT_END_TIME,'dd/mm/yyyyhh24:mi') SHIFT_END_TIME,SCHEDULE_TYPE,to_char(USER_STEP_IN_TIME,'dd/mm/yyyyhh24:mi') USER_STEP_IN_TIME,to_char(USER_STEP_OUT_TIME,'dd/mm/yyyyhh24:mi') USER_STEP_OUT_TIME,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,LOCN_TYPE,ACTIVITY_LOG_ID,ADDED_BY_ID,to_char(ADDED_DATE,'dd/mm/yyyyhh24:mi') ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/yyyyhh24:mi') MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,to_char(ACTUAL_END_TIME,'dd/mm/yyyyhh24:mi') ACTUAL_END_TIME FROM rs_work_schedule WHERE facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";

			pstmt_select_wrk_staff1 = connection.prepareStatement(sql_shif_staff1) ;
			pstmt_select_wrk_staff1.setString(1,facility_id);
			pstmt_select_wrk_staff1.setString(2,workplace_code);
			pstmt_select_wrk_staff1.setString(3,role_type);
			pstmt_select_wrk_staff1.setString(4,staff_id);
			pstmt_select_wrk_staff1.setString(5,schedule_date);
			pstmt_select_wrk_staff1.setString(6,staff1_shift_code);
			rs_select_wrk_staff1 = pstmt_select_wrk_staff1.executeQuery() ;

			while (rs_select_wrk_staff1!= null && rs_select_wrk_staff1.next()) {
				facility_id1=rs_select_wrk_staff1.getString("facility_id");
				workplace_code1=rs_select_wrk_staff1.getString("workplace_code");
				role_type1=rs_select_wrk_staff1.getString("role_type");          
				staff_id1=rs_select_wrk_staff1.getString("staff_id");           
				schedule_date1=rs_select_wrk_staff1.getString("schedule_date");      
				shift_code1=rs_select_wrk_staff1.getString("shift_code");        
				shift_mnemonic1=rs_select_wrk_staff1.getString("shift_mnemonic");       
				shift_start_time1=rs_select_wrk_staff1.getString("shift_start_time");
				shift_end_time1=rs_select_wrk_staff1.getString("shift_end_time");    
				schedule_type1=rs_select_wrk_staff1.getString("schedule_type");  
				requirement_id1=rs_select_wrk_staff1.getString("requirement_id")==null ? "":rs_select_wrk_staff1.getString("requirement_id");         
				staff_type1=rs_select_wrk_staff1.getString("staff_type");            
				position_code1=rs_select_wrk_staff1.getString("position_code");         
				locn_type1=rs_select_wrk_staff1.getString("locn_type")==null ? "":rs_select_wrk_staff1.getString("locn_type");         
				actual_end_time1=rs_select_wrk_staff1.getString("ACTUAL_END_TIME");			
				
			}//end of selecting staff1 details
			if(pstmt_select_wrk_staff1 != null)
				pstmt_select_wrk_staff1.close();
			if(rs_select_wrk_staff1 != null)
				rs_select_wrk_staff1.close();
		
			String sql_shif_staff2="SELECT FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,to_char(SCHEDULE_DATE,'dd/mm/yyyy') schedule_date,SHIFT_CODE,SHIFT_MNEMONIC,to_char(SHIFT_START_TIME,'dd/mm/yyyyhh24:mi') SHIFT_START_TIME ,to_char(SHIFT_END_TIME,'dd/mm/yyyyhh24:mi') SHIFT_END_TIME,SCHEDULE_TYPE,to_char(USER_STEP_IN_TIME,'dd/mm/yyyyhh24:mi') USER_STEP_IN_TIME,to_char(USER_STEP_OUT_TIME,'dd/mm/yyyyhh24:mi') USER_STEP_OUT_TIME,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,LOCN_TYPE,ACTIVITY_LOG_ID,ADDED_BY_ID,to_char(ADDED_DATE,'dd/mm/yyyyhh24:mi') ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/yyyyhh24:mi') MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,to_char(ACTUAL_END_TIME,'dd/mm/yyyyhh24:mi') ACTUAL_END_TIME FROM rs_work_schedule WHERE facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";

			pstmt_select_wrk_staff2 = connection.prepareStatement(sql_shif_staff2) ;
			pstmt_select_wrk_staff2.setString(1,facility_id);
			pstmt_select_wrk_staff2.setString(2,new_workplace_code);
			pstmt_select_wrk_staff2.setString(3,role_type);
			pstmt_select_wrk_staff2.setString(4,new_staff_id);
			pstmt_select_wrk_staff2.setString(5,schedule_date);
			pstmt_select_wrk_staff2.setString(6,staff2_shift_code);
			rs_select_wrk_staff2 = pstmt_select_wrk_staff2.executeQuery() ;

			while (rs_select_wrk_staff2!= null && rs_select_wrk_staff2.next()) {
				facility_id2=rs_select_wrk_staff2.getString("facility_id");
				workplace_code2=rs_select_wrk_staff2.getString("workplace_code");
				role_type2=rs_select_wrk_staff2.getString("role_type");          
				staff_id2=rs_select_wrk_staff2.getString("staff_id");           
				schedule_date2=rs_select_wrk_staff2.getString("schedule_date");      
				shift_code2=rs_select_wrk_staff2.getString("shift_code");        
				shift_mnemonic2=rs_select_wrk_staff2.getString("shift_mnemonic");       
				shift_start_time2=rs_select_wrk_staff2.getString("shift_start_time");
				shift_end_time2=rs_select_wrk_staff2.getString("shift_end_time");    
				schedule_type2=rs_select_wrk_staff2.getString("schedule_type");  
				requirement_id2=rs_select_wrk_staff2.getString("requirement_id")==null ? "":rs_select_wrk_staff2.getString("requirement_id");         
				staff_type2=rs_select_wrk_staff2.getString("staff_type");            
				position_code2=rs_select_wrk_staff2.getString("position_code");  
				locn_type2=rs_select_wrk_staff2.getString("locn_type")==null ? "":rs_select_wrk_staff2.getString("locn_type");         
				actual_end_time2=rs_select_wrk_staff2.getString("ACTUAL_END_TIME");			

			}//end of selecting staff2 details
			if(pstmt_select_wrk_staff2 != null)
				pstmt_select_wrk_staff2.close();
			if(rs_select_wrk_staff2 != null)
				rs_select_wrk_staff2.close();

	
			String sql_insert_log_dtl_del_staff1="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'1','SW',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
				   
			pstmt_insert_log_dtl_del_staff1 = connection.prepareStatement(sql_insert_log_dtl_del_staff1) ;

			pstmt_insert_log_dtl_del_staff1.setString(1,activity_log_id);
			pstmt_insert_log_dtl_del_staff1.setString(2,facility_id1);
			pstmt_insert_log_dtl_del_staff1.setString(3,workplace_code1);
			pstmt_insert_log_dtl_del_staff1.setString(4,role_type1);
			pstmt_insert_log_dtl_del_staff1.setString(5,staff_id1);
			pstmt_insert_log_dtl_del_staff1.setString(6,schedule_date1);
			pstmt_insert_log_dtl_del_staff1.setString(7,shift_code1);
			pstmt_insert_log_dtl_del_staff1.setString(8,shift_mnemonic1);
			pstmt_insert_log_dtl_del_staff1.setString(9,shift_start_time1);
			pstmt_insert_log_dtl_del_staff1.setString(10,shift_end_time1);
			pstmt_insert_log_dtl_del_staff1.setString(11,schedule_type1);
			pstmt_insert_log_dtl_del_staff1.setString(12,requirement_id1);
			pstmt_insert_log_dtl_del_staff1.setString(13,staff_type1);
			pstmt_insert_log_dtl_del_staff1.setString(14,position_code1);
			pstmt_insert_log_dtl_del_staff1.setString(15,locn_type1);
			
			pstmt_insert_log_dtl_del_staff1.setString(16,added_by_id);
			pstmt_insert_log_dtl_del_staff1.setString(17,added_at_ws_no);
			pstmt_insert_log_dtl_del_staff1.setString(18,added_facility_id);
			pstmt_insert_log_dtl_del_staff1.setString(19,modified_by_id);
			pstmt_insert_log_dtl_del_staff1.setString(20,modified_at_ws_no);
			pstmt_insert_log_dtl_del_staff1.setString(21,modified_facility_id);
			pstmt_insert_log_dtl_del_staff1.setString(22,actual_end_time1);

			insert2=pstmt_insert_log_dtl_del_staff1.executeUpdate();
			if(pstmt_insert_log_dtl_del_staff1 !=null)
				pstmt_insert_log_dtl_del_staff1.close();

			if(insert2>0)	{
				flag2=true;
			}
			//end of inserting staff1 details into activity_log_detail before deleting
		
			String sql_delet_wrk_staff1="DELETE rs_work_schedule WHERE  facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";	
			
			pstmt_delet_wrk_staff1 =connection.prepareStatement(sql_delet_wrk_staff1);
			pstmt_delet_wrk_staff1.setString(1,facility_id1);
			pstmt_delet_wrk_staff1.setString(2,workplace_code1);
			pstmt_delet_wrk_staff1.setString(3,role_type1);
			pstmt_delet_wrk_staff1.setString(4,staff_id1);
			pstmt_delet_wrk_staff1.setString(5,schedule_date1);
			pstmt_delet_wrk_staff1.setString(6,shift_code1);
			
			insert3 = pstmt_delet_wrk_staff1.executeUpdate();
			if(pstmt_delet_wrk_staff1 != null)
				pstmt_delet_wrk_staff1.close();

			if(insert3>0)	{
				flag3=true;
			}
			//end of deleting staff1 details from rs_work_schedule

			String sql_insert_log_dtl_del_staff2="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'2','SW',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
			
			pstmt_insert_log_dtl_del_staff2 = connection.prepareStatement(sql_insert_log_dtl_del_staff2) ;
			pstmt_insert_log_dtl_del_staff2.setString(1,activity_log_id);
			pstmt_insert_log_dtl_del_staff2.setString(2,facility_id2);
			pstmt_insert_log_dtl_del_staff2.setString(3,workplace_code2);
			pstmt_insert_log_dtl_del_staff2.setString(4,role_type2);
			pstmt_insert_log_dtl_del_staff2.setString(5,staff_id2);
			pstmt_insert_log_dtl_del_staff2.setString(6,schedule_date2);
			pstmt_insert_log_dtl_del_staff2.setString(7,shift_code2);
			pstmt_insert_log_dtl_del_staff2.setString(8,shift_mnemonic2);
			pstmt_insert_log_dtl_del_staff2.setString(9,shift_start_time2);
			pstmt_insert_log_dtl_del_staff2.setString(10,shift_end_time2);
			pstmt_insert_log_dtl_del_staff2.setString(11,schedule_type2);
			pstmt_insert_log_dtl_del_staff2.setString(12,requirement_id2);
			pstmt_insert_log_dtl_del_staff2.setString(13,staff_type2);
			pstmt_insert_log_dtl_del_staff2.setString(14,position_code2);
			pstmt_insert_log_dtl_del_staff2.setString(15,locn_type2);
					
			pstmt_insert_log_dtl_del_staff2.setString(16,added_by_id);
			pstmt_insert_log_dtl_del_staff2.setString(17,added_at_ws_no);
			pstmt_insert_log_dtl_del_staff2.setString(18,added_facility_id);
			pstmt_insert_log_dtl_del_staff2.setString(19,modified_by_id);
			pstmt_insert_log_dtl_del_staff2.setString(20,modified_at_ws_no);
			pstmt_insert_log_dtl_del_staff2.setString(21,modified_facility_id);
			pstmt_insert_log_dtl_del_staff2.setString(22,actual_end_time2);

			insert4=pstmt_insert_log_dtl_del_staff2.executeUpdate();
			if(pstmt_insert_log_dtl_del_staff2 != null)
				pstmt_insert_log_dtl_del_staff2.close();

			if(insert4>0)	{
				flag4=true;
			}
			//end of inserting staff1_details into log_detail

			String sql_delet_wrk_staff2="DELETE rs_work_schedule WHERE  facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";	
			
			pstmt_delet_wrk_staff2 =connection.prepareStatement(sql_delet_wrk_staff2);
			pstmt_delet_wrk_staff2.setString(1,facility_id2);
			pstmt_delet_wrk_staff2.setString(2,workplace_code2);
			pstmt_delet_wrk_staff2.setString(3,role_type2);
			pstmt_delet_wrk_staff2.setString(4,staff_id2);
			pstmt_delet_wrk_staff2.setString(5,schedule_date2);
			pstmt_delet_wrk_staff2.setString(6,shift_code2);
			
			insert5 = pstmt_delet_wrk_staff2.executeUpdate();
			if(pstmt_delet_wrk_staff2 != null)
				pstmt_delet_wrk_staff2.close();

			if(insert5>0){
				flag5=true;
			}
			//end of deleting shaff2 details from rs_work_schdule

			String sql_insert_log_dtl_insert_staff1="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'3','SW',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
				   
			pstmt_insert_log_dtl_insert_staff1 = connection.prepareStatement(sql_insert_log_dtl_insert_staff1) ;

			pstmt_insert_log_dtl_insert_staff1.setString(1,activity_log_id);
			pstmt_insert_log_dtl_insert_staff1.setString(2,facility_id1);
			pstmt_insert_log_dtl_insert_staff1.setString(3,workplace_code1);
			pstmt_insert_log_dtl_insert_staff1.setString(4,role_type1);
			pstmt_insert_log_dtl_insert_staff1.setString(5,staff_id1);
			pstmt_insert_log_dtl_insert_staff1.setString(6,schedule_date1);
			pstmt_insert_log_dtl_insert_staff1.setString(7,shift_code2);
			pstmt_insert_log_dtl_insert_staff1.setString(8,shift_mnemonic2);
			pstmt_insert_log_dtl_insert_staff1.setString(9,shift_start_time2);
			pstmt_insert_log_dtl_insert_staff1.setString(10,shift_end_time2);
			pstmt_insert_log_dtl_insert_staff1.setString(11,schedule_type1);
			pstmt_insert_log_dtl_insert_staff1.setString(12,requirement_id1);
			pstmt_insert_log_dtl_insert_staff1.setString(13,staff_type1);
			pstmt_insert_log_dtl_insert_staff1.setString(14,position_code1);
			pstmt_insert_log_dtl_insert_staff1.setString(15,locn_type1);
			
			pstmt_insert_log_dtl_insert_staff1.setString(16,added_by_id);
			pstmt_insert_log_dtl_insert_staff1.setString(17,added_at_ws_no);
			pstmt_insert_log_dtl_insert_staff1.setString(18,added_facility_id);
			pstmt_insert_log_dtl_insert_staff1.setString(19,modified_by_id);
			pstmt_insert_log_dtl_insert_staff1.setString(20,modified_at_ws_no);
			pstmt_insert_log_dtl_insert_staff1.setString(21,modified_facility_id);
			pstmt_insert_log_dtl_insert_staff1.setString(22,actual_end_time2);

			insert6=pstmt_insert_log_dtl_insert_staff1.executeUpdate();
			if(pstmt_insert_log_dtl_insert_staff1 != null)
				pstmt_insert_log_dtl_insert_staff1.close();

			if(insert6>0){
				flag6=true;
			}
			//end of inserting into log_detail staff1 shift=staff2 shift

			String sql_insert_wrk_staff1="INSERT INTO rs_work_schedule( facility_id, workplace_code, role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,activity_log_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,actual_end_time) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
			pstmt_insert_wrk_staff1 = connection.prepareStatement(sql_insert_wrk_staff1) ;
			pstmt_insert_wrk_staff1.setString(1,facility_id1);
			pstmt_insert_wrk_staff1.setString(2,workplace_code1);           
			pstmt_insert_wrk_staff1.setString(3,role_type1);
			pstmt_insert_wrk_staff1.setString(4,staff_id1);
			pstmt_insert_wrk_staff1.setString(5,schedule_date1);
			pstmt_insert_wrk_staff1.setString(6,shift_code2);
			pstmt_insert_wrk_staff1.setString(7,shift_mnemonic2);
			pstmt_insert_wrk_staff1.setString(8,shift_start_time2);
			pstmt_insert_wrk_staff1.setString(9,shift_end_time2);
			
			pstmt_insert_wrk_staff1.setString(10,requirement_id1);
			pstmt_insert_wrk_staff1.setString(11,staff_type1);
			pstmt_insert_wrk_staff1.setString(12,position_code1);
			pstmt_insert_wrk_staff1.setString(13,activity_log_id);
			pstmt_insert_wrk_staff1.setString(14,added_by_id);
			pstmt_insert_wrk_staff1.setString(15,added_at_ws_no);
			pstmt_insert_wrk_staff1.setString(16,added_facility_id);
			pstmt_insert_wrk_staff1.setString(17,modified_by_id);
			pstmt_insert_wrk_staff1.setString(18,modified_at_ws_no);
			pstmt_insert_wrk_staff1.setString(19,modified_facility_id);
			pstmt_insert_wrk_staff1.setString(20,shift_end_time2);

			insert7=pstmt_insert_wrk_staff1.executeUpdate();
			if(pstmt_insert_wrk_staff1 != null)
				pstmt_insert_wrk_staff1.close();

			if(insert7>0)	{
				flag7=true;
			}
			//insert into rs_work_schdule  staff1 shift=staff2 shift

			String sql_insert_log_dtl_insert_staff2="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'4','SW',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
		
			pstmt_insert_log_dtl_insert_staff2 = connection.prepareStatement(sql_insert_log_dtl_insert_staff2) ;
		
			pstmt_insert_log_dtl_insert_staff2.setString(1,activity_log_id);
			pstmt_insert_log_dtl_insert_staff2.setString(2,facility_id2);
			pstmt_insert_log_dtl_insert_staff2.setString(3,workplace_code2);
			pstmt_insert_log_dtl_insert_staff2.setString(4,role_type2);
			pstmt_insert_log_dtl_insert_staff2.setString(5,staff_id2);
			pstmt_insert_log_dtl_insert_staff2.setString(6,schedule_date2);
			pstmt_insert_log_dtl_insert_staff2.setString(7,shift_code1);
			pstmt_insert_log_dtl_insert_staff2.setString(8,shift_mnemonic1);
			pstmt_insert_log_dtl_insert_staff2.setString(9,shift_start_time1);
			pstmt_insert_log_dtl_insert_staff2.setString(10,shift_end_time1);
			pstmt_insert_log_dtl_insert_staff2.setString(11,schedule_type2);
			pstmt_insert_log_dtl_insert_staff2.setString(12,requirement_id2);
			pstmt_insert_log_dtl_insert_staff2.setString(13,staff_type2);
			pstmt_insert_log_dtl_insert_staff2.setString(14,position_code2);
			pstmt_insert_log_dtl_insert_staff2.setString(15,locn_type2);
			
			pstmt_insert_log_dtl_insert_staff2.setString(16,added_by_id);
			pstmt_insert_log_dtl_insert_staff2.setString(17,added_at_ws_no);
			pstmt_insert_log_dtl_insert_staff2.setString(18,added_facility_id);
			pstmt_insert_log_dtl_insert_staff2.setString(19,modified_by_id);
			pstmt_insert_log_dtl_insert_staff2.setString(20,modified_at_ws_no);
			pstmt_insert_log_dtl_insert_staff2.setString(21,modified_facility_id);
			pstmt_insert_log_dtl_insert_staff2.setString(22,actual_end_time1);

			insert8=pstmt_insert_log_dtl_insert_staff2.executeUpdate();
			if(pstmt_insert_log_dtl_insert_staff2 != null)
				pstmt_insert_log_dtl_insert_staff2.close();

			if(insert8>0)	{
				flag8=true;
			}
			//end of inserting into log_detail  staff2 shift = staff1 shift 
	
			String sql_insert_wrk_staff2="INSERT INTO rs_work_schedule( facility_id, workplace_code, role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,activity_log_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,actual_end_time) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
			pstmt_insert_wrk_staff2 = connection.prepareStatement(sql_insert_wrk_staff2) ;
			pstmt_insert_wrk_staff2.setString(1,facility_id2);
			pstmt_insert_wrk_staff2.setString(2,workplace_code2);           
			pstmt_insert_wrk_staff2.setString(3,role_type2);
			pstmt_insert_wrk_staff2.setString(4,staff_id2);
			pstmt_insert_wrk_staff2.setString(5,schedule_date2);
			pstmt_insert_wrk_staff2.setString(6,shift_code1);
			pstmt_insert_wrk_staff2.setString(7,shift_mnemonic1);
			pstmt_insert_wrk_staff2.setString(8,shift_start_time1);
			pstmt_insert_wrk_staff2.setString(9,shift_end_time1);
			
			pstmt_insert_wrk_staff2.setString(10,requirement_id2);
			pstmt_insert_wrk_staff2.setString(11,staff_type2);
			pstmt_insert_wrk_staff2.setString(12,position_code2);
			pstmt_insert_wrk_staff2.setString(13,activity_log_id);
			pstmt_insert_wrk_staff2.setString(14,added_by_id);
			pstmt_insert_wrk_staff2.setString(15,added_at_ws_no);
			pstmt_insert_wrk_staff2.setString(16,added_facility_id);
			pstmt_insert_wrk_staff2.setString(17,modified_by_id);
			pstmt_insert_wrk_staff2.setString(18,modified_at_ws_no);
			pstmt_insert_wrk_staff2.setString(19,modified_facility_id);
			pstmt_insert_wrk_staff2.setString(20,shift_end_time1);

			insert9=pstmt_insert_wrk_staff2.executeUpdate();
			if(pstmt_insert_wrk_staff2 != null)
				pstmt_insert_wrk_staff2.close();
			//end of inserting into rs_wrrk_schdule  staff2 shift = staff1 shift 
			if(insert9>0)	{
				flag9=true;
			}
		 	
			 if(flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9){
                connection.commit();
 				retMap.put( "result", new Boolean( true ) ) ;
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
				messages.append((String)massageMap.get("message"));
			}else{
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
			}catch(Exception ex)	{
				ex.printStackTrace();
			}
		}
		finally{
			try{
	
				if(connection != null) {
					if(rs_logid != null) 
						rs_logid.close();
					if(rs_select_wrk_staff1 != null) 
						rs_select_wrk_staff1.close();
					if(pstmt_logid != null)
						pstmt_logid.close();
					if(pstmt_insert_log != null) 
						pstmt_insert_log.close();
					if(pstmt_select_wrk_staff1 != null) 
						pstmt_select_wrk_staff1.close();
					if(pstmt_insert_log_dtl_del_staff1 != null) 
						pstmt_insert_log_dtl_del_staff1.close();
					if(pstmt_delet_wrk_staff1 != null) 
						pstmt_delet_wrk_staff1.close();
					if(pstmt_insert_log_dtl_del_staff2 != null) 
						pstmt_insert_log_dtl_del_staff2.close();
					if(pstmt_insert_wrk_staff1 != null) 
						pstmt_insert_wrk_staff1.close();
					if(connection != null) 
						ConnectionManager.returnConnection(connection,ppts);
				}
			}
			catch(Exception ey){
				ey.printStackTrace();
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;
	}
}
