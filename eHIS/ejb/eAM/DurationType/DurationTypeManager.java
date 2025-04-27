/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.DurationType ;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;

import javax.ejb.* ;
import javax.transaction.* ;

import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="DurationType"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DurationType"
*	local-jndi-name="DurationType"
*	impl-class-name="eAM.DurationType.DurationTypeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.DurationType.DurationTypeLocal"
*	remote-class="eAM.DurationType.DurationTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.DurationType.DurationTypeLocalHome"
*	remote-class="eAM.DurationType.DurationTypeHome"
*	generate= "local,remote"
*
*
*/



public class DurationTypeManager implements SessionBean {
  	public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) 
	{
		context=context;//for avoiding PMD violation
	}

    public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;




/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap modify(HashMap tabData) {	
		Connection con = null ;
		PreparedStatement pstmt_update_duration = null ;
		StringBuffer sb = new StringBuffer( "" ) ;
		boolean resultVal = false ;
		java.util.HashMap results = new java.util.HashMap() ;
		Properties p = (Properties) tabData.get("p");
		HashMap tabdata =(HashMap) tabData.get("tabdata");
		String locale="";
		locale= p.getProperty("LOCALE");
		try {
			con = ConnectionManager.getConnection(p);
			String SQL_OR_DURATION_TYPE_UPDATE = "UPDATE am_duration_type SET durn_desc_loc_lang=?, for_text_loc_lang=?, modified_by_id =?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=? WHERE durn_type=?";

			int result=0;
			pstmt_update_duration		= con.prepareStatement( SQL_OR_DURATION_TYPE_UPDATE ) ;

			
			String descLocLang = (String) tabdata.get("durn_desc_loc_lang" );
			
			String forText = (String) tabdata.get("for_text" ) ;
			String durnType = (String) tabdata.get("durn_type" ) ;
			pstmt_update_duration.setString( 3, (String) tabdata.get("modified_by_id" ) ) ;
			pstmt_update_duration.setString( 4, (String) tabdata.get("modified_at_ws_no" ) ) ;
			pstmt_update_duration.setString( 5, (String) tabdata.get("modified_facility_id" ) ) ;
			StringTokenizer stDescLocLang = new StringTokenizer(descLocLang,"~");
			StringTokenizer stForText = new StringTokenizer(forText,"~");
			StringTokenizer stDurnType = new StringTokenizer(durnType,"~");
			String descLocLangValue = "";
			String forTextValue = "";
			String durnTypeValue = "";

			while(stDurnType.hasMoreTokens()){
				descLocLangValue = stDescLocLang.nextToken();
				if(descLocLangValue.equals(" ") || descLocLangValue == " " ){
					descLocLangValue = null;
				}
				pstmt_update_duration.setString( 1, (String) descLocLangValue ) ;

				forTextValue = stForText.nextToken();
				if(forTextValue.equals(" ") || forTextValue == " "){
					forTextValue = null;
				}
				pstmt_update_duration.setString( 2, (String) forTextValue ) ;

				durnTypeValue = stDurnType.nextToken();
				if(durnTypeValue.equals(" ") || durnTypeValue ==" "){
					durnTypeValue = null;
				}
				pstmt_update_duration.setString(6, (String) durnTypeValue ) ;
				result = pstmt_update_duration.executeUpdate() ;
			}
			if ( result != 0 ) {
				resultVal = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
			}
			if(pstmt_update_duration != null) pstmt_update_duration.close() ;
		}
		catch( Exception e )
			{
			
			try { con.rollback(); }
			catch (Exception ee) {}
			
			e.printStackTrace() ;
		} 
		finally {
			if (con != null)
				ConnectionManager.returnConnection(con,p);
		}

		results.put( "status", new Boolean(resultVal) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
