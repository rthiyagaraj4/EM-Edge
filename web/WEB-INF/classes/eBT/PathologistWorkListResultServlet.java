/*

*/

package eBT;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import eBT.*;
import eBT.resources.*;

import webbeans.eCommon.*;

public class PathologistWorkListResultServlet extends HttpServlet
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
		ResultSet rs=null;
		p = (java.util.Properties) session.getValue("jdbc") ;
		//Common-ICN-0045
		/* HashMap<String, Object> map = new HashMap<String, Object>();
		String locale		= (String) p.getProperty("LOCALE");
		String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
		String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address"); */
		//Common-ICN-0045
		String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
		
		
		String Remarks = request.getParameter("Remarks")==null ? "" :request.getParameter("Remarks");
		
		String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;	
		int counter = Integer.parseInt(count);
		
		boolean successFlag = false;
		
		String Pathologist_id=request.getParameter("assign_code") == null ? "" : request.getParameter("assign_code") ;
		
		String reportingFacilityId=request.getParameter("reporting_facility_id") == null ? "" : request.getParameter("reporting_facility_id");
		
		String updateSql="UPDATE RL_REQUEST_HEADER SET REPORTING_FACILITY_ID = ?, REPORTING_PATHOLOGIST_ID = ?, ASSIGN_PATHO_REMARKS= ?, ASSIGN_DATE = SYSDATE, ASSIGN_BY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID =? AND SPECIMEN_NO =?";
		
       try
		{

    	   con  = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateSql);
			int selectedCount = 0;
    	   for(int i=0;i<=counter;i++){
			   
				String check_status=request.getParameter("select"+i)==null ? "" :request.getParameter("select"+i);
				
				String operatingFacilityId=request.getParameter("operating_facility"+i)==null ? "" :request.getParameter("operating_facility"+i);//operating_facility

				String patientId=request.getParameter("patient_id_pass"+i)==null ? "" :request.getParameter("patient_id_pass"+i);//patient_id
			
				String specimenNo=request.getParameter("specimen_no_pass"+i)==null ? "" :request.getParameter("specimen_no_pass"+i);//specimen_no

				if(check_status.equals("Y")){
					pstmt.setString(1,reportingFacilityId);
					pstmt.setString(2,Pathologist_id);
					pstmt.setString(3,Remarks);
					pstmt.setString(4,addedById);
					pstmt.setString(5,operatingFacilityId);
					pstmt.setString(6,patientId);
					pstmt.setString(7,specimenNo);
					  pstmt.addBatch();
					  successFlag = true;
					  selectedCount++;
				}
				
				
			}		
			
			int result[] = pstmt.executeBatch();

				if(selectedCount==result.length){
					con.commit();
					String errorMsg= getMessage("en", "RECORD_INSERTED", "BT");
					System.out.println("----->errorMsg------>"+errorMsg);
					String error_value = "1" ;		
					response.sendRedirect("../eBT/jsp/NewProcedureMessage.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );				
				}
	} //try
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{}
			e.printStackTrace(System.err);
			out.println("Exception in try2 of PathologistWorkListResultServlet.java" +e.toString());
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
