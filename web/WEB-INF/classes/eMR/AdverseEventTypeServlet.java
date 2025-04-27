/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eMR;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;


public class AdverseEventTypeServlet extends HttpServlet implements SingleThreadModel
{
	
    PrintWriter out;
    Properties p;
	//HashMap tabdata;	
	String adverse_code;
	String short_desc;
	String long_desc;
	String fina_val;
	String facilityId;
	String addedById;
	//String addedBydate;
	String modifiedById;
	String addedAtWorkstation;
	String modifiedAtWorkstation;
	//String user_define;
	String client_ip_address;
	String eff_status;
	String mode;
	//String addedDate;
	Hashtable message=null;
	Connection conn = null;
	ResultSet rsas=null;
	Statement stmt=null;
	PreparedStatement pst_del_mr_adv_cause=null;
	PreparedStatement pst_mr_adv_reac=null;
	PreparedStatement pst_upd_mr_adv_cause=null;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		HttpSession session;
        session = req.getSession(false);
        p = (Properties)session.getValue("jdbc");
       facilityId = (String)session.getValue("facility_id");
       client_ip_address = p.getProperty("client_ip_address");
       modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
       modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	   
	   
       //tabdata = new HashMap();
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
           // res.setContentType("text/html");
            out = res.getWriter();
            mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res);
			 if(mode.trim().equalsIgnoreCase("modify"))
               modify(req, res);

				
        }
        catch(Exception e)
        {
            out.println(e.toString());
			e.printStackTrace(System.err);
        }
    }
	  public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        try
        {
            doPost(req, res);
        }
        catch(Exception e)
        {
			e.printStackTrace(System.err);
        }
    }

	private void insert(HttpServletRequest req, HttpServletResponse res)
    {
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		String locale = p.getProperty("LOCALE");
        try
        {
			conn = ConnectionManager.getConnection(req);
			stmt = conn.createStatement();
			adverse_code=req.getParameter("code");
			if(adverse_code ==null) adverse_code="";
			short_desc=req.getParameter("short_desc");
			if(short_desc ==null) short_desc="";
			long_desc=req.getParameter("long_desc");
			if(long_desc ==null) long_desc="";
			fina_val=req.getParameter("fina_val");
			if(fina_val ==null) fina_val="";
			//user_define="U";
			eff_status =req.getParameter("eff_status");
			if(eff_status ==null) eff_status="D";
			int insr_one=0;

			boolean flag=true;
			boolean flag2=true;
			//addedDate				= dateFormat.format( new java.util.Date() ) ;



			String old_code="";	
			String sql1="select ADV_EVENT_TYPE_CODE from MR_ADV_EVENT_TYPE where ADV_EVENT_TYPE_CODE = '"+adverse_code+"' ";

			rsas=stmt.executeQuery(sql1);
			if(rsas !=null)
			{
				while(rsas.next())
				{
					old_code=rsas.getString("ADV_EVENT_TYPE_CODE");
					if(old_code.equals(adverse_code))
					{
						flag=false;
					}
	    		}
			}

			if(flag)
			{
			
				String ins_mr_adv_reac="Insert into MR_ADV_EVENT_TYPE (ADV_EVENT_TYPE_CODE,SHORT_DESC,LONG_DESC,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values('"+adverse_code+"','"+short_desc+"','"+long_desc+"','"+eff_status+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+facilityId+"','"+modifiedById+"',sysdate,'"+facilityId+"','"+modifiedAtWorkstation+"')";

				pst_mr_adv_reac=conn.prepareStatement(ins_mr_adv_reac);
				insr_one=pst_mr_adv_reac.executeUpdate();
				if(insr_one >0)
				{
					int upda=0;
					StringTokenizer token_first= new StringTokenizer(fina_val,"@");
					while(token_first.hasMoreTokens())
					{
         			  String fin_vals_split = token_first.nextToken();

						StringTokenizer token_next= new StringTokenizer(fin_vals_split,"$");
						while(token_next.hasMoreTokens())
						{
								String adv_event_ind=token_next.nextToken();
								String eff_status1=token_next.nextToken();

							String sql_update="Insert into MR_ADV_EVENT_TYPE_DETAIL (ADV_EVENT_TYPE_CODE,ADV_EVENT_TYPE_IND,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values( '"+adverse_code+"','"+adv_event_ind+"',	'"+eff_status1+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+facilityId+"','"+modifiedById+"',sysdate,'"+facilityId+"','"+modifiedAtWorkstation+"')";
							pst_upd_mr_adv_cause=conn.prepareStatement(sql_update);
							upda=pst_upd_mr_adv_cause.executeUpdate();

							if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();

							if(upda >0)
							{
								flag2=true;
							}else
							{
								flag2=false;
							}
						}//while
					}//while
					
				}else
				{
					flag2=false;
				}
				
			}else
			{
				flag2=false;
			}
			String error_value="";
			boolean flag3=false;
			//	String s2 = "0";
			//	String s1 = "";
		if(flag2)
		{
			conn.commit();
			flag3=true;
		
		}else
		{
			conn.rollback();
			//s2 = "0";
			//s1 = "APP-SM0095 Record Already Exists...";
			message= MessageManager.getMessage( locale,"RECORD_EXISTS","SM" ) ;
			String error=(String) message.get("message");
			error_value = "0" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
				 }
		  if(flag3)
		  {
			 // 	s2 = "1";
			//		s1 = "APP-SM0002 Operation Completed Successfully ....";
			message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			String error=(String) message.get("message");
			error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
		  }

	
	 }
        catch(Exception e)
        {

            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }finally
		{
			try	
			{
				if(conn != null) ConnectionManager.returnConnection(conn,req);
				if(stmt !=null) stmt.close();
				if(rsas !=null) rsas.close();
				if(pst_mr_adv_reac !=null)pst_mr_adv_reac.close();
				if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();
				if(pst_mr_adv_reac !=null)pst_mr_adv_reac.close();
				if(pst_del_mr_adv_cause !=null)pst_del_mr_adv_cause.close();
				if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();

			}catch(Exception e)
			{
			}

		}
    }

	private void modify(HttpServletRequest req, HttpServletResponse res)
    {
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		String locale = p.getProperty("LOCALE");
        try
        {
			conn = ConnectionManager.getConnection(req);
			adverse_code=req.getParameter("code");
			if(adverse_code ==null) adverse_code="";
			short_desc=req.getParameter("short_desc");
			if(short_desc ==null) short_desc="";
			long_desc=req.getParameter("long_desc");
			if(long_desc ==null) long_desc="";
			//user_define="U";
			eff_status =req.getParameter("eff_status");
			if(eff_status ==null) eff_status="D";
			fina_val=req.getParameter("fina_val");
			if(fina_val ==null) fina_val="";
			int insr_one=0;
			boolean flag2=true;
			//addedDate				= dateFormat.format( new java.util.Date() ) ;
			
			String ins_mr_adv_reac="Update MR_ADV_EVENT_TYPE set SHORT_DESC='"+short_desc+"',LONG_DESC='"+long_desc+"',EFF_STATUS='"+eff_status+"',ADDED_BY_ID='"+addedById+"',ADDED_DATE=sysdate,ADDED_AT_WS_NO='"+addedAtWorkstation+"',ADDED_FACILITY_ID='"+facilityId+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID='"+facilityId+"',MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' where ADV_EVENT_TYPE_CODE='"+adverse_code+"'";
			pst_mr_adv_reac=conn.prepareStatement(ins_mr_adv_reac);
			insr_one=pst_mr_adv_reac.executeUpdate();
				if(insr_one >0)
				{
						int del1=0;
						int upda=0;
				pst_del_mr_adv_cause=conn.prepareStatement("delete from MR_ADV_EVENT_TYPE_DETAIL where ADV_EVENT_TYPE_CODE='"+adverse_code+"'");
				del1 = pst_del_mr_adv_cause.executeUpdate();
					StringTokenizer token_first= new StringTokenizer(fina_val,"@");
					while(token_first.hasMoreTokens())
					{
         			 String fin_vals_split = token_first.nextToken();

						 StringTokenizer token_next= new StringTokenizer(fin_vals_split,"$");
						while(token_next.hasMoreTokens())
						{
								
								String adv_event_ind=token_next.nextToken();
								String eff_status1=token_next.nextToken();

							String sql_update="Insert into MR_ADV_EVENT_TYPE_DETAIL (ADV_EVENT_TYPE_CODE,ADV_EVENT_TYPE_IND,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values( '"+adverse_code+"','"+adv_event_ind+"',	'"+eff_status1+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+facilityId+"','"+modifiedById+"',sysdate,'"+facilityId+"','"+modifiedAtWorkstation+"')";
							pst_upd_mr_adv_cause=conn.prepareStatement(sql_update);
							upda=pst_upd_mr_adv_cause.executeUpdate();

							if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();

								if(upda >0)
								{
									flag2=true;
								}else
								{
									flag2=false;
								}
							}//while
						}//while
					}else
					{
						flag2=false;
					}
					String error_value="";
				boolean flag3=false;
			//	String s2 = "0";
			//	String s1 = "";
				if(flag2)
				{
					conn.commit();
					flag3=true;
				}else
				{
					conn.rollback();
					//s2 = "0";
					 //s1 = "APP-SM0095 Record Already Exists...";
					 message= MessageManager.getMessage( locale,"RECORD_EXISTS","SM" ) ;
					String error=(String) message.get("message");
					error_value = "1" ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
				}
			
				if(flag3)
				{
					//s2 = "1";
					//s1 = "APP-SM0002 Operation Completed Successfully ....";
					 message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					String error=(String) message.get("message");
					error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);

				}


        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }finally
		{
			try	
			{
				if(conn != null) ConnectionManager.returnConnection(conn,req);
				if(stmt !=null) stmt.close();
				if(rsas !=null) rsas.close();
				if(pst_mr_adv_reac !=null)pst_mr_adv_reac.close();
				if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();
				if(pst_mr_adv_reac !=null)pst_mr_adv_reac.close();
				if(pst_del_mr_adv_cause !=null)pst_del_mr_adv_cause.close();
				if(pst_upd_mr_adv_cause !=null)pst_upd_mr_adv_cause.close();

			}catch(Exception e)
			{
			}
		}
    }
}
