/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class FacilityForResponsibilityServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String  respID="" ;
	String  faci="";
    String locale="";
	String insert_vals="";
	String update_vals="";
	String delete_vals="";
	String remarks = "";
	String facilityId ;
	String client_ip_address ;
	Connection con ;
	PreparedStatement pslPrepStmt = null;
	Statement stmt				 = null;
	HttpSession session;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			insertModifyRespFacility(req, res);
		}
		catch(Exception e) 
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con, req);
		}
	}
	private void insertModifyRespFacility(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{  con.setAutoCommit(false);
			StringBuffer sblQry = new StringBuffer();
			respID = req.getParameter("respID");
			faci = req.getParameter("faci");
			String addedById = p.getProperty( "login_user" ) ;
	
//				Timestamp  ts= new Timestamp(System.currentTimeMillis() );
			/*HashMap tabdata=new HashMap();
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );*/
			String facilityID="";
			int ilStatus = 0 ;
			int ilStatus1 = 0 ;
			int ilStatus2 = 0 ;
			insert_vals = req.getParameter("insert_vals");
			update_vals = req.getParameter("update_vals");
			delete_vals = req.getParameter("delete_vals");
			
			String i="";
			if(!insert_vals.equals(""))
			{
			StringTokenizer insToken = new StringTokenizer(insert_vals, "~");
			String sql="insert into SM_facility_for_resp (resp_id,facility_id,remarks,added_by_id,added_date,added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no ) values(?,?,?,?,sysdate,?,?,sysdate,?) ";
			pslPrepStmt = con.prepareStatement(sql);
				while(insToken.hasMoreTokens())
				{
						i = insToken.nextToken();
						facilityID = (req.getParameter("facilityID"+i)==null)	?	""	:	req.getParameter("facilityID"+i);
						remarks = (req.getParameter("comments"+i)==null)	?	""	:	req.getParameter("comments"+i);
											
						

						if(!(faci.equals("fac")))
						  {
						pslPrepStmt.setString(1,respID);
						pslPrepStmt.setString(2,facilityID);
						pslPrepStmt.setString(3,remarks);
						pslPrepStmt.setString(4,addedById);
						pslPrepStmt.setString(5,client_ip_address);
						pslPrepStmt.setString(6,addedById);
						pslPrepStmt.setString(7,client_ip_address);
						ilStatus = pslPrepStmt.executeUpdate();

						  }else
						{
						pslPrepStmt.setString(1,facilityID);
						pslPrepStmt.setString(2,respID);
						pslPrepStmt.setString(3,remarks);
						pslPrepStmt.setString(4,addedById);
						pslPrepStmt.setString(5,client_ip_address);
						pslPrepStmt.setString(6,addedById);
						pslPrepStmt.setString(7,client_ip_address);
						ilStatus = pslPrepStmt.executeUpdate();
						}
						if(!(ilStatus >=1))
						{
							break;
						}
				}
			}

			if(pslPrepStmt != null)
				pslPrepStmt.close();
				
			if(!delete_vals.equals(""))
			{
			StringTokenizer insToken = new StringTokenizer(delete_vals, "~");
			String ids_to_delete = "(";
			int k=0;
				while(insToken.hasMoreTokens())
				{
					if(k != 0)
						ids_to_delete = ids_to_delete +",";
					i = insToken.nextToken();
					
					ids_to_delete =ids_to_delete+ "'"+i+"'";
					k++;
				}
				ids_to_delete = ids_to_delete +")";
				
				if((faci.equals("fac")))
				{
					
					sblQry.append("DELETE FROM SM_facility_for_resp where FACILITY_ID = '"+respID+"' and  RESP_ID IN  "+ids_to_delete);
				}
				else
				{
					sblQry.append("DELETE FROM SM_facility_for_resp where RESP_ID = '"+respID+"' and FACILITY_ID IN "+ids_to_delete);
				
				}
				stmt = con.createStatement();
				ilStatus1 = stmt.executeUpdate(sblQry.toString());
			
			}

			if(!update_vals.equals(""))
			{
				StringTokenizer insToken = new StringTokenizer(update_vals, "~");
		//	String sql="insert into SM_facility_for_resp (resp_id,facility_id,remarks,added_by_id,added_date,added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no ) values(?,?,?,?,sysdate,?,?,sysdate,?) ";
			String sql="update SM_facility_for_resp set remarks=? , modified_by_id = ? ,modified_date=sysdate , modified_at_ws_no=?  where FACILITY_ID =? and RESP_ID = ? ";
			pslPrepStmt = con.prepareStatement(sql);
				while(insToken.hasMoreTokens())
				{
						i = insToken.nextToken();
						facilityID = (req.getParameter("facilityID"+i)==null)	?	""	:	req.getParameter("facilityID"+i);
						remarks = (req.getParameter("comments"+i)==null)	?	""	:	req.getParameter("comments"+i);

						if(!(faci.equals("fac")))
						{
						pslPrepStmt.setString(1,remarks);
						pslPrepStmt.setString(2,addedById);
						pslPrepStmt.setString(3,client_ip_address);
						pslPrepStmt.setString(4,facilityID);
						pslPrepStmt.setString(5,respID);
						ilStatus2 = pslPrepStmt.executeUpdate();
						  }else
						{
						pslPrepStmt.setString(1,remarks);
						pslPrepStmt.setString(2,addedById);
						pslPrepStmt.setString(3,client_ip_address);
						pslPrepStmt.setString(4,respID);
						pslPrepStmt.setString(5,facilityID);
						ilStatus2 = pslPrepStmt.executeUpdate();
						}
						if(!(ilStatus2 >=1))
						{
							break;
						}
				}
			}
			if(pslPrepStmt != null)
				pslPrepStmt.close();

			if(stmt != null)
				stmt.close();
          
			String s20 = "";
			if(ilStatus >=1||ilStatus1 >=1 ||ilStatus2 >=1)
			{
				con.commit();
                java.util.Hashtable hashtable1 = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				s20 = (String)hashtable1.get("message");
				hashtable1.clear();
				//out.println("<script>alert('" + s20 + "');</script>");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode("","UTF-8") + "&err_value=1");
		 	}
			else
            {
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8") + "&err_value=1");
            }
			//if(pslPrepStmt != null)pslPrepStmt.close();
		}
		catch ( Exception e )
		{
			try{
			con.rollback();
			}
			catch(Exception ee){
			}	
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	
		
	}
}
