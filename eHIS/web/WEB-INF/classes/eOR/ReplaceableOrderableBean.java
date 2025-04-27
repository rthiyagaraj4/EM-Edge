/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.naming.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class ReplaceableOrderableBean extends OrAdapter implements Serializable
{

//  declaration of all properties of class

	protected String order_catalog_code			= "";	
	protected String order_catalog_code_repl	= "";
	protected String eff_status					= "D" ;
	protected Hashtable hashMultiple			= null;


// setter method for all properties
//return type@ void parameter @ type of properties

	public void setOrderCatalogCode(String order_catalog_code){
		this.order_catalog_code = order_catalog_code ;
	}

	public void setOrderCatalogCodeRepl(String order_catalog_code_repl){
		this.order_catalog_code_repl = order_catalog_code_repl;
	}

	public void  setEff_status(String  eff_status) 
	{
		  if(eff_status.trim().equals("") )
		  {
			  this.eff_status = "D";
		  }
		  else
		  {
			  this.eff_status= eff_status;
		  }
	}


// getter method for all properties of class
// return type@ type of properties   parameter@ void or nothing

	public String getOrderCatalogCode(){
		return order_catalog_code ;
	}


	public String getOrderCatalogCodeRepl(){
		return order_catalog_code_repl;
	}

  	public String getEffectiveStatus(){
		return eff_status;
	}


/*******************************setAll METHOD***************************************/

		public void setAll( Hashtable recordSetMultiple ) 
	{
		try{

				//System.out.println("######in setall method,recordSetMultiple="+recordSetMultiple);
				hashMultiple = recordSetMultiple ;
				setMode((String)recordSetMultiple.get("mode"));
			}catch(Exception e){e.printStackTrace();}
	}

/********************************METHOD TO Insert***********************************/

public HashMap insert(){

		//System.out.println(" ROBean insert Mode"+mode);

		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
		HashMap tabDataParam=new HashMap();

		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "true") ;

		ArrayList whereData		= new ArrayList();
		ArrayList recordStore	= new ArrayList() ;
		ArrayList tabData		= null;
		ArrayList tabData1		= null ;
		String ID				= "";

		try{
		sqlMap.put("InsertSQL",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_INSERT"));
		sqlMap.put("SelectSQL",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_DUPLICATE_CHK"));
		}

		catch(Exception e){
			System.err.println("exception in insert of ReplaceableOrderableBean.java="+e);
			e.printStackTrace();
		}

		for(int i=0;i<10;i++){
			ID = "order_catalog_code_repl_desc"+i;
			tabData = new ArrayList() ;
			tabData1 = new ArrayList() ;

			if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null))
			{

			tabData.add(((hashMultiple.get("order_catalog_code")==null || hashMultiple.get("order_catalog_code").equals(""))?"":(String)hashMultiple.get("order_catalog_code")).trim());
			tabData.add(((hashMultiple.get("order_catalog_code_repl"+i)==null || hashMultiple.get("order_catalog_code_repl"+i).equals(""))?"":(String)hashMultiple.get("order_catalog_code_repl"+i)).trim());
			tabData.add(((String)login_by_id).trim());
			tabData.add(((String)login_at_ws_no).trim());
			tabData.add(((String)login_facility_id).trim());
			tabData.add(((String)login_by_id).trim());
			tabData.add(((String)login_at_ws_no).trim());
			tabData.add(((String)login_facility_id).trim());
			recordStore.add((ArrayList)tabData);
			tabData1.add(((hashMultiple.get("order_catalog_code")==null || hashMultiple.get("order_catalog_code").equals(""))?"":(String)hashMultiple.get("order_catalog_code")).trim());
			tabData1.add(((hashMultiple.get("order_catalog_code_repl"+i)==null || hashMultiple.get("order_catalog_code_repl"+i).equals(""))?"":(String)hashMultiple.get("order_catalog_code_repl"+i)).trim());
    		whereData.add((ArrayList)tabData1);

		}
	}

		tabDataParam.put("InsertData",recordStore);
		tabDataParam.put("WhereData",whereData);
		tabDataParam.put("properties",getProperties());
		

		return getResult(tabDataParam,sqlMap);

	}   //end of insert



 /**********************************METHOD TO Delete*******************************/

 public HashMap delete(){
	try{
//System.out.println("###in delete,hashMultiple,catalog_code="+(String)hashMultiple.get("order_catalog_code"));
//System.out.println("###in delete,hashMultiple,order_catalog_code_repl="+(String)hashMultiple.get("order_catalog_code_repl"));
	HashMap sqlMap = new HashMap();
	ArrayList deldata=new ArrayList();
	HashMap tabData=new HashMap();

	deldata.add(((String)hashMultiple.get("order_catalog_code")).trim());
	deldata.add(((String)hashMultiple.get("order_catalog_code_repl")).trim());

	sqlMap.put("DeleteSQL",(String)OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_DELETE"));

	tabData.put("properties",getProperties());
	tabData.put("DeleteData",deldata);
	 
	return getResult(tabData,sqlMap);

	}catch(Exception e){
	System.err.println("exception in delete method of ReplaceableOrderableBean.java="+e);
	e.printStackTrace();
	return null;
	}
}      // end of Delete 



 /*****************************doCommon METHOD**************************************/

 private void doCommon() throws Exception {
 } // end of doCommon

	
/******************************getResult METHOD*************************************/

	
private  HashMap getResult(HashMap tabData , HashMap sqlMap )
{

	//System.out.println("####in get result###");
	String traceVal = "";
	HashMap map  = new HashMap() ;
	//SingleTableHandlerHome home = null;
	//SingleTableHandlerRemote remote = null;
    map.put( "result", new Boolean( false ) ) ;
    map.put( "flag", "true" ) ;

	try
	{
		/********************LOOK UP*************************/
		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
		home=(SingleTableHandlerHome)PortableRemoteObject.narrow( object, SingleTableHandlerHome.class) ;
		remote		 = home.create() ;*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();


		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) 
		{

			map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);	

		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
		{
			//map = remote.singleBatchHandler(tabData,sqlMap);
			map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		

		}
		
	/*	else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
		{
			//map = remote.modify(tabData, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		}   */

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

		
		String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
	    if( result ) 
		{
			//System.out.println("if result=true");
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			//System.out.println("if result=false");
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				//System.out.println("##code already exist");
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
				map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
		//System.out.println("####map#############="+map);
		return map;

	}catch(Exception e)
	{
		System.out.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	finally
	{
		clear();
		map.put("traceVal",traceVal);
	 }

}	 // end of get result method


/************************************************************************************/

public void clear() 
{
	super.clear();
	order_catalog_code		= "" ;
	order_catalog_code_repl	= "" ;
	eff_status 				= "E" ;
	hashMultiple			= null;
}


/************************************************************************************/

	
}		// end of class
