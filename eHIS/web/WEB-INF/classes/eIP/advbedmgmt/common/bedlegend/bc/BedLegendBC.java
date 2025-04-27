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
package eIP.advbedmgmt.common.bedlegend.bc;

import java.util.List;

import eIP.advbedmgmt.common.bedlegend.dao.BedLegendDAO;
import eIP.advbedmgmt.common.bedlegend.dao.BedLegendDAOImpl;
import eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest;
import eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse;
import eIP.advbedmgmt.common.model.BedLegend;
import eIP.advbedmgmt.common.model.BedStatusEnum;

/**
 * This is the Business layer class for bed legend
 * @author GRamamoorthy
 *
 */
public class BedLegendBC {

	/**
	 * This method gets the bed legend response
	 * @param request
	 * @return
	 */
	public BedLegendResponse getBedLegend(BedLegendRequest request){
		BedLegendDAO daoInst = new BedLegendDAOImpl();
		BedLegendResponse response = daoInst.getBedLegend(request);
		
		// response will have room color as well as not initialized bed legend
		// remove this if the response is successful
		if(response.isSuccessful()){
			List<BedLegend> legends = response.getLegends();
			BedLegend tempLegend = new BedLegend(BedStatusEnum.ROOM_BCKGND);
			String roomBackgroundColor = "";
			if(legends.contains(tempLegend)){
				int index = legends.indexOf(tempLegend);
				tempLegend = legends.get(index);
				roomBackgroundColor = tempLegend.getLegendColor();
				response.setRoomBackgroundColor(roomBackgroundColor);
				// remove the room legend from response
				legends.remove(tempLegend);
			}
			
			// now remove the not initialized bed legend
			tempLegend = new BedLegend(BedStatusEnum.NOT_INITIALIZED);
			if(legends.contains(tempLegend)){
				int index = legends.indexOf(tempLegend);
				tempLegend = legends.get(index);
				
				legends.remove(tempLegend);
			}
		}
		
		return response;
	}
	
}
