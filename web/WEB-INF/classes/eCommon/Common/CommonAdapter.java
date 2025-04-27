/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.Common ;

import java.sql.* ;
import java.util.* ;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import webbeans.eCommon.* ;
/**
 *
 *
 *
 */
public abstract class CommonAdapter implements Serializable {
    protected String mode                   ;
    protected String module_id              ;
    protected String function_id            ;
    protected Properties properties         ;

    protected String login_by_id            ;
    protected String login_at_ws_no         ;
    protected String login_facility_id      ;
    private     String acc_entity_id    ;

    protected String orderBy    ;
    protected ArrayList list    = null ;
    protected ArrayList primKeys= null ;
	protected String language_id    ;
/**
 *
 *
 */
    public CommonAdapter() {
    }
/**
 *
 * @param module_id Module ID
 */
    public CommonAdapter( String module_id ) {
        this.module_id = module_id ;
    }
/**
 *
 * @param mode  Sets mode
 */
    public void setMode( String mode ) {
        this.mode = mode ;
    }

/**
 *
 * @param mode Defines the mode of operation. Mode is taken from CommonRepository
 * @param mh  CommonMultipleHandler obj that needs to be stored in the session
 * @param session   HttpSession
 */
    public void setMode( String mode, CommonMultipleHandler mh, javax.servlet.http.HttpSession session ) {
        this.mode = mode ;
        session.setAttribute("mh",mh) ;
    }
/**
 *
 * @param module_id Module ID <br>Ex. MP,SM,IP
 */
    public void setModuleId( String module_id ) {
        this.module_id = module_id ;
    }

/**
 *
 * @param function_id   Function ID
 */
    public void setFunctionId( String function_id ) {
        this.function_id = function_id ;
    }
/**
 *
 * @param properties    Properties Object picked from the session
 */
    public void setProperties( Properties properties ) {
        this.properties = properties ;
    }
/**
 *
 * @param login_by_id   Logged in UsedID
 */
    public void setLoginById ( String login_by_id ) {
        this.login_by_id = login_by_id ;
    }

/**
 *
 * @param login_at_ws_no    IP Address of client machine
 */
    public void setLoginAtWsNo ( String login_at_ws_no ) {
        this.login_at_ws_no = login_at_ws_no ;
    }

/**
 *
 * @param login_facility_id     Logged in Facility ID
 */
    public void setLoginFacilityId ( String login_facility_id ) {
        this.login_facility_id = login_facility_id ;
    }

    /**
     *
     * @param acc_entity_id     Acc Entity ID
    */
    public void setAccEntityID(String acc_entity_id)
    {
       this.acc_entity_id = acc_entity_id ;
    }

/**
     *
     * @param language_id     Language ID
    */
	public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
	}

/**
 *
 * @return      Mode
 */
    public String getMode() {
        return this.mode ;
    }
/**
 *
 * @return      ModuleID
 */
    public String getModuleId() {
        return this.module_id ;
    }

/**
 *
 * @return  Function ID
 */
    public String getFunctionId() {
        return this.function_id ;
    }
/**
 *
 * @return      Properties
 */
    public Properties getProperties() {
        return this.properties ;
    }

/**
 *
 * @return      Log in ID
 */
    public String getLoginById () {
        return this.login_by_id ;
    }

/**
 *
 * @return       IP Address of client machine
 */
    public String getLoginAtWsNo () {
        return this.login_at_ws_no ;
    }

/**
  *
 * @return      Logged in Facility ID
 */
    public String getLoginFacilityId () {
        return this.login_facility_id ;
    }

/**
 *
 * @return       Entity ID
 */

public String getAccEntityID()
{
    return this.acc_entity_id;
}

/**
 *
 * @return       Language ID
 */
	public String getLanguageId() {
		 return language_id;
	}

/**
 *
 * @return  java.sql.Connection
 * @throws Exception
 */
    public Connection getConnection() throws Exception {
        Connection connection = null ;
        connection = ConnectionManager.getConnection( properties ) ;
        return connection ;
    }

/**
 *
 * @param connection    java.sql.Connection
 * @throws Exception
 */
    public void closeConnection( Connection connection ) throws Exception {
        if( connection != null )
            ConnectionManager.returnConnection( connection, properties ) ;
    }

/**
 *
 * @param pstmt             java.sql.PreparedStatement
 * @throws Exception
 */
    public void closeStatement( PreparedStatement pstmt ) throws Exception {
        if( pstmt != null )
            pstmt.close() ;
    }

/**
 *
 * @param stmt              java.sql.Statement
 * @throws Exception
 */
    public void closeStatement( Statement stmt ) throws Exception {
        if( stmt != null )
            stmt.close() ;
    }

/**
 *
 * @param cstmt             java.sql.CallableStatement
 * @throws Exception
 */
    public void closeStatement( CallableStatement cstmt ) throws Exception {
        if( cstmt != null )
            cstmt.close() ;
    }

/**
 *
 * @param resultSet         java.sql.ResultSet
 * @throws Exception
 */
    public void closeResultSet( ResultSet resultSet ) throws Exception {
        if( resultSet != null )
            resultSet.close() ;
    }

/**
 *
 *Method called before trasaction where validations should take place.
 * @return      HashMap containing the error information.
 * @throws Exception
 */
    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;

        return map ;
    }

/**
 *  Method  that calls insert(), delete() or modify() method depending on the mode of execution.
 * @return  HashMap containing transaction details.
 */
    public HashMap apply() {
        try
        {
            if ( mode.equals( (String)CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
                return delete() ;
            } else if ( mode.equals( (String) CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
                return insert() ;
            } else if ( mode.equals( (String) CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {
                return modify() ;
            }
        }
        catch(Exception e){
            HashMap map = new HashMap() ;
            map.put( "result", new Boolean( false ) );
            map.put( "message", "Exception in Invalid Operation.."+e+" : Mode passed : *"+mode+"*");
            return map ;
        }

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) );
        map.put( "message", "Invalid Operation.."+mode );
        return map;
    }

/**
 *Method called for deletion of records
 * @return  HashMap containing transaction details.
 */
    public HashMap delete() {
        return new HashMap() ;
    }

/**
 *Method called for an insertions of records
 * @return  HashMap containing transaction details.
 */
    public HashMap insert() {
        return new HashMap() ;
    }

/**
 *Method called for an updations of records
 * @return  HashMap containing transaction details.
 */
    public HashMap modify() {
        return new HashMap() ;
    }

/**
 *
 *Resets the object
 */
    public void clear() {
      mode                = null ;
      orderBy             = null ;
      list                   = null ;
      primKeys            = null ;

    /*
      login_by_id      =null;
      login_at_ws_no  =null;
      login_facility_id  =null;
      acc_entity_id    =null;
    */

    }

/**
 * Method used is setting values to object.
 * @param recordSet
 */
    public void setAll( Hashtable recordSet ) {
    }


public void initialize(){  }
/**
 *
 * @param msgId     Message ID
 * @return              Message description
 */
    public String getMessage( String msgId ) {
        Connection connection = null ;
        PreparedStatement pstmt_msg = null ;
        ResultSet rs_msg = null ;
        String msgtext = "" ;

        try {
            connection = getConnection() ;
            pstmt_msg = connection.prepareStatement( (String) CommonRepository.getCommonKeyValue("SQL_GET_MESSAGE") ) ;
            pstmt_msg.setString(1, msgId) ;
            rs_msg = pstmt_msg.executeQuery() ;
            if(rs_msg != null && rs_msg.next()) {
               msgtext = "APP-" + rs_msg.getString( "MESSAGE_ID" ) + " " + rs_msg.getString("MESSAGE_TEXT_SYSDEF") + "<br>" ;
            } else {
               //msgtext = "Message Not Avaliable in SM_MESSAGE <br>" ;
               msgtext = msgId ;
            }
        } catch( Exception e) {
                msgtext = "Error in Message: "+e ;
        } finally {
            try{
                closeResultSet( rs_msg ) ;
                closeStatement( pstmt_msg ) ;
                closeConnection( connection ) ;
            } catch(Exception es) {}
        }
        return msgtext ;
    }

/**
 *
 * @param msgId     Message ID
 * @param htmlMessage true if message description needs to be appended with HTML break (<br>) tag
 * @return              Message description
 */
    public String getMessage( String msgId , boolean htmlMessage ) {
        String result = "" ;

        result = getMessage( msgId ) ;

        if ( htmlMessage )
            result += "<br>" ;

        return result ;
    }

/**
 *
 * @param locale     Language ID
 * @param messageId  Message Id
 * @param moduleId	 Module Id
 * @return           Message description
 */
	public  String getMessage(String locale, String messageId, String moduleId)
	{
	
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String message_desc = (String) message.get("message");
		message.clear();
        return(message_desc) ;
    }

/*
    public ArrayList getQueryResultPage (HashMap sqlMap,HashMap funcMap,HttpServletRequest req ) throws Exception {
        return getQueryResultPage( sqlMap, funcMap, req, false );
    }

    public ArrayList getQueryResultPage (HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup ) throws Exception {
        Connection connection       = null;
        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;
        if( !lookup ) setOrderby(orderbycolumns);
        String from                 = req.getParameter( "from" ) ;
        String to                   = req.getParameter( "to" ) ;
        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
        String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;
        String sqlData              = (String)sqlMap.get( "sqlData" );
        ArrayList error             = new ArrayList();
        String prevnextlink         = "";
        int query_result_size       = Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );

        StringBuffer msgsb = new StringBuffer();
        int start = 0 ;
        int end = 0 ;

        if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from  ) ;

        if ( to == null )
            end =query_result_size;
        else
            end = Integer.parseInt( to ) ;

        PreparedStatement pstmtCount  =null;
        PreparedStatement pstmtData = null;
        ResultSet rs=null;
        int maxRecord = 0;
        ArrayList result = new ArrayList();
        result.clear();
        result.add("total");
        result.add("prevnext");
        try {
            connection=getConnection();
            int fldkey=1;
            try {
                msgsb.append( " SQL : "+sqlData );
                msgsb.append( " Connection : " + connection );
                if( !lookup )
                    pstmtData = connection.prepareStatement( sqlData + orderBy );
                else
                    pstmtData = connection.prepareStatement( sqlData );
                msgsb.append( " PreparedStatement : " + pstmtData);

                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                    Object fldValue = chkFields.get(fldcount) ;
                    if( fldValue instanceof String ) {
                        if( !lookup )
                          pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                        else {
                            if( searchCriteria.equals( "S" ) )
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                            else if( searchCriteria.equals( "E" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount)) ) ;
                            else if( searchCriteria.equals( "C" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount))+"%" ) ;
                            else
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                        }
                    }
                    else if ( fldValue instanceof Integer )
                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                    else if ( fldValue instanceof Long )
                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                    else if ( fldValue instanceof Float )
                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                    else if ( fldValue instanceof Double )
                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
                    fldkey++;
                }//for
                rs = null;
                rs = pstmtData.executeQuery();
                msgsb.append( "ResultSet : " + rs);
                long count = 0;
                long i = 0;

                if( rs != null ) {
                    while( rs.next() && i <= end+1 ) {
                        if( start != 1 && (i+1) < start ) {
                            i++;
                            continue;
                        }
                        else i++;
                        count++ ;
                        if(i <= end ) {
                            ArrayList records=new ArrayList();
                            records.clear();
                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
                                records.add(rs.getString((String)displayFields.get( dispfldCount )));
                            result.add(records);
                        }
                    }
                    result.set( 0, String.valueOf( count ) ) ;
                    if( start != 1 )
                        prevnextlink += "<td class=\"WHITE\" align=\"right\"><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">Previous</A>" ;
                    if( count > 14 )
                        prevnextlink += "&nbsp;&nbsp;<td class=\"WHITE\" align=\"right\"><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">Next</A>" ;
                    result.set( 1, prevnextlink ) ;
                }

            }catch(Exception ed) {
                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
                result.add(error);
            }
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) closeResultSet( rs ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtCount != null ) closeStatement( pstmtCount ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }
        return result;
    }
*/

/**
 *
 * @param commonMap     HashMap that contains coumns involved
 * @param funcMap          HashMap that contains other details like displayFields,chkFields,primFields(Primary Key fields),primKeyDataType
 * @return Message description
 */

    public ArrayList getQueryResultPage( HashMap commonMap,HashMap funcMap ) throws Exception {
        ArrayList displayFields    = (ArrayList)funcMap.get( "displayFields" );
        ArrayList chkFields        = (ArrayList)funcMap.get( "chkFields" );
        ArrayList primFields       = (ArrayList)commonMap.get( "primFields" );
        ArrayList primKeysDataType = (ArrayList)commonMap.get ("primKeyDataType") ;
        ArrayList error            = new ArrayList();
        ArrayList result           = new ArrayList();
        result.clear();

        String prevnextlink="";
        String from     = (String)commonMap.get( "from" );
        String search   = (String)commonMap.get( "searched" );
        String sqlKey   = (String)commonMap.get( "sqlKey" );
        String sqlData  = (String)commonMap.get( "sqlData" );
        String linkpage = (String)commonMap.get( "prevnextlink" );

        int query_result_size =Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );

        int starting = 0 ;
        int last = 0 ;
        int count = 0 ;
        boolean searched = false ;

        Connection connection = null ;
        PreparedStatement pstmtKey = null ;
        PreparedStatement pstmtData = null ;
        ResultSet rsKey = null ;
        ResultSet rsData = null ;

        try{
            if ( from == null )
                from = "1" ;
            else
                starting = Integer.parseInt( from ) ;

            if ( search == null || search.equals( "null" ) || search.equals("") )   {
                list = null ;
                searched = false ;
            } else {
                searched = true ;
            }

            int next = starting + query_result_size ;
            connection = getConnection() ;
            if ( searched ) {
                last = (list.size() - starting) < query_result_size ? (list.size() - starting) : query_result_size ;
                if ( starting >= query_result_size )
                    prevnextlink+= "<td class='WHITE' align='right'><a href='"+linkpage+"?searched=1&from=" + (starting-query_result_size) + "'>Previous</a>&nbsp;&nbsp;</td>" ;
                else
                    prevnextlink+="<td class='WHITE'>&nbsp;</td>"  ;

                if ( list.size() > (starting+query_result_size) )
                    prevnextlink+= "<td class='WHITE' align='right'><a href='"+linkpage+"?searched=1&from=" + (starting+query_result_size) + "'>Next</a></td>" ;
                else
                    prevnextlink+="<td class='WHITE'>&nbsp;</td>" ;

                result.add(prevnextlink);
                while ( count < last ) {
                    pstmtData = connection.prepareStatement( sqlData ) ;
                    int fld=1;
                    ArrayList setKeys = new ArrayList() ;
                    setKeys=(ArrayList)list.get( starting );
                    for( int listCount=0;  listCount<setKeys.size();  listCount++ ){
                        pstmtData.setString( fld, "" + setKeys.get( listCount ) ) ;
                        fld++;
                    }
                    rsData = pstmtData.executeQuery() ;
                    if ( rsData != null && rsData.next() ) {
                        ArrayList records = new ArrayList();
                        records.clear();
                        for( int recCount=0;  recCount<displayFields.size();  recCount++ )
                            records.add(rsData.getString((String)displayFields.get(recCount)));
                        ++count ;
                        ++starting ;
                        result.add(records);
                        closeResultSet( rsData ) ;
                        closeStatement( pstmtData ) ;
                    }
                }
            } else {
                 sqlKey+=orderBy;
                 try{
                    int ctrlLink=0;
                    pstmtKey = connection.prepareStatement( sqlKey ) ;
                    int fldkey=1;
                    for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                        Object fldValue = chkFields.get(fldcount) ;

                        if( fldValue instanceof String ) {
                            String fldvalue=((String) chkFields.get(fldcount))+"%";
                            pstmtKey.setString( fldkey, fldvalue ) ;
                        }
                        else if ( fldValue instanceof Integer )
                            pstmtKey.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                        else if ( fldValue instanceof Long )
                            pstmtKey.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                        else if ( fldValue instanceof Float )
                            pstmtKey.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                        else if ( fldValue instanceof Double )
                            pstmtKey.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;

                        fldkey++;
                    }
                    rsKey = pstmtKey.executeQuery() ;
                    rsKey.setFetchSize( 100 ) ;

                    list = new ArrayList() ;
                    int keyCount = 0 ;

                    while( rsKey != null && rsKey.next() ) {
                        ++keyCount ;
                        primKeys = new ArrayList() ;
                        for( int primfldCount=0;  primfldCount<primFields.size();  primfldCount++ ){
                        String subflds=( (String) primFields.get(primfldCount) );

                            String primarykeydatatype = ((String)primKeysDataType.get(primfldCount)) ;

                            if( primarykeydatatype.equals("String") )
                            {
                                primKeys.add( rsKey.getString(subflds) );
                            }
                            else if( primarykeydatatype.equals("Integer") )
                                primKeys.add( new Integer(rsKey.getInt(subflds)) );
                            else if( primarykeydatatype.equals("Float") )
                                primKeys.add( new Float(rsKey.getFloat(subflds)) );
                            else if( primarykeydatatype.equals("Long") )
                            {
                                primKeys.add( new Long(rsKey.getLong(subflds)) );

                            }
                            else if( primarykeydatatype.equals("Double") )
                                primKeys.add( new Double(rsKey.getDouble(subflds)) );
                        }

                        if ( keyCount <= query_result_size+1 ) {

                          if(keyCount > query_result_size){
                              prevnextlink="<td align='right' class='WHITE'><a href='"+linkpage+"?searched=1&from=" + next + "'>Next</a></td>";
                          }
                          else{
                              prevnextlink="<td class='WHITE'>&nbsp;</td>"  ;
                          }
                          if(ctrlLink==0)
                              result.add( 0, prevnextlink );

                          ctrlLink++;
                          result.set(0,prevnextlink);

                          if ( keyCount <= query_result_size ) {
                            try{
                                pstmtData = connection.prepareStatement( sqlData ) ;
                                int fld=1;
                                  for( int dataCount=0;  dataCount<primKeys.size();  dataCount++ ) {
                                     Object fldValue = primKeys.get(dataCount) ;
                                     if( fldValue instanceof String )
                                     {
                                         pstmtData.setString( fld, (String)fldValue ) ;
                                     }
                                    else if ( fldValue instanceof Integer )
                                        pstmtData.setInt( fld, ((Integer)fldValue).intValue() ) ;
                                    else if ( fldValue instanceof Long )
                                    {
                                        pstmtData.setLong( fld, ((Long)fldValue).longValue() ) ;
                                    }
                                    else if ( fldValue instanceof Float )
                                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                                    else if ( fldValue instanceof Double )
                                        pstmtData.setDouble( fld, ((Double)fldValue).doubleValue() ) ;

                                    fld++;
                                }

                                rsData = pstmtData.executeQuery() ;
                                if ( rsData != null && rsData.next() ) {
                                    ArrayList records=new ArrayList();
                                    records.clear();
                                    for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
                                        records.add(rsData.getString((String)displayFields.get( dispfldCount )));
                                    result.add(records);
                                    closeResultSet( rsData ) ;
                                    closeStatement( pstmtData ) ;
                                }
                            } catch(Exception ep) {
                                error.add("Exception @ dataQry:"+ep);
                                result.add(error);
                            }
                        }
                      }
                      list.add( primKeys ) ;
                    }

                    closeResultSet( rsKey ) ;
                    closeStatement( pstmtKey ) ;
                } catch(Exception e) {
                    error.add("Exception @ keyQry:"+e);
                    result.add(error);
                }
            }
        } catch(Exception ex) {
            error.add(ex.getMessage());
            result.add(error);
        } finally {
            try{
                if( rsKey != null ) closeResultSet( rsKey ) ;
                if( rsData != null ) closeResultSet( rsData ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtKey != null ) closeStatement( pstmtKey ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }
        return result;
    }
//query result end

    /**
      *sets AddedBy details.
      * tabData HashMap containing login_byid, login_facility_id,login_at_ws_no
    */
    public void setAddedProfile(HashMap tabData) {
        tabData.put( "added_by_id",             login_by_id         ) ;
        tabData.put( "added_facility_id",       login_facility_id   ) ;
        tabData.put( "added_at_ws_no",          login_at_ws_no      ) ;
    }


    /**
      *sets ModifiedBy details.
      * tabData HashMap containing login_by_id, login_facility_id,login_at_ws_no
    */
    public void setModifiedProfile(HashMap tabData) {
        tabData.put( "modified_by_id",          login_by_id         ) ;
        tabData.put( "modified_facility_id",    login_facility_id   ) ;
        tabData.put( "modified_at_ws_no",       login_at_ws_no      ) ;
    }

    public void setUserProfile(HashMap tabData) {
        tabData.put( "login_by_id",             login_by_id         ) ;
        tabData.put( "login_facility_id",       login_facility_id   ) ;
        tabData.put( "login_at_ws_no",          login_at_ws_no      ) ;
    }
    /**
        logs error message
        e   Exception Object
    */
    public void logErrorMessage(Exception e) {
        e.printStackTrace() ;
    }

    /**
        inputString String to be validated for null
        @return validated String
    */
    public static String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
    }

    /**
        inputString String to be validated for null
        defaultValue    If input string is null, string is replaced with defaultValue
        @return returns formatted String
    */
    public static String checkForNull( String inputString, String defaultValue ) {
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
    }
/**
    Utility function that replaces \n character with <br> tag
    message String to be relaced
*/
    public String replaceNewLineChar(String message) {

		return message.replaceAll("\n","<br>");
        /*String spChar[]={"\n"};
        String chChar[]={"<br>"};

        StringBuffer sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
                            continue upper;
                        }
                    }
        return sb.toString();*/
    }

/**
    Used in case of multiple insertion functions
    invalidCodesArray   ArrayList that contains nested Arrraylist that holds the error messages to be delimited
    @return Delimited String
*/
    public String delimitedString( ArrayList invalidCodesArray ) {

        int i,j ;
        String errorString = "" ;
        boolean once = false ;
        for(i=0 ; i<invalidCodesArray.size() ; i++ ) {
            ArrayList invalidCode = (ArrayList) invalidCodesArray.get(i) ;
            String codeString = "" ;
            boolean codeOnce = false ;
            for(j=0 ; j<invalidCode.size() ; j++ ) {
                if( codeOnce )
                    codeString += ":"+ ( String )invalidCode.get(j);
                else {
                    codeString = ( String )invalidCode.get(j);
                    codeOnce = true ;
                }
            }
            if( once )
                errorString += ","+codeString ;
            else {
                errorString = codeString ;
                once = true ;
            }
        }

        return errorString ;
    }

    /**
       *Method defined to get database values for the select object
       *sql     SQL to be executed for fetching te value
       *alParameters    Arraylist containing the data that needs to be used in executing the sql statement
       *selectValue     Default value to be selected
    */
    public ArrayList getListOptionArrayList(String sql,ArrayList alParameters, String selectValue)
    {
            Connection connection               = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet                 =   null;

            ArrayList alOptionValues = new ArrayList();
            // if(isSelectRequired)
            //    alOptionValues.add(CommonRepository.getCommonKeyValue("DEFAULT_LIST_OPTION").toString());

            if(selectValue == null) selectValue = "" ;

            if( !selectValue.equals("") )
                alOptionValues.add( "<option value=\"\">"+selectValue+"</option>" ) ;
            try {
                connection=getConnection();
                preparedStatement=connection.prepareStatement(sql);
                if (alParameters!=null) {
                   /* for (int index=0;index<alParameters.size();index++) {
                        preparedStatement.setString(index+1,alParameters.get(index).toString());
                    }*/
                    setData( preparedStatement, alParameters ) ;
                }
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    alOptionValues.add(new OptionValues(resultSet.getString(1),resultSet.getString(2)));
                }
            }
            catch (java.sql.SQLException exception) {
                alOptionValues.add(new OptionValues(sql+alParameters+"","SQL Exception :"+exception.getErrorCode()+" : "+ exception.getMessage()));
            }
            catch (Exception exception) {
                alOptionValues.add(new OptionValues("","Exception : "+exception.getMessage()));
            }
            finally{
                try {
                    closeResultSet(resultSet);
                    closeStatement(preparedStatement);
                    closeConnection(connection);
                }
                catch (Exception exception) {
                    alOptionValues.add(new OptionValues("Error : "+exception.getMessage(),""));
                }
            }
            return alOptionValues;
    }

    /**
       *arrayListValue  Collection that holds the values using which option tags are constructed
       *defaultValue     Default selection values
       *@return Constructed String
    */
    public String getListOptionTag(ArrayList arrayListValue,String[] defaultValue) {

        if (arrayListValue == null) {
            return null;
        }
        boolean foundDefault = false;
        StringBuffer tagValue = new StringBuffer();
        Object tempObject = null;
        OptionValues tempOptionValues = null;

       //String retVal = "";

        for (int count=0;count<arrayListValue.size();count++ ) {
            tagValue.append('\n');
            tempObject = arrayListValue.get(count);
            if ((!foundDefault) && (tempObject instanceof OptionValues)) {
                tempOptionValues = (OptionValues) tempObject;

               for( int i=0; i<defaultValue.length; i++ )
               {
                    if ( ( tempOptionValues.getValue()).equals(defaultValue[i] ))
                    {
                        tempOptionValues.setDefault(true);
                        // tagValue.append("--Pari :"+tempOptionValues.getValue()+" "+defaultValue[i]+":Pari--") ;
                    }
               }
                tagValue.append(tempOptionValues.toString());
            }
            else {
                tagValue.append(tempObject.toString());
            }
        }
        tagValue.append('\n');
        tempObject = null;
        tempOptionValues = null;

        return tagValue.toString();
    }

    /**
       *arrayListValue  Collection that holds the values using which option tags are constructed
       *selectValue       ---Select--- value
       *defaultValues     Default selection values
       *@return Constructed String
    */
    public String getListOptions( String sql, ArrayList alParameters, String selectValue, String[] defaultValues )
    {
        return( getListOptionTag((getListOptionArrayList(sql, alParameters  , selectValue)), defaultValues) ) ;
    }

    /**
        *preparedstatement  PreparedStatement to which values needs to be set using setXXX
        *dataObjects            Collection that holds the values
        *@return Constructed PreparedStatement
    */
    public PreparedStatement setData(PreparedStatement preparedstatement, ArrayList dataObjects) {
        try {
            for(int i = 0; i <  dataObjects.size(); i++) {
                Object dataObject = dataObjects.get(i) ;

                if(dataObject instanceof String) {
                    if(((String)dataObject).equalsIgnoreCase("null"))
                         preparedstatement.setString(i + 1, null);
                    else
                       preparedstatement.setString(i + 1, (String)dataObject);
                }
                else if(dataObject instanceof Integer)
                    preparedstatement.setInt(i + 1, ((Integer)dataObject).intValue());
                else if(dataObject instanceof Long)
                    preparedstatement.setLong(i + 1, ((Long)dataObject).longValue());
                else if(dataObject instanceof Double)
                    preparedstatement.setDouble(i + 1, ((Double)dataObject).doubleValue());
                else if(dataObject instanceof Float)
                    preparedstatement.setFloat(i + 1, ((Float)dataObject).floatValue());
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return preparedstatement;
    }

}
