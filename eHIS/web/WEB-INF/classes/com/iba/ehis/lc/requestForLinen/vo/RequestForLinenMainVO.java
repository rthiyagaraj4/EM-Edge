/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;



public class RequestForLinenMainVO extends LcVO {
	private PlaceLinenRequestVO placeLinenRequestVO ;
	private RequestsListVO requestsListVO ;	
	private String viewCode; 
	private String checkView;

		
	public String getViewCode() {
		return viewCode;
	}
	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}

	public PlaceLinenRequestVO getPlaceLinenRequestVO() {
		placeLinenRequestVO=(placeLinenRequestVO==null?new PlaceLinenRequestVO():placeLinenRequestVO);
		return placeLinenRequestVO;
	}
	public void setPlaceLinenRequestVO(PlaceLinenRequestVO placeLinenRequestVO) {
		placeLinenRequestVO=(placeLinenRequestVO==null?new PlaceLinenRequestVO():placeLinenRequestVO);
		this.placeLinenRequestVO = placeLinenRequestVO;
	}
	public RequestsListVO getRequestsListVO() {
		requestsListVO=(requestsListVO==null?new RequestsListVO():requestsListVO);
		return requestsListVO;
	}
	public void setRequestsListVO(RequestsListVO requestsListVO) {
		this.requestsListVO = requestsListVO;
	}
	public String getCheckView() {
		return checkView;
	}
	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}
}
