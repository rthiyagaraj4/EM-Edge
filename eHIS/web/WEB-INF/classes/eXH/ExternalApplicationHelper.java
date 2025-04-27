/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;

import java.util.*;
import java.io.*;

public class ExternalApplicationHelper
{
	boolean isDebugYN = false;
	
	public ExternalApplicationHelper() {

	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response,
								Map<String, String> reqParams) throws Exception {
		String protocolLinkID = reqParams.get("PROTOCOL_LINK_ID");
		String settlementType = reqParams.get("P_settlement_type");
		String applicationID = reqParams.get("intExtAppID");
		CreditCardTransactions ccTransactions = new CreditCardTransactions();
		
		try{

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			
			if(isDebugYN) 
				System.out.println("processRequest... " + protocolLinkID +" settlementType ... "+ settlementType +" applicationID ... "+applicationID);

			if("CC01".equals(protocolLinkID)) 
			{
				if (settlementType.toUpperCase().equals("WC"))
				{
					ccTransactions.processCC01Transaction(reqParams);
				}
				else
				{
					ccTransactions.processPlutusTransaction(reqParams);
				}
				
			}
			/*
			else if(("PLUTUSKDPL".equals(protocolLinkID)) || ("PLUTUSKHPL".equals(protocolLinkID)) || 
					("PHONEPEPL".equals(protocolLinkID)) || ("PLUTUSPL".equals(protocolLinkID))) 
					*/
			else if(("PLUTUS".equals(applicationID)) || ("PHONEPE".equals(applicationID)) || ("PINEUPI".equals(applicationID))) 
			{
				if(isDebugYN) 
					System.out.println("processRequest..7.");

				ccTransactions.processPlutusTransaction(reqParams);	
				
				/*

				if ("PHONEPE".equals(applicationID))
				{
					credResponse = reqParams.get("response"); 
					strResponse = new String(credResponse); 

					chkTrnStatus = reqParams.get("CHECK_TRN_STATUS"); 
					strRetryCount = reqParams.get("CHECK_NO_TIMES"); 

					strSub = "TRANSACTION INITIATED - CHECK GET STATUS!";
					
					intwhileCount = 0;
					intRetryCount = Integer.parseInt(strRetryCount);
					
					if(isDebugYN) 
						System.out.println(" PhonePe Transaction chkTrnStatus ::: "+chkTrnStatus+" ::: strRetryCount ::: "+strRetryCount);

					if ("Y".equals(chkTrnStatus))
					{
						if(isDebugYN) 
							System.out.println(" PhonePe Transaction response check transaction index ::: "+strResponse.indexOf(strSub));

						if (strResponse.indexOf(strSub)>0)
						{
							st = new StringTokenizer(strResponse,delims );
							while (st.hasMoreElements()) {
								tokenD.add(st.nextToken());			
							}
							if(isDebugYN) 
								System.out.println("tokenD.size() ::: "+tokenD.size());

							if (tokenD.size()>0)
							{
								rocNo = tokenD.get(2);
								batchId = tokenD.get(8);	
								
								if(isDebugYN) 
									System.out.println(" PhonePe Transaction rocNo ::: "+rocNo+" ::: batchId ::: "+batchId );
								
								reqParams.put("ROC_NO", rocNo);
								reqParams.put("BATCH_ID", batchId);
							}

						}
						while (strResponse.indexOf(strSub)>0 && intwhileCount < intRetryCount)
						{
							reqParams.put("CHECK_STATUS", "Y");
							ccTransactions.processPlutusTransaction(reqParams);
							credResponse = reqParams.get("response"); 
							strResponse = new String(credResponse); 
							intwhileCount++;
						}	
					}									
				}				
				*/
			}
		}
		catch (Exception e) {
			System.out.println(" Exception in ExternalApplicationHelper.processRequest::: "+e);
			e.printStackTrace();
		}
	}
}

