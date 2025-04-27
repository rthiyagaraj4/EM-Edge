package eXH.innoviti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

import eXH.util.EMDataSource;
import eXH.util.XHJSONUtil;
import eXH.util.XHUtil;

public class InnovitiTransaction {
	
	public static String l_segment_id = "";
	public static String l_standard_code = "";	

	public static final String l_field_separator= ",";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    
    public static int cloud_service_flag=0;
    Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	
	public String l_authToken = "";
	public String l_uuid = "";
	public String l_app_msg = "";
	public String l_invoice_no = "";
	
	
	public String TransRequestMethod(String applicationId, String actionKey) throws ParseException{

		String l_request = "",  l_request_msg = "", l_response_msg = "", l_response_str = "",l_trans_value="";
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		
		String strStdQuery = "",strSegQuery = "";

		String query = "", l_debug_yn = "";
		
		//Added by Sethu for AMRI-CRF-0431 on 28/02/2020		
		String l_protocol_link_id = "";
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}

			l_debug_YN = l_debug_yn;

		}
		catch(Exception e)
		{
		}		
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}

			
		l_app_msg = " ::: Inside Innoviti TransRequestMethod Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);	
		
		//Added by Sethu for AMRI-CRF-0431 on 28/02/2020		
		l_app_msg = " ::: Fetching Prootocol Link ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_protocol_link_id = FieldValueFetchMethod(actionKey,"PROTOCOL_LINK_ID=",null,l_field_separator, "TransRequestMethod");
		l_protocol_link_id = l_protocol_link_id.trim();
		l_app_msg = " ::: l_protocol_link_id : "+l_protocol_link_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_protocol_link_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_protocol_link_id;
		}
		
		l_app_msg = " ::: Fetching Standard Code... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		strStdQuery = "Select standard_code||'$!^' from XH_PROTOCOL_LINK where PROTOCOL_LINK_ID = '"+l_protocol_link_id+"'";
		String[] stdQueryResult = XHUtil.singleParamExeQry(strStdQuery).split(Pattern.quote("$!^"), -1);		
		l_standard_code = stdQueryResult[0];
		l_standard_code = l_standard_code.trim();
		l_app_msg = " Standard Code ::: "+l_standard_code;
		if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = "Fetching Segment ID... ";
		if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		strSegQuery = "Select segment_type||'$!^' from XH_SEGMENT where STANDARD_CODE = '"+l_standard_code+"' and CONTROL_YN = 'Y'";			
		String[] segQueryResult = XHUtil.singleParamExeQry(strSegQuery).split(Pattern.quote("$!^"), -1);
		l_segment_id = segQueryResult[0];
		l_segment_id = l_segment_id.trim();
			
		l_app_msg = " Segment ID... "+l_segment_id;
		if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		
		l_request = FieldValueFetchMethod(actionKey, "P_REQUEST=", null, l_field_separator, "TransRequestMethod");
		l_request=l_request.trim();
		
		if (!(l_request.length()>0)){
			l_app_msg = " ::: Generating Transaction id...";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			l_trans_value = GenerateTransIDMethod();
			l_app_msg = " ::: l_trans_value : "+l_trans_value;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_trans_value.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_trans_value;
			}
			

			l_app_msg = " ::: Calling Request Mesage Build Method... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{   
	            l_request_msg  = MessageBuildMethod(l_trans_value, actionKey);
				l_app_msg = " ::: l_request_msg : "+l_request_msg;
	            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			}  

			if (l_request_msg.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_request_msg;
			}
			
			l_app_msg = " ::: Calling InteractiveTableInsertion Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_errcd.equals("S"))
			{
				l_response_msg=InteractiveTableInsertionMethod(applicationId,actionKey,l_request_msg,l_trans_value);
				l_app_msg = " ::: l_response_msg : "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_response_msg.indexOf("Error in ")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_msg;
				}
			}
			
			l_app_msg = " ::: Calling HTTPGateway Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			if (l_errcd.equals("S"))
			{
				l_response_msg = TransCommunicationMethod("INNOCTM", actionKey, l_request_msg,"");
				l_app_msg = " ::: l_response_msg : "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_response_msg.indexOf("Error in ")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_msg;
				}

			}
			
			if (l_errcd.equals("S"))
			{
				l_response_str  = MessageLoadMethod(actionKey, l_response_msg, l_trans_value);
				l_app_msg = " ::: l_response_str : "+l_response_str;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_response_str.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_str;
				}
			}
			l_app_msg = " ::: Calling InteractiveTableUpdation Method...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_errcd.equals("S"))
			{
				l_response_msg = InteractiveTableUpdationMethod(l_response_msg,l_response_str,l_trans_value);
				l_app_msg = " ::: l_response_msg : "+l_response_msg;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_response_msg.indexOf("Error in ")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_response_msg;
				}

			}
		
		}
		else {
				l_app_msg = " ::: Generating Invoice No...";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);
	
				l_invoice_no = GenerateInvoiceNoMethod();
				l_invoice_no=l_invoice_no.trim();
				l_app_msg = " ::: l_invoice_no : "+l_invoice_no;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_trans_value.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_invoice_no;
				}
				
				l_request = FieldValueFetchMethod(actionKey, "P_REQUEST=", null, l_field_separator, "TransRequestMethod");
				l_request=l_request.trim();
				
				l_app_msg = " ::: l_request : "+l_request;
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				if (l_request.indexOf("Error")>=0)
				{
					return l_request;
				}
				if (l_request.equals("WITHDRAW_MONEY"))
				{ 
					
					l_authToken=GetAuthToken(applicationId,actionKey);
					
					l_authToken=l_authToken.trim();
					
					l_app_msg  = "Forming actionKey with AuthToken..."+actionKey;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					actionKey = actionKey + ", P_AuthToken="+l_authToken ;
					l_app_msg  = " ::: actionKey : "+actionKey;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Generating Transaction id...";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);

					l_trans_value = GenerateTransIDMethod();
					l_app_msg = " ::: l_trans_value : "+l_trans_value;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_trans_value.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_trans_value;
					}
					
					l_app_msg = " ::: Calling CloudMessageBuild Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		            l_request_msg  = CloudMessageBuildMethod(l_invoice_no, actionKey,"WITHDRAW_MONEY");
					l_app_msg = " ::: Send Invoice Request Message : "+l_request_msg;
		            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		            
		            l_app_msg = " ::: Calling InteractiveTableInsertion Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						l_response_msg=InteractiveTableInsertionMethod(applicationId,actionKey,l_request_msg,l_trans_value);
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}
					}
					
					l_app_msg = " ::: Calling HTTPGateway Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					if (l_errcd.equals("S"))
					{
						l_response_msg = TransCommunicationMethod("INNOCTM", actionKey, l_request_msg,"WITHDRAW_MONEY");
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}

					}
					
					l_app_msg = " ::: Calling CloudMessageLoad Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						//l_response_msg="{\"uuid\":\"39065e5e-bd0b-11ea-b3c1-2957a6a5ff4b\",\"statusMessage\":\"Bill Invoice saved successfully\",\"statusCode\":\"00\"}";
						l_response_str  = CloudMessageLoadMethod(actionKey, l_response_msg,"WITHDRAW_MONEY");
						l_app_msg = " ::: l_response_str : "+l_response_str;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_str.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_str;
						}
					}
					l_app_msg = " ::: Calling InteractiveTableUpdation Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						l_response_msg = InteractiveTableUpdationMethod(l_response_msg,l_response_str,l_trans_value);
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}

					}
					
					l_app_msg  = "Forming actionKey with Uuid..."+actionKey;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					actionKey= actionKey + ", P_Uuid=" +l_uuid ;
					l_app_msg  = " ::: actionKey : "+actionKey;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					
					l_app_msg = " ::: Generating Transaction id...";
					if (l_debug_YN.equals("Y"))	
						System.out.println(l_app_msg);

					l_trans_value = GenerateTransIDMethod();
					l_app_msg = " ::: l_trans_value : "+l_trans_value;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_trans_value.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_trans_value;
					}
		            
					l_app_msg = " ::: Calling CloudMessageBuild Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		            l_request_msg  = CloudMessageBuildMethod(l_invoice_no, actionKey,"CHECK_STATUS");
					l_app_msg = " ::: Check Status Request Message : "+l_request_msg;
		            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		            
		            l_app_msg = " ::: Calling InteractiveTableInsertion Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						l_response_msg=InteractiveTableInsertionMethod(applicationId,actionKey,l_request_msg,l_trans_value);
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}
					}
					
					l_app_msg = " ::: Calling HTTPGateway Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

					if (l_errcd.equals("S"))
					{
						l_response_msg = TransCommunicationMethod("INNOCTM", actionKey, l_request_msg,"CHECK_STATUS");
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}

					}
					l_app_msg = " ::: Calling CloudMessageLoad Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						
						/*l_response_msg="{\"TransactionDetails\":{"
							      +"\"approvalCode\":\"804957\","
							      +"\"billInvoiceNo\":\"0307201\","
							      +"\"paymentStatus\":\"Paid\","
							      +"\"invoiceDate\":\"2020-07-03 14:16:43\","
							      +"\"invoiceAmount\":10.00,"
							      +"\"txnType\":\"00\","
							      +"\"uuid\":\"39065e5e-bd0b-11ea-b3c1-2957a6a5ff4b\","
							      +"\"orgBillUUID\":null,"
							      +"\"rrn\":\"10007920    \","
							      +"\"paidDate\":\"2020-07-03 14:34:55\","
							      +"\"paidAmount\":300.00,"
							      +"\"bankInvoiceNo\":\"000015\","
							      +"\"actualTxnMode\":\"00\","
							      +"\"invoiceDetails\":{"
							         +"\"displayTag1\":\"Jims\","
							         +"\"displayTag2\":\"Table-1\","
							         +"\"posID\":\"12369\","
							         +"\"cashierID\":\"7921\","
							         +"\"itemSKU\":null,"
							         +"\"itemSerialNo\":\"121233244\","
							         +"\"points\":\"25.2\""
							      +"},"
							      +"\"txnMode\":\"00\","
							      +"\"additionalData\":{"
							         +"\"primid\":\"3rcv3rt567892370000010159306650251991033\","
							         +"\"mobileNo\":\"9036804021\","
							         +"\"txnReferenceNo\":\"\","
							         +"\"maskedCardNo\":\"437748xxxxxx7307\","
							         +"\"merchantVpa\":\"\","
							         +"\"payerVpa\":\"\","
							         +"\"acqBank\":\"HDFC BANK\","
							         +"\"batchNo\":\"000001\","
							         +"\"mid\":\"ABCEDSHGIJKLopt\","
							         +"\"tid\":\"NICICIBT\","
							         +"\"cardType\":\"CHIP\","
							         +"\"cardHolderName\":\"MAYANK PANCHAL\","
							         +"\"issuerBankName\":\"\","
							         +"\"discountAmount\":300.00,"
							         +"\"scheme\":\"VISA_PIN@POS\","
							         +"\"chipApplicationName\":\"\","
							         +"\"itemSKU\":\"\","
							         +"\"itemSerialNo\":\"\","
							         +"\"points\":null,"
							         +"\"dccObject\":{"
							            +"\"dccExchangeRate\":null,"
							            +"\"dCCMarginFee\":null,"
							            +"\"dccTxnCurrency\":null,"
							            +"\"dccCurrencyName\":\"\","
							            +"\"dccConvertedAmount\":\"\""
							         +"},"
							         +"\"emiResponseObject\":\"Tenure:#6 Months\\nCard Issuer:#KOTAK BANK\\nTxn Amt:#Rs 29905.70\\nBrand:#Voltas\\nCategory:#Stabilizer\\nModel:#STABVLTS9951\\nMerchant Cashback:#0.00%\\nMerchant Cashback Amt:#Rs 0.00\\nLoan Amt:#Rs 29905.70\nRate of Interest(p.a):#12.00 %\\nInterest Amt:#Rs 1055.38\\nEMI Amt:#Rs 5160.18\\nProc Fee:#Rs 0.00\\nAdv EMI:# 0\\nTotal Amt (with Interest):#Rs 30961.08\","
							         +"\"customerConsent\":null,"
							         +"\"emiCardType\":\"DEBIT\","
							         +"\"emiTransactionType\":\"dc emi\","
							         +"\"emiBankRefNo\":\"dfghjkxcvbn\","
							         +"\"downPaymentAm\":12.20,"
							         +"\"downPaymentRRN\":\"b678888888886\","
							         +"\"downPaymentApprovalCode\":\"jhshdfdrf23345\""
							      +"}"
							   +"},"
							   +"\"statusMessage\":\"Paid\","
							   +"\"statusCode\":\"00\""
							+"}";
						*/
						
						
						l_response_str  = CloudMessageLoadMethod(actionKey, l_response_msg,"CHECK_STATUS");
						l_app_msg = " ::: l_response_str : "+l_response_str;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_str.indexOf("Error")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_str;
						}
					}
					
					l_app_msg = " ::: Calling InteractiveTableUpdation Method...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
					if (l_errcd.equals("S"))
					{
						l_response_msg = InteractiveTableUpdationMethod(l_response_msg,l_response_str,l_trans_value);
						l_app_msg = " ::: l_response_msg : "+l_response_msg;
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						if (l_response_msg.indexOf("Error in ")>=0)
						{
							l_errcd = "E";
							l_errmsg = l_response_msg;
						}

					}
					
			}
			
			
			if (l_request.equals("CHECK_STATUS"))
	        {   
				l_app_msg  = "Forming actionKey with Uuid..."+actionKey;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				actionKey= actionKey + ", P_Uuid=" +l_uuid ;
				l_app_msg  = " ::: actionKey : "+actionKey;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = " ::: Generating Transaction id...";
				if (l_debug_YN.equals("Y"))	
					System.out.println(l_app_msg);

				l_trans_value = GenerateTransIDMethod();
				l_app_msg = " ::: l_trans_value : "+l_trans_value;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_trans_value.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_trans_value;
				}
				
				l_app_msg = " ::: Calling CloudMessageBuild Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
	            l_request_msg  = CloudMessageBuildMethod(l_invoice_no, actionKey,"CHECK_STATUS");
				l_app_msg = " ::: Check Status Request Message : "+l_request_msg;
	            if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
	            
	            l_app_msg = " ::: Calling InteractiveTableInsertion Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_errcd.equals("S"))
				{
					l_response_msg=InteractiveTableInsertionMethod(applicationId,actionKey,l_request_msg,l_trans_value);
					l_app_msg = " ::: l_response_msg : "+l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_response_msg.indexOf("Error in ")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_response_msg;
					}
				}
				
				l_app_msg = " ::: Calling HTTPGateway Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				if (l_errcd.equals("S"))
				{
					l_response_msg = TransCommunicationMethod("INNOCTM", actionKey, l_request_msg,"CHECK_STATUS");
					l_app_msg = " ::: l_response_msg : "+l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_response_msg.indexOf("Error in ")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_response_msg;
					}

				}
				l_app_msg = " ::: Calling CloudMessageLoad Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_errcd.equals("S"))
				{
					
					/*l_response_msg="{\"TransactionDetails\":{"
						      +"\"approvalCode\":\"804957\","
						      +"\"billInvoiceNo\":\"0307201\","
						      +"\"paymentStatus\":\"Paid\","
						      +"\"invoiceDate\":\"2020-07-03 14:16:43\","
						      +"\"invoiceAmount\":10.00,"
						      +"\"txnType\":\"00\","
						      +"\"uuid\":\"39065e5e-bd0b-11ea-b3c1-2957a6a5ff4b\","
						      +"\"orgBillUUID\":null,"
						      +"\"rrn\":\"10007920    \","
						      +"\"paidDate\":\"2020-07-03 14:34:55\","
						      +"\"paidAmount\":300.00,"
						      +"\"bankInvoiceNo\":\"000015\","
						      +"\"actualTxnMode\":\"00\","
						      +"\"invoiceDetails\":{"
						         +"\"displayTag1\":\"Jims\","
						         +"\"displayTag2\":\"Table-1\","
						         +"\"posID\":\"12369\","
						         +"\"cashierID\":\"7921\","
						         +"\"itemSKU\":null,"
						         +"\"itemSerialNo\":\"121233244\","
						         +"\"points\":\"25.2\""
						      +"},"
						      +"\"txnMode\":\"00\","
						      +"\"additionalData\":{"
						         +"\"primid\":\"3rcv3rt567892370000010159306650251991033\","
						         +"\"mobileNo\":\"9036804021\","
						         +"\"txnReferenceNo\":\"\","
						         +"\"maskedCardNo\":\"437748xxxxxx7307\","
						         +"\"merchantVpa\":\"\","
						         +"\"payerVpa\":\"\","
						         +"\"acqBank\":\"HDFC BANK\","
						         +"\"batchNo\":\"000001\","
						         +"\"mid\":\"ABCEDSHGIJKLopt\","
						         +"\"tid\":\"NICICIBT\","
						         +"\"cardType\":\"CHIP\","
						         +"\"cardHolderName\":\"MAYANK PANCHAL\","
						         +"\"issuerBankName\":\"\","
						         +"\"discountAmount\":300.00,"
						         +"\"scheme\":\"VISA_PIN@POS\","
						         +"\"chipApplicationName\":\"\","
						         +"\"itemSKU\":\"\","
						         +"\"itemSerialNo\":\"\","
						         +"\"points\":null,"
						         +"\"dccObject\":{"
						            +"\"dccExchangeRate\":null,"
						            +"\"dCCMarginFee\":null,"
						            +"\"dccTxnCurrency\":null,"
						            +"\"dccCurrencyName\":\"\","
						            +"\"dccConvertedAmount\":\"\""
						         +"},"
						         +"\"emiResponseObject\":\"Tenure:#6 Months\\nCard Issuer:#KOTAK BANK\\nTxn Amt:#Rs 29905.70\\nBrand:#Voltas\\nCategory:#Stabilizer\\nModel:#STABVLTS9951\\nMerchant Cashback:#0.00%\\nMerchant Cashback Amt:#Rs 0.00\\nLoan Amt:#Rs 29905.70\nRate of Interest(p.a):#12.00 %\\nInterest Amt:#Rs 1055.38\\nEMI Amt:#Rs 5160.18\\nProc Fee:#Rs 0.00\\nAdv EMI:# 0\\nTotal Amt (with Interest):#Rs 30961.08\","
						         +"\"customerConsent\":null,"
						         +"\"emiCardType\":\"DEBIT\","
						         +"\"emiTransactionType\":\"dc emi\","
						         +"\"emiBankRefNo\":\"dfghjkxcvbn\","
						         +"\"downPaymentAm\":12.20,"
						         +"\"downPaymentRRN\":\"b678888888886\","
						         +"\"downPaymentApprovalCode\":\"jhshdfdrf23345\""
						      +"}"
						   +"},"
						   +"\"statusMessage\":\"Paid\","
						   +"\"statusCode\":\"00\""
						+"}";*/
					
					
					
					l_response_str  = CloudMessageLoadMethod(actionKey, l_response_msg,"CHECK_STATUS");
					l_app_msg = " ::: l_response_str : "+l_response_str;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_response_str.indexOf("Error")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_response_str;
					}
				}
				
				l_app_msg = " ::: Calling InteractiveTableUpdation Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				if (l_errcd.equals("S"))
				{
					l_response_msg = InteractiveTableUpdationMethod(l_response_msg,l_response_str,l_trans_value);
					l_app_msg = " ::: l_response_msg : "+l_response_msg;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_response_msg.indexOf("Error in ")>=0)
					{
						l_errcd = "E";
						l_errmsg = l_response_msg;
					}

				}
	            
			} 
			
		}
		if (!(l_request.length()>0)){
			if (l_errcd.equals("S"))
			{
				return l_response_str;
			}
			else
			{
				l_errmsg = "E" + "$!^" + "Error" + "$!^" + l_errmsg + "$!^" + l_trans_value + "$!^" + "" + "$!^" + "";
				return l_errmsg;
			}
		}
		else{
			if (l_errcd.equals("S"))
			{
				return l_response_str;
			}
			else{
				
				l_errmsg = "\""+l_trans_value+"\",\"\", \"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\"," +
						   "\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\""+l_uuid+"\"";
				return l_errmsg;
			}
		}
		
	}
	
	public String InteractiveTableInsertionMethod(String applicationId,String actionKey,String requestMsg,String transValue){
		
		
		String  l_patient_id = "", l_encounter_id = "", l_facility_id = "", l_user_id = "", l_user_wsno = "";
		
		
		String l_request_date = "";

		
		l_app_msg = " ::: Fetching Patient ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_patient_id = FieldValueFetchMethod(actionKey,"P_patient_id=",null,l_field_separator, "TransRequestMethod");
		l_patient_id = l_patient_id.trim();
		l_app_msg = " ::: l_patient_id : "+l_patient_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_patient_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_patient_id;
		}

		l_app_msg = " ::: Fetching Encounter ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_encounter_id = FieldValueFetchMethod(actionKey,"P_episode_ID=",null,l_field_separator, "TransRequestMethod");
		l_encounter_id = l_encounter_id.trim();
		l_app_msg = " ::: l_encounter_id : "+l_encounter_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_encounter_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_encounter_id;
		}

		l_app_msg = " ::: Fetching Facility ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_facility_id = FieldValueFetchMethod(actionKey,"P_FACILITY_ID=",null,l_field_separator, "TransRequestMethod");
		l_facility_id = l_facility_id.trim();
		l_app_msg = " ::: l_facility_id : "+l_facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_facility_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_facility_id;
		}

		l_app_msg = " ::: Fetching User ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_id = FieldValueFetchMethod(actionKey,"P_USER_ID=",null,l_field_separator, "TransRequestMethod");
		l_user_id = l_user_id.trim();
		l_app_msg = " ::: l_user_id : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = " ::: Fetching User WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_user_wsno = FieldValueFetchMethod(actionKey,"P_WS_NO=",null,l_field_separator, "TransRequestMethod");
		l_user_wsno = l_user_wsno.trim();
		l_app_msg = " ::: WSNO : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}
		

		l_app_msg = " ::: Getting Formatted l_request_date value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_request_date = getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", new java.util.Date());

		l_app_msg = " ::: l_request_date : "+l_request_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Setting  reqParams value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{		

			Map<String,String> reqParams = new HashMap<String,String>();
			
			Map<String,Integer> reqIntParams = new HashMap<String,Integer>();
			
			reqParams.put("LOGIN_USER", l_user_id);
			reqParams.put("CLIENT_MACHINE", l_user_wsno); 
			reqParams.put("PGM_ID", "XBCC");
			reqParams.put("MODULE_ID", "XH");
			reqParams.put("SESSION_ID", "REGPAT");

			reqParams.put("MSG_ID", transValue);
			reqParams.put("REQUEST_DATE", l_request_date); 
			reqParams.put("REQUEST_TEXT", requestMsg); 
			reqParams.put("APPLICATION_ID", applicationId);
			reqParams.put("FACILITY_ID", l_facility_id);
			reqParams.put("MESSAGE_DATE", l_request_date); 
			reqParams.put("EVENT_TYPE", "CT01");
			reqParams.put("PATIENT_ID", l_patient_id);
			reqParams.put("EPISODE_TYPE", "");
			reqParams.put("ENCOUNTER_ID", l_encounter_id);
			reqParams.put("ACC_NO", actionKey);
			reqIntParams.put("EXT_ACC_NO",Integer.parseInt(l_invoice_no));
			reqParams.put("REQUEST_SYNTAX", actionKey);
			reqParams.put("ACK_MSG_ID", "");
			reqParams.put("PROTOCOL_LINK_ID", "INNOCTM");
			reqParams.put("ADDED_BY_ID", l_user_id); 
			reqParams.put("ADDED_BY_DATE", l_request_date); 
			reqParams.put("MODIFIED_BY_ID", l_user_id); 
			reqParams.put("MODIFIED_BY_DATE", l_request_date); 
			reqParams.put("ADDED_BY_FACILITY", l_facility_id);
			reqParams.put("MODIFIED_BY_FACILITY", l_facility_id);
			reqParams.put("RESPONSE_TEXT", ""); 
			reqParams.put("RESPONSE_SYNTAX", "");
			reqParams.put("PROFILE", ""); 
			reqParams.put("ERROR_TEXT", ""); 
			reqParams.put("ACK_TEXT", "");
			reqParams.put("ACK_SYNTAX", "");

			l_app_msg = " ::: Inserting Interface Audit data...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			XHUtil.updateInteractiveDetails(reqParams);
		
		}
		catch (Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in setting request params : "+l_app_msg+ " - "+ e.getMessage();;
			e.printStackTrace();
		}	
		return l_errcd;
		
		
	}
	
	public String InteractiveTableUpdationMethod(String responseMsg,String responseStr,String transValue){
		

		String updateStmt = "";
		dbConn = null;
		pstmt = null;
		int updateCount = 0;	
		try
		{
			dbConn =  EMDataSource.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, responseMsg);
			pstmt.setString(2, responseStr);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_errmsg);
			pstmt.setString(5, transValue);
			pstmt.setString(6, "XBCC");
			updateCount = pstmt.executeUpdate();

			l_app_msg = " ::: UpdateCount : "+updateCount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
			if (updateCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
				l_errcd = "E";
				l_errmsg = " Error in updating Interactive Integration Records ";				
			}

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		
		}
		return l_errcd;
		
	}

	public String MessageBuildMethod(String l_txn_id, String actionKey){
		String l_element_id = "";

		String l_txn_type = "", l_txn_mode = "", l_amount = "";
		String r_amount = "";

		String createRequestString = "";	
		
		l_app_msg = " ::: Inside MessageBuildMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	       

		l_app_msg = " ::: Fetching Amount... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_amount = FieldValueFetchMethod(actionKey,"P_Total_Bill_Amount=",null,l_field_separator, "MessageBuildMethod");
		//l_amount = l_amount.substring(0, l_amount.length() - 3).trim();
		l_app_msg = " ::: Amount : "+l_amount;
		
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_amount.indexOf("Error")>=0)
		{
			return l_amount;
		}
		
		r_amount = l_amount;
		if(l_amount.contains(".")){
			double d_amt = Double.parseDouble(l_amount);
			int i = (int) (d_amt * 100);
			
			r_amount = String.valueOf(i);
			l_app_msg = " ::: Request Amount with Decimal : "+r_amount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}	
		l_app_msg = " ::: Request Amount : "+r_amount;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		
		l_app_msg = " ::: Retrieving Transaction Type... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_element_id = "TXN_TYPE";

		l_txn_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_txn_type=l_txn_type.trim();
		l_app_msg = " ::: Transaction Type : "+l_txn_type;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_txn_type.indexOf("Error")>=0)
		{
			return l_txn_type;
		}
		
		l_app_msg = " ::: Retrieving Transaction Mode... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_element_id = "TXN_MODE";

		l_txn_mode = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_txn_mode=l_txn_mode.trim();
		l_app_msg = " ::: Transaction Type : "+l_txn_mode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_txn_mode.indexOf("Error")>=0)
		{
			return l_txn_mode;
		}
		
		createRequestString = l_txn_type+","+l_txn_mode+","+l_txn_id+","+r_amount;
		
		l_app_msg = " ::: Generated Request Object : "+createRequestString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return createRequestString;

	}

	public String MessageLoadMethod(String actionKey, String message, String sequence_No){

		String l_app_msg = "";
		String l_in_JSON = ""; 
		String l_wallet_trn_date = "";

        String l_status_return ="";

		String l_merchant_id = "", l_txn_date = "";
		String l_ResponseCode = "", l_ResponseMessage = "", l_ApprovalCode = "", l_Card_Num = "", l_Card_Type = "", l_CardHolder_Name = "", l_RRN_No = ""; 
		String l_Acquirer_Bank = "", l_Txn_Type = "", l_BankInvoice_Num = "", l_Batch_Number = "", l_Terminal_Id = "", l_Merchant_Id = "",l_amount="";
		String l_txn_resp_date = "",l_txn_time = "";

		l_app_msg = " ::: Inside MessageLoadMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: Testing message : "+message;
		if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{
		
		l_in_JSON = XHJSONUtil.createJsonObject(message);
		l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_in_JSON.indexOf("Error")==0)
		{
			return l_in_JSON;
		}
		
		l_ResponseCode = XHJSONUtil.getJsonRequestString(l_in_JSON, "ResponseCode");
		l_ResponseCode = l_ResponseCode.trim();
		l_app_msg = " ::: Response Code : "+l_ResponseCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		//if(l_ResponseCode.equals("00")){
			
			l_ResponseMessage = XHJSONUtil.getJsonRequestString(l_in_JSON, "ResponseMessage");
			l_ResponseMessage = l_ResponseMessage.trim();
			l_app_msg = " ::: Response Message : "+l_ResponseMessage;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_ApprovalCode = XHJSONUtil.getJsonRequestString(l_in_JSON, "ApprovalCode");
			l_ApprovalCode = l_ApprovalCode.trim();
			l_app_msg = " ::: Approval Code : "+l_ApprovalCode;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Card_Num = XHJSONUtil.getJsonRequestString(l_in_JSON, "Card_Num");
			l_Card_Num = l_Card_Num.trim();
			l_app_msg = " ::: Card Number : "+l_Card_Num;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Card_Type = XHJSONUtil.getJsonRequestString(l_in_JSON, "Card_Type");
			l_Card_Type = l_Card_Type.trim();
			l_app_msg = " ::: Card Type : "+l_Card_Type;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_CardHolder_Name = XHJSONUtil.getJsonRequestString(l_in_JSON, "CardHolder_Name");
			l_CardHolder_Name = l_CardHolder_Name.trim();
			l_app_msg = " ::: Card Holder Name : "+ l_CardHolder_Name;
			if(l_debug_YN.equals("Y")) System.err.println(l_app_msg);
			
			l_RRN_No = XHJSONUtil.getJsonRequestString(l_in_JSON, "RRN_No");
			l_RRN_No = l_RRN_No.trim();
			l_app_msg = " ::: RRN No : "+ l_RRN_No;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Acquirer_Bank = XHJSONUtil.getJsonRequestString(l_in_JSON, "Acquirer_Bank");
			l_Acquirer_Bank = l_Acquirer_Bank.trim();
			l_app_msg = " ::: Acquirer Bank : "+ l_Acquirer_Bank;
			if(l_debug_YN.equals("Y")) System.err.println(l_app_msg);
			
			l_merchant_id = XHJSONUtil.getJsonRequestString(message, "Merchant_Id");
			l_merchant_id = l_merchant_id.trim();
			l_app_msg = " ::: Merchant Id : "+l_merchant_id;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Txn_Type = XHJSONUtil.getJsonRequestString(message, "Txn_Type");
			l_Txn_Type = l_Txn_Type.trim();
			l_app_msg = " ::: Txn Type : "+ l_Txn_Type;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_BankInvoice_Num = XHJSONUtil.getJsonRequestString(message, "BankInvoice_Num");
			l_BankInvoice_Num = l_BankInvoice_Num.trim();
			l_app_msg = " ::: Bank Invoice Number :"+l_BankInvoice_Num;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Batch_Number = XHJSONUtil.getJsonRequestString(message, "Batch_Number");
			l_Batch_Number = l_Batch_Number.trim();
			l_app_msg = " ::: Batch Number : "+l_Batch_Number;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_amount = XHJSONUtil.getJsonRequestString(message, "Amount");
			l_amount = l_amount.trim();
			l_app_msg = " ::: Amount : "+l_amount;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_Terminal_Id = XHJSONUtil.getJsonRequestString(message, "Terminal_Id");
			l_Terminal_Id = l_Terminal_Id.trim();
			l_app_msg = " ::: Terminal ID : "+l_Terminal_Id;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_txn_date = XHJSONUtil.getJsonRequestString(message, "Txn_Date");
			l_txn_date = l_txn_date.trim();
			l_app_msg = " ::: Txn Date : "+l_txn_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			
			
			if(l_txn_date.length() > 10){
				
				l_txn_date = l_txn_date.substring(0, 19);
			
				//Date date = new Date(l_txn_date);				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				df.setTimeZone(TimeZone.getTimeZone("IST"));			
				Date date = df.parse(l_txn_date);
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
				l_wallet_trn_date = dateFormat.format(date);
				
				
				//l_txn_resp_date = "",l_txn_time = "";
				l_txn_resp_date = l_wallet_trn_date.substring(0, 10);
				l_txn_time = l_wallet_trn_date.substring(11,19);
				
				l_txn_resp_date = l_txn_resp_date.replace("/", "").trim();
				l_txn_time = l_txn_time.replace(":", "").trim();
				
			}
			
			
			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			/*l_status_return = l_status + "$!^" +l_ResponseCode + "$!^" + l_ResponseMessage + "$!^" + l_ApprovalCode + "$!^"+ l_BankInvoice_Num + "$!^" + l_Terminal_Id + "$!^" + l_CardHolder_Name +"$!^"+
					l_Card_Num + "$!^" + l_Card_Type + "$!^" + l_Merchant_Id + "$!^" + l_RRN_No + "$!^" + l_wallet_trn_date + "$!^" + l_Txn_Type + "$!^" + l_Batch_Number + "$!^" + l_Acquirer_Bank;*/
			
			l_status_return = "\""+sequence_No+"\","+"\""+l_ApprovalCode+"\","+"\""+l_ResponseMessage+"\","+"\""+l_Card_Num+"\","+"\"XXXX\","+"\""+l_CardHolder_Name+"\","+"\""+l_Card_Type+"\","+"\""+l_BankInvoice_Num+"\","+"\""+l_Batch_Number+"\","+
			"\""+l_Terminal_Id+"\","+"\"\","+"\""+l_ResponseMessage+"\","+"\""+l_Acquirer_Bank+"\","+"\""+l_Merchant_Id+"\","+"\""+l_RRN_No+"\","+"\"0\","+"\"1\","+
			"\""+l_Merchant_Id+"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_amount+"\","+"\"\","+"\"\","+"\""+l_txn_resp_date+"\","+"\""+l_txn_time+"\"";
					
			
		//}
		
        l_app_msg = " ::: l_status_return from JSON : "+ l_status_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
	}catch (Exception e) {
		
	}

		return l_status_return;
	}
	
	public String CloudMessageBuildMethod(String invoiceNo, String actionKey,String request){
		String l_element_id = "";

		String l_txn_type = "", l_txn_mode = "", l_amount = "";
		String r_amount = "";

		String createJsonString = "";	
		
		String l_request_date="",l_merchant_id  = "",l_pass_code="", l_store_code = "", l_innostore = "", l_utid = "",l_billInvoiceNo="";
		

		l_app_msg = "Inside MessageBuildMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	       

		l_app_msg = "Retrieving Merchant Id...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

        l_element_id = "MERCHANT_ID";

        l_merchant_id = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
        l_merchant_id=l_merchant_id.trim();
		l_app_msg = " ::: l_merchant_id : "+l_merchant_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_merchant_id.indexOf("Error")>=0)
		{
			return l_merchant_id;
		}

		l_app_msg = "Retrieving Pass Code...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_element_id = "PASS_CODE";

		l_pass_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_pass_code=l_pass_code.trim();
		l_app_msg = " ::: l_pass_code : "+l_pass_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pass_code.indexOf("Error")>=0)
		{
			return l_pass_code;
		}

		l_app_msg = "Retrieving Store Code...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_element_id = "STORE_CODE";
		
		l_store_code = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_store_code=l_store_code.trim();
		l_app_msg = " ::: l_store_code : "+l_store_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_store_code.indexOf("Error")>=0)
		{
			return l_store_code;
		}
		
		l_app_msg = "Retrieving INNOSTORE...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_element_id = "INNOSTORE";
		
		l_innostore = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_innostore=l_innostore.trim();
		l_app_msg = " ::: l_innostore : "+l_innostore;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pass_code.indexOf("Error")>=0)
		{
			return l_innostore;
		}
		
		l_app_msg = "Retrieving UTID...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_element_id = "UTID";
		
		l_utid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_utid=l_utid.trim();
		l_app_msg = " ::: l_utid : "+l_utid;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_pass_code.indexOf("Error")>=0)
		{
			return l_utid;
		}
		
		if (request.equals("GET_AUTHTOKEN")){
			
			l_app_msg = "Inside SEND INVOICE GET AUTHTOKEN...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
			
			l_app_msg = " ::: Generating JSON GET_AUTHTOKEN Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestString("merchant_id", l_merchant_id);
			createJsonString = XHJSONUtil.createJsonRequestString("pass_code", l_pass_code);

		}


		if (request.equals("WITHDRAW_MONEY"))
        {  
			
			l_app_msg = "Inside SEND INVOICE...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = "Generating Transaction id...";
			if (l_debug_YN.equals("Y"))	
				System.out.println(l_app_msg);

			l_app_msg = "Getting Formatted l_request_date value...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_request_date = getFormattedStringDate("yyyy-mm-dd HH:mm:ss", new java.util.Date());

			l_app_msg = "::: Request Date : "+l_request_date;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
			l_app_msg = " ::: Fetching Amount... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_amount = FieldValueFetchMethod(actionKey,"P_Total_Bill_Amount=",null,l_field_separator, "MessageBuildMethod");
			//l_amount = l_amount.substring(0, l_amount.length() - 3).trim();
			l_app_msg = " ::: Amount : "+l_amount;
			
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_amount.indexOf("Error")>=0)
			{
				return l_amount;
			}
			
			r_amount = l_amount;
			if(l_amount.contains(".")){
				double d_amt = Double.parseDouble(l_amount);
				int i = (int) (d_amt * 100);
				
				r_amount = String.valueOf(i);
				l_app_msg = " ::: Request Amount with Decimal : "+r_amount;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}	
			l_app_msg = " ::: Request Amount : "+r_amount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_app_msg = " ::: Retrieving Transaction Type... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "TXN_TYPE";

			l_txn_type = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_txn_type=l_txn_type.trim();
			l_app_msg = " ::: Transaction Type : "+l_txn_type;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_txn_type.indexOf("Error")>=0)
			{
				return l_txn_type;
			}
			
			l_app_msg = " ::: Retrieving Transaction Mode... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "TXN_MODE";

			l_txn_mode = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_txn_mode=l_txn_mode.trim();
			l_app_msg = " ::: Transaction Type : "+l_txn_mode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_txn_mode.indexOf("Error")>=0)
			{
				return l_txn_mode;
			}
			
			l_app_msg = " ::: Retrieving UTID... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_element_id = "UTID";

			l_utid = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
			l_utid=l_utid.trim();
			l_app_msg = " ::: l_utid : "+l_utid;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_utid.indexOf("Error")>=0)
			{
				return l_utid;
			}
			l_app_msg = " ::: Fetching Bill Invoice No... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_billInvoiceNo= invoiceNo;
			
			l_billInvoiceNo=l_billInvoiceNo.trim();
			
			l_app_msg = " ::: l_billInvoiceNo : "+l_billInvoiceNo;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (l_billInvoiceNo.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_billInvoiceNo;
			}
			
			l_app_msg = " ::: Generating JSON WITHDRAW_MONEY Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestString("store_code", l_store_code); 
			createJsonString = XHJSONUtil.createJsonRequestString("innostore", l_innostore);
			createJsonString = XHJSONUtil.createJsonRequestString("billInvoiceNo", l_billInvoiceNo);
			createJsonString = XHJSONUtil.createJsonRequestString("invoiceDate", l_request_date);
			createJsonString = XHJSONUtil.createJsonRequestString("invoiceAmount", r_amount);
			createJsonString = XHJSONUtil.createJsonRequestString("txnType", l_txn_type);
			createJsonString = XHJSONUtil.createJsonRequestString("txnMode", l_txn_mode);
			createJsonString = XHJSONUtil.createJsonRequestString("utid", l_utid);
			
		}

		if (request.equals("CHECK_STATUS"))
        {
			l_app_msg = " ::: Generating JSON CHECK_STATUS Request Object... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			XHJSONUtil.ClearJsonObjString("clear");
			
			createJsonString = XHJSONUtil.createJsonRequestString("uuid", l_uuid);		}

		
		l_app_msg = " ::: Generated JSON Request Object : "+createJsonString;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return createJsonString;


	}

	
	public String CloudMessageLoadMethod(String actionKey, String message,String request) throws ParseException{
		
		String l_in_JSON = ""; 
		String l_status= "", l_status_code= "", l_status_msg= "";
		String l_response_str = "",l_response_str_add="";

		String l_billInvoiceNo="",l_merchant_id  = "",l_acqBank="",l_paymentStatus="",l_maskedCardNo="",l_cardHolderName="",l_cardType=""; 
		String l_approval_Code = "",l_mid="",l_rrn="",l_paidAmount="",l_paidTimeStamp="",l_paidDate="",l_paidTime="",l_batchNo="",l_tid="";
		
		String l_bankInvoiceNo="";

        String l_status_return ="";


		l_app_msg = "Inside CloudMessageLoadMethod...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Fetching Request... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		

		l_in_JSON = XHJSONUtil.createJsonObject(message);
		l_app_msg = " ::: l_in_JSON : "+l_in_JSON;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_in_JSON.indexOf("Error")==0)
		{
			return l_in_JSON;
		}

		if (request.equals("GET_AUTHTOKEN"))
		{

			l_status_code = XHJSONUtil.getJsonRequestString(message, "statusCode");
			l_status_code=l_status_code.trim();
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_status_code.equals("00"))
			{
				l_status = "S";
			}
			
			if (l_status_code.equals("01"))
			{
				l_status = "E";
			}
			
			l_app_msg = " ::: message : "+message;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_status_msg = XHJSONUtil.getJsonRequestString(message, "statusMessage");
			l_status_msg=l_status_msg.trim();
			l_app_msg = " ::: l_status_msg : "+l_status_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			if (l_status.equals("S"))
			{
				l_merchant_id = XHJSONUtil.getJsonRequestString(message, "merchantid");
				l_merchant_id = l_merchant_id.trim();
				l_app_msg = " ::: merchant id : "+ l_merchant_id;
				if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_authToken = XHJSONUtil.getJsonRequestString(message, "authToken");
				l_authToken = l_authToken.trim();
				l_app_msg = " ::: authToken : "+ l_authToken;
				if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}

						
			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_status_return ="\""+l_status+"\","+"\""+l_status_code+"\","+"\""+l_status_msg+"\","+"\""+l_merchant_id+"\","+"\""+l_authToken+"\"";

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		
		if (request.equals("WITHDRAW_MONEY"))
		{

			l_status_code = XHJSONUtil.getJsonRequestString(message, "statusCode");
			l_status_code = l_status_code.trim();
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_status_code.equals("00"))
			{
				l_status = "S";
			}
			
			if (l_status_code.equals("01"))
			{
				l_status = "E";
			}
			
			l_app_msg = " ::: message : "+message;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_status_msg = XHJSONUtil.getJsonRequestString(message, "statusMessage");
			l_status_msg = l_status_msg.trim();
			l_app_msg = " ::: l_status_msg : "+l_status_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			if (l_status.equals("S"))
			{
				l_uuid = XHJSONUtil.getJsonRequestString(message, "uuid");
				l_uuid = l_uuid.trim();
				l_app_msg = " ::: l_uuid : "+l_uuid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}

			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_status_return =" \""+l_status+"\","+"\""+l_status_code+"\","+"\""+l_status_msg+"\","+"\""+l_uuid+"\"";

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}


		if (request.equals("CHECK_STATUS"))
		{
			l_status_code = XHJSONUtil.getJsonRequestString(message, "statusCode");
			l_status_code = l_status_code.trim();
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_status_code.equals("00"))
			{
				l_status = "S";
			}
			
			if (l_status_code.equals("01"))
			{
				l_status = "E";
			}
			
			l_app_msg = " ::: l_status : "+l_status+ " ::: l_status_code : "+l_status_code+ " ::: l_status_msg : " +l_status_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

			if (l_status.equals("S"))
			{
				l_response_str = XHJSONUtil.getJsonChild(l_in_JSON, "TransactionDetails");
				
				l_approval_Code = XHJSONUtil.getJsonRequestString(l_response_str, "approvalCode");
				l_approval_Code = l_approval_Code.trim();
				l_app_msg = " ::: l_approval_Code : "+l_approval_Code;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_billInvoiceNo = XHJSONUtil.getJsonRequestString(l_response_str, "billInvoiceNo");
				l_billInvoiceNo = l_billInvoiceNo.trim();
				l_app_msg = " ::: l_billInvoiceNo : "+l_billInvoiceNo;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_paidAmount=XHJSONUtil.getJsonRequestString(l_response_str, "paidAmount");
				l_paidAmount = l_paidAmount.trim();
				l_app_msg = " ::: l_paidAmount : "+l_paidAmount;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_paymentStatus = XHJSONUtil.getJsonRequestString(l_response_str, "paymentStatus");
				l_paymentStatus = l_paymentStatus.trim();
				l_app_msg = " ::: l_paymentStatus : "+l_paymentStatus;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_uuid = XHJSONUtil.getJsonRequestString(l_response_str, "uuid");
				l_uuid = l_uuid.trim();
				l_app_msg = " ::: l_uuid : "+l_uuid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_rrn = XHJSONUtil.getJsonRequestString(l_response_str, "rrn");
				l_rrn = l_rrn.trim();
				l_app_msg = " ::: l_rrn : "+l_rrn;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_bankInvoiceNo=XHJSONUtil.getJsonRequestString(l_response_str, "bankInvoiceNo");
				l_bankInvoiceNo = l_bankInvoiceNo.trim();
				l_app_msg = " ::: l_bankInvoiceNo : "+l_bankInvoiceNo;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_uuid=XHJSONUtil.getJsonRequestString(l_response_str, "uuid");
				l_uuid = l_uuid.trim();
				l_app_msg = " ::: l_uuid : "+l_uuid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				l_paidTimeStamp=XHJSONUtil.getJsonRequestString(l_response_str, "paidDate");
				l_app_msg = " ::: l_paidTimeStamp : "+l_paidTimeStamp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				
				if(l_paidTimeStamp.length() > 10){
					
					l_paidTimeStamp = l_paidTimeStamp.substring(0, 19);
				
					//Date date = new Date(l_txn_date);				
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					df.setTimeZone(TimeZone.getTimeZone("IST"));			
					Date date = df.parse(l_paidTimeStamp);
					
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
					String l_txn_Date = dateFormat.format(date);
					
					
					//l_txn_resp_date = "",l_txn_time = "";
					l_paidDate = l_txn_Date.substring(0, 10);
					l_paidTime = l_txn_Date.substring(11,19);
					
					l_paidDate = l_paidDate.replace("/", "").trim();
					l_paidTime = l_paidTime.replace(":", "").trim();
					
				}
				l_response_str_add = XHJSONUtil.getJsonChild(l_response_str, "additionalData");
				l_maskedCardNo = XHJSONUtil.getJsonRequestString(l_response_str_add,"maskedCardNo");
				l_maskedCardNo = l_maskedCardNo.trim();
				l_app_msg = " ::: l_maskedCardNo : "+l_maskedCardNo;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_cardHolderName=XHJSONUtil.getJsonRequestString(l_response_str_add,"cardHolderName");
				l_cardHolderName = l_cardHolderName.trim();
				l_app_msg = " ::: l_cardHolderName : "+l_cardHolderName;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_cardType=XHJSONUtil.getJsonRequestString(l_response_str_add,"cardType");
				l_cardType = l_cardType.trim();
				l_app_msg = " ::: l_cardType : "+l_cardType;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_batchNo=XHJSONUtil.getJsonRequestString(l_response_str_add,"batchNo");
				l_batchNo = l_batchNo.trim();
				l_app_msg = " ::: l_batchNo : "+l_batchNo;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_tid=XHJSONUtil.getJsonRequestString(l_response_str_add,"tid");
				l_tid = l_tid.trim();
				l_app_msg = " ::: l_tid : "+l_tid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_acqBank=XHJSONUtil.getJsonRequestString(l_response_str_add,"acqBank");
				l_acqBank = l_acqBank.trim();
				l_app_msg = " ::: l_acqBank : "+l_acqBank;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_mid=XHJSONUtil.getJsonRequestString(l_response_str_add, "mid");
				l_mid = l_mid.trim();
				l_app_msg = " ::: l_mid : "+l_mid;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}		
			l_app_msg = " ::: Before l_status_return... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_status_return = "\""+l_billInvoiceNo+"\","+"\""+l_approval_Code+"\","+"\""+l_paymentStatus+"\","+"\""+l_maskedCardNo+"\","+"\"XXXX\","+"\""+l_cardHolderName+"\","+"\""+l_cardType+"\","+"\""+l_bankInvoiceNo+"\","+"\""+l_batchNo+"\","+
					"\""+l_tid+"\","+"\"\","+"\""+l_paymentStatus+"\","+"\""+l_acqBank+"\","+"\""+l_mid+"\","+"\""+l_rrn+"\","+"\"0\","+"\"1\","+
					"\""+l_mid+"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\"\","+"\""+l_paidAmount+"\","+"\"\","+"\"\","+"\""+l_paidDate+"\","+"\""+l_paidTime+"\","+"\""+l_uuid+"\"";

			l_app_msg = " ::: l_status_return : "+l_status_return;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		}
		
        l_app_msg = " ::: l_status_return from JSON : "+ l_status_return;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		return l_status_return;
	}

	
	
	
	

	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message,String request){
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "";
		String clientIpAddress = "";


		String l_profile_id = "", l_standard_code = "HTTPCC";
		String l_http_user_agent = "", l_http_content_type = "", l_http_transfer_encoding = "", l_http_soapaction = "", l_url = "";
		int l_http_content_length_flag  = 0;
		int l_http_timeout  = 0;

		String l_request_url = "",l_request_type="",l_request_url_cloud="",l_element_id="";

		HttpURLConnection conn = null;

		String l_response_msg = "", l_return_resp = "";
		
		String strStdQuery = "", l_std_code = "", strSegQuery = "", l_segment_id = "";


		l_app_msg = " ::: Inside TransCommunicationMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Protocol Link ID : "+ protocolLinkID + " ::: Action Key : " + actionKey + " ::: Message : "+message;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Fetching Communication Standards ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, protocolLinkID);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_profile_id = rs.getString("PROFILE_ID");
			   l_url = rs.getString("XML_STYLE_SHEET_URL");
			   l_standard_code = rs.getString("STANDARD_CODE");
			   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
			   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
			   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
			   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
			   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
			}

			l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			strStdQuery = "Select standard_code||'$!^' from XH_PROTOCOL_LINK where PROTOCOL_LINK_ID = '"+protocolLinkID+"'";
			String[] stdQueryResult = XHUtil.singleParamExeQry(strStdQuery).split(Pattern.quote("$!^"), -1);		
			l_std_code = stdQueryResult[0];
			l_app_msg = "Fetching Standard Code ::: "+l_std_code;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			strSegQuery = "Select segment_type||'$!^' from XH_SEGMENT where STANDARD_CODE = '"+l_std_code+"' and CONTROL_YN = 'Y'";			
			String[] segQueryResult = XHUtil.singleParamExeQry(strSegQuery).split(Pattern.quote("$!^"), -1);
			l_segment_id = segQueryResult[0];
			l_app_msg = "Fetching Segment ID ::: "+l_segment_id;
			if(l_debug_YN.equals("Y")) System.out.println(l_app_msg);		
			

			l_app_msg = " ::: Fetching Time out... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt = null;
			rs = null;
			
			query = "SELECT COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM WHERE PLUGIN_TYPE = ? ";

			pstmt = dbConn.prepareStatement(query);	
			pstmt.setString(1, l_segment_id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_http_timeout = rs.getInt("COMM_PROCESS_IDLE_TIME");			   
			}
			
			if (l_http_timeout == 0)
				l_http_timeout = 60;
			
			l_http_timeout = l_http_timeout * 1000;// To convert to milliseconds
			
			l_app_msg = " ::: HTTP Time Out : "+ l_http_timeout;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			// ipAddress code added
			
			l_app_msg = " ::: Fetching Client IP Address ... ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			clientIpAddress = FieldValueFetchMethod(actionKey,"clientIPAddress=",null,l_field_separator, "TransCommunicationMethod");
			clientIpAddress = clientIpAddress.trim();
			l_app_msg = " ::: Client IP Address : "+clientIpAddress;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			if (clientIpAddress.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = clientIpAddress;
			}
			
			l_url = l_url.replace("localhost", clientIpAddress.toLowerCase());	
			
			if (!(request.length()>0))
			{
			    l_app_msg = " :::  Url : "+l_url;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				l_request_url = l_url + message ;
			}
			else{
				l_app_msg = " :::  Url : "+l_url;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				l_request_type = request + "_URL";
				
				l_app_msg = "Retrieving Request URL...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				l_element_id = l_request_type;

				l_request_url_cloud = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
				l_app_msg = " ::: l_request_url_cloud : "+l_request_url_cloud;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				if (l_request_url.indexOf("Error")>=0)
				{
					return l_request_url_cloud;
				}
				
				l_request_url= l_url + "/" + l_request_url_cloud;
			}

			l_request_url = l_request_url.trim();

			l_app_msg = " ::: Request Url : "+l_request_url;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			URL url = new URL(l_request_url);	
			
			if (!(request.length()>0)){
				
				l_app_msg = " ::: URL Open Connection...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
				conn = (HttpURLConnection) url.openConnection();
	
				l_app_msg = " ::: Connection Set Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
				conn.setRequestMethod("GET");
				
				l_app_msg = " ::: Connection Set Timeout...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				conn.setConnectTimeout(l_http_timeout);
	
				conn.setReadTimeout(l_http_timeout);
				
				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
				/*
				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();
				*/
			}
			else{
				
				l_app_msg = " ::: URL Open Connection...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
				conn = (HttpURLConnection) url.openConnection();
	
				l_app_msg = " ::: Connection Set Method...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
	
				conn.setRequestMethod("GET");
				
				l_app_msg = " ::: Connection Set Timeout...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				conn.setConnectTimeout(l_http_timeout);
	
				conn.setReadTimeout(l_http_timeout);
				
				if (!(l_http_content_type.equals("XXX")))
				{
					l_app_msg = " ::: Set Property Content-Type...";
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					conn.setRequestProperty("Content-Type", l_http_content_type);
				}
				
				if(request.equalsIgnoreCase("WITHDRAW_MONEY")|| request.equalsIgnoreCase("CHECK_STATUS")){
					
					if (l_authToken.length() > 0)
					{
						l_app_msg = " ::: Set Property authToken...";
						if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
						conn.setRequestProperty("authToken", l_authToken);
					}
				}
				
				l_app_msg = " ::: conn.setUseCaches(false)...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				
				conn.setUseCaches(false);

				l_app_msg = " ::: conn.setDoOutput(true)...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
				conn.setDoOutput(true);

				l_app_msg = " ::: Writing the request to the OutputStream...";
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();
				
			}
			l_app_msg = " ::: Reading the response from the OutputStream...";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			InputStream is;
			try{
				is = conn.getInputStream();
			}catch(Exception e){
				is = conn.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((is)));

			l_app_msg = " ::: Output from Server .... \n";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			while ((l_response_msg = br.readLine()) != null) {
				l_return_resp = l_return_resp + l_response_msg;
				l_app_msg = " ::: Server Response : "+l_return_resp;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			}
			
			conn.disconnect();
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: MalformedURLException ::: " +l_response_msg);			
			return l_response_msg;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: IOException ::: " +l_response_msg);			
			return l_response_msg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_response_msg = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(" ::: Exception ::: " +l_response_msg);
			return l_response_msg;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		l_app_msg = " ::: l_return_resp : "+l_return_resp;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		return l_return_resp;
	}

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";	

		try
		{
			
			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}

	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSegMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'X') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("DEFAULT_VALUE");
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_field_value;
	}
	
	public String GenerateTransIDMethod(){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		int l_trans_id = 0;

		l_app_msg = " ::: Inside GenerateTransIDMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select XH_INTERACTIVE_TRX_NO_SEQ.NEXTVAL TRANSID FROM DUAL " ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_trans_id = rs.getInt("TRANSID");
			}

			if (l_trans_id > 0 )
			{
				l_field_value = String.valueOf(l_trans_id);
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	

		return l_field_value;
	}
	
	public static Map<String,String> getRequestParams()
	{
		Map<String,String> requestParams = new HashMap<String,String>();		
		return requestParams;
	}

	public static String getFormattedStringDate(String format,Date date)
    {	
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
    }
	
	public String GetAuthToken(String applicationId,String actionKey) throws ParseException{
		
		l_app_msg = " ::: inside GetAuthToken method : ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		String l_element_id="",l_auth_token_flag="",l_auth_valid_days="";

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "",today="",l_modified_date="";
		
		
		l_element_id = "AUTH_TOKEN_FLAG";

		l_auth_token_flag = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: AUTH TOKEN FLAG : "+l_auth_token_flag;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_auth_token_flag.indexOf("Error")>=0)
		{
			return l_auth_token_flag;
		}
		
		l_element_id = "AUTH_VALID_DAYS";

		l_auth_valid_days = FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
		l_app_msg = " ::: AUTH VALID DAYS : "+l_auth_valid_days;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_auth_token_flag.indexOf("Error")>=0)
		{
			return l_auth_valid_days;
		}
		
		l_app_msg = " ::: l_segment_id : "+l_segment_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: l_standard_code : "+l_standard_code;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving AUTH TOKEN VALUE ADDED_DATE and MODIFIED_DATE...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "SELECT MODIFIED_DATE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_segment_id);
			pstmt.setString(2, l_standard_code);
			pstmt.setString(3, "AUTH_TOKEN_VALUE");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				l_modified_date = sqlDateToString(rs.getTimestamp("MODIFIED_DATE"));
			}
			
		}
		catch(Exception e)
		{
			today = "Error in "+ l_app_msg + " : " +  e.getMessage();
			l_modified_date = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		today =new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
		Date todayDate = dateFormat.parse(today);
		Date modified_date = dateFormat.parse(l_modified_date);
		
		l_app_msg = " ::: modified_date : "+modified_date;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: todayDate : "+todayDate;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_auth_valid_days=l_auth_valid_days.trim();
		
		int auth_valid= Integer.parseInt(l_auth_valid_days);
		
		if(auth_valid == 0){
			
			l_authToken=GenerateAuthToken(applicationId,actionKey);
		}
		else{
				int authDays=(auth_valid)*(60*60*24);
				l_app_msg = " ::: auth valid Days in  : "+authDays;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = " ::: todayDate.getTime() : "+todayDate.getTime();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				l_app_msg = " ::: modified_date.getTime() : "+modified_date.getTime();
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				int diff = (int) ((todayDate.getTime() - modified_date.getTime()) / (1000));
				l_app_msg = " ::: difference between current date and modified date : "+diff;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				boolean compareDates = (diff) > authDays;
				
				l_app_msg = " ::: compareDates : "+compareDates;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
				if((l_auth_token_flag.equalsIgnoreCase("Y")) && compareDates){
				
					l_authToken=GenerateAuthToken(applicationId,actionKey);
				}
				else{
					l_element_id = "AUTH_TOKEN_VALUE";
		
					l_authToken=FetchStdCntrlSegMethod(l_segment_id, l_element_id, l_standard_code);
					l_app_msg = " ::: AUTH TOKEN VALUE : "+l_authToken;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
					if (l_authToken.indexOf("Error")>=0)
					{
						return l_authToken;
					}
				}
			}
		return l_authToken;
	}
	
	public String GenerateAuthToken(String applicationId,String actionKey) throws ParseException{
		
		String l_request_msg="",l_response_msg="",l_response_str="",l_element_id="",l_trans_value="";
		
		l_app_msg = " ::: Generating Transaction id...";
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);

		l_trans_value = GenerateTransIDMethod();
		l_app_msg = " ::: l_trans_value : "+l_trans_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		if (l_trans_value.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_trans_value;
		}
	
		l_app_msg = " ::: Calling CloudMessageBuild Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
        
		l_request_msg  = CloudMessageBuildMethod(l_invoice_no, actionKey,"GET_AUTHTOKEN");
		l_app_msg = " ::: GET AUTHTOKEN Request Message : "+l_request_msg;
        if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
        
        l_app_msg = " ::: Calling InteractiveTableInsertion Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{
			l_response_msg=InteractiveTableInsertionMethod(applicationId,actionKey,l_request_msg,l_trans_value);
			
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}
		}
		l_app_msg = " ::: Calling HTTPGateway Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		if (l_errcd.equals("S"))
		{
			l_response_msg = TransCommunicationMethod("INNOCTM", actionKey, l_request_msg,"GET_AUTHTOKEN");
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		l_app_msg = " ::: Calling CloudMessageLoad Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{
			//l_response_msg="{\"merchantid\":\"TestMerchant\",\"authToken\":\"TestMerchant[B@3f3e8999\",\"statusCode\":\"00\",\"statusMessage\":\"Success\"}";
			l_response_str  = CloudMessageLoadMethod(actionKey, l_response_msg,"GET_AUTHTOKEN");
			l_app_msg = " ::: l_response_str : "+l_response_str;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_str.indexOf("Error")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_str;
			}
		}
		l_app_msg = " ::: Calling InteractiveTableUpdation Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{
			l_response_msg = InteractiveTableUpdationMethod(l_response_msg,l_response_str,l_trans_value);
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		l_app_msg = " ::: Calling Control Segment Updation Method...";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		if (l_errcd.equals("S"))
		{
			l_element_id="AUTH_TOKEN_VALUE";
			l_response_msg = ControlSegmentUpdationMethod(l_authToken,l_segment_id,l_standard_code,l_element_id);
			l_app_msg = " ::: l_response_msg : "+l_response_msg;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
			
			if (l_response_msg.indexOf("Error in ")>=0)
			{
				l_errcd = "E";
				l_errmsg = l_response_msg;
			}

		}
		
		return l_authToken;
		
	}

	
	public static String sqlDateToString(Timestamp timestamp){
	    if(timestamp != null) {
	        java.util.Date utilDate = new java.util.Date(timestamp.getTime());
	        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	        return dateFormat.format(utilDate);
	    }
	    return null;
	}
	
	public String ControlSegmentUpdationMethod(String defaultValue,String segmentId,String standardCode,String elementId){
		
		l_app_msg = " ::: inside Control Segment Updation Method : ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		String updateStmt = "";
		dbConn = null;
		pstmt = null;
		int updateCount = 0;	
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();  
		System.out.println(dateFormat.format(cal.getTime()));
		java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
		try
		{
			
			dbConn =  EMDataSource.getConnection();
			updateStmt = " UPDATE XH_STANDARD_CONTROL_SEG "
							+" SET	DEFAULT_VALUE  = ?, "
							+"		ADDED_DATE     = ?, "
							+" 		MODIFIED_DATE     = ? "
							+" WHERE SEGMENT_ID = ? " 
							+" AND STANDARD_CODE  = ? " 
							+" AND ELEMENT_ID = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, defaultValue);
			pstmt.setTimestamp(2, timestamp);
			pstmt.setTimestamp(3, timestamp);
			pstmt.setString(4, segmentId);
			pstmt.setString(5, standardCode);
			pstmt.setString(6, elementId);
			updateCount = pstmt.executeUpdate();

			l_app_msg = " ::: UpdateCount : "+updateCount;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

			
			if (updateCount == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
				l_errcd = "E";
				l_errmsg = " Error in updating Interactive Integration Records ";				
			}

		}
		catch(Exception e)
		{
			l_errcd = "E";
			l_errmsg = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return l_errcd;
		
	}

	public String GenerateInvoiceNoMethod(){
	
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
	
		String query = "";
		String l_app_msg = "", l_field_value = "";
	
		int l_trans_id = 0;
	
		l_app_msg = " ::: Inside GenerateInvoiceNoMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select XH_INTERACTIVE_INVOICE_NO_SEQ.NEXTVAL TRANSID FROM DUAL " ;
	
			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_trans_id = rs.getInt("TRANSID");
			}
	
			if (l_trans_id > 0 )
			{
				l_field_value = String.valueOf(l_trans_id);
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  l_trans_id;
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	
	
		return l_field_value;
	}
	
	
}
