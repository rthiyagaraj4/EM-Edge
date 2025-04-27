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

import eAlert.src.databeans.AlertFlagOptions;

/**
 * @author prasannar
 *
 */
public class AlertFlagOptionContainer {

private static AlertFlagOptionContainer s_instance = null;
	
	private List<AlertFlagOptions> alertFlatOptionList = new ArrayList<AlertFlagOptions>();
	
	private AlertFlagOptionContainer(){
		initialize();
	}
	
	public static AlertFlagOptionContainer getInstance()
	{
		if(s_instance == null)
		{
			s_instance = new AlertFlagOptionContainer();
		}
		
		return s_instance;
	}
	
	private void initialize()
	{
		/**
		 * TODO generate the Alert master list from the DB
		 */
		AlertFlagOptionRetriever retriever = new AlertFlagOptionRetriever();
		alertFlatOptionList = retriever.getAlertFlagOptions();
	}
	
	
	public List<AlertFlagOptions> getAlertFlagOptionsConfig()
	{
		if(alertFlatOptionList == null)
		{
			AlertFlagOptionRetriever retriever = new AlertFlagOptionRetriever();
			alertFlatOptionList = retriever.getAlertFlagOptions();
		}
		
		return alertFlatOptionList;
	}
	/**
	 * TODO refresh the alert code list for insert, update and delete.
	 */
	
}
