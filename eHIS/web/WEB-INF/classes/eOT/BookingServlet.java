/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

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
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import org.xml.sax.InputSource;
import com.ehis.util.BundleMessage;
import webbeans.eCommon.*;
//import javax.servlet.jsp.PageContext;
//import javax.servlet.jsp.*;
//import eCommon.MessageManager.*;

import java.sql.* ;
import eCommon.Common.* ;


public class BookingServlet extends javax.servlet.http.HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}


	public String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
	
	//setting the character Encoding b4 retreiving any request
	req.setCharacterEncoding("UTF-8");
	//setting the content type b4 sending any response
	res.setContentType("text/html;charset=UTF-8");
	
	//Added Against MMS Vulnerability Issue - Starts
    req= new XSSRequestWrapper(req);
    res.addHeader("X-XSS-Protection", "1; mode=block");
    res.addHeader("X-Content-Type-Options", "nosniff"); 
    //Added Against MMS Vulnerability Issue - Ends
	
	//JspFactory.getDefaultFactory().getPageContext(servlet,request,response,errorpage,needsession,buffer,autoflash)
	//PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
	//getting the audit fields 
	HttpSession session=req.getSession(true);
	String strFacilityId=""+session.getAttribute("facility_id");
	Properties p=(Properties)session.getAttribute("jdbc");
	String strClientAddress=""+p.getProperty("client_ip_address");
	String login_user=""+p.getProperty("login_user");
	//getting the locale 
	String locale = p.getProperty("LOCALE");
	PrintWriter out=res.getWriter();
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	ResultSet rs=null;
	CallableStatement cstmt = null;

	//String Cannonicalization
	String emty = "".intern();
	//initialization of variables
	String sql=emty;
	String strBookingDate=emty;
	String strRoomCode=emty;
	String strBookingNum=emty;
	String strFromStageCode=emty;
	String strToStageCode=emty;
	String strSequenceNo=emty;
	String strPriorityCode=emty;
	String strPatientId=emty;
	String strSequenceYN=emty;
	String strReasonCode=emty;
	String strSessionId=emty;
	String strStatus=emty;
	String strMessage=emty;
	String strBookingNo=emty;
	String strScheduleReason=emty;
	String strScheduleYN=emty;
	String strFlag=emty;
	String strSeq=emty;
	String stage_code_final=emty;
	String sqlforstagecode=emty;
    try{
		conn = ConnectionManager.getConnection(req);
		int index=0,cou=0;
		eOT.MasterXMLParse masterParse=null;
		InputSource inputSource=null;
		HashMap hashElement=null;
		ArrayList tabData=null;
		//param="booking_date="+booking_date+"&room_code="+room_code"+&seq_change_yn="+seq_change_yn+"&flag=1&cancel_reason="+cancel_reason+"&booking_no="+booking_no;
		strFlag=checkForNull(req.getParameter("flag"));
		//eOT.LogFile.log("OTDebugger","Flag "+strFlag,this);
		if(strFlag.equals("1")==false){
			masterParse=new MasterXMLParse();
			inputSource=new InputSource(req.getReader());
			hashElement=masterParse.parseXMLData(inputSource,null,null,eOT.MasterXMLParse.DETAIL_ONLY);	
			tabData=(ArrayList)hashElement.get("SEARCH");
	}
	try{
		sql="select SYS_CONTEXT('USERENV','Sessionid') session_id from dual";
		pstmt=conn.prepareCall(sql);
		rs=pstmt.executeQuery();
		if(rs.next())	{
			strSessionId=rs.getString("session_id");
		}
		rs.close();  
		pstmt.close();
	}catch(Exception ee){}
		//rs.close();  commented for V3
		//pstmt.close();
	try{
		sqlforstagecode="SELECT STAGE_CODE FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO = (SELECT MAX(SERIAL_NO) FROM OT_BOOKING_FIN_STAGES)";
		pstmt=conn.prepareCall(sqlforstagecode);
		rs=pstmt.executeQuery();
		if(rs.next()){
			 stage_code_final=rs.getString("STAGE_CODE");
	 	}
		rs.close();
		pstmt.close();
	}catch(Exception ee){}
	finally{
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	}
int count=0;
int count2=0;
	if(strFlag.equals("1")==false){

		pstmt1=conn.prepareStatement("DELETE FROM OT_BOOKING_FIN_SEQ_TEMP WHERE  USER_ID ='"+login_user+"' AND  SESSION_ID = '"+strSessionId+"' AND FACILITY_ID = '"+strFacilityId+"'");
		count2=pstmt1.executeUpdate();	

		sql="insert into OT_BOOKING_FIN_SEQ_TEMP(USER_ID,SESSION_ID,FACILITY_ID,BOOKING_DATE,OPER_ROOM_CODE,PATIENT_ID,BOOKING_NUM,FROM_STAGE_CODE,TO_STAGE_CODE,PRIORITY_CODE,	SEQUENCE_NO,ADDED_WS_ID,SEQ_CHNG_REASON_CODE) values(?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?)";
		pstmt=conn.prepareCall(sql);
		HashMap hashDtl;
		for( cou=0;cou<tabData.size();cou++){
		 hashDtl=(HashMap)tabData.get(cou);
		 strBookingDate=checkForNull(""+hashDtl.get("booking_date"));
		 strRoomCode=checkForNull(""+hashDtl.get("room_code"));
		 strFromStageCode=checkForNull(""+hashDtl.get("from_stage_code"));
		 strToStageCode=checkForNull(""+hashDtl.get("to_stage_code"));
		 strBookingNum=checkForNull(""+hashDtl.get("booking_num"));
		 strPriorityCode=checkForNull(""+hashDtl.get("priority_code"));
		 strSequenceNo=checkForNull(""+hashDtl.get("sequence_no"));
		 strPatientId=checkForNull(""+hashDtl.get("patient_id"));
		 strSequenceYN=checkForNull(""+hashDtl.get("seq_change_yn"));
		 strReasonCode=checkForNull(""+hashDtl.get("reason_code"));
		 index=0;
		 pstmt.setString(++index,login_user);
		 pstmt.setString(++index,strSessionId);
		 pstmt.setString(++index,strFacilityId);
		 pstmt.setString(++index,strBookingDate);
		 pstmt.setString(++index,strRoomCode);
		 pstmt.setString(++index,strPatientId);
		 pstmt.setString(++index,strBookingNum);
		 pstmt.setString(++index,strFromStageCode);
		 pstmt.setString(++index,strToStageCode);
		 pstmt.setString(++index,strPriorityCode);
		 pstmt.setString(++index,strSequenceNo);
		 pstmt.setString(++index,strClientAddress);
		 pstmt.setString(++index,strReasonCode);
		count=pstmt.executeUpdate();
	

	   }
	//   pstmt1=conn.prepareStatement("DELETE FROM OT_BOOKING_FIN_SEQ_TEMP WHERE  USER_ID ='"+login_user+"' AND  SESSION_ID = '"+strSessionId+"' AND FACILITY_ID = '"+strFacilityId+"'");
	//	pstmt1.executeUpdate();	
	}else{

		strRoomCode=checkForNull(req.getParameter("room_code"));
		strBookingNo=checkForNull(req.getParameter("booking_no"));
		strBookingDate=checkForNull(req.getParameter("booking_date"));
		strSequenceYN=checkForNull(req.getParameter("seq_change_yn"));
		strScheduleReason=checkForNull(req.getParameter("cancel_reason"));
		strScheduleYN="Y";

	}
	index=0;
	if(strSequenceYN.equals("Y")) 
		strSeq="?";
	else
	strSeq="null";

	String langstrMessage="";
	cstmt=conn.prepareCall("{call OT_UPDATE_BOOKING_STG(?,?,?,?,"+strSeq+",?,?,?,?,?,?,?,?)}");
	 //eOT.LogFile.log("OTDebugger","Call Procedure"+strSeq,this);
	cstmt.setString(++index,strFacilityId);
	cstmt.setString(++index,login_user);
	//eOT.LogFile.log("OTDebugger","login_user"+login_user,this);
	cstmt.setString(++index,strSessionId);
	//eOT.LogFile.log("OTDebugger","strSessionId"+strSessionId,this);
	cstmt.setString(++index,strBookingDate);
	 //eOT.LogFile.log("OTDebugger","strBookingDate"+strBookingDate,this);
	if(strSeq.equals("?")){	
	cstmt.setString(++index,strRoomCode);
	//eOT.LogFile.log("OTDebugger","strRoomCode"+strRoomCode,this);
	}
	cstmt.setString(++index,strSequenceYN);
	//eOT.LogFile.log("OTDebugger","strSequenceYN"+strSequenceYN,this);
	cstmt.setString(++index,strScheduleYN);
	//eOT.LogFile.log("OTDebugger","strScheduleYN"+strScheduleYN,this);
	cstmt.setString(++index,strBookingNo);
	//eOT.LogFile.log("OTDebugger","strBookingNo"+strBookingNo,this);
	cstmt.setString(++index,strScheduleReason);
	//eOT.LogFile.log("OTDebugger","strScheduleReason"+strScheduleReason,this);
	cstmt.registerOutParameter(++index,Types.VARCHAR);
	cstmt.registerOutParameter(++index,Types.VARCHAR);
	cstmt.setString(++index,strClientAddress);
	cstmt.registerOutParameter(++index,Types.VARCHAR);
	//eOT.LogFile.log("OTDebugger","strClientAddress"+strClientAddress,this);
	cstmt.execute();
//	strStatus=cstmt.getString(10);
//	strMessage=cstmt.getString((11));
//	langstrMessage=cstmt.getString(13);
	strStatus=checkForNull(cstmt.getString(index-3));
	strMessage=checkForNull(cstmt.getString((index-2)));
	langstrMessage=checkForNull(cstmt.getString(index));
	System.err.println("239 Status -----> "+strStatus);
System.err.println("240 Str Message ------> "+strMessage);
System.err.println("241 Lang Str Message -------> "+langstrMessage);
	cstmt.close();
	//eOT.LogFile.log("OTDebugger","strStatus "+strStatus,this);
	//eOT.LogFile.log("OTDebugger","strMessage "+strMessage,this);
	 //cstmt.close(); commented V3
     MessageManager mm=new MessageManager();
	 String msg = "";

			pstmt2=conn.prepareStatement("DELETE FROM OT_BOOKING_FIN_SEQ_TEMP WHERE  USER_ID ='"+login_user+"' AND    SESSION_ID = '"+strSessionId+"' AND FACILITY_ID = '"+strFacilityId+"'");
		count2=pstmt2.executeUpdate();	
System.err.println(" In Booking Servlet after Procedure Executed....: ");
System.err.println("Status -----> "+strStatus);
System.err.println("Str Message ------> "+strMessage);
System.err.println("Lang Str Message -------> "+langstrMessage);
	 if(strStatus.equals("E")==true){
		//final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
		final java.util.Hashtable mesg = mm.getMessage(locale, langstrMessage, "OT") ;
		msg = ((String) mesg.get("message"));

		System.err.println("Inside If condition bookignServlet ---->"+strMessage); // old message
		System.err.println("langstrMessage 242----> "+langstrMessage);
		conn.rollback();
	}else{
		////eOT.LogFile.log("OTDebugger","sql"+sql,this);

conn.commit();
  }
out.println(msg);


}catch(Exception ee){
	//eOT.LogFile.log("OTDebugger","Exception in Update"+ee,this);
	ee.printStackTrace();
	System.err.println("error is cmg in this servlet :" +ee);
}
finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if(pstmt2!=null) pstmt2.close();
			if(cstmt!=null) cstmt.close();
			if(conn!=null)
			ConnectionManager.returnConnection(conn, req);
		}catch(Exception e){}
}
}
}
