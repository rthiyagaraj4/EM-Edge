package eXH;

import java.util.Map;

public interface ICommTransactions
{
	public void processRequest(Map<String, String> reqParams) throws Exception;
	public String sendRequest(Map<String, String> reqParams) throws Exception;
	public String buildRequestMsg(Map<String, String> reqParams);
	public String getRequestMsg(String requestFormat, Map<String,String> reqParams);
	public String receiveRequest(Map<String, String> reqParams) throws Exception;
}