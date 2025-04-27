/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.pojo.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.core.util.LcConstants;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenMainVO;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenVO;
import com.iba.ehis.lc.loanLinen.vo.LoanListVO;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestForLinenMainVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class LoanLinenAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		DTO dto = new DTO();
		String target = null;
		(IBALogger.getLogger()).debug(this.getClass(),
				"LoanLinen---viewcode---->"
						+ ((LoanLinenMainVO) valueObject).getViewCode(), "");

		if (((LoanLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.LOAN_LINEN_TAB)) {
			target = "loanLinen";

			if (((LoanLinenMainVO) valueObject).getLoanLinenVO()
					.getLoanRefNum() == null) {
				((LoanLinenMainVO) valueObject).setMode(AppConstants.CREATE);

			} else {
				LoanLinenVO loanLinenVO = (LoanLinenVO) (((AppDelegator) getDelegator())
						.getTypeMaster(((LoanLinenMainVO) valueObject)
								.getLoanLinenVO())).getObject();
				((LoanLinenMainVO) valueObject).setLoanLinenVO(loanLinenVO);
				((LoanLinenMainVO) valueObject).setMode(AppConstants.UPDATE);

			}
			((LoanLinenMainVO) valueObject)
					.setLoanLinenVO(prePopulateLoanLinenTab(
							((LoanLinenMainVO) valueObject).getLoanLinenVO(),
							request));

		} else if (((LoanLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.LOAN_LINEN_LIST_TAB)) {

			((LoanLinenMainVO) valueObject)
					.setLoanListVO(prePopulateLoanLinenList(
							((LoanLinenMainVO) valueObject).getLoanListVO(),
							request));
			target = "loanList";
			if (((LoanLinenMainVO) valueObject).getLoanListVO().getLoanRefNum() != null) {
				((LoanLinenMainVO) valueObject).getLoanListVO().setSourceCode(
						((LoanLinenMainVO) valueObject).getLoanListVO()
								.getSourceCode());
			}
		}

		dto.setTarget(target);
		dto.setObject((LoanLinenMainVO) valueObject);
		return dto;
	}

	private LoanListVO prePopulateLoanLinenList(LoanListVO loanListVO,
			HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		loanListVO = (LoanListVO) setDefaultSet(loanListVO, request);
		loanListVO.setGivenBy(((AppVO) loanListVO).getAddedById());
		loanListVO.setReceivedBy(((AppVO) loanListVO).getAddedById());
		return loanListVO;
	}

	private LoanLinenVO prePopulateLoanLinenTab(LoanLinenVO loanLinenVO,
			HttpServletRequest request) {
		Map lookupValue = new HashMap();
		Map loanReasonMap = new HashMap();
		
		LookupVO lookUpVo = new LookupVO();
		lookupValue
				.put("operatingFacilityId", loanLinenVO.getAddedFacilityId());
		lookupValue.put("language_Id",request.getSession().getAttribute("LOCALE"));

		lookUpVo.setLookupParameters(lookupValue);
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanReason");

		IBALogger.getLogger().debug(this.getClass(),
				"LoanLinenAction---------->lookupValue" + lookupValue, null);
		DTO dto = ((LookupDelegate) getDelegatorById("lookupDelegator"))
				.lookupUpQuery(lookUpVo, null, request.getSession().getId());
		IBALogger.getLogger().debug(this.getClass(),
				"LoanLinenAction---------->" + dto.getObject(), null);
		loanReasonMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		loanLinenVO = (LoanLinenVO) setDefaultSet(loanLinenVO, request);
		loanLinenVO.setReasonMap(loanReasonMap);

		return loanLinenVO;
	}

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = null;
		if (((LoanLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.LOAN_LINEN_TAB)) {
			LoanLinenVO loanLinenVO = (LoanLinenVO) setDefaultSet(
					((LoanLinenMainVO) valueObject).getLoanLinenVO(), request);
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(loanLinenVO);
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}

		} else {

			LoanListVO loanListVO = (LoanListVO) setDefaultSet(
					((LoanLinenMainVO) valueObject).getLoanListVO(), request);
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(loanListVO);
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}

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

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		LoanLinenMainVO loanLinenMainVO = ((LoanLinenMainVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(loanLinenMainVO);

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
			HttpServletResponse response) throws ApplicationException {
		AppForm criteriaForm = new AppForm();
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		if (((LoanLinenMainVO) valueObject).getCheckView() == null
				|| ((LoanLinenMainVO) valueObject).getCheckView().equals("")) {
			queryCriteriaVO.setPageAction("LoanLinenPageAction");
			queryCriteriaVO.setQueryResultPage("LoanLinenQueryResultPage");
			queryCriteriaVO
					.setFunctionId(((AppVO) valueObject).getFunctionId());
			queryCriteriaVO.setModuleId(AppConstants.LINEN);
			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("loanLinenCriteriaPage");
		} else {
			QueryResultVO qryResultVO = new QueryResultVO();
			qryResultVO.setFunctionId("loan");
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			criteriaVo.setPageAction("LoanLinenViewPageAction");
			QueryCriteriaItem linenItemCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem requestNumCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem operFacilityIdCriteriaIetm = new QueryCriteriaItem();

			linenItemCriteriaIetm.setItemValue(((LoanLinenMainVO) valueObject)
					.getLoanLinenVO().getLinenItem().trim());
			linenItemCriteriaIetm.setProperty("linenItem");

			requestNumCriteriaIetm.setItemValue(((LoanLinenMainVO) valueObject)
					.getLoanLinenVO().getLoanRefNum().trim());
			requestNumCriteriaIetm.setProperty("loanRefNum");
			try {
				operFacilityIdCriteriaIetm
						.setItemValue(((LoanLinenMainVO) valueObject)
								.getLoanLinenVO().getAddedFacilityId());
				operFacilityIdCriteriaIetm.setProperty("operatingfacilityId");
			} catch (Exception e) {
			}
			criteriaVo.getCriteriaItems().add(linenItemCriteriaIetm);
			criteriaVo.getCriteriaItems().add(requestNumCriteriaIetm);
			criteriaVo.getCriteriaItems().add(operFacilityIdCriteriaIetm);

			qryResultVO.setCriteriaVo(criteriaVo);
			Page page = new Page();
			page.setPagingEnabled(false);
			qryResultVO.setPage(page);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			valueObject = setDefaultSet((AppVO) valueObject, request);
			try {
				dto = ((AppDelegator) getDelegator())
						.queryTypeMaster(qryResultVO);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
			dto.setTarget("ViewLoan");
		}
		return dto;
	}

	public Object getLoanRefNum(HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanRefNum");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		return reqNoMap;
	}

	public Object getLoan(String languageId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		 Map ValueMap = new HashMap();
		Map lookupParams = new HashMap();
		Page page = new Page();
		page.setPagingEnabled(false);
		 ValueMap.put("language_Id", languageId);
		lookUpVo.setLookupParameters(ValueMap);
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanReason");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return reqNoMap;
	}

}
