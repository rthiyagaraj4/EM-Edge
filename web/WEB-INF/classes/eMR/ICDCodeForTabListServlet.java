/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

//import java.io.PrintWriter;
//import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.Properties;
//import webbeans.eCommon.RecordSet;
import eMR.ICDCodeForTabList.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.io.*;
import java.sql.*;
import java.net.*;



public class ICDCodeForTabListServlet extends javax.servlet.http.HttpServlet
{
	 

	boolean	insert = true;
    Connection con  ;
    //Statement stmt = null;
	PreparedStatement stmt			= null;
	PreparedStatement prepStmt = null;
    PrintWriter out;
    Properties p;
    String facilityId ;
    String client_ip_address ;
    String tabulation_list="";
	String locale	="";
				

	//String sStyle="";

    HttpSession session;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        session = req.getSession(false);
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		//sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
            this.out = res.getWriter();

            modifyICDCodeForTabList(req, res);
        }
        catch(Exception e)
        {
            out.println(e.toString());
        }
    }

    /*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        try
        {
            this.out = res.getWriter();
            res.setContentType("text/html");

            String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
            String params = req.getQueryString() ;
            String source = url + params ;

            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception e)  {  out.println(e.toString());	 }
    }*/

    private void modifyICDCodeForTabList(HttpServletRequest req, HttpServletResponse res)
    {
			int delete_val = 0;
			int insert_val = 0;
			String checkedOnes = "";
			String diag_srl_no = "";
			String diag_srl = "";
			String orderBy = "";
			String searchby = "";
			String searchcrt = "";
			String alphadescription = "";
			String age_spec = "";
			String selectedAlpha = "";
			String term_set_id = "";
			String mode = "";
        try
        {
			con = ConnectionManager.getConnection(req);
			
			String addedById			= p.getProperty( "login_user" ) ;
			//String addedDate			= dateFormat.format( new java.util.Date() ) ;
		//	String modifiedById			= addedById ;
			String modifiedFacilityId	= facilityId ;
			String addedAtWorkstation	= client_ip_address;
		//	String modifiedAtWorkstation= addedAtWorkstation ;

			//java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
		
			
//			Enumeration<String> parameterNames = req.getParameterNames();
//	        while (parameterNames.hasMoreElements()) {
//	            String paramName = (String) parameterNames.nextElement();
//	            String paramValue = req.getParameter(paramName);
//	            System.out.println("Name: " + paramName);
//	            System.out.println("Value: " + paramValue);
//
//	        }
			tabulation_list = checkForNull(req.getParameter("tabulation_list"));
			orderBy = checkForNull(req.getParameter("orderBy"));
			searchby = checkForNull(req.getParameter("searchby"));
			searchcrt = checkForNull(req.getParameter("searchcrt"));
			alphadescription = checkForNull(req.getParameter("alphadescription"));
			age_spec = checkForNull(req.getParameter("age_spec"));
			selectedAlpha = checkForNull(req.getParameter("selectedAlpha"));
			term_set_id = checkForNull(req.getParameter("term_set_id"));
			mode = checkForNull(req.getParameter("mode"));			       
		    
			String from = "";
			String to = "";
			
			if(req.getParameter("Criteria_from") != null ){
				from = checkForNull(req.getParameter("Criteria_from")) == "" ? "0":checkForNull(req.getParameter("Criteria_from"));
				to = checkForNull(req.getParameter("Criteria_to")) == "" ? "14":checkForNull(req.getParameter("Criteria_to"));				
			} else if(req.getParameter("from") != null){
				from = checkForNull(req.getParameter("from")) == "" ? "0":checkForNull(req.getParameter("from"));
				to = checkForNull(req.getParameter("to")) == "" ? "14":checkForNull(req.getParameter("to"));					
			}
            
            int	n_from = 0 ;
            int	n_to = 0 ;
            
			// added by marwan, to have the content of the current page not the next or prev page
            if(("next").equals(req.getParameter("whichPage"))){
        		n_from = Integer.parseInt(from.trim()) > 0 ? Integer.parseInt(from.trim())-14 : Integer.parseInt(from.trim()) ;
        		n_to = Integer.parseInt(to.trim())>14 ? Integer.parseInt(to.trim())-14 : Integer.parseInt(to.trim());            	
            } else if(("prev").equals(req.getParameter("whichPage"))){
        		n_from = Integer.parseInt(from.trim())+14 ;
        		n_to =  Integer.parseInt(to.trim())+14 ;            	
            } else {
            	n_from = Integer.parseInt(from.trim()) ;
        		n_to =  Integer.parseInt(to.trim()) ;   
            }
            
//            System.out.println("From: " + n_from + "<-----> To: " + n_to);
            
			for(int k=n_from+1; k<=n_to; k++)
			{
				checkedOnes = checkForNull(req.getParameter(("icdCodeNum"+k)),"N");
				diag_srl_no = checkForNull(req.getParameter("tab_list_no"+k));
             
				if(k != n_to)
					diag_srl = diag_srl+"'"+diag_srl_no+"',";
				else
					diag_srl = diag_srl+"'"+diag_srl_no+"'";
			}

			try
			{
				//stmt = con.createStatement();
				
				String 	sql = "delete MR_TERM_CODE_FOR_TAB_LIST where term_set_id =? AND TERM_CODE  IN ( "+diag_srl+" ) AND TAB_LIST_NO=?";
				
				stmt  = con.prepareStatement(sql);
				
				stmt.setString(1, term_set_id);
				stmt.setString(2, tabulation_list);
				
				delete_val = stmt.executeUpdate();	
				if(stmt != null)stmt.close();
			}
			catch (Exception es)
			{
				insert = false;
				es.printStackTrace();
				con.rollback();
			}

			for(int k=n_from+1; k<=n_to; k++)
			{
				checkedOnes = checkForNull(req.getParameter(("icdCodeNum"+k)),"N");
//				System.out.println(req.getParameter(("icdCodeNum"+k)));
               	if(checkedOnes.equals("Y"))
				{
					diag_srl_no = checkForNull(req.getParameter("tab_list_no"+k));
                	
					try
					{
					
						String InsertQry = " INSERT INTO MR_TERM_CODE_FOR_TAB_LIST  (TAB_LIST_NO, TERM_SET_ID, TERM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?, sysdate,?,?,?, sysdate ,?,?) ";
		
						prepStmt = con.prepareStatement(InsertQry);
						
						prepStmt.setString(1, tabulation_list);
						prepStmt.setString(2, term_set_id);
						prepStmt.setString(3, diag_srl_no);
						prepStmt.setString(4, addedById);
						prepStmt.setString(5, addedAtWorkstation);
						prepStmt.setString(6, modifiedFacilityId);
						prepStmt.setString(7, addedById);
						prepStmt.setString(8, addedAtWorkstation);
						prepStmt.setString(9, modifiedFacilityId);
						
						insert_val = prepStmt.executeUpdate();
						
						if(prepStmt != null) prepStmt.close();
			
					}
					catch (Exception es)
					{
						insert = false;
						es.printStackTrace();
						con.rollback();
					}
				}
			}
			if(insert)
				{
					if(mode.equals("apply"))
					{
								MessageManager mm = new MessageManager();
								final java.util.Hashtable mesg = mm.getMessage(locale,"RECORD_INSERTED", "SM");
								String msg1 = (String) mesg.get("message");
								out.println("<script>parent.frames[1].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';</script>");
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg1, "UTF-8" ) + "&err_value=1" );
								mesg.clear();
					}
					else
						out.println("<script>parent.parent.frames[1].reloadresultPage('O')</script>");
					

					con.commit();
					out.println("<script>parent.parent.frames[1].reloadresultPage('C')</script>");
				}
			else
				{
					
				}

//			if ( tabdata != null) tabdata.clear();
//			if ( results != null) results.clear();
	}
		catch(Exception e)
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
        }
		finally
		{
			 if (con != null)
			 {
				 ConnectionManager.returnConnection(con,req);
			 }
		}	
    }
		public static String checkForNull(String inputString)
		{
			return((inputString == null) ? "" : inputString);
		}

		public static String checkForNull(String inputString, String defaultValue)
		{
			return((inputString == null) ? defaultValue : inputString);
		}


}
