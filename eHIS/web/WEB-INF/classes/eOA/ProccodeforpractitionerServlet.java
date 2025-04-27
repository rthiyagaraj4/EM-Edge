/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import eOA.AppointmentDetails.*;
import java.net.URLEncoder;
import com.ehis.util.*;

public class ProccodeforpractitionerServlet extends javax.servlet.http.HttpServlet{
    PrintWriter out; 
    java.util.Properties p;
	Connection con ;
	PreparedStatement pstmt;
	ResultSet rs;
	String  facilityId					="";
	String  client_ip_address		="";
	String  addedById					="";
	String  locale							="";
	String final_linked_codes		="";
	String final_unlinked_codes	="";
	String code_to_be_link			="";
	String term_set_id					="";
	String link_by						="";
	HttpSession session;
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException{
		session					 = req.getSession(false);
        this.p					 = (java.util.Properties) session.getAttribute( "jdbc" ) ;
        this.facilityId			 = (String) session.getAttribute( "facility_id" ) ;
        client_ip_address	 = p.getProperty("client_ip_address");
		locale					 = p.getProperty("LOCALE");
		addedById			 = p.getProperty( "login_user" ) ;
		final_linked_codes	= req.getParameter("final_linked_codes");
		final_unlinked_codes	= req.getParameter("final_unlinked_codes");
		code_to_be_link		= req.getParameter("code_to_be_link");
		term_set_id				= req.getParameter("term_set_id");
		link_by						= req.getParameter("link_by");
		System.out.println("=Serv=final_linked_codes=@====>" +final_linked_codes);
		System.out.println("=Serv=final_unlinked_codes=@====>" +final_unlinked_codes);
		System.out.println("=Serv=code_to_be_link=@====>" +code_to_be_link);
		System.out.println("=Serv=link_by=@====>" +link_by);
        try{
				this.out = res.getWriter();
//				con = ConnectionManager.getConnection(req);
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");
				saveLink_Unlink_Codes(req,res);
		}catch(Exception ex){
			System.out.println("Exception==@==Proccodeforpractitioner_servlet=>"+ex);
			ex.printStackTrace();
		}
	}
	public void saveLink_Unlink_Codes(HttpServletRequest req, HttpServletResponse res){
			String error="";
			String error_value="0"; 
		try{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int upd_lin=0;
			int ins_lin=0;
			int upd_unl=0;
			String code="";
			String UPDATE_LINKED_CODES="UPDATE OA_PRACT_PROC_LINK SET EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE PRACTITIONER_ID=? AND PROC_CODING_SCHEME=? AND PROC_CODE=? ";
			String INSERT_LINKED_CODES="INSERT INTO OA_PRACT_PROC_LINK(PRACTITIONER_ID,PROC_CODING_SCHEME,PROC_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?) ";
			if(!final_linked_codes.equals("")){
					StringTokenizer st_linked_codes=new StringTokenizer(final_linked_codes,"$");
					while(st_linked_codes.hasMoreTokens()){
								code=st_linked_codes.nextToken();
								pstmt=con.prepareStatement(UPDATE_LINKED_CODES);
								pstmt.setString(1,"Y");
								pstmt.setString(2,addedById);
								pstmt.setString(3,client_ip_address);
								pstmt.setString(4,facilityId);
								if(link_by.equals("PROC_CODE")){
									pstmt.setString(5,code);
									pstmt.setString(6,term_set_id);
									pstmt.setString(7,code_to_be_link);
								}else{
									pstmt.setString(5,code_to_be_link);
									pstmt.setString(6,term_set_id);
									pstmt.setString(7,code);
								}
								upd_lin=pstmt.executeUpdate();
								if(upd_lin==0){
									pstmt=con.prepareStatement(INSERT_LINKED_CODES);
								if(link_by.equals("PROC_CODE")){
										pstmt.setString(1,code);
										pstmt.setString(2,term_set_id);
										pstmt.setString(3,code_to_be_link);
								}else{
										pstmt.setString(1,code_to_be_link);
										pstmt.setString(2,term_set_id);
										pstmt.setString(3,code);
								}
									pstmt.setString(4,addedById);
									pstmt.setString(5,client_ip_address);
									pstmt.setString(6,facilityId);
									pstmt.setString(7,addedById);
									pstmt.setString(8,client_ip_address);
									pstmt.setString(9,facilityId);
									pstmt.setString(10,"Y");
									ins_lin=pstmt.executeUpdate();
								}
                               /* CheckStyle Correction added by Munisekhar */
								if(pstmt != null) pstmt.close();
					}
			}
			if(!final_unlinked_codes.equals("")){
				StringTokenizer st_unlinked_codes=new StringTokenizer(final_unlinked_codes,"$");
				String format_unlik_codes="";
				String unlik_codes_criteria="";
				while(st_unlinked_codes.hasMoreTokens()){
					format_unlik_codes=format_unlik_codes+"'"+st_unlinked_codes.nextToken()+"'"+",";
				}
				format_unlik_codes=format_unlik_codes.substring(0,format_unlik_codes.length()-1);
				System.out.println("=@=Servlet=format_unlik_codes=@=>"+format_unlik_codes);
				if(link_by.equals("PROC_CODE")){
						unlik_codes_criteria="PRACTITIONER_ID IN("+format_unlik_codes+") AND  PROC_CODING_SCHEME=? AND PROC_CODE=?";
				}else{
						unlik_codes_criteria="PROC_CODE IN("+format_unlik_codes+") AND  PROC_CODING_SCHEME=? AND PRACTITIONER_ID=?";
				}
				String UPDATE_UNLINKED_CODES="UPDATE OA_PRACT_PROC_LINK SET EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE "+unlik_codes_criteria+" ";
				System.out.println("=@=Servlet=UPDATE_UNLINKED_CODES=@=>"+UPDATE_UNLINKED_CODES);
				pstmt=con.prepareStatement(UPDATE_UNLINKED_CODES);
				pstmt.setString(1,"N");
				pstmt.setString(2,addedById);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facilityId);
				pstmt.setString(5,term_set_id);
				pstmt.setString(6,code_to_be_link);
				upd_unl=pstmt.executeUpdate();
			}
			/* CheckStyle Correction added by Munisekhar */
			if(pstmt != null) pstmt.close();
				System.out.println("=@=Servlet=upd_lin=@=>"+upd_lin);
				System.out.println("=@=Servlet=ins_lin=@=>"+ins_lin);
				System.out.println("=@=Servlet=upd_unl=@=>"+upd_unl);
			if(upd_lin>0||ins_lin>0||upd_unl>0){
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				System.out.println("=@=Servlet=error=@=>"+error);
//				out.print("<script>alert('"+error+"')</script>");
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+URLEncoder.encode(error,"UTF-8")+ "&err_value="+error_value);
			}else{
				con.rollback();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+URLEncoder.encode(error,"UTF-8")+ "&err_value="+error_value);
			}
		}catch(Exception ex){
			try{
				con.rollback();
			}catch(Exception exe){
				exe.printStackTrace();
			}
			System.out.println("Exception=@=ProccodeforpractitionerServlet=Savemethod=>" +ex);
			ex.printStackTrace();
		}finally{
			if(con != null){
				ConnectionManager.returnConnection(con,p);
			}
		}
			
	} 
}

 
