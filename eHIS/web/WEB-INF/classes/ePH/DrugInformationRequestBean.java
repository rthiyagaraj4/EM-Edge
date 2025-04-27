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
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugInformationRequestBean extends PhAdapter implements Serializable {
	

	java.util.Properties p=null;

	protected String code = "";
	protected String description = "";
	protected String display_sequence_no = "";
	protected String sys_def  = "";
	protected String eff_status  = "";
	protected String dup_chk  = "";
	public DrugInformationRequestBean() {
		try {
			doCommon();
		}
		catch(Exception e) {}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	
	public void setCode(String code){
		this.code = code;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setDisplaysequenceno(String display_sequence_no){
		this.display_sequence_no = display_sequence_no;
	}
	public void setEffStatus(String eff_status){
		if (eff_status.equals("") || eff_status==null ){
			eff_status="D";
		}
		this.eff_status = eff_status;
	}

	 public void setSysDef(String sys_def){
		if (sys_def.equals("") || sys_def==null ){
			sys_def="N";
		}
		this.sys_def = sys_def;
	}
   public void setDupChk(String dup_chk){
		this.dup_chk = dup_chk;
	}

	
	public String getCode(){
		return code;
	}
	public String getDescription(){
		return description;
	}
	public String getDisplaysequenceno(){
		return display_sequence_no;
	}
	public String getEffStatus(){
		return eff_status;
	}
	public String getSysDef(){
		return sys_def;
	}


public String getDupChk(){
		return dup_chk;
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
		if(recordSet.containsKey("sys_def"))
			setSysDef((String)recordSet.get("sys_def")) ;
		if(recordSet.containsKey("dup_chk"))
			setDupChk((String)recordSet.get("dup_chk")) ;
	}

	public void loadData() throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT") );


			pstmt.setString( 1, getCode().trim() ) ;

			resultSet = pstmt.executeQuery() ;
			
			//System.err.println("The resultset values ----------------"+resultSet);

			if ( resultSet != null && resultSet.next() ) {

				setCode( resultSet.getString("CODE" ));
				setDescription(resultSet.getString("DESCRIPTION" ));
				setDisplaysequenceno(resultSet.getString("SEQ_NO" ));
				setSysDef(resultSet.getString("SYSTEM_DEFINED_YN"));
				setEffStatus( resultSet.getString("EFF_STATUS"));	
				
			}
		}
		catch ( Exception e ){
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
	public boolean CheckSeqno(String seq_no,String code) { 
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean dulicatd_yn			= false;
		//String code1				="";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT1")) ;
			    pstmt.setString(1,seq_no);
				resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				
/*				if( resultSet.getInt("COUNT")==1)
				 {
					 pstmt		= null;
					 resultSet	= null;
                     pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT3")) ;
			          pstmt.setString(1,seq_no);
					  resultSet				= pstmt.executeQuery();
					  	
					  if(resultSet!=null && resultSet.next()){
						  code1	= resultSet.getString("REQ_CAT_CODE");
					  }
					  System.err.println("CODE & CODE1! +++++" +code + " : " +code1);
					  
					  if(code.equals(code1) || code1.equals("")){
						  dulicatd_yn	=	false;

					  }else{
						  dulicatd_yn	=	true;
					  }		   
					
				}
				
			} */
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
	//	System.err.println("====dulicatd_yn==="+dulicatd_yn+"===seq_no==="+seq_no);
		return dulicatd_yn;

		
}


	public HashMap insert() {
		
		//System.err.println("Entering into insert mode =======================");

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		//StringBuffer sb= new StringBuffer();
		try{
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
			insertData.add( sys_def.trim() ) ;

//			whereData.add( code.trim() ) ;

			whereData.add( display_sequence_no.trim() ) ;

		
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
			

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT1"));
				
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_INSERT"));

//			SingleTableHandlerHome home = null;
//			SingleTableHandlerRemote remote = null;
			try {

/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;

				System.err.println("the results from map "+map);*/

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


				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

			/*	else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}*/
			
				else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message", "APP-PH00186 Duplicate Sequence No not allowed" ) ;
					else
					map.put( "message", "APP-PH00187 Duplicate Code not allowed") ;
				}

			//	else
			//		map.put( "message", "App-004 Duplicate Code not allowed") ;

			}catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
		//	map.put("flag",sb.toString());
			e.printStackTrace() ;
		}
		finally {
			try {} 
			catch( Exception ee ){
				System.err.println( "sql exception cought here");
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally
		
		return map ;
	}

	public HashMap modify() {
	
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;
		//ArrayList whereData = new ArrayList() ;


		modifyData.add( description.trim() ) ;
		modifyData.add( display_sequence_no.trim() ) ;
		modifyData.add( eff_status.trim() ) ;
		
		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( sys_def.trim() ) ;
		modifyData.add( code.trim() ) ;
		
		boolean duplicate_yn = false;
	
		if(dup_chk.equals("Y"))
		duplicate_yn = CheckSeqno(display_sequence_no.trim(),code.trim());

//	boolean duplicate_yn =CheckSeqno(display_sequence_no.trim());



//		whereData.add( display_sequence_no.trim() ) ;
		//System.err.println("==duplicate_yn=2222=="+duplicate_yn);
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
	//	tabData.put( "WhereData",whereData);

		HashMap sqlMap = new HashMap() ;
		try{
//		sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_SELECT1"));
		sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_REQ_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}

//		SingleTableHandlerHome home = null;
//		SingleTableHandlerRemote remote = null;
		
	try {
			if(!duplicate_yn){
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				debug.append("BEFOER CREATE(IN MODIFY)");
				remote = home.create() ;
				debug.append("BEFOER MODIFY");
				map = remote.modify( tabData, sqlMap ) ;
				debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));*/

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

			}
			
			else{
			String msgid=getMessage(getLanguageId(),"CODE_ALREADY_EXISTS","Common");
//			map.put( "message",msgid ) ;
			map.put( "msgid",msgid ) ;
			map.put( "result", new Boolean(false) ) ;
			//map.put("flag" ,new Boolean(false) ));
			System.err.println("message in map  " +map);
	
			}
			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				System.err.println("ENtering into part if ");
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());
			}
			else{

				System.err.println("ENtering into else part if result fails ");
			
				if( ((String)map.get( "msgid" )).equals( "APP-000064 Record Already Exists..." ) )
					map.put( "message", "App-PH00186 Duplicate Seq num not allowed" ) ;
			//	else{
			//	map.put( "message", (map.get("msgid"))) ;
			//	map.put( "result", new Boolean( false ) ) ;
			//	map.put( "message", (map.get("msgid"))) ;
			//	map.put( "flag",debug.toString());
			//	}
	/*	else{
			if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
			map.put( "message", "App-0002 Duplicate Seq num not allowed" ) ;
			else
			map.put( "message", "App-004 Duplicate Code not allowed") ;


		}*/
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
		return map ;	
	}

	public HashMap delete() {
			
		//StringBuffer debug =new StringBuffer();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		return map ;
	}
}


