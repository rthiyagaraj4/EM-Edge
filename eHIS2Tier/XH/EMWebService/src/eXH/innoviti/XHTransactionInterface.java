package eXH.innoviti;

import java.text.ParseException;

public interface XHTransactionInterface  
{
	public String TransRequestMethod(String profileId, String applicationId, String actionKey);
	public String MessageBuildMethod(String applicationId, String actionKey);
	public String MessageLoadMethod(String actionKey, String message);
	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String message,String request);
	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID);
	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode);
	
	public String GetAuthToken(String applicationId,String actionKey) throws ParseException;
	public String InteractiveTableInsertionMethod(String applicationId,String actionKey,String requestMsg,String transValue);
	public String InteractiveTableUpdationMethod(String responseMsg,String responseStr,String transValue);
	public String CloudMessageBuildMethod(String invoiceNo, String actionKey,String request);
	public String CloudMessageLoadMethod(String actionKey, String message,String request) throws ParseException;
	
}