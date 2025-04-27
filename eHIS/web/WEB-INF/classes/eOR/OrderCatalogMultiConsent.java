/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import javax.servlet.*;
import javax.servlet.http.*;

import eCommon.Common.*;
import eOR.Common.* ;
import webbeans.eCommon.*;

import eOR.OROrderCatalogMultiConsent.*;


public class OrderCatalogMultiConsent extends OrAdapter implements java.io.Serializable 
{
	StringBuffer traceVal = new StringBuffer();
	protected Hashtable			hashMultiple;
	protected ArrayList			catalogues_data;
	protected ArrayList			catalog_details;

	public void  setCatalogues_data(ArrayList catalogues_data) 
	{
		this.catalogues_data = catalogues_data; 
	}

	public void  setCatalog_details(ArrayList catalog_details) 
	{
		this.catalog_details = catalog_details; 
	}

	public ArrayList getCatalogues_data() 
	{
		return this.catalogues_data; 
	}

	public ArrayList getCatalog_details() 
	{
		return this.catalog_details; 
	}

	/**
		This will populate all the order categories
		@return		:	ArrayList
	*/
	public ArrayList getAllOrderCategory() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategories	= new ArrayList() ;

		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1")) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] categoryRecords = new String[2];
				categoryRecords[0] = resultSet.getString("order_category");
				categoryRecords[1] = resultSet.getString("short_desc");

				OrderCategories.add(categoryRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderCategories;
	}


	/**
		This will populate all the order Types with respect to the order category selected
		@return		:	ArrayList
	*/

	public ArrayList getOrderTypes(String orderCategory) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderTypes	= new ArrayList() ;
		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ORDER_TYPE")) ;
			pstmt.setString(1,orderCategory);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] orderTypeRecords = new String[2];
				orderTypeRecords[0] = resultSet.getString("ORDER_TYPE_CODE");
				orderTypeRecords[1] = resultSet.getString("SHORT_DESC");

				OrderTypes.add(orderTypeRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderTypes;
	}
	
	/**
		This will populate all the Order Catalogues for the selected order category, order type, catalog and or defLimit
		@return		:	ArrayList
	*/
	public ArrayList getCatalogues(String orderCategory,String orderType, String catalogue, String defLimit) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList allCatalogues		= new ArrayList() ;
		String[] orMultiConsent = null;
		try
		{
			connection = getConnection();
			// if the slected defLimit is pending define
			if(!defLimit.equals("") && defLimit.equalsIgnoreCase("P"))
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_ORDER_CATALOG_NON_EXIST")) ;
			}
			// if the slected defLimit is all
			else if (!defLimit.equals("") && defLimit.equalsIgnoreCase("A"))
			{
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_ORDER_CATALOG")) ;
			}
			pstmt.setString(1,language_id);
			pstmt.setString(2,orderCategory);
			pstmt.setString(3,orderType);
			pstmt.setString(4,catalogue+"%");
			resultSet = pstmt.executeQuery();
			while(null!=resultSet && resultSet.next())
			{
				orMultiConsent = new String[6];
				orMultiConsent[0] = resultSet.getString("order_category_desc" );
				orMultiConsent[1] = resultSet.getString("order_type_desc" );
				orMultiConsent[2] = resultSet.getString("catalog_desc" );
				orMultiConsent[3] = resultSet.getString("ORDER_CATALOG_CODE" );
				orMultiConsent[4] = resultSet.getString(5);
				allCatalogues.add(orMultiConsent);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return allCatalogues;
	}
	/**
		This will populate Order Catalogue Consent detail information for the catalogue selected
		@return		:	ArrayList
	*/
	public ArrayList getCatalogInfo(String catalogCode) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList catalogInfo = new ArrayList();
		String consentFormList = "";
		String consentReqBefOrder = "";
		String consentReqBefRegn = "";
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_INFO")) ;
			pstmt.setString(1,catalogCode);
			resultSet = pstmt.executeQuery();
			while(null!=resultSet && resultSet.next())
			{
				consentFormList = resultSet.getString("CONSENT_FORM_LIST");
				consentReqBefOrder = resultSet.getString("NUM_OF_CONSENT_REQ_BO");
				consentReqBefRegn = resultSet.getString("NUM_OF_CONSENT_REQ_BR");
				catalogInfo.add(consentFormList);
				catalogInfo.add(consentReqBefOrder);
				catalogInfo.add(consentReqBefRegn);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return catalogInfo;
	}
	/**
		This method populate Catalogue Consent details information for the catalogue selected
		@return		:	ArrayList contains details of the catalogue
	*/
	public ArrayList getCatalogDetails(String catalogCode) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList catalogDetails	= new ArrayList() ;
		String[] orMultiConsent = null;
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_DTLS")) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,catalogCode);
			resultSet = pstmt.executeQuery();

			while(null!=resultSet && resultSet.next())
			{
				orMultiConsent = new String[6];
				orMultiConsent[0] = resultSet.getString("DESCRIPTION");
				orMultiConsent[1] = resultSet.getString("CODE");
				orMultiConsent[2] = resultSet.getString("STAGE");
				orMultiConsent[3] = resultSet.getString("DFLT_SELECTED");
				orMultiConsent[4] = resultSet.getString("SEQUENCE_ORDER"); 
				orMultiConsent[5] = resultSet.getString("DESCRIPTION");
				catalogDetails.add(orMultiConsent);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return catalogDetails;
	}

	public void setAll( Hashtable recordSetMultiple ) 
	{
		try
		{
			hashMultiple = recordSetMultiple ;
			setMode((String)recordSetMultiple.get("mode"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public HashMap validate() 
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "" ) ;
		return map ;
	}

	/**
		This method inserts the records entered by the user
		@return		:	HashMap
	*/
	public HashMap modify()
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean(false));
		map.put( "flag", "true");
		ArrayList recordStore = new ArrayList() ;
		HashMap sqlMap = new HashMap();
		try
		{
			sqlMap.put("SQL_OR_ORDER_CATALOG_MULTI_CONSENT_DELETE",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_DEL"));
			sqlMap.put("SQL_OR_ORDER_CATALOG_MULTI_CONSENT_INSERT",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_INS"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		String ID="";
		ArrayList tabData = null;
		int totalRecords = Integer.parseInt(((String)hashMultiple.get("totalRecords")).trim());
		String catalogCode = ((String)hashMultiple.get("order_catalog_code")).trim();
		int seq_number = 0;
		for(int i=0;i<totalRecords;i++)
		{
			ID = "consent_desc"  + i ;
			tabData = new ArrayList() ;
			if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null))
			{
				
				String mandatory = ((String)hashMultiple.get("mandatory" + i)).trim();
				String select = ((String)hashMultiple.get("select" + i)).trim();
				if((select.trim().equals("")) || (select.equalsIgnoreCase("N")))
				{
					//
				}
				else
				{
					seq_number ++;
					tabData.add(((String)hashMultiple.get("order_catalog_code")).trim());
					tabData.add(((String)hashMultiple.get("consent_form_id" + i)).trim());
					tabData.add(((String)hashMultiple.get("consent_stage" + i)).trim());
					if((mandatory.trim().equals("")) || (mandatory.equalsIgnoreCase("N")))
					{
						tabData.add("N");
					}
					else
					{
						tabData.add(mandatory.trim());
					}
					tabData.add(String.valueOf(seq_number));
					tabData.add(((String)login_by_id).trim()) ;
					tabData.add(((String)login_at_ws_no).trim()) ;
					tabData.add(((String)login_facility_id).trim()) ;
					tabData.add(((String)login_by_id).trim()) ;
					tabData.add(((String)login_at_ws_no).trim()) ;
					tabData.add(((String)login_facility_id).trim()) ;
					recordStore.add((ArrayList)tabData);
				}
			}
		}
		HashMap tabDataParam =  new HashMap();
 		tabDataParam.put( "UpdateData", recordStore);
		tabDataParam.put( "properties", getProperties());
		tabDataParam.put( "catalogCode", catalogCode);
		try
		{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_MULTICONSENT_JNDI"), OROrderCatalogMultiConsentHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();

			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			argArray	= null;
			paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					}
		}
		catch(Exception e)
		{
			System.err.println( "Error Calling EJB : "+e );
			map.put( "message", e.getMessage());
			e.printStackTrace();
		}
		map.put("traceVal",traceVal);
		traceVal.setLength(0);
		return map;
	}



	//////////////////////////////////////////////////

	public OrderCatalogMultiConsent()
    {
        recordSet = null;
        recordSet = new ArrayList();
    }

    public OrderCatalogMultiConsent(OrderCatalogMultiConsent recordset)
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
	/////////////////////////////////////////////////
}
