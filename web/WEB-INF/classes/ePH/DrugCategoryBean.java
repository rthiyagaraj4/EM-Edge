/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
    Module       : ePH
    Created Date : 03-01-2003
    Modified By  :
    Modified Date:
    Version      :
    Description  :
                  DrugCategoryBean contains
                  1.insert()
                  method which will use CallSingleTableHandlerEjb()
*/
//saved on 27/10/2005
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugCategoryBean extends PhAdapter implements Serializable {

    protected String drug_catg_code     ="";
    protected String long_desc          ="";
    protected String short_desc         ="";
    protected String eff_status         ="";
    protected String pin_auth_reqd_yn   ="";
    protected Hashtable hashMultiple     ;

/******************  Constructor  *************************************************/
    public DrugCategoryBean() {
        try {
            doCommon();
        }
        catch(Exception e) 
		{
			e.printStackTrace();
		}
    }

/*********** Over-ridden Adapter methods start here *******************************/
    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

/********* /* Set Methods Start ***************************************************/

    public void setDrugCatgCode( String drug_catg_code ) {
        this.drug_catg_code = drug_catg_code  ;
    }
    public void setLongDesc( String long_desc ) {
        this.long_desc = long_desc  ;
    }
    public void setShortDesc( String short_desc )   {
        this.short_desc = short_desc  ;
    }
	public void setauthreqdYN ( String pin_auth_reqd_yn ){
        if(pin_auth_reqd_yn.equals("") || pin_auth_reqd_yn==null )
            this.pin_auth_reqd_yn = "N" ;
        else
            this.pin_auth_reqd_yn = pin_auth_reqd_yn ;
    }
    public void setEffStatus ( String eff_status ){
        if(eff_status.equals("") || eff_status==null )
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;
    }

/*********** Get Methods Start ********************************************************/
    public String getDrugCatgCode() {
        return this.drug_catg_code  ;
    }
    public String getLongDesc() {
        return this.long_desc  ;
    }
    public String getShortDesc() {
        return this.short_desc  ;
    }
	public String getauthreqdYN (){
        return this.pin_auth_reqd_yn ;
    }

    public String getEffStatus (){
        return this.eff_status ;
    }

/********************* setAll  *******************************************************/
    public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }

/*************************************************************************************/
public HashMap insert()
{

    ArrayList insertData = new ArrayList() ;
    ArrayList whereData = new ArrayList() ;

    for(int i=0; i<10;i++)
    {
        String drugCode = "drug_catg_code"  + i ;
        String longDesc = "long_desc"  + i ;
        String shortDesc = "short_desc"  + i ;
        ArrayList insertRow = new ArrayList() ;
        ArrayList whereRow = new ArrayList() ;

        if(!
              (  (((String)hashMultiple.get(drugCode))).trim().equals("")
                                    ||
                (((String)hashMultiple.get(longDesc))).trim().equals("")
                                    ||
                (((String)hashMultiple.get(shortDesc))).trim().equals("")
              )
          )
        {
            /***** 4 values per row from the AddModify form  */

            insertRow.add( (String)hashMultiple.get(  ("drug_catg_code" + i)    )  ) ;
            insertRow.add( (String)hashMultiple.get(  ("long_desc" + i)         ) ) ;
            insertRow.add( (String)hashMultiple.get(  ("short_desc" + i)        ) ) ;

		
			if( (((String)hashMultiple.get(("pin_auth_reqd_yn" + i)))==null) || (((String)hashMultiple.get(("pin_auth_reqd_yn" + i))).equals("") ))
                insertRow.add(  "N"  ) ;
            else
                insertRow.add( (String)hashMultiple.get(  ("pin_auth_reqd_yn" + i) ) ) ;

			if(( ((String)hashMultiple.get(("eff_status"+i)))==null) || (((String)hashMultiple.get(("eff_status"+i))).equals("")) )

                insertRow.add(  "D"  ) ;
            else
                insertRow.add( (String)hashMultiple.get(  ("eff_status"+i) ) ) ;

            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;
            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;

            whereRow.add( (String)hashMultiple.get(  ("drug_catg_code" + i) )  ) ;

            /* note:-
            The insertData and whereData should be arraylist of arraylist
            in case of insertMultiple() of SingleTableHandler
            */
            insertData.add( insertRow ) ;
            whereData.add( whereRow ) ;
        }
        }//for

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);

        HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_CATG_SELECT3" ) );
			//sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_CATG_INSERT") );
			sqlMap.put( "InsertSQL", "INSERT INTO PH_DRUG_CATG (DRUG_CATG_CODE, LONG_DESC, SHORT_DESC,PIN_AUTH_REQD_YN, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?) " );
		}catch(Exception e){
			e.printStackTrace();
		}

return CallSingleTableHandler( tabData,sqlMap );
}

/**********************************************************************************/
public HashMap modify()
{
	        ArrayList insertRow = new ArrayList() ;

            insertRow.add( (String)hashMultiple.get(  "long_desc"  ) ) ;
            insertRow.add( (String)hashMultiple.get(  "short_desc"  ) ) ;
			if(( ((String)hashMultiple.get("pin_auth_reqd_yn" ))==null )||(((String)hashMultiple.get("pin_auth_reqd_yn")).equals("") ))
                insertRow.add(  "N"  ) ;
            else
                insertRow.add((String)hashMultiple.get(("pin_auth_reqd_yn"))) ;

            if( (((String)hashMultiple.get(("eff_status" ))) == null) || (((String)hashMultiple.get(("eff_status"))).equals("")) )
                insertRow.add(  "D"  ) ;
            else
                insertRow.add( (String)hashMultiple.get( ("eff_status" )) ) ;

            insertRow.add( login_by_id ) ;
            insertRow.add( login_at_ws_no ) ;
            insertRow.add( login_facility_id ) ;

            insertRow.add( drug_catg_code  ) ;

            HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "ModifyData",insertRow);

            HashMap sqlMap = new HashMap() ;
			try{
				//sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_CATG_UPDATE" ) );
				sqlMap.put( "ModifySQL", "UPDATE PH_DRUG_CATG SET LONG_DESC = ?, SHORT_DESC = ?,PIN_AUTH_REQD_YN=?, EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE DRUG_CATG_CODE = ? " );
			}catch(Exception e){
				e.printStackTrace();
			}

			return CallSingleTableHandler(tabData,sqlMap );
}

/********************************************************************************/
private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
 {
    HashMap map = new HashMap() ;
    map.put( "result", new Boolean( false ) ) ;

/*  SingleTableHandlerHome home = null;
    SingleTableHandlerRemote remote = null;*/

    try {
			//System.err.println("entering single tab handler");
/*        InitialContext context = new InitialContext() ;
        Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
        remote = home.create() ;

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
            map = remote.singleBatchHandler( tabData, sqlMap ) ;
        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
            map = remote.modify( tabData, sqlMap ) ;
        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) ){
             map = remote.delete( tabData, sqlMap ) ;
        }*/

		Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
		Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]=new Object[2];
		argArray[0]=tabData;
		argArray[1]=sqlMap;

		Class[] paramArray=new Class[2];
		paramArray[0]=tabData.getClass();
		paramArray[1]=sqlMap.getClass();

        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  )
		{
		    map=(HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
		}
		else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) )
		{
		     map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		}
		else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE" )) )
		{
		     map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
		}

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

        if( ((Boolean) map.get( "result" )).booleanValue() )
          //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
		  map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
        else{
				String msgID = "";
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
//					msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				} else{
					msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ;
					map.put( "message", msgID) ;
				}
            }
        }
        catch(Exception e) {
        System.err.println( "Error Calling EJB classcast : "+e ) ;
        map.put( "message", e.getMessage()+"classcast") ;
        e.printStackTrace() ;
        }
/*		finally {
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

/*********************************************************************************/
    public void loadData() throws Exception {
		//System.err.println("loadData in bean--->");
        String []stParameters       =   {getDrugCatgCode()};
        HashMap hmRecord    =   null;
       // hmRecord    =   fetchRecord(PhRepository.getPhKeyValue( "SQL_PH_DRUG_CATG_SELECT2" ), stParameters);
        hmRecord    =   fetchRecord("SELECT A.DRUG_CATG_CODE, A.LONG_DESC, A.SHORT_DESC, A.PIN_AUTH_REQD_YN,A.EFF_STATUS FROM PH_DRUG_CATG A WHERE A.DRUG_CATG_CODE = ?" , stParameters);

                setLongDesc ( (String)hmRecord.get  ("LONG_DESC")   ) ;
                setShortDesc( (String)hmRecord.get  ("SHORT_DESC")  ) ;
                setauthreqdYN( (String)hmRecord.get  ("PIN_AUTH_REQD_YN")  ) ;
                setEffStatus( (String)hmRecord.get  ("EFF_STATUS")  ) ;
 }
/*********************************************************************************/
public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
	//System.err.println("fetchRecord in bean");
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

            resultSet.next();
            for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
                hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));

        }
        catch (Exception exception )    {
            System.err.println("Error loading values from database");
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
/*********************************************************************************/
//this function are used  pinauthreqdYN checkbocx
	public String PinAuthReqdYN() {
		
        String pinauthreqdYN=" ";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;

        try {
            connection = getConnection() ;
           
		   pstmt				= connection.prepareStatement("SELECT DRUG_CAT_PIN_AUTH_REQD_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?");
		   pstmt.setString(1,login_facility_id.trim());
           resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next()) {
                pinauthreqdYN=resultSet.getString("DRUG_CAT_PIN_AUTH_REQD_YN");
            //System.err.println("pinauthreqdYN----while loop----->"+pinauthreqdYN);
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
				es.printStackTrace() ;
            }

        }
		return pinauthreqdYN;
    }









}//class end
