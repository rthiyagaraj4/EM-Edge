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


public class BLDischClearanceCancelMasterServlet extends HttpServlet {
	
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
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BLDischClearanceCancelMasterServlet() {
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
			String error = "";			
		
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;  
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ; 
			locale	= (String)session.getAttribute("LOCALE");
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			String episodeType = (String)request.getParameter("episodeType");
			String patientId = (String)request.getParameter("patientId");
			String episodeId = (String)request.getParameter("episodeId");
			//String docType = (String)request.getParameter("docType");
			//String docNumber = (String)request.getParameter("docNumber");
			String reasonCode = (String)request.getParameter("reasonCode");
			String userId = (String)request.getParameter("userId");
			String authRemarks = (String)request.getParameter("authRemarks");
			
					
			
			String procSql = "{ call   BL_CANCEL_DISCHARGE_CLEARANCE.BL_CANC_DISC_CLEARANCE_SAVE(?,?,?,?,?,?,?,?) }";
			
			cstmt = con.prepareCall(procSql);	
			
			cstmt.setString(1, facilityId);
		    cstmt.setString(2, episodeType);
			cstmt.setString(3, patientId);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, reasonCode);
			cstmt.setString(6, userId);	
			cstmt.setString(7, authRemarks);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			
			
			cstmt.execute();
			
			str_error_text = cstmt.getString(8);   
			str_error_text = "";
			System.err.println("str_error_text is: "+str_error_text);
			
			if(str_error_text==null || str_error_text=="")
				insertable = true;
			
			cstmt.close();   
			
			if(insertable){
				error_value = "1" ;
				error = "Discharge Clearance Cancelled <br> APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				error = "Record has not been saved. Please try again";			
			}
			
			
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );	



			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in BLDischClearanceCancelMasterServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in BLDischClearanceCancelMasterServlet.java" + e.toString());
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
				else{
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch excep in BLDischClearanceCancelMasterServlet.java" + e.toString());				
			}	
		}
	}
}