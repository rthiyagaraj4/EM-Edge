/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eAlert.src.dataccess;

import java.util.ArrayList;
import java.util.List;

import eAlert.src.databeans.AlertMaster;

/**
 * @author PrasannaR
 * 
 *
 */
public class AlertConfigContainer {

	private static AlertConfigContainer s_instance = null;
	
	private List<AlertMaster> alertMasterList = new ArrayList<AlertMaster>();
	
	private AlertConfigContainer(){
		initialize();
	}
	
	public static AlertConfigContainer getInstance()
	{
		if(s_instance == null)
		{
			s_instance = new AlertConfigContainer();
		}
		
		return s_instance;
	}
	
	private void initialize()
	{
		AlertConfigRetriever retriever = new AlertConfigRetriever();
		alertMasterList = retriever.getAlertMasterConfig();
	}
	
	
	public List<AlertMaster> getAlertConfig()
	{
		if(alertMasterList == null)
		{
			AlertConfigRetriever retriever = new AlertConfigRetriever();
			alertMasterList = retriever.getAlertMasterConfig();
		}
		
		return alertMasterList;
	}
	/**
	 * TODO refresh the alert code list for insert, update and delete.
	 */
}
