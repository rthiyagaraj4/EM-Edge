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
import webbeans.eCommon.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;


public class assignBedGIServlet extends HttpServlet implements SingleThreadModel{

PrintWriter out;
HttpSession session;
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null; 
PreparedStatement pstat	 = null;
ResultSet rs11 = null;
ResultSet rset11 = null;
boolean treatGenderProceed=false;
boolean pseudoBedProceed = true;
java.util.Properties p 		= null;
String client_ip_address="";
String user_id="";
//int rs=0;
//int rs1=0;
int recCount=0;
//StringBuffer sql1 = null;
StringBuffer sql2 = null;
StringBuffer sql3 = null;
StringBuffer sql4 = null;
StringBuffer sql11 = null;
StringBuffer sql22 = null;
StringBuffer sql33 = null;
StringBuffer sql44 = null;
StringBuffer msgSBuf = null;

String gender                           ="";
String treatgender	                    ="";
String facilityId			            ="";
String clinic_code			            ="";
String practitioner_id			        ="";
String encounter_id			            ="";
String treatment_area_code		        ="";
String bed_no				            ="";
String patient_id			            ="";
String service_code			            ="";
String pseudo_bed_yn	                ="";
String priority_zone	                ="";
String locale 							="";


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

public void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
	request.setCharacterEncoding("UTF-8");
    res.setContentType("text/html;charset=UTF-8");
	this.out = res.getWriter();
	try	{
			session 			= request.getSession(true);
			this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
 		    locale			    =   p.getProperty("LOCALE");
            con = ConnectionManager.getConnection(request);
	try{
			facilityId			= (String) session.getValue("facility_id");
			clinic_code			= request.getParameter("clinic_code");
			practitioner_id		= request.getParameter("practitioner_id");
			encounter_id		= request.getParameter("encounter_id");	
			treatment_area_code	= request.getParameter("treatment_area_code");
			bed_no				= request.getParameter("bed_no");
			patient_id			= request.getParameter("patient_id");
			service_code		= request.getParameter("service_code");
			pseudo_bed_yn	    = request.getParameter("pseudo_bed_yn");
			priority_zone	    = request.getParameter("priority_zone");
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			user_id	= (String)session.getValue("login_user") ;

			/* Monday, May 24, 2010 PE_Exe venkat S 
    		sql1 = new StringBuffer();
			sql1.append("select sex from mp_patient where patient_id=? ");
			pstmt1 = con.prepareStatement(sql1.toString());
			pstmt1.setString(1, patient_id) ;
		    rset11=pstmt1.executeQuery();
     		if(rset11!=null && rset11.next()){
			gender=rset11.getString("sex");
			}
		 if(rset11!=null) rset11.close();
		 if(pstmt1!=null) pstmt1.close();
		 if((sql1 != null) && (sql1.length() > 0))
			{	sql1.delete(0,sql1.length());
			}
*/

	     sql2 = new StringBuffer();
		 sql2.append("select gender,(select sex from mp_patient where patient_id='"+patient_id+"') pat_ssex from AE_TMT_AREA_FOR_CLINIC where ");
		 sql2.append(" clinic_code = ? and treatment_area_code =? ");
		 sql2.append(" and facility_id = ?");
		pstmt1 = con.prepareStatement(sql2.toString());
		pstmt1.setString(1, clinic_code) ;
		pstmt1.setString(2, treatment_area_code) ;
		pstmt1.setString(3, facilityId) ;
		rset11=pstmt1.executeQuery();
        if(rset11!=null && rset11.next()){
		treatgender=rset11.getString("gender");
		gender=rset11.getString("pat_ssex");
		}

		if((treatgender==null) || (treatgender.equals("null")) || (treatgender.equals("")))  treatgender			= "";
	  	if ((treatgender.equals("")))
		{    treatGenderProceed = true;
		} 
		if(rset11!=null) rset11.close();
		if(pstmt1!=null) pstmt1.close();
		if((sql2 != null) && (sql2.length() > 0))
		{	sql2.delete(0,sql2.length());
		}
		if (treatgender!=null || !(treatgender.equals("")))
		if(treatgender.equals(gender)) treatGenderProceed = true;
		if (pseudo_bed_yn.equals("Y")) {
        sql3 = new StringBuffer();
        sql3.append("select (1) from ae_bed_for_trmt_area a where ");
		sql3.append(" pseudo_bed_yn='N' and (a.CURRENT_STATUS='A' or ");
        sql3.append(" (a.Current_status='R' and ");
        sql3.append(" sysdate >a.occupied_until_date_time)) ");
		sql3.append(" and clinic_code = ? and ");
        sql3.append(" treatment_area_code = ? and facility_id = ? ");
		pstat  = con.prepareStatement(sql3.toString());
		pstat.setString(1, clinic_code);
		pstat.setString(2, treatment_area_code);
		pstat.setString(3, facilityId);
		rs11 = pstat.executeQuery();
		if (rs11!=null)	{
			while (rs11.next())	 {
			recCount = rs11.getInt(1);
		}}
		if (rs11 != null) rs11	.close();
		if (pstat != null) pstat.close();
		if (recCount!=0)  pseudoBedProceed = false;
		if((sql3 != null) && (sql3.length() > 0))
		 {	sql3.delete(0,sql3.length());
		 }
		}
    	if(treatGenderProceed && ( pseudo_bed_yn.equals("N") || pseudoBedProceed)) {
		sql4 = new StringBuffer();
	    sql4.append("select '1' from ae_bed_for_trmt_area where ");
	    sql4.append(" occupying_patient_id= ?  and facility_id= ? ");
	    pstmt1 = con.prepareStatement(sql4.toString());
	    pstmt1.setString(1, patient_id) ;
		pstmt1.setString(2, facilityId) ;
		rs11 = pstmt1.executeQuery();
		boolean occupy_flag=false;
		if(rs11!=null){
		if(rs11.next())
		occupy_flag=true;
		}
		if(rs11!=null) rs11.close();
    	if(pstmt1!=null) pstmt1.close();
		if((sql4 != null) && (sql4.length() > 0))
	    {sql4.delete(0,sql4.length());
		}
		if(!occupy_flag){
		con.setAutoCommit( false );
		boolean data1=updateData();
		
		if(data1)
		{  
		   msgSBuf = new StringBuffer();
		   /*msgSBuf.append("select get_error_message('RECORD_INSERTED') mesg from dual ");
		   PreparedStatement pstmt111  = con.prepareStatement(msgSBuf.toString());
		   ResultSet rs111 = pstmt111.executeQuery();
		   if (rs111!=null && rs111.next())
			message = rs111.getString("mesg");
			if(pstmt111!=null) pstmt111.close();
			if(rs111!=null) rs111.close();
			if((msgSBuf != null) && (msgSBuf.length() > 0))
			{msgSBuf.delete(0,msgSBuf.length());}*/
			con.commit();
            MessageManager mm=new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
			String msg = ((String) mesg.get("message"));
			out.println("<script>alert('"+msg+"');parent.frames(0).document.forms(0).refresh.click();</script>");
			mesg.clear();
			}else
			{con.rollback();
			out.println("<script>alert('Transaction failed');parent.frames(0).document.forms(0).refresh.click();</script>");
			}
			}else{
				    MessageManager mm=new MessageManager();
			        final java.util.Hashtable mesg = mm.getMessage(locale, "BED_OCCUPIED", "AE") ;
			        String msg = ((String) mesg.get("message"));
					out.println("<script>alert('"+msg+"');			parent.frames(0).document.forms(0).refresh.click();</script>");
					mesg.clear();
			}
		    } else if(!treatGenderProceed) {
				    MessageManager mm=new MessageManager();
			        final java.util.Hashtable mesg = mm.getMessage(locale, "CANT_ASSIGN_TRMT_AREA", "AE") ;
			        String msg = ((String) mesg.get("message"));
		    out.println("<script>alert(\""+msg+"\");parent.frames(0).document.forms(0).refresh.click();</script>");
			mesg.clear();
			} else if(!pseudoBedProceed) {
					MessageManager mm=new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "SPARE_BAY_CANT_BE_ASGNED", "AE") ;
					String msg = ((String) mesg.get("message"));
			 out.println("<script>alert(\""+msg+"\");parent.frames(0).document.forms(0).refresh.click();</script>");
			 mesg.clear();
			}}
catch( Exception e ){
	con.rollback();
	e.printStackTrace();
	//out.println(e.toString());
}		}catch(Exception e){
 		e.printStackTrace();
		}finally
    { try
	    {if(pstmt!=null) pstmt.close(); if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();if(pstmt3!=null) pstmt3.close();
		ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}}

public boolean updateData()
{ try
	{
	    //int res = 0;
		//int res1 = 0;

	    sql11 = new StringBuffer();
        sql11.append("update op_patient_queue set ");
        sql11.append("queue_status='02',treatment_area_code = ? ,");
        sql11.append(" ae_bed_no = ? , priority_zone = ? , ");
        sql11.append(" practitioner_id =upper(?), modified_by_id = ?, ");
        sql11.append(" modified_date = SYSDATE, ASSIGN_TMT_AREA_TIME=SYSDATE, modified_at_ws_no = ?,");
        sql11.append(" modified_facility_id = ?");
		sql11.append(" where facility_id = ? and locn_type = 'C' and ");
        sql11.append(" locn_code = ?  and encounter_id = ? "); 
		sql22 = new StringBuffer();
        sql22.append("update AE_BED_FOR_TRMT_AREA set ");
    	sql22.append("OCCUPYING_PATIENT_ID = ?, CURRENT_STATUS ='O' ");
	    sql22.append(" where FACILITY_ID =? AND  CLINIC_CODE = ?");
		sql22.append(" AND  TREATMENT_AREA_CODE = ? AND BED_NO = ? ");
		sql33 = new StringBuffer();
        sql33.append("insert into ae_pat_movement_log ");
        sql33.append("(patient_id,facility_id,encounter_id,");
        sql33.append("assign_tmt_area_code,assign_bed_no,");
        sql33.append("assign_practitioner_id,assign_date,");
        sql33.append("assign_clinic_code,added_facility_id,");
		sql33.append("added_date,added_by_id,");
		sql33.append("added_at_ws_no,service_code)");
		sql33.append(" values (?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?) ");

         sql44 = new StringBuffer();
         sql44.append("update pr_encounter set ");
         sql44.append(" visit_status='02', ATTEND_PRACTITIONER_ID = null ,ASSIGN_BED_NUM = ?,");
		 sql44.append(" modified_by_id = ?,");
		 sql44.append(" modified_date = SYSDATE,  modified_at_ws_no = ?,");
		 sql44.append(" modified_facility_id = ?,TREATMENT_AREA_CODE=?");
		 sql44.append("  where facility_id = ? and encounter_id= ? ");
         pstmt = con.prepareStatement(sql11.toString());
         pstmt.setString(1, treatment_area_code) ;
	     pstmt.setString(2, bed_no) ;
		 pstmt.setString(3, priority_zone) ;
		 pstmt.setString(4, practitioner_id) ;
		 pstmt.setString(5, user_id) ;
		 pstmt.setString(6, client_ip_address) ;
		 pstmt.setString(7, facilityId) ;
		 pstmt.setString(8, facilityId) ;
		 pstmt.setString(9, clinic_code) ;
		 pstmt.setString(10, encounter_id) ;
		
		 pstmt1 = con.prepareStatement(sql22.toString());
		 pstmt1.setString(1, patient_id) ;
	     pstmt1.setString(2, facilityId) ;
		 pstmt1.setString(3, clinic_code) ;
    	 pstmt1.setString(4, treatment_area_code) ;
		 pstmt1.setString(5, bed_no) ;
          
		  pstmt2 = con.prepareStatement(sql33.toString());
		 pstmt2.setString(1, patient_id) ;
	     pstmt2.setString(2, facilityId) ;
		 pstmt2.setString(3, encounter_id) ;
		 pstmt2.setString(4, treatment_area_code) ;
		 pstmt2.setString(5, bed_no) ;
		 pstmt2.setString(6, practitioner_id.equals("*All")?"":practitioner_id) ;
		 pstmt2.setString(7, clinic_code) ;
		 pstmt2.setString(8, facilityId) ;
		 pstmt2.setString(9, user_id) ;
		 pstmt2.setString(10, client_ip_address) ;
		 pstmt2.setString(11, service_code) ;

		 pstmt3 =  con.prepareStatement(sql44.toString());
		// pstmt3.setString(1, practitioner_id) ;
		 pstmt3.setString(1, bed_no) ;
		 pstmt3.setString(2, user_id) ;
		 pstmt3.setString(3, client_ip_address) ;
		 pstmt3.setString(4, facilityId) ;
		 //pstmt3.setString(5, service_code) ;
		 pstmt3.setString(5, treatment_area_code) ;
		  pstmt3.setString(6, facilityId) ;
		 pstmt3.setString(7, encounter_id) ;
         pstmt.executeUpdate();
		 pstmt1.executeUpdate();
         //res = pstmt.executeUpdate();
         //res1 =  pstmt1.executeUpdate();
         pstmt2.executeUpdate();
	     pstmt3.executeUpdate();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
		if(pstmt3!=null) pstmt3.close();
	}
	catch(Exception e)
	{
	 e.printStackTrace();
	 return false;
	}
return true;
}

} // End of the Class
			

