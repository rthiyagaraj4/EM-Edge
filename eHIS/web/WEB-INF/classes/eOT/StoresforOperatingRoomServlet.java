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
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class StoresforOperatingRoomServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{

		String oper_room_code = checkForNull(req.getParameter("oper_room_code"));
		PrintWriter out;
		
		HashMap hashElement=null,map=null;
		eOT.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOT.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		/* String added_date="";
		String modified_date=""; */ //Common-ICN-0055
		String locale ="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		int flag=0;
		try{
				ArrayList arrList = new ArrayList(1);
				con = ConnectionManager.getConnection(req);
				InputSource inputSource=new InputSource(req.getReader());
				hashElement=masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
				ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
				
				String type_desc = "";
				String facility_name="";
				String store_code = "";
				String select_value = "";
				String dflt_select_value = "";
				String mode = "";
				String msg="";

		//ADDED_DATE, MODIFIED_DATE
		//ADDED_FACILITY_ID, MODIFIED_FACILITY_ID
                String sqlUpdate="UPDATE OT_STORES_FOR_THEATRE SET DEFAULT_YN = ?,MODIFIED_BY_ID =?,MODIFIED_DATE = SYSDATE,MODIFIED_AT_WS_NO =?,MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID =? AND OPER_ROOM_CODE =? AND STORE_FACILITY_ID=? AND STORE_CODE=? AND STORE_TYPE =?";
                String sqlDelete="DELETE FROM OT_STORES_FOR_THEATRE WHERE OPERATING_FACILITY_ID =? AND OPER_ROOM_CODE=? AND STORE_FACILITY_ID =? AND STORE_CODE =?";
				String sqlInsert="INSERT INTO OT_STORES_FOR_THEATRE(OPERATING_FACILITY_ID,OPER_ROOM_CODE,STORE_FACILITY_ID,STORE_CODE,STORE_TYPE,DEFAULT_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,SYSDATE,?,?,?)";
				
				pstmt1=con.prepareStatement(sqlDelete);
				pstmt2=con.prepareStatement(sqlInsert);
				pstmt3=con.prepareStatement(sqlUpdate);
				ArrayList flag_arr= new ArrayList();
				if(tabData!=null && tabData.size()>0){
					for(int i = 0;i<tabData.size();i++){
					map = (HashMap) tabData.get(i);
					type_desc = (String )  map.get("type_desc");
					facility_name = (String )  map.get("facility_name");
					store_code = (String) map.get("store_desc");
					select_value = (String) map.get("select_value");
					dflt_select_value = checkForNull((String) map.get("dflt_select_value"));
					mode = checkForNull((String) map.get("mode"));
					if(("").equals(dflt_select_value)) dflt_select_value="N";
					if(("").equals(mode)||("undefined").equals(mode)) mode="I";


					
					//pstmt = select_value.equals("N")?pstmt1:pstmt2;
					if(("U").equals(mode) && ("Y").equals(select_value))
					{  
						pstmt3.setString(1,dflt_select_value);
						pstmt3.setString(2,(String) CommonData.get("login_user"));
						pstmt3.setString(3,(String) CommonData.get("login_at_ws_no"));
						pstmt3.setString(4,facility_id);
						pstmt3.setString(5,facility_id);//OPERATING_FACILITY_ID
						pstmt3.setString(6,oper_room_code);//OPER_ROOM_CODE
						pstmt3.setString(7,facility_name);//STORE_FACILITY_ID
						pstmt3.setString(8,store_code);//STORE_CODE
						pstmt3.setString(9,type_desc);//STORE_TYPE
						flag = pstmt3.executeUpdate();
						flag_arr.add(""+flag);
					}
					else if(select_value.equals("N")||("D").equals(mode)){
						// pstmt = pstmt1;
						 
					     pstmt1.setString(1,facility_id);
						 pstmt1.setString(2,oper_room_code);
						 pstmt1.setString(3,facility_name);//store_facility_id
						 pstmt1.setString(4,store_code);//store_code
			             flag = pstmt1.executeUpdate();
						 flag_arr.add(""+flag);
						//pstmt.addBatch();
					}else{
						//pstmt=pstmt2;
						pstmt2.setString(1,facility_id);
						pstmt2.setString(2,oper_room_code);
						pstmt2.setString(3,facility_name);//store_facility_id
						pstmt2.setString(4,store_code);//store_code
						pstmt2.setString(5,type_desc);//store_type
						pstmt2.setString(6,dflt_select_value);//store_type
						pstmt2.setString(7,(String) CommonData.get("login_user"));
						pstmt2.setString(8,(String) CommonData.get("login_at_ws_no"));
						pstmt2.setString(9,(String) CommonData.get("login_user"));
						pstmt2.setString(10,(String) CommonData.get("login_at_ws_no")); 
						pstmt2.setString(11,facility_id); 
						pstmt2.setString(12,facility_id); 
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
			  //  System.err.println("Err Msg in StoresforOperatingRoomServlet"+e.getMessage());
				//out.println(""+e);
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				if(pstmt3!=null) pstmt3.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){e.printStackTrace();}
	  }
    }
 }



