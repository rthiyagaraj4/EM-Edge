/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Source File Name:   LcMendingReceiptDtlId.java

package com.iba.ehis.dobj;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.iba.ehis.dobj:
//            LcMendingReceiptHdr

public class LcMendingReceiptDtlId
    implements Serializable
{

    public LcMendingReceiptDtlId()
    {
    }

    public LcMendingReceiptDtlId(LcMendingReceiptHdr lcMendingReceiptHdr, String requestNum, String linenItem, Long receivedQty, String addedById, Date addedDate, String addedFacilityId, 
            String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.lcMendingReceiptHdr = lcMendingReceiptHdr;
        this.requestNum = requestNum;
        this.linenItem = linenItem;
        this.receivedQty = receivedQty;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcMendingReceiptDtlId(LcMendingReceiptHdr lcMendingReceiptHdr, String requestNum, String linenItem, Long receivedQty, String remarks, String addedById, Date addedDate, 
            String addedFacilityId, String addedAtWsNo, String modifiedById, Date modifiedDate, String modifiedFacilityId, String modifiedAtWsNo)
    {
        this.lcMendingReceiptHdr = lcMendingReceiptHdr;
        this.requestNum = requestNum;
        this.linenItem = linenItem;
        this.receivedQty = receivedQty;
        this.remarks = remarks;
        this.addedById = addedById;
        this.addedDate = addedDate;
        this.addedFacilityId = addedFacilityId;
        this.addedAtWsNo = addedAtWsNo;
        this.modifiedById = modifiedById;
        this.modifiedDate = modifiedDate;
        this.modifiedFacilityId = modifiedFacilityId;
        this.modifiedAtWsNo = modifiedAtWsNo;
    }

    public LcMendingReceiptHdr getLcMendingReceiptHdr()
    {
        return lcMendingReceiptHdr;
    }

    public void setLcMendingReceiptHdr(LcMendingReceiptHdr lcMendingReceiptHdr)
    {
        this.lcMendingReceiptHdr = lcMendingReceiptHdr;
    }

    public String getRequestNum()
    {
        return requestNum;
    }

    public void setRequestNum(String requestNum)
    {
        this.requestNum = requestNum;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public Long getReceivedQty()
    {
        return receivedQty;
    }

    public void setReceivedQty(Long receivedQty)
    {
        this.receivedQty = receivedQty;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
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

    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof LcMendingReceiptDtlId))
            return false;
        LcMendingReceiptDtlId castOther = (LcMendingReceiptDtlId)other;
        return (getLcMendingReceiptHdr() == castOther.getLcMendingReceiptHdr() || getLcMendingReceiptHdr() != null && castOther.getLcMendingReceiptHdr() != null && getLcMendingReceiptHdr().equals(castOther.getLcMendingReceiptHdr())) && (getRequestNum() == castOther.getRequestNum() || getRequestNum() != null && castOther.getRequestNum() != null && getRequestNum().equals(castOther.getRequestNum())) && (getLinenItem() == castOther.getLinenItem() || getLinenItem() != null && castOther.getLinenItem() != null && getLinenItem().equals(castOther.getLinenItem())) && (getReceivedQty() == castOther.getReceivedQty() || getReceivedQty() != null && castOther.getReceivedQty() != null && getReceivedQty().equals(castOther.getReceivedQty())) && (getRemarks() == castOther.getRemarks() || getRemarks() != null && castOther.getRemarks() != null && getRemarks().equals(castOther.getRemarks())) && (getAddedById() == castOther.getAddedById() || getAddedById() != null && castOther.getAddedById() != null && getAddedById().equals(castOther.getAddedById())) && (getAddedDate() == castOther.getAddedDate() || getAddedDate() != null && castOther.getAddedDate() != null && getAddedDate().equals(castOther.getAddedDate())) && (getAddedFacilityId() == castOther.getAddedFacilityId() || getAddedFacilityId() != null && castOther.getAddedFacilityId() != null && getAddedFacilityId().equals(castOther.getAddedFacilityId())) && (getAddedAtWsNo() == castOther.getAddedAtWsNo() || getAddedAtWsNo() != null && castOther.getAddedAtWsNo() != null && getAddedAtWsNo().equals(castOther.getAddedAtWsNo())) && (getModifiedById() == castOther.getModifiedById() || getModifiedById() != null && castOther.getModifiedById() != null && getModifiedById().equals(castOther.getModifiedById())) && (getModifiedDate() == castOther.getModifiedDate() || getModifiedDate() != null && castOther.getModifiedDate() != null && getModifiedDate().equals(castOther.getModifiedDate())) && (getModifiedFacilityId() == castOther.getModifiedFacilityId() || getModifiedFacilityId() != null && castOther.getModifiedFacilityId() != null && getModifiedFacilityId().equals(castOther.getModifiedFacilityId())) && (getModifiedAtWsNo() == castOther.getModifiedAtWsNo() || getModifiedAtWsNo() != null && castOther.getModifiedAtWsNo() != null && getModifiedAtWsNo().equals(castOther.getModifiedAtWsNo()));
    }

    public int hashCode()
    {
        int result = 17;
        result = 37 * result + (getLcMendingReceiptHdr() != null ? getLcMendingReceiptHdr().hashCode() : 0);
        result = 37 * result + (getRequestNum() != null ? getRequestNum().hashCode() : 0);
        result = 37 * result + (getLinenItem() != null ? getLinenItem().hashCode() : 0);
        result = 37 * result + (getReceivedQty() != null ? getReceivedQty().hashCode() : 0);
        result = 37 * result + (getRemarks() != null ? getRemarks().hashCode() : 0);
        result = 37 * result + (getAddedById() != null ? getAddedById().hashCode() : 0);
        result = 37 * result + (getAddedDate() != null ? getAddedDate().hashCode() : 0);
        result = 37 * result + (getAddedFacilityId() != null ? getAddedFacilityId().hashCode() : 0);
        result = 37 * result + (getAddedAtWsNo() != null ? getAddedAtWsNo().hashCode() : 0);
        result = 37 * result + (getModifiedById() != null ? getModifiedById().hashCode() : 0);
        result = 37 * result + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        result = 37 * result + (getModifiedFacilityId() != null ? getModifiedFacilityId().hashCode() : 0);
        result = 37 * result + (getModifiedAtWsNo() != null ? getModifiedAtWsNo().hashCode() : 0);
        return result;
    }

    private LcMendingReceiptHdr lcMendingReceiptHdr;
    private String requestNum;
    private String linenItem;
    private Long receivedQty;
    private String remarks;
    private String addedById;
    private Date addedDate;
    private String addedFacilityId;
    private String addedAtWsNo;
    private String modifiedById;
    private Date modifiedDate;
    private String modifiedFacilityId;
    private String modifiedAtWsNo;
}
