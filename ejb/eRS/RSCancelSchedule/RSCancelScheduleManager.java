/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSCancelSchedule ;
import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSCancelSchedule"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSCancelSchedule"
*	local-jndi-name="RSCancelSchedule"
*	impl-class-name="eRS.RSCancelSchedule.RSCancelScheduleManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSCancelSchedule.RSCancelScheduleLocal"
*	remote-class="eRS.RSCancelSchedule.RSCancelScheduleRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSCancelSchedule.RSCancelScheduleLocalHome"
*	remote-class="eRS.RSCancelSchedule.RSCancelScheduleHome"
*	generate= "local,remote"
*
*
*/

public class RSCancelScheduleManager implements SessionBean {

	Connection connection = null;
	StringBuffer traceVal	= new StringBuffer();
	PreparedStatement pstmt_insert=null;
	PreparedStatement pstmt_insert1=null;
	PreparedStatement pstmt_select1=null;
	PreparedStatement pstmt_select2=null;
	PreparedStatement pstmt_del = null;
	PreparedStatement stmt_select=null;
	ResultSet res_sel = null;
	ResultSet res_sel1 = null;
	ResultSet res_sel2 = null;
	int rec_inserted;
	String activity_log_id="";
	String facil_id="";
	String work_code="";        
	String rol_type="";
	String staf_id="";
	String sch_date="";
	String shft_code="";

	String facility_id="";
	String frm_dt="";
	String to_dt="";
	String workplace_code="";
	String locn_type="";
	String position_code="";
	String role_type="";
	String staff_id="";
	String staff_type="";
	String reason_code="";
	String remarks="";
	String requirement_id="";
	String login_by_id="";
	String login_at_ws_no="";
	String login_facility_id="";
	String modified_by_id="";
	String modified_facility_id="";
	String modified_at_ws_no="";
	String facility_id1="";
   	String workplace_code1="";
	String role_type1="";            
	String staff_id1="";             
	String schedule_date1="";      
	String shift_code1="";           
	String shift_mnemonic1="";        
	String shift_start_time1="";
	String shift_end_time1="";     
	String schedule_type1="";          
	String requirement_id1="";         
	String staff_type1="";             
	String position_code1="";         
	String locn_type1="";
	String added_by_id1="";
	String added_date1="";             
	String added_at_ws_no1="";         
	String added_facility_id1="";      
	String modified_by_id1="";         
	String modified_date1="";          
	String modified_at_ws_no1="";      
	String modified_facility_id1="";
	String actual_end_time1="";

	public RSCancelScheduleManager(){}

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
	public HashMap delete(HashMap tabData){

		Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		
		try{								
				int totalRecords = Integer.parseInt((String )tabData.get("recdelhandler"));
				facility_id = (String )tabData.get("facility_id")==null? "":(String )tabData.get("facility_id");
				frm_dt = (String )tabData.get("frm_dt")==null? "":(String )tabData.get("frm_dt");
				to_dt = (String )tabData.get("to_dt")==null? "":(String )tabData.get("to_dt");
				workplace_code = (String )tabData.get("workplace_code")==null? "":(String )tabData.get("workplace_code");
				locn_type = (String )tabData.get("locn_type")==null? "":(String )tabData.get("locn_type");
				position_code = (String )tabData.get("position_code")==null? "":(String )tabData.get("position_code");
				role_type = (String )tabData.get("role_type")==null? "":(String )tabData.get("role_type");
				staff_id = (String )tabData.get("staff_id")==null? "":(String )tabData.get("staff_id");
				staff_type = (String )tabData.get("staff_type")==null? "":(String )tabData.get("staff_type");
				reason_code = (String )tabData.get("reason_code")==null? "":(String )tabData.get("reason_code");

				login_by_id = (String )tabData.get("added_by_id")==null? "":(String )tabData.get("added_by_id");
				login_at_ws_no = (String )tabData.get("added_at_ws_no")==null? "":(String )tabData.get("added_at_ws_no");
				login_facility_id = (String )tabData.get("added_facility_id")==null? "":(String )tabData.get("added_facility_id");
				modified_by_id = (String )tabData.get("modified_by_id")==null? "":(String )tabData.get("modified_by_id");
				modified_at_ws_no = (String )tabData.get("modified_at_ws_no")==null? "":(String )tabData.get("modified_at_ws_no");
				modified_facility_id = (String )tabData.get("modified_facility_id")==null? "":(String )tabData.get("modified_facility_id");

			    ppts = (Properties )tabData.get("properties");
	
				boolean flag=true;
				int flag1=0;
				int serial_num=0;
			
		        connection = ConnectionManager.getConnection(ppts);
				connection.setAutoCommit( false );
				
				String sql_select="select RS_ACTIVITY_LOG_SEQ.nextval activity_log_id from dual";
				stmt_select=connection.prepareStatement(sql_select);
				res_sel = stmt_select.executeQuery() ;
				while (res_sel != null && res_sel.next()) {
					activity_log_id=res_sel.getString("activity_log_id");
				}
				if(stmt_select != null)
					stmt_select.close();
				if(res_sel != null)
					res_sel.close();
				String sql_insert="insert into rs_activity_log (ACTIVITY_LOG_ID,ACTIVITY_TYPE,REASON_CODE,REMARKS,DATE_FROM,DATE_TO,LOCN_TYPE,FACILITY_ID,WORKPLACE_CODE,REQUIREMENT_ID,ROLE_TYPE,STAFF_TYPE,STAFF_ID,POSITION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,'C',?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";	

				pstmt_insert=connection.prepareStatement(sql_insert);
				pstmt_insert.setString(1,activity_log_id);
				pstmt_insert.setString(2,reason_code);
				pstmt_insert.setString(3,remarks);
				pstmt_insert.setString(4,frm_dt);
				pstmt_insert.setString(5,to_dt);
				pstmt_insert.setString(6,locn_type);
				pstmt_insert.setString(7,facility_id);
				pstmt_insert.setString(8,workplace_code);
				pstmt_insert.setString(9,requirement_id);
				pstmt_insert.setString(10,role_type);
				pstmt_insert.setString(11,staff_type);
				pstmt_insert.setString(12,staff_id);
				pstmt_insert.setString(13,position_code);
				pstmt_insert.setString(14,login_by_id);
				pstmt_insert.setString(15,login_at_ws_no);
				pstmt_insert.setString(16,login_facility_id);
				pstmt_insert.setString(17,modified_by_id);
				pstmt_insert.setString(18,modified_at_ws_no);
				pstmt_insert.setString(19,modified_facility_id);

				rec_inserted=pstmt_insert.executeUpdate();//record inserting 
				if(pstmt_insert != null)
					pstmt_insert.close();

				if(rec_inserted<0){
						flag=false;
						connection.rollback();
				}else{

				for(int i=0;i<totalRecords;i++){				
								 
					HashMap tabDataTemp = (HashMap )tabData.get(String.valueOf(i+1));
					facil_id=(String )tabDataTemp.get("facil_id");
					work_code=(String )tabDataTemp.get("work_code");
					rol_type=(String )tabDataTemp.get("rol_type");
					staf_id=(String )tabDataTemp.get("staf_id");
					sch_date=(String )tabDataTemp.get("sch_date");
					shft_code=(String )tabDataTemp.get("shft_code");
					
					String sql_select1="SELECT NVL(MAX(serial_num),0) + 1 maxVal  FROM rs_activity_log_dtl WHERE activity_log_id=? ";

					pstmt_select1 = connection.prepareStatement(sql_select1) ;
					pstmt_select1.setString(1,activity_log_id);
					res_sel1=pstmt_select1.executeQuery();

					while (res_sel1 != null && res_sel1.next()) {
						serial_num=Integer.parseInt(res_sel1.getString("maxVal"));
					}
					if(pstmt_select1 != null)
						pstmt_select1.close();
					if(res_sel1 != null)
						res_sel1.close();

					String sql_select2="SELECT FACILITY_ID,WORKPLACE_CODE,ROLE_TYPE,STAFF_ID,to_char(SCHEDULE_DATE,'dd/mm/yyyy') schedule_date,SHIFT_CODE,SHIFT_MNEMONIC,to_char(SHIFT_START_TIME,'dd/mm/yyyy hh24:mi') SHIFT_START_TIME ,to_char(SHIFT_END_TIME,'dd/mm/yyyy hh24:mi') SHIFT_END_TIME,SCHEDULE_TYPE,to_char(USER_STEP_IN_TIME,'dd/mm/yyyy hh24:mi') USER_STEP_IN_TIME,to_char(USER_STEP_OUT_TIME,'dd/mm/yyyy hh24:mi') USER_STEP_OUT_TIME,REQUIREMENT_ID,STAFF_TYPE,POSITION_CODE,LOCN_TYPE,ACTIVITY_LOG_ID,ADDED_BY_ID,to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/yyyy hh24:mi') MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,to_char(ACTUAL_END_TIME,'dd/mm/yyyy hh24:mi') ACTUAL_END_TIME FROM rs_work_schedule WHERE facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";

					pstmt_select2 = connection.prepareStatement(sql_select2) ;
					pstmt_select2.setString(1,facil_id);
					pstmt_select2.setString(2,work_code);
					pstmt_select2.setString(3,rol_type);
					pstmt_select2.setString(4,staf_id);
					pstmt_select2.setString(5,sch_date);
					pstmt_select2.setString(6,shft_code);
					res_sel2 = pstmt_select2.executeQuery() ;

					while (res_sel2 != null && res_sel2.next()) {
						facility_id1=res_sel2.getString("facility_id");
						workplace_code1=res_sel2.getString("workplace_code");
						role_type1=res_sel2.getString("role_type");          
						staff_id1=res_sel2.getString("staff_id");           
						schedule_date1=res_sel2.getString("schedule_date");      
						shift_code1=res_sel2.getString("shift_code");        
						shift_mnemonic1=res_sel2.getString("shift_mnemonic");       
						shift_start_time1=res_sel2.getString("shift_start_time");
						shift_end_time1=res_sel2.getString("shift_end_time");    
						schedule_type1=res_sel2.getString("schedule_type");  
						requirement_id1=res_sel2.getString("requirement_id")==null ? "":res_sel2.getString("requirement_id");         
						staff_type1=res_sel2.getString("staff_type");            
						position_code1=res_sel2.getString("position_code");         
						locn_type1=res_sel2.getString("locn_type");
						added_by_id1=res_sel2.getString("added_by_id");
						added_date1=res_sel2.getString("added_date");             
						added_at_ws_no1=res_sel2.getString("added_at_ws_no");     
						added_facility_id1=res_sel2.getString("added_facility_id");     
						modified_by_id1=res_sel2.getString("modified_by_id");        
						modified_date1=res_sel2.getString("modified_date");         
						modified_at_ws_no1=res_sel2.getString("modified_at_ws_no");      
						modified_facility_id1=res_sel2.getString("modified_facility_id");
						actual_end_time1=res_sel2.getString("ACTUAL_END_TIME");

							
					}
					if(pstmt_select2 != null)
						pstmt_select2.close();
					if(res_sel2 != null)
						res_sel2.close();
					
					String sql_insert1="INSERT INTO rs_activity_log_dtl ( activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,schedule_type,requirement_id,staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no ,modified_facility_id,ACTUAL_END_TIME ) VALUES (?,?,'C',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'), to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'), ?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'))";
					pstmt_insert1 = connection.prepareStatement(sql_insert1) ;

					pstmt_insert1.setString(1,activity_log_id);
					pstmt_insert1.setInt(2,serial_num);           
					pstmt_insert1.setString(3,facility_id1);
					pstmt_insert1.setString(4,workplace_code1);
					pstmt_insert1.setString(5,role_type1);
					pstmt_insert1.setString(6,staff_id1);
					pstmt_insert1.setString(7,schedule_date1);
					pstmt_insert1.setString(8,shift_code1);
					pstmt_insert1.setString(9,shift_mnemonic1);
					pstmt_insert1.setString(10,shift_start_time1);
					pstmt_insert1.setString(11,shift_end_time1);
					pstmt_insert1.setString(12,schedule_type1);
					pstmt_insert1.setString(13,requirement_id1);
					pstmt_insert1.setString(14,staff_type1);
					pstmt_insert1.setString(15,position_code1);
					pstmt_insert1.setString(16,locn_type1);
					
					pstmt_insert1.setString(17,added_by_id1);
					pstmt_insert1.setString(18,added_date1);
					pstmt_insert1.setString(19,added_at_ws_no1);
					pstmt_insert1.setString(20,added_facility_id1);
					pstmt_insert1.setString(21,modified_by_id1);
					pstmt_insert1.setString(22,modified_date1);
					pstmt_insert1.setString(23,modified_at_ws_no1);
					pstmt_insert1.setString(24,modified_facility_id1);
					pstmt_insert1.setString(25,actual_end_time1);

					pstmt_insert1.executeUpdate();//record inserting 
					if(pstmt_insert1 != null)
						pstmt_insert1.close();
				
					String sql_del="DELETE rs_work_schedule WHERE  facility_id = ? AND workplace_code = ? AND role_type = ? AND staff_id = ? AND schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? ";

					pstmt_del =connection.prepareStatement(sql_del);
					pstmt_del.setString(1,facil_id);
					pstmt_del.setString(2,work_code);
					pstmt_del.setString(3,rol_type);
					pstmt_del.setString(4,staf_id);
					pstmt_del.setString(5,sch_date);
					pstmt_del.setString(6,shft_code);

					flag1 = pstmt_del.executeUpdate();
					if(pstmt_del != null)
						pstmt_del.close();
			
					if (flag1<0){
						flag=false;
						connection.rollback();
						break;
					}

					pstmt_del.close();  
			  }
		}

		    if(flag==true)	{
				connection.commit();
				retMap.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORDS_DELETED" ) ;
			}			
		
		}catch(Exception e){
			try{	

				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				traceVal.append(e.getMessage());
				messages.append( " ERROR_IN_DELETING_FROM" ) ;
			}catch(Exception ex)	{
				ex.printStackTrace();
			}
		}finally{

			try{
				res_sel.close();
				res_sel1.close();
				res_sel2.close();
				pstmt_insert.close();
				pstmt_insert1.close();
				pstmt_select1.close();
				pstmt_select2.close();
				stmt_select.close();
				pstmt_del.close();

				if(connection != null) {
					ConnectionManager.returnConnection(connection,ppts);
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
