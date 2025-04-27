/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class TokenSeriesBean extends PhAdapter implements Serializable {

	protected Hashtable hashMultiple;
	protected String disp_locn_code		="";
	protected String disp_locn_desc		="";
	protected String token_series_code	="";
	protected String token_series_desc	="";
	protected String start_serial_no	="";
	protected String next_serial_no		="";
	protected String eff_status			="";
	protected String applicable_sex_ind	="";
	protected String nationality_ind	="";
	protected String Genera_Upon	="";
	protected String allow_to_change	="";
	protected String gen_token			="";
	protected String token_gen_stage	="";
	protected String QMS_required_yn	="N";	//Added for Bru-HIMS-CRF-076 [IN:029942]
	protected String QMS_edit_token_yn	="N";	//Added for Bru-HIMS-CRF-076 [IN:029942]
	protected int countVal			=0;

	public TokenSeriesBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
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
		map.put( "message", "success..." ) ;
		return map;
	}
	/* Get Methods Start */
	public String getDispLocnCode(){
		return this.disp_locn_code;
	}
	public String getDispLocnDesc(){
		return this.disp_locn_desc;
	}
	public String getTokenSeriesCode(){
		return this.token_series_code;
	}
	public String getTokenSeriesDesc(){
		return this.token_series_desc;
	}
	public String getStartSeriesNo(){
		return this.start_serial_no;
	}
	public String getNextSerialNo(){
		return this.next_serial_no;
	}
	public String allowToChange(){
		return this.allow_to_change;
	}
	public String getEffStatus(){
		return this.eff_status;
	}

    public String getGenToken(){

		return this.gen_token;
	}

	public String getApplicableSexInd(){
		return this.applicable_sex_ind;
	}
	public String getNationalityInd(){
		return this.nationality_ind;
	}

	public String getLoggedInFacility() {
		return login_facility_id;
	}

	public void setTokenGenStage(String  token_gen_stage){
		this.token_gen_stage=token_gen_stage;
	}

	public String getTokenGenStage(){
      return this.token_gen_stage;
	}

    public void setCountValue(int countVal){
		this.countVal=countVal;
	}

	 public int getCountValue(){
		return countVal;
	}
 
	public void setGeneraUpon(String Genera_Upon){
		this.Genera_Upon=Genera_Upon;
	}

	 public String getGeneraUpon(){
		return Genera_Upon;
	}
	//Added for Bru-HIMS-CRF-076 [IN:029942] - start
	public void setQMSReq(String QMS_required_yn){
		this.QMS_required_yn=QMS_required_yn;
	}

	 public String getQMSReq(){
		return QMS_required_yn;
	}
	public void setQMSEditToken(String QMS_edit_token_yn){
		this.QMS_edit_token_yn=QMS_edit_token_yn;
	}

	 public String getQMSEditToken(){
		return QMS_edit_token_yn;
	}
	//Added for Bru-HIMS-CRF-076 [IN:029942] - end
	/* Get Methods End */
	
	// setAll method to set all the values
	public void setAll(Hashtable recordSetMultiple){
System.err.println("=====recordSetMultiple====>"+recordSetMultiple);
		this.mode =(String)recordSetMultiple.get("mode");		
		if (mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
			hashMultiple = recordSetMultiple ;
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
			if(recordSetMultiple.containsKey("disp_locn_code"))
				disp_locn_code = (String)recordSetMultiple.get("disp_locn_code") ;
			if(recordSetMultiple.containsKey("token_series_code"))
				token_series_code = (String)recordSetMultiple.get("token_series_code") ;
			if(recordSetMultiple.containsKey("token_series_desc"))
				token_series_desc = (String)recordSetMultiple.get("token_series_desc") ;
			if(recordSetMultiple.containsKey("start_serial_no"))
				start_serial_no = (String)recordSetMultiple.get("start_serial_no") ;
			
			if(recordSetMultiple.containsKey("Genera_Upon"))
				Genera_Upon = (String)recordSetMultiple.get("Genera_Upon") ;
			//Added for Bru-HIMS-CRF-076 [IN:029942] -start
			if(recordSetMultiple.containsKey("QMS_required")){
				QMS_required_yn = (String)recordSetMultiple.get("QMS_required") ;
				if (QMS_required_yn == null || QMS_required_yn.equals(""))
					QMS_required_yn = "N";
				else
					QMS_required_yn = "Y";
			}
			if(recordSetMultiple.containsKey("QMS_edit_token")){
				QMS_edit_token_yn = (String)recordSetMultiple.get("QMS_edit_token") ;
				if (QMS_edit_token_yn == null || QMS_edit_token_yn.equals(""))
					QMS_edit_token_yn = "N";
				else
					QMS_edit_token_yn = "Y";
			}
			//Added for Bru-HIMS-CRF-076 [IN:029942] -end
			if(recordSetMultiple.containsKey("eff_status")){
				eff_status = (String)recordSetMultiple.get("eff_status") ;
				if (eff_status == null || eff_status.equals("")){
					eff_status = "D";
				}
				else{
					eff_status = "E";
				}
			}            

			if(recordSetMultiple.containsKey("gen_token")){
				gen_token = (String)recordSetMultiple.get("gen_token") ;

				if (gen_token == null || gen_token.equals("")){
					gen_token = "N";
				}else{
					gen_token = "Y";
				}
			}
			if(recordSetMultiple.containsKey("applicable_sex_ind"))
				applicable_sex_ind = (String)recordSetMultiple.get("applicable_sex_ind") ;
			if(recordSetMultiple.containsKey("nationality_ind"))
				nationality_ind = (String)recordSetMultiple.get("nationality_ind") ;

			if(recordSetMultiple.containsKey("Genera_Upon"))
				Genera_Upon = (String)recordSetMultiple.get("Genera_Upon") ;
		}
	} 
		
// insert Method  starts here...
	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		HashMap sqlMap = new HashMap() ; 
		HashMap tabData = new HashMap() ;
		try{

			for(int i=0; i<10;i++){
				String select				= "select"+i;
				String token_series_code	= "token_series_code"  + i ;
				String description			= "description"  + i ;

				ArrayList insertRow = new ArrayList() ;
				ArrayList whereRow = new ArrayList() ;
				if (((String)hashMultiple.get(select)).trim().equals("E")){
					if(!((((String)hashMultiple.get(token_series_code))).trim().equals("")|| (((String)hashMultiple.get(description))).trim().equals("") )){
						insertRow.add( login_facility_id     ) ;
						insertRow.add( (String)hashMultiple.get(   "disp_locn_code" )  ) ;
						insertRow.add( (String)hashMultiple.get(  ("token_series_code" + i))) ;
						insertRow.add( (String)hashMultiple.get(  ("description" + i))) ;
						insertRow.add( (String)hashMultiple.get(  ("start_serial_no" + i)) ) ;
						insertRow.add( (String)hashMultiple.get(  ("start_serial_no" + i) ) ) ;
						insertRow.add( (String)hashMultiple.get(  ("applicable_sex_ind" + i)) ) ;
						insertRow.add( (String)hashMultiple.get(  ("nationality_ind" + i)) ) ;						
						
						insertRow.add( (String)hashMultiple.get(  ("Genera_Upon" + i)) ) ;						

						if( ((String)hashMultiple.get(("eff_status" + i))).equals("") )
							insertRow.add(  "D"  ) ;
						else
							insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)) ) ;

						if( ((String)hashMultiple.get(("gen_token" + i))).equals("") )
							insertRow.add(  "N"  ) ;
						else
							insertRow.add( (String)hashMultiple.get(  ("gen_token" + i)) ) ;

						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						insertRow.add( login_by_id ) ;
						insertRow.add( login_at_ws_no ) ;
						insertRow.add( login_facility_id ) ;
						//Added for Bru-HIMS-CRF-076 [IN:029942] - start
						if(hashMultiple.get("QMS_required" + i)==null ||  ((String)hashMultiple.get(("QMS_required" + i))).equals("") )
							insertRow.add(  "N"  ) ;
						else
							insertRow.add( (String)hashMultiple.get("QMS_required" + i) ) ;

						if(hashMultiple.get("QMS_edit_token" + i)==null || ((String)hashMultiple.get("QMS_edit_token" + i)).equals("") )
							insertRow.add(  "N"  ) ;
						else
							insertRow.add( (String)hashMultiple.get(  "QMS_edit_token" + i) ) ;
						//Added for Bru-HIMS-CRF-076 [IN:029942] - end
						whereRow.add( (String)hashMultiple.get("disp_locn_code"  ) ) ;
						whereRow.add( (String)hashMultiple.get( "token_series_code" + i ) ) ;
						/* note:-
						The insertData and whereData should be arraylist of arraylist
						in case of insertMultiple() of SingleTableHandler
						*/
						insertData.add( insertRow ) ;
						whereData.add( whereRow ) ;
					}
				}
			}//for
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_SELECT4" ) );
			
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_INSERT") );
	
	//sqlMap.put( "InsertSQL", "INSERT INTO PH_TOKEN_SERIES(FACILITY_ID, DISP_LOCN_CODE, TOKEN_SERIES_CODE, DESCRIPTION,NEXT_SERIAL_NO,START_SERIAL_NO, APPLICABLE_SEX_IND, NATIONALITY_IND,TOKEN_GEN_STAGE, EFF_STATUS,GEN_TOKEN_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
			/*SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;
			
			InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
			map = remote.singleBatchHandler( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
		System.err.println("tabData------>"+tabData);

			map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	System.err.println("map------>"+map);

			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			}
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else{
					map.put( "message", (map.get("msgid"))) ;
				}
			}
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
			System.err.println("===========hashMultiple==>"+hashMultiple);
		}
		map.put("flag","0");
		return map ;
	}//insert ends

	public HashMap modify() {
		
		StringBuffer debug = new StringBuffer();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList modifyData = new ArrayList() ;

		modifyData.add( token_series_desc.trim() ) ;
		modifyData.add( start_serial_no.trim() ) ;
		modifyData.add( start_serial_no.trim() ) ;
		modifyData.add( applicable_sex_ind.trim() ) ;
		modifyData.add( nationality_ind.trim() ) ;
		modifyData.add( eff_status.trim() ) ;
		modifyData.add( gen_token.trim() ) ;
		modifyData.add( Genera_Upon.trim() ) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( QMS_required_yn.trim() ) ;	//Added for Bru-HIMS-CRF-076 [IN:029942]
		modifyData.add( QMS_edit_token_yn.trim() ) ;	//Added for Bru-HIMS-CRF-076 [IN:029942]
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( disp_locn_code.trim() ) ;	
		modifyData.add( token_series_code.trim() ) ;
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

 //   System.err.println("tabData------->"+tabData);


		HashMap sqlMap = new HashMap() ;
		try{
			//sqlMap.put( "ModifySQL","UPDATE PH_TOKEN_SERIES SET DESCRIPTION = ?,  NEXT_SERIAL_NO = ?, START_SERIAL_NO = ?, APPLICABLE_SEX_IND = ? , NATIONALITY_IND = ? , EFF_STATUS = ?,GEN_TOKEN_YN=? ,TOKEN_GEN_STAGE=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND TOKEN_SERIES_CODE = ? ");
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
		try {
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
			map = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
		System.err.println("tabData------>"+tabData);

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		System.err.println("map------>"+map);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag","0");
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag","0");
			}
		}
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			map.put( "flag","0");
			e.printStackTrace() ;
		} 
		map.put("flag",debug.toString());
		System.err.println("map------>"+map);
		return map ;	
	}


public int getCount(String facility_id,String disp_code){
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 dispCount		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_COUNT") ) ;
			//pstmt				= connection.prepareStatement("Select nvl(count(*),0) cnt from ph_token_series where facility_id = ? and disp_locn_code = ? and token_gen_stage = 'OR'") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					dispCount	=	resultSet.getInt("cnt");

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("dispCount----bean---->"+dispCount);
		return dispCount;	
	}
public int getGenTokenUponCount(String facility_id,String disp_code){
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 GenTokenUponCount		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_COUNT2") ) ;
			//pstmt				= connection.prepareStatement("Select nvl(count(*),0) cnt from ph_token_series where facility_id = ? and disp_locn_code = ? and token_gen_stage = 'RI' ") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					GenTokenUponCount	=	resultSet.getInt("cnt");

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("dispCount----bean---->"+dispCount);
		return GenTokenUponCount;	
	}




public int getReturnMediCount(String facility_id,String disp_code){
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 ReturnMediCount		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_COUNT3") ) ;
			//pstmt				= connection.prepareStatement("Select nvl(count(*),0) cnt from ph_token_series where facility_id = ? and disp_locn_code = ? and token_gen_stage = 'RM' ") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					ReturnMediCount	=	resultSet.getInt("cnt");

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("dispCount----bean---->"+dispCount);
		return ReturnMediCount;	
	}

public int getDirectDispCount(String facility_id,String disp_code){
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 DirectDispCount		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_COUNT4") ) ;
			//pstmt				= connection.prepareStatement("Select nvl(count(*),0) cnt from ph_token_series where facility_id = ? and disp_locn_code = ? and token_gen_stage = 'DD' ") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					DirectDispCount	=	resultSet.getInt("cnt");

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("dispCount----bean---->"+dispCount);
		return DirectDispCount;	
	}

public ArrayList GenTokenUponYN(String facility_id,String disp_code,String locale){
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		ArrayList	 GenTokenUponYN	= new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_GENTOKEN_YN") ) ;
			//pstmt				= connection.prepareStatement("SELECT  GEN_TOKEN_UPON_REISSUE_YN,GEN_TOKEN_UPON_RET_MEDN_YN,GEN_TOKEN_UPON_DIR_DISP_YN  FROM PH_DISP_LOCN_LANG_VW WHERE FACILITY_ID = ? AND  DISP_LOCN_CODE=?  AND  LANGUAGE_ID=? ") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			pstmt.setString(3,locale.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					GenTokenUponYN.add(resultSet.getString("GEN_TOKEN_UPON_REISSUE_YN"));
					GenTokenUponYN.add(resultSet.getString("GEN_TOKEN_UPON_RET_MEDN_YN"));
					GenTokenUponYN.add(resultSet.getString("GEN_TOKEN_UPON_DIR_DISP_YN"));

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("dispCount----bean---->"+dispCount);
		return GenTokenUponYN;	
	}

	public int getQueryVal(String facility_id,String disp_code,String token_series_code,String token_gen_stage,String status){ //Added new Parameter 'status' and 'token_gen_stage' for [IN032818]
	//System.err.println("in side method");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 QueryCount		=0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_NEW_COUNT1") ) ;
			//pstmt				= connection.prepareStatement("Select nvl(count(*),0) cnt  from ph_token_series where facility_id =? and disp_locn_code = ? and token_gen_stage in ('OR','RI','RM','DD') and token_series_code != ?") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			pstmt.setString(3,token_gen_stage.trim()); //  Added  for [IN032818]
			pstmt.setString(4,token_series_code.trim());
			pstmt.setString(5,status.trim()); //  Added  for [IN032818]
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null && resultSet.next() ) {
					QueryCount	=	resultSet.getInt("cnt");

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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		//System.err.println("QueryCount----bean---->"+QueryCount);
		return QueryCount;	
	}
//[IN032818]  Added New Method to,Get Count and Medication Value --- Begin 
	public HashMap getCountForTokenGenStages(String facility_id,String disp_code,String token_series_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		int	 stageCount		=0;
		String GenStage="";
		HashMap result=new HashMap();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_STAGE_WISE_COUNT") ) ;
			
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_code.trim());
			pstmt.setString(3,token_series_code.trim());
			
			resultSet	= pstmt.executeQuery(); 
			if ( resultSet != null ) {
				while(resultSet.next() ){
					stageCount	=	resultSet.getInt("CNT");
					GenStage = 	resultSet.getString("TOKEN_GEN_STAGE");
					result.put(GenStage, stageCount);
				}
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
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;	
	}

//[IN032818]  Added New Method to,Get Count and Medication Value --- End

	public ArrayList getDispLocForList() throws Exception {  
		
		ArrayList arrList = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_SELECT3") );
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null ){
				while ( resultSet.next() ) {
					arrList.add(resultSet.getString("DISP_LOCN_CODE"));
					arrList.add(resultSet.getString("SHORT_DESC"));
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return arrList;
	}
	
	public HashMap delete() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map ;
	}
	          
	public void loadData(String disp_locn_code,String token_series_code) throws Exception {
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TOKEN_SERIES_SELECT2") );
			pstmt.setString(1, login_facility_id.trim() ) ;
			pstmt.setString(2, disp_locn_code.trim() ) ;
			pstmt.setString(3, token_series_code.trim() ) ;
			pstmt.setString(4, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				disp_locn_code		=	resultSet.getString("DISP_LOCN_CODE" );
				disp_locn_desc		=	resultSet.getString("SHORT_DESC" );
				token_series_code	=	resultSet.getString("TOKEN_SERIES_CODE" );
				token_series_desc	=	resultSet.getString("DESCRIPTION" );
				start_serial_no		=	resultSet.getString("START_SERIAL_NO" )==null?"":resultSet.getString("START_SERIAL_NO" );
				next_serial_no		=   resultSet.getString("NEXT_SERIAL_NO")==null?"":resultSet.getString("NEXT_SERIAL_NO" );
				applicable_sex_ind	=	resultSet.getString("APPLICABLE_SEX_IND" );
				nationality_ind		=	resultSet.getString("NATIONALITY_IND" );
				eff_status			=	resultSet.getString("EFF_STATUS" );
				gen_token			=	resultSet.getString("GEN_TOKEN_YN" );
				QMS_required_yn		=	resultSet.getString("QMS_REQUIRED_YN" );
				QMS_edit_token_yn	=	resultSet.getString("QMS_EDIT_TOKEN_YN" );
				if(start_serial_no.equals(next_serial_no)){
					allow_to_change = "Y";
				}
				else{
					allow_to_change = "N";
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
				es.printStackTrace() ;
			}
		}
	}
}
