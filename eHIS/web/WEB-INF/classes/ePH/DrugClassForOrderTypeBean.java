/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugClassForOrderType.*;

public class DrugClassForOrderTypeBean extends PhAdapter implements Serializable {
	protected HashMap orderType 		= null ;
	protected HashMap duprecs	 		= null ;

	public DrugClassForOrderTypeBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) 
		{
		  e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */

	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap insert() {
		return updateTable();
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	private HashMap updateTable() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "test" ) ;
		map.put( "message", getMode() ) ;

		int donothing = 0;
		StringBuffer s = new StringBuffer() ;

		ArrayList insertData = new ArrayList() ;
		ArrayList modifyData = new ArrayList() ;
		ArrayList deleteData = new ArrayList() ;

		HashMap commonData = new HashMap() ;
		commonData.put( "login_by_id", login_by_id ) ;
		commonData.put( "login_at_ws_no", login_at_ws_no ) ;
		commonData.put( "login_facility_id", login_facility_id ) ;
		for ( int i = 0; i < orderType.size(); i++ ) {
			StringTokenizer st = new StringTokenizer(orderType.get(i+"").toString(), ",");
			String code			= st.nextToken();
			st.nextToken();
			String drugclass	= st.nextToken();
			st.nextToken();
			String dbmode		= st.nextToken();
			if ( dbmode.equalsIgnoreCase("I") ) {
				insertData.add( code ) ;
				insertData.add( drugclass ) ;
			}
			else if ( dbmode.equalsIgnoreCase("M") ) {
				modifyData.add( drugclass ) ;
				modifyData.add( code ) ;
			}
			else if ( dbmode.equalsIgnoreCase("D") ) {
				deleteData.add( code ) ;
			}
			else if ( dbmode.equalsIgnoreCase("DN") ) {
				donothing ++;
			}
		}
		if (orderType.size() != donothing) {

/*			DrugClassForOrderTypeHome home = null ;
			DrugClassForOrderTypeRemote remote = null ;*/

			try {
				HashMap tabData = new HashMap() ;
				tabData.put( "COMMONDATA", commonData ) ;
				tabData.put( "PROPERTIES", getProperties() ) ;
				tabData.put( "INSERTDATA", insertData ) ;
				tabData.put( "MODIFYDATA", modifyData ) ;
				tabData.put( "DELETEDATA", deleteData ) ;

				HashMap sqlMap = new HashMap() ;
				sqlMap.put( "INSERTSQL", PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_FOR_DRUG_CLASS_INSERT" ) ) ;
				sqlMap.put( "MODIFYSQL", PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_FOR_DRUG_CLASS_UPDATE" ) );
				sqlMap.put( "DELETESQL", PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_FOR_DRUG_CLASS_DELETE" ) );

/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_DRUG_CLASS_FOR_ORDER_TYPE" ) ) ;

				home  = (DrugClassForOrderTypeHome) PortableRemoteObject.narrow( object, DrugClassForOrderTypeHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;  */

    			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DRUG_CLASS_FOR_ORDER_TYPE"), DrugClassForOrderTypeHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;
				
				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() ) {
					//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				}
				else 
				{
					map.put( "message", map.get("msgid") ) ;
				}
			}
			catch (Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
/*			finally {
				try {
					if( remote != null )
						remote.remove() ;
				}
				catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}
			}*/
		}
		else {
			map.put( "message", "ATLEAST_ONE_SELECTED" ) ;
		}
		map.put( "flag", s.toString() + "INSERTDATA : " + insertData.toString() + "MODIFYDATA : " + modifyData.toString() + "DELETEDATA : " + deleteData.toString());
		return map ;
	}

	public ArrayList getOrderTypeDetails(String ordTypeCode) {
		ArrayList orderTypeDetails = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_FOR_DRUG_CLASS_SELECT3" ) ) ;
			pstmt.setString(1,ordTypeCode) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					orderTypeDetails.add( resultSet.getString( "LONG_DESC" ) ) ;
					orderTypeDetails.add( resultSet.getString( "ORDER_CATEGORY_DESC" ) );
					orderTypeDetails.add( resultSet.getString( "FREQ_APPLICABLE_YN" ) );
					orderTypeDetails.add( resultSet.getString( "SOFT_STOP_YN" ) );
					orderTypeDetails.add( resultSet.getString( "CONT_ORDER_YN" ) );
					orderTypeDetails.add( resultSet.getString( "PIN_APPLICABLE_ON_ORDER_YN" ) );
					orderTypeDetails.add( resultSet.getString( "PIN_APPLICABLE_ON_RESULT_YN" ) );
					orderTypeDetails.add( resultSet.getString( "REGN_REQD_YN" ) );
					/*if (!( resultSet.getString( "ELAPSED_PRD_CLOSE_UNPR" ) == null || resultSet.getString( "ELAPSED_PRD_CLOSE_UNPR" ).equals(null) ) )
						orderTypeDetails.add( resultSet.getString( "ELAPSED_PRD_CLOSE_UNPR" ) );
					else
						orderTypeDetails.add( "" );
					if (!( resultSet.getString( "ELAPSED_PRD_CLOSE_INPR" ) == null || resultSet.getString( "ELAPSED_PRD_CLOSE_INPR" ).equals(null) ) )
						orderTypeDetails.add( resultSet.getString( "ELAPSED_PRD_CLOSE_INPR" ) );
					else
						orderTypeDetails.add( "" );
						*/
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{
				System.out.println("Exception while closing statements and resultsets"+es.toString());
			}
		}
		return orderTypeDetails;
	}

	public HashMap getOrderType() {
		orderType = new HashMap();
		duprecs = new HashMap();

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_OR_ORDER_TYPE_SELECT" ) ) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				int i = 0;
				while ( resultSet.next() ) {
					String drug_class ="";
					drug_class = resultSet.getString( "DRUG_CLASS" );

					if (resultSet.getString( "DRUG_CLASS" ) == null)
						drug_class = "~";
					else
						drug_class = resultSet.getString( "DRUG_CLASS" );

					orderType.put( ""+i, resultSet.getString( "ORDER_TYPE_CODE" ) + "," + resultSet.getString( "LONG_DESC" ) + "," + drug_class +  "," + resultSet.getString( "AVAILABLE_DB_YN" ) + "," + "DN");
					duprecs.put( ""+i, resultSet.getString( "ORDER_TYPE_CODE" ) + "," + resultSet.getString( "LONG_DESC" ) + "," + drug_class +  "," + resultSet.getString( "AVAILABLE_DB_YN" ) + "," + "DN");
					i++;
				}
			}

		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) 
			{
			System.out.println("Exception while closing statements and resultsets"+es.toString());
			}
		}
		return orderType;
	}

	public void setHashData(String paramstring) {
		StringTokenizer st = new StringTokenizer(paramstring, ",");

		while (st.hasMoreTokens()) {
			orderType.put(st.nextToken(), st.nextToken() + "," + st.nextToken() + "," + st.nextToken() + "," + st.nextToken() + "," + st.nextToken());
		}
	}

	public HashMap getHashData() {
		return orderType;
	}

	public HashMap getOriginalData(int from, int numrecs) {
		for (int i=from; i < from+numrecs; i++) {
			if ( i < orderType.size() )
				orderType.put(i+"", duprecs.get(i+"")) ;
			else break;
		}
		return orderType;
	}

	/* Function specific methods end */
}
