<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations for OR Logic Implementation start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%
    request.setCharacterEncoding("UTF-8");
	/*Added by karthik on Oct-18-2012 to default select a practitioner*/
    String session_pract=request.getParameter("set_session_practitioner");
	if(session_pract==null) session_pract="";
    String session_pract_staff_ind=request.getParameter("set_session_pract_staff_ind");
	if(session_pract_staff_ind==null) session_pract_staff_ind="";
    String session_pract_staff_id=request.getParameter("set_session_pract_staff_id");
	if(session_pract_staff_id==null) session_pract_staff_id="";
	session.setAttribute("sessionPractitioner",session_pract);
	session.setAttribute("sessionStaffInd",session_pract_staff_ind);
	session.setAttribute("sessionStaffId",session_pract_staff_id);

	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;
	ResultSet rsserv_desc=null;	ResultSet rsreson_desc=null; ResultSet rsuomdesc=null;
	ResultSet rspractname=null;	ResultSet rsserv_qty=null;
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
		
	//String sql1=""; String sql2=""; String sql3=""; String sql_chr_det=""; 	
	String locale	= (String)session.getAttribute("LOCALE");
	ArrayList a1=new ArrayList();ArrayList a2=new ArrayList();ArrayList a3=new ArrayList();ArrayList a4=new ArrayList();ArrayList a5=new ArrayList();ArrayList a6=new ArrayList();ArrayList a7=new ArrayList();
	ArrayList a8=new ArrayList();ArrayList a9=new ArrayList();ArrayList a10=new ArrayList();ArrayList a11=new ArrayList();ArrayList a12=new ArrayList();ArrayList a13=new ArrayList();ArrayList a14=new ArrayList();
	ArrayList a15=new ArrayList();	//ArrayList temp=new ArrayList();
	ArrayList a16=new ArrayList();
	ArrayList a17=new ArrayList();ArrayList a18=new ArrayList();ArrayList a19=new ArrayList();ArrayList a20=new ArrayList();ArrayList a21=new ArrayList();ArrayList a22=new ArrayList(); ArrayList a23=new ArrayList();ArrayList a24=new ArrayList();ArrayList a25=new ArrayList();ArrayList a26=new ArrayList();ArrayList a27=new ArrayList();
	int totalRecords=0;int noofdecimal = 2;//long p_episode_id=0; int p_visit_id=0;
	//long p_encounter_id=0;
	String str_encounter_id="";
	String remove_check="";	String  str_acct_seq_no=""; 
	String p_facility_id="";String p_login_user="";	String p_episode_type="";
	String p_patient_id=""; String strp_episode_id=""; 	String strp_visit_id="";
	String p_service_date="";  String p_service_panel_ind=""; 	String p_service_panel_code="";
	//String readonly="";
	String str="";String p_string="";String added_serv_yn ="";	
	String p_module_id="";String include_label="";String exclude_label=""; String query_string="";
	String rate_label="";String charge_label="";String p_order_id=""; String p_order_line_no="";
	String p_string1 ="",p_override_yn="";
	String blng_grp_id="",cust_group_code="",cust_code="",policy_type_code="",policy_priority="",policy_no="",policy_start_date="",policy_exp_date="";
	String credit_auth_ref="",credit_auth_date="",policy_eff_from_date="",policy_eff_to_date="",approved_amt="",approved_days="";
	String non_ins_blng_grp_id="",non_ins_cust_group_code="",non_ins_cust_code="",user_id="",ws_num="";	
	String clinic_code="";String str_epi_type_clinic_code="";
	String panel_qty ="",panel_qty_for_hidden="";
	double serv_qty=0.0;
							double db_panel_qty =0.0;

	String p_order_item="";
	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="",str_or_key_line_no="";
	HashMap bill_dtls_frm_or_bean = null;
	String p_ordering_facility_id ="";//--[IN034785]

	CurrencyFormat cf = new CurrencyFormat();
	HashMap hm_string=null;
	
	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	String bean_name_bl="";
	HashMap finDtls		= new HashMap();
	/******end*******************/
	
	String str_null="";

	try
	{
		try
		{
			con	=	ConnectionManager.getConnection(request);
			query_string=request.getQueryString();


			panel_qty = request.getParameter("panel_qty");
			if(panel_qty==null || panel_qty.equals("")) panel_qty="1";
			panel_qty_for_hidden=panel_qty;
			

			p_facility_id = (String)httpSession.getValue("facility_id");
			if(p_facility_id==null) p_facility_id="";
		
			p_login_user =  p.getProperty("login_user");
			if(p_login_user==null) p_login_user="";
		 

			p_episode_type = request.getParameter("episode_type");
			if(p_episode_type==null) p_episode_type="";

			p_patient_id = request.getParameter("patient_id");
			if(p_patient_id==null) p_patient_id="";
	
			strp_visit_id = request.getParameter("visit_id");
			if(strp_visit_id==null || strp_visit_id.equals("")) strp_visit_id="0";
//			p_visit_id=Integer.parseInt(strp_visit_id);	
	
			strp_episode_id = request.getParameter("episode_id");
			if(strp_episode_id==null || strp_episode_id.equals("")) strp_episode_id="0";
//			p_episode_id=Long.parseLong(strp_episode_id);	

			p_service_date = request.getParameter("service_date");		
			if(p_service_date==null) p_service_date="";
			//p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);		

			p_service_panel_ind = request.getParameter("service_panel_ind");
			if(p_service_panel_ind==null) p_service_panel_ind="";

			p_service_panel_code = request.getParameter("service_panel_code");
			if(p_service_panel_code==null) p_service_panel_code="";

			p_module_id=request.getParameter("module_id");	
			if(p_module_id==null) p_module_id="";

			str_encounter_id=request.getParameter("encounter_id");
			if(str_encounter_id==null || str_encounter_id.equals("") || str_encounter_id.equals("null")) str_encounter_id="";
//			p_encounter_id=Long.parseLong(str_encounter_id);	

			str_acct_seq_no=request.getParameter("acct_seq_no");
			if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="";

			p_order_id = request.getParameter("order_id");
			if(p_order_id==null || p_order_id.equals("")) p_order_id="";	

			p_order_line_no= request.getParameter("order_line_no");
			if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";

			p_order_item=request.getParameter("order_catalog_code");
			if(p_order_item==null) p_order_item="";

			clinic_code=request.getParameter("clinic_code");
			if(clinic_code==null) clinic_code="";
			//--[IN034785] - Start
			p_ordering_facility_id=request.getParameter("ord_facility");
			if((p_ordering_facility_id==null || p_ordering_facility_id.equals("")))
			{			
				p_facility_id = (String)httpSession.getValue("facility_id");
			}	
			else
			{
				p_facility_id= p_ordering_facility_id;
			}
			//--[IN034785] - End

			str_epi_type_clinic_code=p_episode_type+"#"+clinic_code;
			if(str_epi_type_clinic_code==null) str_epi_type_clinic_code="";

			include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
			if(include_label==null || include_label.equals("")) include_label="";		

			exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");
			if(exclude_label==null || exclude_label.equals("")) exclude_label="";		

			rate_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.RATE.label","bl_labels");
			if(rate_label==null || rate_label.equals("")) rate_label="";		

			charge_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charge.label","common_labels");
			if(charge_label==null || charge_label.equals("")) charge_label="";		

			//p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS",locale,"en");

			/*********************ADDED BR RAM FOR GHL-CRF-1.2**********************************/
			calledfrmencYN=request.getParameter("patregnchargeYN");
			if(calledfrmencYN==null) calledfrmencYN="N";
			
			/******************************END**************************************************/
		}
		catch(Exception eX1)
		{	
			out.println("Error= "+eX1);
		}
		/***************Added by ram ghl-crf-1.2***************/
		if(calledfrmencYN.equals("Y") && p_module_id.equals("MP"))
		{
			clinic_code="";
			bean_id_bl=request.getParameter("bean_id");
			if(bean_id_bl==null) bean_id_bl="";
			bean_name_bl=request.getParameter("bean_name");
			if(bean_name_bl==null) bean_name_bl="";
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, bean_name_bl, request ) ;
			if(bean!=null)
			{
				String panel_str_frm_bl = (String) bean.getPanelString(); 
				p_string1=panel_str_frm_bl;
			}
			

		}
		/*****************End**********************************/
		
		else if(p_module_id.equals("OP") || p_module_id.equals("AE") || (p_module_id.equals("MP") && calledfrmencYN.equals("N")))
		{
			hm_string=(HashMap)session.getAttribute("BlChargeRecord");
		
			if(hm_string!=null)
			{
				p_string1 =(String)hm_string.get("panel_str");
				if(p_string1==null || p_string1.equals(""))
				{
					p_string1="";	
				}
				else
				{
					//p_string1=p_string1.trim();
				}
			}
		}
		else if(p_module_id.equals("BL"))
		{
/*

			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";
			System.out.println("str_or_bean_id in Body:"+str_or_bean_id);

			str_or_key=request.getParameter("key");
			if(str_or_key==null) str_or_key="";

			str_or_key_line_no=request.getParameter("key_line_no");
			if(str_or_key_line_no==null) str_or_key_line_no="";
			
			if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
			{
				str_or_key=str_or_key+str_or_key_line_no;
			}
			
			BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;

			bill_dtls_frm_or_bean=(HashMap)ServPanlBean.getSelectedServPanlDtls(str_or_key);

			if(bill_dtls_frm_or_bean!=null)
			{
				String panel_str_frm_or = (String) bill_dtls_frm_or_bean.get("bl_panel_str"); 
				p_string1=panel_str_frm_or;
			}
*/
		} 
		
		else
		{
			//The bean concept has to be incorporated for modules like OR/OT/PH
			str_or_bean_id=request.getParameter("bean_id");
			if(str_or_bean_id==null) str_or_bean_id="";

			str_or_key=request.getParameter("key");
			if(str_or_key==null) str_or_key="";

			str_or_key_line_no=request.getParameter("key_line_no");
			if(str_or_key_line_no==null) str_or_key_line_no="";
			
			if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
			{
				str_or_key=str_or_key+str_or_key_line_no;
			}
			
			OrderEntryBillingQueryBean orderEntryBillBean =null;

			if(!str_or_bean_id.equals(""))
			{
				// Added the new If...Else Loop for the Future Order Purpose as on 30th August'07 by Manivel
				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					FutureOrder beanObj  = (FutureOrder )getBeanObject(str_or_bean_id,"eOR.FutureOrder",request);
                    orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
				else
				{
					OrderEntryBean beanObj  = (OrderEntryBean)getBeanObject(str_or_bean_id,"eOR.OrderEntryBean",request);
                    orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
			}
			else
			{
				orderEntryBillBean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
			}

			bill_dtls_frm_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);

			if(bill_dtls_frm_or_bean!=null)
			{
				String panel_str_frm_or = (String) bill_dtls_frm_or_bean.get("bl_panel_str"); 
				p_string1=panel_str_frm_or;
//				System.out.println("Panel String from OR Bean:"+p_string1);
			}
		} 
		/***************Added by ram ghl-crf-1.2  if else***************/
		if(calledfrmencYN.equals("Y") && p_module_id.equals("MP"))
		{
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, bean_name_bl, request ) ;
			finDtls = (HashMap)bean.getFinDtls();

			blng_grp_id=(String)finDtls.get("blng_grp_id");
			if(blng_grp_id==null)	blng_grp_id=""; 	

			cust_group_code=(String)finDtls.get("str_cust_group_code");
			if(cust_group_code==null)	cust_group_code=""; 

			cust_code=(String)finDtls.get("str_cust_code");
			if(cust_code==null)	cust_code=""; 
		
			policy_type_code=(String)finDtls.get("str_policy_type_code");
			if(policy_type_code==null) policy_type_code=""; 
		
			policy_priority=(String)finDtls.get("str_priority");
			if(policy_priority==null) policy_priority=""; 
		
			policy_no=(String)finDtls.get("str_policy_number");
			if(policy_no==null)	policy_no=""; 	

			policy_start_date=(String)finDtls.get("str_policy_start_date");
			if(policy_start_date==null)	policy_start_date=""; 

			policy_exp_date=(String)finDtls.get("str_policy_expiry_date");
			if(policy_exp_date==null)policy_exp_date=""; 	

			credit_auth_ref=(String)finDtls.get("str_credit_auth_ref");
			if(credit_auth_ref==null) credit_auth_ref=""; 	

			credit_auth_date=(String)finDtls.get("str_credit_auth_date");
			if(credit_auth_date==null) credit_auth_date=""; 	
	
			policy_eff_from_date=(String)finDtls.get("str_effective_from");
			if(policy_eff_from_date==null)	policy_eff_from_date=""; 	

			policy_eff_to_date=(String)finDtls.get("str_effective_to");
			if(policy_eff_to_date==null) policy_eff_to_date=""; 

			approved_amt=(String)finDtls.get("str_approved_amt");
			if(approved_amt==null) approved_amt=""; 	
	
			approved_days=(String)finDtls.get("str_approved_days");
			if(approved_days==null)	approved_days=""; 	

			non_ins_blng_grp_id=(String)finDtls.get("non_ins_blng_grp_id");
			if(non_ins_blng_grp_id==null) non_ins_blng_grp_id=""; 	

			non_ins_cust_group_code=(String)finDtls.get("non_ins_cust_group_code");
			if(non_ins_cust_group_code==null)	non_ins_cust_group_code=""; 	

			non_ins_cust_code=(String)finDtls.get("non_ins_cust_code");
			if(non_ins_cust_code==null)	non_ins_cust_code=""; 

		}else{
				HashMap fin_dtls_bef_reg=(HashMap)session.getAttribute("fin_dtls_to_chrg_dtls");
				if(!(fin_dtls_bef_reg==null))
				{	
					blng_grp_id=(String)fin_dtls_bef_reg.get("billing_group");
					if(blng_grp_id==null)	blng_grp_id=""; 	

					cust_group_code=(String)fin_dtls_bef_reg.get("cust_group_code");
					if(cust_group_code==null)	cust_group_code=""; 

					cust_code=(String)fin_dtls_bef_reg.get("cust_code");
					if(cust_code==null)	cust_code=""; 
				
					policy_type_code=(String)fin_dtls_bef_reg.get("policy_type_code");
					if(policy_type_code==null) policy_type_code=""; 
				
					policy_priority=(String)fin_dtls_bef_reg.get("policy_priority");
					if(policy_priority==null) policy_priority=""; 
				
					policy_no=(String)fin_dtls_bef_reg.get("policy_no");
					if(policy_no==null)	policy_no=""; 	

					policy_start_date=(String)fin_dtls_bef_reg.get("policy_start_date");
					if(policy_start_date==null)	policy_start_date=""; 

					policy_exp_date=(String)fin_dtls_bef_reg.get("policy_exp_date");
					if(policy_exp_date==null)policy_exp_date=""; 	

					credit_auth_ref=(String)fin_dtls_bef_reg.get("credit_auth_ref");
					if(credit_auth_ref==null) credit_auth_ref=""; 	

					credit_auth_date=(String)fin_dtls_bef_reg.get("credit_auth_date");
					if(credit_auth_date==null) credit_auth_date=""; 	
			
					policy_eff_from_date=(String)fin_dtls_bef_reg.get("policy_eff_from_date");
					if(policy_eff_from_date==null)	policy_eff_from_date=""; 	

					policy_eff_to_date=(String)fin_dtls_bef_reg.get("policy_eff_to_date");
					if(policy_eff_to_date==null) policy_eff_to_date=""; 

					approved_amt=(String)fin_dtls_bef_reg.get("approved_amt");
					if(approved_amt==null) approved_amt=""; 	
			
					approved_days=(String)fin_dtls_bef_reg.get("approved_days");
					if(approved_days==null)	approved_days=""; 	

					non_ins_blng_grp_id=(String)fin_dtls_bef_reg.get("non_ins_blng_grp_id");
					if(non_ins_blng_grp_id==null) non_ins_blng_grp_id=""; 	

					non_ins_cust_group_code=(String)fin_dtls_bef_reg.get("non_ins_cust_group_code");
					if(non_ins_cust_group_code==null)	non_ins_cust_group_code=""; 	

					non_ins_cust_code=(String)fin_dtls_bef_reg.get("non_ins_cust_code");
					if(non_ins_cust_code==null)	non_ins_cust_code=""; 	
			
					user_id=(String)fin_dtls_bef_reg.get("user_id");
					if(user_id==null) user_id=""; 
				}
		}
		try
		{
			remove_check=request.getParameter("remove_check");

			if(remove_check==null) remove_check="";
			String checked_row="";
			String record_count="";
			int total_records=0;
			int selected_index=0;		
			//String fwd_payer_desc="";
			
			if(checked_row==null) checked_row="";
			if(remove_check.equals("remove"))
			{
				record_count=request.getParameter("total_records");
				if(record_count==null) record_count="";
				total_records=Integer.parseInt(record_count);							
				checked_row=request.getParameter("checked_row");
				if(checked_row==null) checked_row="";
				selected_index=Integer.parseInt(checked_row);
				
				for(int i=0;i<total_records;i++)
				{
					
					if(!(i==selected_index))
					{	try{

					String temp1=request.getParameter("service"+i);
					a1.add(temp1);						
					temp1=request.getParameter("blng_serv_code"+i);
					a2.add(temp1);					
					temp1=request.getParameter("incl_excl"+i);
					a3.add(temp1);								
					temp1=request.getParameter("incl_excl_action"+i);
					a4.add(temp1);					
					temp1=request.getParameter("reason"+i);
					a5.add(temp1);					
					temp1=request.getParameter("action_reason_code"+i);
					a6.add(temp1);				
					temp1=request.getParameter("charge"+i);
					a7.add(temp1);					
					temp1=request.getParameter("original_qty"+i);
					a8.add(temp1);
					temp1=request.getParameter("modify_qty_yn"+i);
					a9.add(temp1);
					temp1=request.getParameter("uom"+i);
					a10.add(temp1);
					temp1=request.getParameter("uom_code"+i);
					a11.add(temp1);
					temp1=request.getParameter("revise_qty"+i);
					a12.add(temp1);
					temp1=request.getParameter("total_qty"+i);
					a13.add(temp1);
					temp1=request.getParameter("rate"+i);
					a14.add(temp1);					
					temp1=request.getParameter("practioner_type"+i);
					a15.add(temp1);
					temp1=request.getParameter("pract_id"+i);
					a16.add(temp1);
					temp1=request.getParameter("practioner"+i);
					a17.add(temp1);					
					temp1=request.getParameter("total_pay"+i);
					a18.add(temp1);
					temp1=request.getParameter("patient_pay"+i);
					a19.add(temp1);
					temp1=request.getParameter("patient_paid"+i);
					a20.add(temp1);
					temp1=request.getParameter("preappr_reqd"+i);
					a21.add(temp1);
					/*temp1=request.getParameter("kkk");
					a20.add(i,temp1);				
					System.out.println(" cbflag11 rem "+ a20);
					*/
					temp1=request.getParameter("pract_staff_id"+i);
					a22.add(temp1);	
					temp1=request.getParameter("ratecharge_desc"+i);
					a23.add(temp1);
					temp1=request.getParameter("charged_yn"+i);
					a24.add(temp1);

					temp1=request.getParameter("override_allowed_yn"+i);					
					a25.add(temp1);					

					temp1=request.getParameter("serv_amt_changed"+i);					
					a26.add(temp1);					

					temp1=request.getParameter("excl_incl_ind_for_screen"+i);					
					a27.add(temp1);					

					}catch(Exception e){System.out.println("Exception in :"+e);}
				}
				}		
				
			}		
		}
		catch(Exception eX)
		{	
			out.println("Error1= "+eX);
		}
%>
<html>
<head>
<script>
	var cbflag="";
	var cbflag1="";
	function check(i)
	{
		document.edit_enter_main.focussed_row.value=i;
	}
	function modify_remove_payer(i)
	{	
		var service="";
		var blng_serv_code="";
		var incl_excl="";
		var incl_excl_action="";
		var reason="";
		var reason_code="";
		var charge="";
		var original_qty="";
		var uom="";
		var uom_code="";
		var revise_qty="";
		var total_qty="";
		var rate="";
		var practioner_type="";
		var pract_id="";
		var practioner="";
		var total_pay="";
		var patient_pay="";
		var preappr="";
		var service1="";
		var blng_serv_code1="";
		var incl_excl1="";
		var incl_excl_action1="";
		var reason1="";
		var reason_code1="";
		var charge1="";
		var original_qty1="";
		var uom1="";
		var uom_code1="";
		var revise_qty1="";
		var total_qty1="";
		var rate1="";
		var practioner_type1="";
		var pract_id1="";
		var practioner1="";
		var total_pay1="";
		var patient_pay1="";
		var preappr_reqd="";
		var cbflag1=""
		var modify_qty_yn="";
		var modify_qty_yn1="";

		var totalRecords=document.forms[0].total_records.value;
		var selected_row=i;
	
		for(var j=0;j<totalRecords;j++)
		{
			service1=eval("document.forms[0].service"+j);
			if(service1.value=="") service=service+"|"+" ";
			else service=service+"|"+service1.value;

			blng_serv_code1		=eval("document.forms[0].blng_serv_code"+j);
			if(blng_serv_code1.value=="") blng_serv_code=blng_serv_code+"|"+" ";
			else blng_serv_code=blng_serv_code+"|"+blng_serv_code1.value;

			incl_excl1=eval("document.forms[0].incl_excl"+j);
			if(incl_excl1.value=="") incl_excl=incl_excl+"|"+" ";
			else incl_excl=incl_excl+"|"+incl_excl1.value;		
		
			incl_excl_action1=eval("document.forms[0].incl_excl_action"+j);
			if(incl_excl_action1.value=="") incl_excl_action=incl_excl_action+"|"+" ";
			else incl_excl_action=incl_excl_action+"|"+incl_excl_action1.value;
		
			reason1=eval("document.forms[0].reason"+j);
			if(reason1.value=="") reason=reason+"|"+" ";
			else reason=reason+"|"+reason1.value;		

			reason_code1=eval("document.forms[0].action_reason_code"+j);
			if(reason_code1.value=="") reason_code=reason_code+"|"+" ";
			else reason_code=reason_code1+"|"+reason_code1.value;		

			charge1=eval("document.forms[0].charge"+j);
			if(charge1.value=="") charge=charge+"|"+" ";
			else charge=charge+"|"+charge1.value;		
		
			original_qty1=eval("document.forms[0].original_qty"+j);
			if(original_qty1.value=="") original_qty=original_qty+"|"+" ";
			else original_qty=original_qty+"|"+original_qty1.value;		

			uom1=eval("document.forms[0].uom"+j);
			if(uom1.value=="") uom=uom+"|"+" ";
			else uom=uom+"|"+uom1.value;		

			uom_code1=eval("document.forms[0].uom_code"+j);
			if(uom_code1.value=="") uom_code=uom_code+"|"+" ";
			else uom_code=uom_code+"|"+uom_code1.value;	

			revise_qty1=eval("document.forms[0].revise_qty"+j);
			if(revise_qty1.value=="") revise_qty=revise_qty+"|"+" ";
			else revise_qty=revise_qty+"|"+revise_qty1.value;
		
			total_qty1=eval("document.forms[0].total_qty"+j);
			if(total_qty1.value=="") total_qty=total_qty+"|"+" ";
			else total_qty=total_qty+"|"+total_qty1.value;
		
			rate1=eval("document.forms[0].rate"+j);
			if(rate1.value=="") rate=rate+"|"+" ";
			else rate=rate+"|"+rate1.value;
		
			practioner_type1=eval("document.forms[0].practioner_type"+j);
			if(practioner_type1.value=="") practioner_type=practioner_type+"|"+" ";
			else practioner_type=practioner_type+"|"+practioner_type1.value;

			pract_id1=eval("document.forms[0].pract_id"+j);
			if(pract_id1.value=="") pract_id=pract_id+"|"+" ";
			else pract_id=pract_id+"|"+pract_id1.value;
		
			practioner1=eval("document.forms[0].practioner"+j);
			if(practioner1.value=="") practioner=practioner+"|"+" ";
			else practioner=practioner+"|"+practioner1.value;
						
			total_pay1=eval("document.forms[0].total_pay"+j);
			if(total_pay1.value=="") total_pay=total_pay+"|"+" ";
			else total_pay=total_pay+"|"+total_pay1.value;
		
			patient_pay1=eval("document.forms[0].patient_pay"+j);
			if(patient_pay1.value=="") patient_pay=patient_pay+"|"+" ";
			else patient_pay=patient_pay+"|"+patient_pay1.value;	

			cbflag1=eval("document.forms[0].preappr_reqd"+j);
			//if(cbflag1=="") cbflag=cbflag+"|"+" ";
			//else cbflag=cbflag+"|"+cbflag1.checked;	

			if(cbflag1.checked)
			{
				cbflag=cbflag+"|"+"true";
			}
			else
			{
				cbflag=cbflag+"|"+"false";
			}
		}		

		uom=uom+"|";	

		var retVal			= new String();
		var dialogTop = "100";
		var dialogHeight = "25" ;
		var dialogWidth = "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
		//var getString=document.forms[0].queryString.value;
    	var param = "title="+title+"&action=modify&service="+service+"&incl_excl="+incl_excl+"&incl_excl_action="+incl_excl_action+"&reason="+reason+"&charge="+charge+"&original_qty="+original_qty+"&revise_qty="+revise_qty+"&total_qty="+total_qty+"&rate="+rate+"&practioner_type="+practioner_type+"&practioner="+practioner+"&total_pay="+total_pay+"&patient_pay="+patient_pay+"&selected_row="+selected_row+"&total_records="+totalRecords+"&uom="+uom+"&cbflag="+cbflag;
		alert('param->'+param);
		//retVal=window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDetials2.jsp?"+param,arguments,features);
		retVal=window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDetialsValidationFrame.jsp?"+param,arguments,features);
		if(retVal!=null)
		{	
			var arr=new Array();
			var delete_flag="";
			if(retVal == null) retVal='';
			if (retVal != null || retVal!="")
			{
				var retVal=unescape(retVal);					  
				if(retVal != null && retVal.length>0)
				{
					arr=retVal.split("::");	
					delete_flag=arr[0];
					if(delete_flag=="remove")
					{
						var totalRecords =document.forms[0].total_records.value;
						var count =totalRecords - 1; 
						document.forms[0].total_records.value=count;
						 parent.frames[2].location.href='../../eBL/jsp/BLEnterEditChargeDetailsBody.jsp?remove_check=remove&'+getString;
					}
				}
			}
		}
		else
		{
			//alert("closed");
		}
	}

	function selected(i)
	{
		var total_records=document.forms[0].total_records.value;
		var selected_row=eval("document.forms[0].selected_row"+i);
		var selected_row1=eval("document.forms[0].preappr_reqd"+i);		
		var l_charge_yn=eval("document.forms[0].charged_yn"+i);		
		
		
		if(selected_row.checked==false)
		{
			selected_row.checked=false;
			document.edit_enter_main.checked_row.value="";
		}
		else{
			if(l_charge_yn.value!="Y")
			{			
			

				for(var j=0;j<total_records;j++)
				{
					var temp=eval("document.forms[0].selected_row"+j);
					temp.checked=false;
					//temp.value="false";
				}
				selected_row.checked=true;
				//selected_row.value="true";
				document.edit_enter_main.checked_row.value=i;
			}
			else{
				for(var j=0;j<total_records;j++)
				{
					var temp=eval("document.forms[0].selected_row"+j);
					temp.checked=false;
					//temp.value="false";
				}
				
				alert(getMessage('BL9779','BL'));
				return false;
				}

			}
		
	}

	function putdeci(object)
	{
		if(object.value!='')
		{
			var decimal=document.forms[0].noofdecimal.value;
			putDecimal(object,17,decimal);
		}
	}

	function totpayable()
	{
		
		var totalpayable=0.00;
		var patientpayable=0.00;
		var patientpaid=0.00;
		var totpayable="";
		var patpayable="";
		var patpaid="";
		var a1=new Array();var a2=new Array();var a3=new Array();
		var formObj = parent.query2.document.edit_enter_main;
		var	totalRecords =eval(formObj.total_records.value);	
		for(var i=0;i<totalRecords;i++)
		{
		  totpayable=eval("document.forms[0].total_pay"+i);
		  patpayable=eval("document.forms[0].patient_pay"+i);
		  patpaid=eval("document.forms[0].patient_paid"+i);
	  
		  a1[i]=totpayable.value;
		  if(a1[i]=="") a1[i]="0.0";
		  totalpayable=parseFloat(totalpayable) + parseFloat(a1[i]);
	
		  a2[i]=patpayable.value;
		  if(a2[i]=="") a2[i]="0.0";
		  patientpayable=parseFloat(patientpayable) + parseFloat(a2[i]);

		  a3[i]=patpaid.value;
		  if(a3[i]=="") a3[i]="0.0";
		  patientpaid=parseFloat(patientpaid) + parseFloat(a3[i]);
	  
		}
		parent.frames[3].document.forms[0].total.value=totalpayable;	
		var totp=eval("parent.frames[3].document.forms[0].total")
		putdeci(totp);
		//alert("totp"+totp.value)
		parent.frames[3].document.forms[0].patient.value=patientpayable;	
		var patp=eval("parent.frames[3].document.forms[0].patient")
		putdeci(patp);		
		//document.forms[0].total_pay_panel.value=totalpayable;
		//document.forms[0].patient_pay_panel.value=patientpayable;

		parent.frames[3].document.forms[0].patient_paid.value=patientpaid;	
		var patpd=eval("parent.frames[3].document.forms[0].patient_paid");
		putdeci(patpd);

		setTimeout('totpayable()',1000);
	}
	function check_box(i)
	{
		var preappr_reqd=eval("document.forms[0].preappr_reqd"+i);

		if(preappr_reqd.value=="checked")
		{
			preappr_reqd.checked=true;
		}
		else
		{
			preappr_reqd.checked=false;
		}
	}

</script>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		</head>

<body onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='edit_enter_main' id='edit_enter_main' method='post' >

<table cellpadding=3 cellspacing=0  width="100%" align='left' id='ins_data' border='1'>

<%
	//l_rec_val="",l_qty="0.0"d_pat_gross_charge_amt=0,
		String l_servicecode="",l_ratecharge="", l_exclincl="",l_reason="", l_practstaff="", l_practstaff_desc="",l_practstaffid=""; String l_uom="",l_incl_excl="",l_serv_qty="",l_preapp_yn="",l_chargeamt="",l_chargeamt_screen="";
		String str_day_type_code="",str_day_type_disc="",str_time_type_code="",str_time_type_desc="",str_credit_auth_ref="";
		String str_excl_incl_ind="",str_preapp_yn="",d_split_ind="",modify_qty_yn="",classval="";	
		String d_net_charge_amt_temp="",d_cust_net_charge_amt_temp="",d_pat_payable_temp="",d_pat_paid_amt_temp="0.00";
		String ratecharge_desc="",str_charged_yn="", str_pat_billed_yn="";
		String str_err_code="",str_sys_message_id="",str_error_text="";
		String str_override_allowed_yn="";String test_var="",str_base_qty="",str_base_rate="";

		double d_addl_factor=0,d_base_chargeamt=0; //d_base_qty=0, d_base_rate=0
		double d_gross_charge_amt=0,d_disc_amt=0, d_net_charge_amt=0,d_disc_perc=0;
		double d_pat_disc_amt=0,d_pat_net_charge_amt=0;
		double d_cust_gross_charge_amt=0, d_cust_disc_amt=0,d_cust_net_charge_amt=0;
		double d_curr_availed=0, d_pat_paid_amt=0.00,d_pat_payable=0,record_select=0,num1=0,num2=0; 
		
	


		try
		{
			if(remove_check.equals("remove"))
			{
				p_string=request.getParameter("p_string");

				if(p_string==null) p_string="";
				totalRecords=a1.size();
				record_select=1;
				for(int i=0;i<totalRecords;i++)
				{	
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
%>
<tr id=row<%=i%>>
	<td class=<%=classval%> width='9%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>
	<!--<td class=<%=classval%> width='5%'><a onClick="modify_remove_payer(<%=i%>);"><u><%=record_select%></u></a></td>-->
	<td class=<%=classval%> width='10%' ><input type='text' name='service<%=i%>' id='service<%=i%>' size='10' readonly maxlength='30'  value="<%=a1.get(i)%>" ><input type=hidden name='blng_serv_code<%=i%>' id='blng_serv_code<%=i%>' value="<%=a2.get(i)%>"></td>
  	<td class=<%=classval%> width='18%' ><input type='text' name='incl_excl<%=i%>' id='incl_excl<%=i%>' size='10' readonly maxlength='30' value="<%=a3.get(i)%>" ></td>
	<td class=<%=classval%> width='18%' ><input type='text' name='incl_excl_action<%=i%>' id='incl_excl_action<%=i%>' size='10' readonly maxlength='30'  value="<%=a4.get(i)%>" ></td>
	<td class=<%=classval%> width='15%' ><input type='text' name='reason<%=i%>' id='reason<%=i%>' size='10' readonly maxlength='30'  value="<%=a5.get(i)%>" ><input type=hidden name='action_reason_code<%=i%>' id='action_reason_code<%=i%>' value='<%=a6.get(i)%>' ></td>
	<td class=<%=classval%> width='5%' ><input type='text' name='ratecharge_desc<%=i%>' id='ratecharge_desc<%=i%>' size='10' readonly maxlength='5'  value="<%=a23.get(i)%>" >
	<input type='hidden' name='charge<%=i%>' id='charge<%=i%>' size='10' readonly maxlength='30'  value="<%=a7.get(i)%>" ></td>
	<%
		System.out.println("modify_qty_yn in Body.jsp::::: "+modify_qty_yn);
	%>
	
  	<td class=<%=classval%> width='15%' ><input type='text' name='original_qty<%=i%>' id='original_qty<%=i%>' size='10' readonly maxlength='7'  value="<%=a8.get(i)%>" style='text-align:right'><input type=hidden name='modify_qty_yn<%=i%>' id='modify_qty_yn<%=i%>' value='<%=a9.get(i)%>' ></td>
	<td class=<%=classval%> width='10%' ><input type='text' name='uom<%=i%>' id='uom<%=i%>' size='4' readonly maxlength='30'  value="<%=a10.get(i)%>" ><input type=hidden name='uom_code<%=i%>' id='uom_code<%=i%>' value="<%=a11.get(i)%>" ></td>
	<td class=<%=classval%> width='20%' ><input type='text' name='revise_qty<%=i%>' id='revise_qty<%=i%>' size='10' readonly maxlength='7'  value="<%=a12.get(i)%>" style='text-align:right'></td>
	<td class=<%=classval%> width='4%' ><input type='text' name='total_qty<%=i%>' id='total_qty<%=i%>' size='10' readonly maxlength='7'  value="<%=a13.get(i)%>" style='text-align:right'></td>
</tr>
<tr>
	<td class=<%=classval%> width='9%' ></td>
	<td class=<%=classval%> width='10%' ><input type='text' name='rate<%=i%>' id='rate<%=i%>' size='14' readonly maxlength='10'  value="<%=a14.get(i)%>" style='text-align:right'></td>
	<td class=<%=classval%> width='18%' ><input type='text' name='practioner_type<%=i%>' id='practioner_type<%=i%>' size='10' readonly maxlength='30'  value='<%=a15.get(i)%>' ><input type=hidden name='pract_id<%=i%>' id='pract_id<%=i%>' value="<%=a16.get(i)%>"></td>
  	<td class=<%=classval%> width='18%' ><input type='text' name='practioner<%=i%>' id='practioner<%=i%>' size='10' readonly maxlength='30'  value="<%=a17.get(i)%>" ><input type=hidden name='pract_staff_id<%=i%>' id='pract_staff_id<%=i%>' value="<%=a22.get(i)%>"></td>
	<td class=<%=classval%> width='15%' ><input type='text' name='total_pay<%=i%>' id='total_pay<%=i%>' size='14' readonly maxlength='30'  value="<%=a18.get(i)%>" style='text-align:right'></td>
	<td class=<%=classval%> width='5%'><input type='text' name='patient_pay<%=i%>' id='patient_pay<%=i%>' size='14' readonly maxlength='30'  value="<%=a19.get(i)%>" style='text-align:right'></td>
	<td class=<%=classval%> width='15%'><input type='text' name='patient_paid<%=i%>' id='patient_paid<%=i%>' size='14' readonly maxlength='30'  value="<%=a20.get(i)%>" style='text-align:right'></td>
	<td class=<%=classval%> width='10%'><input type='checkbox' name='preappr_reqd<%=i%>' id='preappr_reqd<%=i%>' size='10'  maxlength='30' <%=a21.get(i)%> value="<%=a21.get(i)%>" onclick='check_box(<%=i%>)'></td>
	<input type='hidden' name='charged_yn<%=i%>' id='charged_yn<%=i%>' value="<%=a24.get(i)%>">
	<input type='hidden' name='override_allowed_yn<%=i%>' id='override_allowed_yn<%=i%>' value="<%=a25.get(i)%>">
	<input type='hidden' name='serv_amt_changed<%=i%>' id='serv_amt_changed<%=i%>' value="<%=a26.get(i)%>">
	<input type='hidden' name='excl_incl_ind_for_screen<%=i%>' id='excl_incl_ind_for_screen<%=i%>' value="<%=a27.get(i)%>">
	<td colspan=2 class=<%=classval%>>&nbsp;</td>
</tr>
	<%
		System.err.println("a25.get(i):"+a25.get(i));
					record_select++;
				}//for loop		 
			}//if remove check
			else
			{
			  String delimit="<NR>";
			  p_string1 = request.getParameter("p_str");
			  String serv_str=p_string1.replaceAll(delimit,"|");
			  if(serv_str==null) serv_str="";
			  int t1=serv_str.indexOf("|");
			  if(t1!=-1)
			  {
				if(!serv_str.equals("")) 
				{
					try
					{		
						pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
						rscurr = pstmt.executeQuery();	
						while(rscurr.next())
						{
							noofdecimal  =  rscurr.getInt(1);		
						}
						rscurr.close();
						pstmt.close();
					}
					catch(Exception e)
					{
						System.out.println("3="+e.toString());
					}
					String serv_description="";
					String reason_description="";
					String uom_description="";
					String pract_name="";
					int i=0;	
					totalRecords=0;
					record_select=0;
					String p_serv_panel_temp="";
					int t=serv_str.indexOf("|");
					if(t!=-1)
					{
						p_string = serv_str.substring(0,t);
						p_serv_panel_temp=serv_str.substring(t);
					}
					else
					{
						p_serv_panel_temp=serv_str;
					}
				
					StringTokenizer st = new StringTokenizer(p_serv_panel_temp,"|");
					int count = 0;	
					
					while(st.hasMoreTokens())
					{
						count++;			
						String string1 = st.nextToken();		
						StringTokenizer st1 = new StringTokenizer(string1,"#");				
						while(st1.hasMoreTokens())
						{
							l_servicecode = st1.nextToken();
							System.err.println("l_servicecode :"+l_servicecode);
							if(l_servicecode.equals(" ")) l_servicecode="";
							try
							{
								pstmt = con.prepareStatement( " select LONG_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+l_servicecode +"'and LANGUAGE_ID ='"+locale+"' ");
				
								rsserv_desc = pstmt.executeQuery();	
		
								while(rsserv_desc.next())
								{
								   serv_description  =  rsserv_desc.getString(1);							
								}	
								rsserv_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							try
							{	
								pstmt = con.prepareStatement( " select NVL(MODIFY_QTY_DURING_ENTRY,'N') from bl_panel_dtl where 	operating_facility_id ='"+p_facility_id+"'  and panel_code = '"+p_service_panel_code+"' and blng_serv_code = '"+l_servicecode+"' ");			
								modify_qty_yn="";
								rsserv_qty = pstmt.executeQuery();	
								while(rsserv_qty.next())
								{
									modify_qty_yn  =  rsserv_qty.getString(1);	
								}
								rsserv_qty.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							l_ratecharge = st1.nextToken();
							if(l_ratecharge.equals(" ")) l_ratecharge="";
		
							if(l_ratecharge.equals("R"))
							{
								ratecharge_desc=rate_label;
							}
							else
							{
								ratecharge_desc=charge_label;
							}
							l_exclincl = st1.nextToken();							
							if(l_exclincl.equals(" ")) l_exclincl="";


							p_override_yn=l_exclincl;		//p_override_incl_excl_ind


							if(l_exclincl.equals("I")) l_exclincl=include_label;
							else if(l_exclincl.equals("E")) l_exclincl=exclude_label;	
							l_reason = st1.nextToken();
							if(l_reason.equals(" ")) l_reason="";
							try
							{
								pstmt = con.prepareStatement( " select ACTION_REASON_DESC     from   bl_action_reason_lang_vw where ACTION_REASON_CODE ='"+l_reason+"' and LANGUAGE_ID = '"+locale+"' ");

								rsreson_desc = pstmt.executeQuery();	
								reason_description="";
								while(rsreson_desc.next())
								{
									reason_description  =  rsreson_desc.getString(1);		
								}	
								rsreson_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("2="+e.toString());
							}
							l_practstaff = st1.nextToken();
							if(l_practstaff.equals(" ")) l_practstaff="";

							if(l_practstaff.equals("P")){l_practstaff_desc="Practitioner";}
							if(l_practstaff.equals("O")){l_practstaff_desc="OtherStaff";}
							l_practstaffid = st1.nextToken();
							if(l_practstaffid.equals(" ")) l_practstaffid="";
							try
							{
								pstmt = con.prepareStatement("SELECT NAME FROM BL_AM_PRACT_STAFF_VW WHERE PRACT_STAFF_IND='"+l_practstaff+"' AND PRACTITIONER_ID    = '"+l_practstaffid+"' AND LANGUAGE_ID = '"+locale+"' and facility_id='"+p_facility_id+"'");	
							
								pract_name="";
								rspractname = pstmt.executeQuery();	
								while(rspractname.next())
								{
									pract_name  =  rspractname.getString(1);		
								}	
								rspractname.close();
								pstmt.close();
							}
							catch(Exception e) 
							{
								System.out.println("3="+e.toString());
							}
							l_uom = st1.nextToken();
							if(l_uom.equals(" ")) l_uom="";
							try
							{
								String uom_sql=" select LONG_DESC from am_uom_lang_vw where UOM_CODE = '"+l_uom+"' and LANGUAGE_ID = '"+locale+"' ";	

								pstmt = con.prepareStatement(uom_sql );
								rsuomdesc = pstmt.executeQuery();	
								if(rsuomdesc!=null && rsuomdesc.next())
								{
									uom_description  =  rsuomdesc.getString(1);		
								}				
								rsuomdesc.close();
								pstmt.close();
							}
							catch(Exception e) 
							{
								System.out.println("3="+e.toString());
							}
							l_incl_excl=st1.nextToken();
							if(l_incl_excl.equals(" ")) l_incl_excl="";
							if(l_incl_excl.equals("E"))
							{
								l_incl_excl=exclude_label;
							}
							else if(l_incl_excl.equals("I"))
							{
								l_incl_excl=include_label;
							}
							//else if(l_exclincl.equals("")) l_exclincl=exclude_label;
							l_preapp_yn = st1.nextToken();
							if(l_preapp_yn.equals(" ")) l_preapp_yn="";
							if(l_preapp_yn.equals("Y"))
							{
								str="checked";
							}
							l_serv_qty = st1.nextToken();
							if(l_serv_qty.equals(" ")) l_serv_qty="";
								System.err.println("8.3:"+l_serv_qty);
							l_chargeamt = st1.nextToken();
							if(l_chargeamt.equals(" ")) l_chargeamt="";
							//l_qty = cf.formatCurrency(l_qty, noofdecimal);
							//l_chargeamt = cf.formatCurrency(l_chargeamt, noofdecimal);
							l_chargeamt_screen = l_chargeamt;

							l_serv_qty = cf.formatCurrency(l_serv_qty, noofdecimal);
							panel_qty = cf.formatCurrency(panel_qty_for_hidden, noofdecimal);
							serv_qty=Double.parseDouble(l_serv_qty);
							db_panel_qty =Double.parseDouble(panel_qty); 
							double temp = 0.0;
					
							if(l_ratecharge.equals("R"))
							{
								temp = serv_qty*db_panel_qty;
							}
							else
							{
								temp = serv_qty;
							}
							panel_qty=cf.formatCurrency(String.valueOf(temp), noofdecimal);
	//		double charge_amt=Double.parseDouble(l_chargeamt);	//enabled for testing by muthu

// charge amt is nullified for Rate Based services
		//		System.out.println(" Rate charege details "+l_ratecharge); 
				//commented By DhanasekarV start  IN036427
		/*							if(l_ratecharge.equals("R"))
							{
								l_chargeamt="";
							}
							*/
							if(!l_servicecode.equals(""))
							{
								try
								{
									String serv_panel_str="";					
									if(p_service_panel_ind.equals("L"))
									{
										serv_panel_str=l_servicecode;
									}
									else
									{
										serv_panel_str=p_service_panel_code;
									}
									if(((strp_episode_id.equals("0") && strp_visit_id.equals("0")) && !p_episode_type.equals("R")) || ((strp_episode_id.equals("0") && strp_visit_id.equals("0")) && p_episode_type.equals("R")))
									{
										String p_service_panel_ind_temp="S";

										if(p_episode_type.equals("R") && p_module_id.equals("OR"))
										{
											
											String sqloverride="{ call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','R','"+str_null+"','"+str_null+"','"+p_patient_id+"','"+serv_panel_str+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),?,?)}";
											CallableStatement call = con.prepareCall(sqloverride);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
											String sqlbefreg="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS('"+p_facility_id+"','"+p_module_id+"','R','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+str_null+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+l_chargeamt_screen+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";
											//if(serv_panel_str.equals("LZZ_FREE"))


											call = con.prepareCall(sqlbefreg);	
											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.DOUBLE);
											call.registerOutParameter(4,java.sql.Types.DOUBLE);
											call.registerOutParameter(5,java.sql.Types.DOUBLE);
											call.registerOutParameter(6,java.sql.Types.DOUBLE);
											call.registerOutParameter(7,java.sql.Types.DOUBLE);
											call.registerOutParameter(8,java.sql.Types.DOUBLE);
											call.registerOutParameter(9,java.sql.Types.DOUBLE);
											call.registerOutParameter(10,java.sql.Types.DOUBLE);
											call.registerOutParameter(11,java.sql.Types.DOUBLE);
											call.registerOutParameter(12,java.sql.Types.DOUBLE);
											call.registerOutParameter(13,java.sql.Types.DOUBLE);
											call.registerOutParameter(14,java.sql.Types.DOUBLE);	
											call.registerOutParameter(15,java.sql.Types.VARCHAR);	
											call.registerOutParameter(16,java.sql.Types.DOUBLE);
											call.registerOutParameter(17,java.sql.Types.VARCHAR);
											call.registerOutParameter(18,java.sql.Types.VARCHAR);
											call.registerOutParameter(19,java.sql.Types.VARCHAR);	
											call.registerOutParameter(20,java.sql.Types.VARCHAR);
											call.registerOutParameter(21,java.sql.Types.VARCHAR);
											call.registerOutParameter(22,java.sql.Types.VARCHAR);
											call.registerOutParameter(23,java.sql.Types.VARCHAR);
											call.registerOutParameter(24,java.sql.Types.VARCHAR);
											call.registerOutParameter(25,java.sql.Types.VARCHAR);
											call.registerOutParameter(26,java.sql.Types.VARCHAR);
											call.registerOutParameter(27,java.sql.Types.VARCHAR);
										
											call.execute();	

											str_base_qty = call.getString(5);
											 if(str_base_qty==null) str_base_qty="";
											str_base_rate = call.getString(6);
											 if(str_base_rate==null) str_base_rate="";

											// if (str_base_rate!=0) 
											str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
									
											d_net_charge_amt=call.getDouble(11);
											d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
											
											
											if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
											if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
			
											d_cust_net_charge_amt=call.getDouble(18);
											d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

											if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
											if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
//											test_var=call.getString(18);
										
											str_err_code=call.getString(25);
											if(str_err_code==null) str_err_code="";
										
											str_sys_message_id=call.getString(26);   
											if(str_sys_message_id==null) str_sys_message_id="";
											
											str_error_text=call.getString(27);
											if(str_error_text==null) str_error_text="";		
											d_pat_payable = Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
									
											d_pat_payable_temp=String.valueOf(d_pat_payable);
									

											if(d_pat_payable==0) d_pat_payable_temp="0.00";
											if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);	

											call.close();
										}
										else
										{
											CallableStatement call = null;
											/*String sqloverride_bef_reg="{ call blcommon.bl_chk_ex_in_ovrride_bef_reg('"+p_facility_id+"','"+p_episode_type+"','"+p_patient_id+"','"+policy_type_code+"','"+cust_group_code+"','"+cust_code+"','"+policy_priority+"','"+l_servicecode+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),'"+policy_eff_from_date+"','"+policy_eff_to_date+"',?)}";
											CallableStatement call = con.prepareCall(sqloverride_bef_reg);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											*/
											try
											{
											String sqloverride_bef_reg="{ call BL_PROC_ITEM_VALIDATIONS_MP.GET_BLNG_SERV_VALS('"+p_facility_id+"','"+p_module_id+"','"+str_epi_type_clinic_code+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?)}";
											call = con.prepareCall(sqloverride_bef_reg);

											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.VARCHAR);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.registerOutParameter(5,java.sql.Types.VARCHAR);
											call.registerOutParameter(6,java.sql.Types.VARCHAR);
											call.registerOutParameter(7,java.sql.Types.VARCHAR);
											call.execute();
											str_override_allowed_yn=call.getString(3);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
											
											str_err_code=call.getString(5);
											if(str_err_code==null) str_err_code="";
										
											str_sys_message_id=call.getString(6);   
											if(str_sys_message_id==null) str_sys_message_id="";
											
											str_error_text=call.getString(7);
											if(str_error_text==null) str_error_text="";	

											call.close();
											}
											catch(Exception e)
											{
												System.err.println("Error when calling BL_PROC_ITEM_VALIDATIONS_MP.GET_BLNG_SERV_VALS:"+e);
											}

											if((str_err_code.equals("10") && !str_err_code.equals("")) || !str_sys_message_id.equals(""))
											{
												if (str_err_code.equals("10") && !str_err_code.equals(""))
												{
%>
													<script>
													var strErrorMessage = '<%=str_error_text%>';
													alert(strErrorMessage);
													</script>
<%
												}
												if(!str_sys_message_id.equals(""))
												{
													System.err.println("In Body Page2.1");
%>
												   <script>
													alert(getMessage('<%=str_sys_message_id%>','BL'));
												   </script>
<%	
												}	
											}
											else
											{
												String sqlbefreg="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS_BEF_REG('"+p_facility_id+"','"+p_module_id+"','"+str_epi_type_clinic_code+"','"+p_patient_id+"','"+str_encounter_id+"','"+strp_episode_id+"','"+strp_visit_id+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+l_chargeamt+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"','"+user_id+"','"+ws_num+"','"+str_acct_seq_no+"','"+p_override_yn+"','"+locale+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
												//if(serv_panel_str.equals("LZZ_FREE"))


												call = con.prepareCall(sqlbefreg);	
												call.registerOutParameter(1,java.sql.Types.VARCHAR);
												call.registerOutParameter(2,java.sql.Types.VARCHAR);
												call.registerOutParameter(3,java.sql.Types.DOUBLE);
												call.registerOutParameter(4,java.sql.Types.DOUBLE);
												call.registerOutParameter(5,java.sql.Types.DOUBLE);
												call.registerOutParameter(6,java.sql.Types.DOUBLE);
												call.registerOutParameter(7,java.sql.Types.DOUBLE);
												call.registerOutParameter(8,java.sql.Types.DOUBLE);
												call.registerOutParameter(9,java.sql.Types.DOUBLE);
												call.registerOutParameter(10,java.sql.Types.DOUBLE);
												call.registerOutParameter(11,java.sql.Types.DOUBLE);
												call.registerOutParameter(12,java.sql.Types.DOUBLE);
												call.registerOutParameter(13,java.sql.Types.DOUBLE);
												call.registerOutParameter(14,java.sql.Types.DOUBLE);	
												call.registerOutParameter(15,java.sql.Types.VARCHAR);	
												call.registerOutParameter(16,java.sql.Types.DOUBLE);
												call.registerOutParameter(17,java.sql.Types.VARCHAR);
												call.registerOutParameter(18,java.sql.Types.VARCHAR);
												call.registerOutParameter(19,java.sql.Types.VARCHAR);	
												call.registerOutParameter(20,java.sql.Types.VARCHAR);
												call.registerOutParameter(21,java.sql.Types.VARCHAR);
//												call.registerOutParameter(22,java.sql.Types.VARCHAR);
											
												call.execute();	
												str_base_qty = call.getString(1);
												 if(str_base_qty==null) str_base_qty="";
												str_base_rate = call.getString(2);
												 if(str_base_rate==null) str_base_rate="";

												// if (str_base_rate!=0) 
												str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
										
												d_net_charge_amt=call.getDouble(7);
												d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
												
												
												if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
												if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
				
												d_cust_net_charge_amt=call.getDouble(14);
												d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

												if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
												if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
												test_var=call.getString(18);
/*
												str_override_allowed_yn=call.getString(19);
												if(str_override_allowed_yn == null) str_override_allowed_yn = "N";
*/											
												str_err_code=call.getString(19);
												if(str_err_code==null) str_err_code="";
											
												str_sys_message_id=call.getString(20);   
												if(str_sys_message_id==null) str_sys_message_id="";
												
												str_error_text=call.getString(21);
												if(str_error_text==null) str_error_text="";		
												d_pat_payable = Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										
												d_pat_payable_temp=String.valueOf(d_pat_payable);
										

												if(d_pat_payable==0) d_pat_payable_temp="0.00";
												if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);	
										
												call.close();
											}
										}
									}
									else
									{

										String p_service_panel_ind_temp="S";

//										String sqloverride="{ call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','"+p_episode_type+"','"+strp_episode_id+"','"+strp_visit_id+"','"+p_patient_id+"','"+l_servicecode+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI'),?)}";
										String sqloverride="{ call BL_PROC_ITEM_VALIDATIONS_MP1.bl_check_excl_incl_override('"+p_facility_id+"','"+p_patient_id+"','"+p_episode_type+"','"+str_encounter_id+"','"+strp_episode_id+"','"+strp_visit_id+"',to_date('"+p_service_date+"','dd/mm/yyyy HH24:MI')"+",'"+l_servicecode+"','"+p_order_item+"','"+p_module_id+"',?,?,?,?)}";
										CallableStatement call = con.prepareCall(sqloverride);
										
										try
										{
											call.registerOutParameter(1,java.sql.Types.VARCHAR);
											call.registerOutParameter(2,java.sql.Types.VARCHAR);
											call.registerOutParameter(3,java.sql.Types.VARCHAR);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.execute();

											str_override_allowed_yn=call.getString(1);
											if(str_override_allowed_yn==null) str_override_allowed_yn="";
											//Changed for IN50765 
											if("Y".equals(str_override_allowed_yn)) str_override_allowed_yn="B";
							   System.out.println("str_override_allowed_yn  "+str_override_allowed_yn);													
											
											str_err_code=call.getString(2);
										    if(str_err_code==null) str_err_code="";
		
											str_sys_message_id=call.getString(3);   
										    if(str_sys_message_id==null) str_sys_message_id="";
	
											str_error_text=call.getString(4);
											if(str_error_text==null) str_error_text="";

										}
										catch(Exception e)
										{
											System.err.println("Error while calling BL_PROC_ITEM_VALIDATIONS_MP.bl_check_excl_incl_override:"+e);
										}
										/*	String sqltest="{ call BL_PROC_ITEM_VALIDATIONS_MP.GET_BILL_DETAILS('"+p_facility_id+"','"+p_module_id+"','"+p_episode_type+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+p_encounter_id+"','"+p_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+p_order_item+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+serv_qty+"','"+charge_amt+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";
	
										CallableStatement call = con.prepareCall(sqltest);
										call.registerOutParameter(1,java.sql.Types.VARCHAR);
										call.registerOutParameter(2,java.sql.Types.VARCHAR);
										call.registerOutParameter(3,java.sql.Types.VARCHAR);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.DOUBLE);
										call.registerOutParameter(6,java.sql.Types.DOUBLE);
										call.registerOutParameter(7,java.sql.Types.DOUBLE);
										call.registerOutParameter(8,java.sql.Types.DOUBLE);
										call.registerOutParameter(9,java.sql.Types.DOUBLE);
										call.registerOutParameter(10,java.sql.Types.DOUBLE);
										call.registerOutParameter(11,java.sql.Types.DOUBLE);
										call.registerOutParameter(12,java.sql.Types.DOUBLE);
										call.registerOutParameter(13,java.sql.Types.DOUBLE);
										call.registerOutParameter(14,java.sql.Types.DOUBLE);
										call.registerOutParameter(15,java.sql.Types.DOUBLE);
										call.registerOutParameter(16,java.sql.Types.DOUBLE);
										call.registerOutParameter(17,java.sql.Types.DOUBLE);
										call.registerOutParameter(18,java.sql.Types.DOUBLE);
										call.registerOutParameter(19,java.sql.Types.VARCHAR);	
										call.registerOutParameter(20,java.sql.Types.DOUBLE);
										call.registerOutParameter(21,java.sql.Types.VARCHAR);
										call.registerOutParameter(22,java.sql.Types.VARCHAR);
										call.registerOutParameter(23,java.sql.Types.VARCHAR);	
										call.registerOutParameter(24,java.sql.Types.DOUBLE);
										call.registerOutParameter(25,java.sql.Types.VARCHAR);
										call.registerOutParameter(26,java.sql.Types.VARCHAR);
										call.registerOutParameter(27,java.sql.Types.VARCHAR);
								
										call.execute();		
								
										str_day_type_code=call.getString(1);	   
										if(str_day_type_code==null) str_day_type_code="";
										
										str_day_type_disc=call.getString(2);	 
										if(str_day_type_disc==null) str_day_type_disc="";
	
									    str_time_type_code=call.getString(3);
										if(str_time_type_code==null) str_time_type_code="";
									 
										str_time_type_desc=call.getString(4);	
									    if(str_time_type_desc==null) str_time_type_desc="";
									
										d_base_qty=call.getDouble(5);
										d_base_rate=call.getDouble(6);
										d_addl_factor=call.getDouble(7);
										d_base_chargeamt=call.getDouble(8); 
										d_gross_charge_amt=call.getDouble(9);
									    d_disc_amt=call.getDouble(10); 
									
										d_net_charge_amt=call.getDouble(11); 
										d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);

										if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
										if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,2);
									     
										d_disc_perc=call.getDouble(12);
									    d_pat_gross_charge_amt=call.getDouble(13);
									    d_pat_disc_amt=call.getDouble(14);
									    d_pat_net_charge_amt=call.getDouble(15);
										d_cust_gross_charge_amt=call.getDouble(16);
										d_cust_disc_amt=call.getDouble(17);
									    d_cust_net_charge_amt=call.getDouble(18);	
										d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

										if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
										if (d_cust_net_charge_amt!=0)
										{
											d_cust_net_charge_amt_temp = cf.formatCurrency(d_cust_net_charge_amt_temp,2);
										}
									    d_split_ind=call.getString(19);
										if(d_split_ind==null) d_split_ind="";
									    d_curr_availed=call.getDouble(20);  
										str_credit_auth_ref=call.getString(21);
										if(str_credit_auth_ref==null) str_credit_auth_ref="";
									    str_excl_incl_ind=call.getString(22);    
									    str_preapp_yn=call.getString(23);
									    if(str_day_type_disc==null) str_day_type_disc="";
									    d_pat_paid_amt=call.getDouble(24);  
										d_pat_paid_amt_temp=String.valueOf(d_pat_paid_amt);

										if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
										if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf.formatCurrency(d_pat_paid_amt_temp,2);
		
										str_err_code=call.getString(25);
									    if(str_err_code==null) str_err_code="";
	
										str_sys_message_id=call.getString(26);   
									    if(str_sys_message_id==null) str_sys_message_id="";
	
										str_error_text=call.getString(27);
										if(str_error_text==null) str_error_text="";	
			
										d_pat_payable = 	Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										d_pat_payable_temp=String.valueOf(d_pat_payable);

										if(d_pat_payable==0) d_pat_payable_temp="0.00";
										if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,2);
			
										call.close();*/
										
										String sqltest="{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DETAILS('"+p_facility_id+"','"+p_module_id+"','"+p_order_id+"','"+p_order_line_no+"','"+p_episode_type+"','"+p_patient_id+"','"+strp_episode_id+"','"+strp_visit_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),?,?,?,?,'"+p_order_item+"','"+p_service_panel_ind_temp+"','"+serv_panel_str+"','"+panel_qty+"','"+l_chargeamt+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+p_override_yn+"',?,?,'"+locale+"',?,?,?)}";

										
										 call = con.prepareCall(sqltest);
/*
										CallableStatement call = con.prepareCall("{ call 	BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DETAILS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 

										call.setString(1,p_facility_id);//facility_id
										call.setString(2,p_module_id);	//module_id	
										call.setString(3,p_order_id); //p_order_id
										call.setString(4,p_order_line_no); //p_order_line_no
										call.setString(5,p_episode_type);//episode_type
										call.setString(6,p_patient_id);
										call.setString(7,strp_episode_id);
										call.setString(8,strp_visit_id);//visit_id
										call.setString(9,str_encounter_id);
										call.setString(10,str_acct_seq_no);					
										call.setString(11,p_service_date);
										call.setString(16,p_order_item);//item_code
										call.setString(17,p_service_panel_ind_temp);//service_panel_ind
										call.setString(18,serv_panel_str);//service_panel_code
										call.setDouble(19,serv_qty);//se
										call.setString(20,String.valueOf(charge_amt));
*/
										call.setDouble(24,num1);
										call.setDouble(25,num2);
/*
										call.setString(43,p_override_yn);
										call.setString(46,locale);
*/
										call.registerOutParameter(1,java.sql.Types.VARCHAR);
										call.registerOutParameter(2,java.sql.Types.VARCHAR);
										call.registerOutParameter(3,java.sql.Types.VARCHAR);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.registerOutParameter(7,java.sql.Types.DOUBLE);
										call.registerOutParameter(8,java.sql.Types.DOUBLE);
										call.registerOutParameter(9,java.sql.Types.DOUBLE);
										call.registerOutParameter(10,java.sql.Types.DOUBLE);
										call.registerOutParameter(11,java.sql.Types.DOUBLE);
										call.registerOutParameter(12,java.sql.Types.DOUBLE);
										call.registerOutParameter(13,java.sql.Types.DOUBLE);
										call.registerOutParameter(14,java.sql.Types.DOUBLE);
										call.registerOutParameter(15,java.sql.Types.DOUBLE);
										call.registerOutParameter(16,java.sql.Types.DOUBLE);
										call.registerOutParameter(17,java.sql.Types.DOUBLE);
										call.registerOutParameter(18,java.sql.Types.DOUBLE);
										call.registerOutParameter(19,java.sql.Types.VARCHAR);	
										call.registerOutParameter(20,java.sql.Types.DOUBLE);
										call.registerOutParameter(21,java.sql.Types.VARCHAR);
										call.registerOutParameter(22,java.sql.Types.VARCHAR);
										call.registerOutParameter(23,java.sql.Types.VARCHAR);	
										call.registerOutParameter(24,java.sql.Types.DOUBLE);
										call.registerOutParameter(25,java.sql.Types.DOUBLE);
										call.registerOutParameter(26,java.sql.Types.VARCHAR);
										call.registerOutParameter(27,java.sql.Types.VARCHAR);
										call.registerOutParameter(28,java.sql.Types.DOUBLE);
										call.registerOutParameter(29,java.sql.Types.VARCHAR);
										call.registerOutParameter(30,java.sql.Types.VARCHAR);
										call.registerOutParameter(31,java.sql.Types.VARCHAR);
									
										call.execute();	
	
										str_day_type_code=call.getString(1);	 
										if(str_day_type_code==null) str_day_type_code="";
	
										str_day_type_disc=call.getString(2);	 
										if(str_day_type_disc==null) str_day_type_disc="";
		
										str_time_type_code=call.getString(3);
									    if(str_time_type_code==null) str_time_type_code="";
		
										str_time_type_desc=call.getString(4);	
									    if(str_time_type_desc==null) str_time_type_desc="";									
										//d_base_qty=call.getDouble(5);
									    //d_base_rate=call.getDouble(6);
										str_base_qty = call.getString(5);
										 if(str_base_qty==null) str_base_qty="";
										str_base_rate = call.getString(6);
										 if(str_base_rate==null) str_base_rate="";
										 str_base_rate = cf.formatCurrency(str_base_rate,noofdecimal);
										//if (str_base_rate!=0) str_base_rate =  
										//cf.formatCurrency(str_base_rate,noofdecimal);										

									    d_addl_factor=call.getDouble(7);



									    d_base_chargeamt=call.getDouble(8); 
										d_gross_charge_amt=call.getDouble(9);
									    d_disc_amt=call.getDouble(10); 
										d_net_charge_amt=call.getDouble(11); 

										if(d_net_charge_amt<0) d_net_charge_amt=0;
										d_net_charge_amt_temp=String.valueOf(d_net_charge_amt);
										if(d_net_charge_amt==0) d_net_charge_amt_temp="0.00";
										if (d_net_charge_amt!=0) d_net_charge_amt_temp = cf.formatCurrency(d_net_charge_amt_temp,noofdecimal);
										d_disc_perc=call.getDouble(12);
										// d_pat_gross_charge_amt=call.getDouble(29);
									    d_pat_disc_amt=call.getDouble(14);
									    d_pat_net_charge_amt=call.getDouble(15);
									    d_cust_gross_charge_amt=call.getDouble(16);
									    d_cust_disc_amt=call.getDouble(17);
									    d_cust_net_charge_amt=call.getDouble(18);	
										d_cust_net_charge_amt_temp=String.valueOf(d_cust_net_charge_amt);

										if(d_cust_net_charge_amt==0) d_cust_net_charge_amt_temp="0.00";
										
										if (d_cust_net_charge_amt!=0) d_cust_net_charge_amt_temp = 	cf.formatCurrency(d_cust_net_charge_amt_temp,noofdecimal);
										d_split_ind=call.getString(19);
									    if(d_split_ind==null) d_split_ind="";
										d_curr_availed=call.getDouble(20);  
										str_credit_auth_ref=call.getString(21);
									    if(str_credit_auth_ref==null) str_credit_auth_ref="";
										str_charged_yn=call.getString(22);
									    if(str_charged_yn==null) str_charged_yn="";
										str_pat_billed_yn=call.getString(23);
									    if(str_pat_billed_yn==null) str_pat_billed_yn="";
										num1=call.getDouble(24);
										num2=call.getDouble(25);
									    str_excl_incl_ind=call.getString(26);    
									    str_preapp_yn=call.getString(27);    
									    d_pat_paid_amt=call.getDouble(28);  
										
										d_pat_paid_amt_temp=String.valueOf(d_pat_paid_amt);

										if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
										if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf.formatCurrency(d_pat_paid_amt_temp,noofdecimal);	
									
										str_err_code=call.getString(29);
									    if(str_err_code==null) str_err_code="";
									    
										str_sys_message_id=call.getString(30);   
									    if(str_sys_message_id==null) str_sys_message_id="";
									    
										str_error_text=call.getString(31);
									    if(str_error_text==null) str_error_text="";	
								
										d_pat_payable = 	Double.parseDouble(d_net_charge_amt_temp)-Double.parseDouble(d_cust_net_charge_amt_temp);
										d_pat_payable_temp=String.valueOf(d_pat_payable);

										if(d_pat_payable==0) d_pat_payable_temp="0.00";
										if (d_pat_payable!=0) d_pat_payable_temp = cf.formatCurrency(d_pat_payable_temp,noofdecimal);
										
										
									
										call.close();
									
									}
								}//try
								catch(Exception exp1)
								{			
									System.out.println("error pay amt"+exp1);
								}
							}//if end for procdeure		
									
						 }//inner while st	
	
						if((str_err_code.equals("10") && !str_err_code.equals("")) || !str_sys_message_id.equals(""))
						{
							if (str_err_code.equals("10") && !str_err_code.equals(""))
							{
%>
								<script>
								var strErrorMessage = '<%=str_error_text%>';
								alert(strErrorMessage);
								</script>
<%
							}
							if(!str_sys_message_id.equals(""))
							{
%>
							   <script>
								alert(getMessage('<%=str_sys_message_id%>','BL'));
							   </script>
<%	
							}	
						}
						else
						{
 							if(i % 2 == 0 )
							{
								classval	=	"QRYEVEN";
							}
							else
							{
								classval	=	"QRYODD";
							}
%>
<tr id=row<%=i%>>
	<td class=<%=classval%> width='9%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' onClick="selected(<%=i%>)"></td>	
	<!--<td class=<%=classval%> width='5%'><a onClick="modify_remove_payer(<%=i%>);"><u><%=record_select%></u></a></td>-->
	<td class=<%=classval%> width='10%' ><input type='text' name='service<%=i%>' id='service<%=i%>' size='10' readonly maxlength='30'  value="<%=serv_description%>" ><input type=hidden name='blng_serv_code<%=i%>' id='blng_serv_code<%=i%>' value="<%=l_servicecode%>" ></td>
	<td class=<%=classval%> width='18%' ><input type='text' name='incl_excl<%=i%>' id='incl_excl<%=i%>' size='10' readonly maxlength='15' value="<%=l_incl_excl%>" ></td>
	<td class=<%=classval%> width='18%' ><input type='text' name='incl_excl_action<%=i%>' id='incl_excl_action<%=i%>' size='10' readonly maxlength='15'  value="<%=l_exclincl%>" ></td>
	<td class=<%=classval%> width='15%' ><input type='text' name='reason<%=i%>' id='reason<%=i%>' size='10' readonly maxlength='30'  value="<%=reason_description%>" ><input type=hidden name='action_reason_code<%=i%>' id='action_reason_code<%=i%>' value="<%=l_reason%>" ></td>
	<td class=<%=classval%> width='5%' ><input type='text' name='ratecharge_desc<%=i%>' id='ratecharge_desc<%=i%>' size='10' readonly maxlength='5'  value="<%=ratecharge_desc%>" ><input type='hidden' name='charge<%=i%>' id='charge<%=i%>' size='10' readonly maxlength='5'  value="<%=l_ratecharge%>" ></td>


	<td class=<%=classval%> width='15%' ><input type='text' name='original_qty<%=i%>' id='original_qty<%=i%>' size='10' readonly maxlength='7'  value='<%=l_serv_qty%>' style='text-align:right'><input type=hidden name='modify_qty_yn<%=i%>' id='modify_qty_yn<%=i%>' value='<%=modify_qty_yn%>' ></td>

	<td class=<%=classval%> width='10%' ><input type='text' name='uom<%=i%>' id='uom<%=i%>' size='4' readonly maxlength='30'  value='<%=uom_description%>' ><input type=hidden name='uom_code<%=i%>' id='uom_code<%=i%>' value="<%=l_uom%>" ></td>


	<td class=<%=classval%> width='20%' ><input type='text' name='revise_qty<%=i%>' id='revise_qty<%=i%>' size='10' readonly maxlength='7'  value="<%=l_serv_qty%>" style='text-align:right'></td>
	<td class=<%=classval%> width='4%' ><input type='text' name='total_qty<%=i%>' id='total_qty<%=i%>' size='10' readonly maxlength='7'  value="<%=panel_qty%>" style='text-align:right'></td>
</tr>
<tr>
	<td class=<%=classval%> width='9%' ></td>
	<td class=<%=classval%> width='10%' ><input type='text' name='rate<%=i%>' id='rate<%=i%>' size='10' readonly maxlength='10'  value="<%=str_base_rate%>" style='text-align:right' onfocus='putdeci(this);'></td>
	<td class=<%=classval%> width='18%' ><input type='text' name='practioner_type<%=i%>' id='practioner_type<%=i%>' size='10' readonly maxlength='30'  value="<%=l_practstaff_desc%>" ><input type=hidden name='pract_id<%=i%>' id='pract_id<%=i%>' value='<%=l_practstaff%>' ></td>
  	<td class=<%=classval%> width='18%' ><input type='text' name='practioner<%=i%>' id='practioner<%=i%>' size='10' readonly maxlength='30'  value="<%=pract_name%>" ><input type=hidden name='pract_staff_id<%=i%>' id='pract_staff_id<%=i%>' value="<%=l_practstaffid%>" ></td>


	<td class=<%=classval%> width='15%' ><input type='text' name='total_pay<%=i%>' id='total_pay<%=i%>' size='14' readonly maxlength='30'  value="<%=d_net_charge_amt_temp%>" style='text-align:right'></td>
	<td class=<%=classval%> width='5%'><input type='text' name='patient_pay<%=i%>' id='patient_pay<%=i%>' size='14' readonly maxlength='30'  value="<%=d_pat_payable_temp%>" style='text-align:right'></td>
	<td class=<%=classval%> width='15%'><input type='text' name='patient_paid<%=i%>' id='patient_paid<%=i%>' size='14' readonly maxlength='30'  value="<%=d_pat_paid_amt_temp%>" style='text-align:right'  onfocus='putdeci(this);'></td>
	<td class=<%=classval%> width='10%'><input type='checkbox' name='preappr_reqd<%=i%>' id='preappr_reqd<%=i%>' size='10'  maxlength='30' value='<%=str%>'  <%=str%> readonly	onclick='check_box(<%=i%>)'></td>
	<input type='hidden' name='charged_yn<%=i%>' id='charged_yn<%=i%>' value="<%=str_charged_yn%>">
	<input type='hidden' name='override_allowed_yn<%=i%>' id='override_allowed_yn<%=i%>' value="<%=str_override_allowed_yn%>">

<!--	<td class=<%=classval%> width='20%'><input type='text' name='net_amt<%=i%>' id='net_amt<%=i%>' size='10' readonly maxlength='30'  value="<%=d_net_charge_amt_temp%>" style='text-align:right'  onfocus='putdeci(this);'></td></td>-->

	<input type='hidden' name='serv_amt_changed<%=i%>' id='serv_amt_changed<%=i%>' value="<%=str_base_rate%>">
	<input type='hidden' name='excl_incl_ind_for_screen<%=i%>' id='excl_incl_ind_for_screen<%=i%>' value="">




	<td class=<%=classval%> width='20%'></td>
	<td class=<%=classval%> width='4%'></td>
</tr>
<%
							i++;
							record_select++;
							totalRecords=i;		
						}//while
					}//else	
					}//p_string if
					else
					{
						%>
							<script>
								alert(getMessage("BL9758","BL"));
							</script>
						<%
						//no record found alert messages to be popup
					}
				}
				else
				{
				%>
					<script>
						alert(getMessage("BL9758","BL"));
					</script>
				<%
					//no record found alert messages to be popup
				}
			}//else  for multirecord
		}
		catch(Exception e)
		{
			System.out.println("Exception in Design Layout Else Part"+e);
		}
%>
</table>
<!-- Added by karthik on Oct-18-2012 to default select a practitioner -->
<%
	String session_practitioner=(String)session.getAttribute("sessionPractitioner");
	String session_staff_ind=(String)session.getAttribute("sessionStaffInd");
	String session_staff_id=(String)session.getAttribute("sessionStaffId");
%>
<input type='hidden' name='session_practitioner' id='session_practitioner' value="<%=session_practitioner%>">
<input type='hidden' name='session_staff_ind' id='session_staff_ind' value="<%=session_staff_ind%>">
<input type='hidden' name='session_staff_id' id='session_staff_id' value="<%=session_staff_id%>">
<input type='hidden' name='total_records' id='total_records' value="<%=totalRecords%>">
<input type='hidden' name='focussed_row' id='focussed_row' value='' >
<input type='hidden' name='i' id='i' value='' >
<input type='hidden' name='checked_row' id='checked_row' value='' >
<input type='hidden' name='action_reason_code' id='action_reason_code' value='' >
<input type='hidden' name='pract_staff_type_ind' id='pract_staff_type_ind' value='' >
<input type='hidden' name='pract_staff_type_code' id='pract_staff_type_code' value='' >
<input type='hidden' name='blng_serv_code' id='blng_serv_code' value="<%=l_servicecode%>" >
<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='' >
<input type='hidden' name='p_service_panel_ind' id='p_service_panel_ind' value="<%=p_service_panel_ind%>" >
<%
	if(p_service_panel_ind.equals("L"))
	{
%>
<input type='hidden' name='panel_code' id='panel_code' value='<%=p_service_panel_code%>' >
<%
	}
%>

<input type='hidden' name='cflag' id='cflag' value='' >
<input type='hidden' name='str' id='str' value="<%=str%>" >
<input type='hidden' name='p_string' id='p_string' value="<%=p_string%>" >
<input type='hidden' name='added_serv_yn' id='added_serv_yn' value="<%=added_serv_yn%>" >
<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
<input type='hidden' name='total_pay_panel' id='total_pay_panel' value='' >
<input type='hidden' name='patient_pay_panel' id='patient_pay_panel' value=''>
<input type='hidden' name='query_string' id='query_string' value="<%=query_string%>" >
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=str_encounter_id%>" >
<input type='hidden' name='acc_seq_no' id='acc_seq_no' value="<%=str_acct_seq_no%>" >
<input type='hidden' name='rate_label' id='rate_label' value="<%=rate_label%>" >
<input type='hidden' name='charge_label' id='charge_label' value="<%=charge_label%>" >
<input type='hidden' name='include_label' id='include_label' value="<%=include_label%>" >
<input type='hidden' name='exclude_label' id='exclude_label' value="<%=exclude_label%>" >
<input type='hidden' name='panel_qty' id='panel_qty' value="<%=panel_qty_for_hidden%>" >

<input type='hidden' name='str_epi_type_clinic_code' id='str_epi_type_clinic_code' value="<%=str_epi_type_clinic_code%>" >


</form>
</body>
<script>
//	var query_string=document.forms[0].query_string.value;
	//var include_label=document.forms[0].include_label.value;	
	//var exclude_label=document.forms[0].exclude_label.value;
	//var rate_label=document.forms[0].rate_label.value;
	//var charge_label=document.forms[0].charge_label.value;	

	
	parent.frames[3].location.href="../../eBL/jsp/BLEnterEditChargeDetailsBtn.jsp?<%=query_string%>";			//parent.frames[3].location.href="../../eBL/jsp/BLEnterEditChargeDetials4.jsp?include_label="+include_label+"&exclude_label="+exclude_label+"&rate_label="+rate_label+"&charge_label="+charge_label+"&"+query_string;	
	
</script>

<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception Try"+e);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

</html>

