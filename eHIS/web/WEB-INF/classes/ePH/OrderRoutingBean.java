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
	Function	 :
	Class Name	 :
	Created By	 :
	Created Date :
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :

*/

package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import javax.rmi.* ;
import ePH.OrderRouting.*;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;



public class OrderRoutingBean extends PhAdapter implements Serializable {

    protected Hashtable hashMultiple;
	protected String debug="";

	protected String ordering_facility_id = "";
	protected String ordering_source_type = "";
	protected String ordering_source_code = "";
	protected String routing_level = "";
	protected String routing_code = "";
	protected String performing_facility_id = "";
	protected String rtn_ord_disp_locn_code = "";
	protected String stat_ord_disp_locn_code = "";
	protected String disch_ord_disp_locn_code = "";
	protected String disp_locn_for_admixtures = "N";

	public OrderRoutingBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
		e.printStackTrace() ;
		}
	}
	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
	}

	public String getDebug(){
		return this.debug;
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
	public void setDispLocnForAdmixtures(String disp_locn_for_admixtures){
		this.disp_locn_for_admixtures = disp_locn_for_admixtures;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSetMultiple)
	{
		
		if(recordSetMultiple.containsKey("mode"))
			setMode((String)recordSetMultiple.get("mode")) ;

		if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ){
			hashMultiple = recordSetMultiple ;
		}else {
			if(recordSetMultiple.containsKey("ordering_facility_id"))
				ordering_facility_id = (String)recordSetMultiple.get("ordering_facility_id");
			if(recordSetMultiple.containsKey("ordering_source_type")){
				ordering_source_type = (String)recordSetMultiple.get("ordering_source_type");
				
				}
			if(recordSetMultiple.containsKey("ordering_source_code")){
				ordering_source_code = (String)recordSetMultiple.get("ordering_source_code");
				
				}
			if(recordSetMultiple.containsKey("routing_level"))
				routing_level = (String)recordSetMultiple.get("routing_level");
			if(recordSetMultiple.containsKey("routing_code"))
				routing_code = (String)recordSetMultiple.get("routing_code");
			if(recordSetMultiple.containsKey("performing_facility_id"))
				performing_facility_id = (String)recordSetMultiple.get("performing_facility_id");
			if(recordSetMultiple.containsKey("rtn_ord_disp_locn_code"))
				rtn_ord_disp_locn_code = (String)recordSetMultiple.get("rtn_ord_disp_locn_code");
			if(recordSetMultiple.containsKey("stat_ord_disp_locn_code"))
				stat_ord_disp_locn_code = (String)recordSetMultiple.get("stat_ord_disp_locn_code");
			if(recordSetMultiple.containsKey("disch_ord_disp_locn_code"))
				disch_ord_disp_locn_code = (String)recordSetMultiple.get("disch_ord_disp_locn_code");
			

		}
	}

	// insert Method  starts here...
	public HashMap insert() {

		Connection connection = null ;
		PreparedStatement pstmt = null,pstmt1 = null ;
		ResultSet resultSet = null ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList arrListData = new ArrayList();
		ArrayList insertRowCommonData = new ArrayList() ;

		//OrderRoutingHome   home=null;
		//OrderRoutingRemote remote=null;
		try{
			connection = getConnection() ;
			pstmt	 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT11") ) ;
			pstmt1	 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT12") ) ;
			String ordering_facility_id = ((String)hashMultiple.get("ordering_facility_id"));
			String ordering_source_code	= ((String)hashMultiple.get("ordering_source_code"));
			String ordering_source_type = ((String)hashMultiple.get("ordering_source_type"));
			if (ordering_source_type.equals("E"))
			{ 
				ordering_source_type ="C"; 
				
			}
			if (ordering_source_type.equals("D"))
			{ ordering_source_type ="N"; }
			insertRowCommonData.add(ordering_facility_id);
			insertRowCommonData.add(ordering_source_type);
			insertRowCommonData.add(ordering_source_code);


			int noOfRows = Integer.parseInt((String)hashMultiple.get("number_of_rows"));

			for(int i=0; i<noOfRows;i++){
				ArrayList insertRowMultipleData = new ArrayList();
				if (((String)hashMultiple.get("select"+i)).equals("Y")){

					String routingLevel = ((String)hashMultiple.get("routing_level"+i));
					String routing_code = "",rtn_ord_disp_locn_code="",stat_ord_disp_locn_code="",disch_ord_disp_locn_code="";
					if (hashMultiple.get("routing_code"+i) !=null){
						routing_code = ((String)hashMultiple.get("routing_code"+i));
					}
					if (hashMultiple.get("rtn_ord_disp_locn_code"+i) !=null){
						rtn_ord_disp_locn_code = ((String)hashMultiple.get("rtn_ord_disp_locn_code"+i));
					}
					if (hashMultiple.get("stat_ord_disp_locn_code"+i) !=null){
						stat_ord_disp_locn_code = ((String)hashMultiple.get("stat_ord_disp_locn_code"+i));
					}
					if (hashMultiple.get("disch_ord_disp_locn_code"+i) !=null){
						disch_ord_disp_locn_code = ((String)hashMultiple.get("disch_ord_disp_locn_code"+i));
					}else{
						disch_ord_disp_locn_code = "";
					}
					
					if (!routingLevel.equals("O")){
						insertRowMultipleData.add(routingLevel);
						insertRowMultipleData.add(routing_code);
						insertRowMultipleData.add(((String)hashMultiple.get("performing_facility_id"+i)));
						insertRowMultipleData.add(rtn_ord_disp_locn_code);
						insertRowMultipleData.add(stat_ord_disp_locn_code);
						insertRowMultipleData.add(disch_ord_disp_locn_code);

					}else{
						insertRowMultipleData.add(routingLevel);
						StringTokenizer st1 = new StringTokenizer(routing_code,":");
						routing_code = st1.nextToken();
						insertRowMultipleData.add(routing_code);

						insertRowMultipleData.add(((String)hashMultiple.get("performing_facility_id"+i)));

						StringTokenizer st2 = new StringTokenizer(rtn_ord_disp_locn_code,":");
						while (st2.hasMoreTokens()){
							rtn_ord_disp_locn_code = st2.nextToken();
						}
						insertRowMultipleData.add(rtn_ord_disp_locn_code);

						StringTokenizer st3 = new StringTokenizer(stat_ord_disp_locn_code,":");
						while (st3.hasMoreTokens()){
							stat_ord_disp_locn_code = st3.nextToken();
						}
						insertRowMultipleData.add(stat_ord_disp_locn_code);

						StringTokenizer st4 = new StringTokenizer(disch_ord_disp_locn_code,":");
						while (st4.hasMoreTokens()){
							disch_ord_disp_locn_code = st4.nextToken();
						}
						insertRowMultipleData.add(disch_ord_disp_locn_code);
                   
					}
					arrListData.add(insertRowMultipleData);
// duplicate check
//					Connection connection = null ;
//					PreparedStatement pstmt = null ;
//					ResultSet resultSet = null ;
//					connection = getConnection() ;
					if (routingLevel.equals("S")){
						try {

							//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT11") ) ;
							pstmt.setString(1,ordering_facility_id.trim());
							pstmt.setString(2,ordering_source_type.trim());
							pstmt.setString(3,ordering_source_code.trim());
							resultSet = pstmt.executeQuery() ;
							if ( resultSet != null ) {
								if ( resultSet.next() ) {
									if (resultSet.getInt("count")>0){
										map.put( "result", new Boolean( false ) ) ;
										map.put( "message", getMessage(getLanguageId(),"CODE_ALREADY_EXISTS","Common") ) ;
										map.put("flag","0");
										return map;
									}
								}
							}closeResultSet(resultSet);
						}
						catch(Exception e){
							e.printStackTrace() ;
						}
					}else if (!routingLevel.equals("S")){
						try {
							//connection = getConnection() ;
							//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT12") ) ;
							pstmt1.setString(1,ordering_facility_id.trim());
							pstmt1.setString(2,ordering_source_type.trim());
							pstmt1.setString(3,ordering_source_code.trim());
							pstmt1.setString(4,routingLevel.trim());
							pstmt1.setString(5,routing_code.trim());
							resultSet = pstmt1.executeQuery() ;
							if ( resultSet != null ) {
								if ( resultSet.next() ) {
									if (resultSet.getInt("count")>0){
										map.put( "result", new Boolean( false ) ) ;
										map.put( "message", getMessage(getLanguageId(),"CODE_ALREADY_EXISTS","Common") ) ;
										map.put("flag","0");
										return map;
									}
								}
							}closeResultSet(resultSet);
						}
						catch(Exception e){
							e.printStackTrace() ;
						}
					}
				}
			}

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "CommonData",insertRowCommonData);
			tabData.put( "MultipleData",arrListData);

			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_ORDER_ROUTING_INSERT",PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_INSERT"));
			sqlMap.put("SQL_PH_ORDER_ROUTING_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_DTL_INSERT"));

			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_ORDER_ROUTING") ) ;
			home  = (OrderRoutingHome) PortableRemoteObject.narrow( object, OrderRoutingHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.insert( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_ORDER_ROUTING" ),OrderRoutingHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			try{
		//		closeResultSet(resultSet);
			closeStatement(pstmt);
			closeStatement(pstmt1);
			closeConnection(connection);
			}
			catch(Exception ex){ex.printStackTrace();}
			map.put("flag","0");
		}//finally
		return map ;
	}//insert ends

	public HashMap modify() {
//		StringBuffer debug =new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		//OrderRoutingHome   home=null;
		//OrderRoutingRemote remote=null;
		try{
			ArrayList modifyData = new ArrayList() ;

			modifyData.add( performing_facility_id.trim()) ;
			modifyData.add( rtn_ord_disp_locn_code.trim()) ;
			modifyData.add( stat_ord_disp_locn_code.trim()) ;
			modifyData.add( disch_ord_disp_locn_code.trim()) ;
			modifyData.add( ordering_facility_id.trim()) ;
			modifyData.add( ordering_source_type.trim()) ;
			modifyData.add( ordering_source_code.trim()) ;
			modifyData.add( routing_level.trim()) ;
			modifyData.add( routing_code.trim()) ;

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_DTL_UPDATE") );

	 		HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);
			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_ORDER_ROUTING") ) ;
			home  = (OrderRoutingHome) PortableRemoteObject.narrow( object, OrderRoutingHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_ORDER_ROUTING" ),OrderRoutingHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;

				map.put("flag",(String)result.get("flag"));
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag",(String)result.get("flag"));
			}
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			map.put("flag","0");
			}//finally
		return map ;

	}

	public HashMap delete() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		//OrderRoutingHome   home=null;
		//OrderRoutingRemote remote=null;
		try{
			ArrayList deleteData = new ArrayList() ;
			HashMap sqlMap = new HashMap() ;
			if (routing_level.equals("S")){
				deleteData.add( ordering_facility_id.trim() ) ;
				deleteData.add( ordering_source_type.trim() ) ;
				deleteData.add( ordering_source_code.trim() ) ;
				sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_DELETE") );
			}else{

				deleteData.add( ordering_facility_id.trim()) ;
				deleteData.add( ordering_source_type.trim()) ;
				deleteData.add( ordering_source_code.trim()) ;
				deleteData.add( routing_level.trim()) ;
				deleteData.add( routing_code.trim()) ;


				sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_DTL_DELETE") );
			}

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "DeleteData",deleteData);


			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_ORDER_ROUTING") ) ;
			home  = (OrderRoutingHome) PortableRemoteObject.narrow( object, OrderRoutingHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.delete( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_ORDER_ROUTING" ),OrderRoutingHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag",(String)result.get("flag"));
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag",(String)result.get("flag"));
			}


		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug);
			e.printStackTrace() ;
		}//catch
		finally{
				map.put("flag",debug);
				}//finally
		map.put("flag",debug);
		return map ;
	}

	/* Function specific methods start */

	public ArrayList getDataForList()  throws Exception {

		ArrayList all = new ArrayList();
		ArrayList performingFacility = new ArrayList() ;
		String orderingFacility = "";
		ArrayList routingCode = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String IPInstalled = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT1") ) ;
			pstmt.setString(1,getLanguageId()); //  added according to the LanguageId in query
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					performingFacility.add( resultSet.getString( "FACILITY_ID" ) ) ;
					performingFacility.add( resultSet.getString( "FACILITY_NAME" ) );
				}
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT10") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			//System.err.println("login_facility_id.trim()=====496 in bean=====>" +login_facility_id.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					orderingFacility = resultSet.getString( "FACILITY_NAME" ) ;
				}
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT4") ) ;
		//	pstmt = connection.prepareStatement( "SELECT A.ORDER_TYPE_CODE, B.SHORT_DESC, A.DRUG_CLASS FROM PH_ORDER_TYPE_FOR_DRUG_CLASS A,OR_ORDER_TYPE_LANG_VW B WHERE A.ORDER_TYPE_CODE=B.ORDER_TYPE_CODE AND B.EFF_STATUS='E' AND B.LANGUAGE_ID =? UNION ALL SELECT ORDER_TYPE_CODE, SHORT_DESC, null drug_class FROM OR_ORDER_TYPE_LANG_VW WHERE ORDER_CATEGORY = 'PH' AND LANGUAGE_ID = ? ORDER BY 2" ) ;

/*--Changed query for IN16677 SRR20056-SCF-3877 returning duplicate values --*/
			//pstmt = connection.prepareStatement( "SELECT   a.order_type_code, b.short_desc, a.drug_class FROM ph_order_type_for_drug_class a, or_order_type_lang_vw b WHERE a.order_type_code = b.order_type_code AND b.eff_status = 'E' AND b.language_id = ? UNION ALL SELECT   order_type_code, short_desc, NULL drug_class FROM or_order_type_lang_vw WHERE order_category = 'PH' AND language_id = ? AND order_type_code NOT IN (SELECT a.order_type_code FROM ph_order_type_for_drug_class a, or_order_type_lang_vw b WHERE a.order_type_code = b.order_type_code AND b.eff_status = 'E' AND b.language_id = ?) ORDER BY 2 " ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_SELECT13") ) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					routingCode.add( resultSet.getString( "ORDER_TYPE_CODE" ) ) ;
					routingCode.add( resultSet.getString( "DRUG_CLASS" ) );
					routingCode.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT6") ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					if (resultSet.getInt(1)>0){
						IPInstalled = "Y";
					}
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		//System.err.println("performingFacility---->"+performingFacility);
		//System.err.println("orderingFacility---->"+orderingFacility);
		//System.err.println("routingCode---->"+routingCode);
		//System.err.println("IPInstalled---->"+IPInstalled);
		

		all.add(performingFacility);
		all.add(orderingFacility);
		all.add(routingCode);
		all.add(IPInstalled);
		//System.err.println("all---->"+all);
		return all;
	}
  /*
	public ArrayList loadRelatedLocation(String facility_id,String ordering_source_type) throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arrList=new ArrayList();
		try {

			connection = getConnection() ;
			if (ordering_source_type.equals("N")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT2")) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
				
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("NURSING_UNIT_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			}else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT3")) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());

				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("CLINIC_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		return arrList;
	}*/

	public ArrayList loadRelatedLocation(String facility_id,String ordering_source_type) throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arrList=new ArrayList();
		//System.err.println("ordering_source_type---->"+ordering_source_type);
		try {

			connection = getConnection() ;
			if (ordering_source_type.equals("N")){
			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT2")) ;
			    pstmt = connection.prepareStatement("SELECT NURSING_UNIT_CODE,LONG_DESC SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE EFF_STATUS='E' AND FACILITY_ID = ? AND PATIENT_CLASS = 'IP' AND LANGUAGE_ID = ? ORDER BY 2") ;
													 
			   	pstmt.setString(1,facility_id.trim());
			    pstmt.setString(2,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("NURSING_UNIT_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			}
			else
            if (ordering_source_type.equals("D")){
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTE_SELECT4")) ;
				pstmt = connection.prepareStatement("SELECT NURSING_UNIT_CODE,SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE EFF_STATUS='E' AND FACILITY_ID = ? AND LANGUAGE_ID= ? AND PATIENT_CLASS = 'DC' ORDER BY 2 ") ;
				pstmt.setString(1,facility_id.trim());
    		    pstmt.setString(2,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("NURSING_UNIT_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			}
			else
            if (ordering_source_type.equals("E")){
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTE_SELECT2")) ;
				pstmt = connection.prepareStatement("SELECT CLINIC_CODE , SHORT_DESC FROM OP_CLINIC_LANG_VW WHERE FACILITY_ID like ? AND LANGUAGE_ID  =? AND EFF_STATUS='E' and CLINIC_TYPE IN (SELECT LOCN_TYPE FROM AM_CARE_LOCN_TYPE WHERE CARE_LOCN_TYPE_IND = 'E')  ORDER BY 2  ") ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());

				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("CLINIC_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			} 
			else
            if (ordering_source_type.equals("C"))
				{
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTE_SELECT1")) ;
				pstmt = connection.prepareStatement("SELECT CLINIC_CODE , LONG_DESC SHORT_DESC FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE FACILITY_ID like ? AND EFF_STATUS='E' AND CLINIC_TYPE IN (SELECT LOCN_TYPE FROM AM_CARE_LOCN_TYPE WHERE CARE_LOCN_TYPE_IND = 'C') AND LANGUAGE_ID = ? ORDER BY 2") ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ) {
					while ( resultSet.next() ) {
						arrList.add(resultSet.getString("CLINIC_CODE"));
						arrList.add(resultSet.getString("SHORT_DESC"));
					}
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		return arrList;
	}


	public ArrayList getDataForDefaultDispenseLocation(String facility_id,String disp_locn_type, String routing_code,String routing_level) throws Exception{

		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause = "";
		try {

			String type = "";
			String strAppend="";
			if (routing_level.equals("O")){
				StringTokenizer st = new StringTokenizer(routing_code,":");
				while(st.hasMoreTokens()){
					type = st.nextToken();
				}
			}else{
				type = routing_code.trim();
			}

			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}

			//Condition added for  IN17548  --- 18-Jan 2010  -- Shyampriya -

			if(disp_locn_type.equals("C") || disp_locn_type.equals("E"))
			{
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			}
			if(disp_locn_type.equals("N") || disp_locn_type.equals("D"))
			{
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','I')";
			}

			connection = getConnection() ;
			if(disp_locn_for_admixtures.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6A")+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
			}else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6") + strAppend+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
				if ( (type.equals("G") || type.equals("N") || type.equals("C")) ){
					pstmt.setString(3,disp_locn_type.trim());
					}
			}

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	// Method added to get data for discharge medication list
	public ArrayList getDataForDefaultDispenseLocationD(String facility_id,String disp_locn_type, String routing_code,String routing_level) throws Exception{

		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause = "";
		try {

			String type = "";
			String strAppend="";
			if (routing_level.equals("O")){
				StringTokenizer st = new StringTokenizer(routing_code,":");
				while(st.hasMoreTokens()){
					type = st.nextToken();
				}
			}else{
				type = routing_code.trim();
			}

			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}

				//added for  IN17548  --- 18-Jan 2010  -- Shyampriya -
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";

			connection = getConnection() ;
			if(disp_locn_for_admixtures.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6A")+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
			}else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6") + strAppend+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
				if ( (type.equals("G") || type.equals("N") || type.equals("C")) ){
					pstmt.setString(3,disp_locn_type.trim());
					}
			}

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	public ArrayList getDefaultDispLocDataForSource(String facility_id,String ordering_source_type)throws Exception{
		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause ="";
		String sql ="";
		try {
			connection = getConnection() ;

			//Condition added for  IN17548  --- 18-Jan 2010  -- Shyampriya -
			if(ordering_source_type.equals("C") || ordering_source_type.equals("E"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			if(ordering_source_type.equals("N") || ordering_source_type.equals("D"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','I')";

			sql = "SELECT A.DISP_LOCN_CODE,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.EFF_STATUS='E' AND A.FACILITY_ID=? AND A.LANGUAGE_ID = ? AND (DISP_LOCN_TYPE='P' OR DISP_LOCN_TYPE='N')"+append_clause;

			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	//This method is for discharge medication orders
	public ArrayList getDefaultDispLocDataForSourceD(String facility_id)throws Exception{
		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause ="";
		String sql ="";
		try {
			connection = getConnection() ;
		
				// added for  IN17548  --- 18-Jan 2010  -- Shyampriya -
					append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			
			sql = "SELECT A.DISP_LOCN_CODE,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.EFF_STATUS='E' AND A.FACILITY_ID=? AND A.LANGUAGE_ID = ? AND (DISP_LOCN_TYPE='P' OR DISP_LOCN_TYPE='N')"+append_clause;
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	public ArrayList getDefaultDispLocDataForDrug(String facility_id,String disp_locn_type,String drug_code) throws Exception{

		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause = "";
		try {
			String type = "";
			String strAppend="";
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT13")) ;
			pstmt.setString(1,drug_code.trim());
			resultSet = pstmt.executeQuery();
			if (resultSet != null && resultSet.next()){
				type = resultSet.getString("DRUG_CLASS");
			}
			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

				//Condition added for  IN17548  --- 18-Jan 2010  -- Shyampriya -
			if(disp_locn_type.equals("C") || disp_locn_type.equals("E"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			if(disp_locn_type.equals("N") || disp_locn_type.equals("D"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','I')";

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6") + strAppend+append_clause) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,getLanguageId());
			if ( (type.equals("G") || type.equals("N") || type.equals("C")) ){
			pstmt.setString(3,disp_locn_type.trim());
			}
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	//This method is for discharge medication orders
	public ArrayList getDefaultDispLocDataForDrugD(String facility_id,String disp_locn_type,String drug_code) throws Exception{

		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause = "";
		try {
			String type = "";
			String strAppend="";
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT13")) ;
			pstmt.setString(1,drug_code.trim());
			resultSet = pstmt.executeQuery();
			if (resultSet != null && resultSet.next()){
				type = resultSet.getString("DRUG_CLASS");
			}
			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

				// added for  IN17548  --- 18-Jan 2010  -- Shyampriya -
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6") + strAppend+append_clause) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,getLanguageId());
			if ( (type.equals("G") || type.equals("N") || type.equals("C")) ){
			pstmt.setString(3,disp_locn_type.trim());
			}
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					arrList.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					arrList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}
		return arrList;
	}

	public ArrayList loadData(String ordering_facility_id,String ordering_source_type,String ordering_source_code,String routing_level,String routing_code)throws Exception{
		ArrayList dataList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {

			connection = getConnection() ;
			if(routing_level.equals("S")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT17")) ;
				pstmt.setString(1,ordering_facility_id.trim());
				pstmt.setString(2,ordering_source_type.trim());
				pstmt.setString(3,ordering_source_code.trim());
			}else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT15")) ;
				pstmt.setString(1,ordering_facility_id.trim());
				pstmt.setString(2,ordering_source_type.trim());
				pstmt.setString(3,ordering_source_code.trim());
				pstmt.setString(4,routing_level.trim());
				pstmt.setString(5,routing_code.trim());
			}
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					dataList.add( resultSet.getString( "PERFORMING_FACILITY_ID" ) ) ;
					dataList.add( resultSet.getString( "RTN_ORD_DISP_LOCN_CODE" ) );
					dataList.add( resultSet.getString( "STAT_ORD_DISP_LOCN_CODE" ) );
					dataList.add( resultSet.getString( "DISCH_ORD_DISP_LOCN_CODE" ) );
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}


		return dataList;
	}
}
