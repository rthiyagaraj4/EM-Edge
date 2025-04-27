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

// Referenced classes of package com.iba.ehis.dobj:
//            OrOrderCatalog, OrOrderType

public class OrOrderCatalogByTypeId
    implements Serializable
{

    public OrOrderCatalogByTypeId()
    {
    }

    public OrOrderCatalogByTypeId(OrOrderCatalog orOrderCatalog, OrOrderType orOrderType)
    {
        this.orOrderCatalog = orOrderCatalog;
        this.orOrderType = orOrderType;
    }

    public OrOrderCatalog getOrOrderCatalog()
    {
        return orOrderCatalog;
    }

    public void setOrOrderCatalog(OrOrderCatalog orOrderCatalog)
    {
        this.orOrderCatalog = orOrderCatalog;
    }

    public OrOrderType getOrOrderType()
    {
        return orOrderType;
    }

    public void setOrOrderType(OrOrderType orOrderType)
    {
        this.orOrderType = orOrderType;
    }

    private OrOrderCatalog orOrderCatalog;
    private OrOrderType orOrderType;
}
