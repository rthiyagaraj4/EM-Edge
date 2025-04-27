/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import eBL.Common.*;

@SuppressWarnings({"rawtypes", "serial"})
public class DailyCashReportBean extends BlAdapter implements Serializable {	
	//public	HttpSession session ;
	//static String  changeBlgName="";
	public LinkedHashMap hasDailyCashSearchValues		= new LinkedHashMap();
	HashSet unionKeys;
	Random rand = new Random();
	String servGroupCode="";
	String longDesc="";
	String shortDesc = "";
	String usedForUndefinedItems =  "";
	String usedForExemptedReceipt = "";
	String index="";
	String ServItmInd="";
	String ServItmCode="";
	String ServItmDesc="";
	
	public String getServGroupCode() {
		return servGroupCode;
	}

	public void setServGroupCode(String servGroupCode) {
		this.servGroupCode = servGroupCode;
	}
	
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	public String getUsedForUndefinedItems() {
		return usedForUndefinedItems;
	}

	public void setUsedForUndefinedItems(String usedForUndefinedItems) {
		this.usedForUndefinedItems = usedForUndefinedItems;
	}
	
	public String getUsedForExemptedReceipt() {
		return usedForExemptedReceipt;
	}

	public void setUsedForExemptedReceipt(String usedForExemptedReceipt) {
		this.usedForExemptedReceipt = usedForExemptedReceipt;
	}

	public String getIndex(int j) {
		// TODO Auto-generated method stub
	//	int rand_int1 = rand.nextInt(1000); 
		int rand_int1 = j; 
		index=Integer.toString(rand_int1);
		//System.err.println("indexVal for Addrow "+index);
		return index;
	}	

	public void setIndex(String index) {
		this.index = index;
	}
	
	public String getIndexVal() {
		// TODO Auto-generated method stub
		int rand_int1 = rand.nextInt(1000); 
		index=Integer.toString(rand_int1);
		//System.err.println("indexVal for Addrow "+index);
		return index;
	}	

	public void setIndexVal(String index) {
		this.index = index;
	}

	public String getServItmInd() {
		return ServItmInd;
	}

	public void setServItmInd(String ServItmInd) {
		this.ServItmInd = ServItmInd;
	}
	public String getServItmCode() {
		return ServItmCode;
	}

	public void setServItmCode(String ServItmCode) {
		this.ServItmCode = ServItmCode;
	}
	public String getServItmDesc() {
		return ServItmDesc;
	}

	public void setServItmDesc(String ServItmDesc) {
		this.ServItmDesc = ServItmDesc;
	}
}