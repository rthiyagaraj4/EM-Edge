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
import eCommon.SingleTabHandler.*;
import eIP.IPSwapPatientBed.* ;


public class SwapPatientBedServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out			= null;
	Properties p			= null;
	String sStyle;
	String locale			= "";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		String facilityId = (String)session.getValue("facility_id") ;
		sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		this.p = (Properties) session.getValue( "jdbc" ) ;
		
		try 
		{
			locale = p.getProperty("LOCALE");
			this.out = res.getWriter();
			IPSwapPatientBeds(req, facilityId);
		}catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void IPSwapPatientBeds(HttpServletRequest req, String facilityId)	
	{
		String srl_no	="";
		try
		{
			String patientid1			= checkForNull(req.getParameter("patient_id1"));
			String eid1					= checkForNull(req.getParameter("encounter_id1"));
			String patientid2			= checkForNull(req.getParameter("patient_id2"));
			String eid2					= checkForNull(req.getParameter("encounter_id2"));
			String practitioner_id1		= checkForNull(req.getParameter("practitioner_id1"));
			String practitioner_id2		= checkForNull(req.getParameter("practitioner_id2"));
			String nursing_unit_code1	= checkForNull(req.getParameter("nursing_unit_code1"));
			String nursing_unit_code2	= checkForNull(req.getParameter("nursing_unit_code2"));
			String bl_operational		= checkForNull(req.getParameter("bl_operational"));
			String bl_interfaced_yn		= checkForNull(req.getParameter("bl_interfaced_yn"));
			String patient_class1		= checkForNull(req.getParameter("patient_class1"));
			String patient_class2		= checkForNull(req.getParameter("patient_class2"));
			String mother_bed_status1	= checkForNull(req.getParameter("mother_bed_status1"));
				   if(mother_bed_status1.equals(""))
					  mother_bed_status1= "N";
			String mother_bed_status2	= checkForNull(req.getParameter("mother_bed_status2"));
			if(mother_bed_status2.equals(""))
					  mother_bed_status2= "N";
			String year1				= checkForNull(req.getParameter("year1"));
			String year2				= checkForNull(req.getParameter("year2"));
			String error				= "";
			HashMap hashData = new HashMap();
			hashData.put("facilityId",facilityId);
			hashData.put("patientid1",patientid1);
			hashData.put("patientid2",patientid2);
			hashData.put("encounterid1",eid1);
			hashData.put("encounterid2",eid2);
			hashData.put("practitioner_id1",practitioner_id1);
			hashData.put("practitioner_id2",practitioner_id2);
			hashData.put("specialty_code1",checkForNull(req.getParameter("specialty_code1")));
			hashData.put("specialty_code2",checkForNull(req.getParameter("specialty_code2")));
			hashData.put("nursing_unit_type1",checkForNull(req.getParameter("nursing_unit_type1")));
			hashData.put("nursing_unit_type2",checkForNull(req.getParameter("nursing_unit_type2")));
			hashData.put("admission_date_time1",checkForNull(req.getParameter("admission_date_time1")));
			hashData.put("admission_date_time2",checkForNull(req.getParameter("admission_date_time2")));
			hashData.put("nursing_unit_code1",nursing_unit_code1);
			hashData.put("nursing_unit_code2",nursing_unit_code2);
			hashData.put("room_num1",checkForNull(req.getParameter("room_no1")));
			hashData.put("room_num2",checkForNull(req.getParameter("room_no2")));
			hashData.put("bed_num1",checkForNull(req.getParameter("bed_no1")));
			hashData.put("bed_num2",checkForNull(req.getParameter("bed_no2")));
			hashData.put("service_code1",checkForNull(req.getParameter("service_code1")));
			hashData.put("service_code2",checkForNull(req.getParameter("service_code2")));
			hashData.put("bed_type_code1",checkForNull(req.getParameter("bed_type_code1")));
			hashData.put("bed_type_code2",checkForNull(req.getParameter("bed_type_code2")));
			hashData.put("bed_class_code1",checkForNull(req.getParameter("bed_class_code1")));
			hashData.put("bed_class_code2",checkForNull(req.getParameter("bed_class_code1")));
			hashData.put("team_id1",checkForNull(req.getParameter("team_id1")));
			hashData.put("team_id2",checkForNull(req.getParameter("team_id2")));
			hashData.put("client_ip_address",p.getProperty("client_ip_address"));
			hashData.put("hid_gender1",checkForNull(req.getParameter("hid_gender1")));
			hashData.put("hid_gender2",checkForNull(req.getParameter("hid_gender2")));			
			hashData.put("swap_contact_reason",checkForNull(req.getParameter("swap_contact_reason")));
			hashData.put("srl_no",srl_no);
			hashData.put("bl_interfaced_yn",bl_interfaced_yn);
			hashData.put("bl_operational",bl_operational);
			hashData.put("patient_class1",patient_class1);
			hashData.put("patient_class2",patient_class2);
			hashData.put("mother_bed_status1",mother_bed_status1);
			hashData.put("mother_bed_status2",mother_bed_status2);
			hashData.put("transfer_wo_delink_yn",checkForNull(req.getParameter("transfer_wo_delink_yn"),"N"));//Added for the CRF - HSA-CRF-0035

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPSwapPatientBed",IPSwapPatientBedHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashData;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashData.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertIPSwapPatientBed",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			results.clear();
			hashData.clear();
			
			
			if(!inserted)
			{
				if(error.indexOf("<br>")!=-1)
						error = error.substring(0,error.indexOf("<br>"));
			}

			if(inserted)
			{
				if(error.indexOf("<br>")!=-1)
				error = error.substring(0,error.indexOf("<br>"));
				HashMap htRepResults = new HashMap();
				HashMap htRepResults2 = new HashMap();
				htRepResults = onlineReports(req,eid1,nursing_unit_code1,patientid1,facilityId,locale,year1);


				doOnlineReports(eid1, htRepResults);

				htRepResults2 = onlineReports(req,eid2,nursing_unit_code2,patientid2,facilityId,locale,year2);

		

				doOnlineReports( eid2, htRepResults2);

				htRepResults.clear();
				htRepResults2.clear();

				out.print("<script>alert('"+error+"')</script>");
				out.print("<script>parent.window.close();</script>");
			}
			else
			{
				out.println("<script>alert('"+error+"');</script>");
				out.print("<script>parent.window.close();</script>");
			}
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
		
	private void doOnlineReports(String eid, HashMap reportResults) throws ServletException, IOException, SQLException
	{        
		
		StringBuffer htmlFor = new StringBuffer();
		String reportParamNames		= (String)reportResults.get("reportParamNames");
		String reportParamValues	= (String)reportResults.get("reportParamValues");
		String sqlString			= (String)reportResults.get("sqlString");
		String clinic_type			= (String)reportResults.get("clinictype");
		String nursing_unit_code	= (String)reportResults.get("cliniccode");
	   	
		reportResults.clear();

		htmlFor.append( " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append( "</head><body class='message'>");
		htmlFor.append( "<script language = 'JavaScript'>" );
		htmlFor.append( "  var dialogHeight    = '25' ;");
		htmlFor.append(  " var dialogWidth = '65' ;");
		htmlFor.append(  "var dialogTop = 58;" );
		htmlFor.append( "  var arguments =   ''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append( "  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=SWAP_PATIENT_BEDS&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+eid+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append( "  retVal            =   window.showModalDialog(getUrl,arguments,features); ");
		htmlFor.append( " </script>" );

		out.println(htmlFor.toString());
		out.println("</body></html>");
		
	}

	public HashMap onlineReports(HttpServletRequest req, String eid, String nursing_unit_code,String p_patient_id, String facilityId, String locale,String year) throws ServletException, IOException, SQLException
	{

		HashMap reportResults = new HashMap();
		String sqlString = "";		
		String clinic_type = "N";
		
		Connection  con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String wristBandLbl = "";
		try
		{
			con = ConnectionManager.getConnection(req);
			int n_Age = 0;
			//String age = "";
			/*
			String wristBandSql = "select calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year from MP_PATIENT where patient_id = '"+p_patient_id+"'";

			if(rset!=null) rset.close();
			pstmt = con.prepareStatement(wristBandSql);
			rset = pstmt.executeQuery();

			if (rset != null && rset.next())
				age = checkForNull(rset.getString("year"));
			*/
			n_Age = Integer.parseInt(year);
			if(n_Age <= 2)
				wristBandLbl = "IPBWBLBL";
			else
				wristBandLbl = "IPBINWBL";

		}catch(Exception repEx)
		{
			repEx.printStackTrace();
		}
		finally
		{
			try
			{
				if(rset!=null)    rset.close();
				if(pstmt!=null) pstmt.close();
				if(con != null)  ConnectionManager.returnConnection(con,req);
			}
			catch(Exception e){e.printStackTrace();}
		}
		
		sqlString = " select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, SM_REPORT_LANG_VW b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and b.language_id ='"+locale+"' and a.print_on_conform_transfer_yn='Y' and a.nursing_unit_code ='"+nursing_unit_code+"' and a.report_id = b.report_id and a.report_id not in ('"+wristBandLbl+"') order by 2 ";

		String gen_file_no = "";
		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_file_no";
		String reportParamValues = ""+eid+","+nursing_unit_code+","+clinic_type+","+p_patient_id+","+gen_file_no+"";

		reportResults.put("reportParamNames",reportParamNames);
		reportResults.put("reportParamValues",reportParamValues);
		reportResults.put("sqlString",sqlString);
		reportResults.put("clinictype",clinic_type);
		reportResults.put("cliniccode",nursing_unit_code);
		reportResults.put("p_patient_id",p_patient_id);
		reportResults.put("gen_file_no",gen_file_no);
		return reportResults;

	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
