// Decompiled by DJ v3.0.0.63 Copyright 2002 Atanas Neshkov  Date: 8/6/2005 10:05:51 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RotateFilter.java
//This File is saved on 18/10/2005.

import java.awt.image.*;

public class RotateFilter extends ImageFilter
{

    public RotateFilter()
    {
    }

    public void setHints(int i)
    {
        super.consumer.setHints(i & -7);
    }

    public void setDimensions(int i, int j)
    {
        super.consumer.setDimensions(j, i);
    }

    public void setPixels(int i, int j, int k, int l, ColorModel colormodel, byte abyte0[], int i1, 
            int j1)
    {
        int ai[] = new int[abyte0.length];
        for(int k1 = 0; k1 < l; k1++)
        {
            for(int l1 = 0; l1 < k; l1++)
                ai[l1 * l + k1] = abyte0[((k1 + 1) * j1 - l1 - 1) + i1];

        }

        super.consumer.setPixels(j, i, l, k, colormodel, ai, 0, l);
    }

    public void setPixels(int i, int j, int k, int l, ColorModel colormodel, int ai[], int i1, 
            int j1)
    {
        int ai1[] = new int[ai.length];
        for(int k1 = 0; k1 < l; k1++)
        {
            for(int l1 = 0; l1 < k; l1++)
                ai1[l1 * l + k1] = ai[((k1 + 1) * j1 - l1 - 1) + i1];

        }

        super.consumer.setPixels(j, i, l, k, colormodel, ai1, 0, l);
    }
}