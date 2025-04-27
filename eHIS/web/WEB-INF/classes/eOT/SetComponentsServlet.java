/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;            
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
//import com.debug.sql.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;



public class SetComponentsServlet extends javax.servlet.http.HttpServlet {
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
		out=res.getWriter();
		
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		/* String added_date="";  
		String modified_date=""; */ //Common-ICN-0055
		String locale="";
		//String customer_id ="";//Added by muthuN for RUT-CRF-0091 //Common-ICN-0055
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = (String) prop.getProperty( "LOCALE" ) ;
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		Connection con = null;
		PreparedStatement pstmt = null;
		/* PreparedStatement pstmt_st = null;//Added by muthuN for RUT-CRF-0091
		ResultSet rst_st=null;//Added by muthuN for RUT-CRF-0091
		Statement stmt=null;
		ResultSet rs=null;
		int flag=0;
		boolean flag_update=true; */ //Common-ICN-0055
		int flag1=0;
		String key="";
		String msg="";
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
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key) );
				String instr_code=(String) hash.get("instr_code");
				String item_code=(String) hash.get("item_code");
				String quantity=(String) hash.get("quantity");
				String st_location=(String) hash.get("st_location");
				if(key.equals( "OT_INSTRUMENT_COMPONENTS_I") ){
				   pstmt.setString(1,instr_code);
				   pstmt.setString(2,item_code);
				   pstmt.setString(3,quantity);
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_INSTRUMENT_COMPONENTS_U") ){
					pstmt.setString(1,quantity);
   				    pstmt.setString(2,st_location);
				    pstmt.setString(3,(String) CommonData.get("login_user"));
				    pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
				    pstmt.setString(5,(String) CommonData.get("facility_id"));
					//where condition
				    pstmt.setString(6,instr_code);
				    pstmt.setString(7,item_code);
					flag1 = pstmt.executeUpdate();
					flag_arr.add(""+flag1);
				}else if(key.equals( "OT_INSTRUMENT_COMPONENTS_D") ){
					pstmt.setString(1,(String) hash.get("instr_code"));
					pstmt.setString(2,(String) hash.get("item_code"));
					flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				//end of if else
				//pstmt.addBatch();
			}// end of for Loop
			 MessageManager mm=new MessageManager();
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


