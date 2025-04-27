/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.common.response;

/**
 * @author GaneshkumarC 
 *
 */
import java.util.*;

import eIPAD.chartsummary.common.healthobject.*;;
public class SfsResponse extends GenericResponse{
	private List<SfsHo> lstSfsHO;
    private boolean bDuplicateValues = false;
    private HashMap<String,String> oSfsMap;
	/**
	 * @return the lstSfsHO
	 */
	public List<SfsHo> getLstSfsHO() {
		return lstSfsHO;
	}

	/**
	 * @param lstSfsHO the lstSfsHO to set
	 */
	public void setLstSfsHO(List<SfsHo> lstSfsHO) {
		this.lstSfsHO = lstSfsHO;
	}

	/**
	 * @return the bDuplicateValues
	 */
	public boolean isbDuplicateValues() {
		return bDuplicateValues;
	}

	/**
	 * @param bDuplicateValues the bDuplicateValues to set
	 */
	public void setbDuplicateValues(boolean bDuplicateValues) {
		this.bDuplicateValues = bDuplicateValues;
	}

	/**
	 * @return the oSfsMap
	 */
	public HashMap<String, String> getoSfsMap() {
		return oSfsMap;
	}

	/**
	 * @param oSfsMap the oSfsMap to set
	 */
	public void setoSfsMap(HashMap<String, String> oSfsMap) {
		this.oSfsMap = oSfsMap;
	}
	
}
