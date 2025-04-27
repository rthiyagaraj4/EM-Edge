/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.sendLinenForMending.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;

public class SendLinenForMendingMainVO extends LcVO {
	private PlaceLinenMendingRequestVO placeLinenRequestVO;

	private MendingListVO requestsListVO;

	private String viewCode;

	private String checkView;

	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}

	public PlaceLinenMendingRequestVO getPlaceLinenRequestVO() {
		placeLinenRequestVO = (placeLinenRequestVO == null ? new PlaceLinenMendingRequestVO()
				: placeLinenRequestVO);
		return placeLinenRequestVO;
	}

	public void setPlaceLinenRequestVO(
			PlaceLinenMendingRequestVO placeLinenRequestVO) {
		placeLinenRequestVO = (placeLinenRequestVO == null ? new PlaceLinenMendingRequestVO()
				: placeLinenRequestVO);
		this.placeLinenRequestVO = placeLinenRequestVO;
	}

	public MendingListVO getRequestsListVO() {
		requestsListVO = (requestsListVO == null ? new MendingListVO()
				: requestsListVO);
		return requestsListVO;
	}

	public void setRequestsListVO(MendingListVO requestsListVO) {
		this.requestsListVO = requestsListVO;
	}

	public String getCheckView() {
		return checkView;
	}

	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}
}
