/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.web;

import com.iba.ehis.core.vo.QueryResultVO;

/**
 * @struts.form name="PageForm"
 */

public class PageForm extends AppForm {
	public PageForm() {
		super(QueryResultVO.class);
	}
}
