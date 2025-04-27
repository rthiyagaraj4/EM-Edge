/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

/*import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eCommon.Common.*;
import eOT.*;*/


import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;



public class PreOperativeServlet extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}


	public String checkForNull(String value){

		if( value ==null|| value.equals("null")||value.length()==0)
			return "";
		else
			 return value;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		Connection conn=null;
		String locale="";
		String msg="";
		MessageManager mm=new MessageManager();
		try{
			PreparedStatement pstmt=null;
			PreparedStatement pstmt1=null;
			PrintWriter out=res.getWriter();
			conn = ConnectionManager.getConnection(req);
			String sql="";
			String strBookingNum="";
			String strPatientId="";
			String strOrderLineNo="";
			String strOrderId="";
			String strOrderTypeCode="";
			String strDbType="";
			String strFacilityId="";
			String strClientAddress="";
			String login_user="";
			int index=0,cou=0;
			HttpSession session=req.getSession(true);
			strFacilityId	=""+session.getAttribute("facility_id");
			Properties p	=		(Properties)session.getAttribute ("jdbc");
			strClientAddress=""+p.getProperty("client_ip_address");
			login_user		=	""+p.getProperty("login_user");
			locale			=	""+p.getProperty("LOCALE");

			eOT.MasterXMLParse masterParse=new MasterXMLParse();
			InputSource inputSource=new InputSource(req.getReader());
			HashMap hashElement=masterParse.parseXMLData(inputSource,null,null,eOT.MasterXMLParse.DETAIL_ONLY);	
			ArrayList tabData=(ArrayList)hashElement.get("SEARCH");
			sql="INSERT INTO OT_BOOKING_LINKED_ORDERS(FACILITY_ID,PATIENT_ID,APPT_REF_NUM,ORDER_ID,ORDER_LINE_NUM,ORDER_TYPE_CODE,TRN_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID) VALUES(?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?)";
			pstmt=conn.prepareCall(sql);
			sql="delete from OT_BOOKING_LINKED_ORDERS where facility_id=? and patient_id=? and appt_ref_num=? and order_id=? and order_line_num=?";
			pstmt1=conn.prepareCall(sql);
			HashMap hashDtl;
			for(cou=0;cou<tabData.size();cou++){
				hashDtl=(HashMap)tabData.get(cou);
				strBookingNum=checkForNull(""+hashDtl.get("booking_no"));
				strPatientId=checkForNull(""+hashDtl.get("patient_id"));
				strOrderLineNo=checkForNull(""+hashDtl.get("lineno"));
				strOrderId=checkForNull(""+hashDtl.get("orderid"));
				strOrderTypeCode=checkForNull(""+hashDtl.get("order_code"));
				strDbType=checkForNull(""+hashDtl.get("db_type"));
				if(strDbType.equals("I")==true){
					index=0;
					pstmt.setString(++index,strFacilityId);
					//eOT.LogFile.log("OTDebugger","Facility"+strFacilityId,this);
					pstmt.setString(++index,strPatientId);
					//eOT.LogFile.log("OTDebugger","strPatientId"+strPatientId,this);
					pstmt.setString(++index,strBookingNum);
					//eOT.LogFile.log("OTDebugger","strBookingNum"+strBookingNum,this);
					pstmt.setString(++index,strOrderId);
					//eOT.LogFile.log("OTDebugger","strOrderId"+strOrderId,this);
					pstmt.setString(++index,strOrderLineNo);
					//eOT.LogFile.log("OTDebugger","strOrderLineNo"+strOrderLineNo,this);
					pstmt.setString(++index,strOrderTypeCode);
					//eOT.LogFile.log("OTDebugger","strOrderTypeCode"+strOrderTypeCode,this);
					pstmt.setString(++index,login_user);
					//eOT.LogFile.log("OTDebugger","login_user"+login_user,this);
					pstmt.setString(++index,strClientAddress);
					//eOT.LogFile.log("OTDebugger","strClientAddress"+strClientAddress,this);
					pstmt.setString(++index,strFacilityId);
					//eOT.LogFile.log("OTDebugger","Facility"+strFacilityId,this);
					pstmt.execute();
				}
			if(strDbType.equals("D")==true){
				 pstmt1.setString(1,strFacilityId);
				 pstmt1.setString(2,strPatientId);
				 pstmt1.setString(3,strBookingNum);
				 pstmt1.setString(4,strOrderId);
				 pstmt1.setString(5,strOrderLineNo);
				 pstmt1.execute();
			}
		}
		conn.commit();
		final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		msg = ((String) mesg.get("message"));
		out.println(msg);

		if(pstmt !=null) pstmt.close();
		if(pstmt1 !=null) pstmt1.close();
	}catch(Exception ee){
		//eOT.LogFile.log("OTDebugger","Exception in Update"+ee,this);
		try{
			conn.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
			msg = ((String) mesg.get("message"));
		}catch(Exception e){}
	}finally{
			if(conn!=null)
			ConnectionManager.returnConnection(conn, req);
	}

}

}
