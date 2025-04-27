package HL7Engine.InboundProcess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.EMConstants;

public class CustomTransactions 
{
	private static CustomTransactions customTransactions;
	InboundServerParameters serverParameters;	
	InboundServerDBInteraction serverDB;
	Common common;
	
	private CustomTransactions(InboundServerDBInteraction serverDB)
	{
		this.serverDB = serverDB;
		serverParameters = serverDB.serverParameters;
		common = Common.getInstance();
	}
	
	public static CustomTransactions getInstance(InboundServerDBInteraction serverDB)
	{
		if(customTransactions == null)
		{
			customTransactions = new CustomTransactions(serverDB);
		}
		return customTransactions;
	}
	
	public void processPDF(String message)
	{
		File pdfFile = null;
		String orderNo = "", fillerOrderNo = "", contraSysEvnCode = "";
		
		HashMap<String,List<String>> msgSegments = CommonUtil.splitMessage(message,
				serverParameters.messageStart, 
				serverParameters.messageEnd,
				serverParameters.messageSegmentStart, 
				serverParameters.messageSegmentEnd,
				serverParameters.fieldSeperator);
		if(msgSegments != null)
		{
			List<String> obxSegList = msgSegments.get(EMConstants.ORDER_RESULT_SEG);
			List<String> mshSegList = msgSegments.get(EMConstants.MESSAGE_HDR_SEG);
			List<String> obrSegList = msgSegments.get(EMConstants.ORDER_REQUEST_SEG);
			
			if(mshSegList != null)
			{				
				String msgType = mshSegList.get(8).substring(4);
				String msgID = mshSegList.get(11);
				//Added by Sethu for ML-BRU-CRF-0615 on 04/03/2022
				String facilityId = mshSegList.get(3);
				
				// or Condition Added by Sethu for ML-BRU-CRF-0615 on 04/03/2022
				//or Condition EMConstants.DOC_T08_EVENT.equals(msgType) Added by Sethu for ML-MMOH-SCF-2622 on 24/01/2024
				if((EMConstants.ORDER_RESULT_EVENT.equals(msgType) && obxSegList != null && ("RP".equals(obxSegList.get(2)))) 
						||(EMConstants.DOC_MDM_EVENT.equals(msgType) && obxSegList != null && ("RP".equals(obxSegList.get(2))))
						||(EMConstants.DOC_T08_EVENT.equals(msgType) && obxSegList != null && ("RP".equals(obxSegList.get(2)))))
				{
					String pdfPath = obxSegList.get(5);
					if(pdfPath != null && !pdfPath.equals(""))
					{
						try {
							common.fileOutput(serverParameters.strLogFile, "(CustomTransactions:processPDF) !!! ****************** at "+pdfPath+" ************\n");
							pdfFile = new File(pdfPath);
						}
						catch(Exception e){
							common.fileOutput(serverParameters.strExceptionLogFile, "(CustomTransactions:processPDF) !!! Exception while accessing PDF file "+CommonUtil.getStringStackTrace(e) + "\n" ) ;
						}
						
						if(pdfFile.exists())
						{
							//If Condition Added by Sethu for ML-BRU-CRF-0615 on 04/03/2022
							if (EMConstants.ORDER_RESULT_EVENT.equals(msgType) && obxSegList != null && ("RP".equals(obxSegList.get(2))))
							{
								orderNo = (String)((ArrayList)msgSegments.get("ORC")).get(2); // ORC[2] - Order No
								orderNo = CommonUtil.emSubstring(orderNo, 0, orderNo.indexOf("!"));
								fillerOrderNo = obrSegList.get(3);
							}
							contraSysEvnCode = obxSegList.get(3);
							contraSysEvnCode = CommonUtil.emSubstring(contraSysEvnCode, 0, contraSysEvnCode.indexOf(EMConstants.HL7_ELE_SEPARATOR));
							//If Condition EMConstants.DOC_MDM_EVENT.equals(msgType) Added by Sethu for ML-BRU-CRF-0615 on 04/03/2022
							//EMConstants.DOC_T08_EVENT.equals(msgType) Added by Sethu for ML-MMOH-SCF-2622 on 24/01/2024
							if ((EMConstants.DOC_MDM_EVENT.equals(msgType) || EMConstants.DOC_T08_EVENT.equals(msgType)) 
									&& obxSegList != null && ("RP".equals(obxSegList.get(2))))
							{
								fillerOrderNo = facilityId;
							}
							updateEncounterObj(orderNo, pdfPath, fillerOrderNo, contraSysEvnCode);
						}
						else
						{
							common.fileOutput(serverParameters.strLogFile, "(CustomTransactions:processPDF) !!! PDF file does not exist at "+pdfPath+" !!!\n");
						}
					}
					else
					{
						common.fileOutput(serverParameters.strLogFile, "(CustomTransactions:processPDF) !!! PDF Path does not exist !!!\n");
					}
				}
			}
		}		
	}

	private void updateEncounterObj(String orderNo, String pdfFileName, String fillerOrderNo, String contraSysEvnCode)
	{
		if( orderNo != null && !orderNo.trim().equals("") )
		{
			InboundUtil inboundUtil = new InboundUtil(serverParameters);
			File pdfFile = new File(pdfFileName);
			if(pdfFile.exists())
			{
				HashMap<String,String> paramList = serverDB.getOrderParamList(orderNo, "1", fillerOrderNo);
				paramList = inboundUtil.getOrderEventType(paramList);
				boolean pdfUpdated = serverDB.updatePDFFile(
												(String)paramList.get("eventType"),
												(String)paramList.get("moduleID"),
												(String)paramList.get("accession_num"),
												contraSysEvnCode,
												(String)paramList.get("event_title"),
												pdfFileName);
				if(serverParameters.logToFile)
				{					
					common.fileOutput(serverParameters.strLogFile, "(InboundServerRead:run) Updating PDF " +pdfFileName+ "\n");
				}
				if(pdfUpdated) common.fileOutput(serverParameters.strLogFile, "(CustomTransactions:updateEncounterObj) PDF file updated\n" );
				else common.fileOutput(serverParameters.strLogFile, "(CustomTransactions:updateEncounterObj) Failed to update PDF file !!!\n" );
			}																
		}					
	}

	public void performTransactions(String message) 
	{
		try
		{
			String customProtocols [] = {EMConstants.SRR_RIS_IB_PROTOCOL,EMConstants.MOHBR_PACS_IB_PROTOCOL,EMConstants.MOHBR_CPAC_IB_PROTOCOL, EMConstants.MOHBR_LIS_IB_PROTOCOL, EMConstants.SDNG_T08_IB_PROTOCOL};
			if(CommonUtil.equalsAny(serverParameters.strProtocolId, customProtocols))
			{
				processPDF(message);
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}
}
