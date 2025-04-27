/*
	Developed by  : Ravindranath
	Created on    : 06/07/2010
*/
package HL7Engine.InboundProcess;

import java.util.HashMap;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

public class InboundUtil
{
	Common common = null;
	InboundServerDBInteraction serverDB;
	InboundServerParameters serverParameters;

	public InboundUtil(InboundServerParameters serverParameters)
	{
		common = Common.getInstance();
		this.serverParameters = serverParameters;
	}

	/**
	 * 
	 */
	public synchronized HashMap<String,String> getOrderEventType(HashMap<String,String> orderParamList)
	{
		try
		{
			String orderCategory = (String)orderParamList.get("order_category");
			if(orderCategory != null)
			{
				if(orderCategory.equalsIgnoreCase("PC")) 
				{
					orderParamList.put("eventType", "PTCR");
					orderParamList.put("moduleID", "CA");					
				}
				else if(orderCategory.equalsIgnoreCase("NC")) 
				{
					orderParamList.put("eventType", "NCIN");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("LB")) 
				{
					orderParamList.put("eventType", "LBIN");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("PH")) 
				{
					orderParamList.put("eventType", "PHRP");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("RD")) 
				{
					orderParamList.put("eventType", "RDIN");
					orderParamList.put("moduleID", "RD");					
				}
				else if(orderCategory.equalsIgnoreCase("RX")) 
				{
					orderParamList.put("eventType", "RXIN");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("TR")) 
				{
					orderParamList.put("eventType", "TRET");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("DS")) 
				{
					orderParamList.put("eventType", "DIET");
					orderParamList.put("moduleID", "OR");					
				}
				else if(orderCategory.equalsIgnoreCase("OT")) 
				{
					orderParamList.put("eventType", "SUNT");
					orderParamList.put("moduleID", "OT");					
				}
				else if(orderCategory.equalsIgnoreCase("MI")) 
				{
					orderParamList.put("eventType", "MISC");
					orderParamList.put("moduleID", "OR");					
				}
			}
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}	
		return orderParamList;
	}
}