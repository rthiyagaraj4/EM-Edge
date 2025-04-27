/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM ;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.* ;
import javax.naming.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.SingleTabHandler.*;

public class DayoftheWeekServlet extends javax.servlet.http.HttpServlet
	{

	PrintWriter out 				;
	Properties p;
	String strSql="";
	 
	Connection con						=null;
	Statement stmt=null;
	
	CallableStatement cstmt = null; //Added HSA-CRF-0306.1 
	String errmsg=""; //Added HSA-CRF-0306.1
	String facilityId; //Added HSA-CRF-0306.1
	String error_value="";
	String error="";
	String[] day_no1n=new String[7];
	String[] day_of_weekn=new String[7];
	String[] default22n=new String[7];	
	String[] week1n=new String[7];			
	String[] week_appl2n=new String[7];			
	String[] week2n	=new String[7];
	String[] week3n=new String[7];
	String[] week4n=new String[7];			
	String[] week5n=new String[7];	
	String locale="";
    String client_ip_address;
	int g=0;
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

		con		= ConnectionManager.getConnection(req);
		con.setAutoCommit(false);
	

         this.out = res.getWriter();
         String operation = "modify";		

         if(operation.equals("modify"))
            modify(req, res);

		}
      catch (Exception e) {
         out.println(e.toString());
		 e.printStackTrace();
      }
   }
   
		
		
	private void modify(HttpServletRequest req, HttpServletResponse res) {
      try 
		  {
		  int value1=0;	
		res.setContentType("text/html;charset=UTF-8");
       req.setCharacterEncoding("UTF-8");
								
			for(int s=0;s<7;s++) {
				
				if(req.getParameter("day_nof"+s) != null ){
				day_no1n[g]=req.getParameter("day_nof"+s);
				
				if( !day_no1n[g].equals(""))
					{				
			if(req.getParameter("default11"+s) != null)
			{
					default22n[g]=req.getParameter("default11"+s);
				

			}

				
				if(req.getParameter("week_appl1"+s)!=null)
				{		
					week_appl2n[g]=req.getParameter("week_appl1"+s);
			
				}
				
				
				if(req.getParameter("week11"+s)!=null)
				{
					week1n[g]=req.getParameter("week11"+s);			
				
				}
				
				if(req.getParameter("week21"+s)!=null)
				{
					week2n[g]=req.getParameter("week21"+s);
				}
				if(req.getParameter("week31"+s)!=null)
				{
					week3n[g]=req.getParameter("week31"+s);				
				}
				if(req.getParameter("week41"+s)!=null)
				{
					week4n[g]=req.getParameter("week41"+s);
				

				}
				if(req.getParameter("week51"+s)!=null)
				{
					week5n[g]=req.getParameter("week51"+s);
				}
				
				g++;
				}				
				}
			}
		
		 String addedById = p.getProperty("login_user");
        
         String modifiedById = addedById;
		 stmt=con.createStatement();
		
         String addedAtWorkstation = client_ip_address;
         String modifiedAtWorkstation = addedAtWorkstation;
					for(int i=0;i<g;i++){				
					strSql = "update SM_DAY_OF_WEEK set WEEK_APPLICABILITY='"+week_appl2n[i]+"', DAY_TYPE='"+default22n[i]+"', DAY_TYPE_WEEK_1='"+week1n[i]+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=Sysdate, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"', DAY_TYPE_WEEK_2='"+week2n[i]+"', DAY_TYPE_WEEK_3='"+week3n[i]+"', DAY_TYPE_WEEK_4='"+week4n[i]+"', DAY_TYPE_WEEK_5='"+week5n[i]+"' where DAY_NO='"+day_no1n[i]+"'";
					value1=stmt.executeUpdate(strSql);			
				
				}	
			MessageManager mm=new MessageManager();
			
			//Added for this CRF HSA-CRF-0306.1
			if(value1!=0) con.commit();
			
			String isSitespecificparam=req.getParameter("isSitespecificparam");
			boolean sitespecificbool=Boolean.parseBoolean(isSitespecificparam);
			
			
			
			if(sitespecificbool){ 			  
				cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, "");
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "DAY_OF_WEEK");
				cstmt.setString(4, "");				  
                cstmt.setString(5, "");
                cstmt.setString(6, "");
                cstmt.setString(7, "");   				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
				
				
               			
			}
			//End HSA-CRF-0306.1
			
			
			if(value1!=0)
  		    {
				 java.util.Hashtable mesg=mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
				  error=(String)mesg.get("message");
				error_value		= "1" ;
				//error			= "APP-SM0002 Operation Completed Successfully ....";
				value1=0;
		     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );	
			con.commit();
			mesg.clear();
			}
			else 
			{
				java.util.Hashtable mesg=mm.getMessage(locale, "NO_CHANGE_TO_SAVE", "Common") ;
				 error=(String)mesg.get("message");
			error_value		= "0" ;

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			mesg.clear();
			}

			if(stmt!=null) 
			stmt.close();
			if(cstmt!=null) cstmt.close();//Added for checkstyle
		
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
				g=0;					
				ConnectionManager.returnConnection(con, req);
			}
			catch(Exception e){ 
				out.println("in finally"+e.toString());
				e.printStackTrace();
				}
		}

	}
}
