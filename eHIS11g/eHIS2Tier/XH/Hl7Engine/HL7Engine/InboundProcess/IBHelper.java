/*
	Developed by  : Ravindranath
	Created on    : 06/07/2010
*/
package HL7Engine.InboundProcess;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

public class IBHelper
{
	public static IBHelper ibHelper = null;
	Common common = null;
	InboundServerDBInteraction serverDB;
	InboundServerParameters serverParameters;

	private IBHelper(InboundServerDBInteraction serverDB)
	{
		common = Common.getInstance();
		this.serverDB = serverDB;
		serverParameters = serverDB.serverParameters;
	}

	public static synchronized IBHelper getInstance(InboundServerDBInteraction serverDB)
	{
		if(ibHelper == null)
		{
			ibHelper = new IBHelper(serverDB);
		}

		return ibHelper;
	}

	public boolean checkExeDBConnection()
	{		
		int currentCount = 0;
		boolean isDBConExists;
		
		while(true)
		{
			try
			{
				if(serverParameters.totExternalConnRetries == 0) {
					common.fileOutput(serverParameters.strLogFile, "(IBHelper:checkExeDBConnection) Connecting to External Database...\n" ) ;
				}
				else {
					common.fileOutput(serverParameters.strLogFile, "(IBHelper:checkExeDBConnection) Retrying external database connection...\n" ) ;
				}

				isDBConExists = serverDB.getExternalDBConnection();

				if(isDBConExists) {
					common.fileOutput(serverParameters.strLogFile, "(IBHelper:checkExeDBConnection) External database connection successfull...\n" ) ;
					break;
				}
				else {
					updateRetryAttempts(++currentCount);
					common.fileOutput(serverParameters.strLogFile, "(IBHelper:checkExeDBConnection) External Database connection failed !!!\n" ) ;
				}
			}
			catch (Exception exp)
			{
				common.fileOutput(serverParameters.strLogFile, "(IBHelper:checkExeDBConnection) "+exp.getMessage()+"\n" ) ;
				common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
			}
		}

		return isDBConExists;
	}

	private void updateRetryAttempts(int currentRetryCount)
	{
		try
		{
			serverParameters.totExternalConnRetries++;
			serverDB.updateCommRetries(serverParameters.totExternalConnRetries);			

			if(currentRetryCount >= serverParameters.intMaxRetries)
			{
				common.fileOutput(serverParameters.strLogFile, "(InboundServerApplication:updateRetryAttempts) Max Retires Reached ["+currentRetryCount+"]\n" );
				serverParameters.isMaxRetriesReached = true;
			}			

			Thread.sleep(serverParameters.intRetryInterval);
		}
		catch(Exception exp)
		{				
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}
}