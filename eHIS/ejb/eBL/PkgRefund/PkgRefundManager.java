/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.PkgRefund;

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
*	name="PkgRefund"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgRefund"
*	local-jndi-name="PkgRefund"
*	impl-class-name="eBL.PkgRefund.PkgRefundManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgRefund.PkgRefundLocal"
*	remote-class="eBL.PkgRefund.PkgRefundRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgRefund.PkgRefundLocalHome"
*	remote-class="eBL.PkgRefund.PkgRefundHome"
*	generate= "local,remote"
*
*
*/


public class PkgRefundManager implements SessionBean
{
	SessionContext ctx;
	boolean insertable = false;
	String locale = "";	
	Connection con;
	CallableStatement cstmt = null;


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

	public java.util.HashMap insert(java.util.Properties p,java.util.HashMap tabdata) 
	{		
	
		con = ConnectionManager.getConnection(p);
		//ResultSet rs			= null;	unused
		//Statement stmt				= null; unused
		HashMap return_mess = new HashMap();		
		Hashtable messageHashtable=new Hashtable();
		StringBuffer sb = new StringBuffer("") ;
		StringTokenizer msgIds;
		boolean insertable = false;
	
		String locale = "";		
		if(locale==null) locale="en";	
	//	String errCode = "", sysMessgaeId="", errText=""; unused
		StringBuffer sys_err = new StringBuffer("") ;
		String client_ip_address="",user_id="",str_error_level="",str_error_text="",str_sysmesage_id="";
		String p_trx_doc_ref="";
		String p_from_bill_doc_type="";
		String p_from_bill_doc_num="";
		String p_to_bill_doc_type="";
		String p_to_bill_doc_num="";
		String p_bill_mpi_id="";
		//System.out.println("tabdata:"+tabdata);	
		
		try{
			//	String totalRecords=(String)tabdata.get("totalRecords");
			//if(totalRecords==null) totalRecords="";
			//tot_rec=Integer.parseInt(totalRecords);
			con.setAutoCommit( false ) ;			
			insertable = true;	
			String facility_id = (String) tabdata.get("facility_id");
			if(facility_id==null) facility_id="";

			String patient_id=(String)tabdata.get("patient_id");
			if(patient_id==null) patient_id="";
			
			client_ip_address=(String)tabdata.get("client_ip_address");
			if(client_ip_address==null) client_ip_address="";
			
			user_id=(String)tabdata.get("login_user");
			if(user_id==null) user_id="";

			String pkg_code=(String)tabdata.get("pkg_code");
			if(pkg_code==null) pkg_code="";
		
			String pkg_desc=(String)tabdata.get("pkg_desc");
			if(pkg_desc==null) pkg_desc="";	
			
			String pkg_seq_no=(String)tabdata.get("pkg_seq_no");
			if(pkg_seq_no==null) pkg_seq_no="";
			
			ArrayList pkg_srv_dtls=(ArrayList)tabdata.get("pkg_srv_dtls");

			HashMap excl_srv_dtls=(HashMap)tabdata.get("excl_srv_dtls");
			
			String  pkg_serv_ind="";
			String  pkg_serv_code="";
			String  pkg_serv_desc="";
			String  order_catalog_code="";
			//String  rate_ind=""; unsued
			//String  factor_rate=""; unused
			String  refund_yn="";
			String  refund_rate="";
			String  utilized_serv_qty="";
			String  utilized_serv_amt="";
				String available_amt="0";
			String  refunded="";
			String  refunded_amount="";
			String  refund_amt="";
			String  refund_serv="";
			String[] record;
			
			String sqlBlPkgRefund="";

			
			sqlBlPkgRefund="{call   blpkgrefund.post_refund_dtls(?,?,?,sysdate,?,?,?,?,?,?,?,?,?)}";
			cstmt = con.prepareCall(sqlBlPkgRefund);	
			
		
	/*System.out.println("facility_id="+facility_id);
	System.out.println("client_ip_address="+client_ip_address);
	System.out.println("user_id="+user_id);
	System.out.println("pkg_seq_no="+pkg_seq_no);
	System.out.println("pkg_code="+pkg_code);*/
			if(pkg_srv_dtls!=null && pkg_srv_dtls.size()>0){
				for(int i=0;i<pkg_srv_dtls.size();i++)
				{
					record=(String[])pkg_srv_dtls.get(i);
					pkg_serv_ind=record[0];
					pkg_serv_code=record[1];
					pkg_serv_desc=record[2];
					order_catalog_code=record[3];					
					refund_yn=record[4];
					refund_rate=record[5];
					utilized_serv_qty=record[6];
					utilized_serv_amt=record[7];
					available_amt=record[8];
					refund_amt=record[9];
					refunded=record[10];
					refunded_amount=record[11];				
					refund_serv=record[12];
				/*	System.out.println("pkg_serv_ind="+pkg_serv_ind);
					System.out.println("pkg_serv_code="+pkg_serv_code);
					System.out.println("refund_amt="+refund_amt);
					System.out.println("refund_serv="+refund_serv);
							System.out.println("refunded="+refunded);
							System.out.println("refunded_amount="+refunded_amount);*/
					if(refunded==null) refunded="N";
					if(refund_serv==null) refund_serv="N";
					if(refund_rate==null) refund_rate="";
					if(refund_amt==null) refund_amt="0";
					if(available_amt==null) available_amt="0";
					if(refunded_amount==null) refunded_amount="0";
					if(insertable && !refunded.equals("Y") &&  refund_serv.equals("Y")){					
											
						cstmt.setString(1,facility_id);
						cstmt.setString(2,client_ip_address);
						cstmt.setString(3,user_id);
						cstmt.setString(4,pkg_seq_no);		
						cstmt.setString(5,pkg_code);							
						cstmt.setString(6,pkg_serv_code);							
						cstmt.setString(7,refund_rate);							
						cstmt.setString(8,refund_amt);							
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);				
						
						cstmt.execute();					
						p_trx_doc_ref=cstmt.getString(9);
						str_error_level=cstmt.getString(10);
						str_sysmesage_id=cstmt.getString(11);					
						str_error_text=cstmt.getString(12);
						
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(p_trx_doc_ref==null) p_trx_doc_ref="";
						/*System.out.println("p_trx_doc_ref ="+p_trx_doc_ref);
						System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
						System.out.println("str_error_level in process:"+str_error_level);
						System.out.println("str_error_text in process:"+str_error_text);*/						
						
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insertable=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
							//	System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");													
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{								
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}	
					}					
				}
			}
			
			ArrayList excl_srv=new ArrayList();
			String excl_serv_ind="";
			String excl_serv_code="";
			String excl_serv_desc="";
			
			String exclude_yn="";
			Set<String> excl_srv_set=(Set<String>)excl_srv_dtls.keySet();
		//	System.out.println("excl_srv_set="+excl_srv_set.toString());
			Iterator<String> excl_srv_it=excl_srv_set.iterator();
			String mapKey="";
			while(insertable && excl_srv_it.hasNext()){
				mapKey=excl_srv_it.next();			
				excl_srv=(ArrayList)excl_srv_dtls.get(mapKey);	
				if(insertable && excl_srv!=null && excl_srv.size()>0){
					for(int i=0;i<excl_srv.size();i++)
					{
						record=(String[])excl_srv.get(i);
						excl_serv_ind=record[0];
						excl_serv_code=record[1];
						excl_serv_desc=record[2];
						exclude_yn=record[3];
						refund_yn=record[4];
						refund_rate=record[5];
						utilized_serv_qty=record[6];
						utilized_serv_amt	=record[7];
						available_amt	=record[8];
						refund_amt=record[9];
						refunded=record[10];
						refunded_amount=record[11];
						refund_serv=record[12];
				/*	System.out.println("excl_serv_ind="+excl_serv_ind);
					System.out.println("excl_serv_code="+excl_serv_code);
					System.out.println("refund_amt="+refund_amt);
					System.out.println("refund_serv="+refund_serv);
					System.out.println("refunded="+refunded);
					System.out.println("refunded_amount="+refunded_amount);*/
					if(refunded==null) refunded="N";
					if(refunded_amount==null) refunded_amount="0";
					if(refund_serv==null) refund_serv="N";
					if(refund_rate==null) refund_rate="";
					if(refund_amt==null) refund_amt="0";
					if(available_amt==null) available_amt="0";
					if(insertable && !refunded.equals("Y") &&  refund_serv.equals("Y")){		
									
						cstmt.setString(1,facility_id);
						cstmt.setString(2,client_ip_address);
						cstmt.setString(3,user_id);
						cstmt.setString(4,pkg_seq_no);		
						cstmt.setString(5,pkg_code);							
						cstmt.setString(6,excl_serv_code);							
						cstmt.setString(7,refund_rate);							
						cstmt.setString(8,refund_amt);							
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);				
							
						cstmt.execute();					
							
						p_trx_doc_ref=cstmt.getString(9);
						str_error_level=cstmt.getString(10);
						str_sysmesage_id=cstmt.getString(11);					
						str_error_text=cstmt.getString(12);
						
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(p_trx_doc_ref==null) p_trx_doc_ref="";
						/*System.out.println("p_trx_doc_ref ="+p_trx_doc_ref);
						System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
						System.out.println("str_error_level in process:"+str_error_level);
						System.out.println("str_error_text in process:"+str_error_text);*/						
						
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insertable=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");													
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{								
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
					}
				}
			}
		}
			// need commit here?
		if(cstmt!=null)		
			cstmt.close();	
		if(insertable){
			sqlBlPkgRefund="{call  blpkgrefund.generate_bill (?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = con.prepareCall(sqlBlPkgRefund);						
			cstmt.setString(1,facility_id);
			cstmt.setString(2,client_ip_address);
			cstmt.setString(3,user_id);
			cstmt.setString(4,pkg_seq_no);		
			cstmt.setString(5,pkg_code);									
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);				
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);				
			cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);				
			cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);				
			cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);				
							
			cstmt.execute();					
			p_from_bill_doc_type=cstmt.getString(6);
			p_from_bill_doc_num=cstmt.getString(7);
			p_to_bill_doc_type=cstmt.getString(8);
			p_to_bill_doc_num=cstmt.getString(9);
			p_bill_mpi_id=cstmt.getString(9);
			str_error_level=cstmt.getString(10);					
			str_sysmesage_id=cstmt.getString(11);					
			str_error_text=cstmt.getString(13);
				
			if(str_error_level==null) str_error_level="";
			if(str_sysmesage_id==null) str_sysmesage_id="";
			if(str_error_text==null) str_error_text="";
			if(p_from_bill_doc_type==null) p_from_bill_doc_type="";
			if(p_from_bill_doc_num==null) p_from_bill_doc_num="";
			if(p_to_bill_doc_type==null) p_to_bill_doc_type="";
			if(p_to_bill_doc_num==null) p_to_bill_doc_num="";
			if(p_bill_mpi_id==null) p_bill_mpi_id="";
		/*	System.out.println("p_from_bill_doc_type ="+p_from_bill_doc_type);
			System.out.println("p_from_bill_doc_num ="+p_from_bill_doc_num);
			System.out.println("p_to_bill_doc_type ="+p_to_bill_doc_type);
			System.out.println("p_to_bill_doc_num ="+p_to_bill_doc_num);
			System.out.println("p_bill_mpi_id ="+p_bill_mpi_id);
			System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
			System.out.println("str_error_level in process:"+str_error_level);
			System.out.println("str_error_text in process:"+str_error_text);	*/					
				
			if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
			{
				insertable=false;
				sb.append("<br>"+str_error_text+"<br> ") ;
			}
			if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
			{
				insertable=false;
				if((str_error_level.equals("10") && !str_error_text.equals("") ))
				{
					sb.append("<br>"+str_error_text+"<br> ") ;
					//System.out.println("sb mesage in Error is:"+sb);
				}
				else
				{
					if(str_sysmesage_id.indexOf("|") != (-1)){
						msgIds=new StringTokenizer(str_sysmesage_id,"|");
						while(msgIds.hasMoreTokens())
						{
							messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
							sb.append((String)messageHashtable.get("message")+"<br>");													
						}
					//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
					}else{								
						messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
						sb.append((String)messageHashtable.get("message"));
						//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
					}
				}
			}
			if(cstmt!=null)		
			cstmt.close();
		}		
		if(insertable )
		{
				//System.out.println("herer");
				con.commit();
		}
		else
		{
			con.rollback();
		}
		
	}
	catch (Exception e)
	 {
		insertable=false;
		sys_err.append("Main Exception:"+e);
		//System.out.println("Exception in PkgRefunManager.java:"+e);
			e.printStackTrace();
	 }		
	finally 
	{
		//System.out.println("finally");		
		if (con != null)
		ConnectionManager.returnConnection(con, p);
	}		
	/*System.out.println("insertable="+insertable);
	System.out.println("p_from_bill_doc_type ="+p_from_bill_doc_type);
	System.out.println("p_from_bill_doc_num ="+p_from_bill_doc_num);
	System.out.println("p_to_bill_doc_type ="+p_to_bill_doc_type);
	System.out.println("p_to_bill_doc_num ="+p_to_bill_doc_num);
	System.out.println("p_bill_mpi_id ="+p_bill_mpi_id);			
	System.out.println("sb.toString():"+sb.toString());*/
							
			
	return_mess.put("p_from_bill_doc_type",p_from_bill_doc_type);
	return_mess.put("p_from_bill_doc_num",p_from_bill_doc_num);
	return_mess.put("p_to_bill_doc_type",p_to_bill_doc_type);
	return_mess.put("p_to_bill_doc_num",p_to_bill_doc_num);
	return_mess.put("status",new Boolean(insertable));
	return_mess.put("error",sb.toString());
	return_mess.put("sys_error",sys_err.toString());
	//return_mess.put("message",str_sysmesage_id);	
	return return_mess;	
		
	}//insert()



	
}
