package HL7Engine.OutboundProcess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.Message;
import HL7Engine.exceptions.FatalException;

public class CMDMessageProcessor implements ICommunication
{
	Message messageObj;
	private OutboundClientParameters clientParameters;
	private Common common = null;
	public static final String CMD_PARAM_SEPARATOR = "#"; 
	
	List<String> pendingList = new ArrayList<String>();
	public CMDMessageProcessor() {
	}

	public CMDMessageProcessor(OutboundClientDBInteraction clientDB,
			OutboundClientParameters clientParameters) throws Exception
	{
		this.clientParameters = clientParameters;
		common = Common.getInstance();
		initFunc();
	}

	public void initFunc() throws Exception
	{
		try {
			messageObj = new Message(clientParameters.messageStart,
									clientParameters.messageEnd,
									clientParameters.messageSegmentEnd,
									clientParameters.componentSeparator,
									clientParameters.fieldSeparator,
									clientParameters.repetitionSeparator,
									clientParameters.subComponentSeparator,
									clientParameters.escapeChar);
		}
		catch(Exception exp) {
			throw new FatalException("Exception in initializing CMDMessageProcessor");
		}
	}

	public String sendMessage(String message) throws Exception
	{
		messageObj.setMessage(message);
		processSegments();
		return "S";
	}

	private void processSegments() throws Exception
	{
		try
		{
			HashMap<String, List<String>> segmentsMap = new HashMap<String, List<String>>();
			String message = messageObj.getMessage();
			String[] msgSegments = message.split("\\" + messageObj.getSegmentEnd());
			int cmdCount = 0;

			for(String currentSegment: msgSegments)
			{
				List<String> currentSegmentList = Arrays.asList(currentSegment.split("\\" + messageObj.getFieldSeparator(), -1));
				String currentSegmentName = currentSegmentList.get(0);
				segmentsMap.put(currentSegmentName, currentSegmentList);
				
				if("CMD".equals(currentSegmentName)) {
					++cmdCount;
					processCMDSegment(segmentsMap);
				}
			}
			if(cmdCount == 0) {
				common.fileOutput(clientParameters.strLogFile, "(CMDMessageProcessor:processSegments) CMD Segment not found !!! \n");
			}
		}
		catch(Exception exp) {
			processException(exp);
			throw exp;
		}
		finally {
			pendingList.clear();
		}
	}

	private String processCMDSegment(HashMap<String, List<String>> segmentsMap) throws Exception
	{
		StringBuilder exePath = new StringBuilder();
		String statusMessage = "";
		String cmdParamSeparator = " ";
		List<String> cmdSegment = null;
		int fieldNo = 0; // variable used to skip first element of cmdSegment as first element is segment name
		try {
			cmdSegment = segmentsMap.get("CMD");
			for(String currentField : cmdSegment) {
				if(fieldNo != 0) {
					exePath.append(messageObj.getFieldValue(currentField, segmentsMap));
					exePath.append(cmdParamSeparator);
					if(fieldNo == 1) { // first param will be exe name and space should be added for that instead of CMD_PARAM_SEPARATOR
						cmdParamSeparator = CMD_PARAM_SEPARATOR;
					}
				}
				fieldNo++;
			}
			if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(CMDMessageProcessor:processCMDSegment) Exe Command:\n======\n" + exePath.toString() + "\n======\n");
			
			statusMessage = processCommunication(exePath.toString());
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(CMDMessageProcessor:processCMDSegment) Current Segment : " + cmdSegment + "\n");
			throw exp;
		}
		
		return statusMessage;
	}

	private String processCommunication(String exeCMD) throws Exception
	{
		return CommonUtil.executeCMD(exeCMD, false, false, 0);
	}

	public String processCommunication(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void closeResources()
	{
		// TODO Auto-generated method stub
	}
	
	void processException(Exception exp) throws Exception
	{
		common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processException) Exception "+ exp +"\n" );
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    throw exp;
	}
}
