
package eOA ;

import java.net.InetAddress;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eDS.Common.*;
import eOA.*;

public class patientPortalConfigServlet extends javax.servlet.http.HttpServlet{  
    
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	PrintWriter out;
    Properties p;
    String facilityId;
    String login_user;
    String client_ip_address;
    String mode;
    boolean inserted;
    Connection con;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException{

	try {
	    
			HttpSession httpsession = request.getSession(false);
            facilityId				= (String)httpsession.getValue("facility_id");
            
            p						= (Properties)httpsession.getValue("jdbc");
            client_ip_address		= p.getProperty("client_ip_address");
            login_user				= p.getProperty("login_user");
            out						= response.getWriter();
            mode					= request.getParameter("mode");
           System.err.println("mode==>"+mode);
            if(mode.equals("insert")){
            	insertDetails(request, response);	
            }
            
            
	}
	catch (Exception e){
		out.println(e.toString());
		e.printStackTrace();

	}
}

private void insertDetails( HttpServletRequest request, HttpServletResponse response){
	JSONObject json						= new JSONObject();

	try {
		con = ConnectionManager.getConnection(request);
		con.setAutoCommit(false);
		response.setContentType("application/json");
   
		String s = "";
		String locale = p.getProperty("LOCALE");
	    int executableCount=0;
	    int result=0;
		String dayNo			= "" ;
		String startTime		= "" ;
		String endTime			= "" ;
		String noOfSlots		= "" ;
        String locn_code		= "" ;
		String pract_id			= "" ;
		String time_table_type	= "" ;
		String locn_type		= "" ;
		String resource_type	= "" ;
		int srlNo				= 0;
		String orgStartTime		= "" ;
		String orgEndTime		= "" ;
		String orgNoOfSlots		= "" ;
		String orgTimeTableType	= "" ;

		
		String finalData			= (request.getParameter("finalData")==null || request.getParameter("finalData")=="")?"":request.getParameter("finalData");
		String speciality_code		= (request.getParameter("speciality_code")==null || request.getParameter("speciality_code")=="")?"":request.getParameter("speciality_code");
		String eff_status			= (request.getParameter("eff_status")==null || request.getParameter("eff_status")=="")?"":request.getParameter("eff_status");
		
		//System.out.println("finalData: " + finalData);
		//System.out.println("speciality_code" + speciality_code);
		//System.out.println("eff_status" + eff_status);
			
	//	String deleteSql			= "delete from oa_portal_schedule_config where SPECIALITY_CODE='"+speciality_code+"'";
		String deleteSql			= "delete from oa_portal_schedule_config where SPECIALITY_CODE=? ";
		PreparedStatement prep1		= con.prepareStatement(deleteSql);
		prep1.setString(1,speciality_code);
		int delResult = prep1.executeUpdate();

		System.err.println("delResult==>"+delResult);

		prep1.close();


		String sql	="insert into oa_portal_schedule_config (FACILITY_ID,SRL_NO,RESOURCE_TYPE,LOCN_CODE,SPECIALITY_CODE, RESOURCE_ID,  DAY_NO, START_TIME, END_TIME, NO_OF_SLOTS, LOCN_TYPE,TIME_TABLE_TYPE, EFF_STATUS , ADDED_AT_WS_NO, ADDED_DATE, ADDED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_DATE, MODIFIED_BY_ID,ADDED_FACILITY_ID,MODIFIED_FACILITY_ID,ORG_START_TIME,ORG_END_TIME,ORG_NO_OF_SLOTS,ORG_TIME_TABLE_TYPE ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?,?,?,?,?)";
		
		PreparedStatement prep =  con.prepareStatement(sql);

		
		String[] groups = finalData.split("###");
		// Outer loop to iterate over each group
		for (int i = 0; i < groups.length; i++) {
		    String group = groups[i]; // Current group
		    // System.out.println("Processing group " + (i + 1) + ":");

		    // Split the current group into fields using "|~|" as the delimiter
		    String[] fields = group.split("\\|~\\|");

		    // Inner loop to iterate over each field in the current group
		    for (int j = 0; j < fields.length; j++) {
		        String field = fields[j]; // Current field
		        // System.out.println("  Field " + (j + 1) + ": " + field);
		    }
		    // System.out.println(); // Blank line for separating groups output
		    
		    dayNo				= fields[0];
			startTime			= fields[1];
			endTime				= fields[2];
			noOfSlots			= fields[3];
			locn_code			= fields[4];
			pract_id			= fields[5];
			time_table_type		= fields[6];
			locn_type			= fields[7];
			resource_type		= fields[8];
			srlNo				= Integer.parseInt(fields[9]);
			orgStartTime		= fields[10];
			orgEndTime			= fields[11];
			orgNoOfSlots		= fields[12];
			orgTimeTableType	= fields[13];
		    
		    
		    int k=1;
			prep.setString(k++, facilityId);
			prep.setInt(k++, srlNo );
			prep.setString(k++, resource_type);
			prep.setString(k++, locn_code);
			prep.setString(k++, speciality_code);
			prep.setString(k++, pract_id);
			prep.setString(k++, dayNo);
			prep.setString(k++, startTime);
			prep.setString(k++, endTime);
			prep.setString(k++, noOfSlots);
			prep.setString(k++, locn_type);
			prep.setString(k++, time_table_type);
			prep.setString(k++, eff_status);
			prep.setString(k++, client_ip_address);
			prep.setString(k++, login_user);
			prep.setString(k++, client_ip_address);
			prep.setString(k++, login_user);
			prep.setString(k++, facilityId);
			prep.setString(k++, facilityId);
			prep.setString(k++, orgStartTime);
			prep.setString(k++, orgEndTime);
			prep.setString(k++, orgNoOfSlots);
			prep.setString(k++, orgTimeTableType);
			prep.addBatch();
			executableCount++;
		}
		
		
//		StringTokenizer indtoken = new StringTokenizer(finalData, "###");
//		while (indtoken.hasMoreTokens()) {
//			String inner_string = indtoken.nextToken();
//			StringTokenizer stoken = new StringTokenizer(inner_string,"|~|");
//			while(stoken.hasMoreTokens()) {
//				// "3|~||~||~||~||~||~|1|~||~||~|1|~|23:00|~|23:30|~|1|~|1###"
//				dayNo				= stoken.nextToken();
//				System.out.println("1 " + dayNo);
//				startTime			= stoken.nextToken();
//				System.out.println("2 " + startTime);
//				endTime				= stoken.nextToken();
//				System.out.println("3 " + endTime);
//				noOfSlots			= stoken.nextToken();
//				System.out.println("4 " + noOfSlots);
//				locn_code			= stoken.nextToken();
//				System.out.println("5 " + locn_code);
//				pract_id			= stoken.nextToken();
//				System.out.println("6 " + pract_id);
//				time_table_type		= stoken.nextToken();
//				System.out.println("7 " + time_table_type);
//				locn_type			= stoken.nextToken();
//				System.out.println("8 " + locn_type);
//				resource_type		= stoken.nextToken();
//				System.out.println("9 " + resource_type);
//				srlNo				= Integer.parseInt(stoken.nextToken());
//				System.out.println("10 " + srlNo);
//				orgStartTime		= stoken.nextToken();
//				System.out.println("11 " + orgStartTime);
//				orgEndTime			= stoken.nextToken();
//				System.out.println("12 " + orgEndTime);
//				orgNoOfSlots		= stoken.nextToken();
//				System.out.println("13 " + orgNoOfSlots);
//				orgTimeTableType	= stoken.nextToken();
//				System.out.println("14 " + orgTimeTableType);
//			}
//
//			int i=1;
//			System.out.println("facilityId: " + facilityId);
//			prep.setString(i++, facilityId);
//			prep.setInt(i++, srlNo);
//			prep.setString(i++, resource_type);
//			prep.setString(i++, locn_code);
//			prep.setString(i++, speciality_code);
//			prep.setString(i++, pract_id);
//			prep.setString(i++, dayNo);
//			prep.setString(i++, startTime);
//			prep.setString(i++, endTime);
//			prep.setString(i++, noOfSlots);
//			prep.setString(i++, locn_type);
//			prep.setString(i++, time_table_type);
//			prep.setString(i++, eff_status);
//			prep.setString(i++, client_ip_address);
//			prep.setString(i++, login_user);
//			prep.setString(i++, client_ip_address);
//			prep.setString(i++, login_user);
//			prep.setString(i++, facilityId);
//			prep.setString(i++, facilityId);
//			prep.setString(i++, orgStartTime);
//			prep.setString(i++, orgEndTime);
//			prep.setString(i++, orgNoOfSlots);
//			prep.setString(i++, orgTimeTableType);
//			System.out.println("I: " + i) ;
//			prep.addBatch();
//			executableCount++;
//		}

		if(executableCount >0){
			int[] no = prep.executeBatch();
			result	 = no.length;
		}
		prep.close();
		
		System.err.println("executableCount==>"+executableCount);
		System.err.println("result==>"+result);
		
		
		if(executableCount == result){ 
				con.commit();
				json.put("success","true");	
				json.put("error","");	
		
		}else{
				con.rollback();
				json.put("success","false");	
				json.put("error","error");
		}
		response.getWriter().write(json.toString());

	} catch ( Exception e ) {
	
		e.printStackTrace();
		json.put("error",e);
		try{
			con.rollback();
			response.setContentType("application/json");
			response.getWriter().write(json.toString());
		}catch( Exception e1 ) {

		}
	//	
		
	}finally{
		if(con != null)  ConnectionManager.returnConnection(con, request);
	}

}	// end mehod
} // end class