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
package com.iba.ehis.lc.linenItem.pojo.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.lc.agencyCode.vo.AgencyCodeVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.linenItem.vo.LinenItemVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author yadavk
 */
public class LinenItemAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.createTypeMaster((LinenItemVO) valueObject);

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
				((LinenItemVO) valueObject).getLinenItem(),
				request.getSession().getId());
		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((LinenItemVO) valueObject);

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
				.updateTypeMaster((LinenItemVO) valueObject);

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
		Map lookupValue = new HashMap();
		Map linenTypeMap = new HashMap();
		LookupVO lookUpVo = new LookupVO();
		lookupValue.put("operatingFacilityId", ((AppVO) valueObject)
				.getAddedFacilityId());
		lookupValue.put("languageId",request.getSession().getAttribute("LOCALE") );
		lookUpVo.setLookupParameters(lookupValue);
		lookUpVo.setQueryId("ehis.lc.linenItem.getLinenType");

		IBALogger.getLogger().debug(this.getClass(),
				"LinenItemAction---------->lookupValue" + lookupValue, null);
		dto = ((LookupDelegate) getDelegatorById("lookupDelegator"))
				.lookupUpQuery(lookUpVo, null, request.getSession().getId());
		IBALogger.getLogger().debug(this.getClass(),
				"LinenItemAction---------->" + dto.getObject(), null);
		linenTypeMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		if (((LinenItemVO) valueObject).getLinenItem() == null) {
			((LinenItemVO) valueObject).setLinenMap(linenTypeMap);
			dto.setMode(Constants.CREATE);
			dto.setObject(valueObject);
			dto.setTarget("createPageLinenItem");
			dto.setStatus(Constants.SUCCESS);
		} else {
			dto = ((AppDelegator) getDelegator())
					.getTypeMaster((LinenItemVO) valueObject);
			((LinenItemVO) dto.getObject()).setLinenMap(linenTypeMap);
			((AppVO) dto.getObject()).setFunctionId(((LinenItemVO) valueObject)
					.getFunctionId());
			((AppVO) dto.getObject()).setModuleId(((LinenItemVO) valueObject)
					.getModuleId());

			IBALogger.getLogger().debug(this.getClass(),
					((LinenItemVO) dto.getObject()).getLinenItem(),
					request.getSession().getId());

			dto.setMode(Constants.UPDATE);
			dto.setTarget("createPageLinenItem");
		}

		return dto;
	}

	private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request) {
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
		criteriaItemLinenItem.setBundleName("lcLabels");
		criteriaItemLinenItem.setLabelKey("com.iba.ehis.lc.linenItem");
		criteriaItemLinenItem.setProperty("linenItem");
		criteriaItemLinenItem.setLength(10);
		criteriaItemLinenItem.setSize(10);
		criteriaItemLinenItem.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemLinenItem);

		QueryCriteriaItem criteriaItemLongDesc = new QueryCriteriaItem();
		criteriaItemLongDesc.setBundleName("lcLabels");
		criteriaItemLongDesc.setLabelKey("com.iba.ehis.lc.longDesc");
		criteriaItemLongDesc.setProperty("longDesc");
		criteriaItemLongDesc.setLength(30);
		criteriaItemLongDesc.setSize(30);
		criteriaItemLongDesc.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemLongDesc);

		QueryCriteriaItem criteriaItemshortDesc = new QueryCriteriaItem();
		criteriaItemshortDesc.setBundleName("lcLabels");
		criteriaItemshortDesc.setLabelKey("com.iba.ehis.lc.shortDesc");
		criteriaItemshortDesc.setProperty("shortDesc");
		criteriaItemshortDesc.setLength(15);
		criteriaItemshortDesc.setSize(15);
		criteriaItemshortDesc.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemshortDesc);

		QueryCriteriaItem criteriaItemDisposable = new QueryCriteriaItem();
		criteriaItemDisposable.setBundleName("lcLabels");
		criteriaItemDisposable.setLabelKey("com.iba.ehis.lc.disposableItem");
		criteriaItemDisposable.setProperty("disposable");
		criteriaItemDisposable.setLength(5);
		criteriaItemDisposable.setSize(5);
		criteriaItemDisposable.setType(QueryCriteriaConstants.SELECT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemDisposable);
		try {
			criteriaItemDisposable.addOption("com.iba.ehis.lc.statusB", "",
					"lcLabels");
			criteriaItemDisposable.addOption("com.iba.ehis.lc.yes", "Y",
					"lcLabels");
			criteriaItemDisposable.addOption("com.iba.ehis.lc.no", "N",
					"lcLabels");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.linenItem", "1",
				"lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.longDesc", "2",
				"lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.shortDesc", "3",
				"lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.disposableItem", "4",
				"lcLabels");
		queryCriteriaVO
				.addOrderByCol("com.iba.ehis.lc.nature", "5", "lcLabels");

		queryCriteriaVO.setPageAction("LinenItemPageAction");
		queryCriteriaVO.setQueryResultPage("LinenItemQueryResultPage");
		valueObject = setDefaultSet((AppVO) valueObject, request);
		queryCriteriaVO.setFunctionId(((LinenItemVO) valueObject)
				.getFunctionId());
		queryCriteriaVO.setModuleId(((LinenItemVO) valueObject).getModuleId());
		AppForm criteriaForm = new AppForm();
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("queryCriteriaPage");
		return dto;
	}
}
