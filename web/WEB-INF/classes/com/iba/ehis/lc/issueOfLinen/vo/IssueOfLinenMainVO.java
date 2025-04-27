/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueOfLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;



public class IssueOfLinenMainVO extends LcVO {
	private IssueOfLinenVO issueOfLinenVO ;
	private RequestsListVO requestsListVO ;	
	private String viewCode; 
	
	private String checkView;

	public String getViewCode() {
		return viewCode;
	}
	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
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
	public IssueOfLinenVO getIssueOfLinenVO() {
		issueOfLinenVO=(issueOfLinenVO==null?new IssueOfLinenVO():issueOfLinenVO);
		return issueOfLinenVO;
	}
	public void setIssueOfLinenVO(IssueOfLinenVO issueOfLinenVO) {
		issueOfLinenVO=(issueOfLinenVO==null?new IssueOfLinenVO():issueOfLinenVO);
		this.issueOfLinenVO = issueOfLinenVO;
	} 
}
