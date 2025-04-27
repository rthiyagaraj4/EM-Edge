/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSManageWorkScheduleChange;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;

 /**
*
* @ejb.bean
*	name="RSManageWorkScheduleChange"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSManageWorkScheduleChange"
*	local-jndi-name="RSManageWorkScheduleChange"
*	impl-class-name="eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeLocal"
*	remote-class="eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeLocalHome"
*	remote-class="eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeHome"
*	generate= "local,remote"
*
*
*/

public class RSManageWorkScheduleChangeManager implements SessionBean{
	Connection connection			= null;
	StringBuffer traceVal	    	= new StringBuffer();
	PreparedStatement pstmt_logid=null;
	PreparedStatement pstmt_insert_log=null;
	PreparedStatement pstmt_select_wrk=null;
	PreparedStatement pstmt_insert_log_dtl_old=null;
	PreparedStatement pstmt_delet_wrk=null;
    PreparedStatement pstmt_insert_log_dtl_new=null;
	PreparedStatement pstmt_insert_wrk=null;

	ResultSet rs_logid=null;
	ResultSet rs_select_wrk=null;
	String locale	 ="";
	
	public RSManageWorkScheduleChangeManager(){}

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
    public HashMap insert(HashMap tabData) {
		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;

		String old_shift  = (String)tabData.get("old_shift");
		String new_shift  = (String)tabData.get("new_shift");
		String new_mnemonic_key  = (String)tabData.get("new_mnemonic");
		String new_shift_start_time  = (String)tabData.get("new_shift_start_time");
		String new_shift_end_time  = (String)tabData.get("new_shift_end_time");
		String facility_id  = (String)tabData.get("p_facility_id");
		String workplace_code = (String)tabData.get("p_workplace_code");
		String schedule_date  = (String)tabData.get("p_schedule_date");
		String role_type  = (String)tabData.get("p_role_type");
		String staff_id  = (String)tabData.get("p_staff_id");
		String staff_type  = (String)tabData.get("p_staff_type");
		String position_code  = (String)tabData.get("p_position_code");
		String requirement_id  = (String)tabData.get("p_requirement_id");
		String reason_code  = (String)tabData.get("reason");
		String remarks  = (String)tabData.get("remarks");
        String added_by_id			=	(String)tabData.get("added_by_id");
		String added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		String added_facility_id	=	(String)tabData.get("added_facility_id");
		locale= (String )tabData.get("locale");
		ppts				=	(Properties)tabData.get("properties");
		/*System.out.println("Values in manageworkschedulechangemanager.ejb-------->");
		System.out.println("tabData  in ejb 94---->"+tabData);
		System.out.println("locale in ejb: 95----->"+locale);*/

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
		String locn_type="";

		String modified_by_id		=	added_by_id;
		String modified_at_ws_no	=	added_at_ws_no;
		String modified_facility_id	=	added_facility_id;
		String activity_log_id="";

		boolean flag1 = false;
        boolean flag2 = false;
		boolean flag3 = false;
        boolean flag4 = false;
		boolean flag5 = false;
		
		int rec_inserted_log1=0;
		int rec_inserted_log1_dtl1=0;
		int rec_inserted_log1_dtl2=0;
		int rec_deleted_wrk=0;
		int rec_inserted_wrk=0;
		try{
		   
			connection = ConnectionManager.getConnection(ppts);
            connection.setAutoCommit(false);
			String sql_activity = "select RS_ACTIVITY_LOG_SEQ.nextval activity_log_id from dual";

			pstmt_logid=connection.prepareStatement(sql_activity);
			rs_logid = pstmt_logid.executeQuery() ;
			while (rs_logid != null && rs_logid.next()) {
					activity_log_id=rs_logid.getString("activity_log_id");
			 }
			
			String sql_insert_log="insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,DATE_FROM,DATE_TO,LOCN_TYPE,FACILITY_ID,WORKPLACE_CODE,REQUIREMENT_ID,ROLE_TYPE,STAFF_TYPE,STAFF_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,'CH',?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			pstmt_insert_log=connection.prepareStatement(sql_insert_log);
			pstmt_insert_log.setString(1,activity_log_id);
			pstmt_insert_log.setString(2,reason_code);
			pstmt_insert_log.setString(3,remarks);
			pstmt_insert_log.setString(4,schedule_date);
			pstmt_insert_log.setString(5,schedule_date);
			pstmt_insert_log.setString(6,locn_type);
			pstmt_insert_log.setString(7,facility_id);
			pstmt_insert_log.setString(8,workplace_code);
			pstmt_insert_log.setString(9,requirement_id);
			pstmt_insert_log.setString(10,role_type);
			pstmt_insert_log.setString(11,staff_type);
			pstmt_insert_log.setString(12,staff_id);
			pstmt_insert_log.setString(13,position_code);
			pstmt_insert_log.setString(14,added_by_id);
			pstmt_insert_log.setString(15,added_at_ws_no);
			pstmt_insert_log.setString(16,added_facility_id);
			pstmt_insert_log.setString(17,modified_by_id);
			pstmt_insert_log.setString(18,modified_at_ws_no);
			pstmt_insert_log.setString(19,modified_facility_id);
			
			rec_inserted_log1=pstmt_insert_log.executeUpdate();

			if(rec_inserted_log1>0)
			{
				flag1=true;
			}

			String sql_shif_old="SELECT FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,to_char(SCHEDULE_DATE,'dd/mm/yyyy') schedule_date,SHIFT_CODE,SHIFT_MNEMONIC,to_char(SHIFT_START_TIME,'dd/mm/yyyyhh24:mi') SHIFT_START_TIME ,to_char(SHIFT_END_TIME,'dd/mm/yyyyhh24:mi') SHIFT_END_TIME,SCHEDULE_TYPE,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,LOCN_TYPE,ACTIVITY_LOG_ID,ADDED_BY_ID,to_char(ADDED_DATE,'dd/mm/yyyyhh24:mi') ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/yyyyhh24:mi')MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,to_char(ACTUAL_END_TIME,'dd/mm/yyyyhh24:mi') ACTUAL_END_TIME FROM rs_work_schedule WHERE facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";

					pstmt_select_wrk = connection.prepareStatement(sql_shif_old) ;
					pstmt_select_wrk.setString(1,facility_id);
					pstmt_select_wrk.setString(2,workplace_code);
					pstmt_select_wrk.setString(3,role_type);
					pstmt_select_wrk.setString(4,staff_id);
					pstmt_select_wrk.setString(5,schedule_date);
					pstmt_select_wrk.setString(6,old_shift);
					rs_select_wrk = pstmt_select_wrk.executeQuery() ;

					while (rs_select_wrk!= null && rs_select_wrk.next()) {
						facility_id1=rs_select_wrk.getString("facility_id");
						workplace_code1=rs_select_wrk.getString("workplace_code");
						role_type1=rs_select_wrk.getString("role_type");          
						staff_id1=rs_select_wrk.getString("staff_id");           
						schedule_date1=rs_select_wrk.getString("schedule_date");      
						shift_code1=rs_select_wrk.getString("shift_code");        
						shift_mnemonic1=rs_select_wrk.getString("shift_mnemonic");       
						shift_start_time1=rs_select_wrk.getString("shift_start_time");
						shift_end_time1=rs_select_wrk.getString("shift_end_time");    
						schedule_type1=rs_select_wrk.getString("schedule_type");  
						requirement_id1=rs_select_wrk.getString("requirement_id")==null ? "":rs_select_wrk.getString("requirement_id");         
						staff_type1=rs_select_wrk.getString("staff_type");            
						position_code1=rs_select_wrk.getString("position_code"); 
						locn_type1=rs_select_wrk.getString("locn_type")==null ? "":rs_select_wrk.getString("locn_type");         
						actual_end_time1=rs_select_wrk.getString("ACTUAL_END_TIME");
					}
						
				String sql_insert_log_dtl="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'1','CH',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),?,?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
				   
					pstmt_insert_log_dtl_old = connection.prepareStatement(sql_insert_log_dtl) ;

					pstmt_insert_log_dtl_old.setString(1,activity_log_id);
					pstmt_insert_log_dtl_old.setString(2,facility_id1);
					pstmt_insert_log_dtl_old.setString(3,workplace_code1);
					pstmt_insert_log_dtl_old.setString(4,role_type1);
					pstmt_insert_log_dtl_old.setString(5,staff_id1);
					pstmt_insert_log_dtl_old.setString(6,schedule_date1);
					pstmt_insert_log_dtl_old.setString(7,shift_code1);
					pstmt_insert_log_dtl_old.setString(8,shift_mnemonic1);
					pstmt_insert_log_dtl_old.setString(9,shift_start_time1);
					pstmt_insert_log_dtl_old.setString(10,shift_end_time1);
					pstmt_insert_log_dtl_old.setString(11,schedule_type1);
					pstmt_insert_log_dtl_old.setString(12,requirement_id1);
					pstmt_insert_log_dtl_old.setString(13,staff_type1);
					pstmt_insert_log_dtl_old.setString(14,position_code1);
					pstmt_insert_log_dtl_old.setString(15,locn_type1);
					pstmt_insert_log_dtl_old.setString(16,added_by_id);
					pstmt_insert_log_dtl_old.setString(17,added_at_ws_no);
					pstmt_insert_log_dtl_old.setString(18,added_facility_id);
					pstmt_insert_log_dtl_old.setString(19,modified_by_id);
					pstmt_insert_log_dtl_old.setString(20,modified_at_ws_no);
					pstmt_insert_log_dtl_old.setString(21,modified_facility_id);
					pstmt_insert_log_dtl_old.setString(22,actual_end_time1);
				
				    rec_inserted_log1_dtl1=pstmt_insert_log_dtl_old.executeUpdate();

				if(rec_inserted_log1_dtl1>0)
				{
					flag2=true;
				}

			String sql_delet_wrk="DELETE rs_work_schedule WHERE  facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";	
			
				pstmt_delet_wrk =connection.prepareStatement(sql_delet_wrk);
				pstmt_delet_wrk.setString(1,facility_id1);
				pstmt_delet_wrk.setString(2,workplace_code1);
				pstmt_delet_wrk.setString(3,role_type1);
				pstmt_delet_wrk.setString(4,staff_id1);
				pstmt_delet_wrk.setString(5,schedule_date1);
				pstmt_delet_wrk.setString(6,shift_code1);
				
				rec_deleted_wrk = pstmt_delet_wrk.executeUpdate();

				if(rec_deleted_wrk>0)
				{
					flag3=true;
				}
			
		String sql_insert_log_dtl1="INSERT INTO rs_activity_log_dtl (activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,'2','CH',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
				
			pstmt_insert_log_dtl_new = connection.prepareStatement(sql_insert_log_dtl1) ;
			pstmt_insert_log_dtl_new.setString(1,activity_log_id);
			pstmt_insert_log_dtl_new.setString(2,facility_id);
			pstmt_insert_log_dtl_new.setString(3,workplace_code);
			pstmt_insert_log_dtl_new.setString(4,role_type);
			pstmt_insert_log_dtl_new.setString(5,staff_id);
			pstmt_insert_log_dtl_new.setString(6,schedule_date);
			pstmt_insert_log_dtl_new.setString(7,new_shift);
			pstmt_insert_log_dtl_new.setString(8,new_mnemonic_key);
			pstmt_insert_log_dtl_new.setString(9,new_shift_start_time);
			pstmt_insert_log_dtl_new.setString(10,new_shift_end_time);
			pstmt_insert_log_dtl_new.setString(11,requirement_id);
			pstmt_insert_log_dtl_new.setString(12,staff_type);
			pstmt_insert_log_dtl_new.setString(13,position_code);
			pstmt_insert_log_dtl_new.setString(14,added_by_id);
			pstmt_insert_log_dtl_new.setString(15,added_at_ws_no);
			pstmt_insert_log_dtl_new.setString(16,added_facility_id);
			pstmt_insert_log_dtl_new.setString(17,modified_by_id);
			pstmt_insert_log_dtl_new.setString(18,modified_at_ws_no);
			pstmt_insert_log_dtl_new.setString(19,modified_facility_id);
			pstmt_insert_log_dtl_new.setString(20,new_shift_end_time);

			rec_inserted_log1_dtl2=pstmt_insert_log_dtl_new.executeUpdate();

			if(rec_inserted_log1_dtl2>0)
			{
				flag4=true;
			}

		String sql_insert_wrk="INSERT INTO rs_work_schedule( facility_id, workplace_code, role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,activity_log_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,actual_end_time) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyyhh24:mi'), to_date(?,'dd/mm/yyyyhh24:mi'),'A',?,?,?,?,?,sysdate, ?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyyhh24:mi'))";
			pstmt_insert_wrk = connection.prepareStatement(sql_insert_wrk) ;
			pstmt_insert_wrk.setString(1,facility_id);
			pstmt_insert_wrk.setString(2,workplace_code);           
			pstmt_insert_wrk.setString(3,role_type);
			pstmt_insert_wrk.setString(4,staff_id);
			pstmt_insert_wrk.setString(5,schedule_date);
			pstmt_insert_wrk.setString(6,new_shift);
			pstmt_insert_wrk.setString(7,new_mnemonic_key);
			pstmt_insert_wrk.setString(8,new_shift_start_time);
			pstmt_insert_wrk.setString(9,new_shift_end_time);
			pstmt_insert_wrk.setString(10,requirement_id);
			pstmt_insert_wrk.setString(11,staff_type);
			pstmt_insert_wrk.setString(12,position_code);
			pstmt_insert_wrk.setString(13,activity_log_id);
			pstmt_insert_wrk.setString(14,added_by_id);
			pstmt_insert_wrk.setString(15,added_at_ws_no);
			pstmt_insert_wrk.setString(16,added_facility_id);
			pstmt_insert_wrk.setString(17,modified_by_id);
			pstmt_insert_wrk.setString(18,modified_at_ws_no);
			pstmt_insert_wrk.setString(19,modified_facility_id);
			pstmt_insert_wrk.setString(20,new_shift_end_time);

			rec_inserted_wrk=pstmt_insert_wrk.executeUpdate();

			if(rec_inserted_wrk>0)
			{
				flag5=true;
			}
		
		 	 if(flag1 && flag2 && flag3 && flag4 && flag5){
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

					if(rs_logid != null) rs_logid.close();
					if(rs_select_wrk != null) rs_select_wrk.close();
					
					if(pstmt_logid != null) pstmt_logid.close();
					if(pstmt_insert_log != null) pstmt_insert_log.close();
					if(pstmt_select_wrk != null) pstmt_select_wrk.close();
					if(pstmt_insert_log_dtl_old != null) pstmt_insert_log_dtl_old.close();
					if(pstmt_delet_wrk != null) pstmt_delet_wrk.close();
					if(pstmt_insert_log_dtl_new != null) pstmt_insert_log_dtl_new.close();
					if(pstmt_insert_wrk != null) pstmt_insert_wrk.close();
					
					if(connection != null) ConnectionManager.returnConnection(connection,ppts);
				}
			}catch(Exception ey){
				ey.printStackTrace();
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;
	}
}
