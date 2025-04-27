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
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class SetupOperationTimeRangesServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session=req.getSession(false);
		PrintWriter out;
		out=res.getWriter();					
		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address=prop.getProperty( "client_ip_address" );
		String facility_id = (String)session.getValue( "facility_id" ) ;
		String login_user=prop.getProperty( "login_user" );
		String locale=prop.getProperty( "LOCALE" );
		String sql="";
		String curr_date=req.getParameter("curr_date");			
		String mode=req.getParameter("mode");	
		String time_range_code=req.getParameter("time_range_code");
		if(time_range_code==null || time_range_code.equals("null"))
			time_range_code=req.getParameter("time_range_code1");
		//String disable_flag=CommonBean.checkForNull(req.getParameter("disable_falg")); //Common-ICN-0055
		String one=curr_date+" "+req.getParameter("slot_1");
		String two=curr_date+" "+req.getParameter("slot_2");
		String three=curr_date+" "+req.getParameter("slot_3");
		String four=curr_date+" "+req.getParameter("slot_4");
		String five=curr_date+" "+req.getParameter("slot_5");
		String six=curr_date+" "+req.getParameter("slot_6");
		String seven=curr_date+" "+req.getParameter("slot_7");
		String eight=curr_date+" "+req.getParameter("slot_8");
		String nine=curr_date+" "+req.getParameter("slot_9");
		String ten=curr_date+" "+req.getParameter("slot_10");

		String status=req.getParameter("status");
		if(status==null || status.equals("null"))
			status="D";

		Connection con = null;
		PreparedStatement pstmt=null;	
		String msg="";     
		int flag=0;	
		try{
			con = ConnectionManager.getConnection(req);			
			if(mode.equals("insert")){
				sql="INSERT INTO OT_OPER_TIME_RANGE (TIME_RANGE_CODE,TIME_1_SLOT,TIME_2_SLOT,TIME_3_SLOT,TIME_4_SLOT,TIME_5_SLOT,TIME_6_SLOT,TIME_7_SLOT,TIME_8_SLOT,TIME_9_SLOT,TIME_10_SLOT,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ('"+time_range_code+"',TO_DATE('"+one+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+two+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+three+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+four+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+five+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+six+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+seven+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+eight+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+nine+"','DD/MM/YYYY HH24:MI'),TO_DATE('"+ten+"','DD/MM/YYYY HH24:MI'),'"+status+"','"+login_user+"',SYSDATE,'"+client_ip_address+"','"+facility_id+"','"+login_user+"',SYSDATE,'"+client_ip_address+"','"+facility_id+"')";
			}else{
				sql="UPDATE OT_OPER_TIME_RANGE SET TIME_1_SLOT=TO_DATE('"+one+"','DD/MM/YYYY HH24:MI'),TIME_2_SLOT=TO_DATE('"+two+"','DD/MM/YYYY HH24:MI'),TIME_3_SLOT=TO_DATE('"+three+"','DD/MM/YYYY HH24:MI'),TIME_4_SLOT=TO_DATE('"+four+"','DD/MM/YYYY HH24:MI'),TIME_5_SLOT=TO_DATE('"+five+"','DD/MM/YYYY HH24:MI'),TIME_6_SLOT=TO_DATE('"+six+"','DD/MM/YYYY HH24:MI'),TIME_7_SLOT=TO_DATE('"+seven+"','DD/MM/YYYY HH24:MI'),TIME_8_SLOT=TO_DATE('"+eight+"','DD/MM/YYYY HH24:MI'),TIME_9_SLOT=TO_DATE('"+nine+"','DD/MM/YYYY HH24:MI'),TIME_10_SLOT=TO_DATE('"+ten+"','DD/MM/YYYY HH24:MI'),STATUS='"+status+"',MODIFIED_BY_ID='"+login_user+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+client_ip_address+"',MODIFIED_FACILITY_ID='"+facility_id+"' where TIME_RANGE_CODE='"+time_range_code+"'";				 
			}
			pstmt=con.prepareStatement(sql);
			flag = pstmt.executeUpdate() ;
			//con.commit();
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
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(msg,"UTF-8"));
	}catch(Exception e){
			e.printStackTrace();
		    //System.err.println("Err Msg in Set Up Operation Time Ranges Servlet"+e.getMessage());
			//out.println(""+e);
	}finally{
		try{				
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){e.printStackTrace();}
	  }
    }
 }




