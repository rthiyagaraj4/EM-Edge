/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.autocomplete.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author saisirishag SortUtility is the utility class which is used to display
 *         the sorted list
 */
public class SortUtility {

	/**
	 * sortMapByValue is one of overloaded static method which serves the sorting mechanism
	 * @param inMap
	 * @param comparator
	 * @return
	 */
	public static LinkedHashMap sortMapByValue(Map inMap, Comparator comparator) {
		return sortMapByValue(inMap, comparator, null);
	}
/**
 * sortMapByValue is one of overloaded static method which serves the sorting mechanism
 * @param inMap
 * @param ascendingOrder
 * @return
 */
	public static LinkedHashMap sortMapByValue(Map inMap, boolean ascendingOrder) {
		return sortMapByValue(inMap, null, new Boolean(ascendingOrder));
	}
/**
 * sortMapByValue is one of overloaded static method which serves the sorting mechanism
 * @param inMap
 * @return
 */
	public static LinkedHashMap sortMapByValue(Map inMap) {
		return sortMapByValue(inMap, null, null);
	}
/**
 * sortMapByValue method holds the implementation for sorting.
 * @param inMap
 * @param comparator
 * @param ascendingOrder
 * @return
 */
	private static LinkedHashMap sortMapByValue(Map inMap,
			Comparator comparator, Boolean ascendingOrder) {
		int iSize = inMap.size();

		// Create new LinkedHashMap that need to be returned
		LinkedHashMap sortedMap = new LinkedHashMap(iSize);

		Collection values = inMap.values();
		ArrayList valueList = new ArrayList(values); // To get List of all
														// values in passed Map
		HashSet distinctValues = new HashSet(values); // To know the distinct
														// values in passed Map

		// Do handing for null values. remove them from the list that will be
		// used for sorting
		int iNullValueCount = 0; // Total number of null values present in
									// passed Map
		if (distinctValues.contains(null)) {
			distinctValues.remove(null);
			for (int i = 0; i < valueList.size(); i++) {
				if (valueList.get(i) == null) {
					valueList.remove(i);
					iNullValueCount++;
					i--;
					continue;
				}
			}
		}

		// Sort the values of the passed Map
		if (ascendingOrder == null) {
			// If Boolean ascendingOrder is null, use passed comparator for
			// order of sorting values
			Collections.sort(valueList, comparator);
		} else if (ascendingOrder.booleanValue()) {
			// If Boolean ascendingOrder is not null and is true, sort values in
			// ascending order
			Collections.sort(valueList);
		} else {
			// If Boolean ascendingOrder is not null and is false, sort values
			// in descending order
			Collections.sort(valueList);
			Collections.reverse(valueList);
		}

		// Check if there are multiple same values exist in passed Map (not
		// considering null values)
		boolean bAllDistinct = true;
		if (iSize != (distinctValues.size() + iNullValueCount))
			bAllDistinct = false;

		Object key = null, value = null, sortedValue;
		Set keySet = null;
		Iterator itKeyList = null;
		HashMap hmTmpMap = new HashMap(iSize);
		HashMap hmNullValueMap = new HashMap();

		if (bAllDistinct) {
			// There are no multiple same values in the passed map (without
			// consedring null)
			keySet = inMap.keySet();
			itKeyList = keySet.iterator();
			while (itKeyList.hasNext()) {
				key = itKeyList.next();
				value = inMap.get(key);

				if (value != null)
					hmTmpMap.put(value, key); // Prepare new temp HashMap with
												// value=key combination
				else
					hmNullValueMap.put(key, value); // Keep all null values in a
													// new temp Map
			}

			if (ascendingOrder != null && !ascendingOrder.booleanValue()) {
				// As it is descending order, Add Null Values in first place of
				// the LinkedHasMap
				sortedMap.putAll(hmNullValueMap);
			}

			// Put all not null values in returning LinkedHashMap
			for (int i = 0; i < valueList.size(); i++) {
				value = valueList.get(i);
				key = hmTmpMap.get(value);

				sortedMap.put(key, value);
			}

			if (ascendingOrder == null || ascendingOrder.booleanValue()) {
				// Add Null Values in the last of the LinkedHasMap
				sortedMap.putAll(hmNullValueMap);
			}
		} else {
			// There are some multiple values (with out considering null)
			keySet = inMap.keySet();
			itKeyList = keySet.iterator();
			while (itKeyList.hasNext()) {
				key = itKeyList.next();
				value = inMap.get(key);

				if (value != null)
					hmTmpMap.put(key, value); // Prepare new temp HashMap with
												// key=value combination
				else
					hmNullValueMap.put(key, value); // Keep all null values in a
													// new temp Map
			}

			if (ascendingOrder != null && !ascendingOrder.booleanValue()) {
				
				sortedMap.putAll(hmNullValueMap);
			}

			
			for (int i = 0; i < valueList.size(); i++) {
				sortedValue = valueList.get(i);

				// Search this value in temp HashMap and if found remove it
				keySet = hmTmpMap.keySet();
				itKeyList = keySet.iterator();
				while (itKeyList.hasNext()) {
					key = itKeyList.next();
					value = hmTmpMap.get(key);
					if (value.equals(sortedValue)) {
						sortedMap.put(key, value);
						hmTmpMap.remove(key);
						break;
					}
				}
			}

			if (ascendingOrder == null || ascendingOrder.booleanValue()) {
				// Add Null Values in the last of the LinkedHasMap
				sortedMap.putAll(hmNullValueMap);
			}
		}

		return sortedMap;
	}
}
