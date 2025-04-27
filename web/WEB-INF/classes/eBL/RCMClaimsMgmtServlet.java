package eBL;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import java.util.*;
import javax.servlet.ServletException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.BlRepository;
import eCommon.XSSRequestWrapper; //V220324


public class RCMClaimsMgmtServlet extends HttpServlet {
	
	Connection con = null;
	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 	
	
	boolean insertable = false;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RCMClaimsMgmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private String checkForNull(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.err.println("Inside doPost method");
		request = new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		try
		{
			System.err.println("Inside doPost method1");
						
			String claim_status = (String)request.getParameter("claim_status");					
			String btn_clicked = (String)request.getParameter("btn_clicked");					
			System.err.println("Inside doPost claim_status :::"+claim_status);
			if("E".equals(claim_status)){
				processInError(request,response,claim_status);
			}
			if("D".equals(claim_status)){
				if("regeneratePDF".equals(btn_clicked)){
					processRegenerate(request,response,claim_status);
				}
				if("review".equals(btn_clicked)){
					processReview(request,response,claim_status);
				}
			}
			if("R".equals(claim_status)){
				if("regeneratePDF".equals(btn_clicked)){
					processRegenerate(request,response,claim_status);
				}	
				if("generateClaim".equals(btn_clicked)){
					processGenerateClaim(request,response,claim_status);
				}
				if("revertStatus".equals(btn_clicked)){
					processRevertStatus(request,response,claim_status);
				}
			}
			if("G".equals(claim_status)){
				if("revertStatus".equals(btn_clicked)){
					processRevertStatus(request,response,claim_status);
				}
			}			
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
		}finally{
			
		}
	}
	
	private void processInError(HttpServletRequest request, HttpServletResponse response, String claim_status) throws ServletException, IOException {
		
		System.err.println("Inside processInError method");
		con = ConnectionManager.getConnection(request);

		try
		{
			System.err.println("Inside processInError method1");
			session = request.getSession(false);
			String error_value = "0";
			String str_error_text = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			String total_records = (String)request.getParameter("total_records");
			int tot_rec = Integer.parseInt(total_records);
			System.err.println("tot_rec: "+tot_rec);
			
			for(int i=1;i<=tot_rec;i++){
				String rcm_id = request.getParameter("rcm_id_"+i);
				String isRecSelectedYN = request.getParameter("chkbox_"+i);
				if(isRecSelectedYN == null) isRecSelectedYN = "N";
				System.err.println("rcm_id: "+rcm_id);
				System.err.println("isRecSelectedYN: "+isRecSelectedYN);
				
				if("Y".equals(isRecSelectedYN)){
					String procSql = "{ call bl_rcm.bl_rcm_generate_doc(?) }";
				
					cstmt = con.prepareCall(procSql);	
				
					cstmt.setString(1, rcm_id);
					cstmt.execute();
				}
				
				insertable = true;
			}
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				str_error_text = "Document Generated <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				str_error_text = "Record has not been saved. Please try again";			
			}			
			
			response.sendRedirect("../eBL/jsp/RCMClaimsHandleResponse.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+"&claim_status="+claim_status);

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in RCMClaimsMgmtServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in RCMClaimsMgmtServlet.java" + e.toString());				
			}	
		}
	}

	private void processRegenerate(HttpServletRequest request, HttpServletResponse response,String claim_status) throws ServletException, IOException {
		
		System.err.println("Inside processRegenerate method");
		con = ConnectionManager.getConnection(request);

		try
		{
			System.err.println("Inside processRegenerate method1");
			session = request.getSession(false);
			String error_value = "0";
			String str_error_text = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			System.err.println("rcm_id: "+request.getParameter("rcm_id1"));
			
			String total_records = request.getParameter("total_records");
			System.err.println("total_records==>"+total_records);
			int tot_rec = Integer.parseInt(total_records);
			System.err.println("tot_rec: "+tot_rec);
			
			for(int i=1;i<=tot_rec;i++){
				String rcmid = request.getParameter("rcm_id"+i);
				String checkpayer = request.getParameter("chkbox_"+i);
				if(checkpayer == null) checkpayer = "N";
				System.err.println("rcm_id: "+rcmid);
				System.err.println("checkpayer: "+checkpayer);
				
				if("Y".equals(checkpayer)){
					System.err.println("232===============>");
					String procSql = "{ call bl_rcm.bl_rcm_regenerate_doc(?) }";
				
					cstmt = con.prepareCall(procSql);	
				
					cstmt.setString(1, rcmid);
					cstmt.execute();
				}
				
				insertable = true;
			}
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				str_error_text = "Document Generated <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				str_error_text = "Record has not been saved. Please try again";			
			}			
			
			response.sendRedirect("../eBL/jsp/RCMClaimsHandleResponse.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+"&claim_status="+claim_status);

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in RCMClaimsMgmtServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in RCMClaimsMgmtServlet.java" + e.toString());				
			}	
		}
	}

	private void processReview(HttpServletRequest request, HttpServletResponse response,String claim_status) throws ServletException, IOException {
		
		System.err.println("Inside processReview method");
		con = ConnectionManager.getConnection(request);

		try
		{
			System.err.println("Inside processReview method1");
			session = request.getSession(false);
			String error_value = "0";
			String str_error_text = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			System.err.println("rcm_id: "+request.getParameter("rcm_id1"));
			
			String total_records = request.getParameter("total_records");
			System.err.println("total_records==>"+total_records);
			int tot_rec = Integer.parseInt(total_records);
			System.err.println("tot_rec: "+tot_rec);
			
			for(int i=1;i<=tot_rec;i++){
				String rcmid = request.getParameter("rcm_id"+i);
				String checkpayer = request.getParameter("chkbox_"+i);
				if(checkpayer == null) checkpayer = "N";
				System.err.println("rcm_id: "+rcmid);
				System.err.println("checkpayer: "+checkpayer);
				
				if("Y".equals(checkpayer)){
					System.err.println("339===============>");
					String procSql = "{ call bl_rcm.bl_update_status(?,?) }";
				
					cstmt = con.prepareCall(procSql);	
				
					cstmt.setString(1, rcmid);
					cstmt.setString(2, "R");
					cstmt.execute();
				}
				
				insertable = true;
			}
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				str_error_text = "Document Generated <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				str_error_text = "Record has not been saved. Please try again";			
			}			
			
			response.sendRedirect("../eBL/jsp/RCMClaimsHandleResponse.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+"&claim_status="+claim_status);

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in RCMClaimsMgmtServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in RCMClaimsMgmtServlet.java" + e.toString());				
			}	
		}
	}

	private void processGenerateClaim(HttpServletRequest request, HttpServletResponse response,String claim_status) throws ServletException, IOException {
		
		System.err.println("Inside processGenerateClaim method");
		con = ConnectionManager.getConnection(request);

		try
		{
			System.err.println("Inside processGenerateClaim method1");
			session = request.getSession(false);
			String error_value = "0";
			String str_error_text = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			System.err.println("rcm_id: "+request.getParameter("rcm_id1"));
			
			String total_records = request.getParameter("total_records");
			System.err.println("total_records==>"+total_records);
			int tot_rec = Integer.parseInt(total_records);
			System.err.println("tot_rec: "+tot_rec);
			int claim_num = 0;
			String claimGen="{ ? = call BL_RCM.BL_GET_CLAIM_NO()}";
			CallableStatement callClaim= con.prepareCall(claimGen);
			callClaim.registerOutParameter(1, java.sql.Types.INTEGER);
			callClaim.execute();
			claim_num=callClaim.getInt(1);//get from function
			System.err.println("hi in claim_num ==>"+claim_num);
			
			for(int i=1;i<=tot_rec;i++){
				String rcmid = request.getParameter("rcm_id"+i);
				String checkpayer = request.getParameter("chkbox_"+i);
				if(checkpayer == null) checkpayer = "N";
				System.err.println("rcm_id: "+rcmid);
				System.err.println("checkpayer: "+checkpayer);
				
				if("Y".equals(checkpayer)){
					System.err.println("339===============>");
					String procSql = "{ call bl_rcm.bl_update_claim_no(?,?,?) }";
				
					cstmt = con.prepareCall(procSql);	
				
					cstmt.setString(1, rcmid);
					cstmt.setString(2, "G");
					cstmt.setInt(3, claim_num);
					cstmt.execute();
				}
				
				insertable = true;
			}
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				str_error_text = "Document Generated <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				str_error_text = "Record has not been saved. Please try again";			
			}			
			
			response.sendRedirect("../eBL/jsp/RCMClaimsHandleResponse.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+"&claim_status="+claim_status);

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in RCMClaimsMgmtServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in RCMClaimsMgmtServlet.java" + e.toString());				
			}	
		}
	}

private void processRevertStatus(HttpServletRequest request, HttpServletResponse response,String claim_status) throws ServletException, IOException {
		
		System.err.println("Inside revertStatus method");
		con = ConnectionManager.getConnection(request);

		try
		{
			System.err.println("Inside processReview method1");
			session = request.getSession(false);
			String error_value = "0";
			String str_error_text = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			System.err.println("rcm_id: "+request.getParameter("rcm_id1"));
			
			String total_records = request.getParameter("total_records");
			System.err.println("total_records==>"+total_records);
			int tot_rec = Integer.parseInt(total_records);
			System.err.println("tot_rec: "+tot_rec);
			String status = "";
			if(claim_status.equals("R"))
				status = "D";
			else if(claim_status.equals("G"))
				status = "R";
			for(int i=1;i<=tot_rec;i++){
				String rcmid = request.getParameter("rcm_id"+i);
				String checkpayer = request.getParameter("chkbox_"+i);
				if(checkpayer == null) checkpayer = "N";
				System.err.println("rcm_id: "+rcmid);
				System.err.println("checkpayer: "+checkpayer);
				
				if("Y".equals(checkpayer)){
					System.err.println("339===============>");
					String procSql = "{ call bl_rcm.bl_update_status(?,?) }";
				
					cstmt = con.prepareCall(procSql);	
				
					cstmt.setString(1, rcmid);
					cstmt.setString(2, status);
					cstmt.execute();
				}
				
				insertable = true;
			}
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				str_error_text = "Document Generated <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				str_error_text = "Record has not been saved. Please try again";			
			}			
			
			response.sendRedirect("../eBL/jsp/RCMClaimsHandleResponse.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+"&claim_status="+claim_status);

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in RCMClaimsMgmtServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in RCMClaimsMgmtServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in RCMClaimsMgmtServlet.java" + e.toString());				
			}	
		}
	}

}