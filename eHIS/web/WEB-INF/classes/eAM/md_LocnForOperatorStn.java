/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.SingleThreadModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
 * @todo Some of the class members should be moved to method level scope
 */
public class md_LocnForOperatorStn extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	Properties p;
	
	//String role ;
	//String practitioner;
	String operator_station ="" ;
String locale="";
	//String facility;
	//String teamid = "";
	//String setup_bl_dtls_in_ip_yn;
	//String msgtxt = "";
	//String msg_id = "";
	//String msg_txt = "";

	String location_type="";
	String finalSelect="";
	String mode="";

	Connection con;
	PreparedStatement pslPrepStmt;
	PreparedStatement delStmt;
	PreparedStatement delStmt2;

	

	String client_ip_address ;
    String facilityId;
	//String serviceURL;
	//String objectName;
	HttpSession session;
	
	//String specialty="";
	String facilityID="";
	boolean	insert = true;

	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		//serviceURL=(String) session.getValue("serviceURL");
 locale= p.getProperty("LOCALE");
		try{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			 mode = req.getParameter("mode");
			 if(mode==null){
				 mode="";
			 }			
			if(operation.equals("insert")){
				insertDeletePractForOperatorStation(req, res);
			}
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}finally{
            ConnectionManager.returnConnection(con, req);
   		}
	}
	private void insertDeletePractForOperatorStation(HttpServletRequest req, HttpServletResponse res){
		try{
			
			
			String addedById = p.getProperty( "login_user" ) ;
			 //String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById;
			//String modifiedDate = addedDate;
			res.setContentType("text/html;charset=UTF-8");
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			facilityID = req.getParameter("facilityID");
			if(facilityID == null) facilityID="";

			operator_station	= req.getParameter("operator_station");
			location_type 		= req.getParameter("location_type");			
			finalSelect			= req.getParameter("finalSelect");			
			String sqlIns="insert into am_locn_for_oper_stn ( facility_id,oper_stn_id,locn_type, locn_code,eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,global_locn_yn ) values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?) ";
			String sqlDel2 = "delete from am_restrn_for_oper_stn where facility_id=? and oper_stn_id =? and locn_type=? and locn_code=?";
			String sqlDel  = "delete from am_locn_for_oper_stn where facility_id=? and oper_stn_id =? and locn_type=? and locn_code=?";
			
			
			delStmt2 = con.prepareStatement(sqlDel2);

			
  
			StringTokenizer stmain=new StringTokenizer(finalSelect,"~");
			int mainTkn=stmain.countTokens();
			int resUpdate=0;
			String commit_yn="false";
                 
			for(int k=0;k<mainTkn;k++){
				
				String st=stmain.nextToken();
				
				StringTokenizer subTkn=new StringTokenizer(st,"$");
				String locn_code   = subTkn.nextToken();
				subTkn.nextToken();
				subTkn.nextToken();
				String eff_status  = subTkn.nextToken();	
				String global_locn_yn  = subTkn.nextToken();	
				
							
				if(eff_status.equals("E"))
					{					
				    delStmt  = con.prepareStatement(sqlDel);
					delStmt.setString(1,facilityID);
					delStmt.setString(2,operator_station);
					delStmt.setString(3,location_type);
					delStmt.setString(4,locn_code);
					resUpdate=delStmt.executeUpdate();

						if(delStmt		!=null)	delStmt.close();
					pslPrepStmt = con.prepareStatement(sqlIns);

					
					pslPrepStmt.setString(1,facilityID);
					pslPrepStmt.setString(2,operator_station);
					pslPrepStmt.setString(3,location_type);
					pslPrepStmt.setString(4,locn_code);
					pslPrepStmt.setString(5,eff_status);
					pslPrepStmt.setString(6,addedById);
					pslPrepStmt.setString(7,addedAtWorkstation);
					pslPrepStmt.setString(8,addedFacilityId);
					pslPrepStmt.setString(9,modifiedById);
					pslPrepStmt.setString(10,modifiedAtWorkstation);
					pslPrepStmt.setString(11,modifiedFacilityId);
					pslPrepStmt.setString(12,global_locn_yn);
                    
					resUpdate=pslPrepStmt.executeUpdate();
					
					
                    if(pslPrepStmt	!=null)	pslPrepStmt.close();
					
				}
				else if(eff_status.equals("D"))
					{
						
					pslPrepStmt = con.prepareStatement(sqlDel);
					pslPrepStmt.setString(1,facilityID);
					pslPrepStmt.setString(2,operator_station);
					pslPrepStmt.setString(3,location_type);
					pslPrepStmt.setString(4,locn_code);
				
					
					resUpdate=pslPrepStmt.executeUpdate();
					if(resUpdate>=1)
						 commit_yn="true";

					
											
					delStmt2.setString(1,facilityID);
					delStmt2.setString(2,operator_station);
					delStmt2.setString(3,location_type);
					delStmt2.setString(4,locn_code);				
					delStmt2.executeUpdate();
					
				}
				
			}
		

			//String s20 = "";
			 String msg1 = "";
			if((commit_yn=="true")||(resUpdate >=1)){
				insert=true;				
		 	}


			if(insert)
				{ 
               if(mode.equals("apply"))			
					{		
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,"RECORD_INSERTED", "SM");
						 msg1 = (String) mesg.get("message");
						out.println("<script>parent.parent.frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';</script>");
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg1,"UTF-8" ) + "&err_value=1");
						 mesg.clear();
					}else{							
							out.println("<script>parent.frames[1].frames[1].reloadresultPage('R')</script>");							
					}					
					con.commit();
				}
				else{   
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg1,"UTF-8" ) + "&err_value=1");
            }
						
					if(delStmt		!=null)	delStmt.close();
					if(delStmt2		!=null)	delStmt2.close();
					if(pslPrepStmt	!=null)	pslPrepStmt.close();
									
			
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con, req);		
		}
	}
}
