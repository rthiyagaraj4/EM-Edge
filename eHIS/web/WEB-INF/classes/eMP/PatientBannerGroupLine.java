/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;
import java.io.*;
import java.util.*;

public class  PatientBannerGroupLine implements java.io.Serializable
{
	ArrayList recordsLine1 = new ArrayList();
	ArrayList recordsLine2 = new ArrayList();

	public void addRecordstoLine1(String value)
	{
		recordsLine1.add(value);
	}

	public void addRecordstoLine2(String value)
	{
		recordsLine2.add(value);
	}

	public ArrayList returnList1()
	{
		return recordsLine1;
	}

	public ArrayList returnList2()
	{
		return recordsLine2;
	}

	public void clearBean()
	{
		recordsLine1 = new ArrayList();
		recordsLine2 = new ArrayList();
	}
}
