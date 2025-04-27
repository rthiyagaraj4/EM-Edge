<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
try{
	request.setCharacterEncoding("UTF-8");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	HashMap support_data = new HashMap();
	HashMap mult_slmt_vals = new HashMap();
	String facility_id="", client_ip_address="", user_id="" ;
	String locale="";	
	locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	facility_id = (String) session.getValue("facility_id");
	if (facility_id==null) facility_id = "";
	user_id	=  (String) session.getValue("login_user");	
	if (user_id==null) user_id = "";

	client_ip_address = p.getProperty("client_ip_address");
	if (client_ip_address==null) client_ip_address = "";
	String bean_id		= "PkgEnterReceptRefundBean" ;
	String bean_name	= "eBL.PkgEnterReceptRefundBean";
	PkgEnterReceptRefundBean bean			= (PkgEnterReceptRefundBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clearBean();
	putObjectInBean(bean_id,bean,request);
	String patient_id="",  visit_id="", episode_id="", episode_type="", encounter_id="";
	String rcpt_rfnd_ind="", rcpt_nature_code="", cash_counter_code="",	shift_id="", doc_amt="", narration="", ip_adm_trf_dep_ind="", rec_ref_format_ind="", rfnd_dep_in_use_yn="", pmnt_thru_mail="",ext_acc_facility_id="", ext_acc_code="", ext_acc_dept_code="", mult_slmt_yn="", downtime_entry_yn="", downtime_reason_code="", downtime_doc_type_code="", downtime_doc_num="", downtime_doc_date="", cc_machine_id="", payers_add1="", payers_add2="", payers_add3="", payers_tel_num="", consolidated_receipt_yn="",rcpt_type_code="",currdate="";
	String str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="N",hand_without_counter_chk_out="N";
    String  pkgSeqNo="";String str_tot_rec="";	
	int doc_sr_no=1;String str_doc_sr_no ="0",rtn_str_doc_sr_no="";
	int totalRecords=0;
	patient_id= request.getParameter("patient_id");
	if(patient_id==null) patient_id="";		

	visit_id=request.getParameter("visit_id");
	if(visit_id==null) visit_id="";

	episode_id=request.getParameter("episode_id");
	if(episode_id==null) episode_id="";

	episode_type=request.getParameter("episode_type");
	if(episode_type==null) episode_type="";

	encounter_id=request.getParameter("encounter_id");
	if(encounter_id==null) encounter_id="";

	rcpt_rfnd_ind=request.getParameter("rcpt_rfnd_ind");
	if(rcpt_rfnd_ind==null) rcpt_rfnd_ind	="";

	rcpt_nature_code=request.getParameter("rcpt_nature_code");
	if(rcpt_nature_code==null) rcpt_nature_code="";

	cash_counter_code=request.getParameter("cash_counter_code");
	if(cash_counter_code==null) cash_counter_code="";

	shift_id=request.getParameter("shift_id");
	if(shift_id==null) shift_id="";

	doc_amt=request.getParameter("doc_amt");
	if(doc_amt==null) doc_amt="";	

	narration=request.getParameter("narration");
	if(narration==null) narration="";

	ip_adm_trf_dep_ind=request.getParameter("ip_adm_trf_dep_ind");
	if(ip_adm_trf_dep_ind==null) ip_adm_trf_dep_ind="";

	rec_ref_format_ind=request.getParameter("rec_ref_format_ind");
	if(rec_ref_format_ind==null) rec_ref_format_ind="";

	rfnd_dep_in_use_yn=request.getParameter("rfnd_dep_in_use_yn");
	if(rfnd_dep_in_use_yn==null) rfnd_dep_in_use_yn="";

	pmnt_thru_mail=request.getParameter("pmnt_thru_mail");
	if(pmnt_thru_mail==null) pmnt_thru_mail="";	 

	ext_acc_facility_id=request.getParameter("ext_acc_facility_id");
	if(ext_acc_facility_id==null) ext_acc_facility_id="";	 

	ext_acc_code=request.getParameter("ext_acc_code");
	if(ext_acc_code==null) ext_acc_code="";	 

	ext_acc_dept_code=request.getParameter("ext_acc_dept_code");
	if(ext_acc_dept_code==null) ext_acc_dept_code="";	 

	mult_slmt_yn=request.getParameter("mult_slmt_yn");
	if(mult_slmt_yn==null) mult_slmt_yn="";	 

	downtime_entry_yn=request.getParameter("downtime_entry_yn");
	if(downtime_entry_yn==null) downtime_entry_yn="";	 

	downtime_reason_code=request.getParameter("downtime_reason_code");
	if(downtime_reason_code==null) downtime_reason_code="";

	downtime_doc_type_code=request.getParameter("downtime_doc_type_code");
	if(downtime_doc_type_code==null) downtime_doc_type_code="";	 

	downtime_doc_num=request.getParameter("downtime_doc_num");
	if(downtime_doc_num==null) downtime_doc_num="";	 

	downtime_doc_date=request.getParameter("downtime_doc_date");
	if(downtime_doc_date==null) downtime_doc_date="";	
	
	cc_machine_id=request.getParameter("cc_machine_id");
	if(cc_machine_id==null) cc_machine_id="";	 

	payers_add1=request.getParameter("payers_add1");
	if(payers_add1==null) payers_add1="";	

	payers_add2=request.getParameter("payers_add2");
	if(payers_add2==null) payers_add2="";	

	payers_add3=request.getParameter("payers_add3");
	if(payers_add3==null) payers_add3="";	
	
	payers_tel_num=request.getParameter("payers_tel_num");
	if(payers_tel_num==null) payers_tel_num="";	 

	consolidated_receipt_yn=request.getParameter("consolidated_receipt_yn");
	if(consolidated_receipt_yn==null) consolidated_receipt_yn="";

	rcpt_type_code=request.getParameter("rcpt_type_code");
	if(rcpt_type_code==null) rcpt_type_code="";

	currdate=request.getParameter("currdate");
	if(currdate==null) currdate="";
/*****************added for packge biling********************/
		pkgSeqNo=request.getParameter("pkgSeqNo");
		if(pkgSeqNo==null) pkgSeqNo="";
/******************************END****************************/	
		str_tot_rec = request.getParameter("total_records");
		if(str_tot_rec == null) str_tot_rec="0";
		totalRecords = Integer.parseInt(str_tot_rec);
		str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = request.getParameter("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
		if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd == null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";
		hand_without_counter_chk_out = request.getParameter("hand_without_counter_chk_out");
		if(hand_without_counter_chk_out == null) hand_without_counter_chk_out="";
		support_data.clear();
		support_data.put("facility_id",facility_id);
		support_data.put("locale",locale);
		support_data.put("patient_id",patient_id);		
		support_data.put("visit_id",visit_id);
		support_data.put("episode_id",episode_id);
		support_data.put("episode_type",episode_type);
		support_data.put("encounter_id",encounter_id);
		support_data.put("rcpt_rfnd_ind",rcpt_rfnd_ind); 
		support_data.put("rcpt_nature_code",rcpt_nature_code); 
		support_data.put("cash_counter_code",cash_counter_code); 
		support_data.put("shift_id",shift_id); 
		support_data.put("doc_amt",doc_amt); 
		support_data.put("narration",narration); 
		support_data.put("ip_adm_trf_dep_ind",ip_adm_trf_dep_ind); 
		support_data.put("rec_ref_format_ind",rec_ref_format_ind); 
		support_data.put("rfnd_dep_in_use_yn",rfnd_dep_in_use_yn); 
		support_data.put("pmnt_thru_mail",pmnt_thru_mail); 
		support_data.put("ext_acc_facility_id",ext_acc_facility_id); 
		support_data.put("ext_acc_code",ext_acc_code); 
		support_data.put("ext_acc_dept_code",ext_acc_dept_code); 
		support_data.put("mult_slmt_yn",mult_slmt_yn); 
		support_data.put("downtime_entry_yn",downtime_entry_yn); 
		support_data.put("downtime_reason_code",downtime_reason_code); 
		support_data.put("downtime_doc_type_code",downtime_doc_type_code); 
		support_data.put("downtime_doc_num",downtime_doc_num); 
		support_data.put("downtime_doc_date",downtime_doc_date); 
		support_data.put("cc_machine_id",cc_machine_id); 
		support_data.put("payers_add1",payers_add1); 
		support_data.put("payers_add2",payers_add2); 
		support_data.put("payers_add3",payers_add3); 
		support_data.put("payers_tel_num",payers_tel_num); 
		support_data.put("consolidated_receipt_yn",consolidated_receipt_yn); 
		support_data.put("user_id",user_id);
		support_data.put("client_ip_address",client_ip_address);
		support_data.put("rcpt_type_code",rcpt_type_code);
		support_data.put("currdate",currdate);		
		support_data.put("str_tot_rec",str_tot_rec);
		support_data.put("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd",str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd);
		support_data.put("hand_without_counter_chk_out",hand_without_counter_chk_out);
		/*********************added pkgSeqNo IN TAB DATA for package billing********************************************/
		support_data.put("pkgSeqNo",pkgSeqNo);
		bean.setSupportData(support_data);
		//HashMap hm = new HashMap();
		mult_slmt_vals.clear();
		doc_sr_no=1;

	if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y"))
		{
		str_doc_sr_no ="0";
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
		ArrayList rtn_str_doc_sr_no1=new ArrayList();
		
		ArrayList rtn_str_slmt_short_desc=new ArrayList();
		ArrayList rtn_str_bank_name=new ArrayList();
		ArrayList rtn_str_online_app=new ArrayList();


		for(int i=0;i<totalRecords;i++)
		{		


				String str_slmt_doc_amt = request.getParameter("billslmtamt"+i);
				if(str_slmt_doc_amt == null) str_slmt_doc_amt="";
				rtn_str_slmt_doc_amt.add(str_slmt_doc_amt+"|");

				String str_slmt_type_code = request.getParameter("slmttype"+i);
				if(str_slmt_type_code ==null) str_slmt_type_code="";
				String str_cash_slmt_flag =str_slmt_type_code;
				str_slmt_type_code=str_slmt_type_code.substring(0,2);
				str_cash_slmt_flag =str_cash_slmt_flag.substring(2,3);
				rtn_str_slmt_type_code.add(str_slmt_type_code+"|");

				String str_slmt_doc_ref_desc = request.getParameter("instref"+i);
				if(str_slmt_doc_ref_desc == null) str_slmt_doc_ref_desc="";
				rtn_str_slmt_doc_ref_desc.add(str_slmt_doc_ref_desc+"|");

				String str_slmt_doc_ref_date = request.getParameter("instdate"+i);
				if(str_slmt_doc_ref_date == null) str_slmt_doc_ref_date="";
				rtn_str_slmt_doc_ref_date.add(str_slmt_doc_ref_date+"|");

				String str_slmt_doc_remarks = request.getParameter("str_slmt_doc_remarks"+i);
				if(str_slmt_doc_remarks == null) str_slmt_doc_remarks="";
				rtn_str_slmt_doc_remarks.add(str_slmt_doc_remarks+"|");

				String str_app_ref_no = request.getParameter("apprrefno"+i);
				if(str_app_ref_no == null) str_app_ref_no="";
				rtn_str_app_ref_no.add(str_app_ref_no+"|");

				/*String str_cash_slmt_flag = request.getParameter("str_cash_slmt_flag"+i);
				if(str_cash_slmt_flag == null) str_cash_slmt_flag="";
				str_cash_slmt_flag="A";*/
				rtn_str_cash_slmt_flag.add(str_cash_slmt_flag+"|");

				String str_cc_batch_no = request.getParameter("batchno"+i);
				if(str_cc_batch_no == null) str_cc_batch_no="";
				rtn_str_cc_batch_no.add(str_cc_batch_no+"|");

				String str_cc_sale_draft_no = request.getParameter("saledraftno"+i);
				if(str_cc_sale_draft_no == null) str_cc_sale_draft_no="";
				rtn_str_cc_sale_draft_no.add(str_cc_sale_draft_no+"|");

				String str_cc_swipped_yn = request.getParameter("str_cc_swipped_yn"+i);
				if(str_cc_swipped_yn == null) str_cc_swipped_yn="";
				rtn_str_cc_swipped_yn.add(str_cc_swipped_yn+"|");

				String str_bank_code = request.getParameter("instremarkcode"+i);
				if(str_bank_code == null) str_bank_code="";
				rtn_str_bank_code.add(str_bank_code+"|");

				String str_bank_branch = request.getParameter("instbranch"+i);
				if(str_bank_branch == null) str_bank_branch="";
				rtn_str_bank_branch.add(str_bank_branch+"|");

				String str_cash_amt_given = request.getParameter("cash_given"+i);
				if(str_cash_amt_given == null) str_cash_amt_given="";
				rtn_str_cash_amt_given.add(str_cash_amt_given+"|");

				String str_cash_amt_return = request.getParameter("cash_return"+i);
				if(str_cash_amt_return == null) str_cash_amt_return="";
				rtn_str_cash_amt_return.add(str_cash_amt_return+"|");

				String str_payer_name = request.getParameter("payername"+i);
				if(str_payer_name == null) str_payer_name="";
				rtn_str_payer_name.add(str_payer_name+"|");

				String str_rcpt_rfnd_id_no = request.getParameter("recrefidno"+i);
				if(str_rcpt_rfnd_id_no == null) str_rcpt_rfnd_id_no="";
				rtn_str_rcpt_rfnd_id_no.add(str_rcpt_rfnd_id_no+"|");

				String str_nominee_name = request.getParameter("str_nominee_name"+i);
				if(str_nominee_name == null) str_nominee_name="";
				rtn_str_nominee_name.add(str_nominee_name+"|");

				str_doc_sr_no = String.valueOf(doc_sr_no);
				rtn_str_doc_sr_no1.add(str_doc_sr_no+"|");
				doc_sr_no=1;


				String str_slmt_short_desc = request.getParameter("shortdesc"+i);
				if(str_slmt_short_desc == null) str_slmt_short_desc="";
				rtn_str_slmt_short_desc.add(str_slmt_short_desc+"|");

				String str_bank_name = request.getParameter("instbankname"+i);
				if(str_bank_name == null) str_bank_name="";
				rtn_str_bank_name.add(str_bank_name+"|");

				String str_online_app = request.getParameter("onlineapproval"+i);
				if(str_online_app == null) str_online_app="";
				rtn_str_online_app.add(str_online_app+"|");

				mult_slmt_vals.put("rtn_str_slmt_doc_amt",rtn_str_slmt_doc_amt);
				mult_slmt_vals.put("rtn_str_slmt_type_code",rtn_str_slmt_type_code);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_desc",rtn_str_slmt_doc_ref_desc);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_date",rtn_str_slmt_doc_ref_date);
				mult_slmt_vals.put("rtn_str_slmt_doc_remarks",rtn_str_slmt_doc_remarks);
				mult_slmt_vals.put("rtn_str_app_ref_no",rtn_str_app_ref_no);
				mult_slmt_vals.put("rtn_str_cash_slmt_flag",rtn_str_cash_slmt_flag);
				mult_slmt_vals.put("rtn_str_cc_batch_no",rtn_str_cc_batch_no);
				mult_slmt_vals.put("rtn_str_cc_sale_draft_no",rtn_str_cc_sale_draft_no);
				mult_slmt_vals.put("rtn_str_cc_swipped_yn",rtn_str_cc_swipped_yn);
				mult_slmt_vals.put("rtn_str_bank_code",rtn_str_bank_code);
				mult_slmt_vals.put("rtn_str_bank_branch",rtn_str_bank_branch);
				mult_slmt_vals.put("rtn_str_cash_amt_given",rtn_str_cash_amt_given);
				mult_slmt_vals.put("rtn_str_cash_amt_return",rtn_str_cash_amt_return);
				mult_slmt_vals.put("rtn_str_payer_name",rtn_str_payer_name);
				mult_slmt_vals.put("rtn_str_rcpt_rfnd_id_no",rtn_str_rcpt_rfnd_id_no);
				mult_slmt_vals.put("rtn_str_nominee_name",rtn_str_nominee_name);
				mult_slmt_vals.put("rtn_str_doc_sr_no",rtn_str_doc_sr_no1);
				mult_slmt_vals.put("rtn_str_slmt_short_desc",rtn_str_slmt_short_desc);
				mult_slmt_vals.put("rtn_str_bank_name",rtn_str_bank_name);
				mult_slmt_vals.put("rtn_str_online_app",rtn_str_online_app);


		}//end of for loop
				bean.setMultSlmtVals(mult_slmt_vals);
		}//end of if loop
		else{

			String rtn_str_slmt_doc_amt="", rtn_str_slmt_type_code="", rtn_str_slmt_doc_ref_desc="", rtn_str_slmt_doc_ref_date ="", rtn_str_slmt_doc_remarks ="" ,rtn_str_app_ref_no="", rtn_str_cash_slmt_flag="", rtn_str_cc_batch_no="", rtn_str_cc_sale_draft_no="", rtn_str_cc_swipped_yn="", rtn_str_bank_code="", rtn_str_bank_branch="", rtn_str_cash_amt_given="", rtn_str_cash_amt_return="", rtn_str_payer_name="", rtn_str_rcpt_rfnd_id_no="", rtn_str_nominee_name="",rtn_str_online_app="";
			str_doc_sr_no ="0";rtn_str_doc_sr_no="";

		for(int i=0;i<totalRecords;i++)
		{		


				String str_slmt_doc_amt = request.getParameter("billslmtamt"+i);
				if(str_slmt_doc_amt == null) str_slmt_doc_amt="";

				rtn_str_slmt_doc_amt=  rtn_str_slmt_doc_amt+str_slmt_doc_amt+"|";

				String str_slmt_type_code = request.getParameter("slmttype"+i);
				if(str_slmt_type_code ==null) str_slmt_type_code="";

				String str_cash_slmt_flag =str_slmt_type_code;
				str_slmt_type_code=str_slmt_type_code.substring(0,2);

				//rtn_str_slmt_type_code=  rtn_str_slmt_doc_amt+str_slmt_type_code+"|";
				str_cash_slmt_flag =str_cash_slmt_flag.substring(2,3);
				rtn_str_slmt_type_code=  rtn_str_slmt_type_code+str_slmt_type_code+"|";


				String str_slmt_doc_ref_desc = request.getParameter("instref"+i);
				if(str_slmt_doc_ref_desc == null) str_slmt_doc_ref_desc="";


				rtn_str_slmt_doc_ref_desc=  rtn_str_slmt_doc_ref_desc+str_slmt_doc_ref_desc+"|";

				String str_slmt_doc_ref_date = request.getParameter("instdate"+i);
				if(str_slmt_doc_ref_date == null) str_slmt_doc_ref_date="";


				rtn_str_slmt_doc_ref_date=  rtn_str_slmt_doc_ref_date+str_slmt_doc_ref_date+"|";

				String str_slmt_doc_remarks = request.getParameter("str_slmt_doc_remarks"+i);
				if(str_slmt_doc_remarks == null) str_slmt_doc_remarks="";

				rtn_str_slmt_doc_remarks=  rtn_str_slmt_doc_remarks+str_slmt_doc_remarks+"|";

				String str_app_ref_no = request.getParameter("apprrefno"+i);
				if(str_app_ref_no == null) str_app_ref_no="";

				rtn_str_app_ref_no=  rtn_str_app_ref_no+str_app_ref_no+"|";

				/*String str_cash_slmt_flag = request.getParameter("str_cash_slmt_flag"+i);
				if(str_cash_slmt_flag == null) str_cash_slmt_flag="";*/

				rtn_str_cash_slmt_flag=  rtn_str_cash_slmt_flag+str_cash_slmt_flag+"|";

				String str_cc_batch_no = request.getParameter("batchno"+i);
				if(str_cc_batch_no == null) str_cc_batch_no="";

				rtn_str_cc_batch_no=  rtn_str_cc_batch_no+str_cc_batch_no+"|";

				String str_cc_sale_draft_no = request.getParameter("saledraftno"+i);
				if(str_cc_sale_draft_no == null) str_cc_sale_draft_no="";

				rtn_str_cc_sale_draft_no=  rtn_str_cc_sale_draft_no+str_cc_sale_draft_no+"|";

				String str_cc_swipped_yn = request.getParameter("str_cc_swipped_yn"+i);
				if(str_cc_swipped_yn == null) str_cc_swipped_yn="";

				rtn_str_cc_swipped_yn =  rtn_str_cc_swipped_yn+str_cc_swipped_yn+"|";

				String str_bank_code = request.getParameter("instremarkcode"+i);
				if(str_bank_code == null) str_bank_code="";

				rtn_str_bank_code=  rtn_str_bank_code+str_bank_code+"|";

				String str_bank_branch = request.getParameter("instbranch"+i);
				if(str_bank_branch == null) str_bank_branch="";

				rtn_str_bank_branch=  rtn_str_bank_branch+str_bank_branch+"|";

				String str_cash_amt_given = request.getParameter("cash_given"+i);
				if(str_cash_amt_given == null) str_cash_amt_given="";

				rtn_str_cash_amt_given =  rtn_str_cash_amt_given+str_cash_amt_given+"|";

				String str_cash_amt_return = request.getParameter("cash_return"+i);
				if(str_cash_amt_return == null) str_cash_amt_return="";

				rtn_str_cash_amt_return =  rtn_str_cash_amt_return+str_cash_amt_return+"|";


				String str_payer_name = request.getParameter("payername"+i);
				if(str_payer_name == null) str_payer_name="";
				rtn_str_payer_name=  rtn_str_payer_name+str_payer_name+"|";

				String str_rcpt_rfnd_id_no = request.getParameter("recrefidno"+i);
				if(str_rcpt_rfnd_id_no == null) str_rcpt_rfnd_id_no="";

				rtn_str_rcpt_rfnd_id_no =  rtn_str_rcpt_rfnd_id_no+str_rcpt_rfnd_id_no+"|";

				String str_nominee_name = request.getParameter("str_nominee_name"+i);
				if(str_nominee_name == null) str_nominee_name="";

				rtn_str_nominee_name =  rtn_str_nominee_name+str_nominee_name+"|";

				str_doc_sr_no = String.valueOf(doc_sr_no);
				rtn_str_doc_sr_no=rtn_str_doc_sr_no+str_doc_sr_no+"|";

					doc_sr_no++;

				String str_online_app = request.getParameter("onlineapproval"+i);
				if(str_online_app == null) str_online_app="";
				rtn_str_online_app = rtn_str_online_app+str_online_app+"|";


				mult_slmt_vals.put("rtn_str_slmt_doc_amt",rtn_str_slmt_doc_amt);
				mult_slmt_vals.put("rtn_str_slmt_type_code",rtn_str_slmt_type_code);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_desc",rtn_str_slmt_doc_ref_desc);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_date",rtn_str_slmt_doc_ref_date);
				mult_slmt_vals.put("rtn_str_slmt_doc_remarks",rtn_str_slmt_doc_remarks);
				mult_slmt_vals.put("rtn_str_app_ref_no",rtn_str_app_ref_no);
				mult_slmt_vals.put("rtn_str_cash_slmt_flag",rtn_str_cash_slmt_flag);
				mult_slmt_vals.put("rtn_str_cc_batch_no",rtn_str_cc_batch_no);
				mult_slmt_vals.put("rtn_str_cc_sale_draft_no",rtn_str_cc_sale_draft_no);
				mult_slmt_vals.put("rtn_str_cc_swipped_yn",rtn_str_cc_swipped_yn);
				mult_slmt_vals.put("rtn_str_bank_code",rtn_str_bank_code);
				mult_slmt_vals.put("rtn_str_bank_branch",rtn_str_bank_branch);
				mult_slmt_vals.put("rtn_str_cash_amt_given",rtn_str_cash_amt_given);
				mult_slmt_vals.put("rtn_str_cash_amt_return",rtn_str_cash_amt_return);
				mult_slmt_vals.put("rtn_str_payer_name",rtn_str_payer_name);
				mult_slmt_vals.put("rtn_str_rcpt_rfnd_id_no",rtn_str_rcpt_rfnd_id_no);
				mult_slmt_vals.put("rtn_str_nominee_name",rtn_str_nominee_name);
				mult_slmt_vals.put("rtn_str_doc_sr_no",rtn_str_doc_sr_no);
				mult_slmt_vals.put("rtn_str_online_app",rtn_str_online_app);
			}
			bean.setMultSlmtVals(mult_slmt_vals);
	}

		if(!str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y"))
		{
			HashMap mult_slmt_vals1 = new HashMap();
		str_doc_sr_no ="0";
		ArrayList rtn_str_slmt_doc_amt1=new ArrayList();
		ArrayList rtn_str_slmt_type_code1=new ArrayList();
		ArrayList rtn_str_slmt_doc_ref_desc1=new ArrayList();
		ArrayList rtn_str_slmt_doc_ref_date1=new ArrayList();
		ArrayList rtn_str_slmt_doc_remarks1=new ArrayList();
		ArrayList rtn_str_app_ref_no1=new ArrayList();
		ArrayList rtn_str_cash_slmt_flag1=new ArrayList();
		ArrayList rtn_str_cc_batch_no1=new ArrayList();
		ArrayList rtn_str_cc_sale_draft_no1=new ArrayList();
		ArrayList rtn_str_cc_swipped_yn1=new ArrayList();
		ArrayList rtn_str_bank_code1=new ArrayList();
		ArrayList rtn_str_bank_branch1=new ArrayList();
		ArrayList rtn_str_cash_amt_given1=new ArrayList();
		ArrayList rtn_str_cash_amt_return1=new ArrayList();
		ArrayList rtn_str_payer_name1=new ArrayList();
		ArrayList rtn_str_rcpt_rfnd_id_no1=new ArrayList();
		ArrayList rtn_str_nominee_name1=new ArrayList();
		ArrayList rtn_str_doc_sr_no11=new ArrayList();
		ArrayList rtn_str_slmt_short_desc=new ArrayList();
		ArrayList rtn_str_bank_name=new ArrayList();
		ArrayList rtn_str_online_app=new ArrayList();
		for(int i=0;i<totalRecords;i++)
		{		
				String str_slmt_doc_amt = request.getParameter("billslmtamt"+i);
				if(str_slmt_doc_amt == null) str_slmt_doc_amt="";
				rtn_str_slmt_doc_amt1.add(str_slmt_doc_amt+"|");
				String str_slmt_type_code = request.getParameter("slmttype"+i);
				if(str_slmt_type_code ==null) str_slmt_type_code="";
				String str_cash_slmt_flag =str_slmt_type_code;
				str_slmt_type_code=str_slmt_type_code.substring(0,2);
				str_cash_slmt_flag =str_cash_slmt_flag.substring(2,3);
				rtn_str_slmt_type_code1.add(str_slmt_type_code+"|");
				String str_slmt_doc_ref_desc = request.getParameter("instref"+i);
				if(str_slmt_doc_ref_desc == null) str_slmt_doc_ref_desc="";
				rtn_str_slmt_doc_ref_desc1.add(str_slmt_doc_ref_desc+"|");
				String str_slmt_doc_ref_date = request.getParameter("instdate"+i);
				if(str_slmt_doc_ref_date == null) str_slmt_doc_ref_date="";
				rtn_str_slmt_doc_ref_date1.add(str_slmt_doc_ref_date+"|");
				String str_slmt_doc_remarks = request.getParameter("str_slmt_doc_remarks"+i);
				if(str_slmt_doc_remarks == null) str_slmt_doc_remarks="";
				rtn_str_slmt_doc_remarks1.add(str_slmt_doc_remarks+"|");
				String str_app_ref_no = request.getParameter("apprrefno"+i);
				if(str_app_ref_no == null) str_app_ref_no="";
				rtn_str_app_ref_no1.add(str_app_ref_no+"|");				
				/*String str_cash_slmt_flag = request.getParameter("str_cash_slmt_flag"+i);
				if(str_cash_slmt_flag == null) str_cash_slmt_flag="";
				str_cash_slmt_flag="A";*/
				rtn_str_cash_slmt_flag1.add(str_cash_slmt_flag+"|");
				String str_cc_batch_no = request.getParameter("batchno"+i);
				if(str_cc_batch_no == null) str_cc_batch_no="";
				rtn_str_cc_batch_no1.add(str_cc_batch_no+"|");
				String str_cc_sale_draft_no = request.getParameter("saledraftno"+i);
				if(str_cc_sale_draft_no == null) str_cc_sale_draft_no="";
				rtn_str_cc_sale_draft_no1.add(str_cc_sale_draft_no+"|");
				String str_cc_swipped_yn = request.getParameter("str_cc_swipped_yn"+i);
				if(str_cc_swipped_yn == null) str_cc_swipped_yn="";
				rtn_str_cc_swipped_yn1.add(str_cc_swipped_yn+"|");
				String str_bank_code = request.getParameter("instremarkcode"+i);
				if(str_bank_code == null) str_bank_code="";
				rtn_str_bank_code1.add(str_bank_code+"|");
				String str_bank_branch = request.getParameter("instbranch"+i);
				if(str_bank_branch == null) str_bank_branch="";
				rtn_str_bank_branch1.add(str_bank_branch+"|");
				String str_cash_amt_given = request.getParameter("cash_given"+i);
				if(str_cash_amt_given == null) str_cash_amt_given="";
				rtn_str_cash_amt_given1.add(str_cash_amt_given+"|");
				String str_cash_amt_return = request.getParameter("cash_return"+i);
				if(str_cash_amt_return == null) str_cash_amt_return="";
				rtn_str_cash_amt_return1.add(str_cash_amt_return+"|");
				String str_payer_name = request.getParameter("payername"+i);
				if(str_payer_name == null) str_payer_name="";
				rtn_str_payer_name1.add(str_payer_name+"|");
				String str_rcpt_rfnd_id_no = request.getParameter("recrefidno"+i);
				if(str_rcpt_rfnd_id_no == null) str_rcpt_rfnd_id_no="";
				rtn_str_rcpt_rfnd_id_no1.add(str_rcpt_rfnd_id_no+"|");
				String str_nominee_name = request.getParameter("str_nominee_name"+i);
				if(str_nominee_name == null) str_nominee_name="";
				rtn_str_nominee_name1.add(str_nominee_name+"|");
				str_doc_sr_no = String.valueOf(doc_sr_no);
				rtn_str_doc_sr_no11.add(str_doc_sr_no+"|");
				doc_sr_no=1;
				String str_slmt_short_desc = request.getParameter("shortdesc"+i);
				if(str_slmt_short_desc == null) str_slmt_short_desc="";
				rtn_str_slmt_short_desc.add(str_slmt_short_desc+"|");
				String str_bank_name = request.getParameter("instbankname"+i);
				if(str_bank_name == null) str_bank_name="";
				rtn_str_bank_name.add(str_bank_name+"|");

				String str_online_app = request.getParameter("onlineapproval"+i);
				if(str_online_app == null) str_online_app="";
				rtn_str_online_app.add(str_online_app+"|");

				mult_slmt_vals1.put("rtn_str_slmt_doc_amt",rtn_str_slmt_doc_amt1);
				mult_slmt_vals1.put("rtn_str_slmt_type_code",rtn_str_slmt_type_code1);
				mult_slmt_vals1.put("rtn_str_slmt_doc_ref_desc",rtn_str_slmt_doc_ref_desc1);
				mult_slmt_vals1.put("rtn_str_slmt_doc_ref_date",rtn_str_slmt_doc_ref_date1);
				mult_slmt_vals1.put("rtn_str_slmt_doc_remarks",rtn_str_slmt_doc_remarks1);
				mult_slmt_vals1.put("rtn_str_app_ref_no",rtn_str_app_ref_no1);
				mult_slmt_vals1.put("rtn_str_cash_slmt_flag",rtn_str_cash_slmt_flag1);
				mult_slmt_vals1.put("rtn_str_cc_batch_no",rtn_str_cc_batch_no1);
				mult_slmt_vals1.put("rtn_str_cc_sale_draft_no",rtn_str_cc_sale_draft_no1);
				mult_slmt_vals1.put("rtn_str_cc_swipped_yn",rtn_str_cc_swipped_yn1);
				mult_slmt_vals1.put("rtn_str_bank_code",rtn_str_bank_code1);
				mult_slmt_vals1.put("rtn_str_bank_branch",rtn_str_bank_branch1);
				mult_slmt_vals1.put("rtn_str_cash_amt_given",rtn_str_cash_amt_given1);
				mult_slmt_vals1.put("rtn_str_cash_amt_return",rtn_str_cash_amt_return1);
				mult_slmt_vals1.put("rtn_str_payer_name",rtn_str_payer_name1);
				mult_slmt_vals1.put("rtn_str_rcpt_rfnd_id_no",rtn_str_rcpt_rfnd_id_no1);
				mult_slmt_vals1.put("rtn_str_nominee_name",rtn_str_nominee_name1);
				mult_slmt_vals1.put("rtn_str_doc_sr_no",rtn_str_doc_sr_no11);
				mult_slmt_vals1.put("rtn_str_slmt_short_desc",rtn_str_slmt_short_desc);
				mult_slmt_vals1.put("rtn_str_bank_name",rtn_str_bank_name);
				mult_slmt_vals1.put("rtn_str_online_app",rtn_str_online_app);
		}//end of for loop
				bean.setSlmtVals(mult_slmt_vals1);
				//System.out.println("mult_slmt_vals 1123"+mult_slmt_vals1);
		}//end of if loop

		putObjectInBean(bean_id,bean,request);
}catch(Exception ee){
	System.out.println("Error in Pkgrecrefsub"+ee);
	ee.printStackTrace();
}

%>
<SCRIPT>
//window.parent.returnValue="Y";
		//parent.window.close();
parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -2].close();
toCloseTopShowModal("Y");	
</SCRIPT>
</html>

