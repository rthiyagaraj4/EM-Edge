/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.DBRole ;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="DBRole"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DBRole"
*	local-jndi-name="DBRole"
*	impl-class-name="eSM.DBRole.DatabaseRoleManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.DBRole.DatabaseRoleLocal"
*	remote-class="eSM.DBRole.DatabaseRoleRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.DBRole.DatabaseRoleLocalHome"
*	remote-class="eSM.DBRole.DatabaseRoleHome"
*	generate= "local,remote"
*
*
*/

public class DatabaseRoleManager implements SessionBean {

	Connection con ;
	
	PreparedStatement pstmt ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public String connection_pooling_yn="";
    String locale=""; 
	//public void ejbCreate() throws CreateException {}  //checklist commented
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {
	}
	/**
	 *Method to update DatabaseRole
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateOraRole(
							java.util.HashMap tabdata1
						 ) {

		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		String ora_role_id1=(String)tabdata1.get("ora_role_id1");	
		String ora_role_password1=(String)tabdata1.get("ora_role_password1");	
		String addedAtWorkstation=(String)tabdata1.get("addedAtWorkstation");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		try {

			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			} catch ( Exception e )
			  {
				insertable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;

			}

		if ( insertable )
		{
		  try {
			connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;

			String ora_role_password="";
			if(connection_pooling_yn.equals("Y")) 
			{
				
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN'";
				pstmt=con.prepareStatement(sql_ora);
				ResultSet rs_ora=pstmt.executeQuery();
				if(rs_ora!=null)
				{
					while(rs_ora.next())
					{
						ora_role_password=rs_ora.getString(1);
					
					
					}
					rs_ora.close();
				}

				else
				{
					sb.append("Record not Found For the Role MEDADMIN");
				}
				if(ora_role_password != null && !ora_role_password.equals("")){
					try{
						ora_role_password=ora_role_password.trim();
						sql_ora="Set Role MEDADMIN identified by "+ora_role_password;				
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sql_ora);
						pstmt.execute();		
						pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());				
					}
			   }else{
				   try{
						ora_role_password=ora_role_password.trim();
						sql_ora="Set Role MEDADMIN";	
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sql_ora);
						pstmt.execute();	
						pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());				
					}
			   }
			}
	
		String sql1 =" UPDATE 	SM_ora_role	 set ora_role_password = app_password.encrypt('"+ ora_role_password1 +"')," +
					 " ora_privilege 	 = 'E'	  ,	" +
					 " added_by_id 		 = '"+ addedById +"'  ,	" +
					 " added_date 		 = sysdate		  ,				" +
					 " added_at_ws_no 	 = '"+ addedAtWorkstation +"' , " +
					 " modified_by_id 	 = '"+ modifiedById +"'	      ,	" +
					 " modified_date 	 = sysdate	   ,				" +
					 " modified_at_ws_no = '"+ modifiedAtWorkstation +"'" +
					 " where	ora_role_id='"+ ora_role_id1 +"' and 	" +
					 " (ora_role_password != app_password.encrypt('"+ora_role_password1+"')"+
					 " 	)";

					if(pstmt!=null)pstmt.close();
					 pstmt = con.prepareStatement(sql1);
					 int res1 = pstmt.executeUpdate() ;

				  
		String sqlA1 = "ALTER role "+ora_role_id1.trim()+" identified by "+ora_role_password1.trim();

		
					if(pstmt!=null)pstmt.close();
					 pstmt = con.prepareStatement(sqlA1);
					  pstmt.execute();


				if (( res1 != 0 ))
				{
					result = true ;
					 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();
					
				}
				else{
					try{
					con.rollback();
					
					}catch(Exception es){}
				}


				
			} catch ( Exception e )
			   {
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
			try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
				
				}
				  if(pstmt !=null) pstmt.close();
				  
				  ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		      }

		   }
		}//E.O.Insertable

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}//E.O.InsertOraRole
}//E.O.sess bean

