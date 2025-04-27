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
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class ClinicalCalcParamServlet extends javax.servlet.http.HttpServlet	
{
	

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}


	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{ 

		//HttpSession session = request.getSession(false);
		PrintWriter out = null;
		Connection con = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		//Hashtable tabdata = new Hashtable();
		//Properties p;
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		try
		{
			con.setAutoCommit( false ) ;
		}
		catch (Exception e)
		{
			
			e.printStackTrace() ;
		}
		
		
			updateClinCalc(request,response,con);
		

	}

	public void updateClinCalc(HttpServletRequest request,HttpServletResponse response,Connection con)
	{

		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1 = null;
		//ResultSet rs = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facilityid = "";

		String calc_id = "";
		String clin_formula = "";

		int nUpdStat = 0;

		
		//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		/*try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} */

		calc_id = request.getParameter("clin_calc")==null?"":request.getParameter("clin_calc");
		clin_formula = request.getParameter("clin_formula")==null?"":request.getParameter("clin_formula");
		

		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facilityid		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");

		
			
		

		String updClinFormQry ="update CA_CLINICAL_CALC d set d.FORMULA_REF_ID=? where d.CALC_ID =?  ";

		try
		{
				
			pstmt=con.prepareStatement(updClinFormQry);

			
			pstmt.setString(1,clin_formula);
			pstmt.setString(2,calc_id);
			
			
			nUpdStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

			if(nUpdStat>0)
				{ 		
					con.commit();
					errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;

				}
				else
				{
					con.rollback();
					errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
					error_value = "0" ;

				}

				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);


		}
		catch(Exception e )
		{
			//out.println("Exception in updateClinCalc method of  ClinicalCalcParamServlet ...So Record Not updated  : "+e.toString());
			
			e.printStackTrace();
			
			try
			{
				con.rollback();
				
			}
			catch(Exception eee)
			{
				
				eee.printStackTrace();
			}


		}
		finally
		{
				
			if(con != null) ConnectionManager.returnConnection(con);
				
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
