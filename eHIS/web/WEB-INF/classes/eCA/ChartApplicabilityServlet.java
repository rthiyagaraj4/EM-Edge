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
//import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
//import webbeans.eCommon.MessageManager;
import eCommon.SingleTabHandler.*;
 public class ChartApplicabilityServlet extends HttpServlet
 {

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public  void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	 {  request.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		String mode = request.getParameter("mode") == null ? "" :  request.getParameter("mode");
		if(mode.equals("insert"))
				insert(request,response, out);
		if(mode.equals("modify"))
				modify(request, out);
		if(mode.equals("delete"))
				delete(request, out);


	 }
/**
*	delete	-	will be called when the mode value is delete
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	 void delete(HttpServletRequest request, PrintWriter out)	
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
//			ResultSet rs;
			String patientClass = "";
			String errVal = "0";
			String specialtyCode = "";
			//int count = 0;
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
			String	practType = "";
			String locationType = "";
			String locationCode = "";
			String  ageGrpCode = "";
			String chartId = "";
			String errorMsg = "";
			String dispSeqNo = "";//IN040032
			try{
					con = ConnectionManager.getConnection(request);
					patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
					specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");
					practType =  request.getParameter("specialtyCode") == null ? "" :  request.getParameter("practTypeCode");
					locationType = 	request.getParameter("locationType") == null ? "" :  request.getParameter("locationType");
					locationCode = request.getParameter("locationCode") == null ? "" :  request.getParameter("locationCode");
					ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");
					chartId =  request.getParameter("chartCode") == null ? "" :  request.getParameter("chartCode");
					//IN040032 Starts
					dispSeqNo = request.getParameter("dispSeqNo") == null ? "" : request.getParameter("dispSeqNo");
					
					if("".equals(dispSeqNo))
					{
						dispSeqNo = "0";
					}
					//ps = con.prepareStatement("delete from    CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? and  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ? and chart_id=? ");
					ps = con.prepareStatement("delete from    CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? and  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ? and chart_id=? AND NVL (disp_seq_no, '0') = ? ");
					ps.setString(1,patientClass);
					ps.setString(2,specialtyCode);
					ps.setString(3,practType);
					ps.setString(4,locationType);
					ps.setString(5,locationCode);
					ps.setString(6,ageGrpCode);
					ps.setString(7,chartId);
					ps.setString(8,dispSeqNo);
					//IN040032 Ends
					int deleted = ps.executeUpdate();
					if(deleted != 0)
					{
						tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
						con.commit();
						out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");
						}
						else
						{
						tabdata = MessageManager.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","Common");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
							out.println("<script>parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.disabled=true</script>");
							out.println("<script>parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.disabled=true</script>");
							out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");		
						}
					if(ps != null) ps.close();
				}
			catch(Exception ee)
			{
				//out.println("Exception raise by Chart Applicability Servlet ...So Record Not Deleted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
					
						if(con != null) ConnectionManager.returnConnection(con);
				
			}
	 }
 /**
*	insert	-	will be called when the mode value is insert
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)		
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs;
			String patientClass = "";
			String errVal = "0";
			String specialtyCode = "";
			int count = 0;
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
			String	practType = "";
			String locationType = "";
			String locationCode = "";
			String  ageGrpCode = "";
			String chartId = "";
			String errorMsg = "";
			String dispSeqNo = "";//IN040032
			int updated = 0;
			boolean result = false;
			int index=0;
			try{
				con = ConnectionManager.getConnection(request);
				//int counter=0;//Checkstyle
				patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
				specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");
				practType =  request.getParameter("specialtyCode") == null ? "" :  request.getParameter("practTypeCode");
				locationType = 	request.getParameter("locationType") == null ? "" :  request.getParameter("locationType");
				locationCode = request.getParameter("locationCode") == null ? "" :  request.getParameter("locationCode");
				ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");
				chartId =  request.getParameter("chartCode") == null ? "" :  request.getParameter("chartCode");
				//IN040032 Start
				dispSeqNo = request.getParameter("dispSeqNo") == null ? "" : request.getParameter("dispSeqNo");
				
				ps = con.prepareStatement("select chart_id from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ?  and chart_id = ? ");
				
				//ps = con.prepareStatement("select chart_id from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ?  and chart_id = ? and DISP_SEQ_NO = ?");
				
				ps.setString(1,patientClass);
				ps.setString(2,specialtyCode);
				ps.setString(3,practType);
				ps.setString(4,locationType);
				ps.setString(5,locationCode);
				ps.setString(6,ageGrpCode);
				
					ps.setString(7,chartId);
					//ps.setString(8,dispSeqNo);
				
				
				//IN040032 Ends
				rs = ps.executeQuery();
				while(rs.next())
				{
					count ++;
				}
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				
				/*ps = con.prepareStatement("select 1 from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ? and chart_id = ? ");//Niji
				
				//ps = con.prepareStatement("select 1 from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ? and chart_id = ? and DISP_SEQ_NO = ?");//Niji	
				
				ps.setString(1,patientClass);
				ps.setString(2,specialtyCode);
				ps.setString(3,practType);
				ps.setString(4,locationType);
				ps.setString(5,locationCode);
				ps.setString(6,ageGrpCode);
				
				ps.setString(7,chartId);
				//ps.setString(8,dispSeqNo);
				rs = ps.executeQuery();
				while(rs.next())
				{
					counter++;
				}
				if(ps != null)ps.close();
				if(rs != null)rs.close();*/

				if(count == 0)
				{
					//ps = con.prepareStatement("insert into CA_CHART_APPLICABLITY (PATIENT_CLASS, SPECIALITY_CODE, PRACT_TYPE, LOCN_TYPE_IND, LOCN_CODE, AGE_GROUP_CODE, CHART_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,facility_id) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?) ");//IN040032
					ps = con.prepareStatement("insert into CA_CHART_APPLICABLITY (PATIENT_CLASS, SPECIALITY_CODE, PRACT_TYPE, LOCN_TYPE_IND, LOCN_CODE, AGE_GROUP_CODE, CHART_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,facility_id) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?) ");//IN040032
					ps.setString(1,patientClass);
					ps.setString(2,specialtyCode);
					ps.setString(3,practType);
					ps.setString(4,locationType);
					ps.setString(5,locationCode);
					ps.setString(6,ageGrpCode);
					ps.setString(7,chartId);
					ps.setString(8,addedId);
					ps.setString(9,client_ip_addr);
					ps.setString(10,facilityId);
					ps.setString(11,addedId);
					ps.setString(12,client_ip_addr);
					ps.setString(13,facilityId);
					ps.setString(14,facilityId);
					//ps.setString(15,dispSeqNo);//IN040032
					int inserted = ps.executeUpdate();
					if(inserted > 0)
					{
						result = true;
					}
					if(rs != null)rs.close();
					if(ps != null)ps.close();
					
					if(!"".equals(dispSeqNo) && result)
					{
						ps = con.prepareStatement("select chart_id from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ?  and DISP_SEQ_NO = ?");
						ps.setString(1,patientClass);
						ps.setString(2,specialtyCode);
						ps.setString(3,practType);
						ps.setString(4,locationType);
						ps.setString(5,locationCode);
						ps.setString(6,ageGrpCode);
						
						//ps.setString(7,chartId);
						ps.setString(7,dispSeqNo);//Niji
						rs = ps.executeQuery();
						while(rs.next())
						{
							index++;
						}
						if(rs != null)rs.close();
						if(ps != null)ps.close();
						if(index == 0)
						{
							
							ps = con.prepareStatement("update CA_CHART_APPLICABLITY set DISP_SEQ_NO = ? where PATIENT_CLASS=? and SPECIALITY_CODE=? and  PRACT_TYPE=? and LOCN_TYPE_IND=? and LOCN_CODE=? and  AGE_GROUP_CODE=? and CHART_ID=? ");
							
							ps.setString(1,dispSeqNo);
							ps.setString(2,patientClass);
							ps.setString(3,specialtyCode);
							ps.setString(4,practType);
							ps.setString(5,locationType);
							ps.setString(6,locationCode);
							ps.setString(7,ageGrpCode);
							ps.setString(8,chartId);
							updated = ps.executeUpdate();
							if(updated > 0)
							{
								result = true;
							}
							
						}
						else
						{
							
							result = false;
							con.rollback();
							tabdata = MessageManager.getMessage(locale, "DUP_ENT_NOT_ALLOWED","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "0";
						}
					}
					
					
					if(result)
					{
					
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
					}
					else
					{
						
						con.rollback();
						tabdata = MessageManager.getMessage(locale, "DUP_ENT_NOT_ALLOWED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
					}
				}
				else
				{
						
						con.rollback();
						tabdata = MessageManager.getMessage(locale, "DUP_ENT_NOT_ALLOWED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
				}
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				if(rs != null) rs.close();
				if(ps != null) ps.close();

			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Chart Applicability Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
				
					
			if(con != null) ConnectionManager.returnConnection(con);
				
				
			}
			
	 }	
 /**
*	modify	-	will be called when the mode value is modify
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	void modify(HttpServletRequest request, PrintWriter out)
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs;//IN040032
			String patientClass = "";
			String errVal = "0";//IN040032
			String specialtyCode = "";
		//	int count = 0;
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
			String	practType = "";
			String locationType = "";
			String locationCode = "";
			String  ageGrpCode = "";
			String chartId = "";
			String errorMsg = "";
			int count = 0;//IN040032
			
			try
			{
				con = ConnectionManager.getConnection(request);
				patientClass = request.getParameter("patientClass") == null ? "" :  request.getParameter("patientClass");
				specialtyCode = request.getParameter("specialtyCode") == null ? "" :  request.getParameter("specialtyCode");
				practType =  request.getParameter("specialtyCode") == null ? "" :  request.getParameter("practTypeCode");
				locationType = 	request.getParameter("locationType") == null ? "" :  request.getParameter("locationType");
				locationCode = request.getParameter("locationCode") == null ? "" :  request.getParameter("locationCode");
				ageGrpCode =  request.getParameter("ageGrpCode") == null ? "" :  request.getParameter("ageGrpCode");

				chartId =  request.getParameter("chartCode") == null ? "" :  request.getParameter("chartCode");
				String oldChartId = request.getParameter("oldChartCode") == null ? "" :  request.getParameter("oldChartCode");
				//IN040032 Start
				String dispSeqNo = request.getParameter("dispSeqNo") == null ? "" : request.getParameter("dispSeqNo");
				String oldDispSeqNo = request.getParameter("oldDispSeqNo") == null ? "" : request.getParameter("oldDispSeqNo");
				
				
				if("".equals(oldDispSeqNo))
				{
					oldDispSeqNo = "0";
				}
				
				if("".equals(dispSeqNo))
				{
					ps = con.prepareStatement("select chart_id from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ?  and chart_id = ? AND NVL(disp_seq_no,'0') = ?");
				}
				else
				{
					ps = con.prepareStatement("select chart_id from  CA_CHART_APPLICABLITY where PATIENT_CLASS = ?  and SPECIALITY_CODE=? And  PRACT_TYPE =? And  LOCN_TYPE_IND =? And  LOCN_CODE = ? and  AGE_GROUP_CODE = ?  and DISP_SEQ_NO = ?");
				}
				ps.setString(1,patientClass);
				ps.setString(2,specialtyCode);
				ps.setString(3,practType);
				ps.setString(4,locationType);
				ps.setString(5,locationCode);
				ps.setString(6,ageGrpCode);
				if("".equals(dispSeqNo))
				{
					ps.setString(7,chartId);
					ps.setString(8,dispSeqNo);
				}
				else
				{
					ps.setString(7,dispSeqNo);
				}
				rs = ps.executeQuery();
				while(rs.next())
				{
					count ++;
				}
				if(ps != null)ps.close();
				if(rs != null)rs.close();
				
		
				if(count == 0 )
				{//IN040032 Ends
				
					ps = con.prepareStatement("update CA_CHART_APPLICABLITY set CHART_ID =?,MODIFIED_BY_ID = ?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, FACILITY_ID=? ,DISP_SEQ_NO = ? where PATIENT_CLASS=? and SPECIALITY_CODE=? and  PRACT_TYPE=? and LOCN_TYPE_IND=? and LOCN_CODE=? and  AGE_GROUP_CODE=? and CHART_ID=?");
					

					ps.setString(1,chartId);
					ps.setString(2,addedId);
					ps.setString(3,client_ip_addr);
					ps.setString(4,facilityId);
					ps.setString(5,facilityId);
					//IN040032 Start
					ps.setString(6,dispSeqNo);
					/*ps.setString(6,patientClass);
					ps.setString(7,specialtyCode);
					ps.setString(8,practType);
					ps.setString(9,locationType);
					ps.setString(10,locationCode);
					ps.setString(11,ageGrpCode);
					ps.setString(12,oldChartId);*/
					ps.setString(7,patientClass);
					ps.setString(8,specialtyCode);
					ps.setString(9,practType);
					ps.setString(10,locationType);
					ps.setString(11,locationCode);
					ps.setString(12,ageGrpCode);
					ps.setString(13,oldChartId);
					//ps.setString(14,oldDispSeqNo);
					//IN040032 End
					int updated  = ps.executeUpdate();
					
						if(updated != 0)
						{
							
							con.commit();
							tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
							errorMsg= (String) tabdata.get("message");
							
							//errVal = "1";
						}
				}//IN040032 Starts
				else
				{
						con.rollback();
						tabdata = MessageManager.getMessage(locale, "DUP_ENT_NOT_ALLOWED","CA");
						errorMsg= (String) tabdata.get("message");
						
						errVal = "0";
				}
				//IN040032 Ends
				out.println("<script>parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.disabled=true</script>");
				out.println("<script>parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.disabled=true</script>");
				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"'</script>");
			if(ps != null) ps.close();
			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Chart Applicability Servlet ...So Record Not Updated  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
				
						if(con != null) ConnectionManager.returnConnection(con);
				
			}

	 }
 }
