/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCommon;

import java.io.Serializable;
import java.util.ArrayList;

public class RecordSet
    implements Serializable
{

    public RecordSet()
    {
        recordSet = null;
        recordSet = new ArrayList();
    }

    public RecordSet(RecordSet recordset)
    {
        recordSet = null;
        recordSet = new ArrayList(recordset.recordSet);
    }

    public ArrayList getRecordSetHandle()
    {
        return new ArrayList(recordSet);
    }

    public int getSize()
    {
        int i = 0;
        if(recordSet != null)
            i = recordSet.size();
        return i;
    }

    public boolean clearAll()
        throws Exception
    {
        recordSet.clear();
        return true;
    }

    public boolean putObject(Object obj)
        throws Exception
    {
        try
        {
            recordSet.add(obj);
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
                recordSet.set(i, obj);
        }
        catch(Exception exception)
        {
            throw new Exception("Exception@setObject: " + exception);
        }
        return true;
    }

	 public boolean addObject(int i, Object obj)
        throws Exception
    {
        try
        {
            if(i < getSize())
                recordSet.add(i, obj);
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
        if(recordSet != null && i < getSize())
            obj = recordSet.get(i);
        return obj;
    }

    public boolean removeObject(int i)
        throws Exception
    {
        if(i < getSize())
        {
            recordSet.remove(i);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean containsObject(Object obj)
        throws Exception
    {
        boolean flag = false;
        if(recordSet != null)
            flag = recordSet.contains(obj);
        return flag;
    }

    public int indexOfObject(Object obj)
        throws Exception
    {
        int i = -1;
        if(recordSet != null)
            i = recordSet.indexOf(obj);
        return i;
    }

    ArrayList recordSet;
}
