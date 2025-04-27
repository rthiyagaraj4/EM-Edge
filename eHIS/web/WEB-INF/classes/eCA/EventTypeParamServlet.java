/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class EventTypeParamServlet extends javax.servlet.http.HttpServlet	
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		PrintWriter out =null;
	
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = res.getWriter();

			insertEventTypeParam(req, res);
		} 
		catch(Exception e) 
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{
			PrintWriter out =null;
			out = res.getWriter();
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
		    out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link> <script src='../eCommon/js/MstCodeCommon.js' language='javascript'></script><script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{	}
}


	private void insertEventTypeParam(HttpServletRequest req, HttpServletResponse res)	
	{
		PrintWriter out =null;
		
		java.util.Properties p;
		Connection con = null;
		PreparedStatement pslPrepStmt = null;

		String module_id = "CA";
		String facilityId = "" ;
		String client_ip_address = "";
		String locale = "";

		HttpSession session		= req.getSession(false);
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale					= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue( "facility_id" ) ;

		client_ip_address		= p.getProperty("client_ip_address");

		try 
		{
			out = res.getWriter();

			String event_type= "";
			String direct_regn="";

			String addedById				=	p.getProperty( "login_user" ) ;
			String modifiedById				=	addedById ;
			String modifiedFacilityId		=	facilityId ;
			String addedAtWorkstation		=	client_ip_address;
			String modifiedAtWorkstation	=	addedAtWorkstation ;
			String count					=	req.getParameter("count");

			HashMap tabdata=new HashMap();

			boolean bUpdStatus	= true;

			int totCount = Integer.parseInt(count);
			int k=0; 

			for(int ilCount = 0; ilCount< totCount; ilCount++)
			{
				event_type = req.getParameter("event_type"+ilCount);

				if(event_type != null)
				{
					tabdata.put("event_type"+k,event_type);
					module_id = req.getParameter("module_id"+ilCount);

					if(module_id != null)
						tabdata.put("module_id"+k,module_id);
					k++;
				}
			}
				
			con = ConnectionManager.getConnection(p);

			int j = 0;
			int t=0;

			try 
			{
				StringBuffer sblQry = new StringBuffer();

				sblQry.append("Update cr_event_type_param set build_cr_yn = 'N',BUILD_CR_FOR_DIRECT_REGN_YN ='N'   ");
				pslPrepStmt = con.prepareStatement(sblQry.toString());
				
				j = pslPrepStmt.executeUpdate();
				
				if(pslPrepStmt!=null) 
					pslPrepStmt.close();

				j=1;t=1;

				if(k != 0) 
				{
					j = 0;

					String s8	=	"";
					String s9	=	"";
						
					sblQry = new StringBuffer();

					for(int counter = 0; counter < k; counter++) 
					{
						s8 = (String)tabdata.get("event_type" + counter);
						s9 = (String)tabdata.get("module_id" + counter);

						if(sblQry.length() > 0)
							sblQry.delete(0,sblQry.length());

						sblQry.append("UPDATE cr_event_type_param SET build_cr_yn='Y'" );
						sblQry.append(" , modified_by_id =?");
						sblQry.append(" , modified_facility_id =?");
						sblQry.append(" , modified_at_ws_no =?");
						sblQry.append(" , modified_date = sysdate ");
						sblQry.append(" WHERE event_type = ?");
						sblQry.append(" AND module_id =?");
							
						if(pslPrepStmt!=null) pslPrepStmt.close();

						pslPrepStmt = con.prepareStatement(sblQry.toString());

						pslPrepStmt.setString(1, modifiedById);
						pslPrepStmt.setString(2, modifiedFacilityId);
						pslPrepStmt.setString(3, modifiedAtWorkstation);
						pslPrepStmt.setString(4, s8);
						pslPrepStmt.setString(5, s9);

						j = pslPrepStmt.executeUpdate();

						if(j < 0)
							 bUpdStatus = false;

						if(bUpdStatus == false)
							break;

						if(pslPrepStmt!=null) pslPrepStmt.close();
					}

					tabdata.clear();
				}

				if(bUpdStatus)
				{
					HashMap tabdata1=new HashMap();

					int totCount1 = Integer.parseInt(count);
					int l=0;
				
					for(int ilCount = 0; ilCount< totCount1; ilCount++)
					{
						direct_regn=req.getParameter("direct_regn"+ilCount);
			
						if(direct_regn != null)
						{
							tabdata1.put("direct_regn"+l,direct_regn);
							module_id = req.getParameter("module_id"+ilCount);

							if(module_id != null)
								tabdata1.put("module_id"+l,module_id);
			
							l++;
						}
					}

					if(l!= 0) 
					{
						t=0;

						String s9	=	"";
						String s10	=	"";

						sblQry = new StringBuffer();

						for(int counter = 0; counter < l; counter++) 
						{
							s9		=	(String)tabdata1.get("module_id" + counter);
							s10		=	(String)tabdata1.get("direct_regn" + counter);

							if(sblQry.length() > 0)
								sblQry.delete(0,sblQry.length());
					
							sblQry.append("UPDATE cr_event_type_param SET BUILD_CR_FOR_DIRECT_REGN_YN='Y'" );
							sblQry.append(" , modified_by_id =?");
							sblQry.append(" , modified_facility_id =?");
							sblQry.append(" , modified_at_ws_no =?");
							sblQry.append(" , modified_date = sysdate ");
							sblQry.append(" WHERE event_type = ?");
							sblQry.append(" AND module_id =?");
								
							if(pslPrepStmt!=null) pslPrepStmt.close();

							pslPrepStmt = con.prepareStatement(sblQry.toString());

							pslPrepStmt.setString(1, modifiedById);
							pslPrepStmt.setString(2, modifiedFacilityId);
							pslPrepStmt.setString(3, modifiedAtWorkstation);
							pslPrepStmt.setString(4, s10);
							pslPrepStmt.setString(5, s9);

							t = pslPrepStmt.executeUpdate();

							if (t < 0)
								bUpdStatus = false;
				
							if(bUpdStatus == false)
								break;

							if(pslPrepStmt!=null) pslPrepStmt.close();
						}

						tabdata1.clear();
					}
				}
				
				String error		= "";
				String error_value	= "0" ;
				Hashtable results = new Hashtable();

				if(bUpdStatus) 
				{
					results = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
					con.commit();
					error_value	=	"1";
				} 
				else 
				{
					con.rollback();
					results = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
				}

				error = (String) results.get("message") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );

			}
			catch(Exception e) 
			{
				e.printStackTrace();
				//out.println("Exception here" +e);//common-icn-0181
				
			}
			finally
			{
				try
				{
					if(pslPrepStmt!=null) pslPrepStmt.close();
				}
				catch(Exception e){}
			}

		} 
		catch ( Exception e ) 
		{
			//out.println(e.getMessage());//common-icn-0181			
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
				ConnectionManager.returnConnection(con, p);
		}
	}
}
