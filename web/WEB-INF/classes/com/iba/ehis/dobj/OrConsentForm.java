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

public class OrConsentForm
    implements Serializable
{

    public OrConsentForm()
    {
        orConsentRefDtls = new HashSet(0);
        orOrderLineConsentDrafts = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        orCatalogConsentDtls = new HashSet(0);
        orOrderCatalogs = new HashSet(0);
    }

    public OrConsentForm(String consentFormId, String consentFormContent, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, 
            String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String consentType)
    {
        orConsentRefDtls = new HashSet(0);
        orOrderLineConsentDrafts = new HashSet(0);
        orConsentRefHdrs = new HashSet(0);
        orCatalogConsentDtls = new HashSet(0);
        orOrderCatalogs = new HashSet(0);
        this.consentFormId = consentFormId;
        this.consentFormContent = consentFormContent;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.consentType = consentType;
    }

    public OrConsentForm(String consentFormId, String consentFormContent, String effStatus, String addedById, Date addedDate, String addedAtWsNo, String addedFacilityId, 
            String modifiedById, Date modifiedDate, String modifiedAtWsNo, String modifiedFacilityId, String consentType, String consentFormLabel, String consentFormat, 
            String consentFormatId, String indexedYn, Set orConsentRefDtls, Set orOrderLineConsentDrafts, Set orConsentRefHdrs, Set orCatalogConsentDtls, Set orOrderCatalogs)
    {
        this.orConsentRefDtls = new HashSet(0);
        this.orOrderLineConsentDrafts = new HashSet(0);
        this.orConsentRefHdrs = new HashSet(0);
        this.orCatalogConsentDtls = new HashSet(0);
        this.orOrderCatalogs = new HashSet(0);
        this.consentFormId = consentFormId;
        this.consentFormContent = consentFormContent;
        this.effStatus = effStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedAtWsNo = addedAtWsNo;
        this.addedFacilityId = addedFacilityId;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.modifiedFacilityId = modifiedFacilityId;
        this.consentType = consentType;
        this.consentFormLabel = consentFormLabel;
        this.consentFormat = consentFormat;
        this.consentFormatId = consentFormatId;
        this.indexedYn = indexedYn;
        this.orConsentRefDtls = orConsentRefDtls;
        this.orOrderLineConsentDrafts = orOrderLineConsentDrafts;
        this.orConsentRefHdrs = orConsentRefHdrs;
        this.orCatalogConsentDtls = orCatalogConsentDtls;
        this.orOrderCatalogs = orOrderCatalogs;
    }

    public String getConsentFormId()
    {
        return consentFormId;
    }

    public void setConsentFormId(String consentFormId)
    {
        this.consentFormId = consentFormId;
    }

    public String getConsentFormContent()
    {
        return consentFormContent;
    }

    public void setConsentFormContent(String consentFormContent)
    {
        this.consentFormContent = consentFormContent;
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

    public String getConsentType()
    {
        return consentType;
    }

    public void setConsentType(String consentType)
    {
        this.consentType = consentType;
    }

    public String getConsentFormLabel()
    {
        return consentFormLabel;
    }

    public void setConsentFormLabel(String consentFormLabel)
    {
        this.consentFormLabel = consentFormLabel;
    }

    public String getConsentFormat()
    {
        return consentFormat;
    }

    public void setConsentFormat(String consentFormat)
    {
        this.consentFormat = consentFormat;
    }

    public String getConsentFormatId()
    {
        return consentFormatId;
    }

    public void setConsentFormatId(String consentFormatId)
    {
        this.consentFormatId = consentFormatId;
    }

    public String getIndexedYn()
    {
        return indexedYn;
    }

    public void setIndexedYn(String indexedYn)
    {
        this.indexedYn = indexedYn;
    }

    public Set getOrConsentRefDtls()
    {
        return orConsentRefDtls;
    }

    public void setOrConsentRefDtls(Set orConsentRefDtls)
    {
        this.orConsentRefDtls = orConsentRefDtls;
    }

    public Set getOrOrderLineConsentDrafts()
    {
        return orOrderLineConsentDrafts;
    }

    public void setOrOrderLineConsentDrafts(Set orOrderLineConsentDrafts)
    {
        this.orOrderLineConsentDrafts = orOrderLineConsentDrafts;
    }

    public Set getOrConsentRefHdrs()
    {
        return orConsentRefHdrs;
    }

    public void setOrConsentRefHdrs(Set orConsentRefHdrs)
    {
        this.orConsentRefHdrs = orConsentRefHdrs;
    }

    public Set getOrCatalogConsentDtls()
    {
        return orCatalogConsentDtls;
    }

    public void setOrCatalogConsentDtls(Set orCatalogConsentDtls)
    {
        this.orCatalogConsentDtls = orCatalogConsentDtls;
    }

    public Set getOrOrderCatalogs()
    {
        return orOrderCatalogs;
    }

    public void setOrOrderCatalogs(Set orOrderCatalogs)
    {
        this.orOrderCatalogs = orOrderCatalogs;
    }

    private String consentFormId;
    private String consentFormContent;
    private String effStatus;
    private String addedById;
    private Date addedDate;
    private String addedAtWsNo;
    private String addedFacilityId;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedAtWsNo;
    private String modifiedFacilityId;
    private String consentType;
    private String consentFormLabel;
    private String consentFormat;
    private String consentFormatId;
    private String indexedYn;
    private Set orConsentRefDtls;
    private Set orOrderLineConsentDrafts;
    private Set orConsentRefHdrs;
    private Set orCatalogConsentDtls;
    private Set orOrderCatalogs;
}
