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
package com.iba.ehis.lc.laundryUser.pojo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.pojo.business.*;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.laundryUser.vo.LaundryUserVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author yadavk
 */
public class LaundryUserAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		DTO dto = new DTO();

		valueObject = setDefaultSet((AppVO) valueObject, request);
		((LaundryUserVO) valueObject).setAddedFacilityId(((AppVO) valueObject)
				.getAddedFacilityId());
		try {
			dto = ((AppDelegator) getDelegator())
					.createTypeMaster((LaundryUserVO) valueObject);
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
			IBALogger.getLogger().debug(this.getClass(),
					"LaundryUserAction-----Failure----->", null);
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;
	}

	protected DTO doActionDelete(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		IBALogger.getLogger().debug(this.getClass(),
				"LaundryUserAction-----1----->doActionDelete()", null);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((LaundryUserVO) valueObject);
		IBALogger.getLogger().debug(this.getClass(),
				"LaundryUserAction-----2----->doActionDelete() ", null);
		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}
		return dto;
	}

	protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) {
		DTO dto = null;

		dto = loadCriteria(valueObject, request);
		return dto;
	}

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster((LaundryUserVO) valueObject);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;

	}

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {

		IBALogger.getLogger().debug(this.getClass(),
				"LaundryUserAction---------->doPrePopulate ", null);
		DTO dto = new DTO();
		DTO dtoLookUp = new DTO();
		LookupVO lookUpVo = new LookupVO();
		valueObject = setDefaultSet((AppVO) valueObject, request);

		/* checks if the vo having null values */
		if (((LaundryUserVO) valueObject).getUser() == null) {
			valueObject = setDefaultSet((AppVO) valueObject, request);
			dto.setMode(Constants.CREATE); // sets tha mode as create
			dto.setObject(valueObject); // sets the valueobject to dto
			dto.setTarget("createPageLaundryUser"); // sets the target page to
													// ceatePage
			dto.setStatus(Constants.SUCCESS); // sets the status as SUCCESS
		} else {
			IBALogger.getLogger().debug(
					this.getClass(),
					"LaundryUserAction---------->doPrePopulate ----else"
							+ ((LaundryUserVO) valueObject)
									.getOverRideWardConf(), null);
			/*
			 * Adds the Default vaues to the valueobject
			 */
			valueObject = setDefaultSet((LaundryUserVO) valueObject, request);
			dto.setObject(valueObject);
			((AppVO) dto.getObject())
					.setFunctionId(((LaundryUserVO) valueObject)
							.getFunctionId());
			((AppVO) dto.getObject()).setModuleId(((LaundryUserVO) valueObject)
					.getModuleId());
			dto.setMode(Constants.UPDATE); // sets the Mode as UPDATE
			dto.setTarget("createPageLaundryUser"); // sets the page target to
													// createPage
		}

		return dto;
	}

	private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request) {
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		QueryCriteriaItem criteriaItemUser = new QueryCriteriaItem();
		criteriaItemUser.setBundleName("lcLabels");
		criteriaItemUser.setLabelKey("com.iba.ehis.lc.laundryUser.user");
		criteriaItemUser.setProperty("user");
		criteriaItemUser.setLength(30);
		criteriaItemUser.setSize(30);
		criteriaItemUser.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemUser);

		QueryCriteriaItem criteriaOverrideWardConfirmation = new QueryCriteriaItem();
		criteriaOverrideWardConfirmation.setBundleName("lcLabels");
		criteriaOverrideWardConfirmation
				.setLabelKey("com.iba.ehis.lc.laundryUser.overrideWardConfirmation");
		criteriaOverrideWardConfirmation.setProperty("overRideWardConf");
		criteriaOverrideWardConfirmation
				.setType(QueryCriteriaConstants.SELECT_ITEM);
		queryCriteriaVO.getCriteriaItems()
				.add(criteriaOverrideWardConfirmation);
		try {
			criteriaOverrideWardConfirmation.addOption(
					"com.iba.ehis.lc.statusB", "", "lcLabels");
			criteriaOverrideWardConfirmation.addOption("com.iba.ehis.lc.yes",
					"Y", "lcLabels");
			criteriaOverrideWardConfirmation.addOption("com.iba.ehis.lc.no",
					"N", "lcLabels");
		} catch (Exception e) {
			e.printStackTrace();
		}

		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.laundryUser.user", "1",
				"lcLabels");
		queryCriteriaVO.addOrderByCol(
				"com.iba.ehis.lc.laundryUser.overrideWardConfirmation", "2",
				"lcLabels");

		queryCriteriaVO.setPageAction("LaundryUserPageAction");
		queryCriteriaVO.setQueryResultPage("LaundryUserQueryResultPage");
		valueObject = setDefaultSet((AppVO) valueObject, request);
		queryCriteriaVO.setFunctionId(((LaundryUserVO) valueObject)
				.getFunctionId());
		queryCriteriaVO
				.setModuleId(((LaundryUserVO) valueObject).getModuleId());
		AppForm criteriaForm = new AppForm();
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("queryCriteriaPage");
		return dto;
	}
}
