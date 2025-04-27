/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     PO Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eMM ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;
import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest ;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eMM.Common.*;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;

 
public class ParameterBean extends MmAdapter implements Serializable 
{
	protected String	dflt_trade_id		=	"";
	protected String	dflt_batch_id		=	"";
	protected String	receive_bonus_yn	=	"N";
	protected String	receive_sample_yn 	=	"N";
	protected String	module_id			=	"MM";
	//protected String	language_id;
	
	protected String	ss_period_end_scope    =	"";
	protected String	st_period_end_scope    =	"";
	protected String	po_period_end_scope    =	"";
	protected String	decentralized_inv_yn   =	"";

	protected String	po_mandatory_yn	=	"N";	//Added for GDOH-CRF-0109
	public void setDecentralized_inv_yn( String decentralized_inv_yn){
		this.decentralized_inv_yn	=  checkForNull(decentralized_inv_yn,"N");
	}
	public String getDecentralized_inv_yn(){
		return this.decentralized_inv_yn;
	}

	public void setSs_period_end_scope( String ss_period_end_scope){
		this.ss_period_end_scope	=  ss_period_end_scope;
	}
	public String getSs_period_end_scope(){
		return this.ss_period_end_scope;
	}
/*	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setSt_period_end_scope( String st_period_end_scope){
		this.st_period_end_scope	=  st_period_end_scope;
	}
	public String getSt_period_end_scope(){
		return this.st_period_end_scope;
	}

	public void setPo_period_end_scope( String po_period_end_scope){
		this.po_period_end_scope	=  po_period_end_scope;
	}
	public String getPo_period_end_scope(){
		return this.po_period_end_scope;
	}






	public ParameterBean() throws Exception
	{
		try 
		{
			doCommon();
		}
		catch(Exception e) {
				e.printStackTrace() ;
		}
	}

	/* Set Methods Start */
	public void setTradeID( String dflt_trade_id)
	{
		this.dflt_trade_id	=  dflt_trade_id;
	}

	public void setBatchID( String dflt_batch_id )
	{
		this.dflt_batch_id		=	dflt_batch_id;
	}

	
    public void setReceiveBonusYN ( String receive_bonus_yn ){
        if(receive_bonus_yn.equals("") || receive_bonus_yn==null )
            this.receive_bonus_yn = "N" ;
        else
            this.receive_bonus_yn = receive_bonus_yn ;
    }
	
    public void setReceiveSampleYN ( String receive_sample_yn ){
        if(receive_sample_yn.equals("") || receive_sample_yn==null )
            this.receive_sample_yn = "N" ;
        else
            this.receive_sample_yn = receive_sample_yn ;
    }
	//Added against GDOH-CRF-0109 starts
    public void setPo_mandatory_yn(String po_mandatory_yn) {
        if(po_mandatory_yn.equals("") || po_mandatory_yn==null )
            this.po_mandatory_yn = "N" ;
        else
        	this.po_mandatory_yn = po_mandatory_yn;
	}
	//Added against GDOH-CRF-0109 ends
	/* Set Methods End */

	/* Get Methods Start */
	public String getTradeID()
	{
		return this.dflt_trade_id;
	}

	public String getBatchID()
	{
		return this.dflt_batch_id;
	}


	public String getReceiveBonusYN()
	{
		return this.receive_bonus_yn;
	}

	public String getReceiveSampleYN() 
	{
		return this.receive_sample_yn	;
	}
	//Added against GDOH-CRF-0109 starts
	public String getPo_mandatory_yn() {
		return po_mandatory_yn;
	}
	//Added against GDOH-CRF-0109 ends

	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() 
	{
		super.clear() ;
		dflt_trade_id		=	"";  		
		dflt_batch_id		=	"";  
                         
		receive_bonus_yn	=	"N"; 
		receive_sample_yn 	=	"N"; 

		po_mandatory_yn		=	"N";	//Added for GDOH-CRF-0109
		ss_period_end_scope    =	"N";
		st_period_end_scope    =	"N";
		po_period_end_scope    =	"N";
		decentralized_inv_yn   =	"N";


	}
	public void setAll( Hashtable recordSet ) 
	{
		super.setAll(recordSet);

		if(recordSet.containsKey("dflt_trade_id"))
			setTradeID((String)recordSet.get("dflt_trade_id"));

		if(recordSet.containsKey("dflt_batch_id"))
			setBatchID((String)recordSet.get("dflt_batch_id"));

		if(recordSet.containsKey("receive_bonus_yn"))
			setReceiveBonusYN((String)recordSet.get("receive_bonus_yn"));

		if(recordSet.containsKey("receive_sample_yn"))
			setReceiveSampleYN((String)recordSet.get("receive_sample_yn")) ;
				//Added against GDOH-CRF-0109 starts
		if(recordSet.containsKey("po_mandatory_yn"))
			setPo_mandatory_yn((String)recordSet.get("po_mandatory_yn")) ;
		//Added against GDOH-CRF-0109 ends
		
		setSs_period_end_scope ((String)recordSet.get("ss_period_end_scope")) ;
		setSt_period_end_scope ((String)recordSet.get("st_period_end_scope")) ;
		setPo_period_end_scope ((String)recordSet.get("po_period_end_scope")) ;
		setDecentralized_inv_yn((String)recordSet.get("decentralized_inv_yn")) ;
		
	}

	private void doCommon() throws Exception 
	{
	}

	public HashMap insert() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();

		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();

		InsertData.add(receive_bonus_yn);
		InsertData.add(receive_sample_yn);
		InsertData.add(dflt_batch_id);
		InsertData.add(dflt_trade_id);

		InsertData.add(ss_period_end_scope  );
		InsertData.add(st_period_end_scope  );
		InsertData.add(po_period_end_scope  );
		InsertData.add(decentralized_inv_yn );

		InsertData.add(po_mandatory_yn );	//Added against GDOH-CRF-0109 
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);

		WhereData.add(module_id);

		tabData.put("InsertData",InsertData);
		tabData.put("WhereData",WhereData);
		tabData.put("properties",getProperties());

		HashMap sqlMap = new HashMap();
	
		
//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try {
		//sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue("SQL_MM_PARAMETER_ADMIN_INSERT1") );//Commented for SS_ICN-0001
        sqlMap.put( "InsertSQL", "INSERT INTO mm_parameter ( receive_bonus_yn, receive_sample_yn, dflt_batch_id, dflt_trade_id, ss_period_end_scope, st_period_end_scope, po_period_end_scope, decentralized_inv_yn, po_mandatory_yn, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );
		sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue("SQL_MM_PARAMETER_ADMIN_EXIST") );

			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;
		
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				 map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put( "message", map.get("msgid") ) ;
			} 
			catch(Exception e)
			{
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
					}
			}
		return map ;
	}

	
	public HashMap modify() 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		HashMap tabData = new HashMap();
		ArrayList ModifyData = new ArrayList();

		ModifyData.add(receive_bonus_yn);
		ModifyData.add(receive_sample_yn);
		ModifyData.add(dflt_batch_id);
		ModifyData.add(dflt_trade_id);		
		ModifyData.add(ss_period_end_scope  );
		ModifyData.add(st_period_end_scope  );
		ModifyData.add(po_period_end_scope  );
		ModifyData.add(decentralized_inv_yn );

		ModifyData.add(po_mandatory_yn );	//Added against GDOH-CRF-0109 
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
		ModifyData.add(module_id);

		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;
		HashMap sqlMap = new HashMap();

//		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;

		try
			{
				sqlMap.put( "ModifySQL", MmRepository.getMmKeyValue("SQL_MM_PARAMETER_ADMIN_UPDATE") );


			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/
				Object home1 =com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				 map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put("message",map.get("msgid"));		

			}
			catch(Exception e)
			{
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee )
				{
					map.put( "message", ee.getMessage() ) ;
				}
			}

		return map ;
	}

	public void loadData() throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(MmRepository.getMmKeyValue("SQL_MM_PARAMETER_ADMIN_SINGLE"));
					
			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setBatchID(resultSet.getString("dflt_batch_id"));
				setTradeID(resultSet.getString("dflt_trade_id"));
				setReceiveBonusYN(checkForNull(resultSet.getString("receive_bonus_yn")));
				setReceiveSampleYN(checkForNull(resultSet.getString("receive_sample_yn")));

				setSs_period_end_scope (checkForNull(resultSet.getString("ss_period_end_scope")));
				setSt_period_end_scope (checkForNull(resultSet.getString("st_period_end_scope")));
				setPo_period_end_scope (checkForNull(resultSet.getString("po_period_end_scope")));
				setDecentralized_inv_yn(checkForNull(resultSet.getString("decentralized_inv_yn")));
				setPo_mandatory_yn(checkForNull(resultSet.getString("po_mandatory_yn")));	//Added against GDOH-CRF-0109 
				
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
	}

	public boolean recordExists() throws Exception{
		boolean	bReturn=false;
		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_PARAMETER_ADMIN_EXIST"));
			preparedStatement.setString(1,"MM");
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			bReturn=(resultSet.getInt("total")!=0);
			if( preparedStatement != null)
					closeStatement(preparedStatement);
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	finally
		{
			try{
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
			

		}

		
		return bReturn;
	}

	public ArrayList CheckForEnable() throws Exception{
        boolean	bReturn=false;
		ArrayList alChechInst = new ArrayList();
		ArrayList alAllModl   = new ArrayList();

        alAllModl.add("PO");
        alAllModl.add("SS");
		alAllModl.add("ST");

		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_MODULE_INSTALLED_CHECK"));
			for(int i=0;i<3;i++)
            {

				preparedStatement.setString(1,(String)alAllModl.get(i));
				resultSet=preparedStatement.executeQuery();
				resultSet.next();
				bReturn=(resultSet.getInt("COUNT")!=0);
				
				/*if(preparedStatement != null)
					closeStatement(preparedStatement);*/
				if(resultSet != null)
					closeResultSet(resultSet);

				if(bReturn==true)
				{
                  alChechInst.add("Y");
				}
                else
                {
                  alChechInst.add("N");
				}
			}
		}
		catch (Exception exception){
			exception.printStackTrace();
		
		}
		finally
		{
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
			

		}
		return alChechInst;
	}
	
}
