/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"ATLEAST_ONE_RECORD_ENTERED","APP-MM0001 至少输入一个记录"},
		{"ITEM_ANALYSIS_UNIQUE","APP-MM0002 项目分�?代�?应该唯一"},
		{"ITEM_EITHER_PH_CSSD","APP-MM0003 项目必须是一个�?�房存货或消毒组件"},
		{"STORE_EITHER_EXT_DEPT","APP-MM0004 库房应该在外部或是一个部门"},
		{"INVALID_AM_TRADE_ID","APP-MM0005 无效的商�?编�?"},
		{"INVALID_MM_ITEM_CODE","APP-MM0006 无效的项目编�?"},
		{"DUPLICATE_ENTRIES_NOT_ALLOWED","APP-MM0007 �?�?许�?�?输入"},
		{"NOT_APPL_FOR_THIS_INSTAL","APP-MM0008 功能�?适用"},
		{"CONV_FACTOR_NOT_GREATER_THAN_ONE","APP-MM0009 转�?�因�?�?能大于1"}

	};
}			
