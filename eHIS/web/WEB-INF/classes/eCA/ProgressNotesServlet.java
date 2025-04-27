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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
public class ProgressNotesServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	public void init(ServletConfig cfg) throws ServletException
    {
        super.init(cfg);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		this.out = response.getWriter();
		try	
		{
			String mode=request.getParameter("mode");
			session 			= request.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");
			if(mode.equals("NEW"))
			{
				insertProgression(request,response);
			}
			else if(mode.equals("CLOSE"))
			{
				closeProgression(request,response);	
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
    }

	public void insertProgression(HttpServletRequest request,HttpServletResponse response)
	{

		String module_id			= request.getParameter("module_id");
		String patient_id			= request.getParameter("patient_id");
		String speciality			= request.getParameter("speciality");
		String ProgressNotes		= request.getParameter("ProgressNotes");
		String queryString		= request.getParameter("queryString");
		String called_from			= request.getParameter("called_from");
		String addedById			= p.getProperty( "login_user" ) ;
		String addedAtWorkstation	= client_ip_address;
		String locale = (String) p.getProperty("LOCALE");
		
		int instval = 0;

		String errorMsg = "";
		String progression_ref	= "";

		Connection		  connection		= null ;
		PreparedStatement pstmt				= null ;
		ResultSet		  rs				= null ;

		String prgNoQry = " select max(PROGRESSION_CYCLE_NO) from CA_PAT_PROGRESSION_HDR where PATIENT_ID = ? and MODULE_ID = ? AND CALLED_FROM = 'OH_CHARTING'" ;

		String prgRefQry = " select CA_PROGRESSION_REF.CURRVAL progression_ref from dual ";
		
		int progression_no=Integer.parseInt(request.getParameter("progression_no")==null?"0":request.getParameter("progression_no"));
			if(progression_no==0)
				progression_no=1;
				

		String insertSQL ="INSERT INTO CA_PAT_PROGRESSION_HDR (PROGRESSION_REF, PATIENT_ID, MODULE_ID, PROGRESSION_CYCLE_NO, FACILITY_ID,SPECIALITY_CODE, PROGRESSION_STATUS, START_PROGRESS_NOTE_TYPE, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CALLED_FROM) values (CA_PROGRESSION_REF.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?)";


		try
		{
				
			connection=ConnectionManager.getConnection(request);

			if(called_from.equals("OH_TREATMENT"))
			{
				progression_no=1;
			}
			else
			{
			pstmt = connection.prepareStatement(prgNoQry);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				progression_no = Integer.parseInt( rs.getString(1)==null?"0":rs.getString(1) );
			}
			
			progression_no+=1;
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			pstmt=connection.prepareStatement(insertSQL);

			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setInt(3,progression_no);
			pstmt.setString(4,facilityId);
			pstmt.setString(5,speciality);
			pstmt.setString(6,"O");
			pstmt.setString(7,ProgressNotes);
			pstmt.setString(8,addedById);
			pstmt.setString(9,addedAtWorkstation);
			pstmt.setString(10,facilityId);
			pstmt.setString(11,addedById);
			pstmt.setString(12,addedAtWorkstation);
			pstmt.setString(13,facilityId);
			pstmt.setString(14,called_from);
			
			instval=pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();

			if(instval>0)
			{
				connection.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				//error_value = "1" ;

				if(called_from.equals("OH_TREATMENT"))
				{
					pstmt = connection.prepareStatement(prgRefQry);
					rs = pstmt.executeQuery();

					while(rs.next())
					{
						progression_ref = rs.getString(1);
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			else
			{
				connection.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				//error_value = "0" ;


			}
			
				out.println("<script>");
				out.println("if(top.content.matFrame != null){");
				//out.println("if(top.content.matFrame.maternitytreeframe != null){");
				//out.println("if(top.content.matFrame.maternitytreeframe.document.maternityMenu != null){");
				//out.println("alert('here....'+top.content.matFrame.maternitytreeframe.name);");
				//out.println("top.content.matFrame.maternitytreeframe.document.location.reload();");
				if(called_from.equals("OH_TREATMENT"))
				{ 	
				out.println("top.content.matFrame.location.href='../eCA/jsp/ProgressNotesTreeMain.jsp?progression_ref="+progression_ref+"&"+queryString+"';");
				}
				else
				{

					out.println("top.content.matFrame.location.href='../eCA/jsp/ProgressNotesTreeMain.jsp?"+queryString+"';");


				}
				
				out.println("top.content.workAreaFrame.location.href = '../eCommon/html/blank.html';}");
				
				out.println("window.returnValue='"+progression_ref+"'");
				
				//out.println("top.content.matFrame.maternitytreeframe.location.reload();}}}");
				out.println("parent.messageFrame.location='../eCommon/jsp/error.jsp?err_num="+errorMsg+"'</script>");
			
		
		
		/* MessageManager mm=new MessageManager();
		final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
		//String msg=((String) mesg.get("message"));
		String msg="";
		mesg.clear(); */

		//out.println("<script>parent.messageFrame.location='../eCommon/jsp/error.jsp?err_num="+msg+"'</script>");


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			if(connection!=null)
			{
				ConnectionManager.returnConnection(connection);
			}
		}
		


	}
	public void closeProgression(HttpServletRequest request,HttpServletResponse response)
	{

		String module_id			= request.getParameter("module_id");
		String patient_id			= request.getParameter("patient_id");
		String progression_no		= request.getParameter("progression_no");
		String progression_ref		= request.getParameter("progression_ref");
		String queryString		= request.getParameter("queryString");

		String locale = (String) p.getProperty("LOCALE");

		Connection		  connection		= null ;
		PreparedStatement pstmt				= null ;

		int instval = 0;

		String errorMsg = "";

		String updSQL = " update CA_PAT_PROGRESSION_HDR set PROGRESSION_STATUS= 'C' where PROGRESSION_REF = ? and  PATIENT_ID = ? and  MODULE_ID =  ? and PROGRESSION_CYCLE_NO =? ";

		try
		{
			
			connection = ConnectionManager.getConnection(request);

			pstmt = connection.prepareStatement(updSQL);
			pstmt.setString(1,progression_ref);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,module_id);
			pstmt.setString(4,progression_no);

			instval=pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();
	

			if(instval>0)
			{
				connection.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				//error_value = "1" ;

			}
			else
			{
				connection.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				//error_value = "0" ;


			}
			
				out.println("<script>");
				out.println("if(top.content != null){");
				//out.println("top.content.location.href='../eCA/jsp/ProgressNotesModalFrames.jsp?"+queryString+"';}");
				
				out.println("top.content.matFrame.maternitytreeframe.location.href = '../eCA/jsp/ProgressNotesMenu.jsp?"+queryString+"&sel_progression_no="+progression_no+"';");
				
				//out.println("top.content.matFrame.maternitytreeframe.location.reload();}}}");
				out.println("top.content.workAreaFrame.location.href = '../eCommon/html/blank.html';}");
				out.println("parent.messageFrame.location='../eCommon/jsp/error.jsp?err_num="+errorMsg+"'</script>");




		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			if(connection!=null)
			{
				ConnectionManager.returnConnection(connection);
			}
		}


	}




	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }




} 
