
	package eBL.EnterReceiptRefund;

	import java.sql.*;
	import javax.naming.*;
	import javax.rmi.*;
	import java.rmi.RemoteException;
	import javax.ejb.*;
	import eBL.BLEstimateDepositBean;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.StringTokenizer;
	import java.lang.*;
	import java.io.* ;
	import java.util.*;
	import webbeans.eCommon.*;
	import java.text.SimpleDateFormat;

	/**
	*
	* @ejb.bean
	*	name="EnterReceiptRefund"
	*	type="Stateless"
	*	transaction-type="Bean"
	*	view-type="both"
	*	jndi-name="EnterReceiptRefund"
	*	local-jndi-name="EnterReceiptRefund"
	*	impl-class-name="eBL.EnterReceiptRefund.EnterReceiptRefundManager"
	*	
	*
	* @ejb.interface
	*	extends="javax.ejb.EJBObject"
	*	local-extends="javax.ejb.EJBLocalObject" 
	*	local-class="eBL.EnterReceiptRefund.EnterReceiptRefundLocal"
	*	remote-class="eBL.EnterReceiptRefund.EnterReceiptRefundRemote"
	*	generate= "local,remote"
	*
	* @ejb.home
	*	extends="javax.ejb.EJBHome" 
	*	local-extends="javax.ejb.EJBLocalHome"
	*	local-class="eBL.EnterReceiptRefund.EnterReceiptRefundLocalHome"
	*	remote-class="eBL.EnterReceiptRefund.EnterReceiptRefundHome"
	*	generate= "local,remote"
	*
	*
	*/


	public class EnterReceiptRefundManager implements SessionBean {
		Connection con;

		CallableStatement cstmt = null;

		SessionContext ctx;

		boolean insertable = false;

		String locale = "";

		String encounterid = "";

		String errCode = "", sysMessgaeId="", errText="", gen_doc_type="",gen_doc_num="";
		StringBuffer sys_err = new StringBuffer("") ;

		String str_trx_doc_ref=""; int str_trx_doc_ref_line_no=0;
		String str_cash_counter="",str_shift_id="",str_session_id="",str_pgm_date="",str_doc_type_code="",str_doc_no="",str_error_level="",str_error_text="",str_sysmesage_id="",final_msg_doc_type_code="";
		//Added by muthu on 25-7-12 Receipt
		String rec_print_format_enabled_yn = "";
		String str_rec_prt_format_vals = "";
		String gen_prt_format ="";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		//Added by muthu on 25-7-12 Receipt
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
		private String replaceNull(String input){
			if(input == null || "null".equals(input)){
				input = "";
			}
			return input;
		}
		/**
		* @ejb.interface-method
		*	 view-type="both"
		*/
		public java.util.HashMap insertDepositData(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals) 
		{
			
			con = ConnectionManager.getConnection(p);
			//con.setAutoCommit( false ) ;

			HashMap return_mess = new HashMap();
			final_msg_doc_type_code="";
			
			//HashMap multi_slmt_val=mult_slmt_vals;
			//HashMap indi_slmt_val = new HashMap();
			
			//StringTokenizer st = null;
			boolean insertable = false;
		//	String error="";
			String locale = "";
			String sys_warning = "";

			locale = (String) support_data.get("locale");
			if(locale==null) locale="en";

	//		java.util.Locale loc = new java.util.Locale(locale);

			//java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);

			//String hosp_chrg_leg = bl_labels.getString("eBL.PLS_NOTE_TRX_REF_NO.label");

			String total_settled_amt=(String) support_data.get("total_settled_amt");
			if(total_settled_amt==null) total_settled_amt="";
			

			String facility_id = (String) support_data.get("facility_id");
			if(facility_id==null) facility_id="";
			
			String customercode = (String) support_data.get("customercode");
			if(customercode==null) customercode="";

			
			String patient_id=(String)support_data.get("patient_id");
			if(patient_id==null) patient_id="";

			
			String visit_id=replaceNull((String)support_data.get("visit_id"));
			//String strVisit_id = replaceNull(request.getParameter("visit_id"));	
			
			//if(visit_id==null) visit_id="";

			String episode_id=replaceNull((String)support_data.get("episode_id"));
			//if(episode_id==null) episode_id="";
			System.out.println("episode id="+episode_id);
			
			String episode_type=(String)support_data.get("episode_type");
			if(episode_type==null) episode_type="";

			String encounter_id=replaceNull((String)support_data.get("encounter_id"));
			if(encounter_id==null) encounter_id="";

			String rcpt_rfnd_ind=(String)support_data.get("rcpt_rfnd_ind");
			if(rcpt_rfnd_ind==null) rcpt_rfnd_ind="";
			String rcpt_nature_code=(String)support_data.get("rcpt_nature_code");
			if(rcpt_nature_code==null) rcpt_nature_code="";

			String cash_counter_code=(String)support_data.get("cash_counter_code");
			if(cash_counter_code==null) cash_counter_code="";

			String shift_id=(String)support_data.get("shift_id");
			if(shift_id==null) shift_id="";
			
			String doc_amt=(String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="";

			String narration=(String)support_data.get("narration");
			if(narration==null) narration="";

			String ip_adm_trf_dep_ind=(String)support_data.get("ip_adm_trf_dep_ind");
			if(ip_adm_trf_dep_ind==null) ip_adm_trf_dep_ind="";

			String rec_ref_format_ind=(String)support_data.get("rec_ref_format_ind");
			if(rec_ref_format_ind==null) rec_ref_format_ind="";

			String rfnd_dep_in_use_yn=(String)support_data.get("rfnd_dep_in_use_yn");
			if(rfnd_dep_in_use_yn==null) rfnd_dep_in_use_yn="";

			String pmnt_thru_mail=(String)support_data.get("pmnt_thru_mail");
			if(pmnt_thru_mail==null) pmnt_thru_mail="";

			String ext_acc_facility_id=(String)support_data.get("ext_acc_facility_id");
			if(ext_acc_facility_id==null) ext_acc_facility_id="";
					
			String ext_acc_code=(String)support_data.get("ext_acc_code");
			if(ext_acc_code==null) ext_acc_code="";

			String refnumber=(String)support_data.get("refnumber");
			if(refnumber==null) refnumber="";
			System.out.println("refnumber"+refnumber);
			
			String ext_acc_dept_code=(String)support_data.get("ext_acc_dept_code");
			if(ext_acc_dept_code==null) ext_acc_dept_code="";

			String mult_slmt_yn=(String)support_data.get("mult_slmt_yn");
			if(mult_slmt_yn==null) mult_slmt_yn="";

			String downtime_entry_yn=(String)support_data.get("downtime_entry_yn");
			if(downtime_entry_yn==null) downtime_entry_yn="";

			String downtime_reason_code=(String)support_data.get("downtime_reason_code");
			if(downtime_reason_code==null) downtime_reason_code="";

			String downtime_doc_type_code=(String)support_data.get("downtime_doc_type_code");
			if(downtime_doc_type_code==null) downtime_doc_type_code="";

			String downtime_doc_num=(String)support_data.get("downtime_doc_num");
			if(downtime_doc_num==null) downtime_doc_num="";

			String downtime_doc_date=(String)support_data.get("downtime_doc_date");
			if(downtime_doc_date==null) downtime_doc_date="";

			String downtime_reason=(String)support_data.get("downtime_reason");
			if(downtime_reason==null) downtime_reason="";

			String cc_machine_id=(String)support_data.get("cc_machine_id");
			if(cc_machine_id==null) cc_machine_id="";
			System.out.println("cc_machine_id");

			String payers_add1=(String)support_data.get("payers_add1");
			if(payers_add1==null) payers_add1="";
			String payers_add2=(String)support_data.get("payers_add2");
			if(payers_add2==null) payers_add2="";

			String payers_add3=(String)support_data.get("payers_add3");
			if(payers_add3==null) payers_add3="";

			String payers_tel_num=(String)support_data.get("payers_tel_num");
			if(payers_tel_num==null) payers_tel_num="";
			
			String consolidated_receipt_yn=(String)support_data.get("consolidated_receipt_yn");
			if(consolidated_receipt_yn==null) consolidated_receipt_yn="";
			
			String user_id = (String)support_data.get("user_id");
			if(user_id==null) user_id="";
			
			String client_ip_address = (String)support_data.get("client_ip_address");
			if(client_ip_address==null) client_ip_address="";

			String rcpt_type_code = (String)support_data.get("rcpt_type_code");
			if(rcpt_type_code==null) rcpt_type_code="";
			
			String requestid=(String)support_data.get("requestid");
			if(requestid==null) requestid="";
			
			
			String orgdoctypecode=replaceNull((String)support_data.get("orgdoctypecode"));
			if(orgdoctypecode==null) orgdoctypecode="";
			
			
			
			String orgdocnum=replaceNull((String)support_data.get("orgdocnum"));
			if(orgdocnum==null) orgdocnum="";
			
			
			String orgdocsrno=replaceNull((String)support_data.get("orgdocsrno"));
			if(orgdocsrno==null) orgdocsrno="";
			
			
			System.out.println("orgdoctypecode / orgdocnum / orgdocsrno ::"+orgdoctypecode+"/" +orgdocnum+"/"+orgdocsrno);  
			
			String splAgnDpstYN=(String)support_data.get("splAgnDpstYN");
			if(splAgnDpstYN==null) splAgnDpstYN="";
			
			String splAgnDepEffFrom=(String)support_data.get("splAgnDepEffFrom");
			if(splAgnDepEffFrom==null) splAgnDepEffFrom="";
			
			String splAgnDepEffTo=(String)support_data.get("splAgnDepEffTo");
			if(splAgnDepEffTo==null) splAgnDepEffTo="";
			
			System.out.println("splAgnDpstYN / splAgnDepEffFrom / splAgnDepEffTo :: "+splAgnDpstYN+" / "+splAgnDepEffFrom+" / "+splAgnDepEffTo );

			String currdate = (String)support_data.get("currdate");
			System.out.println("Currdate"+currdate);
			
			String str_tot_rec = (String)support_data.get("str_tot_rec");
			if(str_tot_rec==null) str_tot_rec="0";
			
			String str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = (String)support_data.get("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd==null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";			

			String hand_without_counter_chk_out = (String)support_data.get("hand_without_counter_chk_out");
			if(hand_without_counter_chk_out==null) hand_without_counter_chk_out="";			
			
			BLEstimateDepositBean depositbean=(BLEstimateDepositBean)support_data.get("depositbean"); 
			 
			
			String str_doc_amt="";
	/*******************ADDEDD FOR PACKAGE BILLING**********************/	
			String pkgSeqNo = (String)support_data.get("pkgSeqNo");
			if(pkgSeqNo==null) pkgSeqNo="";	
	/*********************END*****************************************/
			//Added for MMS SCF 501.1
			String pkgSequenceNumber = (String)support_data.get("pkgSequenceNumber");
			if(pkgSequenceNumber==null) pkgSequenceNumber="";	
			String pkgSequenceAmount = (String)support_data.get("pkgSequenceAmount");
			if(pkgSequenceAmount==null) pkgSequenceAmount="";	
			if(!"".equals(pkgSequenceNumber)){
				String strSeqAmt = "";
				StringTokenizer seqArr = new StringTokenizer(pkgSequenceNumber,"^");
				StringTokenizer amtArr = new StringTokenizer(pkgSequenceAmount,"^");
				while(seqArr.hasMoreTokens()){
					strSeqAmt += "|"+seqArr.nextToken()+"^"+amtArr.nextToken()+"^N";				
				}
				strSeqAmt += "|";
				narration = narration+":::"+strSeqAmt;
			}
			//Added for MMS SCF 501.1

			int tot_rec=Integer.parseInt(str_tot_rec);
	//		String doc_amt_limt="",
			//String doc_type_code_limt="";
			String str_sysmesage_id_limit="";
			
			
		try
		{
			con.setAutoCommit( false ) ;
			
				
		/*	try
			{
				
				List<BLEstimateDepositBean> depositlist1 = depositbean.getDepositList();
				//depositbean.getDepositList(depositlist);
				
				for (Iterator iterator = depositlist1.iterator(); iterator.hasNext();)
				{
					
				depositbean = (BLEstimateDepositBean) iterator.next();
				System.out.println("service code ejb="+depositbean.getService_code());
				System.out.println("charges ejb="+depositbean.getCharges());
				System.out.println("qty ejb="+depositbean.getQty());
				System.out.println("Rc ejb="+depositbean.getRate_charge());
				System.out.println("base rate ejb="+depositbean.getBase_rate());
				System.out.println("base qty ejb="+depositbean.getBase_qty());
				System.out.println("day type ejb="+depositbean.getDay_type());
				System.out.println("time type ejb="+depositbean.getTime_type());
				
				}
			}catch(Exception e)
			{
				System.out.println("Exception in BLEstimatedepositBean"+e);
			}*/
			
			
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y"))
				{
				System.out.println("if ejb");
				try{

				ArrayList rtn_str_slmt_doc_amt=new ArrayList();
				ArrayList rtn_str_slmt_type_code=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_desc=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_date=new ArrayList();
				ArrayList rtn_str_slmt_doc_remarks=new ArrayList();
				ArrayList rtn_str_app_ref_no=new ArrayList();
				ArrayList rtn_str_cash_slmt_flag=new ArrayList();
				ArrayList rtn_str_cc_batch_no=new ArrayList();
				ArrayList rtn_str_cc_sale_draft_no=new ArrayList();
				ArrayList rtn_str_cc_swipped_yn=new ArrayList();
				ArrayList rtn_str_bank_code=new ArrayList();
				ArrayList rtn_str_bank_branch=new ArrayList();
				ArrayList rtn_str_cash_amt_given=new ArrayList();
				ArrayList rtn_str_cash_amt_return=new ArrayList();
				ArrayList rtn_str_payer_name=new ArrayList();
				ArrayList rtn_str_rcpt_rfnd_id_no=new ArrayList();
				ArrayList rtn_str_nominee_name=new ArrayList();
				ArrayList rtn_str_doc_sr_no=new ArrayList();

					 rtn_str_slmt_doc_amt = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
					//if(rtn_str_slmt_doc_amt==null) rtn_str_slmt_doc_amt="";
					

					rtn_str_slmt_type_code = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_type_code");
					//if(rtn_str_slmt_type_code==null) rtn_str_slmt_type_code="";

					 rtn_str_slmt_doc_ref_date = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
				//	if(rtn_str_slmt_doc_ref_date==null) rtn_str_slmt_doc_ref_date="";


					 rtn_str_slmt_doc_ref_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
				//	if(rtn_str_slmt_doc_ref_desc==null) rtn_str_slmt_doc_ref_desc="";


					 rtn_str_slmt_doc_remarks = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
				//	if(rtn_str_slmt_doc_remarks==null) rtn_str_slmt_doc_remarks="";


					 rtn_str_app_ref_no = (ArrayList)mult_slmt_vals.get("rtn_str_app_ref_no");
				//	if(rtn_str_app_ref_no==null) rtn_str_app_ref_no="";


					 rtn_str_cash_slmt_flag = (ArrayList)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
				//	if(rtn_str_cash_slmt_flag==null) rtn_str_cash_slmt_flag="";

					 rtn_str_cc_batch_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_batch_no");
				//	if(rtn_str_cc_batch_no==null) rtn_str_cc_batch_no="";


					 rtn_str_cc_sale_draft_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");
				//	if(rtn_str_cc_sale_draft_no==null) rtn_str_cc_sale_draft_no="";

					 rtn_str_cc_swipped_yn = (ArrayList)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
				//	if(rtn_str_cc_swipped_yn==null) rtn_str_cc_swipped_yn="";


					 rtn_str_bank_code = (ArrayList)mult_slmt_vals.get("rtn_str_bank_code");
				//	if(rtn_str_bank_code==null) rtn_str_bank_code="";


					 rtn_str_bank_branch = (ArrayList)mult_slmt_vals.get("rtn_str_bank_branch");
				//	if(rtn_str_bank_branch==null) rtn_str_bank_branch="";


					 rtn_str_cash_amt_given = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_given");
				//	if(rtn_str_cash_amt_given==null) rtn_str_cash_amt_given="";


					 rtn_str_cash_amt_return = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_return");
				//	if(rtn_str_cash_amt_return==null) rtn_str_cash_amt_return="";


					 rtn_str_payer_name = (ArrayList)mult_slmt_vals.get("rtn_str_payer_name");
				//	if(rtn_str_payer_name==null) rtn_str_payer_name="";


					 rtn_str_rcpt_rfnd_id_no = (ArrayList)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
				//	if(rtn_str_rcpt_rfnd_id_no==null) rtn_str_rcpt_rfnd_id_no="";


					 rtn_str_nominee_name = (ArrayList)mult_slmt_vals.get("rtn_str_nominee_name");
				//	if(rtn_str_nominee_name==null) rtn_str_nominee_name="";

					 rtn_str_doc_sr_no = (ArrayList)mult_slmt_vals.get("rtn_str_doc_sr_no");
				//	if(rtn_str_doc_sr_no==null) rtn_str_doc_sr_no="";
					insertable = true;
				/**************added for CRF-13**************************/
				
			try{
				
				if(hand_without_counter_chk_out.equals("Y")){			
					String str_rcpt_doc_amt="",arr_str_rcpt_doc_amt="",arr_str_slmt_type_code="",str_slmt_type_code="";
					for(int i=0;i<tot_rec;i++)
					{
						arr_str_rcpt_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
						str_rcpt_doc_amt=str_rcpt_doc_amt+arr_str_rcpt_doc_amt;	
						
						arr_str_slmt_type_code=(String)rtn_str_slmt_type_code.get(i);
						str_slmt_type_code=str_slmt_type_code+arr_str_slmt_type_code;	
					}
				
					str_rcpt_doc_amt=str_rcpt_doc_amt.replace("|","~");
					str_slmt_type_code=str_slmt_type_code.replace("|","~");
					

					if(insertable)
					{
						 str_rcpt_doc_amt = str_rcpt_doc_amt.replace("|","~");
						 str_slmt_type_code = str_slmt_type_code.replace("|","~");

						cstmt = con.prepareCall("{ call IBAEHIS.bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,user_id);
						cstmt.setString(3,cash_counter_code);
						cstmt.setString(4,str_slmt_type_code);
						cstmt.setString(5,str_rcpt_doc_amt);					

						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
								
						str_error_level		 = cstmt.getString(6);		
						str_sysmesage_id	 = cstmt.getString(7);		
						str_error_text     	 = cstmt.getString(8);				
						
						if ( str_error_level  == null ) str_error_level = "";
						if ( str_sysmesage_id == null ) str_sysmesage_id ="";
						if ( str_error_text	  == null ) str_error_text ="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if(str_error_level.equals("10") && (!str_error_text.equals("")))
						{
							insertable = false;
						}
							if(!str_sysmesage_id.equals(""))
							{
								if(	str_sysmesage_id.equals("BL7340")){
									str_sysmesage_id_limit="BL7340";
									insertable = true;
								}else{
									str_sysmesage_id_limit="";
									insertable = false;
									}
						
							}

						
					}
				}//insertable
				}//if
				}catch(Exception ee)
					{
						insertable=false;
					sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
					System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);;
					ee.printStackTrace();
					}
			/*************End*******************************************/		

					for(int i=0;i<tot_rec;i++)
					{
					


					 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
					 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);


					if(insertable)
					{
						System.out.println("ejb if 1st");
						String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
						str_tot_rec="1";
						//String downtime_slmt_yn="";

						//debetor_catagory_code=episode_type
						//String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+str_doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no.get(i)+"','"+rtn_str_slmt_doc_amt.get(i)+"','"+rtn_str_slmt_type_code.get(i)+"','"+rtn_str_slmt_doc_ref_desc.get(i)+"','"+rtn_str_slmt_doc_ref_date.get(i)+"','"+rtn_str_slmt_doc_remarks.get(i)+"','"+rtn_str_app_ref_no.get(i)+"','"+rtn_str_cash_slmt_flag.get(i)+"','"+rtn_str_cc_batch_no.get(i)+"','"+rtn_str_cc_sale_draft_no.get(i)+"','"+rtn_str_cc_swipped_yn.get(i)+"','"+rtn_str_bank_code.get(i)+"','"+rtn_str_bank_branch.get(i)+"','"+rtn_str_cash_amt_given.get(i)+"','"+rtn_str_cash_amt_return.get(i)+"','"+rtn_str_payer_name.get(i)+"','"+rtn_str_rcpt_rfnd_id_no.get(i)+"','"+rtn_str_nominee_name.get(i)+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?)}";
						//Below query is changed by muthu on 25-7-12 against 33868 - Receipt Print
						try
						{
						cstmt=con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.bl_proc_validate_main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,episode_type);
						cstmt.setString(3,patient_id);
						cstmt.setString(4,episode_id);	
						cstmt.setString(5,visit_id);
						cstmt.setString(6,downtime_entry_yn);
						cstmt.setString(7,downtime_doc_type_code);
						cstmt.setString(8,downtime_doc_num);	
						if((downtime_doc_date == null) || ("".equals(downtime_doc_date))){
							cstmt.setString(9, null);
							}
						else{
							cstmt.setDate(9, new java.sql.Date(sdf1.parse(downtime_doc_date).getTime()));
							}
						
						//cstmt.setString(9,downtime_doc_date);
						cstmt.setString(10,downtime_reason_code);
						cstmt.setString(11,rcpt_rfnd_ind);
						cstmt.setString(12,rcpt_nature_code);	
						cstmt.setString(13,rcpt_type_code);
						cstmt.setString(14,orgdoctypecode);
						cstmt.setString(15,orgdocnum);
						cstmt.setString(16,orgdocsrno);	
						cstmt.setString(17,doc_amt);
						cstmt.setString(18,total_settled_amt);
						cstmt.setString(19,null);
						cstmt.setString(20,refnumber);				
						cstmt.setString(21,user_id);
						cstmt.setString(22,client_ip_address);
						cstmt.setString(23,locale);
						cstmt.setString(24,null);	
						cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);					
				
						cstmt.execute();
						str_error_level=cstmt.getString(25);
						str_sysmesage_id=cstmt.getString(26);					
						str_error_text=cstmt.getString(27);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						System.out.println("validation error id check "+str_sysmesage_id);
						System.out.println("validation error text chceck"+str_error_text);
						cstmt.close();
						}
						catch(Exception e)
						{
							insertable=false;
							System.out.println("Exception in bl_proc_receipt_refund_main.bl_proc_validate_main 1"+e);
							e.printStackTrace();
						}
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}

						else
						{
						
							try
							{
								try
								{
								cstmt=con.prepareCall("{call IBAEHIS.bl_insert_deposit.global_assign_values(?)}");
								cstmt.setString(1,refnumber);
								cstmt.execute();
								}catch(Exception e)
								{
									System.out.println("EXception in procedure bl_insert_deposit.global_assign_values"+e);
									e.printStackTrace();
								}
								finally
								{
									cstmt.close();
								}
								
							String sqldoctype="{ call    IBAEHIS.BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+str_doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"',TO_DATE('"+downtime_doc_date+"','DD/MM/YYYY HH24:MI:SS'),'"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no.get(i)+"','"+rtn_str_slmt_doc_amt.get(i)+"','"+rtn_str_slmt_type_code.get(i)+"','"+rtn_str_slmt_doc_ref_desc.get(i)+"','"+rtn_str_slmt_doc_ref_date.get(i)+"','"+rtn_str_slmt_doc_remarks.get(i)+"','"+rtn_str_app_ref_no.get(i)+"','"+rtn_str_cash_slmt_flag.get(i)+"','"+rtn_str_cc_batch_no.get(i)+"','"+rtn_str_cc_sale_draft_no.get(i)+"','"+rtn_str_cc_swipped_yn.get(i)+"','"+rtn_str_bank_code.get(i)+"','"+rtn_str_bank_branch.get(i)+"','"+rtn_str_cash_amt_given.get(i)+"','"+rtn_str_cash_amt_return.get(i)+"','"+rtn_str_payer_name.get(i)+"','"+rtn_str_rcpt_rfnd_id_no.get(i)+"','"+rtn_str_nominee_name.get(i)+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?,'"+orgdoctypecode+"','"+orgdocnum+"','"+orgdocsrno+"')}";
					
						cstmt = con.prepareCall(sqldoctype);
						cstmt.setString(1,cash_counter_code);
						cstmt.setString(2,shift_id);
						cstmt.setString(3,str_session_id);
						cstmt.setString(4,str_pgm_date);				
				
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						
						cstmt.execute();
						

						cash_counter_code = cstmt.getString(1);
						shift_id = cstmt.getString(2);
						str_session_id = cstmt.getString(3);
						str_pgm_date  = cstmt.getString(4);					
						str_doc_type_code = cstmt.getString(5);
						str_doc_no=cstmt.getString(6);
						rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
						str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						str_error_level=cstmt.getString(9);
						str_sysmesage_id=cstmt.getString(10);					
						str_error_text=cstmt.getString(11);

						if(cash_counter_code==null) cash_counter_code="";
						if(shift_id==null) shift_id="";
						if(str_session_id==null) str_session_id="";
						if(str_pgm_date==null) str_pgm_date="";
						if(str_doc_type_code==null) str_doc_type_code="";
						if(str_doc_no==null) str_doc_no="";					
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";//Added by muthu on 25-7-12 Receipt
						if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";//Added by muthu on 25-7-12 Receipt


						System.out.println("procedure 0 error id check "+str_sysmesage_id);
						System.out.println("procedure 0 error text chceck"+str_error_text);
						
						cstmt.close();
					}
					catch(Exception e)
					{
						insertable=false;
						sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
						System.out.println("Exception in Proc Call 1st :"+e);
						e.printStackTrace();
					}
					
							try{
								cstmt=con.prepareCall("{call IBAEHIS.BL_INSERT_DEPOSIT.check_cc_applicable_yn(?,?,?)}");
								cstmt.setString(1,facility_id);
								cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
								cstmt.execute();
								sys_warning = cstmt.getString(2);
							}
							catch(Exception warnEx){
								System.out.println("check_cc_applicable_yn error id check "+warnEx);
							}
							finally{
								cstmt.close();
							}
							
							try
							{
							cstmt=con.prepareCall("{call IBAEHIS.bl_insert_deposit.global_unassign_values(?)}");
							cstmt.setString(1,null);
							cstmt.execute();
							
							}catch(Exception e)
							{
								System.out.println("EXception in procedure bl_insert_deposit.global_unassign_values"+e);
								e.printStackTrace();
							}
						finally
						{
							cstmt.close();
						}

						if( (!str_sysmesage_id.equals("") && !str_sysmesage_id.equals("BL9864") && !str_sysmesage_id.equals("BL9865"))  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}
						
						
						//Estimate Deposit procedure call begins here 
						else
						{
							if("BL9864".equals(str_sysmesage_id) || "BL9865".equals(str_sysmesage_id)){
								sys_warning = str_sysmesage_id;
							}
							insertable = true;
							gen_doc_type = str_doc_type_code;
							gen_doc_num = str_doc_no;
							gen_prt_format = str_rec_prt_format_vals;
							final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;
							System.out.println("str_doc_type_code "+str_doc_type_code);
							System.out.println("str_doc_no "+str_doc_no);
							
							try
							{
							List<BLEstimateDepositBean> depositlistejb = depositbean.getDepositList();
							System.out.println("list,751="+depositlistejb);						
							int size=0;
							
							StringBuffer servCodeObj = new StringBuffer();
							StringBuffer rateChrgObj = new StringBuffer();
							StringBuffer baseQtyObj = new StringBuffer();
							StringBuffer baseRateObj = new StringBuffer();
							StringBuffer QtyObj = new StringBuffer();
							StringBuffer chargesObj = new StringBuffer();
							StringBuffer dayTypeObj = new StringBuffer();
							StringBuffer timeTypeObj = new StringBuffer();
							if(depositlistejb!=null) {
								System.out.println("in if 757");
								size=depositlistejb.size();	
								System.out.println("size="+size);	
								System.out.println("Bean Add in EJB ");
								int j=0;
								for (Iterator iterator = depositlistejb.iterator(); iterator.hasNext();)
								{
									depositbean = (BLEstimateDepositBean) iterator.next();
									System.out.println("service code"+depositbean.getService_code());
									//RBU-GHL-CRF-0021 V231129
									if(!"".equals(depositbean.getService_code()) || !"null".equals(depositbean.getService_code()))
									{
										servCodeObj.append(depositbean.getService_code()).append("|");	
										if( !"".equals(depositbean.getRate_charge()) || !"null".equals(depositbean.getRate_charge())){
											rateChrgObj.append(depositbean.getRate_charge()).append("|");			
										}else{
											rateChrgObj.append(" |");
										}
										if( !"".equals(depositbean.getBase_qty()) || !"null".equals(depositbean.getBase_qty())){
											baseQtyObj.append(depositbean.getBase_qty()).append("|");	
										}else{
											baseQtyObj.append("0|");
										}
										if( !"".equals(depositbean.getBase_rate()) || !"null".equals(depositbean.getBase_rate())){
											baseRateObj.append(depositbean.getBase_rate()).append("|");	
										}else{
											baseRateObj.append("0|");
										}
										if( !"".equals(depositbean.getQty()) || !"null".equals(depositbean.getQty())){
											QtyObj.append(depositbean.getQty()).append("|");	
										}else{
											QtyObj.append("0|");
										}
										if( !"".equals(depositbean.getCharges()) || !"null".equals(depositbean.getCharges())){
											chargesObj.append(depositbean.getCharges()).append("|");	
										}else{
											chargesObj.append("0|");
										}
										if( !"".equals(depositbean.getDay_type()) || !"null".equals(depositbean.getDay_type())){
											dayTypeObj.append(depositbean.getDay_type()).append("|");	
										}else{
											dayTypeObj.append(" |");
										}
										if( !"".equals(depositbean.getTime_type()) || !"null".equals(depositbean.getTime_type())){
											timeTypeObj.append(depositbean.getTime_type()).append("|");			
										}else{
											timeTypeObj.append(" |");
										}
									}else{
										servCodeObj.append(" |");
										rateChrgObj.append(" |");			 
										baseQtyObj.append("0|");
										baseRateObj.append("0|");
										QtyObj.append("0|");
										chargesObj.append("0|");
										dayTypeObj.append(" |");
										timeTypeObj.append(" |");	
									}
									j++;
								}
								System.out.println("Objarrdata,791=>"+servCodeObj+"~"+rateChrgObj+"~"+baseQtyObj);
								System.out.println("Objarrdata,791=>"+baseRateObj+"~"+QtyObj+"~"+chargesObj);
								System.out.println("Objarrdata,791=>"+dayTypeObj+"~"+timeTypeObj);
								
							} else
							{
								//RBU-GHL-CRF-0021 V231129
								System.out.println("in else 830");
								servCodeObj.append(" |");			
								rateChrgObj.append(" |");			 
								baseQtyObj.append("0|");
								baseRateObj.append("0|");
								QtyObj.append("0|");
								chargesObj.append("0|");
								dayTypeObj.append(" |");
								timeTypeObj.append(" |");	
							}
							System.out.println("Objarrdata,823=>"+servCodeObj+"~"+rateChrgObj+"~"+baseQtyObj);
							System.out.println("Objarrdata,823=>"+baseRateObj+"~"+QtyObj+"~"+chargesObj);
							System.out.println("Objarrdata,823=>"+dayTypeObj+"~"+timeTypeObj);
							

							System.out.println("facility_id,810=>"+facility_id+"episode_type~"+episode_type+"patient_id~"+patient_id);
							System.out.println("episode_id,810=>"+episode_id+"visit_id~"+visit_id+"requestid~"+requestid);
							System.out.println("rcpt_rfnd_ind,810=>"+rcpt_rfnd_ind+"rcpt_nature_code~"+rcpt_nature_code+"rcpt_type_code~"+rcpt_type_code);
							
								System.out.println("cc_machine_id 821");
								cstmt = con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.bl_insert_rec_service_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1, facility_id);
								cstmt.setString(2,episode_type);
								cstmt.setString(3,patient_id);
								cstmt.setString(4, episode_id); 
								cstmt.setString(5, visit_id); 
								cstmt.setString(6, requestid); 
								cstmt.setString(7, rcpt_rfnd_ind); 
								cstmt.setString(8, rcpt_nature_code); 
								cstmt.setString(9, rcpt_type_code); 
								cstmt.setString(10,str_doc_type_code);
								System.out.println("str_doc_type_code"+str_doc_type_code);
								cstmt.setString(11,str_doc_no);
								System.out.println("str_doc_no"+str_doc_no);
								if((currdate == null) || ("".equals(currdate))){
									cstmt.setString(12, null);
									}
								else{
									cstmt.setDate(12, new java.sql.Date(sdf.parse(currdate).getTime()));
									}
								//RBU-GHL-CRF-0021 V231129
								cstmt.setString(13, servCodeObj.toString());
								cstmt.setString(14, rateChrgObj.toString());
								cstmt.setString(15, baseQtyObj.toString());
								cstmt.setString(16, baseRateObj.toString());
								cstmt.setString(17, QtyObj.toString());
								cstmt.setString(18, chargesObj.toString());
								cstmt.setString(19, dayTypeObj.toString());
								cstmt.setString(20, timeTypeObj.toString());
								
								cstmt.setString(21, user_id); 
								cstmt.setString(22, client_ip_address); 
								cstmt.setString(23, locale); 
								
								cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								cstmt.execute();	
								str_error_level = cstmt.getString(24);
								str_sysmesage_id = cstmt.getString(25);
								str_error_text = cstmt.getString(26);
								
								System.out.println("error check"+str_sysmesage_id);
								System.out.println("error text check"+str_error_text);
								
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								
							//cstmt.close();
								if(!(("").equals(str_sysmesage_id)) || !(("").equals(str_error_text)))
								{
								insertable=false;
											
								}
								
							
							}
							catch(Exception e)
							{
								insertable=false;
								System.out.println("Exception1 in BLEstimateDepositBean"+e);
								e.printStackTrace();							
							}
							finally
							{
								cstmt.close();
							} //Estimate Deposit procedure call ends here 
							
							//Special Agency Deposit Procedure Call begins here
							try
							{
								cstmt = con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.insert_spl_age_dep_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1, facility_id);
								cstmt.setString(2,patient_id);						     
								cstmt.setString(3, rcpt_rfnd_ind); 						    
								cstmt.setString(4,episode_type);
								cstmt.setString(5, ip_adm_trf_dep_ind); 
								cstmt.setString(6, rcpt_nature_code); 
								cstmt.setString(7, null); 
								cstmt.setString(8, splAgnDpstYN); 
								cstmt.setString(9,ip_adm_trf_dep_ind);
								cstmt.setString(10,str_doc_type_code);
								cstmt.setString(11,str_doc_no);
								cstmt.setString(12,doc_amt);
								cstmt.setString(13,null);
								
								if((splAgnDepEffFrom == null) || ("".equals(splAgnDepEffFrom))){
									cstmt.setString(14, null);
									}
								else{
									cstmt.setDate(14, new java.sql.Date(sdf.parse(splAgnDepEffFrom).getTime()));
									}
								
								if((splAgnDepEffTo == null) || ("".equals(splAgnDepEffTo))){
									cstmt.setString(15, null);
									}
								else{
									cstmt.setDate(15, new java.sql.Date(sdf.parse(splAgnDepEffTo).getTime()));
									}
								
								
								cstmt.setString(16, user_id); 
								cstmt.setString(17, client_ip_address); 
								
								cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
								cstmt.execute();	
								str_error_level = cstmt.getString(18);
								str_sysmesage_id = cstmt.getString(19);
								str_error_text = cstmt.getString(20);
								
								System.out.println("error check"+str_sysmesage_id);
								System.out.println("error text check"+str_error_text);
								
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
							
								
							
								if(!(("").equals(str_sysmesage_id)) || !(("").equals(str_error_text)))
								{
								insertable=false;
											
								}
							
							
							
							
							}catch(Exception e)
								{
								
								insertable=false;
								System.out.println("Exception in bl_proc_receipt_refund_main.insert_spl_age_dep_dtls"+e);
								e.printStackTrace();							
					
							}
							finally
							{
								cstmt.close();
							}
						
						}	//special agency deposit procedure call ends here 
						}
					}//end insertable
					/*********************added for PACKAGE BILLING **************************************/
				
				/*	if(insertable)
					{
						
						if(!pkgSeqNo.equals(""))
						{
							String sqlpkgdep  ="{ call   blpackage.UpdatePackSub(?,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlpkgdep);							
							
							cstmt.setString(1,facility_id);
							cstmt.setString(2,pkgSeqNo);
							cstmt.setString(3,str_doc_type_code);
							cstmt.setString(4,str_doc_no);
							cstmt.setString(5,str_doc_amt);
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
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
							}
							else
							{
								insertable = true;
							}
					}//package seq chk
					} */ //insertable 
					}//end for
				}
				catch(Exception e)
				{
					insertable=false;
					sys_err.append(" Exception in if :"+e);
					System.out.println("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd Y"+e);
					e.printStackTrace();
				}
				}
			
			else{
				System.out.println("else ejb");
					String rtn_str_slmt_doc_amt = (String)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
					if(rtn_str_slmt_doc_amt==null) rtn_str_slmt_doc_amt="";

					String rtn_str_slmt_type_code = (String)mult_slmt_vals.get("rtn_str_slmt_type_code");
					if(rtn_str_slmt_type_code==null) rtn_str_slmt_type_code="";

					String rtn_str_slmt_doc_ref_date = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
					if(rtn_str_slmt_doc_ref_date==null) rtn_str_slmt_doc_ref_date="";


					String rtn_str_slmt_doc_ref_desc = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
					if(rtn_str_slmt_doc_ref_desc==null) rtn_str_slmt_doc_ref_desc="";


					String rtn_str_slmt_doc_remarks = (String)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
					if(rtn_str_slmt_doc_remarks==null) rtn_str_slmt_doc_remarks="";


					String rtn_str_app_ref_no = (String)mult_slmt_vals.get("rtn_str_app_ref_no");
					if(rtn_str_app_ref_no==null) rtn_str_app_ref_no="";


					String rtn_str_cash_slmt_flag = (String)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
					if(rtn_str_cash_slmt_flag==null) rtn_str_cash_slmt_flag="";

					String rtn_str_cc_batch_no = (String)mult_slmt_vals.get("rtn_str_cc_batch_no");
					if(rtn_str_cc_batch_no==null) rtn_str_cc_batch_no="";


					String rtn_str_cc_sale_draft_no = (String)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");
					if(rtn_str_cc_sale_draft_no==null) rtn_str_cc_sale_draft_no="";

					String rtn_str_cc_swipped_yn = (String)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
					if(rtn_str_cc_swipped_yn==null) rtn_str_cc_swipped_yn="";


					String rtn_str_bank_code = (String)mult_slmt_vals.get("rtn_str_bank_code");
					if(rtn_str_bank_code==null) rtn_str_bank_code="";


					String rtn_str_bank_branch = (String)mult_slmt_vals.get("rtn_str_bank_branch");
					if(rtn_str_bank_branch==null) rtn_str_bank_branch="";


					String rtn_str_cash_amt_given = (String)mult_slmt_vals.get("rtn_str_cash_amt_given");
					if(rtn_str_cash_amt_given==null) rtn_str_cash_amt_given="";


					String rtn_str_cash_amt_return = (String)mult_slmt_vals.get("rtn_str_cash_amt_return");
					if(rtn_str_cash_amt_return==null) rtn_str_cash_amt_return="";


					String rtn_str_payer_name = (String)mult_slmt_vals.get("rtn_str_payer_name");
					if(rtn_str_payer_name==null) rtn_str_payer_name="";


					String rtn_str_rcpt_rfnd_id_no = (String)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
					if(rtn_str_rcpt_rfnd_id_no==null) rtn_str_rcpt_rfnd_id_no="";


					String rtn_str_nominee_name = (String)mult_slmt_vals.get("rtn_str_nominee_name");
					if(rtn_str_nominee_name==null) rtn_str_nominee_name="";

					String rtn_str_doc_sr_no = (String)mult_slmt_vals.get("rtn_str_doc_sr_no");
					if(rtn_str_doc_sr_no==null) rtn_str_doc_sr_no="";


		
			
				/*try
				{
				
					cstmt = con.prepareCall("{ call BLCORE.GENERATE_SEQUENCE_COMMON_PROC(?,?,?,?,?)}");

					cstmt.setString(1,facility_id);
					
					if(episode_type.equals("O") || episode_type.equals("E"))
					{
						cstmt.setString(2,"DIRECT_OP");
						cstmt.setString(3,"BL-OPDE");
					}
					else if(episode_type.equals("I") || episode_type.equals("D"))
					{
						cstmt.setString(2,"DIRECT_IP");
						cstmt.setString(3,"BL-IPDE");
					}
					else
					{
						cstmt.setString(2,"DIRECT_RF");
						cstmt.setString(3,"BL-RFDE");
					}

					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);

					cstmt.execute();

					errText = "";
					
					str_trx_doc_ref = cstmt.getString(4);
					errText = cstmt.getString(5);

					if(str_trx_doc_ref == null) str_trx_doc_ref="";
					if(errText == null) errText="";

					System.out.println("str_trx_doc_ref:"+str_trx_doc_ref);
					System.out.println("errCode:"+errCode);
					
					cstmt.close();

					if(!errText.equals(""))
					{
						insertable = false;
					}
					else
					{
						insertable = true;
					}
				}
				catch (Exception e)
				{
					insertable = false;
					sys_err.append("Exception while calling GENERATE_SEQUENCE_COMMON_PROC:"+e);
					System.out.println("Exception while calling GENERATE_SEQUENCE_COMMON_PROC:"+e);
				}*/


				insertable = true;
	/**************added for CRF-13**************************/
				try{
					if(hand_without_counter_chk_out.equals("Y")){
					if(insertable)
					{
						String str_rcpt_doc_amt = rtn_str_slmt_doc_amt.replace("|","~");
						String str_slmt_type_code = rtn_str_slmt_type_code.replace("|","~");

						cstmt = con.prepareCall("{ IBAEHIS.call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,user_id);
						cstmt.setString(3,cash_counter_code);
						cstmt.setString(4,str_slmt_type_code);
						cstmt.setString(5,str_rcpt_doc_amt);					

						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
								
						str_error_level		 = cstmt.getString(6);		
						str_sysmesage_id	 = cstmt.getString(7);		
						str_error_text     	 = cstmt.getString(8);				
						
						if ( str_error_level  == null ) str_error_level = "";
						if ( str_sysmesage_id == null ) str_sysmesage_id ="";
						if ( str_error_text	  == null ) str_error_text ="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if(str_error_level.equals("10") && (!str_error_text.equals("")))
						{
							insertable = false;
						}
							if(!str_sysmesage_id.equals(""))
							{
								if(	str_sysmesage_id.equals("BL7340")){
									str_sysmesage_id_limit="BL7340";
									insertable = true;
								}else{
									str_sysmesage_id_limit="";
									insertable = false;
									}
						
							}

						
					}
				}//insertable
			}//if
				}catch(Exception ee)
					{
						insertable=false;
					sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
					System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);
					ee.printStackTrace();
					}
		/*************End*******************************************/		
			
				try
				{
					if(insertable)
					{
						System.out.println("ejb 2nd");
						String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
						//debetor_catagory_code=episode_type
						//String downtime_slmt_yn="";
						//String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no+"','"+rtn_str_slmt_doc_amt+"','"+rtn_str_slmt_type_code+"','"+rtn_str_slmt_doc_ref_desc+"','"+rtn_str_slmt_doc_ref_date+"','"+rtn_str_slmt_doc_remarks+"','"+rtn_str_app_ref_no+"','"+rtn_str_cash_slmt_flag+"','"+rtn_str_cc_batch_no+"','"+rtn_str_cc_sale_draft_no+"','"+rtn_str_cc_swipped_yn+"','"+rtn_str_bank_code+"','"+rtn_str_bank_branch+"','"+rtn_str_cash_amt_given+"','"+rtn_str_cash_amt_return+"','"+rtn_str_payer_name+"','"+rtn_str_rcpt_rfnd_id_no+"','"+rtn_str_nominee_name+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?)}";
						//Below query is changed by muthu on 25-7-12 against 33868 - Receipt Print
						try
						{
						cstmt=con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.bl_proc_validate_main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,episode_type);
						cstmt.setString(3,patient_id);
						cstmt.setString(4,episode_id);	
						cstmt.setString(5,visit_id);
						cstmt.setString(6,downtime_entry_yn);
						cstmt.setString(7,downtime_doc_type_code);
						cstmt.setString(8,downtime_doc_num);
						if((downtime_doc_date == null) || ("".equals(downtime_doc_date))){
							cstmt.setString(9, null);
							}
						else{
							cstmt.setDate(9, new java.sql.Date(sdf1.parse(downtime_doc_date).getTime()));
							}
						//cstmt.setString(9,downtime_doc_date);
						cstmt.setString(10,downtime_reason_code);
						cstmt.setString(11,rcpt_rfnd_ind);
						cstmt.setString(12,rcpt_nature_code);	
						cstmt.setString(13,rcpt_type_code);
						cstmt.setString(14,orgdoctypecode);
						cstmt.setString(15,orgdocnum);
						cstmt.setString(16,orgdocsrno);	
						cstmt.setString(17,doc_amt);
						cstmt.setString(18,total_settled_amt);
						cstmt.setString(19,null);	
						cstmt.setString(20,refnumber);			
						cstmt.setString(21,user_id);
						cstmt.setString(22,client_ip_address);
						cstmt.setString(23,locale);
						cstmt.setString(24,null);	
						cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);					
				
						cstmt.execute();
						str_error_level=cstmt.getString(25);
						str_sysmesage_id=cstmt.getString(26);					
						str_error_text=cstmt.getString(27);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";

						System.out.println("validation 1 error id check "+str_sysmesage_id);
						System.out.println("validation 1 error text chceck"+str_error_text);
						cstmt.close();
						}
						catch(Exception e)
						{
							insertable=false;
							System.out.println("Exception in bl_proc_receipt_refund_main.bl_proc_validate_main"+e);
							e.printStackTrace();
						}
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}

						else
						{
						
							try
							{
							cstmt=con.prepareCall("{call IBAEHIS.bl_insert_deposit.global_assign_values(?)}");
							cstmt.setString(1,refnumber);
							cstmt.execute();
							}catch(Exception e)
							{
								System.out.println("EXception in procedure bl_insert_deposit.global_assign_values"+e);
								e.printStackTrace();
							}
							finally
							{
								cstmt.close();
							}
						
						
							String sqldoctype="{ call   IBAEHIS.BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"',TO_DATE('"+downtime_doc_date+"','DD/MM/YYYY HH24:MI:SS'),'"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no+"','"+rtn_str_slmt_doc_amt+"','"+rtn_str_slmt_type_code+"','"+rtn_str_slmt_doc_ref_desc+"','"+rtn_str_slmt_doc_ref_date+"','"+rtn_str_slmt_doc_remarks+"','"+rtn_str_app_ref_no+"','"+rtn_str_cash_slmt_flag+"','"+rtn_str_cc_batch_no+"','"+rtn_str_cc_sale_draft_no+"','"+rtn_str_cc_swipped_yn+"','"+rtn_str_bank_code+"','"+rtn_str_bank_branch+"','"+rtn_str_cash_amt_given+"','"+rtn_str_cash_amt_return+"','"+rtn_str_payer_name+"','"+rtn_str_rcpt_rfnd_id_no+"','"+rtn_str_nominee_name+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?,'"+orgdoctypecode+"','"+orgdocnum+"','"+orgdocsrno+"')}";
					
						cstmt = con.prepareCall(sqldoctype);
						cstmt.setString(1,cash_counter_code);
						cstmt.setString(2,shift_id);
						cstmt.setString(3,str_session_id);
						cstmt.setString(4,str_pgm_date);	
				
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						
						cstmt.execute();

						cash_counter_code = cstmt.getString(1);
						shift_id = cstmt.getString(2);
						str_session_id = cstmt.getString(3);
						str_pgm_date  = cstmt.getString(4);					
						str_doc_type_code = cstmt.getString(5);
						str_doc_no=cstmt.getString(6);
						rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
						str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						str_error_level=cstmt.getString(9);
						str_sysmesage_id=cstmt.getString(10);					
						str_error_text=cstmt.getString(11);


						if(cash_counter_code==null) cash_counter_code="";
						if(shift_id==null) shift_id="";
						if(str_session_id==null) str_session_id="";
						if(str_pgm_date==null) str_pgm_date="";
						if(str_doc_type_code==null) str_doc_type_code="";
						if(str_doc_no==null) str_doc_no="";					
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";//Added by muthu on 25-7-12 Receipt
						if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";//Added by muthu on 25-7-12 Receipt
						

						System.out.println("procedure 1 error id check "+str_sysmesage_id);
						System.out.println("procedure 1 error text chceck"+str_error_text);
						cstmt.close();
						
						try{
							cstmt=con.prepareCall("{call IBAEHIS.BL_INSERT_DEPOSIT.check_cc_applicable_yn(?,?,?)}");
							cstmt.setString(1,facility_id);
							cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
							cstmt.execute();
							sys_warning = cstmt.getString(2);
						}
						catch(Exception warnEx){
							System.out.println("check_cc_applicable_yn error id check "+warnEx);
						}
						finally{
							cstmt.close();
						}

						try
						{
						cstmt=con.prepareCall("{call IBAEHIS.bl_insert_deposit.global_unassign_values(?)}");
						cstmt.setString(1,null);
						cstmt.execute();
						}catch(Exception e)
						{
							System.out.println("EXception in procedure bl_insert_deposit.global_unassign_values"+e);
							e.printStackTrace();
						}
						finally
						{
							cstmt.close();
						}
					
						
						if( (!str_sysmesage_id.equals("") && !str_sysmesage_id.equals("BL9864") && !str_sysmesage_id.equals("BL9865"))  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}
						else
						{
							if("BL9864".equals(str_sysmesage_id) || "BL9865".equals(str_sysmesage_id)){
								sys_warning = str_sysmesage_id;
							}
							insertable = true;
							gen_doc_type = str_doc_type_code;
							gen_doc_num = str_doc_no;
							gen_prt_format = str_rec_prt_format_vals;//Added by muthu on 25-7-12 Receipt
							final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;
							System.out.println("str_doc_type_code");
							System.out.println("str_doc_no");
							
							try
							{
							List<BLEstimateDepositBean> depositlistejb = depositbean.getDepositList();
							System.out.println("list="+depositlistejb);						
							int size=0;
							
							StringBuffer servCodeObj = new StringBuffer();
							StringBuffer rateChrgObj = new StringBuffer();
							StringBuffer baseQtyObj = new StringBuffer();
							StringBuffer baseRateObj = new StringBuffer();
							StringBuffer QtyObj = new StringBuffer();
							StringBuffer chargesObj = new StringBuffer();
							StringBuffer dayTypeObj = new StringBuffer();
							StringBuffer timeTypeObj = new StringBuffer();
							
							if(depositlistejb!=null) {
								System.out.println("in if 1409");
								size=depositlistejb.size();	
								System.out.println("size 1460 "+size);
								System.out.println("Bean Add in EJB ");
								int j=0;
								for (Iterator iterator = depositlistejb.iterator(); iterator.hasNext();)
								{
									depositbean = (BLEstimateDepositBean) iterator.next();
									System.out.println("service code"+depositbean.getService_code());
									//RBU-GHL-CRF-0021 V231129
									if(!"".equals(depositbean.getService_code()) || !"null".equals(depositbean.getService_code()))
									{
										servCodeObj.append(depositbean.getService_code()).append("|");	
										if( !"".equals(depositbean.getRate_charge()) || !"null".equals(depositbean.getRate_charge())){
											rateChrgObj.append(depositbean.getRate_charge()).append("|");			
										}else{
											rateChrgObj.append(" |");
										}
										if( !"".equals(depositbean.getBase_qty()) || !"null".equals(depositbean.getBase_qty())){
											baseQtyObj.append(depositbean.getBase_qty()).append("|");	
										}else{
											baseQtyObj.append("0|");
										}
										if( !"".equals(depositbean.getBase_rate()) || !"null".equals(depositbean.getBase_rate())){
											baseRateObj.append(depositbean.getBase_rate()).append("|");	
										}else{
											baseRateObj.append("0|");
										}
										if( !"".equals(depositbean.getQty()) || !"null".equals(depositbean.getQty())){
											QtyObj.append(depositbean.getQty()).append("|");	
										}else{
											QtyObj.append("0|");
										}
										if( !"".equals(depositbean.getCharges()) || !"null".equals(depositbean.getCharges())){
											chargesObj.append(depositbean.getCharges()).append("|");	
										}else{
											chargesObj.append("0|");
										}
										if( !"".equals(depositbean.getDay_type()) || !"null".equals(depositbean.getDay_type())){
											dayTypeObj.append(depositbean.getDay_type()).append("|");	
										}else{
											dayTypeObj.append(" |");
										}
										if( !"".equals(depositbean.getTime_type()) || !"null".equals(depositbean.getTime_type())){
											timeTypeObj.append(depositbean.getTime_type()).append("|");			
										}else{
											timeTypeObj.append(" |");
										}
									}else{
										servCodeObj.append(" |");
										rateChrgObj.append(" |");			 
										baseQtyObj.append("0|");
										baseRateObj.append("0|");
										QtyObj.append("0|");
										chargesObj.append("0|");
										dayTypeObj.append(" |");
										timeTypeObj.append(" |");	
									}
									j++;
								}
								System.out.println("Objarrdata,1487=>"+servCodeObj+"~"+rateChrgObj+"~"+baseQtyObj);
								System.out.println("Objarrdata,1487=>"+baseRateObj+"~"+QtyObj+"~"+chargesObj);
								System.out.println("Objarrdata,1487=>"+dayTypeObj+"~"+timeTypeObj);
							} else
							{
								//RBU-GHL-CRF-0021 V231129
								System.out.println("in else 1493");
								servCodeObj.append(" |");			
								rateChrgObj.append(" |");			 
								baseQtyObj.append("0|");
								baseRateObj.append("0|");
								QtyObj.append("0|");
								chargesObj.append("0|");
								dayTypeObj.append(" |");
								timeTypeObj.append(" |");	
							}
							System.out.println("Objarrdata,1470=>"+servCodeObj+"~"+rateChrgObj+"~"+baseQtyObj);
							System.out.println("Objarrdata,1470=>"+baseRateObj+"~"+QtyObj+"~"+chargesObj);
							System.out.println("Objarrdata,1470=>"+dayTypeObj+"~"+timeTypeObj);
							
							System.out.println("facility_id,1470=>"+facility_id+"episode_type~"+episode_type+"patient_id~"+patient_id);
							System.out.println("episode_id,1470=>"+episode_id+"visit_id~"+visit_id+"requestid~"+requestid);
							System.out.println("rcpt_rfnd_ind,1470=>"+rcpt_rfnd_ind+"rcpt_nature_code~"+rcpt_nature_code+"rcpt_type_code~"+rcpt_type_code);
							 
								System.out.println("cc_machine_id 2");
								cstmt = con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.bl_insert_rec_service_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1, facility_id);
								cstmt.setString(2,episode_type);
								cstmt.setString(3,patient_id);
								cstmt.setString(4, episode_id); 
								cstmt.setString(5, visit_id); 
								cstmt.setString(6, requestid); 
								cstmt.setString(7, rcpt_rfnd_ind); 
								cstmt.setString(8, rcpt_nature_code); 
								cstmt.setString(9, rcpt_type_code); 
								cstmt.setString(10,str_doc_type_code);
								System.out.println("str_doc_type_code"+str_doc_type_code);
								cstmt.setString(11,str_doc_no);
								System.out.println("str_doc_no"+str_doc_no);
								if((currdate == null) || ("".equals(currdate))){
									cstmt.setString(12, null);
									}
								else{
									cstmt.setDate(12, new java.sql.Date(sdf.parse(currdate).getTime()));
									}
								System.out.println("1474");
								//RBU-GHL-CRF-0021 V231129
								cstmt.setString(13, servCodeObj.toString());
								cstmt.setString(14, rateChrgObj.toString());
								cstmt.setString(15, baseQtyObj.toString());
								cstmt.setString(16, baseRateObj.toString());
								cstmt.setString(17, QtyObj.toString());
								cstmt.setString(18, chargesObj.toString());
								cstmt.setString(19, dayTypeObj.toString());
								cstmt.setString(20, timeTypeObj.toString());
								System.out.println("1484");
								cstmt.setString(21, user_id); 
								cstmt.setString(22, client_ip_address); 
								cstmt.setString(23, locale); 
								
								cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								cstmt.execute();	
								str_error_level = cstmt.getString(24);
								str_sysmesage_id = cstmt.getString(25);
								str_error_text = cstmt.getString(26);
								
								System.out.println("error check"+str_sysmesage_id);
								System.out.println("error text check"+str_error_text);
								
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								
								if(!(("").equals(str_sysmesage_id)) || !(("").equals(str_error_text)))
								{
								insertable=false;
											
								}
								
							
							}
							catch(Exception e)
							{
								insertable=false;
								System.out.println("Exception1 in BLEstimateDepositBean"+e);
								e.printStackTrace();							
							}
							finally
							{
								cstmt.close();
							} //Estimate Deposit procedure call ends here 
							
							//Special Agency Deposit Procedure Call begins here
						
							
							try
							{
								cstmt = con.prepareCall("{call IBAEHIS.bl_proc_receipt_refund_main.insert_spl_age_dep_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1, facility_id);
								cstmt.setString(2,patient_id);						     
								cstmt.setString(3, rcpt_rfnd_ind); 						    
								cstmt.setString(4,episode_type);
								cstmt.setString(5, ip_adm_trf_dep_ind); 
								cstmt.setString(6, rcpt_nature_code); 
								cstmt.setString(7, null); 
								cstmt.setString(8, splAgnDpstYN); 
								cstmt.setString(9,ip_adm_trf_dep_ind);
								cstmt.setString(10,str_doc_type_code);
								cstmt.setString(11,str_doc_no);
								cstmt.setString(12,doc_amt);
								cstmt.setString(13,null);
								if((splAgnDepEffFrom == null) || ("".equals(splAgnDepEffFrom))){
									cstmt.setString(14, null);
									}
								else{
									cstmt.setDate(14, new java.sql.Date(sdf.parse(splAgnDepEffFrom).getTime()));
									}
								
								if((splAgnDepEffTo == null) || ("".equals(splAgnDepEffTo))){
									cstmt.setString(15, null);
									}
								else{
									cstmt.setDate(15, new java.sql.Date(sdf.parse(splAgnDepEffTo).getTime()));
									}
									cstmt.setString(16, user_id); 
								cstmt.setString(17, client_ip_address); 
								
								cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);	
								cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
								cstmt.execute();	
								str_error_level = cstmt.getString(18);
								str_sysmesage_id = cstmt.getString(19);
								str_error_text = cstmt.getString(20);
								
								System.out.println("error check"+str_sysmesage_id);
								System.out.println("error text check"+str_error_text);
								
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
							
								
							
								if(!(("").equals(str_sysmesage_id)) || !(("").equals(str_error_text)))
								{
								insertable=false;
											
								}
							
							
							
							
							}catch(Exception e)
								{
								
								insertable=false;
								System.out.println("Exception in bl_proc_receipt_refund_main.insert_spl_age_dep_dtls"+e);
								e.printStackTrace();							
					
							}
							finally
							{
								cstmt.close();
							} //Special Agency Deposit procedure call ends here 
							

						}	
						}
						
					}//INSERTABLE
					
	/********************added for package deposit ******************************/
			/*		if(insertable)
					{
						if(!pkgSeqNo.equals(""))
						{
							String sqlpkgdep  ="{ call   blpackage.UpdatePackSub(?,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlpkgdep);							
							cstmt.setString(1,facility_id);
							cstmt.setString(2,pkgSeqNo);
							cstmt.setString(3,str_doc_type_code);
							cstmt.setString(4,str_doc_no);
							cstmt.setString(5,doc_amt);
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
							//System.out.println("str_error_level blpackage.UpdatePackSub:"+str_error_level);
							//System.out.println("str_sysmesage blpackage.UpdatePackSub:"+str_sysmesage_id);
							//System.out.println("str_error_text blpackage.UpdatePackSub"+str_error_text);
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
							}
							else
							{
								insertable = true;
							}
						}//pakg seq test
					}//insertable */

				}
				catch(Exception e)
				{
					insertable=false;
					sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
					System.out.println("Exception in Proc Call 2nd :"+e);
				}
			}// end else 
				if(insertable)
				{
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
				System.out.println("Main Exception:"+e);
			}
			
			finally 
			{
				System.out.println("finally");
				if (con != null)
					ConnectionManager.returnConnection(con, p);
			}
		
			System.out.println("final_msg_doc_type_code ejb:::"+final_msg_doc_type_code);
			return_mess.put("status",new Boolean(insertable));
			return_mess.put("error",str_error_text);
			return_mess.put("sys_error",sys_err.toString());
			return_mess.put("message",str_sysmesage_id);
			return_mess.put("message1",str_sysmesage_id_limit);
			return_mess.put("gen_doc_type",gen_doc_type);
			return_mess.put("gen_doc_num",gen_doc_num);
			return_mess.put("final_msg_doc_type_code",final_msg_doc_type_code);
			return_mess.put("gen_prt_format",gen_prt_format);//Added by muthu on 25-7-12 Receipt
			return_mess.put("rec_print_format_enabled_yn",rec_print_format_enabled_yn);//Added by muthu on 25-7-12 Receipt
			return_mess.put("str_rec_prt_format_vals",str_rec_prt_format_vals);//Added by muthu on 25-7-12 Receipt
			return_mess.put("sys_warning",sys_warning);
			return return_mess;
		}
		
		/**
		* @ejb.interface-method
		*	 view-type="both"
		*/
		
		public java.util.HashMap insert(java.util.Properties p,java.util.HashMap support_data,java.util.HashMap mult_slmt_vals) 
		{
			
			con = ConnectionManager.getConnection(p);
			//con.setAutoCommit( false ) ;

			HashMap return_mess = new HashMap();
			final_msg_doc_type_code="";
			
			//HashMap multi_slmt_val=mult_slmt_vals;
			//HashMap indi_slmt_val = new HashMap();
			
			//StringTokenizer st = null;
			boolean insertable = false;
		//	String error="";
			String locale = "";

			locale = (String) support_data.get("locale");
			if(locale==null) locale="en";

	//		java.util.Locale loc = new java.util.Locale(locale);

			//java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);

			//String hosp_chrg_leg = bl_labels.getString("eBL.PLS_NOTE_TRX_REF_NO.label");

			

			String facility_id = (String) support_data.get("facility_id");
			if(facility_id==null) facility_id="";

			String patient_id=(String)support_data.get("patient_id");
			if(patient_id==null) patient_id="";

			
			String visit_id=(String)support_data.get("visit_id");
			if(visit_id==null) visit_id="";

			String episode_id=(String)support_data.get("episode_id");
			if(episode_id==null) episode_id="";

			String episode_type=(String)support_data.get("episode_type");
			if(episode_type==null) episode_type="";

			String encounter_id=(String)support_data.get("encounter_id");
			if(encounter_id==null) encounter_id="";

			String rcpt_rfnd_ind=(String)support_data.get("rcpt_rfnd_ind");
			if(rcpt_rfnd_ind==null) rcpt_rfnd_ind="";
			String rcpt_nature_code=(String)support_data.get("rcpt_nature_code");
			if(rcpt_nature_code==null) rcpt_nature_code="";

			String cash_counter_code=(String)support_data.get("cash_counter_code");
			if(cash_counter_code==null) cash_counter_code="";

			String shift_id=(String)support_data.get("shift_id");
			if(shift_id==null) shift_id="";
			String doc_amt=(String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="";

			String narration=(String)support_data.get("narration");
			if(narration==null) narration="";

			String ip_adm_trf_dep_ind=(String)support_data.get("ip_adm_trf_dep_ind");
			if(ip_adm_trf_dep_ind==null) ip_adm_trf_dep_ind="";

			String rec_ref_format_ind=(String)support_data.get("rec_ref_format_ind");
			if(rec_ref_format_ind==null) rec_ref_format_ind="";

			String rfnd_dep_in_use_yn=(String)support_data.get("rfnd_dep_in_use_yn");
			if(rfnd_dep_in_use_yn==null) rfnd_dep_in_use_yn="";

			String pmnt_thru_mail=(String)support_data.get("pmnt_thru_mail");
			if(pmnt_thru_mail==null) pmnt_thru_mail="";

			String ext_acc_facility_id=(String)support_data.get("ext_acc_facility_id");
			if(ext_acc_facility_id==null) ext_acc_facility_id="";

			String ext_acc_code=(String)support_data.get("ext_acc_code");
			if(ext_acc_code==null) ext_acc_code="";

			String ext_acc_dept_code=(String)support_data.get("ext_acc_dept_code");
			if(ext_acc_dept_code==null) ext_acc_dept_code="";

			String mult_slmt_yn=(String)support_data.get("mult_slmt_yn");
			if(mult_slmt_yn==null) mult_slmt_yn="";

			String downtime_entry_yn=(String)support_data.get("downtime_entry_yn");
			if(downtime_entry_yn==null) downtime_entry_yn="";

			String downtime_reason_code=(String)support_data.get("downtime_reason_code");
			if(downtime_reason_code==null) downtime_reason_code="";

			String downtime_doc_type_code=(String)support_data.get("downtime_doc_type_code");
			if(downtime_doc_type_code==null) downtime_doc_type_code="";

			String downtime_doc_num=(String)support_data.get("downtime_doc_num");
			if(downtime_doc_num==null) downtime_doc_num="";

			String downtime_doc_date=(String)support_data.get("downtime_doc_date");
			if(downtime_doc_date==null) downtime_doc_date="";

			String cc_machine_id=(String)support_data.get("cc_machine_id");
			if(cc_machine_id==null) cc_machine_id="";

			String payers_add1=(String)support_data.get("payers_add1");
			if(payers_add1==null) payers_add1="";
			String payers_add2=(String)support_data.get("payers_add2");
			if(payers_add2==null) payers_add2="";

			String payers_add3=(String)support_data.get("payers_add3");
			if(payers_add3==null) payers_add3="";

			String payers_tel_num=(String)support_data.get("payers_tel_num");
			if(payers_tel_num==null) payers_tel_num="";
			
			String consolidated_receipt_yn=(String)support_data.get("consolidated_receipt_yn");
			if(consolidated_receipt_yn==null) consolidated_receipt_yn="";
			
			String user_id = (String)support_data.get("user_id");
			if(user_id==null) user_id="";
			
			String client_ip_address = (String)support_data.get("client_ip_address");
			if(client_ip_address==null) client_ip_address="";

			String rcpt_type_code = (String)support_data.get("rcpt_type_code");
			if(rcpt_type_code==null) rcpt_type_code="";

			String currdate = (String)support_data.get("currdate");
			if(currdate==null) currdate="";

			String str_tot_rec = (String)support_data.get("str_tot_rec");
			if(str_tot_rec==null) str_tot_rec="0";
			
			String str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = (String)support_data.get("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd==null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";			

			String hand_without_counter_chk_out = (String)support_data.get("hand_without_counter_chk_out");
			if(hand_without_counter_chk_out==null) hand_without_counter_chk_out="";			

			String str_doc_amt="";
	/*******************ADDEDD FOR PACKAGE BILLING**********************/	
			String pkgSeqNo = (String)support_data.get("pkgSeqNo");
			if(pkgSeqNo==null) pkgSeqNo="";	
	/*********************END*****************************************/
			//Added for MMS SCF 501.1
			String pkgSequenceNumber = (String)support_data.get("pkgSequenceNumber");
			if(pkgSequenceNumber==null) pkgSequenceNumber="";	
			System.out.println("pkgSequenceNumber "+pkgSequenceNumber);
			String pkgSequenceAmount = (String)support_data.get("pkgSequenceAmount");
			if(pkgSequenceAmount==null) pkgSequenceAmount="";	
		
		if(!"".equals(pkgSequenceNumber)){
				String strSeqAmt = "";
				StringTokenizer seqArr = new StringTokenizer(pkgSequenceNumber,"^");
				StringTokenizer amtArr = new StringTokenizer(pkgSequenceAmount,"^");
				while(seqArr.hasMoreTokens()){
					String amtArr1 = amtArr.hasMoreTokens() ? amtArr.nextToken() : "0.00";
					//System.out.println("amtArr1-->"+amtArr1);
					
					strSeqAmt += "|"+seqArr.nextToken()+"^"+amtArr1+"^N";		
					
				}
				strSeqAmt += "|";
				narration = narration+":::"+strSeqAmt;
			}
			//Added for MMS SCF 501.1

			int tot_rec=Integer.parseInt(str_tot_rec);
	//		String doc_amt_limt="",
			//String doc_type_code_limt="";
			String str_sysmesage_id_limit="";
			
			
		try
		{
			con.setAutoCommit( false ) ;
			
				
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y"))
				{
				try{

				ArrayList rtn_str_slmt_doc_amt=new ArrayList();
				ArrayList rtn_str_slmt_type_code=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_desc=new ArrayList();
				ArrayList rtn_str_slmt_doc_ref_date=new ArrayList();
				ArrayList rtn_str_slmt_doc_remarks=new ArrayList();
				ArrayList rtn_str_app_ref_no=new ArrayList();
				ArrayList rtn_str_cash_slmt_flag=new ArrayList();
				ArrayList rtn_str_cc_batch_no=new ArrayList();
				ArrayList rtn_str_cc_sale_draft_no=new ArrayList();
				ArrayList rtn_str_cc_swipped_yn=new ArrayList();
				ArrayList rtn_str_bank_code=new ArrayList();
				ArrayList rtn_str_bank_branch=new ArrayList();
				ArrayList rtn_str_cash_amt_given=new ArrayList();
				ArrayList rtn_str_cash_amt_return=new ArrayList();
				ArrayList rtn_str_payer_name=new ArrayList();
				ArrayList rtn_str_rcpt_rfnd_id_no=new ArrayList();
				ArrayList rtn_str_nominee_name=new ArrayList();
				ArrayList rtn_str_doc_sr_no=new ArrayList();

					 rtn_str_slmt_doc_amt = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
					//if(rtn_str_slmt_doc_amt==null) rtn_str_slmt_doc_amt="";
					

					rtn_str_slmt_type_code = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_type_code");
					//if(rtn_str_slmt_type_code==null) rtn_str_slmt_type_code="";

					 rtn_str_slmt_doc_ref_date = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
				//	if(rtn_str_slmt_doc_ref_date==null) rtn_str_slmt_doc_ref_date="";


					 rtn_str_slmt_doc_ref_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
				//	if(rtn_str_slmt_doc_ref_desc==null) rtn_str_slmt_doc_ref_desc="";


					 rtn_str_slmt_doc_remarks = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
				//	if(rtn_str_slmt_doc_remarks==null) rtn_str_slmt_doc_remarks="";


					 rtn_str_app_ref_no = (ArrayList)mult_slmt_vals.get("rtn_str_app_ref_no");
				//	if(rtn_str_app_ref_no==null) rtn_str_app_ref_no="";


					 rtn_str_cash_slmt_flag = (ArrayList)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
				//	if(rtn_str_cash_slmt_flag==null) rtn_str_cash_slmt_flag="";

					 rtn_str_cc_batch_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_batch_no");
				//	if(rtn_str_cc_batch_no==null) rtn_str_cc_batch_no="";


					 rtn_str_cc_sale_draft_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");
				//	if(rtn_str_cc_sale_draft_no==null) rtn_str_cc_sale_draft_no="";

					 rtn_str_cc_swipped_yn = (ArrayList)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
				//	if(rtn_str_cc_swipped_yn==null) rtn_str_cc_swipped_yn="";


					 rtn_str_bank_code = (ArrayList)mult_slmt_vals.get("rtn_str_bank_code");
				//	if(rtn_str_bank_code==null) rtn_str_bank_code="";


					 rtn_str_bank_branch = (ArrayList)mult_slmt_vals.get("rtn_str_bank_branch");
				//	if(rtn_str_bank_branch==null) rtn_str_bank_branch="";


					 rtn_str_cash_amt_given = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_given");
				//	if(rtn_str_cash_amt_given==null) rtn_str_cash_amt_given="";


					 rtn_str_cash_amt_return = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_return");
				//	if(rtn_str_cash_amt_return==null) rtn_str_cash_amt_return="";


					 rtn_str_payer_name = (ArrayList)mult_slmt_vals.get("rtn_str_payer_name");
				//	if(rtn_str_payer_name==null) rtn_str_payer_name="";


					 rtn_str_rcpt_rfnd_id_no = (ArrayList)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
				//	if(rtn_str_rcpt_rfnd_id_no==null) rtn_str_rcpt_rfnd_id_no="";


					 rtn_str_nominee_name = (ArrayList)mult_slmt_vals.get("rtn_str_nominee_name");
				//	if(rtn_str_nominee_name==null) rtn_str_nominee_name="";

					 rtn_str_doc_sr_no = (ArrayList)mult_slmt_vals.get("rtn_str_doc_sr_no");
				//	if(rtn_str_doc_sr_no==null) rtn_str_doc_sr_no="";
					insertable = true;
				/**************added for CRF-13**************************/
				
			try{
				
				if(hand_without_counter_chk_out.equals("Y")){			
					String str_rcpt_doc_amt="",arr_str_rcpt_doc_amt="",arr_str_slmt_type_code="",str_slmt_type_code="";
					for(int i=0;i<tot_rec;i++)
					{
						arr_str_rcpt_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
						str_rcpt_doc_amt=str_rcpt_doc_amt+arr_str_rcpt_doc_amt;	
						
						arr_str_slmt_type_code=(String)rtn_str_slmt_type_code.get(i);
						str_slmt_type_code=str_slmt_type_code+arr_str_slmt_type_code;	
					}
				
					str_rcpt_doc_amt=str_rcpt_doc_amt.replace("|","~");
					str_slmt_type_code=str_slmt_type_code.replace("|","~");
					

					if(insertable)
					{
						 str_rcpt_doc_amt = str_rcpt_doc_amt.replace("|","~");
						 str_slmt_type_code = str_slmt_type_code.replace("|","~");

						cstmt = con.prepareCall("{ call IBAEHIS.bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,user_id);
						cstmt.setString(3,cash_counter_code);
						cstmt.setString(4,str_slmt_type_code);
						cstmt.setString(5,str_rcpt_doc_amt);					

						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
								
						str_error_level		 = cstmt.getString(6);		
						str_sysmesage_id	 = cstmt.getString(7);		
						str_error_text     	 = cstmt.getString(8);				
						
						if ( str_error_level  == null ) str_error_level = "";
						if ( str_sysmesage_id == null ) str_sysmesage_id ="";
						if ( str_error_text	  == null ) str_error_text ="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if(str_error_level.equals("10") && (!str_error_text.equals("")))
						{
							insertable = false;
						}
							if(!str_sysmesage_id.equals(""))
							{
								if(	str_sysmesage_id.equals("BL7340")){
									str_sysmesage_id_limit="BL7340";
									insertable = true;
								}else{
									str_sysmesage_id_limit="";
									insertable = false;
									}
						
							}

						
					}
				}//insertable
				}//if
				}catch(Exception ee)
					{
						insertable=false;
					sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
					System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);;
					}
			/*************End*******************************************/		
			
			Boolean SiteSpec_PkgDep=false;
			String SiteSpecific_PkgDep ="";
			
			SiteSpec_PkgDep = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_DEP_ADJ_APPL_YN");
			
			if(SiteSpec_PkgDep){
				SiteSpecific_PkgDep="Y";
			}
			else{
				
				SiteSpecific_PkgDep="N";
				
			}

					for(int i=0;i<tot_rec;i++)
					{
					


					 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
					 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);
						String pkgSequenceNum = (String)support_data.get("pkgSeqNo");
						String pksequence="";
						String pksequence1[];
						ArrayList<String> list = new ArrayList<String>();
						StringTokenizer pksequenceNum1 = new StringTokenizer(pkgSequenceNumber,"^");
						while(pksequenceNum1.hasMoreTokens()){
							list.add(pksequenceNum1.nextToken());
							
							//pksequence += pksequenceNum1.nextToken();
							//pksequence1= pksequence;
							System.out.println("pksequence-->"+narration);
							//System.out.println("pksequence-->"+list.get(i));
						}


					if(insertable)
					{
						String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
						str_tot_rec="1";
						//String downtime_slmt_yn="";

						//debetor_catagory_code=episode_type
						//String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+str_doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no.get(i)+"','"+rtn_str_slmt_doc_amt.get(i)+"','"+rtn_str_slmt_type_code.get(i)+"','"+rtn_str_slmt_doc_ref_desc.get(i)+"','"+rtn_str_slmt_doc_ref_date.get(i)+"','"+rtn_str_slmt_doc_remarks.get(i)+"','"+rtn_str_app_ref_no.get(i)+"','"+rtn_str_cash_slmt_flag.get(i)+"','"+rtn_str_cc_batch_no.get(i)+"','"+rtn_str_cc_sale_draft_no.get(i)+"','"+rtn_str_cc_swipped_yn.get(i)+"','"+rtn_str_bank_code.get(i)+"','"+rtn_str_bank_branch.get(i)+"','"+rtn_str_cash_amt_given.get(i)+"','"+rtn_str_cash_amt_return.get(i)+"','"+rtn_str_payer_name.get(i)+"','"+rtn_str_rcpt_rfnd_id_no.get(i)+"','"+rtn_str_nominee_name.get(i)+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?)}";
						//Below query is changed by muthu on 25-7-12 against 33868 - Receipt Print
						String sqldoctype="{ call   IBAEHIS.BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+str_doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no.get(i)+"','"+rtn_str_slmt_doc_amt.get(i)+"','"+rtn_str_slmt_type_code.get(i)+"','"+rtn_str_slmt_doc_ref_desc.get(i)+"','"+rtn_str_slmt_doc_ref_date.get(i)+"','"+rtn_str_slmt_doc_remarks.get(i)+"','"+rtn_str_app_ref_no.get(i)+"','"+rtn_str_cash_slmt_flag.get(i)+"','"+rtn_str_cc_batch_no.get(i)+"','"+rtn_str_cc_sale_draft_no.get(i)+"','"+rtn_str_cc_swipped_yn.get(i)+"','"+rtn_str_bank_code.get(i)+"','"+rtn_str_bank_branch.get(i)+"','"+rtn_str_cash_amt_given.get(i)+"','"+rtn_str_cash_amt_return.get(i)+"','"+rtn_str_payer_name.get(i)+"','"+rtn_str_rcpt_rfnd_id_no.get(i)+"','"+rtn_str_nominee_name.get(i)+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?)}";
					
						cstmt = con.prepareCall(sqldoctype);
						cstmt.setString(1,cash_counter_code);
						cstmt.setString(2,shift_id);
						cstmt.setString(3,str_session_id);
						cstmt.setString(4,str_pgm_date);				
				
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						
						cstmt.execute();
						

						cash_counter_code = cstmt.getString(1);
						shift_id = cstmt.getString(2);
						str_session_id = cstmt.getString(3);
						str_pgm_date  = cstmt.getString(4);					
						str_doc_type_code = cstmt.getString(5);
						str_doc_no=cstmt.getString(6);
						rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
						str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						str_error_level=cstmt.getString(9);
						str_sysmesage_id=cstmt.getString(10);					
						str_error_text=cstmt.getString(11);

						if(cash_counter_code==null) cash_counter_code="";
						if(shift_id==null) shift_id="";
						if(str_session_id==null) str_session_id="";
						if(str_pgm_date==null) str_pgm_date="";
						if(str_doc_type_code==null) str_doc_type_code="";
						if(str_doc_no==null) str_doc_no="";					
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";//Added by muthu on 25-7-12 Receipt
						if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";//Added by muthu on 25-7-12 Receipt


						
						cstmt.close();

						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}
						else
						{
							insertable = true;
							gen_doc_type = str_doc_type_code;
							gen_doc_num = str_doc_no;
							gen_prt_format = str_rec_prt_format_vals;//Added by muthu on 25-7-12 Receipt
							final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;


						}
				
					//	Object SiteSpecific_PkgDep; 46449
						if(SiteSpec_PkgDep && list.size() > 0){
							
							if(insertable)
							{
								
								
								String sqlpkgdep1  ="{ call   IBAEHIS.blpackage.updatepackSeqInDeposit(?,?,?,?,?,?,?)}";
									CallableStatement cstmt = con.prepareCall(sqlpkgdep1);							
									cstmt.setString(1,facility_id);
									if(list.size() == 1) {								
										cstmt.setString(2,list.get(0));
									} else {
										try {
											cstmt.setString(2,list.get(0));
										} catch(ArrayIndexOutOfBoundsException ex) {
											cstmt.setString(2,list.get(0));
										}
									}
									//System.out.println("str_error_level blpackage.UpdatePackSub:"+list.get(i));
									cstmt.setString(3,str_doc_type_code);
									cstmt.setString(4,str_doc_no);
									//cstmt.setString(5,doc_amt);
									cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
									cstmt.execute();	
									str_error_level=cstmt.getString(5);
									str_sysmesage_id=cstmt.getString(6);					
									str_error_text=cstmt.getString(7);
									
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									System.out.println("str_error_level blpackage.UpdatePackSub:"+str_error_level);
									System.out.println("str_sysmesage blpackage.UpdatePackSub:"+str_sysmesage_id);
									System.out.println("str_error_text blpackage.UpdatePackSub"+str_error_text);
									cstmt.close();

									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
									}
									else
									{
										insertable = true;
									}
								
							/*	while(pksequenceNum1.hasMoreTokens()){

									String arr[] = pksequenceNum1.nexttokens();
									
									//System.out.println("str_error_level blpackage.UpdatePackSub:"+arr[].to);
									
								}*/
								
			
							
							}
							}
						
						
						
					}//end insertable
					/*********************added for PACKAGE BILLING **************************************/
					if(insertable)
					{
						if(!pkgSequenceNumber.equals(""))
						{
							String sqlpkgdep  ="{ call   IBAEHIS.blpackage.UpdatePackSub(?,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlpkgdep);							
							
							cstmt.setString(1,facility_id);
							cstmt.setString(2,pkgSequenceNumber);
							cstmt.setString(3,str_doc_type_code);
							cstmt.setString(4,str_doc_no);
							cstmt.setString(5,str_doc_amt);
							cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
							cstmt.execute();	
							str_error_level=cstmt.getString(6);
							str_sysmesage_id=cstmt.getString(7);					
							str_error_text=cstmt.getString(8);
							
							System.out.println("str_error_text / str_sysmesage_id"+str_error_text+"/"+str_sysmesage_id);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								
							}
							else
							{
								insertable = true;
							}
					}//package seq chk
					}//insertable
					}//end for
				}
				catch(Exception e)
				{
					insertable=false;
					sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
					System.out.println("Exception in Proc Call 1st :"+e);
				}
				}else{

					String rtn_str_slmt_doc_amt = (String)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
					if(rtn_str_slmt_doc_amt==null) rtn_str_slmt_doc_amt="";

					String rtn_str_slmt_type_code = (String)mult_slmt_vals.get("rtn_str_slmt_type_code");
					if(rtn_str_slmt_type_code==null) rtn_str_slmt_type_code="";

					String rtn_str_slmt_doc_ref_date = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
					if(rtn_str_slmt_doc_ref_date==null) rtn_str_slmt_doc_ref_date="";


					String rtn_str_slmt_doc_ref_desc = (String)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
					if(rtn_str_slmt_doc_ref_desc==null) rtn_str_slmt_doc_ref_desc="";


					String rtn_str_slmt_doc_remarks = (String)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
					if(rtn_str_slmt_doc_remarks==null) rtn_str_slmt_doc_remarks="";


					String rtn_str_app_ref_no = (String)mult_slmt_vals.get("rtn_str_app_ref_no");
					if(rtn_str_app_ref_no==null) rtn_str_app_ref_no="";


					String rtn_str_cash_slmt_flag = (String)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
					if(rtn_str_cash_slmt_flag==null) rtn_str_cash_slmt_flag="";

					String rtn_str_cc_batch_no = (String)mult_slmt_vals.get("rtn_str_cc_batch_no");
					if(rtn_str_cc_batch_no==null) rtn_str_cc_batch_no="";


					String rtn_str_cc_sale_draft_no = (String)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");
					if(rtn_str_cc_sale_draft_no==null) rtn_str_cc_sale_draft_no="";

					String rtn_str_cc_swipped_yn = (String)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
					if(rtn_str_cc_swipped_yn==null) rtn_str_cc_swipped_yn="";


					String rtn_str_bank_code = (String)mult_slmt_vals.get("rtn_str_bank_code");
					if(rtn_str_bank_code==null) rtn_str_bank_code="";


					String rtn_str_bank_branch = (String)mult_slmt_vals.get("rtn_str_bank_branch");
					if(rtn_str_bank_branch==null) rtn_str_bank_branch="";


					String rtn_str_cash_amt_given = (String)mult_slmt_vals.get("rtn_str_cash_amt_given");
					if(rtn_str_cash_amt_given==null) rtn_str_cash_amt_given="";


					String rtn_str_cash_amt_return = (String)mult_slmt_vals.get("rtn_str_cash_amt_return");
					if(rtn_str_cash_amt_return==null) rtn_str_cash_amt_return="";


					String rtn_str_payer_name = (String)mult_slmt_vals.get("rtn_str_payer_name");
					if(rtn_str_payer_name==null) rtn_str_payer_name="";


					String rtn_str_rcpt_rfnd_id_no = (String)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
					if(rtn_str_rcpt_rfnd_id_no==null) rtn_str_rcpt_rfnd_id_no="";


					String rtn_str_nominee_name = (String)mult_slmt_vals.get("rtn_str_nominee_name");
					if(rtn_str_nominee_name==null) rtn_str_nominee_name="";

					String rtn_str_doc_sr_no = (String)mult_slmt_vals.get("rtn_str_doc_sr_no");
					if(rtn_str_doc_sr_no==null) rtn_str_doc_sr_no="";


		
			
				/*try
				{
				
					cstmt = con.prepareCall("{ call BLCORE.GENERATE_SEQUENCE_COMMON_PROC(?,?,?,?,?)}");

					cstmt.setString(1,facility_id);
					
					if(episode_type.equals("O") || episode_type.equals("E"))
					{
						cstmt.setString(2,"DIRECT_OP");
						cstmt.setString(3,"BL-OPDE");
					}
					else if(episode_type.equals("I") || episode_type.equals("D"))
					{
						cstmt.setString(2,"DIRECT_IP");
						cstmt.setString(3,"BL-IPDE");
					}
					else
					{
						cstmt.setString(2,"DIRECT_RF");
						cstmt.setString(3,"BL-RFDE");
					}

					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);

					cstmt.execute();

					errText = "";
					
					str_trx_doc_ref = cstmt.getString(4);
					errText = cstmt.getString(5);

					if(str_trx_doc_ref == null) str_trx_doc_ref="";
					if(errText == null) errText="";

					System.out.println("str_trx_doc_ref:"+str_trx_doc_ref);
					System.out.println("errCode:"+errCode);
					
					cstmt.close();

					if(!errText.equals(""))
					{
						insertable = false;
					}
					else
					{
						insertable = true;
					}
				}
				catch (Exception e)
				{
					insertable = false;
					sys_err.append("Exception while calling GENERATE_SEQUENCE_COMMON_PROC:"+e);
					System.out.println("Exception while calling GENERATE_SEQUENCE_COMMON_PROC:"+e);
				}*/


				insertable = true;
	/**************added for CRF-13**************************/
				try{
					if(hand_without_counter_chk_out.equals("Y")){
					if(insertable)
					{
						String str_rcpt_doc_amt = rtn_str_slmt_doc_amt.replace("|","~");
						String str_slmt_type_code = rtn_str_slmt_type_code.replace("|","~");

						cstmt = con.prepareCall("{ call IBAEHIS.bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,facility_id);
						cstmt.setString(2,user_id);
						cstmt.setString(3,cash_counter_code);
						cstmt.setString(4,str_slmt_type_code);
						cstmt.setString(5,str_rcpt_doc_amt);					

						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);	
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						
						cstmt.execute();	
								
						str_error_level		 = cstmt.getString(6);		
						str_sysmesage_id	 = cstmt.getString(7);		
						str_error_text     	 = cstmt.getString(8);				
						
						if ( str_error_level  == null ) str_error_level = "";
						if ( str_sysmesage_id == null ) str_sysmesage_id ="";
						if ( str_error_text	  == null ) str_error_text ="";

					if ((str_error_level.equals("10") && (!str_error_text.equals(""))) ||!str_sysmesage_id.equals(""))
					{
						if(str_error_level.equals("10") && (!str_error_text.equals("")))
						{
							insertable = false;
						}
							if(!str_sysmesage_id.equals(""))
							{
								if(	str_sysmesage_id.equals("BL7340")){
									str_sysmesage_id_limit="BL7340";
									insertable = true;
								}else{
									str_sysmesage_id_limit="";
									insertable = false;
									}
						
							}

						
					}
				}//insertable
			}//if
				}catch(Exception ee)
					{
						insertable=false;
					sys_err.append(" Exception while calling bl_proc_check_lmt:"+ee);
					System.out.println("Exception in Proc bl_proc_check_lmt Call:"+ee);;
					}
		/*************End*******************************************/		
				try
				{
					if(insertable)
					{
						String cash_counter_facility_id="", cc_count="",cc_refund_ded_amt="",calling_function_id="EBL_ENTER_RECEIPT_REFUND";
						//debetor_catagory_code=episode_type
						//String downtime_slmt_yn="";
						//String sqldoctype="{ call   BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no+"','"+rtn_str_slmt_doc_amt+"','"+rtn_str_slmt_type_code+"','"+rtn_str_slmt_doc_ref_desc+"','"+rtn_str_slmt_doc_ref_date+"','"+rtn_str_slmt_doc_remarks+"','"+rtn_str_app_ref_no+"','"+rtn_str_cash_slmt_flag+"','"+rtn_str_cc_batch_no+"','"+rtn_str_cc_sale_draft_no+"','"+rtn_str_cc_swipped_yn+"','"+rtn_str_bank_code+"','"+rtn_str_bank_branch+"','"+rtn_str_cash_amt_given+"','"+rtn_str_cash_amt_return+"','"+rtn_str_payer_name+"','"+rtn_str_rcpt_rfnd_id_no+"','"+rtn_str_nominee_name+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?)}";
						//Below query is changed by muthu on 25-7-12 against 33868 - Receipt Print
						String sqldoctype="{ call   IBAEHIS.BL_INSERT_DEPOSIT.BL_INSERT_DEPOSIT_BUILD_TABLE('"+facility_id+"','"+rcpt_rfnd_ind+"','"+rcpt_nature_code+"','"+rcpt_type_code+"','"+episode_type+"','"+episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+cash_counter_facility_id+"','"+cash_counter_code+"','"+shift_id+"','"+doc_amt+"','"+cc_refund_ded_amt+"','"+narration+"','"+ip_adm_trf_dep_ind+"','"+rec_ref_format_ind+"','"+rfnd_dep_in_use_yn+"','"+pmnt_thru_mail+"','"+ext_acc_facility_id+"','"+ext_acc_code+"','"+ext_acc_dept_code+"','"+mult_slmt_yn+"','"+downtime_entry_yn+"','"+downtime_reason_code+"','"+downtime_doc_type_code+"','"+downtime_doc_num+"','"+downtime_doc_date+"','"+cc_machine_id+"','"+payers_add1+"','"+payers_add2+"','"+payers_add3+"','"+payers_tel_num+"','"+consolidated_receipt_yn+"','"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+user_id+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"','"+rtn_str_doc_sr_no+"','"+rtn_str_slmt_doc_amt+"','"+rtn_str_slmt_type_code+"','"+rtn_str_slmt_doc_ref_desc+"','"+rtn_str_slmt_doc_ref_date+"','"+rtn_str_slmt_doc_remarks+"','"+rtn_str_app_ref_no+"','"+rtn_str_cash_slmt_flag+"','"+rtn_str_cc_batch_no+"','"+rtn_str_cc_sale_draft_no+"','"+rtn_str_cc_swipped_yn+"','"+rtn_str_bank_code+"','"+rtn_str_bank_branch+"','"+rtn_str_cash_amt_given+"','"+rtn_str_cash_amt_return+"','"+rtn_str_payer_name+"','"+rtn_str_rcpt_rfnd_id_no+"','"+rtn_str_nominee_name+"','"+user_id+"','"+facility_id+"','"+locale+"','"+client_ip_address+"',?,?,'"+cc_count+"','"+calling_function_id+"',?,?,'"+str_tot_rec+"',?,?,?,?,?,?,?)}";
					
						cstmt = con.prepareCall(sqldoctype);
						cstmt.setString(1,cash_counter_code);
						cstmt.setString(2,shift_id);
						cstmt.setString(3,str_session_id);
						cstmt.setString(4,str_pgm_date);	
				
						cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);					
						cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);//Added by muthu on 25-7-12 Receipt
						
						cstmt.execute();

						cash_counter_code = cstmt.getString(1);
						shift_id = cstmt.getString(2);
						str_session_id = cstmt.getString(3);
						str_pgm_date  = cstmt.getString(4);					
						str_doc_type_code = cstmt.getString(5);
						str_doc_no=cstmt.getString(6);
						rec_print_format_enabled_yn=cstmt.getString(7);//Added by muthu on 25-7-12 Receipt
						str_rec_prt_format_vals=cstmt.getString(8);//Added by muthu on 25-7-12 Receipt
						str_error_level=cstmt.getString(9);
						str_sysmesage_id=cstmt.getString(10);					
						str_error_text=cstmt.getString(11);


						if(cash_counter_code==null) cash_counter_code="";
						if(shift_id==null) shift_id="";
						if(str_session_id==null) str_session_id="";
						if(str_pgm_date==null) str_pgm_date="";
						if(str_doc_type_code==null) str_doc_type_code="";
						if(str_doc_no==null) str_doc_no="";					
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(rec_print_format_enabled_yn==null) rec_print_format_enabled_yn="";//Added by muthu on 25-7-12 Receipt
						if(str_rec_prt_format_vals==null) str_rec_prt_format_vals="";//Added by muthu on 25-7-12 Receipt


						cstmt.close();

						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insertable=false;
						}
						else
						{
							insertable = true;
							gen_doc_type = str_doc_type_code;
							gen_doc_num = str_doc_no;
							gen_prt_format = str_rec_prt_format_vals;//Added by muthu on 25-7-12 Receipt
							final_msg_doc_type_code =final_msg_doc_type_code+"::"+str_doc_type_code+"/"+str_doc_no;
						}
					}//INSERTABLE
					
	/********************added for package deposit ******************************/
					if(insertable)
					{
						if(!pkgSequenceNumber.equals(""))
						{
							

							String sqlpkgdep  ="{ call   IBAEHIS.blpackage.UpdatePackSub(?,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlpkgdep);							
							cstmt.setString(1,facility_id);
							cstmt.setString(2,pkgSequenceNumber);
							cstmt.setString(3,str_doc_type_code);
							cstmt.setString(4,str_doc_no);
							cstmt.setString(5,doc_amt);
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
							System.out.println("str_error_level blpackage.UpdatePackSub:"+str_error_level);
							System.out.println("str_sysmesage blpackage.UpdatePackSub:"+str_sysmesage_id);
							System.out.println("str_error_text blpackage.UpdatePackSub"+str_error_text);
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
							}
							else
							{
								insertable = true;
							}
						}//pakg seq test
					}//insertable

				}
				catch(Exception e)
				{
					insertable=false;
					sys_err.append(" Exception while calling BL_INSERT_DEPOSIT_BUILD_TABLE:"+e);
					System.out.println("Exception in Proc Call 2nd :"+e);
				}
			}// end else 
				if(insertable)
				{
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
				System.out.println("Main Exception:"+e);
			}
			
			finally 
			{
				System.out.println("finally");
				if (con != null)
					ConnectionManager.returnConnection(con, p);
			}
					
			return_mess.put("status",new Boolean(insertable));
			return_mess.put("error",str_error_text);
			return_mess.put("sys_error",sys_err.toString());
			return_mess.put("message",str_sysmesage_id);
			return_mess.put("message1",str_sysmesage_id_limit);
			return_mess.put("gen_doc_type",gen_doc_type);
			return_mess.put("gen_doc_num",gen_doc_num);
			return_mess.put("final_msg_doc_type_code",final_msg_doc_type_code);
			return_mess.put("gen_prt_format",gen_prt_format);//Added by muthu on 25-7-12 Receipt
			return_mess.put("rec_print_format_enabled_yn",rec_print_format_enabled_yn);//Added by muthu on 25-7-12 Receipt
			return_mess.put("str_rec_prt_format_vals",str_rec_prt_format_vals);//Added by muthu on 25-7-12 Receipt
			return return_mess;
		}
	}