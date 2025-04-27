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

public class Messages_th extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents;
    }

	static final Object[][] contents = 
	{		
			{"ATLEAST_ONE_RECORD_ENTERED"		,	"APP-MM0001 ต้องบันทึ�?อย่างน้อย 1 ข้อความ"},                   
			{"ITEM_ANALYSIS_UNIQUE"				,	"APP-MM0002 รหัสวัสดุเพื่อ�?ารวิเคราะห์ต้องไม่ซ้ำ"},                    
			{"ITEM_EITHER_PH_CSSD"				,	"APP-MM0003 วัสดุควรมาจา�? คลังยาหรือ CSSD component"}, 
			{"STORE_EITHER_EXT_DEPT"			,	"APP-MM0004 ควรเลือ�?คลังจา�? ภายนอ�?หรือ ภาควิชา"},          
			{"INVALID_AM_TRADE_ID"				,	"APP-MM0005 รหัส�?ารค้าไม่ถู�?ต้อง"},                                       
			{"INVALID_MM_ITEM_CODE"				,	"APP-MM0006 รหัสวัสดุไม่ถู�?ต้อง"},                                      
			{"DUPLICATE_ENTRIES_NOT_ALLOWED"	,	"APP-MM0007 บันทึ�?ซ้ำไม่ได้"},                      
			{"NOT_APPL_FOR_THIS_INSTAL"			,	"APP-MM0008 ไม่สามารถดำเนิน�?ารได้"}
	};
}		
