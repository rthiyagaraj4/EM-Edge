package HL7Engine.OutboundProcess;

import java.util.Map;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;
import HL7Engine.Common.Common;
import HL7Engine.exceptions.FatalException;
import HL7Engine.exceptions.InterfaceException;

public class LotusNotesTrans extends MailTransactions implements ICommunication
{
	private Database database;
	private OutboundClientDBInteraction clientDB;
	private OutboundClientParameters clientParameters;
	private Common common = null;

	public LotusNotesTrans(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		super(clientDB, clientParameters);
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}

	public void initFunc() throws Exception 
	{
		try
		{
			NotesThread.sinitThread();
			Session session = NotesFactory.createSession((String) null, (String) null, clientParameters.odbcDBPwd);
			database = session.getDatabase("", clientParameters.url);
		}
		catch(NotesException exception)
		{
			throw new FatalException(exception.getMessage());
		}
	}

	public String sendMessage(String message) throws Exception
	{
		try
		{
			String [] mailDtls = getMessageDetails(message);
			if(clientParameters.logToFile) common.fileOutput(clientParameters.strLogFile, "(LotusNotesTrans:sendMessage) Recipient Mail ID : " + mailDtls[4] + "\n" );
			Document d = database.createDocument();
			d.setSaveMessageOnSend(true);
			d.appendItemValue("Subject", mailDtls[1]);
			d.appendItemValue("Body", mailDtls[0]);
			d.appendItemValue("SendTo", mailDtls[4]);
			d.appendItemValue("CopyTo", mailDtls[5]);
			d.appendItemValue("BlindCopyTo", mailDtls[6]);
			d.send(mailDtls[4]);
		}
		catch(Exception exp)
		{
			Thread.sleep(clientParameters.intRetryInterval * 1000);
			throw new InterfaceException(exp.getMessage());
		}
		return "S";
	}

	public void closeResources() 
	{
		NotesThread.stermThread();
	}

	public String processCommunication(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
