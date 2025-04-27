/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.lookup.pojo.web;

import com.iba.framework.core.pojo.web.BaseForm;
import com.iba.framework.core.util.Constants;
import com.iba.framework.lookup.vo.LookupVO;

public class LookupForm extends BaseForm {
	public LookupForm() {
		super(LookupVO.class);
		setMethod(Constants.QUERY);
	}
}
