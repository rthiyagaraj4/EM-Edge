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


public class SurgicalAccessoriesServlet extends javax.servlet.http.HttpServlet {
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
		String mode=req.getParameter("mode");
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty( "LOCALE" );
		String key="";
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		HashMap master_map=new HashMap();
		ArrayList tabData =	new ArrayList();
		int flag=0;
		int flag1=0;
		HashMap hash =new HashMap();
		ArrayList flag_arr = new ArrayList();
		String msg="";
	try{
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 if(mode.equals("insert")){
				hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);
				master_map =(HashMap) hashElement.get("HEADER");
				key=(String) master_map.get("table_name")+"_"+(String) master_map.get("mode");
                 
				if(key.equals( "OT_OPER_SURGICAL_ACCESSORIES_MODIFY") ){
				
					
					
				}
				else
				//StatementFactory.setDefaultDebug(DebugLevel.VERBOSE);
				//pstmt = StatementFactory.getStatement(con,OTRepository.getOTKeyValue(key) );
				 pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));
		 

				//No Modification in the header table, only insert operation
			if(key.equals( "OT_OPER_SURGICAL_ACCESSORIES_INSERT") ){
		   	pstmt.setString(1,(String) master_map.get("appl_desc"));
			pstmt.setString(2,(String) master_map.get("speciality_code"));
			pstmt.setString(3,(String) master_map.get("category_code"));
			pstmt.setString(4,(String) master_map.get("subCategory_code"));
			pstmt.setString(5,(String) master_map.get("operation_code"));
			pstmt.setString(6,(String) CommonData.get("login_user"));
			pstmt.setString(7,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(8,(String) CommonData.get("facility_id"));
			pstmt.setString(9,(String) CommonData.get("login_user"));
			pstmt.setString(10,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(11,(String) CommonData.get("facility_id"));
			flag=pstmt.executeUpdate();
		}
		
			MessageManager m=new MessageManager();

			if( flag>0){
					con.commit();
					final java.util.Hashtable mesg = m.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
				 }else{
					con.rollback();
					final java.util.Hashtable mesg = m.getMessage(locale, "APP-OT0082", "OT") ;
					msg = ((String) mesg.get("message"));
				 }


		
		tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		
		if(pstmt!=null) pstmt.close(); //Added Against Common-ICN-0031
		
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));
								
				if(key.equals( "OT_OPER_PACKAGE_I") ){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("package_code"));
				   pstmt.setString(3,(String) hash.get("package_qty"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
			  	   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
									
                }else if(key.equals("OT_OPER_EQUIPMENT_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("equipment_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				
				}else if(key.equals("OT_OPER_INSTRUMENT_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("instr_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
			  	   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("prosthesis_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else	if(key.equals("OT_OPER_PERSONNEL_REQD_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("role_id"));
				   pstmt.setString(3,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close(); //Added Against Common-ICN-0031

			}// end of for Loop
			MessageManager mm=new MessageManager();
			if( flag>0 && !flag_arr.contains("0")){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
				 }else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
					msg = ((String) mesg.get("message"));
				 }
		}

				 out.println(msg);
		 }else if(mode.equals("modify")){
				hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.DETAIL_ONLY);
				tabData =(ArrayList) hashElement.get("SEARCH");

		
	 int size = tabData.size();
		 if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
				pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));
				  if(key.equals("OT_OPER_PACKAGE_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("package_code"));
				   pstmt.setString(3,(String) hash.get("package_qty"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
			  	   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
									
                }else if(key.equals("OT_OPER_EQUIPMENT_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("equipment_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				
				}else if(key.equals("OT_OPER_INSTRUMENT_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("instr_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
			  	   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("prosthesis_code"));
				   pstmt.setString(3,(String) hash.get("no_Of_Units"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else	if(key.equals("OT_OPER_PERSONNEL_REQD_I")){
				   pstmt.setString(1,(String) hash.get("operation_code"));
				   pstmt.setString(2,(String) hash.get("role_id"));
				   pstmt.setString(3,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   pstmt.setString(10,(String) hash.get("speciality_code"));
				   pstmt.setString(11,(String) hash.get("category_code"));
				   pstmt.setString(12,(String) hash.get("subCategory_code"));
				   pstmt.setString(13,(String) hash.get("appl_desc"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				else if(key.equals("OT_OPER_PACKAGE_U1")){
		
				   pstmt.setString(1,(String) hash.get("package_qty"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
				
                   flag_arr.add(""+flag1);
				  }else if(key.equals("OT_OPER_PACKAGE_U2")){
				   pstmt.setString(1,(String) hash.get("package_qty"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
				   //where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
				  }else if(key.equals("OT_OPER_PACKAGE_U3")){
				   pstmt.setString(1,(String) hash.get("package_qty"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
				   //where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
				  }else if(key.equals("OT_OPER_PACKAGE_U4")){
				   pstmt.setString(1,(String) hash.get("package_qty"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
				   //where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("subCategory_code"));
				   pstmt.setString(9,(String) hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
				  }else if(key.equals("OT_OPER_PACKAGE_U5")){
				   pstmt.setString(1,(String) hash.get("package_qty"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
				   //where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("operation_code"));
				   pstmt.setString(7,(String) hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
				  
				}else if(key.equals("OT_OPER_PACKAGE_D1")){

				   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String)hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PACKAGE_D2")){
				   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String)hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PACKAGE_D3")){
				   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String)hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PACKAGE_D4")){
				   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("subCategory_code"));
				   pstmt.setString(5,(String)hash.get("package_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);			   
				}else if(key.equals("OT_OPER_PACKAGE_D5")){
					pstmt.setString(1,(String) hash.get("appl_desc"));
                    pstmt.setString(2,(String) hash.get("operation_code"));
					pstmt.setString(3,(String)hash.get("package_code"));
					flag1 = pstmt.executeUpdate();
                    flag_arr.add(""+flag1);
					
                }else if(key.equals("OT_OPER_EQUIPMENT_U1")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_U2")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_U3")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_U4")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("subCategory_code"));
				   pstmt.setString(9,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_U5")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("operation_code"));
				   pstmt.setString(7,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_D1")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				else if(key.equals("OT_OPER_EQUIPMENT_D2")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_D3")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_D4")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("subCategory_code"));
				   pstmt.setString(5,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_EQUIPMENT_D5")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("operation_code"));
				   pstmt.setString(3,(String) hash.get("equipment_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_U1")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_U2")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_U3")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_U4")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("subCategory_code"));
				   pstmt.setString(9,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_U5")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("operation_code"));
				   pstmt.setString(7,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_D1")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_D2")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_D3")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_D4")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("subCategory_code"));
				   pstmt.setString(5,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_INSTRUMENT_D5")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("operation_code"));
				   pstmt.setString(3,(String) hash.get("instr_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_U1")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
		
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_U2")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_U3")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_U4")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("subCategory_code"));
				   pstmt.setString(9,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_U5")){
				   pstmt.setString(1,(String) hash.get("no_Of_Units"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("operation_code"));
				   pstmt.setString(7,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_D1")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_D2")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_D3")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_D4")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("subCategory_code"));
				   pstmt.setString(5,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PROSTHESIS_D5")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("operation_code"));
				   pstmt.setString(3,(String) hash.get("prosthesis_code"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_U1")){
				   pstmt.setString(1,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_U2")){
				   pstmt.setString(1,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_U3")){
				   pstmt.setString(1,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_U4")){
				   pstmt.setString(1,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("speciality_code"));
				   pstmt.setString(7,(String) hash.get("category_code"));
				   pstmt.setString(8,(String) hash.get("subCategory_code"));
				   pstmt.setString(9,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_U5")){
				   pstmt.setString(1,(String) hash.get("no_Of_Persons"));
				   pstmt.setString(2,(String) CommonData.get("login_user"));
				   pstmt.setString(3,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(4,(String) CommonData.get("facility_id"));
					//where condition
				   pstmt.setString(5,(String) hash.get("appl_desc"));
				   pstmt.setString(6,(String) hash.get("operation_code"));
				   pstmt.setString(7,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_D1")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_D2")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_D3")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_D4")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("speciality_code"));
				   pstmt.setString(3,(String) hash.get("category_code"));
				   pstmt.setString(4,(String) hash.get("subCategory_code"));
				   pstmt.setString(5,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals("OT_OPER_PERSONNEL_REQD_D5")){
                   pstmt.setString(1,(String) hash.get("appl_desc"));
				   pstmt.setString(2,(String) hash.get("operation_code"));
				   pstmt.setString(3,(String) hash.get("role_id"));
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}
				
				if(pstmt!=null) pstmt.close(); //Added Against Common-ICN-0031
			}// end of for Loop
		 }
		
        
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
		 System.err.println("Err Msg in SurgicalAccessoriesServlet"+e.getMessage());
	}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }







