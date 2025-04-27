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
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import javax.rmi.* ;
import ePH.BLGroupOrderRouting.*;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class BLGroupOrderRoutingBean extends PhAdapter implements Serializable {

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
	protected String billing_group = "";
	protected String customer_id = "";
	protected String polocy_type = "";
	protected String customer_group = "";
	protected String disp_locn_code = "";
	protected String day_type = "";
	protected String disp_locn_for_admixtures = "N";
	private  ArrayList altdisp=new ArrayList();
  //  private  HashMap AltTemp=new HashMap(); Removed for IN063877
  //  private ArrayList alAllOrderRoutingList=new ArrayList(); Removed for IN063877
	HashMap altdispdetailsrtn=new HashMap();
	HashMap altdispdetailsstat=new HashMap();
	HashMap altdispdetailsD=new HashMap();
	HashMap rtnDetails=new HashMap();
	HashMap statDetails=new HashMap();
	HashMap dischargeDetails=new HashMap();
    HashMap TempAlt=new HashMap();
    ArrayList tempaltdisp=new ArrayList();
	public BLGroupOrderRoutingBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}
	

	public String getDebug(){
		return this.debug;
	}

	private void doCommon() throws Exception {
	}
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public void setDispLocnForAdmixtures(String disp_locn_for_admixtures){
		this.disp_locn_for_admixtures = disp_locn_for_admixtures;
	}

	public void setaltdisplocndetailsrtn(String key,HashMap altrtn) {
		this.altdispdetailsrtn.put(key,altrtn);
	}
	public HashMap getaltdisplocndetailsrtn() {
		return this.altdispdetailsrtn;
	} 
	public void setaltdisplocndetailsstat(String key,HashMap altstat) {
		this.altdispdetailsstat.put(key,altstat);
	}
	public HashMap getaltdisplocndetailsstat() {
		return this.altdispdetailsstat;
	} 
	public void setaltdisplocndetailsD(String key,HashMap altD) {
		
		this.altdispdetailsD.put(key,altD);
	}
	public HashMap getaltdisplocndetailsD() {
		return this.altdispdetailsD;
	} 
	
	public void setRtnDetails(String key,HashMap rtnDetails) {
		this.rtnDetails.put(key,rtnDetails);
	}

	public HashMap getRtnDetails() {
		return this.rtnDetails;
	} 

	public void setStatDetails(String key,HashMap statDetails) {
		this.statDetails.put(key,statDetails);
	}

	public HashMap getStatDetails() {
		return this.statDetails;
	} 

	public void setDischargeDtails(String key,HashMap dischargeDetails) {
		this.dischargeDetails.put(key,dischargeDetails);
	}

	public HashMap getDischargeDtails() {
		return this.dischargeDetails;
	} 

	public void setTempAlt(String key,ArrayList TempAlt) {
		this.TempAlt.put(key,TempAlt);
	}

	public HashMap getTempAlt() {
		return this.TempAlt;
	} 
	
	public ArrayList getAltDispData(){
		ArrayList alt_disp_data=new ArrayList();
		alt_disp_data.add(getaltdisplocndetailsrtn());
		alt_disp_data.add(getaltdisplocndetailsstat());
		alt_disp_data.add(getaltdisplocndetailsD());
		return alt_disp_data;
		
	}
	public void clear() {
		super.clear() ;
		altdispdetailsrtn=new HashMap();
		altdispdetailsstat=new HashMap();
		altdispdetailsD=new HashMap();
	}

	public void setAll(Hashtable recordSetMultiple){
		if(recordSetMultiple.containsKey("mode"))
			setMode((String)recordSetMultiple.get("mode")) ;

		if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ){
			hashMultiple = recordSetMultiple ;
			if(recordSetMultiple.containsKey("disp_locn_code"))
				disp_locn_code = (String)recordSetMultiple.get("disp_locn_code");
			if(recordSetMultiple.containsKey("day_type"))
				day_type = (String)recordSetMultiple.get("day_type");
		}
		else {
			hashMultiple = recordSetMultiple ;
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
			if(recordSetMultiple.containsKey("billing_group"))
				billing_group = (String)recordSetMultiple.get("billing_group");
			if(recordSetMultiple.containsKey("customer_group"))
				customer_group = checkForNull((String)recordSetMultiple.get("customer_group"),"*A");//*A added for [IN:041151] & [IN:046433]
			if(recordSetMultiple.containsKey("customer_id"))
				customer_id = checkForNull((String)recordSetMultiple.get("customer_id"),"*A");//*A added for [IN:041151] & [IN:046433]
			if(recordSetMultiple.containsKey("polocy_type"))
				polocy_type = checkForNull((String)recordSetMultiple.get("polocy_type"),"*A"); //*A added for [IN:041151] & [IN:046433]
			if(recordSetMultiple.containsKey("disp_locn_code"))
				disp_locn_code = (String)recordSetMultiple.get("disp_locn_code");
			if(recordSetMultiple.containsKey("day_type"))
				day_type = (String)recordSetMultiple.get("day_type");
		}
	}

	public HashMap insert() {

		Connection connection = null ;
		PreparedStatement pstmt = null,pstmt1 = null ;
		ResultSet resultSet = null ;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList arrListData = new ArrayList();
		ArrayList insertRowCommonData = new ArrayList() ;
		ArrayList insertRowMultipleData = null;
		String routingLevel , routing_code;
		StringTokenizer stdata =null; 

		try{
			connection = getConnection() ;
			pstmt	 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_SELECT11") ) ;
			pstmt1	 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_SELECT12") ) ;
			String ordering_facility_id = ((String)hashMultiple.get("ordering_facility_id"));
			String ordering_source_code	= ((String)hashMultiple.get("ordering_source_code"));
			String ordering_source_type = ((String)hashMultiple.get("ordering_source_type"));
			if (ordering_source_type.equals("E"))
				ordering_source_type ="C"; 
			else if (ordering_source_type.equals("D"))
				ordering_source_type ="N"; 
			insertRowCommonData.add(ordering_facility_id);
			insertRowCommonData.add(ordering_source_type);
			insertRowCommonData.add(ordering_source_code);
			insertRowCommonData.add(disp_locn_code);
			insertRowCommonData.add(day_type);

			int noOfRows = Integer.parseInt((String)hashMultiple.get("number_of_rows"));

			for(int i=0; i<noOfRows;i++){
				insertRowMultipleData = new ArrayList();
				     
				if (((String)hashMultiple.get("select"+i)).equals("Y")){

					routingLevel = ((String)hashMultiple.get("routing_level"+i));
					routing_code = hashMultiple.get("routing_code"+i)==null?"":(String)hashMultiple.get("routing_code"+i);
					rtn_ord_disp_locn_code = hashMultiple.get("rtn_ord_disp_locn_code"+i)==null?"":(String)hashMultiple.get("rtn_ord_disp_locn_code"+i);
					stat_ord_disp_locn_code = hashMultiple.get("stat_ord_disp_locn_code"+i)==null?"":(String)hashMultiple.get("stat_ord_disp_locn_code"+i);
					disch_ord_disp_locn_code = hashMultiple.get("disch_ord_disp_locn_code"+i)==null?"":(String)hashMultiple.get("disch_ord_disp_locn_code"+i);
					billing_group = hashMultiple.get("billing_group"+i)==null?"":(String)hashMultiple.get("billing_group"+i);
					customer_group = checkForNull((String)hashMultiple.get("customer_group"+i),"*A");//*A added for [IN:041151] & [IN:046433]
					customer_id = checkForNull((String)hashMultiple.get("customer_id"+i),"*A"); //*A added for [IN:041151] & [IN:046433]
					polocy_type = checkForNull((String)hashMultiple.get("polocy_type"+i),"*A"); //*A added for [IN:041151] & [IN:046433]
					if (!routingLevel.equals("O")){
						insertRowMultipleData.add(routingLevel);
						insertRowMultipleData.add(routing_code);
						insertRowMultipleData.add(((String)hashMultiple.get("performing_facility_id"+i)));
						insertRowMultipleData.add(rtn_ord_disp_locn_code);
						insertRowMultipleData.add(stat_ord_disp_locn_code);
						insertRowMultipleData.add(disch_ord_disp_locn_code);
						insertRowMultipleData.add(billing_group);
						insertRowMultipleData.add(customer_group);
						insertRowMultipleData.add(customer_id);
						insertRowMultipleData.add(polocy_type);
					}
					else{
						insertRowMultipleData.add(routingLevel);
						stdata = new StringTokenizer(routing_code,":");
						routing_code = stdata.nextToken();
						insertRowMultipleData.add(routing_code);

						insertRowMultipleData.add(((String)hashMultiple.get("performing_facility_id"+i)));

						stdata = new StringTokenizer(rtn_ord_disp_locn_code,":");
						while (stdata.hasMoreTokens()){
							rtn_ord_disp_locn_code = stdata.nextToken();
						}
						insertRowMultipleData.add(rtn_ord_disp_locn_code);

						stdata = new StringTokenizer(stat_ord_disp_locn_code,":");
						while (stdata.hasMoreTokens()){
							stat_ord_disp_locn_code = stdata.nextToken();
						}
						insertRowMultipleData.add(stat_ord_disp_locn_code);

						stdata = new StringTokenizer(disch_ord_disp_locn_code,":");
						while (stdata.hasMoreTokens()){
							disch_ord_disp_locn_code = stdata.nextToken();
						}
						insertRowMultipleData.add(disch_ord_disp_locn_code);
						stdata = new StringTokenizer(billing_group,":");
						while (stdata.hasMoreTokens()){
							billing_group = stdata.nextToken();
						}
						insertRowMultipleData.add(billing_group);
						stdata = new StringTokenizer(customer_group,":");
						while (stdata.hasMoreTokens()){
							customer_group = stdata.nextToken();
						}
						insertRowMultipleData.add(customer_group);
						stdata = new StringTokenizer(customer_id,":");
						while (stdata.hasMoreTokens()){
							customer_id = stdata.nextToken();
						}
						insertRowMultipleData.add(customer_id);
						stdata = new StringTokenizer(polocy_type,":");
						while (stdata.hasMoreTokens()){
							polocy_type = stdata.nextToken();
						}
						insertRowMultipleData.add(polocy_type);
					}
					arrListData.add(insertRowMultipleData);
					if (routingLevel.equals("S")){
						try {
							pstmt.setString(1,ordering_facility_id.trim());
							pstmt.setString(2,ordering_source_type.trim());
							pstmt.setString(3,ordering_source_code.trim());
							pstmt.setString(4,billing_group.trim());
							pstmt.setString(5,customer_group.trim());
							pstmt.setString(6,customer_id.trim());
							pstmt.setString(7,polocy_type.trim());
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
							}
							closeResultSet(resultSet);
						}
						catch(Exception e){
							e.printStackTrace() ;
						}
					}
					else if (!routingLevel.equals("S")){
						try {
							pstmt1.setString(1,ordering_facility_id.trim());
							pstmt1.setString(2,ordering_source_type.trim());
							pstmt1.setString(3,ordering_source_code.trim());
							pstmt1.setString(4,routingLevel.trim());
							pstmt1.setString(5,routing_code.trim());
							pstmt1.setString(6,billing_group.trim());
							pstmt1.setString(7,customer_group.trim());
							pstmt1.setString(8,customer_id.trim());
							pstmt1.setString(9,polocy_type.trim());
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
							}
							closeResultSet(resultSet);
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
			tabData.put( "ALTDispDetails",getAltDispData());
			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_BL_GROUP_ORDER_ROUTING_INSERT",PhRepository.getPhKeyValue("SQL_PH_BL_GROUP_ORDER_ROUTING_INSERT"));
			sqlMap.put("SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_INSERT"));
			sqlMap.put( "INSERTSQL",PhRepository.getPhKeyValue("SQL_PH_BLGROUP_ALT_DISP_LOCN_INSERT") ) ;
			sqlMap.put( "UPDATESQL", PhRepository.getPhKeyValue("SQL_PH_BLGROUP_ALT_DISP_LOCN_UPDATE"));

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_BL_ORDER_ROUTING" ),BLGroupOrderRoutingHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass();
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
		}
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}
		finally{
			try{
				closeStatement(pstmt);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			map.put("flag","0");
		}
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

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
			modifyData.add( billing_group.trim()) ;
			modifyData.add( customer_group.trim()) ;
			modifyData.add( customer_id.trim()) ;
			modifyData.add( polocy_type.trim()) ;

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_BL_GROUP_ORDER_ROUTING_DTL_UPDATE") );
			sqlMap.put( "INSERTSQL",PhRepository.getPhKeyValue("SQL_PH_BLGROUP_ALT_DISP_LOCN_INSERT") ) ;
			sqlMap.put( "UPDATESQL", PhRepository.getPhKeyValue("SQL_PH_BLGROUP_ALT_DISP_LOCN_UPDATE"));

	 		HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);
			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;
			tabData.put( "ALTDispDetails",getAltDispData());
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_BL_ORDER_ROUTING" ),BLGroupOrderRoutingHome.class,getLocalEJB());
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
		}
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}
		return map ;

	}

	public HashMap delete() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
		try{
			ArrayList deleteData = new ArrayList() ;
			HashMap sqlMap = new HashMap() ;
			if (routing_level.equals("S")){
				deleteData.add( ordering_facility_id.trim() ) ;
				deleteData.add( ordering_source_type.trim() ) ;
				deleteData.add( ordering_source_code.trim() ) ;
				deleteData.add( billing_group.trim()) ;
				deleteData.add( customer_group.trim()) ;
				deleteData.add( customer_id.trim()) ;
				deleteData.add( polocy_type.trim()) ;
				sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_DELETE") );
				sqlMap.put( "DeleteALTSQL", PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_ALT_DELETE_FOR_SOURCE") );
			}
			else{
				deleteData.add( ordering_facility_id.trim()) ;
				deleteData.add( ordering_source_type.trim()) ;
				deleteData.add( ordering_source_code.trim()) ;
				deleteData.add( routing_level.trim()) ;
				deleteData.add( routing_code.trim()) ;
				deleteData.add( billing_group.trim()) ;
				deleteData.add( customer_group.trim()) ;
				deleteData.add( customer_id.trim()) ;
				deleteData.add( polocy_type.trim()) ;
				sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_DTL_DELETE") );
				sqlMap.put( "DeleteALTSQL", PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_ALT_DELETE") );
			}

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "DeleteData",deleteData);

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_BL_ORDER_ROUTING" ),BLGroupOrderRoutingHome.class,getLocalEJB());
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
		}
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug);
			e.printStackTrace() ;
		}
		finally{
			map.put("flag",debug);
		}
		map.put("flag",debug);
		return map ;
	}

	public ArrayList loadRelatedLocation(String facility_id,String ordering_source_type) throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arrList=new ArrayList();
		try {

			connection = getConnection() ;
			if (ordering_source_type.equals("N")){
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
			else if (ordering_source_type.equals("C")){
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
		return arrList;
	}


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
			pstmt.setString(1,getLanguageId()); 
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
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					orderingFacility = resultSet.getString( "FACILITY_NAME" ) ;
				}
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
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
		all.add(performingFacility);
		all.add(orderingFacility);
		all.add(routingCode);
		all.add(IPInstalled);
		return all;
	}
	
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
			}
			else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

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
		return arrList;
	}

	public ArrayList loadData(String ordering_facility_id,String ordering_source_type,String ordering_source_code,String routing_level,String routing_code,String billing_group_code,String bl_cust_group_code,String bl_cust_code,String bl_polocy_type_code)throws Exception{
		ArrayList dataList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			if(routing_level.equals("S")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_BL_GROUP_ORDER_ROUTING_SELECT1")) ;
				pstmt.setString(1,ordering_facility_id.trim());
				pstmt.setString(2,ordering_source_type.trim());
				pstmt.setString(3,ordering_source_code.trim());
				pstmt.setString(4,billing_group_code.trim());//Added for MMS Internal issue Start
				pstmt.setString(5,bl_cust_group_code.trim());
				pstmt.setString(6,bl_cust_code.trim());
				pstmt.setString(7,bl_polocy_type_code.trim());//Added for MMS Internal issue End
			}
			else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_BL_GROUP_ORDER_ROUTING_SELECT2")) ;
				pstmt.setString(1,ordering_facility_id.trim());
				pstmt.setString(2,ordering_source_type.trim());
				pstmt.setString(3,ordering_source_code.trim());
				pstmt.setString(4,routing_level.trim());
				pstmt.setString(5,routing_code.trim());
				pstmt.setString(6,billing_group_code.trim());
				pstmt.setString(7,bl_cust_group_code.trim());
				pstmt.setString(8,bl_cust_code.trim());
				pstmt.setString(9,bl_polocy_type_code.trim());
			}
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					dataList.add( resultSet.getString( "PERFORMING_FACILITY_ID" ) ) ;
					dataList.add( resultSet.getString( "RTN_ORD_DISP_LOCN_CODE" ) );
					dataList.add( resultSet.getString( "STAT_ORD_DISP_LOCN_CODE" ) );
					dataList.add( resultSet.getString( "DISCH_ORD_DISP_LOCN_CODE" ) );
					dataList.add( resultSet.getString( "BL_GROUP_CODE" ) );
					dataList.add( resultSet.getString( "BL_CUSTOMER_GROUP_CODE" ) );
					dataList.add( resultSet.getString( "BL_CUSTOMER_CODE" ) );
					dataList.add( resultSet.getString( "BL_POLICY_TYPE" ) );
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
		return dataList;
	}

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
			}
			else{
				type = routing_code.trim();
			}

			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}

			append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";

			connection = getConnection() ;
			if(disp_locn_for_admixtures.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6A")+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
			}
			else{
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
			}
			else{
				type = routing_code.trim();
			}

			if (type.equals("G")){
				strAppend	=	" AND A.DISP_GENL_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=?  OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=?  OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}

			if(disp_locn_type.equals("C") || disp_locn_type.equals("E"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','O')";
			else if(disp_locn_type.equals("N") || disp_locn_type.equals("D"))
				append_clause =" AND A.DISP_LOCN_CATEGORY IN ('B','I')";

			connection = getConnection() ;
			if(disp_locn_for_admixtures.equals("Y")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT6A")+append_clause) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,getLanguageId());
			}
			else{
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
			}
			else if (type.equals("N")){
				strAppend	=	" AND A.DISP_NARCOTICS_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			else if (type.equals("C")){
				strAppend	=	" AND A.DISP_CONTROLLED_DRUG_YN='Y' AND (A.DISP_LOCN_TYPE=? OR A.DISP_LOCN_TYPE='P')";
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

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
		return arrList;
	}
	
	public ArrayList getDefaultDispLocDataForSourceD(String facility_id)throws Exception{
		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String append_clause ="";
		String sql ="";
		try {
			connection = getConnection() ;
		
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
		return arrList;
	}

	public ArrayList getBillingGroup(){
		ArrayList billingGroup = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_BILLING_GROUP_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					billingGroup.add( resultSet.getString( "BLNG_GRP_ID" ) ) ;
					billingGroup.add( resultSet.getString( "SHORT_DESC" ) );
					billingGroup.add( resultSet.getString( "SETTLEMENT_IND" ) );
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return billingGroup;
	}

	public ArrayList getCustomer(String cust_group_code){
		ArrayList customer = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CUSTOMER_SELECT")) ;
			pstmt.setString(1,cust_group_code);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					customer.add( resultSet.getString( "CUST_CODE" ) ) ;
					customer.add( resultSet.getString( "SHORT_NAME" ) );
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return customer;
	}

	public ArrayList getCustomerGroup(){
		ArrayList custGroup = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CUSTOMER_GROUP_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					custGroup.add( resultSet.getString( "CUST_GROUP_CODE" ) ) ;
					custGroup.add( resultSet.getString( "SHORT_DESC" ) );
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return custGroup;
	}

   public ArrayList getPolocyType(String cust_group_code,String cust_code,String facility_id){
		ArrayList polocyType = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_POLICY_TYPE_SELECT")) ;
			pstmt.setString(1,cust_group_code);
			pstmt.setString(2,cust_code);
			pstmt.setString(3,facility_id);
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					polocyType.add( resultSet.getString( "POLICY_TYPE_CODE" ) ) ;
					polocyType.add( resultSet.getString( "SHORT_DESC" ) );
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
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return polocyType;
	}

	public ArrayList getFacilities() {
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		ArrayList facilities				= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				facilities.add(resultSet.getString("FACILITY_ID"));
				facilities.add(resultSet.getString("FACILITY_NAME"));
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
		return facilities;
	}

	public ArrayList getaltdisplocmodify(String order_src_type, String perform_fcy,String order_fcy,String order_src_code,String day_type,String disp_locn_code,String routlevel, String routcode,String id){ 
		Connection connection			= null ;
		PreparedStatement pstmt		    = null ;
		ResultSet resultSet			    = null ;
		ArrayList altdispres			=new ArrayList();
		HashMap rec						=new HashMap();
		String sql_query                ="";
		altdisp=new ArrayList();
		String code2, status, frmtime, totime;

		if (altdisp != null){
			altdisp.clear();
		}
		altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
		try{
			connection	= getConnection() ;
			if(!routcode.equals("")){
				sql_query   =PhRepository.getPhKeyValue( "SQL_PH_BL_ORDER_ROUTING_SELECT14");
				pstmt = connection.prepareStatement(sql_query) ;
				pstmt.setString(1,order_fcy.trim());
				pstmt.setString(2,order_src_type.trim());
				pstmt.setString(3,order_src_code.trim());
				pstmt.setString(4,perform_fcy.trim());
				pstmt.setString(5,day_type.trim());
				pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(7,routlevel.trim());
				pstmt.setString(8,routcode.trim());
				pstmt.setString(9,id.trim());// added for MMS_BETA_0043[046240];
			}
			else{
				sql_query   = PhRepository.getPhKeyValue("SQL_PH_BL_ORDER_ROUTING_SELECT15");
				pstmt		= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,order_fcy.trim());
				pstmt.setString(2,order_src_type.trim());
				pstmt.setString(3,order_src_code.trim());
				pstmt.setString(4,perform_fcy.trim());
				pstmt.setString(5,day_type.trim());
				pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(7,routlevel.trim());
				pstmt.setString(8,id.trim());// added for MMS_BETA_0043[046240];
			}
			resultSet			= pstmt.executeQuery();
			while (resultSet.next()) {
				code2=(String)resultSet.getString("ALT_DISP_LOCN_CODE");
				status=(String)resultSet.getString("EFF_STATUS");
				frmtime=(String)resultSet.getString("TIME_FROM");
				totime=(String)resultSet.getString("TIME_TO");
				altdispres.add(code2);
				altdispres.add(status);
				altdispres.add(frmtime);
				altdispres.add(totime);
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
		String code1, eff_status, frm_time, to_time, code;
		HashMap rec1;
		for (int i=0;i<altdisp.size() ;i++ ){	
			rec=(HashMap)altdisp.get((i));
			code	=	(String)rec.get("code");
			int rep=0;
			try{
				rep=Integer.parseInt((String)rec.get("repeat"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int j=0;j<altdispres.size();j+=4){
				code1=(String)altdispres.get((j));
				eff_status=(String)altdispres.get((j+1));
				frm_time=(String)altdispres.get((j+2));
				to_time=(String)altdispres.get((j+3));
				
				if(code.equals(code1)){				
					if(rep==0){
						rec.put("flag","I");
						rec.put("eff_status",eff_status);
						rec.put("totime",to_time);
						rec.put("frmtime",frm_time);
						rec.put("routing_level_code",routlevel);
						rec.put("routing_code",routcode);
						rec.put("disp_locn_code",disp_locn_code);
						rec.put("day_type",day_type);
						rec.put("order_src_type",order_src_type);
						rec.put("perform_fcy",perform_fcy);
						rec.put("order_fcy",order_fcy.trim());
						rec.put("ord_src_code",order_src_code.trim());
						rec.put("id",id.trim());
						rep++;
					}
					else{		
						rec1=new HashMap();
						rec1.put("code",code);
						rec1.put("desc",rec.get("desc"));
						rec1.put("totime",to_time);
						rec1.put("frmtime",frm_time);
						rec1.put("flag","I");
						rec1.put("eff_status","E");
						rec1.put("repeat",new Integer(rep).toString());
						rec1.put("routing_level_code",routlevel);
						rec1.put("routing_code",routcode);
						rec1.put("disp_locn_code",disp_locn_code);
						rec1.put("day_type",day_type);
						rec1.put("order_src_type",order_src_type);
						rec1.put("perform_fcy",perform_fcy);
						rec1.put("order_fcy",order_fcy.trim());
						rec1.put("ord_src_code",order_src_code.trim());
						rec1.put("id",id.trim());
						rep++;
						altdisp.add(i,rec1);
						i++;
						rec1=null;
					}
				}
			}
		}
		return altdisp;
	}

	public ArrayList getLocns( String order_src_type, String perform_fcy,String Ordering_Facility,String flag ) {
		Connection connection		= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet				= null ;
		ArrayList ordSrcLocns			= new ArrayList();
		altdisp=new ArrayList();
		try {
			connection = getConnection() ;
			if (perform_fcy.equals("") && order_src_type.equals("N")) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT2" )) ;
				pstmt.setString(1, Ordering_Facility.trim());
				pstmt.setString(2, getLanguageId());
			}
			else if (perform_fcy.equals("") && order_src_type.equals("C")) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT3" )) ;
				pstmt.setString(1, Ordering_Facility.trim());
				pstmt.setString(2,getLanguageId());
			}
			else {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT4" )) ;
				altdisp=new ArrayList();
				pstmt.setString(1, perform_fcy.trim());
				pstmt.setString(2, order_src_type.trim());
				pstmt.setString(3, getLanguageId());
			}
			resultSet = pstmt.executeQuery() ;
			String code,type,desc;
			HashMap record = null;
			while (resultSet.next()) {
				record	=	new HashMap();
				code=resultSet.getString("LOCN_CODE");
				ordSrcLocns.add(code);
				if (!perform_fcy.equals("")) {
					type=resultSet.getString("DISP_LOCN_TYPE");
					ordSrcLocns.add(type);
				}
				desc=resultSet.getString("SHORT_DESC");
				ordSrcLocns.add(desc);
				record.put("code",code);
				record.put("desc",desc);
				record.put("totime","");
				record.put("frmtime","");
				record.put("flag","N");
				record.put("eff_status","E");
				record.put("repeat","0");
				record.put("routing_level_code","");
				record.put("routing_code","");
				record.put("billing_group_id","");
				record.put("customer_group_id","");
				record.put("policy_type_id","");
				record.put("disp_locn_code","");
				record.put("day_type","");
				record.put("order_src_type","");
				record.put("perform_fcy","");
				record.put("order_fcy","");
				record.put("ord_src_code","");
				record.put("id","");
				altdisp.add(record);
				tempaltdisp.add(record);
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
		if(flag.equals("1"))
		   return ordSrcLocns;
		else
			return altdisp;
	}

    public ArrayList selectedlocn(String alt_disp_code,String frmtime,String totime,String flag,String eff_status,String repeat,String id,String order_src_type,String   ord_src_code,String perform_fcy,String order_fcy,String day_type,String disp_locn_code,String routing_level_code,String routing_code_alt,String billing_group_id,String customer_group_id,String customer_id,String policy_type_id,String mode,String tmplDtlString){
		
		HashMap rec=new HashMap();
		String temp="";
		HashMap new1;
		ArrayList altdisplocns1=null;
		HashMap stat= null;
		HashMap rtn=null;
		HashMap D=null;
		String key , code;  // repeat1; Removed for IN063877
		Set keyset;
		Iterator keyiterator = null;
		StringTokenizer stTmplDtl = new StringTokenizer(tmplDtlString,"~");
		ArrayList sldScaleTmplDtl = new ArrayList();
		HashMap tempAltDispDtls = new HashMap();
		HashMap tempaltdisp			=new HashMap();
		altdisp=new ArrayList();
		if (altdisp != null){
			altdisp.clear();
		}
		altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
		int temp_count = 0;
		while(stTmplDtl.hasMoreTokens()){
			temp_count++;
			temp = stTmplDtl.nextToken();
			if(temp_count % 5 == 0)
				temp = temp;
			sldScaleTmplDtl.add(temp);
		}
		for (int i=0;i<altdisp.size() ;i++ ){
			if(mode.equals("UPDATE")){
				altdisplocns1=new ArrayList();
				stat= new HashMap();
				rtn=new HashMap();
				D=new HashMap();
				altdisplocns1=getAltDispData();
				for(int k=0;k<altdisplocns1.size();k+=3){
					rtn=(HashMap)altdisplocns1.get(k);
					stat=(HashMap)altdisplocns1.get(k+1);
					D=(HashMap)altdisplocns1.get(k+2);
				}
				if( id.equals("S") && (stat!=null || !stat.equals(""))){
					keyset = stat.keySet() ;
					if(keyset.size()>0){
						 keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(disp_locn_code)){
								tempaltdisp  = (HashMap)stat.get(key);
							}
						}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						 keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(routing_level_code+"~"+routing_code_alt+"~"+billing_group_id+"~"+disp_locn_code+"~"+day_type)){
								altdisp  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else
						altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
				}
				if(id.equals("R") && (rtn!=null || !rtn.equals(""))){
					keyset = rtn.keySet() ;
					if(keyset.size()>0){
						keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(disp_locn_code)){
								tempaltdisp  = (HashMap)rtn.get(key);
							}
						}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						 keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(routing_level_code+"~"+routing_code_alt+"~"+billing_group_id+"~"+disp_locn_code+"~"+day_type)){
								altdisp  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else{
						altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
					}
				}
				if(id.equals("D")  && !(D==null || D.equals(""))){
						keyset = D.keySet() ;
					if(keyset.size()>0){
						 keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(disp_locn_code)){
								tempaltdisp  = (HashMap)D.get(key);
							}
						}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						 keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(routing_level_code+"~"+routing_code_alt+"~"+billing_group_id+"~"+disp_locn_code+"~"+day_type)){
								altdisp  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else
					   altdisp=getLocns(order_src_type,perform_fcy,order_fcy,"");
				}
			}
			rec=(HashMap)altdisp.get((i));
			code	=	(String)rec.get("code");
			int rep=0;
			try{
				rep=Integer.parseInt((String)rec.get("repeat"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for (int j=0;j<sldScaleTmplDtl.size();j+=5){
				alt_disp_code=(String)sldScaleTmplDtl.get((j));
				frmtime=(String)sldScaleTmplDtl.get((j+1));
				totime=(String)sldScaleTmplDtl.get((j+2));
				eff_status=(String)sldScaleTmplDtl.get((j+3));
				repeat=(String)sldScaleTmplDtl.get((j+4));
				if(code.equals(alt_disp_code) ){
					if(rep==0){
						rec.put("flag",flag);
						rec.put("frmtime",frmtime);
						rec.put("totime",totime);
						rec.put("eff_status",eff_status);
						rec.put("routing_level_code",routing_level_code);
						rec.put("routing_code",routing_code_alt);
						rec.put("billing_group_id",billing_group_id);
						rec.put("customer_group_id",customer_group_id);
						rec.put("customer_id",customer_id);
						rec.put("policy_type_id",policy_type_id);
						rec.put("disp_locn_code",disp_locn_code);
						rec.put("day_type",day_type);
						rec.put("order_src_type",order_src_type);
						rec.put("perform_fcy",perform_fcy);
						rec.put("order_fcy",order_fcy.trim());
						rec.put("ord_src_code",ord_src_code.trim());
						rec.put("id",id.trim());
						rep++;
					}
					else{	
						new1=new HashMap();
						new1.put("code",alt_disp_code);
						new1.put("desc",rec.get("desc"));
						new1.put("totime",totime);
						new1.put("frmtime",frmtime);
						new1.put("flag","I");
						new1.put("eff_status","E");
						new1.put("repeat",new Integer(rep).toString());	
						new1.put("routing_level_code",routing_level_code);
						new1.put("routing_code",routing_code_alt);
						new1.put("billing_group_id",billing_group_id);
						new1.put("customer_group_id",customer_group_id);
						new1.put("customer_id",customer_id);
						new1.put("policy_type_id",policy_type_id);
						new1.put("disp_locn_code",disp_locn_code);
						new1.put("day_type",day_type);
						new1.put("order_src_type",order_src_type);
						new1.put("perform_fcy",perform_fcy);
						new1.put("order_fcy",order_fcy.trim());
						new1.put("ord_src_code",ord_src_code.trim());
						new1.put("id",id.trim());
						rep++;
						altdisp.add(i,new1);
						i++;
						new1=null;
					}
				}
			}
		}
		tempAltDispDtls.put(routing_level_code+"~"+routing_code_alt+"~"+billing_group_id+"~"+disp_locn_code+"~"+day_type,altdisp);
		if(id.equals("R"))// added for MMS_BETA_0043[046240]; start
			disp_locn_code=disp_locn_code+"~R";
		else if(id.equals("S"))
			disp_locn_code=disp_locn_code+"~S";
		else if(id.equals("D"))
			disp_locn_code=disp_locn_code+"~D";		//added for MMS_BETA_0043[046240]; end
		if(id.equals("R")){
			setaltdisplocndetailsrtn(disp_locn_code, tempAltDispDtls);
		}
		else if(id.equals("S")){
			if(altdispdetailsrtn.containsKey(disp_locn_code)){
				altdispdetailsrtn.clear();
				setaltdisplocndetailsrtn(disp_locn_code, tempAltDispDtls);
			}
			else
				setaltdisplocndetailsstat(disp_locn_code, tempAltDispDtls);
		}
		else if(id.equals("D")){
			
			if(altdispdetailsrtn.containsKey(disp_locn_code)){
				altdispdetailsrtn.clear();
				setaltdisplocndetailsrtn(disp_locn_code, tempAltDispDtls);
			}
			else
				setaltdisplocndetailsD(disp_locn_code, tempAltDispDtls);
		}
        
		getAltDispData();
		return altdisp;
	}

	public void clearAltdispdata(String id){
		if(id.equals("R")){
			altdispdetailsrtn=new HashMap();
		}
		else if(id.equals("S")){
			 altdispdetailsstat=new HashMap();
		}
		else if(id.equals("D")){
			altdispdetailsD=new HashMap();
		}
	}
	public String TimeChk() {
		Connection connection	         = null ;
		ResultSet resultSet				 = null;
		PreparedStatement cstmt		 = null ;
		StringBuffer st						 = new StringBuffer();
		String res="ss";
		HashMap	record = null;
		for(int i=0; i<altdisp.size(); i++) {
			record = (HashMap)altdisp.get(i);
			if((((String)record.get("frmtime"))!="") && (((String)record.get("totime"))!="")) {
				if(((String)record.get("eff_status")).equals("E")){
					st.append((String)record.get("frmtime"));
                    st.append(",");
			        st.append((String)record.get("totime"));
			        st.append(",");			
				}
			}
		}
		String se = st.toString();
		try {
			connection		= getConnection() ;
			cstmt= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1F" )) ;
			cstmt.setString(1, se);
			resultSet = cstmt.executeQuery();
			
			while (resultSet.next()) {
				res	= resultSet.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
			 
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement(cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return res;
	}
}
