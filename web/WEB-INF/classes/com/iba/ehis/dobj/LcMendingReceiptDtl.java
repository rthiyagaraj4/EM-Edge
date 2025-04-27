/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Source File Name:   LcMendingReceiptDtl.java

package com.iba.ehis.dobj;

import java.io.Serializable;

// Referenced classes of package com.iba.ehis.dobj:
//            LcMendingReceiptDtlId, LcMendingReceiptHdr

public class LcMendingReceiptDtl
    implements Serializable
{

    public LcMendingReceiptDtl()
    {
    }

    public LcMendingReceiptDtl(LcMendingReceiptDtlId id, LcMendingReceiptHdr lcMendingReceiptHdr)
    {
        this.id = id;
        this.lcMendingReceiptHdr = lcMendingReceiptHdr;
    }

    public LcMendingReceiptDtlId getId()
    {
        return id;
    }

    public void setId(LcMendingReceiptDtlId id)
    {
        this.id = id;
    }

    public LcMendingReceiptHdr getLcMendingReceiptHdr()
    {
        return lcMendingReceiptHdr;
    }

    public void setLcMendingReceiptHdr(LcMendingReceiptHdr lcMendingReceiptHdr)
    {
        this.lcMendingReceiptHdr = lcMendingReceiptHdr;
    }

    private LcMendingReceiptDtlId id;
    private LcMendingReceiptHdr lcMendingReceiptHdr;
}
