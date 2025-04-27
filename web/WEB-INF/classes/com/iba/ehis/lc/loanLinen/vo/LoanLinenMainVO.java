/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;

public class LoanLinenMainVO extends LcVO {
	private LoanLinenVO loanLinenVO;

	private LoanListVO loanListVO;

	private ViewResultVO viewResultVO;

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

	public LoanLinenVO getLoanLinenVO() {
		loanLinenVO = (loanLinenVO == null ? new LoanLinenVO() : loanLinenVO);
		return loanLinenVO;
	}

	public void setLoanLinenVO(LoanLinenVO loanLinenVO) {
		loanLinenVO = (loanLinenVO == null ? new LoanLinenVO() : loanLinenVO);
		this.loanLinenVO = loanLinenVO;
	}

	public LoanListVO getLoanListVO() {
		loanListVO = (loanListVO == null ? new LoanListVO() : loanListVO);
		return loanListVO;
	}

	public void setLoanListVO(LoanListVO loanListVO) {
		this.loanListVO = loanListVO;
	}

	public ViewResultVO getViewResultVO() {
		return viewResultVO;
	}

	public void setViewResultVO(ViewResultVO viewResultVO) {
		this.viewResultVO = viewResultVO;
	}

}
