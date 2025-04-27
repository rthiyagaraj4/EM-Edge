/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

/**
 *		FileName : FacilityDeptServlet.java
 *		Version	 : 3
 *		Date	 : 14-2-05	
**/
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;


public class FacilityDeptServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	Connection con;
	java.util.Properties p;
	String opfacilityid;
	String deptcode ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	PreparedStatement pslPrepStmt = null;
	PreparedStatement pslPrepchk = null;
String locale="";
	//String serviceURL;
	//String objectName;
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
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);

			String operation = req.getParameter("function_name");
			if ( operation.equals("modify")) 
				modifyFacilityDept(req, res);


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
	}*/


	private void modifyFacilityDept(HttpServletRequest req, HttpServletResponse res)
	{
		ResultSet rescnt = null;

		try
		{
			opfacilityid=req.getParameter("facility");
			
			HashMap tabdata=new HashMap();

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;

				tabdata.put("added_date", added_date);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("operating_facility_id",opfacilityid);

        		String totalvalues=req.getParameter("totalvalues") != null ? req.getParameter("totalvalues") : "";
				StringTokenizer stringtokenizer = new StringTokenizer(totalvalues, "~");
				out.println("totalvalues "+ totalvalues);
				int maintkn=stringtokenizer.countTokens();
				String sqlMain="";
				int ilStatus=0;
				for(int j=0;j<maintkn;j++)
				{
					String stMain=stringtokenizer.nextToken();
					StringTokenizer st5=new StringTokenizer(stMain,"$");
					String dept_code = st5.nextToken();
					String status = st5.nextToken();
					String flag = st5.nextToken();
					out.println("flag "+ flag +" status "+ status);
					 if((flag.equals("N") || flag.equals("Y")) && status.equals("E"))
					 {
						String chkSql="select count(*) from am_facility_dept where OPERATING_FACILITY_ID='"+opfacilityid+"'  and DEPT_CODE='"+dept_code+"'";
						pslPrepchk = con.prepareStatement(chkSql);
						rescnt = pslPrepchk.executeQuery();
						rescnt.next();
						if(rescnt.getInt(1) == 0 )
						{
							sqlMain="INSERT INTO am_facility_dept "+
										" ( OPERATING_FACILITY_ID, DEPT_CODE,EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, "+
										" ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) "+
										" VALUES ( "+
										" '"+opfacilityid+"', '"+dept_code+"','E', '"+ addedById +"', sysdate ,'"+ client_ip_address +"', "+
										" '"+ modifiedFacilityId +"', '"+ addedById +"', sysdate ,'"+ client_ip_address +"','"+ modifiedFacilityId +"') ";
						
							 pslPrepStmt = con.prepareStatement(sqlMain);
							 ilStatus = pslPrepStmt.executeUpdate();
							if(pslPrepStmt!= null) 
								pslPrepStmt.close();//ADDED BY RAJESH 8/11/2004
						}
				 		else
				 		{
							 sqlMain=" update am_facility_dept set EFF_STATUS='E' ,MODIFIED_BY_ID='"+addedById+"', "+
											" MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+client_ip_address+"', "+
											" MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where "+
											" OPERATING_FACILITY_ID ='"+opfacilityid +"'  and DEPT_CODE='"+dept_code+"' ";
							 pslPrepStmt = con.prepareStatement(sqlMain);
							 ilStatus = pslPrepStmt.executeUpdate();
							if(pslPrepStmt!= null)
								pslPrepStmt.close();//ADDED BY RAJESH 8/11/2004 
						}
						if(rescnt!=null) rescnt.close();
						if(pslPrepchk!= null) pslPrepchk.close();
					 }
					 else
						 if(flag.equals("N") || flag.equals("Y") && status.equals("D"))
						 {
							 sqlMain=" update am_facility_dept set EFF_STATUS='D' ,MODIFIED_BY_ID='"+addedById+"', "+
											" MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+client_ip_address+"', "+
											" MODIFIED_FACILITY_ID='"+modifiedFacilityId+"'  where "+
											" OPERATING_FACILITY_ID ='"+opfacilityid +"'  and DEPT_CODE='"+dept_code+"' ";

						 pslPrepStmt = con.prepareStatement(sqlMain);
						 ilStatus = pslPrepStmt.executeUpdate();
						  if(pslPrepStmt!= null)
							pslPrepStmt.close();  //ADDED BY RAJESH 8/11/2004
						 }
						 
					}
					tabdata.clear();
					String error = "";
					if(ilStatus == 1)
					{
						con.commit();
						Map hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						error = (String)hashtable1.get("message");
					    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=1");
						hashtable1.clear();
					} 
					else
					{
					   con.rollback();
					   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) );
            		}
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( opfacilityid+ " "+deptcode+ " "+ effectiveStatus );
		}
		finally
		{
			try
			{
				if(pslPrepStmt!= null) pslPrepStmt.close();
			}
			catch(Exception e)
			{
				out.print("Exception in closing statements " + e);
			}
		}
	}
}
