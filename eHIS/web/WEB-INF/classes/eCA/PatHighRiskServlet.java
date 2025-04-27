/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History     	Name        Description
-----------------------------------------------------------------------
?           100           		?           created

15/12/2012  IN030460 			Karthi L	CRF-019 Update PR_Diagnosis table when we modify any patient high risk data when the close date 
											is available with occursrlno, termsetid and term code.
26/12/2012	IN036904			Karthi L	After we close the associated High Risk condition, the defined sensitive Diagnosis should changed to Resolved
											status in Record Diagnosis is function. Currently it is showing Inerror status
02/01/2013  IN037071			Karthi L	When we try to close one of the High Risk Condition, both the High Risk Conditions are getting  closed		
20/01/2012	CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
19/06/2023  46480       krishna pranay       19/06/2023         Ramesh Goli     COMMON-ICN-0131
-----------------------------------------------------------------------
*/ 
package eCA;

import eCA.PatHighRisk.* ;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager; // added for CRF-019 - 30460
 public class PatHighRiskServlet extends javax.servlet.http.HttpServlet{

//				String facilityid ;
				//java.util.HashMap env;
				//String serviceURL;
//				String objectName;
	Connection con;
public void init(ServletConfig config) throws ServletException{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {

	PrintWriter out;
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
	

/***********************changes made by Ankur 20/02/03*******************************/
    //this.client_ip_address = req.getRemoteAddr() ;
//	client_ip_address = p.getProperty("client_ip_address");
/*****************************ends here**********************************************/

	try {
			out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )  insertPatHighRisk(req, res,out,session);
			if ( operation.equals("modify"))  modifyPatHighRisk(req, res,out,session);
	}
	catch (Exception e)	{
		//out.println(e.toString());
		e.printStackTrace();
	}
}


private void modifyPatHighRisk(HttpServletRequest req, HttpServletResponse res,PrintWriter out,HttpSession session)
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String facilityId = (String)session.getValue("facility_id");
	String highriskcode;
	String onsetdate;
	String closedate;
	String patientid;
	String practid;
	String locncode;
	String locntype;
	String eid;
	String remarks;
	String temp_encounterid;
	long encounterid = 0L;
	String client_ip_address = p.getProperty("client_ip_address");
	String locale				= (String) p.getProperty("LOCALE");

		String termSetId = ""; // added for CRF - 30460
		String termCode = ""; // added for CRF-019 - 30460
		String occurSrlNo = ""; // added for CRF-019 - 30460
		String srlno = ""; // added for IN037071
		int ocrSrlNo;
		String p_called_from_widget = "";  //CHL-CRF [IN035950]
		//int getSrlNo; // added for IN037071//Checkstyle
	try 
	{
		
		highriskcode = req.getParameter("high_risk_code");
		onsetdate = req.getParameter("onset_date");


		closedate = req.getParameter("close_date")==null?"":req.getParameter("close_date");
		
		remarks=req.getParameter("remarks");
		patientid = req.getParameter("P_patient_id");
		practid = req.getParameter("P_practitioner_id");
		if((practid==null) || (practid.equals("null")))practid="";
		//facilityid = req.getParameter("P_facility_id");
		locncode = req.getParameter("P_locn_code");
		if((locncode==null) || (locncode.equals("null")))locncode="";
		locntype = req.getParameter("P_locn_type");
		if((locntype==null) || (locntype.equals("null")))locntype="";
		eid = req.getParameter("P_encounter_id");
			termSetId = req.getParameter("termSetId");  // added for CRF - 30460
			termCode = req.getParameter("termCode"); // added for CRF - 30460
			occurSrlNo = req.getParameter("occurSrlNo"); // added for CRF - 30460
			ocrSrlNo = Integer.parseInt(occurSrlNo); // added for CRF - 30460
			srlno = req.getParameter("srlno"); // IN037071
		p_called_from_widget	= req.getParameter("p_called_from_widget")==null?"":req.getParameter("p_called_from_widget"); //CHL-CRF[IN035950]
		if   (eid.equals("") || eid.length() == 4)
					 temp_encounterid="";
				 else
	     	 encounterid = Long.parseLong(eid);
			 temp_encounterid=encounterid+"";	

		onsetdate	= com.ehis.util.DateUtils.convertDate(onsetdate,"DMY",locale,"en");
		closedate	= com.ehis.util.DateUtils.convertDate(closedate,"DMY",locale,"en");

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatHighRiskManager",PatHighRiskManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[14];
		argArray[0] = p;
		argArray[1] = patientid;
		argArray[2] = highriskcode;
		argArray[3] = closedate;
		argArray[4] = remarks;
		argArray[5] = practid;
		argArray[6] = facilityId;
		argArray[7] = locncode;
		argArray[8] = locntype;
		argArray[9] = temp_encounterid;
		argArray[10] = client_ip_address;
		argArray[11] = facilityId;
		argArray[12] = locale;
		argArray[13] = srlno; // IN037071

		Class [] paramArray = new Class[14];
		paramArray[0] = p.getClass();
		paramArray[1] = patientid.getClass();
		paramArray[2] = highriskcode.getClass();
		paramArray[3] = closedate.getClass();
		paramArray[4] = remarks.getClass();
		paramArray[5] = practid.getClass();
		paramArray[6] = facilityId.getClass();
		paramArray[7] = locncode.getClass();
		paramArray[8] = locntype.getClass();
		paramArray[9] = temp_encounterid.getClass();
		paramArray[10] = client_ip_address.getClass();
		paramArray[11] = facilityId.getClass();
		paramArray[12] = locale.getClass();
		paramArray[13] = srlno.getClass(); // IN037071

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updatePatHighRisk",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted )
				{
						if((termSetId != null && termSetId != "") && (termCode != null && termCode != "") && ocrSrlNo > 0) //added for CRF-019 - 030460 - Start
						{
							updateHighRiskDiagnosis(req, session);
							
						}	// END
					error_value = "1" ;
					results.clear();
					res.sendRedirect("../eCA/jsp/PatHighRiskErrorPage.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value +"&p_called_from_widget=" +p_called_from_widget );
//		out.println( "status-----------"+inserted+"   suresh error-------------"+error);
				}
				else
				{
					error = (String) results.get("error") ;
					results.clear();
					res.sendRedirect("../eCA/jsp/PatHighRiskErrorPage.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") );
	//	out.println( "status-----------"+inserted+"   suresh error-------------"+error);
				}
	//			res.sendRedirect("../eCA/jsp/PatHighRiskErrorPage.jsp?err_num=" + java.net.URLEncoder.encode( error ) );


} catch ( Exception e ) {
			//out.println(e.getMessage());
			
			//out.println(e.toString()+encounterid);//common-icn-0181
			e.printStackTrace();
   }
}


private void insertPatHighRisk(HttpServletRequest req, HttpServletResponse res,PrintWriter out,HttpSession session)
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String facilityId = (String)session.getValue("facility_id");
	String highriskcode;
	String onsetdate;
	String patientid;
	String practid;
	String locncode;
	String locntype;
	String eid;
	String remarks;
	String temp_encounterid;
	long encounterid = 0L;
	String client_ip_address = p.getProperty("client_ip_address");
	String locale				= (String) p.getProperty("LOCALE");
	String date_type = "";
	String p_called_from_widget = "";  //CHL-CRF [IN035950]
	try
	{
	
	highriskcode = req.getParameter("high_risk_code");

	onsetdate = req.getParameter("onset_date");
	
	remarks=req.getParameter("remarks");
	patientid = req.getParameter("P_patient_id");
	date_type = req.getParameter("date_type1") == null ? "" : req.getParameter("date_type1");
	
	practid = req.getParameter("P_practitioner_id");
	if((practid==null) || (practid.equals("null")))practid="";
	locncode = req.getParameter("P_locn_code");
	if((locncode==null) || (locncode.equals("null")))locncode="";
	locntype = req.getParameter("P_locn_type");
	if((locntype==null) || (locntype.equals("null")))locntype="";
	eid = req.getParameter("P_encounter_id");

	p_called_from_widget	= req.getParameter("p_called_from_widget")==null?"":req.getParameter("p_called_from_widget"); //CHL-CRF[IN035950]
	if   (eid.equals("")||(eid==null) || eid.length() == 4)
		temp_encounterid = "";
	 else
	     	 encounterid = Long.parseLong(eid);
			 temp_encounterid=encounterid+"";	

		onsetdate	= com.ehis.util.DateUtils.convertDate(onsetdate,"DMY",locale,"en");

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatHighRiskManager",PatHighRiskManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[14];
		argArray[0] = p;
		argArray[1] = patientid;
		argArray[2] = highriskcode;
		argArray[3] = onsetdate;
		argArray[4] = remarks ;
		argArray[5] = practid;
		argArray[6] = facilityId;
		argArray[7] = locncode;
		argArray[8] = locntype;
		argArray[9] = temp_encounterid;
		argArray[10] = client_ip_address;
		argArray[11] = facilityId;
		argArray[12] = locale;
		argArray[13] = date_type;
		
		

		Class [] paramArray = new Class[14];
		paramArray[0] = p.getClass();
		paramArray[1] = patientid.getClass();
		paramArray[2] = highriskcode.getClass();
		paramArray[3] = onsetdate.getClass();
		paramArray[4] = remarks.getClass();
		paramArray[5] = practid.getClass();
		paramArray[6] = facilityId.getClass();
		paramArray[7] = locncode.getClass();
		paramArray[8] = locntype.getClass();
		paramArray[9] = temp_encounterid.getClass();
		paramArray[10] = client_ip_address.getClass();
		paramArray[11] = facilityId.getClass();
		paramArray[12] = locale.getClass();
		paramArray[13] = date_type.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertPatHighRisk",
		paramArray)).invoke(busObj,argArray);
	
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					String error = (String) results.get("error") ;
					String error_value = "0" ;

					if ( inserted )
					{
						error_value = "1" ;
						results.clear();
						res.sendRedirect("../eCA/jsp/PatHighRiskErrorPage.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value +"&p_called_from_widget=" +p_called_from_widget);
					}
					else
					{
						error = (String) results.get("error") ;
						results.clear();
						res.sendRedirect("../eCA/jsp/PatHighRiskErrorPage.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") );
					}


} catch ( Exception e ) {
			//out.println(e.getMessage());
			
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
   }
}
	// New method added for CRF-019 - 030460
	public void updateHighRiskDiagnosis(HttpServletRequest req, HttpSession session)
	{
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId = (String)session.getValue("facility_id");


		String closedate = "";

		String patientid = "";
		//String practid = "";//Checkstyle
		String remarks = "";

		String locale	= (String) p.getProperty("LOCALE");
		String termSetId = "";
		String termCode = "";
		String occurSrlNo = "";
		PreparedStatement pstatement;
		String sql = "";
		int ocrSrlNo;
		String currStatus = "R"; //IN036904
		
		try
		{
			con=ConnectionManager.getConnection(p);
			try
			{
				sql = "UPDATE PR_DIAGNOSIS SET CURR_STATUS= ?, CURR_STATUS_DATE= to_date(?,'dd/mm/yyyy'), CURR_REMARKS= ?, MODIFIED_BY_ID= ?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO= ?, MODIFIED_FACILITY_ID= ? WHERE PATIENT_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND OCCUR_SRL_NO  = ?";
				
				String modifiedById = p.getProperty( "login_user" );
				closedate = req.getParameter("close")==null?"":req.getParameter("close");
				
				remarks=req.getParameter("remarks");
				patientid = req.getParameter("P_patient_id");
				String modified_worstation_id = p.getProperty("client_ip_address");
				termSetId = req.getParameter("termSetId");
				termCode = req.getParameter("termCode");
				occurSrlNo = req.getParameter("occurSrlNo");
				
				if(!locale.equalsIgnoreCase("en"))
				{
					closedate	= com.ehis.util.DateUtils.convertDate(closedate,"DMY",locale,"en");
				}	
				
				ocrSrlNo = Integer.parseInt(occurSrlNo);
				pstatement = con.prepareStatement(sql);
				
				pstatement.setString ( 1, currStatus) ;
				pstatement.setString ( 2, closedate) ;
				pstatement.setString ( 3, remarks) ;
				pstatement.setString ( 4, modifiedById) ;
				pstatement.setString ( 5, modified_worstation_id) ;
				pstatement.setString ( 6, facilityId) ;
				pstatement.setString ( 7, patientid) ;
				pstatement.setString ( 8, termSetId) ;
				pstatement.setString ( 9, termCode) ;
				pstatement.setInt ( 10, ocrSrlNo) ;
//				System.out.println(" BEFORE UPDATE STATEMENT ") ;
				pstatement.executeUpdate() ;//46480
				
				if(pstatement!=null)pstatement.close();//15950
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			try 
				{ 
					con.rollback(); 
				} 
				catch (Exception ee) {}
		}		
		finally 
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,p);
		}
		
	}
}
