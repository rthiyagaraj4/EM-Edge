/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMRegFilesNotPulled;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ; 
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.st.RecordSetBean;

/**
*
* @ejb.bean
*	name="FMRegFilesNotPulled"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMRegFilesNotPulled"
*	local-jndi-name="FMRegFilesNotPulled"
*	impl-class-name="eFM.FMRegFilesNotPulled.FMRegFilesNotPulledManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMRegFilesNotPulled.FMRegFilesNotPulledLocal"
*	remote-class="eFM.FMRegFilesNotPulled.FMRegFilesNotPulledRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMRegFilesNotPulled.FMRegFilesNotPulledLocalHome"
*	remote-class="eFM.FMRegFilesNotPulled.FMRegFilesNotPulledHome"
*	generate= "local,remote"
*
*
*/

public class FMRegFilesNotPulledManager implements SessionBean
{
	Connection con				=	null;  
	PreparedStatement pstmt_upd	=	null;	
		
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;	
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		this.ctx=context;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateFMFilePullYN(
								java.util.Properties p,
								webbeans.st.RecordSetBean recordSet,
								String	  addedFacilityId,
								String	  addedAtWorkstation
								)  
	{
		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		String facilityId=addedFacilityId;
		String added_by_id = p.getProperty( "login_user" ) ;				
		String added_facility_id = addedFacilityId ;		
		String added_at_ws_no = addedAtWorkstation ;		

		String file_no="",patient_id="",file_pull_yn="";
		String update_sql="";
		String locale = p.getProperty("LOCALE");

		int update_count=0;

		Hashtable htRecord	=	new Hashtable();

		try 
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			update_sql="Update fm_pulling_list set file_pulled_yn=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where file_no=? and facility_id=? and patient_id=?";
			
			pstmt_upd	=	con.prepareStatement(update_sql);

			int row_count	=	recordSet.getSize();

			for(int k=0; k<row_count; k++)
			{
				htRecord			=	(java.util.Hashtable)	recordSet.getObject(k);
				file_pull_yn		=	(String)	htRecord.get("file_pull_yn");
				if(file_pull_yn.equals("Y"))
				{
					file_no			=	(String)	htRecord.get("file_no");
					patient_id		=	(String)	htRecord.get("patient_id");
										
					pstmt_upd.setString	(1,	"Y" );
					pstmt_upd.setString	(2,	added_by_id );
					pstmt_upd.setString	(3,	added_at_ws_no );
					pstmt_upd.setString	(4,	added_facility_id );
					pstmt_upd.setString	(5,	file_no );
					pstmt_upd.setString	(6,	facilityId );
					pstmt_upd.setString	(7,	patient_id );

					update_count = pstmt_upd.executeUpdate() ;				
				}
			}			
			if(update_count > 0)
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
			{
				result = false ;
				con.rollback();
			}
			htRecord.clear();
			if(pstmt_upd != null) pstmt_upd.close();
		}
		catch(Exception e)
		{
			sb.append(e.getMessage());
			if ( con != null )
			{
				try
				{
					con.rollback();
				}
				catch( Exception ce ) {
				sb.append("Exception While rollback" + ce.getMessage());
				}
			}

		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con, p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
