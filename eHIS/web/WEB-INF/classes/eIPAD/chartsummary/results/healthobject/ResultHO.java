/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.healthobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

/**
 * @author SaraswathiR 
 *
 */
public class ResultHO {

	private String categoryName;
	private String categoryCode;

	private ArrayList<ResultSubCategory> resSubCat = new ArrayList<ResultSubCategory>();
	
	public boolean equals(Object obj){
		if(obj instanceof ResultHO){
			ResultHO resHOItem = (ResultHO)obj;
			if(resHOItem.getCategoryCode().equals(this.getCategoryCode())){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}
	public ArrayList<Date> getAllDates(){
		ArrayList<Date> dates = new ArrayList<Date>();
		HashSet<Date> hs = new HashSet<Date>();
		ResultValue curRes;
		ArrayList<ResultGroupItem> resultGroupItemList;
		ArrayList<ResultValue> curResValues;
		for(int h=0; h<resSubCat.size();h++){
			resultGroupItemList = resSubCat.get(h).getResGrpItems();
			for(int i=0;i<resultGroupItemList.size();i++){
				curResValues = resultGroupItemList.get(i).getResValues();
				for(int k=0;k<curResValues.size();k++){
					curRes = curResValues.get(k);
					hs.add(curRes.getEventTimestamp());
				}
			}
		}
		dates.addAll(hs);
		Collections.sort(dates,Collections.reverseOrder());
		return dates;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return the resSubCat
	 */
	public ArrayList<ResultSubCategory> getResSubCat() {
		return resSubCat;
	}
	/**
	 * @param resSubCat the resSubCat to set
	 */
	public void setResSubCat(ArrayList<ResultSubCategory> resSubCat) {
		this.resSubCat = resSubCat;
	}

	
}
