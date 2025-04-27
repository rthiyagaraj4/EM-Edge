/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
	Module		 : ePH
	Function	 : DrugCategory
	Class Name	 : DrugCategoryRuleByPatclBean
	Created By	 : A.S.Raghunath
	Created Date : 07-12-2002
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :

*/
//saved on 27/10/2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugCategoryRuleByPatclBean extends PhAdapter implements Serializable {
	

	protected String drug_catg_code	= "" ;
	protected String drug_catg_desc = "";
	protected String patient_class = "" ;
	protected String patient_class_desc = "" ;
	protected int	 max_durn_value = 0 ;
	protected String max_durn_type = "";
	protected String action_abbr ="";
	protected String ord_auth_level ="";
	protected String prompt_msg ="";

	public DrugCategoryRuleByPatclBean() {
		try {
			doCommon();
		}
		catch(Exception e) {}
	}

	/* Over-ridden Adapter methods start here */


	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}


	/* Set Methods Start */
	public void setDrugCatgCode( String drug_catg_code ) {
		this.drug_catg_code = drug_catg_code  ;	
	}

	public void setDrugCatgDesc( String drug_catg_desc ) {
		this.drug_catg_desc = drug_catg_desc  ;	
	}

	public void setPatientClass( String patient_class )	{
		this.patient_class = patient_class  ;
	}

	public void setPatientClassDesc( String patient_class_desc )	{
		this.patient_class_desc = patient_class_desc  ;
	}

	public void setMaxDurnValue ( int max_durn_value ){
		this.max_durn_value=max_durn_value;
	}

	public void setMaxDurnType( String max_durn_type ) {
		this.max_durn_type = max_durn_type  ;	
	}

	public void setActionAbbr( String action_abbr )	{
		this.action_abbr = action_abbr  ;
	}

	public void setOrdAuthLevel ( String ord_auth_level ){
		this.ord_auth_level=ord_auth_level;
	}

	public void setPromptMsg( String prompt_msg ) {
		this.prompt_msg = prompt_msg  ;	
	}

	/* Set Methods End */


	/* Get Methods Start */
	public String getDrugCatgCode() {
		return this.drug_catg_code ;
	}
	public String getDrugCatgDesc() {
		return this.drug_catg_desc ;
	}
	public String getPatientClass() {
		return this.patient_class ;
	}
	public String getPatientClassDesc() {
		return this.patient_class_desc ;
	}
	public int getMaxDurnValue() {
		return this.max_durn_value ;
	}
	public String getMaxDurnType() {
		return this.max_durn_type ;
	}
	public String getActionAbbr() {
		return this.action_abbr ;
	}
	public String getOrdAuthLevel() {
		return this.ord_auth_level ;
	}
	public String getPromptMsg() {
		return this.prompt_msg ;
	}
	/* Get Methods End */
	
	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("drug_catg_code"))
			setDrugCatgCode((String)recordSet.get("drug_catg_code")) ;
		if(recordSet.containsKey("patient_class"))
			setPatientClass((String)recordSet.get("patient_class")) ;
		if(recordSet.containsKey("max_durn_value"))
			setMaxDurnValue(Integer.parseInt((String)recordSet.get("max_durn_value"))) ;
		if(recordSet.containsKey("max_durn_type"))
			setMaxDurnType((String)recordSet.get("max_durn_type")) ;
		if(recordSet.containsKey("action_abbr"))
			setActionAbbr((String)recordSet.get("action_abbr")) ;
		if(recordSet.containsKey("ord_auth_level"))
			setOrdAuthLevel((String)recordSet.get("ord_auth_level")) ;
		if(recordSet.containsKey("prompt_msg"))
			setPromptMsg((String)recordSet.get("prompt_msg")) ;
		
	}

	/* Function specific methods start */

	public ArrayList getAllList(String locale)  throws Exception {

		ArrayList all=new ArrayList();
		ArrayList drugCatg = new ArrayList() ;
		ArrayList patientClass=new ArrayList();
		ArrayList durationType=new ArrayList();
		ArrayList phParamValues = new ArrayList();

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT1") ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					drugCatg.add( resultSet.getString( "DRUG_CATG_CODE" ) ) ;
					drugCatg.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)		closeStatement( pstmt ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT2") ) ;
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					patientClass.add( resultSet.getString( "PATIENT_CLASS" ) ) ;
					patientClass.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)		closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT5") ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					durationType.add( resultSet.getString( "DURN_TYPE" ) ) ;
					durationType.add( resultSet.getString( "DURN_DESC" ) );
				}
			}		

			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)		closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT9") ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					phParamValues.add( resultSet.getString( "MAX_DURN_FOR_OP_PRES" ) ) ;
					phParamValues.add( resultSet.getString( "MAX_DURN_FOR_IP_PRES" ) );
				}
			}	
			all.add(drugCatg);
			all.add(patientClass);
			all.add(durationType);
			all.add(phParamValues);
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { }
		}

		return all;
	}

// insert Method  starts here...
public HashMap insert()
{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "test" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		try{

			insertData.add( drug_catg_code.trim() ) ;
			insertData.add( patient_class.trim() ) ;
			insertData.add(	(max_durn_value+"").trim() ) ;
			insertData.add( max_durn_type.trim()) ;
			insertData.add( action_abbr.trim() ) ;
			insertData.add( ord_auth_level.trim() ) ;
			insertData.add( prompt_msg.trim() ) ;
			
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			whereData.add( drug_catg_code.trim() ) ;
			whereData.add( patient_class.trim() ) ;
			
			
			map.put( "flag", drug_catg_code.trim() + patient_class.trim() ) ;

	
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT6") );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_INSERT") );

/*			SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;*/
			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally {
			try {} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally*/
		
		return map ;
}//insert ends


//public ArrayList getPatientClassInfo(String locale) throws Exception	{ 
public ArrayList getPatientClassInfo() throws Exception	{ 
		Connection connection		  =	null ;
		PreparedStatement pstmt		  =	null ;
		ResultSet resultSet			  =	null ;

		ArrayList records				  =	new ArrayList();
		try {
			String[] strArr		 =   new String[7];
			connection			 =	  getConnection() ;
			pstmt				 =	  connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT5") );
//			pstmt.setString(1,locale);
			pstmt.setString(1,getLanguageId());

			resultSet			 =	  pstmt.executeQuery() ;
			while ( resultSet.next() ){
                strArr		        =  new String[2];  	
				strArr[0]			=	resultSet.getString("PATIENT_CLASS");
				strArr[1]			=	resultSet.getString("SHORT_DESC");
							
				
				records.add(strArr);
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return records;
	}























public void loadData() throws Exception {
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT4") );
			pstmt.setString( 1, drug_catg_code ) ;
			pstmt.setString( 2, patient_class  ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				setDrugCatgCode( resultSet.getString("DRUG_CATG_CODE" ));
				setDrugCatgDesc( resultSet.getString("DRUG_CATG_DESC" ));
				setPatientClass( resultSet.getString("PATIENT_CLASS" ));
				setPatientClassDesc( resultSet.getString("PATIENT_CLASS_DESC"));
				setMaxDurnType( resultSet.getString("MAX_DURN_TYPE" ));
				setMaxDurnValue( resultSet.getInt("MAX_DURN_VALUE" ));
				setActionAbbr( resultSet.getString("ACTION" ));
				setOrdAuthLevel( resultSet.getString("ORD_AUTH_LEVEL" ));
				setPromptMsg( resultSet.getString("PROMPT_MSG" )) ;
			}
			
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
	}

	public HashMap modify() {
	
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

		modifyData.add( (max_durn_value+"").trim()) ;
		modifyData.add( max_durn_type.trim()) ;
		modifyData.add( action_abbr.trim()) ;
		modifyData.add( ord_auth_level.trim()) ;
		modifyData.add( prompt_msg.trim()) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( drug_catg_code.trim() ) ;
		modifyData.add( patient_class.trim() ) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try{
		sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}

/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/

		try {

		/*	InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
    		map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			debug.append("BEFOER CREATE(IN MODIFY)");
			debug.append("BEFOER MODIFY");
			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));
			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
				map.put( "flag",debug.toString());
			}
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		} 
		/*finally {
			try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map ;	
	}

	public HashMap delete() {
			
		StringBuffer debug =new StringBuffer();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList deleteData = new ArrayList() ;

		deleteData.add( drug_catg_code.trim() ) ;
		deleteData.add( patient_class.trim() ) ;

		debug.append("CODE::(IN DELETE)"+drug_catg_code);
		debug.append("CLASS::"+patient_class);
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteData",deleteData);

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_DELETE") );
		}catch(Exception e){
			e.printStackTrace();
		}

/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/
		try {

/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
			map = remote.delete( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			debug.append("BEFORE DELETE.......");

			debug.append("AFTER DELETE......."+(Boolean) map.get( "result" ));

			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH")) ;
			

		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put("flag",debug.toString());
			e.printStackTrace() ;
		} finally {
			try {
				/*if( remote != null )
					remote.remove() ;*/
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		map.put("flag",debug.toString());
		return map ;
	}
}
