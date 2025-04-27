/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents =
		{
			{"RECORD_SELECT","th Select Any record then Press Request or Print"},	
			{"COMPLETE","th Successfully Completed"},	
			{"VOLUME_NULL","th th BT0120 Transfused volume should not be Null"},	
			{"VOLUME_LT","th th BT0121 Transfused volume should  be less than Current Volume"},				
			{"DATE_ST_GT_ISSUE","th th BT0114 Transfuse start date should be greater then ISSUED Date"},		
			{"DATE_EN_LT_RESER","th BT0119 Transfuse end date should be less then RESERVED Date"},		
			{"DATE_EN_LT_SYS","th BT0117 Transfuse end date should not be greater then SYSTEM Date"},
			{"DATE_EN_GT_TRANS","th BT0118 Transfuse end date should be greater then  Transfuse start date"},	
			{"DATE_EN_LT_RESER","th BT0119 Transfuse end date should be less then RESERVED Date"},	


			{"TXT_PRACT_NULL","th BT0141 Transfuse Practitioner Name should be Null"},
			{"PRACT_ID_CURRENT_USER","th BT0122 Error in Practitioner Selection"},	
			{"REACTION_CODE_NULL","th BT0131 Reaction code should not be Null"},	
			{"DATE_ST_NULL","th BT0113 Transfuse start date can not be Null"},	
			{"DATE_EN_NULL","th BT0116 Transfuse End date can not be Null"},	
			{"PARTIAL_TRANS_CODE","th BT0132 Partial Transfusion Reason  should not be Null"},	
			{"PRACT_ID_CURRENT_USER","th BT0122 Error in Practitioner Selection"},	
			{"PARTIAL_TRANS_CODE","th BT0132 Partial Transfusion Reason  should not be Null"},	
			{"DATE_ST_LT_RESER","th BT0115 Transfuse start date should be less then RESERVED Date"},		
			{"DATE_EN_GT_TRANS","th BT0118 Transfuse end date should be greater then  Transfuse start date"},		
			{"DATE_EN_LT_RESER","th BT0119 Transfuse end date should be less then RESERVED Date"},		
			{"TRANS_INVESTIGATE","th Please order transfusion reaction investigation"}	
			};			
}		
