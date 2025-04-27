/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;
import webbeans.eCommon.ConnectionManager;
import java.sql.SQLException;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class DrugForNotificationServlet extends HttpServlet
{

   public void init(ServletConfig servletconfig)  throws ServletException{
        super.init(servletconfig);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession httpsession = req.getSession(false);
        
		
	
		//declaration of variables;
		HashMap hashmap = new HashMap(37);
		List arrLst = new ArrayList(37);
		Connection con = null;
		PreparedStatement pstmt= null;
		String[] audit_flds = new String[3];
		List arraylist = new ArrayList(37);
		List arr = new ArrayList(37);
		HashMap hmap = null;
       
	   //SQL Strings
	   String ins_sql = "INSERT INTO OT_DRUGS_FOR_NOTIFICATION (DEFN_TYPE,DRUG,NOTIFY_PRE_ANESTHESIA_YN,ADDED_BY_ID,ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO)VALUES(?, ?,NVL(?,'N'),?,SYSDATE,?,?,?,SYSDATE,?,?)";

		String upd_sql = "UPDATE OT_DRUGS_FOR_NOTIFICATION SET NOTIFY_PRE_ANESTHESIA_YN = NVL(?,'N'),MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE DEFN_TYPE = ? AND DRUG = ?";

		//getting the auditing fields.
		String facility_id = (String)httpsession.getAttribute("facility_id");
		String login_user = (String)httpsession.getAttribute("login_user");
        Properties properties = (Properties)httpsession.getAttribute("jdbc");
		String locale = (String) properties.getProperty( "LOCALE" ) ;
        String login_at_ws_no = properties.getProperty("client_ip_address");
		//audit fields stored into String array
		audit_flds[0]=login_user;
		audit_flds[1]=facility_id;
		audit_flds[2]=login_at_ws_no;
        String key="";
		PrintWriter out = res.getWriter();
        MasterXMLParse masterxmlparse = new MasterXMLParse();
		 
		try{
			
			con = ConnectionManager.getConnection(req);
            InputSource inputsource = new InputSource(req.getReader());
            hashmap = masterxmlparse.parseXMLData(inputsource, null, null, 3);
            arrLst = (ArrayList)hashmap.get("SEARCH");
			if(arrLst!=null && arrLst.size() > 0){
                Iterator itr = arrLst.iterator();
			   for(;itr.hasNext();){
				 hmap = (HashMap)itr.next();
				 key =  (String)hmap.get("db_action");
				 pstmt = (key.equals("I"))?con.prepareStatement(ins_sql):con.prepareStatement(upd_sql);
				 int flag_rec = setParamater(pstmt,key,hmap,audit_flds).executeUpdate();
				arr.add(""+flag_rec);
			   }
			   
			  boolean flag = true;
              MessageManager mm=new MessageManager();
			  String msg ="";
			  if(arr.contains("0")){ 
				 con.rollback();
				 flag = false;
				final java.util.Map mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
 				out.println(msg);
			 }else{
				  con.commit();
				final java.util.Map mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				out.println(msg);
			}
			 
		  }
        }catch(Exception e){
			e.printStackTrace();
            //System.err.println("Err Msg in DrugForNotificationServlet  "+e);
			//out.println(e);
        }
		finally{
			try{
					hashmap.clear();arraylist.clear(); arr.clear();
					arrLst.clear(); hmap.clear();
				 if(pstmt!=null) pstmt.close();
				 if(con!=null) ConnectionManager.returnConnection(con,req);
 			}catch(Exception e){e.printStackTrace();}
		}
    }

	public PreparedStatement setParamater(PreparedStatement pstmt,String key, HashMap map,String[] audit_flds) throws SQLException{
		//PreparedStatement pstmt; 
		switch(key.charAt(0)){
			case 'I' :  
						pstmt.setString(1,(String)map.get("def_type"));						
						pstmt.setString(2,(String)map.get("drug_code"));						
						pstmt.setString(3,(String)map.get("notify_yn"));						
						pstmt.setString(4,audit_flds[0]);						
						pstmt.setString(5,audit_flds[1]);						
						pstmt.setString(6,audit_flds[2]);						
						pstmt.setString(7,audit_flds[0]);						
						pstmt.setString(8,audit_flds[1]);						
						pstmt.setString(9,audit_flds[2]);						
						break;
			case 'U' : 
						pstmt.setString(1,(String)map.get("notify_yn"));						
						pstmt.setString(2,audit_flds[0]);						
						pstmt.setString(3,audit_flds[1]);						
						pstmt.setString(4,audit_flds[2]);						
						pstmt.setString(5,(String)map.get("def_type"));						
						pstmt.setString(6,(String)map.get("drug_code"));					
						break;
		}
		return pstmt;		
	}

  }
