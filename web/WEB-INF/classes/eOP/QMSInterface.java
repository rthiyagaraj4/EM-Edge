/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**	This File contains all the SQL SELECT queries used in the ChangePatientSubNames.jsp file.
	*	Last Modified Date 12/29/2005 10:21 AM 
	*/

package eOP;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import eXH.*;

public class QMSInterface implements Serializable
{
	public static String getQueueNumber(HashMap params, HashMap audit_params) throws Exception
	{
		String qms_queue_num="";
		try{			
			String room_num = (String)params.get("room_num");
			String queue_id=(String)params.get("queue_id");
			String pract_id = (String)params.get("pract_id");
			
			QueueManager ext_interface = new QueueManager();
			
			String[] issueResponse = new String[3];
			issueResponse=ext_interface.issueTicket(room_num,queue_id,pract_id,audit_params);
			
			if("0".equals(issueResponse[0])){
				qms_queue_num=issueResponse[1];
			}
			else{
				qms_queue_num="-1";
				System.err.println("Response from QMS for issueTicket ----> "+issueResponse[2]);
			}
		}catch(Exception e){
			System.err.println("QMS getQueueNumber - Exception during interface call issueTicket: "+e.getMessage());
			qms_queue_num="-1";
			e.printStackTrace();
			//return qms_queue_num;
		}
		return qms_queue_num;
	}
	
	public static void cancelQueueNumber(String queue_num, HashMap audit_params,Connection con) throws Exception
	{      
	     Statement stmt=null;
		 int res=0;
		 con.setAutoCommit(false);
		try{
			QueueManager ext_interface = new QueueManager();
			
			String cancelResponse[]=ext_interface.cancelTicket(queue_num,audit_params);
			System.err.println("Response from QMS for cancelTicket ----> "+cancelResponse[1]);
			
			}
			catch(Exception e){
			System.err.println("QMS cancel Ticket - Exception during interface call : "+e.getMessage());
			e.printStackTrace();
			}
			try{
			String facility_id=(String)audit_params.get("facilityID");
			String encounter_id=(String)audit_params.get("encounterID");
			String upd_qms_call_cnt="update op_patient_queue set qms_call_count = 0 where facility_id='"+facility_id+"' and encounter_id ='"+encounter_id+"'";
			stmt = con.createStatement();
			res = stmt.executeUpdate(upd_qms_call_cnt);
			if(res != 0){				
				con.commit();
			}else{
			   con.rollback();
			}   
			}catch(Exception e1){
					con.rollback();
			       e1.printStackTrace();				   
			}finally{
			      if(stmt!=null) stmt.close();
			}
	}
	
	public static void finishConsultation(String queue_num, String room_num,HashMap audit_params){
		
		try{
			QueueManager ext_interface = new QueueManager();
			String checkoutResponse[]=ext_interface.finishConsultation(queue_num,audit_params);
			if(!("0".equals(checkoutResponse[0]))){
			System.err.println("Response from QMS for finishConsultation ----> "+checkoutResponse[2]);
			}
			/*Commented as per the clarification document.
			String callNextResponse[]=ext_interface.callNextTicket(room_num,additionalParams);
			if(!("0".equals(callNextResponse[0]))){
			System.err.println("Response from QMS for callNextTicket ----> "+callNextResponse[2]);
			}*/
			}catch(Exception e){
			System.err.println("QMS finishConsultation Ticket - Exception during interface call : "+e.getMessage());
			e.printStackTrace();
			}
	}

	//Method declaration modified for the SCF - ML-Bru-SCF-1074
	public static String callPatient(String queue_num, HashMap audit_params, Connection con)throws Exception{
		String errorFromQMS="";//Added for the SCF - ML-Bru-SCF-1074
		Statement stmt=null;
		int res =0;
        con.setAutoCommit(false);
		try{
			QueueManager ext_interface = new QueueManager();
			

			String callTicketResponse[]=ext_interface.callTicket(queue_num,audit_params);
			if(!("0".equals(callTicketResponse[0]))){
			System.err.println("Response from QMS for callPatient ----> "+callTicketResponse[2]);
			errorFromQMS=callTicketResponse[2];//Added for the SCF - ML-Bru-SCF-1074
			}else{//Added for the SCF - ML-Bru-SCF-1074
				String facility_id=(String)audit_params.get("facilityID");
				String encounter_id=(String)audit_params.get("encounterID");
				String upd_qms_call_cnt="update op_patient_queue set qms_call_count = (nvl(qms_call_count,0)+1) where facility_id='"+facility_id+"' and encounter_id ='"+encounter_id+"'";
				stmt = con.createStatement();
				res = stmt.executeUpdate(upd_qms_call_cnt);
				if(res != 0){					
					con.commit();
				}else{
                    con.rollback();
				}
				
			}
			}catch(Exception e){
			System.err.println("QMS callPatient - Exception during interface call : "+e.getMessage());
			con.rollback();
			e.printStackTrace();			
			errorFromQMS="QMS callPatient - Exception during interface call";
			}finally{
			 if(stmt!=null) stmt.close();
			}		
			return errorFromQMS;
	}
	
	//Method declaration modified for the SCF - ML-Bru-SCF-1074
	public static String callNextPatient(String room_num, HashMap audit_params){
		String errorFromQMS="";//Added for the SCF - ML-Bru-SCF-1074
		try{
			QueueManager ext_interface = new QueueManager();
			
			String callNextResponse[]=ext_interface.callNextTicket(room_num,audit_params);
			if(!("0".equals(callNextResponse[0]))){
			System.err.println("Response from QMS for callNextPatient ----> "+callNextResponse[2]);
			errorFromQMS=callNextResponse[2];//Added for the SCF - ML-Bru-SCF-1074
			}
			
			}catch(Exception e){
			System.err.println("QMS callNextPatient - Exception during interface call : "+e.getMessage());
			e.printStackTrace();
			errorFromQMS="QMS callNextPatient - Exception during interface call";
			}		
		return errorFromQMS;
	}
	public static String getEMQueueId(String facilityId,String p_queue_date,String p_locn_code, String p_locn_type,String p_pract_id,String room_num,String other_res_type, String other_res_code,String appt_walk_in,String ws_no,String addedById,Connection con){
	
		String queue_id_sql="select op_getQueueID(?,?,?,?,?,?,?,?,?,?,?) queue_id from dual";
		String queue_id="";
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try{
		pstmt=con.prepareStatement(queue_id_sql);
		
		pstmt.setString(1,facilityId);
		pstmt.setString(2,p_queue_date);
		pstmt.setString(3,p_locn_type);
		pstmt.setString(4,p_locn_code);
		pstmt.setString(5,p_pract_id);
		pstmt.setString(6,room_num);
		pstmt.setString(7,other_res_type);
		pstmt.setString(8,other_res_code);
		pstmt.setString(9,appt_walk_in);
		pstmt.setString(10,addedById);
		pstmt.setString(11,ws_no);
		rs=pstmt.executeQuery();
		while(rs.next()){
			queue_id=rs.getString(1);
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return queue_id;
	}
		
	
	public static String isClinicQMSInterfaced(String p_locn_code,String p_facility_id,Connection con){
		String qms_interface_sql="select QMS_INTERFACED_YN from op_clinic where FACILITY_ID=? and clinic_code =?";
		String qms_interfaced_yn="N";
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try{
		pstmt=con.prepareStatement(qms_interface_sql);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_locn_code);
		
		rs=pstmt.executeQuery();
		while(rs.next()){
			qms_interfaced_yn=checkForNull(rs.getString("QMS_INTERFACED_YN"),"N");
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();			
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		return qms_interfaced_yn;
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}


	public static boolean isSiteSpecific(Connection con,String module_id,String function_id){
		String siteSpecificSQL="select count(*) count from SM_FUNCTION_CONTROL a, sm_site_param b where a.MODULE_ID=? and a.FUNCTIONALITY_ID =? and a.SITE_ID =b.customer_id";
		int count=0;
		boolean siteSpecific=false;
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(siteSpecificSQL);
			pstmt.setString(1,module_id);
			pstmt.setString(2,function_id);

			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				siteSpecific=true;
			}
		}catch(Exception ex){
			System.err.println("Exception in isSiteSpecific - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return siteSpecific;
	}
}
