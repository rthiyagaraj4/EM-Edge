/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.ehis.lc.repinfectedlinen.pojo.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.framework.lookup.pojo.business.LookupDelegate;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.replatedeliveries.vo.RepLateDeliveriesVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import java.util.*;

import com.iba.framework.lookup.vo.LookupVO;

public class RepInfectedLinenAction extends LcAction{

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)throws ApplicationException {
				
		DTO lookUpDTO=new DTO();
		LookupVO lookUpVo = new LookupVO();
		Map lookupMap = new HashMap();
								
			lookupMap.put("facilityId",((AppVO)valueObject).getAddedFacilityId());
			lookUpVo.setLookupParameters(lookupMap);
			valueObject = setDefaultSet((AppVO)valueObject,request);				
			lookUpDTO.setMode(Constants.CREATE);
			lookUpDTO.setObject(valueObject);
			lookUpDTO.setTarget("createPage");
			lookUpDTO.setStatus(Constants.SUCCESS);
		return lookUpDTO;
				
	}
	
}
