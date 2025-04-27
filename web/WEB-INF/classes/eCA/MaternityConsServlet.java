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
import eCommon.XSSRequestWrapper;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eOP.StartCons.*;
import eOP.QmgmtRe_AssignPract.*;

public class MaternityConsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	public void init(ServletConfig cfg) throws ServletException
    {
        super.init(cfg);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		this.out = response.getWriter();
		try	{
		String mode=request.getParameter("mode");
		session 			= request.getSession(true);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		if(mode.equals("NEW"))
			updatespltyepisode(request,response);
		}catch(Exception e){
						out.println(e.toString());
			}
    }

	public void updatespltyepisode(HttpServletRequest request,HttpServletResponse response){
	String module_id=request.getParameter("module_id");
	String NewEvent=request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");
	String patient_id=request.getParameter("patient_id");	
	String splty_event_code=request.getParameter("splty_event_code");
	String addedById			= p.getProperty( "login_user" ) ;
	String modifiedById			= addedById ;
	String addedFacilityId		= facilityId;
	String modifiedFacilityId	= addedFacilityId ;
	String addedAtWorkstation	=client_ip_address;
	String modifiedAtWorkstation= addedAtWorkstation ;
	String queryString=request.getParameter("queryString");

	String additionalEventYN = "N";

	int cycle=Integer.parseInt(request.getParameter("cycle_no"));
	if(cycle==0)
		cycle=cycle+1;
	Connection connection		= null;
	PreparedStatement insrt_pstmt = null;
	PreparedStatement insrt_pstmt1 = null;
	String locale = p.getProperty("LOCALE");
	int instval=0;
	int instevntval=0;
	connection=ConnectionManager.getConnection(request);
	String insertSQL="INSERT INTO CA_PAT_SPLTY_EPISODE_HDR(PATIENT_ID,MODULE_ID,CYCLE_NO,CYCLE_START_DATE,CYCLE_END_DATE,START_SPLTY_EVENT_CODE,END_SPLTY_EVENT_CODE,CYCLE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,sysdate,'',?,'','O',?,sysdate,?,?,?,sysdate,?,?)";
	try{
		if(!NewEvent.equals("NewEvent"))
		{
			insrt_pstmt=connection.prepareStatement(insertSQL);
			insrt_pstmt.setString(1,patient_id);
			insrt_pstmt.setString(2,module_id);
			insrt_pstmt.setInt(3,cycle);
			insrt_pstmt.setString(4,splty_event_code);
			insrt_pstmt.setString(5,addedById);
			insrt_pstmt.setString(6,addedAtWorkstation);
			insrt_pstmt.setString(7,addedFacilityId);
			insrt_pstmt.setString(8,modifiedById);
			insrt_pstmt.setString(9,modifiedAtWorkstation);
			insrt_pstmt.setString(10,modifiedFacilityId);
			instval=insrt_pstmt.executeUpdate();
		}
		if(insrt_pstmt!=null)
			insrt_pstmt.close();
		if(instval>0 || NewEvent.equals("NewEvent")){
		connection.commit();
		try{
			String insert_evnt_SQL="INSERT INTO CA_PAT_SPLTY_EPISODE_EVENT(PATIENT_ID,MODULE_ID,CYCLE_NO,SPLTY_EVENT_CODE,SPLTY_EVENT_START_DATE,SPLTY_EVENT_END_DATE,SPLTY_EVENT_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDITIONAL_EVENT_YN) VALUES(?,?,?,?,sysdate,'','O',?,sysdate,?,?,?,sysdate,?,?,?)";
			insrt_pstmt1=connection.prepareStatement(insert_evnt_SQL);

			if(NewEvent.equals("NewEvent") && (splty_event_code.equals("MCE006") || splty_event_code.equals("MCE005")))
				additionalEventYN = "Y";
			else additionalEventYN = "N";

			insrt_pstmt1.setString(1,patient_id);
			insrt_pstmt1.setString(2,module_id);
			insrt_pstmt1.setInt(3,cycle);
			insrt_pstmt1.setString(4,splty_event_code);
			insrt_pstmt1.setString(5,addedById);
			insrt_pstmt1.setString(6,addedAtWorkstation);
			insrt_pstmt1.setString(7,addedFacilityId);
			insrt_pstmt1.setString(8,modifiedById);
			insrt_pstmt1.setString(9,modifiedAtWorkstation);
			insrt_pstmt1.setString(10,modifiedFacilityId);
			insrt_pstmt1.setString(11,additionalEventYN);
			instevntval=insrt_pstmt1.executeUpdate();
			if(insrt_pstmt1!=null)
				insrt_pstmt1.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	if(instevntval>0){
		connection.commit();
	if(connection!=null)
		connection.close();
	MessageManager mm=new MessageManager();
	final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
	//String msg=((String) mesg.get("message"));
	String msg="";
	mesg.clear();
	queryString="updated=Y&"+queryString;
	out.println("<script>parent.matFrame.maternityeventframe.location.href='../eCA/jsp/MaternityConsCycle.jsp?"+queryString+"';</script>");
	out.println("<script>parent.matFrame.maternitytreeframe.location.href='../eCA/jsp/MaternityConsMenu.jsp?"+queryString+"';</script>");
	//out.println("<script>parent.workAreaFrame.mattitleframe.location.href='../eCommon/html/blank.html';</script>");
	out.println("<script>parent.workArea.cols = '0%,24%,*,0%';</script>");
	out.println("<script>parent.workAreaFrame.matcycleframe.location.href='../eCommon/html/blank.html';</script>");
	//out.println("<script>parent.workAreaFrame.matactionframe.location.href='../eCommon/html/blank.html';</script>");
	//out.println("<script>alert(parent.workAreaFrame.matactionframe.name);</script>");
	out.println("<script>parent.messageFrame.location='../eCommon/jsp/error.jsp?err_num="+msg+"'</script>");
	}
	}else{
			connection.rollback();
	}
	}catch(Exception e){
	e.printStackTrace();
	}finally{
	try
	{
		if(connection!=null) { ConnectionManager.returnConnection(connection,p); }
	}
	catch(Exception e){e.printStackTrace();}
	}

	}
} // end of class CAOpenChartServlet
