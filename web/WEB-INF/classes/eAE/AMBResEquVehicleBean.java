/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;
import java.io.*;
import java.util.*;

public class  AMBResEquVehicleBean implements java.io.Serializable
{
	HashMap recordmap = new HashMap();
	HashMap addFrameRecMap = new HashMap();
	ArrayList tempList = new ArrayList();
	
	public void addRecords(String recKey, String recVal)
	{
		recordmap.put(recKey,recVal);
		//System.out.println("recordmap from map ===== >"+recordmap);
		//System.out.println("addFrameRecMap from addRecords ===== >"+addFrameRecMap);
	}

	public void addFrameRecords(String recKey, String recVal)
	{
		addFrameRecMap.put(recKey,recVal);
		//System.out.println("addFrameRecMap from map ===== >"+addFrameRecMap);
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
		//System.out.println("keys from the bean --- >"+keys);
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
		//System.out.println("keys from the bean --- >"+keys);
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
		//System.out.println("Clear Method From Bean : ");
		recordmap = null;
		addFrameRecMap = null;
		//System.out.println("recordmap = "+recordmap);
		//System.out.println("addFrameRecMap = "+addFrameRecMap);
	}

	public void addToList(int i, String Code)
	{
		tempList.add(i,Code);
		//System.out.println("tempList from the bean --- >"+tempList+"iIndex ---> "+i);
	}

	public ArrayList retrieveArrayList()
	{
		return tempList;
	}

	public void removeElement(int i)
	{
		tempList.remove(i);
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
