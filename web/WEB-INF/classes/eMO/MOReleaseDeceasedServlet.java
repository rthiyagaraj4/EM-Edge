/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eMO.ReleaseDeceased.*;
import java.sql.*;
import java.util.Date;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;


public class MOReleaseDeceasedServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
String expyn="";
String bodreldate="";
String unclaimed_body_yn="";
// java.sql.Date iss_date_d;
String locale = "";
String regno ="";
java.util.Properties p;
//String storagelocationcode;
//Timestamp receiveTimestamp =null;
String facilityId ;
String client_ip_address;
//String serviceURL;

//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/mm/yyyy" ) ;

public void init(ServletConfig config) throws ServletException
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
 throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	locale = p.getProperty("LOCALE");

	//serviceURL=(String) session.getValue("serviceURL");
	
      
	try
	{
		this.out = res.getWriter();
		String operation = "MODIFY";
			
		if ( operation.equals("MODIFY"))
		updateReleaseDeceased(req, res);
		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			res.setContentType("text/html;charset=UTF-8");
			
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

       		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
	}


	private void updateReleaseDeceased(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{	String s = p.getProperty("login_user");
            String s2 = s;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
			String bodyrelby = req.getParameter("bodrelby")==null?"":req.getParameter("bodrelby");
			String police_officer="";
			String police_station="";
			String rank="";
			String burial_issued_yn="";
			String burial_issued_dtime="";
            String CLAIMANT_TYPE="";
			String CLAIMANT_TYPE_CODE="";
			String RELATIONSHIP=""; 
			String NAME="";
			String JOB_TITLE="";  
			String ADD_LINE1=""; 
			String ADD_LINE2="";
			String ADD_LINE3="";
			String ADD_LINE4="";
			String ZIP_CODE="";
			String COUNTRY_CODE=""; 
			String TELEPHONE_OFF ="";
			String TELEPHONE_RES="";
			String res_town_code="";
            String res_area_code="";
            String region_code ="";

			String EMAIL_ID ="";
			String MOB_TEL_NO="";
			String NAT_ID_NO ="";
			String ORGANIZATION_NAME="";  
            String PATIENT_EMPLOYEE_ID=""; 

			//Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
			String PASSPORT_NO="";
			String OTHER_IDENTIFICATION="";

            String RELEASE_TO_FACILITY=""; //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg			
			String reason_desc=""; //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
			
			String claim_date_time="";// Added by Santhosh for ML-MMOH-CRF-1948
			
			
			expyn	               = req.getParameter("expyn");
			bodreldate	       = req.getParameter("bodreldate");
			regno	               = req.getParameter("patient_id");
    		if(expyn == null)expyn = "N";
			if(regno == null)regno = "";
			if(bodreldate == null)bodreldate = "";

			if(bodreldate!=null && !bodreldate.equals(""))
				bodreldate = DateUtils.convertDate(bodreldate,"DMYHM",locale,"en");
			police_officer=req.getParameter("police_officer")==null?"":req.getParameter("police_officer");
			police_station=req.getParameter("police_station")==null?"":req.getParameter("police_station");
			claim_date_time = req.getParameter("claimdatetime")==null?"":req.getParameter("claimdatetime");
			rank=req.getParameter("rank")== null?"":req.getParameter("rank");
			burial_issued_yn=req.getParameter("burial_issued_yn")== null?"N":req.getParameter("burial_issued_yn");
			burial_issued_dtime=req.getParameter("burial_dtime")==null?"":req.getParameter("burial_dtime");
			if(burial_issued_dtime!=null && !burial_issued_dtime.equals(""))
				burial_issued_dtime = DateUtils.convertDate(burial_issued_dtime,"DMYHM",locale,"en");


            
             CLAIMANT_TYPE              =checkForNull(req.getParameter("CLAIMANT_TYPE"));   
			 CLAIMANT_TYPE_CODE         =checkForNull(req.getParameter("CLAIMANT_TYPE_CODE"));   
			 RELATIONSHIP               =checkForNull(req.getParameter("RELATIONSHIP"));    
			 NAME                       =checkForNull(req.getParameter("NAME"));   
			 JOB_TITLE                  =checkForNull(req.getParameter("JOB_TITLE"));     
			 ADD_LINE1                  =checkForNull(req.getParameter("addr_line_1"));    
			 ADD_LINE2                  =checkForNull(req.getParameter("addr_line_2"));   
			 ADD_LINE3                  =checkForNull(req.getParameter("addr_line_3"));   
			 ADD_LINE4                  =checkForNull(req.getParameter("addr_line_4"));   
			// ZIP_CODE                   =checkForNull(req.getParameter("ZIP_CODE"));  
			 ZIP_CODE                   =checkForNull(req.getParameter("m_postal_code"));   
			 COUNTRY_CODE               =checkForNull(req.getParameter("COUNTRY_CODE"));    
			 TELEPHONE_OFF              =checkForNull(req.getParameter("TELEPHONE_OFF"));   
			 TELEPHONE_RES              =checkForNull(req.getParameter("TELEPHONE_RES"));   
			// res_town_code              = checkForNull(req.getParameter("town1"));   
			res_town_code              = checkForNull(req.getParameter("m_town"));   
            // res_area_code              = checkForNull(req.getParameter("area1"));  
			res_area_code              = checkForNull(req.getParameter("m_area"));  
             //region_code                = checkForNull(req.getParameter("region1")); 
			 region_code                = checkForNull(req.getParameter("m_region"));  
			
			 EMAIL_ID                   =checkForNull(req.getParameter("EMAIL_ID"));   
			 MOB_TEL_NO                 =checkForNull(req.getParameter("MOB_TEL_NO"));   
			 NAT_ID_NO                  =checkForNull(req.getParameter("NAT_ID_NO"));   
			 ORGANIZATION_NAME          =checkForNull(req.getParameter("ORGANIZATION_NAME"));     
			 PATIENT_EMPLOYEE_ID        =checkForNull(req.getParameter("PATIENT_EMPLOYEE_ID")); 
			 
			 //Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
			 PASSPORT_NO				=checkForNull(req.getParameter("PASSPORT_NO")); 
			 OTHER_IDENTIFICATION       =checkForNull(req.getParameter("OTHER_IDENTIFICATION")); 

             unclaimed_body_yn          =req.getParameter("unclaimed_body_yn")==null?"N":req.getParameter("unclaimed_body_yn");   
             RELEASE_TO_FACILITY		=checkForNull(req.getParameter("RELEASE_TO_FACILITY")); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
			 reason_desc		=checkForNull(req.getParameter("reason_desc")); //Added Against Bru-HIMS-CRF-366 [IN-039612]
			
			HashMap tabdata=new HashMap();
			
			 if(!(bodreldate.equals("")))
    		{
			tabdata.put("RELEASE_BODY_DATE",bodreldate);		
		 	}
	 		else
			{
			tabdata.put("RELEASE_BODY_DATE"," ");
			}
			tabdata.put("RELEASE_BODY_YN","Y");		
			tabdata.put("EXPORTATION_REQD_YN",expyn);
			tabdata.put("modified_by_id", s2);
            tabdata.put("modified_facility_id", s5);
            tabdata.put("modified_at_ws_no", s7);
    		tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("REGISTRATION_NO",regno);
			tabdata.put("bodyrelby",bodyrelby);
			
			tabdata.put("police_officer",police_officer);
			tabdata.put("police_station",police_station);
			tabdata.put("rank",rank);
			tabdata.put("burial_issued_yn",burial_issued_yn);
			tabdata.put("burial_issued_dtime",burial_issued_dtime);

			tabdata.put("CLAIMANT_TYPE",CLAIMANT_TYPE);
			tabdata.put("CLAIMANT_TYPE_CODE",CLAIMANT_TYPE_CODE);
			tabdata.put("RELATIONSHIP",RELATIONSHIP);
			tabdata.put("NAME",NAME);
			tabdata.put("JOB_TITLE",JOB_TITLE);
			tabdata.put("ADD_LINE1",ADD_LINE1);
			tabdata.put("ADD_LINE2",ADD_LINE2);
			tabdata.put("ADD_LINE3",ADD_LINE3);
			tabdata.put("ADD_LINE4",ADD_LINE4);
			tabdata.put("ZIP_CODE",ZIP_CODE);
			tabdata.put("res_town_code",res_town_code);
	    	tabdata.put("res_area_code",res_area_code);
	    	tabdata.put("region_code",region_code);
	
			tabdata.put("COUNTRY_CODE",COUNTRY_CODE);
			tabdata.put("TELEPHONE_OFF",TELEPHONE_OFF);
			tabdata.put("TELEPHONE_RES",TELEPHONE_RES);
			tabdata.put("EMAIL_ID",EMAIL_ID);
			tabdata.put("MOB_TEL_NO",MOB_TEL_NO);
			tabdata.put("NAT_ID_NO",NAT_ID_NO);
			tabdata.put("ORGANIZATION_NAME",ORGANIZATION_NAME);
			tabdata.put("PATIENT_EMPLOYEE_ID",PATIENT_EMPLOYEE_ID);

			//Added by Ashwini on 02-Aug-2017 for ML-MMOH-CRF-0743
			tabdata.put("PASSPORT_NO",PASSPORT_NO);
			tabdata.put("OTHER_IDENTIFICATION",OTHER_IDENTIFICATION);

			tabdata.put("unclaimed_body_yn",unclaimed_body_yn);
			tabdata.put("RELEASE_TO_FACILITY",RELEASE_TO_FACILITY); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg			
			tabdata.put("reason_desc",reason_desc); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
			tabdata.put("CLAIM_DATE_TIME",claim_date_time);// Added by Santhosh for ML-MMOH-CRF-1948

			 boolean local_ejbs = false;
            if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
            Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReleaseDeceased",MOReleaseDeceasedHome.class,local_ejbs);
            Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
            Object argArray[] = new Object[2];
            argArray[0] = p;
            argArray[1] = tabdata;
            Class [] paramArray = new Class[2];
             paramArray[0] = p.getClass();
             paramArray[1] = tabdata.getClass();
             java.util.HashMap results=new HashMap();
             results =(HashMap)busObj.getClass().getMethod("updateReleaseDeceased", paramArray).invoke(busObj, argArray); 
             boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		     String error = (String) results.get("error") ;
		     String error_value  = "0" ;
		     if ( inserted )
			 { error_value = "1" ;
    		
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value=" + error_value );
					   
	          }
		      else
		       { error_value = "0" ;
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value=" + error_value );
		       }
						
					
	tabdata.clear();
	results.clear();
	}
catch(Exception e)
{
	e.printStackTrace();
}
	}

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
}
