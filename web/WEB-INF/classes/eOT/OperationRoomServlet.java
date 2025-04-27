/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class OperationRoomServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		
		    String curr_date=req.getParameter("curr_date");
			
			String mode=req.getParameter("mode");
			String facilityid=req.getParameter("facility_id");
			String theatre_type=req.getParameter("theatre_type");
			String oper_room_code=req.getParameter("oper_room_code");
			if(oper_room_code==null || oper_room_code.equals("null"))
				oper_room_code=req.getParameter("oper_room_code1");
			String long_desc=req.getParameter("long_desc");
			if(long_desc==null || long_desc.equals("null"))
		    
				long_desc=req.getParameter("long_desc1");
			String short_desc=req.getParameter("short_desc");
			if(short_desc==null || short_desc.equals("null"))
                 short_desc=req.getParameter("short_desc1");
			String oper_room_seq=req.getParameter("oper_room_seq");
			if(oper_room_seq==null || oper_room_seq.equals("null"))
                 oper_room_seq=req.getParameter("oper_room_seq1");
			String restrict_by_splty_yn = req.getParameter("restrict_by_splty_yn");
			if (restrict_by_splty_yn==null || restrict_by_splty_yn.equals("null"))
				restrict_by_splty_yn="N";
			String over_booking_allowed_yn = req.getParameter("over_booking_allowed_yn");
			if (over_booking_allowed_yn==null || over_booking_allowed_yn.equals("null"))
				over_booking_allowed_yn="N";
			String no_of_overbookings_allowed = req.getParameter("No_Of_Overbookings");//Added by lakshmi against MO-CRF-20058
			String service_code=req.getParameter("service_code");
            String wd_start_time=req.getParameter("wd_start_time");
			if(wd_start_time==null || wd_start_time.equals("null"))
                 wd_start_time=req.getParameter("wd_start_time1");
			String wd_end_time=req.getParameter("wd_end_time");
			if(wd_end_time==null || wd_end_time.equals("null"))
                 wd_end_time=req.getParameter("wd_end_time1");
			String hd_start_time=req.getParameter("hd_start_time");
			if(hd_start_time==null || hd_start_time.equals("null"))
                 hd_start_time=req.getParameter("hd_start_time1");
			String hd_end_time=req.getParameter("hd_end_time");
			if(hd_end_time==null || hd_end_time.equals("null"))
                 hd_end_time=req.getParameter("hd_end_time1");


			String rec_room_code=req.getParameter("rec_room_code");
			if(rec_room_code==null || rec_room_code.equals("null"))
				rec_room_code=req.getParameter("rec_room_code1");
			String chargable_room=req.getParameter("chargable_room");
			if(chargable_room==null || chargable_room.equals("null"))
				chargable_room="N";
				

			String wd_start_date_time=curr_date+" "+wd_start_time;
			String wd_end_date_time=curr_date+" "+wd_end_time;
	        String hd_start_date_time=curr_date+" "+hd_start_time;
			String hd_end_date_time=curr_date+" "+hd_end_time;
			PrintWriter out;

			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
			HttpSession session=req.getSession(false);
			out=res.getWriter();
						
			//masterXMLParse=new eOT.MasterXMLParse();
			String client_ip_address="";
			String facility_id = "";	
			String login_user=""; 
			//String added_date="";
			//String modified_date="";
			String locale = "";
			


			java.util.Properties prop = null;
			facility_id = (String)session.getValue( "facility_id" ) ;
			prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = prop.getProperty( "client_ip_address" );
			login_user = prop.getProperty( "login_user" );
			locale = prop.getProperty("LOCALE");
			
			//CRF-004 Authorize Slots for Booking - Rajesh V 
			String userInfo = req.getParameter("childWinParams");
			//CRF-004 Authorize Slots for Booking - Rajesh V 
							
			Connection con = null;		
			PreparedStatement pstmt=null;        
			int flag=0;
		
		try{				
			String msg="";
			con = ConnectionManager.getConnection(req);
			if(mode.equals("insert")){       
				//String sqlInsert="INSERT INTO OT_OPER_ROOM (OPERATING_FACILITY_ID,OPER_ROOM_CODE,LONG_DESC,SHORT_DESC,THEATRE_TYPE,WD_START_TIME,WD_END_TIME,HD_START_TIME,HD_END_TIME,RESTRICT_BY_SPLTY_YN,OVER_BOOKING_ALLOWED_YN,OPER_ROOM_SEQ,SERVICE_CODE,CHARGEABLE_YN,DFLT_RECOVERY_ROOM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI') ,to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				String sqlInsert="INSERT INTO OT_OPER_ROOM (OPERATING_FACILITY_ID,OPER_ROOM_CODE,LONG_DESC,SHORT_DESC,THEATRE_TYPE,WD_START_TIME,WD_END_TIME,HD_START_TIME,HD_END_TIME,RESTRICT_BY_SPLTY_YN,OVER_BOOKING_ALLOWED_YN,OPER_ROOM_SEQ,SERVICE_CODE,CHARGEABLE_YN,DFLT_RECOVERY_ROOM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OVER_BOOK_COUNT) VALUES (?,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI') ,to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),to_date(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";//Modified by lakshmi againt MO-CRF-20058
				pstmt=con.prepareStatement(sqlInsert);

				pstmt.setString(1,facilityid);
				pstmt.setString(2,oper_room_code);
				pstmt.setString(3,long_desc);
				pstmt.setString(4,short_desc);
				pstmt.setString(5,theatre_type);
				pstmt.setString(6,wd_start_date_time);
				pstmt.setString(7,wd_end_date_time);
				pstmt.setString(8,hd_start_date_time);
				pstmt.setString(9,hd_end_date_time);
				pstmt.setString(10,restrict_by_splty_yn);
				pstmt.setString(11,over_booking_allowed_yn);
				pstmt.setString(12,oper_room_seq);
				pstmt.setString(13,service_code);
				pstmt.setString(14,chargable_room);
				pstmt.setString(15,rec_room_code);
				pstmt.setString(16,login_user);
				pstmt.setString(17,client_ip_address);
				pstmt.setString(18,facility_id);
				pstmt.setString(19,login_user);
				pstmt.setString(20,client_ip_address);
				pstmt.setString(21,facility_id);
				pstmt.setString(22,no_of_overbookings_allowed);//Added by lakshmi against MO-CRF-20058
				//System.out.println("hi::beforeinsert");//lakshmi
				//pstmt.execute();	
				flag = pstmt.executeUpdate();
				//System.out.println("hi::afterinsert");//lakshmi
				//CRF-004 Authorize Slots for Booking - Rajesh V 
				//int result = 0; //Common-ICN-0055
				if(!("".equals(userInfo)))
					flag = operSlotsInsertUpdate(req,res,oper_room_code);
				//CRF-004 Authorize Slots for Booking - Rajesh V 
				
			}else if(mode.equals("modify")){			
				//String sqlModify="UPDATE OT_OPER_ROOM SET OPERATING_FACILITY_ID=?,LONG_DESC=?,SHORT_DESC=?,THEATRE_TYPE=?,WD_START_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),WD_END_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),HD_START_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), HD_END_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), RESTRICT_BY_SPLTY_YN=?, OVER_BOOKING_ALLOWED_YN=?, OPER_ROOM_SEQ=?, SERVICE_CODE=?,CHARGEABLE_YN=?,DFLT_RECOVERY_ROOM_CODE=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where OPER_ROOM_CODE=?";
				String sqlModify="UPDATE OT_OPER_ROOM SET OPERATING_FACILITY_ID=?,LONG_DESC=?,SHORT_DESC=?,THEATRE_TYPE=?,WD_START_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),WD_END_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'),HD_START_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), HD_END_TIME=TO_DATE(?,'DD/MM/YYYY HH24:MI'), RESTRICT_BY_SPLTY_YN=?, OVER_BOOKING_ALLOWED_YN=?, OVER_BOOK_COUNT=?, OPER_ROOM_SEQ=?, SERVICE_CODE=?,CHARGEABLE_YN=?,DFLT_RECOVERY_ROOM_CODE=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where OPER_ROOM_CODE=?";//Modified by lakshmi againt MO-CRF-20058

				pstmt=con.prepareStatement(sqlModify);
				pstmt.setString(1,facilityid);
				pstmt.setString(2,long_desc);
				pstmt.setString(3,short_desc);
				pstmt.setString(4,theatre_type);
				pstmt.setString(5,wd_start_date_time);
				pstmt.setString(6,wd_end_date_time);
				pstmt.setString(7,hd_start_date_time);
				pstmt.setString(8,hd_end_date_time);
				pstmt.setString(9,restrict_by_splty_yn);
				pstmt.setString(10,over_booking_allowed_yn);
				pstmt.setString(11,no_of_overbookings_allowed);//Added by lakshmi against MO-CRF-20058
				pstmt.setString(12,oper_room_seq);
				pstmt.setString(13,service_code);
				pstmt.setString(14,chargable_room);
				pstmt.setString(15,rec_room_code);
				pstmt.setString(16,login_user);
				pstmt.setString(17,client_ip_address);
				pstmt.setString(18,facility_id);
				pstmt.setString(19,oper_room_code);
//System.out.println("hi::beforemodify");//lakshmi
				flag = pstmt.executeUpdate();	
				//System.out.println("hi::aftermodify");//lakshmi
				//CRF-004 Authorize Slots for Booking - Rajesh V 
				//int result = 0; //Common-ICN-0055
				if(!("".equals(userInfo)))
					flag = operSlotsInsertUpdate(req,res,oper_room_code);
				//CRF-004 Authorize Slots for Booking - Rajesh V 
				}
			   MessageManager mm=new MessageManager();
			   if(flag>0){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
				}else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					msg = ((String) mesg.get("message"));
				}
				
			
			//out.println(msg);
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( msg,"UTF-8" ));
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg in Operation Room Servlet"+e.getMessage());
		//out.println(""+e);
	}finally{
		try{								
			if(pstmt!=null) pstmt.close();             
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){e.printStackTrace();}
	  }
    }

	//CRF-004 Authorize Slots for Booking - Rajesh V 
	private int operSlotsInsertUpdate(HttpServletRequest request,
			HttpServletResponse response,String oper_room_code) {
		
		Connection con = null;		
		PreparedStatement pstmt=null;   
		int retRslt = 0;
		try{
		String userInfo = request.getParameter("childWinParams");
		String initArr[] = userInfo.split("!!!");
		String modeArr[] = initArr[1].split("::");
		String contentArr[] = initArr[0].split("###");
		int[] result = new int[modeArr.length];
		int rslt = 0;
		String sqlUsers = "";
		HttpSession session=request.getSession(false);
		java.util.Properties prop = null;
		String facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = prop.getProperty( "client_ip_address" );
		String login_user = prop.getProperty( "login_user" );
		con = ConnectionManager.getConnection(request);
		if(modeArr.length == contentArr.length){
			for(int i=0;i<modeArr.length;i++){
				try{
					if("I".equals(modeArr[i])){
						String userArr[] = contentArr[i].split(":::");
						sqlUsers = "INSERT INTO OT_OPER_ROOM_USER(OPERATING_FACILITY_ID,OPER_ROOM_CODE,APPL_USER_ID,APPL_USER_NAME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";						
						pstmt = null;
						pstmt = con.prepareStatement(sqlUsers);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_room_code);
						pstmt.setString(3, userArr[0]);
						pstmt.setString(4, userArr[1]);
						pstmt.setString(5, login_user);
						pstmt.setString(6, client_ip_address);
						pstmt.setString(7, facility_id);
						pstmt.setString(8, login_user);
						pstmt.setString(9, client_ip_address);
						pstmt.setString(10, facility_id);
						pstmt.execute();
						rslt = 1;
					}
					else if("D".equals(modeArr[i])){
						String userArr[] = contentArr[i].split(":::");
						sqlUsers = "DELETE FROM OT_OPER_ROOM_USER WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ? AND APPL_USER_ID = ?";						
						pstmt = null;
						pstmt = con.prepareStatement(sqlUsers);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_room_code);
						pstmt.setString(3, userArr[0]);
						pstmt.execute();
						rslt = 1;
					}
					else if("U".equals(modeArr[i])){
						rslt = 1;
					}
					if(pstmt!=null) pstmt.close(); //Common-ICN-0053
				}
				catch(Exception e){
					e.printStackTrace();
					//System.err.println("Exception in OperatingRoomServlet -- "+e);
					rslt = 0;
				}
				
				result[i] = rslt;
			}
		}
		con.commit();	
		retRslt = result[0];
		for(int i=1;i<result.length;i++){
			if(result[i]<retRslt){
				retRslt = result[i];
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				e.printStackTrace();
				//System.err.println("Exception in operation users:"+e);
			}	
		}
		return retRslt;
	}
	
	//CRF-004 Authorize Slots for Booking - Rajesh V 
 }




