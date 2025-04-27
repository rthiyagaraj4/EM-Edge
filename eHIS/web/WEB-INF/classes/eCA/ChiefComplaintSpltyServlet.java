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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
//import oracle.sql.*;
import eCommon.SingleTabHandler.*;

public class ChiefComplaintSpltyServlet extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			insert(req, res, out);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}


	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		//req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html,charset=UTF-8");
		java.util.Properties p;
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		int [] insertCounts			= null;
		boolean insert_flag			=false;
		int [] insertCounts1			= null;
		boolean update_flag			= false ;
		MessageManager mm=new MessageManager();

		Connection con				= null;
		
		PreparedStatement ins_pstmt = null;
		PreparedStatement del_pstmt = null;

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		String locale = p.getProperty("LOCALE");
		ChiefComplaintSplty complnt  = (ChiefComplaintSplty)session.getAttribute("chiefcomplnt");
		String complnt_code=req.getParameter("complnt_code");
		ArrayList insert_spcl=complnt.getList();
		ArrayList removelist=complnt.getloadupdtsp();
		int listsize			=removelist.size();
		int inst_size			=insert_spcl.size();

		try
		{
			
		con = ConnectionManager.getConnection(req);

		if(removelist.size() > 0){
			String deleteQuery = "DELETE FROM CA_CHIEF_COMPLAINT_SPLTY WHERE CA_CHIEF_COMPLAINT LIKE UPPER(?) AND SPECIALITY_CODE LIKE UPPER(?)";
			try{
					
					del_pstmt=con.prepareStatement(deleteQuery);			
					for(int i=0;i<listsize;i++){
						del_pstmt.setString(1,complnt_code);
						del_pstmt.setString(2,(String)removelist.get(i));
						del_pstmt.addBatch();
					}
					insertCounts1=del_pstmt.executeBatch();
					if(del_pstmt!=null) del_pstmt.close();
			}catch(Exception e){
				
				e.printStackTrace();

			}
			
			for (int i=0;i<insertCounts1.length ;i++ )
				{
					if(insertCounts1[i]<0  && insertCounts1[i] != -2 )
					{
						update_flag=false;
						break;
					}
					else
					{
						update_flag=true;
					}
				}
		}
		

		String insertQuery = "insert into CA_CHIEF_COMPLAINT_SPLTY(CA_CHIEF_COMPLAINT,SPECIALITY_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,sysdate,?,?,?,sysdate,?,?)";
		try{
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			try{
			for(int j=0;j<inst_size;j++){
				for(int k=0;k<listsize;k++){
					String code=(String)insert_spcl.get(j);
					if(code.equals(removelist.get(k)))
						insert_spcl.remove(j);
				}
			}
			
			ins_pstmt=con.prepareStatement(insertQuery);
			for(int i=0;i<insert_spcl.size();i++){
				ins_pstmt.setString	(1, complnt_code);
				ins_pstmt.setString	(2, (String)insert_spcl.get(i));
				ins_pstmt.setString	(3, addedById);
				ins_pstmt.setString	(4, addedAtWorkstation);
				ins_pstmt.setString	(5, addedFacilityId);
				ins_pstmt.setString	(6, modifiedById);
				ins_pstmt.setString	(7, modifiedAtWorkstation);
				ins_pstmt.setString	(8, modifiedFacilityId);
				ins_pstmt.addBatch();
			}

				insertCounts=ins_pstmt.executeBatch();

				if(ins_pstmt!=null) ins_pstmt.close();

				for (int i=0;i<insertCounts.length ;i++ )
				{
					if(insertCounts[i]<0  && insertCounts[i] != -2 )
					{
						insert_flag=false;
						break;
					}
					else
					{
						insert_flag=true;
					}
				}

			}catch(Exception eIns){
					//out.println("exception @Insert :"+eIns);//common-icn-0181
					eIns.printStackTrace();
				}

			if(insert_flag || update_flag)
			{
				con.commit();				
				final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
				String msg=((String) mesg.get("message"));
				mesg.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=1");
			}
			else
			{
				con.rollback();				
				final java.util.Hashtable mesg=mm.getMessage(locale,"NO_CHANGE_TO_SAVE","Common");
				String msg=((String) mesg.get("message"));
				mesg.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=0");
			}
					}catch ( Exception e ){
			//out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}		

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(con != null) ConnectionManager.returnConnection(con);			
		}
	}
	
}
