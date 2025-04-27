package HL7Engine.OutboundProcess;

import HL7Engine.Common.Common;

public abstract class MailTransactions implements CommunicationInterface 
{	
	private OutboundClientDBInteraction clientDB;
	private OutboundClientParameters clientParameters;
	private Common common = null;
		
	public MailTransactions(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		super();
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}	
	
	protected String[] getMessageDetails(String message) throws Exception
	{
		String [] connDtls = clientDB.getSMTPDtls(message);
		return connDtls;
	}
}
