/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// yadavK
// Source File Name:   PlaceLinenRequestVO.java
package com.iba.ehis.lc.requestForLinen.vo;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;
public class PlaceLinenRequestVO extends LcVO
{

    public PlaceLinenRequestVO()
    {
        linenRequest = new AutoGenerationList(LinenRequestList.class);
    }

    public String getRaisedBy()
    {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy)
    {
        this.raisedBy = raisedBy;
    }

    public AutoGenerationList getLinenRequest()
    {
        return linenRequest;
    }

    public void setLinenRequest(AutoGenerationList linenRequest)
    {
        this.linenRequest = linenRequest;
    }

    public IBADateTime getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(IBADateTime requestDate)
    {
        this.requestDate = requestDate;
    }

    public String getRequestNum()
    {
        return requestNum;
    }

    public void setRequestNum(String requestNum)
    {
        this.requestNum = requestNum;
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

    public String getRequestStatus()
    {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus)
    {
        this.requestStatus = requestStatus;
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

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    private String requestNum;
    private IBADateTime requestDate;
    private String sourceType;
    private String sourceCode;
    private String raisedBy;
    private String requestStatus;
    private String linenItem;
    private String cancelledBy;
    private IBADateTime cancelledDate;
    private String reasonCode;
    private String reasonDesc;
    private AutoGenerationList linenRequest;
}
