/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
//import eAE.AMBResEquVehicleBean.*;
//import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class AMBEquipmentForVehicleServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = response.getWriter();

			String strResEqu			=	request.getParameter("amb_equ_type");

			if(strResEqu.equals("RS") )
				insertSecResForVehicle(request,response, out);
			else
				insertEquipForVehicle(request,response, out);
		}
		catch(Exception e)
		{
			//out.println("Exception in try of doPost() of Servlet.java "+e.toString());
			System.out.println("Exception in try of doPost() of Servlet.java "+e.toString());
			e.printStackTrace(System.err);
		}
	}

	private void insertSecResForVehicle(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;
		String facilityId = "" ;
		String client_ip_address = "";
		String note_type = "";
		HttpSession session;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		String addedById				= p.getProperty( "login_user" ) ;
		String locale = p.getProperty("LOCALE");
		boolean bFlag		=	true;

		String strResTypeQry	=	"";
		String sec_hdg_code = "";
		String note_seq_num = "";
		String chief_comp = "";
//		String strResType	= "";
		String countOfRows = "";
		String strInsertQry	=	"";
		String strResourceType	=	"";
		String error			=	"";

		String error_value		=	"";

		String sbDelQry			=	"";

		int records				=	0;

		java.util.HashMap valueMap = new java.util.HashMap();

		Connection	con				=	null;

		PreparedStatement pstmt		=	null;
		PreparedStatement psDel		=	null;

		int nDel					=	0;

		try
		{
			strResTypeQry	=	"SELECT PRACT_SOURCE FROM AM_PRACT_FOR_AMB_VW WHERE PRACTITIONER_ID = ?";
			sbDelQry		= "DELETE FROM AE_AMB_VEHICLE_RESOURCE WHERE FACILITY_ID = ? AND AMB_VEHICLE_ID = ? ";
	
			con = ConnectionManager.getConnection(request);

			con.setAutoCommit(false);

			note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			valueMap.put("note_type",note_type);			
			valueMap.put("facility_id",facilityId);
			valueMap.put("client_ip_address",client_ip_address);
			countOfRows = request.getParameter("countOfRows") == null ? "" : request.getParameter("countOfRows");
			valueMap.put("countOfRows",countOfRows);
			int i = Integer.parseInt(countOfRows);

			try
			{
				psDel		=	con.prepareStatement(sbDelQry);
				psDel.setString(1,facilityId);
				psDel.setString(2,note_type);
				nDel	=	psDel.executeUpdate();
	
			}
			catch (Exception e1)
			{
				e1.printStackTrace(System.err);
			}
			finally
			{
				if(psDel!=null) 	psDel.close();
			}

			for(int j=0;j<i;j++)
			{
				sec_hdg_code = request.getParameter("sec_heading_code"+j) == null ? "" : request.getParameter("sec_heading_code"+j);
				note_seq_num = request.getParameter("seq_num_text"+j) == null ? "" : request.getParameter("seq_num_text"+j);
				chief_comp = request.getParameter("chief_complaint"+j) == null ? "N" : request.getParameter("chief_complaint"+j);
				strResourceType = request.getParameter("resType"+j) == null ? "N" : request.getParameter("resType"+j);

				valueMap.put("sec_hdg_code"+j,sec_hdg_code);
				valueMap.put("note_seq_num"+j,note_seq_num);
				valueMap.put("chief_comp"+j,chief_comp);				
				valueMap.put("res_type"+j,strResourceType);				
			}
			
			strInsertQry	=	"INSERT INTO AE_AMB_VEHICLE_RESOURCE (FACILITY_ID,AMB_VEHICLE_ID,AMB_RESOURCE_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CONTACT_DISPLY_YN,AMB_RESOURCE_TYPE) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";

			if(i != 0)
			{
				pstmt = con.prepareStatement(strInsertQry);

				String strResourceId		=	"";
				
				for(int j=0;j<i;j++)
				{
					sec_hdg_code = (String)valueMap.get("sec_hdg_code"+j);

					StringTokenizer stTemp	=	 new StringTokenizer(sec_hdg_code,"~");
					
					if(stTemp != null && stTemp.hasMoreTokens() )
						strResourceId	=	 stTemp.nextToken();

					chief_comp = (String)valueMap.get("chief_comp"+j);
					strResourceType =	 (String)valueMap.get("res_type"+j);

					pstmt.setString(1,facilityId);
					pstmt.setString(2,note_type);
					pstmt.setString(3,strResourceId);
					pstmt.setString(4,addedById);
					pstmt.setString(5,client_ip_address);
					pstmt.setString(6,facilityId);
					pstmt.setString(7,addedById);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facilityId);
					pstmt.setString(10,chief_comp);
					pstmt.setString(11,strResourceType);
					records = pstmt.executeUpdate();

					if(records < 0)
					{
						bFlag	= false;
						break;
					}
					else
						bFlag	= true;
				}				

				valueMap.clear();
				if(pstmt != null) pstmt.close();

				if(bFlag)
				{
					con.commit();
					error_value	="1";
					//error	=	"APP-AE901 Operation Completed Successfully.......";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					message.clear();
				}
				else
				{
					con.rollback();
					error_value	="0";
					error	=	"APP-AE902 Updation Failed...";
				}
			}else{
					error_value	="1";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					message.clear();
			}/*else{
					error_value	="1";
					java.util.Hashtable message = MessageManager.getMessage(locale, "NO_CHANGE_TO_SAVE", "Common");
					error = ((String) message.get("message"));
					message.clear();
			}*/

			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();				
				//out.println("Exception in try of Servlet.java"+e.toString());
				System.out.println("Exception in try of Servlet.java"+e.toString());
				e.printStackTrace(System.err);
			}
			catch (Exception e2)
			{
				e2.printStackTrace(System.err);
			}

		}finally{
			
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}
	}

	private void insertEquipForVehicle(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;

		String facilityId = "" ;
		String client_ip_address = "";
		String note_type = "";
		HttpSession session;
		
		session				= request.getSession(false);
		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		String addedById	= p.getProperty( "login_user" ) ;
		String locale = p.getProperty("LOCALE");

		boolean bFlag		=	true;

	//	String strResTypeQry	=	"";
		String sec_hdg_code		=	"";
		String note_seq_num		=	"";
		//String chief_comp		=	"";
		String countOfRows		=	"";
		String strInsertQry		=	"";
	//	String strResourceType	=	"";
		String error			=	"";
		String error_value		=	"";
		String sbDelQry			=	"";

		int records				=	0;

		java.util.HashMap valueMap = new java.util.HashMap();

		Connection	con				=	null;

		PreparedStatement pstmt		=	null;
		PreparedStatement psDel		=	null;

		int nDel					=	0;

		try
		{
			sbDelQry		= "DELETE FROM AE_AMB_VEHICLE_EQUIP WHERE FACILITY_ID = ? AND AMB_VEHICLE_ID = ? ";
	
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);

			note_type		= request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

			valueMap.put("note_type",note_type);			
			valueMap.put("facility_id",facilityId);
			valueMap.put("client_ip_address",client_ip_address);
			countOfRows = request.getParameter("countOfRows") == null ? "" : request.getParameter("countOfRows");
			valueMap.put("countOfRows",countOfRows);
			int i = Integer.parseInt(countOfRows);

			try
			{
				psDel		=	con.prepareStatement(sbDelQry);

				psDel.setString(1,facilityId);
				psDel.setString(2,note_type);

				nDel	=	psDel.executeUpdate();
			}
			catch (Exception e1)
			{
				e1.printStackTrace(System.err);
			}finally{
				if(psDel!=null) psDel.close();
			}

			for(int j=0;j<i;j++)
			{
				sec_hdg_code = request.getParameter("sec_heading_code"+j) == null ? "" : request.getParameter("sec_heading_code"+j);
				note_seq_num = request.getParameter("seq_num_text"+j) == null ? "" : request.getParameter("seq_num_text"+j);

				valueMap.put("sec_hdg_code"+j,sec_hdg_code);
				valueMap.put("note_seq_num"+j,note_seq_num);
			}

			strInsertQry	=	"INSERT INTO AE_AMB_VEHICLE_EQUIP (FACILITY_ID,AMB_VEHICLE_ID,AMB_EQUIPMENT_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

			if(i != 0)
			{
				pstmt = con.prepareStatement(strInsertQry);

				for(int j=0;j<i;j++)
				{
					sec_hdg_code = (String)valueMap.get("sec_hdg_code"+j);

					pstmt.setString(1,facilityId);
					pstmt.setString(2,note_type);
					pstmt.setString(3,sec_hdg_code);
					pstmt.setString(4,addedById);
					pstmt.setString(5,client_ip_address);
					pstmt.setString(6,facilityId);
					pstmt.setString(7,addedById);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facilityId);

					records = pstmt.executeUpdate();

					if(records < 0)
					{
						bFlag	= false;
						break;
					}
					else
						bFlag	= true;
				}				

				valueMap.clear();
				if(pstmt != null) pstmt.close();

				if(bFlag)
				{
					con.commit();
					error_value	="1";
					//error	=	"APP-AE901 Operation Completed Successfully.......";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					message.clear();
				}
				else
				{
					con.rollback();
					error_value	="0";
					error	=	"APP-AE902 Updation Failed...";
				}
			}else{
					error_value	="1";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					message.clear();
			}/*else{
					error_value	="1";
					java.util.Hashtable message = MessageManager.getMessage(locale, "NO_CHANGE_TO_SAVE", "Common");
					error = ((String) message.get("message"));
					message.clear();
			}*/
			
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				//out.println("Exception in try of Servlet.java"+e.toString());
				System.out.println("Exception in try of Servlet.java"+e.toString());
				e.printStackTrace(System.err);
			}
			catch (Exception e2)
			{
				e2.printStackTrace(System.err);
			}
		}finally{
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}
	}
}
