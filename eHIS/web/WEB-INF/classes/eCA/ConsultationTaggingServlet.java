/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
07/09/2023	    41654			Twinkle Shah				           Ramesh Goli             MMS-JU-CRF-0015.4											
14/06/2024    62519         Krishna Pranay     20/06/2024     Ramesh Goli         COMMON-ICN-0289							
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class ConsultationTaggingServlet extends javax.servlet.http.HttpServlet	
{

private static final long serialVersionUID = 1L;

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
{ 
		PrintWriter out = null;
		Connection con = null;
		request.setCharacterEncoding("UTF-8");			
		response.setContentType("text/html; charset=UTF-8");
		con = ConnectionManager.getConnection(request);
		
		String mode1=request.getParameter("mode1")==null?"":request.getParameter("mode1");
		if("modify".equals(mode1))
		{
			updateConsultationTagging(request,response,con);
		}
		else if("delete".equals(mode1))
		{
			deleteConsultationTaggingRecord(request,response,con);
		}
		else
		{
			insertConsultationTagging(request,response,con);
		}
	}

	public void insertConsultationTagging(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		 //ResultSet rs = null;  //62519  
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facility_id		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");

		String insert_query ="";
		String patient_id ="";
		String sStyle =	 "";
		int nInsStat =0;
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String start_Date="";
	   String end_Date="";
long encounter_id;
String mode1="";
String encounter="";
	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	     outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";
	     String splCode =request.getParameter("splCode")==null?"":request.getParameter("splCode");
	     String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");	     
	     String practitionerId =request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId");
		 start_Date =request.getParameter("start_Date")==null?"":request.getParameter("start_Date");
		 start_Date			= com.ehis.util.DateUtils.convertDate(start_Date,"DMYHM",locale,"en");
		end_Date =request.getParameter("end_Date")==null?"":request.getParameter("end_Date");
		end_Date			= com.ehis.util.DateUtils.convertDate(end_Date,"DMYHM",locale,"en");
        mode1 =request.getParameter("mode1")==null?"":request.getParameter("mode1");	
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	    encounter = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	    encounter_id = Long.parseLong(encounter);
		try
		{
			insert_query ="INSERT INTO CA_CONSULTATION_TAGGING(FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,SPECIALITY_CODE,TAG_PRACTITIONER_ID,START_DATE,END_DATE ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),TO_DATE(?,'DD/MM/YYYY HH24:MI'),?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)";

			pstmt=con.prepareStatement(insert_query); 
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setLong(3,encounter_id);
			pstmt.setString(4,splCode);
			pstmt.setString(5,practitionerId);
			pstmt.setString(6,start_Date);
			pstmt.setString(7,end_Date);
			pstmt.setString(8,loginuserid);
			pstmt.setString(9,client_ip_address);
			pstmt.setString(10,facility_id);
			pstmt.setString(11,loginuserid);
			pstmt.setString(12,client_ip_address);
			pstmt.setString(13,facility_id);
			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			  if(nInsStat>0)
			  { 		
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1";
				}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
				
				if("CONSULT_TAGGING".equals(option_id) || "CONSULT_TAGGING1".equals(option_id)) 
				    outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
				else
					outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
				
			   out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
		catch(Exception e )
		{			
			e.printStackTrace();
			
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	public void updateConsultationTagging(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1 = null;  //62519  
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		loginuserid		=(String) session.getValue("login_user");
		facility_id		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		String patient_id ="";
		String sStyle =	 "";
	    String outPut1 = "";
	    String outPut2 = ""; 
	    String start_Date="";
	    String end_Date="";
	    String encounter="";
 long encounter_id;
// String mode1=""; // 62519  
String modify_query="";
int updsStat=0;
String tag_practitioner_id="";
String speciality_code="";
sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";

	     String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
		 start_Date =request.getParameter("start_Date")==null?"":request.getParameter("start_Date");
		 start_Date			= com.ehis.util.DateUtils.convertDate(start_Date,"DMYHM",locale,"en");
		 end_Date =request.getParameter("end_Date")==null?"":request.getParameter("end_Date");
	     end_Date			= com.ehis.util.DateUtils.convertDate(end_Date,"DMYHM",locale,"en");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		encounter = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	    
	    encounter_id = Long.parseLong(encounter);

        tag_practitioner_id = request.getParameter("tag_practitioner_id")==null?"":request.getParameter("tag_practitioner_id");
	    speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		try
		{
	       modify_query ="UPDATE CA_CONSULTATION_TAGGING SET start_date = TO_DATE (?, 'dd/MM/yyyy HH24:MI'), end_date = TO_DATE (?, 'dd/MM/yyyy HH24:MI'), modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE FACILITY_ID = ? and PATIENT_ID=? and ENCOUNTER_ID=? and TAG_PRACTITIONER_ID=? and SPECIALITY_CODE=?";
			pstmt=con.prepareStatement(modify_query); 
			pstmt.setString(1,start_Date);
			pstmt.setString(2,end_Date);
			pstmt.setString(3,loginuserid);
			pstmt.setString(4,client_ip_address);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,facility_id );
			pstmt.setString(7,patient_id );
			pstmt.setLong(8, encounter_id);
			pstmt.setString(9,tag_practitioner_id );
			pstmt.setString(10,speciality_code );
			pstmt.setString(5,speciality_code);
			updsStat = pstmt.executeUpdate();	
			if(pstmt != null) pstmt.close();
			  if(updsStat>0)
			  { 		
				con.commit();
				errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				error_value = "1";
				}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				if(pstmt != null) pstmt.close();
				if("CONSULT_TAGGING".equals(option_id) || "CONSULT_TAGGING1".equals(option_id)) 
				    outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
				else
					outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
				   out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
	
		}
		catch(Exception e )
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	public void deleteConsultationTaggingRecord(HttpServletRequest request,HttpServletResponse response,Connection con)
	{
		HttpSession session = request.getSession(false);
		PrintWriter out = null;
		try
		{
			out= response.getWriter();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		Properties p;
		String errorMsg = "";
		String error_value ="";
		String loginuserid = "";
		String client_ip_address = "";
		String facility_id = "";

		p = (java.util.Properties) session.getValue( "jdbc" ) ;

		loginuserid		=(String) session.getValue("login_user");
		facility_id		=(String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");
		String locale = (String) p.getProperty("LOCALE");
		String patient_id ="";
		String sStyle =	 "";
		int nInsStat =0;
	String outPut1 = "";
	String outPut2 = ""; 
	String start_Date="";
	String end_Date="";
String encounter_id;
Long encounter;
String del_query="";
  // String mode1="";  // 62519  
String tag_practitioner_id="";
String speciality_code="";
String insert_query_log="";
int nInsStatLog=0;
sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	     outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";
	     String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
	     
	     start_Date =request.getParameter("start_Date")==null?"":request.getParameter("start_Date");
		 start_Date			= com.ehis.util.DateUtils.convertDate(start_Date,"DMYHM",locale,"en");
		 end_Date =request.getParameter("end_Date")==null?"":request.getParameter("end_Date");
	     end_Date			= com.ehis.util.DateUtils.convertDate(end_Date,"DMYHM",locale,"en");
	     
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	    encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	    encounter= Long.parseLong(encounter_id);
	    tag_practitioner_id = request.getParameter("tag_practitioner_id")==null?"":request.getParameter("tag_practitioner_id");
	    speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		try
		{
			del_query ="DELETE FROM CA_CONSULTATION_TAGGING WHERE facility_id = ? AND patient_id = ? AND encounter_id = ? and TAG_PRACTITIONER_ID=? and SPECIALITY_CODE=?";

			pstmt=con.prepareStatement(del_query); 
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setLong(3,encounter);
			pstmt.setString(4,tag_practitioner_id);
			pstmt.setString(5,speciality_code);
			nInsStat = pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();

			  if(nInsStat>0)
			  { 		
				  insert_query_log ="INSERT INTO CA_CONSULTATION_TAGGING_LOG(FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,SPECIALITY_CODE,TAG_PRACTITIONER_ID,START_DATE,END_DATE ,ROW_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)";
					pstmt=con.prepareStatement(insert_query_log); 
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setLong(3,encounter);
					pstmt.setString(4,speciality_code);
                    pstmt.setString(5,tag_practitioner_id);
					pstmt.setString(6,start_Date);
					pstmt.setString(7,end_Date);
					pstmt.setString(8,"D");
					pstmt.setString(9,loginuserid);
					pstmt.setString(10,client_ip_address);
					pstmt.setString(11,facility_id);
					pstmt.setString(12,loginuserid);
					pstmt.setString(13,client_ip_address);
					pstmt.setString(14,facility_id);
					nInsStatLog = pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();
				  
				  if(nInsStatLog>0)
				  { 
			      con.commit();
				  errorMsg= getMessage(locale,"RECORD_INSERTED","CA");
				  error_value = "1";
				  }
				  else
				  {
				   con.rollback();
				   errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				   error_value = "0" ;
					}
				}
			else
			{
				con.rollback();
				errorMsg= getMessage(locale,"FAILED_TRANSACTION","CA");
				error_value = "0" ;
			}
				if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
				   
				if("CONSULT_TAGGING".equals(option_id) || "CONSULT_TAGGING1".equals(option_id))   
				 outPut2 = "<script>parent.frames(3).onSuccess();</script>"+"</BODY></html>";  
				else
				outPut2 = "<script>parent.frames(3).location.reload();</script>"+"</BODY></html>";  
				out.println(outPut1+"<script>alert('"+errorMsg+"');</script>"+outPut2);
		}
		catch(Exception e )
		{			
			e.printStackTrace();
			
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		finally
		{			
			if(con != null) ConnectionManager.returnConnection(con);	
		}
	}
	
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }

}
