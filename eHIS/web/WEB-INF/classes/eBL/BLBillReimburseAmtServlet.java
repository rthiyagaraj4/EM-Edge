/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;

public class BLBillReimburseAmtServlet extends javax.servlet.http.HttpServlet 
{

	PrintWriter out;

	java.util.Properties p;

	HttpSession session;

	Connection con;

	PreparedStatement pstmt;

	ResultSet rs;	

	HashMap support_data = new HashMap();
	//HashMap sel_serv_panel_data = new HashMap();
	HashMap ind_reimb_dtls = new HashMap();
	Hashtable messageHashtable=new Hashtable();
	String msg="";

	StringBuffer sb = new StringBuffer();

	String str_facility_id, str_client_ip_address, str_user_id ;

	String locale;

	String sStyle = "";

	String str_module_id = "", str_function_id = "", str_audit_no = "", str_trx_doc_ref = "" , str_trx_doc_ref_line_num = "", str_trx_doc_ref_seq_num = ""; String str_episode_type = "", str_patient_id = "", str_episode_id = "", str_visit_id = "", str_encounter_id = "";
	String str_bill_doc_type = "", str_bill_doc_num = "", str_query_string = "";//, str_blng_serv_code = "";
//	String str_reimbursable_yn_old = "", str_reimbursable_yn = "", str_reimbursable_ind_old = "", str_reimbursable_ind = "";
//	String str_old_reim_amt = "", str_rev_amt = "", str_reason_code = "";

	String str_tot_rec="";

	String str_error_level = "", str_error_text = "", str_sys_message_id = "";
	
	int totalRecords=0;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");

		this.str_facility_id = (String) session.getValue("facility_id");
		if(str_facility_id == null) str_facility_id="";

		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";

		str_client_ip_address = p.getProperty("client_ip_address");
		if(str_client_ip_address == null) str_client_ip_address="";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";

		//String attributes[] = session.getValueNames();
		locale = p.getProperty("LOCALE");

		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			
			updateReimbursementDtls(req, res);

		} 
		catch (Exception e) 
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		} 
	}

	private void updateReimbursementDtls(HttpServletRequest req,HttpServletResponse res) throws SQLException
	{
		try 
		{
			con	=	ConnectionManager.getConnection(req);

			java.util.Locale loc = new java.util.Locale(locale);
//			java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
			java.util.ResourceBundle sm_messages = java.util.ResourceBundle.getBundle("eSM.resources.Messages",loc);
//			String gen_receipt = (String)bl_labels.getString("eBL.DOC_GEN.label");
			String rec_mod_mess = (String) sm_messages.getString("RECORD_MODIFIED");

			String sys_error = "";

//			System.err.println("Main 1");
			getData(req);
//			System.err.println("Main 2");
			InsertSupportdata();
//			System.err.println("Main 3");	
			
			boolean inserted = true;
			boolean inserted_rec = true;
			CallableStatement call = null;
			
			for (int i=0;i<totalRecords;i++)
			{
				String p_blng_serv_code = req.getParameter("blng_serv_code_"+i);
				if(p_blng_serv_code == null) p_blng_serv_code="";
//				System.err.println("****p_blng_serv_code:"+p_blng_serv_code);
				
				String p_blng_grp_id = req.getParameter("blng_grp_id_"+i);
				if(p_blng_grp_id == null) p_blng_grp_id="";
//				System.err.println("****p_blng_grp_id:"+p_blng_grp_id);

				String p_trx_doc_ref = req.getParameter("trx_doc_ref_"+i);
				if(p_trx_doc_ref == null) p_trx_doc_ref="";
//				System.err.println("****p_trx_doc_ref:"+p_trx_doc_ref);

				String p_trx_doc_ref_line_num = req.getParameter("trx_doc_ref_line_num_"+i);
				if(p_trx_doc_ref_line_num == null) p_blng_serv_code="";
//				System.err.println("****p_trx_doc_ref_line_num:"+p_trx_doc_ref_line_num);

				String p_trx_doc_ref_seq_num = req.getParameter("trx_doc_ref_seq_num_"+i);
				if(p_trx_doc_ref_seq_num == null) p_trx_doc_ref_seq_num="";
//				System.err.println("****p_trx_doc_ref_seq_num:"+p_trx_doc_ref_seq_num);

				String p_reimbursable_yn_old = req.getParameter("rtn_stup_reimb_YN_"+i);
				if(p_reimbursable_yn_old == null) p_reimbursable_yn_old="N";
//				System.err.println("****p_reimbursable_yn_old:"+p_reimbursable_yn_old);

				String p_reimbursable_ind_old = req.getParameter("rtn_stup_reimb_type_"+i);
				if(p_reimbursable_ind_old == null) p_reimbursable_ind_old="N";
//				System.err.println("****p_reimbursable_ind_old:"+p_reimbursable_ind_old);

				String p_old_reim_amt = req.getParameter("rtn_stup_reimb_amt_"+i);
				if(p_old_reim_amt == null) p_old_reim_amt="0";
//				System.err.println("****p_old_reim_amt:"+p_old_reim_amt);

				String p_reimbursable_yn_curr = req.getParameter("rtn_curr_reimb_YN_"+i);
				if(p_reimbursable_yn_curr == null) p_reimbursable_yn_curr="N";
//				System.err.println("****p_reimbursable_yn_curr:"+p_reimbursable_yn_curr);

				String p_reimbursable_ind_curr = req.getParameter("rtn_curr_reimb_type_"+i);
				if(p_reimbursable_ind_curr == null) p_reimbursable_ind_curr="N";
//				System.err.println("****p_reimbursable_ind_curr:"+p_reimbursable_ind_curr);

				String p_rev_amt = req.getParameter("rtn_curr_rev_amt_"+i);
				if(p_rev_amt == null) p_rev_amt="0";
//				System.err.println("****p_rev_amt:"+p_rev_amt);

				String p_reason_code = req.getParameter("reimb_reason_code_"+i);
				if(p_reason_code == null) p_reason_code="";
//				System.err.println("****p_reason_code:"+p_reason_code);

				String p_serv_module_id = req.getParameter("serv_module_id_"+i);
				if(p_serv_module_id == null) p_serv_module_id="";
//				System.err.println("****p_serv_module_id:"+p_serv_module_id);
				
				if(inserted && inserted_rec)
				{
					try
					{
						call = con.prepareCall("{ call BLCORE.GENERATE_SEQUENCE_COMMON_PROC(?,?,?,?,?) }");	

						call.setString(1,str_facility_id);
						call.setString(2,"REIM_AUDIT_NO");
						call.setString(3,"REIMB");
						call.registerOutParameter(4,java.sql.Types.VARCHAR); 
						call.registerOutParameter(5,java.sql.Types.VARCHAR);

						call.execute();

						str_audit_no = 	call.getString(4);		
						if(str_audit_no == null) str_audit_no="";
//						System.err.println("str_audit_no====:"+str_audit_no);
						str_error_text = 	call.getString(5);		
						if(str_error_text == null) str_error_text="";
//						System.err.println("str_error_text====:"+str_error_text);
						call.close();

						if(!str_error_text.equals(""))
						{
							inserted = false;
						}
						else
						{
							inserted = true;
						}
					}
					catch (Exception e)
					{
						inserted = false;
						System.err.println("Error while Generating Audit Seq No:"+e);
						sys_error = "Error while Generating Audit Seq No:"+e;
					}
				}

				if(inserted && inserted_rec)
				{
					try
					{
						call = con.prepareCall("{ call BLCORE.BL_PROC_CALC_REIM_AMT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
						call.setString(1,str_facility_id);
						call.setString(2,str_function_id);
						call.setString(3,p_serv_module_id);
						call.setString(4,str_audit_no);
						call.setString(5,p_trx_doc_ref);
						call.setString(6,p_trx_doc_ref_line_num);
						call.setString(7,p_trx_doc_ref_seq_num);
						call.setString(8,str_episode_type);
						call.setString(9,str_patient_id);
						call.setString(10,str_episode_id);
						call.setString(11,str_visit_id);
						call.setString(12,str_encounter_id);
						call.setString(13,p_blng_grp_id);
						call.setString(14,str_bill_doc_type);
						call.setString(15,str_bill_doc_num);
						call.setString(16,p_blng_serv_code);
						call.setString(17,p_reimbursable_yn_old);
						call.setString(18,p_reimbursable_yn_curr);
						call.setString(19,p_reimbursable_ind_old);
						call.setString(20,p_reimbursable_ind_curr);
						call.setString(21,p_old_reim_amt);
						call.setString(22,p_rev_amt);
						call.setString(23,p_reason_code);
						call.setString(24,str_user_id);
						call.setString(25,str_client_ip_address);
						call.registerOutParameter(26,java.sql.Types.VARCHAR); 
						call.registerOutParameter(27,java.sql.Types.VARCHAR); 
						call.registerOutParameter(28,java.sql.Types.VARCHAR);

						call.execute();

						str_sys_message_id = 	call.getString(26);		
						if(str_sys_message_id == null) str_sys_message_id="";
						str_error_level = 	call.getString(27);		
						if(str_error_level == null) str_error_level="";
						str_error_text = 	call.getString(28);		
						if(str_error_text == null) str_error_text="";

//						System.err.println("****str_sys_message_id:"+str_sys_message_id);
//						System.err.println("****str_error_level:"+str_error_level);
//						System.err.println("****str_error_text:"+str_error_text);

						call.close();
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
//								System.err.println("****Inside Error Text Loop");
								inserted = false;
								inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
//								System.err.println("****Inside Sys Message Loop");
								inserted = false;
								inserted_rec = false;
							}
						}
						else
						{
//							System.err.println("****Inside Rec Success Loop");
							inserted = true;
							inserted_rec = true;
						}
					}
					catch(Exception e)
					{
						inserted = false;
						inserted_rec = false;
						System.err.println(" Err: BL_PROC_CALC_REIM_AMT: "+e);
						sys_error = sys_error + " Err: BL_PROC_CALC_REIM_AMT: "+e;
					}
				}
			}
//			System.err.println("**** Reimbursment Success = "+inserted);
/*			
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			System.err.println("ejb call 1");

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/EnterReceiptRefund",eBL.EnterReceiptRefund.EnterReceiptRefundHome.class, local_ejbs);
			System.err.println("ejb call 2");

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			System.err.println("ejb call 3");

			Object argArray[] = new Object[3];

			System.err.println("ejb call 4");
					
			argArray[0] = p;
			argArray[1] = support_data;
			argArray[2] = ind_reimb_dtls;
			
			System.err.println("ejb call 5");
			Class[] paramArray = new Class[3];

			paramArray[0] = p.getClass();
			paramArray[1] = support_data.getClass();
			paramArray[2] = ind_reimb_dtls.getClass();
			System.err.println("ejb call 6");	

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status")).booleanValue());

			String str_error_level = (String) results.get("error_level");
			String str_error_text = (String) results.get("error_text");
			String str_sys_message_id = (String) results.get("sys_message_id");

			System.err.println("inserted:"+inserted);
			System.err.println("str_error_level:"+str_error_level);
			System.err.println("str_error_text:"+str_error_text);
			System.err.println("str_sys_message_id:"+str_sys_message_id);
*/
			if(inserted && inserted_rec)
			{
				con.commit();
//				String final_message=gen_receipt+" "+final_msg_doc_type_code;

//				out.println("<script>alert('"+final_message+"')</script>");
				out.println("<script>alert('"+rec_mod_mess+"')</script>");
				out.println("<script>parent.parent.parent.document.getElementById('dialog_tag').close();</script>");
			}
			else
			{
				con.rollback();
				if(!str_error_level.equals("") && !str_error_text.equals(""))
				{
					out.println("<script>parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
				}
				else if(!str_sys_message_id.equals(""))
				{
					messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
					msg=(String)messageHashtable.get("message");

					out.println("<script>parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
				}

				if(!sys_error.equals(""))
				{
					out.println("<script>parent.parent.frames[0].location.href='../eCommon/jsp/commonToolbar.jsp?"+str_query_string+"';parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( sys_error.toString(), "UTF-8" )+ "<br>'</script>");
				}
			}
			ConnectionManager.returnConnection(con, req);
		} 
		catch (Exception e) 
		{
			System.err.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");
		} 
	}
		
	public void getData(HttpServletRequest req)
	{     
//		System.err.println("getData 1");

		str_patient_id= req.getParameter("patient_id");
		if(str_patient_id==null) str_patient_id="";		

		str_visit_id=req.getParameter("visit_id");
		if(str_visit_id==null) str_visit_id="";

		str_episode_id=req.getParameter("episode_id");
		if(str_episode_id==null) str_episode_id="";

		str_episode_type=req.getParameter("episode_type");
		if(str_episode_type==null) str_episode_type="";

		str_encounter_id=req.getParameter("encounter_id");
		if(str_encounter_id==null) str_encounter_id="";

		str_module_id=req.getParameter("module_id");
		if(str_module_id==null) str_module_id="";

		str_function_id=req.getParameter("function_id");
		if(str_function_id==null) str_function_id="";

		str_bill_doc_type=req.getParameter("bill_doc_type_code");
		if(str_bill_doc_type==null) str_bill_doc_type="";

		str_bill_doc_num=req.getParameter("bill_doc_num");
		if(str_bill_doc_num==null) str_bill_doc_num="";

		str_query_string = req.getParameter("query_string");
		if(str_query_string==null) str_query_string="";

//		System.err.println("getData 4");
		str_tot_rec = req.getParameter("total_records");
		if(str_tot_rec == null) str_tot_rec="0";
		totalRecords = Integer.parseInt(str_tot_rec);
//		System.err.println("totalRecords servlet" +totalRecords);

		GetIndReimbDtls(totalRecords,req);

	}
	public void InsertSupportdata() 
	{
		support_data.clear();
		support_data.put("facility_id",str_facility_id);
		support_data.put("locale",locale);
		support_data.put("patient_id",str_patient_id);		
		support_data.put("visit_id",str_visit_id);
		support_data.put("episode_id",str_episode_id);
		support_data.put("episode_type",str_episode_type);
		support_data.put("encounter_id",str_encounter_id);
		support_data.put("module_id",str_module_id); 
		support_data.put("bill_doc_type",str_bill_doc_type); 
		support_data.put("bill_doc_num",str_bill_doc_num); 
		support_data.put("user_id",str_user_id);
		support_data.put("client_ip_address",str_client_ip_address);
		support_data.put("str_tot_rec",str_tot_rec);
//		System.err.println("support_data 1"+support_data);
	}

	public void GetIndReimbDtls(int totalRecords,HttpServletRequest req)
	{
		ind_reimb_dtls.clear();
//		System.err.println("ind_reimb_dtls 1"+ind_reimb_dtls);

		ArrayList rtn_blng_serv_code=new ArrayList();
		ArrayList rtn_trx_doc_ref=new ArrayList();
		ArrayList rtn_trx_doc_ref_line_num=new ArrayList();
		ArrayList rtn_trx_doc_ref_seq_num=new ArrayList();
		ArrayList rtn_reimbursable_yn_old=new ArrayList();
		ArrayList rtn_reimbursable_ind_old=new ArrayList();
		ArrayList rtn_old_reim_amt=new ArrayList();
		ArrayList rtn_reimbursable_yn_curr=new ArrayList();
		ArrayList rtn_reimbursable_ind_curr=new ArrayList();
		ArrayList rtn_rev_amt=new ArrayList();
		ArrayList rtn_reason_code=new ArrayList();
		ArrayList rtn_blng_grp=new ArrayList();

		for(int i=0;i<totalRecords;i++)
		{		
			String str_blng_serv_code = req.getParameter("blng_serv_code_"+i);
			if(str_blng_serv_code == null) str_blng_serv_code="";
			rtn_blng_serv_code.add(str_blng_serv_code+"|");
//			System.err.println("rtn_blng_serv_code mult:"+rtn_blng_serv_code);

			String str_trx_doc_ref = req.getParameter("trx_doc_ref_"+i);
			if(str_trx_doc_ref == null) str_trx_doc_ref="";
			rtn_trx_doc_ref.add(str_trx_doc_ref+"|");
//			System.err.println("rtn_trx_doc_ref mult:"+rtn_trx_doc_ref);

			String str_trx_doc_ref_line_num = req.getParameter("trx_doc_ref_line_num_"+i);
			if(str_trx_doc_ref_line_num == null) str_blng_serv_code="";
			rtn_trx_doc_ref_line_num.add(str_trx_doc_ref_line_num+"|");
//			System.err.println("rtn_trx_doc_ref_line_num mult:"+rtn_trx_doc_ref_line_num);

			String str_trx_doc_ref_seq_num = req.getParameter("trx_doc_ref_seq_num_"+i);
			if(str_trx_doc_ref_seq_num == null) str_trx_doc_ref_seq_num="";
			rtn_trx_doc_ref_seq_num.add(str_trx_doc_ref_seq_num+"|");
//			System.err.println("rtn_trx_doc_ref_seq_num mult:"+rtn_trx_doc_ref_seq_num);

			String str_reimbursable_yn_old = req.getParameter("reimbursable_yn_old_"+i);
			if(str_reimbursable_yn_old == null) str_reimbursable_yn_old="";
			rtn_reimbursable_yn_old.add(str_reimbursable_yn_old+"|");
//			System.err.println("rtn_reimbursable_yn_old mult:"+rtn_reimbursable_yn_old);

			String str_reimbursable_ind_old = req.getParameter("reimbursable_ind_old_"+i);
			if(str_reimbursable_ind_old == null) str_reimbursable_ind_old="";
			rtn_reimbursable_ind_old.add(str_reimbursable_ind_old+"|");
//			System.err.println("rtn_reimbursable_ind_old mult:"+rtn_reimbursable_ind_old);

			String str_old_reim_amt = req.getParameter("old_reim_amt_"+i);
			if(str_old_reim_amt == null) str_old_reim_amt="";
			rtn_old_reim_amt.add(str_old_reim_amt+"|");
//			System.err.println("rtn_old_reim_amt mult:"+rtn_old_reim_amt);

			String str_reimbursable_yn_curr = req.getParameter("rtn_reimbursable_yn_curr_"+i);
			if(str_reimbursable_yn_curr == null) str_reimbursable_yn_curr="";
			rtn_reimbursable_yn_curr.add(str_reimbursable_yn_curr+"|");
//			System.err.println("rtn_reimbursable_yn_curr mult:"+rtn_reimbursable_yn_curr);

			String str_reimbursable_ind_curr = req.getParameter("reimbursable_ind_curr_"+i);
			if(str_reimbursable_ind_curr == null) str_reimbursable_ind_curr="";
			rtn_reimbursable_ind_curr.add(str_reimbursable_ind_curr+"|");
//			System.err.println("rtn_reimbursable_ind_curr mult:"+rtn_reimbursable_ind_curr);

			String str_rev_amt = req.getParameter("rev_amt_"+i);
			if(str_rev_amt == null) str_rev_amt="";
			rtn_rev_amt.add(str_rev_amt+"|");
//			System.err.println("rtn_rev_amt mult:"+rtn_rev_amt);

			String str_reason_code = req.getParameter("reason_code_"+i);
			if(str_reason_code == null) str_reason_code="";
			rtn_reason_code.add(str_reason_code+"|");
//			System.err.println("rtn_reason_code mult:"+rtn_reason_code);

			String str_blng_grp=req.getParameter("blng_grp_id_"+i);
			if(str_blng_grp == null) str_blng_grp="";
			rtn_blng_grp.add(str_blng_grp+"|");
//			System.err.println("rtn_blng_grp mult:"+rtn_blng_grp);

			ind_reimb_dtls.put("rtn_blng_serv_code",rtn_blng_serv_code);
			ind_reimb_dtls.put("rtn_trx_doc_ref",rtn_trx_doc_ref);
			ind_reimb_dtls.put("rtn_trx_doc_ref_line_num",rtn_trx_doc_ref_line_num);
			ind_reimb_dtls.put("rtn_trx_doc_ref_seq_num",rtn_trx_doc_ref_seq_num);
			ind_reimb_dtls.put("rtn_reimbursable_yn_old",rtn_reimbursable_yn_old);
			ind_reimb_dtls.put("rtn_reimbursable_ind_old",rtn_reimbursable_ind_old);
			ind_reimb_dtls.put("rtn_old_reim_amt",rtn_old_reim_amt);
			ind_reimb_dtls.put("rtn_reimbursable_yn_curr",rtn_reimbursable_yn_curr);
			ind_reimb_dtls.put("rtn_reimbursable_ind_curr",rtn_reimbursable_ind_curr);
			ind_reimb_dtls.put("rtn_rev_amt",rtn_rev_amt);
			ind_reimb_dtls.put("rtn_reason_code",rtn_reason_code);
			ind_reimb_dtls.put("blng_grp",rtn_blng_grp);
		}//end of for loop
//		System.err.println("ind_reimb_dtls 2"+ind_reimb_dtls);	
	}
}
