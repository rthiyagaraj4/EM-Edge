/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;

import eCommon.Common.*;
//import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eST.Common.StAdapter;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;

public class StMultipleInsertMasterBean extends StAdapter
    implements Serializable
{
	//String language_id;
    public StMultipleInsertMasterBean()
    {
        RECORD_SIZE = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
        code = new String[RECORD_SIZE];
        long_desc = new String[RECORD_SIZE];
        short_desc = new String[RECORD_SIZE];
        eff_status = new String[RECORD_SIZE];
    }
	
	/*public void setLanguageId(String language_id)
	{
		this.language_id = language_id;
	}

	public String getLanguageId() 
	{
		return this.language_id;
	}*/
    public void setCode(int i, String s)
    {
        code[i] = s == null ? null : s.toUpperCase();
    }

    public void setLong_desc(int i, String s)
    {
        long_desc[i] = s;
    }

    public void setShort_desc(int i, String s)
    {
        short_desc[i] = s;
    }

    public void setEff_status(int i, String s)
    {
        eff_status[i] = s;
    }

    public String getCode(int i)
    {
        return code[i];
    }

    public String getLong_desc(int i)
    {
        return long_desc[i];
    }

    public String getShort_desc(int i)
    {
        return short_desc[i];
    }

    public String getEff_status(int i)
    {
        return eff_status[i];
    }

    public void clear()
    {
        super.clear();
        for(int i = 0; i < RECORD_SIZE; i++)
        {
            code[i] = "";
            long_desc[i] = "";
            short_desc[i] = "";
            eff_status[i] = "D";
        }

    }

    public void setAll(Hashtable hashtable)
    {
        for(int i = 0; i < RECORD_SIZE; i++)
        {
            String s = (String)hashtable.get("code_" + i);
            String s1 = (String)hashtable.get("long_desc_" + i);
            String s2 = (String)hashtable.get("short_desc_" + i);
            String s3 = (String)hashtable.get("eff_status_" + i);
            if(s == null || s.equals(""))
            {
                setCode(i, null);
                setLong_desc(i, null);
                setShort_desc(i, null);
                setEff_status(i, null);
            } else
            {
                setCode(i, s);
                setLong_desc(i, s1);
                setShort_desc(i, s2);
                if(s3 == null || s3.trim().equals(""))
                    setEff_status(i, "D");
                else
                    setEff_status(i, s3);
            }
        }

    }

    public HashMap insert()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        HashMap hashmap2 = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        hashmap.put("result", new Boolean(false));
        for(int i = 0; i < RECORD_SIZE; i++)
            if(getCode(i) != null && !getCode(i).equals(""))
            {
                ArrayList arraylist2 = new ArrayList();
                arraylist2.add(getCode(i));
                arraylist2.add(getLong_desc(i));
                arraylist2.add(getShort_desc(i));
                arraylist2.add(getEff_status(i));
                arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
                arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
                arraylist.add(arraylist2);
                ArrayList arraylist3 = new ArrayList();
                arraylist3.add(getCode(i));
                arraylist1.add(arraylist3);
            }

        hashmap2.put("InsertSQL", InsertSQL);
        hashmap2.put("SelectSQL", SelectSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("WhereData", arraylist1);
        hashmap1.put("InsertData", arraylist);

        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {
          /*  InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
            SingleTableHandlerHome singletablehandlerhome = (SingleTableHandlerHome)PortableRemoteObject.narrow(obj1, eCommon.SingleTableHandler.SingleTableHandlerHome.class);
            singletablehandlerremote = singletablehandlerhome.create();
            hashmap = singletablehandlerremote.singleBatchHandler(hashmap1, hashmap2);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),eCommon.SingleTableHandler.SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap1;
			argArray[1] = hashmap2;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap1.getClass(); 
			paramArray[1] = hashmap2.getClass();

			 hashmap = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            if(((Boolean)hashmap.get("result")).booleanValue())
                hashmap.put("message", getMessage((String)hashmap.get("msgid")));
            else
            if(((String)hashmap.get("msgid")).equals("CODE_ALREADY_EXISTS"))
            {
                String s = getMessage((String)hashmap.get("msgid"), false);
                s = s.substring(0, s.indexOf("<br>"));
                hashmap.put("message", s);
                hashmap.put("invalidCode", delimitedString((ArrayList)hashmap.get("invalidCode")));
            } else
            {
                hashmap.put("message", hashmap.get("msgid"));
            }
        }
        catch(Exception exception)
        {
            hashmap.put("message", exception.toString());
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if(singletablehandlerremote != null)
                    singletablehandlerremote.remove();
            }
            catch(Exception exception2)
            {
                hashmap.put("message", exception2.toString());
            }
        }
        return hashmap;
    }

    public HashMap modify()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        ArrayList arraylist = new ArrayList();
        HashMap hashmap2 = new HashMap();
        hashmap.put("result", new Boolean(false));
        arraylist.add(long_desc[0]);
        arraylist.add(short_desc[0]);
        arraylist.add(eff_status[0]);
        arraylist.add(super.login_by_id);
        arraylist.add(super.login_at_ws_no);
        arraylist.add(super.login_facility_id);
        arraylist.add(code[0]);
		
        hashmap2.put("ModifySQL", UpdateSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("ModifyData", arraylist);

        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {
          /*  InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
            SingleTableHandlerHome singletablehandlerhome = (SingleTableHandlerHome)PortableRemoteObject.narrow(obj1, eCommon.SingleTableHandler.SingleTableHandlerHome.class);
            singletablehandlerremote = singletablehandlerhome.create();
            hashmap = singletablehandlerremote.modify(hashmap1, hashmap2);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),eCommon.SingleTableHandler.SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap1;
			argArray[1] = hashmap2;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap1.getClass(); ;
			paramArray[1] = hashmap2.getClass();

			hashmap = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if(((Boolean)hashmap.get("result")).booleanValue())
                hashmap.put("message", getMessage((String)hashmap.get("msgid")));
            else
                hashmap.put("message", hashmap.get("msgid"));
        }
        catch(Exception exception)
        {
            hashmap.put("message", exception.getMessage());
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if(singletablehandlerremote != null)
                    singletablehandlerremote.remove();
            }
            catch(Exception exception2)
            {
                hashmap.put("message", exception2.getMessage());
            }
        }
        return hashmap;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < RECORD_SIZE; i++)
        {
            stringbuffer.append("Record :" + (i + 1) + " :: ");
            stringbuffer.append(code[i] + "=\t");
            stringbuffer.append(long_desc[i] + "=");
            stringbuffer.append(short_desc[i] + "=");
            stringbuffer.append(eff_status[i] + "=");
            stringbuffer.append("<BR>");
        }

        return stringbuffer.toString();
    }

    public void loadData()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(ModifySQL);
            preparedstatement.setString(1, code[0]);
            preparedstatement.setString(2, getLanguageId());
          //  preparedstatement.setString(1, code[0]);


            resultset = preparedstatement.executeQuery();



            if(resultset != null && resultset.next())
            {

				
                setCode(0, resultset.getString(codeFieldName));
                setLong_desc(0, resultset.getString("long_desc"));
                setShort_desc(0, resultset.getString("short_desc"));
                setEff_status(0, resultset.getString("eff_status"));

				
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
    }

    public HashMap validate()
        throws Exception
    {
        HashMap hashmap = new HashMap();
        hashmap.put("result", new Boolean(true));
        hashmap.put("message", "");
        return hashmap;
    }

    protected int RECORD_SIZE;
    private String code[];
    private String long_desc[];
    private String short_desc[];
    private String eff_status[];
    protected String InsertSQL;
    protected String ModifySQL;
    protected String SelectSQL;
    protected String UpdateSQL;
    protected String codeFieldName;
}
