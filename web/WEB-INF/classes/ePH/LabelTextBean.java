/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 08/11/2005
/***********************************************************************************************
	Module		 : ePH
	Function	 : Label Text
	Class Name	 :  LabelTextBean
	Created By	 : Vinit Srivastava
	Created Date : 18-12-2002
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :
		LabelTextBean contains 
		1. insert() method which will forward the request to 
		  the session bean...(SingleTableHandler) to insert the records into PH_LABEL_TEXT table.

		2. validate() method that will access the database to see if the RouteCode being inerted already exists .If it does then DUPLICATE CODE message is displayed and control is returned back to the AddModify page.No implementation here cause taken care by SingleTableHandler.
		3. getDataForHyperLink() this will populate the data on hyper link click 
		it will also be called when the control returns after successful updation in onsuccess()
**********************************************************************************************/

package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugCategory.*;
import eCommon.SingleTableHandler.*;
import javax.servlet.* ; 
import javax.servlet.http.*;

public class LabelTextBean extends PhAdapter implements Serializable {
	
	protected String label_text_id="";
	protected String label_text_type="";
	protected String label_text_1="";
	protected String label_text_2="";
	protected String label_text_1_loc_lang="";
	protected String label_text_2_loc_lang="";
	protected String eff_status="";
	protected String PARAM_YN="";
	protected String caution_text_max_200=""; //added for MMS-QH-CRF-0200 [IN:052044]

	public LabelTextBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {/* Over-ridden Adapter methods start here */
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}	/* Over-ridden Adapter methods end here */

	// set methods start
	public void setPARAM_YN( String PARAM_YN )  {
		if(PARAM_YN==null)
            PARAM_YN="";
        else
            this.PARAM_YN =PARAM_YN ;
	}
	public void setCautionTextMax( String caution_text_max_200 )  {//added for MMS-QH-CRF-0200 [IN:052044]
		this.caution_text_max_200 =caution_text_max_200 ;
	}
	
	public void setLABEL_TEXT_ID( String label_text_id ) {		
		this.label_text_id = label_text_id  ;
	}	
	public void setLABEL_TEXT_TYPE( String label_text_type ) {
		this.label_text_type = label_text_type  ;
	}
	public void setLABEL_TEXT_1(String label_text_1) {
		this.label_text_1=label_text_1;
	}
	public void setLABEL_TEXT_2(String label_text_2) {
		this.label_text_2=label_text_2;
	}
	public void setLABEL_TEXT_1_LOC_LANG(String label_text_1_loc_lang) {		
		this.label_text_1_loc_lang=label_text_1_loc_lang;
	}
	public void setLABEL_TEXT_2_LOC_LANG(String label_text_2_loc_lang) {		
		this.label_text_2_loc_lang=label_text_2_loc_lang;
	}
	public void setEffStatus(String eff_status) {
		if(eff_status.equals("") || eff_status==null )
			this.eff_status = "D" ;
		else
			this.eff_status = eff_status ;
	}// set methods end

	// get methods start here
	public String getLABEL_TEXT_ID() {
		return this.label_text_id  ;
	}
	public String getLABEL_TEXT_TYPE() {
		return this.label_text_type  ;
	}
	public String getLABEL_TEXT_1() {
		return this.label_text_1 ;
	}
	public String getLABEL_TEXT_2() {
		return this.label_text_2 ;
	}
	public String getEffStatus() {
		return this.eff_status ;

	}	

	public String getPARAM_YN(){
		return  this.PARAM_YN ;
	}
	public String getCautionTextMax(  )  {//added for MMS-QH-CRF-0200 [IN:052044]
		return this.caution_text_max_200 ;
	}// get methods end here

	public void setAll( Hashtable recordSet ){
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("label_text_id"))
			setLABEL_TEXT_ID((String)recordSet.get("label_text_id")) ;
		if(recordSet.containsKey("label_text_type"))
			setLABEL_TEXT_TYPE((String)recordSet.get("label_text_type")) ;
		if(recordSet.containsKey("label_text_1"))
			setLABEL_TEXT_1((String)recordSet.get("label_text_1")) ;
		if(recordSet.containsKey("label_text_2"))
			setLABEL_TEXT_2((String)recordSet.get("label_text_2")) ;
		if(recordSet.containsKey("eff_status"))
			setEffStatus((String)recordSet.get("eff_status")) ;
		if(recordSet.containsKey("label_text_1_loc_lang")) //added for MMS-QH-CRF-0200 [IN:052044] -start
			setLABEL_TEXT_1_LOC_LANG((String)recordSet.get("label_text_1_loc_lang")) ;
		if(recordSet.containsKey("eff_status"))
			setLABEL_TEXT_2_LOC_LANG((String)recordSet.get("label_text_2_loc_lang")) ; //added for MMS-QH-CRF-0200 [IN:052044]  -end
	}

	public HashMap validate() throws Exception {// validate method starts here..
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}// validate method ends here...

	// insert method  starts here...
	public HashMap insert(){
		StringBuffer debug=new StringBuffer();
		debug.append("INSIDE INSERT");

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;		
		/*try{ --commented for MMS-QH-CRF-0200 [IN:052044] 
		  if(!label_text_1_loc_lang.equals("")){
               InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(label_text_1_loc_lang.getBytes()), "windows-1256");
                label_text_1_loc_lang = (new BufferedReader(inputstreamreader)).readLine();
           }		  
		}
		catch (Exception ee){
			ee.printStackTrace();
		}
		try{
			if(!label_text_2_loc_lang.equals("")){		 
               InputStreamReader inputstreamreader1 = new InputStreamReader(new ByteArrayInputStream(label_text_2_loc_lang.getBytes()), "windows-1256");
                label_text_2_loc_lang = (new BufferedReader(inputstreamreader1)).readLine();				
           }   		
		}
		catch (Exception ee){
			ee.printStackTrace();
		}*/
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		try{
			insertData.add( label_text_id ) ;
			insertData.add( label_text_type ) ;
			insertData.add(	label_text_1 ) ;
			insertData.add( label_text_2) ;
			insertData.add( label_text_1_loc_lang ) ;
			insertData.add( label_text_2_loc_lang ) ;

			insertData.add( eff_status ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
			whereData.add( label_text_id ) ;

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			try{
				sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_SELECT4" ) );
				sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_INSERT") );
			}
			catch(Exception e){
				e.printStackTrace();
			}
	
			//SingleTableHandlerHome home = null;
			//SingleTableHandlerRemote remote = null;
			try {
				/*debug.append("Before Initial Context");
				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")  ) ;
				debug.append("After lookup");
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				debug.append("BEfore insert");
				map = remote.insert( tabData, sqlMap ) ;
				debug.append("After Insert");*/

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
					//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				map.put("flag",debug.toString());
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug.toString());
			e.printStackTrace() ;
		}
		map.put("flag",debug.toString());
		return map ;		
	}

/*********************   getDataForHyperLink() **********************************/
// called in the AddModify page,evoked from onsuccess() and modify() in js

	public ArrayList getDataForHyperLink(String label_text_id)  throws Exception {
		ArrayList AllColsArr = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String stSql = "";
		try {
			connection = getConnection() ;
			stSql = PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_SELECT2" );
			if((getPARAM_YN().equals("Y") || getCautionTextMax().equals("Y")) ) //if block added for MMS-QH-CRF-0200 [IN:052044] 
				stSql = PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_SELECT2A" ) ;
			pstmt = connection.prepareStatement( stSql ) ;
			pstmt.setString(1,label_text_id.trim());
			resultSet = pstmt.executeQuery() ;
			
			if ( resultSet != null && resultSet.next() ) {
				AllColsArr.add( (String) resultSet.getString( "LABEL_TEXT_ID" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "LABEL_TEXT_TYPE" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "LABEL_TEXT_1" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "LABEL_TEXT_2" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "LABEL_TEXT_1_LOC_LANG" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "LABEL_TEXT_2_LOC_LANG" ) ) ;
				AllColsArr.add( (String)resultSet.getString( "EFF_STATUS" ) ) ;
			}
		}
		catch ( Exception e ){
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
				es.printStackTrace();
			}
		}
		return AllColsArr;
	}

/******************************** modify()   ********************************/
	public HashMap modify() {
		StringBuffer debug=new StringBuffer();
		//debug.append("INSIDE MODIFY//");

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;		
		//code added  on 24/4/2004 for converting to local lang...
		try{
			/*if(!label_text_1_loc_lang.equals("")){ //commented for MMS-QH-CRF-0200 [IN:052044] 
				InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(label_text_1_loc_lang.getBytes()), "windows-1256");
				label_text_1_loc_lang = (new BufferedReader(inputstreamreader)).readLine();
           }
			if(!label_text_2_loc_lang.equals("")){ 		 
               InputStreamReader inputstreamreader1 = new InputStreamReader(new ByteArrayInputStream(label_text_2_loc_lang.getBytes()), "windows-1256");
                label_text_2_loc_lang = (new BufferedReader(inputstreamreader1)).readLine();				
           }*/
			ArrayList insertRow = new ArrayList() ;
			
			insertRow.add( label_text_type  ) ;
			insertRow.add( label_text_1 ) ;
			insertRow.add(label_text_2) ;
			insertRow.add(label_text_1_loc_lang) ;
			insertRow.add(label_text_2_loc_lang) ;   

			insertRow.add(eff_status) ; 
			insertRow.add( login_by_id ) ;
			insertRow.add( login_at_ws_no ) ;
			insertRow.add( login_facility_id ) ;
			insertRow.add( label_text_id  ) ;

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",insertRow);
			//no need of where data here in modify function of single table handler ejb

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_UPDATE" ) );

			//SingleTableHandlerHome home = null;
			//SingleTableHandlerRemote remote = null;
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")  ) ;
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

			if( ((Boolean) map.get( "result" )).booleanValue() ){
				//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			}
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
				else{
					//debug.append("Inside else result fails here ejb call modify()//"+((Boolean) map.get( "result" )).booleanValue()+"//messageid//"+(map.get("msgid")) );
					map.put( "message", (map.get("msgid"))) ;
				}
			}
		}//try
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			map.put("flag",debug.toString());
			e.printStackTrace() ;
		}
		map.put("flag",debug.toString());
			return map ;		
	}// modify method ends here...
	/* would connect to the PARAM table and get Y or N and accordingly return value*/
	public void  YNforLocLang()  throws Exception{
		String []stParameters   =   { login_facility_id };
		HashMap hmRecord        =   null;
		hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_FACILITY_PARAM_SELECT" ), stParameters);
		setPARAM_YN( (String)hmRecord.get  ("PAT_INSTR_LOC_LANG_YN")  ) ;
	}
	/******************************************************************************/
	public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
        HashMap hmRecord                    =   new HashMap();
        Connection connection               = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet                 = null;
        ResultSetMetaData resultSetMetaData = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (stParameters!=null)
                for (int index=0; index<stParameters.length ;index++ )
                    preparedStatement.setString( index+1, stParameters[index]);

            resultSet = preparedStatement.executeQuery();
            resultSetMetaData   =   resultSet.getMetaData();
			
			if(resultSet !=null && resultSet.next()){
                for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
				    hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
			}
        }
        catch (Exception exception )    {
            exception.printStackTrace();
            throw exception;
        }
        finally {
            try{
                closeResultSet(resultSet);
                closeStatement(preparedStatement);
                closeConnection(connection);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
        }
		return hmRecord;
	}

	public void  fetchCautionTextMax()  throws Exception{ //added for MMS-QH-CRF-0200 [IN:052044] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String crit_field_id = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_CAUTION_MAX_200_SELECT" ));
			pstmt.setString(1,"*A");
			pstmt.setString(2,"LABEL_TEXT");
			pstmt.setString(3, "CAUTION_TEXT_MAX_200");
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));
					if(crit_field_id.equals("CAUTION_TEXT_MAX_200"))
						setCautionTextMax(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
				}
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}
}/***********   class end*******************************************************/
