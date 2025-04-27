/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.response;

import java.util.List;

import eIPAD.selectorder.healthobject.*;
public class TickSheetResponse implements java.io.Serializable {
	private List<TickSheetHO> lstTickSheet;

	/**
	 * @return the lstTickSheet
	 */
	public List<TickSheetHO> getLstTickSheet() {
		return lstTickSheet;
	}

	/**
	 * @param lstTickSheet the lstTickSheet to set
	 */
	public void setLstTickSheet(List<TickSheetHO> lstTickSheet) {
		this.lstTickSheet = lstTickSheet;
	}

}
