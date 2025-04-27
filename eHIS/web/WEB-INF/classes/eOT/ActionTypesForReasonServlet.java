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
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;
import webbeans.eCommon.*;

public class ActionTypesForReasonServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		//PageContext pageCtx = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
		String reason_code = CommonBean.checkForNull(req.getParameter("reason_code"));
		PrintWriter out;
		HashMap hashElement=null,map=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
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
		String locale = prop.getProperty("LOCALE") ;
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);

		String sqlupdate="UPDATE OT_REASON_ACTION_TYPE SET ACTIVE_YN=?,MODIFIED_DATE=SYSDATE, MODIFIED_BY_ID=?, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE reason_code=? AND action_type=?";
		String sqlinsert="INSERT INTO OT_REASON_ACTION_TYPE  (reason_code,action_type,active_yn,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
//		String sql="";
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2=null;
		ArrayList flag_arr= null;
		String update_flag = "";
		String action_code="";
		String select_value="";
		int flag=0;
		try{
				ArrayList arrList = new ArrayList(1);
				con = ConnectionManager.getConnection(req);
				InputSource inputSource=new InputSource(req.getReader());
				hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
				String msg="";
                flag_arr= new ArrayList();
				if(tabData!=null && tabData.size()>0) {
					int size=tabData.size();
		
					for(int i = 0;i<size;i++) {
						map = (HashMap) tabData.get(i);
						update_flag =  CommonBean.checkForNull( (String) map.get("update_flag") );
                        action_code=(String) map.get("action_code");
						select_value=(String) map.get("select_value");
						if(pstmt1!=null) pstmt1.close();
						if(pstmt2!=null) pstmt2.close();
						pstmt1=con.prepareStatement(sqlupdate);
						pstmt2=con.prepareStatement(sqlinsert);
						if( update_flag.equals("U") ) {
							
							pstmt1.setString(1,select_value);
							pstmt1.setString(2,(String) CommonData.get("login_user"));
							pstmt1.setString(3,(String) CommonData.get("login_at_ws_no"));
							pstmt1.setString(4,(String) CommonData.get("facility_id"));
							pstmt1.setString(5,reason_code);
							pstmt1.setString(6,action_code);
							flag = pstmt1.executeUpdate();
                            flag_arr.add(""+flag);
						}else{	
								pstmt2.setString(1,reason_code );
								pstmt2.setString(2,(String) map.get("action_code")  );
								pstmt2.setString(3,(String) map.get("select_value") );
								pstmt2.setString(4,(String) CommonData.get("login_user"));
								pstmt2.setString(5,(String) CommonData.get("login_at_ws_no"));
								pstmt2.setString(6,(String) CommonData.get("facility_id"));
								pstmt2.setString(7,(String) CommonData.get("login_user"));
								pstmt2.setString(8,(String) CommonData.get("login_at_ws_no")); 
								pstmt2.setString(9,(String) CommonData.get("facility_id"));
								flag = pstmt2.executeUpdate();
                                flag_arr.add(""+flag);
																
						}
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
                   	}// end of for Loop
				 MessageManager mm=new MessageManager();
				 if(!flag_arr.contains("0")){
						con.commit();
					  //msg = " Operation Completed Successfully....";
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
			    System.err.println("Err Msg in ActionTypesForReasonServlet"+e.getMessage());
	}finally{
		try{
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



