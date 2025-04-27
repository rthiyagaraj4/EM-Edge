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
package com.iba.framework.lookup.pojo.business;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.BaseBusinessDelegate;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author Sabarinathan S
 * 
 * @spring.bean id="lookupDelegator"
 * @spring.property name="facade" ref="lookupFacade"
 */
public class LookupDelegate extends BaseBusinessDelegate {

	public DTO lookupUpQuery(LookupVO lookupValue, Page page, String sessionId) {
		DTO oDto = new DTO();
		try {
			oDto = ((Lookup) getFacade()).lookupByQuery(lookupValue, page,
					sessionId);
		} catch (ApplicationException e) {
			oDto.setException(e);
			oDto.setMessageId(e.getErrorCode());
		}
		return oDto;
	}
}
