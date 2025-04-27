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

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"XI1001","APP-XI0001 �?作�?功完�?"},
		{"XI1009","APP-XI0009 终止日期应该大于等于开始日期"},
		{"XI1021","APP-XI0021 查询导致无引录被检索出"},
		{"XI1000","APP-XI1000 �?作失败….."},

	};
}			
