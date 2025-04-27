/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.sql.*;
import java.net.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.xml.sax.InputSource;
import eOT.Common.OTRepository;
import webbeans.eCommon.*;
//import com.debug.sql.*;

public class SwabAndInstrumentsTemplateServlet extends javax.servlet.http.HttpServlet {
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
	
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty( "LOCALE" );
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		Connection con = null;
		PreparedStatement pstmt = null;
	
		int flag=0;
		int flag1=0;
    	MessageManager mm=new MessageManager();
	try{
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);	
		 HashMap master_map =(HashMap) hashElement.get("HEADER");
		 String msg="";
		 String key=(String) master_map.get("table_name")+"_"+(String) master_map.get("mode");

		 pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key) );
		 
		 if(key.equals( "OT_SWAB_INSTR_TMPL_HDR_INSERT") ){
			pstmt.setString(1,(String) master_map.get("template_id"));
			pstmt.setString(2,(String) master_map.get("description"));
			pstmt.setString(3,(String) master_map.get("status"));
			pstmt.setString(4,(String) CommonData.get("login_user"));
			pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(6,(String) CommonData.get("facility_id"));
			pstmt.setString(7,(String) CommonData.get("login_user"));
			pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(9,(String) CommonData.get("facility_id"));
		}else if(key.equals( "OT_SWAB_INSTR_TMPL_HDR_MODIFY") ){
			pstmt.setString(1,(String) master_map.get("description"));
			pstmt.setString(2,(String) master_map.get("status"));
			pstmt.setString(3,(String) CommonData.get("login_user"));
			pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(5,(String) CommonData.get("facility_id"));
			pstmt.setString(6,(String) master_map.get("template_id"));
			}
	   flag=pstmt.executeUpdate();
	 
		if(pstmt!=null) pstmt.close();
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		HashMap hash = null;
		ArrayList flag_arr = new ArrayList();
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
				//pstmt=StatementFactory.getStatement(con,OTRepository.getOTKeyValue(key) );
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key) );
				String template_id=(String) hash.get("template_id");
				String item_code=(String) hash.get("item_code");
				String srl_no=(String) hash.get("srl_no");
				String initial_count=(String) hash.get("initial_count");		
				if(key.equals( "OT_SWAB_INSTR_TMPL_DTL_I") ){
				   pstmt.setString(1,template_id);
				   pstmt.setString(2,item_code);
				   pstmt.setString(3,srl_no);
				   pstmt.setString(4,initial_count);
				   pstmt.setString(5,(String) CommonData.get("login_user"));
				   pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(7,(String) CommonData.get("facility_id"));
				   pstmt.setString(8,(String) CommonData.get("login_user"));
				   pstmt.setString(9,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(10,(String) CommonData.get("facility_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_SWAB_INSTR_TMPL_DTL_U") ){
				   pstmt.setString(1,item_code);
				   pstmt.setString(2,initial_count);
				   pstmt.setString(3,(String) CommonData.get("login_user"));
				   pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(5,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(6,template_id);
				   pstmt.setString(7,srl_no);
				   flag1 = pstmt.executeUpdate();
				   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_SWAB_INSTR_TMPL_DTL_D") ){
					pstmt.setString(1,(String) hash.get("template_id"));
					pstmt.setString(2,(String) hash.get("srl_no"));
					flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close(); //Common-ICN-0053
				//end of if else
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
				
			out.println(msg);
		}//end of if Block
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



