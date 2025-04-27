/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class EncSummApplicabilityServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public  void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{  
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		String mode = request.getParameter("mode") == null ? "" :  request.getParameter("mode");
		
		if(mode.equals("insert")) insert(request,response, out);
		if(mode.equals("modify")) modify(request, out);
		if(mode.equals("delete")) delete(request, out);
	}

/**
*	insert - will be called when the mode value is insert
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)		
	{
		String client_ip_addr;
		String facilityId;
		String addedId;
		
		HttpSession session; 
		Properties p;
		Hashtable tabdata;
		
		PreparedStatement ps;
		Connection con = null;
		ResultSet rs;
		
		String patientClass = "";		
		String specialtyCode = "";
		String practTypeCode = "";
		String practitionerId = "";
		String ageGrpCode = "";
		String summCode = "";
		
		String errVal = "0";
		String errorMsg = "";
		int count = 0;
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" );
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" );
		client_ip_addr=	p.getProperty("client_ip_address");
		addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user");		
		
		try{
			con = ConnectionManager.getConnection(request);
			
			patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
			specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");	
			practTypeCode = request.getParameter("practTypeCode") == null ? "" :  request.getParameter("practTypeCode");
			practitionerId = request.getParameter("practitionerId") == null ? "" :  request.getParameter("practitionerId");
			ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");
			summCode =  request.getParameter("summCode") == null ? "" :  request.getParameter("summCode");
			
			//ps = con.prepareStatement("select ES_SUMM_CODE from CR_ES_SUMM_APPLICABILITY where PATIENT_CLASS = ?  and SPECIALITY_CODE = ? and PRACT_TYPE = ? and  AGE_GROUP_CODE = ? ");
			//ps = con.prepareStatement("select ES_SUMM_CODE from CR_ES_SUMM_APPLICABILITY where PATIENT_CLASS = ?  and SPECIALITY_CODE = ? and PRACT_TYPE = ? and PRACTITIONER_ID = ? and  AGE_GROUP_CODE = ?  and ES_SUMM_CODE = ? ");
			ps = con.prepareStatement("select ES_SUMM_CODE from CR_ES_SUMM_APPLICABILITY where PATIENT_CLASS = ?  and SPECIALITY_CODE = ? and PRACT_TYPE = ? and PRACTITIONER_ID = ? and  AGE_GROUP_CODE = ? ");
			ps.setString(1,patientClass);
			ps.setString(2,specialtyCode);
			ps.setString(3,practTypeCode);
			ps.setString(4,practitionerId);
			ps.setString(5,ageGrpCode);
			//ps.setString(6,summCode);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count ++;
			}
			
			if(ps != null)ps.close();
			if(rs != null)rs.close();			
		
			if(count == 0)
			{
				ps = con.prepareStatement("insert into CR_ES_SUMM_APPLICABILITY (PATIENT_CLASS, SPECIALITY_CODE, PRACT_TYPE, PRACTITIONER_ID, AGE_GROUP_CODE, ES_SUMM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) " +
						"						values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ");
				ps.setString(1,patientClass);
				ps.setString(2,specialtyCode);
				ps.setString(3,practTypeCode);
				ps.setString(4,practitionerId);
				ps.setString(5,ageGrpCode);
				ps.setString(6,summCode);
				ps.setString(7,addedId);
				ps.setString(8,client_ip_addr);
				ps.setString(9,facilityId);
				ps.setString(10,addedId);
				ps.setString(11,client_ip_addr);
				ps.setString(12,facilityId);		
				
				int inserted = ps.executeUpdate();
				
				if(ps != null)ps.close();
				if(rs != null)rs.close();
				
				if(inserted != 0)
				{
					con.commit();
					tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
					errorMsg= (String) tabdata.get("message");
					errVal = "1";
				}
			}
			else
			{
				con.rollback();
				tabdata = MessageManager.getMessage(locale, "SUMM_ALREADY_CONFIGURED","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
			
			if(rs != null) rs.close();
			if(ps != null) ps.close();
		
		}
		catch(Exception ee)
		{
			out.println("Exception raise by Encounter Summary Applicability Servlet ...So Record Not inserted  : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{				
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}	
/**
*	modify	-	will be called when the mode value is modify
*	@param	request - this is HttpServletRequest
*	throws javax.servlet.ServletException,IOException
*/
	public void modify(HttpServletRequest request, PrintWriter out)
	{
		String client_ip_addr;
		String facilityId;
		String addedId;
		
		HttpSession session; 
		Properties p;
		Hashtable tabdata;
		
		String errVal = "0";
		String errorMsg = "";
		
		PreparedStatement ps;
		Connection con = null;

		String patientClass = "";
		String specialtyCode = "";
		String practTypeCode = "";
		String practitionerId = "";
		String ageGrpCode = "";
		String summCode = "";

		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_addr=	p.getProperty("client_ip_address");
		addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		
		try
		{
			con = ConnectionManager.getConnection(request);
			patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
			specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");
			practTypeCode = request.getParameter("practTypeCode") == null ? "" :  request.getParameter("practTypeCode");
			practitionerId = request.getParameter("practitionerId") == null ? "" :  request.getParameter("practitionerId");
			ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");
			summCode =  request.getParameter("summCode") == null ? "" :  request.getParameter("summCode");		
			
			String oldSummCode = request.getParameter("oldSummCode") == null ? "" :  request.getParameter("oldSummCode");
			
			ps = con.prepareStatement("update CR_ES_SUMM_APPLICABILITY set ES_SUMM_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? " +
					"where PATIENT_CLASS = ? and SPECIALITY_CODE = ? and PRACT_TYPE = ? and PRACTITIONER_ID = ? and  AGE_GROUP_CODE = ? and ES_SUMM_CODE = ? ");

			ps.setString(1,summCode);
			ps.setString(2,addedId);
			ps.setString(3,client_ip_addr);
			ps.setString(4,facilityId);				
			ps.setString(5,patientClass);
			ps.setString(6,specialtyCode);
			ps.setString(7,practTypeCode);
			ps.setString(8,practitionerId);
			ps.setString(9,ageGrpCode);
			ps.setString(10,oldSummCode);
			
			int updated = ps.executeUpdate();
			
			if(updated != 0)
			{
				con.commit();
				
				tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");	
				errVal = "1";
			}
			else
			{
				con.rollback();
				errVal = "0";
			}
			out.println("<script>parent.f_query_add_mod.document.encSummApplicabilityForm.patientClass.disabled=true</script>");
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");
		if(ps != null) ps.close();
		}
		catch(Exception ee)
		{
			//out.println("Exception raise by Enc Summary Applicability Servlet ...So Record Not Updated  : "+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}
	
	public void delete(HttpServletRequest request, PrintWriter out)	
	{
		HttpSession session; 
		Properties p;
		Hashtable tabdata;
		PreparedStatement ps;
		Connection con = null;

		String patientClass = "";
		String specialtyCode = "";
		String practTypeCode = "";
		String practitionerId = "";
		String ageGrpCode = "";
		String summCode = "";
		

		String errVal = "0";
		String errorMsg = "";

		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" );
		String locale = (String) p.getProperty("LOCALE");

		try
		{
			con = ConnectionManager.getConnection(request);
			patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
			specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");	
			practTypeCode = request.getParameter("practTypeCode") == null ? "" :  request.getParameter("practTypeCode");
			practitionerId = request.getParameter("practitionerId") == null ? "" :  request.getParameter("practitionerId");
			ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");
			summCode =  request.getParameter("summCode") == null ? "" :  request.getParameter("summCode");
			
			ps = con.prepareStatement("delete from cr_es_summ_applicability where PATIENT_CLASS = ? and SPECIALITY_CODE = ? and PRACT_TYPE = ? and PRACTITIONER_ID = ? and AGE_GROUP_CODE = ? and ES_SUMM_CODE = ? ");
			ps.setString(1,patientClass);
			ps.setString(2,specialtyCode);
			ps.setString(3,practTypeCode);
			ps.setString(4,practitionerId);
			ps.setString(5,ageGrpCode);
			ps.setString(6,summCode);
			int deleted = ps.executeUpdate();
			if(deleted != 0)
			{
				tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "1";
				con.commit();
				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");
			}
			else
			{
				tabdata = MessageManager.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","Common");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
				out.println("<script>parent.f_query_add_mod.document.encSummApplicabilityForm.patientClass.disabled=true</script>");
				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");		
			}
			if(ps != null) ps.close();
		}
		catch(Exception ee)
		{
			//out.println("Exception raise by Encounter Summary Applicability Servlet ...So Record Not Deleted  : "+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}

}
