/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 08/11/2005
package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class PresRemarkBean extends PhAdapter implements Serializable {

	protected ArrayList routeOfDrug		= null ;
    protected ArrayList forInsert		= null;

	protected String REMARK_CODE			= "" ;
	protected String REMARK_DESC			= "" ;
	protected String FORM_CODE				= "" ;
	protected String FORM_DESC				= "" ;
	protected String ROUTE_CODE				= "" ;
	protected String ROUTE_DESC				= "" ;
	protected String APPL_SLIDING_SCALE_YN	= "" ;

	public PresRemarkBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {			e.printStackTrace() ;
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

		try {

			if ( getMode().equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || getMode().equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ) {
				if(recordSet.containsKey("REMARK_CODE"))
					setRemarkCode((String)recordSet.get("REMARK_CODE")) ;
				if(recordSet.containsKey("REMARK_DESC"))
					setRemarkDesc((String)recordSet.get("REMARK_DESC")) ;
				if(recordSet.containsKey("FORM_CODEANDDESC"))
					setFormCode((String)recordSet.get("FORM_CODEANDDESC")) ;
				if(recordSet.containsKey("ROUTE_CODEANDDESC"))
					setRouteCode((String)recordSet.get("ROUTE_CODEANDDESC")) ;
				if(recordSet.containsKey("APPL_SLIDING_SCALE_YN"))
					setApplSlidingScaleYN((String)recordSet.get("APPL_SLIDING_SCALE_YN")) ;
			}

			if ( getMode().equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) {
				forInsert = new ArrayList();

				for ( int i=0; i<10; i++ ) {
					String formCodeForCheck = "";
					String slider ="";
					if ( recordSet.containsKey("REMARK_CODE_"+i) ) {
						formCodeForCheck = (String)recordSet.get("REMARK_CODE_"+i);
						if ( !formCodeForCheck.equals("") ) {
							forInsert.add(formCodeForCheck);

							if(recordSet.containsKey("REMARK_DESC_"+i))
								forInsert.add((String)recordSet.get("REMARK_DESC_"+i)) ;

							if (recordSet.containsKey("FORM_CODE_"+i))
								forInsert.add((String)recordSet.get("FORM_CODE_"+i));

							if (recordSet.containsKey("ROUTE_CODE_"+i))
								forInsert.add((String)recordSet.get("ROUTE_CODE_"+i)) ;

							if (recordSet.containsKey("APPL_SLIDING_SCALE_YN_"+i))

								slider = (String)recordSet.get("APPL_SLIDING_SCALE_YN_"+i) ;
								if(slider.equals("") || slider==null ) 
							{
							forInsert.add("N");
							}else
							{
								forInsert.add("Y") ;
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
	}

	/* Set Methods Start */
	public void setRemarkCode( String REMARK_CODE ) {
		this.REMARK_CODE = REMARK_CODE ;
	}
	public void setRemarkDesc( String REMARK_DESC ) {
		this.REMARK_DESC = REMARK_DESC ;
	}
	public void setFormCode( String FORM_CODE ) {
		this.FORM_CODE = FORM_CODE ;
	}
	public void setFormDesc( String FORM_DESC ) {
		this.FORM_DESC = FORM_DESC ;
	}
	public void setRouteCode( String ROUTE_CODE ) {
		this.ROUTE_CODE = ROUTE_CODE ;
	}
	public void setRouteDesc( String ROUTE_DESC ) {
		this.ROUTE_DESC = ROUTE_DESC ;
	}
	public void setApplSlidingScaleYN( String APPL_SLIDING_SCALE_YN ) {
		if(APPL_SLIDING_SCALE_YN.equals("") || APPL_SLIDING_SCALE_YN==null )
			this.APPL_SLIDING_SCALE_YN = "N" ;
		else
			this.APPL_SLIDING_SCALE_YN = APPL_SLIDING_SCALE_YN ;
	}
	/* Set Methods End */

	/* Get Methods Start */
	public String getRemarkCode() {
		return this.REMARK_CODE ;
	}
	public String getRemarkDesc() {
		return this.REMARK_DESC ;
	}
	public String getFormCode() {
		return this.FORM_CODE ;
	}
	public String getFormDesc() {
		return this.FORM_DESC ;
	}
	public String getRouteCode() {
		return this.ROUTE_CODE ;
	}
	public String getRouteDesc() {
		return this.ROUTE_DESC ;
	}
	public String getApplSlidingScaleYN() {
		return this.APPL_SLIDING_SCALE_YN ;
	}
	/* Get Methods End */

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap insert() {
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Insert Failed" ) ;

		ArrayList insertData	= new ArrayList() ;
		ArrayList whereData		= new ArrayList() ;
		ArrayList whereObjects	= null ;
		ArrayList insertObjects	= null ;

		int j=0;
		for(int i=0; i<10;i++) {
			if (j<forInsert.size()) {
				whereObjects = new ArrayList() ;
				whereObjects.add(forInsert.get(j));
				whereData.add(whereObjects);

				insertObjects = new ArrayList() ;
				insertObjects.add(forInsert.get(j));
				insertObjects.add(forInsert.get(j+1));
				insertObjects.add(forInsert.get(j+2));
				insertObjects.add(forInsert.get(j+3));
				insertObjects.add(forInsert.get(j+4));
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertData.add(insertObjects);
				j += 5;
			}
		}

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "WhereData", whereData ) ;
		tabData.put( "InsertData", insertData ) ;

		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_SELECT2" ));
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_INSERT" ));
		}
		catch (Exception e) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}

		return CallSingleTableHandler( tabData,sqlMap );
	}

	public HashMap modify() {
		//System.err.println("modify------------->");
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Update Failed" ) ;

		ArrayList modifyData = new ArrayList() ;
		modifyData.add( REMARK_DESC ) ;
		modifyData.add( FORM_CODE ) ;
		modifyData.add( ROUTE_CODE ) ;
		modifyData.add( APPL_SLIDING_SCALE_YN ) ;
		modifyData.add( login_by_id ) ;
		modifyData.add( login_at_ws_no ) ;
		modifyData.add( login_facility_id ) ;
		modifyData.add( REMARK_CODE ) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData", modifyData);

		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_UPDATE" ));
		}
		catch (Exception e) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
           //System.err.println("CallSingleTableHandler-------------->");
		return CallSingleTableHandler( tabData,sqlMap );
	}

	public HashMap delete() {
		

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Delete Failed" ) ;

		ArrayList deleteData = new ArrayList() ;
		deleteData.add( REMARK_CODE ) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteData", deleteData);

		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_DELETE" ));
		}
		catch (Exception e) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
            // System.err.println("CallSingleTableHandler----------->");
		return CallSingleTableHandler( tabData,sqlMap );
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	private  HashMap CallSingleTableHandler( HashMap tabData , HashMap sqlMap ) {
		//System.err.println("CallSingleTableHandler");
		//System.err.println("tabData--------->"+tabData);
		//System.err.println("sqlMap--------->"+sqlMap);
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
		try {
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ) ) ;
			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
				map = remote.singleBatchHandler( tabData, sqlMap ) ;

			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
				map = remote.modify( tabData, sqlMap ) ;

			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" ) ) )
				map = remote.delete( tabData, sqlMap ) ;*/


		Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
		//System.err.println("home----------->"+home);
		Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);
		//System.err.println("busObj----------->"+busObj);

		Object argArray[]=new Object[2];
		argArray[0]=tabData;
		argArray[1]=sqlMap;

       // System.err.println("argArray---------->"+argArray);

		Class[] paramArray=new Class[2];
		paramArray[0]=tabData.getClass();
		paramArray[1]=sqlMap.getClass();
		//System.err.println("argArray---------->"+argArray);



				if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  ){
				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) ){
				//System.err.println("<----------------MODE_MODIFY-------------------->");
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" ) ) ){
				map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
				
			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
			else {
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ) {
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else
					map.put( "message", (getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"))) ;

			}
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB classcast : "+e ) ;
			map.put( "message", e.getMessage()+"classcast") ;
			e.printStackTrace() ;
		}
		return map;
	}

	public ArrayList getFormOfDrug() {
		ArrayList formOfDrug = new ArrayList() ;
		routeOfDrug = new ArrayList() ;

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_FORM" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					formOfDrug.add( resultSet.getString( "FORM_CODE" ) ) ;
					formOfDrug.add( resultSet.getString( "FORM_DESC" ) );
				}
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_ROUTE_FORM" )) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					routeOfDrug.add( resultSet.getString( "FORM_CODE" ) );
					routeOfDrug.add( resultSet.getString( "ROUTE_CODE" ) );
					routeOfDrug.add( resultSet.getString( "ROUTE_DESC" ) );
					routeOfDrug.add( resultSet.getString( "ROUTE_COLOR" ) );
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return formOfDrug;
	}

	public ArrayList getRouteOfDrug(String FORM_CODE) {
		ArrayList drugRoute = new ArrayList();
		for ( int i=0; i < routeOfDrug.size(); i+=4 ) {
			if (routeOfDrug.get(i).equals(FORM_CODE)) {
				drugRoute.add(routeOfDrug.get(i+1));
				drugRoute.add(routeOfDrug.get(i+2));
				drugRoute.add(routeOfDrug.get(i+3));
			}
		}
		return drugRoute;
	}

	public String checkSliding(String remark_code) throws Exception{

		String result = "Y";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_SELECT5")) ;
			pstmt.setString(1,remark_code.trim());
			resultSet = pstmt.executeQuery();
			if ( resultSet.next() ) {
				
					result = resultSet.getString( "APPL_SLIDING_SCALE_YN" );
				}
			
		}catch ( Exception e ) {
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
			catch(Exception es) {			es.printStackTrace() ;
 }
		}
		return result;
	}
	/* Function specific methods end */
}
