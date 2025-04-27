/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRD.resources;
import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
     }
static final Object[][] contents = {
	{"RD0001","APP-RD0001 Report Text updated Successfully.. "},
	{"RD0002","APP-RD0002 Please select the record before proceeding "},
	{"RD0003","APP-RD0003 Operation Completed Successfully ...."},
	{"RD0004","APP-RD0004 Please select Type before proceeding.."}
};
}