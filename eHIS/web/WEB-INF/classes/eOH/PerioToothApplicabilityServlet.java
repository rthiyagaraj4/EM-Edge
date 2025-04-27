/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerioToothApplicabilityServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}


public void doPost(HttpServletRequest request, HttpServletResponse response)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(false);
		out=response.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
		
		Connection          con = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		int flag=0;
		
		
		
		String msg="";
		String trace="0";
		try{
			con = ConnectionManager.getConnection(request);
				        
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
		    String component_code = checkForNull(request.getParameter( "component_code" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String required_yn = checkForNull(request.getParameter( "required_yn" )) ;
			String flag1 = checkForNull(request.getParameter( "flag" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String chk_recorded = checkForNull(request.getParameter( "chk_recorded" )) ;

			if(required_yn==null || required_yn=="")
			{
				required_yn="N";
			}
			
			
		    if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(flag1.equals("1")){   
				String component_code_hid = checkForNull(request.getParameter( "component_code_hid" )) ;
			    String tooth_no_hid = checkForNull(request.getParameter( "tooth_no_hid" )) ;
                pstmt=con.prepareStatement("UPDATE  OH_PERIODONTAL_CHART_DEF_DTL2 SET REQUIRED_YN = ? ,ADDED_BY_ID = ?, ADDED_DATE =SYSDATE ,ADDED_AT_WS_NO = ?,ADDED_FACILITY_ID =? ,MODIFIED_BY_ID= ?,MODIFIED_DATE = SYSDATE,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? WHERE CHART_CODE = ? AND COMPONENT_CODE= ? AND TOOTH_NO = ?");
                
				pstmt.setString(1,required_yn);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,login_user);
				pstmt.setString(6,client_ip_address);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,component_code_hid);
				pstmt.setString(10,tooth_no_hid);
			    flag = pstmt.executeUpdate();
			}
			else{
			pstmt=con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_DEF_DTL2 (CHART_CODE,COMPONENT_CODE,TOOTH_NO,REQUIRED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			
				pstmt.setString(1,chart_code);
				pstmt.setString(2,component_code);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,required_yn);
				pstmt.setString(5,login_user);
				pstmt.setString(6,client_ip_address);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,login_user);
				pstmt.setString(9,client_ip_address);
				pstmt.setString(10,facility_id);
			    flag = pstmt.executeUpdate();
			}

			MessageManager mm=new MessageManager();
			if(flag != 0){
				
				if (chk_recorded.equals("Y")){////added by parul on 07/01/2010 for 17712
					con.commit();
					//String  error_value = "1" ;	//Commented Against Common-ICN-0031
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044

				}else{
					final java.util.Hashtable mesg = mm.getMessage(locale,"NO_CHANGE_TO_SAVE", "COMMON") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044
				}

				
			}
			else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
				msg = ((String) mesg.get("message"));
				mesg.clear();	//Common-ICN-0044
			}

			String msg_val = java.net.URLEncoder.encode( msg,"UTF-8" );
			StringBuffer stringbuffer = new StringBuffer();
			stringbuffer.append("<html><head>");
			stringbuffer.append("<title></title>");
			stringbuffer.append("<script language='javascript' src='../eCommon/js/ValidateControl.js'></script>");
			stringbuffer.append("<script language='javascript' src='../eCommon/js/common.js'></script>");
			stringbuffer.append("<script language='javascript' src='../eOH/js/PerioToothApplicability.js'></script>");
			stringbuffer.append("<script language='javascript' src='../eOH/js/Hashtable.js'></script>");
			
			stringbuffer.append("</head>");
			stringbuffer.append("<body>");
			stringbuffer.append("<script>refreshDtlFrame('"+chart_code+"','"+tooth_numbering_system+"','"+oh_chart_level+"','"+flag1+"');");
			//stringbuffer.append("top.content.frames(1).frames(2).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" + msg_val+"'"); 
			stringbuffer.append("top.content.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" + msg_val+"'"); 
			stringbuffer.append("</script>");
			stringbuffer.append("</body></html>");
			out.println(stringbuffer.toString());

			//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	                                 
		}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in PerioToothApplicabilityServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("96: Caught Exception during rollback"+e_1);
				}
				
			    System.err.println("Err Msg in PerioToothApplicabilityServlet"+e.getMessage());
			    System.err.println("Err Msg in PerioToothApplicabilityServlet:trace="+trace);
				msg = e.toString();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		}finally{
			try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}
    }
}
