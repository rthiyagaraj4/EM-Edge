package com.isoft.interfaceengine.custominterface;

import java.util.HashMap;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.text.ParseException;

import HL7Engine.Common.*;
import HL7Engine.OutboundProcess.*;
import com.isoft.interfaceengine.dao.*;
import com.isoft.interfaceengine.Helper.*;
import th.ac.mahidol.si.zehis.alleh.all01.DTALL01EHISRESULTRES.Response.ZRECORD.Items;
import th.ac.mahidol.si.zehis.alleh.all01.DTALL01EHISRESULT;
import th.ac.mahidol.si.zehis.alleh.all01.MTALL01EHISRESULTDocument;
import th.ac.mahidol.si.zehis.alleh.all01.MTALL01EHISRESULTRESDocument;
import com.isoft.sapinv.client.MI_ALL01_EHIS_RESULTServiceStub;

/**
 * Class contains functionality related to the SAP webserives for Siriraj
 * 
 * Author  : Ravindranath
 * Version : 01/02/2011
 */

public class SAPService implements IWebservice
{
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;
	Common common;
	private ServiceDAO serviceDAO;

	MTALL01EHISRESULTDocument serviceRequest;
	DTALL01EHISRESULT dtall01EHISResult;
	MI_ALL01_EHIS_RESULTServiceStub stub;
	
	boolean isCommStatusUpdated;

	public SAPService(OutboundClientParameters clientParameters, OutboundClientDBInteraction clientDB)
	{
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
		init();
	}

	public int processPendingItems()
	{
		int retVal = 0;
		try
		{
			serviceRequest		= MTALL01EHISRESULTDocument.Factory.newInstance();
			dtall01EHISResult	= serviceRequest.addNewMTALL01EHISRESULT();
			retVal = retriveData();
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(SAPService:processPendingItems) Exception:"+exp+"\n ");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		return retVal;
	}

	public int retriveData() throws Exception
	{
		HashMap dataMap = (HashMap) serviceDAO.getSAPServiceData();
		int i = 1;

		if(dataMap != null && dataMap.size() > 0) 
		{
			buildRequest(dataMap);
			callService(dataMap);
		}
		else
		{
			i = 0;
			common.fileOutput(clientParameters.strLogFile, "(SAPService:processPendingItems) No records to process...\n");			
		}
		return i;
	}

	public void buildRequest(Object tempdataMap)
	{
		try
		{
			HashMap dataMap = (HashMap)tempdataMap;
			DTALL01EHISRESULT.Request requestObj = dtall01EHISResult.addNewRequest();		
			DTALL01EHISRESULT.Request.Item item = null;
			
			Calendar createdDate = null;
			Calendar createdTime = null;

			Collection dataCol = dataMap.values();

			Iterator iterator = dataCol.iterator();

			while(iterator.hasNext())
			{
				item = requestObj.addNewItem();

				HashMap tempMap = (HashMap)iterator.next();

				try
				{
					createdDate = CommonUtil.convertStr2Calendar((String)tempMap.get("CREATEDDATE"), "yyyy-MM-dd");
					createdTime = CommonUtil.convertStr2Calendar((String)tempMap.get("CREATEDTIME"), "hh:mm:ss");
				}
				catch (ParseException parseException)
				{
					common.fileOutput(clientParameters.strLogFile, 
						"(SAPService:buildRequest) Unable to parse date/time "
						+(String)tempMap.get("CREATEDDATE")+"/ "+(String)tempMap.get("CREATEDTIME")+"\n ");					
				}

				item.setZTRNID((String)tempMap.get("TRNID"));
				item.setZCREATEDBY((String)tempMap.get("CREATEDBY"));
				item.setZCREATEDDATE(createdDate);
				item.setZCREATEDTIME(createdTime);
				item.setZLOGCHG((String)tempMap.get("LOGCHG"));
				item.setZTRNREMARK((String)tempMap.get("TRNREMARK"));
				item.setZTRNSTATUSNEW((String)tempMap.get("TRNSTATUSNEW"));
				item.setZTRNSTATUSOLD((String)tempMap.get("TRNSTATUSOLD"));
				item.setZUPDATEDSTATUS((String)tempMap.get("UPDATEDSTATUS"));
				item.setZUPDATEDSTATUSDESC((String)tempMap.get("UPDATEDSTATUSDESC"));
			}					
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(SAPService:buildRequest) Exception:"+exp+"\n ");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	public void callService(Object dataMap) throws Exception
	{
		try
		{
			if(clientParameters.debugYN) common.fileOutput(clientParameters.strLogFile, "(SAPService:buildRequest) XML Req:\n"+serviceRequest.xmlText()+"\n");
			MTALL01EHISRESULTRESDocument serviceResponse = stub.mI_ALL01_EHIS_RESULT(serviceRequest);
			Items [] items = serviceResponse.getMTALL01EHISRESULTRES().getResponse().getZRECORD().getItemsArray();
			if(clientParameters.debugYN) common.fileOutput(clientParameters.strLogFile, "(SAPService:buildRequest) XML Res:\n"+serviceResponse.getMTALL01EHISRESULTRES().getResponse().xmlText()+"\n");
			if(!isCommStatusUpdated) 
			{
				isCommStatusUpdated = true;
				clientDB.updateProcessComStatus("Y");
			}

			serviceDAO.updateSAPItemsStatus((HashMap)dataMap, items);
		}
		catch (org.apache.axis2.AxisFault exp)
		{
			clientParameters.isExtConnDown = true;
			common.fileOutput(clientParameters.strLogFile, "(SAPService:buildRequest) Exception:"+exp+"\n");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}		
	}

	private void init()
	{
		if(serviceDAO == null) serviceDAO = new ServiceDAO(clientParameters, clientDB); // data access object creation

		try
		{
			// Initialization objects for webservice call
			stub = new MI_ALL01_EHIS_RESULTServiceStub(clientParameters.webserviceURL);

			clientParameters.isPurgeEnabled = serviceDAO.getPurgeStatus();
//			stub.sapUserID = "zadam001";
//			stub.sapPassword = "ITONEXI";
			stub.sapUserID = clientParameters.webserviceUID;
			stub.sapPassword = clientParameters.webservicePwd;
		}
		catch(Error error)
		{
			common.fileOutput(clientParameters.strLogFile, 
				"(SAPService:init) !!! Service API not found for SAP !!!\n");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(error) + "\n");
			CustomInterfaceHelper.getInstance().closeInstance(clientDB);
		}
		catch (Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(SAPService:init) Exception:"+exp+"\n");
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}		
	}

	public void updateResponse()
	{
	}
}
