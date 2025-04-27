/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.io.*;
import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ExtApplParamBean implements Serializable
{
    ArrayList extapp;

    public ExtApplParamBean()
    {
       extapp = null;
       extapp = new ArrayList();
    }

   
    public ArrayList getbeanHandle()
    {
        return new ArrayList(extapp);
    }

    public int getSize()
    {
        int i = 0;
        if(extapp != null)
            i = extapp.size();
        return i;
    }

    public boolean clearAll()
        throws Exception
    {
        extapp.clear();
        return true;
    }

    public boolean putObject(Object obj)
        throws Exception
    {
        try
        {
            extapp.add(obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@putObject: " + exception);
        }
        return true;
    }

    public boolean setObject(int i, Object obj)
        throws Exception
    {
        try
        {
            if(i < getSize())
                extapp.set(i, obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@setObject: " + exception);
        }
        return true;
    }

    
    public Object getObject(int i)
        throws Exception
    {
        Object obj = null;
        if(extapp!= null && i < getSize())
            obj = extapp.get(i);
        return obj;
    }

    public boolean removeObject(int i)
        throws Exception
    {
        if(i < getSize())
        {
            extapp.remove(i);
            return true;
        } else
        {
            return false;
        }
    }

	public boolean removeObject(Object ob,int i )
	{
		if(i < getSize())
        {
		extapp.remove(ob);
		return true;
		}
		else
			return false;
	}

    public boolean containsObject(Object obj)
        throws Exception
    {
        boolean flag = false;
        if(extapp != null)
            flag = extapp.contains(obj);
        return flag;
    }

    public int indexOfObject(Object obj)
        throws Exception
    {
        int i = -1;
        if(extapp!= null)
            i = extapp.indexOf(obj);
        return i;
    }

  }
