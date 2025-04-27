/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.menuDetail;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.rmi.Remote;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;



/**
*
* @ejb.bean
*	name="menuDetail"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="menuDetail"
*	local-jndi-name="menuDetail"
*	impl-class-name="eSM.menuDetail.menuDetailManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.menuDetail.menuDetailManagerLocal"
*	remote-class="eSM.menuDetail.menuDetailManagerRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.menuDetail.menuDetailManagerLocalHome"
*	remote-class="eSM.menuDetail.menuDetailManagerHome"
*	generate= "local,remote"
*
*
*/
public class menuDetailManager implements SessionBean
{
	String locale="";
	Connection con=null;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
    PreparedStatement pstmt3;
	PreparedStatement pstmt4;
	Statement stat;
	CallableStatement csstmt_pres	    =null;
	ResultSet rs=null;
	ResultSet rs1=null;
	java.util.Properties p;
	
	String sql="";
	String sql1="";
	String sql2="";
	String sql3="";
	String sql4="";
	String dsql="";
	String menuid="";
	String moduleid="";
	String functionid="";
	String submenuid="";
	String optiontype="";
	String option_descriptor="";
	String pres_result1="";
	String pres_result2="";
	String pres_result3="";
	String pres_result4="";
	String pres_result5="";
	String pres_result6="";
	int option_sequence=1;
	int srl_no=1;
	int temp=0;
	int res1=0;
			
	String      menu_id                ="";
	String      menus[]                ;
	String      addedAtWorkstation     ="";
	String      addedById              ="";   
	String      modifiedById           =""; 
	String      modifiedAtWorkstation  ="";
	java.util.HashMap results = new java.util.HashMap();
	StringBuffer sb = new StringBuffer( "" ) ;
	public final String RECORD_INSERTED = "RECORD_INSERTED";

	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext context) {}

	
	/**
	 *Method to insert Menu Detail
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public HashMap insertmenuDetail(HashMap argMap) 
	{       p=(java.util.Properties)argMap.get("p");
			locale = p.getProperty("LOCALE");
			menu_id=(String)argMap.get("menu_id");
			menus=(String[])argMap.get("menus");
			addedAtWorkstation=(String)argMap.get("client_ip_address");
			boolean result = false ;
			addedById = p.getProperty( "login_user" ) ;
			modifiedById = addedById ;
			modifiedAtWorkstation = addedAtWorkstation ;
			
			boolean pres_result=false;
			try
			{       con = ConnectionManager.getConnection(p);
					con.setAutoCommit(false);
					stat=con.createStatement();
				    csstmt_pres=con.prepareCall("{call PRESERVE_SM_FREQ_FUNC_BY_USER(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result1=csstmt_pres.getString(2);
					if(pres_result1 !=null && pres_result1.equals("1"))
					pres_result=true;
					else pres_result=false;
				   if (pres_result)	csstmt_pres.close();
				    csstmt_pres=con.prepareCall("{call DELETE_SM_FREQ_FUNC_BY_USER(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result2=csstmt_pres.getString(2);
					if(pres_result2 !=null && pres_result2.equals("1")) pres_result=true;
					else pres_result=false;
					if (pres_result)
					{
					csstmt_pres.close();
					csstmt_pres=con.prepareCall("{call PRESERVE_SM_MENU_RSTRN_RESP(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result3=csstmt_pres.getString(2);
					if(pres_result3 !=null && pres_result3.equals("1"))pres_result=true;
					else pres_result=false;
					}
					if (pres_result)
					{
					csstmt_pres.close();
					csstmt_pres=con.prepareCall("{call DELETE_SM_MENU_RSTRN_RESP(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result4=csstmt_pres.getString(2);
					if(pres_result4 !=null && pres_result4.equals("1"))	pres_result=true;
					else pres_result=false;
					}
					if (pres_result)
					{
					dsql="Delete sm_menu_sfunc_dtl where menu_id='" + menu_id + "'";
					stat.executeUpdate(dsql);
					dsql="Delete sm_menu_dtl where menu_id='" + menu_id + "'";
					stat.executeUpdate(dsql);
					
					
					pres_result=smmenudet();
										
					if (pres_result)
					{
					csstmt_pres.close();
					csstmt_pres=con.prepareCall("{call INSERT_SM_FREQ_FUNC_BY_USER(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result5=csstmt_pres.getString(2);
					if(pres_result5 !=null && pres_result5.equals("1"))
					pres_result=true;
					else
					pres_result=false;
					if (pres_result)
					{
					csstmt_pres.close();
					csstmt_pres=con.prepareCall("{call INSERT_SM_MENU_RSTRN_RESP(?,?)}");
					csstmt_pres.setString( 1, menu_id);
					csstmt_pres.registerOutParameter(2,Types.VARCHAR);
					csstmt_pres.execute();
					pres_result6=csstmt_pres.getString(2);
					if(pres_result6 !=null && pres_result6.equals("1"))
					pres_result=true;
					else
					pres_result=false;
					}
					if(pres_result){
						result = true ;
						con.commit();
						java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
					else{
						con.rollback();
						sb.append("Error while Preserving Records");
					}}
					else{ con.rollback();}
					}
					else{
						con.rollback();
						sb.append("Error while preserving Records");
					}}
			catch ( Exception e )
			{
				try{
					  con.rollback();
				}catch(Exception ce){
					ce.printStackTrace();
				}
				sb.append( "Error: " +e+ e.getMessage() + "<br>" ) ;
				e.printStackTrace();
			}
			finally
			{
				if (con != null)
				{
					try
					{
					  if(pstmt !=null) pstmt.close();
  					  if(csstmt_pres !=null) csstmt_pres.close();
					  if(stat !=null) stat.close();
					  if(rs !=null) rs.close();
					  if(rs1 !=null) rs1.close();
					  ConnectionManager.returnConnection(con,p);
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			argMap.clear();
			sb.setLength(0);
			return results ;
	}

public boolean smmenudet() 
{
	boolean retVal = true;
		try
		{			
					if( !(menus[0].equals("")) )
					{   
						if( !(menus.equals("") || menus==null ) )
						{
						String array[]=new String[7];
                        sql="Select insert_access_yn,update_access_yn,delete_access_yn,print_access_yn,query_only_access_yn,function_name from sm_function where function_id=? and module_id=?";
                        pstmt =con.prepareStatement(sql);
                        sql1="Select menu_name from sm_menu_hdr where menu_id=?";
                        pstmt1 =con.prepareStatement(sql1);
                        sql2="Insert into sm_menu_dtl(menu_id,option_sequence_no,srl_no,option_type,module_id,submenu_id,function_id,option_descriptor,insert_access_yn,update_access_yn,delete_access_yn,print_access_yn,query_only_access_yn,added_by_id,added_date,added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?)";
                        pstmt2=con.prepareStatement(sql2);
                        sql3 = "select subfunction_id,insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn from sm_subfunction where parent_function_id = ?";
                        pstmt3=con.prepareStatement(sql3);
                        sql4="insert into sm_menu_sfunc_dtl(module_id, menu_id, option_sequence_no, function_id, subfunction_id, incl_yn, insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn, added_by_id, added_date, added_at_ws_no, modified_by_id, modified_date, modified_at_ws_no) values(?,?,?,?,?,'Y',?,?,?,?,?,?,sysdate,?,?,sysdate,?)";
                        pstmt4=con.prepareStatement(sql4);
							for(int i=0;i<menus.length;i++)
							{	
								String insert="N";
								String update="N";
								String delete="N";
								String print="N";
								String query="N";
								java.util.StringTokenizer st=new java.util.StringTokenizer(menus[i],"#");
                                
								int n=0;
								while(st.hasMoreTokens())
								{
									array[n]=st.nextToken();
									 
									n++;
								}
								menuid=  array[0].trim();
								moduleid= array[1].trim();
								functionid= array[2].trim();
								submenuid= array[3].trim();
								optiontype= array[4].trim();
								option_sequence=Integer.parseInt(array[5].trim());
								srl_no=Integer.parseInt(array[6].trim());
								if((menuid.equals("undefined")) || (menuid == null) || (menuid.equals("null"))) 
								menuid = "";
								if((moduleid.equals("undefined")) || (moduleid == null) || (moduleid.equals("null")))
								moduleid = "";
								if((functionid.equals("undefined")) || (functionid == null) || (functionid.equals("null"))) 
								functionid = "";
								if((submenuid.equals("undefined")) || (submenuid == null) || (submenuid.equals("null"))) 
							    submenuid = "";
								if((optiontype.equals("undefined")) || (optiontype == null) || (optiontype.equals("null"))) 
								optiontype = "";
								
								if( optiontype.trim().equals("F") )
								{
									pstmt.setString(1,functionid.trim());
									pstmt.setString(2,moduleid.trim());
										rs=pstmt.executeQuery();
										if(rs !=null)
										{
											if(rs.next())
											{		insert=rs.getString(1);
													update=rs.getString(2);
													delete=rs.getString(3);
													print=rs.getString(4);
													
													query=rs.getString(5);
												    option_descriptor=rs.getString(6);
											}											
										}
								}
								if(rs!=null)
									rs.close();	
								if( optiontype.trim().equals("P") )
								{
									pstmt.setString(1,functionid.trim());
									pstmt.setString(2,moduleid.trim());// Added by Dharma on june 28th against ML-MMOH-SCF-0440 [IN:060736]
										rs=pstmt.executeQuery();
										if(rs !=null)
										{
											if(rs.next())
											{		insert=rs.getString(1);
													update=rs.getString(2);
													delete=rs.getString(3);
													print=rs.getString(4);
													
													query=rs.getString(5);
												    option_descriptor=rs.getString(6);
											}											
										}
								}
								if(rs!=null)
									rs.close();	
								if( optiontype.trim().equals("R") )
								{		
										pstmt.setString(1,functionid.trim());
										pstmt.setString(2,moduleid.trim());// Added by Dharma on june 28th against ML-MMOH-SCF-0440 [IN:060736]
										rs=pstmt.executeQuery();
										if(rs !=null)
										{
											if(rs.next())
											{       insert=rs.getString(1);
													update=rs.getString(2);
													delete=rs.getString(3);
													print=rs.getString(4);
													query=rs.getString(5);
													option_descriptor=rs.getString(6);
											} 											
										}
						 		}
								if(rs!=null)
									rs.close();
						 		if(optiontype.trim().equals("M"))
						 		{       pstmt1.setString(1,submenuid.trim());
										rs1=pstmt1.executeQuery();
										if(rs1 !=null)
										{
											if(rs1.next())
											{
												option_descriptor=rs1.getString(1);								
											}
										}
						 		}
								if(rs1!=null)
									rs1.close();
								temp += 1;
									pstmt2.setString(1,menuid.trim());
									pstmt2.setInt(2,option_sequence);
									pstmt2.setInt(3,srl_no);
									pstmt2.setString(4,optiontype.trim());
									pstmt2.setString(5,moduleid.trim());
									pstmt2.setString(6,submenuid.trim());
									pstmt2.setString(7,functionid.trim());
									pstmt2.setString(8,option_descriptor);
									pstmt2.setString(9,insert);
									pstmt2.setString(10,update);
									pstmt2.setString(11,delete);
									pstmt2.setString(12,print);
									pstmt2.setString(13,query);
									pstmt2.setString(14,addedById);
									pstmt2.setString(15,addedAtWorkstation);
									pstmt2.setString(16,modifiedById);
									pstmt2.setString(17,modifiedAtWorkstation);
									res1 = pstmt2.executeUpdate() ;
									if (res1>0) {
										pstmt3.setString(1,functionid.trim());
										rs = pstmt3.executeQuery();
										if (rs!=null) {
											while (rs.next()) {
												pstmt4.setString(1,moduleid.trim());
												pstmt4.setString(2,menuid.trim());
												pstmt4.setInt(3,option_sequence);
												pstmt4.setString(4,functionid.trim());
												pstmt4.setString(5,rs.getString(1));
												pstmt4.setString(6,rs.getString(2));
												pstmt4.setString(7,rs.getString(3));
												pstmt4.setString(8,rs.getString(4));
												pstmt4.setString(9,rs.getString(5));
												pstmt4.setString(10,rs.getString(6));
												pstmt4.setString(11,addedById);
												pstmt4.setString(12,addedAtWorkstation);
												pstmt4.setString(13,modifiedById);
												pstmt4.setString(14,modifiedAtWorkstation);
												res1 = pstmt4.executeUpdate() ;
												if(res1<1)
													retVal = false;
												//rs.close();
										   }
										}
										if(rs!=null) rs.close(); //Checklist
									} else {
										retVal = false;
									}
							}							
						}
					}
				pstmt.close();
				pstmt1.close();
				pstmt2.close();
				pstmt3.close();
				pstmt4.close();
				if(rs!=null)
					rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
