/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import eOT.Common.OTRepository;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.Types;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;



public class SurgeonDiaryMaintainScheduleServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);	    
	}
	 


	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		PrintWriter out;
		HashMap hashElement=null;
		//eOT.MasterParse MasterParse = new eOT.MasterParse();
		eOT.MasterXMLParse masterXMLParse=new eOT.MasterXMLParse();
		//HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		/*String  SQL_UPD = "UPDATE OT_BOOKING_HDR SET BOOKING_STATUS='9',CANCELLATION_DATE=SYSDATE,CANCELLED_BY=?,				CANCELLED_REMARKS= 'Cancelled from Maintain dairy schedule by '||?||' on '||to_char(sysdate,'dd/mm/yyyy hh24:mi') WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE=? AND TEAM_DOCTOR_CODE=? AND BOOKING_DATE = TO_DATE(?,'DD/MM/YYYY')";*/
		
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String status = "";
		String no_of_cases= "";
		String error_text = "";
		//String lang_error_text = "";

		java.util.Properties prop = null;
		facility_id = (String)session.getAttribute( "facility_id" ) ;
		prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		String locale = prop.getProperty("LOCALE") ;
		Connection con = null;
		CallableStatement cstmt = null;
		String msg="";
		boolean trx_flag = false;
		int cancelled_slots = 0;
		//String curr_date=req.getParameter("curr_date");
		 MessageManager mm=new MessageManager();
		ArrayList arrList = new ArrayList(1);
	    HashMap hash = null;
		ArrayList tabData = null;
		try{
		  
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
	     tabData =(ArrayList) hashElement.get("SEARCH");
		 int size = tabData.size();
	 	 
		 con = ConnectionManager.getConnection(req);
		 cstmt=con.prepareCall("{call OT_MAINTAIN_SCHD_CANCELLATION(?,?,?,?,?,?,?,?,?,?)}");
		for(int i=0;i<size;i++){
			hash = (HashMap) tabData.get(i);
			cstmt.setString( 1, facility_id);				//P_FACILITY_ID				
			cstmt.setString(2,(String) hash.get("booking_date")); //P_BOOKING_DATE
			cstmt.setString(3,(String) hash.get("surgeon_code")); //P_SURGEON_CODE			
			cstmt.setString(4,(String) hash.get("theatre_code")); //P_OPER_ROOM_CODE		
			cstmt.setString( 5, login_user);				//P_USER		
			cstmt.setString( 6, client_ip_address);		//P_WSNO		
			cstmt.registerOutParameter( 7, 12);		//7 P_NO_OF_CASES	    
			cstmt.registerOutParameter( 8, 12 );		//P_TRS_TYPE	    
			cstmt.registerOutParameter( 9,12 );		//P_ERR_MSG   
			cstmt.registerOutParameter( 10,12 );     //P_LANG_ERR   
			cstmt.execute() ;
			no_of_cases		=	cstmt.getString(7);
			status				=  cstmt.getString(8);
			error_text			=  cstmt.getString(9);
			if("S".equals(status)){
				cancelled_slots		=	cancelled_slots + Integer.parseInt(cstmt.getString(7));
				msg = cancelled_slots+"";
				trx_flag = true;
				
			}else{
				msg = cstmt.getString(9);
				
			}
			
			if("E".equals(status)) break;
		}
		if(trx_flag){
				con.commit();
			}else{
				con.rollback();
			}
		out.println(msg);

			 //out.println("<script>parent.document.frames.messageFrame='../../eCommon/jsp/MstCodeError.jsp?err_value='"+msg+"'</script>");
}catch(Exception e){
		final java.util.Map mesg;
		//e.printStackTrace();
		 System.err.println("Err Msg in SurgeonDiaryMaintainScheduleServlet"+e.getMessage());
		 try{
			con.rollback();
			mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
		 }catch(Exception e1){}
	}finally{
		try{
				hashElement.clear();
				arrList.clear();
				tabData.clear();
				hash.clear();
				//mesg.clear();
				if(cstmt!=null) cstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }

}


