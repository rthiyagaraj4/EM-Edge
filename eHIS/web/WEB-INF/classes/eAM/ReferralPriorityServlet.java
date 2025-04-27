package eAM;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.SingleTabHandler.*;



public class ReferralPriorityServlet extends javax.servlet.http.HttpServlet
	{

	PrintWriter out ;
	Properties p;
	String strSql="";
	 
	Connection con	=null;
	String referralprioritycode="";
	String referralprioritydesc="";
	String addedById = "";
	String modifiedById = "";
	String addedFacilityId = "";
	String modifiedFacilityId = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	String errmsg=""; 
	String facilityId; 
	String s1="";
	PreparedStatement pstmt = null;
	String error_value="";
	String error="";
	String locale="";
    String client_ip_address;
    HttpSession session;

	 public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException 
	{

      try {  
		
	  req.setCharacterEncoding("UTF-8");
	  res.setContentType("text/html;charset=UTF-8");
	  session = req.getSession(false);
      this.p = (java.util.Properties) session.getValue("jdbc");
      client_ip_address = req.getRemoteAddr();
      client_ip_address = this.p.getProperty("client_ip_address");
		
        locale=p.getProperty("LOCALE");
	    facilityId= (String) session.getValue( "facility_id" ) ;	
	    addedById = p.getProperty( "login_user" );
		modifiedById = addedById;
		addedFacilityId = facilityId;
		modifiedFacilityId = addedFacilityId;
		addedAtWorkstation = client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation;
		
		con		= ConnectionManager.getConnection(req);
		con.setAutoCommit(false);
	 

         this.out = res.getWriter();		
         updateReferralPriority(req, res);

		}
      catch (Exception e) {
         out.println(e.toString());
		 e.printStackTrace();
      }

	  finally
	  {
		 ConnectionManager.returnConnection(con, req);
      }
   }
   
 private  void updateReferralPriority(HttpServletRequest req,HttpServletResponse res) {
       
	try { 	
			   	
			int refpriority_arr_size = Integer.parseInt(req.getParameter("refpriority_arr_size"));
			boolean result = false;
			int count = 0;
			int count_1 = 0;
			con=ConnectionManager.getConnection(req);
			
			for(int i = 0 ; i < refpriority_arr_size ; i++) 
			{
				referralprioritycode = req.getParameter("priority_Code"+i);
				referralprioritydesc = req.getParameter("priority_Desc"+i);
				
				//con=ConnectionManager.getConnection(req); //Commented for checkstyle
				pstmt = con.prepareStatement("UPDATE am_referral_priority SET priority_desc = ?, added_by_id = ?, added_date = SYSDATE, added_at_ws_no = ?, added_facility_id = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where priority_code = ?");
				
				
				pstmt.setString(1,referralprioritydesc);
				pstmt.setString(2,addedById);
				pstmt.setString(3,addedAtWorkstation);
				pstmt.setString(4,addedFacilityId);
				pstmt.setString(5,modifiedById);
				pstmt.setString(6,modifiedAtWorkstation);
				pstmt.setString(7,modifiedFacilityId);
				pstmt.setString(8,referralprioritycode);
				count = pstmt.executeUpdate();
			
				 	if(count>0){
						result = true;
					}else{
						result = false;
					}
					
					if(result){
						++count_1;
						con.commit();
					}else{
						con.rollback();
					}
				
				if(pstmt!=null) pstmt.close();
		    } 
				MessageManager mm=new MessageManager();
				
				if(count_1==3)
	  		    { 
				  java.util.Hashtable mesg=mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
				  error=(String)mesg.get("message");
				  error_value		= "1" ;
				  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );	
				  mesg.clear();
				  count_1=0;
				 }
				
				//if(pstmt!=null) pstmt.close(); //Commented for checkstyle
			
			}//try
			catch(Exception e)
			{
				error_value	= "0" ;
				error		= "APP-SM0000 Transaction Failes ....<br>" + e;
				try
				{
					out.println("Error : " +e);
					
					con.rollback();
				}catch(Exception ee)
				{
					ee.printStackTrace();

				}
			} 
			finally
			{
			try
				{				
					ConnectionManager.returnConnection(con, req);
				}
				catch(Exception e){ 
					out.println("in finally"+e.toString());
					e.printStackTrace();
					}
			}

		}
	}