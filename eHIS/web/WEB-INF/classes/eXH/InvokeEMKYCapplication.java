/***************************************************************************************************************
 * Author   :   Prithvirajan. R
 * Desc     :	This class is used to invoke the external EGL application
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;
import eXH.InterfaceUtil;

/**
 * Servlet implementation class InvokeEGLapplication
 */
public class InvokeEMKYCapplication extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseTxt=null;
		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType");

			System.out.println("call type..."+callType);
		
			if("KYC".equals(callType)) // Just sample... have to be removed.
			{
					responseTxt=getKYCresponse(reqParams);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}
			else if("GetKYCconfigValue".equals(callType)) // Just sample... have to be removed.
			{
					responseTxt=InterfaceUtil.getKYCconfigValue();
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}
			else if("PanCardValidation".equals(callType)) // Just sample... have to be removed.
			{
					responseTxt=panCardValidation(reqParams);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}
			else if("GetTranslationData".equals(callType)) // Just sample... have to be removed.
			{
				    String tableId = reqParams.get("tableId");
				    String appId = reqParams.get("appId");
					String fieldValue = reqParams.get("fieldValue");
					System.out.println("InvokeEMKYCapplication::getTranslationData::::transValue for appId.."+appId+"....tableId..."+tableId+"...fieldValue ..." +fieldValue);

					responseTxt=InterfaceUtil.getTranslationData(tableId,appId,fieldValue);
					System.out.println("Response from InvokeEMKYCapplication..."+responseTxt);

					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}
			
		}
		catch (Exception exp) 
		{
			exp.printStackTrace(System.err);
		}
    }

	 /*
	  * 
	  * just sample.
	  */
	private String getKYCresponse(Map<String, String> reqParams) throws Exception 
	{
		System.out.println("get kyc response...");
		String responseTxt="";
		String imageText="";
		try
		{
			imageText="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";
			responseTxt = "{"
			+"\"kycDetails\":{"
			+"\"uid\":\"776580373031\","
			+"\"dob\":\"12-03-1991\","
			+"\"gender\":\"M\","
			+"\"name\":\"Kishor Jotiram Toraskar\","
			+"\"phone\":\"\","
			+"\"co\":\"\","
			+"\"district\":\"Kolhapur\","
			+"\"house\":\"\","
			+"\"landMark\":\"\","
			+"\"location\":\"taluka- karveer\","
			+"\"postalCode\":\"416204\","
			+"\"postOffice\":\"\","
			+"\"state\":\"Maharashtra\","
			+"\"street\":\"\","
			+"\"subdist\":\"\","
			+"\"vtc\":\"Sangrul\","
			+"\"vtcCode\":\"27-2734-A25D1F7B4D59BFBA90B0094C4B4BD0FB\","
			+"\"photo\":\""+imageText+"\","
			+"\"emailAddress\":\"\""
			+"}"
			+"\"authenticationCode\":\"633a574bfd6b41518029afa1b3db0579\","
			+"\"timeStamp\":\"192.168.40.11\","
			+"\"transactionId\":\"WITHDRAW_MONEY\","
			+"\"responseMessage\":\"POS\","
			+"\"responseCode\":\"POS\","
			+"\"requestTransactionId\":\"1.0\""
			+"}\""; 

			String sampleTxt = "{"
			+"\"kycDetails\":{"
			+"\"uid\":\"776580373031\","
			+"\"dob\":\"12-03-1991\","
			+"\"gender\":\"M\","
			+"\"name\":\"Kishor Jotiram Toraskar\","
			+"\"phone\":\"\","
			+"\"co\":\"\","
			+"\"district\":\"Kolhapur\","
			+"\"house\":\"\","
			+"\"landMark\":\"\","
			+"\"location\":\"taluka- karveer\","
			+"\"postalCode\":\"416204\","
			+"\"postOffice\":\"\","
			+"\"state\":\"Maharashtra\","
			+"\"street\":\"\","
			+"\"subdist\":\"\","
			+"\"vtc\":\"Sangrul\","
			+"\"vtcCode\":\"27-2734-A25D1F7B4D59BFBA90B0094C4B4BD0FB\","
			//+"\"photo\":\""+imageText+"\","
			+"\"emailAddress\":\"\""
			+"}}";
			//responseTxt = "S$!^SUCCESS$!^123456$!^09/12/2016 12:55 $!^1$!^2$!^9876$!^nothing$!^remarks22";
			/* responseTxt = "{"
			+"\"uid\":\"776580373031\","
			+"\"dob\":\"12-03-1991\","
			+"\"gender\":\"M\"}";
			System.out.println("After setting response...."); */

			//responseTxt=sampleTxt;
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return responseTxt;	
	}

	public static Timestamp getTimeStamp(String dateStr)
	{
		//String startDate="01/02/2013 11:30:25.0";
		Timestamp timestamp=null;
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			java.util.Date parsedDate = dateFormat.parse(dateStr);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
			System.out.println("InvokeEMKYCapplication.java::::responseDate time value......."+timestamp);
			//timestamp.
		}catch(Exception e){//this generic but you can control another types of exception
		 e.printStackTrace(); 
		}

		return timestamp;
	}

	/*
	* Added by Sethu on 14/04/2017 for KDAH-CRF-0370 
	* This method is used for Pan Card Validation
	*/

	private String panCardValidation(Map<String, String> reqParams) throws Exception 
	{
		//"<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<USER>anilp$!^<WSNO>DFLT_WSNO$!^<PANCARDNO>ARBPS3602E";

		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String p_response="", errorCode = "", errorMsg = "";

		String paramString=reqParams.get("paramString");
		System.out.println("InvokeEGLapplication.java:::panCardValidation...paramString...."+paramString);
		try
		{   
				
			dbConn = ConnectionManager.getConnection();

			ostmt = dbConn.prepareCall("{ CALL XHPANCARDVALIDATION.VALIDATION_REQUEST(?,?,?,?) }" );
			ostmt.setString(1,paramString);
			ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(2);
			errorCode = ostmt.getString(3);
			errorMsg = ostmt.getString(4);
			System.out.println(" ... 9 ..."+errorMsg);
			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			}
					
			System.out.println("(InvokeEGLapplication:panCardValidation) responseTxt "+responseTxt);
		}
		catch(Exception exp)
		{
			System.out.println("(InvokeEGLapplication:panCardValidation) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		System.out.println("InvokeEGLapplication.java panCardValidation:::responseTxt...."+responseTxt);
		return responseTxt;	
	}

	/*

	private String panCardValidation(Map<String, String> reqParams) throws Exception 
	{
		String responseTxt="";
		String p_response="", errorCode = "", errorMsg = "";

		String paramString=reqParams.get("paramString");
		System.out.println("InvokeEMKYCapplication.java:::PayTMTransactions...paramString...."+paramString);
		try
		{   

			PancardValidation pancard = new PancardValidation();
				
			responseTxt = pancard.TransRequestMethod("PANCARDPROF1","PANCARD", paramString);
			System.out.println("(InvokeEMKYCapplication:panCardValidation) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			System.out.println("(InvokeEMKYCapplication:panCardValidation) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}		
		System.out.println("InvokeEMKYCapplication panCardValidation:::responseTxt...."+responseTxt);
		return responseTxt;	
	}

	*/

}