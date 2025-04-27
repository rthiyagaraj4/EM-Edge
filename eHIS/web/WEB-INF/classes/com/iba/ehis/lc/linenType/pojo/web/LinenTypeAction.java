/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  LinenTypeAction.java
 */
package com.iba.ehis.lc.linenType.pojo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 */
public class LinenTypeAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.createTypeMaster((LinentypeVO) valueObject);

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
				((LinentypeVO) valueObject).getLinenTypeCode(),
				request.getSession().getId());
		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((LinentypeVO) valueObject);

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
				.updateTypeMaster((LinentypeVO) valueObject);

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
		DTO dto = new DTO();
		valueObject = setDefaultSet((AppVO) valueObject, request);
		if (((LinentypeVO) valueObject).getLinenTypeCode() == null) {
			dto.setMode(Constants.CREATE);
			dto.setObject(valueObject);
			dto.setTarget("createPageLinenType");
			dto.setStatus(Constants.SUCCESS);
		} else {
			dto = ((AppDelegator) getDelegator())
					.getTypeMaster((LinentypeVO) valueObject);
			((AppVO) dto.getObject()).setFunctionId(((LinentypeVO) valueObject)
					.getFunctionId());
			((AppVO) dto.getObject()).setModuleId(((LinentypeVO) valueObject)
					.getModuleId());
			IBALogger.getLogger().debug(this.getClass(),
					((LinentypeVO) dto.getObject()).getLinenTypeCode(),
					request.getSession().getId());
			dto.setMode(Constants.UPDATE);
			dto.setTarget("createPageLinenType");
		}

		return dto;
	}

	private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request) {
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
		criteriaItemLinenItem.setBundleName("lcLabels");
		criteriaItemLinenItem.setLabelKey("com.iba.ehis.lc.linenType");
		criteriaItemLinenItem.setProperty("linenTypeCode");
		criteriaItemLinenItem.setLength(5);
		criteriaItemLinenItem.setSize(5);
		criteriaItemLinenItem.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemLinenItem);

		QueryCriteriaItem criteriaItemDesciption = new QueryCriteriaItem();
		criteriaItemDesciption.setBundleName("lcLabels");
		criteriaItemDesciption.setLabelKey("com.iba.ehis.lc.description");
		criteriaItemDesciption.setProperty("linenTypeDesc");
		criteriaItemDesciption.setLength(30);
		criteriaItemDesciption.setSize(30);
		criteriaItemDesciption.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemDesciption);

		QueryCriteriaItem criteriaItemStatus = new QueryCriteriaItem();
		criteriaItemStatus.setBundleName("lcLabels");
		criteriaItemStatus.setLabelKey("com.iba.ehis.lc.nature");
		criteriaItemStatus.setProperty("effStatus");
		criteriaItemStatus.setLength(5);
		criteriaItemStatus.setSize(5);
		criteriaItemStatus.setType(QueryCriteriaConstants.SELECT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemStatus);
		try {
			criteriaItemStatus.addOption("com.iba.ehis.lc.statusB", "",
					"lcLabels");
			criteriaItemStatus.addOption("com.iba.ehis.lc.statusY", "E",
					"lcLabels");
			criteriaItemStatus.addOption("com.iba.ehis.lc.statusN", "D",
					"lcLabels");
		} catch (Exception e) {
			e.printStackTrace();
		}
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.linenType", "1",
				"lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.description", "2",
				"lcLabels");
		queryCriteriaVO
				.addOrderByCol("com.iba.ehis.lc.nature", "3", "lcLabels");

		queryCriteriaVO.setPageAction("LinenTypePageAction");
		queryCriteriaVO.setQueryResultPage("LinenTypeQueryResultPage");
		valueObject = setDefaultSet((AppVO) valueObject, request);
		queryCriteriaVO.setFunctionId(((LinentypeVO) valueObject)
				.getFunctionId());
		queryCriteriaVO.setModuleId(((LinentypeVO) valueObject).getModuleId());
		AppForm criteriaForm = new AppForm();
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("queryCriteriaPage");
		return dto;
	}
}
