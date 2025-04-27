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

public class ChecklistsServlet extends javax.servlet.http.HttpServlet {
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
		//res.setContentType("text/html");
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
		String locale = prop.getProperty("LOCALE") ;
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		int flag=0;
		int flag1=0;
	try{
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);	
		 HashMap master_map =(HashMap) hashElement.get("HEADER");
		 String msg="";
		 String key=(String) master_map.get("table_name")+"_"+(String) master_map.get("mode");
		 
		if(pstmt!=null) pstmt.close();
		 pstmt = con.prepareStatement(OTRepository.getOTKeyValue(key));

		 


		if(key.equals( "OT_CHECKLIST_HDR_INSERT") ){
		   	pstmt.setString(1,(String) master_map.get("checklist_code"));
			pstmt.setString(2,(String) master_map.get("description"));
			pstmt.setString(3,(String) master_map.get("status"));
			pstmt.setString(4,(String) CommonData.get("login_user"));
			pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(6,(String) CommonData.get("facility_id"));
			pstmt.setString(7,(String) CommonData.get("login_user"));
			pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(9,(String) CommonData.get("facility_id"));
		}else if(key.equals( "OT_CHECKLIST_HDR_MODIFY") ){
			pstmt.setString(1,(String) master_map.get("description"));
			pstmt.setString(2,(String) master_map.get("status"));
			pstmt.setString(3,(String) CommonData.get("login_user"));
			pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(5,(String) CommonData.get("facility_id"));
			pstmt.setString(6,(String) master_map.get("checklist_code"));
			}
		
		flag=pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
       if(flag>0)
		{
		   
		   con.commit();
	   
		}
	   else
		{
		   
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
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key) );
				String checklist_code=(String) hash.get("checklist_code");
                String checklist_item_code=(String) hash.get("checklist_item_code");
				String checklist_item_srl_no=(String) hash.get("checklist_item_srl_no");
				 //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
				//Start
				String intra_operative_sel=(String) hash.get("intra_operative_sel");
				//End

				if(key.equals( "OT_CHECKLIST_DTL_I") ){
				   pstmt.setString(1,checklist_code);
				   pstmt.setString(2,checklist_item_code);
				   pstmt.setString(3,checklist_item_srl_no);
				    //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
					//Start
				   pstmt.setString(4,intra_operative_sel);
				   //End
				   pstmt.setString(5,(String) CommonData.get("login_user"));
				   pstmt.setString(6,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(7,(String) CommonData.get("facility_id"));
				   pstmt.setString(8,(String) CommonData.get("login_user"));
				   pstmt.setString(9,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(10,(String) CommonData.get("facility_id"));
				
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_CHECKLIST_DTL_U") ){
					//rs=stmt.executeQuery("SELECT CHECKLIST_CODE,CHECKLIST_ITEM_CODE,CHECKLIST_ITEM_SRL_NO FROM OT_CHECKLIST_DTL WHERE CHECKLIST_CODE='"+checklist_code+"' and CHECKLIST_ITEM_CODE='"+checklist_item_code+"'");
					//if(!rs.next())
					//{
						//flag_update=true;
				
				   pstmt.setString(1,checklist_item_code);
				     //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
					//Start
				   pstmt.setString(2,intra_operative_sel);
				   //End
				   pstmt.setString(3,(String) CommonData.get("login_user"));
				   pstmt.setString(4,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(5,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(6,checklist_code);
				  pstmt.setString(7,checklist_item_srl_no);
				
                   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
					//}
					//else{
						//flag_update=false;
						//msg1="Checklist Item Code cannot be duplicated........";
					//}
				}else if(key.equals( "OT_CHECKLIST_DTL_D") ){
					pstmt.setString(1,(String) hash.get("checklist_code"));
					pstmt.setString(2,(String) hash.get("checklist_item_srl_no"));
				
					flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
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
			 //if(flag_update==false)
            // out.println(msg1);
			//else
			out.println(msg);
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



