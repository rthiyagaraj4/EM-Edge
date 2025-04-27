/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;

//import java.io.Serializable;
import java.util.*;

public class RecordDiagnosis implements java.io.Serializable
{
	Hashtable recordset = new Hashtable();
	
	/*public RecordDiagnosis()
	{
		Hashtable recordset = new Hashtable();
	}*/
 
	 public int getSize()
    {
        int i = 0;
        if(recordset != null)
            i = recordset.size();
        return i;
    }

	public void addRecord(String key, String code)throws Exception
	{
		try
		{
			recordset.put(key,code);
		}
		catch(Exception ex)
		{
			 throw new Exception("Exception@addRecord: " + ex);
		}
	}
	
	public Object getRecord(String i) throws Exception
	{
		try
		{
			Object obj = null;
			if(recordset != null ){
            obj = recordset.get(i);
			}
			return obj;
		}
		catch(Exception ex)
		{
			throw new Exception("Exception@getRecord: " + ex);
		}
		
	}

	public boolean removeRecord(String key)
        throws Exception
	 {
       	if(recordset !=null)
        {
            recordset.remove(key);
            return true;
        } else
        {
            return false;
        }
    }
	
	 public boolean containsRecord(String key)
        throws Exception
    {
        boolean flag = false;
        if(recordset != null)
            flag = recordset.contains(key);
        return flag;
    }
	
	public ArrayList getAllRecord() throws Exception
	{
		ArrayList getArry = new ArrayList();
		try
		{

			//ArrayList getArry = new ArrayList();
			Enumeration enum1 = recordset.keys();

			String record = "",code="",desc="" ,icd_code="",codedesc="";
			String enumval="",keycode="";
			//int i=0;
			while(enum1.hasMoreElements())
			{
				enumval = (String)enum1.nextElement();
				record=(String)getRecord(enumval);
			
				StringTokenizer st = new StringTokenizer(record,"~");
				while(st.hasMoreTokens()){
                    code = st.nextToken();
					desc = st.nextToken();
					icd_code = st.nextToken();
					codedesc = st.nextToken();
				}	
				keycode=enumval+"~"+code+"~"+desc+"~"+icd_code+"~"+codedesc;
				getArry.add(keycode);
				
			}
			//return getArry;
		}
		catch(Exception ex)
		{
			throw new Exception("Exception@getAllRecord: " + ex);
		}
		return getArry;
	}

	public boolean clearAllRecord()
        throws Exception
    {
        recordset.clear();
        return true;
    }


}
