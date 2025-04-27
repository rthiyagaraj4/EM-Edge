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
import webbeans.eCommon.*;
 

public class CAPatMedReportServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = null;

		try
		{
			out = response.getWriter();
			insert(request,response,out);
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	{
		Properties p;
		HttpSession session;

		String addedById = "";
		String addedFacilityId = "";
		String clientIpAddress = "";
		String respID = "";
		String error_value = "0";
		String past_days = "";
		String unit = "";
		String current_encounter = "";
		String previous_enconters = "";
		String inpatient_yn = "";
		String outpatient_yn = "";
		String day_care = "";
		String emergency = "";
		String external = "";
		
		int k = 0;

		session = request.getSession(false);
		p = (java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		respID = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
		clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

		String noteTypeId = request.getParameter("NoteTypeID") == null ? "" : request.getParameter("NoteTypeID");
		String pmrBeanID = request.getParameter("pmrBeanID") == null ? "" : request.getParameter("pmrBeanID");
		String fnName = request.getParameter("fnName") == null ? "" : request.getParameter("fnName");
		//String selFacility = request.getParameter("selFacility") == null ? "" : request.getParameter("selFacility");
		String selFacility = request.getParameter("facility") == null ? "" : request.getParameter("facility");
	    past_days = request.getParameter("past_days") == null ? "0" : request.getParameter("past_days");
		unit = request.getParameter("unit") == null ? "" : request.getParameter("unit");
		current_encounter = request.getParameter("current_encounter") == null ? "N" : request.getParameter("current_encounter");
		previous_enconters = request.getParameter("previous_enconters") == null ? "0" : request.getParameter("previous_enconters");
		inpatient_yn = request.getParameter("inpatient_yn") == null ? "" : request.getParameter("inpatient_yn");
		outpatient_yn = request.getParameter("outpatient_yn") == null ? "" : request.getParameter("outpatient_yn");
		day_care = request.getParameter("day_care") == null ? "" : request.getParameter("day_care");
		emergency = request.getParameter("emergency") == null ? "" : request.getParameter("emergency");
		external = request.getParameter("external") == null ? "" : request.getParameter("external");

		current_encounter		=(current_encounter==null)?"Y":current_encounter; 
		current_encounter		=(current_encounter.equals(""))?"Y":current_encounter ;
		inpatient_yn		    =(inpatient_yn.equals(""))?"N":inpatient_yn ;
		outpatient_yn		    =(outpatient_yn.equals(""))?"N":outpatient_yn ;
		day_care		        =(day_care.equals(""))?"N":day_care ;
		emergency		        =(emergency.equals(""))?"N":emergency ;
		external		        =(external.equals(""))?"N":external ;
		past_days		        =(past_days==null)?"0":past_days;
		previous_enconters	    =(previous_enconters==null)?"0":previous_enconters;
		past_days		        =(past_days.equals(""))?"0":past_days;
		previous_enconters	    =(previous_enconters.equals(""))?"0":previous_enconters;
		
		
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		//ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "";
		String sqlDel = "";
		String sqlcnt ="";

		//if (fnName.equals("Encounter Details"))
		if (fnName.equals("CAMS_ENC_DTL_FOR_PMR"))
		{	
		    sqlcnt = "select count(*) total from CA_PMR_ENCNTR_DETAILS where NOTE_TYPE_ID = ? ";

			sqlDel = "delete CA_PMR_ENCNTR_DETAILS where NOTE_TYPE_ID = ? ";

			sql = "INSERT INTO CA_PMR_ENCNTR_DETAILS (NOTE_TYPE_ID,ENCNTR_PAST_DAYS,ENCNTR_PDAYS_OPTION,CURRENT_ENCNTR,PREV_ENCNTR,INPATIENT_YN,OUTPATIENT_YN,DAYCARE_YN,EMERGENCY_YN,EXTERNAL_YN,FACILITY_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			
		//}else if (fnName.equals("Speciality"))
		}else if (fnName.equals("CAMS_SPLTY_FOR_PMR"))
		{
			sql = "INSERT INTO CA_PMR_FOR_SPECIALITY (NOTE_TYPE_ID,SPECIALITY_CODE,FACILITY_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";		
			
			sqlDel = "delete CA_PMR_FOR_SPECIALITY where NOTE_TYPE_ID = ? and FACILITY_ID=?";
		//}else if (fnName.equals("Practitioner"))
		}else if (fnName.equals("CAMS_PRACT_FOR_PMR"))
		{
			sql = "INSERT INTO CA_PMR_FOR_PRACTITIONER (NOTE_TYPE_ID,PRACTITIONER_ID,FACILITY_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";		
			
			sqlDel = "delete CA_PMR_FOR_PRACTITIONER where NOTE_TYPE_ID = ? and FACILITY_ID=?";
		}
	
		try
		{			
			con = ConnectionManager.getConnection(request);

			//if (fnName.equals("Speciality")  || fnName.equals("Practitioner"))
			if (fnName.equals("CAMS_SPLTY_FOR_PMR")  || fnName.equals("CAMS_PRACT_FOR_PMR"))
			{
			
				if (!pmrBeanID.equals("") && pmrBeanID != null)
				{
				
					PatientBannerGroupLine pmrBeanOBJ = (PatientBannerGroupLine) com.ehis.persist.PersistenceHelper.getObjectFromBean(pmrBeanID,pmrBeanID,session);

					ArrayList list = pmrBeanOBJ.returnList1();							
					
					ps = con.prepareStatement(sqlDel);
					ps.setString(1,noteTypeId);
					ps.setString(2,addedFacilityId);
					//int X = ps.executeUpdate();
					ps.executeUpdate();

								
					if(ps != null) ps.close();

					ps = con.prepareStatement(sql);
					if (list.size() > 0)
					{					
						for(int i =0;i<list.size();i++)
						{					
							ps.setString(1,noteTypeId);					
							ps.setString(2,(String)list.get(i));
							ps.setString(3,addedFacilityId);
							ps.setString(4,addedById);
							ps.setString(5,clientIpAddress);
							ps.setString(6,addedFacilityId);
							ps.setString(7,addedById);
							ps.setString(8,clientIpAddress);
							ps.setString(9,addedFacilityId);

							k = ps.executeUpdate();
							
						}
					}else {
						k = 1;
					}
					if(ps != null) ps.close();
				}			
			//}else if (fnName.equals("Encounter Details"))
			}else if (fnName.equals("CAMS_ENC_DTL_FOR_PMR"))
			{							
					ps1 = con.prepareStatement(sqlcnt);
					ps1.setString(1,noteTypeId);
					//ps1.setString(2,selFacility);
					rs1=ps1.executeQuery();
					while(rs1.next() && rs1!=null)
					{
						ps = con.prepareStatement(sqlDel);
						ps.setString(1,noteTypeId);
						//ps.setString(2,selFacility);
						//int X = ps.executeUpdate();
						 ps.executeUpdate();
					
						if(ps != null) ps.close();
					}
					if(rs1!=null)
			        rs1.close();
		            if(ps1!=null)
			        ps1.close();

                     ps = con.prepareStatement(sql);
					 
					 ps.setString(1,noteTypeId);					
					 ps.setString(2,past_days);
					 ps.setString(3,unit);
					 ps.setString(4,current_encounter);
					 ps.setString(5,previous_enconters);
					 ps.setString(6,inpatient_yn);
					 ps.setString(7,outpatient_yn);
					 ps.setString(8,day_care);
					 ps.setString(9,emergency);
					 ps.setString(10,external);
					 ps.setString(11,selFacility);
					 ps.setString(12,addedById);
					 ps.setString(13,clientIpAddress);
					 ps.setString(14,addedFacilityId);
					 ps.setString(15,addedById);
					 ps.setString(16,clientIpAddress);
					 ps.setString(17,addedFacilityId);

					 k = ps.executeUpdate();

					 if(ps != null) ps.close();
					
	
			}else {
				 error_value = "0";
			}
			
			if(k > 0) error_value = "1";
			
			if(error_value.equals("1"))
			{
				con.commit();
				
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");
				
				tabdata.clear();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");				
			}
		}
		catch(Exception ee)
		{
			try
			{
				con.rollback();	
			}
			catch (Exception rb)
			{
			}
			
			//out.println("Exception in try - insert of CAPatMedReportServlet.java -"+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	}

   
} // end of class CAPatMedReportServlet
