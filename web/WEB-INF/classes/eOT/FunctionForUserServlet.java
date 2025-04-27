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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;


public class FunctionForUserServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		String user_id = CommonBean.checkForNull(req.getParameter("user_id"));
		PrintWriter out;
		
		HashMap hashElement=null,map=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		masterXMLParse=new eOT.MasterXMLParse();
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
//		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			ArrayList arrList = new ArrayList(1);
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			InputSource inputSource=new InputSource(req.getReader());
			hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
			ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
			int flag=0;

			String msg="";
			String c_mode ="";  

			String sqlInsert="INSERT INTO OT_USER_FUNCTIONS (USER_ID,FUNCTION_ID,ALLOW_VERIFICATION_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String sqlUpdate="UPDATE OT_USER_FUNCTIONS SET ALLOW_VERIFICATION_YN = ? ,MODIFIED_BY_ID = ?,MODIFIED_DATE= SYSDATE,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID= ? WHERE USER_ID = ?  AND FUNCTION_ID = ?";
			String sqlDelete="DELETE FROM OT_USER_FUNCTIONS WHERE USER_ID = ?  AND FUNCTION_ID = ?";
			pstmt1=con.prepareStatement(sqlUpdate);
			pstmt2=con.prepareStatement(sqlInsert);
			pstmt3=con.prepareStatement(sqlDelete);

			ArrayList flag_arr= new ArrayList();
			if(tabData!=null && tabData.size()>0){
			for(int i = 0;i<tabData.size();i++){
				map = (HashMap) tabData.get(i);
				c_mode = (String) map.get("c_mode");
				if( c_mode.equals("U") ){
					pstmt1.setString(1,(String) map.get("allow_verif") );
					pstmt1.setString(2,(String) CommonData.get("login_user") );
					pstmt1.setString(3,(String) CommonData.get("login_at_ws_no") );
					pstmt1.setString(4,(String) CommonData.get("facility_id") );
					pstmt1.setString(5,user_id);
					pstmt1.setString(6,(String )  map.get("func_id") );
					flag = pstmt1.executeUpdate();
					flag_arr.add(""+flag);
				}else if( c_mode.equals("I") ){
					pstmt2.setString(1,user_id);
					pstmt2.setString(2,(String) map.get("func_id"));
					pstmt2.setString(3,(String) map.get("allow_verif"));
					pstmt2.setString(4,(String) CommonData.get("login_user"));
					pstmt2.setString(5,(String) CommonData.get("login_at_ws_no"));
					pstmt2.setString(6,(String) CommonData.get("facility_id"));
					pstmt2.setString(7,(String) CommonData.get("login_user"));
					pstmt2.setString(8,(String) CommonData.get("login_at_ws_no")); 
					pstmt2.setString(9,(String) CommonData.get("facility_id"));
					flag = pstmt2.executeUpdate();
					flag_arr.add(""+flag);
				}
				else if( c_mode.equals("D") ){
					pstmt3.setString(1,user_id);
					pstmt3.setString(2,(String) map.get("func_id"));
					flag = pstmt3.executeUpdate();
					flag_arr.add(""+flag);
				}
					//pstmt.addBatch();
			}// end of for Loop
			
				MessageManager mm=new MessageManager();
				 if(!flag_arr.contains("0")){
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
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				if(pstmt3!=null) pstmt3.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



