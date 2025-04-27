/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Source File Name:   LcLoanDtls.java

package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.iba.ehis.dobj:
//            LcLoanDtlsId

public class LcLoanDtls
    implements Serializable
{

    public LcLoanDtls()
    {
    }

    public LcLoanDtls(LcLoanDtlsId id, Date loanDate, String sourceType, String loanedToSourceType, String loanedToSourceCode, String linenItem, Long loanQty, 
            String reasonForLoan, String givenBy, String receivedBy, String loanStatus, String addedById, Date addedDate, String addedFacilityId, 
            String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.id = id;
        this.loanDate = loanDate;
        this.sourceType = sourceType;
        this.loanedToSourceType = loanedToSourceType;
        this.loanedToSourceCode = loanedToSourceCode;
        this.linenItem = linenItem;
        this.loanQty = loanQty;
        this.reasonForLoan = reasonForLoan;
        this.givenBy = givenBy;
        this.receivedBy = receivedBy;
        this.loanStatus = loanStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcLoanDtls(LcLoanDtlsId id, Date loanDate, String sourceType, String sourceCode, String loanedToSourceType, String loanedToSourceCode, String linenItem, 
            Long loanQty, String reasonForLoan, String remarks, String givenBy, String receivedBy, String cancelledBy, Date cancelledDate, 
            String cancelReason, String receivedWriteOff, String receivedBackBy, String givenBackBy, String loanStatus, String addedById, Date addedDate, 
            String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo, Long receivedQty)
    {
        this.id = id;
        this.loanDate = loanDate;
        this.sourceType = sourceType;
        this.sourceCode = sourceCode;
        this.loanedToSourceType = loanedToSourceType;
        this.loanedToSourceCode = loanedToSourceCode;
        this.linenItem = linenItem;
        this.loanQty = loanQty;
        this.reasonForLoan = reasonForLoan;
        this.remarks = remarks;
        this.givenBy = givenBy;
        this.receivedBy = receivedBy;
        this.cancelledBy = cancelledBy;
        this.cancelledDate = cancelledDate;
        this.cancelReason = cancelReason;
        this.receivedWriteOff = receivedWriteOff;
        this.receivedBackBy = receivedBackBy;
        this.givenBackBy = givenBackBy;
        this.loanStatus = loanStatus;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
        this.receivedQty = receivedQty;
    }

    public LcLoanDtlsId getId()
    {
        return id;
    }

    public void setId(LcLoanDtlsId id)
    {
        this.id = id;
    }

    public Date getLoanDate()
    {
        return loanDate;
    }

    public void setLoanDate(Date loanDate)
    {
        this.loanDate = loanDate;
    }

    public String getSourceType()
    {
        return sourceType;
    }

    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public String getLoanedToSourceType()
    {
        return loanedToSourceType;
    }

    public void setLoanedToSourceType(String loanedToSourceType)
    {
        this.loanedToSourceType = loanedToSourceType;
    }

    public String getLoanedToSourceCode()
    {
        return loanedToSourceCode;
    }

    public void setLoanedToSourceCode(String loanedToSourceCode)
    {
        this.loanedToSourceCode = loanedToSourceCode;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public Long getLoanQty()
    {
        return loanQty;
    }

    public void setLoanQty(Long loanQty)
    {
        this.loanQty = loanQty;
    }

    public String getReasonForLoan()
    {
        return reasonForLoan;
    }

    public void setReasonForLoan(String reasonForLoan)
    {
        this.reasonForLoan = reasonForLoan;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getGivenBy()
    {
        return givenBy;
    }

    public void setGivenBy(String givenBy)
    {
        this.givenBy = givenBy;
    }

    public String getReceivedBy()
    {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    public String getCancelledBy()
    {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy)
    {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelledDate()
    {
        return cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate)
    {
        this.cancelledDate = cancelledDate;
    }

    public String getCancelReason()
    {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason)
    {
        this.cancelReason = cancelReason;
    }

    public String getReceivedWriteOff()
    {
        return receivedWriteOff;
    }

    public void setReceivedWriteOff(String receivedWriteOff)
    {
        this.receivedWriteOff = receivedWriteOff;
    }

    public String getReceivedBackBy()
    {
        return receivedBackBy;
    }

    public void setReceivedBackBy(String receivedBackBy)
    {
        this.receivedBackBy = receivedBackBy;
    }

    public String getGivenBackBy()
    {
        return givenBackBy;
    }

    public void setGivenBackBy(String givenBackBy)
    {
        this.givenBackBy = givenBackBy;
    }

    public String getLoanStatus()
    {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus)
    {
        this.loanStatus = loanStatus;
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

    public String getAddedFacilityId()
    {
        return addedFacilityId;
    }

    public void setAddedFacilityId(String addedFacilityId)
    {
        this.addedFacilityId = addedFacilityId;
    }

    public String getAddedAtWsNo()
    {
        return addedAtWsNo;
    }

    public void setAddedAtWsNo(String addedAtWsNo)
    {
        this.addedAtWsNo = addedAtWsNo;
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

    public String getModifiedFacilityId()
    {
        return modifiedFacilityId;
    }

    public void setModifiedFacilityId(String modifiedFacilityId)
    {
        this.modifiedFacilityId = modifiedFacilityId;
    }

    public String getModifiedAtWsNo()
    {
        return modifiedAtWsNo;
    }

    public void setModifiedAtWsNo(String modifiedAtWsNo)
    {
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public Long getReceivedQty()
    {
        return receivedQty;
    }

    public void setReceivedQty(Long receivedQty)
    {
        this.receivedQty = receivedQty;
    }

    private LcLoanDtlsId id;
    private Date loanDate;
    private String sourceType;
    private String sourceCode;
    private String loanedToSourceType;
    private String loanedToSourceCode;
    private String linenItem;
    private Long loanQty;
    private String reasonForLoan;
    private String remarks;
    private String givenBy;
    private String receivedBy;
    private String cancelledBy;
    private Date cancelledDate;
    private String cancelReason;
    private String receivedWriteOff;
    private String receivedBackBy;
    private String givenBackBy;
    private String loanStatus;
    private String addedById;
    private Date addedDate;
    private String addedFacilityId;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedFacilityId;
    private String modifiedAtWsNo;
    private Long receivedQty;
}
