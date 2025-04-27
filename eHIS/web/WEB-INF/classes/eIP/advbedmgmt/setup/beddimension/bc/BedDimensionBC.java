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
package eIP.advbedmgmt.setup.beddimension.bc;

import eIP.advbedmgmt.setup.beddimension.dao.BedDimensionDAO;
import eIP.advbedmgmt.setup.beddimension.dao.BedDimensionDAOImpl;
import eIP.advbedmgmt.setup.beddimension.request.RetrieveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.request.SaveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.response.RetrieveDimensionResponse;
import eIP.advbedmgmt.setup.beddimension.response.SaveDimensionResponse;

/**
 * this is the bc layer class for bed dimensions
 * @author GRamamoorthy
 *
 */
public class BedDimensionBC {

	/**
	 * This method gets the bed dimensions
	 * @param request
	 * @return
	 */
	public RetrieveDimensionResponse getBedDimension(RetrieveDimensionRequest request){
		BedDimensionDAO daoInst = new BedDimensionDAOImpl();
		return daoInst.getDimensions(request);
	}
	
	/**
	 * This method saves the bed dimensions
	 * @param request
	 * @return
	 */
	public SaveDimensionResponse saveBedDimension(SaveDimensionRequest request){
		BedDimensionDAO daoInst = new BedDimensionDAOImpl();
		return daoInst.saveDimensions(request);
	}
	
	
}
