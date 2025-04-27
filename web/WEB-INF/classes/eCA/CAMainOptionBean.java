/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.io.*;
import java.util.*;

public class  CAMainOptionBean implements java.io.Serializable
{
	HashMap records = new HashMap();
	ArrayList keys1 = new ArrayList();
	ArrayList keys2 = new ArrayList();
	
	public void addRecords(String key, String value)
	{
		records.put(key,value);
	}

	public void addKeys1(String key)
	{
		keys1.add(key);
	}

	public void addKeys2(String key)
	{
		keys2.add(key);
	}

	public ArrayList retrieveRecords1()
	{
		return keys1;
	}

	public ArrayList retrieveRecords2()
	{
		return keys2;
	}

	public HashMap getHashValues()
	{
		return records;
	}
	
	public void clearBean()
	{
		records.clear();
		keys1.clear();
		keys2.clear();
	}
	
	public boolean chkContainsValue(String key)
	{
		if(records.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean chkContainsKey1(String key)
	{
		if(keys1.contains(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean chkContainsKey2(String key)
	{
		if(keys2.contains(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}//ens of class
