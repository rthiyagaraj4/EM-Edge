/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;


public class DrugInformationSourceBean extends PhAdapter implements Serializable {
	

	java.util.Properties p=null;

	protected String code = "";
	protected String description = "";
	protected String display_sequence_no = "";
	protected String eff_status  = "";
	protected String dup_chk  = "";

	//protected String code1 = "";
	//protected String description1 = "";
	//protected String display_sequence_no1 = "";
	//protected String eff_status1  = "";
	protected String dup_chk1  = "";
	//protected String totalRecords ="";

	protected Hashtable hashMultiple;
	
	
	
	public DrugInformationSourceBean() {
		try {
			doCommon();
		}
		catch(Exception e) {}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
		code = "";
		description = "";
		display_sequence_no = "";
		eff_status  = "";
		dup_chk  = "";
		dup_chk1  = "";
		hashMultiple = null;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	
	public void setCode(String code){
		this.code = code; }
	//public void setCode1(String code1){
	//this.code1 = code1;  }



	public void setDescription(String description){
		this.description = description;	}
	//public void setDescription1(String description1){
	//	this.description1 = description1;}



	public void setDisplaysequenceno(String display_sequence_no){
		this.display_sequence_no = display_sequence_no;	}
	//public void setDisplaysequenceno1(String display_sequence_no1){
	//	this.display_sequence_no1 = display_sequence_no1;}



	public void setEffStatus(String eff_status){
		if (eff_status.equals("") || eff_status==null ){
			eff_status="D";	}
		this.eff_status = eff_status;}
   //	public void setEffStatus1(String eff_status1){
	//	if (eff_status1.equals("") || eff_status1==null ){
	//		eff_status1="D";	}
	//		this.eff_status1 = eff_status1;}

	
	public void setDupChk(String dup_chk){
		this.dup_chk = dup_chk;
	}

	public void setDupChk1(String dup_chk1){
		this.dup_chk1 = dup_chk1;
	}

	public String getCode(){
		return code;}
	//public String getCode1(){
	//	return code1;}
		
	public String getDescription(){
		return description;	}
	//public String getDescription1(){
	//	return description1;}


	public String getDisplaysequenceno(){
		return display_sequence_no;	}
	/*public String getDisplaysequenceno1(){
		return display_sequence_no1;}*/

	public String getEffStatus(){
		return eff_status;}
	/*public String getEffStatus1(){
		return eff_status1;	}*/

	public String getDupChk(){
		return dup_chk;
	}
	
	public String getDupChk1(){
		return dup_chk1;
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	// setAll method to set all the values

	
	public void setAll(Hashtable recordSet)
	{

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("code"))
			setCode((String)recordSet.get("code")) ;
		if(recordSet.containsKey("description"))
			setDescription((String)recordSet.get("description")) ;
		if(recordSet.containsKey("display_sequence_no"))
			setDisplaysequenceno((String)recordSet.get("display_sequence_no")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status")) ;
		if(recordSet.containsKey("dup_chk"))
			setDupChk((String)recordSet.get("dup_chk")) ;
		if(recordSet.containsKey("info_dup_chk"))
			setDupChk1((String)recordSet.get("info_dup_chk")) ;

		hashMultiple = recordSet;

	}
/*	
	public void loadData() throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DTL_SELECT") );
			pstmt.setString( 1, getCode1().trim() ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				setCode1( resultSet.getString("CODE" ));
				setDescription1(resultSet.getString("DESCRIPTION" ));
				setDisplaysequenceno1(resultSet.getString("INFO_SEQ_NO" ));
				setEffStatus1( resultSet.getString("EFF_STATUS"));	
				}
		}catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
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
*/
	public boolean CheckSeqno(String seq_no,String code) { 
		
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean dulicatd_yn			= false;
	
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_COUNT_SELECT")) ;	
			pstmt.setString(1,seq_no);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if( resultSet.getInt("COUNT")>0)
				 {
					dulicatd_yn	=	true;
				}
			}
		}catch ( Exception e ) {
			System.err.println( "Error while checking nationality  :"+e ) ;
            e.printStackTrace() ;
		}finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }catch(Exception es){es.printStackTrace();}
        }
	
		return dulicatd_yn;
	}

	public ArrayList getDrugInformationSource(String info_cat_code) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList DrugInfo = new ArrayList() ;

		try {
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_QUERY_SELECT")) ;
			pstmt.setString( 1, info_cat_code.trim());
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record  = new String[4];
				record[0] = resultSet.getString( "CODE" )  ;
				record[1] = resultSet.getString( "DESCP" )  ;
				record[2] = resultSet.getString( "SEQNO" )  ;
				record[3] = resultSet.getString( "EFF" )  ;
 				DrugInfo.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "s4 Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return DrugInfo;
	}
	public String[] checkForDuplicate(String req_cat_code,String seq_info) { 
		Connection connection       = null ;
		PreparedStatement pstmt     = null,pstmt1     = null;
		ResultSet resultSet         = null ;
		String[] dulicatd_yn = new String[2];
		int i=0;
		try{
			connection = getConnection() ;
			if(!req_cat_code.equals("")){
				//pstmt	= connection.prepareStatement("SELECT COUNT(ROWID) COUNT FROM PH_DRUG_INFO_ENQ_HDR WHERE upper(INFO_CAT_CODE) like upper(?)") ;
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DUPLICATE_SELECT")) ;
				pstmt.setString(1,req_cat_code);
				resultSet= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					if( resultSet.getInt("COUNT") > 0) 
						dulicatd_yn[i]	=	"Y";
					else
						dulicatd_yn[i]	=	"N";
					
					i++;
				}
			}
			closeResultSet(resultSet);
			pstmt1		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_COUNT_SELECT")) ;	
			pstmt1.setString(1,seq_info);
			resultSet= pstmt1.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if( resultSet.getInt("COUNT") > 0) {
					dulicatd_yn[i]	=	"Y";
				}else
					dulicatd_yn[i]	=	"N";
			}
		}catch ( Exception e ) {
			System.err.println( "Error while checking nationality  :"+e ) ;
			e.printStackTrace() ;
		}finally {
			try{
			 closeResultSet( resultSet ) ;
			 closeStatement( pstmt ) ;
			 closeStatement( pstmt1 ) ;
			 closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
			}
		System.err.println("The values for the intermediate from bean "+dulicatd_yn);
		return dulicatd_yn;

	}

	public HashMap delete() {
				
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			return map ;
	}

	private String[] giveDuplicateValues(String arr[]) throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs	         = null ;
		StringBuffer messages = new StringBuffer() ;
		String duplicate[]	   	= null;

		try
		  {
				//String sql="SELECT INFO_CODE FROM PH_DRUG_INFO_ENQ_DTL WHERE INFO_CAT_CODE like (?) and INFO_CODE in(?)";
				String sql= PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DTL_DUPLICATE_SELECT");

				connection	= getConnection() ;
				/*Directly replacing the ? in the sql string with the values*/
				int t = sql.lastIndexOf("?");
				sql  = sql.substring(0,t) + arr[1].trim() + sql.substring(t+1)  ;
				pstmt = connection.prepareStatement(sql.trim(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

				int size = arr.length ;
				String val1 = arr[0] ;
				pstmt.setString(1,val1.trim());
				size = 0 ;
				rs = pstmt.executeQuery();
				while (rs.next())
				++size;

				if(size == 0 )
					return null ;

				duplicate = new String[size] ;
				rs.beforeFirst()  ;
				int i =0 ;
				while(rs.next()){
					duplicate[i] = rs.getString(1);
					++i;
				}

			  }catch(Exception e){
					messages.append(e.getMessage());
					throw e;
		 } finally {
			try {
				 closeConnection( connection );
				closeResultSet(rs);
				closeStatement(pstmt);
			} catch (Exception ee) {ee.printStackTrace();}
		 }

		return duplicate;
	}//End of dulicate chk

	public HashMap  insert(){
			
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		
//		SingleTableHandlerHome home = null;
//		SingleTableHandlerRemote remote = null;
		
		try{

		/**************************/

			String  sqlParam1 = " "; //Paramters passed for duplicate chking
			String  sqlParam2 = " "; //Paramters passed for duplicate chking
			StringBuffer messages = new StringBuffer();

			for(int s=0 ; s < 10 ; s++){
				if(!((String)hashMultiple.get("info_code"+s)).trim().equals("")){
				
					sqlParam1 = (String)hashMultiple.get("code");
					sqlParam2 = sqlParam2 + "'" + (String)hashMultiple.get(("info_code" + s)) + "',";
				}
			}
			int indx = sqlParam2.lastIndexOf(",") ;
			sqlParam2 = sqlParam2.substring(0,indx);//to remove last ',' char
			String arrChkDup[]  =  new String[2] ;
			arrChkDup[0] = sqlParam1 ;
			arrChkDup[1] = sqlParam2 ;
			String duplicates[] = giveDuplicateValues(arrChkDup);
			if(duplicates != null )
			{
				String msg  =	 "";
				int len = duplicates.length ;
				while(len > 0)
				msg = msg + "," + duplicates[--len] ;
				int t= msg.indexOf(",");
				msg    = msg.substring(t+1) ;
				messages.append(msg);
				map.put( "message", "CODE_ALREADY_EXISTS") ;
				map.put( "invalidCode", msg  ) ;
				map.put( "flag", "Duplicate") ;
				map.put( "traceVal", "dup loop records" ) ;
				return map ;
			}

/*******************************************************************************/
			insertData.add( code.trim() ) ;
			insertData.add( description.trim() ) ;
			insertData.add(	display_sequence_no.trim() ) ;
			insertData.add( eff_status.trim()) ;
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;
			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;
			whereData.add( display_sequence_no.trim() ) ;
			
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_COUNT_SELECT"));
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_INSERT"));

			try {
				
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				if( ((Boolean) map.get( "result" )).booleanValue() ) {
					
					sqlMap.clear();
					sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DTL_INSERT"));

					String ID="";
					String info_eff_status = "";
					whereData.clear();
					insertData.clear();
					
					for(int i=0 ; i < 10 ; i++)
					{      
						ID = "info_code"  + i ;
						
						if(!((String)hashMultiple.get(ID)).trim().equals("")){
							if(((String)hashMultiple.get("info_eff_status"+i)).trim().equals(""))
								info_eff_status = "D";
							else
								info_eff_status = ((String)hashMultiple.get("info_eff_status"+i)).trim();
						
						insertData.add((String)hashMultiple.get(("code"))) ;
						insertData.add((String)hashMultiple.get(("info_code" + i))) ;
						insertData.add((String)hashMultiple.get(("info_short_desc"+ i))) ;
						insertData.add((String)hashMultiple.get(("seq_no"+ i))) ;
						//insertData.add((String)hashMultiple.get(("info_eff_status"+i))) ;
						insertData.add(info_eff_status.trim()) ;
						insertData.add(login_at_ws_no) ;
						insertData.add(login_facility_id) ;
						insertData.add(login_by_id) ;
						insertData.add(login_at_ws_no) ;
						insertData.add(login_facility_id) ;
						insertData.add(login_by_id) ;
						tabData.put( "properties", getProperties() );
						tabData.put( "InsertData",insertData);

				//		home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				//		remote = home.create() ;
				//		map = remote.insert( tabData, sqlMap ) ;
						map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


						whereData.clear();
						insertData.clear();

						if( ((Boolean) map.get( "result" )).booleanValue() ) {	
	
							map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
							}
						else{
							if(((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
								map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
							else
								map.put( "message", (map.get("msgid"))) ;
							}
						}
					}
				}else
				{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}catch(Exception e) {
						System.err.println( "Error Calling EJB : "+e ) ;
						map.put( "message", e.getMessage()) ;
						e.printStackTrace() ;
			}
		}catch(Exception e){
			System.err.println( "Error Calling EJB 3: "+e ) ;
			map.put( "message", "Duplicate  :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
		/*finally {
			clear();
			try {
				if( remote != null )
					remote.remove() ;
			}catch( Exception ee ){
					System.err.println( "sql exception cought here");
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
			}
		}//finally */

		return map ;
	}

	public HashMap modify() {

		StringBuffer debug =new StringBuffer();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList modifyData = new ArrayList() ;
		
		modifyData.add(((String)hashMultiple.get("description")).trim()) ;
		modifyData.add(((String)hashMultiple.get("display_sequence_no")).trim()) ;
		modifyData.add(((String)hashMultiple.get("eff_status")).trim()) ;
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( ((String)hashMultiple.get("code")).trim()) ;
		boolean duplicate_yn1 = false;
		if(dup_chk1.equals("Y"))
			
			duplicate_yn1 =CheckSeqno((String)hashMultiple.get(("display_sequence_no")),(String)hashMultiple.get(("code")));
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);
			HashMap sqlMap = new HashMap() ;
		try{
		//sqlMap.put( "ModifySQL", "UPDATE PH_DRUG_INFO_ENQ_HDR SET SHORT_DESC=?, SEQ_NO=?, EFF_STATUS=?,MODIFIED_BY_ID =?, MODIFIED_DATE =SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE INFO_CAT_CODE=?" );
		sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}

//		SingleTableHandlerHome home = null;
//		SingleTableHandlerRemote remote = null;

		try{
			if(!duplicate_yn1){

/*				InitialContext context = new InitialContext() ;
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

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(((Boolean) map.get( "result" )).booleanValue() )
				{	
				
					sqlMap.clear();
					modifyData.clear();
					//sqlMap.put( "ModifySQL", "UPDATE  PH_DRUG_INFO_ENQ_DTL  SET INFO_DESC=?, INFO_SEQ_NO=?, EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO= ?, MODIFIED_FACILITY_ID= ? WHERE INFO_CAT_CODE=? AND INFO_CODE= ?" );
					sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DTL_UPDATE1") );
				
					String ID="";
					int totalRecords = Integer.parseInt((String)hashMultiple.get("totalRecords"));
					String info_eff_status = "";						
					for(int i=0 ; i < totalRecords ; i++)
					{      
						ID = "info_code"  + i ;
						if(!((String)hashMultiple.get(ID)).trim().equals("")){
							if(((String)hashMultiple.get("info_eff_status"+i)).equals(""))
								info_eff_status="D";
							else
								info_eff_status="E";
							modifyData.add(((String)hashMultiple.get("info_short_desc"+i))) ;
							modifyData.add(((String)hashMultiple.get("seq_no"+i)).trim()) ;
							//modifyData.add(((String)hashMultiple.get("info_eff_status"+i)).trim()) ;
							modifyData.add((info_eff_status).trim()) ;
							modifyData.add( login_by_id.trim() ) ;
							modifyData.add( login_at_ws_no.trim() ) ;
							modifyData.add( login_facility_id.trim() ) ;
							modifyData.add( ((String)hashMultiple.get("code")).trim()) ;
							modifyData.add( ((String)hashMultiple.get("info_code"+i)).trim()) ;
							
							tabData.put( "properties", getProperties() );
							tabData.put( "ModifyData",modifyData);

	//						home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
	//						remote = home.create() ;
	//						map = remote.modify( tabData, sqlMap ) ;
							
							map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

							modifyData.clear();
							if( ((Boolean) map.get( "result" )).booleanValue() ) {	
								map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
							}
						}//end of code lup
					}// end of for lup
				}// end of if lup
			}else{
				map.put( "msgid", "CODE_ALREADY_EXISTS") ;
				System.err.println("ENtering into else part if result fails ");
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message", "APP-PH0005 Duplicate Display Sequence No not allowed :"+((String)hashMultiple.get("display_sequence_no")).trim() ) ;
			} 
		}catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		} 
		/*finally {
			try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map;
	}

}
