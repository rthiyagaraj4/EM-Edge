/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.response;


import eIPAD.selectorder.healthobject.TickSheetItemHO;
import java.util.List;
public class TickSheetItemRes implements java.io.Serializable {
	private List<TickSheetItemHO> lstTickSheetItem;

	/**
	 * @return the lstTickSheetItem
	 */
	public List<TickSheetItemHO> getLstTickSheetItem() {
		return lstTickSheetItem;
	}

	/**
	 * @param lstTickSheetItem the lstTickSheetItem to set
	 */
	public void setLstTickSheetItem(List<TickSheetItemHO> lstTickSheetItem) {
		this.lstTickSheetItem = lstTickSheetItem;
	}

}
