/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eFM;

import java.util.*;

// Referenced classes of package webbeans.fm:
//            FMFilesIssueDetail

public class FMFilesIssueCart implements java.io.Serializable
{
    public FMFilesIssueCart()
    {
        IssueCart = new ArrayList();
    }

    public ArrayList getPresCart()
    {
        return IssueCart;
    }

    public void addIssuestoCart(FMFilesIssueDetail filesissuedetail)
    {
        IssueCart.add(filesissuedetail);
    }

    public void updIssuestoCart(FMFilesIssueDetail filesissuedetail, int i)
    {
        IssueCart.set(i, filesissuedetail);
    }

    public void delIssuesfromCart(int i)
    {
        IssueCart.remove(i);
    }

    public FMFilesIssueDetail getIssuesfromCart(int i)
    {
        FMFilesIssueDetail objIssueDetail = new FMFilesIssueDetail();
        objIssueDetail = (FMFilesIssueDetail)IssueCart.get(i);
        return objIssueDetail;
    }

    public void clearCart()
    {
        IssueCart.clear();
    }

    public boolean CurrFacilityFileNoExist(String str1, String str2, String str3)
    {
       // Object obj = null;
        for(int i = 0; i < IssueCart.size(); i++)
        {
            FMFilesIssueDetail filesissuedetail = (FMFilesIssueDetail)IssueCart.get(i);
	        String s1 = filesissuedetail.getCurr_Facility_Id();
			String s2 = filesissuedetail.getFile_No();
			String s3 = filesissuedetail.getVolume_No();
            if(s1.equals(str1) && s2.equals(str2) && s3.equals(str3))
                return true;
        }
        return false;
    }

    public boolean FacilityFileNoExist(String str1, String str2, String str3)
    {
       // Object obj = null;
        for(int i = 0; i < IssueCart.size(); i++)
        {
            FMFilesIssueDetail filesissuedetail = (FMFilesIssueDetail)IssueCart.get(i);
	        String s1 = filesissuedetail.getReq_Facility_Id();
			String s2 = filesissuedetail.getFile_No();
			String s3 = filesissuedetail.getPatient_Id();
            if(s1.equals(str1) && s2.equals(str2) && s3.equals(str3))
                return true;
        }
        return false;
    }

    public boolean FileNoExist(String str1, String str2, String str3)
    {
      //  Object obj = null;
        for(int i = 0; i < IssueCart.size(); i++)
        {
            FMFilesIssueDetail filesissuedetail = (FMFilesIssueDetail)IssueCart.get(i);
	        String s1 = filesissuedetail.getReq_No();
			String s2 = filesissuedetail.getFile_No();
			String s3 = filesissuedetail.getVolume_No();
            if(s1.equals(str1) && s2.equals(str2) && s3.equals(str3))
                return true;
        }
        return false;
    }

    public boolean SameFileNoExist(String str1)
    {
        //Object obj = null;
        for(int i = 0; i < IssueCart.size(); i++)
        {
            FMFilesIssueDetail filesissuedetail = (FMFilesIssueDetail)IssueCart.get(i);
			String s1 = filesissuedetail.getFile_No();
            if(s1.equals(str1) )
                return true;
        }
        return false;
    }

    public boolean ReqNoExist(String s)
    {
      //  Object obj = null;
       // String s1 = "";
        for(int i = 0; i < IssueCart.size(); i++)
        {
            FMFilesIssueDetail filesissuedetail = (FMFilesIssueDetail)IssueCart.get(i);
            String s2 = filesissuedetail.getReq_No();
            if(s2.equals(s))
                return true;
        }
        return false;
    }

    ArrayList IssueCart;
}
