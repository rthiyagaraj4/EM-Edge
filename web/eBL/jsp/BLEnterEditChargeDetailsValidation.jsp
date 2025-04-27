<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*,eBL.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations for OR Logic Implementation start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs1 = null;ResultSet rs2 = null;	
	ResultSet rs_dec = null;
	CurrencyFormat cf = new CurrencyFormat();

	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");		
		HttpSession httpSession = request.getSession(false);
		String locale	= (String)session.getAttribute("LOCALE");
		con	=	ConnectionManager.getConnection(request);	
		Properties p = (Properties)httpSession.getValue("jdbc");	
        //320
	double max_chg_amt=0;
		//320
		String str_rate_chr_ind="";
		String p_facility_id = ""; 	String p_login_user = ""; String action3="";	
		String sql4="";String sql5=""; String sqluom=""; 
		String sqlreson="";String str_action_reason_desc="";
		String p_blng_serv_code=""; String p_episode_type=""; String p_service_date="";
		String str_excl_incl_ind=""; String p_excl_incl_ind="";
		String p_patient_id="";
		String p_mode="";String str_stat=""; String p_status="";
		String str_status="";String p_practioner="";	
		String p_pract_staff_type="";  String p_pract_staff_ind=""; String p_pract_staff_type_desc="";
		String p_other_staff_type="";String  p_action_reason_code=""; 	
		String p_short_desc="";	String str_episode_id=""; String str_visit_id="";String strp_serv_qty="";
		String strp_serv_amt="";String strp_disc_amt=""; String p_pract_staff_id="";
		String   p_rate_charge_ind="";	 String p_module_id="";
		String p_ind="";String p_added_serv_yn="";	String p_excl_incl_action_ind="";
		String p_service_panel_ind="";	String str_p_rate_value=""; String strp_rate="";String strp_total_qty="";
		String p_incl_excl=""; 	String p_incl_excl_action="";String p_modify_qty_yn="";
		String str_min_chg_amt="";	String str_encounter_id="";String str_acct_seq_no="";String d_pat_payable_temp="";
		String p_order_id=""; String p_order_line_no="";String p_item_code=""; 
		String str_epi_type_clinic_code="";String blng_grp_id=""; String cust_group_code=""; String cust_code=""; String policy_type_code="";
		String policy_priority="";String policy_no="";String policy_start_date="";String policy_exp_date="";String credit_auth_ref="";String policy_eff_from_date="";String policy_eff_to_date="";String approved_amt="";String approved_days="";String non_ins_blng_grp_id="";String non_ins_cust_group_code="";String non_ins_cust_code="";String user_id="";String credit_auth_date="";
		String include_label="", exclude_label="",str_charge_based_amt="";//str_actual_amt="",str_actual_amt_val="",net_amount="";
		String cald_frm="";String sel_rec="",panel_qty="",str_base_amt="";
		double db_serv_qty=0;
		double db_panel_qty =0;

		//double  p_serv_qty=0;double  p_serv_amt=0; double  p_disc_amt=0;double p_rate_value=0; 	double p_rate=0;
		//double p_total_qty=0;	double p_min_chg_amt=0;  double d_charge_based_amt=0;
		int noofdecimal=0;
		/****ghl-crf-1.2*************/
		String calledfrmencYN="N";
		String bean_id_bl ="";
		//String bean_name_bl="";
		HashMap finDtls		= new HashMap();
		/******end*******************/
		try
		{			
			
			str_epi_type_clinic_code=request.getParameter("str_epi_type_clinic_code");
			if(str_epi_type_clinic_code==null) str_epi_type_clinic_code="";

			action3=request.getParameter("action1");

			p_facility_id = (String)httpSession.getValue("facility_id");		

			p_login_user =  p.getProperty("login_user");
			
			cald_frm = request.getParameter("cald_frm");
			if(cald_frm == null) cald_frm="";
			
			sel_rec = request.getParameter("sel_rec");
			if(sel_rec == null) sel_rec="";

			p_action_reason_code=request.getParameter("action_reason_code");
			if(p_action_reason_code==null || p_action_reason_code.equals("")) p_action_reason_code="";

			p_blng_serv_code=request.getParameter("blng_serv_code");
			if(p_blng_serv_code==null || p_blng_serv_code.equals("")) p_blng_serv_code="";

			p_episode_type = request.getParameter("episode_type");
			if(p_episode_type==null || p_episode_type.equals("")) p_episode_type="";

			p_patient_id = request.getParameter("patient_id");
			if(p_patient_id==null || p_patient_id.equals("")) p_patient_id="";

			str_visit_id = request.getParameter("visit_id");	
			str_visit_id=str_visit_id.trim();
			if(str_visit_id==null  || str_visit_id.equals("")) str_visit_id="";	
			

			str_episode_id = request.getParameter("episode_id");	
			str_episode_id=str_episode_id.trim();
			if(str_episode_id==null  || str_episode_id.equals("")) str_episode_id="";	
			
			p_mode=request.getParameter("action1");
			if(p_mode==null || p_mode.equals("")) p_mode="";		
			
			p_practioner=request.getParameter("practioner");
			if(p_practioner==null || p_practioner.equals("")) p_practioner="";		
			
			p_rate_charge_ind=request.getParameter("rate_charge_ind");
			if(p_rate_charge_ind==null || p_rate_charge_ind.equals("")) p_rate_charge_ind="";
			
						
			p_module_id = request.getParameter("module_id");
			if(p_module_id==null || p_module_id.equals("")) p_module_id="";
			p_ind = request.getParameter("ind");
			if(p_ind==null || p_ind.equals("")) p_ind="";
			
			p_added_serv_yn = request.getParameter("added_serv_yn");
			if(p_added_serv_yn==null || p_added_serv_yn.equals("")) p_added_serv_yn="";
			
			p_excl_incl_action_ind = request.getParameter("excl_incl_action");
			if(p_excl_incl_action_ind==null || p_excl_incl_action_ind.equals("")) p_excl_incl_action_ind="";
			
			p_service_panel_ind = request.getParameter("service_panel_ind");
			if(p_service_panel_ind==null || p_service_panel_ind.equals("")) p_service_panel_ind="";
			
			str_p_rate_value = request.getParameter("rate_value");
			if(str_p_rate_value==null || str_p_rate_value.equals("")) str_p_rate_value="0.0";
			
			str_min_chg_amt = request.getParameter("min_chg_amt");
			if(str_min_chg_amt==null || str_min_chg_amt.equals("")) str_min_chg_amt="0.0";
			
			strp_serv_qty=request.getParameter("revise_qty");
			if(strp_serv_qty==null || strp_serv_qty.equals("")) strp_serv_qty="";


			


			panel_qty=request.getParameter("original_qty");
			if(panel_qty==null || panel_qty.equals("")) panel_qty="1";

			panel_qty = cf.formatCurrency(panel_qty, noofdecimal);

	
			
			strp_serv_amt=request.getParameter("serv_amt");
			if(strp_serv_amt==null || strp_serv_amt.equals("") ) strp_serv_amt="0.0";			
			
			strp_disc_amt=request.getParameter("disc_amt");
			if(strp_disc_amt==null || strp_disc_amt.equals("")) strp_disc_amt="0.0";
			
			strp_rate=request.getParameter("rate");
			if(strp_rate==null || strp_rate.equals("")) strp_rate="";
			

		//	str_actual_amt_val=request.getParameter("actual_amt");
		//	if(str_actual_amt_val==null || str_actual_amt_val.equals("")) str_actual_amt_val="";

			

			String serv_amt_changed=request.getParameter("serv_amt_changed");
			if(serv_amt_changed==null ||serv_amt_changed.equals("undefined")) serv_amt_changed="";	

//			System.out.println("serv_amt_changed val:"+serv_amt_changed);

			strp_total_qty=request.getParameter("total_qty");
			if(strp_total_qty==null ||strp_total_qty.equals("")) strp_total_qty="0.0";				

			p_incl_excl=request.getParameter("incl_excl");
			if(p_incl_excl==null || p_incl_excl.equals("")) p_incl_excl="";
			
			p_pract_staff_id=request.getParameter("pract_staff_id");
			if(p_pract_staff_id==null || p_pract_staff_id.equals("")) p_pract_staff_id="";
			
			include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
			if(include_label==null || include_label.equals("")) include_label="";		

			exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");
			if(exclude_label==null || exclude_label.equals("")) exclude_label="";	

			p_incl_excl_action=request.getParameter("incl_excl_action");
			

			if(p_incl_excl_action==null || p_incl_excl_action.equals("")) p_incl_excl_action="";
			if(p_incl_excl_action.equals(exclude_label))
			{
				p_incl_excl_action="E";
			}
			else if(p_incl_excl_action.equals(include_label))
			{
				p_incl_excl_action="I";
			}
			



			if(p_incl_excl.equals(exclude_label))
			{
				p_incl_excl="E";
			}
			else if(p_incl_excl.equals(include_label))
			{
				p_incl_excl="I";
			}

			p_service_date=request.getParameter("service_date");
			if(p_service_date==null || p_service_date.equals("")) p_service_date="";	
			
			p_modify_qty_yn=request.getParameter("modify_qty_yn");
			if(p_modify_qty_yn==null || p_modify_qty_yn.equals("")) p_modify_qty_yn="";	

			
			p_excl_incl_ind=request.getParameter("incl_excl");
			if(p_excl_incl_ind==null || p_excl_incl_ind.equals("")) p_excl_incl_ind="";	
			
			str_encounter_id=request.getParameter("encounter_id");
			if(str_encounter_id==null || str_encounter_id.equals("")) str_encounter_id="";
			
			
			str_acct_seq_no=request.getParameter("acct_seq_no");		
			if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="";
			
			p_order_id = request.getParameter("order_id");
			if(p_order_id==null || p_order_id.equals("")) p_order_id="";	
			
			p_order_line_no= request.getParameter("order_line_no");
			if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";	
			
			/****ghl-crf-1.2*************/				
			calledfrmencYN=request.getParameter("calledfrmencYN");
//				System.out.println("calledfrmencYN validation "+calledfrmencYN);
			if(calledfrmencYN==null) calledfrmencYN="";
			if(calledfrmencYN.equals("Y"))
			{
				bean_id_bl=request.getParameter("bean_id_bl");
				if(bean_id_bl==null) bean_id_bl="";
//				System.out.println("bean_id_bl validation "+bean_id_bl);
			}
			/******end*******************/	

			//p_min_chg_amt=Double.parseDouble(str_min_chg_amt);		
			//p_rate_value=Double.parseDouble(str_p_rate_value);
			//p_serv_qty=Double.parseDouble(strp_serv_qty);
			//p_serv_amt=Double.parseDouble(strp_serv_amt);
			//p_disc_amt=Double.parseDouble(strp_disc_amt);
			//p_rate=Double.parseDouble(strp_rate);		
			//p_total_qty=Double.parseDouble(strp_total_qty);	

			//net_amount= request.getParameter("net_amount");
			//if(net_amount==null || net_amount.equals("")) net_amount="";	
			
	String 	rate_chk= request.getParameter("rate_chk");
			if(rate_chk==null || rate_chk.equals("")) rate_chk="";
	
	
			if(p_rate_charge_ind.equals("R"))
			{
				str_charge_based_amt=strp_serv_qty;	
			}
			else if(p_rate_charge_ind.equals("C"))
			{
				//if(strp_rate.equals(str_actual_amt_val))
				//{
			//		strp_rate=net_amount;
			//	}
			//	else{
					str_charge_based_amt=serv_amt_changed;
				//}
				//else{
				//str_charge_based_amt=strp_rate;
				//}
				
			}		
		
		}
		catch(Exception eX)
		{			
			System.out.println("Error=" +eX);
		}
/***************Added by ram ghl-crf-1.2  if else***************/
	if(calledfrmencYN.equals("Y")){
		BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, "eBL.BLPatRegChargesBean", request ) ;
			finDtls = (HashMap)bean.getFinDtls();
//			System.out.println("finDtls_temp validation "+finDtls);

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
			if(blng_grp_id==null)		blng_grp_id=""; 	

			cust_group_code=(String)fin_dtls_bef_reg.get("cust_group_code");
			if(cust_group_code==null)		cust_group_code=""; 	
			
			cust_code=(String)fin_dtls_bef_reg.get("cust_code");
			if(cust_code==null)		cust_code=""; 	

			policy_type_code=(String)fin_dtls_bef_reg.get("policy_type_code");
			if(policy_type_code==null)		policy_type_code=""; 	

			policy_priority=(String)fin_dtls_bef_reg.get("policy_priority");
			if(policy_priority==null)		policy_priority=""; 	

			policy_no=(String)fin_dtls_bef_reg.get("policy_no");
			if(policy_no==null)		policy_no=""; 	
			
			policy_start_date=(String)fin_dtls_bef_reg.get("policy_start_date");
			if(policy_start_date==null)		policy_start_date=""; 	
			
			policy_exp_date=(String)fin_dtls_bef_reg.get("policy_exp_date");
			if(policy_exp_date==null)		policy_exp_date=""; 	
			
			credit_auth_ref=(String)fin_dtls_bef_reg.get("credit_auth_ref");
			if(credit_auth_ref==null)		credit_auth_ref=""; 	
			
			credit_auth_date=(String)fin_dtls_bef_reg.get("credit_auth_date");
			if(credit_auth_date==null)		credit_auth_date=""; 	
			
			policy_eff_from_date=(String)fin_dtls_bef_reg.get("policy_eff_from_date");
			if(policy_eff_from_date==null)		policy_eff_from_date=""; 	
			
			policy_eff_to_date=(String)fin_dtls_bef_reg.get("policy_eff_to_date");
			if(policy_eff_to_date==null)		policy_eff_to_date=""; 	
			
			approved_amt=(String)fin_dtls_bef_reg.get("approved_amt");
			if(approved_amt==null)		approved_amt=""; 	
			
			approved_days=(String)fin_dtls_bef_reg.get("approved_days");
			if(approved_days==null)		approved_days=""; 	
			
			non_ins_blng_grp_id=(String)fin_dtls_bef_reg.get("non_ins_blng_grp_id");
			if(non_ins_blng_grp_id==null)		non_ins_blng_grp_id=""; 	

			non_ins_cust_group_code=(String)fin_dtls_bef_reg.get("non_ins_cust_group_code");
			if(non_ins_cust_group_code==null)		non_ins_cust_group_code=""; 	

			non_ins_cust_code=(String)fin_dtls_bef_reg.get("non_ins_cust_code");
			if(non_ins_cust_code==null)		non_ins_cust_code=""; 	
			
			user_id=(String)fin_dtls_bef_reg.get("user_id");
			if(user_id==null)		user_id=""; 	
		}
	}

		try
		{
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");				
			rs_dec = pstmt.executeQuery();	
			if ( rs_dec.next() && rs_dec != null ) 
				noofdecimal  =  rs_dec.getInt(1);			
			
			if(rs_dec != null) rs_dec.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("4="+e.toString());
		}
		
		
		
		strp_serv_qty = cf.formatCurrency(strp_serv_qty, noofdecimal);

		panel_qty = cf.formatCurrency(panel_qty, noofdecimal);

		db_serv_qty=Double.parseDouble(strp_serv_qty);
		db_panel_qty =Double.parseDouble(panel_qty); 
		
		double temp_serv_qty = db_serv_qty*db_panel_qty;

		strp_serv_qty=cf.formatCurrency(String.valueOf(temp_serv_qty), noofdecimal);


		//validations for service
	//p_mode="add";
		if(p_mode.equals("add"))
		{
			if(p_ind.equals("BLNG_SERV_CODE"))
			{
				String uomcode="";
				String uom_desc="";
				String str_blng_serv_desc="";
				//String str_rate_chr_ind="";
				String str_overrride_yn="";
				String str_preappr_yn="";
				String str_error_code="";
				String str_sys_message_id="";
				String str_error_text="";
				double d_serv_amt=0;
				double d_pat_payable=0;
				double d_min_charge=0;	
				String d_serv_amt_temp="";
				String str_charged_yn="";
				String str_pat_billed_yn="";
				double d_pat_paid_amt=0; 
				

				try
				{  
					sqluom= "select UOM_CODE, LONG_DESC,MAX_CHARGE_AMT from bl_blng_Serv where blng_serv_code = '"+p_blng_serv_code+"' ";
					
					pstmt = con.prepareStatement(sqluom);
					rs1 = pstmt.executeQuery() ;
					if( rs1 != null ) 
					{
						while( rs1.next() )
						{  
							uomcode = rs1.getString(1);
						max_chg_amt=rs1.getDouble(3);
					
							
						}
					}
					rs1.close();
					pstmt.close();
				
					String uom_desc_sql="select LONG_DESC from am_uom_lang_vw where UOM_CODE = '"+uomcode+"' and LANGUAGE_ID = '"+locale+"'";
					pstmt = con.prepareStatement(uom_desc_sql);
					rs1 = pstmt.executeQuery() ;
					if( rs1 != null ) 
					{
						while( rs1.next() )
						{  
							uom_desc = rs1.getString(1);
						}
					}
					if(rs1 != null) rs1.close();
					pstmt.close();
				}
				catch(Exception e)
				{
					out.println("Error uom"+ e);
				}
				
				try
				{
					if((str_episode_id.equals("0") && str_visit_id.equals("0") && !p_episode_type.equals("R")) || (str_episode_id.equals("0") && str_visit_id.equals("0") && p_episode_type.equals("R") && !p_module_id.equals("OR")))
					{
						String sqlblngserv="{ call BL_CHARGE_CALCULATION.BL_VALIDATE_BLNG_SERV_ENTRY('"+p_facility_id+"','"+p_module_id+"','"+locale+"','"+str_epi_type_clinic_code+"','"+str_episode_id+"','"+str_visit_id+"','"+p_patient_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_blng_serv_code+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'1.0','','"+p_incl_excl_action+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?,?,?,?,?,?)}";
						System.err.println("sqlblngserv:"+sqlblngserv);
						CallableStatement call = con.prepareCall(sqlblngserv);
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.registerOutParameter(2,java.sql.Types.VARCHAR);
						call.registerOutParameter(3,java.sql.Types.DOUBLE);
						call.registerOutParameter(4,java.sql.Types.DOUBLE);
						call.registerOutParameter(5,java.sql.Types.VARCHAR); 
						call.registerOutParameter(6,java.sql.Types.DOUBLE); 					
						call.registerOutParameter(7,java.sql.Types.VARCHAR); 
						call.registerOutParameter(8,java.sql.Types.VARCHAR); 
						call.registerOutParameter(9,java.sql.Types.VARCHAR);
						call.registerOutParameter(10,java.sql.Types.VARCHAR);
						call.registerOutParameter(11,java.sql.Types.VARCHAR);
						call.registerOutParameter(12,java.sql.Types.VARCHAR);
						call.execute();      					
						str_blng_serv_desc = call.getString(1);  

						str_base_amt = call.getString(2);
						if(str_base_amt==null) str_base_amt="";
						 str_base_amt = cf.formatCurrency(str_base_amt,noofdecimal);
						d_serv_amt = call.getDouble(3);   			
						d_serv_amt_temp=String.valueOf(d_serv_amt);
						
						CurrencyFormat cf1 = new CurrencyFormat();
						if(d_serv_amt==0) d_serv_amt_temp="0.00";
						if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);
						d_pat_payable = call.getDouble(4);					
						d_pat_payable_temp=String.valueOf(d_pat_payable);
						cf1 = new CurrencyFormat();
						if(d_pat_payable==0) d_pat_payable_temp="0.00";
						if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);
						str_rate_chr_ind= call.getString(5);					
						d_min_charge= call.getDouble(6);
						
						str_excl_incl_ind= call.getString(7);					
						str_overrride_yn = call.getString(8);					
						str_preappr_yn = call.getString(9);					
						str_error_code = call.getString(10);					
						str_sys_message_id = call.getString(11);					
						str_error_text = call.getString(12);						
						
						if(str_blng_serv_desc==null) str_blng_serv_desc="";
						if(str_rate_chr_ind==null) str_rate_chr_ind="";
						if(str_excl_incl_ind==null) str_excl_incl_ind="";
						if(str_overrride_yn==null) str_overrride_yn="";
						
						if(str_preappr_yn==null) str_preappr_yn="";
						if(str_error_code==null) str_error_code="";					
						if(str_sys_message_id==null) str_sys_message_id="";
						if(str_error_text==null) str_error_text="";									
						call.close();
					}
					else
					{
					strp_serv_qty="";
/*
					if(p_incl_excl_action.equals(""))
							{
								p_incl_excl_action=p_incl_excl;
							}
*/

						CallableStatement call = con.prepareCall("{ call BL_CHARGE_CALCULATION.BL_VALIDATE_BLNG_SERV_ENTRY(?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

						call.setString(1,p_facility_id);
						call.setString(2,p_module_id);
						call.setString(3,p_order_id);
						call.setString(4,p_order_line_no);
						call.setString(5,locale);
						call.setString(6,p_episode_type);
						call.setString(7,str_episode_id);
						call.setString(8,str_visit_id);
						call.setString(9,p_patient_id);	
						call.setString(10,str_encounter_id);	
						call.setString(11,str_acct_seq_no);	
						call.setString(12,p_item_code);	
						call.setString(13,p_blng_serv_code);
						call.setString(14,p_service_date);
						call.setString(15,strp_serv_qty);//p_total_qty
						//call.setString(16,String.valueOf(d_charge_based_amt));//service_amt
						call.setString(16,strp_rate);  //28-02-08
						call.setString(17,p_incl_excl_action);
					
						call.registerOutParameter(18,java.sql.Types.VARCHAR);
						call.registerOutParameter(19,java.sql.Types.VARCHAR);
						call.registerOutParameter(20,java.sql.Types.DOUBLE);
					
						call.registerOutParameter(21,java.sql.Types.DOUBLE);
						call.registerOutParameter(22,java.sql.Types.VARCHAR); 
						call.registerOutParameter(23,java.sql.Types.DOUBLE); 					
						call.registerOutParameter(24,java.sql.Types.VARCHAR); 
						call.registerOutParameter(25,java.sql.Types.VARCHAR); 
						call.registerOutParameter(26,java.sql.Types.VARCHAR);
						call.registerOutParameter(27,java.sql.Types.DOUBLE);
						call.registerOutParameter(28,java.sql.Types.VARCHAR);
						call.registerOutParameter(29,java.sql.Types.VARCHAR);
						call.registerOutParameter(30,java.sql.Types.VARCHAR);
						call.registerOutParameter(31,java.sql.Types.VARCHAR);
						call.registerOutParameter(32,java.sql.Types.VARCHAR);
					
						call.execute();      
						str_blng_serv_desc = call.getString(18);
						str_base_amt = call.getString(19);
						if(str_base_amt==null) str_base_amt="";
						 str_base_amt = cf.formatCurrency(str_base_amt,noofdecimal);
						d_serv_amt = call.getDouble(20); 
						d_serv_amt_temp=String.valueOf(d_serv_amt);
						
						CurrencyFormat cf1 = new CurrencyFormat();
						if(d_serv_amt==0) d_serv_amt_temp="0.00";
						if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);

						d_pat_payable = call.getDouble(21);					
						d_pat_payable_temp=String.valueOf(d_pat_payable);
						cf1 = new CurrencyFormat();
						if(d_pat_payable==0) d_pat_payable_temp="0.00";
						if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);

	

						str_rate_chr_ind= call.getString(22);					
						d_min_charge= call.getDouble(23);						
						str_excl_incl_ind= call.getString(24);					
						str_overrride_yn = call.getString(25);											
						str_preappr_yn = call.getString(26);
						d_pat_paid_amt = call.getDouble(27);
						str_charged_yn = call.getString(28);
						str_pat_billed_yn= call.getString(29);
		 
						str_error_code = call.getString(30);					
						str_sys_message_id = call.getString(31);					
						str_error_text = call.getString(32);						
						
						if(str_blng_serv_desc==null) str_blng_serv_desc="";
						if(str_rate_chr_ind==null) str_rate_chr_ind="";
						if(str_excl_incl_ind==null) str_excl_incl_ind="";
						if(str_overrride_yn==null) str_overrride_yn="";
						if(str_preappr_yn==null) str_preappr_yn="";
						if(str_charged_yn==null) str_charged_yn="";
						if(str_pat_billed_yn==null) str_pat_billed_yn="";
						if(str_error_code==null) str_error_code="";					
						if(str_sys_message_id==null) str_sys_message_id="";
						if(str_error_text==null) str_error_text="";			
						call.close();
						
					}
				}
				catch(Exception exp)
				{		
					out.println(exp);	
				}

				if(str_error_code.equals("10") || 	!str_error_text.equals("") || !str_sys_message_id.equals(""))
				{		
					if (str_error_code.equals("10") && !str_error_text.equals(""))
					{
%>	
						<script>
							var strErrorMessage = "<%=str_error_text%>";
							 alert(strErrorMessage);
						</script>
<%
					}
				
					if(!str_sys_message_id.equals(""))
					{
%>
						<script>
							alert(getMessage('<%=str_sys_message_id%>','BL'));
							parent.frames[0].document.forms[0].service.value="";
							parent.frames[0].document.forms[0].blng_serv_code.value="";
							parent.frames[0].document.forms[0].uom.value="";
							parent.frames[0].document.forms[0].uom_code.value="";
							parent.frames[0].document.forms[0].incl_excl.value="";
							parent.frames[0].document.forms[0].charge.value="";
							parent.frames[0].document.forms[0].ratecharge_desc.value="";
							parent.frames[0].document.forms[0].rate.value="";
							parent.frames[0].document.forms[0].revise_qty.value='';
							parent.frames[0].document.forms[0].original_qty.value='';
							parent.frames[0].document.forms[0].total_qty.value='';
							parent.frames[0].document.forms[0].total_pay.value='';
							parent.frames[0].document.forms[0].patient_pay.value='';
							parent.frames[0].document.forms[0].patient_paid.value='';		
						</script>
<%
					}
				}	
				else
				{
%>			
					<script>

						parent.frames[0].document.forms[0]
						.uom.value="<%=uom_desc%>";
						parent.frames[0].document.forms[0].uom_code.value="<%=uomcode%>";		
					</script>
<%
					if(str_rate_chr_ind.equals("R"))
					{
%>
						<script>
						
						var original_qty=parent.frames[0].document.forms[0].orig_qty.value;
							parent.frames[0].document.forms[0].rate.disabled=true;							
							parent.frames[0].document.forms[0].revise_qty.disabled=false;							
							parent.frames[0].document.forms[0].original_qty.value=original_qty;
							parent.frames[0].document.forms[0].revise_qty.value="1.00";							
							parent.frames[0].document.forms[0].revise_qty.focus();						
						</script>
<%
					}
					else
					{
%>
						<script>

							parent.frames[0].document.forms[0].revise_qty.value="1.00";		
							parent.frames[0].document.forms[0].original_qty.value="1.00";
							parent.frames[0].document.forms[0].total_qty.value="1.00";
							parent.frames[0].document.forms[0].revise_qty.disabled=true;		
							parent.frames[0].document.forms[0].rate.disabled=false;
						//	parent.frames[0].document.forms[0].rate.focus();		
						</script>
<%
					}
						
%>							
					<script>						
						parent.frames[0].document.forms[0].accept_button.disabled=false;
						parent.frames[0].document.forms[0].service.value="<%=str_blng_serv_desc%>";			
						parent.frames[0].document.forms[0].rate.value="<%=str_base_amt%>";				
						parent.frames[0].document.forms[0].max_chg_amt.value="<%=max_chg_amt%>";//muthu
						parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";		
						parent.frames[0].document.forms[0].min_chg_amt.value="<%=d_min_charge%>";		
						parent.frames[0].document.forms[0].override_yn.value="<%=str_overrride_yn%>";
						parent.frames[0].document.forms[0].charge.value="<%=str_rate_chr_ind%>";
						parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
						parent.frames[0].document.forms[0].serv_amt_changed.value="<%=d_serv_amt_temp%>";
					</script>
<%
					if(str_preappr_yn.equals("Y"))
					{
%>
						<script>
						   parent.frames[0].document.forms[0].preappr_reqd.checked=true;
						</script>
<%
					}

					if(str_excl_incl_ind.equals("E"))	
					{
%>
						<script>
						  parent.frames[0].document.forms[0].incl_excl.value=getLabel("Common.Exclude.label","common");
						</script>
<%		
					}
					else if(str_excl_incl_ind.equals("I"))
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl.value=getLabel("Common.Include.label","common");
						</script>
<%
					}	
					System.err.println("str_overrride_yn:"+str_overrride_yn);
					if(str_overrride_yn.equals("I"))	
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl_action.options.length=2;
						  	parent.frames[0].document.forms[0].incl_excl_action.options[0].text="-----"+getLabel("Common.defaultSelect.label","common")+"-----";
							parent.frames[0].document.forms[0].incl_excl_action.options[0].value="";
						    parent.frames[0].document.forms[0].incl_excl_action.options[1].text=getLabel("Common.Include.label","common");
						    parent.frames[0].document.forms[0].incl_excl_action.options[1].value=getLabel("Common.Include.label","common");
						</script>
<%		
					}
					else if(str_overrride_yn.equals("E"))
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl_action.options.length=2; 
							parent.frames[0].document.forms[0].incl_excl_action.options[0].text="-----"+getLabel("Common.defaultSelect.label","common")+"-----";
							parent.frames[0].document.forms[0].incl_excl_action.options[0].value="";
							parent.frames[0].document.forms[0].incl_excl_action.options[1].text=getLabel("Common.Exclude.label","common");
							parent.frames[0].document.forms[0].incl_excl_action.options[1].value=getLabel("Common.Exclude.label","common");
						</script>
<%
					}	
					else if(str_overrride_yn.equals("B"))
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl_action.options.length=3; parent.frames[0].document.forms[0].incl_excl_action.options[0].text="-----"+getLabel("Common.defaultSelect.label","common")+"-----";
							parent.frames[0].document.forms[0].incl_excl_action.options[0].value="";
							parent.frames[0].document.forms[0].incl_excl_action.options[2].text=getLabel("Common.Include.label","common");
						    parent.frames[0].document.forms[0].incl_excl_action.options[2].value=getLabel("Common.Include.label","common");
							parent.frames[0].document.forms[0].incl_excl_action.options[1].text=getLabel("Common.Exclude.label","common");
						    parent.frames[0].document.forms[0].incl_excl_action.options[1].value=getLabel("Common.Exclude.label","common");

						</script>
<%
					}	
					else
					{
%>
						<script>
						 parent.frames[0].document.forms[0].incl_excl_action.options.length=1; parent.frames[0].document.forms[0].incl_excl_action.options[0].text="-----"+getLabel("Common.defaultSelect.label","common")+"-----";
						</script>
<%
					}
					
					if(str_preappr_yn.equals("Y"))
					{
%>
						<script>			
							parent.frames[0].document.forms[0].preappr_reqd.checked=true;
						</script>
<%
					}
		
					if(str_excl_incl_ind.equals("I")|| str_excl_incl_ind.equals("E"))
					{
%>
						<script>
							parent.frames[0].document.forms[0].charge.value="<%=str_rate_chr_ind%>";
						</script>
<%
					}
					if (str_rate_chr_ind.equals("R")) 
					{
%>
						<script>
							parent.frames[0].document.forms[0].rate.disabled=true;
						</script>
<%
					}
					else
					{
%>
						<script>
							parent.frames[0].document.forms[0].rate.disabled=false;
						</script>
<%
					}
					if(str_rate_chr_ind.equals("R")) 
					{
%>
						<script>
							parent.frames[0].document.forms[0].ratecharge_desc.value=getLabel("eBL.RATE.label","BL");
						</script>
<%
					}
					else if(str_rate_chr_ind.equals("C")) {
%>
						<script>
							parent.frames[0].document.forms[0].ratecharge_desc.value=getLabel("Common.Charge.label","common");
						</script>
<%
					}

						
					if(str_excl_incl_ind.equals("") || str_overrride_yn.equals("N")|| str_overrride_yn.equals(""))
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl_action.disabled=true;
							parent.frames[0].document.forms[0].action_reason_desc.disabled=true;
						</script>
<%
					}
					else
					{
%>
						<script>
							parent.frames[0].document.forms[0].incl_excl_action.disabled=false;
							parent.frames[0].document.forms[0].action_reason_desc.disabled=false;
						</script>
<%
					}
				}
			}  
		} 

		if(p_mode.equals("add") || p_mode.equals("modify") )
		{
			if(p_ind.equals("REASON_CODE"))
			{
				try
				{
					if(p_added_serv_yn.equals("Y") && !str_excl_incl_ind.equals(p_excl_incl_action_ind)&& p_action_reason_code.equals(""))
					{			 
%>
						<script>
							alert(getMessage('BL9608','BL'));
						</script>			
<%
					}		
					if(!p_action_reason_code.equals(""))
					{
						sqlreson="select action_reason_desc, status  from bl_action_reason_lang_vw  where action_reason_code='"+p_action_reason_code+"' and  language_id = '"+locale+"' ";
						 pstmt = con.prepareStatement(sqlreson);
						rs1 = pstmt.executeQuery() ;
						if( rs1 != null ) 
						{
							while( rs1.next() )
							{  
								str_action_reason_desc = rs1.getString(1);
								str_status= rs1.getString(2);
							}	
						}

						if(str_action_reason_desc==null) str_action_reason_desc="";
						if(str_status==null) str_status="";		
						rs1.close();
						pstmt.close();		
						
						if(str_status.equals("S"))
						{	
%>
							<script>
								alert(getMessage('BL1353','BL'));
							</script>
<%
						}
					}		
				}
				catch(Exception exp4)
				{
					System.out.println("Error 4 "+exp4);
				}
	
				if (str_stat.equals("S"))
				{
%>
					<script>
						alert(getMessage('BL1353','BL'));
					</script>			
<%
				}	
			}  

			if(p_ind.equals("PRACT_STAFF"))
			{
				if(!p_practioner.equals(""))
				{
					try
					{
						if(p_pract_staff_ind.equals("P") )
						{
							sql4="SELECT B.PRACT_TYPE, B.DESC_USERDEF ST_TYPE, A.PRACTITIONER_NAME, A.EFF_STATUS  "+
							"  FROM AM_PRACTITIONER_LANG_VW A, AM_PRACT_TYPE_LANG_VW B "+
							"  WHERE EXISTS (SELECT PRACTITIONER_ID FROM AM_PRACT_FOR_FACILITY "+
							"  WHERE facility_id = '"+p_facility_id+"' "+
							"  AND PRACTITIONER_ID = '"+p_pract_staff_id+"'  "+
							"  AND NVL(EFF_STATUS,'!') != 'S') "+
							"  AND UPPER(A.LANGUAGE_ID) = UPPER('"+locale+"') "+
							"  AND PRACTITIONER_ID = '"+p_pract_staff_id+"' "+
							"  AND A.PRACT_TYPE = B.PRACT_TYPE "+
							"  AND A.LANGUAGE_ID = B.LANGUAGE_ID ";
							pstmt = con.prepareStatement(sql4);
							rs1 = pstmt.executeQuery() ;
							if( rs1 != null ) 
							{
								while( rs1.next() )
								{  
									p_pract_staff_type = rs1.getString(1);
									if(p_pract_staff_type==null) p_pract_staff_type="";
									p_pract_staff_type_desc= rs1.getString(2);
									if(p_pract_staff_type_desc==null) p_pract_staff_type_desc="";
									p_short_desc = rs1.getString(3);
									if(p_short_desc==null) p_short_desc="";
									p_status = rs1.getString(4);
									if(p_status==null) p_status="";
								}
							}		
							rs1.close();
							pstmt.close();
							if(p_status.equals(""))  p_status="X";
							if(p_status.equals("S"))
							{
%>
								<script>
									alert(getMessage('BL4140','BL'));
								</script>			
<%
							}
						}
						else
						{
							sql5="SELECT B.OTHER_STAFF_TYPE, B.SHORT_DESC ST_TYPE, A.OTHER_STAFF_NAME, A.EFF_STATUS "+
							   " FROM AM_OTHER_STAFF_LANG_VW A,AM_OTHER_STAFF_TYPE_LANG_VW B "+
							   " WHERE EXISTS (SELECT OTHER_STAFF_ID FROM AM_OTHER_STAFF_FOR_FACILITY "+
							   " WHERE facility_id = '"+p_facility_id+"'"+
							   " AND OTHER_STAFF_ID = '"+p_pract_staff_id+"' "+
							   " AND NVL(EFF_STATUS,'!') != 'S') "+
							   " AND UPPER(A.LANGUAGE_ID) = UPPER('"+locale+"') "+
							   " AND A.OTHER_STAFF_ID = '"+p_pract_staff_id+"'"+
							   " AND A.OTHER_STAFF_TYPE = B.OTHER_STAFF_TYPE "+
							   " AND A.LANGUAGE_ID = B.LANGUAGE_ID ";
							pstmt = con.prepareStatement(sql5);
							rs2 = pstmt.executeQuery() ;
							if( rs2 != null ) 
							{
								while( rs2.next() )
								{  
									p_other_staff_type = rs2.getString(1);
									if(p_pract_staff_type==null) p_pract_staff_type="";
									p_pract_staff_type_desc= rs2.getString(2);
									if(p_pract_staff_type_desc==null) p_pract_staff_type_desc="";
									p_short_desc = rs2.getString(3);
									if(p_short_desc==null) p_short_desc="";
									p_status = rs2.getString(4);
									if(p_status==null) p_status="";
								}
							}
							if(rs2 != null) rs2.close();
							pstmt.close();
						}	     
					}
					catch(Exception e )
					{						 
						out.println(e);
					}
				}	
			}

			if(p_ind.equals("REVISED_QTY"))
			{
				double d_tot_qty=0;
				double d_serv_amt=0; 
				double d_pat_payable=0;
				String str_incl_excl_ind="";
				String str_preappr_yn="";
				double d_pat_paid_amt=0;
				String str_error_code="";
				String str_sys_message_id="";
				String str_error_text="";
				String d_pat_paid_amt_temp="";String d_tot_qty_temp="";
				String d_serv_amt_temp="";
				String str_charged_yn="";
				String str_pat_billed_yn="";

				if(p_rate_charge_ind.equals("R"))
				{
					
					try
					{
					if((str_episode_id.equals("0") && str_visit_id.equals("0") && !p_episode_type.equals("R")) || (str_episode_id.equals("0") && str_visit_id.equals("0") && p_episode_type.equals("R") && !p_module_id.equals("OR")))
						{
							
							String sqlservqty="{ call BL_CHARGE_CALCULATION.BL_VALIDATE_SERV_QTY_ENTRY('"+p_facility_id+"','"+p_module_id+"','"+locale+"','"+str_epi_type_clinic_code+"','"+str_episode_id+"','"+str_visit_id+"','"+p_patient_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_blng_serv_code+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+strp_serv_qty+"','"+str_charge_based_amt+"','"+p_rate_charge_ind+"','"+p_incl_excl_action+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?,?,?)}";							



							CallableStatement call = con.prepareCall(sqlservqty);
							call.registerOutParameter(1,java.sql.Types.DOUBLE);
							call.registerOutParameter(2,java.sql.Types.DOUBLE);
							call.registerOutParameter(3,java.sql.Types.DOUBLE);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.DOUBLE);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.execute();
							d_tot_qty=call.getDouble(1);										
							d_tot_qty_temp=String.valueOf(d_tot_qty);
							CurrencyFormat cf1 = new CurrencyFormat();
							if(d_tot_qty==0) d_tot_qty_temp="0.00";
							if (d_tot_qty!=0) d_tot_qty_temp = cf1.formatCurrency(d_tot_qty_temp,noofdecimal);
							d_serv_amt=call.getDouble(2);	
							d_serv_amt_temp=String.valueOf(d_serv_amt);
							cf1 = new CurrencyFormat();
							if(d_serv_amt==0) d_serv_amt_temp="0.00";
							if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);
							d_pat_payable=call.getDouble(3);				
							d_pat_payable_temp=String.valueOf(d_pat_payable);
							 cf1 = new CurrencyFormat();
							if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);
							str_incl_excl_ind=call.getString(4);
							if(str_incl_excl_ind==null) str_incl_excl_ind="";					
							str_preappr_yn=call.getString(5);
							if(str_preappr_yn==null) str_preappr_yn="";						
							d_pat_paid_amt=call.getDouble(6);
							d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
							if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);	
							str_error_code = call.getString(7);		
							if(str_error_code==null) str_error_code="";
							str_sys_message_id = call.getString(8);
							if(str_sys_message_id==null) str_sys_message_id="";
							str_error_text = call.getString(9);
							if(str_error_text==null) str_error_text="";				
							call.close();
						}
						else
						{
/*
							if(p_incl_excl_action.equals(""))
							{
								p_incl_excl_action=p_incl_excl;
							}
*/
							CallableStatement call = con.prepareCall("{ call BL_CHARGE_CALCULATION.BL_VALIDATE_SERV_QTY_ENTRY(?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
							call.setString(1,p_facility_id);
							call.setString(2,p_module_id);
							call.setString(3,p_order_id);
							call.setString(4,p_order_line_no);
							call.setString(5,locale);
							call.setString(6,p_episode_type);
							call.setString(7,str_episode_id);
							call.setString(8,str_visit_id);
							call.setString(9,p_patient_id);	
							call.setString(10,str_encounter_id);	
							call.setString(11,str_acct_seq_no);	
							call.setString(12,p_item_code);	
							call.setString(13,p_blng_serv_code);
							call.setString(14,p_service_date);
							call.setString(15,strp_serv_qty);//p_total_qty
							call.setString(16,str_charge_based_amt);
							call.setString(17,p_rate_charge_ind);
							call.setString(18,p_incl_excl_action);
							call.registerOutParameter(19,java.sql.Types.DOUBLE);
							call.registerOutParameter(20,java.sql.Types.DOUBLE);
							call.registerOutParameter(21,java.sql.Types.DOUBLE);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.DOUBLE);
							call.registerOutParameter(25,java.sql.Types.VARCHAR);
							call.registerOutParameter(26,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);
							call.execute();
							d_tot_qty=call.getDouble(19);										
							d_tot_qty_temp=String.valueOf(d_tot_qty);	
							CurrencyFormat cf1 = new CurrencyFormat();
							if(d_tot_qty==0) d_tot_qty_temp="0.00";
							if (d_tot_qty!=0) d_tot_qty_temp = cf1.formatCurrency(d_tot_qty_temp,noofdecimal);
							d_serv_amt=call.getDouble(20);		
							d_serv_amt_temp=String.valueOf(d_serv_amt);
							cf1 = new CurrencyFormat();
							if(d_serv_amt==0) d_serv_amt_temp="0.00";
							if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);
							d_pat_payable=call.getDouble(21);	
							d_pat_payable_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);
							str_incl_excl_ind=call.getString(22);
							if(str_incl_excl_ind==null) str_incl_excl_ind="";					
							str_preappr_yn=call.getString(23);
							if(str_preappr_yn==null) str_preappr_yn="";						
							d_pat_paid_amt=call.getDouble(24);
							d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
							if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);
							str_charged_yn = call.getString(25);
							if(str_charged_yn==null) str_charged_yn="";
							str_pat_billed_yn = call.getString(26);
							if(str_pat_billed_yn==null) str_pat_billed_yn="";
							str_error_code = call.getString(27);		
							if(str_error_code==null) str_error_code="";
							str_sys_message_id = call.getString(28);
							if(str_sys_message_id==null) str_sys_message_id="";
							str_error_text = call.getString(29);
							if(str_error_text==null) str_error_text="";							
							call.close();
							
						}
					}
					catch(Exception e )
					{ 
						out.println(e);
						System.out.println("revised qty error"+e);
					}
		
					//if(d_tot_qty<0)
					//{
%>
					<!-- 	<script>		
							alert(getMessage('BL9018','BL'));
						</script>  -->
<%
					//}
					if (str_error_code.equals("10") || !str_error_text.equals("") || !str_sys_message_id.equals(""))
					{
						if(!cald_frm.equals("direct_ser_req"))
						{
%>
						<script> 
							parent.frames[0].document.forms[0].accept_button.disabled=true;			
						</script>
<%
						}
						if (str_error_code.equals("10") && !str_error_text.equals(""))
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
						if(cald_frm.equals("direct_ser_req"))
						{
%>
							<script>
								var qty=eval('parent.frames[0].document.forms[0].qty_'+<%=sel_rec%>);
								qty.value="<%=d_tot_qty_temp%>";

								var hid_qty=eval('parent.frames[0].document.forms[0].hid_qty_'+<%=sel_rec%>);
								hid_qty.value="<%=d_tot_qty_temp%>";

//								parent.frames[0].document.forms[0].total_qty.value="<%=d_tot_qty_temp%>";					
								var rate=eval('parent.frames[0].document.getElementById('charges_')'+<%=sel_rec%>);
								rate.innerText="<%=d_serv_amt_temp%>";

								var hid_charges=eval('parent.frames[0].document.forms[0].hid_charges_'+<%=sel_rec%>);
								hid_charges.value="<%=d_serv_amt_temp%>";
//								parent.frames[0].document.forms[0].rate.value="<%=d_serv_amt_temp%>";

								var patient_pay=eval('parent.frames[0].document.getElementById('patient_payable_')'+<%=sel_rec%>);
								patient_pay.innerText="<%=d_pat_payable_temp%>";
//								parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";	 
								
								var patient_paid=eval('parent.frames[0].document.getElementById('patient_paid_')'+<%=sel_rec%>);
								patient_paid.innerText="<%=d_pat_paid_amt_temp%>";
//								parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	  

//								parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
								
							</script>
<%
							if (str_preappr_yn.equals("Y"))
							{
%>
								<script>
									var preappr_reqd=eval('parent.frames[0].document.forms[0].preappr_reqd_'+<%=sel_rec%>);
									preappr_reqd.checked=true;
//									parent.frames[0].document.forms[0].preappr_reqd.checked=true;
								</script>
<%
							}
%>
							<script>
								parent.frames[1].totalCharges();
								parent.frames[0].callUpdateBean(<%=sel_rec%>);
							</script>
<%
						}
						else
						{
%>       
							<script>

								parent.frames[0].document.forms[0].accept_button.disabled=false;
								parent.frames[0].document.forms[0].total_qty.value="<%=d_tot_qty_temp%>";					
							//	parent.frames[0].document.forms[0].rate.value="<%=d_serv_amt_temp%>"; commented  on 25/08/08 added new	
								parent.frames[0].document.forms[0].rate.disabled=true;	
								parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";
								parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	  
								parent.frames[0].document.forms[0].total_pay.value="<%=d_serv_amt_temp%>";	 
								parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
								
								if(parent.frames[0].document.forms[0].rate_chk_close.value == "Y")
								{									
									parent.frames[0].acceptchargedet1();								
								}
							</script>
<%
							if (str_preappr_yn.equals("Y"))
							{
%>
								<script>
									parent.frames[0].document.forms[0].preappr_reqd.checked=true;
								</script>
<%
							}
						}
					}
				}
				else
				{
					if(p_rate_charge_ind.equals("C") && (!cald_frm.equals("direct_ser_req")))
					{
%>
					<script>		
						parent.frames[0].document.forms[0].total_qty.value="1.00";
					</script>					
<%
					}
					}
			}

			if(p_ind.equals("RATE"))
			{
				if(p_rate_charge_ind.equals("C"))
				{
					
					double d_pat_payable=0;
					double d_serv_amt=0; String str_preappr_yn="";
					double d_pat_paid_amt=0;
					String str_incl_excl_ind="";String d_serv_amt_temp="";String d_pat_paid_amt_temp="";
					String str_error_code=""; String str_sys_message_id="";String str_error_text="";
					String str_charged_yn = "";
					String str_pat_billed_yn = "";
					//BL_VALIDATE_SERV_AMT_ENTRY_REG
					try
					{
					if((str_episode_id.equals("0") && str_visit_id.equals("0") && !p_episode_type.equals("R")) || (str_episode_id.equals("0") && str_visit_id.equals("0") && p_episode_type.equals("R") && !p_module_id.equals("OR")))
						{
							String sqlservamt="{ call BL_CHARGE_CALCULATION.BL_VALIDATE_SERV_AMT_ENTRY('"+p_facility_id+"','"+p_module_id+"','"+locale+"','"+str_epi_type_clinic_code+"','"+str_episode_id+"','"+str_visit_id+"','"+p_patient_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_blng_serv_code+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+strp_serv_qty+"','"+str_charge_based_amt+"','"+p_rate_charge_ind+"','"+str_min_chg_amt+"','"+p_incl_excl_action+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?,?)}";
							CallableStatement call = con.prepareCall(sqlservamt);
							call.registerOutParameter(1,java.sql.Types.DOUBLE);
							call.registerOutParameter(2,java.sql.Types.DOUBLE);
							call.registerOutParameter(3,java.sql.Types.VARCHAR);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);				
							call.registerOutParameter(5,java.sql.Types.DOUBLE);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.execute();				
							d_serv_amt=call.getDouble(1);	
							d_serv_amt_temp=String.valueOf(d_serv_amt);
							CurrencyFormat cf1 = new CurrencyFormat();
							if(d_serv_amt==0) d_serv_amt_temp="0.00";
							if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);
							d_pat_payable=call.getDouble(2);	
							d_pat_payable_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_payable==0) d_pat_payable_temp="0.00";
							if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);			
							str_incl_excl_ind=call.getString(3);
							if(str_incl_excl_ind==null) str_incl_excl_ind="";					
							str_preappr_yn=call.getString(4);
							if(str_preappr_yn==null) str_preappr_yn="";						
							d_pat_paid_amt=call.getDouble(5);
							d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
							if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);
							str_error_code = call.getString(6);		
							if(str_error_code==null) str_error_code="";
							str_sys_message_id = call.getString(7);
							if(str_sys_message_id==null) str_sys_message_id="";
							str_error_text = call.getString(8);
							if(str_error_text==null) str_error_text="";				
							call.close();
						}
						else
						{
/*
							if(p_incl_excl_action.equals(""))
							{
								p_incl_excl_action=p_incl_excl;
							}
*/					
							CallableStatement call = con.prepareCall("{ call BL_CHARGE_CALCULATION.BL_VALIDATE_SERV_AMT_ENTRY(?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

							call.setString(1,p_facility_id);
							call.setString(2,p_module_id);
							call.setString(3,p_order_id);
							call.setString(4,p_order_line_no);
							call.setString(5,locale);
							call.setString(6,p_episode_type);
							call.setString(7,str_episode_id);
							call.setString(8,str_visit_id);
							call.setString(9,p_patient_id);	
							//call.setLong(10,encounter_id);	
							//call.setInt(11,acct_seq_no);	
							call.setString(10,str_encounter_id);	
							call.setString(11,str_acct_seq_no);	
							call.setString(12,p_item_code);	
							call.setString(13,p_blng_serv_code);
							call.setString(14,p_service_date);
							call.setString(15,strp_serv_qty);//p_total_qty
							call.setString(16,str_charge_based_amt);
System.out.println("str_charge_based_amt 1481 --> "+str_charge_based_amt);
//							call.setString(16,str_actual_amt_val);

							call.setString(17,p_rate_charge_ind);
							//call.setDouble(18,p_min_chg_amt);
							call.setString(18,str_min_chg_amt);//28-02-08
							call.setString(19,p_incl_excl_action);

							call.registerOutParameter(20,java.sql.Types.DOUBLE);
							call.registerOutParameter(21,java.sql.Types.DOUBLE);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.DOUBLE);
							call.registerOutParameter(25,java.sql.Types.VARCHAR);
							call.registerOutParameter(26,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);
							
							call.execute();
							d_serv_amt=call.getDouble(20);
							d_serv_amt_temp=String.valueOf(d_serv_amt);
							CurrencyFormat cf1 = new CurrencyFormat();
							d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);

							d_pat_payable=call.getDouble(21);				
							d_pat_payable_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_payable==0) d_pat_payable_temp="0.00";
							if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);

							str_excl_incl_ind=call.getString(22);				
							if(str_excl_incl_ind==null) str_excl_incl_ind="";								

							str_preappr_yn=call.getString(23);					
							if(str_preappr_yn==null) str_preappr_yn="";				

							d_pat_paid_amt=call.getDouble(24);					
							d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
							cf1 = new CurrencyFormat();
							if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
							if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);

							str_charged_yn = call.getString(25);
							if(str_charged_yn==null) str_charged_yn="";				

							str_pat_billed_yn = call.getString(26);
							if(str_pat_billed_yn==null) str_pat_billed_yn="";				
				
							str_error_code = call.getString(27);				
							if(str_error_code==null) str_error_code="";				
							str_sys_message_id = call.getString(28);				
							if(str_sys_message_id==null) str_sys_message_id="";								
							str_error_text = call.getString(29);					
							if(str_error_text==null) str_error_text="";					
							call.close();

							
						}
					}	
					catch(Exception e )
					{ 
						out.println("rete error2"+e);
						System.out.println("rate error2"+e);
					}
		
					if (str_error_code.equals("10") || !str_error_text.equals("") || !str_sys_message_id.equals(""))
					{
						if(!cald_frm.equals("direct_ser_req"))
						{
%>
						<script> 
							parent.frames[0].document.forms[0].accept_button.disabled=true;		
						</script>
<%
						}
						if (str_error_code.equals("10") && !str_error_text.equals(""))
						{
%>
							<script>	
								var strErrorMessage = '<%=str_error_text%>';
								alert(strErrorMessage);
							</script>
<%
						}
						if(str_sys_message_id!="")
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
						if(cald_frm.equals("direct_ser_req"))
						{
%>
<script>
								var rate=eval('parent.frames[0].document.forms[0].charges_'+<%=sel_rec%>);
								rate.value="<%=d_serv_amt_temp%>";

								var hid_charges=eval('parent.frames[0].document.forms[0].hid_charges_'+<%=sel_rec%>);
								hid_charges.value="<%=d_serv_amt_temp%>";

//								parent.frames[0].document.forms[0].rate.value="<%=d_serv_amt_temp%>";	 

								var patient_pay=eval('parent.frames[0].document.getElementById('patient_payable_')'+<%=sel_rec%>);
								patient_pay.innerText="<%=d_pat_payable_temp%>";
//								parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";	 
								
								var patient_paid=eval('parent.frames[0].document.getElementById('patient_paid_')'+<%=sel_rec%>);
								patient_paid.innerText="<%=d_pat_paid_amt_temp%>";
//								parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	  

								var charged_YN=eval('parent.frames[0].document.forms[0].charged_YN'+<%=sel_rec%>);
								charged_YN.value="<%=str_charged_yn%>";

//								parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
							</script>
<%								
							
							if (str_preappr_yn.equals("Y"))
							{
%>
								<script>
									var preappr_reqd=eval('parent.frames[0].document.forms[0].preappr_reqd_'+<%=sel_rec%>);
									preappr_reqd.checked=true;
//									parent.frames[0].document.forms[0].preappr_reqd.checked=true;
								</script>

<%
							}
%>
							<script>
								parent.frames[1].totalCharges();
								parent.frames[0].callUpdateBean(<%=sel_rec%>);
							</script>
<%


						}
						else
						{
%>	  
							<script>
								parent.frames[0].document.forms[0].accept_button.disabled=false;
								//parent.frames[0].document.forms[0].rate.value="<%=d_serv_amt_temp%>";	 
								parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";	 
								parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	  
								parent.frames[0].document.forms[0].total_pay.value="<%=d_serv_amt_temp%>";
								parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
							//	parent.frames[0].document.forms[0].net_amount.value="<%=d_serv_amt_temp%>";
							
								parent.frames[0].document.forms[0].serv_amt_changed.value="<%=str_charge_based_amt%>";
								
								
								if(parent.frames[0].document.forms[0].rate_chk_close.value == "Y")
								{			
									
									parent.frames[0].acceptchargedet1();
								}
								
							</script>
<%
						
							if(!p_rate_charge_ind.equals("C"))
							{
								if(str_excl_incl_ind.equals("E"))	
								{
%>
									<script>
										parent.frames[0].document.forms[0].incl_excl.value=getLabel("Common.Exclude.label","common");
									</script>
<%
								}
								else if(str_excl_incl_ind.equals("I"))
								{
%>
									<script>
										parent.frames[0].document.forms[0].incl_excl.value=getLabel("Common.Include.label","common");
									</script>
<%
								}	
							} 	
								
							if (str_preappr_yn.equals("Y"))
							{
%>
								<script>
								   parent.frames[0].document.forms[0].preappr_reqd.checked=true;
								</script>
<%
							}
						}
					}
				}
			}

			if(p_ind.equals("EXCL_INCL_ACT"))
			{				
				double d_serv_amt=0;	double d_pat_payable=0;
				String str_incl_excl_ind="";	String str_preappr_yn="";
				double d_pat_paid_amt=0;
				String str_error_code = "";	String str_sys_message_id ="";
				String str_error_text = "";String d_serv_amt_temp="";String d_pat_paid_amt_temp="";
				String str_charged_yn =""; 	String str_pat_billed_yn ="";
				

				
				try
				{
					if((str_episode_id.equals("0") && str_visit_id.equals("0") && !p_episode_type.equals("R")) || (str_episode_id.equals("0") && str_visit_id.equals("0") && p_episode_type.equals("R") && !p_module_id.equals("OR")))
					{
						String sqlinclexcl="{ call BL_CHARGE_CALCULATION.BL_VALIDATE_EXCL_INCL_ACTION('"+p_facility_id+"','"+p_module_id+"','"+locale+"','"+str_epi_type_clinic_code+"','"+str_episode_id+"','"+str_visit_id+"','"+p_patient_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_blng_serv_code+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+strp_serv_qty+"','"+str_charge_based_amt+"','"+p_rate_charge_ind+"','"+p_incl_excl_action+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+policy_type_code+"','"+policy_priority+"','"+policy_no+"','"+policy_start_date+"','"+policy_exp_date+"','"+credit_auth_ref+"','"+credit_auth_date+"','"+policy_eff_from_date+"','"+policy_eff_to_date+"','"+approved_amt+"','"+approved_days+"','"+non_ins_blng_grp_id+"','"+non_ins_cust_group_code+"','"+non_ins_cust_code+"',?,?,?,?,?,?,?,?,?)}";					
						

						CallableStatement call = con.prepareCall(sqlinclexcl);
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.registerOutParameter(2,java.sql.Types.DOUBLE);
						call.registerOutParameter(3,java.sql.Types.DOUBLE);
						call.registerOutParameter(4,java.sql.Types.VARCHAR);
						call.registerOutParameter(5,java.sql.Types.VARCHAR);
						call.registerOutParameter(6,java.sql.Types.DOUBLE);
						call.registerOutParameter(7,java.sql.Types.VARCHAR);
						call.registerOutParameter(8,java.sql.Types.VARCHAR);
						call.registerOutParameter(9,java.sql.Types.VARCHAR);
						
						call.execute();		
						str_base_amt = call.getString(1);
						if(str_base_amt==null) str_base_amt="";
						 str_base_amt = cf.formatCurrency(str_base_amt,noofdecimal);						
						d_serv_amt=call.getDouble(2);	
						d_serv_amt_temp=String.valueOf(d_serv_amt);
						CurrencyFormat cf1 = new CurrencyFormat();
						if(d_serv_amt==0) d_serv_amt_temp="0.00";
						if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);						
						d_pat_payable=call.getDouble(3);						
						d_pat_payable_temp=String.valueOf(d_pat_payable);
						 cf1 = new CurrencyFormat();
						if(d_pat_payable==0) d_pat_payable_temp="0.00";
						if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);	
						
						str_incl_excl_ind=call.getString(4);
						if(str_incl_excl_ind==null) str_incl_excl_ind="";					
						str_preappr_yn=call.getString(5);
						if(str_preappr_yn==null) str_preappr_yn="";						
						d_pat_paid_amt=call.getDouble(6);
						d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
						cf1 = new CurrencyFormat();
						if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
						if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);


						str_error_code = call.getString(7);		
						if(str_error_code==null) str_error_code="";
						
						str_sys_message_id = call.getString(8);
						if(str_sys_message_id==null) str_sys_message_id="";
						
						str_error_text = call.getString(9);
						if(str_error_text==null) str_error_text="";				
						
						call.close();
					}
					else
					{
//Commented below lines for IN022809
/*							if(p_incl_excl_action.equals(""))
							{
								p_incl_excl_action=p_incl_excl;
							}
*/
						CallableStatement call = con.prepareCall("{ call BL_CHARGE_CALCULATION.BL_VALIDATE_EXCL_INCL_ACTION(?,?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

//String sqlinclexcl1="{ call BL_CHARGE_CALCULATION.BL_VALIDATE_EXCL_INCL_ACTION('"+p_facility_id+"','"+p_module_id+"','"+p_order_id+"','"+p_order_line_no+"','"+locale+"','"+p_episode_type+"','"+str_episode_id+"','"+str_visit_id+"','"+p_patient_id+"','"+str_encounter_id+"','"+str_acct_seq_no+"','"+p_item_code+"','"+p_blng_serv_code+"',TO_DATE('"+p_service_date+"','DD/MM/YYYY HH24:MI'),'"+strp_serv_qty+"','"+str_charge_based_amt+"','"+p_rate_charge_ind+"','"+p_incl_excl_action+"',?,?,?,?,?,?,?,?,?,?)}";
	
						call.setString(1,p_facility_id);
						call.setString(2,p_module_id);
						call.setString(3,p_order_id);
						call.setString(4,p_order_line_no);
						call.setString(5,locale);
						call.setString(6,p_episode_type);
						call.setString(7,str_episode_id);
						call.setString(8,str_visit_id);
						call.setString(9,p_patient_id);	
						call.setString(10,str_encounter_id);	
						call.setString(11,str_acct_seq_no);	
						call.setString(12,p_item_code);							
						call.setString(13,p_blng_serv_code);
						call.setString(14,p_service_date);
						call.setString(15,strp_serv_qty);//p_total_qty
						call.setString(16,str_charge_based_amt);						
						call.setString(17,p_rate_charge_ind);
						call.setString(18,p_incl_excl_action);
						//CallableStatement call = con.prepareCall(sqlinclexcl1);
						call.registerOutParameter(19,java.sql.Types.VARCHAR);
						call.registerOutParameter(20,java.sql.Types.DOUBLE);
						call.registerOutParameter(21,java.sql.Types.DOUBLE);
						call.registerOutParameter(22,java.sql.Types.VARCHAR);
						call.registerOutParameter(23,java.sql.Types.VARCHAR);
						call.registerOutParameter(24,java.sql.Types.DOUBLE);
						call.registerOutParameter(25,java.sql.Types.VARCHAR);
						call.registerOutParameter(26,java.sql.Types.VARCHAR);
						call.registerOutParameter(27,java.sql.Types.VARCHAR);
						call.registerOutParameter(28,java.sql.Types.VARCHAR);
						call.registerOutParameter(29,java.sql.Types.VARCHAR);
						call.execute();
						str_base_amt = call.getString(19);
						if(str_base_amt==null) str_base_amt="";
						 str_base_amt = cf.formatCurrency(str_base_amt,noofdecimal);
						d_serv_amt=call.getDouble(20);				
						d_serv_amt_temp=String.valueOf(d_serv_amt);
						CurrencyFormat cf1 = new CurrencyFormat();
						if(d_serv_amt==0) d_serv_amt_temp="0.00";
						if (d_serv_amt!=0) d_serv_amt_temp = cf1.formatCurrency(d_serv_amt_temp,noofdecimal);
				
						d_pat_payable=call.getDouble(21);				
						d_pat_payable_temp=String.valueOf(d_pat_payable);
						cf1 = new CurrencyFormat();
						if(d_pat_payable==0) d_pat_payable_temp="0.00";
						if (d_pat_payable!=0) d_pat_payable_temp = cf1.formatCurrency(d_pat_payable_temp,noofdecimal);
					
						str_excl_incl_ind=call.getString(22);
						if(str_excl_incl_ind==null) str_excl_incl_ind="";		
//						System.out.println("From validation page proc str_excl_incl_ind:"+str_excl_incl_ind);
						str_preappr_yn=call.getString(23);	
						if(str_preappr_yn==null) str_preappr_yn="";								
						d_pat_paid_amt=call.getDouble(24);	
						d_pat_paid_amt_temp=String.valueOf(d_pat_payable);
						cf1 = new CurrencyFormat();
						if(d_pat_paid_amt==0) d_pat_paid_amt_temp="0.00";
						if (d_pat_paid_amt!=0) d_pat_paid_amt_temp = cf1.formatCurrency(d_pat_paid_amt_temp,noofdecimal);
				
						str_charged_yn = call.getString(25);
						if(str_charged_yn==null) str_charged_yn="";	
						str_pat_billed_yn = call.getString(26);
						if(str_pat_billed_yn==null) str_pat_billed_yn="";	

				
						str_error_code = call.getString(27);
						if(str_error_code==null) str_error_code="";								
						str_sys_message_id = call.getString(28);
						if(str_sys_message_id==null) str_sys_message_id="";						
						str_error_text = call.getString(29);	
						if(str_error_text==null) str_error_text="";				
						
						call.close();		
					}
				}
				catch(Exception e )
				{ 
					out.println("incl excl error2"+e);
					System.out.println("incl excl  error2"+e);
				}
				
				if (str_error_code.equals("10") || !str_error_text.equals("") || !str_sys_message_id.equals(""))
				{
					if(!cald_frm.equals("direct_ser_req"))
						{					
%>
					<script> 
						parent.frames[0].document.forms[0].accept_button.disabled=true;				
					</script>
<%
						}
					if (str_error_code.equals("10") && !str_error_text.equals(""))
					{
%>
						<script>	
							var strErrorMessage = '<%=str_error_text%>';
							alert(strErrorMessage);
						</script>
<%
					}
					if(str_sys_message_id!="")
					{
%>
						 <script>
							 alert(getMessage('<%=str_sys_message_id%>','BL'));
						</script>
<%
					}
				}
				else{
					if(cald_frm.equals("direct_ser_req"))
						{
						if(p_rate_charge_ind.equals("C"))
							{
						%>
						
<script>
								var rate=eval('parent.frames[0].document.forms[0].charges_'+<%=sel_rec%>);
								rate.value="<%=d_serv_amt_temp%>";

								var hid_charges=eval('parent.frames[0].document.forms[0].hid_charges_'+<%=sel_rec%>);
								hid_charges.value="<%=d_serv_amt_temp%>";

							<%
							}
							if(p_rate_charge_ind.equals("R"))
							{
							%>
								var rate=eval('parent.frames[0].document.getElementById('charges_')'+<%=sel_rec%>);
								rate.innerText="<%=d_serv_amt_temp%>";

								var hid_charges=eval('parent.frames[0].document.forms[0].hid_charges_'+<%=sel_rec%>);
								hid_charges.value="<%=d_serv_amt_temp%>";

							<%
							}
							%>


//								parent.frames[0].document.forms[0].rate.value="<%=d_serv_amt_temp%>";	 

								var patient_pay=eval('parent.frames[0].document.getElementById('patient_payable_')'+<%=sel_rec%>);
								patient_pay.innerText="<%=d_pat_payable_temp%>";
//								parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";	 
								
								var patient_paid=eval('parent.frames[0].document.getElementById('patient_paid_')'+<%=sel_rec%>);
								patient_paid.innerText="<%=d_pat_paid_amt_temp%>";
//								parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	  

								var charged_YN=eval('parent.frames[0].document.forms[0].charged_YN'+<%=sel_rec%>);
								charged_YN.value="<%=str_charged_yn%>";

//								parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";
								var incl_excl_act_reason=eval('parent.frames[0].document.forms[0].incl_excl_action_reason_'+<%=sel_rec%>);
								incl_excl_act_reason.focus();
							</script>
<%									
							if (str_preappr_yn.equals("Y"))
							{
%>
								<script>
									var preappr_reqd=eval('parent.frames[0].document.forms[0].preappr_reqd_'+<%=sel_rec%>);
									preappr_reqd.checked=true;
//									parent.frames[0].document.forms[0].preappr_reqd.checked=true;
								</script>

<%
							}
%>
							<script>
							parent.frames[1].totalCharges();
								parent.frames[0].callUpdateBean(<%=sel_rec%>);
							</script>
<%


				}
				else
				{ 
%>	  
					<script>	
						parent.frames[0].document.forms[0].accept_button.disabled=false;
						parent.frames[0].document.forms[0].rate.value="<%=str_base_amt%>"; 
						parent.frames[0].document.forms[0].patient_pay.value="<%=d_pat_payable_temp%>";
						parent.frames[0].document.forms[0].total_pay.value="<%=d_serv_amt_temp%>";
						parent.frames[0].document.forms[0].patient_paid.value="<%=d_pat_paid_amt_temp%>";	
						parent.frames[0].document.forms[0].charged_yn.value="<%=str_charged_yn%>";					

						parent.frames[0].document.forms[0].serv_amt_changed.value="<%=str_base_amt%>";

					//	parent.frames[0].document.forms[0].excl_incl_ind_for_screen.value="<%=str_excl_incl_ind%>";



						
					</script>
<%
						
					if (str_preappr_yn.equals("Y"))
					{
%>
						<script>
							parent.frames[0].document.forms[0].preappr_reqd.checked=true;
						</script>
	 
<%
					}
				}
				}
			}
		}
%>
<script>
	
function calc_charg_for_rate_bsd_serv()
{ 
	 
	 if(document.forms[0].rate_chr_ind_on_serv_add.value == 'R')
	{
		
		parent.frames[0].revqyt('Y');
	}

	if(document.forms[0].rate_chr_ind_on_serv_add.value == 'C')
	{
	
	var max_chg_amt="<%=max_chg_amt%>";
		parent.frames[0].document.forms[0].serv_amt_changed.value="";
		//var max_chg_amt='<%=max_chg_amt%>';
		parent.frames[0].rateval('Y',max_chg_amt);		
	}
}


	

</script>
<body onLoad='calc_charg_for_rate_bsd_serv();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<INPUT TYPE="hidden" name='rate_chr_ind_on_serv_add' id='rate_chr_ind_on_serv_add' value="<%=str_rate_chr_ind%>">
</form>
</body>

<%
	
	}
	catch(Exception e)
	{
		out.println("Main Exception in ChargeDetailsValidation.jsp:"+e);
	}
	finally
		{	
			if(pstmt != null)		pstmt.close();
			ConnectionManager.returnConnection(con, request);
		}
%>

