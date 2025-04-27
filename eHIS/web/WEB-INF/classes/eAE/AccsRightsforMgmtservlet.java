/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*; 
import javax.servlet.http.*;
import javax.naming.*; 
import javax.rmi.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;

//import com.ehis.util.BundleMessage;
public class AccsRightsforMgmtservlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session; 
	Properties p;
	String client_ip_address;
	String  locale=	""; 

	boolean inserted		= false;
	String mode;  
	String practitioner_code= "";
	String second_triage_yn= "";
	String counsulation_yn= "";
	String reg_new_born_yn= ""; //Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
	String error_value  ="";
	String error  ="";
	//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	String for_admission_yn="N";
	String cancel_for_admission_yn="N";
	String modify_referral_yn="N";
	//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 ends-->
	
	int noOfRecords= 0;
	PreparedStatement pstmt = null;
	ResultSet resultSet 	= null;
    Connection con;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
		{
			 req.setCharacterEncoding("UTF-8");
		     res.setContentType("text/html;charset=UTF-8");
			 session = req.getSession(false);
			 
			 p = (java.util.Properties) session.getValue( "jdbc" ) ;
		     out=null;
			 locale	= p.getProperty("LOCALE");

			 con = ConnectionManager.getConnection(p);

	
		this.out = res.getWriter();
		try	{
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");
		    String addedById	   = p.getProperty( "login_user" ) ;
			String modifiedById    =   addedById;
			String modifiedBy_ws_no    =   client_ip_address;
			String modifiedBy_faci_Id    =   facilityId;
            noOfRecords = Integer.parseInt((String)req.getParameter("noOfRecords"));
            mode        = req.getParameter("mode");
			
		try{
			if(mode.equalsIgnoreCase("INSERT"))
			{
			//reg_new_born_yn Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				//<!--FOR_ADMISSION_YN,CANCEL_FOR_ADMISSION_YN,MODIFY_REFERRAL_YN Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
		    String sql = "insert into AE_ACCS_RIGHTS_BY_PRAC_TYPE (PRACT_TYPE,SEC_TRIAG_YN,CONS_YN,REG_NEW_BORN_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,FOR_ADMISSION_YN,CANCEL_FOR_ADMISSION_YN,MODIFY_REFERRAL_YN)values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
			for (int i=1;i<=noOfRecords; i++ )
			{
				practitioner_code="";
				second_triage_yn ="";
				counsulation_yn="";
				reg_new_born_yn="";

			  practitioner_code=req.getParameter("practitioner_code"+i);
			  second_triage_yn=req.getParameter("second_triage_yn"+i)==null?"N" :req.getParameter("second_triage_yn"+i) ;
			  counsulation_yn=req.getParameter("counsulation_yn"+i)==null?"N" :req.getParameter("counsulation_yn"+i) ;
			  reg_new_born_yn=req.getParameter("reg_new_born_yn"+i)==null?"N" :"Y" ;//Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			  
			//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
				for_admission_yn="";
				cancel_for_admission_yn="";
				modify_referral_yn="";
			    for_admission_yn=req.getParameter("for_admission"+i)==null?"N" :req.getParameter("for_admission"+i) ;
				cancel_for_admission_yn=req.getParameter("cancel_for_admission"+i)==null?"N" :req.getParameter("cancel_for_admission"+i) ;
				modify_referral_yn=req.getParameter("Modify_referral"+i)==null?"N" :req.getParameter("Modify_referral"+i) ;
				//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
				
			 int j=1;
			 pstmt.setString(j++,practitioner_code);
			 pstmt.setString(j++,second_triage_yn);
			 pstmt.setString(j++,counsulation_yn);
			 pstmt.setString(j++,reg_new_born_yn);//Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			 pstmt.setString(j++,addedById);
			 pstmt.setString(j++,client_ip_address);
			 pstmt.setString(j++,facilityId);
			 pstmt.setString(j++,modifiedById);
			 pstmt.setString(j++,modifiedBy_ws_no);
			 pstmt.setString(j++,modifiedBy_faci_Id);
			 pstmt.setString(j++,for_admission_yn);//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
			 pstmt.setString(j++,cancel_for_admission_yn);//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
			 pstmt.setString(j++,modify_referral_yn);//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
		     pstmt.addBatch();
			}
			int [] insertCounts = pstmt.executeBatch();	
			inserted = true;

			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
			error_value  = ((String) mesg.get("message"));
			
            con.commit();
			for (int k=0;k<insertCounts.length ;k++ ){
				if(insertCounts[k]<0  && insertCounts[k] != -2 ){
							inserted=false;
							break;
				}
			}
			mesg.clear();
		}
		else if(mode.equalsIgnoreCase("UPDATE"))
		{
			//reg_new_born_yn Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			//<!--FOR_ADMISSION_YN,CANCEL_FOR_ADMISSION_YN,MODIFY_REFERRAL_YN Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
			String sql = "update  AE_ACCS_RIGHTS_BY_PRAC_TYPE set SEC_TRIAG_YN=?,CONS_YN=?,reg_new_born_yn=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,FOR_ADMISSION_YN=?,CANCEL_FOR_ADMISSION_YN=?,MODIFY_REFERRAL_YN=? WHERE PRACT_TYPE=? ";
			pstmt = con.prepareStatement(sql);
           
			for (int i=1;i<=noOfRecords; i++ )
			{
				practitioner_code="";
				second_triage_yn ="";
				counsulation_yn="";
				reg_new_born_yn="";//Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]

			practitioner_code=req.getParameter("practitioner_code"+i);
			second_triage_yn=req.getParameter("second_triage_yn"+i)==null?"N" :req.getParameter("second_triage_yn"+i) ;
			counsulation_yn=req.getParameter("counsulation_yn"+i)==null?"N" :req.getParameter("counsulation_yn"+i) ;
			reg_new_born_yn=req.getParameter("reg_new_born_yn"+i)==null?"N" :"Y" ;//Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			
			//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
			for_admission_yn="";
			cancel_for_admission_yn="";
			modify_referral_yn="";
			for_admission_yn=req.getParameter("for_admission"+i)==null?"N" :req.getParameter("for_admission"+i) ;
			cancel_for_admission_yn=req.getParameter("cancel_for_admission"+i)==null?"N" :req.getParameter("cancel_for_admission"+i) ;
			modify_referral_yn=req.getParameter("Modify_referral"+i)==null?"N" :req.getParameter("Modify_referral"+i) ;
			//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 ends-->
			
			
			int j=1; 
			 pstmt.setString(j++,second_triage_yn);
			 pstmt.setString(j++,counsulation_yn);
			 pstmt.setString(j++,reg_new_born_yn);//Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			 pstmt.setString(j++,modifiedById);
			 pstmt.setString(j++,modifiedBy_ws_no);
			 pstmt.setString(j++,modifiedBy_faci_Id);
			 pstmt.setString(j++,for_admission_yn); //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
			 pstmt.setString(j++,cancel_for_admission_yn);//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
			 pstmt.setString(j++,modify_referral_yn); //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 -->
			 pstmt.setString(j++,practitioner_code);

		     pstmt.addBatch();
			}
			int [] UpdateCounts = pstmt.executeBatch();	
			inserted = true;
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
			
			
			error_value  = ((String) mesg.get("message"));
			
            con.commit();

			for (int k=0;k<UpdateCounts.length ;k++ ){
				if(UpdateCounts[k]<0  && UpdateCounts[k] != -2 ){
							inserted=false;
							break;
				}
			}

             mesg.clear();
		}

			if ( inserted )
			{
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+error_value+"&err_value=1");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error_value,"UTF-8" )+"&err_value=1");
			}
			else
			{
                res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" ));

			}
			

		}
		
				
		catch(Exception e) 
			{
			e.printStackTrace();
			inserted = false;
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();

			}
		}
	}



			
    catch(Exception e) 
	{
		e.printStackTrace();
	}
		finally
		{
			 try
            {
				     if (pstmt != null) pstmt.close();	
					 if(con != null)      ConnectionManager.returnConnection(con,p);
            }
               catch(java.lang.Exception exception1) 
				{
				   exception1.printStackTrace();
			    }	   	   
	       
  	    }

	
	}


}


