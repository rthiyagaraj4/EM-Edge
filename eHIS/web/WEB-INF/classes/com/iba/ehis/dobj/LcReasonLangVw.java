/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 8/25/2009 5:31:46 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LcReasonLangVw.java

package com.iba.ehis.dobj;

import java.io.Serializable;

// Referenced classes of package com.iba.ehis.dobj:
//            LcReasonLangVwId

public class LcReasonLangVw
    implements Serializable
{

    public LcReasonLangVw()
    {
    }

    public LcReasonLangVw(LcReasonLangVwId id)
    {
        this.id = id;
    }

    public LcReasonLangVwId getId()
    {
        return id;
    }

    public void setId(LcReasonLangVwId id)
    {
        this.id = id;
    }

    private LcReasonLangVwId id;
}
