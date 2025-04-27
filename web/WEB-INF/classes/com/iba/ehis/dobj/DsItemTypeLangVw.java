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
//            DsItemTypeLangVwId

public class DsItemTypeLangVw
    implements Serializable
{

    public DsItemTypeLangVw()
    {
    }

    public DsItemTypeLangVw(DsItemTypeLangVwId id)
    {
        this.id = id;
    }

    public DsItemTypeLangVwId getId()
    {
        return id;
    }

    public void setId(DsItemTypeLangVwId id)
    {
        this.id = id;
    }

    private DsItemTypeLangVwId id;
}
