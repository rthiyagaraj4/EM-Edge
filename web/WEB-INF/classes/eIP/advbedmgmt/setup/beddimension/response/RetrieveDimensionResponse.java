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
package eIP.advbedmgmt.setup.beddimension.response;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class storing the bed dimension
 * @author GRamamoorthy
 *
 */
public class RetrieveDimensionResponse extends BaseResponse {

	/**
	 * data members
	 */
	private int minWidth = 0;
	
	private int minHeight = 0;
	
	private int maxWidth = 0;
	
	private int maxHeight = 0;
	
	private int width = 0;
	
	private int height = 0;

	/**
	 * @return the minWidth
	 */
	public int getMinWidth() {
		return minWidth;
	}

	/**
	 * @param minWidth the minWidth to set
	 */
	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	/**
	 * @return the minHeight
	 */
	public int getMinHeight() {
		return minHeight;
	}

	/**
	 * @param minHeight the minHeight to set
	 */
	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	/**
	 * @return the maxWidth
	 */
	public int getMaxWidth() {
		return maxWidth;
	}

	/**
	 * @param maxWidth the maxWidth to set
	 */
	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	/**
	 * @return the maxHeight
	 */
	public int getMaxHeight() {
		return maxHeight;
	}

	/**
	 * @param maxHeight the maxHeight to set
	 */
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
}
