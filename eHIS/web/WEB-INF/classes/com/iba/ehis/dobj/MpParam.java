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

public class MpParam
    implements Serializable
{

    public MpParam()
    {
    }

    public MpParam(String moduleId, Long patientIdLength, String patientNoCtrl, String dfltPatSerGrpType, String acceptNationalIdNoYn, String familyNoLinkYn, String headPatientNoUseYn, 
            String familyOrgIdAcceptYn, String generalAlertYn, String suspendServiceYn, String singleOrMultiFilesInd, String separateFileNoYn, String extSystemInterfaceYn, String namePrefixAcceptYn, 
            String namePrefixReqdYn, String firstNameAcceptYn, String firstNameReqdYn, String secondNameAcceptYn, String secondNameReqdYn, String thirdNameAcceptYn, String thirdNameReqdYn, 
            String familyNameAcceptYn, String familyNameReqdYn, String familyNamePrefixYn, String nameSuffixAcceptYn, String nameSuffixReqdYn, String namesInOthLangYn, String nameDervnLogic, 
            String altId1Type, String altId1ReqdYn, String altId1UniqueYn, String altId1ExpWarnYn, String altId1AcceptOthPatSerYn, String altId1AcceptAlphanumericYn, String altId1RoutineYn, 
            String altId1AdvAlertReqdYn, String altId1LenValidationYn, String altId1ExpDateAcceptYn, String altId2ReqdYn, String altId2UniqueYn, String altId2ExpWarnYn, String altId2RoutineYn, 
            String altId2AdvAlertReqdYn, String altId2LenValidationYn, String altId2ExpDateAcceptYn, String altId3ReqdYn, String altId3UniqueYn, String altId3ExpWarnYn, String altId3RoutineYn, 
            String altId3AdvAlertReqdYn, String altId3LenValidationYn, String altId3ExpDateAcceptYn, String altId4ReqdYn, String altId4UniqueYn, String altId4ExpWarnYn, String altId4RoutineYn, 
            String altId4AdvAlertReqdYn, String altId4LenValidationYn, String altId4ExpDateAcceptYn, String dfltContactMode1, String dfltContactMode2, String dfltAddrType1, String dfltAddrType2, 
            String promptPatFinClassYn, String reviewNbLinksBefRegYn, String terminalDigitReqdYn, String sexHistYn, String birthDateHistYn, String legalNameHistYn, String aliasNameHistYn, 
            String codedPseudoNameHistYn, String contactNoHistYn, String addressHistYn, String ocpnNEmplHistYn, String generalAlertInfoHistYn, String suspendReinstateHistYn, String inactActHistYn, 
            String recRevokeDeathHistYn, String altId1HistYn, String altId2HistYn, String altId3HistYn, String altId4HistYn, String nationalityHistYn, String hrInterfaceYn, 
            String hisInterfaceYn, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, String modifiedById, Date modifiedDate, 
            String modifiedAtWsNo, String modifiedFacilityId, String patNameAsMultipartYn, String acceptOthAltIdYn, String createFileAtAdmission, String createFileAtPatRegnYn, String createFileAtRegAttYn, 
            String createFileAtRegVisitYn, String fileTypeApplYn, String genSlnoUnknownPatYn, String maintainDocOrFile, String createFileAtDcAdmissionYn, String acptApptRfrlInRegPatYn, String dfltAltId1InEmpIdYn, 
            String invokeChgPatDtlsFmNbYn, String entitlementByPatCatYn, String familyLinkHistYn, String orgMemberHistYn, String patCatHistYn, String natIdHistYn, String birthPlaceCodeHistYn, 
            String altId1NoncitizenYn, String altId2NoncitizenYn, String altId2AcceptAlphanumericYn, String altId3AcceptAlphanumericYn, String altId4AcceptAlphanumericYn)
    {
        this.moduleId = moduleId;
        this.patientIdLength = patientIdLength;
        this.patientNoCtrl = patientNoCtrl;
        this.dfltPatSerGrpType = dfltPatSerGrpType;
        this.acceptNationalIdNoYn = acceptNationalIdNoYn;
        this.familyNoLinkYn = familyNoLinkYn;
        this.headPatientNoUseYn = headPatientNoUseYn;
        this.familyOrgIdAcceptYn = familyOrgIdAcceptYn;
        this.generalAlertYn = generalAlertYn;
        this.suspendServiceYn = suspendServiceYn;
        this.singleOrMultiFilesInd = singleOrMultiFilesInd;
        this.separateFileNoYn = separateFileNoYn;
        this.extSystemInterfaceYn = extSystemInterfaceYn;
        this.namePrefixAcceptYn = namePrefixAcceptYn;
        this.namePrefixReqdYn = namePrefixReqdYn;
        this.firstNameAcceptYn = firstNameAcceptYn;
        this.firstNameReqdYn = firstNameReqdYn;
        this.secondNameAcceptYn = secondNameAcceptYn;
        this.secondNameReqdYn = secondNameReqdYn;
        this.thirdNameAcceptYn = thirdNameAcceptYn;
        this.thirdNameReqdYn = thirdNameReqdYn;
        this.familyNameAcceptYn = familyNameAcceptYn;
        this.familyNameReqdYn = familyNameReqdYn;
        this.familyNamePrefixYn = familyNamePrefixYn;
        this.nameSuffixAcceptYn = nameSuffixAcceptYn;
        this.nameSuffixReqdYn = nameSuffixReqdYn;
        this.namesInOthLangYn = namesInOthLangYn;
        this.nameDervnLogic = nameDervnLogic;
        this.altId1Type = altId1Type;
        this.altId1ReqdYn = altId1ReqdYn;
        this.altId1UniqueYn = altId1UniqueYn;
        this.altId1ExpWarnYn = altId1ExpWarnYn;
        this.altId1AcceptOthPatSerYn = altId1AcceptOthPatSerYn;
        this.altId1AcceptAlphanumericYn = altId1AcceptAlphanumericYn;
        this.altId1RoutineYn = altId1RoutineYn;
        this.altId1AdvAlertReqdYn = altId1AdvAlertReqdYn;
        this.altId1LenValidationYn = altId1LenValidationYn;
        this.altId1ExpDateAcceptYn = altId1ExpDateAcceptYn;
        this.altId2ReqdYn = altId2ReqdYn;
        this.altId2UniqueYn = altId2UniqueYn;
        this.altId2ExpWarnYn = altId2ExpWarnYn;
        this.altId2RoutineYn = altId2RoutineYn;
        this.altId2AdvAlertReqdYn = altId2AdvAlertReqdYn;
        this.altId2LenValidationYn = altId2LenValidationYn;
        this.altId2ExpDateAcceptYn = altId2ExpDateAcceptYn;
        this.altId3ReqdYn = altId3ReqdYn;
        this.altId3UniqueYn = altId3UniqueYn;
        this.altId3ExpWarnYn = altId3ExpWarnYn;
        this.altId3RoutineYn = altId3RoutineYn;
        this.altId3AdvAlertReqdYn = altId3AdvAlertReqdYn;
        this.altId3LenValidationYn = altId3LenValidationYn;
        this.altId3ExpDateAcceptYn = altId3ExpDateAcceptYn;
        this.altId4ReqdYn = altId4ReqdYn;
        this.altId4UniqueYn = altId4UniqueYn;
        this.altId4ExpWarnYn = altId4ExpWarnYn;
        this.altId4RoutineYn = altId4RoutineYn;
        this.altId4AdvAlertReqdYn = altId4AdvAlertReqdYn;
        this.altId4LenValidationYn = altId4LenValidationYn;
        this.altId4ExpDateAcceptYn = altId4ExpDateAcceptYn;
        this.dfltContactMode1 = dfltContactMode1;
        this.dfltContactMode2 = dfltContactMode2;
        this.dfltAddrType1 = dfltAddrType1;
        this.dfltAddrType2 = dfltAddrType2;
        this.promptPatFinClassYn = promptPatFinClassYn;
        this.reviewNbLinksBefRegYn = reviewNbLinksBefRegYn;
        this.terminalDigitReqdYn = terminalDigitReqdYn;
        this.sexHistYn = sexHistYn;
        this.birthDateHistYn = birthDateHistYn;
        this.legalNameHistYn = legalNameHistYn;
        this.aliasNameHistYn = aliasNameHistYn;
        this.codedPseudoNameHistYn = codedPseudoNameHistYn;
        this.contactNoHistYn = contactNoHistYn;
        this.addressHistYn = addressHistYn;
        this.ocpnNEmplHistYn = ocpnNEmplHistYn;
        this.generalAlertInfoHistYn = generalAlertInfoHistYn;
        this.suspendReinstateHistYn = suspendReinstateHistYn;
        this.inactActHistYn = inactActHistYn;
        this.recRevokeDeathHistYn = recRevokeDeathHistYn;
        this.altId1HistYn = altId1HistYn;
        this.altId2HistYn = altId2HistYn;
        this.altId3HistYn = altId3HistYn;
        this.altId4HistYn = altId4HistYn;
        this.nationalityHistYn = nationalityHistYn;
        this.hrInterfaceYn = hrInterfaceYn;
        this.hisInterfaceYn = hisInterfaceYn;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.patNameAsMultipartYn = patNameAsMultipartYn;
        this.acceptOthAltIdYn = acceptOthAltIdYn;
        this.createFileAtAdmission = createFileAtAdmission;
        this.createFileAtPatRegnYn = createFileAtPatRegnYn;
        this.createFileAtRegAttYn = createFileAtRegAttYn;
        this.createFileAtRegVisitYn = createFileAtRegVisitYn;
        this.fileTypeApplYn = fileTypeApplYn;
        this.genSlnoUnknownPatYn = genSlnoUnknownPatYn;
        this.maintainDocOrFile = maintainDocOrFile;
        this.createFileAtDcAdmissionYn = createFileAtDcAdmissionYn;
        this.acptApptRfrlInRegPatYn = acptApptRfrlInRegPatYn;
        this.dfltAltId1InEmpIdYn = dfltAltId1InEmpIdYn;
        this.invokeChgPatDtlsFmNbYn = invokeChgPatDtlsFmNbYn;
        this.entitlementByPatCatYn = entitlementByPatCatYn;
        this.familyLinkHistYn = familyLinkHistYn;
        this.orgMemberHistYn = orgMemberHistYn;
        this.patCatHistYn = patCatHistYn;
        this.natIdHistYn = natIdHistYn;
        this.birthPlaceCodeHistYn = birthPlaceCodeHistYn;
        this.altId1NoncitizenYn = altId1NoncitizenYn;
        this.altId2NoncitizenYn = altId2NoncitizenYn;
        this.altId2AcceptAlphanumericYn = altId2AcceptAlphanumericYn;
        this.altId3AcceptAlphanumericYn = altId3AcceptAlphanumericYn;
        this.altId4AcceptAlphanumericYn = altId4AcceptAlphanumericYn;
    }

    public String getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }

    public Long getPatientIdLength()
    {
        return patientIdLength;
    }

    public void setPatientIdLength(Long patientIdLength)
    {
        this.patientIdLength = patientIdLength;
    }

    public String getPatientNoCtrl()
    {
        return patientNoCtrl;
    }

    public void setPatientNoCtrl(String patientNoCtrl)
    {
        this.patientNoCtrl = patientNoCtrl;
    }

    public String getGenPatSerGrp()
    {
        return genPatSerGrp;
    }

    public void setGenPatSerGrp(String genPatSerGrp)
    {
        this.genPatSerGrp = genPatSerGrp;
    }

    public String getNatIdPatSerGrp()
    {
        return natIdPatSerGrp;
    }

    public void setNatIdPatSerGrp(String natIdPatSerGrp)
    {
        this.natIdPatSerGrp = natIdPatSerGrp;
    }

    public String getAltIdPatSerGrp()
    {
        return altIdPatSerGrp;
    }

    public void setAltIdPatSerGrp(String altIdPatSerGrp)
    {
        this.altIdPatSerGrp = altIdPatSerGrp;
    }

    public String getFamilyNoPatSerGrp()
    {
        return familyNoPatSerGrp;
    }

    public void setFamilyNoPatSerGrp(String familyNoPatSerGrp)
    {
        this.familyNoPatSerGrp = familyNoPatSerGrp;
    }

    public String getDfltPatSerGrpType()
    {
        return dfltPatSerGrpType;
    }

    public void setDfltPatSerGrpType(String dfltPatSerGrpType)
    {
        this.dfltPatSerGrpType = dfltPatSerGrpType;
    }

    public String getEmegPatSerGrp()
    {
        return emegPatSerGrp;
    }

    public void setEmegPatSerGrp(String emegPatSerGrp)
    {
        this.emegPatSerGrp = emegPatSerGrp;
    }

    public String getNewbornPatSerGrp()
    {
        return newbornPatSerGrp;
    }

    public void setNewbornPatSerGrp(String newbornPatSerGrp)
    {
        this.newbornPatSerGrp = newbornPatSerGrp;
    }

    public String getAcceptNationalIdNoYn()
    {
        return acceptNationalIdNoYn;
    }

    public void setAcceptNationalIdNoYn(String acceptNationalIdNoYn)
    {
        this.acceptNationalIdNoYn = acceptNationalIdNoYn;
    }

    public Long getNatIdLength()
    {
        return natIdLength;
    }

    public void setNatIdLength(Long natIdLength)
    {
        this.natIdLength = natIdLength;
    }

    public String getNatIdPrompt()
    {
        return natIdPrompt;
    }

    public void setNatIdPrompt(String natIdPrompt)
    {
        this.natIdPrompt = natIdPrompt;
    }

    public String getNatIdChkDigitScheme()
    {
        return natIdChkDigitScheme;
    }

    public void setNatIdChkDigitScheme(String natIdChkDigitScheme)
    {
        this.natIdChkDigitScheme = natIdChkDigitScheme;
    }

    public String getNatIdChkLen()
    {
        return natIdChkLen;
    }

    public void setNatIdChkLen(String natIdChkLen)
    {
        this.natIdChkLen = natIdChkLen;
    }

    public String getNatIdCheckDigitId()
    {
        return natIdCheckDigitId;
    }

    public void setNatIdCheckDigitId(String natIdCheckDigitId)
    {
        this.natIdCheckDigitId = natIdCheckDigitId;
    }

    public String getNatIdReqdAllSeries()
    {
        return natIdReqdAllSeries;
    }

    public void setNatIdReqdAllSeries(String natIdReqdAllSeries)
    {
        this.natIdReqdAllSeries = natIdReqdAllSeries;
    }

    public String getInvokeRoutine()
    {
        return invokeRoutine;
    }

    public void setInvokeRoutine(String invokeRoutine)
    {
        this.invokeRoutine = invokeRoutine;
    }

    public String getNatDataSourceId()
    {
        return natDataSourceId;
    }

    public void setNatDataSourceId(String natDataSourceId)
    {
        this.natDataSourceId = natDataSourceId;
    }

    public String getIdChangeAllowedForSeries()
    {
        return idChangeAllowedForSeries;
    }

    public void setIdChangeAllowedForSeries(String idChangeAllowedForSeries)
    {
        this.idChangeAllowedForSeries = idChangeAllowedForSeries;
    }

    public String getFamilyNoLinkYn()
    {
        return familyNoLinkYn;
    }

    public void setFamilyNoLinkYn(String familyNoLinkYn)
    {
        this.familyNoLinkYn = familyNoLinkYn;
    }

    public String getHeadPatientNoUseYn()
    {
        return headPatientNoUseYn;
    }

    public void setHeadPatientNoUseYn(String headPatientNoUseYn)
    {
        this.headPatientNoUseYn = headPatientNoUseYn;
    }

    public String getFamilyOrgIdAcceptYn()
    {
        return familyOrgIdAcceptYn;
    }

    public void setFamilyOrgIdAcceptYn(String familyOrgIdAcceptYn)
    {
        this.familyOrgIdAcceptYn = familyOrgIdAcceptYn;
    }

    public String getCitizenNationalityCode()
    {
        return citizenNationalityCode;
    }

    public void setCitizenNationalityCode(String citizenNationalityCode)
    {
        this.citizenNationalityCode = citizenNationalityCode;
    }

    public String getGeneralAlertYn()
    {
        return generalAlertYn;
    }

    public void setGeneralAlertYn(String generalAlertYn)
    {
        this.generalAlertYn = generalAlertYn;
    }

    public String getSuspendServiceYn()
    {
        return suspendServiceYn;
    }

    public void setSuspendServiceYn(String suspendServiceYn)
    {
        this.suspendServiceYn = suspendServiceYn;
    }

    public String getSingleOrMultiFilesInd()
    {
        return singleOrMultiFilesInd;
    }

    public void setSingleOrMultiFilesInd(String singleOrMultiFilesInd)
    {
        this.singleOrMultiFilesInd = singleOrMultiFilesInd;
    }

    public String getSeparateFileNoYn()
    {
        return separateFileNoYn;
    }

    public void setSeparateFileNoYn(String separateFileNoYn)
    {
        this.separateFileNoYn = separateFileNoYn;
    }

    public String getExtSystemInterfaceYn()
    {
        return extSystemInterfaceYn;
    }

    public void setExtSystemInterfaceYn(String extSystemInterfaceYn)
    {
        this.extSystemInterfaceYn = extSystemInterfaceYn;
    }

    public String getNamePrefixAcceptYn()
    {
        return namePrefixAcceptYn;
    }

    public void setNamePrefixAcceptYn(String namePrefixAcceptYn)
    {
        this.namePrefixAcceptYn = namePrefixAcceptYn;
    }

    public String getNamePrefixReqdYn()
    {
        return namePrefixReqdYn;
    }

    public void setNamePrefixReqdYn(String namePrefixReqdYn)
    {
        this.namePrefixReqdYn = namePrefixReqdYn;
    }

    public String getNamePrefixPrompt()
    {
        return namePrefixPrompt;
    }

    public void setNamePrefixPrompt(String namePrefixPrompt)
    {
        this.namePrefixPrompt = namePrefixPrompt;
    }

    public String getFirstNameAcceptYn()
    {
        return firstNameAcceptYn;
    }

    public void setFirstNameAcceptYn(String firstNameAcceptYn)
    {
        this.firstNameAcceptYn = firstNameAcceptYn;
    }

    public String getFirstNameReqdYn()
    {
        return firstNameReqdYn;
    }

    public void setFirstNameReqdYn(String firstNameReqdYn)
    {
        this.firstNameReqdYn = firstNameReqdYn;
    }

    public Long getFirstNameOrder()
    {
        return firstNameOrder;
    }

    public void setFirstNameOrder(Long firstNameOrder)
    {
        this.firstNameOrder = firstNameOrder;
    }

    public String getFirstNamePrompt()
    {
        return firstNamePrompt;
    }

    public void setFirstNamePrompt(String firstNamePrompt)
    {
        this.firstNamePrompt = firstNamePrompt;
    }

    public String getSecondNameAcceptYn()
    {
        return secondNameAcceptYn;
    }

    public void setSecondNameAcceptYn(String secondNameAcceptYn)
    {
        this.secondNameAcceptYn = secondNameAcceptYn;
    }

    public String getSecondNameReqdYn()
    {
        return secondNameReqdYn;
    }

    public void setSecondNameReqdYn(String secondNameReqdYn)
    {
        this.secondNameReqdYn = secondNameReqdYn;
    }

    public Long getSecondNameOrder()
    {
        return secondNameOrder;
    }

    public void setSecondNameOrder(Long secondNameOrder)
    {
        this.secondNameOrder = secondNameOrder;
    }

    public String getSecondNamePrompt()
    {
        return secondNamePrompt;
    }

    public void setSecondNamePrompt(String secondNamePrompt)
    {
        this.secondNamePrompt = secondNamePrompt;
    }

    public String getThirdNameAcceptYn()
    {
        return thirdNameAcceptYn;
    }

    public void setThirdNameAcceptYn(String thirdNameAcceptYn)
    {
        this.thirdNameAcceptYn = thirdNameAcceptYn;
    }

    public String getThirdNameReqdYn()
    {
        return thirdNameReqdYn;
    }

    public void setThirdNameReqdYn(String thirdNameReqdYn)
    {
        this.thirdNameReqdYn = thirdNameReqdYn;
    }

    public Long getThirdNameOrder()
    {
        return thirdNameOrder;
    }

    public void setThirdNameOrder(Long thirdNameOrder)
    {
        this.thirdNameOrder = thirdNameOrder;
    }

    public String getThirdNamePrompt()
    {
        return thirdNamePrompt;
    }

    public void setThirdNamePrompt(String thirdNamePrompt)
    {
        this.thirdNamePrompt = thirdNamePrompt;
    }

    public String getFamilyNameAcceptYn()
    {
        return familyNameAcceptYn;
    }

    public void setFamilyNameAcceptYn(String familyNameAcceptYn)
    {
        this.familyNameAcceptYn = familyNameAcceptYn;
    }

    public String getFamilyNameReqdYn()
    {
        return familyNameReqdYn;
    }

    public void setFamilyNameReqdYn(String familyNameReqdYn)
    {
        this.familyNameReqdYn = familyNameReqdYn;
    }

    public Long getFamilyNameOrder()
    {
        return familyNameOrder;
    }

    public void setFamilyNameOrder(Long familyNameOrder)
    {
        this.familyNameOrder = familyNameOrder;
    }

    public String getFamilyNamePrompt()
    {
        return familyNamePrompt;
    }

    public void setFamilyNamePrompt(String familyNamePrompt)
    {
        this.familyNamePrompt = familyNamePrompt;
    }

    public String getFamilyNamePrefixYn()
    {
        return familyNamePrefixYn;
    }

    public void setFamilyNamePrefixYn(String familyNamePrefixYn)
    {
        this.familyNamePrefixYn = familyNamePrefixYn;
    }

    public String getFamilyNoPrompt()
    {
        return familyNoPrompt;
    }

    public void setFamilyNoPrompt(String familyNoPrompt)
    {
        this.familyNoPrompt = familyNoPrompt;
    }

    public String getNameSuffixAcceptYn()
    {
        return nameSuffixAcceptYn;
    }

    public void setNameSuffixAcceptYn(String nameSuffixAcceptYn)
    {
        this.nameSuffixAcceptYn = nameSuffixAcceptYn;
    }

    public String getNameSuffixReqdYn()
    {
        return nameSuffixReqdYn;
    }

    public void setNameSuffixReqdYn(String nameSuffixReqdYn)
    {
        this.nameSuffixReqdYn = nameSuffixReqdYn;
    }

    public String getNameSuffixPrompt()
    {
        return nameSuffixPrompt;
    }

    public void setNameSuffixPrompt(String nameSuffixPrompt)
    {
        this.nameSuffixPrompt = nameSuffixPrompt;
    }

    public String getNamesInOthLangYn()
    {
        return namesInOthLangYn;
    }

    public void setNamesInOthLangYn(String namesInOthLangYn)
    {
        this.namesInOthLangYn = namesInOthLangYn;
    }

    public String getNamePrefixLocLangPrompt()
    {
        return namePrefixLocLangPrompt;
    }

    public void setNamePrefixLocLangPrompt(String namePrefixLocLangPrompt)
    {
        this.namePrefixLocLangPrompt = namePrefixLocLangPrompt;
    }

    public String getFirstNameLocLangPrompt()
    {
        return firstNameLocLangPrompt;
    }

    public void setFirstNameLocLangPrompt(String firstNameLocLangPrompt)
    {
        this.firstNameLocLangPrompt = firstNameLocLangPrompt;
    }

    public String getSecondNameLocLangPrompt()
    {
        return secondNameLocLangPrompt;
    }

    public void setSecondNameLocLangPrompt(String secondNameLocLangPrompt)
    {
        this.secondNameLocLangPrompt = secondNameLocLangPrompt;
    }

    public String getThirdNameLocLangPrompt()
    {
        return thirdNameLocLangPrompt;
    }

    public void setThirdNameLocLangPrompt(String thirdNameLocLangPrompt)
    {
        this.thirdNameLocLangPrompt = thirdNameLocLangPrompt;
    }

    public String getFamilyNameLocLangPrompt()
    {
        return familyNameLocLangPrompt;
    }

    public void setFamilyNameLocLangPrompt(String familyNameLocLangPrompt)
    {
        this.familyNameLocLangPrompt = familyNameLocLangPrompt;
    }

    public String getNameSuffixLocLangPrompt()
    {
        return nameSuffixLocLangPrompt;
    }

    public void setNameSuffixLocLangPrompt(String nameSuffixLocLangPrompt)
    {
        this.nameSuffixLocLangPrompt = nameSuffixLocLangPrompt;
    }

    public Long getMaxPatientAge()
    {
        return maxPatientAge;
    }

    public void setMaxPatientAge(Long maxPatientAge)
    {
        this.maxPatientAge = maxPatientAge;
    }

    public String getNameDervnLogic()
    {
        return nameDervnLogic;
    }

    public void setNameDervnLogic(String nameDervnLogic)
    {
        this.nameDervnLogic = nameDervnLogic;
    }

    public String getNameDervnLogicOthLang()
    {
        return nameDervnLogicOthLang;
    }

    public void setNameDervnLogicOthLang(String nameDervnLogicOthLang)
    {
        this.nameDervnLogicOthLang = nameDervnLogicOthLang;
    }

    public String getDfltSndxType()
    {
        return dfltSndxType;
    }

    public void setDfltSndxType(String dfltSndxType)
    {
        this.dfltSndxType = dfltSndxType;
    }

    public String getDfltCodedPseudoName()
    {
        return dfltCodedPseudoName;
    }

    public void setDfltCodedPseudoName(String dfltCodedPseudoName)
    {
        this.dfltCodedPseudoName = dfltCodedPseudoName;
    }

    public String getEthnicSndxType()
    {
        return ethnicSndxType;
    }

    public void setEthnicSndxType(String ethnicSndxType)
    {
        this.ethnicSndxType = ethnicSndxType;
    }

    public String getAltId1Type()
    {
        return altId1Type;
    }

    public void setAltId1Type(String altId1Type)
    {
        this.altId1Type = altId1Type;
    }

    public Long getAltId1Length()
    {
        return altId1Length;
    }

    public void setAltId1Length(Long altId1Length)
    {
        this.altId1Length = altId1Length;
    }

    public String getAltId1ChkDigitScheme()
    {
        return altId1ChkDigitScheme;
    }

    public void setAltId1ChkDigitScheme(String altId1ChkDigitScheme)
    {
        this.altId1ChkDigitScheme = altId1ChkDigitScheme;
    }

    public String getAltId1ReqdYn()
    {
        return altId1ReqdYn;
    }

    public void setAltId1ReqdYn(String altId1ReqdYn)
    {
        this.altId1ReqdYn = altId1ReqdYn;
    }

    public String getAltId1UniqueYn()
    {
        return altId1UniqueYn;
    }

    public void setAltId1UniqueYn(String altId1UniqueYn)
    {
        this.altId1UniqueYn = altId1UniqueYn;
    }

    public String getAltId1ExpWarnYn()
    {
        return altId1ExpWarnYn;
    }

    public void setAltId1ExpWarnYn(String altId1ExpWarnYn)
    {
        this.altId1ExpWarnYn = altId1ExpWarnYn;
    }

    public Long getAltId1ExpGraceDays()
    {
        return altId1ExpGraceDays;
    }

    public void setAltId1ExpGraceDays(Long altId1ExpGraceDays)
    {
        this.altId1ExpGraceDays = altId1ExpGraceDays;
    }

    public String getAltId1AcceptOthPatSerYn()
    {
        return altId1AcceptOthPatSerYn;
    }

    public void setAltId1AcceptOthPatSerYn(String altId1AcceptOthPatSerYn)
    {
        this.altId1AcceptOthPatSerYn = altId1AcceptOthPatSerYn;
    }

    public String getAltId1AcceptAlphanumericYn()
    {
        return altId1AcceptAlphanumericYn;
    }

    public void setAltId1AcceptAlphanumericYn(String altId1AcceptAlphanumericYn)
    {
        this.altId1AcceptAlphanumericYn = altId1AcceptAlphanumericYn;
    }

    public String getAltId1RoutineYn()
    {
        return altId1RoutineYn;
    }

    public void setAltId1RoutineYn(String altId1RoutineYn)
    {
        this.altId1RoutineYn = altId1RoutineYn;
    }

    public String getAltId1DataSourceId()
    {
        return altId1DataSourceId;
    }

    public void setAltId1DataSourceId(String altId1DataSourceId)
    {
        this.altId1DataSourceId = altId1DataSourceId;
    }

    public String getAltId1AdvAlertReqdYn()
    {
        return altId1AdvAlertReqdYn;
    }

    public void setAltId1AdvAlertReqdYn(String altId1AdvAlertReqdYn)
    {
        this.altId1AdvAlertReqdYn = altId1AdvAlertReqdYn;
    }

    public Long getAltId1AdvAlertDays()
    {
        return altId1AdvAlertDays;
    }

    public void setAltId1AdvAlertDays(Long altId1AdvAlertDays)
    {
        this.altId1AdvAlertDays = altId1AdvAlertDays;
    }

    public String getAltId1LenValidationYn()
    {
        return altId1LenValidationYn;
    }

    public void setAltId1LenValidationYn(String altId1LenValidationYn)
    {
        this.altId1LenValidationYn = altId1LenValidationYn;
    }

    public String getAltId1ExpDateAcceptYn()
    {
        return altId1ExpDateAcceptYn;
    }

    public void setAltId1ExpDateAcceptYn(String altId1ExpDateAcceptYn)
    {
        this.altId1ExpDateAcceptYn = altId1ExpDateAcceptYn;
    }

    public String getAltId2Type()
    {
        return altId2Type;
    }

    public void setAltId2Type(String altId2Type)
    {
        this.altId2Type = altId2Type;
    }

    public Long getAltId2Length()
    {
        return altId2Length;
    }

    public void setAltId2Length(Long altId2Length)
    {
        this.altId2Length = altId2Length;
    }

    public String getAltId2ChkDigitScheme()
    {
        return altId2ChkDigitScheme;
    }

    public void setAltId2ChkDigitScheme(String altId2ChkDigitScheme)
    {
        this.altId2ChkDigitScheme = altId2ChkDigitScheme;
    }

    public String getAltId2ReqdYn()
    {
        return altId2ReqdYn;
    }

    public void setAltId2ReqdYn(String altId2ReqdYn)
    {
        this.altId2ReqdYn = altId2ReqdYn;
    }

    public String getAltId2UniqueYn()
    {
        return altId2UniqueYn;
    }

    public void setAltId2UniqueYn(String altId2UniqueYn)
    {
        this.altId2UniqueYn = altId2UniqueYn;
    }

    public String getAltId2ExpWarnYn()
    {
        return altId2ExpWarnYn;
    }

    public void setAltId2ExpWarnYn(String altId2ExpWarnYn)
    {
        this.altId2ExpWarnYn = altId2ExpWarnYn;
    }

    public Long getAltId2ExpGraceDays()
    {
        return altId2ExpGraceDays;
    }

    public void setAltId2ExpGraceDays(Long altId2ExpGraceDays)
    {
        this.altId2ExpGraceDays = altId2ExpGraceDays;
    }

    public String getAltId2RoutineYn()
    {
        return altId2RoutineYn;
    }

    public void setAltId2RoutineYn(String altId2RoutineYn)
    {
        this.altId2RoutineYn = altId2RoutineYn;
    }

    public String getAltId2DataSourceId()
    {
        return altId2DataSourceId;
    }

    public void setAltId2DataSourceId(String altId2DataSourceId)
    {
        this.altId2DataSourceId = altId2DataSourceId;
    }

    public String getAltId2AdvAlertReqdYn()
    {
        return altId2AdvAlertReqdYn;
    }

    public void setAltId2AdvAlertReqdYn(String altId2AdvAlertReqdYn)
    {
        this.altId2AdvAlertReqdYn = altId2AdvAlertReqdYn;
    }

    public Long getAltId2AdvAlertDays()
    {
        return altId2AdvAlertDays;
    }

    public void setAltId2AdvAlertDays(Long altId2AdvAlertDays)
    {
        this.altId2AdvAlertDays = altId2AdvAlertDays;
    }

    public String getAltId2LenValidationYn()
    {
        return altId2LenValidationYn;
    }

    public void setAltId2LenValidationYn(String altId2LenValidationYn)
    {
        this.altId2LenValidationYn = altId2LenValidationYn;
    }

    public String getAltId2ExpDateAcceptYn()
    {
        return altId2ExpDateAcceptYn;
    }

    public void setAltId2ExpDateAcceptYn(String altId2ExpDateAcceptYn)
    {
        this.altId2ExpDateAcceptYn = altId2ExpDateAcceptYn;
    }

    public String getAltId3Type()
    {
        return altId3Type;
    }

    public void setAltId3Type(String altId3Type)
    {
        this.altId3Type = altId3Type;
    }

    public Long getAltId3Length()
    {
        return altId3Length;
    }

    public void setAltId3Length(Long altId3Length)
    {
        this.altId3Length = altId3Length;
    }

    public String getAltId3ChkDigitScheme()
    {
        return altId3ChkDigitScheme;
    }

    public void setAltId3ChkDigitScheme(String altId3ChkDigitScheme)
    {
        this.altId3ChkDigitScheme = altId3ChkDigitScheme;
    }

    public String getAltId3ReqdYn()
    {
        return altId3ReqdYn;
    }

    public void setAltId3ReqdYn(String altId3ReqdYn)
    {
        this.altId3ReqdYn = altId3ReqdYn;
    }

    public String getAltId3UniqueYn()
    {
        return altId3UniqueYn;
    }

    public void setAltId3UniqueYn(String altId3UniqueYn)
    {
        this.altId3UniqueYn = altId3UniqueYn;
    }

    public String getAltId3ExpWarnYn()
    {
        return altId3ExpWarnYn;
    }

    public void setAltId3ExpWarnYn(String altId3ExpWarnYn)
    {
        this.altId3ExpWarnYn = altId3ExpWarnYn;
    }

    public Long getAltId3ExpGraceDays()
    {
        return altId3ExpGraceDays;
    }

    public void setAltId3ExpGraceDays(Long altId3ExpGraceDays)
    {
        this.altId3ExpGraceDays = altId3ExpGraceDays;
    }

    public String getAltId3RoutineYn()
    {
        return altId3RoutineYn;
    }

    public void setAltId3RoutineYn(String altId3RoutineYn)
    {
        this.altId3RoutineYn = altId3RoutineYn;
    }

    public String getAltId3DataSourceId()
    {
        return altId3DataSourceId;
    }

    public void setAltId3DataSourceId(String altId3DataSourceId)
    {
        this.altId3DataSourceId = altId3DataSourceId;
    }

    public String getAltId3AdvAlertReqdYn()
    {
        return altId3AdvAlertReqdYn;
    }

    public void setAltId3AdvAlertReqdYn(String altId3AdvAlertReqdYn)
    {
        this.altId3AdvAlertReqdYn = altId3AdvAlertReqdYn;
    }

    public Long getAltId3AdvAlertDays()
    {
        return altId3AdvAlertDays;
    }

    public void setAltId3AdvAlertDays(Long altId3AdvAlertDays)
    {
        this.altId3AdvAlertDays = altId3AdvAlertDays;
    }

    public String getAltId3LenValidationYn()
    {
        return altId3LenValidationYn;
    }

    public void setAltId3LenValidationYn(String altId3LenValidationYn)
    {
        this.altId3LenValidationYn = altId3LenValidationYn;
    }

    public String getAltId3ExpDateAcceptYn()
    {
        return altId3ExpDateAcceptYn;
    }

    public void setAltId3ExpDateAcceptYn(String altId3ExpDateAcceptYn)
    {
        this.altId3ExpDateAcceptYn = altId3ExpDateAcceptYn;
    }

    public String getAltId4Type()
    {
        return altId4Type;
    }

    public void setAltId4Type(String altId4Type)
    {
        this.altId4Type = altId4Type;
    }

    public Long getAltId4Length()
    {
        return altId4Length;
    }

    public void setAltId4Length(Long altId4Length)
    {
        this.altId4Length = altId4Length;
    }

    public String getAltId4ChkDigitScheme()
    {
        return altId4ChkDigitScheme;
    }

    public void setAltId4ChkDigitScheme(String altId4ChkDigitScheme)
    {
        this.altId4ChkDigitScheme = altId4ChkDigitScheme;
    }

    public String getAltId4ReqdYn()
    {
        return altId4ReqdYn;
    }

    public void setAltId4ReqdYn(String altId4ReqdYn)
    {
        this.altId4ReqdYn = altId4ReqdYn;
    }

    public String getAltId4UniqueYn()
    {
        return altId4UniqueYn;
    }

    public void setAltId4UniqueYn(String altId4UniqueYn)
    {
        this.altId4UniqueYn = altId4UniqueYn;
    }

    public String getAltId4ExpWarnYn()
    {
        return altId4ExpWarnYn;
    }

    public void setAltId4ExpWarnYn(String altId4ExpWarnYn)
    {
        this.altId4ExpWarnYn = altId4ExpWarnYn;
    }

    public Long getAltId4ExpGraceDays()
    {
        return altId4ExpGraceDays;
    }

    public void setAltId4ExpGraceDays(Long altId4ExpGraceDays)
    {
        this.altId4ExpGraceDays = altId4ExpGraceDays;
    }

    public String getAltId4RoutineYn()
    {
        return altId4RoutineYn;
    }

    public void setAltId4RoutineYn(String altId4RoutineYn)
    {
        this.altId4RoutineYn = altId4RoutineYn;
    }

    public String getAltId4DataSourceId()
    {
        return altId4DataSourceId;
    }

    public void setAltId4DataSourceId(String altId4DataSourceId)
    {
        this.altId4DataSourceId = altId4DataSourceId;
    }

    public String getAltId4AdvAlertReqdYn()
    {
        return altId4AdvAlertReqdYn;
    }

    public void setAltId4AdvAlertReqdYn(String altId4AdvAlertReqdYn)
    {
        this.altId4AdvAlertReqdYn = altId4AdvAlertReqdYn;
    }

    public Long getAltId4AdvAlertDays()
    {
        return altId4AdvAlertDays;
    }

    public void setAltId4AdvAlertDays(Long altId4AdvAlertDays)
    {
        this.altId4AdvAlertDays = altId4AdvAlertDays;
    }

    public String getAltId4LenValidationYn()
    {
        return altId4LenValidationYn;
    }

    public void setAltId4LenValidationYn(String altId4LenValidationYn)
    {
        this.altId4LenValidationYn = altId4LenValidationYn;
    }

    public String getAltId4ExpDateAcceptYn()
    {
        return altId4ExpDateAcceptYn;
    }

    public void setAltId4ExpDateAcceptYn(String altId4ExpDateAcceptYn)
    {
        this.altId4ExpDateAcceptYn = altId4ExpDateAcceptYn;
    }

    public String getDfltContactMode1()
    {
        return dfltContactMode1;
    }

    public void setDfltContactMode1(String dfltContactMode1)
    {
        this.dfltContactMode1 = dfltContactMode1;
    }

    public String getDfltContactMode2()
    {
        return dfltContactMode2;
    }

    public void setDfltContactMode2(String dfltContactMode2)
    {
        this.dfltContactMode2 = dfltContactMode2;
    }

    public String getDfltContactMode3()
    {
        return dfltContactMode3;
    }

    public void setDfltContactMode3(String dfltContactMode3)
    {
        this.dfltContactMode3 = dfltContactMode3;
    }

    public String getDfltContactMode4()
    {
        return dfltContactMode4;
    }

    public void setDfltContactMode4(String dfltContactMode4)
    {
        this.dfltContactMode4 = dfltContactMode4;
    }

    public String getDfltContactMode5()
    {
        return dfltContactMode5;
    }

    public void setDfltContactMode5(String dfltContactMode5)
    {
        this.dfltContactMode5 = dfltContactMode5;
    }

    public String getDfltAddrType1()
    {
        return dfltAddrType1;
    }

    public void setDfltAddrType1(String dfltAddrType1)
    {
        this.dfltAddrType1 = dfltAddrType1;
    }

    public String getDfltAddrType2()
    {
        return dfltAddrType2;
    }

    public void setDfltAddrType2(String dfltAddrType2)
    {
        this.dfltAddrType2 = dfltAddrType2;
    }

    public String getDfltAddrType3()
    {
        return dfltAddrType3;
    }

    public void setDfltAddrType3(String dfltAddrType3)
    {
        this.dfltAddrType3 = dfltAddrType3;
    }

    public String getDfltAddrType4()
    {
        return dfltAddrType4;
    }

    public void setDfltAddrType4(String dfltAddrType4)
    {
        this.dfltAddrType4 = dfltAddrType4;
    }

    public String getDfltAddrType5()
    {
        return dfltAddrType5;
    }

    public void setDfltAddrType5(String dfltAddrType5)
    {
        this.dfltAddrType5 = dfltAddrType5;
    }

    public String getDfltRelContactRole1()
    {
        return dfltRelContactRole1;
    }

    public void setDfltRelContactRole1(String dfltRelContactRole1)
    {
        this.dfltRelContactRole1 = dfltRelContactRole1;
    }

    public String getDfltRelContactRole2()
    {
        return dfltRelContactRole2;
    }

    public void setDfltRelContactRole2(String dfltRelContactRole2)
    {
        this.dfltRelContactRole2 = dfltRelContactRole2;
    }

    public String getDfltRelContactRole3()
    {
        return dfltRelContactRole3;
    }

    public void setDfltRelContactRole3(String dfltRelContactRole3)
    {
        this.dfltRelContactRole3 = dfltRelContactRole3;
    }

    public String getDfltRelContactRole4()
    {
        return dfltRelContactRole4;
    }

    public void setDfltRelContactRole4(String dfltRelContactRole4)
    {
        this.dfltRelContactRole4 = dfltRelContactRole4;
    }

    public String getDfltRelContactRole5()
    {
        return dfltRelContactRole5;
    }

    public void setDfltRelContactRole5(String dfltRelContactRole5)
    {
        this.dfltRelContactRole5 = dfltRelContactRole5;
    }

    public String getDfltDoc1Type()
    {
        return dfltDoc1Type;
    }

    public void setDfltDoc1Type(String dfltDoc1Type)
    {
        this.dfltDoc1Type = dfltDoc1Type;
    }

    public String getDfltDoc2Type()
    {
        return dfltDoc2Type;
    }

    public void setDfltDoc2Type(String dfltDoc2Type)
    {
        this.dfltDoc2Type = dfltDoc2Type;
    }

    public String getDfltDoc3Type()
    {
        return dfltDoc3Type;
    }

    public void setDfltDoc3Type(String dfltDoc3Type)
    {
        this.dfltDoc3Type = dfltDoc3Type;
    }

    public String getDfltDoc4Type()
    {
        return dfltDoc4Type;
    }

    public void setDfltDoc4Type(String dfltDoc4Type)
    {
        this.dfltDoc4Type = dfltDoc4Type;
    }

    public String getDfltDoc5Type()
    {
        return dfltDoc5Type;
    }

    public void setDfltDoc5Type(String dfltDoc5Type)
    {
        this.dfltDoc5Type = dfltDoc5Type;
    }

    public String getDfltPatFinClass()
    {
        return dfltPatFinClass;
    }

    public void setDfltPatFinClass(String dfltPatFinClass)
    {
        this.dfltPatFinClass = dfltPatFinClass;
    }

    public String getPromptPatFinClassYn()
    {
        return promptPatFinClassYn;
    }

    public void setPromptPatFinClassYn(String promptPatFinClassYn)
    {
        this.promptPatFinClassYn = promptPatFinClassYn;
    }

    public Long getAllowNbRegnWithinDays()
    {
        return allowNbRegnWithinDays;
    }

    public void setAllowNbRegnWithinDays(Long allowNbRegnWithinDays)
    {
        this.allowNbRegnWithinDays = allowNbRegnWithinDays;
    }

    public String getUnitOfWtNb()
    {
        return unitOfWtNb;
    }

    public void setUnitOfWtNb(String unitOfWtNb)
    {
        this.unitOfWtNb = unitOfWtNb;
    }

    public String getUnitOfCircumNb()
    {
        return unitOfCircumNb;
    }

    public void setUnitOfCircumNb(String unitOfCircumNb)
    {
        this.unitOfCircumNb = unitOfCircumNb;
    }

    public String getUnitOfLengthNb()
    {
        return unitOfLengthNb;
    }

    public void setUnitOfLengthNb(String unitOfLengthNb)
    {
        this.unitOfLengthNb = unitOfLengthNb;
    }

    public String getUnitOfGestNb()
    {
        return unitOfGestNb;
    }

    public void setUnitOfGestNb(String unitOfGestNb)
    {
        this.unitOfGestNb = unitOfGestNb;
    }

    public Double getMinWeight()
    {
        return minWeight;
    }

    public void setMinWeight(Double minWeight)
    {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight()
    {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight)
    {
        this.maxWeight = maxWeight;
    }

    public Double getMinChestCircum()
    {
        return minChestCircum;
    }

    public void setMinChestCircum(Double minChestCircum)
    {
        this.minChestCircum = minChestCircum;
    }

    public Double getMaxChestCircum()
    {
        return maxChestCircum;
    }

    public void setMaxChestCircum(Double maxChestCircum)
    {
        this.maxChestCircum = maxChestCircum;
    }

    public Double getMinHeadCircum()
    {
        return minHeadCircum;
    }

    public void setMinHeadCircum(Double minHeadCircum)
    {
        this.minHeadCircum = minHeadCircum;
    }

    public Double getMaxHeadCircum()
    {
        return maxHeadCircum;
    }

    public void setMaxHeadCircum(Double maxHeadCircum)
    {
        this.maxHeadCircum = maxHeadCircum;
    }

    public Double getMinLength()
    {
        return minLength;
    }

    public void setMinLength(Double minLength)
    {
        this.minLength = minLength;
    }

    public Double getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(Double maxLength)
    {
        this.maxLength = maxLength;
    }

    public Long getMinGestation()
    {
        return minGestation;
    }

    public void setMinGestation(Long minGestation)
    {
        this.minGestation = minGestation;
    }

    public Long getMaxGestation()
    {
        return maxGestation;
    }

    public void setMaxGestation(Long maxGestation)
    {
        this.maxGestation = maxGestation;
    }

    public String getNameSuffixMaleNb()
    {
        return nameSuffixMaleNb;
    }

    public void setNameSuffixMaleNb(String nameSuffixMaleNb)
    {
        this.nameSuffixMaleNb = nameSuffixMaleNb;
    }

    public String getNameSuffixFemaleNb()
    {
        return nameSuffixFemaleNb;
    }

    public void setNameSuffixFemaleNb(String nameSuffixFemaleNb)
    {
        this.nameSuffixFemaleNb = nameSuffixFemaleNb;
    }

    public String getReviewNbLinksBefRegYn()
    {
        return reviewNbLinksBefRegYn;
    }

    public void setReviewNbLinksBefRegYn(String reviewNbLinksBefRegYn)
    {
        this.reviewNbLinksBefRegYn = reviewNbLinksBefRegYn;
    }

    public Long getNbMotherMinAge()
    {
        return nbMotherMinAge;
    }

    public void setNbMotherMinAge(Long nbMotherMinAge)
    {
        this.nbMotherMinAge = nbMotherMinAge;
    }

    public String getNbUseMotherSer()
    {
        return nbUseMotherSer;
    }

    public void setNbUseMotherSer(String nbUseMotherSer)
    {
        this.nbUseMotherSer = nbUseMotherSer;
    }

    public Long getNbFatherMinAge()
    {
        return nbFatherMinAge;
    }

    public void setNbFatherMinAge(Long nbFatherMinAge)
    {
        this.nbFatherMinAge = nbFatherMinAge;
    }

    public String getNamePrefixMaleNb()
    {
        return namePrefixMaleNb;
    }

    public void setNamePrefixMaleNb(String namePrefixMaleNb)
    {
        this.namePrefixMaleNb = namePrefixMaleNb;
    }

    public String getNamePrefixFemaleNb()
    {
        return namePrefixFemaleNb;
    }

    public void setNamePrefixFemaleNb(String namePrefixFemaleNb)
    {
        this.namePrefixFemaleNb = namePrefixFemaleNb;
    }

    public String getIdCardTitle()
    {
        return idCardTitle;
    }

    public void setIdCardTitle(String idCardTitle)
    {
        this.idCardTitle = idCardTitle;
    }

    public String getLine1FaceSheetText()
    {
        return line1FaceSheetText;
    }

    public void setLine1FaceSheetText(String line1FaceSheetText)
    {
        this.line1FaceSheetText = line1FaceSheetText;
    }

    public String getLine2FaceSheetText()
    {
        return line2FaceSheetText;
    }

    public void setLine2FaceSheetText(String line2FaceSheetText)
    {
        this.line2FaceSheetText = line2FaceSheetText;
    }

    public String getLine3FaceSheetText()
    {
        return line3FaceSheetText;
    }

    public void setLine3FaceSheetText(String line3FaceSheetText)
    {
        this.line3FaceSheetText = line3FaceSheetText;
    }

    public String getLine4FaceSheetText()
    {
        return line4FaceSheetText;
    }

    public void setLine4FaceSheetText(String line4FaceSheetText)
    {
        this.line4FaceSheetText = line4FaceSheetText;
    }

    public String getLine5FaceSheetText()
    {
        return line5FaceSheetText;
    }

    public void setLine5FaceSheetText(String line5FaceSheetText)
    {
        this.line5FaceSheetText = line5FaceSheetText;
    }

    public String getLine6FaceSheetText()
    {
        return line6FaceSheetText;
    }

    public void setLine6FaceSheetText(String line6FaceSheetText)
    {
        this.line6FaceSheetText = line6FaceSheetText;
    }

    public String getLine7FaceSheetText()
    {
        return line7FaceSheetText;
    }

    public void setLine7FaceSheetText(String line7FaceSheetText)
    {
        this.line7FaceSheetText = line7FaceSheetText;
    }

    public String getLine8FaceSheetText()
    {
        return line8FaceSheetText;
    }

    public void setLine8FaceSheetText(String line8FaceSheetText)
    {
        this.line8FaceSheetText = line8FaceSheetText;
    }

    public String getLine9FaceSheetText()
    {
        return line9FaceSheetText;
    }

    public void setLine9FaceSheetText(String line9FaceSheetText)
    {
        this.line9FaceSheetText = line9FaceSheetText;
    }

    public String getLine10FaceSheetText()
    {
        return line10FaceSheetText;
    }

    public void setLine10FaceSheetText(String line10FaceSheetText)
    {
        this.line10FaceSheetText = line10FaceSheetText;
    }

    public Long getSearchThresholdRecords()
    {
        return searchThresholdRecords;
    }

    public void setSearchThresholdRecords(Long searchThresholdRecords)
    {
        this.searchThresholdRecords = searchThresholdRecords;
    }

    public String getTerminalDigitReqdYn()
    {
        return terminalDigitReqdYn;
    }

    public void setTerminalDigitReqdYn(String terminalDigitReqdYn)
    {
        this.terminalDigitReqdYn = terminalDigitReqdYn;
    }

    public Long getTerminalDigitCount()
    {
        return terminalDigitCount;
    }

    public void setTerminalDigitCount(Long terminalDigitCount)
    {
        this.terminalDigitCount = terminalDigitCount;
    }

    public Long getTerminalDigit1Position()
    {
        return terminalDigit1Position;
    }

    public void setTerminalDigit1Position(Long terminalDigit1Position)
    {
        this.terminalDigit1Position = terminalDigit1Position;
    }

    public Long getTerminalDigit2Position()
    {
        return terminalDigit2Position;
    }

    public void setTerminalDigit2Position(Long terminalDigit2Position)
    {
        this.terminalDigit2Position = terminalDigit2Position;
    }

    public Long getTerminalDigit3Position()
    {
        return terminalDigit3Position;
    }

    public void setTerminalDigit3Position(Long terminalDigit3Position)
    {
        this.terminalDigit3Position = terminalDigit3Position;
    }

    public Long getTerminalDigit4Position()
    {
        return terminalDigit4Position;
    }

    public void setTerminalDigit4Position(Long terminalDigit4Position)
    {
        this.terminalDigit4Position = terminalDigit4Position;
    }

    public Long getTerminalDigit5Position()
    {
        return terminalDigit5Position;
    }

    public void setTerminalDigit5Position(Long terminalDigit5Position)
    {
        this.terminalDigit5Position = terminalDigit5Position;
    }

    public String getAddlField1Prompt()
    {
        return addlField1Prompt;
    }

    public void setAddlField1Prompt(String addlField1Prompt)
    {
        this.addlField1Prompt = addlField1Prompt;
    }

    public Long getAddlField1Length()
    {
        return addlField1Length;
    }

    public void setAddlField1Length(Long addlField1Length)
    {
        this.addlField1Length = addlField1Length;
    }

    public String getAddlField1Section()
    {
        return addlField1Section;
    }

    public void setAddlField1Section(String addlField1Section)
    {
        this.addlField1Section = addlField1Section;
    }

    public String getAddlField2Prompt()
    {
        return addlField2Prompt;
    }

    public void setAddlField2Prompt(String addlField2Prompt)
    {
        this.addlField2Prompt = addlField2Prompt;
    }

    public Long getAddlField2Length()
    {
        return addlField2Length;
    }

    public void setAddlField2Length(Long addlField2Length)
    {
        this.addlField2Length = addlField2Length;
    }

    public String getAddlField2Section()
    {
        return addlField2Section;
    }

    public void setAddlField2Section(String addlField2Section)
    {
        this.addlField2Section = addlField2Section;
    }

    public String getAddlField3Prompt()
    {
        return addlField3Prompt;
    }

    public void setAddlField3Prompt(String addlField3Prompt)
    {
        this.addlField3Prompt = addlField3Prompt;
    }

    public Long getAddlField3Length()
    {
        return addlField3Length;
    }

    public void setAddlField3Length(Long addlField3Length)
    {
        this.addlField3Length = addlField3Length;
    }

    public String getAddlField3Section()
    {
        return addlField3Section;
    }

    public void setAddlField3Section(String addlField3Section)
    {
        this.addlField3Section = addlField3Section;
    }

    public String getAddlField4Prompt()
    {
        return addlField4Prompt;
    }

    public void setAddlField4Prompt(String addlField4Prompt)
    {
        this.addlField4Prompt = addlField4Prompt;
    }

    public Long getAddlField4Length()
    {
        return addlField4Length;
    }

    public void setAddlField4Length(Long addlField4Length)
    {
        this.addlField4Length = addlField4Length;
    }

    public String getAddlField4Section()
    {
        return addlField4Section;
    }

    public void setAddlField4Section(String addlField4Section)
    {
        this.addlField4Section = addlField4Section;
    }

    public String getAddlField5Prompt()
    {
        return addlField5Prompt;
    }

    public void setAddlField5Prompt(String addlField5Prompt)
    {
        this.addlField5Prompt = addlField5Prompt;
    }

    public Long getAddlField5Length()
    {
        return addlField5Length;
    }

    public void setAddlField5Length(Long addlField5Length)
    {
        this.addlField5Length = addlField5Length;
    }

    public String getAddlField5Section()
    {
        return addlField5Section;
    }

    public void setAddlField5Section(String addlField5Section)
    {
        this.addlField5Section = addlField5Section;
    }

    public String getSexHistYn()
    {
        return sexHistYn;
    }

    public void setSexHistYn(String sexHistYn)
    {
        this.sexHistYn = sexHistYn;
    }

    public String getBirthDateHistYn()
    {
        return birthDateHistYn;
    }

    public void setBirthDateHistYn(String birthDateHistYn)
    {
        this.birthDateHistYn = birthDateHistYn;
    }

    public String getLegalNameHistYn()
    {
        return legalNameHistYn;
    }

    public void setLegalNameHistYn(String legalNameHistYn)
    {
        this.legalNameHistYn = legalNameHistYn;
    }

    public String getAliasNameHistYn()
    {
        return aliasNameHistYn;
    }

    public void setAliasNameHistYn(String aliasNameHistYn)
    {
        this.aliasNameHistYn = aliasNameHistYn;
    }

    public String getCodedPseudoNameHistYn()
    {
        return codedPseudoNameHistYn;
    }

    public void setCodedPseudoNameHistYn(String codedPseudoNameHistYn)
    {
        this.codedPseudoNameHistYn = codedPseudoNameHistYn;
    }

    public String getContactNoHistYn()
    {
        return contactNoHistYn;
    }

    public void setContactNoHistYn(String contactNoHistYn)
    {
        this.contactNoHistYn = contactNoHistYn;
    }

    public String getAddressHistYn()
    {
        return addressHistYn;
    }

    public void setAddressHistYn(String addressHistYn)
    {
        this.addressHistYn = addressHistYn;
    }

    public String getOcpnNEmplHistYn()
    {
        return ocpnNEmplHistYn;
    }

    public void setOcpnNEmplHistYn(String ocpnNEmplHistYn)
    {
        this.ocpnNEmplHistYn = ocpnNEmplHistYn;
    }

    public String getGeneralAlertInfoHistYn()
    {
        return generalAlertInfoHistYn;
    }

    public void setGeneralAlertInfoHistYn(String generalAlertInfoHistYn)
    {
        this.generalAlertInfoHistYn = generalAlertInfoHistYn;
    }

    public String getSuspendReinstateHistYn()
    {
        return suspendReinstateHistYn;
    }

    public void setSuspendReinstateHistYn(String suspendReinstateHistYn)
    {
        this.suspendReinstateHistYn = suspendReinstateHistYn;
    }

    public String getInactActHistYn()
    {
        return inactActHistYn;
    }

    public void setInactActHistYn(String inactActHistYn)
    {
        this.inactActHistYn = inactActHistYn;
    }

    public String getRecRevokeDeathHistYn()
    {
        return recRevokeDeathHistYn;
    }

    public void setRecRevokeDeathHistYn(String recRevokeDeathHistYn)
    {
        this.recRevokeDeathHistYn = recRevokeDeathHistYn;
    }

    public String getAltId1HistYn()
    {
        return altId1HistYn;
    }

    public void setAltId1HistYn(String altId1HistYn)
    {
        this.altId1HistYn = altId1HistYn;
    }

    public String getAltId2HistYn()
    {
        return altId2HistYn;
    }

    public void setAltId2HistYn(String altId2HistYn)
    {
        this.altId2HistYn = altId2HistYn;
    }

    public String getAltId3HistYn()
    {
        return altId3HistYn;
    }

    public void setAltId3HistYn(String altId3HistYn)
    {
        this.altId3HistYn = altId3HistYn;
    }

    public String getAltId4HistYn()
    {
        return altId4HistYn;
    }

    public void setAltId4HistYn(String altId4HistYn)
    {
        this.altId4HistYn = altId4HistYn;
    }

    public String getNationalityHistYn()
    {
        return nationalityHistYn;
    }

    public void setNationalityHistYn(String nationalityHistYn)
    {
        this.nationalityHistYn = nationalityHistYn;
    }

    public String getHrInterfaceYn()
    {
        return hrInterfaceYn;
    }

    public void setHrInterfaceYn(String hrInterfaceYn)
    {
        this.hrInterfaceYn = hrInterfaceYn;
    }

    public String getHrCheckDigitScheme()
    {
        return hrCheckDigitScheme;
    }

    public void setHrCheckDigitScheme(String hrCheckDigitScheme)
    {
        this.hrCheckDigitScheme = hrCheckDigitScheme;
    }

    public String getHisInterfaceYn()
    {
        return hisInterfaceYn;
    }

    public void setHisInterfaceYn(String hisInterfaceYn)
    {
        this.hisInterfaceYn = hisInterfaceYn;
    }

    public Long getAgeLimitForService()
    {
        return ageLimitForService;
    }

    public void setAgeLimitForService(Long ageLimitForService)
    {
        this.ageLimitForService = ageLimitForService;
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

    public String getPatNameAsMultipartYn()
    {
        return patNameAsMultipartYn;
    }

    public void setPatNameAsMultipartYn(String patNameAsMultipartYn)
    {
        this.patNameAsMultipartYn = patNameAsMultipartYn;
    }

    public String getAcceptOthAltIdYn()
    {
        return acceptOthAltIdYn;
    }

    public void setAcceptOthAltIdYn(String acceptOthAltIdYn)
    {
        this.acceptOthAltIdYn = acceptOthAltIdYn;
    }

    public String getAllowNbRegnUnit()
    {
        return allowNbRegnUnit;
    }

    public void setAllowNbRegnUnit(String allowNbRegnUnit)
    {
        this.allowNbRegnUnit = allowNbRegnUnit;
    }

    public String getCreateFileAtAdmission()
    {
        return createFileAtAdmission;
    }

    public void setCreateFileAtAdmission(String createFileAtAdmission)
    {
        this.createFileAtAdmission = createFileAtAdmission;
    }

    public String getCreateFileAtPatRegnYn()
    {
        return createFileAtPatRegnYn;
    }

    public void setCreateFileAtPatRegnYn(String createFileAtPatRegnYn)
    {
        this.createFileAtPatRegnYn = createFileAtPatRegnYn;
    }

    public String getCreateFileAtRegAttYn()
    {
        return createFileAtRegAttYn;
    }

    public void setCreateFileAtRegAttYn(String createFileAtRegAttYn)
    {
        this.createFileAtRegAttYn = createFileAtRegAttYn;
    }

    public String getCreateFileAtRegVisitYn()
    {
        return createFileAtRegVisitYn;
    }

    public void setCreateFileAtRegVisitYn(String createFileAtRegVisitYn)
    {
        this.createFileAtRegVisitYn = createFileAtRegVisitYn;
    }

    public String getFileTypeApplYn()
    {
        return fileTypeApplYn;
    }

    public void setFileTypeApplYn(String fileTypeApplYn)
    {
        this.fileTypeApplYn = fileTypeApplYn;
    }

    public String getGenSlnoUnknownPatYn()
    {
        return genSlnoUnknownPatYn;
    }

    public void setGenSlnoUnknownPatYn(String genSlnoUnknownPatYn)
    {
        this.genSlnoUnknownPatYn = genSlnoUnknownPatYn;
    }

    public String getMaintainDocOrFile()
    {
        return maintainDocOrFile;
    }

    public void setMaintainDocOrFile(String maintainDocOrFile)
    {
        this.maintainDocOrFile = maintainDocOrFile;
    }

    public Long getMaxMultipleBirthRegnHrs()
    {
        return maxMultipleBirthRegnHrs;
    }

    public void setMaxMultipleBirthRegnHrs(Long maxMultipleBirthRegnHrs)
    {
        this.maxMultipleBirthRegnHrs = maxMultipleBirthRegnHrs;
    }

    public String getNbFemaleRelnship()
    {
        return nbFemaleRelnship;
    }

    public void setNbFemaleRelnship(String nbFemaleRelnship)
    {
        this.nbFemaleRelnship = nbFemaleRelnship;
    }

    public String getNbMaleRelnship()
    {
        return nbMaleRelnship;
    }

    public void setNbMaleRelnship(String nbMaleRelnship)
    {
        this.nbMaleRelnship = nbMaleRelnship;
    }

    public String getNbMinGestBet2Dely()
    {
        return nbMinGestBet2Dely;
    }

    public void setNbMinGestBet2Dely(String nbMinGestBet2Dely)
    {
        this.nbMinGestBet2Dely = nbMinGestBet2Dely;
    }

    public Long getNbMotherCutoffAge()
    {
        return nbMotherCutoffAge;
    }

    public void setNbMotherCutoffAge(Long nbMotherCutoffAge)
    {
        this.nbMotherCutoffAge = nbMotherCutoffAge;
    }

    public Long getNbMotherUpperAge()
    {
        return nbMotherUpperAge;
    }

    public void setNbMotherUpperAge(Long nbMotherUpperAge)
    {
        this.nbMotherUpperAge = nbMotherUpperAge;
    }

    public String getNbUnknownRelnship()
    {
        return nbUnknownRelnship;
    }

    public void setNbUnknownRelnship(String nbUnknownRelnship)
    {
        this.nbUnknownRelnship = nbUnknownRelnship;
    }

    public String getUnitOfChestCircumNb()
    {
        return unitOfChestCircumNb;
    }

    public void setUnitOfChestCircumNb(String unitOfChestCircumNb)
    {
        this.unitOfChestCircumNb = unitOfChestCircumNb;
    }

    public String getCreateFileAtDcAdmissionYn()
    {
        return createFileAtDcAdmissionYn;
    }

    public void setCreateFileAtDcAdmissionYn(String createFileAtDcAdmissionYn)
    {
        this.createFileAtDcAdmissionYn = createFileAtDcAdmissionYn;
    }

    public String getDefaultRaceCode()
    {
        return defaultRaceCode;
    }

    public void setDefaultRaceCode(String defaultRaceCode)
    {
        this.defaultRaceCode = defaultRaceCode;
    }

    public String getAcptApptRfrlInRegPatYn()
    {
        return acptApptRfrlInRegPatYn;
    }

    public void setAcptApptRfrlInRegPatYn(String acptApptRfrlInRegPatYn)
    {
        this.acptApptRfrlInRegPatYn = acptApptRfrlInRegPatYn;
    }

    public String getDfltAltId1InEmpIdYn()
    {
        return dfltAltId1InEmpIdYn;
    }

    public void setDfltAltId1InEmpIdYn(String dfltAltId1InEmpIdYn)
    {
        this.dfltAltId1InEmpIdYn = dfltAltId1InEmpIdYn;
    }

    public String getInvokeChgPatDtlsFmNbYn()
    {
        return invokeChgPatDtlsFmNbYn;
    }

    public void setInvokeChgPatDtlsFmNbYn(String invokeChgPatDtlsFmNbYn)
    {
        this.invokeChgPatDtlsFmNbYn = invokeChgPatDtlsFmNbYn;
    }

    public String getMappedAltIdOrgMemberId()
    {
        return mappedAltIdOrgMemberId;
    }

    public void setMappedAltIdOrgMemberId(String mappedAltIdOrgMemberId)
    {
        this.mappedAltIdOrgMemberId = mappedAltIdOrgMemberId;
    }

    public String getOrgMemberRelationshipCode()
    {
        return orgMemberRelationshipCode;
    }

    public void setOrgMemberRelationshipCode(String orgMemberRelationshipCode)
    {
        this.orgMemberRelationshipCode = orgMemberRelationshipCode;
    }

    public String getEntitlementByPatCatYn()
    {
        return entitlementByPatCatYn;
    }

    public void setEntitlementByPatCatYn(String entitlementByPatCatYn)
    {
        this.entitlementByPatCatYn = entitlementByPatCatYn;
    }

    public String getFamilyLinkHistYn()
    {
        return familyLinkHistYn;
    }

    public void setFamilyLinkHistYn(String familyLinkHistYn)
    {
        this.familyLinkHistYn = familyLinkHistYn;
    }

    public String getOrgMemberHistYn()
    {
        return orgMemberHistYn;
    }

    public void setOrgMemberHistYn(String orgMemberHistYn)
    {
        this.orgMemberHistYn = orgMemberHistYn;
    }

    public String getPatCatHistYn()
    {
        return patCatHistYn;
    }

    public void setPatCatHistYn(String patCatHistYn)
    {
        this.patCatHistYn = patCatHistYn;
    }

    public String getNatIdHistYn()
    {
        return natIdHistYn;
    }

    public void setNatIdHistYn(String natIdHistYn)
    {
        this.natIdHistYn = natIdHistYn;
    }

    public String getBirthPlaceCodeHistYn()
    {
        return birthPlaceCodeHistYn;
    }

    public void setBirthPlaceCodeHistYn(String birthPlaceCodeHistYn)
    {
        this.birthPlaceCodeHistYn = birthPlaceCodeHistYn;
    }

    public String getNamePfxReqdForOrgMemYn()
    {
        return namePfxReqdForOrgMemYn;
    }

    public void setNamePfxReqdForOrgMemYn(String namePfxReqdForOrgMemYn)
    {
        this.namePfxReqdForOrgMemYn = namePfxReqdForOrgMemYn;
    }

    public String getAltId1NoncitizenYn()
    {
        return altId1NoncitizenYn;
    }

    public void setAltId1NoncitizenYn(String altId1NoncitizenYn)
    {
        this.altId1NoncitizenYn = altId1NoncitizenYn;
    }

    public String getAltId2NoncitizenYn()
    {
        return altId2NoncitizenYn;
    }

    public void setAltId2NoncitizenYn(String altId2NoncitizenYn)
    {
        this.altId2NoncitizenYn = altId2NoncitizenYn;
    }

    public String getAltId2AcceptAlphanumericYn()
    {
        return altId2AcceptAlphanumericYn;
    }

    public void setAltId2AcceptAlphanumericYn(String altId2AcceptAlphanumericYn)
    {
        this.altId2AcceptAlphanumericYn = altId2AcceptAlphanumericYn;
    }

    public String getAltId3AcceptAlphanumericYn()
    {
        return altId3AcceptAlphanumericYn;
    }

    public void setAltId3AcceptAlphanumericYn(String altId3AcceptAlphanumericYn)
    {
        this.altId3AcceptAlphanumericYn = altId3AcceptAlphanumericYn;
    }

    public String getAltId4AcceptAlphanumericYn()
    {
        return altId4AcceptAlphanumericYn;
    }

    public void setAltId4AcceptAlphanumericYn(String altId4AcceptAlphanumericYn)
    {
        this.altId4AcceptAlphanumericYn = altId4AcceptAlphanumericYn;
    }

    private String moduleId;
    private Long patientIdLength;
    private String patientNoCtrl;
    private String genPatSerGrp;
    private String natIdPatSerGrp;
    private String altIdPatSerGrp;
    private String familyNoPatSerGrp;
    private String dfltPatSerGrpType;
    private String emegPatSerGrp;
    private String newbornPatSerGrp;
    private String acceptNationalIdNoYn;
    private Long natIdLength;
    private String natIdPrompt;
    private String natIdChkDigitScheme;
    private String natIdChkLen;
    private String natIdCheckDigitId;
    private String natIdReqdAllSeries;
    private String invokeRoutine;
    private String natDataSourceId;
    private String idChangeAllowedForSeries;
    private String familyNoLinkYn;
    private String headPatientNoUseYn;
    private String familyOrgIdAcceptYn;
    private String citizenNationalityCode;
    private String generalAlertYn;
    private String suspendServiceYn;
    private String singleOrMultiFilesInd;
    private String separateFileNoYn;
    private String extSystemInterfaceYn;
    private String namePrefixAcceptYn;
    private String namePrefixReqdYn;
    private String namePrefixPrompt;
    private String firstNameAcceptYn;
    private String firstNameReqdYn;
    private Long firstNameOrder;
    private String firstNamePrompt;
    private String secondNameAcceptYn;
    private String secondNameReqdYn;
    private Long secondNameOrder;
    private String secondNamePrompt;
    private String thirdNameAcceptYn;
    private String thirdNameReqdYn;
    private Long thirdNameOrder;
    private String thirdNamePrompt;
    private String familyNameAcceptYn;
    private String familyNameReqdYn;
    private Long familyNameOrder;
    private String familyNamePrompt;
    private String familyNamePrefixYn;
    private String familyNoPrompt;
    private String nameSuffixAcceptYn;
    private String nameSuffixReqdYn;
    private String nameSuffixPrompt;
    private String namesInOthLangYn;
    private String namePrefixLocLangPrompt;
    private String firstNameLocLangPrompt;
    private String secondNameLocLangPrompt;
    private String thirdNameLocLangPrompt;
    private String familyNameLocLangPrompt;
    private String nameSuffixLocLangPrompt;
    private Long maxPatientAge;
    private String nameDervnLogic;
    private String nameDervnLogicOthLang;
    private String dfltSndxType;
    private String dfltCodedPseudoName;
    private String ethnicSndxType;
    private String altId1Type;
    private Long altId1Length;
    private String altId1ChkDigitScheme;
    private String altId1ReqdYn;
    private String altId1UniqueYn;
    private String altId1ExpWarnYn;
    private Long altId1ExpGraceDays;
    private String altId1AcceptOthPatSerYn;
    private String altId1AcceptAlphanumericYn;
    private String altId1RoutineYn;
    private String altId1DataSourceId;
    private String altId1AdvAlertReqdYn;
    private Long altId1AdvAlertDays;
    private String altId1LenValidationYn;
    private String altId1ExpDateAcceptYn;
    private String altId2Type;
    private Long altId2Length;
    private String altId2ChkDigitScheme;
    private String altId2ReqdYn;
    private String altId2UniqueYn;
    private String altId2ExpWarnYn;
    private Long altId2ExpGraceDays;
    private String altId2RoutineYn;
    private String altId2DataSourceId;
    private String altId2AdvAlertReqdYn;
    private Long altId2AdvAlertDays;
    private String altId2LenValidationYn;
    private String altId2ExpDateAcceptYn;
    private String altId3Type;
    private Long altId3Length;
    private String altId3ChkDigitScheme;
    private String altId3ReqdYn;
    private String altId3UniqueYn;
    private String altId3ExpWarnYn;
    private Long altId3ExpGraceDays;
    private String altId3RoutineYn;
    private String altId3DataSourceId;
    private String altId3AdvAlertReqdYn;
    private Long altId3AdvAlertDays;
    private String altId3LenValidationYn;
    private String altId3ExpDateAcceptYn;
    private String altId4Type;
    private Long altId4Length;
    private String altId4ChkDigitScheme;
    private String altId4ReqdYn;
    private String altId4UniqueYn;
    private String altId4ExpWarnYn;
    private Long altId4ExpGraceDays;
    private String altId4RoutineYn;
    private String altId4DataSourceId;
    private String altId4AdvAlertReqdYn;
    private Long altId4AdvAlertDays;
    private String altId4LenValidationYn;
    private String altId4ExpDateAcceptYn;
    private String dfltContactMode1;
    private String dfltContactMode2;
    private String dfltContactMode3;
    private String dfltContactMode4;
    private String dfltContactMode5;
    private String dfltAddrType1;
    private String dfltAddrType2;
    private String dfltAddrType3;
    private String dfltAddrType4;
    private String dfltAddrType5;
    private String dfltRelContactRole1;
    private String dfltRelContactRole2;
    private String dfltRelContactRole3;
    private String dfltRelContactRole4;
    private String dfltRelContactRole5;
    private String dfltDoc1Type;
    private String dfltDoc2Type;
    private String dfltDoc3Type;
    private String dfltDoc4Type;
    private String dfltDoc5Type;
    private String dfltPatFinClass;
    private String promptPatFinClassYn;
    private Long allowNbRegnWithinDays;
    private String unitOfWtNb;
    private String unitOfCircumNb;
    private String unitOfLengthNb;
    private String unitOfGestNb;
    private Double minWeight;
    private Double maxWeight;
    private Double minChestCircum;
    private Double maxChestCircum;
    private Double minHeadCircum;
    private Double maxHeadCircum;
    private Double minLength;
    private Double maxLength;
    private Long minGestation;
    private Long maxGestation;
    private String nameSuffixMaleNb;
    private String nameSuffixFemaleNb;
    private String reviewNbLinksBefRegYn;
    private Long nbMotherMinAge;
    private String nbUseMotherSer;
    private Long nbFatherMinAge;
    private String namePrefixMaleNb;
    private String namePrefixFemaleNb;
    private String idCardTitle;
    private String line1FaceSheetText;
    private String line2FaceSheetText;
    private String line3FaceSheetText;
    private String line4FaceSheetText;
    private String line5FaceSheetText;
    private String line6FaceSheetText;
    private String line7FaceSheetText;
    private String line8FaceSheetText;
    private String line9FaceSheetText;
    private String line10FaceSheetText;
    private Long searchThresholdRecords;
    private String terminalDigitReqdYn;
    private Long terminalDigitCount;
    private Long terminalDigit1Position;
    private Long terminalDigit2Position;
    private Long terminalDigit3Position;
    private Long terminalDigit4Position;
    private Long terminalDigit5Position;
    private String addlField1Prompt;
    private Long addlField1Length;
    private String addlField1Section;
    private String addlField2Prompt;
    private Long addlField2Length;
    private String addlField2Section;
    private String addlField3Prompt;
    private Long addlField3Length;
    private String addlField3Section;
    private String addlField4Prompt;
    private Long addlField4Length;
    private String addlField4Section;
    private String addlField5Prompt;
    private Long addlField5Length;
    private String addlField5Section;
    private String sexHistYn;
    private String birthDateHistYn;
    private String legalNameHistYn;
    private String aliasNameHistYn;
    private String codedPseudoNameHistYn;
    private String contactNoHistYn;
    private String addressHistYn;
    private String ocpnNEmplHistYn;
    private String generalAlertInfoHistYn;
    private String suspendReinstateHistYn;
    private String inactActHistYn;
    private String recRevokeDeathHistYn;
    private String altId1HistYn;
    private String altId2HistYn;
    private String altId3HistYn;
    private String altId4HistYn;
    private String nationalityHistYn;
    private String hrInterfaceYn;
    private String hrCheckDigitScheme;
    private String hisInterfaceYn;
    private Long ageLimitForService;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String patNameAsMultipartYn;
    private String acceptOthAltIdYn;
    private String allowNbRegnUnit;
    private String createFileAtAdmission;
    private String createFileAtPatRegnYn;
    private String createFileAtRegAttYn;
    private String createFileAtRegVisitYn;
    private String fileTypeApplYn;
    private String genSlnoUnknownPatYn;
    private String maintainDocOrFile;
    private Long maxMultipleBirthRegnHrs;
    private String nbFemaleRelnship;
    private String nbMaleRelnship;
    private String nbMinGestBet2Dely;
    private Long nbMotherCutoffAge;
    private Long nbMotherUpperAge;
    private String nbUnknownRelnship;
    private String unitOfChestCircumNb;
    private String createFileAtDcAdmissionYn;
    private String defaultRaceCode;
    private String acptApptRfrlInRegPatYn;
    private String dfltAltId1InEmpIdYn;
    private String invokeChgPatDtlsFmNbYn;
    private String mappedAltIdOrgMemberId;
    private String orgMemberRelationshipCode;
    private String entitlementByPatCatYn;
    private String familyLinkHistYn;
    private String orgMemberHistYn;
    private String patCatHistYn;
    private String natIdHistYn;
    private String birthPlaceCodeHistYn;
    private String namePfxReqdForOrgMemYn;
    private String altId1NoncitizenYn;
    private String altId2NoncitizenYn;
    private String altId2AcceptAlphanumericYn;
    private String altId3AcceptAlphanumericYn;
    private String altId4AcceptAlphanumericYn;
}
