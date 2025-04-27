/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueLinenAfterMending.vo;

import com.iba.ehis.lc.core.vo.LcVO;

public class IssueLinenAfterMendingMainVO extends LcVO {
	private IssueLinenAfterMendingVO issueOfLinenVO;

	private MendingListVO requestsListVO;

	private String viewCode;

	private String checkView;

	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
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

	public IssueLinenAfterMendingVO getIssueOfLinenVO() {
		issueOfLinenVO = (issueOfLinenVO == null ? new IssueLinenAfterMendingVO()
				: issueOfLinenVO);
		return issueOfLinenVO;
	}

	public void setIssueOfLinenVO(IssueLinenAfterMendingVO issueOfLinenVO) {
		issueOfLinenVO = (issueOfLinenVO == null ? new IssueLinenAfterMendingVO()
				: issueOfLinenVO);
		this.issueOfLinenVO = issueOfLinenVO;
	}
}
