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
package eIP.advbedmgmt.setup.beddimension.dao;

import eIP.advbedmgmt.setup.beddimension.request.RetrieveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.request.SaveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.response.RetrieveDimensionResponse;
import eIP.advbedmgmt.setup.beddimension.response.SaveDimensionResponse;

/**
 * This is the interface for bed dimension related activities
 * @author GRamamoorthy
 *
 */
public interface BedDimensionDAO {

	/**
	 * This method retrieves the bed dimensions
	 * @param request
	 * @return
	 */
	public RetrieveDimensionResponse getDimensions(RetrieveDimensionRequest request);
	
	
	/**
	 * This method saves bed dimensions
	 * @param request
	 * @return
	 */
	public SaveDimensionResponse saveDimensions(SaveDimensionRequest request);
	
}
