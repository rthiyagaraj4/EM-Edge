
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		GHL-CRF-0487 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/

package eOR;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import webbeans.eCommon.*;

public class TeleRadiologyResultServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		java.util.Properties p;
		HttpSession session;
		String sStyle = "";

		out = response.getWriter();
		session = request.getSession(false);

		sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p = (java.util.Properties) session.getValue("jdbc") ;

			insertRecord(request,response,out,p,session);
		
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	private void insertRecord(HttpServletRequest request,HttpServletResponse response, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		CallableStatement cs = null;
		//HashMap<String, Object> map = new HashMap<String, Object>();  //COMMON-ICN-0122
		ResultSet rs=null;
		p = (java.util.Properties) session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");
		
		String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
		//String practitionerId = (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");  //COMMON-ICN-0122
		String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
		String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
		String Remarks = request.getParameter("Remarks")==null ? "" :request.getParameter("Remarks");
		String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;
		int counter = Integer.parseInt(count);
		boolean successFlag = false;
		String radiologistId=request.getParameter("assigned_pract_code") == null ? "" : request.getParameter("assigned_pract_code") ;
		String operatingFacilityId="";
		
		String reportingFacilityId=request.getParameter("reporting_facility_id") == null ? "" : request.getParameter("reporting_facility_id");
		String requestNum="";//request_num
		String requestLineNum="";//request_line_num
		
		String updateSql="UPDATE RD_EXAM_VIEW_REQUESTED SET RADIOLOGIST_ID = ?,REPORTING_FACILITY_ID = ?,REPORTING_RADIOLOGIST_ID = ?,ASSIGN_RAD_REMARKS= ?,ASSIGN_DATE = SYSDATE,ASSIGN_BY_ID = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND REQUEST_NUM = ? AND REQUEST_LINE_NUM = ?";
       try
		{
    	   con  = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateSql);
			int selectedCount = 0;
    	   for(int i=0;i<=counter;i++){
				String check_status=request.getParameter("select"+i)==null ? "" :request.getParameter("select"+i);
				 operatingFacilityId=request.getParameter("operating_facility"+i)==null ? "" :request.getParameter("operating_facility"+i);//operating_facility
				 requestNum=request.getParameter("request_num"+i)==null ? "" :request.getParameter("request_num"+i);//request_num
				 requestLineNum=request.getParameter("request_line_num"+i)==null ? "" :request.getParameter("request_line_num"+i);//request_line_num
				if(check_status.equals("Y")){
					pstmt.setString(1,radiologistId);
					pstmt.setString(2,reportingFacilityId);
					pstmt.setString(3,radiologistId);
					pstmt.setString(4,Remarks);
					pstmt.setString(5,addedById);
					pstmt.setString(6,addedById);
					pstmt.setString(7,addedAtWSNo);
					pstmt.setString(8,facilityId);
					pstmt.setString(9,operatingFacilityId);
					pstmt.setString(10,requestNum);
					pstmt.setString(11,requestLineNum);
		              pstmt.addBatch();
		               successFlag = true;
		               selectedCount++;
				}
			}
		
			System.out.println("---selectedCount-------------->"+selectedCount);
			int result[] = pstmt.executeBatch();
			System.out.println("---result-------------->"+result.length);
			//if(successFlag){
			if(selectedCount==result.length){
				con.commit();
				String errorMsg= getMessage(locale, "RECORD_INSERTED","OR");
				String error_value = "1" ;				
				response.sendRedirect("../eOR/jsp/NewProcedureMessage.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
			
			}
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{}
			e.printStackTrace(System.err);
			out.println("Exception in try2 of TeleRadiologyResultServlet.java" +e.toString());
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
				if(cs!=null)cs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)
					ConnectionManager.returnConnection(con,p);
			}
			catch(Exception e)
			{}
		}
		
		
	}


}
