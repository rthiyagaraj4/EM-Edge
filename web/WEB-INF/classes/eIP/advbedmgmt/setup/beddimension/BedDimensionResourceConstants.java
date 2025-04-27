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

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This constants file is used for resource bundle messages
 * in the bed dimension sub module
 * @author GRamamoorthy
 *
 */
public class BedDimensionResourceConstants {

	/**
	 * Constants denoting the resource bundle keys used to retrieve messages
	 */
	public static final String RETRIEVE_DIM_SQLEXCEPTION_KEY = "BedDimension.RetrieveDimension.SQLExceptionMessage";
	
	public static final String DISPLAY_RETRIEVE_DIM_SQLEXCEPTION_KEY = "DisplayMessage.BedDimension.RetrieveDimension.SQLExceptionMessage";
	
	public static final String RETRIEVE_DIM_NULLRESULTSET_KEY = "BedDimension.RetrieveDimension.NullResultSetMessage";
	
	public static final String DISPLAY_RETRIEVE_DIM_NULLRESULTSET_KEY = "DisplayMessage.BedDimension.RetrieveDimension.NullResultSetMessage";
	
	public static final String RETRIEVE_DIM_NODATA_KEY = "BedDimension.RetrieveDimension.NoDataMessage";
	
	public static final String DISPLAY_RETRIEVE_DIM_NODATA_KEY = "DisplayMessage.BedDimension.RetrieveDimension.NoDataMessage";
	
	public static final String RETRIEVE_DIM_CONNECTION_ERROR_KEY = "BedDimension.RetrieveDimension.ConnectionError";
	
	public static final String DISPLAY_RETRIEVE_DIM_CONNECTION_ERROR_KEY = "DisplayMessage.BedDimension.RetrieveDimension.ConnectionError";
	
	/**
	 * resource bundle keys for save dimension
	 */
	public static final String SAVE_DIMENSION_SQLEXCEPTION_KEY = "BedDimension.SaveDimension.SQLExceptionMessage";
	
	public static final String DISPLAY_SAVE_DIMENSION_SQLEXCEPTION_KEY = "DisplayMessage.BedDimension.SaveDimension.SQLExceptionMessage";
	
	public static final String SAVE_DIMENSION_FAILURE_KEY = "BedDimension.SaveDimension.UpdateFailureMessage";
	
	public static final String DISPLAY_SAVE_DIMENSION_FAILURE_KEY = "DisplayMessage.BedDimension.SaveDimension.UpdateFailureMessage";
	
	public static final String SAVE_DIMENSION_CONNECTION_ERROR_KEY = "BedDimension.SaveDimension.ConnectionError";
	
	public static final String DISPLAY_SAVE_DIMENSION_CONNECTION_ERROR_KEY = "DisplayMessage.BedDimension.SaveDimension.ConnectionError";
	
	
	/**
	 * Constant denoting the resource bundle file path
	 */
	public static final String RESOURCE_BUNDLE_FILE_PATH = "eIP.advbedmgmt.setup.beddimension.resourcebundle.Messages";
	
	/**
	 * This should always be the last method/entity in this class
	 * This method will be called by the GBMInitialization servlet during
	 * server startup
	 */
	public static void initialize(){
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.RETRIEVE_DIM_SQLEXCEPTION_CODE,
				RETRIEVE_DIM_SQLEXCEPTION_KEY,
				DISPLAY_RETRIEVE_DIM_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.RETRIEVE_DIM_NULLRESULTSET_CODE,
				RETRIEVE_DIM_NULLRESULTSET_KEY,
				DISPLAY_RETRIEVE_DIM_NULLRESULTSET_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.RETRIEVE_DIM_NODATA_CODE,
				RETRIEVE_DIM_NODATA_KEY,
				DISPLAY_RETRIEVE_DIM_NODATA_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.SAVE_DIM_SQLEXCEPTION_CODE,
				SAVE_DIMENSION_SQLEXCEPTION_KEY,
				DISPLAY_SAVE_DIMENSION_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.SAVE_DIM_UPDATE_FAIL_CODE,
				SAVE_DIMENSION_FAILURE_KEY,
				DISPLAY_SAVE_DIMENSION_FAILURE_KEY);
		
	}
	
	
	
}
