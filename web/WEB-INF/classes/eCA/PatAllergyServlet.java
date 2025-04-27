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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

import eCA.PatAllergy.* ;

public class PatAllergyServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out;	
		HttpSession session = req.getSession(false);
	
		try 
		{
			out = res.getWriter();
			String operation = req.getParameter("function_name");

			if(operation.equals("insert"))  insertPatAllergy(req,res,out,session);
			if(operation.equals("modify"))  modifyPatAllergy(req,res,out,session);
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void insertPatAllergy(HttpServletRequest req, HttpServletResponse res,PrintWriter out,HttpSession session)	
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		String	drug_code				=	"",							generic_id				=	"";
		String	temp_encounterid		=	"",							allergytypecode			=	"";
		String	allergytypecode2		=	"",							allergytypecode3		=	"";
		String	allergyclass			=	"",							allergicitem			=	"";
		String	allergicitem1			=	"",							onsetdate				=	"";
		String	remarks					=	"",							patientid				=	"";
		String	practid					=	"",							locncode				=	"";
		String	locntype				=	"",							eid						=	"";
	
		String	client_ip_address		=	(String) p.getProperty("client_ip_address");
		String	facilityId				=	(String)session.getValue("facility_id") ;

		long encounterid ;
	
		Connection con =	null;
		PreparedStatement pstmt = null;
		ResultSet rs =	null;

		try
		{
			con = ConnectionManager.getConnection(req);

			allergytypecode = req.getParameter("allergydesc");
			if( allergytypecode == null) allergytypecode="";
			allergytypecode2 = req.getParameter("allergydesc2");
			if( allergytypecode2 == null) allergytypecode2="";
			allergytypecode3 = req.getParameter("allergydesc3");
			if( allergytypecode3 == null) allergytypecode3="";
			allergyclass = req.getParameter("allergyclass");
			if( allergyclass == null) allergyclass="";
			allergicitem1 = req.getParameter("allergicto");
			if( allergicitem1 == null) allergicitem1="";

			if(allergyclass.equals("D"))
			{
				drug_code	=	(req.getParameter("drug_code")==null)	?	""	:	req.getParameter("drug_code");
				generic_id	=	(req.getParameter("generic_id")==null)	?	""	:	req.getParameter("generic_id");
				java.util.StringTokenizer St =new  java.util.StringTokenizer(allergicitem1,"$");

				while(St.hasMoreTokens())
				{
					St.nextToken();
					allergicitem=St.nextToken();
				}
			}
			else
				allergicitem=allergicitem1;

			onsetdate	=	req.getParameter("onset");
			onsetdate	=	com.ehis.util.DateUtils.convertDate(onsetdate,"DMY",locale,"en");

			remarks		=	req.getParameter("remarks");
			patientid	=	req.getParameter("Patient_Id");

			if( patientid == null) patientid="";
	
			onsetdate.trim();
		
			if( onsetdate == null || (onsetdate.equals("")) ) 
				onsetdate="";
			else 
			{
				String sql = " select to_date(?,'dd/mm/yyyy')-date_of_birth  from mp_patient  where patient_Id =?  ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, onsetdate);
				pstmt.setString(2, patientid);
				rs = pstmt.executeQuery();

				String validDate	= "";
				int dateCheck		= 0;

				while(rs.next())
				{
					validDate = rs.getString(1);
					dateCheck = Integer.parseInt(validDate);
				}

				if( dateCheck < 0)
				{
					String error =getMessage(locale, "LESS_THAN_BDAY_DATE","CA");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return;
				}
			}

			practid = req.getParameter("Practitioner_Id");
			if( practid == null || practid.equals("null") || practid.equals("")) practid="";
			locncode = req.getParameter("Clinic_Code");
			if( locncode == null || locncode.equals("null") || locncode.equals("")) locncode="";
			locntype = req.getParameter("Location_Type");
			if( locntype == null || locntype.equals("null") || locntype.equals("")) locntype="";
			eid = req.getParameter("Encounter_Id");
			if( eid == null || eid.equals("null") ) eid="";

			if (!eid.equals("") && !eid.equals("null"))
			{
				encounterid = Long.parseLong(eid);
				temp_encounterid=encounterid+"";
			}
	
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatAllergyManager",PatAllergyManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[18];
			argArray[0] = p;
			argArray[1] = patientid;
			argArray[2] = allergytypecode;
			argArray[3] = allergyclass;
			argArray[4] = allergicitem;
			argArray[5] = generic_id;
			argArray[6] = onsetdate;
			argArray[7] = remarks;
			argArray[8] = practid;
			argArray[9] = facilityId;
			argArray[10] = locncode;
			argArray[11] = locntype ;
			argArray[12] = temp_encounterid ;
			argArray[13] = client_ip_address;
			argArray[14] = facilityId;
			argArray[15] = drug_code;
			argArray[16] = allergytypecode2;
			argArray[17] = allergytypecode3;

			Class [] paramArray = new Class[18];
			paramArray[0] = p.getClass();
			paramArray[1] = patientid.getClass();
			paramArray[2] = allergytypecode.getClass();
			paramArray[3] = allergyclass.getClass();
			paramArray[4] = allergicitem.getClass();
			paramArray[5] = generic_id.getClass();
			paramArray[6] = onsetdate.getClass();
			paramArray[7] = remarks.getClass();
			paramArray[8] = practid.getClass();
			paramArray[9] = facilityId.getClass();
			paramArray[10] = locncode.getClass();
			paramArray[11] = locntype .getClass();
			paramArray[12] = temp_encounterid.getClass();
			paramArray[13] = client_ip_address.getClass();
			paramArray[14] = facilityId.getClass();
			paramArray[15] = drug_code.getClass();
			paramArray[16] = allergytypecode2.getClass();
			paramArray[17] = allergytypecode3.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertPatAllergy",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null; 
			paramArray = null;

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
				error_value = "1" ;
			else
			{
				error = (String) results.get("error") ;
				out.println(error);
			}
			
			results.clear();
			
			res.sendRedirect("../eCA/jsp/PatAllergyError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value); 
	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception in insert() of PatAllergyServlet.jsp "+e.toString());//common-icn-01181
			
			e.printStackTrace();
		 }
		 finally
		 {
		   if(con!=null)
				ConnectionManager.returnConnection(con,req);
		 }
	}

	private void modifyPatAllergy(HttpServletRequest req, HttpServletResponse res,PrintWriter out,HttpSession session)	
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		String locale = (String) p.getProperty("LOCALE");

		String allergyclass					=	"",							allergicitem			=	"";
		String allergicitem1				=	"",							errorRemarks			=	"";
		String temp_encounterid				=	"",							remarks					=	"";
		String closedate					=	"",							patientid				=	"";
		String practid						=	"",							locncode				=	"";
		String locntype						=	"",							eid						=	"";
		String srlno						=	"";

		String facilityId					=	(String) session.getValue("facility_id") ;
		String client_ip_address			=	(String) p.getProperty("client_ip_address");

		long encounterid ;

		Connection	con =	null;
		PreparedStatement pstmt = null;
		ResultSet rs =	null;
				
		try 
		{
			con = ConnectionManager.getConnection(req);

			allergyclass		=	req.getParameter("allergyclass");
			errorRemarks		=	req.getParameter("errorRemarks");
			allergicitem1		=	req.getParameter("allergicto");
			
			if(allergyclass.equals("D"))
			{
				java.util.StringTokenizer St =new  java.util.StringTokenizer(allergicitem1,";");

				while(St.hasMoreTokens())
				{
					St.nextToken();
					allergicitem=St.nextToken();
				}
			}
			else
				allergicitem=allergicitem1;

			srlno			=	req.getParameter("srlno");
			patientid		=	req.getParameter("Patient_Id");
			remarks			=	req.getParameter("remarks");
			closedate		=	req.getParameter("close");

			if(closedate == null || (closedate.equals("") ))
				closedate = "";
			else 
			{
				closedate = com.ehis.util.DateUtils.convertDate(closedate,"DMY",locale,"en");	
			
				String sql = " select to_date(?,'dd/mm/yyyy')-date_of_birth  from mp_patient  where patient_Id =?  ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, closedate);
				pstmt.setString(2, patientid);

				rs = pstmt.executeQuery();
				
				String validDate = "";

				int dateCheck = 0;

				while(rs.next())
				{
					validDate = rs.getString(1);
					dateCheck = Integer.parseInt(validDate);
				}

				if( dateCheck < 0)
				{
					String error =getMessage(locale, "CL_DATE_NOT_LT_BDATE","CA");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return;
				}
			}

			practid			= req.getParameter("Practitioner_Id");
			locncode		= req.getParameter("Clinic_Code");
			locntype		= req.getParameter("Location_Type");
			eid				= req.getParameter("Encounter_Id");

			if ( !eid.equals("") && !eid.equals("null"))
			{
				encounterid = Long.parseLong(eid);
				temp_encounterid=encounterid+"";
			}
			else
			{
				encounterid=0;
				temp_encounterid=encounterid+"";
			}
								
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatAllergyManager",PatAllergyManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[14];
			argArray[0] = p;
			argArray[1] = patientid;
			argArray[2] = srlno;
			argArray[3] = allergicitem;
			argArray[4] = remarks;
			argArray[5] = closedate;
			argArray[6] = practid;
			argArray[7] = facilityId;
			argArray[8] = locncode ;
			argArray[9] = locntype ;
			argArray[10] = temp_encounterid;
			argArray[11] = client_ip_address;
			argArray[12] = facilityId;
			argArray[13] =	errorRemarks;

			Class [] paramArray = new Class[14];
			paramArray[0] = p.getClass();
			paramArray[1] = patientid.getClass();
			paramArray[2] = srlno.getClass();
			paramArray[3] = allergicitem.getClass();
			paramArray[4] = remarks.getClass();
			paramArray[5] = closedate.getClass();
			paramArray[6] = practid.getClass();
			paramArray[7] = facilityId.getClass();
			paramArray[8] = locncode .getClass();
			paramArray[9] = locntype.getClass();
			paramArray[10] = temp_encounterid.getClass();
			paramArray[11] = client_ip_address.getClass();
			paramArray[12] = facilityId.getClass();
			paramArray[13] = errorRemarks.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updatePatAllergy",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null; 
			paramArray = null;
		
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( inserted )
			{
				error_value = "1" ;
				results.clear();
				res.sendRedirect("../eCA/jsp/PatAllergyError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
				
			}
			else
			{
				error = (String) results.get("error") ;
				results.clear();
				res.sendRedirect("../eCA/jsp/PatAllergyError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") );
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		} 
		catch ( Exception e ) 
		{
			//out.println(e.getMessage()+"<br>");//common-icn-0181
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)	
				ConnectionManager.returnConnection(con,req);
		}
	}
}
