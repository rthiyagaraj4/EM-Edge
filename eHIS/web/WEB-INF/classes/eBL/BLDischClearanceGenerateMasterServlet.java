package eBL;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import java.util.*;
import javax.servlet.ServletException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.BlRepository;
import eCommon.XSSRequestWrapper; //V220324


public class BLDischClearanceGenerateMasterServlet extends HttpServlet {
	
	Connection con = null;
	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 	
	
	boolean insertable = false;
	String genDischClearDocNum = "";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BLDischClearanceGenerateMasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private String checkForNull(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.err.println("Inside doPost method");
		con = ConnectionManager.getConnection(request);
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		try
		{
			System.err.println("Inside doPost method1");
			session = request.getSession(false);
			String error_value = "0";
			//String error = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			
			String episodeType = (String)request.getParameter("episodeType");
			String patientId = (String)request.getParameter("patientId");
			String episodeId = (String)request.getParameter("episodeId");
			String encounterId = (String)request.getParameter("encounterId");
			String acctSeqNo = (String)request.getParameter("acctSeqNo");
			String admissionDt = (String)request.getParameter("admissionDt");
			String curWardCode = (String)request.getParameter("curWardCode");
			String curBedClassCode = (String)request.getParameter("curBedClassCode");
			String curRoomNum = (String)request.getParameter("curRoomNum");
			String curBedNum = (String)request.getParameter("curBedNum");
			String curPhysicianId = (String)request.getParameter("curPhysicianId");
			String docType = (String)request.getParameter("docType");
			String docNumber = (String)request.getParameter("docNumber");
			String discAdviceAtTo = (String)request.getParameter("discAdviceAtTo");
			String patOutsAmt = (String)request.getParameter("patOutsAmt");
			String reasonCode = (String)request.getParameter("reasonCode");
			String userId = (String)request.getParameter("userId");
			String authRemarks = (String)request.getParameter("authRemarks");
					
			
			String procSql = "{ call   BL_DISCHARGE_CLEARANCE.BL_DISC_CLEARANCE_SAVE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			cstmt = con.prepareCall(procSql);							
			cstmt.setString(1, facilityId);
		    cstmt.setString(2, episodeType);
			cstmt.setString(3, patientId);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, encounterId);
			cstmt.setString(6, acctSeqNo);		
			cstmt.setString(7, admissionDt);
			cstmt.setString(8, curWardCode);
			cstmt.setString(9, curBedClassCode);
			cstmt.setString(10, curRoomNum);
			cstmt.setString(11, curBedNum);
			cstmt.setString(12, curPhysicianId);
			cstmt.setString(13, docType);
			cstmt.setString(14, docNumber);
			cstmt.setString(15, discAdviceAtTo);
			cstmt.setString(16, patOutsAmt);
			cstmt.setString(17, reasonCode);
			cstmt.setString(18, userId);	
			cstmt.setString(19, authRemarks);
			cstmt.setString(20, client_ip_address);
			cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
			
			
			cstmt.execute();
			
			str_error_text = cstmt.getString(21);
			genDischClearDocNum = cstmt.getString(22);
			String[] docInfo=genDischClearDocNum.split("/");
			if(str_error_text==null)
				insertable = true;
			
			cstmt.close();  
			
			if(insertable){
				str_error_text = "Operation Completed Successfully.";
				error_value = "1" ;
				response.sendRedirect("../eBL/jsp/BLDischClearReceipt.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value+
					"&docType="+docInfo[0]+
					"&docNumber="+docInfo[1]+
					"&episodeId="+episodeId+
					"&episodeType="+episodeType);
			
			}else{
				error_value = "0" ;
				response.sendRedirect("../eBL/jsp/BLDischClearReceipt.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value);
				
			}
					
			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in BLDischClearanceGenerateMasterServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in BLDischClearanceGenerateMasterServlet.java" + e.toString());
			e.printStackTrace();
			insertable = false;
		}finally{
			try
			{
				if(insertable){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 
					con.close();
				}
				if(cstmt!=null){
					cstmt.close();
				}
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in BLDischClearanceGenerateMasterServlet.java" + e.toString());				
			}	
		}
	}
}