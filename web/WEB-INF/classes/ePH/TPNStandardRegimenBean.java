
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;     

import oracle.sql.*;
import java.io.*;
//import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import eOR.* ;
import ePH.Common.* ;
import eCommon.Common.* ;   
//import ePH.TPNConsLimits.*;
//saved on 22/10/2005
public class TPNStandardRegimenBean extends PhAdapter implements Serializable, eOR.SceduleFreqeuncyInterface  {

	private HashMap scheduleFrequency	= new HashMap();
	private String presRemarks			="";

	String order_id						="";
	HashMap regimenRemarks				=new HashMap();
	private HashMap   schdMap		= new HashMap();


	private String	 buildMAR_yn			= "";
	public void setBuildMAR_yn(String buildMAR_yn){
		this.buildMAR_yn = buildMAR_yn;
	}
	public String getBuildMAR_yn(){
		return buildMAR_yn;
	}

	private Hashtable recordSet			= new Hashtable();
	private String	 StockUOM			= "";
	private String	 order_type            = "";//Added for Bru-HIMS-CRF-393_1.0
	public TPNStandardRegimenBean(){
		//Constructor
		try{
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */

	private void doCommon() throws Exception
	{
	}

	public void clear()
	{
		super.clear() ;
		scheduleFrequency	= new HashMap();
		regimenRemarks		=new HashMap();
		presRemarks			="";
		order_id = "";
		buildMAR_yn = "";
		schdMap		= new HashMap();
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */

	public void setRegimenRemarks(HashMap tmp)
	{
		this.regimenRemarks=tmp;
	}
	public HashMap getRegimenRemarks()
	{
		return this.regimenRemarks;
	}

	public void setPresRemarks(String remarks)
	{
		this.presRemarks=remarks;
	}
	public String getPresRemarks()
	{
		return this.presRemarks;
	}

	public String getLoggedInFacility()
	{
		return login_facility_id;
	}
	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;	
	}

	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}
	public void setOrderType(String order_type){//Added for Bru-HIMS-CRF-393_1.0 -start
		this.order_type=order_type;
	}
	public String getOrder_Type(){
		return this.order_type;
	} //Added for Bru-HIMS-CRF-393_1.0 -end
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public ArrayList  getFrequencies(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT1" )) ;
			pstmt.setString(1, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("FREQ_CODE"));
				result.add(resultSet.getString("FREQ_DESC"));
				result.add(resultSet.getString("SCHEDULED_YN")==null?"N":resultSet.getString("SCHEDULED_YN"));
				result.add(resultSet.getString("FREQ_NATURE"));

			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null) 	closeStatement( pstmt ) ;

		}
		catch ( Exception e ) {

			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
				resultSet=null;
				pstmt=null;
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
		return result;
	}

	public String getTradeCode(String regcode)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT12" )) ;
			pstmt.setString(1,regcode);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result=resultSet.getString("TRADE_ID");
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
				es.printStackTrace();
			}
		}
		return result;
	}

	public String getEndDate(String sdate,String duration)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";

		try {
			connection = getConnection() ;
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT9" )) ;
			pstmt.setString(1,sdate);
			pstmt.setString(2,duration);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result=resultSet.getString("ENDDATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result=e.toString();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
					es.printStackTrace();
			}
		}
		return result;	   
	}

	public ArrayList  getTPNGenerics(String groupCode)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//this query retrieves generic ids and limits set for the age group
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT18" )) ;
			pstmt.setString(1,groupCode);
			pstmt.setString(2,groupCode);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("CONST_GENERIC_CODE")==null?"":resultSet.getString("CONST_GENERIC_CODE"));
				result.add(resultSet.getString("CONST_GENERIC_NAME")==null?"":resultSet.getString("CONST_GENERIC_NAME"));
				result.add(resultSet.getString("CONST_QTY_UNIT")==null?"":resultSet.getString("CONST_QTY_UNIT"));
			}
		}
		catch ( Exception e ) {

			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   System.err.println("Error::"+es);

			}
		}
		return result; 
	}

	public HashMap  getOrderDetails(String orderid)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null,pstmt1=null ;
		ResultSet resultSet = null ,resultSet1=null;
		HashMap result=new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT20" )) ;
			pstmt.setString(1,orderid);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {

				String isscheduled=resultSet.getString("ISSCHEDULED")==null?"":resultSet.getString("ISSCHEDULED");
				result.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE")==null?"":resultSet.getString("ORDER_CATALOG_CODE"));
				result.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME")==null?"":resultSet.getString("START_DATE_TIME"));
				result.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME")==null?"":resultSet.getString("END_DATE_TIME"));
				result.put("FREQ_CODE",resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
				result.put("FREQ_NATURE",resultSet.getString("FREQ_NATURE")==null?"":resultSet.getString("FREQ_NATURE"));
				result.put("DURN_VALUE",resultSet.getString("DURN_VALUE")==null?"":resultSet.getString("DURN_VALUE"));
				result.put("DURN_TYPE",resultSet.getString("DURN_TYPE")==null?"":resultSet.getString("DURN_TYPE"));
				result.put("INFUSE_OVER",resultSet.getString("INFUSE_OVER")==null?"":resultSet.getString("INFUSE_OVER"));
				result.put("INFUSE_OVER_UNIT",resultSet.getString("INFUSE_OVER_UNIT")==null?"":resultSet.getString("INFUSE_OVER_UNIT"));
				result.put("ISSCHEDULED",isscheduled);
				result.put("LONG_NAME",resultSet.getString("LONG_NAME")==null?"":resultSet.getString("LONG_NAME"));
				result.put("TOTAL_VOLUME",resultSet.getString("TOTAL_VOLUME")==null?"":resultSet.getString("TOTAL_VOLUME"));
				result.put("PRES_BASE_UNIT",resultSet.getString("PRES_BASE_UNIT")==null?"":resultSet.getString("PRES_BASE_UNIT"));
				result.put("TPN_ADMIN_ROUTE",resultSet.getString("TPN_ADMIN_ROUTE")==null?"":resultSet.getString("TPN_ADMIN_ROUTE"));	
				result.put("BUILD_MAR_YN",resultSet.getString("BUILD_MAR_YN")==null?"":resultSet.getString("BUILD_MAR_YN"));	
				//Added for amend ML-MMOH-CRF-1012 start
				result.put("TOTAL_DAILY_FLUID",resultSet.getString("TOTAL_DAILY_FLUID")==null?"":resultSet.getString("TOTAL_DAILY_FLUID"));	
				result.put("ENTERAL_FEEDING",resultSet.getString("ENTERAL_FEEDING")==null?"":resultSet.getString("ENTERAL_FEEDING"));
				//Added for amend ML-MMOH-CRF-1012 end
			
				if (!isscheduled.equals("0"))
				{
					//get scheduled time and put it in an array list and send it back
					ArrayList schtime=new ArrayList();
					pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT23" )) ;
					pstmt1.setString(1,orderid);
					resultSet1 = pstmt1.executeQuery() ;
					while (resultSet1.next())
					{
						schtime.add(resultSet1.getString("ORDER_LINE_FIELD_VALUE"));
						schtime.add(resultSet1.getString("DOSE"));
					} 
				//if(resultSet1!=null) closeResultSet( resultSet1 ) ;
				//if(pstmt1!=null) closeStatement( pstmt1 ) ;

				result.put("SCH_TIME",schtime);					
				}
			}
		}
		catch ( Exception e ) {

			e.printStackTrace() ;
			result.put("ERROR",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   System.err.println("Error::"+es);
			}
		}
		return result;	
	} 

	public ArrayList getRegimenDetails(String regcode,String orderdate)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		boolean tpn_tab_reg = false;//ML-MMOH-CRF-1290

		try {
			connection = getConnection() ;
			tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
			//this query retrieveds age groups
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT7" )) ;
			pstmt.setString(1,regcode);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.add(resultSet.getString("DFLT_TPN_ROUTE")==null?"":resultSet.getString("DFLT_TPN_ROUTE"));
				result.add(resultSet.getString("TOTAL_VOLUME")==null?"":resultSet.getString("TOTAL_VOLUME"));
				result.add(resultSet.getString("PRES_BASE_UNIT")==null?"":resultSet.getString("PRES_BASE_UNIT"));
				result.add(resultSet.getString("INFUSE_OVER_VALUE")==null?"":resultSet.getString("INFUSE_OVER_VALUE"));
				result.add(resultSet.getString("INFUSE_OVERDURN_TYPE")==null?"":resultSet.getString("INFUSE_OVERDURN_TYPE"));
			}
			if(resultSet!=null)	closeResultSet( resultSet ) ;
			if(pstmt!=null) 	closeStatement( pstmt ) ;
			System.out.println("365 tpn_tab_reg"+tpn_tab_reg);
			if(tpn_tab_reg==true){//if condtion added for ml-mmoh-crf-1290.1
				pstmt = connection.prepareStatement( "SELECT  ORD_AUTH_REQD_YN, ORD_COSIGN_REQD_YN,  ORD_SPL_APPR_REQD_YN,   FREQ_CODE,  DURN_VALUE,  CHK_FOR_MAX_DURN_ACTION,   PROMPT_MSG,   MAX_DURN_VALUE,   CONSENT_REQD_YN ,TO_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')+NVL(durn_value,0),'DD/MM/YYYY HH24:MI') ENDDATE FROM    OR_ORDER_CATALOG_BY_PTCL A,OR_ORDER_CATALOG B WHERE   A.ORDER_CATALOG_CODE=B.ORDER_CATALOG_CODE AND A.ORDER_CATALOG_CODE=? and a.PATIENT_CLASS='IP' and SETTING_APPLICABILITY='A'") ;
				pstmt.setString(1,orderdate);
				pstmt.setString(2,regcode);
				resultSet = pstmt.executeQuery() ;
			
				if (resultSet.next()) {
					result.add(resultSet.getString("ORD_AUTH_REQD_YN")==null?"N":resultSet.getString("ORD_AUTH_REQD_YN"));
					result.add(resultSet.getString("ORD_COSIGN_REQD_YN")==null?"N":resultSet.getString("ORD_COSIGN_REQD_YN"));
					result.add(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null?"N":resultSet.getString("ORD_SPL_APPR_REQD_YN"));
					result.add(resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
					result.add(resultSet.getString("DURN_VALUE")==null?"0":resultSet.getString("DURN_VALUE"));
					result.add(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"R":resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
					result.add(resultSet.getString("PROMPT_MSG")==null?"":resultSet.getString("PROMPT_MSG"));
					result.add(resultSet.getString("MAX_DURN_VALUE")==null?"":resultSet.getString("MAX_DURN_VALUE"));
					result.add(resultSet.getString("CONSENT_REQD_YN"));
					result.add(resultSet.getString("ENDDATE")==null?"":resultSet.getString("ENDDATE"));
				}
				
				else{
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT8" )) ;
					
					
					pstmt.setString(1,orderdate);
					pstmt.setString(2,regcode);
					resultSet = pstmt.executeQuery() ;
					if (resultSet.next()) {
						result.add(resultSet.getString("ORD_AUTH_REQD_YN")==null?"N":resultSet.getString("ORD_AUTH_REQD_YN"));
						result.add(resultSet.getString("ORD_COSIGN_REQD_YN")==null?"N":resultSet.getString("ORD_COSIGN_REQD_YN"));
						result.add(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null?"N":resultSet.getString("ORD_SPL_APPR_REQD_YN"));
						result.add(resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
						result.add(resultSet.getString("DURN_VALUE")==null?"0":resultSet.getString("DURN_VALUE"));
						result.add(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"R":resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
						result.add(resultSet.getString("PROMPT_MSG")==null?"":resultSet.getString("PROMPT_MSG"));
						result.add(resultSet.getString("MAX_DURN_VALUE")==null?"":resultSet.getString("MAX_DURN_VALUE"));
						result.add(resultSet.getString("CONSENT_REQD_YN"));
						result.add(resultSet.getString("ENDDATE")==null?"":resultSet.getString("ENDDATE"));
					}
				}
			}
			else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT8" )) ;
			pstmt.setString(1,orderdate);
			pstmt.setString(2,regcode);
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.add(resultSet.getString("ORD_AUTH_REQD_YN")==null?"N":resultSet.getString("ORD_AUTH_REQD_YN"));
				result.add(resultSet.getString("ORD_COSIGN_REQD_YN")==null?"N":resultSet.getString("ORD_COSIGN_REQD_YN"));
				result.add(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null?"N":resultSet.getString("ORD_SPL_APPR_REQD_YN"));
				result.add(resultSet.getString("FREQ_CODE")==null?"":resultSet.getString("FREQ_CODE"));
				result.add(resultSet.getString("DURN_VALUE")==null?"0":resultSet.getString("DURN_VALUE"));
				result.add(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null?"R":resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
				result.add(resultSet.getString("PROMPT_MSG")==null?"":resultSet.getString("PROMPT_MSG"));
				result.add(resultSet.getString("MAX_DURN_VALUE")==null?"":resultSet.getString("MAX_DURN_VALUE"));
				result.add(resultSet.getString("CONSENT_REQD_YN"));
				result.add(resultSet.getString("ENDDATE")==null?"":resultSet.getString("ENDDATE"));
			}
			}
		}
		catch ( Exception e ) {

			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println("Error @ getdetails::"+es);
			}
		}
		return result;	 
	}

	public String getFormatId(String order_category,String order_type_code,String order_catalog_code) 
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String format_id		=	"";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT16"));
			pstmt.setString(1, order_category);
			pstmt.setString(2, order_type_code);
			pstmt.setString(3, order_catalog_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				format_id	=	resultSet.getString("FORMAT_ID");
			}
		}
		catch(Exception e) {
			format_id = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error@ get ID ::"+es);}
		}
		return format_id;
	}

	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed
		recordSet is nothing but a hashtable containing all form values

		*/

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
	    if(recordSet.containsKey("remarksDtls"))
			setPresRemarks((String)recordSet.get("remarksDtls")) ;
		this.recordSet = recordSet;
	}

/* These two methods are for the scheduled frequency lookup */
	public boolean setScheduleFrequencyStr(Hashtable ht) {
		try {
			String code 								= (String)ht.get("code");
			String duration_type 						= (String)ht.get("durationType");
			int repeat									= Integer.parseInt((String)ht.get("repeat"));
			String row_value							= (String)ht.get("row_value");
			scheduleFrequency							= new HashMap();
			ArrayList scheduleFrequencyDatas			= new ArrayList();

			for(int j=1; j <= repeat; j++) {
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e) {
			System.err.println("Error when setting schedule");
			return false;
		}
	}

	public ArrayList getScheduleFrequencyStr(String code, String row_value) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

	public String getOrderID(){
		return this.order_id;
	}

	public String setOrderID(String patientClass) { 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String order_id			= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, "PH");
			pstmt.setString(2, patientClass);
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_id	 = resultSet.getString("order_id");
			}
			this.order_id=order_id;
		}
		catch(Exception e) {
			System.err.println("Error @ generating Order ID : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ generating Order ID : " + es);}
		}
		return order_id;
	}

	public  float calculateQty(String freqCode,String freqNature,float volume,int duration,String regcode)
	{
		float qtyvalue=0;
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String rptValue="1.0";
		String intValue="1.0";
		
		try {
			connection	= getConnection();
			/*pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT10"));
			pstmt.setString(1, freqCode);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				rptValue     = resultSet.getString("REPEAT_VALUE")==null?"1":resultSet.getString("REPEAT_VALUE");
				intValue	 =resultSet.getString("INTERVAL_VALUE")==null?"1":resultSet.getString("INTERVAL_VALUE"); 

			}*/
			if (freqNature.equals("F")||freqNature.equals("C"))
			{
				qtyvalue=duration*volume*(Float.parseFloat(rptValue)==0?1:Float.parseFloat(rptValue));
			}
			else if (freqNature.equals("I"))
			{
				qtyvalue=duration*volume*(24/(Float.parseFloat(intValue)==0?1:Float.parseFloat(intValue)));

			}
			else if (freqNature.equals("O"))
			{
				qtyvalue=volume;
			}
			//if(resultSet!=null)	closeResultSet( resultSet ) ;
			//if(pstmt!=null) 	closeStatement( pstmt ) ;
			//Now find the stock uom and insert
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT19"));
			pstmt		= connection.prepareStatement("SELECT   CEIL(?/(nvl((select EQVL_VALUE  from am_uom_eqvl where  UOM_CODE =a.PRES_BASE_UNIT and  EQVL_UOM_CODE =b.SALE_UOM_CODE),'1' ))) stock_qty,  SALE_UOM_CODE   stock_uom FROM    PH_tpn_regimen A,ST_ITEM B WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.item_CODE=?");
			pstmt.setString(1, qtyvalue+"");
			pstmt.setString(2, regcode);

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				String tmp				= resultSet.getString("STOCK_QTY");
				if (tmp!=null && !tmp.equals(""))
				{
					qtyvalue		= Float.parseFloat(tmp);
				}
				this.StockUOM		= resultSet.getString("STOCK_UOM");
			}
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving frequency for qty calculations : " + e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving frequency for qty calculations : " + es);}
		}
		return qtyvalue;
	}

	public  String getOrderType(String regCode)
	{
		String ordertype="";
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT11"));
			pstmt.setString(1, regCode);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				ordertype = resultSet.getString("ORDER_TYPE_CODE");
			}
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order type : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order type : " + es);}
		}
		return ordertype;
	}

	public  String getUnit()
	{
		String ordertype="";
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT21"));

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				ordertype = resultSet.getString("REGIMEN_SETUP_UNIT");
			}
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order type : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order type : " + es);
			}
		}
		return ordertype;
	}
/* -- Function  getOrderDispenseLocationForTPN Added for SRR20056-SCF-7783	ICN 28195*/

	public ArrayList getOrderDispenseLocationForTPN(String location_type,String location_code,String take_home_medication,String priority,String iv_prep_yn,String drug_code,String patient_id,String encounter_id) {
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList disp_locn		= new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, location_type);
			cstmt.setString(3, location_code);
			cstmt.setString(4, take_home_medication);
			cstmt.setString(5, priority);
			cstmt.setString(6, iv_prep_yn);
			cstmt.setString(7, getLanguageId());
			
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.setString(12,drug_code); // added for Bru-HIMS-CRF-347 [IN:037862]-- end
			cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.execute();

			disp_locn.add(cstmt.getString(8));
			disp_locn.add(cstmt.getString(9));
			disp_locn.add(cstmt.getString(10));
		    //setDispCode(cstmt.getString(8).toString());
		}
		catch (Exception e) {
			disp_locn.add(e.toString());
			System.err.println("Error finding default dispense location for TPN NS :"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		 
		return disp_locn;
	}
/* -- Function  getDispenseLocation commented for SRR20056-SCF-7783	ICN 28195
	public  ArrayList getDispenseLocation(String facility,String locationtype,String locationcode,String takehome,String priority)
	{
		ArrayList result=new ArrayList();
		Connection connection	= null;
		CallableStatement cstmt	= null;
		ResultSet resultSet		= null;
		try {
			connection	= getConnection();
			cstmt = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
			cstmt.setString(1, facility);
			cstmt.setString(2, locationtype);
			cstmt.setString(3, locationcode);
			cstmt.setString(4, takehome);
			cstmt.setString(5, priority);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();

			String perf_locn_code	= cstmt.getString(6);
			String perf_locn_type	= cstmt.getString(7);

			result.add(perf_locn_code);
			result.add(perf_locn_type);
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving dispense location : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving dispense location : " + es);
			}
		}
		return result;
	}
*/
	public  String getOrderStatus(String authreqd,String cosignreqd,String appreqd,String authorized,String approved,String cosigned)
	{
		String order_status					="";
		Connection connection				= null;
		PreparedStatement pstmt				= null;
		ResultSet resultSet					= null;

		/* Calculation of Order Status starts here*/
		String init_auth_reqd_yn			=authreqd;
		String init_spl_appr_reqd_yn		=appreqd;
		String init_cosign_reqd_yn			=cosignreqd;

		
		String ord_auth_reqd_yn				=authorized;
		String ord_appr_reqd_yn				=approved;
		String ord_cosign_reqd_yn			=cosigned;

		if( (init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N")) )
		{
			order_status="10";
		}
		else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y")))
		{
			if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
				order_status	=	"10";
			else
				order_status	=	"00";
		}
		else if ((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))) 
		{
			if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))		
				order_status	=	"10";
			else
				order_status	=	"05";
		}
		else if ((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N"))) 
		{
			if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
				order_status	=	"10";
			else
				order_status="03";
		}
		else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N")))
		{
			if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
			{		
				order_status="10";
			}
			else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
			{		
				order_status="05";
			}
			else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
			{		
				order_status="03";
			} 
			else
			{
				order_status="03";
			}
		}
		else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y")))
		{
			if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
			{
				order_status="10";
			}
			else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
			{
				order_status="03";
			}
			else if((ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) )
			{
				order_status="00";
			}
			else 
			{
				order_status="00";
			}
		}
		else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y")))
		{
			if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) )
			{
				order_status="10";
			}
			else 
			{
				order_status="05";
			}
		}
		else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))) 
		{
			if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y"))) 
			{
				order_status	=	"10";
			}
			else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ) 
			{
				order_status	=	"03";
			}
			else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) 
			{
				order_status	=	"05";
			}
			else if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) 
			{
				order_status	=	"10";
			}
			else 
			{	
				order_status	=	"03";
			}
		}

	/*Order Status Calculation ends here*/
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT13"));
			pstmt.setString(1, order_status);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				order_status = resultSet.getString("ORDER_STATUS_CODE");
			}
		
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order status : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order status : " + es);}
		}
		return order_status;
	}

	public HashMap insert() {

//		HashMap result=new HashMap();
		HashMap tabData	=new HashMap();
		HashMap sqlMap	=new HashMap();
		HashMap map		=new HashMap();
		//put required data

		String patientclass=(String)recordSet.get("patient_class");
		/* Generate Order Id*/

		if (patientclass.equals("EA"))
		{
			patientclass="OP";
		}
		else if (patientclass.equals("DF"))
		{
			patientclass="IP";
		}
		String orderid			=setOrderID(patientclass);
		String freqNature		=(String)recordSet.get("freqNature");
		String freqCode			=(String)recordSet.get("frequency");
		String regCode			=(String)recordSet.get("Regimen_Code");
		String locCode			=(String)recordSet.get("location_code");
		String locType			=(String)recordSet.get("location_type");
		String priority			=(String)recordSet.get("priority");
		String patient_id		=(String)recordSet.get("patient_id");
		String encounter_id		=(String)recordSet.get("encounter_id");
		String infroute			=(String)recordSet.get("infroute");	 
		String ordertype		=getOrderType(regCode);	 
		//int volume				=Integer.parseInt((String)recordSet.get("volume"));
		float volume				=Float.parseFloat((String)recordSet.get("volume"));
		int duration			=Integer.parseInt((String)recordSet.get("duration"));
		String total_daily_fluid		=(String)(recordSet.get("total_daily_fluid")==null?"":recordSet.get("total_daily_fluid"));//added for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(recordSet.get("enteral_feeding")==null?"":recordSet.get("enteral_feeding"));//added for ML-MMOH-CRF-1012
		float qty					=calculateQty(freqCode,freqNature,volume,duration,regCode);
		String qty1				=qty+"";

		/*Get trade_code*/
		String tradecode		=getTradeCode(regCode);
		
		/* Get Dispense location*/
		//ArrayList dispLocn	=getDispenseLocation(login_facility_id,locType,locCode,"N",priority);//Commented for SRR20056-SCF-7783	ICN 28195
		ArrayList dispLocn	=getOrderDispenseLocationForTPN(locType,locCode,"N",priority,"7","",patient_id,encounter_id); // Added for for SRR20056-SCF-7783	ICN 28195,patient_id,encounter_id added for MMS-QH-CRF-0048 [IN:037704]
		if (dispLocn.size()==0)
		{
			tabData.put("flag","temp");
			tabData.put("result",new Boolean(false));
			tabData.put("message","Errror Retrieving dispense locations!!");
		}
		String dispcode		=(String)dispLocn.get(0);
	
		/* Calculate order status */
		String authreqd		=(String)recordSet.get("authreqdYN");
		String cosignreqd	=(String)recordSet.get("cosignreqdYN");
		String appreqd		=(String)recordSet.get("splappreqdYN");
		String authorized	=(String)recordSet.get("authorizedYN");
		String approved		=(String)recordSet.get("splappedYN");
		String cosigned		=(String)recordSet.get("cosignedYN");
	
		String orderstatus	=getOrderStatus(authreqd,cosignreqd,appreqd,authorized,approved,cosigned);

		tabData.put("flag","temp");
		tabData.put("result",new Boolean(true));
		tabData.put("message","inside insert");
		
		//common order details
		tabData.put("order_id",orderid);
		tabData.put("patient_id",patient_id);
		tabData.put("encounter_id",encounter_id);
		tabData.put("location_type",locType);
		tabData.put("location_code",locCode);
		tabData.put("pract_id",recordSet.get("pract_id"));
		tabData.put("patient_class",patientclass);
		tabData.put("bed_num",recordSet.get("bed_num"));//added for ML-MMOH-CRF-1089
		if(!getLanguageId().equals("en")){ // if& else block added for SRR20056-SCF-7783	28195
			tabData.put("order_date",com.ehis.util.DateUtils.convertDate((String)recordSet.get("order_date"), "DMYHM",getLanguageId(),"en"));
		}
		else{
			tabData.put("order_date",recordSet.get("order_date"));
		}
		//tabData.put("order_date",recordSet.get("order_date")); // commented for SRR20056-SCF-7783	28195
		tabData.put("weight",recordSet.get("weight"));
		tabData.put("height",recordSet.get("height"));
		tabData.put("priority",priority);
		tabData.put("orderstatus",orderstatus);
		tabData.put("header_comments",getPresRemarks());

		//Regimen related details	  		
		tabData.put("Regimen_Code",regCode);
		tabData.put("stdregimen",recordSet.get("stdregimen"));
		tabData.put("ordertype",ordertype);
		if(!getLanguageId().equals("en")){ // if& else block added for SRR20056-SCF-7783	28195
			tabData.put("startdate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("startdate"), "DMYHM",getLanguageId(),"en"));
			tabData.put("enddate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("enddate"), "DMYHM",getLanguageId(),"en"));
		}
		else{
			tabData.put("startdate",recordSet.get("startdate"));
			tabData.put("enddate",recordSet.get("enddate"));
		}
		//tabData.put("startdate",recordSet.get("startdate")); // commented for SRR20056-SCF-7783	28195
		//tabData.put("enddate",recordSet.get("enddate")); // commented for SRR20056-SCF-7783	28195
		tabData.put("duration",recordSet.get("duration"));
		tabData.put("frequency",freqCode);
		tabData.put("freqNature",freqNature);
		tabData.put("quantity",qty1);
		tabData.put("StockUOM",this.StockUOM);
		tabData.put("tradecode",tradecode);
		tabData.put("infuseover",recordSet.get("infuseover"));
		tabData.put("infuseoverdrn",recordSet.get("infuseoverdrn"));
		tabData.put("volume",recordSet.get("volume"));
		tabData.put("unitofvolume",recordSet.get("unitofvolume"));
		tabData.put("StockUOM",StockUOM); 
		tabData.put("authreqdYN",authreqd);
		tabData.put("cosignreqdYN",cosignreqd);
		tabData.put("splappreqdYN",appreqd);
		tabData.put("consentreqdYN",recordSet.get("consentreqdYN"));
		tabData.put("authorizedYN",authorized);
		tabData.put("cosignedYN",approved);
		tabData.put("splappedYN",cosigned);
		tabData.put("dispcode",dispcode);/*dispcode to be inserted*/
		tabData.put("user",login_by_id);
		tabData.put("facility",login_facility_id);
		tabData.put("wsno",login_at_ws_no);
		tabData.put("scheduleFrequency",scheduleFrequency);
		tabData.put("infroute",infroute); 
		/*Get Regimen Remarks  and store it in the tabData*/
		//System.err.println("regimenRemarks---->"+regimenRemarks);
		tabData.put("regimenRemarks",regimenRemarks); 
		tabData.put("buildMAR_yn",getBuildMAR_yn());
		
		tabData.put("total_daily_fluid",total_daily_fluid);//added for ML-MMOH-CRF_1012
		tabData.put("enteral_feeding",enteral_feeding);//added for ML-MMOH-CRF_1012
		try {
		    String SQLORDER="INSERT INTO OR_ORDER (ORDER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY,CONTR_SYS_ID, PATIENT_ID, PATIENT_CLASS, ORDERING_FACILITY_ID,ENCOUNTER_ID, EPISODE_ID, SOURCE_TYPE,SOURCE_CODE, DISCHARGE_IND, ORD_DATE_TIME, ORD_PRACT_ID, PRIORITY, ORD_AUTH_REQD_YN,  ORD_AUTH_BY_PRACT_ID,ORD_AUTH_DATE_TIME,ORD_APPR_REQD_YN, ORD_APPR_BY_USER_ID, ORD_APPR_DATE_TIME, ORD_COSIGN_REQD_YN, ORD_COSIGN_BY_PRACT_ID, ORD_COSIGN_DATE_TIME,BILL_YN, CONT_ORDER_IND, PERFORMING_FACILITY_ID, PERFORMING_SYS_ID, PERFORMING_DEPTLOC_TYPE, PERFORMING_DEPTLOC_CODE, PERFORMING_PRACT_ID,  RESULT_AUTH_REQD_YN, CHILD_ORDER_YN,  ORDER_SET_YN,  IV_PREP_YN,  ORDER_STATUS,ADDED_BY_ID,  ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,  MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORD_CONSENT_REQD_YN, ORD_CONSENT_BY_ID,  ORD_CONSENT_BY_DATE_TIME,TRN_GROUP_REF) VALUES (?/*order_id*/, ?/*ORDER_TYPE_CODE*/, 'PH', 'PH', ?/*PATIENT_ID*/,?/*PATIENT_CLASS*/, ?/*ORDERING_FACILITY_ID*/, ?/*ENCOUNTER_ID*/, ?/*EPISODE_ID*/, ? /*SOURCE_TYPE*/, ?/*SOURCE_CODE*/, 'N', TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_DATE_TIME*/, ?/*ORD_PRACT_ID*/, ?/*PRIORITY*/,?/*ORD_AUTH_REQD_YN*/, ?/*ORD_AUTH_BY_PRACT_ID*/,  TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_AUTH_DATE_TIME*/,?/*ORD_APPR_REQD_YN*/, ?/*ORD_APPR_BY_USER_ID*/,  TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_APPR_DATE_TIME*/,?/*ORD_COSIGN_REQD_YN*/, ?/*ORD_COSIGN_BY_PRACT_ID*/, TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_COSIGN_DATE_TIME*/,'N', 'CO', ?/*PERFORMING_FACILITY_ID*/, 'PH', ?/*PERFORMING_DEPTLOC_TYPE*/,	?/*PERFORMING_DEPTLOC_CODE*/,?/*PERFORMING_PRACT_ID*/, 'N', 'N', 'N', ?, ?/*ORDER_STATUS*/, ?/*ADDED_BY_ID*/, SYSDATE, ?/*ADDED_AT_WS_NO*/, ?/*ADDED_FACILITY_ID*/,  ?/*MODIFIED_BY_ID*/, SYSDATE, ?/*MODIFIED_AT_WS_NO*/,   ?/*MODIFIED_FACILITY_ID*/, ?/*ORD_CONSENT_REQD_YN*/, ?/*ORD_CONSENT_BY_ID*/,    TO_DATE(?, 'dd/mm/yyyy hh24:mi')/*ORD_CONSENT_BY_DATE_TIME*/,? /*TRN_GROUP_REF*/ )";
		   //	sqlMap.put("SQLORDER", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT1" ) );
		   	sqlMap.put("SQLORDER", SQLORDER);
			sqlMap.put("SQLORDERLINE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT2" ) );
			sqlMap.put("SQLORDERLINEPH", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT3" ) );
			sqlMap.put("SQLORDERCOMMENTS", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT4" ) );
			sqlMap.put("SQLORDERCOMMENTS1", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATE1" ) );
			sqlMap.put("SQLORDERLINEFIELDVALUES", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT5" ) );
			sqlMap.put("SQLMEDNADMIN", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT6" ) );
			sqlMap.put("SQLDATESELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT15" ) );
			sqlMap.put("SQLFACILITYPARAMSELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT14" ) );	  
			sqlMap.put("SQLPH_PATIENT_DRUG_PROFILE_INSERT", PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_INSERT4A" ) );
			sqlMap.put("SERIALNO", PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_SELECT55" ) );
			sqlMap.put("SQLPHTPNSTANDARDREGIMEN","INSERT INTO PH_TPN_STANDARD_REGIMEN (FACILITY_ID,DISP_LOCN_CODE,ORDER_ID,ORDER_LINE_NUM,PATIENT_ID,PATIENT_CLASS,LOCN_CODE,BED_NO,QTY_VALUE,INFUSE_OVER,INFUSE_LINE,START_DATE,END_DATE,DURATION ,CONST_GROUP_CODE, TPN_REGIMEN_CODE,CONST_GENERIC_CODE, CONST_CONCENTRATION_PERC, CONST_VOLUME, CONST_VOLUME_UNIT,CONST_WEIGHT,CONST_WEIGHT_UNIT,EMULSION_TYPE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID ,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ,LABEL_CAU_INSTRN1_ENG, LABEL_CAU_INSTRN2_ENG,LABEL_SPL_INSTRN1_ENG,LABEL_SPL_INSTRN2_ENG,LABEL_PAT_INSTRN1_ENG,LABEL_CAU_INSTRN1_LOC,LABEL_CAU_INSTRN2_LOC,LABEL_SPL_INSTRN1_LOC,LABEL_SPL_INSTRN2_LOC,LABEL_PAT_INSTRN1_LOC) VALUES (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?)");
//added for ML-MMOH-CRF-1089
			map=localInsert (tabData,sqlMap );
			if( ((Boolean) map.get( "result")).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		return map;
	}

	private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside local Insert" ) ;

		String debug="0";

		Connection connection			= null ;
		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_insert4	= null ;
		PreparedStatement pstmt_insert5	= null ;
		PreparedStatement pstmt_insert6	= null ;
		PreparedStatement pstmt_insert7	= null ;//added for ML-MMOH-CRF-1089
		PreparedStatement pstmt_insert	= null ;
		PreparedStatement pstmttmp		= null;
		PreparedStatement pstmt			= null ;
		PreparedStatement pstmt_select1	= null ;
		PreparedStatement pstmt_clob	=null;
		PreparedStatement pstmt_select2	= null;//added for ML-MMOH-CRF-1089
		PreparedStatement pstmt_select3	= null;//added for ML-MMOH-CRF-1089
		ResultSet resultSet				= null;//added for ML-MMOH-CRF-1089
		ResultSet resultSet3			= null;//added for ML-MMOH-CRF-1089
		ResultSet	rset_clob			=null;
		ResultSet rstmp					= null;
		PreparedStatement pstmt_select	=null;
		ResultSet temprs				=null;
		CallableStatement cstmt_insert	=null;
		//Retrieve tabData and sql data

		String order_id					=(String)tabData.get("order_id");
		String orderstatus				=(String)tabData.get("orderstatus");
		String patient_id				=(String)tabData.get("patient_id");
		String encounter_id				=(String)tabData.get("encounter_id");
		String location_type			=(String)tabData.get("location_type");
		String location_code			=(String)tabData.get("location_code");
		String pract_id					=(String)tabData.get("pract_id");
		String patient_class			=(String)tabData.get("patient_class");
		String order_date				=(String)tabData.get("order_date");
		String weight					=(String)tabData.get("weight");
		String height					=(String)tabData.get("height");
		String priority					=(String)tabData.get("priority");
		String Regimen_Code				=(String)tabData.get("Regimen_Code");
		String tradecode				=(String)tabData.get("tradecode");
		String stdregimen				=(String)tabData.get("stdregimen");
		String ordertype				=(String)tabData.get("ordertype");
		String startdate				=(String)tabData.get("startdate");
		String enddate					=(String)tabData.get("enddate");
		String duration					=(String)tabData.get("duration");
		String frequency				=(String)tabData.get("frequency");
		String quantity					=(String)tabData.get("quantity");
		String infuseover				=(String)tabData.get("infuseover");
		String infuseoverdrn			=(String)tabData.get("infuseoverdrn");
		String volume					=(String)tabData.get("volume");
		String unitofvolume				=(String)tabData.get("unitofvolume");
		String StockUOM					=(String)tabData.get("StockUOM");
		String authreqdYN				=(String)tabData.get("authreqdYN");
		String cosignreqdYN				=(String)tabData.get("cosignreqdYN");
		String splappreqdYN				=(String)tabData.get("splappreqdYN");	
		String consentreqdYN			=(String)tabData.get("consentreqdYN");	
		String authorizedYN				=(String)tabData.get("authorizedYN");
		String cosignedYN				=(String)tabData.get("cosignedYN");
		String splappedYN				=(String)tabData.get("splappedYN");	
		String dispcode					=(String)tabData.get("dispcode");
		String user						=(String)tabData.get("user");
		String facility					=(String)tabData.get("facility");
		String wsno						=(String)tabData.get("wsno");
		String infroute                 =(String)tabData.get("infroute");
		HashMap	regimenRemarks			=(HashMap)tabData.get("regimenRemarks");
		HashMap	scheduleFrequency		=(HashMap)tabData.get("scheduleFrequency");
		String	buildMAR_yn				=(String)tabData.get("buildMAR_yn");
		String  bed_num					= (String)tabData.get("bed_num");//added for ML-MMOH-CRF-1089
		String total_daily_fluid		=(String)(tabData.get("total_daily_fluid")==null?"":tabData.get("total_daily_fluid"));//added for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(tabData.get("enteral_feeding")==null?"":tabData.get("enteral_feeding"));//added for ML-MMOH-CRF-1012
		ResultSet resultSet2			= null ;//ADDED FOR ML-MMOH-CRF-1089
		ResultSet resultSet1			= null ;
		String trn_group_ref = "";
		int tmpcount					=0;
		int srl_NO						= 0;
		String route_code				="";

		try {

			connection	= getConnection() ;
			boolean tpn_std_lbl_site = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","TPN_STD_REGIMEN_LABEL");//added for ML-MMOH-CRF-1089
			pstmt			= connection.prepareStatement((String) sqlMap.get( "SERIALNO"));
				pstmt.setString(1,patient_id);
				resultSet		= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						srl_NO=resultSet.getInt("NEXT_SRL_NO");
				}
			if(resultSet!=null)	
				closeResultSet( resultSet ) ;
			if(pstmt!=null) 	
				closeStatement( pstmt ) ;
			
			pstmt   =connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT5A"));
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				route_code=resultSet.getString("DFLT_IV_ROUTE_CODE");
				if(route_code == null){
					route_code="";
				}
			}

		  	pstmt_select1		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT")) ;
			resultSet1			= pstmt_select1.executeQuery();

			if(resultSet1!=null && resultSet1.next()) {
				trn_group_ref = resultSet1.getString("TRN_GROUP_REF");
			}
			try {
				closeResultSet( resultSet1 );
				closeStatement( pstmt_select1) ;
			}
			catch(Exception es) {
				es.printStackTrace();
			}
			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLORDER"));
			pstmt_insert1.setString(1,order_id);  
			pstmt_insert1.setString(2,ordertype);	  
			pstmt_insert1.setString(3,patient_id);	
			pstmt_insert1.setString(4,patient_class.trim());
			pstmt_insert1.setString(5,facility);	   
			pstmt_insert1.setString(6,encounter_id);   
			pstmt_insert1.setString(7,encounter_id);   
			pstmt_insert1.setString(8,location_type);  
			pstmt_insert1.setString(9,location_code);	
			pstmt_insert1.setString(10,order_date);	   
			pstmt_insert1.setString(11,pract_id);	   
			pstmt_insert1.setString(12,priority.trim());  
			pstmt_insert1.setString(13,authreqdYN);

			if (authorizedYN.equals("Y"))
			{
				pstmt_insert1.setString(14,pract_id);	
				pstmt_insert1.setString(15,order_date);
			}
			else
			{
				pstmt_insert1.setString(14,"");
				pstmt_insert1.setString(15,"");
			}
			pstmt_insert1.setString(16,splappreqdYN);
			if (splappedYN.equals("Y"))
			{
				pstmt_insert1.setString(17,pract_id);  
				pstmt_insert1.setString(18,order_date);
			}
			else
			{
				pstmt_insert1.setString(17,"");
				pstmt_insert1.setString(18,"");
			}
			pstmt_insert1.setString(19,cosignreqdYN);
			if (cosignedYN.equals("Y"))
			{
				pstmt_insert1.setString(20,pract_id); 
				pstmt_insert1.setString(21,order_date);
			}
			else
			{
				pstmt_insert1.setString(20,"");
				pstmt_insert1.setString(21,"");
			}
			pstmt_insert1.setString(22,facility);  
			pstmt_insert1.setString(23,"P");	  
			pstmt_insert1.setString(24,dispcode);/*dispcode to be inserted*/ 
			pstmt_insert1.setString(25,pract_id);			   
			pstmt_insert1.setString(26,"7");/* IV_PREP_YN*/
			pstmt_insert1.setString(27,orderstatus);	 
			pstmt_insert1.setString(28,user);  
			pstmt_insert1.setString(29,wsno);  
			pstmt_insert1.setString(30,facility); 
			pstmt_insert1.setString(31,user);	  
			pstmt_insert1.setString(32,wsno);	  
			pstmt_insert1.setString(33,facility);  
			pstmt_insert1.setString(34,consentreqdYN);	
			pstmt_insert1.setString(35,"");
			pstmt_insert1.setString(36,"");
			pstmt_insert1.setString(37,trn_group_ref);

			tmpcount = pstmt_insert1.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER") ;
				connection.rollback();
				return map;
			}
			closeStatement( pstmt_insert1 ) ;			
			/* OR_ORDER  OVER*/

			pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINE"));
													 
			pstmt_insert2.setString(1,order_id);
			pstmt_insert2.setString(2,"1");
			pstmt_insert2.setString(3,Regimen_Code); 
			//IF ELSE CONDTION ADDED FOR ML-MMOH-SCF-0839 
			if(stdregimen.length() > 40 && stdregimen!= null && !stdregimen.equals(""))
				
				{pstmt_insert2.setString(4, stdregimen.substring(0,40));
			pstmt_insert2.setString(5, stdregimen.substring(0,40));}
				else
					{pstmt_insert2.setString(4, stdregimen);
			pstmt_insert2.setString(5, stdregimen);}
			//pstmt_insert2.setString(4,stdregimen);//COMMENTED FOR ML-MMOH-SCF-0839 
			//pstmt_insert2.setString(5,stdregimen);//COMMENTED FOR ML-MMOH-SCF-0839 
			pstmt_insert2.setString(6,ordertype);
			pstmt_insert2.setString(7,order_date);
			pstmt_insert2.setString(8,priority);
			pstmt_insert2.setString(9,authreqdYN);
			pstmt_insert2.setString(10,splappreqdYN);
			pstmt_insert2.setString(11,cosignreqdYN);
			pstmt_insert2.setString(12,startdate);
			pstmt_insert2.setString(13,route_code);//Route code
			pstmt_insert2.setString(14,volume);//qty_value
	  		pstmt_insert2.setString(15,unitofvolume); 
			pstmt_insert2.setString(16,frequency);	 
			pstmt_insert2.setString(17,duration);	
			pstmt_insert2.setString(18,"D");
			if (!regimenRemarks.isEmpty())
			{
				pstmt_insert2.setString(19,(String)regimenRemarks.get("order_format_values"))/*LINE_FIELDS_DISPLAY_TEXT*/;
			}
			else
			{
				pstmt_insert2.setString(19,"")/*LINE_FIELDS_DISPLAY_TEXT*/; 
			}
			
			pstmt_insert2.setString(20,enddate);
			pstmt_insert2.setString(21,quantity);
			pstmt_insert2.setString(22,StockUOM);//ORDER_UOM
			pstmt_insert2.setString(23,pract_id);
			pstmt_insert2.setString(24,orderstatus);
			pstmt_insert2.setString(25,user);
			pstmt_insert2.setString(26,wsno);
			pstmt_insert2.setString(27,facility);
			pstmt_insert2.setString(28,user);
			pstmt_insert2.setString(29,wsno);
			pstmt_insert2.setString(30,facility);
			pstmt_insert2.setString(31,consentreqdYN);
			//pstmt_insert2.setString(32,stdregimen);//COMMENTED FOR ML-MMOH-SCF-0839 
		//	pstmt_insert2.setString(33,stdregimen);//COMMENTED FOR ML-MMOH-SCF-0839 
		//ADDED FOR ML-MMOH-SCF-0839  START
			if(stdregimen.length() > 40 && stdregimen!= null && !stdregimen.equals(""))
				
			{pstmt_insert2.setString(32, stdregimen.substring(0,40));
		pstmt_insert2.setString(33, stdregimen.substring(0,40));}
			else
				{pstmt_insert2.setString(32, stdregimen);
		pstmt_insert2.setString(33, stdregimen);}
			//ADDED FOR ML-MMOH-SCF-0839  END
			tmpcount = pstmt_insert2.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE") ;
				connection.rollback();
				return map;
			}
			 closeStatement( pstmt_insert2 ) ;
			/* OR_ORDER_LINE  OVER*/ 
			/* PH_PATIENT_DRUG_PROFILE_INSERT     */
			pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLPH_PATIENT_DRUG_PROFILE_INSERT"));
			pstmt_insert.setString(1,patient_id);
			pstmt_insert.setString(2,""+(srl_NO));
			pstmt_insert.setString(3,facility);
			pstmt_insert.setString(4,encounter_id);
			pstmt_insert.setString(5,patient_class);
			pstmt_insert.setString(6,location_type);
			pstmt_insert.setString(7,location_code);
			pstmt_insert.setString(8,"");//
			pstmt_insert.setString(9,"");//
			pstmt_insert.setString(10,"");//
			pstmt_insert.setString(11,"");//
			pstmt_insert.setString(12,"");//
			pstmt_insert.setString(13,"");//
			pstmt_insert.setString(14,pract_id);//
			pstmt_insert.setString(15,pract_id);//
			pstmt_insert.setString(16,Regimen_Code);//DRUG_CODE,
			pstmt_insert.setString(17,"STREG");//GENERIC_ID,
			pstmt_insert.setString(18,startdate);
			pstmt_insert.setString(19,enddate);
			pstmt_insert.setString(20,"Y");
			pstmt_insert.setString(21,"N");
			pstmt_insert.setString(22,"");//strength
			pstmt_insert.setString(23,"");//strength_uom_code
			pstmt_insert.setString(24,"");//dosage
			pstmt_insert.setString(25,"");//dosage_uom_code
			pstmt_insert.setString(26,"");//SPLIT_DOSE_PREVIEW
			pstmt_insert.setString(27,frequency);
			pstmt_insert.setString(28,duration);
			pstmt_insert.setString(29,quantity);
			pstmt_insert.setString(30,"");//DIAG_TEXT
			pstmt_insert.setString(31,"");
			pstmt_insert.setString(32,"7");
			pstmt_insert.setString(33,"");
			pstmt_insert.setString(34,"");
			pstmt_insert.setString(35,"");
			pstmt_insert.setString(36,"");
			pstmt_insert.setString(37,"");
			pstmt_insert.setString(38,"N");
			pstmt_insert.setString(39,"");
			pstmt_insert.setString(40,null);
			pstmt_insert.setString(41,"N");
			pstmt_insert.setString(42,"");
			pstmt_insert.setString(43,null);
			pstmt_insert.setString(44,"P");
			pstmt_insert.setString(45,facility);
			pstmt_insert.setString(46,order_id);
			pstmt_insert.setString(47,"1");
			pstmt_insert.setString(48,"");
			pstmt_insert.setString(49,"N");
			pstmt_insert.setString(50,null);
			pstmt_insert.setString(51,"");
			pstmt_insert.setString(52,"");
			pstmt_insert.setString(53,null);
			pstmt_insert.setString(54,"");
			pstmt_insert.setString(55,"");
			pstmt_insert.setString(56,"N");
			pstmt_insert.setString(57,null);
			pstmt_insert.setString(58,"");
			pstmt_insert.setString(59,"");
			pstmt_insert.setString(60,user);
			pstmt_insert.setString(61,wsno);
			pstmt_insert.setString(62,facility);
			pstmt_insert.setString(63,user);
			pstmt_insert.setString(64,wsno);
			pstmt_insert.setString(65,facility);
			pstmt_insert.setString(66,"");
			pstmt_insert.setString(67,"");//ALLERGY_REMARKS
			pstmt_insert.setString(68,"");//DOSE_REMARKS
			pstmt_insert.setString(69,"");//IV_INGREDIENTS
			pstmt_insert.setString(70,"D");//DURN_TYPE
			pstmt_insert.setString(71,"");//DISPENSED_DRUGS,
			pstmt_insert.setString(72,"");//ALTERNATE_GENERIC_ID,
			pstmt_insert.setString(73,"");//DISP_REMARKS,
			pstmt_insert.setString(74,"");//DUPLICATE_DRUG_OVERRIDE_REASON,
			pstmt_insert.setString(75,"N");//REFILL_YN,
			pstmt_insert.setString(76,"");//FORM_CODE
			pstmt_insert.setString(77,"");//
			pstmt_insert.setString(78,"");//
			pstmt_insert.setString(79,"");//
			pstmt_insert.setString(80,"");//
			pstmt_insert.setString(81,"");//
			pstmt_insert.setString(82,"");//
			pstmt_insert.setString(83,"");//
			pstmt_insert.setString(84,"");//
			pstmt_insert.setString(85,"");//
			pstmt_insert.setString(86,"Q");//PRESCRIBED_MODE
			pstmt_insert.setString(87,height);
			pstmt_insert.setString(88,"");//height_unit
			pstmt_insert.setString(89,weight);
			pstmt_insert.setString(90,"");//weight_unit
			pstmt_insert.setString(91,"");//bsa
			pstmt_insert.setString(92,"N");	//allergic_yn					
			pstmt_insert.setString(93,"");//bmi	
			pstmt_insert.setString(94,infroute);//TPN_ADMIN_ROUTE

			tmpcount = pstmt_insert.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_PATIENT_DRUG_PROFILE") ;
				connection.rollback();
				return map;
			}
			 closeStatement( pstmt_insert ) ;
			//******************************end PH_PATIENT_DRUG_PROFILE*******************		
			if (buildMAR_yn == null)
			{
				buildMAR_yn = "N";
			}
			pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEPH"));
			
			pstmt_insert3.setString(1,order_id);
			pstmt_insert3.setString(2,"1");
			pstmt_insert3.setString(3,tradecode); 
			pstmt_insert3.setString(4,"A");
			pstmt_insert3.setString(5,"");
			pstmt_insert3.setString(6,"");
			pstmt_insert3.setString(7,infuseover); 
			pstmt_insert3.setString(8,infuseoverdrn);
			pstmt_insert3.setString(9,"");
			pstmt_insert3.setString(10,"");
			pstmt_insert3.setString(11,"");
			pstmt_insert3.setString(12,"P");
			pstmt_insert3.setString(13,"");/*dispcode to be inserted*/
			pstmt_insert3.setString(14,quantity); 
			pstmt_insert3.setString(15,"");
			pstmt_insert3.setString(16,user);
			pstmt_insert3.setString(17,wsno);
			pstmt_insert3.setString(18,facility);
			pstmt_insert3.setString(19,user);
			pstmt_insert3.setString(20,wsno);
			pstmt_insert3.setString(21,facility);
			pstmt_insert3.setString(22,"");
			pstmt_insert3.setString(23,"");
			pstmt_insert3.setString(24,quantity); 
			pstmt_insert3.setString(25,unitofvolume);
			pstmt_insert3.setString(26,buildMAR_yn);
			pstmt_insert3.setString(27,total_daily_fluid);//added for ML-MMOH-CRF-1012
			pstmt_insert3.setString(28,enteral_feeding);//added for ML-MMOH-CRF-1012
			tmpcount = pstmt_insert3.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE_PH") ;
				connection.rollback();
				return map;
			}
			 closeStatement( pstmt_insert3 ) ;
			/* OR_ORDER_LINE_PH OVER*/ 			
			// Header Level Comments
			String header_comments = (String)tabData.get("header_comments");
			if ( (header_comments!=null) && (header_comments.length() > 0) && (!header_comments.equals(""))   )
			{
				pstmt_insert4 = connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS"));
				pstmt_insert4.setString(1, order_id);
				pstmt_insert4.setString(2, "1"); // For Insert it will be "1"
				pstmt_insert4.setString(3, user);
				pstmt_insert4.setString(4, wsno);
				pstmt_insert4.setString(5, facility);
				pstmt_insert4.setString(6, user);
				pstmt_insert4.setString(7, wsno);
				pstmt_insert4.setString(8, facility);
				tmpcount = pstmt_insert4.executeUpdate();
				if(tmpcount > 0 )
				{
//					PreparedStatement pstmt_clob=null;
//					ResultSet	rset_clob=null;
					pstmt_clob		= connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS1"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,"1"); 
					rset_clob=pstmt_clob.executeQuery();
					if(rset_clob!=null)
					{
						while(rset_clob.next())
						{
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}
					}
				}
				else
				{
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_COMMENTS") ;
					connection.rollback();
					return map;
				}
			   closeStatement( pstmt_clob ) ;
			   closeResultSet( rset_clob ) ; 
	  		}
			/* OR_ORDER_COMMENTS OVER*/
			int seqNo=0;
			if (!scheduleFrequency.isEmpty())
			{
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
				ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
				for(int n=0;n<fieldvalues.size();n++)
				{
					HashMap data=new HashMap();
					data=(HashMap)fieldvalues.get(n);
  					String admin_time=(String)data.get("admin_time");
  					String admin_qty=(String)data.get("admin_qty");
					pstmt_insert5.setString(1,order_id);
  					pstmt_insert5.setString(2,"1");
  					pstmt_insert5.setString(3,"S");
  					pstmt_insert5.setString(4,""+(seqNo++));
  					pstmt_insert5.setString(5, "SCHED_ADMIN_TIME");
  					pstmt_insert5.setString(6,"C");
  					pstmt_insert5.setString(7,"D");
  					pstmt_insert5.setString(8,admin_time);
  					pstmt_insert5.setString(9,admin_qty);
  					pstmt_insert5.setString(10,unitofvolume);
  					pstmt_insert5.setString(11,"O");
  					pstmt_insert5.setString(12,user);
  					pstmt_insert5.setString(13,wsno);
  					pstmt_insert5.setString(14,facility);
  					pstmt_insert5.setString(15,user);
  					pstmt_insert5.setString(16,wsno);
  					pstmt_insert5.setString(17,facility);
  					pstmt_insert5.addBatch();
				}

				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
				{
					if(batch_result[i]<0  && batch_result[i] != -2 ){
						tmpcount=0;
						break;
					} 
					else 
					{
						tmpcount = 1;
					}
				}
				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion of Frequency into Order Line Field Values table") ;
					connection.rollback();
					return map;
				}
			   closeStatement( pstmt_insert5 ) ;
			}

			if (!regimenRemarks.isEmpty())
			{
				if(pstmt_insert5!=null) 	closeStatement( pstmt_insert5 ) ;
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
				String  total_seq=(String)regimenRemarks.get("order_format_count") ;
				int order_format_count=Integer.parseInt(total_seq);
				for(int k=0;k<order_format_count;k++)
				{
					pstmt_insert5.setString(1,order_id);
					pstmt_insert5.setString(2,"1"); // order_line_num
					pstmt_insert5.setString(3,"S");
					pstmt_insert5.setString(4,""+(seqNo++));
					pstmt_insert5.setString(5,(String)regimenRemarks.get("field_mnemonic"+k));
					pstmt_insert5.setString(6,(String)regimenRemarks.get("field_type"+k));
					pstmt_insert5.setString(7,(String)regimenRemarks.get("label_text"+k));
					pstmt_insert5.setString(8,(String)regimenRemarks.get("field_values"+k));
					pstmt_insert5.setString(9,"");
					pstmt_insert5.setString(10,"");
					pstmt_insert5.setString(11,(String)regimenRemarks.get("accept_option"+k));
					pstmt_insert5.setString(12,user);
					pstmt_insert5.setString(13,wsno);
					pstmt_insert5.setString(14,facility);
					pstmt_insert5.setString(15,user);
					pstmt_insert5.setString(16,wsno);
					pstmt_insert5.setString(17,facility);
					pstmt_insert5.addBatch();
				}
				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
				{
					if(batch_result[i]<0  && batch_result[i] != -2 ){
						tmpcount=0;
						break;
					} 
					else 
					{
						tmpcount = 1;
					}
				}
				if (tmpcount==0)
				{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion of Remarks into Order Line Field Values table") ;
				connection.rollback();
				return map;

				}
				closeStatement( pstmt_insert5 ) ;	  
				}
			/* OR_ORDER_LINE_FIELD_VALUES OVER*/
			//INSERT INTO PH_MEDN_ADMIN
	//		PreparedStatement pstmt_select	=null;
	//		ResultSet temprs						=null;

			//Check ph_facility_param
			 pstmttmp=connection.prepareStatement((String) sqlMap.get( "SQLFACILITYPARAMSELECT"));
			pstmttmp.setString(1,facility);
			 rstmp=pstmttmp.executeQuery();
			String verify			="N";
			String medadmin	="N";
			if (rstmp.next())
			{
				verify		=rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null?"N":rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				medadmin	=rstmp.getString("MED_ADMIN_REQD_YN")==null?"N":rstmp.getString("MED_ADMIN_REQD_YN");
			}

			if (	(medadmin.equals("Y"))&&((patient_class.equals("IP")||(patient_class.equals("EM")))))
			{
				pstmt_insert6=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMIN"));
				pstmt_insert6.setString(1,facility);
				pstmt_insert6.setString(2,encounter_id);
				pstmt_insert6.setString(3,startdate);
				pstmt_insert6.setString(4,Regimen_Code);
				pstmt_insert6.setString(5,"1");
				pstmt_insert6.setString(6,order_id);
				pstmt_insert6.setString(7,"1");
				pstmt_insert6.setString(8,patient_id);
				pstmt_insert6.setString(9,pract_id);
				pstmt_insert6.setString(10,quantity);
				pstmt_insert6.setString(11,unitofvolume);
				pstmt_insert6.setString(12,"")/*SCH_ROUTE_CODE*/;
				pstmt_insert6.setString(13,user);
				pstmt_insert6.setString(14,wsno);
				pstmt_insert6.setString(15,facility);
				pstmt_insert6.setString(16,user);
				pstmt_insert6.setString(17,wsno);
				pstmt_insert6.setString(18,facility);
				pstmt_insert6.setString(19,verify)/*VERIFY_REQD_YN*/;
				tmpcount =pstmt_insert6.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_MEDN_ADMIN") ;
				connection.rollback();
				return map;
			}
  			closeStatement( pstmt_insert6 ) ;	  
		}
		//Execute Batch for PH_MEDN_ADMIN
			/* PH_MEDN_ADMIN OVER */
			//Now call workload procedure
//			CallableStatement cstmt_insert=null;
			cstmt_insert=connection.prepareCall("{call PH_CREATE_WORKLOAD_STATS(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt_insert.setString( 1, pract_id);
			cstmt_insert.setString( 2, order_date);
			cstmt_insert.setString( 3, facility);
			cstmt_insert.setString( 4, patient_class);
			cstmt_insert.setString( 5, location_type);
			cstmt_insert.setString( 6, location_code);
			cstmt_insert.setString( 7,"1");
			cstmt_insert.setString( 8,"1");
			cstmt_insert.setString( 9, wsno);
			cstmt_insert.setString( 10, user);
			cstmt_insert.registerOutParameter(11, Types.VARCHAR );
			cstmt_insert.registerOutParameter(12, Types.VARCHAR );
			cstmt_insert.execute() ;
			String insert_yn	= cstmt_insert.getString( 11 );
			if(insert_yn.equals("Y"))
				tmpcount = 1;
			else
				tmpcount = 0;

			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into Workload Statistics Table") ;
				connection.rollback();
				return map;
			}
//added for ML-MMOH-CRF-1089 - start
	
			if(tpn_std_lbl_site){
				String cons_group_code = "",const_generic_code="",const_concentration_perc="",const_volume="",const_volume_unit = "",const_weight="",const_weight_unit="",emulsion_type="", caution_label_text_id_1="", spl_instr_label_text_id="",how_to_take_text="";

			
				pstmt_insert7=connection.prepareStatement((String) sqlMap.get( "SQLPHTPNSTANDARDREGIMEN"));

				pstmt_select3 = connection.prepareStatement("SELECT caution_label_text_id_1, caution_label_text_id_2, spl_instr_label_text_id, how_to_take_text  FROM ph_tpn_regimen WHERE tpn_regimen_code = ? ");
				
				pstmt_select3.setString(1,Regimen_Code);
				resultSet3	= pstmt_select3.executeQuery();
				
				if(resultSet3!=null && resultSet3.next()){
					
					caution_label_text_id_1 =resultSet3.getString("caution_label_text_id_1");
					spl_instr_label_text_id =resultSet3.getString("spl_instr_label_text_id");
					how_to_take_text		=resultSet3.getString("how_to_take_text");
				}
				pstmt_select2 = connection.prepareStatement( "SELECT b.const_group_code, b.const_generic_code, a.const_weight,a.const_weight_unit,emulsion_type,CONST_VOLUME,CONST_VOLUME_UNIT,const_concentration_perc FROM ph_const_for_tpn_regimen a, ph_tpn_const_generic_name b   WHERE a.tpn_regimen_code = ? AND  a.const_generic_code = b.const_generic_code ORDER BY 1");
				
				pstmt_select2.setString(1,Regimen_Code);

				resultSet2		= pstmt_select2.executeQuery();
				while(resultSet2!=null && resultSet2.next()){

				cons_group_code			 = resultSet2.getString("const_group_code");
				const_generic_code 		 = resultSet2.getString("const_generic_code");	
				const_weight 			 = resultSet2.getString("const_weight");
				const_weight_unit 		 = resultSet2.getString("const_weight_unit");
				emulsion_type 			 = resultSet2.getString("emulsion_type");
				const_volume = resultSet2.getString("CONST_VOLUME");
				const_volume_unit = resultSet2.getString("CONST_VOLUME_UNIT");
				const_concentration_perc = resultSet2.getString("const_concentration_perc");

				pstmt_insert7.setString(1,facility);
				pstmt_insert7.setString(2,dispcode);
				pstmt_insert7.setString(3,order_id);
				pstmt_insert7.setString(4,"1");
				pstmt_insert7.setString(5,patient_id);
				pstmt_insert7.setString(6,patient_class);
				pstmt_insert7.setString(7,location_code);
				pstmt_insert7.setString(8,bed_num);
				pstmt_insert7.setString(9,quantity);
				pstmt_insert7.setString(10,infuseover);
				pstmt_insert7.setString(11,infroute);
				pstmt_insert7.setString(12,startdate);
				pstmt_insert7.setString(13,enddate);
				pstmt_insert7.setString(14,duration);
				pstmt_insert7.setString(15,cons_group_code);
				pstmt_insert7.setString(16,Regimen_Code);
				pstmt_insert7.setString(17,const_generic_code);
				pstmt_insert7.setString(18,const_concentration_perc);
				pstmt_insert7.setString(19,const_volume);
				pstmt_insert7.setString(20,const_volume_unit);
				pstmt_insert7.setString(21,const_weight);
				pstmt_insert7.setString(22,const_weight_unit);
				pstmt_insert7.setString(23,emulsion_type);
				pstmt_insert7.setString(24,user);
				pstmt_insert7.setString(25,wsno);
				pstmt_insert7.setString(26,facility);
				pstmt_insert7.setString(27,user);
				pstmt_insert7.setString(28,wsno);
				pstmt_insert7.setString(29,facility);
				pstmt_insert7.setString(30,caution_label_text_id_1);
				pstmt_insert7.setString(31,"");
				pstmt_insert7.setString(32,spl_instr_label_text_id);
				pstmt_insert7.setString(33,"");
				pstmt_insert7.setString(34,how_to_take_text);
				pstmt_insert7.setString(35,caution_label_text_id_1);
				pstmt_insert7.setString(36,"");
				pstmt_insert7.setString(37,spl_instr_label_text_id);
				pstmt_insert7.setString(38,"");
				pstmt_insert7.setString(39,how_to_take_text);
				

				pstmt_insert7.addBatch();
				}
			int[] batch_result = pstmt_insert7.executeBatch();
			for (int i=0;i<batch_result.length ;i++ )
			{
				if(batch_result[i]<0  && batch_result[i] != -2 ){
					tmpcount=0;
					break;
				}else 
				{
					tmpcount = 1;
				}
			}
			if (tmpcount==0)
			{

				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into PH_TPN_STANDARD_REGIMEN ") ;
				connection.rollback();
				return map;
			}
  			closeStatement( pstmt_insert7 ) ;	  
		
			}
//added for ML-MMOH-CRF-1089 - end
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();
		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception has occured: " +e+debug) ;
			e.printStackTrace();
					}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet( rstmp ) ;
				closeResultSet( rset_clob ) ;
				closeResultSet(temprs);
				closeStatement(pstmttmp		);
				closeStatement( pstmt_insert ) ;
				closeStatement(pstmt);
				closeStatement(cstmt_insert);
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_insert3 ) ;
				closeStatement( pstmt_insert4 ) ;
				closeStatement( pstmt_insert5 ) ;
				closeStatement( pstmt_insert6 ) ;
				closeStatement( pstmt_clob ) ;
				closeStatement( pstmt_select ) ;
				closeStatement( pstmt_select2 ) ;
				closeStatement( pstmt_select3 ) ;
				closeStatement( pstmt_insert7 ) ;
				closeResultSet(resultSet2);//ADDED FOR ML-MMOH-CRF-1089
				closeResultSet(resultSet3);
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;

			}
		}
		return map ;
	}

	public HashMap modify() {
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();

		//put required data

		String orderid			=(String)recordSet.get("order_id");
		String freqNature		=(String)recordSet.get("freqNature");
		String freqCode			=(String)recordSet.get("frequency");
		String regCode			=(String)recordSet.get("Regimen_Code");
		String patientclass		=(String)recordSet.get("patient_class");
		String infroute			=(String)recordSet.get("infroute");
		/* Generate Order Id*/

		if (patientclass.equals("EA"))
		{
			patientclass="OP";
		}
		else if (patientclass.equals("DF"))
		{
			patientclass="IP";
		}

		//int volume				=Integer.parseInt((String)recordSet.get("volume"));
		float volume				=Float.parseFloat((String)recordSet.get("volume"));
		int duration			=Integer.parseInt((String)recordSet.get("duration"));  		
		float qty					=calculateQty(freqCode,freqNature,volume,duration,regCode);
		String total_daily_fluid		=(String)(recordSet.get("total_daily_fluid")==null?"":recordSet.get("total_daily_fluid"));//added for amend ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(recordSet.get("enteral_feeding")==null?"":recordSet.get("enteral_feeding"));//added for amend ML-MMOH-CRF-1012
		String qty1				=qty+"";

		//common order details
		tabData.put("order_id",orderid);
		tabData.put("pract_id",recordSet.get("pract_id"));
		tabData.put("patientclass",patientclass);
		tabData.put("encounter_id",recordSet.get("encounter_id"));
		tabData.put("patient_id",recordSet.get("patient_id")); 
		//Regimen related details
		if(!getLanguageId().equals("en")){ // if& else block added for SRR20056-SCF-7783	28195
			tabData.put("startdate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("startdate"), "DMYHM",getLanguageId(),"en"));
			tabData.put("enddate",com.ehis.util.DateUtils.convertDate((String)recordSet.get("enddate"), "DMYHM",getLanguageId(),"en"));
		}
		else{
			tabData.put("startdate",recordSet.get("startdate"));
			tabData.put("enddate",recordSet.get("enddate"));
		}
		//tabData.put("startdate",recordSet.get("startdate")); //commented for SRR20056-SCF-7783	28195
		//tabData.put("enddate",recordSet.get("enddate")); //commented for SRR20056-SCF-7783	28195
		tabData.put("duration",recordSet.get("duration"));
		tabData.put("frequency",freqCode);
		tabData.put("freqNature",freqNature);
		tabData.put("quantity",qty1);
		tabData.put("infuseover",recordSet.get("infuseover"));
		tabData.put("infuseoverdrn",recordSet.get("infuseoverdrn"));
		tabData.put("volume",recordSet.get("volume"));
		tabData.put("unitofvolume",recordSet.get("unitofvolume"));
		tabData.put("StockUOM",StockUOM);
		tabData.put("user",login_by_id);
		tabData.put("facility",login_facility_id);
		tabData.put("wsno",login_at_ws_no);
		tabData.put("Regimen_Code",regCode);
		tabData.put("scheduleFrequency",scheduleFrequency);
		tabData.put("header_comments",getPresRemarks());
		tabData.put("infroute",infroute);
		tabData.put("buildMAR_yn",getBuildMAR_yn());
		//Added for amend ML-MMOH-CRF-1012 start
		tabData.put("total_daily_fluid",total_daily_fluid);
		tabData.put("enteral_feeding",enteral_feeding);
		//Added for amend ML-MMOH-CRF-1012 end
		/*Get Regimen Remarks  and store it in the tabData*/
		tabData.put("regimenRemarks",regimenRemarks);
		try {
			sqlMap.put("SQLORDERLINE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATEORDERLINE1A" ) );
			sqlMap.put("SQLORDERREMARKSDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_ORDERREMARKSDELETE" ) );
			sqlMap.put("SQLORDERLINEREMARKSDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_ORDERLINEREMARKSDELETE" ) );
			//sqlMap.put("SQLORDERLINEPH", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATEORDERLINEPH" ) );
			//TOTAL_DAILY_FLUID=?, ENTERAL_FEEDING=? added amend ML-MMOH-CRF-1012
			sqlMap.put("SQLORDERLINEPH", "UPDATE OR_ORDER_LINE_PH SET INFUSE_OVER=?, INFUSE_OVER_UNIT=?,TOT_INFUSION_OVER=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? , BMS_QTY=?, PRES_QTY_VALUE=?, BUILD_MAR_YN=?,TOTAL_DAILY_FLUID=?,ENTERAL_FEEDING=? WHERE ORDER_ID=? " );
			sqlMap.put("SQLORDERLINESCHEDULE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT5" ) );
			sqlMap.put("SQLORDERCOMMENTS", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT4" ) );
			sqlMap.put("SQLORDERCOMMENTS1", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_UPDATE1" )) ;  			
			sqlMap.put("SQLMEDNADMINDEL", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_DELETE" )) ;				
			sqlMap.put("SQLMEDNADMIN", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_INSERT6" ) );
			sqlMap.put("SQLDATESELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT15" ) );
			sqlMap.put("SQLFACILITYPARAMSELECT", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT14" ) );
			sqlMap.put("SQLMAXSEQNO", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT22" ) );
			sqlMap.put("PH_DRUG_PROFILE_UPDATE", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_PH_DRUG_PROFILE_UPDATE" ) );	
		  	sqlMap.put("SQLPHTPNSTANDARDREGIMENAMEND","UPDATE PH_TPN_STANDARD_REGIMEN SET QTY_VALUE=?, START_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'),END_DATE=TO_DATE(?,'DD/MM/YYYY HH24:MI'), INFUSE_OVER=?,DURATION=?, MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? WHERE ORDER_ID=? " );//ML-BRU-CRF-1089
			
			map.put("result",new Boolean(true));
			map.put("flage","testing modfy");
			map.put("message","In modify");

			map=localModify (tabData,sqlMap );
			if( ((Boolean) map.get( "result")).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
		 }
		 catch (Exception e)
		 {
			System.err.println(e.toString());
		 }
		return map;
	}


	private HashMap localModify( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside local Modify" ) ;

		String debug="0";

		Connection connection			= null ;
		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_insert4	= null ;
		PreparedStatement pstmt_insert5	= null ;
		PreparedStatement pstmt_insert6	= null ;
		PreparedStatement pstmt_update	= null ;
		PreparedStatement pstmt_update1	= null ;//ML-BRU-CRF-1089
		PreparedStatement pstmt			= null ;
		PreparedStatement pstmt_clob	= null;
		ResultSet	rset_clob			= null;
		PreparedStatement pstmttmp		= null;
		ResultSet rstmp					= null;
		ResultSet resultSet				= null ;

		//Retrieve tabData and sql data

		String order_id					=(String)tabData.get("order_id");
		String startdate				=(String)tabData.get("startdate");
		String enddate					=(String)tabData.get("enddate");
		String duration					=(String)tabData.get("duration");
		String quantity					=(String)tabData.get("quantity");
		String infuseover				=(String)tabData.get("infuseover");
		String infuseoverdrn			=(String)tabData.get("infuseoverdrn");
		String volume					=(String)tabData.get("volume");
		String unitofvolume				=(String)tabData.get("unitofvolume");
		String StockUOM					=(String)tabData.get("StockUOM");
		String user						=(String)tabData.get("user");
		String facility					=(String)tabData.get("facility");
		String wsno						=(String)tabData.get("wsno");	
		String pract_id					=(String)tabData.get("pract_id");	
		String patient_class			=(String)tabData.get("patientclass");	
		String Regimen_Code				=(String)tabData.get("Regimen_Code");	
		String encounter_id				=(String)tabData.get("encounter_id");	
		String patient_id				=(String)tabData.get("patient_id");	
		String infroute					=(String)tabData.get("infroute");	  
		HashMap	regimenRemarks			=(HashMap)tabData.get("regimenRemarks");
		HashMap	scheduleFrequency		=(HashMap)tabData.get("scheduleFrequency");
		String	buildMAR_yn				=(String)tabData.get("buildMAR_yn");
		String route_code				="";
		String SEQ					    ="";
		String total_daily_fluid		=(String)(tabData.get("total_daily_fluid")==null?"":tabData.get("total_daily_fluid"));//added amend for ML-MMOH-CRF-1012
		String enteral_feeding			=(String)(tabData.get("enteral_feeding")==null?"":tabData.get("enteral_feeding"));//added amend for ML-MMOH-CRF-1012

		int tmpcount			=0;
		int seqNo=1;

		try {

			connection	= getConnection() ;
			boolean tpn_std_lbl_site = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","TPN_STD_REGIMEN_LABEL");//added for ML-MMOH-CRF-1089
			pstmt   =connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT5A"));
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				route_code=resultSet.getString("DFLT_IV_ROUTE_CODE");
				if(route_code == null){
					route_code="";
				}
			}
			try{

				pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINE"));
				pstmt_insert2.setString(1,route_code); 
				pstmt_insert2.setString(2,volume);//qty_value 
				pstmt_insert2.setString(3,unitofvolume);//qty_unit	
				pstmt_insert2.setString(4,quantity);//order_qty	  
				pstmt_insert2.setString(5,StockUOM);//order_uom	  
				pstmt_insert2.setString(6,duration);  
				pstmt_insert2.setString(7,startdate);  
				pstmt_insert2.setString(8,enddate);	 
				pstmt_insert2.setString(9,user);   
				pstmt_insert2.setString(10,wsno);  
				pstmt_insert2.setString(11,facility); 
				pstmt_insert2.setString(12,(String)(tabData.get("frequency")==null?"":tabData.get("frequency"))); //added for ML-MMOH-CRF-1126
				pstmt_insert2.setString(13,order_id);

				tmpcount = pstmt_insert2.executeUpdate();
			}
			catch(Exception e){
			   e.printStackTrace();
			}
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into OR_ORDER_LINE") ;
				connection.rollback();
				return map;
			}
			closeStatement( pstmt_insert2 ) ;

			/* OR_ORDER_LINE  OVER*/

			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEPH"));
		
			pstmt_insert1.setString(1,infuseover);
			pstmt_insert1.setString(2,infuseoverdrn);
			pstmt_insert1.setString(3,duration);
			pstmt_insert1.setString(4,user);
			pstmt_insert1.setString(5,wsno);
			pstmt_insert1.setString(6,facility);
			pstmt_insert1.setString(7,quantity);
			pstmt_insert1.setString(8,quantity);
			pstmt_insert1.setString(9,buildMAR_yn);
			pstmt_insert1.setString(10,total_daily_fluid);//added amend for ML-MMOH-CRF-1012
			pstmt_insert1.setString(11,enteral_feeding);//added amend for ML-MMOH-CRF-1012
			pstmt_insert1.setString(12,order_id);

			tmpcount = pstmt_insert1.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into OR_ORDER_LINE_PH") ;
				connection.rollback();
				return map;
			}
			closeStatement( pstmt_insert1 ) ;
			/* OR_ORDER_LINE  PH OVER*/
			/* PH_PATIENT_DRUG_PROFILE */
			pstmt_update=connection.prepareStatement((String) sqlMap.get("PH_DRUG_PROFILE_UPDATE"));
	
			pstmt_update.setString(1,infroute);//TPN_ADMIN_ROUTE
			pstmt_update.setString(2,wsno);//MODIFIED_AT_WS_NO
			pstmt_update.setString(3,user);//MODIFIED_BY_ID
			pstmt_update.setString(4,facility);//MODIFIED_FACILITY_ID
			pstmt_update.setString(5,order_id);//ORIG_ORDER_ID
			tmpcount = pstmt_update.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into PH_PATIENT_DRUG_PROFILE") ;
				connection.rollback();
				return map;
			}

//ML-BRU-CRF-1089 - start
			if(tpn_std_lbl_site){
			pstmt_update1=connection.prepareStatement((String) sqlMap.get("SQLPHTPNSTANDARDREGIMENAMEND"));
				pstmt_update1.setString(1,volume);
				pstmt_update1.setString(2,startdate);  
				pstmt_update1.setString(3,enddate);	 
				pstmt_update1.setString(4,infuseover);
				pstmt_update1.setString(5,duration);  
				pstmt_update1.setString(6,user);   
				pstmt_update1.setString(7,wsno);  
				pstmt_update1.setString(8,facility);  
				pstmt_update1.setString(9,order_id); 
				tmpcount = pstmt_update1.executeUpdate();
				if (tmpcount==0)
				{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Updation into PH_TPN_STANDARD_REGIMEN") ;
				connection.rollback();
				return map;
			} //ML-BRU-CRF-1089 -end
		}

		  /* Start of ORDER LINE FIELD VALUES */
			closeStatement( pstmt_update ) ;
			if (!scheduleFrequency.isEmpty())
			{
				if(pstmt_insert5!=null)  closeStatement(pstmt_insert5);
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINESCHEDULE"));
				ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
				for(int n=0;n<fieldvalues.size();n++)
				{
					HashMap data=new HashMap();
					data=(HashMap)fieldvalues.get(n);
					String admin_time=(String)data.get("admin_time");
					String admin_qty=(String)data.get("admin_qty");
					pstmt_insert5.setString(1,order_id);
					pstmt_insert5.setString(2,"1");
					pstmt_insert5.setString(3,"S");
					pstmt_insert5.setString(4,""+(seqNo++));
					pstmt_insert5.setString(5, "SCHED_ADMIN_TIME");
					pstmt_insert5.setString(6,"C");
					pstmt_insert5.setString(7,"D");
					pstmt_insert5.setString(8,admin_time);
					pstmt_insert5.setString(9,admin_qty);
					pstmt_insert5.setString(10,unitofvolume);
					pstmt_insert5.setString(11,"O");
					pstmt_insert5.setString(12,user);
					pstmt_insert5.setString(13,wsno);
					pstmt_insert5.setString(14,facility);
					pstmt_insert5.setString(15,user);
					pstmt_insert5.setString(16,wsno);
					pstmt_insert5.setString(17,facility);
					pstmt_insert5.addBatch();
				}
				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
				{
					if(batch_result[i]<0  && batch_result[i] != -2 ){
						tmpcount=0;
						break;
					} 
					else 
					{
						tmpcount = 1;
					}
				}

				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion of Frequency into Order Line Field Values table") ;
					connection.rollback();
					return map;
				}
				closeStatement( pstmt_insert5 ) ;
			}
			if (!regimenRemarks.isEmpty())
			{
				if(pstmt_insert3!=null)		
					closeStatement(pstmt_insert3);
				//Delete from or_order_line_field values where field text is not sched_admin_time ie only remarks will be deleted
				pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEREMARKSDEL"));
				pstmt_insert3.setString(1,order_id);
				pstmt_insert3.executeUpdate();
				//now choose the maximum seq no from or_order_line_field_values
				if(pstmt_insert3!=null)		closeStatement(pstmt_insert3);
				//System.err.println("order_id---->"+order_id);
				pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLMAXSEQNO"));
				pstmt_insert3.setString(1,order_id);
				resultSet=	pstmt_insert3.executeQuery();
				if (resultSet.next())
				{
					//SEQ=Integer.parseInt(resultSet.getString("SEQ"));
					SEQ=resultSet.getString("SEQ");
					if(!(SEQ==null||SEQ.equals("null")||SEQ.equals(""))){
					 seqNo=Integer.parseInt(SEQ)+1;
					}
					else{
						seqNo=seqNo+1;
					}
				}
				if(pstmt_insert3!=null) closeStatement(pstmt_insert3);

				if(pstmt_insert5!=null) closeStatement(pstmt_insert5);

				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINESCHEDULE"));
				String  total_seq=(String)regimenRemarks.get("order_format_count") ;
				int order_format_count=Integer.parseInt(total_seq);
				for(int k=0;k<order_format_count;k++)
				{
					pstmt_insert5.setString(1,order_id);
					pstmt_insert5.setString(2,"1"); // order_line_num
					pstmt_insert5.setString(3,"S");

					pstmt_insert5.setString(4,""+(seqNo++));
					pstmt_insert5.setString(5,(String)regimenRemarks.get("field_mnemonic"+k));
					pstmt_insert5.setString(6,(String)regimenRemarks.get("field_type"+k));
					pstmt_insert5.setString(7,(String)regimenRemarks.get("label_text"+k));
					pstmt_insert5.setString(8,(String)regimenRemarks.get("field_values"+k));
					pstmt_insert5.setString(9,"");
					pstmt_insert5.setString(10,"");
					pstmt_insert5.setString(11,(String)regimenRemarks.get("accept_option"+k));
					pstmt_insert5.setString(12,user);
					pstmt_insert5.setString(13,wsno);
					pstmt_insert5.setString(14,facility);
					pstmt_insert5.setString(15,user);
					pstmt_insert5.setString(16,wsno);
					pstmt_insert5.setString(17,facility);
					pstmt_insert5.addBatch();
				}
				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
				{
					if(batch_result[i]<0  && batch_result[i] != -2 ){
						tmpcount=0;
						break;
					} 
					else 
					{
						tmpcount = 1;
					}
				}
				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion of Remarks into Order Line Field Values table") ;
					connection.rollback();
					return map;
				}
				closeStatement( pstmt_insert5 ) ;
			}
			/* OR_ORDER_LINE_FIELD_VALUES OVER*/
		/* END OF ORDERLINE_FIELD_VALES */
			String header_comments = (String)tabData.get("header_comments");
			
			if ( (header_comments!=null) && (header_comments.length() > 0) && (!header_comments.equals(""))   )
			{
				if(pstmt_insert3!=null) closeStatement(pstmt_insert3);
					
				pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERREMARKSDEL"));
				pstmt_insert3.setString(1,order_id);
				pstmt_insert3.executeUpdate();

				pstmt_insert4 = connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS"));
				pstmt_insert4.setString(1, order_id);
				pstmt_insert4.setString(2, "1"); // For Insert it will be "1"
				pstmt_insert4.setString(3, user);
				pstmt_insert4.setString(4, wsno);
				pstmt_insert4.setString(5, facility);
				pstmt_insert4.setString(6, user);
				pstmt_insert4.setString(7, wsno);
				pstmt_insert4.setString(8, facility);
				tmpcount = pstmt_insert4.executeUpdate();
				if(tmpcount > 0 )
				{
			//		PreparedStatement pstmt_clob=null;
			//		ResultSet	rset_clob=null;
					pstmt_clob		= connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS1"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,"1"); 
					rset_clob=pstmt_clob.executeQuery();
					if(rset_clob!=null)
					{
						while(rset_clob.next())
						{
						    	Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}
					}
				}
				else
				{
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_COMMENTS") ;
					connection.rollback();
					return map;
				}
			}
			/* OR_ORDER_COMMENTS OVER*/
			 if(pstmt_insert3!=null) 
				 closeStatement(pstmt_insert3);
			 pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMINDEL"));
			 pstmt_insert3.setString(1,order_id);
			 pstmt_insert3.executeUpdate();

			//INSERT INTO PH_MEDN_ADMIN
			//Check ph_facility_param
			 pstmttmp=connection.prepareStatement((String) sqlMap.get( "SQLFACILITYPARAMSELECT"));
			pstmttmp.setString(1,facility);
			 rstmp=pstmttmp.executeQuery();
			String verify			="N";
			String medadmin	="N";
			if (rstmp.next())
			{
				verify		=rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null?"N":rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				medadmin	=rstmp.getString("MED_ADMIN_REQD_YN")==null?"N":rstmp.getString("MED_ADMIN_REQD_YN");
			}

			if (	(medadmin.equals("Y"))&&((patient_class.equals("IP")||(patient_class.equals("EM")))))
			{
				pstmt_insert6=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMIN"));
				pstmt_insert6.setString(1,facility);
				pstmt_insert6.setString(2,encounter_id);
				pstmt_insert6.setString(3,startdate);
				pstmt_insert6.setString(4,Regimen_Code);
				pstmt_insert6.setString(5,"1");
				pstmt_insert6.setString(6,order_id);
				pstmt_insert6.setString(7,"1");
				pstmt_insert6.setString(8,patient_id);
				pstmt_insert6.setString(9,pract_id);
				pstmt_insert6.setString(10,quantity);
				pstmt_insert6.setString(11,unitofvolume);
				pstmt_insert6.setString(12,"")/*SCH_ROUTE_CODE*/;
				pstmt_insert6.setString(13,user);
				pstmt_insert6.setString(14,wsno);
				pstmt_insert6.setString(15,facility);
				pstmt_insert6.setString(16,user);
				pstmt_insert6.setString(17,wsno);
				pstmt_insert6.setString(18,facility);
				pstmt_insert6.setString(19,verify)/*VERIFY_REQD_YN*/;
				tmpcount =pstmt_insert6.executeUpdate();
				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into PH_MEDN_ADMIN") ;
					connection.rollback();
					return map;
				}
			}
			/* PH_MEDN_ADMIN OVER */
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();
		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception has occured: " +e+debug) ;
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(rset_clob);
				closeStatement(pstmttmp);
				closeResultSet( rstmp);
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_insert3 ) ;
				closeStatement( pstmt_insert4 ) ;
				closeStatement( pstmt_insert5 ) ;
				closeStatement( pstmt_insert6 ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update1 ) ;//ML-BRU-CRF-1089
				
				closeStatement( pstmt_clob);
				closeStatement( pstmt);
				closeStatement( pstmttmp);
				closeConnection( connection );		
			}
			catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;	
			}
		} 	
		return map ;
	}

	public  ArrayList getTpnFrequency()
	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String frequency="";
		String freqNature = "";
		String code="";
		ArrayList tpnfreq=new ArrayList();
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT29"));
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				code	= resultSet.getString("code");
				frequency = resultSet.getString("FREQUENCY");
				freqNature= resultSet.getString("FREQ_NATURE");
				tpnfreq.add(code);
				tpnfreq.add(frequency);
				tpnfreq.add(freqNature);
			}
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + es);}
		}
		return tpnfreq;
	}

	public  ArrayList getNPCValue(String regcode)
	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		ArrayList record=new ArrayList();
		String npcvalue="";
		String volume="";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT30"));
			pstmt.setString(1,regcode);
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				npcvalue	= resultSet.getString("NPC");
				volume      = resultSet.getString("TOTAL_VOLUME"); 
			}
			record.add(npcvalue);
			record.add(volume);
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + es);
			}
		}
		return record;
	}

	public String getDrugDesc(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String drug_desc	= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6B"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				drug_desc = resultSet.getString("long_name");
			}
		}
		catch (Exception e) {
			System.err.println("Error loading order_catalog_code : " + e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error loading order_catalog_code : " + es);}
		}
		return drug_desc;
	} 
	public ArrayList getFluidRequired(String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList fluidValue = new ArrayList();
		int ispresent=0;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT2"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()){
				fluidValue.add(resultSet.getString("CONST_QTY_UNIT"));
				fluidValue.add(resultSet.getString("CONST_MIN_VAL"));
				fluidValue.add(resultSet.getString("CONST_MAX_VAL"));
				fluidValue.add(resultSet.getString("CONST_STD_VAL"));
				ispresent=1;
			}
			if (ispresent==0)
			{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT6"));
				resultSet	= pstmt.executeQuery();
				while (resultSet.next()){
					fluidValue.add(resultSet.getString("ORDERING_UNIT"));
					fluidValue.add("0");
					fluidValue.add("100000");
					fluidValue.add("0");
					ispresent=1;
				}
				if (ispresent==0)
				{
					fluidValue.add("  ");
					fluidValue.add("0");
					fluidValue.add("100000");
					fluidValue.add("0");

				}
			}//if
		}catch (Exception e) {
				System.err.println("Error loading Fluid Required: " + e);
		}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {				
				System.err.println("Error loading Fluid Required: " + es);
			}
		}
		return fluidValue;
	}

	public String  getVolueme(String tpn_regimen_code)
	{       
		Connection connection = null ;
		PreparedStatement pstmt=null ;
		ResultSet resultSet=null;
		String volume="";
		try {
			connection = getConnection() ;
			pstmt= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_NON_STD_REGIMEN_SELECT3" )) ;
			pstmt.setString(1,tpn_regimen_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next())
			{				
				 volume	=resultSet.getString("TOTAL_VOLUME");
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
				System.err.println("Error loading : " + es);  
			}
		}
		return volume;
	}

	public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		//String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT TPN_SCREENING_TYPE,TPN_SCREENING_FORM_ID from ph_facility_param where FACILITY_ID=?");
			pstmt.setString(1,getLoggedInFacility());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("TPN_SCREENING_TYPE",resultSet.getString("TPN_SCREENING_TYPE"));
				 result.put("TPN_SCREENING_FORM_ID",resultSet.getString("TPN_SCREENING_FORM_ID"));
			}
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
									
    public HashMap ChkScreeningDetails(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String accession_num="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE FACILITY_ID=? AND ENCOUNTER_ID =? AND NOTE_TYPE=?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 accession_num =resultSet.getString("ACCESSION_NUM");
			     result.put("ACCESSION_NUM",accession_num);
			 }
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}

	public HashMap ChkDiscrete(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String contr_module_id="PH";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT  distinct to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') TEST_OBSERV_DT_TM FROM ca_encntr_discr_msr WHERE ? = facility_id(+) and encounter_id = ? and discr_msr_panel_or_form_id = ? and CONTR_MODULE_ID =? ");			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			pstmt.setString(4,contr_module_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				 result.put("TEST_OBSERV_DT_TM",resultSet.getString("TEST_OBSERV_DT_TM"));
			}
		}
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}

	public  String getVolume(String order_id)
	{
		String ordertype="";
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT26"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				ordertype = resultSet.getString("QTY_VALUE");
			}
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving order type : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving order type : " + es);}
		}
		return ordertype;
	}
	/* Function specific methods end */

	public String getprint_ord_sht_rule_ind(String  order_type_code,String patient_class){//Added for Bru-HIMS-CRF-393_1.0
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String print_option_sql		= "";
		String pres_print			= "";
		try{
			connection				= getConnection() ;
			print_option_sql="SELECT PRINT_ORD_SHT_RULE_IND FROM OR_ORDER_TYPE_ROUTING WHERE ORDER_TYPE_CODE=? AND PATIENT_CLASS=DECODE(?,PATIENT_CLASS, PATIENT_CLASS, '*A') AND OPERATING_FACILITY_ID=?";
			pstmt			= connection.prepareStatement(print_option_sql) ;
			pstmt.setString(1,order_type_code);
			pstmt.setString(2,patient_class);
			pstmt.setString(3,login_facility_id);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				pres_print=resultSet.getString("PRINT_ORD_SHT_RULE_IND")==null ? "C" :resultSet.getString("PRINT_ORD_SHT_RULE_IND");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pres_print;
	}
	//added for ML-MMOH-CRF-1126 - start
	public  HashMap getTPNContFreq(String order_catalog_code,String patient_class)
	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1= null;
		ResultSet resultSet1	= null;
		String frequency		= "";
		String code				= "";
		String freq_code		= "";
		ArrayList tpnfreq		= new ArrayList();
		HashMap freqMap			= new HashMap();
		try {
			connection	= getConnection();

			pstmt		= connection.prepareStatement("SELECT A.FREQ_CODE,A.FREQ_DESC FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.EFF_STATUS='E' AND A.FREQ_NATURE = 'C' AND A.FREQ_CODE = B.FREQ_CODE AND B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2");

			pstmt1		= connection.prepareStatement("SELECT FREQ_CODE FROM OR_CATALOG_BY_PTCL_LANG_VW WHERE  ORDER_CATALOG_CODE=?  and SETTING_APPLICABILITY = 'A'   AND patient_class = decode(?,patient_class, patient_class, '*A') AND LANGUAGE_ID = ?");

			pstmt.setString(1,order_catalog_code);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				code	= resultSet.getString("FREQ_CODE");
				frequency = resultSet.getString("FREQ_DESC");
				tpnfreq.add(code);
				tpnfreq.add(frequency);
			}
			pstmt1.setString(1,order_catalog_code);
			pstmt1.setString(2,patient_class);
			pstmt1.setString(3,getLanguageId());	
			resultSet1	= pstmt1.executeQuery();
			if (resultSet1!=null && resultSet1.next()) {
				freq_code	= resultSet1.getString("FREQ_CODE");
				if(freq_code==null)
					freq_code="";
			}
		freqMap.put("defTpnFreqCode",freq_code);
		freqMap.put("conTpnFreqList",tpnfreq);
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeResultSet(resultSet1);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error @ retrieving APPL_FREQ_FOR_TPN : " + es);}
		}
		return freqMap;
	}
	//added for ML-MMOH-CRF-1126 - end
	public  ArrayList getTPNConstEnrg(String const_code){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;		
		ArrayList tpnEngConst   = new ArrayList();		
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_ENERGY_QUERY"));		
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {											
				tpnEngConst.add(checkForNull(resultSet.getString("CONSTITUENT_CODE")));				
				tpnEngConst.add(checkForNull(resultSet.getString("CONSTITUENT_NAME")));
			}		
		}
		catch(Exception e) {
			System.err.println("Error @ retrieving required constituent energy : " + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);				
			}
			catch(Exception es) {System.err.println("Error @ retrieving appl required constituent energy : " + es);}
		}
		return tpnEngConst;
	}  // Added for ML-MMOH-CRF-1266 [IN:068728] - End	
	// Added for ML-MMOH-CRF-1290 START
	public String getAlert_YN(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String prompt_alert_yn	= "";
		String prompt_alert_msg	= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_NAME_SELECT1"));
			pstmt.setString(1, drug_code);

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {

				prompt_alert_yn	=	resultSet.getString("PROMPT_ALERT_YN");
				if(prompt_alert_yn.equals("Y"))
				{
                 prompt_alert_msg	=	resultSet.getString("PROMPT_ALERT_MSG");
				 if(prompt_alert_msg==null)
					 prompt_alert_msg="";

				}else
				{
					 prompt_alert_msg="";
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return prompt_alert_msg;
	}
	// Added for ML-MMOH-CRF-1290 END
}
