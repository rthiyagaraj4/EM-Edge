/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents;
    }

	static final Object[][] contents = 
	{		
		{"RECORD_INSERTED",					 "APP-ST0128 �?ารทำงานสมบูรณ์ ประสบผลสำเร็จ"},
		{"RECORD_MODIFIED",					 "APP-ST0128 �?ารทำงานสมบูรณ์ ประสบผลสำเร็จ"}
		
	};
}		



