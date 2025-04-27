package eBL;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

import java.io.ByteArrayInputStream;
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

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;


public class BLRecordPaymentConsentMasterServlet extends HttpServlet {
	
	Connection con = null;
	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
    public BLRecordPaymentConsentMasterServlet() {
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
			String patientId = (String)request.getParameter("patient_Id");
			String episodeId = (String)request.getParameter("episodeId");
			String consentAmt = (String)request.getParameter("consentAmt");
			String consentDate = (String)request.getParameter("consentDate");
			String relName = (String)request.getParameter("relName");
			String relNationality = (String)request.getParameter("relNationality");
			String relCivilId = (String)request.getParameter("relCivilId");
			String relTelNum = (String)request.getParameter("relTelNum");
			String pmntUser = (String)request.getParameter("pmntUser");
			String signed_YN = (String)request.getParameter("signed_YN");
			String esign = (String)request.getParameter("esign");
			System.err.println("esign val is: "+esign);
			
			String byteString1 = (esign.split(",")[1]);
			System.err.println("byteString "+byteString1);
			byte[] imageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(byteString1);
			ByteArrayInputStream bis=new ByteArrayInputStream(imageByte);
		
			
			
			
			
			System.err.println("episodeType "+episodeType);	
			System.err.println("patientId "+patientId);	
			System.err.println("episodeId "+episodeId);	
			System.err.println("consentAmt "+consentAmt);	
			System.err.println("consentDate "+consentDate);	
			System.err.println("relName "+relName);	
			System.err.println("relNationality "+relNationality);	
			System.err.println("relCivilId "+relCivilId);	
			System.err.println("relTelNum "+relTelNum);	
			System.err.println("pmntUser "+pmntUser);
			System.err.println("signed_YN "+signed_YN);
			System.err.println("esign "+esign);
			System.err.println("bis "+bis);
			
			String procSql = "{ call   BL_INS_PAT_PMNT_CONSENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			cstmt = con.prepareCall(procSql);	
			
			cstmt.setString(1, facilityId);
		    cstmt.setString(2, patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, consentAmt);
			cstmt.setString(6, consentDate);	
			cstmt.setString(7, pmntUser);
			cstmt.setString(8, relName);
			cstmt.setString(9, relNationality);
			cstmt.setString(10, relCivilId);
			cstmt.setString(11, relTelNum);
		//	cstmt.setString(12, null);
			cstmt.setBinaryStream(12, bis,imageByte.length);
			cstmt.setString(13, "Y");
			cstmt.setString(14, login_user);
			cstmt.setString(15, null);
			cstmt.setString(16, client_ip_address);
			cstmt.setString(17, facilityId);
			cstmt.setString(18, login_user);
			cstmt.setString(19, null);
			cstmt.setString(20, client_ip_address);
			cstmt.setString(21, facilityId);
			cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(23, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
			
			
			cstmt.execute();
			str_error_level = cstmt.getString(22);
			str_sysmesage_id = cstmt.getString(23);
			str_error_text = cstmt.getString(24);
			
			System.err.println("str_sysmesage_id in PD Details:"+str_sysmesage_id);
			System.err.println("str_error_level in PD Details:"+str_error_level);
			System.err.println("str_error_text in PD Details:"+str_error_text);
				
			
			if(str_error_text==null && str_sysmesage_id==null && str_error_text==null)
				insertable = true;
			
			cstmt.close();  
			
			
			
			if(insertable){
				error_value = "1" ;
				error = "APP-SM0070 Operation Completed Successfully ....";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );	
			}else{
				error_value = "0" ;
				error = str_sysmesage_id + "Error from procedure " +str_error_text;
				response.sendRedirect("../eBL/jsp/BLDischClearReceipt.jsp?message=" + java.net.URLEncoder.encode( str_error_text,"UTF-8" ) +"&err_value="+error_value);
			}

			if(pstmt!=null){
				pstmt.close();
				rst.close();
			}
		}catch(SQLException sqle){
			System.err.println("164,SQLException in BLRecordPaymentConsentMasterServlet.java" + sqle.toString());
			sqle.printStackTrace();
			insertable = false;
		}catch(Exception e){
			System.err.println("168,Exception in BLRecordPaymentConsentMasterServlet.java" + e.toString());
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
				System.err.println("Final catch excep in BLRecordPaymentConsentMasterServlet.java" + e.toString());				
			}	
		}
	}
}