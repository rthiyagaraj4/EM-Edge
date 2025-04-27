/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 10:44 AM *****/
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

public class SuspendReinstatePatientServlet extends HttpServlet 
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

			String Action = req.getParameter("Action")==null ? "" : req.getParameter("Action");

			String Suspension_Remarks =req.getParameter("Suspension_Remarks")==null ? "" : req.getParameter("Suspension_Remarks");
			String Reinstatement_Remarks =req.getParameter("Reinstatement_Remarks")==null ? "" : req.getParameter("Reinstatement_Remarks");
			String Suspend_Yn = "";
			String Status_Remarks = "";
			if(Action.equals("Suspend")) {
				Suspend_Yn = "Y" ;
				Status_Remarks = Suspension_Remarks;
			}
			else {
				Suspend_Yn ="N" ;
				Status_Remarks = Reinstatement_Remarks;
			}

			String modifiedById = p.getProperty( "login_user" ) ;
			String modifiedFacilityId =(String) session.getValue( "facility_id" );
			String modifiedAtWorkstation=p.getProperty("client_ip_address");

			HashMap tabdata=new HashMap();
			
			tabdata.put("suspend_yn",Suspend_Yn);
			tabdata.put("status_reason_code",(req.getParameter("Reason")==null ? "" : req.getParameter("Reason")));
			tabdata.put("status_remarks",Status_Remarks);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			/*Added by Thamizh selvi on 10th Jan 2017 against MO-CRF-20119 Start*/

			con = ConnectionManager.getConnection(req);
			Boolean SuspReinstRelative = CommonBean.isSiteSpecific(con,"MP","SUSPEND_REINSTATE_RELATIONSHIP");

			HashMap condflds=new HashMap();

			if(SuspReinstRelative)
			{

				String alt_id1_no = null;
				String relationship_code = null;
				String relationship_to_head = null;

				stmt = con.createStatement();
				rs = stmt.executeQuery("select org_member_relationship_code from mp_param");

				if ( rs.next()  ) {
					relationship_code = rs.getString("org_member_relationship_code") == null? "" : rs.getString("org_member_relationship_code");
				}
				
				if(rs!=null)rs.close(); //Added for checkstyle
			    if(stmt!=null)stmt.close(); //Added for checkstyle
           
				String patient_id = req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id");
				
				stmt = con.createStatement();
				rs =  stmt.executeQuery("Select alt_id1_no, relationship_to_head from mp_patient where patient_id ='"+patient_id+"'");

				if (rs.next())
				{
					alt_id1_no = rs.getString("alt_id1_no") == null? "" : rs.getString("alt_id1_no");
					relationship_to_head = rs.getString("relationship_to_head") == null? "" : rs.getString("relationship_to_head");
				}
				
				if (relationship_code.equals(relationship_to_head))
				{
					condflds.put("alt_id1_no",alt_id1_no);
				}

				else
				{
					condflds.put("patient_id",patient_id);
				}
			}
			else
			{

				condflds.put("patient_id",(req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id")));
			}
			/*Added by Thamizh selvi on 11th Jan 2017 against MO-CRF-20119 End*/

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
				/* out.println(e.getMessage());
				out.println(e.toString()); */
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
