/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.CashChequeHandOver;

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
*	name="CashChequeHandOver"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CashChequeHandOver"
*	local-jndi-name="CashChequeHandOver"
*	impl-class-name="eBL.CashChequeHandOver.CashChequeHandOverManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.CashChequeHandOver.CashChequeHandOverLocal"
*	remote-class="eBL.CashChequeHandOver.CashChequeHandOverRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.CashChequeHandOver.CashChequeHandOverLocalHome"
*	remote-class="eBL.CashChequeHandOver.CashChequeHandOverHome"
*	generate= "local,remote"
*
*
*/


public class CashChequeHandOverManager implements SessionBean {
	Connection con;

	CallableStatement cstmt = null;

	SessionContext ctx;

	boolean insertable = false;

	String locale = "";

	String encounterid = "";

	String errCode = "", sysMessgaeId="", errText="", gen_doc_type="",gen_doc_num="";
	StringBuffer sys_err = new StringBuffer("") ;

	String str_trx_doc_ref=""; int str_trx_doc_ref_line_no=0;
	String currdate="",client_ip_address="",user_id="",str_pgm_date="",str_doc_type_code="",str_doc_no="",str_error_level="",str_error_text="",str_sysmesage_id="";

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
		HashMap return_mess = new HashMap();		
		boolean insertable = false;
		String locale = "";	
		if(locale==null) locale="en";		
		//System.out.println("tabdata handover:"+tabdata);
		
	

		String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";

		String loginDateTime=(String)tabdata.get("loginDateTime");
		if(loginDateTime==null) loginDateTime="";

		String reqDateTime=(String)tabdata.get("reqDateTime");
		if(reqDateTime==null) reqDateTime="";

		String cashInHand=(String)tabdata.get("cashInHand");
		if(cashInHand==null) cashInHand="";

		String chequeInHand=(String)tabdata.get("chequeInHand");
		if(chequeInHand==null) chequeInHand="";

		String cashCounterCode=(String)tabdata.get("cashCounterCode");
		if(cashCounterCode==null) cashCounterCode="";

		String inUseBy=(String)tabdata.get("inUseBy");
		if(inUseBy==null) inUseBy="";

		String cashTotalAmt=(String)tabdata.get("tot_cash_amt");
		if(cashTotalAmt==null) cashTotalAmt="";

		String chequeTotalAmt=(String)tabdata.get("tot_chk_amt");
		if(chequeTotalAmt==null) chequeTotalAmt="";

		client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		String mode=(String)tabdata.get("mode");
		if(mode==null) mode="";

		String handoverrequestamt=(String)tabdata.get("handoverrequestamt");
		if(handoverrequestamt==null) handoverrequestamt="";

		if(handoverrequestamt.equals(""))
			handoverrequestamt=cashTotalAmt;

		 locale=(String)tabdata.get("locale");
		if(locale==null) locale="";

		String iuMode="";
		if(mode.equals("modify"))
		{
				iuMode="U";
		}else{
				iuMode="I";
		}
			
		
	
	try{
		con.setAutoCommit( false ) ;			
		insertable = true;		
		
		try{
			if(mode.equals("modify"))
			{				
			 if(insertable){
				String sqlhandedoverdel="{ call   bl_csh_chq_handover.proc_delete_all_recs(?,?,?,TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,?,?,?)}";
				//System.out.println("sqlhandedoverdel :"+sqlhandedoverdel);		
				cstmt = con.prepareCall(sqlhandedoverdel);
				cstmt.setString(1,facility_id);
				cstmt.setString(2,cashCounterCode);	
				cstmt.setString(3,inUseBy);

				cstmt.setString(4,loginDateTime);					
				cstmt.setString(5,reqDateTime);					
				cstmt.setString(6,client_ip_address);					
					
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				
				cstmt.execute();

				str_error_level=cstmt.getString(7);
				str_sysmesage_id=cstmt.getString(8);					
				str_error_text=cstmt.getString(9);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";

				//System.out.println("str_error_level in process:"+str_error_level);
				//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				//System.out.println("str_error_text in process:"+str_error_text);
				cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;						
					}
			}//insertable
			}//if
		}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling hdr.proc_delete_all_recs:"+e);
				System.out.println("Exception in proc_insert_bl_handed_reqt.proc_delete_all_recs Call:"+e);
			  }

		try{
			
			if(insertable){
				String sqlhandedoverreq="{ call   bl_csh_chq_handover.proc_insert_bl_handed_reqt(?,?,?,TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,?,?,?,?,?,?)}";
				//System.out.println("sqlhandedoverreq :"+sqlhandedoverreq);		
				cstmt = con.prepareCall(sqlhandedoverreq);
				cstmt.setString(1,facility_id);
				//System.out.println("sqlhandedoverreq :1.1" +cashCounterCode);		
				cstmt.setString(2,cashCounterCode);
				//System.out.println("sqlhandedoverreq :1"+inUseBy);		
				cstmt.setString(3,inUseBy);
				//System.out.println("sqlhandedoverreq :2"+loginDateTime);		
				cstmt.setString(4,loginDateTime);	
				//System.out.println("sqlhandedoverreq :3"+reqDateTime);
				
				cstmt.setString(5,reqDateTime);		
				//System.out.println("sqlhandedoverreq :4"+client_ip_address);	
				
				cstmt.setString(6,client_ip_address);		
				//System.out.println("sqlhandedoverreq :5"+handoverrequestamt);
				
				cstmt.setString(7,handoverrequestamt);		
				//System.out.println("sqlhandedoverreq :6"+chequeTotalAmt);	
				
				cstmt.setString(8,chequeTotalAmt);
				//System.out.println("sqlhandedoverreq :7");	

				cstmt.setString(9,iuMode);
				//System.out.println("sqlhandedoverreq :7"+iuMode);	
					
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				
				cstmt.execute();

				str_error_level=cstmt.getString(10);
				str_sysmesage_id=cstmt.getString(11);					
				str_error_text=cstmt.getString(12);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";

				//System.out.println("str_error_level in process:"+str_error_level);
				//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				//System.out.println("str_error_text in process:"+str_error_text);
				cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;						
					}
			}
		}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling hdr.proc_insert_bl_handed_reqt:"+e);
				System.out.println("Exception in proc_insert_bl_handed_reqt.proc_insert_bl_handed_reqt Call:"+e);
			  }
		try{
			String str_curr_deno="",str_curr_num="",str_curr_amt="";
			String str_chq_num="",str_chq_date="",str_bank_name="",str_payer_name="",str_patient_id="",str_chq_amount="";

			HashMap cashCollectionDtls=(HashMap)tabdata.get("CASH_COLL_DTLS_SER");
			HashMap chequeCollectionDtls=(HashMap)tabdata.get("CHEQUE_COLL_DTLS_SER");
		 
			ArrayList	cash_coll_dtls			=	new ArrayList();
			ArrayList	cheque_coll_dtls	    =	new ArrayList();
			ArrayList	curr_deno		=	new ArrayList();
			ArrayList	curr_num		=	new ArrayList();
			ArrayList	curr_amt		=	new ArrayList();
			ArrayList	chq_num			=	new ArrayList();
			ArrayList	chq_date		=	new ArrayList();
			ArrayList	bank_name	    =	new ArrayList();
			ArrayList	payer_name	    =	new ArrayList();
			ArrayList	patient_id	    =	new ArrayList();
			ArrayList	chq_amount		=	new ArrayList();
	try{		
	 if(insertable){	
		if(cashCollectionDtls.size()>0)
		{
			cash_coll_dtls					=(ArrayList)cashCollectionDtls.get("CASH_COLL_DTLS");
			//System.out.println("added for package billing cash_coll_dtls :"+cash_coll_dtls);
			if(cash_coll_dtls.size()>0)
			{
				curr_deno = (ArrayList)cash_coll_dtls.get(0);
				//System.out.println("added for package billing curr_deno :"+curr_deno);

				curr_num = (ArrayList)cash_coll_dtls.get(1);
				//System.out.println("added for package billing curr_num :"+curr_num);

				curr_amt = (ArrayList)cash_coll_dtls.get(2);
				//System.out.println("added for package billing curr_amt :"+curr_amt);
				
			}
		}

		int totRec_cash = 0;
		if(curr_deno.size() >0)
		totRec_cash = curr_deno.size();

		for(int i=0;i<totRec_cash;i++)
		{	
			str_curr_deno	=(String)curr_deno.get(i);
			//System.out.println("added for str_curr_deno billing str_curr_deno :"+str_curr_deno);
			str_curr_num	=(String)curr_num.get(i);
			//System.out.println("added for str_curr_num billing str_curr_num :"+str_curr_num);
			str_curr_amt	=(String)curr_amt.get(i);
			//System.out.println("added for str_curr_amt billing str_curr_amt :"+str_curr_amt);

			String sqlhandedovercashreq="{ call   bl_csh_chq_handover.proc_ins_bl_handed_cash_den(?,?,?,TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,?,?,?,?,?)}";
				//System.out.println("sqlhandedovercashreq :"+sqlhandedovercashreq);		
				//System.out.println("CONNECTION :"+con);		
				//System.out.println("CSMT :"+cstmt);		
				cstmt = con.prepareCall(sqlhandedovercashreq);
				//System.out.println("CSMT 111:"+cstmt);	
				cstmt.setString(1,facility_id);
				cstmt.setString(2,cashCounterCode);
				cstmt.setString(3,inUseBy);
				cstmt.setString(4,loginDateTime);		
				cstmt.setString(5,reqDateTime);		
				cstmt.setString(6,str_curr_deno);		
				cstmt.setString(7,str_curr_num);		
				cstmt.setString(8,client_ip_address);	

				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				
				cstmt.execute();

				str_error_level=cstmt.getString(9);
				str_sysmesage_id=cstmt.getString(10);					
				str_error_text=cstmt.getString(11);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";

				//System.out.println("str_error_level in process:"+str_error_level);
				//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				//System.out.println("str_error_text in process:"+str_error_text);
				cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;						
					}
		}//for loop

	 }//insertable
	}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling hdr.proc_ins_bl_handed_cash_den:"+e);
				System.out.println("Exception in proc_insert_bl_handed_reqt.proc_ins_bl_handed_cash_den Call:"+e);
			  }

	 try{		
		if(insertable){
			if(chequeCollectionDtls.size()>0)
			{
				cheque_coll_dtls					=(ArrayList)chequeCollectionDtls.get("CHEQUE_COLL_DTLS");
				//System.out.println("added for package billing cash_coll_dtls :"+cheque_coll_dtls);
				if(cheque_coll_dtls.size()>0)
				{
					chq_num = (ArrayList)cheque_coll_dtls.get(0);
					//System.out.println("added for package billing curr_deno :"+curr_deno);

					chq_date = (ArrayList)cheque_coll_dtls.get(1);
					//System.out.println("added for package billing curr_num :"+curr_num);

					bank_name = (ArrayList)cheque_coll_dtls.get(2);
					//System.out.println("added for chq_date billing bank_name :"+bank_name);

					payer_name = (ArrayList)cheque_coll_dtls.get(3);
					//System.out.println("added for payer_name billing payer_name :"+payer_name);

					patient_id = (ArrayList)cheque_coll_dtls.get(4);
					//System.out.println("added for patient_id billing v :"+patient_id);

					chq_amount = (ArrayList)cheque_coll_dtls.get(5);
					//System.out.println("added for chq_amount billing chq_amount :"+chq_amount);


					




					
				}
			}

			
			int totRec_chq = 0;
			if(chq_num.size() >0)
			totRec_chq = chq_num.size();
			for(int i=0;i<totRec_chq;i++)
			{	
				str_chq_num	=(String)chq_num.get(i);
				//System.out.println("added for str_curr_deno billing str_chq_num :"+str_chq_num);

				str_chq_date	=(String)chq_date.get(i);
				//System.out.println("added for str_curr_num billing str_chq_date :"+str_chq_date);

				str_chq_date = com.ehis.util.DateUtils.convertDate(str_chq_date,"DMY",locale,"en");
				//System.out.println("str_chq_date Called v ejb  conv:"+str_chq_date);

				

				str_bank_name	=(String)bank_name.get(i);
				//System.out.println("added for str_curr_amt billing str_bank_name :"+str_bank_name);

				str_payer_name	=(String)payer_name.get(i);
				//System.out.println("added for str_curr_amt billing str_payer_name :"+str_payer_name);

				str_patient_id	=(String)patient_id.get(i);
				//System.out.println("added for str_curr_amt billing str_patient_id :"+str_patient_id);

				str_chq_amount	=(String)chq_amount.get(i);
				//System.out.println("added for str_curr_amt billing str_chq_amount :"+str_chq_amount);


				String sqlhandedovercheqreq="{ call   bl_csh_chq_handover.proc_bl_handed_cheque_amt(?,?,?,TO_DATE(?,'DD/MM/YYYY hh24:mi:ss'),TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,?,?,?,?,?,?,?)}";
					//System.out.println("sqlhandedovercheqreq :"+sqlhandedovercheqreq);	
					//System.out.println("CONNECTION chq :"+con);		
				//System.out.println("CSMT chq:"+cstmt);	
					cstmt = con.prepareCall(sqlhandedovercheqreq);
					//System.out.println("CSMT bbcvbc chq:"+cstmt);	
					cstmt.setString(1,facility_id);
					cstmt.setString(2,cashCounterCode);
					cstmt.setString(3,inUseBy);
					cstmt.setString(4,loginDateTime);		
					cstmt.setString(5,reqDateTime);		
					cstmt.setString(6,str_chq_num);		
					cstmt.setString(7,str_chq_date);		
					cstmt.setString(8,str_bank_name);		
					cstmt.setString(9,str_payer_name);		
					cstmt.setString(10,str_patient_id);		
					cstmt.setString(11,str_chq_amount);		
					cstmt.setString(12,client_ip_address);	

					cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
					
					cstmt.execute();

					str_error_level=cstmt.getString(13);
					str_sysmesage_id=cstmt.getString(14);					
					str_error_text=cstmt.getString(15);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					//System.out.println("str_error_level in process:"+str_error_level);
					//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
					//System.out.println("str_error_text in process:"+str_error_text);

					cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;						
					}
			}//for loop
	
		

					
		}//insertable
	}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling hdr.proc_bl_handed_cheque_amt:"+e);
				System.out.println("Exception in proc_insert_bl_handed_reqt.proc_bl_handed_cheque_amt Call:"+e);
			  }
}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling cchandover.cchandover:"+e);
				System.out.println("Exception in cchandover.cchandover Call:"+e);
			  }

		
		if(insertable)
		{
			con.commit();
		}
		else
		{
			con.rollback();
		}
}catch (Exception e)
	 {
		insertable=false;
		sys_err.append("Main Exception:"+e);
		System.out.println("Main Exception:"+e);
	 }		
	finally 
	{
		//System.out.println("finally");
		if (con != null)
		ConnectionManager.returnConnection(con, p);
	}		
		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);	
		return return_mess;	
	}//insert()

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
		HashMap return_mess = new HashMap();		
		boolean insertable = false;
		String locale = "";	
		if(locale==null) locale="en";		
		//System.out.println("delete data handover:"+tabdata);

		String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";

		String loginDateTime=(String)tabdata.get("loginDateTime");
		if(loginDateTime==null) loginDateTime="";

		String reqDateTime=(String)tabdata.get("reqDateTime");
		if(reqDateTime==null) reqDateTime="";

		String cashInHand=(String)tabdata.get("cashInHand");
		if(cashInHand==null) cashInHand="";

		String chequeInHand=(String)tabdata.get("chequeInHand");
		if(chequeInHand==null) chequeInHand="";

		String cashCounterCode=(String)tabdata.get("cashCounterCode");
		if(cashCounterCode==null) cashCounterCode="";

		String inUseBy=(String)tabdata.get("inUseBy");
		if(inUseBy==null) inUseBy="";

		client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		 locale=(String)tabdata.get("locale");
		if(locale==null) locale="";
try{
			con.setAutoCommit( false ) ;
			insertable = true;	


try{
		if(insertable){
				String sqlhandedoverRemove="{ call   bl_csh_chq_handover.proc_cancel_request(?,?,?,TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss'),?,?,?,?)}";
				//System.out.println("sqlhandedoverRemove :"+sqlhandedoverRemove);		
				cstmt = con.prepareCall(sqlhandedoverRemove);
				cstmt.setString(1,facility_id);
				cstmt.setString(2,cashCounterCode);	
				cstmt.setString(3,inUseBy);

				cstmt.setString(4,loginDateTime);					
				cstmt.setString(5,reqDateTime);					
				cstmt.setString(6,client_ip_address);					
					
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				
				cstmt.execute();

				str_error_level=cstmt.getString(7);
				str_sysmesage_id=cstmt.getString(8);					
				str_error_text=cstmt.getString(9);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";

				//System.out.println("str_error_level in process:"+str_error_level);
				//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				//System.out.println("str_error_text in process:"+str_error_text);
				cstmt.close();

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;						
					}
			}//insertable

	}catch(Exception e)
			  {
				insertable=false;
				sys_err.append(" Exception while calling hdr.proc_cancel_request:"+e);
				System.out.println("Exception in proc_insert_bl_handed_reqt.proc_cancel_request Call:"+e);
			  }
	if(insertable)
		{
			con.commit();
		}
		else
		{
			con.rollback();
		}
}catch (Exception e)
	 {
		insertable=false;
		sys_err.append("Main Exception:"+e);
		System.out.println("Main Exception:"+e);
	 }		
	finally 
	{
		//System.out.println("finally");
		if (con != null)
		ConnectionManager.returnConnection(con, p);
	}		

		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);	
		return return_mess;	
	}

}
