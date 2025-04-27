/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCommon.Common ;

import java.util.* ;

public class CommonRepository {

      /**
*/

    private static CommonRepository instance ;

    private HashMap dataMap ;

    private  CommonRepository() throws Exception {
        dataMap = new HashMap() ;
        load() ;
    }
/**
 *
 * @param key   Key value as listed below
       *  <table>
              *  <tr><th align="left">Key Description</td><th align="left">Key Code</th></tr>
              *  <tr><td>Default list value</td><td>DEFAULT_LIST_OPTION</td></tr>
              *  <tr><td>Value for Delete Mode</td><td>MODE_DELETE</td></tr>
              *  <tr><td>Value for Insert Mode</td><td>MODE_INSERT</td></tr>
              *  <tr><td>Value for Delete Mode</td><td>MODE_MODIFY</td></tr>
              *  <tr><td>Integer identifier</td><td>PK_INT</td></tr>
              *  <tr><td>Long identifier</td><td>PK_LONG </td></tr>
              *  <tr><td>Float identifier</td><td>PK_FLOAT</td></tr>
              *  <tr><td>Double identifier</td><td>PK_DOUBLE</td></tr>
              *  <tr><td>String identifier</td><td>PK_STRING</td></tr>
              *  <tr><td>AccidentalEmergency module ID</td><td>ID_AE</td></tr>
              *  <tr><td>Application Masters module ID</td><td>ID_AM</td></tr>
              *  <tr><td>Billing Module ID</td><td>ID_BL</td></tr>
              *  <tr><td>Clinician Access module ID</td><td>ID_CA</td></tr>
              *  <tr><td>Duplicate Registration module ID</td><td>ID_DR</td></tr>
              *  <tr><td>Frequency module's ID</td><td>ID_FM</td></tr>
              *  <tr><td>HA module ID</td><td>ID_HA</td></tr>
              *  <tr><td>Inpatient Module ID</td><td>ID_IP</td></tr>
              *  <tr><td>Material Management ID</td><td>ID_MM</td></tr>
              *  <tr><td>Master patient index module ID</td><td>ID_MP</td></tr>
              *  <tr><td>Outpatient Appointment Module ID</td><td>ID_OA</td></tr>
              *  <tr><td>Outpatient module ID</td><td>ID_OP</td></tr>
              *  <tr><td>OrderEntry module ID</td><td>ID_OR</td></tr>
              *  <tr><td>Pharmacy module ID</td><td>ID_PH</td></tr>
              *  <tr><td>PO module ID</td><td>ID_PO</td></tr>
              *  <tr><td>System Manager module ID</td><td>ID_SM</td></tr>
              *  <tr><td>Speciality  module ID</td><td>ID_SP</td></tr>
              *  <tr><td>Sterile Stock module ID</td><td>ID_SS</td></tr>
              *  <tr><td>Stock module ID</td><td>ID_ST</td></tr>
              *  <tr><td>Number of records to be fetched in query result page</td><td>QUERY_RESULT_SIZE</td></tr>
              *  <tr><td>Number of records to be displayed in Multiple insertion page</td><td>MULTIPLE_INSERT_PAGE_SIZE</td></tr>
              *  <tr><td>SQL for getting system date and time</td><td>SQL_SYS_DATE_TIME</td></tr>
              *  <tr><td>SQL to get the messages from database</td><td>SQL_GET_MESSAGE</td></tr>
              *  <tr><td>JNDI location id for JDBC connection</td><td>JNDI_JDBC</td></tr>
              *   <tr><td>JNDI location for SingleTabHandler EJB</td><td>JNDI_SINGLE_TABLE_HANDLER</td></tr>
       *  </table>
     * @return          Value mapped to the key
   */
    public static synchronized String getCommonKeyValue( String key ) {

        String val = "" ;
      try
      {
        if ( instance == null )
            instance = new CommonRepository() ;

            val = instance.getValue( key ) ;
      }
       catch( Exception e ){ val = e.toString() ;  throw new NullPointerException(val);}
        return ( val ) ;
    }

    private String getValue( String key ) throws Exception {
        String value = "" ;

        try {
            value = String.valueOf( dataMap.get( key )) ;

            if ( value == null )
                throw new Exception( key + " : Key not found" ) ;
        } catch ( Exception e ) {
            throw new Exception( key + " : Key not found" ) ;
        }

        return value ;
    }

    protected void finalize() throws Throwable {
        if ( dataMap != null )
            dataMap = null ;
    }

    private void load() throws Exception {

            dataMap.put("DEFAULT_LIST_OPTION",                      "<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;</option>");
        /*Modes*/
            dataMap.put( "MODE_DELETE","0" ) ;
            dataMap.put( "MODE_INSERT","1" ) ;
            dataMap.put( "MODE_MODIFY","2" ) ;
        /*End of Modes*/

        /* Data Types definition */
            dataMap.put( "PK_INT",   "Integer" ) ;
            dataMap.put( "PK_LONG",  "Long"    ) ;
            dataMap.put( "PK_FLOAT", "Float"   ) ;
            dataMap.put( "PK_DOUBLE","Double"  ) ;
            dataMap.put( "PK_STRING","String"  ) ;
        /* End Of Data type definition */

        /* Module ID definitions */
            dataMap.put( "ID_AE","AE" ) ;
            dataMap.put( "ID_AM","AM" ) ;
            dataMap.put( "ID_BL","BL" ) ;
            dataMap.put( "ID_CA","CA" ) ;
            dataMap.put( "ID_DR","DR" ) ;
            dataMap.put( "ID_FM","FM" ) ;
            dataMap.put( "ID_HA","HA" ) ;
            dataMap.put( "ID_IP","IP" ) ;
            dataMap.put( "ID_MM","MM" ) ;
            dataMap.put( "ID_MP","MP" ) ;
            dataMap.put( "ID_OA","OA" ) ;
            dataMap.put( "ID_OP","OP" ) ;
            dataMap.put( "ID_OR","OR" ) ;
            dataMap.put( "ID_PH","PH" ) ;
            dataMap.put( "ID_PO","PO" ) ;
            dataMap.put( "ID_SM","SM" ) ;
            dataMap.put( "ID_SP","SP" ) ;
            dataMap.put( "ID_SS","SS" ) ;
            dataMap.put( "ID_ST","ST" ) ;
            dataMap.put( "ID_DS","DS" ) ; // AAKH-CRF-0065
			dataMap.put( "ID_RD","RD" ) ;
        /* End of Module ID definitions */

        /* QRY RESULT DISPLAY SIZE */
            dataMap.put( "QUERY_RESULT_SIZE", new Integer(14) ) ;
            dataMap.put( "MULTIPLE_INSERT_PAGE_SIZE",new Integer(10));
        /* QRY RESULT DISPLAY SIZE END */

        /* SQL statements start */
            dataMap.put( "SQL_SYS_DATE_TIME", "select to_char( sysdate, 'dd/mm/yyyy' ) sys_date, to_char( sysdate, 'HH24:MI' ) sys_time, to_char( sysdate, 'HH24:MI:SS' ) sys_time_sec, to_char( sysdate, 'dd/mm/yyyy HH24:MI' ) sys_date_time, to_char( sysdate, 'dd/mm/yyyy HH24:MI:SS' ) sys_date_time_sec, to_char( sysdate, 'MI:SS' ) min_sec from dual" ) ;
            dataMap.put( "SQL_GET_MESSAGE", "select message_id, message_text_sysdef from sm_message where message_ref = ? " ) ;
        /* SQL statements end */

        /* JNDI locations start */
            dataMap.put( "JNDI_JDBC", "java:comp/env/jdbc/OracleDS" ) ;
            dataMap.put( "JNDI_SINGLE_TABLE_HANDLER", "java:comp/env/SingleTableHandler" ) ;
        /* JNDI locations end */

    }
}
