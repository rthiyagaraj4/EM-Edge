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
package eIP.advbedmgmt.common.bedcolor.bc;

import java.util.List;

import eIP.advbedmgmt.common.bedcolor.dao.BedColorDAO;
import eIP.advbedmgmt.common.bedcolor.dao.BedColorDAOImpl;
import eIP.advbedmgmt.common.bedcolor.request.BedColorRequest;
import eIP.advbedmgmt.common.bedcolor.response.BedColorResponse;
import eIP.advbedmgmt.common.model.BedColor;
import eIP.advbedmgmt.common.model.BedStatusEnum;

/**
 * This is the BC layer class for bed color 
 * @author GRamamoorthy
 *
 */
public class BedColorBC {

	/**
	 * This method gets the bed color 
	 * @param request
	 * @return
	 */
	public BedColorResponse getBedColor(BedColorRequest request){
		BedColorDAO daoInst = new BedColorDAOImpl();
		BedColorResponse response = daoInst.getBedColor(request);
		
		// response will have room color as well as not initialized bed color
		// remove this if the response is successful
		if (response.isSuccessful()) {
			List<BedColor> colors = response.getColorList();
			
			// check if request contains a specific bed status
			String bedStatus = request.getBedStatus();
			BedStatusEnum statusEnum = BedStatusEnum.NOT_INITIALIZED;
			try {
				statusEnum = BedStatusEnum.valueOf(bedStatus);
			} catch (Exception e) {
				// not much can be done
				statusEnum = BedStatusEnum.NOT_INITIALIZED;
			}
			
			// this means status given as request is not a valid one
			// there is a need to filter the not initialized and room colors
			if(!(statusEnum.equals(BedStatusEnum.NOT_INITIALIZED))){
				BedColor color = new BedColor(BedStatusEnum.ROOM_BCKGND);
				if(colors.contains(color)){
					int index = colors.indexOf(color);
					colors.remove(index);
				}
				
				color = new BedColor(BedStatusEnum.NOT_INITIALIZED);
				if(colors.contains(color)){
					int index = colors.indexOf(color);
					colors.remove(index);
				}
			}
			
		}
		
		return response;
	}
	
}
