/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

public class IndexRecBean implements java.io.Serializable
{
    java.util.ArrayList recordSet   =   null;

    public IndexRecBean()
    {
        recordSet   =   new java.util.ArrayList();
    }

	public IndexRecBean(IndexRecBean recordSet)
	{
		this.recordSet	=	new java.util.ArrayList(recordSet.recordSet);
	}

    public java.util.ArrayList getRecordSetHandle()
    {
        return new java.util.ArrayList(recordSet);
    }

	public java.util.ArrayList getAllRecords(){
		return this.recordSet;
	}

    public int getSize()
    {
        int size = 0;
        if(recordSet!=null)
            size    =   recordSet.size();
        return size;
    }

    public boolean clearAll() throws Exception
    {
        recordSet.clear();
        return true;
    }

    public boolean putObject (Object recordObject) throws Exception
    {
        try
        {
            recordSet.add(recordObject);
        }
        catch(Exception e)
        {
            throw new Exception("Exception@putObject: "+e);
        }
        return true;
    }

    public boolean setObject (int index, Object recordObject) throws Exception
    {
        try
        {
			if( index < getSize() )
	            recordSet.set(index, recordObject);
        }
        catch(Exception e)
        {
            throw new Exception("Exception@setObject: "+e);
        }
        return true;
    }

    public java.lang.Object getObject (int row) throws Exception
    {
        java.lang.Object recordObject   =   null;
        if(recordSet!=null)
		{
			if( row < getSize() )
	            recordObject = (java.lang.Object) recordSet.get(row);
		}
        return recordObject;
    }

    public boolean removeObject (int row) throws Exception
    {
		if( row < getSize() )
		{
			recordSet.remove(row);
			return true;
		}
		else
		{
			return false;
		}
    }

    public boolean containsObject (java.lang.Object searchObject) throws Exception
    {
        boolean containsRecord  =   false;
        if(recordSet!=null)
            containsRecord =  recordSet.contains(searchObject);
        return containsRecord;
    }

    public int indexOfObject (java.lang.Object searchObject) throws Exception
    {
        int recordIndex     =   -1;
        if(recordSet!=null)
            recordIndex =  recordSet.indexOf(searchObject);
        return recordIndex;
    }
}
