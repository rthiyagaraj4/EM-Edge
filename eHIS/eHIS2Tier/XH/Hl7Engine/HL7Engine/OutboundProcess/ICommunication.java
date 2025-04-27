package HL7Engine.OutboundProcess;

import java.util.Map;

public interface ICommunication
{
	void initFunc() throws Exception;
	String sendMessage(String message) throws Exception;
	void closeResources();
	String processCommunication(Map<String, String> params) throws Exception;
}
