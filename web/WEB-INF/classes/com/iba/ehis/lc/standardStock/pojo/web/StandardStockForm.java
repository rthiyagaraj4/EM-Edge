/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.standardStock.pojo.web;

import com.iba.ehis.lc.core.pojo.web.LcForm;
import com.iba.ehis.lc.laundryUser.vo.LaundryUserVO;
import com.iba.ehis.lc.standardStock.vo.StandardStockVO;
import com.iba.framework.core.vo.BaseVO;

public class StandardStockForm extends LcForm {

	public StandardStockForm() {
		setVo(new StandardStockVO());
	}

}
