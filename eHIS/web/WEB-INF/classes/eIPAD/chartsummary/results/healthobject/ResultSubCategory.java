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
public class ResultSubCategory {

	private String subCategoryName;
	private String subCategoryCode;
	private ArrayList<ResultGroupItem> resGrpItems = new ArrayList<ResultGroupItem>();
	
	public boolean equals(Object obj){
		if(obj instanceof ResultSubCategory){
			ResultSubCategory resItem = (ResultSubCategory)obj;
			if(resItem.getSubCategoryCode().equals(this.getSubCategoryCode())){
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
	
	/**
	 * @param Method to get all dates for display in tabular format
	 */
	public ArrayList<Date> getAllDates(){
		ArrayList<Date> dates = new ArrayList<Date>();
		HashSet<Date> hs = new HashSet<Date>();
		ResultGroupItem curResultGroupItem;
		ResultValue curRes;
		ArrayList<ResultValue> curResValues;
		for(int i=0;i<resGrpItems.size();i++){
			curResultGroupItem = resGrpItems.get(i);
			curResValues = curResultGroupItem.getResValues();
			for(int k=0;k<curResValues.size();k++){
				curRes = curResValues.get(k);
				hs.add(curRes.getEventTimestamp());
			}
		}
		dates.addAll(hs);
		Collections.sort(dates,Collections.reverseOrder());
		return dates;
	}
	public int getResGroupItemIndex(String groupCode, String resCode){
		//constructing a ResultGroupItem with groupCode & resCode for comparison
		ResultGroupItem cResGrpItem = new ResultGroupItem();
		cResGrpItem.setResultGroupCode(groupCode);
		cResGrpItem.setResultCode(resCode);
		
		//if groupCode is not null 
		if(groupCode!=null && !groupCode.equals("")){
			//get the first and last index of the objects with the same group code from the resGrpItems array list
			int gStart = resGrpItems.indexOf(cResGrpItem);
			int gEnd = resGrpItems.lastIndexOf(cResGrpItem);
			//if indexOf returns negative then the ResultGroupItem is not created already
			if(gStart<0){
				return -1;
			}
			else{
				//All the group items with a single code will be grouped together and available as a block in the resGrpItems array list
				//Hence iterating between the first and last index will suffice to see if the ResultGroupItem is already created
				for(int i=gStart;i<=gEnd;i++){
					ResultGroupItem curResGrpItem = resGrpItems.get(i);
					String curGroupCode = curResGrpItem.getResultGroupCode();
					String curResCod = curResGrpItem.getResultCode();
					//if a ResultGroupItem object with matching groupCode and resCode is found then return its index
					if(curGroupCode.equals(groupCode) && curResCod.equals(resCode)){
						return i;
					}
				}
				//if not found then return negative
				return -1;
			}
		}
		else if(groupCode==null || groupCode.equals("")){
			//in this case we have to iterate all the items of the resGrpItems arraylist
			for(int i=0;i<resGrpItems.size();i++){
				ResultGroupItem curResGrpItem = resGrpItems.get(i);
				String curResCod = curResGrpItem.getResultCode();
				if((groupCode==null || groupCode.equals("")) && curResCod.equals(resCode)){
					return i;
				}
			}
			return -1;
		}
		return -1;
	}
	
	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}
	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	/**
	 * @return the subCategoryCode
	 */
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	/**
	 * @param subCategoryCode the subCategoryCode to set
	 */
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	/**
	 * @return the resGrpItems
	 */
	public ArrayList<ResultGroupItem> getResGrpItems() {
		return resGrpItems;
	}

	/**
	 * @param resGrpItems the resGrpItems to set
	 */
	public void setResGrpItems(ArrayList<ResultGroupItem> resGrpItems) {
		this.resGrpItems = resGrpItems;
	}

}
