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
				
				if(EMConstants.ORDER_RESULT_EVENT.equals(msgType) && obxSegList != null && ("RP".equals(obxSegList.get(2))))
				{
					String pdfPath = obxSegList.get(5);
					if(pdfPath != null && !pdfPath.equals(""))
					{
						File pdfFile = new File(pdfPath);
						if(pdfFile.exists())
						{
							String orderNo = (String)((ArrayList)msgSegments.get("ORC")).get(2); // ORC[2] - Order No
							String fillerOrderNo = obrSegList.get(3);
							String contraSysEvnCode = obxSegList.get(3);
							contraSysEvnCode = contraSysEvnCode.substring(0, contraSysEvnCode.indexOf(EMConstants.HL7_ELE_SEPARATOR));
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
			if(EMConstants.SRR_RIS_IB_PROTOCOL.equals(serverParameters.strProtocolId))
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
