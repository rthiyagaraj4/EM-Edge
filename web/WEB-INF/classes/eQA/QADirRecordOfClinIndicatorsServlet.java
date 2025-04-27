/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eQA;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class QADirRecordOfClinIndicatorsServlet extends HttpServlet implements SingleThreadModel{
	
	
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

	    Connection conn=null;
		PreparedStatement pstmtQry =null;
		PreparedStatement pstmtRecChk =null;
		PreparedStatement pstmtMasQry =null;
		PreparedStatement pstmtMastUpd =null;
		PreparedStatement pstmtMastIns =null;
		PreparedStatement pstmtUpdate =null;
		PreparedStatement pstmtInsert =null;
		ResultSet rset=null;

		PrintWriter out;
		out=res.getWriter();
		HttpSession session = req.getSession(false);	
		int x=0;	
		
		try	{
		         
              String error			="";
			  res.setContentType("text/html");
			  System.out.println("QA Start before");
			  if (session!=null)
			  {
	  			Enumeration attributes=session.getAttributeNames();
				 System.out.println("session.isNew() "+session.isNew() );
				 if (attributes != null)
					{
						while(attributes.hasMoreElements()) {
							   System.out.println("attributes:"+ attributes.nextElement());
						}
					}
			  }
			
			  ArrayList arr =(ArrayList)session.getAttribute("arr");
			  System.out.println("QA Start after arraylist");
			  HashMap hash=(HashMap)session.getAttribute("collectData");
			  System.out.println("QA Start after hashmap");
			  System.out.println("indicator start");
			  StringBuffer strRecChk  = new StringBuffer();
			  StringBuffer strQry     = new StringBuffer();
			  StringBuffer strMasQry  = new StringBuffer();
			  StringBuffer sqlMastUpd = new StringBuffer();
			  StringBuffer sqlMastIns = new StringBuffer();
			  StringBuffer sqlUpdate  = new StringBuffer();
			  StringBuffer sqlInsert  = new StringBuffer();
			  conn = ConnectionManager.getConnection(req);
			  java.util.Properties p  = null;
			  p = (java.util.Properties) session.getValue( "jdbc" ) ;
              String client_ip_address = p.getProperty("client_ip_address");
		      String facility_id = (String)session.getValue("facility_id") ;
		      String addedById			= p.getProperty( "login_user" ) ;
		      String addedAtWorkstation	=client_ip_address;
			  String update_yn="";
				
			 strRecChk.append("SELECT PATIENT_CLASS,");
			 strRecChk.append("to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy'),");
			 strRecChk.append("to_char(NVL(DISCHARGE_DATE_TIME,VISIT_ADM_DATE_TIME),'dd/mm/yyyy')");
			 strRecChk.append(" FROM PR_ENCOUNTER ");
			 strRecChk.append(" WHERE FACILITY_ID=? AND ENCOUNTER_ID=? ");

			 pstmtRecChk = conn.prepareStatement(strRecChk.toString());

             strMasQry.append("SELECT * FROM QA_QIND_ENCOUNTER_TRN  WHERE facility_id=? AND encounter_id=?");

			  pstmtMasQry = conn.prepareStatement(strMasQry.toString());
			 
		

			  sqlMastUpd.append("UPDATE QA_QIND_ENCOUNTER_TRN  SET ");
			  sqlMastUpd.append("MODIFIED_BY_ID=?,ENCOUNTER_END_DATE=to_date(?,'dd/mm/yyyy'),");
			  sqlMastUpd.append("ENCOUNTER_START_DATE=to_date(?,'dd/mm/yyyy'),");
			  sqlMastUpd.append("MODIFIED_DATE=SYSDATE ,MODIFIED_AT_WS_NO=?,");
			  sqlMastUpd.append("MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND ");
			  sqlMastUpd.append("ENCOUNTER_ID=? ");
              pstmtMastUpd = conn.prepareStatement(sqlMastUpd.toString());

			  sqlMastIns.append("INSERT INTO QA_QIND_ENCOUNTER_TRN ");
			  sqlMastIns.append("(FACILITY_ID,ENCOUNTER_ID,PATIENT_CLASS, ");
			  sqlMastIns.append("ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO, ");
			  sqlMastIns.append("ADDED_FACILITY_ID,MODIFIED_BY_ID, ");
			  sqlMastIns.append("MODIFIED_DATE,MODIFIED_AT_WS_NO,");
			  sqlMastIns.append("MODIFIED_FACILITY_ID,ENCOUNTER_START_DATE,");
			  sqlMastIns.append(" ENCOUNTER_END_DATE) VALUES ");
			  sqlMastIns.append("(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))");

			  pstmtMastIns = conn.prepareStatement(sqlMastIns.toString());

			  strQry.append("SELECT * FROM QA_QIND_ENCOUNTER_CLIND_TRN WHERE facility_id=? AND encounter_id=?  AND qind_clind_id=?");

			  pstmtQry= conn.prepareStatement(strQry.toString());			

			 sqlUpdate.append("UPDATE QA_QIND_ENCOUNTER_CLIND_TRN SET  ");
			 sqlUpdate.append(" SYS_USER_CREATED='D',");
			 sqlUpdate.append(" CLIND_ANALYSIS_STATUS='9',");
			 sqlUpdate.append(" INCL_COMMENTS=?,");
			 sqlUpdate.append(" APPLICABLE_YN=?,");
			 sqlUpdate.append(" INCL_FOR_YES_YN=?,");
			 sqlUpdate.append(" INCL_COMPL_CODE=?,");
			 sqlUpdate.append(" MODIFIED_BY_ID=?,");
			 sqlUpdate.append(" MODIFIED_DATE=SYSDATE,");
			 sqlUpdate.append(" MODIFIED_AT_WS_NO=?,");
			 sqlUpdate.append(" MODIFIED_FACILITY_ID=? ");
			 sqlUpdate.append(" WHERE ");
			 sqlUpdate.append(" FACILITY_ID=?  AND ");
			 sqlUpdate.append(" ENCOUNTER_ID=?  AND ");
			 sqlUpdate.append(" QIND_CLIND_ID=? ");
			// sqlUpdate.append(" QIND_CLIND_ID=?  AND ");
			// sqlUpdate.append(" (SYS_USER_CREATED='D' OR CLIND_ANALYSIS_STATUS IN ('0','5'))");
			
			 pstmtUpdate = conn.prepareStatement(sqlUpdate.toString());
			
			 sqlInsert.append(" INSERT INTO QA_QIND_ENCOUNTER_CLIND_TRN ( ");
			 sqlInsert.append("FACILITY_ID,");
			 sqlInsert.append(" ENCOUNTER_ID,");
			 sqlInsert.append(" QIND_CLIND_ID,");
			 sqlInsert.append(" SYS_USER_CREATED,");
			 sqlInsert.append(" CLIND_ANALYSIS_STATUS,");
			 sqlInsert.append(" INCL_COMMENTS,");
			 sqlInsert.append(" APPLICABLE_YN,");
			 sqlInsert.append(" INCL_FOR_YES_YN,");
			 sqlInsert.append(" INCL_COMPL_CODE,");
			 sqlInsert.append(" ADDED_BY_ID,");
			 sqlInsert.append(" ADDED_DATE,");
			 sqlInsert.append(" ADDED_AT_WS_NO,");
			 sqlInsert.append(" ADDED_FACILITY_ID,");
			 sqlInsert.append(" MODIFIED_BY_ID,");
			 sqlInsert.append(" MODIFIED_DATE,");
			 sqlInsert.append(" MODIFIED_AT_WS_NO,");
			 sqlInsert.append(" MODIFIED_FACILITY_ID)");
			 sqlInsert.append(" VALUES 	(?,?,?,'D','9',?,?,?,?,?, SYSDATE,?,?,?,SYSDATE,?,?)");
           	 pstmtInsert = conn.prepareStatement(sqlInsert.toString());
        if(arr!=null)
			{
		for(int i=0;i<arr.size();i++)
		{
		  if(hash.containsKey(arr.get(i)))
		   {
			 StringTokenizer subTkn= new StringTokenizer((String)hash.get(arr.get(i)),"|");
			 
			 while(subTkn.hasMoreTokens())
			  {
			    String strFromDate="";
	            String strToDate="";
			    String strEncounterId=subTkn.nextToken();
			    String qind_clind_id=subTkn.nextToken();
			   // String clind_analysis_status=subTkn.nextToken();
			   // String incl_diag_code=subTkn.nextToken();
			   // String incl_proc_code=subTkn.nextToken();
			    String incl_compl_code=subTkn.nextToken();
			    String incl_comments=subTkn.nextToken();
                String incl_yn=subTkn.nextToken();
			    String patient_class=subTkn.nextToken();
			
				
				pstmtRecChk.setString(1,facility_id);
				pstmtRecChk.setString(2,strEncounterId);
				rset = pstmtRecChk.executeQuery();	
				if(rset.next())
				{
					update_yn = "Y";
				    strFromDate = 	rset.getString(2);
				    strToDate = 	rset.getString(3);

			    pstmtMasQry.setString(1,facility_id);
				pstmtMasQry.setString(2,strEncounterId);
				rset = pstmtMasQry.executeQuery();
			    if(rset.next())
			    {
					
			    
					error="APP-SM0002 Operation Completed Successfully ....";
					System.out.println("addedById:" + addedById);
					System.out.println("strToDate:" + strToDate);
					System.out.println("strFromDate:" + strFromDate);
					System.out.println("addedAtWorkstation:" + addedAtWorkstation);
					System.out.println("facility_id:" + facility_id);
					System.out.println("strEncounterId:" + strEncounterId);
					
					pstmtMastUpd.setString(1,addedById);
					pstmtMastUpd.setString(2,strToDate);
					pstmtMastUpd.setString(3,strFromDate);
					pstmtMastUpd.setString(4,addedAtWorkstation);
					pstmtMastUpd.setString(5,facility_id);
					pstmtMastUpd.setString(6,facility_id);
					pstmtMastUpd.setString(7,strEncounterId);
					x=  pstmtMastUpd.executeUpdate();
			        System.out.println("x" +x);
				}
				else
				    {
				     error="APP-SM0001 Operation Completed Successfully ....";
					 pstmtMastIns.setString(1,facility_id);
					 pstmtMastIns.setString(2,strEncounterId);
					 pstmtMastIns.setString(3,patient_class);
					 pstmtMastIns.setString(4,addedById);
					 pstmtMastIns.setString(5,addedAtWorkstation);
					 pstmtMastIns.setString(6,facility_id);
					 pstmtMastIns.setString(7,addedById);
					 pstmtMastIns.setString(8,addedAtWorkstation);
					 pstmtMastIns.setString(9,facility_id);
					 pstmtMastIns.setString(10,strToDate);
	    			 pstmtMastIns.setString(11,strFromDate);
		             pstmtMastIns.executeUpdate();
				   }

					System.out.println("incl_comments:" + incl_comments);
					System.out.println("incl_yn:" + incl_yn);
					System.out.println("incl_compl_code:" + incl_compl_code);
					System.out.println("addedAtWorkstation:" + addedAtWorkstation);
					System.out.println("qind_clind_id:" + qind_clind_id);
					
					    
                      
				pstmtQry.setString(1,facility_id);
				pstmtQry.setString(2,strEncounterId);
				pstmtQry.setString(3,qind_clind_id);
				rset = pstmtQry.executeQuery();	

		             if(!rset.next())
		             { 

						pstmtInsert.setString(1,facility_id);
						pstmtInsert.setString(2,strEncounterId);
						pstmtInsert.setString(3,qind_clind_id);
						pstmtInsert.setString(4,incl_comments);
						pstmtInsert.setString(5,"Y");
						pstmtInsert.setString(6,incl_yn);
						pstmtInsert.setString(7,incl_compl_code);
						pstmtInsert.setString(8,addedById);
						pstmtInsert.setString(9,addedAtWorkstation);
						pstmtInsert.setString(10,facility_id);
						pstmtInsert.setString(11,addedById);
						pstmtInsert.setString(12,addedAtWorkstation);
						pstmtInsert.setString(13,facility_id);
						x=pstmtInsert.executeUpdate();     
		             
					 }
					 else
					{
					 pstmtUpdate.setString(1,incl_comments);
					 pstmtUpdate.setString(2,"Y");
					 pstmtUpdate.setString(3,incl_yn);
					 pstmtUpdate.setString(4,incl_compl_code);
					 pstmtUpdate.setString(5,addedById);
					 pstmtUpdate.setString(6,addedAtWorkstation);
					 pstmtUpdate.setString(7,facility_id);
					 pstmtUpdate.setString(8,facility_id);
					 pstmtUpdate.setString(9,strEncounterId);
					 pstmtUpdate.setString(10,qind_clind_id);
					 x=pstmtUpdate.executeUpdate(); 
					}
					System.out.println("X2:" + x);

			  }

	 
   }
  }
 }
    //if(rset!=null)rset.close();
	
	
	//session.removeAttribute("collectData");
//	session.removeAttribute("arr");
 	
	 
	if ( x>0 )
	{  
		out.println("<script>alert('"+error+"')");
		out.println("parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=1'");
		out.println("</script>");
		//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=1");
		conn.commit();
	}
	else
    {   
		
		error="error...";
		out.println("<script>alert('"+error+"')");
		out.println("parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0'");
		out.println("</script>");
		//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=0" );
    }
	if((sqlInsert != null) && (sqlInsert.length() > 0))
	{
		sqlInsert.delete(0,sqlInsert.length());
	}
	if((sqlMastUpd != null) && (sqlMastUpd.length() > 0))
	{
		sqlMastUpd.delete(0,sqlMastUpd.length());
	}
	if((sqlMastIns != null) && (sqlMastIns.length() > 0))
	{
		sqlMastIns.delete(0,sqlMastIns.length());
	}
	if((sqlUpdate != null) && (sqlUpdate.length() > 0))
	{
		sqlUpdate.delete(0,sqlUpdate.length());
	}
	if((strQry != null) && (strQry.length() > 0))
	{
		strQry.delete(0,strQry.length());
	}
	if(pstmtRecChk!=null) pstmtRecChk.close();
	if(pstmtMasQry!=null) pstmtMasQry.close();
	if(pstmtMastUpd!=null) pstmtMastUpd.close();
	if(pstmtMastIns!=null) pstmtMastIns.close();
	if(pstmtQry!=null) pstmtQry.close();
	if(pstmtUpdate!=null) pstmtUpdate.close();
	if(pstmtInsert!=null) pstmtInsert.close();
// arr.clear();
// hash.clear();
			}else
	{
		error="APP-002413 No Changes to Save ....";
		out.println("<script>alert('"+error+"')");
		out.println("parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0'");
		out.println("</script>");
		//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=0" );
	}
	 if(rset!=null)rset.close();
  }
  catch(Exception e)
  {
	 e.printStackTrace();
	  System.out.println("Error in QA "+e);
	  
	   try
		 { 
		//  session.removeAttribute("collectData");
	    //  session.removeAttribute("arr");
		 // out.println("<script>alert('"+error+"')");
		out.println("<script>parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0'");
		out.println("</script>");
 	//  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0" );
		   System.out.println("Error in QA "+e);
		   if (conn != null)
			  conn.rollback(); 
		 }
		 catch(Exception ee)
		 {
			ee.printStackTrace();
		  System.out.println("Error in QA "+ee);
		  
		 }
  }
  finally
  {
	  if(conn != null)
		 ConnectionManager.returnConnection(conn, req);
  }
 
	session.removeAttribute("collectData");
	 session.removeAttribute("arr");
 }
 	
}
