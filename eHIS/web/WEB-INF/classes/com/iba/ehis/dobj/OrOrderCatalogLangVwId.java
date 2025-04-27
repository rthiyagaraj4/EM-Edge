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
import java.util.Date;

public class OrOrderCatalogLangVwId
    implements Serializable
{

    public OrOrderCatalogLangVwId()
    {
    }

    public OrOrderCatalogLangVwId(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, String s17, String s18, String s19, String s20, 
            String s21, String s22, String s23, String s24, String s25, String s26, String s27, 
            String s28, Date date, String s29, String s30, String s31, Date date1, String s32, 
            String s33)
    {
        orderCatalogCode = s;
        languageId = s1;
        longDesc = s2;
        shortDesc = s3;
        orderCategory = s4;
        orderTypeCode = s5;
        consentReqdYn = s6;
        promptAlertYn = s7;
        qtyReqdYn = s8;
        splitDoseYn = s9;
        taperDoseYn = s10;
        freqApplicableYn = s11;
        softStopYn = s12;
        contOrderYn = s13;
        refillContOrderYn = s14;
        chkForDuplYn = s15;
        apptReqdYn = s16;
        patInstrnAgeSexYn = s17;
        deptOnlyYn = s18;
        completeOnOrderYn = s19;
        billYn = s20;
        resultApplicableYn = s21;
        resultAuthReqdYn = s22;
        indexedYn = s23;
        statApptReqdYn = s24;
        urgentApptReqdYn = s25;
        routineApptReqdYn = s26;
        effStatus = s27;
        addedById = s28;
        addedDate = date;
        addedAtWsNo = s29;
        addedFacilityId = s30;
        modifiedById = s31;
        modifiedDate = date1;
        modifiedAtWsNo = s32;
        modifiedFacilityId = s33;
    }

    public OrOrderCatalogLangVwId(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, String s17, String s18, String s19, String s20, 
            String s21, String s22, String s23, String s24, String s25, String s26, Long long1, 
            String s27, String s28, Long long2, String s29, String s30, String s31, String s32, 
            String s33, Date date, String s34, String s35, String s36, String s37, String s38, 
            String s39, String s40, String s41, String s42, String s43, String s44, String s45, 
            String s46, String s47, String s48, Long long3, String s49, Long long4, String s50, 
            Long long5, String s51, String s52, String s53, String s54, String s55, String s56, 
            String s57, String s58, String s59, String s60, String s61, String s62, String s63, 
            String s64, Long long6, String s65, String s66, String s67, String s68, String s69, 
            String s70, String s71, String s72, String s73, String s74, String s75, String s76, 
            Date date1, String s77, String s78, String s79, Date date2, String s80, String s81)
    {
        orderCatalogCode = s;
        languageId = s1;
        ordby = s2;
        longDesc = s3;
        shortDesc = s4;
        orderCategory = s5;
        orderTypeCode = s6;
        securityLevel = s7;
        orderCatalogNature = s8;
        consentReqdYn = s9;
        consentFormId = s10;
        promptAlertYn = s11;
        promptAlertMsg = s12;
        qtyReqdYn = s13;
        qtyUom = s14;
        splitDoseYn = s15;
        taperDoseYn = s16;
        freqApplicableYn = s17;
        softStopYn = s18;
        contOrderYn = s19;
        refillContOrderYn = s20;
        continuousFreqOrder = s21;
        fieldFormatId = s22;
        commentFormatId = s23;
        chkForDuplYn = s24;
        chkForDuplStatus = s25;
        chkForDuplAheadAction = s26;
        chkForDuplAheadPeriod = long1;
        chkForDuplAheadUnit = s27;
        chkForDuplBehindAction = s28;
        chkForDuplBehindPeriod = long2;
        chkForDuplBehindUnit = s29;
        ordAuthLevel = s30;
        ordCosignLevel = s31;
        ordSplApprLevel = s32;
        apptReqdYn = s33;
        apptTime = date;
        patInstrnAgeSexYn = s34;
        deptOnlyYn = s35;
        completeOnOrderYn = s36;
        billYn = s37;
        resultApplicableYn = s38;
        resultAuthReqdYn = s39;
        chartResultType = s40;
        discrMsrPanelId = s41;
        contrModId = s42;
        contrMsrPanelId = s43;
        imageLinkId = s44;
        indexedYn = s45;
        priorityAppl = s46;
        activityType = s47;
        checkForDuplLevel = s48;
        statTurnAroundTime = long3;
        statTurnAroundType = s49;
        urgentTurnAroundTime = long4;
        urgentTurnAroundType = s50;
        routineTurnAroundTime = long5;
        routineTurnAroundType = s51;
        confidentialYn = s52;
        taperUp = s53;
        applSlidingScaleYn = s54;
        statApptReqdYn = s55;
        urgentApptReqdYn = s56;
        routineApptReqdYn = s57;
        ivPrepYn = s58;
        dischargeIndicator = s59;
        chargeTypeApplicable = s60;
        consentStage = s61;
        routineChkForDuplYn = s62;
        urgentChkForDuplYn = s63;
        statChkForDuplYn = s64;
        apptPrepTime = long6;
        apptPrepTimeType = s65;
        apptActionForPrep = s66;
        procLinkApplicable = s67;
        procLinkResultingOption = s68;
        explanatoryText = s69;
        refusalFormId = s70;
        effStatus = s71;
        termSetId = s72;
        termCode = s73;
        autoReportYn = s74;
        procCodingScheme = s75;
        addedById = s76;
        addedDate = date1;
        addedAtWsNo = s77;
        addedFacilityId = s78;
        modifiedById = s79;
        modifiedDate = date2;
        modifiedAtWsNo = s80;
        modifiedFacilityId = s81;
    }

    public String getOrderCatalogCode()
    {
        return orderCatalogCode;
    }

    public void setOrderCatalogCode(String s)
    {
        orderCatalogCode = s;
    }

    public String getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(String s)
    {
        languageId = s;
    }

    public String getOrdby()
    {
        return ordby;
    }

    public void setOrdby(String s)
    {
        ordby = s;
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String s)
    {
        longDesc = s;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String s)
    {
        shortDesc = s;
    }

    public String getOrderCategory()
    {
        return orderCategory;
    }

    public void setOrderCategory(String s)
    {
        orderCategory = s;
    }

    public String getOrderTypeCode()
    {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String s)
    {
        orderTypeCode = s;
    }

    public String getSecurityLevel()
    {
        return securityLevel;
    }

    public void setSecurityLevel(String s)
    {
        securityLevel = s;
    }

    public String getOrderCatalogNature()
    {
        return orderCatalogNature;
    }

    public void setOrderCatalogNature(String s)
    {
        orderCatalogNature = s;
    }

    public String getConsentReqdYn()
    {
        return consentReqdYn;
    }

    public void setConsentReqdYn(String s)
    {
        consentReqdYn = s;
    }

    public String getConsentFormId()
    {
        return consentFormId;
    }

    public void setConsentFormId(String s)
    {
        consentFormId = s;
    }

    public String getPromptAlertYn()
    {
        return promptAlertYn;
    }

    public void setPromptAlertYn(String s)
    {
        promptAlertYn = s;
    }

    public String getPromptAlertMsg()
    {
        return promptAlertMsg;
    }

    public void setPromptAlertMsg(String s)
    {
        promptAlertMsg = s;
    }

    public String getQtyReqdYn()
    {
        return qtyReqdYn;
    }

    public void setQtyReqdYn(String s)
    {
        qtyReqdYn = s;
    }

    public String getQtyUom()
    {
        return qtyUom;
    }

    public void setQtyUom(String s)
    {
        qtyUom = s;
    }

    public String getSplitDoseYn()
    {
        return splitDoseYn;
    }

    public void setSplitDoseYn(String s)
    {
        splitDoseYn = s;
    }

    public String getTaperDoseYn()
    {
        return taperDoseYn;
    }

    public void setTaperDoseYn(String s)
    {
        taperDoseYn = s;
    }

    public String getFreqApplicableYn()
    {
        return freqApplicableYn;
    }

    public void setFreqApplicableYn(String s)
    {
        freqApplicableYn = s;
    }

    public String getSoftStopYn()
    {
        return softStopYn;
    }

    public void setSoftStopYn(String s)
    {
        softStopYn = s;
    }

    public String getContOrderYn()
    {
        return contOrderYn;
    }

    public void setContOrderYn(String s)
    {
        contOrderYn = s;
    }

    public String getRefillContOrderYn()
    {
        return refillContOrderYn;
    }

    public void setRefillContOrderYn(String s)
    {
        refillContOrderYn = s;
    }

    public String getContinuousFreqOrder()
    {
        return continuousFreqOrder;
    }

    public void setContinuousFreqOrder(String s)
    {
        continuousFreqOrder = s;
    }

    public String getFieldFormatId()
    {
        return fieldFormatId;
    }

    public void setFieldFormatId(String s)
    {
        fieldFormatId = s;
    }

    public String getCommentFormatId()
    {
        return commentFormatId;
    }

    public void setCommentFormatId(String s)
    {
        commentFormatId = s;
    }

    public String getChkForDuplYn()
    {
        return chkForDuplYn;
    }

    public void setChkForDuplYn(String s)
    {
        chkForDuplYn = s;
    }

    public String getChkForDuplStatus()
    {
        return chkForDuplStatus;
    }

    public void setChkForDuplStatus(String s)
    {
        chkForDuplStatus = s;
    }

    public String getChkForDuplAheadAction()
    {
        return chkForDuplAheadAction;
    }

    public void setChkForDuplAheadAction(String s)
    {
        chkForDuplAheadAction = s;
    }

    public Long getChkForDuplAheadPeriod()
    {
        return chkForDuplAheadPeriod;
    }

    public void setChkForDuplAheadPeriod(Long long1)
    {
        chkForDuplAheadPeriod = long1;
    }

    public String getChkForDuplAheadUnit()
    {
        return chkForDuplAheadUnit;
    }

    public void setChkForDuplAheadUnit(String s)
    {
        chkForDuplAheadUnit = s;
    }

    public String getChkForDuplBehindAction()
    {
        return chkForDuplBehindAction;
    }

    public void setChkForDuplBehindAction(String s)
    {
        chkForDuplBehindAction = s;
    }

    public Long getChkForDuplBehindPeriod()
    {
        return chkForDuplBehindPeriod;
    }

    public void setChkForDuplBehindPeriod(Long long1)
    {
        chkForDuplBehindPeriod = long1;
    }

    public String getChkForDuplBehindUnit()
    {
        return chkForDuplBehindUnit;
    }

    public void setChkForDuplBehindUnit(String s)
    {
        chkForDuplBehindUnit = s;
    }

    public String getOrdAuthLevel()
    {
        return ordAuthLevel;
    }

    public void setOrdAuthLevel(String s)
    {
        ordAuthLevel = s;
    }

    public String getOrdCosignLevel()
    {
        return ordCosignLevel;
    }

    public void setOrdCosignLevel(String s)
    {
        ordCosignLevel = s;
    }

    public String getOrdSplApprLevel()
    {
        return ordSplApprLevel;
    }

    public void setOrdSplApprLevel(String s)
    {
        ordSplApprLevel = s;
    }

    public String getApptReqdYn()
    {
        return apptReqdYn;
    }

    public void setApptReqdYn(String s)
    {
        apptReqdYn = s;
    }

    public Date getApptTime()
    {
        return apptTime;
    }

    public void setApptTime(Date date)
    {
        apptTime = date;
    }

    public String getPatInstrnAgeSexYn()
    {
        return patInstrnAgeSexYn;
    }

    public void setPatInstrnAgeSexYn(String s)
    {
        patInstrnAgeSexYn = s;
    }

    public String getDeptOnlyYn()
    {
        return deptOnlyYn;
    }

    public void setDeptOnlyYn(String s)
    {
        deptOnlyYn = s;
    }

    public String getCompleteOnOrderYn()
    {
        return completeOnOrderYn;
    }

    public void setCompleteOnOrderYn(String s)
    {
        completeOnOrderYn = s;
    }

    public String getBillYn()
    {
        return billYn;
    }

    public void setBillYn(String s)
    {
        billYn = s;
    }

    public String getResultApplicableYn()
    {
        return resultApplicableYn;
    }

    public void setResultApplicableYn(String s)
    {
        resultApplicableYn = s;
    }

    public String getResultAuthReqdYn()
    {
        return resultAuthReqdYn;
    }

    public void setResultAuthReqdYn(String s)
    {
        resultAuthReqdYn = s;
    }

    public String getChartResultType()
    {
        return chartResultType;
    }

    public void setChartResultType(String s)
    {
        chartResultType = s;
    }

    public String getDiscrMsrPanelId()
    {
        return discrMsrPanelId;
    }

    public void setDiscrMsrPanelId(String s)
    {
        discrMsrPanelId = s;
    }

    public String getContrModId()
    {
        return contrModId;
    }

    public void setContrModId(String s)
    {
        contrModId = s;
    }

    public String getContrMsrPanelId()
    {
        return contrMsrPanelId;
    }

    public void setContrMsrPanelId(String s)
    {
        contrMsrPanelId = s;
    }

    public String getImageLinkId()
    {
        return imageLinkId;
    }

    public void setImageLinkId(String s)
    {
        imageLinkId = s;
    }

    public String getIndexedYn()
    {
        return indexedYn;
    }

    public void setIndexedYn(String s)
    {
        indexedYn = s;
    }

    public String getPriorityAppl()
    {
        return priorityAppl;
    }

    public void setPriorityAppl(String s)
    {
        priorityAppl = s;
    }

    public String getActivityType()
    {
        return activityType;
    }

    public void setActivityType(String s)
    {
        activityType = s;
    }

    public String getCheckForDuplLevel()
    {
        return checkForDuplLevel;
    }

    public void setCheckForDuplLevel(String s)
    {
        checkForDuplLevel = s;
    }

    public Long getStatTurnAroundTime()
    {
        return statTurnAroundTime;
    }

    public void setStatTurnAroundTime(Long long1)
    {
        statTurnAroundTime = long1;
    }

    public String getStatTurnAroundType()
    {
        return statTurnAroundType;
    }

    public void setStatTurnAroundType(String s)
    {
        statTurnAroundType = s;
    }

    public Long getUrgentTurnAroundTime()
    {
        return urgentTurnAroundTime;
    }

    public void setUrgentTurnAroundTime(Long long1)
    {
        urgentTurnAroundTime = long1;
    }

    public String getUrgentTurnAroundType()
    {
        return urgentTurnAroundType;
    }

    public void setUrgentTurnAroundType(String s)
    {
        urgentTurnAroundType = s;
    }

    public Long getRoutineTurnAroundTime()
    {
        return routineTurnAroundTime;
    }

    public void setRoutineTurnAroundTime(Long long1)
    {
        routineTurnAroundTime = long1;
    }

    public String getRoutineTurnAroundType()
    {
        return routineTurnAroundType;
    }

    public void setRoutineTurnAroundType(String s)
    {
        routineTurnAroundType = s;
    }

    public String getConfidentialYn()
    {
        return confidentialYn;
    }

    public void setConfidentialYn(String s)
    {
        confidentialYn = s;
    }

    public String getTaperUp()
    {
        return taperUp;
    }

    public void setTaperUp(String s)
    {
        taperUp = s;
    }

    public String getApplSlidingScaleYn()
    {
        return applSlidingScaleYn;
    }

    public void setApplSlidingScaleYn(String s)
    {
        applSlidingScaleYn = s;
    }

    public String getStatApptReqdYn()
    {
        return statApptReqdYn;
    }

    public void setStatApptReqdYn(String s)
    {
        statApptReqdYn = s;
    }

    public String getUrgentApptReqdYn()
    {
        return urgentApptReqdYn;
    }

    public void setUrgentApptReqdYn(String s)
    {
        urgentApptReqdYn = s;
    }

    public String getRoutineApptReqdYn()
    {
        return routineApptReqdYn;
    }

    public void setRoutineApptReqdYn(String s)
    {
        routineApptReqdYn = s;
    }

    public String getIvPrepYn()
    {
        return ivPrepYn;
    }

    public void setIvPrepYn(String s)
    {
        ivPrepYn = s;
    }

    public String getDischargeIndicator()
    {
        return dischargeIndicator;
    }

    public void setDischargeIndicator(String s)
    {
        dischargeIndicator = s;
    }

    public String getChargeTypeApplicable()
    {
        return chargeTypeApplicable;
    }

    public void setChargeTypeApplicable(String s)
    {
        chargeTypeApplicable = s;
    }

    public String getConsentStage()
    {
        return consentStage;
    }

    public void setConsentStage(String s)
    {
        consentStage = s;
    }

    public String getRoutineChkForDuplYn()
    {
        return routineChkForDuplYn;
    }

    public void setRoutineChkForDuplYn(String s)
    {
        routineChkForDuplYn = s;
    }

    public String getUrgentChkForDuplYn()
    {
        return urgentChkForDuplYn;
    }

    public void setUrgentChkForDuplYn(String s)
    {
        urgentChkForDuplYn = s;
    }

    public String getStatChkForDuplYn()
    {
        return statChkForDuplYn;
    }

    public void setStatChkForDuplYn(String s)
    {
        statChkForDuplYn = s;
    }

    public Long getApptPrepTime()
    {
        return apptPrepTime;
    }

    public void setApptPrepTime(Long long1)
    {
        apptPrepTime = long1;
    }

    public String getApptPrepTimeType()
    {
        return apptPrepTimeType;
    }

    public void setApptPrepTimeType(String s)
    {
        apptPrepTimeType = s;
    }

    public String getApptActionForPrep()
    {
        return apptActionForPrep;
    }

    public void setApptActionForPrep(String s)
    {
        apptActionForPrep = s;
    }

    public String getProcLinkApplicable()
    {
        return procLinkApplicable;
    }

    public void setProcLinkApplicable(String s)
    {
        procLinkApplicable = s;
    }

    public String getProcLinkResultingOption()
    {
        return procLinkResultingOption;
    }

    public void setProcLinkResultingOption(String s)
    {
        procLinkResultingOption = s;
    }

    public String getExplanatoryText()
    {
        return explanatoryText;
    }

    public void setExplanatoryText(String s)
    {
        explanatoryText = s;
    }

    public String getRefusalFormId()
    {
        return refusalFormId;
    }

    public void setRefusalFormId(String s)
    {
        refusalFormId = s;
    }

    public String getEffStatus()
    {
        return effStatus;
    }

    public void setEffStatus(String s)
    {
        effStatus = s;
    }

    public String getTermSetId()
    {
        return termSetId;
    }

    public void setTermSetId(String s)
    {
        termSetId = s;
    }

    public String getTermCode()
    {
        return termCode;
    }

    public void setTermCode(String s)
    {
        termCode = s;
    }

    public String getAutoReportYn()
    {
        return autoReportYn;
    }

    public void setAutoReportYn(String s)
    {
        autoReportYn = s;
    }

    public String getProcCodingScheme()
    {
        return procCodingScheme;
    }

    public void setProcCodingScheme(String s)
    {
        procCodingScheme = s;
    }

    public String getAddedById()
    {
        return addedById;
    }

    public void setAddedById(String s)
    {
        addedById = s;
    }

    public Date getAddedDate()
    {
        return addedDate;
    }

    public void setAddedDate(Date date)
    {
        addedDate = date;
    }

    public String getAddedAtWsNo()
    {
        return addedAtWsNo;
    }

    public void setAddedAtWsNo(String s)
    {
        addedAtWsNo = s;
    }

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String s)
    {
        addedFacilityId = s;
    }

    public String getModifiedById()
    {
        return modifiedById;
    }

    public void setModifiedById(String s)
    {
        modifiedById = s;
    }

    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(Date date)
    {
        modifiedDate = date;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String s)
    {
        modifiedAtWsNo = s;
    }

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String s)
    {
        modifiedFacilityId = s;
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof OrOrderCatalogLangVwId))
        {
            return false;
        } else
        {
            OrOrderCatalogLangVwId orordercataloglangvwid = (OrOrderCatalogLangVwId)obj;
            return (getOrderCatalogCode() == orordercataloglangvwid.getOrderCatalogCode() || getOrderCatalogCode() != null && orordercataloglangvwid.getOrderCatalogCode() != null && getOrderCatalogCode().equals(orordercataloglangvwid.getOrderCatalogCode())) && (getLanguageId() == orordercataloglangvwid.getLanguageId() || getLanguageId() != null && orordercataloglangvwid.getLanguageId() != null && getLanguageId().equals(orordercataloglangvwid.getLanguageId())) && (getOrdby() == orordercataloglangvwid.getOrdby() || getOrdby() != null && orordercataloglangvwid.getOrdby() != null && getOrdby().equals(orordercataloglangvwid.getOrdby())) && (getLongDesc() == orordercataloglangvwid.getLongDesc() || getLongDesc() != null && orordercataloglangvwid.getLongDesc() != null && getLongDesc().equals(orordercataloglangvwid.getLongDesc())) && (getShortDesc() == orordercataloglangvwid.getShortDesc() || getShortDesc() != null && orordercataloglangvwid.getShortDesc() != null && getShortDesc().equals(orordercataloglangvwid.getShortDesc())) && (getOrderCategory() == orordercataloglangvwid.getOrderCategory() || getOrderCategory() != null && orordercataloglangvwid.getOrderCategory() != null && getOrderCategory().equals(orordercataloglangvwid.getOrderCategory())) && (getOrderTypeCode() == orordercataloglangvwid.getOrderTypeCode() || getOrderTypeCode() != null && orordercataloglangvwid.getOrderTypeCode() != null && getOrderTypeCode().equals(orordercataloglangvwid.getOrderTypeCode())) && (getSecurityLevel() == orordercataloglangvwid.getSecurityLevel() || getSecurityLevel() != null && orordercataloglangvwid.getSecurityLevel() != null && getSecurityLevel().equals(orordercataloglangvwid.getSecurityLevel())) && (getOrderCatalogNature() == orordercataloglangvwid.getOrderCatalogNature() || getOrderCatalogNature() != null && orordercataloglangvwid.getOrderCatalogNature() != null && getOrderCatalogNature().equals(orordercataloglangvwid.getOrderCatalogNature())) && (getConsentReqdYn() == orordercataloglangvwid.getConsentReqdYn() || getConsentReqdYn() != null && orordercataloglangvwid.getConsentReqdYn() != null && getConsentReqdYn().equals(orordercataloglangvwid.getConsentReqdYn())) && (getConsentFormId() == orordercataloglangvwid.getConsentFormId() || getConsentFormId() != null && orordercataloglangvwid.getConsentFormId() != null && getConsentFormId().equals(orordercataloglangvwid.getConsentFormId())) && (getPromptAlertYn() == orordercataloglangvwid.getPromptAlertYn() || getPromptAlertYn() != null && orordercataloglangvwid.getPromptAlertYn() != null && getPromptAlertYn().equals(orordercataloglangvwid.getPromptAlertYn())) && (getPromptAlertMsg() == orordercataloglangvwid.getPromptAlertMsg() || getPromptAlertMsg() != null && orordercataloglangvwid.getPromptAlertMsg() != null && getPromptAlertMsg().equals(orordercataloglangvwid.getPromptAlertMsg())) && (getQtyReqdYn() == orordercataloglangvwid.getQtyReqdYn() || getQtyReqdYn() != null && orordercataloglangvwid.getQtyReqdYn() != null && getQtyReqdYn().equals(orordercataloglangvwid.getQtyReqdYn())) && (getQtyUom() == orordercataloglangvwid.getQtyUom() || getQtyUom() != null && orordercataloglangvwid.getQtyUom() != null && getQtyUom().equals(orordercataloglangvwid.getQtyUom())) && (getSplitDoseYn() == orordercataloglangvwid.getSplitDoseYn() || getSplitDoseYn() != null && orordercataloglangvwid.getSplitDoseYn() != null && getSplitDoseYn().equals(orordercataloglangvwid.getSplitDoseYn())) && (getTaperDoseYn() == orordercataloglangvwid.getTaperDoseYn() || getTaperDoseYn() != null && orordercataloglangvwid.getTaperDoseYn() != null && getTaperDoseYn().equals(orordercataloglangvwid.getTaperDoseYn())) && (getFreqApplicableYn() == orordercataloglangvwid.getFreqApplicableYn() || getFreqApplicableYn() != null && orordercataloglangvwid.getFreqApplicableYn() != null && getFreqApplicableYn().equals(orordercataloglangvwid.getFreqApplicableYn())) && (getSoftStopYn() == orordercataloglangvwid.getSoftStopYn() || getSoftStopYn() != null && orordercataloglangvwid.getSoftStopYn() != null && getSoftStopYn().equals(orordercataloglangvwid.getSoftStopYn())) && (getContOrderYn() == orordercataloglangvwid.getContOrderYn() || getContOrderYn() != null && orordercataloglangvwid.getContOrderYn() != null && getContOrderYn().equals(orordercataloglangvwid.getContOrderYn())) && (getRefillContOrderYn() == orordercataloglangvwid.getRefillContOrderYn() || getRefillContOrderYn() != null && orordercataloglangvwid.getRefillContOrderYn() != null && getRefillContOrderYn().equals(orordercataloglangvwid.getRefillContOrderYn())) && (getContinuousFreqOrder() == orordercataloglangvwid.getContinuousFreqOrder() || getContinuousFreqOrder() != null && orordercataloglangvwid.getContinuousFreqOrder() != null && getContinuousFreqOrder().equals(orordercataloglangvwid.getContinuousFreqOrder())) && (getFieldFormatId() == orordercataloglangvwid.getFieldFormatId() || getFieldFormatId() != null && orordercataloglangvwid.getFieldFormatId() != null && getFieldFormatId().equals(orordercataloglangvwid.getFieldFormatId())) && (getCommentFormatId() == orordercataloglangvwid.getCommentFormatId() || getCommentFormatId() != null && orordercataloglangvwid.getCommentFormatId() != null && getCommentFormatId().equals(orordercataloglangvwid.getCommentFormatId())) && (getChkForDuplYn() == orordercataloglangvwid.getChkForDuplYn() || getChkForDuplYn() != null && orordercataloglangvwid.getChkForDuplYn() != null && getChkForDuplYn().equals(orordercataloglangvwid.getChkForDuplYn())) && (getChkForDuplStatus() == orordercataloglangvwid.getChkForDuplStatus() || getChkForDuplStatus() != null && orordercataloglangvwid.getChkForDuplStatus() != null && getChkForDuplStatus().equals(orordercataloglangvwid.getChkForDuplStatus())) && (getChkForDuplAheadAction() == orordercataloglangvwid.getChkForDuplAheadAction() || getChkForDuplAheadAction() != null && orordercataloglangvwid.getChkForDuplAheadAction() != null && getChkForDuplAheadAction().equals(orordercataloglangvwid.getChkForDuplAheadAction())) && (getChkForDuplAheadPeriod() == orordercataloglangvwid.getChkForDuplAheadPeriod() || getChkForDuplAheadPeriod() != null && orordercataloglangvwid.getChkForDuplAheadPeriod() != null && getChkForDuplAheadPeriod().equals(orordercataloglangvwid.getChkForDuplAheadPeriod())) && (getChkForDuplAheadUnit() == orordercataloglangvwid.getChkForDuplAheadUnit() || getChkForDuplAheadUnit() != null && orordercataloglangvwid.getChkForDuplAheadUnit() != null && getChkForDuplAheadUnit().equals(orordercataloglangvwid.getChkForDuplAheadUnit())) && (getChkForDuplBehindAction() == orordercataloglangvwid.getChkForDuplBehindAction() || getChkForDuplBehindAction() != null && orordercataloglangvwid.getChkForDuplBehindAction() != null && getChkForDuplBehindAction().equals(orordercataloglangvwid.getChkForDuplBehindAction())) && (getChkForDuplBehindPeriod() == orordercataloglangvwid.getChkForDuplBehindPeriod() || getChkForDuplBehindPeriod() != null && orordercataloglangvwid.getChkForDuplBehindPeriod() != null && getChkForDuplBehindPeriod().equals(orordercataloglangvwid.getChkForDuplBehindPeriod())) && (getChkForDuplBehindUnit() == orordercataloglangvwid.getChkForDuplBehindUnit() || getChkForDuplBehindUnit() != null && orordercataloglangvwid.getChkForDuplBehindUnit() != null && getChkForDuplBehindUnit().equals(orordercataloglangvwid.getChkForDuplBehindUnit())) && (getOrdAuthLevel() == orordercataloglangvwid.getOrdAuthLevel() || getOrdAuthLevel() != null && orordercataloglangvwid.getOrdAuthLevel() != null && getOrdAuthLevel().equals(orordercataloglangvwid.getOrdAuthLevel())) && (getOrdCosignLevel() == orordercataloglangvwid.getOrdCosignLevel() || getOrdCosignLevel() != null && orordercataloglangvwid.getOrdCosignLevel() != null && getOrdCosignLevel().equals(orordercataloglangvwid.getOrdCosignLevel())) && (getOrdSplApprLevel() == orordercataloglangvwid.getOrdSplApprLevel() || getOrdSplApprLevel() != null && orordercataloglangvwid.getOrdSplApprLevel() != null && getOrdSplApprLevel().equals(orordercataloglangvwid.getOrdSplApprLevel())) && (getApptReqdYn() == orordercataloglangvwid.getApptReqdYn() || getApptReqdYn() != null && orordercataloglangvwid.getApptReqdYn() != null && getApptReqdYn().equals(orordercataloglangvwid.getApptReqdYn())) && (getApptTime() == orordercataloglangvwid.getApptTime() || getApptTime() != null && orordercataloglangvwid.getApptTime() != null && getApptTime().equals(orordercataloglangvwid.getApptTime())) && (getPatInstrnAgeSexYn() == orordercataloglangvwid.getPatInstrnAgeSexYn() || getPatInstrnAgeSexYn() != null && orordercataloglangvwid.getPatInstrnAgeSexYn() != null && getPatInstrnAgeSexYn().equals(orordercataloglangvwid.getPatInstrnAgeSexYn())) && (getDeptOnlyYn() == orordercataloglangvwid.getDeptOnlyYn() || getDeptOnlyYn() != null && orordercataloglangvwid.getDeptOnlyYn() != null && getDeptOnlyYn().equals(orordercataloglangvwid.getDeptOnlyYn())) && (getCompleteOnOrderYn() == orordercataloglangvwid.getCompleteOnOrderYn() || getCompleteOnOrderYn() != null && orordercataloglangvwid.getCompleteOnOrderYn() != null && getCompleteOnOrderYn().equals(orordercataloglangvwid.getCompleteOnOrderYn())) && (getBillYn() == orordercataloglangvwid.getBillYn() || getBillYn() != null && orordercataloglangvwid.getBillYn() != null && getBillYn().equals(orordercataloglangvwid.getBillYn())) && (getResultApplicableYn() == orordercataloglangvwid.getResultApplicableYn() || getResultApplicableYn() != null && orordercataloglangvwid.getResultApplicableYn() != null && getResultApplicableYn().equals(orordercataloglangvwid.getResultApplicableYn())) && (getResultAuthReqdYn() == orordercataloglangvwid.getResultAuthReqdYn() || getResultAuthReqdYn() != null && orordercataloglangvwid.getResultAuthReqdYn() != null && getResultAuthReqdYn().equals(orordercataloglangvwid.getResultAuthReqdYn())) && (getChartResultType() == orordercataloglangvwid.getChartResultType() || getChartResultType() != null && orordercataloglangvwid.getChartResultType() != null && getChartResultType().equals(orordercataloglangvwid.getChartResultType())) && (getDiscrMsrPanelId() == orordercataloglangvwid.getDiscrMsrPanelId() || getDiscrMsrPanelId() != null && orordercataloglangvwid.getDiscrMsrPanelId() != null && getDiscrMsrPanelId().equals(orordercataloglangvwid.getDiscrMsrPanelId())) && (getContrModId() == orordercataloglangvwid.getContrModId() || getContrModId() != null && orordercataloglangvwid.getContrModId() != null && getContrModId().equals(orordercataloglangvwid.getContrModId())) && (getContrMsrPanelId() == orordercataloglangvwid.getContrMsrPanelId() || getContrMsrPanelId() != null && orordercataloglangvwid.getContrMsrPanelId() != null && getContrMsrPanelId().equals(orordercataloglangvwid.getContrMsrPanelId())) && (getImageLinkId() == orordercataloglangvwid.getImageLinkId() || getImageLinkId() != null && orordercataloglangvwid.getImageLinkId() != null && getImageLinkId().equals(orordercataloglangvwid.getImageLinkId())) && (getIndexedYn() == orordercataloglangvwid.getIndexedYn() || getIndexedYn() != null && orordercataloglangvwid.getIndexedYn() != null && getIndexedYn().equals(orordercataloglangvwid.getIndexedYn())) && (getPriorityAppl() == orordercataloglangvwid.getPriorityAppl() || getPriorityAppl() != null && orordercataloglangvwid.getPriorityAppl() != null && getPriorityAppl().equals(orordercataloglangvwid.getPriorityAppl())) && (getActivityType() == orordercataloglangvwid.getActivityType() || getActivityType() != null && orordercataloglangvwid.getActivityType() != null && getActivityType().equals(orordercataloglangvwid.getActivityType())) && (getCheckForDuplLevel() == orordercataloglangvwid.getCheckForDuplLevel() || getCheckForDuplLevel() != null && orordercataloglangvwid.getCheckForDuplLevel() != null && getCheckForDuplLevel().equals(orordercataloglangvwid.getCheckForDuplLevel())) && (getStatTurnAroundTime() == orordercataloglangvwid.getStatTurnAroundTime() || getStatTurnAroundTime() != null && orordercataloglangvwid.getStatTurnAroundTime() != null && getStatTurnAroundTime().equals(orordercataloglangvwid.getStatTurnAroundTime())) && (getStatTurnAroundType() == orordercataloglangvwid.getStatTurnAroundType() || getStatTurnAroundType() != null && orordercataloglangvwid.getStatTurnAroundType() != null && getStatTurnAroundType().equals(orordercataloglangvwid.getStatTurnAroundType())) && (getUrgentTurnAroundTime() == orordercataloglangvwid.getUrgentTurnAroundTime() || getUrgentTurnAroundTime() != null && orordercataloglangvwid.getUrgentTurnAroundTime() != null && getUrgentTurnAroundTime().equals(orordercataloglangvwid.getUrgentTurnAroundTime())) && (getUrgentTurnAroundType() == orordercataloglangvwid.getUrgentTurnAroundType() || getUrgentTurnAroundType() != null && orordercataloglangvwid.getUrgentTurnAroundType() != null && getUrgentTurnAroundType().equals(orordercataloglangvwid.getUrgentTurnAroundType())) && (getRoutineTurnAroundTime() == orordercataloglangvwid.getRoutineTurnAroundTime() || getRoutineTurnAroundTime() != null && orordercataloglangvwid.getRoutineTurnAroundTime() != null && getRoutineTurnAroundTime().equals(orordercataloglangvwid.getRoutineTurnAroundTime())) && (getRoutineTurnAroundType() == orordercataloglangvwid.getRoutineTurnAroundType() || getRoutineTurnAroundType() != null && orordercataloglangvwid.getRoutineTurnAroundType() != null && getRoutineTurnAroundType().equals(orordercataloglangvwid.getRoutineTurnAroundType())) && (getConfidentialYn() == orordercataloglangvwid.getConfidentialYn() || getConfidentialYn() != null && orordercataloglangvwid.getConfidentialYn() != null && getConfidentialYn().equals(orordercataloglangvwid.getConfidentialYn())) && (getTaperUp() == orordercataloglangvwid.getTaperUp() || getTaperUp() != null && orordercataloglangvwid.getTaperUp() != null && getTaperUp().equals(orordercataloglangvwid.getTaperUp())) && (getApplSlidingScaleYn() == orordercataloglangvwid.getApplSlidingScaleYn() || getApplSlidingScaleYn() != null && orordercataloglangvwid.getApplSlidingScaleYn() != null && getApplSlidingScaleYn().equals(orordercataloglangvwid.getApplSlidingScaleYn())) && (getStatApptReqdYn() == orordercataloglangvwid.getStatApptReqdYn() || getStatApptReqdYn() != null && orordercataloglangvwid.getStatApptReqdYn() != null && getStatApptReqdYn().equals(orordercataloglangvwid.getStatApptReqdYn())) && (getUrgentApptReqdYn() == orordercataloglangvwid.getUrgentApptReqdYn() || getUrgentApptReqdYn() != null && orordercataloglangvwid.getUrgentApptReqdYn() != null && getUrgentApptReqdYn().equals(orordercataloglangvwid.getUrgentApptReqdYn())) && (getRoutineApptReqdYn() == orordercataloglangvwid.getRoutineApptReqdYn() || getRoutineApptReqdYn() != null && orordercataloglangvwid.getRoutineApptReqdYn() != null && getRoutineApptReqdYn().equals(orordercataloglangvwid.getRoutineApptReqdYn())) && (getIvPrepYn() == orordercataloglangvwid.getIvPrepYn() || getIvPrepYn() != null && orordercataloglangvwid.getIvPrepYn() != null && getIvPrepYn().equals(orordercataloglangvwid.getIvPrepYn())) && (getDischargeIndicator() == orordercataloglangvwid.getDischargeIndicator() || getDischargeIndicator() != null && orordercataloglangvwid.getDischargeIndicator() != null && getDischargeIndicator().equals(orordercataloglangvwid.getDischargeIndicator())) && (getChargeTypeApplicable() == orordercataloglangvwid.getChargeTypeApplicable() || getChargeTypeApplicable() != null && orordercataloglangvwid.getChargeTypeApplicable() != null && getChargeTypeApplicable().equals(orordercataloglangvwid.getChargeTypeApplicable())) && (getConsentStage() == orordercataloglangvwid.getConsentStage() || getConsentStage() != null && orordercataloglangvwid.getConsentStage() != null && getConsentStage().equals(orordercataloglangvwid.getConsentStage())) && (getRoutineChkForDuplYn() == orordercataloglangvwid.getRoutineChkForDuplYn() || getRoutineChkForDuplYn() != null && orordercataloglangvwid.getRoutineChkForDuplYn() != null && getRoutineChkForDuplYn().equals(orordercataloglangvwid.getRoutineChkForDuplYn())) && (getUrgentChkForDuplYn() == orordercataloglangvwid.getUrgentChkForDuplYn() || getUrgentChkForDuplYn() != null && orordercataloglangvwid.getUrgentChkForDuplYn() != null && getUrgentChkForDuplYn().equals(orordercataloglangvwid.getUrgentChkForDuplYn())) && (getStatChkForDuplYn() == orordercataloglangvwid.getStatChkForDuplYn() || getStatChkForDuplYn() != null && orordercataloglangvwid.getStatChkForDuplYn() != null && getStatChkForDuplYn().equals(orordercataloglangvwid.getStatChkForDuplYn())) && (getApptPrepTime() == orordercataloglangvwid.getApptPrepTime() || getApptPrepTime() != null && orordercataloglangvwid.getApptPrepTime() != null && getApptPrepTime().equals(orordercataloglangvwid.getApptPrepTime())) && (getApptPrepTimeType() == orordercataloglangvwid.getApptPrepTimeType() || getApptPrepTimeType() != null && orordercataloglangvwid.getApptPrepTimeType() != null && getApptPrepTimeType().equals(orordercataloglangvwid.getApptPrepTimeType())) && (getApptActionForPrep() == orordercataloglangvwid.getApptActionForPrep() || getApptActionForPrep() != null && orordercataloglangvwid.getApptActionForPrep() != null && getApptActionForPrep().equals(orordercataloglangvwid.getApptActionForPrep())) && (getProcLinkApplicable() == orordercataloglangvwid.getProcLinkApplicable() || getProcLinkApplicable() != null && orordercataloglangvwid.getProcLinkApplicable() != null && getProcLinkApplicable().equals(orordercataloglangvwid.getProcLinkApplicable())) && (getProcLinkResultingOption() == orordercataloglangvwid.getProcLinkResultingOption() || getProcLinkResultingOption() != null && orordercataloglangvwid.getProcLinkResultingOption() != null && getProcLinkResultingOption().equals(orordercataloglangvwid.getProcLinkResultingOption())) && (getExplanatoryText() == orordercataloglangvwid.getExplanatoryText() || getExplanatoryText() != null && orordercataloglangvwid.getExplanatoryText() != null && getExplanatoryText().equals(orordercataloglangvwid.getExplanatoryText())) && (getRefusalFormId() == orordercataloglangvwid.getRefusalFormId() || getRefusalFormId() != null && orordercataloglangvwid.getRefusalFormId() != null && getRefusalFormId().equals(orordercataloglangvwid.getRefusalFormId())) && (getEffStatus() == orordercataloglangvwid.getEffStatus() || getEffStatus() != null && orordercataloglangvwid.getEffStatus() != null && getEffStatus().equals(orordercataloglangvwid.getEffStatus())) && (getTermSetId() == orordercataloglangvwid.getTermSetId() || getTermSetId() != null && orordercataloglangvwid.getTermSetId() != null && getTermSetId().equals(orordercataloglangvwid.getTermSetId())) && (getTermCode() == orordercataloglangvwid.getTermCode() || getTermCode() != null && orordercataloglangvwid.getTermCode() != null && getTermCode().equals(orordercataloglangvwid.getTermCode())) && (getAutoReportYn() == orordercataloglangvwid.getAutoReportYn() || getAutoReportYn() != null && orordercataloglangvwid.getAutoReportYn() != null && getAutoReportYn().equals(orordercataloglangvwid.getAutoReportYn())) && (getProcCodingScheme() == orordercataloglangvwid.getProcCodingScheme() || getProcCodingScheme() != null && orordercataloglangvwid.getProcCodingScheme() != null && getProcCodingScheme().equals(orordercataloglangvwid.getProcCodingScheme())) && (getAddedById() == orordercataloglangvwid.getAddedById() || getAddedById() != null && orordercataloglangvwid.getAddedById() != null && getAddedById().equals(orordercataloglangvwid.getAddedById())) && (getAddedDate() == orordercataloglangvwid.getAddedDate() || getAddedDate() != null && orordercataloglangvwid.getAddedDate() != null && getAddedDate().equals(orordercataloglangvwid.getAddedDate())) && (getAddedAtWsNo() == orordercataloglangvwid.getAddedAtWsNo() || getAddedAtWsNo() != null && orordercataloglangvwid.getAddedAtWsNo() != null && getAddedAtWsNo().equals(orordercataloglangvwid.getAddedAtWsNo())) && (getAddedFacilityId() == orordercataloglangvwid.getAddedFacilityId() || getAddedFacilityId() != null && orordercataloglangvwid.getAddedFacilityId() != null && getAddedFacilityId().equals(orordercataloglangvwid.getAddedFacilityId())) && (getModifiedById() == orordercataloglangvwid.getModifiedById() || getModifiedById() != null && orordercataloglangvwid.getModifiedById() != null && getModifiedById().equals(orordercataloglangvwid.getModifiedById())) && (getModifiedDate() == orordercataloglangvwid.getModifiedDate() || getModifiedDate() != null && orordercataloglangvwid.getModifiedDate() != null && getModifiedDate().equals(orordercataloglangvwid.getModifiedDate())) && (getModifiedAtWsNo() == orordercataloglangvwid.getModifiedAtWsNo() || getModifiedAtWsNo() != null && orordercataloglangvwid.getModifiedAtWsNo() != null && getModifiedAtWsNo().equals(orordercataloglangvwid.getModifiedAtWsNo())) && (getModifiedFacilityId() == orordercataloglangvwid.getModifiedFacilityId() || getModifiedFacilityId() != null && orordercataloglangvwid.getModifiedFacilityId() != null && getModifiedFacilityId().equals(orordercataloglangvwid.getModifiedFacilityId()));
        }
    }

    public int hashCode()
    {
        int i = 17;
        i = 37 * i + (getOrderCatalogCode() != null ? getOrderCatalogCode().hashCode() : 0);
        i = 37 * i + (getLanguageId() != null ? getLanguageId().hashCode() : 0);
        i = 37 * i + (getOrdby() != null ? getOrdby().hashCode() : 0);
        i = 37 * i + (getLongDesc() != null ? getLongDesc().hashCode() : 0);
        i = 37 * i + (getShortDesc() != null ? getShortDesc().hashCode() : 0);
        i = 37 * i + (getOrderCategory() != null ? getOrderCategory().hashCode() : 0);
        i = 37 * i + (getOrderTypeCode() != null ? getOrderTypeCode().hashCode() : 0);
        i = 37 * i + (getSecurityLevel() != null ? getSecurityLevel().hashCode() : 0);
        i = 37 * i + (getOrderCatalogNature() != null ? getOrderCatalogNature().hashCode() : 0);
        i = 37 * i + (getConsentReqdYn() != null ? getConsentReqdYn().hashCode() : 0);
        i = 37 * i + (getConsentFormId() != null ? getConsentFormId().hashCode() : 0);
        i = 37 * i + (getPromptAlertYn() != null ? getPromptAlertYn().hashCode() : 0);
        i = 37 * i + (getPromptAlertMsg() != null ? getPromptAlertMsg().hashCode() : 0);
        i = 37 * i + (getQtyReqdYn() != null ? getQtyReqdYn().hashCode() : 0);
        i = 37 * i + (getQtyUom() != null ? getQtyUom().hashCode() : 0);
        i = 37 * i + (getSplitDoseYn() != null ? getSplitDoseYn().hashCode() : 0);
        i = 37 * i + (getTaperDoseYn() != null ? getTaperDoseYn().hashCode() : 0);
        i = 37 * i + (getFreqApplicableYn() != null ? getFreqApplicableYn().hashCode() : 0);
        i = 37 * i + (getSoftStopYn() != null ? getSoftStopYn().hashCode() : 0);
        i = 37 * i + (getContOrderYn() != null ? getContOrderYn().hashCode() : 0);
        i = 37 * i + (getRefillContOrderYn() != null ? getRefillContOrderYn().hashCode() : 0);
        i = 37 * i + (getContinuousFreqOrder() != null ? getContinuousFreqOrder().hashCode() : 0);
        i = 37 * i + (getFieldFormatId() != null ? getFieldFormatId().hashCode() : 0);
        i = 37 * i + (getCommentFormatId() != null ? getCommentFormatId().hashCode() : 0);
        i = 37 * i + (getChkForDuplYn() != null ? getChkForDuplYn().hashCode() : 0);
        i = 37 * i + (getChkForDuplStatus() != null ? getChkForDuplStatus().hashCode() : 0);
        i = 37 * i + (getChkForDuplAheadAction() != null ? getChkForDuplAheadAction().hashCode() : 0);
        i = 37 * i + (getChkForDuplAheadPeriod() != null ? getChkForDuplAheadPeriod().hashCode() : 0);
        i = 37 * i + (getChkForDuplAheadUnit() != null ? getChkForDuplAheadUnit().hashCode() : 0);
        i = 37 * i + (getChkForDuplBehindAction() != null ? getChkForDuplBehindAction().hashCode() : 0);
        i = 37 * i + (getChkForDuplBehindPeriod() != null ? getChkForDuplBehindPeriod().hashCode() : 0);
        i = 37 * i + (getChkForDuplBehindUnit() != null ? getChkForDuplBehindUnit().hashCode() : 0);
        i = 37 * i + (getOrdAuthLevel() != null ? getOrdAuthLevel().hashCode() : 0);
        i = 37 * i + (getOrdCosignLevel() != null ? getOrdCosignLevel().hashCode() : 0);
        i = 37 * i + (getOrdSplApprLevel() != null ? getOrdSplApprLevel().hashCode() : 0);
        i = 37 * i + (getApptReqdYn() != null ? getApptReqdYn().hashCode() : 0);
        i = 37 * i + (getApptTime() != null ? getApptTime().hashCode() : 0);
        i = 37 * i + (getPatInstrnAgeSexYn() != null ? getPatInstrnAgeSexYn().hashCode() : 0);
        i = 37 * i + (getDeptOnlyYn() != null ? getDeptOnlyYn().hashCode() : 0);
        i = 37 * i + (getCompleteOnOrderYn() != null ? getCompleteOnOrderYn().hashCode() : 0);
        i = 37 * i + (getBillYn() != null ? getBillYn().hashCode() : 0);
        i = 37 * i + (getResultApplicableYn() != null ? getResultApplicableYn().hashCode() : 0);
        i = 37 * i + (getResultAuthReqdYn() != null ? getResultAuthReqdYn().hashCode() : 0);
        i = 37 * i + (getChartResultType() != null ? getChartResultType().hashCode() : 0);
        i = 37 * i + (getDiscrMsrPanelId() != null ? getDiscrMsrPanelId().hashCode() : 0);
        i = 37 * i + (getContrModId() != null ? getContrModId().hashCode() : 0);
        i = 37 * i + (getContrMsrPanelId() != null ? getContrMsrPanelId().hashCode() : 0);
        i = 37 * i + (getImageLinkId() != null ? getImageLinkId().hashCode() : 0);
        i = 37 * i + (getIndexedYn() != null ? getIndexedYn().hashCode() : 0);
        i = 37 * i + (getPriorityAppl() != null ? getPriorityAppl().hashCode() : 0);
        i = 37 * i + (getActivityType() != null ? getActivityType().hashCode() : 0);
        i = 37 * i + (getCheckForDuplLevel() != null ? getCheckForDuplLevel().hashCode() : 0);
        i = 37 * i + (getStatTurnAroundTime() != null ? getStatTurnAroundTime().hashCode() : 0);
        i = 37 * i + (getStatTurnAroundType() != null ? getStatTurnAroundType().hashCode() : 0);
        i = 37 * i + (getUrgentTurnAroundTime() != null ? getUrgentTurnAroundTime().hashCode() : 0);
        i = 37 * i + (getUrgentTurnAroundType() != null ? getUrgentTurnAroundType().hashCode() : 0);
        i = 37 * i + (getRoutineTurnAroundTime() != null ? getRoutineTurnAroundTime().hashCode() : 0);
        i = 37 * i + (getRoutineTurnAroundType() != null ? getRoutineTurnAroundType().hashCode() : 0);
        i = 37 * i + (getConfidentialYn() != null ? getConfidentialYn().hashCode() : 0);
        i = 37 * i + (getTaperUp() != null ? getTaperUp().hashCode() : 0);
        i = 37 * i + (getApplSlidingScaleYn() != null ? getApplSlidingScaleYn().hashCode() : 0);
        i = 37 * i + (getStatApptReqdYn() != null ? getStatApptReqdYn().hashCode() : 0);
        i = 37 * i + (getUrgentApptReqdYn() != null ? getUrgentApptReqdYn().hashCode() : 0);
        i = 37 * i + (getRoutineApptReqdYn() != null ? getRoutineApptReqdYn().hashCode() : 0);
        i = 37 * i + (getIvPrepYn() != null ? getIvPrepYn().hashCode() : 0);
        i = 37 * i + (getDischargeIndicator() != null ? getDischargeIndicator().hashCode() : 0);
        i = 37 * i + (getChargeTypeApplicable() != null ? getChargeTypeApplicable().hashCode() : 0);
        i = 37 * i + (getConsentStage() != null ? getConsentStage().hashCode() : 0);
        i = 37 * i + (getRoutineChkForDuplYn() != null ? getRoutineChkForDuplYn().hashCode() : 0);
        i = 37 * i + (getUrgentChkForDuplYn() != null ? getUrgentChkForDuplYn().hashCode() : 0);
        i = 37 * i + (getStatChkForDuplYn() != null ? getStatChkForDuplYn().hashCode() : 0);
        i = 37 * i + (getApptPrepTime() != null ? getApptPrepTime().hashCode() : 0);
        i = 37 * i + (getApptPrepTimeType() != null ? getApptPrepTimeType().hashCode() : 0);
        i = 37 * i + (getApptActionForPrep() != null ? getApptActionForPrep().hashCode() : 0);
        i = 37 * i + (getProcLinkApplicable() != null ? getProcLinkApplicable().hashCode() : 0);
        i = 37 * i + (getProcLinkResultingOption() != null ? getProcLinkResultingOption().hashCode() : 0);
        i = 37 * i + (getExplanatoryText() != null ? getExplanatoryText().hashCode() : 0);
        i = 37 * i + (getRefusalFormId() != null ? getRefusalFormId().hashCode() : 0);
        i = 37 * i + (getEffStatus() != null ? getEffStatus().hashCode() : 0);
        i = 37 * i + (getTermSetId() != null ? getTermSetId().hashCode() : 0);
        i = 37 * i + (getTermCode() != null ? getTermCode().hashCode() : 0);
        i = 37 * i + (getAutoReportYn() != null ? getAutoReportYn().hashCode() : 0);
        i = 37 * i + (getProcCodingScheme() != null ? getProcCodingScheme().hashCode() : 0);
        i = 37 * i + (getAddedById() != null ? getAddedById().hashCode() : 0);
        i = 37 * i + (getAddedDate() != null ? getAddedDate().hashCode() : 0);
        i = 37 * i + (getAddedAtWsNo() != null ? getAddedAtWsNo().hashCode() : 0);
        i = 37 * i + (getAddedFacilityId() != null ? getAddedFacilityId().hashCode() : 0);
        i = 37 * i + (getModifiedById() != null ? getModifiedById().hashCode() : 0);
        i = 37 * i + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        i = 37 * i + (getModifiedAtWsNo() != null ? getModifiedAtWsNo().hashCode() : 0);
        i = 37 * i + (getModifiedFacilityId() != null ? getModifiedFacilityId().hashCode() : 0);
        return i;
    }

    private String orderCatalogCode;
    private String languageId;
    private String ordby;
    private String longDesc;
    private String shortDesc;
    private String orderCategory;
    private String orderTypeCode;
    private String securityLevel;
    private String orderCatalogNature;
    private String consentReqdYn;
    private String consentFormId;
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
    private String fieldFormatId;
    private String commentFormatId;
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
    private String priorityAppl;
    private String activityType;
    private String checkForDuplLevel;
    private Long statTurnAroundTime;
    private String statTurnAroundType;
    private Long urgentTurnAroundTime;
    private String urgentTurnAroundType;
    private Long routineTurnAroundTime;
    private String routineTurnAroundType;
    private String confidentialYn;
    private String taperUp;
    private String applSlidingScaleYn;
    private String statApptReqdYn;
    private String urgentApptReqdYn;
    private String routineApptReqdYn;
    private String ivPrepYn;
    private String dischargeIndicator;
    private String chargeTypeApplicable;
    private String consentStage;
    private String routineChkForDuplYn;
    private String urgentChkForDuplYn;
    private String statChkForDuplYn;
    private Long apptPrepTime;
    private String apptPrepTimeType;
    private String apptActionForPrep;
    private String procLinkApplicable;
    private String procLinkResultingOption;
    private String explanatoryText;
    private String refusalFormId;
    private String effStatus;
    private String termSetId;
    private String termCode;
    private String autoReportYn;
    private String procCodingScheme;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
}
