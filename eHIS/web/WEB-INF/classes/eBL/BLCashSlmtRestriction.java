/**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2			 V231128  			 51666 		   GHL-CRF-0642-US004			 Namrata Charate
 */
package eBL;

import com.google.gson.JsonObject;
import eBL.Common.BlRepository;
import eBL.billreceipt.request.BillReceiptRequest;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Locale;
import java.util.ResourceBundle;
import webbeans.eCommon.ConnectionManager;
import java.text.SimpleDateFormat;


public class BLCashSlmtRestriction {
	
	public String blCashSlmt(String slmtTypeCode){
		PreparedStatement pstmt = null;
		Connection con = null;
		String cashYn = "N";
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select bl_cash_slmt_limitation.bl_slmt_cash_type_yn(?) cashYn from dual ");
			pstmt.setString(1,slmtTypeCode);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				cashYn = rst.getString("cashYn");
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in blcashslmt ->"+e);
			e.printStackTrace();
			cashYn = "N";
		}
		finally{
			//rst = null; //commented V210416
			//pstmt = null;
			try{
				if(pstmt != null) {
					pstmt.close(); 
				}
				if(rst != null) {
					rst.close(); 
				}
			}catch(Exception e){
				System.out.println("EXCEPTION in blcashslmt: " + e);
				e.printStackTrace();
			}//Added for V210416
			
			ConnectionManager.returnConnection(con);
		}
		return cashYn;
	}
	
	public String checkCashRestrictionEligibility(String facilityId){
		PreparedStatement pstmt = null;
		Connection con = null;
		String siteEligibility = "N";
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select bl_cash_slmt_limitation.get_cash_slmt_setup(?) siteEligibility from dual ");
			pstmt.setString(1,facilityId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				siteEligibility = rst.getString("siteEligibility");
			}
		}
		catch(Exception e){
			System.err.println("Exception in blcashslmt ->"+e);
			e.printStackTrace();
			siteEligibility = "N";
		}
		finally{
			try{
				if(pstmt != null) {
					pstmt.close(); 
				}
				if(rst != null) {
					rst.close(); 
				}
			}catch(Exception e){
				System.out.println("exception in blcashslmtrest statement : " + e);
				e.printStackTrace();
			}//Added for V210416
			
			//rst = null; //commented V210416
			//pstmt = null; //commented V210416
			ConnectionManager.returnConnection(con);
		}
		return siteEligibility;
	}
	
	
	
	public JsonObject BLPatientDepValidate(String facilityId,String patientId,String depositAmt){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		String messageText="";
		String locale = "en";
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
				
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("PATIENT_DEPOSIT_VALIDATE"));
			cstmt.setString(1,facilityId);
			cstmt.setString (2,patientId);
			cstmt.setString (3,depositAmt);					
			cstmt.registerOutParameter(4, Types.VARCHAR);							
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();
			String errorLevel = replaceNull(cstmt.getString(4));
			String sysMessageId = replaceNull(cstmt.getString(5));
			String errorText = replaceNull(cstmt.getString(6));		
			String messageTextExtn = replaceNull(cstmt.getString(7));
			
			if("".equals(errorLevel) && "".equals(sysMessageId) && "".equals(errorText) && "".equals(messageTextExtn)){
				obj.addProperty("allowYn","Y");
			}
			else{
				obj.addProperty("allowYn","N");
				obj.addProperty("errorText",errorText);
				try{
					messageText = rb.getString(sysMessageId);
				}
				catch(Exception rbException){
					messageText = getMessageString(sysMessageId,con);
					rbException.printStackTrace();
					System.err.println("Exceprion in RB ->"+rbException);
				}
				obj.addProperty("messageText",messageText);
				System.err.println("messageTextExtn: "+messageTextExtn.replaceAll("\n"," \n "));  //V231128
				obj.addProperty("messageTextExtn",messageTextExtn);  //V231128
			}				
		}
		catch(Exception e){
			System.err.println("Exception in BLPatientDepValid ->"+e);
			e.printStackTrace();
		}
		finally{
			try{
				//cstmt = null;
				if(cstmt != null) {  //Added for V210416
					cstmt.close();
				}
			} 
			catch(Exception ex){
				System.err.println("Exception in BLcashslmt close ->"+ex);
				ex.printStackTrace();
			}
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	
	public JsonObject BLPatientRecValidate(
			String facilityId,
			String docTypeCode, 
			String docNum,
			String docDate,
			String episodeType,
			String episodeId,
			String visitId,
			String patientId,
			String slmtAmt
			){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		String messageText="";
		String locale = "en";
		Locale loc = new Locale(locale);
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);		
		
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("PATIENT_RECEIPT_VALIDATE"));
			cstmt.setString(1,facilityId);
			cstmt.setString (2,docTypeCode);
			cstmt.setString (3,docNum);	
			if((docDate == null) || ("".equals(docDate))){
				cstmt.setString(4, null);
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date docsDate = new Date(sdf.parse(docDate).getTime());
				cstmt.setDate(4, docsDate);
			}
			cstmt.setString (5,episodeType);
			cstmt.setString (6,episodeId);
			cstmt.setString(7,visitId);
			cstmt.setString (8,patientId);
			cstmt.setString (9,slmtAmt);
			cstmt.registerOutParameter(10, Types.VARCHAR);							
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.execute();
			String errorLevel = replaceNull(cstmt.getString(10));
			String sysMessageId = replaceNull(cstmt.getString(11));
			String errorText = replaceNull(cstmt.getString(12));		
			String messageTextExtn = replaceNull(cstmt.getString(13));
			if("".equals(errorLevel) && "".equals(sysMessageId) && "".equals(errorText) && "".equals(messageTextExtn)){
				obj.addProperty("allowYn","Y");
			}
			else{
				obj.addProperty("allowYn","N");
				obj.addProperty("errorText",errorText);
				try{
					messageText = rb.getString(sysMessageId);
				}
				catch(Exception rbException){
					messageText = getMessageString(sysMessageId,con);
					System.err.println("Exceprion in RB ->"+rbException);
					rbException.printStackTrace();
				}
				obj.addProperty("messageText",messageText);
				System.err.println("messageTextExtn: "+messageTextExtn);
				obj.addProperty("messageTextExtn",messageTextExtn);
			}				
		}
		catch(Exception e){
			System.err.println("Exception in BLPatientRecValid:  "+e);
			e.printStackTrace();
		}
		finally{
			try{
				//cstmt = null; //commented V210416
				if(cstmt != null) {
					cstmt.close(); //Added for V210416
				}
			}catch(Exception e){
				System.err.println("exception wwhile closing cstmt:"+e);
				e.printStackTrace();
			}
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	

	public String replaceNull(String input){
		if(input == null || "null".equals(input)|| input== " "){
			input = "";
		}
		return input;
	}
	
	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
			
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			e.printStackTrace();
			output = messageId;
		}
		finally{
			try{
				if(pstmt != null) {
					pstmt.close(); //Added for V210416
				}
				if(rst != null) {
					rst.close(); //Added for V210416
				}
			}catch(Exception ex){
				System.err.println("exception while closing stat:"+ex);
				ex.printStackTrace();
			}
			//rst = null;
			//pstmt = null;//commented V210416
		}
		return output;
	}	
}
	
	
