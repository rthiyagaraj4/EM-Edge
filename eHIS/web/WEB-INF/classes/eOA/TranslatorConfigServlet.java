/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;


public class TranslatorConfigServlet extends HttpServlet{
	PrintWriter out;	
	Properties p;
	String language_code;
	String srl_no;
	String date_range_from;
	String date_range_to;
	String no_of_translator;
	String factor;
	String eff_status ;
	String facilityId ;	
	String client_ip_address ;	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;
	String locale="";
	String sql="";	
	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale= p.getProperty("LOCALE");
		try{
				con=ConnectionManager.getConnection(req);
				res.setContentType("text/html");
				this.out = res.getWriter();
				String operation = req.getParameter("function_name");		
				if ( operation.equals("insert"))    insertTranslatorConfig(req, res);
				if ( operation.equals("modify"))   modifyTranslatorConfig(req, res);
			}catch(Exception e){
				out.println(e.toString());
				e.printStackTrace();
			}
	}
	private void insertTranslatorConfig(HttpServletRequest req, HttpServletResponse res)	{
		try
		{	
			language_code=req.getParameter("language_code");			
			date_range_from=req.getParameter("date_range_from");
			date_range_to=req.getParameter("date_range_to");
			no_of_translator=req.getParameter("no_of_translator");
			factor=req.getParameter("factor");
			eff_status = req.getParameter("eff_status");
			if ( eff_status == null )eff_status="D";
			String addedById = p.getProperty( "login_user" ) ;			
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;	
			String error_msg = "" ;	
			int count=0;
			int result=0; 
			
			sql="select count(*) from OA_TRANSLATOR_CONFIGURATION where language_id='"+language_code+"' and facility_id='"+facilityId+"' and (to_date ('"+date_range_from+"','dd/mm/yyyy') between EFF_DATE_FROM and EFF_DATE_TO or to_date ('"+date_range_to+"','dd/mm/yyyy') between EFF_DATE_FROM and EFF_DATE_TO or (to_date ('"+date_range_from+"','dd/mm/yyyy') <= EFF_DATE_FROM and to_date ('"+date_range_to+"','dd/mm/yyyy') >= EFF_DATE_TO))";			

			pstmt = con.prepareStatement( sql );
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()){
				count=rset.getInt(1);
			}

			if(count != 0){
					 Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					 error_msg = (String)message.get("message");					
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8"));
					 message.clear();			
			}else{			
				if(pstmt !=null) pstmt.close();				
				sql="insert into OA_TRANSLATOR_CONFIGURATION(FACILITY_ID,LANGUAGE_ID,SRL_NO,NO_OF_TRANSLATOR,MULTIPLY_FACTOR,EFF_DATE_FROM,EFF_DATE_TO,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values('"+facilityId+"','"+language_code+"',OA_TRANS_CONFIG_SEQ.NEXTVAL,'"+no_of_translator+"','"+factor+"',to_date('"+date_range_from+"','dd/mm/yyyy'),to_date('"+date_range_to+"','dd/mm/yyyy'),'"+eff_status+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"')";
				
				pstmt = con.prepareStatement( sql );
				result= pstmt.executeUpdate();							
					
				if ( result > 0 ){
					 con.commit();
					 Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 error_msg = (String)message.get("message");					 
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8") + "&err_value=1"  );
					 message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_msg,"UTF-8" ) );
				}
			}			
				if(pstmt !=null) pstmt.close();
				if(rset !=null) rset.close();
	}catch(Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());				
			e.printStackTrace();
	}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}

	private void modifyTranslatorConfig(HttpServletRequest req, HttpServletResponse res)	{
		try{
			language_code=req.getParameter("language_code");
			srl_no=req.getParameter("srl_no");
			date_range_from=req.getParameter("date_range_from");
			date_range_to=req.getParameter("date_range_to");
			no_of_translator=req.getParameter("no_of_translator");
			factor=req.getParameter("factor");
			eff_status = req.getParameter("eff_status");
			String change_flag = req.getParameter("change_flag");
			if ( eff_status == null )eff_status="D";				
			String modifiedById =  p.getProperty( "login_user" ) ;						
			String modifiedFacilityId = facilityId ;			
			String modifiedAtWorkstation = client_ip_address ;
			String error_msg = "" ;
			int count=0;
			int result=0;		

			if(change_flag.equals("true")){
				sql="select count(*) from OA_TRANSLATOR_CONFIGURATION where language_id='"+language_code+"' and facility_id='"+facilityId+"' and srl_no !='"+srl_no+"' and (to_date ('"+date_range_from+"','dd/mm/yyyy') between EFF_DATE_FROM and EFF_DATE_TO or to_date ('"+date_range_to+"','dd/mm/yyyy') between EFF_DATE_FROM and EFF_DATE_TO or (to_date ('"+date_range_from+"','dd/mm/yyyy') <= EFF_DATE_FROM and to_date ('"+date_range_to+"','dd/mm/yyyy') >= EFF_DATE_TO))";	

				pstmt = con.prepareStatement( sql );
				rset = pstmt.executeQuery();
				if(rset!=null && rset.next()){
					count=rset.getInt(1);
				}
			}
			if(count != 0){
					 Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					 error_msg = (String)message.get("message");					 
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8"));
					 message.clear();		
			}else{
				if(pstmt !=null) pstmt.close();				
				sql="update OA_TRANSLATOR_CONFIGURATION set FACILITY_ID='"+facilityId+"',NO_OF_TRANSLATOR='"+no_of_translator+"',MULTIPLY_FACTOR='"+factor+"',EFF_DATE_FROM=to_date('"+date_range_from+"','dd/mm/yyyy'),EFF_DATE_TO=to_date('"+date_range_to+"','dd/mm/yyyy'),EFF_STATUS='"+eff_status+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where language_id='"+language_code+"' and srl_no='"+srl_no+"' ";		
			
				pstmt = con.prepareStatement( sql );				
				result= pstmt.executeUpdate();							
						
				if ( result > 0 ){
					 con.commit();
					 Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 error_msg = (String)message.get("message");					 
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8") + "&err_value=1"  );
					 message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_msg,"UTF-8" ) );
				}
			}
			
			if(pstmt !=null) pstmt.close();
			if(rset !=null) rset.close();

		}catch(Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());			
			e.printStackTrace();
		}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}
}
