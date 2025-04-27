/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		
            {"XB1000","APP-XB1000 zh_Operation Failed..."},
			{"XB1001","APP-XB1001 zh_Operation Completed Successfully .... "}, 
    		{"XB1009","APP-XB1009 zh_To Date should be Greater than or equal to From Date"},
			{"XB1021","APP-XB1021 zh_Query caused no records to be retrieved"},		
			{"XB1056","APP-XB1056 zh_At least one item record has to be selected  "},
		    {"XB1057","APP-XB1057 zh_Gen UOM and Sale UOM cannot be blank for selected item records  "},
			{"XB1058","APP-XB1058 zh_A maXBmum of only one document can be selected..."},
			{"XB1059","APP-XB1059 zh_Invalid Date Format"},
			{"XB1060","APP-XB1060 zh_Select the Event Type "},
			{"XB1061","APP-XB1061 zh_$ records processed"}
		};			
}			
