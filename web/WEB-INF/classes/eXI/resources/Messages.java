/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		
            {"XI1000","APP-XI1000 Operation Failed..."},
			{"XI1001","APP-XI1001 Operation Completed Successfully .... "}, 
    		{"XI1009","APP-XI1009 To Date should be Greater than or equal to From Date"},
			{"XI1021","APP-XI1021 Query caused no records to be retrieved"},		
			{"XI1056","APP-XI1056 At least one item record has to be selected  "},
		    {"XI1057","APP-XI1057 Gen UOM and Sale UOM cannot be blank for selected item records  "},
			{"XI1058","APP-XI1058 A maximum of only one document can be selected..."},
			{"XI1059","APP-XI1059 Invalid Date Format"}				
		};			
}			
