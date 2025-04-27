package HL7Engine.Common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import HL7Engine.OutboundProcess.OutboundClientParameters;

public class Message
{
	private String fieldSeparator;
	private String componentSeparator;
	private String subComponentSeparator;
	private String repetitionSeparator;
	
	private String escapeChar;
	private String message;
	
	private HashMap<String, List<String>> segmentsMap;
	private String msgStartChar;
	private String msgEndChar;
	private String segmentEnd;
	
	protected OutboundClientParameters clientParameters;
	
	public String getFieldSeparator()
	{
		return fieldSeparator;
	}

	public void setFieldSeparator(String fieldSeparator)
	{
		this.fieldSeparator = fieldSeparator;
	}

	public String getComponentSeparator()
	{
		return componentSeparator;
	}

	public void setComponentSeparator(String componentSeparator)
	{
		this.componentSeparator = componentSeparator;
	}

	public String getSubComponentSeparator()
	{
		return subComponentSeparator;
	}

	public void setSubComponentSeparator(String subComponentSeparator)
	{
		this.subComponentSeparator = subComponentSeparator;
	}

	public String getRepetitionSeparator()
	{
		return repetitionSeparator;
	}

	public void setRepetitionSeparator(String repetitionSeparator)
	{
		this.repetitionSeparator = repetitionSeparator;
	}

	public String getEscapeChar()
	{
		return escapeChar;
	}

	public void setEscapeChar(String escapeChar)
	{
		this.escapeChar = escapeChar;
	}

	public String getMsgStartChar()
	{
		return msgStartChar;
	}

	public void setMsgStartChar(String msgStartChar)
	{
		this.msgStartChar = msgStartChar;
	}

	public String getMsgEndChar()
	{
		return msgEndChar;
	}

	public void setMsgEndChar(String msgEndChar)
	{
		this.msgEndChar = msgEndChar;
	}

	public String getSegmentEnd()
	{
		return segmentEnd;
	}

	public void setSegmentEnd(String segmentEnd)
	{
		this.segmentEnd = segmentEnd;
	}	
	
	public Message()
	{		
	}
	
	public Message(String msgStartChar, String msgEndChar, String segmentEnd, String componentSeparator, String fieldSeparator, String repetitionSeparator, String subComponentSeparator, String escapeChar)
	{		
		this.msgStartChar = msgStartChar;
		this.msgEndChar = msgEndChar;
		this.segmentEnd = segmentEnd;
		this.componentSeparator = componentSeparator;
		this.fieldSeparator = fieldSeparator;
		this.repetitionSeparator = repetitionSeparator;
		this.subComponentSeparator = subComponentSeparator;
		this.escapeChar = escapeChar;
		segmentsMap = new HashMap<String, List<String>>();
		formatDelimeters();
	}
	
	public void setMessage(String message)
	{
		setMessage(message, false);
	}
	
	public void setMessage(String message, boolean isMessageFormattingRequired)
	{
		this.message = message;
		truncateMsgDelimiters();
		
		if (isMessageFormattingRequired) {
			formatMessage();
		}
	}
	
	public void formatMessage()
	{
		String[] msgSegments = message.split("\\" + segmentEnd);
		
		for(String currentSegment: msgSegments) {
			List<String> currentSegmentArray = Arrays.asList(currentSegment.split("\\" + fieldSeparator));
			segmentsMap.put(currentSegmentArray.get(0), currentSegmentArray);
		}
	}

	public String getMessage()
	{
		return message;
	}

	private void truncateMsgDelimiters()
	{
		if(message.startsWith(msgStartChar)) {
			message = message.substring(message.indexOf(msgStartChar) + 1);
		}

		if(message.endsWith(segmentEnd + msgEndChar)) {
			message = message.substring(0, message.indexOf(segmentEnd + msgEndChar));
		}
	}

	private void formatDelimeters()
	{
		msgStartChar = CommonUtil.processAsciiToString(msgStartChar);
		msgEndChar = CommonUtil.processAsciiToString(msgEndChar);
		segmentEnd = CommonUtil.processAsciiToString(segmentEnd);
		componentSeparator = CommonUtil.processAsciiToString(componentSeparator);
		fieldSeparator = CommonUtil.processAsciiToString(fieldSeparator);
		subComponentSeparator = CommonUtil.processAsciiToString(subComponentSeparator);
		repetitionSeparator = CommonUtil.processAsciiToString(repetitionSeparator);
		escapeChar = CommonUtil.processAsciiToString(escapeChar);
	}

	public String getFieldValue(String segmentID, String pointer)
	{
		List<String> segmentFieldValues = getSegment(segmentID);
		return getFieldValue(segmentID, pointer, segmentFieldValues);
	}
	
	/*
	 * To get the message field value. Method handled fields for repetition also, logic as follows
	 * Pointer - 3.R4.2, 
	 * 3 indicates segment field number, R indicates field is a repeat field, 
	 * 4 indicates which repetition to be fetched, 2 indicates which subfield in repetition to be returned
	 * Eg - 3rd Field value = SA00000001~111~2222^99~3333^09~4444~5555, then 3.R4.2 will fetch value 09
	 */
	

	public String getFieldValue(String segmentID, String pointer, List<String> segmentFieldValues)
	{
		String fieldValue = segmentFieldValues.get(formatPointer(pointer, 0));
		
		pointer = pointer.substring(pointer.indexOf(".") + 1);
		
		if(pointer.contains("R")) {
		//	pointer = pointer.substring(1);
			String field = CommonUtil.emSubstring(pointer, pointer.indexOf("R") + 1,  pointer.indexOf(".")); // to get which repetition to process
			 String [] fieldValues = fieldValue.split("\\" + repetitionSeparator, -1);
			 
			 if(fieldValues.length >= Integer.parseInt(field)) {
				 fieldValue = fieldValues[Integer.parseInt(field) - 1]; 
			 }
			 else {
				 fieldValue = "";
			 }
		}
		
		// sub component in the repetition field
		if(pointer.contains(".")) {
			String [] fieldValues = fieldValue.split("\\" + componentSeparator, -1);
			
			if(fieldValues.length > formatPointer(pointer, 1)) {
				 fieldValue = fieldValues[formatPointer(pointer, 1)]; 
			 }
			 else {
				 fieldValue = "";
			 }
			
			 /* Added by Niveditha for ML-MMOH-SCF-1481 on 08/04/2020 */
			 if (!subComponentSeparator.equals(null) && (fieldValue.indexOf(subComponentSeparator)>0))
			 {
				 fieldValues = fieldValue.split("\\" + subComponentSeparator, -1);
			
				if(fieldValues.length > formatPointer(pointer, 1)) {
					fieldValue = fieldValues[formatPointer(pointer, 1)]; 
				}
				else {
					 fieldValue = "";
				}
			 }
			 /* Added by Niveditha for ML-MMOH-SCF-1481 on 08/04/2020 */
		}	
		
		return fieldValue;
	}	
	
	/* Added by Sethu for ML-BRU-CRF-0535 on 20/12/2018 */
	public String getFieldValueStr(String segmentID, String pointer, List<String> segmentFieldValues) {
        String fieldValue = null;
        fieldValue = segmentFieldValues.get(this.formatPointer(pointer, 0));
        if (pointer.contains(".")) {
            fieldValue = fieldValue.split("\\" + this.componentSeparator)[this.formatPointer(pointer, 1)];
        }
        return fieldValue;
    } 
    
    
	
	public String getFieldValue(String field, Map<String, List<String>> segments)
	{
		String fieldValue = "";
		String segmentID = "";
		String segmentField = "";
		
		Pattern pattern = Pattern.compile(":(.*?)\\[(.*?)\\]");
		Matcher matcher = pattern.matcher(field);
		
		while(matcher.find()) {
			segmentID = matcher.group(1);
			segmentField = matcher.group(2);
		}
		fieldValue = getFieldValue(segmentID, segmentField, segments.get(segmentID));
		return fieldValue;
	}
	
	/*
	 * Utility method returns the HL7 field or subfield value in numeric format based on "field" parameter.
	 * e.g.:- if the current context is for PID[3.2] and "field" is 0 then 3 will be returned else 2  
	 */
	private int formatPointer(String pointer, int field)
	{
		int completeFieldPointer = 0;
		
		if(field == 0) completeFieldPointer = new Integer(CommonUtil.emSubstring(pointer, 0, pointer.indexOf(".")));
		else completeFieldPointer = new Integer(pointer.substring(pointer.indexOf(".") + 1)) - 1; // -1 because java array/list will start from 0
																									// but the pointer mentioned will be as per HL7
		
		return completeFieldPointer;
	}

	private List<String> getSegment(String segmentID) {		
		return segmentsMap.get(segmentID);
	}	

	public static boolean isNotSingleComponent(String pointer)
	{
		boolean isNotSingleComponent = false;
		int dotIndex = pointer.indexOf(".");

		if(dotIndex != -1)
		{
			if(!pointer.endsWith(".0")) isNotSingleComponent = true;
		}

		return isNotSingleComponent;
	}
}
