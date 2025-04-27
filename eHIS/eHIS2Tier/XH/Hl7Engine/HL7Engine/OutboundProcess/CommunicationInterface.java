package HL7Engine.OutboundProcess;

public interface CommunicationInterface
{
	void initFunc() throws Exception;
	void sendMessage(String message) throws Exception;
	void closeResources();
}
