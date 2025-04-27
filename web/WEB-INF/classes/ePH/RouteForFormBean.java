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
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
//saved on 27/10/2005
public class RouteForFormBean extends PhAdapter implements Serializable{

	protected String form_code                  = "" ;
    protected String form_desc                  = "" ;
    protected String route_code                 = "" ;
    protected String route_desc                 = "" ;
    protected String action_text_label          = "" ;
    protected String action_text_label_loc_lang = "" ;
    protected String PARAM_YN                   = "" ;
    protected String debug                   = "" ;
	HashMap testing = new HashMap();
	protected ArrayList formList =null;
	
	public RouteForFormBean() {
    try {
            doCommon() ;
        }
        catch(Exception e) {
		    e.printStackTrace();
		}
	}

	public HashMap getTest(){
		return testing;
	}

	public void setDebug( String debug )    {
        this.debug = debug ;
    }

	public void setForm_Code( String form_code )    {
        this.form_code = form_code ;
    }
	public void setForm_Desc( String form_desc )    {
        this.form_desc = form_desc ;
    }
	public void setRoute_Code( String route_code )  {
        this.route_code = route_code ;
    }
	public void setRoute_Desc( String route_desc )  {
        this.route_desc = route_desc ;
    }
	public void setAction_Text_Label( String action_text_label )    {
        this.action_text_label = action_text_label ;
    }
	public void setAction_Text_Label_Loc_Lang( String action_text_label_loc_lang )  {

        if(action_text_label_loc_lang==null)
            this.action_text_label_loc_lang="";
        else
            this.action_text_label_loc_lang =action_text_label_loc_lang ;
    }
	public void setPARAM_YN( String PARAM_YN )  {
		if(PARAM_YN==null )
			PARAM_YN = "N";
		else
			this.PARAM_YN =PARAM_YN ;
	}

	public void setRecords( ArrayList ListItem )    {
		this.formList = ListItem;
    }

	public String getDebug() {
        return this.debug ;
    }

	public String getForm_Code() {
        return this.form_code ;
    }
	public String getForm_Desc() {
        return this.form_desc ;
    }

	public String getRoute_Code() {
        return this.route_code ;
    }
	public String getRoute_Desc() {
        return this.route_desc ;
    }
	public String getAction_Text_Label() {
        return this.action_text_label ;
    }
	public String getAction_Text_Label_Loc_Lang1() {
        return this.action_text_label_loc_lang ;
    }
	public String getPARAM_YN() {
        return this.PARAM_YN ;
    }

	private void doCommon() throws Exception {}

	public void clear() {
		super.clear() ;
	}

	 public void setAll( Hashtable recordSetMultiple ) {
		this.mode =(String)recordSetMultiple.get("mode");
	 }

	public HashMap insert(){
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData  = new ArrayList() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		/* if the Insert is in Y or N mode acc to PH_PARAM table    String  YN="";  try{ YN=(String)getPARAM_YN();  debug.append("YN="+YN+"//");        }       catch(Exception e){}*/
		try{
			int j	=	0;
			for(int i=0; i < 10;i++){
				ArrayList insertRow = new ArrayList() ;
				ArrayList whereRow  = new ArrayList() ;
				/*although we have the name of  variable in the AddModify as Form_Desc
				but the value is Form_Code....and the value being displayed is Form_Desc
				that is why the name we use here is form_desc1, form_desc2....   */
			
				if(!((((String)formList.get(j))).trim().equals("") || (((String)formList.get(j+1))).trim().equals("") )){
					/***** 4 values per row from the form  */
					insertRow.add( (String)formList.get(j) ) ;
					insertRow.add( (String)formList.get(j+1) ) ;
					insertRow.add( (String)formList.get(j+2) ) ;

					if( (PARAM_YN.equals("Y")) ){	
						String columnvalue_t = "";
						InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(  ((String)formList.get(j+3)).getBytes()), "windows-1256");
						columnvalue_t = (new BufferedReader(inputstreamreader)).readLine();
						insertRow.add(columnvalue_t ) ;
					}
					else if( (PARAM_YN.equals("N")) )
						insertRow.add("") ;
					else
						insertRow.add("") ;

					insertRow.add(    login_by_id       ) ;
					insertRow.add(    login_at_ws_no    ) ;
					insertRow.add(    login_facility_id ) ;

					insertRow.add(    login_by_id       ) ;
					insertRow.add(    login_at_ws_no    ) ;
					insertRow.add(    login_facility_id ) ;

					whereRow.add(  (String)formList.get(j)    ) ;
					whereRow.add(  (String)formList.get(j+1)   ) ;

					insertData.add( insertRow ) ;
					whereData.add(  whereRow );
				}
				j	=	j +4;
			}       
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_SELECT5" ) );
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_INSERT") );
			map = CallSingleTableHandler( tabData,sqlMap );
        }
		catch(Exception e){
            e.printStackTrace();
        }
		return map ;
	}

	public HashMap modify(){
		int j	=	0;
		ArrayList insertRow     = new ArrayList() ;	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        try{
			if(!( (((String)formList.get(j))).trim().equals("") ||(((String)formList.get(j+1))).trim().equals("")) ){
				/*Two values from the AddMOd form in modify mode */
				insertRow.add( (String)formList.get(j+2)  ) ;
				if( (PARAM_YN.equals("Y")) ){
					if(!((String)formList.get( j+3 )).equals("")){
						InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(  ((String)formList.get(j+3)).getBytes()), "windows-1256");
						action_text_label_loc_lang = (new BufferedReader(inputstreamreader)).readLine();
					}		  
					insertRow.add( action_text_label_loc_lang  ) ;
				}
				else if( (PARAM_YN.equals("N")) ){
					insertRow.add("") ;
				}
				else
					insertRow.add("") ;
				insertRow.add(    login_by_id       ) ;
				insertRow.add(    login_at_ws_no    ) ;
				insertRow.add(    login_facility_id ) ;

				insertRow.add(      form_code       ) ;
				insertRow.add(      route_code      ) ;
			}
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",insertRow);

			HashMap sqlMap = new HashMap() ;
            sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_UPDATE" ) );
			map= CallSingleTableHandler( tabData,sqlMap );
        }
		catch(Exception e){
            e.printStackTrace();
        }
		return map;
	}

	public HashMap delete(){
		ArrayList insertRow     = new ArrayList() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		if(!(form_code.trim().equals("") || route_code.trim().equals("") )){
			//Two values from the AddMOd form in modify mode
			insertRow.add( form_code  ) ;
			insertRow.add( route_code ) ;
		}
        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "DeleteData",insertRow);

        HashMap sqlMap = new HashMap() ;
        try{
            sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_DELETE" ) );
			map = CallSingleTableHandler( tabData,sqlMap );
        }
		catch(Exception e){
            e.printStackTrace();
        }
		return map ;
	}

	public ArrayList getForm_Desc_X(String code,String locale)  throws Exception{
		ArrayList FormRoute_desc_arr    = new ArrayList() ;
		Connection connection           = null ;
		PreparedStatement pstmt         = null ;
		ResultSet resultSet             = null ;
		try {
			connection = getConnection() ;
			if ( code.equals("form") ){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_SELECT1" ) ) ;
				pstmt.setString(1,locale);
				resultSet = pstmt.executeQuery() ;

				if ( resultSet != null ){
					while ( resultSet.next() ){
						FormRoute_desc_arr.add( resultSet.getString( "FORM_CODE" ) ) ;
						FormRoute_desc_arr.add( resultSet.getString( "FORM_DESC" ) ) ;
					}
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if ( code.equals("route") ){
				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_SELECT2" ) ) ;
				pstmt.setString(1,locale);
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null ){
					while ( resultSet.next() ){
						FormRoute_desc_arr.add( resultSet.getString( "ROUTE_CODE" ) ) ;
						FormRoute_desc_arr.add( resultSet.getString( "ROUTE_DESC" ) ) ;
						FormRoute_desc_arr.add( resultSet.getString( "ROUTE_COLOR" ) ) ;// added for CRF RUT-CRF-0034.1[IN:037389]
					}
				}
			}
		}
		catch ( Exception e ){
            e.printStackTrace() ;
            throw e ;
        }
        finally{
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return FormRoute_desc_arr;
	}

	 public void loadData() throws Exception {
		String []stParameters   =   {getForm_Code(),getRoute_Code()};
		HashMap hmRecord        =   null;
		hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_SELECT4" ), stParameters);
		setForm_Desc( (String)hmRecord.get  ("FORM_DESC")  ) ;
		setRoute_Desc( (String)hmRecord.get  ("ROUTE_DESC")  ) ;
		setAction_Text_Label( (String)hmRecord.get  ("ACTION_TEXT_LABEL")  ) ;
		setAction_Text_Label_Loc_Lang( (String)hmRecord.get  ("ACTION_TEXT_LABEL_LOC_LANG") ) ;
	 }

	public void  YNforLocLang()  throws Exception{
		String []stParameters   =   { login_facility_id };
		HashMap hmRecord        =   null;
		hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_FACILITY_PARAM_SELECT" ), stParameters);
		testing = hmRecord;
		setPARAM_YN( (String)hmRecord.get  ("PAT_INSTR_LOC_LANG_YN")  ) ;
		setDebug( (String)hmRecord.get  ("PAT_INSTR_LOC_LANG_YN")+":::" );
	}

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
			if ( resultSet != null && resultSet.next() ) {
				resultSetMetaData   =   resultSet.getMetaData();
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

	private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap ){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
			else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
				map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}				
			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else
					map.put( "message", (map.get("msgid"))) ;
            }
        }
        catch(Exception e) {
			map.put( "message", e.getMessage()+"classcast") ;
			e.printStackTrace() ;
        }
		return map;
	}
}//class end
