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
import eOT.*;
import javax.rmi.* ;
import javax.naming.*;
import eOT.Booking.*;*/

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;

public class WaitListServlet extends javax.servlet.http.HttpServlet
{

public void init(ServletConfig config) throws ServletException
	{
	super.init(config);
	}


public void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
	{

//Added Against MMS Vulnerability Issue - Starts
req= new XSSRequestWrapper(req);
res.addHeader("X-XSS-Protection", "1; mode=block");
res.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

Connection conn=null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
CallableStatement cstmt = null;
CallableStatement cstmt1 = null;

try	{
req.setCharacterEncoding("UTF-8");
res.setContentType("text/html;charset=UTF-8");
PrintWriter out=res.getWriter();
////eOT.LogFile.log("OTDebugger","Entering in Servlet",this);
String strClientAddress="";
String strFacilityId="";
String login_user="";
String locale="";
String strStatus="";
String strErrorMsg="";
String strErrMsg="";
String strDuration="";
//String strPatientClass="";
//String strEpisodeType="";
//String strVisitId="";
String strOrderId="";
String strBookingNum="";
String strSpecialityCode="";
String sql="";
String sql1="";
String strCancel="";
String strCancelReason="";
String strCancelBy="";
//String strCancelDate=""; commented for V3
String strStartTime="";
String strSurgeonCode="";
String strRoomCode="";
String strBookingDate="";
String strBookingDate1="";
String strPatientId="";
String strCancelOrder="";
String strOperationCode="";
String strMultipleOperYN="";
String strCancelDesc="";
String strWaitListNo="";
String asstSurgeonCode="";

String strSubFunction="";
String strPreferredDate="";
String wardInformedDateTime="";
String cancelledRemarks="";

String err_code="";
String err_text="";
String lang_err_msg_id="";
String sys_message_id="";
String err_desc="";

String over_booking_case_yn="";

String strHour,strMin;

int hour=0,min=0;


strOrderId=CommonBean.checkForNull(req.getParameter("orderid"));
asstSurgeonCode=CommonBean.checkForNull(req.getParameter("asst_surgeon_code"));
strBookingNum=CommonBean.checkForNull(req.getParameter("booking_no"));
strCancel=CommonBean.checkForNull(req.getParameter("cancel"));
over_booking_case_yn=CommonBean.checkForNull(req.getParameter("over_booking_case_yn"));//Sanjay
//System.out.println("WaitListServlet.java over_booking_case_yn: " + over_booking_case_yn);//Sanjay

String wardInformedYN=CommonBean.checkForNull(req.getParameter("ward_informed_yn"));
if("Y".equals(wardInformedYN)){
	wardInformedDateTime=CommonBean.checkForNull(req.getParameter("ward_informed_date_time"));
	cancelledRemarks=CommonBean.checkForNull(req.getParameter("cancelled_remarks"));
}

strCancelOrder=CommonBean.checkForNull(req.getParameter("cancel_order"));
strSubFunction=CommonBean.checkForNull(req.getParameter("subfunction"));
String function_id=CommonBean.checkForNull(req.getParameter("function_id"));
if( function_id.equals("OT_TO_BE_RESCHD_CASES")) {
	function_id="Y";
}else
	{
	function_id="N";

}

//eOT.LogFile.log("OTDebugger","strSubFunction"+strSubFunction,this);


HttpSession session=req.getSession(true);
String langstrMessage="";
strFacilityId=""+session.getAttribute("facility_id");
Properties p=(Properties)session.getAttribute("jdbc");
strClientAddress=""+p.getProperty("client_ip_address");
login_user=""+p.getProperty("login_user");
locale=""+p.getProperty("LOCALE");
conn=ConnectionManager.getConnection(req);


 //cstmt=conn.prepareCall("{ call OT_UPDATE_BOOKING_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?)}");
 cstmt=conn.prepareCall("{ call OT_UPDATE_BOOKING_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
 cstmt1=conn.prepareCall("{ call OT_CAN_OPER_CHARGES (?,?,?,?,?,?,?,?)}");// For Cancel Billing record when cancelling the order(cancel check box in cancel appointment screen is checked only).
if(strOrderId.length()>0&&strBookingNum.length()==0)
{
	////eOT.LogFile.log("OTDebugger","SQL "+sql,this);
	////eOT.LogFile.log("OTDebugger","strOrderId "+strOrderId,this);
				//sql1 = "SELECT SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'hh24'))) HOUR1,SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'mi'))) MIN1 FROM OT_PENDING_ORDERS_DTL_VW  where order_id=?";
				sql1 = "SELECT nvl(SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'hh24'))),'0') HOUR1,nvl(SUM(TO_NUMBER(TO_CHAR(OPER_DURN,'mi'))),'0') MIN1 FROM OT_PENDING_ORDERS_DTL_VW  where order_id=?";//CRF-186(Unable to wailist)
	try
	{
		pstmt=conn.prepareStatement(sql1);
		pstmt.setString(1,strOrderId);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			hour=Integer.parseInt(rs.getString("HOUR1"));
			min=Integer.parseInt(rs.getString("MIN1"));
		}
		rs.close();
		pstmt.close();
	}
	catch(Exception ee)
	{
			ee.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	hour+=min/60;
	min%=60;
	strHour="";
	strMin="";

	if(hour<10)
		strHour="0"+hour;
	else
		strHour+=hour;
	if(min <10) 
		strMin="0"+min;
	else
		strMin=""+min;

	strDuration="01/03/05 "+strHour+":"+strMin;

	sql="SELECT PERFORMING_FACILITY_ID PERFORMING_FACILITY_ID1,NATURE_TYPE NATURE_TYPE1,ORDER_ID ORDER_ID1, ORDER_TYPE_CODE ORDER_TYPE_CODE1,to_char(PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1,TEAM_DOCTOR_IND TEAM_DOCTOR_IND1, PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1, PATIENT_ID PATIENT_ID1,ADMISSION_DATE ADMISSION_DATE1, DISCHARGE_DATE DISCHARGE_DATE1, EPISODE_ID EPISODE_ID1, PATIENT_CLASS PATIENT_CLASS1, ENCOUNTER_ID ENCOUNTER_ID1, EPISODE_TYPE EPISODE_TYPE1, VISIT_ID VISIT_ID1, SURGERY_NATURE SURGERY_NATURE1,SPECIALITY_CODE SPECIALITY_CODE1, REF_SOURCE_TYPE REF_SOURCE_TYPE1, REF_SOURCE_CODE REF_SOURCE_CODE1,ANAESTHESIA_CODE ANAESTHESIA_CODE1, ANAESTHETIST_CODE ANAESTHETIST_CODE1, PATIENT_POSITION PATIENT_POSITION1 FROM OT_PENDING_ORDERS_VW WHERE ORDER_ID =?";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,strOrderId);
	rs=pstmt.executeQuery();
	HashMap headerDtl=new HashMap();
	if(rs.next()==true)
	{
		headerDtl.put("patient_id",CommonBean.checkForNull(rs.getString("PATIENT_ID1")));
		headerDtl.put("episode_id",CommonBean.checkForNull(rs.getString("EPISODE_ID1")));
		headerDtl.put("encounter_id",CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1")));
		headerDtl.put("patient_class",CommonBean.checkForNull(rs.getString("PATIENT_CLASS1")));
		headerDtl.put("episode_type",CommonBean.checkForNull(rs.getString("EPISODE_TYPE1")));
		headerDtl.put("visitid",CommonBean.checkForNull(rs.getString("VISIT_ID1")));
		headerDtl.put("SPECIALITY_CODE",CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1")));
		headerDtl.put("orderid",CommonBean.checkForNull(rs.getString("ORDER_ID1")));
		headerDtl.put("booking_date",CommonBean.checkForNull(rs.getString("PREF_SURG_DATE1")));
		headerDtl.put("start_time","");
		headerDtl.put("roomCode","");
		headerDtl.put("REMARKS","");
		headerDtl.put("surgeonCode",CommonBean.checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1")));
		headerDtl.put("natureType",CommonBean.checkForNull(rs.getString("NATURE_TYPE1")));
		headerDtl.put("natureCode",CommonBean.checkForNull(rs.getString("SURGERY_NATURE1")));
		headerDtl.put("sourceDesc",CommonBean.checkForNull(rs.getString("REF_SOURCE_TYPE1")));
		headerDtl.put("sourceType",CommonBean.checkForNull(rs.getString("REF_SOURCE_CODE1")));
		headerDtl.put("Anaesthetia_code",CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1")));
		headerDtl.put("Anaesthetiest_code",CommonBean.checkForNull(rs.getString("ANAESTHETIST_CODE1")));
		headerDtl.put("Patient_position",CommonBean.checkForNull(rs.getString("PATIENT_POSITION1")));
		headerDtl.put("trn_type","W");
		headerDtl.put("waitlistyn","N");
		cstmt.setString(1,strFacilityId);
		cstmt.setString(2,""+headerDtl.get("patient_id"));
		cstmt.setString(3,""+headerDtl.get("episode_id"));
		cstmt.setString(4,""+headerDtl.get("encounter_id"));
		cstmt.setString(5,""+headerDtl.get("patient_class"));
		cstmt.setString(6,""+headerDtl.get("episode_type"));
		cstmt.setString(7,""+headerDtl.get("visitid"));
		cstmt.setString(8,""+headerDtl.get("SPECIALITY_CODE"));
		cstmt.setString(9,""+headerDtl.get("orderid"));
		cstmt.setString(10,""+headerDtl.get("booking_date"));
		cstmt.setString(11,"");
		cstmt.setString(12,""+headerDtl.get("start_time"));
		cstmt.registerOutParameter(13,Types.VARCHAR);
		cstmt.setString(14,("Y".equals(over_booking_case_yn))?"OVERBOOK":strDuration);
		cstmt.setString(15,""+headerDtl.get("roomCode"));
		cstmt.setString(16,""+headerDtl.get("surgeonCode"));
		cstmt.setString(17,""+headerDtl.get("natureType"));
		cstmt.setString(18,""+headerDtl.get("natureCode"));
		cstmt.setString(19,""+headerDtl.get("sourceType"));
		cstmt.setString(20,""+headerDtl.get("sourceDesc"));
		cstmt.setString(21,""+headerDtl.get("Anaesthetia_code"));
		cstmt.setString(22,""+headerDtl.get("Anaesthetiest_code"));
		cstmt.setString(23,""+headerDtl.get("Patient_position"));
		cstmt.setString(24,""+headerDtl.get("REMARKS"));
		cstmt.registerOutParameter(25,Types.VARCHAR);
		cstmt.setString(26,"W");
		cstmt.setString(27,"");
		cstmt.registerOutParameter(28,Types.VARCHAR);
		cstmt.registerOutParameter(29,Types.VARCHAR);
		cstmt.setString(30,login_user);
		cstmt.setString(31,strClientAddress);
		if(strOrderId.length()>0)	
			cstmt.setString(32,"Y");
		else 
			cstmt.setString(32,"");
		cstmt.setString(33,"");
		cstmt.setString(34,"");
		cstmt.setString(35,"");
		cstmt.setString(36,"");
		cstmt.setString(37,"");
		cstmt.setString(38,"");
		cstmt.setString(39,"");
		cstmt.setString(40,"");
		cstmt.setString(41,"");
		cstmt.setString(42,"");
		cstmt.setString(43,"");
		cstmt.setString(44,"");
		cstmt.setString(45,asstSurgeonCode);
		cstmt.setString(47,function_id);
		// Newly Added LANG_ERR_MSG_ID
		cstmt.registerOutParameter(46,Types.VARCHAR);
		//out.println("<script>alert('before execute 111111111')</script>");
		cstmt.executeQuery();
		//out.println("<script>alert('after execute 11111111111')</script>");
		strBookingNum=cstmt.getString(25);
		strStatus=cstmt.getString(28);
		strErrorMsg=cstmt.getString(29);
		langstrMessage=cstmt.getString(46);
		if(strStatus.equalsIgnoreCase("E")==true)
		{
			strErrMsg=strErrorMsg;	
			conn.rollback();
			out.println(langstrMessage);
		}
	}
	rs.close();
	if(strStatus.equalsIgnoreCase("S")==true)
	{
		conn.commit();
		out.println("APP-OT0106");
	}
}
else if(strBookingNum.length()>0 && strCancel.equals("true"))
{
	//out.println("<script>alert('else iffff2222222222')</script>");
	//eOT.LogFile.log("OTDebugger"," Enter in cancellation",this);
	strCancelReason=CommonBean.checkForNull(req.getParameter("cancel_reason"));
	strCancelDesc=CommonBean.checkForNull(req.getParameter("cancel_desc"));
	strCancelBy=CommonBean.checkForNull(req.getParameter("cancel_by"));
	//strCancelDate=CommonBean.checkForNull(req.getParameter("cancel_date")); commented for v3
	strBookingDate=CommonBean.checkForNull(req.getParameter("booking_date"));
	strStartTime=CommonBean.checkForNull(req.getParameter("start_time"));
	cstmt.setString(1,strFacilityId);
	cstmt.setString(2,"");
	cstmt.setString(3,"");
	cstmt.setString(4,"");
	cstmt.setString(5,"");
	cstmt.setString(6,"");
	cstmt.setString(7,"");
	cstmt.setString(8,"");
	if(strCancelOrder.equals("true")&&strOrderId.length()>0)
	{
		cstmt.setString(9,strOrderId);
		cstmt.setString(27,"CO");
	}
	else
	{
		cstmt.setString(9,"");
		cstmt.setString(27,"");
	}
	cstmt.setString(10,"");
	cstmt.setString(11,"");
	cstmt.setString(12,"");
	cstmt.registerOutParameter(13,Types.VARCHAR);
	cstmt.setString(14,"");
	cstmt.setString(15,"");
	cstmt.setString(16,"");
	cstmt.setString(17,"");
	cstmt.setString(18,"");
	cstmt.setString(19,"");
	cstmt.setString(20,"");
	cstmt.setString(21,"");
	cstmt.setString(22,"");
	cstmt.setString(23,"");
	cstmt.setString(24,"");
	cstmt.setString(25,strBookingNum);
	cstmt.setString(26,"C");
	cstmt.registerOutParameter(28,Types.VARCHAR);
	cstmt.registerOutParameter(29,Types.VARCHAR);
	cstmt.setString(30,login_user);
	cstmt.setString(31,strClientAddress);
	cstmt.setString(32,"");
	cstmt.setString(33,"");
	cstmt.setString(34,"");
	cstmt.setString(35,strCancelReason);
	cstmt.setString(36,strCancelDesc);
	cstmt.setString(37,"");
	cstmt.setString(38,strCancelBy);
	cstmt.setString(39,"");
	cstmt.setString(40,"");
	cstmt.setString(41,"");
	cstmt.setString(42,wardInformedYN);//Informed Ward YN
	cstmt.setString(43,wardInformedDateTime);//Ward Informed Date and Time
	cstmt.setString(44,cancelledRemarks);//Cancelled Remarks
	cstmt.setString(45,asstSurgeonCode);//Cancelled Remarks
	cstmt.setString(47,function_id);
	cstmt.registerOutParameter(46,Types.VARCHAR);
	cstmt.executeQuery();
	strStatus=cstmt.getString(28);
	strErrorMsg=cstmt.getString(29);
	if(strStatus.equalsIgnoreCase("E")==true)
	{
		strErrMsg=strErrorMsg;	
		strSubFunction="0";
		conn.rollback();
		out.println(strErrMsg);
	}

	if(strStatus.equalsIgnoreCase("S")==true)
	{
		if(strCancelOrder.equals("true"))
		{

			// Below Code For Cancel Billing record when cancelling the order(cancel check box in cancel appointment screen is checked only).
			cstmt1.setString(1,strFacilityId);
			cstmt1.setString(2,strBookingNum);
			cstmt1.setString(3,login_user);
			cstmt1.setString(4,strClientAddress);
			cstmt1.registerOutParameter(5,Types.VARCHAR);
			cstmt1.registerOutParameter(6,Types.VARCHAR);
			cstmt1.registerOutParameter(7,Types.VARCHAR);
			cstmt1.registerOutParameter(8,Types.VARCHAR);
			cstmt1.executeQuery();
			err_code=CommonBean.checkForNull(cstmt1.getString(5));
			err_text=CommonBean.checkForNull(cstmt1.getString(6));
			lang_err_msg_id=CommonBean.checkForNull(cstmt1.getString(7));
			sys_message_id =CommonBean.checkForNull(cstmt1.getString(8));

			String SQL2="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
			try
			{
				//con = ConnectionManager.getConnection();
				pstmt1=conn.prepareStatement(SQL2);
				pstmt1.setString(1,sys_message_id);
				rs1 = pstmt1.executeQuery();
				while(rs1.next())
				{
					err_desc=CommonBean.checkForNull(rs1.getString(1));
				}
			}
			catch(Exception e)
			{
				System.err.println("Err Mesg in getMessage Function"+e);
					e.printStackTrace();

			}
			finally
			{
				try
				{
					if(rs1!=null)rs1.close();
					if(pstmt1!=null)pstmt1.close();
				}
				catch(Exception e){
								e.printStackTrace();
				}
			}
			if(("").equals(err_desc))
			{
				err_desc+=err_text;
			}
			if(err_desc.equals(""))
			{
				conn.commit();
				out.println("1");
			}
			else
			{
				conn.rollback();
				out.println(err_desc);
				//out.println(err_desc +"&&&&"); //SCF-1123
			}
		}
		else
		{
			conn.commit();
			out.println("1");
		}
	}
}
else if(strBookingNum.length()>0 && strCancel.equals("true")==false)
{
	//out.println("<script>alert('else ifffff 33333333333333')</script>");
	try
	{
		if(strSubFunction.equals("1")==true)
		{
			sql="Select to_char(APPT_DATE,'dd/mm/yyyy') APPT_DATE1 from OT_SCHD_OPERS_VW where OPERATING_FACILITY_ID=? and APPT_REF_NUM=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,strFacilityId);
			pstmt.setString(2,strBookingNum);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				strBookingDate1=rs.getString("APPT_DATE1");
			}
			if(rs!=null) rs.close();
			pstmt.close();
		}

		sql="SELECT SUM(TO_NUMBER(TO_CHAR(A.OPER_DURN,'hh24'))) HOUR1,SUM(TO_NUMBER(TO_CHAR(A.OPER_DURN,'mi'))) MIN1   FROM	  OT_BOOKING_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID 	= ? AND	 A.BOOKING_NUM 	= ?  AND  A.OPER_CODE = B.OPER_CODE ";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strBookingNum);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			hour=Integer.parseInt(rs.getString("HOUR1"));
			min=Integer.parseInt(rs.getString("MIN1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception ee)
	{
			ee.printStackTrace();
	}
	finally
	{
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	}      

	hour+=min/60;
	min%=60;
	strHour="";
	strMin="";

	if(hour<10)
		strHour="0"+hour;
	else
		strHour+=hour;
	if(min <10) 
		strMin="0"+min;
	else
		strMin=""+min;
	strDuration="01/03/05 "+strHour+":"+strMin;
	strCancelReason=CommonBean.checkForNull(req.getParameter("cancel_reason"));
	strCancelDesc=CommonBean.checkForNull(req.getParameter("cancel_desc"));
	strCancelBy=CommonBean.checkForNull(req.getParameter("cancel_by"));
	//strCancelDate=CommonBean.checkForNull(req.getParameter("cancel_date"));
	strPatientId=CommonBean.checkForNull(req.getParameter("patient_id"));
	strBookingDate=CommonBean.checkForNull(req.getParameter("booking_date"));
	strSpecialityCode=CommonBean.checkForNull(req.getParameter("speciality_code"));
	strRoomCode=CommonBean.checkForNull(req.getParameter("room_code"));
	strStartTime=CommonBean.checkForNull(req.getParameter("start_time"));
	strSurgeonCode=CommonBean.checkForNull(req.getParameter("surgeonCode"));
	strOperationCode=CommonBean.checkForNull(req.getParameter("oper_code"));
	strMultipleOperYN=CommonBean.checkForNull(req.getParameter("oper_multiple"));

	cstmt.setString(1,strFacilityId);
	cstmt.setString(2,strPatientId);
	cstmt.setString(3,"");
	cstmt.setString(4,"");
	cstmt.setString(5,"");
	cstmt.setString(6,"");
	cstmt.setString(7,"");
	cstmt.setString(8,strSpecialityCode);
	cstmt.setString(9,"");
	cstmt.setString(10,"");
	cstmt.setString(11,strBookingDate);
	cstmt.setString(12,strStartTime);
	cstmt.registerOutParameter(13,Types.VARCHAR);
	cstmt.setString(14,("Y".equals(over_booking_case_yn))?"OVERBOOK":strDuration);
	cstmt.setString(15,strRoomCode);
	cstmt.setString(16,strSurgeonCode);
	cstmt.setString(17,"");
	cstmt.setString(18,"");
	cstmt.setString(19,"");
	cstmt.setString(20,"");
	cstmt.setString(21,"");
	cstmt.setString(22,"");
	cstmt.setString(23,"");
	cstmt.setString(24,"");
	cstmt.setString(25,strBookingNum);
	cstmt.setString(26,"T");
	cstmt.setString(27,"");
	cstmt.registerOutParameter(28,Types.VARCHAR);
	cstmt.registerOutParameter(29,Types.VARCHAR);
	cstmt.setString(30,login_user);
	cstmt.setString(31,strClientAddress);
	cstmt.setString(32,"");
	cstmt.setString(33,"");
	cstmt.setString(34,"");
	cstmt.setString(35,strCancelReason);
	cstmt.setString(36,strCancelDesc);
	cstmt.setString(37,"");
	cstmt.setString(38,strCancelBy);
	cstmt.setString(39,strOperationCode);
	cstmt.setString(40,strMultipleOperYN);
	cstmt.setString(41,"");
	cstmt.setString(42,"");
	cstmt.setString(43,"");
	cstmt.setString(44,"");
	cstmt.setString(45,asstSurgeonCode);
	cstmt.setString(47,function_id);
	cstmt.registerOutParameter(46,Types.VARCHAR);
	cstmt.executeQuery();
	strStatus=cstmt.getString(28);
	strErrorMsg=cstmt.getString(29);
	if(strStatus.equalsIgnoreCase("E")==true)
	{
		strErrMsg=strErrorMsg;
		conn.rollback();
		out.println(strErrMsg);
		strSubFunction="0";
	}

	if(strStatus.equalsIgnoreCase("S")==true)
	{
		conn.commit();
		out.println("1");
	}
	cstmt.close();
}

if(strBookingDate1.length()>0)	
	strBookingDate=strBookingDate1;

if(strSubFunction.equals("1")==true)
{
	//out.println("<script>alert('00000')</script>");
	strWaitListNo= CommonBean.checkForNull(req.getParameter("add_waitlist_no"));
	strCancelReason=CommonBean.checkForNull(req.getParameter("cancel_reason"));
	strCancelDesc=CommonBean.checkForNull(req.getParameter("cancel_desc"));
	strCancelBy=CommonBean.checkForNull(req.getParameter("cancel_by"));
	//strBookingDate=CommonBean.checkForNull(req.getParameter("booking_date"));
	strStartTime=CommonBean.checkForNull(req.getParameter("start_time"));
	sql="SELECT  a.BOOKING_NUM BOOKING_NUM1,a.PATIENT_ID PATIENT_ID1,a.SPECIALITY_CODE SPECIALITY_CODE1,to_char(a.BOOKING_DATE,'dd/mm/yyyy') BOOKING_DATE1,to_char(a.BOOKING_START_TIME,'dd/mm/yyyy hh24:mi') BOOKING_START_TIME1,a.OPER_ROOM_CODE OPER_ROOM_CODE1,a.TEAM_DOCTOR_CODE TEAM_DOCTOR_CODE1,to_char(a.BOOKING_DURATION,'dd/mm/yyyy hh24:mi') BOOKING_DURATION1,b.PRIMARY_OPER_CODE PRIMARY_OPER_CODE1,to_char(b.PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1,b.MULTIPLE_OPERS_YN MULTIPLE_OPERS_YN1 FROM OT_BOOKing_HDR a,OT_waitlist_vw b  WHERE b.waitlist_num=? and a.OPERATING_FACILITY_ID= ? AND a.booking_num=b.booking_num";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,strWaitListNo);
	pstmt.setString(2,strFacilityId);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
		//strBookingDate=CommonBean.checkForNull(rs.getString("BOOKING_DATE1"));
		strSpecialityCode=CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1"));
		strRoomCode=CommonBean.checkForNull(rs.getString("OPER_ROOM_CODE1"));
		//strStartTime=CommonBean.checkForNull(rs.getString("BOOKING_START_TIME1"));
		strSurgeonCode=CommonBean.checkForNull(rs.getString("TEAM_DOCTOR_CODE1"));
		strDuration =CommonBean.checkForNull(rs.getString("BOOKING_DURATION1"));
		strBookingNum=CommonBean.checkForNull(rs.getString("BOOKING_NUM1"));
		strPreferredDate=CommonBean.checkForNull(rs.getString("PREFERRED_DATE1"));
		strOperationCode=CommonBean.checkForNull(rs.getString("PRIMARY_OPER_CODE1"));
		strMultipleOperYN=CommonBean.checkForNull(rs.getString("MULTIPLE_OPERS_YN1"));

		cstmt.setString(1,strFacilityId);
		cstmt.setString(2,strPatientId);
		cstmt.setString(3,"");
		cstmt.setString(4,"");
		cstmt.setString(5,"");
		cstmt.setString(6,"");
		cstmt.setString(7,"");
		cstmt.setString(8,strSpecialityCode);
		cstmt.setString(10,strPreferredDate);
		cstmt.setString(11,strBookingDate);
		cstmt.setString(12,strStartTime);
		cstmt.registerOutParameter(13,Types.VARCHAR);
		cstmt.setString(14,("Y".equals(over_booking_case_yn))?"OVERBOOK":strDuration);
		cstmt.setString(15,strRoomCode);
		cstmt.setString(16,strSurgeonCode);
		cstmt.setString(17,"");
		cstmt.setString(18,"");
		cstmt.setString(19,"");
		cstmt.setString(20,"");
		cstmt.setString(21,"");
		cstmt.setString(22,"");
		cstmt.setString(23,"");
		cstmt.setString(24,"");
		cstmt.setString(25,strBookingNum);
		cstmt.setString(26,"T");
		cstmt.registerOutParameter(28,Types.VARCHAR);
		cstmt.registerOutParameter(29,Types.VARCHAR);
		cstmt.setString(30,login_user);
		cstmt.setString(31,strClientAddress);
		cstmt.setString(32,"");
		cstmt.setString(33,"");
		cstmt.setString(34,"");
		cstmt.setString(35,strCancelReason);
		cstmt.setString(36,strCancelDesc);
		cstmt.setString(37,"");
		cstmt.setString(38,strCancelBy);
		cstmt.setString(39,strOperationCode);
		cstmt.setString(40,strMultipleOperYN);
		cstmt.setString(41,"");
		cstmt.setString(42,"");
		cstmt.setString(43,"");
		cstmt.setString(44,"");
		cstmt.setString(45,asstSurgeonCode);
		cstmt.setString(47,function_id);
		cstmt.executeQuery();
		strStatus=cstmt.getString(28);
		strErrorMsg=cstmt.getString(29);
		if(strStatus.equalsIgnoreCase("E")==true)
		{
			strErrMsg=strErrorMsg;	
			conn.rollback();
			out.println(strErrMsg);
		}
		if(strStatus.equalsIgnoreCase("S")==true)
		{
			conn.commit();
			out.println("1");
		}
	}
	pstmt.close();
}
	cstmt.close();
	cstmt1.close();
	if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){
	e.printStackTrace();
	//eOT.LogFile.log("OTDebugger","Exception"+ee,this);
}
finally{
	if(conn!=null)	
		ConnectionManager.returnConnection(conn,req);
}

	//BOOKING_DATE
}
}
