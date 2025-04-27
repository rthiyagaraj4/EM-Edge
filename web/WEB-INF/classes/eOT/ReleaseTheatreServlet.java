/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import org.xml.sax.InputSource;

public class ReleaseTheatreServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	String facility_id="";
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		session = req.getSession(false);
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
//		ArrayList arrList=new ArrayList();
//		HashMap hashElement=null;
		res.setContentType("text/html");	
		this.out = res.getWriter();
//		MasterXMLParse masterXmlParse= new eOT.MasterXMLParse();
		ArrayList tabData = parseXMLStream(req);

		out.println(ReleaseTheatre(tabData,req));
	}
		
	


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private ArrayList parseXMLStream(HttpServletRequest req){
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

	private int isBatchUpdateSucess(int[] status){
		int size = status.length;
		ArrayList list = new ArrayList();
		for(int k=size-1;k>=0;k--){
			list.add((status[k]!=-3)?"S":"E");
		}
		return (!list.contains("E"))?1:0;
	}

	
	private String  ReleaseTheatre(ArrayList tabData,HttpServletRequest req){
		int size = tabData.size();
		//{theatre_code=OT1, release_yn=Y, to_time=17:00, block_date=19/11/2006, from_time=08:00}]}
		String empty="".intern();
		String slots_sql="SELECT OPERATING_FACILITY_ID, OPER_ROOM_CODE, TO_CHAR(BOOKING_DATE,'DD/MM/YYYY'), TO_CHAR(BOOKING_TIME,'HH24:MI') FROM OT_BOOKING_TIME_SLOTS WHERE OPERATING_FACILITY_ID  = ? AND OPER_ROOM_CODE  = ? AND TRUNC(BOOKING_DATE) = TO_DATE(?,'DD/MM/YYYY') AND TO_NUMBER(TO_CHAR(BOOKING_TIME, 'SSSSS'))+1 BETWEEN TO_NUMBER(to_char(TO_date(?,'HH24:MI'),'SSSSS')) AND TO_NUMBER(to_char(TO_date(?,'HH24:MI'),'SSSSS'))+1  AND STATUS = '30' ORDER BY 4";
		
		//String update_status="UPDATE OT_BOOKING_TIME_SLOTS SET STATUS = '10' , TOOL_TIP_MSG= NULL WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ? AND  TRUNC(BOOKING_DATE)   = TO_DATE(?,'DD/MM/YYYY')  AND   TO_CHAR(BOOKING_TIME,'HH24:MI')  = ?";
		// The above update_status is modified by bshankar. Removed the TRUNC(Booking_date) and modified as below.
		String update_status="UPDATE OT_BOOKING_TIME_SLOTS SET STATUS = '10' , TOOL_TIP_MSG= NULL WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ? AND  BOOKING_DATE BETWEEN TO_DATE(?||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE(?||' 23:59','DD/MM/YYYY HH24:MI') AND TO_CHAR(BOOKING_TIME,'HH24:MI')  = ?";
		
		String delete_sql ="DELETE OT_BLOCK_OPER_ROOM WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ?  AND TRUNC(BLOCK_DATE) = TO_DATE(?,'DD/MM/YYYY') AND TO_CHAR(FR_SLOT_TIME,'HH24:MI') = ? AND TO_CHAR(TO_SLOT_TIME,'HH24:MI') = ?"; 



		String booking_date=empty;
		String booking_time=empty;
		String  msg = empty;
		int status=0;
		HashMap map = new HashMap();
//		ArrayList updt_arr=new ArrayList();
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt_1=null;
		PreparedStatement pstmt_2=null;
		ResultSet rst = null;
		
		try{
			con = ConnectionManager.getConnection();
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement(slots_sql);
			pstmt_1 = con.prepareStatement(update_status);
			pstmt_2 = con.prepareStatement(delete_sql);
			int index=0;
			
			for(int i=size-1;i>=0;i--){
				map = (HashMap) tabData.get(i);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,(String)map.get("theatre_code"));
				pstmt.setString(3,(String)map.get("block_date"));
				pstmt.setString(4,(String)map.get("from_time"));
				pstmt.setString(5,(String)map.get("to_time"));
				rst = pstmt.executeQuery();
				while(rst.next()){
					index++;
					booking_date = rst.getString(3);//booking_date
					booking_time = rst.getString(4);//booking_time
					pstmt_1.setString(1,facility_id);
					pstmt_1.setString(2,(String)map.get("theatre_code"));
					pstmt_1.setString(3,booking_date);
					pstmt_1.setString(4,booking_date);
					pstmt_1.setString(5,booking_time);
					pstmt_1.addBatch();
				}//end of while rst loop
				int[] result = pstmt_1.executeBatch();
				status = isBatchUpdateSucess(result);
				if(status>0){
				//	if(pstmt_2!= null) pstmt_2.close();
					pstmt_2.setString(1,facility_id);
					pstmt_2.setString(2,(String)map.get("theatre_code"));
					pstmt_2.setString(3,(String)map.get("block_date"));
					pstmt_2.setString(4,(String)map.get("from_time"));
					pstmt_2.setString(5,(String)map.get("to_time"));
					status= pstmt_2.executeUpdate();
				}
				if(status>0){
						msg = "RECORD_INSERTED";
						con.commit();
				}else {
					con.rollback();
					msg = "APP-OT0082";
				}
			if(rst!=null)rst.close(); //Common-ICN-0054

			}//end of for loop
			//tabData.clear();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			//	rst.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt_1!=null) pstmt_1.close();
				if(pstmt_2!=null) pstmt_2.close();
				if(rst!=null)rst.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){
			}
		}
		return msg;
		
	}
}
