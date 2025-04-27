/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eIP.IPConfirmBooking.*;
import com.ehis.util.*;

public class IPAdvBedMgmtTrnsServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		String operation=checkForNull(req.getParameter("operation"));
		try{
			if(operation.equals("cancelDischargeAdvice")){				
				CancelDischargeAdviceFinDtlsValidations(req,res);				
			}else if(operation.equals("DischargePatient")){
				dischargePatientValidations(req,res);	
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}//E.O.doPost

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);
		}
		catch(Exception e)	{	e.printStackTrace(); }
	}
	private void CancelDischargeAdviceFinDtlsValidations(HttpServletRequest req, HttpServletResponse res)throws Exception{
		//System.out.println("IPAdvBedMgmtTrnsServlet CancelDischargeAdviceFinDtlsValidations");
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		//String updateSQL			=null;
		try{
			HttpSession session		=  req.getSession(false);
			String facility_id		= (String)session.getValue("facility_id") ;
			String nursingUnit 	= checkForNull(req.getParameter("nursingUnit"));
			String encounter_id 	= checkForNull(req.getParameter("encounter_id"));
			//String patient_id 	= checkForNull(req.getParameter("patient_id"));
			String function_id 	= checkForNull(req.getParameter("function_id"));
			con = ConnectionManager.getConnection(req);
			/*updateSQL="update ip_nursing_unit set floor_width=?,floor_height=? where NURSING_UNIT_CODE=? and FACILITY_ID=?";
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL);			
			pstmt.setInt(1, Integer.parseInt(floorWidth));
			pstmt.setInt(2, Integer.parseInt(floorHeight));
			pstmt.setString(3,nursingUnit);
			pstmt.setString(4,facility_id);
			pstmt.executeUpdate();
			con.commit();*/
			String retValue=IPAdvBedMgmtBean.canDisAdviceFinDtlsValidations(facility_id,nursingUnit,function_id,encounter_id,con,pstmt,rSet);
			PrintWriter	out			= null;
			out						= res.getWriter();
			System.out.println("retValue ==>"+retValue+"<==");
			out.print(retValue);
			out.flush();
			out.close();
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private void dischargePatientValidations(HttpServletRequest req, HttpServletResponse res)throws Exception{
		//System.out.println("IPAdvBedMgmtTrnsServlet dischargePatientValidations");
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		//String updateSQL			=null;
		try{
			HttpSession session		=  req.getSession(false);
			String facility_id		= (String)session.getValue("facility_id") ;
			String nursingUnit 	= checkForNull(req.getParameter("nursingUnit"));
			String encounter_id 	= checkForNull(req.getParameter("encounter_id"));
			//String patient_id 	= checkForNull(req.getParameter("patient_id"));
			String function_id 	= checkForNull(req.getParameter("function_id"));
			String bl_operational 	= checkForNull(req.getParameter("bl_operational"));
			String bl_dtls_in_ip 	= checkForNull(req.getParameter("bl_dtls_in_ip"));
			con = ConnectionManager.getConnection(req);
			String retValue=IPAdvBedMgmtBean.dischargePatientValidations(facility_id,nursingUnit,function_id,encounter_id,bl_operational,bl_dtls_in_ip,con,pstmt,rSet);
			PrintWriter	out			= null;
			out						= res.getWriter();
			//System.out.println("retValue ==>"+retValue+"<==");
			out.print(retValue);
			out.flush();
			out.close();
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString,String defaultstr)
	{
		return (inputString==null)	?	defaultstr	:	inputString;
	}
}// E.O.Class
