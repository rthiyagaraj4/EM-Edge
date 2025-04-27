/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.laundryUser.vo;

import java.util.List;
import java.util.Map;

import com.iba.ehis.core.vo.QueryCriteriaVO;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.Page;

public class LaundryUserVO extends LcVO {

	/* Declaration of WardsForKitchen variables for the VO */

	private String user;

	private String overRideWardConf;

	/* Generated getter and setter metods of the above variables */

	public String getOverRideWardConf() {
		if (overRideWardConf == null)
			overRideWardConf = "N";
		return overRideWardConf;
	}

	public void setOverRideWardConf(String overRideWardConf) {
		this.overRideWardConf = overRideWardConf;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
