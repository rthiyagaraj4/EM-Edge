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
package eIP.advbedmgmt.common.bedlegend.response;

import java.util.List;

import eIP.advbedmgmt.common.bedlegend.BedLegendConstants;
import eIP.advbedmgmt.common.model.BedLegend;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for bed legends
 * @author GRamamoorthy
 *
 */
public class BedLegendResponse extends BaseResponse {

	private List<BedLegend> legends = null;
	
	private String roomBackgroundColor = BedLegendConstants.DEFAULT_ROOM_BACKGROUND_COLOR;

	/**
	 * @return the legends
	 */
	public List<BedLegend> getLegends() {
		return legends;
	}

	/**
	 * @param legends the legends to set
	 */
	public void setLegends(List<BedLegend> legends) {
		this.legends = legends;
	}
	
	/**
	 * This is a convenient method to get the color of a room
	 * the room color is always present in the configuration table
	 * This method should be called only after the bed legends are
	 * set
	 * @return
	 */
	public String getRoomColor(){
		String roomColor = BedLegendConstants.DEFAULT_ROOM_BACKGROUND_COLOR;
		if(legends == null || legends.isEmpty()){
			return roomColor;
		}
		
		BedLegend tempLegend = new BedLegend(BedStatusEnum.ROOM_BCKGND);
		if(legends.contains(tempLegend)){
			int index = legends.indexOf(tempLegend);
			tempLegend = legends.get(index);
			roomColor = tempLegend.getLegendColor();
		}
		
		return roomColor;
	}

	/**
	 * @return the roomBackgroundColor
	 */
	public String getRoomBackgroundColor() {
		return roomBackgroundColor;
	}

	/**
	 * @param roomBackgroundColor the roomBackgroundColor to set
	 */
	public void setRoomBackgroundColor(String roomBackgroundColor) {
		this.roomBackgroundColor = roomBackgroundColor;
	}
	
}
