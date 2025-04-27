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
import eCommon.XSSRequestWrapper;

public class PractitionerTypesForRoleTypesServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		String role_type = CommonBean.checkForNull(req.getParameter("role_type"));
		PrintWriter out;
		
		HashMap hashElement=null,map=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();

		
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOT.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
//		String added_date="";
//		String modified_date="";
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int flag=0;
		try{
				ArrayList arrList = new ArrayList(1);
				con = ConnectionManager.getConnection(req);
				InputSource inputSource=new InputSource(req.getReader());
				hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
				//int flag=0;
				String pract_type = "";
				String select_value = "";
				String msg="";
                String sqlDelete="DELETE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE role_type=? AND pract_type=?";
				String sqlInsert="INSERT INTO OT_PRACT_TYPES_FOR_ROLE_TYPE (ROLE_TYPE,PRACT_TYPE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?)";
				//( OTRepository.getOTKeyValue(TABLE_NAME_MODE) ); 
				pstmt1=con.prepareStatement(sqlDelete);
				pstmt2=con.prepareStatement(sqlInsert);
				ArrayList flag_arr= new ArrayList();
				if(tabData!=null && tabData.size()>0){
					for(int i = 0;i<tabData.size();i++){
					map = (HashMap) tabData.get(i);
					pract_type = (String )  map.get("practitioner_type");
					select_value = (String) map.get("select_value");
					//pstmt = select_value.equals("N")?pstmt1:pstmt2;
					if(select_value.equals("N")){
					     pstmt1.setString(1,role_type);
						 pstmt1.setString(2,pract_type);
			             flag = pstmt1.executeUpdate();
						 flag_arr.add(""+flag);
						//pstmt.addBatch();
					}else{
						pstmt2.setString(1,role_type);
						pstmt2.setString(2,pract_type);
						pstmt2.setString(3,(String) CommonData.get("login_user"));
						pstmt2.setString(4,(String) CommonData.get("login_at_ws_no"));
						pstmt2.setString(5,(String) CommonData.get("facility_id"));
						//pstmt2.setString(6,(String) CommonData.get("login_user"));
						//pstmt2.setString(7,(String) CommonData.get("login_at_ws_no")); 
						//pstmt2.setString(8,(String) CommonData.get("facility_id"));
						flag = pstmt2.executeUpdate();
						flag_arr.add(""+flag);
						//pstmt.addBatch();
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
			    //System.err.println("Err Msg in PractitionerTypesForRoleTypesServlet"+e.getMessage());
				//out.println(""+e);
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){e.printStackTrace();}
	  }
    }
 }



