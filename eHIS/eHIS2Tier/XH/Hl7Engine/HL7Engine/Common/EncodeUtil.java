package HL7Engine.Common;

public class EncodeUtil
{
	public static String unicodeEncoding(String message)
	{	
		StringBuffer hexBuffer = new StringBuffer();
		char[] rawCharArray = message.toCharArray();
		int rawCharArrayLength = rawCharArray.length;
		for (int i = 0; i < rawCharArrayLength; i++) 
		{
			if(rawCharArray[i] <= 0x000F) { hexBuffer.append("000"); }
			else if(rawCharArray[i] <= 0x00ff) { hexBuffer.append("00"); }
			else if(rawCharArray[i] <= 0x0fff) { hexBuffer.append("0"); }
			hexBuffer.append(Integer.toHexString(rawCharArray[i]));		
		}

		return hexBuffer.toString();
	}
}