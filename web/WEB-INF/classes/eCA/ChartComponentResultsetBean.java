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

public class ChartComponentResultsetBean implements  java.io.Serializable {
	HashMap recordsTable = null;
	//String chart_panel_discr_id = "";
	//String corr_values_from_table = "";
	String finalString;
	public String getFinalString()
	{
		return this.finalString;
	}
	public void setFinalString(String finalString)
	{
		this.finalString = finalString;
	}
	public void clearHashtableValue()
	{
		this.recordsTable = null;
	}
	public void addRecords(HashMap tableForRecs){
		recordsTable = tableForRecs;

		
	}
	public String fetchRecords(String chart_panel_discr_id){
		String recValues = "";
	
		recValues = ((String) recordsTable.get(chart_panel_discr_id)) == null ? "" : (String) recordsTable.get(chart_panel_discr_id);
		
		return recValues;
	}
	public HashMap getRecords(){
		return recordsTable;
	}
	public ArrayList fetchKeys(){
		ArrayList keysForValues = new ArrayList();
		int index =0;
		String tempString = "";
		
		Set keyList = (Set) this.recordsTable.keySet();
		Iterator keyIter = keyList.iterator();
		while(keyIter.hasNext()){
			tempString = (String) keyIter.next();
			keysForValues.add(index,(String) tempString);
			index++;
		}

		return keysForValues;
	}
}//end of class
