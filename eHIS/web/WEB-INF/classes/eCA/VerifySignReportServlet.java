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
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class VerifySignReportServlet extends javax.servlet.http.HttpServlet
{
	HttpSession session = null;
	java.util.Properties p = null;

	String locale = "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;

		try
		{
		   session = req.getSession(false);
		   p = (java.util.Properties) session.getValue("jdbc");
		   locale = (String) p.getProperty("LOCALE");
		   out = res.getWriter();
	   	   String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		   String login_user = (String) session.getValue("login_user") ;

   			eCA.PatientBannerGroupLine verifySignBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("verifySignBean","eCA.PatientBannerGroupLine",session);

			callAuthProc(req,res,out,verifySignBean,facilityId,session,locale,login_user);
		}
		catch(Exception e)
		{
			
			out.println("Exception at try-doPost() of VerifySignReportServlet.java--"+e.toString());
			e.printStackTrace();
		}
	} //end of doPost()

	private void callAuthProc(HttpServletRequest req, HttpServletResponse res, PrintWriter out, eCA.PatientBannerGroupLine verifySignBean, String facilityId,HttpSession session,String locale,String login_user)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CallableStatement cs = null;

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String moduleId = "";
		String reportId = "";
		String requestDate = "";
		String destLocnType = "";
		String destLocnCode = "";
		String reportFileName = "";
		String routingMode = "";
		String reportPriority = "";
		String attachmentRequiredYN = "";
		String accessionNum = "";
		String mailCommDateTime = "";
		String userId = "";
		String requestSrlNo = "";
		String patientId = "";
		String encounterId = "";
		String reject_reason = "";
		String verify_flag = "";
		String valueFromMap = "";
		String rejectedBy = login_user;
		StringTokenizer strToken = null;

		String sqlVals = "select MODULE_ID, REPORT_ID, to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi:ss') REQUEST_DATE, DEST_LOCN_TYPE, DEST_LOCN_CODE, REPORT_FILE_NAME, ROUTING_MODE, REPORT_PRIORITY, ATTACHMENT_REQUIRED_YN, ACCESSION_NUM, to_char(MAIL_COMM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') MAIL_COMM_DATE_TIME, USER_ID, ENCOUNTER_ID, PATIENT_ID from SM_REPORT_VERIFY_REQUEST where REQUEST_SRL_NO = ?";

		ArrayList list = verifySignBean.getKeys();
		HashMap map = verifySignBean.returnHashMap();

		try
		{
			con = ConnectionManager.getConnection(req);
			ps = con.prepareStatement(sqlVals);
			cs = con.prepareCall("{call APPFAXMAIL.VERIFY_MAIL_REQ(?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss'),?,?)}");
			for(int t=0;t<list.size();t++)
			{
				requestSrlNo = (String) list.get(t);
				valueFromMap = (String) map.get(requestSrlNo);
				if(valueFromMap.indexOf("`") != -1)
				{
					strToken = new StringTokenizer(valueFromMap,"`");
					verify_flag = strToken.nextToken();
					reject_reason = strToken.nextToken();
				}
				else
				{
					verify_flag = valueFromMap;
					reject_reason = "";
				}

				ps.setString(1,requestSrlNo);
				rs = ps.executeQuery();
				while(rs.next())
				{
					moduleId = rs.getString("MODULE_ID") == null ? "" : rs.getString("MODULE_ID");
					reportId = rs.getString("REPORT_ID") == null ? "" : rs.getString("REPORT_ID");
					requestDate = rs.getString("REQUEST_DATE") == null ? "" : rs.getString("REQUEST_DATE");
					destLocnType = rs.getString("DEST_LOCN_TYPE") == null ? "" : rs.getString("DEST_LOCN_TYPE");
					destLocnCode = rs.getString("DEST_LOCN_CODE") == null ? "" : rs.getString("DEST_LOCN_CODE");
					reportFileName = rs.getString("REPORT_FILE_NAME") == null ? "" : rs.getString("REPORT_FILE_NAME");
					routingMode = rs.getString("ROUTING_MODE") == null ? "" : rs.getString("ROUTING_MODE");
					reportPriority = rs.getString("REPORT_PRIORITY") == null ? "" : rs.getString("REPORT_PRIORITY");
					attachmentRequiredYN = rs.getString("ATTACHMENT_REQUIRED_YN") == null ? "N" : rs.getString("ATTACHMENT_REQUIRED_YN");
					accessionNum = rs.getString("ACCESSION_NUM") == null ? "" : rs.getString("ACCESSION_NUM");
					mailCommDateTime = rs.getString("MAIL_COMM_DATE_TIME") == null ? "" : rs.getString("MAIL_COMM_DATE_TIME");
					patientId = rs.getString("PATIENT_ID") == null ? "" : rs.getString("PATIENT_ID");
					encounterId = rs.getString("ENCOUNTER_ID") == null ? "" : rs.getString("ENCOUNTER_ID");
					userId = rs.getString("USER_ID") == null ? "" : rs.getString("USER_ID");

					

					cs.setString(1,facilityId);
					cs.setString(2,moduleId);
					cs.setString(3,reportId);
					cs.setString(4,requestDate);
					cs.setString(5,destLocnType);
					cs.setString(6,destLocnCode);
					cs.setString(7,reportFileName);
					cs.setString(8,routingMode);
					cs.setString(9,reportPriority);
					cs.setString(10,attachmentRequiredYN);
					cs.setString(11,accessionNum);
					cs.setString(12,mailCommDateTime);
					cs.setString(13,requestSrlNo);
					cs.setString(14,patientId);
					cs.setString(15,encounterId);
					cs.setString(16,userId);
					cs.setString(17,verify_flag);
					cs.setString(18,rejectedBy);
					cs.setString(19,reject_reason);
					cs.execute();
				}
				if(rs != null) rs.close();
			}
			
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(cs != null) cs.close();

			con.commit();
			//String error_value = "1" ;
			String error = getMessage(locale,"RECORD_INSERTED","CA");
			//out.println("<script>self.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value="+error_value+"'</script>");
			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			out.println(error);
			out.println("<script>top.content.workAreaFrame.signRepCriteriaFrame.onSuccess()</script>");
			out.println("</BODY></html>");
		}//end of try
		catch (Exception e)
		{
			try
			{
				con.rollback();
			}
			catch (Exception ee)
			{
			}
			
			out.println("Exception at try-main of VerifySignReportServlet.java--"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(cs != null) cs.close();
				if(con != null) ConnectionManager.returnConnection(con,req);				
			}
			catch (Exception excep)
			{
			}
		}
	}//end of method

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }
}//end of class
