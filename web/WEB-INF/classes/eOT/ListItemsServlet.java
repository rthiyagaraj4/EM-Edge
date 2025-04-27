/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
/*
import java.sql.*;
import java.net.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.xml.sax.InputSource;
import eOT.*;
import eOT.Common.*;
import com.debug.sql.*;
*/
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import eOT.Common.*;

public class ListItemsServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		PrintWriter out;
		HashMap hashElement=null;
		eOT.MasterParse MasterParse = new eOT.MasterParse();
		HashMap CommonData=new HashMap();
		HttpSession session=req.getSession(false);
		res.setContentType("text/html");
		out=res.getWriter();
					
		
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
	
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		int flag=0;
		int flag1=0;
		String locale = prop.getProperty("LOCALE");
		
	try{
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);	
		 HashMap master_map =(HashMap) hashElement.get("HEADER");
		 String msg="";
		 String key=(String) master_map.get("table_name")+"_"+(String) master_map.get("mode");

		pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));
		if(key.equals( "OT_CHECKLIST_LISTVALS_HDR_INSERT") ){
		   	pstmt.setString(1,(String) master_map.get("list_id"));
			pstmt.setString(2,(String) CommonData.get("login_user"));
			pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String) CommonData.get("facility_id"));
			pstmt.setString(5,(String) CommonData.get("login_user"));
			pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(7,(String) CommonData.get("facility_id"));
			pstmt.setString(8,(String) master_map.get("description"));
		}else if(key.equals( "OT_CHECKLIST_LISTVALS_HDR_MODIFY") ){
			pstmt.setString(1,(String) master_map.get("description"));
			pstmt.setString(2,(String) CommonData.get("login_user"));
			pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(4,(String) CommonData.get("facility_id"));
			pstmt.setString(5,(String) master_map.get("list_id"));
			}
		
		flag=pstmt.executeUpdate();
       if(flag>0)
		{

		   con.commit();
	   
		}
	   else
		{
		   // msg = "Operation Failed....";
		   con.rollback();
		}
		out.println(msg);
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		HashMap hash = null;
		ArrayList flag_arr = new ArrayList();
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");

				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));

				String list_id=(String) hash.get("list_id");
                String item_description=(String) hash.get("item_description");
				String item_value=(String) hash.get("item_value");
				String default_value_yn=(String) hash.get("default_value_yn");
				
				if(key.equals( "OT_CHECKLIST_LISTVALS_DTL_I") ){
				   pstmt.setString(1,list_id);
				   pstmt.setString(2,item_description);
				   pstmt.setString(3,item_value);
				   pstmt.setString(4,default_value_yn);
				   pstmt.setString(5,(String) CommonData.get("login_user"));
				   pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(7,(String) CommonData.get("facility_id"));
				   pstmt.setString(8,(String) CommonData.get("login_user"));
				   pstmt.setString(9,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(10,(String) CommonData.get("facility_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				   
				}else if(key.equals( "OT_CHECKLIST_LISTVALS_DTL_U") ){
				   pstmt.setString(1,item_description);
				    pstmt.setString(2,default_value_yn);
				   pstmt.setString(3,(String) CommonData.get("login_user"));
				   pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(5,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(6,list_id);
				  pstmt.setString(7,item_value);
                   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_CHECKLIST_LISTVALS_DTL_D") ){
					pstmt.setString(1,(String) hash.get("list_id"));
					pstmt.setString(2,(String) hash.get("item_value"));
					flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag);
				}
				if(pstmt!=null) pstmt.close();
				//end of if else
				//pstmt.addBatch();
			}// end of for Loop
            MessageManager mm=new MessageManager();

			 if( flag>0 && !flag_arr.contains("0")){
				//msg = "Operation Completed Successfully....";
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
				 }else{
					//msg = "Operation Failed....";
					  con.rollback();
					  final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					  msg = ((String) mesg.get("message"));
				 }
				out.println(msg);
				hashElement.clear();
				CommonData.clear();
				master_map.clear();
				tabData.clear();
				hash.clear();
				flag_arr.clear();
				}//end of if Block
	}catch(Exception e){
		e.printStackTrace();
		 System.err.println("Err Msg in ChecklistsServlet"+e.getMessage());
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



