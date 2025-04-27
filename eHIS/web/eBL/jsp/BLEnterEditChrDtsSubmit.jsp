<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations for OR Logic Implementation start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<%
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");	
	request.setCharacterEncoding("UTF-8");
	String episode_id="";
	String episode_type="";
	String patient_id="";
	String visit_id="";

	String str_panel="";
	String accept_chk="";
	String service_panel_ind="";
	String p_module_id="";

	String incl_excl_action_code_to_or="";
	String action_reason_code_to_or="";
	String total_payable_to_or="";
	String patient_payable_to_or="";
	String total_paid_to_or="";
	//String str_override_yn="";

	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="";
	String str_or_key_line_no="",excl_incl_ind_for_screen="";
	String rate_temp="";

	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	//String bean_name_bl="";
	/******end*******************/

	String mod_pract_ind="", mod_physician_id="";
	
	HashMap bill_dtls_to_or_bean = null;

	try
	{
		episode_type=request.getParameter("h_episode_type");
		episode_id=request.getParameter("h_episode_id");
		patient_id=request.getParameter("h_patient_id");
		visit_id=request.getParameter("h_visit_id");

		service_panel_ind=request.getParameter("service_panel_ind");
		if(service_panel_ind==null )service_panel_ind="";

		p_module_id=(String)request.getParameter("h_module_id");
		if(p_module_id==null) p_module_id="";

		String str_panel_hdr =request.getParameter("p_str");
		String str_panel_body =request.getParameter("p_str1");

		str_or_bean_id=request.getParameter("str_or_bean_id");
		if(str_or_bean_id==null) str_or_bean_id="";

		str_or_key=request.getParameter("str_or_key");
		if(str_or_key==null) str_or_key="";
		
		str_or_key_line_no=request.getParameter("str_or_key_line_no");
		if(str_or_key_line_no==null || str_or_key_line_no.equals("")) str_or_key_line_no="";

		if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
		{
			str_or_key=str_or_key+str_or_key_line_no;
		}

		incl_excl_action_code_to_or=request.getParameter("incl_excl_action_code_to_or");
		if(incl_excl_action_code_to_or==null) incl_excl_action_code_to_or="";

		action_reason_code_to_or=request.getParameter("action_reason_code_to_or");
		if(action_reason_code_to_or==null) action_reason_code_to_or="";

		total_payable_to_or=request.getParameter("total");
		if(total_payable_to_or == null) total_payable_to_or="";

		patient_payable_to_or=request.getParameter("patient");
		if(patient_payable_to_or == null) patient_payable_to_or="";

		total_paid_to_or=request.getParameter("patient_paid");
		if(total_paid_to_or == null) total_paid_to_or="";

		rate_temp=request.getParameter("rate_temp");
		if(rate_temp == null) rate_temp="";	

		excl_incl_ind_for_screen=request.getParameter("excl_incl_ind_for_screen");
		if(excl_incl_ind_for_screen == null) excl_incl_ind_for_screen="";	

		mod_pract_ind = request.getParameter("mod_pract_ind");
		if(mod_pract_ind == null) mod_pract_ind="";	

		mod_physician_id = request.getParameter("mod_physician_id");
		if(mod_physician_id == null) mod_physician_id="";	
			
		
		if(service_panel_ind.equals("L"))
		{
			str_panel=str_panel_hdr+str_panel_body;
		}
		else if(service_panel_ind.equals("S"))
		{
			str_panel=str_panel_hdr+str_panel_body;
		}
		accept_chk=request.getParameter("accept_chk");

  
		
		//pString.put("episode_type",episode_type);
		//pString.put("episode_id",episode_id);
		//pString.put("patient_id",patient_id);
		//pString.put("visit_id",visit_id);	
		//pString.put("accept_chk",accept_chk);

		 calledfrmencYN = request.getParameter("calledfrmencYN");
		 if(calledfrmencYN == null || calledfrmencYN.equals("")) calledfrmencYN="N";
		 bean_id_bl=request.getParameter("bean_id_bl");
		 if(bean_id_bl == null || bean_id_bl.equals("")) bean_id_bl="N";


	
		if(p_module_id.equals("OP") || p_module_id.equals("AE") || (p_module_id.equals("MP") && calledfrmencYN.equals("N")))
		{
//			System.err.println("Inside IF of Submit Charge Dtls");
			HashMap pString = new HashMap();
			pString.put("panel_str",str_panel);
			session.setAttribute("BlChargeRecord",(HashMap)pString);
		}/*
		else if(p_module_id.equals("BL"))
		{

			bill_dtls_to_or_bean= null;

			BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;

			if(!str_or_bean_id.equals(""))
			{
				bill_dtls_to_or_bean=(HashMap)ServPanlBean.getSelectedServPanlDtls(str_or_key);

				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);
	

				bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
				bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
				bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
						
				ServPanlBean.setSelectedServPanlDtls(str_or_key, bill_dtls_to_or_bean); 
			}
		}*/
		else if(calledfrmencYN.equals("Y") && p_module_id.equals("MP") ) {
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, "eBL.BLPatRegChargesBean", request ) ;
			if(bean!=null)
			{
				bean.setPanelString(str_panel);		
				if(service_panel_ind.equals("S"))
				{
								
					bean.setTotPay(total_payable_to_or);
					bean.setTotPatPay(patient_payable_to_or);
				}
			}		
		}
		else
		{

			bill_dtls_to_or_bean= null;

/*			bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
			bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
			bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);  // which we will pass it to your Billing routine before recording the Order
*/

			OrderEntryBillingQueryBean orderEntryBillBean = null;
			FutureOrder	FutureBeanObj  = null;
			OrderEntryBean	beanObj  = null;
			if(!str_or_bean_id.equals(""))
			{

				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					FutureBeanObj  = (FutureOrder)getBeanObject( str_or_bean_id, "eOR.FutureOrder", request ) ;
					orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) FutureBeanObj.getOrderEntryBillBean();
				}
				else
				{
					beanObj  = (OrderEntryBean)getBeanObject( str_or_bean_id, "eOR.OrderEntryBean", request ) ;
					orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
				bill_dtls_to_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);
				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);
				

				if(service_panel_ind.equals("S"))
				{
								
					bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
					bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
					bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
					bill_dtls_to_or_bean.put("rate" , rate_temp);
					bill_dtls_to_or_bean.put("excl_incl_ind_for_screen" , excl_incl_ind_for_screen);
					bill_dtls_to_or_bean.put("mod_pract_ind",mod_pract_ind);
					bill_dtls_to_or_bean.put("mod_physician_id" , mod_physician_id);

				}
				
				
				orderEntryBillBean.setOrderBillDtls(str_or_key, bill_dtls_to_or_bean); 


				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					putObjectInBean(str_or_bean_id,FutureBeanObj,request); // set it back in persistence
				}
				else
				{
					putObjectInBean(str_or_bean_id,beanObj,request); // set it back in persistence
				}
			}
			else
			{
				orderEntryBillBean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
				bill_dtls_to_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);
				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);

				if(service_panel_ind.equals("S"))
				{
					bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
					bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
					bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
					bill_dtls_to_or_bean.put("rate" , rate_temp);
					bill_dtls_to_or_bean.put("excl_incl_ind_for_screen" , excl_incl_ind_for_screen);
					bill_dtls_to_or_bean.put("mod_pract_ind",mod_pract_ind);
					bill_dtls_to_or_bean.put("mod_physician_id" , mod_physician_id);

				}


				orderEntryBillBean.setOrderBillDtls(str_or_key, bill_dtls_to_or_bean); 

				putObjectInBean("Or_billingQueryBean",orderEntryBillBean,request);
			}
		}
		session.setAttribute("acc_flag","true");
/*
		session.setAttribute("episode_type",episode_type);
		session.setAttribute("episode_id",episode_id);
		session.setAttribute("patient_id",patient_id);
		session.setAttribute("visit_id",visit_id);
*/
%>

<html>

<script>
	
	//parent.window.close();
	parent.parent.document.getElementById('dialog_tag').close();

</script>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in Main:"+e);
	}
%>	
</html>
