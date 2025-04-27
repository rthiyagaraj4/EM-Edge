/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// yadavK
// Source File Name:   RequestsListVO.java
package com.iba.ehis.lc.requestForLinen.vo;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;
public class RequestsListVO extends LcVO
{

    public RequestsListVO()
    {
        linenRequest = new AutoGenerationList(LinenRequestList.class);
    }

    public IBADateTime getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(IBADateTime requestDate)
    {
        this.requestDate = requestDate;
    }

    public String getToDate()
    {
        return toDate;
    }

    public void setToDate(String toDate)
    {
        this.toDate = toDate;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public String getRaisedBy()
    {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy)
    {
        this.raisedBy = raisedBy;
    }

    public String getRequestStatus()
    {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus)
    {
        this.requestStatus = requestStatus;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public String getSourceType()
    {
        return sourceType;
    }

    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    public AutoGenerationList getLinenRequest()
    {
        return linenRequest;
    }

    public void setLinenRequest(AutoGenerationList linenRequest)
    {
        this.linenRequest = linenRequest;
    }

    public String getRequestNo()
    {
        return requestNo;
    }

    public void setRequestNo(String requestNo)
    {
        this.requestNo = requestNo;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public Long getIssuedQty()
    {
        return issuedQty;
    }

    public void setIssuedQty(Long issuedQty)
    {
        this.issuedQty = issuedQty;
    }

    public Long getRequestedQty()
    {
        return requestedQty;
    }

    public void setRequestedQty(Long requestedQty)
    {
        this.requestedQty = requestedQty;
    }

    public String getCancelledBy()
    {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy)
    {
        this.cancelledBy = cancelledBy;
    }

    public IBADateTime getCancelledDate()
    {
        return cancelledDate;
    }

    public void setCancelledDate(IBADateTime cancelledDate)
    {
        this.cancelledDate = cancelledDate;
    }

    public String getReasonCode()
    {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
    }

    public String getReasonDesc()
    {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc)
    {
        this.reasonDesc = reasonDesc;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc;
    }

    public String getSourceDesc()
    {
        return sourceDesc;
    }

    public void setSourceDesc(String sourceDesc)
    {
        this.sourceDesc = sourceDesc;
    }

    private String sourceType;
    private String sourceCode;
    private String sourceDesc;
    private String requestNo;
    private Long requestedQty;
    private Long issuedQty;
    private String remarks;
    private IBADateTime requestDate;
    private String toDate;
    private String raisedBy;
    private String requestStatus;
    private String linenItem;
    private String shortDesc;
    private String cancelledBy;
    private IBADateTime cancelledDate;
    private String reasonCode;
    private String reasonDesc;
    private AutoGenerationList linenRequest;
}
