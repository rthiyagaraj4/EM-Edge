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
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.WsTokenSeries.*;

public class WsTokenSeriesBean extends PhAdapter implements Serializable {

	private HashMap initDatas	= null;
	private TreeSet assoDatas	= null;

	public ArrayList tempAssoDatas	=	null;
    protected String defTokenSeries	=	""; //added for [IN:037465]

	String disp_locn			= "";
	String ws_st			= "";
	private ArrayList insertData = new ArrayList() ;
	public WsTokenSeriesBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {		
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		insertData = new ArrayList();
		//tempAssoDatas = new ArrayList();
	}

	public void setDispLocn(String disp_locn) {
		this.disp_locn = disp_locn;
	}

	public void setWSLocn(String ws_st) {
		this.ws_st = ws_st;
	}

	public String getDispLocn() {
		return this.disp_locn;
	}
	public String getWSLocn() {
		return this.ws_st;
	}
	/*=======================================================================*/

	public ArrayList getTempAssoDatas() {
		return this.tempAssoDatas;
	}

	public void setTempAssoDatas(ArrayList tempAssoDatas) {
		this.tempAssoDatas = tempAssoDatas;
	}

	/*=======================================================================*/
     public void setDefaultTokenSeries(String defTokenSeries) { //added for [IN:037465] - start
		this.defTokenSeries = defTokenSeries;
	}
	public String getDefaultTokenSeries() {
		return this.defTokenSeries;
	} //added for [IN:037465] - end

	public void setAll( Hashtable recordSet ){
		int totalrecs	=	0;
		//String associate = "";

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("totalrecs")) {
			totalrecs	=	Integer.parseInt((String)recordSet.get("totalrecs")) ;
		}

		if(recordSet.containsKey("locn_code"))
			setDispLocn((String)recordSet.get("locn_code")) ;//location
		if(recordSet.containsKey("ws_st"))
			setWSLocn((String)recordSet.get("ws_st")) ;   // workstation

		/*	for (int i=0; i<=totalrecs; i+=2 )
		{		
		if(recordSet.containsKey("asso_yn_"+i))
		associate =	((String)recordSet.get("asso_yn_"+i)) ;
		if (associate.equals("Y"))
		{
			if(recordSet.containsKey("TS_CODE_"+i))
			insertData.add((String)recordSet.get("TS_CODE_"+i)) ;
		}
		} */
		insertData=getTempAssoDatas();
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
		//String		code			=	""; //Commented for common-icn-0048
		//String		default_yn		=	"N"; //Commented for common-icn-0048
		//String		default_yn1		=	""; //Commented for common-icn-0048
		//ArrayList	insertRecord	=	null; //Commented for common-icn-0048
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "test" ) ;
		HashMap commonData = new HashMap() ;
		commonData.put( "login_by_id",		login_by_id ) ;
		commonData.put( "login_at_ws_no",	login_at_ws_no ) ;
		commonData.put( "login_facility_id",login_facility_id ) ;
		commonData.put( "locn_code", getDispLocn() ) ;
		commonData.put( "ws_no",	getWSLocn() ) ;
		HashMap tabData = new HashMap() ;
		tabData.put( "COMMONDATA", commonData ) ;
		tabData.put( "PROPERTIES", getProperties() ) ;
		tabData.put( "INSERTDATA", insertData ) ;			
		tabData.put( "DEF_TOKENSERIESCODE", getDefaultTokenSeries() ) ;			

		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "INSERTSQL", PhRepository.getPhKeyValue( "SQL_WS_TS_INSERT" ) ) ;				
			sqlMap.put( "DELETESQL", PhRepository.getPhKeyValue( "SQL_WS_TS_DELETE" ) );
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
		//WsTokenSeriesHome home = null;
		//WsTokenSeriesRemote remote = null;
		try {
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_WS_TS" ) ) ;

			home  = (WsTokenSeriesHome) PortableRemoteObject.narrow( object, WsTokenSeriesHome.class ) ;
			remote = home.create() ;
			map = remote.insert( tabData, sqlMap ) ;   */
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_WS_TS" ),WsTokenSeriesHome.class,getLocalEJB());
			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

			 Class  paramArray[] = new Class[2];
			 paramArray[0]= tabData.getClass();
			 paramArray[1] = sqlMap.getClass();
					
			 map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			 (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() ) {
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			}
			else {
				map.put( "message", map.get("msgid") ) ;
			}
		}
		catch (Exception e) {
			map.put( "message", e.getMessage() ) ;
		}
		return map ;
	}

	public void setHashData(String paramstring) {
		StringTokenizer st = new StringTokenizer(paramstring, "|");

		while (st.hasMoreTokens()) {
			int recnum		= Integer.parseInt(st.nextToken());			
			String ts_code	= st.nextToken();			
			String db_mode	= st.nextToken();

			initDatas.put(new Integer(recnum),  ts_code + "|" + db_mode);

			if (db_mode.equals("D")) {
				assoDatas.remove(new Integer(recnum));
			}
			else if (db_mode.equals("I")) {
				assoDatas.add(new Integer(recnum));
			}
		}
	}

	public HashMap getHashData() {
		return initDatas;
	}

	public TreeSet getAssocData() {
		return assoDatas;
	}

	public ArrayList getDispLocns() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList dispLocns = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_DISP_LOCN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				dispLocns.add(resultSet.getString("DISP_LOCN_CODE"));
				dispLocns.add(resultSet.getString("SHORT_DESC"));
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return dispLocns;
	}

	public ArrayList getTokenSeries() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList tokenSeries = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_TOKEN_SERIES" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, getDispLocn());
			pstmt.setString(3, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				tokenSeries.add(resultSet.getString("TOKEN_SERIES_CODE"));
				tokenSeries.add(resultSet.getString("DESCRIPTION"));
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return tokenSeries;
	}

	public ArrayList getWSLocns(String disp_locn) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList wsLocns = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_WORK_STN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, disp_locn);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				wsLocns.add(resultSet.getString("WS_NO"));
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
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return wsLocns;
	}

	public ArrayList getTokenWs(String disp_locn, String ws_no) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList token_ws = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_TOKEN_WS" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, disp_locn);
			pstmt.setString(3, ws_no);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				token_ws.add(resultSet.getString("TOKEN_SERIES_CODE"));
			}
			// Storing the associated token series from db into temp array list
			setTempAssoDatas(token_ws);
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return token_ws;
	}

	public HashMap getWorkStations(String disp_locn) {
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		initDatas = new HashMap();
		assoDatas = new TreeSet();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_WORK_STN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, disp_locn);
			resultSet = pstmt.executeQuery() ;
			int recnum = 0;
			while (resultSet.next()) {
				//String ws_no	= resultSet.getString("WS_NO");
				String ts_code	= checkNullResult(resultSet.getString("TOKEN_SERIES_CODE"), "~");
				if (ts_code.equals("~")) {
					initDatas.put(new Integer(recnum),  ts_code +"|" + "DN");
				}
				else {
					initDatas.put(new Integer(recnum),  ts_code +"|" + "DN");
					assoDatas.add(new Integer(recnum));
				}
				recnum++;
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return initDatas;
	}

	private String checkNullResult(String inputString, String defaultValue) {
		return (inputString==null) ? defaultValue : inputString;
	}
	/* Function specific methods end */
	//added for [IN:037465] -start
	public void setDefaultTokenSeries(String disp_locn, String ws_no) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String defTokenSeries = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "select TOKEN_SERIES_CODE from PH_WS_FOR_TOKEN_SERIES where facility_id = ?  AND DISP_LOCN_CODE=? AND WS_NO=? and DEFAULT_TOKEN_YN ='Y'") ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, disp_locn);
			pstmt.setString(3, ws_no);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				defTokenSeries=checkNullResult(resultSet.getString("TOKEN_SERIES_CODE"),"");
			}
			// Storing the associated token series from db into temp array list
			setDefaultTokenSeries(defTokenSeries);
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
	}
	//added for [IN:037465] - end
}
