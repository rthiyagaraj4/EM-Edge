package com.isoft.interfaceengine.Helper;

import HL7Engine.Common.*;
import HL7Engine.OutboundProcess.*;

public class CustomInterfaceHelper
{
	private static CustomInterfaceHelper interfaceHelper = null;
	private Common common;

	private CustomInterfaceHelper()
	{
		common = Common.getInstance();
	}

	public static CustomInterfaceHelper getInstance()
	{
		if(interfaceHelper == null)
		{
			interfaceHelper = new CustomInterfaceHelper();
		}

		return interfaceHelper;
	}

	public void closeInstance(OutboundClientDBInteraction clientDB)
	{
		clientDB.closeDBconn();
		common.logProcessStop(clientDB.clientParameters.strLogFile);
		System.exit(0);
	}
}