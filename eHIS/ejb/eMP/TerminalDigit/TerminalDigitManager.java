/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP.TerminalDigit;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="TerminalDigit"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TerminalDigit"
*	local-jndi-name="TerminalDigit"
*	impl-class-name="eMP.TerminalDigit.TerminalDigitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMP.TerminalDigit.TerminalDigitLocal"
*	remote-class="eMP.TerminalDigit.TerminalDigitRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.TerminalDigit.TerminalDigitLocalHome"
*	remote-class="eMP.TerminalDigit.TerminalDigitHome"
*	generate= "local,remote"
*
*
*/

public class TerminalDigitManager implements SessionBean {
	Connection con ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}

	/**
		* @ejb.interface-method
		*	 view-type="both"
		*/
	public java.util.HashMap insertTerminalDigit(
							java.util.Properties p,							
							String addedAtWorkstation,
							String addedFacilityId,
							java.util.HashMap tabdata,
							java.util.HashMap tabdata1
						 ) {
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		String locale="";
		locale=p.getProperty("LOCALE");
		StringBuffer sb=new StringBuffer("") ;
		StringBuffer sql=new StringBuffer("");
		StringBuffer sql1=new StringBuffer("");

		sql.append("INSERT INTO MR_TERMINAL_DIGIT_HDR(TERM_DIGIT_LEVEL, FACILITY_ID, MR_SECTION_CODE, NO_OF_TERM_DIGIT, NO_OF_TERM_DIGIT_GROUP, TERM_DIGIT1_POSITION, TERM_DIGIT2_POSITION, TERM_DIGIT3_POSITION, TERM_DIGIT4_POSITION, TERM_DIGIT5_POSITION, TERM_DIGIT6_POSITION, TERM_DIGIT7_POSITION, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values ( ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? )");
		sql1.append("INSERT INTO MR_TERMINAL_DIGIT_DTL(TERM_DIGIT_LEVEL, FACILITY_ID, MR_SECTION_CODE,TERM_DIGIT_GRP1_ID, TERM_DIGIT_GRP1_POSITION1, TERM_DIGIT_GRP1_POSITION2, TERM_DIGIT_GRP1_POSITION3, TERM_DIGIT_GRP1_POSITION4, TERM_DIGIT_GRP1_POSITION5, TERM_DIGIT_GRP1_POSITION6, TERM_DIGIT_GRP1_POSITION7, TERM_DIGIT_GRP2_ID, TERM_DIGIT_GRP2_POSITION1, TERM_DIGIT_GRP2_POSITION2, TERM_DIGIT_GRP2_POSITION3, TERM_DIGIT_GRP2_POSITION4, TERM_DIGIT_GRP2_POSITION5, TERM_DIGIT_GRP2_POSITION6, TERM_DIGIT_GRP2_POSITION7, TERM_DIGIT_GRP3_ID, TERM_DIGIT_GRP3_POSITION1, TERM_DIGIT_GRP3_POSITION2, TERM_DIGIT_GRP3_POSITION3, TERM_DIGIT_GRP3_POSITION4, TERM_DIGIT_GRP3_POSITION5, TERM_DIGIT_GRP3_POSITION6, TERM_DIGIT_GRP3_POSITION7, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,? ,? ,? ,? ,?,? ,? ,? ,? ,?, ? ,? ,? ,? ,? )");
		String addedById = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;		
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		Date added_date = Date.valueOf( addedDate ) ;
		Date modified_date = Date.valueOf( modifiedDate ) ;
  	try {
      		con = ConnectionManager.getConnection(p);
			
			String duplicateSql = "";
			String level = (String)tabdata.get("term_digit_level");
			String facilityid = (String)tabdata.get("facility_id");
			String mr_section = (String)tabdata.get("mr_section_code");
			if(level.equals("E")) {
				duplicateSql = "select count(*) count from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"'";			
			}
			if(level.equals("F")) {
				duplicateSql = "select count(*) count from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"'";		
			}
			if(level.equals("S")) {
				duplicateSql = "select count(*) count from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"' and mr_section_code = '"+mr_section+"'";
			}
			int cnt= 0;
			pstmt = con.prepareStatement( duplicateSql ) ;			
			ResultSet rs = pstmt.executeQuery() ;

			if ( rs!=null) {
				while(rs.next()) {
					cnt = rs.getInt("count");
					
				}
			}
				if (cnt!=0) {				
				insertable = false ;
				
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS, "MP") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
				}	
			if( rs != null) rs.close();
		} catch ( Exception e ) {
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		}

		if ( insertable ) {
			try {			
				pstmt = con.prepareStatement( sql.toString() );
				pstmt.setString ( 1,  (String)tabdata.get("term_digit_level") );
				pstmt.setString	( 2,  (String)tabdata.get("facility_id") ) ;
				pstmt.setString	( 3,  (String)tabdata.get("mr_section_code") ) ;
				pstmt.setString	( 4,  (String)tabdata.get("no_of_term_digit") ) ;
				pstmt.setString ( 5,  (String)tabdata.get("no_of_term_digit_group") );
				pstmt.setString ( 6,  (String)tabdata.get("term_digit1_position") );
				pstmt.setString ( 7,  (String)tabdata.get("term_digit2_position") );
				pstmt.setString ( 8,  (String)tabdata.get("term_digit3_position") );
				pstmt.setString ( 9,  (String)tabdata.get("term_digit4_position") );
				pstmt.setString ( 10, (String)tabdata.get("term_digit5_position") );
				pstmt.setString	( 11, (String)tabdata.get("term_digit6_position") ) ;
				pstmt.setString	( 12, (String)tabdata.get("term_digit7_position") ) ;	
				pstmt.setString	( 13, addedById ) ;
				pstmt.setDate	( 14, added_date ) ;				
				pstmt.setString	( 15, addedAtWorkstation ) ;
				pstmt.setString	( 16, addedFacilityId ) ;
				pstmt.setString	( 17, modifiedById ) ;
				pstmt.setDate	( 18, modified_date ) ;
				pstmt.setString	( 19, modifiedAtWorkstation ) ;
				pstmt.setString	( 20, modifiedFacilityId ) ;

				int res1 = 0;
				int res = pstmt.executeUpdate() ;
				
				if (res!=0) {
				pstmt1 = con.prepareStatement( sql1.toString() );
				pstmt1.setString ( 1, (String)tabdata1.get("term_digit_level") );
				pstmt1.setString	( 2, (String)tabdata1.get("facility_id") ) ;
				pstmt1.setString	( 3, (String)tabdata1.get("mr_section_code") ) ;
				pstmt1.setString	( 4,  (String)tabdata1.get("term_digit_grp1_id") ) ;
				pstmt1.setString ( 5,  (String)tabdata1.get("term_digit_grp1_position1") );
				pstmt1.setString ( 6,  (String)tabdata1.get("term_digit_grp1_position2") );
				pstmt1.setString ( 7,  (String)tabdata1.get("term_digit_grp1_position3") );
				pstmt1.setString ( 8,  (String)tabdata1.get("term_digit_grp1_position4") );
				pstmt1.setString ( 9,  (String)tabdata1.get("term_digit_grp1_position5") );
				pstmt1.setString ( 10, (String)tabdata1.get("term_digit_grp1_position6") );
				pstmt1.setString	( 11, (String)tabdata1.get("term_digit_grp1_position7") ) ;
				pstmt1.setString	( 12, (String)tabdata1.get("term_digit_grp2_id") ) ;	
				pstmt1.setString ( 13,  (String)tabdata1.get("term_digit_grp2_position1") );
				pstmt1.setString ( 14,  (String)tabdata1.get("term_digit_grp2_position2") );
				pstmt1.setString ( 15,  (String)tabdata1.get("term_digit_grp2_position3") );
				pstmt1.setString ( 16,  (String)tabdata1.get("term_digit_grp2_position4") );
				pstmt1.setString ( 17,  (String)tabdata1.get("term_digit_grp2_position5") );
				pstmt1.setString ( 18, (String)tabdata1.get("term_digit_grp2_position6") );
				pstmt1.setString	( 19, (String)tabdata1.get("term_digit_grp2_position7") ) ;
				pstmt1.setString	( 20, (String)tabdata1.get("term_digit_grp3_id") ) ;	
				pstmt1.setString ( 21,  (String)tabdata1.get("term_digit_grp3_position1") );
				pstmt1.setString ( 22,  (String)tabdata1.get("term_digit_grp3_position2") );
				pstmt1.setString ( 23,  (String)tabdata1.get("term_digit_grp3_position3") );
				pstmt1.setString ( 24,  (String)tabdata1.get("term_digit_grp3_position4") );
				pstmt1.setString ( 25,  (String)tabdata1.get("term_digit_grp3_position5") );
				pstmt1.setString ( 26, (String)tabdata1.get("term_digit_grp3_position6") );
				pstmt1.setString	( 27, (String)tabdata1.get("term_digit_grp3_position7") ) ;
				pstmt1.setString	( 28, addedById ) ;
				pstmt1.setDate	( 29, added_date ) ;				
				pstmt1.setString	( 30, addedAtWorkstation ) ;
				pstmt1.setString	( 31, addedFacilityId ) ;
				pstmt1.setString	( 32, modifiedById ) ;
				pstmt1.setDate	( 33, modified_date ) ;
				pstmt1.setString	( 34, modifiedAtWorkstation ) ;
				pstmt1.setString	( 35, modifiedFacilityId ) ;
			
				res1 = pstmt1.executeUpdate() ;
			}
			if (( res != 0 )&&(res1 != 0)) {
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage(locale , RECORD_INSERTED,"SM");
			sb.append( (String) message.get("message"));
			message.clear();
			con.commit();
			}

			if(pstmt!=null)pstmt.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" );
				e.printStackTrace() ;
				try { con.rollback(); } catch (Exception ee) {}
			}
			finally { if(con!=null) ConnectionManager.returnConnection(con,p); }
		}
		tabdata.clear();
		tabdata1.clear();
		results.put( "status", new Boolean(result));
		results.put( "error", sb.toString());
		return results ;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap deleteTerminalDigit(	
		java.util.Properties p,			
		java.util.HashMap tabdata
	 ) {
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String locale="";
		locale=p.getProperty("LOCALE");
		try {
			con = ConnectionManager.getConnection(p);
			
			String duplicateSql = "", duplicateSql1 = "";
			String level =		(String)tabdata.get("term_digit_level");
			String facilityid = (String)tabdata.get("facility_id");
			String mr_section = (String)tabdata.get("mr_section_code");
			
			if(level.equals("E")) {
				duplicateSql = "delete from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"' and facility_id is null and mr_section_code is null ";
				duplicateSql1 = "delete from MR_TERMINAL_DIGIT_DTL where term_digit_level = '"+level+"' and facility_id is null and mr_section_code is null ";			
			}
			if(level.equals("F")) {
				duplicateSql = "delete from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"' and mr_section_code is null ";	
				duplicateSql1 = "delete from MR_TERMINAL_DIGIT_DTL where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"' and mr_section_code is null";
			}
			if(level.equals("S")) {
				duplicateSql = "delete from MR_TERMINAL_DIGIT_HDR where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"' and mr_section_code = '"+mr_section+"'";
				duplicateSql1 = "delete from MR_TERMINAL_DIGIT_DTL where term_digit_level = '"+level+"' and facility_id = '"+facilityid+"' and mr_section_code = '"+mr_section+"'";
			}
			
			pstmt = con.prepareStatement( duplicateSql);
			int res1 = 0;
			int res = pstmt.executeUpdate();
				if (res!=0) {
					pstmt1 = con.prepareStatement(duplicateSql1);
					res1 = pstmt1.executeUpdate();
				}
				else {
					try { con.rollback(); } catch (Exception ee) {}
				}
				if (( res != 0 )&&(res1 != 0)) {
					result = true ;
					
					java.util.Hashtable message = MessageManager.getMessage(locale , RECORD_DELETED,"SM");
					
					sb.append((String) message.get("message"));
					message.clear();
					con.commit();
				}
				if(pstmt!=null)pstmt.close();
				if(pstmt1!=null)pstmt1.close();
		}
		catch (Exception e) {
			sb.append( e.getMessage() + "<br>" );
			e.printStackTrace();
			try { con.rollback(); } catch (Exception ee) {}
		}
		finally { ConnectionManager.returnConnection(con,p); }
		tabdata.clear();
	results.put( "status", new Boolean(result));
	results.put( "error", sb.toString());
	return results;
	}
}
