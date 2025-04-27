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
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugCategory.*;
import eCommon.SingleTableHandler.*;

//saved on 27/10/2005

public class FormOfDrugBean extends PhAdapter implements Serializable {

    java.util.ArrayList arrListForInsert=null;
    protected String form_code="";
    protected String form_desc="";
    protected String form_code_loc_lang="";
    protected String form_desc_loc_lang="";
    protected String eff_status="";
    protected String fieldCheck="";

    public FormOfDrugBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
		e.printStackTrace();
		}
    }

    /* Over-ridden Adapter methods start here */
    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

    /* Over-ridden Adapter methods end here */


    // set methods start

    public void setFormCode( String form_code ) {
        this.form_code = form_code  ;
    }
    public void setFormDesc( String form_desc ) {
        this.form_desc = form_desc  ;
    }
    public void setFormCodeLocLang(String form_code_loc_lang) {
        this.form_code_loc_lang=form_code_loc_lang;
    }
    public void setFormDescLocLang(String form_desc_loc_lang) {
        this.form_desc_loc_lang=form_desc_loc_lang;
    }
    public void setEffStatus(String eff_status){
        if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
    }
    // set methods end

    // get methods start here

    public String getFormCode() {
        return this.form_code  ;
    }
    public String getFormDesc() {
        return this.form_desc  ;
    }
    public String getFormCodeLocLang() {
        return this.form_code_loc_lang ;
    }
    public String getFormDescLocLang() {
        return this.form_desc_loc_lang ;
    }
    public String getEffStatus(){
        return this.eff_status;
    }
    // get methods end here

    public void setAll( Hashtable recordSet ){

        if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
        String action = getMode();

        arrListForInsert=new ArrayList();

        if (action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
            if(recordSet.containsKey("form_code"))
                setFormCode((String)recordSet.get("form_code")) ;
            if(recordSet.containsKey("form_desc"))
                setFormDesc((String)recordSet.get("form_desc")) ;
            if(recordSet.containsKey("form_code_loc_lang"))
                setFormCodeLocLang((String)recordSet.get("form_code_loc_lang")) ;
            if(recordSet.containsKey("form_desc_loc_lang"))
                setFormDescLocLang((String)recordSet.get("form_desc_loc_lang")) ;
            if(recordSet.containsKey("eff_status"))
                setEffStatus((String)recordSet.get("eff_status")) ;
        }
        if (action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
            if (recordSet.containsKey("fieldCheck")) {
                fieldCheck = (String)recordSet.get("fieldCheck") ;
            }

            for (int i=1;i<=10;i++ ) {
                String formCodeForCheck="";
                if(recordSet.containsKey("form_code"+i)){
                    formCodeForCheck=(String)recordSet.get("form_code"+i) ;
                    if (!formCodeForCheck.equals(""))
                    {
                        arrListForInsert.add(formCodeForCheck);
                        if(recordSet.containsKey("form_desc"+i))
                            arrListForInsert.add((String)recordSet.get("form_desc"+i)) ;
                        if (recordSet.containsKey("form_code_loc_lang"+i))
                            arrListForInsert.add((String)recordSet.get("form_code_loc_lang"+i));
                        if (recordSet.containsKey("form_desc_loc_lang"+i))
                            arrListForInsert.add((String)recordSet.get("form_desc_loc_lang"+i)) ;
                        if (recordSet.containsKey("eff_status"+i)){
                            String effStatusCheck=(String)recordSet.get("eff_status"+i);
                            if (effStatusCheck.equals("") || effStatusCheck==null){
                                effStatusCheck="D";
                            }
                            arrListForInsert.add(effStatusCheck) ;
                        }
                    }
                }
            }
        }
    }


    // validate method starts here...
    public HashMap validate() throws Exception {
        HashMap map=new HashMap();
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map;
    }
    // validate method ends here...

    // insert method  starts here...
    public HashMap insert() {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed::Under Construction......."+arrListForInsert.size() ) ;

        ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;
        ArrayList insertObjects = null;
        ArrayList whereObjects = null;



		int j=0;
		insertObjects=new ArrayList();
		whereObjects=new ArrayList();
		if (fieldCheck.equals("None")) {
			for (int i=0;i<arrListForInsert.size() ;i+=5 ) {
				insertObjects=new ArrayList();
				whereObjects=new ArrayList();

                insertObjects.add(arrListForInsert.get(i));
                insertObjects.add(arrListForInsert.get(i+1));
                insertObjects.add(arrListForInsert.get(i+2));
                insertObjects.add(arrListForInsert.get(i+3));
                insertObjects.add(arrListForInsert.get(i+4));
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);

				whereObjects.add(arrListForInsert.get(j));
				j += 5;

				insertData.add(insertObjects);
				whereData.add(whereObjects);
			}
		}
		else if (fieldCheck.equals("Both")) {
			for (int i=0;i<arrListForInsert.size() ;i+=3 ) {
				insertObjects=new ArrayList();
				whereObjects=new ArrayList();

				insertObjects.add(arrListForInsert.get(i));
				insertObjects.add(arrListForInsert.get(i+1));
				insertObjects.add("");
				insertObjects.add("");
				insertObjects.add(arrListForInsert.get(i+2));
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);

				whereObjects.add(arrListForInsert.get(j));
				j += 3;

				insertData.add(insertObjects);
				whereData.add(whereObjects);
			}
        }

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);

        HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_FORM_SELECT3") );
		    sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_FORM_INSERT") );
		}catch(Exception e){
			e.printStackTrace();
		}

	    /*SingleTableHandlerHome home = null;
        SingleTableHandlerRemote remote = null;*/

        try{
            /*InitialContext context = new InitialContext() ;
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

				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )
                //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
			    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
            else{
                if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
                else
                    map.put( "message", (map.get("msgid"))) ;
            }
        } catch(Exception e) {
            map.put( "message", e.getMessage()) ;
            e.printStackTrace() ;
        } 
        map.put( "flag" , insertData.toString());
        return map ;

    }
    // insert method ends here...


    // modify method starts here...
    public HashMap modify() {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;

        ArrayList modifyData = new ArrayList() ;

        modifyData.add( form_desc.trim() ) ;
        modifyData.add( form_code_loc_lang.trim() ) ;
        modifyData.add( form_desc_loc_lang.trim() ) ;
        modifyData.add( eff_status.trim() ) ;
        modifyData.add( login_by_id.trim() ) ;
        modifyData.add( login_at_ws_no.trim() ) ;
        modifyData.add( login_facility_id.trim() ) ;
        modifyData.add( form_code.trim() ) ;

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "ModifyData",modifyData);

        HashMap sqlMap = new HashMap() ;

		try{
			sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_FORM_UPDATE") );
		}catch(Exception e){
			e.printStackTrace();
		}

        /*SingleTableHandlerHome home = null;
        SingleTableHandlerRemote remote = null;*/

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

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )
            {
                map.put( "result", new Boolean( true ) ) ;
                //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                map.put( "flag","0");
            }
            else{
                map.put( "result", new Boolean( false ) ) ;
                map.put( "message", (map.get("msgid"))) ;
                map.put( "flag","0");
            }
        } catch(Exception e) {
            map.put( "message", e.getMessage()) ;
            map.put( "flag","0");
            e.printStackTrace() ;
        } 
        return map ;
    }
    // modify method ends here...

    public ArrayList displayCheck() throws Exception
    {
        ArrayList all=new ArrayList();
        String locallanguage = "0";
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT") ) ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
                if (resultSet.getString( "PAT_INSTR_LOC_LANG_YN" ).equals("Y")){
					locallanguage = "1"; // if PAT_INSTR_LOC_LANG_YN is Y
                }else{
					locallanguage = "0"; // if PAT_INSTR_LOC_LANG_YN is N
				}
            }else{
				locallanguage = "2";	// if PH_PARAM_FACILITY is Not Setup
			}
           all.add(locallanguage);
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
			es.printStackTrace();
			}
        }
        return all;
    }
    public ArrayList getValuesForModify(String form_code) throws Exception{

        ArrayList all=new ArrayList();

        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FORM_SELECT2") ) ;
            pstmt.setString(1,form_code.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
                all.add(resultSet.getString("FORM_CODE"));
                all.add(resultSet.getString("FORM_DESC"));
                all.add(resultSet.getString("FORM_CODE_LOC_LANG"));
                all.add(resultSet.getString("FORM_DESC_LOC_LANG"));
                all.add(resultSet.getString("EFF_STATUS"));
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
			es.printStackTrace();
			}
        }
        return all;
    }
}
