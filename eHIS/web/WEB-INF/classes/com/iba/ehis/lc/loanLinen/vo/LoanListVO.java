/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author :Yadav Kar
// Source File Name:   LoanListVO.java

package com.iba.ehis.lc.loanLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

import  com.iba.ehis.lc.loanLinen.vo.ViewResultVO;


public class LoanListVO extends LcVO
{

    public LoanListVO()
    {
        loanLinenList = new AutoGenerationList(ViewResultVO.class);
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

    public String getGivenBy()
    {
        return givenBy;
    }

    public void setGivenBy(String givenBy)
    {
        this.givenBy = givenBy;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public IBADateTime getLoanDate()
    {
        return loanDate;
    }

    public void setLoanDate(IBADateTime loanDate)
    {
        this.loanDate = loanDate;
    }

    public Long getLoanedQty()
    {
        return loanedQty;
    }

    public void setLoanedQty(Long loanedQty)
    {
        this.loanedQty = loanedQty;
    }

    public String getLoanedToSourceCode()
    {
        return loanedToSourceCode;
    }

    public void setLoanedToSourceCode(String loanedToSourceCode)
    {
        this.loanedToSourceCode = loanedToSourceCode;
    }

    public String getLoanedToSourceType()
    {
        return loanedToSourceType;
    }

    public void setLoanedToSourceType(String loanedToSourceType)
    {
        this.loanedToSourceType = loanedToSourceType;
    }

    public String getLoanRefNum()
    {
        return loanRefNum;
    }

    public void setLoanRefNum(String loanRefNum)
    {
        this.loanRefNum = loanRefNum;
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

    public String getReceivedBy()
    {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
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

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc;
    }

    public String getLoanStatus()
    {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus)
    {
        this.loanStatus = loanStatus;
    }

    public Long getReceivedQty()
    {
        return receivedQty;
    }

    public void setReceivedQty(Long receivedQty)
    {
        this.receivedQty = receivedQty;
    }

    public AutoGenerationList getLoanLinenList()
    {
        return loanLinenList;
    }

    public void setLoanLinenList(AutoGenerationList loanLinenList)
    {
        this.loanLinenList = loanLinenList;
    }

    private String loanRefNum;
    private IBADateTime loanDate;
    private String sourceType;
    private String sourceCode;
    private String givenBy;
    private String loanedToSourceType;
    private String loanedToSourceCode;
    private String receivedBy;
    private String remarks;
    private String loanStatus;
    private String linenItem;
    private String shortDesc;
    private String cancelledBy;
    private IBADateTime cancelledDate;
    private String reasonCode;
    private String reasonDesc;
    private Long loanedQty;
    private Long receivedQty;
    private AutoGenerationList loanLinenList;
}
