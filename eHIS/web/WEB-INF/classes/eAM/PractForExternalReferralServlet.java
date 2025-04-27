/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
public class PractForExternalReferralServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;

	String primary_specialty="";
	String totAssignreassign="", effStatus="",finalSelect="",finalString="";
	java.util.Properties p;
	String facility;
	String facilityId ;
	String client_ip_address ;
	//String serviceURL;
	//String objectName;
	HttpSession session;
	String locale="";

	 Connection con;
	 PreparedStatement pslPrepStmt;
	 PreparedStatement delStmt;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
		try
		{
			 con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if ( operation.equals("insert") )   insertOPPF(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
		finally
		        {
		            ConnectionManager.returnConnection(con, req);
        		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}
*/

private void insertOPPF(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
				int inserted = 0;
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedFacilityId=facilityId;
				String modifiedFacilityId = addedFacilityId ;
				String addedAtWorkstation=client_ip_address;
			    String modifiedAtWorkstation = addedAtWorkstation ;
			    String referral = req.getParameter("referral_code");

			    facility=req.getParameter("facility_id");
			    if(facility == null) facility="";
			    primary_specialty=req.getParameter("primary_specialty");
			    if(primary_specialty == null) primary_specialty="";
			    totAssignreassign= req.getParameter("totAssignreassign");
			    if(totAssignreassign == null) totAssignreassign="";
			    effStatus = req.getParameter("effStatus");
			    if(effStatus == null) effStatus="D";
			    finalSelect = req.getParameter("finalSelect");
			    if(finalSelect == null) finalSelect="";
			    finalString = req.getParameter("finalString");
			    if(finalString == null) finalString="";

			    String sql=	" insert into am_ext_pract_for_referral (REFERRAL_CODE, PRACTITIONER_ID, EFF_DATE_FROM, EFF_DATE_TO, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
 
		    	String sql2=" update am_ext_pract_for_referral  set  eff_status=? where REFERRAL_CODE =? and  practitioner_id=?";

			    StringTokenizer mainTkn= new StringTokenizer(finalString,"`");
			    int maintkns= mainTkn.countTokens();
			    int resUpdate=0;
			    String practitioner_id="",eff_status="";
			    pslPrepStmt = con.prepareStatement(sql);
			    delStmt=con.prepareStatement(sql2);
			    for(int main=0;main<maintkns;main++)
			    {
				String sub1=mainTkn.nextToken();
				StringTokenizer subTkn= new StringTokenizer(sub1,"$");
				practitioner_id=subTkn.nextToken();
				eff_status = subTkn.nextToken();

				delStmt.setString(1,eff_status);
				delStmt.setString(2,referral);
				delStmt.setString(3,practitioner_id);	

				resUpdate=delStmt.executeUpdate();
				
				if(resUpdate == 0)
				{
				pslPrepStmt.setString(1,referral);
				
				pslPrepStmt.setString(2,practitioner_id);
				pslPrepStmt.setString(3,"");
				pslPrepStmt.setString(4,"");
				pslPrepStmt.setString(5,eff_status);
				pslPrepStmt.setString(6,addedById);
				pslPrepStmt.setString(7,addedAtWorkstation);
				pslPrepStmt.setString(8,addedFacilityId);
				pslPrepStmt.setString(9,modifiedById);
				pslPrepStmt.setString(10,modifiedAtWorkstation);
				pslPrepStmt.setString(11,modifiedFacilityId);
				inserted= pslPrepStmt.executeUpdate();
				}
			}

			String s20 = "";
			if(inserted >0 || resUpdate >0 )
			{
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				s20 = (String)hashtable1.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
                hashtable1.clear();
		 	}else
            {
              con.rollback();
			  Hashtable hashtable1 = MessageManager.getMessage(locale, "NO_CHANGE_TO_SAVE","common");
			  s20 = (String)hashtable1.get("message");
              res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
			  hashtable1.clear();
            }
	}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
		finally
		{
			try
			{
				if(pslPrepStmt!=null) pslPrepStmt.close();
				if(delStmt!=null) delStmt.close();
			}catch(Exception e){out.print("Exception in closing statements " + e);}
		}
	}
}
