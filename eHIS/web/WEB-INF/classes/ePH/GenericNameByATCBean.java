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
	Function	 : Generic Name
	Class Name	 : GenericNameByATCBean
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
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.GenericNameByATC.*;
import ePH.GenericNameByPharmaco.*;


//saved on 27/10/2005
public class GenericNameByATCBean extends PhAdapter implements Serializable {

	java.util.ArrayList arrListForInsert=null;
	java.util.ArrayList arrListForDelete=null;
	java.util.ArrayList arrListForInsertNew=null;
	java.util.ArrayList arrListATCUpdate=null;
	java.util.ArrayList arrListATCUpdate1=null;

	protected String generic_id="";
	protected String generic_name="";
	protected String drug_name="";
	protected String eff_status="";
	protected String called="";
	protected String call_from="";
	private HashMap ATCUpdateMap = new HashMap();
	public GenericNameByATCBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear() ;
		ATCUpdateMap.clear(); 
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	public HashMap validate() throws Exception {

			HashMap map=new HashMap();
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", "success.." ) ;

			String strGenericName="";
			StringTokenizer stGeneric=new StringTokenizer(getGenericName()," ");
			while (stGeneric.hasMoreTokens()){
				strGenericName += " "+stGeneric.nextToken();
			}
			setGenericName(strGenericName.trim());


			String action = getMode();

			if(action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){

				Connection connection = null ;
				PreparedStatement pstmt = null ;
				ResultSet resultSet = null ;
				try {
					connection = getConnection() ;
					pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT6") );
					pstmt.setString(1,strGenericName.trim());
					resultSet = pstmt.executeQuery() ;
					if( resultSet.next() ){
					if (resultSet.getInt(1)>0)
						{
							map.put( "result", new Boolean( false ) ) ;
							map.put( "message", getMessage("PH_GENERIC_NAME_DUP") ) ;
						}
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
					}
				}
			}

		return map;
	}

	 public void setToATCUpdateMap(int index, String indexValue){
		if (! ATCUpdateMap.containsKey(index))
		{
			ATCUpdateMap.put(index,indexValue);
		}
	}

	public HashMap getATCUpdateMap(){
		return ATCUpdateMap;
	}

	/* Set Methods Start */
	public void setGenericName(String generic_name){
		this.generic_name=generic_name;
	}
	public void setDrugName(String drug_name){
		this.drug_name=drug_name;
	}
	public void setEffStatus ( String eff_status ){
		if(eff_status.equals("") || eff_status==null )
			this.eff_status = "D" ;
		else
			this.eff_status = eff_status ;
	}
	public void setCalled ( String called ){
		if(called.equals("") || called==null )
			this.called = "D" ;
		else
			this.called = called ;
	}
	public void setGenericId(String generic_id){
		this.generic_id=generic_id;
	}
    public void setCallFrom(String call_from){
		this.call_from=call_from;
	}
    public void setATCUpdatedValues(ArrayList arrListATCUpdate){
	this.arrListATCUpdate = arrListATCUpdate;
	}
	public void setUpdateByATCList(ArrayList arrListATCUpdate1){
	this.arrListATCUpdate1 = arrListATCUpdate1;
	}
	/* Set Methods End */

	/* Get Methods Start */
	public String getGenericName(){
		return generic_name;
	}
	public String getDrugName(){
		return drug_name;
	}
	public String getEffStatus(){
		return eff_status;
	}
	public String getCalled(){
		return called;
	}
	public String getGenericId(){
		return generic_id;
	}
	public ArrayList getATCUpdatedValues(){
	 return arrListATCUpdate;
	}
	public ArrayList getUpdateByATCList(){
	 return arrListATCUpdate1;
	}
	public String getCallFrom(){
	 return call_from;
	}
	/* Get Methods End */

	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		String action = getMode();
		
		arrListForInsert=new ArrayList();
		arrListForInsertNew = new ArrayList();
		arrListForDelete    = new ArrayList();

		if ( action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
			String called_from = "";
			if(recordSet.containsKey("generic_name"))
				setGenericName((String)recordSet.get("generic_name")) ;
			if(recordSet.containsKey("drug_name"))
				setDrugName((String)recordSet.get("drug_name")) ;
			if(recordSet.containsKey("eff_status"))
				setEffStatus((String)recordSet.get("eff_status")) ;
			if(recordSet.containsKey("called"))
				setCalled((String)recordSet.get("called")) ;
			called_from=(String)recordSet.get("called");
			int noOfRecords;
			if (called_from.equals("pharma"))
			{
				 noOfRecords= (recordSet.size()-5)/3;
			}else
			{
				 noOfRecords= (recordSet.size()-7)/5;
			}

			for(int i=1;i<=noOfRecords;i++)
			{
				String insert="";
				if(recordSet.containsKey("select"+i)){
					 insert=(String)recordSet.get("select"+i);
				}
				if (insert.equals("Y"))
				{
					String[] record=new String[5];
					if (recordSet.containsKey("atc_class_lev1_code"+i))
					{
						record[0]=(String)recordSet.get("atc_class_lev1_code"+i);
					}
					if (recordSet.containsKey("atc_class_lev2_code"+i))
					{
						record[1]=(String)recordSet.get("atc_class_lev2_code"+i);
					}
					if (recordSet.containsKey("atc_class_lev3_code"+i))
					{
						record[2]=(String)recordSet.get("atc_class_lev3_code"+i);
					}
					if (recordSet.containsKey("atc_class_lev4_code"+i))
					{
						record[3]=(String)recordSet.get("atc_class_lev4_code"+i);
					}
					if (recordSet.containsKey("atc_class_lev5_code"+i))
					{
						record[4]=(String)recordSet.get("atc_class_lev5_code"+i);
					}
					arrListForInsert.add(record);
				}
			}
		}
		if ( action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {

			if(recordSet.containsKey("generic_name"))
				setGenericName((String)recordSet.get("generic_name")) ;

			if(recordSet.containsKey("drug_name"))
				setDrugName((String)recordSet.get("drug_name")) ;
			if(recordSet.containsKey("eff_status"))
				setEffStatus((String)recordSet.get("eff_status")) ;
			if (recordSet.containsKey("generic_id"))
				setGenericId((String)recordSet.get("generic_id"));

			int noOfRecords= (recordSet.size()-5)/7;

			for (int i=1;i<=noOfRecords ;i++ )
			{
				String insertNEW="";
				String deleteOLD="";
				if(recordSet.containsKey("select"+i)){
					 insertNEW=(String)recordSet.get("select"+i);
				}
				if(recordSet.containsKey("chkdelete"+i)){
					 deleteOLD=(String)recordSet.get("chkdelete"+i);
				}
				if (insertNEW.equals("Y")){
					String[] record=new String[5];
					if (recordSet.containsKey("NEWatc_class_lev1_code"+i)){
						record[0]=(String)recordSet.get("NEWatc_class_lev1_code"+i);
					}
					if (recordSet.containsKey("NEWatc_class_lev2_code"+i)){
						record[1]=(String)recordSet.get("NEWatc_class_lev2_code"+i);
					}
					if (recordSet.containsKey("NEWatc_class_lev3_code"+i)){
						record[2]=(String)recordSet.get("NEWatc_class_lev3_code"+i);
					}
					if (recordSet.containsKey("NEWatc_class_lev4_code"+i)){
						record[3]=(String)recordSet.get("NEWatc_class_lev4_code"+i);
					}
					if (recordSet.containsKey("NEWatc_class_lev5_code"+i)){
						record[4]=(String)recordSet.get("NEWatc_class_lev5_code"+i);
					}
					arrListForInsertNew.add(record);
					//System.out.println("arrListForInsertNew---255->"+arrListForInsertNew);
				}
				if (deleteOLD.equals("Y")){
					String record="";
					if (recordSet.containsKey("sr_no"+i)){
						record=(String)recordSet.get("sr_no"+i);
					}
					arrListForDelete.add(record);
					//System.out.println("arrListForDelete------264----->"+arrListForDelete);
				}
			}
		}
	}

	// insert Method  starts here...
	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
String called_in = getCalled();
if (called_in.equals("pharma"))
			{
		//GenericNameByPharmacoHome   home=null;
		//GenericNameByPharmacoRemote remote=null;
		try{
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );

			tabData.put( "generic_name",generic_name);
			tabData.put( "drug_name",drug_name);
			tabData.put( "eff_status",eff_status);

			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			tabData.put("arrList",arrListForInsert);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_GENERIC_NAME_INSERT",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_INSERT"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_INSERT",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_INSERT"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4"));

			try {
				
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_GENERIC_NAME_BY_PHARMACO_CLASS") ) ;
				home  = (GenericNameByPharmacoHome) PortableRemoteObject.narrow( object, GenericNameByPharmacoHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_GENERIC_NAME_BY_PHARMACO_CLASS" ),GenericNameByPharmacoHome.class,getLocalEJB());
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
					//map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
					map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;

					map.put("flag","0");
				}
				else{
					map.put( "message", result.get("msgid") ) ;
					map.put("flag","0");
				}
			}//try
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}//catch
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			map.put("flag","0");
				}//finally
			}
			else
		{
		//GenericNameByATCHome   home=null;
		//GenericNameByATCRemote remote=null;
		try{
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );

			tabData.put( "generic_name",generic_name);
			tabData.put( "drug_name",drug_name);
			tabData.put( "eff_status",eff_status);

			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			tabData.put("arrList",arrListForInsert);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_GENERIC_NAME_INSERT",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_INSERT"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT4",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT4"));

			try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_GENERIC_NAME_BY_ATC_CLASS") ) ;

				home  = (GenericNameByATCHome) PortableRemoteObject.narrow( object, GenericNameByATCHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_GENERIC_NAME_BY_ATC_CLASS" ),GenericNameByATCHome.class,getLocalEJB());
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
				  // map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
				   map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
					map.put("flag","0");
				}
				else{
					map.put( "message", result.get("msgid") ) ;
					map.put("flag","0");
				}
			}//try
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}//catch
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			map.put("flag","0");
			}//finally
		}
		return map ;
	}

	//modify method starts here

	public HashMap modify() {

  //System.err.println("modify method is calling");
  
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		//GenericNameByATCHome   home=null;
		//GenericNameByATCRemote remote=null;
		try{
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );

			tabData.put( "generic_id",generic_id);
			//--------------------------------------------------------------------------------------
			tabData.put( "generic_name",generic_name);
			//System.err.println("generic_name---bean->"+generic_name);
			
			tabData.put( "drug_name",drug_name);
			//System.err.println("drug_name---bean->"+drug_name);
			
			tabData.put( "eff_status",eff_status);
			tabData.put( "eff_status",eff_status);
            //System.err.println("eff_status---bean->"+eff_status);

			tabData.put( "updateByATC",getATCUpdatedValues()); //updated arraylist
			tabData.put( "call_from",getCallFrom()); //calling from
			
   //-------------------------------------------------------------------------------------------

			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;

			tabData.put("deleteOld",arrListForDelete);
			//System.out.println("deleteOld---->"+arrListForDelete);
			tabData.put("insertNew",arrListForInsertNew);
          // System.out.println("insertNew---->"+arrListForInsertNew);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_GENERIC_NAME_UPDATE",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_UPDATE"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_DELETE",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_DELETE"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT"));
			sqlMap.put("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT4",PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT4"));
			/* @Name - Krishna Kiran 
			 * @Date - 18/12/2009
			 * @Inc# - IN017314
			 * @Desc - SQL_PH_GENERIC_NAME_UPDATE1-- is passed to manager that allows to update the effective status of generic name into PH_GENERIC_NAME when we selected search by ATC Classfication in Query Mode
			 */
			String sqlStr = "UPDATE PH_GENERIC_NAME  SET EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE GENERIC_ID = ?";
			sqlMap.put("SQL_PH_GENERIC_NAME_UPDATE1",sqlStr); 
            
			//System.out.println("sqlMap--->"+sqlMap);
			//System.out.println("tabData--->"+tabData);

			try {
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_GENERIC_NAME_BY_ATC_CLASS") ) ;

				home  = (GenericNameByATCHome) PortableRemoteObject.narrow( object, GenericNameByATCHome.class ) ;
				remote = home.create() ;
				HashMap result = remote.modify( tabData, sqlMap ) ;
*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_GENERIC_NAME_BY_ATC_CLASS" ),GenericNameByATCHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
                 

				 //System.out.println("result-----HashMap----->"+result);

				if( ((Boolean) result.get( "result" )).booleanValue())	{
					map.put( "result", new Boolean( true ) ) ;
				    //map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
					map.put("message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;

								
					
					map.put("flag","0");
				}
				else
				{
					map.put( "message", result.get("msgid") ) ;
					map.put("flag","0");
				}
			}//try
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}//catch
		}//try
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		}//catch
		finally{
			map.put("flag","0");
			}//finally
		return map;
	}

	// This method is used to retrieve the data depending on the query criteria

	public ArrayList getAllByGenericName(String generic_name,String drug_class,String eff_status,String from,String to)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		long count=0;
		long i = 0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT2") );
			pstmt.setString(1,generic_name.trim());
			pstmt.setString(2,drug_class.trim());
			pstmt.setString(3,eff_status.trim());
			pstmt.setString(4,getLanguageId().trim());
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
				String arr[] = new String[4];
				arr[0]=resultSet.getString("GENERIC_ID");
				arr[1]=resultSet.getString("GENERIC_NAME");
				arr[2]=resultSet.getString("DRUG_CLASS");
				arr[3]=resultSet.getString("EFF_STATUS");
			
				records.add(arr);
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(generic_name)+"','"+(drug_class)+"','"+(eff_status)+"')\">Previous</a>" ;

			if( count > 14 )
					prevnextlink += "&nbsp;&nbsp;<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(generic_name)+"','"+(drug_class)+"','"+(eff_status)+"')\">Next</a>" ;
			records.set(0,prevnextlink);
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
			}
		}
		return records;
	}

	// This method is used to get the values on click of the link in query result page...

	public ArrayList getAllValuesForModify(String generic_id,String locale) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList records=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT5") );
			pstmt.setString(1,generic_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ){
				String[] strArr = new String[15];
				strArr[0]  = resultSet.getString("SRL_NO");
				strArr[1]  = resultSet.getString("GENERIC_ID");
				strArr[2]  = resultSet.getString("GENERIC_NAME");
				strArr[3]  = resultSet.getString("DRUG_CLASS");
				strArr[4]  = resultSet.getString("EFF_STATUS");
				strArr[5]  = resultSet.getString("ATC_CLASS_LEV1_CODE");
				strArr[6]  = resultSet.getString("ATC_CLASS_LEV1_DESC");
				strArr[7]  = resultSet.getString("ATC_CLASS_LEV2_CODE");
				strArr[8]  = resultSet.getString("ATC_CLASS_LEV2_DESC");
				strArr[9]  = resultSet.getString("ATC_CLASS_LEV3_CODE");
				strArr[10] = resultSet.getString("ATC_CLASS_LEV3_DESC");
				strArr[11] = resultSet.getString("ATC_CLASS_LEV4_CODE");
				strArr[12] = resultSet.getString("ATC_CLASS_LEV4_DESC");
				strArr[13] = resultSet.getString("ATC_CLASS_LEV5_CODE");
				strArr[14] = resultSet.getString("ATC_CLASS_LEV5_DESC");
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
			}
		}
		return records;
	}

// This is used to get all the values for display...

	/*public ArrayList getAllValuesForDisplay(String atcclassification,String from,String to,String locale) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String strAppend="";

		String prevnextlink			= "";
		int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		long count=0;
		long j = 0;
		
		try {
			StringTokenizer st=new StringTokenizer(atcclassification,"|");
/*			String lev1= st.nextToken();
			String lev2= st.nextToken();
			String lev3= st.nextToken();
			String lev4= st.nextToken();
			String lev5= st.nextToken(); /
			String lev1="",lev2="",lev3="",lev4="",lev5="";
			String lev11="",lev22="",lev33="",lev44="",lev55="";

			if(st.hasMoreTokens())
				 lev1= st.nextToken();
			if(st.hasMoreTokens())
				 lev11= st.nextToken();
			if(st.hasMoreTokens())
				 lev2= st.nextToken();
			if(st.hasMoreTokens())
				 lev22= st.nextToken();
			if(st.hasMoreTokens())
				 lev3= st.nextToken();
			if(st.hasMoreTokens())
				 lev33= st.nextToken();
			if(st.hasMoreTokens())
				 lev4= st.nextToken();
			if(st.hasMoreTokens())
				 lev44= st.nextToken();
			if(st.hasMoreTokens())
				 lev5= st.nextToken();
			if(st.hasMoreTokens())
				 lev55= st.nextToken();

			if (!lev2.equals(" ") && !lev2.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV2_CODE = ? " ;
			}
			if (!lev3.equals(" ") && !lev3.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV3_CODE = ? " ;
			}
			if (!lev4.equals(" ") && !lev4.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV4_CODE = ? " ;
			}
			if (!lev5.equals(" ") && !lev5.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV5_CODE = ? " ;
			}
		
			
			connection = getConnection() ;

			String strSQL = PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT1") + strAppend + " ORDER BY G.GENERIC_NAME";
			System.out.println("strSQL----2---->"+strSQL);
				
			pstmt = connection.prepareStatement( strSQL );
			

			pstmt.setString(1,lev1);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			
			int i=6;
			if (!lev2.equals(" ") && !lev2.equals("")){
				pstmt.setString(++i,lev2);
			}
			if (!lev3.equals(" ") && !lev3.equals("")){
				pstmt.setString(++i,lev3);
			}
			if (!lev4.equals(" ") && !lev4.equals("")){
				pstmt.setString(++i,lev4);
			}
			if (!lev5.equals(" ") && !lev5.equals("")){
				pstmt.setString(++i,lev5);
			}
			System.out.println("lev1=="+lev1+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==lev2=="+lev2+"==lev3=="+lev3+"==lev4=="+lev4+"==lev5=="+lev5);

		resultSet = pstmt.executeQuery() ;
		
			records.add("link");
			while ( resultSet.next() && j <= end+1 ){
				if( start != 1 && (j+1) < start ) {
					j++;
					continue;
				}
				else j++;
				count++ ;
				if(j <= end ) {
					String[] strArr = new String[15];
					strArr[0]  = resultSet.getString("SRL_NO");
					strArr[1]  = resultSet.getString("GENERIC_ID");
					strArr[2]  = resultSet.getString("GENERIC_NAME");
					strArr[3]  = resultSet.getString("DRUG_CLASS");
					strArr[4]  = resultSet.getString("EFF_STATUS");
					strArr[5]  = resultSet.getString("ATC_CLASS_LEV1_CODE");
					strArr[6]  = resultSet.getString("ATC_CLASS_LEV1_DESC");
					strArr[7]  = resultSet.getString("ATC_CLASS_LEV2_CODE");
					strArr[8]  = resultSet.getString("ATC_CLASS_LEV2_DESC");
					strArr[9]  = resultSet.getString("ATC_CLASS_LEV3_CODE");
					strArr[10] = resultSet.getString("ATC_CLASS_LEV3_DESC");
					strArr[11] = resultSet.getString("ATC_CLASS_LEV4_CODE");
					strArr[12] = resultSet.getString("ATC_CLASS_LEV4_DESC");
					strArr[13] = resultSet.getString("ATC_CLASS_LEV5_CODE");
					strArr[14] = resultSet.getString("ATC_CLASS_LEV5_DESC");
					records.add(strArr);


					
				}
			}
		
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLinkForATCClassification('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+atcclassification+"')\">Previous</a>" ;
			if( count > 14 )
					prevnextlink += "&nbsp;&nbsp;<td align='right'><a href=\"javascript:SubmitLinkForATCClassification('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+atcclassification+"')\">Next</a>" ;
			records.set(0,prevnextlink);
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
			}
		}
		return records;

	}*/

	public ArrayList getAllValuesForDisplay1(String atcclassification_codes,String from,String to,String locale) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();	
		String strAppend="";

	//	String prevnextlink			= ""; Removed for IN063877
		int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		//long count=0; Removed for IN063877
		//long j = 0;  Removed for IN063877
		
		try {
			StringTokenizer st=new StringTokenizer(atcclassification_codes,"|");
			String lev1="";
			String lev2="";
			String lev3="";
			String lev4="";
			String lev5="";

			if(st.hasMoreTokens())
				lev1= st.nextToken();
			if(st.hasMoreTokens())
				lev2= st.nextToken();
			if(st.hasMoreTokens())	
				lev3= st.nextToken();
			if(st.hasMoreTokens())	
				lev4= st.nextToken();
			if(st.hasMoreTokens())	
				lev5= st.nextToken();

			if (!lev2.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV2_CODE = ? " ;
			}
			if (!lev3.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV3_CODE = ? " ;
			}
			if (!lev4.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV4_CODE = ? " ;
			}
			if (!lev5.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV5_CODE = ? " ;
			}
					
			connection = getConnection() ;
			String strSQL = PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT1") + strAppend + " ORDER BY G.GENERIC_NAME";
			pstmt = connection.prepareStatement( strSQL );
			pstmt.setString(1,lev1);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			int i=6;
			if (!lev2.equals("")){
				pstmt.setString(++i,lev2);
			}
			if (!lev3.equals("")){
				pstmt.setString(++i,lev3);
			}
			if (!lev4.equals("")){
				pstmt.setString(++i,lev4);
			}
			if (!lev5.equals("")){
				pstmt.setString(++i,lev5);
			}
			
		resultSet = pstmt.executeQuery() ;
		
		if(resultSet.next()){
					records.add(resultSet.getString("ATC_CLASS_LEV1_DESC"));
					records.add(resultSet.getString("ATC_CLASS_LEV2_DESC"));
					records.add(resultSet.getString("ATC_CLASS_LEV3_DESC"));
					records.add(resultSet.getString("ATC_CLASS_LEV4_DESC"));
					records.add(resultSet.getString("ATC_CLASS_LEV5_DESC"));
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
			}
		}
		return records;

	}

	public ArrayList getAllValuesForPharmacoDisplay(String atcclassification,String from,String to) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String strAppend="";

		String prevnextlink			= "";
		int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;

		long count=0;
		long j = 0;

		try {
			StringTokenizer st=new StringTokenizer(atcclassification,"|");
			String lev1= st.nextToken();
			String lev2= st.nextToken();
			String lev3= st.nextToken();

			if (!lev2.equals(" ")){

				strAppend += " AND DRUG_CLASS_DTL_GROUP_NO_1 = ? " ;
			}
			if (! lev3.equals(" ")){
				strAppend += " AND DRUG_CLASS_DTL_GROUP_NO_2 = ? " ;
			}

			strAppend += " ) " ;
			connection = getConnection() ;

			String strSQL = PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_PHARMACO_SELECT") + strAppend ;
			pstmt = connection.prepareStatement( strSQL );

			pstmt.setString(1,lev1);
			int i=1;
			if (!lev2.equals(" ")){
				pstmt.setString(++i,lev2);
			}
			if (!lev3.equals(" ")){
				pstmt.setString(++i,lev3);
			}

			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && j <= end+1 ){
				if( start != 1 && (j+1) < start ) {
					j++;
					continue;
				}
				else j++;
				count++ ;
				if(j <= end ) {
					String[] strArr = new String[3];
					strArr[0]  = resultSet.getString("GENERIC_NAME");
					strArr[1]  = resultSet.getString("DRUG_CLASS");
					strArr[2]  = resultSet.getString("EFF_STATUS");
					records.add(strArr);
				}
				}
			
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLinkForATCClassification('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+atcclassification+"')\">Previous</a>" ;
			if( count > 14 )
					prevnextlink += "&nbsp;&nbsp;<td align='right'><a href=\"javascript:SubmitLinkForATCClassification('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+atcclassification+"')\">Next</a>" ;
			records.set(0,prevnextlink);
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
			}
		}
		return records;

	}

	public String checkForAssociation(String generic_id) throws Exception{

		String result = "Y";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {

			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT7")) ;
			pstmt.setString(1,generic_id.trim());
			resultSet = pstmt.executeQuery();
			if ( resultSet.next() ) {
				if(Integer.parseInt(resultSet.getString("COUNT"))>0){
					result = "N";
				}
			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)		closeStatement( pstmt ) ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT8")) ;
			pstmt.setString(1,generic_id.trim());
			resultSet = pstmt.executeQuery();
			if ( resultSet.next() ) {
				if(Integer.parseInt(resultSet.getString("COUNT"))>0){
					result = "N";
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
			catch(Exception es) { }
		}
		return result;
	}
			/* @Name - Krishna Kiran 
			 * @Date - 18/12/2009
			 * @Inc# - IN017314
			 * @Desc - modified the signature of this method and the  previois signature of the method contains from and to 
			 */
		public ArrayList getAllValuesForDisplay(String atcclassification,String locale) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String strAppend="";

		//String prevnextlink			= "";
		//int query_result_size		= Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
		//int start = 0 ;
		//int end = 0 ;

//		if ( from == null || from.equals(""))
//			start = 1 ;
//		else
//			start = Integer.parseInt( from  ) ;
//
//		if ( to == null || to.equals(""))
//			end =query_result_size;
//		else
//			end = Integer.parseInt( to ) ;
//
//		long count=0;
//		long j = 0;
		
		try {
			StringTokenizer st=new StringTokenizer(atcclassification,"|");
/*			String lev1= st.nextToken();
			String lev2= st.nextToken();
			String lev3= st.nextToken();
			String lev4= st.nextToken();
			String lev5= st.nextToken(); */
			String lev1="",lev2="",lev3="",lev4="",lev5="";
			String lev11="",lev22="",lev33="",lev44="",lev55="";

			if(st.hasMoreTokens())
				 lev1= st.nextToken();
			if(st.hasMoreTokens())
				 lev11= st.nextToken();
			if(st.hasMoreTokens())
				 lev2= st.nextToken();
			if(st.hasMoreTokens())
				 lev22= st.nextToken();
			if(st.hasMoreTokens())
				 lev3= st.nextToken();
			if(st.hasMoreTokens())
				 lev33= st.nextToken();
			if(st.hasMoreTokens())
				 lev4= st.nextToken();
			if(st.hasMoreTokens())
				 lev44= st.nextToken();
			if(st.hasMoreTokens())
				 lev5= st.nextToken();
			if(st.hasMoreTokens())
				 lev55= st.nextToken();

			if (!lev2.equals(" ") && !lev2.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV2_CODE = ? " ;
			}
			if (!lev3.equals(" ") && !lev3.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV3_CODE = ? " ;
			}
			if (!lev4.equals(" ") && !lev4.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV4_CODE = ? " ;
			}
			if (!lev5.equals(" ") && !lev5.equals("")){
				strAppend += " AND A.ATC_CLASS_LEV5_CODE = ? " ;
			}
		
			
			connection = getConnection() ;

			String strSQL = PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT1") + strAppend + " ORDER BY G.GENERIC_NAME";
			//System.out.println("strSQL----2---->"+strSQL);
				
			pstmt = connection.prepareStatement( strSQL );
			

			pstmt.setString(1,lev1);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			
			int i=6;
			if (!lev2.equals(" ") && !lev2.equals("")){
				pstmt.setString(++i,lev2);
			}
			if (!lev3.equals(" ") && !lev3.equals("")){
				pstmt.setString(++i,lev3);
			}
			if (!lev4.equals(" ") && !lev4.equals("")){
				pstmt.setString(++i,lev4);
			}
			if (!lev5.equals(" ") && !lev5.equals("")){
				pstmt.setString(++i,lev5);
			}
			//System.out.println("lev1=="+lev1+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==locale=="+locale+"==lev2=="+lev2+"==lev3=="+lev3+"==lev4=="+lev4+"==lev5=="+lev5);

		resultSet = pstmt.executeQuery() ;
		
			//records.add("link");
			while ( resultSet.next()){
				
					records.add( resultSet.getString("SRL_NO"));
					records.add(resultSet.getString("GENERIC_ID"));
					records.add(resultSet.getString("GENERIC_NAME"));
					records.add(resultSet.getString("DRUG_CLASS"));
					records.add( resultSet.getString("EFF_STATUS"));
					records.add( resultSet.getString("ATC_CLASS_LEV1_CODE"));
					records.add( resultSet.getString("ATC_CLASS_LEV1_DESC"));
					records.add( resultSet.getString("ATC_CLASS_LEV2_CODE"));
					records.add( resultSet.getString("ATC_CLASS_LEV2_DESC"));
					records.add( resultSet.getString("ATC_CLASS_LEV3_CODE"));
					records.add( resultSet.getString("ATC_CLASS_LEV3_DESC"));
					records.add( resultSet.getString("ATC_CLASS_LEV4_CODE"));
					records.add( resultSet.getString("ATC_CLASS_LEV4_DESC"));
					records.add( resultSet.getString("ATC_CLASS_LEV5_CODE"));
					records.add( resultSet.getString("ATC_CLASS_LEV5_DESC"));
					//records.add(strArr);			
				
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
			}
		}
		//System.out.println("records=="+records);
			return records;

	}

}
