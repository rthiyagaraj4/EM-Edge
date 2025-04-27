/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eMR.ICDCodeForDagger.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.RecordSet;

public class ICDCodeForDaggerServlet extends javax.servlet.http.HttpServlet
{
    PrintWriter out;
    Properties p;
    String facilityId ;
    String client_ip_address ;
    String dagger_code="";
    String dagger_srl_no="";

    HttpSession session;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd") ;

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
        try
        {			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			modifyAsteriskCodesforDaggerCodes(req, res);
        }
        catch(Exception e)
        {
            //out.println(e.toString());
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        try
        {
            this.out = res.getWriter();            
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

            String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
            String params = req.getQueryString() ;
            String source = url + params ;

            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception e)  {
			e.printStackTrace() ;
		}
    }

    private void modifyAsteriskCodesforDaggerCodes(HttpServletRequest req, HttpServletResponse res)
    {
		Connection con = null;
        try
        {
            HashMap tabdata=new HashMap();
            RecordSet	accessRightRecSet	=	null;
            RecordSet	accessLeftRecSet	=	null;
            String checkedOnes = "";
            String checkedOnesCodes = "";
            String	from	=	"";	
			String to		=	"";
            from = (req.getParameter("from")==null)?"0"	: req.getParameter("from");
            to	 = (req.getParameter("to")==null) ?"0"	: req.getParameter("to");
			accessRightRecSet=(webbeans.eCommon.RecordSet)session.getAttribute("AXSRightRecSet");
			accessLeftRecSet=(webbeans.eCommon.RecordSet)session.getAttribute("AXSLeftRecSet");
			dagger_code = req.getParameter("dagger_code");
				if(dagger_code == null) dagger_code="";
			Statement stmt = null;
			ResultSet rset = null;
			try
			{
				con = ConnectionManager.getConnection(req);

				String srl_no_Sql =" select DIAG_SRL_NO from MR_ICD_CODE where DIAG_CODE = '"+dagger_code+"' ";
	
				stmt = con.createStatement();
				rset = stmt.executeQuery(srl_no_Sql);
				if(rset.next())
				{
					dagger_srl_no	= rset.getString("DIAG_SRL_NO");
				}
	
				if(rset != null) rset.close();	   
				if(stmt != null) stmt.close(); 

			}catch(Exception e)
			{
				//out.println("Error in query : "+e);
				e.printStackTrace();
			}finally
			{
				if(con != null) ConnectionManager.returnConnection(con,req);
			}

			if(from != null && to != null)
			{
				from	=	from.trim();
				to		=	to.trim();
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
				{
					if(req.getParameter("astk_diag_srl_no"+i) != null)
					{
						
						checkedOnes = req.getParameter(("astk_diag_srl_no"+i))==null?"":req.getParameter(("astk_diag_srl_no"+i));
						checkedOnesCodes = req.getParameter(("astk_diag_code"+i))==null?"":req.getParameter(("astk_diag_code"+i));
					
						//	/if((!accessRightRecSet.containsObject(checkedOnes)) && (!accessLeftRecSet.containsObject(checkedOnesCodes)))
						if(!accessRightRecSet.containsObject(checkedOnes))
						{	
							accessRightRecSet.putObject(checkedOnes);
							accessLeftRecSet.putObject(checkedOnesCodes);
						}

						if((!accessRightRecSet.containsObject(checkedOnes)) && (!accessLeftRecSet.containsObject(checkedOnesCodes)))
						{
//							accessLeftRecSet.putObject(checkedOnesCodes);
						}
					
					}
				}
			}

			for(int i=0;i<accessRightRecSet.getSize();i++)
			{
				tabdata.put(("astk_diag_srl_no"+i),(String)accessRightRecSet.getObject(i));
				tabdata.put(("astk_diag_code"+i),(String)accessLeftRecSet.getObject(i));
			}
	
			tabdata.put("dagger_code",dagger_code);
			tabdata.put("dagger_srl_no",dagger_srl_no);
			String slCount				= ""+accessRightRecSet.getSize();
			String addedById			= p.getProperty( "login_user" ) ;
			String addedDate			= dateFormat.format( new java.util.Date() ) ;
			String modifiedById			= addedById ;
			String modifiedFacilityId	= facilityId ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;
			java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ICDCodeForDagger",ICDCodeForDaggerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertICDCodeForDagger",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = "";
			String error_value = "0" ;
			if (inserted)
			{
				error_value = "1" ;
				error= (String) results.get("message") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if ( results != null) results.clear();
			if ( tabdata != null) tabdata.clear();
		}
		catch ( Exception e )
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : ");
			e.printStackTrace();
        }
    }
}
