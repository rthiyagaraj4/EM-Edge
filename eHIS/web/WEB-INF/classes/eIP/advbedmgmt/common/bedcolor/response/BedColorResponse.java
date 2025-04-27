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
package eIP.advbedmgmt.common.bedcolor.response;

import java.util.List;

import eIP.advbedmgmt.common.model.BedColor;
import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for getting bed color
 * @author GRamamoorthy
 *
 */
public class BedColorResponse extends BaseResponse {

	private List<BedColor> colorList = null;

	/**
	 * @return the colorList
	 */
	public List<BedColor> getColorList() {
		return colorList;
	}

	/**
	 * @param colorList the colorList to set
	 */
	public void setColorList(List<BedColor> colorList) {
		this.colorList = colorList;
	}
	
}
