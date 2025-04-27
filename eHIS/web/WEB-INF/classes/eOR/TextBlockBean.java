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


public class TextBlockBean extends OrAdapter  implements java.io.Serializable {

	//protected Hashtable allValues = new Hashtable();

	protected String text_block_id ="";
	protected String discr_msr_panel_id="";
	protected String text_block="";
	protected String eff_status="";

	StringBuffer traceVals = new StringBuffer();
//StringBuffer message=new StringBuffer();



	public void setTextBlockId(String text_block_id){	this.text_block_id = text_block_id;	}
	public void setDiscrMsrPanelId(String discr_msr_panel_id){			this.discr_msr_panel_id = discr_msr_panel_id;	}
	public void setTextBlock(String text_block){			this.text_block = text_block;
}
public void setEffStatus(String eff_status){
this.eff_status=eff_status;
}
public String getTextBlockId(){return 	this.text_block_id ;	}
public String getDiscrMsrPanel_id(){return 	this.discr_msr_panel_id ;	}
public String getTextBlock(){return 	this.text_block ;}
public String getEffStatus(){ return this.eff_status;}



/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	/*public ArrayList getDiscreteMeasure() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList DiscMeas = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_DISC_MEAS_SELECT") ) ;

			resultSet = pstmt.executeQuery() ;
			String[] record=null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "discr_msr_id" )  ;

				DiscMeas.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return DiscMeas;
	}

*/

/**
	This will populate all the Status list by priority
	@return		:	ArrayList
*/


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public String[] loadData(String text_block_id1 ) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String [] values=new String[5];

		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_UPDATE") ) ;

			pstmt.setString( 1, text_block_id1 ) ;


			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
//				String[] record = new String[4];
				values[0] = resultSet.getString( "text_block_id" )  ;
				values[1] = resultSet.getString( "DISCR_MSR_PANEL_ID" )  ;
				values[2] = resultSet.getString( "TEXT_BLOCK" )  ;
				values[3] = resultSet.getString( "EFF_STATUS" )  ;
				values[4] = resultSet.getString( "short_desc" )  ;

			//	allVal.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return values;
	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public HashMap insert(){
		//System.out.println("in insert method....");
//		HashMap map = new HashMap() ;
//		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");
		this.mode="1";
		setMode(mode);
		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData=new ArrayList();

		insertData.add(text_block_id);
		whereData.add(text_block_id);
		insertData.add(discr_msr_panel_id);
		insertData.add(text_block);
		//System.out.println("####text_block.length="+text_block.length()+"==="+text_block_id+"discr_msr_panel_id"+discr_msr_panel_id);
		insertData.add(eff_status);

		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;

try{
	    sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_INSERT") );
	     sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_DUPLICATE_CHECK")  );//SQL_OR_TEXT_BLOCK_DUPLICATE_CHECK
		 //System.out.println("SQL_OR_TEXT_BLOCK_INSERT"+OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_INSERT"));
		//System.out.println("SQL_OR_TEXT_BLOCK_DUPLICATE_CHECK"+OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_DUPLICATE_CHECK"));
}catch(Exception e){e.printStackTrace();}
		

		//System.out.println("insertData"+insertData);

		traceVals.append("calling get result method");
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		tabData.put( "WhereData",whereData);
//		map.put("traceVal", tabData.toString());

		return getResult(tabData,sqlMap) ;
	}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public HashMap modify(){
		traceVals.append("just entered -- ");
		this.mode="2";
		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList modifyData = new ArrayList() ;
		setMode(mode);
		modifyData.add(discr_msr_panel_id);
		modifyData.add(text_block ) ;
		modifyData.add(eff_status ) ;
		modifyData.add(text_block_id ) ;
		try{
	    sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_SCOPE_MODIFY" ));}catch(Exception e){e.printStackTrace();}
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
//		map.put("traceVal", tabData.toString());

		return getResult(tabData,sqlMap) ;
		//return map;
	}

/**********This Method  Actually Calls the EJB's Method ********************/

private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
	//System.out.println("in get Result Method");
		HashMap map  = new HashMap() ;
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
		traceVals.append("  ::in the  get result method::");
		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();


			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				traceVals.append("calling  insert of single table handler");
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);		

			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				// map = remote.modify(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

			//System.out.println("============="+(String)map.get("msgid"));
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
				
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				
				
				//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
		//map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		map.put("traceVals",traceVals);
		//return map ;
	  }finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
			map.put("traceVal",traceVals);
		}
		return map;

 }//End of Method
///////// set all method


public String getComboString(){
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet rs	= null;
	try {
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_DISC_MEAS_SELECT"));
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol			    = "";
		String  codeDesc			= "";

		while (rs.next()){
				codeCol			    = ChkDef.defaultString(rs.getString(2));
				codeDesc			= ChkDef.defaultString(rs.getString(1));
			    sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}catch(Exception e){
		System.out.println(e.getMessage());
		return null;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
				closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}
}


/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		//System.out.println("in set all method....");
			//allValues = recordSet;
			if(recordSet.containsKey("text_block_id")){
				setTextBlockId((String)recordSet.get("text_block_id"));
			}
			if(recordSet.containsKey("discr_msr_panel_id")){
				setDiscrMsrPanelId((String)recordSet.get("discr_msr_panel_id"));//TEXT_BLOCK
			}

			if(recordSet.containsKey("text_block")){
				setTextBlock(((String)recordSet.get("text_block")).trim());}
			if(recordSet.containsKey("eff_status")){
						setEffStatus((String)recordSet.get("eff_status"));}

			this.mode = (String)recordSet.get( "mode" );
			setMode(mode);
	}

public void clear(){
//	 allValues =null;
	 text_block_id ="";
	 discr_msr_panel_id="";
	 text_block="";
	 eff_status="";
	 mode="";
}
		public void setFunctionId(String f_id)
	{
		this.function_id=f_id;

		}

		}
