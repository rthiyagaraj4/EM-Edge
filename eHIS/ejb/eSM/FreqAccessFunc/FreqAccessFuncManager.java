/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.FreqAccessFunc;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FreqAccessFunc"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FreqAccessFunc"
*	local-jndi-name="FreqAccessFunc"
*	impl-class-name="eSM.FreqAccessFunc.FreqAccessFuncManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.FreqAccessFunc.FreqAccessFuncLocal"
*	remote-class="eSM.FreqAccessFunc.FreqAccessFuncRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.FreqAccessFunc.FreqAccessFuncLocalHome"
*	remote-class="eSM.FreqAccessFunc.FreqAccessFuncHome"
*	generate= "local,remote"
*
*
*/


public class FreqAccessFuncManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	 SessionContext ctx;
	ResultSet  rslno;
	String locale="";
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { this.ctx=context;}


	/**
	 *Method to insert FreqAccessFunction
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertFreqAccessFunc(

								java.util.HashMap tabdata1
						 ) 
		{

		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		String appl_user_id=(String)tabdata1.get("appl_user_id");
		String resp_id=(String)tabdata1.get("resp_id");
		String checkval=(String)tabdata1.get("checkval");
		String addedAtWorkstation=(String)tabdata1.get("addedAtWorkstation");

		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;
		boolean insertable = true ;
		int freq_func_srl_no =0;
		StringBuffer sb = new StringBuffer( "" ) ;
		
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		String option_sequence_no="";
		String module_id="";
		String function_id="";
		String menu_id="";
		int res=0;
		
						try
							{
								StringTokenizer outer = new StringTokenizer(checkval,"!");
								
								con = ConnectionManager.getConnection(p);
							
								String sqlSNo=" select nvl(max(FREQ_FUNC_SRL_NO),0)+1   from sm_freq_func_by_user where appl_user_id = ? and resp_id =?";
								pstmt=con.prepareStatement(sqlSNo);
								
								String sql = "insert into 	sm_freq_func_by_user values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?,?,sysdate,?)" ;
								pstmt1 = con.prepareStatement( sql );
								while(outer.hasMoreTokens())
								{	
									String outerVal = outer.nextToken();
									StringTokenizer inner = new StringTokenizer(outerVal,"|");
									while (inner.hasMoreTokens())
									{
										function_id    =inner.nextToken();
										menu_id      =inner.nextToken();
										option_sequence_no    =inner.nextToken(); 
										module_id   =inner.nextToken();
										
										
										if ( insertable )
										{
											
											pstmt.setString(1,appl_user_id);
                                            pstmt.setString(2,resp_id);
											rslno=pstmt.executeQuery();
											while (rslno !=null  && rslno.next()  )
											{
													freq_func_srl_no=rslno.getInt(1);
											}
											
											if(rslno!=null) rslno.close();
											
											pstmt1.setString(1, appl_user_id) ;
											pstmt1.setString(2, resp_id) ;
											pstmt1.setInt(3, freq_func_srl_no ) ;
											pstmt1.setString( 4,menu_id);
											pstmt1.setString( 5,option_sequence_no);
											pstmt1.setString( 6,module_id);
											pstmt1.setString( 7,function_id);
											pstmt1.setString( 8, addedById ) ;
											pstmt1.setString( 9, addedAtWorkstation ) ;
											pstmt1.setString( 10, modifiedById ) ;
											pstmt1.setString( 11,modifiedAtWorkstation) ;
											res = pstmt1.executeUpdate() ;
											
										}
									}
								}
								if(pstmt!=null)pstmt.close();
								if(pstmt1!=null)pstmt1.close();
								if ( res != 0 )
								{
									con.commit();
									result = true ;
									insertable=true;
									 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
									sb.append( (String) message.get("message") ) ;
                                    message.clear();									
								}
								else
								{
									insertable=false;
									con.rollback();
								}
								if(rslno!=null)  rslno.close();
								if(pstmt!=null) pstmt.close();								
							}
							catch ( Exception e ) 
							{
								sb.append( e.getMessage() + "<br>" ) ;
								sb.append( e.toString() + "<br>" ) ;
								e.printStackTrace() ;
								try
								{
									con.rollback() ;
								}catch(Exception ce){}
							}
						  finally 
						  {
							 
							   try
							  {
									ConnectionManager.returnConnection(con,p);
								} catch (Exception ee) {}
									 
        					 
						}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		tabdata1.clear();
		return results ;
	}


	/**
	 *Method to delete FreqAccessFunction
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap deleteFreqAccessFunc(
								java.util.HashMap tabdata1
						 ) 
		{

		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		String appl_user_id=(String)tabdata1.get("appl_user_id");
		String resp_id=(String)tabdata1.get("resp_id");
		String checkval=(String)tabdata1.get("checkval");
		

		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;
		boolean insertable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;

		String srl_no=""; 
		int res=0;

		
		try{
			con = ConnectionManager.getConnection(p);
			 StringTokenizer outer = new StringTokenizer(checkval,"!");
			 while(outer.hasMoreTokens())
			 {		
				String outerVal = outer.nextToken();
				StringTokenizer inner = new StringTokenizer(outerVal,"|");
				
				while (inner.hasMoreTokens())
				{
					appl_user_id    =inner.nextToken();
					srl_no    =inner.nextToken(); 


					try
					{
					}
					catch ( Exception e )
					{
						insertable = false ;
						sb.append( e.toString()+ "<br>" ) ;
						e.printStackTrace() ;
					}

				if ( insertable )
				{
					String sql = "delete from sm_freq_func_by_user where appl_user_id=?  and		resp_id=?  and  FREQ_FUNC_SRL_NO=?  " ;
					pstmt = con.prepareStatement( sql );
					pstmt.setString	( 1, appl_user_id) ;
					pstmt.setString	( 2, resp_id) ;
					pstmt.setInt  	( 3, Integer.parseInt(srl_no) ) ;
							
					 res = pstmt.executeUpdate() ;
					 if(res >0) con.commit();
					 if(pstmt!=null) pstmt.close();
				}
			}
		 }
		 	if ( res != 0 )
			{
				result = true ;
				 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				
				sb.append( (String) message.get("message") ) ;
				
			   message.clear();
			}
			else
			{
				insertable=false;
				con.rollback();
			}
			if(pstmt!=null) pstmt.close();
		}
		catch ( Exception e ) 
		{
			sb.append( e.getMessage() + "<br>" ) ;
			sb.append( e.toString() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback() ;
			}catch(Exception ce){}
		}
		finally 
		{
			ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		tabdata1.clear();
		return results ;
	}
}
