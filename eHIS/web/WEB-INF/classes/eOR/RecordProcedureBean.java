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


//import eOR.ORReportAuthorization.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RecordProcedureBean extends OrAdapter implements java.io.Serializable
{
  //  HttpServletRequest request = null;
  //  HttpServletResponse response = null;


/*	public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response;
	}
*/
//	public String  tempChk	= "";
/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	private ArrayList parameters =  new ArrayList();

	public void setAll(Hashtable hash){

		this.mode		  =	(String)hash.get("mode");
	//	this.request = (HttpServletRequest)hash.get("HttpRequest");
	//	this.response = (HttpServletResponse)hash.get("HttpResponse");

		int total_recs	  = Integer.parseInt(checkForNull((String)hash.get("total_recs"),"-1"));

        parameters =  new ArrayList();

		if(total_recs != 0){ //that means there are some records

			for (int i = 0; i < total_recs ; i++ ){
				String chk			 = checkForNull((String)hash.get("chk"+i),"N");
				if(chk.trim().equalsIgnoreCase("Y")){
					HashMap	param					=	new   HashMap();
					param.put("practitioner_id"		,(String)hash.get("practitioner_id"));
					param.put("practitioner_type"	,(String)hash.get("practitioner_type"));
					param.put("order_id"			,(String)hash.get("order_id"+i));
					param.put("result_type"			,(String)hash.get("result_type"+i));
					param.put("result_status"		,(String)hash.get("result_status"+i));
					param.put("report_srl_no"		,(String)hash.get("report_srl_no"+i));
					param.put("ord_typ_code"		,(String)hash.get("order_type_code"+i));
					System.out.println("ord_typ_code="+((String)param.get("ord_typ_code")));
					param.put("patient_class"		,(String)hash.get("patient_class"+i));
					param.put("priority"			,(String)hash.get("priority"+i));
					param.put("source_type"			,(String)hash.get("source_type"+i));
					param.put("location_code"		,(String)hash.get("source_code"+i));

					parameters.add(param)	;
				}

			}
		}

	}


	public void clear()	{
		 parameters =  new ArrayList();
	}

	public HashMap insert(){

		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		HashMap recordStoreParam = new HashMap() ;

		try{

		recordStoreParam.put("parameters"			, parameters);
		recordStoreParam.put("login_by_id"			, login_by_id) ;
		recordStoreParam.put("login_at_ws_no"		, login_at_ws_no ) ;
		recordStoreParam.put("login_facility_id"	, login_facility_id ) ;


		sqlMap.put("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE"					   ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_HDR_UPDATE"));
		sqlMap.put("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE"					   ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_DTL_UPDATE"));
		sqlMap.put("SQL_OR_REPORT_AUTH_ORD_UPDATE"						   ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORD_UPDATE"));
		sqlMap.put("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE"				   ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_RES_ORD_LINE_UPDATE"));
		sqlMap.put("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A"    ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_A"));
		sqlMap.put("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY"  ,OrRepository.getOrKeyValue("SQL_OR_REPORT_AUTH_ORDER_STATUS_CODE_SELECT_TYPE_ANY"));
		sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG"						,OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );

	//	return getResult(recordStoreParam,sqlMap );
		return getResult();

		}catch(Exception e){
	//		tempChk += e.getMessage();
			logErrorMessage(e);
			return null;
		}

	}

/**********This Method  Actually Calls the EJB's Method ********************/
// private  HashMap getResult(HashMap record , HashMap sqlMap ) {
 private  HashMap getResult() {
	HashMap map  = new HashMap() ;
	/*try
		{

			InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_ORDER_REPORT_AUTH_JNDI"));
			ORReportAuthorizationHome home  = (ORReportAuthorizationHome) PortableRemoteObject.narrow( object,ORReportAuthorizationHome.class );
			ORReportAuthorizationRemote remote = home.create() ;
			//ReportAuthorizationManager	remote = new ReportAuthorizationManager();
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			//map = remote.insert(tabDataParamtabDataParam, sqlMap ) ;
			//	return tabDataParam ;
			map = remote.insert(tabDataParam, sqlMap ) ;
			if(((Boolean)map.get("result")).booleanValue()) {
				ArrayList params		=(ArrayList)record.get("parameters" ) ;
				Hashtable printTab			= new Hashtable();

				for (int i=0 ; i<parameters.size() ; i++ ){
                	HashMap currRec			= (HashMap)params.get(i);
                	printTab.clear();

                	String report_srl_no	= (String)currRec.get("report_srl_no");
                	String order_id			= (String)currRec.get("order_id");
                	String ord_typ_code		= (String)currRec.get("ord_typ_code");
                	System.out.println("currord_typ_code="+((String)currRec.get("ord_typ_code")));
                	String patient_class	= (String)currRec.get("patient_class");
                	String source_type		= (String)currRec.get("source_type");
                	String location_code	= (String)currRec.get("location_code");
                	String priority			= (String)currRec.get("priority");

                	printTab.put("report_srl_no",report_srl_no);
                	printTab.put("order_id",order_id);
                	printTab.put("ord_typ_code",ord_typ_code);
                	printTab.put("patient_class",patient_class);
                	printTab.put("source_type",source_type);
                	printTab.put("location_code",location_code);
                	printTab.put("priority",priority);
                	printTab.put("facility_id",login_facility_id);

                	//onlineprint
                	System.out.println("report_srl_no="+printTab.get("report_srl_no"));
                	System.out.println("order_id="+printTab.get("order_id"));
                	System.out.println("ord_typ_code="+printTab.get("ord_typ_code"));
                	System.out.println("patient_class="+printTab.get("patient_class"));
                	System.out.println("source_type="+printTab.get("source_type"));
                	System.out.println("location_code="+printTab.get("location_code"));
                	System.out.println("priority="+printTab.get("priority"));
                	System.out.println("before OnlinePrinting");
                	OnLinePrinting online_print = new OnLinePrinting(request,response);
                	HashMap tmp_map = (HashMap)online_print.printResultEntryReport(printTab);
                	System.out.println("after OnlinePrinting");
				}
			}
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				return null ;
			}

	  return map;

	 }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}*/
    return map;
 }//End of Method

/***************************************************************************/

	public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}

	public int orderableCount(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int count 					= 0;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RECORD_PROCEDURE_COUNT_ORDERABLES") ) ;
			pstmt.setString(1, order_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				count = resultSet.getInt(1)  ;
			}
		} catch ( Exception e )	{
			System.out.println( "Error loading values from database"+e ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return count;
	}

    public ArrayList  getOrderables(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Orderables		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_RECORD_PROCEDURE_SELECT_ORDERABLES") ) ;
			pstmt.setString (1,order_id.trim());

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] orderable 	= new String[3];
				orderable[0] 		= resultSet.getString("catalog_synonym_dc")  ;  //catalog_synonym_dc
				orderable[1] 		= resultSet.getString("order_catalog_code")  ;  //order_catalog_code
				orderable[2]		= resultSet.getString("order_line_num")  	 ;  //order_line_num
				Orderables.add(orderable);
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}
		return Orderables;
	}
}
