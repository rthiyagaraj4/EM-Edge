package com.isoft.interfaceengine.custominterface;

import HL7Engine.Common.*;
import HL7Engine.OutboundProcess.*;
import com.isoft.interfaceengine.Helper.CustomInterfaceHelper;

/**
 * Class handles all the functions related to webservice
 */

public class OutboundWebservice
{
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;
	Common common;
	IWebservice iWebservice;

	public OutboundWebservice()
	{
	}

	public OutboundWebservice(OutboundClientParameters clientParameters, OutboundClientDBInteraction clientDB)
	{		
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}

	public int executeService()
	{
		if(iWebservice == null) createServiceInstance();
		int result = iWebservice.processPendingItems();
		return result;
	}

	private void createServiceInstance()
	{
		boolean instanceCreated = false;
		String protocolID = clientParameters.strProtocolId;

		try
		{
			if("SRRSAPP1".equalsIgnoreCase(protocolID))
			{
				common.fileOutput(clientParameters.strLogFile, "(OutboundWebservice:createServiceInstance) protocolID:" + protocolID + "\n" ) ;
				iWebservice = new SAPService(clientParameters, clientDB);
				instanceCreated = true;
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundWebservice:createServiceInstance) Exception:" + exp.getMessage() + "\n" ) ;
			if(clientParameters.stackTrace) common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n"); 
		}		

		if(!instanceCreated || iWebservice == null)
		{
			common.fileOutput(clientParameters.strLogFile, 
				"(OutboundWebservice:createServiceInstance) !!! Service implementation not found for "+protocolID+" protocol !!!\n");
			CustomInterfaceHelper.getInstance().closeInstance(clientDB);
		}
	}	
}