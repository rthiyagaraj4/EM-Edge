/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.ScheduleFreq;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.transaction.* ;
import java.text.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="ScheduleFreq"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ScheduleFreq"
*	local-jndi-name="ScheduleFreq"
*	impl-class-name="eAM.ScheduleFreq.ScheduleFreqManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.ScheduleFreq.ScheduleFreqLocal"
*	remote-class="eAM.ScheduleFreq.ScheduleFreqRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.ScheduleFreq.ScheduleFreqLocalHome"
*	remote-class="eAM.ScheduleFreq.ScheduleFreqHome"
*	generate= "local,remote"
*
*
*/




public class ScheduleFreqManager implements SessionBean{
	Connection con ;
	PreparedStatement pstmt ;

	Properties	p ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED		= "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED		= "RECORD_MODIFIED" ;

	String  freq_code			="";
	String  admin_facility_id	="";
	String  admin_day_or_time	="";
	//String  admin_day			="";
	String	admin_time			="";

	int dayCount				=0;
	int timeCount				=0;

	String	  mode				= "";

	String modified_by_id			="";
	String modified_facility_id		="";
	String modified_at_ws_no		="";
	java.sql.Timestamp modified_date=null;

    String added_by_id				="";
	String added_facility_id		="";
	String added_at_ws_no			="";
	java.sql.Timestamp added_date	=null;

	StringBuffer sb					=null;
	java.util.HashMap results	    =null;
	java.util.HashMap hashtable	=null;

	boolean result					= false ;
	String max_no_of_cycle			= "";
	//boolean insertable				= true ;

/****************************** CALL BACK Functions  ********************/
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context )
	{
		context=context;//for avoiding PMD violation
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/


public java.util.HashMap insert(HashMap hmParams) {
		 p =(Properties) hmParams.get("p");
		 hashtable = (HashMap)hmParams.get("tabdata");
		modified_by_id			    =(String)hashtable.get("modified_by_id");
	modified_facility_id		=(String)hashtable.get("modified_facility_id");
    modified_at_ws_no		    =(String)hashtable.get("modified_at_ws_no");
	modified_date				=(java.sql.Timestamp)hashtable.get("modified_date");
	added_by_id				    = (String)hashtable.get("added_by_id");
	added_facility_id		    = (String)hashtable.get("added_facility_id");
    added_at_ws_no			    = (String)hashtable.get("added_at_ws_no");
	added_date					= (java.sql.Timestamp)hashtable.get("added_date");
	mode						=((String)hashtable.get("mode")==null)?"":(String)hashtable.get("mode");
	freq_code					=((String)hashtable.get("freq_code")==null)?"":(String)hashtable.get("freq_code");
	admin_facility_id			=((String)hashtable.get("admin_facility_id")==null)?"":(String)hashtable.get("admin_facility_id");
	admin_day_or_time			=((String)hashtable.get("admin_day_or_time")==null)?"":(String)hashtable.get("admin_day_or_time");
//	dayCount					=((Integer)hashtable.get("dayCount")).intValue() ;
	timeCount					=((Integer)hashtable.get("timeCount")).intValue() ;
	String locale="";
			locale= p.getProperty("LOCALE");
		results			= new java.util.HashMap() ;
		sb					= new StringBuffer();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date today = new java.util.Date();
		String dateString = dt.format(today);
		extractValues();//get all the values from the hashTable
		hmParams.clear();
		try {
			con					= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			if(mode.trim().equals("1")){//for insert
				if(checkDuplicate()==false) //chk duplicate
				return results;
			}else if(mode.trim().equals("2")){//for Update
				String delSql = "Delete from AM_FREQUENCY_ADMIN_DAY_TIME where 	FREQ_CODE='" +  freq_code.trim() + "' and ADMIN_FACILITY_ID='" +admin_facility_id.trim() +"'";
				Statement stmt = con.createStatement();
				int i = stmt.executeUpdate(delSql);
                if(stmt!=null)stmt.close();
				if(i <= 0){
					con.rollback();
					results.put( "status", new Boolean(false) ) ;
					results.put( "error", "Err in Delete:rec cannot be deleted for Update for req : FREQ_CODE= "+  freq_code.trim() +"ADMIN_FACILITY_ID"  +  admin_facility_id.trim() ) ;
				return results ;
				}
			}
			String sql	= "INSERT INTO AM_FREQUENCY_ADMIN_DAY_TIME(FREQ_CODE,"+
					"ADMIN_FACILITY_ID, " +
					"ADMIN_DAY_OR_TIME, " +
					"ADMIN_DAY, " +
					"ADMIN_TIME, " +
					"ADDED_BY_ID, " +
					"ADDED_DATE, " +
					"ADDED_AT_WS_NO, " +
					"ADDED_FACILITY_ID, " +
					"MODIFIED_BY_ID, " +
					"MODIFIED_DATE, " +
					"MODIFIED_AT_WS_NO, " +
					"MODIFIED_FACILITY_ID, " +
					"ADMIN_WEEK, " +
					"ADMIN_MONTH" +
					") values (?,?,?,?,to_date(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?)" ;  //Modified by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
					pstmt = con.prepareStatement(sql);
					while(timeCount > 0){
					pstmt.setString(1 ,freq_code);
					pstmt.setString(2 ,admin_facility_id);
					pstmt.setString(3 ,admin_day_or_time);
					pstmt.setString(4 , (String)hashtable.get("admin_day"+timeCount));
					 admin_time = dateString + " " + (String)hashtable.get("admin_time"+timeCount);
					sb.append("admin_time"+admin_time);
					pstmt.setString(5 ,admin_time);
					pstmt.setString(6,added_by_id);
					pstmt.setTimestamp(7,added_date);
					pstmt.setString(8,added_at_ws_no);
					pstmt.setString(9,added_facility_id);
					pstmt.setString(10,modified_by_id);
					pstmt.setTimestamp(11,modified_date);
					pstmt.setString(12,modified_at_ws_no);
					pstmt.setString(13,modified_facility_id);
					pstmt.setString(14, (String)hashtable.get("admin_week"+timeCount)); 
					pstmt.setString(15, (String)hashtable.get("admin_month"+timeCount));
					pstmt.addBatch();
					--timeCount ;
				}
			/*		while(dayCount > 0){
					pstmt.setString(1 ,freq_code);
					pstmt.setString(2 ,admin_facility_id);
					pstmt.setString(3 ,admin_day_or_time);
					sb.append("admin_day"+(String)hashtable.get("admin_day"+dayCount));
					pstmt.setString(4 ,(String)hashtable.get("admin_day"+dayCount));
					pstmt.setString(5 , null);
					pstmt.setString(6,added_by_id);
					pstmt.setTimestamp(7,added_date);
					pstmt.setString(8,added_at_ws_no);
					pstmt.setString(9,added_facility_id);
					pstmt.setString(10,modified_by_id);
					pstmt.setTimestamp(11,modified_date);
					pstmt.setString(12,modified_at_ws_no);
					pstmt.setString(13,modified_facility_id);
					pstmt.addBatch();
					--dayCount ; 
				}*/
			int [] updatedCounts = pstmt.executeBatch();
			if ( updatedCounts.length == -3 )
				result = false;
			else
				result = true ;
			String msg = "";
			if(result)
				{
				if(mode.trim().equals("1"))
					{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED ,"SM") ;
					results.put( "status", new Boolean(result) ) ;
					msg = (String) message.get("message")  ;
					results.put( "error", msg ) ;
					message.clear();
					return results;
					}
					else if(mode.trim().equals("2"))
					{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM") ;
					results.put( "status", new Boolean(result) ) ;
					msg = (String) message.get("message")  ;
					results.put( "error", msg ) ;
					message.clear();
					return results;
					}
				}
				else
					con.rollback();
				results.put( "status", new Boolean(result) ) ;
				results.put( "error", sb.toString() ) ;
				return results ;
		}catch(Exception fe){
				sb.append(fe.toString());
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				fe.printStackTrace();
				return results ;
		}finally
		 {
			try {
						if (con != null) ConnectionManager.returnConnection(con,p);
						if(pstmt!=null) pstmt.close();
				 }
				 catch(BatchUpdateException ee)
				 {
						sb.append(ee.toString());
						sb.append(ee.getUpdateCounts());
						results.put( "status", new Boolean(false) ) ;
						results.put( "error", sb.toString() ) ;
						ee.printStackTrace();
						return results ;
				 }
				 catch(Exception ee)
				 {
						sb.append(ee.toString());
						results.put( "status", new Boolean(false) ) ;
						results.put( "error", sb.toString() ) ;
						ee.printStackTrace();
						return results ;
				 }
		}



}//End if insert function


/******************** Function to Extract Value  FROM THE HASHTABLE*************************/
private void extractValues() {// to extract values from the has table
try{
	//java.util.Properties p =(Properties) hmParams.get("p");
		// hashtable = (HashMap)hmParams.get("tabdata");

	modified_by_id			    =(String)hashtable.get("modified_by_id");
	modified_facility_id		=(String)hashtable.get("modified_facility_id");
    modified_at_ws_no		    =(String)hashtable.get("modified_at_ws_no");
	modified_date				=(java.sql.Timestamp)hashtable.get("modified_date");
	added_by_id				    = (String)hashtable.get("added_by_id");
	added_facility_id		    = (String)hashtable.get("added_facility_id");
    added_at_ws_no			    = (String)hashtable.get("added_at_ws_no");
	added_date					= (java.sql.Timestamp)hashtable.get("added_date");
	mode						=((String)hashtable.get("mode")==null)?"":(String)hashtable.get("mode");
	freq_code					=((String)hashtable.get("freq_code")==null)?"":(String)hashtable.get("freq_code");
	admin_facility_id			=((String)hashtable.get("admin_facility_id")==null)?"":(String)hashtable.get("admin_facility_id");
	admin_day_or_time			=((String)hashtable.get("admin_day_or_time")==null)?"":(String)hashtable.get("admin_day_or_time");

//	dayCount					=((Integer)hashtable.get("dayCount")).intValue() ;
	timeCount					=((Integer)hashtable.get("timeCount")).intValue() ;


	
}catch(Exception e){
	  sb.append(e.toString());
	  e.printStackTrace();
	}
}	 //End of exctract method


/****************************** Function to Check  Duplicate  ****************************************/


public boolean checkDuplicate() //checks for the duplicates in the table
{

		ResultSet rs = null;
String locale="";
			locale= p.getProperty("LOCALE");
		try
		{

			final String duplicateSql = "SELECT COUNT(*) FROM AM_FREQUENCY_ADMIN_DAY_TIME WHERE FREQ_CODE =? AND ADMIN_FACILITY_ID=?" ;
			pstmt = con.prepareStatement(duplicateSql) ;
			pstmt.setString(1,freq_code ) ;
			pstmt.setString(2,admin_facility_id ) ;
			rs = pstmt.executeQuery() ;

			int count  = 0;
			if(rs.next())
			count = rs.getInt(1) ;

			if (count > 0)
			{
				//insertable = false ;
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common") ;
				sb.append( (String) message.get("message") ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;

				message.clear();
				return false ;
			}else{
				return true ;
			}

		} catch ( Exception e ) {
				//insertable = false ;
				sb.append( e.toString() + "<br>" ) ;
				results.put( "status", new Boolean(false) ) ;
				results.put( "error", sb.toString() ) ;
				e.printStackTrace() ;
				return false ;
			}
		finally
		{
			try
			{
				if(pstmt!=null )pstmt.close();
				if(rs!=null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	} // end  of the method

}//End of Class
