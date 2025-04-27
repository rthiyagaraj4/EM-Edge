/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.Common ;

import java.util.ArrayList;
import java.util.StringTokenizer;
public class MessageTokenizer
{
//MSH|^~\&|MEDICOM|GET-WELL HOSPITAL|TEST APPLICATION||20030315101732||ADT^A04|1736|P|2.3.1|||NEEVN|A04|20020828120605||||20030315101732
//PID|||TN06501283||JOSE^^^||200103150000|M||||||||||TN06501283||||||||0027^SOUTH AFRICA (N.P)||||PV1||O||IV|||^||||||||||||50104099V1|CP||||||||||||||||||||||||200303151017||

    public String strMessageBox[];
    public String partialMsgList[];
    public String strPartialMessage = "";

    String strStartMessage = "" + ((char)11);
    String strEndMessage = "" + ((char)13) + ((char)28) + ((char)13);
    String segmentEnd;
    String fieldSeparator;
    String componentSeparator;
    String strHeader = "MSH";
    String strStartBlock = "" + ((char)11);

    public int intTotMessage;
    public int partialMessageCounter;

    String strMessageControlId = "";
    String strApplicationId = "";
    public StringBuilder partialMsgBuffer = new StringBuilder();

    int endMsgTokens = 3;
    int endMsgLen = 0;

    public String strLogFile = null;
    public boolean logToFile = false;

    Common common = Common.getInstance();

    public MessageTokenizer()
    {
    	strStartMessage = strStartBlock + strHeader;
    }

    public MessageTokenizer(String startMessage, String endMessage)
    {
    	this.strStartMessage = startMessage;
    	this.strEndMessage = endMessage;
    	strLogFile = InterfaceUtil.getDefaultLogLoc("Token");
    }

    public void setMessageDelimiters(String segmentEnd, String componentSeparator, String fieldSeparator)
    {
    	this.segmentEnd = segmentEnd;
    	this.fieldSeparator = fieldSeparator;
    	this.componentSeparator = componentSeparator;
    	formatMessageDelimiters();
    }

    public int getTokenizedMessage(String msg)
    {
    	int partialMessage = 0;
    	intTotMessage = 0;
    	partialMessageCounter = 0;
    	int intStart = 0;
    	int intEnd = 0;
    	int previousMsgEnd = 0; // Variable used to fetch partial msg in case of msg without proper start symbols.
    
    	String strTotalMessage = "";		
    
    	strTotalMessage = strPartialMessage + msg;
    	strMessageBox = new String[100];
    	partialMsgList = new String[100];
    
    	while(true)
    	{
    	    try
    	    {					
        		if( logToFile && ( strPartialMessage != null && !"".equals(strPartialMessage) ) )
        		{
        		//	common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) Partial Msg in Buffer:"+strPartialMessage+"\n" ) ;				
        		}
        
        		intStart = strTotalMessage.indexOf(strStartMessage,intStart);
        		intEnd  = strTotalMessage.indexOf(strEndMessage,intEnd);
    	    }
    	    catch(Exception exceptionGeneral)
    	    {
    	    	common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) Exception:"+exceptionGeneral+"\n" ) ;
    	    }
    	    try
    	    {
        		if(intTotMessage == 99) 
        		{
        		    common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) !!! Found more than 100 messages in single iteration, ignoring the rest !!!\n" ) ;
        		    break;
        		}
        		if ((intStart >= 0) && (intEnd > 0))	
        		{
        		    //	partialMsgBuffer.delete(0, partialMsgBuffer.length());
        		    strPartialMessage = "";
        		    previousMsgEnd = intEnd + endMsgTokens; 
        		    strMessageBox[intTotMessage] = strTotalMessage.substring(intStart,intEnd+endMsgTokens);					
        		    ++intTotMessage;
        		    partialMessage = 0;					
        		    partialMsgBuffer.append(strTotalMessage.substring(intStart, intEnd + endMsgLen));
        		}
        		else if ((intStart >= 0 ) && (intEnd < 0))
        		{
        		    //	partialMsgBuffer.delete(0, partialMsgBuffer.length());
        		    // Initial Partial Message;
        		    strPartialMessage = strTotalMessage.substring(intStart);
        		    if(logToFile) common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) End symbol missing\n" ) ;
        
        		    partialMsgList[partialMessageCounter] = strPartialMessage + "MSA|AE|16|Message Rejected |||Segment sequence error";			
        		    partialMessageCounter++;
        		    partialMessage = 2;
        		    //	partialMsgBuffer.append(msg);
        		    break;
        		}
        		else if ((intStart < 0) && (intEnd > 0))
        		{
        		    // Final Partial Message					
        		    if(logToFile) common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) Start symbol missing\n" );
        
        		    partialMsgList[partialMessageCounter] = strTotalMessage.substring(previousMsgEnd,intEnd + endMsgTokens) + 
        		    "MSA|AE|16|Message Rejected |||Segment sequence error";
        		    partialMessageCounter++;
        		    partialMessage = 1;
        		    //	partialMsgBuffer.append(msg);
        		    break;
        		}
        		else if ((intStart < 0) && (intEnd < 0))
        		{				
        		    String tempStr = strTotalMessage.substring(previousMsgEnd);
        
        		    if(!tempStr.trim().equals("")) common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) Missing Start & End symbols\n" ) ;
        		    // Middle Segment
        		    if (intTotMessage == 0)
        		    {					
        			strPartialMessage = strTotalMessage;
        			partialMessage = 2;
        			common.fileOutput( strLogFile, "(MessageTokenizer:getTokenizedMessage) Middle Segment:"+strPartialMessage+"\n" ) ;
        		    }					
        
        		    if(!tempStr.trim().equals(""))
        		    {
        			partialMsgList[partialMessageCounter] = tempStr + 
        			"MSA|AE|16|Message Rejected |||Segment sequence error";
        		    }
        		    partialMessageCounter++;
        		    break;
        		}
        		++intStart;
        		++intEnd;
        		++partialMessageCounter;
    	    }
    	    catch(Exception exp)
    	    {
        		common.fileOutput( strLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
        		break;
    	    }
    	}
    	return partialMessage;
    }

    // method Inserted by srinivasa.N 	---EPABX INTERFACE
    public void getTokenized_Message(String msg)
    {
    	int start = 0;
    	int end = 0;
    	intTotMessage = 0;
    
    	strMessageBox = new String[30];
    	start=msg.indexOf("PS",0); 
    	String stemp="";
    	String sstemp="";
    	while(true)
    	{
    	    stemp=msg.substring(3);     
    	    end=stemp.indexOf("PS|");
    	    if(end>=0) 
    	    {
        		sstemp=msg.substring(start,end+3);
        		strMessageBox[intTotMessage]=sstemp;
        		msg=msg.substring(end+3);
    	    }
    	    else
    	    {
        		sstemp=msg;
        		strMessageBox[intTotMessage]=sstemp;
        		intTotMessage++;
        		break;
    	    }
    	    start = 0;
    	    intTotMessage++;
    	}
    }	 //end of the method getTokenized_Message
    
   // method Inserted by kapil 	---ARYUINVP2 INTERFACE
    public void getTokenized_ARYU_Message(String msg)
    {
    	int start = 0;
    	int end = 0;
    	intTotMessage = 0;
    	String endMessage = "" + ((char)13) + ((char)28) + ((char)13);
    
    	strMessageBox = new String[100];
    	start=msg.indexOf("AY",0); 
    	String stemp="";
    	String sstemp="";
    	while(true)
    	{
    	    stemp=msg.substring(3);     
    	    //end=stemp.indexOf("AY|");
    	    //end = 0;
    	    end = stemp.indexOf(endMessage);    	    
    	    if(end>=0) 
    	    {
        		sstemp=msg.substring(start,end+3);
        		strMessageBox[intTotMessage]=sstemp;
        		msg=msg.substring(end+3);
    	    }
    	    else
    	    {
        		sstemp=msg;
        		strMessageBox[intTotMessage]=sstemp;
        		intTotMessage++;
        		break;
    	    }
    	    start = 0;
    	    intTotMessage++;
    	}
    }

    /**
     * Method tokenizes the message start & end characters retrieved from DB. 
     * If multiple characters has to be there as start or end for messages,
     * Database returns the number representation of the special characters with a delimiter for each character.
     */
    public void formatMessageDelimiters()
    {
    	strStartMessage = CommonUtil.formatAsciiToString(strStartMessage);		
    	segmentEnd = CommonUtil.formatAsciiToString(segmentEnd);
    	fieldSeparator = CommonUtil.formatAsciiToString(fieldSeparator);
    
    	StringBuffer temp = null;
    	StringTokenizer tokenizer = null;
    	int temp1 = 0;
    
    	if(strEndMessage != null)
    	{
    	    endMsgTokens = 0;
    	    temp = new StringBuffer();
    	    tokenizer = new StringTokenizer(strEndMessage, "|");
    	    while(tokenizer.hasMoreTokens())
    	    {
        		endMsgTokens++;
        		temp1 = Integer.parseInt(tokenizer.nextToken());
        		temp.append(((char)temp1));
    	    }
    	    strEndMessage = temp.toString();
    	}
    	else
    	{
    	    strEndMessage = "" + ((char)13) + ((char)28) + ((char)13);
    	}
    	endMsgLen = strEndMessage.length();
    }

    public String[] formatMessage(String message, String operation, String reqField, String replaceWith) throws Exception
    {
    	message = message.substring(strStartMessage.length(), message.indexOf(strEndMessage));
    
    	StringTokenizer tokens = new StringTokenizer(message, segmentEnd);
    	String segmentName = reqField.substring(1, reqField.indexOf("["));
    	String tempSegment;
    	StringBuilder retVal = new StringBuilder();
    	String reqFieldVal = "";
    	String strReqFieldIndex = reqField.substring(reqField.indexOf("[") + 1, reqField.indexOf("]"));
    	String strSubFieldIndex = "0";
    	int reqFieldIndex = 0;
    	int subFieldIndex = 0;
    	String result[] = new String[2];
    
    	if(strReqFieldIndex.indexOf(".") > 0)
    	{
    	    strSubFieldIndex = strReqFieldIndex.substring(strReqFieldIndex.indexOf(".") + 1);
    	    strReqFieldIndex = strReqFieldIndex.substring(0, strReqFieldIndex.indexOf("."));
    	    reqFieldIndex = Integer.parseInt(strReqFieldIndex);
    	    subFieldIndex = Integer.parseInt(strSubFieldIndex);
    	}
    
    //	common.fileOutput( strLogFile, "(MessageTokenizer:formatMessage) segmentName "+segmentName+" \n");
    
    	while(tokens.hasMoreTokens())
    	{
    	    tempSegment = tokens.nextToken();
    	    common.fileOutput( strLogFile, "(MessageTokenizer:formatMessage) tempSegment "+tempSegment+" \n");
    	    if(tempSegment.startsWith(segmentName))
    	    {				
        		ArrayList segmentFieldList = (ArrayList) CommonUtil.eHISStringTokenizer(tempSegment, fieldSeparator);
        
        		int fieldListSize = segmentFieldList.size();
        //		common.fileOutput( strLogFile, "(MessageTokenizer:formatMessage) reqFieldIndex "+reqFieldIndex+"\n");
        //		common.fileOutput( strLogFile, "(MessageTokenizer:formatMessage) fieldListSize "+fieldListSize+"\n");
        //		common.fileOutput( strLogFile, "(MessageTokenizer:formatMessage) subFieldIndex "+subFieldIndex+"\n");
        
        		// replace function will replace the specified field with the given value and returns newly built message.
        		if("replace".equalsIgnoreCase(operation))
        		{
        		    for (int i = 0; i < fieldListSize; i++)
        		    {
            			if((i + 1) == reqFieldIndex) 
            			{
            			    if(subFieldIndex > 0)
            			    {				
                				String fieldVal [] = segmentFieldList.get(i).toString().split("\\"+componentSeparator);								
                				int subfieldListSize = fieldVal.length;
                
                				for (int j = 0; j < subfieldListSize; j++)
                				{									
                				    if((j + 1) != subFieldIndex) 
                				    {
                					//	retVal += fieldVal[j];
                				    	retVal.append(fieldVal[j]);
                				    }
                				    else 
                				    {
                    					reqFieldVal = fieldVal[j];
                    				//	retVal += replaceWith;
                    					retVal.append(replaceWith);
                				    }
                				    if((j+1) != subfieldListSize) 
                				    {
                					//	retVal += componentSeparator;
                				    	retVal.append(componentSeparator);
                				    }
                				}
                			//	retVal += fieldSeparator;
                				retVal.append(fieldSeparator);
            			    }						
            			}
            			else 
            			{
            			    //	retVal += segmentFieldList.get(i) + fieldSeparator;
            			    retVal.append(segmentFieldList.get(i));
            			    retVal.append(fieldSeparator);
            			}
        		    }
        		 //	retVal += segmentEnd;
        		    retVal.append(segmentEnd);
        		}
        		else if("fetch".equalsIgnoreCase(operation))
        		{
        		    //	retVal = (String)segmentFieldList.get(reqFieldIndex - 1);
        		    retVal.delete(0, retVal.length());
        		    retVal.append((String)segmentFieldList.get(reqFieldIndex - 1));
        
        		    if(subFieldIndex > 0)
        		    {
            			String temp[] = retVal.toString().split("\\"+componentSeparator);
            			retVal.delete(0, retVal.length());
            			retVal.append(temp[subFieldIndex]);
        		    }
        		}
    	    }
    	    else if("replace".equalsIgnoreCase(operation)) 
    	    {
    		//	retVal += (tempSegment + segmentEnd);
        		retVal.append(tempSegment);
        		retVal.append(segmentEnd);
    	    }
    	}
    
    	if("replace".equalsIgnoreCase(operation)) 
    	{
    	    retVal.insert(0, strStartMessage).append(strEndMessage);			
    	    result[0] = retVal.toString(); // message after replacing the given field.
    	    result[1] = reqFieldVal;
    	}
    	else
    	{
    	    result[0] = retVal.toString();
    	}
    
    	return result;
    }
}
