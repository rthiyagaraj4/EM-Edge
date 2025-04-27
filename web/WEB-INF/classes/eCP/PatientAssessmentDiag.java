/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.

package eCP;

import java.util.*;

public class PatientAssessmentDiag implements java.io.Serializable  
{
	TreeMap diagRecs = new TreeMap();
	ArrayList list = null;
	
	public PatientAssessmentDiag()
	{
		list = new ArrayList();
	}

	public int getSize()
	{
		int i = 0;
		if(diagRecs != null)
			i = diagRecs.size();

		return i;
	}

	public void addDiagnosis(String key, String value) throws Exception
	{
		diagRecs.put(key,value);
	}

	public String getDiagRecords(String keyValue)
	{
		String diagDesc = (String)diagRecs.get(keyValue);
		return diagDesc;
	}

	public ArrayList getKeySet()
	{
		String keys = "";
		Set mapkeySet = (Set) diagRecs.keySet();
		Iterator mapIterator = mapkeySet.iterator();
		list.clear();
		while(mapIterator.hasNext())
		{	
			keys = (String) mapIterator.next();
			list.add(keys);		
		}

	
		return list;		
	}

	public void clearDiagBean()
	{
		diagRecs.clear();
		list.clear();
	}

	public ArrayList getMapValues()
	{
		String values = "";
		Collection mapValues = (Collection) diagRecs.values();
		Iterator valueIterator = mapValues.iterator();
		list.clear();
		while(valueIterator.hasNext())
		{
			values = (String) valueIterator.next();
			list.add(values);		
		}
		return list;
	}

	public boolean checkForDups(String mapValue)
	{
		if(diagRecs.containsValue(mapValue))
			return true;
		else
			return false;
	}
}


