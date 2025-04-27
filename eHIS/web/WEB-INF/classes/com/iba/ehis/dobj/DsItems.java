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
//            DsItemsId

public class DsItems
    implements Serializable
{

    public DsItems()
    {
    }

    public DsItems(DsItemsId id)
    {
        this.id = id;
    }

    public DsItemsId getId()
    {
        return id;
    }

    public void setId(DsItemsId id)
    {
        this.id = id;
    }

    private DsItemsId id;
}
