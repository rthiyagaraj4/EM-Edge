/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;
//import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
//import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.*;
//import java.util.Hashtable;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
import java.sql.*;


public class PrepareLocationBean extends StMultipleInsertMasterBean
    implements Serializable
{
		private String batch_id[];
	    private String batch_yn[];
		private String batch_series[];
		private String SelectBatchSQL ;
		private String UpdateBatchSQL;
	//	private String language_id;
		public PrepareLocationBean()
		{	
			RECORD_SIZE = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	        batch_id = new String[RECORD_SIZE];
		    batch_yn = new String[RECORD_SIZE];
			batch_series=new String[RECORD_SIZE];
			super.InsertSQL = StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_INSERT");
			super.ModifySQL = StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_SELECT_SINGLE");
			super.UpdateSQL = StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_UPDATE");
			super.SelectSQL = StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_COUNT");
			UpdateBatchSQL=StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_UPDATE_BATCH");
			SelectBatchSQL = StRepository.getStKeyValue("SQL_ST_PREPARE_LOCATION_SELECT_BATCH_ID"); 
			super.codeFieldName = "prepare_location_code";
	}

	 public void setBatch_id(int i, String s)
    {
        batch_id[i] = s;
    }

	public void setBatch_yn(int i, String s)
    {
		
        batch_yn[i] = s;
    }
	
	  public void setBatch_series(int i, String s)
    {
		
        batch_series[i] = s;
    }
	 public String getBatch_series(int i)
    {	
        return batch_series[i] ; 
    }
	
	/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}

	public String getLanguageId() 
	{
		return this.language_id;
	}*/
    public String getBatch_id(int i)
    {	
        return batch_id[i] ; 
    }

    public String getBatch_yn(int i)
    {
        return batch_yn[i] ;
    }

	 public void setAll(Hashtable hashtable)
	{

		super.setAll(hashtable);
		for(int i = 0; i < RECORD_SIZE; i++)
        {
			String s = (String)hashtable.get("code_" + i);
			String batch_id  = (String)hashtable.get("batch_id_" + i);
            String batch_yn = (String)hashtable.get("auto_gen_batch_yn_" + i);
			String batch_series=(String)hashtable.get("batch_series_"+i);
			
            if(s == null || s.equals(""))
            {
                setBatch_id(i, null);
                setBatch_yn(i, null);
				setBatch_series(i,null);

            }else{

                setBatch_id(i, batch_id);
                setBatch_yn(i, batch_yn);
				setBatch_series(i,batch_series);

                if(batch_yn == null || batch_yn.trim().equals(""))
                    setBatch_yn(i, "N");
                else
                    setBatch_yn(i, batch_yn);
            }
        }

    }

public void loadData() throws Exception
{ 
		super.loadData();

        
		

        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;

        try
        {
            connection = getConnection();
			preparedstatement = connection.prepareStatement(SelectBatchSQL);
			preparedstatement.setString(1, getCode(0));
			resultset = preparedstatement.executeQuery();
			if(resultset != null && resultset.next())
            {

				setBatch_yn(0,resultset.getString("auto_gen_batch_yn"));
				setBatch_id(0,resultset.getString("next_batch_id"));
				setBatch_series(0,resultset.getString("batch_id_series"));
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


public HashMap insert()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        HashMap hashmap2 = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        hashmap.put("result", new Boolean(false));
		int i = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
        for(int j = 0; j < i; j++)
            if(getCode(j) != null && !getCode(j).equals(""))
            {
                ArrayList arraylist2 = new ArrayList();
                arraylist2.add(getCode(j));
                arraylist2.add(getLong_desc(j));
                arraylist2.add(getShort_desc(j));
                arraylist2.add(super.login_facility_id);
				arraylist2.add(getEff_status(j));
				arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
                arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
				arraylist2.add(getBatch_yn(j));
				arraylist2.add(getBatch_id(j));
				arraylist2.add(getBatch_series(j));
                arraylist.add(arraylist2);
				ArrayList arraylist3 = new ArrayList();
                arraylist3.add(getCode(j));
                arraylist1.add(arraylist3);
            
			}

        hashmap2.put("InsertSQL", super.InsertSQL);
        hashmap2.put("SelectSQL", super.SelectSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("WhereData", arraylist1);
        hashmap1.put("InsertData", arraylist);
		hashmap1.put("LanguageData",LanguageData);
// pmd 19/02/05
//	Object obj = null;
        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {
          /* InitialContext initialcontext = new InitialContext();
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
			paramArray[0] = hashmap1.getClass(); ;
			paramArray[1] = hashmap2.getClass();

			 hashmap = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if(((Boolean)hashmap.get("result")).booleanValue())
                hashmap.put("message", getSTMessage(getLanguageId(),(String) hashmap.get("msgid" ),"ST") ) ;
            else
            if(((String)hashmap.get("msgid")).equals("CODE_ALREADY_EXISTS"))
                hashmap.put("message", getSTMessage(getLanguageId(),(String) hashmap.get("msgid" ),"Common") ) ;
            else
                hashmap.put("message", hashmap.get("msgid"));
        }
        catch(Exception exception)
        {
            hashmap.put("message", exception.toString() + "= Here is the error :" + hashmap.get("result"));
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
                exception2.printStackTrace();
                hashmap.put("message", exception2.toString());
            }
        }
        return hashmap;
    }


 public HashMap modify()
    {
		super.modify();
		HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        ArrayList albatch = new ArrayList();
        HashMap hashmap2 = new HashMap();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        hashmap.put("result", new Boolean(false));
		albatch.add(getBatch_id(0));
		albatch.add(super.login_by_id);
        albatch.add(super.login_at_ws_no);
        albatch.add(super.login_facility_id);
		albatch.add(getCode(0));
		hashmap2.put("ModifySQL", UpdateBatchSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("ModifyData", albatch);
		hashmap1.put("LanguageData",LanguageData);
//		Object obj = null;
        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {	
			/*InitialContext initialcontext = new InitialContext();
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
                hashmap.put("message", getSTMessage(getLanguageId(),(String) hashmap.get("msgid" ),"ST") ) ;
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


	/* public HashMap insert()
	 {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        HashMap hashmap2 = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        hashmap.put("result", new Boolean(false));
        int i = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
        for(int j = 0; j < i; j++)
            if(getCode(j) != null && !getCode(j).equals(""))
            {
                ArrayList arraylist2 = new ArrayList();
                arraylist2.add(getCode(j));
                arraylist2.add(getLong_desc(j));
                arraylist2.add(getShort_desc(j));
                arraylist2.add(super.login_facility_id);
                arraylist2.add(getEff_status(j));
                arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
                arraylist2.add(super.login_by_id);
                arraylist2.add(super.login_at_ws_no);
                arraylist2.add(super.login_facility_id);
                arraylist.add(arraylist2);
                ArrayList arraylist3 = new ArrayList();
                arraylist3.add(getCode(j));
                arraylist1.add(arraylist3);
            }

        hashmap2.put("InsertSQL", super.InsertSQL);
        hashmap2.put("SelectSQL", super.SelectSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("WhereData", arraylist1);
        hashmap1.put("InsertData", arraylist);
        Object obj = null;
        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {
            InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
            SingleTableHandlerHome singletablehandlerhome = (SingleTableHandlerHome)PortableRemoteObject.narrow(obj1, eCommon.SingleTableHandler.SingleTableHandlerHome.class);
            singletablehandlerremote = singletablehandlerhome.create();
            hashmap = singletablehandlerremote.singleBatchHandler(hashmap1, hashmap2);
            if(((Boolean)hashmap.get("result")).booleanValue())
                hashmap.put("message", getMessage((String)hashmap.get("msgid")));
            else
            if(((String)hashmap.get("msgid")).equals("CODE_ALREADY_EXISTS"))
                hashmap.put("message", getMessage((String)hashmap.get("msgid")));
            else
                hashmap.put("message", hashmap.get("msgid"));
        }
        catch(Exception exception)
        {
            hashmap.put("message", exception.toString() + "= Here is the error :" + hashmap.get("result"));
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
                exception2.printStackTrace();
                hashmap.put("message", exception2.toString());
            }
        }
        return hashmap;
    }*/
}
