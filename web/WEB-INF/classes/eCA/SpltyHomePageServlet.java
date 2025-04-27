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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eOP.StartCons.*;
import eOP.QmgmtRe_AssignPract.*;

public class SpltyHomePageServlet extends javax.servlet.http.HttpServlet
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
		this.out = response.getWriter();
		try	{
		session 			= request.getSession(true);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		updatesplty(request,response);
		}catch(Exception e){
						//out.println(e.toString());//common-icn-0181
						e.printStackTrace();//COMMON-ICN-0181
			}
    }

	public void updatesplty(HttpServletRequest request,HttpServletResponse response) throws Exception{

	String module_id=request.getParameter("module_id");
	String patient_id=request.getParameter("patient_id");
	String hist_rec_type=request.getParameter("hist_rec_type");
	int cycle=Integer.parseInt(request.getParameter("cycle_no"));
	int keyRef=Integer.parseInt(request.getParameter("keyRef"));
	String Rcount=request.getParameter("Rcount");
	String event_time_str="";
	String contr_sys_id="";
	String contr_sys_event_code="";
	String accession_num="";	
	String addedById			= p.getProperty( "login_user" ) ;
	String modifiedById			= addedById ;
	String addedFacilityId		= facilityId;
	String modifiedFacilityId	= addedFacilityId ;
	String addedAtWorkstation	=client_ip_address;
	String modifiedAtWorkstation= addedAtWorkstation ;
	Connection connection		= null;
	PreparedStatement insrt_pstmt = null;
	String locale = p.getProperty("LOCALE");
	String SQL_CA_SPLTY_CHECK_DUP="";
	int instval=0;
	int instevntval=0;
	String insertSQL="";
	try{
		connection=ConnectionManager.getConnection(request);
	for(int k=1;k<=Integer.parseInt(Rcount);k++)
		{
			event_time_str=request.getParameter("event_datetime_str"+k);
			contr_sys_id=request.getParameter("contr_sys_id"+k);
			contr_sys_event_code=request.getParameter("contr_sys_event_code"+k);
			accession_num=request.getParameter("accession_num"+k);
			
	
	instval=0;
	instevntval=0;
	
	SQL_CA_SPLTY_CHECK_DUP="SELECT COUNT(*) FROM CA_PAT_SPLTY_HIST_REF WHERE HIST_REC_TYPE =? AND CONTR_SYS_ID=? AND ACCESSION_NUM=? AND CONTR_SYS_EVENT_CODE=? ";
	String arrChkDup[]  =  new String[4] ;
	arrChkDup[0] = hist_rec_type ;
	arrChkDup[1] = contr_sys_id ;
	arrChkDup[2] = accession_num ;
	arrChkDup[3] = contr_sys_event_code ;
	boolean duplicate = chkDuplicate(SQL_CA_SPLTY_CHECK_DUP,connection,arrChkDup);

	if(!duplicate)
	{
	insertSQL="INSERT INTO CA_PAT_SPLTY_HIST_REF(HIST_REC_TYPE,CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE,PATIENT_ID,MODULE_ID,CYLE_NO,EVENT_DATE,KEY_REF,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYY HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,?)";
	try{
			insrt_pstmt=connection.prepareStatement(insertSQL);
			insrt_pstmt.setString(1,hist_rec_type);
			insrt_pstmt.setString(2,contr_sys_id);
			insrt_pstmt.setString(3,accession_num);
			insrt_pstmt.setString(4,contr_sys_event_code);
			insrt_pstmt.setString(5,patient_id);
			insrt_pstmt.setString(6,module_id);
			insrt_pstmt.setInt(7,cycle);
			insrt_pstmt.setString(8,event_time_str);
			insrt_pstmt.setInt(9,keyRef);
			insrt_pstmt.setString(10,addedById);
			insrt_pstmt.setString(11,addedAtWorkstation);
			insrt_pstmt.setString(12,addedFacilityId);
			insrt_pstmt.setString(13,modifiedById);
			insrt_pstmt.setString(14,modifiedAtWorkstation);
			insrt_pstmt.setString(15,modifiedFacilityId);
			instval=insrt_pstmt.executeUpdate();
		
		if(insrt_pstmt!=null)
			insrt_pstmt.close();
		if(instval>0){
		connection.commit();
		}
	}catch(Exception e){
	e.printStackTrace();
	}
	}
	}
	}
	catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(connection != null) ConnectionManager.returnConnection(connection,p);			
		}

	MessageManager mm=new MessageManager();
	final java.util.Hashtable mesg=mm.getMessage(locale,"RECORD_INSERTED","CA");
	String errorMsg= (String) mesg.get("message");
	out.println("<script>alert('"+errorMsg+"')</script>");
	out.println("<script>window.close();</script>");

	}

	public boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
try{
		boolean dupFlag = false ;
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}

		if(count > 0)
		dupFlag = true ;
		return dupFlag;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			 rs.close();
			pstmt.close() ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }

}//End of dulicate chk
} // end of class CAOpenChartServlet
