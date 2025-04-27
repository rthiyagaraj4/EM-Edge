/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.agencyCode.pojo.web;

import com.iba.ehis.lc.agencyCode.vo.AgencyCodeVO;
import com.iba.ehis.lc.core.pojo.web.LcForm;

public class AgencyCodeForm extends LcForm {

	public AgencyCodeForm() {
		setVo(new AgencyCodeVO()); 
	}

}
