/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;



public class DeliverCleanedLinenMainVO extends LcVO {
	private DeliverCleanedLinenVO deliverCleanedLinenVO ;
	private DeliverListVO deliverListVO ;	
	private String viewCode; 
	
	private String checkView;

	public String getViewCode() {
		return viewCode;
	}
	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	public DeliverListVO getDeliverListVO() {
		deliverListVO=(deliverListVO==null?new DeliverListVO():deliverListVO);
		return deliverListVO;
	}
	public void setDeliverListVO(DeliverListVO deliverListVO) {
		this.deliverListVO = deliverListVO;
	}
	public String getCheckView() {
		return checkView;
	}
	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}
	public DeliverCleanedLinenVO getDeliverCleanedLinenVO() {
		deliverCleanedLinenVO=(deliverCleanedLinenVO==null?new DeliverCleanedLinenVO():deliverCleanedLinenVO);
		return deliverCleanedLinenVO;
	}
	public void setDeliverCleanedLinenVO(DeliverCleanedLinenVO deliverCleanedLinenVO) {
		deliverCleanedLinenVO=(deliverCleanedLinenVO==null?new DeliverCleanedLinenVO():deliverCleanedLinenVO);
		this.deliverCleanedLinenVO = deliverCleanedLinenVO;
	} 
}
