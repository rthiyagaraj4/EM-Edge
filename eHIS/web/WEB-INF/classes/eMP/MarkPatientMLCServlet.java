/******
CRF/SCF Reference No 	:  ML-MMOH-CRF-1955
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  1-07-2023
Purpose of the Script   :  Mark Patient as Medico Legal Case (MLC) Patient and to revert the MLC marked patient as Non-MLC patient 				   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
***/
package eMP;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import javax.rmi.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;

import eCommon.SingleTabHandler.*;

public class MarkPatientMLCServlet extends HttpServlet 
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		PrintWriter out=null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			out = res.getWriter();
			String action = req.getParameter("Action")==null ? "" : req.getParameter("Action");
			String mlc_reason = req.getParameter("Reason")==null ? "" : req.getParameter("Reason");
			String modifiedById = p.getProperty( "login_user" ) ;
			String modifiedFacilityId =(String) session.getValue( "facility_id" );
			String modifiedAtWorkstation=p.getProperty("client_ip_address");
			HashMap tabdata=new HashMap();			
			tabdata.put("MLC_YN",action);
			tabdata.put("MLC_REASON",mlc_reason);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			con = ConnectionManager.getConnection(req);
			HashMap condflds=new HashMap();
			condflds.put("patient_id",(req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id")));
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_patient";
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			error = (String) results.get("error") ;
			results.clear();
			if ( inserted )
			{
				error_value = " " ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+error_value+"&err_value=1");
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch (Exception e)	{
			out.println(e.getMessage());
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
			{	
			if(con != null) ConnectionManager.returnConnection(con,req);
			}
	}	
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		else
			return false;
	}
}
