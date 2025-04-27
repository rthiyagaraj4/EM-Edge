/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//yadavk
// Source File Name:   QueryStockStatusVO.java

package com.iba.ehis.lc.queryStockStatus.vo;

import com.iba.ehis.lc.core.vo.LcVO;

public class QueryStockStatusVO extends LcVO
{

    public QueryStockStatusVO()
    {
    }

    public Long getInUseQty()
    {
        return inUseQty;
    }

    public void setInUseQty(Long inUseQty)
    {
        this.inUseQty = inUseQty;
    }

    public String getLinenItem()
    {
        return linenItem;
    }

    public void setLinenItem(String linenItem)
    {
        this.linenItem = linenItem;
    }

    public Long getLoanedQty()
    {
        return loanedQty;
    }

    public void setLoanedQty(Long loanedQty)
    {
        this.loanedQty = loanedQty;
    }

    public Long getSoiledQty()
    {
        return soiledQty;
    }

    public void setSoiledQty(Long soiledQty)
    {
        this.soiledQty = soiledQty;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

//    changes for SCF 32276 - AMRI-SCF-0098
    
    public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
//	SCF 32276 changes end
	private String linenItem;
    private Long inUseQty;
    private Long soiledQty;
    private Long loanedQty;
    private String total;
    private String sourceCode;
//  changes for SCF 32276 - AMRI-SCF-0098    
    private String sourceType;
//	SCF 32276 changes end    
}
