// Decompiled by DJ v3.0.0.63 Copyright 2002 Atanas Neshkov  Date: 8/6/2005 9:39:48 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   record_data.java
//This File is saved on 18/10/2005.

	 
public class record_data
{

    public record_data()
    {
        iN = 1;
        sIt = "";
        sUrl = "";
        sFont = "Arial";
        sBg = "";
        sU = "";
        iLg = 1;
        sDec = "";
    }

    public boolean get(record_data rd1, String s, char c, int i)
    {
        //boolean flag = false;
        int l = 0;
        int i1 = 0;
        Double double1 = new Double(0.0D);
        iN = i;
        iD = new double[iN];
        for(int j = 0; j < iN;)
            iD[j++] = iNan;

        i = 0;
        if(s == null)
            return false;
        do
        {
            int k = s.indexOf(c, i);
            String s1;
            if(k > 0)
                s1 = new String(s.substring(i, k).trim());
            else
                s1 = new String(s.substring(i).trim());
            boolean flag1;
            try
            {
                double1 = Double.valueOf(s1);
                flag1 = i1 > 0;
            }
            catch(NumberFormatException numberformatexception)
            {
                flag1 = false;
            }
            if(s1.length() == 0 && i1 > 0)
            {
                flag1 = true;
                double1 = new Double(iNan);
            }
            if(k > -1 || s1.length() > 0)
                if(flag1)
                {
                    if(l < iN)
                        rd1.iD[l++] = double1.doubleValue();
                } else
                if(s1.startsWith("frm="))
                    rd1.sDec = s1.substring(4);
                else
                if(s1.startsWith("ilg="))
                    rd1.iLg = Integer.parseInt(s1.substring(4));
                else
                if(s1.startsWith("unit="))
                {
                    rd1.sU = s1.substring(5);
                } else
                {
                    if(i1 == 0)
                        rd1.sIt = new String(s1);
                    if(i1 == 1)
                        rd1.sUrl = new String(s1);
                    if(i1 == 2)
                        rd1.sFont = new String(s1);
                    if(i1 == 3)
                        rd1.sBg = new String(s1);
                    i1++;
                }
            if(k == -1)
                return l + i1 > 0;
            i = k + 1;
        } while(true);
    }

    static double iNan = -0.00012540000000000001D;
    public int iN;
    public String sIt;
    public String sUrl;
    public String sFont;
    public String sBg;
    public String sU;
    public int iLg;
    public String sDec;
    public double iD[];

}