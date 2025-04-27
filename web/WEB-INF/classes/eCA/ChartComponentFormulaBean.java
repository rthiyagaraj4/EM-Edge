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

public class ChartComponentFormulaBean  implements java.io.Serializable {
	 HashMap formula = null;
	 HashMap summary = null;
	 String retVal;
	
	public void clearHashtableValue()
	{
		this.formula = null;
	}
	
	public void addFormula(HashMap hashFormula){
		this.formula = hashFormula;

		//hashFormula.clear();
	}
	public HashMap returnFormulaTab()
	{
		return this.formula;
	}
	public String fetchFormula(String panel_discr_id){
		String formul = "";
		if(this.formula != null )
		{
			formul = ((String) this.formula.get(panel_discr_id))==null ? "" :(String) this.formula.get(panel_discr_id)	;
		}
		return formul;
	}
	public ArrayList fetchKeys(){
		ArrayList keysForValues =new ArrayList();
		int index =0;
		String tempString = "";
		
		Set keyList = (Set) this.formula.keySet();
		Iterator keyIter = keyList.iterator();
		while(keyIter.hasNext()){
			tempString = (String) keyIter.next();
			keysForValues.add(index,(String)tempString);
			index++;
		}
		return keysForValues;
	}

	public void clearFormula(){
		formula = new HashMap();
	}

	public int getSize(){
		
		return formula.size();
	}

	public void setretValString(String retVal){
		this.retVal = retVal;
	}

	public String getretValString(){
		return this.retVal;
	}

	public HashMap getSummary(){

		return this.summary;
	}

	public void setSummary(HashMap summary){
		this.summary = summary;

	}

	public void clearSummary(){
		this.summary = null;
	}
};//end of class

