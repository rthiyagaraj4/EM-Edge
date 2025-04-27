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


public class AdverseReactionServlet extends HttpServlet implements SingleThreadModel
{
	
    PrintWriter out;
    Properties p;
	String adv_reac_code;
	String short_desc;
	String long_desc;
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
	String fin_vals;
	Hashtable message=null;
	Connection conn = null;
	StringTokenizer token_next=null;
	String fin_vals_split ="";
	PreparedStatement pst_del_mr_adv_cause=null;
	PreparedStatement pst_upd_mr_adv_cause=null;
	String to=null;
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

	   to=req.getParameter("to");
			if(to ==null) to="";


	   
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
           // res.setContentType("text/html");
            out = res.getWriter();
            mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res);
		

				
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
		
		try
		{
			addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
			addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
			String locale = p.getProperty("LOCALE");
			conn = ConnectionManager.getConnection(req);
			String allergen_code_all="";
			adv_reac_code=req.getParameter("reac_code");
			if(adv_reac_code ==null) adv_reac_code="";
			String adv_event_type_ind=req.getParameter("adv_event_type_ind");
			if(adv_event_type_ind ==null) adv_event_type_ind="";
			String adv_event_type=req.getParameter("adv_event_type");
			if(adv_event_type ==null) adv_event_type="";
			eff_status =req.getParameter("eff_status");
			if(eff_status ==null || eff_status.equals("")) eff_status="D";
			fin_vals=req.getParameter("finalval");
			if(fin_vals ==null) fin_vals="";
			allergen_code_all=req.getParameter("allergen_code_all");
			if(allergen_code_all ==null) allergen_code_all="";
			String isOnApply   = (req.getParameter("isOnApply")==null)? "N" :req.getParameter("isOnApply");
			

			boolean flag2=true;
			int del1=0;
			int upda=0;

			pst_del_mr_adv_cause=conn.prepareStatement("delete from MR_ADV_REA_CAUSE_AGENT where ADV_REAC_CODE='"+adv_reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"' and ALLERGEN_CODE=?");

			String sql_update="Insert into MR_ADV_REA_CAUSE_AGENT (ADV_REAC_CODE,ALLERGEN_CODE,ADV_EVENT_TYPE_IND,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values( ?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			
			pst_upd_mr_adv_cause=conn.prepareStatement(sql_update);
			
			StringTokenizer token1=new StringTokenizer(allergen_code_all,"|");
			while(token1.hasMoreTokens()){
				String allergen_code_val=token1.nextToken();
				pst_del_mr_adv_cause.setString(1,allergen_code_val);
				del1 = pst_del_mr_adv_cause.executeUpdate();
				

			}

			StringTokenizer token=new StringTokenizer(fin_vals,"$");
				while(token.hasMoreTokens()){
				String ind_val=token.nextToken();

				StringTokenizer token2 = new StringTokenizer(ind_val,"|");
				while(token2.hasMoreTokens()){
					String allergen_code=token2.nextToken();
					String eff_status1=token2.nextToken();

					pst_upd_mr_adv_cause.setString(1,adv_reac_code);
					pst_upd_mr_adv_cause.setString(2,allergen_code);
					pst_upd_mr_adv_cause.setString(3,adv_event_type_ind);
					pst_upd_mr_adv_cause.setString(4,eff_status1);
					pst_upd_mr_adv_cause.setString(5,addedById);
					pst_upd_mr_adv_cause.setString(6,addedAtWorkstation);
					pst_upd_mr_adv_cause.setString(7,facilityId);
					pst_upd_mr_adv_cause.setString(8,modifiedById);
					pst_upd_mr_adv_cause.setString(9,facilityId);
					pst_upd_mr_adv_cause.setString(10,modifiedAtWorkstation);
					upda=pst_upd_mr_adv_cause.executeUpdate();
					if(upda >0)
					{
						flag2=true;
					}else{
						flag2=false;
					}
				}
			}
						
			
			

			String error_value=""; 					
			boolean flag3=false;
			
			if(flag2)
			{
				conn.commit();
				flag3=true;
			}else{
				conn.rollback();
				//s2 = "0";
				//s1 = "APP-SM0095 Record Already Exists...";
				message= MessageManager.getMessage( locale,"RECORD_EXISTS","SM" ) ;
				String error=(String) message.get("message");
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +  URLEncoder.encode(error,"UTF-8")+ "&err_value=" +error_value);
				
			}
			
			if(flag3)
			{
				//s2 = "1";
				//s1 = "APP-SM0002 Operation Completed Successfully ....";
				if(isOnApply.equals("Y"))
				{
					//out.println("<script>parent.parent.parent.frames(2).frames(1).frames(2).reloadResultPage();</script>");
					out.println("<script>parent.parent.frames[2].reloadResultPage("+to+");</script>");
				}
				else
				{
					message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					String error=(String) message.get("message");
					error_value = "1" ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
				}

				//out.println("<script>parent.Onsuccess();</script>");
			}
			

	}catch (Exception e)
	{
		e.printStackTrace(System.err);
		out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " +e.toString());
		e.printStackTrace(System.err);
	}finally{
		 
		 if (conn != null)
		 {
			 ConnectionManager.returnConnection(conn,req);
		 }
		try
		{
			
			if(pst_del_mr_adv_cause !=null) pst_del_mr_adv_cause.close();
			if(pst_upd_mr_adv_cause !=null) pst_upd_mr_adv_cause.close();
		}
		catch (Exception e)
		{
		}
	}	

 }//METHOD
}
