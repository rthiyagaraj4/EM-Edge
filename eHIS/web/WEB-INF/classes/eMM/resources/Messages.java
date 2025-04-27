/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
24/05/2017				IN063603			    Badmavathi B												 GHL-CRF-0456
05/07/2017				IN060124				SooryaPrakash M												GHL_CRF-0405
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eMM.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = 
	{		
			{"ATLEAST_ONE_RECORD_ENTERED",		"APP-MM0001 Atleast one record should be entered"},                   
			{"ITEM_ANALYSIS_UNIQUE",			"APP-MM0002 Item Analysis Code should be unique"},                    
			{"ITEM_EITHER_PH_CSSD",				"APP-MM0003 Item Should be either Pharmacy Stock or CSSD Component"}, 
			{"STORE_EITHER_EXT_DEPT",			"APP-MM0004 Store Should be either External or Department"},          
			{"INVALID_AM_TRADE_ID",				"APP-MM0005 Invalid Trade ID"},                                       
			{"INVALID_MM_ITEM_CODE",			"APP-MM0006 Invalid Item Code"},                                      
			{"DUPLICATE_ENTRIES_NOT_ALLOWED",	"APP-MM0007 Duplicate entries are not allowed"},                      
			{"NOT_APPL_FOR_THIS_INSTAL",		"APP-MM0008 This function is not applicable"},
			{"CONV_FACTOR_NOT_GREATER_THAN_ONE","APP-MM0009 Conversion Factor Cannot Be Greater Than 1"},
			{"DIRECT_SALES_NOT_ALLOWED","APP-MM0010 Cannot uncheck. Item is marked for 'Sale/Patient Issues' for one or more stores."},//Added for GHL-CRF-0456
			{"STOCK_IN_HAND","APP-MM0011 Stock is available for this item. Transactions on Item Stock can not be done if the item is disabled. "}, //Added for GHL-CRF-0405
			{"PARAMETER_SETUP","APP-MM0013 Please setup the ST Entity Parameter and ST Facility Parameter to proceed. "}, //Added for PMG2017-SS-CRF-0002
			{"ALTERNATE_MISSING","APP-MM0014 Alternate Value cannot be blank."}  //Added for MMS-DM-CRF-0209.2
	};
}		
