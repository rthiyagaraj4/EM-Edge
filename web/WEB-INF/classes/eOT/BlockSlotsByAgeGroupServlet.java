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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import eOT.Common.OTRepository;
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;
import webbeans.eCommon.*;

public class BlockSlotsByAgeGroupServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		PrintWriter out;
		HashMap hashElement=null;
		//eOT.MasterParse MasterParse = new eOT.MasterParse();
		eOT.MasterXMLParse masterXMLParse=new eOT.MasterXMLParse();;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		//PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
		out=res.getWriter();
					
		
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		//String added_date="";
		//String modified_date="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getAttribute( "facility_id" ) ;
		prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		String start_time=req.getParameter("start_time");
		String end_time=req.getParameter("end_time");
//		String agegrp_desc=req.getParameter("agegrp_desc");
		String locale = prop.getProperty("LOCALE") ;
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs=null;
//		int flag=0;
		int flag1=0;
//		boolean flag_update=true;
		String key="";
		String msg="";
		//String curr_date=req.getParameter("curr_date");
			 MessageManager mm=new MessageManager();
		
	    try{
		 ArrayList arrList = new ArrayList(1);
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
		        
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		HashMap hash = null;
		ArrayList flag_arr = new ArrayList();
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));

				if(key.equals( "OT_SPECIALITY_TIME_TABLE_I") ){
				   pstmt.setString(1,(String) hash.get("operating_facility_id"));
				   pstmt.setString(2,(String) hash.get("oper_room_code"));
				   pstmt.setString(3,(String) hash.get("agegrp_desc"));
				   pstmt.setString(4,start_time);
				   pstmt.setString(5,end_time);
				   pstmt.setString(6,(String) CommonData.get("login_user"));
				   pstmt.setString(7,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(8,(String) CommonData.get("facility_id"));
				   pstmt.setString(9,(String) CommonData.get("login_user"));
				   pstmt.setString(10,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(11,(String) CommonData.get("facility_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_SPECIALITY_TIME_TABLE_U") ){
				   pstmt.setString(1,(String) hash.get("oper_room_code"));
				   pstmt.setString(2,(String) hash.get("agegrp_desc"));
   				   pstmt.setString(3,start_time);
				   pstmt.setString(4,end_time);
				   pstmt.setString(5,(String) CommonData.get("login_user"));
				   pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(7,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(8,(String) hash.get("operating_facility_id"));
				   pstmt.setString(9,(String) hash.get("oper_room_code"));
				   pstmt.setString(10,(String) hash.get("day_code"));
				   pstmt.setString(11,(String) hash.get("speciality_code"));
				   //pstmt.setString(15,start_time);
                   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
						
				}else if(key.equals( "OT_SPECIALITY_TIME_TABLE_D") ){
					pstmt.setString(1,(String) hash.get("operating_facility_id"));
					pstmt.setString(2,(String) hash.get("oper_room_code"));
					pstmt.setString(3,(String) hash.get("agegrp_desc"));
				    pstmt.setString(4,start_time);
				    pstmt.setString(5,end_time);
					flag1 = pstmt.executeUpdate();
                    flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close();
				//end of if else
				//pstmt.addBatch();
			}// end of for Loop
			 if( !flag_arr.contains("0")){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
			}else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					msg = ((String) mesg.get("message"));
			 }				
			 out.println(msg);
		}//end of if Block
		if(pstmt !=null) pstmt.close();
	}catch(Exception e){
		//e.printStackTrace();
		 System.err.println("Err Msg in BlockSlotsByAgeGroupServlet"+e.getMessage());
		 try{
			con.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
		 }catch(Exception e1){}
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



