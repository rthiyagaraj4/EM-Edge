/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.MenuAccessRights;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MenuAccessRights"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MenuAccessRights"
*	local-jndi-name="MenuAccessRights"
*	impl-class-name="eSM.MenuAccessRights.MenuAccessRightsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.MenuAccessRights.MenuAccessRightsLocal"
*	remote-class="eSM.MenuAccessRights.MenuAccessRightsRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.MenuAccessRights.MenuAccessRightsLocalHome"
*	remote-class="eSM.MenuAccessRights.MenuAccessRightsHome"
*	generate= "local,remote"
*
*
*/

public class MenuAccessRightsManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	SessionContext ctx;
	String locale="";
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	int res2 = 0;

	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;
	}

	/**
	 *Method to update Menu Access Rights
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateMenuAccessRights(HashMap argMap) 
	 {	
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String insertaccessyn[]=(String[])argMap.get("insertaccessyn");
		String updateaccessyn[]=(String[])argMap.get("updateaccessyn");
		String deleteaccessyn[]=(String[])argMap.get("deleteaccessyn");
		String printaccessyn[]=(String[])argMap.get("printaccessyn");
		String queryonlyaccessyn[]=(String[])argMap.get("queryonlyaccessyn");
		String functionid[]=(String[])argMap.get("functionid");
		String menuid[]=(String[])argMap.get("menuid");
		
		Integer PvalInt=(Integer)argMap.get("Pval");
		int Pval=PvalInt.intValue();
		String  optionsequenceno[]=(String[])argMap.get("optionsequenceno");		
		String  addedAtWorkstation=(String)argMap.get("client_ip_address");
		
		String  subfunctionvalues[]=(String[])argMap.get("subfunctionvalues");

		
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result 		= false ;
		boolean updateable  = true ;
		StringBuffer sb 	= new StringBuffer( "" ) ;

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		
		
		try {

			 con = ConnectionManager.getConnection(p);
             
			} catch ( Exception e )
			  {
				updateable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;

				if (con != null)
				{
					try {
						} catch (Exception ee) {}
		      	}

			 }

		try {

		if ( updateable )
		{
		  
		  String sql = " UPDATE SM_MENU_DTL set INSERT_ACCESS_YN=?,UPDATE_ACCESS_YN=?,DELETE_ACCESS_YN=?,QUERY_ONLY_ACCESS_YN=?,PRINT_ACCESS_YN=?,added_by_id=?,added_date=sysdate,added_at_ws_no=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=? where MENU_ID=? and OPTION_SEQUENCE_NO=? ";
          pstmt = con.prepareStatement( sql );
			
		  String sql1 = " UPDATE SM_MENU_SFUNC_DTL set INCL_YN = ?, INSERT_ACCESS_YN = ?, UPDATE_ACCESS_YN = ?,DELETE_ACCESS_YN = ?,PRINT_ACCESS_YN = ?, QUERY_ONLY_ACCESS_YN = ?, MODIFIED_BY_ID = ?,MODIFIED_DATE = sysdate,MODIFIED_AT_WS_NO = ? Where MENU_ID = ? and OPTION_SEQUENCE_NO = ? and FUNCTION_ID = ? and SUBFUNCTION_ID = ? ";
		  pstmt1 = con.prepareStatement(sql1);
		  
		  for(int i = 1; i <= Pval ;i++)
		  {

			 pstmt.setString(1,insertaccessyn[i]);
			 pstmt.setString(2,updateaccessyn[i]);
			 pstmt.setString(3,deleteaccessyn[i]);
			 pstmt.setString(4,queryonlyaccessyn[i]);
			 pstmt.setString(5,printaccessyn[i]);
			 pstmt.setString(6,addedById);
			 pstmt.setString(7,addedAtWorkstation);
			 pstmt.setString(8,modifiedById);
			 pstmt.setString(9,modifiedAtWorkstation);
			 pstmt.setString(10,menuid[i]);
			 pstmt.setString(11,optionsequenceno[i]);
			 res2 = pstmt.executeUpdate() ;

						 if(res2 > 0)
						 {
								
							if(!subfunctionvalues[i].equals(""))
							 {
								StringTokenizer stoken = new StringTokenizer(subfunctionvalues[i],"$");
									
								while(stoken.hasMoreTokens())
								{
									String subvalues = stoken.nextToken();
									
									StringTokenizer subtoken = new StringTokenizer(subvalues,"|");

									String subfunc   = subtoken.nextToken();
									String includeyn = subtoken.nextToken();
									String insertyn  = subtoken.nextToken();
									String updateyn  = subtoken.nextToken();
									String deleteyn  = subtoken.nextToken();
									String queryyn   = subtoken.nextToken();
									String printyn   = subtoken.nextToken();

									pstmt1.setString(1,includeyn);
									pstmt1.setString(2,insertyn);
									pstmt1.setString(3,updateyn);
									pstmt1.setString(4,deleteyn);
									pstmt1.setString(5,printyn);
									pstmt1.setString(6,queryyn);
									pstmt1.setString(7,modifiedById);
									pstmt1.setString(8,modifiedAtWorkstation);
									pstmt1.setString(9,menuid[i]);
									pstmt1.setString(10,optionsequenceno[i]);
									pstmt1.setString(11,functionid[i]);
									pstmt1.setString(12,subfunc);
									 pstmt1.executeUpdate(); 
								} // end of while stoken
							 }  // end of SubFunctionValues
						 } // end of res2
		   }//E.O.for
	    }//e.O.IF
          
	     if (res2 != 0)
		  {
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
				sb.append( (String) message.get("message") ) ;
				con.commit();
				if(pstmt != null)  pstmt.close() ;
				if(pstmt1 != null) pstmt1.close() ;
		  
		  message.clear();
		  }
	 }catch ( Exception e )
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
					ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		      }

		   }


		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		argMap.clear();
		return results ;
	}//E.O.Modify

}//E.O.sess bean

