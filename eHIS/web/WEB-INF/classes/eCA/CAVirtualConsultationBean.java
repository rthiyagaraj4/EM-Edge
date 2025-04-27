/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226	
---------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import java.text.SimpleDateFormat;
import webbeans.eCommon.*;
import eCommon.Common.*;

public class CAVirtualConsultationBean  implements Serializable {
	public CAVirtualConsultationBean()
	{
	}
	public String validateVitrualConsultation(String facility_id,String patient_id,String episode_type,String episode_id,String clinician_id){
		Connection con = null;
		String result ="N!N";		
		try{
			con = ConnectionManager.getConnection(); 
			String apptId=validateAttendPractationandVisitStatus( con, facility_id,  episode_id, clinician_id);
			System.out.println("----------------apptId------------>"+apptId+"<-------");
			if(!"N".equals(apptId)){
				if("N".equals(validateUnbldOutstAmtExistsYN( con, facility_id, patient_id, episode_type, episode_id, clinician_id))){
					result ="Y!"+getVirtualConsUrl( con, apptId);
				}
			}
		}catch(Exception e){	
			
		}finally{ 
				try {									
					ConnectionManager.returnConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}			
		}
		return result;		
	}
	public String validateAttendPractationandVisitStatus(Connection con,String facility_id,String episode_id,String clinician_id){		
		
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String apptId="";
		try{
				psmt = con.prepareStatement("SELECT ATTEND_PRACTITIONER_ID,VISIT_STATUS,APPT_ID FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?");	
				psmt.setString(1,facility_id);	;	
				psmt.setString(2,episode_id);	
				rs = psmt.executeQuery();
				String attendPractationerId="";
				String visitStatus="";
			
				while(rs!=null && rs.next()){
					System.out.println("----------->50");
					attendPractationerId= rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
					visitStatus= rs.getString("VISIT_STATUS")==null?"":rs.getString("VISIT_STATUS");
					apptId= rs.getString("APPT_ID")==null?"N":rs.getString("APPT_ID");
				}
				System.out.println("CAVirtualConsultationBean--------------->"+clinician_id+"------------>"+attendPractationerId+"-------->"+visitStatus);
				if(!clinician_id.equals(attendPractationerId)){
					System.out.println("-------------------------->55");
					return "N";
				}
				if("".equals(visitStatus) || "07".equals(visitStatus) || "09".equals(visitStatus)){
					System.out.println("-------------------------->59");
					return "N";
				}
		}catch(Exception e){	
			System.err.println("CAVirtualConsultationBean-------------validateAttendPractationandVisitStatus------->"+e.getMessage());
		}finally{ 
				try {
					if(rs!=null)rs.close();
					if(psmt!=null)psmt.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		return apptId;		
	}
	public String validateUnbldOutstAmtExistsYN(Connection con,String facility_id,String patient_id,String episode_type,String episode_id,String clinician_id){
		
		String result ="N";
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
				psmt = con.prepareStatement("SELECT blcommonproc.unbld_outst_amt_exists_yn(?,?,?,NULL,NULL,?,NULL) outstAmoutYN  FROM DUAL");	
				psmt.setString(1,facility_id);	
				psmt.setString(2,patient_id);	
				psmt.setString(3,episode_type);	
				psmt.setString(4,episode_id);	
				rs = psmt.executeQuery();
				while(rs!=null && rs.next()){
					System.out.println("------------------------>88");
					result= rs.getString("outstAmoutYN")==null?"N":rs.getString("outstAmoutYN");
					System.out.println("------------------------>"+result);
				}
		}catch(Exception e){	
			System.err.println("CAVirtualConsultationBean-------------validateUnbldOutstAmtExistsYN------->"+e.getMessage());
		}finally{ 
				try {
					if(rs!=null)rs.close();
					if(psmt!=null)psmt.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		return result;		
	}
public String getVirtualConsUrl(Connection con,String apptId){	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String appUrl=" ";
		String appType=" ";
		String appStatus=" ";
		try{
			
				psmt = con.prepareStatement("SELECT APPT_URL,APPT_TYPE,APPT_TYPE_STATUS FROM OA_APPT WHERE APPT_REF_NO=? ");	
				psmt.setString(1,apptId);		
				rs = psmt.executeQuery();				
				while(rs!=null && rs.next()){
					appUrl= rs.getString("APPT_URL")==null?" ":rs.getString("APPT_URL");
					appType= rs.getString("APPT_TYPE")==null?" ":rs.getString("APPT_TYPE");
					appStatus= rs.getString("APPT_TYPE_STATUS")==null?" ":rs.getString("APPT_TYPE_STATUS");
				}
			
		}catch(Exception e){	
			System.err.println("CAVirtualConsultationBean-------------getVirtualConsUrl------->"+e.getMessage());
		}finally{ 
				try {
					if(rs!=null)rs.close();
					if(psmt!=null)psmt.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		System.out.println("==CAVirtualConsultationBean============>"+appUrl+"~"+appType+"~"+appStatus+"~");
		return appUrl+"~"+appType+"~"+appStatus+"~";		
	}
}
