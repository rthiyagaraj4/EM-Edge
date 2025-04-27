package eXH.paytm;

public interface XHTransactionInterface  
{
	public String TransRequestMethod(String profileId, String applicationId, String actionKey);
	public String MessageBuildMethod(String applicationId, String actionKey);
	public String MessageLoadMethod(String actionKey, String message);
	public String TransCommunicationMethod(String protocolLinkID, String actionKey, String checkSum, String message);

	public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID);
	public String FetchStdCntrlSegMethod(String segmentID, String elementId, String standardCode);

}