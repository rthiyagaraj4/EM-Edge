/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.UserAccessRights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

/**
*
* @ejb.bean
*	name="UserAccessRights"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="UserAccessRights"
*	local-jndi-name="UserAccessRights"
*	impl-class-name="eMR.UserAccessRights.UserAccessRightsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.UserAccessRights.UserAccessRightsLocal"
*	remote-class="eMR.UserAccessRights.UserAccessRightsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.UserAccessRights.UserAccessRightsLocalHome"
*	remote-class="eMR.UserAccessRights.UserAccessRightsHome"
*	generate= "local,remote"
*
*
*/

public class UserAccessRightsManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 =null ;
	ResultSet rs = null;

	public static final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public static final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public static final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	//SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {/*this.ctx=context;*/}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insertUserAccessRights(Properties p,	HashMap hashdata) 
	{
		String  appl_user_id =(String)hashdata.get("appl_user_id");
		String 	rec_sen_diag_for_cons_pat_yn =(String)hashdata.get("rec_sen_diag_for_cons_pat_yn");
		String 	rec_sen_diag_for_oth_pat_yn =(String)hashdata.get("rec_sen_diag_for_oth_pat_yn");
		String	vw_sen_diag_for_cons_pat_yn =(String)hashdata.get("vw_sen_diag_for_cons_pat_yn");
		String 	vw_sen_diag_for_oth_pat_yn =(String)hashdata.get("vw_sen_diag_for_oth_pat_yn");
		String 	sen_diag_password =(String)hashdata.get("sen_diag_password");
		String 	rec_high_risk_for_cons_pat_yn =(String)hashdata.get("rec_high_risk_for_cons_pat_yn");
		String 	rec_high_risk_for_oth_pat_yn =(String)hashdata.get("rec_high_risk_for_oth_pat_yn");
		String 	vw_high_risk_for_cons_pat_yn =(String)hashdata.get("vw_high_risk_for_cons_pat_yn");
		String 	vw_high_risk_for_oth_pat_yn =(String)hashdata.get("vw_high_risk_for_oth_pat_yn");
		String 	high_risk_password =(String)hashdata.get("high_risk_password");
		//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
		String 	change_national_id =(String)hashdata.get("change_national_id");
		String 	enable_national_id =(String)hashdata.get("enable_national_id"); //Added by Ashwin K for AAKH-CRF-0150

		String 	myhix_view_YN =(String)hashdata.get("myhix_view_YN"); //Added for MYHIX integration ML-MMOH-CRF-0507.1
		String 	cancel_transfer_in_yn =(String)hashdata.get("cancel_transfer_in_yn"); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124

		String 	requestor_type_yn =(String)hashdata.get("requestor_type_yn"); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707

		String	addedFacilityId =(String)hashdata.get("addedFacilityId");
		String	addedAtWorkstation =(String)hashdata.get("addedAtWorkstation");
		String 	user_fac_id =(String)hashdata.get("user_fac_id");
		String locale = p.getProperty("LOCALE");


		HashMap results = new HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sbSql = new StringBuffer();

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		try
		{
			con = ConnectionManager.getConnection(p);

			//Duplicate Check
			final String duplicateSql = "select appl_user_id from MR_USER_ACCESS_RIGHTS where facility_id = ? and appl_user_id =?" ;
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, user_fac_id) ;
			pstmt.setString( 2, appl_user_id) ;

			 rs = pstmt.executeQuery() ;

			if(rs.next())
			{
				insertable = false ;
				final Hashtable message = MessageManager.getMessage(locale,CODE_ALREADY_EXISTS,"MP") ;
				sb.append((String) message.get("message"));
				if ( message != null ) message.clear();
				rs.close();
				pstmt.close();
			}

			if(insertable)
			{
				try
				{
					if(sbSql.length() > 0 ) 
					sbSql.delete(0,sbSql.length());
					//Maheshwaran K added "CHANGE_NATIONAL_ID_NO_YN" in the query for the Bru-HIMS-CRF-283 as on 17/08/2012
					sbSql.append(" insert into MR_USER_ACCESS_RIGHTS ( ");
					sbSql.append(" facility_id, appl_user_id,	 rec_sen_diag_for_cons_pat_yn, ");
					sbSql.append(" rec_sen_diag_for_oth_pat_yn, vw_sen_diag_for_cons_pat_yn, ");
					sbSql.append(" vw_sen_diag_for_oth_pat_yn, sen_diag_password, ");
					sbSql.append(" rec_high_risk_for_cons_pat_yn,	 rec_high_risk_for_oth_pat_yn, ");
					sbSql.append(" vw_high_risk_for_cons_pat_yn,	 vw_high_risk_for_oth_pat_yn, ");
					sbSql.append(" high_risk_password, added_by_id,  added_date,added_facility_id, added_at_ws_no,modified_by_id, ");
					sbSql.append(" modified_date, modified_facility_id,	 modified_at_ws_no ,CHANGE_NATIONAL_ID_NO_YN,ENABLE_EMIRATES_ID_YN,myhix_view_YN, cancel_transfer_in_yn , requestor_type_yn");
					sbSql.append(" ) values ( '"+user_fac_id+"', '"+appl_user_id+"', '"+rec_sen_diag_for_cons_pat_yn+"', '"+rec_sen_diag_for_oth_pat_yn+"', '"+vw_sen_diag_for_cons_pat_yn+"', '"+vw_sen_diag_for_oth_pat_yn+"',APP_PASSWORD.Encrypt('"+sen_diag_password+"'), '"+rec_high_risk_for_cons_pat_yn+"', '"+rec_high_risk_for_oth_pat_yn+"', '"+vw_high_risk_for_cons_pat_yn+"','"+vw_high_risk_for_oth_pat_yn+"', ");
					sbSql.append(" APP_PASSWORD.Encrypt('"+high_risk_password+"'),'"+addedById+"',SYSDATE,'"+addedFacilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',SYSDATE,'"+modifiedFacilityId+"','"+modifiedAtWorkstation+"','"+change_national_id+"','"+enable_national_id+"','"+myhix_view_YN+"','"+cancel_transfer_in_yn+"','"+requestor_type_yn+"') "); //modified by Sangeetha on 5-apr-17 for GDOH-CRF-0124
					//"requestor_type_yn" Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
					//"ENABLE_EMIRATES_ID_YN" Added by Ashwin K for AAKH-CRF-0150

					pstmt1 = con.prepareStatement( sbSql.toString() );

					int res1 = pstmt1.executeUpdate() ;
					con.commit() ;

					if(res1 != 0) 
					{
						result = true ;
						Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED ,"SM") ;
						sb.append( (String) message.get("message") ) ;
						if ( message != null ) message.clear();
					}

					if( pstmt1!=null ) pstmt1.close() ;
				
				}catch ( Exception e ) 
				{
					sb.append( e.getMessage() +"in exception"+ "<br>" ) ;
					e.printStackTrace() ;

					if ( con != null ) 
						con.rollback();
				}
			}
		if(rs != null)rs.close();
		}catch ( Exception e )
		{
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
		}
		finally
		{ 
			if (con != null)
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

	public HashMap updateUserAccessRights(Properties p, HashMap hashdata)
	{


		String 	rec_sen_diag_for_cons_pat_yn =(String)hashdata.get("rec_sen_diag_for_cons_pat_yn");
		String 	rec_sen_diag_for_oth_pat_yn =(String)hashdata.get("rec_sen_diag_for_oth_pat_yn");
		String	vw_sen_diag_for_cons_pat_yn =(String)hashdata.get("vw_sen_diag_for_cons_pat_yn");
		String 	vw_sen_diag_for_oth_pat_yn =(String)hashdata.get("vw_sen_diag_for_oth_pat_yn");
		String 	sen_diag_password =(String)hashdata.get("sen_diag_password");
		String 	rec_high_risk_for_cons_pat_yn =(String)hashdata.get("rec_high_risk_for_cons_pat_yn");
		String 	rec_high_risk_for_oth_pat_yn =(String)hashdata.get("rec_high_risk_for_oth_pat_yn");
		String 	vw_high_risk_for_cons_pat_yn =(String)hashdata.get("vw_high_risk_for_cons_pat_yn");
		String 	vw_high_risk_for_oth_pat_yn =(String)hashdata.get("vw_high_risk_for_oth_pat_yn");
		String 	high_risk_password =(String)hashdata.get("high_risk_password");
		String	modifiedFacilityId =(String)hashdata.get("modifiedFacilityId");
		String	modifiedAtWorkstation =(String)hashdata.get("modifiedAtWorkstation");
		String  appl_user_id =(String)hashdata.get("appl_user_id");
		String 	user_fac_id =(String)hashdata.get("user_fac_id");
		//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
		String 	change_national_id =(String)hashdata.get("change_national_id");
		String 	enable_national_id =(String)hashdata.get("enable_national_id");//Added by Ashwin K for AAKH-CRF-0150

		String 	myhix_view_YN =(String)hashdata.get("myhix_view_YN"); //Added for MYHIX integration ML-MMOH-CRF-0507.1
		String 	cancel_transfer_in_yn =(String)hashdata.get("cancel_transfer_in_yn"); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
		
		String 	requestor_type_yn =(String)hashdata.get("requestor_type_yn"); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707

		HashMap results = new HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		StringBuffer sbSql = new StringBuffer();

		String modifiedById = p.getProperty( "login_user" ) ;
		String locale = p.getProperty( "LOCALE" ) ;

		if ( updatable ) 
		{
			try
			{
				con = ConnectionManager.getConnection(p);

				if(sbSql.length() > 0 ) 
				sbSql.delete(0,sbSql.length());
				//Maheshwaran K added "CHANGE_NATIONAL_ID_NO_YN" in the query for the Bru-HIMS-CRF-283 as on 17/08/2012
				sbSql.append(" update mr_user_access_rights set ");
				sbSql.append(" rec_sen_diag_for_cons_pat_yn = '"+rec_sen_diag_for_cons_pat_yn+"', ");
				sbSql.append(" rec_sen_diag_for_oth_pat_yn  = '"+rec_sen_diag_for_oth_pat_yn+"', ");
				sbSql.append(" vw_sen_diag_for_cons_pat_yn  = '"+vw_sen_diag_for_cons_pat_yn+"', ");
				sbSql.append(" vw_sen_diag_for_oth_pat_yn = '"+vw_sen_diag_for_oth_pat_yn+"', ");
				sbSql.append(" sen_diag_password= APP_PASSWORD.Encrypt('"+sen_diag_password+"'), ");
				sbSql.append(" rec_high_risk_for_cons_pat_yn = '"+rec_high_risk_for_cons_pat_yn+"', ");
				sbSql.append(" rec_high_risk_for_oth_pat_yn  = '"+rec_high_risk_for_oth_pat_yn+"', ");
				sbSql.append(" vw_high_risk_for_cons_pat_yn  = '"+vw_high_risk_for_cons_pat_yn+"', ");
				sbSql.append(" vw_high_risk_for_oth_pat_yn   = '"+vw_high_risk_for_oth_pat_yn+"', ");
				sbSql.append(" high_risk_password =APP_PASSWORD.Encrypt('"+high_risk_password+"'), ");
				sbSql.append(" modified_by_id = '"+modifiedById+"', ");
				sbSql.append(" modified_date = sysdate, ");
				sbSql.append(" modified_facility_id = '"+modifiedFacilityId+"', ");
				sbSql.append(" modified_at_ws_no	= '"+modifiedAtWorkstation+"' , ");
				sbSql.append(" CHANGE_NATIONAL_ID_NO_YN	= '"+change_national_id+"' , ");
				sbSql.append(" ENABLE_EMIRATES_ID_YN	= '"+enable_national_id+"' , "); //Added by Ashwin K for AAKH-CRF-0150
				sbSql.append(" myhix_view_YN	= '"+myhix_view_YN+"' , ");
				sbSql.append(" cancel_transfer_in_yn	= '"+cancel_transfer_in_yn+"' , "); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
				sbSql.append(" requestor_type_yn	= '"+requestor_type_yn+"'  "); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
				sbSql.append(" where ");
				sbSql.append(" appl_user_id = '"+appl_user_id+"' and facility_id = '"+user_fac_id+"' ");

				pstmt = con.prepareStatement(sbSql.toString());

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) 
				{
					result = true ;
					con.commit() ;
					Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM") ;
					sb.append( (String) message.get("message") ) ;
					if ( message != null ) message.clear();
				}

				if(pstmt != null)	pstmt.close() ;

			}catch(Exception e) 
			{
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
			{
				if(con != null)
					ConnectionManager.returnConnection(con,p);
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
