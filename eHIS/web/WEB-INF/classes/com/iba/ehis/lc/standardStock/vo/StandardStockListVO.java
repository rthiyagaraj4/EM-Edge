/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.standardStock.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.vo.BaseVO;

public class StandardStockListVO extends LcVO {
	private String linenItem;

	private Long stdQty;

	private int flag;

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Long getStdQty() {
		return stdQty;
	}

	public void setStdQty(Long stdQty) {
		this.stdQty = stdQty;
	}

}
