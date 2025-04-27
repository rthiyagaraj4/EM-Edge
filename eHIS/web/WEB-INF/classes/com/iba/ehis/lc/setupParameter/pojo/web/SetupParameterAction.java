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
package com.iba.ehis.lc.setupParameter.pojo.web;

import com.iba.ehis.lc.core.pojo.web.LcAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.lc.setupParameter.vo.SetupParameterVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk 
 */
public class SetupParameterAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = new DTO();
		try {
			valueObject = setDefaultSet((AppVO) valueObject, request);
			dto = ((AppDelegator) getDelegator())
					.createTypeMaster((SetupParameterVO) valueObject);
		} catch (Exception e) {
			String message = e.getMessage();
			dto.setMessageId(message);
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.INPUT_ERROR);
		}

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;
	}

	protected DTO doActionDelete(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		IBALogger.getLogger().debug(this.getClass(),
				((SetupParameterVO) valueObject).getLaundryCode(),
				request.getSession().getId());
		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((SetupParameterVO) valueObject);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}
		return dto;
	}

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster((SetupParameterVO) valueObject);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}
		return dto;

	}

	 protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
     throws ApplicationException
 {
     DTO dto = new DTO();
     try
     {
         valueObject = setDefaultSet((AppVO)valueObject, request);
         dto = ((AppDelegator)getDelegator()).getTypeMaster((SetupParameterVO)valueObject);
     }
     catch(Exception e)
     {
         IBALogger.getLogger().debug(getClass(), "SetupParameterAction ---------EXCEPTION---------->doPrePopulate ", null);
         e.printStackTrace();
     }
     if(((SetupParameterVO)dto.getObject()).getOperationFacilityid()==null)
     {
         dto.setMode(Constants.CREATE);
         dto.setObject(valueObject);
         dto.setTarget("createPageSetupParameter");
         
     } else
     {
         valueObject = setDefaultSet((AppVO)valueObject, request);
         
         ((AppVO)dto.getObject()).setFunctionId(((SetupParameterVO)valueObject).getFunctionId());
         ((AppVO)dto.getObject()).setModuleId(((SetupParameterVO)valueObject).getModuleId());
         IBALogger.getLogger().debug(getClass(),((SetupParameterVO)dto.getObject()).getLaundryCode(), request.getSession().getId());
         dto.setMode(Constants.UPDATE);
         dto.setTarget("createPageSetupParameter");
     }
     return dto;
 }
}
