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

public class QAAnlyzRecordOfClinIndicatorsServlet extends HttpServlet implements SingleThreadModel{
	
	
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

	    Connection conn=null;
		PreparedStatement pstmtQry =null;
		PreparedStatement pstmtRecChk =null;
		PreparedStatement pstmtMastUpd =null;
		PreparedStatement pstmtUpdate =null;
		ResultSet rset=null;

		String strEncounterId=req.getParameter("encounter_id")==null?" ":req.getParameter("encounter_id");
		String qind_clind_id=req.getParameter("qind_clind_id")==null?" ":req.getParameter("qind_clind_id");
		String incl_compl_code=req.getParameter("incl_compl_code").equals("")?" ":req.getParameter("incl_compl_code");
		String incl_comments=req.getParameter("incl_comments").equals("")?" ":req.getParameter("incl_comments");
		String patient_class=req.getParameter("patient_class")==null?" ":req.getParameter("patient_class");
		String incl_yn=req.getParameter("incl_yn")==null?" ":req.getParameter("incl_yn");
		String sql=req.getParameter("p_sql")==null?" ":req.getParameter("p_sql");

 		PrintWriter out;
		out=res.getWriter();
		HttpSession session = req.getSession(false);	
		int x=0;	
		
		try	{
		         
              String error			="";
			  res.setContentType("text/html");
			  System.out.println("QA Start before");
			  
			  StringBuffer strRecChk  = new StringBuffer();
			  StringBuffer sqlMastUpd = new StringBuffer();
			  StringBuffer sqlUpdate  = new StringBuffer();

			  conn = ConnectionManager.getConnection(req);
			  java.util.Properties p  = null;
			  System.out.println("QA Start before session");
			  p = (java.util.Properties) (session.getValue( "jdbc" )==null ? "" : session.getValue( "jdbc" ) );
			  System.out.println("QA Start after session") ;

              
		      String facility_id = (String) (session.getValue("facility_id")==null ? "" : session.getValue("facility_id")) ;

		      String addedById			= p.getProperty( "login_user" ) ;
			  String client_ip_address =  p.getProperty("client_ip_address");
		      String addedAtWorkstation	=client_ip_address;
			  String update_yn="";
				
			 strRecChk.append("SELECT PATIENT_CLASS,");
			 strRecChk.append("to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy'),");
			 strRecChk.append("to_char(NVL(DISCHARGE_DATE_TIME,VISIT_ADM_DATE_TIME),'dd/mm/yyyy')");
			 strRecChk.append(" FROM PR_ENCOUNTER ");
			 strRecChk.append(" WHERE FACILITY_ID=? AND ENCOUNTER_ID=? ");

			 pstmtRecChk = conn.prepareStatement(strRecChk.toString());

           	  sqlMastUpd.append("UPDATE QA_QIND_ENCOUNTER_TRN  SET ");
			  sqlMastUpd.append("MODIFIED_BY_ID=?,ENCOUNTER_END_DATE=to_date(?,'dd/mm/yyyy'),");
			  sqlMastUpd.append("ENCOUNTER_START_DATE=to_date(?,'dd/mm/yyyy'),");
			  sqlMastUpd.append("MODIFIED_DATE=SYSDATE ,MODIFIED_AT_WS_NO=?,");
			  sqlMastUpd.append("MODIFIED_FACILITY_ID=? WHERE FACILITY_ID=? AND ");
			  sqlMastUpd.append("ENCOUNTER_ID=? ");
              pstmtMastUpd = conn.prepareStatement(sqlMastUpd.toString());

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
			
			
				pstmtRecChk.setString(1,facility_id);
				pstmtRecChk.setString(2,strEncounterId);
				rset = pstmtRecChk.executeQuery();	
				if(rset.next())
				{
					update_yn = "Y";
				    String strFromDate = 	rset.getString(2);
				    String strToDate = 	rset.getString(3);

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
				
			
					System.out.println("incl_comments:" + incl_comments);
					System.out.println("incl_yn:" + incl_yn);
					System.out.println("incl_compl_code:" + incl_compl_code);
					System.out.println("addedAtWorkstation:" + addedAtWorkstation);
					System.out.println("qind_clind_id:" + qind_clind_id);

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
	
					System.out.println("X2:" + x);
				}
	  if(rset!=null)rset.close();


    //if(rset!=null)rset.close();
	
	
	//session.removeAttribute("collectData");
//	session.removeAttribute("arr");
 	
	 
	if ( x>0 )
	{  
		out.println("<script>alert('"+error+"')");
		out.println("parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=1'");
		//out.println("parent.frames(2).location.href = '../../eQA/jsp/QAAnalyzePartialIndSearchResult.jsp?sql="+sql);
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

	if((sqlMastUpd != null) && (sqlMastUpd.length() > 0))
	{
		sqlMastUpd.delete(0,sqlMastUpd.length());
	}
	if((sqlUpdate != null) && (sqlUpdate.length() > 0))
	{
		sqlUpdate.delete(0,sqlUpdate.length());
	}
	if((strRecChk != null) && (strRecChk.length() > 0))
	{
		strRecChk.delete(0,strRecChk.length());
	}
	if(pstmtRecChk!=null) pstmtRecChk.close();
	if(pstmtMastUpd!=null) pstmtMastUpd.close();
	if(pstmtUpdate!=null) pstmtUpdate.close();

			/*}else
	{
		error="APP-002413 No Changes to Save ....";
		out.println("<script>alert('"+error+"')");
		out.println("parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0'");
		out.println("</script>");
		//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=0" );
	}*/
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
		//out.println("<script>parent.qa_message_frame.location.href='../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("") + "&err_value=0'");
	//	out.println("</script>");
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

 }
 	
}
