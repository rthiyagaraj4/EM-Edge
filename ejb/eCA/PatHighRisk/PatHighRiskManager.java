/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.PatHighRisk;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="PatHighRiskManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatHighRiskManager"
*	local-jndi-name="PatHighRiskManager"
*	impl-class-name="eCA.PatHighRisk.PatHighRiskManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.PatHighRisk.PatHighRiskManagerLocal"
*	remote-class="eCA.PatHighRisk.PatHighRiskManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.PatHighRisk.PatHighRiskManagerLocalHome"
*	remote-class="eCA.PatHighRisk.PatHighRiskManagerHome"
*	generate= "local,remote"
*
*
*/

public class PatHighRiskManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-mm-dd" ) ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {//this.ctx=context;
	context=context;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertPatHighRisk
	(
							java.util.Properties p,
							String	  patientid,
							String	  highriskcode,
							String	  onsetdate ,
							String	  remarks,
							String	  practid,
							String	  facilityid ,
							String	  locncode,
							String	  locntype ,
							String	  temp_encounterid ,
							String	  addedAtWorkstation,
							String	  addedFacilityId,
							String	  locale,
							String    date_type
						 ) 
		{
	
		long encounterid=Long.parseLong(temp_encounterid);
		
		java.util.HashMap results = new java.util.HashMap() ;
		
		int srlno = 0;

		boolean result			= false ;
		boolean insertable		= true ;

		StringBuffer sb = new StringBuffer( "" ) ;
		
		String addedById				= p.getProperty( "login_user" ) ;
//		String addedDate				= dateFormat.format( new java.util.Date() ) ;
		String modifiedById				= addedById ;
		String modifiedFacilityId		= addedFacilityId ;
		String remark					= remarks;
		String modifiedAtWorkstation	= addedAtWorkstation ;

//        java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;

		ResultSet rset = null,rs = null;
		
		int rs1		=	0;

		try
		{
			con=ConnectionManager.getConnection(p);

			try
			{
				String duplicateSql = "select count(*) as total from pr_high_risk_condition where high_risk_code = ? and patient_id = ? " ;

				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, highriskcode ) ;
				pstmt.setString( 2, patientid ) ;

				rs = pstmt.executeQuery() ;
				
				if(rs.next())
					rs1=rs.getInt("total");

				if(rs1 >=1)
				{
					if (pstmt!=null) pstmt.close();

					String duplicatesql2 = " select '1' from pr_high_risk_condition where high_risk_code = ? and patient_id = ?  and close_date is null " ;

					pstmt = con.prepareStatement( duplicatesql2 ) ;
					
					pstmt.setString( 1, highriskcode ) ;
					pstmt.setString( 2, patientid ) ;
					
					rset = pstmt.executeQuery() ;

					if ( rset.next())
					{
						insertable = false ;
						final java.util.Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
						sb.append( (String) message.get("message") ) ;
						message.clear();
						con.commit();
					}
				}
				
				if(rs!=null) rs.close();
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}
			catch ( Exception e )
			{
				insertable = false ;
				sb.append( e+ "<br>" ) ;
				e.printStackTrace() ;

				try 
				{ 
					con.rollback(); 
				} 
				catch (Exception ee) 
				{
					ee.printStackTrace();
				}
		    }
			
			if (insertable) 
			{
				try
				{
					String Sql = "select nvl(max(srl_no),0)+1 num from pr_high_risk_condition where patient_id = ? and high_risk_code = ?" ;
		
							pstmt = con.prepareStatement( Sql ) ;
							
							pstmt.setString( 1, patientid) ;
							pstmt.setString( 2, highriskcode) ;
							rs = pstmt.executeQuery() ;
							
							rs.next();
							srlno = rs.getInt("num");

							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							
				}
				catch(Exception e)
				{
					insertable = false ;
					sb.append( e + "<br>" ) ;
					e.printStackTrace() ;
				}
		}	
		if ( insertable )
		{
			try
			{
				StringBuffer sql =new StringBuffer();
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" insert into 	pr_high_risk_condition(	" );	
				sql.append(" PATIENT_ID,		HIGH_RISK_CODE,");
				sql.append(" SRL_NO, ONSET_DATE, remarks,"); 	
				sql.append("ONSET_PRACTITIONER_ID, ONSET_FACILITY_ID, " );
				sql.append("ONSET_LOCN_CODE, ONSET_LOCN_TYPE, " );
				sql.append("ONSET_ENCOUNTER_ID, ONSET_RECORDED_DATE, ONSET_DATE_TYPE, " ); 
				sql.append(" added_by_id,		added_date, " );
				sql.append(" added_facility_id, added_at_ws_no, " );
				sql.append(" modified_by_id,	 modified_date, ");
				sql.append(" modified_facility_id,	modified_at_ws_no ");
				sql.append(" ) values ( ?, ?, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?,sysdate,?,?,sysdate,? ,?, ?, sysdate, ?, ? )" );

				pstmt = con.prepareStatement( sql.toString());
				pstmt.setString	( 1, patientid ) ;
				pstmt.setString	( 2, highriskcode) ;
				pstmt.setInt	( 3, srlno  ) ;
				pstmt.setString	( 4, onsetdate ) ;
				pstmt.setString (5, remark);
				pstmt.setString	( 6, practid ) ;
				pstmt.setString	( 7, facilityid ) ;
				pstmt.setString	( 8, locncode ) ;
				pstmt.setString	( 9, locntype ) ;
				pstmt.setLong( 10, encounterid ) ;
				pstmt.setString( 11, date_type ) ;
				pstmt.setString   (12,addedById);
				pstmt.setString	( 13, addedFacilityId ) ;
				pstmt.setString	( 14, addedAtWorkstation ) ;
				pstmt.setString	( 15, modifiedById ) ;
				pstmt.setString	( 16, modifiedFacilityId ) ;
				pstmt.setString	( 17, modifiedAtWorkstation ) ;
				int res = pstmt.executeUpdate() ;

				if ( res >= 0 )
				{
					result = true ;

					final java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");

					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}

				if(pstmt!=null) pstmt.close();
			}
			catch ( Exception e ) 
			{
				sb.append( "Insert"+e.getMessage() + srlno+"<br> " ) ;
				e.printStackTrace() ;
				try 
				{ con.rollback(); 
				} 
				catch (Exception ee) 
				{
					ee.printStackTrace();
				}
			}

		}//end insertable
	}
	catch(Exception e){}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,p);
	}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updatePatHighRisk(
									java.util.Properties p,
									String    patientid,
									String	  highriskcode,
									String    closedate ,
									String	  remarks,
									String	  practid,
									String	  facilityid ,
									String	  locncode,
									String	  locntype ,
									String	  temp_encounterid ,
									String	  addedAtWorkstation,
									String	  addedFacilityId,
									String	  locale,
									String srlno
									) // additional parameter srlno added for IN037071
	{
		long encounterid=Long.parseLong(temp_encounterid);
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String srl_no = srlno; //IN037071
		int serialNo = 0; //IN037071
		serialNo = Integer.parseInt(srl_no); //IN037071
		String modifiedById = p.getProperty( "login_user" ) ;
		//String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		//java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		//
		String remark=remarks;
		String close_date="";

		if(!closedate.equals("") )
			close_date = closedate;

		if ( updatable ) {
		try{
			con=ConnectionManager.getConnection(p);
		try 
		{
				
						StringBuffer sql =new StringBuffer();
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" update pr_high_risk_condition set ");
						sql.append(" remarks=?, ");
						if (!closedate.equals("") )
						{
							sql.append(" close_date = to_date(?,'dd/mm/yyyy'), close_practitioner_id = ?, " );
							sql.append(" close_facility_id = ?, close_locn_code = ?, ");
							sql.append(" close_locn_type = ?, close_encounter_id = ?," );
							sql.append(" close_recorded_date = sysdate, " );
						}
						sql.append(" modified_by_id	= ?,  " );
						sql.append(" modified_date		= sysdate,  " );
						sql.append(" modified_facility_id	= ?, " );
						sql.append(" modified_at_ws_no = ? " );
						sql.append(" where	patient_id=? and high_risk_code	= ? and srl_no = ? and close_date is null "); // additional and condition srl_no have been added for IN037071
                
				pstmt = con.prepareStatement( sql.toString());
				int i =1;
				pstmt.setString(i++,remark);
				if (!closedate.equals("") )
				{
				
					pstmt.setString ( i++, close_date) ;
					pstmt.setString ( i++, practid) ;
					pstmt.setString ( i++, facilityid) ;
					pstmt.setString ( i++, locncode) ;
					pstmt.setString ( i++, locntype) ;
					pstmt.setLong   ( i++, encounterid) ;
				}
//				
				pstmt.setString	( i++, modifiedById ) ;
          //      pstmt.setDate   ( i++, modified_date) ;
				pstmt.setString	( i++, modifiedFacilityId ) ;
				pstmt.setString	( i++, modifiedAtWorkstation ) ;
				pstmt.setString ( i++, patientid  );
				pstmt.setString ( i++, highriskcode );
				pstmt.setInt ( i++, serialNo );

				int res = pstmt.executeUpdate() ;

				if ( res >= 0 ) {
					result = true ;



					final java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");

					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}

				if(pstmt!=null) pstmt.close();
			}
			catch ( Exception e ) 
			{
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try 
				{ 
					con.rollback(); 
				} 
				catch (Exception ee) {}
			}
		    
		}
		catch(Exception e){}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,p);
		}
		} // end if updatable

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
} // end session bean
