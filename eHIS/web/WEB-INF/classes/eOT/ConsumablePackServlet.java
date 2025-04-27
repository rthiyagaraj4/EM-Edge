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
import eOT.Common.OTRepository;
import org.xml.sax.InputSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
//import com.debug.sql.*;


public class ConsumablePackServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		PrintWriter out;
		HashMap hashElement=null;
		eOT.MasterParse MasterParse = new eOT.MasterParse();
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
//		String added_date="";
//		String modified_date="";
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		String locale = prop.getProperty("LOCALE");
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		//Statement stmt=null;
//		ResultSet rs=null;
		int flag=0;
		int flag1=0;
//		boolean flag_update=true;
		MessageManager mm=new MessageManager();

	try{
		con = ConnectionManager.getConnection(req);
		InputSource inputSource=new InputSource(req.getReader());
		hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);	
		HashMap master_map =(HashMap) hashElement.get("HEADER");
		String msg="";
		String key=(String) master_map.get("table_name")+"_"+(String) master_map.get("mode");
		//StatementFactory.setDefaultDebug(DebugLevel.VERBOSE);
		//pstmt = StatementFactory.getStatement(con,OTRepository.getOTKeyValue(key) );
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue(key));
		if(key.equals("OT_PACKAGE_HDR_INSERT") ){
			pstmt.setString(1,(String) master_map.get("package_code"));
			pstmt.setString(2,(String) master_map.get("long_description"));
			pstmt.setString(3,(String) master_map.get("short_description"));
			pstmt.setString(4,(String) master_map.get("status"));
			pstmt.setString(5,(String) CommonData.get("login_user"));
			pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(7,(String) CommonData.get("facility_id"));
			pstmt.setString(8,(String) CommonData.get("login_user"));
			pstmt.setString(9,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(10,(String) CommonData.get("facility_id"));
			//CRF-268 Consumable pack - Rajesh V
			pstmt.setString(11,(String) master_map.get("ss_code"));
			//CRF-268 Consumable pack - Rajesh V
		}else if(key.equals( "OT_PACKAGE_HDR_MODIFY") ){
			pstmt.setString(1,(String) master_map.get("long_description"));
			pstmt.setString(2,(String) master_map.get("short_description"));
			pstmt.setString(3,(String) master_map.get("status"));
			pstmt.setString(4,(String) CommonData.get("login_user"));
			pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(6,(String) CommonData.get("facility_id"));
			//CRF-268 Consumable pack - Rajesh V
			pstmt.setString(7,(String) master_map.get("ss_code"));
			pstmt.setString(8,(String) master_map.get("package_code"));
			//CRF-268 Consumable pack - Rajesh V
		}
		flag=pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();		
        if(flag>0){
		   con.commit();
		 final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		 msg = ((String) mesg.get("message"));
		}else{
		  //msg = "Operation Failed....";
		  con.rollback();
		  final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
		  msg = ((String) mesg.get("message"));
		}
		
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		HashMap hash = null;
		ArrayList flag_arr = new ArrayList();
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
				//pstmt=StatementFactory.getStatement(con,OTRepository.getOTKeyValue(key) );
				pstmt = con.prepareStatement(OTRepository.getOTKeyValue(key));
				String package_code=(String) hash.get("package_code");
				String item_code=(String) hash.get("item_code");
				String reqd_qty=(String) hash.get("reqd_qty");
				//String mode=(String) hash.get("mode");
				if(key.equals( "OT_PACKAGE_DTL_I") ){
				   pstmt.setString(1,package_code);
				   pstmt.setString(2,item_code);
				   pstmt.setString(3,reqd_qty);
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_PACKAGE_DTL_U") ){
					  pstmt.setString(1,reqd_qty);
				      pstmt.setString(2,(String) CommonData.get("login_user"));
				      pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				      pstmt.setString(4,(String) CommonData.get("facility_id"));
					  //where condition
					  pstmt.setString(5,item_code);
				      pstmt.setString(6,package_code);
					  flag1 = pstmt.executeUpdate();
				      flag_arr.add(""+flag1);
				}else if(key.equals( "OT_PACKAGE_DTL_D") ){
					pstmt.setString(1,(String) hash.get("package_code"));
					pstmt.setString(2,(String) hash.get("item_code"));
					flag1 = pstmt.executeUpdate();
                    flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close();
				//end of if else
				//pstmt.addBatch();
			}// end of for Loop

			 if( flag>0 && !flag_arr.contains("0")){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
			  }else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					msg = ((String) mesg.get("message"));
			 }
		}//end of if Block
		if(pstmt!=null)pstmt.close();
		out.println(msg);
	}catch(Exception e){
		e.printStackTrace();
		 System.err.println("Err Msg in ConsumablePackServlet"+e.getMessage());
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



