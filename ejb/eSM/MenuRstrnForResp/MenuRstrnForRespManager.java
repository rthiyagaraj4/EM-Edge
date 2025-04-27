/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.MenuRstrnForResp ;

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
*	name="MenuRstrnForResp"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MenuRstrnForResp"
*	local-jndi-name="MenuRstrnForResp"
*	impl-class-name="eSM.MenuRstrnForResp.MenuRstrnForRespManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.MenuRstrnForResp.MenuRstrnForRespLocal"
*	remote-class="eSM.MenuRstrnForResp.MenuRstrnForRespRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.MenuRstrnForResp.MenuRstrnForRespLocalHome"
*	remote-class="eSM.MenuRstrnForResp.MenuRstrnForRespHome"
*	generate= "local,remote"
*
*
*/



public class MenuRstrnForRespManager implements SessionBean {
    
	Connection con ;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	PreparedStatement pstmt1;
	PreparedStatement pstmt_delete;
	java.util.Properties p;
	String locale="";
	int res1=0;
	int res2=0;
    int res_delete=0;
	int count=0;
	boolean result = false ;
	boolean insertable = true ;
	String rSql              ="";
	SessionContext ctx;
	PreparedStatement pstmt11=null;
	PreparedStatement pstmt22=null;
	String freq_cnt1          ="";
	String resp_id            ="";
    String submenu_id         ="";
    String option_type        ="";
    String addedAtWorkstation ="";
	String sql1               ="";
	String sql_delete         ="";
    String addedById          ="";
    String modifiedById       ="";
	String sql2="";
	String freq_cnt="";
	ResultSet rs=null;
    StringBuffer sb = new StringBuffer( "" ) ;
	ArrayList RC; 
    ArrayList RO;
	ArrayList AC;
	ArrayList AE;
	ArrayList AI;
	ArrayList AU;
	ArrayList AD;
	ArrayList AP;
	ArrayList AQ;
	ArrayList AO;
	ArrayList AM;
	ArrayList AF;
	ArrayList AS;
	ArrayList RM;
	ArrayList AN;
	ArrayList SFA;

	public final String RECORD_INSERTED = "RECORD_INSERTED" ;

	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;
	}
	/**
	 *Method to update Menu Restriction for Responsibility
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap update(
							
							HashMap argMap
			 ) {
		
		p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		RC=(ArrayList)argMap.get("RC");
		RO=(ArrayList)argMap.get("RO");
		AC=(ArrayList)argMap.get("AC");
		AE=(ArrayList)argMap.get("AE");
		AI=(ArrayList)argMap.get("AI");
		AU=(ArrayList)argMap.get("AU");
		AD=(ArrayList)argMap.get("AD");
		AP=(ArrayList)argMap.get("AP");
		AQ=(ArrayList)argMap.get("AQ");
		AO=(ArrayList)argMap.get("AO");
		AM=(ArrayList)argMap.get("AM");
		AF=(ArrayList)argMap.get("AF");
		AS=(ArrayList)argMap.get("AS");
		RM=(ArrayList)argMap.get("RM");
		AN=(ArrayList)argMap.get("AN");
		SFA=(ArrayList)argMap.get("SFA");
		 
		resp_id            =(String)argMap.get("resp_id");

		submenu_id         =(String)argMap.get("submenu_id");

		option_type        =(String)argMap.get("option_type");
	
		addedAtWorkstation =(String)argMap.get("client_ip_address");


    	java.util.HashMap results = new java.util.HashMap() ;
		 addedById    =     p.getProperty( "login_user" ) ;
		 modifiedById = addedById ;
		
		try {	con = ConnectionManager.getConnection(p);
			} catch ( Exception e )  {
		insertable = false ;
		sb.append( e.getMessage() + "<br>" ) ;
		e.printStackTrace() ;
  	 }
 	if ( insertable )
	{	 
		 
		  boolean res= restrictMenuForResp();
         if(res)
              restrictMenuForResp1();
		
		}//E.O.Insertable
          RC.clear();
		  RO.clear();
		  AC.clear();
		  AE.clear();
		  AI.clear();
		  AU.clear();
		  AD.clear();
		  AP.clear();	
		  AQ.clear();
		  AO.clear();
		  AM.clear();
		  AF.clear();
		  AS.clear();
		  RM.clear();
		  AN.clear();
		  SFA.clear();
		  argMap.clear();

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		return results ;
	}


public boolean  restrictMenuForResp()
{try {
			if(RC.size()>0)
			{  rSql = "Delete from SM_SFUNC_RSTRN_RESP where resp_id=? and menu_id=? and option_sequence_no =?";
			   pstmt2 = con.prepareStatement( rSql );								
               sql1="Delete from sm_menu_rstrn_resp where resp_id=? and menu_id=? and option_sequence_no =?" ;
			   pstmt = con.prepareStatement( sql1 ); 
			 
			 for(int i=0;i<RC.size();i++)
				 {
									pstmt2.setString(1,resp_id);
									pstmt2.setString(2,(String) RM.get(i));
                                    pstmt2.setString(3,(String) RO.get(i));
                                    pstmt2.executeUpdate() ; 			
									pstmt.setString(1,resp_id);
									pstmt.setString(2,(String) RM.get(i));
                                    pstmt.setString(3,(String) RO.get(i));
    							    pstmt.executeUpdate() ;
							 }  
							 
							 }
                           if(pstmt2!=null)pstmt2.close();
						   if(pstmt2!=null)pstmt2.close();
   
   }catch(Exception e)
	{
	   e.printStackTrace();
	}

return true;
}

public void  restrictMenuForResp1()
{	try {

	      if(AC.size()>0)
			 {	sql2="Insert into sm_menu_rstrn_resp values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?)";

				pstmt = con.prepareStatement( sql2 );
				freq_cnt="select count(*) from sm_freq_func_by_user where resp_id=? and menu_id =? and function_id=? ";
				pstmt1=con.prepareStatement( freq_cnt );
				freq_cnt1="select count(*) from sm_freq_func_by_user where resp_id=? and menu_id =?";
				pstmt11=con.prepareStatement(freq_cnt1);
				String sql22 = " Insert into SM_SFUNC_RSTRN_RESP (RESP_ID, MENU_ID, OPTION_SEQUENCE_NO, MODULE_ID, FUNCTION_ID, SUBFUNCTION_ID, INCL_YN, INSERT_ACCESS_YN,UPDATE_ACCESS_YN, DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO) Values (?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,SYSDATE,?)";
    			pstmt22 = con.prepareStatement(sql22);



				for(int i=0;i<AC.size();i++)
                 {

					if(option_type.equals("F") || option_type.equals("R") )
				  {

				 pstmt.setString(1,resp_id);
				 pstmt.setString(2,submenu_id);
				 pstmt.setString(3,(String) AO.get(i));
				 pstmt.setString(4,option_type);
				 pstmt.setString(5,(String) AE.get(i));
                 pstmt.setString(6,(String) AM.get(i));
				 pstmt.setString(7,(String) AF.get(i));
				 pstmt.setString(8,(String) AS.get(i));
				 pstmt.setString(9,(String) AI.get(i));
				 pstmt.setString(10,(String) AU.get(i));
				 pstmt.setString(11,(String) AD.get(i));
				 pstmt.setString(12,(String) AP.get(i));
				 pstmt.setString(13,(String) AQ.get(i));
				 pstmt.setString(14,addedById);
				 pstmt.setString(15,addedAtWorkstation);
				 pstmt.setString(16,modifiedById);
				 pstmt.setString(17,addedAtWorkstation);
				
				 // To delete the excluded records from freq accessed list if any// freq_cnt="select count(*) from sm_freq_func_by_user where resp_id=? and menu_id =? and function_id=? ";	//	pstmt1=con.prepareStatement( freq_cnt );
					
					pstmt1.setString(1, resp_id);
					pstmt1.setString(2, submenu_id);
					pstmt1.setString(3, (String) AF.get(i) );
					rs= pstmt1.executeQuery();
					if(rs!=null)
					  {		while (rs.next())
							{	count=rs.getInt(1);		}
					  }
				   sql_delete="delete from sm_freq_func_by_user where resp_id='"+resp_id+"' and menu_id = '"+submenu_id+"' and function_id='"+(String) AF.get(i)+"'";
       			    if(rs!=null) rs.close();
					}else if(option_type.equals("M"))
					{

				 pstmt.setString(1,resp_id);
				 pstmt.setString(2,(String) AN.get(i));
				 pstmt.setString(3,(String) AO.get(i));
				 pstmt.setString(4,option_type);
				 pstmt.setString(5,(String) AE.get(i));
                 pstmt.setString(6,(String) AM.get(i));
				 pstmt.setString(7,(String) AF.get(i));
				 pstmt.setString(8,(String) AS.get(i));

				 pstmt.setString(9,(String) AI.get(i));
				 pstmt.setString(10,(String) AU.get(i));
				 pstmt.setString(11,(String) AD.get(i));
				 pstmt.setString(12,(String) AP.get(i));
				 pstmt.setString(13,(String) AQ.get(i));
				 pstmt.setString(14,addedById);
				 pstmt.setString(15,addedAtWorkstation);
				 pstmt.setString(16,modifiedById);
				 pstmt.setString(17,addedAtWorkstation);
				  
				  
				 //count query	
				pstmt11.setString(1, resp_id);
				pstmt11.setString(2, (String)AS.get(i));
				rs= pstmt11.executeQuery();
				if(rs!=null)
        			  {	while (rs.next())
							{
		 					count=rs.getInt(1);
							}  }
							
				   sql_delete="delete from sm_freq_func_by_user where resp_id='"+resp_id+"' and menu_id = '"+submenu_id+"'";
    			   if(rs!=null) rs.close();	}



				  res2 = pstmt.executeUpdate() ;

			      if(res2 > 0)
				   {		String subfunctionvalues = (String) SFA.get(i);
				             
							if(!subfunctionvalues.equals(""))
							 {  	StringTokenizer stoken = new StringTokenizer(subfunctionvalues,"$");
									while(stoken.hasMoreTokens())
									{   	String subvalues = stoken.nextToken();
											StringTokenizer subtoken = new StringTokenizer(subvalues,"|");
											String subfunc   = subtoken.nextToken();
											String includeyn = subtoken.nextToken();
											String insertyn  = subtoken.nextToken();
											String updateyn  = subtoken.nextToken();
											String deleteyn  = subtoken.nextToken();
											String queryyn   = subtoken.nextToken();
											String printyn   = subtoken.nextToken();
											
											if(includeyn.equals("Y"))
											{
												pstmt22.setString(1, resp_id);
												pstmt22.setString(2, submenu_id);
												pstmt22.setString(3,(String) AO.get(i));
												pstmt22.setString(4,(String) AM.get(i));
												pstmt22.setString(5,(String) AF.get(i));
												pstmt22.setString(6,subfunc);
												pstmt22.setString(7,includeyn);
												pstmt22.setString(8,insertyn);
												pstmt22.setString(9, updateyn);
												pstmt22.setString(10, deleteyn);
												pstmt22.setString(11, printyn);
												pstmt22.setString(12, queryyn);
												pstmt22.setString(13, addedById);
												pstmt22.setString(14, addedAtWorkstation);
												pstmt22.setString(15, modifiedById);
												pstmt22.setString(16, addedAtWorkstation);
												pstmt22.executeUpdate(); 
												
												}
										} // end of while stoken
									 }  // end of SubFunctionValues
								}
							 if(count>0)
							  {	  pstmt_delete = con.prepareStatement( sql_delete );
								  res_delete = pstmt_delete.executeUpdate();
							  }else res_delete=1;
							  if(pstmt_delete!=null) pstmt_delete.close();
							  if(res2==0) break;
							  if(res_delete==0) break;
							} // end of for
						}
						else res2=1;
						if(pstmt!=null)pstmt.close();
						if(pstmt1!=null)pstmt1.close();
						if(pstmt11!=null)pstmt11.close();
						if(pstmt22!=null)pstmt22.close();
						if (( res1 != 0 ) || (res2 != 0)|| (res_delete != 0) )
						{	
							result = true ;
							java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
							sb.append( (String) message.get("message") ) ;
							con.commit();
							message.clear();
						}	if(pstmt!=null) pstmt.close() ;
						
					} catch ( Exception e )
		    {	sb.append( e.getMessage() + "<br>" ) ;
					
				e.printStackTrace() ;
				try{con.rollback();
				   }catch (Exception ce){
					   ce.printStackTrace();
				   }
			}	finally
			{  if (con != null)
			  {   try
			   {	ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {
				   ee.printStackTrace();
			   }
		      } }
}

}//E.O.sess bean


