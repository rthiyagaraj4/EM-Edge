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


public class MORevertReleasedServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
String bodreldate="";
String unclaimed_body_yn="";
// java.sql.Date iss_date_d;
String locale = "";
String reg_no ="";
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
		String operation = "REVERT";
			
		if (operation.equals("REVERT"))
		RevertReleased(req, res);
		}
		catch (Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
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


	private void RevertReleased(HttpServletRequest req, HttpServletResponse res)
	{
		PreparedStatement pstmt = null;	 
		ResultSet rset = null;
		int rs1 = 0;
		Connection con = null;
		
		try
		{	
			 con  = ConnectionManager.getConnection(req);
			//String s = p.getProperty("login_user");
          //  String s2 = s;
           // String s4 = facilityId;
           // String s5 = s4;
            //String s6 = client_ip_address;
           // String s7 = s6;
			//String bodyrelby = req.getParameter("bodrelby")==null?"":req.getParameter("bodrelby");
			String modifiedById	= p.getProperty( "login_user" ) ;
			String modifiedWorkstation	=client_ip_address;
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
            String mo_area_code ="";
            String bed_no ="";
            String rfid_tag_no ="";
            String revert_release_reason ="";
            String revert_remarks ="";
            String pateint_id ="";
			boolean result = true;
			String EMAIL_ID ="";
			String MOB_TEL_NO="";
			String NAT_ID_NO ="";
			String ORGANIZATION_NAME="";  
            String PATIENT_EMPLOYEE_ID=""; 
            String RELEASE_TO_FACILITY=""; //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
			String reason_desc=""; //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
			
			bodreldate	       = req.getParameter("bodreldate");
			reg_no	               = req.getParameter("reg_no");
			if(reg_no == null)reg_no = "";
			if(bodreldate == null)bodreldate = "";

			if(bodreldate!=null && !bodreldate.equals(""))
				bodreldate = DateUtils.convertDate(bodreldate,"DMYHM",locale,"en");
			police_officer=req.getParameter("police_officer")==null?"":req.getParameter("police_officer");
			police_station=req.getParameter("police_station")==null?"":req.getParameter("police_station");
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
	
			 ZIP_CODE                   =checkForNull(req.getParameter("m_postal_code"));   
			 COUNTRY_CODE               =checkForNull(req.getParameter("COUNTRY_CODE"));    
			 TELEPHONE_OFF              =checkForNull(req.getParameter("TELEPHONE_OFF"));   
			 TELEPHONE_RES              =checkForNull(req.getParameter("TELEPHONE_RES"));   
			
			res_town_code              = checkForNull(req.getParameter("m_town"));   
        
			res_area_code              = checkForNull(req.getParameter("m_area"));  
         
			 region_code                = checkForNull(req.getParameter("m_region"));  
			
			 EMAIL_ID                   =checkForNull(req.getParameter("EMAIL_ID"));   
			 MOB_TEL_NO                 =checkForNull(req.getParameter("MOB_TEL_NO"));   
			 NAT_ID_NO                  =checkForNull(req.getParameter("NAT_ID_NO"));   
			 ORGANIZATION_NAME          =checkForNull(req.getParameter("ORGANIZATION_NAME"));     
			 PATIENT_EMPLOYEE_ID        =checkForNull(req.getParameter("PATIENT_EMPLOYEE_ID"));   
             unclaimed_body_yn          =req.getParameter("unclaimed_body_yn")==null?"N":req.getParameter("unclaimed_body_yn");   
            mo_area_code          =req.getParameter("mo_area_code")==null?"":req.getParameter("mo_area_code");   
             bed_no          =req.getParameter("bed_no")==null?"":req.getParameter("bed_no");   
             pateint_id          =req.getParameter("pateint_id")==null?"":req.getParameter("pateint_id");   
             rfid_tag_no          =req.getParameter("rfid_tag_no")==null?"":req.getParameter("rfid_tag_no");   
             revert_release_reason          =req.getParameter("revert_release_reason")==null?"":req.getParameter("revert_release_reason");   
             revert_remarks          =req.getParameter("revert_remarks")==null?"":req.getParameter("revert_remarks");   
             RELEASE_TO_FACILITY              =checkForNull(req.getParameter("RELEASE_TO_FACILITY")); //Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg			 
			 reason_desc              =checkForNull(req.getParameter("reason_desc")); //Added this CRF Bru-HIMS-CRF-366 [IN-039612]
			 
			 String sqlChk = "select occupying_patient_id,registration_no from mo_bed_for_area where area_code = ? and bed_no = ? and facility_id = ?";
			 String occupying_patient_id = "";
			 String new_reg_no = "";
			 String rfid_patient_id = "";
			 String rfid_reg_no = "";
			 
			 
			 

			 pstmt	= con.prepareStatement(sqlChk);
			 pstmt.setString(1,mo_area_code) ;	   
			 pstmt.setString(2,bed_no) ;
			 pstmt.setString(3,facilityId) ;
			 rset =  pstmt.executeQuery();
			
			if(rset!=null && rset.next()){
				occupying_patient_id = rset.getString("occupying_patient_id")==null?"":rset.getString("occupying_patient_id");
				new_reg_no = rset.getString("registration_no")==null?"":rset.getString("registration_no");
			}
				
				

			if(!rfid_tag_no.equals("")){
			//Maheshwaran k modified the Query for the Bru-HIMS-CRF-369 -IN039615 as on 29/08/2013
				 String sqlRfidChk = "select occupying_patient_id,registration_no from xt_rfid_tag where rfid_tag_num = ? ";
				

				  if (rset != null)rset.close();
				  if (pstmt != null)pstmt.close();

				 pstmt	= con.prepareStatement(sqlRfidChk);
				 pstmt.setString(1,rfid_tag_no) ;	   				 
				 //pstmt.setString(2,facilityId) ;//Maheshwaran k commented for the Bru-HIMS-CRF-369 -IN039615 as on 29/08/2013
				 rset =  pstmt.executeQuery();
				
				if(rset!=null && rset.next()){
					rfid_patient_id = rset.getString("occupying_patient_id")==null?"":rset.getString("occupying_patient_id");
					rfid_reg_no = rset.getString("registration_no")==null?"":rset.getString("registration_no");
				}
					
					

			}
		StringBuffer sqlBuf1 = new StringBuffer();
	    sqlBuf1.append("UPDATE mo_mortuary_regn SET release_body_date = NULL,released_by = NULL,burial_permit_issued_yn = 'N',burial_permit_issue_date = NULL ,REVERT_REASON_CODE=?, REVERT_REMARKS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  ");
		if(!occupying_patient_id.equals("") && !new_reg_no.equals("")){
			sqlBuf1.append(", bed_no = NULL , PREV_BED_NO = '"+bed_no+"' ");
		}
		if(!rfid_patient_id.equals("") && !rfid_reg_no.equals("")){
			sqlBuf1.append(", rfid_tag_num = NULL , PREV_RFID_TAG_NUM = '"+rfid_tag_no+"' ");
		}
		sqlBuf1.append(" WHERE registration_no = ? AND facility_id = ? and release_body_date IS NOT NULL AND released_by IS NOT NULL ");

	    if (rset != null)rset.close();
		if (pstmt != null)pstmt.close();
		pstmt	= con.prepareStatement(sqlBuf1.toString());
	    pstmt.setString(1,revert_release_reason) ;	   
	    pstmt.setString(2,revert_remarks) ;
        pstmt.setString(3,modifiedById) ;
	    pstmt.setString(4,modifiedWorkstation) ;
	    pstmt.setString(5,facilityId) ;		
	    pstmt.setString(6,reg_no) ;	   
	    pstmt.setString(7,facilityId) ;
	  
		
	    rs1 =  pstmt.executeUpdate();
	
		if(rs1 > 0)
			result = true;
		else
			result = false;
	
	if(result && occupying_patient_id.equals("") && new_reg_no.equals("")){
		
		StringBuffer sqlBuf = new StringBuffer();
	    sqlBuf.append("update mo_bed_for_area set occupying_patient_id=?,registration_no=?,MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where area_code=? and bed_no=? and facility_id = ? ");
	
		if (pstmt != null)pstmt.close();
		pstmt	= con.prepareStatement(sqlBuf.toString());
	    pstmt.setString(1,pateint_id) ;	   
	    pstmt.setString(2,reg_no) ;
	    pstmt.setString(3,modifiedById) ;
	    pstmt.setString(4,modifiedWorkstation) ;
	    pstmt.setString(5,facilityId) ;
	    pstmt.setString(6,mo_area_code) ;	   
	    pstmt.setString(7,bed_no) ; 			
	    pstmt.setString(8,facilityId) ;  			
	    rs1 =  pstmt.executeUpdate();	
		}

	
			
			String error_value  = "0" ;
			String error  = "" ;
		     if(result){ 
				 error_value = "1" ;
				 con.commit();
    			 java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
				 error = (String) message.get("message");
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value=" + error_value );					   
	          }else{
				  error_value = "0" ;
				  res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value=" + error_value );
		       }
			   if (pstmt != null){
				pstmt.close();
				}
						
					
 
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con,p);
		
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
