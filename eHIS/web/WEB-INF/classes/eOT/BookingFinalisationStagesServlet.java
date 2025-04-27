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
import eOT.Common.OTRepository;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;

/*import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;*/



public class BookingFinalisationStagesServlet extends javax.servlet.http.HttpServlet {
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
		//PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
		out=res.getWriter();
					
		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = prop.getProperty( "client_ip_address" );
		String facility_id = (String)session.getValue( "facility_id" ) ;	
		String login_user = prop.getProperty( "login_user" ); 
		String locale = prop.getProperty("LOCALE") ;
					
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		String specific_indicator=req.getParameter("specific_indicator");
		int flag=0;
		int flag1=0;
		
	    try{
		 con = ConnectionManager.getConnection(req);
		 InputSource inputSource=new InputSource(req.getReader());
		 hashElement = MasterParse.parseXMLData(inputSource,null,null,eOT.MasterParse.HEADER_DETAIL);	
		 HashMap master_map =(HashMap) hashElement.get("HEADER");
		 String msg="";
		 String table_name = (String) master_map.get("table_name");
		 if(table_name.equals("OT_BOOKING_FIN_STAGES_LANG_VW"))
			 table_name = "OT_BOOKING_FIN_STAGES";

		 String key=table_name+"_"+(String) master_map.get("mode");
		   pstmt = con.prepareStatement(OTRepository.getOTKeyValue(key));
		 		 
		 if(key.equals( "OT_BOOKING_FIN_STAGES_INSERT")){
			pstmt.setString(1,(String) master_map.get("stage_code"));
			pstmt.setString(2,(String) master_map.get("pre_stage_description"));
			pstmt.setString(3,(String) master_map.get("post_stage_description"));
			pstmt.setString(4,(String) master_map.get("srl_no"));
			pstmt.setString(5,(String) master_map.get("position_code"));
			pstmt.setString(6,(String) master_map.get("specific_indicator"));
			pstmt.setString(7,(String) master_map.get("action_if_not_done"));
			pstmt.setString(8,(String) master_map.get("pac_stage_yn"));
			pstmt.setString(9,(String) master_map.get("color_ind"));
			pstmt.setString(10,(String) master_map.get("text_color"));
			pstmt.setString(11,(String) CommonData.get("login_user"));
			pstmt.setString(12,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(13,(String) CommonData.get("facility_id"));
			pstmt.setString(14,(String) CommonData.get("login_user"));
			pstmt.setString(15,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(16,(String) CommonData.get("facility_id"));
		}else if(key.equals( "OT_BOOKING_FIN_STAGES_MODIFY")){
			pstmt.setString(1,(String) master_map.get("pre_stage_description"));
			pstmt.setString(2,(String) master_map.get("post_stage_description"));
			pstmt.setString(3,(String) master_map.get("srl_no"));
			pstmt.setString(4,(String) master_map.get("position_code"));
			pstmt.setString(5,(String) master_map.get("specific_indicator"));
			pstmt.setString(6,(String) master_map.get("action_if_not_done"));
			pstmt.setString(7,(String) master_map.get("pac_stage_yn"));
			pstmt.setString(8,(String) master_map.get("color_ind"));
			pstmt.setString(9,(String) master_map.get("text_color"));
			pstmt.setString(10,(String) CommonData.get("login_user"));
			pstmt.setString(11,(String) CommonData.get("login_at_ws_no"));
			pstmt.setString(12,(String) CommonData.get("facility_id"));
			pstmt.setString(13,(String) master_map.get("stage_code"));
		}
		flag=pstmt.executeUpdate();
		if(pstmt !=null) pstmt.close();
      	ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		int size = tabData.size();
		HashMap hash = null;
		ArrayList flag_arr = new ArrayList();
		if(size>0){
			for(int i=0;i<size;i++){
				hash = (HashMap) tabData.get(i);
				table_name = (String) hash.get("table_name");
				if(table_name.equals("OT_BOOKING_FIN_STAGES_DTL_LANG_VW"))
					table_name = "OT_BOOKING_FIN_STAGES_DTL";
				key = table_name+"_"+(String) hash.get("mode");
	pstmt=con.prepareStatement(OTRepository.getOTKeyValue(key));
				
				if(key.equals( "OT_BOOKING_FIN_STAGES_DTL_I")){
				   pstmt.setString(1,(String) hash.get("stage_code"));
				   pstmt.setString(2,(String) hash.get("facility_id"));
				   pstmt.setString(3,(String) hash.get("user_id"));
				   pstmt.setString(4,(String) CommonData.get("login_user"));
				   pstmt.setString(5,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(6,(String) CommonData.get("facility_id"));
				   pstmt.setString(7,(String) CommonData.get("login_user"));
				   pstmt.setString(8,(String) CommonData.get("login_at_ws_no"));
				   pstmt.setString(9,(String) CommonData.get("facility_id"));
				   
				   flag1 = pstmt.executeUpdate();
                   flag_arr.add(""+flag1);
				}else if(key.equals( "OT_BOOKING_FIN_STAGES_DTL_D")){					
					pstmt.setString(1,(String) hash.get("stage_code"));
					pstmt.setString(2,(String) hash.get("facility_id"));
					pstmt.setString(3,(String) hash.get("user_id"));

					flag1 = pstmt.executeUpdate();
					flag_arr.add(""+flag1);
				}
				if(pstmt!=null) pstmt.close();
				//end of if else
				//pstmt.addBatch();
			}// end of for Loop
            			
		}//end of if Block
		if(specific_indicator.equals("*ALL")){
            MessageManager mm=new MessageManager();
			if(flag>0){
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
			}else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
			}
		}else if(specific_indicator.equals("SPC")){
            MessageManager mm=new MessageManager();
			if(flag>0  && !flag_arr.contains("0")){
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
			}else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
			}
		}//end of if else
		if(pstmt!=null) pstmt.close();
		out.println(msg);
	}catch(Exception e){
		e.printStackTrace();
		 System.err.println("Err Msg in BookingFinalisationStagesServlet"+e.getMessage());
	}finally{
				if(con!=null) ConnectionManager.returnConnection(con,req);
		
	  }
    }
 }



