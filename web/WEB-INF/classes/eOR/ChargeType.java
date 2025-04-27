/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.ejb.* ;
import eCommon.Common.*;
import javax.rmi.* ;
import javax.naming.* ;
import eOR.Common.* ;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class ChargeType extends OrAdapter implements Serializable {


	//StringBuffer messages = new StringBuffer() ;

	//Connection connection = null ;
	//PreparedStatement pstmt = null ;


//  declaration of all properties of class

	protected String order_category		= "" ;
	protected String charge_type_code = "" ;
	protected String description			= "" ;
	//protected String order_type			="";
	protected String explanatory_note		="";
	protected Hashtable hashMultiple	=null;
/***********************************************************************/

	public void setOrderCategory(String order_category){
		this.order_category = order_category ;
	}

	public void setChargeTypeCode(String charge_type_code)
	{
  		this.charge_type_code=charge_type_code;
	}

    public void setDescription(String description)
	{
		this.description = description;
	}

	/*public void setOrderType(String order_type)
	{
		this.order_type = order_type ;
	}*/
	
	public void setExplanatoryNote(String explanatory_note)   
	{
		this.explanatory_note = explanatory_note ;
	}

/***********************************************************************/

	public String  getOrderCategory(){
		return order_category ;
	}

	public String getChargeTypeCode()
	{
  		return charge_type_code;
	}

	public String getDescription()
	{
		return description;
	}

	/*public String getOrderType()
	{
		return order_type ;
	}*/

	public String getExplanatoryNote()
	{
		return explanatory_note ;
	}


	/*****************************************************************/
	public void setAll( Hashtable recordSetMultiple ) 
	{
		try{
				hashMultiple = recordSetMultiple ;
				setMode((String)recordSetMultiple.get("mode"));
			}catch(Exception e){e.printStackTrace();}
	}
	/*****************************************************************/
	public HashMap insert()
	{

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "true") ;

		ArrayList whereData=new ArrayList();
		ArrayList recordStore = new ArrayList() ;
		HashMap sqlMap = new HashMap();
		try
		{
			sqlMap.put("InsertSQL",(String)OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_INSERT"));
			sqlMap.put("SelectSQL",(String)OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_DUPLICATE_CHK"));
		}catch(Exception e){

			e.printStackTrace();}

		String ID="";
		ArrayList tabData = null;
		ArrayList tabData1 = null ;

		for(int i=0 ; i < 8 ; i++)
		{


			ID = "charge_type_code"  + i ;
			tabData = new ArrayList() ;
			tabData1 = new ArrayList() ;

			if(!(((String)hashMultiple.get(ID)).equals("")||(String)hashMultiple.get(ID)==null))
			{
				
				tabData.add(((String)hashMultiple.get("charge_type_code"+ i)).trim()) ;
				tabData.add(((String)hashMultiple.get("description"+ i)).trim() );				
				tabData.add(((String)hashMultiple.get("order_category")).trim());	
				tabData.add(((String)hashMultiple.get("explanatory_note"+ i)).trim() );
				tabData.add(((String)login_by_id).trim()) ;
				tabData.add(((String)login_at_ws_no).trim()) ;
				tabData.add(((String)login_facility_id).trim()) ;			
				tabData.add(((String)login_by_id).trim()) ;				
				tabData.add((String)login_at_ws_no.trim()) ;
				tabData.add((String)login_facility_id.trim()) ;
				recordStore.add((ArrayList)tabData);
				tabData1.add(((String)hashMultiple.get("order_category")).trim());
				tabData1.add(((String)hashMultiple.get("charge_type_code"+ i)).trim()) ;
				whereData.add((ArrayList)tabData1);

			

			}
		 }




		 HashMap tabDataParam =  new HashMap() ;
		 tabDataParam.put( "InsertData", recordStore);
		 tabDataParam.put("WhereData",whereData);
		 tabDataParam.put( "properties", getProperties() );

		 return getResult(tabDataParam,sqlMap) ;

	}// end of insert method

/************************************************************************************/
public HashMap modify() 
	{

		HashMap dataMap = new HashMap() ;
		ArrayList tabdata = new ArrayList() ;

		tabdata.add( ((String)hashMultiple.get("description")).trim() ) ;
		tabdata.add( ((String)hashMultiple.get("explanatory_note")).trim() ) ;		
		tabdata.add(( (String)hashMultiple.get("charge_type_code")).trim() ) ;
				
		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL",OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_UPDATE") );
		}catch(Exception e){e.printStackTrace();}
		
		dataMap.put("properties", getProperties() );
		dataMap.put("ModifyData",tabdata);

		return getResult(dataMap,sqlMap) ;

	 }// end of modify method

/************************************************************************************/

public void clear() 
{
	super.clear();
	order_category		= "" ;
	charge_type_code		= "" ;
	description			= "" ;
	explanatory_note			= ""	;
	hashMultiple		=null;

}

/************************************************************************************/
public HashMap delete(){
try{

	HashMap tabData = new HashMap();
	ArrayList delData = new ArrayList() ;
	HashMap sqlMap = new HashMap();

	delData.add(( (String)hashMultiple.get("charge_type_code")).trim() ) ;
	delData.add(( (String)hashMultiple.get("order_category")).trim() ) ;
	

	sqlMap.put("DeleteSQL",OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_DELETE"));
	tabData.put("properties",getProperties());
	tabData.put("DeleteData",delData);
	return getResult(tabData,sqlMap) ;
	}catch(Exception e){
		
		logErrorMessage(e);
		return null;
	}

}

/************************************************************************************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap )
{

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
			//map = remote.delete(tabData, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);		


		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
		{
			//map = remote.singleBatchHandler(tabData,sqlMap);
			map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		


		}else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
		{
			//map = remote.modify(tabData, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	
		}
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

		String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
        if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
				/*String invalidCode_1=delimitedString((ArrayList)map.get("invalidCode"));
				String temp="";
				
				String invalidCode="";
				StringTokenizer invalidCode_2=new StringTokenizer(invalidCode_1,",");
				
				while (invalidCode_2.hasMoreTokens())
				{
					temp=invalidCode_2.nextToken();
					StringTokenizer invalidCode_3=new StringTokenizer(temp,":");
					while(invalidCode_3.hasMoreTokens())
					{
						invalidCode_3.nextToken();
						invalidCode+=invalidCode_3.nextToken();
						invalidCode+=",";
					}
				}
					*/	
				map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
		return map;

	}catch(Exception e)
	{

		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	finally
	{
		clear();
		/*try 
		{
			if( remote != null )
				remote.remove() ;
		} catch( Exception ee ) 
		{

			map.put( "message", ee.getMessage() ) ;
		}*/
		map.put("traceVal",traceVal);
	 }

	}
/************************************************************************************/
	public ArrayList getChargeTypeOrderCategory () throws Exception 
	{
		ArrayList OrderCat = new ArrayList() ;
		Connection connection=null;
		java.sql.ResultSet resultSet=null;
		java.sql.PreparedStatement pstmt = null;

		try {
			connection=	getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2") ) ;
			pstmt.setString(1,language_id);
			if(!(pstmt==null)){
				resultSet = pstmt.executeQuery() ;
			}
			String[] record =null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "ORDER_CATEGORY" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return OrderCat;
	}// end of  getTickSheetSectionOrderCategory () method
/**********************************************************/
public String getComboString(){
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet rs	= null;
	try {
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC2"));
		pstmt.setString(1,language_id);
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();

		String  codeCol			    = "";
		String  codeDesc			= "";

		while (rs.next()){
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}catch(Exception e){
		e.printStackTrace() ;
		return null;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
				closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}
}
/**********************************************************/
public String[] loadData(String charge_type_code)throws Exception
	{

	if(charge_type_code.equals(""))return null;
	String[] ChargeType = new String[2] ;
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	java.sql.PreparedStatement pstmt		= null;
	try {
		connection=getConnection() ;

		pstmt	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_SELECT"));
		pstmt.setString(1,charge_type_code.trim());
		
			resultSet		= pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			ChargeType[0]=resultSet.getString( "description" ) ;
			ChargeType[1]=resultSet.getString( "explanatory_note" ) ;
		
		}
		return ChargeType;

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;	

	}
	}



/***********************************************************/
	/*public ArrayList getOrderType (String order_category) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record			 =		null;

		ArrayList OrderType = new ArrayList() ;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHARGE_TYPE_ORD_TYPE_SELECT") ) ;
			pstmt.setString(1,order_category);
			resultSet	= pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					record = new String[2];
					record[0] = resultSet.getString( "description" )  ;
					record[1] = resultSet.getString( "code" )  ;
					OrderType.add(record) ;
			}
			record=null;
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderType;
	}*/

/**********************************************************/

}
