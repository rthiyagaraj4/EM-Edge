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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import eOT.Common.OTRepository;
import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;
import webbeans.eCommon.ConnectionManager;
import eOT.MasterXMLParse;

public class DiaryScheduleForSurgeonServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
//		HttpSession session=req.getSession(false);
		PrintWriter out=res.getWriter();
		//CRF-004 Authorize Slots for Booking - Rajesh V
		String otParam = req.getParameter("otParam");
		//CRF-004 Authorize Slots for Booking - Rajesh V
		String msg="";
		int status=0;
		HashMap hash = null;
		String mode="";
		String key="";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		ArrayList flag_arr = new ArrayList();
		HashMap CommonData = getCommonData(req);
		ArrayList tabData = parseXMLReader(req);
		int size = tabData.size();
	try{
		con = ConnectionManager.getConnection(req);
		for(int i=0;i<size;i++){
			hash = (HashMap) tabData.get(i);
			mode = (String) hash.get("mode");
			key = (String) hash.get("table_name")+"_"+(String) hash.get("mode");
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue(key));
			pstmt=setParameters(pstmt,hash,CommonData,mode,otParam);//CRF-004 Authorize Slots for Booking - Rajesh V
			status = pstmt.executeUpdate();
			flag_arr.add(""+status);					
		}
	
		if( !flag_arr.contains("0")){
				con.commit();
				msg = "RECORD_INSERTED";
		}else{
				con.rollback();
				msg = "APP-OT0082";
		}				
		out.println(msg);
    }catch(Exception e){
		 e.printStackTrace();
	}finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	 }
  }

  private ArrayList parseXMLReader(HttpServletRequest req){
		ArrayList arrList=new ArrayList(5);
		HashMap hashElement = new HashMap();
		try{
			MasterXMLParse masterXMLParse=new MasterXMLParse();
			InputSource inputSource=new InputSource(req.getReader());
			hashElement = masterXMLParse.parseXMLData(inputSource,null,arrList,eOT.MasterXMLParse.DETAIL_ONLY);	
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList tabData =(ArrayList) hashElement.get("SEARCH");
		return tabData;
	}

	private HashMap getCommonData(HttpServletRequest req){
		HashMap CommonData = new HashMap();
		HttpSession session = req.getSession(false);
		String facility_id =(String)session.getAttribute("facility_id") ;
		java.util.Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String client_ip_address = prop.getProperty( "client_ip_address" );
		String login_user = prop.getProperty( "login_user" );
//		String locale = prop.getProperty("LOCALE") ;
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		return CommonData;
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V
	public PreparedStatement setParameters(PreparedStatement pstmt,HashMap map,HashMap commonData, String mode, String otParam)throws java.sql.SQLException{
		//return "I".equals(mode)?setParameterForInsert(pstmt,map,commonData):setParameterForUpdate(pstmt,map,commonData);
		if ("I".equals(mode)){
				return setParameterForInsert(pstmt,map,commonData,otParam);//CRF-004 Authorize Slots for Booking - Rajesh V
		} else if ("U".equals(mode)){
				return setParameterForUpdate(pstmt,map,commonData,otParam);//CRF-004 Authorize Slots for Booking - Rajesh V
		} else if ("D".equals(mode)){
				return setParameterForDelete(pstmt,map,commonData);
		}
		return null;
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V
	private PreparedStatement setParameterForInsert(PreparedStatement pstmt,HashMap hash,HashMap CommonData, String otParam) throws java.sql.SQLException{
	   String[] week = new String[5];
	   String str_week = "";
	   pstmt.setString(1,(String) hash.get("operating_facility_id"));
	   pstmt.setString(2,(String) hash.get("oper_room_code"));
	   pstmt.setString(3,(String) hash.get("day"));
	   pstmt.setString(4,(String) hash.get("surgeon_code"));
	   pstmt.setString(5,(String) hash.get("speciality_code"));
	   pstmt.setString(6,(String)hash.get("start_time"));
	   pstmt.setString(7,(String)hash.get("end_time"));
	   pstmt.setString(8,(String) hash.get("schedule_type"));
	   str_week = (String) hash.get("week");
	   for(int j=0;j<str_week.length();j++){
		 week[j] = str_week.substring(j,j+1);
	   }
	   pstmt.setString(9,week[0]);
	   pstmt.setString(10,week[1]);
	   pstmt.setString(11,week[2]);
	   pstmt.setString(12,week[3]);
	   pstmt.setString(13,week[4]);
	   pstmt.setString(14,(String) CommonData.get("login_user"));
	   pstmt.setString(15,(String) CommonData.get("login_at_ws_no"));
	   pstmt.setString(16,(String) CommonData.get("facility_id"));
	   pstmt.setString(17,(String) CommonData.get("login_user"));
	   pstmt.setString(18,(String) CommonData.get("login_at_ws_no"));
	   pstmt.setString(19,(String) CommonData.get("facility_id"));
	   //CRF-004 Authorize Slots for Booking - Rajesh V
	   if("Y".equalsIgnoreCase(otParam)){
			pstmt.setInt(20,Integer.parseInt((String) hash.get("totalSlots")));
			if("".equals((String) hash.get("restrictedSlots"))){
				pstmt.setString(21,null);
			}
			else{
				pstmt.setInt(21,Integer.parseInt((String) hash.get("restrictedSlots")));
			}
			
	   }
	   else{
			pstmt.setString(20,null);
			pstmt.setString(21,null);
	   }
	   //CRF-004 Authorize Slots for Booking - Rajesh V
	   return pstmt;
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V
	private PreparedStatement setParameterForUpdate(PreparedStatement pstmt,HashMap hash,HashMap CommonData,String otParam) throws java.sql.SQLException {
		String[] week = new String[5];
	    String str_week = "";
		// pstmt.setString(1,(String)hash.get("start_time"));
		 pstmt.setString(1,(String)hash.get("end_time"));
		 pstmt.setString(2,(String)hash.get("schedule_type"));
	     str_week = (String) hash.get("week");
	     for(int j=0;j<str_week.length();j++){
			 week[j] = str_week.substring(j,j+1);
		 }
		 pstmt.setString(3,week[0]);
		 pstmt.setString(4,week[1]);
		 pstmt.setString(5,week[2]);
		 pstmt.setString(6,week[3]);
		 pstmt.setString(7,week[4]);
		 pstmt.setString(8,(String) CommonData.get("login_user"));
		 pstmt.setString(9,(String) CommonData.get("login_at_ws_no"));
		 pstmt.setString(10,(String) CommonData.get("facility_id"));
		//CRF-004 Authorize Slots for Booking - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
			pstmt.setInt(11,Integer.parseInt((String) hash.get("totalSlots")));
			if("".equals((String) hash.get("restrictedSlots"))){
				pstmt.setString(12,null);
			}
			else{
				pstmt.setInt(12,Integer.parseInt((String) hash.get("restrictedSlots")));
			}
		}
		else{
			pstmt.setString(11,null);
			pstmt.setString(12,null);
		}
		//where condition
		 pstmt.setString(13,(String) hash.get("operating_facility_id"));
		 pstmt.setString(14,(String) hash.get("oper_room_code"));
		 pstmt.setString(15,(String) hash.get("day"));
		 pstmt.setString(16,(String) hash.get("surgeon_code"));
		 pstmt.setString(17,(String) hash.get("speciality_code"));
		 pstmt.setString(18,(String)hash.get("start_time"));
		//CRF-004 Authorize Slots for Booking - Rajesh V
		 return pstmt;

	}

		private PreparedStatement setParameterForDelete(PreparedStatement pstmt,HashMap hash,HashMap CommonData) throws java.sql.SQLException {
		 //where condition
	     pstmt.setString(1,(String) hash.get("operating_facility_id"));
	     //pstmt.setString(1,(String) CommonData.get("facility_id"));
		 pstmt.setString(2,(String) hash.get("day"));
		 //pstmt.setString(3,(String) hash.get("resource"));
		 pstmt.setString(3,"D");
	     pstmt.setString(4,(String) hash.get("surgeon_code"));
		 pstmt.setString(5,(String) hash.get("oper_room_code"));
		 pstmt.setString(6,(String) hash.get("start_time"));
		 pstmt.setString(7,(String) hash.get("end_time"));
	     pstmt.setString(8,(String) hash.get("speciality_code"));
	     pstmt.setString(9,(String) hash.get("schedule_type"));
		 return pstmt;

	}
}


