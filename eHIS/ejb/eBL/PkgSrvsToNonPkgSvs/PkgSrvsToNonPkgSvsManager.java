/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.PkgSrvsToNonPkgSvs;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.io.* ;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="PkgSrvsToNonPkgSvs"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgSrvsToNonPkgSvs"
*	local-jndi-name="PkgSrvsToNonPkgSvs"
*	impl-class-name="eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsLocal"
*	remote-class="eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsLocalHome"
*	remote-class="eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsHome"
*	generate= "local,remote"
*
*
*/


public class PkgSrvsToNonPkgSvsManager implements SessionBean
{
	Connection con;
	SessionContext ctx;
	boolean insertable = false;
	String locale = "";
	StringBuffer sys_err = new StringBuffer("") ;
	

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	
/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata) 
	{		
		con = ConnectionManager.getConnection(p);
		CallableStatement cstmt = null;
		HashMap return_mess = new HashMap();
		String str_error_level	="";
		String str_error_text	="";
		String str_sysmesage_id	="";
		
	//	int result = 0;
		String locale = "";
		String client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";
		
		String user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";
		//locale = (String) tabdata.get("locale");
		if(locale==null) locale="en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		facility_id = facility_id==null?"": facility_id;
		String patientId = (String) tabdata.get("patientId");
		patientId = patientId==null?"": patientId;
		String packageSeqNo = "";
		String delCheck		= "";
		int totRec = 0;
		int transDocRefLineNo = 0;
		HashMap srvsToNonPkgSvsDtls	= (HashMap) tabdata.get("srvsToNonPkgSvsDtls");
		ArrayList packageSeqNoList	= (ArrayList) tabdata.get("packageSeqNoList");
		if(packageSeqNoList!=null && packageSeqNoList.size()>0)
			totRec = packageSeqNoList.size();
		/*System.out.println("totRec from bean :"+totRec);
		System.out.println("packageSeqNoList from bean :"+packageSeqNoList);
		System.out.println("srvsToNonPkgSvsDtls from bean :"+srvsToNonPkgSvsDtls);*/
		ArrayList srvDetails		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		try
		{
			con.setAutoCommit( false ) ;			
			insertable = true;
			if(insertable && totRec>0)
			{
				String sql="{ call   blpackage.Change_Pkg_Serv_To_Non_Pkg(?,?,?,?,?,?,?,?)}";
				for(int k=0;k<totRec;k++)
				{
					packageSeqNo = (String)packageSeqNoList.get(k);
					//System.out.println("packageSeqNo from bean :"+packageSeqNo);
					if(insertable && srvsToNonPkgSvsDtls!=null && srvsToNonPkgSvsDtls.containsKey(packageSeqNo))
					{
						srvDetails = (ArrayList) srvsToNonPkgSvsDtls.get(packageSeqNo);
						if(srvDetails!=null && srvDetails.size()>0)
						{
							for(int i=0;i<srvDetails.size(); i++)
							{
								dtls	= (ArrayList)srvDetails.get(i);
								delCheck= (String)dtls.get(10); 
								//System.out.println(" delCheck:"+delCheck);
								transDocRefLineNo  = Integer.parseInt((String)dtls.get(1));
								//System.out.println(" transDocRefLineNo:"+transDocRefLineNo);
								//System.out.println(" transDocRef:"+(String)dtls.get(0));

								if(delCheck!=null && delCheck.equals("Y"))
								{	 //System.out.println("here inside");
									try
									{
										cstmt = con.prepareCall(sql);	
										cstmt.setString(1,facility_id);
										cstmt.setString(2,patientId);
										cstmt.setString(3,packageSeqNo);
										cstmt.setString(4,(String)dtls.get(0));
										cstmt.setInt(5,transDocRefLineNo);
										cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);				
										cstmt.execute();					
										str_error_level=cstmt.getString(6);
										str_sysmesage_id=cstmt.getString(7);					
										str_error_text=cstmt.getString(8);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process:"+str_error_level);
										System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
										System.out.println("str_error_text in process:"+str_error_text);*/
										cstmt.close();

										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											break;
										}
										else
										{
											insertable = true;						
										}
									}
									catch(Exception e)
									{
										System.out.println("Exception from updating "+i+" record in bl_encounter_payer_for_pkg :"+e);
									}
								}
							}
						}
					}	
				}
			}
			if(insertable)
				con.commit();
			else
				con.rollback();
		}
		catch (Exception e)
		{
			insertable=false;
			sys_err.append("Main Exception:"+e);
			System.out.println("Main Exception modify:"+e);
			e.printStackTrace();
		}
		finally
		{
			if (con != null) ConnectionManager.returnConnection(con, p);
		}
		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",str_error_level);
		return_mess.put("message",str_sysmesage_id);	

		return return_mess;	
	}//modify()
}
