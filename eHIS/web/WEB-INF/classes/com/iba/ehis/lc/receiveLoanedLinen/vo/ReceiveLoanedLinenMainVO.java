/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.vo;

import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenVO;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.ehis.lc.issueOfLinen.vo.RequestsListVO;

public class ReceiveLoanedLinenMainVO extends LcVO {

	private ReceiveLoanedLinenVO receiveLoanedLinenVO;

	private RequestsListVO requestsListVO;

	private String viewCode;

	private String checkView;

	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}

	public String getCheckView() {
		return checkView;
	}

	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}

	public ReceiveLoanedLinenVO getReceiveLoanedLinenVO() {
		receiveLoanedLinenVO = (receiveLoanedLinenVO == null ? new ReceiveLoanedLinenVO()
				: receiveLoanedLinenVO);
		return receiveLoanedLinenVO;
	}

	public void setReceiveLoanedLinenVO(
			ReceiveLoanedLinenVO receiveLoanedLinenVO) {
		receiveLoanedLinenVO = (receiveLoanedLinenVO == null ? new ReceiveLoanedLinenVO()
				: receiveLoanedLinenVO);
		this.receiveLoanedLinenVO = receiveLoanedLinenVO;
	}

	public RequestsListVO getRequestsListVO() {
		requestsListVO = (requestsListVO == null ? new RequestsListVO()
				: requestsListVO);
		return requestsListVO;
	}

	public void setRequestsListVO(RequestsListVO requestsListVO) {
		requestsListVO = (requestsListVO == null ? new RequestsListVO()
				: requestsListVO);
		this.requestsListVO = requestsListVO;
	}

}
