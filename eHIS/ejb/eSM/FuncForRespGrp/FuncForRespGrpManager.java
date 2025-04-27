/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.FuncForRespGrp ;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FuncForRespGrp"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FuncForRespGrp"
*	local-jndi-name="FuncForRespGrp"
*	impl-class-name="eSM.FuncForRespGrp.FuncForRespGrpManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.FuncForRespGrp.FuncForRespGrpLocal"
*	remote-class="eSM.FuncForRespGrp.FuncForRespGrpRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.FuncForRespGrp.FuncForRespGrpLocalHome"
*	remote-class="eSM.FuncForRespGrp.FuncForRespGrpHome"
*	generate= "local,remote"
*
*
*/

public class FuncForRespGrpManager implements SessionBean {
  String locale="";
	Connection con ;
	PreparedStatement pstmt ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
     SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {
	this.ctx = context;
	}
	
	/**
	 *Method to update FuncForRespGrp
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap update(

							java.util.HashMap tabdata1
						 ){

		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		ArrayList RM=(ArrayList)tabdata1.get("RM");	
		ArrayList RF=(ArrayList)tabdata1.get("RF");	
		ArrayList RC=(ArrayList)tabdata1.get("RC");	
		ArrayList AM=(ArrayList)tabdata1.get("AM");	
		ArrayList AF=(ArrayList)tabdata1.get("AF");	
		ArrayList AC=(ArrayList)tabdata1.get("AC");	
		String resp_group_id=(String)tabdata1.get("resp_group_id");		
		String addedAtWorkstation=(String)tabdata1.get("client_ip_address");	
		
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer("") ;

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;

		String whereclauseR1="";
		String whereclauseR2="";

		int res1=0;
		int res2=0;

		try {

			con = ConnectionManager.getConnection(p);

			} catch ( Exception e )
			  {
				insertable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;			

			 }

		if ( insertable )
		{
		  try {
			  if(RC.size() > 0)
			  {
				for(int i=0; i<RC.size();i++)
			  {

				whereclauseR1=whereclauseR1+"'"+(String) RM.get(i)+"'"+",";
				whereclauseR2=whereclauseR2+"'"+(String) RF.get(i)+"'"+",";
			  }
			  whereclauseR1=whereclauseR1.substring(0,whereclauseR1.length() -1 );
			  whereclauseR2=whereclauseR2.substring(0,whereclauseR2.length() -1 );

				String sql1="Delete from sm_func_by_resp_grp where module_id in ("+whereclauseR1+") and function_id in ("+whereclauseR2+") and resp_group_id ='"+resp_group_id+"'";
				 if(pstmt!=null) pstmt.close();
				 pstmt = con.prepareStatement( sql1.toString());
				 res1 = pstmt.executeUpdate() ;
				 pstmt.close();
			  }
			  else res1=1;

			String sql2="Insert into sm_func_by_resp_grp values (? ,?,?,?,sysdate,?,?,sysdate,?)";
			 pstmt = con.prepareStatement( sql2 );
					 
				
				if(AC.size()>0)
				 {
				  for(int i=0;i<AC.size();i++)
				  {
					  
					  pstmt.setString(1,(String)AM.get(i));
					  pstmt.setString(2,(String)AF.get(i));
					  pstmt.setString(3,resp_group_id);
					  pstmt.setString(4,addedById);
					  pstmt.setString(5,addedAtWorkstation);
					  pstmt.setString(6,modifiedById);
					  pstmt.setString(7,addedAtWorkstation);
					  res2 = pstmt.executeUpdate() ;
					  if(res2==0) break;
				  }
			   }
			    else res2=1;
				
				if (( res1 != 0 ) || (res2 != 0) )
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage(locale,	"RECORD_INSERTED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
				}
				pstmt.close() ;
			} catch ( Exception e )
			   {
				
					sb.append( e.getMessage() + "<br>" ) ;
					e.printStackTrace() ;
						try{
								con.rollback();
						   }catch (Exception ce){
							   ce.printStackTrace();
						   }
			   }

			finally
			{
			  if (con != null)
			  {
			   try
			   {
				      ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {
				   ee.printStackTrace();
			  }
		      }

		   }
		}//E.O.Insertable

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		tabdata1.clear();
		RM.clear();
        RF.clear();
		RC.clear();
		AM.clear();
		AF.clear();
		AC.clear();

		return results ;
	}//E.O.InsertOraRole
}//E.O.sess bean

