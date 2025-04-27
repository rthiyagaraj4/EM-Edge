/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Modified By		: NANDA KUMAR R.
Modified Date	: 21/04/2002
*/

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
import com.ehis.util.*;

public class FacilitiesForUserServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
    String locale="";
	String userid;
	String  facility ;
	String remarks;
	String facilityId ;
	String client_ip_address ;
	Connection con ;
	PreparedStatement pslPrepStmt = null;
	Statement stmt				 = null;
	String insert_vals="";
	String update_vals="";
	String delete_vals="";	

	//boolean insertable;
	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
	    client_ip_address = p.getProperty("client_ip_address");
		try
		{
			res.setContentType("text/html");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			insertFacility(req, res);

			pslPrepStmt = null;
			
			out = null;

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


	private void insertFacility(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			userid=req.getParameter("userID");
			facility = req.getParameter("facilityID");
			remarks=req.getParameter("remarks");
			String label = req.getParameter("label1")==null ? "" : req.getParameter("label1");
			String addedById = p.getProperty( "login_user" ) ;
			//String modifiedById = addedById ;
			//String addedFacilityId=facilityId;
			//String modifiedFacilityId = addedFacilityId ;
			//String addedAtWorkstation=client_ip_address;
			//String modifiedAtWorkstation = addedAtWorkstation ;

			/*HashMap tabdata=new HashMap();
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );*/
            

            String checkedFromDate="",checkedToDate="";
			String facilityID ="";
           
           
            String	from	=	"",	to		=	"";
			String sql="";
			int ilStatus = 0 ;
			int ilStatus1 = 0 ;
			int ilStatus2 = 0 ;
			insert_vals = req.getParameter("insert_vals");
			update_vals = req.getParameter("update_vals");
			delete_vals = req.getParameter("delete_vals");

            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			String i="";

			if(!insert_vals.equals(""))
			{
				StringTokenizer insToken = new StringTokenizer(insert_vals, "~");
				if(label.equals("User")){
				sql = "insert into sm_facility_for_user(APPL_USER_ID ,FACILITY_ID,ACCESS_EFF_DATE_FROM,ACCESS_EFF_DATE_TO,REMARKS,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,sysdate,?)";
				}
				else{
					sql = "insert into sm_facility_for_user(FACILITY_ID  ,APPL_USER_ID,ACCESS_EFF_DATE_FROM,ACCESS_EFF_DATE_TO,REMARKS,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,sysdate,?)";
				}
				pslPrepStmt = con.prepareStatement(sql);
			
			while(insToken.hasMoreTokens())
				{
						i = insToken.nextToken();
						facilityID = (req.getParameter("facilityID"+i)==null)	?	""	:	req.getParameter("facilityID"+i);
						remarks = (req.getParameter("comments"+i)==null)	?	""	:	req.getParameter("comments"+i);

						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
					
						

						pslPrepStmt.setString(1,userid);
						pslPrepStmt.setString(2,facilityID);
						pslPrepStmt.setString(3,checkedFromDate);
						pslPrepStmt.setString(4,checkedToDate);
						pslPrepStmt.setString(5,remarks);
						pslPrepStmt.setString(6,addedById);
						pslPrepStmt.setString(7,client_ip_address);
						pslPrepStmt.setString(8,addedById);
						pslPrepStmt.setString(9,client_ip_address);

						ilStatus = pslPrepStmt.executeUpdate();

						if(!(ilStatus >=1))
						{
							break;
						}
				}

			}
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

				StringBuffer sblQry = new StringBuffer();
				if(!label.equals("User"))
				{
					sblQry.append("DELETE FROM sm_facility_for_user  where FACILITY_ID = '"+userid+"' and APPL_USER_ID IN "+ids_to_delete);
				}
				else
				{
					sblQry.append("DELETE FROM sm_facility_for_user  where APPL_USER_ID = '"+userid+"' and FACILITY_ID IN "+ids_to_delete);
				}

				stmt = con.createStatement();
				ilStatus1 = stmt.executeUpdate(sblQry.toString());
			}

			if(!update_vals.equals(""))
			{
				StringTokenizer insToken = new StringTokenizer(update_vals, "~");
				if(label.equals("User")){
				sql = "update sm_facility_for_user set ACCESS_EFF_DATE_FROM=to_date(?,'dd/mm/yyyy'),ACCESS_EFF_DATE_TO=to_date(?,'dd/mm/yyyy'),REMARKS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where  APPL_USER_ID=? and FACILITY_ID=?";
				}
				else{
					sql = "update sm_facility_for_user set ACCESS_EFF_DATE_FROM=to_date(?,'dd/mm/yyyy'),ACCESS_EFF_DATE_TO=to_date(?,'dd/mm/yyyy'),REMARKS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where  FACILITY_ID=? and APPL_USER_ID=? ";

				}
				pslPrepStmt = con.prepareStatement(sql);
			
			while(insToken.hasMoreTokens())
				{
						i = insToken.nextToken();
						facilityID = (req.getParameter("facilityID"+i)==null)	?	""	:	req.getParameter("facilityID"+i);
						remarks = (req.getParameter("comments"+i)==null)	?	""	:	req.getParameter("comments"+i);

						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
					
						

						
						pslPrepStmt.setString(1,checkedFromDate);
						pslPrepStmt.setString(2,checkedToDate);
						pslPrepStmt.setString(3,remarks);
						pslPrepStmt.setString(4,addedById);
						pslPrepStmt.setString(5,client_ip_address);
						pslPrepStmt.setString(6,userid);
						pslPrepStmt.setString(7,facilityID);

						ilStatus2 = pslPrepStmt.executeUpdate();

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
			//if(ilStatus >=1)
			if(ilStatus >=1 || ilStatus1 >=1 || ilStatus2 >=1)
			{
				con.commit();
				java.util.Hashtable hashtable1 = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				s20 = (String)hashtable1.get("message");
				hashtable1.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode("", "UTF-8") + "&err_value=1");
		 	}else
            {
                con.rollback();
                res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20, "UTF-8") + "&err_value=1");
            }
			

	if(pslPrepStmt != null)pslPrepStmt.close();
	}
	catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
		out.println(  userid+ " "+facility+ " "+remarks);
		e.printStackTrace();
	}
	

}

} 
