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

public class  SectionForNoteTypeRecBean implements java.io.Serializable
{
	HashMap recordmap = new HashMap();
	HashMap addFrameRecMap = new HashMap();
	ArrayList tempList = new ArrayList();
	
	public void addRecords(String recKey, String recVal)
	{
		recordmap.put(recKey,recVal);

	}

	public void addFrameRecords(String recKey, String recVal)
	{
		addFrameRecMap.put(recKey,recVal);

	}

	public ArrayList retrieveRecords()
	{
		ArrayList keys = new ArrayList();
		Set mapKeySet = (Set)recordmap.keySet();
		Iterator mapIter = mapKeySet.iterator();		
		while(mapIter.hasNext())
		{
			keys.add((String)mapIter.next());
		}

		return keys;
	}

	public ArrayList retrieveHashRecords()
	{
		ArrayList keys = new ArrayList();
		Set mapKeySet = (Set)addFrameRecMap.keySet();
		Iterator mapIter = mapKeySet.iterator();		
		while(mapIter.hasNext())
		{
			keys.add((String)mapIter.next());
		}

		return keys;
	}

	public void removeRec(String recKey)
	{
		recordmap.remove(recKey);
	}

	public void removeHashRecords(String recKey)
	{
		addFrameRecMap.remove(recKey);
	}

	public HashMap getHashValues()
	{
		return recordmap;
	}

	public HashMap getHashRecordValues()
	{
		return addFrameRecMap;
	}

	public void clearBean()
	{

		recordmap = null;
		addFrameRecMap = null;

	}

	public void addToList(int i, String Code)
	{
		tempList.add(i,Code);

	}

	public ArrayList retrieveArrayList()
	{
		return tempList;
	}

	public void removeElement(int i)
	{
		tempList.remove(i);
	}
	public void removeElement(String key)
	{
		if(recordmap.containsKey(key))
			recordmap.remove(key);
		//if(tempList.containsKey(key))
			//tempList.remove(key);

	}
	public int getIndexOfElement(String s)
	{
		for(int k=0; k<tempList.size();k++)
		{
			String str = (String) tempList.get(k);
			if(str.equals(s))
			{
				return k;
			}
		}
			return -1;
	}


	public boolean chkContainsKey(String key)
	{
		if(recordmap.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
