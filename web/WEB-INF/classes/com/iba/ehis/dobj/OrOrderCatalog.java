/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.*;

// Referenced classes of package com.iba.ehis.dobj:
//            OrOrderFormatHdr, OrOrderCategory, OrOrderType, OrConsentForm

public class OrOrderCatalog
    implements Serializable
{

    public OrOrderCatalog()
    {
        orCatalogConsentDtls = new HashSet(0);
        phTdmAttrDtls = new HashSet(0);
        orOrderSetComponents = new HashSet(0);
        orOrderCatalogPrepsInstrns = new HashSet(0);
        orOrderablesForDeptlocs = new HashSet(0);
        amCatalogForSpecialities = new HashSet(0);
        orConsentRefDtls = new HashSet(0);
        orOrderCatalogByTypes = new HashSet(0);
        orOrderLineTdmDtls = new HashSet(0);
        prWaitLists = new HashSet(0);
        orOrderCatalogReplsForOrderCatalogCode = new HashSet(0);
        orOrderCatalogProcLinks = new HashSet(0);
        dsDietTypes = new HashSet(0);
        orOrderCatalogByIndexes = new HashSet(0);
        orOrderCatalogSynonyms = new HashSet(0);
        orOrderCatalogReplsForOrderCatalogCodeRepl = new HashSet(0);
    }

    public OrOrderCatalog(String orderCatalogCode, OrOrderCategory orOrderCategory, OrOrderType orOrderType, String longDesc, String shortDesc, String consentReqdYn, String promptAlertYn, 
            String qtyReqdYn, String splitDoseYn, String taperDoseYn, String freqApplicableYn, String softStopYn, String contOrderYn, String refillContOrderYn, 
            String chkForDuplYn, String apptReqdYn, String patInstrnAgeSexYn, String deptOnlyYn, String completeOnOrderYn, String billYn, String resultApplicableYn, 
            String resultAuthReqdYn, String indexedYn, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, 
            String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String statApptReqdYn, String urgentApptReqdYn, String routineApptReqdYn)
    {
        orCatalogConsentDtls = new HashSet(0);
        phTdmAttrDtls = new HashSet(0);
        orOrderSetComponents = new HashSet(0);
        orOrderCatalogPrepsInstrns = new HashSet(0);
        orOrderablesForDeptlocs = new HashSet(0);
        amCatalogForSpecialities = new HashSet(0);
        orConsentRefDtls = new HashSet(0);
        orOrderCatalogByTypes = new HashSet(0);
        orOrderLineTdmDtls = new HashSet(0);
        prWaitLists = new HashSet(0);
        orOrderCatalogReplsForOrderCatalogCode = new HashSet(0);
        orOrderCatalogProcLinks = new HashSet(0);
        dsDietTypes = new HashSet(0);
        orOrderCatalogByIndexes = new HashSet(0);
        orOrderCatalogSynonyms = new HashSet(0);
        orOrderCatalogReplsForOrderCatalogCodeRepl = new HashSet(0);
        this.orderCatalogCode = orderCatalogCode;
        this.orOrderCategory = orOrderCategory;
        this.orOrderType = orOrderType;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.consentReqdYn = consentReqdYn;
        this.promptAlertYn = promptAlertYn;
        this.qtyReqdYn = qtyReqdYn;
        this.splitDoseYn = splitDoseYn;
        this.taperDoseYn = taperDoseYn;
        this.freqApplicableYn = freqApplicableYn;
        this.softStopYn = softStopYn;
        this.contOrderYn = contOrderYn;
        this.refillContOrderYn = refillContOrderYn;
        this.chkForDuplYn = chkForDuplYn;
        this.apptReqdYn = apptReqdYn;
        this.patInstrnAgeSexYn = patInstrnAgeSexYn;
        this.deptOnlyYn = deptOnlyYn;
        this.completeOnOrderYn = completeOnOrderYn;
        this.billYn = billYn;
        this.resultApplicableYn = resultApplicableYn;
        this.resultAuthReqdYn = resultAuthReqdYn;
        this.indexedYn = indexedYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.statApptReqdYn = statApptReqdYn;
        this.urgentApptReqdYn = urgentApptReqdYn;
        this.routineApptReqdYn = routineApptReqdYn;
    }

    public OrOrderCatalog(String orderCatalogCode, OrOrderFormatHdr orOrderFormatHdrByCommentFormatId, OrOrderCategory orOrderCategory, OrOrderType orOrderType, OrOrderFormatHdr orOrderFormatHdrByFieldFormatId, OrConsentForm orConsentForm, String longDesc, 
            String shortDesc, String securityLevel, String orderCatalogNature, String consentReqdYn, String promptAlertYn, String promptAlertMsg, String qtyReqdYn, 
            String qtyUom, String splitDoseYn, String taperDoseYn, String freqApplicableYn, String softStopYn, String contOrderYn, String refillContOrderYn, 
            String continuousFreqOrder, String chkForDuplYn, String chkForDuplStatus, String chkForDuplAheadAction, Long chkForDuplAheadPeriod, String chkForDuplAheadUnit, String chkForDuplBehindAction, 
            Long chkForDuplBehindPeriod, String chkForDuplBehindUnit, String ordAuthLevel, String ordCosignLevel, String ordSplApprLevel, String apptReqdYn, Date apptTime, 
            String patInstrnAgeSexYn, String deptOnlyYn, String completeOnOrderYn, String billYn, String resultApplicableYn, String resultAuthReqdYn, String chartResultType, 
            String discrMsrPanelId, String contrModId, String contrMsrPanelId, String imageLinkId, String indexedYn, String effStatus, String addedById, 
            Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, 
            String taperUp, String applSlidingScaleYn, Long statTurnAroundTime, String statTurnAroundType, Long urgentTurnAroundTime, String urgentTurnAroundType, Long routineTurnAroundTime, 
            String routineTurnAroundType, String confidentialYn, String priorityAppl, String activityType, String checkForDuplLevel, String dischargeIndicator, String statApptReqdYn, 
            String urgentApptReqdYn, String routineApptReqdYn, String ivPrepYn, String consentStage, String routineChkForDuplYn, String urgentChkForDuplYn, String statChkForDuplYn, 
            Long apptPrepTime, String apptPrepTimeType, String apptActionForPrep, String chargeTypeApplicable, String procLinkApplicable, String procLinkResultingOption, String explanatoryText, 
            String refusalFormId, String termSetId, String termCode, String procCodingScheme, String autoReportYn, String consentFormList, Long numOfConsentReqBo, 
            Long numOfConsentReqBr, Set orCatalogConsentDtls, Set phTdmAttrDtls, Set orOrderSetComponents, Set orOrderCatalogPrepsInstrns, Set orOrderablesForDeptlocs, Set amCatalogForSpecialities, 
            Set orConsentRefDtls, Set orOrderCatalogByTypes, Set orOrderLineTdmDtls, Set prWaitLists, Set orOrderCatalogReplsForOrderCatalogCode, Set orOrderCatalogProcLinks, Set dsDietTypes, 
            Set orOrderCatalogByIndexes, Set orOrderCatalogSynonyms, Set orOrderCatalogReplsForOrderCatalogCodeRepl)
    {
        this.orCatalogConsentDtls = new HashSet(0);
        this.phTdmAttrDtls = new HashSet(0);
        this.orOrderSetComponents = new HashSet(0);
        this.orOrderCatalogPrepsInstrns = new HashSet(0);
        this.orOrderablesForDeptlocs = new HashSet(0);
        this.amCatalogForSpecialities = new HashSet(0);
        this.orConsentRefDtls = new HashSet(0);
        this.orOrderCatalogByTypes = new HashSet(0);
        this.orOrderLineTdmDtls = new HashSet(0);
        this.prWaitLists = new HashSet(0);
        this.orOrderCatalogReplsForOrderCatalogCode = new HashSet(0);
        this.orOrderCatalogProcLinks = new HashSet(0);
        this.dsDietTypes = new HashSet(0);
        this.orOrderCatalogByIndexes = new HashSet(0);
        this.orOrderCatalogSynonyms = new HashSet(0);
        this.orOrderCatalogReplsForOrderCatalogCodeRepl = new HashSet(0);
        this.orderCatalogCode = orderCatalogCode;
        this.orOrderFormatHdrByCommentFormatId = orOrderFormatHdrByCommentFormatId;
        this.orOrderCategory = orOrderCategory;
        this.orOrderType = orOrderType;
        this.orOrderFormatHdrByFieldFormatId = orOrderFormatHdrByFieldFormatId;
        this.orConsentForm = orConsentForm;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.securityLevel = securityLevel;
        this.orderCatalogNature = orderCatalogNature;
        this.consentReqdYn = consentReqdYn;
        this.promptAlertYn = promptAlertYn;
        this.promptAlertMsg = promptAlertMsg;
        this.qtyReqdYn = qtyReqdYn;
        this.qtyUom = qtyUom;
        this.splitDoseYn = splitDoseYn;
        this.taperDoseYn = taperDoseYn;
        this.freqApplicableYn = freqApplicableYn;
        this.softStopYn = softStopYn;
        this.contOrderYn = contOrderYn;
        this.refillContOrderYn = refillContOrderYn;
        this.continuousFreqOrder = continuousFreqOrder;
        this.chkForDuplYn = chkForDuplYn;
        this.chkForDuplStatus = chkForDuplStatus;
        this.chkForDuplAheadAction = chkForDuplAheadAction;
        this.chkForDuplAheadPeriod = chkForDuplAheadPeriod;
        this.chkForDuplAheadUnit = chkForDuplAheadUnit;
        this.chkForDuplBehindAction = chkForDuplBehindAction;
        this.chkForDuplBehindPeriod = chkForDuplBehindPeriod;
        this.chkForDuplBehindUnit = chkForDuplBehindUnit;
        this.ordAuthLevel = ordAuthLevel;
        this.ordCosignLevel = ordCosignLevel;
        this.ordSplApprLevel = ordSplApprLevel;
        this.apptReqdYn = apptReqdYn;
        this.apptTime = apptTime;
        this.patInstrnAgeSexYn = patInstrnAgeSexYn;
        this.deptOnlyYn = deptOnlyYn;
        this.completeOnOrderYn = completeOnOrderYn;
        this.billYn = billYn;
        this.resultApplicableYn = resultApplicableYn;
        this.resultAuthReqdYn = resultAuthReqdYn;
        this.chartResultType = chartResultType;
        this.discrMsrPanelId = discrMsrPanelId;
        this.contrModId = contrModId;
        this.contrMsrPanelId = contrMsrPanelId;
        this.imageLinkId = imageLinkId;
        this.indexedYn = indexedYn;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.taperUp = taperUp;
        this.applSlidingScaleYn = applSlidingScaleYn;
        this.statTurnAroundTime = statTurnAroundTime;
        this.statTurnAroundType = statTurnAroundType;
        this.urgentTurnAroundTime = urgentTurnAroundTime;
        this.urgentTurnAroundType = urgentTurnAroundType;
        this.routineTurnAroundTime = routineTurnAroundTime;
        this.routineTurnAroundType = routineTurnAroundType;
        this.confidentialYn = confidentialYn;
        this.priorityAppl = priorityAppl;
        this.activityType = activityType;
        this.checkForDuplLevel = checkForDuplLevel;
        this.dischargeIndicator = dischargeIndicator;
        this.statApptReqdYn = statApptReqdYn;
        this.urgentApptReqdYn = urgentApptReqdYn;
        this.routineApptReqdYn = routineApptReqdYn;
        this.ivPrepYn = ivPrepYn;
        this.consentStage = consentStage;
        this.routineChkForDuplYn = routineChkForDuplYn;
        this.urgentChkForDuplYn = urgentChkForDuplYn;
        this.statChkForDuplYn = statChkForDuplYn;
        this.apptPrepTime = apptPrepTime;
        this.apptPrepTimeType = apptPrepTimeType;
        this.apptActionForPrep = apptActionForPrep;
        this.chargeTypeApplicable = chargeTypeApplicable;
        this.procLinkApplicable = procLinkApplicable;
        this.procLinkResultingOption = procLinkResultingOption;
        this.explanatoryText = explanatoryText;
        this.refusalFormId = refusalFormId;
        this.termSetId = termSetId;
        this.termCode = termCode;
        this.procCodingScheme = procCodingScheme;
        this.autoReportYn = autoReportYn;
        this.consentFormList = consentFormList;
        this.numOfConsentReqBo = numOfConsentReqBo;
        this.numOfConsentReqBr = numOfConsentReqBr;
        this.orCatalogConsentDtls = orCatalogConsentDtls;
        this.phTdmAttrDtls = phTdmAttrDtls;
        this.orOrderSetComponents = orOrderSetComponents;
        this.orOrderCatalogPrepsInstrns = orOrderCatalogPrepsInstrns;
        this.orOrderablesForDeptlocs = orOrderablesForDeptlocs;
        this.amCatalogForSpecialities = amCatalogForSpecialities;
        this.orConsentRefDtls = orConsentRefDtls;
        this.orOrderCatalogByTypes = orOrderCatalogByTypes;
        this.orOrderLineTdmDtls = orOrderLineTdmDtls;
        this.prWaitLists = prWaitLists;
        this.orOrderCatalogReplsForOrderCatalogCode = orOrderCatalogReplsForOrderCatalogCode;
        this.orOrderCatalogProcLinks = orOrderCatalogProcLinks;
        this.dsDietTypes = dsDietTypes;
        this.orOrderCatalogByIndexes = orOrderCatalogByIndexes;
        this.orOrderCatalogSynonyms = orOrderCatalogSynonyms;
        this.orOrderCatalogReplsForOrderCatalogCodeRepl = orOrderCatalogReplsForOrderCatalogCodeRepl;
    }

    public String getOrderCatalogCode()
    {
        return orderCatalogCode;
    }

    public void setOrderCatalogCode(String orderCatalogCode)
    {
        this.orderCatalogCode = orderCatalogCode;
    }

    public OrOrderFormatHdr getOrOrderFormatHdrByCommentFormatId()
    {
        return orOrderFormatHdrByCommentFormatId;
    }

    public void setOrOrderFormatHdrByCommentFormatId(OrOrderFormatHdr orOrderFormatHdrByCommentFormatId)
    {
        this.orOrderFormatHdrByCommentFormatId = orOrderFormatHdrByCommentFormatId;
    }

    public OrOrderCategory getOrOrderCategory()
    {
        return orOrderCategory;
    }

    public void setOrOrderCategory(OrOrderCategory orOrderCategory)
    {
        this.orOrderCategory = orOrderCategory;
    }

    public OrOrderType getOrOrderType()
    {
        return orOrderType;
    }

    public void setOrOrderType(OrOrderType orOrderType)
    {
        this.orOrderType = orOrderType;
    }

    public OrOrderFormatHdr getOrOrderFormatHdrByFieldFormatId()
    {
        return orOrderFormatHdrByFieldFormatId;
    }

    public void setOrOrderFormatHdrByFieldFormatId(OrOrderFormatHdr orOrderFormatHdrByFieldFormatId)
    {
        this.orOrderFormatHdrByFieldFormatId = orOrderFormatHdrByFieldFormatId;
    }

    public OrConsentForm getOrConsentForm()
    {
        return orConsentForm;
    }

    public void setOrConsentForm(OrConsentForm orConsentForm)
    {
        this.orConsentForm = orConsentForm;
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String longDesc)
    {
        this.longDesc = longDesc;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc;
    }

    public String getSecurityLevel()
    {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel)
    {
        this.securityLevel = securityLevel;
    }

    public String getOrderCatalogNature()
    {
        return orderCatalogNature;
    }

    public void setOrderCatalogNature(String orderCatalogNature)
    {
        this.orderCatalogNature = orderCatalogNature;
    }

    public String getConsentReqdYn()
    {
        return consentReqdYn;
    }

    public void setConsentReqdYn(String consentReqdYn)
    {
        this.consentReqdYn = consentReqdYn;
    }

    public String getPromptAlertYn()
    {
        return promptAlertYn;
    }

    public void setPromptAlertYn(String promptAlertYn)
    {
        this.promptAlertYn = promptAlertYn;
    }

    public String getPromptAlertMsg()
    {
        return promptAlertMsg;
    }

    public void setPromptAlertMsg(String promptAlertMsg)
    {
        this.promptAlertMsg = promptAlertMsg;
    }

    public String getQtyReqdYn()
    {
        return qtyReqdYn;
    }

    public void setQtyReqdYn(String qtyReqdYn)
    {
        this.qtyReqdYn = qtyReqdYn;
    }

    public String getQtyUom()
    {
        return qtyUom;
    }

    public void setQtyUom(String qtyUom)
    {
        this.qtyUom = qtyUom;
    }

    public String getSplitDoseYn()
    {
        return splitDoseYn;
    }

    public void setSplitDoseYn(String splitDoseYn)
    {
        this.splitDoseYn = splitDoseYn;
    }

    public String getTaperDoseYn()
    {
        return taperDoseYn;
    }

    public void setTaperDoseYn(String taperDoseYn)
    {
        this.taperDoseYn = taperDoseYn;
    }

    public String getFreqApplicableYn()
    {
        return freqApplicableYn;
    }

    public void setFreqApplicableYn(String freqApplicableYn)
    {
        this.freqApplicableYn = freqApplicableYn;
    }

    public String getSoftStopYn()
    {
        return softStopYn;
    }

    public void setSoftStopYn(String softStopYn)
    {
        this.softStopYn = softStopYn;
    }

    public String getContOrderYn()
    {
        return contOrderYn;
    }

    public void setContOrderYn(String contOrderYn)
    {
        this.contOrderYn = contOrderYn;
    }

    public String getRefillContOrderYn()
    {
        return refillContOrderYn;
    }

    public void setRefillContOrderYn(String refillContOrderYn)
    {
        this.refillContOrderYn = refillContOrderYn;
    }

    public String getContinuousFreqOrder()
    {
        return continuousFreqOrder;
    }

    public void setContinuousFreqOrder(String continuousFreqOrder)
    {
        this.continuousFreqOrder = continuousFreqOrder;
    }

    public String getChkForDuplYn()
    {
        return chkForDuplYn;
    }

    public void setChkForDuplYn(String chkForDuplYn)
    {
        this.chkForDuplYn = chkForDuplYn;
    }

    public String getChkForDuplStatus()
    {
        return chkForDuplStatus;
    }

    public void setChkForDuplStatus(String chkForDuplStatus)
    {
        this.chkForDuplStatus = chkForDuplStatus;
    }

    public String getChkForDuplAheadAction()
    {
        return chkForDuplAheadAction;
    }

    public void setChkForDuplAheadAction(String chkForDuplAheadAction)
    {
        this.chkForDuplAheadAction = chkForDuplAheadAction;
    }

    public Long getChkForDuplAheadPeriod()
    {
        return chkForDuplAheadPeriod;
    }

    public void setChkForDuplAheadPeriod(Long chkForDuplAheadPeriod)
    {
        this.chkForDuplAheadPeriod = chkForDuplAheadPeriod;
    }

    public String getChkForDuplAheadUnit()
    {
        return chkForDuplAheadUnit;
    }

    public void setChkForDuplAheadUnit(String chkForDuplAheadUnit)
    {
        this.chkForDuplAheadUnit = chkForDuplAheadUnit;
    }

    public String getChkForDuplBehindAction()
    {
        return chkForDuplBehindAction;
    }

    public void setChkForDuplBehindAction(String chkForDuplBehindAction)
    {
        this.chkForDuplBehindAction = chkForDuplBehindAction;
    }

    public Long getChkForDuplBehindPeriod()
    {
        return chkForDuplBehindPeriod;
    }

    public void setChkForDuplBehindPeriod(Long chkForDuplBehindPeriod)
    {
        this.chkForDuplBehindPeriod = chkForDuplBehindPeriod;
    }

    public String getChkForDuplBehindUnit()
    {
        return chkForDuplBehindUnit;
    }

    public void setChkForDuplBehindUnit(String chkForDuplBehindUnit)
    {
        this.chkForDuplBehindUnit = chkForDuplBehindUnit;
    }

    public String getOrdAuthLevel()
    {
        return ordAuthLevel;
    }

    public void setOrdAuthLevel(String ordAuthLevel)
    {
        this.ordAuthLevel = ordAuthLevel;
    }

    public String getOrdCosignLevel()
    {
        return ordCosignLevel;
    }

    public void setOrdCosignLevel(String ordCosignLevel)
    {
        this.ordCosignLevel = ordCosignLevel;
    }

    public String getOrdSplApprLevel()
    {
        return ordSplApprLevel;
    }

    public void setOrdSplApprLevel(String ordSplApprLevel)
    {
        this.ordSplApprLevel = ordSplApprLevel;
    }

    public String getApptReqdYn()
    {
        return apptReqdYn;
    }

    public void setApptReqdYn(String apptReqdYn)
    {
        this.apptReqdYn = apptReqdYn;
    }

    public Date getApptTime()
    {
        return apptTime;
    }

    public void setApptTime(Date apptTime)
    {
        this.apptTime = apptTime;
    }

    public String getPatInstrnAgeSexYn()
    {
        return patInstrnAgeSexYn;
    }

    public void setPatInstrnAgeSexYn(String patInstrnAgeSexYn)
    {
        this.patInstrnAgeSexYn = patInstrnAgeSexYn;
    }

    public String getDeptOnlyYn()
    {
        return deptOnlyYn;
    }

    public void setDeptOnlyYn(String deptOnlyYn)
    {
        this.deptOnlyYn = deptOnlyYn;
    }

    public String getCompleteOnOrderYn()
    {
        return completeOnOrderYn;
    }

    public void setCompleteOnOrderYn(String completeOnOrderYn)
    {
        this.completeOnOrderYn = completeOnOrderYn;
    }

    public String getBillYn()
    {
        return billYn;
    }

    public void setBillYn(String billYn)
    {
        this.billYn = billYn;
    }

    public String getResultApplicableYn()
    {
        return resultApplicableYn;
    }

    public void setResultApplicableYn(String resultApplicableYn)
    {
        this.resultApplicableYn = resultApplicableYn;
    }

    public String getResultAuthReqdYn()
    {
        return resultAuthReqdYn;
    }

    public void setResultAuthReqdYn(String resultAuthReqdYn)
    {
        this.resultAuthReqdYn = resultAuthReqdYn;
    }

    public String getChartResultType()
    {
        return chartResultType;
    }

    public void setChartResultType(String chartResultType)
    {
        this.chartResultType = chartResultType;
    }

    public String getDiscrMsrPanelId()
    {
        return discrMsrPanelId;
    }

    public void setDiscrMsrPanelId(String discrMsrPanelId)
    {
        this.discrMsrPanelId = discrMsrPanelId;
    }

    public String getContrModId()
    {
        return contrModId;
    }

    public void setContrModId(String contrModId)
    {
        this.contrModId = contrModId;
    }

    public String getContrMsrPanelId()
    {
        return contrMsrPanelId;
    }

    public void setContrMsrPanelId(String contrMsrPanelId)
    {
        this.contrMsrPanelId = contrMsrPanelId;
    }

    public String getImageLinkId()
    {
        return imageLinkId;
    }

    public void setImageLinkId(String imageLinkId)
    {
        this.imageLinkId = imageLinkId;
    }

    public String getIndexedYn()
    {
        return indexedYn;
    }

    public void setIndexedYn(String indexedYn)
    {
        this.indexedYn = indexedYn;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String effStatus)
    {
        this.effStatus = effStatus;
    }

    public String getAddedById()
    {
        return addedById;
    }

    public void setAddedById(String addedById)
    {
        this.addedById = addedById;
    }

    public Date getAddedDate()
    {
        return addedDate;
    }

    public void setAddedDate(Date addedDate)
    {
        this.addedDate = addedDate;
    }

    public String getAddedAtWsNo()
    {
        return addedAtWsNo;
    }

    public void setAddedAtWsNo(String addedAtWsNo)
    {
        this.addedAtWsNo = addedAtWsNo;
    }

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String addedFacilityId)
    {
        this.addedFacilityId = addedFacilityId;
    }

    public String getModifiedById()
    {
        return modifiedById;
    }

    public void setModifiedById(String modifiedById)
    {
        this.modifiedById = modifiedById;
    }

    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String modifiedAtWsNo)
    {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String modifiedFacilityId)
    {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getTaperUp()
    {
        return taperUp;
    }

    public void setTaperUp(String taperUp)
    {
        this.taperUp = taperUp;
    }

    public String getApplSlidingScaleYn()
    {
        return applSlidingScaleYn;
    }

    public void setApplSlidingScaleYn(String applSlidingScaleYn)
    {
        this.applSlidingScaleYn = applSlidingScaleYn;
    }

    public Long getStatTurnAroundTime()
    {
        return statTurnAroundTime;
    }

    public void setStatTurnAroundTime(Long statTurnAroundTime)
    {
        this.statTurnAroundTime = statTurnAroundTime;
    }

    public String getStatTurnAroundType()
    {
        return statTurnAroundType;
    }

    public void setStatTurnAroundType(String statTurnAroundType)
    {
        this.statTurnAroundType = statTurnAroundType;
    }

    public Long getUrgentTurnAroundTime()
    {
        return urgentTurnAroundTime;
    }

    public void setUrgentTurnAroundTime(Long urgentTurnAroundTime)
    {
        this.urgentTurnAroundTime = urgentTurnAroundTime;
    }

    public String getUrgentTurnAroundType()
    {
        return urgentTurnAroundType;
    }

    public void setUrgentTurnAroundType(String urgentTurnAroundType)
    {
        this.urgentTurnAroundType = urgentTurnAroundType;
    }

    public Long getRoutineTurnAroundTime()
    {
        return routineTurnAroundTime;
    }

    public void setRoutineTurnAroundTime(Long routineTurnAroundTime)
    {
        this.routineTurnAroundTime = routineTurnAroundTime;
    }

    public String getRoutineTurnAroundType()
    {
        return routineTurnAroundType;
    }

    public void setRoutineTurnAroundType(String routineTurnAroundType)
    {
        this.routineTurnAroundType = routineTurnAroundType;
    }

    public String getConfidentialYn()
    {
        return confidentialYn;
    }

    public void setConfidentialYn(String confidentialYn)
    {
        this.confidentialYn = confidentialYn;
    }

    public String getPriorityAppl()
    {
        return priorityAppl;
    }

    public void setPriorityAppl(String priorityAppl)
    {
        this.priorityAppl = priorityAppl;
    }

    public String getActivityType()
    {
        return activityType;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public String getCheckForDuplLevel()
    {
        return checkForDuplLevel;
    }

    public void setCheckForDuplLevel(String checkForDuplLevel)
    {
        this.checkForDuplLevel = checkForDuplLevel;
    }

    public String getDischargeIndicator()
    {
        return dischargeIndicator;
    }

    public void setDischargeIndicator(String dischargeIndicator)
    {
        this.dischargeIndicator = dischargeIndicator;
    }

    public String getStatApptReqdYn()
    {
        return statApptReqdYn;
    }

    public void setStatApptReqdYn(String statApptReqdYn)
    {
        this.statApptReqdYn = statApptReqdYn;
    }

    public String getUrgentApptReqdYn()
    {
        return urgentApptReqdYn;
    }

    public void setUrgentApptReqdYn(String urgentApptReqdYn)
    {
        this.urgentApptReqdYn = urgentApptReqdYn;
    }

    public String getRoutineApptReqdYn()
    {
        return routineApptReqdYn;
    }

    public void setRoutineApptReqdYn(String routineApptReqdYn)
    {
        this.routineApptReqdYn = routineApptReqdYn;
    }

    public String getIvPrepYn()
    {
        return ivPrepYn;
    }

    public void setIvPrepYn(String ivPrepYn)
    {
        this.ivPrepYn = ivPrepYn;
    }

    public String getConsentStage()
    {
        return consentStage;
    }

    public void setConsentStage(String consentStage)
    {
        this.consentStage = consentStage;
    }

    public String getRoutineChkForDuplYn()
    {
        return routineChkForDuplYn;
    }

    public void setRoutineChkForDuplYn(String routineChkForDuplYn)
    {
        this.routineChkForDuplYn = routineChkForDuplYn;
    }

    public String getUrgentChkForDuplYn()
    {
        return urgentChkForDuplYn;
    }

    public void setUrgentChkForDuplYn(String urgentChkForDuplYn)
    {
        this.urgentChkForDuplYn = urgentChkForDuplYn;
    }

    public String getStatChkForDuplYn()
    {
        return statChkForDuplYn;
    }

    public void setStatChkForDuplYn(String statChkForDuplYn)
    {
        this.statChkForDuplYn = statChkForDuplYn;
    }

    public Long getApptPrepTime()
    {
        return apptPrepTime;
    }

    public void setApptPrepTime(Long apptPrepTime)
    {
        this.apptPrepTime = apptPrepTime;
    }

    public String getApptPrepTimeType()
    {
        return apptPrepTimeType;
    }

    public void setApptPrepTimeType(String apptPrepTimeType)
    {
        this.apptPrepTimeType = apptPrepTimeType;
    }

    public String getApptActionForPrep()
    {
        return apptActionForPrep;
    }

    public void setApptActionForPrep(String apptActionForPrep)
    {
        this.apptActionForPrep = apptActionForPrep;
    }

    public String getChargeTypeApplicable()
    {
        return chargeTypeApplicable;
    }

    public void setChargeTypeApplicable(String chargeTypeApplicable)
    {
        this.chargeTypeApplicable = chargeTypeApplicable;
    }

    public String getProcLinkApplicable()
    {
        return procLinkApplicable;
    }

    public void setProcLinkApplicable(String procLinkApplicable)
    {
        this.procLinkApplicable = procLinkApplicable;
    }

    public String getProcLinkResultingOption()
    {
        return procLinkResultingOption;
    }

    public void setProcLinkResultingOption(String procLinkResultingOption)
    {
        this.procLinkResultingOption = procLinkResultingOption;
    }

    public String getExplanatoryText()
    {
        return explanatoryText;
    }

    public void setExplanatoryText(String explanatoryText)
    {
        this.explanatoryText = explanatoryText;
    }

    public String getRefusalFormId()
    {
        return refusalFormId;
    }

    public void setRefusalFormId(String refusalFormId)
    {
        this.refusalFormId = refusalFormId;
    }

    public String getTermSetId()
    {
        return termSetId;
    }

    public void setTermSetId(String termSetId)
    {
        this.termSetId = termSetId;
    }

    public String getTermCode()
    {
        return termCode;
    }

    public void setTermCode(String termCode)
    {
        this.termCode = termCode;
    }

    public String getProcCodingScheme()
    {
        return procCodingScheme;
    }

    public void setProcCodingScheme(String procCodingScheme)
    {
        this.procCodingScheme = procCodingScheme;
    }

    public String getAutoReportYn()
    {
        return autoReportYn;
    }

    public void setAutoReportYn(String autoReportYn)
    {
        this.autoReportYn = autoReportYn;
    }

    public String getConsentFormList()
    {
        return consentFormList;
    }

    public void setConsentFormList(String consentFormList)
    {
        this.consentFormList = consentFormList;
    }

    public Long getNumOfConsentReqBo()
    {
        return numOfConsentReqBo;
    }

    public void setNumOfConsentReqBo(Long numOfConsentReqBo)
    {
        this.numOfConsentReqBo = numOfConsentReqBo;
    }

    public Long getNumOfConsentReqBr()
    {
        return numOfConsentReqBr;
    }

    public void setNumOfConsentReqBr(Long numOfConsentReqBr)
    {
        this.numOfConsentReqBr = numOfConsentReqBr;
    }

    public Set getOrCatalogConsentDtls()
    {
        return orCatalogConsentDtls;
    }

    public void setOrCatalogConsentDtls(Set orCatalogConsentDtls)
    {
        this.orCatalogConsentDtls = orCatalogConsentDtls;
    }

    public Set getPhTdmAttrDtls()
    {
        return phTdmAttrDtls;
    }

    public void setPhTdmAttrDtls(Set phTdmAttrDtls)
    {
        this.phTdmAttrDtls = phTdmAttrDtls;
    }

    public Set getOrOrderSetComponents()
    {
        return orOrderSetComponents;
    }

    public void setOrOrderSetComponents(Set orOrderSetComponents)
    {
        this.orOrderSetComponents = orOrderSetComponents;
    }

    public Set getOrOrderCatalogPrepsInstrns()
    {
        return orOrderCatalogPrepsInstrns;
    }

    public void setOrOrderCatalogPrepsInstrns(Set orOrderCatalogPrepsInstrns)
    {
        this.orOrderCatalogPrepsInstrns = orOrderCatalogPrepsInstrns;
    }

    public Set getOrOrderablesForDeptlocs()
    {
        return orOrderablesForDeptlocs;
    }

    public void setOrOrderablesForDeptlocs(Set orOrderablesForDeptlocs)
    {
        this.orOrderablesForDeptlocs = orOrderablesForDeptlocs;
    }

    public Set getAmCatalogForSpecialities()
    {
        return amCatalogForSpecialities;
    }

    public void setAmCatalogForSpecialities(Set amCatalogForSpecialities)
    {
        this.amCatalogForSpecialities = amCatalogForSpecialities;
    }

    public Set getOrConsentRefDtls()
    {
        return orConsentRefDtls;
    }

    public void setOrConsentRefDtls(Set orConsentRefDtls)
    {
        this.orConsentRefDtls = orConsentRefDtls;
    }

    public Set getOrOrderCatalogByTypes()
    {
        return orOrderCatalogByTypes;
    }

    public void setOrOrderCatalogByTypes(Set orOrderCatalogByTypes)
    {
        this.orOrderCatalogByTypes = orOrderCatalogByTypes;
    }

    public Set getOrOrderLineTdmDtls()
    {
        return orOrderLineTdmDtls;
    }

    public void setOrOrderLineTdmDtls(Set orOrderLineTdmDtls)
    {
        this.orOrderLineTdmDtls = orOrderLineTdmDtls;
    }

    public Set getPrWaitLists()
    {
        return prWaitLists;
    }

    public void setPrWaitLists(Set prWaitLists)
    {
        this.prWaitLists = prWaitLists;
    }

    public Set getOrOrderCatalogReplsForOrderCatalogCode()
    {
        return orOrderCatalogReplsForOrderCatalogCode;
    }

    public void setOrOrderCatalogReplsForOrderCatalogCode(Set orOrderCatalogReplsForOrderCatalogCode)
    {
        this.orOrderCatalogReplsForOrderCatalogCode = orOrderCatalogReplsForOrderCatalogCode;
    }

    public Set getOrOrderCatalogProcLinks()
    {
        return orOrderCatalogProcLinks;
    }

    public void setOrOrderCatalogProcLinks(Set orOrderCatalogProcLinks)
    {
        this.orOrderCatalogProcLinks = orOrderCatalogProcLinks;
    }

    public Set getDsDietTypes()
    {
        return dsDietTypes;
    }

    public void setDsDietTypes(Set dsDietTypes)
    {
        this.dsDietTypes = dsDietTypes;
    }

    public Set getOrOrderCatalogByIndexes()
    {
        return orOrderCatalogByIndexes;
    }

    public void setOrOrderCatalogByIndexes(Set orOrderCatalogByIndexes)
    {
        this.orOrderCatalogByIndexes = orOrderCatalogByIndexes;
    }

    public Set getOrOrderCatalogSynonyms()
    {
        return orOrderCatalogSynonyms;
    }

    public void setOrOrderCatalogSynonyms(Set orOrderCatalogSynonyms)
    {
        this.orOrderCatalogSynonyms = orOrderCatalogSynonyms;
    }

    public Set getOrOrderCatalogReplsForOrderCatalogCodeRepl()
    {
        return orOrderCatalogReplsForOrderCatalogCodeRepl;
    }

    public void setOrOrderCatalogReplsForOrderCatalogCodeRepl(Set orOrderCatalogReplsForOrderCatalogCodeRepl)
    {
        this.orOrderCatalogReplsForOrderCatalogCodeRepl = orOrderCatalogReplsForOrderCatalogCodeRepl;
    }

    private String orderCatalogCode;
    private OrOrderFormatHdr orOrderFormatHdrByCommentFormatId;
    private OrOrderCategory orOrderCategory;
    private OrOrderType orOrderType;
    private OrOrderFormatHdr orOrderFormatHdrByFieldFormatId;
    private OrConsentForm orConsentForm;
    private String longDesc;
    private String shortDesc;
    private String securityLevel;
    private String orderCatalogNature;
    private String consentReqdYn;
    private String promptAlertYn;
    private String promptAlertMsg;
    private String qtyReqdYn;
    private String qtyUom;
    private String splitDoseYn;
    private String taperDoseYn;
    private String freqApplicableYn;
    private String softStopYn;
    private String contOrderYn;
    private String refillContOrderYn;
    private String continuousFreqOrder;
    private String chkForDuplYn;
    private String chkForDuplStatus;
    private String chkForDuplAheadAction;
    private Long chkForDuplAheadPeriod;
    private String chkForDuplAheadUnit;
    private String chkForDuplBehindAction;
    private Long chkForDuplBehindPeriod;
    private String chkForDuplBehindUnit;
    private String ordAuthLevel;
    private String ordCosignLevel;
    private String ordSplApprLevel;
    private String apptReqdYn;
    private Date apptTime;
    private String patInstrnAgeSexYn;
    private String deptOnlyYn;
    private String completeOnOrderYn;
    private String billYn;
    private String resultApplicableYn;
    private String resultAuthReqdYn;
    private String chartResultType;
    private String discrMsrPanelId;
    private String contrModId;
    private String contrMsrPanelId;
    private String imageLinkId;
    private String indexedYn;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String taperUp;
    private String applSlidingScaleYn;
    private Long statTurnAroundTime;
    private String statTurnAroundType;
    private Long urgentTurnAroundTime;
    private String urgentTurnAroundType;
    private Long routineTurnAroundTime;
    private String routineTurnAroundType;
    private String confidentialYn;
    private String priorityAppl;
    private String activityType;
    private String checkForDuplLevel;
    private String dischargeIndicator;
    private String statApptReqdYn;
    private String urgentApptReqdYn;
    private String routineApptReqdYn;
    private String ivPrepYn;
    private String consentStage;
    private String routineChkForDuplYn;
    private String urgentChkForDuplYn;
    private String statChkForDuplYn;
    private Long apptPrepTime;
    private String apptPrepTimeType;
    private String apptActionForPrep;
    private String chargeTypeApplicable;
    private String procLinkApplicable;
    private String procLinkResultingOption;
    private String explanatoryText;
    private String refusalFormId;
    private String termSetId;
    private String termCode;
    private String procCodingScheme;
    private String autoReportYn;
    private String consentFormList;
    private Long numOfConsentReqBo;
    private Long numOfConsentReqBr;
    private Set orCatalogConsentDtls;
    private Set phTdmAttrDtls;
    private Set orOrderSetComponents;
    private Set orOrderCatalogPrepsInstrns;
    private Set orOrderablesForDeptlocs;
    private Set amCatalogForSpecialities;
    private Set orConsentRefDtls;
    private Set orOrderCatalogByTypes;
    private Set orOrderLineTdmDtls;
    private Set prWaitLists;
    private Set orOrderCatalogReplsForOrderCatalogCode;
    private Set orOrderCatalogProcLinks;
    private Set dsDietTypes;
    private Set orOrderCatalogByIndexes;
    private Set orOrderCatalogSynonyms;
    private Set orOrderCatalogReplsForOrderCatalogCodeRepl;
}
