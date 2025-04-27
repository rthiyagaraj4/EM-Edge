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


public class DisposableAdjustmentBean extends StMultipleInsertMasterBean
    implements Serializable
{
		private String batch_id[];
	    private String batch_yn[];
		private String batch_series[];
		private String store_code[];
		private String eff_status[];
		private String SelectBatchSQL ;
		private String UpdateBatchSQL;
	    private String selected_store_code;
	
		public DisposableAdjustmentBean()
		{	
			RECORD_SIZE = Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	        batch_id = new String[RECORD_SIZE];
		    batch_yn = new String[RECORD_SIZE];
			batch_series=new String[RECORD_SIZE]; 
			store_code=new String[RECORD_SIZE];
			eff_status=new String[RECORD_SIZE];
			 
			super.InsertSQL = StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_INSERT");
			//super.ModifySQL = StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_SELECT_SINGLE");
			//super.UpdateSQL = StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_UPDATE");
			super.SelectSQL = StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_COUNT");
			UpdateBatchSQL=StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_BATCH");
			SelectBatchSQL = StRepository.getStKeyValue("SQL_ST_DISPOSABLE_ADJUSTMENT_SELECT_BATCH_ID"); 
			super.codeFieldName = "store_code";
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
    public String getBatch_id(int i)
    {	
        return batch_id[i] ; 
    }
    public String getBatch_yn(int i)
    {
        return batch_yn[i] ;
    }
	
	  public void setStore_code(int i, String s)
    {
		
        store_code[i] = s;
    }
	 public String getStore_code(int i)
    {	
        return store_code[i] ; 
    }
	 public void setEff_status(int i, String s)
    {
        eff_status[i] = s;
    }
	
	 public String getEff_status(int i)
    {
        return eff_status[i];
    }
	
	   

	 public void setAll(Hashtable hashtable)
	{
		super.setAll(hashtable);
		for(int i = 0; i < RECORD_SIZE; i++)
        {
			String s = (String)hashtable.get("store_code_" + i);
			String batch_id  = (String)hashtable.get("batch_id_" + i);
            String batch_yn = (String)hashtable.get("auto_gen_batch_yn_" + i);
			String batch_series=(String)hashtable.get("batch_series_"+i);
			String eff_status = (String)hashtable.get("eff_status_" + i);
			
            if(s == null || s.equals(""))
            {
			   setStore_code(i, null);
                setBatch_id(i, null);
                setBatch_yn(i, null);
				setBatch_series(i,null);
				setEff_status(i, null);

            }else{

                setBatch_id(i, batch_id);
                setBatch_yn(i, batch_yn);
				setBatch_series(i,batch_series);
				setStore_code(i, s);

                if(batch_yn == null || batch_yn.trim().equals(""))
                    setBatch_yn(i, "N");
                else
                    setBatch_yn(i, batch_yn);
					
					 if(eff_status == null || eff_status.trim().equals(""))
                    setEff_status(i, "D");
                else
                    setEff_status(i, eff_status);
            }
        }

    }

public void loadData() throws Exception
{ 
		//super.loadData();

        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;

        try
        {
            connection = getConnection();
			preparedstatement = connection.prepareStatement(SelectBatchSQL);
			System.out.println("store_code==>"+getStore_code(0));
			preparedstatement.setString(1, getStore_code(0));
			resultset = preparedstatement.executeQuery();
			if(resultset != null && resultset.next())
            {

				setBatch_yn(0,resultset.getString("auto_gen_batch_yn"));
				setBatch_id(0,resultset.getString("next_batch_id"));
				setBatch_series(0,resultset.getString("batch_id_series"));
				setEff_status(0,resultset.getString("eff_status")); 
				
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
            if(getStore_code(j) != null && !getStore_code(j).equals(""))
            {
                ArrayList arraylist2 = new ArrayList();
                arraylist2.add(getStore_code(j));
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
                arraylist3.add(getStore_code(j));
               // arraylist3.add(getBatch_id(j));
				//arraylist3.add(getBatch_series(j));
				
                arraylist1.add(arraylist3);
            
			}

        hashmap2.put("InsertSQL", super.InsertSQL);
        hashmap2.put("SelectSQL", super.SelectSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("WhereData", arraylist1);
        hashmap1.put("InsertData", arraylist);
		hashmap1.put("LanguageData",LanguageData);
		
		//System.out.println("hashmap2==214======>" +hashmap2 +"hashmap1" +hashmap1);

        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {

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
		//super.modify();
		HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        ArrayList albatch = new ArrayList();
        HashMap hashmap2 = new HashMap();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        hashmap.put("result", new Boolean(false));
		albatch.add(getBatch_yn(0));
		albatch.add(getBatch_id(0));
		albatch.add(getEff_status(0));
		albatch.add(super.login_by_id);
        albatch.add(super.login_at_ws_no);
        albatch.add(super.login_facility_id);
		albatch.add(getStore_code(0));
		 
		
		hashmap2.put("ModifySQL", UpdateBatchSQL);
        hashmap1.put("properties", getProperties());
        hashmap1.put("ModifyData", albatch);
		hashmap1.put("LanguageData",LanguageData);
		
		//System.out.println("hashmap2 modify==>" +hashmap2 +"hashmap1" +hashmap1);
 
        SingleTableHandlerRemote singletablehandlerremote = null;
        try
        {	
			 

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


	 public void setSelected_store_code(String selected_store_code) {
		this.selected_store_code = selected_store_code;
	}

	public String getSelected_store_code() {
		return this.selected_store_code;
	}
	
	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues, getSelected_store_code());
		alOptionValues = null;
		return optionValues;
	}	
}
