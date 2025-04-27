 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

26/04/2023  40016           Ranjith P R       27/04/2023         Ramesh Goli        ML-MMOH-CRF-1823                 
----------------------------------------------------------------------------------------------------------------------------------------------------------	
 */
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

import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORUserForReview.*;

public class UserForReview extends OrAdapter implements java.io.Serializable {
	protected String responsibility 			= "";
	protected String responsibility_desc 	= "";
	protected String practitioner			 	= "";
	protected String practitioner_desc		= "";
	protected String order_category			= "";
	protected String order_category_desc	= "";
//	protected String order_type				= "";
//	protected String order_type_desc		= "";
	protected String responsibility_id		= "";
	protected String authorise					= "";
	protected String co_sign					= "";
	protected String sp_apprv					= "";
	protected String qu_apprv					= "";///40016
	StringBuffer traceVals = new StringBuffer();

//public String tmpChk = "";
	public void setResponsibility(String responsibility){
		this.responsibility = responsibility;
	}
	public void setResponsibilityDesc(String responsibility_desc){
		this.responsibility_desc = responsibility_desc;
	}
	public void setPractitioner(String practitioner){
		this.practitioner = practitioner;
	}
	public void setPractitionerDesc(String practitioner_desc){
		this.practitioner_desc = practitioner_desc;
	}
	public void setOrderCategoryDesc(String order_category_desc){
		this.order_category_desc = order_category_desc;
	}
	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setAuthorise(String authorise){
		this.authorise = authorise;
	}
	public void setCoSign(String co_sign){
		this.co_sign = co_sign;
	}
	public void setSpApprove(String sp_apprv){
		this.sp_apprv = sp_apprv;
	}
	//40016starts
	public void setQuApprove(String qu_apprv){
		this.qu_apprv = qu_apprv;
	}
	//40016end
	public void setMode(String mode){
		this.mode = mode;
	}
	public void setResponsibilityId(String responsibility_id){
		this.responsibility_id = responsibility_id;
	}


	public String getResponsibility(){
		return responsibility;
	}
	public String getResponsibilityDesc(){
		return responsibility_desc;
	}
	public String getPractitioner(){
		return practitioner;
	}
	public String getPractitionerDesc(){
		return practitioner_desc;
	}
	public String getOrderCategoryDesc(){
		return order_category_desc;
	}
	public String getOrderCategory(){
		return order_category;
	}
	public String getAuthorise(){
		return authorise;
	}
	public String getCoSign(){
		return co_sign;
	}
	public String getSpApprove(){
		return sp_apprv;
	}
	//40016starts
	public String getQuApprove(){
		return qu_apprv;
	}
	//40016end
	public String getMode(){
		return mode;
	}
	public String getResponsibilityId(){
		return responsibility_id;
	}



/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
        	closeConnection(connection) ;
		}
		return OrderCat;
	}


/**
	This will populate all the responsibilities
	@return		:	ArrayList
*/

	public ArrayList getAllResponsibility () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REPORTING_RESPONSIBILITY")) ;
			resultSet = pstmt.executeQuery() ;


			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "resp_id" )  ;
				record[1] = resultSet.getString( "resp_name" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}


/**
	This will populate all the order categories with scope of each category
	@return		:	ArrayList
*/

	public ArrayList allOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;
		traceVals.append("== before -- in populate - responsibility :"+responsibility);
		traceVals.append("== before -- in populate - practitioner :"+practitioner);
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT") ) ;

			//tmpChk = (String)OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT") ;

		   if(responsibility.equals(" ") || responsibility.equals("") || responsibility== " " || responsibility== "" ){
				responsibility= null;
			}
		   if(practitioner.equals(" ") || practitioner.equals("") || practitioner== " "  || practitioner== "" ){
				practitioner= null;
			}

		traceVals.append("== after -- in populate - responsibility :"+responsibility);
		traceVals.append("== after -- in populate - practitioner :"+practitioner);

			pstmt.setString( 1, responsibility ) ;
			pstmt.setString( 2, practitioner) ;
			pstmt.setString( 3, responsibility ) ;
			pstmt.setString( 4, practitioner) ;
			resultSet = pstmt.executeQuery() ;

			String auth_yn = "";
			String cosign_yn = "";
			String spl_appr_yn = "";
			String quota_limit_yn = "";//40016
			while ( resultSet != null && resultSet.next() ) {
				//String[] record = new String[5];
				String[] record = new String[6];//40016
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				auth_yn = resultSet.getString("auth_yn");
				if(auth_yn == null) 	{
					auth_yn = "";
				}
				record[2] = auth_yn;

				cosign_yn = resultSet.getString("cosign_yn");
				if(cosign_yn == null) 	{
					cosign_yn = "";
				}
				record[3] = cosign_yn;

				spl_appr_yn = resultSet.getString("spl_appr_yn");
				if(spl_appr_yn == null) 	{
					spl_appr_yn = "";
				}
				record[4] = spl_appr_yn;
				//40016starts
				quota_limit_yn = resultSet.getString("quota_limit_yn");
				if(quota_limit_yn == null) 	{
					quota_limit_yn = "";
				}
				record[5] = quota_limit_yn;
				//40016end

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}



/* Over-ridden Adapter methods start here */

	public HashMap validate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		HashMap map = new HashMap() ;

	   if(responsibility.equals(" ") || responsibility.equals("") || responsibility== " " ){
			responsibility= null;
		}
	   if(practitioner.equals(" ") || practitioner.equals("") || practitioner== " " ){
			practitioner= null;
		}


		map.put( "result", new Boolean( true ) ) ;
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
        {
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_DUP_CHK")) ;
				pstmt.setString( 1, practitioner ) ;
				pstmt.setString( 2, responsibility) ;

				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null && resultSet.next() ) {
					int count = resultSet.getInt( 1 ) ;
					if ( count > 0 ) {
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", "CODE_ALREADY_EXISTS" ) ;
					}
					else {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
				}
			  } catch ( Exception e ) {
				System.err.println( "Order Type - validate() method error" ) ;
				e.printStackTrace() ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", e ) ;
				throw e ;
			} finally {
				
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			
			}
		}
		return map ;
	}



/**
	This will set all the values to the HashMap, which further passsed as an input to the EJB
	@return		:	HashMap
*/

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");


		HashMap tabdata = new HashMap() ;

		traceVals.append("--before --practitioner  :"+practitioner);
		traceVals.append("-- responsibility : "+responsibility);
		try{
			if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
				responsibility= "";
			}
			if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
				practitioner= "";
			}
		}catch(Exception e){
			practitioner = "";
			responsibility = "";
		}

		traceVals.append("--after --practitioner  :"+practitioner);
		traceVals.append("-- responsibility : "+responsibility);

		tabdata.put("responsibility",responsibility);
		tabdata.put("practitioner",practitioner);
		tabdata.put("order_category",order_category);
		tabdata.put("auth_yn",authorise);
		tabdata.put("cosign_yn",co_sign);
		tabdata.put("spl_appr_yn",sp_apprv);
		tabdata.put("quota_limit_yn",qu_apprv);//40016
		tabdata.put( "added_by_id",			login_by_id ) ;
		//tabdata.put( "added_date",			added_date ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;
		tabdata.put( "modified_by_id",		login_by_id ) ;
//		tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;


		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_USER_FOR_REVIEW_INSERT", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_INSERT") );
		}catch(Exception e){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
//		traceVals.append("-- OrInterface.SQL_OR_USER_FOR_REVIEW_INSERT : "+OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_INSERT"));

		//ORUserForReviewHome home = null ;
		//ORUserForReviewRemote remote = null ;

		try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REVIEW") ) ;
				home  = (ORUserForReviewHome) PortableRemoteObject.narrow( object, ORUserForReviewHome.class ) ;
				tabdata.put( "properties", getProperties() );
				remote = home.create() ;
				//ORUserForReviewManager remote1 = new ORUserForReviewManager();
				map = remote.insert( tabdata, sqlMap ) ;*/
				//map = insert( tabdata, sqlMap ) ;
				
				Object home = com.ehis.eslp.ServiceLocator.getInstance ().getHome(OrRepository.getOrKeyValue("USER_FOR_REVIEW"), ORUserForReviewHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				
				//String ejbVals = (String)map.get("traceVal");

		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}






/**
	This will set all the values to the HashMap, which further passsed as an modify method of the EJB
	@return		:	HashMap
*/

	public HashMap modify(){
		HashMap map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				traceVals.append("just entered  now fresh-- ");

		HashMap tabdata = new HashMap() ;

		traceVals.append("--before --practitioner  :"+practitioner);
		traceVals.append("-- responsibility : "+responsibility);
		try{
			if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
				responsibility= "";
			}
			if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
				practitioner= "";
			}
		}catch(Exception e){
			practitioner = "";
			responsibility = "";
		}

		traceVals.append("--after --practitioner  :"+practitioner);
		traceVals.append("-- responsibility : "+responsibility);


		tabdata.put("responsibility",responsibility);
		tabdata.put("practitioner",practitioner);
		tabdata.put("order_category",order_category);

		tabdata.put("auth_yn",authorise);
		tabdata.put("cosign_yn",co_sign);
		tabdata.put("spl_appr_yn",sp_apprv);
		tabdata.put("quota_limit_yn",qu_apprv);//40016
		tabdata.put( "responsibility_id",	responsibility_id) ;

		traceVals.append("--after --order_category  :"+order_category);
		traceVals.append("-- authorise : "+authorise);
		//traceVals.append("--after --co_sign  :"+co_sign);
		traceVals.append("-- sp_apprv : "+sp_apprv);
		traceVals.append("-- qu_apprv : "+qu_apprv);//40016

		tabdata.put( "added_by_id",			login_by_id ) ;
		//tabdata.put( "added_date",			added_date ) ;
		tabdata.put( "added_at_ws_no",		login_at_ws_no ) ;
		tabdata.put( "added_facility_id",	login_facility_id ) ;

		tabdata.put( "modified_by_id",		login_by_id ) ;
//		tabdata.put( "modified_date",		modified_date ) ;
		tabdata.put( "modified_facility_id",login_facility_id ) ;
		tabdata.put( "modified_at_ws_no",	login_at_ws_no ) ;
		tabdata.put( "properties",	getProperties()) ;



		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SQL_OR_USER_FOR_REVIEW_UPDATE", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_UPDATE") );
			sqlMap.put( "SQL_OR_USER_FOR_REVIEW_INSERT", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_INSERT") );
			sqlMap.put( "USER_FOR_REVIEW_DELETE", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_DELETE") );
		}catch(Exception e){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}

//		traceVals.append("-- OrInterface.SQL_OR_USER_FOR_REVIEW_UPDATE: "+OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_UPDATE"));

		//ORUserForReviewHome home = null ;
		//ORUserForReviewRemote remote = null ;

		try {
				tabdata.put( "properties", getProperties() );
			/*	InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REVIEW") ) ;
				home  = (ORUserForReviewHome) PortableRemoteObject.narrow( object, ORUserForReviewHome.class ) ;
				
				remote = home.create() ;
				//ORUserForReviewManager remote1 = new ORUserForReviewManager();
				map = remote.modify( tabdata, sqlMap ) ;*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance ().getHome(OrRepository.getOrKeyValue("USER_FOR_REVIEW"), ORUserForReviewHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= tabdata;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= tabdata.getClass();
					paramArray[1]	= sqlMap.getClass();

				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				
				boolean map_result = ((Boolean)map.get( "result" )).booleanValue();
				//System.out.println("map_result>>>>"+map_result);
				if(!(map_result)){
					//map = remote.delete( tabdata, sqlMap ) ;
					map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					//System.out.println("map>>>> after delete ::: "+map);
					//map = remote.insert( tabdata, sqlMap ) ;
					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				}
				//map = modify( tabdata, sqlMap ) ;

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;

				//String ejbVals = (String)map.get("traceVal");
				//traceVals.append("-- ejbVals : "+ejbVals);




               map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				map.put("traceVal", (String)traceVals.toString());





		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}

		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}



/**
	This will set all the values to the HashMap, which further passsed as an delete method of the EJB
	@return		:	HashMap
*/

	public HashMap delete(){
		HashMap map = new HashMap() ;
				map.put( "result", new Boolean( false ) ) ;
				traceVals.append("just entered to delete methos-- ");
				HashMap tabdata = new HashMap() ;

				if(responsibility==null || responsibility.equals("") || responsibility.equals("") || responsibility.equals(" ") ){
					responsibility= "";
				}
				if(practitioner == null || practitioner.equals("") || practitioner.equals(" ") ){
					practitioner= "";
				}

				tabdata.put("responsibility",responsibility);
				tabdata.put("practitioner",practitioner);
				tabdata.put( "properties",	getProperties()) ;
				tabdata.put( "responsibility_id",	responsibility_id) ;


				HashMap sqlMap = new HashMap() ;
				try{
					sqlMap.put( "USER_FOR_REVIEW_DELETE", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_DELETE") );
				}catch(Exception e){
					System.err.println( "Error loading values from database" ) ;
					e.printStackTrace() ;
				}

//				traceVals.append("the query is : "+OrRepository.getOrKeyValue("USER_FOR_REVIEW_DELETE") );
				traceVals.append(" --responsibility: "+responsibility);
				traceVals.append(" --practitioner: "+practitioner);

				//ORUserForReviewHome home = null ;
				//ORUserForReviewRemote remote = null ;

				try {
						/*InitialContext context = new InitialContext() ;
						Object object = context.lookup( OrRepository.getOrKeyValue("USER_FOR_REVIEW")) ;
						home  = (ORUserForReviewHome) PortableRemoteObject.narrow( object, ORUserForReviewHome.class ) ;
						remote = home.create() ;
						//ORUserForReviewManager remote1 = new ORUserForReviewManager();
						map = remote.delete( tabdata, sqlMap ) ;*/
						//map = delete( tabdata, sqlMap ) ;
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("USER_FOR_REVIEW"), ORUserForReviewHome.class, getLocalEJB());
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[]	= new Object[2];
							argArray[0]		= tabdata;
							argArray[1]		= sqlMap;
						Class [] paramArray = new Class[2];
							paramArray[0]	= tabdata.getClass();
							paramArray[1]	= sqlMap.getClass();
						map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
								
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
						argArray	= null;
						paramArray	= null;
						//String ejbVals = (String)map.get("traceVal");
						//traceVals.append("-- ejbVals : "+ejbVals);



		          if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}


		map.put( "traceVal", traceVals.toString() ) ;


				} catch(Exception e) {
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} finally {
					clear();
					/*try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee ) {
						System.err.println( ee.getMessage() ) ;
						map.put( "message", ee.getMessage() ) ;
					}*/
				}
		map.put( "traceVal", traceVals.toString() ) ;

		return map ;

	}



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/



	public void setAll( Hashtable recordSet ) {

		if(recordSet.containsKey("responsibility")){
			setResponsibility((String)recordSet.get("responsibility")) ;
		}
		if(recordSet.containsKey("practitioner")){
			setPractitioner((String)recordSet.get("practitioner")) ;
		}
		if(recordSet.containsKey("allOrderCats")){
			setOrderCategory((String)recordSet.get( "allOrderCats" ));
		}
		if(recordSet.containsKey("allFinalAuth")){
			setAuthorise((String)recordSet.get( "allFinalAuth" ));
		}
		if(recordSet.containsKey("allFinalCo_sign")){
			setCoSign((String)recordSet.get( "allFinalCo_sign" ));
		}
		if(recordSet.containsKey("allFinalSp_appr")){
			setSpApprove((String)recordSet.get( "allFinalSp_appr" ));
		}
		//40016start
		if(recordSet.containsKey("allFinalQu_appr")){
			setQuApprove((String)recordSet.get( "allFinalQu_appr" ));
		}
		//40016end
		if(recordSet.containsKey("mode")){
			setMode((String)recordSet.get( "mode" ));
		}
		if(recordSet.containsKey("responsibility_id")){
			setResponsibilityId((String)recordSet.get( "responsibility_id" ));
		}
	}

/**
	This will clear all the values of all bean variables
	@return		:	void
*/

	public void clear() 
	{
		responsibility 		= "";
		practitioner			= "";
		order_category	= "";

		super.clear() ;
	}

}
