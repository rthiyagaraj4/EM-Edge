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
package com.iba.ehis.lc.standardStock.pojo.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.pojo.business.*;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.linenItem.vo.LinenItemVO;
import com.iba.ehis.lc.reason.vo.ReasonVO;
import com.iba.ehis.lc.standardStock.vo.StandardStockVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author yadavk
 */
public class StandardStockAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		DTO dto = new DTO();
		valueObject = setDefaultSet((AppVO) valueObject, request);
		((StandardStockVO) valueObject)
				.setAddedFacilityId(((AppVO) valueObject).getAddedFacilityId());
		try {
			dto = ((AppDelegator) getDelegator())
					.createTypeMaster((StandardStockVO) valueObject);
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
					"StandardStockAction-----Failure----->", null);
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
				"StandardStockAction-----1----->doActionDelete()", null);
		DTO dto = ((AppDelegator) getDelegator())
				.deleteTypeMaster((StandardStockVO) valueObject);
		IBALogger.getLogger().debug(this.getClass(),
				"StandardStockAction-----2----->doActionDelete() ", null);
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
		DTO dto = new DTO();

		dto = ((AppDelegator) getDelegator())
				.updateTypeMaster((StandardStockVO) valueObject);

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
				"StandardStockAction---------->doPrePopulate ", null);
		DTO dto = new DTO();
		DTO dtoLookUp = new DTO();
		LookupVO lookUpVo = new LookupVO();
		valueObject = setDefaultSet((AppVO) valueObject, request);

		/* checks if the vo having null values */
		if (((StandardStockVO) valueObject).getSourceCode() == null) {
			valueObject = setDefaultSet((AppVO) valueObject, request);
			dto.setMode(Constants.CREATE); // sets tha mode as create
			dto.setObject(valueObject); // sets the valueobject to dto
			dto.setTarget("createPageStandardStock"); // sets the target page
														// to ceatePage
			dto.setStatus(Constants.SUCCESS); // sets the status as SUCCESS
		} else {
			IBALogger.getLogger().debug(this.getClass(),
					"StandardStockAction---------->doPrePopulate ----else",
					null);

			/*
			 * The logger will put the contents of Longdesc on the log file
			 */
			dto.setObject(((StandardStockVO) valueObject));
			((AppVO) dto.getObject())
					.setFunctionId(((StandardStockVO) valueObject)
							.getFunctionId());
			((AppVO) dto.getObject())
					.setModuleId(((StandardStockVO) valueObject).getModuleId());
			dto.setMode(Constants.UPDATE); // sets the Mode as UPDATE
			dto.setTarget("createPageStandardStock"); // sets the page target
														// to createPage
		}

		return dto;
	}

	private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request) {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		IBALogger.getLogger().debug(this.getClass(),
				"..............loadCriteria..........", null);
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		QueryCriteriaItem criteriaItemsourceType = new QueryCriteriaItem();
		criteriaItemsourceType.setBundleName("lcLabels");
		criteriaItemsourceType
				.setLabelKey("com.iba.ehis.lc.standardStock.sourceType");
		criteriaItemsourceType.setProperty("sourceType");
		criteriaItemsourceType.setLength(15);
		criteriaItemsourceType.setSize(15);
		criteriaItemsourceType.setType(QueryCriteriaConstants.SELECT_ITEM);
		// criteriaItemsourceType.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemsourceType);
		try {
			criteriaItemsourceType.addOption("com.iba.ehis.lc.selectforbutton", "",
					"lcLabels");
			criteriaItemsourceType.addOption("com.iba.ehis.lc.ward", "W",
					"lcLabels");
			criteriaItemsourceType.addOption("com.iba.ehis.lc.clinic", "C",
					"lcLabels");
			criteriaItemsourceType.addOption("com.iba.ehis.lc.department", "D",
					"lcLabels");
		} catch (Exception e) {
			e.printStackTrace();
		}

		QueryCriteriaItem criteriaItemSource = new QueryCriteriaItem();
		criteriaItemSource.setBundleName("lcLabels");
		criteriaItemSource.setLabelKey("com.iba.ehis.lc.standardStock.source");
		criteriaItemSource.setProperty("sourceCode");
		criteriaItemSource.setLength(15);
		criteriaItemSource.setSize(15);
		criteriaItemSource.setType(QueryCriteriaConstants.TEXT_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemSource);
		
		
		
		QueryCriteriaItem criteriaItemLanguageId = new QueryCriteriaItem();
		criteriaItemLanguageId.setItemValue((String)request.getSession().getAttribute("LOCALE"));
		criteriaItemLanguageId.setProperty("languageId");
		criteriaItemLanguageId.setType(QueryCriteriaConstants.HIDDEN_ITEM);
		queryCriteriaVO.getCriteriaItems().add(criteriaItemLanguageId);
			
		
		queryCriteriaVO.addOrderByCol(
				"com.iba.ehis.lc.standardStock.sourceType", "1", "lcLabels");
		queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.standardStock.source",
				"2", "lcLabels");

		queryCriteriaVO.setPageAction("StandardStockPageAction");
		queryCriteriaVO.setQueryResultPage("StandardStockQueryResultPage");
		valueObject = setDefaultSet((AppVO) valueObject, request);
		queryCriteriaVO.setFunctionId(((StandardStockVO) valueObject)
				.getFunctionId());
		queryCriteriaVO.setModuleId(((StandardStockVO) valueObject)
				.getModuleId());
		//queryCriteriaVO.setQueryCriteriaAction("/QueryAction");
		AppForm criteriaForm = new AppForm();
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("queryCriteriaPage");
		return dto;
	}

	public Map getAllStock(String sourceCode, String sourceType, String facilityId, String languageId, HttpServletRequest request)
    {
        DTO dto = new DTO();
        Map ValueMap = new HashMap();
        Map existingRec = new HashMap();
        LookupVO lookUpVo = new LookupVO();
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("StandardStockAction----code----->")).append(sourceCode).toString(), null);
        ValueMap.put("facilityId", facilityId);
        ValueMap.put("sourceCode", sourceCode);
        ValueMap.put("sourceType", sourceType);
        ValueMap.put("languageId", languageId);
        lookUpVo.setLookupParameters(ValueMap);
        lookUpVo.setQueryId("ehis.lc.standardStock.getStock");
      
      
        try
        {
            dto = ((LookupDelegate)getDelegatorById("lookupDelegator")).lookupUpQuery(lookUpVo, null, request.getSession().getId());
            existingRec = ((LookupVO)dto.getObject()).getLookupResults();
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId("APP_404");
        }
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("StandardStockAction-----getSource----->")).append(existingRec).toString(), null);
        return existingRec;
    }

    public Map getLinenItem(String languageId, HttpServletRequest request)
    {
        DTO dto = new DTO();
        Map ValueMap = new HashMap();
        Map existingRec = new HashMap();
        LookupVO lookUpVo = new LookupVO();
        IBALogger.getLogger().debug(getClass(), "StandardStockAction----1----->", null);
        ValueMap.put("languageId", languageId);
        lookUpVo.setLookupParameters(ValueMap);
        lookUpVo.setQueryId("ehis.lc.standardStock.linenItem");
        try
        {
            dto = ((LookupDelegate)getDelegatorById("lookupDelegator")).lookupUpQuery(lookUpVo, null, request.getSession().getId());
            existingRec = ((LookupVO)dto.getObject()).getLookupResults();
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId("APP_404");
        }
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("StandardStockAction-----getLinen----->")).append(existingRec).toString(), null);
        return existingRec;
    }

}
