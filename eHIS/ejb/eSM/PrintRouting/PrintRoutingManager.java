/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.PrintRouting ;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="PrintRouting"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PrintRouting"
*	local-jndi-name="PrintRouting"
*	impl-class-name="eSM.PrintRouting.PrintRoutingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.PrintRouting.PrintRoutingManagerLocal"
*	remote-class="eSM.PrintRouting.PrintRoutingManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.PrintRouting.PrintRoutingManagerLocalHome"
*	remote-class="eSM.PrintRouting.PrintRoutingManagerHome"
*	generate= "local,remote"
*
*
*/

public class PrintRoutingManager implements SessionBean {
	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt3;
    SessionContext ctx;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;
	public final String FCY_ID_NOT_BLANK = "FCY_ID_NOT_BLANK" ;
    String locale="";
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;}

	/**
	 *Method to insert PrintRouting
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertPrintRouting(HashMap argMap ) {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String moduleId=(String)argMap.get("moduleId");
		String reportId=(String)argMap.get("reportId");
		String facilityId=(String)argMap.get("facilityid");
		String destLocnType=(String)argMap.get("destLocnType");
		String destLocnCode=(String)argMap.get("destLocnCode");
		String wsNo=(String)argMap.get("wsNo");
		String dfltReportMode=(String)argMap.get("dfltReportMode");
		Integer noOfCopiesInt=(Integer)argMap.get("noOfCopies");
		int noOfCopies=	noOfCopiesInt.intValue();				
		String printer_id1=(String)argMap.get("printer_id1");
		String from_time1=(String)argMap.get("from_time1");
		String printer_id2=(String)argMap.get("printer_id2");
		String from_time2=(String)argMap.get("from_time2");
		String printer_id3=(String)argMap.get("printer_id3");
		String from_time3=(String)argMap.get("from_time3");
		String addedFacilityId=(String)argMap.get("facilityId");
		String addedAtWorkstation=(String)argMap.get("client_ip_address");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		boolean facilityBasedAndFacilityExists = true;
		StringBuffer sb = new StringBuffer( "" ) ;
		try{ String sql = "insert into sm_print_routing (module_id,report_id,srl_no,facility_id,dest_locn_type,	dest_locn_code, ws_no,dflt_report_mode,no_of_copies,printer_id1,from_time1,printer_id2,from_time2,printer_id3,from_time3,added_by_id,added_date, added_facility_id,added_at_ws_no,modified_by_id,modified_date, modified_facility_id,modified_at_ws_no ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date('"+from_time1+"','dd/mm/yyyy hh24:mi'), ?, to_date('"+from_time2+"','dd/mm/yyyy hh24:mi'), ?, to_date('"+from_time3+"','dd/mm/yyyy hh24:mi'), ?, sysdate, ?,?,?,sysdate,?,? )" ;
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		try { con = ConnectionManager.getConnection(p);
			String D_facility_value=" is null ";
			if 	(facilityId == null || facilityId.equals("null") || facilityId.trim().equals("") )
			D_facility_value = " is null ";
			else
			D_facility_value = "='"+facilityId+"' ";
			String D_Loc_code=" is null ";
			if 	(destLocnCode == null || destLocnCode.equals("null") || destLocnCode.trim().equals("") )
			D_Loc_code = " is null ";
			else
			D_Loc_code = "='"+destLocnCode+"' ";
			String D_ws_no=" is null ";
			if 	(wsNo == null || wsNo.equals("null") || wsNo.trim().equals("") )
			D_ws_no = " is null ";
			else
			D_ws_no = "='"+wsNo+"' ";
			if(destLocnType.equals("L")){
				
			final String duplicateSql = "select count(*) from sm_print_routing where module_id = ?  and report_id = ? and facility_id " + D_facility_value + " and dest_locn_type=? and dest_locn_code "+ D_Loc_code+ " and ws_no "+D_ws_no;
			pstmt = con.prepareStatement( duplicateSql ) ;
    		pstmt.setString( 1, moduleId ) ;
			pstmt.setString( 2, reportId ) ;
			pstmt.setString( 3, destLocnType ) ;
			}else{
				final String duplicateSql = "select count(*) from sm_print_routing where module_id = ?  and report_id= ? and facility_id " + D_facility_value + " and dest_locn_type=? and dest_locn_code "+ D_Loc_code+ " and  ws_no "+D_ws_no;
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, moduleId ) ;
				pstmt.setString( 2, reportId ) ;
				pstmt.setString( 3, destLocnType ) ;
			}
			ResultSet rs = pstmt.executeQuery() ;
			int no_count=0;
			if(rs!=null){
			if(rs.next()){
			no_count=rs.getInt(1);
			rs.close();	}
			}
			if(no_count>0){
			insertable = false ;
			java.util.Hashtable message = MessageManager.getMessage( locale, "CODE_ALREADY_EXISTS","Common" ) ;
			sb.append( (String) message.get("message") ) ;message.clear();
			}
			final String facilityBsd = "Select module_id,report_id from sm_report where module_id = ? and report_id= ? and facility_based_yn='Y'";
			PreparedStatement pStmtFacility = con.prepareStatement(facilityBsd);
			pStmtFacility.setString( 1, moduleId ) ;
			pStmtFacility.setString( 2, reportId ) ;
			ResultSet rsFac = pStmtFacility.executeQuery();
			if (rsFac != null){
			if(rsFac.next()){
			if ((facilityId == null)||(facilityId.equals(""))){
			facilityBasedAndFacilityExists = false;
			 java.util.Hashtable message = MessageManager.getMessage(locale,"FCY_ID_NOT_BLANK", "SM");
			sb.append( (String) message.get("message") ) ;
			message.clear();rsFac.close();
			}}}
			pStmtFacility.close();
		} catch ( Exception e ) {
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		}	
		if ( facilityBasedAndFacilityExists && insertable ) {
			try {//Getting  the maximum value for the column srl_no
				int maxRecord=0;
				String str="select nvl(max(srl_no),0) as total from sm_print_routing where  module_id= ? and report_id= ?";
				pstmt3 = con.prepareStatement(str ) ;
				pstmt3.setString( 1, moduleId ) ;
			    pstmt3.setString( 2, reportId ) ;
				ResultSet rs1 = pstmt3.executeQuery() ;
				rs1.next();
				maxRecord = rs1.getInt("total");
				rs1.close();
				maxRecord=maxRecord+1;
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1,  moduleId ) ;
				pstmt.setString	( 2,  reportId  ) ;
				pstmt.setInt	( 3,  maxRecord ) ;
				pstmt.setString	( 4,  facilityId ) ;
				pstmt.setString	( 5,  destLocnType ) ;
				pstmt.setString	( 6,  destLocnCode ) ;
				pstmt.setString	( 7,  wsNo ) ;
				pstmt.setString	( 8,  dfltReportMode ) ;
				pstmt.setInt	( 9,  noOfCopies ) ;
				pstmt.setString	( 10, printer_id1 ) ;
				pstmt.setString	( 11, printer_id2 ) ;
				pstmt.setString	( 12, printer_id3 ) ;
				pstmt.setString	( 13, addedById ) ;
				pstmt.setString	( 14, addedFacilityId ) ;
				pstmt.setString	( 15, addedAtWorkstation ) ;
				pstmt.setString	( 16, modifiedById ) ;
				pstmt.setString	( 17, modifiedFacilityId ) ;
				pstmt.setString	( 18, modifiedAtWorkstation ) ;
				int res = pstmt.executeUpdate() ;
				if ( res != 0 ) {
					result = true ;
	    			 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();message.clear();
				}	pstmt.close() ;
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
					try{
						con.rollback();
					}catch (Exception ce){}
			}
		}
		}
finally
		{  if (con != null)
		  {   try
			   {  if(pstmt3 != null) pstmt3.close();
				  ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		      }}results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		argMap.clear();
		return results ;
 }

	/**
	 *Method to update PrintRouting
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


				
public java.util.HashMap updatePrintRouting(
							
							HashMap argMap
						 )   {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String moduleId=(String)argMap.get("moduleId");
		String reportId=(String)argMap.get("reportId");
		String facilityId=(String)argMap.get("facilityid");
		String destLocnType=(String)argMap.get("destLocnType");
		String destLocnCode=(String)argMap.get("destLocnCode");
		String wsNo=(String)argMap.get("wsNo");
		Integer noOfCopiesInt=(Integer)argMap.get("noOfCopies");
		int noOfCopies=	noOfCopiesInt.intValue();				
		String printer_id1=(String)argMap.get("printer_id1");
		String from_time1=(String)argMap.get("from_time1");
		String printer_id2=(String)argMap.get("printer_id2");
		String from_time2=(String)argMap.get("from_time2");
		String printer_id3=(String)argMap.get("printer_id3");
		String from_time3=(String)argMap.get("from_time3");
		String modifiedFacilityId=(String)argMap.get("facilityId");
		String modifiedAtWorkstation=(String)argMap.get("client_ip_address");


		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true;
		
		String P_facility_value=" is null ";

		if 	(facilityId == null || facilityId.equals("null") || facilityId.trim().equals("") )
			P_facility_value = " is null ";
		else
			P_facility_value = "='"+facilityId+"' ";

		String P_Loc_code=" is null ";

		if 	(destLocnCode == null || destLocnCode.equals("null") || destLocnCode.trim().equals("") )
			P_Loc_code = " is null ";
		else
			P_Loc_code = "='"+destLocnCode+"' ";

		String P_ws_no=" is null ";
		if 	(wsNo == null || wsNo.equals("null") || wsNo.trim().equals("") )
			P_ws_no = " is null ";
		else
			P_ws_no = "='"+wsNo+"' ";
			
			

			String modifiedById = p.getProperty( "login_user" ) ;

		String sql ="update sm_print_routing set no_of_copies= "+noOfCopies+" ,  " +
							"  printer_id1     ='"+printer_id1+"'  ,"	+
							"  from_time1  =to_date('"+from_time1+"','dd/mm/yyyy hh24:mi') ,	"+
							"  printer_id2    ='"+printer_id2+"' , "	+
							"  from_time2   =to_date('"+from_time2+"','dd/mm/yyyy hh24:mi') , "+
							"  printer_id3  ='"+printer_id3+"' ,"+
							"  from_time3 =to_date('"+from_time3+"','dd/mm/yyyy hh24:mi')," +
							"  modified_by_id	= '"+modifiedById+"' , " +
							"  modified_date		= sysdate, " +
							"  modified_facility_id	= '"+modifiedFacilityId+"', " +
							"  modified_at_ws_no 	= '"+modifiedAtWorkstation+"'   "  +
						    "  where	module_id 	='"+moduleId+"' and  report_id= '"+reportId+"' "+
							"  and   facility_id "+P_facility_value+" " +
							"  and   dest_locn_code "+P_Loc_code+"  " +
							"  and  ws_no "+P_ws_no+"  " +
							"  and    dest_locn_type= '"+destLocnType+"'  " ;

			try {
	
				con = ConnectionManager.getConnection(p);
				if ( updatable ) {
					pstmt = con.prepareStatement( sql );

					int res = pstmt.executeUpdate() ;

					if ( res != 0 ) {

						result = true ;
						 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
						sb.append( (String) message.get("message") ) ;
						con.commit();message.clear();
					}
					pstmt.close() ;
				}
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
					try{
						con.rollback();
					}catch (Exception ce){}
					}
finally
			{
			  if (con != null)
			  {
			   try
			   {
				      ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		      }

		   }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		argMap.clear();
		return results ;
	}

	/**
	 *Method to delete PrintRouting
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


public java.util.HashMap deletePrintRouting(
							
							HashMap argMap
						 )   {

		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String moduleId=(String)argMap.get("moduleId");
		String reportId=(String)argMap.get("reportId");
		Integer srlNoInt=(Integer)argMap.get("srlNo");
		int srlNo=srlNoInt.intValue();

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
			try {


				String sql ="delete from sm_print_routing where module_id=? and report_id = ? and srl_no= ?";
				con = ConnectionManager.getConnection(p);

				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, moduleId ) ;
				pstmt.setString	( 2, reportId ) ;
				pstmt.setInt	( 3, srlNo    ) ;

				int res = pstmt.executeUpdate() ;


				if ( res != 0 ) {

					result = true ;
                   java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_DELETED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();message.clear();
				}

				pstmt.close() ;
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
					try{
								con.rollback();
			}catch (Exception ce){}
				
			}

		finally{
				if ( con != null ) {
								try {
					ConnectionManager.returnConnection(con,p);
								} catch( Exception ce ) {}
					}

				}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		argMap.clear();
		return results ;
	}



}

