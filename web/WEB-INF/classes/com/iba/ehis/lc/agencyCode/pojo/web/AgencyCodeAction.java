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
package com.iba.ehis.lc.agencyCode.pojo.web;

import com.iba.ehis.lc.agencyCode.vo.AgencyCodeVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO; 
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 */
public class AgencyCodeAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.createTypeMaster((AgencyCodeVO) valueObject);

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
				((AgencyCodeVO) valueObject).getAgencyCode(),
				request.getSession().getId());
		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((AgencyCodeVO) valueObject);

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
				.updateTypeMaster((AgencyCodeVO) valueObject);

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
		if (((AgencyCodeVO) valueObject).getAgencyCode() == null) {
			dto.setMode(Constants.CREATE);
			dto.setObject(valueObject);
			dto.setTarget("createPageAgencyCode");
			dto.setStatus(Constants.SUCCESS);
		} else {
			dto = ((AppDelegator) getDelegator())
					.getTypeMaster((AgencyCodeVO) valueObject);
			IBALogger.getLogger().debug(this.getClass(),
					((AgencyCodeVO) dto.getObject()).getAgencyCode(),
					request.getSession().getId());
			((AppVO) dto.getObject())
					.setFunctionId(((AgencyCodeVO) valueObject).getFunctionId());
			((AppVO) dto.getObject()).setModuleId(((AgencyCodeVO) valueObject)
					.getModuleId());
			dto.setMode(Constants.UPDATE);
			dto.setTarget("createPageAgencyCode");
		}

		return dto;
	}

	private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request) {
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		QueryCriteriaItem criteriaItemAgencyCode = new QueryCriteriaItem();
		criteriaItemAgencyCode.setBundleName("lcLabels");
		criteriaItemAgencyCode
				.setLabelKey("com.iba.ehis.lc.agencyCode.agencyCode");
		criteriaItemAgencyCode.setProperty("agencyCode");
		criteriaItemAgencyCode.setLength(10);
		criteriaItemAgencyCode.setSize(10);
		criteriaItemAgencyCode.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemAgencyCode);

		QueryCriteriaItem criteriaItemName = new QueryCriteriaItem();
		criteriaItemName.setBundleName("lcLabels");
		criteriaItemName.setLabelKey("com.iba.ehis.lc.agencyCode.name");
		criteriaItemName.setProperty("agencyName");
		criteriaItemName.setLength(30);
		criteriaItemName.setSize(30);
		criteriaItemName.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemName);

		QueryCriteriaItem criteriaItemEffStatus = new QueryCriteriaItem();
		criteriaItemEffStatus.setBundleName("lcLabels");
		criteriaItemEffStatus.setLabelKey("com.iba.ehis.lc.nature");
		criteriaItemEffStatus.setProperty("effStatus");
		criteriaItemEffStatus.setLength(5);
		criteriaItemEffStatus.setSize(5);
		criteriaItemEffStatus.setType(QueryCriteriaConstants.SELECT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemEffStatus);
		try {
			criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusB", "",
					"lcLabels");
			criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusY", "E",
					"lcLabels");
			criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusN", "D",
					"lcLabels");
		} catch (Exception e) {
			e.printStackTrace();
		}

		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.agencyCode.agencyCode",
				"1", "lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.agencyCode.name", "2",
				"lcLabels");
		queryCriteriaVO
				.addOrderByCol("com.iba.ehis.lc.nature", "3", "lcLabels");

		queryCriteriaVO.setPageAction("AgencyCodePageAction");
		queryCriteriaVO.setQueryResultPage("AgencyCodeQueryResultPage");
		valueObject = setDefaultSet((AppVO) valueObject, request);
		queryCriteriaVO.setFunctionId(((AgencyCodeVO) valueObject)
				.getFunctionId());
		queryCriteriaVO.setModuleId(((AgencyCodeVO) valueObject).getModuleId());
		AppForm criteriaForm = new AppForm();
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("queryCriteriaPage");
		return dto;
	}
}
