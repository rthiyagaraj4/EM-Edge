/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.util.Map;
import java.util.regex.Pattern;

public class CreditCardTransactions
{
	//private static final long serialVersionUID = 1L;
	boolean isDebugYN = false;

	/*
	* !!! 
	 * This method is being called directly from Billing module in case of SettleBill request. 
	 * Any change should be handled appropriately 
	 * !!!
	 * */ 
	/**
	 * CC01 is the protocol link ID for Walletree card integration  - Medicity. Integration is a 2 step process.
	 * GetCardBalance & SettleBill. Value of parameter P_Reciept_number is being checked to differentiate between these 2 requests from billing module
	 * @param reqParams  Map should contain all the keys as mentioned in Card Integration TechnicalCard Integration – Technical Reference Manual - Version xx.doc
	 * @return responseMsg  Response in the format as mentioned in the doc
	 */
	public String processCC01Transaction(Map<String, String> reqParams) throws Exception {
		String responseHeader = "";
		String successResponse = "";
		String receiptNumber = reqParams.get("P_Reciept_number");
		reqParams.put("CLIENT_MACHINE", "WALLETREE");

		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
		
		if(receiptNumber != null && !receiptNumber.equals("")) {
			settleBillsCC01(reqParams);
			responseHeader = "//GetBillsResponse/*";
		}
		else {
			getBalanceCC01(reqParams);
			responseHeader = "//GetCardBalanceResponse/*";
			successResponse = XHUtil.getLocaleMessage(reqParams.get("locale"), "XH0123", "XH");
		}
		
		String responseMsg = reqParams.get("RESPONSE_TEXT");
		processResponseCC01(responseMsg, responseHeader, reqParams, successResponse);
		responseMsg = reqParams.get("response");
		return responseMsg;
	}
	/*
	public String processCC01Transaction(Map<String, String> reqParams) throws Exception {
		String responseHeader = "";
		String successResponse = "";
		String customerID = XHUtil.singleParamExeQry("SELECT customer_id from sm_site_param");
		if("KDAH".equals(customerID)) {
			reqParams.put("intExtAppID", "PLUTUS");
			processPlutusTransaction(reqParams);
		}		
		
		String responseMsg = reqParams.get("RESPONSE_TEXT");
		processResponseCC01(responseMsg, responseHeader, reqParams, successResponse);
		responseMsg = reqParams.get("response");
		return responseMsg;
	}
	*/
	// Refer Card Integration API - Technical Details.doc for response format spec
	private void processResponseCC01(String response, String requestHeaderNode,
										Map<String, String> reqParams, String successResponse) throws Exception {
		String responseType = "toModule";
		String responseMsg = getSettleBillResponse(reqParams);

		reqParams.put("responseType", responseType);
		reqParams.put("response", responseMsg);
	}

	private String getSettleBillResponse(Map<String, String> reqParams) {
		String receiptNumber = reqParams.get("P_Reciept_number");
		String requestType = "GCBR";
		
		if(receiptNumber != null && !receiptNumber.equals("")) {
			requestType = "GBR";
		}
		
		reqParams.put("requestType", requestType);

		return processResponse(reqParams);
	}
	
	private String processResponse(Map<String, String> reqParams) {
		CreditCardDAO creditCardDAO = new CreditCardDAO();

		StringBuilder inputStringBuilder = new StringBuilder();
		inputStringBuilder.append(reqParams.get("requestType"));
		inputStringBuilder.append("|");
		inputStringBuilder.append(reqParams.get("RESPONSE_TEXT"));
		inputStringBuilder.append("|");
		inputStringBuilder.append(reqParams.get("P_PATIENT_NAME"));
		inputStringBuilder.append("|");
		inputStringBuilder.append(reqParams.get("INTERACTIVE_TRX_NO"));
		inputStringBuilder.append("|");
		inputStringBuilder.append(reqParams.get("INTERACTIVE_TRX_NO"));
		inputStringBuilder.append("|");
		inputStringBuilder.append("");
		inputStringBuilder.append(reqParams.get("P_Preapaid_Card_Number"));
		inputStringBuilder.append("||");
		inputStringBuilder.append(reqParams.get("INTERACTIVE_TRX_NO"));
		inputStringBuilder.append("||");
		
		reqParams.put("INPUT_STRING", inputStringBuilder.toString());
		
		String responseMsg = creditCardDAO.getSettleBillResponse(reqParams);
		System.out.println("(CreditCardTransactions:processResponse) Response " + responseMsg);
		reqParams.put("response", responseMsg);
		return responseMsg;
	}

	private void getBalanceCC01(Map<String, String> reqParams) throws Exception {
		String balanceRequest = "<GetCardBalanceRequest> <BillAmount>#REQ_P_doc_amt_END</BillAmount> <CardNumber>#REQ_P_Preapaid_Card_Number_END</CardNumber> <Uhid>#REQ_P_patient_id_END</Uhid>   </GetCardBalanceRequest>";
		String responseFormat = "<GetCardBalanceResponse>	<Status>1</Status>	<description />	<errorList /></GetCardBalanceResponse>";
		
		reqParams.put("REQUEST_SYNTAX", balanceRequest);
		reqParams.put("RESPONSE_SYNTAX", responseFormat);
		reqParams.put("URL", reqParams.get("URL") + "/getcardbalance");
		
		HTTPTransactions httpTransactions = new HTTPTransactions();
		httpTransactions.processRequest(reqParams);
	}

	private void settleBillsCC01(Map<String, String> reqParams) throws Exception {
		String settleBillRequest = "<GetBillsRequest>  <Billamount>#REQ_P_doc_amt_END</Billamount> <Billdate>#REQ_docDate_END</Billdate> <CardNumber>#REQ_P_Preapaid_Card_Number_END</CardNumber> <Episodeid>#REQ_P_episode_ID_END</Episodeid> <Receiptdate>#REQ_receiptDate_END</Receiptdate> <Receiptno>#REQ_P_RECEIPT_TYPE_END/#REQ_P_Reciept_number_END</Receiptno> <TotalBillAmount>#REQ_P_Total_Bill_Amount_END</TotalBillAmount> <UHid>#REQ_P_patient_id_END</UHid> <billno>#REQ_P_Bill_Doc_Type_END/#REQ_P_Bill_Doc_Num_END</billno> <userId>#REQ_LOGIN_USER_END</userId> </GetBillsRequest>";
		String responseFormat = "<GetBillsResponse>	<Status>1</Status>	<description />	<errorList /></GetBillsResponse>";
		
		reqParams.put("intExtAppID", "WALLETREE");
		
		fetchDMSFilterDtls(reqParams);
		updateInteractiveParams(reqParams);
		
		reqParams.put("REQUEST_SYNTAX", settleBillRequest);
		reqParams.put("RESPONSE_SYNTAX", responseFormat);
		reqParams.put("URL", reqParams.get("URL") + "/billsettlement");
		
		String docDate = XHDBAdapter.checkNull(reqParams.get("p_doc_date"));
		String receiptDate = XHDBAdapter.checkNull(reqParams.get("P_Reciept_Date"));
		
		if(!docDate.equals("")) {
			reqParams.put("docDate", XHUtil.convertDateFormat(docDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"));
		}
		
		if(!receiptDate.equals("")) {
			reqParams.put("receiptDate", XHUtil.convertDateFormat(receiptDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"));
		}
		System.out.println("(settleBillsCC01) " + reqParams);
		HTTPTransactions httpTransactions = new HTTPTransactions();
		httpTransactions.processRequest(reqParams);
	}
	
	private void fetchDMSFilterDtls(Map<String, String> reqParams) {
		String query = "SELECT application_id ||'$!^'|| protocol_link_id ||'$!^'|| facility_id ||'$!^'|| external_application ||'$!^'|| external_function ||'$!^'|| event_type FROM xh_filter_dms_vw WHERE "
						+ " login_user = '*' "
						+ " AND responsibility = '*' "
						+ " AND login_function = '*' "
						+ " AND external_application = NVL('" + reqParams.get("intExtAppID") + "', external_application)";
		String protocolQry = "SELECT protocol_type ||'$!^'|| xml_style_sheet_url ||'$!^'|| IP_ADDRESS ||'$!^'|| PORT_NUMBER FROM xh_protocol WHERE protocol_id = '"+ reqParams.get("intExtAppID") + reqParams.get("P_FACILITY_ID") +"'";

		String[] queryResult = XHUtil.singleParamExeQry(query).split(Pattern.quote("$!^"), -1);
		String[] protocolQueryResult = XHUtil.singleParamExeQry(protocolQry).split(Pattern.quote("$!^"), -1);

		if(queryResult.length == 6) {
			reqParams.put("APPLICATION_ID", queryResult[0]);
			reqParams.put("PROTOCOL_LINK_ID", queryResult[1]);
			reqParams.put("FACILITY_ID", queryResult[2]);
			reqParams.put("EXTERNAL_APPLICATION", queryResult[3]);
			reqParams.put("EXTERNAL_FUNCTION", queryResult[4]);
			reqParams.put("EVENT_TYPE", queryResult[5]);
		}

		if(protocolQueryResult.length == 4) {
			reqParams.put("protocolType", protocolQueryResult[0]);
			reqParams.put("URL", protocolQueryResult[1]);
			reqParams.put("IP_ADDRESS", protocolQueryResult[2]);
			reqParams.put("PORT_NUMBER", protocolQueryResult[3]);
		}
	}
	
	private void updateInteractiveParams(Map<String, String> reqParams) {
		String strDate = XHUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", null);

		reqParams.put("LOGIN_USER", reqParams.get("P_USER_ID"));
		reqParams.put("FACILITY_ID", reqParams.get("P_FACILITY_ID"));
		reqParams.put("PGM_ID", reqParams.get("intExtAppID") + reqParams.get("P_FACILITY_ID"));
		reqParams.put("MODULE_ID", "XH");
		reqParams.put("SESSION_ID", reqParams.get("CLIENT_MACHINE"));
		reqParams.put("REQUEST_DATE", strDate);
		reqParams.put("FACILITY_ID", reqParams.get("P_FACILITY_ID"));
		reqParams.put("MESSAGE_DATE", strDate);
		reqParams.put("PATIENT_ID", reqParams.get("P_patient_id"));
		reqParams.put("EPISODE_TYPE", reqParams.get("P_EPISODE_TYPE"));
		reqParams.put("ENCOUNTER_ID", reqParams.get("P_episode_ID"));
		reqParams.put("ACC_NO", reqParams.get("P_ACCESSION_NUM"));
		reqParams.put("EXT_ACC_NO", "");			
		reqParams.put("ADDED_BY_ID", reqParams.get("P_USER_ID"));
		reqParams.put("ADDED_BY_DATE", strDate);
		reqParams.put("MODIFIED_BY_ID", reqParams.get("P_USER_ID"));
		reqParams.put("MODIFIED_BY_DATE", strDate);
		reqParams.put("ADDED_BY_FACILITY", reqParams.get("P_FACILITY_ID"));
		reqParams.put("MODIFIED_BY_FACILITY", reqParams.get("P_FACILITY_ID"));
	}

	public void processPlutusTransaction(Map<String, String> reqParams) throws Exception {
		// Commented by Sethu for IP Address 
		//reqParams.put("IP_ADDRESS", reqParams.get("clientIPAddress")); // Passing the IP address
								// of the client as the Plutus port will be listening at the local system from the transaction is being done

		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic
		int ccAppletEnabled = 0;

		try
		{
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			reqParams.put("CLIENT_MACHINE", "Plutus");
		//	fetchDMSFilterDtls(reqParams);
		//	updateInteractiveParams(reqParams);
			plutusRequest(reqParams);
			reqParams.put("responseType", "toModule");
	
			if(isDebugYN)
				System.out.println("PARAMS " + reqParams);

			//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
			ccAppletEnabled = Integer.parseInt(reqParams.get("P_CCAppletEnabled"));
			
			if(isDebugYN)
				System.out.println("Process Plutus Transaction Credit Card Applet Enabled " + ccAppletEnabled);

			if (ccAppletEnabled>0)
			{
				return;
			}

			CreditCardDAO creditCardDAO = new CreditCardDAO();
			
			String responseMsg = creditCardDAO.getSettleBillResponsePlutus(reqParams);

			if(isDebugYN)
				System.out.println("(CreditCardTransactions:processPlutusTransaction) Response " + responseMsg);

			reqParams.put("response", responseMsg);
		}
		catch (Exception e)
		{
			System.out.println(" Exception in CreditCardTransactions.processPlutusTransaction::: "+e);
			e.printStackTrace();
		}
		
	}
	
	private void plutusRequest(Map<String, String> reqParams) throws Exception {
		System.out.println("PARAMS... " + reqParams);

		//Code added by Sethu for KDAH-CRF-0504 on 13/03/2019
		String strTrnType = "", strWalletId = "";
		StringBuilder message = null;

		String chkStatus_yn = ""; 
		String batchId = "", rocNo = "", trn_chkStatus_yn = "";

		//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic
		int ccAppletEnabled = 0;
		String strApplicationId = "";

		String l_response_str = "";
		
		try
		{
			if(isDebugYN)
				System.out.println("PARAMS... " + reqParams);

			//Code added by Sethu for KDAH-CRF-0504 on 13/03/2019
			strTrnType = reqParams.get("TXN_TYPE_SEG");
			strWalletId = reqParams.get("WALLET_ID");

			if(isDebugYN)
				System.out.println("Transaction Type..."+strTrnType+" strWalletId..."+strWalletId);

			if (strWalletId.equals("X"))
				strWalletId = "";

			chkStatus_yn = reqParams.get("P_Card_Status_YN");
			trn_chkStatus_yn = reqParams.get("P_Trn_Status");
	
			if(isDebugYN)
				System.out.println("Check Status Flag..."+chkStatus_yn+" Transaction Check Status..."+trn_chkStatus_yn);

			if ("Y".equals(chkStatus_yn) && "Y".equals(trn_chkStatus_yn))
			{
				strTrnType = reqParams.get("TXN_TYPE_STATUS");
				rocNo = reqParams.get("P_Card_Roc_No");
				batchId = reqParams.get("P_Card_Batch_ID");
				
				if(isDebugYN)
					System.out.println("Transaction Check Type..."+strTrnType+" ... rocNo ... "+rocNo+" ... batchId ... "+batchId);
			}

			message = new StringBuilder(strTrnType+",");
	
			if(isDebugYN)
				System.out.println("P_settlement_type in Credicard Transaction..."+reqParams.get("P_settlement_type"));

			if(isDebugYN)
				System.out.println("Credicard Transaction Number..."+reqParams.get("P_Bill_Doc_Num"));

			if(isDebugYN)
				System.out.println("Credicard Check Status Transaction Number..."+reqParams.get("P_Card_Trn_No"));
			
			if ("N".equals(trn_chkStatus_yn))
			{
				message.append(reqParams.get("P_Bill_Doc_Num"));
			}
			if ("Y".equals(trn_chkStatus_yn))
			{
				message.append(reqParams.get("P_Card_Trn_No"));
			}
			
			message.append(",");
			message.append(Math.round(Double.parseDouble(reqParams.get("P_Total_Bill_Amount")) * 100)); 
									// Multiplying with 100 as amount should be in paise as per vendor's request format

			//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
			ccAppletEnabled = Integer.parseInt(reqParams.get("P_CCAppletEnabled"));
			strApplicationId = "";
			if (ccAppletEnabled>0)
			{
				strApplicationId = reqParams.get("intExtAppID");
			}

			if(isDebugYN)
				System.out.println("Application ID.... " + strApplicationId);

			/*

			if ("PLUTUS".equals(strApplicationId))
			{
				strWalletId = strApplicationId;
			}				
			*/

			//Code ends here Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic

			if (ccAppletEnabled>0)
			{
				message.append(","+strWalletId+","+strApplicationId+",,,,,,,");		
			}
			else
			{
				message.append(","+strWalletId+",,,,,,,,");		
			}

			if ("Y".equals(chkStatus_yn) && "Y".equals(trn_chkStatus_yn))			
			{
				message.append(""+batchId+","+rocNo+",,,,,,,,,,,");
			}

			String responseFormat = "";

			if(isDebugYN)
				System.out.println("REQUEST_SYNTAX " + message.toString());

			reqParams.put("REQUEST_SYNTAX", message.toString());
			reqParams.put("RESPONSE_SYNTAX", responseFormat);

			reqParams.put("response", message.toString());

			//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
			
			if(isDebugYN)
				System.out.println("Credit Card Applet Enabled " + ccAppletEnabled);

			reqParams.put("RESPONSE_TEXT", message.toString());

			if (ccAppletEnabled>0)
			{
				return;
			}
			if(isDebugYN)
				System.out.println("Credit Card Code continued...");

			//Code ends here Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic
			
			TCPTransactions tcpTransactions = new TCPTransactions();
			tcpTransactions.processRequest(reqParams);
		}
		catch (Exception e)
		{
			System.out.println(" Exception in CreditCardTransactions.plutusRequest::: "+e.getMessage());
			e.printStackTrace();

			l_response_str = reqParams.get("P_Bill_Doc_Num")+" ,\"\" ,"+e.getMessage()+" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"0\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\" ,\"\"";
			System.out.println(" Exception in CreditCardTransactions.plutusRequest l_response_str::: "+l_response_str);
			reqParams.put("RESPONSE_TEXT", l_response_str);
		}
		
	}	
}