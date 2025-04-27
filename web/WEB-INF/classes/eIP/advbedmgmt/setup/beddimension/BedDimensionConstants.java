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
package eIP.advbedmgmt.setup.beddimension;

/**
 * Constants file for bed dimension
 * @author GRamamoorthy
 *
 */
public class BedDimensionConstants {

	/**
	 * constants denoting the result set column names for bed dimensions
	 */
	public static final String DIMENSION_TYPE_COLUMN_NAME = "DIM_TYPE";
	
	public static final String DIMENSION_VALUE_COLUMN_NAME = "DIM_VALUE";
	
	/**
	 * Constants denoting the value of the dimension type column
	 */
	public static final String MIN_WIDTH_DIM_TYPE = "MIN_WIDTH";
	
	public static final String MIN_HEIGHT_DIM_TYPE = "MIN_HEIGHT";
	
	public static final String MAX_WIDTH_DIM_TYPE = "MAX_WIDTH";
	
	public static final String MAX_HEIGHT_DIM_TYPE = "MAX_HEIGHT";
	
	public static final String WIDTH_DIM_TYPE = "WIDTH";
	
	public static final String HEIGHT_DIM_TYPE = "HEIGHT";
	
	/**
	 * Constant denoting the bc identifier used in the spring beans definition xml
	 */
	public static final String BC_IDENTIFIER = "bedDimension";
	
	/**
	 * Constant denoting the default width and height
	 */
	public static final int DEFAULT_WIDTH = 150;
	
	public static final int DEFAULT_HEIGHT = 90;
	
}
