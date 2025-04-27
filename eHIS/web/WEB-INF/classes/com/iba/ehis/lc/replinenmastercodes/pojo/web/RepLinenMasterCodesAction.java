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
package com.iba.ehis.lc.replinenmastercodes.pojo.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.framework.lookup.pojo.business.LookupDelegate;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.replinenmastercodes.vo.RepLinenMasterCodesVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import java.util.*;

import com.iba.framework.lookup.vo.LookupVO;

public class RepLinenMasterCodesAction extends LcAction{

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)throws ApplicationException {
		DTO lookUpDTO=new DTO();
		LookupVO lookUpVo = new LookupVO();
		Map lookupMap = new HashMap();

		lookupMap.put("facilityId",((AppVO)valueObject).getAddedFacilityId());
		lookUpVo.setLookupParameters(lookupMap);
		valueObject = setDefaultSet((AppVO)valueObject,request);			
		lookUpDTO.setMode(Constants.CREATE);
		lookUpDTO.setObject(valueObject);
		
		String Mode=(String)request.getParameter("mode");
		
		if(Mode.equals("master")){
			lookUpDTO.setTarget("createPage");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("I")){
			lookUpDTO.setTarget("createPage1");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE1"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("T")){
			lookUpDTO.setTarget("createPage2");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE2"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("A")){
			lookUpDTO.setTarget("createPage3");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE3"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("R")){
			lookUpDTO.setTarget("createPage4");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE4"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("S")){
			lookUpDTO.setTarget("createPage5");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE5"+lookUpDTO.getTarget(),null);
		}else if(Mode.equals("L")){
			lookUpDTO.setTarget("createPage6");
			IBALogger.getLogger().debug(this.getClass(),"CREATE PAGE6"+lookUpDTO.getTarget(),null);
		}
		lookUpDTO.setStatus(Constants.SUCCESS);
	return lookUpDTO;
	}				
}
